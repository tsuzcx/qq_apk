package com.tencent.mm.plugin.voip.video.camera.prev;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class a
  implements com.tencent.mm.plugin.video.a, com.tencent.mm.plugin.video.b
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
  protected ObservableSurfaceView HjQ;
  protected ObservableTextureView HjR;
  protected int[] HjS;
  protected int HjT;
  protected boolean imy;
  protected int mHeight;
  protected int mWidth;
  protected v sZb;
  protected boolean sZd;
  protected long zNW;
  protected Camera.Parameters zNY;
  protected int zOa;
  protected boolean zOb;
  protected boolean zOc;
  protected boolean zOd;
  protected com.tencent.mm.plugin.voip.video.camera.a.b zOe;
  protected boolean zOf;
  protected boolean zOg;
  protected byte[] zOh;
  protected List<byte[]> zOi;
  protected int zOj;
  protected int zOk;
  protected int zOl;
  protected boolean zOm;
  private byte[] zOn;
  Camera.PreviewCallback zOo;
  
  static
  {
    AppMethodBeat.i(235865);
    zOp = Pattern.compile(",");
    irq = 20;
    irs = 70;
    AppMethodBeat.o(235865);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235846);
    this.HjI = false;
    this.HjJ = false;
    this.HjK = false;
    this.HjL = false;
    this.HjM = false;
    this.HjN = 0L;
    this.zNW = 30000L;
    this.HjO = 0;
    this.zOb = false;
    this.zOc = false;
    this.zOd = false;
    this.HjQ = null;
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
        AppMethodBeat.i(235845);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          h.CyF.idkeyStat(159L, 0L, 1L, false);
          h.CyF.idkeyStat(159L, 3L, 1L, false);
          if (a.this.zOe != null) {
            a.this.zOe.cza();
          }
          AppMethodBeat.o(235845);
          return;
        }
        if (a.this.HjP == null)
        {
          Log.e("MicroMsg.Voip.CaptureRender", "onPreviewFrame mSize is null");
          AppMethodBeat.o(235845);
          return;
        }
        int m;
        int i;
        int k;
        int j;
        if (a.this.zOe != null)
        {
          if ((a.a(a.this) == null) || (a.a(a.this).length != paramAnonymousArrayOfByte.length)) {
            a.a(a.this, new byte[paramAnonymousArrayOfByte.length]);
          }
          System.arraycopy(paramAnonymousArrayOfByte, 0, a.a(a.this), 0, paramAnonymousArrayOfByte.length);
          m = 1;
          if (a.this.HjI)
          {
            i = com.tencent.mm.plugin.voip.video.camera.a.c.Hjz;
            k = i;
            if (!ae.gKt.gFF) {
              break label609;
            }
            k = i;
            if (ae.gKt.gFE.dYT == 0) {
              break label609;
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
            paramAnonymousCamera = a.this;
            if ((i != 0) || (k <= 0)) {
              break label516;
            }
            bool = true;
            label241:
            paramAnonymousCamera.HjJ = bool;
            k = a.this.HjP.width;
            int n = a.this.HjP.height;
            if ((i == 0) || (a.this.cyZ())) {
              break label522;
            }
            if (a.this.zOh == null)
            {
              i = k * n * 3 / 2;
              a.this.zOh = new byte[i];
              a.this.zOh[0] = 90;
            }
            com.tencent.mm.plugin.voip.c.fFg().a(a.a(a.this), a.a(a.this).length, k, n, a.this.zOa, a.this.zOh, a.this.zOh.length, k, n, j);
            a.this.zOe.a(a.this.zOh, a.this.zOh.length, k, n, a.this.zOa, m);
          }
          for (;;)
          {
            if (m.getApiLevel() >= 8)
            {
              if (a.this.sZb == null)
              {
                Log.e("MicroMsg.Voip.CaptureRender", "the camera is null and has been release");
                AppMethodBeat.o(235845);
                return;
                j = com.tencent.mm.plugin.voip.video.camera.a.c.HjA;
                k = j;
                if (!ae.gKt.gFH) {
                  break label609;
                }
                k = j;
                if (ae.gKt.gFG.dYT == 0) {
                  break label609;
                }
                m = ae.gKt.gFG.gGp;
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
                a.this.zOe.a(a.a(a.this), a.a(a.this).length, a.this.HjP.width, a.this.HjP.height, a.this.zOa, m);
                continue;
              }
              if (a.this.sZb != null) {
                a.this.sZb.addCallbackBuffer(paramAnonymousArrayOfByte);
              }
            }
          }
          AppMethodBeat.o(235845);
          return;
          label609:
          i = 0;
          j = m;
        }
      }
    };
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    com.tencent.mm.plugin.voip.video.camera.a.c.hH(MMApplicationContext.getContext().getApplicationContext());
    Log.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
    AppMethodBeat.o(235846);
  }
  
  private static Point a(CharSequence paramCharSequence, Point paramPoint)
  {
    AppMethodBeat.i(235857);
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
        AppMethodBeat.o(235857);
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
      AppMethodBeat.o(235857);
      return null;
      label274:
      k = j;
      int n = i;
    }
  }
  
  private static boolean a(v paramv, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235855);
    if (paramv == null)
    {
      AppMethodBeat.o(235855);
      return false;
    }
    try
    {
      Camera.Parameters localParameters = paramv.getParameters();
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        localParameters.setPreviewSize(paramInt1, paramInt2);
      }
      paramv.setParameters(localParameters);
      AppMethodBeat.o(235855);
      return true;
    }
    catch (Exception paramv)
    {
      h.CyF.idkeyStat(159L, 0L, 1L, false);
      Log.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + paramv.toString());
      AppMethodBeat.o(235855);
    }
    return false;
  }
  
  private boolean b(v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(235856);
    if (paramv == null)
    {
      AppMethodBeat.o(235856);
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
      AppMethodBeat.o(235856);
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
      AppMethodBeat.o(235856);
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
  
  private void eoa()
  {
    AppMethodBeat.i(235852);
    for (;;)
    {
      try
      {
        if ((this.sZb != null) && (this.zOb))
        {
          if ((this.HjP != null) && (this.HjP.height > 0) && (this.HjP.width > 0))
          {
            int j = this.HjP.height * this.HjP.width * 3 / 2;
            if (this.zOi == null)
            {
              this.zOi = new ArrayList(3);
              i = 0;
              if (i < 3)
              {
                this.zOi.add(new byte[j]);
                i += 1;
                continue;
                if (i < this.zOi.size())
                {
                  if (this.sZb == null) {
                    break label225;
                  }
                  this.sZb.addCallbackBuffer((byte[])this.zOi.get(i));
                  break label225;
                }
                this.sZb.setPreviewCallbackWithBuffer(this.zOo);
                AppMethodBeat.o(235852);
              }
            }
          }
          else
          {
            this.sZb.setPreviewCallback(this.zOo);
          }
        }
        else
        {
          AppMethodBeat.o(235852);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Voip.CaptureRender", localException, "setPreviewCallback error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(235852);
        return;
      }
      int i = 0;
      continue;
      label225:
      i += 1;
    }
  }
  
  private int f(v paramv)
  {
    AppMethodBeat.i(235863);
    if (paramv == null)
    {
      AppMethodBeat.o(235863);
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
      AppMethodBeat.o(235863);
      return i;
    }
  }
  
  /* Error */
  private int h(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 448
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 172
    //   8: ldc_w 450
    //   11: iload_1
    //   12: invokestatic 453	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   15: invokevirtual 215	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 118	com/tencent/mm/plugin/voip/video/camera/prev/a:zOc	Z
    //   26: iconst_1
    //   27: istore 17
    //   29: iload 17
    //   31: istore 16
    //   33: aload_0
    //   34: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   37: ifnull +52 -> 89
    //   40: aload_0
    //   41: getfield 98	com/tencent/mm/plugin/voip/video/camera/prev/a:HjI	Z
    //   44: iload_1
    //   45: if_icmpeq +78 -> 123
    //   48: aload_0
    //   49: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   52: getfield 456	com/tencent/mm/compatible/deviceinfo/v:gIJ	Z
    //   55: ifne +11 -> 66
    //   58: aload_0
    //   59: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   62: aconst_null
    //   63: invokevirtual 410	com/tencent/mm/compatible/deviceinfo/v:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   66: aload_0
    //   67: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   70: invokevirtual 459	com/tencent/mm/compatible/deviceinfo/v:stopPreview	()V
    //   73: aload_0
    //   74: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   77: invokevirtual 462	com/tencent/mm/compatible/deviceinfo/v:release	()V
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   85: iload 17
    //   87: istore 16
    //   89: iload 16
    //   91: ifeq +46 -> 137
    //   94: aload_0
    //   95: aload_0
    //   96: iload_1
    //   97: invokespecial 466	com/tencent/mm/plugin/voip/video/camera/prev/a:rO	(Z)Lcom/tencent/mm/compatible/deviceinfo/v;
    //   100: putfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   103: aload_0
    //   104: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   107: ifnonnull +25 -> 132
    //   110: aload_0
    //   111: iconst_0
    //   112: putfield 116	com/tencent/mm/plugin/voip/video/camera/prev/a:zOb	Z
    //   115: ldc_w 448
    //   118: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iconst_m1
    //   122: ireturn
    //   123: aload_0
    //   124: getfield 146	com/tencent/mm/plugin/voip/video/camera/prev/a:zOm	Z
    //   127: istore 16
    //   129: goto -40 -> 89
    //   132: aload_0
    //   133: iconst_0
    //   134: putfield 146	com/tencent/mm/plugin/voip/video/camera/prev/a:zOm	Z
    //   137: aload_0
    //   138: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   141: ifnull +11 -> 152
    //   144: aload_0
    //   145: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   148: invokevirtual 257	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   151: pop
    //   152: aload_0
    //   153: iconst_1
    //   154: putfield 116	com/tencent/mm/plugin/voip/video/camera/prev/a:zOb	Z
    //   157: aload_0
    //   158: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   161: astore 18
    //   163: getstatic 470	com/tencent/mm/plugin/voip/video/camera/a/c:Hjw	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   166: getfield 475	com/tencent/mm/plugin/voip/video/camera/prev/b:HjW	I
    //   169: istore 11
    //   171: aload 18
    //   173: ifnull +256 -> 429
    //   176: bipush 26
    //   178: istore 4
    //   180: ldc 172
    //   182: ldc_w 477
    //   185: iconst_1
    //   186: anewarray 4	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: iload 11
    //   193: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: aastore
    //   197: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload 18
    //   202: invokevirtual 257	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   205: astore 19
    //   207: invokestatic 480	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMainProcess	()Z
    //   210: ifeq +27 -> 237
    //   213: ldc_w 482
    //   216: invokestatic 488	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   219: checkcast 482	com/tencent/mm/plugin/zero/b/a
    //   222: invokeinterface 492 1 0
    //   227: ldc_w 494
    //   230: bipush 26
    //   232: invokevirtual 497	com/tencent/mm/n/f:getInt	(Ljava/lang/String;I)I
    //   235: istore 4
    //   237: ldc 172
    //   239: ldc_w 499
    //   242: iconst_1
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: iload 4
    //   250: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: aastore
    //   254: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: invokestatic 504	com/tencent/mm/compatible/util/k:alh	()Z
    //   260: ifne +11 -> 271
    //   263: iload 4
    //   265: invokestatic 510	com/tencent/mm/compatible/util/d:oD	(I)Z
    //   268: ifeq +1114 -> 1382
    //   271: ldc 192
    //   273: istore 6
    //   275: iconst_0
    //   276: istore 16
    //   278: iconst_m1
    //   279: istore 8
    //   281: iconst_0
    //   282: istore 7
    //   284: getstatic 351	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   287: ifnull +1752 -> 2039
    //   290: getstatic 351	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   293: getfield 513	com/tencent/mm/compatible/deviceinfo/c:gGk	I
    //   296: sipush 1000
    //   299: imul
    //   300: istore 8
    //   302: getstatic 351	com/tencent/mm/compatible/deviceinfo/ae:gKt	Lcom/tencent/mm/compatible/deviceinfo/c;
    //   305: getfield 516	com/tencent/mm/compatible/deviceinfo/c:gGl	I
    //   308: sipush 1000
    //   311: imul
    //   312: istore 7
    //   314: goto +1725 -> 2039
    //   317: ldc 172
    //   319: ldc_w 518
    //   322: iconst_4
    //   323: anewarray 4	java/lang/Object
    //   326: dup
    //   327: iconst_0
    //   328: iload 8
    //   330: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: iload 7
    //   338: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   341: aastore
    //   342: dup
    //   343: iconst_2
    //   344: iload 11
    //   346: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: aastore
    //   350: dup
    //   351: iconst_3
    //   352: iload 17
    //   354: invokestatic 308	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   357: aastore
    //   358: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   361: iload 8
    //   363: ldc 192
    //   365: if_icmpeq +15 -> 380
    //   368: iload 7
    //   370: ldc 192
    //   372: if_icmpeq +8 -> 380
    //   375: iload 17
    //   377: ifne +947 -> 1324
    //   380: iconst_1
    //   381: istore 4
    //   383: iload 4
    //   385: ifeq +44 -> 429
    //   388: ldc 172
    //   390: ldc_w 520
    //   393: iconst_1
    //   394: anewarray 4	java/lang/Object
    //   397: dup
    //   398: iconst_0
    //   399: iload 11
    //   401: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   404: aastore
    //   405: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   408: aload 18
    //   410: invokevirtual 257	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   413: astore 19
    //   415: aload 19
    //   417: iload 11
    //   419: invokevirtual 523	android/hardware/Camera$Parameters:setPreviewFrameRate	(I)V
    //   422: aload 18
    //   424: aload 19
    //   426: invokevirtual 266	com/tencent/mm/compatible/deviceinfo/v:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   429: ldc 172
    //   431: new 280	java/lang/StringBuilder
    //   434: dup
    //   435: ldc_w 525
    //   438: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   441: iload_2
    //   442: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc 75
    //   447: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: iload_3
    //   451: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   454: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: iload_1
    //   461: ifeq +992 -> 1453
    //   464: getstatic 470	com/tencent/mm/plugin/voip/video/camera/a/c:Hjw	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   467: getfield 529	com/tencent/mm/plugin/voip/video/camera/prev/b:Hkb	Landroid/graphics/Point;
    //   470: astore 18
    //   472: aload 18
    //   474: ifnull +990 -> 1464
    //   477: iconst_1
    //   478: istore 4
    //   480: aconst_null
    //   481: astore 21
    //   483: aload 18
    //   485: ifnull +1533 -> 2018
    //   488: new 379	com/tencent/mm/compatible/deviceinfo/ac
    //   491: dup
    //   492: aload 18
    //   494: getfield 237	android/graphics/Point:x	I
    //   497: aload 18
    //   499: getfield 245	android/graphics/Point:y	I
    //   502: invokespecial 530	com/tencent/mm/compatible/deviceinfo/ac:<init>	(II)V
    //   505: astore 19
    //   507: ldc 172
    //   509: new 280	java/lang/StringBuilder
    //   512: dup
    //   513: ldc_w 532
    //   516: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   519: aload 19
    //   521: getfield 385	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   524: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   527: ldc 75
    //   529: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload 19
    //   534: getfield 382	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   537: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   540: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   546: aload_0
    //   547: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   550: invokevirtual 257	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   553: astore 18
    //   555: new 234	android/graphics/Point
    //   558: dup
    //   559: iload_2
    //   560: iload_3
    //   561: invokespecial 247	android/graphics/Point:<init>	(II)V
    //   564: astore 22
    //   566: aload 18
    //   568: ldc_w 534
    //   571: invokevirtual 536	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   574: astore 20
    //   576: aload 20
    //   578: ifnonnull +1437 -> 2015
    //   581: aload 18
    //   583: ldc_w 538
    //   586: invokevirtual 536	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   589: astore 20
    //   591: aconst_null
    //   592: astore 18
    //   594: aload 20
    //   596: ifnull +28 -> 624
    //   599: ldc 172
    //   601: ldc_w 540
    //   604: aload 20
    //   606: invokestatic 211	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   609: invokevirtual 215	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   612: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   615: aload 20
    //   617: aload 22
    //   619: invokestatic 542	com/tencent/mm/plugin/voip/video/camera/prev/a:a	(Ljava/lang/CharSequence;Landroid/graphics/Point;)Landroid/graphics/Point;
    //   622: astore 18
    //   624: aload 18
    //   626: astore 20
    //   628: aload 18
    //   630: ifnonnull +30 -> 660
    //   633: new 234	android/graphics/Point
    //   636: dup
    //   637: aload 22
    //   639: getfield 237	android/graphics/Point:x	I
    //   642: iconst_3
    //   643: ishr
    //   644: iconst_3
    //   645: ishl
    //   646: aload 22
    //   648: getfield 245	android/graphics/Point:y	I
    //   651: iconst_3
    //   652: ishr
    //   653: iconst_3
    //   654: ishl
    //   655: invokespecial 247	android/graphics/Point:<init>	(II)V
    //   658: astore 20
    //   660: new 379	com/tencent/mm/compatible/deviceinfo/ac
    //   663: dup
    //   664: aload 20
    //   666: getfield 237	android/graphics/Point:x	I
    //   669: aload 20
    //   671: getfield 245	android/graphics/Point:y	I
    //   674: invokespecial 530	com/tencent/mm/compatible/deviceinfo/ac:<init>	(II)V
    //   677: astore 18
    //   679: ldc 172
    //   681: new 280	java/lang/StringBuilder
    //   684: dup
    //   685: ldc_w 544
    //   688: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   691: aload 18
    //   693: getfield 385	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   696: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   699: ldc 75
    //   701: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 18
    //   706: getfield 382	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   709: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   712: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   718: iload 4
    //   720: ifeq +779 -> 1499
    //   723: aload_0
    //   724: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   727: aload 19
    //   729: getfield 385	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   732: aload 19
    //   734: getfield 382	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   737: invokestatic 546	com/tencent/mm/plugin/voip/video/camera/prev/a:a	(Lcom/tencent/mm/compatible/deviceinfo/v;II)Z
    //   740: istore_1
    //   741: ldc 172
    //   743: new 280	java/lang/StringBuilder
    //   746: dup
    //   747: ldc_w 548
    //   750: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   753: aload 19
    //   755: getfield 385	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   758: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   761: ldc_w 550
    //   764: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: aload 19
    //   769: getfield 382	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   772: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   775: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   781: iload_1
    //   782: ifne +838 -> 1620
    //   785: aload 18
    //   787: ifnull +833 -> 1620
    //   790: ldc 172
    //   792: new 280	java/lang/StringBuilder
    //   795: dup
    //   796: ldc_w 552
    //   799: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   802: aload 18
    //   804: getfield 385	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   807: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   810: ldc_w 550
    //   813: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: aload 18
    //   818: getfield 382	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   821: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   824: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload_0
    //   831: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   834: aload 18
    //   836: getfield 385	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   839: aload 18
    //   841: getfield 382	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   844: invokestatic 546	com/tencent/mm/plugin/voip/video/camera/prev/a:a	(Lcom/tencent/mm/compatible/deviceinfo/v;II)Z
    //   847: ifne +773 -> 1620
    //   850: ldc 172
    //   852: new 280	java/lang/StringBuilder
    //   855: dup
    //   856: ldc_w 554
    //   859: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   862: aload 18
    //   864: getfield 385	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   867: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   870: ldc_w 550
    //   873: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: aload 18
    //   878: getfield 382	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   881: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   884: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   890: ldc_w 448
    //   893: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   896: iconst_m1
    //   897: ireturn
    //   898: astore 18
    //   900: getstatic 272	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   903: ldc2_w 273
    //   906: lconst_0
    //   907: lconst_1
    //   908: iconst_0
    //   909: invokevirtual 278	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   912: ldc 172
    //   914: ldc_w 556
    //   917: iconst_1
    //   918: anewarray 4	java/lang/Object
    //   921: dup
    //   922: iconst_0
    //   923: aload 18
    //   925: invokevirtual 415	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   928: aastore
    //   929: invokestatic 558	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   932: aload_0
    //   933: getfield 560	com/tencent/mm/plugin/voip/video/camera/prev/a:zOe	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   936: ifnull +54 -> 990
    //   939: aload_0
    //   940: getfield 560	com/tencent/mm/plugin/voip/video/camera/prev/a:zOe	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   943: invokeinterface 565 1 0
    //   948: aload_0
    //   949: iconst_1
    //   950: putfield 146	com/tencent/mm/plugin/voip/video/camera/prev/a:zOm	Z
    //   953: aload_0
    //   954: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   957: getfield 456	com/tencent/mm/compatible/deviceinfo/v:gIJ	Z
    //   960: ifne +11 -> 971
    //   963: aload_0
    //   964: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   967: aconst_null
    //   968: invokevirtual 410	com/tencent/mm/compatible/deviceinfo/v:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   971: aload_0
    //   972: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   975: invokevirtual 459	com/tencent/mm/compatible/deviceinfo/v:stopPreview	()V
    //   978: aload_0
    //   979: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   982: invokevirtual 462	com/tencent/mm/compatible/deviceinfo/v:release	()V
    //   985: aload_0
    //   986: aconst_null
    //   987: putfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   990: ldc_w 448
    //   993: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   996: iconst_m1
    //   997: ireturn
    //   998: astore 19
    //   1000: ldc 172
    //   1002: aload 19
    //   1004: ldc_w 567
    //   1007: iconst_1
    //   1008: anewarray 4	java/lang/Object
    //   1011: dup
    //   1012: iconst_0
    //   1013: aload 18
    //   1015: invokevirtual 415	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1018: aastore
    //   1019: invokestatic 419	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1022: goto -32 -> 990
    //   1025: iload 8
    //   1027: ifne +24 -> 1051
    //   1030: iload 7
    //   1032: ifne +19 -> 1051
    //   1035: iconst_0
    //   1036: istore 17
    //   1038: ldc_w 568
    //   1041: istore 7
    //   1043: ldc_w 568
    //   1046: istore 8
    //   1048: goto -731 -> 317
    //   1051: aload 19
    //   1053: invokevirtual 571	android/hardware/Camera$Parameters:getSupportedPreviewFpsRange	()Ljava/util/List;
    //   1056: astore 20
    //   1058: aload 20
    //   1060: ifnull +1002 -> 2062
    //   1063: aload 20
    //   1065: invokeinterface 322 1 0
    //   1070: ifne +6 -> 1076
    //   1073: goto +989 -> 2062
    //   1076: aload 20
    //   1078: invokeinterface 322 1 0
    //   1083: istore 12
    //   1085: iconst_0
    //   1086: istore 9
    //   1088: ldc_w 568
    //   1091: istore 5
    //   1093: ldc_w 568
    //   1096: istore 4
    //   1098: iload 16
    //   1100: istore 17
    //   1102: iload 5
    //   1104: istore 7
    //   1106: iload 4
    //   1108: istore 8
    //   1110: iload 9
    //   1112: iload 12
    //   1114: if_icmpge -797 -> 317
    //   1117: aload 20
    //   1119: iload 9
    //   1121: invokeinterface 398 2 0
    //   1126: checkcast 572	[I
    //   1129: astore 21
    //   1131: aload 21
    //   1133: ifnull +891 -> 2024
    //   1136: aload 21
    //   1138: arraylength
    //   1139: iconst_1
    //   1140: if_icmple +884 -> 2024
    //   1143: aload 21
    //   1145: iconst_0
    //   1146: iaload
    //   1147: istore 8
    //   1149: aload 21
    //   1151: iconst_1
    //   1152: iaload
    //   1153: istore 10
    //   1155: ldc 172
    //   1157: ldc_w 574
    //   1160: iconst_3
    //   1161: anewarray 4	java/lang/Object
    //   1164: dup
    //   1165: iconst_0
    //   1166: iload 9
    //   1168: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1171: aastore
    //   1172: dup
    //   1173: iconst_1
    //   1174: iload 8
    //   1176: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1179: aastore
    //   1180: dup
    //   1181: iconst_2
    //   1182: iload 10
    //   1184: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1187: aastore
    //   1188: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1191: iload 8
    //   1193: iflt +831 -> 2024
    //   1196: iload 10
    //   1198: iload 8
    //   1200: if_icmplt +824 -> 2024
    //   1203: iload 10
    //   1205: sipush 1000
    //   1208: idiv
    //   1209: istore 13
    //   1211: iload 8
    //   1213: sipush 1000
    //   1216: idiv
    //   1217: istore 14
    //   1219: iload 11
    //   1221: iconst_5
    //   1222: iadd
    //   1223: bipush 30
    //   1225: invokestatic 578	java/lang/Math:min	(II)I
    //   1228: istore 7
    //   1230: iload 11
    //   1232: iconst_5
    //   1233: isub
    //   1234: iconst_5
    //   1235: invokestatic 581	java/lang/Math:max	(II)I
    //   1238: istore 15
    //   1240: iload 13
    //   1242: iload 15
    //   1244: if_icmplt +845 -> 2089
    //   1247: iload 13
    //   1249: iload 7
    //   1251: if_icmpgt +838 -> 2089
    //   1254: iload 14
    //   1256: iload 15
    //   1258: if_icmplt +831 -> 2089
    //   1261: iload 14
    //   1263: iload 7
    //   1265: if_icmpgt +824 -> 2089
    //   1268: iconst_1
    //   1269: istore 7
    //   1271: iload 7
    //   1273: ifeq +751 -> 2024
    //   1276: iload 11
    //   1278: iload 14
    //   1280: isub
    //   1281: invokestatic 242	java/lang/Math:abs	(I)I
    //   1284: istore 7
    //   1286: iload 13
    //   1288: iload 11
    //   1290: isub
    //   1291: invokestatic 242	java/lang/Math:abs	(I)I
    //   1294: iload 7
    //   1296: iadd
    //   1297: istore 7
    //   1299: iload 7
    //   1301: iload 6
    //   1303: if_icmpge +721 -> 2024
    //   1306: iconst_1
    //   1307: istore 16
    //   1309: iload 7
    //   1311: istore 4
    //   1313: iload 10
    //   1315: istore 5
    //   1317: iload 8
    //   1319: istore 6
    //   1321: goto +747 -> 2068
    //   1324: ldc 172
    //   1326: ldc_w 583
    //   1329: iconst_3
    //   1330: anewarray 4	java/lang/Object
    //   1333: dup
    //   1334: iconst_0
    //   1335: iload 8
    //   1337: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1340: aastore
    //   1341: dup
    //   1342: iconst_1
    //   1343: iload 7
    //   1345: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1348: aastore
    //   1349: dup
    //   1350: iconst_2
    //   1351: iload 11
    //   1353: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1356: aastore
    //   1357: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1360: aload 19
    //   1362: iload 8
    //   1364: iload 7
    //   1366: invokevirtual 586	android/hardware/Camera$Parameters:setPreviewFpsRange	(II)V
    //   1369: aload 18
    //   1371: aload 19
    //   1373: invokevirtual 266	com/tencent/mm/compatible/deviceinfo/v:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   1376: iconst_0
    //   1377: istore 4
    //   1379: goto -996 -> 383
    //   1382: iconst_1
    //   1383: istore 4
    //   1385: goto -1002 -> 383
    //   1388: astore 19
    //   1390: ldc 172
    //   1392: new 280	java/lang/StringBuilder
    //   1395: dup
    //   1396: ldc_w 588
    //   1399: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1402: aload 19
    //   1404: invokevirtual 288	java/lang/Exception:toString	()Ljava/lang/String;
    //   1407: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1413: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1416: iconst_1
    //   1417: istore 4
    //   1419: goto -1036 -> 383
    //   1422: astore 18
    //   1424: ldc 172
    //   1426: new 280	java/lang/StringBuilder
    //   1429: dup
    //   1430: ldc_w 590
    //   1433: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1436: aload 18
    //   1438: invokevirtual 288	java/lang/Exception:toString	()Ljava/lang/String;
    //   1441: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1444: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1450: goto -1021 -> 429
    //   1453: getstatic 470	com/tencent/mm/plugin/voip/video/camera/a/c:Hjw	Lcom/tencent/mm/plugin/voip/video/camera/prev/b;
    //   1456: getfield 593	com/tencent/mm/plugin/voip/video/camera/prev/b:Hkc	Landroid/graphics/Point;
    //   1459: astore 18
    //   1461: goto -989 -> 472
    //   1464: iconst_0
    //   1465: istore 4
    //   1467: goto -987 -> 480
    //   1470: astore 20
    //   1472: aload 21
    //   1474: astore 18
    //   1476: ldc 172
    //   1478: ldc_w 595
    //   1481: iconst_1
    //   1482: anewarray 4	java/lang/Object
    //   1485: dup
    //   1486: iconst_0
    //   1487: aload 20
    //   1489: invokevirtual 415	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1492: aastore
    //   1493: invokestatic 558	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1496: goto -778 -> 718
    //   1499: ldc 172
    //   1501: ldc_w 597
    //   1504: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1507: aload 18
    //   1509: ifnull +111 -> 1620
    //   1512: ldc 172
    //   1514: new 280	java/lang/StringBuilder
    //   1517: dup
    //   1518: ldc_w 599
    //   1521: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1524: aload 18
    //   1526: getfield 385	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   1529: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1532: ldc_w 550
    //   1535: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: aload 18
    //   1540: getfield 382	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   1543: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1546: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1549: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1552: aload_0
    //   1553: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1556: aload 18
    //   1558: getfield 385	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   1561: aload 18
    //   1563: getfield 382	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   1566: invokestatic 546	com/tencent/mm/plugin/voip/video/camera/prev/a:a	(Lcom/tencent/mm/compatible/deviceinfo/v;II)Z
    //   1569: ifne +51 -> 1620
    //   1572: ldc 172
    //   1574: new 280	java/lang/StringBuilder
    //   1577: dup
    //   1578: ldc_w 601
    //   1581: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1584: aload 18
    //   1586: getfield 385	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   1589: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1592: ldc_w 550
    //   1595: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1598: aload 18
    //   1600: getfield 382	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   1603: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1606: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1609: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1612: ldc_w 448
    //   1615: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1618: iconst_m1
    //   1619: ireturn
    //   1620: aload_0
    //   1621: aload_0
    //   1622: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1625: aload_0
    //   1626: getfield 98	com/tencent/mm/plugin/voip/video/camera/prev/a:HjI	Z
    //   1629: invokespecial 603	com/tencent/mm/plugin/voip/video/camera/prev/a:b	(Lcom/tencent/mm/compatible/deviceinfo/v;Z)Z
    //   1632: pop
    //   1633: aload_0
    //   1634: aload_0
    //   1635: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1638: invokevirtual 257	com/tencent/mm/compatible/deviceinfo/v:getParameters	()Landroid/hardware/Camera$Parameters;
    //   1641: putfield 605	com/tencent/mm/plugin/voip/video/camera/prev/a:zNY	Landroid/hardware/Camera$Parameters;
    //   1644: aload_0
    //   1645: getfield 605	com/tencent/mm/plugin/voip/video/camera/prev/a:zNY	Landroid/hardware/Camera$Parameters;
    //   1648: invokevirtual 609	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   1651: astore 18
    //   1653: aload 18
    //   1655: ifnull +24 -> 1679
    //   1658: aload_0
    //   1659: new 379	com/tencent/mm/compatible/deviceinfo/ac
    //   1662: dup
    //   1663: aload 18
    //   1665: getfield 430	android/hardware/Camera$Size:width	I
    //   1668: aload 18
    //   1670: getfield 431	android/hardware/Camera$Size:height	I
    //   1673: invokespecial 530	com/tencent/mm/compatible/deviceinfo/ac:<init>	(II)V
    //   1676: putfield 377	com/tencent/mm/plugin/voip/video/camera/prev/a:HjP	Lcom/tencent/mm/compatible/deviceinfo/ac;
    //   1679: aload_0
    //   1680: getfield 605	com/tencent/mm/plugin/voip/video/camera/prev/a:zNY	Landroid/hardware/Camera$Parameters;
    //   1683: invokevirtual 612	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   1686: istore_3
    //   1687: aload_0
    //   1688: getstatic 615	com/tencent/mm/plugin/voip/video/camera/a/c:HjB	I
    //   1691: putfield 617	com/tencent/mm/plugin/voip/video/camera/prev/a:zOa	I
    //   1694: aload_0
    //   1695: getfield 617	com/tencent/mm/plugin/voip/video/camera/prev/a:zOa	I
    //   1698: ifgt +9 -> 1707
    //   1701: aload_0
    //   1702: bipush 7
    //   1704: putfield 617	com/tencent/mm/plugin/voip/video/camera/prev/a:zOa	I
    //   1707: aload_0
    //   1708: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   1711: astore 18
    //   1713: new 619	android/hardware/Camera$CameraInfo
    //   1716: dup
    //   1717: invokespecial 620	android/hardware/Camera$CameraInfo:<init>	()V
    //   1720: astore 19
    //   1722: aload_0
    //   1723: getfield 98	com/tencent/mm/plugin/voip/video/camera/prev/a:HjI	Z
    //   1726: ifeq +233 -> 1959
    //   1729: getstatic 623	com/tencent/mm/plugin/voip/video/camera/a/c:Hjx	I
    //   1732: istore_2
    //   1733: iload_2
    //   1734: aload 19
    //   1736: invokestatic 629	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   1739: invokestatic 159	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1742: ldc_w 631
    //   1745: invokevirtual 635	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1748: checkcast 637	android/view/WindowManager
    //   1751: invokeinterface 641 1 0
    //   1756: invokevirtual 646	android/view/Display:getRotation	()I
    //   1759: istore 4
    //   1761: iconst_0
    //   1762: istore_2
    //   1763: iload 4
    //   1765: tableswitch	default:+330 -> 2095, 0:+333->2098, 1:+338->2103, 2:+344->2109, 3:+351->2116
    //   1797: getfield 98	com/tencent/mm/plugin/voip/video/camera/prev/a:HjI	Z
    //   1800: ifeq +166 -> 1966
    //   1803: sipush 360
    //   1806: iload_2
    //   1807: aload 19
    //   1809: getfield 649	android/hardware/Camera$CameraInfo:orientation	I
    //   1812: iadd
    //   1813: sipush 360
    //   1816: irem
    //   1817: isub
    //   1818: sipush 360
    //   1821: irem
    //   1822: istore_2
    //   1823: aload 18
    //   1825: iload_2
    //   1826: invokevirtual 652	com/tencent/mm/compatible/deviceinfo/v:setDisplayOrientation	(I)V
    //   1829: aload_0
    //   1830: iload_2
    //   1831: putfield 654	com/tencent/mm/plugin/voip/video/camera/prev/a:zOj	I
    //   1834: ldc 172
    //   1836: ldc_w 656
    //   1839: bipush 6
    //   1841: anewarray 4	java/lang/Object
    //   1844: dup
    //   1845: iconst_0
    //   1846: iload_3
    //   1847: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1850: aastore
    //   1851: dup
    //   1852: iconst_1
    //   1853: aload_0
    //   1854: getfield 377	com/tencent/mm/plugin/voip/video/camera/prev/a:HjP	Lcom/tencent/mm/compatible/deviceinfo/ac;
    //   1857: getfield 385	com/tencent/mm/compatible/deviceinfo/ac:width	I
    //   1860: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1863: aastore
    //   1864: dup
    //   1865: iconst_2
    //   1866: aload_0
    //   1867: getfield 377	com/tencent/mm/plugin/voip/video/camera/prev/a:HjP	Lcom/tencent/mm/compatible/deviceinfo/ac;
    //   1870: getfield 382	com/tencent/mm/compatible/deviceinfo/ac:height	I
    //   1873: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1876: aastore
    //   1877: dup
    //   1878: iconst_3
    //   1879: aload_0
    //   1880: getfield 617	com/tencent/mm/plugin/voip/video/camera/prev/a:zOa	I
    //   1883: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1886: aastore
    //   1887: dup
    //   1888: iconst_4
    //   1889: getstatic 659	com/tencent/mm/plugin/voip/video/camera/a/c:Hjz	I
    //   1892: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1895: aastore
    //   1896: dup
    //   1897: iconst_5
    //   1898: aload_0
    //   1899: getfield 654	com/tencent/mm/plugin/voip/video/camera/prev/a:zOj	I
    //   1902: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1905: aastore
    //   1906: invokestatic 310	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1909: ldc_w 448
    //   1912: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1915: iconst_1
    //   1916: ireturn
    //   1917: astore 18
    //   1919: getstatic 272	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   1922: ldc2_w 273
    //   1925: lconst_0
    //   1926: lconst_1
    //   1927: iconst_0
    //   1928: invokevirtual 278	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1931: ldc 172
    //   1933: ldc_w 661
    //   1936: iconst_1
    //   1937: anewarray 4	java/lang/Object
    //   1940: dup
    //   1941: iconst_0
    //   1942: aload 18
    //   1944: invokevirtual 415	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1947: aastore
    //   1948: invokestatic 558	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1951: ldc_w 448
    //   1954: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1957: iconst_m1
    //   1958: ireturn
    //   1959: getstatic 664	com/tencent/mm/plugin/voip/video/camera/a/c:Hjy	I
    //   1962: istore_2
    //   1963: goto -230 -> 1733
    //   1966: aload 19
    //   1968: getfield 649	android/hardware/Camera$CameraInfo:orientation	I
    //   1971: iload_2
    //   1972: isub
    //   1973: sipush 360
    //   1976: iadd
    //   1977: sipush 360
    //   1980: irem
    //   1981: istore_2
    //   1982: goto -159 -> 1823
    //   1985: astore 18
    //   1987: ldc 172
    //   1989: ldc_w 666
    //   1992: iconst_1
    //   1993: anewarray 4	java/lang/Object
    //   1996: dup
    //   1997: iconst_0
    //   1998: aload 18
    //   2000: invokevirtual 415	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2003: aastore
    //   2004: invokestatic 558	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2007: goto -173 -> 1834
    //   2010: astore 20
    //   2012: goto -536 -> 1476
    //   2015: goto -1424 -> 591
    //   2018: aconst_null
    //   2019: astore 19
    //   2021: goto -1475 -> 546
    //   2024: iload 4
    //   2026: istore 7
    //   2028: iload 6
    //   2030: istore 4
    //   2032: iload 7
    //   2034: istore 6
    //   2036: goto +32 -> 2068
    //   2039: iload 8
    //   2041: ifle -1016 -> 1025
    //   2044: iload 7
    //   2046: ifle -1021 -> 1025
    //   2049: iload 7
    //   2051: iload 8
    //   2053: if_icmplt -1028 -> 1025
    //   2056: iconst_1
    //   2057: istore 17
    //   2059: goto -1742 -> 317
    //   2062: iconst_1
    //   2063: istore 4
    //   2065: goto -1682 -> 383
    //   2068: iload 9
    //   2070: iconst_1
    //   2071: iadd
    //   2072: istore 9
    //   2074: iload 6
    //   2076: istore 7
    //   2078: iload 4
    //   2080: istore 6
    //   2082: iload 7
    //   2084: istore 4
    //   2086: goto -988 -> 1098
    //   2089: iconst_0
    //   2090: istore 7
    //   2092: goto -821 -> 1271
    //   2095: goto -299 -> 1796
    //   2098: iconst_0
    //   2099: istore_2
    //   2100: goto -304 -> 1796
    //   2103: bipush 90
    //   2105: istore_2
    //   2106: goto -310 -> 1796
    //   2109: sipush 180
    //   2112: istore_2
    //   2113: goto -317 -> 1796
    //   2116: sipush 270
    //   2119: istore_2
    //   2120: goto -324 -> 1796
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2123	0	this	a
    //   0	2123	1	paramBoolean	boolean
    //   0	2123	2	paramInt1	int
    //   0	2123	3	paramInt2	int
    //   178	1907	4	i	int
    //   1091	225	5	j	int
    //   273	1808	6	k	int
    //   282	1809	7	m	int
    //   279	1775	8	n	int
    //   1086	987	9	i1	int
    //   1153	161	10	i2	int
    //   169	1183	11	i3	int
    //   1083	32	12	i4	int
    //   1209	82	13	i5	int
    //   1217	64	14	i6	int
    //   1238	21	15	i7	int
    //   31	1277	16	bool1	boolean
    //   27	2031	17	bool2	boolean
    //   161	716	18	localObject1	Object
    //   898	472	18	localException1	Exception
    //   1422	15	18	localException2	Exception
    //   1459	365	18	localObject2	Object
    //   1917	26	18	localException3	Exception
    //   1985	14	18	localException4	Exception
    //   205	563	19	localObject3	Object
    //   998	374	19	localException5	Exception
    //   1388	15	19	localException6	Exception
    //   1720	300	19	localCameraInfo	android.hardware.Camera.CameraInfo
    //   574	544	20	localObject4	Object
    //   1470	18	20	localException7	Exception
    //   2010	1	20	localException8	Exception
    //   481	992	21	arrayOfInt	int[]
    //   564	83	22	localPoint	Point
    // Exception table:
    //   from	to	target	type
    //   137	152	898	java/lang/Exception
    //   939	971	998	java/lang/Exception
    //   971	990	998	java/lang/Exception
    //   180	207	1388	java/lang/Exception
    //   207	237	1388	java/lang/Exception
    //   237	271	1388	java/lang/Exception
    //   284	314	1388	java/lang/Exception
    //   317	361	1388	java/lang/Exception
    //   1051	1058	1388	java/lang/Exception
    //   1063	1073	1388	java/lang/Exception
    //   1076	1085	1388	java/lang/Exception
    //   1117	1131	1388	java/lang/Exception
    //   1136	1143	1388	java/lang/Exception
    //   1155	1191	1388	java/lang/Exception
    //   1203	1240	1388	java/lang/Exception
    //   1276	1299	1388	java/lang/Exception
    //   1324	1376	1388	java/lang/Exception
    //   388	429	1422	java/lang/Exception
    //   546	576	1470	java/lang/Exception
    //   581	591	1470	java/lang/Exception
    //   599	624	1470	java/lang/Exception
    //   633	660	1470	java/lang/Exception
    //   660	679	1470	java/lang/Exception
    //   1633	1653	1917	java/lang/Exception
    //   1658	1679	1917	java/lang/Exception
    //   1707	1733	1985	java/lang/Exception
    //   1733	1761	1985	java/lang/Exception
    //   1796	1823	1985	java/lang/Exception
    //   1823	1834	1985	java/lang/Exception
    //   1959	1963	1985	java/lang/Exception
    //   1966	1982	1985	java/lang/Exception
    //   679	718	2010	java/lang/Exception
  }
  
  private static void h(v paramv)
  {
    AppMethodBeat.i(235864);
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
      AppMethodBeat.o(235864);
    }
  }
  
  private v rO(boolean paramBoolean)
  {
    AppMethodBeat.i(235854);
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
        AppMethodBeat.o(235854);
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
        AppMethodBeat.o(235854);
        return null;
      }
      this.HjI = paramBoolean;
    }
  }
  
  private static v rP(boolean paramBoolean)
  {
    localObject2 = null;
    AppMethodBeat.i(235853);
    if (com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx <= 0)
    {
      AppMethodBeat.o(235853);
      return null;
    }
    if (!com.tencent.mm.plugin.voip.video.camera.a.c.fLk())
    {
      AppMethodBeat.o(235853);
      return null;
    }
    if (paramBoolean == true) {}
    for (;;)
    {
      try
      {
        locala = com.tencent.mm.compatible.deviceinfo.d.a(MMApplicationContext.getContext(), com.tencent.mm.plugin.voip.video.camera.a.c.Hjx, null);
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
      AppMethodBeat.o(235853);
      return localObject1;
      locala = com.tencent.mm.compatible.deviceinfo.d.a(MMApplicationContext.getContext(), com.tencent.mm.plugin.voip.video.camera.a.c.Hjy, null);
      Log.i("Camera", "Use back");
    }
  }
  
  @TargetApi(14)
  public final void N(int[] paramArrayOfInt)
  {
    boolean bool3 = true;
    AppMethodBeat.i(235862);
    if ((ae.gKt.gGg == 1) && (this.zOc))
    {
      AppMethodBeat.o(235862);
      return;
    }
    if (ae.gKt.gGf > 2000) {
      this.zNW = ae.gKt.gGf;
    }
    if (paramArrayOfInt == null)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "focusOnFace error, faceLocation is null");
      boolean bool2;
      if (System.currentTimeMillis() - this.HjN > this.zNW)
      {
        bool1 = true;
        if ((this.HjK) && (!bool1) && (this.HjL == this.HjI)) {
          break label336;
        }
        paramArrayOfInt = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
        if (this.HjK) {
          break label298;
        }
        bool2 = true;
        label131:
        paramArrayOfInt = paramArrayOfInt.append(bool2).append(",isAutoFocusTimeout: ").append(bool1).append(",mAutoFocusTimeOut:").append(this.zNW).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
        if (this.HjL == this.HjI) {
          break label304;
        }
      }
      label298:
      label304:
      for (boolean bool1 = bool3;; bool1 = false)
      {
        Log.i("MicroMsg.Voip.CaptureRender", bool1 + ",isClickScreen :false");
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
          AppMethodBeat.o(235862);
          return;
        }
        catch (Exception paramArrayOfInt)
        {
          Log.e("MicroMsg.Voip.CaptureRender", "mCamera.getParameters() or autoFocus fail!" + paramArrayOfInt.toString());
        }
        bool1 = false;
        break;
        bool2 = false;
        break label131;
      }
      label336:
      AppMethodBeat.o(235862);
      return;
    }
    int i;
    Object localObject;
    int j;
    int k;
    int m;
    label487:
    int n;
    int i1;
    if (this.HjS == null)
    {
      this.HjS = paramArrayOfInt;
      i = 1;
      localObject = this.HjS;
      j = Math.abs(localObject[0] - paramArrayOfInt[0]);
      k = Math.abs(localObject[1] - paramArrayOfInt[1]);
      m = Math.abs(localObject[2] - paramArrayOfInt[2]);
      k = Math.abs(localObject[3] - paramArrayOfInt[3]) + (j + k + m);
      Log.d("MicroMsg.Voip.CaptureRender", "face location diff:%d", new Object[] { Integer.valueOf(k) });
      if (k <= irs)
      {
        j = i;
        if (k <= irq) {}
      }
      else
      {
        this.HjS = paramArrayOfInt;
        if (k > irs) {
          i = 1;
        }
        j = i;
        if (k > irq)
        {
          j = 1;
          if ((i != 0) || (j != 0))
          {
            k = this.HjS[0];
            m = this.HjS[1];
            n = this.HjS[2];
            i1 = this.HjS[3];
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramArrayOfInt = new Rect(k, m, n, i1);
        localObject = this.sZb.getParameters();
        k = j;
        ArrayList localArrayList;
        if (j != 0)
        {
          if ((com.tencent.mm.compatible.util.d.oD(14)) && (((Camera.Parameters)localObject).getMaxNumMeteringAreas() > 0))
          {
            localArrayList = new ArrayList();
            localArrayList.add(new Camera.Area(paramArrayOfInt, 1000));
            ((Camera.Parameters)localObject).setMeteringAreas(localArrayList);
            k = j;
          }
        }
        else
        {
          j = i;
          if (i == 0) {
            break label815;
          }
          if ((!com.tencent.mm.compatible.util.d.oD(14)) || (((Camera.Parameters)localObject).getMaxNumFocusAreas() <= 0)) {
            continue;
          }
          localArrayList = new ArrayList();
          localArrayList.add(new Camera.Area(paramArrayOfInt, 1000));
          ((Camera.Parameters)localObject).setFocusAreas(localArrayList);
          j = i;
          break label815;
          this.sZb.setParameters((Camera.Parameters)localObject);
          if (j != 0)
          {
            Log.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", new Object[] { Boolean.valueOf(this.imy) });
            if (this.imy)
            {
              this.HjK = false;
              this.imy = false;
              this.sZb.autoFocus(new Camera.AutoFocusCallback()
              {
                public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
                {
                  AppMethodBeat.i(235844);
                  Log.d("MicroMsg.Voip.CaptureRender", "onAutoFocus, success:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
                  a.this.imy = true;
                  AppMethodBeat.o(235844);
                }
              });
            }
          }
          AppMethodBeat.o(235862);
          return;
        }
        Log.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
        k = 0;
        continue;
        Log.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
        j = 0;
      }
      catch (Exception paramArrayOfInt)
      {
        Log.e("MicroMsg.Voip.CaptureRender", "focusOnFace exception:%s", new Object[] { paramArrayOfInt.getMessage() });
      }
      AppMethodBeat.o(235862);
      return;
      k = 0;
      i = j;
      j = k;
      break label487;
      i = 0;
      break;
      label815:
      if (j == 0) {
        if (k == 0) {}
      }
    }
  }
  
  public final int a(com.tencent.mm.plugin.voip.video.camera.a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(235851);
    if (com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx <= 0)
    {
      this.HjO = 1;
      AppMethodBeat.o(235851);
      return -1;
    }
    if (paramBoolean) {
      if (!com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.HjX) {
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
      this.HjO = 1;
      AppMethodBeat.o(235851);
      return i;
      if (!com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.HjY) {
        paramBoolean = true;
      }
    }
    eoa();
    this.HjO = 0;
    AppMethodBeat.o(235851);
    return 1;
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder)
  {
    boolean bool1 = false;
    AppMethodBeat.i(235849);
    Log.d("MicroMsg.Voip.CaptureRender", "surfaceChange");
    if ((!this.zOb) || (paramSurfaceHolder.getSurface() == null))
    {
      boolean bool2 = this.zOb;
      if (paramSurfaceHolder.getSurface() == null) {
        bool1 = true;
      }
      Log.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed, CameraOpen: %b, surface: %b, apiLevel: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(235849);
      return;
    }
    try
    {
      if (!this.sZb.gIJ) {
        this.sZb.setPreviewCallback(null);
      }
      this.sZb.stopPreview();
      this.sZb.setPreviewDisplay(paramSurfaceHolder);
      eoa();
      this.sZb.startPreview();
      this.sZd = true;
    }
    catch (Exception paramSurfaceHolder)
    {
      for (;;)
      {
        h.CyF.idkeyStat(159L, 0L, 1L, false);
        h.CyF.idkeyStat(159L, 2L, 1L, false);
        Log.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + paramSurfaceHolder.getMessage());
        this.HjO = 1;
      }
    }
    if (this.zOg)
    {
      fLb();
      this.zOg = false;
    }
    if (!cyZ()) {
      com.tencent.mm.plugin.voip.c.fFg().adn(this.HjO);
    }
    AppMethodBeat.o(235849);
  }
  
  public final void a(ObservableSurfaceView paramObservableSurfaceView)
  {
    AppMethodBeat.i(235847);
    Log.d("MicroMsg.Voip.CaptureRender", "bind ObservableSurfaceView");
    if (paramObservableSurfaceView == null)
    {
      AppMethodBeat.o(235847);
      return;
    }
    this.HjQ = paramObservableSurfaceView;
    this.HjQ.setSurfaceChangeCallback(this);
    this.zOd = true;
    AppMethodBeat.o(235847);
  }
  
  public final void a(ObservableTextureView paramObservableTextureView)
  {
    AppMethodBeat.i(235848);
    Log.i("MicroMsg.Voip.CaptureRender", "bind ObservableTextureView");
    if (paramObservableTextureView == null)
    {
      AppMethodBeat.o(235848);
      return;
    }
    this.HjR = paramObservableTextureView;
    this.HjR.setTextureChangeCallback(this);
    this.zOd = false;
    AppMethodBeat.o(235848);
  }
  
  public final int aPv()
  {
    return this.zOj;
  }
  
  public boolean cyZ()
  {
    return false;
  }
  
  public final boolean dEO()
  {
    return this.sZd;
  }
  
  public final void eoc()
  {
    AppMethodBeat.i(235861);
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
          this.sZb.setPreviewCallback(null);
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
        AppMethodBeat.o(235861);
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
          if (!this.sZb.gIJ) {
            this.sZb.setPreviewCallback(null);
          }
          this.sZb.release();
          this.sZb = null;
          this.zOb = false;
        }
      }
    }
  }
  
  public final void f(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool1 = false;
    AppMethodBeat.i(235850);
    Log.d("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable");
    if ((!this.zOb) || (paramSurfaceTexture == null))
    {
      boolean bool2 = this.zOb;
      if (paramSurfaceTexture == null) {
        bool1 = true;
      }
      Log.e("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable failed, CameraOpen: %b, surface: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      AppMethodBeat.o(235850);
      return;
    }
    try
    {
      if (!this.sZb.gIJ) {
        this.sZb.setPreviewCallback(null);
      }
      this.sZb.stopPreview();
      this.sZb.setPreviewTexture(paramSurfaceTexture);
      eoa();
      this.sZb.startPreview();
      this.sZd = true;
    }
    catch (Exception paramSurfaceTexture)
    {
      for (;;)
      {
        h.CyF.idkeyStat(159L, 0L, 1L, false);
        h.CyF.idkeyStat(159L, 2L, 1L, false);
        Log.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + paramSurfaceTexture.getMessage());
        this.HjO = 1;
      }
    }
    if (this.zOg)
    {
      fLb();
      this.zOg = false;
    }
    if (!cyZ()) {
      com.tencent.mm.plugin.voip.c.fFg().adn(this.HjO);
    }
    AppMethodBeat.o(235850);
  }
  
  public final boolean fKZ()
  {
    return this.HjJ;
  }
  
  public final int fLa()
  {
    return this.HjO;
  }
  
  /* Error */
  public final int fLb()
  {
    // Byte code:
    //   0: ldc_w 925
    //   3: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 116	com/tencent/mm/plugin/voip/video/camera/prev/a:zOb	Z
    //   10: ifne +24 -> 34
    //   13: ldc 172
    //   15: ldc_w 927
    //   18: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 114	com/tencent/mm/plugin/voip/video/camera/prev/a:HjO	I
    //   26: ldc_w 925
    //   29: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_m1
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 124	com/tencent/mm/plugin/voip/video/camera/prev/a:zOf	Z
    //   38: ifeq +19 -> 57
    //   41: ldc 172
    //   43: ldc_w 929
    //   46: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: ldc_w 925
    //   52: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_m1
    //   56: ireturn
    //   57: aload_0
    //   58: getfield 122	com/tencent/mm/plugin/voip/video/camera/prev/a:HjQ	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   61: ifnull +34 -> 95
    //   64: aload_0
    //   65: getfield 122	com/tencent/mm/plugin/voip/video/camera/prev/a:HjQ	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   68: invokevirtual 932	com/tencent/mm/plugin/video/ObservableSurfaceView:fAP	()Z
    //   71: ifne +24 -> 95
    //   74: ldc 172
    //   76: ldc_w 934
    //   79: invokestatic 433	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_0
    //   83: iconst_1
    //   84: putfield 126	com/tencent/mm/plugin/voip/video/camera/prev/a:zOg	Z
    //   87: ldc_w 925
    //   90: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iconst_0
    //   94: ireturn
    //   95: ldc 172
    //   97: ldc_w 936
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_0
    //   107: getfield 120	com/tencent/mm/plugin/voip/video/camera/prev/a:zOd	Z
    //   110: invokestatic 308	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   113: aastore
    //   114: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload_0
    //   118: getfield 122	com/tencent/mm/plugin/voip/video/camera/prev/a:HjQ	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   121: ifnull +109 -> 230
    //   124: aload_0
    //   125: getfield 120	com/tencent/mm/plugin/voip/video/camera/prev/a:zOd	Z
    //   128: ifeq +102 -> 230
    //   131: aload_0
    //   132: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   135: aload_0
    //   136: getfield 122	com/tencent/mm/plugin/voip/video/camera/prev/a:HjQ	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   139: invokevirtual 940	com/tencent/mm/plugin/video/ObservableSurfaceView:getSurfaceHolder	()Landroid/view/SurfaceHolder;
    //   142: invokevirtual 832	com/tencent/mm/compatible/deviceinfo/v:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   145: aload_0
    //   146: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   149: invokevirtual 835	com/tencent/mm/compatible/deviceinfo/v:startPreview	()V
    //   152: aload_0
    //   153: iconst_1
    //   154: putfield 144	com/tencent/mm/plugin/voip/video/camera/prev/a:sZd	Z
    //   157: aload_0
    //   158: iconst_1
    //   159: putfield 124	com/tencent/mm/plugin/voip/video/camera/prev/a:zOf	Z
    //   162: ldc_w 925
    //   165: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: iconst_1
    //   169: ireturn
    //   170: astore_1
    //   171: getstatic 272	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   174: ldc2_w 273
    //   177: lconst_0
    //   178: lconst_1
    //   179: iconst_0
    //   180: invokevirtual 278	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   183: getstatic 272	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   186: ldc2_w 273
    //   189: ldc2_w 853
    //   192: lconst_1
    //   193: iconst_0
    //   194: invokevirtual 278	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   197: aload_0
    //   198: iconst_1
    //   199: putfield 114	com/tencent/mm/plugin/voip/video/camera/prev/a:HjO	I
    //   202: ldc 172
    //   204: new 280	java/lang/StringBuilder
    //   207: dup
    //   208: ldc_w 942
    //   211: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: aload_1
    //   215: invokevirtual 288	java/lang/Exception:toString	()Ljava/lang/String;
    //   218: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: goto -82 -> 145
    //   230: aload_0
    //   231: getfield 872	com/tencent/mm/plugin/voip/video/camera/prev/a:HjR	Lcom/tencent/mm/plugin/video/ObservableTextureView;
    //   234: ifnull -89 -> 145
    //   237: aload_0
    //   238: getfield 120	com/tencent/mm/plugin/voip/video/camera/prev/a:zOd	Z
    //   241: ifne -96 -> 145
    //   244: aload_0
    //   245: getfield 375	com/tencent/mm/plugin/voip/video/camera/prev/a:sZb	Lcom/tencent/mm/compatible/deviceinfo/v;
    //   248: aload_0
    //   249: getfield 872	com/tencent/mm/plugin/voip/video/camera/prev/a:HjR	Lcom/tencent/mm/plugin/video/ObservableTextureView;
    //   252: invokevirtual 946	com/tencent/mm/plugin/video/ObservableTextureView:getSurfaceTexture	()Landroid/graphics/SurfaceTexture;
    //   255: invokevirtual 922	com/tencent/mm/compatible/deviceinfo/v:setPreviewTexture	(Landroid/graphics/SurfaceTexture;)V
    //   258: goto -113 -> 145
    //   261: astore_1
    //   262: getstatic 272	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   265: ldc2_w 273
    //   268: lconst_0
    //   269: lconst_1
    //   270: iconst_0
    //   271: invokevirtual 278	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   274: getstatic 272	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   277: ldc2_w 273
    //   280: ldc2_w 853
    //   283: lconst_1
    //   284: iconst_0
    //   285: invokevirtual 278	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   288: aload_0
    //   289: iconst_1
    //   290: putfield 114	com/tencent/mm/plugin/voip/video/camera/prev/a:HjO	I
    //   293: ldc 172
    //   295: new 280	java/lang/StringBuilder
    //   298: dup
    //   299: ldc_w 942
    //   302: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   305: aload_1
    //   306: invokevirtual 288	java/lang/Exception:toString	()Ljava/lang/String;
    //   309: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: goto -173 -> 145
    //   321: astore_1
    //   322: getstatic 272	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   325: ldc2_w 273
    //   328: lconst_0
    //   329: lconst_1
    //   330: iconst_0
    //   331: invokevirtual 278	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   334: getstatic 272	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   337: ldc2_w 273
    //   340: ldc2_w 853
    //   343: lconst_1
    //   344: iconst_0
    //   345: invokevirtual 278	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   348: aload_0
    //   349: iconst_1
    //   350: putfield 114	com/tencent/mm/plugin/voip/video/camera/prev/a:HjO	I
    //   353: aload_0
    //   354: getfield 560	com/tencent/mm/plugin/voip/video/camera/prev/a:zOe	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   357: ifnull +12 -> 369
    //   360: aload_0
    //   361: getfield 560	com/tencent/mm/plugin/voip/video/camera/prev/a:zOe	Lcom/tencent/mm/plugin/voip/video/camera/a/b;
    //   364: invokeinterface 565 1 0
    //   369: ldc 172
    //   371: new 280	java/lang/StringBuilder
    //   374: dup
    //   375: ldc_w 948
    //   378: invokespecial 285	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   381: aload_1
    //   382: invokevirtual 288	java/lang/Exception:toString	()Ljava/lang/String;
    //   385: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 296	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: goto -237 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	a
    //   170	45	1	localException1	Exception
    //   261	45	1	localException2	Exception
    //   321	61	1	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   131	145	170	java/lang/Exception
    //   244	258	261	java/lang/Exception
    //   145	157	321	java/lang/Exception
  }
  
  public final ac fLc()
  {
    return this.HjP;
  }
  
  public final void fLd()
  {
    AppMethodBeat.i(235859);
    if (com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx < 2)
    {
      Log.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + com.tencent.mm.plugin.voip.video.camera.a.c.Hjw.gFx);
      AppMethodBeat.o(235859);
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
      if (!cyZ()) {
        com.tencent.mm.plugin.voip.c.fFg().adn(this.HjO);
      }
      this.imy = true;
      AppMethodBeat.o(235859);
      return;
    }
  }
  
  public final boolean fLp()
  {
    return this.HjI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.camera.prev.a
 * JD-Core Version:    0.7.0.1
 */