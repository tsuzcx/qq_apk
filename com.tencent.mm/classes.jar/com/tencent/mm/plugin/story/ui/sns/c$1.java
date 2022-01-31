package com.tencent.mm.plugin.story.ui.sns;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class c$1
  implements View.OnClickListener
{
  c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110266);
    paramView = this.sKO;
    if (!c.a(this.sKO)) {}
    for (boolean bool = true;; bool = false)
    {
      c.a(paramView, bool);
      if (!c.a(this.sKO)) {
        break;
      }
      c.b(this.sKO);
      AppMethodBeat.o(110266);
      return;
    }
    c.c(this.sKO);
    AppMethodBeat.o(110266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.c.1
 * JD-Core Version:    0.7.0.1
 */