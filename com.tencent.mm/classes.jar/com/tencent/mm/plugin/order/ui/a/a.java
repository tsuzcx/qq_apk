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
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.e;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements a.a
{
  public com.tencent.mm.wallet_core.ui.c MGq;
  
  public final List<Preference> a(final Context paramContext, final com.tencent.mm.ui.base.preference.f paramf, final MallTransactionObject paramMallTransactionObject)
  {
    AppMethodBeat.i(66800);
    ArrayList localArrayList = new ArrayList();
    int i;
    Object localObject1;
    Object localObject2;
    label154:
    label358:
    int j;
    if (paramMallTransactionObject.hva == 2)
    {
      i = 1;
      if ((!Util.isNullOrNil(paramMallTransactionObject.MEr)) && (!Util.isNullOrNil(paramMallTransactionObject.phA)))
      {
        localObject1 = new d(paramContext);
        ((d)localObject1).xOn = paramMallTransactionObject.phA;
        ((d)localObject1).mName = paramMallTransactionObject.MEr;
        ((d)localObject1).mOnClickListener = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66791);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (!Util.isNullOrNil(paramMallTransactionObject.hzv)) {
              com.tencent.mm.wallet_core.ui.i.an(paramContext, paramMallTransactionObject.hzv);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66791);
          }
        };
        localArrayList.add(localObject1);
        localArrayList.add(new PreferenceSmallCategory(paramContext));
      }
      localObject2 = new i(paramContext);
      ((i)localObject2).MGQ = com.tencent.mm.wallet_core.ui.i.e(paramMallTransactionObject.wZe, paramMallTransactionObject.MEq);
      if (i == 0) {
        break label1565;
      }
      localObject1 = paramContext.getString(a.i.wallet_order_info_amount_income);
      ((i)localObject2).setTitle((CharSequence)localObject1);
      if (!Util.isNullOrNil(paramMallTransactionObject.MEi)) {
        ((i)localObject2).aRj(paramMallTransactionObject.MEi);
      }
      localArrayList.add(localObject2);
      boolean bool = false;
      if (paramMallTransactionObject.wZe != paramMallTransactionObject.MEu)
      {
        localObject1 = new h(paramContext);
        ((h)localObject1).MGN = false;
        ((h)localObject1).MGO = true;
        localArrayList.add(localObject1);
        localObject1 = new f(paramContext);
        ((f)localObject1).setContent(com.tencent.mm.wallet_core.ui.i.e(paramMallTransactionObject.MEu, paramMallTransactionObject.MEq));
        ((f)localObject1).setTitle(a.i.wallet_order_info_orginal_amount);
        localArrayList.add(localObject1);
        bool = true;
      }
      if ((paramMallTransactionObject.wZe != paramMallTransactionObject.MEu) && (!Util.isNullOrNil(paramMallTransactionObject.DUX)))
      {
        localObject1 = new g(paramContext);
        ((g)localObject1).setTitle(a.i.wallet_order_info_discount);
        ((g)localObject1).pkD = paramf;
        localObject2 = paramMallTransactionObject.DUX.split("\n");
        if (localObject2.length != 1) {
          break label1598;
        }
        ((g)localObject1).MGG = localObject2[0];
        localArrayList.add(localObject1);
      }
      localObject1 = new h(paramContext);
      ((h)localObject1).MGN = bool;
      ((h)localObject1).MGO = true;
      localArrayList.add(localObject1);
      if ((i == 0) && (!Util.isNullOrNil(paramMallTransactionObject.MED)))
      {
        com.tencent.mm.kernel.h.baF();
        localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramMallTransactionObject.MED);
        if ((localObject1 != null) && ((int)((com.tencent.mm.contact.d)localObject1).maN > 0))
        {
          localObject1 = ((com.tencent.mm.contact.d)localObject1).aSV();
          localObject2 = new f(paramContext);
          ((f)localObject2).setTitle(a.i.wallet_order_info_spid);
          ((f)localObject2).setContent((String)localObject1);
          localArrayList.add(localObject2);
        }
      }
      if ((paramMallTransactionObject.igp == 31) && (i != 0) && (!Util.isNullOrNil(paramMallTransactionObject.MEK)))
      {
        com.tencent.mm.kernel.h.baF();
        localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramMallTransactionObject.MEK);
        if ((localObject1 != null) && ((int)((com.tencent.mm.contact.d)localObject1).maN > 0))
        {
          localObject1 = ((com.tencent.mm.contact.d)localObject1).aSV();
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
        if ((paramMallTransactionObject.igp != 32) && (paramMallTransactionObject.igp != 33) && (paramMallTransactionObject.igp != 31)) {
          break label1655;
        }
        paramf.setTitle(a.i.wallet_order_info_collect_remark_txt);
        label668:
        paramf.setContent(paramMallTransactionObject.desc);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.MEO))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_original_feeinfo_title);
        paramf.setContent(paramMallTransactionObject.MEO);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.MEN))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_rate_title);
        paramf.setContent(paramMallTransactionObject.MEN);
        localArrayList.add(paramf);
      }
      if (!TextUtils.isEmpty(paramMallTransactionObject.MEF))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_charge_fee);
        paramf.setContent(paramMallTransactionObject.MEF);
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
        if ((paramMallTransactionObject.igp != 31) || (z.bAM().equals(paramMallTransactionObject.MED)) || (paramMallTransactionObject.MEE <= 0) || (Util.isNullOrNil(paramMallTransactionObject.MED)) || (Util.isNullOrNil(paramMallTransactionObject.hAU))) {
          break label1828;
        }
        localObject1 = paramContext.getString(a.i.remittance_resend_transfer_msg);
        localObject2 = paramMallTransactionObject.MEk + " " + (String)localObject1;
        i = paramMallTransactionObject.MEk.length();
        j = paramMallTransactionObject.MEk.length();
        paramf.a((String)localObject2, i + 1, ((String)localObject1).length() + j + 1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66794);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            k.b(paramContext, paramContext.getString(a.i.remittance_confirm_resend_msg), paramContext.getString(a.i.app_remind), paramContext.getString(a.i.remittance_resend), paramContext.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(66793);
                paramAnonymous2DialogInterface = new Intent();
                paramAnonymous2DialogInterface.putExtra("transaction_id", a.3.this.MDY.hAU);
                paramAnonymous2DialogInterface.putExtra("receiver_name", a.3.this.MDY.MED);
                paramAnonymous2DialogInterface.putExtra("resend_msg_from_flag", 1);
                com.tencent.mm.br.c.b(a.3.this.val$context, "remittance", ".ui.RemittanceResendMsgUI", paramAnonymous2DialogInterface);
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
      paramf.setContent(com.tencent.mm.wallet_core.ui.i.vh(paramMallTransactionObject.createTime));
      localArrayList.add(paramf);
      if (!Util.isNullOrNil(paramMallTransactionObject.MEo))
      {
        localObject2 = new f(paramContext);
        ((f)localObject2).setTitle(a.i.wallet_order_info_pay_method);
        localObject1 = paramMallTransactionObject.MEo;
        paramf = (com.tencent.mm.ui.base.preference.f)localObject1;
        if (!Util.isNullOrNil(paramMallTransactionObject.MEp)) {
          paramf = (String)localObject1 + "(" + paramMallTransactionObject.MEp + ")";
        }
        ((f)localObject2).setContent(paramf);
        localArrayList.add(localObject2);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.hAU))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_trans_id);
        paramf.setContent(paramMallTransactionObject.hAU);
        localArrayList.add(paramf);
      }
      if (!Util.isNullOrNil(paramMallTransactionObject.MEn))
      {
        paramf = new f(paramContext);
        paramf.setTitle(a.i.wallet_order_info_sp_billno);
        if (paramMallTransactionObject.igp != 8) {
          break label1857;
        }
        paramf.setContent(paramContext.getString(a.i.wallet_order_info_sp_billno_tip));
        localObject1 = new c(paramContext);
        localObject2 = com.tencent.mm.bz.a.a.d(paramContext, paramMallTransactionObject.MEn, 5, 0);
        ((c)localObject1).MGy = com.tencent.mm.wallet_core.ui.i.bER(paramMallTransactionObject.MEn);
        ((c)localObject1).orY = ((Bitmap)localObject2);
        ((c)localObject1).mOnClickListener = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66795);
            Object localObject = new b();
            ((b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
            if (a.this.MGq != null)
            {
              localObject = a.this;
              Bitmap localBitmap = this.val$bmp;
              String str = paramMallTransactionObject.MEn;
              if (((a)localObject).MGq != null)
              {
                ((a)localObject).MGq.qv(str, str);
                ((a)localObject).MGq.MAx = localBitmap;
                ((a)localObject).MGq.MAy = localBitmap;
                ((a)localObject).MGq.jPm();
              }
              a.this.MGq.ak(paramAnonymousView, true);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66795);
          }
        };
        localArrayList.add(paramf);
        localArrayList.add(localObject1);
      }
      label1327:
      if (paramMallTransactionObject.MDR.size() != 0) {
        break label1877;
      }
      i = 0;
      label1342:
      if ((i != 0) || ((Util.isNullOrNil(paramMallTransactionObject.MEy)) && (Util.isNullOrNil(paramMallTransactionObject.hzv)) && (Util.isNullOrNil(paramMallTransactionObject.MDU)))) {
        break label1883;
      }
      paramf = new h(paramContext);
      paramf.MGN = true;
      localArrayList.add(paramf);
      localArrayList.add(com.tencent.mm.plugin.order.model.a.a(paramContext, paramMallTransactionObject));
      label1413:
      if (i != 0)
      {
        paramf = new j(paramContext);
        if (paramMallTransactionObject.MDS != 1) {
          break label1928;
        }
        if ((!Util.isNullOrNil(paramMallTransactionObject.MEy)) || (!Util.isNullOrNil(paramMallTransactionObject.hzv)) || (!Util.isNullOrNil(paramMallTransactionObject.MDU)))
        {
          if (Util.isNullOrNil(paramMallTransactionObject.MEz)) {
            break label1914;
          }
          paramf.MGR = paramMallTransactionObject.MEz;
          label1483:
          paramf.MGS = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(66797);
              Object localObject = new b();
              ((b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
              paramAnonymousView = new LinkedList();
              localObject = new LinkedList();
              if (!Util.isNullOrNil(paramMallTransactionObject.hzv))
              {
                ((List)localObject).add(Integer.valueOf(0));
                paramAnonymousView.add(paramContext.getString(a.i.wallet_order_info_support_biz));
              }
              if (!Util.isNullOrNil(paramMallTransactionObject.MDU))
              {
                ((List)localObject).add(Integer.valueOf(1));
                paramAnonymousView.add(paramContext.getString(a.i.wallet_order_info_support_call));
              }
              if (!Util.isNullOrNil(paramMallTransactionObject.MEy))
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
              k.b(paramContext, null, paramAnonymousView, (List)localObject, null, new k.e()
              {
                public final void onClick(int paramAnonymous2Int1, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(66796);
                  com.tencent.mm.plugin.order.model.a.a(paramAnonymous2Int2, a.5.this.val$context, a.5.this.MDY);
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
      paramf.MDR = paramMallTransactionObject.MDR;
      paramf.mOnClickListener = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66799);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (paramAnonymousView.getTag() == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66799);
            return;
          }
          if ((paramAnonymousView.getTag() instanceof MallOrderDetailObject.HelpCenter))
          {
            paramAnonymousView = (MallOrderDetailObject.HelpCenter)paramAnonymousView.getTag();
            a.a(paramContext, paramAnonymousView.url, paramMallTransactionObject);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66799);
        }
      };
      paramContext = new h(paramContext);
      paramContext.MGN = true;
      localArrayList.add(paramContext);
      localArrayList.add(paramf);
      AppMethodBeat.o(66800);
      return localArrayList;
      i = 0;
      break;
      label1565:
      if (paramMallTransactionObject.igp == 11)
      {
        localObject1 = paramContext.getString(a.i.wallet_order_info_save_amount);
        break label154;
      }
      localObject1 = paramContext.getString(a.i.wallet_order_info_amount);
      break label154;
      label1598:
      ((g)localObject1).MGG = paramContext.getString(a.i.wallet_order_info_discount_summary, new Object[] { Integer.valueOf(localObject2.length), com.tencent.mm.wallet_core.ui.i.e(paramMallTransactionObject.MEu - paramMallTransactionObject.wZe, paramMallTransactionObject.MEq) });
      ((g)localObject1).a((String[])localObject2, TextUtils.TruncateAt.MIDDLE);
      break label358;
      label1655:
      paramf.setTitle(a.i.wallet_order_info_from);
      break label668;
      label1665:
      localObject1 = new f(paramContext);
      if (paramMallTransactionObject.igp == 31)
      {
        ((f)localObject1).setTitle(a.i.wallet_order_info_remittance_memo);
        label1692:
        if (Util.isNullOrNil(paramMallTransactionObject.MEg)) {
          break label1816;
        }
        localObject2 = paramContext.getString(a.i.wallet_order_info_check_detail);
        String str = paramMallTransactionObject.desc + " " + (String)localObject2;
        i = paramMallTransactionObject.desc.length();
        j = paramMallTransactionObject.desc.length();
        ((f)localObject1).a(str, i + 1, ((String)localObject2).length() + (j + 1), new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66792);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = paramMallTransactionObject.desc + "\n" + paramMallTransactionObject.MEg;
            this.MGt.setContent(paramAnonymousView);
            paramf.notifyDataSetChanged();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66792);
          }
        });
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
      paramf.setContent(paramMallTransactionObject.MEk);
      if (Util.isNullOrNil(paramMallTransactionObject.MEl)) {
        break label1019;
      }
      paramf.aRi(paramMallTransactionObject.MEl);
      break label1019;
      label1857:
      paramf.setContent(paramMallTransactionObject.MEn);
      localArrayList.add(paramf);
      break label1327;
      label1877:
      i = 1;
      break label1342;
      label1883:
      paramf = new h(paramContext);
      paramf.MGN = true;
      paramf.uOJ = false;
      localArrayList.add(paramf);
      break label1413;
      label1914:
      paramf.MGR = paramContext.getString(a.i.wallet_order_info_support_customer_service);
      break label1483;
      label1928:
      if (!Util.isNullOrNil(paramMallTransactionObject.MEz))
      {
        paramf.MGR = paramMallTransactionObject.MEz;
        paramf.MGS = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66798);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            a.a(paramContext, paramMallTransactionObject.MEy, paramMallTransactionObject);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/order/ui/preference/DefaultOrderPrefFactory$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(66798);
          }
        };
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a
 * JD-Core Version:    0.7.0.1
 */