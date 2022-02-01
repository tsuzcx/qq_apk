package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.order.ui.a.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public static e a(final Context paramContext, MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66656);
    e locale = new e(paramContext);
    if (!Util.isNullOrNil(paramMallTransactionObject.AOu)) {}
    for (locale.AQz = paramContext.getString(2131768027);; locale.AQz = paramContext.getString(2131768030))
    {
      locale.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66655);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/order/model/MallOrderPreferenceManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          paramAnonymousView = new LinkedList();
          localObject = new LinkedList();
          if (!Util.isNullOrNil(this.ANT.dCu))
          {
            ((List)localObject).add(Integer.valueOf(0));
            paramAnonymousView.add(paramContext.getString(2131768028));
          }
          if (!Util.isNullOrNil(this.ANT.ANP))
          {
            ((List)localObject).add(Integer.valueOf(1));
            paramAnonymousView.add(paramContext.getString(2131768029));
          }
          if (!Util.isNullOrNil(this.ANT.AOu))
          {
            ((List)localObject).add(Integer.valueOf(2));
            paramAnonymousView.add(paramContext.getString(2131768031));
          }
          if (((List)localObject).size() == 1)
          {
            a.a(((Integer)((List)localObject).get(0)).intValue(), paramContext, this.ANT);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/model/MallOrderPreferenceManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66655);
            return;
          }
          h.b(paramContext, null, paramAnonymousView, (List)localObject, null, new h.e()
          {
            public final void cy(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(66654);
              a.a(paramAnonymous2Int2, a.1.this.val$context, a.1.this.ANT);
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
      g.aAi();
      as localas = ((l)g.af(l.class)).aSN().Kn(paramMallTransactionObject.dCu);
      if ((localas != null) && (c.oR(localas.field_type)))
      {
        com.tencent.mm.wallet_core.ui.f.ao(paramContext, paramMallTransactionObject.dCu);
        AppMethodBeat.o(66657);
        return;
      }
      com.tencent.mm.wallet_core.ui.f.am(paramContext, paramMallTransactionObject.dCu);
      AppMethodBeat.o(66657);
      return;
      com.tencent.mm.wallet_core.ui.f.cM(paramContext, paramMallTransactionObject.ANP);
      AppMethodBeat.o(66657);
      return;
      com.tencent.mm.wallet_core.ui.f.p(paramContext, paramMallTransactionObject.AOu, false);
    }
  }
  
  public static abstract interface a
  {
    public abstract List<Preference> a(Context paramContext, com.tencent.mm.ui.base.preference.f paramf, MallTransactionObject paramMallTransactionObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.a
 * JD-Core Version:    0.7.0.1
 */