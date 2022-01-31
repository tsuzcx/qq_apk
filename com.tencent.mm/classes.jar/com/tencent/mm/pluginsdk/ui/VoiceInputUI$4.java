package com.tencent.mm.pluginsdk.ui;

import android.widget.Button;

final class VoiceInputUI$4
  implements VoiceInputFooter.a
{
  VoiceInputUI$4(VoiceInputUI paramVoiceInputUI) {}
  
  public final void cmC()
  {
    this.sbE.DX(8);
  }
  
  public final void lR(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      VoiceInputUI.e(this.sbE).setVisibility(4);
      return;
    }
    VoiceInputUI.e(this.sbE).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI.4
 * JD-Core Version:    0.7.0.1
 */