package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.voip.ui.k;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "bgView", "contentView", "context", "Landroid/content/Context;", "mainIconLayout", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "radius", "", "getRootView", "()Landroid/view/View;", "setRootView", "timeTv", "Landroid/widget/TextView;", "tipTv", "value", "", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "doAnimationHide", "", "doAnimationShow", "onHangupHappened", "onResumeIconAndTipShow", "refreshLayoutCauseDockChanged", "isDockerLeft", "", "refreshMiniView", "release", "setVoicePlayDevice", "device", "updateText", "text", "", "updateTime", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  View AhP;
  WeImageView Lvd;
  Integer Lve;
  View contentView;
  Context context;
  TextView pls;
  private final float radius;
  View rootView;
  TextView timeTv;
  
  public j(View paramView)
  {
    AppMethodBeat.i(285407);
    this.rootView = paramView;
    this.radius = a.fromDPToPix(MMApplicationContext.getContext(), 12);
    this.contentView = this.rootView.findViewById(a.e.multitalk_content_view);
    paramView = this.contentView;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.contentView;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new k(this.radius));
    }
    this.AhP = this.rootView.findViewById(a.e.widget_bg);
    paramView = this.AhP;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.AhP;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new k(this.radius));
    }
    this.timeTv = ((TextView)this.rootView.findViewById(a.e.multitalk_voice_mini_time_tv));
    this.pls = ((TextView)this.rootView.findViewById(a.e.multitalk_voice_mini_tip_tv));
    this.context = this.rootView.getContext();
    this.Lvd = ((WeImageView)this.rootView.findViewById(a.e.multitalk_main_status_icon_iv));
    paramView = this.Lvd;
    if (paramView != null) {
      paramView.setBackground(bb.m(this.context, a.g.icons_filled_call, Color.parseColor("#07C160")));
    }
    paramView = this.Lvd;
    if (paramView != null) {
      paramView.setIconColor(Color.parseColor("#07C160"));
    }
    paramView = this.Lvd;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    AppMethodBeat.o(285407);
  }
  
  public final Integer ght()
  {
    AppMethodBeat.i(285414);
    int i = this.rootView.getVisibility();
    AppMethodBeat.o(285414);
    return Integer.valueOf(i);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView$doAnimationHide$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Animator.AnimatorListener
  {
    a(j paramj) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(285577);
      this.Lvf.rootView.setVisibility(4);
      AppMethodBeat.o(285577);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView$doAnimationShow$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    b(j paramj) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(285582);
      this.Lvf.rootView.setAlpha(1.0F);
      AppMethodBeat.o(285582);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.j
 * JD-Core Version:    0.7.0.1
 */