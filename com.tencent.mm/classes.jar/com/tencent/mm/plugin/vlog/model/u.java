package com.tencent.mm.plugin.vlog.model;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"getInteger", "", "Landroid/media/MediaFormat;", "name", "", "defaultValue", "getLong", "", "plugin-vlog_release"})
public final class u
{
  public static final int c(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    AppMethodBeat.i(190590);
    p.h(paramMediaFormat, "$this$getInteger");
    p.h(paramString, "name");
    if (paramMediaFormat.containsKey(paramString))
    {
      paramInt = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(190590);
      return paramInt;
    }
    AppMethodBeat.o(190590);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.u
 * JD-Core Version:    0.7.0.1
 */