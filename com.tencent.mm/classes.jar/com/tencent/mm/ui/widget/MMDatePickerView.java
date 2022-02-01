package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.af;

public class MMDatePickerView
  extends LinearLayout
  implements View.OnClickListener
{
  private Button afTa;
  private Button afTb;
  private Button afTc;
  private MMSpinnerDatePicker xeC;
  
  public MMDatePickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143347);
    init(paramContext);
    AppMethodBeat.o(143347);
  }
  
  public MMDatePickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143348);
    init(paramContext);
    AppMethodBeat.o(143348);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(143349);
    paramContext = af.mU(paramContext).inflate(a.h.mm_datepicker_dialog, this);
    this.afTa = ((Button)paramContext.findViewById(a.g.year_btn));
    this.afTb = ((Button)paramContext.findViewById(a.g.month_btn));
    this.afTc = ((Button)paramContext.findViewById(a.g.day_btn));
    this.xeC = ((MMSpinnerDatePicker)paramContext.findViewById(a.g.mm_datepicker));
    this.afTa.setOnClickListener(this);
    this.afTb.setOnClickListener(this);
    this.afTc.setOnClickListener(this);
    AppMethodBeat.o(143349);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(143350);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/widget/MMDatePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i = paramView.getId();
    if (i == a.g.year_btn) {
      this.xeC.setPickerMode(0);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/ui/widget/MMDatePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(143350);
      return;
      if (i == a.g.month_btn) {
        this.xeC.setPickerMode(1);
      } else {
        this.xeC.setPickerMode(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMDatePickerView
 * JD-Core Version:    0.7.0.1
 */