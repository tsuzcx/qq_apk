package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.a.zp.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.af.p;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.o;
import com.tencent.mm.ui.chatting.m;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class ak$a
  extends c
  implements i
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private aa roa;
  
  public ak$a()
  {
    AppMethodBeat.i(37084);
    this.roa = new ab(this);
    AppMethodBeat.o(37084);
  }
  
  public final void S(View paramView, int paramInt)
  {
    AppMethodBeat.i(37090);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof ak.d))
    {
      AppMethodBeat.o(37090);
      return;
    }
    Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
    paramView = (ak.d)localObject;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      paramView.uiD.jFf();
      paramView.uiD.setVisibility(4);
      paramView.aeRV.setVisibility(4);
      paramView.coverIv.setVisibility(0);
      paramView.coverIv.setImageResource(R.k.app_brand_share_page_cover_default);
      AppMethodBeat.o(37090);
      return;
    case 0: 
      paramView.uiD.setVisibility(0);
      paramView.uiD.jFe();
      paramView.coverIv.setVisibility(4);
      paramView.aeRV.setVisibility(4);
      AppMethodBeat.o(37090);
      return;
    case 1: 
      paramView.uiD.jFf();
      paramView.uiD.setVisibility(4);
      paramView.aeRV.setVisibility(4);
      paramView.coverIv.setVisibility(0);
      paramView.coverIv.setImageResource(R.k.dynamic_page_res_not_found);
      AppMethodBeat.o(37090);
      return;
    }
    paramView.uiD.jFf();
    paramView.uiD.setVisibility(4);
    paramView.aeRV.setVisibility(0);
    paramView.coverIv.setVisibility(4);
    AppMethodBeat.o(37090);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37085);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.gfW);
      paramLayoutInflater = new ak.d().ab((View)localObject, true);
      paramView = ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).dM(((View)localObject).getContext());
      paramLayoutInflater.aeRV = paramView;
      if (paramView != null) {
        paramLayoutInflater.aeRU.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      }
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37085);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37086);
    this.aeiK = parama1;
    ak.d locald = (ak.d)parama;
    Object localObject1 = paramcc.field_content;
    Object localObject2 = (o)parama1.cm(o.class);
    ((o)localObject2).cN(paramcc);
    ((o)localObject2).cO(paramcc);
    ((o)localObject2).cP(paramcc);
    com.tencent.mm.ui.chatting.component.c.c(parama1, parama.convertView, paramcc);
    Log.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", new Object[] { paramString });
    label225:
    WxaAttributes localWxaAttributes;
    if (localObject1 != null)
    {
      parama = k.b.aP((String)localObject1, paramcc.field_reserved);
      localObject2 = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
      if (parama != null)
      {
        locald.aeNq.setVisibility(8);
        locald.aeNp.setVisibility(8);
        locald.aeNN.setVisibility(8);
        parama.aK(com.tencent.mm.message.h.class);
        locald.clickArea.setBackgroundResource(R.g.chatto_bg_app);
        g localg = com.tencent.mm.pluginsdk.model.app.h.is(parama.appId, parama.appVersion);
        if (localg != null) {
          b(parama1, parama, paramcc);
        }
        if ((parama.kLg != null) && (parama.kLg.length() != 0)) {
          break label823;
        }
        locald.aeNs.setVisibility(8);
        localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(parama.nTD);
        locald.aeNv.setVisibility(0);
        locald.aeNm.setVisibility(8);
        locald.aeNy.setVisibility(0);
        locald.aeNw.setVisibility(8);
        if (localWxaAttributes == null) {
          break label852;
        }
        paramString = localWxaAttributes.field_nickname;
        label295:
        if (localWxaAttributes == null) {
          break label861;
        }
        localObject1 = localWxaAttributes.field_smallHeadURL;
        label307:
        locald.aeNN.setVisibility(0);
        locald.aeRT.setVisibility(8);
        locald.aeNR.setText(parama.title);
        locald.aeRT.setText(parama.description);
        locald.aeNL.setText(paramString);
        switch (parama.nTW)
        {
        default: 
          locald.aeNM.setText(R.l.app_brand_entrance);
          label399:
          r.bKe().a((String)localObject1, locald.aeNK, ak.d.lCf);
          if (!parama1.juG()) {
            if (com.tencent.mm.pluginsdk.model.app.h.k(localg))
            {
              locald.aeNu.setVisibility(0);
              c(parama1, locald.aeNu, bz.a(parama, paramcc));
              label454:
              localObject1 = (com.tencent.mm.message.a)parama.aK(com.tencent.mm.message.a.class);
              paramString = new Bundle();
              paramString.putString("app_id", parama.nTE);
              paramString.putString("msg_id", paramcc.field_msgId);
              if (localObject1 == null) {
                break label924;
              }
              paramcc = ((com.tencent.mm.message.a)localObject1).nOL;
              label525:
              paramString.putString("cache_key", paramcc);
              paramString.putString("msg_title", parama.title);
              paramString.putString("msg_path", parama.nTC);
              paramString.putInt("msg_pkg_type", parama.nTW);
              paramString.putInt("pkg_version", parama.appVersion);
              paramString.putInt("widget_type", 0);
              if (!parama1.juG()) {
                break label930;
              }
            }
          }
          break;
        }
      }
    }
    label924:
    label930:
    for (paramInt = 1008;; paramInt = 1007)
    {
      paramString.putInt("scene", paramInt);
      paramString.putInt("view_init_width", ak.d.aeRR);
      paramString.putInt("view_init_height", ak.d.aeRS);
      locald.aeRV.setTag(locald);
      ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).a(p.el(parama1), locald.aeRV, paramString, this.roa);
      b.a(parama.nTD, localWxaAttributes, parama);
      locald.clickArea.setTag(localObject2);
      locald.clickArea.setOnClickListener(d(parama1));
      paramString = ad.bCb().M(p.el(parama1), true);
      paramcc = (ak.c)paramString.get("listener", null);
      parama = paramcc;
      if (paramcc == null)
      {
        parama = new ak.c();
        paramString.q("listener", parama);
      }
      parama.n(parama1);
      if (this.wQm) {
        locald.clickArea.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(37086);
      return;
      Log.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramcc.field_msgId), paramString });
      parama = null;
      break;
      label823:
      locald.aeNs.setVisibility(0);
      b(parama1, locald.aeNs, bz.bBE(parama.kLg));
      break label225;
      label852:
      paramString = parama.iab;
      break label295;
      label861:
      localObject1 = parama.nTY;
      break label307;
      locald.aeNM.setText(R.l.app_brand_share_wxa_testing_tag);
      break label399;
      locald.aeNM.setText(R.l.app_brand_share_wxa_preview_tag);
      break label399;
      locald.aeNu.setVisibility(8);
      break label454;
      locald.aeNu.setVisibility(8);
      break label454;
      paramcc = null;
      break label525;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37088);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37088);
      return false;
    case 111: 
      e.b.a(parama, paramcc, a(parama, paramcc));
      AppMethodBeat.o(37088);
      return false;
    case 133: 
      Object localObject = paramcc.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = k.b.Hf((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37088);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.nTE);
      ((Bundle)localObject).putString("msg_id", paramcc.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.nTW);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.nTH);
      ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEJ().e(parama.aezO.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37088);
      return false;
    }
    ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEJ().dN(parama.aezO.getContext());
    AppMethodBeat.o(37088);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255602);
    int i = ((bz)paramView.getTag()).position;
    paramContextMenuInfo = k.b.Hf(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
    Object localObject;
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.s(paramContextMenuInfo.appId, false, false))) && (!m.bR(paramcc)) && (!bt.Q(paramcc)))
    {
      if (paramContextMenuInfo.type != 6) {
        break label372;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.n.bpU(paramContextMenuInfo.hzM);
      if (((localObject == null) || (!e.b.j(paramcc, ((com.tencent.mm.pluginsdk.model.app.c)localObject).field_fileFullPath))) && (!paramcc.isClean())) {
        params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
    }
    for (;;)
    {
      localObject = new ex();
      ((ex)localObject).hFc.msgId = paramcc.field_msgId;
      ((ex)localObject).publish();
      if ((((ex)localObject).hFd.hEn) || (e.b.a(this.aeiK.aezO.getContext(), paramContextMenuInfo))) {
        params.a(i, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
      }
      if (bt.F(paramcc)) {
        params.clear();
      }
      if (!this.aeiK.juH()) {
        params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
      }
      paramView = ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEJ();
      if ((paramView.bEO()) || (paramView.vK(paramContextMenuInfo.nTW)))
      {
        params.add(i, 133, 0, this.aeiK.aezO.getMMResources().getString(R.l.gyx));
        params.add(i, 132, 0, this.aeiK.aezO.getMMResources().getString(R.l.gyw));
      }
      AppMethodBeat.o(255602);
      return true;
      label372:
      params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37089);
    com.tencent.mm.modelstat.a.a(paramcc, a.a.oUW);
    ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    if (paramcc.field_content == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    Object localObject2 = k.b.Hf(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
    if (localObject2 == null)
    {
      AppMethodBeat.o(37089);
      return false;
    }
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.s(((k.b)localObject2).appId, false, false);
    if (localObject1 != null) {
      a(parama, (k.b)localObject2, d(parama, paramcc), (g)localObject1, paramcc.field_msgSvrId, parama.getTalkerUserName());
    }
    Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((k.b)localObject2).nTD, ((k.b)localObject2).nTC, ((k.b)localObject2).nTE, ((k.b)localObject2).url, Integer.valueOf(((k.b)localObject2).nTW), ((k.b)localObject2).nTG });
    localObject1 = new zp();
    ((zp)localObject1).icM.appId = ((k.b)localObject2).nTE;
    ((zp)localObject1).icM.userName = ((k.b)localObject2).nTD;
    ((zp)localObject1).icM.icO = ((k.b)localObject2).nTC;
    ((zp)localObject1).icM.icP = ((k.b)localObject2).nTW;
    ((zp)localObject1).icM.icS = ((k.b)localObject2).nTG;
    ((zp)localObject1).icM.appVersion = ((k.b)localObject2).nTX;
    Object localObject3 = ((zp)localObject1).icM;
    boolean bool;
    if (((k.b)localObject2).nTW != 0)
    {
      bool = true;
      ((zp.a)localObject3).icT = bool;
      ((zp)localObject1).icM.icV.eoT = parama.getTalkerUserName();
      ((zp)localObject1).icM.icV.eoU = ((k.b)localObject2).nTJ;
      localObject2 = ((k.b)localObject2).nTI;
      if (!parama.juG()) {
        break label439;
      }
      ((zp)localObject1).icM.scene = 1008;
      localObject3 = new StringBuilder(parama.getTalkerUserName());
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append(a(parama, paramcc));
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append((String)localObject2);
    }
    for (((zp)localObject1).icM.hzx = ((StringBuilder)localObject3).toString();; ((zp)localObject1).icM.hzx = ((StringBuilder)localObject3).toString())
    {
      ((zp)localObject1).publish();
      com.tencent.mm.ui.chatting.component.c.d(parama, paramView, paramcc);
      AppMethodBeat.o(37089);
      return true;
      bool = false;
      break;
      label439:
      ((zp)localObject1).icM.scene = 1007;
      localObject3 = new StringBuilder(a(parama, paramcc));
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append((String)localObject2);
    }
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean fXn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.a
 * JD-Core Version:    0.7.0.1
 */