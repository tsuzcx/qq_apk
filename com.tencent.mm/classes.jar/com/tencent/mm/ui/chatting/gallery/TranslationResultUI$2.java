package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eg;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.d;

final class TranslationResultUI$2
  implements Runnable
{
  TranslationResultUI$2(TranslationResultUI paramTranslationResultUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(138646);
    TranslationResultUI.a(this.zOm, d.decodeFile(TranslationResultUI.b(this.zOm).field_resultFile, null));
    if (TranslationResultUI.c(this.zOm) != null) {
      al.d(new TranslationResultUI.2.1(this));
    }
    AppMethodBeat.o(138646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.TranslationResultUI.2
 * JD-Core Version:    0.7.0.1
 */