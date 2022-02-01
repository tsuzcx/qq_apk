package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import d.g.b.k;
import d.l;
import d.v;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarDetailView", "footerStub", "getFooterStub", "()Landroid/view/View;", "setFooterStub", "headerStub", "getHeaderStub", "setHeaderStub", "loadingIv", "Landroid/widget/ImageView;", "mMuteIconIv", "mTimerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mTitleShowCallback", "Lkotlin/Function1;", "", "", "maskView", "multiTalkVideoView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkVideoView;", "switchCameraTv", "Landroid/widget/TextView;", "talkingAvatarLayout", "getTalkingAvatarLayout", "setTalkingAvatarLayout", "userName", "userNameShadowIv", "userNameTv", "voiceMaskIv", "weakNetworkIv", "hideUserName", "showMuteIcon", "visible", "", "showUserName", "isTitleShowCallback", "mIsContinue", "", "plugin-multitalk_release"})
public final class b
  extends RecyclerView.w
{
  private d.g.a.b<? super String, y> ByQ;
  private au bYO;
  public View gGk;
  public TextView uZA;
  private View uZB;
  private View uZC;
  View uZE;
  View uZF;
  View uZG;
  public MultiTalkVideoView uZv;
  public ImageView uZw;
  public ImageView uZx;
  public TextView uZy;
  public ImageView uZz;
  public String userName;
  public ImageView uxs;
  
  public b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(178966);
    View localView = paramView.findViewById(2131305664);
    k.g(localView, "itemView.findViewById(R.id.talking_avatar_layout)");
    this.uZE = localView;
    localView = paramView.findViewById(2131300727);
    k.g(localView, "itemView.findViewById(R.id.header_stub)");
    this.uZF = localView;
    localView = paramView.findViewById(2131300209);
    k.g(localView, "itemView.findViewById(R.id.footer_stub)");
    this.uZG = localView;
    localView = paramView.findViewById(2131305671);
    if (localView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.uZv = ((MultiTalkVideoView)localView);
    this.gGk = paramView.findViewById(2131302169);
    localView = paramView.findViewById(2131306487);
    if (localView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.uZw = ((ImageView)localView);
    localView = paramView.findViewById(2131302597);
    if (localView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.uZx = ((ImageView)localView);
    localView = paramView.findViewById(2131305577);
    if (localView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.uZy = ((TextView)localView);
    localView = paramView.findViewById(2131301502);
    if (localView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.uxs = ((ImageView)localView);
    localView = paramView.findViewById(2131302585);
    if (localView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.uZz = ((ImageView)localView);
    localView = paramView.findViewById(2131307275);
    if (localView == null)
    {
      paramView = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.uZA = ((TextView)localView);
    this.uZC = paramView.findViewById(2131307274);
    this.uZB = paramView.findViewById(2131307273);
    AppMethodBeat.o(178966);
  }
  
  private final void dgF()
  {
    AppMethodBeat.i(200722);
    Object localObject = this.uZB;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).cancel();
      }
    }
    localObject = this.uZB;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setDuration(150L);
          if (localObject != null) {
            ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new a(this));
          }
        }
      }
    }
    localObject = this.bYO;
    if (localObject != null) {
      ((au)localObject).stopTimer();
    }
    localObject = this.bYO;
    if (localObject != null) {
      ((au)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.bYO;
    if (localObject != null)
    {
      ((au)localObject).quitSafely();
      AppMethodBeat.o(200722);
      return;
    }
    AppMethodBeat.o(200722);
  }
  
  public final void b(d.g.a.b<? super String, y> paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(210278);
    TextView localTextView = this.uZA;
    if (((localTextView != null) && (localTextView.getVisibility() == 8)) || (paramBoolean))
    {
      this.ByQ = paramb;
      paramb = this.uZA;
      if (paramb != null) {
        paramb.setText((CharSequence)this.userName);
      }
      paramb = this.uZB;
      if (paramb != null) {
        paramb.setAlpha(0.0F);
      }
      paramb = this.uZC;
      if (paramb != null) {
        paramb.setVisibility(0);
      }
      paramb = this.uZA;
      if (paramb != null) {
        paramb.setVisibility(0);
      }
      paramb = this.bYO;
      if (paramb != null) {
        paramb.stopTimer();
      }
      paramb = this.bYO;
      if (paramb != null) {
        paramb.removeCallbacksAndMessages(null);
      }
      paramb = this.bYO;
      if (paramb != null) {
        paramb.quitSafely();
      }
      this.bYO = new au((au.a)new b(this), false);
      paramb = this.uZB;
      if (paramb != null)
      {
        paramb = paramb.animate();
        if (paramb != null) {
          paramb.cancel();
        }
      }
      paramb = this.uZB;
      if (paramb != null)
      {
        paramb = paramb.animate();
        if (paramb != null)
        {
          paramb = paramb.alpha(1.0F);
          if (paramb != null)
          {
            paramb = paramb.setDuration(150L);
            if (paramb != null)
            {
              paramb.setListener((Animator.AnimatorListener)new c(this));
              AppMethodBeat.o(210278);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(210278);
      return;
    }
    dgF();
    AppMethodBeat.o(210278);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder$hideUserName$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
  public static final class a
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(200718);
      paramAnimator = this.uZH.uZA;
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      paramAnimator = b.c(this.uZH);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      paramAnimator = this.uZH.userName;
      if (paramAnimator != null)
      {
        d.g.a.b localb = b.d(this.uZH);
        if (localb != null)
        {
          localb.ay(paramAnimator);
          AppMethodBeat.o(200718);
          return;
        }
        AppMethodBeat.o(200718);
        return;
      }
      AppMethodBeat.o(200718);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTimerExpired"})
  static final class b
    implements au.a
  {
    b(b paramb) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(200719);
      b.a(this.uZH);
      AppMethodBeat.o(200719);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder$showUserName$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(200720);
      paramAnimator = b.b(this.uZH);
      if (paramAnimator != null)
      {
        paramAnimator.Ah(5000L);
        AppMethodBeat.o(200720);
        return;
      }
      AppMethodBeat.o(200720);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */