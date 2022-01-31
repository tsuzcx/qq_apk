package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HardCoderSettingUI$2
  implements View.OnClickListener
{
  HardCoderSettingUI$2(HardCoderSettingUI paramHardCoderSettingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34871);
    HardCoderSettingUI.a(this.AuJ, true);
    this.AuJ.showDialog(1);
    AppMethodBeat.o(34871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.HardCoderSettingUI.2
 * JD-Core Version:    0.7.0.1
 */