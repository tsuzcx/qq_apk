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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;
import java.util.Map;

public final class h$b
  extends c
{
  private a JWz;
  private final int KxD = 1;
  
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
      ((View)localObject).setTag(new h.a().gy((View)localObject));
    }
    AppMethodBeat.o(36876);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(36877);
    this.JWz = parama1;
    paramString = parambv.field_content;
    if (paramString != null) {}
    for (paramString = k.b.aB(paramString, parambv.field_reserved);; paramString = null)
    {
      h.a locala = (h.a)parama;
      paramString = (com.tencent.mm.ah.d)paramString.ao(com.tencent.mm.ah.d.class);
      if (paramString.dPe == 0)
      {
        locala.KxB.setBackgroundResource(2131233066);
        locala.KxC.setBackgroundResource(2131233053);
        locala.KxA.setVisibility(8);
      }
      for (;;)
      {
        parama.olI.setOnClickListener(d(parama1));
        parama.olI.setOnLongClickListener(c(parama1));
        parama.olI.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
        parama1 = new bk(parambv, this.JWz.fJC(), paramInt, null, '\000');
        parama.olI.setTag(parama1);
        AppMethodBeat.o(36877);
        return;
        locala.KxB.setBackgroundResource(2131233067);
        locala.KxC.setBackgroundResource(2131233052);
        locala.KxA.setVisibility(0);
        if (paramString.dPe == 1) {
          locala.KxA.setText(ak.getContext().getString(2131760902));
        } else if (paramString.dPe == 2) {
          locala.KxA.setText(ak.getContext().getString(2131760904));
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bv parambv)
  {
    AppMethodBeat.i(36879);
    paramMenuItem.getItemId();
    AppMethodBeat.o(36879);
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187730);
    paraml.a(((bk)paramView.getTag()).position, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
    AppMethodBeat.o(187730);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bv parambv)
  {
    AppMethodBeat.i(36880);
    ((b)g.ab(b.class)).aaK(parambv.field_talker);
    paramView = parambv.field_content;
    if (paramView != null)
    {
      paramView = k.b.aB(paramView, parambv.field_reserved);
      if (!bu.isNullOrNil(paramView.hEl))
      {
        ae.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
        com.tencent.mm.ah.d locald = (com.tencent.mm.ah.d)paramView.ao(com.tencent.mm.ah.d.class);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_native_url", paramView.hEl);
        localIntent.putExtra("key_username", parama.getTalkerUserName());
        localIntent.putExtra("key_image_id", paramView.hEo);
        localIntent.putExtra("key_image_aes_key", paramView.hEp);
        localIntent.putExtra("key_image_length", paramView.hEq);
        localIntent.putExtra("key_msgid", parambv.field_msgId);
        localIntent.putExtra("key_msg_newyear_localreceivestatus", locald.dPe);
        if (locald.glt != null) {
          localIntent.putExtra("key_emoji_md5", locald.glt.field_md5);
        }
        com.tencent.mm.br.d.b(parama.Kkd.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", localIntent);
        paramView.hEm = 1;
        parambv.setContent(k.b.a(paramView, null, null));
        if ((parambv != null) && (parambv.cVH())) {
          break label260;
        }
      }
    }
    for (;;)
    {
      bc.aCg();
      com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
      AppMethodBeat.o(36880);
      return true;
      try
      {
        label260:
        parama = parambv.field_content;
        int i = parama.indexOf("<msg>");
        paramView = parama;
        if (i > 0)
        {
          paramView = parama;
          if (i < parama.length()) {
            paramView = parama.substring(i).trim();
          }
        }
        paramView = bx.M(paramView, "msg");
        if ((paramView != null) && (paramView.size() > 0)) {
          parambv.uk(com.tencent.mm.sdk.platformtools.bk.bO(paramView));
        }
      }
      catch (Exception paramView)
      {
        ae.e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", paramView.getMessage());
      }
    }
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 469762097);
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h.b
 * JD-Core Version:    0.7.0.1
 */