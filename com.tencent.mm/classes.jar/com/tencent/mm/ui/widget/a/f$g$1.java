package com.tencent.mm.ui.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class f$g$1
  implements u.e
{
  f$g$1(f.g paramg, f.g.a parama) {}
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(251837);
    Object localObject = this.agfq.EoD.getTag();
    if (((localObject instanceof t)) && (paramt.equals((t)localObject)))
    {
      this.agfq.EoD.setVisibility(0);
      this.agfq.EoD.setImageDrawable(paramt.getIcon());
    }
    AppMethodBeat.o(251837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.f.g.1
 * JD-Core Version:    0.7.0.1
 */