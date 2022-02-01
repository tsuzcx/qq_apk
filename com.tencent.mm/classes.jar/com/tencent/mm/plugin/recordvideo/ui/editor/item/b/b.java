package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "", "path", "", "durationMs", "", "(Ljava/lang/String;J)V", "getDurationMs", "()J", "setDurationMs", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-recordvideo_release"})
public final class b
{
  public long durationMs;
  public String path;
  
  private b(String paramString)
  {
    AppMethodBeat.i(222848);
    this.path = paramString;
    this.durationMs = 0L;
    AppMethodBeat.o(222848);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(222858);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.h(this.path, paramObject.path)) || (this.durationMs != paramObject.durationMs)) {}
      }
    }
    else
    {
      AppMethodBeat.o(222858);
      return true;
    }
    AppMethodBeat.o(222858);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(222856);
    String str = this.path;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.durationMs;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(222856);
      return i * 31 + j;
    }
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(222844);
    p.k(paramString, "<set-?>");
    this.path = paramString;
    AppMethodBeat.o(222844);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(222852);
    String str = "TTSInfo(path=" + this.path + ", durationMs=" + this.durationMs + ")";
    AppMethodBeat.o(222852);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b
 * JD-Core Version:    0.7.0.1
 */