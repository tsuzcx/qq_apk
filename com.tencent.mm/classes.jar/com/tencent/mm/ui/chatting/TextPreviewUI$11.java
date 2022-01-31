package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.textview.a;

final class TextPreviewUI$11
  implements View.OnClickListener
{
  TextPreviewUI$11(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31055);
    if ((TextPreviewUI.d(this.zCJ) != null) && ((!TextPreviewUI.d(this.zCJ).ANj) || (!TextPreviewUI.d(this.zCJ).ANk)))
    {
      TextPreviewUI.d(this.zCJ).dPQ();
      TextPreviewUI.d(this.zCJ).ANj = true;
      TextPreviewUI.d(this.zCJ).ANk = true;
      TextPreviewUI.d(this.zCJ).dPP();
      AppMethodBeat.o(31055);
      return;
    }
    this.zCJ.finish();
    AppMethodBeat.o(31055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.11
 * JD-Core Version:    0.7.0.1
 */