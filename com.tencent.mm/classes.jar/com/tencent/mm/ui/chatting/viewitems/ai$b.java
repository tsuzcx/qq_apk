package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class ai$b
  extends c
  implements com.tencent.mm.modelappbrand.h, t.n
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  private ab lpO;
  
  public ai$b()
  {
    AppMethodBeat.i(37091);
    this.lpO = new ac(this);
    AppMethodBeat.o(37091);
  }
  
  public final void L(View paramView, int paramInt)
  {
    AppMethodBeat.i(37097);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof ai.d))
    {
      AppMethodBeat.o(37097);
      return;
    }
    Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
    paramView = (ai.d)localObject;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      paramView.odq.gZi();
      paramView.odq.setVisibility(4);
      paramView.PLV.setVisibility(4);
      paramView.puw.setVisibility(0);
      paramView.puw.setImageResource(2131689654);
      AppMethodBeat.o(37097);
      return;
    case 0: 
      paramView.odq.setVisibility(0);
      paramView.odq.gZh();
      paramView.PLV.setVisibility(4);
      paramView.puw.setVisibility(4);
      AppMethodBeat.o(37097);
      return;
    case 1: 
      paramView.odq.gZi();
      paramView.odq.setVisibility(4);
      paramView.PLV.setVisibility(4);
      paramView.puw.setVisibility(0);
      paramView.puw.setImageResource(2131690112);
      AppMethodBeat.o(37097);
      return;
    }
    paramView.odq.gZi();
    paramView.odq.setVisibility(4);
    paramView.PLV.setVisibility(0);
    paramView.puw.setVisibility(4);
    AppMethodBeat.o(37097);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37092);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493601);
      paramLayoutInflater = new ai.d().R((View)localObject, false);
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).cU(((View)localObject).getContext());
      paramLayoutInflater.PLV = paramView;
      paramLayoutInflater.PLU.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37092);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37093);
    ai.d locald = (ai.d)parama;
    this.PhN = parama1;
    paramString = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
    paramString.bZ(paramca);
    Object localObject1 = paramca.field_content;
    paramString.bX(paramca);
    if (localObject1 != null) {}
    for (paramString = k.b.aD((String)localObject1, paramca.field_reserved);; paramString = null)
    {
      bq localbq = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
      Object localObject2;
      if (paramString != null)
      {
        locald.PHX.setVisibility(8);
        locald.PHW.setVisibility(8);
        locald.PHT.setVisibility(8);
        locald.PIu.setVisibility(8);
        localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(paramString.izi);
        if (localObject2 == null) {
          break label725;
        }
        localObject1 = ((WxaAttributes)localObject2).field_nickname;
        if (localObject2 == null) {
          break label735;
        }
        localObject2 = ((WxaAttributes)localObject2).field_smallHeadURL;
        label176:
        locald.PIu.setVisibility(0);
        locald.PLT.setVisibility(8);
        locald.PIy.setText(paramString.title);
        locald.PLT.setText(paramString.description);
        locald.PIs.setText((CharSequence)localObject1);
        switch (paramString.izz)
        {
        default: 
          locald.PIt.setText(2131755440);
          label271:
          com.tencent.mm.av.q.bcV().a((String)localObject2, locald.PIr, ai.d.gvY);
          if (gTW())
          {
            localObject1 = (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            if ((paramca.field_status == 2) && (b((com.tencent.mm.ui.chatting.d.b.k)localObject1, paramca.field_msgId))) {
              if (locald.PIn != null) {
                locald.PIn.setVisibility(0);
              }
            }
          }
          break;
        }
      }
      label427:
      label817:
      label825:
      for (;;)
      {
        label344:
        boolean bool = false;
        localObject1 = this;
        label350:
        ((b)localObject1).b(parama, bool);
        parama = (com.tencent.mm.ag.a)paramString.as(com.tencent.mm.ag.a.class);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("app_id", paramString.izj);
        ((Bundle)localObject1).putString("msg_id", paramca.field_msgId);
        if (parama != null)
        {
          parama = parama.iuR;
          ((Bundle)localObject1).putString("cache_key", parama);
          ((Bundle)localObject1).putString("msg_title", paramString.title);
          ((Bundle)localObject1).putString("msg_path", paramString.izh);
          ((Bundle)localObject1).putInt("msg_pkg_type", paramString.izz);
          ((Bundle)localObject1).putInt("pkg_version", paramString.appVersion);
          ((Bundle)localObject1).putInt("widget_type", 0);
          if (!parama1.gRM()) {
            break label817;
          }
        }
        for (int i = 1008;; i = 1007)
        {
          ((Bundle)localObject1).putInt("scene", i);
          ((Bundle)localObject1).putInt("view_init_width", ai.d.PLR);
          ((Bundle)localObject1).putInt("view_init_height", ai.d.PLS);
          locald.PLV.setTag(locald);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).a(com.tencent.mm.plugin.appbrand.ac.n.cO(parama1), locald.PLV, (Bundle)localObject1, this.lpO);
          ((w)com.tencent.mm.kernel.g.af(w.class)).VA(paramString.izi);
          locald.clickArea.setTag(localbq);
          locald.clickArea.setOnClickListener(d(parama1));
          localObject1 = ad.aVe().G(com.tencent.mm.plugin.appbrand.ac.n.cO(parama1), true);
          paramString = (ai.c)((ad.b)localObject1).get("listener", null);
          parama = paramString;
          if (paramString == null)
          {
            parama = new ai.c();
            ((ad.b)localObject1).l("listener", parama);
          }
          parama.n(parama1);
          if (this.qoo) {
            locald.clickArea.setOnLongClickListener(c(parama1));
          }
          a(paramInt, locald, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
          AppMethodBeat.o(37093);
          return;
          label725:
          localObject1 = paramString.eah;
          break;
          label735:
          localObject2 = paramString.izB;
          break label176;
          locald.PIt.setText(2131755704);
          break label271;
          locald.PIt.setText(2131755703);
          break label271;
          if (locald.PIn == null) {
            break label344;
          }
          locald.PIn.setVisibility(8);
          break label344;
          if (paramca.field_status >= 2) {
            break label825;
          }
          bool = true;
          localObject1 = this;
          break label350;
          parama = null;
          break label427;
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37095);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37095);
      return false;
    case 111: 
      e.b.a(parama, paramca, a(parama, paramca));
      AppMethodBeat.o(37095);
      return false;
    case 103: 
      paramMenuItem = paramca.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
        return false;
      }
      paramMenuItem = k.b.HD(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(37095);
        return false;
        parama = new kj();
        parama.dPt.dPu = paramMenuItem.dPu;
        parama.dPt.dFm = paramca.field_msgId;
        parama.dPt.dPv = paramca.field_talker;
        EventCenter.instance.publish(parama);
      }
    case 133: 
      Object localObject = paramca.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = k.b.HD((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.izj);
      ((Bundle)localObject).putString("msg_id", paramca.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.izz);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.izm);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXI().d(parama.Pwc.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37095);
      return false;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXI().cV(parama.Pwc.getContext());
    AppMethodBeat.o(37095);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233812);
    int i = ((bq)paramView.getTag()).position;
    if (paramca.field_content == null)
    {
      AppMethodBeat.o(233812);
      return true;
    }
    k.b localb = k.b.HD(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(233812);
      return true;
    }
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false))) && (!com.tencent.mm.ui.chatting.k.bm(paramca))) {
      paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
    }
    if (((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker))) {
      paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
    }
    ef localef = new ef();
    localef.dHy.msgId = paramca.field_msgId;
    EventCenter.instance.publish(localef);
    if ((localef.dHz.dGX) || (e.b.a(this.PhN.Pwc.getContext(), localb))) {
      paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
    }
    if (!this.PhN.gRN()) {
      paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
    }
    paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXI();
    if ((paramView.aXO()) || (paramView.sE(localb.izz)))
    {
      paramm.add(i, 133, 0, this.PhN.Pwc.getMMResources().getString(2131757443));
      paramm.add(i, 132, 0, this.PhN.Pwc.getMMResources().getString(2131757442));
    }
    AppMethodBeat.o(233812);
    return true;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233813);
    if (paramca.dOQ())
    {
      com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
      bp.Ad(paramca.field_msgId);
      parama.BN(true);
      AppMethodBeat.o(233813);
      return;
    }
    AppMethodBeat.o(233813);
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37096);
    ((b)com.tencent.mm.kernel.g.af(b.class)).akR(paramca.field_talker);
    paramView.getTag();
    paramView = paramca.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    paramView = k.b.HD(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.o(paramView.appId, true, false);
    if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId))) {
      a(parama, paramView, z.aTY(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, paramca.field_msgSvrId, parama.getTalkerUserName());
    }
    localObject1 = new wq();
    ((wq)localObject1).ecI.appId = paramView.izj;
    ((wq)localObject1).ecI.userName = paramView.izi;
    ((wq)localObject1).ecI.ecK = paramView.izh;
    ((wq)localObject1).ecI.ecL = paramView.izz;
    ((wq)localObject1).ecI.ecO = paramView.izl;
    ((wq)localObject1).ecI.appVersion = paramView.izA;
    Object localObject2 = ((wq)localObject1).ecI;
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramView.izz != 0)
    {
      bool = true;
      ((wq.a)localObject2).ecP = bool;
      localObject2 = paramView.izn;
      if (!parama.gRM()) {
        break label354;
      }
      ((wq)localObject1).ecI.scene = 1008;
      localStringBuilder = new StringBuilder(parama.getTalkerUserName());
      localStringBuilder.append(":");
      localStringBuilder.append(a(parama, paramca));
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject2);
    }
    for (((wq)localObject1).ecI.dCw = localStringBuilder.toString();; ((wq)localObject1).ecI.dCw = paramca.toString())
    {
      ((wq)localObject1).ecI.ecR.cyq = parama.getTalkerUserName();
      ((wq)localObject1).ecI.ecR.cyr = paramView.izo;
      EventCenter.instance.publish((IEvent)localObject1);
      AppMethodBeat.o(37096);
      return true;
      bool = false;
      break;
      label354:
      ((wq)localObject1).ecI.scene = 1007;
      paramca = new StringBuilder(a(parama, paramca));
      paramca.append(":");
      paramca.append((String)localObject2);
    }
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.b
 * JD-Core Version:    0.7.0.1
 */