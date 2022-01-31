package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$10
  implements View.OnClickListener
{
  c$10(c paramc, LinearLayout paramLinearLayout) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(85131);
    if (this.BIS.getVisibility() == 8)
    {
      this.BIS.setVisibility(0);
      ((Button)paramView).setText("隐藏插件设置");
      AppMethodBeat.o(85131);
      return;
    }
    this.BIS.setVisibility(8);
    ((Button)paramView).setText("插件设置");
    AppMethodBeat.o(85131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.10
 * JD-Core Version:    0.7.0.1
 */