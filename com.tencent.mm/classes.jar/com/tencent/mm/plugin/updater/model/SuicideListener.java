package com.tencent.mm.plugin.updater.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.i.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class SuicideListener
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(214537);
    ad.i("Tinker.TinkerResponseProcessor", "do suicide");
    f.EOZ.by(aj.getContext());
    AppMethodBeat.o(214537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.updater.model.SuicideListener
 * JD-Core Version:    0.7.0.1
 */