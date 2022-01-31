package com.tencent.mm.plugin.recharge.ui;

import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.sdk.platformtools.bo;

final class MallEditText$a$a$3
  implements Runnable
{
  MallEditText$a$a$3(MallEditText.a.a parama, a parama1) {}
  
  public final void run()
  {
    AppMethodBeat.i(44216);
    MallEditText.a(this.pVF.pVE.pVy, this.pVG);
    if (!bo.isNullOrNil(MallEditText.e(this.pVF.pVE.pVy).name))
    {
      MallEditText.g(this.pVF.pVE.pVy).setText(MallEditText.e(this.pVF.pVE.pVy).name);
      MallEditText.g(this.pVF.pVE.pVy).setVisibility(0);
    }
    for (;;)
    {
      MallEditText.a(this.pVF.pVE.pVy).dismissDropDown();
      AppMethodBeat.o(44216);
      return;
      MallEditText.g(this.pVF.pVE.pVy).setText("");
      MallEditText.g(this.pVF.pVE.pVy).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText.a.a.3
 * JD-Core Version:    0.7.0.1
 */