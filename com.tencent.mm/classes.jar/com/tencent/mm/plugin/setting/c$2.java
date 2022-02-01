package com.tencent.mm.plugin.setting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.z.a;
import java.util.Map;

final class c$2
  implements cd.a
{
  c$2(c paramc) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(73747);
    parama = z.a(parama.gqE.Fvk);
    if ((parama == null) || (parama.length() == 0))
    {
      ad.e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
      AppMethodBeat.o(73747);
      return;
    }
    parama = bw.M(parama, "sysmsg");
    if (parama == null)
    {
      AppMethodBeat.o(73747);
      return;
    }
    String str = bt.bI((String)parama.get(".sysmsg.RedPoints.redPoint.path"), "");
    int i = bt.aRe(bt.bI((String)parama.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
    bt.aRe(bt.bI((String)parama.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
    if (bt.isNullOrNil(str))
    {
      AppMethodBeat.o(73747);
      return;
    }
    if (str.equals("my_setting_privaty_recentOption"))
    {
      if (((Integer)g.ajC().ajl().get(al.a.Iyk, Integer.valueOf(0))).intValue() >= i)
      {
        AppMethodBeat.o(73747);
        return;
      }
      g.ajC().ajl().set(al.a.Iyk, Integer.valueOf(i));
      g.ajC().ajl().set(al.a.Iyl, Integer.valueOf(i));
      g.ajC().ajl().set(al.a.Iyn, Integer.valueOf(i));
      g.ajC().ajl().set(al.a.Iyp, Integer.valueOf(i));
      g.ajC().ajl().set(al.a.Iyr, Integer.valueOf(i));
      com.tencent.mm.z.c.aht().x(266260, true);
      AppMethodBeat.o(73747);
      return;
    }
    if (str.equals("my_setting_plugin_switch"))
    {
      parama = bt.bI((String)parama.get(".sysmsg.RedPoints.redPoint.ext"), "");
      if (bt.isNullOrNil(parama))
      {
        AppMethodBeat.o(73747);
        return;
      }
      if (((Integer)g.ajC().ajl().get(al.a.Izn, Integer.valueOf(0))).intValue() >= i)
      {
        AppMethodBeat.o(73747);
        return;
      }
      g.ajC().ajl().set(al.a.Izn, Integer.valueOf(i));
      str = (String)g.ajC().ajl().get(al.a.Izo, "");
      if (bt.isNullOrNil(str)) {
        break label414;
      }
      parama = parama.concat(",").concat(str);
    }
    label414:
    for (;;)
    {
      g.ajC().ajl().set(al.a.Izo, parama);
      com.tencent.mm.z.c.aht().x(262158, true);
      AppMethodBeat.o(73747);
      return;
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c.2
 * JD-Core Version:    0.7.0.1
 */