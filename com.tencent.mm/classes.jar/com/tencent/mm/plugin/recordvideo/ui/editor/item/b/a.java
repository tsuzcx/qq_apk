package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/EditRenderScript;", "", "path", "", "startMs", "", "endMS", "playRate", "", "(Ljava/lang/String;JJF)V", "getEndMS", "()J", "setEndMS", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getPlayRate", "()F", "setPlayRate", "(F)V", "getStartMs", "setStartMs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-recordvideo_release"})
public final class a
{
  public long Cgu;
  public long eiq;
  public float mwH;
  public String path;
  
  public a(String paramString, long paramLong1, long paramLong2, float paramFloat)
  {
    AppMethodBeat.i(237871);
    this.path = paramString;
    this.eiq = paramLong1;
    this.Cgu = paramLong2;
    this.mwH = paramFloat;
    AppMethodBeat.o(237871);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237874);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.j(this.path, paramObject.path)) || (this.eiq != paramObject.eiq) || (this.Cgu != paramObject.Cgu) || (Float.compare(this.mwH, paramObject.mwH) != 0)) {}
      }
    }
    else
    {
      AppMethodBeat.o(237874);
      return true;
    }
    AppMethodBeat.o(237874);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(237873);
    String str = this.path;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.eiq;
      int j = (int)(l ^ l >>> 32);
      l = this.Cgu;
      int k = (int)(l ^ l >>> 32);
      int m = Float.floatToIntBits(this.mwH);
      AppMethodBeat.o(237873);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237872);
    String str = "EditRenderScript(path=" + this.path + ", startMs=" + this.eiq + ", endMS=" + this.Cgu + ", playRate=" + this.mwH + ")";
    AppMethodBeat.o(237872);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a
 * JD-Core Version:    0.7.0.1
 */