package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.fx;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

final class BankRemitSortView$1
  implements c.a
{
  BankRemitSortView$1(BankRemitSortView paramBankRemitSortView) {}
  
  public final View a(d paramd, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.nxJ.getContext();
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from((Context)localObject).inflate(a.g.bank_remit_sort_item, null);
      paramView = new BankRemitSortView.a(this.nxJ, (byte)0);
      paramView.nxK = ((TextView)localView.findViewById(a.f.catalogTV));
      paramView.nvx = ((TextView)localView.findViewById(a.f.brsb_item_title));
      paramView.nvv = ((CdnImageView)localView.findViewById(a.f.brsb_item_icon));
      localView.setTag(paramView);
    }
    paramView = (BankRemitSortView.a)localView.getTag();
    localObject = (fx)paramd.data;
    if (localObject != null)
    {
      if ((this.nxJ.vee) && (paramBoolean1)) {
        if (paramd.vem.equals("☆"))
        {
          paramView.nxK.setText(a.i.bank_remit_select_bank_freq_bank_title);
          paramView.nxK.setVisibility(0);
        }
      }
      for (;;)
      {
        paramView.nvv.setUseSdcardCache(true);
        paramView.nvv.fT(((fx)localObject).nve, b.KR(((fx)localObject).nve));
        paramView.nvx.setText(((fx)localObject).lnT);
        return localView;
        paramView.nxK.setText(paramd.vem);
        break;
        paramView.nxK.setVisibility(8);
      }
    }
    y.w("MicroMsg.BankcardSortView", "elem is null: %s", new Object[] { Integer.valueOf(paramInt) });
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSortView.1
 * JD-Core Version:    0.7.0.1
 */