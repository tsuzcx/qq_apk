package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/ABAVideoInfo;", "", "path", "", "videoStart", "", "videoEnd", "(Ljava/lang/String;JJ)V", "getPath", "()Ljava/lang/String;", "getVideoEnd", "()J", "getVideoStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-vlog_release"})
public final class b
{
  final long GwX;
  final long GwY;
  final String path;
  
  public b(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(190476);
    this.path = paramString;
    this.GwX = paramLong1;
    this.GwY = paramLong2;
    AppMethodBeat.o(190476);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(190479);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.j(this.path, paramObject.path)) || (this.GwX != paramObject.GwX) || (this.GwY != paramObject.GwY)) {}
      }
    }
    else
    {
      AppMethodBeat.o(190479);
      return true;
    }
    AppMethodBeat.o(190479);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(190478);
    String str = this.path;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.GwX;
      int j = (int)(l ^ l >>> 32);
      l = this.GwY;
      int k = (int)(l ^ l >>> 32);
      AppMethodBeat.o(190478);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190477);
    String str = "ABAVideoInfo(path=" + this.path + ", videoStart=" + this.GwX + ", videoEnd=" + this.GwY + ")";
    AppMethodBeat.o(190477);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.b
 * JD-Core Version:    0.7.0.1
 */