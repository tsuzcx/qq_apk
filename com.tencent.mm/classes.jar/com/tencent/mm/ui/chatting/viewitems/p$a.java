package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.a.rc.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class p$a
  extends c
  implements com.tencent.mm.modelappbrand.f
{
  private z fXH = new aa(this);
  private com.tencent.mm.ui.chatting.c.a vko;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_appmsg_wxa_dynamic);
      paramLayoutInflater = new p.d().u((View)localObject, true);
      paramView = ((com.tencent.mm.modelappbrand.e)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.e.class)).bt(((View)localObject).getContext());
      paramLayoutInflater.vDq = paramView;
      paramLayoutInflater.vDp.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    p.d locald = (p.d)parama;
    parama = parambi.field_content;
    Object localObject = (i)parama1.ac(i.class);
    ((i)localObject).aU(parambi);
    ((i)localObject).aV(parambi);
    ((i)localObject).aW(parambi);
    y.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", new Object[] { paramString });
    aw localaw;
    if (parama != null)
    {
      parama = g.a.M(parama, parambi.field_reserved);
      localaw = new aw(parambi, parama1.cFE(), paramInt, null, '\000');
      if (parama != null)
      {
        locald.vBx.setVisibility(8);
        locald.vBw.setVisibility(8);
        locald.vBV.setVisibility(8);
        paramString = (com.tencent.mm.ae.e)parama.A(com.tencent.mm.ae.e.class);
        localObject = locald.vBA;
        if (paramString != null) {
          break label828;
        }
        paramString = null;
        label163:
        if (!((ChattingItemFooter)localObject).l(paramString, parambi.field_talker)) {
          break label838;
        }
        locald.igg.setBackgroundResource(R.g.chatfrom_bg_apptop);
        label189:
        com.tencent.mm.pluginsdk.model.app.f localf = com.tencent.mm.pluginsdk.model.app.g.dh(parama.appId, parama.cau);
        if ((localf != null) && (localf.ZH())) {
          b(parama1, parama, parambi);
        }
        if ((parama.cQF != null) && (parama.cQF.length() != 0)) {
          break label852;
        }
        locald.vBz.setVisibility(8);
        label249:
        localObject = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(parama.dSY);
        locald.vBC.setVisibility(0);
        locald.vBt.setVisibility(8);
        locald.vBF.setVisibility(0);
        locald.vBD.setVisibility(8);
        if (localObject == null) {
          break label881;
        }
        paramString = ((WxaAttributes)localObject).field_nickname;
        label318:
        if (localObject == null) {
          break label890;
        }
        localObject = ((WxaAttributes)localObject).field_smallHeadURL;
        label330:
        locald.vBV.setVisibility(0);
        locald.vBR.setVisibility(8);
        locald.vBY.setText(parama.title);
        locald.vBR.setText(parama.description);
        locald.vBT.setText(paramString);
        switch (parama.dTf)
        {
        default: 
          locald.vBU.setText(R.l.app_brand_entrance);
          label419:
          com.tencent.mm.as.o.ON().a((String)localObject, locald.vBS, p.d.vDo);
          if (!parama1.cFE()) {
            if (com.tencent.mm.pluginsdk.model.app.g.g(localf))
            {
              locald.vBB.setVisibility(0);
              c(parama1, locald.vBB, aw.a(parama, parambi));
              label474:
              localObject = (com.tencent.mm.ae.a)parama.A(com.tencent.mm.ae.a.class);
              paramString = new Bundle();
              paramString.putString("app_id", parama.dSZ);
              paramString.putString("msg_id", parambi.field_msgId);
              if (localObject == null) {
                break label953;
              }
              parambi = ((com.tencent.mm.ae.a)localObject).dPE;
              label545:
              paramString.putString("cache_key", parambi);
              paramString.putString("msg_title", parama.title);
              paramString.putString("msg_path", parama.dSX);
              paramString.putInt("msg_pkg_type", parama.dTf);
              paramString.putInt("pkg_version", parama.cau);
              paramString.putInt("widget_type", 0);
              if (!parama1.cFE()) {
                break label959;
              }
            }
          }
          break;
        }
      }
    }
    label828:
    label959:
    for (paramInt = 1008;; paramInt = 1007)
    {
      paramString.putInt("scene", paramInt);
      paramString.putInt("view_init_width", p.d.vDm);
      paramString.putInt("view_init_height", p.d.vDn);
      locald.vDq.setTag(locald);
      ((com.tencent.mm.modelappbrand.e)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.e.class)).a(com.tencent.mm.plugin.appbrand.u.o.aX(parama1), locald.vDq, paramString, this.fXH);
      locald.igg.setTag(localaw);
      locald.igg.setOnClickListener(d(parama1));
      paramString = u.Hc().v(com.tencent.mm.plugin.appbrand.u.o.aX(parama1), true);
      parambi = (p.c)paramString.get("listener", null);
      parama = parambi;
      if (parambi == null)
      {
        parama = new p.c();
        paramString.h("listener", parama);
      }
      parama.j(parama1);
      if (this.khG) {
        locald.igg.setOnLongClickListener(c(parama1));
      }
      return;
      y.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambi.field_msgId), paramString });
      parama = null;
      break;
      paramString = paramString.dQr;
      break label163;
      label838:
      locald.igg.setBackgroundResource(R.g.chatfrom_bg_app);
      break label189;
      label852:
      locald.vBz.setVisibility(0);
      b(parama1, locald.vBz, aw.adO(parama.cQF));
      break label249;
      label881:
      paramString = parama.bYH;
      break label318;
      label890:
      localObject = parama.dTh;
      break label330;
      locald.vBU.setText(R.l.app_brand_share_wxa_testing_tag);
      break label419;
      locald.vBU.setText(R.l.app_brand_share_wxa_preview_tag);
      break label419;
      locald.vBB.setVisibility(8);
      break label474;
      locald.vBB.setVisibility(8);
      break label474;
      parambi = null;
      break label545;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    g.a locala = g.a.gp(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    Object localObject;
    if ((com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.by(locala.appId, false))) && (!k.at(parambi)))
    {
      if (locala.type != 6) {
        break label359;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.l.VX(locala.bFE);
      if (((localObject == null) || (!d.b.e(parambi, ((com.tencent.mm.pluginsdk.model.app.b)localObject).field_fileFullPath))) && (!parambi.cvx())) {
        paramContextMenu.add(i, 111, 0, this.vko.vtz.getMMResources().getString(R.l.retransmit));
      }
    }
    for (;;)
    {
      localObject = new do();
      ((do)localObject).bJZ.bIt = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      if ((((do)localObject).bKa.bJy) || (d.b.a(this.vko.vtz.getContext(), locala))) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_open));
      }
      if (bf.k(parambi)) {
        paramContextMenu.clear();
      }
      if (!this.vko.cFF()) {
        paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
      }
      paramView = ((com.tencent.mm.modelappbrand.e)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.e.class)).Jn();
      if ((paramView.Js()) || (paramView.id(locala.dTf)))
      {
        paramContextMenu.add(i, 133, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_open_wxa_widget_debugger_settings));
        paramContextMenu.add(i, 132, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_open_wxa_widget_debugger));
      }
      return true;
      label359:
      paramContextMenu.add(i, 111, 0, this.vko.vtz.getMMResources().getString(R.l.retransmit));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    String str = null;
    Object localObject = null;
    switch (paramMenuItem.getItemId())
    {
    default: 
    case 100: 
    case 111: 
    case 133: 
      do
      {
        return false;
        str = parambi.field_content;
        paramMenuItem = (MenuItem)localObject;
        if (str != null) {
          paramMenuItem = g.a.gp(str);
        }
        if (paramMenuItem != null)
        {
          com.tencent.mm.pluginsdk.model.app.l.ha(parambi.field_msgId);
          if (19 == paramMenuItem.type)
          {
            localObject = new nd();
            ((nd)localObject).bWJ.type = 3;
            ((nd)localObject).bWJ.bIt = parambi.field_msgId;
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
          }
          localObject = com.tencent.mm.pluginsdk.model.app.g.by(paramMenuItem.appId, false);
          if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.f)localObject).ZH())) {
            a(parama, paramMenuItem, parambi, (com.tencent.mm.pluginsdk.model.app.f)localObject);
          }
        }
        bd.bC(parambi.field_msgId);
        return false;
        d.b.a(parama, parambi, b(parama, parambi));
        return false;
        localObject = parambi.field_content;
        paramMenuItem = str;
        if (localObject != null) {
          paramMenuItem = g.a.gp((String)localObject);
        }
      } while (paramMenuItem == null);
      localObject = new Bundle();
      ((Bundle)localObject).putString("app_id", paramMenuItem.dSZ);
      ((Bundle)localObject).putString("msg_id", parambi.field_msgId);
      ((Bundle)localObject).putInt("pkg_type", paramMenuItem.dTf);
      ((Bundle)localObject).putInt("pkg_version", paramMenuItem.dTc);
      ((com.tencent.mm.modelappbrand.e)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.e.class)).Jn().d(parama.vtz.getContext(), (Bundle)localObject);
      return false;
    }
    ((com.tencent.mm.modelappbrand.e)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.e.class)).Jn().bu(parama.vtz.getContext());
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    com.tencent.mm.modelstat.a.a(parambi, a.a.eBA);
    if (parambi.field_content == null) {}
    Object localObject1;
    do
    {
      return false;
      localObject1 = g.a.gp(bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend));
    } while (localObject1 == null);
    paramView = com.tencent.mm.pluginsdk.model.app.g.by(((g.a)localObject1).appId, false);
    if ((paramView != null) && (paramView.ZH())) {
      a(parama, (g.a)localObject1, d(parama, parambi), paramView, parambi.field_msgSvrId);
    }
    y.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { ((g.a)localObject1).dSY, ((g.a)localObject1).dSX, ((g.a)localObject1).dSZ, ((g.a)localObject1).url, Integer.valueOf(((g.a)localObject1).dTf), ((g.a)localObject1).dTb });
    paramView = new rc();
    paramView.caq.appId = ((g.a)localObject1).dSZ;
    paramView.caq.userName = ((g.a)localObject1).dSY;
    paramView.caq.cas = ((g.a)localObject1).dSX;
    paramView.caq.cat = ((g.a)localObject1).dTf;
    paramView.caq.caw = ((g.a)localObject1).dTb;
    paramView.caq.cau = ((g.a)localObject1).dTg;
    Object localObject2 = paramView.caq;
    boolean bool;
    if (((g.a)localObject1).dTf != 0)
    {
      bool = true;
      ((rc.a)localObject2).cax = bool;
      paramView.caq.caz.dZN = parama.getTalkerUserName();
      paramView.caq.caz.dTX = ((g.a)localObject1).dTe;
      localObject1 = ((g.a)localObject1).dTd;
      if (!parama.cFE()) {
        break label378;
      }
      paramView.caq.scene = 1008;
      localObject2 = new StringBuilder(parama.getTalkerUserName());
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(b(parama, parambi));
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append((String)localObject1);
    }
    for (paramView.caq.bFv = ((StringBuilder)localObject2).toString();; paramView.caq.bFv = parama.toString())
    {
      com.tencent.mm.sdk.b.a.udP.m(paramView);
      return true;
      bool = false;
      break;
      label378:
      paramView.caq.scene = 1007;
      parama = new StringBuilder(b(parama, parambi));
      parama.append(":");
      parama.append((String)localObject1);
    }
  }
  
  public final boolean bfO()
  {
    return false;
  }
  
  public final void y(View paramView, int paramInt)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof p.d)) {
      return;
    }
    y.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
    paramView = (p.d)localObject;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      paramView.him.cKc();
      paramView.him.setVisibility(4);
      paramView.vDq.setVisibility(4);
      paramView.pEu.setVisibility(0);
      paramView.pEu.setImageResource(R.k.app_brand_share_page_cover_default);
      return;
    case 0: 
      paramView.him.setVisibility(0);
      paramView.him.cKb();
      paramView.pEu.setVisibility(4);
      paramView.vDq.setVisibility(4);
      return;
    case 1: 
      paramView.him.cKc();
      paramView.him.setVisibility(4);
      paramView.vDq.setVisibility(4);
      paramView.pEu.setVisibility(0);
      paramView.pEu.setImageResource(R.k.dynamic_page_res_not_found);
      return;
    }
    paramView.him.cKc();
    paramView.him.setVisibility(4);
    paramView.vDq.setVisibility(0);
    paramView.pEu.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.a
 * JD-Core Version:    0.7.0.1
 */