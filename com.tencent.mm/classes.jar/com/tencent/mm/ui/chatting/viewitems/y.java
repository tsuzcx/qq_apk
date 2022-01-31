package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.HardDeviceChattingItemView;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

public final class y
  extends c
{
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_harddevice_msg);
      ((View)localObject).setTag(new y.a(this).dY((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    y.a locala = (y.a)parama;
    Object localObject1 = ap.clc().gZ(parambi.field_msgId);
    Object localObject2 = parambi.field_content;
    if ((localObject1 != null) && (localObject2 != null)) {
      paramString = g.a.M((String)localObject2, parambi.field_reserved);
    }
    for (;;)
    {
      aw localaw = new aw(parambi, parama1.cFE(), paramInt, null, '\000');
      HardDeviceChattingItemView localHardDeviceChattingItemView = (HardDeviceChattingItemView)parama.igg;
      int j;
      int k;
      int i;
      if ((paramString != null) && ((paramString.showType == 1) || (paramString.dRw == 1))) {
        if (ah.bl(paramString.dRr))
        {
          localObject2 = paramString.color;
          Object localObject3 = paramString.dRo;
          if (!bk.bl((String)localObject2))
          {
            localObject1 = localObject3;
            parambi = (bi)localObject2;
            if (!bk.bl((String)localObject3)) {}
          }
          else
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", new Object[] { localObject2, localObject3 });
            parambi = "#ffffff";
            localObject1 = "#ffffff";
          }
          localObject2 = new StateListDrawable();
          localObject3 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject3);
          localObject1 = new ColorDrawable(Color.parseColor((String)localObject1));
          ((StateListDrawable)localObject2).addState(new int[] { 16842908 }, (Drawable)localObject1);
          localObject1 = new ColorDrawable(Color.parseColor(parambi));
          ((StateListDrawable)localObject2).addState(new int[] { 16842766 }, (Drawable)localObject1);
          parambi = new ColorDrawable(Color.parseColor(parambi));
          ((StateListDrawable)localObject2).addState(new int[0], parambi);
          localHardDeviceChattingItemView.setBackgroundDrawable((Drawable)localObject2);
          paramString.dRr = "#ffffff";
          parambi = paramString.dRp;
          localObject1 = paramString.dRq;
          j = R.e.white;
          k = R.e.white;
          i = k;
          paramInt = j;
          if (!ah.bl(parambi))
          {
            i = k;
            paramInt = j;
            if (!ah.bl((String)localObject1)) {
              paramInt = j;
            }
          }
        }
      }
      try
      {
        i = Color.parseColor(parambi);
        paramInt = i;
        j = Color.parseColor((String)localObject1);
        paramInt = i;
        i = j;
        parambi = new StateListDrawable();
        localObject1 = new ColorDrawable(i);
        parambi.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(i);
        parambi.addState(new int[] { 16842908 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        parambi.addState(new int[] { 16842766 }, (Drawable)localObject1);
        localObject1 = new ColorDrawable(paramInt);
        parambi.addState(new int[0], (Drawable)localObject1);
        locala.vEP.setBackgroundDrawable(parambi);
        parambi = paramString.dRr;
        if (locala != null)
        {
          i = R.e.white;
          paramInt = i;
          if (ah.bl(parambi)) {}
        }
      }
      catch (IllegalArgumentException parambi)
      {
        try
        {
          paramInt = Color.parseColor(parambi);
          locala.vEM.setTextColor(paramInt);
          locala.vEN.setTextColor(paramInt);
          locala.vEK.setTextColor(paramInt);
          locala.vEL.setTextColor(paramInt);
          locala.vEO.setTextColor(paramInt);
          locala.vEM.setText(paramString.dRk);
          locala.vEN.setText(paramString.dRi);
          locala.vEK.setText(paramString.dRm);
          locala.vEL.setText(paramString.dRl);
          locala.vEO.setText(paramString.dRn);
          if (!ah.bl(paramString.dRs))
          {
            locala.vEQ.setVisibility(0);
            a.b.o(locala.vEQ, paramString.dRs);
            parama.igg.setOnLongClickListener(c(parama1));
            parama.igg.setOnTouchListener(((g)parama1.ac(g.class)).cDu());
            parama.igg.setTag(localaw);
            parama.igg.setOnClickListener(d(parama1));
            return;
            if (localObject1 == null) {}
            for (boolean bool = true;; bool = false)
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.ChattingItemHardDeviceMsg", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), localObject2, Long.valueOf(parambi.field_msgId), paramString });
              paramString = null;
              break;
            }
            parambi = parambi;
            com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
            i = k;
          }
        }
        catch (IllegalArgumentException parambi)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.y.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
            paramInt = i;
            continue;
            locala.vEQ.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    paramContextMenu.add(((aw)paramView.getTag()).position, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
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
    return paramInt == -1879048185;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    int i = 0;
    String str = parambi.field_content;
    paramView = g.a.M(str, parambi.field_reserved);
    if (paramView == null)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
      return false;
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!ah.bl(paramView.url))
    {
      parambi = new Intent();
      parambi.putExtra("rawUrl", paramView.url);
      com.tencent.mm.br.d.b(parama.vtz.getContext(), "webview", ".ui.tools.WebViewUI", parambi);
      return true;
    }
    if (!ah.bl(paramView.dRj))
    {
      int j = paramView.dRy;
      if (System.currentTimeMillis() - j * 1000L >= 2592000000L) {
        i = 1;
      }
      if (i == 0)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_rank_info", str);
        localIntent.putExtra("key_rank_semi", parambi.field_reserved);
        localIntent.putExtra("key_rank_title", paramView.dRt);
        localIntent.putExtra("key_champion_info", paramView.dRu);
        localIntent.putExtra("key_champion_coverimg", paramView.dRu);
        localIntent.putExtra("rank_id", paramView.dRj);
        localIntent.putExtra("app_username", paramView.appName);
        localIntent.putExtra("device_type", paramView.dRx);
        localIntent.putExtra("key_champioin_username", paramView.dRs);
        com.tencent.mm.br.d.b(parama.vtz.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        com.tencent.mm.plugin.sport.b.d.jdMethod_if(28);
      }
    }
    for (;;)
    {
      return true;
      com.tencent.mm.br.d.x(parama.vtz.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
    }
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y
 * JD-Core Version:    0.7.0.1
 */