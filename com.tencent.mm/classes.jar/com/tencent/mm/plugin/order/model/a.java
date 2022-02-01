package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.order.ui.a.e;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static e a(final Context paramContext, MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66656);
    e locale = new e(paramContext);
    if (!bu.isNullOrNil(paramMallTransactionObject.wSA)) {}
    for (locale.wUD = paramContext.getString(2131765578);; locale.wUD = paramContext.getString(2131765581))
    {
      locale.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66655);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/model/MallOrderPreferenceManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          paramAnonymousView = new LinkedList();
          localObject = new LinkedList();
          if (!bu.isNullOrNil(this.wRY.wSr))
          {
            ((List)localObject).add(Integer.valueOf(0));
            paramAnonymousView.add(paramContext.getString(2131765579));
          }
          if (!bu.isNullOrNil(this.wRY.wRU))
          {
            ((List)localObject).add(Integer.valueOf(1));
            paramAnonymousView.add(paramContext.getString(2131765580));
          }
          if (!bu.isNullOrNil(this.wRY.wSA))
          {
            ((List)localObject).add(Integer.valueOf(2));
            paramAnonymousView.add(paramContext.getString(2131765582));
          }
          if (((List)localObject).size() == 1)
          {
            a.a(((Integer)((List)localObject).get(0)).intValue(), paramContext, this.wRY);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/model/MallOrderPreferenceManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66655);
            return;
          }
          h.b(paramContext, null, paramAnonymousView, (List)localObject, null, new h.d()
          {
            public final void cv(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(66654);
              a.a(paramAnonymous2Int2, a.1.this.val$context, a.1.this.wRY);
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
      g.ajS();
      an localan = ((l)g.ab(l.class)).azF().BH(paramMallTransactionObject.wSr);
      if ((localan != null) && (c.lO(localan.field_type)))
      {
        com.tencent.mm.wallet_core.ui.f.ag(paramContext, paramMallTransactionObject.wSr);
        AppMethodBeat.o(66657);
        return;
      }
      com.tencent.mm.wallet_core.ui.f.ae(paramContext, paramMallTransactionObject.wSr);
      AppMethodBeat.o(66657);
      return;
      com.tencent.mm.wallet_core.ui.f.ct(paramContext, paramMallTransactionObject.wRU);
      AppMethodBeat.o(66657);
      return;
      com.tencent.mm.wallet_core.ui.f.p(paramContext, paramMallTransactionObject.wSA, false);
    }
  }
  
  public static abstract interface a
  {
    public abstract List<Preference> a(Context paramContext, com.tencent.mm.ui.base.preference.f paramf, MallTransactionObject paramMallTransactionObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.a
 * JD-Core Version:    0.7.0.1
 */