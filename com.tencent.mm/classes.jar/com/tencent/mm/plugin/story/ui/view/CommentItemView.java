package com.tencent.mm.plugin.story.ui.view;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animEndHeight", "animEndWidth", "animStartSize", "appeared", "", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getComment", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "setComment", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "contentLayout", "Landroid/view/ViewGroup;", "getContentLayout", "()Landroid/view/ViewGroup;", "setContentLayout", "(Landroid/view/ViewGroup;)V", "maskView", "Landroid/view/View;", "getMaskView", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "normalAnimator", "Landroid/animation/ValueAnimator;", "getNormalAnimator", "()Landroid/animation/ValueAnimator;", "setNormalAnimator", "(Landroid/animation/ValueAnimator;)V", "normalBgAnimator", "getNormalBgAnimator", "setNormalBgAnimator", "backgroundAnimation", "", "contentAnimation", "enterListAnimation", "order", "isAppearAnimEnd", "normalAnimation", "duration", "", "transStart", "transEnd", "onAppear", "Lkotlin/Function0;", "onAnimateEnd", "onFinishInflate", "shakeAnimation", "stopAnimation", "ArgbEvaluator", "Companion", "TwoLineInterpolator", "plugin-story_release"})
public final class CommentItemView
  extends LinearLayout
{
  public static final b FAM;
  ValueAnimator FAF;
  private ValueAnimator FAG;
  com.tencent.mm.plugin.story.f.b.a FAH;
  private boolean FAI;
  int FAJ;
  int FAK;
  int FAL;
  public ImageView jWS;
  public View maskView;
  public ViewGroup zhm;
  
  static
  {
    AppMethodBeat.i(120036);
    FAM = new b((byte)0);
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
    this.FAH = new com.tencent.mm.plugin.story.f.b.a();
    this.FAJ = com.tencent.mm.cb.a.fromDPToPix(paramContext, 48);
    AppMethodBeat.o(120034);
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(120028);
    ImageView localImageView = this.jWS;
    if (localImageView == null) {
      p.btv("avatarView");
    }
    AppMethodBeat.o(120028);
    return localImageView;
  }
  
  public final com.tencent.mm.plugin.story.f.b.a getComment()
  {
    return this.FAH;
  }
  
  public final ViewGroup getContentLayout()
  {
    AppMethodBeat.i(120030);
    ViewGroup localViewGroup = this.zhm;
    if (localViewGroup == null) {
      p.btv("contentLayout");
    }
    AppMethodBeat.o(120030);
    return localViewGroup;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(120026);
    View localView = this.maskView;
    if (localView == null) {
      p.btv("maskView");
    }
    AppMethodBeat.o(120026);
    return localView;
  }
  
  public final ValueAnimator getNormalAnimator()
  {
    return this.FAF;
  }
  
  public final ValueAnimator getNormalBgAnimator()
  {
    return this.FAG;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(120033);
    super.onFinishInflate();
    View localView2 = findViewById(2131308493);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = findViewById(2131308500);
    }
    if (localView1 == null) {}
    for (this.maskView = ((View)this);; this.maskView = localView1)
    {
      localView1 = findViewById(2131308514);
      p.g(localView1, "findViewById(R.id.story_comment_item_avatar)");
      this.jWS = ((ImageView)localView1);
      localView1 = findViewById(2131308518);
      p.g(localView1, "findViewById(R.id.story_…ment_item_content_layout)");
      this.zhm = ((ViewGroup)localView1);
      AppMethodBeat.o(120033);
      return;
    }
  }
  
  public final void setAvatarView(ImageView paramImageView)
  {
    AppMethodBeat.i(120029);
    p.h(paramImageView, "<set-?>");
    this.jWS = paramImageView;
    AppMethodBeat.o(120029);
  }
  
  public final void setComment(com.tencent.mm.plugin.story.f.b.a parama)
  {
    AppMethodBeat.i(120032);
    p.h(parama, "<set-?>");
    this.FAH = parama;
    AppMethodBeat.o(120032);
  }
  
  public final void setContentLayout(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120031);
    p.h(paramViewGroup, "<set-?>");
    this.zhm = paramViewGroup;
    AppMethodBeat.o(120031);
  }
  
  public final void setMaskView(View paramView)
  {
    AppMethodBeat.i(120027);
    p.h(paramView, "<set-?>");
    this.maskView = paramView;
    AppMethodBeat.o(120027);
  }
  
  public final void setNormalAnimator(ValueAnimator paramValueAnimator)
  {
    this.FAF = paramValueAnimator;
  }
  
  public final void setNormalBgAnimator(ValueAnimator paramValueAnimator)
  {
    this.FAG = paramValueAnimator;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$ArgbEvaluator;", "Landroid/animation/TypeEvaluator;", "", "()V", "evaluate", "fraction", "", "startValue", "endValue", "plugin-story_release"})
  public static final class a
    implements TypeEvaluator<Object>
  {
    public final Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(120022);
      p.h(paramObject1, "startValue");
      p.h(paramObject2, "endValue");
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$TwoLineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "getDivide", "()Landroid/graphics/PointF;", "smooth", "", "smoothEnd", "smoothStart", "getInterpolation", "input", "plugin-story_release"})
  public static final class c
    implements Interpolator
  {
    private final float FAN;
    private final PointF FAO;
    private final PointF FAP;
    private final PointF FAQ;
    
    public c(PointF paramPointF)
    {
      AppMethodBeat.i(120023);
      this.FAQ = paramPointF;
      this.FAN = 0.2F;
      this.FAO = new PointF(this.FAQ.x * (1.0F - this.FAN), this.FAQ.y * (1.0F - this.FAN));
      this.FAP = new PointF(this.FAQ.x + (1.0F - this.FAQ.x) * this.FAN, this.FAQ.y + (1.0F - this.FAQ.y) * this.FAN);
      AppMethodBeat.o(120023);
    }
    
    public final float getInterpolation(float paramFloat)
    {
      if (paramFloat < this.FAO.x) {
        return this.FAQ.y * paramFloat / this.FAQ.x;
      }
      if (paramFloat < this.FAP.x) {
        return this.FAO.y + (paramFloat - this.FAO.x) / (this.FAP.x - this.FAO.x) * (this.FAP.y - this.FAO.y);
      }
      return this.FAQ.y + (paramFloat - this.FAQ.x) / (1.0F - this.FAQ.x) * (1.0F - this.FAQ.y);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(120024);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = this.FAS.getLayoutParams();
      paramValueAnimator.width = (CommentItemView.c(this.FAS) + (int)((CommentItemView.d(this.FAS) - CommentItemView.c(this.FAS)) * f));
      int i = CommentItemView.c(this.FAS);
      paramValueAnimator.height = ((int)(f * (CommentItemView.e(this.FAS) - CommentItemView.c(this.FAS))) + i);
      this.FAS.setLayoutParams(paramValueAnimator);
      AppMethodBeat.o(120024);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(CommentItemView paramCommentItemView, int paramInt1, int paramInt2, z.f paramf, kotlin.g.a.a parama) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(120025);
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(120025);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      int i = (int)((this.FAT - this.FAU) * (1.0F - f));
      this.FAS.setTranslationY(i);
      if (f < this.FAV)
      {
        this.FAS.setScaleX(f / this.FAV);
        this.FAS.setScaleY(f / this.FAV);
        this.FAS.setAlpha(f / this.FAV * 0.5F + 0.5F);
      }
      do
      {
        if (i < 100) {
          this.FAS.setAlpha(i / 100.0F);
        }
        if (this.FAS.getAlpha() >= 0.05F) {
          break;
        }
        paramValueAnimator = this.FAS.getNormalAnimator();
        if (paramValueAnimator != null) {
          paramValueAnimator.removeAllUpdateListeners();
        }
        paramValueAnimator = this.FAX;
        if (paramValueAnimator == null) {
          break;
        }
        paramValueAnimator.invoke();
        AppMethodBeat.o(120025);
        return;
        this.FAS.setScaleX(1.0F);
        this.FAS.setScaleY(1.0F);
        this.FAS.setAlpha(1.0F);
        paramValueAnimator = (kotlin.g.a.a)this.FAW.SYG;
        if (paramValueAnimator != null) {
          paramValueAnimator.invoke();
        }
        this.FAW.SYG = null;
      } while (CommentItemView.a(this.FAS));
      CommentItemView.b(this.FAS);
      paramValueAnimator = this.FAS;
      long l = 0L;
      Object localObject;
      if (!paramValueAnimator.FAH.FnX)
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
        localObject = paramValueAnimator.zhm;
        if (localObject == null) {
          p.btv("contentLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = paramValueAnimator.zhm;
        if (localObject == null) {
          p.btv("contentLayout");
        }
        ((ViewGroup)localObject).setAlpha(0.0F);
        paramValueAnimator = paramValueAnimator.zhm;
        if (paramValueAnimator == null) {
          p.btv("contentLayout");
        }
        paramValueAnimator = ObjectAnimator.ofFloat(paramValueAnimator, "alpha", new float[] { 0.0F, 1.0F });
        p.g(paramValueAnimator, "contentLayoutAnim");
        paramValueAnimator.setStartDelay(l);
        paramValueAnimator.setDuration(100L);
        paramValueAnimator.start();
        break;
        localObject = paramValueAnimator.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = paramValueAnimator.FAL;
        ((ViewGroup.LayoutParams)localObject).height = paramValueAnimator.FAK;
        paramValueAnimator.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      AppMethodBeat.o(120025);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentItemView
 * JD-Core Version:    0.7.0.1
 */