package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements a.a
{
  public com.tencent.mm.wallet_core.ui.c GJB;
  
  public final List<Preference> a(final Context paramContext, com.tencent.mm.ui.base.preference.f paramf, final MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66800);
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject1;
    Object localObject2;
    label154:
    label358:
    int j;
    if (paramMallTransactionObject.fqR == 2)
    {
      i = 1;
      if ((!Util.isNullOrNil(paramMallTransactionObject.GHA)) && (!Util.isNullOrNil(paramMallTransactionObject.mnM)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).uFL = paramMallTransactionObject.mnM;
        ((d)localObject1).mName = paramMallTransactionObject.GHA;
        ((d)localObject1).mOnClickListener = new a.1(this, paramMallTransactionObject, paramContext);
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      localObject2 = new i(paramContext);
      ((i)localObject2).GKb = com.tencent.mm.wallet_core.ui.g.d(paramMallTransactionObject.tVK, paramMallTransactionObject.GHz);
      if (i == 0) {
        break label1565;
      }
      localObject1 = paramContext.getString(a.i.wallet_order_info_amount_income);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!Util.isNullOrNil(paramMallTransactionObject.GHr)) {
        ((i)localObject2).aUd(paramMallTransactionObject.GHr);
      }
      localArrayList.add(localObject2);
      boolean bool = false;
      if (paramMallTransactionObject.tVK != paramMallTransactionObject.GHE)
      {
        localObject1 = new h(paramContext);
        ((h)localObject1).GJY = false;
        ((h)localObject1).GJZ = true;
        localArrayList.add(localObject1);
        localObject1 = new f(paramContext);
        ((f)localObject1).setContent(com.tencent.mm.wallet_core.ui.g.d(paramMallTransactionObject.GHE, paramMallTransactionObject.GHz));
        ((f)localObject1).setTitle(a.i.wallet_order_info_orginal_amount);
        localArrayList.add(localObject1);
        bool = true;
      }
      if ((paramMallTransactionObject.tVK != paramMallTransactionObject.GHE) && (!Util.isNullOrNil(paramMallTransactionObject.GHD)))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(a.i.wallet_order_info_discount);
        ((g)localObject1).mrf = paramf;
        localObject2 = paramMallTransactionObject.GHD.split("\n");
        if (localObject2.length != 1) {
          break label1598;
        }
        ((g)localObject1).GJR = localObject2[0];
        localArrayList.add(localObject1);
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).GJY = bool;
      ((h)localObject1).GJZ = true;
      localArrayList.add(localObject1);
      if ((i == 0) && (!Util.isNullOrNil(paramMallTransactionObject.GHN)))
      {
        com.tencent.mm.kernel.h.aHH();
        localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramMallTransactionObject.GHN);
        if ((localObject1 != null) && ((int)((com.tencent.mm.contact.d)localObject1).jxt > 0))
        {
          localObject1 = ((com.tencent.mm.contact.d)localObject1).ays();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(a.i.wallet_order_info_spid);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if ((paramMallTransactionObject.gag == 31) && (i != 0) && (!Util.isNullOrNil(paramMallTransactionObject.GHU)))
      {
        com.tencent.mm.kernel.h.aHH();
        localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramMallTransactionObject.GHU);
        if ((localObject1 != null) && ((int)((com.tencent.mm.contact.d)localObject1).jxt > 0))
        {
          localObject1 = ((com.tencent.mm.contact.d)localObject1).ays();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(a.i.wallet_order_info_from);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.desc))
      {
        if (i == 0) {
          break label1665;
        }
        paramf = new f(paramContext);
        if ((paramMallTransactionObject.gag != 32) && (paramMallTransactionObject.gag != 33) && (paramMallTransactionObject.gag != 31)) {
          break label1655;
        }
        paramf.setTitle(a.i.wallet_order_info_collect_remark_txt);
        label668:
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.GHY))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_original_feeinfo_title);
        paramf.setContent(paramMallTransactionObject.GHY);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.GHX))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_rate_title);
        paramf.setContent(paramMallTransactionObject.GHX);
        localArrayList.add(paramf);
      }
      if (!TextUtils.isEmpty(paramMallTransactionObject.GHP))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_charge_fee);
        paramf.setContent(paramMallTransactionObject.GHP);
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
        if ((paramMallTransactionObject.gag != 31) || (z.bcZ().equals(paramMallTransactionObject.GHN)) || (paramMallTransactionObject.GHO <= 0) || (Util.isNullOrNil(paramMallTransactionObject.GHN)) || (Util.isNullOrNil(paramMallTransactionObject.fww))) {
          break label1828;
        }
        localObject1 = paramContext.getString(a.i.remittance_resend_transfer_msg);
        localObject2 = paramMallTransactionObject.GHt + " " + (String)localObject1;
        i = paramMallTransactionObject.GHt.length();
        j = paramMallTransactionObject.GHt.length();
        paramf.a((String)localObject2, i + 1, ((String)localObject1).length() + j + 1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66794);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            com.tencent.mm.ui.base.h.c(paramContext, paramContext.getString(a.i.remittance_confirm_resend_msg), paramContext.getString(a.i.app_remind), paramContext.getString(a.i.remittance_resend), paramContext.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(66793);
                paramAnonymous2DialogInterface = new Intent();
                paramAnonymous2DialogInterface.putExtra("transaction_id", a.3.this.GHh.fww);
                paramAnonymous2DialogInterface.putExtra("receiver_name", a.3.this.GHh.GHN);
                paramAnonymous2DialogInterface.putExtra("resend_msg_from_flag", 1);
                com.tencent.mm.by.c.b(a.3.this.val$context, "remittance", ".ui.RemittanceResendMsgUI", paramAnonymous2DialogInterface);
                AppMethodBeat.o(66793);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66794);
          }
        });
        label1019:
        localArrayList.add(paramf);
      }
      paramf = new f(paramContext);
      paramf.setTitle(a.i.wallet_order_info_deal_time);
      paramf.setContent(com.tencent.mm.wallet_core.ui.g.uW(paramMallTransactionObject.createTime));
      localArrayList.add(paramf);
      if (!Util.isNullOrNil(paramMallTransactionObject.GHx))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(a.i.wallet_order_info_pay_method);
        localObject1 = paramMallTransactionObject.GHx;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!Util.isNullOrNil(paramMallTransactionObject.GHy)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.GHy + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.fww))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_trans_id);
        paramf.setContent(paramMallTransactionObject.fww);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.GHw))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_sp_billno);
        if (paramMallTransactionObject.gag != 8) {
          break label1857;
        }
        paramf.setContent(paramContext.getString(a.i.wallet_order_info_sp_billno_tip));
        localObject1 = new c(paramContext);
        localObject2 = com.tencent.mm.cf.a.a.c(paramContext, paramMallTransactionObject.GHw, 5, 0);
        ((c)localObject1).GJJ = com.tencent.mm.wallet_core.ui.g.bCt(paramMallTransactionObject.GHw);
        ((c)localObject1).lAx = ((Bitmap)localObject2);
        ((c)localObject1).mOnClickListener = new a.4(this, (Bitmap)localObject2, paramMallTransactionObject);
        localArrayList.add(paramf);
        localArrayList.add(localObject1);
      }
      label1327:
      if (paramMallTransactionObject.GHa.size() != 0) {
        break label1877;
      }
      i = 0;
      label1342:
      if ((i != 0) || ((Util.isNullOrNil(paramMallTransactionObject.GHI)) && (Util.isNullOrNil(paramMallTransactionObject.fvb)) && (Util.isNullOrNil(paramMallTransactionObject.GHd)))) {
        break label1883;
      }
      paramf = new h(paramContext);
      paramf.GJY = true;
      localArrayList.add(paramf);
      localArrayList.add(com.tencent.mm.plugin.order.model.a.a(paramContext, paramMallTransactionObject));
      label1413:
      if (i != 0)
      {
        paramf = new j(paramContext);
        if (paramMallTransactionObject.GHb != 1) {
          break label1928;
        }
        if ((!Util.isNullOrNil(paramMallTransactionObject.GHI)) || (!Util.isNullOrNil(paramMallTransactionObject.fvb)) || (!Util.isNullOrNil(paramMallTransactionObject.GHd)))
        {
          if (Util.isNullOrNil(paramMallTransactionObject.GHJ)) {
            break label1914;
          }
          paramf.GKc = paramMallTransactionObject.GHJ;
          label1483:
          paramf.GKd = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(66797);
              Object localObject = new b();
              ((b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
              paramAnonymousView = new LinkedList();
              localObject = new LinkedList();
              if (!Util.isNullOrNil(paramMallTransactionObject.fvb))
              {
                ((List)localObject).add(Integer.valueOf(0));
                paramAnonymousView.add(paramContext.getString(a.i.wallet_order_info_support_biz));
              }
              if (!Util.isNullOrNil(paramMallTransactionObject.GHd))
              {
                ((List)localObject).add(Integer.valueOf(1));
                paramAnonymousView.add(paramContext.getString(a.i.wallet_order_info_support_call));
              }
              if (!Util.isNullOrNil(paramMallTransactionObject.GHI))
              {
                ((List)localObject).add(Integer.valueOf(2));
                paramAnonymousView.add(paramContext.getString(a.i.wallet_order_info_support_safeguard));
              }
              if (((List)localObject).size() == 1)
              {
                com.tencent.mm.plugin.order.model.a.a(((Integer)((List)localObject).get(0)).intValue(), paramContext, paramMallTransactionObject);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(66797);
                return;
              }
              com.tencent.mm.ui.base.h.b(paramContext, null, paramAnonymousView, (List)localObject, null, new h.e()
              {
                public final void cS(int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(66796);
                  com.tencent.mm.plugin.order.model.a.a(paramAnonymous2Int2, a.5.this.val$context, a.5.this.GHh);
                  AppMethodBeat.o(66796);
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(66797);
            }
          };
        }
      }
    }
    for (;;)
    {
      paramf.GHa = paramMallTransactionObject.GHa;
      paramf.mOnClickListener = new a.7(this, paramContext, paramMallTransactionObject);
      paramContext = new h(paramContext);
      paramContext.GJY = true;
      localArrayList.add(paramContext);
      localArrayList.add(paramf);
      AppMethodBeat.o(66800);
      return localArrayList;
      i = 0;
      break;
      label1565:
      if (paramMallTransactionObject.gag == 11)
      {
        localObject1 = paramContext.getString(a.i.wallet_order_info_save_amount);
        break label154;
      }
      localObject1 = paramContext.getString(a.i.wallet_order_info_amount);
      break label154;
      label1598:
      ((g)localObject1).GJR = paramContext.getString(a.i.wallet_order_info_discount_summary, new Object[] { Integer.valueOf(localObject2.length), com.tencent.mm.wallet_core.ui.g.d(paramMallTransactionObject.GHE - paramMallTransactionObject.tVK, paramMallTransactionObject.GHz) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label358;
      label1655:
      paramf.setTitle(a.i.wallet_order_info_from);
      break label668;
      label1665:
      localObject1 = new f(paramContext);
      if (paramMallTransactionObject.gag == 31)
      {
        ((f)localObject1).setTitle(a.i.wallet_order_info_remittance_memo);
        label1692:
        if (Util.isNullOrNil(paramMallTransactionObject.GHp)) {
          break label1816;
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
        break label1692;
        label1816:
        ((f)localObject1).setContent(paramMallTransactionObject.desc);
      }
      label1828:
      paramf.setContent(paramMallTransactionObject.GHt);
      if (Util.isNullOrNil(paramMallTransactionObject.GHu)) {
        break label1019;
      }
      paramf.aUc(paramMallTransactionObject.GHu);
      break label1019;
      label1857:
      paramf.setContent(paramMallTransactionObject.GHw);
      localArrayList.add(paramf);
      break label1327;
      label1877:
      i = 1;
      break label1342;
      label1883:
      paramf = new h(paramContext);
      paramf.GJY = true;
      paramf.rDs = false;
      localArrayList.add(paramf);
      break label1413;
      label1914:
      paramf.GKc = paramContext.getString(a.i.wallet_order_info_support_customer_service);
      break label1483;
      label1928:
      if (!Util.isNullOrNil(paramMallTransactionObject.GHJ))
      {
        paramf.GKc = paramMallTransactionObject.GHJ;
        paramf.GKd = new a.6(this, paramContext, paramMallTransactionObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a
 * JD-Core Version:    0.7.0.1
 */