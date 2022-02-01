package com.tencent.scanlib.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a
  implements f
{
  protected Point MlK = null;
  protected float MlL = 1.0F;
  protected int MlM = -1;
  protected int MlN;
  protected int MlO;
  protected volatile boolean Vp = false;
  protected Camera gdk;
  protected int mMaxZoom;
  protected volatile boolean rqh = false;
  protected Point rqi = null;
  protected Point rqj = null;
  protected boolean rqk;
  protected int rql;
  protected boolean rqm = false;
  protected boolean vZT = false;
  
  public static int D(List<Integer> paramList, int paramInt)
  {
    AppMethodBeat.i(3521);
    int i;
    if ((paramList != null) && (paramList.size() > 0))
    {
      Log.i("BaseScanCamera", String.format("zoomRatios: %s,size: %d", new Object[] { paramList, Integer.valueOf(paramList.size()) }));
      i = Collections.binarySearch(paramList, Integer.valueOf(paramInt));
      Log.i("BaseScanCamera", "insert index: ".concat(String.valueOf(i)));
      if (i >= 0) {
        paramInt = i;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(3521);
      return paramInt;
      i = -(i + 1);
      int j = i - 1;
      if ((i >= 0) && (i <= paramList.size() - 1) && (j >= 0) && (j <= paramList.size() - 1))
      {
        if (((Integer)paramList.get(i)).intValue() - paramInt > paramInt - ((Integer)paramList.get(j)).intValue()) {
          paramInt = j;
        } else {
          paramInt = i;
        }
      }
      else if ((i >= 0) && (i <= paramList.size() - 1)) {
        paramInt = i;
      } else if ((j >= 0) && (j <= paramList.size() - 1)) {
        paramInt = j;
      } else {
        paramInt = 0;
      }
    }
  }
  
  private Point b(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(3520);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new a.a((byte)0));
    ((List)localObject).remove(0);
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    Log.d("BaseScanCamera", String.format("visible.x: %d, visible.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) }));
    Log.i("BaseScanCamera", String.format("SCREEN_PIXELS: %s", new Object[] { Integer.valueOf(paramPoint.x * paramPoint.y) }));
    float f1 = (1.0F / 1.0F);
    localObject = ((List)localObject).iterator();
    int k;
    int m;
    label322:
    label334:
    float f2;
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
      k = localSize.width;
      m = localSize.height;
      Log.i("BaseScanCamera", String.format("realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) }));
      int i;
      if (!this.rqk)
      {
        i = k;
        if (this.rqk) {
          break label322;
        }
      }
      for (int j = m;; j = Math.max(k, m))
      {
        Log.d("BaseScanCamera", String.format("maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        if ((i != paramPoint.x) || (j != paramPoint.y)) {
          break label334;
        }
        paramParameters = new Point(k, m);
        Log.i("BaseScanCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
        AppMethodBeat.o(3520);
        return paramParameters;
        i = Math.min(k, m);
        break;
      }
      if (k * m >= 307200)
      {
        f2 = Math.abs(i / j - f3);
        if (f2 >= f1) {
          break label495;
        }
        localPoint = new Point(k, m);
        f1 = f2;
      }
    }
    label495:
    for (;;)
    {
      Log.i("BaseScanCamera", String.format("diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(k), Integer.valueOf(m) }));
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        Log.i("BaseScanCamera", "No suitable preview sizes, using default: ".concat(String.valueOf(paramPoint)));
      }
      Log.i("BaseScanCamera", "Found best approximate preview size: ".concat(String.valueOf(paramPoint)));
      AppMethodBeat.o(3520);
      return paramPoint;
    }
  }
  
  private void fYN()
  {
    AppMethodBeat.i(3530);
    try
    {
      Log.i("BaseScanCamera", "set scan focus");
      List localList = this.gdk.getParameters().getSupportedFocusModes();
      if (localList == null) {
        break label188;
      }
      Log.i("BaseScanCamera", "supported focus modes size = " + localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        Log.i("BaseScanCamera", "supported focus modes : ".concat(String.valueOf((String)localIterator.next())));
      }
      if (!localException.contains("continuous-video")) {
        break label161;
      }
    }
    catch (Exception localException)
    {
      Log.e("BaseScanCamera", "setScanFocus error: " + localException.getMessage());
      AppMethodBeat.o(3530);
      return;
    }
    Log.d("BaseScanCamera", "camera support continuous video focus");
    setFocusMode("continuous-video");
    AppMethodBeat.o(3530);
    return;
    label161:
    if (localException.contains("auto"))
    {
      Log.d("BaseScanCamera", "camera support auto focus");
      setFocusMode("auto");
    }
    label188:
    AppMethodBeat.o(3530);
  }
  
  private Point l(Point paramPoint)
  {
    AppMethodBeat.i(3515);
    int j = (this.MlK.x - this.rqj.x) / 2;
    int i = (this.MlK.y - this.rqj.y) / 2;
    Point localPoint1 = new Point(paramPoint.x + j, paramPoint.y + i);
    if (this.rqk)
    {
      j = (this.MlK.y - this.rqj.x) / 2;
      i = (this.MlK.x - this.rqj.y) / 2;
      localPoint1 = new Point(paramPoint.y + i, this.rqj.x - paramPoint.x + j);
    }
    Log.d("BaseScanCamera", String.format("dx %d, dy %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }));
    Point localPoint2 = new Point((int)(localPoint1.x / this.MlL), (int)(localPoint1.y / this.MlL));
    Log.i("BaseScanCamera", "viewPoint " + paramPoint + ", previewPoint " + localPoint1 + ", scanPoint " + localPoint2);
    AppMethodBeat.o(3515);
    return localPoint2;
  }
  
  private Point n(Point paramPoint)
  {
    AppMethodBeat.i(3518);
    Camera.Parameters localParameters = this.gdk.getParameters();
    Object localObject = localParameters.get("preview-size-values");
    if (localObject == null) {
      localObject = localParameters.get("preview-size-value");
    }
    for (;;)
    {
      Point localPoint = null;
      if (localObject != null)
      {
        Log.d("BaseScanCamera", "preview-size-values parameter: ".concat(String.valueOf(localObject)));
        localPoint = b(localParameters, paramPoint);
      }
      localObject = localPoint;
      if (localPoint == null) {
        localObject = new Point(paramPoint.x >> 3 << 3, paramPoint.y >> 3 << 3);
      }
      AppMethodBeat.o(3518);
      return localObject;
    }
  }
  
  private Point o(Point paramPoint)
  {
    AppMethodBeat.i(3519);
    float f2;
    if (this.rqk) {
      f2 = this.rqj.x * 1.0F / paramPoint.y;
    }
    for (float f1 = this.rqj.y * 1.0F / paramPoint.x;; f1 = this.rqj.y * 1.0F / paramPoint.y)
    {
      this.MlL = Math.max(f2, f1);
      paramPoint = new Point((int)(paramPoint.x * this.MlL), (int)(paramPoint.y * this.MlL));
      AppMethodBeat.o(3519);
      return paramPoint;
      f2 = this.rqj.x * 1.0F / paramPoint.x;
    }
  }
  
  public final void a(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(3512);
    if (this.gdk != null) {
      try
      {
        this.gdk.setOneShotPreviewCallback(paramPreviewCallback);
        AppMethodBeat.o(3512);
        return;
      }
      catch (RuntimeException paramPreviewCallback)
      {
        Log.w("BaseScanCamera", "takeOneShot() " + paramPreviewCallback.getMessage());
      }
    }
    AppMethodBeat.o(3512);
  }
  
  public final void ahq(int paramInt)
  {
    AppMethodBeat.i(3513);
    if (this.Vp)
    {
      Log.w("BaseScanCamera", "in open(), is open already");
      AppMethodBeat.o(3513);
      return;
    }
    int j = Camera.getNumberOfCameras();
    Object localObject1 = new Camera.CameraInfo();
    int i = 0;
    if (i < j)
    {
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject1);
      if (((Camera.CameraInfo)localObject1).facing == 0) {
        Log.d("ScanCameraUtil", String.format("cam get bid %d", new Object[] { Integer.valueOf(i) }));
      }
    }
    for (;;)
    {
      Log.d("ScanCameraUtil", String.format("cam getBackCameraId %d", new Object[] { Integer.valueOf(i) }));
      long l = System.currentTimeMillis();
      if (Build.MODEL.equals("M9")) {
        new e();
      }
      for (localObject1 = e.fYP();; localObject1 = d.kV(i, paramInt))
      {
        if (localObject1 != null) {
          break label199;
        }
        Log.e("BaseScanCamera", "in open(), openCameraRes == null");
        AppMethodBeat.o(3513);
        return;
        i += 1;
        break;
        Log.d("ScanCameraUtil", "openCamera(), CameraUtilImplAPI9, cameraId = ".concat(String.valueOf(i)));
        new d();
      }
      label199:
      this.vZT = false;
      this.MlM = -1;
      this.rql = ((g.a.a)localObject1).dHi;
      if (((g.a.a)localObject1).dHi % 180 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.rqk = bool;
        Log.d("BaseScanCamera", String.format("openCamera done, cameraId=[%s] costTime=[%s] rotation[%d]", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(this.rql) }));
        this.gdk = ((g.a.a)localObject1).gdk;
        if (this.gdk != null) {
          break;
        }
        Log.e("BaseScanCamera", "in open(), camera == null, bNeedRotate " + this.rqk);
        AppMethodBeat.o(3513);
        return;
      }
      this.Vp = true;
      localObject1 = this.gdk.getParameters();
      for (;;)
      {
        try
        {
          if (this.gdk != null)
          {
            localObject2 = ((Camera.Parameters)localObject1).get("zoom-supported");
            if ((!com.tencent.scanlib.a.isNullOrNil((String)localObject2)) && (Boolean.parseBoolean((String)localObject2))) {
              continue;
            }
            Log.i("BaseScanCamera", "not support zoom");
          }
        }
        catch (Exception localException2)
        {
          Object localObject2;
          Log.e("BaseScanCamera", "init zoom exception! " + localException2.getMessage());
          continue;
          if (((Integer)localException2.get(this.mMaxZoom)).intValue() <= 400) {
            continue;
          }
          this.mMaxZoom = D(localException2, 400);
          continue;
          paramInt = j;
          if (!localException2.contains(Integer.valueOf(842094169))) {
            continue;
          }
          i = 1;
          paramInt = j;
          continue;
          if (i == 0) {
            continue;
          }
          Log.i("BaseScanCamera", "Preview not support NV21, but support YV12");
          ((Camera.Parameters)localObject1).setPreviewFormat(842094169);
          continue;
          Log.i("BaseScanCamera", "Preview not support NV21 and YV12. Use format: " + localException2.get(0));
          ((Camera.Parameters)localObject1).setPreviewFormat(((Integer)localException2.get(0)).intValue());
          continue;
        }
        j = 0;
        i = 0;
        localObject2 = ((Camera.Parameters)localObject1).getSupportedPreviewFormats();
        Log.i("BaseScanCamera", "supportedPreviewFormat:".concat(String.valueOf(localObject2)));
        if (!((List)localObject2).contains(Integer.valueOf(17))) {
          continue;
        }
        paramInt = 1;
        if (paramInt == 0) {
          continue;
        }
        Log.i("BaseScanCamera", "Preview support NV21");
        ((Camera.Parameters)localObject1).setPreviewFormat(17);
        this.gdk.setParameters((Camera.Parameters)localObject1);
        try
        {
          fYN();
          AppMethodBeat.o(3513);
          return;
        }
        catch (Exception localException1)
        {
          Log.e("BaseScanCamera", "set focus mode error: " + localException1.getMessage());
          AppMethodBeat.o(3513);
          return;
        }
        localObject2 = ((Camera.Parameters)localObject1).getZoomRatios();
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          this.MlO = 0;
          this.mMaxZoom = ((int)(((List)localObject2).size() / 1.5D));
          Log.d("BaseScanCamera", String.format("divideRatio: %f,max zoom: %d", new Object[] { Double.valueOf(1.5D), Integer.valueOf(this.mMaxZoom) }));
          if (this.mMaxZoom >= this.MlO) {
            continue;
          }
          this.mMaxZoom = this.MlO;
          Log.i("BaseScanCamera", String.format("default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", new Object[] { Integer.valueOf(this.MlO), ((List)localObject2).get(this.MlO), Integer.valueOf(this.mMaxZoom), ((List)localObject2).get(this.mMaxZoom) }));
        }
      }
      i = 0;
    }
  }
  
  public final void ahr(int paramInt)
  {
    AppMethodBeat.i(3522);
    if ((this.gdk != null) && (this.rqh) && (paramInt > 0)) {
      try
      {
        Camera.Parameters localParameters = this.gdk.getParameters();
        List localList = localParameters.getZoomRatios();
        int i;
        if (localList != null)
        {
          i = localList.size();
          if (i > 0) {}
        }
        else
        {
          AppMethodBeat.o(3522);
          return;
        }
        Log.d("BaseScanCamera", String.format("zoom to ratio:%d", new Object[] { Integer.valueOf(paramInt) }));
        if ((paramInt >= ((Integer)localList.get(this.MlO)).intValue()) && (paramInt <= ((Integer)localList.get(this.mMaxZoom)).intValue())) {
          paramInt = D(localList, paramInt);
        }
        for (;;)
        {
          Log.i("BaseScanCamera", String.format("zoom:%d,ratio:%d", new Object[] { Integer.valueOf(paramInt), localList.get(paramInt) }));
          this.MlN = paramInt;
          localParameters.setZoom(paramInt);
          this.gdk.setParameters(localParameters);
          AppMethodBeat.o(3522);
          return;
          if (paramInt < ((Integer)localList.get(this.MlO)).intValue())
          {
            paramInt = this.MlO;
          }
          else
          {
            Log.i("BaseScanCamera", "exceed max zoom");
            i = this.MlN + (this.mMaxZoom - this.MlN) / 5;
            paramInt = i;
            if (i > this.mMaxZoom) {
              paramInt = this.mMaxZoom;
            }
          }
        }
        AppMethodBeat.o(3522);
      }
      catch (Exception localException)
      {
        Log.e("BaseScanCamera", "zoom scale exception:" + localException.getMessage());
      }
    }
  }
  
  public final void ahs(int paramInt)
  {
    AppMethodBeat.i(3523);
    if ((this.gdk != null) && (this.rqh)) {}
    for (;;)
    {
      int i;
      try
      {
        Camera.Parameters localParameters = this.gdk.getParameters();
        List localList = localParameters.getZoomRatios();
        if (localList != null)
        {
          i = localList.size();
          if (i > 0) {}
        }
        else
        {
          AppMethodBeat.o(3523);
          return;
        }
        Log.i("BaseScanCamera", String.format("zoom action:%d,beforeZoom:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localParameters.getZoom()) }));
        switch (paramInt)
        {
        case 0: 
          localParameters.setZoom(this.MlN);
          this.gdk.setParameters(localParameters);
          Log.i("BaseScanCamera", String.format("zoom action:%d,afterZoom:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localParameters.getZoom()) }));
          AppMethodBeat.o(3523);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.e("BaseScanCamera", "zoom action exception:" + localException.getMessage());
      }
      this.MlN = 0;
      continue;
      AppMethodBeat.o(3523);
      return;
      this.MlN = this.MlO;
      continue;
      if (this.MlN < this.mMaxZoom)
      {
        this.MlN += 1;
        if (this.MlN > this.mMaxZoom) {}
        for (i = this.mMaxZoom;; i = this.MlN)
        {
          this.MlN = i;
          break;
        }
        if (this.MlN > this.MlO)
        {
          this.MlN -= 1;
          if (this.MlN < this.MlO) {}
          for (i = this.MlO;; i = this.MlN)
          {
            this.MlN = i;
            break;
          }
          this.MlN = this.mMaxZoom;
          continue;
          if (this.MlN != this.MlO) {
            this.MlN = this.MlO;
          } else {
            this.MlN = this.mMaxZoom;
          }
        }
      }
    }
  }
  
  public final void autoFocus(Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    AppMethodBeat.i(3525);
    if ((this.gdk != null) && (this.rqh)) {
      try
      {
        this.gdk.autoFocus(paramAutoFocusCallback);
        AppMethodBeat.o(3525);
        return;
      }
      catch (Exception paramAutoFocusCallback)
      {
        Log.w("BaseScanCamera", "autoFocus() " + paramAutoFocusCallback.getMessage());
      }
    }
    AppMethodBeat.o(3525);
  }
  
  public final boolean cOB()
  {
    return this.rqh;
  }
  
  public final void cancelAutoFocus()
  {
    AppMethodBeat.i(3526);
    try
    {
      if (this.gdk != null) {
        this.gdk.cancelAutoFocus();
      }
      AppMethodBeat.o(3526);
      return;
    }
    catch (Exception localException)
    {
      Log.w("BaseScanCamera", "cancelAutoFocus " + localException.getMessage());
      AppMethodBeat.o(3526);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(3514);
    Log.i("BaseScanCamera", "close(), previewing " + this.rqh);
    if (this.gdk != null)
    {
      this.Vp = false;
      long l = System.currentTimeMillis();
      this.gdk.setPreviewCallback(null);
      this.gdk.stopPreview();
      this.rqh = false;
      Log.i("BaseScanCamera", "stopPreview costTime " + (System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
      this.gdk.release();
      this.gdk = null;
      Log.i("BaseScanCamera", "camera.close() costTime " + (System.currentTimeMillis() - l));
    }
    this.vZT = false;
    this.rqm = false;
    this.MlM = -1;
    this.rqk = false;
    AppMethodBeat.o(3514);
  }
  
  public final boolean dPp()
  {
    AppMethodBeat.i(3527);
    boolean bool = "auto".equals(getFocusMode());
    AppMethodBeat.o(3527);
    return bool;
  }
  
  public final boolean fYI()
  {
    return this.rqk;
  }
  
  public final Point fYJ()
  {
    return this.rqi;
  }
  
  public final Point fYK()
  {
    return this.MlK;
  }
  
  public final float fYL()
  {
    return this.MlL;
  }
  
  public final int fYM()
  {
    AppMethodBeat.i(3524);
    if ((this.gdk != null) && (this.gdk.getParameters() != null) && (this.gdk.getParameters().getZoomRatios() != null) && (this.gdk.getParameters().getZoomRatios().size() > 0))
    {
      int i = ((Integer)this.gdk.getParameters().getZoomRatios().get(this.MlN)).intValue();
      AppMethodBeat.o(3524);
      return i;
    }
    AppMethodBeat.o(3524);
    return 100;
  }
  
  public final int getCameraRotation()
  {
    return this.rql;
  }
  
  public final String getFocusMode()
  {
    AppMethodBeat.i(3528);
    try
    {
      if (this.gdk != null)
      {
        String str = this.gdk.getParameters().getFocusMode();
        AppMethodBeat.o(3528);
        return str;
      }
    }
    catch (Exception localException)
    {
      Log.w("BaseScanCamera", "getFocusMode() " + localException.getMessage());
      AppMethodBeat.o(3528);
    }
    return "";
  }
  
  public final boolean isOpen()
  {
    return this.Vp;
  }
  
  public final void m(Point paramPoint)
  {
    AppMethodBeat.i(3517);
    this.rqj = new Point(paramPoint);
    Log.d("BaseScanCamera", "set visible resolution: " + this.rqj);
    try
    {
      this.rqi = n(this.rqj);
      this.MlK = o(this.rqi);
      AppMethodBeat.o(3517);
      return;
    }
    catch (Exception paramPoint)
    {
      Log.e("BaseScanCamera", "set preview size" + paramPoint.getMessage());
      AppMethodBeat.o(3517);
    }
  }
  
  public final void p(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(3510);
    long l = System.currentTimeMillis();
    if ((this.gdk != null) && (!this.rqh))
    {
      if (paramSurfaceTexture != null) {
        this.gdk.setPreviewTexture(paramSurfaceTexture);
      }
      if (this.rqi == null)
      {
        this.rqi = n(this.rqj);
        this.MlK = o(this.rqi);
      }
      paramSurfaceTexture = this.gdk.getParameters();
      paramSurfaceTexture.setPreviewSize(this.rqi.x, this.rqi.y);
      this.gdk.setParameters(paramSurfaceTexture);
      this.gdk.startPreview();
      this.rqh = true;
      Log.d("BaseScanCamera", String.format("startPreview done costTime=[%s]", new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - l)) }));
    }
    AppMethodBeat.o(3510);
  }
  
  public final Rect r(Rect paramRect)
  {
    AppMethodBeat.i(3516);
    Rect localRect = new Rect();
    Log.i("BaseScanCamera", String.format("visibleResolution:%s, previewResolution:%s", new Object[] { this.rqj, this.MlK }));
    Point localPoint2;
    if (this.rqk)
    {
      localPoint1 = new Point(paramRect.right, paramRect.top);
      localPoint2 = l(localPoint1);
      if (!this.rqk) {
        break label174;
      }
    }
    label174:
    for (Point localPoint1 = new Point(paramRect.left, paramRect.bottom);; localPoint1 = new Point(paramRect.right, paramRect.bottom))
    {
      localPoint1 = l(localPoint1);
      localRect.set(localPoint2.x, localPoint2.y, localPoint1.x, localPoint1.y);
      Log.i("BaseScanCamera", String.format("uiRect %s, scanRect %s", new Object[] { paramRect, localRect }));
      AppMethodBeat.o(3516);
      return localRect;
      localPoint1 = new Point(paramRect.left, paramRect.top);
      break;
    }
  }
  
  public final void setFocusMode(String paramString)
  {
    AppMethodBeat.i(3529);
    try
    {
      if (this.gdk != null)
      {
        Camera.Parameters localParameters = this.gdk.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains(paramString)))
        {
          localParameters.setFocusMode(paramString);
          this.gdk.setParameters(localParameters);
        }
      }
      AppMethodBeat.o(3529);
      return;
    }
    catch (Exception paramString)
    {
      Log.w("BaseScanCamera", "setFocusMode " + paramString.getMessage());
      AppMethodBeat.o(3529);
    }
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(3511);
    if (this.gdk != null)
    {
      this.gdk.stopPreview();
      this.rqh = false;
    }
    AppMethodBeat.o(3511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.scanlib.a.a
 * JD-Core Version:    0.7.0.1
 */