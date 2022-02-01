package com.tencent.mm.plugin.sns.ui.d;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.pluginsdk.m;

final class c$19
  implements View.OnClickListener
{
  c$19(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(220115);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    try
    {
      int i = x.aBN((String)paramView.getTag());
      paramView = new Intent();
      paramView.putExtra("sns_label_sns_info", i);
      com.tencent.mm.plugin.sns.c.a.iUz.u(paramView, this.AQE.activity);
      label77:
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(220115);
      return;
    }
    catch (Exception paramView)
    {
      break label77;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c.19
 * JD-Core Version:    0.7.0.1
 */