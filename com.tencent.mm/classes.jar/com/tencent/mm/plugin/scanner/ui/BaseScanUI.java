package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.a.mo.b;
import com.tencent.mm.g.a.mq;
import com.tencent.mm.g.a.qa;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.1;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.a;
import com.tencent.mm.plugin.scanner.util.f;
import com.tencent.mm.plugin.scanner.util.f.a;
import com.tencent.mm.plugin.scanner.util.t;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(3)
public class BaseScanUI
  extends MMActivity
  implements Camera.AutoFocusCallback, Camera.PreviewCallback, TextureView.SurfaceTextureListener, i.b
{
  private final Object ceY;
  private int cpY;
  private int[] gEs;
  private com.tencent.mm.sdk.b.c<ux> kSY;
  private volatile boolean mof;
  private boolean pbN;
  private final long qvG;
  private final int qvH;
  private MMTextureView qvI;
  private SurfaceTexture qvJ;
  private LinearLayout qvK;
  private TextView qvL;
  private FrameLayout qvM;
  private com.tencent.mm.plugin.scanner.util.j qvN;
  private Point qvO;
  private SelectScanModePanel qvP;
  private ScanMaskView qvQ;
  private ScannerFlashSwitcher qvR;
  private boolean qvS;
  private boolean qvT;
  private boolean qvU;
  private i.a qvV;
  private int qvW;
  private int qvX;
  private int qvY;
  private int qvZ;
  private final int qwA;
  protected ak qwB;
  protected ak qwC;
  private com.tencent.mm.sdk.b.c qwD;
  protected ak qwE;
  protected final int qwF;
  protected final int qwG;
  protected final int qwH;
  private boolean qwa;
  private Rect qwb;
  private TextView qwc;
  private View qwd;
  private boolean qwe;
  private boolean qwf;
  private boolean qwg;
  private boolean qwh;
  private f qwi;
  private TranslateAnimation qwj;
  private ImageView qwk;
  private i qwl;
  private int qwm;
  private int qwn;
  private int qwo;
  private boolean qwp;
  private boolean qwq;
  private boolean qwr;
  private long qws;
  private long qwt;
  private Set<Integer> qwu;
  private int qwv;
  private ValueAnimator qww;
  private com.tencent.mm.network.n qwx;
  private com.tencent.mm.sdk.b.c<mq> qwy;
  protected ak qwz;
  private PowerManager.WakeLock wakeLock;
  
  public BaseScanUI()
  {
    AppMethodBeat.i(80943);
    this.qvG = 150L;
    this.qvH = 2;
    this.mof = false;
    this.ceY = new Object();
    this.qvQ = null;
    this.qvS = false;
    this.qvT = false;
    this.qvU = true;
    this.qwa = true;
    this.qwb = new Rect();
    this.qwe = false;
    this.qwf = true;
    this.qwg = false;
    this.qwh = false;
    this.qwi = null;
    this.wakeLock = null;
    this.qwm = 0;
    this.cpY = 0;
    this.qwn = 0;
    this.qwo = 0;
    this.qwp = true;
    this.qwq = false;
    this.qwr = false;
    this.gEs = new int[8];
    this.qwu = new HashSet();
    this.kSY = new BaseScanUI.1(this);
    this.qwx = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(138468);
        if (!BaseScanUI.b(BaseScanUI.this))
        {
          AppMethodBeat.o(138468);
          return;
        }
        new ak(Looper.getMainLooper()).post(new BaseScanUI.12.1(this, paramAnonymousInt));
        AppMethodBeat.o(138468);
      }
    };
    this.qwy = new com.tencent.mm.sdk.b.c() {};
    this.qwz = new BaseScanUI.9(this);
    this.qwA = 2600;
    this.pbN = false;
    this.qwB = new BaseScanUI.16(this);
    this.qwC = new BaseScanUI.17(this);
    this.qwD = new BaseScanUI.18(this);
    this.qwE = new BaseScanUI.19(this);
    this.qwF = 0;
    this.qwG = 1;
    this.qwH = 2;
    AppMethodBeat.o(80943);
  }
  
  private boolean Ll()
  {
    AppMethodBeat.i(80982);
    if ((7 == this.qwm) || (9 == this.qwm) || (10 == this.qwm) || (11 == this.qwm) || (com.tencent.mm.compatible.e.d.Ll()))
    {
      AppMethodBeat.o(80982);
      return true;
    }
    AppMethodBeat.o(80982);
    return false;
  }
  
  private void bvO()
  {
    AppMethodBeat.i(80964);
    com.tencent.mm.sdk.g.d.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138469);
        if (BaseScanUI.a(BaseScanUI.this) == null)
        {
          AppMethodBeat.o(138469);
          return;
        }
        synchronized (BaseScanUI.u(BaseScanUI.this))
        {
          if ((!BaseScanUI.C(BaseScanUI.this)) && (BaseScanUI.a(BaseScanUI.this) != null))
          {
            BaseScanUI.d(BaseScanUI.this, true);
            ab.i("MicroMsg.scanner.BaseScanUI", "closeCamera");
            BaseScanUI.a(BaseScanUI.this).release();
            BaseScanUI.D(BaseScanUI.this);
            BaseScanUI.d(BaseScanUI.this, false);
            ab.i("MicroMsg.scanner.BaseScanUI", "scanCamera.release() done");
          }
          AppMethodBeat.o(138469);
          return;
        }
      }
    }, "BaseScanUI_closeCamera");
    AppMethodBeat.o(80964);
  }
  
  private void byJ()
  {
    AppMethodBeat.i(80981);
    qa localqa = new qa();
    localqa.cGC.bsY = 1;
    com.tencent.mm.sdk.b.a.ymk.l(localqa);
    setResult(0);
    finish();
    AppMethodBeat.o(80981);
  }
  
  private void ciA()
  {
    AppMethodBeat.i(80962);
    this.qvN.a(new Camera.PreviewCallback()
    {
      public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera) {}
    });
    AppMethodBeat.o(80962);
  }
  
  private void ciB()
  {
    AppMethodBeat.i(80965);
    if (this.qvS)
    {
      AppMethodBeat.o(80965);
      return;
    }
    this.qvS = true;
    kA(true);
    Object localObject = new mo();
    ((mo)localObject).cCK.type = 2;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    if (((mo)localObject).cCL.cCJ)
    {
      ab.i("MicroMsg.scanner.BaseScanUI", "Permission dialog showed");
      this.qvT = true;
      bvO();
      byJ();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(80965);
      return;
    }
    localObject = com.tencent.mm.ui.base.h.a(this, getString(2131302923), getString(2131297087), new BaseScanUI.14(this));
    if (localObject == null)
    {
      ab.d("MicroMsg.scanner.BaseScanUI", "comfirmDialog == null");
      AppMethodBeat.o(80965);
      return;
    }
    ((com.tencent.mm.ui.widget.b.c)localObject).setCancelable(false);
    ((com.tencent.mm.ui.widget.b.c)localObject).setCanceledOnTouchOutside(false);
    ((com.tencent.mm.ui.widget.b.c)localObject).show();
    AppMethodBeat.o(80965);
  }
  
  private void ciD()
  {
    AppMethodBeat.i(80968);
    this.qvO = new Point();
    getWindowManager().getDefaultDisplay().getSize(this.qvO);
    ab.d("MicroMsg.scanner.BaseScanUI", "update visible rect:%s", new Object[] { this.qvO });
    AppMethodBeat.o(80968);
  }
  
  private boolean cit()
  {
    AppMethodBeat.i(151659);
    if (this.qwm == 1)
    {
      com.tencent.mm.plugin.scanner.util.c localc = com.tencent.mm.plugin.scanner.util.c.qCh;
      if (com.tencent.mm.plugin.scanner.util.c.CL(this.qwn))
      {
        AppMethodBeat.o(151659);
        return true;
      }
    }
    AppMethodBeat.o(151659);
    return false;
  }
  
  private void ciu()
  {
    AppMethodBeat.i(80950);
    if (this.qwl == null)
    {
      AppMethodBeat.o(80950);
      return;
    }
    ciC();
    AppMethodBeat.o(80950);
  }
  
  private void civ()
  {
    AppMethodBeat.i(80956);
    if (this.qvR != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qvR.getLayoutParams();
      if (this.qwm == 3) {}
      for (localLayoutParams.topMargin = (this.qvP.getTop() - com.tencent.mm.cb.a.fromDPToPix(this, 70));; localLayoutParams.topMargin = (this.qwb.top + (this.qwb.height() - com.tencent.mm.cb.a.fromDPToPix(this, 70))))
      {
        ab.b("MicroMsg.scanner.BaseScanUI", "initFlashSwitcher, scanMaskRect: %s, scanLineStart: %s, scanLineEnd: %s", new Object[] { this.qwb, Integer.valueOf(this.qvY), Integer.valueOf(this.qvZ) });
        this.qvR.setLayoutParams(localLayoutParams);
        this.qvR.setOnClickListener(new BaseScanUI.8(this));
        if ((this.qvN == null) || (!this.qvN.oHg)) {
          break;
        }
        this.qvR.setVisibility(0);
        AppMethodBeat.o(80956);
        return;
      }
      this.qvR.setVisibility(8);
    }
    AppMethodBeat.o(80956);
  }
  
  private void ciw()
  {
    AppMethodBeat.i(80957);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.qwk.getLayoutParams();
    if (this.qwa)
    {
      localLayoutParams.width = this.qvW;
      localLayoutParams.gravity = 1;
    }
    for (;;)
    {
      this.qwk.setLayoutParams(localLayoutParams);
      this.qwk.invalidate();
      this.qwk.setVisibility(0);
      if (!this.qwa) {
        break;
      }
      this.qwj = new TranslateAnimation(0.0F, 0.0F, this.qvY, this.qvZ);
      AppMethodBeat.o(80957);
      return;
      localLayoutParams.height = this.qvX;
      localLayoutParams.gravity = 48;
      localLayoutParams.topMargin = this.qwb.top;
    }
    this.qwj = new TranslateAnimation(this.qvY, this.qvZ, 0.0F, 0.0F);
    AppMethodBeat.o(80957);
  }
  
  private void ciz()
  {
    AppMethodBeat.i(80961);
    al.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(138466);
        try
        {
          if (BaseScanUI.a(BaseScanUI.this) == null)
          {
            ab.w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in openCamera()");
            AppMethodBeat.o(138466);
            return;
          }
          if (!BaseScanUI.t(BaseScanUI.this)) {
            BaseScanUI.c(BaseScanUI.this, true);
          }
          if (BaseScanUI.a(BaseScanUI.this).isOpen()) {
            ab.i("MicroMsg.scanner.BaseScanUI", "camera already open");
          }
          for (;;)
          {
            al.p(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(138465);
                BaseScanUI.A(BaseScanUI.this);
                AppMethodBeat.o(138465);
              }
            }, 50L);
            BaseScanUI.a(BaseScanUI.this).f(BaseScanUI.B(BaseScanUI.this));
            BaseScanUI.i(BaseScanUI.this).kE(BaseScanUI.this.ciF());
            BaseScanUI.i(BaseScanUI.this).g(BaseScanUI.a(BaseScanUI.this).miT);
            if (BaseScanUI.a(BaseScanUI.this) != null) {
              ab.i("MicroMsg.scanner.BaseScanUI", "alvinluo openCameraImpl scanCamera isPreviewing: %b", new Object[] { Boolean.valueOf(BaseScanUI.a(BaseScanUI.this).miS) });
            }
            if ((BaseScanUI.a(BaseScanUI.this) != null) && (BaseScanUI.a(BaseScanUI.this).miS)) {
              BaseScanUI.this.lg(0L);
            }
            AppMethodBeat.o(138466);
            return;
            synchronized (BaseScanUI.u(BaseScanUI.this))
            {
              BaseScanUI.a(BaseScanUI.this).open();
              ab.d("MicroMsg.scanner.BaseScanUI", "scanCamera.open done");
              BaseScanUI.v(BaseScanUI.this);
              BaseScanUI.c(BaseScanUI.this, false);
            }
          }
          return;
        }
        catch (Exception localException)
        {
          ab.w("MicroMsg.scanner.BaseScanUI", "Exception in scanCamera.open(), [%s]", new Object[] { localException.toString() });
          ab.printErrStackTrace("MicroMsg.scanner.BaseScanUI", localException, "", new Object[0]);
          BaseScanUI.w(BaseScanUI.this);
          if (BaseScanUI.x(BaseScanUI.this) >= 5)
          {
            BaseScanUI.y(BaseScanUI.this);
            AppMethodBeat.o(138466);
            return;
          }
          al.p(new BaseScanUI.10.1(this), 300L);
          AppMethodBeat.o(138466);
        }
      }
    }, 25L);
    AppMethodBeat.o(80961);
  }
  
  private void f(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(80958);
    if ((this.qvY < 0) || (this.qvZ <= 0) || (this.qwl == null) || (!this.qwl.cir()))
    {
      cix();
      AppMethodBeat.o(80958);
      return;
    }
    if (paramBoolean) {
      ciw();
    }
    this.qwz.removeMessages(1);
    if (paramLong <= 0L)
    {
      this.qwz.sendEmptyMessage(1);
      AppMethodBeat.o(80958);
      return;
    }
    cix();
    this.qwz.sendEmptyMessageDelayed(1, paramLong);
    AppMethodBeat.o(80958);
  }
  
  /* Error */
  private void startPreview()
  {
    // Byte code:
    //   0: ldc_w 688
    //   3: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 141	com/tencent/mm/plugin/scanner/ui/BaseScanUI:mof	Z
    //   10: ifne +10 -> 20
    //   13: aload_0
    //   14: getfield 261	com/tencent/mm/plugin/scanner/ui/BaseScanUI:qvN	Lcom/tencent/mm/plugin/scanner/util/j;
    //   17: ifnonnull +19 -> 36
    //   20: ldc_w 426
    //   23: ldc_w 690
    //   26: invokestatic 693	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc_w 688
    //   32: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: return
    //   36: aload_0
    //   37: getfield 261	com/tencent/mm/plugin/scanner/ui/BaseScanUI:qvN	Lcom/tencent/mm/plugin/scanner/util/j;
    //   40: invokevirtual 696	com/tencent/mm/plugin/scanner/util/j:isOpen	()Z
    //   43: ifne +19 -> 62
    //   46: ldc_w 426
    //   49: ldc_w 698
    //   52: invokestatic 693	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: ldc_w 688
    //   58: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: return
    //   62: aload_0
    //   63: getfield 700	com/tencent/mm/plugin/scanner/ui/BaseScanUI:qvJ	Landroid/graphics/SurfaceTexture;
    //   66: ifnonnull +19 -> 85
    //   69: ldc_w 426
    //   72: ldc_w 702
    //   75: invokestatic 693	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: ldc_w 688
    //   81: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: return
    //   85: aload_0
    //   86: getfield 261	com/tencent/mm/plugin/scanner/ui/BaseScanUI:qvN	Lcom/tencent/mm/plugin/scanner/util/j;
    //   89: getfield 705	com/tencent/mm/plugin/scanner/util/j:miS	Z
    //   92: ifeq +19 -> 111
    //   95: ldc_w 426
    //   98: ldc_w 707
    //   101: invokestatic 693	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: ldc_w 688
    //   107: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: return
    //   111: ldc_w 426
    //   114: ldc_w 709
    //   117: invokestatic 433	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: getfield 146	com/tencent/mm/plugin/scanner/ui/BaseScanUI:ceY	Ljava/lang/Object;
    //   124: astore_1
    //   125: aload_1
    //   126: monitorenter
    //   127: aload_0
    //   128: invokespecial 711	com/tencent/mm/plugin/scanner/ui/BaseScanUI:ciA	()V
    //   131: aload_0
    //   132: getfield 261	com/tencent/mm/plugin/scanner/ui/BaseScanUI:qvN	Lcom/tencent/mm/plugin/scanner/util/j;
    //   135: aload_0
    //   136: getfield 700	com/tencent/mm/plugin/scanner/ui/BaseScanUI:qvJ	Landroid/graphics/SurfaceTexture;
    //   139: invokevirtual 714	com/tencent/mm/plugin/scanner/util/j:k	(Landroid/graphics/SurfaceTexture;)V
    //   142: ldc_w 426
    //   145: ldc_w 716
    //   148: invokestatic 433	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_0
    //   152: getfield 189	com/tencent/mm/plugin/scanner/ui/BaseScanUI:gEs	[I
    //   155: iconst_5
    //   156: invokestatic 722	java/lang/System:currentTimeMillis	()J
    //   159: aload_0
    //   160: getfield 724	com/tencent/mm/plugin/scanner/ui/BaseScanUI:qws	J
    //   163: lsub
    //   164: l2i
    //   165: iastore
    //   166: aload_0
    //   167: getfield 261	com/tencent/mm/plugin/scanner/ui/BaseScanUI:qvN	Lcom/tencent/mm/plugin/scanner/util/j;
    //   170: invokevirtual 728	com/tencent/mm/plugin/scanner/util/j:getFocusMode	()Ljava/lang/String;
    //   173: invokestatic 734	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   176: ifne +86 -> 262
    //   179: aload_0
    //   180: getfield 261	com/tencent/mm/plugin/scanner/ui/BaseScanUI:qvN	Lcom/tencent/mm/plugin/scanner/util/j;
    //   183: invokevirtual 728	com/tencent/mm/plugin/scanner/util/j:getFocusMode	()Ljava/lang/String;
    //   186: ldc_w 736
    //   189: invokevirtual 742	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   192: ifeq +70 -> 262
    //   195: aload_0
    //   196: getfield 261	com/tencent/mm/plugin/scanner/ui/BaseScanUI:qvN	Lcom/tencent/mm/plugin/scanner/util/j;
    //   199: invokevirtual 745	com/tencent/mm/plugin/scanner/util/j:cancelAutoFocus	()V
    //   202: aload_0
    //   203: lconst_0
    //   204: invokevirtual 298	com/tencent/mm/plugin/scanner/ui/BaseScanUI:lf	(J)V
    //   207: aload_1
    //   208: monitorexit
    //   209: ldc_w 688
    //   212: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: return
    //   216: astore_1
    //   217: ldc_w 426
    //   220: ldc_w 747
    //   223: iconst_1
    //   224: anewarray 143	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_1
    //   230: invokevirtual 750	java/lang/Exception:toString	()Ljava/lang/String;
    //   233: aastore
    //   234: invokestatic 752	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: ldc_w 426
    //   240: aload_1
    //   241: ldc_w 754
    //   244: iconst_0
    //   245: anewarray 143	java/lang/Object
    //   248: invokestatic 758	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: aload_0
    //   252: invokespecial 760	com/tencent/mm/plugin/scanner/ui/BaseScanUI:ciB	()V
    //   255: ldc_w 688
    //   258: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: return
    //   262: getstatic 766	com/tencent/mm/compatible/e/ac:eru	Lcom/tencent/mm/compatible/e/c;
    //   265: getfield 771	com/tencent/mm/compatible/e/c:eor	J
    //   268: lconst_0
    //   269: lcmp
    //   270: ifle +20 -> 290
    //   273: aload_0
    //   274: getstatic 766	com/tencent/mm/compatible/e/ac:eru	Lcom/tencent/mm/compatible/e/c;
    //   277: getfield 771	com/tencent/mm/compatible/e/c:eor	J
    //   280: l2f
    //   281: getstatic 776	com/tencent/mm/platformtools/ae:glu	F
    //   284: fmul
    //   285: f2i
    //   286: i2l
    //   287: invokevirtual 298	com/tencent/mm/plugin/scanner/ui/BaseScanUI:lf	(J)V
    //   290: aload_0
    //   291: lconst_0
    //   292: invokevirtual 779	com/tencent/mm/plugin/scanner/ui/BaseScanUI:lg	(J)V
    //   295: goto -88 -> 207
    //   298: astore_2
    //   299: aload_1
    //   300: monitorexit
    //   301: ldc_w 688
    //   304: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: aload_2
    //   308: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	BaseScanUI
    //   216	84	1	localException	Exception
    //   298	10	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	20	216	java/lang/Exception
    //   20	29	216	java/lang/Exception
    //   36	55	216	java/lang/Exception
    //   62	78	216	java/lang/Exception
    //   85	104	216	java/lang/Exception
    //   111	127	216	java/lang/Exception
    //   209	215	216	java/lang/Exception
    //   301	309	216	java/lang/Exception
    //   127	207	298	finally
    //   207	209	298	finally
    //   262	290	298	finally
    //   290	295	298	finally
    //   299	301	298	finally
  }
  
  public final void a(i.a parama)
  {
    this.qvV = parama;
  }
  
  public final void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, f.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(151660);
    ab.i("MicroMsg.scanner.BaseScanUI", "dealQBarString, qbarString: %s, codeType: %s, codeVersion: %s, typeName: %s, scanEntryScene: %d", new Object[] { paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString2, Integer.valueOf(this.qwn) });
    if (this.qwi != null) {
      this.qwi.cjt();
    }
    Bundle localBundle = getIntent().getBundleExtra("_stat_obj");
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    this.qwi = new f();
    this.qwi.a(this, paramString1, paramInt1, paramInt2, paramInt3, paramString2, parama, paramBundle, this.qwn, false, -1);
    if ((this.qwm == 1) || (this.qwm == 8) || (this.qwm == 4))
    {
      paramString1 = com.tencent.mm.plugin.scanner.model.n.qux;
      paramInt1 = com.tencent.mm.plugin.scanner.model.n.quu;
    }
    AppMethodBeat.o(151660);
  }
  
  public final void ab(int paramInt, long paramLong)
  {
    AppMethodBeat.i(80969);
    this.qwB.removeMessages(0);
    this.qwB.sendEmptyMessageDelayed(paramInt, paramLong);
    this.qvP.setSelectedMode(paramInt);
    AppMethodBeat.o(80969);
  }
  
  public final void ag(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(80988);
    label278:
    for (;;)
    {
      synchronized (this.ceY)
      {
        if ((!this.mof) && (this.qvN != null) && (this.qvN.miS))
        {
          ab.i("MicroMsg.scanner.BaseScanUI", "zoom camera,action:%d,type:%d,scale:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          int i = this.qvN.cjD();
          if ((this.qwm != 1) && (this.qwm != 8) && (this.qwm != 4)) {
            break label250;
          }
          if ((paramInt2 == 1) && (!((p)this.qwl).ciW()))
          {
            ab.d("MicroMsg.scanner.BaseScanUI", "auto zoom is disable");
            AppMethodBeat.o(80988);
            return;
          }
          if (paramInt1 != 6) {
            continue;
          }
          this.qvN.CR(paramInt3);
          if (paramInt2 == 2) {
            ((p)this.qwl).ciV();
          }
          if (this.qvN.cjD() != i)
          {
            com.tencent.mm.plugin.scanner.model.n localn = com.tencent.mm.plugin.scanner.model.n.qux;
            this.qvN.cjD();
            if (paramInt2 != 1) {
              break label278;
            }
            localn.quK |= 0x1;
          }
        }
        AppMethodBeat.o(80988);
        return;
        this.qvN.CS(paramInt1);
      }
      label250:
      if (paramInt1 == 6)
      {
        this.qvN.CR(paramInt3);
      }
      else
      {
        this.qvN.CS(paramInt1);
        continue;
        if (paramInt2 == 2) {
          localObject2.quK |= 0x2;
        }
      }
    }
  }
  
  public final void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(80977);
    if (this.qvK != null)
    {
      if (!getIntent().getBooleanExtra("key_is_hide_right_btn", false))
      {
        if (paramOnClickListener != null)
        {
          this.qvK.setVisibility(paramInt);
          this.qvK.setOnClickListener(paramOnClickListener);
          this.qvL.setBackgroundDrawable(null);
          this.qvL.setText(getString(2131303081));
          AppMethodBeat.o(80977);
        }
      }
      else
      {
        this.qvK.setVisibility(8);
        AppMethodBeat.o(80977);
      }
    }
    else if (!getIntent().getBooleanExtra("key_is_hide_right_btn", false))
    {
      if (paramOnClickListener != null)
      {
        addIconOptionMenu(0, 2131230740, new BaseScanUI.20(this, paramOnClickListener));
        AppMethodBeat.o(80977);
        return;
      }
      removeOptionMenu(0);
    }
    AppMethodBeat.o(80977);
  }
  
  public final void ciC()
  {
    AppMethodBeat.i(80966);
    for (;;)
    {
      try
      {
        ciD();
        if (this.qwl == null)
        {
          ab.d("MicroMsg.scanner.BaseScanUI", "initBodyByScanMode null scanMode");
          AppMethodBeat.o(80966);
          return;
        }
        this.qwl.f(this.qvO);
        Rect localRect = this.qwl.H(true, Ll());
        Object localObject = new FrameLayout.LayoutParams(localRect.width(), localRect.height(), 3);
        ((FrameLayout.LayoutParams)localObject).leftMargin = localRect.left;
        ((FrameLayout.LayoutParams)localObject).topMargin = localRect.top;
        this.qvW = localRect.width();
        this.qvX = localRect.height();
        ab.d("MicroMsg.scanner.BaseScanUI", "mask : leftMargin=[%s], topMargin=[%s], width=[%s], height=[%s]", new Object[] { Integer.valueOf(((FrameLayout.LayoutParams)localObject).leftMargin), Integer.valueOf(((FrameLayout.LayoutParams)localObject).topMargin), Integer.valueOf(this.qvW), Integer.valueOf(this.qvX) });
        localRect = new Rect(((FrameLayout.LayoutParams)localObject).leftMargin, ((FrameLayout.LayoutParams)localObject).topMargin, ((FrameLayout.LayoutParams)localObject).leftMargin + this.qvW, ((FrameLayout.LayoutParams)localObject).topMargin + this.qvX);
        if (this.qvO.x - localRect.right < localRect.left)
        {
          ab.w("MicroMsg.scanner.BaseScanUI", "this is a special device");
          if (this.qvO.x - localRect.left > localRect.left) {
            localRect.right = (this.qvO.x - localRect.left);
          }
        }
        if (this.qvQ != null)
        {
          localObject = this.qvQ.getMaskRect();
          this.qvQ.ciQ();
          this.qvQ = new ScanMaskView(this, (Rect)localObject);
          localObject = new FrameLayout.LayoutParams(-1, -1);
          this.qvQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if ((this.qwm == 3) && (t.cjO())) {
            this.qvQ.setMaskAnimaListener(new BaseScanUI.15(this));
          }
          this.qvM.removeAllViews();
          View.inflate(this, this.qwl.cin(), this.qvM);
          this.qwl.dz(this.qvM.getChildAt(0));
          this.qwl.cip();
          this.qwl.dA(this.qvM);
          this.qvM.addView(this.qvQ, 0, (ViewGroup.LayoutParams)localObject);
          this.qvQ.l(localRect);
          this.qwl.k(localRect);
          this.qvQ.setBackgroundColor(0);
          ab.d("MicroMsg.scanner.BaseScanUI", "newRect = %s", new Object[] { localRect });
          if (this.qwa)
          {
            this.qvY = localRect.top;
            this.qvZ = (localRect.bottom - BackwardSupportUtil.b.b(this, 8.0F));
            this.qwb = localRect;
            civ();
            if ((this.qwf) && (!this.qvU) && (!cit())) {
              break label688;
            }
            f(true, this.qvQ.getMaskAnimDuration() + 150L);
            if ((this.qwc != null) && (this.qwd != null))
            {
              this.qwc.setVisibility(8);
              this.qwd.setVisibility(8);
            }
            if ((this.qvN != null) && (this.qvN.isOpen()))
            {
              this.qvN.f(this.qvO);
              this.qwl.kE(ciF());
              this.qwl.g(this.qvN.miT);
            }
            AppMethodBeat.o(80966);
          }
        }
        else
        {
          this.qvQ = new ScanMaskView(this, localRect);
          continue;
        }
        this.qvY = localException.left;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.scanner.BaseScanUI", localException, "", new Object[0]);
        AppMethodBeat.o(80966);
        return;
      }
      this.qvZ = (localException.right - BackwardSupportUtil.b.b(this, 8.0F));
      this.qwb = localException;
      continue;
      label688:
      if ((this.qwc != null) && (this.qwd != null))
      {
        this.qwc.setText(2131302918);
        this.qwd.setVisibility(0);
        this.qwc.setVisibility(0);
      }
    }
  }
  
  public final void ciE()
  {
    AppMethodBeat.i(80974);
    Intent localIntent = new Intent();
    localIntent.putExtra("preview_ui_title", 2131302941);
    com.tencent.mm.pluginsdk.ui.tools.n.a(this, 4660, localIntent);
    AppMethodBeat.o(80974);
  }
  
  public final boolean ciF()
  {
    AppMethodBeat.i(80978);
    if ((this.qvN == null) || (!this.qvN.isOpen()))
    {
      ab.d("MicroMsg.scanner.BaseScanUI", "scanCamera == null or scanCamera is not open, cameraNeedRotate return false");
      AppMethodBeat.o(80978);
      return false;
    }
    boolean bool = this.qvN.miW;
    AppMethodBeat.o(80978);
    return bool;
  }
  
  public final void ciG()
  {
    AppMethodBeat.i(80979);
    byJ();
    AppMethodBeat.o(80979);
  }
  
  public final void ciH()
  {
    AppMethodBeat.i(80980);
    super.finish();
    AppMethodBeat.o(80980);
  }
  
  public final void ciI()
  {
    AppMethodBeat.i(80989);
    Object localObject;
    if ((!this.mof) && (this.qvN != null) && (!this.qvT))
    {
      localObject = this.qvN.getFocusMode();
      if ((!bo.isNullOrNil((String)localObject)) && (!((String)localObject).equals("auto"))) {
        localObject = this.qvN;
      }
    }
    try
    {
      if ((((com.tencent.mm.plugin.scanner.util.j)localObject).eoH != null) && (((com.tencent.mm.plugin.scanner.util.j)localObject).miS))
      {
        Camera.Parameters localParameters = ((com.tencent.mm.plugin.scanner.util.j)localObject).eoH.getParameters();
        List localList = localParameters.getSupportedFocusModes();
        if ((localList != null) && (localList.contains("auto")) && (!bo.isNullOrNil(localParameters.getFocusMode())) && (!localParameters.getFocusMode().equals("auto")))
        {
          localParameters.setFocusMode("auto");
          ((com.tencent.mm.plugin.scanner.util.j)localObject).eoH.setParameters(localParameters);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.scanner.ScanCamera", "setFocusModeAuto %s", new Object[] { localException.getMessage() });
      }
    }
    lg(0L);
    AppMethodBeat.o(80989);
  }
  
  public final void cix()
  {
    AppMethodBeat.i(80959);
    if ((this.qwk != null) && (this.qwj != null))
    {
      this.qwk.setVisibility(8);
      this.qwk.clearAnimation();
      this.qwk.setAnimation(null);
    }
    AppMethodBeat.o(80959);
  }
  
  public final void ciy()
  {
    AppMethodBeat.i(80960);
    ab.i("MicroMsg.scanner.BaseScanUI", "alvinluo playScanOkSound: %b, succ: %b", new Object[] { Boolean.valueOf(this.qvT), Boolean.TRUE });
    if (!this.qvT) {
      ay.ax(this, 2131302240);
    }
    AppMethodBeat.o(80960);
  }
  
  public View findViewById(int paramInt)
  {
    AppMethodBeat.i(80944);
    View localView = super.findViewById(paramInt);
    AppMethodBeat.o(80944);
    return localView;
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(80946);
    if (!Ll())
    {
      ab.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation PORTRAIT");
      AppMethodBeat.o(80946);
      return 1;
    }
    ab.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation LANDSCAPE");
    AppMethodBeat.o(80946);
    return 0;
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(80945);
    if (!Ll())
    {
      ab.d("MicroMsg.scanner.BaseScanUI", "getLayoutId PORTRAIT");
      AppMethodBeat.o(80945);
      return 2130970600;
    }
    ab.d("MicroMsg.scanner.BaseScanUI", "getLayoutId LANDSCAPE");
    AppMethodBeat.o(80945);
    return 2130970601;
  }
  
  public void initView()
  {
    AppMethodBeat.i(80948);
    if (Ll())
    {
      getWindow().setFlags(1024, 1024);
      hideTitleView();
      ab.d("MicroMsg.scanner.BaseScanUI", "oncreate LANDSCAPE");
    }
    this.qwd = findViewById(2131827415);
    this.qwc = ((TextView)findViewById(2131827416));
    this.qvK = ((LinearLayout)findViewById(2131827426));
    this.qvL = ((TextView)findViewById(2131827427));
    this.qvM = ((FrameLayout)findViewById(2131827414));
    this.qvR = ((ScannerFlashSwitcher)findViewById(2131827418));
    this.qvI = ((MMTextureView)findViewById(2131827413));
    this.qvI.setOpaque(false);
    this.qvI.setSurfaceTextureListener(this);
    Object localObject2;
    Object localObject1;
    if ((7 == this.qwm) || (9 == this.qwm) || (10 == this.qwm) || (11 == this.qwm))
    {
      localObject2 = (Button)findViewById(2131827428);
      ((Button)localObject2).setVisibility(0);
      findViewById(2131827420).setVisibility(8);
      findViewById(2131827423).setVisibility(8);
      if (9 != this.qwm)
      {
        localObject1 = localObject2;
        if (10 != this.qwm) {}
      }
      else
      {
        ViewGroup.LayoutParams localLayoutParams = ((Button)localObject2).getLayoutParams();
        localObject1 = localObject2;
        if (localLayoutParams != null)
        {
          localObject1 = localObject2;
          if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
          {
            localObject1 = (ViewGroup.MarginLayoutParams)localLayoutParams;
            ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = localObject2;
          }
        }
      }
      if (localObject1 == null) {
        break label506;
      }
      ((Button)localObject1).setOnClickListener(new BaseScanUI.23(this));
    }
    int i;
    for (;;)
    {
      this.qwk = ((ImageView)findViewById(2131827417));
      this.cpY = getIntent().getIntExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
      this.qvP = ((SelectScanModePanel)findViewById(2131827419));
      this.qvM.setVisibility(0);
      if ((7 != this.qwm) && (9 != this.qwm) && (10 != this.qwm) && (11 != this.qwm) && (Ll()))
      {
        this.qwm = 1;
        this.qwe = true;
      }
      localObject1 = getIntent().getIntArrayExtra("key_support_scan_code_type");
      localObject2 = new HashSet();
      if ((localObject1 == null) || (localObject1.length <= 0)) {
        break label521;
      }
      i = 0;
      while (i < localObject1.length)
      {
        ((Set)localObject2).add(Integer.valueOf(localObject1[i]));
        i += 1;
      }
      localObject1 = (Button)findViewById(2131827424);
      break;
      label506:
      setBackBtn(new BaseScanUI.24(this));
    }
    label521:
    ciD();
    setMMSubTitle(null);
    if (this.qwm == 2)
    {
      this.qwl = new k(this, this.qvO);
      setMMTitle(t.ge(t.qDP, getString(2131302906)));
      ab.i("MicroMsg.scanner.BaseScanUI", "alvinluo canUseOfflineScan: %b", new Object[] { Boolean.valueOf(cit()) });
      this.qwl.kG(cit());
      this.qwl.CI(this.qwn);
      if (com.tencent.mm.x.c.PJ().b(ac.a.yKC, ac.a.yKD)) {
        this.qwu.add(Integer.valueOf(3));
      }
      this.qwa = this.qwl.ciq();
      localObject1 = this.qwk;
      if (!this.qwa) {
        break label1706;
      }
      i = 2130840051;
      label673:
      ((ImageView)localObject1).setBackgroundResource(i);
      if ((7 != this.qwm) && (9 != this.qwm) && (10 != this.qwm) && (11 != this.qwm)) {
        break label1713;
      }
    }
    for (;;)
    {
      if (this.qvN != null) {
        this.qvN.CQ(this.qwm);
      }
      ciu();
      this.qww = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.qww.addUpdateListener(new BaseScanUI.25(this));
      this.qww.setDuration(300L);
      setActionbarColor(getResources().getColor(2131690605));
      ab.i("MicroMsg.scanner.BaseScanUI", "initView() done, fromSource=[%s], directSelectMode=[%s]", new Object[] { Integer.valueOf(this.cpY), Integer.valueOf(this.qwm) });
      AppMethodBeat.o(80948);
      return;
      if (this.qwm == 5)
      {
        this.qwl = new q(this, this.qvO);
        setMMTitle(2131302898);
        this.qwq = true;
        break;
      }
      if (this.qwm == 3)
      {
        this.qwl = new o(this, this.qvO);
        setMMTitle(2131302894);
        break;
      }
      if ((this.qwm == 4) && (!Ll()))
      {
        if (((Set)localObject2).isEmpty()) {}
        for (this.qwl = new p(this, this.qvO, this.cpY, 2);; this.qwl = new p(this, this.qvO, this.cpY, (Set)localObject2))
        {
          ((p)this.qwl).qAb = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
          this.qvP.setVisibility(8);
          setMMTitle(2131302899);
          break;
        }
      }
      if (this.qwm == 8)
      {
        if (((Set)localObject2).isEmpty()) {}
        for (this.qwl = new p(this, this.qvO, this.cpY, 1);; this.qwl = new p(this, this.qvO, this.cpY, (Set)localObject2))
        {
          ((p)this.qwl).qAb = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
          this.qvP.setVisibility(8);
          setMMTitle(2131302896);
          break;
        }
      }
      if (7 == this.qwm)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.qwl = new j(this, this.qvO, (DisplayMetrics)localObject1, getWindowManager().getDefaultDisplay().getRotation());
        localObject1 = (j)this.qwl;
        if ((getIntent() != null) && (getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false))) {}
        for (boolean bool = true;; bool = false)
        {
          ((j)localObject1).qzp = bool;
          setMMTitle(2131302889);
          this.qvP.setVisibility(8);
          break;
        }
      }
      if (9 == this.qwm)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.qwl = new m(this, this.qvO, (DisplayMetrics)localObject1, getWindowManager().getDefaultDisplay().getRotation());
        setMMTitle(2131302891);
        this.qvP.setVisibility(8);
        break;
      }
      if (10 == this.qwm)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.qwl = new l(this, this.qvO, (DisplayMetrics)localObject1, getWindowManager().getDefaultDisplay().getRotation());
        setMMTitle(2131302890);
        this.qvP.setVisibility(8);
        break;
      }
      if (11 == this.qwm)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.qwl = new n(this, this.qvO, (DisplayMetrics)localObject1, getWindowManager().getDefaultDisplay().getRotation());
        setMMTitle(2131302892);
        this.qvP.setVisibility(8);
        break;
      }
      this.qwm = 1;
      if (((Set)localObject2).isEmpty())
      {
        localObject1 = this.qvO;
        int j = this.cpY;
        if (Ll())
        {
          i = 1;
          label1526:
          this.qwl = new p(this, (Point)localObject1, j, i);
          label1542:
          ((p)this.qwl).qAb = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
          if (!com.tencent.mm.au.b.aig()) {
            break label1665;
          }
          this.qwe = true;
          if (!t.cjO()) {
            break label1653;
          }
          this.qvP.setDisplayModes(new int[] { 1, 3 });
          this.qvP.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!this.qwe) {
          break label1696;
        }
        setMMTitle(2131302896);
        break;
        i = 0;
        break label1526;
        this.qwl = new p(this, this.qvO, this.cpY, (Set)localObject2);
        break label1542;
        label1653:
        this.qvP.setVisibility(8);
        continue;
        label1665:
        if (getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false))
        {
          this.qwe = false;
          this.qvP.setVisibility(8);
        }
      }
      label1696:
      setMMTitle(2131302897);
      break;
      label1706:
      i = 2130840052;
      break label673;
      label1713:
      this.qvP.setShowRedDotModes(this.qwu);
      this.qvP.setSelectedMode(this.qwm);
      this.qvP.setOnGridItemClickCallback(new BaseScanUI.26(this));
    }
  }
  
  public final void kA(boolean paramBoolean)
  {
    AppMethodBeat.i(80976);
    this.qvT = paramBoolean;
    if (paramBoolean)
    {
      cix();
      if (this.qwd != null)
      {
        this.qwd.setVisibility(0);
        AppMethodBeat.o(80976);
      }
    }
    else
    {
      lg(0L);
      f(false, 0L);
      if (this.qwd != null) {
        this.qwd.setVisibility(8);
      }
    }
    AppMethodBeat.o(80976);
  }
  
  public final void lf(long paramLong)
  {
    AppMethodBeat.i(80970);
    ab.i("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay: %s", new Object[] { Long.valueOf(paramLong) });
    this.qwC.removeMessages(0);
    if (!this.qvT)
    {
      this.qwC.sendEmptyMessageDelayed(0, paramLong);
      AppMethodBeat.o(80970);
      return;
    }
    ab.w("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay() scanPause");
    AppMethodBeat.o(80970);
  }
  
  public final void lg(long paramLong)
  {
    AppMethodBeat.i(80971);
    if ((this.qvN != null) && (!this.qvT) && (this.qvN.miS))
    {
      ab.d("MicroMsg.scanner.BaseScanUI", "focus delay:".concat(String.valueOf(paramLong)));
      String str = this.qvN.getFocusMode();
      if ((!bo.isNullOrNil(str)) && (str.equals("continuous-video")))
      {
        lf(0L);
        AppMethodBeat.o(80971);
        return;
      }
      this.qwE.removeMessages(0);
      this.qwE.sendEmptyMessageDelayed(0, paramLong);
    }
    AppMethodBeat.o(80971);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(80975);
    if (this.qvV != null) {
      this.qvV.c(this, paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(80975);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(80973);
    ab.i("MicroMsg.scanner.BaseScanUI", "onAutoFocus, success: %s, camera: %s", new Object[] { Boolean.valueOf(paramBoolean), paramCamera });
    this.gEs[4] = ((int)(System.currentTimeMillis() - this.qwt));
    ac.eru.eor = this.gEs[4];
    if (this.qvT)
    {
      AppMethodBeat.o(80973);
      return;
    }
    if (this.qwl == null)
    {
      AppMethodBeat.o(80973);
      return;
    }
    if ((this.qvN != null) && (this.qvN.miS) && (paramBoolean)) {
      lf(0L);
    }
    if (this.qwl.qyY > 0L) {
      lg(this.qwl.qyY);
    }
    AppMethodBeat.o(80973);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(80984);
    super.onConfigurationChanged(paramConfiguration);
    ab.i("MicroMsg.scanner.BaseScanUI", "screen orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if ((paramConfiguration.orientation == 2) || (paramConfiguration.orientation == 1)) {
      al.p(new BaseScanUI.21(this), 100L);
    }
    AppMethodBeat.o(80984);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80947);
    this.qwm = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    MMActivity.initLanguage(this);
    this.qwn = getIntent().getIntExtra("key_scan_entry_scene", 0);
    getWindow().addFlags(2097280);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if ((g.Rc().adt() == 6) || (g.Rc().adt() == 4)) {
      this.qvU = true;
    }
    for (;;)
    {
      if ((7 == this.qwm) || (11 == this.qwm) || (1 == this.qwm) || (8 == this.qwm)) {
        this.qwf = false;
      }
      ab.i("MicroMsg.scanner.BaseScanUI", "needCheckNetwork %s", new Object[] { Boolean.valueOf(this.qwf) });
      com.tencent.mm.sdk.b.a.ymk.c(this.qwD);
      com.tencent.mm.sdk.b.a.ymk.c(this.qwy);
      initView();
      this.qws = System.currentTimeMillis();
      paramBundle = ScanCameraLightDetector.qCZ;
      try
      {
        paramBundle.qDd = com.tencent.mm.sdk.g.d.aqu("ScanCameraLightDetector_detectThread");
        paramBundle.qDd.start();
        paramBundle.handler = new ScanCameraLightDetector.1(paramBundle, paramBundle.qDd.getLooper());
        ab.i("MicroMsg.ScanCameraLightDetector", "start, sensorManager: %s, lightSensor: %s, isRegister: %s", new Object[] { paramBundle.sensorManager, paramBundle.qDb, Boolean.valueOf(paramBundle.qDc) });
        this.qws = System.currentTimeMillis();
        com.tencent.mm.sdk.b.a.ymk.c(this.kSY);
        AppMethodBeat.o(80947);
        return;
        this.qvU = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.ScanCameraLightDetector", localException, "start error: %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80955);
    ab.i("MicroMsg.scanner.BaseScanUI", "onDestroy()");
    if (this.qwl != null) {
      this.qwl.onDestroy();
    }
    if (this.qvQ != null) {
      this.qvQ.ciQ();
    }
    if (this.qvI != null) {
      this.qvI.setSurfaceTextureListener(null);
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.qwD);
    com.tencent.mm.sdk.b.a.ymk.d(this.qwy);
    com.tencent.mm.sdk.b.a.ymk.d(this.kSY);
    if (this.qwi != null) {
      this.qwi.cjt();
    }
    ScanCameraLightDetector localScanCameraLightDetector = ScanCameraLightDetector.qCZ;
    ab.i("MicroMsg.ScanCameraLightDetector", "stop, isRegister: %s, sensorManager: %s, lightSensor: %s", new Object[] { Boolean.valueOf(localScanCameraLightDetector.qDc), localScanCameraLightDetector.sensorManager, localScanCameraLightDetector.qDb });
    try
    {
      localScanCameraLightDetector.qDa = -1L;
      if (localScanCameraLightDetector.qDd != null) {
        localScanCameraLightDetector.qDd.quit();
      }
      super.onDestroy();
      AppMethodBeat.o(80955);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ScanCameraLightDetector", localException, "stop error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(80951);
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
    {
      ab.d("MicroMsg.scanner.BaseScanUI", "keyCode KEYCODE_BACK");
      this.qvT = true;
      byJ();
      overridePendingTransition(0, 0);
      AppMethodBeat.o(80951);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(80951);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(80954);
    ab.i("MicroMsg.scanner.BaseScanUI", "onPause(), scanMode: %s, mQBarStringHandler: %s", new Object[] { this.qwl, this.qwi });
    this.qvT = true;
    com.tencent.mm.plugin.scanner.util.o.qDy.stop();
    if (this.qwl != null)
    {
      this.qwl.onPause();
      if (this.qwl.cim() != null) {
        this.qwl.cim().pJ();
      }
    }
    int i;
    if (this.qvN != null)
    {
      String str = this.qvN.getFocusMode();
      if ((!bo.isNullOrNil(str)) && (str.equals("continuous-video"))) {
        this.gEs[2] = 1;
      }
    }
    else
    {
      bvO();
      if (this.qvR != null)
      {
        this.qvR.cji();
        this.qvR.hide();
      }
      if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
      {
        this.wakeLock.release();
        this.wakeLock = null;
      }
      sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
      g.RK().b(this.qwx);
      if (this.qwi != null) {
        this.qwi.onPause();
      }
      if ((this.qwm == 1) || (this.qwm == 8) || (this.qwm == 4))
      {
        com.tencent.mm.plugin.scanner.model.n.qux.bJP();
        i = (int)(System.currentTimeMillis() - this.qws);
        ab.i("MicroMsg.scanner.BaseScanUI", "scan cost time:".concat(String.valueOf(i)));
        if (!com.tencent.mm.plugin.scanner.model.n.qux.quz) {
          break label493;
        }
        this.gEs[0] = 1;
      }
    }
    for (;;)
    {
      this.gEs[1] = i;
      this.gEs[3] = com.tencent.mm.plugin.scanner.model.n.qux.quA;
      if (com.tencent.mm.plugin.scanner.util.o.qDy.cjL() > 0L) {
        this.gEs[6] = ((int)(com.tencent.mm.plugin.scanner.util.o.qDy.cjL() - this.qws));
      }
      this.gEs[7] = this.qwm;
      com.tencent.mm.plugin.report.service.h.qsU.e(14176, new Object[] { Integer.valueOf(this.gEs[0]), Integer.valueOf(this.gEs[1]), Integer.valueOf(this.gEs[2]), Integer.valueOf(this.gEs[3]), Integer.valueOf(this.gEs[4]), Integer.valueOf(this.gEs[5]), Integer.valueOf(this.gEs[6]), Integer.valueOf(this.gEs[7]) });
      super.onPause();
      AppMethodBeat.o(80954);
      return;
      this.gEs[2] = 0;
      break;
      label493:
      this.gEs[0] = 0;
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(80972);
    if (paramArrayOfByte == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.scanner.BaseScanUI", "onPreviewFrame, data==null: %s, camera: %s", new Object[] { Boolean.valueOf(bool), paramCamera });
      if ((!this.qvT) && (this.qwl != null) && (this.qwl.cim() != null) && (this.qwl.H(false, Ll()) != null)) {
        break;
      }
      ab.w("MicroMsg.scanner.BaseScanUI", "onPreviewFrame error state, scanPause = [%s]", new Object[] { Boolean.valueOf(this.qvT) });
      AppMethodBeat.o(80972);
      return;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      if (paramArrayOfByte == null) {}
      for (bool = true;; bool = false)
      {
        ab.e("MicroMsg.scanner.BaseScanUI", "onPreviewFrame, wrong data, data is null [%s]", new Object[] { Boolean.valueOf(bool) });
        ciB();
        AppMethodBeat.o(80972);
        return;
      }
    }
    if (this.qvN == null)
    {
      ab.e("MicroMsg.scanner.BaseScanUI", "onPreviewFrame, scanCamera == null, finish this activity");
      AppMethodBeat.o(80972);
      return;
    }
    label1167:
    for (;;)
    {
      Rect localRect2;
      try
      {
        int i;
        Object localObject1;
        Object localObject2;
        if (this.qvN != null)
        {
          paramCamera = this.qvN;
          if (paramCamera.qCU < 0)
          {
            if (!paramCamera.cjF()) {
              continue;
            }
            i = 1;
            paramCamera.qCU = i;
          }
          if (paramCamera.qCU != 1) {
            continue;
          }
          i = 1;
          if ((i != 0) && (!this.qvN.oHg) && ((this.qvU) || (cit())))
          {
            paramCamera = ScanCameraLightDetector.qCZ;
            i = this.qvN.miT.x;
            j = this.qvN.miT.y;
            if ((paramCamera.qDa < 0L) || ((bo.av(paramCamera.qDa) >= 1000L) && (paramCamera.handler != null) && (paramCamera.qDd != null) && (paramCamera.qDd.isAlive())))
            {
              localObject1 = new ScanCameraLightDetector.a(paramCamera, (byte)0);
              ((ScanCameraLightDetector.a)localObject1).oIw = paramArrayOfByte;
              ((ScanCameraLightDetector.a)localObject1).width = i;
              ((ScanCameraLightDetector.a)localObject1).height = j;
              localObject2 = Message.obtain();
              ((Message)localObject2).what = 233;
              ((Message)localObject2).obj = localObject1;
              paramCamera.handler.sendMessage((Message)localObject2);
              paramCamera.qDa = bo.yB();
            }
          }
        }
        Rect localRect1;
        if ((this.qvN != null) && (!this.qvT))
        {
          paramCamera = this.qwl;
          localObject1 = this.qvN.miT;
          i = this.qvN.miX;
          localObject2 = this.qvN;
          localRect1 = this.qwl.kD(Ll());
          j = this.qwm;
          localRect2 = new Rect();
          ab.i("MicroMsg.scanner.ScanCamera", "frame rect:%s, visibleResolution:%s, cameraResolution %s", new Object[] { localRect1, ((com.tencent.mm.plugin.scanner.util.j)localObject2).miV, ((com.tencent.mm.plugin.scanner.util.j)localObject2).miT });
          if ((((com.tencent.mm.plugin.scanner.util.j)localObject2).miW) && (!((com.tencent.mm.plugin.scanner.util.j)localObject2).qCR))
          {
            ab.i("MicroMsg.scanner.ScanCamera", ", needRotate = " + ((com.tencent.mm.plugin.scanner.util.j)localObject2).miW + " needLandscape = " + ((com.tencent.mm.plugin.scanner.util.j)localObject2).qCR);
            localRect2.top = ((((com.tencent.mm.plugin.scanner.util.j)localObject2).miT.x - (int)(localRect1.height() * ((com.tencent.mm.plugin.scanner.util.j)localObject2).cjy())) / 2);
            localRect2.bottom = (((com.tencent.mm.plugin.scanner.util.j)localObject2).miT.x - localRect2.top);
            localRect2.left = ((((com.tencent.mm.plugin.scanner.util.j)localObject2).miT.y - (int)(localRect1.width() * ((com.tencent.mm.plugin.scanner.util.j)localObject2).cjx())) / 2);
            localRect2.right = (((com.tencent.mm.plugin.scanner.util.j)localObject2).miT.y - localRect2.left);
            break label1167;
            if ((!((com.tencent.mm.plugin.scanner.util.j)localObject2).miW) || (((com.tencent.mm.plugin.scanner.util.j)localObject2).qCR)) {
              break label1041;
            }
            if (localRect2.height() / 1.586F >= localRect2.width()) {
              break label989;
            }
            j = (int)(localRect2.height() / 1.586F);
            localRect2.left = ((localRect2.left + localRect2.right) / 2 - j / 2);
            localRect2.right = (j + localRect2.left);
            ab.i("MicroMsg.scanner.ScanCamera", "resultRect %s", new Object[] { localRect2 });
            ((com.tencent.mm.plugin.scanner.util.j)localObject2).mfj = localRect2;
            ((com.tencent.mm.plugin.scanner.util.j)localObject2).cjB();
            ab.i("MicroMsg.scanner.ScanCamera", "scanRect:" + ((com.tencent.mm.plugin.scanner.util.j)localObject2).mfj);
            paramCamera.a(paramArrayOfByte, (Point)localObject1, i, ((com.tencent.mm.plugin.scanner.util.j)localObject2).mfj);
          }
        }
        else
        {
          AppMethodBeat.o(80972);
          return;
          i = 0;
          continue;
          i = 0;
          continue;
        }
        localRect2.left = ((int)(localRect1.left * ((com.tencent.mm.plugin.scanner.util.j)localObject2).cjx()));
        localRect2.right = ((int)(localRect1.right * ((com.tencent.mm.plugin.scanner.util.j)localObject2).cjx()));
        localRect2.top = ((int)(localRect1.top * ((com.tencent.mm.plugin.scanner.util.j)localObject2).cjy()));
        localRect2.bottom = ((int)(localRect1.bottom * ((com.tencent.mm.plugin.scanner.util.j)localObject2).cjy()));
        if (localRect2.bottom > ((com.tencent.mm.plugin.scanner.util.j)localObject2).miT.y) {
          localRect2.bottom = ((com.tencent.mm.plugin.scanner.util.j)localObject2).miT.y;
        }
        if (localRect2.right <= ((com.tencent.mm.plugin.scanner.util.j)localObject2).miT.x) {
          break label1167;
        }
        localRect2.right = ((com.tencent.mm.plugin.scanner.util.j)localObject2).miT.x;
      }
      catch (Exception paramArrayOfByte)
      {
        ab.printErrStackTrace("MicroMsg.scanner.BaseScanUI", paramArrayOfByte, "onPreviewFrame exception", new Object[0]);
        AppMethodBeat.o(80972);
        return;
      }
      label989:
      int j = (int)(localRect2.width() * 1.586F);
      localRect2.top = ((localRect2.top + localRect2.bottom) / 2 - j / 2);
      localRect2.bottom = (j + localRect2.top);
      continue;
      label1041:
      if (localRect2.width() * 1.0D / localRect2.height() < 1.585999965667725D)
      {
        j = (int)(localRect2.width() / 1.586F);
        localRect2.top = ((localRect2.top + localRect2.bottom) / 2 - j / 2);
        localRect2.bottom = (j + localRect2.top);
      }
      else
      {
        j = (int)(localRect2.height() * 1.586F);
        localRect2.left = ((localRect2.left + localRect2.right) / 2 - j / 2);
        localRect2.right = (j + localRect2.left);
        continue;
        if (7 != j) {
          if (11 != j) {}
        }
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(80953);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.scanner.BaseScanUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(80953);
      return;
    }
    ab.i("MicroMsg.scanner.BaseScanUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(80953);
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
      {
        this.qwp = false;
        com.tencent.mm.ui.base.h.a(this, getString(2131302067), getString(2131302083), getString(2131300996), getString(2131296888), false, new BaseScanUI.4(this), new BaseScanUI.5(this));
        AppMethodBeat.o(80953);
        return;
        if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
        {
          this.qwq = false;
          com.tencent.mm.ui.base.h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131296888), false, new BaseScanUI.6(this), new BaseScanUI.7(this));
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80952);
    super.onResume();
    if (!this.qwr)
    {
      com.tencent.mm.cn.d.aNX();
      this.qwr = true;
    }
    ab.i("MicroMsg.scanner.BaseScanUI", "should check camera %s, location %s", new Object[] { Boolean.valueOf(this.qwp), Boolean.valueOf(this.qwq) });
    boolean bool;
    int i;
    if ((this.qwp) || (this.qwq)) {
      if (this.qwp)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 16, null, null);
        ab.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          i = 0;
          if (i != 0)
          {
            if (com.tencent.mm.compatible.f.b.Me()) {
              break label355;
            }
            com.tencent.mm.ui.base.h.a(this, getString(2131302067), getString(2131302083), getString(2131300996), getString(2131296888), false, new BaseScanUI.27(this), new BaseScanUI.28(this));
          }
        }
      }
    }
    for (;;)
    {
      if ((!this.qvT) && ((this.qwm == 1) || (this.qwm == 8) || (this.qwm == 4)))
      {
        com.tencent.mm.plugin.scanner.model.n.qux.reset();
        com.tencent.mm.plugin.scanner.model.n.qux.CE(com.tencent.mm.plugin.scanner.model.n.quu);
      }
      ??? = com.tencent.mm.plugin.scanner.util.o.qDy;
      ab.i("MicroMsg.ScanStableDetector", "start detect scan stable");
      if (((com.tencent.mm.plugin.scanner.util.o)???).bmB != null)
      {
        ((com.tencent.mm.plugin.scanner.util.o)???).qDw = 0;
        ((com.tencent.mm.plugin.scanner.util.o)???).qDv[0] = 0.0F;
        ((com.tencent.mm.plugin.scanner.util.o)???).qDv[1] = 0.0F;
        ((com.tencent.mm.plugin.scanner.util.o)???).qDv[2] = 0.0F;
        ab.i("MicroMsg.ScanStableDetector", "register accelerate listener");
        ((com.tencent.mm.plugin.scanner.util.o)???).bmB.registerListener((SensorEventListener)???, ((com.tencent.mm.plugin.scanner.util.o)???).qDu, 50000);
      }
      AppMethodBeat.o(80952);
      return;
      if (this.qwq)
      {
        bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 76, null, null);
        ab.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkLocation [%b]", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          i = 0;
          break;
        }
      }
      i = 1;
      break;
      label355:
      if ((this.qwm != 5) || (com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION"))) {
        break label426;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131296888), false, new BaseScanUI.2(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(80913);
          BaseScanUI.b(BaseScanUI.this, true);
          BaseScanUI.this.finish();
          AppMethodBeat.o(80913);
        }
      });
    }
    label426:
    if ((!this.qwf) || (this.qvU) || (cit()))
    {
      this.qvT = false;
      f(false, 0L);
      label458:
      this.qwh = false;
    }
    for (;;)
    {
      synchronized (this.ceY)
      {
        ab.i("MicroMsg.scanner.BaseScanUI", "onResume open Camera");
        i = this.qwm;
        if ((7 != this.qwm) && (9 != this.qwm) && (10 != this.qwm))
        {
          if (11 == this.qwm)
          {
            break label721;
            this.qvN = new com.tencent.mm.plugin.scanner.util.j(this, i, bool);
            ciz();
            if ((this.qwm != 3) || (!t.cjO()))
            {
              if (this.qwl.cim() != null) {
                this.qwl.cim().restartDecoder();
              }
              this.qwl.onResume();
            }
            ??? = ah.getContext();
            if (this.wakeLock == null)
            {
              this.wakeLock = ((PowerManager)((Context)???).getSystemService("power")).newWakeLock(10, "Scan Lock");
              this.wakeLock.acquire();
            }
            sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
            if (this.qwf) {
              g.RK().a(this.qwx);
            }
            if (this.qwi == null) {
              break;
            }
            this.qwi.onResume();
            break;
            this.qvT = true;
            cix();
            break label458;
          }
          bool = false;
        }
      }
      label721:
      bool = true;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(80967);
    super.onStart();
    AppMethodBeat.o(80967);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80985);
    ab.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureAvailable");
    this.qvI.dEs();
    this.qvJ = paramSurfaceTexture;
    this.qwg = true;
    if (this.qwh)
    {
      ciz();
      this.qwh = false;
    }
    startPreview();
    AppMethodBeat.o(80985);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(80987);
    ab.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureDestroyed");
    this.qwg = false;
    AppMethodBeat.o(80987);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80986);
    ab.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureSizeChanged");
    this.qvJ = paramSurfaceTexture;
    AppMethodBeat.o(80986);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI
 * JD-Core Version:    0.7.0.1
 */