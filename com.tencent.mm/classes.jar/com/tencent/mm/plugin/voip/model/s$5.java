package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.mm.sdk.platformtools.bk;

final class s$5
  extends PhoneStateListener
{
  s$5(s params, TelephonyManager paramTelephonyManager) {}
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    int i = 100;
    super.onSignalStrengthsChanged(paramSignalStrength);
    String[] arrayOfString = paramSignalStrength.toString().split(" ");
    if (this.pTX.getNetworkType() == 13)
    {
      if ((arrayOfString != null) && (arrayOfString.length >= 10)) {
        s.An(bk.getInt(arrayOfString[9], -141) + 140);
      }
      this.pTW.pTN = "LTE";
      if (s.auH() <= 100) {
        break label146;
      }
      label80:
      s.An(i);
      if (s.auH() >= 0) {
        break label153;
      }
    }
    label146:
    label153:
    for (i = 0;; i = s.auH())
    {
      s.An(i);
      s.f(this.pTW);
      return;
      int j = paramSignalStrength.getGsmSignalStrength();
      if ((paramSignalStrength.isGsm()) && (j == 99))
      {
        s.An(-1);
        break;
      }
      s.An((int)(j * 3.225807F));
      break;
      i = s.auH();
      break label80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.s.5
 * JD-Core Version:    0.7.0.1
 */