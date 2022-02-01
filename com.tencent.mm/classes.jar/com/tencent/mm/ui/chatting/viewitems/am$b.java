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
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.b.d;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.i;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.a.la;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.a.xw.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.evu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.n;
import java.util.Locale;

public final class am$b
  extends c
  implements t.n
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
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
      localObject = new aq(paramLayoutInflater, R.i.eeg);
      ((View)localObject).setTag(new am.d().W((View)localObject, false));
    }
    AppMethodBeat.o(37117);
    return localObject;
  }
  
  public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37118);
    final am.d locald = (am.d)parama;
    this.WBq = parama1;
    paramString = (com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class);
    paramString.ct(paramca);
    Object localObject1 = paramca.field_content;
    paramString.cr(paramca);
    if (localObject1 != null) {}
    label271:
    label797:
    label807:
    for (paramString = k.b.aG((String)localObject1, paramca.field_reserved);; paramString = null)
    {
      by localby = new by(paramca, parama1.hRi(), paramInt, null, '\000');
      Object localObject2;
      if (paramString != null)
      {
        locald.Xds.setVisibility(8);
        locald.Xdr.setVisibility(8);
        locald.Xdo.setVisibility(8);
        locald.XdP.setVisibility(8);
        localObject2 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(paramString.loA);
        if (localObject2 == null) {
          break label797;
        }
        localObject1 = ((WxaAttributes)localObject2).field_nickname;
        if (localObject2 == null) {
          break label807;
        }
        localObject2 = ((WxaAttributes)localObject2).field_smallHeadURL;
        label176:
        locald.XdP.setVisibility(0);
        locald.XhN.setVisibility(8);
        locald.XdT.setText(paramString.title);
        locald.XhN.setText(paramString.description);
        locald.XdN.setText((CharSequence)localObject1);
        switch (paramString.loT)
        {
        default: 
          locald.XdO.setText(R.l.app_brand_entrance);
          com.tencent.mm.ay.q.bml().a((String)localObject2, locald.XdM, am.d.jak);
          if (hTG())
          {
            localObject1 = (com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class);
            if ((paramca.field_status == 2) && (b((com.tencent.mm.ui.chatting.d.b.k)localObject1, paramca.field_msgId))) {
              if (locald.XdI != null) {
                locald.XdI.setVisibility(0);
              }
            }
          }
          break;
        }
      }
      label343:
      label884:
      for (;;)
      {
        boolean bool = false;
        for (localObject1 = this;; localObject1 = this)
        {
          ((b)localObject1).b(parama, bool);
          parama = com.tencent.mm.ay.q.bmh().d(paramca.field_imgPath, false, true);
          locald.XdQ.setImageBitmap(null);
          locald.XdQ.setVisibility(4);
          locald.XdS.setVisibility(0);
          com.tencent.mm.modelappbrand.a.b.bhh().a(new b.k()
          {
            public final void G(Bitmap paramAnonymousBitmap)
            {
              AppMethodBeat.i(37114);
              if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
              {
                locald.XdQ.setImageBitmap(paramAnonymousBitmap);
                locald.XdQ.setVisibility(0);
                locald.XdS.setVisibility(4);
                AppMethodBeat.o(37114);
                return;
              }
              locald.XdQ.setVisibility(4);
              locald.XdS.setVisibility(0);
              AppMethodBeat.o(37114);
            }
            
            public final void bhq() {}
            
            public final void bhr() {}
            
            public final String key()
            {
              AppMethodBeat.i(37115);
              String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
              AppMethodBeat.o(37115);
              return str;
            }
          }, "file://".concat(String.valueOf(parama)), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).dK(240, 192));
          locald.XhV.setVisibility(8);
          locald.XhV.setTag(Util.nullAs(paramString.loG, ""));
          locald.XhW.setVisibility(8);
          parama = (com.tencent.mm.aj.a)paramString.ar(com.tencent.mm.aj.a.class);
          if ((parama != null) && (parama.lkc))
          {
            localObject1 = paramString.loG;
            localObject2 = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.m.class)).SJ((String)localObject1);
            am.a(parama1, locald, parama, (d)localObject2);
            am.a(parama1, locald, parama, paramString, (d)localObject2);
            int j = parama.lkj;
            int i = j;
            if (localObject2 != null)
            {
              i = j;
              if (((d)localObject2).field_updatePeroid != 0) {
                i = ((d)localObject2).field_updatePeroid;
              }
            }
            if (i > 0) {
              ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.m.class)).a(am.e.cP(parama1), paramString.loB, (String)localObject1, i, new m.a()
              {
                public final void a(String paramAnonymousString, evu paramAnonymousevu)
                {
                  AppMethodBeat.i(37116);
                  Log.d("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymousevu.content });
                  if (locald.XhV == null)
                  {
                    Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "viewHolder.appbrandUpdateTv is null, return");
                    AppMethodBeat.o(37116);
                    return;
                  }
                  String str = (String)locald.XhV.getTag();
                  if (Util.isNullOrNil(str))
                  {
                    Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "oriShareKey is null, return");
                    AppMethodBeat.o(37116);
                    return;
                  }
                  if (str.equals(paramAnonymousString))
                  {
                    locald.XhV.setVisibility(0);
                    locald.XhV.setText(paramAnonymousevu.content);
                    locald.XhV.setTextColor(Util.convertStringToRGB(paramAnonymousevu.UjM, locald.XhV.getCurrentTextColor()));
                    if (paramAnonymousevu.state == 1)
                    {
                      paramAnonymousString = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.m.class)).SJ(paramAnonymousString);
                      if ((paramAnonymousString != null) && (paramAnonymousString.field_btnState == 1))
                      {
                        if (Util.isNullOrNil(parama.lki))
                        {
                          locald.XhW.setVisibility(8);
                          AppMethodBeat.o(37116);
                          return;
                        }
                        locald.XhW.setVisibility(0);
                        locald.XhW.setText(parama.lki);
                      }
                    }
                  }
                  AppMethodBeat.o(37116);
                }
              });
            }
          }
          ((w)com.tencent.mm.kernel.h.ae(w.class)).adj(paramString.loA);
          locald.clickArea.setTag(localby);
          locald.clickArea.setOnClickListener(d(parama1));
          localObject1 = ad.beh().I(am.e.cP(parama1), true);
          paramString = (am.c)((ad.b)localObject1).get("listener", null);
          parama = paramString;
          if (paramString == null)
          {
            parama = new am.c();
            ((ad.b)localObject1).k("listener", parama);
          }
          parama.n(parama1);
          if (this.tMW)
          {
            locald.clickArea.setOnLongClickListener(c(parama1));
            locald.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
          }
          a(paramInt, locald, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
          AppMethodBeat.o(37118);
          return;
          localObject1 = paramString.fUe;
          break;
          localObject2 = paramString.loV;
          break label176;
          locald.XdO.setText(R.l.app_brand_share_wxa_testing_tag);
          break label271;
          locald.XdO.setText(R.l.app_brand_share_wxa_preview_tag);
          break label271;
          if (locald.XdI == null) {
            break label343;
          }
          locald.XdI.setVisibility(8);
          break label343;
          if (paramca.field_status >= 2) {
            break label884;
          }
          bool = true;
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37120);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37120);
      return false;
    case 111: 
      e.b.a(parama, paramca, a(parama, paramca));
      AppMethodBeat.o(37120);
      return false;
    }
    paramMenuItem = paramca.field_content;
    if (paramMenuItem == null)
    {
      AppMethodBeat.o(37120);
      return false;
    }
    paramMenuItem = k.b.OQ(paramMenuItem);
    if (paramMenuItem != null) {
      switch (paramMenuItem.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37120);
      return false;
      parama = new la();
      parama.fIH.fII = paramMenuItem.fII;
      parama.fIH.fxU = paramca.field_msgId;
      parama.fIH.fIJ = paramca.field_talker;
      EventCenter.instance.publish(parama);
    }
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(268708);
    int i = ((by)paramView.getTag()).position;
    if (paramca.field_content == null)
    {
      AppMethodBeat.o(268708);
      return true;
    }
    k.b localb = k.b.OQ(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(268708);
      return true;
    }
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false))) && (!com.tencent.mm.ui.chatting.k.bF(paramca))) {
      paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if (((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker))) {
      paramo.a(i, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
    }
    em localem = new em();
    localem.fAp.msgId = paramca.field_msgId;
    EventCenter.instance.publish(localem);
    if ((localem.fAq.fzO) || (e.b.a(this.WBq.WQv.getContext(), localb))) {
      paramo.a(i, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
    }
    if (!this.WBq.hRj()) {
      paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(268708);
    return true;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(268711);
    if (paramca.erk())
    {
      com.tencent.mm.pluginsdk.model.app.m.bh(paramca);
      bq.Gk(paramca.field_msgId);
      parama.Gi(true);
      AppMethodBeat.o(268711);
      return;
    }
    AppMethodBeat.o(268711);
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 587202609);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37121);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
    paramView.getTag();
    paramView = paramca.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(37121);
      return false;
    }
    paramView = k.b.OQ(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(37121);
      return false;
    }
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.o(paramView.appId, true, false);
    if ((localObject1 != null) && (!Util.isNullOrNil(((g)localObject1).field_appId))) {
      a(parama, paramView, z.bcZ(), (g)localObject1, paramca.field_msgSvrId, parama.getTalkerUserName());
    }
    localObject1 = new xw();
    ((xw)localObject1).fWN.appId = paramView.loB;
    ((xw)localObject1).fWN.userName = paramView.loA;
    ((xw)localObject1).fWN.fWP = paramView.loz;
    ((xw)localObject1).fWN.fWQ = paramView.loT;
    ((xw)localObject1).fWN.fWT = paramView.loD;
    ((xw)localObject1).fWN.appVersion = paramView.loU;
    Object localObject2 = ((xw)localObject1).fWN;
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramView.loT != 0)
    {
      bool = true;
      ((xw.a)localObject2).fWU = bool;
      localObject2 = paramView.loF;
      if (!parama.hRi()) {
        break label365;
      }
      ((xw)localObject1).fWN.scene = 1008;
      localStringBuilder = new StringBuilder(parama.getTalkerUserName());
      localStringBuilder.append(":");
      localStringBuilder.append(a(parama, paramca));
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject2);
    }
    for (((xw)localObject1).fWN.fvd = localStringBuilder.toString();; ((xw)localObject1).fWN.fvd = paramca.toString())
    {
      ((xw)localObject1).fWN.fWW.cwT = parama.getTalkerUserName();
      ((xw)localObject1).fWN.fWW.cwU = paramView.loG;
      am.c((xw)localObject1, paramView);
      EventCenter.instance.publish((IEvent)localObject1);
      am.a(parama, paramView);
      AppMethodBeat.o(37121);
      return true;
      bool = false;
      break;
      label365:
      ((xw)localObject1).fWN.scene = 1007;
      paramca = new StringBuilder(a(parama, paramca));
      paramca.append(":");
      paramca.append((String)localObject2);
    }
  }
  
  public final boolean hTD()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.b
 * JD-Core Version:    0.7.0.1
 */