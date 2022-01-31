package com.tencent.mm.plugin.radar.ui;

import a.k;
import android.view.View;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.radar.b.c;
import com.tencent.mm.plugin.radar.b.c.a;
import com.tencent.mm.plugin.radar.b.c.d;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.plugin.radar.b.c.m;
import com.tencent.mm.plugin.radar.b.e.c;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi.d;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class RadarViewController$e
  implements RadarMemberView.b
{
  public final void a(bio parambio, c.e parame)
  {
    a.d.b.g.k(parambio, "member");
    Object localObject1 = g.nnt;
    String str = g.b(parambio);
    if (parame == null) {
      return;
    }
    switch (h.fHS[parame.ordinal()])
    {
    default: 
      return;
    case 1: 
      l = RadarViewController.e(this.nnP).Lw(str);
      RadarViewController.c(this.nnP).nlh.put(Long.valueOf(l), new e.c(parambio, parame));
      RadarViewController.a(this.nnP, str, c.e.nkF);
      return;
    }
    Object localObject2 = RadarViewController.e(this.nnP);
    a.d.b.g.k(str, "username");
    localObject1 = com.tencent.mm.kernel.g.r(j.class);
    a.d.b.g.j(localObject1, "service(IMessengerStorage::class.java)");
    localObject1 = ((j)localObject1).Fw().abl(str);
    a.d.b.g.j(localObject1, "contact");
    Object localObject3 = (CharSequence)((ad)localObject1).getUsername();
    if ((localObject3 == null) || (a.h.e.X((CharSequence)localObject3)))
    {
      i = 1;
      if (i == 0) {
        break label323;
      }
      localObject1 = str;
      label199:
      localObject3 = (String)((c)localObject2).nkv.get(localObject1);
      localObject4 = (CharSequence)localObject3;
      if ((localObject4 != null) && (!a.h.e.X((CharSequence)localObject4))) {
        break label340;
      }
    }
    label323:
    label340:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label345;
      }
      localObject3 = c.nkz;
      y.e(c.access$getTAG$cp(), "Verify Contact username(%s) error, verifyTicket is null", new Object[] { localObject1 });
      ((c)localObject2).Lw((String)localObject1);
      l = -1L;
      RadarViewController.c(this.nnP).nlh.put(Long.valueOf(l), new e.c(parambio, parame));
      RadarViewController.a(this.nnP, str, c.e.nkF);
      return;
      i = 0;
      break;
      localObject1 = ((ad)localObject1).getUsername();
      a.d.b.g.j(localObject1, "contact.username");
      break label199;
    }
    label345:
    Object localObject4 = bi.d.acc((String)localObject3);
    long l = System.currentTimeMillis();
    localObject2 = new c.a((c)localObject2, (c.d)new c.m((c)localObject2, (String)localObject3, l));
    localObject3 = ((bi.d)localObject4).cvP();
    a.d.b.g.j(localObject3, "verify.verifyTicket");
    a.d.b.g.k(localObject3, "verifyTicket");
    if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("username is null", bool);
      ((c.a)localObject2).onStart();
      com.tencent.mm.kernel.g.Dk().d((com.tencent.mm.ah.m)new com.tencent.mm.pluginsdk.model.m((String)localObject1, (String)localObject3, 48, (byte)0));
      break;
    }
  }
  
  public final void b(bio parambio, c.e parame)
  {
    if (parambio != null) {
      g localg = g.nnt;
    }
    for (parambio = g.b(parambio);; parambio = null)
    {
      parambio = (View)((Map)RadarViewController.d(this.nnP).nnW).get(parambio);
      if (parambio == null) {
        break label83;
      }
      parambio = parambio.getTag();
      if (parambio != null) {
        break;
      }
      throw new k("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
    }
    parambio = (RadarViewController.c.a)parambio;
    if (parame != c.e.nkE) {
      parambio.noa.buL();
    }
    label83:
    RadarViewController.f(this.nnP).buU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.e
 * JD-Core Version:    0.7.0.1
 */