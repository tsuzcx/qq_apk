package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.textview.a;

final class TextPreviewUI$9$1
  implements Runnable
{
  TextPreviewUI$9$1(TextPreviewUI.9 param9) {}
  
  public final void run()
  {
    AppMethodBeat.i(31052);
    if (TextPreviewUI.d(this.zCL.zCJ) != null) {
      TextPreviewUI.d(this.zCL.zCJ).dPW();
    }
    AppMethodBeat.o(31052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.9.1
 * JD-Core Version:    0.7.0.1
 */