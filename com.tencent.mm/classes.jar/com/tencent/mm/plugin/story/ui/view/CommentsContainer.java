package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.f.b.u.d;
import a.l;
import a.y;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/CommentsContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "comments", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "currIndex", "isPause", "", "()Z", "setPause", "(Z)V", "isUnread", "setUnread", "itemClickListener", "Lkotlin/Function0;", "", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "nextItemDelay", "", "nextItemDuration", "nextRunnable", "Ljava/lang/Runnable;", "onLoop", "getOnLoop", "setOnLoop", "onLoopRunnable", "random", "Ljava/util/Random;", "animNext", "createDrawable", "Landroid/graphics/drawable/GradientDrawable;", "comment", "getItemView", "Lcom/tencent/mm/plugin/story/ui/view/CommentItemView;", "nextDelay", "nextDuration", "pause", "restart", "resume", "shakeIndex", "index", "update", "storyComments", "", "plugin-story_release"})
public final class CommentsContainer
  extends RelativeLayout
{
  private final String TAG;
  boolean cvo;
  private int eSA;
  private Random random;
  private final ArrayList<com.tencent.mm.plugin.story.model.b.a> sHA;
  private long sLM;
  private long sLN;
  private a.f.a.a<y> sLO;
  private a.f.a.a<y> sLP;
  private final Runnable sLQ;
  private final Runnable sLR;
  private boolean sxy;
  
  public CommentsContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110374);
    AppMethodBeat.o(110374);
  }
  
  public CommentsContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110373);
    this.TAG = "MicroMsg.CommentsContainer";
    this.sHA = new ArrayList();
    this.eSA = -1;
    this.random = new Random();
    this.cvo = true;
    this.sLQ = ((Runnable)new CommentsContainer.c(this));
    this.sLR = ((Runnable)new CommentsContainer.d(this));
    AppMethodBeat.o(110373);
  }
  
  public final a.f.a.a<y> getItemClickListener()
  {
    return this.sLO;
  }
  
  public final a.f.a.a<y> getOnLoop()
  {
    return this.sLP;
  }
  
  public final void i(List<com.tencent.mm.plugin.story.model.b.a> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(151163);
    j.q(paramList, "storyComments");
    this.sxy = paramBoolean;
    this.sHA.clear();
    this.sHA.addAll((Collection)paramList);
    this.eSA = -1;
    this.sLN = 4000L;
    AppMethodBeat.o(151163);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(110372);
    ab.i(this.TAG, "LogStory: pause ".concat(String.valueOf(this)));
    this.cvo = true;
    removeCallbacks(this.sLQ);
    removeCallbacks(this.sLR);
    removeAllViews();
    this.eSA = -1;
    AppMethodBeat.o(110372);
  }
  
  public final void restart()
  {
    AppMethodBeat.i(138896);
    ab.i(this.TAG, "LogStory: restart ".concat(String.valueOf(this)));
    resume();
    AppMethodBeat.o(138896);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(110371);
    ab.i(this.TAG, "LogStory: resume ".concat(String.valueOf(this)));
    this.cvo = false;
    if (this.eSA != 0)
    {
      removeCallbacks(this.sLQ);
      removeCallbacks(this.sLR);
      removeAllViews();
      this.eSA = -1;
      postDelayed(this.sLQ, 300L);
    }
    AppMethodBeat.o(110371);
  }
  
  public final void setItemClickListener(a.f.a.a<y> parama)
  {
    this.sLO = parama;
  }
  
  public final void setOnLoop(a.f.a.a<y> parama)
  {
    this.sLP = parama;
  }
  
  public final void setPause(boolean paramBoolean)
  {
    this.cvo = paramBoolean;
  }
  
  public final void setUnread(boolean paramBoolean)
  {
    this.sxy = paramBoolean;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(CommentsContainer paramCommentsContainer, CommentItemView paramCommentItemView, com.tencent.mm.plugin.story.model.b.a parama, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(110368);
      Object localObject1 = this.sLT.getMaskView();
      Object localObject2 = this.sLS;
      Object localObject3 = this.sLS.getContext();
      j.p(localObject3, "context");
      ((View)localObject1).setBackground((Drawable)CommentsContainer.a((CommentsContainer)localObject2, (Context)localObject3));
      this.sLT.setVisibility(0);
      int i = this.sLT.getMeasuredHeight();
      int j = this.sLH;
      int k = this.sLS.getPaddingBottom();
      CommentsContainer.a(this.sLS, com.tencent.mm.cb.a.ar(this.sLS.getContext(), j - k) * 9L);
      if (CommentsContainer.a(this.sLS) <= 0L) {
        CommentsContainer.a(this.sLS, 4000L);
      }
      localObject1 = this.sLT;
      long l = CommentsContainer.a(this.sLS);
      j = this.sLS.getPaddingBottom();
      k = this.sLH;
      int m = i / 2;
      Object localObject4 = (a.f.a.a)new CommentsContainer.a.1(this);
      localObject2 = (a.f.a.a)new CommentsContainer.a.2(this);
      ((CommentItemView)localObject1).sLA = ((CommentItemView)localObject1).getMeasuredWidth();
      ((CommentItemView)localObject1).sLz = ((CommentItemView)localObject1).getMeasuredHeight();
      localObject3 = ((CommentItemView)localObject1).owk;
      if (localObject3 == null) {
        j.ays("contentLayout");
      }
      ((ViewGroup)localObject3).setVisibility(8);
      localObject3 = ((CommentItemView)localObject1).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject3).height = ((CommentItemView)localObject1).sLy;
      ((ViewGroup.LayoutParams)localObject3).width = ((CommentItemView)localObject1).sLy;
      ((CommentItemView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ab.i("MicroMsg.CommentItemView", "LogStory: animation start " + ((CommentItemView)localObject1).sLy + ", " + ((CommentItemView)localObject1).sLA + ' ' + ((CommentItemView)localObject1).sLz);
      localObject3 = new u.d();
      ((u.d)localObject3).BNq = localObject4;
      localObject4 = new CommentItemView.c(new PointF(0.05F, 0.1F));
      ((CommentItemView)localObject1).sLu = ObjectAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      ValueAnimator localValueAnimator = ((CommentItemView)localObject1).sLu;
      if (localValueAnimator != null) {
        localValueAnimator.setInterpolator((TimeInterpolator)localObject4);
      }
      localObject4 = ((CommentItemView)localObject1).sLu;
      if (localObject4 != null) {
        ((ValueAnimator)localObject4).setDuration(l);
      }
      localObject4 = ((CommentItemView)localObject1).sLu;
      if (localObject4 != null) {
        ((ValueAnimator)localObject4).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new CommentItemView.e((CommentItemView)localObject1, k - m, j, (u.d)localObject3, (a.f.a.a)localObject2));
      }
      localObject1 = ((CommentItemView)localObject1).sLu;
      if (localObject1 != null) {
        ((ValueAnimator)localObject1).start();
      }
      CommentsContainer.b(this.sLS, (com.tencent.mm.cb.a.ar(this.sLS.getContext(), i) + 96) * 6L);
      if (CommentsContainer.d(this.sLS) == CommentsContainer.e(this.sLS).size() - 1)
      {
        CommentsContainer.b(this.sLS, CommentsContainer.a(this.sLS));
        this.sLS.postDelayed(CommentsContainer.f(this.sLS), CommentsContainer.c(this.sLS));
      }
      this.sLS.postDelayed(CommentsContainer.g(this.sLS), CommentsContainer.c(this.sLS));
      AppMethodBeat.o(110368);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentsContainer
 * JD-Core Version:    0.7.0.1
 */