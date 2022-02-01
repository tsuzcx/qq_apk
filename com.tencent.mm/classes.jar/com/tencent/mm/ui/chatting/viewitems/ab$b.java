package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
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
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.ut.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.k;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class ab$b
  extends c
  implements com.tencent.mm.modelappbrand.h, s.n
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  private ab jOC;
  
  public ab$b()
  {
    AppMethodBeat.i(37091);
    this.jOC = new com.tencent.mm.modelappbrand.ac(this);
    AppMethodBeat.o(37091);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(37097);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof ab.d))
    {
      AppMethodBeat.o(37097);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
    paramView = (ab.d)localObject;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      paramView.mkI.fuX();
      paramView.mkI.setVisibility(4);
      paramView.ImF.setVisibility(4);
      paramView.opg.setVisibility(0);
      paramView.opg.setImageResource(2131689648);
      AppMethodBeat.o(37097);
      return;
    case 0: 
      paramView.mkI.setVisibility(0);
      paramView.mkI.fuW();
      paramView.ImF.setVisibility(4);
      paramView.opg.setVisibility(4);
      AppMethodBeat.o(37097);
      return;
    case 1: 
      paramView.mkI.fuX();
      paramView.mkI.setVisibility(4);
      paramView.ImF.setVisibility(4);
      paramView.opg.setVisibility(0);
      paramView.opg.setImageResource(2131690080);
      AppMethodBeat.o(37097);
      return;
    }
    paramView.mkI.fuX();
    paramView.mkI.setVisibility(4);
    paramView.ImF.setVisibility(0);
    paramView.opg.setVisibility(4);
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
      localObject = new ag(paramLayoutInflater, 2131493493);
      paramLayoutInflater = new ab.d().F((View)localObject, false);
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).cz(((View)localObject).getContext());
      paramLayoutInflater.ImF = paramView;
      paramLayoutInflater.ImE.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37092);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37098);
    if (parambo.cKN())
    {
      com.tencent.mm.pluginsdk.model.app.m.aD(parambo);
      bi.pK(parambo.field_msgId);
      parama.xg(true);
      AppMethodBeat.o(37098);
      return;
    }
    AppMethodBeat.o(37098);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37093);
    ab.d locald = (ab.d)parama;
    this.HNS = parama1;
    paramString = (k)parama1.bf(k.class);
    paramString.bE(parambo);
    Object localObject1 = parambo.field_content;
    paramString.bC(parambo);
    if (localObject1 != null) {}
    for (paramString = k.b.az((String)localObject1, parambo.field_reserved);; paramString = null)
    {
      bj localbj = new bj(parambo, parama1.foQ(), paramInt, null, '\000');
      Object localObject2;
      if (paramString != null)
      {
        locald.IiP.setVisibility(8);
        locald.IiO.setVisibility(8);
        locald.IiL.setVisibility(8);
        locald.Ijm.setVisibility(8);
        localObject2 = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).Ka(paramString.hke);
        if (localObject2 == null) {
          break label725;
        }
        localObject1 = ((WxaAttributes)localObject2).field_nickname;
        if (localObject2 == null) {
          break label735;
        }
        localObject2 = ((WxaAttributes)localObject2).field_smallHeadURL;
        label176:
        locald.Ijm.setVisibility(0);
        locald.ImD.setVisibility(8);
        locald.Ijq.setText(paramString.title);
        locald.ImD.setText(paramString.description);
        locald.Ijk.setText((CharSequence)localObject1);
        switch (paramString.hkq)
        {
        default: 
          locald.Ijl.setText(2131755401);
          label271:
          o.aFB().a((String)localObject2, locald.Ijj, ab.d.fvC);
          if (fqw())
          {
            localObject1 = (i)parama1.bf(i.class);
            if ((parambo.field_status == 2) && (a((i)localObject1, parambo.field_msgId))) {
              if (locald.Ijf != null) {
                locald.Ijf.setVisibility(0);
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
        ((Bundle)localObject1).putString("app_id", paramString.hkf);
        ((Bundle)localObject1).putString("msg_id", parambo.field_msgId);
        if (parama != null)
        {
          parama = parama.hfO;
          ((Bundle)localObject1).putString("cache_key", parama);
          ((Bundle)localObject1).putString("msg_title", paramString.title);
          ((Bundle)localObject1).putString("msg_path", paramString.hkd);
          ((Bundle)localObject1).putInt("msg_pkg_type", paramString.hkq);
          ((Bundle)localObject1).putInt("pkg_version", paramString.aBM);
          ((Bundle)localObject1).putInt("widget_type", 0);
          if (!parama1.foQ()) {
            break label817;
          }
        }
        for (int i = 1008;; i = 1007)
        {
          ((Bundle)localObject1).putInt("scene", i);
          ((Bundle)localObject1).putInt("view_init_width", ab.d.ImB);
          ((Bundle)localObject1).putInt("view_init_height", ab.d.ImC);
          locald.ImF.setTag(locald);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).a(com.tencent.mm.plugin.appbrand.z.m.cE(parama1), locald.ImF, (Bundle)localObject1, this.jOC);
          ((q)com.tencent.mm.kernel.g.ab(q.class)).Iz(paramString.hke);
          locald.nDl.setTag(localbj);
          locald.nDl.setOnClickListener(d(parama1));
          localObject1 = y.ayq().F(com.tencent.mm.plugin.appbrand.z.m.cE(parama1), true);
          paramString = (ab.c)((y.b)localObject1).get("listener", null);
          parama = paramString;
          if (paramString == null)
          {
            parama = new ab.c();
            ((y.b)localObject1).l("listener", parama);
          }
          parama.n(parama1);
          if (this.opt) {
            locald.nDl.setOnLongClickListener(c(parama1));
          }
          a(paramInt, locald, parambo, parama1.foM(), parama1.foQ(), parama1, this);
          AppMethodBeat.o(37093);
          return;
          label725:
          localObject1 = paramString.dvm;
          break;
          label735:
          localObject2 = paramString.hks;
          break label176;
          locald.Ijl.setText(2131755657);
          break label271;
          locald.Ijl.setText(2131755656);
          break label271;
          if (locald.Ijf == null) {
            break label344;
          }
          locald.Ijf.setVisibility(8);
          break label344;
          if (parambo.field_status >= 2) {
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
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37094);
    int i = ((bj)paramView.getTag()).position;
    if (parambo.field_content == null)
    {
      AppMethodBeat.o(37094);
      return true;
    }
    k.b localb = k.b.vA(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(37094);
      return true;
    }
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.k(localb.appId, false, false))) && (!j.aU(parambo))) {
      paramContextMenu.add(i, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
    }
    if (((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131757234));
    }
    com.tencent.mm.g.a.dy localdy = new com.tencent.mm.g.a.dy();
    localdy.ddK.msgId = parambo.field_msgId;
    com.tencent.mm.sdk.b.a.GpY.l(localdy);
    if ((localdy.ddL.ddj) || (e.b.a(this.HNS.HZF.getContext(), localb))) {
      paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
    }
    if (!this.HNS.foR()) {
      paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
    }
    paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aAC();
    if ((paramView.aAI()) || (paramView.on(localb.hkq)))
    {
      paramContextMenu.add(i, 133, 0, this.HNS.HZF.getMMResources().getString(2131757231));
      paramContextMenu.add(i, 132, 0, this.HNS.HZF.getMMResources().getString(2131757230));
    }
    AppMethodBeat.o(37094);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37095);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37095);
      return false;
    case 111: 
      e.b.a(parama, parambo, b(parama, parambo));
      AppMethodBeat.o(37095);
      return false;
    case 103: 
      paramMenuItem = parambo.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
        return false;
      }
      paramMenuItem = k.b.vA(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(37095);
        return false;
        parama = new jl();
        parama.dkU.dkV = paramMenuItem.dkV;
        parama.dkU.dbz = parambo.field_msgId;
        parama.dkU.dkW = parambo.field_talker;
        com.tencent.mm.sdk.b.a.GpY.l(parama);
      }
    case 133: 
      Object localObject = parambo.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = k.b.vA((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.hkf);
      ((Bundle)localObject).putString("msg_id", parambo.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.hkq);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.hki);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aAC().d(parama.HZF.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37095);
      return false;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aAC().cA(parama.HZF.getContext());
    AppMethodBeat.o(37095);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37096);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
    paramView.getTag();
    paramView = parambo.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    paramView = k.b.vA(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.k(paramView.appId, true, false);
    if ((localObject1 != null) && (!bs.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId))) {
      a(parama, paramView, u.axw(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, parambo.field_msgSvrId, parama.getTalkerUserName());
    }
    localObject1 = new ut();
    ((ut)localObject1).dxt.appId = paramView.hkf;
    ((ut)localObject1).dxt.userName = paramView.hke;
    ((ut)localObject1).dxt.dxv = paramView.hkd;
    ((ut)localObject1).dxt.dxw = paramView.hkq;
    ((ut)localObject1).dxt.dxy = paramView.hkh;
    ((ut)localObject1).dxt.aBM = paramView.hkr;
    Object localObject2 = ((ut)localObject1).dxt;
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramView.hkq != 0)
    {
      bool = true;
      ((ut.a)localObject2).dxz = bool;
      localObject2 = paramView.hkj;
      if (!parama.foQ()) {
        break label354;
      }
      ((ut)localObject1).dxt.scene = 1008;
      localStringBuilder = new StringBuilder(parama.getTalkerUserName());
      localStringBuilder.append(":");
      localStringBuilder.append(b(parama, parambo));
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject2);
    }
    for (((ut)localObject1).dxt.cYP = localStringBuilder.toString();; ((ut)localObject1).dxt.cYP = parambo.toString())
    {
      ((ut)localObject1).dxt.dxB.ccc = parama.getTalkerUserName();
      ((ut)localObject1).dxt.dxB.ccd = paramView.hkk;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      AppMethodBeat.o(37096);
      return true;
      bool = false;
      break;
      label354:
      ((ut)localObject1).dxt.scene = 1007;
      parambo = new StringBuilder(b(parama, parambo));
      parambo.append(":");
      parambo.append((String)localObject2);
    }
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.b
 * JD-Core Version:    0.7.0.1
 */