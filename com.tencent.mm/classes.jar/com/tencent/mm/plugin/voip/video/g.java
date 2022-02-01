package com.tencent.mm.plugin.voip.video;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/VoipSurfaceTexture;", "Landroid/graphics/SurfaceTexture;", "texName", "", "(I)V", "TAG", "", "plugin-voip_release"})
public final class g
  extends SurfaceTexture
{
  private final String TAG;
  
  public g(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(115960);
    this.TAG = "MicroMsg.VoipSurfaceTexture";
    try
    {
      super.detachFromGLContext();
      AppMethodBeat.o(115960);
      return;
    }
    catch (Exception localException)
    {
      Log.i(this.TAG, "detachFromGLContext  in init error");
      AppMethodBeat.o(115960);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.g
 * JD-Core Version:    0.7.0.1
 */