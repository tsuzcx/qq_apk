package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$31
  implements View.OnClickListener
{
  c$31(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154184);
    LinearLayout localLinearLayout = (LinearLayout)this.IST.ISL.findViewById(2131298553);
    if (localLinearLayout.getVisibility() == 8)
    {
      localLinearLayout.setVisibility(0);
      ((Button)paramView).setText("隐藏高级设置");
      AppMethodBeat.o(154184);
      return;
    }
    localLinearLayout.setVisibility(8);
    ((Button)paramView).setText("高级设置");
    AppMethodBeat.o(154184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.31
 * JD-Core Version:    0.7.0.1
 */