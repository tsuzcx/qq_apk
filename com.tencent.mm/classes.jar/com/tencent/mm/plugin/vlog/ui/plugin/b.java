package com.tencent.mm.plugin.vlog.ui.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.videocomposition.d;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer;", "", "()V", "trackStates", "", "", "Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer$TrackState;", "cache", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "composition", "restore", "restoreTrackTime", "", "TrackState", "plugin-vlog_release"})
public final class b
{
  private Map<Integer, a> GGx;
  
  public b()
  {
    AppMethodBeat.i(191174);
    this.GGx = ((Map)new LinkedHashMap());
    AppMethodBeat.o(191174);
  }
  
  public final ac c(ac paramac)
  {
    AppMethodBeat.i(191172);
    p.h(paramac, "composition");
    this.GGx.clear();
    Iterator localIterator = ((Iterable)paramac.Gzn).iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      Object localObject = new a(localad.Gzy, localad.GzA.GGz, localad.GzA.GGA);
      this.GGx.put(Integer.valueOf(localad.id), localObject);
      localObject = a.GAD;
      a.a(localad, 0);
    }
    AppMethodBeat.o(191172);
    return paramac;
  }
  
  public final ac c(ac paramac, boolean paramBoolean)
  {
    AppMethodBeat.i(191173);
    p.h(paramac, "composition");
    Iterator localIterator = ((Iterable)paramac.Gzn).iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      a locala = (a)this.GGx.get(Integer.valueOf(localad.id));
      if (locala != null)
      {
        if (paramBoolean)
        {
          localad.KQ(locala.GGz);
          localad.KR(locala.GGA);
        }
        a locala1 = a.GAD;
        a.a(localad, locala.GGy);
      }
    }
    AppMethodBeat.o(191173);
    return paramac;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer$TrackState;", "", "transOrder", "", "trackStartTimeMs", "", "trackEndTimeMs", "(IJJ)V", "getTrackEndTimeMs", "()J", "getTrackStartTimeMs", "getTransOrder", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class a
  {
    final long GGA;
    final int GGy;
    final long GGz;
    
    public a(int paramInt, long paramLong1, long paramLong2)
    {
      this.GGy = paramInt;
      this.GGz = paramLong1;
      this.GGA = paramLong2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.GGy != paramObject.GGy) || (this.GGz != paramObject.GGz) || (this.GGA != paramObject.GGA)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      int i = this.GGy;
      long l = this.GGz;
      int j = (int)(l ^ l >>> 32);
      l = this.GGA;
      return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(191171);
      String str = "TrackState(transOrder=" + this.GGy + ", trackStartTimeMs=" + this.GGz + ", trackEndTimeMs=" + this.GGA + ")";
      AppMethodBeat.o(191171);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.b
 * JD-Core Version:    0.7.0.1
 */