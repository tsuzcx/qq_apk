package com.tencent.mm.plugin.normsg.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.sdk.platformtools.aj;

public final class j
{
  private static boolean gJk = false;
  private static a wvi;
  
  public static boolean isConnected()
  {
    return gJk;
  }
  
  public static void start()
  {
    AppMethodBeat.i(149110);
    if (wvi == null) {
      wvi = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction(b.wtJ.atn(""));
    aj.getContext().registerReceiver(wvi, localIntentFilter);
    AppMethodBeat.o(149110);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(149111);
    if (wvi != null) {
      aj.getContext().unregisterReceiver(wvi);
    }
    wvi = null;
    AppMethodBeat.o(149111);
  }
  
  static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(149109);
      if (paramIntent == null)
      {
        AppMethodBeat.o(149109);
        return;
      }
      j.access$002(paramIntent.getExtras().getBoolean(b.wtJ.atn("3<<;14\"<<")));
      AppMethodBeat.o(149109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.j
 * JD-Core Version:    0.7.0.1
 */