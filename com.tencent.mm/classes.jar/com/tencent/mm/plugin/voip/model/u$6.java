package com.tencent.mm.plugin.voip.model;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimerTask;

final class u$6
  extends TimerTask
{
  u$6(u paramu) {}
  
  public final void run()
  {
    int i = 10;
    AppMethodBeat.i(4648);
    if (u.g(this.tzy) != null) {
      u.a(this.tzy, u.g(this.tzy).getConnectionInfo());
    }
    if ((u.h(this.tzy) != null) && (u.h(this.tzy).getBSSID() != null) && (u.g(this.tzy) != null))
    {
      u.g(this.tzy);
      u.HD(WifiManager.calculateSignalLevel(u.h(this.tzy).getRssi(), 10));
      if (u.aUG() > 10)
      {
        u.HD(i);
        if (u.aUG() >= 0) {
          break label182;
        }
        i = 0;
        label118:
        u.HD(i);
        u.HD(u.aUG() * 10);
      }
    }
    for (;;)
    {
      if (u.aUG() != -1) {
        break label197;
      }
      if (u.i(this.tzy) <= 1) {
        u.HC(-1);
      }
      this.tzy.setNetSignalValue(1, u.access$400());
      AppMethodBeat.o(4648);
      return;
      i = u.aUG();
      break;
      label182:
      i = u.aUG();
      break label118;
      u.HD(-1);
    }
    label197:
    this.tzy.setNetSignalValue(2, u.aUG());
    AppMethodBeat.o(4648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.u.6
 * JD-Core Version:    0.7.0.1
 */