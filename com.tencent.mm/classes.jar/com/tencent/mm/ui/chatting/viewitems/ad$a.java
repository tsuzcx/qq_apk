package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.c;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

public final class ad$a
  extends c
{
  private a vko;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(R.i.chatting_item_from_mail, null);
      paramLayoutInflater = new ad.b();
      paramLayoutInflater.dsz = ((TextView)localView.findViewById(R.h.chatting_time_tv));
      paramLayoutInflater.nSa = ((TextView)localView.findViewById(R.h.chatting_user_tv));
      paramLayoutInflater.vCQ = ((ImageView)localView.findViewById(R.h.chatting_mail_attach_iv));
      paramLayoutInflater.vFe = ((TextView)localView.findViewById(R.h.chatting_title_itv));
      paramLayoutInflater.vEC = ((TextView)localView.findViewById(R.h.chatting_content_itv));
      paramLayoutInflater.igg = localView.findViewById(R.h.chatting_click_area);
      localView.setTag(paramLayoutInflater);
    }
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    parama = (ad.b)parama;
    au.Hx();
    paramString = com.tencent.mm.model.c.Fy().HL(parambi.field_content);
    parama.vFe.setText(paramString.title);
    parama.vEC.setText(paramString.content);
    a(parama, paramString.eyU);
    ImageView localImageView = parama.vCQ;
    if (paramString.kjj) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      parama.igg.setTag(new aw(parambi, parama1.cFE(), paramInt, null, '\000'));
      parama.igg.setOnClickListener(d(parama1));
      parama.igg.setOnLongClickListener(c(parama1));
      parama.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
      return;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    int i = ((aw)paramView.getTag()).position;
    if (!this.vko.cFF()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
    }
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return paramInt == 35;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    paramView = (aw)paramView.getTag();
    au.Hx();
    parambi = com.tencent.mm.model.c.Fy().HL(paramView.bWO.field_content);
    if (ah.pm(parambi.nds).length() > 0) {
      d.b(parama.vtz.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", paramView.bWO.field_msgId));
    }
    for (;;)
    {
      return true;
      if (ah.pm(parambi.uCi).length() > 0)
      {
        paramView = new Intent("android.intent.action.VIEW", Uri.parse(parambi.uCi));
        d.b(parama.vtz.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      }
    }
  }
  
  public final boolean bfO()
  {
    return false;
  }
  
  protected final boolean cHb()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.a
 * JD-Core Version:    0.7.0.1
 */