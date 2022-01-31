package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ui.y;

public class MMDatePickerView
  extends LinearLayout
  implements View.OnClickListener
{
  private MMSpinnerDatePicker iMj;
  private Button wjh;
  private Button wji;
  private Button wjj;
  
  public MMDatePickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MMDatePickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    paramContext = y.gt(paramContext).inflate(a.h.mm_datepicker_dialog, this);
    this.wjh = ((Button)paramContext.findViewById(a.g.year_btn));
    this.wji = ((Button)paramContext.findViewById(a.g.month_btn));
    this.wjj = ((Button)paramContext.findViewById(a.g.day_btn));
    this.iMj = ((MMSpinnerDatePicker)paramContext.findViewById(a.g.mm_datepicker));
    this.wjh.setOnClickListener(this);
    this.wji.setOnClickListener(this);
    this.wjj.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == a.g.year_btn)
    {
      this.iMj.setPickerMode(0);
      return;
    }
    if (i == a.g.month_btn)
    {
      this.iMj.setPickerMode(1);
      return;
    }
    this.iMj.setPickerMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMDatePickerView
 * JD-Core Version:    0.7.0.1
 */