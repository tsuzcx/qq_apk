package com.tencent.mm.plugin.voip.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.aa;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.ObservableSurfaceView;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class a
  implements com.tencent.mm.plugin.video.a, com.tencent.mm.plugin.video.b
{
  private static final Pattern qCQ;
  private static int tFm;
  private static int tFn;
  protected int mHeight;
  protected int mWidth;
  protected u mrD;
  protected boolean mrE;
  protected boolean tFA;
  protected boolean tFB;
  protected ObservableSurfaceView tFC;
  protected ObservableTextureView tFD;
  protected f tFE;
  protected boolean tFF;
  protected boolean tFG;
  protected byte[] tFH;
  protected int[] tFI;
  protected List<byte[]> tFJ;
  protected boolean tFK;
  protected int tFL;
  protected int tFM;
  protected int tFN;
  protected int tFO;
  protected boolean tFP;
  Camera.PreviewCallback tFQ;
  protected boolean tFo;
  protected boolean tFp;
  protected boolean tFq;
  protected boolean tFr;
  protected boolean tFs;
  protected long tFt;
  protected long tFu;
  protected int tFv;
  protected Camera.Parameters tFw;
  protected aa tFx;
  protected int tFy;
  protected boolean tFz;
  
  static
  {
    AppMethodBeat.i(5041);
    qCQ = Pattern.compile(",");
    tFm = 20;
    tFn = 70;
    AppMethodBeat.o(5041);
  }
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5022);
    this.tFo = false;
    this.tFp = false;
    this.tFq = false;
    this.tFr = false;
    this.tFs = false;
    this.tFt = 0L;
    this.tFu = 30000L;
    this.tFv = 0;
    this.tFz = false;
    this.tFA = false;
    this.tFB = false;
    this.tFC = null;
    this.tFF = false;
    this.tFG = false;
    this.tFH = null;
    this.tFI = null;
    this.mWidth = 320;
    this.mHeight = 240;
    this.tFK = true;
    this.tFM = 0;
    this.tFN = 0;
    this.tFO = 0;
    this.mrE = false;
    this.tFP = false;
    this.tFQ = new a.2(this);
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    i.fo(ah.getContext().getApplicationContext());
    ab.d("MicroMsg.Voip.CaptureRender", "width: %d, height: %d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
    AppMethodBeat.o(5022);
  }
  
  private static Point a(CharSequence paramCharSequence, Point paramPoint)
  {
    AppMethodBeat.i(5033);
    int i1 = 2147483647;
    paramCharSequence = qCQ.split(paramCharSequence);
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
        break label277;
      }
      str = paramCharSequence[m].trim();
      k = str.indexOf('x');
      if (k >= 0) {
        break;
      }
      ab.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: ".concat(String.valueOf(str)));
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
        n = bo.getInt(str.substring(0, k), 0);
        k = bo.getInt(str.substring(k + 1), 0);
        i5 = Math.abs(n - paramPoint.x) + Math.abs(k - paramPoint.y);
        if (i5 != 0) {
          break label220;
        }
        if ((n <= 0) || (k <= 0)) {
          break label269;
        }
        paramCharSequence = new Point(n, k);
        AppMethodBeat.o(5033);
        return paramCharSequence;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ab.w("MicroMsg.Voip.CaptureRender", "Bad preview-size: ".concat(String.valueOf(str)));
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
      AppMethodBeat.o(5033);
      return null;
      label277:
      k = j;
      int n = i;
    }
  }
  
  private static boolean a(u paramu, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5031);
    if (paramu == null)
    {
      AppMethodBeat.o(5031);
      return false;
    }
    try
    {
      Camera.Parameters localParameters = paramu.getParameters();
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        localParameters.setPreviewSize(paramInt1, paramInt2);
      }
      paramu.setParameters(localParameters);
      AppMethodBeat.o(5031);
      return true;
    }
    catch (Exception paramu)
    {
      h.qsU.idkeyStat(159L, 0L, 1L, false);
      ab.e("MicroMsg.Voip.CaptureRender", "TryPreviewSize fail:" + paramu.toString());
      AppMethodBeat.o(5031);
    }
    return false;
  }
  
  private boolean c(u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(5032);
    if (paramu == null)
    {
      AppMethodBeat.o(5032);
      return false;
    }
    Camera.Parameters localParameters;
    List localList;
    try
    {
      ab.i("MicroMsg.Voip.CaptureRender", "trySetAutoFocus, isFrontCamera:%s", new Object[] { Boolean.valueOf(paramBoolean) });
      localParameters = paramu.getParameters();
      localList = localParameters.getSupportedFocusModes();
      if (localList == null) {
        break label224;
      }
      ab.d("MicroMsg.Voip.CaptureRender", "supported focus modes size = " + localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ab.d("MicroMsg.Voip.CaptureRender", "supported focus modes : ".concat(String.valueOf((String)localIterator.next())));
      }
      if (ac.eru.eox != 0) {
        break label268;
      }
    }
    catch (Exception paramu)
    {
      h.qsU.idkeyStat(159L, 0L, 1L, false);
      ab.e("MicroMsg.Voip.CaptureRender", "TrySetAutoFocus fail:" + paramu.toString());
      AppMethodBeat.o(5032);
      return false;
    }
    if (paramBoolean) {
      if (localList.contains("auto"))
      {
        ab.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
        localParameters.setFocusMode("auto");
        this.tFA = false;
      }
    }
    for (;;)
    {
      paramu.setParameters(localParameters);
      label224:
      AppMethodBeat.o(5032);
      return true;
      if (localList.contains("continuous-video"))
      {
        ab.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
        localParameters.setFocusMode("continuous-video");
        this.tFA = true;
        continue;
        label268:
        if ((ac.eru.eox == 1) || (!paramBoolean)) {
          if (localList.contains("continuous-video"))
          {
            ab.d("MicroMsg.Voip.CaptureRender", "camera support continuous video focus");
            localParameters.setFocusMode("continuous-video");
            this.tFA = true;
          }
          else if (localList.contains("auto"))
          {
            ab.d("MicroMsg.Voip.CaptureRender", "camera support auto focus");
            localParameters.setFocusMode("auto");
            this.tFA = false;
          }
        }
      }
    }
  }
  
  private void cPx()
  {
    AppMethodBeat.i(5028);
    for (;;)
    {
      try
      {
        if ((this.mrD != null) && (this.tFz))
        {
          if ((this.tFx != null) && (this.tFx.height > 0) && (this.tFx.width > 0))
          {
            int j = this.tFx.height * this.tFx.width * 3 / 2;
            if (this.tFJ == null)
            {
              this.tFJ = new ArrayList(3);
              i = 0;
              if (i < 3)
              {
                this.tFJ.add(new byte[j]);
                i += 1;
                continue;
                if (i < this.tFJ.size())
                {
                  if (this.mrD == null) {
                    break label225;
                  }
                  this.mrD.addCallbackBuffer((byte[])this.tFJ.get(i));
                  break label225;
                }
                this.mrD.setPreviewCallbackWithBuffer(this.tFQ);
                AppMethodBeat.o(5028);
              }
            }
          }
          else
          {
            this.mrD.setPreviewCallback(this.tFQ);
          }
        }
        else
        {
          AppMethodBeat.o(5028);
          return;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.Voip.CaptureRender", localException, "setPreviewCallback error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(5028);
        return;
      }
      int i = 0;
      continue;
      label225:
      i += 1;
    }
  }
  
  private int g(u paramu)
  {
    AppMethodBeat.i(5039);
    if (paramu == null)
    {
      AppMethodBeat.o(5039);
      return 0;
    }
    for (;;)
    {
      try
      {
        localObject = paramu.getParameters().getSupportedPreviewSizes();
        if ((localObject == null) || (((List)localObject).size() == 0)) {
          continue;
        }
        localObject = ((List)localObject).iterator();
        i = 0;
      }
      catch (Exception paramu)
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
          ab.d("MicroMsg.Voip.CaptureRender", "support Size:" + localSize.width + "," + localSize.height);
          if (i == 0)
          {
            this.tFM = localSize.width;
            this.tFN = localSize.height;
          }
          i += 1;
          continue;
        }
        try
        {
          paramu = paramu.getParameters().getSupportedPreviewFormats();
          if ((paramu == null) || (paramu.size() == 0)) {
            continue;
          }
          paramu = paramu.iterator();
          if (!paramu.hasNext()) {
            continue;
          }
          ab.i("MicroMsg.Voip.CaptureRender", "support Format:".concat(String.valueOf(((Integer)paramu.next()).intValue())));
          continue;
          ab.printErrStackTrace("MicroMsg.Voip.CaptureRender", paramu, "", new Object[0]);
        }
        catch (Exception paramu) {}
      }
      catch (Exception paramu)
      {
        continue;
      }
      AppMethodBeat.o(5039);
      return i;
    }
  }
  
  private static void h(u paramu)
  {
    AppMethodBeat.i(5040);
    try
    {
      localList = paramu.getParameters().getSupportedPreviewFrameRates();
      paramu = "supportFps:";
      localu = paramu;
      if (localList != null)
      {
        int i = 0;
        for (;;)
        {
          localu = paramu;
          if (i >= localList.size()) {
            break;
          }
          int j = ((Integer)localList.get(i)).intValue();
          paramu = paramu + j + ",";
          i += 1;
        }
      }
    }
    catch (Exception paramu)
    {
      u localu;
      for (;;)
      {
        ab.d("MicroMsg.Voip.CaptureRender", "getSupportedPreviewFrameRates:error:" + paramu.toString());
        List localList = null;
      }
      ab.i("MicroMsg.Voip.CaptureRender", localu);
      AppMethodBeat.o(5040);
    }
  }
  
  /* Error */
  private int j(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: sipush 5034
    //   3: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 165
    //   8: ldc_w 445
    //   11: iload_1
    //   12: invokestatic 448	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   15: invokevirtual 207	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 429	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 111	com/tencent/mm/plugin/voip/video/a:tFA	Z
    //   26: iconst_1
    //   27: istore 17
    //   29: iload 17
    //   31: istore 16
    //   33: aload_0
    //   34: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   37: ifnull +52 -> 89
    //   40: aload_0
    //   41: getfield 91	com/tencent/mm/plugin/voip/video/a:tFo	Z
    //   44: iload_1
    //   45: if_icmpeq +78 -> 123
    //   48: aload_0
    //   49: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   52: getfield 451	com/tencent/mm/compatible/e/u:eqG	Z
    //   55: ifne +11 -> 66
    //   58: aload_0
    //   59: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   62: aconst_null
    //   63: invokevirtual 397	com/tencent/mm/compatible/e/u:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   66: aload_0
    //   67: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   70: invokevirtual 454	com/tencent/mm/compatible/e/u:stopPreview	()V
    //   73: aload_0
    //   74: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   77: invokevirtual 457	com/tencent/mm/compatible/e/u:release	()V
    //   80: aload_0
    //   81: aconst_null
    //   82: putfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   85: iload 17
    //   87: istore 16
    //   89: iload 16
    //   91: ifeq +46 -> 137
    //   94: aload_0
    //   95: aload_0
    //   96: iload_1
    //   97: invokespecial 461	com/tencent/mm/plugin/voip/video/a:nc	(Z)Lcom/tencent/mm/compatible/e/u;
    //   100: putfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   103: aload_0
    //   104: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   107: ifnonnull +25 -> 132
    //   110: aload_0
    //   111: iconst_0
    //   112: putfield 109	com/tencent/mm/plugin/voip/video/a:tFz	Z
    //   115: sipush 5034
    //   118: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iconst_m1
    //   122: ireturn
    //   123: aload_0
    //   124: getfield 139	com/tencent/mm/plugin/voip/video/a:tFP	Z
    //   127: istore 16
    //   129: goto -40 -> 89
    //   132: aload_0
    //   133: iconst_0
    //   134: putfield 139	com/tencent/mm/plugin/voip/video/a:tFP	Z
    //   137: aload_0
    //   138: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   141: ifnull +11 -> 152
    //   144: aload_0
    //   145: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   148: invokevirtual 248	com/tencent/mm/compatible/e/u:getParameters	()Landroid/hardware/Camera$Parameters;
    //   151: pop
    //   152: aload_0
    //   153: iconst_1
    //   154: putfield 109	com/tencent/mm/plugin/voip/video/a:tFz	Z
    //   157: aload_0
    //   158: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   161: astore 18
    //   163: getstatic 465	com/tencent/mm/plugin/voip/video/i:tHy	Lcom/tencent/mm/plugin/voip/video/g;
    //   166: getfield 470	com/tencent/mm/plugin/voip/video/g:tGg	I
    //   169: istore 11
    //   171: aload 18
    //   173: ifnull +246 -> 419
    //   176: ldc 165
    //   178: ldc_w 472
    //   181: iconst_1
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: iload 11
    //   189: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   192: aastore
    //   193: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload 18
    //   198: invokevirtual 248	com/tencent/mm/compatible/e/u:getParameters	()Landroid/hardware/Camera$Parameters;
    //   201: astore 19
    //   203: ldc_w 474
    //   206: invokestatic 480	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   209: checkcast 474	com/tencent/mm/plugin/zero/b/a
    //   212: invokeinterface 484 1 0
    //   217: ldc_w 486
    //   220: bipush 26
    //   222: invokevirtual 489	com/tencent/mm/m/e:getInt	(Ljava/lang/String;I)I
    //   225: istore 4
    //   227: ldc 165
    //   229: ldc_w 491
    //   232: iconst_1
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: iload 4
    //   240: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: aastore
    //   244: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: invokestatic 496	com/tencent/mm/compatible/util/l:IM	()Z
    //   250: ifne +11 -> 261
    //   253: iload 4
    //   255: invokestatic 502	com/tencent/mm/compatible/util/d:fv	(I)Z
    //   258: ifeq +1114 -> 1372
    //   261: ldc 184
    //   263: istore 6
    //   265: iconst_0
    //   266: istore 16
    //   268: iconst_m1
    //   269: istore 8
    //   271: iconst_0
    //   272: istore 7
    //   274: getstatic 339	com/tencent/mm/compatible/e/ac:eru	Lcom/tencent/mm/compatible/e/c;
    //   277: ifnull +1750 -> 2027
    //   280: getstatic 339	com/tencent/mm/compatible/e/ac:eru	Lcom/tencent/mm/compatible/e/c;
    //   283: getfield 505	com/tencent/mm/compatible/e/c:eoA	I
    //   286: sipush 1000
    //   289: imul
    //   290: istore 8
    //   292: getstatic 339	com/tencent/mm/compatible/e/ac:eru	Lcom/tencent/mm/compatible/e/c;
    //   295: getfield 508	com/tencent/mm/compatible/e/c:eoB	I
    //   298: sipush 1000
    //   301: imul
    //   302: istore 7
    //   304: goto +1723 -> 2027
    //   307: ldc 165
    //   309: ldc_w 510
    //   312: iconst_4
    //   313: anewarray 4	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: iload 8
    //   320: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   323: aastore
    //   324: dup
    //   325: iconst_1
    //   326: iload 7
    //   328: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   331: aastore
    //   332: dup
    //   333: iconst_2
    //   334: iload 11
    //   336: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: aastore
    //   340: dup
    //   341: iconst_3
    //   342: iload 17
    //   344: invokestatic 296	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   347: aastore
    //   348: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   351: iload 8
    //   353: ldc 184
    //   355: if_icmpeq +15 -> 370
    //   358: iload 7
    //   360: ldc 184
    //   362: if_icmpeq +8 -> 370
    //   365: iload 17
    //   367: ifne +947 -> 1314
    //   370: iconst_1
    //   371: istore 4
    //   373: iload 4
    //   375: ifeq +44 -> 419
    //   378: ldc 165
    //   380: ldc_w 512
    //   383: iconst_1
    //   384: anewarray 4	java/lang/Object
    //   387: dup
    //   388: iconst_0
    //   389: iload 11
    //   391: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: aastore
    //   395: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   398: aload 18
    //   400: invokevirtual 248	com/tencent/mm/compatible/e/u:getParameters	()Landroid/hardware/Camera$Parameters;
    //   403: astore 19
    //   405: aload 19
    //   407: iload 11
    //   409: invokevirtual 515	android/hardware/Camera$Parameters:setPreviewFrameRate	(I)V
    //   412: aload 18
    //   414: aload 19
    //   416: invokevirtual 257	com/tencent/mm/compatible/e/u:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   419: ldc 165
    //   421: new 271	java/lang/StringBuilder
    //   424: dup
    //   425: ldc_w 517
    //   428: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   431: iload_2
    //   432: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   435: ldc 69
    //   437: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: iload_3
    //   441: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 429	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: iload_1
    //   451: ifeq +992 -> 1443
    //   454: getstatic 465	com/tencent/mm/plugin/voip/video/i:tHy	Lcom/tencent/mm/plugin/voip/video/g;
    //   457: getfield 521	com/tencent/mm/plugin/voip/video/g:tGl	Landroid/graphics/Point;
    //   460: astore 18
    //   462: aload 18
    //   464: ifnull +990 -> 1454
    //   467: iconst_1
    //   468: istore 4
    //   470: aconst_null
    //   471: astore 21
    //   473: aload 18
    //   475: ifnull +1531 -> 2006
    //   478: new 366	com/tencent/mm/compatible/e/aa
    //   481: dup
    //   482: aload 18
    //   484: getfield 229	android/graphics/Point:x	I
    //   487: aload 18
    //   489: getfield 237	android/graphics/Point:y	I
    //   492: invokespecial 522	com/tencent/mm/compatible/e/aa:<init>	(II)V
    //   495: astore 19
    //   497: ldc 165
    //   499: new 271	java/lang/StringBuilder
    //   502: dup
    //   503: ldc_w 524
    //   506: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   509: aload 19
    //   511: getfield 372	com/tencent/mm/compatible/e/aa:width	I
    //   514: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   517: ldc 69
    //   519: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: aload 19
    //   524: getfield 369	com/tencent/mm/compatible/e/aa:height	I
    //   527: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   530: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 429	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: aload_0
    //   537: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   540: invokevirtual 248	com/tencent/mm/compatible/e/u:getParameters	()Landroid/hardware/Camera$Parameters;
    //   543: astore 18
    //   545: new 226	android/graphics/Point
    //   548: dup
    //   549: iload_2
    //   550: iload_3
    //   551: invokespecial 239	android/graphics/Point:<init>	(II)V
    //   554: astore 22
    //   556: aload 18
    //   558: ldc_w 526
    //   561: invokevirtual 528	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   564: astore 20
    //   566: aload 20
    //   568: ifnonnull +1435 -> 2003
    //   571: aload 18
    //   573: ldc_w 530
    //   576: invokevirtual 528	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   579: astore 20
    //   581: aconst_null
    //   582: astore 18
    //   584: aload 20
    //   586: ifnull +28 -> 614
    //   589: ldc 165
    //   591: ldc_w 532
    //   594: aload 20
    //   596: invokestatic 203	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   599: invokevirtual 207	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   602: invokestatic 429	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   605: aload 20
    //   607: aload 22
    //   609: invokestatic 534	com/tencent/mm/plugin/voip/video/a:a	(Ljava/lang/CharSequence;Landroid/graphics/Point;)Landroid/graphics/Point;
    //   612: astore 18
    //   614: aload 18
    //   616: astore 20
    //   618: aload 18
    //   620: ifnonnull +30 -> 650
    //   623: new 226	android/graphics/Point
    //   626: dup
    //   627: aload 22
    //   629: getfield 229	android/graphics/Point:x	I
    //   632: iconst_3
    //   633: ishr
    //   634: iconst_3
    //   635: ishl
    //   636: aload 22
    //   638: getfield 237	android/graphics/Point:y	I
    //   641: iconst_3
    //   642: ishr
    //   643: iconst_3
    //   644: ishl
    //   645: invokespecial 239	android/graphics/Point:<init>	(II)V
    //   648: astore 20
    //   650: new 366	com/tencent/mm/compatible/e/aa
    //   653: dup
    //   654: aload 20
    //   656: getfield 229	android/graphics/Point:x	I
    //   659: aload 20
    //   661: getfield 237	android/graphics/Point:y	I
    //   664: invokespecial 522	com/tencent/mm/compatible/e/aa:<init>	(II)V
    //   667: astore 18
    //   669: ldc 165
    //   671: new 271	java/lang/StringBuilder
    //   674: dup
    //   675: ldc_w 536
    //   678: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   681: aload 18
    //   683: getfield 372	com/tencent/mm/compatible/e/aa:width	I
    //   686: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   689: ldc 69
    //   691: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload 18
    //   696: getfield 369	com/tencent/mm/compatible/e/aa:height	I
    //   699: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   702: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 429	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   708: iload 4
    //   710: ifeq +779 -> 1489
    //   713: aload_0
    //   714: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   717: aload 19
    //   719: getfield 372	com/tencent/mm/compatible/e/aa:width	I
    //   722: aload 19
    //   724: getfield 369	com/tencent/mm/compatible/e/aa:height	I
    //   727: invokestatic 538	com/tencent/mm/plugin/voip/video/a:a	(Lcom/tencent/mm/compatible/e/u;II)Z
    //   730: istore_1
    //   731: ldc 165
    //   733: new 271	java/lang/StringBuilder
    //   736: dup
    //   737: ldc_w 540
    //   740: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   743: aload 19
    //   745: getfield 372	com/tencent/mm/compatible/e/aa:width	I
    //   748: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   751: ldc_w 542
    //   754: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload 19
    //   759: getfield 369	com/tencent/mm/compatible/e/aa:height	I
    //   762: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   765: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   768: invokestatic 429	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   771: iload_1
    //   772: ifne +838 -> 1610
    //   775: aload 18
    //   777: ifnull +833 -> 1610
    //   780: ldc 165
    //   782: new 271	java/lang/StringBuilder
    //   785: dup
    //   786: ldc_w 544
    //   789: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   792: aload 18
    //   794: getfield 372	com/tencent/mm/compatible/e/aa:width	I
    //   797: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   800: ldc_w 542
    //   803: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload 18
    //   808: getfield 369	com/tencent/mm/compatible/e/aa:height	I
    //   811: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   814: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: invokestatic 287	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   820: aload_0
    //   821: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   824: aload 18
    //   826: getfield 372	com/tencent/mm/compatible/e/aa:width	I
    //   829: aload 18
    //   831: getfield 369	com/tencent/mm/compatible/e/aa:height	I
    //   834: invokestatic 538	com/tencent/mm/plugin/voip/video/a:a	(Lcom/tencent/mm/compatible/e/u;II)Z
    //   837: ifne +773 -> 1610
    //   840: ldc 165
    //   842: new 271	java/lang/StringBuilder
    //   845: dup
    //   846: ldc_w 546
    //   849: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   852: aload 18
    //   854: getfield 372	com/tencent/mm/compatible/e/aa:width	I
    //   857: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   860: ldc_w 542
    //   863: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload 18
    //   868: getfield 369	com/tencent/mm/compatible/e/aa:height	I
    //   871: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   874: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   877: invokestatic 287	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   880: sipush 5034
    //   883: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   886: iconst_m1
    //   887: ireturn
    //   888: astore 18
    //   890: getstatic 263	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   893: ldc2_w 264
    //   896: lconst_0
    //   897: lconst_1
    //   898: iconst_0
    //   899: invokevirtual 269	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   902: ldc 165
    //   904: ldc_w 548
    //   907: iconst_1
    //   908: anewarray 4	java/lang/Object
    //   911: dup
    //   912: iconst_0
    //   913: aload 18
    //   915: invokevirtual 402	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   918: aastore
    //   919: invokestatic 550	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   922: aload_0
    //   923: getfield 552	com/tencent/mm/plugin/voip/video/a:tFE	Lcom/tencent/mm/plugin/voip/video/f;
    //   926: ifnull +54 -> 980
    //   929: aload_0
    //   930: getfield 552	com/tencent/mm/plugin/voip/video/a:tFE	Lcom/tencent/mm/plugin/voip/video/f;
    //   933: invokeinterface 557 1 0
    //   938: aload_0
    //   939: iconst_1
    //   940: putfield 139	com/tencent/mm/plugin/voip/video/a:tFP	Z
    //   943: aload_0
    //   944: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   947: getfield 451	com/tencent/mm/compatible/e/u:eqG	Z
    //   950: ifne +11 -> 961
    //   953: aload_0
    //   954: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   957: aconst_null
    //   958: invokevirtual 397	com/tencent/mm/compatible/e/u:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   961: aload_0
    //   962: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   965: invokevirtual 454	com/tencent/mm/compatible/e/u:stopPreview	()V
    //   968: aload_0
    //   969: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   972: invokevirtual 457	com/tencent/mm/compatible/e/u:release	()V
    //   975: aload_0
    //   976: aconst_null
    //   977: putfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   980: sipush 5034
    //   983: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   986: iconst_m1
    //   987: ireturn
    //   988: astore 19
    //   990: ldc 165
    //   992: aload 19
    //   994: ldc_w 559
    //   997: iconst_1
    //   998: anewarray 4	java/lang/Object
    //   1001: dup
    //   1002: iconst_0
    //   1003: aload 18
    //   1005: invokevirtual 402	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1008: aastore
    //   1009: invokestatic 406	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1012: goto -32 -> 980
    //   1015: iload 8
    //   1017: ifne +24 -> 1041
    //   1020: iload 7
    //   1022: ifne +19 -> 1041
    //   1025: iconst_0
    //   1026: istore 17
    //   1028: ldc_w 560
    //   1031: istore 7
    //   1033: ldc_w 560
    //   1036: istore 8
    //   1038: goto -731 -> 307
    //   1041: aload 19
    //   1043: invokevirtual 563	android/hardware/Camera$Parameters:getSupportedPreviewFpsRange	()Ljava/util/List;
    //   1046: astore 20
    //   1048: aload 20
    //   1050: ifnull +1000 -> 2050
    //   1053: aload 20
    //   1055: invokeinterface 310 1 0
    //   1060: ifne +6 -> 1066
    //   1063: goto +987 -> 2050
    //   1066: aload 20
    //   1068: invokeinterface 310 1 0
    //   1073: istore 12
    //   1075: iconst_0
    //   1076: istore 9
    //   1078: ldc_w 560
    //   1081: istore 5
    //   1083: ldc_w 560
    //   1086: istore 4
    //   1088: iload 16
    //   1090: istore 17
    //   1092: iload 5
    //   1094: istore 7
    //   1096: iload 4
    //   1098: istore 8
    //   1100: iload 9
    //   1102: iload 12
    //   1104: if_icmpge -797 -> 307
    //   1107: aload 20
    //   1109: iload 9
    //   1111: invokeinterface 385 2 0
    //   1116: checkcast 564	[I
    //   1119: astore 21
    //   1121: aload 21
    //   1123: ifnull +889 -> 2012
    //   1126: aload 21
    //   1128: arraylength
    //   1129: iconst_1
    //   1130: if_icmple +882 -> 2012
    //   1133: aload 21
    //   1135: iconst_0
    //   1136: iaload
    //   1137: istore 8
    //   1139: aload 21
    //   1141: iconst_1
    //   1142: iaload
    //   1143: istore 10
    //   1145: ldc 165
    //   1147: ldc_w 566
    //   1150: iconst_3
    //   1151: anewarray 4	java/lang/Object
    //   1154: dup
    //   1155: iconst_0
    //   1156: iload 9
    //   1158: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1161: aastore
    //   1162: dup
    //   1163: iconst_1
    //   1164: iload 8
    //   1166: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1169: aastore
    //   1170: dup
    //   1171: iconst_2
    //   1172: iload 10
    //   1174: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1177: aastore
    //   1178: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1181: iload 8
    //   1183: iflt +829 -> 2012
    //   1186: iload 10
    //   1188: iload 8
    //   1190: if_icmplt +822 -> 2012
    //   1193: iload 10
    //   1195: sipush 1000
    //   1198: idiv
    //   1199: istore 13
    //   1201: iload 8
    //   1203: sipush 1000
    //   1206: idiv
    //   1207: istore 14
    //   1209: iload 11
    //   1211: iconst_5
    //   1212: iadd
    //   1213: bipush 30
    //   1215: invokestatic 570	java/lang/Math:min	(II)I
    //   1218: istore 7
    //   1220: iload 11
    //   1222: iconst_5
    //   1223: isub
    //   1224: iconst_5
    //   1225: invokestatic 573	java/lang/Math:max	(II)I
    //   1228: istore 15
    //   1230: iload 13
    //   1232: iload 15
    //   1234: if_icmplt +843 -> 2077
    //   1237: iload 13
    //   1239: iload 7
    //   1241: if_icmpgt +836 -> 2077
    //   1244: iload 14
    //   1246: iload 15
    //   1248: if_icmplt +829 -> 2077
    //   1251: iload 14
    //   1253: iload 7
    //   1255: if_icmpgt +822 -> 2077
    //   1258: iconst_1
    //   1259: istore 7
    //   1261: iload 7
    //   1263: ifeq +749 -> 2012
    //   1266: iload 11
    //   1268: iload 14
    //   1270: isub
    //   1271: invokestatic 234	java/lang/Math:abs	(I)I
    //   1274: istore 7
    //   1276: iload 13
    //   1278: iload 11
    //   1280: isub
    //   1281: invokestatic 234	java/lang/Math:abs	(I)I
    //   1284: iload 7
    //   1286: iadd
    //   1287: istore 7
    //   1289: iload 7
    //   1291: iload 6
    //   1293: if_icmpge +719 -> 2012
    //   1296: iconst_1
    //   1297: istore 16
    //   1299: iload 7
    //   1301: istore 4
    //   1303: iload 10
    //   1305: istore 5
    //   1307: iload 8
    //   1309: istore 6
    //   1311: goto +745 -> 2056
    //   1314: ldc 165
    //   1316: ldc_w 575
    //   1319: iconst_3
    //   1320: anewarray 4	java/lang/Object
    //   1323: dup
    //   1324: iconst_0
    //   1325: iload 8
    //   1327: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1330: aastore
    //   1331: dup
    //   1332: iconst_1
    //   1333: iload 7
    //   1335: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1338: aastore
    //   1339: dup
    //   1340: iconst_2
    //   1341: iload 11
    //   1343: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1346: aastore
    //   1347: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1350: aload 19
    //   1352: iload 8
    //   1354: iload 7
    //   1356: invokevirtual 578	android/hardware/Camera$Parameters:setPreviewFpsRange	(II)V
    //   1359: aload 18
    //   1361: aload 19
    //   1363: invokevirtual 257	com/tencent/mm/compatible/e/u:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   1366: iconst_0
    //   1367: istore 4
    //   1369: goto -996 -> 373
    //   1372: iconst_1
    //   1373: istore 4
    //   1375: goto -1002 -> 373
    //   1378: astore 19
    //   1380: ldc 165
    //   1382: new 271	java/lang/StringBuilder
    //   1385: dup
    //   1386: ldc_w 580
    //   1389: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1392: aload 19
    //   1394: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   1397: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1403: invokestatic 287	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1406: iconst_1
    //   1407: istore 4
    //   1409: goto -1036 -> 373
    //   1412: astore 18
    //   1414: ldc 165
    //   1416: new 271	java/lang/StringBuilder
    //   1419: dup
    //   1420: ldc_w 582
    //   1423: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1426: aload 18
    //   1428: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   1431: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1434: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1437: invokestatic 287	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1440: goto -1021 -> 419
    //   1443: getstatic 465	com/tencent/mm/plugin/voip/video/i:tHy	Lcom/tencent/mm/plugin/voip/video/g;
    //   1446: getfield 585	com/tencent/mm/plugin/voip/video/g:tGm	Landroid/graphics/Point;
    //   1449: astore 18
    //   1451: goto -989 -> 462
    //   1454: iconst_0
    //   1455: istore 4
    //   1457: goto -987 -> 470
    //   1460: astore 20
    //   1462: aload 21
    //   1464: astore 18
    //   1466: ldc 165
    //   1468: ldc_w 587
    //   1471: iconst_1
    //   1472: anewarray 4	java/lang/Object
    //   1475: dup
    //   1476: iconst_0
    //   1477: aload 20
    //   1479: invokevirtual 402	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1482: aastore
    //   1483: invokestatic 550	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1486: goto -778 -> 708
    //   1489: ldc 165
    //   1491: ldc_w 589
    //   1494: invokestatic 429	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1497: aload 18
    //   1499: ifnull +111 -> 1610
    //   1502: ldc 165
    //   1504: new 271	java/lang/StringBuilder
    //   1507: dup
    //   1508: ldc_w 591
    //   1511: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1514: aload 18
    //   1516: getfield 372	com/tencent/mm/compatible/e/aa:width	I
    //   1519: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1522: ldc_w 542
    //   1525: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1528: aload 18
    //   1530: getfield 369	com/tencent/mm/compatible/e/aa:height	I
    //   1533: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1536: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1539: invokestatic 429	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1542: aload_0
    //   1543: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   1546: aload 18
    //   1548: getfield 372	com/tencent/mm/compatible/e/aa:width	I
    //   1551: aload 18
    //   1553: getfield 369	com/tencent/mm/compatible/e/aa:height	I
    //   1556: invokestatic 538	com/tencent/mm/plugin/voip/video/a:a	(Lcom/tencent/mm/compatible/e/u;II)Z
    //   1559: ifne +51 -> 1610
    //   1562: ldc 165
    //   1564: new 271	java/lang/StringBuilder
    //   1567: dup
    //   1568: ldc_w 593
    //   1571: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1574: aload 18
    //   1576: getfield 372	com/tencent/mm/compatible/e/aa:width	I
    //   1579: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1582: ldc_w 542
    //   1585: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1588: aload 18
    //   1590: getfield 369	com/tencent/mm/compatible/e/aa:height	I
    //   1593: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1596: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1599: invokestatic 287	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1602: sipush 5034
    //   1605: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1608: iconst_m1
    //   1609: ireturn
    //   1610: aload_0
    //   1611: aload_0
    //   1612: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   1615: aload_0
    //   1616: getfield 91	com/tencent/mm/plugin/voip/video/a:tFo	Z
    //   1619: invokespecial 595	com/tencent/mm/plugin/voip/video/a:c	(Lcom/tencent/mm/compatible/e/u;Z)Z
    //   1622: pop
    //   1623: aload_0
    //   1624: aload_0
    //   1625: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   1628: invokevirtual 248	com/tencent/mm/compatible/e/u:getParameters	()Landroid/hardware/Camera$Parameters;
    //   1631: putfield 597	com/tencent/mm/plugin/voip/video/a:tFw	Landroid/hardware/Camera$Parameters;
    //   1634: aload_0
    //   1635: getfield 597	com/tencent/mm/plugin/voip/video/a:tFw	Landroid/hardware/Camera$Parameters;
    //   1638: invokevirtual 601	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   1641: astore 18
    //   1643: aload 18
    //   1645: ifnull +24 -> 1669
    //   1648: aload_0
    //   1649: new 366	com/tencent/mm/compatible/e/aa
    //   1652: dup
    //   1653: aload 18
    //   1655: getfield 416	android/hardware/Camera$Size:width	I
    //   1658: aload 18
    //   1660: getfield 417	android/hardware/Camera$Size:height	I
    //   1663: invokespecial 522	com/tencent/mm/compatible/e/aa:<init>	(II)V
    //   1666: putfield 364	com/tencent/mm/plugin/voip/video/a:tFx	Lcom/tencent/mm/compatible/e/aa;
    //   1669: aload_0
    //   1670: getfield 597	com/tencent/mm/plugin/voip/video/a:tFw	Landroid/hardware/Camera$Parameters;
    //   1673: invokevirtual 604	android/hardware/Camera$Parameters:getPreviewFrameRate	()I
    //   1676: istore_3
    //   1677: aload_0
    //   1678: getstatic 607	com/tencent/mm/plugin/voip/video/i:tHD	I
    //   1681: putfield 609	com/tencent/mm/plugin/voip/video/a:tFy	I
    //   1684: aload_0
    //   1685: getfield 609	com/tencent/mm/plugin/voip/video/a:tFy	I
    //   1688: ifgt +9 -> 1697
    //   1691: aload_0
    //   1692: bipush 7
    //   1694: putfield 609	com/tencent/mm/plugin/voip/video/a:tFy	I
    //   1697: aload_0
    //   1698: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   1701: astore 18
    //   1703: new 611	android/hardware/Camera$CameraInfo
    //   1706: dup
    //   1707: invokespecial 612	android/hardware/Camera$CameraInfo:<init>	()V
    //   1710: astore 19
    //   1712: aload_0
    //   1713: getfield 91	com/tencent/mm/plugin/voip/video/a:tFo	Z
    //   1716: ifeq +231 -> 1947
    //   1719: getstatic 615	com/tencent/mm/plugin/voip/video/i:tHz	I
    //   1722: istore_2
    //   1723: iload_2
    //   1724: aload 19
    //   1726: invokestatic 621	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   1729: invokestatic 152	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   1732: ldc_w 623
    //   1735: invokevirtual 627	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1738: checkcast 629	android/view/WindowManager
    //   1741: invokeinterface 633 1 0
    //   1746: invokevirtual 638	android/view/Display:getRotation	()I
    //   1749: istore 4
    //   1751: iconst_0
    //   1752: istore_2
    //   1753: iload 4
    //   1755: tableswitch	default:+328 -> 2083, 0:+331->2086, 1:+336->2091, 2:+342->2097, 3:+349->2104
    //   1785: getfield 91	com/tencent/mm/plugin/voip/video/a:tFo	Z
    //   1788: ifeq +166 -> 1954
    //   1791: sipush 360
    //   1794: iload_2
    //   1795: aload 19
    //   1797: getfield 641	android/hardware/Camera$CameraInfo:orientation	I
    //   1800: iadd
    //   1801: sipush 360
    //   1804: irem
    //   1805: isub
    //   1806: sipush 360
    //   1809: irem
    //   1810: istore_2
    //   1811: aload 18
    //   1813: iload_2
    //   1814: invokevirtual 644	com/tencent/mm/compatible/e/u:setDisplayOrientation	(I)V
    //   1817: aload_0
    //   1818: iload_2
    //   1819: putfield 646	com/tencent/mm/plugin/voip/video/a:tFL	I
    //   1822: ldc 165
    //   1824: ldc_w 648
    //   1827: bipush 6
    //   1829: anewarray 4	java/lang/Object
    //   1832: dup
    //   1833: iconst_0
    //   1834: iload_3
    //   1835: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1838: aastore
    //   1839: dup
    //   1840: iconst_1
    //   1841: aload_0
    //   1842: getfield 364	com/tencent/mm/plugin/voip/video/a:tFx	Lcom/tencent/mm/compatible/e/aa;
    //   1845: getfield 372	com/tencent/mm/compatible/e/aa:width	I
    //   1848: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1851: aastore
    //   1852: dup
    //   1853: iconst_2
    //   1854: aload_0
    //   1855: getfield 364	com/tencent/mm/plugin/voip/video/a:tFx	Lcom/tencent/mm/compatible/e/aa;
    //   1858: getfield 369	com/tencent/mm/compatible/e/aa:height	I
    //   1861: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1864: aastore
    //   1865: dup
    //   1866: iconst_3
    //   1867: aload_0
    //   1868: getfield 609	com/tencent/mm/plugin/voip/video/a:tFy	I
    //   1871: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1874: aastore
    //   1875: dup
    //   1876: iconst_4
    //   1877: getstatic 651	com/tencent/mm/plugin/voip/video/i:tHB	I
    //   1880: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1883: aastore
    //   1884: dup
    //   1885: iconst_5
    //   1886: aload_0
    //   1887: getfield 646	com/tencent/mm/plugin/voip/video/a:tFL	I
    //   1890: invokestatic 173	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1893: aastore
    //   1894: invokestatic 298	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1897: sipush 5034
    //   1900: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1903: iconst_1
    //   1904: ireturn
    //   1905: astore 18
    //   1907: getstatic 263	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   1910: ldc2_w 264
    //   1913: lconst_0
    //   1914: lconst_1
    //   1915: iconst_0
    //   1916: invokevirtual 269	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   1919: ldc 165
    //   1921: ldc_w 653
    //   1924: iconst_1
    //   1925: anewarray 4	java/lang/Object
    //   1928: dup
    //   1929: iconst_0
    //   1930: aload 18
    //   1932: invokevirtual 402	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1935: aastore
    //   1936: invokestatic 550	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1939: sipush 5034
    //   1942: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1945: iconst_m1
    //   1946: ireturn
    //   1947: getstatic 656	com/tencent/mm/plugin/voip/video/i:tHA	I
    //   1950: istore_2
    //   1951: goto -228 -> 1723
    //   1954: aload 19
    //   1956: getfield 641	android/hardware/Camera$CameraInfo:orientation	I
    //   1959: iload_2
    //   1960: isub
    //   1961: sipush 360
    //   1964: iadd
    //   1965: sipush 360
    //   1968: irem
    //   1969: istore_2
    //   1970: goto -159 -> 1811
    //   1973: astore 18
    //   1975: ldc 165
    //   1977: ldc_w 658
    //   1980: iconst_1
    //   1981: anewarray 4	java/lang/Object
    //   1984: dup
    //   1985: iconst_0
    //   1986: aload 18
    //   1988: invokevirtual 402	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1991: aastore
    //   1992: invokestatic 550	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1995: goto -173 -> 1822
    //   1998: astore 20
    //   2000: goto -534 -> 1466
    //   2003: goto -1422 -> 581
    //   2006: aconst_null
    //   2007: astore 19
    //   2009: goto -1473 -> 536
    //   2012: iload 4
    //   2014: istore 7
    //   2016: iload 6
    //   2018: istore 4
    //   2020: iload 7
    //   2022: istore 6
    //   2024: goto +32 -> 2056
    //   2027: iload 8
    //   2029: ifle -1014 -> 1015
    //   2032: iload 7
    //   2034: ifle -1019 -> 1015
    //   2037: iload 7
    //   2039: iload 8
    //   2041: if_icmplt -1026 -> 1015
    //   2044: iconst_1
    //   2045: istore 17
    //   2047: goto -1740 -> 307
    //   2050: iconst_1
    //   2051: istore 4
    //   2053: goto -1680 -> 373
    //   2056: iload 9
    //   2058: iconst_1
    //   2059: iadd
    //   2060: istore 9
    //   2062: iload 6
    //   2064: istore 7
    //   2066: iload 4
    //   2068: istore 6
    //   2070: iload 7
    //   2072: istore 4
    //   2074: goto -986 -> 1088
    //   2077: iconst_0
    //   2078: istore 7
    //   2080: goto -819 -> 1261
    //   2083: goto -299 -> 1784
    //   2086: iconst_0
    //   2087: istore_2
    //   2088: goto -304 -> 1784
    //   2091: bipush 90
    //   2093: istore_2
    //   2094: goto -310 -> 1784
    //   2097: sipush 180
    //   2100: istore_2
    //   2101: goto -317 -> 1784
    //   2104: sipush 270
    //   2107: istore_2
    //   2108: goto -324 -> 1784
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2111	0	this	a
    //   0	2111	1	paramBoolean	boolean
    //   0	2111	2	paramInt1	int
    //   0	2111	3	paramInt2	int
    //   225	1848	4	i	int
    //   1081	225	5	j	int
    //   263	1806	6	k	int
    //   272	1807	7	m	int
    //   269	1773	8	n	int
    //   1076	985	9	i1	int
    //   1143	161	10	i2	int
    //   169	1173	11	i3	int
    //   1073	32	12	i4	int
    //   1199	82	13	i5	int
    //   1207	64	14	i6	int
    //   1228	21	15	i7	int
    //   31	1267	16	bool1	boolean
    //   27	2019	17	bool2	boolean
    //   161	706	18	localObject1	Object
    //   888	472	18	localException1	Exception
    //   1412	15	18	localException2	Exception
    //   1449	363	18	localObject2	Object
    //   1905	26	18	localException3	Exception
    //   1973	14	18	localException4	Exception
    //   201	557	19	localObject3	Object
    //   988	374	19	localException5	Exception
    //   1378	15	19	localException6	Exception
    //   1710	298	19	localCameraInfo	android.hardware.Camera.CameraInfo
    //   564	544	20	localObject4	Object
    //   1460	18	20	localException7	Exception
    //   1998	1	20	localException8	Exception
    //   471	992	21	arrayOfInt	int[]
    //   554	83	22	localPoint	Point
    // Exception table:
    //   from	to	target	type
    //   137	152	888	java/lang/Exception
    //   929	961	988	java/lang/Exception
    //   961	980	988	java/lang/Exception
    //   176	261	1378	java/lang/Exception
    //   274	304	1378	java/lang/Exception
    //   307	351	1378	java/lang/Exception
    //   1041	1048	1378	java/lang/Exception
    //   1053	1063	1378	java/lang/Exception
    //   1066	1075	1378	java/lang/Exception
    //   1107	1121	1378	java/lang/Exception
    //   1126	1133	1378	java/lang/Exception
    //   1145	1181	1378	java/lang/Exception
    //   1193	1230	1378	java/lang/Exception
    //   1266	1289	1378	java/lang/Exception
    //   1314	1366	1378	java/lang/Exception
    //   378	419	1412	java/lang/Exception
    //   536	566	1460	java/lang/Exception
    //   571	581	1460	java/lang/Exception
    //   589	614	1460	java/lang/Exception
    //   623	650	1460	java/lang/Exception
    //   650	669	1460	java/lang/Exception
    //   1623	1643	1905	java/lang/Exception
    //   1648	1669	1905	java/lang/Exception
    //   1697	1723	1973	java/lang/Exception
    //   1723	1751	1973	java/lang/Exception
    //   1784	1811	1973	java/lang/Exception
    //   1811	1822	1973	java/lang/Exception
    //   1947	1951	1973	java/lang/Exception
    //   1954	1970	1973	java/lang/Exception
    //   669	708	1998	java/lang/Exception
  }
  
  private static u nb(boolean paramBoolean)
  {
    localObject2 = null;
    AppMethodBeat.i(5029);
    if (i.tHy.enO <= 0)
    {
      AppMethodBeat.o(5029);
      return null;
    }
    if (!i.tHE)
    {
      AppMethodBeat.o(5029);
      return null;
    }
    if (paramBoolean == true) {}
    for (;;)
    {
      try
      {
        locala = com.tencent.mm.compatible.e.d.a(ah.getContext(), i.tHz, null);
        ab.i("Camera", "Use front");
        localObject1 = localObject2;
        if (locala != null) {
          localObject1 = locala.eoH;
        }
      }
      catch (Exception localException)
      {
        d.a.a locala;
        h.qsU.idkeyStat(159L, 0L, 1L, false);
        h.qsU.idkeyStat(159L, 1L, 1L, false);
        ab.e("MicroMsg.Voip.CaptureRender", "openCameraByHighApiLvl:error:" + localException.toString());
        Object localObject1 = localObject2;
        continue;
      }
      AppMethodBeat.o(5029);
      return localObject1;
      locala = com.tencent.mm.compatible.e.d.a(ah.getContext(), i.tHA, null);
      ab.i("Camera", "Use back");
    }
  }
  
  private u nc(boolean paramBoolean)
  {
    AppMethodBeat.i(5030);
    Object localObject2 = nb(paramBoolean);
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    for (;;)
    {
      try
      {
        localObject1 = new u(Camera.open());
      }
      catch (Exception localException1)
      {
        ab.e("MicroMsg.Voip.CaptureRender", "OpenCameraError:" + localException1.toString());
        h.qsU.idkeyStat(159L, 0L, 1L, false);
        h.qsU.idkeyStat(159L, 1L, 1L, false);
        if (this.tFE != null) {
          this.tFE.bho();
        }
        AppMethodBeat.o(5030);
        return null;
      }
      try
      {
        localObject2 = ((u)localObject1).getParameters();
        if (!paramBoolean) {
          break label155;
        }
        i = 2;
        ((Camera.Parameters)localObject2).set("camera-id", i);
        ((u)localObject1).setParameters((Camera.Parameters)localObject2);
      }
      catch (Exception localException2)
      {
        h.qsU.idkeyStat(159L, 0L, 1L, false);
        ab.e("MicroMsg.Voip.CaptureRender", "set camera-id error:" + localException2.toString());
        continue;
      }
      this.tFo = paramBoolean;
      h((u)localObject1);
      g((u)localObject1);
      AppMethodBeat.o(5030);
      return localObject1;
      label155:
      int i = 1;
    }
  }
  
  @TargetApi(14)
  public final void B(int[] paramArrayOfInt)
  {
    boolean bool3 = true;
    AppMethodBeat.i(5038);
    if ((ac.eru.eox == 1) && (this.tFA))
    {
      AppMethodBeat.o(5038);
      return;
    }
    if (ac.eru.eow > 2000) {
      this.tFu = ac.eru.eow;
    }
    if (paramArrayOfInt == null)
    {
      ab.e("MicroMsg.Voip.CaptureRender", "focusOnFace error, faceLocation is null");
      boolean bool2;
      if (System.currentTimeMillis() - this.tFt > this.tFu)
      {
        bool1 = true;
        if ((this.tFq) && (!bool1) && (this.tFr == this.tFo)) {
          break label336;
        }
        paramArrayOfInt = new StringBuilder("now i need autoFocus! and !mIsCameraNoParamAutoFocus: ");
        if (this.tFq) {
          break label298;
        }
        bool2 = true;
        label131:
        paramArrayOfInt = paramArrayOfInt.append(bool2).append(",isAutoFocusTimeout: ").append(bool1).append(",mAutoFocusTimeOut:").append(this.tFu).append(",mIsLastAutoFocusFaceCamera != mIsCurrentFaceCamera :");
        if (this.tFr == this.tFo) {
          break label304;
        }
      }
      label298:
      label304:
      for (boolean bool1 = bool3;; bool1 = false)
      {
        ab.i("MicroMsg.Voip.CaptureRender", bool1 + ",isClickScreen :false");
        try
        {
          if ((this.mrD != null) && (this.mrD.getParameters() != null) && (this.mrD.getParameters().getFocusMode() != null) && (this.mrD.getParameters().getFocusMode().equals("auto")))
          {
            this.mrD.autoFocus(null);
            this.tFI = null;
            this.tFt = System.currentTimeMillis();
            this.tFq = true;
            this.tFr = this.tFo;
          }
          AppMethodBeat.o(5038);
          return;
        }
        catch (Exception paramArrayOfInt)
        {
          ab.e("MicroMsg.Voip.CaptureRender", "mCamera.getParameters() or autoFocus fail!" + paramArrayOfInt.toString());
        }
        bool1 = false;
        break;
        bool2 = false;
        break label131;
      }
      label336:
      AppMethodBeat.o(5038);
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
    if (this.tFI == null)
    {
      this.tFI = paramArrayOfInt;
      i = 1;
      localObject = this.tFI;
      j = Math.abs(localObject[0] - paramArrayOfInt[0]);
      k = Math.abs(localObject[1] - paramArrayOfInt[1]);
      m = Math.abs(localObject[2] - paramArrayOfInt[2]);
      k = Math.abs(localObject[3] - paramArrayOfInt[3]) + (j + k + m);
      ab.d("MicroMsg.Voip.CaptureRender", "face location diff:%d", new Object[] { Integer.valueOf(k) });
      if (k <= tFn)
      {
        j = i;
        if (k <= tFm) {}
      }
      else
      {
        this.tFI = paramArrayOfInt;
        if (k > tFn) {
          i = 1;
        }
        j = i;
        if (k > tFm)
        {
          j = 1;
          if ((i != 0) || (j != 0))
          {
            k = this.tFI[0];
            m = this.tFI[1];
            n = this.tFI[2];
            i1 = this.tFI[3];
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramArrayOfInt = new Rect(k, m, n, i1);
        localObject = this.mrD.getParameters();
        k = j;
        ArrayList localArrayList;
        if (j != 0)
        {
          if ((com.tencent.mm.compatible.util.d.fv(14)) && (((Camera.Parameters)localObject).getMaxNumMeteringAreas() > 0))
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
          if ((!com.tencent.mm.compatible.util.d.fv(14)) || (((Camera.Parameters)localObject).getMaxNumFocusAreas() <= 0)) {
            continue;
          }
          localArrayList = new ArrayList();
          localArrayList.add(new Camera.Area(paramArrayOfInt, 1000));
          ((Camera.Parameters)localObject).setFocusAreas(localArrayList);
          j = i;
          break label815;
          this.mrD.setParameters((Camera.Parameters)localObject);
          if (j != 0)
          {
            ab.d("MicroMsg.Voip.CaptureRender", "refocus, mIsFocusOnFace:%b", new Object[] { Boolean.valueOf(this.tFK) });
            if (this.tFK)
            {
              this.tFq = false;
              this.tFK = false;
              this.mrD.autoFocus(new a.1(this));
            }
          }
          AppMethodBeat.o(5038);
          return;
        }
        ab.d("MicroMsg.Voip.CaptureRender", "camera not support metering area");
        k = 0;
        continue;
        ab.d("MicroMsg.Voip.CaptureRender", "camera not support area focus");
        j = 0;
      }
      catch (Exception paramArrayOfInt)
      {
        ab.e("MicroMsg.Voip.CaptureRender", "focusOnFace exception:%s", new Object[] { paramArrayOfInt.getMessage() });
      }
      AppMethodBeat.o(5038);
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
  
  public final int a(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(5027);
    if (i.tHy.enO <= 0)
    {
      this.tFv = 1;
      AppMethodBeat.o(5027);
      return -1;
    }
    if (paramBoolean) {
      if (!i.tHy.tGh) {
        paramBoolean = false;
      }
    }
    for (;;)
    {
      this.tFE = paramf;
      if (j(paramBoolean, this.mWidth, this.mHeight) > 0) {
        break;
      }
      int i = j(paramBoolean, this.mWidth, this.mHeight);
      if (i > 0) {
        break;
      }
      this.tFv = 1;
      AppMethodBeat.o(5027);
      return i;
      if (!i.tHy.tGi) {
        paramBoolean = true;
      }
    }
    cPx();
    this.tFv = 0;
    AppMethodBeat.o(5027);
    return 1;
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder)
  {
    boolean bool1 = false;
    AppMethodBeat.i(5025);
    ab.d("MicroMsg.Voip.CaptureRender", "surfaceChange");
    if ((!this.tFz) || (paramSurfaceHolder.getSurface() == null))
    {
      boolean bool2 = this.tFz;
      if (paramSurfaceHolder.getSurface() == null) {
        bool1 = true;
      }
      ab.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed, CameraOpen: %b, surface: %b, apiLevel: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(5025);
      return;
    }
    try
    {
      if (!this.mrD.eqG) {
        this.mrD.setPreviewCallback(null);
      }
      this.mrD.stopPreview();
      this.mrD.setPreviewDisplay(paramSurfaceHolder);
      cPx();
      this.mrD.startPreview();
      this.mrE = true;
    }
    catch (Exception paramSurfaceHolder)
    {
      for (;;)
      {
        h.qsU.idkeyStat(159L, 0L, 1L, false);
        h.qsU.idkeyStat(159L, 2L, 1L, false);
        ab.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + paramSurfaceHolder.getMessage());
        this.tFv = 1;
      }
    }
    if (this.tFG)
    {
      cPz();
      this.tFG = false;
    }
    if (!bhn()) {
      com.tencent.mm.plugin.voip.b.cLC().Hz(this.tFv);
    }
    AppMethodBeat.o(5025);
  }
  
  public final void a(ObservableSurfaceView paramObservableSurfaceView)
  {
    AppMethodBeat.i(5023);
    ab.d("MicroMsg.Voip.CaptureRender", "bind ObservableSurfaceView");
    if (paramObservableSurfaceView == null)
    {
      AppMethodBeat.o(5023);
      return;
    }
    this.tFC = paramObservableSurfaceView;
    this.tFC.setSurfaceChangeCallback(this);
    this.tFB = true;
    AppMethodBeat.o(5023);
  }
  
  public final void a(ObservableTextureView paramObservableTextureView)
  {
    AppMethodBeat.i(5024);
    ab.i("MicroMsg.Voip.CaptureRender", "bind ObservableTextureView");
    if (paramObservableTextureView == null)
    {
      AppMethodBeat.o(5024);
      return;
    }
    this.tFD = paramObservableTextureView;
    this.tFD.setTextureChangeCallback(this);
    this.tFB = false;
    AppMethodBeat.o(5024);
  }
  
  public final boolean bQT()
  {
    return this.mrE;
  }
  
  public boolean bhn()
  {
    return false;
  }
  
  public final void cPA()
  {
    AppMethodBeat.i(5037);
    ab.d("MicroMsg.Voip.CaptureRender", "StopCapture....mIsInCapture = " + this.tFF);
    if ((this.tFF) && (this.mrD != null))
    {
      this.tFG = false;
      if (!this.mrD.eqG) {
        this.mrD.setPreviewCallback(null);
      }
    }
    try
    {
      this.mrD.stopPreview();
      this.mrE = false;
      this.tFF = false;
      if (1 == this.tFv)
      {
        mo localmo = new mo();
        localmo.cCK.type = 2;
        com.tencent.mm.sdk.b.a.ymk.l(localmo);
      }
      ab.d("MicroMsg.Voip.CaptureRender", "UnInitCapture....mCameraOpen = " + this.tFz);
      if (this.tFz)
      {
        this.tFv = 0;
        this.tFG = false;
        if ((this.mrD != null) && (!this.mrD.eqG))
        {
          this.mrD.setPreviewCallback(null);
          this.mrD.release();
        }
        this.mrD = null;
        this.tFz = false;
        this.tFH = null;
        if (this.tFJ != null) {
          this.tFJ.clear();
        }
        this.tFJ = null;
        this.tFA = false;
        AppMethodBeat.o(5037);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.Voip.CaptureRender", "stopPreview:error" + localException.toString());
        continue;
        if (this.mrD != null)
        {
          if (!this.mrD.eqG) {
            this.mrD.setPreviewCallback(null);
          }
          this.mrD.release();
          this.mrD = null;
          this.tFz = false;
        }
      }
    }
  }
  
  public final boolean cPB()
  {
    return this.tFo;
  }
  
  public final boolean cPC()
  {
    return this.tFp;
  }
  
  public final int cPD()
  {
    return this.tFv;
  }
  
  public final void cPy()
  {
    AppMethodBeat.i(5035);
    if (i.tHy.enO < 2)
    {
      ab.e("MicroMsg.Voip.CaptureRender", "ExchangeCapture...gCameraNum= " + i.tHy.enO);
      AppMethodBeat.o(5035);
      return;
    }
    ab.i("MicroMsg.Voip.CaptureRender", "ExchangeCapture start, gCameraNum= " + i.tHy.enO);
    cPA();
    f localf = this.tFE;
    if (!this.tFo) {}
    for (boolean bool = true;; bool = false)
    {
      a(localf, bool);
      cPz();
      if (!bhn()) {
        com.tencent.mm.plugin.voip.b.cLC().Hz(this.tFv);
      }
      this.tFK = true;
      AppMethodBeat.o(5035);
      return;
    }
  }
  
  /* Error */
  public final int cPz()
  {
    // Byte code:
    //   0: sipush 5036
    //   3: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 109	com/tencent/mm/plugin/voip/video/a:tFz	Z
    //   10: ifne +24 -> 34
    //   13: ldc 165
    //   15: ldc_w 910
    //   18: invokestatic 287	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 107	com/tencent/mm/plugin/voip/video/a:tFv	I
    //   26: sipush 5036
    //   29: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: iconst_m1
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 117	com/tencent/mm/plugin/voip/video/a:tFF	Z
    //   38: ifeq +19 -> 57
    //   41: ldc 165
    //   43: ldc_w 912
    //   46: invokestatic 287	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: sipush 5036
    //   52: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_m1
    //   56: ireturn
    //   57: aload_0
    //   58: getfield 115	com/tencent/mm/plugin/voip/video/a:tFC	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   61: ifnull +34 -> 95
    //   64: aload_0
    //   65: getfield 115	com/tencent/mm/plugin/voip/video/a:tFC	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   68: invokevirtual 915	com/tencent/mm/plugin/video/ObservableSurfaceView:cLd	()Z
    //   71: ifne +24 -> 95
    //   74: ldc 165
    //   76: ldc_w 917
    //   79: invokestatic 315	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_0
    //   83: iconst_1
    //   84: putfield 119	com/tencent/mm/plugin/voip/video/a:tFG	Z
    //   87: sipush 5036
    //   90: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iconst_0
    //   94: ireturn
    //   95: ldc 165
    //   97: ldc_w 919
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_0
    //   107: getfield 113	com/tencent/mm/plugin/voip/video/a:tFB	Z
    //   110: invokestatic 296	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   113: aastore
    //   114: invokestatic 179	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload_0
    //   118: getfield 115	com/tencent/mm/plugin/voip/video/a:tFC	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   121: ifnull +109 -> 230
    //   124: aload_0
    //   125: getfield 113	com/tencent/mm/plugin/voip/video/a:tFB	Z
    //   128: ifeq +102 -> 230
    //   131: aload_0
    //   132: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   135: aload_0
    //   136: getfield 115	com/tencent/mm/plugin/voip/video/a:tFC	Lcom/tencent/mm/plugin/video/ObservableSurfaceView;
    //   139: invokevirtual 923	com/tencent/mm/plugin/video/ObservableSurfaceView:getSurfaceHolder	()Landroid/view/SurfaceHolder;
    //   142: invokevirtual 819	com/tencent/mm/compatible/e/u:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   145: aload_0
    //   146: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   149: invokevirtual 822	com/tencent/mm/compatible/e/u:startPreview	()V
    //   152: aload_0
    //   153: iconst_1
    //   154: putfield 137	com/tencent/mm/plugin/voip/video/a:mrE	Z
    //   157: aload_0
    //   158: iconst_1
    //   159: putfield 117	com/tencent/mm/plugin/voip/video/a:tFF	Z
    //   162: sipush 5036
    //   165: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: iconst_1
    //   169: ireturn
    //   170: astore_1
    //   171: getstatic 263	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   174: ldc2_w 264
    //   177: lconst_0
    //   178: lconst_1
    //   179: iconst_0
    //   180: invokevirtual 269	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   183: getstatic 263	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   186: ldc2_w 264
    //   189: ldc2_w 840
    //   192: lconst_1
    //   193: iconst_0
    //   194: invokevirtual 269	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   197: aload_0
    //   198: iconst_1
    //   199: putfield 107	com/tencent/mm/plugin/voip/video/a:tFv	I
    //   202: ldc 165
    //   204: new 271	java/lang/StringBuilder
    //   207: dup
    //   208: ldc_w 925
    //   211: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: aload_1
    //   215: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   218: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 287	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: goto -82 -> 145
    //   230: aload_0
    //   231: getfield 857	com/tencent/mm/plugin/voip/video/a:tFD	Lcom/tencent/mm/plugin/video/ObservableTextureView;
    //   234: ifnull -89 -> 145
    //   237: aload_0
    //   238: getfield 113	com/tencent/mm/plugin/voip/video/a:tFB	Z
    //   241: ifne -96 -> 145
    //   244: aload_0
    //   245: getfield 362	com/tencent/mm/plugin/voip/video/a:mrD	Lcom/tencent/mm/compatible/e/u;
    //   248: aload_0
    //   249: getfield 857	com/tencent/mm/plugin/voip/video/a:tFD	Lcom/tencent/mm/plugin/video/ObservableTextureView;
    //   252: invokevirtual 929	com/tencent/mm/plugin/video/ObservableTextureView:getSurfaceTexture	()Landroid/graphics/SurfaceTexture;
    //   255: invokevirtual 933	com/tencent/mm/compatible/e/u:setPreviewTexture	(Landroid/graphics/SurfaceTexture;)V
    //   258: goto -113 -> 145
    //   261: astore_1
    //   262: getstatic 263	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   265: ldc2_w 264
    //   268: lconst_0
    //   269: lconst_1
    //   270: iconst_0
    //   271: invokevirtual 269	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   274: getstatic 263	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   277: ldc2_w 264
    //   280: ldc2_w 840
    //   283: lconst_1
    //   284: iconst_0
    //   285: invokevirtual 269	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   288: aload_0
    //   289: iconst_1
    //   290: putfield 107	com/tencent/mm/plugin/voip/video/a:tFv	I
    //   293: ldc 165
    //   295: new 271	java/lang/StringBuilder
    //   298: dup
    //   299: ldc_w 925
    //   302: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   305: aload_1
    //   306: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   309: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 287	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: goto -173 -> 145
    //   321: astore_1
    //   322: getstatic 263	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   325: ldc2_w 264
    //   328: lconst_0
    //   329: lconst_1
    //   330: iconst_0
    //   331: invokevirtual 269	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   334: getstatic 263	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   337: ldc2_w 264
    //   340: ldc2_w 840
    //   343: lconst_1
    //   344: iconst_0
    //   345: invokevirtual 269	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   348: aload_0
    //   349: iconst_1
    //   350: putfield 107	com/tencent/mm/plugin/voip/video/a:tFv	I
    //   353: aload_0
    //   354: getfield 552	com/tencent/mm/plugin/voip/video/a:tFE	Lcom/tencent/mm/plugin/voip/video/f;
    //   357: ifnull +12 -> 369
    //   360: aload_0
    //   361: getfield 552	com/tencent/mm/plugin/voip/video/a:tFE	Lcom/tencent/mm/plugin/voip/video/f;
    //   364: invokeinterface 557 1 0
    //   369: ldc 165
    //   371: new 271	java/lang/StringBuilder
    //   374: dup
    //   375: ldc_w 935
    //   378: invokespecial 276	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   381: aload_1
    //   382: invokevirtual 279	java/lang/Exception:toString	()Ljava/lang/String;
    //   385: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 287	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public final void f(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool1 = false;
    AppMethodBeat.i(5026);
    ab.d("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable");
    if ((!this.tFz) || (paramSurfaceTexture == null))
    {
      boolean bool2 = this.tFz;
      if (paramSurfaceTexture == null) {
        bool1 = true;
      }
      ab.e("MicroMsg.Voip.CaptureRender", "onSurfaceTextureAvailable failed, CameraOpen: %b, surface: %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      AppMethodBeat.o(5026);
      return;
    }
    try
    {
      if (!this.mrD.eqG) {
        this.mrD.setPreviewCallback(null);
      }
      this.mrD.stopPreview();
      this.mrD.setPreviewTexture(paramSurfaceTexture);
      cPx();
      this.mrD.startPreview();
      this.mrE = true;
    }
    catch (Exception paramSurfaceTexture)
    {
      for (;;)
      {
        h.qsU.idkeyStat(159L, 0L, 1L, false);
        h.qsU.idkeyStat(159L, 2L, 1L, false);
        ab.e("MicroMsg.Voip.CaptureRender", "surfaceChange failed" + paramSurfaceTexture.getMessage());
        this.tFv = 1;
      }
    }
    if (this.tFG)
    {
      cPz();
      this.tFG = false;
    }
    if (!bhn()) {
      com.tencent.mm.plugin.voip.b.cLC().Hz(this.tFv);
    }
    AppMethodBeat.o(5026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a
 * JD-Core Version:    0.7.0.1
 */