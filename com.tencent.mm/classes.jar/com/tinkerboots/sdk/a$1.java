package com.tinkerboots.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tinkerboots.sdk.a.a.b;
import com.tinkerboots.sdk.b.c;

final class a$1
  implements MessageQueue.IdleHandler
{
  a$1(a parama, boolean paramBoolean) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(65518);
    Object localObject1 = this.BLC.BLA;
    boolean bool = this.BLB;
    Object localObject2 = c.getContext().getSharedPreferences("patch_server_config", 0);
    long l = ((SharedPreferences)localObject2).getLong("fetch_patch_last_check", 0L);
    if (l == -1L) {
      com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync is disabled, with never check flag!", new Object[0]);
    }
    for (;;)
    {
      AppMethodBeat.o(65518);
      return false;
      l = System.currentTimeMillis() - l;
      if ((bool) || (((com.tinkerboots.sdk.a.a)localObject1).isDebug) || (l >= ((com.tinkerboots.sdk.a.a)localObject1).hin))
      {
        ((SharedPreferences)localObject2).edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
        localObject2 = ((com.tinkerboots.sdk.a.a)localObject1).BLH;
        localObject1 = ((com.tinkerboots.sdk.a.a)localObject1).BLF;
        if (localObject1 == null)
        {
          localObject1 = new RuntimeException("callback can't be null");
          AppMethodBeat.o(65518);
          throw ((Throwable)localObject1);
        }
        if (((b)localObject1).bIp())
        {
          ((b)localObject1).bIq();
          ((b)localObject1).M(((com.tinkerboots.sdk.a.b.a)localObject2).BLI.BLJ);
        }
      }
      else
      {
        com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync should wait interval %ss", new Object[] { Long.valueOf((((com.tinkerboots.sdk.a.a)localObject1).hin - l) / 1000L) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tinkerboots.sdk.a.1
 * JD-Core Version:    0.7.0.1
 */