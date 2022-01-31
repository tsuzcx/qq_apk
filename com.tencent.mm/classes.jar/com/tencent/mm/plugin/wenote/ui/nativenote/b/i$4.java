package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.ku;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.y;

final class i$4
  implements View.OnClickListener
{
  i$4(i parami) {}
  
  public final void onClick(View paramView)
  {
    if (this.rNp.rLi.rJg == 2)
    {
      this.rNp.rLi.rIT.cjp().chS();
      this.rNp.rLi.ciF();
    }
    int i = ((RecyclerView.v)paramView.getTag()).id();
    ku localku = new ku();
    if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(i) == null)
    {
      y.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().size()) });
      return;
    }
    if (com.tencent.mm.plugin.wenote.model.c.chu().rFh == null)
    {
      y.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
      return;
    }
    y.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(i).getType()) });
    localku.bTL.bTN = ((o)com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(i)).rGI;
    localku.bTL.context = paramView.getContext();
    localku.bTL.type = 1;
    com.tencent.mm.plugin.wenote.model.c.chu().rFh.b(localku);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.i.4
 * JD-Core Version:    0.7.0.1
 */