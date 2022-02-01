package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.i;
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.vm.a;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.g.b.a.jo.a;
import com.tencent.mm.g.b.a.jo.b;
import com.tencent.mm.g.b.a.jo.c;
import com.tencent.mm.g.b.a.jo.d;
import com.tencent.mm.g.b.a.jo.e;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.protocal.protobuf.dqt;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.n;
import java.lang.ref.WeakReference;
import java.util.Locale;

public final class ad
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    
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
        localObject = new ah(paramLayoutInflater, 2131493448);
        ((View)localObject).setTag(new ad.d().H((View)localObject, true));
      }
      AppMethodBeat.o(37109);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final bu parambu, String paramString)
    {
      AppMethodBeat.i(37110);
      this.JBI = parama1;
      final ad.d locald = (ad.d)parama;
      parama = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
      parama.bI(parambu);
      parama.bJ(parambu);
      parama.bK(parambu);
      parama = parambu.field_content;
      bk localbk;
      Object localObject;
      if (parama != null)
      {
        parama = k.b.aA(parama, parambu.field_reserved);
        localbk = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
        if (parama != null)
        {
          locald.JZn.setVisibility(8);
          locald.JZm.setVisibility(8);
          locald.JZK.setVisibility(8);
          parama.ao(com.tencent.mm.ai.h.class);
          locald.ofK.setBackgroundResource(2131231727);
          localObject = com.tencent.mm.pluginsdk.model.app.h.fX(parama.appId, parama.aDD);
          if (localObject != null) {
            b(parama1, parama, parambu);
          }
          if ((parama.fkq != null) && (parama.fkq.length() != 0)) {
            break label887;
          }
          locald.JZp.setVisibility(8);
          label191:
          WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(parama.hCn);
          locald.JZs.setVisibility(0);
          locald.JZj.setVisibility(8);
          locald.JZv.setVisibility(0);
          locald.JZt.setVisibility(8);
          if (localWxaAttributes == null) {
            break label916;
          }
          paramString = localWxaAttributes.field_nickname;
          label260:
          locald.JZI.setText(paramString);
          if (localWxaAttributes == null) {
            break label925;
          }
          paramString = localWxaAttributes.field_smallHeadURL;
          label282:
          q.aIJ().a(paramString, locald.JZH, ad.d.fOJ);
          locald.JZK.setVisibility(0);
          locald.Kdb.setVisibility(8);
          locald.Kdb.setText(parama.description);
          locald.JZO.setText(parama.title);
          switch (parama.hCz)
          {
          default: 
            locald.JZJ.setText(2131755401);
            label378:
            q.aIJ().a(paramString, locald.JZH, ad.d.fOJ);
            if (!parama1.fFv()) {
              if (com.tencent.mm.pluginsdk.model.app.h.k((com.tencent.mm.pluginsdk.model.app.g)localObject))
              {
                locald.JZr.setVisibility(0);
                c(parama1, locald.JZr, bk.a(parama, parambu));
              }
            }
            break;
          }
        }
      }
      for (;;)
      {
        parambu = q.aIF().c(parambu.field_imgPath, false, true);
        locald.JZL.setImageBitmap(null);
        locald.JZL.setVisibility(4);
        locald.JZN.setVisibility(0);
        com.tencent.mm.modelappbrand.a.b.aDV().a(new b.k()
        {
          public final String BM()
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
              locald.JZL.setImageBitmap(paramAnonymousBitmap);
              locald.JZL.setVisibility(0);
              locald.JZN.setVisibility(4);
              AppMethodBeat.o(37106);
              return;
            }
            locald.JZL.setVisibility(4);
            locald.JZN.setVisibility(0);
            AppMethodBeat.o(37106);
          }
          
          public final void aEd() {}
          
          public final void ox() {}
        }, "file://".concat(String.valueOf(parambu)), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(240, 192));
        locald.Kdj.setVisibility(8);
        locald.Kdj.setTag(bt.bI(parama.hCt, ""));
        locald.Kdk.setVisibility(8);
        parambu = (com.tencent.mm.ai.a)parama.ao(com.tencent.mm.ai.a.class);
        if ((parambu != null) && (parambu.hxY))
        {
          paramString = parama.hCt;
          localObject = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).Cd(paramString);
          ad.a(parama1, locald, parambu, (com.tencent.mm.ai.a.c)localObject);
          ad.a(parama1, locald, parambu, parama, (com.tencent.mm.ai.a.c)localObject);
          int i = parambu.hyf;
          paramInt = i;
          if (localObject != null)
          {
            paramInt = i;
            if (((com.tencent.mm.ai.a.c)localObject).field_updatePeroid != 0) {
              paramInt = ((com.tencent.mm.ai.a.c)localObject).field_updatePeroid;
            }
          }
          if (paramInt > 0) {
            ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).a(ad.e.cG(parama1), parama.hCo, paramString, paramInt, new m.a()
            {
              public final void a(String paramAnonymousString, dqt paramAnonymousdqt)
              {
                AppMethodBeat.i(37108);
                com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymousdqt.content });
                if (locald.Kdj == null)
                {
                  com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "viewHolder.appbrandUpdateTv is null, return");
                  AppMethodBeat.o(37108);
                  return;
                }
                String str = (String)locald.Kdj.getTag();
                if (bt.isNullOrNil(str))
                {
                  com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "oriShareKey is null, return");
                  AppMethodBeat.o(37108);
                  return;
                }
                if (str.equals(paramAnonymousString))
                {
                  locald.Kdj.setVisibility(0);
                  locald.Kdj.setText(paramAnonymousdqt.content);
                  locald.Kdj.setTextColor(bt.cJ(paramAnonymousdqt.Hsg, locald.Kdj.getCurrentTextColor()));
                  if (paramAnonymousdqt.state == 1)
                  {
                    paramAnonymousString = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).Cd(paramAnonymousString);
                    if ((paramAnonymousString != null) && (paramAnonymousString.field_btnState == 1))
                    {
                      if (bt.isNullOrNil(parambu.hye))
                      {
                        locald.Kdk.setVisibility(8);
                        AppMethodBeat.o(37108);
                        return;
                      }
                      locald.Kdk.setVisibility(0);
                      locald.Kdk.setText(parambu.hye);
                    }
                  }
                }
                AppMethodBeat.o(37108);
              }
            });
          }
        }
        ((r)com.tencent.mm.kernel.g.ab(r.class)).LQ(parama.hCn);
        locald.ofK.setTag(localbk);
        locald.ofK.setOnClickListener(d(parama1));
        paramString = y.aBq().F(ad.e.cG(parama1), true);
        parambu = (ad.c)paramString.get("listener", null);
        parama = parambu;
        if (parambu == null)
        {
          parama = new ad.c();
          paramString.k("listener", parama);
        }
        parama.n(parama1);
        if (this.oSO)
        {
          locald.ofK.setOnLongClickListener(c(parama1));
          locald.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
        }
        AppMethodBeat.o(37110);
        return;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambu.field_msgId), paramString });
        parama = null;
        break;
        label887:
        locald.JZp.setVisibility(0);
        b(parama1, locald.JZp, bk.aWI(parama.fkq));
        break label191;
        label916:
        paramString = parama.dHp;
        break label260;
        label925:
        paramString = parama.hCB;
        break label282;
        locald.JZJ.setText(2131755657);
        break label378;
        locald.JZJ.setText(2131755656);
        break label378;
        locald.JZr.setVisibility(8);
        continue;
        locald.JZr.setVisibility(8);
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37112);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37112);
        return false;
      }
      e.b.a(parama, parambu, b(parama, parambu));
      AppMethodBeat.o(37112);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194419);
      int i = ((bk)paramView.getTag()).position;
      k.b localb = k.b.yr(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
      Object localObject;
      if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.m(localb.appId, false, false))) && (!com.tencent.mm.ui.chatting.j.aX(parambu)))
      {
        if (localb.type != 6) {
          break label264;
        }
        localObject = com.tencent.mm.pluginsdk.model.app.m.aLN(localb.dks);
        if (((localObject == null) || (!e.b.e(parambu, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))) && (!parambu.frT())) {
          paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
        }
      }
      for (;;)
      {
        localObject = new eb();
        ((eb)localObject).dpg.msgId = parambu.field_msgId;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        if ((((eb)localObject).dph.doF) || (e.b.a(this.JBI.JOR.getContext(), localb))) {
          paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
        }
        if (!this.JBI.fFw()) {
          paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
        }
        AppMethodBeat.o(194419);
        return true;
        label264:
        paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37113);
      com.tencent.mm.modelstat.a.a(parambu, a.a.inW);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
      if (parambu.field_content == null)
      {
        AppMethodBeat.o(37113);
        return false;
      }
      paramView = k.b.yr(bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
      if (paramView == null)
      {
        AppMethodBeat.o(37113);
        return false;
      }
      Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.m(paramView.appId, false, false);
      if (localObject1 != null) {
        a(parama, paramView, d(parama, parambu), (com.tencent.mm.pluginsdk.model.app.g)localObject1, parambu.field_msgSvrId, parama.getTalkerUserName());
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramView.hCn, paramView.hCm, paramView.hCo, paramView.url, Integer.valueOf(paramView.hCz), paramView.hCq });
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
        ((vm)localObject1).dJF.dJN.cmt = parama.getTalkerUserName();
        ((vm)localObject1).dJF.dJN.cmu = paramView.hCt;
        localObject2 = paramView.hCs;
        if (!parama.fFv()) {
          break label429;
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
        ad.c((vm)localObject1, paramView);
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
        ad.a(parama, paramView);
        AppMethodBeat.o(37113);
        return true;
        bool = false;
        break;
        label429:
        ((vm)localObject1).dJF.scene = 1007;
        parambu = new StringBuilder(b(parama, parambu));
        parambu.append(":");
        parambu.append((String)localObject2);
      }
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 587202609);
    }
    
    public final boolean fHh()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    
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
        localObject = new ah(paramLayoutInflater, 2131493492);
        ((View)localObject).setTag(new ad.d().H((View)localObject, false));
      }
      AppMethodBeat.o(37117);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37122);
      if (parambu.cTc())
      {
        com.tencent.mm.pluginsdk.model.app.m.aG(parambu);
        bj.rJ(parambu.field_msgId);
        parama.xR(true);
        AppMethodBeat.o(37122);
        return;
      }
      AppMethodBeat.o(37122);
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
    {
      AppMethodBeat.i(37118);
      final ad.d locald = (ad.d)parama;
      this.JBI = parama1;
      paramString = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
      paramString.bK(parambu);
      Object localObject1 = parambu.field_content;
      paramString.bI(parambu);
      if (localObject1 != null) {}
      label270:
      label796:
      label806:
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
            break label796;
          }
          localObject1 = ((WxaAttributes)localObject2).field_nickname;
          if (localObject2 == null) {
            break label806;
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
            q.aIJ().a((String)localObject2, locald.JZH, ad.d.fOJ);
            if (fHj())
            {
              localObject1 = (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class);
              if ((parambu.field_status == 2) && (b((com.tencent.mm.ui.chatting.d.b.k)localObject1, parambu.field_msgId))) {
                if (locald.JZD != null) {
                  locald.JZD.setVisibility(0);
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
            parama = q.aIF().c(parambu.field_imgPath, false, true);
            locald.JZL.setImageBitmap(null);
            locald.JZL.setVisibility(4);
            locald.JZN.setVisibility(0);
            com.tencent.mm.modelappbrand.a.b.aDV().a(new b.k()
            {
              public final String BM()
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
                  locald.JZL.setImageBitmap(paramAnonymousBitmap);
                  locald.JZL.setVisibility(0);
                  locald.JZN.setVisibility(4);
                  AppMethodBeat.o(37114);
                  return;
                }
                locald.JZL.setVisibility(4);
                locald.JZN.setVisibility(0);
                AppMethodBeat.o(37114);
              }
              
              public final void aEd() {}
              
              public final void ox() {}
            }, "file://".concat(String.valueOf(parama)), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(240, 192));
            locald.Kdj.setVisibility(8);
            locald.Kdj.setTag(bt.bI(paramString.hCt, ""));
            locald.Kdk.setVisibility(8);
            parama = (com.tencent.mm.ai.a)paramString.ao(com.tencent.mm.ai.a.class);
            if ((parama != null) && (parama.hxY))
            {
              localObject1 = paramString.hCt;
              localObject2 = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).Cd((String)localObject1);
              ad.a(parama1, locald, parama, (com.tencent.mm.ai.a.c)localObject2);
              ad.a(parama1, locald, parama, paramString, (com.tencent.mm.ai.a.c)localObject2);
              int j = parama.hyf;
              int i = j;
              if (localObject2 != null)
              {
                i = j;
                if (((com.tencent.mm.ai.a.c)localObject2).field_updatePeroid != 0) {
                  i = ((com.tencent.mm.ai.a.c)localObject2).field_updatePeroid;
                }
              }
              if (i > 0) {
                ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).a(ad.e.cG(parama1), paramString.hCo, (String)localObject1, i, new m.a()
                {
                  public final void a(String paramAnonymousString, dqt paramAnonymousdqt)
                  {
                    AppMethodBeat.i(37116);
                    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymousdqt.content });
                    if (locald.Kdj == null)
                    {
                      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "viewHolder.appbrandUpdateTv is null, return");
                      AppMethodBeat.o(37116);
                      return;
                    }
                    String str = (String)locald.Kdj.getTag();
                    if (bt.isNullOrNil(str))
                    {
                      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "oriShareKey is null, return");
                      AppMethodBeat.o(37116);
                      return;
                    }
                    if (str.equals(paramAnonymousString))
                    {
                      locald.Kdj.setVisibility(0);
                      locald.Kdj.setText(paramAnonymousdqt.content);
                      locald.Kdj.setTextColor(bt.cJ(paramAnonymousdqt.Hsg, locald.Kdj.getCurrentTextColor()));
                      if (paramAnonymousdqt.state == 1)
                      {
                        paramAnonymousString = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).Cd(paramAnonymousString);
                        if ((paramAnonymousString != null) && (paramAnonymousString.field_btnState == 1))
                        {
                          if (bt.isNullOrNil(parama.hye))
                          {
                            locald.Kdk.setVisibility(8);
                            AppMethodBeat.o(37116);
                            return;
                          }
                          locald.Kdk.setVisibility(0);
                          locald.Kdk.setText(parama.hye);
                        }
                      }
                    }
                    AppMethodBeat.o(37116);
                  }
                });
              }
            }
            ((r)com.tencent.mm.kernel.g.ab(r.class)).LQ(paramString.hCn);
            locald.ofK.setTag(localbk);
            locald.ofK.setOnClickListener(d(parama1));
            localObject1 = y.aBq().F(ad.e.cG(parama1), true);
            paramString = (ad.c)((y.b)localObject1).get("listener", null);
            parama = paramString;
            if (paramString == null)
            {
              parama = new ad.c();
              ((y.b)localObject1).k("listener", parama);
            }
            parama.n(parama1);
            if (this.oSO)
            {
              locald.ofK.setOnLongClickListener(c(parama1));
              locald.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
            }
            a(paramInt, locald, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
            AppMethodBeat.o(37118);
            return;
            localObject1 = paramString.dHp;
            break;
            localObject2 = paramString.hCB;
            break label176;
            locald.JZJ.setText(2131755657);
            break label270;
            locald.JZJ.setText(2131755656);
            break label270;
            if (locald.JZD == null) {
              break label342;
            }
            locald.JZD.setVisibility(8);
            break label342;
            if (parambu.field_status >= 2) {
              break label883;
            }
            bool = true;
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37120);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37120);
        return false;
      case 111: 
        e.b.a(parama, parambu, b(parama, parambu));
        AppMethodBeat.o(37120);
        return false;
      }
      paramMenuItem = parambu.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37120);
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
        AppMethodBeat.o(37120);
        return false;
        parama = new jt();
        parama.dwH.dwI = paramMenuItem.dwI;
        parama.dwH.dmV = parambu.field_msgId;
        parama.dwH.dwJ = parambu.field_talker;
        com.tencent.mm.sdk.b.a.IbL.l(parama);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194420);
      int i = ((bk)paramView.getTag()).position;
      if (parambu.field_content == null)
      {
        AppMethodBeat.o(194420);
        return true;
      }
      k.b localb = k.b.yr(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
      if (localb == null)
      {
        AppMethodBeat.o(194420);
        return true;
      }
      if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.m(localb.appId, false, false))) && (!com.tencent.mm.ui.chatting.j.aX(parambu))) {
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
      AppMethodBeat.o(194420);
      return true;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37121);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
      paramView.getTag();
      paramView = parambu.field_content;
      if (paramView == null)
      {
        AppMethodBeat.o(37121);
        return false;
      }
      paramView = k.b.yr(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(37121);
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
          break label365;
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
        ad.c((vm)localObject1, paramView);
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
        ad.a(parama, paramView);
        AppMethodBeat.o(37121);
        return true;
        bool = false;
        break;
        label365:
        ((vm)localObject1).dJF.scene = 1007;
        parambu = new StringBuilder(b(parama, parambu));
        parambu.append(":");
        parambu.append((String)localObject2);
      }
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 587202609);
    }
    
    public final boolean fHh()
    {
      return true;
    }
  }
  
  static final class c
    implements com.tencent.mm.ui.l
  {
    private WeakReference<com.tencent.mm.ui.chatting.e.a> oeg;
    
    public final void fws() {}
    
    public final void fwt() {}
    
    public final void fwu() {}
    
    public final void fwv()
    {
      AppMethodBeat.i(37124);
      ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).aDJ();
      AppMethodBeat.o(37124);
    }
    
    public final void fww()
    {
      AppMethodBeat.i(37125);
      ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).aDK();
      AppMethodBeat.o(37125);
    }
    
    public final void fwx()
    {
      AppMethodBeat.i(37126);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingLifecycleChangedListener", "onChattingExitAnimStart, then detach DynamicPageView.");
      if (this.oeg == null)
      {
        AppMethodBeat.o(37126);
        return;
      }
      com.tencent.mm.ui.chatting.e.a locala = (com.tencent.mm.ui.chatting.e.a)this.oeg.get();
      if (locala != null)
      {
        y.aBq().AG(ad.e.cG(locala));
        ((com.tencent.mm.ui.chatting.d.b.j)locala.bh(com.tencent.mm.ui.chatting.d.b.j.class)).b(this);
        ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).Ce(ad.e.cG(locala));
      }
      AppMethodBeat.o(37126);
    }
    
    public final void fwy() {}
    
    final void n(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37123);
      this.oeg = new WeakReference(parama);
      ((com.tencent.mm.ui.chatting.d.b.j)parama.bh(com.tencent.mm.ui.chatting.d.b.j.class)).a(this);
      AppMethodBeat.o(37123);
    }
  }
  
  static final class d
    extends c.a
  {
    public static final int KcZ;
    public static final int Kda;
    static com.tencent.mm.aw.a.a.c fOJ;
    ImageView JZD;
    protected ImageView JZH;
    protected TextView JZI;
    protected TextView JZJ;
    protected LinearLayout JZK;
    protected ImageView JZL;
    protected ImageView JZN;
    protected TextView JZO;
    protected ImageView JZj;
    protected ImageView JZm;
    protected ImageView JZn;
    protected TextView JZp;
    protected ChattingItemFooter JZq;
    protected ImageView JZr;
    protected LinearLayout JZs;
    protected ViewGroup JZt;
    protected TextView JZu;
    protected LinearLayout JZv;
    protected TextView Kdb;
    protected TextView Kdj;
    protected TextView Kdk;
    
    static
    {
      AppMethodBeat.i(37128);
      KcZ = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 240);
      Kda = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 192);
      com.tencent.mm.aw.a.a.c.a locala = new com.tencent.mm.aw.a.a.c.a();
      locala.idD = 2131689599;
      locala.dh(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 20), com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 20)).idp = true;
      fOJ = locala.aJc();
      AppMethodBeat.o(37128);
    }
    
    public final d H(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37127);
      super.gn(paramView);
      this.JZj = ((ImageView)paramView.findViewById(2131298045));
      this.JZm = ((ImageView)this.tPw.findViewById(2131298078));
      this.JZn = ((ImageView)this.tPw.findViewById(2131298177));
      this.JZp = ((TextView)paramView.findViewById(2131298023));
      this.JZr = ((ImageView)paramView.findViewById(2131298039));
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.gZU = paramView.findViewById(2131298147);
      this.yEk = ((TextView)paramView.findViewById(2131298185));
      this.JZq = ((ChattingItemFooter)paramView.findViewById(2131300196));
      this.JZs = ((LinearLayout)paramView.findViewById(2131296863));
      this.JZt = ((ViewGroup)paramView.findViewById(2131301542));
      this.JZu = ((TextView)paramView.findViewById(2131301539));
      this.JZv = ((LinearLayout)paramView.findViewById(2131298053));
      this.ofK = paramView.findViewById(2131298069);
      if (!paramBoolean)
      {
        this.JZD = ((ImageView)this.tPw.findViewById(2131298176));
        this.xfR = ((ProgressBar)this.tPw.findViewById(2131306220));
      }
      this.JZK = ((LinearLayout)paramView.findViewById(2131298005));
      this.JZL = ((ImageView)paramView.findViewById(2131298006));
      this.JZN = ((ImageView)paramView.findViewById(2131299519));
      this.JZO = ((TextView)paramView.findViewById(2131298016));
      this.Kdb = ((TextView)paramView.findViewById(2131298007));
      this.Kdj = ((TextView)paramView.findViewById(2131298022));
      this.JZH = ((ImageView)paramView.findViewById(2131298018));
      this.JZI = ((TextView)paramView.findViewById(2131298020));
      this.JZJ = ((TextView)paramView.findViewById(2131298019));
      this.Kdk = ((TextView)paramView.findViewById(2131298021));
      AppMethodBeat.o(37127);
      return this;
    }
  }
  
  static final class e
  {
    static String cG(Object paramObject)
    {
      AppMethodBeat.i(37129);
      paramObject = "WxaUpdatableMsg#" + com.tencent.mm.plugin.appbrand.z.n.cG(paramObject);
      AppMethodBeat.o(37129);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad
 * JD-Core Version:    0.7.0.1
 */