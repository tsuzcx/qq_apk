package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/EditRenderScript;", "", "path", "", "startMs", "", "endMS", "playRate", "", "(Ljava/lang/String;JJF)V", "getEndMS", "()J", "setEndMS", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getPlayRate", "()F", "setPlayRate", "(F)V", "getStartMs", "setStartMs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-recordvideo_release"})
public final class a
{
  public long Idl;
  public long gcH;
  public String path;
  public float pvh;
  
  public a(String paramString, long paramLong1, long paramLong2, float paramFloat)
  {
    AppMethodBeat.i(218691);
    this.path = paramString;
    this.gcH = paramLong1;
    this.Idl = paramLong2;
    this.pvh = paramFloat;
    AppMethodBeat.o(218691);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(218699);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.h(this.path, paramObject.path)) || (this.gcH != paramObject.gcH) || (this.Idl != paramObject.Idl) || (Float.compare(this.pvh, paramObject.pvh) != 0)) {}
      }
    }
    else
    {
      AppMethodBeat.o(218699);
      return true;
    }
    AppMethodBeat.o(218699);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(218695);
    String str = this.path;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.gcH;
      int j = (int)(l ^ l >>> 32);
      l = this.Idl;
      int k = (int)(l ^ l >>> 32);
      int m = Float.floatToIntBits(this.pvh);
      AppMethodBeat.o(218695);
      return ((i * 31 + j) * 31 + k) * 31 + m;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(218693);
    String str = "EditRenderScript(path=" + this.path + ", startMs=" + this.gcH + ", endMS=" + this.Idl + ", playRate=" + this.pvh + ")";
    AppMethodBeat.o(218693);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a
 * JD-Core Version:    0.7.0.1
 */