package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.h;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.LinkedList;

public final class j
  extends BaseAdapter
{
  m MTg;
  String MTh;
  private Context mContext;
  
  public j(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private h afB(int paramInt)
  {
    AppMethodBeat.i(67032);
    h localh = (h)this.MTg.MRH.get(paramInt);
    AppMethodBeat.o(67032);
    return localh;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67031);
    if (this.MTg.MRH != null)
    {
      int i = this.MTg.MRH.size();
      AppMethodBeat.o(67031);
      return i;
    }
    AppMethodBeat.o(67031);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(67034);
    paramViewGroup = afB(paramInt);
    if ((paramView == null) || (paramView.getTag() == null)) {
      paramView = View.inflate(this.mContext, a.g.product_select_sku_cell, null);
    }
    for (;;)
    {
      CheckBox localCheckBox = (CheckBox)paramView;
      localCheckBox.setText(paramViewGroup.name);
      localCheckBox.setEnabled(paramViewGroup.dsb);
      localCheckBox.setChecked(paramViewGroup.id.equals(this.MTh));
      if (!paramViewGroup.dsb) {
        paramView.setBackgroundResource(a.e.product_sku_bg_disable);
      }
      for (;;)
      {
        paramView.setTag(new Pair(this.MTg.MRF, paramViewGroup.id));
        AppMethodBeat.o(67034);
        return paramView;
        if (paramViewGroup.id.equals(this.MTh)) {
          paramView.setBackgroundResource(a.e.product_sku_bg_selected);
        } else {
          paramView.setBackgroundResource(a.e.product_sku_bg_normal);
        }
      }
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(67033);
    boolean bool = afB(paramInt).dsb;
    AppMethodBeat.o(67033);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.j
 * JD-Core Version:    0.7.0.1
 */