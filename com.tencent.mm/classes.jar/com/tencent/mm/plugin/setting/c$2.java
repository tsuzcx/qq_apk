package com.tencent.mm.plugin.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.a;
import java.util.Map;

final class c$2
  implements bz.a
{
  c$2(c paramc) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(126826);
    parama = aa.a(parama.eyJ.woR);
    if ((parama == null) || (parama.length() == 0))
    {
      ab.e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
      AppMethodBeat.o(126826);
      return;
    }
    parama = br.F(parama, "sysmsg");
    if (parama == null)
    {
      AppMethodBeat.o(126826);
      return;
    }
    String str = bo.bf((String)parama.get(".sysmsg.RedPoints.redPoint.path"), "");
    int i = bo.apV(bo.bf((String)parama.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
    bo.apV(bo.bf((String)parama.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(126826);
      return;
    }
    if (str.equals("my_setting_privaty_recentOption"))
    {
      if (((Integer)g.RL().Ru().get(ac.a.yFu, Integer.valueOf(0))).intValue() >= i)
      {
        AppMethodBeat.o(126826);
        return;
      }
      g.RL().Ru().set(ac.a.yFu, Integer.valueOf(i));
      g.RL().Ru().set(ac.a.yFv, Integer.valueOf(i));
      g.RL().Ru().set(ac.a.yFx, Integer.valueOf(i));
      g.RL().Ru().set(ac.a.yFz, Integer.valueOf(i));
      g.RL().Ru().set(ac.a.yFB, Integer.valueOf(i));
      com.tencent.mm.x.c.PJ().y(266260, true);
      AppMethodBeat.o(126826);
      return;
    }
    if (str.equals("my_setting_plugin_switch"))
    {
      parama = bo.bf((String)parama.get(".sysmsg.RedPoints.redPoint.ext"), "");
      if (bo.isNullOrNil(parama))
      {
        AppMethodBeat.o(126826);
        return;
      }
      if (((Integer)g.RL().Ru().get(ac.a.yGx, Integer.valueOf(0))).intValue() >= i)
      {
        AppMethodBeat.o(126826);
        return;
      }
      g.RL().Ru().set(ac.a.yGx, Integer.valueOf(i));
      str = (String)g.RL().Ru().get(ac.a.yGy, "");
      if (bo.isNullOrNil(str)) {
        break label414;
      }
      parama = parama.concat(",").concat(str);
    }
    label414:
    for (;;)
    {
      g.RL().Ru().set(ac.a.yGy, parama);
      com.tencent.mm.x.c.PJ().y(262158, true);
      AppMethodBeat.o(126826);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c.2
 * JD-Core Version:    0.7.0.1
 */