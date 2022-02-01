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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import d.f;
import d.g;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DelayShowNoviceEducationTips", "DelayShowSearchingTips", "HideNoviceEducationTips", "HideTips", "ShowNoMemberTips", "gone", "com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1;", "<set-?>", "", "isPressing", "()Z", "mCurrentTipsPurpose", "mDontHideFlag", "mHasShownNoviceEducation", "mNoMember", "mPressCount", "mPressForShow", "mPressStartAt", "", "mPressTooShortCount", "mStartWithClick", "noviceEducationTips", "Landroid/widget/LinearLayout;", "getNoviceEducationTips", "()Landroid/widget/LinearLayout;", "noviceEducationTips$delegate", "Lkotlin/Lazy;", "textTipsContainer", "Landroid/view/View;", "getTextTipsContainer", "()Landroid/view/View;", "textTipsContainer$delegate", "tipsFadeIn", "Landroid/view/animation/Animation;", "getTipsFadeIn", "()Landroid/view/animation/Animation;", "tipsFadeIn$delegate", "tipsFadeOut", "getTipsFadeOut", "tipsFadeOut$delegate", "tipsHandler", "com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1;", "tvTextTips", "Landroid/widget/TextView;", "getTvTextTips", "()Landroid/widget/TextView;", "tvTextTips$delegate", "hideAll", "", "hideNoviceEducation", "hideRadarTips", "init", "removeShowTipsMessages", "reset", "setNoMember", "noMember", "setPressingDown", "show", "setPressingUp", "showErrMsg", "msg", "", "showNoviceEducation", "showPressTooShortTips", "showRadarTips", "res", "during", "showSearchingTips", "Companion", "plugin-radar_release"})
public final class RadarTipsView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.RadarTipsView";
  private static final int xkS = 3;
  private static final int xkT = 0;
  static final int xkU = 1;
  static final int xkV = 2;
  private static final int xkW = 3;
  public static final RadarTipsView.a xkX;
  private final f xkA;
  private final f xkB;
  private final f xkC;
  private final f xkD;
  private final int xkE;
  final int xkF;
  final int xkG;
  private final int xkH;
  private final int xkI;
  final f xkJ;
  boolean xkK;
  private boolean xkL;
  boolean xkM;
  boolean xkN;
  private int xkO;
  private long xkP;
  private boolean xkQ;
  int xkR;
  private final b xky;
  private final f xkz;
  
  static
  {
    AppMethodBeat.i(138711);
    xkX = new RadarTipsView.a((byte)0);
    TAG = "MicroMsg.RadarTipsView";
    xkS = 3;
    xkU = 1;
    xkV = 2;
    xkW = 3;
    AppMethodBeat.o(138711);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138725);
    this.xky = new b(this);
    this.xkz = g.O((d.g.a.a)new d(this));
    this.xkA = g.O((d.g.a.a)new e(this));
    this.xkB = i.ao(this, 2131303701);
    this.xkC = i.ao(this, 2131303699);
    this.xkD = i.ao(this, 2131303702);
    this.xkF = 1;
    this.xkG = 2;
    this.xkH = 3;
    this.xkI = 3;
    this.xkJ = new f(this, Looper.getMainLooper());
    this.xkL = true;
    this.xkR = xkT;
    AppMethodBeat.o(138725);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138726);
    this.xky = new b(this);
    this.xkz = g.O((d.g.a.a)new d(this));
    this.xkA = g.O((d.g.a.a)new e(this));
    this.xkB = i.ao(this, 2131303701);
    this.xkC = i.ao(this, 2131303699);
    this.xkD = i.ao(this, 2131303702);
    this.xkF = 1;
    this.xkG = 2;
    this.xkH = 3;
    this.xkI = 3;
    this.xkJ = new f(this, Looper.getMainLooper());
    this.xkL = true;
    this.xkR = xkT;
    AppMethodBeat.o(138726);
  }
  
  private void dDu()
  {
    AppMethodBeat.i(138724);
    this.xkK = false;
    f localf = this.xkJ;
    localf.removeMessages(this.xkF);
    localf.removeMessages(this.xkG);
    localf.removeMessages(this.xkH);
    AppMethodBeat.o(138724);
  }
  
  private void eH(String paramString, int paramInt)
  {
    AppMethodBeat.i(138718);
    p.h(paramString, "msg");
    this.xkK = true;
    getNoviceEducationTips().setVisibility(8);
    getNoviceEducationTips().clearAnimation();
    getTvTextTips().setText((CharSequence)paramString);
    setVisibility(0);
    getTextTipsContainer().setVisibility(0);
    getTextTipsContainer().startAnimation(getTipsFadeIn());
    this.xkJ.removeMessages(this.xkE);
    this.xkJ.removeMessages(this.xkG);
    if (paramInt > 0) {
      this.xkJ.sendEmptyMessageDelayed(this.xkE, paramInt);
    }
    AppMethodBeat.o(138718);
  }
  
  private final Animation getTipsFadeOut()
  {
    AppMethodBeat.i(138713);
    Animation localAnimation = (Animation)this.xkA.getValue();
    AppMethodBeat.o(138713);
    return localAnimation;
  }
  
  private final TextView getTvTextTips()
  {
    AppMethodBeat.i(138714);
    TextView localTextView = (TextView)this.xkB.getValue();
    AppMethodBeat.o(138714);
    return localTextView;
  }
  
  public final void avi(String paramString)
  {
    AppMethodBeat.i(138719);
    p.h(paramString, "msg");
    this.xkR = xkW;
    eH(paramString, 5000);
    AppMethodBeat.o(138719);
  }
  
  public final void dDs()
  {
    AppMethodBeat.i(138720);
    this.xkK = false;
    this.xkR = xkT;
    ad.d(TAG, "hidNoviceEducation");
    this.xkJ.removeMessages(this.xkH);
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
  
  public final void dDt()
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
      this.xkR = xkT;
      this.xkK = false;
      getTextTipsContainer().startAnimation(getTipsFadeOut());
    }
    AppMethodBeat.o(138723);
  }
  
  final LinearLayout getNoviceEducationTips()
  {
    AppMethodBeat.i(138716);
    LinearLayout localLinearLayout = (LinearLayout)this.xkD.getValue();
    AppMethodBeat.o(138716);
    return localLinearLayout;
  }
  
  final View getTextTipsContainer()
  {
    AppMethodBeat.i(138715);
    View localView = (View)this.xkC.getValue();
    AppMethodBeat.o(138715);
    return localView;
  }
  
  final Animation getTipsFadeIn()
  {
    AppMethodBeat.i(138712);
    Animation localAnimation = (Animation)this.xkz.getValue();
    AppMethodBeat.o(138712);
    return localAnimation;
  }
  
  public final void setNoMember(boolean paramBoolean)
  {
    AppMethodBeat.i(138721);
    this.xkL = paramBoolean;
    if (!this.xkL)
    {
      dDt();
      dDu();
      dDs();
    }
    AppMethodBeat.o(138721);
  }
  
  public final void setPressingDown(boolean paramBoolean)
  {
    AppMethodBeat.i(138722);
    if (this.xkP != 0L)
    {
      this.xkR = xkT;
      dDu();
      dDt();
      getTextTipsContainer().setVisibility(8);
      getNoviceEducationTips().setVisibility(8);
      setVisibility(8);
    }
    this.xkN = true;
    this.xkP = bt.HI();
    this.xkQ = paramBoolean;
    this.xkO += 1;
    AppMethodBeat.o(138722);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class b
    extends ap
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138703);
      p.h(paramMessage, "msg");
      this.xkY.setVisibility(8);
      AppMethodBeat.o(138703);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(RadarTipsView paramRadarTipsView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138704);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/radar/ui/RadarTipsView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ad.d(RadarTipsView.access$getTAG$cp(), "noviceEducationTips onclick");
      this.xkY.dDs();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/radar/ui/RadarTipsView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(138704);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<Animation>
  {
    d(RadarTipsView paramRadarTipsView)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<Animation>
  {
    e(RadarTipsView paramRadarTipsView)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsFadeOut$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarTipsView.e parame) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138707);
        p.h(paramAnimation, "animation");
        if (!RadarTipsView.b(this.xkZ.xkY)) {
          RadarTipsView.c(this.xkZ.xkY).sendEmptyMessage(0);
        }
        AppMethodBeat.o(138707);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(138708);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(138708);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(138706);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(138706);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
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
      p.h(paramMessage, "msg");
      int i = paramMessage.what;
      if (i == RadarTipsView.d(this.xkY))
      {
        this.xkY.dDt();
        AppMethodBeat.o(138710);
        return;
      }
      if (i == RadarTipsView.e(this.xkY))
      {
        if ((RadarTipsView.f(this.xkY)) && (this.xkY.xkN))
        {
          RadarTipsView.a(this.xkY);
          AppMethodBeat.o(138710);
        }
      }
      else
      {
        if (i == RadarTipsView.g(this.xkY))
        {
          paramMessage = this.xkY;
          paramMessage.xkK = true;
          paramMessage.xkR = RadarTipsView.xkV;
          ad.d(RadarTipsView.TAG, "showNoviceEducation");
          paramMessage.xkM = true;
          paramMessage.getTextTipsContainer().setVisibility(8);
          paramMessage.getTextTipsContainer().clearAnimation();
          paramMessage.setVisibility(0);
          paramMessage.getNoviceEducationTips().setVisibility(0);
          paramMessage.getNoviceEducationTips().startAnimation(paramMessage.getTipsFadeIn());
          paramMessage.getNoviceEducationTips().requestFocus();
          AppMethodBeat.o(138710);
          return;
        }
        if (i == RadarTipsView.h(this.xkY)) {
          this.xkY.dDs();
        }
      }
      AppMethodBeat.o(138710);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarTipsView
 * JD-Core Version:    0.7.0.1
 */