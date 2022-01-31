package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.util.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class q
{
  public static e ga(Context paramContext)
  {
    AppMethodBeat.i(70463);
    if (bo.bf(ac.erF.epB, "").equals("surface"))
    {
      ab.i("MicroMsg.VideoViewFactory", "match full type surface");
      paramContext = new VideoSurfaceView(paramContext);
      AppMethodBeat.o(70463);
      return paramContext;
    }
    if (m.Ms())
    {
      ab.i("MicroMsg.VideoViewFactory", "IS MTK platform");
      paramContext = new VideoSightView(paramContext);
      AppMethodBeat.o(70463);
      return paramContext;
    }
    ab.i("MicroMsg.VideoViewFactory", "default settings, use sightview");
    paramContext = new VideoSightView(paramContext);
    AppMethodBeat.o(70463);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.q
 * JD-Core Version:    0.7.0.1
 */