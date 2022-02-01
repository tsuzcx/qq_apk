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
import com.tencent.mm.ui.ad;

public class MMDatePickerView
  extends LinearLayout
  implements View.OnClickListener
{
  private Button Ybi;
  private Button Ybj;
  private Button Ybk;
  private MMSpinnerDatePicker ubk;
  
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
    paramContext = ad.kS(paramContext).inflate(a.h.mm_datepicker_dialog, this);
    this.Ybi = ((Button)paramContext.findViewById(a.g.year_btn));
    this.Ybj = ((Button)paramContext.findViewById(a.g.month_btn));
    this.Ybk = ((Button)paramContext.findViewById(a.g.day_btn));
    this.ubk = ((MMSpinnerDatePicker)paramContext.findViewById(a.g.mm_datepicker));
    this.Ybi.setOnClickListener(this);
    this.Ybj.setOnClickListener(this);
    this.Ybk.setOnClickListener(this);
    AppMethodBeat.o(143349);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(143350);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/widget/MMDatePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i = paramView.getId();
    if (i == a.g.year_btn) {
      this.ubk.setPickerMode(0);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/ui/widget/MMDatePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(143350);
      return;
      if (i == a.g.month_btn) {
        this.ubk.setPickerMode(1);
      } else {
        this.ubk.setPickerMode(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMDatePickerView
 * JD-Core Version:    0.7.0.1
 */