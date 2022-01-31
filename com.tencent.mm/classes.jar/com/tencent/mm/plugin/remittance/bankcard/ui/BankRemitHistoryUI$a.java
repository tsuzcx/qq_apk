package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.apc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

final class BankRemitHistoryUI$a
  extends BaseAdapter
{
  private SimpleDateFormat nwJ = new SimpleDateFormat(this.nwG.mController.uMN.getString(a.i.bank_remit_history_date_format_pattern));
  
  private BankRemitHistoryUI$a(BankRemitHistoryUI paramBankRemitHistoryUI) {}
  
  private String ce(long paramLong)
  {
    return this.nwJ.format(new Date(1000L * paramLong));
  }
  
  public final int getCount()
  {
    return BankRemitHistoryUI.i(this.nwG).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return BankRemitHistoryUI.i(this.nwG).get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.nwG.mController.uMN).inflate(a.g.bank_remit_history_item, paramViewGroup, false);
      localView.setTag(new BankRemitHistoryUI.b(this.nwG, localView));
    }
    paramView = (BankRemitHistoryUI.b)localView.getTag();
    paramViewGroup = (apc)getItem(paramInt);
    String str = ce(paramViewGroup.tkY);
    if (paramInt == 0) {
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        paramView.nwK.setText(str);
        paramView.nwK.setVisibility(0);
      }
      for (;;)
      {
        paramView.nwN.setUrl(paramViewGroup.nve);
        paramView.gaI.setText(paramViewGroup.title);
        paramView.nwL.setText(paramViewGroup.tkZ);
        paramView.eXs.setText(paramViewGroup.tkX);
        if (bk.bl(paramViewGroup.tla)) {
          break label245;
        }
        if (!bk.bl(paramViewGroup.tlb)) {
          paramView.nwM.setTextColor(Color.parseColor(paramViewGroup.tlb));
        }
        paramView.nwM.setText(paramViewGroup.tla);
        paramView.nwM.setVisibility(0);
        return localView;
        if (str.equals(ce(((apc)getItem(paramInt - 1)).tkY))) {
          break label257;
        }
        paramInt = 1;
        break;
        paramView.nwK.setVisibility(8);
      }
      label245:
      paramView.nwM.setVisibility(8);
      return localView;
      label257:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI.a
 * JD-Core Version:    0.7.0.1
 */