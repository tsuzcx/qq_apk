package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class VoipMgr$19
  extends PhoneStateListener
{
  VoipMgr$19(VoipMgr paramVoipMgr) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(235631);
    super.onSignalStrengthsChanged(paramSignalStrength);
    super.onSignalStrengthsChanged(paramSignalStrength);
    paramSignalStrength = paramSignalStrength.toString().split(" ");
    try
    {
      if ((VoipMgr.j(this.GYo).getNetworkType() == 13) && (paramSignalStrength.length > 9)) {
        VoipMgr.biH()[0] = Util.safeParseInt(paramSignalStrength[9]);
      }
      AppMethodBeat.o(235631);
      return;
    }
    catch (Exception paramSignalStrength)
    {
      Log.printErrStackTrace("MicroMsg.Voip.VoipMgr", paramSignalStrength, "", new Object[0]);
      AppMethodBeat.o(235631);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.19
 * JD-Core Version:    0.7.0.1
 */