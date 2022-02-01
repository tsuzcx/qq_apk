package com.tencent.mm.plugin.voip.model;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.voip.ui.b;
import com.tencent.mm.plugin.voip.video.b.e.a;

final class VoipMgr$18
  implements e.a
{
  VoipMgr$18(VoipMgr paramVoipMgr) {}
  
  public final void BE()
  {
    AppMethodBeat.i(208351);
    VoipMgr localVoipMgr = this.AEb;
    SurfaceTexture localSurfaceTexture = v2protocal.mSurfaceTexture;
    d locald = v2protocal.AIm;
    if ((localVoipMgr.AzA != null) && (localSurfaceTexture != null))
    {
      localSurfaceTexture.setOnFrameAvailableListener(localVoipMgr);
      localVoipMgr.AzA.a(localSurfaceTexture, locald);
    }
    AppMethodBeat.o(208351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.18
 * JD-Core Version:    0.7.0.1
 */