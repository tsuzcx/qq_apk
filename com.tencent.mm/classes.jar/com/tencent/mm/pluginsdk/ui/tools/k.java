package com.tencent.mm.pluginsdk.ui.tools;

import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText.b;

public final class k
{
  public static InputFilter[] Ytp;
  
  static
  {
    AppMethodBeat.i(141184);
    Ytp = new InputFilter[] { new InputFilter.LengthFilter(50) };
    AppMethodBeat.o(141184);
  }
  
  public static final class a
    implements TextWatcher
  {
    public MMEditText.b Ytq = null;
    
    public final void afterTextChanged(Editable paramEditable) {}
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(141183);
      if (this.Ytq != null) {
        this.Ytq.bXT();
      }
      AppMethodBeat.o(141183);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */