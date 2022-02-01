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
import d.g.b.k;
import d.g.b.v.f;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animEndHeight", "animEndWidth", "animStartSize", "appeared", "", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getComment", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "setComment", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "contentLayout", "Landroid/view/ViewGroup;", "getContentLayout", "()Landroid/view/ViewGroup;", "setContentLayout", "(Landroid/view/ViewGroup;)V", "maskView", "Landroid/view/View;", "getMaskView", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "normalAnimator", "Landroid/animation/ValueAnimator;", "getNormalAnimator", "()Landroid/animation/ValueAnimator;", "setNormalAnimator", "(Landroid/animation/ValueAnimator;)V", "normalBgAnimator", "getNormalBgAnimator", "setNormalBgAnimator", "backgroundAnimation", "", "contentAnimation", "enterListAnimation", "order", "isAppearAnimEnd", "normalAnimation", "duration", "", "transStart", "transEnd", "onAppear", "Lkotlin/Function0;", "onAnimateEnd", "onFinishInflate", "shakeAnimation", "stopAnimation", "ArgbEvaluator", "Companion", "TwoLineInterpolator", "plugin-story_release"})
public final class CommentItemView
  extends LinearLayout
{
  public static final CommentItemView.b zHb;
  public View gGk;
  public ImageView iDk;
  public ViewGroup uxx;
  ValueAnimator zGU;
  private ValueAnimator zGV;
  com.tencent.mm.plugin.story.f.b.a zGW;
  private boolean zGX;
  int zGY;
  int zGZ;
  int zHa;
  
  static
  {
    AppMethodBeat.i(120036);
    zHb = new CommentItemView.b((byte)0);
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
    this.zGW = new com.tencent.mm.plugin.story.f.b.a();
    this.zGY = com.tencent.mm.cc.a.fromDPToPix(paramContext, 48);
    AppMethodBeat.o(120034);
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(120028);
    ImageView localImageView = this.iDk;
    if (localImageView == null) {
      k.aVY("avatarView");
    }
    AppMethodBeat.o(120028);
    return localImageView;
  }
  
  public final com.tencent.mm.plugin.story.f.b.a getComment()
  {
    return this.zGW;
  }
  
  public final ViewGroup getContentLayout()
  {
    AppMethodBeat.i(120030);
    ViewGroup localViewGroup = this.uxx;
    if (localViewGroup == null) {
      k.aVY("contentLayout");
    }
    AppMethodBeat.o(120030);
    return localViewGroup;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(120026);
    View localView = this.gGk;
    if (localView == null) {
      k.aVY("maskView");
    }
    AppMethodBeat.o(120026);
    return localView;
  }
  
  public final ValueAnimator getNormalAnimator()
  {
    return this.zGU;
  }
  
  public final ValueAnimator getNormalBgAnimator()
  {
    return this.zGV;
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
    for (this.gGk = ((View)this);; this.gGk = localView1)
    {
      localView1 = findViewById(2131305309);
      k.g(localView1, "findViewById(R.id.story_comment_item_avatar)");
      this.iDk = ((ImageView)localView1);
      localView1 = findViewById(2131305313);
      k.g(localView1, "findViewById(R.id.story_…ment_item_content_layout)");
      this.uxx = ((ViewGroup)localView1);
      AppMethodBeat.o(120033);
      return;
    }
  }
  
  public final void setAvatarView(ImageView paramImageView)
  {
    AppMethodBeat.i(120029);
    k.h(paramImageView, "<set-?>");
    this.iDk = paramImageView;
    AppMethodBeat.o(120029);
  }
  
  public final void setComment(com.tencent.mm.plugin.story.f.b.a parama)
  {
    AppMethodBeat.i(120032);
    k.h(parama, "<set-?>");
    this.zGW = parama;
    AppMethodBeat.o(120032);
  }
  
  public final void setContentLayout(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120031);
    k.h(paramViewGroup, "<set-?>");
    this.uxx = paramViewGroup;
    AppMethodBeat.o(120031);
  }
  
  public final void setMaskView(View paramView)
  {
    AppMethodBeat.i(120027);
    k.h(paramView, "<set-?>");
    this.gGk = paramView;
    AppMethodBeat.o(120027);
  }
  
  public final void setNormalAnimator(ValueAnimator paramValueAnimator)
  {
    this.zGU = paramValueAnimator;
  }
  
  public final void setNormalBgAnimator(ValueAnimator paramValueAnimator)
  {
    this.zGV = paramValueAnimator;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d(CommentItemView paramCommentItemView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(120024);
      k.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(120024);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = this.zHg.getLayoutParams();
      paramValueAnimator.width = (CommentItemView.c(this.zHg) + (int)((CommentItemView.d(this.zHg) - CommentItemView.c(this.zHg)) * f));
      int i = CommentItemView.c(this.zHg);
      paramValueAnimator.height = ((int)(f * (CommentItemView.e(this.zHg) - CommentItemView.c(this.zHg))) + i);
      this.zHg.setLayoutParams(paramValueAnimator);
      AppMethodBeat.o(120024);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(CommentItemView paramCommentItemView, int paramInt1, int paramInt2, v.f paramf, d.g.a.a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(120025);
      k.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(120025);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      int i = (int)((this.zHh - this.zHi) * (1.0F - f));
      this.zHg.setTranslationY(i);
      if (f < this.zHj)
      {
        this.zHg.setScaleX(f / this.zHj);
        this.zHg.setScaleY(f / this.zHj);
        this.zHg.setAlpha(f / this.zHj * 0.5F + 0.5F);
      }
      do
      {
        if (i < 100) {
          this.zHg.setAlpha(i / 100.0F);
        }
        if (this.zHg.getAlpha() >= 0.05F) {
          break;
        }
        paramValueAnimator = this.zHg.getNormalAnimator();
        if (paramValueAnimator != null) {
          paramValueAnimator.removeAllUpdateListeners();
        }
        paramValueAnimator = this.zHl;
        if (paramValueAnimator == null) {
          break;
        }
        paramValueAnimator.invoke();
        AppMethodBeat.o(120025);
        return;
        this.zHg.setScaleX(1.0F);
        this.zHg.setScaleY(1.0F);
        this.zHg.setAlpha(1.0F);
        paramValueAnimator = (d.g.a.a)this.zHk.KUQ;
        if (paramValueAnimator != null) {
          paramValueAnimator.invoke();
        }
        this.zHk.KUQ = null;
      } while (CommentItemView.a(this.zHg));
      CommentItemView.b(this.zHg);
      paramValueAnimator = this.zHg;
      long l = 0L;
      Object localObject;
      if (!paramValueAnimator.zGW.ztJ)
      {
        localObject = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CommentItemView.d(paramValueAnimator));
        k.g(localObject, "sizeAnimator");
        ((ValueAnimator)localObject).setDuration(300L);
        ((ValueAnimator)localObject).start();
        l = 300L;
      }
      for (;;)
      {
        localObject = paramValueAnimator.uxx;
        if (localObject == null) {
          k.aVY("contentLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = paramValueAnimator.uxx;
        if (localObject == null) {
          k.aVY("contentLayout");
        }
        ((ViewGroup)localObject).setAlpha(0.0F);
        paramValueAnimator = paramValueAnimator.uxx;
        if (paramValueAnimator == null) {
          k.aVY("contentLayout");
        }
        paramValueAnimator = ObjectAnimator.ofFloat(paramValueAnimator, "alpha", new float[] { 0.0F, 1.0F });
        k.g(paramValueAnimator, "contentLayoutAnim");
        paramValueAnimator.setStartDelay(l);
        paramValueAnimator.setDuration(100L);
        paramValueAnimator.start();
        break;
        localObject = paramValueAnimator.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = paramValueAnimator.zHa;
        ((ViewGroup.LayoutParams)localObject).height = paramValueAnimator.zGZ;
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