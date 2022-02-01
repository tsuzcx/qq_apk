package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.a.ut.a;
import com.tencent.mm.g.b.a.ij;
import com.tencent.mm.g.b.a.ij.a;
import com.tencent.mm.g.b.a.ij.b;
import com.tencent.mm.g.b.a.ij.c;
import com.tencent.mm.g.b.a.ij.d;
import com.tencent.mm.g.b.a.ij.e;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.l;
import java.lang.ref.WeakReference;
import java.util.Locale;

public final class ac
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37109);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ag(paramLayoutInflater, 2131493448);
        ((View)localObject).setTag(new ac.d().G((View)localObject, true));
      }
      AppMethodBeat.o(37109);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final bo parambo, String paramString)
    {
      AppMethodBeat.i(37110);
      this.HNS = parama1;
      final ac.d locald = (ac.d)parama;
      parama = (com.tencent.mm.ui.chatting.c.b.k)parama1.bf(com.tencent.mm.ui.chatting.c.b.k.class);
      parama.bC(parambo);
      parama.bD(parambo);
      parama.bE(parambo);
      parama = parambo.field_content;
      bj localbj;
      Object localObject;
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
          localObject = com.tencent.mm.pluginsdk.model.app.h.fA(parama.appId, parama.aBM);
          if (localObject != null) {
            b(parama1, parama, parambo);
          }
          if ((parama.eSb != null) && (parama.eSb.length() != 0)) {
            break label896;
          }
          locald.IiR.setVisibility(8);
          label201:
          WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).Ka(parama.hke);
          locald.IiU.setVisibility(0);
          locald.IiL.setVisibility(8);
          locald.IiX.setVisibility(0);
          locald.IiV.setVisibility(8);
          if (localWxaAttributes == null) {
            break label925;
          }
          paramString = localWxaAttributes.field_nickname;
          label270:
          locald.Ijk.setText(paramString);
          if (localWxaAttributes == null) {
            break label934;
          }
          paramString = localWxaAttributes.field_smallHeadURL;
          label292:
          o.aFB().a(paramString, locald.Ijj, ac.d.fvC);
          locald.Ijm.setVisibility(0);
          locald.ImD.setVisibility(8);
          locald.ImD.setText(parama.description);
          locald.Ijq.setText(parama.title);
          switch (parama.hkq)
          {
          default: 
            locald.Ijl.setText(2131755401);
            label387:
            o.aFB().a(paramString, locald.Ijj, ac.d.fvC);
            if (!parama1.foQ()) {
              if (com.tencent.mm.pluginsdk.model.app.h.k((com.tencent.mm.pluginsdk.model.app.g)localObject))
              {
                locald.IiT.setVisibility(0);
                c(parama1, locald.IiT, bj.a(parama, parambo));
              }
            }
            break;
          }
        }
      }
      for (;;)
      {
        parambo = o.aFx().b(parambo.field_imgPath, false, true);
        locald.Ijn.setImageBitmap(null);
        locald.Ijn.setVisibility(4);
        locald.Ijp.setVisibility(0);
        com.tencent.mm.modelappbrand.a.b.aAS().a(new b.k()
        {
          public final String Ap()
          {
            AppMethodBeat.i(37107);
            String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
            AppMethodBeat.o(37107);
            return str;
          }
          
          public final void E(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(37106);
            if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
            {
              locald.Ijn.setImageBitmap(paramAnonymousBitmap);
              locald.Ijn.setVisibility(0);
              locald.Ijp.setVisibility(4);
              AppMethodBeat.o(37106);
              return;
            }
            locald.Ijn.setVisibility(4);
            locald.Ijp.setVisibility(0);
            AppMethodBeat.o(37106);
          }
          
          public final void aBa() {}
          
          public final void of() {}
        }, "file://".concat(String.valueOf(parambo)), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(240, 192));
        locald.ImL.setVisibility(8);
        locald.ImL.setTag(bs.bG(parama.hkk, ""));
        locald.ImM.setVisibility(8);
        parambo = (com.tencent.mm.ah.a)parama.ao(com.tencent.mm.ah.a.class);
        if ((parambo != null) && (parambo.hfQ))
        {
          paramString = parama.hkk;
          localObject = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).ze(paramString);
          ac.a(parama1, locald, parambo, (com.tencent.mm.ah.a.c)localObject);
          ac.a(parama1, locald, parambo, parama, (com.tencent.mm.ah.a.c)localObject);
          int i = parambo.hfX;
          paramInt = i;
          if (localObject != null)
          {
            paramInt = i;
            if (((com.tencent.mm.ah.a.c)localObject).field_updatePeroid != 0) {
              paramInt = ((com.tencent.mm.ah.a.c)localObject).field_updatePeroid;
            }
          }
          if (paramInt > 0) {
            ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).a(ac.e.cE(parama1), parama.hkf, paramString, paramInt, new m.a()
            {
              public final void a(String paramAnonymousString, dlc paramAnonymousdlc)
              {
                AppMethodBeat.i(37108);
                com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymousdlc.content });
                if (locald.ImL == null)
                {
                  com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "viewHolder.appbrandUpdateTv is null, return");
                  AppMethodBeat.o(37108);
                  return;
                }
                String str = (String)locald.ImL.getTag();
                if (bs.isNullOrNil(str))
                {
                  com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "oriShareKey is null, return");
                  AppMethodBeat.o(37108);
                  return;
                }
                if (str.equals(paramAnonymousString))
                {
                  locald.ImL.setVisibility(0);
                  locald.ImL.setText(paramAnonymousdlc.content);
                  locald.ImL.setTextColor(bs.cG(paramAnonymousdlc.FHy, locald.ImL.getCurrentTextColor()));
                  if (paramAnonymousdlc.state == 1)
                  {
                    paramAnonymousString = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).ze(paramAnonymousString);
                    if ((paramAnonymousString != null) && (paramAnonymousString.field_btnState == 1))
                    {
                      if (bs.isNullOrNil(parambo.hfW))
                      {
                        locald.ImM.setVisibility(8);
                        AppMethodBeat.o(37108);
                        return;
                      }
                      locald.ImM.setVisibility(0);
                      locald.ImM.setText(parambo.hfW);
                    }
                  }
                }
                AppMethodBeat.o(37108);
              }
            });
          }
        }
        ((q)com.tencent.mm.kernel.g.ab(q.class)).Iz(parama.hke);
        locald.nDl.setTag(localbj);
        locald.nDl.setOnClickListener(d(parama1));
        paramString = y.ayq().F(ac.e.cE(parama1), true);
        parambo = (ac.c)paramString.get("listener", null);
        parama = parambo;
        if (parambo == null)
        {
          parama = new ac.c();
          paramString.l("listener", parama);
        }
        parama.n(parama1);
        if (this.opt)
        {
          locald.nDl.setOnLongClickListener(c(parama1));
          locald.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
        }
        AppMethodBeat.o(37110);
        return;
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambo.field_msgId), paramString });
        parama = null;
        break;
        label896:
        locald.IiR.setVisibility(0);
        b(parama1, locald.IiR, bj.aQO(parama.eSb));
        break label201;
        label925:
        paramString = parama.dvm;
        break label270;
        label934:
        paramString = parama.hks;
        break label292;
        locald.Ijl.setText(2131755657);
        break label387;
        locald.Ijl.setText(2131755656);
        break label387;
        locald.IiT.setVisibility(8);
        continue;
        locald.IiT.setVisibility(8);
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(37111);
      int i = ((bj)paramView.getTag()).position;
      k.b localb = k.b.vA(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
      Object localObject;
      if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.k(localb.appId, false, false))) && (!j.aU(parambo)))
      {
        if (localb.type != 6) {
          break label264;
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
        if (!this.HNS.foR()) {
          paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
        }
        AppMethodBeat.o(37111);
        return true;
        label264:
        paramContextMenu.add(i, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37112);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37112);
        return false;
      }
      e.b.a(parama, parambo, b(parama, parambo));
      AppMethodBeat.o(37112);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37113);
      com.tencent.mm.modelstat.a.a(parambo, a.a.hUB);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
      if (parambo.field_content == null)
      {
        AppMethodBeat.o(37113);
        return false;
      }
      paramView = k.b.vA(bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
      if (paramView == null)
      {
        AppMethodBeat.o(37113);
        return false;
      }
      Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.k(paramView.appId, false, false);
      if (localObject1 != null) {
        a(parama, paramView, d(parama, parambo), (com.tencent.mm.pluginsdk.model.app.g)localObject1, parambo.field_msgSvrId, parama.getTalkerUserName());
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramView.hke, paramView.hkd, paramView.hkf, paramView.url, Integer.valueOf(paramView.hkq), paramView.hkh });
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
        ((ut)localObject1).dxt.dxB.ccc = parama.getTalkerUserName();
        ((ut)localObject1).dxt.dxB.ccd = paramView.hkk;
        localObject2 = paramView.hkj;
        if (!parama.foQ()) {
          break label423;
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
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        ac.a(parama, paramView);
        AppMethodBeat.o(37113);
        return true;
        bool = false;
        break;
        label423:
        ((ut)localObject1).dxt.scene = 1007;
        parambo = new StringBuilder(b(parama, parambo));
        parambo.append(":");
        parambo.append((String)localObject2);
      }
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 587202609);
    }
    
    public final boolean fqu()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37117);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ag(paramLayoutInflater, 2131493492);
        ((View)localObject).setTag(new ac.d().G((View)localObject, false));
      }
      AppMethodBeat.o(37117);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37122);
      if (parambo.cKN())
      {
        com.tencent.mm.pluginsdk.model.app.m.aD(parambo);
        bi.pK(parambo.field_msgId);
        parama.xg(true);
        AppMethodBeat.o(37122);
        return;
      }
      AppMethodBeat.o(37122);
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(37118);
      final ac.d locald = (ac.d)parama;
      this.HNS = parama1;
      paramString = (com.tencent.mm.ui.chatting.c.b.k)parama1.bf(com.tencent.mm.ui.chatting.c.b.k.class);
      paramString.bE(parambo);
      Object localObject1 = parambo.field_content;
      paramString.bC(parambo);
      if (localObject1 != null) {}
      label270:
      label796:
      label806:
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
            break label796;
          }
          localObject1 = ((WxaAttributes)localObject2).field_nickname;
          if (localObject2 == null) {
            break label806;
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
            o.aFB().a((String)localObject2, locald.Ijj, ac.d.fvC);
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
        label342:
        label883:
        for (;;)
        {
          boolean bool = false;
          for (localObject1 = this;; localObject1 = this)
          {
            ((b)localObject1).b(parama, bool);
            parama = o.aFx().b(parambo.field_imgPath, false, true);
            locald.Ijn.setImageBitmap(null);
            locald.Ijn.setVisibility(4);
            locald.Ijp.setVisibility(0);
            com.tencent.mm.modelappbrand.a.b.aAS().a(new b.k()
            {
              public final String Ap()
              {
                AppMethodBeat.i(37115);
                String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
                AppMethodBeat.o(37115);
                return str;
              }
              
              public final void E(Bitmap paramAnonymousBitmap)
              {
                AppMethodBeat.i(37114);
                if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
                {
                  locald.Ijn.setImageBitmap(paramAnonymousBitmap);
                  locald.Ijn.setVisibility(0);
                  locald.Ijp.setVisibility(4);
                  AppMethodBeat.o(37114);
                  return;
                }
                locald.Ijn.setVisibility(4);
                locald.Ijp.setVisibility(0);
                AppMethodBeat.o(37114);
              }
              
              public final void aBa() {}
              
              public final void of() {}
            }, "file://".concat(String.valueOf(parama)), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).dc(240, 192));
            locald.ImL.setVisibility(8);
            locald.ImL.setTag(bs.bG(paramString.hkk, ""));
            locald.ImM.setVisibility(8);
            parama = (com.tencent.mm.ah.a)paramString.ao(com.tencent.mm.ah.a.class);
            if ((parama != null) && (parama.hfQ))
            {
              localObject1 = paramString.hkk;
              localObject2 = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).ze((String)localObject1);
              ac.a(parama1, locald, parama, (com.tencent.mm.ah.a.c)localObject2);
              ac.a(parama1, locald, parama, paramString, (com.tencent.mm.ah.a.c)localObject2);
              int j = parama.hfX;
              int i = j;
              if (localObject2 != null)
              {
                i = j;
                if (((com.tencent.mm.ah.a.c)localObject2).field_updatePeroid != 0) {
                  i = ((com.tencent.mm.ah.a.c)localObject2).field_updatePeroid;
                }
              }
              if (i > 0) {
                ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).a(ac.e.cE(parama1), paramString.hkf, (String)localObject1, i, new m.a()
                {
                  public final void a(String paramAnonymousString, dlc paramAnonymousdlc)
                  {
                    AppMethodBeat.i(37116);
                    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymousdlc.content });
                    if (locald.ImL == null)
                    {
                      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "viewHolder.appbrandUpdateTv is null, return");
                      AppMethodBeat.o(37116);
                      return;
                    }
                    String str = (String)locald.ImL.getTag();
                    if (bs.isNullOrNil(str))
                    {
                      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "oriShareKey is null, return");
                      AppMethodBeat.o(37116);
                      return;
                    }
                    if (str.equals(paramAnonymousString))
                    {
                      locald.ImL.setVisibility(0);
                      locald.ImL.setText(paramAnonymousdlc.content);
                      locald.ImL.setTextColor(bs.cG(paramAnonymousdlc.FHy, locald.ImL.getCurrentTextColor()));
                      if (paramAnonymousdlc.state == 1)
                      {
                        paramAnonymousString = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).ze(paramAnonymousString);
                        if ((paramAnonymousString != null) && (paramAnonymousString.field_btnState == 1))
                        {
                          if (bs.isNullOrNil(parama.hfW))
                          {
                            locald.ImM.setVisibility(8);
                            AppMethodBeat.o(37116);
                            return;
                          }
                          locald.ImM.setVisibility(0);
                          locald.ImM.setText(parama.hfW);
                        }
                      }
                    }
                    AppMethodBeat.o(37116);
                  }
                });
              }
            }
            ((q)com.tencent.mm.kernel.g.ab(q.class)).Iz(paramString.hke);
            locald.nDl.setTag(localbj);
            locald.nDl.setOnClickListener(d(parama1));
            localObject1 = y.ayq().F(ac.e.cE(parama1), true);
            paramString = (ac.c)((y.b)localObject1).get("listener", null);
            parama = paramString;
            if (paramString == null)
            {
              parama = new ac.c();
              ((y.b)localObject1).l("listener", parama);
            }
            parama.n(parama1);
            if (this.opt)
            {
              locald.nDl.setOnLongClickListener(c(parama1));
              locald.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
            }
            a(paramInt, locald, parambo, parama1.foM(), parama1.foQ(), parama1, this);
            AppMethodBeat.o(37118);
            return;
            localObject1 = paramString.dvm;
            break;
            localObject2 = paramString.hks;
            break label176;
            locald.Ijl.setText(2131755657);
            break label270;
            locald.Ijl.setText(2131755656);
            break label270;
            if (locald.Ijf == null) {
              break label342;
            }
            locald.Ijf.setVisibility(8);
            break label342;
            if (parambo.field_status >= 2) {
              break label883;
            }
            bool = true;
          }
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(37119);
      int i = ((bj)paramView.getTag()).position;
      if (parambo.field_content == null)
      {
        AppMethodBeat.o(37119);
        return true;
      }
      k.b localb = k.b.vA(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
      if (localb == null)
      {
        AppMethodBeat.o(37119);
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
      AppMethodBeat.o(37119);
      return true;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37120);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37120);
        return false;
      case 111: 
        e.b.a(parama, parambo, b(parama, parambo));
        AppMethodBeat.o(37120);
        return false;
      }
      paramMenuItem = parambo.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37120);
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
        AppMethodBeat.o(37120);
        return false;
        parama = new jl();
        parama.dkU.dkV = paramMenuItem.dkV;
        parama.dkU.dbz = parambo.field_msgId;
        parama.dkU.dkW = parambo.field_talker;
        com.tencent.mm.sdk.b.a.GpY.l(parama);
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37121);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
      paramView.getTag();
      paramView = parambo.field_content;
      if (paramView == null)
      {
        AppMethodBeat.o(37121);
        return false;
      }
      paramView = k.b.vA(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(37121);
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
          break label359;
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
        ac.a(parama, paramView);
        AppMethodBeat.o(37121);
        return true;
        bool = false;
        break;
        label359:
        ((ut)localObject1).dxt.scene = 1007;
        parambo = new StringBuilder(b(parama, parambo));
        parambo.append(":");
        parambo.append((String)localObject2);
      }
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 587202609);
    }
    
    public final boolean fqu()
    {
      return true;
    }
  }
  
  static final class c
    implements l
  {
    private WeakReference<com.tencent.mm.ui.chatting.d.a> nBR;
    
    public final void fgg() {}
    
    public final void fgh() {}
    
    public final void fgi() {}
    
    public final void fgj()
    {
      AppMethodBeat.i(37124);
      ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).aAG();
      AppMethodBeat.o(37124);
    }
    
    public final void fgk()
    {
      AppMethodBeat.i(37125);
      ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).aAH();
      AppMethodBeat.o(37125);
    }
    
    public final void fgl()
    {
      AppMethodBeat.i(37126);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
      if (this.nBR == null)
      {
        AppMethodBeat.o(37126);
        return;
      }
      com.tencent.mm.ui.chatting.d.a locala = (com.tencent.mm.ui.chatting.d.a)this.nBR.get();
      if (locala != null)
      {
        y.ayq().xI(ac.e.cE(locala));
        ((com.tencent.mm.ui.chatting.c.b.h)locala.bf(com.tencent.mm.ui.chatting.c.b.h.class)).b(this);
        ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).zf(ac.e.cE(locala));
      }
      AppMethodBeat.o(37126);
    }
    
    public final void fgm() {}
    
    final void n(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(37123);
      this.nBR = new WeakReference(parama);
      ((com.tencent.mm.ui.chatting.c.b.h)parama.bf(com.tencent.mm.ui.chatting.c.b.h.class)).a(this);
      AppMethodBeat.o(37123);
    }
  }
  
  static final class d
    extends c.a
  {
    public static final int ImB;
    public static final int ImC;
    static com.tencent.mm.av.a.a.c fvC;
    protected ImageView IiL;
    protected ImageView IiO;
    protected ImageView IiP;
    protected TextView IiR;
    protected ChattingItemFooter IiS;
    protected ImageView IiT;
    protected LinearLayout IiU;
    protected ViewGroup IiV;
    protected TextView IiW;
    protected LinearLayout IiX;
    ImageView Ijf;
    protected ImageView Ijj;
    protected TextView Ijk;
    protected TextView Ijl;
    protected LinearLayout Ijm;
    protected ImageView Ijn;
    protected ImageView Ijp;
    protected TextView Ijq;
    protected TextView ImD;
    protected TextView ImL;
    protected TextView ImM;
    
    static
    {
      AppMethodBeat.i(37128);
      ImB = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 240);
      ImC = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 192);
      com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
      locala.hKI = 2131689599;
      locala.de(com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 20), com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 20)).hKv = true;
      fvC = locala.aFT();
      AppMethodBeat.o(37128);
    }
    
    public final d G(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37127);
      super.fX(paramView);
      this.IiL = ((ImageView)paramView.findViewById(2131298045));
      this.IiO = ((ImageView)this.sSS.findViewById(2131298078));
      this.IiP = ((ImageView)this.sSS.findViewById(2131298177));
      this.IiR = ((TextView)paramView.findViewById(2131298023));
      this.IiT = ((ImageView)paramView.findViewById(2131298039));
      this.ijt = ((CheckBox)paramView.findViewById(2131298068));
      this.gGk = paramView.findViewById(2131298147);
      this.xpH = ((TextView)paramView.findViewById(2131298185));
      this.IiS = ((ChattingItemFooter)paramView.findViewById(2131300196));
      this.IiU = ((LinearLayout)paramView.findViewById(2131296863));
      this.IiV = ((ViewGroup)paramView.findViewById(2131301542));
      this.IiW = ((TextView)paramView.findViewById(2131301539));
      this.IiX = ((LinearLayout)paramView.findViewById(2131298053));
      this.nDl = paramView.findViewById(2131298069);
      if (!paramBoolean)
      {
        this.Ijf = ((ImageView)this.sSS.findViewById(2131298176));
        this.vYf = ((ProgressBar)this.sSS.findViewById(2131306220));
      }
      this.Ijm = ((LinearLayout)paramView.findViewById(2131298005));
      this.Ijn = ((ImageView)paramView.findViewById(2131298006));
      this.Ijp = ((ImageView)paramView.findViewById(2131299519));
      this.Ijq = ((TextView)paramView.findViewById(2131298016));
      this.ImD = ((TextView)paramView.findViewById(2131298007));
      this.ImL = ((TextView)paramView.findViewById(2131298022));
      this.Ijj = ((ImageView)paramView.findViewById(2131298018));
      this.Ijk = ((TextView)paramView.findViewById(2131298020));
      this.Ijl = ((TextView)paramView.findViewById(2131298019));
      this.ImM = ((TextView)paramView.findViewById(2131298021));
      AppMethodBeat.o(37127);
      return this;
    }
  }
  
  static final class e
  {
    static String cE(Object paramObject)
    {
      AppMethodBeat.i(37129);
      paramObject = "WxaUpdatableMsg#" + com.tencent.mm.plugin.appbrand.z.m.cE(paramObject);
      AppMethodBeat.o(37129);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac
 * JD-Core Version:    0.7.0.1
 */