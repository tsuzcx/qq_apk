package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.order.ui.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k.e;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.i;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static e a(final Context paramContext, MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66656);
    e locale = new e(paramContext);
    if (!Util.isNullOrNil(paramMallTransactionObject.MEy)) {}
    for (locale.MGz = paramContext.getString(a.i.wallet_order_info_support);; locale.MGz = paramContext.getString(a.i.wallet_order_info_support_customer_service))
    {
      locale.mOnClickListener = new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(262777);
          paramAnonymousView = new LinkedList();
          LinkedList localLinkedList = new LinkedList();
          if (!Util.isNullOrNil(a.this.hzv))
          {
            localLinkedList.add(Integer.valueOf(0));
            paramAnonymousView.add(paramContext.getString(a.i.wallet_order_info_support_biz));
          }
          if (!Util.isNullOrNil(a.this.MDU))
          {
            localLinkedList.add(Integer.valueOf(1));
            paramAnonymousView.add(paramContext.getString(a.i.wallet_order_info_support_call));
          }
          if (!Util.isNullOrNil(a.this.MEy))
          {
            localLinkedList.add(Integer.valueOf(2));
            paramAnonymousView.add(paramContext.getString(a.i.wallet_order_info_support_safeguard));
          }
          if (localLinkedList.size() == 1)
          {
            a.a(((Integer)localLinkedList.get(0)).intValue(), paramContext, a.this);
            AppMethodBeat.o(262777);
            return;
          }
          com.tencent.mm.ui.base.k.b(paramContext, null, paramAnonymousView, localLinkedList, null, new k.e()
          {
            public final void onClick(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(66654);
              a.a(paramAnonymous2Int2, a.1.this.val$context, a.this);
              AppMethodBeat.o(66654);
            }
          });
          AppMethodBeat.o(262777);
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
      h.baF();
      au localau = ((n)h.ax(n.class)).bzA().JE(paramMallTransactionObject.hzv);
      if ((localau != null) && (d.rs(localau.field_type)))
      {
        i.ap(paramContext, paramMallTransactionObject.hzv);
        AppMethodBeat.o(66657);
        return;
      }
      i.an(paramContext, paramMallTransactionObject.hzv);
      AppMethodBeat.o(66657);
      return;
      i.dg(paramContext, paramMallTransactionObject.MDU);
      AppMethodBeat.o(66657);
      return;
      i.p(paramContext, paramMallTransactionObject.MEy, false);
    }
  }
  
  public static abstract interface a
  {
    public abstract List<Preference> a(Context paramContext, f paramf, MallTransactionObject paramMallTransactionObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.a
 * JD-Core Version:    0.7.0.1
 */