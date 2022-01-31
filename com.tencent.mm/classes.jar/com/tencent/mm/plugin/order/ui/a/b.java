package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements a.a
{
  public final List<Preference> a(Context paramContext, final com.tencent.mm.ui.base.preference.f paramf, final MallTransactionObject paramMallTransactionObject)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramMallTransactionObject.bBt == 2) {}
    Object localObject1;
    for (int i = 1;; i = 0)
    {
      if ((!bk.bl(paramMallTransactionObject.mPb)) && (!bk.bl(paramMallTransactionObject.fPM)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).iZG = paramMallTransactionObject.fPM;
        ((d)localObject1).mName = paramMallTransactionObject.mPb;
        ((d)localObject1).mOnClickListener = new b.1(this, paramMallTransactionObject, paramContext);
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      y.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + paramMallTransactionObject.mPq + " and fetchTotalFee is " + paramMallTransactionObject.mPA);
      if (TextUtils.isEmpty(paramMallTransactionObject.mPq)) {
        break;
      }
      localObject1 = new i(paramContext);
      ((i)localObject1).mRG = e.d(paramMallTransactionObject.mPA, paramMallTransactionObject.mOZ);
      ((i)localObject1).setTitle(paramContext.getString(a.i.wallet_order_info_amount_outcome));
      if (!bk.bl(paramMallTransactionObject.mPB)) {
        ((i)localObject1).KM(paramMallTransactionObject.mPB);
      }
      localArrayList.add(localObject1);
      localObject1 = new h(paramContext);
      ((h)localObject1).mRD = false;
      ((h)localObject1).mRE = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(a.i.wallet_order_info_fetch_amount);
      ((f)localObject1).setContent(e.d(paramMallTransactionObject.iHP, paramMallTransactionObject.mOZ));
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(a.i.wallet_order_info_charge_fee);
      ((f)localObject1).setContent(paramMallTransactionObject.mPq);
      localArrayList.add(localObject1);
      if (!bk.bl(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1133;
        }
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_from);
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!bk.bl(paramMallTransactionObject.mOO))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_merchant_name);
        paramf.setContent(paramMallTransactionObject.mOO);
        localArrayList.add(paramf);
      }
      if (!bk.bl(paramMallTransactionObject.mOT))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_status);
        paramf.setContent(paramMallTransactionObject.mOT);
        if (!bk.bl(paramMallTransactionObject.mOU)) {
          paramf.KL(paramMallTransactionObject.mOU);
        }
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(a.i.wallet_order_info_fetch_deal_time);
      paramf.setContent(e.hP(paramMallTransactionObject.enw));
      localArrayList.add(paramf);
      if (paramMallTransactionObject.mPm <= 0) {
        break label1276;
      }
      paramf = new f(paramContext);
      paramf.setTitle(a.i.wallet_order_info_fetch_arrive_time);
      paramf.setContent(e.hP(paramMallTransactionObject.mPm));
      localArrayList.add(paramf);
      label566:
      if (!bk.bl(paramMallTransactionObject.mOX))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(a.i.wallet_order_info_fetch_bank);
        localObject1 = paramMallTransactionObject.mOX;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!bk.bl(paramMallTransactionObject.mOY)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.mOY + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!bk.bl(paramMallTransactionObject.mOW))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_fetch_trans_id);
        paramf.setContent(paramMallTransactionObject.mOW);
        localArrayList.add(paramf);
      }
      if ((bk.bl(paramMallTransactionObject.mPj)) && (bk.bl(paramMallTransactionObject.mPa)) && (bk.bl(paramMallTransactionObject.mOD))) {
        break label1333;
      }
      paramf = new h(paramContext);
      paramf.mRD = true;
      localArrayList.add(paramf);
      localArrayList.add(a.a(paramContext, paramMallTransactionObject));
      return localArrayList;
    }
    Object localObject2 = new i(paramContext);
    ((i)localObject2).mRG = e.d(paramMallTransactionObject.iHP, paramMallTransactionObject.mOZ);
    if (i != 0)
    {
      localObject1 = paramContext.getString(a.i.wallet_order_info_amount_income);
      label820:
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!bk.bl(paramMallTransactionObject.mOR)) {
        ((i)localObject2).KM(paramMallTransactionObject.mOR);
      }
      localArrayList.add(localObject2);
      if ((paramMallTransactionObject.iHP == paramMallTransactionObject.mPf) || (paramMallTransactionObject.mPf <= 0.0D)) {
        break label1364;
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).mRD = false;
      ((h)localObject1).mRE = true;
      localArrayList.add(localObject1);
      localObject1 = new f(paramContext);
      ((f)localObject1).setContent(e.d(paramMallTransactionObject.mPf, paramMallTransactionObject.mOZ));
      ((f)localObject1).setTitle(a.i.wallet_order_info_orginal_amount);
      localArrayList.add(localObject1);
      if (!bk.bl(paramMallTransactionObject.mPe))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(a.i.wallet_order_info_discount);
        ((g)localObject1).hcp = paramf;
        localObject2 = paramMallTransactionObject.mPe.split("\n");
        if (localObject2.length != 1) {
          break label1076;
        }
        ((g)localObject1).mRw = localObject2[0];
        label1015:
        localArrayList.add(localObject1);
      }
    }
    label1076:
    label1333:
    label1364:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = new h(paramContext);
      ((h)localObject1).mRD = bool;
      ((h)localObject1).mRE = true;
      localArrayList.add(localObject1);
      break;
      localObject1 = paramContext.getString(a.i.wallet_order_info_fetch_amount);
      break label820;
      ((g)localObject1).mRw = paramContext.getString(a.i.wallet_order_info_discount_summary, new Object[] { Integer.valueOf(localObject2.length), e.d(paramMallTransactionObject.mPf - paramMallTransactionObject.iHP, paramMallTransactionObject.mOZ) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label1015;
      label1133:
      localObject1 = new f(paramContext);
      ((f)localObject1).setTitle(a.i.wallet_order_info_desc);
      if (!bk.bl(paramMallTransactionObject.mOP))
      {
        localObject2 = paramContext.getString(a.i.wallet_order_info_check_detail);
        String str = paramMallTransactionObject.desc + " " + (String)localObject2;
        i = paramMallTransactionObject.desc.length();
        int j = paramMallTransactionObject.desc.length();
        ((f)localObject1).a(str, i + 1, ((String)localObject2).length() + (j + 1), new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            paramAnonymousView = paramMallTransactionObject.desc + "\n" + paramMallTransactionObject.mOP;
            this.mRj.setContent(paramAnonymousView);
            paramf.notifyDataSetChanged();
          }
        });
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        break;
        ((f)localObject1).setContent(paramMallTransactionObject.desc);
      }
      label1276:
      if (paramMallTransactionObject.mPl > 0)
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_fetch_pre_time);
        paramf.setContent(e.hP(paramMallTransactionObject.mPl));
        localArrayList.add(paramf);
        break label566;
      }
      y.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
      break label566;
      paramContext = new h(paramContext);
      paramContext.mRD = true;
      paramContext.hBd = false;
      localArrayList.add(paramContext);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.b
 * JD-Core Version:    0.7.0.1
 */