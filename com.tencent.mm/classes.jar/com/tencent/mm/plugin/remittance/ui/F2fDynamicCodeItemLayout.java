package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public class F2fDynamicCodeItemLayout
  extends LinearLayout
{
  TextView iUE;
  TextView nzG;
  
  public F2fDynamicCodeItemLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public F2fDynamicCodeItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public F2fDynamicCodeItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    View localView = LayoutInflater.from(getContext()).inflate(a.g.remittance_f2f_dynamic_code_item_layout, this);
    this.nzG = ((TextView)localView.findViewById(a.f.rfdi_left_tv));
    this.iUE = ((TextView)localView.findViewById(a.f.rfdi_right_tv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.F2fDynamicCodeItemLayout
 * JD-Core Version:    0.7.0.1
 */