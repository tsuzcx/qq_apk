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
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class h$c
  extends c
{
  private a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493580);
      ((View)localObject).setTag(new h.a().gO((View)localObject));
    }
    AppMethodBeat.o(36881);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36882);
    this.PhN = parama1;
    paramString = paramca.field_content;
    if (paramString != null) {}
    for (paramString = k.b.aD(paramString, paramca.field_reserved);; paramString = null)
    {
      h.a locala = (h.a)parama;
      paramString = (d)paramString.as(d.class);
      if (paramString.eha == 0)
      {
        locala.PJR.setBackgroundResource(2131233736);
        locala.PJS.setBackgroundResource(2131233704);
        locala.PJQ.setVisibility(8);
      }
      for (;;)
      {
        parama.clickArea.setOnClickListener(d(parama1));
        parama.clickArea.setOnLongClickListener(c(parama1));
        parama.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
        parama1 = new bq(paramca, this.PhN.gRM(), paramInt, null, '\000');
        parama.clickArea.setTag(parama1);
        AppMethodBeat.o(36882);
        return;
        locala.PJR.setBackgroundResource(2131233737);
        locala.PJS.setBackgroundResource(2131233705);
        locala.PJQ.setVisibility(0);
        if (paramString.eha == 1) {
          locala.PJQ.setText(MMApplicationContext.getContext().getString(2131762676));
        } else if (paramString.eha == 2) {
          locala.PJQ.setText(MMApplicationContext.getContext().getString(2131762679));
        }
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(36884);
    paramMenuItem.getItemId();
    AppMethodBeat.o(36884);
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233621);
    paramm.a(((bq)paramView.getTag()).position, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
    AppMethodBeat.o(233621);
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 469762097);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(36885);
    ((b)g.af(b.class)).akR(paramca.field_talker);
    paramView = paramca.field_content;
    if (paramView != null)
    {
      paramView = k.b.aD(paramView, paramca.field_reserved);
      if ((paramView != null) && (!Util.isNullOrNil(paramView.iyr)))
      {
        d locald = (d)paramView.as(d.class);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_native_url", paramView.iyr);
        localIntent.putExtra("key_image_id", paramView.iyu);
        localIntent.putExtra("key_image_aes_key", paramView.iyv);
        localIntent.putExtra("key_image_length", paramView.iyw);
        localIntent.putExtra("key_username", parama.getTalkerUserName());
        localIntent.putExtra("key_msgid", paramca.field_msgId);
        localIntent.putExtra("key_msg_newyear_localreceivestatus", locald.eha);
        if (locald.gWm != null) {
          localIntent.putExtra("key_emoji_md5", locald.gWm.field_md5);
        }
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", localIntent);
      }
    }
    AppMethodBeat.o(36885);
    return true;
  }
  
  public final boolean gTT()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h.c
 * JD-Core Version:    0.7.0.1
 */