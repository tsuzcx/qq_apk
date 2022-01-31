package com.tencent.mm.plugin.story.ui.view;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.az;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.plugin.story.model.d.f;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class StoryCommentView$12
  implements View.OnClickListener
{
  StoryCommentView$12(StoryCommentView paramStoryCommentView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138913);
    if (!StoryCommentView.c(this.sMZ).rPQ.isEmpty())
    {
      if (StoryCommentView.a(this.sMZ) == 3)
      {
        this.sMZ.oq(2);
        paramView = i.sFa;
        i.FU(1);
        AppMethodBeat.o(138913);
        return;
      }
      this.sMZ.oq(3);
      paramView = i.sFa;
      i.FU(2);
      paramView = i.sFa;
      i.cDs().cC(4L);
      paramView = i.sFa;
      i.cDs().gm(String.valueOf(StoryCommentView.n(this.sMZ)));
      paramView = i.sFa;
      i.cDt();
    }
    AppMethodBeat.o(138913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryCommentView.12
 * JD-Core Version:    0.7.0.1
 */