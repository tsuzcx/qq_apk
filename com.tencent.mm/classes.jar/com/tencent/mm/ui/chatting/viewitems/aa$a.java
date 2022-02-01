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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.a.uj.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.k;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class aa$a
  extends c
  implements com.tencent.mm.modelappbrand.h
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  private ab joq;
  
  public aa$a()
  {
    AppMethodBeat.i(37084);
    this.joq = new ac(this);
    AppMethodBeat.o(37084);
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(37090);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof aa.d))
    {
      AppMethodBeat.o(37090);
      return;
    }
    ad.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
    paramView = (aa.d)localObject;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      paramView.lIL.ffc();
      paramView.lIL.setVisibility(4);
      paramView.GMD.setVisibility(4);
      paramView.nMg.setVisibility(0);
      paramView.nMg.setImageResource(2131689648);
      AppMethodBeat.o(37090);
      return;
    case 0: 
      paramView.lIL.setVisibility(0);
      paramView.lIL.ffb();
      paramView.nMg.setVisibility(4);
      paramView.GMD.setVisibility(4);
      AppMethodBeat.o(37090);
      return;
    case 1: 
      paramView.lIL.ffc();
      paramView.lIL.setVisibility(4);
      paramView.GMD.setVisibility(4);
      paramView.nMg.setVisibility(0);
      paramView.nMg.setImageResource(2131690080);
      AppMethodBeat.o(37090);
      return;
    }
    paramView.lIL.ffc();
    paramView.lIL.setVisibility(4);
    paramView.GMD.setVisibility(0);
    paramView.nMg.setVisibility(4);
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
      localObject = new af(paramLayoutInflater, 2131493449);
      paramLayoutInflater = new aa.d().F((View)localObject, true);
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).cq(((View)localObject).getContext());
      paramLayoutInflater.GMD = paramView;
      paramLayoutInflater.GMC.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37085);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37086);
    this.Gob = parama1;
    aa.d locald = (aa.d)parama;
    parama = parambl.field_content;
    Object localObject = (k)parama1.be(k.class);
    ((k)localObject).bA(parambl);
    ((k)localObject).bB(parambl);
    ((k)localObject).bC(parambl);
    ad.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", new Object[] { paramString });
    bi localbi;
    if (parama != null)
    {
      parama = k.b.ar(parama, parambl.field_reserved);
      localbi = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
      if (parama != null)
      {
        locald.GIS.setVisibility(8);
        locald.GIR.setVisibility(8);
        locald.GJp.setVisibility(8);
        parama.ao(com.tencent.mm.ai.h.class);
        locald.naN.setBackground(ao.aC(parama1.GzJ.getContext(), 2130968737));
        com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.fv(parama.appId, parama.aAS);
        if (localg != null) {
          b(parama1, parama, parambl);
        }
        if ((parama.eOT != null) && (parama.eOT.length() != 0)) {
          break label827;
        }
        locald.GIU.setVisibility(8);
        label221:
        localObject = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW(parama.gJE);
        locald.GIX.setVisibility(0);
        locald.GIO.setVisibility(8);
        locald.GJa.setVisibility(0);
        locald.GIY.setVisibility(8);
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
        locald.GJp.setVisibility(0);
        locald.GMB.setVisibility(8);
        locald.GJt.setText(parama.title);
        locald.GMB.setText(parama.description);
        locald.GJn.setText(paramString);
        switch (parama.gJQ)
        {
        default: 
          locald.GJo.setText(2131755401);
          label395:
          o.ayJ().a((String)localObject, locald.GJm, aa.d.frV);
          if (!parama1.eZb()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locald.GIW.setVisibility(0);
              c(parama1, locald.GIW, bi.a(parama, parambl));
              label450:
              localObject = (com.tencent.mm.ai.a)parama.ao(com.tencent.mm.ai.a.class);
              paramString = new Bundle();
              paramString.putString("app_id", parama.gJF);
              paramString.putString("msg_id", parambl.field_msgId);
              if (localObject == null) {
                break label928;
              }
              parambl = ((com.tencent.mm.ai.a)localObject).gFn;
              label521:
              paramString.putString("cache_key", parambl);
              paramString.putString("msg_title", parama.title);
              paramString.putString("msg_path", parama.gJD);
              paramString.putInt("msg_pkg_type", parama.gJQ);
              paramString.putInt("pkg_version", parama.aAS);
              paramString.putInt("widget_type", 0);
              if (!parama1.eZb()) {
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
      paramString.putInt("view_init_width", aa.d.GMz);
      paramString.putInt("view_init_height", aa.d.GMA);
      locald.GMD.setTag(locald);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).a(com.tencent.mm.plugin.appbrand.aa.m.cF(parama1), locald.GMD, paramString, this.joq);
      ((q)com.tencent.mm.kernel.g.ab(q.class)).Ew(parama.gJE);
      locald.naN.setTag(localbi);
      locald.naN.setOnClickListener(d(parama1));
      paramString = y.arz().E(com.tencent.mm.plugin.appbrand.aa.m.cF(parama1), true);
      parambl = (aa.c)paramString.get("listener", null);
      parama = parambl;
      if (parambl == null)
      {
        parama = new aa.c();
        paramString.m("listener", parama);
      }
      parama.n(parama1);
      if (this.nMt) {
        locald.naN.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(37086);
      return;
      ad.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambl.field_msgId), paramString });
      parama = null;
      break;
      label827:
      locald.GIU.setVisibility(0);
      b(parama1, locald.GIU, bi.aLk(parama.eOT));
      break label221;
      label856:
      paramString = parama.dxA;
      break label291;
      label865:
      localObject = parama.gJS;
      break label303;
      locald.GJo.setText(2131755657);
      break label395;
      locald.GJo.setText(2131755656);
      break label395;
      locald.GIW.setVisibility(8);
      break label450;
      locald.GIW.setVisibility(8);
      break label450;
      parambl = null;
      break label521;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37087);
    int i = ((bi)paramView.getTag()).position;
    k.b localb = k.b.rx(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
    Object localObject;
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.j(localb.appId, false, false))) && (!j.aS(parambl)))
    {
      if (localb.type != 6) {
        break label372;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.m.aAV(localb.dbA);
      if (((localObject == null) || (!e.b.e(parambl, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))) && (!parambl.eMl())) {
        paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
      }
    }
    for (;;)
    {
      localObject = new dx();
      ((dx)localObject).dgp.msgId = parambl.field_msgId;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      if ((((dx)localObject).dgq.dfO) || (e.b.a(this.Gob.GzJ.getContext(), localb))) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131757228));
      }
      if (bk.x(parambl)) {
        paramContextMenu.clear();
      }
      if (!this.Gob.eZc()) {
        paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
      }
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atL();
      if ((paramView.atR()) || (paramView.nz(localb.gJQ)))
      {
        paramContextMenu.add(i, 133, 0, this.Gob.GzJ.getMMResources().getString(2131757231));
        paramContextMenu.add(i, 132, 0, this.Gob.GzJ.getMMResources().getString(2131757230));
      }
      AppMethodBeat.o(37087);
      return true;
      label372:
      paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37088);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37088);
      return false;
    case 111: 
      e.b.a(parama, parambl, b(parama, parambl));
      AppMethodBeat.o(37088);
      return false;
    case 133: 
      Object localObject = parambl.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = k.b.rx((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37088);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.gJF);
      ((Bundle)localObject).putString("msg_id", parambl.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.gJQ);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.gJI);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atL().d(parama.GzJ.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37088);
      return false;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.g.class)).atL().cr(parama.GzJ.getContext());
    AppMethodBeat.o(37088);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37089);
    com.tencent.mm.modelstat.a.a(parambl, a.a.htZ);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
    if (parambl.field_content == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    Object localObject1 = k.b.rx(com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
    if (localObject1 == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    paramView = com.tencent.mm.pluginsdk.model.app.h.j(((k.b)localObject1).appId, false, false);
    if (paramView != null) {
      a(parama, (k.b)localObject1, d(parama, parambl), paramView, parambl.field_msgSvrId, parama.getTalkerUserName());
    }
    ad.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((k.b)localObject1).gJE, ((k.b)localObject1).gJD, ((k.b)localObject1).gJF, ((k.b)localObject1).url, Integer.valueOf(((k.b)localObject1).gJQ), ((k.b)localObject1).gJH });
    paramView = new uj();
    paramView.dzH.appId = ((k.b)localObject1).gJF;
    paramView.dzH.userName = ((k.b)localObject1).gJE;
    paramView.dzH.dzJ = ((k.b)localObject1).gJD;
    paramView.dzH.dzK = ((k.b)localObject1).gJQ;
    paramView.dzH.dzM = ((k.b)localObject1).gJH;
    paramView.dzH.aAS = ((k.b)localObject1).gJR;
    Object localObject2 = paramView.dzH;
    boolean bool;
    if (((k.b)localObject1).gJQ != 0)
    {
      bool = true;
      ((uj.a)localObject2).dzN = bool;
      paramView.dzH.dzP.cff = parama.getTalkerUserName();
      paramView.dzH.dzP.cfh = ((k.b)localObject1).gJK;
      localObject1 = ((k.b)localObject1).gJJ;
      if (!parama.eZb()) {
        break label420;
      }
      paramView.dzH.scene = 1008;
      localObject2 = new StringBuilder(parama.getTalkerUserName());
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(b(parama, parambl));
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    for (paramView.dzH.dbt = ((StringBuilder)localObject2).toString();; paramView.dzH.dbt = parama.toString())
    {
      com.tencent.mm.sdk.b.a.ESL.l(paramView);
      AppMethodBeat.o(37089);
      return true;
      bool = false;
      break;
      label420:
      paramView.dzH.scene = 1007;
      parama = new StringBuilder(b(parama, parambl));
      parama.append(":");
      parama.append((String)localObject1);
    }
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.a
 * JD-Core Version:    0.7.0.1
 */