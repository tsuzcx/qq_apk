package com.tencent.mm.plugin.wallet_core.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bqo;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public final class c
{
  public boolean DFD = false;
  MMActivity activity;
  
  public c(MMActivity paramMMActivity)
  {
    this.activity = paramMMActivity;
  }
  
  public static boolean a(b paramb)
  {
    if (paramb == null) {}
    while (paramb.DFC == 0) {
      return false;
    }
    return true;
  }
  
  public static boolean a(bqo parambqo)
  {
    if (parambqo == null) {}
    while (parambqo.DFC == 0) {
      return false;
    }
    return true;
  }
  
  public final void b(final b paramb)
  {
    AppMethodBeat.i(190237);
    if (paramb.DFC == 1)
    {
      h.a(this.activity, paramb.dyI, "", paramb.DFA.dyI, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(190231);
          c.a(c.this, paramb.DFA);
          AppMethodBeat.o(190231);
        }
      });
      AppMethodBeat.o(190237);
      return;
    }
    if (paramb.DFC == 2) {
      h.a(this.activity, paramb.dyI, "", paramb.DFB.dyI, paramb.DFA.dyI, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(190232);
          c.a(c.this, paramb.DFB);
          AppMethodBeat.o(190232);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(190233);
          c.a(c.this, paramb.DFA);
          AppMethodBeat.o(190233);
        }
      });
    }
    AppMethodBeat.o(190237);
  }
  
  public final void b(final bqo parambqo)
  {
    AppMethodBeat.i(190238);
    if (parambqo.DFC == 1)
    {
      h.a(this.activity, parambqo.dyI, "", parambqo.DFA.dyI, false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(190234);
          c.a(c.this, parambqo.DFA);
          AppMethodBeat.o(190234);
        }
      });
      AppMethodBeat.o(190238);
      return;
    }
    if (parambqo.DFC == 2) {
      h.a(this.activity, parambqo.dyI, "", parambqo.DFB.dyI, parambqo.DFA.dyI, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(190235);
          c.a(c.this, parambqo.DFB);
          AppMethodBeat.o(190235);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(190236);
          c.a(c.this, parambqo.DFA);
          AppMethodBeat.o(190236);
        }
      });
    }
    AppMethodBeat.o(190238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.c
 * JD-Core Version:    0.7.0.1
 */