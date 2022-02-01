package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.dp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.e.a;

public final class t$m
  extends t.e
{
  public t$m(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, ca paramca)
  {
    AppMethodBeat.i(34607);
    h.c(parama.WQv.getContext(), parama.WQv.getMMResources().getString(R.l.emoji_chatting_reward_tips_disable_msg), "", parama.WQv.getMMResources().getString(R.l.emoji_chatting_reward_tips_enable), parama.WQv.getMMResources().getString(R.l.emoji_chatting_reward_tips_disable), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34605);
        paramAnonymousDialogInterface = new dp();
        paramAnonymousDialogInterface.fzg.enable = true;
        EventCenter.instance.publish(paramAnonymousDialogInterface);
        AppMethodBeat.o(34605);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34606);
        paramAnonymousDialogInterface = new dp();
        paramAnonymousDialogInterface.fzg.enable = false;
        EventCenter.instance.publish(paramAnonymousDialogInterface);
        AppMethodBeat.o(34606);
      }
    });
    AppMethodBeat.o(34607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.m
 * JD-Core Version:    0.7.0.1
 */