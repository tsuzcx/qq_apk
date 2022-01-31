package com.tencent.mm.plugin.setting;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.a;
import java.util.Map;

final class c$2
  implements bx.a
{
  c$2(c paramc) {}
  
  public final void a(e.a parama)
  {
    parama = aa.a(parama.dBs.svH);
    if ((parama == null) || (parama.length() == 0)) {
      y.e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              parama = bn.s(parama, "sysmsg");
            } while (parama == null);
            str = bk.aM((String)parama.get(".sysmsg.RedPoints.redPoint.path"), "");
            i = bk.ZR(bk.aM((String)parama.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
            bk.ZR(bk.aM((String)parama.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
          } while (bk.bl(str));
          if (!str.equals("my_setting_privaty_recentOption")) {
            break;
          }
        } while (((Integer)g.DP().Dz().get(ac.a.uvn, Integer.valueOf(0))).intValue() >= i);
        g.DP().Dz().c(ac.a.uvn, Integer.valueOf(i));
        g.DP().Dz().c(ac.a.uvo, Integer.valueOf(i));
        g.DP().Dz().c(ac.a.uvq, Integer.valueOf(i));
        g.DP().Dz().c(ac.a.uvs, Integer.valueOf(i));
        g.DP().Dz().c(ac.a.uvu, Integer.valueOf(i));
        com.tencent.mm.y.c.BS().w(266260, true);
        return;
      } while (!str.equals("my_setting_plugin_switch"));
      parama = bk.aM((String)parama.get(".sysmsg.RedPoints.redPoint.ext"), "");
    } while ((bk.bl(parama)) || (((Integer)g.DP().Dz().get(ac.a.uwp, Integer.valueOf(0))).intValue() >= i));
    g.DP().Dz().c(ac.a.uwp, Integer.valueOf(i));
    String str = (String)g.DP().Dz().get(ac.a.uwq, "");
    if (!bk.bl(str)) {
      parama = parama.concat(",").concat(str);
    }
    for (;;)
    {
      g.DP().Dz().c(ac.a.uwq, parama);
      com.tencent.mm.y.c.BS().w(262158, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.c.2
 * JD-Core Version:    0.7.0.1
 */