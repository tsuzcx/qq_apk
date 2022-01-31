package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ModRemarkNameUI$4
  implements View.OnClickListener
{
  ModRemarkNameUI$4(ModRemarkNameUI paramModRemarkNameUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33747);
    ModRemarkNameUI.f(this.Aeo).setVisibility(0);
    ModRemarkNameUI.g(this.Aeo).setVisibility(8);
    ModRemarkNameUI.h(this.Aeo).requestFocus();
    this.Aeo.showVKB();
    AppMethodBeat.o(33747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI.4
 * JD-Core Version:    0.7.0.1
 */