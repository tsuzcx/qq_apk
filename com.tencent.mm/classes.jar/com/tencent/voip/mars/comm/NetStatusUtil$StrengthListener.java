package com.tencent.voip.mars.comm;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

public class NetStatusUtil$StrengthListener
  extends PhoneStateListener
{
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (!paramSignalStrength.isGsm())
    {
      NetStatusUtil.access$0(paramSignalStrength.getCdmaDbm());
      return;
    }
    NetStatusUtil.access$0(paramSignalStrength.getGsmSignalStrength());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.voip.mars.comm.NetStatusUtil.StrengthListener
 * JD-Core Version:    0.7.0.1
 */