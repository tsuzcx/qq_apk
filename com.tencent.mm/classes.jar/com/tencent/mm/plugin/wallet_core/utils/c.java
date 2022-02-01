package com.tencent.mm.plugin.wallet_core.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class c
{
  public boolean DnY = false;
  MMActivity activity;
  
  public c(MMActivity paramMMActivity)
  {
    this.activity = paramMMActivity;
  }
  
  public static boolean a(b paramb)
  {
    if (paramb == null) {}
    while (paramb.DnX == 0) {
      return false;
    }
    return true;
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(199354);
    if (paramb.DnX == 1)
    {
      h.a(this.activity, paramb.dxD, "", paramb.DnV.dxD, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(199351);
          c.a(c.this, paramb.DnV);
          AppMethodBeat.o(199351);
        }
      });
      AppMethodBeat.o(199354);
      return;
    }
    if (paramb.DnX == 2) {
      h.a(this.activity, paramb.dxD, "", paramb.DnW.dxD, paramb.DnV.dxD, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(199352);
          c.a(c.this, paramb.DnW);
          AppMethodBeat.o(199352);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(199353);
          c.a(c.this, paramb.DnV);
          AppMethodBeat.o(199353);
        }
      });
    }
    AppMethodBeat.o(199354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.c
 * JD-Core Version:    0.7.0.1
 */