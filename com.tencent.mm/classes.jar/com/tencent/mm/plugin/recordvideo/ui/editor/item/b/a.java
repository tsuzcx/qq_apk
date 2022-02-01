package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/EditRenderScript;", "", "path", "", "startMs", "", "endMS", "playRate", "", "(Ljava/lang/String;JJF)V", "getEndMS", "()J", "setEndMS", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getPlayRate", "()F", "setPlayRate", "(F)V", "getStartMs", "setStartMs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-recordvideo_release"})
public final class a
{
  public long dQn;
  public float lqb;
  public String path;
  public long yfv;
  
  public a(String paramString, long paramLong1, long paramLong2, float paramFloat)
  {
    AppMethodBeat.i(207030);
    this.path = paramString;
    this.dQn = paramLong1;
    this.yfv = paramLong2;
    this.lqb = paramFloat;
    AppMethodBeat.o(207030);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207033);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.path, paramObject.path)) || (this.dQn != paramObject.dQn) || (this.yfv != paramObject.yfv) || (Float.compare(this.lqb, paramObject.lqb) != 0)) {}
      }
    }
    else
    {
      AppMethodBeat.o(207033);
      return true;
    }
    AppMethodBeat.o(207033);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(207032);
    String str = this.path;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.dQn;
      int j = (int)(l ^ l >>> 32);
      l = this.yfv;
      int k = (int)(l ^ l >>> 32);
      int m = Float.floatToIntBits(this.lqb);
      AppMethodBeat.o(207032);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207031);
    String str = "EditRenderScript(path=" + this.path + ", startMs=" + this.dQn + ", endMS=" + this.yfv + ", playRate=" + this.lqb + ")";
    AppMethodBeat.o(207031);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a
 * JD-Core Version:    0.7.0.1
 */