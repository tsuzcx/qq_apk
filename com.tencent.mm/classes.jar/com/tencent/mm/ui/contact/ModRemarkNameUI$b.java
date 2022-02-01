package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.g;

final class ModRemarkNameUI$b
  implements TextWatcher
{
  private int JeB = 800;
  
  private ModRemarkNameUI$b(ModRemarkNameUI paramModRemarkNameUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(37869);
    this.JeB = g.dq(800, paramEditable.toString());
    if (this.JeB < 0) {
      this.JeB = 0;
    }
    if (ModRemarkNameUI.i(this.Xug) != null) {
      ModRemarkNameUI.i(this.Xug).setText(this.JeB);
    }
    ModRemarkNameUI.b(this.Xug);
    AppMethodBeat.o(37869);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI.b
 * JD-Core Version:    0.7.0.1
 */