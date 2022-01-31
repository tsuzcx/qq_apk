package com.tinkerboots.sdk.tinker.service;

import android.os.Process;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tinkerboots.sdk.b.c.b;
import java.io.File;

public class TinkerServerResultService
  extends DefaultTinkerResultService
{
  private static boolean xnP = false;
  private static com.tinkerboots.sdk.tinker.a.a xnQ = null;
  
  static void restartProcess()
  {
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "app is background now, i can kill quietly", new Object[0]);
    Process.killProcess(Process.myPid());
  }
  
  public final void a(com.tencent.tinker.lib.service.a parama)
  {
    if (parama == null) {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerServerResultService", "received null result!!!!", new Object[0]);
    }
    do
    {
      return;
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "receive result: %s", new Object[] { parama.toString() });
      b.hO(getApplicationContext());
      if (!parama.bKQ) {
        break label131;
      }
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "patch success, please restart process", new Object[0]);
      Y(new File(parama.wWa));
      if (!b(parama)) {
        break;
      }
    } while (!xnP);
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "tinker wait screen to restart process", new Object[0]);
    new c.b(getApplicationContext(), new TinkerServerResultService.1(this));
    return;
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "I have already install the newly patch version!", new Object[0]);
    return;
    label131:
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "patch fail, please check reason", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tinkerboots.sdk.tinker.service.TinkerServerResultService
 * JD-Core Version:    0.7.0.1
 */