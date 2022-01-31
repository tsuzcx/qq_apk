package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
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
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.s.n;

public final class t$b
  extends c
  implements s.n
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33055);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969113);
      ((View)localObject).setTag(new t.d().D((View)localObject, false));
    }
    AppMethodBeat.o(33055);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33060);
    if (parambi.bCn())
    {
      l.al(parambi);
      bf.gw(parambi.field_msgId);
      parama.qT(true);
      AppMethodBeat.o(33060);
      return;
    }
    AppMethodBeat.o(33060);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33056);
    t.d locald = (t.d)parama;
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
        localObject = ((com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.i.class)).Ae(parama.fiX);
        if (localObject == null) {
          break label773;
        }
        paramString = ((WxaAttributes)localObject).field_nickname;
        if (localObject == null) {
          break label782;
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
          label258:
          o.ahG().a((String)localObject, locald.zSq, t.d.zUx);
          if (dLr())
          {
            paramString = (h)parama1.ay(h.class);
            if ((parambi.field_status == 2) && (a(paramString, parambi.field_msgId)))
            {
              if (locald.zSm != null) {
                locald.zSm.setVisibility(0);
              }
              label330:
              if (locald.pNd != null) {
                locald.pNd.setVisibility(8);
              }
            }
          }
          break;
        }
      }
      for (;;)
      {
        paramString = o.ahC().c(parambi.field_imgPath, false, true);
        locald.zSu.setImageBitmap(null);
        locald.zSu.setVisibility(4);
        locald.zSv.setVisibility(0);
        com.tencent.mm.modelappbrand.a.b.acD().a(new t.b.1(this, locald), "file://".concat(String.valueOf(paramString)), null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).cu(240, 192));
        locald.zUG.setVisibility(8);
        locald.zUG.setTag(bo.bf(parama.fjd, ""));
        locald.zUH.setVisibility(8);
        paramString = (com.tencent.mm.af.a)parama.R(com.tencent.mm.af.a.class);
        if ((paramString != null) && (paramString.fff))
        {
          localObject = parama.fjd;
          com.tencent.mm.af.a.b localb = ((k)com.tencent.mm.kernel.g.E(k.class)).qj((String)localObject);
          t.a(parama1, locald, paramString, localb);
          t.a(parama1, locald, paramString, parama, localb);
          int j = paramString.ffm;
          int i = j;
          if (localb != null)
          {
            i = j;
            if (localb.field_updatePeroid != 0) {
              i = localb.field_updatePeroid;
            }
          }
          if (i > 0) {
            ((k)com.tencent.mm.kernel.g.E(k.class)).a(t.e.bt(parama1), parama.fiY, (String)localObject, i, new t.b.2(this, locald, paramString));
          }
        }
        locald.jYu.setTag(localaz);
        locald.jYu.setOnClickListener(d(parama1));
        localObject = v.aae().z(t.e.bt(parama1), true);
        paramString = (t.c)((v.b)localObject).get("listener", null);
        parama = paramString;
        if (paramString == null)
        {
          parama = new t.c();
          ((v.b)localObject).i("listener", parama);
        }
        parama.n(parama1);
        if (this.kFs)
        {
          locald.jYu.setOnLongClickListener(c(parama1));
          locald.jYu.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
        }
        a(paramInt, locald, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
        AppMethodBeat.o(33056);
        return;
        label773:
        paramString = parama.cGO;
        break;
        label782:
        localObject = parama.fjj;
        break label170;
        locald.zSs.setText(2131296857);
        break label258;
        locald.zSs.setText(2131296856);
        break label258;
        if (locald.zSm == null) {
          break label330;
        }
        locald.zSm.setVisibility(8);
        break label330;
        if (locald.pNd != null)
        {
          locald.pNd.setVisibility(0);
          if (parambi.field_status >= 2) {
            locald.pNd.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33057);
    int i = ((az)paramView.getTag()).position;
    if (parambi.field_content == null)
    {
      AppMethodBeat.o(33057);
      return true;
    }
    j.b localb = j.b.mY(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(33057);
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
    AppMethodBeat.o(33057);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33058);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(33058);
      return false;
    case 111: 
      d.b.a(parama, parambi, b(parama, parambi));
      AppMethodBeat.o(33058);
      return false;
    }
    paramMenuItem = parambi.field_content;
    if (paramMenuItem == null)
    {
      AppMethodBeat.o(33058);
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
      AppMethodBeat.o(33058);
      return false;
      parama = new ij();
      parama.cxJ.cxK = paramMenuItem.cxK;
      parama.cxJ.cpg = parambi.field_msgId;
      parama.cxJ.cxL = parambi.field_talker;
      com.tencent.mm.sdk.b.a.ymk.l(parama);
    }
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 587202609);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33059);
    paramView.getTag();
    paramView = parambi.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(33059);
      return false;
    }
    paramView = j.b.mY(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(33059);
      return false;
    }
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.g.ca(paramView.appId, true);
    if ((localObject1 != null) && (!bo.isNullOrNil(((f)localObject1).field_appId))) {
      a(parama, paramView, r.Zn(), (f)localObject1, parambi.field_msgSvrId, parama.getTalkerUserName());
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
        break label340;
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
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      t.a(parama, paramView);
      AppMethodBeat.o(33059);
      return true;
      bool = false;
      break;
      label340:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.b
 * JD-Core Version:    0.7.0.1
 */