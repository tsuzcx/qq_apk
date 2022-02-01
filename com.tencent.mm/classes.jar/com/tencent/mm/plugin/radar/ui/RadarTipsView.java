package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DelayShowNoviceEducationTips", "DelayShowSearchingTips", "HideNoviceEducationTips", "HideTips", "ShowNoMemberTips", "gone", "com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1;", "<set-?>", "", "isPressing", "()Z", "mCurrentTipsPurpose", "mDontHideFlag", "mHasShownNoviceEducation", "mNoMember", "mPressCount", "mPressForShow", "mPressStartAt", "", "mPressTooShortCount", "mStartWithClick", "noviceEducationTips", "Landroid/widget/LinearLayout;", "getNoviceEducationTips", "()Landroid/widget/LinearLayout;", "noviceEducationTips$delegate", "Lkotlin/Lazy;", "textTipsContainer", "Landroid/view/View;", "getTextTipsContainer", "()Landroid/view/View;", "textTipsContainer$delegate", "tipsFadeIn", "Landroid/view/animation/Animation;", "getTipsFadeIn", "()Landroid/view/animation/Animation;", "tipsFadeIn$delegate", "tipsFadeOut", "getTipsFadeOut", "tipsFadeOut$delegate", "tipsHandler", "com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1;", "tvTextTips", "Landroid/widget/TextView;", "getTvTextTips", "()Landroid/widget/TextView;", "tvTextTips$delegate", "hideAll", "", "hideNoviceEducation", "hideRadarTips", "init", "removeShowTipsMessages", "reset", "setNoMember", "noMember", "setPressingDown", "show", "setPressingUp", "showErrMsg", "msg", "", "showNoviceEducation", "showPressTooShortTips", "showRadarTips", "res", "during", "showSearchingTips", "Companion", "plugin-radar_release"})
public final class RadarTipsView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.RadarTipsView";
  private static final int xAP = 3;
  private static final int xAQ = 0;
  static final int xAR = 1;
  static final int xAS = 2;
  private static final int xAT = 3;
  public static final RadarTipsView.a xAU;
  private final f xAA;
  private final int xAB;
  final int xAC;
  final int xAD;
  private final int xAE;
  private final int xAF;
  final f xAG;
  boolean xAH;
  private boolean xAI;
  boolean xAJ;
  boolean xAK;
  private int xAL;
  private long xAM;
  private boolean xAN;
  int xAO;
  private final b xAv;
  private final f xAw;
  private final f xAx;
  private final f xAy;
  private final f xAz;
  
  static
  {
    AppMethodBeat.i(138711);
    xAU = new RadarTipsView.a((byte)0);
    TAG = "MicroMsg.RadarTipsView";
    xAP = 3;
    xAR = 1;
    xAS = 2;
    xAT = 3;
    AppMethodBeat.o(138711);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138725);
    this.xAv = new b(this);
    this.xAw = g.O((a)new d(this));
    this.xAx = g.O((a)new e(this));
    this.xAy = i.ao(this, 2131303701);
    this.xAz = i.ao(this, 2131303699);
    this.xAA = i.ao(this, 2131303702);
    this.xAC = 1;
    this.xAD = 2;
    this.xAE = 3;
    this.xAF = 3;
    this.xAG = new f(this, Looper.getMainLooper());
    this.xAI = true;
    this.xAO = xAQ;
    AppMethodBeat.o(138725);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138726);
    this.xAv = new b(this);
    this.xAw = g.O((a)new d(this));
    this.xAx = g.O((a)new e(this));
    this.xAy = i.ao(this, 2131303701);
    this.xAz = i.ao(this, 2131303699);
    this.xAA = i.ao(this, 2131303702);
    this.xAC = 1;
    this.xAD = 2;
    this.xAE = 3;
    this.xAF = 3;
    this.xAG = new f(this, Looper.getMainLooper());
    this.xAI = true;
    this.xAO = xAQ;
    AppMethodBeat.o(138726);
  }
  
  private void dGL()
  {
    AppMethodBeat.i(138724);
    this.xAH = false;
    f localf = this.xAG;
    localf.removeMessages(this.xAC);
    localf.removeMessages(this.xAD);
    localf.removeMessages(this.xAE);
    AppMethodBeat.o(138724);
  }
  
  private void eP(String paramString, int paramInt)
  {
    AppMethodBeat.i(138718);
    p.h(paramString, "msg");
    this.xAH = true;
    getNoviceEducationTips().setVisibility(8);
    getNoviceEducationTips().clearAnimation();
    getTvTextTips().setText((CharSequence)paramString);
    setVisibility(0);
    getTextTipsContainer().setVisibility(0);
    getTextTipsContainer().startAnimation(getTipsFadeIn());
    this.xAG.removeMessages(this.xAB);
    this.xAG.removeMessages(this.xAD);
    if (paramInt > 0) {
      this.xAG.sendEmptyMessageDelayed(this.xAB, paramInt);
    }
    AppMethodBeat.o(138718);
  }
  
  private final Animation getTipsFadeOut()
  {
    AppMethodBeat.i(138713);
    Animation localAnimation = (Animation)this.xAx.getValue();
    AppMethodBeat.o(138713);
    return localAnimation;
  }
  
  private final TextView getTvTextTips()
  {
    AppMethodBeat.i(138714);
    TextView localTextView = (TextView)this.xAy.getValue();
    AppMethodBeat.o(138714);
    return localTextView;
  }
  
  public final void awx(String paramString)
  {
    AppMethodBeat.i(138719);
    p.h(paramString, "msg");
    this.xAO = xAT;
    eP(paramString, 5000);
    AppMethodBeat.o(138719);
  }
  
  public final void dGJ()
  {
    AppMethodBeat.i(138720);
    this.xAH = false;
    this.xAO = xAQ;
    ae.d(TAG, "hidNoviceEducation");
    this.xAG.removeMessages(this.xAE);
    if ((getVisibility() == 0) && (getNoviceEducationTips().getVisibility() == 0))
    {
      getNoviceEducationTips().clearAnimation();
      if (getTextTipsContainer().getAnimation() == getTipsFadeOut()) {
        getTextTipsContainer().clearAnimation();
      }
      ae.d(TAG, "hideNoviceEducation real");
      getNoviceEducationTips().startAnimation(getTipsFadeOut());
    }
    AppMethodBeat.o(138720);
  }
  
  public final void dGK()
  {
    AppMethodBeat.i(138723);
    ae.d(TAG, "hideRadarTips");
    if ((getVisibility() == 0) && (getTextTipsContainer().getVisibility() == 0))
    {
      if (getNoviceEducationTips().getAnimation() == getTipsFadeOut()) {
        getNoviceEducationTips().clearAnimation();
      }
      getTextTipsContainer().clearAnimation();
      ae.d(TAG, "hideRadarTips real");
      this.xAO = xAQ;
      this.xAH = false;
      getTextTipsContainer().startAnimation(getTipsFadeOut());
    }
    AppMethodBeat.o(138723);
  }
  
  final LinearLayout getNoviceEducationTips()
  {
    AppMethodBeat.i(138716);
    LinearLayout localLinearLayout = (LinearLayout)this.xAA.getValue();
    AppMethodBeat.o(138716);
    return localLinearLayout;
  }
  
  final View getTextTipsContainer()
  {
    AppMethodBeat.i(138715);
    View localView = (View)this.xAz.getValue();
    AppMethodBeat.o(138715);
    return localView;
  }
  
  final Animation getTipsFadeIn()
  {
    AppMethodBeat.i(138712);
    Animation localAnimation = (Animation)this.xAw.getValue();
    AppMethodBeat.o(138712);
    return localAnimation;
  }
  
  public final void setNoMember(boolean paramBoolean)
  {
    AppMethodBeat.i(138721);
    this.xAI = paramBoolean;
    if (!this.xAI)
    {
      dGK();
      dGL();
      dGJ();
    }
    AppMethodBeat.o(138721);
  }
  
  public final void setPressingDown(boolean paramBoolean)
  {
    AppMethodBeat.i(138722);
    if (this.xAM != 0L)
    {
      this.xAO = xAQ;
      dGL();
      dGK();
      getTextTipsContainer().setVisibility(8);
      getNoviceEducationTips().setVisibility(8);
      setVisibility(8);
    }
    this.xAK = true;
    this.xAM = bu.HQ();
    this.xAN = paramBoolean;
    this.xAL += 1;
    AppMethodBeat.o(138722);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class b
    extends aq
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138703);
      p.h(paramMessage, "msg");
      this.xAV.setVisibility(8);
      AppMethodBeat.o(138703);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements a<Animation>
  {
    d(RadarTipsView paramRadarTipsView)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements a<Animation>
  {
    e(RadarTipsView paramRadarTipsView)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsFadeOut$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarTipsView.e parame) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138707);
        p.h(paramAnimation, "animation");
        if (!RadarTipsView.b(this.xAW.xAV)) {
          RadarTipsView.c(this.xAW.xAV).sendEmptyMessage(0);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class f
    extends aq
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
      if (i == RadarTipsView.d(this.xAV))
      {
        this.xAV.dGK();
        AppMethodBeat.o(138710);
        return;
      }
      if (i == RadarTipsView.e(this.xAV))
      {
        if ((RadarTipsView.f(this.xAV)) && (this.xAV.xAK))
        {
          RadarTipsView.a(this.xAV);
          AppMethodBeat.o(138710);
        }
      }
      else
      {
        if (i == RadarTipsView.g(this.xAV))
        {
          paramMessage = this.xAV;
          paramMessage.xAH = true;
          paramMessage.xAO = RadarTipsView.xAS;
          ae.d(RadarTipsView.TAG, "showNoviceEducation");
          paramMessage.xAJ = true;
          paramMessage.getTextTipsContainer().setVisibility(8);
          paramMessage.getTextTipsContainer().clearAnimation();
          paramMessage.setVisibility(0);
          paramMessage.getNoviceEducationTips().setVisibility(0);
          paramMessage.getNoviceEducationTips().startAnimation(paramMessage.getTipsFadeIn());
          paramMessage.getNoviceEducationTips().requestFocus();
          AppMethodBeat.o(138710);
          return;
        }
        if (i == RadarTipsView.h(this.xAV)) {
          this.xAV.dGJ();
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