package com.tencent.mm.plugin.vlog.ui.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.local.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer;", "", "()V", "trackStates", "", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer$TrackState;", "cache", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "composition", "restore", "restoreTrackTime", "", "TrackState", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private Map<Integer, b.a> UhF;
  
  public b()
  {
    AppMethodBeat.i(282363);
    this.UhF = ((Map)new LinkedHashMap());
    AppMethodBeat.o(282363);
  }
  
  public final ac c(ac paramac, boolean paramBoolean)
  {
    AppMethodBeat.i(282383);
    s.u(paramac, "composition");
    Iterator localIterator = ((Iterable)paramac.TDz).iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      b.a locala = (b.a)this.UhF.get(Integer.valueOf(localad.id));
      if (locala != null)
      {
        if (paramBoolean)
        {
          localad.wB(locala.TDw);
          localad.wC(locala.TDx);
        }
        a locala1 = a.UbD;
        a.a(localad, locala.UhG);
      }
    }
    AppMethodBeat.o(282383);
    return paramac;
  }
  
  public final ac d(ac paramac)
  {
    AppMethodBeat.i(282373);
    s.u(paramac, "composition");
    this.UhF.clear();
    Iterator localIterator = ((Iterable)paramac.TDz).iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      Object localObject = new b.a(localad.UaG, localad.UaI.TDw, localad.UaI.TDx);
      this.UhF.put(Integer.valueOf(localad.id), localObject);
      localObject = a.UbD;
      a.a(localad, 0);
    }
    AppMethodBeat.o(282373);
    return paramac;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.b
 * JD-Core Version:    0.7.0.1
 */