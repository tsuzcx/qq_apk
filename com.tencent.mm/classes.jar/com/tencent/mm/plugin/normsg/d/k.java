package com.tencent.mm.plugin.normsg.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class k
{
  private static a MvL;
  private static boolean mST = false;
  
  public static boolean isConnected()
  {
    return mST;
  }
  
  public static void start()
  {
    AppMethodBeat.i(149110);
    if (MvL == null) {
      MvL = new a((byte)0);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction(d.MtP.aQf(""));
    MMApplicationContext.getContext().registerReceiver(MvL, localIntentFilter);
    AppMethodBeat.o(149110);
  }
  
  public static void stop()
  {
    AppMethodBeat.i(149111);
    if (MvL != null) {
      MMApplicationContext.getContext().unregisterReceiver(MvL);
    }
    MvL = null;
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
      k.access$002(paramIntent.getExtras().getBoolean(d.MtP.aQf("3<<;14\"<<")));
      AppMethodBeat.o(149109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.k
 * JD-Core Version:    0.7.0.1
 */