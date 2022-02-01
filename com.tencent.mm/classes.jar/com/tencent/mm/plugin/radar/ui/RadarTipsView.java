package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DelayShowNoviceEducationTips", "DelayShowSearchingTips", "HideNoviceEducationTips", "HideTips", "ShowNoMemberTips", "gone", "com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1;", "<set-?>", "", "isPressing", "()Z", "mCurrentTipsPurpose", "mDontHideFlag", "mHasShownNoviceEducation", "mNoMember", "mPressCount", "mPressForShow", "mPressStartAt", "", "mPressTooShortCount", "mStartWithClick", "noviceEducationTips", "Landroid/widget/LinearLayout;", "getNoviceEducationTips", "()Landroid/widget/LinearLayout;", "noviceEducationTips$delegate", "Lkotlin/Lazy;", "textTipsContainer", "Landroid/view/View;", "getTextTipsContainer", "()Landroid/view/View;", "textTipsContainer$delegate", "tipsFadeIn", "Landroid/view/animation/Animation;", "getTipsFadeIn", "()Landroid/view/animation/Animation;", "tipsFadeIn$delegate", "tipsFadeOut", "getTipsFadeOut", "tipsFadeOut$delegate", "tipsHandler", "com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1;", "tvTextTips", "Landroid/widget/TextView;", "getTvTextTips", "()Landroid/widget/TextView;", "tvTextTips$delegate", "hideAll", "", "hideNoviceEducation", "hideRadarTips", "init", "removeShowTipsMessages", "reset", "setNoMember", "noMember", "setPressingDown", "show", "setPressingUp", "showErrMsg", "msg", "", "showNoviceEducation", "showPressTooShortTips", "showRadarTips", "res", "during", "showSearchingTips", "Companion", "plugin-radar_release"})
public final class RadarTipsView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.RadarTipsView";
  private static final int uUu = 3;
  private static final int uUv = 0;
  static final int uUw = 1;
  static final int uUx = 2;
  private static final int uUy = 3;
  public static final RadarTipsView.a uUz;
  private final b uUa;
  private final f uUb;
  private final f uUc;
  private final f uUd;
  private final f uUe;
  private final f uUf;
  private final int uUg;
  final int uUh;
  final int uUi;
  private final int uUj;
  private final int uUk;
  final f uUl;
  boolean uUm;
  private boolean uUn;
  boolean uUo;
  boolean uUp;
  private int uUq;
  private long uUr;
  private boolean uUs;
  int uUt;
  
  static
  {
    AppMethodBeat.i(138711);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(RadarTipsView.class), "tipsFadeIn", "getTipsFadeIn()Landroid/view/animation/Animation;")), (d.l.k)w.a(new u(w.bk(RadarTipsView.class), "tipsFadeOut", "getTipsFadeOut()Landroid/view/animation/Animation;")), (d.l.k)w.a(new u(w.bk(RadarTipsView.class), "tvTextTips", "getTvTextTips()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bk(RadarTipsView.class), "textTipsContainer", "getTextTipsContainer()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(RadarTipsView.class), "noviceEducationTips", "getNoviceEducationTips()Landroid/widget/LinearLayout;")) };
    uUz = new RadarTipsView.a((byte)0);
    TAG = "MicroMsg.RadarTipsView";
    uUu = 3;
    uUw = 1;
    uUx = 2;
    uUy = 3;
    AppMethodBeat.o(138711);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138725);
    this.uUa = new b(this);
    this.uUb = g.E((a)new d(this));
    this.uUc = g.E((a)new e(this));
    this.uUd = i.am(this, 2131303701);
    this.uUe = i.am(this, 2131303699);
    this.uUf = i.am(this, 2131303702);
    this.uUh = 1;
    this.uUi = 2;
    this.uUj = 3;
    this.uUk = 3;
    this.uUl = new f(this, Looper.getMainLooper());
    this.uUn = true;
    this.uUt = uUv;
    AppMethodBeat.o(138725);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138726);
    this.uUa = new b(this);
    this.uUb = g.E((a)new d(this));
    this.uUc = g.E((a)new e(this));
    this.uUd = i.am(this, 2131303701);
    this.uUe = i.am(this, 2131303699);
    this.uUf = i.am(this, 2131303702);
    this.uUh = 1;
    this.uUi = 2;
    this.uUj = 3;
    this.uUk = 3;
    this.uUl = new f(this, Looper.getMainLooper());
    this.uUn = true;
    this.uUt = uUv;
    AppMethodBeat.o(138726);
  }
  
  private void dfq()
  {
    AppMethodBeat.i(138724);
    this.uUm = false;
    f localf = this.uUl;
    localf.removeMessages(this.uUh);
    localf.removeMessages(this.uUi);
    localf.removeMessages(this.uUj);
    AppMethodBeat.o(138724);
  }
  
  private void eh(String paramString, int paramInt)
  {
    AppMethodBeat.i(138718);
    d.g.b.k.h(paramString, "msg");
    this.uUm = true;
    getNoviceEducationTips().setVisibility(8);
    getNoviceEducationTips().clearAnimation();
    getTvTextTips().setText((CharSequence)paramString);
    setVisibility(0);
    getTextTipsContainer().setVisibility(0);
    getTextTipsContainer().startAnimation(getTipsFadeIn());
    this.uUl.removeMessages(this.uUg);
    this.uUl.removeMessages(this.uUi);
    if (paramInt > 0) {
      this.uUl.sendEmptyMessageDelayed(this.uUg, paramInt);
    }
    AppMethodBeat.o(138718);
  }
  
  private final Animation getTipsFadeOut()
  {
    AppMethodBeat.i(138713);
    Animation localAnimation = (Animation)this.uUc.getValue();
    AppMethodBeat.o(138713);
    return localAnimation;
  }
  
  private final TextView getTvTextTips()
  {
    AppMethodBeat.i(138714);
    TextView localTextView = (TextView)this.uUd.getValue();
    AppMethodBeat.o(138714);
    return localTextView;
  }
  
  public final void alk(String paramString)
  {
    AppMethodBeat.i(138719);
    d.g.b.k.h(paramString, "msg");
    this.uUt = uUy;
    eh(paramString, 5000);
    AppMethodBeat.o(138719);
  }
  
  public final void dfo()
  {
    AppMethodBeat.i(138720);
    this.uUm = false;
    this.uUt = uUv;
    ad.d(TAG, "hidNoviceEducation");
    this.uUl.removeMessages(this.uUj);
    if ((getVisibility() == 0) && (getNoviceEducationTips().getVisibility() == 0))
    {
      getNoviceEducationTips().clearAnimation();
      if (getTextTipsContainer().getAnimation() == getTipsFadeOut()) {
        getTextTipsContainer().clearAnimation();
      }
      ad.d(TAG, "hideNoviceEducation real");
      getNoviceEducationTips().startAnimation(getTipsFadeOut());
    }
    AppMethodBeat.o(138720);
  }
  
  public final void dfp()
  {
    AppMethodBeat.i(138723);
    ad.d(TAG, "hideRadarTips");
    if ((getVisibility() == 0) && (getTextTipsContainer().getVisibility() == 0))
    {
      if (getNoviceEducationTips().getAnimation() == getTipsFadeOut()) {
        getNoviceEducationTips().clearAnimation();
      }
      getTextTipsContainer().clearAnimation();
      ad.d(TAG, "hideRadarTips real");
      this.uUt = uUv;
      this.uUm = false;
      getTextTipsContainer().startAnimation(getTipsFadeOut());
    }
    AppMethodBeat.o(138723);
  }
  
  final LinearLayout getNoviceEducationTips()
  {
    AppMethodBeat.i(138716);
    LinearLayout localLinearLayout = (LinearLayout)this.uUf.getValue();
    AppMethodBeat.o(138716);
    return localLinearLayout;
  }
  
  final View getTextTipsContainer()
  {
    AppMethodBeat.i(138715);
    View localView = (View)this.uUe.getValue();
    AppMethodBeat.o(138715);
    return localView;
  }
  
  final Animation getTipsFadeIn()
  {
    AppMethodBeat.i(138712);
    Animation localAnimation = (Animation)this.uUb.getValue();
    AppMethodBeat.o(138712);
    return localAnimation;
  }
  
  public final void setNoMember(boolean paramBoolean)
  {
    AppMethodBeat.i(138721);
    this.uUn = paramBoolean;
    if (!this.uUn)
    {
      dfp();
      dfq();
      dfo();
    }
    AppMethodBeat.o(138721);
  }
  
  public final void setPressingDown(boolean paramBoolean)
  {
    AppMethodBeat.i(138722);
    if (this.uUr != 0L)
    {
      this.uUt = uUv;
      dfq();
      dfp();
      getTextTipsContainer().setVisibility(8);
      getNoviceEducationTips().setVisibility(8);
      setVisibility(8);
    }
    this.uUp = true;
    this.uUr = bt.GC();
    this.uUs = paramBoolean;
    this.uUq += 1;
    AppMethodBeat.o(138722);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class b
    extends ap
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138703);
      d.g.b.k.h(paramMessage, "msg");
      this.uUA.setVisibility(8);
      AppMethodBeat.o(138703);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(RadarTipsView paramRadarTipsView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138704);
      ad.d(RadarTipsView.access$getTAG$cp(), "noviceEducationTips onclick");
      this.uUA.dfo();
      AppMethodBeat.o(138704);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<Animation>
  {
    d(RadarTipsView paramRadarTipsView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<Animation>
  {
    e(RadarTipsView paramRadarTipsView)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsFadeOut$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarTipsView.e parame) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138707);
        d.g.b.k.h(paramAnimation, "animation");
        if (!RadarTipsView.b(this.uUB.uUA)) {
          RadarTipsView.c(this.uUB.uUA).sendEmptyMessage(0);
        }
        AppMethodBeat.o(138707);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(138708);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(138708);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(138706);
        d.g.b.k.h(paramAnimation, "animation");
        AppMethodBeat.o(138706);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class f
    extends ap
  {
    f(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138710);
      d.g.b.k.h(paramMessage, "msg");
      int i = paramMessage.what;
      if (i == RadarTipsView.d(this.uUA))
      {
        this.uUA.dfp();
        AppMethodBeat.o(138710);
        return;
      }
      if (i == RadarTipsView.e(this.uUA))
      {
        if ((RadarTipsView.f(this.uUA)) && (this.uUA.uUp))
        {
          RadarTipsView.a(this.uUA);
          AppMethodBeat.o(138710);
        }
      }
      else
      {
        if (i == RadarTipsView.g(this.uUA))
        {
          paramMessage = this.uUA;
          paramMessage.uUm = true;
          paramMessage.uUt = RadarTipsView.uUx;
          ad.d(RadarTipsView.TAG, "showNoviceEducation");
          paramMessage.uUo = true;
          paramMessage.getTextTipsContainer().setVisibility(8);
          paramMessage.getTextTipsContainer().clearAnimation();
          paramMessage.setVisibility(0);
          paramMessage.getNoviceEducationTips().setVisibility(0);
          paramMessage.getNoviceEducationTips().startAnimation(paramMessage.getTipsFadeIn());
          paramMessage.getNoviceEducationTips().requestFocus();
          AppMethodBeat.o(138710);
          return;
        }
        if (i == RadarTipsView.h(this.uUA)) {
          this.uUA.dfo();
        }
      }
      AppMethodBeat.o(138710);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarTipsView
 * JD-Core Version:    0.7.0.1
 */