package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$29
  implements View.OnClickListener
{
  c$29(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(85150);
    LinearLayout localLinearLayout = (LinearLayout)this.BIO.BIK.findViewById(2131823317);
    if (localLinearLayout.getVisibility() == 8)
    {
      localLinearLayout.setVisibility(0);
      ((Button)paramView).setText("隐藏高级设置");
      AppMethodBeat.o(85150);
      return;
    }
    localLinearLayout.setVisibility(8);
    ((Button)paramView).setText("高级设置");
    AppMethodBeat.o(85150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.29
 * JD-Core Version:    0.7.0.1
 */