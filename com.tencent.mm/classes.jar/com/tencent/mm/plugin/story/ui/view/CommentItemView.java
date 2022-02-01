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
import d.g.b.k;
import d.g.b.v.e;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animEndHeight", "animEndWidth", "animStartSize", "appeared", "", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getComment", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "setComment", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "contentLayout", "Landroid/view/ViewGroup;", "getContentLayout", "()Landroid/view/ViewGroup;", "setContentLayout", "(Landroid/view/ViewGroup;)V", "maskView", "Landroid/view/View;", "getMaskView", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "normalAnimator", "Landroid/animation/ValueAnimator;", "getNormalAnimator", "()Landroid/animation/ValueAnimator;", "setNormalAnimator", "(Landroid/animation/ValueAnimator;)V", "normalBgAnimator", "getNormalBgAnimator", "setNormalBgAnimator", "backgroundAnimation", "", "contentAnimation", "enterListAnimation", "order", "isAppearAnimEnd", "normalAnimation", "duration", "", "transStart", "transEnd", "onAppear", "Lkotlin/Function0;", "onAnimateEnd", "onFinishInflate", "shakeAnimation", "stopAnimation", "ArgbEvaluator", "Companion", "TwoLineInterpolator", "plugin-story_release"})
public final class CommentItemView
  extends LinearLayout
{
  public static final b ytI;
  public ImageView ida;
  public View lRB;
  public ViewGroup tpf;
  ValueAnimator ytB;
  private ValueAnimator ytC;
  com.tencent.mm.plugin.story.f.b.a ytD;
  private boolean ytE;
  int ytF;
  int ytG;
  int ytH;
  
  static
  {
    AppMethodBeat.i(120036);
    ytI = new b((byte)0);
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
    this.ytD = new com.tencent.mm.plugin.story.f.b.a();
    this.ytF = com.tencent.mm.cd.a.fromDPToPix(paramContext, 48);
    AppMethodBeat.o(120034);
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(120028);
    ImageView localImageView = this.ida;
    if (localImageView == null) {
      k.aPZ("avatarView");
    }
    AppMethodBeat.o(120028);
    return localImageView;
  }
  
  public final com.tencent.mm.plugin.story.f.b.a getComment()
  {
    return this.ytD;
  }
  
  public final ViewGroup getContentLayout()
  {
    AppMethodBeat.i(120030);
    ViewGroup localViewGroup = this.tpf;
    if (localViewGroup == null) {
      k.aPZ("contentLayout");
    }
    AppMethodBeat.o(120030);
    return localViewGroup;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(120026);
    View localView = this.lRB;
    if (localView == null) {
      k.aPZ("maskView");
    }
    AppMethodBeat.o(120026);
    return localView;
  }
  
  public final ValueAnimator getNormalAnimator()
  {
    return this.ytB;
  }
  
  public final ValueAnimator getNormalBgAnimator()
  {
    return this.ytC;
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
    for (this.lRB = ((View)this);; this.lRB = localView1)
    {
      localView1 = findViewById(2131305309);
      k.g(localView1, "findViewById(R.id.story_comment_item_avatar)");
      this.ida = ((ImageView)localView1);
      localView1 = findViewById(2131305313);
      k.g(localView1, "findViewById(R.id.story_…ment_item_content_layout)");
      this.tpf = ((ViewGroup)localView1);
      AppMethodBeat.o(120033);
      return;
    }
  }
  
  public final void setAvatarView(ImageView paramImageView)
  {
    AppMethodBeat.i(120029);
    k.h(paramImageView, "<set-?>");
    this.ida = paramImageView;
    AppMethodBeat.o(120029);
  }
  
  public final void setComment(com.tencent.mm.plugin.story.f.b.a parama)
  {
    AppMethodBeat.i(120032);
    k.h(parama, "<set-?>");
    this.ytD = parama;
    AppMethodBeat.o(120032);
  }
  
  public final void setContentLayout(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120031);
    k.h(paramViewGroup, "<set-?>");
    this.tpf = paramViewGroup;
    AppMethodBeat.o(120031);
  }
  
  public final void setMaskView(View paramView)
  {
    AppMethodBeat.i(120027);
    k.h(paramView, "<set-?>");
    this.lRB = paramView;
    AppMethodBeat.o(120027);
  }
  
  public final void setNormalAnimator(ValueAnimator paramValueAnimator)
  {
    this.ytB = paramValueAnimator;
  }
  
  public final void setNormalBgAnimator(ValueAnimator paramValueAnimator)
  {
    this.ytC = paramValueAnimator;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$ArgbEvaluator;", "Landroid/animation/TypeEvaluator;", "", "()V", "evaluate", "fraction", "", "startValue", "endValue", "plugin-story_release"})
  public static final class a
    implements TypeEvaluator<Object>
  {
    public final Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(120022);
      k.h(paramObject1, "startValue");
      k.h(paramObject2, "endValue");
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$TwoLineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "getDivide", "()Landroid/graphics/PointF;", "smooth", "", "smoothEnd", "smoothStart", "getInterpolation", "input", "plugin-story_release"})
  public static final class c
    implements Interpolator
  {
    private final float ytJ;
    private final PointF ytK;
    private final PointF ytL;
    private final PointF ytM;
    
    public c(PointF paramPointF)
    {
      AppMethodBeat.i(120023);
      this.ytM = paramPointF;
      this.ytJ = 0.2F;
      this.ytK = new PointF(this.ytM.x * (1.0F - this.ytJ), this.ytM.y * (1.0F - this.ytJ));
      this.ytL = new PointF(this.ytM.x + (1.0F - this.ytM.x) * this.ytJ, this.ytM.y + (1.0F - this.ytM.y) * this.ytJ);
      AppMethodBeat.o(120023);
    }
    
    public final float getInterpolation(float paramFloat)
    {
      if (paramFloat < this.ytK.x) {
        return this.ytM.y * paramFloat / this.ytM.x;
      }
      if (paramFloat < this.ytL.x) {
        return this.ytK.y + (paramFloat - this.ytK.x) / (this.ytL.x - this.ytK.x) * (this.ytL.y - this.ytK.y);
      }
      return this.ytM.y + (paramFloat - this.ytM.x) / (1.0F - this.ytM.x) * (1.0F - this.ytM.y);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
      paramValueAnimator = this.ytN.getLayoutParams();
      paramValueAnimator.width = (CommentItemView.c(this.ytN) + (int)((CommentItemView.d(this.ytN) - CommentItemView.c(this.ytN)) * f));
      int i = CommentItemView.c(this.ytN);
      paramValueAnimator.height = ((int)(f * (CommentItemView.e(this.ytN) - CommentItemView.c(this.ytN))) + i);
      this.ytN.setLayoutParams(paramValueAnimator);
      AppMethodBeat.o(120024);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(CommentItemView paramCommentItemView, int paramInt1, int paramInt2, v.e parame, d.g.a.a parama) {}
    
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
      int i = (int)((this.ytO - this.ytP) * (1.0F - f));
      this.ytN.setTranslationY(i);
      if (f < this.ytQ)
      {
        this.ytN.setScaleX(f / this.ytQ);
        this.ytN.setScaleY(f / this.ytQ);
        this.ytN.setAlpha(f / this.ytQ * 0.5F + 0.5F);
      }
      do
      {
        if (i < 100) {
          this.ytN.setAlpha(i / 100.0F);
        }
        if (this.ytN.getAlpha() >= 0.05F) {
          break;
        }
        paramValueAnimator = this.ytN.getNormalAnimator();
        if (paramValueAnimator != null) {
          paramValueAnimator.removeAllUpdateListeners();
        }
        paramValueAnimator = this.ytS;
        if (paramValueAnimator == null) {
          break;
        }
        paramValueAnimator.invoke();
        AppMethodBeat.o(120025);
        return;
        this.ytN.setScaleX(1.0F);
        this.ytN.setScaleY(1.0F);
        this.ytN.setAlpha(1.0F);
        paramValueAnimator = (d.g.a.a)this.ytR.Jhw;
        if (paramValueAnimator != null) {
          paramValueAnimator.invoke();
        }
        this.ytR.Jhw = null;
      } while (CommentItemView.a(this.ytN));
      CommentItemView.b(this.ytN);
      paramValueAnimator = this.ytN;
      long l = 0L;
      Object localObject;
      if (!paramValueAnimator.ytD.ygJ)
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
        localObject = paramValueAnimator.tpf;
        if (localObject == null) {
          k.aPZ("contentLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = paramValueAnimator.tpf;
        if (localObject == null) {
          k.aPZ("contentLayout");
        }
        ((ViewGroup)localObject).setAlpha(0.0F);
        paramValueAnimator = paramValueAnimator.tpf;
        if (paramValueAnimator == null) {
          k.aPZ("contentLayout");
        }
        paramValueAnimator = ObjectAnimator.ofFloat(paramValueAnimator, "alpha", new float[] { 0.0F, 1.0F });
        k.g(paramValueAnimator, "contentLayoutAnim");
        paramValueAnimator.setStartDelay(l);
        paramValueAnimator.setDuration(100L);
        paramValueAnimator.start();
        break;
        localObject = paramValueAnimator.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = paramValueAnimator.ytH;
        ((ViewGroup.LayoutParams)localObject).height = paramValueAnimator.ytG;
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