package com.tencent.mm.plugin.story.ui.view;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
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
import com.tencent.mm.plugin.story.a.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animEndHeight", "animEndWidth", "animStartSize", "appeared", "", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getComment", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "setComment", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "contentLayout", "Landroid/view/ViewGroup;", "getContentLayout", "()Landroid/view/ViewGroup;", "setContentLayout", "(Landroid/view/ViewGroup;)V", "maskView", "Landroid/view/View;", "getMaskView", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "normalAnimator", "Landroid/animation/ValueAnimator;", "getNormalAnimator", "()Landroid/animation/ValueAnimator;", "setNormalAnimator", "(Landroid/animation/ValueAnimator;)V", "normalBgAnimator", "getNormalBgAnimator", "setNormalBgAnimator", "backgroundAnimation", "", "contentAnimation", "enterListAnimation", "order", "isAppearAnimEnd", "normalAnimation", "duration", "", "transStart", "transEnd", "onAppear", "Lkotlin/Function0;", "onAnimateEnd", "onFinishInflate", "shakeAnimation", "stopAnimation", "ArgbEvaluator", "Companion", "TwoLineInterpolator", "plugin-story_release"})
public final class CommentItemView
  extends LinearLayout
{
  public static final b LUQ;
  public ViewGroup EMs;
  ValueAnimator LUJ;
  private ValueAnimator LUK;
  com.tencent.mm.plugin.story.f.b.a LUL;
  private boolean LUM;
  int LUN;
  int LUO;
  int LUP;
  public ImageView mOe;
  public View maskView;
  
  static
  {
    AppMethodBeat.i(120036);
    LUQ = new b((byte)0);
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
    this.LUL = new com.tencent.mm.plugin.story.f.b.a();
    this.LUN = com.tencent.mm.ci.a.fromDPToPix(paramContext, 48);
    AppMethodBeat.o(120034);
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(120028);
    ImageView localImageView = this.mOe;
    if (localImageView == null) {
      p.bGy("avatarView");
    }
    AppMethodBeat.o(120028);
    return localImageView;
  }
  
  public final com.tencent.mm.plugin.story.f.b.a getComment()
  {
    return this.LUL;
  }
  
  public final ViewGroup getContentLayout()
  {
    AppMethodBeat.i(120030);
    ViewGroup localViewGroup = this.EMs;
    if (localViewGroup == null) {
      p.bGy("contentLayout");
    }
    AppMethodBeat.o(120030);
    return localViewGroup;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(120026);
    View localView = this.maskView;
    if (localView == null) {
      p.bGy("maskView");
    }
    AppMethodBeat.o(120026);
    return localView;
  }
  
  public final ValueAnimator getNormalAnimator()
  {
    return this.LUJ;
  }
  
  public final ValueAnimator getNormalBgAnimator()
  {
    return this.LUK;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(120033);
    super.onFinishInflate();
    View localView2 = findViewById(a.d.LAw);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = findViewById(a.d.LAD);
    }
    if (localView1 == null) {}
    for (this.maskView = ((View)this);; this.maskView = localView1)
    {
      localView1 = findViewById(a.d.LAQ);
      p.j(localView1, "findViewById(R.id.story_comment_item_avatar)");
      this.mOe = ((ImageView)localView1);
      localView1 = findViewById(a.d.LAU);
      p.j(localView1, "findViewById(R.id.story_…ment_item_content_layout)");
      this.EMs = ((ViewGroup)localView1);
      AppMethodBeat.o(120033);
      return;
    }
  }
  
  public final void setAvatarView(ImageView paramImageView)
  {
    AppMethodBeat.i(120029);
    p.k(paramImageView, "<set-?>");
    this.mOe = paramImageView;
    AppMethodBeat.o(120029);
  }
  
  public final void setComment(com.tencent.mm.plugin.story.f.b.a parama)
  {
    AppMethodBeat.i(120032);
    p.k(parama, "<set-?>");
    this.LUL = parama;
    AppMethodBeat.o(120032);
  }
  
  public final void setContentLayout(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120031);
    p.k(paramViewGroup, "<set-?>");
    this.EMs = paramViewGroup;
    AppMethodBeat.o(120031);
  }
  
  public final void setMaskView(View paramView)
  {
    AppMethodBeat.i(120027);
    p.k(paramView, "<set-?>");
    this.maskView = paramView;
    AppMethodBeat.o(120027);
  }
  
  public final void setNormalAnimator(ValueAnimator paramValueAnimator)
  {
    this.LUJ = paramValueAnimator;
  }
  
  public final void setNormalBgAnimator(ValueAnimator paramValueAnimator)
  {
    this.LUK = paramValueAnimator;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$ArgbEvaluator;", "Landroid/animation/TypeEvaluator;", "", "()V", "evaluate", "fraction", "", "startValue", "endValue", "plugin-story_release"})
  public static final class a
    implements TypeEvaluator<Object>
  {
    public final Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(120022);
      p.k(paramObject1, "startValue");
      p.k(paramObject2, "endValue");
      int i = ((Integer)paramObject1).intValue();
      float f1 = (i >> 24 & 0xFF) / 255.0F;
      float f4 = (i >> 16 & 0xFF) / 255.0F;
      float f5 = (i >> 8 & 0xFF) / 255.0F;
      float f6 = (i & 0xFF) / 255.0F;
      i = ((Integer)paramObject2).intValue();
      float f2 = (i >> 24 & 0xFF) / 255.0F;
      float f8 = (i >> 16 & 0xFF) / 255.0F;
      float f7 = (i >> 8 & 0xFF) / 255.0F;
      float f3 = (i & 0xFF) / 255.0F;
      f4 = (float)Math.pow(f4, 2.2D);
      f5 = (float)Math.pow(f5, 2.2D);
      f6 = (float)Math.pow(f6, 2.2D);
      f8 = (float)Math.pow(f8, 2.2D);
      f7 = (float)Math.pow(f7, 2.2D);
      f3 = (float)Math.pow(f3, 2.2D);
      f4 = (float)Math.pow(f4 + (f8 - f4) * paramFloat, 0.4545454545454545D);
      f5 = (float)Math.pow(f5 + (f7 - f5) * paramFloat, 0.4545454545454545D);
      f3 = (float)Math.pow(f6 + (f3 - f6) * paramFloat, 0.4545454545454545D);
      i = Math.round((f1 + (f2 - f1) * paramFloat) * 255.0F);
      int j = Math.round(f4 * 255.0F);
      int k = Math.round(f5 * 255.0F);
      int m = Math.round(f3 * 255.0F);
      AppMethodBeat.o(120022);
      return Integer.valueOf(m | i << 24 | j << 16 | k << 8);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d(CommentItemView paramCommentItemView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(120024);
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(120024);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = this.LUV.getLayoutParams();
      paramValueAnimator.width = (CommentItemView.c(this.LUV) + (int)((CommentItemView.d(this.LUV) - CommentItemView.c(this.LUV)) * f));
      int i = CommentItemView.c(this.LUV);
      paramValueAnimator.height = ((int)(f * (CommentItemView.e(this.LUV) - CommentItemView.c(this.LUV))) + i);
      this.LUV.setLayoutParams(paramValueAnimator);
      AppMethodBeat.o(120024);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(CommentItemView paramCommentItemView, int paramInt1, int paramInt2, aa.f paramf, kotlin.g.a.a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(120025);
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(120025);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      int i = (int)((this.LUW - this.LUX) * (1.0F - f));
      this.LUV.setTranslationY(i);
      if (f < this.LUY)
      {
        this.LUV.setScaleX(f / this.LUY);
        this.LUV.setScaleY(f / this.LUY);
        this.LUV.setAlpha(f / this.LUY * 0.5F + 0.5F);
      }
      do
      {
        if (i < 100) {
          this.LUV.setAlpha(i / 100.0F);
        }
        if (this.LUV.getAlpha() >= 0.05F) {
          break;
        }
        paramValueAnimator = this.LUV.getNormalAnimator();
        if (paramValueAnimator != null) {
          paramValueAnimator.removeAllUpdateListeners();
        }
        paramValueAnimator = this.LVa;
        if (paramValueAnimator == null) {
          break;
        }
        paramValueAnimator.invoke();
        AppMethodBeat.o(120025);
        return;
        this.LUV.setScaleX(1.0F);
        this.LUV.setScaleY(1.0F);
        this.LUV.setAlpha(1.0F);
        paramValueAnimator = (kotlin.g.a.a)this.LUZ.aaBC;
        if (paramValueAnimator != null) {
          paramValueAnimator.invoke();
        }
        this.LUZ.aaBC = null;
      } while (CommentItemView.a(this.LUV));
      CommentItemView.b(this.LUV);
      paramValueAnimator = this.LUV;
      long l = 0L;
      Object localObject;
      if (!paramValueAnimator.LUL.LHY)
      {
        localObject = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CommentItemView.d(paramValueAnimator));
        p.j(localObject, "sizeAnimator");
        ((ValueAnimator)localObject).setDuration(300L);
        ((ValueAnimator)localObject).start();
        l = 300L;
      }
      for (;;)
      {
        localObject = paramValueAnimator.EMs;
        if (localObject == null) {
          p.bGy("contentLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = paramValueAnimator.EMs;
        if (localObject == null) {
          p.bGy("contentLayout");
        }
        ((ViewGroup)localObject).setAlpha(0.0F);
        paramValueAnimator = paramValueAnimator.EMs;
        if (paramValueAnimator == null) {
          p.bGy("contentLayout");
        }
        paramValueAnimator = ObjectAnimator.ofFloat(paramValueAnimator, "alpha", new float[] { 0.0F, 1.0F });
        p.j(paramValueAnimator, "contentLayoutAnim");
        paramValueAnimator.setStartDelay(l);
        paramValueAnimator.setDuration(100L);
        paramValueAnimator.start();
        break;
        localObject = paramValueAnimator.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = paramValueAnimator.LUP;
        ((ViewGroup.LayoutParams)localObject).height = paramValueAnimator.LUO;
        paramValueAnimator.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(120025);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentItemView
 * JD-Core Version:    0.7.0.1
 */