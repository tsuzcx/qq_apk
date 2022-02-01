package com.tencent.mm.plugin.scanner.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.p.a;

final class TranslationResultUI$7
  implements p.a
{
  TranslationResultUI$7(TranslationResultUI paramTranslationResultUI) {}
  
  public final void bv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190950);
    Toast.makeText(this.vWm, this.vWm.getString(2131760319, new Object[] { paramString2 }), 1).show();
    AppMethodBeat.o(190950);
  }
  
  public final void bw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190951);
    Toast.makeText(this.vWm, this.vWm.getString(2131762779), 1).show();
    AppMethodBeat.o(190951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.TranslationResultUI.7
 * JD-Core Version:    0.7.0.1
 */