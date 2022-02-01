package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class CommentsContainer$b
  implements View.OnClickListener
{
  CommentsContainer$b(CommentsContainer paramCommentsContainer) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(120050);
    paramView = this.ytZ.getItemClickListener();
    if (paramView != null)
    {
      paramView.invoke();
      AppMethodBeat.o(120050);
      return;
    }
    AppMethodBeat.o(120050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentsContainer.b
 * JD-Core Version:    0.7.0.1
 */