package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;

final class BankCardSelectSortView$1
  implements c.a
{
  BankCardSelectSortView$1(BankCardSelectSortView paramBankCardSelectSortView) {}
  
  public final View a(d paramd, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Context localContext = this.qHB.getContext();
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(localContext).inflate(a.g.bank_remit_sort_item, null);
      paramView = new BankCardSelectSortView.b((byte)0);
      paramView.nxK = ((TextView)localView.findViewById(a.f.catalogTV));
      paramView.nvx = ((TextView)localView.findViewById(a.f.brsb_item_title));
      paramView.nvv = ((CdnImageView)localView.findViewById(a.f.brsb_item_icon));
      localView.setTag(paramView);
    }
    paramView = (BankCardSelectSortView.b)localView.getTag();
    if ((this.qHB.vee) && (paramBoolean1))
    {
      paramView.nxK.setText(paramd.vem);
      paramView.nxK.setVisibility(0);
    }
    for (;;)
    {
      paramd = (BankCardSelectSortView.a)paramd.data;
      paramView.nvx.setText(paramd.mOX);
      if (bk.bl(paramd.bVO)) {
        break;
      }
      paramView.nvv.setUseSdcardCache(true);
      paramView.nvv.fT(paramd.bVO, paramd.qHC);
      return localView;
      paramView.nxK.setVisibility(8);
    }
    paramView.nvv.setImageBitmap(null);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.1
 * JD-Core Version:    0.7.0.1
 */