package com.tencent.mm.plugin.updater.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.c;
import com.tencent.mm.pluginsdk.j.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class SuicideListener
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(196054);
    Log.i("Tinker.TinkerResponseProcessor", "do suicide");
    c.QYP.bT(MMApplicationContext.getContext());
    AppMethodBeat.o(196054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.SuicideListener
 * JD-Core Version:    0.7.0.1
 */