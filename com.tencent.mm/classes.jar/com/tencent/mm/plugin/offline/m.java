package com.tencent.mm.plugin.offline;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aan;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.offline.a.s.a;
import com.tencent.mm.plugin.offline.a.s.c;
import com.tencent.mm.plugin.offline.a.s.e;
import com.tencent.mm.plugin.offline.a.s.f;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import java.util.List;

public final class m
  implements s.a
{
  IListener yYb;
  
  public m()
  {
    AppMethodBeat.i(66276);
    this.yYb = new IListener() {};
    EventCenter.instance.addListener(this.yYb);
    k.ezn();
    k.ezo().a(this);
    AppMethodBeat.o(66276);
  }
  
  private static void bO(int paramInt, String paramString)
  {
    AppMethodBeat.i(66277);
    aan localaan = new aan();
    localaan.ehq.ehs = paramInt;
    localaan.ehq.action = 4;
    localaan.ehq.content = paramString;
    EventCenter.instance.publish(localaan);
    AppMethodBeat.o(66277);
  }
  
  public final boolean a(s.c paramc)
  {
    AppMethodBeat.i(66278);
    if (paramc.AKh == 6)
    {
      paramc = (s.f)paramc;
      if ((paramc.AKp.HZd != null) && (paramc.AKp.HZd.size() > 0))
      {
        paramc = (Orders.Commodity)paramc.AKp.HZd.get(0);
        bO(0, MMApplicationContext.getContext().getString(2131768386, new Object[] { f.d(paramc.qwJ, paramc.AOl) }));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66278);
      return false;
      bO(9, MMApplicationContext.getContext().getString(2131768384));
      continue;
      if (paramc.AKh == 8) {
        bO(6, MMApplicationContext.getContext().getString(2131768384));
      } else if (paramc.AKh == 5) {
        bO(7, Util.nullAs(((s.e)paramc).AKl, ""));
      } else if (paramc.AKh == 4) {
        bO(8, MMApplicationContext.getContext().getString(2131768385));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.m
 * JD-Core Version:    0.7.0.1
 */