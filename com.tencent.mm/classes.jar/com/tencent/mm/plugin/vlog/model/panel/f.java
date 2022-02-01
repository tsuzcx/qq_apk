package com.tencent.mm.plugin.vlog.model.panel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "()V", "getReportCount", "", "plugin-vlog_release"})
public final class f
  extends a
{
  public f()
  {
    super(b.fCe());
    AppMethodBeat.i(190795);
    Log.i(b.auD(), "create: pag group");
    Iterator localIterator = ((Iterable)j.r((Collection)b.fCf())).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ab)localIterator).nextInt();
      this.gXW.add(new e(String.valueOf(i), "pag/text/" + (String)b.fCf().get(i), "pag/text/" + (String)b.fCg().get(i)));
    }
    AppMethodBeat.o(190795);
  }
  
  public final int avo()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.f
 * JD-Core Version:    0.7.0.1
 */