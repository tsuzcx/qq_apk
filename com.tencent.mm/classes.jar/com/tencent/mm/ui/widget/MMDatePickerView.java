package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.y;

public class MMDatePickerView
  extends LinearLayout
  implements View.OnClickListener
{
  private Button Hzs;
  private Button Hzt;
  private Button Hzu;
  private MMSpinnerDatePicker nZw;
  
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
    paramContext = y.js(paramContext).inflate(2131494784, this);
    this.Hzs = ((Button)paramContext.findViewById(2131307139));
    this.Hzt = ((Button)paramContext.findViewById(2131302451));
    this.Hzu = ((Button)paramContext.findViewById(2131298936));
    this.nZw = ((MMSpinnerDatePicker)paramContext.findViewById(2131302321));
    this.Hzs.setOnClickListener(this);
    this.Hzt.setOnClickListener(this);
    this.Hzu.setOnClickListener(this);
    AppMethodBeat.o(143349);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(143350);
    int i = paramView.getId();
    if (i == 2131307139)
    {
      this.nZw.setPickerMode(0);
      AppMethodBeat.o(143350);
      return;
    }
    if (i == 2131302451)
    {
      this.nZw.setPickerMode(1);
      AppMethodBeat.o(143350);
      return;
    }
    this.nZw.setPickerMode(2);
    AppMethodBeat.o(143350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMDatePickerView
 * JD-Core Version:    0.7.0.1
 */