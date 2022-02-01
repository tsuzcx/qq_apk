package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.a.ju;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.a.vq.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.drq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.n;
import java.util.Locale;

public final class ad$b
  extends c
  implements t.n
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
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
      ((View)localObject).setTag(new ad.d().M((View)localObject, false));
    }
    AppMethodBeat.o(37117);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37122);
    if (parambv.cVH())
    {
      com.tencent.mm.pluginsdk.model.app.m.aF(parambv);
      bl.rW(parambv.field_msgId);
      parama.xY(true);
      AppMethodBeat.o(37122);
      return;
    }
    AppMethodBeat.o(37122);
  }
  
  public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37118);
    final ad.d locald = (ad.d)parama;
    this.JWz = parama1;
    paramString = (com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class);
    paramString.bJ(parambv);
    Object localObject1 = parambv.field_content;
    paramString.bH(parambv);
    if (localObject1 != null) {}
    label270:
    label796:
    label806:
    for (paramString = k.b.aB((String)localObject1, parambv.field_reserved);; paramString = null)
    {
      bk localbk = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
      Object localObject2;
      if (paramString != null)
      {
        locald.KvG.setVisibility(8);
        locald.KvF.setVisibility(8);
        locald.KvC.setVisibility(8);
        locald.Kwd.setVisibility(8);
        localObject2 = ((o)com.tencent.mm.kernel.g.ab(o.class)).Ob(paramString.hFc);
        if (localObject2 == null) {
          break label796;
        }
        localObject1 = ((WxaAttributes)localObject2).field_nickname;
        if (localObject2 == null) {
          break label806;
        }
        localObject2 = ((WxaAttributes)localObject2).field_smallHeadURL;
        label176:
        locald.Kwd.setVisibility(0);
        locald.Kzt.setVisibility(8);
        locald.Kwh.setText(paramString.title);
        locald.Kzt.setText(paramString.description);
        locald.Kwb.setText((CharSequence)localObject1);
        switch (paramString.hFr)
        {
        default: 
          locald.Kwc.setText(2131755401);
          q.aJb().a((String)localObject2, locald.Kwa, ad.d.fQP);
          if (fLB())
          {
            localObject1 = (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class);
            if ((parambv.field_status == 2) && (b((com.tencent.mm.ui.chatting.d.b.k)localObject1, parambv.field_msgId))) {
              if (locald.KvW != null) {
                locald.KvW.setVisibility(0);
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
          parama = q.aIX().c(parambv.field_imgPath, false, true);
          locald.Kwe.setImageBitmap(null);
          locald.Kwe.setVisibility(4);
          locald.Kwg.setVisibility(0);
          com.tencent.mm.modelappbrand.a.b.aEl().a(new b.k()
          {
            public final String BN()
            {
              AppMethodBeat.i(37115);
              String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
              AppMethodBeat.o(37115);
              return str;
            }
            
            public final void F(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(37114);
              if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
              {
                locald.Kwe.setImageBitmap(paramAnonymousBitmap);
                locald.Kwe.setVisibility(0);
                locald.Kwg.setVisibility(4);
                AppMethodBeat.o(37114);
                return;
              }
              locald.Kwe.setVisibility(4);
              locald.Kwg.setVisibility(0);
              AppMethodBeat.o(37114);
            }
            
            public final void aEt() {}
            
            public final void ox() {}
          }, "file://".concat(String.valueOf(parama)), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).de(240, 192));
          locald.KzB.setVisibility(8);
          locald.KzB.setTag(bu.bI(paramString.hFi, ""));
          locald.KzC.setVisibility(8);
          parama = (com.tencent.mm.ah.a)paramString.ao(com.tencent.mm.ah.a.class);
          if ((parama != null) && (parama.hAM))
          {
            localObject1 = paramString.hFi;
            localObject2 = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).CF((String)localObject1);
            ad.a(parama1, locald, parama, (com.tencent.mm.ah.a.c)localObject2);
            ad.a(parama1, locald, parama, paramString, (com.tencent.mm.ah.a.c)localObject2);
            int j = parama.hAT;
            int i = j;
            if (localObject2 != null)
            {
              i = j;
              if (((com.tencent.mm.ah.a.c)localObject2).field_updatePeroid != 0) {
                i = ((com.tencent.mm.ah.a.c)localObject2).field_updatePeroid;
              }
            }
            if (i > 0) {
              ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.m.class)).a(ad.e.cH(parama1), paramString.hFd, (String)localObject1, i, new m.a()
              {
                public final void a(String paramAnonymousString, drq paramAnonymousdrq)
                {
                  AppMethodBeat.i(37116);
                  ae.d("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymousdrq.content });
                  if (locald.KzB == null)
                  {
                    ae.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "viewHolder.appbrandUpdateTv is null, return");
                    AppMethodBeat.o(37116);
                    return;
                  }
                  String str = (String)locald.KzB.getTag();
                  if (bu.isNullOrNil(str))
                  {
                    ae.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "oriShareKey is null, return");
                    AppMethodBeat.o(37116);
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
                        if (bu.isNullOrNil(parama.hAS))
                        {
                          locald.KzC.setVisibility(8);
                          AppMethodBeat.o(37116);
                          return;
                        }
                        locald.KzC.setVisibility(0);
                        locald.KzC.setText(parama.hAS);
                      }
                    }
                  }
                  AppMethodBeat.o(37116);
                }
              });
            }
          }
          ((s)com.tencent.mm.kernel.g.ab(s.class)).Mt(paramString.hFc);
          locald.olI.setTag(localbk);
          locald.olI.setOnClickListener(d(parama1));
          localObject1 = z.aBG().F(ad.e.cH(parama1), true);
          paramString = (ad.c)((z.b)localObject1).get("listener", null);
          parama = paramString;
          if (paramString == null)
          {
            parama = new ad.c();
            ((z.b)localObject1).k("listener", parama);
          }
          parama.n(parama1);
          if (this.oZq)
          {
            locald.olI.setOnLongClickListener(c(parama1));
            locald.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          }
          a(paramInt, locald, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
          AppMethodBeat.o(37118);
          return;
          localObject1 = paramString.dIu;
          break;
          localObject2 = paramString.hFt;
          break label176;
          locald.Kwc.setText(2131755657);
          break label270;
          locald.Kwc.setText(2131755656);
          break label270;
          if (locald.KvW == null) {
            break label342;
          }
          locald.KvW.setVisibility(8);
          break label342;
          if (parambv.field_status >= 2) {
            break label883;
          }
          bool = true;
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37120);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37120);
      return false;
    case 111: 
      e.b.a(parama, parambv, b(parama, parambv));
      AppMethodBeat.o(37120);
      return false;
    }
    paramMenuItem = parambv.field_content;
    if (paramMenuItem == null)
    {
      AppMethodBeat.o(37120);
      return false;
    }
    paramMenuItem = k.b.zb(paramMenuItem);
    if (paramMenuItem != null) {
      switch (paramMenuItem.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37120);
      return false;
      parama = new ju();
      parama.dxM.dxN = paramMenuItem.dxN;
      parama.dxM.dnX = parambv.field_msgId;
      parama.dxM.dxO = parambv.field_talker;
      com.tencent.mm.sdk.b.a.IvT.l(parama);
    }
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187815);
    int i = ((bk)paramView.getTag()).position;
    if (parambv.field_content == null)
    {
      AppMethodBeat.o(187815);
      return true;
    }
    k.b localb = k.b.zb(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(187815);
      return true;
    }
    if ((h.l(h.m(localb.appId, false, false))) && (!com.tencent.mm.ui.chatting.k.aW(parambv))) {
      paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
    }
    if (((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker))) {
      paraml.a(i, 123, paramView.getContext().getString(2131757234), 2131690462);
    }
    ec localec = new ec();
    localec.dql.msgId = parambv.field_msgId;
    com.tencent.mm.sdk.b.a.IvT.l(localec);
    if ((localec.dqm.dpK) || (e.b.a(this.JWz.Kkd.getContext(), localb))) {
      paraml.a(i, 129, paramView.getContext().getString(2131757228), 2131691577);
    }
    if (!this.JWz.fJD()) {
      paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(187815);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37121);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
    paramView.getTag();
    paramView = parambv.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(37121);
      return false;
    }
    paramView = k.b.zb(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(37121);
      return false;
    }
    Object localObject1 = h.m(paramView.appId, true, false);
    if ((localObject1 != null) && (!bu.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId))) {
      a(parama, paramView, v.aAC(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, parambv.field_msgSvrId, parama.getTalkerUserName());
    }
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
      localObject2 = paramView.hFh;
      if (!parama.fJC()) {
        break label365;
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
      ((vq)localObject1).dKT.dLc.cmv = parama.getTalkerUserName();
      ((vq)localObject1).dKT.dLc.cmw = paramView.hFi;
      ad.c((vq)localObject1, paramView);
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      ad.a(parama, paramView);
      AppMethodBeat.o(37121);
      return true;
      bool = false;
      break;
      label365:
      ((vq)localObject1).dKT.scene = 1007;
      parambv = new StringBuilder(b(parama, parambv));
      parambv.append(":");
      parambv.append((String)localObject2);
    }
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 587202609);
  }
  
  public final boolean fLz()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.b
 * JD-Core Version:    0.7.0.1
 */