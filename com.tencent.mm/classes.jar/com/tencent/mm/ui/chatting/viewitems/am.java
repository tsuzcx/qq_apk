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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;

public final class am
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
      localObject = new ag(paramLayoutInflater, 2131493466);
      ((View)localObject).setTag(new a().gt((View)localObject));
    }
    AppMethodBeat.o(37310);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37311);
    a locala = (a)parama;
    com.tencent.mm.ah.k localk = ap.eLl().zN(parambo.field_msgId);
    String str = parambo.field_content;
    if ((localk != null) && (str != null))
    {
      paramString = k.b.az(str, parambo.field_reserved);
      parambo = new bj(parambo, parama1.foQ(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.cZX == 2) || (paramString.hiD == 2) || (paramString.hiD == 4)))
      {
        a.b.v(locala.iKw, paramString.hiH);
        locala.Ioz.setTextSize(0, parama1.HZF.getMMResources().getDimension(2131165517));
        locala.Ioz.setTextColor(parama1.HZF.getContext().getResources().getColor(2131100711));
        locala.Ioz.setEllipsize(TextUtils.TruncateAt.END);
        locala.Ioz.setSingleLine(true);
        locala.Ioz.setShouldEllipsize(true);
        locala.Ioz.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.HZF.getContext(), paramString.hiG));
      }
      parama.nDl.setOnLongClickListener(c(parama1));
      parama.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
      parama.nDl.setTag(parambo);
      parama.nDl.setOnClickListener(d(parama1));
      AppMethodBeat.o(37311);
      return;
    }
    if (localk == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.e("MicrMsg.ChattingItemHardDeviceMsgLike", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(parambo.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37312);
    paramContextMenu.add(((bj)paramView.getTag()).position, 100, 0, paramView.getContext().getString(2131757221));
    AppMethodBeat.o(37312);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bo parambo)
  {
    AppMethodBeat.i(37313);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37313);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bo parambo)
  {
    AppMethodBeat.i(37314);
    ac.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
    if (parambo == null)
    {
      ac.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
      AppMethodBeat.o(37314);
      return false;
    }
    String str = parambo.field_content;
    paramView = k.b.az(str, parambo.field_reserved);
    if (paramView == null)
    {
      ac.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
      AppMethodBeat.o(37314);
      return false;
    }
    ac.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!bs.isNullOrNil(paramView.url))
    {
      parambo = new Intent();
      parambo.putExtra("rawUrl", paramView.url);
      d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", parambo);
      AppMethodBeat.o(37314);
      return true;
    }
    az.ayM();
    if (com.tencent.mm.model.c.awB().aNt(paramView.hiH).aaI()) {
      ac.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
    }
    for (;;)
    {
      AppMethodBeat.o(37314);
      return false;
      if (paramView.cZX == 2)
      {
        if (!bs.isNullOrNil(paramView.hip))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_rank_info", str);
          localIntent.putExtra("key_rank_semi", parambo.field_reserved);
          localIntent.putExtra("key_rank_title", paramView.hiA);
          localIntent.putExtra("key_champion_info", paramView.hiB);
          localIntent.putExtra("key_champion_coverimg", paramView.hiB);
          localIntent.putExtra("rank_id", paramView.hip);
          localIntent.putExtra("app_username", paramView.appName);
          localIntent.putExtra("device_type", paramView.hiE);
          localIntent.putExtra("key_champioin_username", paramView.hiz);
          localIntent.putExtra("locate_to_username", paramView.hiH);
          d.b(parama.HZF.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sport.a.c.lA(30);
          break;
          parambo = new Intent();
          parambo.putExtra("key_is_latest", true);
          parambo.putExtra("app_username", paramView.appName);
          parambo.putExtra("device_type", paramView.hiE);
          parambo.putExtra("locate_to_username", paramView.hiH);
          d.b(parama.HZF.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", parambo);
        }
      }
      if (paramView.cZX == 4)
      {
        parambo = new Intent();
        parambo.putExtra("username", paramView.hiH);
        parambo.putExtra("app_username", "gh_43f2581f6fd6");
        d.b(parama.HZF.getContext(), "exdevice", ".ui.ExdeviceProfileUI", parambo);
        com.tencent.mm.plugin.sport.a.c.lA(29);
      }
    }
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048183;
  }
  
  public final boolean fqu()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected NoMeasuredTextView Ioz;
    protected ImageView iKw;
    
    a() {}
    
    public final a gt(View paramView)
    {
      AppMethodBeat.i(37309);
      super.fX(paramView);
      this.ijt = ((CheckBox)paramView.findViewById(2131298068));
      this.iKw = ((ImageView)paramView.findViewById(2131301412));
      this.Ioz = ((NoMeasuredTextView)paramView.findViewById(2131305875));
      AppMethodBeat.o(37309);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am
 * JD-Core Version:    0.7.0.1
 */