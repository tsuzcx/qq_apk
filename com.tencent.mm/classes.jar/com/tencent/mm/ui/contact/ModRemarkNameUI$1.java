package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.widget.MMEditText.b;

final class ModRemarkNameUI$1
  implements MMEditText.b
{
  ModRemarkNameUI$1(ModRemarkNameUI paramModRemarkNameUI) {}
  
  public final void bzd()
  {
    AppMethodBeat.i(37864);
    if (ModRemarkNameUI.a(this.Xug).getText().toString().trim().length() > 0) {
      this.Xug.enableOptionMenu(true);
    }
    AppMethodBeat.o(37864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI.1
 * JD-Core Version:    0.7.0.1
 */