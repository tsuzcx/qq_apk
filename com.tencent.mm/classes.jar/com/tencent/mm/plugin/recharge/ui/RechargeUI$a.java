package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import java.util.List;

final class RechargeUI$a
  extends BaseAdapter
{
  private List<MallRechargeProduct> pUW = null;
  
  private RechargeUI$a(RechargeUI paramRechargeUI) {}
  
  public final void Ci(int paramInt)
  {
    AppMethodBeat.i(44326);
    int i = 0;
    while (i < this.pUW.size())
    {
      ((MallRechargeProduct)this.pUW.get(i)).isDefault = false;
      i += 1;
    }
    ((MallRechargeProduct)this.pUW.get(paramInt)).isDefault = true;
    AppMethodBeat.o(44326);
  }
  
  public final MallRechargeProduct Cj(int paramInt)
  {
    AppMethodBeat.i(44328);
    MallRechargeProduct localMallRechargeProduct = (MallRechargeProduct)this.pUW.get(paramInt);
    AppMethodBeat.o(44328);
    return localMallRechargeProduct;
  }
  
  public final void cK(List<MallRechargeProduct> paramList)
  {
    AppMethodBeat.i(44325);
    this.pUW = paramList;
    notifyDataSetChanged();
    AppMethodBeat.o(44325);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44327);
    if (this.pUW == null)
    {
      AppMethodBeat.o(44327);
      return 0;
    }
    int i = this.pUW.size();
    AppMethodBeat.o(44327);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44330);
    paramView = (CheckedTextView)View.inflate(this.pWS, 2130970533, null);
    paramViewGroup = Cj(paramInt);
    paramView.setText(paramViewGroup.loz);
    paramView.setEnabled(paramViewGroup.isValid());
    if (paramViewGroup.isDefault) {
      paramView.setChecked(true);
    }
    for (;;)
    {
      AppMethodBeat.o(44330);
      return paramView;
      paramView.setChecked(false);
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(44329);
    if (!Cj(paramInt).isValid())
    {
      AppMethodBeat.o(44329);
      return false;
    }
    boolean bool = super.isEnabled(paramInt);
    AppMethodBeat.o(44329);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.a
 * JD-Core Version:    0.7.0.1
 */