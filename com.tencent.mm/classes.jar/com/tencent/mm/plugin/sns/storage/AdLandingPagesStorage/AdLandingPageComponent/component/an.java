package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rl;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.api.ITPPlayer;
import org.json.JSONException;
import org.json.JSONObject;

public final class an
  extends am
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, com.tencent.mm.plugin.sight.decode.ui.b, i.b, i.d
{
  private long AXD;
  private ImageView HLM;
  private long LJG;
  private int LKo;
  private boolean PQA;
  private boolean PQB;
  private boolean PQC;
  private int PQE;
  private int PQF;
  private int PQG;
  private int PQH;
  private int PQI;
  private aq PQL;
  private Runnable PQR;
  private int PQr;
  private View PQs;
  private ImageView PQu;
  private boolean PQx;
  private boolean PQy;
  private boolean PQz;
  private int PSW;
  private int PSX;
  private TextView QRC;
  private ImageView QRE;
  private boolean QRG;
  private VideoPlayerSeekBar QRH;
  private ImageView QRI;
  private View QRJ;
  private volatile boolean QRK;
  private Runnable QRL;
  private View.OnClickListener QRM;
  private long QRO;
  private AdLandingVideoWrapper QSn;
  private boolean QSo;
  private boolean QSp;
  private boolean QSq;
  private boolean QSr;
  private View.OnClickListener QSs;
  private View.OnClickListener QSt;
  private View.OnClickListener QSu;
  private volatile int QSv;
  private b QSw;
  private Context context;
  private boolean isAutoPlay;
  private volatile boolean isWaiting;
  private int length;
  private MMHandler mRi;
  private View maskView;
  private ProgressBar njj;
  private GestureDetector nwZ;
  
  public an(final Context paramContext, ap paramap, ViewGroup paramViewGroup)
  {
    super(paramContext, paramap, paramViewGroup);
    AppMethodBeat.i(96774);
    this.QSo = false;
    this.QSp = false;
    this.QSq = false;
    this.PQB = true;
    this.QSr = true;
    this.PQz = false;
    this.PQA = true;
    this.isAutoPlay = false;
    this.QRG = false;
    this.PQx = false;
    this.PQy = false;
    this.PQr = 0;
    this.LJG = 0L;
    this.PSW = 0;
    this.LKo = 0;
    this.PQE = 0;
    this.PQF = 0;
    this.PQG = 0;
    this.PQL = null;
    this.QRM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96769);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "play btn onclick isPlaying[%b]", new Object[] { Boolean.valueOf(an.this.isPlaying()) });
        an.a(an.this, an.h(an.this));
        if (an.this.isPlaying())
        {
          an.i(an.this);
          an.a(an.this, 4);
          if (an.l(an.this)) {
            an.m(an.this);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96769);
          return;
        }
        if (an.j(an.this)) {
          an.this.haw();
        }
        for (;;)
        {
          an.k(an.this);
          an.a(an.this, 3);
          break;
          an.this.hiA();
          an.this.hax();
        }
      }
    };
    this.QSs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96771);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        an.n(an.this);
        an.a(an.this, an.h(an.this));
        if (an.j(an.this))
        {
          an.this.hiA();
          an.this.hax();
        }
        for (;;)
        {
          an.o(an.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(96771);
          return;
          an.this.haw();
        }
      }
    };
    this.QSt = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(96772);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        an.k(an.this);
        an.p(an.this);
        an.q(an.this);
        an.a(an.this, 3);
        an.this.hax();
        an.a(an.this, true);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(306893);
            if (an.r(an.this))
            {
              AppMethodBeat.o(306893);
              return;
            }
            an.a(an.this, false);
            AppMethodBeat.o(306893);
          }
        }, 10000L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(96772);
      }
    };
    this.QSu = new an.13(this);
    this.QRK = false;
    this.isWaiting = false;
    this.QSv = 0;
    this.PQH = 0;
    this.PQI = 0;
    this.QRO = 0L;
    this.context = paramContext;
    this.mRi = new MMHandler(Looper.getMainLooper());
    try
    {
      this.nwZ = new GestureDetector(this);
      this.QRL = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96762);
          an.a(an.this).setVisibility(8);
          AppMethodBeat.o(96762);
        }
      };
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 5);
      this.PQR = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(307218);
          an.a(an.this, false);
          AppMethodBeat.o(307218);
        }
      };
      this.PQL = new aq()
      {
        public final void Do(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(307220);
          Intent localIntent = new Intent("com.tencent.mm.adlanding.video_progressbar_change");
          if (paramAnonymousBoolean) {}
          for (int i = 1;; i = 0)
          {
            localIntent.putExtra("show", i);
            localIntent.putExtra("activity_code", an.b(an.this));
            androidx.i.a.a.al(paramContext).d(localIntent);
            AppMethodBeat.o(307220);
            return;
          }
        }
      };
      AppMethodBeat.o(96774);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramap.toString());
      }
    }
  }
  
  private void DV(boolean paramBoolean)
  {
    AppMethodBeat.i(306971);
    try
    {
      this.QRH.setIsPlay(paramBoolean);
      this.QRH.getPlayBtn().getLayoutParams().width = this.length;
      this.QRH.getPlayBtn().getLayoutParams().height = this.length;
      if (paramBoolean)
      {
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "startPlay");
        this.QRH.getPlayBtn().setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.media_player_btn_cur_status_on));
        AppMethodBeat.o(306971);
        return;
      }
      Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "pausePlay");
      this.QRH.getPlayBtn().setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.media_player_btn_cur_status_off));
      AppMethodBeat.o(306971);
      return;
    }
    finally
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localObject.toString());
      AppMethodBeat.o(306971);
    }
  }
  
  private void Dt(final boolean paramBoolean)
  {
    AppMethodBeat.i(306997);
    Log.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "pause play");
    this.mRi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96764);
        an.s(an.this).pause();
        try
        {
          if ((an.t(an.this).getVisibility() != 0) && (paramBoolean))
          {
            an.a(an.this).setVisibility(0);
            an.a(an.this, an.u(an.this));
          }
          an.b(an.this, false);
          AppMethodBeat.o(96764);
          return;
        }
        finally
        {
          Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localObject.toString());
          AppMethodBeat.o(96764);
        }
      }
    });
    if (this.LJG != 0L)
    {
      this.PSW = ((int)(this.PSW + (System.currentTimeMillis() - this.LJG)));
      this.LJG = 0L;
    }
    AppMethodBeat.o(306997);
  }
  
  private void aN(Runnable paramRunnable)
  {
    AppMethodBeat.i(306979);
    try
    {
      this.mRi.removeCallbacks(paramRunnable);
      this.mRi.postDelayed(paramRunnable, 4000L);
      AppMethodBeat.o(306979);
      return;
    }
    finally
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramRunnable.toString());
      AppMethodBeat.o(306979);
    }
  }
  
  private void as(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(307011);
    if (this.QSn != null)
    {
      this.PQu.setVisibility(8);
      if (this.HLM.getVisibility() == 0) {
        this.njj.setVisibility(0);
      }
      this.QSn.b(paramInt, paramBoolean);
    }
    AppMethodBeat.o(307011);
  }
  
  private void drB()
  {
    AppMethodBeat.i(96776);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "starting play, downFailed=" + this.QRG);
    if (this.QRG)
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "last download fail ,try again");
      if ((this.QRH != null) && (this.QRH.getParent() != null)) {
        ((ViewGroup)this.QRH.getParent()).removeView(this.QRH);
      }
      this.QSn.setFullScreen(false);
      this.QSn.b(false, ((ap)this.QOV).PSB, 0);
      try
      {
        int i = this.sJv;
        if ((this.QRH != null) && (this.QRH.getParent() != null)) {
          ((ViewGroup)this.QRH.getParent()).removeView(this.QRH);
        }
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i - com.tencent.mm.cd.a.fromDPToPix(this.context, 75), -2);
        localLayoutParams.addRule(12);
        localLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(this.context, 3);
        this.QRH.setLayoutParams(localLayoutParams);
        ((ViewGroup)this.contentView.findViewById(b.f.content_root)).addView(this.QRH, localLayoutParams);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "startPlay exp=" + Util.stackTraceToString(localException));
        }
      }
      as(0, true);
      this.QSn.hjN();
      AppMethodBeat.o(96776);
      return;
    }
    this.mRi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96763);
        if (!an.this.isPlaying())
        {
          if (an.s(an.this).getCurrPosSec() != an.s(an.this).getVideoDurationSec()) {
            break label62;
          }
          an.b(an.this, 0);
        }
        for (;;)
        {
          an.s(an.this).hjN();
          AppMethodBeat.o(96763);
          return;
          label62:
          an.b(an.this, an.s(an.this).getCurrPosSec());
        }
      }
    });
    this.LJG = System.currentTimeMillis();
    this.LKo += 1;
    AppMethodBeat.o(96776);
  }
  
  private void haH()
  {
    AppMethodBeat.i(307025);
    if (this.AXD != 0L)
    {
      this.PSX = ((int)(this.PSX + (System.currentTimeMillis() - this.AXD)));
      this.AXD = 0L;
    }
    AppMethodBeat.o(307025);
  }
  
  private boolean hjG()
  {
    AppMethodBeat.i(307016);
    if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (((ap)this.QOV).QLI))
    {
      AppMethodBeat.o(307016);
      return true;
    }
    AppMethodBeat.o(307016);
    return false;
  }
  
  private void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(96778);
    if (paramBoolean)
    {
      this.QRH.setVisibility(0);
      this.QRE.setVisibility(0);
      this.maskView.setVisibility(0);
      this.QRI.setVisibility(0);
      if (this.PQL != null) {
        this.PQL.Do(true);
      }
      aN(this.PQR);
      AppMethodBeat.o(96778);
      return;
    }
    this.QSq = false;
    this.QRH.setVisibility(4);
    this.QRE.setVisibility(8);
    this.maskView.setVisibility(4);
    this.QRI.setVisibility(8);
    if (this.PQL != null) {
      this.PQL.Do(false);
    }
    this.mRi.removeCallbacks(this.PQR);
    AppMethodBeat.o(96778);
  }
  
  /* Error */
  public final void Gs()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: ldc_w 566
    //   6: invokestatic 130	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 465	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:contentView	Landroid/view/View;
    //   13: getstatic 470	com/tencent/mm/plugin/sns/b$f:content_root	I
    //   16: invokevirtual 476	android/view/View:findViewById	(I)Landroid/view/View;
    //   19: astore 6
    //   21: aload_0
    //   22: aload 6
    //   24: putfield 564	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQs	Landroid/view/View;
    //   27: aload 6
    //   29: ldc_w 567
    //   32: invokevirtual 570	android/view/View:setBackgroundColor	(I)V
    //   35: aload_0
    //   36: getfield 444	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:sJv	I
    //   39: istore_3
    //   40: aload_0
    //   41: getfield 573	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:pvg	I
    //   44: istore_2
    //   45: iload_2
    //   46: istore_1
    //   47: aload_0
    //   48: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   51: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   54: getfield 576	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:QLH	I
    //   57: iconst_1
    //   58: if_icmpne +45 -> 103
    //   61: iload_2
    //   62: istore_1
    //   63: aload_0
    //   64: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   67: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   70: getfield 579	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:width	F
    //   73: f2i
    //   74: ifle +78 -> 152
    //   77: iload_3
    //   78: aload_0
    //   79: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   82: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   85: getfield 581	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:height	F
    //   88: f2i
    //   89: imul
    //   90: aload_0
    //   91: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   94: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   97: getfield 579	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:width	F
    //   100: f2i
    //   101: idiv
    //   102: istore_1
    //   103: aload 6
    //   105: aload_0
    //   106: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   109: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   112: getfield 584	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:paddingLeft	F
    //   115: f2i
    //   116: aload_0
    //   117: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   120: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   123: getfield 587	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:paddingTop	F
    //   126: f2i
    //   127: aload_0
    //   128: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   131: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   134: getfield 590	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:paddingRight	F
    //   137: f2i
    //   138: aload_0
    //   139: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   142: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   145: getfield 593	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:paddingBottom	F
    //   148: f2i
    //   149: invokevirtual 597	android/view/View:setPadding	(IIII)V
    //   152: aload 6
    //   154: new 446	android/widget/RelativeLayout$LayoutParams
    //   157: dup
    //   158: iload_3
    //   159: iload_1
    //   160: invokespecial 452	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   163: invokevirtual 598	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   166: aload 6
    //   168: iload_1
    //   169: invokevirtual 601	android/view/View:setMinimumHeight	(I)V
    //   172: ldc_w 313
    //   175: new 403	java/lang/StringBuilder
    //   178: dup
    //   179: ldc_w 603
    //   182: invokespecial 408	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   185: aload_0
    //   186: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   189: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   192: getfield 576	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:QLH	I
    //   195: invokevirtual 606	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: ldc_w 608
    //   201: invokevirtual 494	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload_3
    //   205: invokevirtual 606	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: ldc_w 610
    //   211: invokevirtual 494	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload_1
    //   215: invokevirtual 606	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: ldc_w 612
    //   221: invokevirtual 494	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload 6
    //   226: invokestatic 618	com/tencent/mm/plugin/sns/data/m:jr	(Landroid/view/View;)Ljava/lang/String;
    //   229: invokevirtual 494	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 413	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload_0
    //   239: aload 6
    //   241: getstatic 621	com/tencent/mm/plugin/sns/b$f:video_view	I
    //   244: invokevirtual 476	android/view/View:findViewById	(I)Landroid/view/View;
    //   247: checkcast 378	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper
    //   250: putfield 360	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSn	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   253: aload_0
    //   254: getfield 360	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSn	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   257: aload_0
    //   258: invokevirtual 625	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setIMMVideoViewCallback	(Lcom/tencent/mm/pluginsdk/ui/i$b;)V
    //   261: aload_0
    //   262: getfield 360	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSn	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   265: aload_0
    //   266: getfield 184	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSu	Landroid/view/View$OnClickListener;
    //   269: invokevirtual 629	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   272: aload_0
    //   273: getfield 360	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSn	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   276: iconst_0
    //   277: invokevirtual 428	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setFullScreen	(Z)V
    //   280: aload_0
    //   281: getfield 360	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSn	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   284: iconst_0
    //   285: aload_0
    //   286: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   289: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   292: getfield 438	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:PSB	Ljava/lang/String;
    //   295: iconst_0
    //   296: invokevirtual 441	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:b	(ZLjava/lang/String;I)V
    //   299: aload_0
    //   300: getfield 360	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSn	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   303: iconst_1
    //   304: invokevirtual 632	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setIsShowBasicControls	(Z)V
    //   307: aload_0
    //   308: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   311: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   314: getfield 635	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:QKv	Z
    //   317: ifne +867 -> 1184
    //   320: ldc_w 313
    //   323: ldc_w 637
    //   326: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: aload_0
    //   330: aload 6
    //   332: getstatic 640	com/tencent/mm/plugin/sns/b$f:progressbar	I
    //   335: invokevirtual 476	android/view/View:findViewById	(I)Landroid/view/View;
    //   338: checkcast 375	android/widget/ProgressBar
    //   341: putfield 373	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:njj	Landroid/widget/ProgressBar;
    //   344: aload_0
    //   345: aload 6
    //   347: getstatic 643	com/tencent/mm/plugin/sns/b$f:thumb_iv	I
    //   350: invokevirtual 476	android/view/View:findViewById	(I)Landroid/view/View;
    //   353: checkcast 271	android/widget/ImageView
    //   356: putfield 367	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:HLM	Landroid/widget/ImageView;
    //   359: ldc_w 645
    //   362: aload_0
    //   363: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   366: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   369: getfield 648	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:QLG	Ljava/lang/String;
    //   372: invokestatic 654	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/k:mC	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   375: astore 7
    //   377: aload 7
    //   379: invokestatic 660	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   382: ifne +8 -> 390
    //   385: aload_0
    //   386: iconst_0
    //   387: putfield 150	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQx	Z
    //   390: aload_0
    //   391: getfield 150	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQx	Z
    //   394: ifeq +957 -> 1351
    //   397: aload_0
    //   398: getfield 367	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:HLM	Landroid/widget/ImageView;
    //   401: aload 7
    //   403: invokestatic 666	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   406: invokevirtual 670	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   409: aload_0
    //   410: aload 6
    //   412: getstatic 673	com/tencent/mm/plugin/sns/b$f:errorTv	I
    //   415: invokevirtual 476	android/view/View:findViewById	(I)Landroid/view/View;
    //   418: checkcast 675	android/widget/TextView
    //   421: putfield 677	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRC	Landroid/widget/TextView;
    //   424: aload_0
    //   425: getfield 677	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRC	Landroid/widget/TextView;
    //   428: aload_0
    //   429: getfield 198	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:context	Landroid/content/Context;
    //   432: getstatic 682	com/tencent/mm/plugin/sns/b$j:download_fail	I
    //   435: invokevirtual 688	android/content/Context:getString	(I)Ljava/lang/String;
    //   438: invokevirtual 692	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   441: aload_0
    //   442: aload 6
    //   444: getstatic 695	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_sight_background	I
    //   447: invokevirtual 476	android/view/View:findViewById	(I)Landroid/view/View;
    //   450: putfield 551	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:maskView	Landroid/view/View;
    //   453: aload_0
    //   454: getfield 551	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:maskView	Landroid/view/View;
    //   457: iconst_4
    //   458: invokevirtual 552	android/view/View:setVisibility	(I)V
    //   461: aload_0
    //   462: new 262	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar
    //   465: dup
    //   466: aload_0
    //   467: getfield 198	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:context	Landroid/content/Context;
    //   470: invokespecial 698	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:<init>	(Landroid/content/Context;)V
    //   473: putfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   476: aload_0
    //   477: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   480: iconst_4
    //   481: invokevirtual 547	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   484: aload_0
    //   485: getfield 168	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQL	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aq;
    //   488: ifnull +31 -> 519
    //   491: aload_0
    //   492: getfield 168	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQL	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aq;
    //   495: astore 7
    //   497: aload_0
    //   498: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   501: invokevirtual 699	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getVisibility	()I
    //   504: ifne +874 -> 1378
    //   507: iconst_1
    //   508: istore 4
    //   510: aload 7
    //   512: iload 4
    //   514: invokeinterface 559 2 0
    //   519: aload_0
    //   520: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   523: aload_0
    //   524: invokevirtual 703	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setIplaySeekCallback	(Lcom/tencent/mm/plugin/sight/decode/ui/b;)V
    //   527: aload_0
    //   528: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   531: aload_0
    //   532: getfield 173	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRM	Landroid/view/View$OnClickListener;
    //   535: invokevirtual 706	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setOnPlayButtonClickListener	(Landroid/view/View$OnClickListener;)V
    //   538: new 446	android/widget/RelativeLayout$LayoutParams
    //   541: dup
    //   542: iload_3
    //   543: aload_0
    //   544: getfield 198	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:context	Landroid/content/Context;
    //   547: bipush 75
    //   549: invokestatic 450	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   552: isub
    //   553: bipush 254
    //   555: invokespecial 452	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   558: astore 7
    //   560: aload 7
    //   562: bipush 12
    //   564: invokevirtual 455	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   567: aload_0
    //   568: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   571: aload 7
    //   573: invokevirtual 462	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   576: aload_0
    //   577: getfield 360	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSn	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   580: aload_0
    //   581: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   584: invokevirtual 710	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setVideoFooterView	(Lcom/tencent/mm/pluginsdk/ui/h;)V
    //   587: aload_0
    //   588: aload 6
    //   590: getstatic 713	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_sight_voice_btn	I
    //   593: invokevirtual 476	android/view/View:findViewById	(I)Landroid/view/View;
    //   596: checkcast 271	android/widget/ImageView
    //   599: putfield 549	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRE	Landroid/widget/ImageView;
    //   602: aload_0
    //   603: getfield 549	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRE	Landroid/widget/ImageView;
    //   606: iconst_4
    //   607: invokevirtual 365	android/widget/ImageView:setVisibility	(I)V
    //   610: aload_0
    //   611: getfield 549	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRE	Landroid/widget/ImageView;
    //   614: aload_0
    //   615: getfield 176	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSs	Landroid/view/View$OnClickListener;
    //   618: invokevirtual 714	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   621: aload_0
    //   622: getfield 549	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRE	Landroid/widget/ImageView;
    //   625: invokevirtual 715	android/widget/ImageView:getParent	()Landroid/view/ViewParent;
    //   628: astore 8
    //   630: aload 8
    //   632: instanceof 421
    //   635: ifeq +15 -> 650
    //   638: aload 8
    //   640: checkcast 421	android/view/ViewGroup
    //   643: aload_0
    //   644: getfield 549	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRE	Landroid/widget/ImageView;
    //   647: invokevirtual 425	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   650: aload_0
    //   651: getfield 549	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRE	Landroid/widget/ImageView;
    //   654: invokevirtual 275	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   657: checkcast 446	android/widget/RelativeLayout$LayoutParams
    //   660: astore 8
    //   662: aload 8
    //   664: aload_0
    //   665: getfield 198	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:context	Landroid/content/Context;
    //   668: bipush 8
    //   670: invokestatic 450	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   673: putfield 458	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   676: aload 8
    //   678: aload_0
    //   679: getfield 198	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:context	Landroid/content/Context;
    //   682: bipush 10
    //   684: invokestatic 450	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   687: putfield 718	android/widget/RelativeLayout$LayoutParams:rightMargin	I
    //   690: aload 6
    //   692: checkcast 421	android/view/ViewGroup
    //   695: aload_0
    //   696: getfield 549	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRE	Landroid/widget/ImageView;
    //   699: aload 8
    //   701: invokevirtual 480	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   704: ldc 242
    //   706: ldc_w 720
    //   709: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   712: aload_0
    //   713: aload 6
    //   715: getstatic 723	com/tencent/mm/plugin/sns/b$f:status_btn	I
    //   718: invokevirtual 476	android/view/View:findViewById	(I)Landroid/view/View;
    //   721: checkcast 271	android/widget/ImageView
    //   724: putfield 362	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQu	Landroid/widget/ImageView;
    //   727: aload_0
    //   728: getfield 362	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQu	Landroid/widget/ImageView;
    //   731: aload_0
    //   732: getfield 198	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:context	Landroid/content/Context;
    //   735: getstatic 726	com/tencent/mm/plugin/sns/b$i:shortvideo_play_btn	I
    //   738: invokestatic 300	com/tencent/mm/cd/a:m	(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;
    //   741: invokevirtual 304	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   744: aload_0
    //   745: getfield 362	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQu	Landroid/widget/ImageView;
    //   748: bipush 8
    //   750: invokevirtual 365	android/widget/ImageView:setVisibility	(I)V
    //   753: aload_0
    //   754: getfield 362	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQu	Landroid/widget/ImageView;
    //   757: aload_0
    //   758: getfield 179	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSt	Landroid/view/View$OnClickListener;
    //   761: invokevirtual 714	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   764: aload_0
    //   765: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   768: invokevirtual 419	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getParent	()Landroid/view/ViewParent;
    //   771: checkcast 421	android/view/ViewGroup
    //   774: aload_0
    //   775: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   778: invokevirtual 425	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   781: aload 7
    //   783: iconst_0
    //   784: putfield 458	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   787: aload 6
    //   789: checkcast 421	android/view/ViewGroup
    //   792: aload_0
    //   793: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   796: aload 7
    //   798: invokevirtual 480	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   801: aload_0
    //   802: getfield 360	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSn	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   805: new 44	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an$9
    //   808: dup
    //   809: aload_0
    //   810: invokespecial 727	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an$9:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an;)V
    //   813: invokevirtual 731	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setVideoPlayCallback	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper$a;)V
    //   816: aload_0
    //   817: getfield 564	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQs	Landroid/view/View;
    //   820: astore 6
    //   822: aload_0
    //   823: aload_0
    //   824: getfield 198	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:context	Landroid/content/Context;
    //   827: bipush 32
    //   829: invokestatic 450	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   832: putfield 277	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:length	I
    //   835: aload_0
    //   836: getfield 360	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSn	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   839: aload_0
    //   840: invokevirtual 735	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   843: aload_0
    //   844: aload 6
    //   846: getstatic 738	com/tencent/mm/plugin/sns/b$f:sns_ad_native_landing_pages_sight_video_full_screen_btn	I
    //   849: invokevirtual 476	android/view/View:findViewById	(I)Landroid/view/View;
    //   852: checkcast 271	android/widget/ImageView
    //   855: putfield 554	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRI	Landroid/widget/ImageView;
    //   858: aload_0
    //   859: getfield 554	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRI	Landroid/widget/ImageView;
    //   862: invokevirtual 715	android/widget/ImageView:getParent	()Landroid/view/ViewParent;
    //   865: astore 7
    //   867: aload 7
    //   869: instanceof 421
    //   872: ifeq +15 -> 887
    //   875: aload 7
    //   877: checkcast 421	android/view/ViewGroup
    //   880: aload_0
    //   881: getfield 554	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRI	Landroid/widget/ImageView;
    //   884: invokevirtual 425	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   887: aload_0
    //   888: getfield 554	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRI	Landroid/widget/ImageView;
    //   891: invokevirtual 275	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   894: checkcast 446	android/widget/RelativeLayout$LayoutParams
    //   897: astore 7
    //   899: aload 7
    //   901: aload_0
    //   902: getfield 198	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:context	Landroid/content/Context;
    //   905: bipush 8
    //   907: invokestatic 450	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   910: putfield 458	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   913: aload 7
    //   915: aload_0
    //   916: getfield 198	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:context	Landroid/content/Context;
    //   919: bipush 10
    //   921: invokestatic 450	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   924: putfield 718	android/widget/RelativeLayout$LayoutParams:rightMargin	I
    //   927: aload 6
    //   929: checkcast 421	android/view/ViewGroup
    //   932: aload_0
    //   933: getfield 554	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRI	Landroid/widget/ImageView;
    //   936: aload 7
    //   938: invokevirtual 480	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   941: aload_0
    //   942: getfield 554	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRI	Landroid/widget/ImageView;
    //   945: aload_0
    //   946: invokevirtual 714	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   949: aload_0
    //   950: getfield 554	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRI	Landroid/widget/ImageView;
    //   953: bipush 8
    //   955: invokevirtual 365	android/widget/ImageView:setVisibility	(I)V
    //   958: ldc 242
    //   960: ldc_w 740
    //   963: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   966: aload_0
    //   967: getfield 360	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSn	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   970: iconst_1
    //   971: invokevirtual 743	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoop	(Z)V
    //   974: aload_0
    //   975: getfield 360	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSn	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   978: aload_0
    //   979: invokevirtual 747	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:setLoopCompletionCallback	(Lcom/tencent/mm/pluginsdk/ui/i$d;)V
    //   982: aload_0
    //   983: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   986: invokevirtual 419	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getParent	()Landroid/view/ViewParent;
    //   989: astore 6
    //   991: aload 6
    //   993: instanceof 421
    //   996: ifeq +15 -> 1011
    //   999: aload 6
    //   1001: checkcast 421	android/view/ViewGroup
    //   1004: aload_0
    //   1005: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1008: invokevirtual 425	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   1011: new 446	android/widget/RelativeLayout$LayoutParams
    //   1014: dup
    //   1015: aload_0
    //   1016: getfield 564	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQs	Landroid/view/View;
    //   1019: invokevirtual 748	android/view/View:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1022: getfield 282	android/view/ViewGroup$LayoutParams:width	I
    //   1025: aload_0
    //   1026: getfield 198	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:context	Landroid/content/Context;
    //   1029: bipush 75
    //   1031: invokestatic 450	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1034: isub
    //   1035: bipush 254
    //   1037: invokespecial 452	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   1040: astore 6
    //   1042: aload 6
    //   1044: bipush 12
    //   1046: invokevirtual 455	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   1049: aload 6
    //   1051: aload_0
    //   1052: getfield 198	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:context	Landroid/content/Context;
    //   1055: iconst_3
    //   1056: invokestatic 450	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
    //   1059: putfield 458	android/widget/RelativeLayout$LayoutParams:bottomMargin	I
    //   1062: aload_0
    //   1063: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1066: aload 6
    //   1068: invokevirtual 462	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   1071: aload_0
    //   1072: getfield 465	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:contentView	Landroid/view/View;
    //   1075: getstatic 470	com/tencent/mm/plugin/sns/b$f:content_root	I
    //   1078: invokevirtual 476	android/view/View:findViewById	(I)Landroid/view/View;
    //   1081: checkcast 421	android/view/ViewGroup
    //   1084: aload_0
    //   1085: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1088: aload 6
    //   1090: invokevirtual 480	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1093: aload_0
    //   1094: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1097: iconst_4
    //   1098: invokevirtual 547	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:setVisibility	(I)V
    //   1101: aload_0
    //   1102: iconst_0
    //   1103: invokespecial 393	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:DV	(Z)V
    //   1106: aload_0
    //   1107: getfield 168	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQL	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aq;
    //   1110: ifnull +32 -> 1142
    //   1113: aload_0
    //   1114: getfield 168	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQL	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/aq;
    //   1117: astore 6
    //   1119: aload_0
    //   1120: getfield 260	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRH	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar;
    //   1123: invokevirtual 699	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar:getVisibility	()I
    //   1126: ifne +288 -> 1414
    //   1129: iload 5
    //   1131: istore 4
    //   1133: aload 6
    //   1135: iload 4
    //   1137: invokeinterface 559 2 0
    //   1142: ldc 242
    //   1144: ldc_w 750
    //   1147: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1150: aload_0
    //   1151: getfield 564	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:PQs	Landroid/view/View;
    //   1154: astore 6
    //   1156: aload_0
    //   1157: aload 6
    //   1159: getstatic 753	com/tencent/mm/plugin/sns/b$f:pause_video_container	I
    //   1162: invokevirtual 476	android/view/View:findViewById	(I)Landroid/view/View;
    //   1165: putfield 335	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRJ	Landroid/view/View;
    //   1168: aload_0
    //   1169: getfield 335	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QRJ	Landroid/view/View;
    //   1172: bipush 8
    //   1174: invokevirtual 552	android/view/View:setVisibility	(I)V
    //   1177: ldc_w 566
    //   1180: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1183: return
    //   1184: aload_0
    //   1185: getfield 360	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QSn	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper;
    //   1188: invokevirtual 757	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/widget/AdLandingVideoWrapper:getInnerVideoView	()Landroid/view/View;
    //   1191: astore 7
    //   1193: aload_0
    //   1194: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1197: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   1200: astore 8
    //   1202: aload 8
    //   1204: getfield 584	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:paddingLeft	F
    //   1207: fconst_0
    //   1208: fcmpl
    //   1209: ifne +33 -> 1242
    //   1212: aload 8
    //   1214: getfield 587	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:paddingTop	F
    //   1217: fconst_0
    //   1218: fcmpl
    //   1219: ifne +23 -> 1242
    //   1222: aload 8
    //   1224: getfield 590	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:paddingRight	F
    //   1227: fconst_0
    //   1228: fcmpl
    //   1229: ifne +13 -> 1242
    //   1232: aload 8
    //   1234: getfield 593	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:paddingBottom	F
    //   1237: fconst_0
    //   1238: fcmpl
    //   1239: ifeq +49 -> 1288
    //   1242: iconst_1
    //   1243: istore 4
    //   1245: aload 7
    //   1247: instanceof 759
    //   1250: ifeq +44 -> 1294
    //   1253: aload_0
    //   1254: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1257: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   1260: getfield 576	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:QLH	I
    //   1263: iconst_1
    //   1264: if_icmpne +30 -> 1294
    //   1267: iload 4
    //   1269: ifne +25 -> 1294
    //   1272: aload 7
    //   1274: new 36	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an$5
    //   1277: dup
    //   1278: aload_0
    //   1279: invokespecial 760	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an$5:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an;)V
    //   1282: invokevirtual 764	android/view/View:addOnLayoutChangeListener	(Landroid/view/View$OnLayoutChangeListener;)V
    //   1285: goto -956 -> 329
    //   1288: iconst_0
    //   1289: istore 4
    //   1291: goto -46 -> 1245
    //   1294: ldc_w 313
    //   1297: new 403	java/lang/StringBuilder
    //   1300: dup
    //   1301: ldc_w 766
    //   1304: invokespecial 408	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1307: aload 7
    //   1309: invokevirtual 769	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1312: ldc_w 771
    //   1315: invokevirtual 494	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: aload_0
    //   1319: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1322: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   1325: getfield 576	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:QLH	I
    //   1328: invokevirtual 606	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1331: ldc_w 773
    //   1334: invokevirtual 494	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1337: iload 4
    //   1339: invokevirtual 412	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1342: invokevirtual 413	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1345: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1348: goto -1019 -> 329
    //   1351: ldc_w 645
    //   1354: aload_0
    //   1355: getfield 432	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an:QOV	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/aa;
    //   1358: checkcast 434	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap
    //   1361: getfield 648	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/ap:QLG	Ljava/lang/String;
    //   1364: new 42	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an$8
    //   1367: dup
    //   1368: aload_0
    //   1369: invokespecial 774	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an$8:<init>	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/an;)V
    //   1372: invokestatic 777	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/k:b	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/g$a;)V
    //   1375: goto -966 -> 409
    //   1378: iconst_0
    //   1379: istore 4
    //   1381: goto -871 -> 510
    //   1384: astore 8
    //   1386: ldc 242
    //   1388: aload 8
    //   1390: invokevirtual 248	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1393: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1396: goto -684 -> 712
    //   1399: astore 6
    //   1401: ldc 242
    //   1403: aload 6
    //   1405: invokevirtual 248	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1408: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1411: goto -445 -> 966
    //   1414: iconst_0
    //   1415: istore 4
    //   1417: goto -284 -> 1133
    //   1420: astore 6
    //   1422: ldc 242
    //   1424: aload 6
    //   1426: invokevirtual 248	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1429: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1432: goto -282 -> 1150
    //   1435: astore 6
    //   1437: ldc 242
    //   1439: aload 6
    //   1441: invokevirtual 248	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1444: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1447: ldc_w 566
    //   1450: invokestatic 240	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1453: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1454	0	this	an
    //   46	169	1	i	int
    //   44	18	2	j	int
    //   39	514	3	k	int
    //   508	908	4	bool1	boolean
    //   1	1129	5	bool2	boolean
    //   19	1139	6	localObject1	Object
    //   1399	5	6	localObject2	Object
    //   1420	5	6	localObject3	Object
    //   1435	5	6	localObject4	Object
    //   375	933	7	localObject5	Object
    //   628	605	8	localObject6	Object
    //   1384	5	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   621	650	1384	finally
    //   650	712	1384	finally
    //   822	887	1399	finally
    //   887	966	1399	finally
    //   966	1011	1420	finally
    //   1011	1129	1420	finally
    //   1133	1142	1420	finally
    //   1142	1150	1420	finally
    //   1156	1177	1435	finally
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, boolean paramBoolean3, int paramInt7, String paramString, long paramLong2)
  {
    AppMethodBeat.i(307310);
    for (;;)
    {
      try
      {
        this.QSn.setNeedPause(false);
        this.PQr = 6;
        this.QRO += paramLong2;
        this.QRK = paramBoolean2;
        this.PQI += 1;
        this.PQF += paramInt2;
        this.PQH += paramInt3;
        this.PQG += paramInt4;
        this.PQE += paramInt5;
        this.LKo += paramInt6;
        this.PSW = ((int)(this.PSW + paramLong1));
        boolean bool = Util.isNullOrNil(paramString);
        if (!bool) {}
        try
        {
          paramString = new JSONObject(paramString);
          if (this.QSw == null) {
            this.QSw = new b();
          }
          b localb = this.QSw;
          localb.PXy += paramString.optInt("exposureCount");
          localb = this.QSw;
          localb.hTS += paramString.optLong("stayTime");
          localb = this.QSw;
          localb.clickCount += paramString.optInt("clickCount");
          paramString = paramString.optJSONObject("btnInfo");
          this.QSw.PXz = paramString.optString("cid");
          localb = this.QSw;
          localb.PXA += paramString.optInt("exposureCount");
          localb = this.QSw;
          localb.PXB += paramString.optLong("stayTime");
          localb = this.QSw;
          paramInt2 = localb.PXC;
          localb.PXC = (paramString.optInt("clickCount") + paramInt2);
        }
        finally
        {
          this.QSw = null;
          Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", paramString.toString());
          continue;
        }
        if (paramBoolean2) {
          this.LJG = System.currentTimeMillis();
        }
        this.mRi.removeCallbacks(this.QRL);
        this.QRJ.setVisibility(8);
        Log.i("VideoFullScreenActivity", "currPosSec = " + paramInt1 + ", isPlaying = " + paramBoolean2 + ", bNoVoice = " + paramBoolean1);
        if (!paramBoolean3) {
          break;
        }
        if ((paramInt7 == this.QSn.getVideoDurationSec()) || (paramInt7 < 0))
        {
          this.QRH.seek(0);
          this.QSn.b(0.0D, true);
          this.LJG = System.currentTimeMillis();
          DV(true);
          if (!paramBoolean1) {
            break label613;
          }
          haw();
          AppMethodBeat.o(307310);
          return;
        }
      }
      finally
      {
        Log.e("VideoFullScreenActivity", paramString.toString());
        AppMethodBeat.o(307310);
        return;
      }
      this.QRH.seek(this.QSn.getCacheTimeSec());
      this.QSn.b(this.QSn.getCacheTimeSec(), true);
    }
    if ((paramInt1 == this.QSn.getVideoDurationSec()) || (paramInt1 < 0))
    {
      this.QRH.seek(0);
      this.QSn.b(0.0D, paramBoolean2);
    }
    for (;;)
    {
      DV(paramBoolean2);
      break;
      this.QRH.seek(paramInt1);
      this.QSn.b(paramInt1, paramBoolean2);
    }
    label613:
    hax();
    AppMethodBeat.o(307310);
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96786);
    if (!super.bP(paramJSONObject))
    {
      AppMethodBeat.o(96786);
      return false;
    }
    try
    {
      paramJSONObject.put("streamVideoDuraion", this.QSn.getVideoDurationSec() * 1000);
      paramJSONObject.put("playTimeInterval", this.PSW);
      paramJSONObject.put("playCount", this.LKo);
      paramJSONObject.put("playCompletedCount", this.PQE);
      paramJSONObject.put("clickFullscreenBtnCount", this.PQI);
      paramJSONObject.put("doubleClickCount", this.PQH);
      paramJSONObject.put("clickPlayControlCount", this.PQF);
      paramJSONObject.put("clickVoiceControlCount", this.PQG);
      if (this.isAutoPlay) {}
      for (Object localObject = "1";; localObject = "0")
      {
        paramJSONObject.put("isAutoPlay", localObject);
        JSONObject localJSONObject;
        if (!this.PQx)
        {
          localObject = MD5Util.getMD5String(((ap)this.QOV).QLG);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (!this.PQy)
        {
          localObject = MD5Util.getMD5String(((ap)this.QOV).PSB);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", localObject);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("streamVideoUrlInfo", localJSONObject);
        }
        if (this.QSw != null)
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("cid", this.QSw.PXz);
          ((JSONObject)localObject).put("exposureCount", this.QSw.PXA);
          ((JSONObject)localObject).put("stayTime", this.QSw.PXB);
          ((JSONObject)localObject).put("clickCount", this.QSw.PXC);
          localJSONObject = new JSONObject();
          localJSONObject.put("exposureCount", this.QSw.PXy);
          localJSONObject.put("stayTime", this.QSw.hTS);
          localJSONObject.put("clickCount", this.QSw.clickCount);
          localJSONObject.put("btnInfo", localObject);
          paramJSONObject.put("fullVideoFloatBarInfo", localJSONObject);
        }
        long l = hjj();
        com.tencent.mm.plugin.sns.ad.d.h.a(62, hjn(), l, this.PSW, "MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent");
        AppMethodBeat.o(96786);
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96786);
    }
  }
  
  public final void blc()
  {
    AppMethodBeat.i(307257);
    this.QSq = true;
    aN(this.PQR);
    AppMethodBeat.o(307257);
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96790);
    Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "online play error, %s", new Object[] { paramString3 });
    this.QRG = true;
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1579, 17);
    AppMethodBeat.o(96790);
  }
  
  public final void dSW()
  {
    AppMethodBeat.i(307313);
    Dt(false);
    this.PQr = 4;
    AppMethodBeat.o(307313);
  }
  
  public final void dSX()
  {
    AppMethodBeat.i(307317);
    this.PQr = 3;
    drB();
    AppMethodBeat.o(307317);
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void el(String paramString1, String paramString2)
  {
    this.QRG = false;
  }
  
  public final void em(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96788);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onVideoEnded");
    this.PQE += 1;
    setFocus(true);
    this.QSn.QTh.stopTimer();
    if (this.LJG != 0L)
    {
      this.PSW = ((int)(this.PSW + (System.currentTimeMillis() - this.LJG)));
      this.LJG = 0L;
    }
    this.PQr = 5;
    this.QSn.onUIPause();
    AppMethodBeat.o(96788);
  }
  
  public final void en(String paramString1, String paramString2) {}
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96789);
    Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "the onVideoPlay is called!");
    if (this.QIK != null) {
      this.QIK.hbe();
    }
    this.HLM.setVisibility(8);
    this.njj.setVisibility(8);
    try
    {
      this.mRi.removeCallbacks(this.QRL);
      this.QRJ.setVisibility(8);
      DV(true);
      AppMethodBeat.o(96789);
      return;
    }
    finally
    {
      Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramString1.toString());
      AppMethodBeat.o(96789);
    }
  }
  
  public final void ep(String paramString1, String paramString2)
  {
    AppMethodBeat.i(307269);
    this.isWaiting = true;
    this.AXD = System.currentTimeMillis();
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "mediaId = " + paramString2 + ", start loading");
    AppMethodBeat.o(307269);
  }
  
  public final void eq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(307270);
    this.isWaiting = false;
    this.QSv = 0;
    haH();
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "mediaId = " + paramString2 + ", end loading");
    AppMethodBeat.o(307270);
  }
  
  public final void gE(String paramString1, String paramString2) {}
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_new_stream;
  }
  
  protected final void had() {}
  
  public final void hao()
  {
    AppMethodBeat.i(96782);
    super.hao();
    AppMethodBeat.o(96782);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(96783);
    super.hap();
    this.QSn.setNeedPause(true);
    Dt(false);
    if ((!this.PQz) && (!this.PQA))
    {
      AppMethodBeat.o(96783);
      return;
    }
    this.PQA = false;
    this.PQz = false;
    if (this.PQr == 1) {
      this.PQr = 2;
    }
    AppMethodBeat.o(96783);
  }
  
  public final void haq()
  {
    AppMethodBeat.i(96785);
    super.haq();
    int i = hjh();
    int j = getView().getHeight();
    Log.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      this.QSn.setNeedPause(true);
      AppMethodBeat.o(96785);
      return;
    }
    if (i < 0)
    {
      this.QSn.setNeedPause(true);
      AppMethodBeat.o(96785);
      return;
    }
    if (i >= j * 0.5F)
    {
      if ((this.PQz) && (!this.PQA))
      {
        AppMethodBeat.o(96785);
        return;
      }
      this.QSn.setNeedPause(false);
      this.PQA = false;
      this.PQz = true;
      if (this.PQr == 6)
      {
        if (this.QRK)
        {
          this.PQr = 1;
          if (this.PQu.getVisibility() == 0)
          {
            this.PQu.setVisibility(8);
            AppMethodBeat.o(96785);
          }
        }
        else
        {
          this.PQr = 4;
        }
        AppMethodBeat.o(96785);
        return;
      }
      this.HLM.setVisibility(0);
      if ((!this.QSr) || ((this.QSr) && (hjG())))
      {
        setFocus(true);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(307249);
            if (an.r(an.this))
            {
              AppMethodBeat.o(307249);
              return;
            }
            an.a(an.this, false);
            AppMethodBeat.o(307249);
          }
        }, 3000L);
      }
      if (this.QSr)
      {
        if (!hjG())
        {
          this.PQu.setVisibility(0);
          this.isAutoPlay = false;
          this.QSr = false;
          AppMethodBeat.o(96785);
          return;
        }
        this.isAutoPlay = true;
        this.QSr = false;
      }
      if (this.PQr == 0)
      {
        if (hjG())
        {
          if (this.PQB) {
            haw();
          }
          for (;;)
          {
            this.PQr = 1;
            drB();
            AppMethodBeat.o(96785);
            return;
            hax();
          }
        }
      }
      else
      {
        if (this.PQr == 2)
        {
          if (this.PQB) {
            haw();
          }
          for (;;)
          {
            drB();
            this.PQr = 1;
            AppMethodBeat.o(96785);
            return;
            hax();
          }
        }
        if (this.PQr == 3)
        {
          if (this.PQB) {
            haw();
          }
          for (;;)
          {
            drB();
            AppMethodBeat.o(96785);
            return;
            hax();
          }
        }
      }
    }
    else
    {
      this.PQA = false;
      this.PQz = false;
      this.QSn.setNeedPause(true);
      Dt(false);
      if (this.PQr == 1) {
        this.PQr = 2;
      }
    }
    AppMethodBeat.o(96785);
  }
  
  public final void has()
  {
    AppMethodBeat.i(96784);
    super.has();
    try
    {
      this.QSn.QTh.stopTimer();
      this.mRi.removeCallbacks(this.PQR);
      this.mRi.removeCallbacks(this.QRL);
      haH();
      l.a(l.QnG, String.valueOf(this.PSX), 1, 0, "");
      this.QSn.onUIDestroy();
      AppMethodBeat.o(96784);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", localObject.toString());
      }
    }
  }
  
  public final void hav()
  {
    AppMethodBeat.i(307199);
    as(0, false);
    AppMethodBeat.o(307199);
  }
  
  public final void haw()
  {
    AppMethodBeat.i(96780);
    super.haw();
    this.QRE.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.icon_volume_off));
    this.QSn.setMute(true);
    this.PQB = true;
    AppMethodBeat.o(96780);
  }
  
  public final void hax()
  {
    AppMethodBeat.i(96781);
    super.hax();
    this.QRE.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.icon_volume_on));
    this.QSn.setMute(false);
    this.PQB = false;
    AppMethodBeat.o(96781);
  }
  
  public final void hay()
  {
    AppMethodBeat.i(307262);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onLoopCompletion");
    this.PQE += 1;
    if (this.QIK != null) {
      this.QIK.PUG = true;
    }
    AppMethodBeat.o(307262);
  }
  
  public final long hjj()
  {
    AppMethodBeat.i(307325);
    long l1 = super.hjj();
    long l2 = this.QRO;
    AppMethodBeat.o(307325);
    return l1 + l2;
  }
  
  public final void hjl()
  {
    AppMethodBeat.i(96791);
    super.hjl();
    Dt(false);
    String str = k.mC("adId", ((ap)this.QOV).QLG);
    if (y.ZC(str))
    {
      this.HLM.setImageBitmap(BitmapUtil.decodeFile(str));
      this.HLM.setVisibility(0);
    }
    AppMethodBeat.o(96791);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(307211);
    boolean bool = this.QSn.isPlaying();
    AppMethodBeat.o(307211);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(307279);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    if (paramView.getId() == b.f.sns_ad_native_landing_pages_sight_video_full_screen_btn) {
      Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "click full screen btn");
    }
    try
    {
      if ((this.context instanceof SnsAdNativeLandingPagesUI))
      {
        this.PQI += 1;
        this.mRi.removeCallbacks(this.QRL);
        this.QRJ.setVisibility(8);
        paramView = (SnsAdNativeLandingPagesUI)this.context;
        a.QSA = (ap)this.QOV;
        com.tencent.mm.plugin.sns.model.ag.Qud = hjn();
        localObject = new Intent(paramView, VideoFullScreenActivity.class);
        ((Intent)localObject).putExtra("KComponentVideoType", 1);
        ((Intent)localObject).putExtra("KComponentCid", this.QOV.QKG);
        ((Intent)localObject).putExtra("KComponentCurrentTime", this.QSn.getCurrPosSec());
        ((Intent)localObject).putExtra("KComponentTotalTime", this.QSn.getVideoDurationSec());
        ((Intent)localObject).putExtra("KComponentVoiceType", this.PQB);
        ((Intent)localObject).putExtra("KComponentProgressType", this.QSn.isPlaying());
        ((Intent)localObject).putExtra("KComponentStreamVideoUrlPath", ((ap)this.QOV).PSB);
        ((Intent)localObject).putExtra("KComponentIsWaiting", this.isWaiting);
        ((Intent)localObject).putExtra("KComponentSeekTimeDueWaiting", this.QSv);
        ((Intent)localObject).putExtra("KComponentKComponentCacheTime", this.QSn.getCacheTimeSec());
        ((Intent)localObject).putExtra("KComponentForceLandMode", ((ap)this.QOV).QJw);
        this.QSn.setNeedPause(true);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, c.a(2000, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject).aYi(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "onClick", "(Landroid/view/View;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1720, 2);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(307279);
        return;
        this.QRI.setVisibility(8);
      }
    }
    finally
    {
      for (;;)
      {
        this.QRI.setVisibility(8);
        Log.e("VideoFullScreenActivity", paramView.toString());
      }
    }
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307284);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onDoubleTap");
        aN(this.PQR);
        if (!this.QRG) {
          this.PQH += 1;
        }
        if (!this.QSn.isPlaying()) {
          continue;
        }
        Dt(true);
        this.PQr = 4;
      }
      finally
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramMotionEvent.toString());
        continue;
        hiA();
        hax();
        continue;
      }
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(307284);
      return false;
      if (!this.PQB) {
        continue;
      }
      haw();
      drB();
      this.PQr = 3;
    }
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307295);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(307295);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onSeekComplete(ITPPlayer paramITPPlayer) {}
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307280);
    try
    {
      Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", "onSingleTapConfirmed");
      if (!this.QSq)
      {
        this.QSq = true;
        setFocus(true);
      }
      for (;;)
      {
        AppMethodBeat.o(307280);
        return false;
        this.QSq = false;
        setFocus(false);
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent.VideoOptimize", paramMotionEvent.toString());
      }
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307291);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(307291);
    return false;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(307272);
    paramView = this.nwZ;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aYi(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageStreamVideoPlayerComponent", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(307272);
    return bool;
  }
  
  public final void tS(int paramInt)
  {
    AppMethodBeat.i(96787);
    Log.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onSeek time ".concat(String.valueOf(paramInt)));
    this.QSv = paramInt;
    if (this.PQB) {
      haw();
    }
    for (;;)
    {
      this.mRi.removeCallbacks(this.QRL);
      this.QRJ.setVisibility(8);
      as(paramInt, true);
      this.PQr = 3;
      AppMethodBeat.o(96787);
      return;
      hiA();
      hax();
    }
  }
  
  public final void tT(int paramInt) {}
  
  public static final class a
  {
    public static ap QSA;
  }
  
  static final class b
  {
    int PXA;
    long PXB;
    int PXC;
    int PXy;
    String PXz;
    int clickCount;
    long hTS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an
 * JD-Core Version:    0.7.0.1
 */