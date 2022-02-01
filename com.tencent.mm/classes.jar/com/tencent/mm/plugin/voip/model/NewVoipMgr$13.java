package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class NewVoipMgr$13
  extends PhoneStateListener
{
  NewVoipMgr$13(NewVoipMgr paramNewVoipMgr) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(235502);
    super.onSignalStrengthsChanged(paramSignalStrength);
    super.onSignalStrengthsChanged(paramSignalStrength);
    paramSignalStrength = paramSignalStrength.toString().split(" ");
    try
    {
      if ((NewVoipMgr.h(this.GUY).getNetworkType() == 13) && (paramSignalStrength.length > 9)) {
        NewVoipMgr.fGd()[0] = Util.safeParseInt(paramSignalStrength[9]);
      }
      AppMethodBeat.o(235502);
      return;
    }
    catch (Exception paramSignalStrength)
    {
      Log.printErrStackTrace("MicroMsg.Voip.NewVoipMgr", paramSignalStrength, "", new Object[0]);
      AppMethodBeat.o(235502);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.NewVoipMgr.13
 * JD-Core Version:    0.7.0.1
 */