package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "bgView", "contentView", "context", "Landroid/content/Context;", "mainIconLayout", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "radius", "", "getRootView", "()Landroid/view/View;", "setRootView", "timeTv", "Landroid/widget/TextView;", "tipTv", "value", "", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "doAnimationHide", "", "doAnimationShow", "onHangupHappened", "onResumeIconAndTipShow", "refreshLayoutCauseDockChanged", "isDockerLeft", "", "refreshMiniView", "release", "setVoicePlayDevice", "device", "updateText", "text", "", "updateTime", "plugin-multitalk_release"})
public final class j
{
  View cBH;
  View contentView;
  Context context;
  TextView jBS;
  View lJI;
  private final float radius;
  TextView timeTv;
  WeImageView zTt;
  Integer zTu;
  
  public j(View paramView)
  {
    AppMethodBeat.i(239805);
    this.lJI = paramView;
    this.radius = a.fromDPToPix(MMApplicationContext.getContext(), 12);
    this.contentView = this.lJI.findViewById(2131305030);
    paramView = this.contentView;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.contentView;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    this.cBH = this.lJI.findViewById(2131310502);
    paramView = this.cBH;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.cBH;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    this.timeTv = ((TextView)this.lJI.findViewById(2131305072));
    this.jBS = ((TextView)this.lJI.findViewById(2131305073));
    this.context = this.lJI.getContext();
    this.zTt = ((WeImageView)this.lJI.findViewById(2131305038));
    paramView = this.zTt;
    if (paramView != null) {
      paramView.setBackground(ar.m(this.context, 2131690498, Color.parseColor("#07C160")));
    }
    paramView = this.zTt;
    if (paramView != null) {
      paramView.setIconColor(Color.parseColor("#07C160"));
    }
    paramView = this.zTt;
    if (paramView != null)
    {
      paramView.setVisibility(0);
      AppMethodBeat.o(239805);
      return;
    }
    AppMethodBeat.o(239805);
  }
  
  public final Integer eoH()
  {
    AppMethodBeat.i(239804);
    int i = this.lJI.getVisibility();
    AppMethodBeat.o(239804);
    return Integer.valueOf(i);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView$doAnimationHide$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
  public static final class a
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(239802);
      this.zTv.lJI.setVisibility(4);
      AppMethodBeat.o(239802);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVoiceView$doAnimationShow$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
  public static final class b
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(239803);
      this.zTv.lJI.setAlpha(1.0F);
      AppMethodBeat.o(239803);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.j
 * JD-Core Version:    0.7.0.1
 */