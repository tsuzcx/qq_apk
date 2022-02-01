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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;

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
      localObject = new aq(paramLayoutInflater, R.i.edx);
      ((View)localObject).setTag(new a().ir((View)localObject));
    }
    AppMethodBeat.o(37310);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37311);
    a locala = (a)parama;
    com.tencent.mm.aj.k localk = ao.hhH().NR(paramca.field_msgId);
    String str = paramca.field_content;
    if ((localk != null) && (str != null))
    {
      paramString = k.b.aG(str, paramca.field_reserved);
      paramca = new by(paramca, parama1.hRi(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.fwp == 2) || (paramString.lmU == 2) || (paramString.lmU == 4)))
      {
        a.b.B(locala.mWb, paramString.lmY);
        locala.Xkc.setTextSize(0, parama1.WQv.getMMResources().getDimension(R.f.NormalTextSize));
        locala.Xkc.setTextColor(parama1.WQv.getContext().getResources().getColor(R.e.normal_text_color));
        locala.Xkc.setEllipsize(TextUtils.TruncateAt.END);
        locala.Xkc.setSingleLine(true);
        locala.Xkc.setShouldEllipsize(true);
        locala.Xkc.setText(com.tencent.mm.pluginsdk.ui.span.l.c(parama1.WQv.getContext(), paramString.lmX));
      }
      parama.clickArea.setOnLongClickListener(c(parama1));
      parama.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
      parama.clickArea.setTag(paramca);
      parama.clickArea.setOnClickListener(d(parama1));
      AppMethodBeat.o(37311);
      return;
    }
    if (localk == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.e("MicrMsg.ChattingItemHardDeviceMsgLike", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), Util.secPrint(str), Long.valueOf(paramca.field_msgId), paramString });
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
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(278299);
    paramo.a(((by)paramView.getTag()).position, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
    AppMethodBeat.o(278299);
    return false;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
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
    paramView = k.b.aG(str, paramca.field_reserved);
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
      com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
      AppMethodBeat.o(37314);
      return true;
    }
    bh.beI();
    if (com.tencent.mm.model.c.bbL().RG(paramView.lmY).ayd()) {
      Log.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
    }
    for (;;)
    {
      AppMethodBeat.o(37314);
      return false;
      if (paramView.fwp == 2)
      {
        if (!Util.isNullOrNil(paramView.lmG))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_rank_info", str);
          localIntent.putExtra("key_rank_semi", paramca.field_reserved);
          localIntent.putExtra("key_rank_title", paramView.lmR);
          localIntent.putExtra("key_champion_info", paramView.lmS);
          localIntent.putExtra("key_champion_coverimg", paramView.lmS);
          localIntent.putExtra("rank_id", paramView.lmG);
          localIntent.putExtra("app_username", paramView.appName);
          localIntent.putExtra("device_type", paramView.lmV);
          localIntent.putExtra("key_champioin_username", paramView.lmQ);
          localIntent.putExtra("locate_to_username", paramView.lmY);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        }
        for (;;)
        {
          d.rE(30);
          break;
          paramca = new Intent();
          paramca.putExtra("key_is_latest", true);
          paramca.putExtra("app_username", paramView.appName);
          paramca.putExtra("device_type", paramView.lmV);
          paramca.putExtra("locate_to_username", paramView.lmY);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", paramca);
        }
      }
      if (paramView.fwp == 4)
      {
        paramca = new Intent();
        paramca.putExtra("username", paramView.lmY);
        paramca.putExtra("app_username", "gh_43f2581f6fd6");
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "exdevice", ".ui.ExdeviceProfileUI", paramca);
        d.rE(29);
      }
    }
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected NoMeasuredTextView Xkc;
    protected ImageView mWb;
    
    a() {}
    
    public final a ir(View paramView)
    {
      AppMethodBeat.i(37309);
      super.create(paramView);
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.mWb = ((ImageView)paramView.findViewById(R.h.dLj));
      this.Xkc = ((NoMeasuredTextView)paramView.findViewById(R.h.dXt));
      AppMethodBeat.o(37309);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax
 * JD-Core Version:    0.7.0.1
 */