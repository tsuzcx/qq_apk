package com.tencent.mm.plugin.voip.model;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.ui.b;
import com.tencent.mm.plugin.voip.video.b.d.a;

final class VoipMgr$17
  implements d.a
{
  VoipMgr$17(VoipMgr paramVoipMgr) {}
  
  public final void tW()
  {
    AppMethodBeat.i(140155);
    VoipMgr localVoipMgr = this.tyo;
    SurfaceTexture localSurfaceTexture = v2protocal.mSurfaceTexture;
    int i = v2protocal.textureId;
    if (localVoipMgr.txc != null)
    {
      localSurfaceTexture.setOnFrameAvailableListener(localVoipMgr);
      localVoipMgr.txc.a(localSurfaceTexture, i);
    }
    AppMethodBeat.o(140155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.17
 * JD-Core Version:    0.7.0.1
 */