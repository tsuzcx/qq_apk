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
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.ut.a;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.k;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class ab$a
  extends c
  implements com.tencent.mm.modelappbrand.h
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  private ab jOC;
  
  public ab$a()
  {
    AppMethodBeat.i(37084);
    this.jOC = new com.tencent.mm.modelappbrand.ac(this);
    AppMethodBeat.o(37084);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(37090);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof ab.d))
    {
      AppMethodBeat.o(37090);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
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
      AppMethodBeat.o(37090);
      return;
    case 0: 
      paramView.mkI.setVisibility(0);
      paramView.mkI.fuW();
      paramView.opg.setVisibility(4);
      paramView.ImF.setVisibility(4);
      AppMethodBeat.o(37090);
      return;
    case 1: 
      paramView.mkI.fuX();
      paramView.mkI.setVisibility(4);
      paramView.ImF.setVisibility(4);
      paramView.opg.setVisibility(0);
      paramView.opg.setImageResource(2131690080);
      AppMethodBeat.o(37090);
      return;
    }
    paramView.mkI.fuX();
    paramView.mkI.setVisibility(4);
    paramView.ImF.setVisibility(0);
    paramView.opg.setVisibility(4);
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
      localObject = new ag(paramLayoutInflater, 2131493449);
      paramLayoutInflater = new ab.d().F((View)localObject, true);
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).cz(((View)localObject).getContext());
      paramLayoutInflater.ImF = paramView;
      paramLayoutInflater.ImE.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37085);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37086);
    this.HNS = parama1;
    ab.d locald = (ab.d)parama;
    parama = parambo.field_content;
    Object localObject = (k)parama1.bf(k.class);
    ((k)localObject).bC(parambo);
    ((k)localObject).bD(parambo);
    ((k)localObject).bE(parambo);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", new Object[] { paramString });
    bj localbj;
    if (parama != null)
    {
      parama = k.b.az(parama, parambo.field_reserved);
      localbj = new bj(parambo, parama1.foQ(), paramInt, null, '\000');
      if (parama != null)
      {
        locald.IiP.setVisibility(8);
        locald.IiO.setVisibility(8);
        locald.Ijm.setVisibility(8);
        parama.ao(com.tencent.mm.ah.h.class);
        locald.nDl.setBackground(ao.aI(parama1.HZF.getContext(), 2130968737));
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.fA(parama.appId, parama.aBM);
        if (localg != null) {
          b(parama1, parama, parambo);
        }
        if ((parama.eSb != null) && (parama.eSb.length() != 0)) {
          break label827;
        }
        locald.IiR.setVisibility(8);
        label221:
        localObject = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).Ka(parama.hke);
        locald.IiU.setVisibility(0);
        locald.IiL.setVisibility(8);
        locald.IiX.setVisibility(0);
        locald.IiV.setVisibility(8);
        if (localObject == null) {
          break label856;
        }
        paramString = ((WxaAttributes)localObject).field_nickname;
        label291:
        if (localObject == null) {
          break label865;
        }
        localObject = ((WxaAttributes)localObject).field_smallHeadURL;
        label303:
        locald.Ijm.setVisibility(0);
        locald.ImD.setVisibility(8);
        locald.Ijq.setText(parama.title);
        locald.ImD.setText(parama.description);
        locald.Ijk.setText(paramString);
        switch (parama.hkq)
        {
        default: 
          locald.Ijl.setText(2131755401);
          label395:
          o.aFB().a((String)localObject, locald.Ijj, ab.d.fvC);
          if (!parama1.foQ()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locald.IiT.setVisibility(0);
              c(parama1, locald.IiT, bj.a(parama, parambo));
              label450:
              localObject = (com.tencent.mm.ah.a)parama.ao(com.tencent.mm.ah.a.class);
              paramString = new Bundle();
              paramString.putString("app_id", parama.hkf);
              paramString.putString("msg_id", parambo.field_msgId);
              if (localObject == null) {
                break label928;
              }
              parambo = ((com.tencent.mm.ah.a)localObject).hfO;
              label521:
              paramString.putString("cache_key", parambo);
              paramString.putString("msg_title", parama.title);
              paramString.putString("msg_path", parama.hkd);
              paramString.putInt("msg_pkg_type", parama.hkq);
              paramString.putInt("pkg_version", parama.aBM);
              paramString.putInt("widget_type", 0);
              if (!parama1.foQ()) {
                break label934;
              }
            }
          }
          break;
        }
      }
    }
    label928:
    label934:
    for (paramInt = 1008;; paramInt = 1007)
    {
      paramString.putInt("scene", paramInt);
      paramString.putInt("view_init_width", ab.d.ImB);
      paramString.putInt("view_init_height", ab.d.ImC);
      locald.ImF.setTag(locald);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).a(com.tencent.mm.plugin.appbrand.z.m.cE(parama1), locald.ImF, paramString, this.jOC);
      ((q)com.tencent.mm.kernel.g.ab(q.class)).Iz(parama.hke);
      locald.nDl.setTag(localbj);
      locald.nDl.setOnClickListener(d(parama1));
      paramString = y.ayq().F(com.tencent.mm.plugin.appbrand.z.m.cE(parama1), true);
      parambo = (ab.c)paramString.get("listener", null);
      parama = parambo;
      if (parambo == null)
      {
        parama = new ab.c();
        paramString.l("listener", parama);
      }
      parama.n(parama1);
      if (this.opt) {
        locald.nDl.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(37086);
      return;
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambo.field_msgId), paramString });
      parama = null;
      break;
      label827:
      locald.IiR.setVisibility(0);
      b(parama1, locald.IiR, bj.aQO(parama.eSb));
      break label221;
      label856:
      paramString = parama.dvm;
      break label291;
      label865:
      localObject = parama.hks;
      break label303;
      locald.Ijl.setText(2131755657);
      break label395;
      locald.Ijl.setText(2131755656);
      break label395;
      locald.IiT.setVisibility(8);
      break label450;
      locald.IiT.setVisibility(8);
      break label450;
      parambo = null;
      break label521;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37087);
    int i = ((bj)paramView.getTag()).position;
    k.b localb = k.b.vA(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
    Object localObject;
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.k(localb.appId, false, false))) && (!j.aU(parambo)))
    {
      if (localb.type != 6) {
        break label372;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.m.aGn(localb.cZa);
      if (((localObject == null) || (!e.b.e(parambo, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))) && (!parambo.fbQ())) {
        paramContextMenu.add(i, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
      }
    }
    for (;;)
    {
      localObject = new com.tencent.mm.g.a.dy();
      ((com.tencent.mm.g.a.dy)localObject).ddK.msgId = parambo.field_msgId;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      if ((((com.tencent.mm.g.a.dy)localObject).ddL.ddj) || (e.b.a(this.HNS.HZF.getContext(), localb))) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if (bk.x(parambo)) {
        paramContextMenu.clear();
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
      AppMethodBeat.o(37087);
      return true;
      label372:
      paramContextMenu.add(i, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37088);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37088);
      return false;
    case 111: 
      e.b.a(parama, parambo, b(parama, parambo));
      AppMethodBeat.o(37088);
      return false;
    case 133: 
      Object localObject = parambo.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = k.b.vA((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37088);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.hkf);
      ((Bundle)localObject).putString("msg_id", parambo.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.hkq);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.hki);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aAC().d(parama.HZF.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37088);
      return false;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).aAC().cA(parama.HZF.getContext());
    AppMethodBeat.o(37088);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37089);
    com.tencent.mm.modelstat.a.a(parambo, a.a.hUB);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
    if (parambo.field_content == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    Object localObject1 = k.b.vA(bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
    if (localObject1 == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    paramView = com.tencent.mm.pluginsdk.model.app.h.k(((k.b)localObject1).appId, false, false);
    if (paramView != null) {
      a(parama, (k.b)localObject1, d(parama, parambo), paramView, parambo.field_msgSvrId, parama.getTalkerUserName());
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((k.b)localObject1).hke, ((k.b)localObject1).hkd, ((k.b)localObject1).hkf, ((k.b)localObject1).url, Integer.valueOf(((k.b)localObject1).hkq), ((k.b)localObject1).hkh });
    paramView = new ut();
    paramView.dxt.appId = ((k.b)localObject1).hkf;
    paramView.dxt.userName = ((k.b)localObject1).hke;
    paramView.dxt.dxv = ((k.b)localObject1).hkd;
    paramView.dxt.dxw = ((k.b)localObject1).hkq;
    paramView.dxt.dxy = ((k.b)localObject1).hkh;
    paramView.dxt.aBM = ((k.b)localObject1).hkr;
    Object localObject2 = paramView.dxt;
    boolean bool;
    if (((k.b)localObject1).hkq != 0)
    {
      bool = true;
      ((ut.a)localObject2).dxz = bool;
      paramView.dxt.dxB.ccc = parama.getTalkerUserName();
      paramView.dxt.dxB.ccd = ((k.b)localObject1).hkk;
      localObject1 = ((k.b)localObject1).hkj;
      if (!parama.foQ()) {
        break label420;
      }
      paramView.dxt.scene = 1008;
      localObject2 = new StringBuilder(parama.getTalkerUserName());
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(b(parama, parambo));
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    for (paramView.dxt.cYP = ((StringBuilder)localObject2).toString();; paramView.dxt.cYP = parama.toString())
    {
      com.tencent.mm.sdk.b.a.GpY.l(paramView);
      AppMethodBeat.o(37089);
      return true;
      bool = false;
      break;
      label420:
      paramView.dxt.scene = 1007;
      parama = new StringBuilder(b(parama, parambo));
      parama.append(":");
      parama.append((String)localObject1);
    }
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.a
 * JD-Core Version:    0.7.0.1
 */