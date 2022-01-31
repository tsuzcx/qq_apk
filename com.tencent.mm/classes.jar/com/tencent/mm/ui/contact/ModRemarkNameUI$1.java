package com.tencent.mm.ui.contact;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText.b;

final class ModRemarkNameUI$1
  implements MMEditText.b
{
  ModRemarkNameUI$1(ModRemarkNameUI paramModRemarkNameUI) {}
  
  public final void are()
  {
    AppMethodBeat.i(33744);
    if (ModRemarkNameUI.a(this.Aeo).getText().toString().trim().length() > 0) {
      this.Aeo.enableOptionMenu(true);
    }
    AppMethodBeat.o(33744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI.1
 * JD-Core Version:    0.7.0.1
 */