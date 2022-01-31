package com.tencent.mm.plugin.story.ui.sns;

import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$c
  implements View.OnClickListener
{
  b$c(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110238);
    if (this.sKn.isShowing()) {
      this.sKn.cancel();
    }
    AppMethodBeat.o(110238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.b.c
 * JD-Core Version:    0.7.0.1
 */