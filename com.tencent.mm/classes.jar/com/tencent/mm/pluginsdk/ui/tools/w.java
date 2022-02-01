package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.util.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class w
{
  public static i lG(Context paramContext)
  {
    AppMethodBeat.i(116317);
    if (Util.nullAs(af.lYj.lVl, "").equals("surface"))
    {
      Log.i("MicroMsg.VideoViewFactory", "match full type surface");
      paramContext = new VideoSurfaceView(paramContext);
      AppMethodBeat.o(116317);
      return paramContext;
    }
    if (m.aQq())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.w
 * JD-Core Version:    0.7.0.1
 */