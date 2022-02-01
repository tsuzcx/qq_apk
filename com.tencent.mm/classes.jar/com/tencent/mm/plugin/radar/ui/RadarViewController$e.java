package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.radar.b.b;
import com.tencent.mm.plugin.radar.b.b.a;
import com.tencent.mm.plugin.radar.b.b.d;
import com.tencent.mm.plugin.radar.b.b.e;
import com.tencent.mm.plugin.radar.b.b.m;
import com.tencent.mm.plugin.radar.b.d;
import com.tencent.mm.plugin.radar.b.d.c;
import com.tencent.mm.protocal.protobuf.dsq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca.d;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/radar/ui/RadarViewController$initView$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"})
public final class RadarViewController$e
  implements RadarMemberView.b
{
  public final void a(dsq paramdsq, b.e parame)
  {
    AppMethodBeat.i(138746);
    p.k(paramdsq, "member");
    Object localObject1 = g.Hwt;
    String str = g.a(paramdsq);
    if (parame == null)
    {
      AppMethodBeat.o(138746);
      return;
    }
    switch (h.$EnumSwitchMapping$0[parame.ordinal()])
    {
    default: 
      AppMethodBeat.o(138746);
      return;
    case 1: 
      l = RadarViewController.e(this.HwP).aVn(str);
      RadarViewController.c(this.HwP).Hul.put(Long.valueOf(l), new d.c(paramdsq, parame));
      RadarViewController.a(this.HwP, str, b.e.HtN);
      AppMethodBeat.o(138746);
      return;
    }
    Object localObject2 = RadarViewController.e(this.HwP);
    p.k(str, "username");
    localObject1 = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(localObject1, "service(IMessengerStorage::class.java)");
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject1).bbL().RG(str);
    p.j(localObject1, "contact");
    Object localObject3 = (CharSequence)((as)localObject1).getUsername();
    if ((localObject3 == null) || (kotlin.n.n.ba((CharSequence)localObject3)))
    {
      i = 1;
      label213:
      if (i == 0) {
        break label342;
      }
      localObject1 = str;
      label221:
      localObject3 = (String)((b)localObject2).HtD.get(localObject1);
      localObject4 = (CharSequence)localObject3;
      if ((localObject4 != null) && (!kotlin.n.n.ba((CharSequence)localObject4))) {
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
      Log.e(b.TAG, "Verify Contact username(%s) error, verifyTicket is null", new Object[] { localObject1 });
      ((b)localObject2).aVn((String)localObject1);
      l = -1L;
      RadarViewController.c(this.HwP).Hul.put(Long.valueOf(l), new d.c(paramdsq, parame));
      RadarViewController.a(this.HwP, str, b.e.HtN);
      break;
      i = 0;
      break label213;
      localObject1 = ((as)localObject1).getUsername();
      p.j(localObject1, "contact.username");
      break label221;
    }
    label364:
    Object localObject4 = ca.d.bxc((String)localObject3);
    long l = System.currentTimeMillis();
    localObject2 = new b.a((b)localObject2, (b.d)new b.m((b)localObject2, (String)localObject3, l));
    localObject3 = ((ca.d)localObject4).hAs();
    p.j(localObject3, "verify.verifyTicket");
    p.k(localObject3, "verifyTicket");
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username is null", bool);
      ((b.a)localObject2).onStart();
      h.aGY().b((q)new com.tencent.mm.pluginsdk.model.t((String)localObject1, (String)localObject3, 48));
      break;
    }
  }
  
  public final void b(dsq paramdsq, b.e parame)
  {
    AppMethodBeat.i(138747);
    if (paramdsq != null) {
      g localg = g.Hwt;
    }
    for (paramdsq = g.a(paramdsq);; paramdsq = null)
    {
      paramdsq = (View)((Map)RadarViewController.d(this.HwP).HwW).get(paramdsq);
      if (paramdsq == null) {
        break label96;
      }
      paramdsq = paramdsq.getTag();
      if (paramdsq != null) {
        break;
      }
      paramdsq = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
      AppMethodBeat.o(138747);
      throw paramdsq;
    }
    paramdsq = (RadarViewController.c.a)paramdsq;
    if (parame != b.e.HtM) {
      paramdsq.Hxa.fty();
    }
    label96:
    RadarViewController.f(this.HwP).ftI();
    AppMethodBeat.o(138747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.e
 * JD-Core Version:    0.7.0.1
 */