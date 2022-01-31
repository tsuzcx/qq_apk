package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.a.if;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.a.rc.a;
import com.tencent.mm.h.b.a.aw.a;
import com.tencent.mm.h.b.a.aw.b;
import com.tencent.mm.h.b.a.aw.c;
import com.tencent.mm.h.b.a.aw.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.t.m;

public final class q
{
  public static final class b
    extends c
    implements t.m
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
        localObject = new t(paramLayoutInflater, R.i.chatting_item_to_appmsg_wxa);
        ((View)localObject).setTag(new q.d().v((View)localObject, false));
      }
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.c.a parama, bi parambi)
    {
      if (parambi.aVK())
      {
        l.ae(parambi);
        bd.bC(parambi.field_msgId);
        parama.cCW();
      }
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
    {
      q.d locald = (q.d)parama;
      this.vko = parama1;
      parama = (com.tencent.mm.ui.chatting.b.b.i)parama1.ac(com.tencent.mm.ui.chatting.b.b.i.class);
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
            break label772;
          }
          paramString = ((WxaAttributes)localObject).field_nickname;
          if (localObject == null) {
            break label781;
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
            o.ON().a((String)localObject, locald.vBS, q.d.vDo);
            if (cHc())
            {
              paramString = (com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class);
              if ((parambi.field_status == 2) && (a(paramString, parambi.field_msgId)))
              {
                if (locald.vBN != null) {
                  locald.vBN.setVisibility(0);
                }
                label327:
                if (locald.nhQ != null) {
                  locald.nhQ.setVisibility(8);
                }
              }
            }
            break;
          }
        }
        for (;;)
        {
          paramString = o.OJ().b(parambi.field_imgPath, false, true);
          locald.vBW.setImageBitmap(null);
          locald.vBW.setVisibility(4);
          locald.vBX.setVisibility(0);
          com.tencent.mm.modelappbrand.a.b.JD().a(new q.b.1(this, locald), "file://" + paramString, null, ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.i.class)).bk(240, 192));
          locald.vDw.setVisibility(8);
          locald.vDw.setTag(bk.aM(parama.dTe, ""));
          locald.vDx.setVisibility(8);
          paramString = (com.tencent.mm.ae.a)parama.A(com.tencent.mm.ae.a.class);
          if ((paramString != null) && (paramString.dPG))
          {
            localObject = parama.dTe;
            com.tencent.mm.ae.a.b localb = ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.k.class)).jv((String)localObject);
            q.a(parama1, locald, paramString, localb);
            q.a(parama1, locald, paramString, parama, localb);
            int j = paramString.dPN;
            int i = j;
            if (localb != null)
            {
              i = j;
              if (localb.field_updatePeroid != 0) {
                i = localb.field_updatePeroid;
              }
            }
            if (i > 0) {
              ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.r(com.tencent.mm.modelappbrand.k.class)).a(q.e.aX(parama1), parama.dSZ, (String)localObject, i, new q.b.2(this, locald, paramString));
            }
          }
          locald.igg.setTag(localaw);
          locald.igg.setOnClickListener(d(parama1));
          localObject = u.Hc().v(q.e.aX(parama1), true);
          paramString = (q.c)((u.b)localObject).get("listener", null);
          parama = paramString;
          if (paramString == null)
          {
            parama = new q.c();
            ((u.b)localObject).h("listener", parama);
          }
          parama.j(parama1);
          if (this.khG)
          {
            locald.igg.setOnLongClickListener(c(parama1));
            locald.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
          }
          a(paramInt, locald, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
          return;
          label772:
          paramString = parama.bYH;
          break;
          label781:
          localObject = parama.dTh;
          break label165;
          locald.vBU.setText(R.l.app_brand_share_wxa_testing_tag);
          break label255;
          locald.vBU.setText(R.l.app_brand_share_wxa_preview_tag);
          break label255;
          if (locald.vBN == null) {
            break label327;
          }
          locald.vBN.setVisibility(8);
          break label327;
          if (locald.nhQ != null)
          {
            locald.nhQ.setVisibility(0);
            if (parambi.field_status >= 2) {
              locald.nhQ.setVisibility(8);
            }
          }
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
    {
      int i = ((aw)paramView.getTag()).position;
      if (parambi.field_content == null) {}
      do
      {
        g.a locala;
        do
        {
          return true;
          locala = g.a.gp(bd.b(this.vko.cFE(), parambi.field_content, parambi.field_isSend));
        } while (locala == null);
        if ((com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.by(locala.appId, false))) && (!com.tencent.mm.ui.chatting.k.at(parambi))) {
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
      } while (this.vko.cFF());
      paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
      return true;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
    {
      switch (paramMenuItem.getItemId())
      {
      }
      do
      {
        do
        {
          return false;
          Object localObject = parambi.field_content;
          paramMenuItem = null;
          if (localObject != null) {
            paramMenuItem = g.a.gp((String)localObject);
          }
          if (paramMenuItem != null)
          {
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
    }
    
    public final boolean au(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 587202609);
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
      if ((localObject1 != null) && (!bk.bl(((f)localObject1).field_appId)) && (((f)localObject1).ZH())) {
        a(parama, paramView, com.tencent.mm.model.q.Gj(), (f)localObject1, parambi.field_msgSvrId);
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
          break label318;
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
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        q.a(parama, paramView);
        return true;
        bool = false;
        break;
        label318:
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
  }
  
  static final class d
    extends c.a
  {
    public static final int vDm = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 240);
    public static final int vDn = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 192);
    static com.tencent.mm.as.a.a.c vDo;
    protected ChattingItemFooter vBA;
    protected ImageView vBB;
    protected LinearLayout vBC;
    protected ViewGroup vBD;
    protected TextView vBE;
    protected LinearLayout vBF;
    ImageView vBN;
    protected TextView vBR;
    protected ImageView vBS;
    protected TextView vBT;
    protected TextView vBU;
    protected LinearLayout vBV;
    protected ImageView vBW;
    protected ImageView vBX;
    protected TextView vBY;
    protected ImageView vBt;
    protected ImageView vBw;
    protected ImageView vBx;
    protected TextView vBz;
    protected TextView vDw;
    protected TextView vDx;
    
    static
    {
      com.tencent.mm.as.a.a.c.a locala = new com.tencent.mm.as.a.a.c.a();
      locala.eru = R.k.app_brand_app_default_icon_for_tail;
      locala.bn(com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 20), com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 20)).erd = true;
      vDo = locala.OV();
    }
    
    public final d v(View paramView, boolean paramBoolean)
    {
      super.dN(paramView);
      this.vBt = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_sub_menu_icon));
      this.vBw = ((ImageView)this.kKz.findViewById(R.h.chatting_continue_btn));
      this.vBx = ((ImageView)this.kKz.findViewById(R.h.chatting_stop_btn));
      this.vBz = ((TextView)paramView.findViewById(R.h.chatting_appmsg_comment_tv));
      this.vBB = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_refuse_iv));
      this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
      this.hoY = paramView.findViewById(R.h.chatting_maskview);
      this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.vBA = ((ChattingItemFooter)paramView.findViewById(R.h.footer));
      this.vBC = ((LinearLayout)paramView.findViewById(R.h.app_msg_layout));
      this.vBD = ((ViewGroup)paramView.findViewById(R.h.location_share_layout));
      this.vBE = ((TextView)paramView.findViewById(R.h.location_share_content));
      this.vBF = ((LinearLayout)paramView.findViewById(R.h.chatting_area));
      this.igg = paramView.findViewById(R.h.chatting_click_area);
      if (!paramBoolean)
      {
        this.vBN = ((ImageView)this.kKz.findViewById(R.h.chatting_status_tick));
        this.nhQ = ((ProgressBar)this.kKz.findViewById(R.h.uploading_pb));
      }
      this.vBV = ((LinearLayout)paramView.findViewById(R.h.chatting_appmsg_appbrand_content));
      this.vBW = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_appbrand_cover_iv));
      this.vBX = ((ImageView)paramView.findViewById(R.h.error_icon_iv));
      this.vBY = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_nickname_tv));
      this.vBR = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_desc_tv));
      this.vDw = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_update_tv));
      this.vBS = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_appbrand_source_iv));
      this.vBT = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_source_tv));
      this.vBU = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_source_tag_tv));
      this.vDx = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_subscribe_tv));
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q
 * JD-Core Version:    0.7.0.1
 */