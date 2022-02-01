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
import com.tencent.mm.ui.aa;

public class MMDatePickerView
  extends LinearLayout
  implements View.OnClickListener
{
  private Button QCF;
  private Button QCG;
  private Button QCH;
  private MMSpinnerDatePicker qCk;
  
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
    paramContext = aa.jQ(paramContext).inflate(2131495518, this);
    this.QCF = ((Button)paramContext.findViewById(2131310680));
    this.QCG = ((Button)paramContext.findViewById(2131304854));
    this.QCH = ((Button)paramContext.findViewById(2131299422));
    this.qCk = ((MMSpinnerDatePicker)paramContext.findViewById(2131304716));
    this.QCF.setOnClickListener(this);
    this.QCG.setOnClickListener(this);
    this.QCH.setOnClickListener(this);
    AppMethodBeat.o(143349);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(143350);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/widget/MMDatePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    int i = paramView.getId();
    if (i == 2131310680) {
      this.qCk.setPickerMode(0);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/ui/widget/MMDatePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(143350);
      return;
      if (i == 2131304854) {
        this.qCk.setPickerMode(1);
      } else {
        this.qCk.setPickerMode(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMDatePickerView
 * JD-Core Version:    0.7.0.1
 */