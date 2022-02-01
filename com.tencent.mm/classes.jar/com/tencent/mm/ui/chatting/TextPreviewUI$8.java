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
    AppMethodBeat.i(232933);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/chatting/TextPreviewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (TextPreviewUI.b(this.PkZ) != null) {
      TextPreviewUI.e(this.PkZ.getContext(), TextPreviewUI.l(this.PkZ).toString());
    }
    a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(232933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.8
 * JD-Core Version:    0.7.0.1
 */