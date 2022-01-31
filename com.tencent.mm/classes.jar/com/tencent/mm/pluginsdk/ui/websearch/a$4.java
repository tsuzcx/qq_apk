package com.tencent.mm.pluginsdk.ui.websearch;

import android.telephony.PhoneStateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.sdk.platformtools.ab;

final class a$4
  extends PhoneStateListener
{
  a$4(a parama) {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    AppMethodBeat.i(28243);
    super.onCallStateChanged(paramInt, paramString);
    int i = -1;
    if (a.f(this.wgr) != null) {
      i = a.f(this.wgr).getCurrentState();
    }
    ab.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    a.f(this.wgr);
    if (i != 2)
    {
      AppMethodBeat.o(28243);
      return;
    }
    this.wgr.pause();
    AppMethodBeat.o(28243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.a.4
 * JD-Core Version:    0.7.0.1
 */