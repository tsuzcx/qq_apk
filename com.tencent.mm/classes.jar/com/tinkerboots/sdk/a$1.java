package com.tinkerboots.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.MessageQueue.IdleHandler;

final class a$1
  implements MessageQueue.IdleHandler
{
  a$1(a parama, boolean paramBoolean) {}
  
  public final boolean queueIdle()
  {
    Object localObject1 = this.xnG.xnE;
    boolean bool = this.xnF;
    Object localObject2 = com.tinkerboots.sdk.b.b.getContext().getSharedPreferences("patch_server_config", 0);
    long l = ((SharedPreferences)localObject2).getLong("fetch_patch_last_check", 0L);
    if (l == -1L) {
      com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync is disabled, with never check flag!", new Object[0]);
    }
    do
    {
      return false;
      l = System.currentTimeMillis() - l;
      if ((!bool) && (!((com.tinkerboots.sdk.a.a)localObject1).isDebug) && (l < ((com.tinkerboots.sdk.a.a)localObject1).fPi)) {
        break;
      }
      ((SharedPreferences)localObject2).edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
      localObject2 = ((com.tinkerboots.sdk.a.a)localObject1).xnL;
      localObject1 = ((com.tinkerboots.sdk.a.a)localObject1).xnJ;
      if (localObject1 == null) {
        throw new RuntimeException("callback can't be null");
      }
    } while (!((com.tinkerboots.sdk.a.a.b)localObject1).bbk());
    ((com.tinkerboots.sdk.a.a.b)localObject1).bbl();
    ((com.tinkerboots.sdk.a.a.b)localObject1).C(((com.tinkerboots.sdk.a.b.a)localObject2).xnM.xnN);
    return false;
    com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "tinker sync should wait interval %ss", new Object[] { Long.valueOf((((com.tinkerboots.sdk.a.a)localObject1).fPi - l) / 1000L) });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tinkerboots.sdk.a.1
 * JD-Core Version:    0.7.0.1
 */