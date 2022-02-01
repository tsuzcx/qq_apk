package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.wallet_core.ui.i;

public final class aj
{
  public static void a(final Context paramContext, efi paramefi)
  {
    AppMethodBeat.i(68552);
    if (paramefi == null)
    {
      AppMethodBeat.o(68552);
      return;
    }
    e.a locala = new e.a(paramContext);
    locala.bDw(paramefi.wording);
    if (!Util.isNullOrNil(paramefi.abkC)) {
      locala.bDD(paramefi.abkC);
    }
    if (!Util.isNullOrNil(paramefi.VmH)) {
      locala.bDC(paramefi.VmH);
    }
    locala.NC(false);
    locala.a(true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68550);
        Log.i("MicroMsg.LqtUtil", "click item, type: %s", new Object[] { Integer.valueOf(aj.this.type) });
        if (aj.this.type != 1)
        {
          if (aj.this.type == 2)
          {
            i.p(paramContext, aj.this.VsH, true);
            AppMethodBeat.o(68550);
            return;
          }
          if (aj.this.type == 3) {
            i.y(aj.this.VcU, aj.this.VcV, 0, 1061);
          }
        }
        AppMethodBeat.o(68550);
      }
    });
    locala.jHH().show();
    AppMethodBeat.o(68552);
  }
  
  public static String arK(int paramInt)
  {
    AppMethodBeat.i(316126);
    Context localContext = MMApplicationContext.getContext();
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(316126);
      return str;
      str = localContext.getString(a.i.wallet_lqt_plan_salary_checkpwd_add_text);
      continue;
      str = localContext.getString(a.i.wallet_lqt_plan_checkpwd_open_text);
      continue;
      str = localContext.getString(a.i.wallet_lqt_plan_checkpwd_stop_text);
      continue;
      str = localContext.getString(a.i.wallet_lqt_plan_checkpwd_delete_text);
      continue;
      str = localContext.getString(a.i.wallet_lqt_plan_checkpwd_modify_text);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.aj
 * JD-Core Version:    0.7.0.1
 */