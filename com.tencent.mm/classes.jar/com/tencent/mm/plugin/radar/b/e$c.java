package com.tencent.mm.plugin.radar.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.brg;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-radar_release"})
public final class e$c
{
  public final brg pQI;
  public final c.e pQJ;
  
  public e$c(brg parambrg, c.e parame)
  {
    AppMethodBeat.i(102907);
    this.pQI = parambrg;
    this.pQJ = parame;
    AppMethodBeat.o(102907);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(102910);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!j.e(this.pQI, paramObject.pQI)) || (!j.e(this.pQJ, paramObject.pQJ))) {}
      }
    }
    else
    {
      AppMethodBeat.o(102910);
      return true;
    }
    AppMethodBeat.o(102910);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(102909);
    Object localObject = this.pQI;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.pQJ;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(102909);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(102908);
    String str = "LatestChangeStat(member=" + this.pQI + ", state=" + this.pQJ + ")";
    AppMethodBeat.o(102908);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.c
 * JD-Core Version:    0.7.0.1
 */