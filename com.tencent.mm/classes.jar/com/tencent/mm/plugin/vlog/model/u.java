package com.tencent.mm.plugin.vlog.model;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getInteger", "", "Landroid/media/MediaFormat;", "name", "", "defaultValue", "getLong", "", "plugin-vlog_release"})
public final class u
{
  public static final int c(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    AppMethodBeat.i(250616);
    p.k(paramMediaFormat, "$this$getInteger");
    p.k(paramString, "name");
    if (paramMediaFormat.containsKey(paramString))
    {
      paramInt = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(250616);
      return paramInt;
    }
    AppMethodBeat.o(250616);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.u
 * JD-Core Version:    0.7.0.1
 */