package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.z;

public class MMDatePickerView
  extends LinearLayout
  implements View.OnClickListener
{
  private Button LnA;
  private Button LnB;
  private Button Lnz;
  private MMSpinnerDatePicker pmS;
  
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
    paramContext = z.jV(paramContext).inflate(2131494784, this);
    this.Lnz = ((Button)paramContext.findViewById(2131307139));
    this.LnA = ((Button)paramContext.findViewById(2131302451));
    this.LnB = ((Button)paramContext.findViewById(2131298936));
    this.pmS = ((MMSpinnerDatePicker)paramContext.findViewById(2131302321));
    this.Lnz.setOnClickListener(this);
    this.LnA.setOnClickListener(this);
    this.LnB.setOnClickListener(this);
    AppMethodBeat.o(143349);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(143350);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/widget/MMDatePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    int i = paramView.getId();
    if (i == 2131307139) {
      this.pmS.setPickerMode(0);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/ui/widget/MMDatePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(143350);
      return;
      if (i == 2131302451) {
        this.pmS.setPickerMode(1);
      } else {
        this.pmS.setPickerMode(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMDatePickerView
 * JD-Core Version:    0.7.0.1
 */