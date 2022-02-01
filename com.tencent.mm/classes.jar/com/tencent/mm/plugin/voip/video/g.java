package com.tencent.mm.plugin.voip.video;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/VoipSurfaceTexture;", "Landroid/graphics/SurfaceTexture;", "texName", "", "(I)V", "TAG", "", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.g
 * JD-Core Version:    0.7.0.1
 */