package com.tencent.mm.plugin.radar.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ell;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/model/RadarManager$LatestChangeStat;", "", "member", "Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "state", "Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "(Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;)V", "getMember", "()Lcom/tencent/mm/protocal/protobuf/RadarSearchMember;", "getState", "()Lcom/tencent/mm/plugin/radar/model/RadarAddContact$Status;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$c
{
  public final ell Nsl;
  public final b.e Nsm;
  
  public d$c(ell paramell, b.e parame)
  {
    AppMethodBeat.i(138552);
    this.Nsl = paramell;
    this.Nsm = parame;
    AppMethodBeat.o(138552);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(138555);
    if (this == paramObject)
    {
      AppMethodBeat.o(138555);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(138555);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.Nsl, paramObject.Nsl))
    {
      AppMethodBeat.o(138555);
      return false;
    }
    if (this.Nsm != paramObject.Nsm)
    {
      AppMethodBeat.o(138555);
      return false;
    }
    AppMethodBeat.o(138555);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(138554);
    int i = this.Nsl.hashCode();
    int j = this.Nsm.hashCode();
    AppMethodBeat.o(138554);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(138553);
    String str = "LatestChangeStat(member=" + this.Nsl + ", state=" + this.Nsm + ')';
    AppMethodBeat.o(138553);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.model.d.c
 * JD-Core Version:    0.7.0.1
 */