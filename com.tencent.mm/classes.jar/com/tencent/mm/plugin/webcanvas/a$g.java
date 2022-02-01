package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext$SyncBarrierInfo;", "", "token", "", "start", "", "(IJ)V", "getStart", "()J", "getToken", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "webview-sdk_release"})
final class a$g
{
  final long start;
  final int token;
  
  public a$g(int paramInt, long paramLong)
  {
    this.token = paramInt;
    this.start = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((this.token != paramObject.token) || (this.start != paramObject.start)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = this.token;
    long l = this.start;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(224578);
    String str = "SyncBarrierInfo(token=" + this.token + ", start=" + this.start + ")";
    AppMethodBeat.o(224578);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.a.g
 * JD-Core Version:    0.7.0.1
 */