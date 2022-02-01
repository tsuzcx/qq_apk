package com.tinkerboots.sdk.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.util.HashSet;

public final class d
{
  private static String SKM;
  private static HashSet<String> SKN;
  
  static
  {
    AppMethodBeat.i(3466);
    SKN = new HashSet();
    AppMethodBeat.o(3466);
  }
  
  public static String hwb()
  {
    if (SKM == null) {
      return "";
    }
    return SKM;
  }
  
  public static boolean hwc()
  {
    AppMethodBeat.i(3465);
    if (SKM == null)
    {
      AppMethodBeat.o(3465);
      return false;
    }
    boolean bool = SKN.contains(SKM);
    AppMethodBeat.o(3465);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void onScreenOff();
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
            ShareTinkerLog.v("Tinker.TinkerUtils", "ScreenReceiver action [%s] ", new Object[] { paramAnonymousIntent });
            if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent))
            {
              paramAnonymousContext.unregisterReceiver(this);
              if (parama != null) {
                parama.onScreenOff();
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