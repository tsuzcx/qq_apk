package com.tencent.mm.ui.base.preference;

import android.widget.RadioButton;

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
    paramRadioButton.setText(this.text);
    paramRadioButton.setId(this.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.b
 * JD-Core Version:    0.7.0.1
 */