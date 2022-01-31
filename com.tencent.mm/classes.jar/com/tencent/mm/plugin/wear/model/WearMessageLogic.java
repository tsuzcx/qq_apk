package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public class WearMessageLogic
  extends BroadcastReceiver
{
  public WearMessageLogic()
  {
    AppMethodBeat.i(26325);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mm.wear.message");
    ah.getContext().registerReceiver(this, localIntentFilter, "com.tencent.mm.wear.message", null);
    AppMethodBeat.o(26325);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(26326);
    if (paramIntent.getAction().equals("com.tencent.mm.wear.message"))
    {
      paramContext = paramIntent.getExtras();
      int i = paramContext.getInt("key_connecttype");
      if (i == 1)
      {
        paramIntent = new WearMessageLogic.a(this, (byte)0);
        paramIntent.uHh = i;
        paramIntent.fOC = paramContext.getInt("key_funid");
        paramIntent.cnU = paramContext.getInt("key_sessionid");
        paramIntent.uHi = paramContext.getByteArray("key_data");
        paramContext = a.cYy().uGA.IV(paramIntent.fOC);
        if (paramContext != null) {
          bool = paramContext.IU(paramIntent.fOC);
        }
        if (bool)
        {
          al.d(paramIntent);
          AppMethodBeat.o(26326);
          return;
        }
        d.post(paramIntent, "WearHttpMessageTask_" + paramIntent.fOC);
        AppMethodBeat.o(26326);
        return;
      }
      if (i == 2)
      {
        paramIntent = new WearMessageLogic.b(this, (byte)0);
        paramIntent.uHh = i;
        paramIntent.fOC = paramContext.getInt("key_funid");
        paramIntent.cnU = paramContext.getInt("key_sessionid");
        paramIntent.uHi = paramContext.getByteArray("key_data");
        a.cYy().uGI.a(paramIntent);
        AppMethodBeat.o(26326);
        return;
      }
      if (i == 3) {
        a.cYy().uGI.a(new WearMessageLogic.c(this, (byte)0));
      }
    }
    AppMethodBeat.o(26326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.WearMessageLogic
 * JD-Core Version:    0.7.0.1
 */