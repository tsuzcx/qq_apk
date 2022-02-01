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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
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
      ((View)localObject).setTag(new a().gP((View)localObject));
    }
    AppMethodBeat.o(37310);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37311);
    a locala = (a)parama;
    com.tencent.mm.ah.k localk = ao.fdU().yb(parambv.field_msgId);
    String str = parambv.field_content;
    if ((localk != null) && (str != null))
    {
      paramString = k.b.aB(str, parambv.field_reserved);
      parambv = new bk(parambv, parama1.fJC(), paramInt, null, '\000');
      if ((paramString != null) && ((paramString.dmr == 2) || (paramString.hDA == 2) || (paramString.hDA == 4)))
      {
        a.b.v(locala.jgy, paramString.hDE);
        locala.KBs.setTextSize(0, parama1.Kkd.getMMResources().getDimension(2131165517));
        locala.KBs.setTextColor(parama1.Kkd.getContext().getResources().getColor(2131100711));
        locala.KBs.setEllipsize(TextUtils.TruncateAt.END);
        locala.KBs.setSingleLine(true);
        locala.KBs.setShouldEllipsize(true);
        locala.KBs.setText(com.tencent.mm.pluginsdk.ui.span.k.c(parama1.Kkd.getContext(), paramString.hDD));
      }
      parama.olI.setOnLongClickListener(c(parama1));
      parama.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
      parama.olI.setTag(parambv);
      parama.olI.setOnClickListener(d(parama1));
      AppMethodBeat.o(37311);
      return;
    }
    if (localk == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.e("MicrMsg.ChattingItemHardDeviceMsgLike", "amessage:%b, %s, %d, %s", new Object[] { Boolean.valueOf(bool), str, Long.valueOf(parambv.field_msgId), paramString });
      paramString = null;
      break;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bv parambv)
  {
    AppMethodBeat.i(37313);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37313);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187878);
    paraml.a(((bk)paramView.getTag()).position, 100, paramView.getContext().getString(2131757221), 2131690384);
    AppMethodBeat.o(187878);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bv parambv)
  {
    AppMethodBeat.i(37314);
    ae.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
    if (parambv == null)
    {
      ae.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
      AppMethodBeat.o(37314);
      return false;
    }
    String str = parambv.field_content;
    paramView = k.b.aB(str, parambv.field_reserved);
    if (paramView == null)
    {
      ae.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
      AppMethodBeat.o(37314);
      return false;
    }
    ae.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", new Object[] { paramView.url });
    if (!bu.isNullOrNil(paramView.url))
    {
      parambv = new Intent();
      parambv.putExtra("rawUrl", paramView.url);
      d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", parambv);
      AppMethodBeat.o(37314);
      return true;
    }
    bc.aCg();
    if (com.tencent.mm.model.c.azF().BH(paramView.hDE).adw()) {
      ae.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
    }
    for (;;)
    {
      AppMethodBeat.o(37314);
      return false;
      if (paramView.dmr == 2)
      {
        if (!bu.isNullOrNil(paramView.hDm))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_rank_info", str);
          localIntent.putExtra("key_rank_semi", parambv.field_reserved);
          localIntent.putExtra("key_rank_title", paramView.hDx);
          localIntent.putExtra("key_champion_info", paramView.hDy);
          localIntent.putExtra("key_champion_coverimg", paramView.hDy);
          localIntent.putExtra("rank_id", paramView.hDm);
          localIntent.putExtra("app_username", paramView.appName);
          localIntent.putExtra("device_type", paramView.hDB);
          localIntent.putExtra("key_champioin_username", paramView.hDw);
          localIntent.putExtra("locate_to_username", paramView.hDE);
          d.b(parama.Kkd.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sport.a.c.md(30);
          break;
          parambv = new Intent();
          parambv.putExtra("key_is_latest", true);
          parambv.putExtra("app_username", paramView.appName);
          parambv.putExtra("device_type", paramView.hDB);
          parambv.putExtra("locate_to_username", paramView.hDE);
          d.b(parama.Kkd.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", parambv);
        }
      }
      if (paramView.dmr == 4)
      {
        parambv = new Intent();
        parambv.putExtra("username", paramView.hDE);
        parambv.putExtra("app_username", "gh_43f2581f6fd6");
        d.b(parama.Kkd.getContext(), "exdevice", ".ui.ExdeviceProfileUI", parambv);
        com.tencent.mm.plugin.sport.a.c.md(29);
      }
    }
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048183;
  }
  
  public final boolean fLz()
  {
    return false;
  }
  
  final class a
    extends c.a
  {
    protected NoMeasuredTextView KBs;
    protected ImageView jgy;
    
    a() {}
    
    public final a gP(View paramView)
    {
      AppMethodBeat.i(37309);
      super.gs(paramView);
      this.iFD = ((CheckBox)paramView.findViewById(2131298068));
      this.jgy = ((ImageView)paramView.findViewById(2131301412));
      this.KBs = ((NoMeasuredTextView)paramView.findViewById(2131305875));
      AppMethodBeat.o(37309);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an
 * JD-Core Version:    0.7.0.1
 */