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
import com.tencent.mm.g.a.ju;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class ac$b
  extends c
  implements com.tencent.mm.modelappbrand.h, t.n
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  private ab kmd;
  
  public ac$b()
  {
    AppMethodBeat.i(37091);
    this.kmd = new ac(this);
    AppMethodBeat.o(37091);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(37097);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof ac.d))
    {
      AppMethodBeat.o(37097);
      return;
    }
    ae.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
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
      AppMethodBeat.o(37097);
      return;
    case 0: 
      paramView.mQm.setVisibility(0);
      paramView.mQm.fQd();
      paramView.Kzv.setVisibility(4);
      paramView.oZd.setVisibility(4);
      AppMethodBeat.o(37097);
      return;
    case 1: 
      paramView.mQm.fQe();
      paramView.mQm.setVisibility(4);
      paramView.Kzv.setVisibility(4);
      paramView.oZd.setVisibility(0);
      paramView.oZd.setImageResource(2131690080);
      AppMethodBeat.o(37097);
      return;
    }
    paramView.mQm.fQe();
    paramView.mQm.setVisibility(4);
    paramView.Kzv.setVisibility(0);
    paramView.oZd.setVisibility(4);
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
      localObject = new ah(paramLayoutInflater, 2131493493);
      paramLayoutInflater = new ac.d().L((View)localObject, false);
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).cy(((View)localObject).getContext());
      paramLayoutInflater.Kzv = paramView;
      paramLayoutInflater.Kzu.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37092);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37098);
    if (parambv.cVH())
    {
      com.tencent.mm.pluginsdk.model.app.m.aF(parambv);
      bl.rW(parambv.field_msgId);
      parama.xY(true);
      AppMethodBeat.o(37098);
      return;
    }
    AppMethodBeat.o(37098);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37093);
    ac.d locald = (ac.d)parama;
    this.JWz = parama1;
    paramString = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
    paramString.bJ(parambv);
    Object localObject1 = parambv.field_content;
    paramString.bH(parambv);
    if (localObject1 != null) {}
    for (paramString = k.b.aB((String)localObject1, parambv.field_reserved);; paramString = null)
    {
      bk localbk = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
      Object localObject2;
      if (paramString != null)
      {
        locald.KvG.setVisibility(8);
        locald.KvF.setVisibility(8);
        locald.KvC.setVisibility(8);
        locald.Kwd.setVisibility(8);
        localObject2 = ((o)com.tencent.mm.kernel.g.ab(o.class)).Ob(paramString.hFc);
        if (localObject2 == null) {
          break label725;
        }
        localObject1 = ((WxaAttributes)localObject2).field_nickname;
        if (localObject2 == null) {
          break label735;
        }
        localObject2 = ((WxaAttributes)localObject2).field_smallHeadURL;
        label176:
        locald.Kwd.setVisibility(0);
        locald.Kzt.setVisibility(8);
        locald.Kwh.setText(paramString.title);
        locald.Kzt.setText(paramString.description);
        locald.Kwb.setText((CharSequence)localObject1);
        switch (paramString.hFr)
        {
        default: 
          locald.Kwc.setText(2131755401);
          label271:
          q.aJb().a((String)localObject2, locald.Kwa, ac.d.fQP);
          if (fLB())
          {
            localObject1 = (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            if ((parambv.field_status == 2) && (b((com.tencent.mm.ui.chatting.d.b.k)localObject1, parambv.field_msgId))) {
              if (locald.KvW != null) {
                locald.KvW.setVisibility(0);
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
        parama = (com.tencent.mm.ah.a)paramString.ao(com.tencent.mm.ah.a.class);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("app_id", paramString.hFd);
        ((Bundle)localObject1).putString("msg_id", parambv.field_msgId);
        if (parama != null)
        {
          parama = parama.hAK;
          ((Bundle)localObject1).putString("cache_key", parama);
          ((Bundle)localObject1).putString("msg_title", paramString.title);
          ((Bundle)localObject1).putString("msg_path", paramString.hFb);
          ((Bundle)localObject1).putInt("msg_pkg_type", paramString.hFr);
          ((Bundle)localObject1).putInt("pkg_version", paramString.aDD);
          ((Bundle)localObject1).putInt("widget_type", 0);
          if (!parama1.fJC()) {
            break label817;
          }
        }
        for (int i = 1008;; i = 1007)
        {
          ((Bundle)localObject1).putInt("scene", i);
          ((Bundle)localObject1).putInt("view_init_width", ac.d.Kzr);
          ((Bundle)localObject1).putInt("view_init_height", ac.d.Kzs);
          locald.Kzv.setTag(locald);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).a(com.tencent.mm.plugin.appbrand.y.n.cH(parama1), locald.Kzv, (Bundle)localObject1, this.kmd);
          ((s)com.tencent.mm.kernel.g.ab(s.class)).Mt(paramString.hFc);
          locald.olI.setTag(localbk);
          locald.olI.setOnClickListener(d(parama1));
          localObject1 = z.aBG().F(com.tencent.mm.plugin.appbrand.y.n.cH(parama1), true);
          paramString = (ac.c)((z.b)localObject1).get("listener", null);
          parama = paramString;
          if (paramString == null)
          {
            parama = new ac.c();
            ((z.b)localObject1).k("listener", parama);
          }
          parama.n(parama1);
          if (this.oZq) {
            locald.olI.setOnLongClickListener(c(parama1));
          }
          a(paramInt, locald, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
          AppMethodBeat.o(37093);
          return;
          label725:
          localObject1 = paramString.dIu;
          break;
          label735:
          localObject2 = paramString.hFt;
          break label176;
          locald.Kwc.setText(2131755657);
          break label271;
          locald.Kwc.setText(2131755656);
          break label271;
          if (locald.KvW == null) {
            break label344;
          }
          locald.KvW.setVisibility(8);
          break label344;
          if (parambv.field_status >= 2) {
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
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37095);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37095);
      return false;
    case 111: 
      e.b.a(parama, parambv, b(parama, parambv));
      AppMethodBeat.o(37095);
      return false;
    case 103: 
      paramMenuItem = parambv.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
        return false;
      }
      paramMenuItem = k.b.zb(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(37095);
        return false;
        parama = new ju();
        parama.dxM.dxN = paramMenuItem.dxN;
        parama.dxM.dnX = parambv.field_msgId;
        parama.dxM.dxO = parambv.field_talker;
        com.tencent.mm.sdk.b.a.IvT.l(parama);
      }
    case 133: 
      Object localObject = parambv.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = k.b.zb((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.hFd);
      ((Bundle)localObject).putString("msg_id", parambv.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.hFr);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.hFg);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().d(parama.Kkd.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37095);
      return false;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDV().cz(parama.Kkd.getContext());
    AppMethodBeat.o(37095);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187813);
    int i = ((bk)paramView.getTag()).position;
    if (parambv.field_content == null)
    {
      AppMethodBeat.o(187813);
      return true;
    }
    k.b localb = k.b.zb(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(187813);
      return true;
    }
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.m(localb.appId, false, false))) && (!com.tencent.mm.ui.chatting.k.aW(parambv))) {
      paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
    }
    if (((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker))) {
      paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
    }
    ec localec = new ec();
    localec.dql.msgId = parambv.field_msgId;
    com.tencent.mm.sdk.b.a.IvT.l(localec);
    if ((localec.dqm.dpK) || (e.b.a(this.JWz.Kkd.getContext(), localb))) {
      paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
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
    AppMethodBeat.o(187813);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37096);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
    paramView.getTag();
    paramView = parambv.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    paramView = k.b.zb(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.m(paramView.appId, true, false);
    if ((localObject1 != null) && (!bu.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId))) {
      a(parama, paramView, v.aAC(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, parambv.field_msgSvrId, parama.getTalkerUserName());
    }
    localObject1 = new vq();
    ((vq)localObject1).dKT.appId = paramView.hFd;
    ((vq)localObject1).dKT.userName = paramView.hFc;
    ((vq)localObject1).dKT.dKV = paramView.hFb;
    ((vq)localObject1).dKT.dKW = paramView.hFr;
    ((vq)localObject1).dKT.dKZ = paramView.hFf;
    ((vq)localObject1).dKT.aDD = paramView.hFs;
    Object localObject2 = ((vq)localObject1).dKT;
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramView.hFr != 0)
    {
      bool = true;
      ((vq.a)localObject2).dLa = bool;
      localObject2 = paramView.hFh;
      if (!parama.fJC()) {
        break label354;
      }
      ((vq)localObject1).dKT.scene = 1008;
      localStringBuilder = new StringBuilder(parama.getTalkerUserName());
      localStringBuilder.append(":");
      localStringBuilder.append(b(parama, parambv));
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject2);
    }
    for (((vq)localObject1).dKT.dlj = localStringBuilder.toString();; ((vq)localObject1).dKT.dlj = parambv.toString())
    {
      ((vq)localObject1).dKT.dLc.cmv = parama.getTalkerUserName();
      ((vq)localObject1).dKT.dLc.cmw = paramView.hFi;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(37096);
      return true;
      bool = false;
      break;
      label354:
      ((vq)localObject1).dKT.scene = 1007;
      parambv = new StringBuilder(b(parama, parambv));
      parambv.append(":");
      parambv.append((String)localObject2);
    }
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean fLz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.b
 * JD-Core Version:    0.7.0.1
 */