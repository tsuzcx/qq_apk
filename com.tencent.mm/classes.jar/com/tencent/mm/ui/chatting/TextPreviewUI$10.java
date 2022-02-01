package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class TextPreviewUI$10
  implements View.OnClickListener
{
  TextPreviewUI$10(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(232935);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/chatting/TextPreviewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    TextPreviewUI.b(this.PkZ, TextPreviewUI.b(this.PkZ));
    a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(232935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.10
 * JD-Core Version:    0.7.0.1
 */