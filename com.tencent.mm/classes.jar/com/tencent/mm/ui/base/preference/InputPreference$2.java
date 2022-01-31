package com.tencent.mm.ui.base.preference;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class InputPreference$2
  implements TextView.OnEditorActionListener
{
  InputPreference$2(InputPreference paramInputPreference) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107196);
    if ((3 == paramInt) && (InputPreference.a(this.zrq) != null) && (InputPreference.b(this.zrq) != null))
    {
      if (InputPreference.b(this.zrq).getText() == null) {
        InputPreference.a(this.zrq);
      }
      for (;;)
      {
        AppMethodBeat.o(107196);
        return true;
        InputPreference.a(this.zrq);
        InputPreference.b(this.zrq).getText();
      }
    }
    AppMethodBeat.o(107196);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.InputPreference.2
 * JD-Core Version:    0.7.0.1
 */