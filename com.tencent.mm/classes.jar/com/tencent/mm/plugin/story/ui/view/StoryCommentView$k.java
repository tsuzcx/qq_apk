package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.l;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class StoryCommentView$k
  implements Runnable
{
  StoryCommentView$k(StoryCommentView paramStoryCommentView) {}
  
  public final void run()
  {
    AppMethodBeat.i(151197);
    StoryCommentView.h(this.sMZ).sIu = false;
    ab.i(StoryCommentView.access$getTAG$cp(), "LogStory: comment recycler count is " + StoryCommentView.f(this.sMZ).getChildCount());
    int j = StoryCommentView.f(this.sMZ).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = StoryCommentView.f(this.sMZ).getChildAt(i);
      if ((localObject instanceof CommentItemView))
      {
        localObject = (CommentItemView)localObject;
        int k = StoryCommentView.f(this.sMZ).getChildCount() - i;
        long l = k * 30L;
        float f = (k + 1) * a.fromDPToPix(((CommentItemView)localObject).getContext(), 16);
        ((CommentItemView)localObject).setAlpha(0.0F);
        ((CommentItemView)localObject).setTranslationY(f);
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { f, 0.0F });
        j.p(localObjectAnimator, "transAnim");
        localObjectAnimator.setDuration(150L);
        localObjectAnimator.setStartDelay(l);
        localObjectAnimator.start();
        localObject = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 1.0F });
        j.p(localObject, "alphaAnim");
        ((ObjectAnimator)localObject).setDuration(150L);
        ((ObjectAnimator)localObject).setStartDelay(l);
        ((ObjectAnimator)localObject).start();
      }
      i += 1;
    }
    AppMethodBeat.o(151197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.k
 * JD-Core Version:    0.7.0.1
 */