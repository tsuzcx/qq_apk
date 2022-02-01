package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.LinkedList;

public final class j
  extends BaseAdapter
{
  m GVE;
  String GVF;
  private Context mContext;
  
  public j(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private h abi(int paramInt)
  {
    AppMethodBeat.i(67032);
    h localh = (h)this.GVE.GUe.get(paramInt);
    AppMethodBeat.o(67032);
    return localh;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67031);
    if (this.GVE.GUe != null)
    {
      int i = this.GVE.GUe.size();
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
    paramViewGroup = abi(paramInt);
    if ((paramView == null) || (paramView.getTag() == null)) {
      paramView = View.inflate(this.mContext, a.g.product_select_sku_cell, null);
    }
    for (;;)
    {
      CheckBox localCheckBox = (CheckBox)paramView;
      localCheckBox.setText(paramViewGroup.name);
      localCheckBox.setEnabled(paramViewGroup.bzb);
      localCheckBox.setChecked(paramViewGroup.id.equals(this.GVF));
      if (!paramViewGroup.bzb) {
        paramView.setBackgroundResource(a.e.product_sku_bg_disable);
      }
      for (;;)
      {
        paramView.setTag(new Pair(this.GVE.GUc, paramViewGroup.id));
        AppMethodBeat.o(67034);
        return paramView;
        if (paramViewGroup.id.equals(this.GVF)) {
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
    boolean bool = abi(paramInt).bzb;
    AppMethodBeat.o(67033);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.j
 * JD-Core Version:    0.7.0.1
 */