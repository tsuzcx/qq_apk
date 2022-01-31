package com.tencent.mm.plugin.sns.ui.d;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.pluginsdk.n;

final class b$18
  implements View.OnClickListener
{
  b$18(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40266);
    try
    {
      int i = v.abP((String)paramView.getTag());
      paramView = new Intent();
      paramView.putExtra("sns_label_sns_info", i);
      a.gmO.u(paramView, this.skd.activity);
      AppMethodBeat.o(40266);
      return;
    }
    catch (Exception paramView)
    {
      AppMethodBeat.o(40266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.18
 * JD-Core Version:    0.7.0.1
 */