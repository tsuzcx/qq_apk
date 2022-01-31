package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.ak;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class h
{
  private static final Pattern nOW = Pattern.compile(",");
  private Activity bMV;
  public Camera dwJ;
  private int goj = 0;
  public Rect jLf;
  public boolean jOC = false;
  public Point jOD = null;
  private Point jOE = null;
  public Point jOF = null;
  public boolean jOG;
  public int jOH;
  private boolean jOI = false;
  public boolean mgM = false;
  public boolean nOX;
  private Rect nOY;
  private Rect nOZ;
  public int nPa = -1;
  private String nPb = "";
  private int nPc;
  private int nPd;
  private int nPe;
  
  public h(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    this.bMV = paramActivity;
    this.jOE = ak.gx(paramActivity);
    this.nOX = paramBoolean;
    this.goj = paramInt;
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint, boolean paramBoolean)
  {
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new a((byte)0));
    ((List)localObject).remove(0);
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    y.d("MicroMsg.scanner.ScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    int n = paramPoint.x * paramPoint.y;
    y.i("MicroMsg.scanner.ScanCamera", "SCREEN_PIXELS: %s, MAX_PREVIEW_PIXELS_USE_BIGGER: %s", new Object[] { Integer.valueOf(n), Integer.valueOf(2073600) });
    float f1 = (1.0F / 1.0F);
    localObject = ((List)localObject).iterator();
    int i;
    int j;
    label271:
    label370:
    label377:
    float f2;
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
      i = localSize.width;
      j = localSize.height;
      y.i("MicroMsg.scanner.ScanCamera", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      int k = i * j;
      if ((k >= 150400) && (k <= 2073600) && ((k <= n) || (Math.min(paramPoint.x, paramPoint.y) < 720)))
      {
        if (i > j)
        {
          m = 1;
          if ((m == 0) || (paramBoolean)) {
            break label370;
          }
          k = j;
          if ((m == 0) || (paramBoolean)) {
            break label377;
          }
        }
        for (int m = i;; m = j)
        {
          y.d("MicroMsg.scanner.ScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y)) {
            break label384;
          }
          paramParameters = new Point(i, j);
          y.i("MicroMsg.scanner.ScanCamera", "Found preview size exactly matching screen size: " + paramParameters);
          return paramParameters;
          m = 0;
          break;
          k = i;
          break label271;
        }
        label384:
        f2 = Math.abs(k / m - f3);
        if (f2 >= f1) {
          break label540;
        }
        localPoint = new Point(i, j);
        f1 = f2;
      }
    }
    label540:
    for (;;)
    {
      y.i("MicroMsg.scanner.ScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        y.i("MicroMsg.scanner.ScanCamera", "No suitable preview sizes, using default: " + paramPoint);
      }
      y.i("MicroMsg.scanner.ScanCamera", "Found best approximate preview size: " + paramPoint);
      return paramPoint;
    }
  }
  
  private static void d(Camera.Parameters paramParameters)
  {
    List localList;
    try
    {
      y.i("MicroMsg.scanner.ScanCamera", "set scan focus");
      localList = paramParameters.getSupportedFocusModes();
      if (localList != null)
      {
        y.i("MicroMsg.scanner.ScanCamera", "supported focus modes size = " + localList.size());
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          y.i("MicroMsg.scanner.ScanCamera", "supported focus modes : " + str);
        }
      }
      return;
    }
    catch (Exception paramParameters)
    {
      y.e("MicroMsg.scanner.ScanCamera", "setScanFocus error: %s", new Object[] { paramParameters.getMessage() });
    }
    do
    {
      if (localList.contains("continuous-video"))
      {
        y.d("MicroMsg.scanner.ScanCamera", "camera support continuous video focus");
        paramParameters.setFocusMode("continuous-video");
        return;
      }
    } while (!localList.contains("auto"));
    y.d("MicroMsg.scanner.ScanCamera", "camera support auto focus");
    paramParameters.setFocusMode("auto");
  }
  
  public final void a(Camera.PreviewCallback paramPreviewCallback)
  {
    if ((this.dwJ != null) && (this.jOC)) {}
    try
    {
      this.dwJ.setOneShotPreviewCallback(paramPreviewCallback);
      return;
    }
    catch (RuntimeException paramPreviewCallback)
    {
      y.w("MicroMsg.scanner.ScanCamera", "takeOneShot() " + paramPreviewCallback.getMessage());
    }
  }
  
  public final void biP()
  {
    y.i("MicroMsg.scanner.ScanCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[] { this.dwJ, Boolean.valueOf(this.jOC) });
    if ((this.dwJ != null) && (this.jOC)) {
      try
      {
        this.mgM = false;
        Camera.Parameters localParameters = this.dwJ.getParameters();
        if ((!bk.dk(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("off")))
        {
          localParameters.setFlashMode("off");
          this.dwJ.setParameters(localParameters);
          y.i("MicroMsg.scanner.ScanCamera", "close flash");
          return;
        }
        y.i("MicroMsg.scanner.ScanCamera", "camera not support close flash!!");
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.scanner.ScanCamera", localException, "closeFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final float byp()
  {
    if ((this.jOG) && (!this.nOX)) {
      return this.jOD.y / this.jOF.x;
    }
    return this.jOD.x / this.jOF.x;
  }
  
  public final float byq()
  {
    if ((this.jOG) && (!this.nOX)) {
      return this.jOD.x / this.jOF.y;
    }
    return this.jOD.y / this.jOF.y;
  }
  
  public final void byr()
  {
    if ((this.dwJ == null) || (this.jOI)) {
      return;
    }
    for (;;)
    {
      try
      {
        Camera.Parameters localParameters = this.dwJ.getParameters();
        float f3;
        float f4;
        float f2;
        float f1;
        int i;
        int j;
        if (this.jLf != null)
        {
          this.nOY = new Rect();
          f3 = this.jOD.x;
          f4 = this.jOD.y;
          f2 = f4;
          f1 = f3;
          if (this.jOG)
          {
            f2 = f4;
            f1 = f3;
            if (!this.nOX)
            {
              f1 = this.jOD.y;
              f2 = this.jOD.x;
            }
          }
          i = (int)(this.jLf.width() / f1 * 2000.0F);
          j = (int)(this.jLf.height() / f2 * 2000.0F);
          this.nOY.left = (-i / 2);
          this.nOY.right = (i / 2);
          this.nOY.top = (-j / 2);
          this.nOY.bottom = (j / 2);
          y.i("MicroMsg.scanner.ScanCamera", "set focus area:" + this.nOY);
        }
        if (this.jLf != null)
        {
          f3 = this.jOD.x;
          f4 = this.jOD.y;
          f2 = f4;
          f1 = f3;
          if (this.jOG)
          {
            f2 = f4;
            f1 = f3;
            if (!this.nOX)
            {
              f1 = this.jOD.y;
              f2 = this.jOD.x;
            }
          }
          this.nOZ = new Rect();
          i = (int)(this.jLf.width() / f1 * 2000.0F);
          j = (int)(this.jLf.height() / f2 * 2000.0F);
          this.nOZ.left = (-i / 2);
          this.nOZ.right = (i / 2);
          this.nOZ.top = (-j / 2);
          this.nOZ.bottom = (j / 2);
          y.i("MicroMsg.scanner.ScanCamera", "set metering area:" + this.nOZ);
        }
        if ((this.nOY == null) || (this.nOZ == null)) {
          break;
        }
        this.jOI = true;
        if (localParameters.getMaxNumMeteringAreas() > 0)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(new Camera.Area(this.nOZ, 1000));
          localParameters.setMeteringAreas(localArrayList);
          if (localParameters.getMaxNumFocusAreas() <= 0) {
            break label543;
          }
          localArrayList = new ArrayList();
          localArrayList.add(new Camera.Area(this.nOY, 1000));
          localParameters.setFocusAreas(localArrayList);
          this.dwJ.setParameters(localParameters);
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.scanner.ScanCamera", "setScanFocusAndMeteringArea error: %s", new Object[] { localException.getMessage() });
        return;
      }
      y.i("MicroMsg.scanner.ScanCamera", "setScanFocusAndMeteringArea, camera not support set metering area");
      continue;
      label543:
      y.i("MicroMsg.scanner.ScanCamera", "setScanFocusAndMeteringArea, camera not support area focus");
    }
  }
  
  public final void bys()
  {
    for (;;)
    {
      try
      {
        if (this.dwJ == null) {
          break;
        }
        Object localObject = this.dwJ.getParameters();
        String str = ((Camera.Parameters)localObject).get("zoom-supported");
        if ((bk.bl(str)) || (!Boolean.parseBoolean(str)))
        {
          y.i("MicroMsg.scanner.ScanCamera", "not support zoom");
          return;
        }
        localObject = ((Camera.Parameters)localObject).getZoomRatios();
        if ((localObject == null) || (((List)localObject).size() <= 0)) {
          break;
        }
        au.Hx();
        q.fa(c.DA().cwa());
        if (q.dyn.dxl == 1)
        {
          bool = true;
          y.i("MicroMsg.scanner.ScanCamera", "needZoom: %s, qrCodeZoom: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(q.dyn.dxl) });
          if ((!bool) || (this.jOE.x < 720) || ((this.goj != 1) && (this.goj != 8) && (this.goj != 4))) {
            break label371;
          }
          this.nPd = (((List)localObject).size() / 5);
          if (this.nPd > 150) {
            this.nPd = 150;
          }
          double d = 1.5D;
          if (q.dyn.dxm != -1.0D) {
            d = q.dyn.dxm;
          }
          this.nPe = ((int)(((List)localObject).size() / d));
          y.d("MicroMsg.scanner.ScanCamera", "divideRatio: %f,max zoom: %d", new Object[] { Double.valueOf(d), Integer.valueOf(this.nPe) });
          if (this.nPe >= this.nPd) {
            break label379;
          }
          this.nPe = this.nPd;
          y.i("MicroMsg.scanner.ScanCamera", "default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", new Object[] { Integer.valueOf(this.nPd), ((List)localObject).get(this.nPd), Integer.valueOf(this.nPe), ((List)localObject).get(this.nPe) });
          return;
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.scanner.ScanCamera", localException, "init zoom exception!", new Object[0]);
        return;
      }
      boolean bool = false;
      continue;
      label371:
      this.nPd = 0;
      continue;
      label379:
      if (this.nPe > 400) {
        this.nPe = 400;
      }
    }
  }
  
  public final int byt()
  {
    if ((this.dwJ != null) && (this.dwJ.getParameters() != null) && (this.dwJ.getParameters().getZoomRatios() != null) && (this.dwJ.getParameters().getZoomRatios().size() > 0)) {
      return ((Integer)this.dwJ.getParameters().getZoomRatios().get(this.nPc)).intValue();
    }
    return 100;
  }
  
  public final void byu()
  {
    List localList;
    try
    {
      y.i("MicroMsg.scanner.ScanCamera", "set picture focus");
      Camera.Parameters localParameters = this.dwJ.getParameters();
      if (localParameters == null)
      {
        y.w("MicroMsg.scanner.ScanCamera", "camera parameters is null");
        return;
      }
      localList = localParameters.getSupportedFocusModes();
      if (localList == null) {
        return;
      }
      y.d("MicroMsg.scanner.ScanCamera", "supported focus modes size = " + localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        y.d("MicroMsg.scanner.ScanCamera", "supported focus modes : " + str);
      }
      if (!localList.contains("continuous-picture")) {
        break label173;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.scanner.ScanCamera", "setPictureFocus error: %s", new Object[] { localException.getMessage() });
      return;
    }
    y.d("MicroMsg.scanner.ScanCamera", "camera support continuous picture focus");
    localException.setFocusMode("continuous-picture");
    for (;;)
    {
      this.dwJ.setParameters(localException);
      return;
      label173:
      if (localList.contains("continuous-video"))
      {
        y.d("MicroMsg.scanner.ScanCamera", "camera support continuous video focus");
        localException.setFocusMode("continuous-video");
      }
      else if (localList.contains("auto"))
      {
        y.d("MicroMsg.scanner.ScanCamera", "camera support auto focus");
        localException.setFocusMode("auto");
      }
    }
  }
  
  public final boolean byv()
  {
    if ((this.dwJ != null) && (this.jOC)) {}
    try
    {
      Camera.Parameters localParameters = this.dwJ.getParameters();
      if ((!bk.dk(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("torch"))) {
        return true;
      }
      y.i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.scanner.ScanCamera", localException, "isFlashSupported error: %s", new Object[] { localException.getMessage() });
      }
    }
    return false;
  }
  
  public final void cancelAutoFocus()
  {
    try
    {
      if (this.dwJ != null) {
        this.dwJ.cancelAutoFocus();
      }
      return;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.scanner.ScanCamera", "cancelAutoFocus %s", new Object[] { localException.getMessage() });
    }
  }
  
  public final void g(Point paramPoint)
  {
    this.jOF = new Point(paramPoint);
    y.d("MicroMsg.scanner.ScanCamera", "set visible resolution:%s", new Object[] { this.jOF });
  }
  
  public final String getFocusMode()
  {
    try
    {
      if ((this.dwJ != null) && (this.jOC))
      {
        String str = this.dwJ.getParameters().getFocusMode();
        return str;
      }
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.scanner.ScanCamera", "getFocusMode() %s", new Object[] { localException.getMessage() });
    }
    return "";
  }
  
  public final boolean isOpen()
  {
    return this.dwJ != null;
  }
  
  public final void j(SurfaceTexture paramSurfaceTexture)
  {
    long l = bk.UZ();
    if ((this.dwJ != null) && (!this.jOC))
    {
      if (paramSurfaceTexture != null) {
        this.dwJ.setPreviewTexture(paramSurfaceTexture);
      }
      this.dwJ.startPreview();
      this.jOC = true;
      y.d("MicroMsg.scanner.ScanCamera", "startPreview done costTime=[%s]", new Object[] { Long.valueOf(bk.cp(l)) });
    }
  }
  
  public final void open()
  {
    if (this.jOC)
    {
      y.w("MicroMsg.scanner.ScanCamera", "in open(), previewing");
      release();
    }
    int i = d.yM();
    long l = bk.UZ();
    Object localObject1 = d.u(this.bMV, i);
    if (localObject1 == null)
    {
      y.e("MicroMsg.scanner.ScanCamera", "in open(), openCameraRes == null");
      throw new IOException();
    }
    this.mgM = false;
    this.nPa = -1;
    y.d("MicroMsg.scanner.ScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(bk.cp(l)) });
    this.jOH = ((d.a.a)localObject1).rotate;
    if (((d.a.a)localObject1).rotate % 180 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jOG = bool;
      this.dwJ = ((d.a.a)localObject1).dwJ;
      if (this.dwJ != null) {
        break;
      }
      y.e("MicroMsg.scanner.ScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.jOG) });
      throw new IOException();
    }
    Camera.Parameters localParameters = this.dwJ.getParameters();
    Object localObject3 = this.jOE;
    Point localPoint = this.jOF;
    if ((9 == this.goj) || (10 == this.goj) || (7 == this.goj) || (11 == this.goj))
    {
      bool = true;
      localObject1 = localParameters.get("preview-size-values");
      if (localObject1 != null) {
        break label624;
      }
      localObject1 = localParameters.get("preview-size-value");
    }
    label543:
    label624:
    for (;;)
    {
      if (localObject1 != null) {
        y.d("MicroMsg.scanner.ScanCamera", "preview-size-values parameter: " + (String)localObject1);
      }
      Object localObject2;
      for (localObject1 = a(localParameters, (Point)localObject3, bool);; localObject2 = null) {
        for (;;)
        {
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new Point(localPoint.x >> 3 << 3, localPoint.y >> 3 << 3);
          }
          this.jOD = ((Point)localObject3);
          y.d("MicroMsg.scanner.ScanCamera", "getCameraResolution: " + this.jOE + " camera:" + this.jOD);
          localParameters.setPreviewSize(this.jOD.x, this.jOD.y);
          bys();
          try
          {
            d(localParameters);
            localObject1 = localParameters.getSupportedPreviewFormats();
            y.i("MicroMsg.scanner.ScanCamera", "supportedPreviewFormat:" + localObject1);
            if (((List)localObject1).contains(Integer.valueOf(17)))
            {
              i = 0;
              j = 1;
              if (j == 0) {
                break label543;
              }
              y.i("MicroMsg.scanner.ScanCamera", "Preview support NV21");
              localParameters.setPreviewFormat(17);
              this.dwJ.setParameters(localParameters);
              return;
              bool = false;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              int j;
              y.e("MicroMsg.scanner.ScanCamera", "set focus mode error: %s", new Object[] { localException.getMessage() });
              continue;
              if (localException.contains(Integer.valueOf(842094169)))
              {
                i = 1;
                j = 0;
                continue;
                if (i != 0)
                {
                  y.i("MicroMsg.scanner.ScanCamera", "Preview not support NV21, but support YV12");
                  localParameters.setPreviewFormat(842094169);
                }
                else
                {
                  y.i("MicroMsg.scanner.ScanCamera", "Preview not support NV21 and YV12. Use format: %s", new Object[] { localException.get(0) });
                  localParameters.setPreviewFormat(((Integer)localException.get(0)).intValue());
                }
              }
              else
              {
                i = 0;
                j = 0;
              }
            }
          }
        }
      }
    }
  }
  
  public final void release()
  {
    y.i("MicroMsg.scanner.ScanCamera", "release(), previewing = [%s]", new Object[] { Boolean.valueOf(this.jOC) });
    if (this.dwJ != null)
    {
      long l = bk.UZ();
      this.dwJ.setPreviewCallback(null);
      this.dwJ.stopPreview();
      this.jOC = false;
      y.i("MicroMsg.scanner.ScanCamera", "stopPreview costTime=[%s]", new Object[] { Long.valueOf(bk.cp(l)) });
      l = bk.UZ();
      this.dwJ.release();
      this.dwJ = null;
      y.i("MicroMsg.scanner.ScanCamera", "camera.release() costTime=[%s]", new Object[] { Long.valueOf(bk.cp(l)) });
    }
    this.mgM = false;
    this.jOI = false;
    this.nPa = -1;
    this.goj = 0;
  }
  
  public final void wV(int paramInt)
  {
    this.goj = paramInt;
    this.jLf = null;
  }
  
  public final void wW(int paramInt)
  {
    if ((this.dwJ != null) && (this.jOC) && (paramInt > 0)) {}
    for (;;)
    {
      List localList;
      int j;
      try
      {
        Camera.Parameters localParameters = this.dwJ.getParameters();
        localList = localParameters.getZoomRatios();
        if (localList == null) {
          break label526;
        }
        if (localList.size() <= 0) {
          return;
        }
        double d = paramInt / 100.0D;
        j = (int)(((Integer)localList.get(this.nPc)).intValue() * d);
        y.d("MicroMsg.scanner.ScanCamera", "scale:%d,to ratio:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j) });
        if ((j < ((Integer)localList.get(this.nPd)).intValue()) || (j > ((Integer)localList.get(this.nPe)).intValue())) {
          break label445;
        }
        if ((localList == null) || (localList.size() <= 0)) {
          break label521;
        }
        y.i("MicroMsg.scanner.ScanCamera", "zoomRatios: %s,size: %d", new Object[] { localList, Integer.valueOf(localList.size()) });
        paramInt = Collections.binarySearch(localList, Integer.valueOf(j));
        y.i("MicroMsg.scanner.ScanCamera", "insert index:%d", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt >= 0)
        {
          y.i("MicroMsg.scanner.ScanCamera", "zoom:%d,ratio:%d", new Object[] { Integer.valueOf(paramInt), localList.get(paramInt) });
          this.nPc = paramInt;
          localParameters.setZoom(paramInt);
          this.dwJ.setParameters(localParameters);
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.scanner.ScanCamera", "zoom scale exception:" + localException.getMessage());
        return;
      }
      paramInt = -(paramInt + 1);
      int i = paramInt - 1;
      if ((paramInt >= 0) && (paramInt <= localList.size() - 1) && (i >= 0) && (i <= localList.size() - 1))
      {
        if (((Integer)localList.get(paramInt)).intValue() - j > j - ((Integer)localList.get(i)).intValue()) {
          paramInt = i;
        }
      }
      else if ((paramInt < 0) || (paramInt > localList.size() - 1)) {
        if ((i >= 0) && (i <= localList.size() - 1))
        {
          paramInt = i;
          continue;
          label445:
          if (j < ((Integer)localList.get(this.nPd)).intValue())
          {
            paramInt = this.nPd;
          }
          else
          {
            y.i("MicroMsg.scanner.ScanCamera", "exceed max zoom");
            i = this.nPc + (this.nPe - this.nPc) / 5;
            paramInt = i;
            if (i > this.nPe) {
              paramInt = this.nPe;
            }
          }
        }
        else
        {
          label521:
          paramInt = 0;
          continue;
          label526:
          return;
        }
      }
    }
  }
  
  public final void wX(int paramInt)
  {
    if ((this.dwJ != null) && (this.jOC)) {}
    for (;;)
    {
      try
      {
        Camera.Parameters localParameters = this.dwJ.getParameters();
        List localList = localParameters.getZoomRatios();
        if (localList == null) {
          break label354;
        }
        if (localList.size() <= 0) {
          return;
        }
        y.i("MicroMsg.scanner.ScanCamera", "zoom action:%d,beforeZoom:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localParameters.getZoom()) });
        switch (paramInt)
        {
        case 0: 
          localParameters.setZoom(this.nPc);
          this.dwJ.setParameters(localParameters);
          y.i("MicroMsg.scanner.ScanCamera", "zoom action:%d,afterZoom:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localParameters.getZoom()) });
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.scanner.ScanCamera", "zoom action exception:" + localException.getMessage());
        return;
      }
      this.nPc = 0;
      continue;
      this.nPc = this.nPd;
      continue;
      if (this.nPc < this.nPe)
      {
        this.nPc += 1;
        if (this.nPc > this.nPe) {}
        for (int i = this.nPe;; i = this.nPc)
        {
          this.nPc = i;
          break;
        }
        if (this.nPc > this.nPd)
        {
          this.nPc -= 1;
          if (this.nPc < this.nPd) {}
          for (i = this.nPd;; i = this.nPc)
          {
            this.nPc = i;
            break;
          }
          this.nPc = this.nPe;
          continue;
          if (this.nPc != this.nPd)
          {
            this.nPc = this.nPd;
          }
          else
          {
            this.nPc = this.nPe;
            continue;
            label354:
            return;
          }
        }
      }
    }
  }
  
  private static final class a
    implements Comparator<Camera.Size>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.h
 * JD-Core Version:    0.7.0.1
 */