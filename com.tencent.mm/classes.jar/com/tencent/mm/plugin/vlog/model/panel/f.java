package com.tencent.mm.plugin.vlog.model.panel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.ab;
import d.a.j;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "()V", "getReportCount", "", "plugin-vlog_release"})
public final class f
  extends a
{
  public f()
  {
    super(b.esC());
    AppMethodBeat.i(195876);
    ad.i(b.aeD(), "create: pag group");
    Iterator localIterator = ((Iterable)j.o((Collection)b.esD())).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ab)localIterator).nextInt();
      this.gkJ.add(new e(String.valueOf(i), "pag/text/" + (String)b.esD().get(i), "pag/text/" + (String)b.esE().get(i)));
    }
    AppMethodBeat.o(195876);
  }
  
  public final int afm()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.f
 * JD-Core Version:    0.7.0.1
 */