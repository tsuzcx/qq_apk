package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "", "path", "", "durationMs", "", "(Ljava/lang/String;J)V", "getDurationMs", "()J", "setDurationMs", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public long durationMs;
  public String path;
  
  private b(String paramString)
  {
    AppMethodBeat.i(280189);
    this.path = paramString;
    this.durationMs = 0L;
    AppMethodBeat.o(280189);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(280235);
    if (this == paramObject)
    {
      AppMethodBeat.o(280235);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(280235);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(280235);
      return false;
    }
    if (this.durationMs != paramObject.durationMs)
    {
      AppMethodBeat.o(280235);
      return false;
    }
    AppMethodBeat.o(280235);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(280228);
    int i = this.path.hashCode();
    int j = q.a..ExternalSyntheticBackport0.m(this.durationMs);
    AppMethodBeat.o(280228);
    return i * 31 + j;
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(280207);
    s.u(paramString, "<set-?>");
    this.path = paramString;
    AppMethodBeat.o(280207);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(280217);
    String str = "TTSInfo(path=" + this.path + ", durationMs=" + this.durationMs + ')';
    AppMethodBeat.o(280217);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b
 * JD-Core Version:    0.7.0.1
 */