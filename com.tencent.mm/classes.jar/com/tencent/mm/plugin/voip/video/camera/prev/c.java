package com.tencent.mm.plugin.voip.video.camera.prev;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.f.a.qj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.c.g;
import com.tencent.mm.plugin.voip.c.j;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.a.a;
import com.tencent.mm.plugin.voip.video.camera.a.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class c
  extends a
  implements b.a
{
  private static final Pattern FtM;
  private static int lgv;
  private static int lgw;
  com.tencent.mm.plugin.voip.video.camera.a.b FAu;
  protected boolean FtA;
  protected com.tencent.mm.plugin.voip.video.camera.a.c FtB;
  public boolean FtC;
  protected boolean FtD;
  protected byte[] FtE;
  protected List<byte[]> FtF;
  private int FtG;
  protected int FtH;
  protected int FtI;
  protected boolean FtJ;
  private byte[] FtK;
  Camera.PreviewCallback FtL;
  protected long Ftt;
  protected Camera.Parameters Ftv;
  protected int Ftx;
  protected boolean Fty;
  protected boolean Ftz;
  protected boolean OaA;
  protected boolean OaB;
  protected long OaC;
  protected int OaD;
  protected ad OaE;
  protected int[] OaH;
  protected int OaI;
  private int OaS;
  protected boolean Oax;
  protected boolean Oay;
  protected boolean Oaz;
  protected boolean lbz;
  private int lcs;
  protected int mHeight;
  SurfaceTexture mSurfaceTexture;
  protected int mWidth;
  protected volatile w wFd;
  protected boolean wFf;
  
  static
  {
    AppMethodBeat.i(234360);
    FtM = Pattern.compile(",");
    lgv = 20;
    lgw = 70;
    AppMethodBeat.o(234360);
  }
  
  public c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234289);
    this.OaS = 0;
    this.Oax = true;
    this.Oay = false;
    this.FtG = 0;
    this.Oaz = false;
    this.OaA = false;
    this.OaB = false;
    this.OaC = 0L;
    this.Ftt = 30000L;
    this.OaD = 0;
    this.Fty = false;
    this.Ftz = false;
    this.FtA = false;
    this.FtC = false;
    this.FtD = false;
    this.FtE = null;
    this.OaH = null;
    this.mWidth = 320;
    this.mHeight = 240;
    this.lbz = true;
    this.FtH = 0;
    this.FtI = 0;
    this.OaI = 0;
    this.wFf = false;
    this.FtJ = false;
    this.FtK = null;
    this.FtL = new Camera.PreviewCallback()
    {
      public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(239024);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          h.IzE.idkeyStat(159L, 0L, 1L, false);
          h.IzE.idkeyStat(159L, 3L, 1L, false);
          if (c.this.FtB != null) {
            c.this.FtB.cNy();
          }
          AppMethodBeat.o(239024);
          return;
        }
        if (c.this.OaE == null)
        {
          Log.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
          AppMethodBeat.o(239024);
          return;
        }
        int m;
        int i;
        int k;
        int j;
        if (c.this.FtB != null)
        {
          if ((c.a(c.this) == null) || (c.a(c.this).length != paramAnonymousArrayOfByte.length)) {
            c.a(c.this, new byte[paramAnonymousArrayOfByte.length]);
          }
          System.arraycopy(paramAnonymousArrayOfByte, 0, c.a(c.this), 0, paramAnonymousArrayOfByte.length);
          m = 1;
          if (c.this.Oax)
          {
            i = com.tencent.mm.plugin.voip.video.camera.a.d.Oao;
            k = i;
            if (!af.juH.jpP) {
              break label619;
            }
            k = i;
            if (af.juH.jpO.fSM == 0) {
              break label619;
            }
            j = af.juH.jpO.jqB;
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
            paramAnonymousCamera = c.this;
            if ((i != 0) || (k <= 0)) {
              break label526;
            }
            bool = true;
            label241:
            paramAnonymousCamera.Oay = bool;
            if (c.b(c.this) != 90) {
              c.this.Oay = false;
            }
            k = c.this.OaE.width;
            int n = c.this.OaE.height;
            if (i == 0) {
              break label532;
            }
            if (c.this.FtE == null)
            {
              i = k * n * 3 / 2;
              c.this.FtE = new byte[i];
              c.this.FtE[0] = 90;
            }
            com.tencent.mm.plugin.voip.c.gxs().a(c.a(c.this), c.a(c.this).length, k, n, c.this.Ftx, c.this.FtE, c.this.FtE.length, k, n, j);
            c.this.FtB.a(c.this.FtE, c.this.FtE.length, k, n, c.this.Ftx, m);
          }
          for (;;)
          {
            if (m.getApiLevel() >= 8)
            {
              if (c.this.wFd == null)
              {
                Log.e("MicroMsg.Voip.CaptureRender", "the camera is null and has been release");
                AppMethodBeat.o(239024);
                return;
                j = com.tencent.mm.plugin.voip.video.camera.a.d.Oap;
                k = j;
                if (!af.juH.jpR) {
                  break label619;
                }
                k = j;
                if (af.juH.jpQ.fSM == 0) {
                  break label619;
                }
                m = af.juH.jpQ.jqB;
                i = 1;
                k = j;
                j = m;
                break;
                m = 0;
                break label224;
                label526:
                bool = false;
                break label241;
                label532:
                c.this.FtB.a(c.a(c.this), c.a(c.this).length, c.this.OaE.width, c.this.OaE.height, c.this.Ftx, m);
                continue;
              }
              if (c.this.wFd != null) {
                c.this.wFd.aj(paramAnonymousArrayOfByte);
              }
            }
          }
          AppMethodBeat.o(239024);
          return;
          label619:
          i = 0;
          j = m;
        }
      }
    };
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    com.tencent.mm.plugin.voip.video.camera.a.d.iL(MMApplicationContext.getContext().getApplicationContext());
    Log.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
    AppMethodBeat.o(234289);
  }
  
  private static Point a(CharSequence paramCharSequence, Point paramPoint)
  {
    AppMethodBeat.i(234311);
    int i1 = 2147483647;
    paramCharSequence = FtM.split(paramCharSequence);
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
        AppMethodBeat.o(234311);
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
      AppMethodBeat.o(234311);
      return null;
      label274:
      k = j;
      int n = i;
    }
  }
  
  private boolean a(w paramw, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234307);
    if (paramw == null)
    {
      AppMethodBeat.o(234307);
      return false;
    }
    try
    {
      Camera.Parameters localParameters = paramw.avd();
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        localParameters.setPreviewSize(paramInt1, paramInt2);
      }
      paramw.c(localParameters);
      this.FtB.fP(paramInt1, paramInt2);
      AppMethodBeat.o(234307);
      return true;
    }
    catch (Exception paramw)
    {
      h.IzE.idkeyStat(159L, 0L, 1L, false);
      Log.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + paramw.toString());
      AppMethodBeat.o(234307);
    }
    return false;
  }
  
  private boolean b(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(234309);
    if (paramw == null)
    {
      AppMethodBeat.o(234309);
      return false;
    }
    Camera.Parameters localParameters;
    List localList;
    try
    {
      Log.i("MicroMsg.Voip.CaptureRender", "trySetAutoFocus, isFrontCamera:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      localParameters = paramw.avd();
      localList = localParameters.getSupportedFocusModes();
      if (localList == null) {
        break label224;
      }
      Log.i("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        Log.i("MicroMsg.Voip.CaptureRender", "supported focus modes : ".concat(String.valueOf((String)localIterator.next())));
      }
      if (af.juH.jqr != 0) {
        break label268;
      }
    }
    catch (Exception paramw)
    {
      h.IzE.idkeyStat(159L, 0L, 1L, false);
      Log.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + paramw.toString());
      AppMethodBeat.o(234309);
      return false;
    }
    if (paramBoolean) {
      if (localList.contains("auto"))
      {
        Log.i("MicroMsg.Voip.CaptureRender", "camera support auto focus");
        localParameters.setFocusMode("auto");
        this.Ftz = false;
      }
    }
    for (;;)
    {
      paramw.c(localParameters);
      label224:
      AppMethodBeat.o(234309);
      return true;
      if (localList.contains("continuous-video"))
      {
        Log.i("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
        localParameters.setFocusMode("continuous-video");
        this.Ftz = true;
        continue;
        label268:
        if ((af.juH.jqr == 1) || (!paramBoolean)) {
          if (localList.contains("continuous-video"))
          {
            Log.i("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
            localParameters.setFocusMode("continuous-video");
            this.Ftz = true;
          }
          else if (localList.contains("auto"))
          {
            Log.i("MicroMsg.Voip.CaptureRender", "camera support auto focus");
            localParameters.setFocusMode("auto");
            this.Ftz = false;
          }
        }
      }
    }
  }
  
  private int f(w paramw)
  {
    AppMethodBeat.i(234349);
    if (paramw == null)
    {
      AppMethodBeat.o(234349);
      return 0;
    }
    for (;;)
    {
      try
      {
        localObject = paramw.avd().getSupportedPreviewSizes();
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
            this.FtH = localSize.width;
            this.FtI = localSize.height;
          }
          i += 1;
          continue;
        }
        try
        {
          paramw = paramw.avd().getSupportedPreviewFormats();
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
      AppMethodBeat.o(234349);
      return i;
    }
  }
  
  private static void h(w paramw)
  {
    AppMethodBeat.i(234353);
    try
    {
      localList = paramw.avd().getSupportedPreviewFrameRates();
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
      AppMethodBeat.o(234353);
    }
  }
  
  private void i(w paramw)
  {
    AppMethodBeat.i(234326);
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i;
    label70:
    label97:
    int k;
    int j;
    if (this.Oax)
    {
      i = com.tencent.mm.plugin.voip.video.camera.a.d.Oam;
      Camera.getCameraInfo(i, localCameraInfo);
      switch (this.OaS)
      {
      default: 
        i = 0;
        if (this.Oax)
        {
          i = (360 - (i + localCameraInfo.orientation) % 360) % 360;
          paramw.qO(i);
          this.FtG = i;
          Log.i("MicroMsg.Voip.CaptureRender", "mIsCurrentFaceCamera is %s, %s,%s,%s,%s", new Object[] { Integer.valueOf(this.OaS), Integer.valueOf(localCameraInfo.orientation), Integer.valueOf(i), Boolean.valueOf(this.Oax), Integer.valueOf(this.FtG) });
          if (!this.Oax) {
            break label304;
          }
          k = com.tencent.mm.plugin.voip.video.camera.a.d.Oao;
          i = k;
          if (!af.juH.jpP) {
            break label350;
          }
          i = k;
          if (af.juH.jpO.fSM == 0) {
            break label350;
          }
          j = 1;
          i = k;
        }
        break;
      }
    }
    for (;;)
    {
      label211:
      if ((j == 0) && (i > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        this.Oay = bool;
        if ((this.FtG != 90) && (j != 0)) {
          this.Oay = false;
        }
        AppMethodBeat.o(234326);
        return;
        i = com.tencent.mm.plugin.voip.video.camera.a.d.Oan;
        break;
        i = 0;
        break label70;
        i = 90;
        break label70;
        i = 180;
        break label70;
        i = 270;
        break label70;
        i = (localCameraInfo.orientation - i + 360) % 360;
        break label97;
        label304:
        j = com.tencent.mm.plugin.voip.video.camera.a.d.Oap;
        i = j;
        if (!af.juH.jpR) {
          break label350;
        }
        i = j;
        if (af.juH.jpQ.fSM == 0) {
          break label350;
        }
        k = 1;
        i = j;
        j = k;
        break label211;
      }
      label350:
      j = 0;
    }
  }
  
  /* Error */
  private int l(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 481
    //   3: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 172
    //   8: ldc_w 483
    //   11: iload_1
    //   12: invokestatic 486	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   15: invokevirtual 217	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 120	com/tencent/mm/plugin/voip/video/camera/prev/c:Ftz	Z
    //   26: iconst_1
    //   27: istore 17
    //   29: iload 17
    //   31: istore 16
    //   33: aload_0
    //   34: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   37: ifnull +52 -> 89
    //   40: aload_0
    //   41: getfield 98	com/tencent/mm/plugin/voip/video/camera/prev/c:Oax	Z
    //   44: iload_1
    //   45: if_icmpeq +78 -> 123
    //   48: aload_0
    //   49: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   52: getfield 491	com/tencent/mm/compatible/deviceinfo/w:jtb	Z
    //   55: ifne +11 -> 66
    //   58: aload_0
    //   59: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   62: aconst_null
    //   63: invokevirtual 494	com/tencent/mm/compatible/deviceinfo/w:a	(Landroid/hardware/Camera$PreviewCallback;)V
    //   66: aload_0
    //   67: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   70: invokevirtual 497	com/tencent/mm/compatible/deviceinfo/w:TL	()V
    //   73: aload_0
    //   74: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   77: invokevirtual 500	com/tencent/mm/compatible/deviceinfo/w:release	()V
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   85: iload 17
    //   87: istore 16
    //   89: iload 16
    //   91: ifeq +46 -> 137
    //   94: aload_0
    //   95: aload_0
    //   96: iload_1
    //   97: invokespecial 504	com/tencent/mm/plugin/voip/video/camera/prev/c:uR	(Z)Lcom/tencent/mm/compatible/deviceinfo/w;
    //   100: putfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   103: aload_0
    //   104: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   107: ifnonnull +25 -> 132
    //   110: aload_0
    //   111: iconst_0
    //   112: putfield 118	com/tencent/mm/plugin/voip/video/camera/prev/c:Fty	Z
    //   115: ldc_w 481
    //   118: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iconst_m1
    //   122: ireturn
    //   123: aload_0
    //   124: getfield 146	com/tencent/mm/plugin/voip/video/camera/prev/c:FtJ	Z
    //   127: istore 16
    //   129: goto -40 -> 89
    //   132: aload_0
    //   133: iconst_0
    //   134: putfield 146	com/tencent/mm/plugin/voip/video/camera/prev/c:FtJ	Z
    //   137: aload_0
    //   138: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   141: ifnull +11 -> 152
    //   144: aload_0
    //   145: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   148: invokevirtual 259	com/tencent/mm/compatible/deviceinfo/w:avd	()Landroid/hardware/Camera$Parameters;
    //   151: pop
    //   152: aload_0
    //   153: iconst_1
    //   154: putfield 118	com/tencent/mm/plugin/voip/video/camera/prev/c:Fty	Z
    //   157: aload_0
    //   158: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   161: astore 18
    //   163: getstatic 508	com/tencent/mm/plugin/voip/video/camera/a/d:Oal	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   166: getfield 513	com/tencent/mm/plugin/voip/video/camera/prev/b:OaL	I
    //   169: istore 11
    //   171: aload 18
    //   173: ifnull +255 -> 428
    //   176: bipush 26
    //   178: istore 4
    //   180: ldc 172
    //   182: ldc_w 515
    //   185: iconst_1
    //   186: anewarray 176	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: iload 11
    //   193: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: aastore
    //   197: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload 18
    //   202: invokevirtual 259	com/tencent/mm/compatible/deviceinfo/w:avd	()Landroid/hardware/Camera$Parameters;
    //   205: astore 19
    //   207: invokestatic 518	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   210: ifeq +27 -> 237
    //   213: ldc_w 520
    //   216: invokestatic 526	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   219: checkcast 520	com/tencent/mm/plugin/zero/b/a
    //   222: invokeinterface 530 1 0
    //   227: ldc_w 532
    //   230: bipush 26
    //   232: invokevirtual 535	com/tencent/mm/n/f:getInt	(Ljava/lang/String;I)I
    //   235: istore 4
    //   237: ldc 172
    //   239: ldc_w 537
    //   242: iconst_1
    //   243: anewarray 176	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: iload 4
    //   250: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: aastore
    //   254: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: invokestatic 542	com/tencent/mm/compatible/util/k:are	()Z
    //   260: ifne +11 -> 271
    //   263: iload 4
    //   265: invokestatic 548	com/tencent/mm/compatible/util/d:qV	(I)Z
    //   268: ifeq +1116 -> 1384
    //   271: ldc 194
    //   273: istore 6
    //   275: iconst_0
    //   276: istore_1
    //   277: iconst_m1
    //   278: istore 8
    //   280: iconst_0
    //   281: istore 7
    //   283: getstatic 361	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   286: ifnull +1640 -> 1926
    //   289: getstatic 361	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   292: getfield 551	com/tencent/mm/compatible/deviceinfo/c:jqw	I
    //   295: sipush 1000
    //   298: imul
    //   299: istore 8
    //   301: getstatic 361	com/tencent/mm/compatible/deviceinfo/af:juH	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   304: getfield 554	com/tencent/mm/compatible/deviceinfo/c:jqx	I
    //   307: sipush 1000
    //   310: imul
    //   311: istore 7
    //   313: goto +1613 -> 1926
    //   316: ldc 172
    //   318: ldc_w 556
    //   321: iconst_4
    //   322: anewarray 176	java/lang/Object
    //   325: dup
    //   326: iconst_0
    //   327: iload 8
    //   329: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   332: aastore
    //   333: dup
    //   334: iconst_1
    //   335: iload 7
    //   337: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: aastore
    //   341: dup
    //   342: iconst_2
    //   343: iload 11
    //   345: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: aastore
    //   349: dup
    //   350: iconst_3
    //   351: iload 16
    //   353: invokestatic 318	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   356: aastore
    //   357: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: iload 8
    //   362: ldc 194
    //   364: if_icmpeq +15 -> 379
    //   367: iload 7
    //   369: ldc 194
    //   371: if_icmpeq +8 -> 379
    //   374: iload 16
    //   376: ifne +950 -> 1326
    //   379: iconst_1
    //   380: istore 4
    //   382: iload 4
    //   384: ifeq +44 -> 428
    //   387: ldc 172
    //   389: ldc_w 558
    //   392: iconst_1
    //   393: anewarray 176	java/lang/Object
    //   396: dup
    //   397: iconst_0
    //   398: iload 11
    //   400: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: aastore
    //   404: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: aload 18
    //   409: invokevirtual 259	com/tencent/mm/compatible/deviceinfo/w:avd	()Landroid/hardware/Camera$Parameters;
    //   412: astore 19
    //   414: aload 19
    //   416: iload 11
    //   418: invokevirtual 561	android/hardware/Camera$Parameters:setPreviewFrameRate	(I)V
    //   421: aload 18
    //   423: aload 19
    //   425: invokevirtual 268	com/tencent/mm/compatible/deviceinfo/w:c	(Landroid/hardware/Camera$Parameters;)V
    //   428: ldc 172
    //   430: new 289	java/lang/StringBuilder
    //   433: dup
    //   434: ldc_w 563
    //   437: invokespecial 294	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   440: iload_2
    //   441: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: ldc 73
    //   446: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: iload_3
    //   450: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   453: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: aload_0
    //   460: getfield 98	com/tencent/mm/plugin/voip/video/camera/prev/c:Oax	Z
    //   463: ifeq +992 -> 1455
    //   466: getstatic 508	com/tencent/mm/plugin/voip/video/camera/a/d:Oal	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   469: getfield 567	com/tencent/mm/plugin/voip/video/camera/prev/b:OaQ	Landroid/graphics/Point;
    //   472: astore 18
    //   474: aload 18
    //   476: ifnull +990 -> 1466
    //   479: iconst_1
    //   480: istore 4
    //   482: aconst_null
    //   483: astore 21
    //   485: aload 18
    //   487: ifnull +1418 -> 1905
    //   490: new 569	com/tencent/mm/compatible/deviceinfo/ad
    //   493: dup
    //   494: aload 18
    //   496: getfield 239	android/graphics/Point:x	I
    //   499: aload 18
    //   501: getfield 247	android/graphics/Point:y	I
    //   504: invokespecial 570	com/tencent/mm/compatible/deviceinfo/ad:<init>	(II)V
    //   507: astore 19
    //   509: ldc 172
    //   511: new 289	java/lang/StringBuilder
    //   514: dup
    //   515: ldc_w 572
    //   518: invokespecial 294	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   521: aload 19
    //   523: getfield 573	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   526: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   529: ldc 73
    //   531: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload 19
    //   536: getfield 574	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   539: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   542: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: aload_0
    //   549: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   552: invokevirtual 259	com/tencent/mm/compatible/deviceinfo/w:avd	()Landroid/hardware/Camera$Parameters;
    //   555: astore 18
    //   557: new 236	android/graphics/Point
    //   560: dup
    //   561: iload_2
    //   562: iload_3
    //   563: invokespecial 249	android/graphics/Point:<init>	(II)V
    //   566: astore 22
    //   568: aload 18
    //   570: ldc_w 576
    //   573: invokevirtual 578	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   576: astore 20
    //   578: aload 20
    //   580: ifnonnull +1322 -> 1902
    //   583: aload 18
    //   585: ldc_w 580
    //   588: invokevirtual 578	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   591: astore 20
    //   593: aconst_null
    //   594: astore 18
    //   596: aload 20
    //   598: ifnull +28 -> 626
    //   601: ldc 172
    //   603: ldc_w 582
    //   606: aload 20
    //   608: invokestatic 213	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   611: invokevirtual 217	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   614: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   617: aload 20
    //   619: aload 22
    //   621: invokestatic 584	com/tencent/mm/plugin/voip/video/camera/prev/c:a	(Ljava/lang/CharSequence;Landroid/graphics/Point;)Landroid/graphics/Point;
    //   624: astore 18
    //   626: aload 18
    //   628: astore 20
    //   630: aload 18
    //   632: ifnonnull +30 -> 662
    //   635: new 236	android/graphics/Point
    //   638: dup
    //   639: aload 22
    //   641: getfield 239	android/graphics/Point:x	I
    //   644: iconst_3
    //   645: ishr
    //   646: iconst_3
    //   647: ishl
    //   648: aload 22
    //   650: getfield 247	android/graphics/Point:y	I
    //   653: iconst_3
    //   654: ishr
    //   655: iconst_3
    //   656: ishl
    //   657: invokespecial 249	android/graphics/Point:<init>	(II)V
    //   660: astore 20
    //   662: new 569	com/tencent/mm/compatible/deviceinfo/ad
    //   665: dup
    //   666: aload 20
    //   668: getfield 239	android/graphics/Point:x	I
    //   671: aload 20
    //   673: getfield 247	android/graphics/Point:y	I
    //   676: invokespecial 570	com/tencent/mm/compatible/deviceinfo/ad:<init>	(II)V
    //   679: astore 18
    //   681: ldc 172
    //   683: new 289	java/lang/StringBuilder
    //   686: dup
    //   687: ldc_w 586
    //   690: invokespecial 294	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   693: aload 18
    //   695: getfield 573	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   698: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   701: ldc 73
    //   703: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload 18
    //   708: getfield 574	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   711: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   714: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: iload 4
    //   722: ifeq +779 -> 1501
    //   725: aload_0
    //   726: aload_0
    //   727: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   730: aload 19
    //   732: getfield 573	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   735: aload 19
    //   737: getfield 574	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   740: invokespecial 588	com/tencent/mm/plugin/voip/video/camera/prev/c:a	(Lcom/tencent/mm/compatible/deviceinfo/w;II)Z
    //   743: istore_1
    //   744: ldc 172
    //   746: new 289	java/lang/StringBuilder
    //   749: dup
    //   750: ldc_w 590
    //   753: invokespecial 294	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   756: aload 19
    //   758: getfield 573	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   761: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   764: ldc_w 592
    //   767: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: aload 19
    //   772: getfield 574	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   775: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   778: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   784: iload_1
    //   785: ifne +838 -> 1623
    //   788: aload 18
    //   790: ifnull +833 -> 1623
    //   793: ldc 172
    //   795: new 289	java/lang/StringBuilder
    //   798: dup
    //   799: ldc_w 594
    //   802: invokespecial 294	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   805: aload 18
    //   807: getfield 573	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   810: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   813: ldc_w 592
    //   816: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: aload 18
    //   821: getfield 574	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   824: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   827: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   833: aload_0
    //   834: aload_0
    //   835: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   838: aload 18
    //   840: getfield 573	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   843: aload 18
    //   845: getfield 574	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   848: invokespecial 588	com/tencent/mm/plugin/voip/video/camera/prev/c:a	(Lcom/tencent/mm/compatible/deviceinfo/w;II)Z
    //   851: ifne +772 -> 1623
    //   854: ldc 172
    //   856: new 289	java/lang/StringBuilder
    //   859: dup
    //   860: ldc_w 596
    //   863: invokespecial 294	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   866: aload 18
    //   868: getfield 573	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   871: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   874: ldc_w 592
    //   877: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: aload 18
    //   882: getfield 574	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   885: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   888: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   891: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   894: ldc_w 481
    //   897: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   900: iconst_m1
    //   901: ireturn
    //   902: astore 18
    //   904: getstatic 281	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   907: ldc2_w 282
    //   910: lconst_0
    //   911: lconst_1
    //   912: iconst_0
    //   913: invokevirtual 287	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   916: ldc 172
    //   918: ldc_w 598
    //   921: iconst_1
    //   922: anewarray 176	java/lang/Object
    //   925: dup
    //   926: iconst_0
    //   927: aload 18
    //   929: invokevirtual 601	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   932: aastore
    //   933: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   936: aload_0
    //   937: getfield 270	com/tencent/mm/plugin/voip/video/camera/prev/c:FtB	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   940: ifnull +54 -> 994
    //   943: aload_0
    //   944: getfield 270	com/tencent/mm/plugin/voip/video/camera/prev/c:FtB	Lcom/tencent/mm/plugin/voip/video/camera/a/c;
    //   947: invokeinterface 606 1 0
    //   952: aload_0
    //   953: iconst_1
    //   954: putfield 146	com/tencent/mm/plugin/voip/video/camera/prev/c:FtJ	Z
    //   957: aload_0
    //   958: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   961: getfield 491	com/tencent/mm/compatible/deviceinfo/w:jtb	Z
    //   964: ifne +11 -> 975
    //   967: aload_0
    //   968: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   971: aconst_null
    //   972: invokevirtual 494	com/tencent/mm/compatible/deviceinfo/w:a	(Landroid/hardware/Camera$PreviewCallback;)V
    //   975: aload_0
    //   976: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   979: invokevirtual 497	com/tencent/mm/compatible/deviceinfo/w:TL	()V
    //   982: aload_0
    //   983: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   986: invokevirtual 500	com/tencent/mm/compatible/deviceinfo/w:release	()V
    //   989: aload_0
    //   990: aconst_null
    //   991: putfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   994: ldc_w 481
    //   997: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1000: iconst_m1
    //   1001: ireturn
    //   1002: astore 19
    //   1004: ldc 172
    //   1006: aload 19
    //   1008: ldc_w 608
    //   1011: iconst_1
    //   1012: anewarray 176	java/lang/Object
    //   1015: dup
    //   1016: iconst_0
    //   1017: aload 18
    //   1019: invokevirtual 601	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1022: aastore
    //   1023: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1026: goto -32 -> 994
    //   1029: iload 8
    //   1031: ifne +24 -> 1055
    //   1034: iload 7
    //   1036: ifne +19 -> 1055
    //   1039: iconst_0
    //   1040: istore 16
    //   1042: ldc_w 609
    //   1045: istore 7
    //   1047: ldc_w 609
    //   1050: istore 8
    //   1052: goto -736 -> 316
    //   1055: aload 19
    //   1057: invokevirtual 612	android/hardware/Camera$Parameters:getSupportedPreviewFpsRange	()Ljava/util/List;
    //   1060: astore 20
    //   1062: aload 20
    //   1064: ifnull +885 -> 1949
    //   1067: aload 20
    //   1069: invokeinterface 332 1 0
    //   1074: ifne +6 -> 1080
    //   1077: goto +872 -> 1949
    //   1080: aload 20
    //   1082: invokeinterface 332 1 0
    //   1087: istore 12
    //   1089: iconst_0
    //   1090: istore 9
    //   1092: ldc_w 609
    //   1095: istore 5
    //   1097: ldc_w 609
    //   1100: istore 4
    //   1102: iload_1
    //   1103: istore 16
    //   1105: iload 5
    //   1107: istore 7
    //   1109: iload 4
    //   1111: istore 8
    //   1113: iload 9
    //   1115: iload 12
    //   1117: if_icmpge -801 -> 316
    //   1120: aload 20
    //   1122: iload 9
    //   1124: invokeinterface 427 2 0
    //   1129: checkcast 613	[I
    //   1132: astore 21
    //   1134: aload 21
    //   1136: ifnull +775 -> 1911
    //   1139: aload 21
    //   1141: arraylength
    //   1142: iconst_1
    //   1143: if_icmple +768 -> 1911
    //   1146: aload 21
    //   1148: iconst_0
    //   1149: iaload
    //   1150: istore 8
    //   1152: aload 21
    //   1154: iconst_1
    //   1155: iaload
    //   1156: istore 10
    //   1158: ldc 172
    //   1160: ldc_w 615
    //   1163: iconst_3
    //   1164: anewarray 176	java/lang/Object
    //   1167: dup
    //   1168: iconst_0
    //   1169: iload 9
    //   1171: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1174: aastore
    //   1175: dup
    //   1176: iconst_1
    //   1177: iload 8
    //   1179: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1182: aastore
    //   1183: dup
    //   1184: iconst_2
    //   1185: iload 10
    //   1187: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1190: aastore
    //   1191: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1194: iload 8
    //   1196: iflt +715 -> 1911
    //   1199: iload 10
    //   1201: iload 8
    //   1203: if_icmplt +708 -> 1911
    //   1206: iload 10
    //   1208: sipush 1000
    //   1211: idiv
    //   1212: istore 13
    //   1214: iload 8
    //   1216: sipush 1000
    //   1219: idiv
    //   1220: istore 14
    //   1222: iload 11
    //   1224: iconst_5
    //   1225: iadd
    //   1226: bipush 30
    //   1228: invokestatic 619	java/lang/Math:min	(II)I
    //   1231: istore 7
    //   1233: iload 11
    //   1235: iconst_5
    //   1236: isub
    //   1237: iconst_5
    //   1238: invokestatic 622	java/lang/Math:max	(II)I
    //   1241: istore 15
    //   1243: iload 13
    //   1245: iload 15
    //   1247: if_icmplt +729 -> 1976
    //   1250: iload 13
    //   1252: iload 7
    //   1254: if_icmpgt +722 -> 1976
    //   1257: iload 14
    //   1259: iload 15
    //   1261: if_icmplt +715 -> 1976
    //   1264: iload 14
    //   1266: iload 7
    //   1268: if_icmpgt +708 -> 1976
    //   1271: iconst_1
    //   1272: istore 7
    //   1274: iload 7
    //   1276: ifeq +635 -> 1911
    //   1279: iload 11
    //   1281: iload 14
    //   1283: isub
    //   1284: invokestatic 244	java/lang/Math:abs	(I)I
    //   1287: istore 7
    //   1289: iload 13
    //   1291: iload 11
    //   1293: isub
    //   1294: invokestatic 244	java/lang/Math:abs	(I)I
    //   1297: iload 7
    //   1299: iadd
    //   1300: istore 7
    //   1302: iload 7
    //   1304: iload 6
    //   1306: if_icmpge +605 -> 1911
    //   1309: iconst_1
    //   1310: istore_1
    //   1311: iload 7
    //   1313: istore 4
    //   1315: iload 10
    //   1317: istore 5
    //   1319: iload 8
    //   1321: istore 6
    //   1323: goto +632 -> 1955
    //   1326: ldc 172
    //   1328: ldc_w 624
    //   1331: iconst_3
    //   1332: anewarray 176	java/lang/Object
    //   1335: dup
    //   1336: iconst_0
    //   1337: iload 8
    //   1339: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1342: aastore
    //   1343: dup
    //   1344: iconst_1
    //   1345: iload 7
    //   1347: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1350: aastore
    //   1351: dup
    //   1352: iconst_2
    //   1353: iload 11
    //   1355: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1358: aastore
    //   1359: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1362: aload 19
    //   1364: iload 8
    //   1366: iload 7
    //   1368: invokevirtual 627	android/hardware/Camera$Parameters:setPreviewFpsRange	(II)V
    //   1371: aload 18
    //   1373: aload 19
    //   1375: invokevirtual 268	com/tencent/mm/compatible/deviceinfo/w:c	(Landroid/hardware/Camera$Parameters;)V
    //   1378: iconst_0
    //   1379: istore 4
    //   1381: goto -999 -> 382
    //   1384: iconst_1
    //   1385: istore 4
    //   1387: goto -1005 -> 382
    //   1390: astore 19
    //   1392: ldc 172
    //   1394: new 289	java/lang/StringBuilder
    //   1397: dup
    //   1398: ldc_w 629
    //   1401: invokespecial 294	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1404: aload 19
    //   1406: invokevirtual 297	java/lang/Exception:toString	()Ljava/lang/String;
    //   1409: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1415: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1418: iconst_1
    //   1419: istore 4
    //   1421: goto -1039 -> 382
    //   1424: astore 18
    //   1426: ldc 172
    //   1428: new 289	java/lang/StringBuilder
    //   1431: dup
    //   1432: ldc_w 631
    //   1435: invokespecial 294	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1438: aload 18
    //   1440: invokevirtual 297	java/lang/Exception:toString	()Ljava/lang/String;
    //   1443: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1449: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1452: goto -1024 -> 428
    //   1455: getstatic 508	com/tencent/mm/plugin/voip/video/camera/a/d:Oal	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   1458: getfield 634	com/tencent/mm/plugin/voip/video/camera/prev/b:OaR	Landroid/graphics/Point;
    //   1461: astore 18
    //   1463: goto -989 -> 474
    //   1466: iconst_0
    //   1467: istore 4
    //   1469: goto -987 -> 482
    //   1472: astore 20
    //   1474: aload 21
    //   1476: astore 18
    //   1478: ldc 172
    //   1480: ldc_w 636
    //   1483: iconst_1
    //   1484: anewarray 176	java/lang/Object
    //   1487: dup
    //   1488: iconst_0
    //   1489: aload 20
    //   1491: invokevirtual 601	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1494: aastore
    //   1495: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1498: goto -778 -> 720
    //   1501: ldc 172
    //   1503: ldc_w 638
    //   1506: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1509: aload 18
    //   1511: ifnull +112 -> 1623
    //   1514: ldc 172
    //   1516: new 289	java/lang/StringBuilder
    //   1519: dup
    //   1520: ldc_w 640
    //   1523: invokespecial 294	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1526: aload 18
    //   1528: getfield 573	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   1531: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1534: ldc_w 592
    //   1537: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: aload 18
    //   1542: getfield 574	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   1545: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1548: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1551: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1554: aload_0
    //   1555: aload_0
    //   1556: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1559: aload 18
    //   1561: getfield 573	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   1564: aload 18
    //   1566: getfield 574	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   1569: invokespecial 588	com/tencent/mm/plugin/voip/video/camera/prev/c:a	(Lcom/tencent/mm/compatible/deviceinfo/w;II)Z
    //   1572: ifne +51 -> 1623
    //   1575: ldc 172
    //   1577: new 289	java/lang/StringBuilder
    //   1580: dup
    //   1581: ldc_w 642
    //   1584: invokespecial 294	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1587: aload 18
    //   1589: getfield 573	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   1592: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1595: ldc_w 592
    //   1598: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: aload 18
    //   1603: getfield 574	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   1606: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1609: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1612: invokestatic 305	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1615: ldc_w 481
    //   1618: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1621: iconst_m1
    //   1622: ireturn
    //   1623: aload_0
    //   1624: aload_0
    //   1625: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1628: aload_0
    //   1629: getfield 98	com/tencent/mm/plugin/voip/video/camera/prev/c:Oax	Z
    //   1632: invokespecial 644	com/tencent/mm/plugin/voip/video/camera/prev/c:b	(Lcom/tencent/mm/compatible/deviceinfo/w;Z)Z
    //   1635: pop
    //   1636: aload_0
    //   1637: aload_0
    //   1638: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1641: invokevirtual 259	com/tencent/mm/compatible/deviceinfo/w:avd	()Landroid/hardware/Camera$Parameters;
    //   1644: putfield 646	com/tencent/mm/plugin/voip/video/camera/prev/c:Ftv	Landroid/hardware/Camera$Parameters;
    //   1647: aload_0
    //   1648: getfield 646	com/tencent/mm/plugin/voip/video/camera/prev/c:Ftv	Landroid/hardware/Camera$Parameters;
    //   1651: invokevirtual 650	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   1654: astore 18
    //   1656: aload 18
    //   1658: ifnull +24 -> 1682
    //   1661: aload_0
    //   1662: new 569	com/tencent/mm/compatible/deviceinfo/ad
    //   1665: dup
    //   1666: aload 18
    //   1668: getfield 394	android/hardware/Camera$Size:width	I
    //   1671: aload 18
    //   1673: getfield 397	android/hardware/Camera$Size:height	I
    //   1676: invokespecial 570	com/tencent/mm/compatible/deviceinfo/ad:<init>	(II)V
    //   1679: putfield 652	com/tencent/mm/plugin/voip/video/camera/prev/c:OaE	Lcom/tencent/mm/compatible/deviceinfo/ad;
    //   1682: iconst_0
    //   1683: istore_2
    //   1684: aload_0
    //   1685: getfield 646	com/tencent/mm/plugin/voip/video/camera/prev/c:Ftv	Landroid/hardware/Camera$Parameters;
    //   1688: invokevirtual 655	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   1691: istore_3
    //   1692: iload_3
    //   1693: istore_2
    //   1694: aload_0
    //   1695: getstatic 658	com/tencent/mm/plugin/voip/video/camera/a/d:Oaq	I
    //   1698: putfield 660	com/tencent/mm/plugin/voip/video/camera/prev/c:Ftx	I
    //   1701: aload_0
    //   1702: getfield 660	com/tencent/mm/plugin/voip/video/camera/prev/c:Ftx	I
    //   1705: ifgt +9 -> 1714
    //   1708: aload_0
    //   1709: bipush 7
    //   1711: putfield 660	com/tencent/mm/plugin/voip/video/camera/prev/c:Ftx	I
    //   1714: aload_0
    //   1715: aload_0
    //   1716: getfield 488	com/tencent/mm/plugin/voip/video/camera/prev/c:wFd	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   1719: invokespecial 662	com/tencent/mm/plugin/voip/video/camera/prev/c:i	(Lcom/tencent/mm/compatible/deviceinfo/w;)V
    //   1722: ldc 172
    //   1724: ldc_w 664
    //   1727: bipush 6
    //   1729: anewarray 176	java/lang/Object
    //   1732: dup
    //   1733: iconst_0
    //   1734: iload_2
    //   1735: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1738: aastore
    //   1739: dup
    //   1740: iconst_1
    //   1741: aload_0
    //   1742: getfield 652	com/tencent/mm/plugin/voip/video/camera/prev/c:OaE	Lcom/tencent/mm/compatible/deviceinfo/ad;
    //   1745: getfield 573	com/tencent/mm/compatible/deviceinfo/ad:width	I
    //   1748: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1751: aastore
    //   1752: dup
    //   1753: iconst_2
    //   1754: aload_0
    //   1755: getfield 652	com/tencent/mm/plugin/voip/video/camera/prev/c:OaE	Lcom/tencent/mm/compatible/deviceinfo/ad;
    //   1758: getfield 574	com/tencent/mm/compatible/deviceinfo/ad:height	I
    //   1761: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1764: aastore
    //   1765: dup
    //   1766: iconst_3
    //   1767: aload_0
    //   1768: getfield 660	com/tencent/mm/plugin/voip/video/camera/prev/c:Ftx	I
    //   1771: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1774: aastore
    //   1775: dup
    //   1776: iconst_4
    //   1777: getstatic 454	com/tencent/mm/plugin/voip/video/camera/a/d:Oao	I
    //   1780: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1783: aastore
    //   1784: dup
    //   1785: iconst_5
    //   1786: aload_0
    //   1787: getfield 102	com/tencent/mm/plugin/voip/video/camera/prev/c:FtG	I
    //   1790: invokestatic 182	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1793: aastore
    //   1794: invokestatic 320	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1797: ldc_w 481
    //   1800: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1803: iconst_1
    //   1804: ireturn
    //   1805: astore 18
    //   1807: getstatic 281	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   1810: ldc2_w 282
    //   1813: lconst_0
    //   1814: lconst_1
    //   1815: iconst_0
    //   1816: invokevirtual 287	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1819: ldc 172
    //   1821: ldc_w 666
    //   1824: iconst_1
    //   1825: anewarray 176	java/lang/Object
    //   1828: dup
    //   1829: iconst_0
    //   1830: aload 18
    //   1832: invokevirtual 601	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1835: aastore
    //   1836: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1839: ldc_w 481
    //   1842: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1845: iconst_m1
    //   1846: ireturn
    //   1847: astore 18
    //   1849: ldc 172
    //   1851: ldc_w 668
    //   1854: iconst_1
    //   1855: anewarray 176	java/lang/Object
    //   1858: dup
    //   1859: iconst_0
    //   1860: aload 18
    //   1862: invokevirtual 601	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1865: aastore
    //   1866: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1869: goto -175 -> 1694
    //   1872: astore 18
    //   1874: ldc 172
    //   1876: ldc_w 670
    //   1879: iconst_1
    //   1880: anewarray 176	java/lang/Object
    //   1883: dup
    //   1884: iconst_0
    //   1885: aload 18
    //   1887: invokevirtual 601	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1890: aastore
    //   1891: invokestatic 603	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1894: goto -172 -> 1722
    //   1897: astore 20
    //   1899: goto -421 -> 1478
    //   1902: goto -1309 -> 593
    //   1905: aconst_null
    //   1906: astore 19
    //   1908: goto -1360 -> 548
    //   1911: iload 4
    //   1913: istore 7
    //   1915: iload 6
    //   1917: istore 4
    //   1919: iload 7
    //   1921: istore 6
    //   1923: goto +32 -> 1955
    //   1926: iload 8
    //   1928: ifle -899 -> 1029
    //   1931: iload 7
    //   1933: ifle -904 -> 1029
    //   1936: iload 7
    //   1938: iload 8
    //   1940: if_icmplt -911 -> 1029
    //   1943: iconst_1
    //   1944: istore 16
    //   1946: goto -1630 -> 316
    //   1949: iconst_1
    //   1950: istore 4
    //   1952: goto -1570 -> 382
    //   1955: iload 9
    //   1957: iconst_1
    //   1958: iadd
    //   1959: istore 9
    //   1961: iload 6
    //   1963: istore 7
    //   1965: iload 4
    //   1967: istore 6
    //   1969: iload 7
    //   1971: istore 4
    //   1973: goto -871 -> 1102
    //   1976: iconst_0
    //   1977: istore 7
    //   1979: goto -705 -> 1274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1982	0	this	c
    //   0	1982	1	paramBoolean	boolean
    //   0	1982	2	paramInt1	int
    //   0	1982	3	paramInt2	int
    //   178	1794	4	i	int
    //   1095	223	5	j	int
    //   273	1695	6	k	int
    //   281	1697	7	m	int
    //   278	1663	8	n	int
    //   1090	870	9	i1	int
    //   1156	160	10	i2	int
    //   169	1185	11	i3	int
    //   1087	31	12	i4	int
    //   1212	82	13	i5	int
    //   1220	64	14	i6	int
    //   1241	21	15	i7	int
    //   31	1914	16	bool1	boolean
    //   27	59	17	bool2	boolean
    //   161	720	18	localObject1	Object
    //   902	470	18	localException1	Exception
    //   1424	15	18	localException2	Exception
    //   1461	211	18	localObject2	Object
    //   1805	26	18	localException3	Exception
    //   1847	14	18	localException4	Exception
    //   1872	14	18	localException5	Exception
    //   205	566	19	localObject3	Object
    //   1002	372	19	localException6	Exception
    //   1390	15	19	localException7	Exception
    //   1906	1	19	localObject4	Object
    //   576	545	20	localObject5	Object
    //   1472	18	20	localException8	Exception
    //   1897	1	20	localException9	Exception
    //   483	992	21	arrayOfInt	int[]
    //   566	83	22	localPoint	Point
    // Exception table:
    //   from	to	target	type
    //   137	152	902	java/lang/Exception
    //   943	975	1002	java/lang/Exception
    //   975	994	1002	java/lang/Exception
    //   180	207	1390	java/lang/Exception
    //   207	237	1390	java/lang/Exception
    //   237	271	1390	java/lang/Exception
    //   283	313	1390	java/lang/Exception
    //   316	360	1390	java/lang/Exception
    //   1055	1062	1390	java/lang/Exception
    //   1067	1077	1390	java/lang/Exception
    //   1080	1089	1390	java/lang/Exception
    //   1120	1134	1390	java/lang/Exception
    //   1139	1146	1390	java/lang/Exception
    //   1158	1194	1390	java/lang/Exception
    //   1206	1243	1390	java/lang/Exception
    //   1279	1302	1390	java/lang/Exception
    //   1326	1378	1390	java/lang/Exception
    //   387	428	1424	java/lang/Exception
    //   548	578	1472	java/lang/Exception
    //   583	593	1472	java/lang/Exception
    //   601	626	1472	java/lang/Exception
    //   635	662	1472	java/lang/Exception
    //   662	681	1472	java/lang/Exception
    //   1636	1656	1805	java/lang/Exception
    //   1661	1682	1805	java/lang/Exception
    //   1684	1692	1847	java/lang/Exception
    //   1714	1722	1872	java/lang/Exception
    //   681	720	1897	java/lang/Exception
  }
  
  private w uR(boolean paramBoolean)
  {
    AppMethodBeat.i(234304);
    w localw = uS(paramBoolean);
    if (localw == null) {}
    for (;;)
    {
      try
      {
        localw = new w(Camera.open());
        this.Oax = false;
        h.IzE.idkeyStat(159L, 0L, 1L, false);
        h(localw);
        f(localw);
        AppMethodBeat.o(234304);
        return localw;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Voip.CaptureRender", "OpenCameraError:" + localException.toString());
        h.IzE.idkeyStat(159L, 0L, 1L, false);
        h.IzE.idkeyStat(159L, 1L, 1L, false);
        if (this.FtB != null) {
          this.FtB.cNy();
        }
        AppMethodBeat.o(234304);
        return null;
      }
      this.Oax = paramBoolean;
      this.FtB.IA(this.lcs);
    }
  }
  
  private static w uS(boolean paramBoolean)
  {
    localObject2 = null;
    AppMethodBeat.i(234300);
    if (com.tencent.mm.plugin.voip.video.camera.a.d.Oal.jpH <= 0)
    {
      AppMethodBeat.o(234300);
      return null;
    }
    if (!com.tencent.mm.plugin.voip.video.camera.a.d.gDK())
    {
      AppMethodBeat.o(234300);
      return null;
    }
    if (paramBoolean == true) {}
    for (;;)
    {
      try
      {
        locala = com.tencent.mm.compatible.deviceinfo.d.D(MMApplicationContext.getContext(), com.tencent.mm.plugin.voip.video.camera.a.d.Oam);
        Log.i("Camera", "Use front");
        localObject1 = localObject2;
        if (locala != null) {
          localObject1 = locala.jqD;
        }
      }
      catch (Exception localException)
      {
        d.a.a locala;
        h.IzE.idkeyStat(159L, 0L, 1L, false);
        h.IzE.idkeyStat(159L, 1L, 1L, false);
        Log.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + localException.toString());
        Object localObject1 = localObject2;
        continue;
      }
      AppMethodBeat.o(234300);
      return localObject1;
      locala = com.tencent.mm.compatible.deviceinfo.d.D(MMApplicationContext.getContext(), com.tencent.mm.plugin.voip.video.camera.a.d.Oan);
      Log.i("Camera", "Use back");
    }
  }
  
  public final void IA(int paramInt)
  {
    AppMethodBeat.i(234357);
    this.lcs = paramInt;
    this.FtB.IA(this.lcs);
    AppMethodBeat.o(234357);
  }
  
  public final int a(com.tencent.mm.plugin.voip.video.camera.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(234298);
    if (com.tencent.mm.plugin.voip.video.camera.a.d.Oal.jpH <= 0)
    {
      this.OaD = 1;
      AppMethodBeat.o(234298);
      return -1;
    }
    if (paramBoolean) {
      if (!com.tencent.mm.plugin.voip.video.camera.a.d.Oal.OaM) {
        paramBoolean = false;
      }
    }
    int i;
    for (;;)
    {
      this.FtB = paramc;
      if (l(paramBoolean, this.mWidth, this.mHeight) > 0) {
        break;
      }
      i = l(paramBoolean, this.mWidth, this.mHeight);
      if (i > 0) {
        break;
      }
      this.OaD = 1;
      AppMethodBeat.o(234298);
      return i;
      if (!com.tencent.mm.plugin.voip.video.camera.a.d.Oal.OaN) {
        paramBoolean = true;
      }
    }
    if (!g.gCF()) {}
    for (;;)
    {
      try
      {
        if ((this.wFd != null) && (this.Fty))
        {
          if ((this.OaE == null) || (this.OaE.height <= 0) || (this.OaE.width <= 0)) {
            continue;
          }
          int j = this.OaE.height * this.OaE.width * 3 / 2;
          if (this.FtF != null) {
            break label335;
          }
          this.FtF = new ArrayList(3);
          i = 0;
          if (i >= 3) {
            break label335;
          }
          this.FtF.add(new byte[j]);
          i += 1;
          continue;
          if (i < this.FtF.size())
          {
            if (this.wFd == null) {
              break label340;
            }
            this.wFd.aj((byte[])this.FtF.get(i));
            break label340;
          }
          this.wFd.b(this.FtL);
        }
      }
      catch (Exception paramc)
      {
        Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", paramc, "setPreviewCallback error: %s", new Object[] { paramc.getMessage() });
        continue;
      }
      this.OaD = 0;
      AppMethodBeat.o(234298);
      return 1;
      this.wFd.a(this.FtL);
      continue;
      j.gDe();
      continue;
      label335:
      i = 0;
      continue;
      label340:
      i += 1;
    }
  }
  
  public final void eXS()
  {
    AppMethodBeat.i(234342);
    Log.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.FtC);
    if ((this.FtC) && (this.wFd != null))
    {
      this.FtD = false;
      if (!this.wFd.jtb) {
        this.wFd.a(null);
      }
    }
    try
    {
      this.wFd.TL();
      this.wFf = false;
      this.FtC = false;
      if (1 == this.OaD)
      {
        qj localqj = new qj();
        localqj.fPf.type = 2;
        EventCenter.instance.publish(localqj);
      }
      Log.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.Fty);
      if (this.Fty)
      {
        this.OaD = 0;
        this.FtD = false;
        if ((this.wFd != null) && (!this.wFd.jtb))
        {
          if ((!g.gCF()) && (!this.wFd.jtb)) {
            this.wFd.a(null);
          }
          this.wFd.release();
        }
        this.wFd = null;
        this.Fty = false;
        this.FtE = null;
        if (this.FtF != null) {
          this.FtF.clear();
        }
        this.FtF = null;
        this.Ftz = false;
        if (this.FAu != null)
        {
          this.FAu.unInit();
          this.FAu = null;
        }
        AppMethodBeat.o(234342);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Voip.CaptureRender", "stopPreview:error" + localException.toString());
        continue;
        if (this.wFd != null)
        {
          if ((!g.gCF()) && (!this.wFd.jtb)) {
            this.wFd.a(null);
          }
          this.wFd.release();
          this.wFd = null;
          this.Fty = false;
        }
      }
    }
  }
  
  public final boolean egx()
  {
    return this.wFf;
  }
  
  public final int gDA()
  {
    return this.OaD;
  }
  
  public final int gDB()
  {
    AppMethodBeat.i(234334);
    if (!this.Fty)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
      this.OaD = 1;
      AppMethodBeat.o(234334);
      return -1;
    }
    if (this.FtC)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: is in capture already ");
      AppMethodBeat.o(234334);
      return -1;
    }
    Log.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", new Object[] { Boolean.valueOf(this.FtA) });
    if (this.mSurfaceTexture != null) {}
    try
    {
      this.wFd.f(this.mSurfaceTexture);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.wFd.ave();
          this.wFf = true;
          if ((!g.gCF()) && (this.wFd != null)) {
            this.wFd.a(this.FtL);
          }
          this.FtC = true;
          if (this.FAu == null) {
            this.FAu = new com.tencent.mm.plugin.voip.video.camera.a.b(this);
          }
          this.FtB.IA(this.lcs);
          AppMethodBeat.o(234334);
          return 1;
          localException1 = localException1;
          h.IzE.idkeyStat(159L, 0L, 1L, false);
          h.IzE.idkeyStat(159L, 2L, 1L, false);
          this.OaD = 1;
          Log.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + localException1.toString());
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          h.IzE.idkeyStat(159L, 0L, 1L, false);
          h.IzE.idkeyStat(159L, 2L, 1L, false);
          this.OaD = 1;
          if (this.FtB != null) {
            this.FtB.cNy();
          }
          Log.e("MicroMsg.Voip.CaptureRender", "startPreview:error" + localException2.toString());
        }
      }
    }
  }
  
  public final ad gDC()
  {
    return this.OaE;
  }
  
  public final void gDD()
  {
    AppMethodBeat.i(234331);
    if (com.tencent.mm.plugin.voip.video.camera.a.d.Oal.jpH < 2)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + com.tencent.mm.plugin.voip.video.camera.a.d.Oal.jpH);
      AppMethodBeat.o(234331);
      return;
    }
    Log.i("MicroMsg.Voip.CaptureRender", "ExchangeCapture start, gCameraNum= " + com.tencent.mm.plugin.voip.video.camera.a.d.Oal.jpH);
    eXS();
    com.tencent.mm.plugin.voip.video.camera.a.c localc = this.FtB;
    if (!this.Oax) {}
    for (boolean bool = true;; bool = false)
    {
      a(localc, bool);
      gDB();
      com.tencent.mm.plugin.voip.c.gxs().akX(this.OaD);
      this.lbz = true;
      AppMethodBeat.o(234331);
      return;
    }
  }
  
  public final int gDE()
  {
    boolean bool = true;
    int k;
    int i;
    int j;
    if (this.Oax)
    {
      k = com.tencent.mm.plugin.voip.video.camera.a.d.Oao;
      i = k;
      if (!af.juH.jpP) {
        break label133;
      }
      i = k;
      if (af.juH.jpO.fSM == 0) {
        break label133;
      }
      j = 1;
      i = k;
    }
    for (;;)
    {
      if ((j == 0) && (i > 0))
      {
        label51:
        this.Oay = bool;
        if (!this.Oay) {
          break label122;
        }
      }
      label122:
      for (i = OpenGlRender.FLAG_Angle270;; i = OpenGlRender.FLAG_Angle90)
      {
        if (i != OpenGlRender.FLAG_Angle270) {
          break label129;
        }
        return 90;
        j = com.tencent.mm.plugin.voip.video.camera.a.d.Oap;
        i = j;
        if (!af.juH.jpR) {
          break label133;
        }
        i = j;
        if (af.juH.jpQ.fSM == 0) {
          break label133;
        }
        k = 1;
        i = j;
        j = k;
        break;
        bool = false;
        break label51;
      }
      label129:
      return 270;
      label133:
      j = 0;
    }
  }
  
  public final boolean gDF()
  {
    boolean bool = false;
    if (this.Oax) {}
    for (int i = OpenGlRender.FLAG_Mirror;; i = 0)
    {
      if (i == OpenGlRender.FLAG_Mirror) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final void gDG()
  {
    AppMethodBeat.i(234321);
    try
    {
      if (this.wFd != null) {
        i(this.wFd);
      }
      AppMethodBeat.o(234321);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "setDisplayOrientation failed: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(234321);
    }
  }
  
  public final int gDH()
  {
    return this.FtG;
  }
  
  @TargetApi(14)
  public final void gDI()
  {
    boolean bool3 = true;
    AppMethodBeat.i(234345);
    if ((af.juH.jqr == 1) && (this.Ftz))
    {
      AppMethodBeat.o(234345);
      return;
    }
    if (af.juH.jqq > 2000) {
      this.Ftt = af.juH.jqq;
    }
    Log.e("MicroMsg.Voip.CaptureRender", "focusOnFace error, faceLocation is null");
    StringBuilder localStringBuilder;
    boolean bool2;
    if (System.currentTimeMillis() - this.OaC > this.Ftt)
    {
      bool1 = true;
      localStringBuilder = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
      if (this.Oaz) {
        break label266;
      }
      bool2 = true;
      label102:
      localStringBuilder = localStringBuilder.append(bool2).append(",isAutoFocusTimeout: ").append(bool1).append(",mAutoFocusTimeOut:").append(this.Ftt).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
      if (this.OaA == this.Oax) {
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
        if ((this.wFd != null) && (this.wFd.avd() != null) && (this.wFd.avd().getFocusMode() != null) && (this.wFd.avd().getFocusMode().equals("auto")))
        {
          this.wFd.a(null);
          this.OaH = null;
          this.OaC = System.currentTimeMillis();
          this.Oaz = true;
          this.OaA = this.Oax;
        }
        AppMethodBeat.o(234345);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Voip.CaptureRender", "mCamera.getParameters() or autoFocus fail!" + localException.toString());
        AppMethodBeat.o(234345);
      }
      bool1 = false;
      break;
      bool2 = false;
      break label102;
    }
  }
  
  public final boolean gDy()
  {
    return this.Oax;
  }
  
  public final boolean gDz()
  {
    return this.Oay;
  }
  
  public final void onOrientationChange(int paramInt)
  {
    this.OaS = paramInt;
  }
  
  public final void t(SurfaceTexture paramSurfaceTexture)
  {
    this.mSurfaceTexture = paramSurfaceTexture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.prev.c
 * JD-Core Version:    0.7.0.1
 */