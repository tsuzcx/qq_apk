package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HardCoderSettingUI$3
  implements View.OnClickListener
{
  HardCoderSettingUI$3(HardCoderSettingUI paramHardCoderSettingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34872);
    HardCoderSettingUI.a(this.AuJ, false);
    this.AuJ.showDialog(1);
    AppMethodBeat.o(34872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.HardCoderSettingUI.3
 * JD-Core Version:    0.7.0.1
 */