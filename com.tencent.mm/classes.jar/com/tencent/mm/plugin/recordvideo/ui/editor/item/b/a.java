package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/EditRenderScript;", "", "path", "", "startMs", "", "endMS", "playRate", "", "(Ljava/lang/String;JJF)V", "getEndMS", "()J", "setEndMS", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getPlayRate", "()F", "setPlayRate", "(F)V", "getStartMs", "setStartMs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-recordvideo_release"})
public final class a
{
  public long dOX;
  public float llC;
  public String path;
  public long xPC;
  
  public a(String paramString, long paramLong1, long paramLong2, float paramFloat)
  {
    AppMethodBeat.i(200772);
    this.path = paramString;
    this.dOX = paramLong1;
    this.xPC = paramLong2;
    this.llC = paramFloat;
    AppMethodBeat.o(200772);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(200775);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.path, paramObject.path)) || (this.dOX != paramObject.dOX) || (this.xPC != paramObject.xPC) || (Float.compare(this.llC, paramObject.llC) != 0)) {}
      }
    }
    else
    {
      AppMethodBeat.o(200775);
      return true;
    }
    AppMethodBeat.o(200775);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(200774);
    String str = this.path;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.dOX;
      int j = (int)(l ^ l >>> 32);
      l = this.xPC;
      int k = (int)(l ^ l >>> 32);
      int m = Float.floatToIntBits(this.llC);
      AppMethodBeat.o(200774);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200773);
    String str = "EditRenderScript(path=" + this.path + ", startMs=" + this.dOX + ", endMS=" + this.xPC + ", playRate=" + this.llC + ")";
    AppMethodBeat.o(200773);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a
 * JD-Core Version:    0.7.0.1
 */