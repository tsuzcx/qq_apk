package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;

public final class ao
  extends c
{
  private f eBv;
  private ao.a vGL;
  private a vko;
  
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_voiceremind_sys);
      ((View)localObject).setTag(new bd().ee((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    bd localbd = (bd)parama;
    this.vko = parama1;
    Object localObject2 = ap.clc().gZ(parambi.field_msgId);
    Object localObject1 = parambi.field_content;
    paramString = null;
    parama = paramString;
    if (localObject2 != null)
    {
      parama = paramString;
      if (localObject1 != null) {
        parama = g.a.M((String)localObject1, parambi.field_reserved);
      }
    }
    if (parama != null) {
      localbd.eXP.setText(parama.description);
    }
    y.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + parambi.field_content);
    localObject1 = com.tencent.mm.plugin.subapp.c.e.PA((String)localObject1);
    if ((localObject1 != null) && (((com.tencent.mm.plugin.subapp.c.e)localObject1).pvI != null) && (((com.tencent.mm.plugin.subapp.c.e)localObject1).pvI.length() > 0) && (((com.tencent.mm.plugin.subapp.c.e)localObject1).pvJ > 0) && (this.eBv == null) && (parama != null) && (bk.bl(parambi.field_imgPath)))
    {
      localObject2 = com.tencent.mm.plugin.subapp.c.k.nR(q.Gj());
      paramString = h.bh((String)localObject2, false);
      parambi.ed((String)localObject2);
      au.Hx();
      com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
      long l = parambi.field_msgId;
      int i = parama.sdkVer;
      localObject2 = parama.appId;
      String str = ((com.tencent.mm.plugin.subapp.c.e)localObject1).pvI;
      int j = ((com.tencent.mm.plugin.subapp.c.e)localObject1).pvJ;
      int k = parama.type;
      localObject1 = parama.dQR;
      parama = l.a(paramString, l, i, (String)localObject2, str, j, k, parama.dQz);
      if (parama != null)
      {
        paramString = au.Dk();
        localObject1 = new ao.1(this, parambi, parama, paramInt);
        this.eBv = ((f)localObject1);
        paramString.a(221, (f)localObject1);
        parama = new ac(parama);
        parama.ckX();
        au.Dk().a(parama, 0);
      }
    }
    localbd.eXP.setTag(new aw(parambi, parama1.cFE(), paramInt, null, '\000'));
    parama = localbd.eXP;
    if (this.vGL == null) {
      this.vGL = new ao.a(this, this.vko);
    }
    parama.setOnClickListener(this.vGL);
    au.Hx();
    if (com.tencent.mm.model.c.isSDCardAvailable()) {
      localbd.eXP.setOnLongClickListener(c(parama1));
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    if (!this.vko.cFF()) {
      paramContextMenu.add(i, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
    }
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    parama = parambi.field_content;
    paramMenuItem = null;
    if (parama != null) {
      paramMenuItem = g.a.gp(parama);
    }
    if (paramMenuItem != null) {
      l.ha(parambi.field_msgId);
    }
    com.tencent.mm.model.bd.bC(parambi.field_msgId);
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048191;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return true;
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao
 * JD-Core Version:    0.7.0.1
 */