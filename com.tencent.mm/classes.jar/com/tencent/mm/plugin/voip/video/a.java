package com.tencent.mm.plugin.voip.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.h.a.lx;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class a
  implements com.tencent.mm.plugin.video.a, com.tencent.mm.plugin.video.b
{
  private static final Pattern nOW = Pattern.compile(",");
  private static int pZK = 20;
  private static int pZL = 70;
  protected boolean jXl = false;
  protected Camera mCamera;
  protected int mHeight = 240;
  protected int mWidth = 320;
  protected boolean pZM = false;
  protected boolean pZN = false;
  protected boolean pZO = false;
  protected boolean pZP = false;
  protected boolean pZQ = false;
  protected long pZR = 0L;
  protected long pZS = 30000L;
  protected int pZT = 0;
  public Camera.Parameters pZU;
  protected Camera.Size pZV;
  protected int pZW;
  public boolean pZX = false;
  protected boolean pZY = false;
  protected boolean pZZ = false;
  protected ObservableSurfaceView qaa = null;
  protected ObservableTextureView qab;
  protected g qac;
  protected boolean qad = false;
  protected boolean qae = false;
  protected byte[] qaf = null;
  protected int[] qag = null;
  protected List<byte[]> qah;
  protected boolean qai = true;
  protected int qaj;
  public int qak = 0;
  public int qal = 0;
  protected int qam = 0;
  Camera.PreviewCallback qan = new a.2(this);
  
  public a(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    j.er(ae.getContext().getApplicationContext());
    y.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
  }
  
  private static Point a(CharSequence paramCharSequence, Point paramPoint)
  {
    int i1 = 2147483647;
    paramCharSequence = nOW.split(paramCharSequence);
    int i6 = paramCharSequence.length;
    int m = 0;
    int j = 0;
    String str;
    int k;
    int i4;
    int i3;
    int i2;
    for (int i = 0;; i = i4)
    {
      if (m >= i6) {
        break label271;
      }
      str = paramCharSequence[m].trim();
      k = str.indexOf('x');
      if (k >= 0) {
        break;
      }
      y.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: " + str);
      i4 = i;
      i3 = j;
      i2 = i1;
      m += 1;
      i1 = i2;
      j = i3;
    }
    for (;;)
    {
      int i5;
      try
      {
        n = bk.getInt(str.substring(0, k), 0);
        k = bk.getInt(str.substring(k + 1), 0);
        i5 = Math.abs(n - paramPoint.x) + Math.abs(k - paramPoint.y);
        if (i5 != 0) {
          break label220;
        }
        if ((n <= 0) || (k <= 0)) {
          break label269;
        }
        return new Point(n, k);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        y.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: " + str);
        i2 = i1;
        i3 = j;
        i4 = i;
      }
      break;
      label220:
      i2 = i1;
      i3 = j;
      i4 = i;
      if (i5 >= i1) {
        break;
      }
      i2 = i1;
      i3 = j;
      i4 = i;
      if (n == k) {
        break;
      }
      i2 = i5;
      i3 = k;
      i4 = n;
      break;
      label269:
      return null;
      label271:
      k = j;
      int n = i;
    }
  }
  
  private static boolean a(Camera paramCamera, int paramInt1, int paramInt2)
  {
    if (paramCamera == null) {
      return false;
    }
    try
    {
      Camera.Parameters localParameters = paramCamera.getParameters();
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        localParameters.setPreviewSize(paramInt1, paramInt2);
      }
      paramCamera.setParameters(localParameters);
      return true;
    }
    catch (Exception paramCamera)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(159L, 0L, 1L, false);
      y.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + paramCamera.toString());
    }
    return false;
  }
  
  private void bSp()
  {
    if ((this.pZV != null) && (this.pZV.height > 0) && (this.pZV.width > 0))
    {
      int j = this.pZV.height * this.pZV.width * 3 / 2;
      if (this.qah == null)
      {
        this.qah = new ArrayList(3);
        i = 0;
        while (i < 3)
        {
          this.qah.add(new byte[j]);
          i += 1;
        }
      }
      int i = 0;
      while (i < this.qah.size())
      {
        this.mCamera.addCallbackBuffer((byte[])this.qah.get(i));
        i += 1;
      }
      this.mCamera.setPreviewCallbackWithBuffer(this.qan);
      return;
    }
    this.mCamera.setPreviewCallback(this.qan);
  }
  
  public static void bSt() {}
  
  private int e(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.Voip.CaptureRender", "try open camera, face: " + paramBoolean);
    this.pZY = false;
    int j = 1;
    int i = j;
    if (this.mCamera != null)
    {
      if (this.pZM == paramBoolean) {
        break label108;
      }
      this.mCamera.setPreviewCallback(null);
      this.mCamera.stopPreview();
      this.mCamera.release();
      this.mCamera = null;
    }
    label108:
    for (i = j; i != 0; i = 0)
    {
      this.mCamera = ke(paramBoolean);
      if (this.mCamera != null) {
        break;
      }
      this.pZX = false;
      return -1;
    }
    Object localObject3;
    try
    {
      if (this.mCamera != null) {
        this.mCamera.getParameters();
      }
      this.pZX = true;
      localObject1 = this.mCamera;
      i = j.qbM.qaG;
      if (localObject1 == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        label190:
        label233:
        label241:
        localCamera = this.mCamera;
        localObject1 = localCamera.getParameters();
        localPoint = new Point(paramInt1, paramInt2);
        localObject4 = ((Camera.Parameters)localObject1).get("preview-size-values");
        if (localObject4 != null) {
          break label1295;
        }
        localObject4 = ((Camera.Parameters)localObject1).get("preview-size-value");
        label370:
        localObject1 = null;
        if (localObject4 != null)
        {
          y.i("MicroMsg.Voip.CaptureRender", "preview-size-values parameter: " + (String)localObject4);
          localObject1 = a((CharSequence)localObject4, localPoint);
        }
        localObject4 = localObject1;
        if (localObject1 == null) {
          localObject4 = new Point(localPoint.x >> 3 << 3, localPoint.y >> 3 << 3);
        }
        localCamera.getClass();
        localObject1 = new Camera.Size(localCamera, ((Point)localObject4).x, ((Point)localObject4).y);
      }
      catch (Exception localException5)
      {
        Object localObject1;
        Object localObject5;
        localObject2 = localObject5;
      }
      try
      {
        y.i("MicroMsg.Voip.CaptureRender", "getCameraResolution:" + ((Camera.Size)localObject1).width + "," + ((Camera.Size)localObject1).height);
        if (i == 0) {
          break label825;
        }
        paramBoolean = a(this.mCamera, ((Camera.Size)localObject3).width, ((Camera.Size)localObject3).height);
        y.i("MicroMsg.Voip.CaptureRender", "1.try config size first! w" + ((Camera.Size)localObject3).width + ",h" + ((Camera.Size)localObject3).height);
        if ((paramBoolean) || (localObject1 == null)) {
          break label940;
        }
        y.e("MicroMsg.Voip.CaptureRender", "1.try config size failed!,try support size: w" + ((Camera.Size)localObject1).width + ",h" + ((Camera.Size)localObject1).height);
        if (a(this.mCamera, ((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height)) {
          break label940;
        }
        y.e("MicroMsg.Voip.CaptureRender", "1.try support size fail: w" + ((Camera.Size)localObject1).width + ",h" + ((Camera.Size)localObject1).height);
        return -1;
      }
      catch (Exception localException6)
      {
        break label802;
      }
      localException1 = localException1;
      com.tencent.mm.plugin.report.service.h.nFQ.a(159L, 0L, 1L, false);
      y.e("MicroMsg.Voip.CaptureRender", "Camera open failed, error:%s", new Object[] { localException1.getMessage() });
      if (this.qac != null) {
        this.qac.blN();
      }
      return -1;
    }
    label738:
    Object localObject2;
    try
    {
      localObject3 = ((Camera)localObject1).getParameters();
      if (!l.wx()) {
        break label738;
      }
      ((Camera.Parameters)localObject3).setPreviewFpsRange(i * 1000, i * 1000);
      ((Camera)localObject1).setParameters((Camera.Parameters)localObject3);
    }
    catch (Exception localException2)
    {
      y.e("MicroMsg.Voip.CaptureRender", "SafeSetFps error:" + localException2.toString());
      break label190;
      localObject2 = j.qbM.qaM;
      break label233;
      i = 0;
      break label241;
    }
    y.i("MicroMsg.Voip.CaptureRender", "Camera Open Success, try set size: w,h:" + paramInt1 + "," + paramInt2);
    if (paramBoolean)
    {
      localObject1 = j.qbM.qaL;
      if (localObject1 == null) {
        break label790;
      }
      i = 1;
      localObject5 = null;
      if (localObject1 == null) {
        break label1298;
      }
      localObject3 = this.mCamera;
      localObject3.getClass();
      localObject3 = new Camera.Size((Camera)localObject3, ((Point)localObject1).x, ((Point)localObject1).y);
      y.i("MicroMsg.Voip.CaptureRender", "getCameraSize from table:" + ((Camera.Size)localObject3).width + "," + ((Camera.Size)localObject3).height);
    }
    for (;;)
    {
      Camera localCamera;
      Point localPoint;
      Object localObject4;
      ((Camera.Parameters)localObject3).setPreviewFrameRate(i);
      break;
      label790:
      label802:
      y.e("MicroMsg.Voip.CaptureRender", "getCameraResolution failed: %s", new Object[] { localException5.getMessage() });
    }
    label825:
    y.i("MicroMsg.Voip.CaptureRender", "2.no config size!");
    if (localObject2 != null)
    {
      y.i("MicroMsg.Voip.CaptureRender", "2.try support size alternatively! w" + ((Camera.Size)localObject2).width + ",h" + ((Camera.Size)localObject2).height);
      if (!a(this.mCamera, ((Camera.Size)localObject2).width, ((Camera.Size)localObject2).height))
      {
        y.e("MicroMsg.Voip.CaptureRender", "2.try support size fail: w" + ((Camera.Size)localObject2).width + ",h" + ((Camera.Size)localObject2).height);
        return -1;
      }
    }
    label940:
    h(this.mCamera);
    for (;;)
    {
      try
      {
        this.pZU = this.mCamera.getParameters();
        this.pZV = this.pZU.getPreviewSize();
        paramInt2 = this.pZU.getPreviewFrameRate();
        this.pZW = j.qbR;
        if (this.pZW <= 0) {
          this.pZW = 7;
        }
      }
      catch (Exception localException3)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(159L, 0L, 1L, false);
        y.e("MicroMsg.Voip.CaptureRender", "try getParameters and getPreviewSize fail, error:%s", new Object[] { localException3.getMessage() });
        return -1;
      }
      try
      {
        localObject2 = this.mCamera;
        localObject3 = new Camera.CameraInfo();
        if (!this.pZM) {
          break label1239;
        }
        paramInt1 = j.qbN;
        Camera.getCameraInfo(paramInt1, (Camera.CameraInfo)localObject3);
        i = ((WindowManager)ae.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        paramInt1 = 0;
        switch (i)
        {
        default: 
          if (!this.pZM) {
            break label1246;
          }
          paramInt1 = (360 - (paramInt1 + ((Camera.CameraInfo)localObject3).orientation) % 360) % 360;
          ((Camera)localObject2).setDisplayOrientation(paramInt1);
          this.qaj = paramInt1;
        }
      }
      catch (Exception localException4)
      {
        y.e("MicroMsg.Voip.CaptureRender", "setDisplayOrientation failed: %s", new Object[] { localException4.getMessage() });
        continue;
      }
      y.i("MicroMsg.Voip.CaptureRender", "Camera ok, fps: %d, mSize.width: %d, mSize.height: %d, format: %d, IsRotate180: %d, displayOrientation: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.pZV.width), Integer.valueOf(this.pZV.height), Integer.valueOf(this.pZW), Integer.valueOf(j.qbP), Integer.valueOf(this.qaj) });
      return 1;
      label1239:
      paramInt1 = j.qbO;
      continue;
      label1246:
      paramInt1 = (((Camera.CameraInfo)localObject3).orientation - paramInt1 + 360) % 360;
      continue;
      label1295:
      break label370;
      label1298:
      localObject3 = null;
      break;
      continue;
      paramInt1 = 0;
      continue;
      paramInt1 = 90;
      continue;
      paramInt1 = 180;
      continue;
      paramInt1 = 270;
    }
  }
  
  private boolean h(Camera paramCamera)
  {
    if (paramCamera == null) {
      return false;
    }
    Camera.Parameters localParameters;
    List localList;
    try
    {
      localParameters = paramCamera.getParameters();
      localList = localParameters.getSupportedFocusModes();
      if (localList == null) {
        break label307;
      }
      y.d("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        y.d("MicroMsg.Voip.CaptureRender", "supported focus modes : " + str);
      }
      if (q.dyd.dwD != 0) {
        break label227;
      }
    }
    catch (Exception paramCamera)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(159L, 0L, 1L, false);
      y.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + paramCamera.toString());
      return false;
    }
    if (localList.contains("auto"))
    {
      y.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
      localParameters.setFocusMode("auto");
      this.pZY = false;
    }
    for (;;)
    {
      paramCamera.setParameters(localParameters);
      break;
      if (localList.contains("continuous-video"))
      {
        y.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
        localParameters.setFocusMode("continuous-video");
        this.pZY = true;
        continue;
        label227:
        if (q.dyd.dwD == 1) {
          if (localList.contains("continuous-video"))
          {
            y.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
            localParameters.setFocusMode("continuous-video");
            this.pZY = true;
          }
          else if (localList.contains("auto"))
          {
            y.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
            localParameters.setFocusMode("auto");
            this.pZY = false;
          }
        }
      }
    }
    label307:
    return true;
  }
  
  private int i(Camera paramCamera)
  {
    if (paramCamera == null) {
      return 0;
    }
    for (;;)
    {
      try
      {
        localObject = paramCamera.getParameters().getSupportedPreviewSizes();
        if ((localObject == null) || (((List)localObject).size() == 0)) {
          continue;
        }
        localObject = ((List)localObject).iterator();
        i = 0;
      }
      catch (Exception paramCamera)
      {
        Object localObject;
        int i = 0;
        continue;
        i = 0;
        continue;
      }
      try
      {
        if (((Iterator)localObject).hasNext())
        {
          Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
          y.d("MicroMsg.Voip.CaptureRender", "support Size:" + localSize.width + "," + localSize.height);
          if (i == 0)
          {
            this.qak = localSize.width;
            this.qal = localSize.height;
          }
          i += 1;
        }
        else
        {
          try
          {
            paramCamera = paramCamera.getParameters().getSupportedPreviewFormats();
            if ((paramCamera == null) || (paramCamera.size() == 0)) {
              continue;
            }
            paramCamera = paramCamera.iterator();
            if (!paramCamera.hasNext()) {
              continue;
            }
            int j = ((Integer)paramCamera.next()).intValue();
            y.i("MicroMsg.Voip.CaptureRender", "support Format:" + j);
            continue;
            y.printErrStackTrace("MicroMsg.Voip.CaptureRender", paramCamera, "", new Object[0]);
          }
          catch (Exception paramCamera) {}
        }
      }
      catch (Exception paramCamera) {}
    }
    return i;
    return i;
  }
  
  private static void j(Camera paramCamera)
  {
    try
    {
      localList = paramCamera.getParameters().getSupportedPreviewFrameRates();
      paramCamera = "supportFps:";
      localCamera = paramCamera;
      if (localList != null)
      {
        int i = 0;
        for (;;)
        {
          localCamera = paramCamera;
          if (i >= localList.size()) {
            break;
          }
          int j = ((Integer)localList.get(i)).intValue();
          paramCamera = paramCamera + j + ",";
          i += 1;
        }
      }
    }
    catch (Exception paramCamera)
    {
      Camera localCamera;
      for (;;)
      {
        y.d("MicroMsg.Voip.CaptureRender", "getSupportedPreviewFrameRates:error:" + paramCamera.toString());
        List localList = null;
      }
      y.i("MicroMsg.Voip.CaptureRender", localCamera);
    }
  }
  
  private static Camera kd(boolean paramBoolean)
  {
    Object localObject = null;
    if (j.qbM.dvX <= 0) {}
    while (!j.qbS) {
      return null;
    }
    if (paramBoolean == true) {
      try
      {
        Camera localCamera1 = Camera.open(j.qbN);
        localObject = localCamera1;
        y.i("Camera", "Use front");
        return localCamera1;
      }
      catch (Exception localException)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(159L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.nFQ.a(159L, 1L, 1L, false);
        y.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + localException.toString());
        return localObject;
      }
    }
    Camera localCamera2 = Camera.open(j.qbO);
    localObject = localCamera2;
    y.i("Camera", "Use back");
    return localCamera2;
  }
  
  private Camera ke(boolean paramBoolean)
  {
    Object localObject2 = kd(paramBoolean);
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    for (;;)
    {
      try
      {
        localObject1 = Camera.open();
      }
      catch (Exception localException1)
      {
        y.e("MicroMsg.Voip.CaptureRender", "OpenCameraError:" + localException1.toString());
        com.tencent.mm.plugin.report.service.h.nFQ.a(159L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.nFQ.a(159L, 1L, 1L, false);
        if (this.qac != null) {
          this.qac.blN();
        }
        return null;
      }
      try
      {
        localObject2 = ((Camera)localObject1).getParameters();
        if (!paramBoolean) {
          break label130;
        }
        i = 2;
        ((Camera.Parameters)localObject2).set("camera-id", i);
        ((Camera)localObject1).setParameters((Camera.Parameters)localObject2);
      }
      catch (Exception localException2)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(159L, 0L, 1L, false);
        y.e("MicroMsg.Voip.CaptureRender", "set camera-id error:" + localException2.toString());
        continue;
      }
      this.pZM = paramBoolean;
      j((Camera)localObject1);
      i((Camera)localObject1);
      return localObject1;
      label130:
      int i = 1;
    }
  }
  
  public final int a(g paramg, boolean paramBoolean)
  {
    if (j.qbM.dvX <= 0)
    {
      this.pZT = 1;
      return -1;
    }
    if (paramBoolean) {
      if (!j.qbM.qaH) {
        paramBoolean = false;
      }
    }
    for (;;)
    {
      this.qac = paramg;
      if (e(paramBoolean, this.mWidth, this.mHeight) > 0) {
        break;
      }
      int i = e(paramBoolean, 0, 0);
      if (i > 0) {
        break;
      }
      this.pZT = 1;
      return i;
      if (!j.qbM.qaI) {
        paramBoolean = true;
      }
    }
    bSp();
    this.pZT = 0;
    return 1;
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder)
  {
    boolean bool1 = false;
    y.d("MicroMsg.Voip.CaptureRender", "surfaceChange");
    if ((!this.pZX) || (paramSurfaceHolder.getSurface() == null))
    {
      boolean bool2 = this.pZX;
      if (paramSurfaceHolder.getSurface() == null) {
        bool1 = true;
      }
      y.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed, CameraOpen: %b, surface: %b, apiLevel: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(Build.VERSION.SDK_INT) });
      return;
    }
    try
    {
      this.mCamera.setPreviewCallback(null);
      this.mCamera.stopPreview();
      this.mCamera.setPreviewDisplay(paramSurfaceHolder);
      bSp();
      this.mCamera.startPreview();
      this.jXl = true;
      if (this.qae)
      {
        bSr();
        this.qae = false;
      }
      com.tencent.mm.plugin.voip.b.bPx().Ak(this.pZT);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(159L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.nFQ.a(159L, 2L, 1L, false);
        y.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + paramSurfaceHolder.getMessage());
        this.pZT = 1;
      }
    }
  }
  
  public final void a(ObservableSurfaceView paramObservableSurfaceView)
  {
    y.d("MicroMsg.Voip.CaptureRender", "bind ObservableSurfaceView");
    if (paramObservableSurfaceView == null) {
      return;
    }
    this.qaa = paramObservableSurfaceView;
    this.qaa.setSurfaceChangeCallback(this);
    this.pZZ = true;
  }
  
  public final void a(ObservableTextureView paramObservableTextureView)
  {
    y.i("MicroMsg.Voip.CaptureRender", "bind ObservableTextureView");
    if (paramObservableTextureView == null) {
      return;
    }
    this.qab = paramObservableTextureView;
    this.qab.setTextureChangeCallback(this);
    this.pZZ = false;
  }
  
  public final void bSq()
  {
    if (j.qbM.dvX < 2)
    {
      y.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + j.qbM.dvX);
      return;
    }
    y.i("MicroMsg.Voip.CaptureRender", "ExchangeCapture start, gCameraNum= " + j.qbM.dvX);
    bSs();
    g localg = this.qac;
    if (!this.pZM) {}
    for (boolean bool = true;; bool = false)
    {
      a(localg, bool);
      bSr();
      com.tencent.mm.plugin.voip.b.bPx().Ak(this.pZT);
      this.qai = true;
      return;
    }
  }
  
  /* Error */
  public final int bSr()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 99	com/tencent/mm/plugin/voip/video/a:pZX	Z
    //   4: ifne +18 -> 22
    //   7: ldc 153
    //   9: ldc_w 695
    //   12: invokestatic 267	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 97	com/tencent/mm/plugin/voip/video/a:pZT	I
    //   20: iconst_m1
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 107	com/tencent/mm/plugin/voip/video/a:qad	Z
    //   26: ifeq +13 -> 39
    //   29: ldc 153
    //   31: ldc_w 697
    //   34: invokestatic 267	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: iconst_m1
    //   38: ireturn
    //   39: aload_0
    //   40: getfield 105	com/tencent/mm/plugin/voip/video/a:qaa	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   43: ifnull +28 -> 71
    //   46: aload_0
    //   47: getfield 105	com/tencent/mm/plugin/voip/video/a:qaa	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   50: invokevirtual 700	com/tencent/mm/plugin/video/ObservableSurfaceView:bOY	()Z
    //   53: ifne +18 -> 71
    //   56: ldc 153
    //   58: ldc_w 702
    //   61: invokestatic 497	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_0
    //   65: iconst_1
    //   66: putfield 109	com/tencent/mm/plugin/voip/video/a:qae	Z
    //   69: iconst_0
    //   70: ireturn
    //   71: ldc 153
    //   73: ldc_w 704
    //   76: iconst_1
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload_0
    //   83: getfield 103	com/tencent/mm/plugin/voip/video/a:pZZ	Z
    //   86: invokestatic 634	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   89: aastore
    //   90: invokestatic 167	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_0
    //   94: getfield 105	com/tencent/mm/plugin/voip/video/a:qaa	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   97: ifnull +103 -> 200
    //   100: aload_0
    //   101: getfield 103	com/tencent/mm/plugin/voip/video/a:pZZ	Z
    //   104: ifeq +96 -> 200
    //   107: aload_0
    //   108: getfield 297	com/tencent/mm/plugin/voip/video/a:mCamera	Landroid/hardware/Camera;
    //   111: aload_0
    //   112: getfield 105	com/tencent/mm/plugin/voip/video/a:qaa	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   115: invokevirtual 708	com/tencent/mm/plugin/video/ObservableSurfaceView:getSurfaceHolder	()Landroid/view/SurfaceHolder;
    //   118: invokevirtual 642	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   121: aload_0
    //   122: getfield 297	com/tencent/mm/plugin/voip/video/a:mCamera	Landroid/hardware/Camera;
    //   125: invokevirtual 645	android/hardware/Camera:startPreview	()V
    //   128: aload_0
    //   129: iconst_1
    //   130: putfield 127	com/tencent/mm/plugin/voip/video/a:jXl	Z
    //   133: aload_0
    //   134: iconst_1
    //   135: putfield 107	com/tencent/mm/plugin/voip/video/a:qad	Z
    //   138: iconst_1
    //   139: ireturn
    //   140: astore_1
    //   141: getstatic 256	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   144: ldc2_w 257
    //   147: lconst_0
    //   148: lconst_1
    //   149: iconst_0
    //   150: invokevirtual 261	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   153: getstatic 256	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   156: ldc2_w 257
    //   159: ldc2_w 660
    //   162: lconst_1
    //   163: iconst_0
    //   164: invokevirtual 261	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   167: aload_0
    //   168: iconst_1
    //   169: putfield 97	com/tencent/mm/plugin/voip/video/a:pZT	I
    //   172: ldc 153
    //   174: new 188	java/lang/StringBuilder
    //   177: dup
    //   178: ldc_w 710
    //   181: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: aload_1
    //   185: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   188: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 267	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: goto -76 -> 121
    //   200: aload_0
    //   201: getfield 677	com/tencent/mm/plugin/voip/video/a:qab	Lcom/tencent/mm/plugin/video/ObservableTextureView;
    //   204: ifnull -83 -> 121
    //   207: aload_0
    //   208: getfield 103	com/tencent/mm/plugin/voip/video/a:pZZ	Z
    //   211: ifne -90 -> 121
    //   214: aload_0
    //   215: getfield 297	com/tencent/mm/plugin/voip/video/a:mCamera	Landroid/hardware/Camera;
    //   218: aload_0
    //   219: getfield 677	com/tencent/mm/plugin/voip/video/a:qab	Lcom/tencent/mm/plugin/video/ObservableTextureView;
    //   222: invokevirtual 714	com/tencent/mm/plugin/video/ObservableTextureView:getSurfaceTexture	()Landroid/graphics/SurfaceTexture;
    //   225: invokevirtual 718	android/hardware/Camera:setPreviewTexture	(Landroid/graphics/SurfaceTexture;)V
    //   228: goto -107 -> 121
    //   231: astore_1
    //   232: getstatic 256	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   235: ldc2_w 257
    //   238: lconst_0
    //   239: lconst_1
    //   240: iconst_0
    //   241: invokevirtual 261	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   244: getstatic 256	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   247: ldc2_w 257
    //   250: ldc2_w 660
    //   253: lconst_1
    //   254: iconst_0
    //   255: invokevirtual 261	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   258: aload_0
    //   259: iconst_1
    //   260: putfield 97	com/tencent/mm/plugin/voip/video/a:pZT	I
    //   263: ldc 153
    //   265: new 188	java/lang/StringBuilder
    //   268: dup
    //   269: ldc_w 710
    //   272: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload_1
    //   276: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   279: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 267	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: goto -167 -> 121
    //   291: astore_1
    //   292: getstatic 256	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   295: ldc2_w 257
    //   298: lconst_0
    //   299: lconst_1
    //   300: iconst_0
    //   301: invokevirtual 261	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   304: getstatic 256	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   307: ldc2_w 257
    //   310: ldc2_w 660
    //   313: lconst_1
    //   314: iconst_0
    //   315: invokevirtual 261	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   318: aload_0
    //   319: iconst_1
    //   320: putfield 97	com/tencent/mm/plugin/voip/video/a:pZT	I
    //   323: aload_0
    //   324: getfield 401	com/tencent/mm/plugin/voip/video/a:qac	Lcom/tencent/mm/plugin/voip/video/g;
    //   327: ifnull +12 -> 339
    //   330: aload_0
    //   331: getfield 401	com/tencent/mm/plugin/voip/video/a:qac	Lcom/tencent/mm/plugin/voip/video/g;
    //   334: invokeinterface 406 1 0
    //   339: ldc 153
    //   341: new 188	java/lang/StringBuilder
    //   344: dup
    //   345: ldc_w 720
    //   348: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   351: aload_1
    //   352: invokevirtual 264	java/lang/Exception:toString	()Ljava/lang/String;
    //   355: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 267	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: goto -231 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	a
    //   140	45	1	localException1	Exception
    //   231	45	1	localException2	Exception
    //   291	61	1	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   107	121	140	java/lang/Exception
    //   214	228	231	java/lang/Exception
    //   121	133	291	java/lang/Exception
  }
  
  public final void bSs()
  {
    y.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.qad);
    if (this.qad)
    {
      this.qae = false;
      this.mCamera.setPreviewCallback(null);
    }
    try
    {
      this.mCamera.stopPreview();
      this.jXl = false;
      this.qad = false;
      if (1 == this.pZT)
      {
        lx locallx = new lx();
        locallx.bVc.type = 2;
        com.tencent.mm.sdk.b.a.udP.m(locallx);
      }
      y.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.pZX);
      if (this.pZX)
      {
        this.pZT = 0;
        this.qae = false;
        this.mCamera.setPreviewCallback(null);
        this.mCamera.release();
        this.mCamera = null;
        this.pZX = false;
        this.qaf = null;
        if (this.qah != null) {
          this.qah.clear();
        }
        this.qah = null;
        this.pZY = false;
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.Voip.CaptureRender", "stopPreview:error" + localException.toString());
        continue;
        if (this.mCamera != null)
        {
          this.mCamera.release();
          this.mCamera = null;
          this.pZX = false;
        }
      }
    }
  }
  
  public final boolean bSu()
  {
    return this.pZM;
  }
  
  public final boolean bSv()
  {
    return this.pZN;
  }
  
  public final int bSw()
  {
    return this.pZT;
  }
  
  public final boolean biR()
  {
    return this.jXl;
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool1 = false;
    y.d("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable");
    if ((!this.pZX) || (paramSurfaceTexture == null))
    {
      boolean bool2 = this.pZX;
      if (paramSurfaceTexture == null) {
        bool1 = true;
      }
      y.e("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable failed, CameraOpen: %b, surface: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      return;
    }
    try
    {
      this.mCamera.setPreviewCallback(null);
      this.mCamera.stopPreview();
      this.mCamera.setPreviewTexture(paramSurfaceTexture);
      bSp();
      this.mCamera.startPreview();
      this.jXl = true;
      if (this.qae)
      {
        bSr();
        this.qae = false;
      }
      com.tencent.mm.plugin.voip.b.bPx().Ak(this.pZT);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(159L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.nFQ.a(159L, 2L, 1L, false);
        y.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + paramSurfaceTexture.getMessage());
        this.pZT = 1;
      }
    }
  }
  
  @TargetApi(14)
  public final void r(int[] paramArrayOfInt)
  {
    boolean bool3 = true;
    label20:
    label75:
    label119:
    int i;
    label305:
    label307:
    label313:
    label333:
    Object localObject;
    int j;
    int k;
    int m;
    label463:
    int n;
    int i1;
    if ((q.dyd.dwD == 1) && (this.pZY))
    {
      return;
    }
    else
    {
      if (q.dyd.dwC > 2000) {
        this.pZS = q.dyd.dwC;
      }
      if (paramArrayOfInt == null)
      {
        y.e("MicroMsg.Voip.CaptureRender", "focusOnFace error, faceLocation is null");
        boolean bool2;
        if (System.currentTimeMillis() - this.pZR > this.pZS)
        {
          bool1 = true;
          if ((this.pZO) && (!bool1) && (this.pZP == this.pZM)) {
            break label305;
          }
          paramArrayOfInt = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
          if (this.pZO) {
            break label307;
          }
          bool2 = true;
          paramArrayOfInt = paramArrayOfInt.append(bool2).append(",isAutoFocusTimeout: ").append(bool1).append(",mAutoFocusTimeOut:").append(this.pZS).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
          if (this.pZP == this.pZM) {
            break label313;
          }
        }
        for (boolean bool1 = bool3;; bool1 = false)
        {
          for (;;)
          {
            y.i("MicroMsg.Voip.CaptureRender", bool1 + ",isClickScreen :false");
            try
            {
              if ((this.mCamera == null) || (this.mCamera.getParameters() == null) || (this.mCamera.getParameters().getFocusMode() == null) || (!this.mCamera.getParameters().getFocusMode().equals("auto"))) {
                break;
              }
              this.mCamera.autoFocus(null);
              this.qag = null;
              this.pZR = System.currentTimeMillis();
              this.pZO = true;
              this.pZP = this.pZM;
              return;
            }
            catch (Exception paramArrayOfInt)
            {
              y.e("MicroMsg.Voip.CaptureRender", "mCamera.getParameters() or autoFocus fail!" + paramArrayOfInt.toString());
              return;
            }
          }
          bool1 = false;
          break label75;
          break;
          bool2 = false;
          break label119;
        }
      }
      if (this.qag != null) {
        break label774;
      }
      this.qag = paramArrayOfInt;
      i = 1;
      localObject = this.qag;
      j = Math.abs(localObject[0] - paramArrayOfInt[0]);
      k = Math.abs(localObject[1] - paramArrayOfInt[1]);
      m = Math.abs(localObject[2] - paramArrayOfInt[2]);
      k = Math.abs(localObject[3] - paramArrayOfInt[3]) + (j + k + m);
      y.d("MicroMsg.Voip.CaptureRender", "face location diff:%d", new Object[] { Integer.valueOf(k) });
      if (k <= pZL)
      {
        j = i;
        if (k <= pZK) {
          break label763;
        }
      }
      this.qag = paramArrayOfInt;
      if (k > pZL) {
        i = 1;
      }
      j = i;
      if (k <= pZK) {
        break label763;
      }
      j = 1;
      if ((i == 0) && (j == 0)) {
        break label772;
      }
      k = this.qag[0];
      m = this.qag[1];
      n = this.qag[2];
      i1 = this.qag[3];
    }
    for (;;)
    {
      try
      {
        paramArrayOfInt = new Rect(k, m, n, i1);
        localObject = this.mCamera.getParameters();
        k = j;
        if (j != 0)
        {
          if ((!d.gF(14)) || (((Camera.Parameters)localObject).getMaxNumMeteringAreas() <= 0)) {
            break label736;
          }
          localArrayList = new ArrayList();
          localArrayList.add(new Camera.Area(paramArrayOfInt, 1000));
          ((Camera.Parameters)localObject).setMeteringAreas(localArrayList);
          k = j;
        }
        j = i;
        if (i == 0) {
          break label779;
        }
        if ((!d.gF(14)) || (((Camera.Parameters)localObject).getMaxNumFocusAreas() <= 0)) {
          break label750;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area(paramArrayOfInt, 1000));
        ((Camera.Parameters)localObject).setFocusAreas(localArrayList);
        j = i;
      }
      catch (Exception paramArrayOfInt)
      {
        y.e("MicroMsg.Voip.CaptureRender", "focusOnFace exception:%s", new Object[] { paramArrayOfInt.getMessage() });
        return;
      }
      this.mCamera.setParameters((Camera.Parameters)localObject);
      if (j == 0) {
        break label20;
      }
      y.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", new Object[] { Boolean.valueOf(this.qai) });
      if (!this.qai) {
        break label20;
      }
      this.pZO = false;
      this.qai = false;
      this.mCamera.autoFocus(new a.1(this));
      return;
      label736:
      y.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
      k = 0;
      continue;
      label750:
      y.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
      j = 0;
      break label779;
      label763:
      k = 0;
      i = j;
      j = k;
      break label463;
      label772:
      break label20;
      label774:
      i = 0;
      break label333;
      label779:
      if (j == 0) {
        if (k == 0) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a
 * JD-Core Version:    0.7.0.1
 */