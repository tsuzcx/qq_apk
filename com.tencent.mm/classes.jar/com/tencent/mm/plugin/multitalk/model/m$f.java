package com.tencent.mm.plugin.multitalk.model;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable"})
final class m$f
  implements SurfaceTexture.OnFrameAvailableListener
{
  public static final f zMc;
  
  static
  {
    AppMethodBeat.i(239605);
    zMc = new f();
    AppMethodBeat.o(239605);
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(239604);
    try
    {
      paramSurfaceTexture.updateTexImage();
      AppMethodBeat.o(239604);
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      Log.e("MicroMsg.MultiTalkCameraManager", "updateTexImage error");
      AppMethodBeat.o(239604);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.m.f
 * JD-Core Version:    0.7.0.1
 */