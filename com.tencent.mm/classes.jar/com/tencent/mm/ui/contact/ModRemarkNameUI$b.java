package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.f;

final class ModRemarkNameUI$b
  implements TextWatcher
{
  private int qFM = 800;
  
  private ModRemarkNameUI$b(ModRemarkNameUI paramModRemarkNameUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(33749);
    this.qFM = f.bO(800, paramEditable.toString());
    if (this.qFM < 0) {
      this.qFM = 0;
    }
    if (ModRemarkNameUI.i(this.Aeo) != null) {
      ModRemarkNameUI.i(this.Aeo).setText(this.qFM);
    }
    ModRemarkNameUI.j(this.Aeo);
    AppMethodBeat.o(33749);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI.b
 * JD-Core Version:    0.7.0.1
 */