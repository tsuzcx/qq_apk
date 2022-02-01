package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class VoipMgr$19
  extends PhoneStateListener
{
  VoipMgr$19(VoipMgr paramVoipMgr) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(208352);
    super.onSignalStrengthsChanged(paramSignalStrength);
    super.onSignalStrengthsChanged(paramSignalStrength);
    paramSignalStrength = paramSignalStrength.toString().split(" ");
    try
    {
      if ((VoipMgr.i(this.AEb).getNetworkType() == 13) && (paramSignalStrength.length > 9)) {
        VoipMgr.aKS()[0] = bs.aLy(paramSignalStrength[9]);
      }
      AppMethodBeat.o(208352);
      return;
    }
    catch (Exception paramSignalStrength)
    {
      ac.printErrStackTrace("MicroMsg.Voip.VoipMgr", paramSignalStrength, "", new Object[0]);
      AppMethodBeat.o(208352);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.19
 * JD-Core Version:    0.7.0.1
 */