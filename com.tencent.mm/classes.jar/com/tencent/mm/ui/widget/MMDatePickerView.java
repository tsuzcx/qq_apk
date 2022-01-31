package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.w;

public class MMDatePickerView
  extends LinearLayout
  implements View.OnClickListener
{
  private Button ACO;
  private Button ACP;
  private Button ACQ;
  private MMSpinnerDatePicker kSU;
  
  public MMDatePickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107870);
    init(paramContext);
    AppMethodBeat.o(107870);
  }
  
  public MMDatePickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107871);
    init(paramContext);
    AppMethodBeat.o(107871);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(107872);
    paramContext = w.hM(paramContext).inflate(2130970161, this);
    this.ACO = ((Button)paramContext.findViewById(2131822888));
    this.ACP = ((Button)paramContext.findViewById(2131822889));
    this.ACQ = ((Button)paramContext.findViewById(2131822890));
    this.kSU = ((MMSpinnerDatePicker)paramContext.findViewById(2131826172));
    this.ACO.setOnClickListener(this);
    this.ACP.setOnClickListener(this);
    this.ACQ.setOnClickListener(this);
    AppMethodBeat.o(107872);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(107873);
    int i = paramView.getId();
    if (i == 2131822888)
    {
      this.kSU.setPickerMode(0);
      AppMethodBeat.o(107873);
      return;
    }
    if (i == 2131822889)
    {
      this.kSU.setPickerMode(1);
      AppMethodBeat.o(107873);
      return;
    }
    this.kSU.setPickerMode(2);
    AppMethodBeat.o(107873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMDatePickerView
 * JD-Core Version:    0.7.0.1
 */