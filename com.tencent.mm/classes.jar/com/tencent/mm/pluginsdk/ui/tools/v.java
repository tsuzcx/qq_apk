package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class v
{
  public static j iE(Context paramContext)
  {
    AppMethodBeat.i(116317);
    if (Util.nullAs(ae.gKE.gHE, "").equals("surface"))
    {
      Log.i("MicroMsg.VideoViewFactory", "match full type surface");
      paramContext = new VideoSurfaceView(paramContext);
      AppMethodBeat.o(116317);
      return paramContext;
    }
    if (l.apy())
    {
      Log.i("MicroMsg.VideoViewFactory", "IS MTK platform");
      paramContext = new VideoSightView(paramContext);
      AppMethodBeat.o(116317);
      return paramContext;
    }
    Log.i("MicroMsg.VideoViewFactory", "default settings, use sightview");
    paramContext = new VideoSightView(paramContext);
    AppMethodBeat.o(116317);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.v
 * JD-Core Version:    0.7.0.1
 */