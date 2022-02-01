package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import java.util.Map;

public final class h$b
  extends c
{
  private a JBI;
  private final int Kbl = 1;
  
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
      localObject = new ah(paramLayoutInflater, 2131493433);
      ((View)localObject).setTag(new h.a().gt((View)localObject));
    }
    AppMethodBeat.o(36876);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(36877);
    this.JBI = parama1;
    paramString = parambu.field_content;
    if (paramString != null) {}
    for (paramString = k.b.aA(paramString, parambu.field_reserved);; paramString = null)
    {
      h.a locala = (h.a)parama;
      paramString = (com.tencent.mm.ai.d)paramString.ao(com.tencent.mm.ai.d.class);
      if (paramString.dNO == 0)
      {
        locala.Kbj.setBackgroundResource(2131233066);
        locala.Kbk.setBackgroundResource(2131233053);
        locala.Kbi.setVisibility(8);
      }
      for (;;)
      {
        parama.ofK.setOnClickListener(d(parama1));
        parama.ofK.setOnLongClickListener(c(parama1));
        parama.ofK.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
        parama1 = new bk(parambu, this.JBI.fFv(), paramInt, null, '\000');
        parama.ofK.setTag(parama1);
        AppMethodBeat.o(36877);
        return;
        locala.Kbj.setBackgroundResource(2131233067);
        locala.Kbk.setBackgroundResource(2131233052);
        locala.Kbi.setVisibility(0);
        if (paramString.dNO == 1) {
          locala.Kbi.setText(aj.getContext().getString(2131760902));
        } else if (paramString.dNO == 2) {
          locala.Kbi.setText(aj.getContext().getString(2131760904));
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bu parambu)
  {
    AppMethodBeat.i(36879);
    paramMenuItem.getItemId();
    AppMethodBeat.o(36879);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194335);
    paraml.a(((bk)paramView.getTag()).position, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
    AppMethodBeat.o(194335);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bu parambu)
  {
    AppMethodBeat.i(36880);
    ((b)g.ab(b.class)).ZT(parambu.field_talker);
    paramView = parambu.field_content;
    if (paramView != null)
    {
      paramView = k.b.aA(paramView, parambu.field_reserved);
      if (!bt.isNullOrNil(paramView.hBx))
      {
        ad.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
        com.tencent.mm.ai.d locald = (com.tencent.mm.ai.d)paramView.ao(com.tencent.mm.ai.d.class);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_native_url", paramView.hBx);
        localIntent.putExtra("key_username", parama.getTalkerUserName());
        localIntent.putExtra("key_image_id", paramView.hBA);
        localIntent.putExtra("key_image_aes_key", paramView.hBB);
        localIntent.putExtra("key_image_length", paramView.hBC);
        localIntent.putExtra("key_msgid", parambu.field_msgId);
        localIntent.putExtra("key_msg_newyear_localreceivestatus", locald.dNO);
        if (locald.gjb != null) {
          localIntent.putExtra("key_emoji_md5", locald.gjb.field_md5);
        }
        com.tencent.mm.bs.d.b(parama.JOR.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", localIntent);
        paramView.hBy = 1;
        parambu.setContent(k.b.a(paramView, null, null));
        if ((parambu != null) && (parambu.cTc())) {
          break label260;
        }
      }
    }
    for (;;)
    {
      ba.aBQ();
      com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
      AppMethodBeat.o(36880);
      return true;
      try
      {
        label260:
        parama = parambu.field_content;
        int i = parama.indexOf("<msg>");
        paramView = parama;
        if (i > 0)
        {
          paramView = parama;
          if (i < parama.length()) {
            paramView = parama.substring(i).trim();
          }
        }
        paramView = bw.M(paramView, "msg");
        if ((paramView != null) && (paramView.size() > 0)) {
          parambu.tP(bj.bI(paramView));
        }
      }
      catch (Exception paramView)
      {
        ad.e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", paramView.getMessage());
      }
    }
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 469762097);
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h.b
 * JD-Core Version:    0.7.0.1
 */