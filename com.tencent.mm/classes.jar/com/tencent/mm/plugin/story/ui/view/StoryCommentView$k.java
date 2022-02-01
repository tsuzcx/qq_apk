package com.tencent.mm.plugin.story.ui.view;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class StoryCommentView$k
  implements Runnable
{
  StoryCommentView$k(StoryCommentView paramStoryCommentView) {}
  
  public final void run()
  {
    AppMethodBeat.i(120158);
    StoryCommentView.h(this.FCE).FxL = false;
    Log.i(StoryCommentView.access$getTAG$cp(), "LogStory: comment recycler count is " + StoryCommentView.f(this.FCE).getChildCount());
    int j = StoryCommentView.f(this.FCE).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = StoryCommentView.f(this.FCE).getChildAt(i);
      if ((localObject instanceof CommentItemView))
      {
        localObject = (CommentItemView)localObject;
        int k = StoryCommentView.f(this.FCE).getChildCount() - i;
        long l = k * 30L;
        float f = (k + 1) * a.fromDPToPix(((CommentItemView)localObject).getContext(), 16);
        ((CommentItemView)localObject).setAlpha(0.0F);
        ((CommentItemView)localObject).setTranslationY(f);
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { f, 0.0F });
        p.g(localObjectAnimator, "transAnim");
        localObjectAnimator.setDuration(150L);
        localObjectAnimator.setStartDelay(l);
        localObjectAnimator.start();
        localObject = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 1.0F });
        p.g(localObject, "alphaAnim");
        ((ObjectAnimator)localObject).setDuration(150L);
        ((ObjectAnimator)localObject).setStartDelay(l);
        ((ObjectAnimator)localObject).start();
      }
      i += 1;
    }
    AppMethodBeat.o(120158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.k
 * JD-Core Version:    0.7.0.1
 */