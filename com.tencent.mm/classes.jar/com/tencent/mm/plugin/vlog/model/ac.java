package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/VideoSource;", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "width", "", "height", "path", "", "duration", "", "(IILjava/lang/String;J)V", "getDuration", "()J", "setDuration", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "plugin-vlog_release"})
public final class ac
  extends s
{
  long duration;
  String path;
  
  public ac(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    super(paramInt1, paramInt2, 0, (byte)0);
    AppMethodBeat.i(195826);
    this.path = paramString;
    this.duration = paramLong;
    AppMethodBeat.o(195826);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ac
 * JD-Core Version:    0.7.0.1
 */