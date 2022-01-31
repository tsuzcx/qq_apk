package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;

public final class aa
  extends c
{
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_harddevice_push);
      ((View)localObject).setTag(new aa.a(this).ea((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    aa.a locala = (aa.a)parama;
    com.tencent.mm.ae.g localg = ap.clc().gZ(parambi.field_msgId);
    String str = parambi.field_content;
    if ((localg != null) && (str != null))
    {
      paramString = g.a.M(str, parambi.field_reserved);
      parambi = new aw(parambi, parama1.cFE(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.showType == 3) || (paramString.dRw == 3)))
      {
        locala.ffK.setImageResource(R.g.hard_device_rank_icon);
        locala.vEU.setText(paramString.dRB);
      }
      parama.igg.setOnLongClickListener(c(parama1));
      parama.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
      parama.igg.setTag(parambi);
      return;
    }
    if (localg == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.e("MicroMsg.ChattingItemHardDeviceMsgPush", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(parambi.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    paramContextMenu.add(((aw)paramView.getTag()).position, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return false;
      parama = parambi.field_content;
      paramMenuItem = null;
      if (parama != null) {
        paramMenuItem = g.a.gp(parama);
      }
      if (paramMenuItem != null) {
        l.ha(parambi.field_msgId);
      }
      bd.bC(parambi.field_msgId);
    }
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048176;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa
 * JD-Core Version:    0.7.0.1
 */