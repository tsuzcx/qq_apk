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
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class ai$a
  extends c
  implements com.tencent.mm.modelappbrand.h
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  private ab lpO;
  
  public ai$a()
  {
    AppMethodBeat.i(37084);
    this.lpO = new ac(this);
    AppMethodBeat.o(37084);
  }
  
  public final void L(View paramView, int paramInt)
  {
    AppMethodBeat.i(37090);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof ai.d))
    {
      AppMethodBeat.o(37090);
      return;
    }
    Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
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
      AppMethodBeat.o(37090);
      return;
    case 0: 
      paramView.odq.setVisibility(0);
      paramView.odq.gZh();
      paramView.puw.setVisibility(4);
      paramView.PLV.setVisibility(4);
      AppMethodBeat.o(37090);
      return;
    case 1: 
      paramView.odq.gZi();
      paramView.odq.setVisibility(4);
      paramView.PLV.setVisibility(4);
      paramView.puw.setVisibility(0);
      paramView.puw.setImageResource(2131690112);
      AppMethodBeat.o(37090);
      return;
    }
    paramView.odq.gZi();
    paramView.odq.setVisibility(4);
    paramView.PLV.setVisibility(0);
    paramView.puw.setVisibility(4);
    AppMethodBeat.o(37090);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37085);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493550);
      paramLayoutInflater = new ai.d().R((View)localObject, true);
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).cU(((View)localObject).getContext());
      paramLayoutInflater.PLV = paramView;
      paramLayoutInflater.PLU.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37085);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37086);
    this.PhN = parama1;
    ai.d locald = (ai.d)parama;
    parama = paramca.field_content;
    Object localObject = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
    ((com.tencent.mm.ui.chatting.d.b.m)localObject).bX(paramca);
    ((com.tencent.mm.ui.chatting.d.b.m)localObject).bY(paramca);
    ((com.tencent.mm.ui.chatting.d.b.m)localObject).bZ(paramca);
    Log.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", new Object[] { paramString });
    bq localbq;
    if (parama != null)
    {
      parama = k.b.aD(parama, paramca.field_reserved);
      localbq = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
      if (parama != null)
      {
        locald.PHX.setVisibility(8);
        locald.PHW.setVisibility(8);
        locald.PIu.setVisibility(8);
        parama.as(com.tencent.mm.ag.h.class);
        locald.clickArea.setBackgroundResource(2131231798);
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.gE(parama.appId, parama.appVersion);
        if (localg != null) {
          b(parama1, parama, paramca);
        }
        if ((parama.fQR != null) && (parama.fQR.length() != 0)) {
          break label815;
        }
        locald.PHZ.setVisibility(8);
        label211:
        localObject = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(parama.izi);
        locald.PIc.setVisibility(0);
        locald.PHT.setVisibility(8);
        locald.PIf.setVisibility(0);
        locald.PId.setVisibility(8);
        if (localObject == null) {
          break label844;
        }
        paramString = ((WxaAttributes)localObject).field_nickname;
        label281:
        if (localObject == null) {
          break label853;
        }
        localObject = ((WxaAttributes)localObject).field_smallHeadURL;
        label293:
        locald.PIu.setVisibility(0);
        locald.PLT.setVisibility(8);
        locald.PIy.setText(parama.title);
        locald.PLT.setText(parama.description);
        locald.PIs.setText(paramString);
        switch (parama.izz)
        {
        default: 
          locald.PIt.setText(2131755440);
          label383:
          com.tencent.mm.av.q.bcV().a((String)localObject, locald.PIr, ai.d.gvY);
          if (!parama1.gRM()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locald.PIb.setVisibility(0);
              c(parama1, locald.PIb, bq.a(parama, paramca));
              label438:
              localObject = (com.tencent.mm.ag.a)parama.as(com.tencent.mm.ag.a.class);
              paramString = new Bundle();
              paramString.putString("app_id", parama.izj);
              paramString.putString("msg_id", paramca.field_msgId);
              if (localObject == null) {
                break label916;
              }
              paramca = ((com.tencent.mm.ag.a)localObject).iuR;
              label509:
              paramString.putString("cache_key", paramca);
              paramString.putString("msg_title", parama.title);
              paramString.putString("msg_path", parama.izh);
              paramString.putInt("msg_pkg_type", parama.izz);
              paramString.putInt("pkg_version", parama.appVersion);
              paramString.putInt("widget_type", 0);
              if (!parama1.gRM()) {
                break label922;
              }
            }
          }
          break;
        }
      }
    }
    label916:
    label922:
    for (paramInt = 1008;; paramInt = 1007)
    {
      paramString.putInt("scene", paramInt);
      paramString.putInt("view_init_width", ai.d.PLR);
      paramString.putInt("view_init_height", ai.d.PLS);
      locald.PLV.setTag(locald);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).a(com.tencent.mm.plugin.appbrand.ac.n.cO(parama1), locald.PLV, paramString, this.lpO);
      ((w)com.tencent.mm.kernel.g.af(w.class)).VA(parama.izi);
      locald.clickArea.setTag(localbq);
      locald.clickArea.setOnClickListener(d(parama1));
      paramString = ad.aVe().G(com.tencent.mm.plugin.appbrand.ac.n.cO(parama1), true);
      paramca = (ai.c)paramString.get("listener", null);
      parama = paramca;
      if (paramca == null)
      {
        parama = new ai.c();
        paramString.l("listener", parama);
      }
      parama.n(parama1);
      if (this.qoo) {
        locald.clickArea.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(37086);
      return;
      Log.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramca.field_msgId), paramString });
      parama = null;
      break;
      label815:
      locald.PHZ.setVisibility(0);
      b(parama1, locald.PHZ, bq.bnn(parama.fQR));
      break label211;
      label844:
      paramString = parama.eah;
      break label281;
      label853:
      localObject = parama.izB;
      break label293;
      locald.PIt.setText(2131755704);
      break label383;
      locald.PIt.setText(2131755703);
      break label383;
      locald.PIb.setVisibility(8);
      break label438;
      locald.PIb.setVisibility(8);
      break label438;
      paramca = null;
      break label509;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37088);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37088);
      return false;
    case 111: 
      e.b.a(parama, paramca, a(parama, paramca));
      AppMethodBeat.o(37088);
      return false;
    case 133: 
      Object localObject = paramca.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = k.b.HD((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37088);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.izj);
      ((Bundle)localObject).putString("msg_id", paramca.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.izz);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.izm);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXI().d(parama.Pwc.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37088);
      return false;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.g.class)).aXI().cV(parama.Pwc.getContext());
    AppMethodBeat.o(37088);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233811);
    int i = ((bq)paramView.getTag()).position;
    k.b localb = k.b.HD(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
    Object localObject;
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false))) && (!k.bm(paramca)))
    {
      if (localb.type != 6) {
        break label366;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.m.bdJ(localb.dCK);
      if (((localObject == null) || (!e.b.h(paramca, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))) && (!paramca.gDB())) {
        paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
      }
    }
    for (;;)
    {
      localObject = new ef();
      ((ef)localObject).dHy.msgId = paramca.field_msgId;
      EventCenter.instance.publish((IEvent)localObject);
      if ((((ef)localObject).dHz.dGX) || (e.b.a(this.PhN.Pwc.getContext(), localb))) {
        paramm.a(i, 129, paramView.getContext().getString(2131757440), 2131690628);
      }
      if (br.B(paramca)) {
        paramm.clear();
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
      AppMethodBeat.o(233811);
      return true;
      label366:
      paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
    }
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37089);
    com.tencent.mm.modelstat.a.a(paramca, a.a.jma);
    ((b)com.tencent.mm.kernel.g.af(b.class)).akR(paramca.field_talker);
    if (paramca.field_content == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    Object localObject1 = k.b.HD(bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
    if (localObject1 == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    paramView = com.tencent.mm.pluginsdk.model.app.h.o(((k.b)localObject1).appId, false, false);
    if (paramView != null) {
      a(parama, (k.b)localObject1, d(parama, paramca), paramView, paramca.field_msgSvrId, parama.getTalkerUserName());
    }
    Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((k.b)localObject1).izi, ((k.b)localObject1).izh, ((k.b)localObject1).izj, ((k.b)localObject1).url, Integer.valueOf(((k.b)localObject1).izz), ((k.b)localObject1).izl });
    paramView = new wq();
    paramView.ecI.appId = ((k.b)localObject1).izj;
    paramView.ecI.userName = ((k.b)localObject1).izi;
    paramView.ecI.ecK = ((k.b)localObject1).izh;
    paramView.ecI.ecL = ((k.b)localObject1).izz;
    paramView.ecI.ecO = ((k.b)localObject1).izl;
    paramView.ecI.appVersion = ((k.b)localObject1).izA;
    Object localObject2 = paramView.ecI;
    boolean bool;
    if (((k.b)localObject1).izz != 0)
    {
      bool = true;
      ((wq.a)localObject2).ecP = bool;
      paramView.ecI.ecR.cyq = parama.getTalkerUserName();
      paramView.ecI.ecR.cyr = ((k.b)localObject1).izo;
      localObject1 = ((k.b)localObject1).izn;
      if (!parama.gRM()) {
        break label420;
      }
      paramView.ecI.scene = 1008;
      localObject2 = new StringBuilder(parama.getTalkerUserName());
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(a(parama, paramca));
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    for (paramView.ecI.dCw = ((StringBuilder)localObject2).toString();; paramView.ecI.dCw = parama.toString())
    {
      EventCenter.instance.publish(paramView);
      AppMethodBeat.o(37089);
      return true;
      bool = false;
      break;
      label420:
      paramView.ecI.scene = 1007;
      parama = new StringBuilder(a(parama, paramca));
      parama.append(":");
      parama.append((String)localObject1);
    }
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.a
 * JD-Core Version:    0.7.0.1
 */