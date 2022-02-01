package com.tencent.mm.plugin.vlog.ui.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.local.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer;", "", "()V", "trackStates", "", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer$TrackState;", "cache", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "composition", "restore", "restoreTrackTime", "", "TrackState", "plugin-vlog_release"})
public final class b
{
  private Map<Integer, a> Nuo;
  
  public b()
  {
    AppMethodBeat.i(242593);
    this.Nuo = ((Map)new LinkedHashMap());
    AppMethodBeat.o(242593);
  }
  
  public final ac c(ac paramac, boolean paramBoolean)
  {
    AppMethodBeat.i(242592);
    p.k(paramac, "composition");
    Iterator localIterator = ((Iterable)paramac.MQY).iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      a locala = (a)this.Nuo.get(Integer.valueOf(localad.id));
      if (locala != null)
      {
        if (paramBoolean)
        {
          localad.Sn(locala.MQV);
          localad.So(locala.MQW);
        }
        a locala1 = a.Nol;
        a.a(localad, locala.Nup);
      }
    }
    AppMethodBeat.o(242592);
    return paramac;
  }
  
  public final ac d(ac paramac)
  {
    AppMethodBeat.i(242591);
    p.k(paramac, "composition");
    this.Nuo.clear();
    Iterator localIterator = ((Iterable)paramac.MQY).iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      Object localObject = new a(localad.Nne, localad.Nng.MQV, localad.Nng.MQW);
      this.Nuo.put(Integer.valueOf(localad.id), localObject);
      localObject = a.Nol;
      a.a(localad, 0);
    }
    AppMethodBeat.o(242591);
    return paramac;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer$TrackState;", "", "transOrder", "", "trackStartTimeMs", "", "trackEndTimeMs", "(IJJ)V", "getTrackEndTimeMs", "()J", "getTrackStartTimeMs", "getTransOrder", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class a
  {
    final long MQV;
    final long MQW;
    final int Nup;
    
    public a(int paramInt, long paramLong1, long paramLong2)
    {
      this.Nup = paramInt;
      this.MQV = paramLong1;
      this.MQW = paramLong2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.Nup != paramObject.Nup) || (this.MQV != paramObject.MQV) || (this.MQW != paramObject.MQW)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      int i = this.Nup;
      long l = this.MQV;
      int j = (int)(l ^ l >>> 32);
      l = this.MQW;
      return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(223829);
      String str = "TrackState(transOrder=" + this.Nup + ", trackStartTimeMs=" + this.MQV + ", trackEndTimeMs=" + this.MQW + ")";
      AppMethodBeat.o(223829);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.b
 * JD-Core Version:    0.7.0.1
 */