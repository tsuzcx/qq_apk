package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.h;

public final class s
{
  public static final class m
    extends s.e
  {
    public m(com.tencent.mm.ui.chatting.d.a parama)
    {
      super();
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(34607);
      h.d(parama.HZF.getContext(), parama.HZF.getMMResources().getString(2131758239), "", parama.HZF.getMMResources().getString(2131758241), parama.HZF.getMMResources().getString(2131758238), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34605);
          paramAnonymousDialogInterface = new dd();
          paramAnonymousDialogInterface.dcG.enable = true;
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
          AppMethodBeat.o(34605);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34606);
          paramAnonymousDialogInterface = new dd();
          paramAnonymousDialogInterface.dcG.enable = false;
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousDialogInterface);
          AppMethodBeat.o(34606);
        }
      });
      AppMethodBeat.o(34607);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s
 * JD-Core Version:    0.7.0.1
 */