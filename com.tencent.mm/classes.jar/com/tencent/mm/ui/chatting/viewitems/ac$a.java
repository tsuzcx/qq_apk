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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class ac$a
  extends c
  implements com.tencent.mm.modelappbrand.h
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  private ab kmd;
  
  public ac$a()
  {
    AppMethodBeat.i(37084);
    this.kmd = new ac(this);
    AppMethodBeat.o(37084);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(37090);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof ac.d))
    {
      AppMethodBeat.o(37090);
      return;
    }
    ae.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
    paramView = (ac.d)localObject;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      paramView.mQm.fQe();
      paramView.mQm.setVisibility(4);
      paramView.Kzv.setVisibility(4);
      paramView.oZd.setVisibility(0);
      paramView.oZd.setImageResource(2131689648);
      AppMethodBeat.o(37090);
      return;
    case 0: 
      paramView.mQm.setVisibility(0);
      paramView.mQm.fQd();
      paramView.oZd.setVisibility(4);
      paramView.Kzv.setVisibility(4);
      AppMethodBeat.o(37090);
      return;
    case 1: 
      paramView.mQm.fQe();
      paramView.mQm.setVisibility(4);
      paramView.Kzv.setVisibility(4);
      paramView.oZd.setVisibility(0);
      paramView.oZd.setImageResource(2131690080);
      AppMethodBeat.o(37090);
      return;
    }
    paramView.mQm.fQe();
    paramView.mQm.setVisibility(4);
    paramView.Kzv.setVisibility(0);
    paramView.oZd.setVisibility(4);
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
      localObject = new ah(paramLayoutInflater, 2131493449);
      paramLayoutInflater = new ac.d().L((View)localObject, true);
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).cy(((View)localObject).getContext());
      paramLayoutInflater.Kzv = paramView;
      paramLayoutInflater.Kzu.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37085);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37086);
    this.JWz = parama1;
    ac.d locald = (ac.d)parama;
    parama = parambv.field_content;
    Object localObject = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
    ((com.tencent.mm.ui.chatting.d.b.m)localObject).bH(parambv);
    ((com.tencent.mm.ui.chatting.d.b.m)localObject).bI(parambv);
    ((com.tencent.mm.ui.chatting.d.b.m)localObject).bJ(parambv);
    ae.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", new Object[] { paramString });
    bk localbk;
    if (parama != null)
    {
      parama = k.b.aB(parama, parambv.field_reserved);
      localbk = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
      if (parama != null)
      {
        locald.KvG.setVisibility(8);
        locald.KvF.setVisibility(8);
        locald.Kwd.setVisibility(8);
        parama.ao(com.tencent.mm.ah.h.class);
        locald.olI.setBackgroundResource(2131231727);
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.gg(parama.appId, parama.aDD);
        if (localg != null) {
          b(parama1, parama, parambv);
        }
        if ((parama.fmn != null) && (parama.fmn.length() != 0)) {
          break label815;
        }
        locald.KvI.setVisibility(8);
        label211:
        localObject = ((o)com.tencent.mm.kernel.g.ab(o.class)).Ob(parama.hFc);
        locald.KvL.setVisibility(0);
        locald.KvC.setVisibility(8);
        locald.KvO.setVisibility(0);
        locald.KvM.setVisibility(8);
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
        locald.Kwd.setVisibility(0);
        locald.Kzt.setVisibility(8);
        locald.Kwh.setText(parama.title);
        locald.Kzt.setText(parama.description);
        locald.Kwb.setText(paramString);
        switch (parama.hFr)
        {
        default: 
          locald.Kwc.setText(2131755401);
          label383:
          q.aJb().a((String)localObject, locald.Kwa, ac.d.fQP);
          if (!parama1.fJC()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locald.KvK.setVisibility(0);
              c(parama1, locald.KvK, bk.a(parama, parambv));
              label438:
              localObject = (com.tencent.mm.ah.a)parama.ao(com.tencent.mm.ah.a.class);
              paramString = new Bundle();
              paramString.putString("app_id", parama.hFd);
              paramString.putString("msg_id", parambv.field_msgId);
              if (localObject == null) {
                break label916;
              }
              parambv = ((com.tencent.mm.ah.a)localObject).hAK;
              label509:
              paramString.putString("cache_key", parambv);
              paramString.putString("msg_title", parama.title);
              paramString.putString("msg_path", parama.hFb);
              paramString.putInt("msg_pkg_type", parama.hFr);
              paramString.putInt("pkg_version", parama.aDD);
              paramString.putInt("widget_type", 0);
              if (!parama1.fJC()) {
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
      paramString.putInt("view_init_width", ac.d.Kzr);
      paramString.putInt("view_init_height", ac.d.Kzs);
      locald.Kzv.setTag(locald);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).a(com.tencent.mm.plugin.appbrand.y.n.cH(parama1), locald.Kzv, paramString, this.kmd);
      ((s)com.tencent.mm.kernel.g.ab(s.class)).Mt(parama.hFc);
      locald.olI.setTag(localbk);
      locald.olI.setOnClickListener(d(parama1));
      paramString = z.aBG().F(com.tencent.mm.plugin.appbrand.y.n.cH(parama1), true);
      parambv = (ac.c)paramString.get("listener", null);
      parama = parambv;
      if (parambv == null)
      {
        parama = new ac.c();
        paramString.k("listener", parama);
      }
      parama.n(parama1);
      if (this.oZq) {
        locald.olI.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(37086);
      return;
      ae.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambv.field_msgId), paramString });
      parama = null;
      break;
      label815:
      locald.KvI.setVisibility(0);
      b(parama1, locald.KvI, bk.aYj(parama.fmn));
      break label211;
      label844:
      paramString = parama.dIu;
      break label281;
      label853:
      localObject = parama.hFt;
      break label293;
      locald.Kwc.setText(2131755657);
      break label383;
      locald.Kwc.setText(2131755656);
      break label383;
      locald.KvK.setVisibility(8);
      break label438;
      locald.KvK.setVisibility(8);
      break label438;
      parambv = null;
      break label509;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37088);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37088);
      return false;
    case 111: 
      e.b.a(parama, parambv, b(parama, parambv));
      AppMethodBeat.o(37088);
      return false;
    case 133: 
      Object localObject = parambv.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = k.b.zb((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37088);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.hFd);
      ((Bundle)localObject).putString("msg_id", parambv.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.hFr);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.hFg);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().d(parama.Kkd.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37088);
      return false;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().cz(parama.Kkd.getContext());
    AppMethodBeat.o(37088);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187812);
    int i = ((bk)paramView.getTag()).position;
    k.b localb = k.b.zb(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
    Object localObject;
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.m(localb.appId, false, false))) && (!k.aW(parambv)))
    {
      if (localb.type != 6) {
        break label366;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.m.aNj(localb.dlu);
      if (((localObject == null) || (!e.b.f(parambv, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))) && (!parambv.fvU())) {
        paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
      }
    }
    for (;;)
    {
      localObject = new ec();
      ((ec)localObject).dql.msgId = parambv.field_msgId;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if ((((ec)localObject).dqm.dpK) || (e.b.a(this.JWz.Kkd.getContext(), localb))) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if (bn.z(parambv)) {
        paraml.clear();
      }
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
      }
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV();
      if ((paramView.aEb()) || (paramView.oQ(localb.hFr)))
      {
        paraml.add(i, 133, 0, this.JWz.Kkd.getMMResources().getString(2131757231));
        paraml.add(i, 132, 0, this.JWz.Kkd.getMMResources().getString(2131757230));
      }
      AppMethodBeat.o(187812);
      return true;
      label366:
      paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37089);
    com.tencent.mm.modelstat.a.a(parambv, a.a.iqQ);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
    if (parambv.field_content == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    Object localObject1 = k.b.zb(bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
    if (localObject1 == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    paramView = com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject1).appId, false, false);
    if (paramView != null) {
      a(parama, (k.b)localObject1, d(parama, parambv), paramView, parambv.field_msgSvrId, parama.getTalkerUserName());
    }
    ae.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((k.b)localObject1).hFc, ((k.b)localObject1).hFb, ((k.b)localObject1).hFd, ((k.b)localObject1).url, Integer.valueOf(((k.b)localObject1).hFr), ((k.b)localObject1).hFf });
    paramView = new vq();
    paramView.dKT.appId = ((k.b)localObject1).hFd;
    paramView.dKT.userName = ((k.b)localObject1).hFc;
    paramView.dKT.dKV = ((k.b)localObject1).hFb;
    paramView.dKT.dKW = ((k.b)localObject1).hFr;
    paramView.dKT.dKZ = ((k.b)localObject1).hFf;
    paramView.dKT.aDD = ((k.b)localObject1).hFs;
    Object localObject2 = paramView.dKT;
    boolean bool;
    if (((k.b)localObject1).hFr != 0)
    {
      bool = true;
      ((vq.a)localObject2).dLa = bool;
      paramView.dKT.dLc.cmv = parama.getTalkerUserName();
      paramView.dKT.dLc.cmw = ((k.b)localObject1).hFi;
      localObject1 = ((k.b)localObject1).hFh;
      if (!parama.fJC()) {
        break label420;
      }
      paramView.dKT.scene = 1008;
      localObject2 = new StringBuilder(parama.getTalkerUserName());
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(b(parama, parambv));
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    for (paramView.dKT.dlj = ((StringBuilder)localObject2).toString();; paramView.dKT.dlj = parama.toString())
    {
      com.tencent.mm.sdk.b.a.IvT.l(paramView);
      AppMethodBeat.o(37089);
      return true;
      bool = false;
      break;
      label420:
      paramView.dKT.scene = 1007;
      parama = new StringBuilder(b(parama, parambv));
      parama.append(":");
      parama.append((String)localObject1);
    }
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.a
 * JD-Core Version:    0.7.0.1
 */