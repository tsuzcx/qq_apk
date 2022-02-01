package com.tencent.mm.plugin.wallet_core.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class c
{
  public boolean BNG = false;
  MMActivity activity;
  
  public c(MMActivity paramMMActivity)
  {
    this.activity = paramMMActivity;
  }
  
  public static boolean a(b paramb)
  {
    if (paramb == null) {}
    while (paramb.BNF == 0) {
      return false;
    }
    return true;
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(207312);
    if (paramb.BNF == 1)
    {
      h.a(this.activity, paramb.dlQ, "", paramb.BND.dlQ, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(207309);
          c.a(c.this, paramb.BND);
          AppMethodBeat.o(207309);
        }
      });
      AppMethodBeat.o(207312);
      return;
    }
    if (paramb.BNF == 2) {
      h.a(this.activity, paramb.dlQ, "", paramb.BNE.dlQ, paramb.BND.dlQ, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(207310);
          c.a(c.this, paramb.BNE);
          AppMethodBeat.o(207310);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(207311);
          c.a(c.this, paramb.BND);
          AppMethodBeat.o(207311);
        }
      });
    }
    AppMethodBeat.o(207312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.c
 * JD-Core Version:    0.7.0.1
 */