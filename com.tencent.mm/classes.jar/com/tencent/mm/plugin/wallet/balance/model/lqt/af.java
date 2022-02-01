package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cga;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.ui.e;

public final class af
{
  public static String To(int paramInt)
  {
    AppMethodBeat.i(68551);
    Context localContext = ai.getContext();
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(68551);
      return str;
      str = localContext.getString(2131765473);
      continue;
      str = localContext.getString(2131765427);
      continue;
      str = localContext.getString(2131765428);
      continue;
      str = localContext.getString(2131765425);
      continue;
      str = localContext.getString(2131765426);
    }
  }
  
  public static void a(final Context paramContext, cga paramcga)
  {
    AppMethodBeat.i(68552);
    if (paramcga == null)
    {
      AppMethodBeat.o(68552);
      return;
    }
    d.a locala = new d.a(paramContext);
    locala.aRI(paramcga.dlQ);
    if (!bs.isNullOrNil(paramcga.Fuh)) {
      locala.aRP(paramcga.Fuh);
    }
    if (!bs.isNullOrNil(paramcga.BhV)) {
      locala.aRO(paramcga.BhV);
    }
    locala.yf(false);
    locala.a(true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68550);
        ac.i("MicroMsg.LqtUtil", "click item, type: %s", new Object[] { Integer.valueOf(this.AYm.type) });
        if (this.AYm.type != 1)
        {
          if (this.AYm.type == 2)
          {
            e.o(paramContext, this.AYm.BnF, true);
            AppMethodBeat.o(68550);
            return;
          }
          if (this.AYm.type == 3) {
            e.v(this.AYm.AZE, this.AYm.AZF, 0, 1061);
          }
        }
        AppMethodBeat.o(68550);
      }
    });
    locala.fvp().show();
    AppMethodBeat.o(68552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.af
 * JD-Core Version:    0.7.0.1
 */