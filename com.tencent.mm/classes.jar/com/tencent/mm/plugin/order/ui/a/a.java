package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements a.a
{
  public com.tencent.mm.wallet_core.ui.c mRg;
  
  public final List<Preference> a(Context paramContext, com.tencent.mm.ui.base.preference.f paramf, MallTransactionObject paramMallTransactionObject)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject1;
    Object localObject2;
    label149:
    label353:
    int j;
    if (paramMallTransactionObject.bBt == 2)
    {
      i = 1;
      if ((!bk.bl(paramMallTransactionObject.mPb)) && (!bk.bl(paramMallTransactionObject.fPM)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).iZG = paramMallTransactionObject.fPM;
        ((d)localObject1).mName = paramMallTransactionObject.mPb;
        ((d)localObject1).mOnClickListener = new a.1(this, paramMallTransactionObject, paramContext);
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      localObject2 = new i(paramContext);
      ((i)localObject2).mRG = e.d(paramMallTransactionObject.iHP, paramMallTransactionObject.mOZ);
      if (i == 0) {
        break label1555;
      }
      localObject1 = paramContext.getString(a.i.wallet_order_info_amount_income);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!bk.bl(paramMallTransactionObject.mOR)) {
        ((i)localObject2).KM(paramMallTransactionObject.mOR);
      }
      localArrayList.add(localObject2);
      boolean bool = false;
      if (paramMallTransactionObject.iHP != paramMallTransactionObject.mPf)
      {
        localObject1 = new h(paramContext);
        ((h)localObject1).mRD = false;
        ((h)localObject1).mRE = true;
        localArrayList.add(localObject1);
        localObject1 = new f(paramContext);
        ((f)localObject1).setContent(e.d(paramMallTransactionObject.mPf, paramMallTransactionObject.mOZ));
        ((f)localObject1).setTitle(a.i.wallet_order_info_orginal_amount);
        localArrayList.add(localObject1);
        bool = true;
      }
      if ((paramMallTransactionObject.iHP != paramMallTransactionObject.mPf) && (!bk.bl(paramMallTransactionObject.mPe)))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(a.i.wallet_order_info_discount);
        ((g)localObject1).hcp = paramf;
        localObject2 = paramMallTransactionObject.mPe.split("\n");
        if (localObject2.length != 1) {
          break label1588;
        }
        ((g)localObject1).mRw = localObject2[0];
        localArrayList.add(localObject1);
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).mRD = bool;
      ((h)localObject1).mRE = true;
      localArrayList.add(localObject1);
      if ((i == 0) && (!bk.bl(paramMallTransactionObject.mPo)))
      {
        com.tencent.mm.kernel.g.DQ();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramMallTransactionObject.mPo);
        if ((localObject1 != null) && ((int)((com.tencent.mm.n.a)localObject1).dBe > 0))
        {
          localObject1 = ((com.tencent.mm.n.a)localObject1).Bq();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(a.i.wallet_order_info_spid);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if ((paramMallTransactionObject.ccY == 31) && (i != 0) && (!bk.bl(paramMallTransactionObject.mPv)))
      {
        com.tencent.mm.kernel.g.DQ();
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramMallTransactionObject.mPv);
        if ((localObject1 != null) && ((int)((com.tencent.mm.n.a)localObject1).dBe > 0))
        {
          localObject1 = ((com.tencent.mm.n.a)localObject1).Bq();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(a.i.wallet_order_info_from);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if (!bk.bl(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1655;
        }
        paramf = new f(paramContext);
        if ((paramMallTransactionObject.ccY != 32) && (paramMallTransactionObject.ccY != 33) && (paramMallTransactionObject.ccY != 31)) {
          break label1645;
        }
        paramf.setTitle(a.i.wallet_order_info_collect_remark_txt);
        label663:
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!bk.bl(paramMallTransactionObject.mPz))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_original_feeinfo_title);
        paramf.setContent(paramMallTransactionObject.mPz);
        localArrayList.add(paramf);
      }
      if (!bk.bl(paramMallTransactionObject.mPy))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_rate_title);
        paramf.setContent(paramMallTransactionObject.mPy);
        localArrayList.add(paramf);
      }
      if (!TextUtils.isEmpty(paramMallTransactionObject.mPq))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_charge_fee);
        paramf.setContent(paramMallTransactionObject.mPq);
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
        if ((paramMallTransactionObject.ccY != 31) || (q.Gj().equals(paramMallTransactionObject.mPo)) || (paramMallTransactionObject.mPp <= 0) || (bk.bl(paramMallTransactionObject.mPo)) || (bk.bl(paramMallTransactionObject.bMY))) {
          break label1818;
        }
        localObject1 = paramContext.getString(a.i.remittance_resend_transfer_msg);
        localObject2 = paramMallTransactionObject.mOT + " " + (String)localObject1;
        i = paramMallTransactionObject.mOT.length();
        j = paramMallTransactionObject.mOT.length();
        paramf.a((String)localObject2, i + 1, ((String)localObject1).length() + j + 1, new a.3(this, paramContext, paramMallTransactionObject));
        label1014:
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(a.i.wallet_order_info_deal_time);
      paramf.setContent(e.hP(paramMallTransactionObject.enw));
      localArrayList.add(paramf);
      if (!bk.bl(paramMallTransactionObject.mOX))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(a.i.wallet_order_info_pay_method);
        localObject1 = paramMallTransactionObject.mOX;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!bk.bl(paramMallTransactionObject.mOY)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.mOY + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!bk.bl(paramMallTransactionObject.bMY))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_trans_id);
        paramf.setContent(paramMallTransactionObject.bMY);
        localArrayList.add(paramf);
      }
      if (!bk.bl(paramMallTransactionObject.mOW))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_sp_billno);
        if (paramMallTransactionObject.ccY != 8) {
          break label1847;
        }
        paramf.setContent(paramContext.getString(a.i.wallet_order_info_sp_billno_tip));
        localObject1 = new c(paramContext);
        localObject2 = com.tencent.mm.by.a.a.b(paramContext, paramMallTransactionObject.mOW, 5, 0);
        ((c)localObject1).mRo = e.afn(paramMallTransactionObject.mOW);
        ((c)localObject1).ebo = ((Bitmap)localObject2);
        ((c)localObject1).mOnClickListener = new a.4(this, (Bitmap)localObject2, paramMallTransactionObject);
        localArrayList.add(paramf);
        localArrayList.add(localObject1);
      }
      label1322:
      if (paramMallTransactionObject.mOA.size() != 0) {
        break label1867;
      }
      i = 0;
      label1337:
      if ((i != 0) || ((bk.bl(paramMallTransactionObject.mPj)) && (bk.bl(paramMallTransactionObject.mPa)) && (bk.bl(paramMallTransactionObject.mOD)))) {
        break label1873;
      }
      paramf = new h(paramContext);
      paramf.mRD = true;
      localArrayList.add(paramf);
      localArrayList.add(com.tencent.mm.plugin.order.model.a.a(paramContext, paramMallTransactionObject));
      label1408:
      if (i != 0)
      {
        paramf = new j(paramContext);
        if (paramMallTransactionObject.mOB != 1) {
          break label1918;
        }
        if ((!bk.bl(paramMallTransactionObject.mPj)) || (!bk.bl(paramMallTransactionObject.mPa)) || (!bk.bl(paramMallTransactionObject.mOD)))
        {
          if (bk.bl(paramMallTransactionObject.mPk)) {
            break label1904;
          }
          paramf.mRH = paramMallTransactionObject.mPk;
          label1478:
          paramf.mRI = new a.5(this, paramMallTransactionObject, paramContext);
        }
      }
    }
    for (;;)
    {
      paramf.mOA = paramMallTransactionObject.mOA;
      paramf.mOnClickListener = new a.7(this, paramContext, paramMallTransactionObject);
      paramContext = new h(paramContext);
      paramContext.mRD = true;
      localArrayList.add(paramContext);
      localArrayList.add(paramf);
      return localArrayList;
      i = 0;
      break;
      label1555:
      if (paramMallTransactionObject.ccY == 11)
      {
        localObject1 = paramContext.getString(a.i.wallet_order_info_save_amount);
        break label149;
      }
      localObject1 = paramContext.getString(a.i.wallet_order_info_amount);
      break label149;
      label1588:
      ((g)localObject1).mRw = paramContext.getString(a.i.wallet_order_info_discount_summary, new Object[] { Integer.valueOf(localObject2.length), e.d(paramMallTransactionObject.mPf - paramMallTransactionObject.iHP, paramMallTransactionObject.mOZ) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label353;
      label1645:
      paramf.setTitle(a.i.wallet_order_info_from);
      break label663;
      label1655:
      localObject1 = new f(paramContext);
      if (paramMallTransactionObject.ccY == 31)
      {
        ((f)localObject1).setTitle(a.i.wallet_order_info_remittance_memo);
        label1682:
        if (bk.bl(paramMallTransactionObject.mOP)) {
          break label1806;
        }
        localObject2 = paramContext.getString(a.i.wallet_order_info_check_detail);
        String str = paramMallTransactionObject.desc + " " + (String)localObject2;
        i = paramMallTransactionObject.desc.length();
        j = paramMallTransactionObject.desc.length();
        ((f)localObject1).a(str, i + 1, ((String)localObject2).length() + (j + 1), new a.2(this, paramMallTransactionObject, (f)localObject1, paramf));
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        break;
        ((f)localObject1).setTitle(a.i.wallet_order_info_desc);
        break label1682;
        label1806:
        ((f)localObject1).setContent(paramMallTransactionObject.desc);
      }
      label1818:
      paramf.setContent(paramMallTransactionObject.mOT);
      if (bk.bl(paramMallTransactionObject.mOU)) {
        break label1014;
      }
      paramf.KL(paramMallTransactionObject.mOU);
      break label1014;
      label1847:
      paramf.setContent(paramMallTransactionObject.mOW);
      localArrayList.add(paramf);
      break label1322;
      label1867:
      i = 1;
      break label1337;
      label1873:
      paramf = new h(paramContext);
      paramf.mRD = true;
      paramf.hBd = false;
      localArrayList.add(paramf);
      break label1408;
      label1904:
      paramf.mRH = paramContext.getString(a.i.wallet_order_info_support_customer_service);
      break label1478;
      label1918:
      if (!bk.bl(paramMallTransactionObject.mPk))
      {
        paramf.mRH = paramMallTransactionObject.mPk;
        paramf.mRI = new a.6(this, paramContext, paramMallTransactionObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a
 * JD-Core Version:    0.7.0.1
 */