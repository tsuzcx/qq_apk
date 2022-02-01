package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VideoSource;", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "width", "", "height", "path", "", "duration", "", "(IILjava/lang/String;J)V", "getDuration", "()J", "setDuration", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "plugin-vlog_release"})
public final class ak
  extends z
{
  long duration;
  String path;
  
  public ak(int paramInt1, int paramInt2, String paramString, long paramLong)
  {
    super(paramInt1, paramInt2, 0, (byte)0);
    AppMethodBeat.i(238489);
    this.path = paramString;
    this.duration = paramLong;
    AppMethodBeat.o(238489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ak
 * JD-Core Version:    0.7.0.1
 */