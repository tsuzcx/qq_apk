package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;

public final class al
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
      localObject = new af(paramLayoutInflater, 2131493466);
      ((View)localObject).setTag(new a().gg((View)localObject));
    }
    AppMethodBeat.o(37310);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37311);
    a locala = (a)parama;
    com.tencent.mm.ai.k localk = ap.evR().vk(parambl.field_msgId);
    String str = parambl.field_content;
    if ((localk != null) && (str != null))
    {
      paramString = k.b.ar(str, parambl.field_reserved);
      parambl = new bi(parambl, parama1.eZb(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.dcz == 2) || (paramString.gIc == 2) || (paramString.gIc == 4)))
      {
        a.b.v(locala.ikp, paramString.gIg);
        locala.GOx.setTextSize(0, parama1.GzJ.getMMResources().getDimension(2131165517));
        locala.GOx.setTextColor(parama1.GzJ.getContext().getResources().getColor(2131100711));
        locala.GOx.setEllipsize(TextUtils.TruncateAt.END);
        locala.GOx.setSingleLine(true);
        locala.GOx.setShouldEllipsize(true);
        locala.GOx.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.GzJ.getContext(), paramString.gIf));
      }
      parama.naN.setOnLongClickListener(c(parama1));
      parama.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
      parama.naN.setTag(parambl);
      parama.naN.setOnClickListener(d(parama1));
      AppMethodBeat.o(37311);
      return;
    }
    if (localk == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.e("MicrMsg.ChattingItemHardDeviceMsgLike", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(parambl.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37312);
    paramContextMenu.add(((bi)paramView.getTag()).position, 100, 0, paramView.getContext().getString(2131757221));
    AppMethodBeat.o(37312);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bl parambl)
  {
    AppMethodBeat.i(37313);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37313);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048183;
  }
  
  public final boolean b(View paramView, a parama, bl parambl)
  {
    AppMethodBeat.i(37314);
    ad.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
    if (parambl == null)
    {
      ad.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
      AppMethodBeat.o(37314);
      return false;
    }
    String str = parambl.field_content;
    paramView = k.b.ar(str, parambl.field_reserved);
    if (paramView == null)
    {
      ad.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
      AppMethodBeat.o(37314);
      return false;
    }
    ad.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!bt.isNullOrNil(paramView.url))
    {
      parambl = new Intent();
      parambl.putExtra("rawUrl", paramView.url);
      d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", parambl);
      AppMethodBeat.o(37314);
      return true;
    }
    az.arV();
    if (com.tencent.mm.model.c.apM().aHY(paramView.gIg).ZN()) {
      ad.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
    }
    for (;;)
    {
      AppMethodBeat.o(37314);
      return false;
      if (paramView.dcz == 2)
      {
        if (!bt.isNullOrNil(paramView.gHO))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_rank_info", str);
          localIntent.putExtra("key_rank_semi", parambl.field_reserved);
          localIntent.putExtra("key_rank_title", paramView.gHZ);
          localIntent.putExtra("key_champion_info", paramView.gIa);
          localIntent.putExtra("key_champion_coverimg", paramView.gIa);
          localIntent.putExtra("rank_id", paramView.gHO);
          localIntent.putExtra("app_username", paramView.appName);
          localIntent.putExtra("device_type", paramView.gId);
          localIntent.putExtra("key_champioin_username", paramView.gHY);
          localIntent.putExtra("locate_to_username", paramView.gIg);
          d.b(parama.GzJ.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sport.a.c.lI(30);
          break;
          parambl = new Intent();
          parambl.putExtra("key_is_latest", true);
          parambl.putExtra("app_username", paramView.appName);
          parambl.putExtra("device_type", paramView.gId);
          parambl.putExtra("locate_to_username", paramView.gIg);
          d.b(parama.GzJ.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", parambl);
        }
      }
      if (paramView.dcz == 4)
      {
        parambl = new Intent();
        parambl.putExtra("username", paramView.gIg);
        parambl.putExtra("app_username", "gh_43f2581f6fd6");
        d.b(parama.GzJ.getContext(), "exdevice", ".ui.ExdeviceProfileUI", parambl);
        com.tencent.mm.plugin.sport.a.c.lI(29);
      }
    }
  }
  
  public final boolean faE()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected NoMeasuredTextView GOx;
    protected ImageView ikp;
    
    a() {}
    
    public final a gg(View paramView)
    {
      AppMethodBeat.i(37309);
      super.fK(paramView);
      this.hIS = ((CheckBox)paramView.findViewById(2131298068));
      this.ikp = ((ImageView)paramView.findViewById(2131301412));
      this.GOx = ((NoMeasuredTextView)paramView.findViewById(2131305875));
      AppMethodBeat.o(37309);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al
 * JD-Core Version:    0.7.0.1
 */