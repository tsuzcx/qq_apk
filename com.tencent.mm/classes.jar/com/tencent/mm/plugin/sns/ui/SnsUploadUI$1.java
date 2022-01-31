package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.KeyboardLinearLayout.a;

final class SnsUploadUI$1
  implements KeyboardLinearLayout.a
{
  SnsUploadUI$1(SnsUploadUI paramSnsUploadUI) {}
  
  public final void rD(int paramInt)
  {
    if (paramInt == -3)
    {
      y.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_SHOW");
      new ah().postDelayed(new SnsUploadUI.1.1(this), 100L);
      return;
    }
    new ah().postDelayed(new SnsUploadUI.1.2(this), 200L);
    y.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_HIDE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.1
 * JD-Core Version:    0.7.0.1
 */