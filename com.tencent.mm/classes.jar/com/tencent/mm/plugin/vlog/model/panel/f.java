package com.tencent.mm.plugin.vlog.model.panel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.ab;
import d.a.j;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "()V", "getReportCount", "", "plugin-vlog_release"})
public final class f
  extends a
{
  public f()
  {
    super(b.ewj());
    AppMethodBeat.i(191335);
    ae.i(b.aeP(), "create: pag group");
    Iterator localIterator = ((Iterable)j.o((Collection)b.ewk())).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ab)localIterator).nextInt();
      this.gne.add(new e(String.valueOf(i), "pag/text/" + (String)b.ewk().get(i), "pag/text/" + (String)b.ewl().get(i)));
    }
    AppMethodBeat.o(191335);
  }
  
  public final int afA()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.f
 * JD-Core Version:    0.7.0.1
 */