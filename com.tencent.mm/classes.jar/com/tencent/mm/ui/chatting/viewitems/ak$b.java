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
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.a.me;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.a.zp.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.af.p;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.o;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class ak$b
  extends c
  implements i, v.n
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private aa roa;
  
  public ak$b()
  {
    AppMethodBeat.i(37091);
    this.roa = new ab(this);
    AppMethodBeat.o(37091);
  }
  
  public final void S(View paramView, int paramInt)
  {
    AppMethodBeat.i(37097);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof ak.d))
    {
      AppMethodBeat.o(37097);
      return;
    }
    Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
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
      AppMethodBeat.o(37097);
      return;
    case 0: 
      paramView.uiD.setVisibility(0);
      paramView.uiD.jFe();
      paramView.aeRV.setVisibility(4);
      paramView.coverIv.setVisibility(4);
      AppMethodBeat.o(37097);
      return;
    case 1: 
      paramView.uiD.jFf();
      paramView.uiD.setVisibility(4);
      paramView.aeRV.setVisibility(4);
      paramView.coverIv.setVisibility(0);
      paramView.coverIv.setImageResource(R.k.dynamic_page_res_not_found);
      AppMethodBeat.o(37097);
      return;
    }
    paramView.uiD.jFf();
    paramView.uiD.setVisibility(4);
    paramView.aeRV.setVisibility(0);
    paramView.coverIv.setVisibility(4);
    AppMethodBeat.o(37097);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37092);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ggW);
      paramLayoutInflater = new ak.d().ab((View)localObject, false);
      paramView = ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).dM(((View)localObject).getContext());
      paramLayoutInflater.aeRV = paramView;
      if (paramView != null) {
        paramLayoutInflater.aeRU.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      }
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37092);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37093);
    ak.d locald = (ak.d)parama;
    this.aeiK = parama1;
    paramString = (o)parama1.cm(o.class);
    paramString.cP(paramcc);
    com.tencent.mm.ui.chatting.component.c.c(parama1, parama.convertView, paramcc);
    Object localObject = paramcc.field_content;
    paramString.cN(paramcc);
    if (localObject != null) {}
    label279:
    label818:
    for (paramString = k.b.aP((String)localObject, paramcc.field_reserved);; paramString = null)
    {
      bz localbz = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
      WxaAttributes localWxaAttributes;
      String str;
      if (paramString != null)
      {
        locald.aeNq.setVisibility(8);
        locald.aeNp.setVisibility(8);
        locald.aeNm.setVisibility(8);
        locald.aeNN.setVisibility(8);
        localWxaAttributes = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(paramString.nTD);
        if (localWxaAttributes == null) {
          break label726;
        }
        localObject = localWxaAttributes.field_nickname;
        if (localWxaAttributes == null) {
          break label736;
        }
        str = localWxaAttributes.field_smallHeadURL;
        label186:
        locald.aeNN.setVisibility(0);
        locald.aeRT.setVisibility(8);
        locald.aeNR.setText(paramString.title);
        locald.aeRT.setText(paramString.description);
        locald.aeNL.setText((CharSequence)localObject);
        switch (paramString.nTW)
        {
        default: 
          locald.aeNM.setText(R.l.app_brand_entrance);
          r.bKe().a(str, locald.aeNK, ak.d.lCf);
          if (jxj())
          {
            localObject = (com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class);
            if ((paramcc.field_status == 2) && (b((com.tencent.mm.ui.chatting.component.api.m)localObject, paramcc.field_msgId))) {
              if (locald.aeNG != null) {
                locald.aeNG.setVisibility(0);
              }
            }
          }
          break;
        }
      }
      label435:
      label826:
      for (;;)
      {
        label352:
        boolean bool = false;
        localObject = this;
        label358:
        ((b)localObject).b(parama, bool);
        parama = (com.tencent.mm.message.a)paramString.aK(com.tencent.mm.message.a.class);
        localObject = new Bundle();
        ((Bundle)localObject).putString("app_id", paramString.nTE);
        ((Bundle)localObject).putString("msg_id", paramcc.field_msgId);
        if (parama != null)
        {
          parama = parama.nOL;
          ((Bundle)localObject).putString("cache_key", parama);
          ((Bundle)localObject).putString("msg_title", paramString.title);
          ((Bundle)localObject).putString("msg_path", paramString.nTC);
          ((Bundle)localObject).putInt("msg_pkg_type", paramString.nTW);
          ((Bundle)localObject).putInt("pkg_version", paramString.appVersion);
          ((Bundle)localObject).putInt("widget_type", 0);
          if (!parama1.juG()) {
            break label818;
          }
        }
        for (int i = 1008;; i = 1007)
        {
          ((Bundle)localObject).putInt("scene", i);
          ((Bundle)localObject).putInt("view_init_width", ak.d.aeRR);
          ((Bundle)localObject).putInt("view_init_height", ak.d.aeRS);
          locald.aeRV.setTag(locald);
          ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).a(p.el(parama1), locald.aeRV, (Bundle)localObject, this.roa);
          b.a(paramString.nTD, localWxaAttributes, paramString);
          locald.clickArea.setTag(localbz);
          locald.clickArea.setOnClickListener(d(parama1));
          localObject = ad.bCb().M(p.el(parama1), true);
          paramString = (ak.c)((ad.b)localObject).get("listener", null);
          parama = paramString;
          if (paramString == null)
          {
            parama = new ak.c();
            ((ad.b)localObject).q("listener", parama);
          }
          parama.n(parama1);
          if (this.wQm) {
            locald.clickArea.setOnLongClickListener(c(parama1));
          }
          a(paramInt, locald, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
          AppMethodBeat.o(37093);
          return;
          label726:
          localObject = paramString.iab;
          break;
          label736:
          str = paramString.nTY;
          break label186;
          locald.aeNM.setText(R.l.app_brand_share_wxa_testing_tag);
          break label279;
          locald.aeNM.setText(R.l.app_brand_share_wxa_preview_tag);
          break label279;
          if (locald.aeNG == null) {
            break label352;
          }
          locald.aeNG.setVisibility(8);
          break label352;
          if (paramcc.field_status >= 2) {
            break label826;
          }
          bool = true;
          localObject = this;
          break label358;
          parama = null;
          break label435;
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37095);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37095);
      return false;
    case 111: 
      e.b.a(parama, paramcc, a(parama, paramcc));
      AppMethodBeat.o(37095);
      return false;
    case 103: 
      paramMenuItem = paramcc.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
        return false;
      }
      paramMenuItem = k.b.Hf(paramMenuItem);
      if (paramMenuItem != null) {
        switch (paramMenuItem.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(37095);
        return false;
        parama = new me();
        parama.hOi.hOj = paramMenuItem.hOj;
        parama.hOi.hCz = paramcc.field_msgId;
        parama.hOi.hOk = paramcc.field_talker;
        parama.publish();
      }
    case 133: 
      Object localObject = paramcc.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = k.b.Hf((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.nTE);
      ((Bundle)localObject).putString("msg_id", paramcc.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.nTW);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.nTH);
      ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEJ().e(parama.aezO.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37095);
      return false;
    }
    ((com.tencent.mm.modelappbrand.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.h.class)).bEJ().dN(parama.aezO.getContext());
    AppMethodBeat.o(37095);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255607);
    int i = ((bz)paramView.getTag()).position;
    if (paramcc.field_content == null)
    {
      AppMethodBeat.o(255607);
      return true;
    }
    paramContextMenuInfo = k.b.Hf(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
    if (paramContextMenuInfo == null)
    {
      AppMethodBeat.o(255607);
      return true;
    }
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.s(paramContextMenuInfo.appId, false, false))) && (!com.tencent.mm.ui.chatting.m.bR(paramcc)) && (!bt.Q(paramcc))) {
      params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker))) {
      params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
    }
    ex localex = new ex();
    localex.hFc.msgId = paramcc.field_msgId;
    localex.publish();
    if ((localex.hFd.hEn) || (e.b.a(this.aeiK.aezO.getContext(), paramContextMenuInfo))) {
      params.a(i, 129, paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
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
    AppMethodBeat.o(255607);
    return true;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255629);
    if (paramcc.fxR())
    {
      com.tencent.mm.pluginsdk.model.app.n.bx(paramcc);
      br.iu(paramcc.field_msgId);
      parama.jpK();
      AppMethodBeat.o(255629);
      return;
    }
    AppMethodBeat.o(255629);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37096);
    ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    paramView.getTag();
    Object localObject1 = paramcc.field_content;
    if (localObject1 == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    localObject1 = k.b.Hf((String)localObject1);
    if (localObject1 == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.s(((k.b)localObject1).appId, true, false);
    if ((localObject2 != null) && (!Util.isNullOrNil(((g)localObject2).field_appId))) {
      a(parama, (k.b)localObject1, z.bAM(), (g)localObject2, paramcc.field_msgSvrId, parama.getTalkerUserName());
    }
    localObject2 = new zp();
    ((zp)localObject2).icM.appId = ((k.b)localObject1).nTE;
    ((zp)localObject2).icM.userName = ((k.b)localObject1).nTD;
    ((zp)localObject2).icM.icO = ((k.b)localObject1).nTC;
    ((zp)localObject2).icM.icP = ((k.b)localObject1).nTW;
    ((zp)localObject2).icM.icS = ((k.b)localObject1).nTG;
    ((zp)localObject2).icM.appVersion = ((k.b)localObject1).nTX;
    Object localObject3 = ((zp)localObject2).icM;
    boolean bool;
    StringBuilder localStringBuilder;
    if (((k.b)localObject1).nTW != 0)
    {
      bool = true;
      ((zp.a)localObject3).icT = bool;
      localObject3 = ((k.b)localObject1).nTI;
      if (!parama.juG()) {
        break label373;
      }
      ((zp)localObject2).icM.scene = 1008;
      localStringBuilder = new StringBuilder(parama.getTalkerUserName());
      localStringBuilder.append(":");
      localStringBuilder.append(a(parama, paramcc));
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject3);
    }
    for (((zp)localObject2).icM.hzx = localStringBuilder.toString();; ((zp)localObject2).icM.hzx = localStringBuilder.toString())
    {
      ((zp)localObject2).icM.icV.eoT = parama.getTalkerUserName();
      ((zp)localObject2).icM.icV.eoU = ((k.b)localObject1).nTJ;
      ((zp)localObject2).publish();
      com.tencent.mm.ui.chatting.component.c.d(parama, paramView, paramcc);
      AppMethodBeat.o(37096);
      return true;
      bool = false;
      break;
      label373:
      ((zp)localObject2).icM.scene = 1007;
      localStringBuilder = new StringBuilder(a(parama, paramcc));
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject3);
    }
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean fXn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.b
 * JD-Core Version:    0.7.0.1
 */