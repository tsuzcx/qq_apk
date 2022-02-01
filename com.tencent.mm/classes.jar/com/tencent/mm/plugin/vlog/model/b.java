package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/ABAVideoInfo;", "", "path", "", "videoStart", "", "videoEnd", "(Ljava/lang/String;JJ)V", "getPath", "()Ljava/lang/String;", "getVideoEnd", "()J", "getVideoStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-vlog_release"})
public final class b
{
  final long BEQ;
  final long BER;
  final String path;
  
  public b(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(195683);
    this.path = paramString;
    this.BEQ = paramLong1;
    this.BER = paramLong2;
    AppMethodBeat.o(195683);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(195686);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.i(this.path, paramObject.path)) || (this.BEQ != paramObject.BEQ) || (this.BER != paramObject.BER)) {}
      }
    }
    else
    {
      AppMethodBeat.o(195686);
      return true;
    }
    AppMethodBeat.o(195686);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(195685);
    String str = this.path;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.BEQ;
      int j = (int)(l ^ l >>> 32);
      l = this.BER;
      int k = (int)(l ^ l >>> 32);
      AppMethodBeat.o(195685);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(195684);
    String str = "ABAVideoInfo(path=" + this.path + ", videoStart=" + this.BEQ + ", videoEnd=" + this.BER + ")";
    AppMethodBeat.o(195684);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.b
 * JD-Core Version:    0.7.0.1
 */