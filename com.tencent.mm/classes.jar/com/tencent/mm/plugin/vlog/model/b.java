package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/ABAVideoInfo;", "", "path", "", "videoStart", "", "videoEnd", "(Ljava/lang/String;JJ)V", "getPath", "()Ljava/lang/String;", "getVideoEnd", "()J", "getVideoStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-vlog_release"})
public final class b
{
  final long NkA;
  final long Nkz;
  final String path;
  
  public b(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(225109);
    this.path = paramString;
    this.Nkz = paramLong1;
    this.NkA = paramLong2;
    AppMethodBeat.o(225109);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(225121);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.h(this.path, paramObject.path)) || (this.Nkz != paramObject.Nkz) || (this.NkA != paramObject.NkA)) {}
      }
    }
    else
    {
      AppMethodBeat.o(225121);
      return true;
    }
    AppMethodBeat.o(225121);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(225117);
    String str = this.path;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.Nkz;
      int j = (int)(l ^ l >>> 32);
      l = this.NkA;
      int k = (int)(l ^ l >>> 32);
      AppMethodBeat.o(225117);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225112);
    String str = "ABAVideoInfo(path=" + this.path + ", videoStart=" + this.Nkz + ", videoEnd=" + this.NkA + ")";
    AppMethodBeat.o(225112);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.b
 * JD-Core Version:    0.7.0.1
 */