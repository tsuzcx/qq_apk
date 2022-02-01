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
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import java.util.Map;

public final class i$b
  extends c
{
  private final int aePw = 1;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36876);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.gfz);
      ((View)localObject).setTag(new i.a().lw((View)localObject));
    }
    AppMethodBeat.o(36876);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(36877);
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
          locala.aePu.setBackgroundResource(R.g.foo);
          locala.aePv.setBackgroundResource(R.g.fof);
          locala.aePt.setVisibility(8);
        }
        for (;;)
        {
          parama.clickArea.setOnClickListener(d(parama1));
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          parama1 = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
          parama.clickArea.setTag(parama1);
          AppMethodBeat.o(36877);
          return;
          locala.aePu.setBackgroundResource(R.g.fop);
          locala.aePv.setBackgroundResource(R.g.foe);
          locala.aePt.setVisibility(0);
          if (locald.ihA == 1) {
            locala.aePt.setText(MMApplicationContext.getContext().getString(R.l.gMO));
          } else if (locald.ihA == 2) {
            locala.aePt.setText(MMApplicationContext.getContext().getString(R.l.gMP));
          }
        }
      }
      if (locald.ihA == 0) {
        if (aw.isDarkMode())
        {
          locala.aePv.setBackgroundResource(R.g.foj);
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
        locala.aePv.setBackgroundResource(R.g.foi);
        break label294;
        if (aw.isDarkMode())
        {
          locala.aePv.setBackgroundResource(R.g.foh);
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
          locala.aePv.setBackgroundResource(R.g.fog);
          locala.aePt.setTextColor(Color.parseColor("#FFE2B1"));
        }
        label460:
        if (locald.ihA == 2) {
          locala.aePt.setText(MMApplicationContext.getContext().getString(R.l.gMP));
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(36879);
    paramMenuItem.getItemId();
    AppMethodBeat.o(36879);
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(254964);
    params.a(((bz)paramView.getTag()).position, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
    AppMethodBeat.o(254964);
    return false;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(36880);
    ((com.tencent.mm.plugin.comm.a.c)h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    paramView = paramcc.field_content;
    k.b localb;
    if (paramView != null)
    {
      localb = k.b.aP(paramView, paramcc.field_reserved);
      if (!Util.isNullOrNil(localb.nSC)) {
        break label289;
      }
      paramView = localb.url;
      if (Util.isNullOrNil(localb.nSL)) {
        break label387;
      }
      Log.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
      paramView = (d)localb.aK(d.class);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_native_url", localb.nSL);
      localIntent.putExtra("key_username", parama.getTalkerUserName());
      localIntent.putExtra("key_image_id", localb.nSO);
      localIntent.putExtra("key_image_aes_key", localb.nSP);
      localIntent.putExtra("key_image_length", localb.nSQ);
      localIntent.putExtra("key_msgid", paramcc.field_msgId);
      localIntent.putExtra("key_msg_newyear_localreceivestatus", paramView.ihA);
      if (paramView.mgK != null) {
        localIntent.putExtra("key_emoji_md5", paramView.mgK.field_md5);
      }
      com.tencent.mm.br.c.b(parama.aezO.getContext(), "wallet_payu", ".pay.ui.WalletPayUChangeBankcardUI", localIntent);
      localb.nSM = 1;
      paramcc.setContent(k.b.a(localb, null, null));
      if ((paramcc != null) && (paramcc.fxR())) {
        break label298;
      }
      label264:
      bh.bCz();
      com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
    }
    for (;;)
    {
      for (;;)
      {
        AppMethodBeat.o(36880);
        return true;
        label289:
        paramView = localb.nSC;
        break;
        try
        {
          label298:
          parama = paramcc.field_content;
          int i = parama.indexOf("<msg>");
          paramView = parama;
          if (i > 0)
          {
            paramView = parama;
            if (i < parama.length()) {
              paramView = parama.substring(i).trim();
            }
          }
          paramView = XmlParser.parseXml(paramView, "msg", null);
          if ((paramView == null) || (paramView.size() <= 0)) {
            break label264;
          }
          paramcc.BU(SemiXml.encode(paramView));
        }
        catch (Exception paramView)
        {
          Log.e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", paramView.getMessage());
        }
      }
      break label264;
      label387:
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
    return (!paramBoolean) && (paramInt == 469762097);
  }
  
  public final boolean fXn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.b
 * JD-Core Version:    0.7.0.1
 */