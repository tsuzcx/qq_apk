package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class TextPreviewUI$6
  implements View.OnClickListener
{
  TextPreviewUI$6(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34935);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/chatting/TextPreviewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (TextPreviewUI.b(this.JEM) != null) {
      TextPreviewUI.e(this.JEM.getContext(), TextPreviewUI.k(this.JEM).toString());
    }
    a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(34935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.6
 * JD-Core Version:    0.7.0.1
 */