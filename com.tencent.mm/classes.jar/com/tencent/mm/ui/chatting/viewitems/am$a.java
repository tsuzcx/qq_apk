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
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.b.d;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.i;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.a.xw.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.m.a;
import com.tencent.mm.modelstat.a.a;
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
import java.util.Locale;

public final class am$a
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
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
      localObject = new aq(paramLayoutInflater, R.i.edg);
      ((View)localObject).setTag(new am.d().W((View)localObject, true));
    }
    AppMethodBeat.o(37109);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, String paramString)
  {
    AppMethodBeat.i(37110);
    this.WBq = parama1;
    final am.d locald = (am.d)parama;
    parama = (com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class);
    parama.cr(paramca);
    parama.cs(paramca);
    parama.ct(paramca);
    parama = paramca.field_content;
    by localby;
    Object localObject;
    if (parama != null)
    {
      parama = k.b.aG(parama, paramca.field_reserved);
      localby = new by(paramca, parama1.hRi(), paramInt, null, '\000');
      if (parama != null)
      {
        locald.Xds.setVisibility(8);
        locald.Xdr.setVisibility(8);
        locald.XdP.setVisibility(8);
        parama.ar(com.tencent.mm.aj.h.class);
        locald.clickArea.setBackgroundResource(R.g.chatto_bg_app);
        localObject = com.tencent.mm.pluginsdk.model.app.h.hn(parama.appId, parama.appVersion);
        if (localObject != null) {
          b(parama1, parama, paramca);
        }
        if ((parama.ilh != null) && (parama.ilh.length() != 0)) {
          break label888;
        }
        locald.Xdu.setVisibility(8);
        label192:
        WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(parama.loA);
        locald.Xdx.setVisibility(0);
        locald.Xdo.setVisibility(8);
        locald.XdA.setVisibility(0);
        locald.Xdy.setVisibility(8);
        if (localWxaAttributes == null) {
          break label917;
        }
        paramString = localWxaAttributes.field_nickname;
        label261:
        locald.XdN.setText(paramString);
        if (localWxaAttributes == null) {
          break label926;
        }
        paramString = localWxaAttributes.field_smallHeadURL;
        label283:
        com.tencent.mm.ay.q.bml().a(paramString, locald.XdM, am.d.jak);
        locald.XdP.setVisibility(0);
        locald.XhN.setVisibility(8);
        locald.XhN.setText(parama.description);
        locald.XdT.setText(parama.title);
        switch (parama.loT)
        {
        default: 
          locald.XdO.setText(R.l.app_brand_entrance);
          label379:
          com.tencent.mm.ay.q.bml().a(paramString, locald.XdM, am.d.jak);
          if (!parama1.hRi()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k((g)localObject))
            {
              locald.Xdw.setVisibility(0);
              c(parama1, locald.Xdw, by.a(parama, paramca));
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      paramca = com.tencent.mm.ay.q.bmh().d(paramca.field_imgPath, false, true);
      locald.XdQ.setImageBitmap(null);
      locald.XdQ.setVisibility(4);
      locald.XdS.setVisibility(0);
      com.tencent.mm.modelappbrand.a.b.bhh().a(new b.k()
      {
        public final void G(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(37106);
          if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()))
          {
            locald.XdQ.setImageBitmap(paramAnonymousBitmap);
            locald.XdQ.setVisibility(0);
            locald.XdS.setVisibility(4);
            AppMethodBeat.o(37106);
            return;
          }
          locald.XdQ.setVisibility(4);
          locald.XdS.setVisibility(0);
          AppMethodBeat.o(37106);
        }
        
        public final void bhq() {}
        
        public final void bhr() {}
        
        public final String key()
        {
          AppMethodBeat.i(37107);
          String str = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", new Object[] { Integer.valueOf(240), Integer.valueOf(192) });
          AppMethodBeat.o(37107);
          return str;
        }
      }, "file://".concat(String.valueOf(paramca)), null, ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).dK(240, 192));
      locald.XhV.setVisibility(8);
      locald.XhV.setTag(Util.nullAs(parama.loG, ""));
      locald.XhW.setVisibility(8);
      paramca = (com.tencent.mm.aj.a)parama.ar(com.tencent.mm.aj.a.class);
      if ((paramca != null) && (paramca.lkc))
      {
        paramString = parama.loG;
        localObject = ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.m.class)).SJ(paramString);
        am.a(parama1, locald, paramca, (d)localObject);
        am.a(parama1, locald, paramca, parama, (d)localObject);
        int i = paramca.lkj;
        paramInt = i;
        if (localObject != null)
        {
          paramInt = i;
          if (((d)localObject).field_updatePeroid != 0) {
            paramInt = ((d)localObject).field_updatePeroid;
          }
        }
        if (paramInt > 0) {
          ((com.tencent.mm.modelappbrand.m)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.m.class)).a(am.e.cP(parama1), parama.loB, paramString, paramInt, new m.a()
          {
            public final void a(String paramAnonymousString, evu paramAnonymousevu)
            {
              AppMethodBeat.i(37108);
              Log.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymousevu.content });
              if (locald.XhV == null)
              {
                Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "viewHolder.appbrandUpdateTv is null, return");
                AppMethodBeat.o(37108);
                return;
              }
              String str = (String)locald.XhV.getTag();
              if (Util.isNullOrNil(str))
              {
                Log.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "oriShareKey is null, return");
                AppMethodBeat.o(37108);
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
                    if (Util.isNullOrNil(paramca.lki))
                    {
                      locald.XhW.setVisibility(8);
                      AppMethodBeat.o(37108);
                      return;
                    }
                    locald.XhW.setVisibility(0);
                    locald.XhW.setText(paramca.lki);
                  }
                }
              }
              AppMethodBeat.o(37108);
            }
          });
        }
      }
      ((w)com.tencent.mm.kernel.h.ae(w.class)).adj(parama.loA);
      locald.clickArea.setTag(localby);
      locald.clickArea.setOnClickListener(d(parama1));
      paramString = ad.beh().I(am.e.cP(parama1), true);
      paramca = (am.c)paramString.get("listener", null);
      parama = paramca;
      if (paramca == null)
      {
        parama = new am.c();
        paramString.k("listener", parama);
      }
      parama.n(parama1);
      if (this.tMW)
      {
        locald.clickArea.setOnLongClickListener(c(parama1));
        locald.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
      }
      AppMethodBeat.o(37110);
      return;
      Log.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramca.field_msgId), paramString });
      parama = null;
      break;
      label888:
      locald.Xdu.setVisibility(0);
      b(parama1, locald.Xdu, by.bzO(parama.ilh));
      break label192;
      label917:
      paramString = parama.fUe;
      break label261;
      label926:
      paramString = parama.loV;
      break label283;
      locald.XdO.setText(R.l.app_brand_share_wxa_testing_tag);
      break label379;
      locald.XdO.setText(R.l.app_brand_share_wxa_preview_tag);
      break label379;
      locald.Xdw.setVisibility(8);
      continue;
      locald.Xdw.setVisibility(8);
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37112);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37112);
      return false;
    }
    e.b.a(parama, paramca, a(parama, paramca));
    AppMethodBeat.o(37112);
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(200022);
    int i = ((by)paramView.getTag()).position;
    k.b localb = k.b.OQ(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
    Object localObject;
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false))) && (!com.tencent.mm.ui.chatting.k.bF(paramca)))
    {
      if (localb.type != 6) {
        break label264;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.m.bqf(localb.fvr);
      if (((localObject == null) || (!e.b.j(paramca, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))) && (!paramca.Ic())) {
        paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
    }
    for (;;)
    {
      localObject = new em();
      ((em)localObject).fAp.msgId = paramca.field_msgId;
      EventCenter.instance.publish((IEvent)localObject);
      if ((((em)localObject).fAq.fzO) || (e.b.a(this.WBq.WQv.getContext(), localb))) {
        paramo.a(i, 129, paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
      }
      if (!this.WBq.hRj()) {
        paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
      }
      AppMethodBeat.o(200022);
      return true;
      label264:
      paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 587202609);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37113);
    com.tencent.mm.modelstat.a.a(paramca, a.a.mcb);
    ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
    if (paramca.field_content == null)
    {
      AppMethodBeat.o(37113);
      return false;
    }
    paramView = k.b.OQ(bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
    if (paramView == null)
    {
      AppMethodBeat.o(37113);
      return false;
    }
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.o(paramView.appId, false, false);
    if (localObject1 != null) {
      a(parama, paramView, d(parama, paramca), (g)localObject1, paramca.field_msgSvrId, parama.getTalkerUserName());
    }
    Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramView.loA, paramView.loz, paramView.loB, paramView.url, Integer.valueOf(paramView.loT), paramView.loD });
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
      ((xw)localObject1).fWN.fWW.cwT = parama.getTalkerUserName();
      ((xw)localObject1).fWN.fWW.cwU = paramView.loG;
      localObject2 = paramView.loF;
      if (!parama.hRi()) {
        break label429;
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
      am.c((xw)localObject1, paramView);
      EventCenter.instance.publish((IEvent)localObject1);
      am.a(parama, paramView);
      AppMethodBeat.o(37113);
      return true;
      bool = false;
      break;
      label429:
      ((xw)localObject1).fWN.scene = 1007;
      paramca = new StringBuilder(a(parama, paramca));
      paramca.append(":");
      paramca.append((String)localObject2);
    }
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.a
 * JD-Core Version:    0.7.0.1
 */