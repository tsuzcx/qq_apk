package com.tencent.mm.ui.base.preference;

import android.widget.RadioButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  int id;
  CharSequence text;
  
  public b(CharSequence paramCharSequence, int paramInt)
  {
    this.text = paramCharSequence;
    this.id = paramInt;
  }
  
  public final void a(RadioButton paramRadioButton)
  {
    AppMethodBeat.i(107144);
    paramRadioButton.setText(this.text);
    paramRadioButton.setId(this.id);
    AppMethodBeat.o(107144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.b
 * JD-Core Version:    0.7.0.1
 */