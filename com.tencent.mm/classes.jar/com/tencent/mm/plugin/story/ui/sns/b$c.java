package com.tencent.mm.plugin.story.ui.sns;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$c
  implements View.OnClickListener
{
  b$c(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119942);
    if (this.ysK.isShowing()) {
      this.ysK.cancel();
    }
    AppMethodBeat.o(119942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.b.c
 * JD-Core Version:    0.7.0.1
 */