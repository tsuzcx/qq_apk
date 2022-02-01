package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dde;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.ui.f;

public final class ah
{
  public static void a(final Context paramContext, dde paramdde)
  {
    AppMethodBeat.i(68552);
    if (paramdde == null)
    {
      AppMethodBeat.o(68552);
      return;
    }
    d.a locala = new d.a(paramContext);
    locala.boo(paramdde.dQx);
    if (!Util.isNullOrNil(paramdde.MIh)) {
      locala.bov(paramdde.MIh);
    }
    if (!Util.isNullOrNil(paramdde.HFD)) {
      locala.bou(paramdde.HFD);
    }
    locala.Dk(false);
    locala.a(true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68550);
        Log.i("MicroMsg.LqtUtil", "click item, type: %s", new Object[] { Integer.valueOf(this.HuT.type) });
        if (this.HuT.type != 1)
        {
          if (this.HuT.type == 2)
          {
            f.p(paramContext, this.HuT.HLy, true);
            AppMethodBeat.o(68550);
            return;
          }
          if (this.HuT.type == 3) {
            f.u(this.HuT.Hwr, this.HuT.Hws, 0, 1061);
          }
        }
        AppMethodBeat.o(68550);
      }
    });
    locala.hbn().show();
    AppMethodBeat.o(68552);
  }
  
  public static String aeo(int paramInt)
  {
    AppMethodBeat.i(68551);
    Context localContext = MMApplicationContext.getContext();
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(68551);
      return str;
      str = localContext.getString(2131767922);
      continue;
      str = localContext.getString(2131767876);
      continue;
      str = localContext.getString(2131767877);
      continue;
      str = localContext.getString(2131767874);
      continue;
      str = localContext.getString(2131767875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ah
 * JD-Core Version:    0.7.0.1
 */