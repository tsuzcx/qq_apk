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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DelayShowNoviceEducationTips", "DelayShowSearchingTips", "HideNoviceEducationTips", "HideTips", "ShowNoMemberTips", "gone", "com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1;", "<set-?>", "", "isPressing", "()Z", "mCurrentTipsPurpose", "mDontHideFlag", "mHasShownNoviceEducation", "mNoMember", "mPressCount", "mPressForShow", "mPressStartAt", "", "mPressTooShortCount", "mStartWithClick", "noviceEducationTips", "Landroid/widget/LinearLayout;", "getNoviceEducationTips", "()Landroid/widget/LinearLayout;", "noviceEducationTips$delegate", "Lkotlin/Lazy;", "textTipsContainer", "Landroid/view/View;", "getTextTipsContainer", "()Landroid/view/View;", "textTipsContainer$delegate", "tipsFadeIn", "Landroid/view/animation/Animation;", "getTipsFadeIn", "()Landroid/view/animation/Animation;", "tipsFadeIn$delegate", "tipsFadeOut", "getTipsFadeOut", "tipsFadeOut$delegate", "tipsHandler", "com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1;", "tvTextTips", "Landroid/widget/TextView;", "getTvTextTips", "()Landroid/widget/TextView;", "tvTextTips$delegate", "hideAll", "", "hideNoviceEducation", "hideRadarTips", "init", "removeShowTipsMessages", "reset", "setNoMember", "noMember", "setPressingDown", "show", "setPressingUp", "showErrMsg", "msg", "", "showNoviceEducation", "showPressTooShortTips", "showRadarTips", "res", "during", "showSearchingTips", "Companion", "plugin-radar_release"})
public final class RadarTipsView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.RadarTipsView";
  private static final int wdj = 3;
  private static final int wdk = 0;
  static final int wdl = 1;
  static final int wdm = 2;
  private static final int wdn = 3;
  public static final RadarTipsView.a wdo;
  private final b wcP;
  private final f wcQ;
  private final f wcR;
  private final f wcS;
  private final f wcT;
  private final f wcU;
  private final int wcV;
  final int wcW;
  final int wcX;
  private final int wcY;
  private final int wcZ;
  final f wda;
  boolean wdb;
  private boolean wdc;
  boolean wdd;
  boolean wde;
  private int wdf;
  private long wdg;
  private boolean wdh;
  int wdi;
  
  static
  {
    AppMethodBeat.i(138711);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(RadarTipsView.class), "tipsFadeIn", "getTipsFadeIn()Landroid/view/animation/Animation;")), (d.l.k)w.a(new u(w.bn(RadarTipsView.class), "tipsFadeOut", "getTipsFadeOut()Landroid/view/animation/Animation;")), (d.l.k)w.a(new u(w.bn(RadarTipsView.class), "tvTextTips", "getTvTextTips()Landroid/widget/TextView;")), (d.l.k)w.a(new u(w.bn(RadarTipsView.class), "textTipsContainer", "getTextTipsContainer()Landroid/view/View;")), (d.l.k)w.a(new u(w.bn(RadarTipsView.class), "noviceEducationTips", "getNoviceEducationTips()Landroid/widget/LinearLayout;")) };
    wdo = new RadarTipsView.a((byte)0);
    TAG = "MicroMsg.RadarTipsView";
    wdj = 3;
    wdl = 1;
    wdm = 2;
    wdn = 3;
    AppMethodBeat.o(138711);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138725);
    this.wcP = new b(this);
    this.wcQ = g.K((a)new d(this));
    this.wcR = g.K((a)new e(this));
    this.wcS = i.an(this, 2131303701);
    this.wcT = i.an(this, 2131303699);
    this.wcU = i.an(this, 2131303702);
    this.wcW = 1;
    this.wcX = 2;
    this.wcY = 3;
    this.wcZ = 3;
    this.wda = new f(this, Looper.getMainLooper());
    this.wdc = true;
    this.wdi = wdk;
    AppMethodBeat.o(138725);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138726);
    this.wcP = new b(this);
    this.wcQ = g.K((a)new d(this));
    this.wcR = g.K((a)new e(this));
    this.wcS = i.an(this, 2131303701);
    this.wcT = i.an(this, 2131303699);
    this.wcU = i.an(this, 2131303702);
    this.wcW = 1;
    this.wcX = 2;
    this.wcY = 3;
    this.wcZ = 3;
    this.wda = new f(this, Looper.getMainLooper());
    this.wdc = true;
    this.wdi = wdk;
    AppMethodBeat.o(138726);
  }
  
  private void dsX()
  {
    AppMethodBeat.i(138724);
    this.wdb = false;
    f localf = this.wda;
    localf.removeMessages(this.wcW);
    localf.removeMessages(this.wcX);
    localf.removeMessages(this.wcY);
    AppMethodBeat.o(138724);
  }
  
  private void eo(String paramString, int paramInt)
  {
    AppMethodBeat.i(138718);
    d.g.b.k.h(paramString, "msg");
    this.wdb = true;
    getNoviceEducationTips().setVisibility(8);
    getNoviceEducationTips().clearAnimation();
    getTvTextTips().setText((CharSequence)paramString);
    setVisibility(0);
    getTextTipsContainer().setVisibility(0);
    getTextTipsContainer().startAnimation(getTipsFadeIn());
    this.wda.removeMessages(this.wcV);
    this.wda.removeMessages(this.wcX);
    if (paramInt > 0) {
      this.wda.sendEmptyMessageDelayed(this.wcV, paramInt);
    }
    AppMethodBeat.o(138718);
  }
  
  private final Animation getTipsFadeOut()
  {
    AppMethodBeat.i(138713);
    Animation localAnimation = (Animation)this.wcR.getValue();
    AppMethodBeat.o(138713);
    return localAnimation;
  }
  
  private final TextView getTvTextTips()
  {
    AppMethodBeat.i(138714);
    TextView localTextView = (TextView)this.wcS.getValue();
    AppMethodBeat.o(138714);
    return localTextView;
  }
  
  public final void aqj(String paramString)
  {
    AppMethodBeat.i(138719);
    d.g.b.k.h(paramString, "msg");
    this.wdi = wdn;
    eo(paramString, 5000);
    AppMethodBeat.o(138719);
  }
  
  public final void dsV()
  {
    AppMethodBeat.i(138720);
    this.wdb = false;
    this.wdi = wdk;
    ac.d(TAG, "hidNoviceEducation");
    this.wda.removeMessages(this.wcY);
    if ((getVisibility() == 0) && (getNoviceEducationTips().getVisibility() == 0))
    {
      getNoviceEducationTips().clearAnimation();
      if (getTextTipsContainer().getAnimation() == getTipsFadeOut()) {
        getTextTipsContainer().clearAnimation();
      }
      ac.d(TAG, "hideNoviceEducation real");
      getNoviceEducationTips().startAnimation(getTipsFadeOut());
    }
    AppMethodBeat.o(138720);
  }
  
  public final void dsW()
  {
    AppMethodBeat.i(138723);
    ac.d(TAG, "hideRadarTips");
    if ((getVisibility() == 0) && (getTextTipsContainer().getVisibility() == 0))
    {
      if (getNoviceEducationTips().getAnimation() == getTipsFadeOut()) {
        getNoviceEducationTips().clearAnimation();
      }
      getTextTipsContainer().clearAnimation();
      ac.d(TAG, "hideRadarTips real");
      this.wdi = wdk;
      this.wdb = false;
      getTextTipsContainer().startAnimation(getTipsFadeOut());
    }
    AppMethodBeat.o(138723);
  }
  
  final LinearLayout getNoviceEducationTips()
  {
    AppMethodBeat.i(138716);
    LinearLayout localLinearLayout = (LinearLayout)this.wcU.getValue();
    AppMethodBeat.o(138716);
    return localLinearLayout;
  }
  
  final View getTextTipsContainer()
  {
    AppMethodBeat.i(138715);
    View localView = (View)this.wcT.getValue();
    AppMethodBeat.o(138715);
    return localView;
  }
  
  final Animation getTipsFadeIn()
  {
    AppMethodBeat.i(138712);
    Animation localAnimation = (Animation)this.wcQ.getValue();
    AppMethodBeat.o(138712);
    return localAnimation;
  }
  
  public final void setNoMember(boolean paramBoolean)
  {
    AppMethodBeat.i(138721);
    this.wdc = paramBoolean;
    if (!this.wdc)
    {
      dsW();
      dsX();
      dsV();
    }
    AppMethodBeat.o(138721);
  }
  
  public final void setPressingDown(boolean paramBoolean)
  {
    AppMethodBeat.i(138722);
    if (this.wdg != 0L)
    {
      this.wdi = wdk;
      dsX();
      dsW();
      getTextTipsContainer().setVisibility(8);
      getNoviceEducationTips().setVisibility(8);
      setVisibility(8);
    }
    this.wde = true;
    this.wdg = bs.Gn();
    this.wdh = paramBoolean;
    this.wdf += 1;
    AppMethodBeat.o(138722);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class b
    extends ao
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138703);
      d.g.b.k.h(paramMessage, "msg");
      this.wdp.setVisibility(8);
      AppMethodBeat.o(138703);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(RadarTipsView paramRadarTipsView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138704);
      ac.d(RadarTipsView.access$getTAG$cp(), "noviceEducationTips onclick");
      this.wdp.dsV();
      AppMethodBeat.o(138704);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<Animation>
  {
    d(RadarTipsView paramRadarTipsView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<Animation>
  {
    e(RadarTipsView paramRadarTipsView)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsFadeOut$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarTipsView.e parame) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138707);
        d.g.b.k.h(paramAnimation, "animation");
        if (!RadarTipsView.b(this.wdq.wdp)) {
          RadarTipsView.c(this.wdq.wdp).sendEmptyMessage(0);
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class f
    extends ao
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
      if (i == RadarTipsView.d(this.wdp))
      {
        this.wdp.dsW();
        AppMethodBeat.o(138710);
        return;
      }
      if (i == RadarTipsView.e(this.wdp))
      {
        if ((RadarTipsView.f(this.wdp)) && (this.wdp.wde))
        {
          RadarTipsView.a(this.wdp);
          AppMethodBeat.o(138710);
        }
      }
      else
      {
        if (i == RadarTipsView.g(this.wdp))
        {
          paramMessage = this.wdp;
          paramMessage.wdb = true;
          paramMessage.wdi = RadarTipsView.wdm;
          ac.d(RadarTipsView.TAG, "showNoviceEducation");
          paramMessage.wdd = true;
          paramMessage.getTextTipsContainer().setVisibility(8);
          paramMessage.getTextTipsContainer().clearAnimation();
          paramMessage.setVisibility(0);
          paramMessage.getNoviceEducationTips().setVisibility(0);
          paramMessage.getNoviceEducationTips().startAnimation(paramMessage.getTipsFadeIn());
          paramMessage.getNoviceEducationTips().requestFocus();
          AppMethodBeat.o(138710);
          return;
        }
        if (i == RadarTipsView.h(this.wdp)) {
          this.wdp.dsV();
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