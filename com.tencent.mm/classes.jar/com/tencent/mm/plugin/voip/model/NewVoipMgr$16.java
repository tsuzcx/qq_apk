package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class NewVoipMgr$16
  extends PhoneStateListener
{
  NewVoipMgr$16(NewVoipMgr paramNewVoipMgr) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(209946);
    super.onSignalStrengthsChanged(paramSignalStrength);
    super.onSignalStrengthsChanged(paramSignalStrength);
    paramSignalStrength = paramSignalStrength.toString().split(" ");
    try
    {
      if ((NewVoipMgr.g(this.Crm).getNetworkType() == 13) && (paramSignalStrength.length > 9)) {
        NewVoipMgr.ezn()[0] = bu.aSB(paramSignalStrength[9]);
      }
      AppMethodBeat.o(209946);
      return;
    }
    catch (Exception paramSignalStrength)
    {
      ae.printErrStackTrace("MicroMsg.Voip.NewVoipMgr", paramSignalStrength, "", new Object[0]);
      AppMethodBeat.o(209946);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.NewVoipMgr.16
 * JD-Core Version:    0.7.0.1
 */