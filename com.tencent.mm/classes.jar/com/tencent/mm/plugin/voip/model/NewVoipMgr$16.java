package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class NewVoipMgr$16
  extends PhoneStateListener
{
  NewVoipMgr$16(NewVoipMgr paramNewVoipMgr) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(191914);
    super.onSignalStrengthsChanged(paramSignalStrength);
    super.onSignalStrengthsChanged(paramSignalStrength);
    paramSignalStrength = paramSignalStrength.toString().split(" ");
    try
    {
      if ((NewVoipMgr.g(this.zic).getNetworkType() == 13) && (paramSignalStrength.length > 9)) {
        NewVoipMgr.dSJ()[0] = bt.aGh(paramSignalStrength[9]);
      }
      AppMethodBeat.o(191914);
      return;
    }
    catch (Exception paramSignalStrength)
    {
      ad.printErrStackTrace("MicroMsg.Voip.NewVoipMgr", paramSignalStrength, "", new Object[0]);
      AppMethodBeat.o(191914);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.NewVoipMgr.16
 * JD-Core Version:    0.7.0.1
 */