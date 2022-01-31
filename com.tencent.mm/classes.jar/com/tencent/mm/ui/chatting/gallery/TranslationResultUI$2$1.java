package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class TranslationResultUI$2$1
  implements Runnable
{
  TranslationResultUI$2$1(TranslationResultUI.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(138645);
    TranslationResultUI.d(this.zOn.zOm).bitmap = TranslationResultUI.c(this.zOn.zOm);
    TranslationResultUI.d(this.zOn.zOm).notifyDataSetChanged();
    AppMethodBeat.o(138645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.TranslationResultUI.2.1
 * JD-Core Version:    0.7.0.1
 */