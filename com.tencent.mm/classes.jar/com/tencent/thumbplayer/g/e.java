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
  TPNativePlayerSurface ahJf;
  private ITPSurfaceListener ahJg;
  private ITPNativePlayerSurfaceCallback ahJh;
  
  public e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(227165);
    this.ahJf = null;
    this.ahJg = null;
    this.ahJh = new ITPNativePlayerSurfaceCallback()
    {
      public final void onRenderInfo(TPNativePlayerSurfaceRenderInfo paramAnonymousTPNativePlayerSurfaceRenderInfo)
      {
        AppMethodBeat.i(227140);
        ITPSurfaceListener localITPSurfaceListener = e.a(e.this);
        if (localITPSurfaceListener != null) {
          localITPSurfaceListener.onRenderInfo(c.a(paramAnonymousTPNativePlayerSurfaceRenderInfo));
        }
        AppMethodBeat.o(227140);
      }
    };
    this.ahJf = new TPNativePlayerSurface(paramSurfaceTexture);
    this.ahJf.setTPSurfaceCallback(this.ahJh);
    AppMethodBeat.o(227165);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(227185);
    this.ahJf.release();
    super.finalize();
    AppMethodBeat.o(227185);
  }
  
  public final void setSurfaceListener(ITPSurfaceListener paramITPSurfaceListener)
  {
    this.ahJg = paramITPSurfaceListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.g.e
 * JD-Core Version:    0.7.0.1
 */