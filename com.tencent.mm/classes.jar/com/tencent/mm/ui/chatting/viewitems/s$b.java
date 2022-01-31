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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.a.so.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.s.n;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class s$b
  extends c
  implements com.tencent.mm.modelappbrand.f, s.n
{
  private com.tencent.mm.modelappbrand.ab hrh;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public s$b()
  {
    AppMethodBeat.i(33029);
    this.hrh = new ac(this);
    AppMethodBeat.o(33029);
  }
  
  public final void I(View paramView, int paramInt)
  {
    AppMethodBeat.i(33035);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof s.d))
    {
      AppMethodBeat.o(33035);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
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
      AppMethodBeat.o(33035);
      return;
    case 0: 
      paramView.iTR.setVisibility(0);
      paramView.iTR.dOV();
      paramView.zUA.setVisibility(4);
      paramView.kha.setVisibility(4);
      AppMethodBeat.o(33035);
      return;
    case 1: 
      paramView.iTR.dOW();
      paramView.iTR.setVisibility(4);
      paramView.zUA.setVisibility(4);
      paramView.kha.setVisibility(0);
      paramView.kha.setImageResource(2131231255);
      AppMethodBeat.o(33035);
      return;
    }
    paramView.iTR.dOW();
    paramView.iTR.setVisibility(4);
    paramView.zUA.setVisibility(0);
    paramView.kha.setVisibility(4);
    AppMethodBeat.o(33035);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33030);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969114);
      paramLayoutInflater = new s.d().C((View)localObject, false);
      paramView = ((e)com.tencent.mm.kernel.g.E(e.class)).bX(((View)localObject).getContext());
      paramLayoutInflater.zUA = paramView;
      paramLayoutInflater.zUz.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(33030);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33036);
    if (parambi.bCn())
    {
      com.tencent.mm.pluginsdk.model.app.l.al(parambi);
      bf.gw(parambi.field_msgId);
      parama.qT(true);
      AppMethodBeat.o(33036);
      return;
    }
    AppMethodBeat.o(33036);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33031);
    s.d locald = (s.d)parama;
    this.zzP = parama1;
    parama = (com.tencent.mm.ui.chatting.c.b.j)parama1.ay(com.tencent.mm.ui.chatting.c.b.j.class);
    parama.bh(parambi);
    paramString = parambi.field_content;
    parama.bf(parambi);
    if (paramString != null) {}
    for (parama = j.b.ab(paramString, parambi.field_reserved);; parama = null)
    {
      az localaz = new az(parambi, parama1.dJG(), paramInt, null, '\000');
      Object localObject;
      if (parama != null)
      {
        locald.zRW.setVisibility(8);
        locald.zRV.setVisibility(8);
        locald.zRS.setVisibility(8);
        locald.zSt.setVisibility(8);
        localObject = ((i)com.tencent.mm.kernel.g.E(i.class)).Ae(parama.fiX);
        if (localObject == null) {
          break label697;
        }
        paramString = ((WxaAttributes)localObject).field_nickname;
        if (localObject == null) {
          break label706;
        }
        localObject = ((WxaAttributes)localObject).field_smallHeadURL;
        label170:
        locald.zSt.setVisibility(0);
        locald.zUy.setVisibility(8);
        locald.zSw.setText(parama.title);
        locald.zUy.setText(parama.description);
        locald.zSr.setText(paramString);
        switch (parama.fjh)
        {
        default: 
          locald.zSs.setText(2131296630);
          label259:
          o.ahG().a((String)localObject, locald.zSq, s.d.zUx);
          if (dLr())
          {
            paramString = (h)parama1.ay(h.class);
            if ((parambi.field_status == 2) && (a(paramString, parambi.field_msgId)))
            {
              if (locald.zSm != null) {
                locald.zSm.setVisibility(0);
              }
              label332:
              if (locald.pNd != null) {
                locald.pNd.setVisibility(8);
              }
              label350:
              paramString = (com.tencent.mm.af.a)parama.R(com.tencent.mm.af.a.class);
              localObject = new Bundle();
              ((Bundle)localObject).putString("app_id", parama.fiY);
              ((Bundle)localObject).putString("msg_id", parambi.field_msgId);
              if (paramString == null) {
                break label803;
              }
              paramString = paramString.ffd;
              label421:
              ((Bundle)localObject).putString("cache_key", paramString);
              ((Bundle)localObject).putString("msg_title", parama.title);
              ((Bundle)localObject).putString("msg_path", parama.fiW);
              ((Bundle)localObject).putInt("msg_pkg_type", parama.fjh);
              ((Bundle)localObject).putInt("pkg_version", parama.bDc);
              ((Bundle)localObject).putInt("widget_type", 0);
              if (!parama1.dJG()) {
                break label809;
              }
            }
          }
          break;
        }
      }
      label803:
      label809:
      for (int i = 1008;; i = 1007)
      {
        ((Bundle)localObject).putInt("scene", i);
        ((Bundle)localObject).putInt("view_init_width", s.d.zUv);
        ((Bundle)localObject).putInt("view_init_height", s.d.zUw);
        locald.zUA.setTag(locald);
        ((e)com.tencent.mm.kernel.g.E(e.class)).a(n.bt(parama1), locald.zUA, (Bundle)localObject, this.hrh);
        locald.jYu.setTag(localaz);
        locald.jYu.setOnClickListener(d(parama1));
        localObject = v.aae().z(n.bt(parama1), true);
        paramString = (s.c)((v.b)localObject).get("listener", null);
        parama = paramString;
        if (paramString == null)
        {
          parama = new s.c();
          ((v.b)localObject).i("listener", parama);
        }
        parama.n(parama1);
        if (this.kFs) {
          locald.jYu.setOnLongClickListener(c(parama1));
        }
        a(paramInt, locald, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
        AppMethodBeat.o(33031);
        return;
        label697:
        paramString = parama.cGO;
        break;
        label706:
        localObject = parama.fjj;
        break label170;
        locald.zSs.setText(2131296857);
        break label259;
        locald.zSs.setText(2131296856);
        break label259;
        if (locald.zSm == null) {
          break label332;
        }
        locald.zSm.setVisibility(8);
        break label332;
        if (locald.pNd == null) {
          break label350;
        }
        locald.pNd.setVisibility(0);
        if (parambi.field_status < 2) {
          break label350;
        }
        locald.pNd.setVisibility(8);
        break label350;
        paramString = null;
        break label421;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33032);
    int i = ((az)paramView.getTag()).position;
    if (parambi.field_content == null)
    {
      AppMethodBeat.o(33032);
      return true;
    }
    j.b localb = j.b.mY(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(33032);
      return true;
    }
    if ((com.tencent.mm.pluginsdk.model.app.g.k(com.tencent.mm.pluginsdk.model.app.g.ca(localb.appId, false))) && (!com.tencent.mm.ui.chatting.j.aB(parambi))) {
      paramContextMenu.add(i, 111, 0, this.zzP.zJz.getMMResources().getString(2131302650));
    }
    if (((parambi.field_status == 2) || (parambi.dGV == 1)) && (a(parambi, this.zzP)) && (auk(parambi.field_talker))) {
      paramContextMenu.add(i, 123, 0, paramView.getContext().getString(2131298244));
    }
    dr localdr = new dr();
    localdr.crt.cpO = parambi.field_msgId;
    com.tencent.mm.sdk.b.a.ymk.l(localdr);
    if ((localdr.cru.cqS) || (d.b.a(this.zzP.zJz.getContext(), localb))) {
      paramContextMenu.add(i, 129, 0, paramView.getContext().getString(2131298238));
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
    AppMethodBeat.o(33032);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33033);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(33033);
      return false;
    case 111: 
      d.b.a(parama, parambi, b(parama, parambi));
      AppMethodBeat.o(33033);
      return false;
    case 103: 
      paramMenuItem = parambi.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(33033);
        return false;
      }
      paramMenuItem = j.b.mY(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(33033);
        return false;
        parama = new ij();
        parama.cxJ.cxK = paramMenuItem.cxK;
        parama.cxJ.cpg = parambi.field_msgId;
        parama.cxJ.cxL = parambi.field_talker;
        com.tencent.mm.sdk.b.a.ymk.l(parama);
      }
    case 133: 
      Object localObject = parambi.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = j.b.mY((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(33033);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.fiY);
      ((Bundle)localObject).putString("msg_id", parambi.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.fjh);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.fjb);
      ((e)com.tencent.mm.kernel.g.E(e.class)).acl().f(parama.zJz.getContext(), (Bundle)localObject);
      AppMethodBeat.o(33033);
      return false;
    }
    ((e)com.tencent.mm.kernel.g.E(e.class)).acl().bY(parama.zJz.getContext());
    AppMethodBeat.o(33033);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33034);
    paramView.getTag();
    paramView = parambi.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(33034);
      return false;
    }
    paramView = j.b.mY(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(33034);
      return false;
    }
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.g.ca(paramView.appId, true);
    if ((localObject1 != null) && (!bo.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.f)localObject1).field_appId))) {
      a(parama, paramView, r.Zn(), (com.tencent.mm.pluginsdk.model.app.f)localObject1, parambi.field_msgSvrId, parama.getTalkerUserName());
    }
    localObject1 = new so();
    ((so)localObject1).cIQ.appId = paramView.fiY;
    ((so)localObject1).cIQ.userName = paramView.fiX;
    ((so)localObject1).cIQ.cIS = paramView.fiW;
    ((so)localObject1).cIQ.cIT = paramView.fjh;
    ((so)localObject1).cIQ.cIV = paramView.fja;
    ((so)localObject1).cIQ.bDc = paramView.fji;
    Object localObject2 = ((so)localObject1).cIQ;
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramView.fjh != 0)
    {
      bool = true;
      ((so.a)localObject2).cIW = bool;
      localObject2 = paramView.fjc;
      if (!parama.dJG()) {
        break label335;
      }
      ((so)localObject1).cIQ.scene = 1008;
      localStringBuilder = new StringBuilder(parama.getTalkerUserName());
      localStringBuilder.append(":");
      localStringBuilder.append(b(parama, parambi));
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject2);
    }
    for (((so)localObject1).cIQ.cmF = localStringBuilder.toString();; ((so)localObject1).cIQ.cmF = parambi.toString())
    {
      ((so)localObject1).cIQ.cIY.bCY = parama.getTalkerUserName();
      ((so)localObject1).cIQ.cIY.bCZ = paramView.fjd;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject1);
      AppMethodBeat.o(33034);
      return true;
      bool = false;
      break;
      label335:
      ((so)localObject1).cIQ.scene = 1007;
      parambi = new StringBuilder(b(parama, parambi));
      parambi.append(":");
      parambi.append((String)localObject2);
    }
  }
  
  public final boolean dLp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s.b
 * JD-Core Version:    0.7.0.1
 */