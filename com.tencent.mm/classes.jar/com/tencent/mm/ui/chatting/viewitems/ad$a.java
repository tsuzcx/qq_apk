package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.protocal.protobuf.drq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.Locale;

public final class ad$a
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
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
      ((View)localObject).setTag(new ad.d().M((View)localObject, true));
    }
    AppMethodBeat.o(37109);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final bv parambv, String paramString)
  {
    AppMethodBeat.i(37110);
    this.JWz = parama1;
    final ad.d locald = (ad.d)parama;
    parama = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
    parama.bH(parambv);
    parama.bI(parambv);
    parama.bJ(parambv);
    parama = parambv.field_content;
    bk localbk;
    Object localObject;
    if (parama != null)
    {
      parama = k.b.aB(parama, parambv.field_reserved);
      localbk = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
      if (parama != null)
      {
        locald.KvG.setVisibility(8);
        locald.KvF.setVisibility(8);
        locald.Kwd.setVisibility(8);
        parama.ao(com.tencent.mm.ah.h.class);
        locald.olI.setBackgroundResource(2131231727);
        localObject = com.tencent.mm.pluginsdk.model.app.h.gg(parama.appId, parama.aDD);
        if (localObject != null) {
          b(parama1, parama, parambv);
        }
        if ((parama.fmn != null) && (parama.fmn.length() != 0)) {
          break label887;
        }
        locald.KvI.setVisibility(8);
        label191:
        WxaAttributes localWxaAttributes = ((o)com.tencent.mm.kernel.g.ab(o.class)).Ob(parama.hFc);
        locald.KvL.setVisibility(0);
        locald.KvC.setVisibility(8);
        locald.KvO.setVisibility(0);
        locald.KvM.setVisibility(8);
        if (localWxaAttributes == null) {
          break label916;
        }
        paramString = localWxaAttributes.field_nickname;
        label260:
        locald.Kwb.setText(paramString);
        if (localWxaAttributes == null) {
          break label925;
        }
        paramString = localWxaAttributes.field_smallHeadURL;
        label282:
        q.aJb().a(paramString, locald.Kwa, ad.d.fQP);
        locald.Kwd.setVisibility(0);
        locald.Kzt.setVisibility(8);
        locald.Kzt.setText(parama.description);
        locald.Kwh.setText(parama.title);
        switch (parama.hFr)
        {
        default: 
          locald.Kwc.setText(2131755401);
          label378:
          q.aJb().a(paramString, locald.Kwa, ad.d.fQP);
          if (!parama1.fJC()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k((com.tencent.mm.pluginsdk.model.app.g)localObject))
            {
              locald.KvK.setVisibility(0);
              c(parama1, locald.KvK, bk.a(parama, parambv));
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      parambv = q.aIX().c(parambv.field_imgPath, false, true);
      locald.Kwe.setImageBitmap(null);
      locald.Kwe.setVisibility(4);
      locald.Kwg.setVisibility(0);
      com.tencent.mm.modelappbrand.a.b.aEl().a(new b.k()
      {
        public final String BN()
        {
          AppMethodBeat.i(37107);
          String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
          AppMethodBeat.o(37107);
          return str;
        }
        
        public final void F(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(37106);
          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
          {
            locald.Kwe.setImageBitmap(paramAnonymousBitmap);
            locald.Kwe.setVisibility(0);
            locald.Kwg.setVisibility(4);
            AppMethodBeat.o(37106);
            return;
          }
          locald.Kwe.setVisibility(4);
          locald.Kwg.setVisibility(0);
          AppMethodBeat.o(37106);
        }
        
        public final void aEt() {}
        
        public final void ox() {}
      }, "file://".concat(String.valueOf(parambv)), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(240, 192));
      locald.KzB.setVisibility(8);
      locald.KzB.setTag(bu.bI(parama.hFi, ""));
      locald.KzC.setVisibility(8);
      parambv = (com.tencent.mm.ah.a)parama.ao(com.tencent.mm.ah.a.class);
      if ((parambv != null) && (parambv.hAM))
      {
        paramString = parama.hFi;
        localObject = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).CF(paramString);
        ad.a(parama1, locald, parambv, (com.tencent.mm.ah.a.c)localObject);
        ad.a(parama1, locald, parambv, parama, (com.tencent.mm.ah.a.c)localObject);
        int i = parambv.hAT;
        paramInt = i;
        if (localObject != null)
        {
          paramInt = i;
          if (((com.tencent.mm.ah.a.c)localObject).field_updatePeroid != 0) {
            paramInt = ((com.tencent.mm.ah.a.c)localObject).field_updatePeroid;
          }
        }
        if (paramInt > 0) {
          ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).a(ad.e.cH(parama1), parama.hFd, paramString, paramInt, new m.a()
          {
            public final void a(String paramAnonymousString, drq paramAnonymousdrq)
            {
              AppMethodBeat.i(37108);
              ae.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymousdrq.content });
              if (locald.KzB == null)
              {
                ae.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "viewHolder.appbrandUpdateTv is null, return");
                AppMethodBeat.o(37108);
                return;
              }
              String str = (String)locald.KzB.getTag();
              if (bu.isNullOrNil(str))
              {
                ae.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "oriShareKey is null, return");
                AppMethodBeat.o(37108);
                return;
              }
              if (str.equals(paramAnonymousString))
              {
                locald.KzB.setVisibility(0);
                locald.KzB.setText(paramAnonymousdrq.content);
                locald.KzB.setTextColor(bu.cN(paramAnonymousdrq.HLI, locald.KzB.getCurrentTextColor()));
                if (paramAnonymousdrq.state == 1)
                {
                  paramAnonymousString = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).CF(paramAnonymousString);
                  if ((paramAnonymousString != null) && (paramAnonymousString.field_btnState == 1))
                  {
                    if (bu.isNullOrNil(parambv.hAS))
                    {
                      locald.KzC.setVisibility(8);
                      AppMethodBeat.o(37108);
                      return;
                    }
                    locald.KzC.setVisibility(0);
                    locald.KzC.setText(parambv.hAS);
                  }
                }
              }
              AppMethodBeat.o(37108);
            }
          });
        }
      }
      ((s)com.tencent.mm.kernel.g.ab(s.class)).Mt(parama.hFc);
      locald.olI.setTag(localbk);
      locald.olI.setOnClickListener(d(parama1));
      paramString = z.aBG().F(ad.e.cH(parama1), true);
      parambv = (ad.c)paramString.get("listener", null);
      parama = parambv;
      if (parambv == null)
      {
        parama = new ad.c();
        paramString.k("listener", parama);
      }
      parama.n(parama1);
      if (this.oZq)
      {
        locald.olI.setOnLongClickListener(c(parama1));
        locald.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
      }
      AppMethodBeat.o(37110);
      return;
      ae.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambv.field_msgId), paramString });
      parama = null;
      break;
      label887:
      locald.KvI.setVisibility(0);
      b(parama1, locald.KvI, bk.aYj(parama.fmn));
      break label191;
      label916:
      paramString = parama.dIu;
      break label260;
      label925:
      paramString = parama.hFt;
      break label282;
      locald.Kwc.setText(2131755657);
      break label378;
      locald.Kwc.setText(2131755656);
      break label378;
      locald.KvK.setVisibility(8);
      continue;
      locald.KvK.setVisibility(8);
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37112);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37112);
      return false;
    }
    e.b.a(parama, parambv, b(parama, parambv));
    AppMethodBeat.o(37112);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187814);
    int i = ((bk)paramView.getTag()).position;
    k.b localb = k.b.zb(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
    Object localObject;
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.m(localb.appId, false, false))) && (!com.tencent.mm.ui.chatting.k.aW(parambv)))
    {
      if (localb.type != 6) {
        break label264;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.m.aNj(localb.dlu);
      if (((localObject == null) || (!e.b.f(parambv, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))) && (!parambv.fvU())) {
        paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
      }
    }
    for (;;)
    {
      localObject = new ec();
      ((ec)localObject).dql.msgId = parambv.field_msgId;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if ((((ec)localObject).dqm.dpK) || (e.b.a(this.JWz.Kkd.getContext(), localb))) {
        paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
      }
      if (!this.JWz.fJD()) {
        paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
      }
      AppMethodBeat.o(187814);
      return true;
      label264:
      paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37113);
    com.tencent.mm.modelstat.a.a(parambv, a.a.iqQ);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
    if (parambv.field_content == null)
    {
      AppMethodBeat.o(37113);
      return false;
    }
    paramView = k.b.zb(bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
    if (paramView == null)
    {
      AppMethodBeat.o(37113);
      return false;
    }
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.m(paramView.appId, false, false);
    if (localObject1 != null) {
      a(parama, paramView, d(parama, parambv), (com.tencent.mm.pluginsdk.model.app.g)localObject1, parambv.field_msgSvrId, parama.getTalkerUserName());
    }
    ae.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramView.hFc, paramView.hFb, paramView.hFd, paramView.url, Integer.valueOf(paramView.hFr), paramView.hFf });
    localObject1 = new vq();
    ((vq)localObject1).dKT.appId = paramView.hFd;
    ((vq)localObject1).dKT.userName = paramView.hFc;
    ((vq)localObject1).dKT.dKV = paramView.hFb;
    ((vq)localObject1).dKT.dKW = paramView.hFr;
    ((vq)localObject1).dKT.dKZ = paramView.hFf;
    ((vq)localObject1).dKT.aDD = paramView.hFs;
    Object localObject2 = ((vq)localObject1).dKT;
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramView.hFr != 0)
    {
      bool = true;
      ((vq.a)localObject2).dLa = bool;
      ((vq)localObject1).dKT.dLc.cmv = parama.getTalkerUserName();
      ((vq)localObject1).dKT.dLc.cmw = paramView.hFi;
      localObject2 = paramView.hFh;
      if (!parama.fJC()) {
        break label429;
      }
      ((vq)localObject1).dKT.scene = 1008;
      localStringBuilder = new StringBuilder(parama.getTalkerUserName());
      localStringBuilder.append(":");
      localStringBuilder.append(b(parama, parambv));
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject2);
    }
    for (((vq)localObject1).dKT.dlj = localStringBuilder.toString();; ((vq)localObject1).dKT.dlj = parambv.toString())
    {
      ad.c((vq)localObject1, paramView);
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      ad.a(parama, paramView);
      AppMethodBeat.o(37113);
      return true;
      bool = false;
      break;
      label429:
      ((vq)localObject1).dKT.scene = 1007;
      parambv = new StringBuilder(b(parama, parambv));
      parambv.append(":");
      parambv.append((String)localObject2);
    }
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 587202609);
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.a
 * JD-Core Version:    0.7.0.1
 */