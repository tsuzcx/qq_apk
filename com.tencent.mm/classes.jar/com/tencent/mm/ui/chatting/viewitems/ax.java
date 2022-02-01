package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.d.a;

public final class ax
  extends c
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37310);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ggn);
      ((View)localObject).setTag(new a().lO((View)localObject));
    }
    AppMethodBeat.o(37310);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37311);
    a locala = (a)parama;
    k localk = as.iIJ().rI(paramcc.field_msgId);
    String str = paramcc.field_content;
    if ((localk != null) && (str != null))
    {
      paramString = k.b.aP(str, paramcc.field_reserved);
      paramcc = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.hAN == 2) || (paramString.nRZ == 2) || (paramString.nRZ == 4)))
      {
        a.b.B(locala.avatar, paramString.nSd);
        locala.aeUN.setTextSize(0, parama1.aezO.getMMResources().getDimension(R.f.NormalTextSize));
        locala.aeUN.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.normal_text_color));
        locala.aeUN.setEllipsize(TextUtils.TruncateAt.END);
        locala.aeUN.setSingleLine(true);
        locala.aeUN.setShouldEllipsize(true);
        locala.aeUN.setText(p.b(parama1.aezO.getContext(), paramString.nSc));
      }
      parama.clickArea.setOnLongClickListener(c(parama1));
      parama.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
      parama.clickArea.setTag(paramcc);
      parama.clickArea.setOnClickListener(d(parama1));
      AppMethodBeat.o(37311);
      return;
    }
    if (localk == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.e("MicrMsg.ChattingItemHardDeviceMsgLike", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), Util.secPrint(str), Long.valueOf(paramcc.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
  {
    AppMethodBeat.i(37313);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37313);
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255146);
    params.a(((bz)paramView.getTag()).position, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
    AppMethodBeat.o(255146);
    return false;
  }
  
  public final boolean c(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(37314);
    Log.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
    if (paramcc == null)
    {
      Log.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
      AppMethodBeat.o(37314);
      return false;
    }
    String str = paramcc.field_content;
    paramView = k.b.aP(str, paramcc.field_reserved);
    if (paramView == null)
    {
      Log.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
      AppMethodBeat.o(37314);
      return false;
    }
    Log.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!Util.isNullOrNil(paramView.url))
    {
      paramcc = new Intent();
      paramcc.putExtra("rawUrl", paramView.url);
      com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramcc);
      AppMethodBeat.o(37314);
      return true;
    }
    bh.bCz();
    if (com.tencent.mm.model.c.bzA().JE(paramView.nSd).aSG()) {
      Log.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
    }
    for (;;)
    {
      AppMethodBeat.o(37314);
      return false;
      if (paramView.hAN == 2)
      {
        if (!Util.isNullOrNil(paramView.nRL))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_rank_info", str);
          localIntent.putExtra("key_rank_semi", paramcc.field_reserved);
          localIntent.putExtra("key_rank_title", paramView.nRW);
          localIntent.putExtra("key_champion_info", paramView.nRX);
          localIntent.putExtra("key_champion_coverimg", paramView.nRX);
          localIntent.putExtra("rank_id", paramView.nRL);
          localIntent.putExtra("app_username", paramView.appName);
          localIntent.putExtra("device_type", paramView.nSa);
          localIntent.putExtra("key_champioin_username", paramView.nRV);
          localIntent.putExtra("locate_to_username", paramView.nSd);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        }
        for (;;)
        {
          d.rG(30);
          break;
          paramcc = new Intent();
          paramcc.putExtra("key_is_latest", true);
          paramcc.putExtra("app_username", paramView.appName);
          paramcc.putExtra("device_type", paramView.nSa);
          paramcc.putExtra("locate_to_username", paramView.nSd);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", paramcc);
        }
      }
      if (paramView.hAN == 4)
      {
        paramcc = new Intent();
        paramcc.putExtra("username", paramView.nSd);
        paramcc.putExtra("app_username", "gh_43f2581f6fd6");
        com.tencent.mm.br.c.b(parama.aezO.getContext(), "exdevice", ".ui.ExdeviceProfileUI", paramcc);
        d.rG(29);
      }
    }
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048183;
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected NoMeasuredTextView aeUN;
    protected ImageView avatar;
    
    a() {}
    
    public final a lO(View paramView)
    {
      AppMethodBeat.i(37309);
      super.create(paramView);
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
      this.avatar = ((ImageView)paramView.findViewById(R.h.fMO));
      this.aeUN = ((NoMeasuredTextView)paramView.findViewById(R.h.fZY));
      AppMethodBeat.o(37309);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax
 * JD-Core Version:    0.7.0.1
 */