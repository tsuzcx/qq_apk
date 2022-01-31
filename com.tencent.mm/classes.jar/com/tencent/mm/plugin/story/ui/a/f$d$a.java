package com.tencent.mm.plugin.story.ui.a;

import a.f.a.m;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class f$d$a
  implements View.OnClickListener
{
  f$d$a(f.d paramd, com.tencent.mm.plugin.story.model.b.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138855);
    if ((com.tencent.mm.plugin.story.c.a.a.srz.czE()) && ((f.a(this.sIF.sIC)) || (f.b(this.sIF.sIC))))
    {
      paramView = j.svi;
      if (!bo.isEqual(j.b.coK(), this.sIE.czp))
      {
        paramView = this.sIF.sIC.sIw;
        if (paramView != null)
        {
          paramView.h(this.sIE, Boolean.TRUE);
          AppMethodBeat.o(138855);
          return;
        }
      }
    }
    AppMethodBeat.o(138855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.f.d.a
 * JD-Core Version:    0.7.0.1
 */