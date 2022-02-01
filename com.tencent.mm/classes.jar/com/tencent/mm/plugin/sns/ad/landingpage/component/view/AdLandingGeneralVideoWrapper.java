package com.tencent.mm.plugin.sns.ad.landingpage.component.view;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.sns.ad.widget.advideo.AdLandingVideoPlayerToolBar;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.LinkedList;
import java.util.List;

public class AdLandingGeneralVideoWrapper
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, d.a, com.tencent.mm.plugin.sight.decode.ui.b, i.a, i.b, i.c, i.d
{
  private long AXD;
  private boolean Flq;
  public long LJG;
  private int LKo;
  protected AdLandingVideoPlayerToolBar PSA;
  private String PSB;
  protected a PSC;
  private boolean PSD;
  private RelativeLayout.LayoutParams PSE;
  private int PSF;
  private int PSG;
  private RelativeLayout.LayoutParams PSH;
  private int PSI;
  private float PSJ;
  private float PSK;
  private float PSL;
  private float PSM;
  private float PSN;
  private float PSO;
  private float PSP;
  private float PSQ;
  private float PSR;
  protected float PSS;
  protected float PST;
  protected boolean PSU;
  public g PSV;
  public int PSW;
  private int PSX;
  protected AdLandingGeneralVideoView PSz;
  private float aAU;
  private float aAV;
  private GestureDetector nwZ;
  private int sAo;
  protected ViewGroup uwW;
  public d vZw;
  
  public AdLandingGeneralVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdLandingGeneralVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(310662);
    this.PSD = false;
    this.PSI = 0;
    this.PSJ = 0.0F;
    this.PSK = 0.0F;
    this.PSL = 1.0F;
    this.LJG = 0L;
    this.PSW = 0;
    this.LKo = 0;
    this.PSz = new AdLandingGeneralVideoView(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    paramContext.addRule(13);
    addView(this.PSz, paramContext);
    this.nwZ = new GestureDetector(this);
    this.vZw = new d();
    AppMethodBeat.o(310662);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10)
  {
    AppMethodBeat.i(310673);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.PSz.y(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
    this.PSA.setPivotX(this.aAU);
    this.PSA.setPivotY(this.aAV);
    localLinkedList.addAll(this.PSA.b(paramFloat1, paramFloat2, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10));
    if ((this.PSV != null) && (this.PSV.getContentView() != null))
    {
      View localView = this.PSV.getContentView();
      localView.setPivotX(this.PSP);
      localView.setPivotY(this.PSQ);
      localLinkedList.addAll(this.PSV.b(paramFloat1, paramFloat2, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10));
    }
    localAnimatorSet.playTogether(localLinkedList);
    if (this.PSU) {
      localAnimatorSet.setDuration(0L);
    }
    for (;;)
    {
      localAnimatorSet.start();
      AppMethodBeat.o(310673);
      return;
      localAnimatorSet.setDuration(500L);
    }
  }
  
  private void haH()
  {
    AppMethodBeat.i(310666);
    if (this.AXD != 0L)
    {
      this.PSX = ((int)(this.PSX + (System.currentTimeMillis() - this.AXD)));
      this.AXD = 0L;
    }
    AppMethodBeat.o(310666);
  }
  
  public final void Dp(boolean paramBoolean)
  {
    AppMethodBeat.i(311033);
    if (this.PSz == null)
    {
      AppMethodBeat.o(311033);
      return;
    }
    if (paramBoolean)
    {
      if (this.PSH != null)
      {
        this.PSz.setLayoutParams(this.PSH);
        AppMethodBeat.o(311033);
      }
    }
    else if (this.PSE != null) {
      this.PSz.setLayoutParams(this.PSE);
    }
    AppMethodBeat.o(311033);
  }
  
  public final void Dq(boolean paramBoolean)
  {
    AppMethodBeat.i(311062);
    if (!this.Flq)
    {
      AppMethodBeat.o(311062);
      return;
    }
    if (this.PSV == null)
    {
      AppMethodBeat.o(311062);
      return;
    }
    if (paramBoolean)
    {
      this.PSV.DU(true);
      AppMethodBeat.o(311062);
      return;
    }
    this.PSV.hiR();
    AppMethodBeat.o(311062);
  }
  
  public final void Du(String paramString)
  {
    AppMethodBeat.i(311003);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(14349, paramString);
    AppMethodBeat.o(311003);
  }
  
  public final boolean X(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(310787);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310652);
        if (AdLandingGeneralVideoWrapper.this.PSz != null) {
          AdLandingGeneralVideoWrapper.this.PSz.X(paramInt, paramBoolean);
        }
        AppMethodBeat.o(310652);
      }
    });
    AppMethodBeat.o(310787);
    return false;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(310694);
    this.PSC = parama;
    if (this.PSz != null)
    {
      this.PSz.setLoop(true);
      this.PSz.setReporter(this);
      this.PSz.setIMMVideoViewCallback(this);
      this.PSz.setIMMDownloadFinish(this);
      this.PSz.setLoopCompletionCallback(this);
      setOnTouchListener(this);
      setOnClickListener(this);
      parama = k.hkC();
      FilePathGenerator.checkMkdir(parama);
      this.PSz.setRootPath(parama);
      this.PSz.setIOnlineVideoProxy(new com.tencent.mm.plugin.sns.ad.landingpage.c.a());
    }
    AppMethodBeat.o(310694);
  }
  
  public final void a(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(310719);
    if (this.PSz != null) {
      this.PSz.a(paramh);
    }
    AppMethodBeat.o(310719);
  }
  
  public final void aWA(String paramString)
  {
    AppMethodBeat.i(310686);
    this.sAo = 0;
    this.PSB = paramString;
    if (this.PSz != null) {
      this.PSz.b(false, paramString, 0);
    }
    AppMethodBeat.o(310686);
  }
  
  public final void ajv(int paramInt)
  {
    AppMethodBeat.i(311080);
    if ((paramInt == -1) || (paramInt == 180))
    {
      AppMethodBeat.o(311080);
      return;
    }
    if (this.PSI == paramInt)
    {
      AppMethodBeat.o(311080);
      return;
    }
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    float f7;
    if (paramInt == 90)
    {
      this.PSK = 90.0F;
      if (this.PSI == 0)
      {
        f1 = this.PSJ;
        f2 = this.PSK;
        f3 = this.PSL;
        f4 = this.PSM;
        f5 = this.PSN;
        f6 = -this.PSN;
        a(f1, f2, f3, f4, 0.0F, f5, 0.0F, this.PSO + f6, this.PSS, this.PSR);
      }
      for (;;)
      {
        this.PSJ = this.PSK;
        if (this.PSV != null) {
          this.PSV.orientation = paramInt;
        }
        this.PSI = paramInt;
        AppMethodBeat.o(311080);
        return;
        f1 = this.PSJ;
        f2 = this.PSK;
        f3 = this.PSM;
        f4 = this.PSM;
        f5 = -this.PSN;
        f6 = this.PSN;
        f7 = this.PSN;
        float f8 = this.PSO;
        float f9 = -this.PSN;
        a(f1, f2, f3, f4, f5, f6, f7 - f8, this.PSO + f9, this.PSR, this.PSR);
      }
    }
    if (paramInt == -90)
    {
      this.PSK = -90.0F;
      if (this.PSI == 0) {
        a(this.PSJ, this.PSK, this.PSL, this.PSM, 0.0F, -this.PSN, 0.0F, this.PSN - this.PSO, this.PSS, this.PSR);
      }
      for (;;)
      {
        this.PSJ = this.PSK;
        break;
        f1 = this.PSJ;
        f2 = this.PSK;
        f3 = this.PSM;
        f4 = this.PSM;
        f5 = this.PSN;
        f6 = -this.PSN;
        f7 = -this.PSN;
        a(f1, f2, f3, f4, f5, f6, this.PSO + f7, this.PSN - this.PSO, this.PSR, this.PSR);
      }
    }
    this.PSK = 0.0F;
    if (this.PSI == 90)
    {
      f1 = this.PSJ;
      f2 = this.PSK;
      f3 = this.PSM;
      f4 = this.PSL;
      f5 = this.PSN;
      f6 = -this.PSN;
      a(f1, f2, f3, f4, f5, 0.0F, this.PSO + f6, 0.0F, this.PSR, this.PSS);
    }
    for (;;)
    {
      this.PSJ = this.PSK;
      break;
      a(this.PSJ, this.PSK, this.PSM, this.PSL, -this.PSN, 0.0F, this.PSN - this.PSO, 0.0F, this.PSR, this.PSS);
    }
  }
  
  public final void bAi() {}
  
  public final void bAj() {}
  
  public final void bAk() {}
  
  public final void bAl() {}
  
  public final void bd(String paramString, boolean paramBoolean) {}
  
  public final void blc()
  {
    AppMethodBeat.i(310905);
    if (this.PSC != null) {
      this.PSC.blc();
    }
    AppMethodBeat.o(310905);
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310929);
    this.PSD = true;
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1579, 10);
    Log.e("MicroMsg.Sns.AdLandingGeneralVideoWrapper", "player callback error, %s, %s", new Object[] { paramString2, paramString3 });
    AppMethodBeat.o(310929);
  }
  
  public final void drB()
  {
    AppMethodBeat.i(310799);
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoWrapper", "start play, downloadFailed = " + this.PSD);
    if (this.PSD)
    {
      Log.e("MicroMsg.Sns.AdLandingGeneralVideoWrapper", "last download fail, try again");
      this.PSz.b(false, this.PSB, 0);
      X(0, true);
      AppMethodBeat.o(310799);
      return;
    }
    if (isPlaying())
    {
      Log.i("MicroMsg.Sns.AdLandingGeneralVideoWrapper", "startPlay but player is playing");
      AppMethodBeat.o(310799);
      return;
    }
    int i = getCurrPosSec();
    if (i == getVideoDurationSec()) {
      X(0, true);
    }
    for (;;)
    {
      haG();
      AppMethodBeat.o(310799);
      return;
      X(i, true);
    }
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void el(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310941);
    this.PSD = false;
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoWrapper", "player callback onPrepared, %s", new Object[] { paramString2 });
    AppMethodBeat.o(310941);
  }
  
  public final void em(String paramString1, String paramString2) {}
  
  public final void en(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310957);
    if (this.PSC != null) {
      this.PSC.aWy(paramString2);
    }
    AppMethodBeat.o(310957);
  }
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310963);
    if (this.PSC != null) {
      this.PSC.aWx(paramString2);
    }
    AppMethodBeat.o(310963);
  }
  
  public final void ep(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310970);
    this.AXD = System.currentTimeMillis();
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoWrapper", "mediaId = " + paramString2 + ", start loading");
    AppMethodBeat.o(310970);
  }
  
  public final void eq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310978);
    haH();
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoWrapper", "mediaId = " + paramString2 + ", end loading");
    AppMethodBeat.o(310978);
  }
  
  public final void gE(String paramString1, String paramString2) {}
  
  public com.tencent.mm.plugin.sns.ad.g.a.a getAdLandingVideoFullScreenFloatBarReportInfo()
  {
    AppMethodBeat.i(311057);
    if (this.PSV != null)
    {
      com.tencent.mm.plugin.sns.ad.g.a.a locala = this.PSV.getAdLandingVideoFullScreenFloatBarReportInfo();
      AppMethodBeat.o(311057);
      return locala;
    }
    AppMethodBeat.o(311057);
    return null;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(310767);
    if (this.PSz != null)
    {
      int i = this.PSz.getCurrPosMs();
      AppMethodBeat.o(310767);
      return i;
    }
    AppMethodBeat.o(310767);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(310773);
    if (this.PSz != null)
    {
      int i = this.PSz.getCurrPosSec();
      AppMethodBeat.o(310773);
      return i;
    }
    AppMethodBeat.o(310773);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    AppMethodBeat.i(310727);
    if (this.PSz != null)
    {
      View localView = this.PSz.getInnerVideoView();
      AppMethodBeat.o(310727);
      return localView;
    }
    AppMethodBeat.o(310727);
    return null;
  }
  
  public int getPlayCount()
  {
    return this.LKo;
  }
  
  public int getPlayTimeInterval()
  {
    return this.PSW;
  }
  
  public ImageView getThumbView()
  {
    AppMethodBeat.i(310740);
    if (this.PSz != null)
    {
      ImageView localImageView = this.PSz.getThumbView();
      AppMethodBeat.o(310740);
      return localImageView;
    }
    AppMethodBeat.o(310740);
    return null;
  }
  
  public AdLandingVideoPlayerToolBar getToolBar()
  {
    return this.PSA;
  }
  
  public ViewGroup getVideoCompContainer()
  {
    return this.uwW;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(310761);
    if (this.PSz != null)
    {
      i = this.PSz.getVideoDurationSec();
      AppMethodBeat.o(310761);
      return i;
    }
    int i = this.sAo;
    AppMethodBeat.o(310761);
    return i;
  }
  
  public AdLandingGeneralVideoView getVideoView()
  {
    return this.PSz;
  }
  
  public final boolean haF()
  {
    AppMethodBeat.i(310782);
    if (this.vZw != null)
    {
      boolean bool = this.vZw.gR(false);
      AppMethodBeat.o(310782);
      return bool;
    }
    AppMethodBeat.o(310782);
    return false;
  }
  
  public final void haG()
  {
    AppMethodBeat.i(310795);
    this.LJG = System.currentTimeMillis();
    this.LKo += 1;
    AppMethodBeat.o(310795);
  }
  
  public final void haI()
  {
    AppMethodBeat.i(311043);
    if (this.PSV != null)
    {
      this.PSV.hiT();
      this.PSV.has();
    }
    AppMethodBeat.o(311043);
  }
  
  public final boolean haJ()
  {
    AppMethodBeat.i(311048);
    if (this.PSV != null)
    {
      boolean bool = this.PSV.isShowing();
      AppMethodBeat.o(311048);
      return bool;
    }
    AppMethodBeat.o(311048);
    return false;
  }
  
  public final void hay()
  {
    AppMethodBeat.i(310923);
    if (this.PSC != null) {
      this.PSC.hay();
    }
    AppMethodBeat.o(310923);
  }
  
  public final void hp(long paramLong)
  {
    AppMethodBeat.i(310997);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(310997);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(310753);
    if (this.PSz != null)
    {
      boolean bool = this.PSz.isPlaying();
      AppMethodBeat.o(310753);
      return bool;
    }
    AppMethodBeat.o(310753);
    return false;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(310868);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(310868);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(310824);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    if (this.PSC != null)
    {
      boolean bool = this.PSC.haA();
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(310824);
      return bool;
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(310824);
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(310853);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(310853);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onSeekComplete(ITPPlayer paramITPPlayer) {}
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(310818);
    if (this.PSC != null)
    {
      boolean bool = this.PSC.haz();
      AppMethodBeat.o(310818);
      return bool;
    }
    AppMethodBeat.o(310818);
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(310844);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(310844);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(310877);
    if (this.nwZ != null)
    {
      paramView = this.nwZ;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aYi(), "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(310877);
      return bool;
    }
    AppMethodBeat.o(310877);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(310814);
    if (this.PSz != null) {
      this.PSz.onUIDestroy();
    }
    haH();
    l.a(l.QnG, String.valueOf(this.PSX), 0, 0, "");
    AppMethodBeat.o(310814);
  }
  
  public void setAnimImmediately(boolean paramBoolean)
  {
    this.PSU = paramBoolean;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(310746);
    if (this.PSz != null) {
      this.PSz.setCover(paramBitmap);
    }
    AppMethodBeat.o(310746);
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    this.Flq = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(310792);
    if (this.PSz != null) {
      this.PSz.setMute(paramBoolean);
    }
    AppMethodBeat.o(310792);
  }
  
  public void setPlayerMode(int paramInt)
  {
    AppMethodBeat.i(310680);
    if (this.PSz != null) {
      this.PSz.setVideoPlayerMode(paramInt);
    }
    AppMethodBeat.o(310680);
  }
  
  public void setVideoContainer(ViewGroup paramViewGroup)
  {
    this.uwW = paramViewGroup;
  }
  
  public void setVideoToolBar(AdLandingVideoPlayerToolBar paramAdLandingVideoPlayerToolBar)
  {
    this.PSA = paramAdLandingVideoPlayerToolBar;
  }
  
  public final void tS(int paramInt)
  {
    AppMethodBeat.i(310911);
    if (this.PSC != null) {
      this.PSC.tS(paramInt);
    }
    AppMethodBeat.o(310911);
  }
  
  public final void tT(int paramInt) {}
  
  public final void z(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(311021);
    for (;;)
    {
      try
      {
        this.PSS = paramFloat3;
        this.PST = paramFloat4;
        this.PSE = ((RelativeLayout.LayoutParams)this.PSz.getLayoutParams());
        if (paramFloat1 / this.PSS > paramFloat2 / this.PST)
        {
          this.PSF = ((int)this.PSS);
          this.PSG = ((int)(this.PSF * paramFloat2 / paramFloat1) + 1);
          this.PSH = new RelativeLayout.LayoutParams(this.PSF, this.PSG);
          this.PSH.leftMargin = (((int)this.PSS - this.PSF) / 2);
          this.PSH.rightMargin = this.PSH.leftMargin;
          this.PSH.topMargin = (((int)this.PST - this.PSG) / 2);
          this.PSH.bottomMargin = this.PSH.topMargin;
          if (this.PST / this.PSS > this.PSF / this.PSG)
          {
            this.PSM = (this.PSS / this.PSG);
            this.PSN = ((paramFloat4 - paramFloat3) / 2.0F);
            this.aAU = (paramFloat3 / 2.0F);
            if ((this.PSA == null) || (this.PSA.getHeight() <= 0)) {
              break label376;
            }
            this.aAV = (-paramFloat4 / 2.0F + this.PSA.getHeight());
            this.PSP = this.aAU;
            this.PSQ = (-paramFloat4 / 2.0F + com.tencent.mm.cd.a.fromDPToPix(getContext(), 96));
            this.PSO = com.tencent.mm.cd.a.fromDPToPix(getContext(), 64);
            this.PSR = (paramFloat4 - (int)(this.PSO * 2.0F));
            AppMethodBeat.o(311021);
          }
        }
        else
        {
          this.PSG = ((int)this.PST);
          this.PSF = ((int)(this.PSG * paramFloat1 / paramFloat2) + 1);
          continue;
        }
        this.PSM = (this.PST / this.PSF);
      }
      finally
      {
        Log.e("MicroMsg.Sns.AdLandingGeneralVideoWrapper", localObject.toString());
        AppMethodBeat.o(311021);
        return;
      }
      continue;
      label376:
      this.aAV = (-paramFloat4 / 2.0F + com.tencent.mm.cd.a.fromDPToPix(getContext(), 64));
    }
  }
  
  public static abstract interface a
  {
    public abstract void aWx(String paramString);
    
    public abstract void aWy(String paramString);
    
    public abstract void blc();
    
    public abstract boolean haA();
    
    public abstract void hay();
    
    public abstract boolean haz();
    
    public abstract void tS(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoWrapper
 * JD-Core Version:    0.7.0.1
 */