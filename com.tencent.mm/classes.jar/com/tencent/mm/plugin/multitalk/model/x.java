package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer;", "", "w", "", "h", "(II)V", "<set-?>", "cameraErrCode", "getCameraErrCode", "()I", "setCameraErrCode", "(I)V", "dispatchFrameData", "", "displayOrientation", "getDisplayOrientation", "setDisplayOrientation", "", "isCameraRemote180", "()Ljava/lang/Boolean;", "setCameraRemote180", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isCloudVoip", "()Z", "isCurrentFaceCamera", "setCurrentFaceCamera", "(Z)V", "isPreviewing", "setPreviewing", "isUesSurfacePreivew", "setUesSurfacePreivew", "mAutoFocusTimeOut", "", "getMAutoFocusTimeOut", "()J", "setMAutoFocusTimeOut", "(J)V", "mCallbackBufList", "", "getMCallbackBufList", "()Ljava/util/List;", "setMCallbackBufList", "(Ljava/util/List;)V", "mCamera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "getMCamera", "()Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "setMCamera", "(Lcom/tencent/mm/compatible/deviceinfo/MCamera;)V", "mCameraOpen", "getMCameraOpen", "setMCameraOpen", "mCameraOpenFaild", "getMCameraOpenFaild", "setMCameraOpenFaild", "mFormat", "getMFormat", "setMFormat", "mGetCameraDataCallback", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "getMGetCameraDataCallback", "()Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "setMGetCameraDataCallback", "(Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;)V", "mHeight", "getMHeight", "setMHeight", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "setMIsCameraNoParamAutoFocus", "mIsContinuousVideoMode", "getMIsContinuousVideoMode", "setMIsContinuousVideoMode", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mIsInCapture", "getMIsInCapture", "setMIsInCapture", "mIsLastAutoFocusFaceCamera", "getMIsLastAutoFocusFaceCamera", "setMIsLastAutoFocusFaceCamera", "mIsLastFocusFaceCamera", "getMIsLastFocusFaceCamera", "setMIsLastFocusFaceCamera", "mIsShouldStartCapture", "getMIsShouldStartCapture", "setMIsShouldStartCapture", "mLastAutoFocusTimestamp", "getMLastAutoFocusTimestamp", "setMLastAutoFocusTimestamp", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mParameters", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "getMParameters", "()Landroid/hardware/Camera$Parameters;", "setMParameters", "(Landroid/hardware/Camera$Parameters;)V", "mRotateTmpBuffer", "getMRotateTmpBuffer", "()[B", "setMRotateTmpBuffer", "([B)V", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getMSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setMSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "mWidth", "getMWidth", "setMWidth", "previewCallback", "Landroid/hardware/Camera$PreviewCallback;", "getPreviewCallback", "()Landroid/hardware/Camera$PreviewCallback;", "setPreviewCallback", "(Landroid/hardware/Camera$PreviewCallback;)V", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "previewSize", "getPreviewSize", "()Lcom/tencent/mm/compatible/deviceinfo/Size;", "setPreviewSize", "(Lcom/tencent/mm/compatible/deviceinfo/Size;)V", "supportMaxPixel", "getSupportMaxPixel", "setSupportMaxPixel", "supportMaxSizeHeight", "getSupportMaxSizeHeight", "setSupportMaxSizeHeight", "supportMaxSizeWidth", "getSupportMaxSizeWidth", "setSupportMaxSizeWidth", "bind", "", "surfaceTexture", "dumpCapInfo", "camera", "exchangeCapture", "exchangeToHignCapture", "is1280", "initCamera", "bFace", "initCapture", "dataCallback", "bFaceFirst", "safeOpenCamera", "safeSetFps", "cuFps", "startCaptureUseSurfaceHolder", "stopCapture", "testSupportFps", "tryPreviewSize", "trySetAutoFocus", "isFrontCamera", "CaptureRenderStatIDKey", "Companion", "plugin-multitalk_release"})
public final class x
{
  private static final Pattern zOp;
  public static final a zOq;
  public boolean imy;
  private int mHeight;
  SurfaceTexture mSurfaceTexture;
  private int mWidth;
  volatile v sZb;
  private boolean sZd;
  public boolean zNU;
  Boolean zNV;
  private long zNW;
  public int zNX;
  private Camera.Parameters zNY;
  ac zNZ;
  int zOa;
  private boolean zOb;
  private boolean zOc;
  private boolean zOd;
  public com.tencent.mm.plugin.voip.video.camera.a.b zOe;
  private boolean zOf;
  private boolean zOg;
  byte[] zOh;
  private List<byte[]> zOi;
  private int zOj;
  private int zOk;
  private int zOl;
  private boolean zOm;
  private byte[] zOn;
  private Camera.PreviewCallback zOo;
  
  static
  {
    AppMethodBeat.i(239652);
    zOq = new a((byte)0);
    zOp = Pattern.compile(",");
    AppMethodBeat.o(239652);
  }
  
  public x()
  {
    AppMethodBeat.i(239651);
    this.zNW = 30000L;
    this.mWidth = 320;
    this.mHeight = 240;
    this.imy = true;
    this.zOo = ((Camera.PreviewCallback)new b(this));
    this.mWidth = 640;
    this.mHeight = 480;
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    com.tencent.mm.plugin.voip.video.camera.a.c.hH(localContext.getApplicationContext());
    Log.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
    AppMethodBeat.o(239651);
  }
  
  private static boolean a(v paramv, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239645);
    if (paramv == null)
    {
      AppMethodBeat.o(239645);
      return false;
    }
    try
    {
      Camera.Parameters localParameters = paramv.getParameters();
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        localParameters.setPreviewSize(paramInt1, paramInt2);
      }
      paramv.setParameters(localParameters);
      AppMethodBeat.o(239645);
      return true;
    }
    catch (Exception paramv)
    {
      h.CyF.idkeyStat(159L, 0L, 1L, false);
      Log.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:".concat(String.valueOf(paramv)));
      AppMethodBeat.o(239645);
    }
    return false;
  }
  
  private final boolean b(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(239646);
    if (paramv == null)
    {
      AppMethodBeat.o(239646);
      return false;
    }
    Camera.Parameters localParameters;
    List localList;
    try
    {
      Log.i("MicroMsg.Voip.CaptureRender", "trySetAutoFocus, isFrontCamera:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      localParameters = paramv.getParameters();
      p.g(localParameters, "parameters");
      localList = localParameters.getSupportedFocusModes();
      if (localList == null) {
        break label226;
      }
      Log.i("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        Log.i("MicroMsg.Voip.CaptureRender", "supported focus modes : ".concat(String.valueOf((String)localIterator.next())));
      }
      if (ae.gKt.gGg != 0) {
        break label271;
      }
    }
    catch (Exception paramv)
    {
      h.CyF.idkeyStat(159L, 0L, 1L, false);
      Log.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:".concat(String.valueOf(paramv)));
      AppMethodBeat.o(239646);
      return false;
    }
    if (paramBoolean) {
      if (localList.contains("auto"))
      {
        Log.i("MicroMsg.Voip.CaptureRender", "camera support auto focus");
        localParameters.setFocusMode("auto");
        this.zOc = false;
      }
    }
    for (;;)
    {
      paramv.setParameters(localParameters);
      label226:
      AppMethodBeat.o(239646);
      return true;
      if (localList.contains("continuous-video"))
      {
        Log.i("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
        localParameters.setFocusMode("continuous-video");
        this.zOc = true;
        continue;
        label271:
        if ((ae.gKt.gGg == 1) || (!paramBoolean)) {
          if (localList.contains("continuous-video"))
          {
            Log.i("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
            localParameters.setFocusMode("continuous-video");
            this.zOc = true;
          }
          else if (localList.contains("auto"))
          {
            Log.i("MicroMsg.Voip.CaptureRender", "camera support auto focus");
            localParameters.setFocusMode("auto");
            this.zOc = false;
          }
        }
      }
    }
  }
  
  private final void eoa()
  {
    AppMethodBeat.i(239643);
    for (;;)
    {
      int i;
      try
      {
        if ((this.sZb != null) && (this.zOb))
        {
          if (this.zNZ != null)
          {
            localObject = this.zNZ;
            if (localObject == null) {
              p.hyc();
            }
            if (((ac)localObject).height > 0)
            {
              localObject = this.zNZ;
              if (localObject == null) {
                p.hyc();
              }
              if (((ac)localObject).width > 0)
              {
                localObject = this.zNZ;
                if (localObject == null) {
                  p.hyc();
                }
                i = ((ac)localObject).height;
                localObject = this.zNZ;
                if (localObject == null) {
                  p.hyc();
                }
                int j = i * ((ac)localObject).width * 3 / 2;
                if (this.zOi == null)
                {
                  this.zOi = ((List)new ArrayList(3));
                  i = 0;
                  if (i < 3)
                  {
                    localObject = this.zOi;
                    if (localObject == null) {
                      break label322;
                    }
                    ((List)localObject).add(new byte[j]);
                    break label322;
                  }
                }
                localObject = this.zOi;
                if (localObject == null) {
                  p.hyc();
                }
                j = ((Collection)localObject).size();
                i = 0;
                if (i < j)
                {
                  if (this.sZb == null) {
                    break label329;
                  }
                  localObject = this.sZb;
                  if (localObject == null) {
                    p.hyc();
                  }
                  List localList = this.zOi;
                  if (localList == null) {
                    p.hyc();
                  }
                  ((v)localObject).addCallbackBuffer((byte[])localList.get(i));
                  break label329;
                }
                localObject = this.sZb;
                if (localObject == null) {
                  p.hyc();
                }
                ((v)localObject).setPreviewCallbackWithBuffer(this.zOo);
                AppMethodBeat.o(239643);
                return;
              }
            }
          }
          Object localObject = this.sZb;
          if (localObject == null) {
            p.hyc();
          }
          ((v)localObject).setPreviewCallback(this.zOo);
          AppMethodBeat.o(239643);
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", (Throwable)localException, "setPreviewCallback error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(239643);
        return;
      }
      label322:
      i += 1;
      continue;
      label329:
      i += 1;
    }
  }
  
  /* Error */
  private int f(v paramv)
  {
    // Byte code:
    //   0: ldc_w 491
    //   3: invokestatic 219	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 491
    //   13: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_1
    //   19: invokevirtual 312	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   22: astore 5
    //   24: aload 5
    //   26: ldc_w 493
    //   29: invokestatic 273	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   32: aload 5
    //   34: invokevirtual 496	android/hardware/Camera$Parameters:getSupportedPreviewSizes	()Ljava/util/List;
    //   37: astore 5
    //   39: aload 5
    //   41: ifnull +271 -> 312
    //   44: aload 5
    //   46: invokeinterface 376 1 0
    //   51: ifeq +261 -> 312
    //   54: aload 5
    //   56: invokeinterface 390 1 0
    //   61: astore 5
    //   63: iconst_0
    //   64: istore_3
    //   65: iload_3
    //   66: istore_2
    //   67: iload_3
    //   68: istore 4
    //   70: aload 5
    //   72: invokeinterface 395 1 0
    //   77: ifeq +92 -> 169
    //   80: iload_3
    //   81: istore 4
    //   83: aload 5
    //   85: invokeinterface 401 1 0
    //   90: checkcast 498	android/hardware/Camera$Size
    //   93: astore 6
    //   95: iload_3
    //   96: istore 4
    //   98: ldc_w 286
    //   101: new 366	java/lang/StringBuilder
    //   104: dup
    //   105: ldc_w 500
    //   108: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: aload 6
    //   113: getfield 501	android/hardware/Camera$Size:width	I
    //   116: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: ldc 227
    //   121: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 6
    //   126: getfield 505	android/hardware/Camera$Size:height	I
    //   129: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: iload_3
    //   139: ifne +166 -> 305
    //   142: iload_3
    //   143: istore 4
    //   145: aload_0
    //   146: aload 6
    //   148: getfield 501	android/hardware/Camera$Size:width	I
    //   151: putfield 509	com/tencent/mm/plugin/multitalk/model/x:zOk	I
    //   154: iload_3
    //   155: istore 4
    //   157: aload_0
    //   158: aload 6
    //   160: getfield 505	android/hardware/Camera$Size:height	I
    //   163: putfield 511	com/tencent/mm/plugin/multitalk/model/x:zOl	I
    //   166: goto +139 -> 305
    //   169: iload_2
    //   170: istore 4
    //   172: aload_1
    //   173: invokevirtual 312	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   176: astore_1
    //   177: iload_2
    //   178: istore 4
    //   180: aload_1
    //   181: ldc_w 493
    //   184: invokestatic 273	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   187: iload_2
    //   188: istore 4
    //   190: aload_1
    //   191: invokevirtual 514	android/hardware/Camera$Parameters:getSupportedPreviewFormats	()Ljava/util/List;
    //   194: astore_1
    //   195: iload_2
    //   196: istore_3
    //   197: aload_1
    //   198: ifnull +92 -> 290
    //   201: iload_2
    //   202: istore 4
    //   204: iload_2
    //   205: istore_3
    //   206: aload_1
    //   207: invokeinterface 376 1 0
    //   212: ifeq +78 -> 290
    //   215: iload_2
    //   216: istore 4
    //   218: aload_1
    //   219: invokeinterface 390 1 0
    //   224: astore_1
    //   225: iload_2
    //   226: istore 4
    //   228: iload_2
    //   229: istore_3
    //   230: aload_1
    //   231: invokeinterface 395 1 0
    //   236: ifeq +54 -> 290
    //   239: iload_2
    //   240: istore 4
    //   242: ldc_w 286
    //   245: ldc_w 516
    //   248: aload_1
    //   249: invokeinterface 401 1 0
    //   254: checkcast 290	java/lang/Integer
    //   257: invokestatic 338	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   260: invokevirtual 342	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   263: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: goto -41 -> 225
    //   269: astore_1
    //   270: ldc_w 286
    //   273: aload_1
    //   274: checkcast 477	java/lang/Throwable
    //   277: ldc_w 517
    //   280: iconst_0
    //   281: anewarray 4	java/lang/Object
    //   284: invokestatic 486	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: iload 4
    //   289: istore_3
    //   290: ldc_w 491
    //   293: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: iload_3
    //   297: ireturn
    //   298: astore_1
    //   299: iconst_0
    //   300: istore 4
    //   302: goto -32 -> 270
    //   305: iload_3
    //   306: iconst_1
    //   307: iadd
    //   308: istore_3
    //   309: goto -244 -> 65
    //   312: iconst_0
    //   313: istore_2
    //   314: goto -145 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	x
    //   0	317	1	paramv	v
    //   66	248	2	i	int
    //   64	245	3	j	int
    //   68	233	4	k	int
    //   22	62	5	localObject	Object
    //   93	66	6	localSize	android.hardware.Camera.Size
    // Exception table:
    //   from	to	target	type
    //   70	80	269	java/lang/Exception
    //   83	95	269	java/lang/Exception
    //   98	138	269	java/lang/Exception
    //   145	154	269	java/lang/Exception
    //   157	166	269	java/lang/Exception
    //   172	177	269	java/lang/Exception
    //   180	187	269	java/lang/Exception
    //   190	195	269	java/lang/Exception
    //   206	215	269	java/lang/Exception
    //   218	225	269	java/lang/Exception
    //   230	239	269	java/lang/Exception
    //   242	266	269	java/lang/Exception
    //   18	39	298	java/lang/Exception
    //   44	63	298	java/lang/Exception
  }
  
  /* Error */
  private final int h(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 519
    //   3: invokestatic 219	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 286
    //   9: ldc_w 521
    //   12: iload_1
    //   13: invokestatic 524	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   16: invokevirtual 342	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 427	com/tencent/mm/plugin/multitalk/model/x:zOc	Z
    //   27: iconst_1
    //   28: istore 17
    //   30: iload 17
    //   32: istore 16
    //   34: aload_0
    //   35: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   38: ifnull +100 -> 138
    //   41: aload_0
    //   42: getfield 526	com/tencent/mm/plugin/multitalk/model/x:zNU	Z
    //   45: iload_1
    //   46: if_icmpeq +126 -> 172
    //   49: aload_0
    //   50: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   53: astore 18
    //   55: aload 18
    //   57: ifnonnull +6 -> 63
    //   60: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   63: aload 18
    //   65: getfield 529	com/tencent/mm/compatible/deviceinfo/v:gIJ	Z
    //   68: ifne +23 -> 91
    //   71: aload_0
    //   72: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   75: astore 18
    //   77: aload 18
    //   79: ifnonnull +6 -> 85
    //   82: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   85: aload 18
    //   87: aconst_null
    //   88: invokevirtual 475	com/tencent/mm/compatible/deviceinfo/v:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   91: aload_0
    //   92: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   95: astore 18
    //   97: aload 18
    //   99: ifnonnull +6 -> 105
    //   102: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   105: aload 18
    //   107: invokevirtual 532	com/tencent/mm/compatible/deviceinfo/v:stopPreview	()V
    //   110: aload_0
    //   111: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   114: astore 18
    //   116: aload 18
    //   118: ifnonnull +6 -> 124
    //   121: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   124: aload 18
    //   126: invokevirtual 535	com/tencent/mm/compatible/deviceinfo/v:release	()V
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   134: iload 17
    //   136: istore 16
    //   138: iload 16
    //   140: ifeq +46 -> 186
    //   143: aload_0
    //   144: aload_0
    //   145: iload_1
    //   146: invokespecial 539	com/tencent/mm/plugin/multitalk/model/x:rO	(Z)Lcom/tencent/mm/compatible/deviceinfo/v;
    //   149: putfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   152: aload_0
    //   153: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   156: ifnonnull +25 -> 181
    //   159: aload_0
    //   160: iconst_0
    //   161: putfield 437	com/tencent/mm/plugin/multitalk/model/x:zOb	Z
    //   164: ldc_w 519
    //   167: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: iconst_m1
    //   171: ireturn
    //   172: aload_0
    //   173: getfield 541	com/tencent/mm/plugin/multitalk/model/x:zOm	Z
    //   176: istore 16
    //   178: goto -40 -> 138
    //   181: aload_0
    //   182: iconst_0
    //   183: putfield 541	com/tencent/mm/plugin/multitalk/model/x:zOm	Z
    //   186: aload_0
    //   187: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   190: ifnull +23 -> 213
    //   193: aload_0
    //   194: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   197: astore 18
    //   199: aload 18
    //   201: ifnonnull +6 -> 207
    //   204: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   207: aload 18
    //   209: invokevirtual 312	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   212: pop
    //   213: aload_0
    //   214: iconst_1
    //   215: putfield 437	com/tencent/mm/plugin/multitalk/model/x:zOb	Z
    //   218: aload_0
    //   219: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   222: astore 18
    //   224: getstatic 545	com/tencent/mm/plugin/voip/video/camera/a/c:Hjw	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   227: astore 19
    //   229: aload 19
    //   231: ldc_w 547
    //   234: invokestatic 273	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   237: aload 19
    //   239: invokevirtual 552	com/tencent/mm/plugin/voip/video/camera/prev/b:fLs	()I
    //   242: istore 11
    //   244: aload 18
    //   246: ifnull +283 -> 529
    //   249: bipush 26
    //   251: istore 4
    //   253: ldc_w 286
    //   256: ldc_w 554
    //   259: iconst_1
    //   260: anewarray 4	java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: iload 11
    //   267: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aastore
    //   271: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: aload 18
    //   276: invokevirtual 312	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   279: astore 19
    //   281: invokestatic 557	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   284: ifeq +39 -> 323
    //   287: ldc_w 559
    //   290: invokestatic 565	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   293: astore 20
    //   295: aload 20
    //   297: ldc_w 567
    //   300: invokestatic 273	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   303: aload 20
    //   305: checkcast 559	com/tencent/mm/plugin/zero/b/a
    //   308: invokeinterface 571 1 0
    //   313: ldc_w 573
    //   316: bipush 26
    //   318: invokevirtual 579	com/tencent/mm/n/f:getInt	(Ljava/lang/String;I)I
    //   321: istore 4
    //   323: ldc_w 286
    //   326: ldc_w 581
    //   329: iconst_1
    //   330: anewarray 4	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: iload 4
    //   337: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: aastore
    //   341: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   344: invokestatic 586	com/tencent/mm/compatible/util/k:alh	()Z
    //   347: ifne +11 -> 358
    //   350: iload 4
    //   352: invokestatic 592	com/tencent/mm/compatible/util/d:oD	(I)Z
    //   355: ifeq +1255 -> 1610
    //   358: ldc_w 593
    //   361: istore 6
    //   363: iconst_0
    //   364: istore 16
    //   366: iconst_m1
    //   367: istore 8
    //   369: iconst_0
    //   370: istore 7
    //   372: getstatic 409	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   375: ifnull +2025 -> 2400
    //   378: getstatic 409	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   381: getfield 596	com/tencent/mm/compatible/deviceinfo/c:gGk	I
    //   384: sipush 1000
    //   387: imul
    //   388: istore 8
    //   390: getstatic 409	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   393: getfield 599	com/tencent/mm/compatible/deviceinfo/c:gGl	I
    //   396: sipush 1000
    //   399: imul
    //   400: istore 7
    //   402: goto +1998 -> 2400
    //   405: ldc_w 286
    //   408: ldc_w 601
    //   411: iconst_4
    //   412: anewarray 4	java/lang/Object
    //   415: dup
    //   416: iconst_0
    //   417: iload 8
    //   419: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   422: aastore
    //   423: dup
    //   424: iconst_1
    //   425: iload 7
    //   427: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   430: aastore
    //   431: dup
    //   432: iconst_2
    //   433: iload 11
    //   435: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   438: aastore
    //   439: dup
    //   440: iconst_3
    //   441: iload 17
    //   443: invokestatic 357	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   446: aastore
    //   447: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   450: iload 8
    //   452: ldc_w 593
    //   455: if_icmpeq +16 -> 471
    //   458: iload 7
    //   460: ldc_w 593
    //   463: if_icmpeq +8 -> 471
    //   466: iload 17
    //   468: ifne +1083 -> 1551
    //   471: iconst_1
    //   472: istore 4
    //   474: iload 4
    //   476: ifeq +53 -> 529
    //   479: ldc_w 286
    //   482: ldc_w 603
    //   485: iconst_1
    //   486: anewarray 4	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: iload 11
    //   493: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   496: aastore
    //   497: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   500: aload 18
    //   502: invokevirtual 312	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   505: astore 19
    //   507: aload 19
    //   509: ldc_w 361
    //   512: invokestatic 273	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   515: aload 19
    //   517: iload 11
    //   519: invokevirtual 606	android/hardware/Camera$Parameters:setPreviewFrameRate	(I)V
    //   522: aload 18
    //   524: aload 19
    //   526: invokevirtual 319	com/tencent/mm/compatible/deviceinfo/v:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   529: ldc_w 286
    //   532: new 366	java/lang/StringBuilder
    //   535: dup
    //   536: ldc_w 608
    //   539: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   542: iload_2
    //   543: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: bipush 44
    //   548: invokevirtual 611	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   551: iload_3
    //   552: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   555: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: iload_1
    //   562: ifeq +1101 -> 1663
    //   565: getstatic 545	com/tencent/mm/plugin/voip/video/camera/a/c:Hjw	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   568: astore 18
    //   570: aload 18
    //   572: ldc_w 547
    //   575: invokestatic 273	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   578: aload 18
    //   580: invokevirtual 615	com/tencent/mm/plugin/voip/video/camera/prev/b:fLq	()Landroid/graphics/Point;
    //   583: astore 18
    //   585: aload 18
    //   587: ifnull +1099 -> 1686
    //   590: iconst_1
    //   591: istore 4
    //   593: aconst_null
    //   594: astore 21
    //   596: aload 18
    //   598: ifnull +1781 -> 2379
    //   601: new 444	com/tencent/mm/compatible/deviceinfo/ac
    //   604: dup
    //   605: aload 18
    //   607: getfield 620	android/graphics/Point:x	I
    //   610: aload 18
    //   612: getfield 623	android/graphics/Point:y	I
    //   615: invokespecial 625	com/tencent/mm/compatible/deviceinfo/ac:<init>	(II)V
    //   618: astore 19
    //   620: ldc_w 286
    //   623: new 366	java/lang/StringBuilder
    //   626: dup
    //   627: ldc_w 627
    //   630: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   633: aload 19
    //   635: getfield 450	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   638: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   641: ldc 227
    //   643: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload 19
    //   648: getfield 447	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   651: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   654: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   660: aload_0
    //   661: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   664: astore 18
    //   666: aload 18
    //   668: ifnonnull +6 -> 674
    //   671: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   674: aload 18
    //   676: invokevirtual 312	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   679: astore 23
    //   681: new 617	android/graphics/Point
    //   684: dup
    //   685: iload_2
    //   686: iload_3
    //   687: invokespecial 628	android/graphics/Point:<init>	(II)V
    //   690: astore 22
    //   692: aload 23
    //   694: ldc_w 630
    //   697: invokevirtual 632	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   700: astore 20
    //   702: aload 20
    //   704: astore 18
    //   706: aload 20
    //   708: ifnonnull +13 -> 721
    //   711: aload 23
    //   713: ldc_w 634
    //   716: invokevirtual 632	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   719: astore 18
    //   721: aload 18
    //   723: ifnull +1650 -> 2373
    //   726: ldc_w 286
    //   729: ldc_w 636
    //   732: aload 18
    //   734: invokestatic 338	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   737: invokevirtual 342	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   740: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   743: aload 18
    //   745: checkcast 638	java/lang/CharSequence
    //   748: aload 22
    //   750: invokestatic 641	com/tencent/mm/plugin/multitalk/model/x$a:a	(Ljava/lang/CharSequence;Landroid/graphics/Point;)Landroid/graphics/Point;
    //   753: astore 18
    //   755: aload 18
    //   757: astore 20
    //   759: aload 18
    //   761: ifnonnull +30 -> 791
    //   764: new 617	android/graphics/Point
    //   767: dup
    //   768: aload 22
    //   770: getfield 620	android/graphics/Point:x	I
    //   773: iconst_3
    //   774: ishr
    //   775: iconst_3
    //   776: ishl
    //   777: aload 22
    //   779: getfield 623	android/graphics/Point:y	I
    //   782: iconst_3
    //   783: ishr
    //   784: iconst_3
    //   785: ishl
    //   786: invokespecial 628	android/graphics/Point:<init>	(II)V
    //   789: astore 20
    //   791: new 444	com/tencent/mm/compatible/deviceinfo/ac
    //   794: dup
    //   795: aload 20
    //   797: getfield 620	android/graphics/Point:x	I
    //   800: aload 20
    //   802: getfield 623	android/graphics/Point:y	I
    //   805: invokespecial 625	com/tencent/mm/compatible/deviceinfo/ac:<init>	(II)V
    //   808: astore 18
    //   810: ldc_w 286
    //   813: new 366	java/lang/StringBuilder
    //   816: dup
    //   817: ldc_w 643
    //   820: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   823: aload 18
    //   825: getfield 450	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   828: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   831: ldc 227
    //   833: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload 18
    //   838: getfield 447	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   841: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   844: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   850: iload 4
    //   852: ifeq +870 -> 1722
    //   855: aload_0
    //   856: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   859: astore 20
    //   861: aload 19
    //   863: ifnonnull +6 -> 869
    //   866: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   869: aload 20
    //   871: aload 19
    //   873: getfield 450	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   876: aload 19
    //   878: getfield 447	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   881: invokestatic 645	com/tencent/mm/plugin/multitalk/model/x:a	(Lcom/tencent/mm/compatible/deviceinfo/v;II)Z
    //   884: istore_1
    //   885: ldc_w 286
    //   888: new 366	java/lang/StringBuilder
    //   891: dup
    //   892: ldc_w 647
    //   895: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   898: aload 19
    //   900: getfield 450	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   903: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   906: ldc_w 649
    //   909: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload 19
    //   914: getfield 447	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   917: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   926: iload_1
    //   927: ifne +919 -> 1846
    //   930: aload 18
    //   932: ifnull +914 -> 1846
    //   935: ldc_w 286
    //   938: new 366	java/lang/StringBuilder
    //   941: dup
    //   942: ldc_w 651
    //   945: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   948: aload 18
    //   950: getfield 450	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   953: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   956: ldc_w 649
    //   959: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: aload 18
    //   964: getfield 447	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   967: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   970: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   973: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   976: aload_0
    //   977: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   980: aload 18
    //   982: getfield 450	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   985: aload 18
    //   987: getfield 447	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   990: invokestatic 645	com/tencent/mm/plugin/multitalk/model/x:a	(Lcom/tencent/mm/compatible/deviceinfo/v;II)Z
    //   993: ifne +853 -> 1846
    //   996: ldc_w 286
    //   999: new 366	java/lang/StringBuilder
    //   1002: dup
    //   1003: ldc_w 653
    //   1006: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1009: aload 18
    //   1011: getfield 450	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   1014: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1017: ldc_w 649
    //   1020: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: aload 18
    //   1025: getfield 447	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   1028: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1031: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1034: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1037: ldc_w 519
    //   1040: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1043: iconst_m1
    //   1044: ireturn
    //   1045: astore 18
    //   1047: getstatic 325	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   1050: ldc2_w 326
    //   1053: lconst_0
    //   1054: lconst_1
    //   1055: iconst_0
    //   1056: invokevirtual 331	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1059: ldc_w 286
    //   1062: ldc_w 655
    //   1065: iconst_1
    //   1066: anewarray 4	java/lang/Object
    //   1069: dup
    //   1070: iconst_0
    //   1071: aload 18
    //   1073: invokevirtual 482	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1076: aastore
    //   1077: invokestatic 657	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1080: aload_0
    //   1081: getfield 659	com/tencent/mm/plugin/multitalk/model/x:zOe	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   1084: ifnull +114 -> 1198
    //   1087: aload_0
    //   1088: getfield 659	com/tencent/mm/plugin/multitalk/model/x:zOe	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   1091: astore 19
    //   1093: aload 19
    //   1095: ifnonnull +6 -> 1101
    //   1098: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   1101: aload 19
    //   1103: invokeinterface 664 1 0
    //   1108: aload_0
    //   1109: iconst_1
    //   1110: putfield 541	com/tencent/mm/plugin/multitalk/model/x:zOm	Z
    //   1113: aload_0
    //   1114: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1117: astore 19
    //   1119: aload 19
    //   1121: ifnonnull +6 -> 1127
    //   1124: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   1127: aload 19
    //   1129: getfield 529	com/tencent/mm/compatible/deviceinfo/v:gIJ	Z
    //   1132: ifne +23 -> 1155
    //   1135: aload_0
    //   1136: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1139: astore 19
    //   1141: aload 19
    //   1143: ifnonnull +6 -> 1149
    //   1146: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   1149: aload 19
    //   1151: aconst_null
    //   1152: invokevirtual 475	com/tencent/mm/compatible/deviceinfo/v:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   1155: aload_0
    //   1156: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1159: astore 19
    //   1161: aload 19
    //   1163: ifnonnull +6 -> 1169
    //   1166: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   1169: aload 19
    //   1171: invokevirtual 532	com/tencent/mm/compatible/deviceinfo/v:stopPreview	()V
    //   1174: aload_0
    //   1175: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1178: astore 19
    //   1180: aload 19
    //   1182: ifnonnull +6 -> 1188
    //   1185: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   1188: aload 19
    //   1190: invokevirtual 535	com/tencent/mm/compatible/deviceinfo/v:release	()V
    //   1193: aload_0
    //   1194: aconst_null
    //   1195: putfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1198: ldc_w 519
    //   1201: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1204: iconst_m1
    //   1205: ireturn
    //   1206: astore 19
    //   1208: ldc_w 286
    //   1211: aload 19
    //   1213: checkcast 477	java/lang/Throwable
    //   1216: ldc_w 666
    //   1219: iconst_1
    //   1220: anewarray 4	java/lang/Object
    //   1223: dup
    //   1224: iconst_0
    //   1225: aload 18
    //   1227: invokevirtual 482	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1230: aastore
    //   1231: invokestatic 486	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1234: goto -36 -> 1198
    //   1237: iload 8
    //   1239: ifne +24 -> 1263
    //   1242: iload 7
    //   1244: ifne +19 -> 1263
    //   1247: iconst_0
    //   1248: istore 17
    //   1250: ldc_w 667
    //   1253: istore 7
    //   1255: ldc_w 667
    //   1258: istore 8
    //   1260: goto -855 -> 405
    //   1263: aload 19
    //   1265: ldc_w 361
    //   1268: invokestatic 273	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1271: aload 19
    //   1273: invokevirtual 670	android/hardware/Camera$Parameters:getSupportedPreviewFpsRange	()Ljava/util/List;
    //   1276: astore 20
    //   1278: aload 20
    //   1280: ifnull +1143 -> 2423
    //   1283: aload 20
    //   1285: invokeinterface 376 1 0
    //   1290: ifne +6 -> 1296
    //   1293: goto +1130 -> 2423
    //   1296: aload 20
    //   1298: invokeinterface 376 1 0
    //   1303: istore 12
    //   1305: iconst_0
    //   1306: istore 9
    //   1308: ldc_w 667
    //   1311: istore 5
    //   1313: ldc_w 667
    //   1316: istore 4
    //   1318: iload 16
    //   1320: istore 17
    //   1322: iload 5
    //   1324: istore 7
    //   1326: iload 4
    //   1328: istore 8
    //   1330: iload 9
    //   1332: iload 12
    //   1334: if_icmpge -929 -> 405
    //   1337: aload 20
    //   1339: iload 9
    //   1341: invokeinterface 466 2 0
    //   1346: checkcast 672	[I
    //   1349: astore 21
    //   1351: aload 21
    //   1353: ifnull +1076 -> 2429
    //   1356: aload 21
    //   1358: arraylength
    //   1359: iconst_1
    //   1360: if_icmpgt +6 -> 1366
    //   1363: goto +1066 -> 2429
    //   1366: aload 21
    //   1368: iconst_0
    //   1369: iaload
    //   1370: istore 8
    //   1372: aload 21
    //   1374: iconst_1
    //   1375: iaload
    //   1376: istore 10
    //   1378: ldc_w 286
    //   1381: ldc_w 674
    //   1384: iconst_3
    //   1385: anewarray 4	java/lang/Object
    //   1388: dup
    //   1389: iconst_0
    //   1390: iload 9
    //   1392: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1395: aastore
    //   1396: dup
    //   1397: iconst_1
    //   1398: iload 8
    //   1400: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1403: aastore
    //   1404: dup
    //   1405: iconst_2
    //   1406: iload 10
    //   1408: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1411: aastore
    //   1412: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1415: iload 8
    //   1417: iflt +1045 -> 2462
    //   1420: iload 10
    //   1422: iload 8
    //   1424: if_icmpge +6 -> 1430
    //   1427: goto +1035 -> 2462
    //   1430: iload 10
    //   1432: sipush 1000
    //   1435: idiv
    //   1436: istore 13
    //   1438: iload 8
    //   1440: sipush 1000
    //   1443: idiv
    //   1444: istore 14
    //   1446: iload 11
    //   1448: iconst_5
    //   1449: iadd
    //   1450: bipush 30
    //   1452: invokestatic 680	java/lang/Math:min	(II)I
    //   1455: istore 7
    //   1457: iload 11
    //   1459: iconst_5
    //   1460: isub
    //   1461: iconst_5
    //   1462: invokestatic 683	java/lang/Math:max	(II)I
    //   1465: istore 15
    //   1467: iload 13
    //   1469: iload 15
    //   1471: if_icmplt +1006 -> 2477
    //   1474: iload 13
    //   1476: iload 7
    //   1478: if_icmpgt +999 -> 2477
    //   1481: iload 14
    //   1483: iload 15
    //   1485: if_icmplt +992 -> 2477
    //   1488: iload 14
    //   1490: iload 7
    //   1492: if_icmpgt +985 -> 2477
    //   1495: iconst_1
    //   1496: istore 7
    //   1498: iload 7
    //   1500: ifeq +885 -> 2385
    //   1503: iload 11
    //   1505: iload 14
    //   1507: isub
    //   1508: invokestatic 687	java/lang/Math:abs	(I)I
    //   1511: istore 7
    //   1513: iload 13
    //   1515: iload 11
    //   1517: isub
    //   1518: invokestatic 687	java/lang/Math:abs	(I)I
    //   1521: iload 7
    //   1523: iadd
    //   1524: istore 7
    //   1526: iload 7
    //   1528: iload 6
    //   1530: if_icmpge +855 -> 2385
    //   1533: iconst_1
    //   1534: istore 16
    //   1536: iload 7
    //   1538: istore 4
    //   1540: iload 10
    //   1542: istore 5
    //   1544: iload 8
    //   1546: istore 6
    //   1548: goto +893 -> 2441
    //   1551: ldc_w 286
    //   1554: ldc_w 689
    //   1557: iconst_3
    //   1558: anewarray 4	java/lang/Object
    //   1561: dup
    //   1562: iconst_0
    //   1563: iload 8
    //   1565: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1568: aastore
    //   1569: dup
    //   1570: iconst_1
    //   1571: iload 7
    //   1573: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1576: aastore
    //   1577: dup
    //   1578: iconst_2
    //   1579: iload 11
    //   1581: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1584: aastore
    //   1585: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1588: aload 19
    //   1590: iload 8
    //   1592: iload 7
    //   1594: invokevirtual 692	android/hardware/Camera$Parameters:setPreviewFpsRange	(II)V
    //   1597: aload 18
    //   1599: aload 19
    //   1601: invokevirtual 319	com/tencent/mm/compatible/deviceinfo/v:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   1604: iconst_0
    //   1605: istore 4
    //   1607: goto -1133 -> 474
    //   1610: iconst_1
    //   1611: istore 4
    //   1613: goto -1139 -> 474
    //   1616: astore 19
    //   1618: ldc_w 286
    //   1621: ldc_w 694
    //   1624: aload 19
    //   1626: invokestatic 338	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1629: invokevirtual 342	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1632: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1635: iconst_1
    //   1636: istore 4
    //   1638: goto -1164 -> 474
    //   1641: astore 18
    //   1643: ldc_w 286
    //   1646: ldc_w 696
    //   1649: aload 18
    //   1651: invokestatic 338	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1654: invokevirtual 342	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1657: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1660: goto -1131 -> 529
    //   1663: getstatic 545	com/tencent/mm/plugin/voip/video/camera/a/c:Hjw	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   1666: astore 18
    //   1668: aload 18
    //   1670: ldc_w 547
    //   1673: invokestatic 273	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1676: aload 18
    //   1678: invokevirtual 699	com/tencent/mm/plugin/voip/video/camera/prev/b:fLr	()Landroid/graphics/Point;
    //   1681: astore 18
    //   1683: goto -1098 -> 585
    //   1686: iconst_0
    //   1687: istore 4
    //   1689: goto -1096 -> 593
    //   1692: astore 20
    //   1694: aload 21
    //   1696: astore 18
    //   1698: ldc_w 286
    //   1701: ldc_w 701
    //   1704: iconst_1
    //   1705: anewarray 4	java/lang/Object
    //   1708: dup
    //   1709: iconst_0
    //   1710: aload 20
    //   1712: invokevirtual 482	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1715: aastore
    //   1716: invokestatic 657	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1719: goto -869 -> 850
    //   1722: ldc_w 286
    //   1725: ldc_w 703
    //   1728: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1731: aload 18
    //   1733: ifnull +113 -> 1846
    //   1736: ldc_w 286
    //   1739: new 366	java/lang/StringBuilder
    //   1742: dup
    //   1743: ldc_w 705
    //   1746: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1749: aload 18
    //   1751: getfield 450	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   1754: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1757: ldc_w 649
    //   1760: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: aload 18
    //   1765: getfield 447	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   1768: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1771: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1774: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1777: aload_0
    //   1778: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1781: aload 18
    //   1783: getfield 450	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   1786: aload 18
    //   1788: getfield 447	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   1791: invokestatic 645	com/tencent/mm/plugin/multitalk/model/x:a	(Lcom/tencent/mm/compatible/deviceinfo/v;II)Z
    //   1794: ifne +52 -> 1846
    //   1797: ldc_w 286
    //   1800: new 366	java/lang/StringBuilder
    //   1803: dup
    //   1804: ldc_w 707
    //   1807: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1810: aload 18
    //   1812: getfield 450	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   1815: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1818: ldc_w 649
    //   1821: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1824: aload 18
    //   1826: getfield 447	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   1829: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1832: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1835: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1838: ldc_w 519
    //   1841: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1844: iconst_m1
    //   1845: ireturn
    //   1846: aload_0
    //   1847: aload_0
    //   1848: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1851: aload_0
    //   1852: getfield 526	com/tencent/mm/plugin/multitalk/model/x:zNU	Z
    //   1855: invokespecial 709	com/tencent/mm/plugin/multitalk/model/x:b	(Lcom/tencent/mm/compatible/deviceinfo/v;Z)Z
    //   1858: pop
    //   1859: aload_0
    //   1860: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1863: astore 18
    //   1865: aload 18
    //   1867: ifnonnull +6 -> 1873
    //   1870: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   1873: aload_0
    //   1874: aload 18
    //   1876: invokevirtual 312	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   1879: putfield 711	com/tencent/mm/plugin/multitalk/model/x:zNY	Landroid/hardware/Camera$Parameters;
    //   1882: aload_0
    //   1883: getfield 711	com/tencent/mm/plugin/multitalk/model/x:zNY	Landroid/hardware/Camera$Parameters;
    //   1886: astore 18
    //   1888: aload 18
    //   1890: ifnull +277 -> 2167
    //   1893: aload 18
    //   1895: invokevirtual 714	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   1898: astore 18
    //   1900: aload 18
    //   1902: ifnull +24 -> 1926
    //   1905: aload_0
    //   1906: new 444	com/tencent/mm/compatible/deviceinfo/ac
    //   1909: dup
    //   1910: aload 18
    //   1912: getfield 501	android/hardware/Camera$Size:width	I
    //   1915: aload 18
    //   1917: getfield 505	android/hardware/Camera$Size:height	I
    //   1920: invokespecial 625	com/tencent/mm/compatible/deviceinfo/ac:<init>	(II)V
    //   1923: putfield 439	com/tencent/mm/plugin/multitalk/model/x:zNZ	Lcom/tencent/mm/compatible/deviceinfo/ac;
    //   1926: aload_0
    //   1927: getfield 711	com/tencent/mm/plugin/multitalk/model/x:zNY	Landroid/hardware/Camera$Parameters;
    //   1930: astore 18
    //   1932: aload 18
    //   1934: ifnull +282 -> 2216
    //   1937: aload 18
    //   1939: invokevirtual 717	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   1942: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1945: astore 18
    //   1947: aload_0
    //   1948: getstatic 720	com/tencent/mm/plugin/voip/video/camera/a/c:HjB	I
    //   1951: putfield 722	com/tencent/mm/plugin/multitalk/model/x:zOa	I
    //   1954: aload_0
    //   1955: getfield 722	com/tencent/mm/plugin/multitalk/model/x:zOa	I
    //   1958: ifgt +9 -> 1967
    //   1961: aload_0
    //   1962: bipush 7
    //   1964: putfield 722	com/tencent/mm/plugin/multitalk/model/x:zOa	I
    //   1967: aload_0
    //   1968: getfield 435	com/tencent/mm/plugin/multitalk/model/x:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1971: astore 19
    //   1973: new 724	android/hardware/Camera$CameraInfo
    //   1976: dup
    //   1977: invokespecial 725	android/hardware/Camera$CameraInfo:<init>	()V
    //   1980: astore 20
    //   1982: aload_0
    //   1983: getfield 526	com/tencent/mm/plugin/multitalk/model/x:zNU	Z
    //   1986: ifeq +236 -> 2222
    //   1989: getstatic 728	com/tencent/mm/plugin/voip/video/camera/a/c:Hjx	I
    //   1992: istore_2
    //   1993: iload_2
    //   1994: aload 20
    //   1996: invokestatic 734	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   1999: invokestatic 265	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2002: ldc_w 736
    //   2005: invokevirtual 740	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2008: astore 21
    //   2010: aload 21
    //   2012: ifnonnull +217 -> 2229
    //   2015: new 742	kotlin/t
    //   2018: dup
    //   2019: ldc_w 744
    //   2022: invokespecial 745	kotlin/t:<init>	(Ljava/lang/String;)V
    //   2025: astore 19
    //   2027: ldc_w 519
    //   2030: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2033: aload 19
    //   2035: athrow
    //   2036: astore 19
    //   2038: ldc_w 286
    //   2041: ldc_w 747
    //   2044: iconst_1
    //   2045: anewarray 4	java/lang/Object
    //   2048: dup
    //   2049: iconst_0
    //   2050: aload 19
    //   2052: invokevirtual 482	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2055: aastore
    //   2056: invokestatic 657	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2059: aload_0
    //   2060: getfield 439	com/tencent/mm/plugin/multitalk/model/x:zNZ	Lcom/tencent/mm/compatible/deviceinfo/ac;
    //   2063: astore 19
    //   2065: aload 19
    //   2067: ifnull +289 -> 2356
    //   2070: aload 19
    //   2072: getfield 450	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   2075: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2078: astore 19
    //   2080: aload_0
    //   2081: getfield 439	com/tencent/mm/plugin/multitalk/model/x:zNZ	Lcom/tencent/mm/compatible/deviceinfo/ac;
    //   2084: astore 20
    //   2086: aload 20
    //   2088: ifnull +274 -> 2362
    //   2091: aload 20
    //   2093: getfield 447	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   2096: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2099: astore 20
    //   2101: ldc_w 286
    //   2104: ldc_w 749
    //   2107: bipush 6
    //   2109: anewarray 4	java/lang/Object
    //   2112: dup
    //   2113: iconst_0
    //   2114: aload 18
    //   2116: aastore
    //   2117: dup
    //   2118: iconst_1
    //   2119: aload 19
    //   2121: aastore
    //   2122: dup
    //   2123: iconst_2
    //   2124: aload 20
    //   2126: aastore
    //   2127: dup
    //   2128: iconst_3
    //   2129: aload_0
    //   2130: getfield 722	com/tencent/mm/plugin/multitalk/model/x:zOa	I
    //   2133: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2136: aastore
    //   2137: dup
    //   2138: iconst_4
    //   2139: getstatic 752	com/tencent/mm/plugin/voip/video/camera/a/c:Hjz	I
    //   2142: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2145: aastore
    //   2146: dup
    //   2147: iconst_5
    //   2148: aload_0
    //   2149: getfield 754	com/tencent/mm/plugin/multitalk/model/x:zOj	I
    //   2152: invokestatic 294	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2155: aastore
    //   2156: invokestatic 359	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2159: ldc_w 519
    //   2162: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2165: iconst_1
    //   2166: ireturn
    //   2167: aconst_null
    //   2168: astore 18
    //   2170: goto -270 -> 1900
    //   2173: astore 18
    //   2175: getstatic 325	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   2178: ldc2_w 326
    //   2181: lconst_0
    //   2182: lconst_1
    //   2183: iconst_0
    //   2184: invokevirtual 331	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2187: ldc_w 286
    //   2190: ldc_w 756
    //   2193: iconst_1
    //   2194: anewarray 4	java/lang/Object
    //   2197: dup
    //   2198: iconst_0
    //   2199: aload 18
    //   2201: invokevirtual 482	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2204: aastore
    //   2205: invokestatic 657	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2208: ldc_w 519
    //   2211: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2214: iconst_m1
    //   2215: ireturn
    //   2216: aconst_null
    //   2217: astore 18
    //   2219: goto -272 -> 1947
    //   2222: getstatic 759	com/tencent/mm/plugin/voip/video/camera/a/c:Hjy	I
    //   2225: istore_2
    //   2226: goto -233 -> 1993
    //   2229: aload 21
    //   2231: checkcast 761	android/view/WindowManager
    //   2234: invokeinterface 765 1 0
    //   2239: astore 21
    //   2241: aload 21
    //   2243: ldc_w 767
    //   2246: invokestatic 273	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   2249: aload 21
    //   2251: invokevirtual 772	android/view/Display:getRotation	()I
    //   2254: istore_3
    //   2255: iconst_0
    //   2256: istore_2
    //   2257: iload_3
    //   2258: tableswitch	default:+225 -> 2483, 0:+228->2486, 1:+233->2491, 2:+239->2497, 3:+246->2504
    //   2289: getfield 526	com/tencent/mm/plugin/multitalk/model/x:zNU	Z
    //   2292: ifeq +45 -> 2337
    //   2295: sipush 360
    //   2298: iload_2
    //   2299: aload 20
    //   2301: getfield 775	android/hardware/Camera$CameraInfo:orientation	I
    //   2304: iadd
    //   2305: sipush 360
    //   2308: irem
    //   2309: isub
    //   2310: sipush 360
    //   2313: irem
    //   2314: istore_2
    //   2315: aload 19
    //   2317: ifnonnull +6 -> 2323
    //   2320: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   2323: aload 19
    //   2325: iload_2
    //   2326: invokevirtual 777	com/tencent/mm/compatible/deviceinfo/v:setDisplayOrientation	(I)V
    //   2329: aload_0
    //   2330: iload_2
    //   2331: putfield 754	com/tencent/mm/plugin/multitalk/model/x:zOj	I
    //   2334: goto -275 -> 2059
    //   2337: aload 20
    //   2339: getfield 775	android/hardware/Camera$CameraInfo:orientation	I
    //   2342: iload_2
    //   2343: isub
    //   2344: sipush 360
    //   2347: iadd
    //   2348: sipush 360
    //   2351: irem
    //   2352: istore_2
    //   2353: goto -38 -> 2315
    //   2356: aconst_null
    //   2357: astore 19
    //   2359: goto -279 -> 2080
    //   2362: aconst_null
    //   2363: astore 20
    //   2365: goto -264 -> 2101
    //   2368: astore 20
    //   2370: goto -672 -> 1698
    //   2373: aconst_null
    //   2374: astore 18
    //   2376: goto -1621 -> 755
    //   2379: aconst_null
    //   2380: astore 19
    //   2382: goto -1722 -> 660
    //   2385: iload 4
    //   2387: istore 7
    //   2389: iload 6
    //   2391: istore 4
    //   2393: iload 7
    //   2395: istore 6
    //   2397: goto +44 -> 2441
    //   2400: iload 8
    //   2402: ifle -1165 -> 1237
    //   2405: iload 7
    //   2407: ifle -1170 -> 1237
    //   2410: iload 7
    //   2412: iload 8
    //   2414: if_icmplt -1177 -> 1237
    //   2417: iconst_1
    //   2418: istore 17
    //   2420: goto -2015 -> 405
    //   2423: iconst_1
    //   2424: istore 4
    //   2426: goto -1952 -> 474
    //   2429: iload 6
    //   2431: istore 7
    //   2433: iload 4
    //   2435: istore 6
    //   2437: iload 7
    //   2439: istore 4
    //   2441: iload 9
    //   2443: iconst_1
    //   2444: iadd
    //   2445: istore 9
    //   2447: iload 6
    //   2449: istore 7
    //   2451: iload 4
    //   2453: istore 6
    //   2455: iload 7
    //   2457: istore 4
    //   2459: goto -1141 -> 1318
    //   2462: iload 4
    //   2464: istore 7
    //   2466: iload 6
    //   2468: istore 4
    //   2470: iload 7
    //   2472: istore 6
    //   2474: goto -33 -> 2441
    //   2477: iconst_0
    //   2478: istore 7
    //   2480: goto -982 -> 1498
    //   2483: goto -195 -> 2288
    //   2486: iconst_0
    //   2487: istore_2
    //   2488: goto -200 -> 2288
    //   2491: bipush 90
    //   2493: istore_2
    //   2494: goto -206 -> 2288
    //   2497: sipush 180
    //   2500: istore_2
    //   2501: goto -213 -> 2288
    //   2504: sipush 270
    //   2507: istore_2
    //   2508: goto -220 -> 2288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2511	0	this	x
    //   0	2511	1	paramBoolean	boolean
    //   0	2511	2	paramInt1	int
    //   0	2511	3	paramInt2	int
    //   251	2218	4	i	int
    //   1311	232	5	j	int
    //   361	2112	6	k	int
    //   370	2109	7	m	int
    //   367	2048	8	n	int
    //   1306	1140	9	i1	int
    //   1376	165	10	i2	int
    //   242	1338	11	i3	int
    //   1303	32	12	i4	int
    //   1436	82	13	i5	int
    //   1444	64	14	i6	int
    //   1465	21	15	i7	int
    //   32	1503	16	bool1	boolean
    //   28	2391	17	bool2	boolean
    //   53	971	18	localObject1	Object
    //   1045	553	18	localException1	Exception
    //   1641	9	18	localException2	Exception
    //   1666	503	18	localObject2	Object
    //   2173	27	18	localException3	Exception
    //   2217	158	18	localObject3	Object
    //   227	962	19	localObject4	Object
    //   1206	394	19	localException4	Exception
    //   1616	9	19	localException5	Exception
    //   1971	63	19	localObject5	Object
    //   2036	15	19	localException6	Exception
    //   2063	318	19	localObject6	Object
    //   293	1045	20	localObject7	Object
    //   1692	19	20	localException7	Exception
    //   1980	384	20	localObject8	Object
    //   2368	1	20	localException8	Exception
    //   594	1656	21	localObject9	Object
    //   690	88	22	localPoint	Point
    //   679	33	23	localParameters	Camera.Parameters
    // Exception table:
    //   from	to	target	type
    //   186	199	1045	java/lang/Exception
    //   204	207	1045	java/lang/Exception
    //   207	213	1045	java/lang/Exception
    //   1087	1093	1206	java/lang/Exception
    //   1098	1101	1206	java/lang/Exception
    //   1101	1119	1206	java/lang/Exception
    //   1124	1127	1206	java/lang/Exception
    //   1127	1141	1206	java/lang/Exception
    //   1146	1149	1206	java/lang/Exception
    //   1149	1155	1206	java/lang/Exception
    //   1155	1161	1206	java/lang/Exception
    //   1166	1169	1206	java/lang/Exception
    //   1169	1180	1206	java/lang/Exception
    //   1185	1188	1206	java/lang/Exception
    //   1188	1198	1206	java/lang/Exception
    //   253	281	1616	java/lang/Exception
    //   281	323	1616	java/lang/Exception
    //   323	358	1616	java/lang/Exception
    //   372	402	1616	java/lang/Exception
    //   405	450	1616	java/lang/Exception
    //   1263	1278	1616	java/lang/Exception
    //   1283	1293	1616	java/lang/Exception
    //   1296	1305	1616	java/lang/Exception
    //   1337	1351	1616	java/lang/Exception
    //   1356	1363	1616	java/lang/Exception
    //   1378	1415	1616	java/lang/Exception
    //   1430	1467	1616	java/lang/Exception
    //   1503	1526	1616	java/lang/Exception
    //   1551	1604	1616	java/lang/Exception
    //   479	529	1641	java/lang/Exception
    //   660	666	1692	java/lang/Exception
    //   671	674	1692	java/lang/Exception
    //   674	702	1692	java/lang/Exception
    //   711	721	1692	java/lang/Exception
    //   726	755	1692	java/lang/Exception
    //   764	791	1692	java/lang/Exception
    //   791	810	1692	java/lang/Exception
    //   1967	1993	2036	java/lang/Exception
    //   1993	2010	2036	java/lang/Exception
    //   2015	2036	2036	java/lang/Exception
    //   2222	2226	2036	java/lang/Exception
    //   2229	2255	2036	java/lang/Exception
    //   2288	2315	2036	java/lang/Exception
    //   2320	2323	2036	java/lang/Exception
    //   2323	2334	2036	java/lang/Exception
    //   2337	2353	2036	java/lang/Exception
    //   1859	1865	2173	java/lang/Exception
    //   1870	1873	2173	java/lang/Exception
    //   1873	1888	2173	java/lang/Exception
    //   1893	1900	2173	java/lang/Exception
    //   1905	1926	2173	java/lang/Exception
    //   810	850	2368	java/lang/Exception
  }
  
  /* Error */
  private final v rO(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc_w 778
    //   5: invokestatic 219	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: iload_1
    //   9: invokestatic 781	com/tencent/mm/plugin/multitalk/model/x$a:rP	(Z)Lcom/tencent/mm/compatible/deviceinfo/v;
    //   12: astore 6
    //   14: aload 6
    //   16: ifnonnull +217 -> 233
    //   19: new 309	com/tencent/mm/compatible/deviceinfo/v
    //   22: dup
    //   23: invokestatic 785	android/hardware/Camera:open	()Landroid/hardware/Camera;
    //   26: invokespecial 788	com/tencent/mm/compatible/deviceinfo/v:<init>	(Landroid/hardware/Camera;)V
    //   29: astore 6
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 526	com/tencent/mm/plugin/multitalk/model/x:zNU	Z
    //   36: getstatic 325	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   39: ldc2_w 326
    //   42: lconst_0
    //   43: lconst_1
    //   44: iconst_0
    //   45: invokevirtual 331	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   48: aload 6
    //   50: invokevirtual 312	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   53: astore 5
    //   55: aload 5
    //   57: ldc_w 493
    //   60: invokestatic 273	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   63: aload 5
    //   65: invokevirtual 791	android/hardware/Camera$Parameters:getSupportedPreviewFrameRates	()Ljava/util/List;
    //   68: astore 7
    //   70: ldc_w 793
    //   73: astore 5
    //   75: aload 5
    //   77: astore 8
    //   79: aload 7
    //   81: ifnull +185 -> 266
    //   84: aload 7
    //   86: checkcast 461	java/util/Collection
    //   89: invokeinterface 462 1 0
    //   94: istore_3
    //   95: aload 5
    //   97: astore 8
    //   99: iload_2
    //   100: iload_3
    //   101: if_icmpge +165 -> 266
    //   104: aload 7
    //   106: iload_2
    //   107: invokeinterface 466 2 0
    //   112: checkcast 795	java/lang/Number
    //   115: invokevirtual 798	java/lang/Number:intValue	()I
    //   118: istore 4
    //   120: new 366	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 799	java/lang/StringBuilder:<init>	()V
    //   127: aload 5
    //   129: invokevirtual 504	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: iload 4
    //   134: invokevirtual 380	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: bipush 44
    //   139: invokevirtual 611	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   142: invokevirtual 384	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore 5
    //   147: iload_2
    //   148: iconst_1
    //   149: iadd
    //   150: istore_2
    //   151: goto -56 -> 95
    //   154: astore 5
    //   156: ldc_w 286
    //   159: ldc_w 801
    //   162: aload 5
    //   164: invokestatic 338	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   167: invokevirtual 342	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   170: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: getstatic 325	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   176: ldc2_w 326
    //   179: lconst_0
    //   180: lconst_1
    //   181: iconst_0
    //   182: invokevirtual 331	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   185: getstatic 325	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   188: ldc2_w 326
    //   191: lconst_1
    //   192: lconst_1
    //   193: iconst_0
    //   194: invokevirtual 331	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   197: aload_0
    //   198: getfield 659	com/tencent/mm/plugin/multitalk/model/x:zOe	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   201: ifnull +24 -> 225
    //   204: aload_0
    //   205: getfield 659	com/tencent/mm/plugin/multitalk/model/x:zOe	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   208: astore 5
    //   210: aload 5
    //   212: ifnonnull +6 -> 218
    //   215: invokestatic 442	kotlin/g/b/p:hyc	()V
    //   218: aload 5
    //   220: invokeinterface 664 1 0
    //   225: ldc_w 778
    //   228: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aconst_null
    //   232: areturn
    //   233: aload_0
    //   234: iload_1
    //   235: putfield 526	com/tencent/mm/plugin/multitalk/model/x:zNU	Z
    //   238: goto -190 -> 48
    //   241: astore 5
    //   243: ldc_w 286
    //   246: ldc_w 803
    //   249: aload 5
    //   251: invokestatic 338	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   254: invokevirtual 342	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   257: invokestatic 507	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aconst_null
    //   261: astore 7
    //   263: goto -193 -> 70
    //   266: ldc_w 286
    //   269: aload 8
    //   271: invokestatic 386	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_0
    //   275: aload 6
    //   277: invokespecial 805	com/tencent/mm/plugin/multitalk/model/x:f	(Lcom/tencent/mm/compatible/deviceinfo/v;)I
    //   280: pop
    //   281: ldc_w 778
    //   284: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: aload 6
    //   289: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	x
    //   0	290	1	paramBoolean	boolean
    //   1	150	2	i	int
    //   94	8	3	j	int
    //   118	15	4	k	int
    //   53	93	5	localObject1	Object
    //   154	9	5	localException1	Exception
    //   208	11	5	localb	com.tencent.mm.plugin.voip.video.camera.a.b
    //   241	9	5	localException2	Exception
    //   12	276	6	localv	v
    //   68	194	7	localList	List
    //   77	193	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   19	31	154	java/lang/Exception
    //   48	70	241	java/lang/Exception
  }
  
  public final int a(com.tencent.mm.plugin.voip.video.camera.a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(239642);
    com.tencent.mm.plugin.voip.video.camera.prev.b localb = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
    p.g(localb, "VoipCameraCompatible.gVoipCameraInfo");
    if (localb.aRA() <= 0)
    {
      this.zNX = 1;
      AppMethodBeat.o(239642);
      return -1;
    }
    if (paramBoolean)
    {
      localb = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
      p.g(localb, "VoipCameraCompatible.gVoipCameraInfo");
      if (!localb.fLt()) {
        paramBoolean = false;
      }
    }
    for (;;)
    {
      this.zOe = paramb;
      if (h(paramBoolean, this.mWidth, this.mHeight) > 0) {
        break;
      }
      int i = h(paramBoolean, this.mWidth, this.mHeight);
      if (i > 0) {
        break;
      }
      this.zNX = 1;
      AppMethodBeat.o(239642);
      return i;
      localb = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
      p.g(localb, "VoipCameraCompatible.gVoipCameraInfo");
      if (!localb.fLu()) {
        paramBoolean = true;
      }
    }
    this.zNU = paramBoolean;
    eoa();
    this.zNX = 0;
    AppMethodBeat.o(239642);
    return 1;
  }
  
  public final int eob()
  {
    AppMethodBeat.i(239648);
    if (!this.zOb)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
      this.zNX = 1;
      AppMethodBeat.o(239648);
      return -1;
    }
    if (this.zOf)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: is in capture already ");
      AppMethodBeat.o(239648);
      return -1;
    }
    Log.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", new Object[] { Boolean.valueOf(this.zOd) });
    if (this.mSurfaceTexture != null) {}
    try
    {
      localv = this.sZb;
      if (localv == null) {
        p.hyc();
      }
      localv.setPreviewTexture(this.mSurfaceTexture);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        v localv;
        label130:
        h.CyF.idkeyStat(159L, 0L, 1L, false);
        h.CyF.idkeyStat(159L, 2L, 1L, false);
        this.zNX = 1;
        Log.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:".concat(String.valueOf(localException1)));
      }
    }
    try
    {
      localv = this.sZb;
      if (localv == null) {
        p.hyc();
      }
      localv.startPreview();
      this.sZd = true;
    }
    catch (Exception localException2)
    {
      h.CyF.idkeyStat(159L, 0L, 1L, false);
      h.CyF.idkeyStat(159L, 2L, 1L, false);
      this.zNX = 1;
      if (this.zOe == null) {
        break label278;
      }
      com.tencent.mm.plugin.voip.video.camera.a.b localb = this.zOe;
      if (localb != null) {
        break label272;
      }
      p.hyc();
      localb.cza();
      Log.e("MicroMsg.Voip.CaptureRender", "startPreview:error".concat(String.valueOf(localException2)));
      break label130;
    }
    if (this.sZb != null)
    {
      localv = this.sZb;
      if (localv == null) {
        p.hyc();
      }
      localv.setPreviewCallback(this.zOo);
    }
    this.zOf = true;
    AppMethodBeat.o(239648);
    return 1;
  }
  
  public final void eoc()
  {
    AppMethodBeat.i(239649);
    Log.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.zOf);
    Object localObject;
    if ((this.zOf) && (this.sZb != null))
    {
      this.zOg = false;
      localObject = this.sZb;
      if (localObject == null) {
        p.hyc();
      }
      if (!((v)localObject).gIJ)
      {
        localObject = this.sZb;
        if (localObject == null) {
          p.hyc();
        }
        ((v)localObject).setPreviewCallback(null);
      }
    }
    try
    {
      localObject = this.sZb;
      if (localObject == null) {
        p.hyc();
      }
      ((v)localObject).stopPreview();
      this.sZd = false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Voip.CaptureRender", "stopPreview:error".concat(String.valueOf(localException)));
        continue;
        if (this.sZb != null)
        {
          v localv = this.sZb;
          if (localv == null) {
            p.hyc();
          }
          if (!localv.gIJ)
          {
            localv = this.sZb;
            if (localv == null) {
              p.hyc();
            }
            localv.setPreviewCallback(null);
          }
          localv = this.sZb;
          if (localv == null) {
            p.hyc();
          }
          localv.release();
          this.sZb = null;
          this.zOb = false;
        }
      }
    }
    this.zOf = false;
    if (1 == this.zNX)
    {
      localObject = new pl();
      ((pl)localObject).dVC.type = 2;
      EventCenter.instance.publish((IEvent)localObject);
    }
    Log.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.zOb);
    if (this.zOb)
    {
      this.zNX = 0;
      this.zOg = false;
      if (this.sZb != null)
      {
        localObject = this.sZb;
        if (localObject == null) {
          p.hyc();
        }
        if (!((v)localObject).gIJ)
        {
          localObject = this.sZb;
          if (localObject == null) {
            p.hyc();
          }
          ((v)localObject).setPreviewCallback(null);
          localObject = this.sZb;
          if (localObject == null) {
            p.hyc();
          }
          ((v)localObject).release();
        }
      }
      this.sZb = null;
      this.zOb = false;
      this.zOh = null;
      if (this.zOi != null)
      {
        localObject = this.zOi;
        if (localObject == null) {
          p.hyc();
        }
        ((List)localObject).clear();
      }
      this.zOi = null;
      this.zOc = false;
      AppMethodBeat.o(239649);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer$Companion;", "", "()V", "CALLBACK_BUFFER_COUNT", "", "COMMA_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "ENUM_VideoDevStartFailed", "ENUM_VideoDevStartNormal", "FOCUS_FACE_LOC_DIFF_THREASHOLD", "METER_FACE_LOC_DIFF_THRESHOLD", "TAG", "", "VFMT_420SP", "VFMT_D530", "VFMT_LOCAL", "VFMT_NV12", "VFMT_RGB24", "VFMT_RGB32", "VFMT_RGB565", "VFMT_ROTATE", "VFMT_UYVY", "VFMT_YUV420", "VFMT_YUY2", "VFMT_YV12", "findBestPreviewSizeValue", "Landroid/graphics/Point;", "previewSizeValueString", "", "screenResolution", "getCameraResolution", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "w", "h", "openCameraByHighApiLvl", "bFace", "", "plugin-multitalk_release"})
  public static final class a
  {
    static Point a(CharSequence paramCharSequence, Point paramPoint)
    {
      AppMethodBeat.i(239640);
      int i = 0;
      int j = 0;
      int k = 2147483647;
      paramCharSequence = x.eod().split(paramCharSequence);
      int i5 = paramCharSequence.length;
      int i3 = 0;
      int n;
      int m;
      int i1;
      int i2;
      label88:
      int i4;
      if (i3 < i5)
      {
        Object localObject1 = paramCharSequence[i3];
        p.g(localObject1, "previewSize");
        localObject1 = (CharSequence)localObject1;
        n = 0;
        m = ((CharSequence)localObject1).length() - 1;
        i1 = 0;
        while (n <= m)
        {
          if (i1 == 0)
          {
            i2 = n;
            if (((CharSequence)localObject1).charAt(i2) > ' ') {
              break label128;
            }
            i2 = 1;
          }
          for (;;)
          {
            if (i1 == 0)
            {
              if (i2 == 0)
              {
                i1 = 1;
                break;
                i2 = m;
                break label88;
                label128:
                i2 = 0;
                continue;
              }
              n += 1;
              break;
            }
          }
          if (i2 == 0) {
            break;
          }
          m -= 1;
        }
        localObject1 = ((CharSequence)localObject1).subSequence(n, m + 1).toString();
        m = n.a((CharSequence)localObject1, 'x', 0, false, 6);
        if (m < 0)
        {
          Log.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: ".concat(String.valueOf(localObject1)));
          i1 = i;
          n = j;
          m = k;
        }
        for (;;)
        {
          i3 += 1;
          k = m;
          j = n;
          i = i1;
          break;
          if (localObject1 != null) {
            break label294;
          }
          try
          {
            t localt = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(239640);
            throw localt;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            Log.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: ".concat(String.valueOf(localObject1)));
            m = k;
            n = j;
            i1 = i;
          }
        }
        label294:
        Object localObject2 = ((String)localObject1).substring(0, m);
        p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        i4 = Util.getInt((String)localObject2, 0);
        if (localObject1 == null)
        {
          localObject2 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(239640);
          throw ((Throwable)localObject2);
        }
        localObject2 = ((String)localObject1).substring(m + 1);
        p.g(localObject2, "(this as java.lang.String).substring(startIndex)");
        i2 = Util.getInt((String)localObject2, 0);
        m = Math.abs(i4 - paramPoint.x) + Math.abs(i2 - paramPoint.y);
        if (m != 0) {}
      }
      for (;;)
      {
        if ((i4 > 0) && (i2 > 0))
        {
          paramCharSequence = new Point(i4, i2);
          AppMethodBeat.o(239640);
          return paramCharSequence;
          if (m < k)
          {
            n = i2;
            i1 = i4;
            if (i4 != i2) {
              break;
            }
          }
          m = k;
          n = j;
          i1 = i;
          break;
        }
        AppMethodBeat.o(239640);
        return null;
        i2 = j;
        i4 = i;
      }
    }
    
    public static v rP(boolean paramBoolean)
    {
      localObject3 = null;
      AppMethodBeat.i(239639);
      Object localObject1 = com.tencent.mm.plugin.voip.video.camera.a.c.Hjw;
      p.g(localObject1, "VoipCameraCompatible.gVoipCameraInfo");
      if (((com.tencent.mm.plugin.voip.video.camera.prev.b)localObject1).aRA() <= 0)
      {
        AppMethodBeat.o(239639);
        return null;
      }
      if (!com.tencent.mm.plugin.voip.video.camera.a.c.HjC)
      {
        AppMethodBeat.o(239639);
        return null;
      }
      if (paramBoolean == true) {}
      for (;;)
      {
        try
        {
          localObject1 = d.B(MMApplicationContext.getContext(), com.tencent.mm.plugin.voip.video.camera.a.c.Hjx);
          Log.i("Camera", "Use front");
          localObject2 = localObject3;
          if (localObject1 != null) {
            localObject2 = ((d.a.a)localObject1).gGr;
          }
        }
        catch (Exception localException)
        {
          h.CyF.idkeyStat(159L, 0L, 1L, false);
          h.CyF.idkeyStat(159L, 1L, 1L, false);
          Log.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:".concat(String.valueOf(localException)));
          Object localObject2 = localObject3;
          continue;
        }
        AppMethodBeat.o(239639);
        return localObject2;
        localObject1 = d.B(MMApplicationContext.getContext(), com.tencent.mm.plugin.voip.video.camera.a.c.Hjy);
        Log.i("Camera", "Use back");
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer$previewCallback$1", "Landroid/hardware/Camera$PreviewCallback;", "onPreviewFrame", "", "data", "", "arg1", "Landroid/hardware/Camera;", "plugin-multitalk_release"})
  public static final class b
    implements Camera.PreviewCallback
  {
    public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
      AppMethodBeat.i(239641);
      p.h(paramArrayOfByte, "data");
      p.h(paramCamera, "arg1");
      if (paramArrayOfByte.length <= 0)
      {
        h.CyF.idkeyStat(159L, 0L, 1L, false);
        h.CyF.idkeyStat(159L, 3L, 1L, false);
        if (this.zOr.zOe != null)
        {
          paramArrayOfByte = this.zOr.zOe;
          if (paramArrayOfByte == null) {
            p.hyc();
          }
          paramArrayOfByte.cza();
        }
        AppMethodBeat.o(239641);
        return;
      }
      if (this.zOr.zNZ == null)
      {
        Log.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
        AppMethodBeat.o(239641);
        return;
      }
      int m;
      int j;
      int k;
      int i;
      if (this.zOr.zOe != null)
      {
        if (x.a(this.zOr) != null)
        {
          paramCamera = x.a(this.zOr);
          if (paramCamera == null) {
            p.hyc();
          }
          if (paramCamera.length == paramArrayOfByte.length) {}
        }
        else
        {
          x.a(this.zOr, new byte[paramArrayOfByte.length]);
        }
        System.arraycopy(paramArrayOfByte, 0, x.a(this.zOr), 0, paramArrayOfByte.length);
        m = 1;
        if (this.zOr.zNU)
        {
          j = com.tencent.mm.plugin.voip.video.camera.a.c.Hjz;
          k = j;
          if (!ae.gKt.gFF) {
            break label788;
          }
          k = j;
          if (ae.gKt.gFE.dYT == 0) {
            break label788;
          }
          i = ae.gKt.gFE.gGp;
          m = 1;
          k = j;
          j = m;
        }
      }
      for (;;)
      {
        label253:
        boolean bool;
        label271:
        byte[] arrayOfByte1;
        Object localObject;
        if (k > 0)
        {
          m = 32;
          paramCamera = this.zOr;
          if ((j != 0) || (k <= 0)) {
            break label631;
          }
          bool = true;
          paramCamera.zNV = Boolean.valueOf(bool);
          paramCamera = this.zOr.zNZ;
          if (paramCamera == null) {
            p.hyc();
          }
          k = paramCamera.width;
          paramCamera = this.zOr.zNZ;
          if (paramCamera == null) {
            p.hyc();
          }
          int n = paramCamera.height;
          if (j == 0) {
            break label637;
          }
          if (this.zOr.zOh == null)
          {
            j = k * n * 3 / 2;
            this.zOr.zOh = new byte[j];
            paramCamera = this.zOr.zOh;
            if (paramCamera == null) {
              p.hyc();
            }
            paramCamera[0] = 90;
          }
          paramCamera = com.tencent.mm.plugin.voip.c.fFg();
          arrayOfByte1 = x.a(this.zOr);
          localObject = x.a(this.zOr);
          if (localObject == null) {
            p.hyc();
          }
          j = localObject.length;
          int i1 = this.zOr.zOa;
          localObject = this.zOr.zOh;
          byte[] arrayOfByte2 = this.zOr.zOh;
          if (arrayOfByte2 == null) {
            p.hyc();
          }
          paramCamera.a(arrayOfByte1, j, k, n, i1, (byte[])localObject, arrayOfByte2.length, k, n, i);
          paramCamera = this.zOr.zOe;
          if (paramCamera == null) {
            p.hyc();
          }
          arrayOfByte1 = this.zOr.zOh;
          localObject = this.zOr.zOh;
          if (localObject == null) {
            p.hyc();
          }
          paramCamera.a(arrayOfByte1, localObject.length, k, n, this.zOr.zOa, m);
        }
        for (;;)
        {
          if (m.getApiLevel() >= 8)
          {
            if (this.zOr.sZb == null)
            {
              Log.e("MicroMsg.Voip.CaptureRender", "the camera is null and has been release");
              AppMethodBeat.o(239641);
              return;
              i = com.tencent.mm.plugin.voip.video.camera.a.c.HjA;
              k = i;
              if (!ae.gKt.gFH) {
                break label788;
              }
              k = i;
              if (ae.gKt.gFG.dYT == 0) {
                break label788;
              }
              m = ae.gKt.gFG.gGp;
              j = 1;
              k = i;
              i = m;
              break;
              m = 0;
              break label253;
              label631:
              bool = false;
              break label271;
              label637:
              paramCamera = this.zOr.zOe;
              if (paramCamera == null) {
                p.hyc();
              }
              arrayOfByte1 = x.a(this.zOr);
              localObject = x.a(this.zOr);
              if (localObject == null) {
                p.hyc();
              }
              long l = localObject.length;
              localObject = this.zOr.zNZ;
              if (localObject == null) {
                p.hyc();
              }
              i = ((ac)localObject).width;
              localObject = this.zOr.zNZ;
              if (localObject == null) {
                p.hyc();
              }
              paramCamera.a(arrayOfByte1, l, i, ((ac)localObject).height, this.zOr.zOa, m);
              continue;
            }
            if (this.zOr.sZb != null)
            {
              paramCamera = this.zOr.sZb;
              if (paramCamera == null) {
                p.hyc();
              }
              paramCamera.addCallbackBuffer(paramArrayOfByte);
            }
          }
        }
        AppMethodBeat.o(239641);
        return;
        label788:
        j = 0;
        i = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.x
 * JD-Core Version:    0.7.0.1
 */