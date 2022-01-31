package com.tencent.mm.pluginsdk.ui.chat;

import android.telephony.PhoneStateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.sdk.platformtools.ab;

final class n$b
  extends PhoneStateListener
{
  VoiceInputLayout vZn;
  
  public n$b(VoiceInputLayout paramVoiceInputLayout)
  {
    this.vZn = paramVoiceInputLayout;
  }
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(27984);
    super.onCallStateChanged(paramInt, paramString);
    int i = -1;
    if (this.vZn != null)
    {
      i = this.vZn.getCurrentState();
      this.vZn.amT();
    }
    ab.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    if (i != 2)
    {
      AppMethodBeat.o(27984);
      return;
    }
    AppMethodBeat.o(27984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.b
 * JD-Core Version:    0.7.0.1
 */