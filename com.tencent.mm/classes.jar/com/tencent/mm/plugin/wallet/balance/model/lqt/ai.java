package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dmu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.wallet_core.ui.g;

public final class ai
{
  public static void a(final Context paramContext, dmu paramdmu)
  {
    AppMethodBeat.i(68552);
    if (paramdmu == null)
    {
      AppMethodBeat.o(68552);
      return;
    }
    d.a locala = new d.a(paramContext);
    locala.bBd(paramdmu.wording);
    if (!Util.isNullOrNil(paramdmu.TTV)) {
      locala.bBk(paramdmu.TTV);
    }
    if (!Util.isNullOrNil(paramdmu.Oxw)) {
      locala.bBj(paramdmu.Oxw);
    }
    locala.HG(false);
    locala.a(true, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(68550);
        Log.i("MicroMsg.LqtUtil", "click item, type: %s", new Object[] { Integer.valueOf(this.OmG.type) });
        if (this.OmG.type != 1)
        {
          if (this.OmG.type == 2)
          {
            g.p(paramContext, this.OmG.ODt, true);
            AppMethodBeat.o(68550);
            return;
          }
          if (this.OmG.type == 3) {
            g.v(this.OmG.Ooe, this.OmG.Oof, 0, 1061);
          }
        }
        AppMethodBeat.o(68550);
      }
    });
    locala.icu().show();
    AppMethodBeat.o(68552);
  }
  
  public static String amb(int paramInt)
  {
    AppMethodBeat.i(271635);
    Context localContext = MMApplicationContext.getContext();
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(271635);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.ai
 * JD-Core Version:    0.7.0.1
 */