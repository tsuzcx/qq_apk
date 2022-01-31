package com.tencent.mm.plugin.wepkg.downloader;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class i
{
  private static int iPW = -1;
  private static i.a rOO;
  
  public static void aFI()
  {
    if (rOO == null) {
      rOO = new i.a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      ae.getContext().registerReceiver(rOO, localIntentFilter);
      label54:
      y.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader startListen");
      return;
    }
    catch (Exception localException)
    {
      break label54;
    }
  }
  
  public static void aFJ()
  {
    if (rOO != null) {}
    try
    {
      ae.getContext().unregisterReceiver(rOO);
      label15:
      rOO = null;
      y.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.i
 * JD-Core Version:    0.7.0.1
 */