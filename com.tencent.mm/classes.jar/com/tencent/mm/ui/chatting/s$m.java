package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.h;

public final class s$m
  extends s.e
{
  public s$m(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(34607);
    h.e(parama.JOR.getContext(), parama.JOR.getMMResources().getString(2131758239), "", parama.JOR.getMMResources().getString(2131758241), parama.JOR.getMMResources().getString(2131758238), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34605);
        paramAnonymousDialogInterface = new dg();
        paramAnonymousDialogInterface.doc.enable = true;
        com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(34605);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(34606);
        paramAnonymousDialogInterface = new dg();
        paramAnonymousDialogInterface.doc.enable = false;
        com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(34606);
      }
    });
    AppMethodBeat.o(34607);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.m
 * JD-Core Version:    0.7.0.1
 */