package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.a.rc.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelappbrand.k.a;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bzp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

public final class q$a
  extends c
{
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_appmsg_wxa);
      ((View)localObject).setTag(new q.d().v((View)localObject, true));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, final bi parambi, String paramString)
  {
    this.vko = parama1;
    final q.d locald = (q.d)parama;
    parama = (com.tencent.mm.ui.chatting.b.b.i)parama1.ac(com.tencent.mm.ui.chatting.b.b.i.class);
    parama.aU(parambi);
    parama.aV(parambi);
    parama.aW(parambi);
    parama = parambi.field_content;
    aw localaw;
    Object localObject;
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
          break label908;
        }
        paramString = null;
        label143:
        if (!((ChattingItemFooter)localObject).l(paramString, parambi.field_talker)) {
          break label918;
        }
        locald.igg.setBackgroundResource(R.g.chatfrom_bg_apptop);
        label169:
        localObject = com.tencent.mm.pluginsdk.model.app.g.dh(parama.appId, parama.cau);
        if ((localObject != null) && (((f)localObject).ZH())) {
          b(parama1, parama, parambi);
        }
        if ((parama.cQF != null) && (parama.cQF.length() != 0)) {
          break label932;
        }
        locald.vBz.setVisibility(8);
        label229:
        WxaAttributes localWxaAttributes = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(parama.dSY);
        locald.vBC.setVisibility(0);
        locald.vBt.setVisibility(8);
        locald.vBF.setVisibility(0);
        locald.vBD.setVisibility(8);
        if (localWxaAttributes == null) {
          break label961;
        }
        paramString = localWxaAttributes.field_nickname;
        label298:
        locald.vBT.setText(paramString);
        if (localWxaAttributes == null) {
          break label970;
        }
        paramString = localWxaAttributes.field_smallHeadURL;
        label320:
        o.ON().a(paramString, locald.vBS, q.d.vDo);
        locald.vBV.setVisibility(0);
        locald.vBR.setVisibility(8);
        locald.vBR.setText(parama.description);
        locald.vBY.setText(parama.title);
        switch (parama.dTf)
        {
        default: 
          locald.vBU.setText(R.l.app_brand_entrance);
          label415:
          o.ON().a(paramString, locald.vBS, q.d.vDo);
          if (!parama1.cFE()) {
            if (com.tencent.mm.pluginsdk.model.app.g.g((f)localObject))
            {
              locald.vBB.setVisibility(0);
              c(parama1, locald.vBB, aw.a(parama, parambi));
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      parambi = o.OJ().b(parambi.field_imgPath, false, true);
      locald.vBW.setImageBitmap(null);
      locald.vBW.setVisibility(4);
      locald.vBX.setVisibility(0);
      com.tencent.mm.modelappbrand.a.b.JD().a(new q.a.1(this, locald), "file://" + parambi, null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.i.class)).bk(240, 192));
      locald.vDw.setVisibility(8);
      locald.vDw.setTag(bk.aM(parama.dTe, ""));
      locald.vDx.setVisibility(8);
      parambi = (com.tencent.mm.ae.a)parama.A(com.tencent.mm.ae.a.class);
      if ((parambi != null) && (parambi.dPG))
      {
        paramString = parama.dTe;
        localObject = ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.k.class)).jv(paramString);
        q.a(parama1, locald, parambi, (com.tencent.mm.ae.a.b)localObject);
        q.a(parama1, locald, parambi, parama, (com.tencent.mm.ae.a.b)localObject);
        int i = parambi.dPN;
        paramInt = i;
        if (localObject != null)
        {
          paramInt = i;
          if (((com.tencent.mm.ae.a.b)localObject).field_updatePeroid != 0) {
            paramInt = ((com.tencent.mm.ae.a.b)localObject).field_updatePeroid;
          }
        }
        if (paramInt > 0) {
          ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.k.class)).a(q.e.aX(parama1), parama.dSZ, paramString, paramInt, new k.a()
          {
            public final void a(String paramAnonymousString, bzp paramAnonymousbzp)
            {
              y.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramAnonymousString, paramAnonymousbzp.content });
              if (locald.vDw == null) {
                y.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "viewHolder.appbrandUpdateTv is null, return");
              }
              do
              {
                String str;
                do
                {
                  return;
                  str = (String)locald.vDw.getTag();
                  if (bk.bl(str))
                  {
                    y.w("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "oriShareKey is null, return");
                    return;
                  }
                } while (!str.equals(paramAnonymousString));
                locald.vDw.setVisibility(0);
                locald.vDw.setText(paramAnonymousbzp.content);
                locald.vDw.setTextColor(bk.bq(paramAnonymousbzp.tIo, locald.vDw.getCurrentTextColor()));
              } while ((paramAnonymousbzp.state != 1) || (((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.k.class)).jv(paramAnonymousString).field_btnState != 1));
              if (bk.bl(parambi.dPM))
              {
                locald.vDx.setVisibility(8);
                return;
              }
              locald.vDx.setVisibility(0);
              locald.vDx.setText(parambi.dPM);
            }
          });
        }
      }
      locald.igg.setTag(localaw);
      locald.igg.setOnClickListener(d(parama1));
      paramString = u.Hc().v(q.e.aX(parama1), true);
      parambi = (q.c)paramString.get("listener", null);
      parama = parambi;
      if (parambi == null)
      {
        parama = new q.c();
        paramString.h("listener", parama);
      }
      parama.j(parama1);
      if (this.khG)
      {
        locald.igg.setOnLongClickListener(c(parama1));
        locald.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
      }
      return;
      y.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(parambi.field_msgId), paramString });
      parama = null;
      break;
      label908:
      paramString = paramString.dQr;
      break label143;
      label918:
      locald.igg.setBackgroundResource(R.g.chatfrom_bg_app);
      break label169;
      label932:
      locald.vBz.setVisibility(0);
      b(parama1, locald.vBz, aw.adO(parama.cQF));
      break label229;
      label961:
      paramString = parama.bYH;
      break label298;
      label970:
      paramString = parama.dTh;
      break label320;
      locald.vBU.setText(R.l.app_brand_share_wxa_testing_tag);
      break label415;
      locald.vBU.setText(R.l.app_brand_share_wxa_preview_tag);
      break label415;
      locald.vBB.setVisibility(8);
      continue;
      locald.vBB.setVisibility(8);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    g.a locala = g.a.gp(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
    Object localObject;
    if ((com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.by(locala.appId, false))) && (!com.tencent.mm.ui.chatting.k.at(parambi)))
    {
      if (locala.type != 6) {
        break label251;
      }
      localObject = l.VX(locala.bFE);
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
      if (!this.vko.cFF()) {
        paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
      }
      return true;
      label251:
      paramContextMenu.add(i, 111, 0, this.vko.vtz.getMMResources().getString(R.l.retransmit));
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    case 100: 
      Object localObject = parambi.field_content;
      paramMenuItem = null;
      if (localObject != null) {
        paramMenuItem = g.a.gp((String)localObject);
      }
      if (paramMenuItem != null)
      {
        l.ha(parambi.field_msgId);
        if (19 == paramMenuItem.type)
        {
          localObject = new nd();
          ((nd)localObject).bWJ.type = 3;
          ((nd)localObject).bWJ.bIt = parambi.field_msgId;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        }
        localObject = com.tencent.mm.pluginsdk.model.app.g.by(paramMenuItem.appId, false);
        if ((localObject != null) && (((f)localObject).ZH())) {
          a(parama, paramMenuItem, parambi, (f)localObject);
        }
      }
      bd.bC(parambi.field_msgId);
      return false;
    }
    d.b.a(parama, parambi, b(parama, parambi));
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 587202609);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    com.tencent.mm.modelstat.a.a(parambi, a.a.eBA);
    if (parambi.field_content == null) {}
    do
    {
      return false;
      paramView = g.a.gp(bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend));
    } while (paramView == null);
    Object localObject1 = com.tencent.mm.pluginsdk.model.app.g.by(paramView.appId, false);
    if ((localObject1 != null) && (((f)localObject1).ZH())) {
      a(parama, paramView, d(parama, parambi), (f)localObject1, parambi.field_msgSvrId);
    }
    y.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[] { paramView.dSY, paramView.dSX, paramView.dSZ, paramView.url, Integer.valueOf(paramView.dTf), paramView.dTb });
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
      ((rc)localObject1).caq.caz.dZN = parama.getTalkerUserName();
      ((rc)localObject1).caq.caz.dTX = paramView.dTe;
      localObject2 = paramView.dTd;
      if (!parama.cFE()) {
        break label382;
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
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      q.a(parama, paramView);
      return true;
      bool = false;
      break;
      label382:
      ((rc)localObject1).caq.scene = 1007;
      parambi = new StringBuilder(b(parama, parambi));
      parambi.append(":");
      parambi.append((String)localObject2);
    }
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.a
 * JD-Core Version:    0.7.0.1
 */