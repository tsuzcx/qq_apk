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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "()V", "getDataCount", "", "plugin-vlog_release"})
public final class f
  extends a
{
  public f()
  {
    super(b.guc());
    AppMethodBeat.i(246448);
    Log.i(b.aBy(), "create: pag group");
    Iterator localIterator = ((Iterable)j.p((Collection)b.gud())).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ab)localIterator).zD();
      this.jIW.add(new e(String.valueOf(i), "pag/text/" + (String)b.gud().get(i), "pag/text/" + (String)b.gue().get(i)));
    }
    AppMethodBeat.o(246448);
  }
  
  public final int getDataCount()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.f
 * JD-Core Version:    0.7.0.1
 */