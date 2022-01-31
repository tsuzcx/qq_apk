package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

final class RechargeUI$a
  extends BaseAdapter
{
  private List<MallRechargeProduct> npI = null;
  
  private RechargeUI$a(RechargeUI paramRechargeUI) {}
  
  public final void ch(List<MallRechargeProduct> paramList)
  {
    this.npI = paramList;
    notifyDataSetChanged();
  }
  
  public final int getCount()
  {
    if (this.npI == null) {
      return 0;
    }
    return this.npI.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (CheckedTextView)View.inflate(this.nrE, a.g.recharge_list_dialog_item_singlechoice, null);
    paramViewGroup = wx(paramInt);
    paramView.setText(paramViewGroup.jfG);
    paramView.setEnabled(paramViewGroup.isValid());
    if (paramViewGroup.isDefault)
    {
      paramView.setChecked(true);
      return paramView;
    }
    paramView.setChecked(false);
    return paramView;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    if (!wx(paramInt).isValid()) {
      return false;
    }
    return super.isEnabled(paramInt);
  }
  
  public final void ww(int paramInt)
  {
    int i = 0;
    while (i < this.npI.size())
    {
      ((MallRechargeProduct)this.npI.get(i)).isDefault = false;
      i += 1;
    }
    ((MallRechargeProduct)this.npI.get(paramInt)).isDefault = true;
  }
  
  public final MallRechargeProduct wx(int paramInt)
  {
    return (MallRechargeProduct)this.npI.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.RechargeUI.a
 * JD-Core Version:    0.7.0.1
 */