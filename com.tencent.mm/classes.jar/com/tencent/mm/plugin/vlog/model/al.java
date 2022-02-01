package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VideoSource;", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "width", "", "height", "path", "", "duration", "", "(IILjava/lang/String;J)V", "getDuration", "()J", "setDuration", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  extends z
{
  long duration;
  String path;
  
  public al(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    super(paramInt1, paramInt2, 0, (byte)0);
    AppMethodBeat.i(283635);
    this.path = paramString;
    this.duration = paramLong;
    AppMethodBeat.o(283635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.al
 * JD-Core Version:    0.7.0.1
 */