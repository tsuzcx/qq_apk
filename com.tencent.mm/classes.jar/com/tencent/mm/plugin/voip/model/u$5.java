package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class u$5
  extends PhoneStateListener
{
  u$5(u paramu, TelephonyManager paramTelephonyManager) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    int i = 100;
    AppMethodBeat.i(4647);
    super.onSignalStrengthsChanged(paramSignalStrength);
    String[] arrayOfString = paramSignalStrength.toString().split(" ");
    if (this.tzz.getNetworkType() == 13)
    {
      if ((arrayOfString != null) && (arrayOfString.length >= 10)) {
        u.HC(bo.getInt(arrayOfString[9], -141) + 140);
      }
      this.tzy.tzp = "LTE";
      if (u.access$400() <= 100) {
        break label158;
      }
      label86:
      u.HC(i);
      if (u.access$400() >= 0) {
        break label165;
      }
    }
    label158:
    label165:
    for (i = 0;; i = u.access$400())
    {
      u.HC(i);
      u.f(this.tzy);
      AppMethodBeat.o(4647);
      return;
      int j = paramSignalStrength.getGsmSignalStrength();
      if ((paramSignalStrength.isGsm()) && (j == 99))
      {
        u.HC(-1);
        break;
      }
      u.HC((int)(j * 3.225807F));
      break;
      i = u.access$400();
      break label86;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.u.5
 * JD-Core Version:    0.7.0.1
 */