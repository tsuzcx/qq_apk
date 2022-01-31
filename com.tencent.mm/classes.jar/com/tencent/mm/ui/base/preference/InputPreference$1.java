package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class InputPreference$1
  implements View.OnClickListener
{
  InputPreference$1(InputPreference paramInputPreference) {}
  
  public final void onClick(View paramView)
  {
    if ((InputPreference.a(this.vcQ) != null) && (InputPreference.b(this.vcQ) != null) && (InputPreference.b(this.vcQ).getText() != null)) {
      InputPreference.b(this.vcQ).getText().toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.InputPreference.1
 * JD-Core Version:    0.7.0.1
 */