package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.KeyboardLinearLayout.a;

final class SnsUploadUI$1
  implements KeyboardLinearLayout.a
{
  SnsUploadUI$1(SnsUploadUI paramSnsUploadUI) {}
  
  public final void sJ(int paramInt)
  {
    AppMethodBeat.i(39737);
    if (paramInt == -3)
    {
      ab.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_SHOW");
      new ak().postDelayed(new SnsUploadUI.1.1(this), 100L);
      AppMethodBeat.o(39737);
      return;
    }
    new ak().postDelayed(new SnsUploadUI.1.2(this), 200L);
    ab.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_HIDE");
    AppMethodBeat.o(39737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.1
 * JD-Core Version:    0.7.0.1
 */