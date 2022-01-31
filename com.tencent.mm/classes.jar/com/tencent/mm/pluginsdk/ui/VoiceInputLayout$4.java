package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.sdk.platformtools.am.a;

final class VoiceInputLayout$4
  implements am.a
{
  VoiceInputLayout$4(VoiceInputLayout paramVoiceInputLayout) {}
  
  public final boolean tC()
  {
    if (VoiceInputLayout.b(this.sbr) == null) {}
    int i;
    do
    {
      return true;
      i = VoiceInputLayout.b(this.sbr).getMaxAmplitudeRate();
    } while (this.sbr.kFU != 2);
    this.sbr.rH(i);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.VoiceInputLayout.4
 * JD-Core Version:    0.7.0.1
 */