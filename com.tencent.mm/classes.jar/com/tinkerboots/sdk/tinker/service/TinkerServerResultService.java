package com.tinkerboots.sdk.tinker.service;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tinkerboots.sdk.b.d.b;
import java.io.File;

public class TinkerServerResultService
  extends DefaultTinkerResultService
{
  private static boolean BLL = false;
  private static com.tinkerboots.sdk.tinker.a.a BLM = null;
  
  static void restartProcess()
  {
    AppMethodBeat.i(65551);
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "app is background now, i can kill quietly", new Object[0]);
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(65551);
  }
  
  public final void a(com.tencent.tinker.lib.service.a parama)
  {
    AppMethodBeat.i(65550);
    if (parama == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.TinkerServerResultService", "received null result!!!!", new Object[0]);
      AppMethodBeat.o(65550);
      return;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "receive result: %s", new Object[] { parama.toString() });
    b.jp(getApplicationContext());
    if (parama.csk)
    {
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "patch success, please restart process", new Object[0]);
      ah(new File(parama.BsF));
      if (b(parama))
      {
        if (BLL)
        {
          com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "tinker wait screen to restart process", new Object[0]);
          new d.b(getApplicationContext(), new TinkerServerResultService.1(this));
          AppMethodBeat.o(65550);
        }
      }
      else
      {
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "I have already install the newly patch version!", new Object[0]);
        AppMethodBeat.o(65550);
      }
    }
    else
    {
      com.tencent.tinker.lib.f.a.i("Tinker.TinkerServerResultService", "patch fail, please check reason", new Object[0]);
    }
    AppMethodBeat.o(65550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tinkerboots.sdk.tinker.service.TinkerServerResultService
 * JD-Core Version:    0.7.0.1
 */