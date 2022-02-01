package com.tencent.mm.plugin.topstory.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class TopStoryCommentFloatDialog$8
  implements View.OnClickListener
{
  TopStoryCommentFloatDialog$8(TopStoryCommentFloatDialog paramTopStoryCommentFloatDialog) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(126656);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.TQC.getVisibility() == 0) {
      this.TQC.hide();
    }
    a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(126656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog.8
 * JD-Core Version:    0.7.0.1
 */