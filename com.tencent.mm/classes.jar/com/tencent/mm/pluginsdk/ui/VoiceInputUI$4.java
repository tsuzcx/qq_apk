package com.tencent.mm.pluginsdk.ui;

import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoiceInputUI$4
  implements VoiceInputFooter.a
{
  VoiceInputUI$4(VoiceInputUI paramVoiceInputUI) {}
  
  public final void dnt()
  {
    AppMethodBeat.i(27610);
    this.vSL.ni(8);
    AppMethodBeat.o(27610);
  }
  
  public final void pe(boolean paramBoolean)
  {
    AppMethodBeat.i(27609);
    if (paramBoolean)
    {
      VoiceInputUI.e(this.vSL).setVisibility(4);
      AppMethodBeat.o(27609);
      return;
    }
    VoiceInputUI.e(this.vSL).setVisibility(0);
    AppMethodBeat.o(27609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputUI.4
 * JD-Core Version:    0.7.0.1
 */