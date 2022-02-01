package com.tencent.thumbplayer.g;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.b.c;
import com.tencent.thumbplayer.api.ITPSurface;
import com.tencent.thumbplayer.api.ITPSurfaceListener;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSurfaceCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurface;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo;

public final class e
  implements ITPSurface
{
  TPNativePlayerSurface Sbr;
  private ITPSurfaceListener Sbs;
  private ITPNativePlayerSurfaceCallback Sbt;
  
  public e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(189516);
    this.Sbr = null;
    this.Sbs = null;
    this.Sbt = new ITPNativePlayerSurfaceCallback()
    {
      public final void onRenderInfo(TPNativePlayerSurfaceRenderInfo paramAnonymousTPNativePlayerSurfaceRenderInfo)
      {
        AppMethodBeat.i(189515);
        ITPSurfaceListener localITPSurfaceListener = e.a(e.this);
        if (localITPSurfaceListener != null) {
          localITPSurfaceListener.onRenderInfo(c.a(paramAnonymousTPNativePlayerSurfaceRenderInfo));
        }
        AppMethodBeat.o(189515);
      }
    };
    this.Sbr = new TPNativePlayerSurface(paramSurfaceTexture);
    this.Sbr.setTPSurfaceCallback(this.Sbt);
    AppMethodBeat.o(189516);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(189517);
    this.Sbr.release();
    super.finalize();
    AppMethodBeat.o(189517);
  }
  
  public final void setSurfaceListener(ITPSurfaceListener paramITPSurfaceListener)
  {
    this.Sbs = paramITPSurfaceListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.g.e
 * JD-Core Version:    0.7.0.1
 */