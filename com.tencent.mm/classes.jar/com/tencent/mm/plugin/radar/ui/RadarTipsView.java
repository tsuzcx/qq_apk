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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.radar.a.d;
import com.tencent.mm.plugin.radar.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DelayShowNoviceEducationTips", "DelayShowSearchingTips", "HideNoviceEducationTips", "HideTips", "ShowNoMemberTips", "gone", "com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1;", "<set-?>", "", "isPressing", "()Z", "mCurrentTipsPurpose", "mDontHideFlag", "mHasShownNoviceEducation", "mNoMember", "mPressCount", "mPressForShow", "mPressStartAt", "", "mPressTooShortCount", "mStartWithClick", "noviceEducationTips", "Landroid/widget/LinearLayout;", "getNoviceEducationTips", "()Landroid/widget/LinearLayout;", "noviceEducationTips$delegate", "Lkotlin/Lazy;", "textTipsContainer", "Landroid/view/View;", "getTextTipsContainer", "()Landroid/view/View;", "textTipsContainer$delegate", "tipsFadeIn", "Landroid/view/animation/Animation;", "getTipsFadeIn", "()Landroid/view/animation/Animation;", "tipsFadeIn$delegate", "tipsFadeOut", "getTipsFadeOut", "tipsFadeOut$delegate", "tipsHandler", "com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1;", "tvTextTips", "Landroid/widget/TextView;", "getTvTextTips", "()Landroid/widget/TextView;", "tvTextTips$delegate", "hideAll", "", "hideNoviceEducation", "hideRadarTips", "init", "removeShowTipsMessages", "reset", "setNoMember", "noMember", "setPressingDown", "show", "setPressingUp", "showErrMsg", "msg", "", "showNoviceEducation", "showPressTooShortTips", "showRadarTips", "res", "during", "showSearchingTips", "Companion", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RadarTipsView
  extends RelativeLayout
{
  private static final int NtU;
  private static final int NtV = 0;
  static final int NtW;
  static final int NtX;
  private static final int NtY;
  public static final RadarTipsView.a Ntz;
  static final String TAG;
  private final b NtA;
  private final j NtB;
  private final j NtC;
  private final j NtD;
  private final j NtE;
  private final j NtF;
  private final int NtG;
  final int NtH;
  final int NtI;
  private final int NtJ;
  private final int NtK;
  final e NtL;
  boolean NtM;
  private boolean NtN;
  boolean NtO;
  boolean NtP;
  private int NtQ;
  private long NtR;
  private boolean NtS;
  int NtT;
  
  static
  {
    AppMethodBeat.i(138711);
    Ntz = new RadarTipsView.a((byte)0);
    TAG = "MicroMsg.RadarTipsView";
    NtU = 3;
    NtW = 1;
    NtX = 2;
    NtY = 3;
    AppMethodBeat.o(138711);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138725);
    this.NtA = new b(this);
    this.NtB = k.cm((kotlin.g.a.a)new c(this));
    this.NtC = k.cm((kotlin.g.a.a)new d(this));
    this.NtD = e.aM((View)this, a.d.NqT);
    this.NtE = e.aM((View)this, a.d.NqR);
    this.NtF = e.aM((View)this, a.d.NqU);
    this.NtH = 1;
    this.NtI = 2;
    this.NtJ = 3;
    this.NtK = 3;
    this.NtL = new e(this, Looper.getMainLooper());
    this.NtN = true;
    this.NtT = NtV;
    AppMethodBeat.o(138725);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138726);
    this.NtA = new b(this);
    this.NtB = k.cm((kotlin.g.a.a)new c(this));
    this.NtC = k.cm((kotlin.g.a.a)new d(this));
    this.NtD = e.aM((View)this, a.d.NqT);
    this.NtE = e.aM((View)this, a.d.NqR);
    this.NtF = e.aM((View)this, a.d.NqU);
    this.NtH = 1;
    this.NtI = 2;
    this.NtJ = 3;
    this.NtK = 3;
    this.NtL = new e(this, Looper.getMainLooper());
    this.NtN = true;
    this.NtT = NtV;
    AppMethodBeat.o(138726);
  }
  
  private static final void a(RadarTipsView paramRadarTipsView, View paramView)
  {
    AppMethodBeat.i(267257);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRadarTipsView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/radar/ui/RadarTipsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRadarTipsView, "this$0");
    Log.d(TAG, "noviceEducationTips onclick");
    paramRadarTipsView.gFo();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/radar/ui/RadarTipsView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267257);
  }
  
  private void gB(String paramString, int paramInt)
  {
    AppMethodBeat.i(138718);
    s.u(paramString, "msg");
    this.NtM = true;
    getNoviceEducationTips().setVisibility(8);
    getNoviceEducationTips().clearAnimation();
    getTvTextTips().setText((CharSequence)paramString);
    setVisibility(0);
    getTextTipsContainer().setVisibility(0);
    getTextTipsContainer().startAnimation(getTipsFadeIn());
    this.NtL.removeMessages(this.NtG);
    this.NtL.removeMessages(this.NtI);
    if (paramInt > 0) {
      this.NtL.sendEmptyMessageDelayed(this.NtG, paramInt);
    }
    AppMethodBeat.o(138718);
  }
  
  private void gFq()
  {
    AppMethodBeat.i(138724);
    this.NtM = false;
    e locale = this.NtL;
    locale.removeMessages(this.NtH);
    locale.removeMessages(this.NtI);
    locale.removeMessages(this.NtJ);
    AppMethodBeat.o(138724);
  }
  
  private final Animation getTipsFadeOut()
  {
    AppMethodBeat.i(138713);
    Object localObject = this.NtC.getValue();
    s.s(localObject, "<get-tipsFadeOut>(...)");
    localObject = (Animation)localObject;
    AppMethodBeat.o(138713);
    return localObject;
  }
  
  private final TextView getTvTextTips()
  {
    AppMethodBeat.i(138714);
    TextView localTextView = (TextView)this.NtD.getValue();
    AppMethodBeat.o(138714);
    return localTextView;
  }
  
  public final void aSy(String paramString)
  {
    AppMethodBeat.i(138719);
    s.u(paramString, "msg");
    this.NtT = NtY;
    gB(paramString, 5000);
    AppMethodBeat.o(138719);
  }
  
  public final void gFo()
  {
    AppMethodBeat.i(138720);
    this.NtM = false;
    this.NtT = NtV;
    Log.d(TAG, "hidNoviceEducation");
    this.NtL.removeMessages(this.NtJ);
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
  
  public final void gFp()
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
      this.NtT = NtV;
      this.NtM = false;
      getTextTipsContainer().startAnimation(getTipsFadeOut());
    }
    AppMethodBeat.o(138723);
  }
  
  final LinearLayout getNoviceEducationTips()
  {
    AppMethodBeat.i(138716);
    LinearLayout localLinearLayout = (LinearLayout)this.NtF.getValue();
    AppMethodBeat.o(138716);
    return localLinearLayout;
  }
  
  final View getTextTipsContainer()
  {
    AppMethodBeat.i(138715);
    View localView = (View)this.NtE.getValue();
    AppMethodBeat.o(138715);
    return localView;
  }
  
  final Animation getTipsFadeIn()
  {
    AppMethodBeat.i(138712);
    Object localObject = this.NtB.getValue();
    s.s(localObject, "<get-tipsFadeIn>(...)");
    localObject = (Animation)localObject;
    AppMethodBeat.o(138712);
    return localObject;
  }
  
  public final void init()
  {
    AppMethodBeat.i(267272);
    getNoviceEducationTips().setOnClickListener(new RadarTipsView..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(267272);
  }
  
  public final void setNoMember(boolean paramBoolean)
  {
    AppMethodBeat.i(138721);
    this.NtN = paramBoolean;
    if (!this.NtN)
    {
      gFp();
      gFq();
      gFo();
    }
    AppMethodBeat.o(138721);
  }
  
  public final void setPressingDown(boolean paramBoolean)
  {
    AppMethodBeat.i(138722);
    if (this.NtR != 0L)
    {
      this.NtT = NtV;
      gFq();
      gFp();
      getTextTipsContainer().setVisibility(8);
      getNoviceEducationTips().setVisibility(8);
      setVisibility(8);
    }
    this.NtP = true;
    this.NtR = Util.currentTicks();
    this.NtS = paramBoolean;
    this.NtQ += 1;
    AppMethodBeat.o(138722);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends MMHandler
  {
    b(RadarTipsView paramRadarTipsView) {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138703);
      s.u(paramMessage, "msg");
      this.NtZ.setVisibility(8);
      AppMethodBeat.o(138703);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Animation>
  {
    c(RadarTipsView paramRadarTipsView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Animation>
  {
    d(RadarTipsView paramRadarTipsView)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsFadeOut$2$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Animation.AnimationListener
    {
      a(RadarTipsView paramRadarTipsView) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(267251);
        s.u(paramAnimation, "animation");
        if (!RadarTipsView.a(this.NtZ)) {
          RadarTipsView.b(this.NtZ).sendEmptyMessage(0);
        }
        AppMethodBeat.o(267251);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(267254);
        s.u(paramAnimation, "animation");
        AppMethodBeat.o(267254);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(267248);
        s.u(paramAnimation, "animation");
        AppMethodBeat.o(267248);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends MMHandler
  {
    e(RadarTipsView paramRadarTipsView, Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(138710);
      s.u(paramMessage, "msg");
      int i = paramMessage.what;
      if (i == RadarTipsView.c(this.NtZ))
      {
        this.NtZ.gFp();
        AppMethodBeat.o(138710);
        return;
      }
      if (i == RadarTipsView.d(this.NtZ))
      {
        if ((RadarTipsView.e(this.NtZ)) && (this.NtZ.NtP))
        {
          RadarTipsView.a(this.NtZ, a.g.Nrl);
          AppMethodBeat.o(138710);
        }
      }
      else
      {
        if (i == RadarTipsView.f(this.NtZ))
        {
          paramMessage = this.NtZ;
          paramMessage.NtM = true;
          paramMessage.NtT = RadarTipsView.NtX;
          Log.d(RadarTipsView.TAG, "showNoviceEducation");
          paramMessage.NtO = true;
          paramMessage.getTextTipsContainer().setVisibility(8);
          paramMessage.getTextTipsContainer().clearAnimation();
          paramMessage.setVisibility(0);
          paramMessage.getNoviceEducationTips().setVisibility(0);
          paramMessage.getNoviceEducationTips().startAnimation(paramMessage.getTipsFadeIn());
          paramMessage.getNoviceEducationTips().requestFocus();
          AppMethodBeat.o(138710);
          return;
        }
        if (i == RadarTipsView.g(this.NtZ)) {
          this.NtZ.gFo();
        }
      }
      AppMethodBeat.o(138710);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarTipsView
 * JD-Core Version:    0.7.0.1
 */