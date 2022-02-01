package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.dz;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.d.a;

public final class v$m
  extends v.e
{
  public v$m(a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, a parama, cc paramcc)
  {
    AppMethodBeat.i(34607);
    k.b(parama.aezO.getContext(), parama.aezO.getMMResources().getString(R.l.emoji_chatting_reward_tips_disable_msg), "", parama.aezO.getMMResources().getString(R.l.emoji_chatting_reward_tips_enable), parama.aezO.getMMResources().getString(R.l.emoji_chatting_reward_tips_disable), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34605);
        paramAnonymousDialogInterface = new dz();
        paramAnonymousDialogInterface.hDP.enable = true;
        paramAnonymousDialogInterface.publish();
        AppMethodBeat.o(34605);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34606);
        paramAnonymousDialogInterface = new dz();
        paramAnonymousDialogInterface.hDP.enable = false;
        paramAnonymousDialogInterface.publish();
        AppMethodBeat.o(34606);
      }
    });
    AppMethodBeat.o(34607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v.m
 * JD-Core Version:    0.7.0.1
 */