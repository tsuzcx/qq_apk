package com.tencent.mm.plugin.radar.ui;

import a.f;
import a.f.a.a;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.g;
import a.j.k;
import a.l;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DelayShowNoviceEducationTips", "DelayShowSearchingTips", "HideNoviceEducationTips", "HideTips", "ShowNoMemberTips", "gone", "com/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$gone$1;", "<set-?>", "", "isPressing", "()Z", "setPressing", "(Z)V", "mCurrentTipsPurpose", "mDontHideFlag", "mHasShownNoviceEducation", "mNoMember", "mPressCount", "mPressForShow", "mPressStartAt", "", "mPressTooShortCount", "mStartWithClick", "noviceEducationTips", "Landroid/widget/LinearLayout;", "getNoviceEducationTips", "()Landroid/widget/LinearLayout;", "noviceEducationTips$delegate", "Lkotlin/Lazy;", "textTipsContainer", "Landroid/view/View;", "getTextTipsContainer", "()Landroid/view/View;", "textTipsContainer$delegate", "tipsFadeIn", "Landroid/view/animation/Animation;", "getTipsFadeIn", "()Landroid/view/animation/Animation;", "tipsFadeIn$delegate", "tipsFadeOut", "getTipsFadeOut", "tipsFadeOut$delegate", "tipsHandler", "com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1;", "tvTextTips", "Landroid/widget/TextView;", "getTvTextTips", "()Landroid/widget/TextView;", "tvTextTips$delegate", "hideAll", "", "hideNoviceEducation", "hideRadarTips", "init", "removeShowTipsMessages", "reset", "setNoMember", "noMember", "setPressingDown", "show", "setPressingUp", "showErrMsg", "msg", "", "showNoviceEducation", "showPressTooShortTips", "showRadarTips", "res", "during", "showSearchingTips", "Companion", "plugin-radar_release"})
public final class RadarTipsView
  extends RelativeLayout
{
  static final String TAG = "MicroMsg.RadarTipsView";
  private static final int pSA = 0;
  static final int pSB = 1;
  static final int pSC = 2;
  private static final int pSD = 3;
  public static final a pSE;
  private static final int pSz = 3;
  private final RadarTipsView.b pSf;
  private final f pSg;
  private final f pSh;
  private final f pSi;
  private final f pSj;
  private final f pSk;
  private final int pSl;
  final int pSm;
  final int pSn;
  private final int pSo;
  private final int pSp;
  final RadarTipsView.f pSq;
  boolean pSr;
  private boolean pSs;
  boolean pSt;
  boolean pSu;
  private int pSv;
  private long pSw;
  private boolean pSx;
  int pSy;
  
  static
  {
    AppMethodBeat.i(103061);
    eOJ = new k[] { (k)v.a(new t(v.aG(RadarTipsView.class), "tipsFadeIn", "getTipsFadeIn()Landroid/view/animation/Animation;")), (k)v.a(new t(v.aG(RadarTipsView.class), "tipsFadeOut", "getTipsFadeOut()Landroid/view/animation/Animation;")), (k)v.a(new t(v.aG(RadarTipsView.class), "tvTextTips", "getTvTextTips()Landroid/widget/TextView;")), (k)v.a(new t(v.aG(RadarTipsView.class), "textTipsContainer", "getTextTipsContainer()Landroid/view/View;")), (k)v.a(new t(v.aG(RadarTipsView.class), "noviceEducationTips", "getNoviceEducationTips()Landroid/widget/LinearLayout;")) };
    pSE = new a((byte)0);
    TAG = "MicroMsg.RadarTipsView";
    pSz = 3;
    pSB = 1;
    pSC = 2;
    pSD = 3;
    AppMethodBeat.o(103061);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103075);
    this.pSf = new RadarTipsView.b(this);
    this.pSg = g.j((a)new RadarTipsView.d(this));
    this.pSh = g.j((a)new RadarTipsView.e(this));
    this.pSi = i.ae(this, 2131826995);
    this.pSj = i.ae(this, 2131826994);
    this.pSk = i.ae(this, 2131826996);
    this.pSm = 1;
    this.pSn = 2;
    this.pSo = 3;
    this.pSp = 3;
    this.pSq = new RadarTipsView.f(this, Looper.getMainLooper());
    this.pSs = true;
    this.pSy = pSA;
    AppMethodBeat.o(103075);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(103076);
    this.pSf = new RadarTipsView.b(this);
    this.pSg = g.j((a)new RadarTipsView.d(this));
    this.pSh = g.j((a)new RadarTipsView.e(this));
    this.pSi = i.ae(this, 2131826995);
    this.pSj = i.ae(this, 2131826994);
    this.pSk = i.ae(this, 2131826996);
    this.pSm = 1;
    this.pSn = 2;
    this.pSo = 3;
    this.pSp = 3;
    this.pSq = new RadarTipsView.f(this, Looper.getMainLooper());
    this.pSs = true;
    this.pSy = pSA;
    AppMethodBeat.o(103076);
  }
  
  private void cfc()
  {
    AppMethodBeat.i(103074);
    this.pSr = false;
    RadarTipsView.f localf = this.pSq;
    localf.removeMessages(this.pSm);
    localf.removeMessages(this.pSn);
    localf.removeMessages(this.pSo);
    AppMethodBeat.o(103074);
  }
  
  private void dd(String paramString, int paramInt)
  {
    AppMethodBeat.i(103068);
    j.q(paramString, "msg");
    this.pSr = true;
    getNoviceEducationTips().setVisibility(8);
    getNoviceEducationTips().clearAnimation();
    getTvTextTips().setText((CharSequence)paramString);
    setVisibility(0);
    getTextTipsContainer().setVisibility(0);
    getTextTipsContainer().startAnimation(getTipsFadeIn());
    this.pSq.removeMessages(this.pSl);
    this.pSq.removeMessages(this.pSn);
    if (paramInt > 0) {
      this.pSq.sendEmptyMessageDelayed(this.pSl, paramInt);
    }
    AppMethodBeat.o(103068);
  }
  
  private final Animation getTipsFadeOut()
  {
    AppMethodBeat.i(103063);
    Animation localAnimation = (Animation)this.pSh.getValue();
    AppMethodBeat.o(103063);
    return localAnimation;
  }
  
  private final TextView getTvTextTips()
  {
    AppMethodBeat.i(103064);
    TextView localTextView = (TextView)this.pSi.getValue();
    AppMethodBeat.o(103064);
    return localTextView;
  }
  
  private final void setPressing(boolean paramBoolean)
  {
    this.pSu = paramBoolean;
  }
  
  public final void XJ(String paramString)
  {
    AppMethodBeat.i(103069);
    j.q(paramString, "msg");
    this.pSy = pSD;
    dd(paramString, 5000);
    AppMethodBeat.o(103069);
  }
  
  public final void cfa()
  {
    AppMethodBeat.i(103070);
    this.pSr = false;
    this.pSy = pSA;
    ab.d(TAG, "hidNoviceEducation");
    this.pSq.removeMessages(this.pSo);
    if ((getVisibility() == 0) && (getNoviceEducationTips().getVisibility() == 0))
    {
      getNoviceEducationTips().clearAnimation();
      if (getTextTipsContainer().getAnimation() == getTipsFadeOut()) {
        getTextTipsContainer().clearAnimation();
      }
      ab.d(TAG, "hideNoviceEducation real");
      getNoviceEducationTips().startAnimation(getTipsFadeOut());
    }
    AppMethodBeat.o(103070);
  }
  
  public final void cfb()
  {
    AppMethodBeat.i(103073);
    ab.d(TAG, "hideRadarTips");
    if ((getVisibility() == 0) && (getTextTipsContainer().getVisibility() == 0))
    {
      if (getNoviceEducationTips().getAnimation() == getTipsFadeOut()) {
        getNoviceEducationTips().clearAnimation();
      }
      getTextTipsContainer().clearAnimation();
      ab.d(TAG, "hideRadarTips real");
      this.pSy = pSA;
      this.pSr = false;
      getTextTipsContainer().startAnimation(getTipsFadeOut());
    }
    AppMethodBeat.o(103073);
  }
  
  final LinearLayout getNoviceEducationTips()
  {
    AppMethodBeat.i(103066);
    LinearLayout localLinearLayout = (LinearLayout)this.pSk.getValue();
    AppMethodBeat.o(103066);
    return localLinearLayout;
  }
  
  final View getTextTipsContainer()
  {
    AppMethodBeat.i(103065);
    View localView = (View)this.pSj.getValue();
    AppMethodBeat.o(103065);
    return localView;
  }
  
  final Animation getTipsFadeIn()
  {
    AppMethodBeat.i(103062);
    Animation localAnimation = (Animation)this.pSg.getValue();
    AppMethodBeat.o(103062);
    return localAnimation;
  }
  
  public final void setNoMember(boolean paramBoolean)
  {
    AppMethodBeat.i(103071);
    this.pSs = paramBoolean;
    if (!this.pSs)
    {
      cfb();
      cfc();
      cfa();
    }
    AppMethodBeat.o(103071);
  }
  
  public final void setPressingDown(boolean paramBoolean)
  {
    AppMethodBeat.i(103072);
    if (this.pSw != 0L)
    {
      this.pSy = pSA;
      cfc();
      cfb();
      getTextTipsContainer().setVisibility(8);
      getNoviceEducationTips().setVisibility(8);
      setVisibility(8);
    }
    this.pSu = true;
    this.pSw = bo.yB();
    this.pSx = paramBoolean;
    this.pSv += 1;
    AppMethodBeat.o(103072);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarTipsView$Companion;", "", "()V", "PressTooShortCountThreshold", "", "TAG", "", "TIPS_PURPOSE_ERROR_MESSAGE", "TIPS_PURPOSE_NORMAL", "TIPS_PURPOSE_NOVICE_EDUCATION", "TIPS_PURPOSE_SHEARING", "plugin-radar_release"})
  public static final class a {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(RadarTipsView paramRadarTipsView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(103054);
      ab.d(RadarTipsView.access$getTAG$cp(), "noviceEducationTips onclick");
      this.pSF.cfa();
      AppMethodBeat.o(103054);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarTipsView
 * JD-Core Version:    0.7.0.1
 */