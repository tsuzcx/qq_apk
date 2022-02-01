package com.tencent.mm.plugin.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;

public class ClearUATTestIDReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(190960);
    ac.i("MicroMsg.ClearUATTestIDReceiver", "get clear test id broadcast");
    g.agR().agA().set(352280, "");
    AppMethodBeat.o(190960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ClearUATTestIDReceiver
 * JD-Core Version:    0.7.0.1
 */