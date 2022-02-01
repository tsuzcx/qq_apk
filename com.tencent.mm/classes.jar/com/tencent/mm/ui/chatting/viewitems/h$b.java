package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;
import java.util.Map;

public final class h$b
  extends c
{
  private final int GKQ = 1;
  private a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493433);
      ((View)localObject).setTag(new h.a().fP((View)localObject));
    }
    AppMethodBeat.o(36876);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(36877);
    this.Gob = parama1;
    paramString = parambl.field_content;
    if (paramString != null) {}
    for (paramString = k.b.ar(paramString, parambl.field_reserved);; paramString = null)
    {
      h.a locala = (h.a)parama;
      paramString = (com.tencent.mm.ai.d)paramString.ao(com.tencent.mm.ai.d.class);
      if (paramString.dDP == 0)
      {
        locala.GKO.setBackgroundResource(2131233066);
        locala.GKP.setBackgroundResource(2131233053);
        locala.GKN.setVisibility(8);
      }
      for (;;)
      {
        parama.naN.setOnClickListener(d(parama1));
        parama.naN.setOnLongClickListener(c(parama1));
        parama.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
        parama1 = new bi(parambl, this.Gob.eZb(), paramInt, null, '\000');
        parama.naN.setTag(parama1);
        AppMethodBeat.o(36877);
        return;
        locala.GKO.setBackgroundResource(2131233067);
        locala.GKP.setBackgroundResource(2131233052);
        locala.GKN.setVisibility(0);
        if (paramString.dDP == 1) {
          locala.GKN.setText(aj.getContext().getString(2131760902));
        } else if (paramString.dDP == 2) {
          locala.GKN.setText(aj.getContext().getString(2131760904));
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(36878);
    paramContextMenu.add(((bi)paramView.getTag()).position, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
    AppMethodBeat.o(36878);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bl parambl)
  {
    AppMethodBeat.i(36879);
    paramMenuItem.getItemId();
    AppMethodBeat.o(36879);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 469762097);
  }
  
  public final boolean b(View paramView, a parama, bl parambl)
  {
    AppMethodBeat.i(36880);
    ((b)g.ab(b.class)).Sa(parambl.field_talker);
    paramView = parambl.field_content;
    if (paramView != null)
    {
      paramView = k.b.ar(paramView, parambl.field_reserved);
      if (!bt.isNullOrNil(paramView.gIO))
      {
        ad.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
        com.tencent.mm.ai.d locald = (com.tencent.mm.ai.d)paramView.ao(com.tencent.mm.ai.d.class);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_native_url", paramView.gIO);
        localIntent.putExtra("key_username", parama.getTalkerUserName());
        localIntent.putExtra("key_image_id", paramView.gIR);
        localIntent.putExtra("key_image_aes_key", paramView.gIS);
        localIntent.putExtra("key_image_length", paramView.gIT);
        localIntent.putExtra("key_msgid", parambl.field_msgId);
        localIntent.putExtra("key_msg_newyear_localreceivestatus", locald.dDP);
        if (locald.fLP != null) {
          localIntent.putExtra("key_emoji_md5", locald.fLP.field_md5);
        }
        com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", localIntent);
        paramView.gIP = 1;
        parambl.setContent(k.b.a(paramView, null, null));
        if ((parambl != null) && (parambl.cxB())) {
          break label260;
        }
      }
    }
    for (;;)
    {
      az.arV();
      com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
      AppMethodBeat.o(36880);
      return true;
      try
      {
        label260:
        parama = parambl.field_content;
        int i = parama.indexOf("<msg>");
        paramView = parama;
        if (i > 0)
        {
          paramView = parama;
          if (i < parama.length()) {
            paramView = parama.substring(i).trim();
          }
        }
        paramView = bw.K(paramView, "msg");
        if ((paramView != null) && (paramView.size() > 0)) {
          parambl.oa(bj.bA(paramView));
        }
      }
      catch (Exception paramView)
      {
        ad.e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", paramView.getMessage());
      }
    }
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h.b
 * JD-Core Version:    0.7.0.1
 */