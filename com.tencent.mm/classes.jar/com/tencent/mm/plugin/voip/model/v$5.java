package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

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
    if (this.AFA.getNetworkType() == 13)
    {
      if ((arrayOfString != null) && (arrayOfString.length >= 10)) {
        v.SA(bs.getInt(arrayOfString[9], -141) + 140);
      }
      this.AFz.AFk = "LTE";
      if (v.access$400() <= 100) {
        break label156;
      }
      label85:
      v.SA(i);
      if (v.access$400() >= 0) {
        break label163;
      }
    }
    label156:
    label163:
    for (i = 0;; i = v.access$400())
    {
      v.SA(i);
      v.f(this.AFz);
      AppMethodBeat.o(115160);
      return;
      int j = paramSignalStrength.getGsmSignalStrength();
      if ((paramSignalStrength.isGsm()) && (j == 99))
      {
        v.SA(-1);
        break;
      }
      v.SA((int)(j * 3.225807F));
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