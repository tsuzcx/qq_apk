package com.tencent.mm.ui.base.preference;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class InputPreference$2
  implements TextView.OnEditorActionListener
{
  InputPreference$2(InputPreference paramInputPreference) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((3 == paramInt) && (InputPreference.a(this.vcQ) != null) && (InputPreference.b(this.vcQ) != null))
    {
      if (InputPreference.b(this.vcQ).getText() != null) {
        InputPreference.b(this.vcQ).getText().toString();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.InputPreference.2
 * JD-Core Version:    0.7.0.1
 */