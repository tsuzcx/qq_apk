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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;

public final class an
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
      localObject = new ah(paramLayoutInflater, 2131493466);
      ((View)localObject).setTag(new a().gK((View)localObject));
    }
    AppMethodBeat.o(37310);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37311);
    a locala = (a)parama;
    com.tencent.mm.ai.k localk = ao.fag().xH(parambu.field_msgId);
    String str = parambu.field_content;
    if ((localk != null) && (str != null))
    {
      paramString = k.b.aA(str, parambu.field_reserved);
      parambu = new bk(parambu, parama1.fFv(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.dlp == 2) || (paramString.hAM == 2) || (paramString.hAM == 4)))
      {
        a.b.v(locala.jdF, paramString.hAQ);
        locala.KeZ.setTextSize(0, parama1.JOR.getMMResources().getDimension(2131165517));
        locala.KeZ.setTextColor(parama1.JOR.getContext().getResources().getColor(2131100711));
        locala.KeZ.setEllipsize(TextUtils.TruncateAt.END);
        locala.KeZ.setSingleLine(true);
        locala.KeZ.setShouldEllipsize(true);
        locala.KeZ.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.JOR.getContext(), paramString.hAP));
      }
      parama.ofK.setOnLongClickListener(c(parama1));
      parama.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
      parama.ofK.setTag(parambu);
      parama.ofK.setOnClickListener(d(parama1));
      AppMethodBeat.o(37311);
      return;
    }
    if (localk == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.e("MicrMsg.ChattingItemHardDeviceMsgLike", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(parambu.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bu parambu)
  {
    AppMethodBeat.i(37313);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37313);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194483);
    paraml.a(((bk)paramView.getTag()).position, 100, paramView.getContext().getString(2131757221), 2131690384);
    AppMethodBeat.o(194483);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bu parambu)
  {
    AppMethodBeat.i(37314);
    ad.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
    if (parambu == null)
    {
      ad.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
      AppMethodBeat.o(37314);
      return false;
    }
    String str = parambu.field_content;
    paramView = k.b.aA(str, parambu.field_reserved);
    if (paramView == null)
    {
      ad.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
      AppMethodBeat.o(37314);
      return false;
    }
    ad.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!bt.isNullOrNil(paramView.url))
    {
      parambu = new Intent();
      parambu.putExtra("rawUrl", paramView.url);
      d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", parambu);
      AppMethodBeat.o(37314);
      return true;
    }
    ba.aBQ();
    if (com.tencent.mm.model.c.azp().Bf(paramView.hAQ).adl()) {
      ad.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
    }
    for (;;)
    {
      AppMethodBeat.o(37314);
      return false;
      if (paramView.dlp == 2)
      {
        if (!bt.isNullOrNil(paramView.hAy))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_rank_info", str);
          localIntent.putExtra("key_rank_semi", parambu.field_reserved);
          localIntent.putExtra("key_rank_title", paramView.hAJ);
          localIntent.putExtra("key_champion_info", paramView.hAK);
          localIntent.putExtra("key_champion_coverimg", paramView.hAK);
          localIntent.putExtra("rank_id", paramView.hAy);
          localIntent.putExtra("app_username", paramView.appName);
          localIntent.putExtra("device_type", paramView.hAN);
          localIntent.putExtra("key_champioin_username", paramView.hAI);
          localIntent.putExtra("locate_to_username", paramView.hAQ);
          d.b(parama.JOR.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sport.a.c.ma(30);
          break;
          parambu = new Intent();
          parambu.putExtra("key_is_latest", true);
          parambu.putExtra("app_username", paramView.appName);
          parambu.putExtra("device_type", paramView.hAN);
          parambu.putExtra("locate_to_username", paramView.hAQ);
          d.b(parama.JOR.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", parambu);
        }
      }
      if (paramView.dlp == 4)
      {
        parambu = new Intent();
        parambu.putExtra("username", paramView.hAQ);
        parambu.putExtra("app_username", "gh_43f2581f6fd6");
        d.b(parama.JOR.getContext(), "exdevice", ".ui.ExdeviceProfileUI", parambu);
        com.tencent.mm.plugin.sport.a.c.ma(29);
      }
    }
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048183;
  }
  
  public final boolean fHh()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected NoMeasuredTextView KeZ;
    protected ImageView jdF;
    
    a() {}
    
    public final a gK(View paramView)
    {
      AppMethodBeat.i(37309);
      super.gn(paramView);
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.jdF = ((ImageView)paramView.findViewById(2131301412));
      this.KeZ = ((NoMeasuredTextView)paramView.findViewById(2131305875));
      AppMethodBeat.o(37309);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an
 * JD-Core Version:    0.7.0.1
 */