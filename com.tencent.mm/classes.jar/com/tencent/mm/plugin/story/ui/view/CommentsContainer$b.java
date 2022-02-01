package com.tencent.mm.plugin.story.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class CommentsContainer$b
  implements View.OnClickListener
{
  CommentsContainer$b(CommentsContainer paramCommentsContainer) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(120050);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/CommentsContainer$getItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = this.AYS.getItemClickListener();
    if (paramView != null) {
      paramView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/CommentsContainer$getItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(120050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.CommentsContainer.b
 * JD-Core Version:    0.7.0.1
 */