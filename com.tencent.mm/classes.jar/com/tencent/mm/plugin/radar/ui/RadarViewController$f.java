package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.radar.model.b;
import com.tencent.mm.plugin.radar.model.b.a;
import com.tencent.mm.plugin.radar.model.b.d;
import com.tencent.mm.plugin.radar.model.b.e;
import com.tencent.mm.plugin.radar.model.b.h;
import com.tencent.mm.plugin.radar.model.d.c;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc.f;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/radar/ui/RadarViewController$initView$1", "Lcom/tencent/mm/plugin/radar/ui/RadarMemberView$OnConfirmBtnClickListener;", "onClick", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "onDismissed", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RadarViewController$f
  implements RadarMemberView.b
{
  RadarViewController$f(RadarViewController paramRadarViewController) {}
  
  public final void a(ell paramell, b.e parame)
  {
    com.tencent.mm.plugin.radar.model.d locald = null;
    AppMethodBeat.i(138746);
    kotlin.g.b.s.u(paramell, "member");
    Object localObject1 = d.Nua;
    String str = d.a(paramell);
    if (parame == null) {}
    for (int i = -1;; i = a.$EnumSwitchMapping$0[parame.ordinal()]) {
      switch (i)
      {
      default: 
        AppMethodBeat.o(138746);
        return;
      }
    }
    long l = RadarViewController.a(this.Nuw).aSv(str);
    locald = RadarViewController.b(this.Nuw);
    localObject1 = locald;
    if (locald == null)
    {
      kotlin.g.b.s.bIx("radarManager");
      localObject1 = null;
    }
    ((com.tencent.mm.plugin.radar.model.d)localObject1).Nsb.put(Long.valueOf(l), new d.c(paramell, parame));
    RadarViewController.a(this.Nuw, str, b.e.NrD);
    AppMethodBeat.o(138746);
    return;
    Object localObject2 = RadarViewController.a(this.Nuw);
    kotlin.g.b.s.u(str, "username");
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(str);
    Object localObject3 = (CharSequence)((az)localObject1).field_username;
    label220:
    label228:
    Object localObject4;
    if ((localObject3 == null) || (kotlin.n.n.bp((CharSequence)localObject3)))
    {
      i = 1;
      if (i == 0) {
        break label367;
      }
      localObject1 = str;
      localObject3 = (String)((b)localObject2).Nrv.get(localObject1);
      localObject4 = (CharSequence)localObject3;
      if ((localObject4 != null) && (!kotlin.n.n.bp((CharSequence)localObject4))) {
        break label384;
      }
      i = 1;
      label265:
      if (i == 0) {
        break label389;
      }
      Log.e(b.TAG, "Verify Contact username(%s) error, verifyTicket is null", new Object[] { localObject1 });
      ((b)localObject2).aSv((String)localObject1);
      l = -1L;
      localObject1 = RadarViewController.b(this.Nuw);
      if (localObject1 != null) {
        break label515;
      }
      kotlin.g.b.s.bIx("radarManager");
      localObject1 = locald;
    }
    label384:
    label515:
    for (;;)
    {
      ((com.tencent.mm.plugin.radar.model.d)localObject1).Nsb.put(Long.valueOf(l), new d.c(paramell, parame));
      RadarViewController.a(this.Nuw, str, b.e.NrD);
      break;
      i = 0;
      break label220;
      label367:
      localObject1 = ((az)localObject1).field_username;
      kotlin.g.b.s.s(localObject1, "contact.username");
      break label228;
      i = 0;
      break label265;
      label389:
      localObject4 = cc.f.byv((String)localObject3);
      l = System.currentTimeMillis();
      localObject2 = new b.a((b)localObject2, (b.d)new b.h((String)localObject3, (b)localObject2, l));
      if (localObject4 != null)
      {
        localObject3 = ((cc.f)localObject4).pPi;
        kotlin.g.b.s.s(localObject3, "verify.verifyTicket");
        kotlin.g.b.s.u(localObject3, "verifyTicket");
        if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
          break label509;
        }
      }
      label509:
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("username is null", bool);
        ((b.a)localObject2).onStart();
        h.aZW().a((p)new v((String)localObject1, (String)localObject3, 48), 0);
        break;
      }
    }
  }
  
  public final void b(ell paramell, b.e parame)
  {
    Object localObject1 = null;
    AppMethodBeat.i(138747);
    Object localObject2;
    if (paramell != null)
    {
      localObject2 = d.Nua;
      paramell = d.a(paramell);
      localObject2 = RadarViewController.c(this.Nuw);
      if (localObject2 != null) {
        break label94;
      }
      kotlin.g.b.s.bIx("adapter");
    }
    for (;;)
    {
      paramell = (View)((Map)localObject1.NuD).get(paramell);
      if (paramell == null) {
        break label119;
      }
      paramell = paramell.getTag();
      if (paramell != null) {
        break label100;
      }
      paramell = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
      AppMethodBeat.o(138747);
      throw paramell;
      paramell = null;
      break;
      label94:
      localObject1 = localObject2;
    }
    label100:
    paramell = (RadarViewController.c.a)paramell;
    if (parame != b.e.NrC) {
      paramell.NuH.gFl();
    }
    label119:
    RadarViewController.d(this.Nuw).gFw();
    AppMethodBeat.o(138747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarViewController.f
 * JD-Core Version:    0.7.0.1
 */