package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "bgView", "contentView", "context", "Landroid/content/Context;", "mainIconLayout", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "radius", "", "getRootView", "()Landroid/view/View;", "setRootView", "timeTv", "Landroid/widget/TextView;", "tipTv", "value", "", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "doAnimationHide", "", "doAnimationShow", "onHangupHappened", "onResumeIconAndTipShow", "refreshLayoutCauseDockChanged", "isDockerLeft", "", "refreshMiniView", "release", "setVoicePlayDevice", "device", "updateText", "text", "", "updateTime", "plugin-multitalk_release"})
public final class j
{
  WeImageView FyV;
  Integer FyW;
  View cCj;
  View contentView;
  Context context;
  TextView mrN;
  View oFW;
  private final float radius;
  TextView timeTv;
  
  public j(View paramView)
  {
    AppMethodBeat.i(197549);
    this.oFW = paramView;
    this.radius = a.fromDPToPix(MMApplicationContext.getContext(), 12);
    this.contentView = this.oFW.findViewById(a.e.multitalk_content_view);
    paramView = this.contentView;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.contentView;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    this.cCj = this.oFW.findViewById(a.e.widget_bg);
    paramView = this.cCj;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.cCj;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    this.timeTv = ((TextView)this.oFW.findViewById(a.e.multitalk_voice_mini_time_tv));
    this.mrN = ((TextView)this.oFW.findViewById(a.e.multitalk_voice_mini_tip_tv));
    this.context = this.oFW.getContext();
    this.FyV = ((WeImageView)this.oFW.findViewById(a.e.multitalk_main_status_icon_iv));
    paramView = this.FyV;
    if (paramView != null) {
      paramView.setBackground(au.o(this.context, a.g.icons_filled_call, Color.parseColor("#07C160")));
    }
    paramView = this.FyV;
    if (paramView != null) {
      paramView.setIconColor(Color.parseColor("#07C160"));
    }
    paramView = this.FyV;
    if (paramView != null)
    {
      paramView.setVisibility(0);
      AppMethodBeat.o(197549);
      return;
    }
    AppMethodBeat.o(197549);
  }
  
  public final Integer eYy()
  {
    AppMethodBeat.i(197542);
    int i = this.oFW.getVisibility();
    AppMethodBeat.o(197542);
    return Integer.valueOf(i);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView$doAnimationHide$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
  public static final class a
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(205366);
      this.FyX.oFW.setVisibility(4);
      AppMethodBeat.o(205366);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView$doAnimationShow$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(199236);
      this.FyX.oFW.setAlpha(1.0F);
      AppMethodBeat.o(199236);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.j
 * JD-Core Version:    0.7.0.1
 */