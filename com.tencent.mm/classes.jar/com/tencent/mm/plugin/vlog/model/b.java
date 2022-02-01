package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/ABAVideoInfo;", "", "path", "", "videoStart", "", "videoEnd", "(Ljava/lang/String;JJ)V", "getPath", "()Ljava/lang/String;", "getVideoEnd", "()J", "getVideoStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-vlog_release"})
public final class b
{
  final long BWo;
  final long BWp;
  final String path;
  
  public b(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191140);
    this.path = paramString;
    this.BWo = paramLong1;
    this.BWp = paramLong2;
    AppMethodBeat.o(191140);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191143);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.i(this.path, paramObject.path)) || (this.BWo != paramObject.BWo) || (this.BWp != paramObject.BWp)) {}
      }
    }
    else
    {
      AppMethodBeat.o(191143);
      return true;
    }
    AppMethodBeat.o(191143);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191142);
    String str = this.path;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.BWo;
      int j = (int)(l ^ l >>> 32);
      l = this.BWp;
      int k = (int)(l ^ l >>> 32);
      AppMethodBeat.o(191142);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191141);
    String str = "ABAVideoInfo(path=" + this.path + ", videoStart=" + this.BWo + ", videoEnd=" + this.BWp + ")";
    AppMethodBeat.o(191141);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.b
 * JD-Core Version:    0.7.0.1
 */