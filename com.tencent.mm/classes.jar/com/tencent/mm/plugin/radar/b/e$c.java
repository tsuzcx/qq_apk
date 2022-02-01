package com.tencent.mm.plugin.radar.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.crc;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-radar_release"})
public final class e$c
{
  public final crc xza;
  public final c.e xzb;
  
  public e$c(crc paramcrc, c.e parame)
  {
    AppMethodBeat.i(138552);
    this.xza = paramcrc;
    this.xzb = parame;
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
        if ((!p.i(this.xza, paramObject.xza)) || (!p.i(this.xzb, paramObject.xzb))) {}
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
    Object localObject = this.xza;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.xzb;
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
    String str = "LatestChangeStat(member=" + this.xza + ", state=" + this.xzb + ")";
    AppMethodBeat.o(138553);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.c
 * JD-Core Version:    0.7.0.1
 */