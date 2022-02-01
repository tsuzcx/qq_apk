package com.tencent.mm.plugin.sns.ui.d;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.pluginsdk.l;

final class b$18
  implements View.OnClickListener
{
  b$18(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(100226);
    try
    {
      int i = x.avp((String)paramView.getTag());
      paramView = new Intent();
      paramView.putExtra("sns_label_sns_info", i);
      a.iyx.u(paramView, this.zhf.activity);
      AppMethodBeat.o(100226);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(100226);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.18
 * JD-Core Version:    0.7.0.1
 */