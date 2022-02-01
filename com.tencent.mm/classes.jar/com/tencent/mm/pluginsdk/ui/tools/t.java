package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class t
{
  public static h hz(Context paramContext)
  {
    AppMethodBeat.i(116317);
    if (bs.bG(ae.fJo.fGy, "").equals("surface"))
    {
      ac.i("MicroMsg.VideoViewFactory", "match full type surface");
      paramContext = new VideoSurfaceView(paramContext);
      AppMethodBeat.o(116317);
      return paramContext;
    }
    if (l.YR())
    {
      ac.i("MicroMsg.VideoViewFactory", "IS MTK platform");
      paramContext = new VideoSightView(paramContext);
      AppMethodBeat.o(116317);
      return paramContext;
    }
    ac.i("MicroMsg.VideoViewFactory", "default settings, use sightview");
    paramContext = new VideoSightView(paramContext);
    AppMethodBeat.o(116317);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.t
 * JD-Core Version:    0.7.0.1
 */