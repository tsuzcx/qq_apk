package com.tencent.mm.plugin.story.ui.view;

import a.f.a.a;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class CommentsContainer$b
  implements View.OnClickListener
{
  CommentsContainer$b(CommentsContainer paramCommentsContainer) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138894);
    paramView = this.sLS.getItemClickListener();
    if (paramView != null)
    {
      paramView.invoke();
      AppMethodBeat.o(138894);
      return;
    }
    AppMethodBeat.o(138894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentsContainer.b
 * JD-Core Version:    0.7.0.1
 */