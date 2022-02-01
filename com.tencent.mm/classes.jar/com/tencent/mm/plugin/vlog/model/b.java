package com.tencent.mm.plugin.vlog.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/ABAVideoInfo;", "", "path", "", "videoStart", "", "videoEnd", "(Ljava/lang/String;JJ)V", "getPath", "()Ljava/lang/String;", "getVideoEnd", "()J", "getVideoStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  final long TXU;
  final long TXV;
  final String path;
  
  public b(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(283464);
    this.path = paramString;
    this.TXU = paramLong1;
    this.TXV = paramLong2;
    AppMethodBeat.o(283464);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(283489);
    if (this == paramObject)
    {
      AppMethodBeat.o(283489);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(283489);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(283489);
      return false;
    }
    if (this.TXU != paramObject.TXU)
    {
      AppMethodBeat.o(283489);
      return false;
    }
    if (this.TXV != paramObject.TXV)
    {
      AppMethodBeat.o(283489);
      return false;
    }
    AppMethodBeat.o(283489);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(283479);
    int i = this.path.hashCode();
    int j = q.a..ExternalSyntheticBackport0.m(this.TXU);
    int k = q.a..ExternalSyntheticBackport0.m(this.TXV);
    AppMethodBeat.o(283479);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(283471);
    String str = "ABAVideoInfo(path=" + this.path + ", videoStart=" + this.TXU + ", videoEnd=" + this.TXV + ')';
    AppMethodBeat.o(283471);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.b
 * JD-Core Version:    0.7.0.1
 */