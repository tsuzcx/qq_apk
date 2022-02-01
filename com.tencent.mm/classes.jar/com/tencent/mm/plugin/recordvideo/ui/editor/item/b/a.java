package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/EditRenderScript;", "", "path", "", "startMs", "", "endMS", "playRate", "", "(Ljava/lang/String;JJF)V", "getEndMS", "()J", "setEndMS", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getPlayRate", "()F", "setPlayRate", "(F)V", "getStartMs", "setStartMs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public long NZH;
  public String path;
  public float sAn;
  public long startMs;
  
  public a(String paramString, long paramLong1, long paramLong2, float paramFloat)
  {
    AppMethodBeat.i(280206);
    this.path = paramString;
    this.startMs = paramLong1;
    this.NZH = paramLong2;
    this.sAn = paramFloat;
    AppMethodBeat.o(280206);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(280252);
    if (this == paramObject)
    {
      AppMethodBeat.o(280252);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(280252);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(280252);
      return false;
    }
    if (this.startMs != paramObject.startMs)
    {
      AppMethodBeat.o(280252);
      return false;
    }
    if (this.NZH != paramObject.NZH)
    {
      AppMethodBeat.o(280252);
      return false;
    }
    if (!s.p(Float.valueOf(this.sAn), Float.valueOf(paramObject.sAn)))
    {
      AppMethodBeat.o(280252);
      return false;
    }
    AppMethodBeat.o(280252);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(280241);
    int i = this.path.hashCode();
    int j = q.a..ExternalSyntheticBackport0.m(this.startMs);
    int k = q.a..ExternalSyntheticBackport0.m(this.NZH);
    int m = Float.floatToIntBits(this.sAn);
    AppMethodBeat.o(280241);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(280225);
    String str = "EditRenderScript(path=" + this.path + ", startMs=" + this.startMs + ", endMS=" + this.NZH + ", playRate=" + this.sAn + ')';
    AppMethodBeat.o(280225);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a
 * JD-Core Version:    0.7.0.1
 */