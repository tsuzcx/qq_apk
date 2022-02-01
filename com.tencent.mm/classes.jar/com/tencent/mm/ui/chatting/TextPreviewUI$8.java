package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class TextPreviewUI$8
  implements View.OnClickListener
{
  TextPreviewUI$8(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(253687);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/chatting/TextPreviewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (TextPreviewUI.b(this.aemj) != null) {
      TextPreviewUI.d(this.aemj.getContext(), TextPreviewUI.m(this.aemj).toString());
    }
    a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(253687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.8
 * JD-Core Version:    0.7.0.1
 */