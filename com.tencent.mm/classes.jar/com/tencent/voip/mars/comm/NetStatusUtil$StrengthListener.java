package com.tencent.voip.mars.comm;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetStatusUtil$StrengthListener
  extends PhoneStateListener
{
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(92750);
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (!paramSignalStrength.isGsm())
    {
      NetStatusUtil.access$002(paramSignalStrength.getCdmaDbm());
      AppMethodBeat.o(92750);
      return;
    }
    NetStatusUtil.access$002(paramSignalStrength.getGsmSignalStrength());
    AppMethodBeat.o(92750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.voip.mars.comm.NetStatusUtil.StrengthListener
 * JD-Core Version:    0.7.0.1
 */