package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.order.ui.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.g;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static e a(final Context paramContext, MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66656);
    e locale = new e(paramContext);
    if (!Util.isNullOrNil(paramMallTransactionObject.GHI)) {}
    for (locale.GJK = paramContext.getString(a.i.wallet_order_info_support);; locale.GJK = paramContext.getString(a.i.wallet_order_info_support_customer_service))
    {
      locale.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66655);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/model/MallOrderPreferenceManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          paramAnonymousView = new LinkedList();
          localObject = new LinkedList();
          if (!Util.isNullOrNil(this.GHh.fvb))
          {
            ((List)localObject).add(Integer.valueOf(0));
            paramAnonymousView.add(paramContext.getString(a.i.wallet_order_info_support_biz));
          }
          if (!Util.isNullOrNil(this.GHh.GHd))
          {
            ((List)localObject).add(Integer.valueOf(1));
            paramAnonymousView.add(paramContext.getString(a.i.wallet_order_info_support_call));
          }
          if (!Util.isNullOrNil(this.GHh.GHI))
          {
            ((List)localObject).add(Integer.valueOf(2));
            paramAnonymousView.add(paramContext.getString(a.i.wallet_order_info_support_safeguard));
          }
          if (((List)localObject).size() == 1)
          {
            a.a(((Integer)((List)localObject).get(0)).intValue(), paramContext, this.GHh);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/model/MallOrderPreferenceManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66655);
            return;
          }
          com.tencent.mm.ui.base.h.b(paramContext, null, paramAnonymousView, (List)localObject, null, new h.e()
          {
            public final void cS(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(66654);
              a.a(paramAnonymous2Int2, a.1.this.val$context, a.1.this.GHh);
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
      com.tencent.mm.kernel.h.aHH();
      as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramMallTransactionObject.fvb);
      if ((localas != null) && (d.rk(localas.field_type)))
      {
        g.ao(paramContext, paramMallTransactionObject.fvb);
        AppMethodBeat.o(66657);
        return;
      }
      g.am(paramContext, paramMallTransactionObject.fvb);
      AppMethodBeat.o(66657);
      return;
      g.cX(paramContext, paramMallTransactionObject.GHd);
      AppMethodBeat.o(66657);
      return;
      g.p(paramContext, paramMallTransactionObject.GHI, false);
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