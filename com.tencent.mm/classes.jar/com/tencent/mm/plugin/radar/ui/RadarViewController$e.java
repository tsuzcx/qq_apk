package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.plugin.radar.b.c.a;
import com.tencent.mm.plugin.radar.b.c.d;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.plugin.radar.b.c.m;
import com.tencent.mm.plugin.radar.b.e;
import com.tencent.mm.plugin.radar.b.e.c;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu.d;
import d.g.b.p;
import d.v;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/radar/ui/RadarViewController$initView$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
public final class RadarViewController$e
  implements RadarMemberView.b
{
  public final void a(cqi paramcqi, c.e parame)
  {
    AppMethodBeat.i(138746);
    p.h(paramcqi, "member");
    Object localObject1 = g.xla;
    String str = g.b(paramcqi);
    if (parame == null)
    {
      AppMethodBeat.o(138746);
      return;
    }
    switch (h.cpQ[parame.ordinal()])
    {
    default: 
      AppMethodBeat.o(138746);
      return;
    case 1: 
      l = RadarViewController.e(this.xlw).avf(str);
      RadarViewController.c(this.xlw).xiR.put(Long.valueOf(l), new e.c(paramcqi, parame));
      RadarViewController.a(this.xlw, str, c.e.xir);
      AppMethodBeat.o(138746);
      return;
    }
    Object localObject2 = RadarViewController.e(this.xlw);
    p.h(str, "username");
    localObject1 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject1, "service(IMessengerStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).azp().Bf(str);
    p.g(localObject1, "contact");
    Object localObject3 = (CharSequence)((am)localObject1).getUsername();
    if ((localObject3 == null) || (d.n.n.aE((CharSequence)localObject3)))
    {
      i = 1;
      label213:
      if (i == 0) {
        break label342;
      }
      localObject1 = str;
      label221:
      localObject3 = (String)((c)localObject2).xih.get(localObject1);
      localObject4 = (CharSequence)localObject3;
      if ((localObject4 != null) && (!d.n.n.aE((CharSequence)localObject4))) {
        break label359;
      }
    }
    label342:
    label359:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label364;
      }
      ad.e(c.TAG, "Verify Contact username(%s) error, verifyTicket is null", new Object[] { localObject1 });
      ((c)localObject2).avf((String)localObject1);
      l = -1L;
      RadarViewController.c(this.xlw).xiR.put(Long.valueOf(l), new e.c(paramcqi, parame));
      RadarViewController.a(this.xlw, str, c.e.xir);
      break;
      i = 0;
      break label213;
      localObject1 = ((am)localObject1).getUsername();
      p.g(localObject1, "contact.username");
      break label221;
    }
    label364:
    Object localObject4 = bu.d.aUe((String)localObject3);
    long l = System.currentTimeMillis();
    localObject2 = new c.a((c)localObject2, (c.d)new c.m((c)localObject2, (String)localObject3, l));
    localObject3 = ((bu.d)localObject4).fsv();
    p.g(localObject3, "verify.verifyTicket");
    p.h(localObject3, "verifyTicket");
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username is null", bool);
      ((c.a)localObject2).onStart();
      com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)new o((String)localObject1, (String)localObject3, 48));
      break;
    }
  }
  
  public final void b(cqi paramcqi, c.e parame)
  {
    AppMethodBeat.i(138747);
    if (paramcqi != null) {
      g localg = g.xla;
    }
    for (paramcqi = g.b(paramcqi);; paramcqi = null)
    {
      paramcqi = (View)((Map)RadarViewController.d(this.xlw).xlD).get(paramcqi);
      if (paramcqi == null) {
        break label96;
      }
      paramcqi = paramcqi.getTag();
      if (paramcqi != null) {
        break;
      }
      paramcqi = new v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
      AppMethodBeat.o(138747);
      throw paramcqi;
    }
    paramcqi = (RadarViewController.c.a)paramcqi;
    if (parame != c.e.xiq) {
      paramcqi.xlH.dDp();
    }
    label96:
    RadarViewController.f(this.xlw).dDy();
    AppMethodBeat.o(138747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.e
 * JD-Core Version:    0.7.0.1
 */