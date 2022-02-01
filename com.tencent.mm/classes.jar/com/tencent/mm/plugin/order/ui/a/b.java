package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a;
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
  public final List<Preference> a(Context paramContext, com.tencent.mm.ui.base.preference.f paramf, MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66804);
    ArrayList localArrayList = new ArrayList();
    if (paramMallTransactionObject.fqR == 2) {}
    Object localObject1;
    for (int i = 1;; i = 0)
    {
      if ((!Util.isNullOrNil(paramMallTransactionObject.GHA)) && (!Util.isNullOrNil(paramMallTransactionObject.mnM)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).uFL = paramMallTransactionObject.mnM;
        ((d)localObject1).mName = paramMallTransactionObject.GHA;
        ((d)localObject1).mOnClickListener = new b.1(this, paramMallTransactionObject, paramContext);
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      Log.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + paramMallTransactionObject.GHP + " and fetchTotalFee is " + paramMallTransactionObject.GHZ);
      if (TextUtils.isEmpty(paramMallTransactionObject.GHP)) {
        break;
      }
      localObject1 = new i(paramContext);
      ((i)localObject1).GKb = com.tencent.mm.wallet_core.ui.g.d(paramMallTransactionObject.GHZ, paramMallTransactionObject.GHz);
      ((i)localObject1).setTitle(paramContext.getString(a.i.wallet_order_info_amount_outcome));
      if (!Util.isNullOrNil(paramMallTransactionObject.GIa)) {
        ((i)localObject1).aUd(paramMallTransactionObject.GIa);
      }
      localArrayList.add(localObject1);
      localObject1 = new h(paramContext);
      ((h)localObject1).GJY = false;
      ((h)localObject1).GJZ = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(a.i.wallet_order_info_fetch_amount);
      ((f)localObject1).setContent(com.tencent.mm.wallet_core.ui.g.d(paramMallTransactionObject.tVK, paramMallTransactionObject.GHz));
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(a.i.wallet_order_info_charge_fee);
      ((f)localObject1).setContent(paramMallTransactionObject.GHP);
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
      if (!Util.isNullOrNil(paramMallTransactionObject.GHo))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_merchant_name);
        paramf.setContent(paramMallTransactionObject.GHo);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.GHt))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_status);
        paramf.setContent(paramMallTransactionObject.GHt);
        if (!Util.isNullOrNil(paramMallTransactionObject.GHu)) {
          paramf.aUc(paramMallTransactionObject.GHu);
        }
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(a.i.wallet_order_info_fetch_deal_time);
      paramf.setContent(com.tencent.mm.wallet_core.ui.g.uW(paramMallTransactionObject.createTime));
      localArrayList.add(paramf);
      if (paramMallTransactionObject.GHL <= 0) {
        break label1294;
      }
      paramf = new f(paramContext);
      paramf.setTitle(a.i.wallet_order_info_fetch_arrive_time);
      paramf.setContent(com.tencent.mm.wallet_core.ui.g.uW(paramMallTransactionObject.GHL));
      localArrayList.add(paramf);
      label571:
      if (!Util.isNullOrNil(paramMallTransactionObject.GHx))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(a.i.wallet_order_info_fetch_bank);
        localObject1 = paramMallTransactionObject.GHx;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!Util.isNullOrNil(paramMallTransactionObject.GHy)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.GHy + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.GHw))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_fetch_trans_id);
        paramf.setContent(paramMallTransactionObject.GHw);
        localArrayList.add(paramf);
      }
      if ((Util.isNullOrNil(paramMallTransactionObject.GHI)) && (Util.isNullOrNil(paramMallTransactionObject.fvb)) && (Util.isNullOrNil(paramMallTransactionObject.GHd))) {
        break label1351;
      }
      paramf = new h(paramContext);
      paramf.GJY = true;
      localArrayList.add(paramf);
      localArrayList.add(a.a(paramContext, paramMallTransactionObject));
      label776:
      AppMethodBeat.o(66804);
      return localArrayList;
    }
    Object localObject2 = new i(paramContext);
    ((i)localObject2).GKb = com.tencent.mm.wallet_core.ui.g.d(paramMallTransactionObject.tVK, paramMallTransactionObject.GHz);
    label830:
    boolean bool2;
    if (i != 0)
    {
      localObject1 = paramContext.getString(a.i.wallet_order_info_amount_income);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!Util.isNullOrNil(paramMallTransactionObject.GHr)) {
        ((i)localObject2).aUd(paramMallTransactionObject.GHr);
      }
      localArrayList.add(localObject2);
      if ((paramMallTransactionObject.tVK == paramMallTransactionObject.GHE) || (paramMallTransactionObject.GHE <= 0.0D)) {
        break label1382;
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).GJY = false;
      ((h)localObject1).GJZ = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setContent(com.tencent.mm.wallet_core.ui.g.d(paramMallTransactionObject.GHE, paramMallTransactionObject.GHz));
      ((f)localObject1).setTitle(a.i.wallet_order_info_orginal_amount);
      localArrayList.add(localObject1);
      bool2 = true;
      bool1 = bool2;
      if (!Util.isNullOrNil(paramMallTransactionObject.GHD))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(a.i.wallet_order_info_discount);
        ((g)localObject1).mrf = paramf;
        localObject2 = paramMallTransactionObject.GHD.split("\n");
        if (localObject2.length != 1) {
          break label1094;
        }
        ((g)localObject1).GJR = localObject2[0];
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
      ((h)localObject1).GJY = bool1;
      ((h)localObject1).GJZ = true;
      localArrayList.add(localObject1);
      break;
      localObject1 = paramContext.getString(a.i.wallet_order_info_fetch_amount);
      break label830;
      ((g)localObject1).GJR = paramContext.getString(a.i.wallet_order_info_discount_summary, new Object[] { Integer.valueOf(localObject2.length), com.tencent.mm.wallet_core.ui.g.d(paramMallTransactionObject.GHE - paramMallTransactionObject.tVK, paramMallTransactionObject.GHz) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label1032;
      label1151:
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(a.i.wallet_order_info_desc);
      if (!Util.isNullOrNil(paramMallTransactionObject.GHp))
      {
        localObject2 = paramContext.getString(a.i.wallet_order_info_check_detail);
        String str = paramMallTransactionObject.desc + " " + (String)localObject2;
        i = paramMallTransactionObject.desc.length();
        int j = paramMallTransactionObject.desc.length();
        ((f)localObject1).a(str, i + 1, ((String)localObject2).length() + (j + 1), new b.2(this, paramMallTransactionObject, (f)localObject1, paramf));
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        break;
        ((f)localObject1).setContent(paramMallTransactionObject.desc);
      }
      if (paramMallTransactionObject.GHK > 0)
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_fetch_pre_time);
        paramf.setContent(com.tencent.mm.wallet_core.ui.g.uW(paramMallTransactionObject.GHK));
        localArrayList.add(paramf);
        break label571;
      }
      Log.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
      break label571;
      paramContext = new h(paramContext);
      paramContext.GJY = true;
      paramContext.rDs = false;
      localArrayList.add(paramContext);
      break label776;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.b
 * JD-Core Version:    0.7.0.1
 */