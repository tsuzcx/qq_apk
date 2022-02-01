package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements a.a
{
  public final List<Preference> a(final Context paramContext, final com.tencent.mm.ui.base.preference.f paramf, final MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66804);
    ArrayList localArrayList = new ArrayList();
    if (paramMallTransactionObject.hva == 2) {}
    Object localObject1;
    for (int i = 1;; i = 0)
    {
      if ((!Util.isNullOrNil(paramMallTransactionObject.MEr)) && (!Util.isNullOrNil(paramMallTransactionObject.phA)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).xOn = paramMallTransactionObject.phA;
        ((d)localObject1).mName = paramMallTransactionObject.MEr;
        ((d)localObject1).mOnClickListener = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66802);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (!Util.isNullOrNil(paramMallTransactionObject.hzv)) {
              com.tencent.mm.wallet_core.ui.i.an(paramContext, paramMallTransactionObject.hzv);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66802);
          }
        };
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      Log.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + paramMallTransactionObject.MEF + " and fetchTotalFee is " + paramMallTransactionObject.MEP);
      if (TextUtils.isEmpty(paramMallTransactionObject.MEF)) {
        break;
      }
      localObject1 = new i(paramContext);
      ((i)localObject1).MGQ = com.tencent.mm.wallet_core.ui.i.e(paramMallTransactionObject.MEP, paramMallTransactionObject.MEq);
      ((i)localObject1).setTitle(paramContext.getString(a.i.wallet_order_info_amount_outcome));
      if (!Util.isNullOrNil(paramMallTransactionObject.MEQ)) {
        ((i)localObject1).aRj(paramMallTransactionObject.MEQ);
      }
      localArrayList.add(localObject1);
      localObject1 = new h(paramContext);
      ((h)localObject1).MGN = false;
      ((h)localObject1).MGO = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(a.i.wallet_order_info_fetch_amount);
      ((f)localObject1).setContent(com.tencent.mm.wallet_core.ui.i.e(paramMallTransactionObject.wZe, paramMallTransactionObject.MEq));
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(a.i.wallet_order_info_charge_fee);
      ((f)localObject1).setContent(paramMallTransactionObject.MEF);
      localArrayList.add(localObject1);
      if (!Util.isNullOrNil(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1151;
        }
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_from);
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.MEf))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_merchant_name);
        paramf.setContent(paramMallTransactionObject.MEf);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.MEk))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_status);
        paramf.setContent(paramMallTransactionObject.MEk);
        if (!Util.isNullOrNil(paramMallTransactionObject.MEl)) {
          paramf.aRi(paramMallTransactionObject.MEl);
        }
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(a.i.wallet_order_info_fetch_deal_time);
      paramf.setContent(com.tencent.mm.wallet_core.ui.i.vh(paramMallTransactionObject.createTime));
      localArrayList.add(paramf);
      if (paramMallTransactionObject.MEB <= 0) {
        break label1294;
      }
      paramf = new f(paramContext);
      paramf.setTitle(a.i.wallet_order_info_fetch_arrive_time);
      paramf.setContent(com.tencent.mm.wallet_core.ui.i.vh(paramMallTransactionObject.MEB));
      localArrayList.add(paramf);
      label571:
      if (!Util.isNullOrNil(paramMallTransactionObject.MEo))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(a.i.wallet_order_info_fetch_bank);
        localObject1 = paramMallTransactionObject.MEo;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!Util.isNullOrNil(paramMallTransactionObject.MEp)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.MEp + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.MEn))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_fetch_trans_id);
        paramf.setContent(paramMallTransactionObject.MEn);
        localArrayList.add(paramf);
      }
      if ((Util.isNullOrNil(paramMallTransactionObject.MEy)) && (Util.isNullOrNil(paramMallTransactionObject.hzv)) && (Util.isNullOrNil(paramMallTransactionObject.MDU))) {
        break label1351;
      }
      paramf = new h(paramContext);
      paramf.MGN = true;
      localArrayList.add(paramf);
      localArrayList.add(com.tencent.mm.plugin.order.model.a.a(paramContext, paramMallTransactionObject));
      label776:
      AppMethodBeat.o(66804);
      return localArrayList;
    }
    Object localObject2 = new i(paramContext);
    ((i)localObject2).MGQ = com.tencent.mm.wallet_core.ui.i.e(paramMallTransactionObject.wZe, paramMallTransactionObject.MEq);
    label830:
    boolean bool2;
    if (i != 0)
    {
      localObject1 = paramContext.getString(a.i.wallet_order_info_amount_income);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!Util.isNullOrNil(paramMallTransactionObject.MEi)) {
        ((i)localObject2).aRj(paramMallTransactionObject.MEi);
      }
      localArrayList.add(localObject2);
      if ((paramMallTransactionObject.wZe == paramMallTransactionObject.MEu) || (paramMallTransactionObject.MEu <= 0.0D)) {
        break label1382;
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).MGN = false;
      ((h)localObject1).MGO = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setContent(com.tencent.mm.wallet_core.ui.i.e(paramMallTransactionObject.MEu, paramMallTransactionObject.MEq));
      ((f)localObject1).setTitle(a.i.wallet_order_info_orginal_amount);
      localArrayList.add(localObject1);
      bool2 = true;
      bool1 = bool2;
      if (!Util.isNullOrNil(paramMallTransactionObject.DUX))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(a.i.wallet_order_info_discount);
        ((g)localObject1).pkD = paramf;
        localObject2 = paramMallTransactionObject.DUX.split("\n");
        if (localObject2.length != 1) {
          break label1094;
        }
        ((g)localObject1).MGG = localObject2[0];
        label1032:
        localArrayList.add(localObject1);
      }
    }
    label1094:
    label1351:
    label1382:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localObject1 = new h(paramContext);
      ((h)localObject1).MGN = bool1;
      ((h)localObject1).MGO = true;
      localArrayList.add(localObject1);
      break;
      localObject1 = paramContext.getString(a.i.wallet_order_info_fetch_amount);
      break label830;
      ((g)localObject1).MGG = paramContext.getString(a.i.wallet_order_info_discount_summary, new Object[] { Integer.valueOf(localObject2.length), com.tencent.mm.wallet_core.ui.i.e(paramMallTransactionObject.MEu - paramMallTransactionObject.wZe, paramMallTransactionObject.MEq) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label1032;
      label1151:
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(a.i.wallet_order_info_desc);
      if (!Util.isNullOrNil(paramMallTransactionObject.MEg))
      {
        localObject2 = paramContext.getString(a.i.wallet_order_info_check_detail);
        String str = paramMallTransactionObject.desc + " " + (String)localObject2;
        i = paramMallTransactionObject.desc.length();
        int j = paramMallTransactionObject.desc.length();
        ((f)localObject1).a(str, i + 1, ((String)localObject2).length() + (j + 1), new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66803);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = paramMallTransactionObject.desc + "\n" + paramMallTransactionObject.MEg;
            this.MGt.setContent(paramAnonymousView);
            paramf.notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/FetchOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66803);
          }
        });
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        break;
        ((f)localObject1).setContent(paramMallTransactionObject.desc);
      }
      if (paramMallTransactionObject.MEA > 0)
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_fetch_pre_time);
        paramf.setContent(com.tencent.mm.wallet_core.ui.i.vh(paramMallTransactionObject.MEA));
        localArrayList.add(paramf);
        break label571;
      }
      Log.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
      break label571;
      paramContext = new h(paramContext);
      paramContext.MGN = true;
      paramContext.uOJ = false;
      localArrayList.add(paramContext);
      break label776;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.b
 * JD-Core Version:    0.7.0.1
 */