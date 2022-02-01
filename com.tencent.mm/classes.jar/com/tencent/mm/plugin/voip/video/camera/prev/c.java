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
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.a.a;
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
{
  private static int irq;
  private static int irs;
  private static final Pattern zOp;
  protected boolean HjI;
  protected boolean HjJ;
  protected boolean HjK;
  protected boolean HjL;
  protected boolean HjM;
  protected long HjN;
  protected int HjO;
  protected ac HjP;
  protected int[] HjS;
  protected int HjT;
  private int Hkd;
  protected boolean imy;
  protected int mHeight;
  SurfaceTexture mSurfaceTexture;
  protected int mWidth;
  protected volatile v sZb;
  protected boolean sZd;
  protected long zNW;
  protected Camera.Parameters zNY;
  protected int zOa;
  protected boolean zOb;
  protected boolean zOc;
  protected boolean zOd;
  protected com.tencent.mm.plugin.voip.video.camera.a.b zOe;
  public boolean zOf;
  protected boolean zOg;
  protected byte[] zOh;
  protected List<byte[]> zOi;
  private int zOj;
  protected int zOk;
  protected int zOl;
  protected boolean zOm;
  private byte[] zOn;
  Camera.PreviewCallback zOo;
  
  static
  {
    AppMethodBeat.i(235887);
    zOp = Pattern.compile(",");
    irq = 20;
    irs = 70;
    AppMethodBeat.o(235887);
  }
  
  public c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235871);
    this.Hkd = 0;
    this.HjI = false;
    this.HjJ = false;
    this.zOj = 0;
    this.HjK = false;
    this.HjL = false;
    this.HjM = false;
    this.HjN = 0L;
    this.zNW = 30000L;
    this.HjO = 0;
    this.zOb = false;
    this.zOc = false;
    this.zOd = false;
    this.zOf = false;
    this.zOg = false;
    this.zOh = null;
    this.HjS = null;
    this.mWidth = 320;
    this.mHeight = 240;
    this.imy = true;
    this.zOk = 0;
    this.zOl = 0;
    this.HjT = 0;
    this.sZd = false;
    this.zOm = false;
    this.zOn = null;
    this.zOo = new Camera.PreviewCallback()
    {
      public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(235870);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          h.CyF.idkeyStat(159L, 0L, 1L, false);
          h.CyF.idkeyStat(159L, 3L, 1L, false);
          if (c.this.zOe != null) {
            c.this.zOe.cza();
          }
          AppMethodBeat.o(235870);
          return;
        }
        if (c.this.HjP == null)
        {
          Log.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
          AppMethodBeat.o(235870);
          return;
        }
        int m;
        int i;
        int k;
        int j;
        if (c.this.zOe != null)
        {
          if ((c.a(c.this) == null) || (c.a(c.this).length != paramAnonymousArrayOfByte.length)) {
            c.a(c.this, new byte[paramAnonymousArrayOfByte.length]);
          }
          System.arraycopy(paramAnonymousArrayOfByte, 0, c.a(c.this), 0, paramAnonymousArrayOfByte.length);
          m = 1;
          if (c.this.HjI)
          {
            i = com.tencent.mm.plugin.voip.video.camera.a.c.Hjz;
            k = i;
            if (!ae.gKt.gFF) {
              break label619;
            }
            k = i;
            if (ae.gKt.gFE.dYT == 0) {
              break label619;
            }
            j = ae.gKt.gFE.gGp;
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
            paramAnonymousCamera.HjJ = bool;
            if (c.b(c.this) != 90) {
              c.this.HjJ = false;
            }
            k = c.this.HjP.width;
            int n = c.this.HjP.height;
            if (i == 0) {
              break label532;
            }
            if (c.this.zOh == null)
            {
              i = k * n * 3 / 2;
              c.this.zOh = new byte[i];
              c.this.zOh[0] = 90;
            }
            com.tencent.mm.plugin.voip.c.fFg().a(c.a(c.this), c.a(c.this).length, k, n, c.this.zOa, c.this.zOh, c.this.zOh.length, k, n, j);
            c.this.zOe.a(c.this.zOh, c.this.zOh.length, k, n, c.this.zOa, m);
          }
          for (;;)
          {
            if (m.getApiLevel() >= 8)
            {
              if (c.this.sZb == null)
              {
                Log.e("MicroMsg.Voip.CaptureRender", "the camera is null and has been release");
                AppMethodBeat.o(235870);
                return;
                j = com.tencent.mm.plugin.voip.video.camera.a.c.HjA;
                k = j;
                if (!ae.gKt.gFH) {
                  break label619;
                }
                k = j;
                if (ae.gKt.gFG.dYT == 0) {
                  break label619;
                }
                m = ae.gKt.gFG.gGp;
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
                c.this.zOe.a(c.a(c.this), c.a(c.this).length, c.this.HjP.width, c.this.HjP.height, c.this.zOa, m);
                continue;
              }
              if (c.this.sZb != null) {
                c.this.sZb.addCallbackBuffer(paramAnonymousArrayOfByte);
              }
            }
          }
          AppMethodBeat.o(235870);
          return;
          label619:
          i = 0;
          j = m;
        }
      }
    };
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    com.tencent.mm.plugin.voip.video.camera.a.c.hH(MMApplicationContext.getContext().getApplicationContext());
    Log.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
    AppMethodBeat.o(235871);
  }
  
  private static Point a(CharSequence paramCharSequence, Point paramPoint)
  {
    AppMethodBeat.i(235877);
    int i1 = 2147483647;
    paramCharSequence = zOp.split(paramCharSequence);
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
        AppMethodBeat.o(235877);
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
      AppMethodBeat.o(235877);
      return null;
      label274:
      k = j;
      int n = i;
    }
  }
  
  private boolean a(v paramv, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235875);
    if (paramv == null)
    {
      AppMethodBeat.o(235875);
      return false;
    }
    try
    {
      Camera.Parameters localParameters = paramv.getParameters();
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        localParameters.setPreviewSize(paramInt1, paramInt2);
      }
      paramv.setParameters(localParameters);
      this.zOe.fs(paramInt1, paramInt2);
      AppMethodBeat.o(235875);
      return true;
    }
    catch (Exception paramv)
    {
      h.CyF.idkeyStat(159L, 0L, 1L, false);
      Log.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + paramv.toString());
      AppMethodBeat.o(235875);
    }
    return false;
  }
  
  private boolean b(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(235876);
    if (paramv == null)
    {
      AppMethodBeat.o(235876);
      return false;
    }
    Camera.Parameters localParameters;
    List localList;
    try
    {
      Log.i("MicroMsg.Voip.CaptureRender", "trySetAutoFocus, isFrontCamera:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      localParameters = paramv.getParameters();
      localList = localParameters.getSupportedFocusModes();
      if (localList == null) {
        break label224;
      }
      Log.i("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        Log.i("MicroMsg.Voip.CaptureRender", "supported focus modes : ".concat(String.valueOf((String)localIterator.next())));
      }
      if (ae.gKt.gGg != 0) {
        break label268;
      }
    }
    catch (Exception paramv)
    {
      h.CyF.idkeyStat(159L, 0L, 1L, false);
      Log.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + paramv.toString());
      AppMethodBeat.o(235876);
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
      label224:
      AppMethodBeat.o(235876);
      return true;
      if (localList.contains("continuous-video"))
      {
        Log.i("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
        localParameters.setFocusMode("continuous-video");
        this.zOc = true;
        continue;
        label268:
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
  
  private int f(v paramv)
  {
    AppMethodBeat.i(235885);
    if (paramv == null)
    {
      AppMethodBeat.o(235885);
      return 0;
    }
    for (;;)
    {
      try
      {
        localObject = paramv.getParameters().getSupportedPreviewSizes();
        if ((localObject == null) || (((List)localObject).size() == 0)) {
          continue;
        }
        localObject = ((List)localObject).iterator();
        i = 0;
      }
      catch (Exception paramv)
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
            this.zOk = localSize.width;
            this.zOl = localSize.height;
          }
          i += 1;
          continue;
        }
        try
        {
          paramv = paramv.getParameters().getSupportedPreviewFormats();
          if ((paramv == null) || (paramv.size() == 0)) {
            continue;
          }
          paramv = paramv.iterator();
          if (!paramv.hasNext()) {
            continue;
          }
          Log.i("MicroMsg.Voip.CaptureRender", "support Format:".concat(String.valueOf(((Integer)paramv.next()).intValue())));
          continue;
          Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", paramv, "", new Object[0]);
        }
        catch (Exception paramv) {}
      }
      catch (Exception paramv)
      {
        continue;
      }
      AppMethodBeat.o(235885);
      return i;
    }
  }
  
  /* Error */
  private int h(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 413
    //   3: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 167
    //   8: ldc_w 415
    //   11: iload_1
    //   12: invokestatic 418	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   15: invokevirtual 212	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 115	com/tencent/mm/plugin/voip/video/camera/prev/c:zOc	Z
    //   26: iconst_1
    //   27: istore 17
    //   29: iload 17
    //   31: istore 16
    //   33: aload_0
    //   34: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   37: ifnull +52 -> 89
    //   40: aload_0
    //   41: getfield 93	com/tencent/mm/plugin/voip/video/camera/prev/c:HjI	Z
    //   44: iload_1
    //   45: if_icmpeq +78 -> 123
    //   48: aload_0
    //   49: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   52: getfield 423	com/tencent/mm/compatible/deviceinfo/v:gIJ	Z
    //   55: ifne +11 -> 66
    //   58: aload_0
    //   59: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   62: aconst_null
    //   63: invokevirtual 427	com/tencent/mm/compatible/deviceinfo/v:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   66: aload_0
    //   67: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   70: invokevirtual 430	com/tencent/mm/compatible/deviceinfo/v:stopPreview	()V
    //   73: aload_0
    //   74: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   77: invokevirtual 433	com/tencent/mm/compatible/deviceinfo/v:release	()V
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   85: iload 17
    //   87: istore 16
    //   89: iload 16
    //   91: ifeq +46 -> 137
    //   94: aload_0
    //   95: aload_0
    //   96: iload_1
    //   97: invokespecial 437	com/tencent/mm/plugin/voip/video/camera/prev/c:rO	(Z)Lcom/tencent/mm/compatible/deviceinfo/v;
    //   100: putfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   103: aload_0
    //   104: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   107: ifnonnull +25 -> 132
    //   110: aload_0
    //   111: iconst_0
    //   112: putfield 113	com/tencent/mm/plugin/voip/video/camera/prev/c:zOb	Z
    //   115: ldc_w 413
    //   118: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iconst_m1
    //   122: ireturn
    //   123: aload_0
    //   124: getfield 141	com/tencent/mm/plugin/voip/video/camera/prev/c:zOm	Z
    //   127: istore 16
    //   129: goto -40 -> 89
    //   132: aload_0
    //   133: iconst_0
    //   134: putfield 141	com/tencent/mm/plugin/voip/video/camera/prev/c:zOm	Z
    //   137: aload_0
    //   138: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   141: ifnull +11 -> 152
    //   144: aload_0
    //   145: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   148: invokevirtual 254	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   151: pop
    //   152: aload_0
    //   153: iconst_1
    //   154: putfield 113	com/tencent/mm/plugin/voip/video/camera/prev/c:zOb	Z
    //   157: aload_0
    //   158: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   161: astore 18
    //   163: getstatic 441	com/tencent/mm/plugin/voip/video/camera/a/c:Hjw	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   166: getfield 446	com/tencent/mm/plugin/voip/video/camera/prev/b:HjW	I
    //   169: istore 11
    //   171: aload 18
    //   173: ifnull +256 -> 429
    //   176: bipush 26
    //   178: istore 4
    //   180: ldc 167
    //   182: ldc_w 448
    //   185: iconst_1
    //   186: anewarray 171	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: iload 11
    //   193: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: aastore
    //   197: invokestatic 315	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload 18
    //   202: invokevirtual 254	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   205: astore 19
    //   207: invokestatic 451	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   210: ifeq +27 -> 237
    //   213: ldc_w 453
    //   216: invokestatic 459	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   219: checkcast 453	com/tencent/mm/plugin/zero/b/a
    //   222: invokeinterface 463 1 0
    //   227: ldc_w 465
    //   230: bipush 26
    //   232: invokevirtual 468	com/tencent/mm/n/f:getInt	(Ljava/lang/String;I)I
    //   235: istore 4
    //   237: ldc 167
    //   239: ldc_w 470
    //   242: iconst_1
    //   243: anewarray 171	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: iload 4
    //   250: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: aastore
    //   254: invokestatic 315	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: invokestatic 475	com/tencent/mm/compatible/util/k:alh	()Z
    //   260: ifne +11 -> 271
    //   263: iload 4
    //   265: invokestatic 481	com/tencent/mm/compatible/util/d:oD	(I)Z
    //   268: ifeq +1116 -> 1384
    //   271: ldc 189
    //   273: istore 6
    //   275: iconst_0
    //   276: istore 16
    //   278: iconst_m1
    //   279: istore 8
    //   281: iconst_0
    //   282: istore 7
    //   284: getstatic 356	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   287: ifnull +1639 -> 1926
    //   290: getstatic 356	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   293: getfield 484	com/tencent/mm/compatible/deviceinfo/c:gGk	I
    //   296: sipush 1000
    //   299: imul
    //   300: istore 8
    //   302: getstatic 356	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   305: getfield 487	com/tencent/mm/compatible/deviceinfo/c:gGl	I
    //   308: sipush 1000
    //   311: imul
    //   312: istore 7
    //   314: goto +1612 -> 1926
    //   317: ldc 167
    //   319: ldc_w 489
    //   322: iconst_4
    //   323: anewarray 171	java/lang/Object
    //   326: dup
    //   327: iconst_0
    //   328: iload 8
    //   330: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: iload 7
    //   338: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: aastore
    //   342: dup
    //   343: iconst_2
    //   344: iload 11
    //   346: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: aastore
    //   350: dup
    //   351: iconst_3
    //   352: iload 17
    //   354: invokestatic 313	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   357: aastore
    //   358: invokestatic 315	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   361: iload 8
    //   363: ldc 189
    //   365: if_icmpeq +15 -> 380
    //   368: iload 7
    //   370: ldc 189
    //   372: if_icmpeq +8 -> 380
    //   375: iload 17
    //   377: ifne +949 -> 1326
    //   380: iconst_1
    //   381: istore 4
    //   383: iload 4
    //   385: ifeq +44 -> 429
    //   388: ldc 167
    //   390: ldc_w 491
    //   393: iconst_1
    //   394: anewarray 171	java/lang/Object
    //   397: dup
    //   398: iconst_0
    //   399: iload 11
    //   401: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   404: aastore
    //   405: invokestatic 315	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   408: aload 18
    //   410: invokevirtual 254	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   413: astore 19
    //   415: aload 19
    //   417: iload 11
    //   419: invokevirtual 494	android/hardware/Camera$Parameters:setPreviewFrameRate	(I)V
    //   422: aload 18
    //   424: aload 19
    //   426: invokevirtual 263	com/tencent/mm/compatible/deviceinfo/v:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   429: ldc 167
    //   431: new 284	java/lang/StringBuilder
    //   434: dup
    //   435: ldc_w 496
    //   438: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   441: iload_2
    //   442: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc 68
    //   447: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: iload_3
    //   451: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   454: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: iload_1
    //   461: ifeq +994 -> 1455
    //   464: getstatic 441	com/tencent/mm/plugin/voip/video/camera/a/c:Hjw	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   467: getfield 500	com/tencent/mm/plugin/voip/video/camera/prev/b:Hkb	Landroid/graphics/Point;
    //   470: astore 18
    //   472: aload 18
    //   474: ifnull +992 -> 1466
    //   477: iconst_1
    //   478: istore 4
    //   480: aconst_null
    //   481: astore 21
    //   483: aload 18
    //   485: ifnull +1420 -> 1905
    //   488: new 502	com/tencent/mm/compatible/deviceinfo/ac
    //   491: dup
    //   492: aload 18
    //   494: getfield 234	android/graphics/Point:x	I
    //   497: aload 18
    //   499: getfield 242	android/graphics/Point:y	I
    //   502: invokespecial 503	com/tencent/mm/compatible/deviceinfo/ac:<init>	(II)V
    //   505: astore 19
    //   507: ldc 167
    //   509: new 284	java/lang/StringBuilder
    //   512: dup
    //   513: ldc_w 505
    //   516: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   519: aload 19
    //   521: getfield 506	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   524: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   527: ldc 68
    //   529: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload 19
    //   534: getfield 507	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   537: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   540: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   546: aload_0
    //   547: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   550: invokevirtual 254	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   553: astore 18
    //   555: new 231	android/graphics/Point
    //   558: dup
    //   559: iload_2
    //   560: iload_3
    //   561: invokespecial 244	android/graphics/Point:<init>	(II)V
    //   564: astore 22
    //   566: aload 18
    //   568: ldc_w 509
    //   571: invokevirtual 512	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   574: astore 20
    //   576: aload 20
    //   578: ifnonnull +1324 -> 1902
    //   581: aload 18
    //   583: ldc_w 514
    //   586: invokevirtual 512	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   589: astore 20
    //   591: aconst_null
    //   592: astore 18
    //   594: aload 20
    //   596: ifnull +28 -> 624
    //   599: ldc 167
    //   601: ldc_w 516
    //   604: aload 20
    //   606: invokestatic 208	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   609: invokevirtual 212	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   612: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   615: aload 20
    //   617: aload 22
    //   619: invokestatic 518	com/tencent/mm/plugin/voip/video/camera/prev/c:a	(Ljava/lang/CharSequence;Landroid/graphics/Point;)Landroid/graphics/Point;
    //   622: astore 18
    //   624: aload 18
    //   626: astore 20
    //   628: aload 18
    //   630: ifnonnull +30 -> 660
    //   633: new 231	android/graphics/Point
    //   636: dup
    //   637: aload 22
    //   639: getfield 234	android/graphics/Point:x	I
    //   642: iconst_3
    //   643: ishr
    //   644: iconst_3
    //   645: ishl
    //   646: aload 22
    //   648: getfield 242	android/graphics/Point:y	I
    //   651: iconst_3
    //   652: ishr
    //   653: iconst_3
    //   654: ishl
    //   655: invokespecial 244	android/graphics/Point:<init>	(II)V
    //   658: astore 20
    //   660: new 502	com/tencent/mm/compatible/deviceinfo/ac
    //   663: dup
    //   664: aload 20
    //   666: getfield 234	android/graphics/Point:x	I
    //   669: aload 20
    //   671: getfield 242	android/graphics/Point:y	I
    //   674: invokespecial 503	com/tencent/mm/compatible/deviceinfo/ac:<init>	(II)V
    //   677: astore 18
    //   679: ldc 167
    //   681: new 284	java/lang/StringBuilder
    //   684: dup
    //   685: ldc_w 520
    //   688: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   691: aload 18
    //   693: getfield 506	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   696: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   699: ldc 68
    //   701: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 18
    //   706: getfield 507	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   709: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   712: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   718: iload 4
    //   720: ifeq +781 -> 1501
    //   723: aload_0
    //   724: aload_0
    //   725: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   728: aload 19
    //   730: getfield 506	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   733: aload 19
    //   735: getfield 507	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   738: invokespecial 522	com/tencent/mm/plugin/voip/video/camera/prev/c:a	(Lcom/tencent/mm/compatible/deviceinfo/v;II)Z
    //   741: istore_1
    //   742: ldc 167
    //   744: new 284	java/lang/StringBuilder
    //   747: dup
    //   748: ldc_w 524
    //   751: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   754: aload 19
    //   756: getfield 506	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   759: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   762: ldc_w 526
    //   765: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: aload 19
    //   770: getfield 507	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   773: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   776: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   782: iload_1
    //   783: ifne +840 -> 1623
    //   786: aload 18
    //   788: ifnull +835 -> 1623
    //   791: ldc 167
    //   793: new 284	java/lang/StringBuilder
    //   796: dup
    //   797: ldc_w 528
    //   800: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   803: aload 18
    //   805: getfield 506	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   808: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   811: ldc_w 526
    //   814: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: aload 18
    //   819: getfield 507	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   822: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   825: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   828: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: aload_0
    //   832: aload_0
    //   833: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   836: aload 18
    //   838: getfield 506	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   841: aload 18
    //   843: getfield 507	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   846: invokespecial 522	com/tencent/mm/plugin/voip/video/camera/prev/c:a	(Lcom/tencent/mm/compatible/deviceinfo/v;II)Z
    //   849: ifne +774 -> 1623
    //   852: ldc 167
    //   854: new 284	java/lang/StringBuilder
    //   857: dup
    //   858: ldc_w 530
    //   861: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   864: aload 18
    //   866: getfield 506	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   869: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   872: ldc_w 526
    //   875: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: aload 18
    //   880: getfield 507	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   883: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   886: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   892: ldc_w 413
    //   895: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   898: iconst_m1
    //   899: ireturn
    //   900: astore 18
    //   902: getstatic 276	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   905: ldc2_w 277
    //   908: lconst_0
    //   909: lconst_1
    //   910: iconst_0
    //   911: invokevirtual 282	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   914: ldc 167
    //   916: ldc_w 532
    //   919: iconst_1
    //   920: anewarray 171	java/lang/Object
    //   923: dup
    //   924: iconst_0
    //   925: aload 18
    //   927: invokevirtual 535	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   930: aastore
    //   931: invokestatic 537	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   934: aload_0
    //   935: getfield 265	com/tencent/mm/plugin/voip/video/camera/prev/c:zOe	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   938: ifnull +54 -> 992
    //   941: aload_0
    //   942: getfield 265	com/tencent/mm/plugin/voip/video/camera/prev/c:zOe	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   945: invokeinterface 540 1 0
    //   950: aload_0
    //   951: iconst_1
    //   952: putfield 141	com/tencent/mm/plugin/voip/video/camera/prev/c:zOm	Z
    //   955: aload_0
    //   956: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   959: getfield 423	com/tencent/mm/compatible/deviceinfo/v:gIJ	Z
    //   962: ifne +11 -> 973
    //   965: aload_0
    //   966: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   969: aconst_null
    //   970: invokevirtual 427	com/tencent/mm/compatible/deviceinfo/v:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   973: aload_0
    //   974: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   977: invokevirtual 430	com/tencent/mm/compatible/deviceinfo/v:stopPreview	()V
    //   980: aload_0
    //   981: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   984: invokevirtual 433	com/tencent/mm/compatible/deviceinfo/v:release	()V
    //   987: aload_0
    //   988: aconst_null
    //   989: putfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   992: ldc_w 413
    //   995: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   998: iconst_m1
    //   999: ireturn
    //   1000: astore 19
    //   1002: ldc 167
    //   1004: aload 19
    //   1006: ldc_w 542
    //   1009: iconst_1
    //   1010: anewarray 171	java/lang/Object
    //   1013: dup
    //   1014: iconst_0
    //   1015: aload 18
    //   1017: invokevirtual 535	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1020: aastore
    //   1021: invokestatic 410	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1024: goto -32 -> 992
    //   1027: iload 8
    //   1029: ifne +24 -> 1053
    //   1032: iload 7
    //   1034: ifne +19 -> 1053
    //   1037: iconst_0
    //   1038: istore 17
    //   1040: ldc_w 543
    //   1043: istore 7
    //   1045: ldc_w 543
    //   1048: istore 8
    //   1050: goto -733 -> 317
    //   1053: aload 19
    //   1055: invokevirtual 546	android/hardware/Camera$Parameters:getSupportedPreviewFpsRange	()Ljava/util/List;
    //   1058: astore 20
    //   1060: aload 20
    //   1062: ifnull +887 -> 1949
    //   1065: aload 20
    //   1067: invokeinterface 327 1 0
    //   1072: ifne +6 -> 1078
    //   1075: goto +874 -> 1949
    //   1078: aload 20
    //   1080: invokeinterface 327 1 0
    //   1085: istore 12
    //   1087: iconst_0
    //   1088: istore 9
    //   1090: ldc_w 543
    //   1093: istore 5
    //   1095: ldc_w 543
    //   1098: istore 4
    //   1100: iload 16
    //   1102: istore 17
    //   1104: iload 5
    //   1106: istore 7
    //   1108: iload 4
    //   1110: istore 8
    //   1112: iload 9
    //   1114: iload 12
    //   1116: if_icmpge -799 -> 317
    //   1119: aload 20
    //   1121: iload 9
    //   1123: invokeinterface 549 2 0
    //   1128: checkcast 550	[I
    //   1131: astore 21
    //   1133: aload 21
    //   1135: ifnull +776 -> 1911
    //   1138: aload 21
    //   1140: arraylength
    //   1141: iconst_1
    //   1142: if_icmple +769 -> 1911
    //   1145: aload 21
    //   1147: iconst_0
    //   1148: iaload
    //   1149: istore 8
    //   1151: aload 21
    //   1153: iconst_1
    //   1154: iaload
    //   1155: istore 10
    //   1157: ldc 167
    //   1159: ldc_w 552
    //   1162: iconst_3
    //   1163: anewarray 171	java/lang/Object
    //   1166: dup
    //   1167: iconst_0
    //   1168: iload 9
    //   1170: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1173: aastore
    //   1174: dup
    //   1175: iconst_1
    //   1176: iload 8
    //   1178: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1181: aastore
    //   1182: dup
    //   1183: iconst_2
    //   1184: iload 10
    //   1186: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1189: aastore
    //   1190: invokestatic 315	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1193: iload 8
    //   1195: iflt +716 -> 1911
    //   1198: iload 10
    //   1200: iload 8
    //   1202: if_icmplt +709 -> 1911
    //   1205: iload 10
    //   1207: sipush 1000
    //   1210: idiv
    //   1211: istore 13
    //   1213: iload 8
    //   1215: sipush 1000
    //   1218: idiv
    //   1219: istore 14
    //   1221: iload 11
    //   1223: iconst_5
    //   1224: iadd
    //   1225: bipush 30
    //   1227: invokestatic 556	java/lang/Math:min	(II)I
    //   1230: istore 7
    //   1232: iload 11
    //   1234: iconst_5
    //   1235: isub
    //   1236: iconst_5
    //   1237: invokestatic 559	java/lang/Math:max	(II)I
    //   1240: istore 15
    //   1242: iload 13
    //   1244: iload 15
    //   1246: if_icmplt +730 -> 1976
    //   1249: iload 13
    //   1251: iload 7
    //   1253: if_icmpgt +723 -> 1976
    //   1256: iload 14
    //   1258: iload 15
    //   1260: if_icmplt +716 -> 1976
    //   1263: iload 14
    //   1265: iload 7
    //   1267: if_icmpgt +709 -> 1976
    //   1270: iconst_1
    //   1271: istore 7
    //   1273: iload 7
    //   1275: ifeq +636 -> 1911
    //   1278: iload 11
    //   1280: iload 14
    //   1282: isub
    //   1283: invokestatic 239	java/lang/Math:abs	(I)I
    //   1286: istore 7
    //   1288: iload 13
    //   1290: iload 11
    //   1292: isub
    //   1293: invokestatic 239	java/lang/Math:abs	(I)I
    //   1296: iload 7
    //   1298: iadd
    //   1299: istore 7
    //   1301: iload 7
    //   1303: iload 6
    //   1305: if_icmpge +606 -> 1911
    //   1308: iconst_1
    //   1309: istore 16
    //   1311: iload 7
    //   1313: istore 4
    //   1315: iload 10
    //   1317: istore 5
    //   1319: iload 8
    //   1321: istore 6
    //   1323: goto +632 -> 1955
    //   1326: ldc 167
    //   1328: ldc_w 561
    //   1331: iconst_3
    //   1332: anewarray 171	java/lang/Object
    //   1335: dup
    //   1336: iconst_0
    //   1337: iload 8
    //   1339: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1342: aastore
    //   1343: dup
    //   1344: iconst_1
    //   1345: iload 7
    //   1347: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1350: aastore
    //   1351: dup
    //   1352: iconst_2
    //   1353: iload 11
    //   1355: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1358: aastore
    //   1359: invokestatic 315	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1362: aload 19
    //   1364: iload 8
    //   1366: iload 7
    //   1368: invokevirtual 564	android/hardware/Camera$Parameters:setPreviewFpsRange	(II)V
    //   1371: aload 18
    //   1373: aload 19
    //   1375: invokevirtual 263	com/tencent/mm/compatible/deviceinfo/v:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   1378: iconst_0
    //   1379: istore 4
    //   1381: goto -998 -> 383
    //   1384: iconst_1
    //   1385: istore 4
    //   1387: goto -1004 -> 383
    //   1390: astore 19
    //   1392: ldc 167
    //   1394: new 284	java/lang/StringBuilder
    //   1397: dup
    //   1398: ldc_w 566
    //   1401: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1404: aload 19
    //   1406: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   1409: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1415: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1418: iconst_1
    //   1419: istore 4
    //   1421: goto -1038 -> 383
    //   1424: astore 18
    //   1426: ldc 167
    //   1428: new 284	java/lang/StringBuilder
    //   1431: dup
    //   1432: ldc_w 568
    //   1435: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1438: aload 18
    //   1440: invokevirtual 292	java/lang/Exception:toString	()Ljava/lang/String;
    //   1443: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1446: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1449: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1452: goto -1023 -> 429
    //   1455: getstatic 441	com/tencent/mm/plugin/voip/video/camera/a/c:Hjw	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   1458: getfield 571	com/tencent/mm/plugin/voip/video/camera/prev/b:Hkc	Landroid/graphics/Point;
    //   1461: astore 18
    //   1463: goto -991 -> 472
    //   1466: iconst_0
    //   1467: istore 4
    //   1469: goto -989 -> 480
    //   1472: astore 20
    //   1474: aload 21
    //   1476: astore 18
    //   1478: ldc 167
    //   1480: ldc_w 573
    //   1483: iconst_1
    //   1484: anewarray 171	java/lang/Object
    //   1487: dup
    //   1488: iconst_0
    //   1489: aload 20
    //   1491: invokevirtual 535	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1494: aastore
    //   1495: invokestatic 537	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1498: goto -780 -> 718
    //   1501: ldc 167
    //   1503: ldc_w 575
    //   1506: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1509: aload 18
    //   1511: ifnull +112 -> 1623
    //   1514: ldc 167
    //   1516: new 284	java/lang/StringBuilder
    //   1519: dup
    //   1520: ldc_w 577
    //   1523: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1526: aload 18
    //   1528: getfield 506	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   1531: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1534: ldc_w 526
    //   1537: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: aload 18
    //   1542: getfield 507	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   1545: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1548: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1551: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1554: aload_0
    //   1555: aload_0
    //   1556: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1559: aload 18
    //   1561: getfield 506	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   1564: aload 18
    //   1566: getfield 507	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   1569: invokespecial 522	com/tencent/mm/plugin/voip/video/camera/prev/c:a	(Lcom/tencent/mm/compatible/deviceinfo/v;II)Z
    //   1572: ifne +51 -> 1623
    //   1575: ldc 167
    //   1577: new 284	java/lang/StringBuilder
    //   1580: dup
    //   1581: ldc_w 579
    //   1584: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1587: aload 18
    //   1589: getfield 506	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   1592: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1595: ldc_w 526
    //   1598: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1601: aload 18
    //   1603: getfield 507	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   1606: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1609: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1612: invokestatic 300	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1615: ldc_w 413
    //   1618: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1621: iconst_m1
    //   1622: ireturn
    //   1623: aload_0
    //   1624: aload_0
    //   1625: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1628: aload_0
    //   1629: getfield 93	com/tencent/mm/plugin/voip/video/camera/prev/c:HjI	Z
    //   1632: invokespecial 581	com/tencent/mm/plugin/voip/video/camera/prev/c:b	(Lcom/tencent/mm/compatible/deviceinfo/v;Z)Z
    //   1635: pop
    //   1636: aload_0
    //   1637: aload_0
    //   1638: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1641: invokevirtual 254	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   1644: putfield 583	com/tencent/mm/plugin/voip/video/camera/prev/c:zNY	Landroid/hardware/Camera$Parameters;
    //   1647: aload_0
    //   1648: getfield 583	com/tencent/mm/plugin/voip/video/camera/prev/c:zNY	Landroid/hardware/Camera$Parameters;
    //   1651: invokevirtual 587	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   1654: astore 18
    //   1656: aload 18
    //   1658: ifnull +24 -> 1682
    //   1661: aload_0
    //   1662: new 502	com/tencent/mm/compatible/deviceinfo/ac
    //   1665: dup
    //   1666: aload 18
    //   1668: getfield 389	android/hardware/Camera$Size:width	I
    //   1671: aload 18
    //   1673: getfield 392	android/hardware/Camera$Size:height	I
    //   1676: invokespecial 503	com/tencent/mm/compatible/deviceinfo/ac:<init>	(II)V
    //   1679: putfield 589	com/tencent/mm/plugin/voip/video/camera/prev/c:HjP	Lcom/tencent/mm/compatible/deviceinfo/ac;
    //   1682: iconst_0
    //   1683: istore_2
    //   1684: aload_0
    //   1685: getfield 583	com/tencent/mm/plugin/voip/video/camera/prev/c:zNY	Landroid/hardware/Camera$Parameters;
    //   1688: invokevirtual 592	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   1691: istore_3
    //   1692: iload_3
    //   1693: istore_2
    //   1694: aload_0
    //   1695: getstatic 595	com/tencent/mm/plugin/voip/video/camera/a/c:HjB	I
    //   1698: putfield 597	com/tencent/mm/plugin/voip/video/camera/prev/c:zOa	I
    //   1701: aload_0
    //   1702: getfield 597	com/tencent/mm/plugin/voip/video/camera/prev/c:zOa	I
    //   1705: ifgt +9 -> 1714
    //   1708: aload_0
    //   1709: bipush 7
    //   1711: putfield 597	com/tencent/mm/plugin/voip/video/camera/prev/c:zOa	I
    //   1714: aload_0
    //   1715: aload_0
    //   1716: getfield 420	com/tencent/mm/plugin/voip/video/camera/prev/c:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1719: invokespecial 600	com/tencent/mm/plugin/voip/video/camera/prev/c:i	(Lcom/tencent/mm/compatible/deviceinfo/v;)V
    //   1722: ldc 167
    //   1724: ldc_w 602
    //   1727: bipush 6
    //   1729: anewarray 171	java/lang/Object
    //   1732: dup
    //   1733: iconst_0
    //   1734: iload_2
    //   1735: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1738: aastore
    //   1739: dup
    //   1740: iconst_1
    //   1741: aload_0
    //   1742: getfield 589	com/tencent/mm/plugin/voip/video/camera/prev/c:HjP	Lcom/tencent/mm/compatible/deviceinfo/ac;
    //   1745: getfield 506	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   1748: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1751: aastore
    //   1752: dup
    //   1753: iconst_2
    //   1754: aload_0
    //   1755: getfield 589	com/tencent/mm/plugin/voip/video/camera/prev/c:HjP	Lcom/tencent/mm/compatible/deviceinfo/ac;
    //   1758: getfield 507	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   1761: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1764: aastore
    //   1765: dup
    //   1766: iconst_3
    //   1767: aload_0
    //   1768: getfield 597	com/tencent/mm/plugin/voip/video/camera/prev/c:zOa	I
    //   1771: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1774: aastore
    //   1775: dup
    //   1776: iconst_4
    //   1777: getstatic 605	com/tencent/mm/plugin/voip/video/camera/a/c:Hjz	I
    //   1780: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1783: aastore
    //   1784: dup
    //   1785: iconst_5
    //   1786: aload_0
    //   1787: getfield 97	com/tencent/mm/plugin/voip/video/camera/prev/c:zOj	I
    //   1790: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1793: aastore
    //   1794: invokestatic 315	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1797: ldc_w 413
    //   1800: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1803: iconst_1
    //   1804: ireturn
    //   1805: astore 18
    //   1807: getstatic 276	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   1810: ldc2_w 277
    //   1813: lconst_0
    //   1814: lconst_1
    //   1815: iconst_0
    //   1816: invokevirtual 282	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1819: ldc 167
    //   1821: ldc_w 607
    //   1824: iconst_1
    //   1825: anewarray 171	java/lang/Object
    //   1828: dup
    //   1829: iconst_0
    //   1830: aload 18
    //   1832: invokevirtual 535	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1835: aastore
    //   1836: invokestatic 537	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1839: ldc_w 413
    //   1842: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1845: iconst_m1
    //   1846: ireturn
    //   1847: astore 18
    //   1849: ldc 167
    //   1851: ldc_w 609
    //   1854: iconst_1
    //   1855: anewarray 171	java/lang/Object
    //   1858: dup
    //   1859: iconst_0
    //   1860: aload 18
    //   1862: invokevirtual 535	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1865: aastore
    //   1866: invokestatic 537	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1869: goto -175 -> 1694
    //   1872: astore 18
    //   1874: ldc 167
    //   1876: ldc_w 611
    //   1879: iconst_1
    //   1880: anewarray 171	java/lang/Object
    //   1883: dup
    //   1884: iconst_0
    //   1885: aload 18
    //   1887: invokevirtual 535	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1890: aastore
    //   1891: invokestatic 537	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1894: goto -172 -> 1722
    //   1897: astore 20
    //   1899: goto -421 -> 1478
    //   1902: goto -1311 -> 591
    //   1905: aconst_null
    //   1906: astore 19
    //   1908: goto -1362 -> 546
    //   1911: iload 4
    //   1913: istore 7
    //   1915: iload 6
    //   1917: istore 4
    //   1919: iload 7
    //   1921: istore 6
    //   1923: goto +32 -> 1955
    //   1926: iload 8
    //   1928: ifle -901 -> 1027
    //   1931: iload 7
    //   1933: ifle -906 -> 1027
    //   1936: iload 7
    //   1938: iload 8
    //   1940: if_icmplt -913 -> 1027
    //   1943: iconst_1
    //   1944: istore 17
    //   1946: goto -1629 -> 317
    //   1949: iconst_1
    //   1950: istore 4
    //   1952: goto -1569 -> 383
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
    //   1973: goto -873 -> 1100
    //   1976: iconst_0
    //   1977: istore 7
    //   1979: goto -706 -> 1273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1982	0	this	c
    //   0	1982	1	paramBoolean	boolean
    //   0	1982	2	paramInt1	int
    //   0	1982	3	paramInt2	int
    //   178	1794	4	i	int
    //   1093	225	5	j	int
    //   273	1695	6	k	int
    //   282	1696	7	m	int
    //   279	1662	8	n	int
    //   1088	872	9	i1	int
    //   1155	161	10	i2	int
    //   169	1185	11	i3	int
    //   1085	32	12	i4	int
    //   1211	82	13	i5	int
    //   1219	64	14	i6	int
    //   1240	21	15	i7	int
    //   31	1279	16	bool1	boolean
    //   27	1918	17	bool2	boolean
    //   161	718	18	localObject1	Object
    //   900	472	18	localException1	Exception
    //   1424	15	18	localException2	Exception
    //   1461	211	18	localObject2	Object
    //   1805	26	18	localException3	Exception
    //   1847	14	18	localException4	Exception
    //   1872	14	18	localException5	Exception
    //   205	564	19	localObject3	Object
    //   1000	374	19	localException6	Exception
    //   1390	15	19	localException7	Exception
    //   1906	1	19	localObject4	Object
    //   574	546	20	localObject5	Object
    //   1472	18	20	localException8	Exception
    //   1897	1	20	localException9	Exception
    //   481	994	21	arrayOfInt	int[]
    //   564	83	22	localPoint	Point
    // Exception table:
    //   from	to	target	type
    //   137	152	900	java/lang/Exception
    //   941	973	1000	java/lang/Exception
    //   973	992	1000	java/lang/Exception
    //   180	207	1390	java/lang/Exception
    //   207	237	1390	java/lang/Exception
    //   237	271	1390	java/lang/Exception
    //   284	314	1390	java/lang/Exception
    //   317	361	1390	java/lang/Exception
    //   1053	1060	1390	java/lang/Exception
    //   1065	1075	1390	java/lang/Exception
    //   1078	1087	1390	java/lang/Exception
    //   1119	1133	1390	java/lang/Exception
    //   1138	1145	1390	java/lang/Exception
    //   1157	1193	1390	java/lang/Exception
    //   1205	1242	1390	java/lang/Exception
    //   1278	1301	1390	java/lang/Exception
    //   1326	1378	1390	java/lang/Exception
    //   388	429	1424	java/lang/Exception
    //   546	576	1472	java/lang/Exception
    //   581	591	1472	java/lang/Exception
    //   599	624	1472	java/lang/Exception
    //   633	660	1472	java/lang/Exception
    //   660	679	1472	java/lang/Exception
    //   1636	1656	1805	java/lang/Exception
    //   1661	1682	1805	java/lang/Exception
    //   1684	1692	1847	java/lang/Exception
    //   1714	1722	1872	java/lang/Exception
    //   679	718	1897	java/lang/Exception
  }
  
  private static void h(v paramv)
  {
    AppMethodBeat.i(235886);
    try
    {
      localList = paramv.getParameters().getSupportedPreviewFrameRates();
      paramv = "supportFps:";
      localv = paramv;
      if (localList != null)
      {
        int i = 0;
        for (;;)
        {
          localv = paramv;
          if (i >= localList.size()) {
            break;
          }
          int j = ((Integer)localList.get(i)).intValue();
          paramv = paramv + j + ",";
          i += 1;
        }
      }
    }
    catch (Exception paramv)
    {
      v localv;
      for (;;)
      {
        Log.d("MicroMsg.Voip.CaptureRender", "getSupportedPreviewFrameRates:error:" + paramv.toString());
        List localList = null;
      }
      Log.i("MicroMsg.Voip.CaptureRender", localv);
      AppMethodBeat.o(235886);
    }
  }
  
  private void i(v paramv)
  {
    AppMethodBeat.i(235880);
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i;
    label70:
    label97:
    int k;
    int j;
    if (this.HjI)
    {
      i = com.tencent.mm.plugin.voip.video.camera.a.c.Hjx;
      Camera.getCameraInfo(i, localCameraInfo);
      switch (this.Hkd)
      {
      default: 
        i = 0;
        if (this.HjI)
        {
          i = (360 - (i + localCameraInfo.orientation) % 360) % 360;
          paramv.setDisplayOrientation(i);
          this.zOj = i;
          Log.i("MicroMsg.Voip.CaptureRender", "mIsCurrentFaceCamera is %s, %s,%s,%s,%s", new Object[] { Integer.valueOf(this.Hkd), Integer.valueOf(localCameraInfo.orientation), Integer.valueOf(i), Boolean.valueOf(this.HjI), Integer.valueOf(this.zOj) });
          if (!this.HjI) {
            break label304;
          }
          k = com.tencent.mm.plugin.voip.video.camera.a.c.Hjz;
          i = k;
          if (!ae.gKt.gFF) {
            break label350;
          }
          i = k;
          if (ae.gKt.gFE.dYT == 0) {
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
        this.HjJ = bool;
        if ((this.zOj != 90) && (j != 0)) {
          this.HjJ = false;
        }
        AppMethodBeat.o(235880);
        return;
        i = com.tencent.mm.plugin.voip.video.camera.a.c.Hjy;
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
        j = com.tencent.mm.plugin.voip.video.camera.a.c.HjA;
        i = j;
        if (!ae.gKt.gFH) {
          break label350;
        }
        i = j;
        if (ae.gKt.gFG.dYT == 0) {
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
  
  private v rO(boolean paramBoolean)
  {
    AppMethodBeat.i(235874);
    v localv = rP(paramBoolean);
    if (localv == null) {}
    for (;;)
    {
      try
      {
        localv = new v(Camera.open());
        this.HjI = false;
        h.CyF.idkeyStat(159L, 0L, 1L, false);
        h(localv);
        f(localv);
        AppMethodBeat.o(235874);
        return localv;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Voip.CaptureRender", "OpenCameraError:" + localException.toString());
        h.CyF.idkeyStat(159L, 0L, 1L, false);
        h.CyF.idkeyStat(159L, 1L, 1L, false);
        if (this.zOe != null) {
          this.zOe.cza();
        }
        AppMethodBeat.o(235874);
        return null;
      }
      this.HjI = paramBoolean;
    }
  }
  
  private static v rP(boolean paramBoolean)
  {
    localObject2 = null;
    AppMethodBeat.i(235873);
    if (com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx <= 0)
    {
      AppMethodBeat.o(235873);
      return null;
    }
    if (!com.tencent.mm.plugin.voip.video.camera.a.c.fLk())
    {
      AppMethodBeat.o(235873);
      return null;
    }
    if (paramBoolean == true) {}
    for (;;)
    {
      try
      {
        locala = d.a(MMApplicationContext.getContext(), com.tencent.mm.plugin.voip.video.camera.a.c.Hjx, null);
        Log.i("Camera", "Use front");
        localObject1 = localObject2;
        if (locala != null) {
          localObject1 = locala.gGr;
        }
      }
      catch (Exception localException)
      {
        d.a.a locala;
        h.CyF.idkeyStat(159L, 0L, 1L, false);
        h.CyF.idkeyStat(159L, 1L, 1L, false);
        Log.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + localException.toString());
        Object localObject1 = localObject2;
        continue;
      }
      AppMethodBeat.o(235873);
      return localObject1;
      locala = d.a(MMApplicationContext.getContext(), com.tencent.mm.plugin.voip.video.camera.a.c.Hjy, null);
      Log.i("Camera", "Use back");
    }
  }
  
  public final int a(com.tencent.mm.plugin.voip.video.camera.a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(235872);
    if (com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx <= 0)
    {
      this.HjO = 1;
      AppMethodBeat.o(235872);
      return -1;
    }
    if (paramBoolean) {
      if (!com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.HjX) {
        paramBoolean = false;
      }
    }
    int i;
    for (;;)
    {
      this.zOe = paramb;
      if (h(paramBoolean, this.mWidth, this.mHeight) > 0) {
        break;
      }
      i = h(paramBoolean, this.mWidth, this.mHeight);
      if (i > 0) {
        break;
      }
      this.HjO = 1;
      AppMethodBeat.o(235872);
      return i;
      if (!com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.HjY) {
        paramBoolean = true;
      }
    }
    this.HjI = paramBoolean;
    if (!g.fKg()) {}
    for (;;)
    {
      try
      {
        if ((this.sZb != null) && (this.zOb))
        {
          if ((this.HjP == null) || (this.HjP.height <= 0) || (this.HjP.width <= 0)) {
            continue;
          }
          int j = this.HjP.height * this.HjP.width * 3 / 2;
          if (this.zOi != null) {
            break label340;
          }
          this.zOi = new ArrayList(3);
          i = 0;
          if (i >= 3) {
            break label340;
          }
          this.zOi.add(new byte[j]);
          i += 1;
          continue;
          if (i < this.zOi.size())
          {
            if (this.sZb == null) {
              break label345;
            }
            this.sZb.addCallbackBuffer((byte[])this.zOi.get(i));
            break label345;
          }
          this.sZb.setPreviewCallbackWithBuffer(this.zOo);
        }
      }
      catch (Exception paramb)
      {
        Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", paramb, "setPreviewCallback error: %s", new Object[] { paramb.getMessage() });
        continue;
      }
      this.HjO = 0;
      AppMethodBeat.o(235872);
      return 1;
      this.sZb.setPreviewCallback(this.zOo);
      continue;
      j.fKE();
      continue;
      label340:
      i = 0;
      continue;
      label345:
      i += 1;
    }
  }
  
  public final boolean dEO()
  {
    return this.sZd;
  }
  
  public final void eoc()
  {
    AppMethodBeat.i(235883);
    Log.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.zOf);
    if ((this.zOf) && (this.sZb != null))
    {
      this.zOg = false;
      if (!this.sZb.gIJ) {
        this.sZb.setPreviewCallback(null);
      }
    }
    try
    {
      this.sZb.stopPreview();
      this.sZd = false;
      this.zOf = false;
      if (1 == this.HjO)
      {
        pl localpl = new pl();
        localpl.dVC.type = 2;
        EventCenter.instance.publish(localpl);
      }
      Log.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.zOb);
      if (this.zOb)
      {
        this.HjO = 0;
        this.zOg = false;
        if ((this.sZb != null) && (!this.sZb.gIJ))
        {
          if ((!g.fKg()) && (!this.sZb.gIJ)) {
            this.sZb.setPreviewCallback(null);
          }
          this.sZb.release();
        }
        this.sZb = null;
        this.zOb = false;
        this.zOh = null;
        if (this.zOi != null) {
          this.zOi.clear();
        }
        this.zOi = null;
        this.zOc = false;
        AppMethodBeat.o(235883);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.Voip.CaptureRender", "stopPreview:error" + localException.toString());
        continue;
        if (this.sZb != null)
        {
          if ((!g.fKg()) && (!this.sZb.gIJ)) {
            this.sZb.setPreviewCallback(null);
          }
          this.sZb.release();
          this.sZb = null;
          this.zOb = false;
        }
      }
    }
  }
  
  public final boolean fKY()
  {
    return this.HjI;
  }
  
  public final boolean fKZ()
  {
    return this.HjJ;
  }
  
  public final int fLa()
  {
    return this.HjO;
  }
  
  public final int fLb()
  {
    AppMethodBeat.i(235882);
    if (!this.zOb)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: failed without open camera");
      this.HjO = 1;
      AppMethodBeat.o(235882);
      return -1;
    }
    if (this.zOf)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "StartCapture: is in capture already ");
      AppMethodBeat.o(235882);
      return -1;
    }
    Log.d("MicroMsg.Voip.CaptureRender", "StartCapture now, isUesSurfacePreivew: %b", new Object[] { Boolean.valueOf(this.zOd) });
    if (this.mSurfaceTexture != null) {}
    try
    {
      this.sZb.setPreviewTexture(this.mSurfaceTexture);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          this.sZb.startPreview();
          this.sZd = true;
          if ((!g.fKg()) && (this.sZb != null)) {
            this.sZb.setPreviewCallback(this.zOo);
          }
          this.zOf = true;
          AppMethodBeat.o(235882);
          return 1;
          localException1 = localException1;
          h.CyF.idkeyStat(159L, 0L, 1L, false);
          h.CyF.idkeyStat(159L, 2L, 1L, false);
          this.HjO = 1;
          Log.e("MicroMsg.Voip.CaptureRender", "StartCapture:error:" + localException1.toString());
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          h.CyF.idkeyStat(159L, 0L, 1L, false);
          h.CyF.idkeyStat(159L, 2L, 1L, false);
          this.HjO = 1;
          if (this.zOe != null) {
            this.zOe.cza();
          }
          Log.e("MicroMsg.Voip.CaptureRender", "startPreview:error" + localException2.toString());
        }
      }
    }
  }
  
  public final ac fLc()
  {
    return this.HjP;
  }
  
  public final void fLd()
  {
    AppMethodBeat.i(235881);
    if (com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx < 2)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx);
      AppMethodBeat.o(235881);
      return;
    }
    Log.i("MicroMsg.Voip.CaptureRender", "ExchangeCapture start, gCameraNum= " + com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx);
    eoc();
    com.tencent.mm.plugin.voip.video.camera.a.b localb = this.zOe;
    if (!this.HjI) {}
    for (boolean bool = true;; bool = false)
    {
      a(localb, bool);
      fLb();
      com.tencent.mm.plugin.voip.c.fFg().adn(this.HjO);
      this.imy = true;
      AppMethodBeat.o(235881);
      return;
    }
  }
  
  public final int fLe()
  {
    boolean bool = true;
    int k;
    int i;
    int j;
    if (this.HjI)
    {
      k = com.tencent.mm.plugin.voip.video.camera.a.c.Hjz;
      i = k;
      if (!ae.gKt.gFF) {
        break label133;
      }
      i = k;
      if (ae.gKt.gFE.dYT == 0) {
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
        this.HjJ = bool;
        if (!this.HjJ) {
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
        j = com.tencent.mm.plugin.voip.video.camera.a.c.HjA;
        i = j;
        if (!ae.gKt.gFH) {
          break label133;
        }
        i = j;
        if (ae.gKt.gFG.dYT == 0) {
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
  
  public final boolean fLf()
  {
    boolean bool = false;
    if (this.HjI) {}
    for (int i = OpenGlRender.FLAG_Mirror;; i = 0)
    {
      if (i == OpenGlRender.FLAG_Mirror) {
        bool = true;
      }
      return bool;
    }
  }
  
  public final void fLg()
  {
    AppMethodBeat.i(235879);
    try
    {
      if (this.sZb != null) {
        i(this.sZb);
      }
      AppMethodBeat.o(235879);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "setDisplayOrientation failed: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(235879);
    }
  }
  
  public final int fLh()
  {
    return this.zOj;
  }
  
  @TargetApi(14)
  public final void fLi()
  {
    boolean bool3 = true;
    AppMethodBeat.i(235884);
    if ((ae.gKt.gGg == 1) && (this.zOc))
    {
      AppMethodBeat.o(235884);
      return;
    }
    if (ae.gKt.gGf > 2000) {
      this.zNW = ae.gKt.gGf;
    }
    Log.e("MicroMsg.Voip.CaptureRender", "focusOnFace error, faceLocation is null");
    StringBuilder localStringBuilder;
    boolean bool2;
    if (System.currentTimeMillis() - this.HjN > this.zNW)
    {
      bool1 = true;
      localStringBuilder = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
      if (this.HjK) {
        break label266;
      }
      bool2 = true;
      label102:
      localStringBuilder = localStringBuilder.append(bool2).append(",isAutoFocusTimeout: ").append(bool1).append(",mAutoFocusTimeOut:").append(this.zNW).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
      if (this.HjL == this.HjI) {
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
        if ((this.sZb != null) && (this.sZb.getParameters() != null) && (this.sZb.getParameters().getFocusMode() != null) && (this.sZb.getParameters().getFocusMode().equals("auto")))
        {
          this.sZb.autoFocus(null);
          this.HjS = null;
          this.HjN = System.currentTimeMillis();
          this.HjK = true;
          this.HjL = this.HjI;
        }
        AppMethodBeat.o(235884);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Voip.CaptureRender", "mCamera.getParameters() or autoFocus fail!" + localException.toString());
        AppMethodBeat.o(235884);
      }
      bool1 = false;
      break;
      bool2 = false;
      break label102;
    }
  }
  
  public final void onOrientationChange(int paramInt)
  {
    this.Hkd = paramInt;
  }
  
  public final void q(SurfaceTexture paramSurfaceTexture)
  {
    this.mSurfaceTexture = paramSurfaceTexture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.prev.c
 * JD-Core Version:    0.7.0.1
 */