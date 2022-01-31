package com.tencent.mm.plugin.wallet.balance.a.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bmv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.wallet_core.ui.e;

public final class ac
{
  public static String Ii(int paramInt)
  {
    AppMethodBeat.i(45331);
    Context localContext = ah.getContext();
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(45331);
      return str;
      str = localContext.getString(2131305222);
      continue;
      str = localContext.getString(2131305225);
      continue;
      str = localContext.getString(2131305226);
      continue;
      str = localContext.getString(2131305223);
      continue;
      str = localContext.getString(2131305224);
    }
  }
  
  public static void a(final Context paramContext, bmv parambmv)
  {
    AppMethodBeat.i(142270);
    if (parambmv == null)
    {
      AppMethodBeat.o(142270);
      return;
    }
    c.a locala = new c.a(paramContext);
    locala.avn(parambmv.cyA);
    if (!bo.isNullOrNil(parambmv.xBg)) {
      locala.avt(parambmv.xBg);
    }
    if (!bo.isNullOrNil(parambmv.tVo)) {
      locala.avs(parambmv.tVo);
    }
    locala.rG(false);
    locala.a(true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(142269);
        ab.i("MicroMsg.LqtUtil", "click item, type: %s", new Object[] { Integer.valueOf(this.tNz.type) });
        if (this.tNz.type != 1)
        {
          if (this.tNz.type == 2)
          {
            e.m(paramContext, this.tNz.uaJ, true);
            AppMethodBeat.o(142269);
            return;
          }
          if (this.tNz.type == 3) {
            e.q(this.tNz.ugl, this.tNz.uaL, 0, 1061);
          }
        }
        AppMethodBeat.o(142269);
      }
    });
    locala.aLZ().show();
    AppMethodBeat.o(142270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.ac
 * JD-Core Version:    0.7.0.1
 */