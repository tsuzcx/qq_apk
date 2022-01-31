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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.a.if;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.a.rc.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class p$b
  extends c
  implements com.tencent.mm.modelappbrand.f, t.m
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_appmsg_wxa_dynamic);
      paramLayoutInflater = new p.d().u((View)localObject, false);
      paramView = ((com.tencent.mm.modelappbrand.e)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.e.class)).bt(((View)localObject).getContext());
      paramLayoutInflater.vDq = paramView;
      paramLayoutInflater.vDp.addView(paramView, new ViewGroup.LayoutParams(-1, -1));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    if (parambi.aVK())
    {
      com.tencent.mm.pluginsdk.model.app.l.ae(parambi);
      bd.bC(parambi.field_msgId);
      parama.cCW();
    }
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    p.d locald = (p.d)parama;
    this.vko = parama1;
    parama = (i)parama1.ac(i.class);
    parama.aW(parambi);
    paramString = parambi.field_content;
    parama.aU(parambi);
    if (paramString != null) {}
    for (parama = g.a.M(paramString, parambi.field_reserved);; parama = null)
    {
      aw localaw = new aw(parambi, parama1.cFE(), paramInt, null, '\000');
      Object localObject;
      if (parama != null)
      {
        locald.vBx.setVisibility(8);
        locald.vBw.setVisibility(8);
        locald.vBt.setVisibility(8);
        locald.vBV.setVisibility(8);
        localObject = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(parama.dSY);
        if (localObject == null) {
          break label688;
        }
        paramString = ((WxaAttributes)localObject).field_nickname;
        if (localObject == null) {
          break label697;
        }
        localObject = ((WxaAttributes)localObject).field_smallHeadURL;
        label165:
        locald.vBV.setVisibility(0);
        locald.vBR.setVisibility(8);
        locald.vBY.setText(parama.title);
        locald.vBR.setText(parama.description);
        locald.vBT.setText(paramString);
        switch (parama.dTf)
        {
        default: 
          locald.vBU.setText(R.l.app_brand_entrance);
          label255:
          com.tencent.mm.as.o.ON().a((String)localObject, locald.vBS, p.d.vDo);
          if (cHc())
          {
            paramString = (com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class);
            if ((parambi.field_status == 2) && (a(paramString, parambi.field_msgId)))
            {
              if (locald.vBN != null) {
                locald.vBN.setVisibility(0);
              }
              label328:
              if (locald.nhQ != null) {
                locald.nhQ.setVisibility(8);
              }
              label346:
              paramString = (com.tencent.mm.ae.a)parama.A(com.tencent.mm.ae.a.class);
              localObject = new Bundle();
              ((Bundle)localObject).putString("app_id", parama.dSZ);
              ((Bundle)localObject).putString("msg_id", parambi.field_msgId);
              if (paramString == null) {
                break label794;
              }
              paramString = paramString.dPE;
              label417:
              ((Bundle)localObject).putString("cache_key", paramString);
              ((Bundle)localObject).putString("msg_title", parama.title);
              ((Bundle)localObject).putString("msg_path", parama.dSX);
              ((Bundle)localObject).putInt("msg_pkg_type", parama.dTf);
              ((Bundle)localObject).putInt("pkg_version", parama.cau);
              ((Bundle)localObject).putInt("widget_type", 0);
              if (!parama1.cFE()) {
                break label800;
              }
            }
          }
          break;
        }
      }
      label794:
      label800:
      for (int i = 1008;; i = 1007)
      {
        ((Bundle)localObject).putInt("scene", i);
        ((Bundle)localObject).putInt("view_init_width", p.d.vDm);
        ((Bundle)localObject).putInt("view_init_height", p.d.vDn);
        locald.vDq.setTag(locald);
        ((com.tencent.mm.modelappbrand.e)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.e.class)).a(com.tencent.mm.plugin.appbrand.u.o.aX(parama1), locald.vDq, (Bundle)localObject, this.fXH);
        locald.igg.setTag(localaw);
        locald.igg.setOnClickListener(d(parama1));
        localObject = u.Hc().v(com.tencent.mm.plugin.appbrand.u.o.aX(parama1), true);
        paramString = (p.c)((u.b)localObject).get("listener", null);
        parama = paramString;
        if (paramString == null)
        {
          parama = new p.c();
          ((u.b)localObject).h("listener", parama);
        }
        parama.j(parama1);
        if (this.khG) {
          locald.igg.setOnLongClickListener(c(parama1));
        }
        a(paramInt, locald, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
        return;
        label688:
        paramString = parama.bYH;
        break;
        label697:
        localObject = parama.dTh;
        break label165;
        locald.vBU.setText(R.l.app_brand_share_wxa_testing_tag);
        break label255;
        locald.vBU.setText(R.l.app_brand_share_wxa_preview_tag);
        break label255;
        if (locald.vBN == null) {
          break label328;
        }
        locald.vBN.setVisibility(8);
        break label328;
        if (locald.nhQ == null) {
          break label346;
        }
        locald.nhQ.setVisibility(0);
        if (parambi.field_status < 2) {
          break label346;
        }
        locald.nhQ.setVisibility(8);
        break label346;
        paramString = null;
        break label417;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    if (parambi.field_content == null) {}
    g.a locala;
    do
    {
      do
      {
        return true;
        locala = g.a.gp(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
      } while (locala == null);
      if ((com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.by(locala.appId, false))) && (!k.at(parambi))) {
        paramContextMenu.add(i, 111, 0, this.vko.vtz.getMMResources().getString(R.l.retransmit));
      }
      if (((parambi.field_status == 2) || (parambi.cQJ == 1)) && (a(parambi, this.vko)) && (adG(parambi.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
      }
      do localdo = new do();
      localdo.bJZ.bIt = parambi.field_msgId;
      com.tencent.mm.sdk.b.a.udP.m(localdo);
      if ((localdo.bKa.bJy) || (d.b.a(this.vko.vtz.getContext(), locala))) {
        paramContextMenu.add(i, 129, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_open));
      }
      if (!this.vko.cFF()) {
        paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
      }
      paramView = ((com.tencent.mm.modelappbrand.e)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.e.class)).Jn();
    } while ((!paramView.Js()) && (!paramView.id(locala.dTf)));
    paramContextMenu.add(i, 133, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_open_wxa_widget_debugger_settings));
    paramContextMenu.add(i, 132, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_open_wxa_widget_debugger));
    return true;
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
    case 103: 
    case 133: 
      do
      {
        do
        {
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
              if (19 == paramMenuItem.type)
              {
                localObject = new nd();
                ((nd)localObject).bWJ.type = 3;
                ((nd)localObject).bWJ.bIt = parambi.field_msgId;
                com.tencent.mm.sdk.b.a.udP.m((b)localObject);
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
            paramMenuItem = parambi.field_content;
          } while (paramMenuItem == null);
          paramMenuItem = g.a.gp(paramMenuItem);
        } while (paramMenuItem == null);
        switch (paramMenuItem.type)
        {
        default: 
          return false;
        }
        parama = new if();
        parama.bQq.bQr = paramMenuItem.bQr;
        parama.bQq.bHR = parambi.field_msgId;
        parama.bQq.bQs = parambi.field_talker;
        com.tencent.mm.sdk.b.a.udP.m(parama);
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
    return (paramBoolean) && (paramInt == 553648177);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    paramView.getTag();
    paramView = parambi.field_content;
    if (paramView == null) {}
    do
    {
      return false;
      paramView = g.a.gp(paramView);
    } while (paramView == null);
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.g.by(paramView.appId, true);
    if ((localObject1 != null) && (!bk.bl(((com.tencent.mm.pluginsdk.model.app.f)localObject1).field_appId)) && (((com.tencent.mm.pluginsdk.model.app.f)localObject1).ZH())) {
      a(parama, paramView, q.Gj(), (com.tencent.mm.pluginsdk.model.app.f)localObject1, parambi.field_msgSvrId);
    }
    localObject1 = new rc();
    ((rc)localObject1).caq.appId = paramView.dSZ;
    ((rc)localObject1).caq.userName = paramView.dSY;
    ((rc)localObject1).caq.cas = paramView.dSX;
    ((rc)localObject1).caq.cat = paramView.dTf;
    ((rc)localObject1).caq.caw = paramView.dTb;
    ((rc)localObject1).caq.cau = paramView.dTg;
    Object localObject2 = ((rc)localObject1).caq;
    boolean bool;
    StringBuilder localStringBuilder;
    if (paramView.dTf != 0)
    {
      bool = true;
      ((rc.a)localObject2).cax = bool;
      localObject2 = paramView.dTd;
      if (!parama.cFE()) {
        break label313;
      }
      ((rc)localObject1).caq.scene = 1008;
      localStringBuilder = new StringBuilder(parama.getTalkerUserName());
      localStringBuilder.append(":");
      localStringBuilder.append(b(parama, parambi));
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject2);
    }
    for (((rc)localObject1).caq.bFv = localStringBuilder.toString();; ((rc)localObject1).caq.bFv = parambi.toString())
    {
      ((rc)localObject1).caq.caz.dZN = parama.getTalkerUserName();
      ((rc)localObject1).caq.caz.dTX = paramView.dTe;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
      return true;
      bool = false;
      break;
      label313:
      ((rc)localObject1).caq.scene = 1007;
      parambi = new StringBuilder(b(parama, parambi));
      parambi.append(":");
      parambi.append((String)localObject2);
    }
  }
  
  public final boolean bfO()
  {
    return true;
  }
  
  public final void y(View paramView, int paramInt)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof p.d)) {
      return;
    }
    y.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", new Object[] { Integer.valueOf(paramView.hashCode()), Integer.valueOf(paramInt) });
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
      paramView.vDq.setVisibility(4);
      paramView.pEu.setVisibility(4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.b
 * JD-Core Version:    0.7.0.1
 */