package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static com.tencent.mm.plugin.order.ui.a.e a(final Context paramContext, MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66656);
    com.tencent.mm.plugin.order.ui.a.e locale = new com.tencent.mm.plugin.order.ui.a.e(paramContext);
    if (!bt.isNullOrNil(paramMallTransactionObject.wCP)) {}
    for (locale.wES = paramContext.getString(2131765578);; locale.wES = paramContext.getString(2131765581))
    {
      locale.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66655);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/model/MallOrderPreferenceManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = new LinkedList();
          localObject = new LinkedList();
          if (!bt.isNullOrNil(this.wCn.wCG))
          {
            ((List)localObject).add(Integer.valueOf(0));
            paramAnonymousView.add(paramContext.getString(2131765579));
          }
          if (!bt.isNullOrNil(this.wCn.wCj))
          {
            ((List)localObject).add(Integer.valueOf(1));
            paramAnonymousView.add(paramContext.getString(2131765580));
          }
          if (!bt.isNullOrNil(this.wCn.wCP))
          {
            ((List)localObject).add(Integer.valueOf(2));
            paramAnonymousView.add(paramContext.getString(2131765582));
          }
          if (((List)localObject).size() == 1)
          {
            a.a(((Integer)((List)localObject).get(0)).intValue(), paramContext, this.wCn);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/model/MallOrderPreferenceManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66655);
            return;
          }
          h.b(paramContext, null, paramAnonymousView, (List)localObject, null, new h.d()
          {
            public final void cv(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(66654);
              a.a(paramAnonymous2Int2, a.1.this.val$context, a.1.this.wCn);
              AppMethodBeat.o(66654);
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/model/MallOrderPreferenceManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
      g.ajD();
      am localam = ((l)g.ab(l.class)).azp().Bf(paramMallTransactionObject.wCG);
      if ((localam != null) && (com.tencent.mm.o.b.lM(localam.field_type)))
      {
        com.tencent.mm.wallet_core.ui.e.ae(paramContext, paramMallTransactionObject.wCG);
        AppMethodBeat.o(66657);
        return;
      }
      com.tencent.mm.wallet_core.ui.e.ac(paramContext, paramMallTransactionObject.wCG);
      AppMethodBeat.o(66657);
      return;
      com.tencent.mm.wallet_core.ui.e.cs(paramContext, paramMallTransactionObject.wCj);
      AppMethodBeat.o(66657);
      return;
      com.tencent.mm.wallet_core.ui.e.o(paramContext, paramMallTransactionObject.wCP, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.a
 * JD-Core Version:    0.7.0.1
 */