package com.tinkerboots.sdk.tinker.service;

import android.os.Process;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tinkerboots.sdk.a.b;
import java.io.File;

public class TinkerServerResultService
  extends DefaultTinkerResultService
{
  private static boolean aqe = false;
  private static com.tinkerboots.sdk.tinker.a.a aqf = null;
  
  static void pe()
  {
    com.tencent.tinker.lib.e.a.c("Tinker.TinkerServerResultService", "app is background now, i can kill quietly", new Object[0]);
    Process.killProcess(Process.myPid());
  }
  
  public final void a(com.tencent.tinker.lib.service.a parama)
  {
    if (parama == null) {
      com.tencent.tinker.lib.e.a.a("Tinker.TinkerServerResultService", "received null result!!!!", new Object[0]);
    }
    do
    {
      return;
      com.tencent.tinker.lib.e.a.c("Tinker.TinkerServerResultService", "receive result: %s", new Object[] { parama.toString() });
      com.tencent.tinker.lib.e.c.F(getApplicationContext());
      if (!parama.anl) {
        break label131;
      }
      com.tencent.tinker.lib.e.a.c("Tinker.TinkerServerResultService", "patch success, please restart process", new Object[0]);
      c(new File(parama.anm));
      if (!b(parama)) {
        break;
      }
    } while (!aqe);
    com.tencent.tinker.lib.e.a.c("Tinker.TinkerServerResultService", "tinker wait screen to restart process", new Object[0]);
    new com.tinkerboots.sdk.a.c(getApplicationContext(), new b()
    {
      public final void pf() {}
    });
    return;
    com.tencent.tinker.lib.e.a.c("Tinker.TinkerServerResultService", "I have already install the newly patch version!", new Object[0]);
    return;
    label131:
    com.tencent.tinker.lib.e.a.c("Tinker.TinkerServerResultService", "patch fail, please check reason", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tinkerboots.sdk.tinker.service.TinkerServerResultService
 * JD-Core Version:    0.7.0.1
 */