package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.d;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;

public final class i$c
  extends c
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36881);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ggA);
      ((View)localObject).setTag(new i.a().lw((View)localObject));
    }
    AppMethodBeat.o(36881);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(36882);
    this.aeiK = parama1;
    paramString = paramcc.field_content;
    if (paramString != null) {}
    for (paramString = k.b.aP(paramString, paramcc.field_reserved);; paramString = null)
    {
      i.a locala = (i.a)parama;
      d locald = (d)paramString.aK(d.class);
      if (paramString.nTe == 1)
      {
        if (locald.ihA == 0)
        {
          locala.aePu.setBackgroundResource(R.g.foq);
          locala.aePv.setBackgroundResource(R.g.fod);
          locala.aePt.setVisibility(8);
        }
        for (;;)
        {
          parama.clickArea.setOnClickListener(d(parama1));
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          parama1 = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
          parama.clickArea.setTag(parama1);
          AppMethodBeat.o(36882);
          return;
          locala.aePu.setBackgroundResource(R.g.for);
          locala.aePv.setBackgroundResource(R.g.foe);
          locala.aePt.setVisibility(0);
          if (locald.ihA == 1) {
            locala.aePt.setText(MMApplicationContext.getContext().getString(R.l.gMO));
          } else if (locald.ihA == 2) {
            locala.aePt.setText(MMApplicationContext.getContext().getString(R.l.gMQ));
          }
        }
      }
      if (locald.ihA == 0) {
        if (aw.isDarkMode())
        {
          locala.aePv.setBackgroundResource(R.g.fon);
          label294:
          locala.aePt.setVisibility(8);
        }
      }
      for (;;)
      {
        locala.aePu.setVisibility(8);
        paramString = locala.aePv.getLayoutParams();
        paramString.width = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 131);
        locala.aePv.setLayoutParams(paramString);
        break;
        locala.aePv.setBackgroundResource(R.g.fom);
        break label294;
        if (aw.isDarkMode())
        {
          locala.aePv.setBackgroundResource(R.g.fol);
          locala.aePt.setTextColor(Color.parseColor("#7FFFE2B1"));
        }
        for (;;)
        {
          locala.aePt.setVisibility(0);
          if (locald.ihA != 1) {
            break label460;
          }
          locala.aePt.setText(MMApplicationContext.getContext().getString(R.l.gMO));
          break;
          locala.aePv.setBackgroundResource(R.g.fok);
          locala.aePt.setTextColor(Color.parseColor("#FFE2B1"));
        }
        label460:
        if (locald.ihA == 2) {
          locala.aePt.setText(MMApplicationContext.getContext().getString(R.l.gMQ));
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(36884);
    paramMenuItem.getItemId();
    AppMethodBeat.o(36884);
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(254956);
    params.a(((bz)paramView.getTag()).position, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
    AppMethodBeat.o(254956);
    return false;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(36885);
    ((com.tencent.mm.plugin.comm.a.c)h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    paramView = paramcc.field_content;
    k.b localb;
    if (paramView != null)
    {
      localb = k.b.aP(paramView, paramcc.field_reserved);
      if (!Util.isNullOrNil(localb.nSC)) {
        break label240;
      }
      paramView = localb.url;
      if ((localb == null) || (Util.isNullOrNil(localb.nSL))) {
        break label249;
      }
      paramView = (d)localb.aK(d.class);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_native_url", localb.nSL);
      localIntent.putExtra("key_image_id", localb.nSO);
      localIntent.putExtra("key_image_aes_key", localb.nSP);
      localIntent.putExtra("key_image_length", localb.nSQ);
      localIntent.putExtra("key_username", parama.getTalkerUserName());
      localIntent.putExtra("key_msgid", paramcc.field_msgId);
      localIntent.putExtra("key_msg_newyear_localreceivestatus", paramView.ihA);
      if (paramView.mgK != null) {
        localIntent.putExtra("key_emoji_md5", paramView.mgK.field_md5);
      }
      com.tencent.mm.br.c.b(parama.aezO.getContext(), "wallet_payu", ".pay.ui.WalletPayUChangeBankcardUI", localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(36885);
      return true;
      label240:
      paramView = localb.nSC;
      break;
      label249:
      if (!Util.isNullOrNil(paramView))
      {
        ah.c(localb.nSN, Long.valueOf(paramcc.field_msgId));
        paramcc = new Intent();
        paramcc.putExtra("rawUrl", paramView);
        com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramcc);
      }
    }
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 469762097);
  }
  
  public final boolean fXn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.c
 * JD-Core Version:    0.7.0.1
 */