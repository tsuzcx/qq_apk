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
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.a.xw.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
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
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class al$a
  extends c
  implements com.tencent.mm.modelappbrand.h
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  private ab oky;
  
  public al$a()
  {
    AppMethodBeat.i(37084);
    this.oky = new ac(this);
    AppMethodBeat.o(37084);
  }
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(37090);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof al.d))
    {
      AppMethodBeat.o(37090);
      return;
    }
    Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
    paramView = (al.d)localObject;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      paramView.rfc.hZY();
      paramView.rfc.setVisibility(4);
      paramView.XhP.setVisibility(4);
      paramView.sDJ.setVisibility(0);
      paramView.sDJ.setImageResource(R.k.app_brand_share_page_cover_default);
      AppMethodBeat.o(37090);
      return;
    case 0: 
      paramView.rfc.setVisibility(0);
      paramView.rfc.hZX();
      paramView.sDJ.setVisibility(4);
      paramView.XhP.setVisibility(4);
      AppMethodBeat.o(37090);
      return;
    case 1: 
      paramView.rfc.hZY();
      paramView.rfc.setVisibility(4);
      paramView.XhP.setVisibility(4);
      paramView.sDJ.setVisibility(0);
      paramView.sDJ.setImageResource(R.k.dynamic_page_res_not_found);
      AppMethodBeat.o(37090);
      return;
    }
    paramView.rfc.hZY();
    paramView.rfc.setVisibility(4);
    paramView.XhP.setVisibility(0);
    paramView.sDJ.setVisibility(4);
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
      localObject = new aq(paramLayoutInflater, R.i.edh);
      paramLayoutInflater = new al.d().V((View)localObject, true);
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.g.class)).cR(((View)localObject).getContext());
      paramLayoutInflater.XhP = paramView;
      paramLayoutInflater.XhO.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37085);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37086);
    this.WBq = parama1;
    al.d locald = (al.d)parama;
    parama = paramca.field_content;
    Object localObject = (com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class);
    ((com.tencent.mm.ui.chatting.d.b.m)localObject).cr(paramca);
    ((com.tencent.mm.ui.chatting.d.b.m)localObject).cs(paramca);
    ((com.tencent.mm.ui.chatting.d.b.m)localObject).ct(paramca);
    Log.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", new Object[] { paramString });
    by localby;
    if (parama != null)
    {
      parama = k.b.aG(parama, paramca.field_reserved);
      localby = new by(paramca, parama1.hRi(), paramInt, null, '\000');
      if (parama != null)
      {
        locald.Xds.setVisibility(8);
        locald.Xdr.setVisibility(8);
        locald.XdP.setVisibility(8);
        parama.ar(com.tencent.mm.aj.h.class);
        locald.clickArea.setBackgroundResource(R.g.chatto_bg_app);
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.hn(parama.appId, parama.appVersion);
        if (localg != null) {
          b(parama1, parama, paramca);
        }
        if ((parama.ilh != null) && (parama.ilh.length() != 0)) {
          break label815;
        }
        locald.Xdu.setVisibility(8);
        label212:
        localObject = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(parama.loA);
        locald.Xdx.setVisibility(0);
        locald.Xdo.setVisibility(8);
        locald.XdA.setVisibility(0);
        locald.Xdy.setVisibility(8);
        if (localObject == null) {
          break label844;
        }
        paramString = ((WxaAttributes)localObject).field_nickname;
        label282:
        if (localObject == null) {
          break label853;
        }
        localObject = ((WxaAttributes)localObject).field_smallHeadURL;
        label294:
        locald.XdP.setVisibility(0);
        locald.XhN.setVisibility(8);
        locald.XdT.setText(parama.title);
        locald.XhN.setText(parama.description);
        locald.XdN.setText(paramString);
        switch (parama.loT)
        {
        default: 
          locald.XdO.setText(R.l.app_brand_entrance);
          label383:
          com.tencent.mm.ay.q.bml().a((String)localObject, locald.XdM, al.d.jak);
          if (!parama1.hRi()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locald.Xdw.setVisibility(0);
              c(parama1, locald.Xdw, by.a(parama, paramca));
              label438:
              localObject = (com.tencent.mm.aj.a)parama.ar(com.tencent.mm.aj.a.class);
              paramString = new Bundle();
              paramString.putString("app_id", parama.loB);
              paramString.putString("msg_id", paramca.field_msgId);
              if (localObject == null) {
                break label916;
              }
              paramca = ((com.tencent.mm.aj.a)localObject).lka;
              label509:
              paramString.putString("cache_key", paramca);
              paramString.putString("msg_title", parama.title);
              paramString.putString("msg_path", parama.loz);
              paramString.putInt("msg_pkg_type", parama.loT);
              paramString.putInt("pkg_version", parama.appVersion);
              paramString.putInt("widget_type", 0);
              if (!parama1.hRi()) {
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
      paramString.putInt("view_init_width", al.d.XhL);
      paramString.putInt("view_init_height", al.d.XhM);
      locald.XhP.setTag(locald);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.g.class)).a(com.tencent.mm.plugin.appbrand.ac.n.cP(parama1), locald.XhP, paramString, this.oky);
      ((w)com.tencent.mm.kernel.h.ae(w.class)).adj(parama.loA);
      locald.clickArea.setTag(localby);
      locald.clickArea.setOnClickListener(d(parama1));
      paramString = ad.beh().I(com.tencent.mm.plugin.appbrand.ac.n.cP(parama1), true);
      paramca = (al.c)paramString.get("listener", null);
      parama = paramca;
      if (paramca == null)
      {
        parama = new al.c();
        paramString.k("listener", parama);
      }
      parama.n(parama1);
      if (this.tMW) {
        locald.clickArea.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(37086);
      return;
      Log.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramca.field_msgId), paramString });
      parama = null;
      break;
      label815:
      locald.Xdu.setVisibility(0);
      b(parama1, locald.Xdu, by.bzO(parama.ilh));
      break label212;
      label844:
      paramString = parama.fUe;
      break label282;
      label853:
      localObject = parama.loV;
      break label294;
      locald.XdO.setText(R.l.app_brand_share_wxa_testing_tag);
      break label383;
      locald.XdO.setText(R.l.app_brand_share_wxa_preview_tag);
      break label383;
      locald.Xdw.setVisibility(8);
      break label438;
      locald.Xdw.setVisibility(8);
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
        paramMenuItem = k.b.OQ((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37088);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.loB);
      ((Bundle)localObject).putString("msg_id", paramca.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.loT);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.loE);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.g.class)).bgR().e(parama.WQv.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37088);
      return false;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.g.class)).bgR().cS(parama.WQv.getContext());
    AppMethodBeat.o(37088);
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(280450);
    int i = ((by)paramView.getTag()).position;
    k.b localb = k.b.OQ(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
    Object localObject;
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false))) && (!k.bF(paramca)) && (!bs.O(paramca)))
    {
      if (localb.type != 6) {
        break label373;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.m.bqf(localb.fvr);
      if (((localObject == null) || (!e.b.j(paramca, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))) && (!paramca.Ic())) {
        paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
    }
    for (;;)
    {
      localObject = new em();
      ((em)localObject).fAp.msgId = paramca.field_msgId;
      EventCenter.instance.publish((IEvent)localObject);
      if ((((em)localObject).fAq.fzO) || (e.b.a(this.WBq.WQv.getContext(), localb))) {
        paramo.a(i, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
      }
      if (bs.D(paramca)) {
        paramo.clear();
      }
      if (!this.WBq.hRj()) {
        paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      }
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.g.class)).bgR();
      if ((paramView.bgX()) || (paramView.vB(localb.loT)))
      {
        paramo.add(i, 133, 0, this.WBq.WQv.getMMResources().getString(R.l.evX));
        paramo.add(i, 132, 0, this.WBq.WQv.getMMResources().getString(R.l.evW));
      }
      AppMethodBeat.o(280450);
      return true;
      label373:
      paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37089);
    com.tencent.mm.modelstat.a.a(paramca, a.a.mcb);
    ((b)com.tencent.mm.kernel.h.ae(b.class)).asK(paramca.field_talker);
    if (paramca.field_content == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    Object localObject1 = k.b.OQ(bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
    if (localObject1 == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    paramView = com.tencent.mm.pluginsdk.model.app.h.o(((k.b)localObject1).appId, false, false);
    if (paramView != null) {
      a(parama, (k.b)localObject1, d(parama, paramca), paramView, paramca.field_msgSvrId, parama.getTalkerUserName());
    }
    Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((k.b)localObject1).loA, ((k.b)localObject1).loz, ((k.b)localObject1).loB, ((k.b)localObject1).url, Integer.valueOf(((k.b)localObject1).loT), ((k.b)localObject1).loD });
    paramView = new xw();
    paramView.fWN.appId = ((k.b)localObject1).loB;
    paramView.fWN.userName = ((k.b)localObject1).loA;
    paramView.fWN.fWP = ((k.b)localObject1).loz;
    paramView.fWN.fWQ = ((k.b)localObject1).loT;
    paramView.fWN.fWT = ((k.b)localObject1).loD;
    paramView.fWN.appVersion = ((k.b)localObject1).loU;
    Object localObject2 = paramView.fWN;
    boolean bool;
    if (((k.b)localObject1).loT != 0)
    {
      bool = true;
      ((xw.a)localObject2).fWU = bool;
      paramView.fWN.fWW.cwT = parama.getTalkerUserName();
      paramView.fWN.fWW.cwU = ((k.b)localObject1).loG;
      localObject1 = ((k.b)localObject1).loF;
      if (!parama.hRi()) {
        break label420;
      }
      paramView.fWN.scene = 1008;
      localObject2 = new StringBuilder(parama.getTalkerUserName());
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(a(parama, paramca));
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    for (paramView.fWN.fvd = ((StringBuilder)localObject2).toString();; paramView.fWN.fvd = parama.toString())
    {
      EventCenter.instance.publish(paramView);
      AppMethodBeat.o(37089);
      return true;
      bool = false;
      break;
      label420:
      paramView.fWN.scene = 1007;
      parama = new StringBuilder(a(parama, paramca));
      parama.append(":");
      parama.append((String)localObject1);
    }
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al.a
 * JD-Core Version:    0.7.0.1
 */