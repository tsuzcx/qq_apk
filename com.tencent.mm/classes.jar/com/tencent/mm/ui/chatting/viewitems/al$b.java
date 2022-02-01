package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.a.la;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.a.xw.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.ac;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class al$b
  extends c
  implements com.tencent.mm.modelappbrand.h, t.n
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  private ab oky;
  
  public al$b()
  {
    AppMethodBeat.i(37091);
    this.oky = new ac(this);
    AppMethodBeat.o(37091);
  }
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(37097);
    Object localObject = paramView.getTag();
    if (!(localObject instanceof al.d))
    {
      AppMethodBeat.o(37097);
      return;
    }
    Log.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
    paramView = (al.d)localObject;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      paramView.rfc.hZY();
      paramView.rfc.setVisibility(4);
      paramView.XhP.setVisibility(4);
      paramView.sDJ.setVisibility(0);
      paramView.sDJ.setImageResource(R.k.app_brand_share_page_cover_default);
      AppMethodBeat.o(37097);
      return;
    case 0: 
      paramView.rfc.setVisibility(0);
      paramView.rfc.hZX();
      paramView.XhP.setVisibility(4);
      paramView.sDJ.setVisibility(4);
      AppMethodBeat.o(37097);
      return;
    case 1: 
      paramView.rfc.hZY();
      paramView.rfc.setVisibility(4);
      paramView.XhP.setVisibility(4);
      paramView.sDJ.setVisibility(0);
      paramView.sDJ.setImageResource(R.k.dynamic_page_res_not_found);
      AppMethodBeat.o(37097);
      return;
    }
    paramView.rfc.hZY();
    paramView.rfc.setVisibility(4);
    paramView.XhP.setVisibility(0);
    paramView.sDJ.setVisibility(4);
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
      localObject = new aq(paramLayoutInflater, R.i.eeh);
      paramLayoutInflater = new al.d().V((View)localObject, false);
      paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.g.class)).cR(((View)localObject).getContext());
      paramLayoutInflater.XhP = paramView;
      paramLayoutInflater.XhO.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(37092);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37093);
    al.d locald = (al.d)parama;
    this.WBq = parama1;
    paramString = (com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class);
    paramString.ct(paramca);
    Object localObject1 = paramca.field_content;
    paramString.cr(paramca);
    if (localObject1 != null) {}
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
          break label725;
        }
        localObject1 = ((WxaAttributes)localObject2).field_nickname;
        if (localObject2 == null) {
          break label735;
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
          label271:
          com.tencent.mm.ay.q.bml().a((String)localObject2, locald.XdM, al.d.jak);
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
      label427:
      label817:
      label825:
      for (;;)
      {
        label344:
        boolean bool = false;
        localObject1 = this;
        label350:
        ((b)localObject1).b(parama, bool);
        parama = (com.tencent.mm.aj.a)paramString.ar(com.tencent.mm.aj.a.class);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("app_id", paramString.loB);
        ((Bundle)localObject1).putString("msg_id", paramca.field_msgId);
        if (parama != null)
        {
          parama = parama.lka;
          ((Bundle)localObject1).putString("cache_key", parama);
          ((Bundle)localObject1).putString("msg_title", paramString.title);
          ((Bundle)localObject1).putString("msg_path", paramString.loz);
          ((Bundle)localObject1).putInt("msg_pkg_type", paramString.loT);
          ((Bundle)localObject1).putInt("pkg_version", paramString.appVersion);
          ((Bundle)localObject1).putInt("widget_type", 0);
          if (!parama1.hRi()) {
            break label817;
          }
        }
        for (int i = 1008;; i = 1007)
        {
          ((Bundle)localObject1).putInt("scene", i);
          ((Bundle)localObject1).putInt("view_init_width", al.d.XhL);
          ((Bundle)localObject1).putInt("view_init_height", al.d.XhM);
          locald.XhP.setTag(locald);
          ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.g.class)).a(com.tencent.mm.plugin.appbrand.ac.n.cP(parama1), locald.XhP, (Bundle)localObject1, this.oky);
          ((w)com.tencent.mm.kernel.h.ae(w.class)).adj(paramString.loA);
          locald.clickArea.setTag(localby);
          locald.clickArea.setOnClickListener(d(parama1));
          localObject1 = ad.beh().I(com.tencent.mm.plugin.appbrand.ac.n.cP(parama1), true);
          paramString = (al.c)((ad.b)localObject1).get("listener", null);
          parama = paramString;
          if (paramString == null)
          {
            parama = new al.c();
            ((ad.b)localObject1).k("listener", parama);
          }
          parama.n(parama1);
          if (this.tMW) {
            locald.clickArea.setOnLongClickListener(c(parama1));
          }
          a(paramInt, locald, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
          AppMethodBeat.o(37093);
          return;
          label725:
          localObject1 = paramString.fUe;
          break;
          label735:
          localObject2 = paramString.loV;
          break label176;
          locald.XdO.setText(R.l.app_brand_share_wxa_testing_tag);
          break label271;
          locald.XdO.setText(R.l.app_brand_share_wxa_preview_tag);
          break label271;
          if (locald.XdI == null) {
            break label344;
          }
          locald.XdI.setVisibility(8);
          break label344;
          if (paramca.field_status >= 2) {
            break label825;
          }
          bool = true;
          localObject1 = this;
          break label350;
          parama = null;
          break label427;
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37095);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37095);
      return false;
    case 111: 
      e.b.a(parama, paramca, a(parama, paramca));
      AppMethodBeat.o(37095);
      return false;
    case 103: 
      paramMenuItem = paramca.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
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
        AppMethodBeat.o(37095);
        return false;
        parama = new la();
        parama.fIH.fII = paramMenuItem.fII;
        parama.fIH.fxU = paramca.field_msgId;
        parama.fIH.fIJ = paramca.field_talker;
        EventCenter.instance.publish(parama);
      }
    case 133: 
      Object localObject = paramca.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = k.b.OQ((String)localObject);
      }
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(37095);
        return false;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.loB);
      ((Bundle)localObject).putString("msg_id", paramca.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.loT);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.loE);
      ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.g.class)).bgR().e(parama.WQv.getContext(), (Bundle)localObject);
      AppMethodBeat.o(37095);
      return false;
    }
    ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.g.class)).bgR().cS(parama.WQv.getContext());
    AppMethodBeat.o(37095);
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(291533);
    int i = ((by)paramView.getTag()).position;
    if (paramca.field_content == null)
    {
      AppMethodBeat.o(291533);
      return true;
    }
    k.b localb = k.b.OQ(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
    if (localb == null)
    {
      AppMethodBeat.o(291533);
      return true;
    }
    if ((com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(localb.appId, false, false))) && (!com.tencent.mm.ui.chatting.k.bF(paramca)) && (!bs.O(paramca))) {
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
    paramView = ((com.tencent.mm.modelappbrand.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.g.class)).bgR();
    if ((paramView.bgX()) || (paramView.vB(localb.loT)))
    {
      paramo.add(i, 133, 0, this.WBq.WQv.getMMResources().getString(R.l.evX));
      paramo.add(i, 132, 0, this.WBq.WQv.getMMResources().getString(R.l.evW));
    }
    AppMethodBeat.o(291533);
    return true;
  }
  
  public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(291534);
    if (paramca.erk())
    {
      com.tencent.mm.pluginsdk.model.app.m.bh(paramca);
      bq.Gk(paramca.field_msgId);
      parama.Gi(true);
      AppMethodBeat.o(291534);
      return;
    }
    AppMethodBeat.o(291534);
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37096);
    ((b)com.tencent.mm.kernel.h.ae(b.class)).asK(paramca.field_talker);
    paramView.getTag();
    paramView = paramca.field_content;
    if (paramView == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    paramView = k.b.OQ(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(37096);
      return false;
    }
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.o(paramView.appId, true, false);
    if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appId))) {
      a(parama, paramView, z.bcZ(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, paramca.field_msgSvrId, parama.getTalkerUserName());
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
        break label354;
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
      EventCenter.instance.publish((IEvent)localObject1);
      AppMethodBeat.o(37096);
      return true;
      bool = false;
      break;
      label354:
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
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al.b
 * JD-Core Version:    0.7.0.1
 */