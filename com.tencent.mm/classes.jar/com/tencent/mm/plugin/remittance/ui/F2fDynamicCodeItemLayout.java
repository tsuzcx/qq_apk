package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public class F2fDynamicCodeItemLayout
  extends LinearLayout
{
  TextView Olf;
  TextView xGl;
  
  public F2fDynamicCodeItemLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(67917);
    init();
    AppMethodBeat.o(67917);
  }
  
  public F2fDynamicCodeItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67918);
    init();
    AppMethodBeat.o(67918);
  }
  
  public F2fDynamicCodeItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(67919);
    init();
    AppMethodBeat.o(67919);
  }
  
  private void init()
  {
    AppMethodBeat.i(67920);
    View localView = LayoutInflater.from(getContext()).inflate(a.g.remittance_f2f_dynamic_code_item_layout, this);
    this.Olf = ((TextView)localView.findViewById(a.f.rfdi_left_tv));
    this.xGl = ((TextView)localView.findViewById(a.f.rfdi_right_tv));
    AppMethodBeat.o(67920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.F2fDynamicCodeItemLayout
 * JD-Core Version:    0.7.0.1
 */