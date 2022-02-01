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
  TPNativePlayerSurface ZEc;
  private ITPSurfaceListener ZEd;
  private ITPNativePlayerSurfaceCallback ZEe;
  
  public e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(221541);
    this.ZEc = null;
    this.ZEd = null;
    this.ZEe = new ITPNativePlayerSurfaceCallback()
    {
      public final void onRenderInfo(TPNativePlayerSurfaceRenderInfo paramAnonymousTPNativePlayerSurfaceRenderInfo)
      {
        AppMethodBeat.i(221536);
        ITPSurfaceListener localITPSurfaceListener = e.a(e.this);
        if (localITPSurfaceListener != null) {
          localITPSurfaceListener.onRenderInfo(c.a(paramAnonymousTPNativePlayerSurfaceRenderInfo));
        }
        AppMethodBeat.o(221536);
      }
    };
    this.ZEc = new TPNativePlayerSurface(paramSurfaceTexture);
    this.ZEc.setTPSurfaceCallback(this.ZEe);
    AppMethodBeat.o(221541);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(221542);
    this.ZEc.release();
    super.finalize();
    AppMethodBeat.o(221542);
  }
  
  public final void setSurfaceListener(ITPSurfaceListener paramITPSurfaceListener)
  {
    this.ZEd = paramITPSurfaceListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.g.e
 * JD-Core Version:    0.7.0.1
 */