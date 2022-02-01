package org.xwalk.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NetworkUtil
{
  private static final int NON_NETWORK = 0;
  private static final int OTHER = 4;
  private static final String TAG = "NetworkUtil";
  private static final int WIFI = 1;
  private static final int _3G = 2;
  private static final int _4G = 3;
  
  public static int getCurrentNetWorkStatus(Context paramContext)
  {
    AppMethodBeat.i(157212);
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0)
    {
      AppMethodBeat.o(157212);
      return 0;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      AppMethodBeat.o(157212);
      return 0;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null)
    {
      AppMethodBeat.o(157212);
      return 0;
    }
    if (!paramContext.isConnected())
    {
      AppMethodBeat.o(157212);
      return 0;
    }
    if (paramContext.getType() == 1)
    {
      AppMethodBeat.o(157212);
      return 1;
    }
    if (paramContext.getSubtype() >= 13)
    {
      AppMethodBeat.o(157212);
      return 3;
    }
    if ((paramContext.getSubtype() >= 5) && (paramContext.getSubtype() < 13))
    {
      AppMethodBeat.o(157212);
      return 2;
    }
    AppMethodBeat.o(157212);
    return 4;
  }
  
  public static boolean isNetworkAvailable()
  {
    AppMethodBeat.i(157213);
    if (getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext()) == 0)
    {
      Log.w("NetworkUtil", "no network");
      AppMethodBeat.o(157213);
      return false;
    }
    AppMethodBeat.o(157213);
    return true;
  }
  
  public static boolean isWifiAvailable()
  {
    AppMethodBeat.i(157214);
    if (getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext()) == 1)
    {
      AppMethodBeat.o(157214);
      return true;
    }
    AppMethodBeat.o(157214);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */