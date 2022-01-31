package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.l;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animEndHeight", "animEndWidth", "animStartSize", "appeared", "", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getComment", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "setComment", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "contentLayout", "Landroid/view/ViewGroup;", "getContentLayout", "()Landroid/view/ViewGroup;", "setContentLayout", "(Landroid/view/ViewGroup;)V", "maskView", "Landroid/view/View;", "getMaskView", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "normalAnimator", "Landroid/animation/ValueAnimator;", "getNormalAnimator", "()Landroid/animation/ValueAnimator;", "setNormalAnimator", "(Landroid/animation/ValueAnimator;)V", "normalBgAnimator", "getNormalBgAnimator", "setNormalBgAnimator", "backgroundAnimation", "", "contentAnimation", "enterListAnimation", "order", "isAppearAnimEnd", "normalAnimation", "duration", "", "transStart", "transEnd", "onAppear", "Lkotlin/Function0;", "onAnimateEnd", "onFinishInflate", "shakeAnimation", "stopAnimation", "ArgbEvaluator", "Companion", "TwoLineInterpolator", "plugin-story_release"})
public final class CommentItemView
  extends LinearLayout
{
  public static final CommentItemView.b sLB;
  public ImageView gqF;
  public View jbK;
  public ViewGroup owk;
  int sLA;
  ValueAnimator sLu;
  private ValueAnimator sLv;
  com.tencent.mm.plugin.story.model.b.a sLw;
  private boolean sLx;
  int sLy;
  int sLz;
  
  static
  {
    AppMethodBeat.i(110356);
    sLB = new CommentItemView.b((byte)0);
    AppMethodBeat.o(110356);
  }
  
  public CommentItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110355);
    AppMethodBeat.o(110355);
  }
  
  public CommentItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110354);
    this.sLw = new com.tencent.mm.plugin.story.model.b.a();
    this.sLy = com.tencent.mm.cb.a.fromDPToPix(paramContext, 48);
    AppMethodBeat.o(110354);
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(110348);
    ImageView localImageView = this.gqF;
    if (localImageView == null) {
      j.ays("avatarView");
    }
    AppMethodBeat.o(110348);
    return localImageView;
  }
  
  public final com.tencent.mm.plugin.story.model.b.a getComment()
  {
    return this.sLw;
  }
  
  public final ViewGroup getContentLayout()
  {
    AppMethodBeat.i(110350);
    ViewGroup localViewGroup = this.owk;
    if (localViewGroup == null) {
      j.ays("contentLayout");
    }
    AppMethodBeat.o(110350);
    return localViewGroup;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(110346);
    View localView = this.jbK;
    if (localView == null) {
      j.ays("maskView");
    }
    AppMethodBeat.o(110346);
    return localView;
  }
  
  public final ValueAnimator getNormalAnimator()
  {
    return this.sLu;
  }
  
  public final ValueAnimator getNormalBgAnimator()
  {
    return this.sLv;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(110353);
    super.onFinishInflate();
    View localView2 = findViewById(2131828323);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = findViewById(2131828316);
    }
    if (localView1 == null) {}
    for (this.jbK = ((View)this);; this.jbK = localView1)
    {
      localView1 = findViewById(2131828317);
      j.p(localView1, "findViewById(R.id.story_comment_item_avatar)");
      this.gqF = ((ImageView)localView1);
      localView1 = findViewById(2131828318);
      j.p(localView1, "findViewById(R.id.story_…ment_item_content_layout)");
      this.owk = ((ViewGroup)localView1);
      AppMethodBeat.o(110353);
      return;
    }
  }
  
  public final void setAvatarView(ImageView paramImageView)
  {
    AppMethodBeat.i(110349);
    j.q(paramImageView, "<set-?>");
    this.gqF = paramImageView;
    AppMethodBeat.o(110349);
  }
  
  public final void setComment(com.tencent.mm.plugin.story.model.b.a parama)
  {
    AppMethodBeat.i(110352);
    j.q(parama, "<set-?>");
    this.sLw = parama;
    AppMethodBeat.o(110352);
  }
  
  public final void setContentLayout(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(110351);
    j.q(paramViewGroup, "<set-?>");
    this.owk = paramViewGroup;
    AppMethodBeat.o(110351);
  }
  
  public final void setMaskView(View paramView)
  {
    AppMethodBeat.i(110347);
    j.q(paramView, "<set-?>");
    this.jbK = paramView;
    AppMethodBeat.o(110347);
  }
  
  public final void setNormalAnimator(ValueAnimator paramValueAnimator)
  {
    this.sLu = paramValueAnimator;
  }
  
  public final void setNormalBgAnimator(ValueAnimator paramValueAnimator)
  {
    this.sLv = paramValueAnimator;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView$TwoLineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "getDivide", "()Landroid/graphics/PointF;", "smooth", "", "smoothEnd", "smoothStart", "getInterpolation", "input", "plugin-story_release"})
  public static final class c
    implements Interpolator
  {
    private final float sLC;
    private final PointF sLD;
    private final PointF sLE;
    private final PointF sLF;
    
    public c(PointF paramPointF)
    {
      AppMethodBeat.i(110343);
      this.sLF = paramPointF;
      this.sLC = 0.2F;
      this.sLD = new PointF(this.sLF.x * (1.0F - this.sLC), this.sLF.y * (1.0F - this.sLC));
      this.sLE = new PointF(this.sLF.x + (1.0F - this.sLF.x) * this.sLC, this.sLF.y + (1.0F - this.sLF.y) * this.sLC);
      AppMethodBeat.o(110343);
    }
    
    public final float getInterpolation(float paramFloat)
    {
      if (paramFloat < this.sLD.x) {
        return this.sLF.y * paramFloat / this.sLF.x;
      }
      if (paramFloat < this.sLE.x) {
        return this.sLD.y + (paramFloat - this.sLD.x) / (this.sLE.x - this.sLD.x) * (this.sLE.y - this.sLD.y);
      }
      return this.sLF.y + (paramFloat - this.sLF.x) / (1.0F - this.sLF.x) * (1.0F - this.sLF.y);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentItemView
 * JD-Core Version:    0.7.0.1
 */