package com.tencent.mm.plugin.voip.model;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.ui.b;
import com.tencent.mm.plugin.voip.video.b.e.a;

final class VoipMgr$18
  implements e.a
{
  VoipMgr$18(VoipMgr paramVoipMgr) {}
  
  public final void Dg()
  {
    AppMethodBeat.i(210063);
    VoipMgr localVoipMgr = this.CuC;
    SurfaceTexture localSurfaceTexture = v2protocal.mSurfaceTexture;
    d locald = v2protocal.CyO;
    if ((localVoipMgr.Cqb != null) && (localSurfaceTexture != null))
    {
      localSurfaceTexture.setOnFrameAvailableListener(localVoipMgr);
      localVoipMgr.Cqb.a(localSurfaceTexture, locald);
    }
    AppMethodBeat.o(210063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.18
 * JD-Core Version:    0.7.0.1
 */