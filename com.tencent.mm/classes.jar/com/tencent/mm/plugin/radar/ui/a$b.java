package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$b
  implements View.OnClickListener
{
  a$b(a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(102940);
    RadarSpecialGridView.a locala = this.pQZ.pQX.getOnItemClickListener();
    if (locala != null)
    {
      int i = this.euX;
      j.p(paramView, "v");
      locala.f(i, paramView);
      AppMethodBeat.o(102940);
      return;
    }
    AppMethodBeat.o(102940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.a.b
 * JD-Core Version:    0.7.0.1
 */