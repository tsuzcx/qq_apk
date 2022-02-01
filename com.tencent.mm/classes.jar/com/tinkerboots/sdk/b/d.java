package com.tinkerboots.sdk.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.f.a;
import java.util.HashSet;

public final class d
{
  private static String IWA;
  private static HashSet<String> IWB;
  
  static
  {
    AppMethodBeat.i(3466);
    IWB = new HashSet();
    AppMethodBeat.o(3466);
  }
  
  public static String ftQ()
  {
    if (IWA == null) {
      return "";
    }
    return IWA;
  }
  
  public static boolean ftR()
  {
    AppMethodBeat.i(3465);
    if (IWA == null)
    {
      AppMethodBeat.o(3465);
      return false;
    }
    boolean bool = IWB.contains(IWA);
    AppMethodBeat.o(3465);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void daE();
  }
  
  public static final class b
  {
    public b(Context paramContext, final d.a parama)
    {
      AppMethodBeat.i(3464);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      paramContext.registerReceiver(new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(3463);
          if (paramAnonymousIntent == null) {}
          for (paramAnonymousIntent = "";; paramAnonymousIntent = paramAnonymousIntent.getAction())
          {
            a.i("Tinker.TinkerUtils", "ScreenReceiver action [%s] ", new Object[] { paramAnonymousIntent });
            if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent))
            {
              paramAnonymousContext.unregisterReceiver(this);
              if (parama != null) {
                parama.daE();
              }
            }
            AppMethodBeat.o(3463);
            return;
          }
        }
      }, localIntentFilter);
      AppMethodBeat.o(3464);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tinkerboots.sdk.b.d
 * JD-Core Version:    0.7.0.1
 */