package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class TextPreviewUI$9
  implements View.OnClickListener
{
  TextPreviewUI$9(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(232934);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/chatting/TextPreviewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    TextPreviewUI.m(this.PkZ);
    a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(232934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.9
 * JD-Core Version:    0.7.0.1
 */