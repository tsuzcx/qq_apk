package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;

public final class t$m
  extends t.e
{
  public t$m(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(34607);
    h.e(parama.Kkd.getContext(), parama.Kkd.getMMResources().getString(2131758239), "", parama.Kkd.getMMResources().getString(2131758241), parama.Kkd.getMMResources().getString(2131758238), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34605);
        paramAnonymousDialogInterface = new dh();
        paramAnonymousDialogInterface.dph.enable = true;
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(34605);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34606);
        paramAnonymousDialogInterface = new dh();
        paramAnonymousDialogInterface.dph.enable = false;
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(34606);
      }
    });
    AppMethodBeat.o(34607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.m
 * JD-Core Version:    0.7.0.1
 */