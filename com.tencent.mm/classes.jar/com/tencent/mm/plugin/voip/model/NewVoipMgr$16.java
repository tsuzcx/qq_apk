package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class NewVoipMgr$16
  extends PhoneStateListener
{
  NewVoipMgr$16(NewVoipMgr paramNewVoipMgr) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(208235);
    super.onSignalStrengthsChanged(paramSignalStrength);
    super.onSignalStrengthsChanged(paramSignalStrength);
    paramSignalStrength = paramSignalStrength.toString().split(" ");
    try
    {
      if ((NewVoipMgr.g(this.AAM).getNetworkType() == 13) && (paramSignalStrength.length > 9)) {
        NewVoipMgr.ehV()[0] = bs.aLy(paramSignalStrength[9]);
      }
      AppMethodBeat.o(208235);
      return;
    }
    catch (Exception paramSignalStrength)
    {
      ac.printErrStackTrace("MicroMsg.Voip.NewVoipMgr", paramSignalStrength, "", new Object[0]);
      AppMethodBeat.o(208235);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.NewVoipMgr.16
 * JD-Core Version:    0.7.0.1
 */