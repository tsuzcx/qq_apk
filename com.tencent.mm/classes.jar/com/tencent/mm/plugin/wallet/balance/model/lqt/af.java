package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.clt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.ui.f;

public final class af
{
  public static String VO(int paramInt)
  {
    AppMethodBeat.i(68551);
    Context localContext = ak.getContext();
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
  
  public static void a(final Context paramContext, clt paramclt)
  {
    AppMethodBeat.i(68552);
    if (paramclt == null)
    {
      AppMethodBeat.o(68552);
      return;
    }
    d.a locala = new d.a(paramContext);
    locala.aZi(paramclt.dyI);
    if (!bu.isNullOrNil(paramclt.HxM)) {
      locala.aZp(paramclt.HxM);
    }
    if (!bu.isNullOrNil(paramclt.CZP)) {
      locala.aZo(paramclt.CZP);
    }
    locala.zf(false);
    locala.a(true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68550);
        ae.i("MicroMsg.LqtUtil", "click item, type: %s", new Object[] { Integer.valueOf(this.CQa.type) });
        if (this.CQa.type != 1)
        {
          if (this.CQa.type == 2)
          {
            f.p(paramContext, this.CQa.DfC, true);
            AppMethodBeat.o(68550);
            return;
          }
          if (this.CQa.type == 3) {
            f.u(this.CQa.CRv, this.CQa.CRw, 0, 1061);
          }
        }
        AppMethodBeat.o(68550);
      }
    });
    locala.fQv().show();
    AppMethodBeat.o(68552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.af
 * JD-Core Version:    0.7.0.1
 */