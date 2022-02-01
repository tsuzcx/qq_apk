package com.tencent.mm.plugin.story.ui.sns;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$d
  implements View.OnClickListener
{
  b$d(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(119943);
    paramView = this.ysK.ysH;
    if (paramView != null)
    {
      paramView.invoke();
      AppMethodBeat.o(119943);
      return;
    }
    AppMethodBeat.o(119943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.b.d
 * JD-Core Version:    0.7.0.1
 */