package com.tencent.thumbplayer.g.a.a;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  extends PhoneStateListener
{
  c$1(c paramc) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(227226);
    super.onSignalStrengthsChanged(paramSignalStrength);
    c.a(this.ahKg, paramSignalStrength);
    AppMethodBeat.o(227226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a.a.c.1
 * JD-Core Version:    0.7.0.1
 */