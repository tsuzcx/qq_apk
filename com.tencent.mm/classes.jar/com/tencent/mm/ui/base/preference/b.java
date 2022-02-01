package com.tencent.mm.ui.base.preference;

import android.widget.RadioButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  CharSequence bba;
  int id;
  
  public b(CharSequence paramCharSequence, int paramInt)
  {
    this.bba = paramCharSequence;
    this.id = paramInt;
  }
  
  public final void a(RadioButton paramRadioButton)
  {
    AppMethodBeat.i(142521);
    paramRadioButton.setText(this.bba);
    paramRadioButton.setId(this.id);
    AppMethodBeat.o(142521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.b
 * JD-Core Version:    0.7.0.1
 */