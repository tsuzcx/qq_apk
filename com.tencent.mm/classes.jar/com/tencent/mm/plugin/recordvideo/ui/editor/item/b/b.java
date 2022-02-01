package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "", "path", "", "durationMs", "", "(Ljava/lang/String;J)V", "getDurationMs", "()J", "setDurationMs", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-recordvideo_release"})
public final class b
{
  public long bup;
  public String path;
  
  private b(String paramString)
  {
    AppMethodBeat.i(207035);
    this.path = paramString;
    this.bup = 0L;
    AppMethodBeat.o(207035);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(207039);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.i(this.path, paramObject.path)) || (this.bup != paramObject.bup)) {}
      }
    }
    else
    {
      AppMethodBeat.o(207039);
      return true;
    }
    AppMethodBeat.o(207039);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(207038);
    String str = this.path;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.bup;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(207038);
      return i * 31 + j;
    }
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(207034);
    p.h(paramString, "<set-?>");
    this.path = paramString;
    AppMethodBeat.o(207034);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207037);
    String str = "TTSInfo(path=" + this.path + ", durationMs=" + this.bup + ")";
    AppMethodBeat.o(207037);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b
 * JD-Core Version:    0.7.0.1
 */