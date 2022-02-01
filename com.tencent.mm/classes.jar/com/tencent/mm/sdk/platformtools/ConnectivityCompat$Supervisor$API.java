package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$Supervisor$API;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "GET_CONNECTION_INFO", "GET_CONFIGURED_NETWORKS", "GET_SCAN_RESULTS", "START_SCAN_WIFI", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum ConnectivityCompat$Supervisor$API
{
  private final String text;
  
  static
  {
    AppMethodBeat.i(243717);
    GET_CONNECTION_INFO = new API("GET_CONNECTION_INFO", 0, "WifiManager#getConnectionInfo");
    GET_CONFIGURED_NETWORKS = new API("GET_CONFIGURED_NETWORKS", 1, "WifiManager#getConfiguredNetworks");
    GET_SCAN_RESULTS = new API("GET_SCAN_RESULTS", 2, "WifiManager#getScanResults");
    START_SCAN_WIFI = new API("START_SCAN_WIFI", 3, "WifiManager#startScan");
    $VALUES = $values();
    AppMethodBeat.o(243717);
  }
  
  private ConnectivityCompat$Supervisor$API(String paramString)
  {
    this.text = paramString;
  }
  
  public final String getText()
  {
    return this.text;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ConnectivityCompat.Supervisor.API
 * JD-Core Version:    0.7.0.1
 */