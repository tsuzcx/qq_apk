package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R.f;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

public final class z
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_harddevice_like);
      ((View)localObject).setTag(new z.a(this).dZ((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    z.a locala = (z.a)parama;
    com.tencent.mm.ae.g localg = ap.clc().gZ(parambi.field_msgId);
    String str = parambi.field_content;
    if ((localg != null) && (str != null))
    {
      paramString = g.a.M(str, parambi.field_reserved);
      parambi = new aw(parambi, parama1.cFE(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.showType == 2) || (paramString.dRw == 2) || (paramString.dRw == 4)))
      {
        a.b.o(locala.ffK, paramString.dRA);
        locala.vES.setTextSize(0, parama1.vtz.getMMResources().getDimension(R.f.NormalTextSize));
        locala.vES.setTextColor(Color.parseColor("#BF000000"));
        locala.vES.setEllipsize(TextUtils.TruncateAt.END);
        locala.vES.setSingleLine(true);
        locala.vES.setShouldEllipsize(true);
        locala.vES.setText(j.b(parama1.vtz.getContext(), paramString.dRz));
      }
      parama.igg.setOnLongClickListener(c(parama1));
      parama.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
      parama.igg.setTag(parambi);
      parama.igg.setOnClickListener(d(parama1));
      return;
    }
    if (localg == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.e("MicrMsg.ChattingItemHardDeviceMsgLike", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(parambi.field_msgId), paramString });
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
      com.tencent.mm.model.bd.bC(parambi.field_msgId);
    }
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048183;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    y.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
    if (parambi == null) {
      y.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
    }
    do
    {
      return false;
      String str = parambi.field_content;
      paramView = g.a.M(str, parambi.field_reserved);
      if (paramView == null)
      {
        y.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
        return false;
      }
      y.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", new Object[] { paramView.url });
      if (!ah.bl(paramView.url))
      {
        parambi = new Intent();
        parambi.putExtra("rawUrl", paramView.url);
        com.tencent.mm.br.d.b(parama.vtz.getContext(), "webview", ".ui.tools.WebViewUI", parambi);
        return true;
      }
      au.Hx();
      if (com.tencent.mm.model.c.Fw().abl(paramView.dRA).Bh())
      {
        y.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
        return false;
      }
      if (paramView.showType == 2)
      {
        if (!ah.bl(paramView.dRj))
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
          localIntent.putExtra("locate_to_username", paramView.dRA);
          com.tencent.mm.br.d.b(parama.vtz.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sport.b.d.jdMethod_if(30);
          return false;
          parambi = new Intent();
          parambi.putExtra("key_is_latest", true);
          parambi.putExtra("app_username", paramView.appName);
          parambi.putExtra("device_type", paramView.dRx);
          parambi.putExtra("locate_to_username", paramView.dRA);
          com.tencent.mm.br.d.b(parama.vtz.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", parambi);
        }
      }
    } while (paramView.showType != 4);
    parambi = new Intent();
    parambi.putExtra("username", paramView.dRA);
    parambi.putExtra("app_username", "gh_43f2581f6fd6");
    com.tencent.mm.br.d.b(parama.vtz.getContext(), "exdevice", ".ui.ExdeviceProfileUI", parambi);
    com.tencent.mm.plugin.sport.b.d.jdMethod_if(29);
    return false;
  }
  
  public final boolean bfO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z
 * JD-Core Version:    0.7.0.1
 */