package io.flutter.plugins.connectivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Connectivity
{
  private ConnectivityManager connectivityManager;
  
  public Connectivity(ConnectivityManager paramConnectivityManager)
  {
    this.connectivityManager = paramConnectivityManager;
  }
  
  private String getNetworkTypeLegacy()
  {
    AppMethodBeat.i(189601);
    NetworkInfo localNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
    {
      AppMethodBeat.o(189601);
      return "none";
    }
    switch (localNetworkInfo.getType())
    {
    case 2: 
    case 3: 
    case 7: 
    case 8: 
    default: 
      AppMethodBeat.o(189601);
      return "none";
    case 1: 
    case 6: 
    case 9: 
      AppMethodBeat.o(189601);
      return "wifi";
    }
    AppMethodBeat.o(189601);
    return "mobile";
  }
  
  public ConnectivityManager getConnectivityManager()
  {
    return this.connectivityManager;
  }
  
  String getNetworkType()
  {
    AppMethodBeat.i(189608);
    if (Build.VERSION.SDK_INT >= 23) {
      localObject1 = null;
    }
    try
    {
      Object localObject2 = this.connectivityManager.getActiveNetwork();
      localObject2 = this.connectivityManager.getNetworkCapabilities((Network)localObject2);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(189608);
      return "none";
    }
    if ((((NetworkCapabilities)localObject1).hasTransport(1)) || (((NetworkCapabilities)localObject1).hasTransport(3)))
    {
      AppMethodBeat.o(189608);
      return "wifi";
    }
    if (((NetworkCapabilities)localObject1).hasTransport(0))
    {
      AppMethodBeat.o(189608);
      return "mobile";
    }
    Object localObject1 = getNetworkTypeLegacy();
    AppMethodBeat.o(189608);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugins.connectivity.Connectivity
 * JD-Core Version:    0.7.0.1
 */