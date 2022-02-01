package com.tencent.mm.plugin.sns.ad.landingpage.component.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.plugin.sns.ad.widget.advideo.AdLandingVideoPlayerToolBar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.LinkedList;
import java.util.List;

public class AdLandingGeneralVideoWrapper
  extends RelativeLayout
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnClickListener, View.OnTouchListener, d.a, com.tencent.mm.plugin.sight.decode.ui.b, i.a, i.b, i.c, i.d
{
  private boolean AJP;
  public long FOL;
  private int FPs;
  protected AdLandingGeneralVideoView JCd;
  protected AdLandingVideoPlayerToolBar JCe;
  private String JCf;
  protected a JCg;
  private boolean JCh;
  private int JCi;
  private float JCj;
  private float JCk;
  private float JCl;
  private float JCm;
  private float JCn;
  private float JCo;
  private float JCp;
  private float JCq;
  private float JCr;
  private float JCs;
  private float JCt;
  protected float JCu;
  protected float JCv;
  protected boolean JCw;
  public g JCx;
  public int JCy;
  private GestureDetector mBn;
  private int pvi;
  protected ViewGroup rnd;
  public d sUi;
  
  public AdLandingGeneralVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdLandingGeneralVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(232571);
    this.JCh = false;
    this.JCi = 0;
    this.JCj = 0.0F;
    this.JCk = 0.0F;
    this.JCl = 1.0F;
    this.FOL = 0L;
    this.JCy = 0;
    this.FPs = 0;
    this.JCd = new AdLandingGeneralVideoView(paramContext);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    paramContext.addRule(13);
    addView(this.JCd, paramContext);
    this.mBn = new GestureDetector(this);
    this.sUi = d.bcs();
    AppMethodBeat.o(232571);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10)
  {
    AppMethodBeat.i(232716);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.JCd.t(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
    this.JCe.setPivotX(this.JCp);
    this.JCe.setPivotY(this.JCq);
    localLinkedList.addAll(this.JCe.b(paramFloat1, paramFloat2, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10));
    if ((this.JCx != null) && (this.JCx.getContentView() != null))
    {
      View localView = this.JCx.getContentView();
      localView.setPivotX(this.JCr);
      localView.setPivotY(this.JCs);
      localLinkedList.addAll(this.JCx.b(paramFloat1, paramFloat2, paramFloat5, paramFloat6, paramFloat7, paramFloat8, paramFloat9, paramFloat10));
    }
    localAnimatorSet.playTogether(localLinkedList);
    if (this.JCw) {
      localAnimatorSet.setDuration(0L);
    }
    for (;;)
    {
      localAnimatorSet.start();
      AppMethodBeat.o(232716);
      return;
      localAnimatorSet.setDuration(500L);
    }
  }
  
  public final void EW(long paramLong)
  {
    AppMethodBeat.i(232694);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(232694);
  }
  
  public final void KP(String paramString)
  {
    AppMethodBeat.i(232696);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(14349, paramString);
    AppMethodBeat.o(232696);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(232579);
    this.JCg = parama;
    if (this.JCd != null)
    {
      this.JCd.setLoop(true);
      this.JCd.setReporter(this);
      this.JCd.setIMMVideoViewCallback(this);
      this.JCd.setIMMDownloadFinish(this);
      this.JCd.setLoopCompletionCallback(this);
      setOnTouchListener(this);
      setOnClickListener(this);
      parama = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.fSq();
      FilePathGenerator.checkMkdir(parama);
      this.JCd.setRootPath(parama);
      this.JCd.setIOnlineVideoProxy(new com.tencent.mm.plugin.sns.ad.landingpage.c.a());
    }
    AppMethodBeat.o(232579);
  }
  
  public final void a(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(232590);
    if (this.JCd != null) {
      this.JCd.a(paramh);
    }
    AppMethodBeat.o(232590);
  }
  
  public final void aR(String paramString, boolean paramBoolean) {}
  
  public final void aRo()
  {
    AppMethodBeat.i(232657);
    if (this.JCg != null) {
      this.JCg.aRo();
    }
    AppMethodBeat.o(232657);
  }
  
  public final void aYy(String paramString)
  {
    AppMethodBeat.i(232576);
    this.pvi = 0;
    this.JCf = paramString;
    if (this.JCd != null) {
      this.JCd.c(false, paramString, 0);
    }
    AppMethodBeat.o(232576);
  }
  
  public final boolean aeM(final int paramInt)
  {
    AppMethodBeat.i(232613);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197614);
        if (AdLandingGeneralVideoWrapper.this.JCd != null) {
          AdLandingGeneralVideoWrapper.this.JCd.I(paramInt, this.JCA);
        }
        AppMethodBeat.o(197614);
      }
    });
    AppMethodBeat.o(232613);
    return false;
  }
  
  public final void aeN(int paramInt)
  {
    AppMethodBeat.i(232714);
    if ((paramInt == -1) || (paramInt == 180))
    {
      AppMethodBeat.o(232714);
      return;
    }
    if (this.JCi == paramInt)
    {
      AppMethodBeat.o(232714);
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
      this.JCk = 90.0F;
      if (this.JCi == 0)
      {
        f1 = this.JCj;
        f2 = this.JCk;
        f3 = this.JCl;
        f4 = this.JCm;
        f5 = this.JCn;
        f6 = -this.JCn;
        a(f1, f2, f3, f4, 0.0F, f5, 0.0F, this.JCo + f6, this.JCu, this.JCt);
      }
      for (;;)
      {
        this.JCj = this.JCk;
        if (this.JCx != null) {
          this.JCx.FO = paramInt;
        }
        this.JCi = paramInt;
        AppMethodBeat.o(232714);
        return;
        f1 = this.JCj;
        f2 = this.JCk;
        f3 = this.JCm;
        f4 = this.JCm;
        f5 = -this.JCn;
        f6 = this.JCn;
        f7 = this.JCn;
        float f8 = this.JCo;
        float f9 = -this.JCn;
        a(f1, f2, f3, f4, f5, f6, f7 - f8, this.JCo + f9, this.JCt, this.JCt);
      }
    }
    if (paramInt == -90)
    {
      this.JCk = -90.0F;
      if (this.JCi == 0) {
        a(this.JCj, this.JCk, this.JCl, this.JCm, 0.0F, -this.JCn, 0.0F, this.JCn - this.JCo, this.JCu, this.JCt);
      }
      for (;;)
      {
        this.JCj = this.JCk;
        break;
        f1 = this.JCj;
        f2 = this.JCk;
        f3 = this.JCm;
        f4 = this.JCm;
        f5 = this.JCn;
        f6 = -this.JCn;
        f7 = -this.JCn;
        a(f1, f2, f3, f4, f5, f6, this.JCo + f7, this.JCn - this.JCo, this.JCt, this.JCt);
      }
    }
    this.JCk = 0.0F;
    if (this.JCi == 90)
    {
      f1 = this.JCj;
      f2 = this.JCk;
      f3 = this.JCm;
      f4 = this.JCl;
      f5 = this.JCn;
      f6 = -this.JCn;
      a(f1, f2, f3, f4, f5, 0.0F, this.JCo + f6, 0.0F, this.JCt, this.JCu);
    }
    for (;;)
    {
      this.JCj = this.JCk;
      break;
      a(this.JCj, this.JCk, this.JCm, this.JCl, -this.JCn, 0.0F, this.JCn - this.JCo, 0.0F, this.JCt, this.JCu);
    }
  }
  
  public final void bcu() {}
  
  public final void bcv() {}
  
  public final void bcw() {}
  
  public final void bcx() {}
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(232669);
    this.JCh = true;
    com.tencent.mm.plugin.report.service.h.IzE.el(1579, 10);
    Log.e("MicroMsg.Sns.AdLandingGeneralVideoWrapper", "player callback error, %s, %s", new Object[] { paramString2, paramString3 });
    AppMethodBeat.o(232669);
  }
  
  public final void cNW()
  {
    AppMethodBeat.i(232621);
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoWrapper", "start play, downloadFailed = " + this.JCh);
    if (this.JCh)
    {
      Log.e("MicroMsg.Sns.AdLandingGeneralVideoWrapper", "last download fail, try again");
      this.JCd.c(false, this.JCf, 0);
      aeM(0);
      AppMethodBeat.o(232621);
      return;
    }
    if (isPlaying())
    {
      Log.i("MicroMsg.Sns.AdLandingGeneralVideoWrapper", "startPlay but player is playing");
      AppMethodBeat.o(232621);
      return;
    }
    int i = getCurrPosSec();
    if (i == getVideoDurationSec()) {
      aeM(0);
    }
    for (;;)
    {
      fKy();
      AppMethodBeat.o(232621);
      return;
      aeM(i);
    }
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public final void dS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(232673);
    this.JCh = false;
    Log.i("MicroMsg.Sns.AdLandingGeneralVideoWrapper", "player callback onPrepared, %s", new Object[] { paramString2 });
    AppMethodBeat.o(232673);
  }
  
  public final void dT(String paramString1, String paramString2) {}
  
  public final void dU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(232678);
    if (this.JCg != null) {
      this.JCg.aYw(paramString2);
    }
    AppMethodBeat.o(232678);
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(232680);
    if (this.JCg != null) {
      this.JCg.aYv(paramString2);
    }
    AppMethodBeat.o(232680);
  }
  
  public final void dW(String paramString1, String paramString2) {}
  
  public final void dX(String paramString1, String paramString2) {}
  
  public final void fC(String paramString1, String paramString2) {}
  
  public final boolean fKA()
  {
    AppMethodBeat.i(232703);
    if (this.JCx != null)
    {
      boolean bool = this.JCx.isShowing();
      AppMethodBeat.o(232703);
      return bool;
    }
    AppMethodBeat.o(232703);
    return false;
  }
  
  public final void fKB()
  {
    AppMethodBeat.i(232712);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    LinkedList localLinkedList = new LinkedList();
    ObjectAnimator localObjectAnimator2;
    if (this.AJP) {
      localObjectAnimator2 = this.JCd.b("scaleX", 1.0F, this.JCl);
    }
    for (ObjectAnimator localObjectAnimator1 = this.JCd.b("scaleY", 1.0F, this.JCl);; localObjectAnimator1 = this.JCd.b("scaleY", this.JCl, 1.0F))
    {
      localLinkedList.add(localObjectAnimator2);
      localLinkedList.add(localObjectAnimator1);
      localAnimatorSet.playTogether(localLinkedList);
      localAnimatorSet.setDuration(0L);
      localAnimatorSet.start();
      AppMethodBeat.o(232712);
      return;
      localObjectAnimator2 = this.JCd.b("scaleX", this.JCl, 1.0F);
    }
  }
  
  public final void fKt()
  {
    AppMethodBeat.i(232664);
    if (this.JCg != null) {
      this.JCg.fKt();
    }
    AppMethodBeat.o(232664);
  }
  
  public final boolean fKx()
  {
    AppMethodBeat.i(232609);
    if (this.sUi != null)
    {
      boolean bool = this.sUi.fZ(false);
      AppMethodBeat.o(232609);
      return bool;
    }
    AppMethodBeat.o(232609);
    return false;
  }
  
  public final void fKy()
  {
    AppMethodBeat.i(232618);
    this.FOL = System.currentTimeMillis();
    this.FPs += 1;
    AppMethodBeat.o(232618);
  }
  
  public final void fKz()
  {
    AppMethodBeat.i(232701);
    if (this.JCx != null)
    {
      this.JCx.fQV();
      this.JCx.fKo();
    }
    AppMethodBeat.o(232701);
  }
  
  public com.tencent.mm.plugin.sns.ad.f.a.a getAdLandingVideoFullScreenFloatBarReportInfo()
  {
    AppMethodBeat.i(232706);
    if (this.JCx != null)
    {
      com.tencent.mm.plugin.sns.ad.f.a.a locala = this.JCx.getAdLandingVideoFullScreenFloatBarReportInfo();
      AppMethodBeat.o(232706);
      return locala;
    }
    AppMethodBeat.o(232706);
    return null;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(232605);
    if (this.JCd != null)
    {
      int i = this.JCd.getCurrPosMs();
      AppMethodBeat.o(232605);
      return i;
    }
    AppMethodBeat.o(232605);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(232607);
    if (this.JCd != null)
    {
      int i = this.JCd.getCurrPosSec();
      AppMethodBeat.o(232607);
      return i;
    }
    AppMethodBeat.o(232607);
    return 0;
  }
  
  public View getInnerVideoView()
  {
    AppMethodBeat.i(232593);
    if (this.JCd != null)
    {
      View localView = this.JCd.getInnerVideoView();
      AppMethodBeat.o(232593);
      return localView;
    }
    AppMethodBeat.o(232593);
    return null;
  }
  
  public int getPlayCount()
  {
    return this.FPs;
  }
  
  public int getPlayTimeInterval()
  {
    return this.JCy;
  }
  
  public View getThumbView()
  {
    AppMethodBeat.i(232596);
    if (this.JCd != null)
    {
      View localView = this.JCd.getThumbView();
      AppMethodBeat.o(232596);
      return localView;
    }
    AppMethodBeat.o(232596);
    return null;
  }
  
  public AdLandingVideoPlayerToolBar getToolBar()
  {
    return this.JCe;
  }
  
  public ViewGroup getVideoCompContainer()
  {
    return this.rnd;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(232603);
    if (this.JCd != null)
    {
      i = this.JCd.getVideoDurationSec();
      AppMethodBeat.o(232603);
      return i;
    }
    int i = this.pvi;
    AppMethodBeat.o(232603);
    return i;
  }
  
  public View getVideoView()
  {
    return this.JCd;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(232601);
    if (this.JCd != null)
    {
      boolean bool = this.JCd.isPlaying();
      AppMethodBeat.o(232601);
      return bool;
    }
    AppMethodBeat.o(232601);
    return false;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(232648);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(232648);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(232629);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    if (this.JCg != null)
    {
      boolean bool = this.JCg.fKv();
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(232629);
      return bool;
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(232629);
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
    AppMethodBeat.i(232644);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(232644);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(232626);
    if (this.JCg != null)
    {
      boolean bool = this.JCg.fKu();
      AppMethodBeat.o(232626);
      return bool;
    }
    AppMethodBeat.o(232626);
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(232640);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(232640);
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(232650);
    if (this.mBn != null)
    {
      paramView = this.mBn;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, paramMotionEvent.aFh(), "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      boolean bool = com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.sf(0)), "com/tencent/mm/plugin/sns/ad/landingpage/component/view/AdLandingGeneralVideoWrapper", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(232650);
      return bool;
    }
    AppMethodBeat.o(232650);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(232624);
    if (this.JCd != null) {
      this.JCd.onUIDestroy();
    }
    AppMethodBeat.o(232624);
  }
  
  public void setAnimImmediately(boolean paramBoolean)
  {
    this.JCw = paramBoolean;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(232599);
    if (this.JCd != null) {
      this.JCd.setCover(paramBitmap);
    }
    AppMethodBeat.o(232599);
  }
  
  public void setFullScreen(boolean paramBoolean)
  {
    this.AJP = paramBoolean;
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(232615);
    if (this.JCd != null) {
      this.JCd.setMute(paramBoolean);
    }
    AppMethodBeat.o(232615);
  }
  
  public void setPlayerMode(int paramInt)
  {
    AppMethodBeat.i(232573);
    if (this.JCd != null) {
      this.JCd.setVideoPlayerMode(paramInt);
    }
    AppMethodBeat.o(232573);
  }
  
  public void setVideoContainer(ViewGroup paramViewGroup)
  {
    this.rnd = paramViewGroup;
  }
  
  public void setVideoToolBar(AdLandingVideoPlayerToolBar paramAdLandingVideoPlayerToolBar)
  {
    this.JCe = paramAdLandingVideoPlayerToolBar;
  }
  
  public final void tY(int paramInt)
  {
    AppMethodBeat.i(232660);
    if (this.JCg != null) {
      this.JCg.tY(paramInt);
    }
    AppMethodBeat.o(232660);
  }
  
  public final void u(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(232698);
    for (;;)
    {
      try
      {
        this.JCu = paramFloat3;
        this.JCv = paramFloat4;
        float f = paramFloat4 / paramFloat2;
        this.JCl = Math.min(paramFloat3 / paramFloat1, f);
        if (paramFloat4 / paramFloat3 > paramFloat1 / paramFloat2)
        {
          this.JCm = (paramFloat3 / paramFloat2);
          this.JCn = ((paramFloat4 - paramFloat3) / 2.0F);
          this.JCp = (paramFloat3 / 2.0F);
          if ((this.JCe != null) && (this.JCe.getHeight() > 0))
          {
            this.JCq = (-paramFloat4 / 2.0F + this.JCe.getHeight());
            this.JCr = this.JCp;
            this.JCs = (-paramFloat4 / 2.0F + com.tencent.mm.ci.a.fromDPToPix(getContext(), 96));
            this.JCo = com.tencent.mm.ci.a.fromDPToPix(getContext(), 64);
            this.JCt = (paramFloat4 - (int)(this.JCo * 2.0F));
            AppMethodBeat.o(232698);
          }
        }
        else
        {
          paramFloat1 = paramFloat4 / paramFloat1;
          this.JCm = paramFloat1;
          continue;
        }
        paramFloat1 = -paramFloat4 / 2.0F;
      }
      catch (Throwable localThrowable)
      {
        Log.e("MicroMsg.Sns.AdLandingGeneralVideoWrapper", localThrowable.toString());
        AppMethodBeat.o(232698);
        return;
      }
      this.JCq = (paramFloat1 + com.tencent.mm.ci.a.fromDPToPix(getContext(), 64));
    }
  }
  
  public final void yk(boolean paramBoolean)
  {
    AppMethodBeat.i(232709);
    if (!this.AJP)
    {
      AppMethodBeat.o(232709);
      return;
    }
    if (this.JCx == null)
    {
      AppMethodBeat.o(232709);
      return;
    }
    if (paramBoolean)
    {
      this.JCx.yL(true);
      AppMethodBeat.o(232709);
      return;
    }
    this.JCx.fQT();
    AppMethodBeat.o(232709);
  }
  
  public static abstract interface a
  {
    public abstract void aRo();
    
    public abstract void aYv(String paramString);
    
    public abstract void aYw(String paramString);
    
    public abstract void fKt();
    
    public abstract boolean fKu();
    
    public abstract boolean fKv();
    
    public abstract void tY(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.view.AdLandingGeneralVideoWrapper
 * JD-Core Version:    0.7.0.1
 */