package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class o
{
  public static f fb(Context paramContext)
  {
    if (bk.aM(q.dyn.dxD, "").equals("surface"))
    {
      y.i("MicroMsg.VideoViewFactory", "match full type surface");
      return new VideoSurfaceView(paramContext);
    }
    if (m.zN())
    {
      y.i("MicroMsg.VideoViewFactory", "IS MTK platform");
      return new VideoSightView(paramContext);
    }
    y.i("MicroMsg.VideoViewFactory", "default settings, use sightview");
    return new VideoSightView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.o
 * JD-Core Version:    0.7.0.1
 */