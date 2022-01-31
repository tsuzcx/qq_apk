package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.List;

final class BankRemitSelectPayeeUI$b
  extends BaseAdapter
{
  private BankRemitSelectPayeeUI$b(BankRemitSelectPayeeUI paramBankRemitSelectPayeeUI) {}
  
  private boolean bwe()
  {
    return BankRemitSelectPayeeUI.d(this.nxC) >= 0;
  }
  
  private boolean bwf()
  {
    return BankRemitSelectPayeeUI.e(this.nxC) >= 0;
  }
  
  public final int getCount()
  {
    int j = BankRemitSelectPayeeUI.c(this.nxC).size();
    int i = j;
    if (bwe()) {
      i = j + 1;
    }
    j = i;
    if (bwf()) {
      j = i + 1;
    }
    return j;
  }
  
  public final Object getItem(int paramInt)
  {
    if ((paramInt == BankRemitSelectPayeeUI.d(this.nxC)) || (paramInt == BankRemitSelectPayeeUI.e(this.nxC))) {
      return null;
    }
    if (paramInt < BankRemitSelectPayeeUI.e(this.nxC)) {
      return BankRemitSelectPayeeUI.c(this.nxC).get(paramInt - 1);
    }
    if ((bwf()) && (paramInt > BankRemitSelectPayeeUI.e(this.nxC)))
    {
      if (bwe()) {
        return BankRemitSelectPayeeUI.c(this.nxC).get(paramInt - 2);
      }
      return BankRemitSelectPayeeUI.c(this.nxC).get(paramInt - 1);
    }
    if (bwe()) {
      return BankRemitSelectPayeeUI.c(this.nxC).get(paramInt - 1);
    }
    y.i("MicroMsg.BankRemitSelectPayeeUI", "maybe wrong pos: [%s,%s,%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(BankRemitSelectPayeeUI.d(this.nxC)), Integer.valueOf(BankRemitSelectPayeeUI.e(this.nxC)) });
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if ((paramInt == BankRemitSelectPayeeUI.d(this.nxC)) || (paramInt == BankRemitSelectPayeeUI.e(this.nxC))) {
      return 0;
    }
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    View localView = paramView;
    if (paramView == null)
    {
      if (i != 0) {
        break label90;
      }
      localView = LayoutInflater.from(this.nxC.mController.uMN).inflate(a.g.bank_remit_select_payee_header_item, paramViewGroup, false);
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        y.w("MicroMsg.BankRemitSelectPayeeUI", "unknown type: %d", new Object[] { Integer.valueOf(i) });
        return localView;
        label90:
        localView = LayoutInflater.from(this.nxC.mController.uMN).inflate(a.g.bank_remit_select_payee_item, paramViewGroup, false);
        paramView = new BankRemitSelectPayeeUI.a(this.nxC, (byte)0);
        paramView.nxH = ((CdnImageView)localView.findViewById(a.f.brsp_item_bank_icon_iv));
        paramView.nvw = ((TextView)localView.findViewById(a.f.brsp_item_payee_name_tv));
        paramView.nxI = ((TextView)localView.findViewById(a.f.brsp_item_bank_info_tv));
        localView.setTag(paramView);
      }
    }
    paramView = (TextView)localView.findViewById(a.f.brsp_header_tv);
    if (BankRemitSelectPayeeUI.d(this.nxC) == paramInt) {}
    for (i = 1; i != 0; i = 0)
    {
      paramView.setText(a.i.bank_remit_select_payee_self_title);
      return localView;
    }
    if (BankRemitSelectPayeeUI.e(this.nxC) == paramInt) {}
    for (i = 1; i != 0; i = 0)
    {
      paramView.setText(a.i.bank_remit_select_payee_other_title);
      return localView;
    }
    paramView.setText("");
    y.w("MicroMsg.BankRemitSelectPayeeUI", "wrong header pos: %s", new Object[] { Integer.valueOf(paramInt) });
    return localView;
    paramView = (BankRemitSelectPayeeUI.a)localView.getTag();
    paramViewGroup = (TransferRecordParcel)getItem(paramInt);
    if (paramViewGroup != null)
    {
      paramView.nxH.dl(paramViewGroup.nve, a.c.transparent);
      if (!bk.bl(paramViewGroup.nvB))
      {
        SpannableString localSpannableString = j.b(paramView.nxC.mController.uMN, paramView.nxC.mController.uMN.getString(a.i.bank_remit_select_payee_name_with_remark, new Object[] { paramViewGroup.nvA, paramViewGroup.nvB }));
        paramView.nvw.setText(localSpannableString);
      }
      for (;;)
      {
        paramView.nxI.setText(paramView.nxC.getString(a.i.bank_remit_select_payee_name_with_remark, new Object[] { paramViewGroup.lnT, paramViewGroup.nvz }));
        return localView;
        paramView.nvw.setText(paramViewGroup.nvA);
      }
    }
    paramView.nxH.setImageResource(a.c.transparent);
    paramView.nvw.setText("");
    paramView.nxI.setText("");
    y.w("MicroMsg.BankRemitSelectPayeeUI", "empty record");
    return localView;
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return (paramInt != BankRemitSelectPayeeUI.d(this.nxC)) && (paramInt != BankRemitSelectPayeeUI.e(this.nxC));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitSelectPayeeUI.b
 * JD-Core Version:    0.7.0.1
 */