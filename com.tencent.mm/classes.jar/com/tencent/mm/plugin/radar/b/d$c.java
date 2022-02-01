package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dsq;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-radar_release"})
public final class d$c
{
  public final dsq Hux;
  public final b.e Huy;
  
  public d$c(dsq paramdsq, b.e parame)
  {
    AppMethodBeat.i(138552);
    this.Hux = paramdsq;
    this.Huy = parame;
    AppMethodBeat.o(138552);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(138555);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.h(this.Hux, paramObject.Hux)) || (!p.h(this.Huy, paramObject.Huy))) {}
      }
    }
    else
    {
      AppMethodBeat.o(138555);
      return true;
    }
    AppMethodBeat.o(138555);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(138554);
    Object localObject = this.Hux;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.Huy;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(138554);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(138553);
    String str = "LatestChangeStat(member=" + this.Hux + ", state=" + this.Huy + ")";
    AppMethodBeat.o(138553);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.d.c
 * JD-Core Version:    0.7.0.1
 */