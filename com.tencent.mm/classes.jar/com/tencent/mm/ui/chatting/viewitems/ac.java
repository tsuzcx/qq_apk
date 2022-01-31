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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;

public final class ac
  extends c
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33219);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969093);
      ((View)localObject).setTag(new ac.a(this).fn((View)localObject));
    }
    AppMethodBeat.o(33219);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33220);
    ac.a locala = (ac.a)parama;
    com.tencent.mm.af.j localj = al.dlL().nx(parambi.field_msgId);
    String str = parambi.field_content;
    if ((localj != null) && (str != null))
    {
      paramString = j.b.ab(str, parambi.field_reserved);
      parambi = new az(parambi, parama1.dJG(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.showType == 2) || (paramString.fhv == 2) || (paramString.fhv == 4)))
      {
        a.b.t(locala.gxs, paramString.fhz);
        locala.zWg.setTextSize(0, parama1.zJz.getMMResources().getDimension(2131427809));
        locala.zWg.setTextColor(Color.parseColor("#BF000000"));
        locala.zWg.setEllipsize(TextUtils.TruncateAt.END);
        locala.zWg.setSingleLine(true);
        locala.zWg.setShouldEllipsize(true);
        locala.zWg.setText(com.tencent.mm.pluginsdk.ui.d.j.b(parama1.zJz.getContext(), paramString.fhy));
      }
      parama.jYu.setOnLongClickListener(c(parama1));
      parama.jYu.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
      parama.jYu.setTag(parambi);
      parama.jYu.setOnClickListener(d(parama1));
      AppMethodBeat.o(33220);
      return;
    }
    if (localj == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.e("MicrMsg.ChattingItemHardDeviceMsgLike", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(parambi.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33221);
    paramContextMenu.add(((az)paramView.getTag()).position, 100, 0, paramView.getContext().getString(2131298232));
    AppMethodBeat.o(33221);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    AppMethodBeat.i(33222);
    paramMenuItem.getItemId();
    AppMethodBeat.o(33222);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048183;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    AppMethodBeat.i(33223);
    ab.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
    if (parambi == null)
    {
      ab.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
      AppMethodBeat.o(33223);
      return false;
    }
    String str = parambi.field_content;
    paramView = j.b.ab(str, parambi.field_reserved);
    if (paramView == null)
    {
      ab.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
      AppMethodBeat.o(33223);
      return false;
    }
    ab.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!ah.isNullOrNil(paramView.url))
    {
      parambi = new Intent();
      parambi.putExtra("rawUrl", paramView.url);
      com.tencent.mm.bq.d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", parambi);
      AppMethodBeat.o(33223);
      return true;
    }
    aw.aaz();
    if (com.tencent.mm.model.c.YA().arw(paramView.fhz).NX()) {
      ab.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
    }
    for (;;)
    {
      AppMethodBeat.o(33223);
      return false;
      if (paramView.showType == 2)
      {
        if (!ah.isNullOrNil(paramView.fhi))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_rank_info", str);
          localIntent.putExtra("key_rank_semi", parambi.field_reserved);
          localIntent.putExtra("key_rank_title", paramView.fhs);
          localIntent.putExtra("key_champion_info", paramView.fht);
          localIntent.putExtra("key_champion_coverimg", paramView.fht);
          localIntent.putExtra("rank_id", paramView.fhi);
          localIntent.putExtra("app_username", paramView.appName);
          localIntent.putExtra("device_type", paramView.fhw);
          localIntent.putExtra("key_champioin_username", paramView.fhr);
          localIntent.putExtra("locate_to_username", paramView.fhz);
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sport.a.d.kS(30);
          break;
          parambi = new Intent();
          parambi.putExtra("key_is_latest", true);
          parambi.putExtra("app_username", paramView.appName);
          parambi.putExtra("device_type", paramView.fhw);
          parambi.putExtra("locate_to_username", paramView.fhz);
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", parambi);
        }
      }
      if (paramView.showType == 4)
      {
        parambi = new Intent();
        parambi.putExtra("username", paramView.fhz);
        parambi.putExtra("app_username", "gh_43f2581f6fd6");
        com.tencent.mm.bq.d.b(parama.zJz.getContext(), "exdevice", ".ui.ExdeviceProfileUI", parambi);
        com.tencent.mm.plugin.sport.a.d.kS(29);
      }
    }
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac
 * JD-Core Version:    0.7.0.1
 */