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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;

public final class h$c
  extends c
{
  private a HNS;
  
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
      localObject = new ag(paramLayoutInflater, 2131493478);
      ((View)localObject).setTag(new h.a().gc((View)localObject));
    }
    AppMethodBeat.o(36881);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(36882);
    this.HNS = parama1;
    paramString = parambo.field_content;
    if (paramString != null) {}
    for (paramString = k.b.az(paramString, parambo.field_reserved);; paramString = null)
    {
      h.a locala = (h.a)parama;
      paramString = (com.tencent.mm.ah.d)paramString.ao(com.tencent.mm.ah.d.class);
      if (paramString.dBB == 0)
      {
        locala.IkL.setBackgroundResource(2131233083);
        locala.IkM.setBackgroundResource(2131233051);
        locala.IkK.setVisibility(8);
      }
      for (;;)
      {
        parama.nDl.setOnClickListener(d(parama1));
        parama.nDl.setOnLongClickListener(c(parama1));
        parama.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
        parama1 = new bj(parambo, this.HNS.foQ(), paramInt, null, '\000');
        parama.nDl.setTag(parama1);
        AppMethodBeat.o(36882);
        return;
        locala.IkL.setBackgroundResource(2131233084);
        locala.IkM.setBackgroundResource(2131233052);
        locala.IkK.setVisibility(0);
        if (paramString.dBB == 1) {
          locala.IkK.setText(ai.getContext().getString(2131760902));
        } else if (paramString.dBB == 2) {
          locala.IkK.setText(ai.getContext().getString(2131760905));
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(36883);
    paramContextMenu.add(((bj)paramView.getTag()).position, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
    AppMethodBeat.o(36883);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bo parambo)
  {
    AppMethodBeat.i(36884);
    paramMenuItem.getItemId();
    AppMethodBeat.o(36884);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bo parambo)
  {
    AppMethodBeat.i(36885);
    ((b)g.ab(b.class)).Wm(parambo.field_talker);
    paramView = parambo.field_content;
    if (paramView != null)
    {
      paramView = k.b.az(paramView, parambo.field_reserved);
      if ((paramView != null) && (!bs.isNullOrNil(paramView.hjo)))
      {
        com.tencent.mm.ah.d locald = (com.tencent.mm.ah.d)paramView.ao(com.tencent.mm.ah.d.class);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_native_url", paramView.hjo);
        localIntent.putExtra("key_image_id", paramView.hjr);
        localIntent.putExtra("key_image_aes_key", paramView.hjs);
        localIntent.putExtra("key_image_length", paramView.hjt);
        localIntent.putExtra("key_username", parama.getTalkerUserName());
        localIntent.putExtra("key_msgid", parambo.field_msgId);
        localIntent.putExtra("key_msg_newyear_localreceivestatus", locald.dBB);
        if (locald.fPB != null) {
          localIntent.putExtra("key_emoji_md5", locald.fPB.field_md5);
        }
        com.tencent.mm.br.d.b(parama.HZF.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", localIntent);
      }
    }
    AppMethodBeat.o(36885);
    return true;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 469762097);
  }
  
  public final boolean fqu()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h.c
 * JD-Core Version:    0.7.0.1
 */