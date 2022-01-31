package com.tencent.mm.plugin.radar.ui;

import a.l;
import a.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.plugin.radar.b.c.a;
import com.tencent.mm.plugin.radar.b.c.d;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.plugin.radar.b.c.m;
import com.tencent.mm.plugin.radar.b.e;
import com.tencent.mm.plugin.radar.b.e.c;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi.d;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/ui/RadarViewController$initView$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
public final class RadarViewController$e
  implements RadarMemberView.b
{
  public final void a(brg parambrg, c.e parame)
  {
    AppMethodBeat.i(103095);
    a.f.b.j.q(parambrg, "member");
    Object localObject1 = g.pSH;
    String str = g.b(parambrg);
    if (parame == null)
    {
      AppMethodBeat.o(103095);
      return;
    }
    switch (h.bLo[parame.ordinal()])
    {
    default: 
      AppMethodBeat.o(103095);
      return;
    case 1: 
      l = RadarViewController.e(this.pTd).XG(str);
      RadarViewController.c(this.pTd).pQw.put(Long.valueOf(l), new e.c(parambrg, parame));
      RadarViewController.a(this.pTd, str, c.e.pPV);
      AppMethodBeat.o(103095);
      return;
    }
    Object localObject2 = RadarViewController.e(this.pTd);
    a.f.b.j.q(str, "username");
    localObject1 = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(localObject1, "service(IMessengerStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject1).YA().arw(str);
    a.f.b.j.p(localObject1, "contact");
    Object localObject3 = (CharSequence)((ad)localObject1).getUsername();
    if ((localObject3 == null) || (a.l.m.ap((CharSequence)localObject3)))
    {
      i = 1;
      label213:
      if (i == 0) {
        break label342;
      }
      localObject1 = str;
      label221:
      localObject3 = (String)((c)localObject2).pPL.get(localObject1);
      localObject4 = (CharSequence)localObject3;
      if ((localObject4 != null) && (!a.l.m.ap((CharSequence)localObject4))) {
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
      ab.e(c.TAG, "Verify Contact username(%s) error, verifyTicket is null", new Object[] { localObject1 });
      ((c)localObject2).XG((String)localObject1);
      l = -1L;
      RadarViewController.c(this.pTd).pQw.put(Long.valueOf(l), new e.c(parambrg, parame));
      RadarViewController.a(this.pTd, str, c.e.pPV);
      break;
      i = 0;
      break label213;
      localObject1 = ((ad)localObject1).getUsername();
      a.f.b.j.p(localObject1, "contact.username");
      break label221;
    }
    label364:
    Object localObject4 = bi.d.asm((String)localObject3);
    long l = System.currentTimeMillis();
    localObject2 = new c.a((c)localObject2, (c.d)new c.m((c)localObject2, (String)localObject3, l));
    localObject3 = ((bi.d)localObject4).dyx();
    a.f.b.j.p(localObject3, "verify.verifyTicket");
    a.f.b.j.q(localObject3, "verifyTicket");
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username is null", bool);
      ((c.a)localObject2).onStart();
      com.tencent.mm.kernel.g.Rc().b((com.tencent.mm.ai.m)new com.tencent.mm.pluginsdk.model.m((String)localObject1, (String)localObject3, 48));
      break;
    }
  }
  
  public final void b(brg parambrg, c.e parame)
  {
    AppMethodBeat.i(103096);
    if (parambrg != null) {
      g localg = g.pSH;
    }
    for (parambrg = g.b(parambrg);; parambrg = null)
    {
      parambrg = (View)((Map)RadarViewController.d(this.pTd).pTk).get(parambrg);
      if (parambrg == null) {
        break label96;
      }
      parambrg = parambrg.getTag();
      if (parambrg != null) {
        break;
      }
      parambrg = new v("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
      AppMethodBeat.o(103096);
      throw parambrg;
    }
    parambrg = (RadarViewController.c.a)parambrg;
    if (parame != c.e.pPU) {
      parambrg.pTo.ceX();
    }
    label96:
    RadarViewController.f(this.pTd).cfg();
    AppMethodBeat.o(103096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.e
 * JD-Core Version:    0.7.0.1
 */