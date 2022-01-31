package com.tencent.mm.plugin.sport.c;

import android.os.RemoteException;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.protocal.c.ciw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class g$1
  implements f
{
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof e))
    {
      com.tencent.mm.kernel.g.Dk().b(1947, g.bLp());
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((e)paramm).ptq;
        y.i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", new Object[] { paramString.swu });
        paramm = paramString.swu;
        if (!ae.cqV()) {
          break label137;
        }
        ((PluginSport)com.tencent.mm.kernel.g.t(PluginSport.class)).getSportFileStorage().Pw(paramm);
        g.Pv(paramString.swu);
        paramm = ((PluginSport)com.tencent.mm.kernel.g.t(PluginSport.class)).getDeviceStepManager().ptg;
        if (paramm == null) {}
      }
    }
    try
    {
      paramm.Pu(paramString.swu);
      label122:
      if (g.bLq() != null) {
        g.bLq().aYu();
      }
      return;
      label137:
      throw new RuntimeException(String.format("not support set value in %s process", new Object[] { ae.getProcessName() }));
    }
    catch (RemoteException paramString)
    {
      break label122;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.g.1
 * JD-Core Version:    0.7.0.1
 */