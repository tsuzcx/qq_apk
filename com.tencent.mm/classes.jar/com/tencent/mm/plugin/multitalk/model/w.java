package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rw;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.camera.prev.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer;", "", "w", "", "h", "(II)V", "<set-?>", "cameraErrCode", "getCameraErrCode", "()I", "setCameraErrCode", "(I)V", "dispatchFrameData", "", "displayOrientation", "getDisplayOrientation", "setDisplayOrientation", "", "isCameraRemote180", "()Ljava/lang/Boolean;", "setCameraRemote180", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isCloudVoip", "()Z", "isCurrentFaceCamera", "setCurrentFaceCamera", "(Z)V", "isPreviewing", "setPreviewing", "isUesSurfacePreivew", "setUesSurfacePreivew", "mAutoFocusTimeOut", "", "getMAutoFocusTimeOut", "()J", "setMAutoFocusTimeOut", "(J)V", "mCallbackBufList", "", "getMCallbackBufList", "()Ljava/util/List;", "setMCallbackBufList", "(Ljava/util/List;)V", "mCamera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "getMCamera", "()Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "setMCamera", "(Lcom/tencent/mm/compatible/deviceinfo/MCamera;)V", "mCameraOpen", "getMCameraOpen", "setMCameraOpen", "mCameraOpenFaild", "getMCameraOpenFaild", "setMCameraOpenFaild", "mFormat", "getMFormat", "setMFormat", "mGetCameraDataCallback", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "getMGetCameraDataCallback", "()Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "setMGetCameraDataCallback", "(Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;)V", "mHeight", "getMHeight", "setMHeight", "mIsCameraNoParamAutoFocus", "getMIsCameraNoParamAutoFocus", "setMIsCameraNoParamAutoFocus", "mIsContinuousVideoMode", "getMIsContinuousVideoMode", "setMIsContinuousVideoMode", "mIsFocusOnFace", "getMIsFocusOnFace", "setMIsFocusOnFace", "mIsInCapture", "getMIsInCapture", "setMIsInCapture", "mIsLastAutoFocusFaceCamera", "getMIsLastAutoFocusFaceCamera", "setMIsLastAutoFocusFaceCamera", "mIsLastFocusFaceCamera", "getMIsLastFocusFaceCamera", "setMIsLastFocusFaceCamera", "mIsShouldStartCapture", "getMIsShouldStartCapture", "setMIsShouldStartCapture", "mLastAutoFocusTimestamp", "getMLastAutoFocusTimestamp", "setMLastAutoFocusTimestamp", "mLastFaceLocation", "", "getMLastFaceLocation", "()[I", "setMLastFaceLocation", "([I)V", "mParameters", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "getMParameters", "()Landroid/hardware/Camera$Parameters;", "setMParameters", "(Landroid/hardware/Camera$Parameters;)V", "mRotateTmpBuffer", "getMRotateTmpBuffer", "()[B", "setMRotateTmpBuffer", "([B)V", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getMSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setMSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "mWidth", "getMWidth", "setMWidth", "previewCallback", "Landroid/hardware/Camera$PreviewCallback;", "getPreviewCallback", "()Landroid/hardware/Camera$PreviewCallback;", "setPreviewCallback", "(Landroid/hardware/Camera$PreviewCallback;)V", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "previewSize", "getPreviewSize", "()Lcom/tencent/mm/compatible/deviceinfo/Size;", "setPreviewSize", "(Lcom/tencent/mm/compatible/deviceinfo/Size;)V", "supportMaxPixel", "getSupportMaxPixel", "setSupportMaxPixel", "supportMaxSizeHeight", "getSupportMaxSizeHeight", "setSupportMaxSizeHeight", "supportMaxSizeWidth", "getSupportMaxSizeWidth", "setSupportMaxSizeWidth", "bind", "", "surfaceTexture", "dumpCapInfo", "camera", "exchangeCapture", "exchangeToHignCapture", "is1280", "initCamera", "bFace", "initCapture", "dataCallback", "bFaceFirst", "safeOpenCamera", "safeSetFps", "cuFps", "startCaptureUseSurfaceHolder", "stopCapture", "testSupportFps", "tryPreviewSize", "trySetAutoFocus", "isFrontCamera", "CaptureRenderStatIDKey", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final a LpK;
  private static final Pattern Lqg;
  volatile com.tencent.mm.compatible.deviceinfo.w Abo;
  public boolean LpL;
  Boolean LpM;
  private long LpN;
  public int LpO;
  private Camera.Parameters LpP;
  ad LpQ;
  int LpR;
  private boolean LpS;
  private boolean LpT;
  private boolean LpU;
  public com.tencent.mm.plugin.voip.video.camera.a.c LpV;
  private boolean LpW;
  private boolean LpX;
  byte[] LpY;
  private List<byte[]> LpZ;
  private int Lqa;
  private int Lqb;
  private int Lqc;
  private boolean Lqd;
  private byte[] Lqe;
  private Camera.PreviewCallback Lqf;
  private int mHeight;
  SurfaceTexture mSurfaceTexture;
  private int mWidth;
  public boolean nGD;
  private boolean nvB;
  
  static
  {
    AppMethodBeat.i(284834);
    LpK = new a((byte)0);
    Lqg = Pattern.compile(",");
    AppMethodBeat.o(284834);
  }
  
  public w()
  {
    AppMethodBeat.i(284747);
    this.LpN = 30000L;
    this.mWidth = 320;
    this.mHeight = 240;
    this.nGD = true;
    this.Lqf = ((Camera.PreviewCallback)new b(this));
    this.mWidth = 640;
    this.mHeight = 480;
    com.tencent.mm.plugin.voip.video.camera.a.d.kC(MMApplicationContext.getContext().getApplicationContext());
    Log.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
    AppMethodBeat.o(284747);
  }
  
  private static boolean a(com.tencent.mm.compatible.deviceinfo.w paramw, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284760);
    if (paramw == null)
    {
      AppMethodBeat.o(284760);
      return false;
    }
    try
    {
      Camera.Parameters localParameters = paramw.aPy();
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        localParameters.setPreviewSize(paramInt1, paramInt2);
      }
      paramw.c(localParameters);
      AppMethodBeat.o(284760);
      return true;
    }
    catch (Exception paramw)
    {
      h.OAn.idkeyStat(159L, 0L, 1L, false);
      Log.e("MicroMsg.Voip.CaptureRender", s.X("TryPreviewSize fail:", paramw));
      AppMethodBeat.o(284760);
    }
    return false;
  }
  
  private final boolean b(com.tencent.mm.compatible.deviceinfo.w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(284773);
    if (paramw == null)
    {
      AppMethodBeat.o(284773);
      return false;
    }
    Camera.Parameters localParameters;
    List localList;
    try
    {
      Log.i("MicroMsg.Voip.CaptureRender", "trySetAutoFocus, isFrontCamera:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      localParameters = paramw.aPy();
      localList = localParameters.getSupportedFocusModes();
      if (localList == null) {
        break label206;
      }
      Log.i("MicroMsg.Voip.CaptureRender", s.X("supported focus modes size = ", Integer.valueOf(localList.size())));
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        Log.i("MicroMsg.Voip.CaptureRender", s.X("supported focus modes : ", (String)localIterator.next()));
      }
      if (af.lXY.lTy != 0) {
        break label251;
      }
    }
    catch (Exception paramw)
    {
      h.OAn.idkeyStat(159L, 0L, 1L, false);
      Log.e("MicroMsg.Voip.CaptureRender", s.X("TrySetAutoFocus fail:", paramw));
      AppMethodBeat.o(284773);
      return false;
    }
    if (paramBoolean) {
      if (localList.contains("auto"))
      {
        Log.i("MicroMsg.Voip.CaptureRender", "camera support auto focus");
        localParameters.setFocusMode("auto");
        this.LpT = false;
      }
    }
    for (;;)
    {
      paramw.c(localParameters);
      label206:
      AppMethodBeat.o(284773);
      return true;
      if (localList.contains("continuous-video"))
      {
        Log.i("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
        localParameters.setFocusMode("continuous-video");
        this.LpT = true;
        continue;
        label251:
        if ((af.lXY.lTy == 1) || (!paramBoolean)) {
          if (localList.contains("continuous-video"))
          {
            Log.i("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
            localParameters.setFocusMode("continuous-video");
            this.LpT = true;
          }
          else if (localList.contains("auto"))
          {
            Log.i("MicroMsg.Voip.CaptureRender", "camera support auto focus");
            localParameters.setFocusMode("auto");
            this.LpT = false;
          }
        }
      }
    }
  }
  
  public static boolean drd()
  {
    return false;
  }
  
  /* Error */
  private int f(com.tencent.mm.compatible.deviceinfo.w paramw)
  {
    // Byte code:
    //   0: ldc_w 415
    //   3: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 415
    //   13: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_1
    //   19: invokevirtual 307	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   22: invokevirtual 418	android/hardware/Camera$Parameters:getSupportedPreviewSizes	()Ljava/util/List;
    //   25: astore 5
    //   27: aload 5
    //   29: ifnull +253 -> 282
    //   32: aload 5
    //   34: invokeinterface 361 1 0
    //   39: ifeq +243 -> 282
    //   42: aload 5
    //   44: invokeinterface 367 1 0
    //   49: astore 5
    //   51: iconst_0
    //   52: istore_3
    //   53: iload_3
    //   54: istore_2
    //   55: iload_3
    //   56: istore 4
    //   58: aload 5
    //   60: invokeinterface 372 1 0
    //   65: ifeq +92 -> 157
    //   68: iload_3
    //   69: istore 4
    //   71: aload 5
    //   73: invokeinterface 378 1 0
    //   78: checkcast 420	android/hardware/Camera$Size
    //   81: astore 6
    //   83: iload_3
    //   84: istore 4
    //   86: ldc_w 281
    //   89: new 422	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 424
    //   96: invokespecial 426	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload 6
    //   101: getfield 429	android/hardware/Camera$Size:width	I
    //   104: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: bipush 44
    //   109: invokevirtual 436	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   112: aload 6
    //   114: getfield 439	android/hardware/Camera$Size:height	I
    //   117: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: invokevirtual 443	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 445	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iload_3
    //   127: ifne +148 -> 275
    //   130: iload_3
    //   131: istore 4
    //   133: aload_0
    //   134: aload 6
    //   136: getfield 429	android/hardware/Camera$Size:width	I
    //   139: putfield 447	com/tencent/mm/plugin/multitalk/model/w:Lqb	I
    //   142: iload_3
    //   143: istore 4
    //   145: aload_0
    //   146: aload 6
    //   148: getfield 439	android/hardware/Camera$Size:height	I
    //   151: putfield 449	com/tencent/mm/plugin/multitalk/model/w:Lqc	I
    //   154: goto +121 -> 275
    //   157: iload_2
    //   158: istore 4
    //   160: aload_1
    //   161: invokevirtual 307	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   164: invokevirtual 452	android/hardware/Camera$Parameters:getSupportedPreviewFormats	()Ljava/util/List;
    //   167: astore_1
    //   168: iload_2
    //   169: istore_3
    //   170: aload_1
    //   171: ifnull +89 -> 260
    //   174: iload_2
    //   175: istore 4
    //   177: iload_2
    //   178: istore_3
    //   179: aload_1
    //   180: invokeinterface 361 1 0
    //   185: ifeq +75 -> 260
    //   188: iload_2
    //   189: istore 4
    //   191: aload_1
    //   192: invokeinterface 367 1 0
    //   197: astore_1
    //   198: iload_2
    //   199: istore 4
    //   201: iload_2
    //   202: istore_3
    //   203: aload_1
    //   204: invokeinterface 372 1 0
    //   209: ifeq +51 -> 260
    //   212: iload_2
    //   213: istore 4
    //   215: ldc_w 281
    //   218: ldc_w 454
    //   221: aload_1
    //   222: invokeinterface 378 1 0
    //   227: checkcast 285	java/lang/Integer
    //   230: invokestatic 334	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   233: invokestatic 363	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: goto -38 -> 198
    //   239: astore_1
    //   240: ldc_w 281
    //   243: aload_1
    //   244: checkcast 456	java/lang/Throwable
    //   247: ldc_w 457
    //   250: iconst_0
    //   251: anewarray 4	java/lang/Object
    //   254: invokestatic 461	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: iload 4
    //   259: istore_3
    //   260: ldc_w 415
    //   263: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: iload_3
    //   267: ireturn
    //   268: astore_1
    //   269: iconst_0
    //   270: istore 4
    //   272: goto -32 -> 240
    //   275: iload_3
    //   276: iconst_1
    //   277: iadd
    //   278: istore_3
    //   279: goto -226 -> 53
    //   282: iconst_0
    //   283: istore_2
    //   284: goto -127 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	this	w
    //   0	287	1	paramw	com.tencent.mm.compatible.deviceinfo.w
    //   54	230	2	i	int
    //   52	227	3	j	int
    //   56	215	4	k	int
    //   25	47	5	localObject	Object
    //   81	66	6	localSize	android.hardware.Camera.Size
    // Exception table:
    //   from	to	target	type
    //   58	68	239	java/lang/Exception
    //   71	83	239	java/lang/Exception
    //   86	126	239	java/lang/Exception
    //   133	142	239	java/lang/Exception
    //   145	154	239	java/lang/Exception
    //   160	168	239	java/lang/Exception
    //   179	188	239	java/lang/Exception
    //   191	198	239	java/lang/Exception
    //   203	212	239	java/lang/Exception
    //   215	236	239	java/lang/Exception
    //   18	27	268	java/lang/Exception
    //   32	51	268	java/lang/Exception
  }
  
  private static void g(com.tencent.mm.compatible.deviceinfo.w paramw)
  {
    AppMethodBeat.i(284813);
    if (paramw == null)
    {
      AppMethodBeat.o(284813);
      return;
    }
    try
    {
      paramw = paramw.aPy().getSupportedPreviewFrameRates();
      String str2 = "supportFps:";
      String str1 = str2;
      if (paramw != null)
      {
        i = 0;
        int k = paramw.size() - 1;
        str1 = str2;
        if (k >= 0)
        {
          str1 = "supportFps:";
          j = i + 1;
          i = ((Number)paramw.get(i)).intValue();
          str1 = str1 + i + ',';
          if (j <= k) {
            break label145;
          }
        }
      }
      Log.i("MicroMsg.Voip.CaptureRender", str1);
      AppMethodBeat.o(284813);
      return;
    }
    catch (Exception paramw)
    {
      for (;;)
      {
        int j;
        Log.d("MicroMsg.Voip.CaptureRender", s.X("getSupportedPreviewFrameRates:error:", paramw));
        paramw = null;
        continue;
        label145:
        int i = j;
      }
    }
  }
  
  private final void ggF()
  {
    AppMethodBeat.i(284753);
    for (;;)
    {
      int i;
      int k;
      int j;
      try
      {
        if ((this.Abo != null) && (this.LpS))
        {
          if (this.LpQ != null)
          {
            localObject = this.LpQ;
            s.checkNotNull(localObject);
            if (((ad)localObject).height > 0)
            {
              localObject = this.LpQ;
              s.checkNotNull(localObject);
              if (((ad)localObject).width > 0)
              {
                localObject = this.LpQ;
                s.checkNotNull(localObject);
                i = ((ad)localObject).height;
                localObject = this.LpQ;
                s.checkNotNull(localObject);
                k = i * ((ad)localObject).width * 3 / 2;
                if (this.LpZ == null)
                {
                  this.LpZ = ((List)new ArrayList(3));
                  i = 0;
                  j = i + 1;
                  localObject = this.LpZ;
                  if (localObject == null) {
                    break label331;
                  }
                  ((List)localObject).add(new byte[k]);
                  break label331;
                }
                label158:
                localObject = this.LpZ;
                s.checkNotNull(localObject);
                k = ((List)localObject).size() - 1;
                if (k >= 0)
                {
                  i = 0;
                  label185:
                  j = i + 1;
                  if (this.Abo == null) {
                    break label341;
                  }
                  localObject = this.Abo;
                  s.checkNotNull(localObject);
                  List localList = this.LpZ;
                  s.checkNotNull(localList);
                  ((com.tencent.mm.compatible.deviceinfo.w)localObject).aj((byte[])localList.get(i));
                  break label341;
                }
                localObject = this.Abo;
                s.checkNotNull(localObject);
                ((com.tencent.mm.compatible.deviceinfo.w)localObject).b(this.Lqf);
                AppMethodBeat.o(284753);
                return;
              }
            }
          }
          Object localObject = this.Abo;
          s.checkNotNull(localObject);
          ((com.tencent.mm.compatible.deviceinfo.w)localObject).a(this.Lqf);
          AppMethodBeat.o(284753);
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", (Throwable)localException, "setPreviewCallback error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(284753);
        return;
      }
      label331:
      label341:
      do
      {
        i = j;
        break label185;
        i = j;
        if (j < 3) {
          break;
        }
        break label158;
      } while (j <= k);
    }
  }
  
  /* Error */
  private final int o(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 526
    //   3: invokestatic 222	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 281
    //   9: ldc_w 528
    //   12: iload_1
    //   13: invokestatic 349	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   16: invokestatic 334	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   19: invokestatic 363	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield 407	com/tencent/mm/plugin/multitalk/model/w:LpT	Z
    //   27: iconst_1
    //   28: istore 17
    //   30: iload 17
    //   32: istore 16
    //   34: aload_0
    //   35: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   38: ifnull +88 -> 126
    //   41: aload_0
    //   42: getfield 530	com/tencent/mm/plugin/multitalk/model/w:LpL	Z
    //   45: iload_1
    //   46: if_icmpeq +114 -> 160
    //   49: aload_0
    //   50: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   53: astore 18
    //   55: aload 18
    //   57: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   60: aload 18
    //   62: getfield 533	com/tencent/mm/compatible/deviceinfo/w:lWt	Z
    //   65: ifne +20 -> 85
    //   68: aload_0
    //   69: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   72: astore 18
    //   74: aload 18
    //   76: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   79: aload 18
    //   81: aconst_null
    //   82: invokevirtual 517	com/tencent/mm/compatible/deviceinfo/w:a	(Landroid/hardware/Camera$PreviewCallback;)V
    //   85: aload_0
    //   86: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   89: astore 18
    //   91: aload 18
    //   93: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   96: aload 18
    //   98: invokevirtual 536	com/tencent/mm/compatible/deviceinfo/w:auq	()V
    //   101: aload_0
    //   102: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   105: astore 18
    //   107: aload 18
    //   109: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   112: aload 18
    //   114: invokevirtual 539	com/tencent/mm/compatible/deviceinfo/w:release	()V
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   122: iload 17
    //   124: istore 16
    //   126: iload 16
    //   128: ifeq +46 -> 174
    //   131: aload_0
    //   132: aload_0
    //   133: iload_1
    //   134: invokespecial 543	com/tencent/mm/plugin/multitalk/model/w:zf	(Z)Lcom/tencent/mm/compatible/deviceinfo/w;
    //   137: putfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   140: aload_0
    //   141: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   144: ifnonnull +25 -> 169
    //   147: aload_0
    //   148: iconst_0
    //   149: putfield 490	com/tencent/mm/plugin/multitalk/model/w:LpS	Z
    //   152: ldc_w 526
    //   155: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: iconst_m1
    //   159: ireturn
    //   160: aload_0
    //   161: getfield 545	com/tencent/mm/plugin/multitalk/model/w:Lqd	Z
    //   164: istore 16
    //   166: goto -40 -> 126
    //   169: aload_0
    //   170: iconst_0
    //   171: putfield 545	com/tencent/mm/plugin/multitalk/model/w:Lqd	Z
    //   174: aload_0
    //   175: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   178: ifnull +20 -> 198
    //   181: aload_0
    //   182: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   185: astore 18
    //   187: aload 18
    //   189: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   192: aload 18
    //   194: invokevirtual 307	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   197: pop
    //   198: aload_0
    //   199: iconst_1
    //   200: putfield 490	com/tencent/mm/plugin/multitalk/model/w:LpS	Z
    //   203: aload_0
    //   204: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   207: astore 18
    //   209: getstatic 549	com/tencent/mm/plugin/voip/video/camera/a/d:UOi	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   212: getfield 554	com/tencent/mm/plugin/voip/video/camera/prev/b:UOI	I
    //   215: istore 11
    //   217: aload 18
    //   219: ifnull +263 -> 482
    //   222: bipush 26
    //   224: istore 4
    //   226: ldc_w 281
    //   229: ldc_w 556
    //   232: iconst_1
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: iload 11
    //   240: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: aastore
    //   244: invokestatic 351	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: aload 18
    //   249: invokevirtual 307	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   252: astore 19
    //   254: invokestatic 559	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   257: ifeq +27 -> 284
    //   260: ldc_w 561
    //   263: invokestatic 567	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   266: checkcast 561	com/tencent/mm/plugin/zero/b/a
    //   269: invokeinterface 571 1 0
    //   274: ldc_w 573
    //   277: bipush 26
    //   279: invokevirtual 579	com/tencent/mm/k/f:getInt	(Ljava/lang/String;I)I
    //   282: istore 4
    //   284: ldc_w 281
    //   287: ldc_w 581
    //   290: iconst_1
    //   291: anewarray 4	java/lang/Object
    //   294: dup
    //   295: iconst_0
    //   296: iload 4
    //   298: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   301: aastore
    //   302: invokestatic 351	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: invokestatic 586	com/tencent/mm/compatible/util/l:isSamsung	()Z
    //   308: ifne +11 -> 319
    //   311: iload 4
    //   313: invokestatic 592	com/tencent/mm/compatible/util/d:rb	(I)Z
    //   316: ifeq +1206 -> 1522
    //   319: ldc_w 593
    //   322: istore 6
    //   324: iconst_0
    //   325: istore 16
    //   327: iconst_m1
    //   328: istore 4
    //   330: iconst_m1
    //   331: istore 5
    //   333: getstatic 388	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   336: ifnull +1947 -> 2283
    //   339: getstatic 388	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   342: getfield 596	com/tencent/mm/compatible/deviceinfo/c:lTD	I
    //   345: sipush 1000
    //   348: imul
    //   349: istore 4
    //   351: getstatic 388	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   354: getfield 599	com/tencent/mm/compatible/deviceinfo/c:lTE	I
    //   357: sipush 1000
    //   360: imul
    //   361: istore 5
    //   363: goto +1920 -> 2283
    //   366: ldc_w 281
    //   369: ldc_w 601
    //   372: iconst_4
    //   373: anewarray 4	java/lang/Object
    //   376: dup
    //   377: iconst_0
    //   378: iload 4
    //   380: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   383: aastore
    //   384: dup
    //   385: iconst_1
    //   386: iload 5
    //   388: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   391: aastore
    //   392: dup
    //   393: iconst_2
    //   394: iload 11
    //   396: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   399: aastore
    //   400: dup
    //   401: iconst_3
    //   402: iload 16
    //   404: invokestatic 349	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   407: aastore
    //   408: invokestatic 351	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: iload 4
    //   413: ldc_w 593
    //   416: if_icmpeq +16 -> 432
    //   419: iload 5
    //   421: ldc_w 593
    //   424: if_icmpeq +8 -> 432
    //   427: iload 16
    //   429: ifne +1034 -> 1463
    //   432: iconst_1
    //   433: istore 4
    //   435: iload 4
    //   437: ifeq +45 -> 482
    //   440: ldc_w 281
    //   443: ldc_w 603
    //   446: iconst_1
    //   447: anewarray 4	java/lang/Object
    //   450: dup
    //   451: iconst_0
    //   452: iload 11
    //   454: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   457: aastore
    //   458: invokestatic 351	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   461: aload 18
    //   463: invokevirtual 307	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   466: astore 19
    //   468: aload 19
    //   470: iload 11
    //   472: invokevirtual 606	android/hardware/Camera$Parameters:setPreviewFrameRate	(I)V
    //   475: aload 18
    //   477: aload 19
    //   479: invokevirtual 314	com/tencent/mm/compatible/deviceinfo/w:c	(Landroid/hardware/Camera$Parameters;)V
    //   482: ldc_w 281
    //   485: new 422	java/lang/StringBuilder
    //   488: dup
    //   489: ldc_w 608
    //   492: invokespecial 426	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   495: iload_2
    //   496: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: bipush 44
    //   501: invokevirtual 436	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   504: iload_3
    //   505: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   508: invokevirtual 443	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 363	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: iload_1
    //   515: ifeq +1054 -> 1569
    //   518: getstatic 549	com/tencent/mm/plugin/voip/video/camera/a/d:UOi	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   521: getfield 612	com/tencent/mm/plugin/voip/video/camera/prev/b:UON	Landroid/graphics/Point;
    //   524: astore 18
    //   526: aload 18
    //   528: ifnull +1052 -> 1580
    //   531: iconst_1
    //   532: istore 4
    //   534: aconst_null
    //   535: astore 21
    //   537: aload 18
    //   539: ifnull +1715 -> 2254
    //   542: new 498	com/tencent/mm/compatible/deviceinfo/ad
    //   545: dup
    //   546: aload 18
    //   548: getfield 617	android/graphics/Point:x	I
    //   551: aload 18
    //   553: getfield 620	android/graphics/Point:y	I
    //   556: invokespecial 622	com/tencent/mm/compatible/deviceinfo/ad:<init>	(II)V
    //   559: astore 19
    //   561: ldc_w 281
    //   564: new 422	java/lang/StringBuilder
    //   567: dup
    //   568: ldc_w 624
    //   571: invokespecial 426	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   574: aload 19
    //   576: getfield 500	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   579: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   582: bipush 44
    //   584: invokevirtual 436	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   587: aload 19
    //   589: getfield 499	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   592: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   595: invokevirtual 443	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 363	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   601: aload_0
    //   602: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   605: astore 18
    //   607: aload 18
    //   609: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   612: aload 18
    //   614: invokevirtual 307	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   617: astore 23
    //   619: new 614	android/graphics/Point
    //   622: dup
    //   623: iload_2
    //   624: iload_3
    //   625: invokespecial 625	android/graphics/Point:<init>	(II)V
    //   628: astore 22
    //   630: aload 23
    //   632: ldc_w 627
    //   635: invokevirtual 630	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   638: astore 20
    //   640: aload 20
    //   642: astore 18
    //   644: aload 20
    //   646: ifnonnull +13 -> 659
    //   649: aload 23
    //   651: ldc_w 632
    //   654: invokevirtual 630	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   657: astore 18
    //   659: aload 18
    //   661: ifnull +1587 -> 2248
    //   664: ldc_w 281
    //   667: ldc_w 634
    //   670: aload 18
    //   672: invokestatic 334	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   675: invokestatic 363	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: aload 18
    //   680: checkcast 636	java/lang/CharSequence
    //   683: aload 22
    //   685: invokestatic 639	com/tencent/mm/plugin/multitalk/model/w$a:a	(Ljava/lang/CharSequence;Landroid/graphics/Point;)Landroid/graphics/Point;
    //   688: astore 18
    //   690: aload 18
    //   692: astore 20
    //   694: aload 18
    //   696: ifnonnull +30 -> 726
    //   699: new 614	android/graphics/Point
    //   702: dup
    //   703: aload 22
    //   705: getfield 617	android/graphics/Point:x	I
    //   708: iconst_3
    //   709: ishr
    //   710: iconst_3
    //   711: ishl
    //   712: aload 22
    //   714: getfield 620	android/graphics/Point:y	I
    //   717: iconst_3
    //   718: ishr
    //   719: iconst_3
    //   720: ishl
    //   721: invokespecial 625	android/graphics/Point:<init>	(II)V
    //   724: astore 20
    //   726: new 498	com/tencent/mm/compatible/deviceinfo/ad
    //   729: dup
    //   730: aload 20
    //   732: getfield 617	android/graphics/Point:x	I
    //   735: aload 20
    //   737: getfield 620	android/graphics/Point:y	I
    //   740: invokespecial 622	com/tencent/mm/compatible/deviceinfo/ad:<init>	(II)V
    //   743: astore 18
    //   745: ldc_w 281
    //   748: new 422	java/lang/StringBuilder
    //   751: dup
    //   752: ldc_w 641
    //   755: invokespecial 426	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   758: aload 18
    //   760: getfield 500	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   763: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   766: bipush 44
    //   768: invokevirtual 436	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   771: aload 18
    //   773: getfield 499	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   776: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   779: invokevirtual 443	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   782: invokestatic 363	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   785: iload 4
    //   787: ifeq +829 -> 1616
    //   790: aload_0
    //   791: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   794: astore 20
    //   796: aload 19
    //   798: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   801: aload 20
    //   803: aload 19
    //   805: getfield 500	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   808: aload 19
    //   810: getfield 499	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   813: invokestatic 643	com/tencent/mm/plugin/multitalk/model/w:a	(Lcom/tencent/mm/compatible/deviceinfo/w;II)Z
    //   816: istore_1
    //   817: ldc_w 281
    //   820: new 422	java/lang/StringBuilder
    //   823: dup
    //   824: ldc_w 645
    //   827: invokespecial 426	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   830: aload 19
    //   832: getfield 500	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   835: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   838: ldc_w 647
    //   841: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: aload 19
    //   846: getfield 499	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   849: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   852: invokevirtual 443	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: invokestatic 363	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   858: iload_1
    //   859: ifne +881 -> 1740
    //   862: aload 18
    //   864: ifnull +876 -> 1740
    //   867: ldc_w 281
    //   870: new 422	java/lang/StringBuilder
    //   873: dup
    //   874: ldc_w 649
    //   877: invokespecial 426	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   880: aload 18
    //   882: getfield 500	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   885: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   888: ldc_w 647
    //   891: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: aload 18
    //   896: getfield 499	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   899: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   902: invokevirtual 443	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokestatic 338	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   908: aload_0
    //   909: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   912: aload 18
    //   914: getfield 500	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   917: aload 18
    //   919: getfield 499	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   922: invokestatic 643	com/tencent/mm/plugin/multitalk/model/w:a	(Lcom/tencent/mm/compatible/deviceinfo/w;II)Z
    //   925: ifne +815 -> 1740
    //   928: ldc_w 281
    //   931: new 422	java/lang/StringBuilder
    //   934: dup
    //   935: ldc_w 651
    //   938: invokespecial 426	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   941: aload 18
    //   943: getfield 500	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   946: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   949: ldc_w 647
    //   952: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: aload 18
    //   957: getfield 499	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   960: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   963: invokevirtual 443	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   966: invokestatic 338	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   969: ldc_w 526
    //   972: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   975: iconst_m1
    //   976: ireturn
    //   977: astore 18
    //   979: getstatic 320	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   982: ldc2_w 321
    //   985: lconst_0
    //   986: lconst_1
    //   987: iconst_0
    //   988: invokevirtual 326	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   991: ldc_w 281
    //   994: ldc_w 653
    //   997: iconst_1
    //   998: anewarray 4	java/lang/Object
    //   1001: dup
    //   1002: iconst_0
    //   1003: aload 18
    //   1005: invokevirtual 522	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1008: aastore
    //   1009: invokestatic 655	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1012: aload_0
    //   1013: getfield 657	com/tencent/mm/plugin/multitalk/model/w:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   1016: ifnull +99 -> 1115
    //   1019: aload_0
    //   1020: getfield 657	com/tencent/mm/plugin/multitalk/model/w:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   1023: astore 19
    //   1025: aload 19
    //   1027: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   1030: aload 19
    //   1032: invokeinterface 662 1 0
    //   1037: aload_0
    //   1038: iconst_1
    //   1039: putfield 545	com/tencent/mm/plugin/multitalk/model/w:Lqd	Z
    //   1042: aload_0
    //   1043: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1046: astore 19
    //   1048: aload 19
    //   1050: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   1053: aload 19
    //   1055: getfield 533	com/tencent/mm/compatible/deviceinfo/w:lWt	Z
    //   1058: ifne +20 -> 1078
    //   1061: aload_0
    //   1062: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1065: astore 19
    //   1067: aload 19
    //   1069: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   1072: aload 19
    //   1074: aconst_null
    //   1075: invokevirtual 517	com/tencent/mm/compatible/deviceinfo/w:a	(Landroid/hardware/Camera$PreviewCallback;)V
    //   1078: aload_0
    //   1079: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1082: astore 19
    //   1084: aload 19
    //   1086: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   1089: aload 19
    //   1091: invokevirtual 536	com/tencent/mm/compatible/deviceinfo/w:auq	()V
    //   1094: aload_0
    //   1095: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1098: astore 19
    //   1100: aload 19
    //   1102: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   1105: aload 19
    //   1107: invokevirtual 539	com/tencent/mm/compatible/deviceinfo/w:release	()V
    //   1110: aload_0
    //   1111: aconst_null
    //   1112: putfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1115: ldc_w 526
    //   1118: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1121: iconst_m1
    //   1122: ireturn
    //   1123: astore 19
    //   1125: ldc_w 281
    //   1128: aload 19
    //   1130: checkcast 456	java/lang/Throwable
    //   1133: ldc_w 664
    //   1136: iconst_1
    //   1137: anewarray 4	java/lang/Object
    //   1140: dup
    //   1141: iconst_0
    //   1142: aload 18
    //   1144: invokevirtual 522	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1147: aastore
    //   1148: invokestatic 461	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1151: goto -36 -> 1115
    //   1154: iload 4
    //   1156: ifne +24 -> 1180
    //   1159: iload 5
    //   1161: ifne +19 -> 1180
    //   1164: iconst_0
    //   1165: istore 16
    //   1167: ldc_w 665
    //   1170: istore 4
    //   1172: ldc_w 665
    //   1175: istore 5
    //   1177: goto -811 -> 366
    //   1180: aload 19
    //   1182: invokevirtual 668	android/hardware/Camera$Parameters:getSupportedPreviewFpsRange	()Ljava/util/List;
    //   1185: astore 20
    //   1187: aload 20
    //   1189: ifnull +1117 -> 2306
    //   1192: aload 20
    //   1194: invokeinterface 361 1 0
    //   1199: ifne +6 -> 1205
    //   1202: goto +1104 -> 2306
    //   1205: aload 20
    //   1207: invokeinterface 361 1 0
    //   1212: istore 12
    //   1214: iconst_0
    //   1215: istore 7
    //   1217: iload 12
    //   1219: ifle +1051 -> 2270
    //   1222: iconst_0
    //   1223: istore 16
    //   1225: ldc_w 665
    //   1228: istore 8
    //   1230: ldc_w 665
    //   1233: istore 4
    //   1235: iload 6
    //   1237: istore 5
    //   1239: iload 8
    //   1241: istore 6
    //   1243: iload 7
    //   1245: iconst_1
    //   1246: iadd
    //   1247: istore 8
    //   1249: aload 20
    //   1251: iload 7
    //   1253: invokeinterface 473 2 0
    //   1258: checkcast 670	[I
    //   1261: astore 21
    //   1263: aload 21
    //   1265: ifnull +1047 -> 2312
    //   1268: aload 21
    //   1270: arraylength
    //   1271: iconst_1
    //   1272: if_icmpgt +6 -> 1278
    //   1275: goto +1037 -> 2312
    //   1278: aload 21
    //   1280: iconst_0
    //   1281: iaload
    //   1282: istore 10
    //   1284: aload 21
    //   1286: iconst_1
    //   1287: iaload
    //   1288: istore 9
    //   1290: ldc_w 281
    //   1293: ldc_w 672
    //   1296: iconst_3
    //   1297: anewarray 4	java/lang/Object
    //   1300: dup
    //   1301: iconst_0
    //   1302: iload 7
    //   1304: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1307: aastore
    //   1308: dup
    //   1309: iconst_1
    //   1310: iload 10
    //   1312: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1315: aastore
    //   1316: dup
    //   1317: iconst_2
    //   1318: iload 9
    //   1320: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1323: aastore
    //   1324: invokestatic 351	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1327: iload 10
    //   1329: iflt +1001 -> 2330
    //   1332: iload 9
    //   1334: iload 10
    //   1336: if_icmpge +6 -> 1342
    //   1339: goto +991 -> 2330
    //   1342: iload 9
    //   1344: sipush 1000
    //   1347: idiv
    //   1348: istore 13
    //   1350: iload 10
    //   1352: sipush 1000
    //   1355: idiv
    //   1356: istore 14
    //   1358: iload 11
    //   1360: iconst_5
    //   1361: iadd
    //   1362: bipush 30
    //   1364: invokestatic 678	java/lang/Math:min	(II)I
    //   1367: istore 7
    //   1369: iload 11
    //   1371: iconst_5
    //   1372: isub
    //   1373: iconst_5
    //   1374: invokestatic 681	java/lang/Math:max	(II)I
    //   1377: istore 15
    //   1379: iload 13
    //   1381: iload 15
    //   1383: if_icmplt +950 -> 2333
    //   1386: iload 13
    //   1388: iload 7
    //   1390: if_icmpgt +943 -> 2333
    //   1393: iload 14
    //   1395: iload 15
    //   1397: if_icmplt +936 -> 2333
    //   1400: iload 14
    //   1402: iload 7
    //   1404: if_icmpgt +929 -> 2333
    //   1407: iconst_1
    //   1408: istore 7
    //   1410: iload 7
    //   1412: ifeq +855 -> 2267
    //   1415: iload 11
    //   1417: iload 14
    //   1419: isub
    //   1420: invokestatic 685	java/lang/Math:abs	(I)I
    //   1423: istore 7
    //   1425: iload 13
    //   1427: iload 11
    //   1429: isub
    //   1430: invokestatic 685	java/lang/Math:abs	(I)I
    //   1433: iload 7
    //   1435: iadd
    //   1436: istore 7
    //   1438: iload 7
    //   1440: iload 5
    //   1442: if_icmpge +825 -> 2267
    //   1445: iconst_1
    //   1446: istore 16
    //   1448: iload 10
    //   1450: istore 6
    //   1452: iload 9
    //   1454: istore 4
    //   1456: iload 7
    //   1458: istore 5
    //   1460: goto +852 -> 2312
    //   1463: ldc_w 281
    //   1466: ldc_w 687
    //   1469: iconst_3
    //   1470: anewarray 4	java/lang/Object
    //   1473: dup
    //   1474: iconst_0
    //   1475: iload 4
    //   1477: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1480: aastore
    //   1481: dup
    //   1482: iconst_1
    //   1483: iload 5
    //   1485: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1488: aastore
    //   1489: dup
    //   1490: iconst_2
    //   1491: iload 11
    //   1493: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1496: aastore
    //   1497: invokestatic 351	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1500: aload 19
    //   1502: iload 4
    //   1504: iload 5
    //   1506: invokevirtual 690	android/hardware/Camera$Parameters:setPreviewFpsRange	(II)V
    //   1509: aload 18
    //   1511: aload 19
    //   1513: invokevirtual 314	com/tencent/mm/compatible/deviceinfo/w:c	(Landroid/hardware/Camera$Parameters;)V
    //   1516: iconst_0
    //   1517: istore 4
    //   1519: goto -1084 -> 435
    //   1522: iconst_1
    //   1523: istore 4
    //   1525: goto -1090 -> 435
    //   1528: astore 19
    //   1530: ldc_w 281
    //   1533: ldc_w 692
    //   1536: aload 19
    //   1538: invokestatic 334	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1541: invokestatic 338	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1544: iconst_1
    //   1545: istore 4
    //   1547: goto -1112 -> 435
    //   1550: astore 18
    //   1552: ldc_w 281
    //   1555: ldc_w 694
    //   1558: aload 18
    //   1560: invokestatic 334	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   1563: invokestatic 338	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1566: goto -1084 -> 482
    //   1569: getstatic 549	com/tencent/mm/plugin/voip/video/camera/a/d:UOi	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   1572: getfield 697	com/tencent/mm/plugin/voip/video/camera/prev/b:UOO	Landroid/graphics/Point;
    //   1575: astore 18
    //   1577: goto -1051 -> 526
    //   1580: iconst_0
    //   1581: istore 4
    //   1583: goto -1049 -> 534
    //   1586: astore 20
    //   1588: aload 21
    //   1590: astore 18
    //   1592: ldc_w 281
    //   1595: ldc_w 699
    //   1598: iconst_1
    //   1599: anewarray 4	java/lang/Object
    //   1602: dup
    //   1603: iconst_0
    //   1604: aload 20
    //   1606: invokevirtual 522	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1609: aastore
    //   1610: invokestatic 655	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1613: goto -828 -> 785
    //   1616: ldc_w 281
    //   1619: ldc_w 701
    //   1622: invokestatic 363	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1625: aload 18
    //   1627: ifnull +113 -> 1740
    //   1630: ldc_w 281
    //   1633: new 422	java/lang/StringBuilder
    //   1636: dup
    //   1637: ldc_w 703
    //   1640: invokespecial 426	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1643: aload 18
    //   1645: getfield 500	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   1648: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1651: ldc_w 647
    //   1654: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1657: aload 18
    //   1659: getfield 499	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   1662: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1665: invokevirtual 443	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1668: invokestatic 363	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1671: aload_0
    //   1672: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1675: aload 18
    //   1677: getfield 500	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   1680: aload 18
    //   1682: getfield 499	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   1685: invokestatic 643	com/tencent/mm/plugin/multitalk/model/w:a	(Lcom/tencent/mm/compatible/deviceinfo/w;II)Z
    //   1688: ifne +52 -> 1740
    //   1691: ldc_w 281
    //   1694: new 422	java/lang/StringBuilder
    //   1697: dup
    //   1698: ldc_w 705
    //   1701: invokespecial 426	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1704: aload 18
    //   1706: getfield 500	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   1709: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1712: ldc_w 647
    //   1715: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1718: aload 18
    //   1720: getfield 499	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   1723: invokevirtual 433	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1726: invokevirtual 443	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1729: invokestatic 338	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1732: ldc_w 526
    //   1735: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1738: iconst_m1
    //   1739: ireturn
    //   1740: aload_0
    //   1741: aload_0
    //   1742: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1745: aload_0
    //   1746: getfield 530	com/tencent/mm/plugin/multitalk/model/w:LpL	Z
    //   1749: invokespecial 707	com/tencent/mm/plugin/multitalk/model/w:b	(Lcom/tencent/mm/compatible/deviceinfo/w;Z)Z
    //   1752: pop
    //   1753: aload_0
    //   1754: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1757: astore 18
    //   1759: aload 18
    //   1761: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   1764: aload_0
    //   1765: aload 18
    //   1767: invokevirtual 307	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   1770: putfield 709	com/tencent/mm/plugin/multitalk/model/w:LpP	Landroid/hardware/Camera$Parameters;
    //   1773: aload_0
    //   1774: getfield 709	com/tencent/mm/plugin/multitalk/model/w:LpP	Landroid/hardware/Camera$Parameters;
    //   1777: astore 18
    //   1779: aload 18
    //   1781: ifnonnull +252 -> 2033
    //   1784: aconst_null
    //   1785: astore 18
    //   1787: aload 18
    //   1789: ifnull +24 -> 1813
    //   1792: aload_0
    //   1793: new 498	com/tencent/mm/compatible/deviceinfo/ad
    //   1796: dup
    //   1797: aload 18
    //   1799: getfield 429	android/hardware/Camera$Size:width	I
    //   1802: aload 18
    //   1804: getfield 439	android/hardware/Camera$Size:height	I
    //   1807: invokespecial 622	com/tencent/mm/compatible/deviceinfo/ad:<init>	(II)V
    //   1810: putfield 492	com/tencent/mm/plugin/multitalk/model/w:LpQ	Lcom/tencent/mm/compatible/deviceinfo/ad;
    //   1813: aload_0
    //   1814: getfield 709	com/tencent/mm/plugin/multitalk/model/w:LpP	Landroid/hardware/Camera$Parameters;
    //   1817: astore 18
    //   1819: aload 18
    //   1821: ifnonnull +265 -> 2086
    //   1824: aconst_null
    //   1825: astore 18
    //   1827: aload_0
    //   1828: getstatic 712	com/tencent/mm/plugin/voip/video/camera/a/d:UOn	I
    //   1831: putfield 714	com/tencent/mm/plugin/multitalk/model/w:LpR	I
    //   1834: aload_0
    //   1835: getfield 714	com/tencent/mm/plugin/multitalk/model/w:LpR	I
    //   1838: ifgt +9 -> 1847
    //   1841: aload_0
    //   1842: bipush 7
    //   1844: putfield 714	com/tencent/mm/plugin/multitalk/model/w:LpR	I
    //   1847: aload_0
    //   1848: getfield 488	com/tencent/mm/plugin/multitalk/model/w:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1851: astore 19
    //   1853: new 716	android/hardware/Camera$CameraInfo
    //   1856: dup
    //   1857: invokespecial 717	android/hardware/Camera$CameraInfo:<init>	()V
    //   1860: astore 20
    //   1862: aload_0
    //   1863: getfield 530	com/tencent/mm/plugin/multitalk/model/w:LpL	Z
    //   1866: ifeq +233 -> 2099
    //   1869: getstatic 720	com/tencent/mm/plugin/voip/video/camera/a/d:UOj	I
    //   1872: istore_2
    //   1873: iload_2
    //   1874: aload 20
    //   1876: invokestatic 726	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   1879: invokestatic 268	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1882: ldc_w 728
    //   1885: invokevirtual 732	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1888: astore 21
    //   1890: aload 21
    //   1892: ifnonnull +214 -> 2106
    //   1895: new 734	java/lang/NullPointerException
    //   1898: dup
    //   1899: ldc_w 736
    //   1902: invokespecial 737	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   1905: astore 19
    //   1907: ldc_w 526
    //   1910: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1913: aload 19
    //   1915: athrow
    //   1916: astore 19
    //   1918: ldc_w 281
    //   1921: ldc_w 739
    //   1924: iconst_1
    //   1925: anewarray 4	java/lang/Object
    //   1928: dup
    //   1929: iconst_0
    //   1930: aload 19
    //   1932: invokevirtual 522	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1935: aastore
    //   1936: invokestatic 655	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1939: aload_0
    //   1940: getfield 492	com/tencent/mm/plugin/multitalk/model/w:LpQ	Lcom/tencent/mm/compatible/deviceinfo/ad;
    //   1943: astore 19
    //   1945: aload 19
    //   1947: ifnonnull +270 -> 2217
    //   1950: aconst_null
    //   1951: astore 19
    //   1953: aload_0
    //   1954: getfield 492	com/tencent/mm/plugin/multitalk/model/w:LpQ	Lcom/tencent/mm/compatible/deviceinfo/ad;
    //   1957: astore 20
    //   1959: aload 20
    //   1961: ifnonnull +269 -> 2230
    //   1964: aconst_null
    //   1965: astore 20
    //   1967: ldc_w 281
    //   1970: ldc_w 741
    //   1973: bipush 6
    //   1975: anewarray 4	java/lang/Object
    //   1978: dup
    //   1979: iconst_0
    //   1980: aload 18
    //   1982: aastore
    //   1983: dup
    //   1984: iconst_1
    //   1985: aload 19
    //   1987: aastore
    //   1988: dup
    //   1989: iconst_2
    //   1990: aload 20
    //   1992: aastore
    //   1993: dup
    //   1994: iconst_3
    //   1995: aload_0
    //   1996: getfield 714	com/tencent/mm/plugin/multitalk/model/w:LpR	I
    //   1999: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2002: aastore
    //   2003: dup
    //   2004: iconst_4
    //   2005: getstatic 744	com/tencent/mm/plugin/voip/video/camera/a/d:UOl	I
    //   2008: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2011: aastore
    //   2012: dup
    //   2013: iconst_5
    //   2014: aload_0
    //   2015: getfield 746	com/tencent/mm/plugin/multitalk/model/w:Lqa	I
    //   2018: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2021: aastore
    //   2022: invokestatic 351	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2025: ldc_w 526
    //   2028: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2031: iconst_1
    //   2032: ireturn
    //   2033: aload 18
    //   2035: invokevirtual 749	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   2038: astore 18
    //   2040: goto -253 -> 1787
    //   2043: astore 18
    //   2045: getstatic 320	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   2048: ldc2_w 321
    //   2051: lconst_0
    //   2052: lconst_1
    //   2053: iconst_0
    //   2054: invokevirtual 326	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   2057: ldc_w 281
    //   2060: ldc_w 751
    //   2063: iconst_1
    //   2064: anewarray 4	java/lang/Object
    //   2067: dup
    //   2068: iconst_0
    //   2069: aload 18
    //   2071: invokevirtual 522	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2074: aastore
    //   2075: invokestatic 655	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2078: ldc_w 526
    //   2081: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2084: iconst_m1
    //   2085: ireturn
    //   2086: aload 18
    //   2088: invokevirtual 754	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   2091: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2094: astore 18
    //   2096: goto -269 -> 1827
    //   2099: getstatic 757	com/tencent/mm/plugin/voip/video/camera/a/d:UOk	I
    //   2102: istore_2
    //   2103: goto -230 -> 1873
    //   2106: aload 21
    //   2108: checkcast 759	android/view/WindowManager
    //   2111: invokeinterface 763 1 0
    //   2116: invokevirtual 768	android/view/Display:getRotation	()I
    //   2119: istore_3
    //   2120: iconst_0
    //   2121: istore_2
    //   2122: iload_3
    //   2123: tableswitch	default:+216 -> 2339, 0:+219->2342, 1:+224->2347, 2:+230->2353, 3:+237->2360
    //   2153: getfield 530	com/tencent/mm/plugin/multitalk/model/w:LpL	Z
    //   2156: ifeq +42 -> 2198
    //   2159: sipush 360
    //   2162: iload_2
    //   2163: aload 20
    //   2165: getfield 771	android/hardware/Camera$CameraInfo:orientation	I
    //   2168: iadd
    //   2169: sipush 360
    //   2172: irem
    //   2173: isub
    //   2174: sipush 360
    //   2177: irem
    //   2178: istore_2
    //   2179: aload 19
    //   2181: invokestatic 496	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   2184: aload 19
    //   2186: iload_2
    //   2187: invokevirtual 774	com/tencent/mm/compatible/deviceinfo/w:qV	(I)V
    //   2190: aload_0
    //   2191: iload_2
    //   2192: putfield 746	com/tencent/mm/plugin/multitalk/model/w:Lqa	I
    //   2195: goto -256 -> 1939
    //   2198: aload 20
    //   2200: getfield 771	android/hardware/Camera$CameraInfo:orientation	I
    //   2203: iload_2
    //   2204: isub
    //   2205: sipush 360
    //   2208: iadd
    //   2209: sipush 360
    //   2212: irem
    //   2213: istore_2
    //   2214: goto -35 -> 2179
    //   2217: aload 19
    //   2219: getfield 500	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   2222: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2225: astore 19
    //   2227: goto -274 -> 1953
    //   2230: aload 20
    //   2232: getfield 499	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   2235: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2238: astore 20
    //   2240: goto -273 -> 1967
    //   2243: astore 20
    //   2245: goto -653 -> 1592
    //   2248: aconst_null
    //   2249: astore 18
    //   2251: goto -1561 -> 690
    //   2254: aconst_null
    //   2255: astore 19
    //   2257: goto -1656 -> 601
    //   2260: iload 8
    //   2262: istore 7
    //   2264: goto -1021 -> 1243
    //   2267: goto +45 -> 2312
    //   2270: ldc_w 665
    //   2273: istore 4
    //   2275: ldc_w 665
    //   2278: istore 5
    //   2280: goto -1914 -> 366
    //   2283: iload 4
    //   2285: ifle -1131 -> 1154
    //   2288: iload 5
    //   2290: ifle -1136 -> 1154
    //   2293: iload 5
    //   2295: iload 4
    //   2297: if_icmplt -1143 -> 1154
    //   2300: iconst_1
    //   2301: istore 16
    //   2303: goto -1937 -> 366
    //   2306: iconst_1
    //   2307: istore 4
    //   2309: goto -1874 -> 435
    //   2312: iload 8
    //   2314: iload 12
    //   2316: if_icmplt -56 -> 2260
    //   2319: iload 4
    //   2321: istore 5
    //   2323: iload 6
    //   2325: istore 4
    //   2327: goto -1961 -> 366
    //   2330: goto -18 -> 2312
    //   2333: iconst_0
    //   2334: istore 7
    //   2336: goto -926 -> 1410
    //   2339: goto -187 -> 2152
    //   2342: iconst_0
    //   2343: istore_2
    //   2344: goto -192 -> 2152
    //   2347: bipush 90
    //   2349: istore_2
    //   2350: goto -198 -> 2152
    //   2353: sipush 180
    //   2356: istore_2
    //   2357: goto -205 -> 2152
    //   2360: sipush 270
    //   2363: istore_2
    //   2364: goto -212 -> 2152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2367	0	this	w
    //   0	2367	1	paramBoolean	boolean
    //   0	2367	2	paramInt1	int
    //   0	2367	3	paramInt2	int
    //   224	2102	4	i	int
    //   331	1991	5	j	int
    //   322	2002	6	k	int
    //   1215	1120	7	m	int
    //   1228	1089	8	n	int
    //   1288	165	9	i1	int
    //   1282	167	10	i2	int
    //   215	1277	11	i3	int
    //   1212	1105	12	i4	int
    //   1348	82	13	i5	int
    //   1356	64	14	i6	int
    //   1377	21	15	i7	int
    //   32	2270	16	bool1	boolean
    //   28	95	17	bool2	boolean
    //   53	903	18	localObject1	Object
    //   977	533	18	localException1	Exception
    //   1550	9	18	localException2	Exception
    //   1575	464	18	localObject2	Object
    //   2043	44	18	localException3	Exception
    //   2094	156	18	localInteger	Integer
    //   252	854	19	localObject3	Object
    //   1123	389	19	localException4	Exception
    //   1528	9	19	localException5	Exception
    //   1851	63	19	localObject4	Object
    //   1916	15	19	localException6	Exception
    //   1943	313	19	localObject5	Object
    //   638	612	20	localObject6	Object
    //   1586	19	20	localException7	Exception
    //   1860	379	20	localObject7	Object
    //   2243	1	20	localException8	Exception
    //   535	1572	21	localObject8	Object
    //   628	85	22	localPoint	Point
    //   617	33	23	localParameters	Camera.Parameters
    // Exception table:
    //   from	to	target	type
    //   174	198	977	java/lang/Exception
    //   1019	1078	1123	java/lang/Exception
    //   1078	1115	1123	java/lang/Exception
    //   226	254	1528	java/lang/Exception
    //   254	284	1528	java/lang/Exception
    //   284	319	1528	java/lang/Exception
    //   333	363	1528	java/lang/Exception
    //   366	411	1528	java/lang/Exception
    //   1180	1187	1528	java/lang/Exception
    //   1192	1202	1528	java/lang/Exception
    //   1205	1214	1528	java/lang/Exception
    //   1249	1263	1528	java/lang/Exception
    //   1268	1275	1528	java/lang/Exception
    //   1290	1327	1528	java/lang/Exception
    //   1342	1379	1528	java/lang/Exception
    //   1415	1438	1528	java/lang/Exception
    //   1463	1516	1528	java/lang/Exception
    //   440	482	1550	java/lang/Exception
    //   601	640	1586	java/lang/Exception
    //   649	659	1586	java/lang/Exception
    //   664	690	1586	java/lang/Exception
    //   699	726	1586	java/lang/Exception
    //   726	745	1586	java/lang/Exception
    //   1847	1873	1916	java/lang/Exception
    //   1873	1890	1916	java/lang/Exception
    //   1895	1916	1916	java/lang/Exception
    //   2099	2103	1916	java/lang/Exception
    //   2106	2120	1916	java/lang/Exception
    //   2152	2179	1916	java/lang/Exception
    //   2179	2195	1916	java/lang/Exception
    //   2198	2214	1916	java/lang/Exception
    //   1753	1779	2043	java/lang/Exception
    //   1792	1813	2043	java/lang/Exception
    //   2033	2040	2043	java/lang/Exception
    //   745	785	2243	java/lang/Exception
  }
  
  private final com.tencent.mm.compatible.deviceinfo.w zf(boolean paramBoolean)
  {
    AppMethodBeat.i(284757);
    com.tencent.mm.compatible.deviceinfo.w localw = a.zg(paramBoolean);
    if (localw == null) {}
    for (;;)
    {
      try
      {
        localw = new com.tencent.mm.compatible.deviceinfo.w((Camera)a.a(new Object(), "com/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer", "safeOpenCamera", "(Z)Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "android/hardware/Camera", "open", "()Landroid/hardware/Camera;"));
        this.LpL = false;
        h.OAn.idkeyStat(159L, 0L, 1L, false);
        g(localw);
        f(localw);
        AppMethodBeat.o(284757);
        return localw;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Voip.CaptureRender", s.X("OpenCameraError:", localException));
        h.OAn.idkeyStat(159L, 0L, 1L, false);
        h.OAn.idkeyStat(159L, 1L, 1L, false);
        if (this.LpV != null)
        {
          com.tencent.mm.plugin.voip.video.camera.a.c localc = this.LpV;
          s.checkNotNull(localc);
          localc.dre();
        }
        AppMethodBeat.o(284757);
        return null;
      }
      this.LpL = paramBoolean;
    }
  }
  
  public final int a(com.tencent.mm.plugin.voip.video.camera.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(284842);
    if (com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP <= 0)
    {
      this.LpO = 1;
      AppMethodBeat.o(284842);
      return -1;
    }
    if (paramBoolean) {
      if (!com.tencent.mm.plugin.voip.video.camera.a.d.UOi.UOJ) {
        paramBoolean = false;
      }
    }
    for (;;)
    {
      this.LpV = paramc;
      if (o(paramBoolean, this.mWidth, this.mHeight) > 0) {
        break;
      }
      int i = o(paramBoolean, this.mWidth, this.mHeight);
      if (i > 0) {
        break;
      }
      this.LpO = 1;
      AppMethodBeat.o(284842);
      return i;
      if (!com.tencent.mm.plugin.voip.video.camera.a.d.UOi.UOK) {
        paramBoolean = true;
      }
    }
    this.LpL = paramBoolean;
    ggF();
    this.LpO = 0;
    AppMethodBeat.o(284842);
    return 1;
  }
  
  public final int ggG()
  {
    AppMethodBeat.i(284850);
    if (!this.LpS)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
      this.LpO = 1;
      AppMethodBeat.o(284850);
      return -1;
    }
    if (this.LpW)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: is in capture already ");
      AppMethodBeat.o(284850);
      return -1;
    }
    Log.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", new Object[] { Boolean.valueOf(this.LpU) });
    if (this.mSurfaceTexture != null) {}
    try
    {
      localw = this.Abo;
      s.checkNotNull(localw);
      localw.f(this.mSurfaceTexture);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          com.tencent.mm.compatible.deviceinfo.w localw = this.Abo;
          s.checkNotNull(localw);
          localw.aPz();
          this.nvB = true;
          if (this.Abo != null)
          {
            localw = this.Abo;
            s.checkNotNull(localw);
            localw.a(this.Lqf);
          }
          this.LpW = true;
          AppMethodBeat.o(284850);
          return 1;
          localException1 = localException1;
          h.OAn.idkeyStat(159L, 0L, 1L, false);
          h.OAn.idkeyStat(159L, 2L, 1L, false);
          this.LpO = 1;
          Log.e("MicroMsg.Voip.CaptureRender", s.X("StartCapture:error:", localException1));
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          h.OAn.idkeyStat(159L, 0L, 1L, false);
          h.OAn.idkeyStat(159L, 2L, 1L, false);
          this.LpO = 1;
          if (this.LpV != null)
          {
            com.tencent.mm.plugin.voip.video.camera.a.c localc = this.LpV;
            s.checkNotNull(localc);
            localc.dre();
          }
          Log.e("MicroMsg.Voip.CaptureRender", s.X("startPreview:error", localException2));
        }
      }
    }
  }
  
  public final void ggH()
  {
    AppMethodBeat.i(284860);
    Log.d("MicroMsg.Voip.CaptureRender", s.X("StopCapture....mIsInCapture = ", Boolean.valueOf(this.LpW)));
    Object localObject;
    if ((this.LpW) && (this.Abo != null))
    {
      this.LpX = false;
      localObject = this.Abo;
      s.checkNotNull(localObject);
      if (!((com.tencent.mm.compatible.deviceinfo.w)localObject).lWt)
      {
        localObject = this.Abo;
        s.checkNotNull(localObject);
        ((com.tencent.mm.compatible.deviceinfo.w)localObject).a(null);
      }
    }
    try
    {
      localObject = this.Abo;
      s.checkNotNull(localObject);
      ((com.tencent.mm.compatible.deviceinfo.w)localObject).auq();
      this.nvB = false;
      this.LpW = false;
      if (1 == this.LpO)
      {
        localObject = new rw();
        ((rw)localObject).hUY.type = 2;
        ((rw)localObject).publish();
      }
      Log.d("MicroMsg.Voip.CaptureRender", s.X("UnInitCapture....mCameraOpen = ", Boolean.valueOf(this.LpS)));
      if (this.LpS)
      {
        this.LpO = 0;
        this.LpX = false;
        if (this.Abo != null)
        {
          localObject = this.Abo;
          s.checkNotNull(localObject);
          if (!((com.tencent.mm.compatible.deviceinfo.w)localObject).lWt)
          {
            localObject = this.Abo;
            s.checkNotNull(localObject);
            ((com.tencent.mm.compatible.deviceinfo.w)localObject).a(null);
            localObject = this.Abo;
            s.checkNotNull(localObject);
            ((com.tencent.mm.compatible.deviceinfo.w)localObject).release();
          }
        }
        this.Abo = null;
        this.LpS = false;
        this.LpY = null;
        if (this.LpZ != null)
        {
          localObject = this.LpZ;
          s.checkNotNull(localObject);
          ((List)localObject).clear();
        }
        this.LpZ = null;
        this.LpT = false;
        AppMethodBeat.o(284860);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Voip.CaptureRender", s.X("stopPreview:error", localException));
        continue;
        if (this.Abo != null)
        {
          com.tencent.mm.compatible.deviceinfo.w localw = this.Abo;
          s.checkNotNull(localw);
          if (!localw.lWt)
          {
            localw = this.Abo;
            s.checkNotNull(localw);
            localw.a(null);
          }
          localw = this.Abo;
          s.checkNotNull(localw);
          localw.release();
          this.Abo = null;
          this.LpS = false;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer$Companion;", "", "()V", "CALLBACK_BUFFER_COUNT", "", "COMMA_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "ENUM_VideoDevStartFailed", "ENUM_VideoDevStartNormal", "FOCUS_FACE_LOC_DIFF_THREASHOLD", "METER_FACE_LOC_DIFF_THRESHOLD", "TAG", "", "VFMT_420SP", "VFMT_D530", "VFMT_LOCAL", "VFMT_NV12", "VFMT_RGB24", "VFMT_RGB32", "VFMT_RGB565", "VFMT_ROTATE", "VFMT_UYVY", "VFMT_YUV420", "VFMT_YUY2", "VFMT_YV12", "findBestPreviewSizeValue", "Landroid/graphics/Point;", "previewSizeValueString", "", "screenResolution", "getCameraResolution", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "w", "h", "openCameraByHighApiLvl", "bFace", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static Point a(CharSequence paramCharSequence, Point paramPoint)
    {
      AppMethodBeat.i(284973);
      int j = 0;
      int k = 0;
      paramCharSequence = w.ggI().split(paramCharSequence);
      s.s(paramCharSequence, "COMMA_PATTERN.split(previewSizeValueString)");
      int i4 = paramCharSequence.length;
      int i = 0;
      int i1 = 2147483647;
      int n;
      int m;
      int i2;
      for (;;)
      {
        if (i < i4)
        {
          Object localObject1 = paramCharSequence[i];
          i += 1;
          s.s(localObject1, "previewSize");
          localObject1 = (CharSequence)localObject1;
          n = 0;
          m = ((CharSequence)localObject1).length() - 1;
          i2 = 0;
          while (n <= m)
          {
            int i3;
            if (i2 == 0)
            {
              i3 = n;
              label96:
              if (s.compare(((CharSequence)localObject1).charAt(i3), 32) > 0) {
                break label139;
              }
              i3 = 1;
            }
            for (;;)
            {
              if (i2 == 0)
              {
                if (i3 == 0)
                {
                  i2 = 1;
                  break;
                  i3 = m;
                  break label96;
                  label139:
                  i3 = 0;
                  continue;
                }
                n += 1;
                break;
              }
            }
            if (i3 == 0) {
              break;
            }
            m -= 1;
          }
          localObject1 = ((CharSequence)localObject1).subSequence(n, m + 1).toString();
          n = n.a((CharSequence)localObject1, 'x', 0, false, 6);
          if (n < 0)
          {
            Log.w("MicroMsg.Voip.CaptureRender", s.X("Bad preview-size: ", localObject1));
          }
          else if (localObject1 == null)
          {
            try
            {
              NullPointerException localNullPointerException = new NullPointerException("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(284973);
              throw localNullPointerException;
            }
            catch (NumberFormatException localNumberFormatException)
            {
              Log.w("MicroMsg.Voip.CaptureRender", s.X("Bad preview-size: ", localObject1));
            }
          }
          else
          {
            Object localObject2 = ((String)localObject1).substring(0, n);
            s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            m = Util.getInt((String)localObject2, 0);
            if (localObject1 == null)
            {
              localObject2 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(284973);
              throw ((Throwable)localObject2);
            }
            localObject2 = ((String)localObject1).substring(n + 1);
            s.s(localObject2, "(this as java.lang.String).substring(startIndex)");
            n = Util.getInt((String)localObject2, 0);
            i2 = Math.abs(m - paramPoint.x);
            i2 = Math.abs(n - paramPoint.y) + i2;
            if (i2 != 0) {
              break;
            }
          }
        }
      }
      for (;;)
      {
        if ((m > 0) && (n > 0))
        {
          paramCharSequence = new Point(m, n);
          AppMethodBeat.o(284973);
          return paramCharSequence;
          if ((i2 >= i1) || (m == n)) {
            break label434;
          }
          i1 = i2;
          k = n;
          j = m;
          break;
        }
        AppMethodBeat.o(284973);
        return null;
        label434:
        break;
        n = k;
        m = j;
      }
    }
    
    public static com.tencent.mm.compatible.deviceinfo.w zg(boolean paramBoolean)
    {
      localObject2 = null;
      AppMethodBeat.i(284964);
      if (com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP <= 0)
      {
        AppMethodBeat.o(284964);
        return null;
      }
      if (!com.tencent.mm.plugin.voip.video.camera.a.d.UOo)
      {
        AppMethodBeat.o(284964);
        return null;
      }
      if (paramBoolean == true) {}
      for (;;)
      {
        try
        {
          locala = com.tencent.mm.compatible.deviceinfo.d.G(MMApplicationContext.getContext(), com.tencent.mm.plugin.voip.video.camera.a.d.UOj);
          Log.i("Camera", "Use front");
          localObject1 = localObject2;
          if (locala != null) {
            localObject1 = locala.lTN;
          }
        }
        catch (Exception localException)
        {
          d.a.a locala;
          h.OAn.idkeyStat(159L, 0L, 1L, false);
          h.OAn.idkeyStat(159L, 1L, 1L, false);
          Log.e("MicroMsg.Voip.CaptureRender", s.X("openCameraByHighApiLvl:error:", localException));
          Object localObject1 = localObject2;
          continue;
        }
        AppMethodBeat.o(284964);
        return localObject1;
        locala = com.tencent.mm.compatible.deviceinfo.d.G(MMApplicationContext.getContext(), com.tencent.mm.plugin.voip.video.camera.a.d.UOk);
        Log.i("Camera", "Use back");
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/model/MultitalkCaptureRenderer$previewCallback$1", "Landroid/hardware/Camera$PreviewCallback;", "onPreviewFrame", "", "data", "", "arg1", "Landroid/hardware/Camera;", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Camera.PreviewCallback
  {
    b(w paramw) {}
    
    public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
    {
      AppMethodBeat.i(284742);
      s.u(paramArrayOfByte, "data");
      s.u(paramCamera, "arg1");
      if (paramArrayOfByte.length <= 0)
      {
        h.OAn.idkeyStat(159L, 0L, 1L, false);
        h.OAn.idkeyStat(159L, 3L, 1L, false);
        if (this.Lqh.LpV != null)
        {
          paramArrayOfByte = this.Lqh.LpV;
          s.checkNotNull(paramArrayOfByte);
          paramArrayOfByte.dre();
        }
        AppMethodBeat.o(284742);
        return;
      }
      if (this.Lqh.LpQ == null)
      {
        Log.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
        AppMethodBeat.o(284742);
        return;
      }
      int m;
      int j;
      int k;
      int i;
      if (this.Lqh.LpV != null)
      {
        if (w.a(this.Lqh) != null)
        {
          paramCamera = w.a(this.Lqh);
          s.checkNotNull(paramCamera);
          if (paramCamera.length == paramArrayOfByte.length) {}
        }
        else
        {
          w.a(this.Lqh, new byte[paramArrayOfByte.length]);
        }
        System.arraycopy(paramArrayOfByte, 0, w.a(this.Lqh), 0, paramArrayOfByte.length);
        m = 1;
        if (this.Lqh.LpL)
        {
          j = com.tencent.mm.plugin.voip.video.camera.a.d.UOl;
          k = j;
          if (!af.lXY.lSW) {
            break label752;
          }
          k = j;
          if (af.lXY.lSV.hYK == 0) {
            break label752;
          }
          i = af.lXY.lSV.lTJ;
          m = 1;
          k = j;
          j = m;
        }
      }
      for (;;)
      {
        label247:
        boolean bool;
        label265:
        byte[] arrayOfByte1;
        Object localObject;
        if (k > 0)
        {
          m = 32;
          paramCamera = this.Lqh;
          if ((j != 0) || (k <= 0)) {
            break label610;
          }
          bool = true;
          paramCamera.LpM = Boolean.valueOf(bool);
          paramCamera = this.Lqh.LpQ;
          s.checkNotNull(paramCamera);
          k = paramCamera.width;
          paramCamera = this.Lqh.LpQ;
          s.checkNotNull(paramCamera);
          int n = paramCamera.height;
          if ((j == 0) || (w.drd())) {
            break label616;
          }
          if (this.Lqh.LpY == null)
          {
            j = k * n * 3 / 2;
            this.Lqh.LpY = new byte[j];
            paramCamera = this.Lqh.LpY;
            s.checkNotNull(paramCamera);
            paramCamera[0] = 90;
          }
          paramCamera = SubCoreVoip.hVp();
          arrayOfByte1 = w.a(this.Lqh);
          localObject = w.a(this.Lqh);
          s.checkNotNull(localObject);
          j = localObject.length;
          int i1 = this.Lqh.LpR;
          localObject = this.Lqh.LpY;
          byte[] arrayOfByte2 = this.Lqh.LpY;
          s.checkNotNull(arrayOfByte2);
          paramCamera.a(arrayOfByte1, j, k, n, i1, (byte[])localObject, arrayOfByte2.length, k, n, i);
          paramCamera = this.Lqh.LpV;
          s.checkNotNull(paramCamera);
          arrayOfByte1 = this.Lqh.LpY;
          localObject = this.Lqh.LpY;
          s.checkNotNull(localObject);
          paramCamera.a(arrayOfByte1, localObject.length, k, n, this.Lqh.LpR, m);
        }
        for (;;)
        {
          if (m.getApiLevel() >= 8)
          {
            if (this.Lqh.Abo == null)
            {
              Log.e("MicroMsg.Voip.CaptureRender", "the camera is null and has been release");
              AppMethodBeat.o(284742);
              return;
              i = com.tencent.mm.plugin.voip.video.camera.a.d.UOm;
              k = i;
              if (!af.lXY.lSY) {
                break label752;
              }
              k = i;
              if (af.lXY.lSX.hYK == 0) {
                break label752;
              }
              m = af.lXY.lSX.lTJ;
              j = 1;
              k = i;
              i = m;
              break;
              m = 0;
              break label247;
              label610:
              bool = false;
              break label265;
              label616:
              paramCamera = this.Lqh.LpV;
              s.checkNotNull(paramCamera);
              arrayOfByte1 = w.a(this.Lqh);
              localObject = w.a(this.Lqh);
              s.checkNotNull(localObject);
              long l = localObject.length;
              localObject = this.Lqh.LpQ;
              s.checkNotNull(localObject);
              i = ((ad)localObject).width;
              localObject = this.Lqh.LpQ;
              s.checkNotNull(localObject);
              paramCamera.a(arrayOfByte1, l, i, ((ad)localObject).height, this.Lqh.LpR, m);
              continue;
            }
            if (this.Lqh.Abo != null)
            {
              paramCamera = this.Lqh.Abo;
              s.checkNotNull(paramCamera);
              paramCamera.aj(paramArrayOfByte);
            }
          }
        }
        AppMethodBeat.o(284742);
        return;
        label752:
        j = 0;
        i = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.w
 * JD-Core Version:    0.7.0.1
 */