package com.tencent.mm.plugin.multitalk.model;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
final class m$f
  implements SurfaceTexture.OnFrameAvailableListener
{
  public static final f Frv;
  
  static
  {
    AppMethodBeat.i(200402);
    Frv = new f();
    AppMethodBeat.o(200402);
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(200401);
    try
    {
      paramSurfaceTexture.updateTexImage();
      AppMethodBeat.o(200401);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      Log.e("MicroMsg.MultiTalkCameraManager", "updateTexImage error");
      AppMethodBeat.o(200401);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.m.f
 * JD-Core Version:    0.7.0.1
 */