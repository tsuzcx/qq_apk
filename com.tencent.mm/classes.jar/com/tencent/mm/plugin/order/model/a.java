package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static com.tencent.mm.plugin.order.ui.a.e a(final Context paramContext, MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66656);
    com.tencent.mm.plugin.order.ui.a.e locale = new com.tencent.mm.plugin.order.ui.a.e(paramContext);
    if (!bs.isNullOrNil(paramMallTransactionObject.vxv)) {}
    for (locale.vzy = paramContext.getString(2131765578);; locale.vzy = paramContext.getString(2131765581))
    {
      locale.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66655);
          paramAnonymousView = new LinkedList();
          LinkedList localLinkedList = new LinkedList();
          if (!bs.isNullOrNil(this.vwT.vxm))
          {
            localLinkedList.add(Integer.valueOf(0));
            paramAnonymousView.add(paramContext.getString(2131765579));
          }
          if (!bs.isNullOrNil(this.vwT.vwP))
          {
            localLinkedList.add(Integer.valueOf(1));
            paramAnonymousView.add(paramContext.getString(2131765580));
          }
          if (!bs.isNullOrNil(this.vwT.vxv))
          {
            localLinkedList.add(Integer.valueOf(2));
            paramAnonymousView.add(paramContext.getString(2131765582));
          }
          if (localLinkedList.size() == 1)
          {
            a.a(((Integer)localLinkedList.get(0)).intValue(), paramContext, this.vwT);
            AppMethodBeat.o(66655);
            return;
          }
          h.b(paramContext, null, paramAnonymousView, localLinkedList, null, new h.d()
          {
            public final void ct(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(66654);
              a.a(paramAnonymous2Int2, a.1.this.val$context, a.1.this.vwT);
              AppMethodBeat.o(66654);
            }
          });
          AppMethodBeat.o(66655);
        }
      };
      AppMethodBeat.o(66656);
      return locale;
    }
  }
  
  public static void a(int paramInt, Context paramContext, MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66657);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(66657);
      return;
      g.agS();
      ai localai = ((k)g.ab(k.class)).awB().aNt(paramMallTransactionObject.vxm);
      if ((localai != null) && (b.ln(localai.field_type)))
      {
        com.tencent.mm.wallet_core.ui.e.af(paramContext, paramMallTransactionObject.vxm);
        AppMethodBeat.o(66657);
        return;
      }
      com.tencent.mm.wallet_core.ui.e.ad(paramContext, paramMallTransactionObject.vxm);
      AppMethodBeat.o(66657);
      return;
      com.tencent.mm.wallet_core.ui.e.cn(paramContext, paramMallTransactionObject.vwP);
      AppMethodBeat.o(66657);
      return;
      com.tencent.mm.wallet_core.ui.e.o(paramContext, paramMallTransactionObject.vxv, false);
    }
  }
  
  public static abstract interface a
  {
    public abstract List<Preference> a(Context paramContext, f paramf, MallTransactionObject paramMallTransactionObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.a
 * JD-Core Version:    0.7.0.1
 */