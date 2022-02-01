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
import com.tencent.mm.plugin.radar.a.d;
import com.tencent.mm.plugin.radar.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DelayShowNoviceEducationTips", "DelayShowSearchingTips", "HideNoviceEducationTips", "HideTips", "ShowNoMemberTips", "gone", "com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1;", "<set-?>", "", "isPressing", "()Z", "mCurrentTipsPurpose", "mDontHideFlag", "mHasShownNoviceEducation", "mNoMember", "mPressCount", "mPressForShow", "mPressStartAt", "", "mPressTooShortCount", "mStartWithClick", "noviceEducationTips", "Landroid/widget/LinearLayout;", "getNoviceEducationTips", "()Landroid/widget/LinearLayout;", "noviceEducationTips$delegate", "Lkotlin/Lazy;", "textTipsContainer", "Landroid/view/View;", "getTextTipsContainer", "()Landroid/view/View;", "textTipsContainer$delegate", "tipsFadeIn", "Landroid/view/animation/Animation;", "getTipsFadeIn", "()Landroid/view/animation/Animation;", "tipsFadeIn$delegate", "tipsFadeOut", "getTipsFadeOut", "tipsFadeOut$delegate", "tipsHandler", "com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1;", "tvTextTips", "Landroid/widget/TextView;", "getTvTextTips", "()Landroid/widget/TextView;", "tvTextTips$delegate", "hideAll", "", "hideNoviceEducation", "hideRadarTips", "init", "removeShowTipsMessages", "reset", "setNoMember", "noMember", "setPressingDown", "show", "setPressingUp", "showErrMsg", "msg", "", "showNoviceEducation", "showPressTooShortTips", "showRadarTips", "res", "during", "showSearchingTips", "Companion", "plugin-radar_release"})
public final class RadarTipsView
  extends RelativeLayout
{
  private static final int Hwl = 3;
  private static final int Hwm = 0;
  static final int Hwn = 1;
  static final int Hwo = 2;
  private static final int Hwp = 3;
  public static final RadarTipsView.a Hwq;
  static final String TAG = "MicroMsg.RadarTipsView";
  private final b HvR;
  private final f HvS;
  private final f HvT;
  private final f HvU;
  private final f HvV;
  private final f HvW;
  private final int HvX;
  final int HvY;
  final int HvZ;
  private final int Hwa;
  private final int Hwb;
  final f Hwc;
  boolean Hwd;
  private boolean Hwe;
  boolean Hwf;
  boolean Hwg;
  private int Hwh;
  private long Hwi;
  private boolean Hwj;
  int Hwk;
  
  static
  {
    AppMethodBeat.i(138711);
    Hwq = new RadarTipsView.a((byte)0);
    TAG = "MicroMsg.RadarTipsView";
    Hwl = 3;
    Hwn = 1;
    Hwo = 2;
    Hwp = 3;
    AppMethodBeat.o(138711);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138725);
    this.HvR = new b(this);
    this.HvS = g.ar((kotlin.g.a.a)new d(this));
    this.HvT = g.ar((kotlin.g.a.a)new e(this));
    this.HvU = i.au(this, a.d.Hte);
    this.HvV = i.au(this, a.d.Htc);
    this.HvW = i.au(this, a.d.Htf);
    this.HvY = 1;
    this.HvZ = 2;
    this.Hwa = 3;
    this.Hwb = 3;
    this.Hwc = new f(this, Looper.getMainLooper());
    this.Hwe = true;
    this.Hwk = Hwm;
    AppMethodBeat.o(138725);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138726);
    this.HvR = new b(this);
    this.HvS = g.ar((kotlin.g.a.a)new d(this));
    this.HvT = g.ar((kotlin.g.a.a)new e(this));
    this.HvU = i.au(this, a.d.Hte);
    this.HvV = i.au(this, a.d.Htc);
    this.HvW = i.au(this, a.d.Htf);
    this.HvY = 1;
    this.HvZ = 2;
    this.Hwa = 3;
    this.Hwb = 3;
    this.Hwc = new f(this, Looper.getMainLooper());
    this.Hwe = true;
    this.Hwk = Hwm;
    AppMethodBeat.o(138726);
  }
  
  private void fJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(138718);
    p.k(paramString, "msg");
    this.Hwd = true;
    getNoviceEducationTips().setVisibility(8);
    getNoviceEducationTips().clearAnimation();
    getTvTextTips().setText((CharSequence)paramString);
    setVisibility(0);
    getTextTipsContainer().setVisibility(0);
    getTextTipsContainer().startAnimation(getTipsFadeIn());
    this.Hwc.removeMessages(this.HvX);
    this.Hwc.removeMessages(this.HvZ);
    if (paramInt > 0) {
      this.Hwc.sendEmptyMessageDelayed(this.HvX, paramInt);
    }
    AppMethodBeat.o(138718);
  }
  
  private void ftD()
  {
    AppMethodBeat.i(138724);
    this.Hwd = false;
    f localf = this.Hwc;
    localf.removeMessages(this.HvY);
    localf.removeMessages(this.HvZ);
    localf.removeMessages(this.Hwa);
    AppMethodBeat.o(138724);
  }
  
  private final Animation getTipsFadeOut()
  {
    AppMethodBeat.i(138713);
    Animation localAnimation = (Animation)this.HvT.getValue();
    AppMethodBeat.o(138713);
    return localAnimation;
  }
  
  private final TextView getTvTextTips()
  {
    AppMethodBeat.i(138714);
    TextView localTextView = (TextView)this.HvU.getValue();
    AppMethodBeat.o(138714);
    return localTextView;
  }
  
  public final void aVq(String paramString)
  {
    AppMethodBeat.i(138719);
    p.k(paramString, "msg");
    this.Hwk = Hwp;
    fJ(paramString, 5000);
    AppMethodBeat.o(138719);
  }
  
  public final void ftB()
  {
    AppMethodBeat.i(138720);
    this.Hwd = false;
    this.Hwk = Hwm;
    Log.d(TAG, "hidNoviceEducation");
    this.Hwc.removeMessages(this.Hwa);
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
  
  public final void ftC()
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
      this.Hwk = Hwm;
      this.Hwd = false;
      getTextTipsContainer().startAnimation(getTipsFadeOut());
    }
    AppMethodBeat.o(138723);
  }
  
  final LinearLayout getNoviceEducationTips()
  {
    AppMethodBeat.i(138716);
    LinearLayout localLinearLayout = (LinearLayout)this.HvW.getValue();
    AppMethodBeat.o(138716);
    return localLinearLayout;
  }
  
  final View getTextTipsContainer()
  {
    AppMethodBeat.i(138715);
    View localView = (View)this.HvV.getValue();
    AppMethodBeat.o(138715);
    return localView;
  }
  
  final Animation getTipsFadeIn()
  {
    AppMethodBeat.i(138712);
    Animation localAnimation = (Animation)this.HvS.getValue();
    AppMethodBeat.o(138712);
    return localAnimation;
  }
  
  public final void setNoMember(boolean paramBoolean)
  {
    AppMethodBeat.i(138721);
    this.Hwe = paramBoolean;
    if (!this.Hwe)
    {
      ftC();
      ftD();
      ftB();
    }
    AppMethodBeat.o(138721);
  }
  
  public final void setPressingDown(boolean paramBoolean)
  {
    AppMethodBeat.i(138722);
    if (this.Hwi != 0L)
    {
      this.Hwk = Hwm;
      ftD();
      ftC();
      getTextTipsContainer().setVisibility(8);
      getNoviceEducationTips().setVisibility(8);
      setVisibility(8);
    }
    this.Hwg = true;
    this.Hwi = Util.currentTicks();
    this.Hwj = paramBoolean;
    this.Hwh += 1;
    AppMethodBeat.o(138722);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
  public static final class b
    extends MMHandler
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138703);
      p.k(paramMessage, "msg");
      this.Hwr.setVisibility(8);
      AppMethodBeat.o(138703);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(RadarTipsView paramRadarTipsView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138704);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/radar/ui/RadarTipsView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.d(RadarTipsView.access$getTAG$cp(), "noviceEducationTips onclick");
      this.Hwr.ftB();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/radar/ui/RadarTipsView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(138704);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Animation>
  {
    d(RadarTipsView paramRadarTipsView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<Animation>
  {
    e(RadarTipsView paramRadarTipsView)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsFadeOut$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarTipsView.e parame) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(138707);
        p.k(paramAnimation, "animation");
        if (!RadarTipsView.a(this.Hws.Hwr)) {
          RadarTipsView.b(this.Hws.Hwr).sendEmptyMessage(0);
        }
        AppMethodBeat.o(138707);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(138708);
        p.k(paramAnimation, "animation");
        AppMethodBeat.o(138708);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(138706);
        p.k(paramAnimation, "animation");
        AppMethodBeat.o(138706);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
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
      p.k(paramMessage, "msg");
      int i = paramMessage.what;
      if (i == RadarTipsView.c(this.Hwr))
      {
        this.Hwr.ftC();
        AppMethodBeat.o(138710);
        return;
      }
      if (i == RadarTipsView.d(this.Hwr))
      {
        if ((RadarTipsView.e(this.Hwr)) && (this.Hwr.Hwg))
        {
          RadarTipsView.a(this.Hwr, a.g.Htv);
          AppMethodBeat.o(138710);
        }
      }
      else
      {
        if (i == RadarTipsView.f(this.Hwr))
        {
          paramMessage = this.Hwr;
          paramMessage.Hwd = true;
          paramMessage.Hwk = RadarTipsView.Hwo;
          Log.d(RadarTipsView.TAG, "showNoviceEducation");
          paramMessage.Hwf = true;
          paramMessage.getTextTipsContainer().setVisibility(8);
          paramMessage.getTextTipsContainer().clearAnimation();
          paramMessage.setVisibility(0);
          paramMessage.getNoviceEducationTips().setVisibility(0);
          paramMessage.getNoviceEducationTips().startAnimation(paramMessage.getTipsFadeIn());
          paramMessage.getNoviceEducationTips().requestFocus();
          AppMethodBeat.o(138710);
          return;
        }
        if (i == RadarTipsView.g(this.Hwr)) {
          this.Hwr.ftB();
        }
      }
      AppMethodBeat.o(138710);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarTipsView
 * JD-Core Version:    0.7.0.1
 */