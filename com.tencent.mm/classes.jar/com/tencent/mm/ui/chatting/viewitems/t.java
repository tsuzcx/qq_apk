package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.h;
import java.lang.ref.WeakReference;

public final class t
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a zzP;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(33047);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new w(paramLayoutInflater, 2130969075);
        ((View)localObject).setTag(new t.d().D((View)localObject, true));
      }
      AppMethodBeat.o(33047);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
    {
      AppMethodBeat.i(33048);
      this.zzP = parama1;
      t.d locald = (t.d)parama;
      parama = (com.tencent.mm.ui.chatting.c.b.j)parama1.ay(com.tencent.mm.ui.chatting.c.b.j.class);
      parama.bf(parambi);
      parama.bg(parambi);
      parama.bh(parambi);
      parama = parambi.field_content;
      az localaz;
      Object localObject;
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
            break label902;
          }
          paramString = null;
          label148:
          if (!((ChattingItemFooter)localObject).m(paramString, parambi.field_talker)) {
            break label912;
          }
          locald.jYu.setBackgroundResource(2130838276);
          label173:
          localObject = com.tencent.mm.pluginsdk.model.app.g.em(parama.appId, parama.bDc);
          if (localObject != null) {
            b(parama1, parama, parambi);
          }
          if ((parama.dGR != null) && (parama.dGR.length() != 0)) {
            break label926;
          }
          locald.zRY.setVisibility(8);
          label225:
          WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.i.class)).Ae(parama.fiX);
          locald.zSb.setVisibility(0);
          locald.zRS.setVisibility(8);
          locald.zSe.setVisibility(0);
          locald.zSc.setVisibility(8);
          if (localWxaAttributes == null) {
            break label955;
          }
          paramString = localWxaAttributes.field_nickname;
          label294:
          locald.zSr.setText(paramString);
          if (localWxaAttributes == null) {
            break label964;
          }
          paramString = localWxaAttributes.field_smallHeadURL;
          label316:
          o.ahG().a(paramString, locald.zSq, t.d.zUx);
          locald.zSt.setVisibility(0);
          locald.zUy.setVisibility(8);
          locald.zUy.setText(parama.description);
          locald.zSw.setText(parama.title);
          switch (parama.fjh)
          {
          default: 
            locald.zSs.setText(2131296630);
            label411:
            o.ahG().a(paramString, locald.zSq, t.d.zUx);
            if (!parama1.dJG()) {
              if (com.tencent.mm.pluginsdk.model.app.g.j((f)localObject))
              {
                locald.zSa.setVisibility(0);
                c(parama1, locald.zSa, az.a(parama, parambi));
              }
            }
            break;
          }
        }
      }
      for (;;)
      {
        parambi = o.ahC().c(parambi.field_imgPath, false, true);
        locald.zSu.setImageBitmap(null);
        locald.zSu.setVisibility(4);
        locald.zSv.setVisibility(0);
        com.tencent.mm.modelappbrand.a.b.acD().a(new t.a.1(this, locald), "file://".concat(String.valueOf(parambi)), null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).cu(240, 192));
        locald.zUG.setVisibility(8);
        locald.zUG.setTag(bo.bf(parama.fjd, ""));
        locald.zUH.setVisibility(8);
        parambi = (com.tencent.mm.af.a)parama.R(com.tencent.mm.af.a.class);
        if ((parambi != null) && (parambi.fff))
        {
          paramString = parama.fjd;
          localObject = ((k)com.tencent.mm.kernel.g.E(k.class)).qj(paramString);
          t.a(parama1, locald, parambi, (com.tencent.mm.af.a.b)localObject);
          t.a(parama1, locald, parambi, parama, (com.tencent.mm.af.a.b)localObject);
          int i = parambi.ffm;
          paramInt = i;
          if (localObject != null)
          {
            paramInt = i;
            if (((com.tencent.mm.af.a.b)localObject).field_updatePeroid != 0) {
              paramInt = ((com.tencent.mm.af.a.b)localObject).field_updatePeroid;
            }
          }
          if (paramInt > 0) {
            ((k)com.tencent.mm.kernel.g.E(k.class)).a(t.e.bt(parama1), parama.fiY, paramString, paramInt, new t.a.2(this, locald, parambi));
          }
        }
        locald.jYu.setTag(localaz);
        locald.jYu.setOnClickListener(d(parama1));
        paramString = v.aae().z(t.e.bt(parama1), true);
        parambi = (t.c)paramString.get("listener", null);
        parama = parambi;
        if (parambi == null)
        {
          parama = new t.c();
          paramString.i("listener", parama);
        }
        parama.n(parama1);
        if (this.kFs)
        {
          locald.jYu.setOnLongClickListener(c(parama1));
          locald.jYu.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
        }
        AppMethodBeat.o(33048);
        return;
        ab.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambi.field_msgId), paramString });
        parama = null;
        break;
        label902:
        paramString = paramString.fgn;
        break label148;
        label912:
        locald.jYu.setBackgroundResource(2130838264);
        break label173;
        label926:
        locald.zRY.setVisibility(0);
        b(parama1, locald.zRY, az.auv(parama.dGR));
        break label225;
        label955:
        paramString = parama.cGO;
        break label294;
        label964:
        paramString = parama.fjj;
        break label316;
        locald.zSs.setText(2131296857);
        break label411;
        locald.zSs.setText(2131296856);
        break label411;
        locald.zSa.setVisibility(8);
        continue;
        locald.zSa.setVisibility(8);
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
    {
      AppMethodBeat.i(33049);
      int i = ((az)paramView.getTag()).position;
      j.b localb = j.b.mY(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
      Object localObject;
      if ((com.tencent.mm.pluginsdk.model.app.g.k(com.tencent.mm.pluginsdk.model.app.g.ca(localb.appId, false))) && (!com.tencent.mm.ui.chatting.j.aB(parambi)))
      {
        if (localb.type != 6) {
          break label263;
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
        if (!this.zzP.dJH()) {
          paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
        }
        AppMethodBeat.o(33049);
        return true;
        label263:
        paramContextMenu.add(i, 111, 0, this.zzP.zJz.getMMResources().getString(2131302650));
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
    {
      AppMethodBeat.i(33050);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(33050);
        return false;
      }
      d.b.a(parama, parambi, b(parama, parambi));
      AppMethodBeat.o(33050);
      return false;
    }
    
    public final boolean aK(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 587202609);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
    {
      AppMethodBeat.i(33051);
      com.tencent.mm.modelstat.a.a(parambi, a.a.fRr);
      if (parambi.field_content == null)
      {
        AppMethodBeat.o(33051);
        return false;
      }
      paramView = j.b.mY(bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
      if (paramView == null)
      {
        AppMethodBeat.o(33051);
        return false;
      }
      Object localObject1 = com.tencent.mm.pluginsdk.model.app.g.ca(paramView.appId, false);
      if (localObject1 != null) {
        a(parama, paramView, d(parama, parambi), (f)localObject1, parambi.field_msgSvrId, parama.getTalkerUserName());
      }
      ab.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramView.fiX, paramView.fiW, paramView.fiY, paramView.url, Integer.valueOf(paramView.fjh), paramView.fja });
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
        ((so)localObject1).cIQ.cIY.bCY = parama.getTalkerUserName();
        ((so)localObject1).cIQ.cIY.bCZ = paramView.fjd;
        localObject2 = paramView.fjc;
        if (!parama.dJG()) {
          break label404;
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
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        t.a(parama, paramView);
        AppMethodBeat.o(33051);
        return true;
        bool = false;
        break;
        label404:
        ((so)localObject1).cIQ.scene = 1007;
        parambi = new StringBuilder(b(parama, parambi));
        parambi.append(":");
        parambi.append((String)localObject2);
      }
    }
    
    public final boolean dLp()
    {
      return false;
    }
  }
  
  static final class c
    implements com.tencent.mm.ui.l
  {
    private WeakReference<com.tencent.mm.ui.chatting.d.a> zUu;
    
    public final void dBY() {}
    
    public final void dBZ() {}
    
    public final void dCa() {}
    
    public final void dCb()
    {
      AppMethodBeat.i(33062);
      ((k)com.tencent.mm.kernel.g.E(k.class)).aco();
      AppMethodBeat.o(33062);
    }
    
    public final void dCc()
    {
      AppMethodBeat.i(33063);
      ((k)com.tencent.mm.kernel.g.E(k.class)).acp();
      AppMethodBeat.o(33063);
    }
    
    public final void dCd()
    {
      AppMethodBeat.i(33064);
      ab.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
      if (this.zUu == null)
      {
        AppMethodBeat.o(33064);
        return;
      }
      com.tencent.mm.ui.chatting.d.a locala = (com.tencent.mm.ui.chatting.d.a)this.zUu.get();
      if (locala != null)
      {
        v.aae().oP(t.e.bt(locala));
        ((com.tencent.mm.ui.chatting.c.b.g)locala.ay(com.tencent.mm.ui.chatting.c.b.g.class)).b(this);
        ((k)com.tencent.mm.kernel.g.E(k.class)).qk(t.e.bt(locala));
      }
      AppMethodBeat.o(33064);
    }
    
    public final void dCe() {}
    
    final void n(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(33061);
      this.zUu = new WeakReference(parama);
      ((com.tencent.mm.ui.chatting.c.b.g)parama.ay(com.tencent.mm.ui.chatting.c.b.g.class)).a(this);
      AppMethodBeat.o(33061);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t
 * JD-Core Version:    0.7.0.1
 */