package com.tencent.mm.plugin.story.ui.view;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animEndHeight", "animEndWidth", "animStartSize", "appeared", "", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "comment", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "getComment", "()Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "setComment", "(Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;)V", "contentLayout", "Landroid/view/ViewGroup;", "getContentLayout", "()Landroid/view/ViewGroup;", "setContentLayout", "(Landroid/view/ViewGroup;)V", "maskView", "Landroid/view/View;", "getMaskView", "()Landroid/view/View;", "setMaskView", "(Landroid/view/View;)V", "normalAnimator", "Landroid/animation/ValueAnimator;", "getNormalAnimator", "()Landroid/animation/ValueAnimator;", "setNormalAnimator", "(Landroid/animation/ValueAnimator;)V", "normalBgAnimator", "getNormalBgAnimator", "setNormalBgAnimator", "backgroundAnimation", "", "contentAnimation", "enterListAnimation", "order", "isAppearAnimEnd", "normalAnimation", "duration", "", "transStart", "transEnd", "onAppear", "Lkotlin/Function0;", "onAnimateEnd", "onFinishInflate", "shakeAnimation", "stopAnimation", "ArgbEvaluator", "Companion", "TwoLineInterpolator", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CommentItemView
  extends LinearLayout
{
  public static final CommentItemView.b SwJ;
  public ViewGroup KGL;
  private ValueAnimator SwK;
  private ValueAnimator SwL;
  private com.tencent.mm.plugin.story.model.b.a SwM;
  private boolean SwN;
  private int SwO;
  private int SwP;
  private int SwQ;
  public View maskView;
  public ImageView pKM;
  
  static
  {
    AppMethodBeat.i(120036);
    SwJ = new CommentItemView.b((byte)0);
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
    this.SwM = new com.tencent.mm.plugin.story.model.b.a();
    this.SwO = com.tencent.mm.cd.a.fromDPToPix(paramContext, 48);
    AppMethodBeat.o(120034);
  }
  
  private static final void a(int paramInt1, int paramInt2, CommentItemView paramCommentItemView, float paramFloat, ah.f paramf, kotlin.g.a.a parama, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(367433);
    s.u(paramCommentItemView, "this$0");
    s.u(paramf, "$appear");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramCommentItemView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(367433);
      throw paramCommentItemView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramInt1 = (int)((paramInt1 - paramInt2) * (1.0F - f));
    paramCommentItemView.setTranslationY(paramInt1);
    if (f < paramFloat)
    {
      paramCommentItemView.setScaleX(f / paramFloat);
      paramCommentItemView.setScaleY(f / paramFloat);
      paramCommentItemView.setAlpha(f / paramFloat * 0.5F + 0.5F);
    }
    do
    {
      if (paramInt1 < 100) {
        paramCommentItemView.setAlpha(paramInt1 / 100.0F);
      }
      if (paramCommentItemView.getAlpha() < 0.05F)
      {
        paramCommentItemView = paramCommentItemView.getNormalAnimator();
        if (paramCommentItemView != null) {
          paramCommentItemView.removeAllUpdateListeners();
        }
        if (parama != null) {
          parama.invoke();
        }
      }
      AppMethodBeat.o(367433);
      return;
      paramCommentItemView.setScaleX(1.0F);
      paramCommentItemView.setScaleY(1.0F);
      paramCommentItemView.setAlpha(1.0F);
      paramValueAnimator = (kotlin.g.a.a)paramf.aqH;
      if (paramValueAnimator != null) {
        paramValueAnimator.invoke();
      }
      paramf.aqH = null;
    } while (paramCommentItemView.SwN);
    paramCommentItemView.SwN = true;
    long l = 0L;
    if (!paramCommentItemView.SwM.Slz)
    {
      paramf = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      paramf.addUpdateListener(new CommentItemView..ExternalSyntheticLambda1(paramCommentItemView));
      l = 300L;
      paramf.setDuration(300L);
      paramf.start();
    }
    for (;;)
    {
      paramCommentItemView.getContentLayout().setVisibility(0);
      paramCommentItemView.getContentLayout().setAlpha(0.0F);
      paramf = ObjectAnimator.ofFloat(paramCommentItemView.getContentLayout(), "alpha", new float[] { 0.0F, 1.0F });
      paramf.setStartDelay(l);
      paramf.setDuration(100L);
      paramf.start();
      break;
      paramf = paramCommentItemView.getLayoutParams();
      paramf.width = paramCommentItemView.SwQ;
      paramf.height = paramCommentItemView.SwP;
      paramCommentItemView.setLayoutParams(paramf);
    }
  }
  
  private static final void a(CommentItemView paramCommentItemView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(367438);
    s.u(paramCommentItemView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramCommentItemView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(367438);
      throw paramCommentItemView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramValueAnimator = paramCommentItemView.getLayoutParams();
    paramValueAnimator.width = (paramCommentItemView.SwO + (int)((paramCommentItemView.SwQ - paramCommentItemView.SwO) * f));
    int i = paramCommentItemView.SwO;
    paramValueAnimator.height = ((int)(f * (paramCommentItemView.SwP - paramCommentItemView.SwO)) + i);
    paramCommentItemView.setLayoutParams(paramValueAnimator);
    AppMethodBeat.o(367438);
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, kotlin.g.a.a<ah> parama1, kotlin.g.a.a<ah> parama2)
  {
    AppMethodBeat.i(367498);
    this.SwQ = getMeasuredWidth();
    this.SwP = getMeasuredHeight();
    getContentLayout().setVisibility(8);
    Object localObject = getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = this.SwO;
    ((ViewGroup.LayoutParams)localObject).width = this.SwO;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    Log.i("MicroMsg.CommentItemView", "LogStory: animation start " + this.SwO + ", " + this.SwQ + ' ' + this.SwP);
    localObject = new ah.f();
    ((ah.f)localObject).aqH = parama1;
    parama1 = new CommentItemView.c(new PointF(0.05F, 0.1F));
    this.SwK = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ValueAnimator localValueAnimator = this.SwK;
    if (localValueAnimator != null) {
      localValueAnimator.setInterpolator((TimeInterpolator)parama1);
    }
    parama1 = this.SwK;
    if (parama1 != null) {
      parama1.setDuration(paramLong);
    }
    parama1 = this.SwK;
    if (parama1 != null) {
      parama1.addUpdateListener(new CommentItemView..ExternalSyntheticLambda0(paramInt2, paramInt1, this, 0.1F, (ah.f)localObject, parama2));
    }
    parama1 = this.SwK;
    if (parama1 != null) {
      parama1.start();
    }
    AppMethodBeat.o(367498);
  }
  
  public final ImageView getAvatarView()
  {
    AppMethodBeat.i(120028);
    ImageView localImageView = this.pKM;
    if (localImageView != null)
    {
      AppMethodBeat.o(120028);
      return localImageView;
    }
    s.bIx("avatarView");
    AppMethodBeat.o(120028);
    return null;
  }
  
  public final com.tencent.mm.plugin.story.model.b.a getComment()
  {
    return this.SwM;
  }
  
  public final ViewGroup getContentLayout()
  {
    AppMethodBeat.i(120030);
    ViewGroup localViewGroup = this.KGL;
    if (localViewGroup != null)
    {
      AppMethodBeat.o(120030);
      return localViewGroup;
    }
    s.bIx("contentLayout");
    AppMethodBeat.o(120030);
    return null;
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(120026);
    View localView = this.maskView;
    if (localView != null)
    {
      AppMethodBeat.o(120026);
      return localView;
    }
    s.bIx("maskView");
    AppMethodBeat.o(120026);
    return null;
  }
  
  public final ValueAnimator getNormalAnimator()
  {
    return this.SwK;
  }
  
  public final ValueAnimator getNormalBgAnimator()
  {
    return this.SwL;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(120033);
    super.onFinishInflate();
    View localView2 = findViewById(a.d.Sej);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = findViewById(a.d.Seq);
    }
    if (localView1 == null) {
      setMaskView((View)this);
    }
    for (;;)
    {
      localView1 = findViewById(a.d.SeC);
      s.s(localView1, "findViewById(R.id.story_comment_item_avatar)");
      setAvatarView((ImageView)localView1);
      localView1 = findViewById(a.d.SeG);
      s.s(localView1, "findViewById(R.id.story_…ment_item_content_layout)");
      setContentLayout((ViewGroup)localView1);
      AppMethodBeat.o(120033);
      return;
      setMaskView(localView1);
    }
  }
  
  public final void setAvatarView(ImageView paramImageView)
  {
    AppMethodBeat.i(120029);
    s.u(paramImageView, "<set-?>");
    this.pKM = paramImageView;
    AppMethodBeat.o(120029);
  }
  
  public final void setComment(com.tencent.mm.plugin.story.model.b.a parama)
  {
    AppMethodBeat.i(120032);
    s.u(parama, "<set-?>");
    this.SwM = parama;
    AppMethodBeat.o(120032);
  }
  
  public final void setContentLayout(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(120031);
    s.u(paramViewGroup, "<set-?>");
    this.KGL = paramViewGroup;
    AppMethodBeat.o(120031);
  }
  
  public final void setMaskView(View paramView)
  {
    AppMethodBeat.i(120027);
    s.u(paramView, "<set-?>");
    this.maskView = paramView;
    AppMethodBeat.o(120027);
  }
  
  public final void setNormalAnimator(ValueAnimator paramValueAnimator)
  {
    this.SwK = paramValueAnimator;
  }
  
  public final void setNormalBgAnimator(ValueAnimator paramValueAnimator)
  {
    this.SwL = paramValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentItemView
 * JD-Core Version:    0.7.0.1
 */