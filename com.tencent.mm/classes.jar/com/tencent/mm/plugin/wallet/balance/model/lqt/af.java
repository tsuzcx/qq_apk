package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.ui.e;

public final class af
{
  public static String Vh(int paramInt)
  {
    AppMethodBeat.i(68551);
    Context localContext = aj.getContext();
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
  
  public static void a(final Context paramContext, ckz paramckz)
  {
    AppMethodBeat.i(68552);
    if (paramckz == null)
    {
      AppMethodBeat.o(68552);
      return;
    }
    d.a locala = new d.a(paramContext);
    locala.aXG(paramckz.dxD);
    if (!bt.isNullOrNil(paramckz.Hem)) {
      locala.aXN(paramckz.Hem);
    }
    if (!bt.isNullOrNil(paramckz.CIj)) {
      locala.aXM(paramckz.CIj);
    }
    locala.yR(false);
    locala.a(true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68550);
        ad.i("MicroMsg.LqtUtil", "click item, type: %s", new Object[] { Integer.valueOf(this.Cyv.type) });
        if (this.Cyv.type != 1)
        {
          if (this.Cyv.type == 2)
          {
            e.o(paramContext, this.Cyv.CNU, true);
            AppMethodBeat.o(68550);
            return;
          }
          if (this.Cyv.type == 3) {
            e.v(this.Cyv.CzQ, this.Cyv.CzR, 0, 1061);
          }
        }
        AppMethodBeat.o(68550);
      }
    });
    locala.fMb().show();
    AppMethodBeat.o(68552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.af
 * JD-Core Version:    0.7.0.1
 */