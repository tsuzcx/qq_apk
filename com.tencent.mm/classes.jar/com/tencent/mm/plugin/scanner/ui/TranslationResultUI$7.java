package com.tencent.mm.plugin.scanner.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.p.a;

final class TranslationResultUI$7
  implements p.a
{
  TranslationResultUI$7(TranslationResultUI paramTranslationResultUI) {}
  
  public final void bF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213710);
    Toast.makeText(this.yva, this.yva.getString(2131760319, new Object[] { paramString2 }), 1).show();
    AppMethodBeat.o(213710);
  }
  
  public final void bG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(213711);
    Toast.makeText(this.yva, this.yva.getString(2131762779), 1).show();
    AppMethodBeat.o(213711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.TranslationResultUI.7
 * JD-Core Version:    0.7.0.1
 */