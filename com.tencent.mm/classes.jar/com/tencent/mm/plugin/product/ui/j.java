package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.LinkedList;

public final class j
  extends BaseAdapter
{
  private Context mContext;
  m mUD;
  String mUE;
  
  public j(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private h vQ(int paramInt)
  {
    return (h)this.mUD.mTb.get(paramInt);
  }
  
  public final int getCount()
  {
    if (this.mUD.mTb != null) {
      return this.mUD.mTb.size();
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = vQ(paramInt);
    if ((paramView == null) || (paramView.getTag() == null)) {
      paramView = View.inflate(this.mContext, a.g.product_select_sku_cell, null);
    }
    for (;;)
    {
      CheckBox localCheckBox = (CheckBox)paramView;
      localCheckBox.setText(paramViewGroup.name);
      localCheckBox.setEnabled(paramViewGroup.mSU);
      localCheckBox.setChecked(paramViewGroup.id.equals(this.mUE));
      if (!paramViewGroup.mSU) {
        paramView.setBackgroundResource(a.e.product_sku_bg_disable);
      }
      for (;;)
      {
        paramView.setTag(new Pair(this.mUD.mSZ, paramViewGroup.id));
        return paramView;
        if (paramViewGroup.id.equals(this.mUE)) {
          paramView.setBackgroundResource(a.e.product_sku_bg_selected);
        } else {
          paramView.setBackgroundResource(a.e.product_sku_bg_normal);
        }
      }
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return vQ(paramInt).mSU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.j
 * JD-Core Version:    0.7.0.1
 */