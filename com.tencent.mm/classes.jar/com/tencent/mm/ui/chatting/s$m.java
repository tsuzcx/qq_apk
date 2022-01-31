package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;

public final class s$m
  extends s.e
{
  public s$m(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(30733);
    h.d(parama.zJz.getContext(), parama.zJz.getMMResources().getString(2131299123), "", parama.zJz.getMMResources().getString(2131299125), parama.zJz.getMMResources().getString(2131299122), new DialogInterface.OnClickListener()new s.m.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(30731);
        paramAnonymousDialogInterface = new cw();
        paramAnonymousDialogInterface.cqo.enable = true;
        com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousDialogInterface);
        AppMethodBeat.o(30731);
      }
    }, new s.m.2(this));
    AppMethodBeat.o(30733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.m
 * JD-Core Version:    0.7.0.1
 */