package com.tencent.voip.mars.comm;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetworkSignalUtil
{
  public static final String TAG = "MicroMsg.NetworkSignalUtil";
  private static Context context = null;
  private static long strength = 10000L;
  
  public static void InitNetworkSignalUtil(Context paramContext)
  {
    AppMethodBeat.i(92746);
    context = paramContext;
    try
    {
      ((TelephonyManager)context.getSystemService("phone")).listen(new PhoneStateListener()
      {
        public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
        {
          AppMethodBeat.i(92789);
          super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
          NetworkSignalUtil.access$000(paramAnonymousSignalStrength);
          AppMethodBeat.o(92789);
        }
      }, 256);
      AppMethodBeat.o(92746);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramContext)
    {
      AppMethodBeat.o(92746);
    }
  }
  
  private static void calSignalStrength(SignalStrength paramSignalStrength)
  {
    AppMethodBeat.i(92748);
    int i;
    long l;
    if (paramSignalStrength.isGsm())
    {
      i = paramSignalStrength.getGsmSignalStrength();
      if ((!paramSignalStrength.isGsm()) || (i != 99)) {
        break label55;
      }
      l = 0L;
    }
    for (;;)
    {
      strength = l;
      AppMethodBeat.o(92748);
      return;
      i = (paramSignalStrength.getCdmaDbm() + 113) / 2;
      break;
      label55:
      l = (i * 3.225807F);
      strength = l;
      if (l > 100L) {}
      for (l = 100L;; l = strength)
      {
        strength = l;
        if (l >= 0L) {
          break label100;
        }
        l = 0L;
        break;
      }
      label100:
      l = strength;
    }
  }
  
  public static long getGSMSignalStrength()
  {
    return strength;
  }
  
  public static long getNetworkSignalStrength(boolean paramBoolean)
  {
    return 0L;
  }
  
  public static long getWifiSignalStrength()
  {
    AppMethodBeat.i(92747);
    WifiInfo localWifiInfo = ((WifiManager)context.getSystemService("wifi")).getConnectionInfo();
    if ((localWifiInfo != null) && (localWifiInfo.getBSSID() != null))
    {
      int j = WifiManager.calculateSignalLevel(localWifiInfo.getRssi(), 10);
      int i = j;
      if (j > 10) {
        i = 10;
      }
      j = i;
      if (i < 0) {
        j = 0;
      }
      long l = j * 10;
      AppMethodBeat.o(92747);
      return l;
    }
    AppMethodBeat.o(92747);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.voip.mars.comm.NetworkSignalUtil
 * JD-Core Version:    0.7.0.1
 */