package com.tencent.mm.plugin.performance.elf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class b$b
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(111070);
    if ("ACTION_ELF_CHECK_RESPONSE".equals(paramIntent.getAction()))
    {
      paramIntent = (ElfCheckResponse)paramIntent.getParcelableExtra("MicroMsg.ElfCheckResponse");
      if (paramIntent == null)
      {
        ab.i("MicroMsg.ProcessElf", "[onReceive] response is null!");
        AppMethodBeat.o(111070);
        return;
      }
      if (!paramIntent.bTy) {
        b.caJ().removeCallbacksAndMessages(null);
      }
      ak localak = b.caJ();
      if ((paramIntent.bTy) && (paramIntent.psr) && (paramIntent.pss)) {
        localak.postDelayed(new ElfCheckResponse.1(paramIntent, paramContext), paramIntent.psv);
      }
      for (boolean bool = true;; bool = false)
      {
        ab.i("MicroMsg.ProcessElf", "[onReceive] %s, isEnable:%s, CHECK_TIME:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramIntent.bTy), Long.valueOf(b.caE()) });
        AppMethodBeat.o(111070);
        return;
        ab.w("MicroMsg.ElfCheckResponse", "can't call process[%s]", new Object[] { paramIntent.processName });
      }
    }
    if ("com.tencent.mm.MMDensityManager".equals(paramIntent.getAction()))
    {
      ab.i("MicroMsg.ProcessElf", "restart mm for density!");
      new Handler(Looper.getMainLooper()).postDelayed(new b.b.1(this, paramContext), 500L);
    }
    AppMethodBeat.o(111070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.elf.b.b
 * JD-Core Version:    0.7.0.1
 */