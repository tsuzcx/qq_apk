package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.li;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.ab;

final class i$4
  implements View.OnClickListener
{
  i$4(i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27168);
    if (this.vDT.vBM.vzL == 2)
    {
      this.vDT.vBM.vzz.djQ().dii();
      this.vDT.vBM.diW();
    }
    int i = ((RecyclerView.v)paramView.getTag()).jN();
    li localli = new li();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(i) == null)
    {
      ab.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().size()) });
      AppMethodBeat.o(27168);
      return;
    }
    if (com.tencent.mm.plugin.wenote.model.c.dhH().vvQ == null)
    {
      ab.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
      AppMethodBeat.o(27168);
      return;
    }
    ab.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(i).getType()) });
    localli.cBr.cBt = ((o)com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(i)).vxr;
    localli.cBr.context = paramView.getContext();
    localli.cBr.type = 1;
    com.tencent.mm.plugin.wenote.model.c.dhH().vvQ.b(localli);
    AppMethodBeat.o(27168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.i.4
 * JD-Core Version:    0.7.0.1
 */