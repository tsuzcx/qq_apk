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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DelayShowNoviceEducationTips", "DelayShowSearchingTips", "HideNoviceEducationTips", "HideTips", "ShowNoMemberTips", "gone", "com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1;", "<set-?>", "", "isPressing", "()Z", "mCurrentTipsPurpose", "mDontHideFlag", "mHasShownNoviceEducation", "mNoMember", "mPressCount", "mPressForShow", "mPressStartAt", "", "mPressTooShortCount", "mStartWithClick", "noviceEducationTips", "Landroid/widget/LinearLayout;", "getNoviceEducationTips", "()Landroid/widget/LinearLayout;", "noviceEducationTips$delegate", "Lkotlin/Lazy;", "textTipsContainer", "Landroid/view/View;", "getTextTipsContainer", "()Landroid/view/View;", "textTipsContainer$delegate", "tipsFadeIn", "Landroid/view/animation/Animation;", "getTipsFadeIn", "()Landroid/view/animation/Animation;", "tipsFadeIn$delegate", "tipsFadeOut", "getTipsFadeOut", "tipsFadeOut$delegate", "tipsHandler", "com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1;", "tvTextTips", "Landroid/widget/TextView;", "getTvTextTips", "()Landroid/widget/TextView;", "tvTextTips$delegate", "hideAll", "", "hideNoviceEducation", "hideRadarTips", "init", "removeShowTipsMessages", "reset", "setNoMember", "noMember", "setPressingDown", "show", "setPressingUp", "showErrMsg", "msg", "", "showNoviceEducation", "showPressTooShortTips", "showRadarTips", "res", "during", "showSearchingTips", "Companion", "plugin-radar_release"})
public final class RadarTipsView
  extends RelativeLayout
{
  private static final int BAQ = 3;
  private static final int BAR = 0;
  static final int BAS = 1;
  static final int BAT = 2;
  private static final int BAU = 3;
  public static final RadarTipsView.a BAV;
  static final String TAG = "MicroMsg.RadarTipsView";
  private final f BAA;
  private final f BAB;
  private final int BAC;
  final int BAD;
  final int BAE;
  private final int BAF;
  private final int BAG;
  final f BAH;
  boolean BAI;
  private boolean BAJ;
  boolean BAK;
  boolean BAL;
  private int BAM;
  private long BAN;
  private boolean BAO;
  int BAP;
  private final b BAw;
  private final f BAx;
  private final f BAy;
  private final f BAz;
  
  static
  {
    AppMethodBeat.i(138711);
    BAV = new RadarTipsView.a((byte)0);
    TAG = "MicroMsg.RadarTipsView";
    BAQ = 3;
    BAS = 1;
    BAT = 2;
    BAU = 3;
    AppMethodBeat.o(138711);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138725);
    this.BAw = new b(this);
    this.BAx = g.ah((kotlin.g.a.a)new d(this));
    this.BAy = g.ah((kotlin.g.a.a)new e(this));
    this.BAz = i.aq(this, 2131306480);
    this.BAA = i.aq(this, 2131306478);
    this.BAB = i.aq(this, 2131306481);
    this.BAD = 1;
    this.BAE = 2;
    this.BAF = 3;
    this.BAG = 3;
    this.BAH = new f(this, Looper.getMainLooper());
    this.BAJ = true;
    this.BAP = BAR;
    AppMethodBeat.o(138725);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138726);
    this.BAw = new b(this);
    this.BAx = g.ah((kotlin.g.a.a)new d(this));
    this.BAy = g.ah((kotlin.g.a.a)new e(this));
    this.BAz = i.aq(this, 2131306480);
    this.BAA = i.aq(this, 2131306478);
    this.BAB = i.aq(this, 2131306481);
    this.BAD = 1;
    this.BAE = 2;
    this.BAF = 3;
    this.BAG = 3;
    this.BAH = new f(this, Looper.getMainLooper());
    this.BAJ = true;
    this.BAP = BAR;
    AppMethodBeat.o(138726);
  }
  
  private void eHz()
  {
    AppMethodBeat.i(138724);
    this.BAI = false;
    f localf = this.BAH;
    localf.removeMessages(this.BAD);
    localf.removeMessages(this.BAE);
    localf.removeMessages(this.BAF);
    AppMethodBeat.o(138724);
  }
  
  private void fh(String paramString, int paramInt)
  {
    AppMethodBeat.i(138718);
    p.h(paramString, "msg");
    this.BAI = true;
    getNoviceEducationTips().setVisibility(8);
    getNoviceEducationTips().clearAnimation();
    getTvTextTips().setText((CharSequence)paramString);
    setVisibility(0);
    getTextTipsContainer().setVisibility(0);
    getTextTipsContainer().startAnimation(getTipsFadeIn());
    this.BAH.removeMessages(this.BAC);
    this.BAH.removeMessages(this.BAE);
    if (paramInt > 0) {
      this.BAH.sendEmptyMessageDelayed(this.BAC, paramInt);
    }
    AppMethodBeat.o(138718);
  }
  
  private final Animation getTipsFadeOut()
  {
    AppMethodBeat.i(138713);
    Animation localAnimation = (Animation)this.BAy.getValue();
    AppMethodBeat.o(138713);
    return localAnimation;
  }
  
  private final TextView getTvTextTips()
  {
    AppMethodBeat.i(138714);
    TextView localTextView = (TextView)this.BAz.getValue();
    AppMethodBeat.o(138714);
    return localTextView;
  }
  
  public final void aKP(String paramString)
  {
    AppMethodBeat.i(138719);
    p.h(paramString, "msg");
    this.BAP = BAU;
    fh(paramString, 5000);
    AppMethodBeat.o(138719);
  }
  
  public final void eHx()
  {
    AppMethodBeat.i(138720);
    this.BAI = false;
    this.BAP = BAR;
    Log.d(TAG, "hidNoviceEducation");
    this.BAH.removeMessages(this.BAF);
    if ((getVisibility() == 0) && (getNoviceEducationTips().getVisibility() == 0))
    {
      getNoviceEducationTips().clearAnimation();
      if (getTextTipsContainer().getAnimation() == getTipsFadeOut()) {
        getTextTipsContainer().clearAnimation();
      }
      Log.d(TAG, "hideNoviceEducation real");
      getNoviceEducationTips().startAnimation(getTipsFadeOut());
    }
    AppMethodBeat.o(138720);
  }
  
  public final void eHy()
  {
    AppMethodBeat.i(138723);
    Log.d(TAG, "hideRadarTips");
    if ((getVisibility() == 0) && (getTextTipsContainer().getVisibility() == 0))
    {
      if (getNoviceEducationTips().getAnimation() == getTipsFadeOut()) {
        getNoviceEducationTips().clearAnimation();
      }
      getTextTipsContainer().clearAnimation();
      Log.d(TAG, "hideRadarTips real");
      this.BAP = BAR;
      this.BAI = false;
      getTextTipsContainer().startAnimation(getTipsFadeOut());
    }
    AppMethodBeat.o(138723);
  }
  
  final LinearLayout getNoviceEducationTips()
  {
    AppMethodBeat.i(138716);
    LinearLayout localLinearLayout = (LinearLayout)this.BAB.getValue();
    AppMethodBeat.o(138716);
    return localLinearLayout;
  }
  
  final View getTextTipsContainer()
  {
    AppMethodBeat.i(138715);
    View localView = (View)this.BAA.getValue();
    AppMethodBeat.o(138715);
    return localView;
  }
  
  final Animation getTipsFadeIn()
  {
    AppMethodBeat.i(138712);
    Animation localAnimation = (Animation)this.BAx.getValue();
    AppMethodBeat.o(138712);
    return localAnimation;
  }
  
  public final void setNoMember(boolean paramBoolean)
  {
    AppMethodBeat.i(138721);
    this.BAJ = paramBoolean;
    if (!this.BAJ)
    {
      eHy();
      eHz();
      eHx();
    }
    AppMethodBeat.o(138721);
  }
  
  public final void setPressingDown(boolean paramBoolean)
  {
    AppMethodBeat.i(138722);
    if (this.BAN != 0L)
    {
      this.BAP = BAR;
      eHz();
      eHy();
      getTextTipsContainer().setVisibility(8);
      getNoviceEducationTips().setVisibility(8);
      setVisibility(8);
    }
    this.BAL = true;
    this.BAN = Util.currentTicks();
    this.BAO = paramBoolean;
    this.BAM += 1;
    AppMethodBeat.o(138722);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class b
    extends MMHandler
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138703);
      p.h(paramMessage, "msg");
      this.BAW.setVisibility(8);
      AppMethodBeat.o(138703);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(RadarTipsView paramRadarTipsView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138704);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/radar/ui/RadarTipsView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.d(RadarTipsView.access$getTAG$cp(), "noviceEducationTips onclick");
      this.BAW.eHx();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/radar/ui/RadarTipsView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(138704);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Animation>
  {
    d(RadarTipsView paramRadarTipsView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<Animation>
  {
    e(RadarTipsView paramRadarTipsView)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsFadeOut$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarTipsView.e parame) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138707);
        p.h(paramAnimation, "animation");
        if (!RadarTipsView.b(this.BAX.BAW)) {
          RadarTipsView.c(this.BAX.BAW).sendEmptyMessage(0);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class f
    extends MMHandler
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
      if (i == RadarTipsView.d(this.BAW))
      {
        this.BAW.eHy();
        AppMethodBeat.o(138710);
        return;
      }
      if (i == RadarTipsView.e(this.BAW))
      {
        if ((RadarTipsView.f(this.BAW)) && (this.BAW.BAL))
        {
          RadarTipsView.a(this.BAW);
          AppMethodBeat.o(138710);
        }
      }
      else
      {
        if (i == RadarTipsView.g(this.BAW))
        {
          paramMessage = this.BAW;
          paramMessage.BAI = true;
          paramMessage.BAP = RadarTipsView.BAT;
          Log.d(RadarTipsView.TAG, "showNoviceEducation");
          paramMessage.BAK = true;
          paramMessage.getTextTipsContainer().setVisibility(8);
          paramMessage.getTextTipsContainer().clearAnimation();
          paramMessage.setVisibility(0);
          paramMessage.getNoviceEducationTips().setVisibility(0);
          paramMessage.getNoviceEducationTips().startAnimation(paramMessage.getTipsFadeIn());
          paramMessage.getNoviceEducationTips().requestFocus();
          AppMethodBeat.o(138710);
          return;
        }
        if (i == RadarTipsView.h(this.BAW)) {
          this.BAW.eHx();
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