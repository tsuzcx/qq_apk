package com.tencent.mm.plugin.order.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public final class a
{
  public static com.tencent.mm.plugin.order.ui.a.e a(Context paramContext, MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(43748);
    com.tencent.mm.plugin.order.ui.a.e locale = new com.tencent.mm.plugin.order.ui.a.e(paramContext);
    if (!bo.isNullOrNil(paramMallTransactionObject.ppz)) {}
    for (locale.prC = paramContext.getString(2131305364);; locale.prC = paramContext.getString(2131305367))
    {
      locale.mOnClickListener = new a.1(paramMallTransactionObject, paramContext);
      AppMethodBeat.o(43748);
      return locale;
    }
  }
  
  public static void a(int paramInt, Context paramContext, MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(43749);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(43749);
      return;
      g.RM();
      ad localad = ((j)g.E(j.class)).YA().arw(paramMallTransactionObject.ppq);
      if ((localad != null) && (com.tencent.mm.n.a.je(localad.field_type)))
      {
        com.tencent.mm.wallet_core.ui.e.af(paramContext, paramMallTransactionObject.ppq);
        AppMethodBeat.o(43749);
        return;
      }
      com.tencent.mm.wallet_core.ui.e.ad(paramContext, paramMallTransactionObject.ppq);
      AppMethodBeat.o(43749);
      return;
      com.tencent.mm.wallet_core.ui.e.bT(paramContext, paramMallTransactionObject.poT);
      AppMethodBeat.o(43749);
      return;
      com.tencent.mm.wallet_core.ui.e.m(paramContext, paramMallTransactionObject.ppz, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.a
 * JD-Core Version:    0.7.0.1
 */