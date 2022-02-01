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
    AppMethodBeat.i(221578);
    super.onSignalStrengthsChanged(paramSignalStrength);
    c.a(this.ZFd, paramSignalStrength);
    AppMethodBeat.o(221578);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.g.a.a.c.1
 * JD-Core Version:    0.7.0.1
 */