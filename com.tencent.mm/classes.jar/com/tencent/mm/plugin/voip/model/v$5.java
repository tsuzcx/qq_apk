package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

final class v$5
  extends PhoneStateListener
{
  v$5(v paramv, TelephonyManager paramTelephonyManager) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    int i = 100;
    AppMethodBeat.i(115160);
    super.onSignalStrengthsChanged(paramSignalStrength);
    String[] arrayOfString = paramSignalStrength.toString().split(" ");
    if (this.zmM.getNetworkType() == 13)
    {
      if ((arrayOfString != null) && (arrayOfString.length >= 10)) {
        v.Qr(bt.getInt(arrayOfString[9], -141) + 140);
      }
      this.zmL.zmx = "LTE";
      if (v.access$400() <= 100) {
        break label156;
      }
      label85:
      v.Qr(i);
      if (v.access$400() >= 0) {
        break label163;
      }
    }
    label156:
    label163:
    for (i = 0;; i = v.access$400())
    {
      v.Qr(i);
      v.f(this.zmL);
      AppMethodBeat.o(115160);
      return;
      int j = paramSignalStrength.getGsmSignalStrength();
      if ((paramSignalStrength.isGsm()) && (j == 99))
      {
        v.Qr(-1);
        break;
      }
      v.Qr((int)(j * 3.225807F));
      break;
      i = v.access$400();
      break label85;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v.5
 * JD-Core Version:    0.7.0.1
 */