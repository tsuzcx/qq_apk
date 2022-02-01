package com.tencent.mm.plugin.wallet_core.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class c
{
  public boolean Avm = false;
  MMActivity activity;
  
  public c(MMActivity paramMMActivity)
  {
    this.activity = paramMMActivity;
  }
  
  public static boolean a(b paramb)
  {
    if (paramb == null) {}
    while (paramb.Avl == 0) {
      return false;
    }
    return true;
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(187189);
    if (paramb.Avl == 1)
    {
      h.a(this.activity, paramb.doh, "", paramb.Avj.doh, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187186);
          c.a(c.this, paramb.Avj);
          AppMethodBeat.o(187186);
        }
      });
      AppMethodBeat.o(187189);
      return;
    }
    if (paramb.Avl == 2) {
      h.a(this.activity, paramb.doh, "", paramb.Avk.doh, paramb.Avj.doh, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187187);
          c.a(c.this, paramb.Avk);
          AppMethodBeat.o(187187);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187188);
          c.a(c.this, paramb.Avj);
          AppMethodBeat.o(187188);
        }
      });
    }
    AppMethodBeat.o(187189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.c
 * JD-Core Version:    0.7.0.1
 */