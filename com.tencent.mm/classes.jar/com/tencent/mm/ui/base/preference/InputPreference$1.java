package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class InputPreference$1
  implements View.OnClickListener
{
  InputPreference$1(InputPreference paramInputPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(107195);
    if ((InputPreference.a(this.zrq) != null) && (InputPreference.b(this.zrq) != null))
    {
      if (InputPreference.b(this.zrq).getText() == null)
      {
        InputPreference.a(this.zrq);
        AppMethodBeat.o(107195);
        return;
      }
      InputPreference.a(this.zrq);
      InputPreference.b(this.zrq).getText();
    }
    AppMethodBeat.o(107195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.InputPreference.1
 * JD-Core Version:    0.7.0.1
 */