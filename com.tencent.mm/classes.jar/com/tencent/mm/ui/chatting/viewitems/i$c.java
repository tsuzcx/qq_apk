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
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class i$c
  extends c
{
  private a WBq;
  
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
      localObject = new aq(paramLayoutInflater, R.i.edK);
      ((View)localObject).setTag(new i.a().ia((View)localObject));
    }
    AppMethodBeat.o(36881);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(36882);
    this.WBq = parama1;
    paramString = paramca.field_content;
    if (paramString != null) {}
    for (paramString = k.b.aG(paramString, paramca.field_reserved);; paramString = null)
    {
      i.a locala = (i.a)parama;
      paramString = (d)paramString.ar(d.class);
      if (paramString.gbq == 0)
      {
        locala.Xfr.setBackgroundResource(R.g.dnS);
        locala.Xfs.setBackgroundResource(R.g.dnN);
        locala.Xfq.setVisibility(8);
      }
      for (;;)
      {
        parama.clickArea.setOnClickListener(d(parama1));
        parama.clickArea.setOnLongClickListener(c(parama1));
        parama.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
        parama1 = new by(paramca, this.WBq.hRi(), paramInt, null, '\000');
        parama.clickArea.setTag(parama1);
        AppMethodBeat.o(36882);
        return;
        locala.Xfr.setBackgroundResource(R.g.dnT);
        locala.Xfs.setBackgroundResource(R.g.dnO);
        locala.Xfq.setVisibility(0);
        if (paramString.gbq == 1) {
          locala.Xfq.setText(MMApplicationContext.getContext().getString(R.l.eKT));
        } else if (paramString.gbq == 2) {
          locala.Xfq.setText(MMApplicationContext.getContext().getString(R.l.eKV));
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
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(288410);
    paramo.a(((by)paramView.getTag()).position, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
    AppMethodBeat.o(288410);
    return false;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 469762097);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(36885);
    ((b)h.ae(b.class)).asK(paramca.field_talker);
    paramView = paramca.field_content;
    if (paramView != null)
    {
      paramView = k.b.aG(paramView, paramca.field_reserved);
      if ((paramView != null) && (!Util.isNullOrNil(paramView.lnH)))
      {
        d locald = (d)paramView.ar(d.class);
        Intent localIntent = new Intent();
        localIntent.putExtra("key_native_url", paramView.lnH);
        localIntent.putExtra("key_image_id", paramView.lnK);
        localIntent.putExtra("key_image_aes_key", paramView.lnL);
        localIntent.putExtra("key_image_length", paramView.lnM);
        localIntent.putExtra("key_username", parama.getTalkerUserName());
        localIntent.putExtra("key_msgid", paramca.field_msgId);
        localIntent.putExtra("key_msg_newyear_localreceivestatus", locald.gbq);
        if (locald.jHh != null) {
          localIntent.putExtra("key_emoji_md5", locald.jHh.field_md5);
        }
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", localIntent);
      }
    }
    AppMethodBeat.o(36885);
    return true;
  }
  
  public final boolean hTD()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.c
 * JD-Core Version:    0.7.0.1
 */