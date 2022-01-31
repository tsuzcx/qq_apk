package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

final class h$1
  implements f
{
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(93677);
    if ((paramm instanceof e))
    {
      g.Rc().b(1947, h.cyR());
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((e)paramm).spF;
        ab.i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", new Object[] { paramString.wpG });
        h.acw(paramString.wpG);
        paramString = h.cyP().toString();
        k.acx(paramString);
        ((PluginSport)g.G(PluginSport.class)).getDeviceStepManager().acv(paramString);
        if (h.cyS() != null) {
          h.cyS().ye();
        }
      }
    }
    AppMethodBeat.o(93677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.h.1
 * JD-Core Version:    0.7.0.1
 */