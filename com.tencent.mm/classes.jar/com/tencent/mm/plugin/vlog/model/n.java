package com.tencent.mm.plugin.vlog.model;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"getInteger", "", "Landroid/media/MediaFormat;", "name", "", "defaultValue", "plugin-vlog_release"})
public final class n
{
  public static final int c(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    AppMethodBeat.i(195721);
    p.h(paramMediaFormat, "$this$getInteger");
    p.h(paramString, "name");
    if (paramMediaFormat.containsKey(paramString))
    {
      paramInt = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(195721);
      return paramInt;
    }
    AppMethodBeat.o(195721);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.n
 * JD-Core Version:    0.7.0.1
 */