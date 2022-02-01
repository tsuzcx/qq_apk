package com.tencent.mm.plugin.voip.video.camera.prev;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rw;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.a.a;
import com.tencent.mm.plugin.voip.video.camera.a.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class c
  extends a
  implements b.a
{
  private static final Pattern Lqg;
  private static int nLg;
  private static int nLh;
  protected volatile w Abo;
  protected long LpN;
  protected Camera.Parameters LpP;
  protected int LpR;
  protected boolean LpS;
  protected boolean LpT;
  protected boolean LpU;
  protected com.tencent.mm.plugin.voip.video.camera.a.c LpV;
  public boolean LpW;
  protected boolean LpX;
  protected byte[] LpY;
  protected List<byte[]> LpZ;
  private int Lqa;
  protected int Lqb;
  protected int Lqc;
  protected boolean Lqd;
  private byte[] Lqe;
  com.tencent.mm.plugin.voip.video.camera.a.b Lwy;
  protected int UOA;
  protected int[] UOE;
  protected int UOF;
  private int UOP;
  protected Size UOQ;
  protected boolean UOu;
  protected boolean UOv;
  protected boolean UOw;
  protected boolean UOx;
  protected boolean UOy;
  protected long UOz;
  protected int mHeight;
  SurfaceTexture mSurfaceTexture;
  protected int mWidth;
  protected boolean nGD;
  private int nHi;
  protected boolean nvB;
  
  static
  {
    AppMethodBeat.i(292980);
    Lqg = Pattern.compile(",");
    nLg = 20;
    nLh = 70;
    AppMethodBeat.o(292980);
  }
  
  public c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292915);
    this.UOP = 0;
    this.UOu = true;
    this.UOv = false;
    this.Lqa = 0;
    this.UOw = false;
    this.UOx = false;
    this.UOy = false;
    this.UOz = 0L;
    this.LpN = 30000L;
    this.UOA = 0;
    this.LpS = false;
    this.LpT = false;
    this.LpU = false;
    this.LpW = false;
    this.LpX = false;
    this.LpY = null;
    this.UOE = null;
    this.mWidth = 320;
    this.mHeight = 240;
    this.nGD = true;
    this.Lqb = 0;
    this.Lqc = 0;
    this.UOF = 0;
    this.nvB = false;
    this.Lqd = false;
    this.Lqe = null;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    com.tencent.mm.plugin.voip.video.camera.a.d.kC(MMApplicationContext.getContext().getApplicationContext());
    Log.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
    AppMethodBeat.o(292915);
  }
  
  private static Point a(CharSequence paramCharSequence, Point paramPoint)
  {
    AppMethodBeat.i(292946);
    int i1 = 2147483647;
    paramCharSequence = Lqg.split(paramCharSequence);
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
        break label274;
      }
      str = paramCharSequence[m].trim();
      k = str.indexOf('x');
      if (k >= 0) {
        break;
      }
      Log.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: ".concat(String.valueOf(str)));
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
        n = Util.getInt(str.substring(0, k), 0);
        k = Util.getInt(str.substring(k + 1), 0);
        i5 = Math.abs(n - paramPoint.x) + Math.abs(k - paramPoint.y);
        if (i5 != 0) {
          break label218;
        }
        if ((n <= 0) || (k <= 0)) {
          break label267;
        }
        paramCharSequence = new Point(n, k);
        AppMethodBeat.o(292946);
        return paramCharSequence;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: ".concat(String.valueOf(str)));
        i2 = i1;
        i3 = j;
        i4 = i;
      }
      break;
      label218:
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
      label267:
      AppMethodBeat.o(292946);
      return null;
      label274:
      k = j;
      int n = i;
    }
  }
  
  private boolean a(w paramw, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292930);
    if (paramw == null)
    {
      AppMethodBeat.o(292930);
      return false;
    }
    try
    {
      Camera.Parameters localParameters = paramw.aPy();
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        localParameters.setPreviewSize(paramInt1, paramInt2);
      }
      paramw.c(localParameters);
      this.LpV.gG(paramInt2, paramInt1);
      AppMethodBeat.o(292930);
      return true;
    }
    catch (Exception paramw)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(159L, 0L, 1L, false);
      Log.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + paramw.toString());
      AppMethodBeat.o(292930);
    }
    return false;
  }
  
  private boolean b(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(292939);
    if (paramw == null)
    {
      AppMethodBeat.o(292939);
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
        break label224;
      }
      Log.i("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        Log.i("MicroMsg.Voip.CaptureRender", "supported focus modes : ".concat(String.valueOf((String)localIterator.next())));
      }
      if (af.lXY.lTy != 0) {
        break label268;
      }
    }
    catch (Exception paramw)
    {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(159L, 0L, 1L, false);
      Log.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + paramw.toString());
      AppMethodBeat.o(292939);
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
      label224:
      AppMethodBeat.o(292939);
      return true;
      if (localList.contains("continuous-video"))
      {
        Log.i("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
        localParameters.setFocusMode("continuous-video");
        this.LpT = true;
        continue;
        label268:
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
  
  private int f(w paramw)
  {
    AppMethodBeat.i(292967);
    if (paramw == null)
    {
      AppMethodBeat.o(292967);
      return 0;
    }
    for (;;)
    {
      try
      {
        localObject = paramw.aPy().getSupportedPreviewSizes();
        if ((localObject == null) || (((List)localObject).size() == 0)) {
          continue;
        }
        localObject = ((List)localObject).iterator();
        i = 0;
      }
      catch (Exception paramw)
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
          Log.d("MicroMsg.Voip.CaptureRender", "support Size:" + localSize.width + "," + localSize.height);
          if (i == 0)
          {
            this.Lqb = localSize.width;
            this.Lqc = localSize.height;
          }
          i += 1;
          continue;
        }
        try
        {
          paramw = paramw.aPy().getSupportedPreviewFormats();
          if ((paramw == null) || (paramw.size() == 0)) {
            continue;
          }
          paramw = paramw.iterator();
          if (!paramw.hasNext()) {
            continue;
          }
          Log.i("MicroMsg.Voip.CaptureRender", "support Format:".concat(String.valueOf(((Integer)paramw.next()).intValue())));
          continue;
          Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", paramw, "", new Object[0]);
        }
        catch (Exception paramw) {}
      }
      catch (Exception paramw)
      {
        continue;
      }
      AppMethodBeat.o(292967);
      return i;
    }
  }
  
  private static void g(w paramw)
  {
    AppMethodBeat.i(292975);
    try
    {
      localList = paramw.aPy().getSupportedPreviewFrameRates();
      paramw = "supportFps:";
      localw = paramw;
      if (localList != null)
      {
        int i = 0;
        for (;;)
        {
          localw = paramw;
          if (i >= localList.size()) {
            break;
          }
          int j = ((Integer)localList.get(i)).intValue();
          paramw = paramw + j + ",";
          i += 1;
        }
      }
    }
    catch (Exception paramw)
    {
      w localw;
      for (;;)
      {
        Log.d("MicroMsg.Voip.CaptureRender", "getSupportedPreviewFrameRates:error:" + paramw.toString());
        List localList = null;
      }
      Log.i("MicroMsg.Voip.CaptureRender", localw);
      AppMethodBeat.o(292975);
    }
  }
  
  /* Error */
  private int o(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 422
    //   3: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 165
    //   8: ldc_w 424
    //   11: iload_1
    //   12: invokestatic 427	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   15: invokevirtual 210	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 118	com/tencent/mm/plugin/voip/video/camera/prev/c:LpT	Z
    //   26: iconst_1
    //   27: istore 17
    //   29: iload 17
    //   31: istore 16
    //   33: aload_0
    //   34: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   37: ifnull +52 -> 89
    //   40: aload_0
    //   41: getfield 96	com/tencent/mm/plugin/voip/video/camera/prev/c:UOu	Z
    //   44: iload_1
    //   45: if_icmpeq +95 -> 140
    //   48: aload_0
    //   49: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   52: getfield 432	com/tencent/mm/compatible/deviceinfo/w:lWt	Z
    //   55: ifne +11 -> 66
    //   58: aload_0
    //   59: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   62: aconst_null
    //   63: invokevirtual 435	com/tencent/mm/compatible/deviceinfo/w:a	(Landroid/hardware/Camera$PreviewCallback;)V
    //   66: aload_0
    //   67: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   70: invokevirtual 438	com/tencent/mm/compatible/deviceinfo/w:auq	()V
    //   73: aload_0
    //   74: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   77: invokevirtual 441	com/tencent/mm/compatible/deviceinfo/w:release	()V
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   85: iload 17
    //   87: istore 16
    //   89: iload 16
    //   91: ifeq +63 -> 154
    //   94: aload_0
    //   95: aload_0
    //   96: iload_1
    //   97: invokespecial 445	com/tencent/mm/plugin/voip/video/camera/prev/c:zf	(Z)Lcom/tencent/mm/compatible/deviceinfo/w;
    //   100: putfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   103: aload_0
    //   104: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   107: ifnonnull +42 -> 149
    //   110: aload_0
    //   111: iconst_0
    //   112: putfield 116	com/tencent/mm/plugin/voip/video/camera/prev/c:LpS	Z
    //   115: ldc_w 422
    //   118: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iconst_m1
    //   122: ireturn
    //   123: astore 18
    //   125: ldc 165
    //   127: ldc_w 447
    //   130: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: iload 17
    //   135: istore 16
    //   137: goto -48 -> 89
    //   140: aload_0
    //   141: getfield 144	com/tencent/mm/plugin/voip/video/camera/prev/c:Lqd	Z
    //   144: istore 16
    //   146: goto -57 -> 89
    //   149: aload_0
    //   150: iconst_0
    //   151: putfield 144	com/tencent/mm/plugin/voip/video/camera/prev/c:Lqd	Z
    //   154: aload_0
    //   155: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   158: ifnull +11 -> 169
    //   161: aload_0
    //   162: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   165: invokevirtual 252	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   168: pop
    //   169: aload_0
    //   170: iconst_1
    //   171: putfield 116	com/tencent/mm/plugin/voip/video/camera/prev/c:LpS	Z
    //   174: aload_0
    //   175: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   178: astore 18
    //   180: getstatic 451	com/tencent/mm/plugin/voip/video/camera/a/d:UOi	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   183: getfield 456	com/tencent/mm/plugin/voip/video/camera/prev/b:UOI	I
    //   186: istore 11
    //   188: aload 18
    //   190: ifnull +255 -> 445
    //   193: bipush 26
    //   195: istore 4
    //   197: ldc 165
    //   199: ldc_w 458
    //   202: iconst_1
    //   203: anewarray 169	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: iload 11
    //   210: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: aastore
    //   214: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: aload 18
    //   219: invokevirtual 252	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   222: astore 19
    //   224: invokestatic 461	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   227: ifeq +27 -> 254
    //   230: ldc_w 463
    //   233: invokestatic 469	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   236: checkcast 463	com/tencent/mm/plugin/zero/b/a
    //   239: invokeinterface 473 1 0
    //   244: ldc_w 475
    //   247: bipush 26
    //   249: invokevirtual 478	com/tencent/mm/k/f:getInt	(Ljava/lang/String;I)I
    //   252: istore 4
    //   254: ldc 165
    //   256: ldc_w 480
    //   259: iconst_1
    //   260: anewarray 169	java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: iload 4
    //   267: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aastore
    //   271: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: invokestatic 485	com/tencent/mm/compatible/util/l:isSamsung	()Z
    //   277: ifne +11 -> 288
    //   280: iload 4
    //   282: invokestatic 491	com/tencent/mm/compatible/util/d:rb	(I)Z
    //   285: ifeq +1116 -> 1401
    //   288: ldc 187
    //   290: istore 6
    //   292: iconst_0
    //   293: istore_1
    //   294: iconst_m1
    //   295: istore 8
    //   297: iconst_0
    //   298: istore 7
    //   300: getstatic 351	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   303: ifnull +1607 -> 1910
    //   306: getstatic 351	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   309: getfield 494	com/tencent/mm/compatible/deviceinfo/c:lTD	I
    //   312: sipush 1000
    //   315: imul
    //   316: istore 8
    //   318: getstatic 351	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   321: getfield 497	com/tencent/mm/compatible/deviceinfo/c:lTE	I
    //   324: sipush 1000
    //   327: imul
    //   328: istore 7
    //   330: goto +1580 -> 1910
    //   333: ldc 165
    //   335: ldc_w 499
    //   338: iconst_4
    //   339: anewarray 169	java/lang/Object
    //   342: dup
    //   343: iconst_0
    //   344: iload 8
    //   346: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: aastore
    //   350: dup
    //   351: iconst_1
    //   352: iload 7
    //   354: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: aastore
    //   358: dup
    //   359: iconst_2
    //   360: iload 11
    //   362: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   365: aastore
    //   366: dup
    //   367: iconst_3
    //   368: iload 16
    //   370: invokestatic 308	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   373: aastore
    //   374: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: iload 8
    //   379: ldc 187
    //   381: if_icmpeq +15 -> 396
    //   384: iload 7
    //   386: ldc 187
    //   388: if_icmpeq +8 -> 396
    //   391: iload 16
    //   393: ifne +950 -> 1343
    //   396: iconst_1
    //   397: istore 4
    //   399: iload 4
    //   401: ifeq +44 -> 445
    //   404: ldc 165
    //   406: ldc_w 501
    //   409: iconst_1
    //   410: anewarray 169	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: iload 11
    //   417: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   420: aastore
    //   421: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   424: aload 18
    //   426: invokevirtual 252	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   429: astore 19
    //   431: aload 19
    //   433: iload 11
    //   435: invokevirtual 504	android/hardware/Camera$Parameters:setPreviewFrameRate	(I)V
    //   438: aload 18
    //   440: aload 19
    //   442: invokevirtual 261	com/tencent/mm/compatible/deviceinfo/w:c	(Landroid/hardware/Camera$Parameters;)V
    //   445: ldc 165
    //   447: new 282	java/lang/StringBuilder
    //   450: dup
    //   451: ldc_w 506
    //   454: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   457: iload_2
    //   458: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   461: ldc 71
    //   463: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: iload_3
    //   467: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   476: aload_0
    //   477: getfield 96	com/tencent/mm/plugin/voip/video/camera/prev/c:UOu	Z
    //   480: ifeq +992 -> 1472
    //   483: getstatic 451	com/tencent/mm/plugin/voip/video/camera/a/d:UOi	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   486: getfield 510	com/tencent/mm/plugin/voip/video/camera/prev/b:UON	Landroid/graphics/Point;
    //   489: astore 18
    //   491: aload 18
    //   493: ifnull +990 -> 1483
    //   496: iconst_1
    //   497: istore 4
    //   499: aconst_null
    //   500: astore 21
    //   502: aload 18
    //   504: ifnull +1385 -> 1889
    //   507: new 512	android/util/Size
    //   510: dup
    //   511: aload 18
    //   513: getfield 232	android/graphics/Point:x	I
    //   516: aload 18
    //   518: getfield 240	android/graphics/Point:y	I
    //   521: invokespecial 513	android/util/Size:<init>	(II)V
    //   524: astore 19
    //   526: ldc 165
    //   528: new 282	java/lang/StringBuilder
    //   531: dup
    //   532: ldc_w 515
    //   535: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   538: aload 19
    //   540: invokevirtual 518	android/util/Size:getWidth	()I
    //   543: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: ldc 71
    //   548: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload 19
    //   553: invokevirtual 521	android/util/Size:getHeight	()I
    //   556: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   559: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: aload_0
    //   566: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   569: invokevirtual 252	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   572: astore 18
    //   574: new 229	android/graphics/Point
    //   577: dup
    //   578: iload_2
    //   579: iload_3
    //   580: invokespecial 242	android/graphics/Point:<init>	(II)V
    //   583: astore 22
    //   585: aload 18
    //   587: ldc_w 523
    //   590: invokevirtual 525	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   593: astore 20
    //   595: aload 20
    //   597: ifnonnull +1289 -> 1886
    //   600: aload 18
    //   602: ldc_w 527
    //   605: invokevirtual 525	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   608: astore 20
    //   610: aconst_null
    //   611: astore 18
    //   613: aload 20
    //   615: ifnull +28 -> 643
    //   618: ldc 165
    //   620: ldc_w 529
    //   623: aload 20
    //   625: invokestatic 206	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   628: invokevirtual 210	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   631: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: aload 20
    //   636: aload 22
    //   638: invokestatic 531	com/tencent/mm/plugin/voip/video/camera/prev/c:a	(Ljava/lang/CharSequence;Landroid/graphics/Point;)Landroid/graphics/Point;
    //   641: astore 18
    //   643: aload 18
    //   645: astore 20
    //   647: aload 18
    //   649: ifnonnull +30 -> 679
    //   652: new 229	android/graphics/Point
    //   655: dup
    //   656: aload 22
    //   658: getfield 232	android/graphics/Point:x	I
    //   661: iconst_3
    //   662: ishr
    //   663: iconst_3
    //   664: ishl
    //   665: aload 22
    //   667: getfield 240	android/graphics/Point:y	I
    //   670: iconst_3
    //   671: ishr
    //   672: iconst_3
    //   673: ishl
    //   674: invokespecial 242	android/graphics/Point:<init>	(II)V
    //   677: astore 20
    //   679: new 512	android/util/Size
    //   682: dup
    //   683: aload 20
    //   685: getfield 232	android/graphics/Point:x	I
    //   688: aload 20
    //   690: getfield 240	android/graphics/Point:y	I
    //   693: invokespecial 513	android/util/Size:<init>	(II)V
    //   696: astore 18
    //   698: ldc 165
    //   700: new 282	java/lang/StringBuilder
    //   703: dup
    //   704: ldc_w 533
    //   707: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   710: aload 18
    //   712: invokevirtual 518	android/util/Size:getWidth	()I
    //   715: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   718: ldc 71
    //   720: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: aload 18
    //   725: invokevirtual 521	android/util/Size:getHeight	()I
    //   728: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   731: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   737: iload 4
    //   739: ifeq +779 -> 1518
    //   742: aload_0
    //   743: aload_0
    //   744: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   747: aload 19
    //   749: invokevirtual 518	android/util/Size:getWidth	()I
    //   752: aload 19
    //   754: invokevirtual 521	android/util/Size:getHeight	()I
    //   757: invokespecial 535	com/tencent/mm/plugin/voip/video/camera/prev/c:a	(Lcom/tencent/mm/compatible/deviceinfo/w;II)Z
    //   760: istore_1
    //   761: ldc 165
    //   763: new 282	java/lang/StringBuilder
    //   766: dup
    //   767: ldc_w 537
    //   770: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   773: aload 19
    //   775: invokevirtual 518	android/util/Size:getWidth	()I
    //   778: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   781: ldc_w 539
    //   784: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: aload 19
    //   789: invokevirtual 521	android/util/Size:getHeight	()I
    //   792: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   795: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: iload_1
    //   802: ifne +838 -> 1640
    //   805: aload 18
    //   807: ifnull +833 -> 1640
    //   810: ldc 165
    //   812: new 282	java/lang/StringBuilder
    //   815: dup
    //   816: ldc_w 541
    //   819: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   822: aload 18
    //   824: invokevirtual 518	android/util/Size:getWidth	()I
    //   827: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: ldc_w 539
    //   833: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload 18
    //   838: invokevirtual 521	android/util/Size:getHeight	()I
    //   841: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   844: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   850: aload_0
    //   851: aload_0
    //   852: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   855: aload 18
    //   857: invokevirtual 518	android/util/Size:getWidth	()I
    //   860: aload 18
    //   862: invokevirtual 521	android/util/Size:getHeight	()I
    //   865: invokespecial 535	com/tencent/mm/plugin/voip/video/camera/prev/c:a	(Lcom/tencent/mm/compatible/deviceinfo/w;II)Z
    //   868: ifne +772 -> 1640
    //   871: ldc 165
    //   873: new 282	java/lang/StringBuilder
    //   876: dup
    //   877: ldc_w 543
    //   880: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   883: aload 18
    //   885: invokevirtual 518	android/util/Size:getWidth	()I
    //   888: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   891: ldc_w 539
    //   894: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: aload 18
    //   899: invokevirtual 521	android/util/Size:getHeight	()I
    //   902: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   905: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   908: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   911: ldc_w 422
    //   914: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   917: iconst_m1
    //   918: ireturn
    //   919: astore 18
    //   921: getstatic 274	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   924: ldc2_w 275
    //   927: lconst_0
    //   928: lconst_1
    //   929: iconst_0
    //   930: invokevirtual 280	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   933: ldc 165
    //   935: ldc_w 545
    //   938: iconst_1
    //   939: anewarray 169	java/lang/Object
    //   942: dup
    //   943: iconst_0
    //   944: aload 18
    //   946: invokevirtual 548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   949: aastore
    //   950: invokestatic 550	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   953: aload_0
    //   954: getfield 263	com/tencent/mm/plugin/voip/video/camera/prev/c:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   957: ifnull +54 -> 1011
    //   960: aload_0
    //   961: getfield 263	com/tencent/mm/plugin/voip/video/camera/prev/c:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   964: invokeinterface 553 1 0
    //   969: aload_0
    //   970: iconst_1
    //   971: putfield 144	com/tencent/mm/plugin/voip/video/camera/prev/c:Lqd	Z
    //   974: aload_0
    //   975: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   978: getfield 432	com/tencent/mm/compatible/deviceinfo/w:lWt	Z
    //   981: ifne +11 -> 992
    //   984: aload_0
    //   985: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   988: aconst_null
    //   989: invokevirtual 435	com/tencent/mm/compatible/deviceinfo/w:a	(Landroid/hardware/Camera$PreviewCallback;)V
    //   992: aload_0
    //   993: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   996: invokevirtual 438	com/tencent/mm/compatible/deviceinfo/w:auq	()V
    //   999: aload_0
    //   1000: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1003: invokevirtual 441	com/tencent/mm/compatible/deviceinfo/w:release	()V
    //   1006: aload_0
    //   1007: aconst_null
    //   1008: putfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1011: ldc_w 422
    //   1014: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1017: iconst_m1
    //   1018: ireturn
    //   1019: astore 19
    //   1021: ldc 165
    //   1023: aload 19
    //   1025: ldc_w 555
    //   1028: iconst_1
    //   1029: anewarray 169	java/lang/Object
    //   1032: dup
    //   1033: iconst_0
    //   1034: aload 18
    //   1036: invokevirtual 548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1039: aastore
    //   1040: invokestatic 405	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1043: goto -32 -> 1011
    //   1046: iload 8
    //   1048: ifne +24 -> 1072
    //   1051: iload 7
    //   1053: ifne +19 -> 1072
    //   1056: iconst_0
    //   1057: istore 16
    //   1059: ldc_w 556
    //   1062: istore 7
    //   1064: ldc_w 556
    //   1067: istore 8
    //   1069: goto -736 -> 333
    //   1072: aload 19
    //   1074: invokevirtual 559	android/hardware/Camera$Parameters:getSupportedPreviewFpsRange	()Ljava/util/List;
    //   1077: astore 20
    //   1079: aload 20
    //   1081: ifnull +852 -> 1933
    //   1084: aload 20
    //   1086: invokeinterface 322 1 0
    //   1091: ifne +6 -> 1097
    //   1094: goto +839 -> 1933
    //   1097: aload 20
    //   1099: invokeinterface 322 1 0
    //   1104: istore 12
    //   1106: iconst_0
    //   1107: istore 9
    //   1109: ldc_w 556
    //   1112: istore 5
    //   1114: ldc_w 556
    //   1117: istore 4
    //   1119: iload_1
    //   1120: istore 16
    //   1122: iload 5
    //   1124: istore 7
    //   1126: iload 4
    //   1128: istore 8
    //   1130: iload 9
    //   1132: iload 12
    //   1134: if_icmpge -801 -> 333
    //   1137: aload 20
    //   1139: iload 9
    //   1141: invokeinterface 417 2 0
    //   1146: checkcast 560	[I
    //   1149: astore 21
    //   1151: aload 21
    //   1153: ifnull +742 -> 1895
    //   1156: aload 21
    //   1158: arraylength
    //   1159: iconst_1
    //   1160: if_icmple +735 -> 1895
    //   1163: aload 21
    //   1165: iconst_0
    //   1166: iaload
    //   1167: istore 8
    //   1169: aload 21
    //   1171: iconst_1
    //   1172: iaload
    //   1173: istore 10
    //   1175: ldc 165
    //   1177: ldc_w 562
    //   1180: iconst_3
    //   1181: anewarray 169	java/lang/Object
    //   1184: dup
    //   1185: iconst_0
    //   1186: iload 9
    //   1188: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1191: aastore
    //   1192: dup
    //   1193: iconst_1
    //   1194: iload 8
    //   1196: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1199: aastore
    //   1200: dup
    //   1201: iconst_2
    //   1202: iload 10
    //   1204: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1207: aastore
    //   1208: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1211: iload 8
    //   1213: iflt +682 -> 1895
    //   1216: iload 10
    //   1218: iload 8
    //   1220: if_icmplt +675 -> 1895
    //   1223: iload 10
    //   1225: sipush 1000
    //   1228: idiv
    //   1229: istore 13
    //   1231: iload 8
    //   1233: sipush 1000
    //   1236: idiv
    //   1237: istore 14
    //   1239: iload 11
    //   1241: iconst_5
    //   1242: iadd
    //   1243: bipush 30
    //   1245: invokestatic 566	java/lang/Math:min	(II)I
    //   1248: istore 7
    //   1250: iload 11
    //   1252: iconst_5
    //   1253: isub
    //   1254: iconst_5
    //   1255: invokestatic 569	java/lang/Math:max	(II)I
    //   1258: istore 15
    //   1260: iload 13
    //   1262: iload 15
    //   1264: if_icmplt +696 -> 1960
    //   1267: iload 13
    //   1269: iload 7
    //   1271: if_icmpgt +689 -> 1960
    //   1274: iload 14
    //   1276: iload 15
    //   1278: if_icmplt +682 -> 1960
    //   1281: iload 14
    //   1283: iload 7
    //   1285: if_icmpgt +675 -> 1960
    //   1288: iconst_1
    //   1289: istore 7
    //   1291: iload 7
    //   1293: ifeq +602 -> 1895
    //   1296: iload 11
    //   1298: iload 14
    //   1300: isub
    //   1301: invokestatic 237	java/lang/Math:abs	(I)I
    //   1304: istore 7
    //   1306: iload 13
    //   1308: iload 11
    //   1310: isub
    //   1311: invokestatic 237	java/lang/Math:abs	(I)I
    //   1314: iload 7
    //   1316: iadd
    //   1317: istore 7
    //   1319: iload 7
    //   1321: iload 6
    //   1323: if_icmpge +572 -> 1895
    //   1326: iconst_1
    //   1327: istore_1
    //   1328: iload 7
    //   1330: istore 4
    //   1332: iload 10
    //   1334: istore 5
    //   1336: iload 8
    //   1338: istore 6
    //   1340: goto +599 -> 1939
    //   1343: ldc 165
    //   1345: ldc_w 571
    //   1348: iconst_3
    //   1349: anewarray 169	java/lang/Object
    //   1352: dup
    //   1353: iconst_0
    //   1354: iload 8
    //   1356: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1359: aastore
    //   1360: dup
    //   1361: iconst_1
    //   1362: iload 7
    //   1364: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1367: aastore
    //   1368: dup
    //   1369: iconst_2
    //   1370: iload 11
    //   1372: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1375: aastore
    //   1376: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1379: aload 19
    //   1381: iload 8
    //   1383: iload 7
    //   1385: invokevirtual 574	android/hardware/Camera$Parameters:setPreviewFpsRange	(II)V
    //   1388: aload 18
    //   1390: aload 19
    //   1392: invokevirtual 261	com/tencent/mm/compatible/deviceinfo/w:c	(Landroid/hardware/Camera$Parameters;)V
    //   1395: iconst_0
    //   1396: istore 4
    //   1398: goto -999 -> 399
    //   1401: iconst_1
    //   1402: istore 4
    //   1404: goto -1005 -> 399
    //   1407: astore 19
    //   1409: ldc 165
    //   1411: new 282	java/lang/StringBuilder
    //   1414: dup
    //   1415: ldc_w 576
    //   1418: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1421: aload 19
    //   1423: invokevirtual 290	java/lang/Exception:toString	()Ljava/lang/String;
    //   1426: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1432: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1435: iconst_1
    //   1436: istore 4
    //   1438: goto -1039 -> 399
    //   1441: astore 18
    //   1443: ldc 165
    //   1445: new 282	java/lang/StringBuilder
    //   1448: dup
    //   1449: ldc_w 578
    //   1452: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1455: aload 18
    //   1457: invokevirtual 290	java/lang/Exception:toString	()Ljava/lang/String;
    //   1460: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1466: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1469: goto -1024 -> 445
    //   1472: getstatic 451	com/tencent/mm/plugin/voip/video/camera/a/d:UOi	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   1475: getfield 581	com/tencent/mm/plugin/voip/video/camera/prev/b:UOO	Landroid/graphics/Point;
    //   1478: astore 18
    //   1480: goto -989 -> 491
    //   1483: iconst_0
    //   1484: istore 4
    //   1486: goto -987 -> 499
    //   1489: astore 20
    //   1491: aload 21
    //   1493: astore 18
    //   1495: ldc 165
    //   1497: ldc_w 583
    //   1500: iconst_1
    //   1501: anewarray 169	java/lang/Object
    //   1504: dup
    //   1505: iconst_0
    //   1506: aload 20
    //   1508: invokevirtual 548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1511: aastore
    //   1512: invokestatic 550	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1515: goto -778 -> 737
    //   1518: ldc 165
    //   1520: ldc_w 585
    //   1523: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1526: aload 18
    //   1528: ifnull +112 -> 1640
    //   1531: ldc 165
    //   1533: new 282	java/lang/StringBuilder
    //   1536: dup
    //   1537: ldc_w 587
    //   1540: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1543: aload 18
    //   1545: invokevirtual 518	android/util/Size:getWidth	()I
    //   1548: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1551: ldc_w 539
    //   1554: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1557: aload 18
    //   1559: invokevirtual 521	android/util/Size:getHeight	()I
    //   1562: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1565: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1568: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1571: aload_0
    //   1572: aload_0
    //   1573: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1576: aload 18
    //   1578: invokevirtual 518	android/util/Size:getWidth	()I
    //   1581: aload 18
    //   1583: invokevirtual 521	android/util/Size:getHeight	()I
    //   1586: invokespecial 535	com/tencent/mm/plugin/voip/video/camera/prev/c:a	(Lcom/tencent/mm/compatible/deviceinfo/w;II)Z
    //   1589: ifne +51 -> 1640
    //   1592: ldc 165
    //   1594: new 282	java/lang/StringBuilder
    //   1597: dup
    //   1598: ldc_w 589
    //   1601: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1604: aload 18
    //   1606: invokevirtual 518	android/util/Size:getWidth	()I
    //   1609: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1612: ldc_w 539
    //   1615: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1618: aload 18
    //   1620: invokevirtual 521	android/util/Size:getHeight	()I
    //   1623: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1626: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1629: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1632: ldc_w 422
    //   1635: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1638: iconst_m1
    //   1639: ireturn
    //   1640: aload_0
    //   1641: aload_0
    //   1642: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1645: aload_0
    //   1646: getfield 96	com/tencent/mm/plugin/voip/video/camera/prev/c:UOu	Z
    //   1649: invokespecial 591	com/tencent/mm/plugin/voip/video/camera/prev/c:b	(Lcom/tencent/mm/compatible/deviceinfo/w;Z)Z
    //   1652: pop
    //   1653: aload_0
    //   1654: aload_0
    //   1655: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/c:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1658: invokevirtual 252	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   1661: putfield 593	com/tencent/mm/plugin/voip/video/camera/prev/c:LpP	Landroid/hardware/Camera$Parameters;
    //   1664: aload_0
    //   1665: getfield 593	com/tencent/mm/plugin/voip/video/camera/prev/c:LpP	Landroid/hardware/Camera$Parameters;
    //   1668: invokevirtual 597	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   1671: astore 18
    //   1673: aload 18
    //   1675: ifnull +24 -> 1699
    //   1678: aload_0
    //   1679: new 512	android/util/Size
    //   1682: dup
    //   1683: aload 18
    //   1685: getfield 384	android/hardware/Camera$Size:width	I
    //   1688: aload 18
    //   1690: getfield 387	android/hardware/Camera$Size:height	I
    //   1693: invokespecial 513	android/util/Size:<init>	(II)V
    //   1696: putfield 599	com/tencent/mm/plugin/voip/video/camera/prev/c:UOQ	Landroid/util/Size;
    //   1699: iconst_0
    //   1700: istore_2
    //   1701: aload_0
    //   1702: getfield 593	com/tencent/mm/plugin/voip/video/camera/prev/c:LpP	Landroid/hardware/Camera$Parameters;
    //   1705: invokevirtual 602	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   1708: istore_3
    //   1709: iload_3
    //   1710: istore_2
    //   1711: aload_0
    //   1712: getstatic 605	com/tencent/mm/plugin/voip/video/camera/a/d:UOn	I
    //   1715: putfield 607	com/tencent/mm/plugin/voip/video/camera/prev/c:LpR	I
    //   1718: aload_0
    //   1719: getfield 607	com/tencent/mm/plugin/voip/video/camera/prev/c:LpR	I
    //   1722: ifgt +9 -> 1731
    //   1725: aload_0
    //   1726: bipush 7
    //   1728: putfield 607	com/tencent/mm/plugin/voip/video/camera/prev/c:LpR	I
    //   1731: ldc 165
    //   1733: ldc_w 609
    //   1736: bipush 6
    //   1738: anewarray 169	java/lang/Object
    //   1741: dup
    //   1742: iconst_0
    //   1743: iload_2
    //   1744: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1747: aastore
    //   1748: dup
    //   1749: iconst_1
    //   1750: aload_0
    //   1751: getfield 599	com/tencent/mm/plugin/voip/video/camera/prev/c:UOQ	Landroid/util/Size;
    //   1754: invokevirtual 518	android/util/Size:getWidth	()I
    //   1757: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1760: aastore
    //   1761: dup
    //   1762: iconst_2
    //   1763: aload_0
    //   1764: getfield 599	com/tencent/mm/plugin/voip/video/camera/prev/c:UOQ	Landroid/util/Size;
    //   1767: invokevirtual 521	android/util/Size:getHeight	()I
    //   1770: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1773: aastore
    //   1774: dup
    //   1775: iconst_3
    //   1776: aload_0
    //   1777: getfield 607	com/tencent/mm/plugin/voip/video/camera/prev/c:LpR	I
    //   1780: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1783: aastore
    //   1784: dup
    //   1785: iconst_4
    //   1786: getstatic 612	com/tencent/mm/plugin/voip/video/camera/a/d:UOl	I
    //   1789: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1792: aastore
    //   1793: dup
    //   1794: iconst_5
    //   1795: aload_0
    //   1796: getfield 100	com/tencent/mm/plugin/voip/video/camera/prev/c:Lqa	I
    //   1799: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1802: aastore
    //   1803: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1806: ldc_w 422
    //   1809: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1812: iconst_1
    //   1813: ireturn
    //   1814: astore 18
    //   1816: getstatic 274	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1819: ldc2_w 275
    //   1822: lconst_0
    //   1823: lconst_1
    //   1824: iconst_0
    //   1825: invokevirtual 280	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1828: ldc 165
    //   1830: ldc_w 614
    //   1833: iconst_1
    //   1834: anewarray 169	java/lang/Object
    //   1837: dup
    //   1838: iconst_0
    //   1839: aload 18
    //   1841: invokevirtual 548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1844: aastore
    //   1845: invokestatic 550	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1848: ldc_w 422
    //   1851: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1854: iconst_m1
    //   1855: ireturn
    //   1856: astore 18
    //   1858: ldc 165
    //   1860: ldc_w 616
    //   1863: iconst_1
    //   1864: anewarray 169	java/lang/Object
    //   1867: dup
    //   1868: iconst_0
    //   1869: aload 18
    //   1871: invokevirtual 548	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1874: aastore
    //   1875: invokestatic 550	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1878: goto -167 -> 1711
    //   1881: astore 20
    //   1883: goto -388 -> 1495
    //   1886: goto -1276 -> 610
    //   1889: aconst_null
    //   1890: astore 19
    //   1892: goto -1327 -> 565
    //   1895: iload 4
    //   1897: istore 7
    //   1899: iload 6
    //   1901: istore 4
    //   1903: iload 7
    //   1905: istore 6
    //   1907: goto +32 -> 1939
    //   1910: iload 8
    //   1912: ifle -866 -> 1046
    //   1915: iload 7
    //   1917: ifle -871 -> 1046
    //   1920: iload 7
    //   1922: iload 8
    //   1924: if_icmplt -878 -> 1046
    //   1927: iconst_1
    //   1928: istore 16
    //   1930: goto -1597 -> 333
    //   1933: iconst_1
    //   1934: istore 4
    //   1936: goto -1537 -> 399
    //   1939: iload 9
    //   1941: iconst_1
    //   1942: iadd
    //   1943: istore 9
    //   1945: iload 6
    //   1947: istore 7
    //   1949: iload 4
    //   1951: istore 6
    //   1953: iload 7
    //   1955: istore 4
    //   1957: goto -838 -> 1119
    //   1960: iconst_0
    //   1961: istore 7
    //   1963: goto -672 -> 1291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1966	0	this	c
    //   0	1966	1	paramBoolean	boolean
    //   0	1966	2	paramInt1	int
    //   0	1966	3	paramInt2	int
    //   195	1761	4	i	int
    //   1112	223	5	j	int
    //   290	1662	6	k	int
    //   298	1664	7	m	int
    //   295	1630	8	n	int
    //   1107	837	9	i1	int
    //   1173	160	10	i2	int
    //   186	1185	11	i3	int
    //   1104	31	12	i4	int
    //   1229	82	13	i5	int
    //   1237	64	14	i6	int
    //   1258	21	15	i7	int
    //   31	1898	16	bool1	boolean
    //   27	107	17	bool2	boolean
    //   123	1	18	localException1	Exception
    //   178	720	18	localObject1	Object
    //   919	470	18	localException2	Exception
    //   1441	15	18	localException3	Exception
    //   1478	211	18	localObject2	Object
    //   1814	26	18	localException4	Exception
    //   1856	14	18	localException5	Exception
    //   222	566	19	localObject3	Object
    //   1019	372	19	localException6	Exception
    //   1407	15	19	localException7	Exception
    //   1890	1	19	localObject4	Object
    //   593	545	20	localObject5	Object
    //   1489	18	20	localException8	Exception
    //   1881	1	20	localException9	Exception
    //   500	992	21	arrayOfInt	int[]
    //   583	83	22	localPoint	Point
    // Exception table:
    //   from	to	target	type
    //   66	85	123	java/lang/Exception
    //   154	169	919	java/lang/Exception
    //   960	992	1019	java/lang/Exception
    //   992	1011	1019	java/lang/Exception
    //   197	224	1407	java/lang/Exception
    //   224	254	1407	java/lang/Exception
    //   254	288	1407	java/lang/Exception
    //   300	330	1407	java/lang/Exception
    //   333	377	1407	java/lang/Exception
    //   1072	1079	1407	java/lang/Exception
    //   1084	1094	1407	java/lang/Exception
    //   1097	1106	1407	java/lang/Exception
    //   1137	1151	1407	java/lang/Exception
    //   1156	1163	1407	java/lang/Exception
    //   1175	1211	1407	java/lang/Exception
    //   1223	1260	1407	java/lang/Exception
    //   1296	1319	1407	java/lang/Exception
    //   1343	1395	1407	java/lang/Exception
    //   404	445	1441	java/lang/Exception
    //   565	595	1489	java/lang/Exception
    //   600	610	1489	java/lang/Exception
    //   618	643	1489	java/lang/Exception
    //   652	679	1489	java/lang/Exception
    //   679	698	1489	java/lang/Exception
    //   1653	1673	1814	java/lang/Exception
    //   1678	1699	1814	java/lang/Exception
    //   1701	1709	1856	java/lang/Exception
    //   698	737	1881	java/lang/Exception
  }
  
  /* Error */
  private w zf(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 617
    //   3: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: invokestatic 620	com/tencent/mm/plugin/voip/video/camera/prev/c:zg	(Z)Lcom/tencent/mm/compatible/deviceinfo/w;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +207 -> 219
    //   15: new 248	com/tencent/mm/compatible/deviceinfo/w
    //   18: dup
    //   19: new 169	java/lang/Object
    //   22: dup
    //   23: invokespecial 621	java/lang/Object:<init>	()V
    //   26: ldc_w 623
    //   29: ldc_w 625
    //   32: ldc_w 627
    //   35: ldc_w 629
    //   38: ldc_w 631
    //   41: ldc_w 633
    //   44: invokestatic 638	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   47: checkcast 639	android/hardware/Camera
    //   50: invokespecial 642	com/tencent/mm/compatible/deviceinfo/w:<init>	(Landroid/hardware/Camera;)V
    //   53: astore_2
    //   54: aload_2
    //   55: getfield 646	com/tencent/mm/compatible/deviceinfo/w:lWs	Landroid/hardware/Camera;
    //   58: ifnonnull +23 -> 81
    //   61: getstatic 274	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   64: ldc2_w 275
    //   67: lconst_0
    //   68: lconst_1
    //   69: iconst_0
    //   70: invokevirtual 280	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   73: ldc_w 617
    //   76: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aconst_null
    //   80: areturn
    //   81: aload_2
    //   82: iconst_0
    //   83: putfield 649	com/tencent/mm/compatible/deviceinfo/w:zS	I
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 96	com/tencent/mm/plugin/voip/video/camera/prev/c:UOu	Z
    //   91: getstatic 274	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   94: ldc2_w 275
    //   97: lconst_0
    //   98: lconst_1
    //   99: iconst_0
    //   100: invokevirtual 280	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   103: new 651	android/hardware/Camera$CameraInfo
    //   106: dup
    //   107: invokespecial 652	android/hardware/Camera$CameraInfo:<init>	()V
    //   110: astore_3
    //   111: aload_2
    //   112: getfield 649	com/tencent/mm/compatible/deviceinfo/w:zS	I
    //   115: aload_3
    //   116: invokestatic 656	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   119: aload_0
    //   120: aload_3
    //   121: getfield 659	android/hardware/Camera$CameraInfo:orientation	I
    //   124: putfield 100	com/tencent/mm/plugin/voip/video/camera/prev/c:Lqa	I
    //   127: aload_2
    //   128: invokestatic 661	com/tencent/mm/plugin/voip/video/camera/prev/c:g	(Lcom/tencent/mm/compatible/deviceinfo/w;)V
    //   131: aload_0
    //   132: aload_2
    //   133: invokespecial 663	com/tencent/mm/plugin/voip/video/camera/prev/c:f	(Lcom/tencent/mm/compatible/deviceinfo/w;)I
    //   136: pop
    //   137: ldc_w 617
    //   140: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_2
    //   144: areturn
    //   145: astore_2
    //   146: ldc 165
    //   148: new 282	java/lang/StringBuilder
    //   151: dup
    //   152: ldc_w 665
    //   155: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload_2
    //   159: invokevirtual 290	java/lang/Exception:toString	()Ljava/lang/String;
    //   162: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 298	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: getstatic 274	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   174: ldc2_w 275
    //   177: lconst_0
    //   178: lconst_1
    //   179: iconst_0
    //   180: invokevirtual 280	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   183: getstatic 274	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   186: ldc2_w 275
    //   189: lconst_1
    //   190: lconst_1
    //   191: iconst_0
    //   192: invokevirtual 280	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   195: aload_0
    //   196: getfield 263	com/tencent/mm/plugin/voip/video/camera/prev/c:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   199: ifnull +12 -> 211
    //   202: aload_0
    //   203: getfield 263	com/tencent/mm/plugin/voip/video/camera/prev/c:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   206: invokeinterface 553 1 0
    //   211: ldc_w 617
    //   214: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   217: aconst_null
    //   218: areturn
    //   219: aload_0
    //   220: iload_1
    //   221: putfield 96	com/tencent/mm/plugin/voip/video/camera/prev/c:UOu	Z
    //   224: aload_0
    //   225: getfield 263	com/tencent/mm/plugin/voip/video/camera/prev/c:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   228: aload_0
    //   229: getfield 667	com/tencent/mm/plugin/voip/video/camera/prev/c:nHi	I
    //   232: invokeinterface 670 2 0
    //   237: goto -134 -> 103
    //   240: astore_2
    //   241: ldc_w 617
    //   244: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aconst_null
    //   248: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	c
    //   0	249	1	paramBoolean	boolean
    //   10	134	2	localw	w
    //   145	14	2	localException1	Exception
    //   240	1	2	localException2	Exception
    //   110	11	3	localCameraInfo	android.hardware.Camera.CameraInfo
    // Exception table:
    //   from	to	target	type
    //   15	73	145	java/lang/Exception
    //   81	86	145	java/lang/Exception
    //   103	127	240	java/lang/Exception
  }
  
  private static w zg(boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    int i = 1;
    AppMethodBeat.i(292920);
    if (com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP <= 0)
    {
      AppMethodBeat.o(292920);
      return null;
    }
    if (!com.tencent.mm.plugin.voip.video.camera.a.d.icE())
    {
      AppMethodBeat.o(292920);
      return null;
    }
    Object localObject1;
    if (paramBoolean == true) {
      localObject1 = localObject3;
    }
    for (;;)
    {
      try
      {
        localObject2 = com.tencent.mm.compatible.deviceinfo.d.G(MMApplicationContext.getContext(), 1);
        localObject1 = localObject3;
        Log.i("Camera", "Use front");
        localObject1 = localObject4;
        if (localObject2 != null)
        {
          localObject1 = localObject3;
          localObject2 = ((d.a.a)localObject2).lTN;
          localObject1 = localObject2;
          ((w)localObject2).zS = i;
          localObject1 = localObject2;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(159L, 0L, 1L, false);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(159L, 1L, 1L, false);
        Log.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + localException.toString());
        continue;
      }
      AppMethodBeat.o(292920);
      return localObject1;
      localObject1 = localObject3;
      localObject2 = com.tencent.mm.compatible.deviceinfo.d.G(MMApplicationContext.getContext(), 0);
      localObject1 = localObject3;
      Log.i("Camera", "Use back");
      i = 0;
    }
  }
  
  public final void Jd(int paramInt)
  {
    AppMethodBeat.i(293075);
    this.nHi = paramInt;
    this.LpV.Jd(this.nHi);
    AppMethodBeat.o(293075);
  }
  
  public final int a(com.tencent.mm.plugin.voip.video.camera.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(293010);
    if (com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP <= 0)
    {
      this.UOA = 1;
      AppMethodBeat.o(293010);
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
      this.UOA = 1;
      AppMethodBeat.o(293010);
      return i;
      if (!com.tencent.mm.plugin.voip.video.camera.a.d.UOi.UOK) {
        paramBoolean = true;
      }
    }
    this.UOA = 0;
    AppMethodBeat.o(293010);
    return 1;
  }
  
  public final boolean boa()
  {
    return this.nvB;
  }
  
  public final boolean bqb()
  {
    boolean bool = false;
    if (this.UOu) {}
    for (int i = 0;; i = OpenGlRender.FLAG_Mirror)
    {
      if (i == OpenGlRender.FLAG_Mirror) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final void ggH()
  {
    AppMethodBeat.i(293044);
    Log.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.LpW);
    if ((this.LpW) && (this.Abo != null))
    {
      this.LpX = false;
      if (!this.Abo.lWt) {
        this.Abo.a(null);
      }
    }
    try
    {
      this.Abo.auq();
      this.nvB = false;
      this.LpW = false;
      if (1 == this.UOA)
      {
        rw localrw = new rw();
        localrw.hUY.type = 2;
        localrw.publish();
      }
      Log.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.LpS);
      if (this.LpS)
      {
        this.UOA = 0;
        this.LpX = false;
        if ((this.Abo != null) && (!this.Abo.lWt)) {
          this.Abo.release();
        }
        this.Abo = null;
        this.LpS = false;
        this.LpY = null;
        if (this.LpZ != null) {
          this.LpZ.clear();
        }
        this.LpZ = null;
        this.LpT = false;
        if (this.Lwy != null)
        {
          this.Lwy.unInit();
          this.Lwy = null;
        }
        AppMethodBeat.o(293044);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Voip.CaptureRender", "stopPreview:error" + localException.toString());
        continue;
        if (this.Abo != null)
        {
          this.Abo.release();
          this.Abo = null;
          this.LpS = false;
        }
      }
    }
  }
  
  public final Size hq()
  {
    return this.UOQ;
  }
  
  public final int icA()
  {
    return this.Lqa;
  }
  
  public final void icB()
  {
    boolean bool3 = true;
    AppMethodBeat.i(293051);
    if ((af.lXY.lTy == 1) && (this.LpT))
    {
      AppMethodBeat.o(293051);
      return;
    }
    if (af.lXY.lTx > 2000) {
      this.LpN = af.lXY.lTx;
    }
    Log.e("MicroMsg.Voip.CaptureRender", "focusOnFace error, faceLocation is null");
    StringBuilder localStringBuilder;
    boolean bool2;
    if (System.currentTimeMillis() - this.UOz > this.LpN)
    {
      bool1 = true;
      localStringBuilder = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
      if (this.UOw) {
        break label266;
      }
      bool2 = true;
      label102:
      localStringBuilder = localStringBuilder.append(bool2).append(",isAutoFocusTimeout: ").append(bool1).append(",mAutoFocusTimeOut:").append(this.LpN).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
      if (this.UOx == this.UOu) {
        break label271;
      }
    }
    label266:
    label271:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      Log.i("MicroMsg.Voip.CaptureRender", bool1 + ",isClickScreen :true");
      try
      {
        if ((this.Abo != null) && (this.Abo.aPy() != null) && (this.Abo.aPy().getFocusMode() != null) && (this.Abo.aPy().getFocusMode().equals("auto")))
        {
          this.Abo.a(null);
          this.UOE = null;
          this.UOz = System.currentTimeMillis();
          this.UOw = true;
          this.UOx = this.UOu;
        }
        AppMethodBeat.o(293051);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Voip.CaptureRender", "mCamera.getParameters() or autoFocus fail!" + localException.toString());
        AppMethodBeat.o(293051);
      }
      bool1 = false;
      break;
      bool2 = false;
      break label102;
    }
  }
  
  public final int icC()
  {
    AppMethodBeat.i(292997);
    try
    {
      int i = this.Abo.aPy().getPreviewFrameRate();
      AppMethodBeat.o(292997);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "get camera fps failed");
      AppMethodBeat.o(292997);
    }
    return 0;
  }
  
  public final boolean icu()
  {
    return this.UOu;
  }
  
  public final boolean icv()
  {
    return this.UOv;
  }
  
  public final int icw()
  {
    return this.UOA;
  }
  
  public final int icx()
  {
    AppMethodBeat.i(293028);
    if (!this.LpS)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
      this.UOA = 1;
      AppMethodBeat.o(293028);
      return -1;
    }
    Log.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", new Object[] { Boolean.valueOf(this.LpU) });
    if (this.mSurfaceTexture != null) {}
    try
    {
      this.Abo.f(this.mSurfaceTexture);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.Abo.aPz();
          this.nvB = true;
          this.LpW = true;
          if (this.Lwy == null) {
            this.Lwy = new com.tencent.mm.plugin.voip.video.camera.a.b(this);
          }
          this.LpV.Jd(this.nHi);
          AppMethodBeat.o(293028);
          return 1;
          localException1 = localException1;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(159L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(159L, 2L, 1L, false);
          this.UOA = 1;
          Log.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + localException1.toString());
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(159L, 0L, 1L, false);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(159L, 2L, 1L, false);
          this.UOA = 1;
          if (this.LpV != null) {
            this.LpV.dre();
          }
          Log.e("MicroMsg.Voip.CaptureRender", "startPreview:error" + localException2.toString());
        }
      }
    }
  }
  
  public final void icy()
  {
    AppMethodBeat.i(293020);
    if (com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP < 2)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP);
      AppMethodBeat.o(293020);
      return;
    }
    Log.i("MicroMsg.Voip.CaptureRender", "ExchangeCapture start, gCameraNum= " + com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP);
    ggH();
    com.tencent.mm.plugin.voip.video.camera.a.c localc = this.LpV;
    if (!this.UOu) {}
    for (boolean bool = true;; bool = false)
    {
      a(localc, bool);
      icx();
      SubCoreVoip.hVp().aqt(this.UOA);
      this.nGD = true;
      AppMethodBeat.o(293020);
      return;
    }
  }
  
  public final int icz()
  {
    boolean bool = true;
    int k;
    int i;
    int j;
    if (this.UOu)
    {
      k = com.tencent.mm.plugin.voip.video.camera.a.d.UOl;
      i = k;
      if (!af.lXY.lSW) {
        break label115;
      }
      i = k;
      if (af.lXY.lSV.hYK == 0) {
        break label115;
      }
      j = 1;
      i = k;
    }
    for (;;)
    {
      if ((j == 0) && (i > 0)) {}
      for (;;)
      {
        this.UOv = bool;
        if (!this.UOv) {
          break label112;
        }
        return 270;
        j = com.tencent.mm.plugin.voip.video.camera.a.d.UOm;
        i = j;
        if (!af.lXY.lSY) {
          break label115;
        }
        i = j;
        if (af.lXY.lSX.hYK == 0) {
          break label115;
        }
        k = 1;
        i = j;
        j = k;
        break;
        bool = false;
      }
      label112:
      return 90;
      label115:
      j = 0;
    }
  }
  
  public final void onOrientationChange(int paramInt)
  {
    this.UOP = paramInt;
  }
  
  public final void unInit()
  {
    AppMethodBeat.i(293068);
    if (com.tencent.mm.plugin.voip.f.h.ibv())
    {
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(292909);
          c.this.ggH();
          AppMethodBeat.o(292909);
        }
      });
      AppMethodBeat.o(293068);
      return;
    }
    ggH();
    AppMethodBeat.o(293068);
  }
  
  public final void v(SurfaceTexture paramSurfaceTexture)
  {
    this.mSurfaceTexture = paramSurfaceTexture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.prev.c
 * JD-Core Version:    0.7.0.1
 */