package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class VoipMgr$18
  extends PhoneStateListener
{
  VoipMgr$18(VoipMgr paramVoipMgr) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(140156);
    super.onSignalStrengthsChanged(paramSignalStrength);
    super.onSignalStrengthsChanged(paramSignalStrength);
    paramSignalStrength = paramSignalStrength.toString().split(" ");
    try
    {
      if ((VoipMgr.j(this.tyo).getNetworkType() == 13) && (paramSignalStrength.length > 9)) {
        VoipMgr.cNo()[0] = bo.apV(paramSignalStrength[9]);
      }
      AppMethodBeat.o(140156);
      return;
    }
    catch (Exception paramSignalStrength)
    {
      ab.printErrStackTrace("MicroMsg.Voip.VoipMgr", paramSignalStrength, "", new Object[0]);
      AppMethodBeat.o(140156);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.18
 * JD-Core Version:    0.7.0.1
 */