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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.vm.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class ac$a
  extends c
  implements com.tencent.mm.modelappbrand.h
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  private ab kiN;
  
  public ac$a()
  {
    AppMethodBeat.i(37084);
    this.kiN = new ac(this);
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
    ad.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
    paramView = (ac.d)localObject;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      paramView.mLk.fLK();
      paramView.mLk.setVisibility(4);
      paramView.Kdd.setVisibility(4);
      paramView.oSB.setVisibility(0);
      paramView.oSB.setImageResource(2131689648);
      AppMethodBeat.o(37090);
      return;
    case 0: 
      paramView.mLk.setVisibility(0);
      paramView.mLk.fLJ();
      paramView.oSB.setVisibility(4);
      paramView.Kdd.setVisibility(4);
      AppMethodBeat.o(37090);
      return;
    case 1: 
      paramView.mLk.fLK();
      paramView.mLk.setVisibility(4);
      paramView.Kdd.setVisibility(4);
      paramView.oSB.setVisibility(0);
      paramView.oSB.setImageResource(2131690080);
      AppMethodBeat.o(37090);
      return;
    }
    paramView.mLk.fLK();
    paramView.mLk.setVisibility(4);
    paramView.Kdd.setVisibility(0);
    paramView.oSB.setVisibility(4);
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
      paramLayoutInflater = new ac.d().G((View)localObject, true);
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).cw(((View)localObject).getContext());
      paramLayoutInflater.Kdd = paramView;
      paramLayoutInflater.Kdc.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37085);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37086);
    this.JBI = parama1;
    ac.d locald = (ac.d)parama;
    parama = parambu.field_content;
    Object localObject = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
    ((com.tencent.mm.ui.chatting.d.b.m)localObject).bI(parambu);
    ((com.tencent.mm.ui.chatting.d.b.m)localObject).bJ(parambu);
    ((com.tencent.mm.ui.chatting.d.b.m)localObject).bK(parambu);
    ad.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", new Object[] { paramString });
    bk localbk;
    if (parama != null)
    {
      parama = k.b.aA(parama, parambu.field_reserved);
      localbk = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
      if (parama != null)
      {
        locald.JZn.setVisibility(8);
        locald.JZm.setVisibility(8);
        locald.JZK.setVisibility(8);
        parama.ao(com.tencent.mm.ai.h.class);
        locald.ofK.setBackgroundResource(2131231727);
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.fX(parama.appId, parama.aDD);
        if (localg != null) {
          b(parama1, parama, parambu);
        }
        if ((parama.fkq != null) && (parama.fkq.length() != 0)) {
          break label815;
        }
        locald.JZp.setVisibility(8);
        label211:
        localObject = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(parama.hCn);
        locald.JZs.setVisibility(0);
        locald.JZj.setVisibility(8);
        locald.JZv.setVisibility(0);
        locald.JZt.setVisibility(8);
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
        locald.JZK.setVisibility(0);
        locald.Kdb.setVisibility(8);
        locald.JZO.setText(parama.title);
        locald.Kdb.setText(parama.description);
        locald.JZI.setText(paramString);
        switch (parama.hCz)
        {
        default: 
          locald.JZJ.setText(2131755401);
          label383:
          q.aIJ().a((String)localObject, locald.JZH, ac.d.fOJ);
          if (!parama1.fFv()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locald.JZr.setVisibility(0);
              c(parama1, locald.JZr, bk.a(parama, parambu));
              label438:
              localObject = (com.tencent.mm.ai.a)parama.ao(com.tencent.mm.ai.a.class);
              paramString = new Bundle();
              paramString.putString("app_id", parama.hCo);
              paramString.putString("msg_id", parambu.field_msgId);
              if (localObject == null) {
                break label916;
              }
              parambu = ((com.tencent.mm.ai.a)localObject).hxW;
              label509:
              paramString.putString("cache_key", parambu);
              paramString.putString("msg_title", parama.title);
              paramString.putString("msg_path", parama.hCm);
              paramString.putInt("msg_pkg_type", parama.hCz);
              paramString.putInt("pkg_version", parama.aDD);
              paramString.putInt("widget_type", 0);
              if (!parama1.fFv()) {
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
      paramString.putInt("view_init_width", ac.d.KcZ);
      paramString.putInt("view_init_height", ac.d.Kda);
      locald.Kdd.setTag(locald);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).a(com.tencent.mm.plugin.appbrand.z.n.cG(parama1), locald.Kdd, paramString, this.kiN);
      ((r)com.tencent.mm.kernel.g.ab(r.class)).LQ(parama.hCn);
      locald.ofK.setTag(localbk);
      locald.ofK.setOnClickListener(d(parama1));
      paramString = y.aBq().F(com.tencent.mm.plugin.appbrand.z.n.cG(parama1), true);
      parambu = (ac.c)paramString.get("listener", null);
      parama = parambu;
      if (parambu == null)
      {
        parama = new ac.c();
        paramString.k("listener", parama);
      }
      parama.n(parama1);
      if (this.oSO) {
        locald.ofK.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(37086);
      return;
      ad.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambu.field_msgId), paramString });
      parama = null;
      break;
      label815:
      locald.JZp.setVisibility(0);
      b(parama1, locald.JZp, bk.aWI(parama.fkq));
      break label211;
      label844:
      paramString = parama.dHp;
      break label281;
      label853:
      localObject = parama.hCB;
      break label293;
      locald.JZJ.setText(2131755657);
      break label383;
      locald.JZJ.setText(2131755656);
      break label383;
      locald.JZr.setVisibility(8);
      break label438;
      locald.JZr.setVisibility(8);
      break label438;
      parambu = null;
      break label509;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37088);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37088);
      return false;
    case 111: 
      e.b.a(parama, parambu, b(parama, parambu));
      AppMethodBeat.o(37088);
      return false;
    case 133: 
      Object localObject = parambu.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = k.b.yr((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37088);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.hCo);
      ((Bundle)localObject).putString("msg_id", parambu.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.hCz);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.hCr);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDF().d(parama.JOR.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37088);
      return false;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDF().cx(parama.JOR.getContext());
    AppMethodBeat.o(37088);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194417);
    int i = ((bk)paramView.getTag()).position;
    k.b localb = k.b.yr(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
    Object localObject;
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.m(localb.appId, false, false))) && (!j.aX(parambu)))
    {
      if (localb.type != 6) {
        break label366;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.m.aLN(localb.dks);
      if (((localObject == null) || (!e.b.e(parambu, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))) && (!parambu.frT())) {
        paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
      }
    }
    for (;;)
    {
      localObject = new eb();
      ((eb)localObject).dpg.msgId = parambu.field_msgId;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if ((((eb)localObject).dph.doF) || (e.b.a(this.JBI.JOR.getContext(), localb))) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if (bl.z(parambu)) {
        paraml.clear();
      }
      if (!this.JBI.fFw()) {
        paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
      }
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDF();
      if ((paramView.aDL()) || (paramView.oN(localb.hCz)))
      {
        paraml.add(i, 133, 0, this.JBI.JOR.getMMResources().getString(2131757231));
        paraml.add(i, 132, 0, this.JBI.JOR.getMMResources().getString(2131757230));
      }
      AppMethodBeat.o(194417);
      return true;
      label366:
      paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37089);
    com.tencent.mm.modelstat.a.a(parambu, a.a.inW);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
    if (parambu.field_content == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    Object localObject1 = k.b.yr(bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
    if (localObject1 == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    paramView = com.tencent.mm.pluginsdk.model.app.h.m(((k.b)localObject1).appId, false, false);
    if (paramView != null) {
      a(parama, (k.b)localObject1, d(parama, parambu), paramView, parambu.field_msgSvrId, parama.getTalkerUserName());
    }
    ad.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((k.b)localObject1).hCn, ((k.b)localObject1).hCm, ((k.b)localObject1).hCo, ((k.b)localObject1).url, Integer.valueOf(((k.b)localObject1).hCz), ((k.b)localObject1).hCq });
    paramView = new vm();
    paramView.dJF.appId = ((k.b)localObject1).hCo;
    paramView.dJF.userName = ((k.b)localObject1).hCn;
    paramView.dJF.dJH = ((k.b)localObject1).hCm;
    paramView.dJF.dJI = ((k.b)localObject1).hCz;
    paramView.dJF.dJK = ((k.b)localObject1).hCq;
    paramView.dJF.aDD = ((k.b)localObject1).hCA;
    Object localObject2 = paramView.dJF;
    boolean bool;
    if (((k.b)localObject1).hCz != 0)
    {
      bool = true;
      ((vm.a)localObject2).dJL = bool;
      paramView.dJF.dJN.cmt = parama.getTalkerUserName();
      paramView.dJF.dJN.cmu = ((k.b)localObject1).hCt;
      localObject1 = ((k.b)localObject1).hCs;
      if (!parama.fFv()) {
        break label420;
      }
      paramView.dJF.scene = 1008;
      localObject2 = new StringBuilder(parama.getTalkerUserName());
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(b(parama, parambu));
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    for (paramView.dJF.dkh = ((StringBuilder)localObject2).toString();; paramView.dJF.dkh = parama.toString())
    {
      com.tencent.mm.sdk.b.a.IbL.l(paramView);
      AppMethodBeat.o(37089);
      return true;
      bool = false;
      break;
      label420:
      paramView.dJF.scene = 1007;
      parama = new StringBuilder(b(parama, parambu));
      parama.append(":");
      parama.append((String)localObject1);
    }
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.a
 * JD-Core Version:    0.7.0.1
 */