package com.tencent.mm.plugin.vlog.model;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"getInteger", "", "Landroid/media/MediaFormat;", "name", "", "defaultValue", "getLong", "", "plugin-vlog_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class u
{
  public static final int c(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    AppMethodBeat.i(283570);
    s.u(paramMediaFormat, "<this>");
    s.u(paramString, "name");
    if (paramMediaFormat.containsKey(paramString))
    {
      paramInt = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(283570);
      return paramInt;
    }
    AppMethodBeat.o(283570);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.u
 * JD-Core Version:    0.7.0.1
 */