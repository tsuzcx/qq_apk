package com.tencent.mm.plugin.performance.elf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class ElfCallUpReceiver
  extends BroadcastReceiver
{
  public static int wHD = -1;
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(124973);
    ad.i("MicroMsg.ElfCallUpReceiver", "[onReceive] call up! ");
    if (getClass().getName().equals(paramIntent.getAction())) {
      wHD = paramIntent.getIntExtra("processId", 0);
    }
    AppMethodBeat.o(124973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.ElfCallUpReceiver
 * JD-Core Version:    0.7.0.1
 */