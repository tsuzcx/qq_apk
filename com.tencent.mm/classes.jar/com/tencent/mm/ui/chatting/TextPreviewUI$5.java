package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TextPreviewUI$5
  implements View.OnClickListener
{
  TextPreviewUI$5(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31048);
    if (TextPreviewUI.b(this.zCJ) != null) {
      TextPreviewUI.e(this.zCJ.getContext(), TextPreviewUI.k(this.zCJ).toString());
    }
    AppMethodBeat.o(31048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.5
 * JD-Core Version:    0.7.0.1
 */