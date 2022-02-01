package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;

public final class at
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
      localObject = new an(paramLayoutInflater, 2131493568);
      ((View)localObject).setTag(new a().hf((View)localObject));
    }
    AppMethodBeat.o(37310);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37311);
    a locala = (a)parama;
    com.tencent.mm.ag.k localk = ao.gnf().GL(paramca.field_msgId);
    String str = paramca.field_content;
    if ((localk != null) && (str != null))
    {
      paramString = k.b.aD(str, paramca.field_reserved);
      paramca = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.dDG == 2) || (paramString.ixF == 2) || (paramString.ixF == 4)))
      {
        a.b.z(locala.keC, paramString.ixJ);
        locala.POa.setTextSize(0, parama1.Pwc.getMMResources().getDimension(2131165535));
        locala.POa.setTextColor(parama1.Pwc.getContext().getResources().getColor(2131100904));
        locala.POa.setEllipsize(TextUtils.TruncateAt.END);
        locala.POa.setSingleLine(true);
        locala.POa.setShouldEllipsize(true);
        locala.POa.setText(com.tencent.mm.pluginsdk.ui.span.l.c(parama1.Pwc.getContext(), paramString.ixI));
      }
      parama.clickArea.setOnLongClickListener(c(parama1));
      parama.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
      parama.clickArea.setTag(paramca);
      parama.clickArea.setOnClickListener(d(parama1));
      AppMethodBeat.o(37311);
      return;
    }
    if (localk == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.e("MicrMsg.ChattingItemHardDeviceMsgLike", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(paramca.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(37313);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37313);
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233908);
    paramm.a(((bq)paramView.getTag()).position, 100, paramView.getContext().getString(2131757433), 2131690529);
    AppMethodBeat.o(233908);
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048183;
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(37314);
    Log.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
    if (paramca == null)
    {
      Log.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
      AppMethodBeat.o(37314);
      return false;
    }
    String str = paramca.field_content;
    paramView = k.b.aD(str, paramca.field_reserved);
    if (paramView == null)
    {
      Log.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
      AppMethodBeat.o(37314);
      return false;
    }
    Log.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!Util.isNullOrNil(paramView.url))
    {
      paramca = new Intent();
      paramca.putExtra("rawUrl", paramView.url);
      com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
      AppMethodBeat.o(37314);
      return true;
    }
    bg.aVF();
    if (com.tencent.mm.model.c.aSN().Kn(paramView.ixJ).arz()) {
      Log.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
    }
    for (;;)
    {
      AppMethodBeat.o(37314);
      return false;
      if (paramView.dDG == 2)
      {
        if (!Util.isNullOrNil(paramView.ixr))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_rank_info", str);
          localIntent.putExtra("key_rank_semi", paramca.field_reserved);
          localIntent.putExtra("key_rank_title", paramView.ixC);
          localIntent.putExtra("key_champion_info", paramView.ixD);
          localIntent.putExtra("key_champion_coverimg", paramView.ixD);
          localIntent.putExtra("rank_id", paramView.ixr);
          localIntent.putExtra("app_username", paramView.appName);
          localIntent.putExtra("device_type", paramView.ixG);
          localIntent.putExtra("key_champioin_username", paramView.ixB);
          localIntent.putExtra("locate_to_username", paramView.ixJ);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sport.a.c.pl(30);
          break;
          paramca = new Intent();
          paramca.putExtra("key_is_latest", true);
          paramca.putExtra("app_username", paramView.appName);
          paramca.putExtra("device_type", paramView.ixG);
          paramca.putExtra("locate_to_username", paramView.ixJ);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", paramca);
        }
      }
      if (paramView.dDG == 4)
      {
        paramca = new Intent();
        paramca.putExtra("username", paramView.ixJ);
        paramca.putExtra("app_username", "gh_43f2581f6fd6");
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "exdevice", ".ui.ExdeviceProfileUI", paramca);
        com.tencent.mm.plugin.sport.a.c.pl(29);
      }
    }
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected NoMeasuredTextView POa;
    protected ImageView keC;
    
    a() {}
    
    public final a hf(View paramView)
    {
      AppMethodBeat.i(37309);
      super.create(paramView);
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.keC = ((ImageView)paramView.findViewById(2131303171));
      this.POa = ((NoMeasuredTextView)paramView.findViewById(2131309157));
      AppMethodBeat.o(37309);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at
 * JD-Core Version:    0.7.0.1
 */