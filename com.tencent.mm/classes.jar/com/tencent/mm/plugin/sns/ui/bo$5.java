package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class bo$5
  implements View.OnClickListener
{
  bo$5(bo parambo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99728);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    boolean bool = paramView.getTag() instanceof s;
    ae.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click ".concat(String.valueOf(bool)));
    if (!bool)
    {
      a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(99728);
      return;
    }
    paramView = (s)paramView.getTag();
    bo.a(this.AHD, paramView);
    a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bo.5
 * JD-Core Version:    0.7.0.1
 */