package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class br$8
  implements View.OnClickListener
{
  br$8(br parambr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(179318);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    boolean bool = paramView.getTag() instanceof s;
    Log.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click ".concat(String.valueOf(bool)));
    if (!bool)
    {
      a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(179318);
      return;
    }
    paramView = (s)paramView.getTag();
    br.a(this.ERz, paramView);
    a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(179318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.br.8
 * JD-Core Version:    0.7.0.1
 */