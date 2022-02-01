package com.tencent.mm.plugin.vlog.model.panel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ah;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "()V", "getDataCount", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  public f()
  {
    super(b.hRK());
    AppMethodBeat.i(283670);
    Log.i(b.aUw(), "create: pag group");
    Iterator localIterator = ((Iterable)p.F((Collection)b.hRL())).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ah)localIterator).Zo();
      this.mio.add(new e(String.valueOf(i), s.X("pag/text/", b.hRL().get(i)), s.X("pag/text/", b.hRM().get(i))));
    }
    AppMethodBeat.o(283670);
  }
  
  public final int getDataCount()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.panel.f
 * JD-Core Version:    0.7.0.1
 */