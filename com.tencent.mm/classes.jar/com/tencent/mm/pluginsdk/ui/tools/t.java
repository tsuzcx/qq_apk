package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.sdk.platformtools.bu;

public final class t
{
  public static h hK(Context paramContext)
  {
    AppMethodBeat.i(116317);
    if (bu.bI(com.tencent.mm.compatible.deviceinfo.ae.geX.gcg, "").equals("surface"))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoViewFactory", "match full type surface");
      paramContext = new VideoSurfaceView(paramContext);
      AppMethodBeat.o(116317);
      return paramContext;
    }
    if (l.abB())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoViewFactory", "IS MTK platform");
      paramContext = new VideoSightView(paramContext);
      AppMethodBeat.o(116317);
      return paramContext;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoViewFactory", "default settings, use sightview");
    paramContext = new VideoSightView(paramContext);
    AppMethodBeat.o(116317);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.t
 * JD-Core Version:    0.7.0.1
 */