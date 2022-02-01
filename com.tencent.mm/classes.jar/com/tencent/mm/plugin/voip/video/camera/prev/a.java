package com.tencent.mm.plugin.voip.video.camera.prev;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rw;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.camera.a.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class a
  implements com.tencent.mm.plugin.video.a, com.tencent.mm.plugin.video.b, b.a
{
  private static final Pattern Lqg;
  private static int nLg;
  private static int nLh;
  protected w Abo;
  protected long LpN;
  protected Camera.Parameters LpP;
  protected int LpR;
  protected boolean LpS;
  protected boolean LpT;
  protected boolean LpU;
  protected com.tencent.mm.plugin.voip.video.camera.a.c LpV;
  protected boolean LpW;
  protected boolean LpX;
  protected byte[] LpY;
  protected List<byte[]> LpZ;
  protected int Lqa;
  protected int Lqb;
  protected int Lqc;
  protected boolean Lqd;
  private byte[] Lqe;
  Camera.PreviewCallback Lqf;
  com.tencent.mm.plugin.voip.video.camera.a.b Lwy;
  protected int UOA;
  protected ad UOB;
  protected ObservableSurfaceView UOC;
  protected ObservableTextureView UOD;
  protected int[] UOE;
  protected int UOF;
  protected boolean UOu;
  protected boolean UOv;
  protected boolean UOw;
  protected boolean UOx;
  protected boolean UOy;
  protected long UOz;
  protected int mHeight;
  protected int mWidth;
  protected boolean nGD;
  private int nHi;
  protected boolean nvB;
  
  static
  {
    AppMethodBeat.i(292998);
    Lqg = Pattern.compile(",");
    nLg = 20;
    nLh = 70;
    AppMethodBeat.o(292998);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292913);
    this.UOu = false;
    this.UOv = false;
    this.UOw = false;
    this.UOx = false;
    this.UOy = false;
    this.UOz = 0L;
    this.LpN = 30000L;
    this.UOA = 0;
    this.LpS = false;
    this.LpT = false;
    this.LpU = false;
    this.UOC = null;
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
    this.Lqf = new Camera.PreviewCallback()
    {
      public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(292922);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          h.OAn.idkeyStat(159L, 0L, 1L, false);
          h.OAn.idkeyStat(159L, 3L, 1L, false);
          if (a.this.LpV != null) {
            a.this.LpV.dre();
          }
          AppMethodBeat.o(292922);
          return;
        }
        if (a.this.UOB == null)
        {
          Log.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
          AppMethodBeat.o(292922);
          return;
        }
        int m;
        int i;
        int k;
        int j;
        if (a.this.LpV != null)
        {
          if ((a.a(a.this) == null) || (a.a(a.this).length != paramAnonymousArrayOfByte.length)) {
            a.a(a.this, new byte[paramAnonymousArrayOfByte.length]);
          }
          System.arraycopy(paramAnonymousArrayOfByte, 0, a.a(a.this), 0, paramAnonymousArrayOfByte.length);
          m = 1;
          if (a.this.UOu)
          {
            i = com.tencent.mm.plugin.voip.video.camera.a.d.UOl;
            k = i;
            if (!af.lXY.lSW) {
              break label609;
            }
            k = i;
            if (af.lXY.lSV.hYK == 0) {
              break label609;
            }
            j = af.lXY.lSV.lTJ;
            m = 1;
            k = i;
            i = m;
          }
        }
        for (;;)
        {
          label224:
          boolean bool;
          if (k > 0)
          {
            m = 32;
            paramAnonymousCamera = a.this;
            if ((i != 0) || (k <= 0)) {
              break label516;
            }
            bool = true;
            label241:
            paramAnonymousCamera.UOv = bool;
            k = a.this.UOB.width;
            int n = a.this.UOB.height;
            if ((i == 0) || (a.this.drd())) {
              break label522;
            }
            if (a.this.LpY == null)
            {
              i = k * n * 3 / 2;
              a.this.LpY = new byte[i];
              a.this.LpY[0] = 90;
            }
            SubCoreVoip.hVp().a(a.a(a.this), a.a(a.this).length, k, n, a.this.LpR, a.this.LpY, a.this.LpY.length, k, n, j);
            a.this.LpV.a(a.this.LpY, a.this.LpY.length, k, n, a.this.LpR, m);
          }
          for (;;)
          {
            if (m.getApiLevel() >= 8)
            {
              if (a.this.Abo == null)
              {
                Log.e("MicroMsg.Voip.CaptureRender", "the camera is null and has been release");
                AppMethodBeat.o(292922);
                return;
                j = com.tencent.mm.plugin.voip.video.camera.a.d.UOm;
                k = j;
                if (!af.lXY.lSY) {
                  break label609;
                }
                k = j;
                if (af.lXY.lSX.hYK == 0) {
                  break label609;
                }
                m = af.lXY.lSX.lTJ;
                i = 1;
                k = j;
                j = m;
                break;
                m = 0;
                break label224;
                label516:
                bool = false;
                break label241;
                label522:
                a.this.LpV.a(a.a(a.this), a.a(a.this).length, a.this.UOB.width, a.this.UOB.height, a.this.LpR, m);
                continue;
              }
              if (a.this.Abo != null) {
                a.this.Abo.aj(paramAnonymousArrayOfByte);
              }
            }
          }
          AppMethodBeat.o(292922);
          return;
          label609:
          i = 0;
          j = m;
        }
      }
    };
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    com.tencent.mm.plugin.voip.video.camera.a.d.kC(MMApplicationContext.getContext().getApplicationContext());
    Log.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
    AppMethodBeat.o(292913);
  }
  
  private static Point a(CharSequence paramCharSequence, Point paramPoint)
  {
    AppMethodBeat.i(292949);
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
        AppMethodBeat.o(292949);
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
      AppMethodBeat.o(292949);
      return null;
      label274:
      k = j;
      int n = i;
    }
  }
  
  private static boolean a(w paramw, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292934);
    if (paramw == null)
    {
      AppMethodBeat.o(292934);
      return false;
    }
    try
    {
      Camera.Parameters localParameters = paramw.aPy();
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        localParameters.setPreviewSize(paramInt1, paramInt2);
      }
      paramw.c(localParameters);
      AppMethodBeat.o(292934);
      return true;
    }
    catch (Exception paramw)
    {
      h.OAn.idkeyStat(159L, 0L, 1L, false);
      Log.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + paramw.toString());
      AppMethodBeat.o(292934);
    }
    return false;
  }
  
  private boolean b(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(292942);
    if (paramw == null)
    {
      AppMethodBeat.o(292942);
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
      h.OAn.idkeyStat(159L, 0L, 1L, false);
      Log.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + paramw.toString());
      AppMethodBeat.o(292942);
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
      AppMethodBeat.o(292942);
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
    AppMethodBeat.i(292977);
    if (paramw == null)
    {
      AppMethodBeat.o(292977);
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
      AppMethodBeat.o(292977);
      return i;
    }
  }
  
  private static void g(w paramw)
  {
    AppMethodBeat.i(292982);
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
      AppMethodBeat.o(292982);
    }
  }
  
  private void ggF()
  {
    AppMethodBeat.i(292919);
    for (;;)
    {
      try
      {
        if ((this.Abo != null) && (this.LpS))
        {
          if ((this.UOB != null) && (this.UOB.height > 0) && (this.UOB.width > 0))
          {
            int j = this.UOB.height * this.UOB.width * 3 / 2;
            if (this.LpZ == null)
            {
              this.LpZ = new ArrayList(3);
              i = 0;
              if (i < 3)
              {
                this.LpZ.add(new byte[j]);
                i += 1;
                continue;
                if (i < this.LpZ.size())
                {
                  if (this.Abo == null) {
                    break label225;
                  }
                  this.Abo.aj((byte[])this.LpZ.get(i));
                  break label225;
                }
                this.Abo.b(this.Lqf);
                AppMethodBeat.o(292919);
              }
            }
          }
          else
          {
            this.Abo.a(this.Lqf);
          }
        }
        else
        {
          AppMethodBeat.o(292919);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", localException, "setPreviewCallback error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(292919);
        return;
      }
      int i = 0;
      continue;
      label225:
      i += 1;
    }
  }
  
  /* Error */
  private int o(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 459
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 175
    //   8: ldc_w 461
    //   11: iload_1
    //   12: invokestatic 464	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   15: invokevirtual 218	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 121	com/tencent/mm/plugin/voip/video/camera/prev/a:LpT	Z
    //   26: aload_0
    //   27: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   30: ifnull +2029 -> 2059
    //   33: aload_0
    //   34: getfield 101	com/tencent/mm/plugin/voip/video/camera/prev/a:UOu	Z
    //   37: iload_1
    //   38: if_icmpeq +105 -> 143
    //   41: aload_0
    //   42: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   45: getfield 467	com/tencent/mm/compatible/deviceinfo/w:lWt	Z
    //   48: ifne +11 -> 59
    //   51: aload_0
    //   52: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   55: aconst_null
    //   56: invokevirtual 452	com/tencent/mm/compatible/deviceinfo/w:a	(Landroid/hardware/Camera$PreviewCallback;)V
    //   59: aload_0
    //   60: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   63: invokevirtual 470	com/tencent/mm/compatible/deviceinfo/w:auq	()V
    //   66: aload_0
    //   67: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   70: invokevirtual 473	com/tencent/mm/compatible/deviceinfo/w:release	()V
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   78: iconst_1
    //   79: istore 16
    //   81: iload 16
    //   83: ifeq +74 -> 157
    //   86: aload_0
    //   87: aload_0
    //   88: iload_1
    //   89: invokespecial 477	com/tencent/mm/plugin/voip/video/camera/prev/a:zf	(Z)Lcom/tencent/mm/compatible/deviceinfo/w;
    //   92: putfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   95: aload_0
    //   96: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   99: ifnonnull +53 -> 152
    //   102: aload_0
    //   103: iconst_0
    //   104: putfield 119	com/tencent/mm/plugin/voip/video/camera/prev/a:LpS	Z
    //   107: ldc_w 459
    //   110: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iconst_m1
    //   114: ireturn
    //   115: astore 18
    //   117: ldc 175
    //   119: ldc_w 479
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload 18
    //   130: invokevirtual 483	java/lang/Exception:fillInStackTrace	()Ljava/lang/Throwable;
    //   133: aastore
    //   134: invokestatic 485	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: iconst_1
    //   138: istore 16
    //   140: goto -59 -> 81
    //   143: aload_0
    //   144: getfield 149	com/tencent/mm/plugin/voip/video/camera/prev/a:Lqd	Z
    //   147: istore 16
    //   149: goto -68 -> 81
    //   152: aload_0
    //   153: iconst_0
    //   154: putfield 149	com/tencent/mm/plugin/voip/video/camera/prev/a:Lqd	Z
    //   157: aload_0
    //   158: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   161: ifnull +11 -> 172
    //   164: aload_0
    //   165: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   168: invokevirtual 260	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   171: pop
    //   172: aload_0
    //   173: iconst_1
    //   174: putfield 119	com/tencent/mm/plugin/voip/video/camera/prev/a:LpS	Z
    //   177: aload_0
    //   178: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   181: astore 18
    //   183: getstatic 489	com/tencent/mm/plugin/voip/video/camera/a/d:UOi	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   186: getfield 494	com/tencent/mm/plugin/voip/video/camera/prev/b:UOI	I
    //   189: istore 11
    //   191: aload 18
    //   193: ifnull +256 -> 449
    //   196: bipush 26
    //   198: istore 4
    //   200: ldc 175
    //   202: ldc_w 496
    //   205: iconst_1
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: iload 11
    //   213: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: aastore
    //   217: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: aload 18
    //   222: invokevirtual 260	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   225: astore 19
    //   227: invokestatic 499	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   230: ifeq +27 -> 257
    //   233: ldc_w 501
    //   236: invokestatic 507	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   239: checkcast 501	com/tencent/mm/plugin/zero/b/a
    //   242: invokeinterface 511 1 0
    //   247: ldc_w 513
    //   250: bipush 26
    //   252: invokevirtual 516	com/tencent/mm/k/f:getInt	(Ljava/lang/String;I)I
    //   255: istore 4
    //   257: ldc 175
    //   259: ldc_w 518
    //   262: iconst_1
    //   263: anewarray 4	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: iload 4
    //   270: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: aastore
    //   274: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: invokestatic 523	com/tencent/mm/compatible/util/l:isSamsung	()Z
    //   280: ifne +11 -> 291
    //   283: iload 4
    //   285: invokestatic 529	com/tencent/mm/compatible/util/d:rb	(I)Z
    //   288: ifeq +1114 -> 1402
    //   291: ldc 195
    //   293: istore 6
    //   295: iconst_0
    //   296: istore 16
    //   298: iconst_m1
    //   299: istore 8
    //   301: iconst_0
    //   302: istore 7
    //   304: getstatic 354	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   307: ifnull +1758 -> 2065
    //   310: getstatic 354	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   313: getfield 532	com/tencent/mm/compatible/deviceinfo/c:lTD	I
    //   316: sipush 1000
    //   319: imul
    //   320: istore 8
    //   322: getstatic 354	com/tencent/mm/compatible/deviceinfo/af:lXY	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   325: getfield 535	com/tencent/mm/compatible/deviceinfo/c:lTE	I
    //   328: sipush 1000
    //   331: imul
    //   332: istore 7
    //   334: goto +1731 -> 2065
    //   337: ldc 175
    //   339: ldc_w 537
    //   342: iconst_4
    //   343: anewarray 4	java/lang/Object
    //   346: dup
    //   347: iconst_0
    //   348: iload 8
    //   350: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: aastore
    //   354: dup
    //   355: iconst_1
    //   356: iload 7
    //   358: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   361: aastore
    //   362: dup
    //   363: iconst_2
    //   364: iload 11
    //   366: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   369: aastore
    //   370: dup
    //   371: iconst_3
    //   372: iload 17
    //   374: invokestatic 311	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   377: aastore
    //   378: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   381: iload 8
    //   383: ldc 195
    //   385: if_icmpeq +15 -> 400
    //   388: iload 7
    //   390: ldc 195
    //   392: if_icmpeq +8 -> 400
    //   395: iload 17
    //   397: ifne +947 -> 1344
    //   400: iconst_1
    //   401: istore 4
    //   403: iload 4
    //   405: ifeq +44 -> 449
    //   408: ldc 175
    //   410: ldc_w 539
    //   413: iconst_1
    //   414: anewarray 4	java/lang/Object
    //   417: dup
    //   418: iconst_0
    //   419: iload 11
    //   421: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   424: aastore
    //   425: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   428: aload 18
    //   430: invokevirtual 260	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   433: astore 19
    //   435: aload 19
    //   437: iload 11
    //   439: invokevirtual 542	android/hardware/Camera$Parameters:setPreviewFrameRate	(I)V
    //   442: aload 18
    //   444: aload 19
    //   446: invokevirtual 269	com/tencent/mm/compatible/deviceinfo/w:c	(Landroid/hardware/Camera$Parameters;)V
    //   449: ldc 175
    //   451: new 283	java/lang/StringBuilder
    //   454: dup
    //   455: ldc_w 544
    //   458: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   461: iload_2
    //   462: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   465: ldc 78
    //   467: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: iload_3
    //   471: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: iload_1
    //   481: ifeq +992 -> 1473
    //   484: getstatic 489	com/tencent/mm/plugin/voip/video/camera/a/d:UOi	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   487: getfield 548	com/tencent/mm/plugin/voip/video/camera/prev/b:UON	Landroid/graphics/Point;
    //   490: astore 18
    //   492: aload 18
    //   494: ifnull +990 -> 1484
    //   497: iconst_1
    //   498: istore 4
    //   500: aconst_null
    //   501: astore 21
    //   503: aload 18
    //   505: ifnull +1533 -> 2038
    //   508: new 431	com/tencent/mm/compatible/deviceinfo/ad
    //   511: dup
    //   512: aload 18
    //   514: getfield 240	android/graphics/Point:x	I
    //   517: aload 18
    //   519: getfield 248	android/graphics/Point:y	I
    //   522: invokespecial 549	com/tencent/mm/compatible/deviceinfo/ad:<init>	(II)V
    //   525: astore 19
    //   527: ldc 175
    //   529: new 283	java/lang/StringBuilder
    //   532: dup
    //   533: ldc_w 551
    //   536: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   539: aload 19
    //   541: getfield 433	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   544: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   547: ldc 78
    //   549: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload 19
    //   554: getfield 432	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   557: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: aload_0
    //   567: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   570: invokevirtual 260	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   573: astore 18
    //   575: new 237	android/graphics/Point
    //   578: dup
    //   579: iload_2
    //   580: iload_3
    //   581: invokespecial 250	android/graphics/Point:<init>	(II)V
    //   584: astore 22
    //   586: aload 18
    //   588: ldc_w 553
    //   591: invokevirtual 555	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   594: astore 20
    //   596: aload 20
    //   598: ifnonnull +1437 -> 2035
    //   601: aload 18
    //   603: ldc_w 557
    //   606: invokevirtual 555	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   609: astore 20
    //   611: aconst_null
    //   612: astore 18
    //   614: aload 20
    //   616: ifnull +28 -> 644
    //   619: ldc 175
    //   621: ldc_w 559
    //   624: aload 20
    //   626: invokestatic 214	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   629: invokevirtual 218	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   632: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: aload 20
    //   637: aload 22
    //   639: invokestatic 561	com/tencent/mm/plugin/voip/video/camera/prev/a:a	(Ljava/lang/CharSequence;Landroid/graphics/Point;)Landroid/graphics/Point;
    //   642: astore 18
    //   644: aload 18
    //   646: astore 20
    //   648: aload 18
    //   650: ifnonnull +30 -> 680
    //   653: new 237	android/graphics/Point
    //   656: dup
    //   657: aload 22
    //   659: getfield 240	android/graphics/Point:x	I
    //   662: iconst_3
    //   663: ishr
    //   664: iconst_3
    //   665: ishl
    //   666: aload 22
    //   668: getfield 248	android/graphics/Point:y	I
    //   671: iconst_3
    //   672: ishr
    //   673: iconst_3
    //   674: ishl
    //   675: invokespecial 250	android/graphics/Point:<init>	(II)V
    //   678: astore 20
    //   680: new 431	com/tencent/mm/compatible/deviceinfo/ad
    //   683: dup
    //   684: aload 20
    //   686: getfield 240	android/graphics/Point:x	I
    //   689: aload 20
    //   691: getfield 248	android/graphics/Point:y	I
    //   694: invokespecial 549	com/tencent/mm/compatible/deviceinfo/ad:<init>	(II)V
    //   697: astore 18
    //   699: ldc 175
    //   701: new 283	java/lang/StringBuilder
    //   704: dup
    //   705: ldc_w 563
    //   708: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   711: aload 18
    //   713: getfield 433	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   716: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   719: ldc 78
    //   721: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload 18
    //   726: getfield 432	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   729: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   732: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   738: iload 4
    //   740: ifeq +779 -> 1519
    //   743: aload_0
    //   744: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   747: aload 19
    //   749: getfield 433	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   752: aload 19
    //   754: getfield 432	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   757: invokestatic 565	com/tencent/mm/plugin/voip/video/camera/prev/a:a	(Lcom/tencent/mm/compatible/deviceinfo/w;II)Z
    //   760: istore_1
    //   761: ldc 175
    //   763: new 283	java/lang/StringBuilder
    //   766: dup
    //   767: ldc_w 567
    //   770: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   773: aload 19
    //   775: getfield 433	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   778: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   781: ldc_w 569
    //   784: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: aload 19
    //   789: getfield 432	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   792: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   795: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: iload_1
    //   802: ifne +838 -> 1640
    //   805: aload 18
    //   807: ifnull +833 -> 1640
    //   810: ldc 175
    //   812: new 283	java/lang/StringBuilder
    //   815: dup
    //   816: ldc_w 571
    //   819: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   822: aload 18
    //   824: getfield 433	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   827: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: ldc_w 569
    //   833: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload 18
    //   838: getfield 432	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   841: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   844: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   850: aload_0
    //   851: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   854: aload 18
    //   856: getfield 433	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   859: aload 18
    //   861: getfield 432	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   864: invokestatic 565	com/tencent/mm/plugin/voip/video/camera/prev/a:a	(Lcom/tencent/mm/compatible/deviceinfo/w;II)Z
    //   867: ifne +773 -> 1640
    //   870: ldc 175
    //   872: new 283	java/lang/StringBuilder
    //   875: dup
    //   876: ldc_w 573
    //   879: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   882: aload 18
    //   884: getfield 433	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   887: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   890: ldc_w 569
    //   893: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: aload 18
    //   898: getfield 432	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   901: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   904: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   910: ldc_w 459
    //   913: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   916: iconst_m1
    //   917: ireturn
    //   918: astore 18
    //   920: getstatic 275	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   923: ldc2_w 276
    //   926: lconst_0
    //   927: lconst_1
    //   928: iconst_0
    //   929: invokevirtual 281	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   932: ldc 175
    //   934: ldc_w 575
    //   937: iconst_1
    //   938: anewarray 4	java/lang/Object
    //   941: dup
    //   942: iconst_0
    //   943: aload 18
    //   945: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   948: aastore
    //   949: invokestatic 485	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   952: aload_0
    //   953: getfield 577	com/tencent/mm/plugin/voip/video/camera/prev/a:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   956: ifnull +54 -> 1010
    //   959: aload_0
    //   960: getfield 577	com/tencent/mm/plugin/voip/video/camera/prev/a:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   963: invokeinterface 582 1 0
    //   968: aload_0
    //   969: iconst_1
    //   970: putfield 149	com/tencent/mm/plugin/voip/video/camera/prev/a:Lqd	Z
    //   973: aload_0
    //   974: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   977: getfield 467	com/tencent/mm/compatible/deviceinfo/w:lWt	Z
    //   980: ifne +11 -> 991
    //   983: aload_0
    //   984: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   987: aconst_null
    //   988: invokevirtual 452	com/tencent/mm/compatible/deviceinfo/w:a	(Landroid/hardware/Camera$PreviewCallback;)V
    //   991: aload_0
    //   992: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   995: invokevirtual 470	com/tencent/mm/compatible/deviceinfo/w:auq	()V
    //   998: aload_0
    //   999: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1002: invokevirtual 473	com/tencent/mm/compatible/deviceinfo/w:release	()V
    //   1005: aload_0
    //   1006: aconst_null
    //   1007: putfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1010: ldc_w 459
    //   1013: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1016: iconst_m1
    //   1017: ireturn
    //   1018: astore 19
    //   1020: ldc 175
    //   1022: aload 19
    //   1024: ldc_w 584
    //   1027: iconst_1
    //   1028: anewarray 4	java/lang/Object
    //   1031: dup
    //   1032: iconst_0
    //   1033: aload 18
    //   1035: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1038: aastore
    //   1039: invokestatic 408	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1042: goto -32 -> 1010
    //   1045: iload 8
    //   1047: ifne +24 -> 1071
    //   1050: iload 7
    //   1052: ifne +19 -> 1071
    //   1055: iconst_0
    //   1056: istore 17
    //   1058: ldc_w 585
    //   1061: istore 7
    //   1063: ldc_w 585
    //   1066: istore 8
    //   1068: goto -731 -> 337
    //   1071: aload 19
    //   1073: invokevirtual 588	android/hardware/Camera$Parameters:getSupportedPreviewFpsRange	()Ljava/util/List;
    //   1076: astore 20
    //   1078: aload 20
    //   1080: ifnull +1008 -> 2088
    //   1083: aload 20
    //   1085: invokeinterface 325 1 0
    //   1090: ifne +6 -> 1096
    //   1093: goto +995 -> 2088
    //   1096: aload 20
    //   1098: invokeinterface 325 1 0
    //   1103: istore 12
    //   1105: iconst_0
    //   1106: istore 9
    //   1108: ldc_w 585
    //   1111: istore 5
    //   1113: ldc_w 585
    //   1116: istore 4
    //   1118: iload 16
    //   1120: istore 17
    //   1122: iload 5
    //   1124: istore 7
    //   1126: iload 4
    //   1128: istore 8
    //   1130: iload 9
    //   1132: iload 12
    //   1134: if_icmpge -797 -> 337
    //   1137: aload 20
    //   1139: iload 9
    //   1141: invokeinterface 420 2 0
    //   1146: checkcast 589	[I
    //   1149: astore 21
    //   1151: aload 21
    //   1153: ifnull +891 -> 2044
    //   1156: aload 21
    //   1158: arraylength
    //   1159: iconst_1
    //   1160: if_icmple +884 -> 2044
    //   1163: aload 21
    //   1165: iconst_0
    //   1166: iaload
    //   1167: istore 8
    //   1169: aload 21
    //   1171: iconst_1
    //   1172: iaload
    //   1173: istore 10
    //   1175: ldc 175
    //   1177: ldc_w 591
    //   1180: iconst_3
    //   1181: anewarray 4	java/lang/Object
    //   1184: dup
    //   1185: iconst_0
    //   1186: iload 9
    //   1188: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1191: aastore
    //   1192: dup
    //   1193: iconst_1
    //   1194: iload 8
    //   1196: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1199: aastore
    //   1200: dup
    //   1201: iconst_2
    //   1202: iload 10
    //   1204: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1207: aastore
    //   1208: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1211: iload 8
    //   1213: iflt +831 -> 2044
    //   1216: iload 10
    //   1218: iload 8
    //   1220: if_icmplt +824 -> 2044
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
    //   1245: invokestatic 595	java/lang/Math:min	(II)I
    //   1248: istore 7
    //   1250: iload 11
    //   1252: iconst_5
    //   1253: isub
    //   1254: iconst_5
    //   1255: invokestatic 598	java/lang/Math:max	(II)I
    //   1258: istore 15
    //   1260: iload 13
    //   1262: iload 15
    //   1264: if_icmplt +851 -> 2115
    //   1267: iload 13
    //   1269: iload 7
    //   1271: if_icmpgt +844 -> 2115
    //   1274: iload 14
    //   1276: iload 15
    //   1278: if_icmplt +837 -> 2115
    //   1281: iload 14
    //   1283: iload 7
    //   1285: if_icmpgt +830 -> 2115
    //   1288: iconst_1
    //   1289: istore 7
    //   1291: iload 7
    //   1293: ifeq +751 -> 2044
    //   1296: iload 11
    //   1298: iload 14
    //   1300: isub
    //   1301: invokestatic 245	java/lang/Math:abs	(I)I
    //   1304: istore 7
    //   1306: iload 13
    //   1308: iload 11
    //   1310: isub
    //   1311: invokestatic 245	java/lang/Math:abs	(I)I
    //   1314: iload 7
    //   1316: iadd
    //   1317: istore 7
    //   1319: iload 7
    //   1321: iload 6
    //   1323: if_icmpge +721 -> 2044
    //   1326: iconst_1
    //   1327: istore 16
    //   1329: iload 7
    //   1331: istore 4
    //   1333: iload 10
    //   1335: istore 5
    //   1337: iload 8
    //   1339: istore 6
    //   1341: goto +753 -> 2094
    //   1344: ldc 175
    //   1346: ldc_w 600
    //   1349: iconst_3
    //   1350: anewarray 4	java/lang/Object
    //   1353: dup
    //   1354: iconst_0
    //   1355: iload 8
    //   1357: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1360: aastore
    //   1361: dup
    //   1362: iconst_1
    //   1363: iload 7
    //   1365: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1368: aastore
    //   1369: dup
    //   1370: iconst_2
    //   1371: iload 11
    //   1373: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1376: aastore
    //   1377: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1380: aload 19
    //   1382: iload 8
    //   1384: iload 7
    //   1386: invokevirtual 603	android/hardware/Camera$Parameters:setPreviewFpsRange	(II)V
    //   1389: aload 18
    //   1391: aload 19
    //   1393: invokevirtual 269	com/tencent/mm/compatible/deviceinfo/w:c	(Landroid/hardware/Camera$Parameters;)V
    //   1396: iconst_0
    //   1397: istore 4
    //   1399: goto -996 -> 403
    //   1402: iconst_1
    //   1403: istore 4
    //   1405: goto -1002 -> 403
    //   1408: astore 19
    //   1410: ldc 175
    //   1412: new 283	java/lang/StringBuilder
    //   1415: dup
    //   1416: ldc_w 605
    //   1419: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1422: aload 19
    //   1424: invokevirtual 291	java/lang/Exception:toString	()Ljava/lang/String;
    //   1427: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1433: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1436: iconst_1
    //   1437: istore 4
    //   1439: goto -1036 -> 403
    //   1442: astore 18
    //   1444: ldc 175
    //   1446: new 283	java/lang/StringBuilder
    //   1449: dup
    //   1450: ldc_w 607
    //   1453: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1456: aload 18
    //   1458: invokevirtual 291	java/lang/Exception:toString	()Ljava/lang/String;
    //   1461: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1464: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1467: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1470: goto -1021 -> 449
    //   1473: getstatic 489	com/tencent/mm/plugin/voip/video/camera/a/d:UOi	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   1476: getfield 610	com/tencent/mm/plugin/voip/video/camera/prev/b:UOO	Landroid/graphics/Point;
    //   1479: astore 18
    //   1481: goto -989 -> 492
    //   1484: iconst_0
    //   1485: istore 4
    //   1487: goto -987 -> 500
    //   1490: astore 20
    //   1492: aload 21
    //   1494: astore 18
    //   1496: ldc 175
    //   1498: ldc_w 612
    //   1501: iconst_1
    //   1502: anewarray 4	java/lang/Object
    //   1505: dup
    //   1506: iconst_0
    //   1507: aload 20
    //   1509: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1512: aastore
    //   1513: invokestatic 485	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1516: goto -778 -> 738
    //   1519: ldc 175
    //   1521: ldc_w 614
    //   1524: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1527: aload 18
    //   1529: ifnull +111 -> 1640
    //   1532: ldc 175
    //   1534: new 283	java/lang/StringBuilder
    //   1537: dup
    //   1538: ldc_w 616
    //   1541: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1544: aload 18
    //   1546: getfield 433	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   1549: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1552: ldc_w 569
    //   1555: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: aload 18
    //   1560: getfield 432	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   1563: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1566: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1569: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1572: aload_0
    //   1573: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1576: aload 18
    //   1578: getfield 433	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   1581: aload 18
    //   1583: getfield 432	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   1586: invokestatic 565	com/tencent/mm/plugin/voip/video/camera/prev/a:a	(Lcom/tencent/mm/compatible/deviceinfo/w;II)Z
    //   1589: ifne +51 -> 1640
    //   1592: ldc 175
    //   1594: new 283	java/lang/StringBuilder
    //   1597: dup
    //   1598: ldc_w 618
    //   1601: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1604: aload 18
    //   1606: getfield 433	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   1609: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1612: ldc_w 569
    //   1615: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1618: aload 18
    //   1620: getfield 432	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   1623: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1626: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1629: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1632: ldc_w 459
    //   1635: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1638: iconst_m1
    //   1639: ireturn
    //   1640: aload_0
    //   1641: aload_0
    //   1642: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1645: aload_0
    //   1646: getfield 101	com/tencent/mm/plugin/voip/video/camera/prev/a:UOu	Z
    //   1649: invokespecial 620	com/tencent/mm/plugin/voip/video/camera/prev/a:b	(Lcom/tencent/mm/compatible/deviceinfo/w;Z)Z
    //   1652: pop
    //   1653: aload_0
    //   1654: aload_0
    //   1655: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1658: invokevirtual 260	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   1661: putfield 622	com/tencent/mm/plugin/voip/video/camera/prev/a:LpP	Landroid/hardware/Camera$Parameters;
    //   1664: aload_0
    //   1665: getfield 622	com/tencent/mm/plugin/voip/video/camera/prev/a:LpP	Landroid/hardware/Camera$Parameters;
    //   1668: invokevirtual 626	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   1671: astore 18
    //   1673: aload 18
    //   1675: ifnull +24 -> 1699
    //   1678: aload_0
    //   1679: new 431	com/tencent/mm/compatible/deviceinfo/ad
    //   1682: dup
    //   1683: aload 18
    //   1685: getfield 387	android/hardware/Camera$Size:width	I
    //   1688: aload 18
    //   1690: getfield 390	android/hardware/Camera$Size:height	I
    //   1693: invokespecial 549	com/tencent/mm/compatible/deviceinfo/ad:<init>	(II)V
    //   1696: putfield 429	com/tencent/mm/plugin/voip/video/camera/prev/a:UOB	Lcom/tencent/mm/compatible/deviceinfo/ad;
    //   1699: aload_0
    //   1700: getfield 622	com/tencent/mm/plugin/voip/video/camera/prev/a:LpP	Landroid/hardware/Camera$Parameters;
    //   1703: invokevirtual 629	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   1706: istore_3
    //   1707: aload_0
    //   1708: getstatic 632	com/tencent/mm/plugin/voip/video/camera/a/d:UOn	I
    //   1711: putfield 634	com/tencent/mm/plugin/voip/video/camera/prev/a:LpR	I
    //   1714: aload_0
    //   1715: getfield 634	com/tencent/mm/plugin/voip/video/camera/prev/a:LpR	I
    //   1718: ifgt +9 -> 1727
    //   1721: aload_0
    //   1722: bipush 7
    //   1724: putfield 634	com/tencent/mm/plugin/voip/video/camera/prev/a:LpR	I
    //   1727: aload_0
    //   1728: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1731: astore 18
    //   1733: new 636	android/hardware/Camera$CameraInfo
    //   1736: dup
    //   1737: invokespecial 637	android/hardware/Camera$CameraInfo:<init>	()V
    //   1740: astore 19
    //   1742: aload_0
    //   1743: getfield 101	com/tencent/mm/plugin/voip/video/camera/prev/a:UOu	Z
    //   1746: ifeq +233 -> 1979
    //   1749: getstatic 640	com/tencent/mm/plugin/voip/video/camera/a/d:UOj	I
    //   1752: istore_2
    //   1753: iload_2
    //   1754: aload 19
    //   1756: invokestatic 646	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   1759: invokestatic 162	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1762: ldc_w 648
    //   1765: invokevirtual 652	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1768: checkcast 654	android/view/WindowManager
    //   1771: invokeinterface 658 1 0
    //   1776: invokevirtual 663	android/view/Display:getRotation	()I
    //   1779: istore 4
    //   1781: iconst_0
    //   1782: istore_2
    //   1783: iload 4
    //   1785: tableswitch	default:+336 -> 2121, 0:+339->2124, 1:+344->2129, 2:+350->2135, 3:+357->2142
    //   1817: getfield 101	com/tencent/mm/plugin/voip/video/camera/prev/a:UOu	Z
    //   1820: ifeq +166 -> 1986
    //   1823: sipush 360
    //   1826: iload_2
    //   1827: aload 19
    //   1829: getfield 666	android/hardware/Camera$CameraInfo:orientation	I
    //   1832: iadd
    //   1833: sipush 360
    //   1836: irem
    //   1837: isub
    //   1838: sipush 360
    //   1841: irem
    //   1842: istore_2
    //   1843: aload 18
    //   1845: iload_2
    //   1846: invokevirtual 669	com/tencent/mm/compatible/deviceinfo/w:qV	(I)V
    //   1849: aload_0
    //   1850: iload_2
    //   1851: putfield 671	com/tencent/mm/plugin/voip/video/camera/prev/a:Lqa	I
    //   1854: ldc 175
    //   1856: ldc_w 673
    //   1859: bipush 6
    //   1861: anewarray 4	java/lang/Object
    //   1864: dup
    //   1865: iconst_0
    //   1866: iload_3
    //   1867: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1870: aastore
    //   1871: dup
    //   1872: iconst_1
    //   1873: aload_0
    //   1874: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/a:UOB	Lcom/tencent/mm/compatible/deviceinfo/ad;
    //   1877: getfield 433	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   1880: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1883: aastore
    //   1884: dup
    //   1885: iconst_2
    //   1886: aload_0
    //   1887: getfield 429	com/tencent/mm/plugin/voip/video/camera/prev/a:UOB	Lcom/tencent/mm/compatible/deviceinfo/ad;
    //   1890: getfield 432	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   1893: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1896: aastore
    //   1897: dup
    //   1898: iconst_3
    //   1899: aload_0
    //   1900: getfield 634	com/tencent/mm/plugin/voip/video/camera/prev/a:LpR	I
    //   1903: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1906: aastore
    //   1907: dup
    //   1908: iconst_4
    //   1909: getstatic 676	com/tencent/mm/plugin/voip/video/camera/a/d:UOl	I
    //   1912: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1915: aastore
    //   1916: dup
    //   1917: iconst_5
    //   1918: aload_0
    //   1919: getfield 671	com/tencent/mm/plugin/voip/video/camera/prev/a:Lqa	I
    //   1922: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1925: aastore
    //   1926: invokestatic 313	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1929: ldc_w 459
    //   1932: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1935: iconst_1
    //   1936: ireturn
    //   1937: astore 18
    //   1939: getstatic 275	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1942: ldc2_w 276
    //   1945: lconst_0
    //   1946: lconst_1
    //   1947: iconst_0
    //   1948: invokevirtual 281	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1951: ldc 175
    //   1953: ldc_w 678
    //   1956: iconst_1
    //   1957: anewarray 4	java/lang/Object
    //   1960: dup
    //   1961: iconst_0
    //   1962: aload 18
    //   1964: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1967: aastore
    //   1968: invokestatic 485	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1971: ldc_w 459
    //   1974: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1977: iconst_m1
    //   1978: ireturn
    //   1979: getstatic 681	com/tencent/mm/plugin/voip/video/camera/a/d:UOk	I
    //   1982: istore_2
    //   1983: goto -230 -> 1753
    //   1986: aload 19
    //   1988: getfield 666	android/hardware/Camera$CameraInfo:orientation	I
    //   1991: iload_2
    //   1992: isub
    //   1993: sipush 360
    //   1996: iadd
    //   1997: sipush 360
    //   2000: irem
    //   2001: istore_2
    //   2002: goto -159 -> 1843
    //   2005: astore 18
    //   2007: ldc 175
    //   2009: ldc_w 683
    //   2012: iconst_1
    //   2013: anewarray 4	java/lang/Object
    //   2016: dup
    //   2017: iconst_0
    //   2018: aload 18
    //   2020: invokevirtual 457	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2023: aastore
    //   2024: invokestatic 485	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2027: goto -173 -> 1854
    //   2030: astore 20
    //   2032: goto -536 -> 1496
    //   2035: goto -1424 -> 611
    //   2038: aconst_null
    //   2039: astore 19
    //   2041: goto -1475 -> 566
    //   2044: iload 4
    //   2046: istore 7
    //   2048: iload 6
    //   2050: istore 4
    //   2052: iload 7
    //   2054: istore 6
    //   2056: goto +38 -> 2094
    //   2059: iconst_1
    //   2060: istore 16
    //   2062: goto -1981 -> 81
    //   2065: iload 8
    //   2067: ifle -1022 -> 1045
    //   2070: iload 7
    //   2072: ifle -1027 -> 1045
    //   2075: iload 7
    //   2077: iload 8
    //   2079: if_icmplt -1034 -> 1045
    //   2082: iconst_1
    //   2083: istore 17
    //   2085: goto -1748 -> 337
    //   2088: iconst_1
    //   2089: istore 4
    //   2091: goto -1688 -> 403
    //   2094: iload 9
    //   2096: iconst_1
    //   2097: iadd
    //   2098: istore 9
    //   2100: iload 6
    //   2102: istore 7
    //   2104: iload 4
    //   2106: istore 6
    //   2108: iload 7
    //   2110: istore 4
    //   2112: goto -994 -> 1118
    //   2115: iconst_0
    //   2116: istore 7
    //   2118: goto -827 -> 1291
    //   2121: goto -305 -> 1816
    //   2124: iconst_0
    //   2125: istore_2
    //   2126: goto -310 -> 1816
    //   2129: bipush 90
    //   2131: istore_2
    //   2132: goto -316 -> 1816
    //   2135: sipush 180
    //   2138: istore_2
    //   2139: goto -323 -> 1816
    //   2142: sipush 270
    //   2145: istore_2
    //   2146: goto -330 -> 1816
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2149	0	this	a
    //   0	2149	1	paramBoolean	boolean
    //   0	2149	2	paramInt1	int
    //   0	2149	3	paramInt2	int
    //   198	1913	4	i	int
    //   1111	225	5	j	int
    //   293	1814	6	k	int
    //   302	1815	7	m	int
    //   299	1781	8	n	int
    //   1106	993	9	i1	int
    //   1173	161	10	i2	int
    //   189	1183	11	i3	int
    //   1103	32	12	i4	int
    //   1229	82	13	i5	int
    //   1237	64	14	i6	int
    //   1258	21	15	i7	int
    //   79	1982	16	bool1	boolean
    //   372	1712	17	bool2	boolean
    //   115	14	18	localException1	Exception
    //   181	716	18	localObject1	Object
    //   918	472	18	localException2	Exception
    //   1442	15	18	localException3	Exception
    //   1479	365	18	localObject2	Object
    //   1937	26	18	localException4	Exception
    //   2005	14	18	localException5	Exception
    //   225	563	19	localObject3	Object
    //   1018	374	19	localException6	Exception
    //   1408	15	19	localException7	Exception
    //   1740	300	19	localCameraInfo	android.hardware.Camera.CameraInfo
    //   594	544	20	localObject4	Object
    //   1490	18	20	localException8	Exception
    //   2030	1	20	localException9	Exception
    //   501	992	21	arrayOfInt	int[]
    //   584	83	22	localPoint	Point
    // Exception table:
    //   from	to	target	type
    //   41	59	115	java/lang/Exception
    //   59	78	115	java/lang/Exception
    //   157	172	918	java/lang/Exception
    //   959	991	1018	java/lang/Exception
    //   991	1010	1018	java/lang/Exception
    //   200	227	1408	java/lang/Exception
    //   227	257	1408	java/lang/Exception
    //   257	291	1408	java/lang/Exception
    //   304	334	1408	java/lang/Exception
    //   337	381	1408	java/lang/Exception
    //   1071	1078	1408	java/lang/Exception
    //   1083	1093	1408	java/lang/Exception
    //   1096	1105	1408	java/lang/Exception
    //   1137	1151	1408	java/lang/Exception
    //   1156	1163	1408	java/lang/Exception
    //   1175	1211	1408	java/lang/Exception
    //   1223	1260	1408	java/lang/Exception
    //   1296	1319	1408	java/lang/Exception
    //   1344	1396	1408	java/lang/Exception
    //   408	449	1442	java/lang/Exception
    //   566	596	1490	java/lang/Exception
    //   601	611	1490	java/lang/Exception
    //   619	644	1490	java/lang/Exception
    //   653	680	1490	java/lang/Exception
    //   680	699	1490	java/lang/Exception
    //   1653	1673	1937	java/lang/Exception
    //   1678	1699	1937	java/lang/Exception
    //   1727	1753	2005	java/lang/Exception
    //   1753	1781	2005	java/lang/Exception
    //   1816	1843	2005	java/lang/Exception
    //   1843	1854	2005	java/lang/Exception
    //   1979	1983	2005	java/lang/Exception
    //   1986	2002	2005	java/lang/Exception
    //   699	738	2030	java/lang/Exception
  }
  
  private w zf(boolean paramBoolean)
  {
    AppMethodBeat.i(292928);
    w localw = zg(paramBoolean);
    if (localw == null) {}
    for (;;)
    {
      try
      {
        localw = new w((Camera)com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/video/camera/prev/CaptureRender", "safeOpenCamera", "(Z)Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "android/hardware/Camera", "open", "()Landroid/hardware/Camera;"));
        this.UOu = false;
        h.OAn.idkeyStat(159L, 0L, 1L, false);
        g(localw);
        f(localw);
        AppMethodBeat.o(292928);
        return localw;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Voip.CaptureRender", "OpenCameraError:" + localException.toString());
        h.OAn.idkeyStat(159L, 0L, 1L, false);
        h.OAn.idkeyStat(159L, 1L, 1L, false);
        if (this.LpV != null) {
          this.LpV.dre();
        }
        AppMethodBeat.o(292928);
        return null;
      }
      this.UOu = paramBoolean;
      this.LpV.Jd(this.nHi);
    }
  }
  
  private static w zg(boolean paramBoolean)
  {
    localObject2 = null;
    AppMethodBeat.i(292923);
    if (com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP <= 0)
    {
      AppMethodBeat.o(292923);
      return null;
    }
    if (!com.tencent.mm.plugin.voip.video.camera.a.d.icE())
    {
      AppMethodBeat.o(292923);
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
        Log.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + localException.toString());
        Object localObject1 = localObject2;
        continue;
      }
      AppMethodBeat.o(292923);
      return localObject1;
      locala = com.tencent.mm.compatible.deviceinfo.d.G(MMApplicationContext.getContext(), com.tencent.mm.plugin.voip.video.camera.a.d.UOk);
      Log.i("Camera", "Use back");
    }
  }
  
  public final void Jd(int paramInt)
  {
    AppMethodBeat.i(293084);
    this.nHi = paramInt;
    this.LpV.Jd(this.nHi);
    AppMethodBeat.o(293084);
  }
  
  public final int a(com.tencent.mm.plugin.voip.video.camera.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(293033);
    if (com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP <= 0)
    {
      this.UOA = 1;
      AppMethodBeat.o(293033);
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
      AppMethodBeat.o(293033);
      return i;
      if (!com.tencent.mm.plugin.voip.video.camera.a.d.UOi.UOK) {
        paramBoolean = true;
      }
    }
    ggF();
    this.UOA = 0;
    AppMethodBeat.o(293033);
    return 1;
  }
  
  public final void a(ObservableSurfaceView paramObservableSurfaceView)
  {
    AppMethodBeat.i(293007);
    Log.d("MicroMsg.Voip.CaptureRender", "bind ObservableSurfaceView");
    if (paramObservableSurfaceView == null)
    {
      AppMethodBeat.o(293007);
      return;
    }
    this.UOC = paramObservableSurfaceView;
    this.UOC.setSurfaceChangeCallback(this);
    this.LpU = true;
    AppMethodBeat.o(293007);
  }
  
  public final void a(ObservableTextureView paramObservableTextureView)
  {
    AppMethodBeat.i(293015);
    Log.i("MicroMsg.Voip.CaptureRender", "bind ObservableTextureView");
    if (paramObservableTextureView == null)
    {
      AppMethodBeat.o(293015);
      return;
    }
    this.UOD = paramObservableTextureView;
    this.UOD.setTextureChangeCallback(this);
    this.LpU = false;
    AppMethodBeat.o(293015);
  }
  
  public final int boh()
  {
    return this.Lqa;
  }
  
  public final void d(SurfaceHolder paramSurfaceHolder)
  {
    boolean bool1 = false;
    AppMethodBeat.i(293027);
    Log.d("MicroMsg.Voip.CaptureRender", "surfaceChange");
    if ((!this.LpS) || (paramSurfaceHolder.getSurface() == null))
    {
      boolean bool2 = this.LpS;
      if (paramSurfaceHolder.getSurface() == null) {
        bool1 = true;
      }
      Log.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed, CameraOpen: %b, surface: %b, apiLevel: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(293027);
      return;
    }
    try
    {
      if (!this.Abo.lWt) {
        this.Abo.a(null);
      }
      this.Abo.auq();
      this.Abo.a(paramSurfaceHolder);
      ggF();
      this.Abo.aPz();
      this.nvB = true;
    }
    catch (Exception paramSurfaceHolder)
    {
      for (;;)
      {
        h.OAn.idkeyStat(159L, 0L, 1L, false);
        h.OAn.idkeyStat(159L, 2L, 1L, false);
        Log.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + paramSurfaceHolder.getMessage());
        this.UOA = 1;
      }
    }
    if (this.LpX)
    {
      icx();
      this.LpX = false;
    }
    if (!drd()) {
      SubCoreVoip.hVp().aqt(this.UOA);
    }
    AppMethodBeat.o(293027);
  }
  
  public boolean drd()
  {
    return false;
  }
  
  public final void ggH()
  {
    AppMethodBeat.i(293053);
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
        if ((this.Abo != null) && (!this.Abo.lWt))
        {
          this.Abo.a(null);
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
        AppMethodBeat.o(293053);
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
          if (!this.Abo.lWt) {
            this.Abo.a(null);
          }
          this.Abo.release();
          this.Abo = null;
          this.LpS = false;
        }
      }
    }
  }
  
  public final void h(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool1 = false;
    AppMethodBeat.i(293030);
    Log.d("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable");
    if ((!this.LpS) || (paramSurfaceTexture == null))
    {
      boolean bool2 = this.LpS;
      if (paramSurfaceTexture == null) {
        bool1 = true;
      }
      Log.e("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable failed, CameraOpen: %b, surface: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      AppMethodBeat.o(293030);
      return;
    }
    try
    {
      if (!this.Abo.lWt) {
        this.Abo.a(null);
      }
      this.Abo.auq();
      this.Abo.f(paramSurfaceTexture);
      ggF();
      this.Abo.aPz();
      this.nvB = true;
    }
    catch (Exception paramSurfaceTexture)
    {
      for (;;)
      {
        h.OAn.idkeyStat(159L, 0L, 1L, false);
        h.OAn.idkeyStat(159L, 2L, 1L, false);
        Log.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + paramSurfaceTexture.getMessage());
        this.UOA = 1;
      }
    }
    if (this.LpX)
    {
      icx();
      this.LpX = false;
    }
    if (!drd()) {
      SubCoreVoip.hVp().aqt(this.UOA);
    }
    AppMethodBeat.o(293030);
  }
  
  public final boolean icJ()
  {
    return this.UOu;
  }
  
  public final ad icK()
  {
    return this.UOB;
  }
  
  public final boolean icv()
  {
    return this.UOv;
  }
  
  public final int icw()
  {
    return this.UOA;
  }
  
  /* Error */
  public final int icx()
  {
    // Byte code:
    //   0: ldc_w 873
    //   3: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 119	com/tencent/mm/plugin/voip/video/camera/prev/a:LpS	Z
    //   10: ifne +24 -> 34
    //   13: ldc 175
    //   15: ldc_w 875
    //   18: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 117	com/tencent/mm/plugin/voip/video/camera/prev/a:UOA	I
    //   26: ldc_w 873
    //   29: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_m1
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 127	com/tencent/mm/plugin/voip/video/camera/prev/a:LpW	Z
    //   38: ifeq +19 -> 57
    //   41: ldc 175
    //   43: ldc_w 877
    //   46: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: ldc_w 873
    //   52: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_m1
    //   56: ireturn
    //   57: aload_0
    //   58: getfield 125	com/tencent/mm/plugin/voip/video/camera/prev/a:UOC	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   61: ifnull +34 -> 95
    //   64: aload_0
    //   65: getfield 125	com/tencent/mm/plugin/voip/video/camera/prev/a:UOC	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   68: invokevirtual 880	com/tencent/mm/plugin/video/ObservableSurfaceView:hQj	()Z
    //   71: ifne +24 -> 95
    //   74: ldc 175
    //   76: ldc_w 882
    //   79: invokestatic 392	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_0
    //   83: iconst_1
    //   84: putfield 129	com/tencent/mm/plugin/voip/video/camera/prev/a:LpX	Z
    //   87: ldc_w 873
    //   90: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iconst_0
    //   94: ireturn
    //   95: ldc 175
    //   97: ldc_w 884
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_0
    //   107: getfield 123	com/tencent/mm/plugin/voip/video/camera/prev/a:LpU	Z
    //   110: invokestatic 311	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   113: aastore
    //   114: invokestatic 189	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload_0
    //   118: getfield 125	com/tencent/mm/plugin/voip/video/camera/prev/a:UOC	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   121: ifnull +141 -> 262
    //   124: aload_0
    //   125: getfield 123	com/tencent/mm/plugin/voip/video/camera/prev/a:LpU	Z
    //   128: ifeq +134 -> 262
    //   131: aload_0
    //   132: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   135: aload_0
    //   136: getfield 125	com/tencent/mm/plugin/voip/video/camera/prev/a:UOC	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   139: invokevirtual 888	com/tencent/mm/plugin/video/ObservableSurfaceView:getSurfaceHolder	()Landroid/view/SurfaceHolder;
    //   142: invokevirtual 798	com/tencent/mm/compatible/deviceinfo/w:a	(Landroid/view/SurfaceHolder;)V
    //   145: aload_0
    //   146: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   149: invokevirtual 801	com/tencent/mm/compatible/deviceinfo/w:aPz	()V
    //   152: aload_0
    //   153: iconst_1
    //   154: putfield 147	com/tencent/mm/plugin/voip/video/camera/prev/a:nvB	Z
    //   157: aload_0
    //   158: iconst_1
    //   159: putfield 127	com/tencent/mm/plugin/voip/video/camera/prev/a:LpW	Z
    //   162: aload_0
    //   163: getfield 851	com/tencent/mm/plugin/voip/video/camera/prev/a:Lwy	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   166: ifnonnull +15 -> 181
    //   169: aload_0
    //   170: new 853	com/tencent/mm/plugin/voip/video/camera/a/b
    //   173: dup
    //   174: aload_0
    //   175: invokespecial 891	com/tencent/mm/plugin/voip/video/camera/a/b:<init>	(Lcom/tencent/mm/plugin/voip/video/camera/a/b$a;)V
    //   178: putfield 851	com/tencent/mm/plugin/voip/video/camera/prev/a:Lwy	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   181: aload_0
    //   182: getfield 577	com/tencent/mm/plugin/voip/video/camera/prev/a:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   185: aload_0
    //   186: getfield 714	com/tencent/mm/plugin/voip/video/camera/prev/a:nHi	I
    //   189: invokeinterface 717 2 0
    //   194: ldc_w 873
    //   197: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: iconst_1
    //   201: ireturn
    //   202: astore_1
    //   203: getstatic 275	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   206: ldc2_w 276
    //   209: lconst_0
    //   210: lconst_1
    //   211: iconst_0
    //   212: invokevirtual 281	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   215: getstatic 275	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   218: ldc2_w 276
    //   221: ldc2_w 819
    //   224: lconst_1
    //   225: iconst_0
    //   226: invokevirtual 281	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   229: aload_0
    //   230: iconst_1
    //   231: putfield 117	com/tencent/mm/plugin/voip/video/camera/prev/a:UOA	I
    //   234: ldc 175
    //   236: new 283	java/lang/StringBuilder
    //   239: dup
    //   240: ldc_w 893
    //   243: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: aload_1
    //   247: invokevirtual 291	java/lang/Exception:toString	()Ljava/lang/String;
    //   250: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: goto -114 -> 145
    //   262: aload_0
    //   263: getfield 772	com/tencent/mm/plugin/voip/video/camera/prev/a:UOD	Lcom/tencent/mm/plugin/video/ObservableTextureView;
    //   266: ifnull -121 -> 145
    //   269: aload_0
    //   270: getfield 123	com/tencent/mm/plugin/voip/video/camera/prev/a:LpU	Z
    //   273: ifne -128 -> 145
    //   276: aload_0
    //   277: getfield 427	com/tencent/mm/plugin/voip/video/camera/prev/a:Abo	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   280: aload_0
    //   281: getfield 772	com/tencent/mm/plugin/voip/video/camera/prev/a:UOD	Lcom/tencent/mm/plugin/video/ObservableTextureView;
    //   284: invokevirtual 897	com/tencent/mm/plugin/video/ObservableTextureView:getSurfaceTexture	()Landroid/graphics/SurfaceTexture;
    //   287: invokevirtual 867	com/tencent/mm/compatible/deviceinfo/w:f	(Landroid/graphics/SurfaceTexture;)V
    //   290: goto -145 -> 145
    //   293: astore_1
    //   294: getstatic 275	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   297: ldc2_w 276
    //   300: lconst_0
    //   301: lconst_1
    //   302: iconst_0
    //   303: invokevirtual 281	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   306: getstatic 275	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   309: ldc2_w 276
    //   312: ldc2_w 819
    //   315: lconst_1
    //   316: iconst_0
    //   317: invokevirtual 281	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   320: aload_0
    //   321: iconst_1
    //   322: putfield 117	com/tencent/mm/plugin/voip/video/camera/prev/a:UOA	I
    //   325: ldc 175
    //   327: new 283	java/lang/StringBuilder
    //   330: dup
    //   331: ldc_w 893
    //   334: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   337: aload_1
    //   338: invokevirtual 291	java/lang/Exception:toString	()Ljava/lang/String;
    //   341: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: goto -205 -> 145
    //   353: astore_1
    //   354: getstatic 275	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   357: ldc2_w 276
    //   360: lconst_0
    //   361: lconst_1
    //   362: iconst_0
    //   363: invokevirtual 281	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   366: getstatic 275	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   369: ldc2_w 276
    //   372: ldc2_w 819
    //   375: lconst_1
    //   376: iconst_0
    //   377: invokevirtual 281	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   380: aload_0
    //   381: iconst_1
    //   382: putfield 117	com/tencent/mm/plugin/voip/video/camera/prev/a:UOA	I
    //   385: aload_0
    //   386: getfield 577	com/tencent/mm/plugin/voip/video/camera/prev/a:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   389: ifnull +12 -> 401
    //   392: aload_0
    //   393: getfield 577	com/tencent/mm/plugin/voip/video/camera/prev/a:LpV	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   396: invokeinterface 582 1 0
    //   401: ldc 175
    //   403: new 283	java/lang/StringBuilder
    //   406: dup
    //   407: ldc_w 899
    //   410: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   413: aload_1
    //   414: invokevirtual 291	java/lang/Exception:toString	()Ljava/lang/String;
    //   417: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 299	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   426: goto -269 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	this	a
    //   202	45	1	localException1	Exception
    //   293	45	1	localException2	Exception
    //   353	61	1	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   131	145	202	java/lang/Exception
    //   276	290	293	java/lang/Exception
    //   145	157	353	java/lang/Exception
  }
  
  public final void icy()
  {
    AppMethodBeat.i(293038);
    if (com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP < 2)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + com.tencent.mm.plugin.voip.video.camera.a.d.UOi.lSP);
      AppMethodBeat.o(293038);
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
      if (!drd()) {
        SubCoreVoip.hVp().aqt(this.UOA);
      }
      this.nGD = true;
      AppMethodBeat.o(293038);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.prev.a
 * JD-Core Version:    0.7.0.1
 */