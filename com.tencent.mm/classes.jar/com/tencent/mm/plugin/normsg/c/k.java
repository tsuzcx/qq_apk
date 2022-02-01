package com.tencent.mm.plugin.normsg.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.sdk.platformtools.ak;

public final class k
{
  private static boolean gLT = false;
  private static a wKT;
  
  public static boolean isConnected()
  {
    return gLT;
  }
  
  public static void start()
  {
    AppMethodBeat.i(149110);
    if (wKT == null) {
      wKT = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction(b.wJt.auA(""));
    ak.getContext().registerReceiver(wKT, localIntentFilter);
    AppMethodBeat.o(149110);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(149111);
    if (wKT != null) {
      ak.getContext().unregisterReceiver(wKT);
    }
    wKT = null;
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
      k.access$002(paramIntent.getExtras().getBoolean(b.wJt.auA("3<<;14\"<<")));
      AppMethodBeat.o(149109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.k
 * JD-Core Version:    0.7.0.1
 */