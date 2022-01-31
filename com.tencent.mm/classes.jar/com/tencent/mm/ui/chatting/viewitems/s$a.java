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
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.so.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.s.n;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class s$a
  extends c
  implements com.tencent.mm.modelappbrand.f
{
  private com.tencent.mm.modelappbrand.ab hrh;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public s$a()
  {
    AppMethodBeat.i(33022);
    this.hrh = new ac(this);
    AppMethodBeat.o(33022);
  }
  
  public final void I(View paramView, int paramInt)
  {
    AppMethodBeat.i(33028);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof s.d))
    {
      AppMethodBeat.o(33028);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
    paramView = (s.d)localObject;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      paramView.iTR.dOW();
      paramView.iTR.setVisibility(4);
      paramView.zUA.setVisibility(4);
      paramView.kha.setVisibility(0);
      paramView.kha.setImageResource(2131230887);
      AppMethodBeat.o(33028);
      return;
    case 0: 
      paramView.iTR.setVisibility(0);
      paramView.iTR.dOV();
      paramView.kha.setVisibility(4);
      paramView.zUA.setVisibility(4);
      AppMethodBeat.o(33028);
      return;
    case 1: 
      paramView.iTR.dOW();
      paramView.iTR.setVisibility(4);
      paramView.zUA.setVisibility(4);
      paramView.kha.setVisibility(0);
      paramView.kha.setImageResource(2131231255);
      AppMethodBeat.o(33028);
      return;
    }
    paramView.iTR.dOW();
    paramView.iTR.setVisibility(4);
    paramView.zUA.setVisibility(0);
    paramView.kha.setVisibility(4);
    AppMethodBeat.o(33028);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33023);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969076);
      paramLayoutInflater = new s.d().C((View)localObject, true);
      paramView = ((e)com.tencent.mm.kernel.g.E(e.class)).bX(((View)localObject).getContext());
      paramLayoutInflater.zUA = paramView;
      paramLayoutInflater.zUz.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(33023);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33024);
    this.zzP = parama1;
    s.d locald = (s.d)parama;
    parama = parambi.field_content;
    Object localObject = (com.tencent.mm.ui.chatting.c.b.j)parama1.ay(com.tencent.mm.ui.chatting.c.b.j.class);
    ((com.tencent.mm.ui.chatting.c.b.j)localObject).bf(parambi);
    ((com.tencent.mm.ui.chatting.c.b.j)localObject).bg(parambi);
    ((com.tencent.mm.ui.chatting.c.b.j)localObject).bh(parambi);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", new Object[] { paramString });
    az localaz;
    if (parama != null)
    {
      parama = j.b.ab(parama, parambi.field_reserved);
      localaz = new az(parambi, parama1.dJG(), paramInt, null, '\000');
      if (parama != null)
      {
        locald.zRW.setVisibility(8);
        locald.zRV.setVisibility(8);
        locald.zSt.setVisibility(8);
        paramString = (com.tencent.mm.af.g)parama.R(com.tencent.mm.af.g.class);
        localObject = locald.zRZ;
        if (paramString != null) {
          break label833;
        }
        paramString = null;
        label168:
        if (!((ChattingItemFooter)localObject).m(paramString, parambi.field_talker)) {
          break label843;
        }
        locald.jYu.setBackgroundResource(2130838276);
        label193:
        com.tencent.mm.pluginsdk.model.app.f localf = com.tencent.mm.pluginsdk.model.app.g.em(parama.appId, parama.bDc);
        if (localf != null) {
          b(parama1, parama, parambi);
        }
        if ((parama.dGR != null) && (parama.dGR.length() != 0)) {
          break label857;
        }
        locald.zRY.setVisibility(8);
        label245:
        localObject = ((i)com.tencent.mm.kernel.g.E(i.class)).Ae(parama.fiX);
        locald.zSb.setVisibility(0);
        locald.zRS.setVisibility(8);
        locald.zSe.setVisibility(0);
        locald.zSc.setVisibility(8);
        if (localObject == null) {
          break label886;
        }
        paramString = ((WxaAttributes)localObject).field_nickname;
        label315:
        if (localObject == null) {
          break label895;
        }
        localObject = ((WxaAttributes)localObject).field_smallHeadURL;
        label327:
        locald.zSt.setVisibility(0);
        locald.zUy.setVisibility(8);
        locald.zSw.setText(parama.title);
        locald.zUy.setText(parama.description);
        locald.zSr.setText(paramString);
        switch (parama.fjh)
        {
        default: 
          locald.zSs.setText(2131296630);
          label419:
          o.ahG().a((String)localObject, locald.zSq, s.d.zUx);
          if (!parama1.dJG()) {
            if (com.tencent.mm.pluginsdk.model.app.g.j(localf))
            {
              locald.zSa.setVisibility(0);
              c(parama1, locald.zSa, az.a(parama, parambi));
              label474:
              localObject = (com.tencent.mm.af.a)parama.R(com.tencent.mm.af.a.class);
              paramString = new Bundle();
              paramString.putString("app_id", parama.fiY);
              paramString.putString("msg_id", parambi.field_msgId);
              if (localObject == null) {
                break label958;
              }
              parambi = ((com.tencent.mm.af.a)localObject).ffd;
              label545:
              paramString.putString("cache_key", parambi);
              paramString.putString("msg_title", parama.title);
              paramString.putString("msg_path", parama.fiW);
              paramString.putInt("msg_pkg_type", parama.fjh);
              paramString.putInt("pkg_version", parama.bDc);
              paramString.putInt("widget_type", 0);
              if (!parama1.dJG()) {
                break label964;
              }
            }
          }
          break;
        }
      }
    }
    label833:
    label964:
    for (paramInt = 1008;; paramInt = 1007)
    {
      paramString.putInt("scene", paramInt);
      paramString.putInt("view_init_width", s.d.zUv);
      paramString.putInt("view_init_height", s.d.zUw);
      locald.zUA.setTag(locald);
      ((e)com.tencent.mm.kernel.g.E(e.class)).a(n.bt(parama1), locald.zUA, paramString, this.hrh);
      locald.jYu.setTag(localaz);
      locald.jYu.setOnClickListener(d(parama1));
      paramString = v.aae().z(n.bt(parama1), true);
      parambi = (s.c)paramString.get("listener", null);
      parama = parambi;
      if (parambi == null)
      {
        parama = new s.c();
        paramString.i("listener", parama);
      }
      parama.n(parama1);
      if (this.kFs) {
        locald.jYu.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(33024);
      return;
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambi.field_msgId), paramString });
      parama = null;
      break;
      paramString = paramString.fgn;
      break label168;
      label843:
      locald.jYu.setBackgroundResource(2130838264);
      break label193;
      label857:
      locald.zRY.setVisibility(0);
      b(parama1, locald.zRY, az.auv(parama.dGR));
      break label245;
      label886:
      paramString = parama.cGO;
      break label315;
      label895:
      localObject = parama.fjj;
      break label327;
      locald.zSs.setText(2131296857);
      break label419;
      locald.zSs.setText(2131296856);
      break label419;
      locald.zSa.setVisibility(8);
      break label474;
      locald.zSa.setVisibility(8);
      break label474;
      parambi = null;
      break label545;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33025);
    int i = ((az)paramView.getTag()).position;
    j.b localb = j.b.mY(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    Object localObject;
    if ((com.tencent.mm.pluginsdk.model.app.g.k(com.tencent.mm.pluginsdk.model.app.g.ca(localb.appId, false))) && (!com.tencent.mm.ui.chatting.j.aB(parambi)))
    {
      if (localb.type != 6) {
        break label371;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.l.alv(localb.cmN);
      if (((localObject == null) || (!d.b.e(parambi, ((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath))) && (!parambi.dyc())) {
        paramContextMenu.add(i, 111, 0, this.zzP.zJz.getMMResources().getString(2131302650));
      }
    }
    for (;;)
    {
      localObject = new dr();
      ((dr)localObject).crt.cpO = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      if ((((dr)localObject).cru.cqS) || (d.b.a(this.zzP.zJz.getContext(), localb))) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131298238));
      }
      if (bh.o(parambi)) {
        paramContextMenu.clear();
      }
      if (!this.zzP.dJH()) {
        paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
      }
      paramView = ((e)com.tencent.mm.kernel.g.E(e.class)).acl();
      if ((paramView.acq()) || (paramView.kQ(localb.fjh)))
      {
        paramContextMenu.add(i, 133, 0, this.zzP.zJz.getMMResources().getString(2131298241));
        paramContextMenu.add(i, 132, 0, this.zzP.zJz.getMMResources().getString(2131298240));
      }
      AppMethodBeat.o(33025);
      return true;
      label371:
      paramContextMenu.add(i, 111, 0, this.zzP.zJz.getMMResources().getString(2131302650));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33026);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(33026);
      return false;
    case 111: 
      d.b.a(parama, parambi, b(parama, parambi));
      AppMethodBeat.o(33026);
      return false;
    case 133: 
      Object localObject = parambi.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = j.b.mY((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(33026);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.fiY);
      ((Bundle)localObject).putString("msg_id", parambi.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.fjh);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.fjb);
      ((e)com.tencent.mm.kernel.g.E(e.class)).acl().f(parama.zJz.getContext(), (Bundle)localObject);
      AppMethodBeat.o(33026);
      return false;
    }
    ((e)com.tencent.mm.kernel.g.E(e.class)).acl().bY(parama.zJz.getContext());
    AppMethodBeat.o(33026);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33027);
    com.tencent.mm.modelstat.a.a(parambi, a.a.fRr);
    if (parambi.field_content == null)
    {
      AppMethodBeat.o(33027);
      return false;
    }
    Object localObject1 = j.b.mY(bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
    if (localObject1 == null)
    {
      AppMethodBeat.o(33027);
      return false;
    }
    paramView = com.tencent.mm.pluginsdk.model.app.g.ca(((j.b)localObject1).appId, false);
    if (paramView != null) {
      a(parama, (j.b)localObject1, d(parama, parambi), paramView, parambi.field_msgSvrId, parama.getTalkerUserName());
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((j.b)localObject1).fiX, ((j.b)localObject1).fiW, ((j.b)localObject1).fiY, ((j.b)localObject1).url, Integer.valueOf(((j.b)localObject1).fjh), ((j.b)localObject1).fja });
    paramView = new so();
    paramView.cIQ.appId = ((j.b)localObject1).fiY;
    paramView.cIQ.userName = ((j.b)localObject1).fiX;
    paramView.cIQ.cIS = ((j.b)localObject1).fiW;
    paramView.cIQ.cIT = ((j.b)localObject1).fjh;
    paramView.cIQ.cIV = ((j.b)localObject1).fja;
    paramView.cIQ.bDc = ((j.b)localObject1).fji;
    Object localObject2 = paramView.cIQ;
    boolean bool;
    if (((j.b)localObject1).fjh != 0)
    {
      bool = true;
      ((so.a)localObject2).cIW = bool;
      paramView.cIQ.cIY.bCY = parama.getTalkerUserName();
      paramView.cIQ.cIY.bCZ = ((j.b)localObject1).fjd;
      localObject1 = ((j.b)localObject1).fjc;
      if (!parama.dJG()) {
        break label401;
      }
      paramView.cIQ.scene = 1008;
      localObject2 = new StringBuilder(parama.getTalkerUserName());
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(b(parama, parambi));
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    for (paramView.cIQ.cmF = ((StringBuilder)localObject2).toString();; paramView.cIQ.cmF = parama.toString())
    {
      com.tencent.mm.sdk.b.a.ymk.l(paramView);
      AppMethodBeat.o(33027);
      return true;
      bool = false;
      break;
      label401:
      paramView.cIQ.scene = 1007;
      parama = new StringBuilder(b(parama, parambi));
      parama.append(":");
      parama.append((String)localObject1);
    }
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s.a
 * JD-Core Version:    0.7.0.1
 */