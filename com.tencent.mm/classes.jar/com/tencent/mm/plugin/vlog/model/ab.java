package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VideoSource;", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "width", "", "height", "path", "", "duration", "", "(IILjava/lang/String;J)V", "getDuration", "()J", "setDuration", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "plugin-vlog_release"})
public final class ab
  extends s
{
  long duration;
  String path;
  
  public ab(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    super(paramInt1, paramInt2, 0, (byte)0);
    AppMethodBeat.i(200953);
    this.path = paramString;
    this.duration = paramLong;
    AppMethodBeat.o(200953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ab
 * JD-Core Version:    0.7.0.1
 */