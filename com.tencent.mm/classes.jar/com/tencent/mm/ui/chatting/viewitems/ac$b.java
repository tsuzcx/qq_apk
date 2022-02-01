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
import com.tencent.mm.g.a.jt;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.vm.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class ac$b
  extends c
  implements com.tencent.mm.modelappbrand.h, s.n
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  private ab kiN;
  
  public ac$b()
  {
    AppMethodBeat.i(37091);
    this.kiN = new ac(this);
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
    ad.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
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
      AppMethodBeat.o(37097);
      return;
    case 0: 
      paramView.mLk.setVisibility(0);
      paramView.mLk.fLJ();
      paramView.Kdd.setVisibility(4);
      paramView.oSB.setVisibility(4);
      AppMethodBeat.o(37097);
      return;
    case 1: 
      paramView.mLk.fLK();
      paramView.mLk.setVisibility(4);
      paramView.Kdd.setVisibility(4);
      paramView.oSB.setVisibility(0);
      paramView.oSB.setImageResource(2131690080);
      AppMethodBeat.o(37097);
      return;
    }
    paramView.mLk.fLK();
    paramView.mLk.setVisibility(4);
    paramView.Kdd.setVisibility(0);
    paramView.oSB.setVisibility(4);
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
      paramLayoutInflater = new ac.d().G((View)localObject, false);
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).cw(((View)localObject).getContext());
      paramLayoutInflater.Kdd = paramView;
      paramLayoutInflater.Kdc.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37092);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37098);
    if (parambu.cTc())
    {
      com.tencent.mm.pluginsdk.model.app.m.aG(parambu);
      bj.rJ(parambu.field_msgId);
      parama.xR(true);
      AppMethodBeat.o(37098);
      return;
    }
    AppMethodBeat.o(37098);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37093);
    ac.d locald = (ac.d)parama;
    this.JBI = parama1;
    paramString = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
    paramString.bK(parambu);
    Object localObject1 = parambu.field_content;
    paramString.bI(parambu);
    if (localObject1 != null) {}
    for (paramString = k.b.aA((String)localObject1, parambu.field_reserved);; paramString = null)
    {
      bk localbk = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
      Object localObject2;
      if (paramString != null)
      {
        locald.JZn.setVisibility(8);
        locald.JZm.setVisibility(8);
        locald.JZj.setVisibility(8);
        locald.JZK.setVisibility(8);
        localObject2 = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(paramString.hCn);
        if (localObject2 == null) {
          break label725;
        }
        localObject1 = ((WxaAttributes)localObject2).field_nickname;
        if (localObject2 == null) {
          break label735;
        }
        localObject2 = ((WxaAttributes)localObject2).field_smallHeadURL;
        label176:
        locald.JZK.setVisibility(0);
        locald.Kdb.setVisibility(8);
        locald.JZO.setText(paramString.title);
        locald.Kdb.setText(paramString.description);
        locald.JZI.setText((CharSequence)localObject1);
        switch (paramString.hCz)
        {
        default: 
          locald.JZJ.setText(2131755401);
          label271:
          q.aIJ().a((String)localObject2, locald.JZH, ac.d.fOJ);
          if (fHj())
          {
            localObject1 = (k)parama1.bh(k.class);
            if ((parambu.field_status == 2) && (b((k)localObject1, parambu.field_msgId))) {
              if (locald.JZD != null) {
                locald.JZD.setVisibility(0);
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
        parama = (com.tencent.mm.ai.a)paramString.ao(com.tencent.mm.ai.a.class);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("app_id", paramString.hCo);
        ((Bundle)localObject1).putString("msg_id", parambu.field_msgId);
        if (parama != null)
        {
          parama = parama.hxW;
          ((Bundle)localObject1).putString("cache_key", parama);
          ((Bundle)localObject1).putString("msg_title", paramString.title);
          ((Bundle)localObject1).putString("msg_path", paramString.hCm);
          ((Bundle)localObject1).putInt("msg_pkg_type", paramString.hCz);
          ((Bundle)localObject1).putInt("pkg_version", paramString.aDD);
          ((Bundle)localObject1).putInt("widget_type", 0);
          if (!parama1.fFv()) {
            break label817;
          }
        }
        for (int i = 1008;; i = 1007)
        {
          ((Bundle)localObject1).putInt("scene", i);
          ((Bundle)localObject1).putInt("view_init_width", ac.d.KcZ);
          ((Bundle)localObject1).putInt("view_init_height", ac.d.Kda);
          locald.Kdd.setTag(locald);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).a(com.tencent.mm.plugin.appbrand.z.n.cG(parama1), locald.Kdd, (Bundle)localObject1, this.kiN);
          ((r)com.tencent.mm.kernel.g.ab(r.class)).LQ(paramString.hCn);
          locald.ofK.setTag(localbk);
          locald.ofK.setOnClickListener(d(parama1));
          localObject1 = y.aBq().F(com.tencent.mm.plugin.appbrand.z.n.cG(parama1), true);
          paramString = (ac.c)((y.b)localObject1).get("listener", null);
          parama = paramString;
          if (paramString == null)
          {
            parama = new ac.c();
            ((y.b)localObject1).k("listener", parama);
          }
          parama.n(parama1);
          if (this.oSO) {
            locald.ofK.setOnLongClickListener(c(parama1));
          }
          a(paramInt, locald, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
          AppMethodBeat.o(37093);
          return;
          label725:
          localObject1 = paramString.dHp;
          break;
          label735:
          localObject2 = paramString.hCB;
          break label176;
          locald.JZJ.setText(2131755657);
          break label271;
          locald.JZJ.setText(2131755656);
          break label271;
          if (locald.JZD == null) {
            break label344;
          }
          locald.JZD.setVisibility(8);
          break label344;
          if (parambu.field_status >= 2) {
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
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37095);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37095);
      return false;
    case 111: 
      e.b.a(parama, parambu, b(parama, parambu));
      AppMethodBeat.o(37095);
      return false;
    case 103: 
      paramMenuItem = parambu.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
        return false;
      }
      paramMenuItem = k.b.yr(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(37095);
        return false;
        parama = new jt();
        parama.dwH.dwI = paramMenuItem.dwI;
        parama.dwH.dmV = parambu.field_msgId;
        parama.dwH.dwJ = parambu.field_talker;
        com.tencent.mm.sdk.b.a.IbL.l(parama);
      }
    case 133: 
      Object localObject = parambu.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = k.b.yr((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.hCo);
      ((Bundle)localObject).putString("msg_id", parambu.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.hCz);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.hCr);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDF().d(parama.JOR.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37095);
      return false;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aDF().cx(parama.JOR.getContext());
    AppMethodBeat.o(37095);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194418);
    int i = ((bk)paramView.getTag()).position;
    if (parambu.field_content == null)
    {
      AppMethodBeat.o(194418);
      return true;
    }
    k.b localb = k.b.yr(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(194418);
      return true;
    }
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.m(localb.appId, false, false))) && (!j.aX(parambu))) {
      paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
    }
    if (((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker))) {
      paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
    }
    eb localeb = new eb();
    localeb.dpg.msgId = parambu.field_msgId;
    com.tencent.mm.sdk.b.a.IbL.l(localeb);
    if ((localeb.dph.doF) || (e.b.a(this.JBI.JOR.getContext(), localb))) {
      paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
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
    AppMethodBeat.o(194418);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37096);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
    paramView.getTag();
    paramView = parambu.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    paramView = k.b.yr(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.m(paramView.appId, true, false);
    if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId))) {
      a(parama, paramView, u.aAm(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, parambu.field_msgSvrId, parama.getTalkerUserName());
    }
    localObject1 = new vm();
    ((vm)localObject1).dJF.appId = paramView.hCo;
    ((vm)localObject1).dJF.userName = paramView.hCn;
    ((vm)localObject1).dJF.dJH = paramView.hCm;
    ((vm)localObject1).dJF.dJI = paramView.hCz;
    ((vm)localObject1).dJF.dJK = paramView.hCq;
    ((vm)localObject1).dJF.aDD = paramView.hCA;
    Object localObject2 = ((vm)localObject1).dJF;
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramView.hCz != 0)
    {
      bool = true;
      ((vm.a)localObject2).dJL = bool;
      localObject2 = paramView.hCs;
      if (!parama.fFv()) {
        break label354;
      }
      ((vm)localObject1).dJF.scene = 1008;
      localStringBuilder = new StringBuilder(parama.getTalkerUserName());
      localStringBuilder.append(":");
      localStringBuilder.append(b(parama, parambu));
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject2);
    }
    for (((vm)localObject1).dJF.dkh = localStringBuilder.toString();; ((vm)localObject1).dJF.dkh = parambu.toString())
    {
      ((vm)localObject1).dJF.dJN.cmt = parama.getTalkerUserName();
      ((vm)localObject1).dJF.dJN.cmu = paramView.hCt;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(37096);
      return true;
      bool = false;
      break;
      label354:
      ((vm)localObject1).dJF.scene = 1007;
      parambu = new StringBuilder(b(parama, parambu));
      parambu.append(":");
      parambu.append((String)localObject2);
    }
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean fHh()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.b
 * JD-Core Version:    0.7.0.1
 */