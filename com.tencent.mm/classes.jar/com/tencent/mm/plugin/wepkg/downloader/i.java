package com.tencent.mm.plugin.wepkg.downloader;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class i
{
  private static int kZo = -1;
  private static i.a vFD;
  
  public static void bje()
  {
    AppMethodBeat.i(63454);
    if (vFD == null) {
      vFD = new i.a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try
    {
      ah.getContext().registerReceiver(vFD, localIntentFilter);
      label59:
      ab.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader startListen");
      AppMethodBeat.o(63454);
      return;
    }
    catch (Exception localException)
    {
      break label59;
    }
  }
  
  public static void bjf()
  {
    AppMethodBeat.i(63455);
    if (vFD != null) {}
    try
    {
      ah.getContext().unregisterReceiver(vFD);
      label20:
      vFD = null;
      ab.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
      AppMethodBeat.o(63455);
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.i
 * JD-Core Version:    0.7.0.1
 */