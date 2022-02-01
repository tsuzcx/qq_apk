package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cli;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-radar_release"})
public final class e$c
{
  public final cli wbu;
  public final c.e wbv;
  
  public e$c(cli paramcli, c.e parame)
  {
    AppMethodBeat.i(138552);
    this.wbu = paramcli;
    this.wbv = parame;
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
        if ((!k.g(this.wbu, paramObject.wbu)) || (!k.g(this.wbv, paramObject.wbv))) {}
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
    Object localObject = this.wbu;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.wbv;
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
    String str = "LatestChangeStat(member=" + this.wbu + ", state=" + this.wbv + ")";
    AppMethodBeat.o(138553);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.c
 * JD-Core Version:    0.7.0.1
 */