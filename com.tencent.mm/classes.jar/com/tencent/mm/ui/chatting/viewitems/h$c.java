package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class h$c
  extends c
  implements t.m
{
  private a vko;
  
  private static String adH(String paramString)
  {
    try
    {
      paramString = g.a.gp(paramString);
      if (paramString != null)
      {
        paramString = URLDecoder.decode(paramString.content, "UTF-8");
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", new Object[] { paramString.getMessage() });
    }
    return "";
  }
  
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_text_c2c);
      ((View)localObject).setTag(new h.a().s((View)localObject, false));
    }
    return localObject;
  }
  
  public final void a(a parama, bi parambi)
  {
    if (parambi.aVK())
    {
      l.ae(parambi);
      bd.bC(parambi.field_msgId);
      parama.cCW();
    }
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    parama = (h.a)parama;
    if (cHc())
    {
      if (parama.nhQ != null) {
        parama.nhQ.setVisibility(8);
      }
      if ((parambi.field_status == 1) || (parambi.field_status == 5))
      {
        if (parama.vBN != null) {
          parama.vBN.setVisibility(8);
        }
        parama.vCB.setBackgroundResource(R.g.chatto_bg_alpha);
        parambi.uBR = true;
      }
    }
    while (parama.nhQ == null) {
      for (;;)
      {
        paramString = adH(parambi.field_content);
        if (bk.bl(paramString)) {
          y.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", new Object[] { Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_msgSvrId) });
        }
        parama.vCB.setMinWidth(0);
        parama.vCB.setText(paramString);
        paramString = parama.vCB;
        i = parambi.getType();
        String str = parama1.getTalkerUserName();
        if (i != 301989937) {
          j.a(paramString, str);
        }
        paramString.getText();
        paramString = aw.b(parambi, parama1.cFE(), paramInt);
        parama.vCB.setTag(paramString);
        parama.vCB.setOnLongClickListener(c(parama1));
        parama.vCB.setOnDoubleClickLitsener(((g)parama1.ac(g.class)).cDt());
        a(paramInt, parama, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
        return;
        parama.vCB.setBackgroundResource(R.g.chatto_bg);
        if (parama.vBN != null) {
          if (a((g)parama1.ac(g.class), parambi.field_msgId))
          {
            if (parambi.uBR)
            {
              paramString = new AlphaAnimation(0.5F, 1.0F);
              paramString.setDuration(300L);
              parama.vCB.startAnimation(paramString);
              parambi.uBR = false;
            }
            parama.vBN.setVisibility(0);
          }
          else
          {
            parama.vBN.setVisibility(8);
          }
        }
      }
    }
    paramString = parama.nhQ;
    if (parambi.field_status >= 2) {}
    for (int i = 8;; i = 0)
    {
      paramString.setVisibility(i);
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
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 503316529);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean bfO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h.c
 * JD-Core Version:    0.7.0.1
 */