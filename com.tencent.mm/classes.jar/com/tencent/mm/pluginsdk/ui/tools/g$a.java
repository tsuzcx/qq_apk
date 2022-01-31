package com.tencent.mm.pluginsdk.ui.tools;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText.b;

public final class g$a
  implements TextWatcher
{
  public MMEditText.b wff = null;
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(105867);
    if (this.wff != null) {
      this.wff.are();
    }
    AppMethodBeat.o(105867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g.a
 * JD-Core Version:    0.7.0.1
 */