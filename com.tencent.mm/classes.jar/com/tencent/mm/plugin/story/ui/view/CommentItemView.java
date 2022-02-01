package com.tencent.mm.plugin.story.ui.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animEndHeight", "animEndWidth", "animStartSize", "appeared", "", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getComment", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "setComment", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "contentLayout", "Landroid/view/ViewGroup;", "getContentLayout", "()Landroid/view/ViewGroup;", "setContentLayout", "(Landroid/view/ViewGroup;)V", "maskView", "Landroid/view/View;", "getMaskView", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "normalAnimator", "Landroid/animation/ValueAnimator;", "getNormalAnimator", "()Landroid/animation/ValueAnimator;", "setNormalAnimator", "(Landroid/animation/ValueAnimator;)V", "normalBgAnimator", "getNormalBgAnimator", "setNormalBgAnimator", "backgroundAnimation", "", "contentAnimation", "enterListAnimation", "order", "isAppearAnimEnd", "normalAnimation", "duration", "", "transStart", "transEnd", "onAppear", "Lkotlin/Function0;", "onAnimateEnd", "onFinishInflate", "shakeAnimation", "stopAnimation", "ArgbEvaluator", "Companion", "TwoLineInterpolator", "plugin-story_release"})
public final class CommentItemView
  extends LinearLayout
{
  public static final CommentItemView.b AYC;
  int AYA;
  int AYB;
  ValueAnimator AYv;
  private ValueAnimator AYw;
  com.tencent.mm.plugin.story.f.b.a AYx;
  private boolean AYy;
  int AYz;
  public View gZU;
  public ImageView iWu;
  public ViewGroup vAa;
  
  static
  {
    AppMethodBeat.i(120036);
    AYC = new CommentItemView.b((byte)0);
    AppMethodBeat.o(120036);
  }
  
  public CommentItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120035);
    AppMethodBeat.o(120035);
  }
  
  public CommentItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120034);
    this.AYx = new com.tencent.mm.plugin.story.f.b.a();
    this.AYz = com.tencent.mm.cc.a.fromDPToPix(paramContext, 48);
    AppMethodBeat.o(120034);
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(120028);
    ImageView localImageView = this.iWu;
    if (localImageView == null) {
      p.bcb("avatarView");
    }
    AppMethodBeat.o(120028);
    return localImageView;
  }
  
  public final com.tencent.mm.plugin.story.f.b.a getComment()
  {
    return this.AYx;
  }
  
  public final ViewGroup getContentLayout()
  {
    AppMethodBeat.i(120030);
    ViewGroup localViewGroup = this.vAa;
    if (localViewGroup == null) {
      p.bcb("contentLayout");
    }
    AppMethodBeat.o(120030);
    return localViewGroup;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(120026);
    View localView = this.gZU;
    if (localView == null) {
      p.bcb("maskView");
    }
    AppMethodBeat.o(120026);
    return localView;
  }
  
  public final ValueAnimator getNormalAnimator()
  {
    return this.AYv;
  }
  
  public final ValueAnimator getNormalBgAnimator()
  {
    return this.AYw;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(120033);
    super.onFinishInflate();
    View localView2 = findViewById(2131305288);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = findViewById(2131305295);
    }
    if (localView1 == null) {}
    for (this.gZU = ((View)this);; this.gZU = localView1)
    {
      localView1 = findViewById(2131305309);
      p.g(localView1, "findViewById(R.id.story_comment_item_avatar)");
      this.iWu = ((ImageView)localView1);
      localView1 = findViewById(2131305313);
      p.g(localView1, "findViewById(R.id.story_…ment_item_content_layout)");
      this.vAa = ((ViewGroup)localView1);
      AppMethodBeat.o(120033);
      return;
    }
  }
  
  public final void setAvatarView(ImageView paramImageView)
  {
    AppMethodBeat.i(120029);
    p.h(paramImageView, "<set-?>");
    this.iWu = paramImageView;
    AppMethodBeat.o(120029);
  }
  
  public final void setComment(com.tencent.mm.plugin.story.f.b.a parama)
  {
    AppMethodBeat.i(120032);
    p.h(parama, "<set-?>");
    this.AYx = parama;
    AppMethodBeat.o(120032);
  }
  
  public final void setContentLayout(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120031);
    p.h(paramViewGroup, "<set-?>");
    this.vAa = paramViewGroup;
    AppMethodBeat.o(120031);
  }
  
  public final void setMaskView(View paramView)
  {
    AppMethodBeat.i(120027);
    p.h(paramView, "<set-?>");
    this.gZU = paramView;
    AppMethodBeat.o(120027);
  }
  
  public final void setNormalAnimator(ValueAnimator paramValueAnimator)
  {
    this.AYv = paramValueAnimator;
  }
  
  public final void setNormalBgAnimator(ValueAnimator paramValueAnimator)
  {
    this.AYw = paramValueAnimator;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d(CommentItemView paramCommentItemView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(120024);
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(120024);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = this.AYH.getLayoutParams();
      paramValueAnimator.width = (CommentItemView.c(this.AYH) + (int)((CommentItemView.d(this.AYH) - CommentItemView.c(this.AYH)) * f));
      int i = CommentItemView.c(this.AYH);
      paramValueAnimator.height = ((int)(f * (CommentItemView.e(this.AYH) - CommentItemView.c(this.AYH))) + i);
      this.AYH.setLayoutParams(paramValueAnimator);
      AppMethodBeat.o(120024);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(CommentItemView paramCommentItemView, int paramInt1, int paramInt2, y.f paramf, d.g.a.a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(120025);
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(120025);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      int i = (int)((this.AYI - this.AYJ) * (1.0F - f));
      this.AYH.setTranslationY(i);
      if (f < this.AYK)
      {
        this.AYH.setScaleX(f / this.AYK);
        this.AYH.setScaleY(f / this.AYK);
        this.AYH.setAlpha(f / this.AYK * 0.5F + 0.5F);
      }
      do
      {
        if (i < 100) {
          this.AYH.setAlpha(i / 100.0F);
        }
        if (this.AYH.getAlpha() >= 0.05F) {
          break;
        }
        paramValueAnimator = this.AYH.getNormalAnimator();
        if (paramValueAnimator != null) {
          paramValueAnimator.removeAllUpdateListeners();
        }
        paramValueAnimator = this.AYM;
        if (paramValueAnimator == null) {
          break;
        }
        paramValueAnimator.invoke();
        AppMethodBeat.o(120025);
        return;
        this.AYH.setScaleX(1.0F);
        this.AYH.setScaleY(1.0F);
        this.AYH.setAlpha(1.0F);
        paramValueAnimator = (d.g.a.a)this.AYL.MLV;
        if (paramValueAnimator != null) {
          paramValueAnimator.invoke();
        }
        this.AYL.MLV = null;
      } while (CommentItemView.a(this.AYH));
      CommentItemView.b(this.AYH);
      paramValueAnimator = this.AYH;
      long l = 0L;
      Object localObject;
      if (!paramValueAnimator.AYx.ALD)
      {
        localObject = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CommentItemView.d(paramValueAnimator));
        p.g(localObject, "sizeAnimator");
        ((ValueAnimator)localObject).setDuration(300L);
        ((ValueAnimator)localObject).start();
        l = 300L;
      }
      for (;;)
      {
        localObject = paramValueAnimator.vAa;
        if (localObject == null) {
          p.bcb("contentLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = paramValueAnimator.vAa;
        if (localObject == null) {
          p.bcb("contentLayout");
        }
        ((ViewGroup)localObject).setAlpha(0.0F);
        paramValueAnimator = paramValueAnimator.vAa;
        if (paramValueAnimator == null) {
          p.bcb("contentLayout");
        }
        paramValueAnimator = ObjectAnimator.ofFloat(paramValueAnimator, "alpha", new float[] { 0.0F, 1.0F });
        p.g(paramValueAnimator, "contentLayoutAnim");
        paramValueAnimator.setStartDelay(l);
        paramValueAnimator.setDuration(100L);
        paramValueAnimator.start();
        break;
        localObject = paramValueAnimator.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = paramValueAnimator.AYB;
        ((ViewGroup.LayoutParams)localObject).height = paramValueAnimator.AYA;
        paramValueAnimator.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(120025);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentItemView
 * JD-Core Version:    0.7.0.1
 */