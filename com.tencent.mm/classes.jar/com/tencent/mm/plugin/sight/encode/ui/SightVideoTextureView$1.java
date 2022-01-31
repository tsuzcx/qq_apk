package com.tencent.mm.plugin.sight.encode.ui;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMTextureView;

final class SightVideoTextureView$1
  implements TextureView.SurfaceTextureListener
{
  SightVideoTextureView$1(SightVideoTextureView paramSightVideoTextureView) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25115);
    ab.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureAvailable, [%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.qXi.qWQ = SightCameraView.b.qXa;
    SightVideoTextureView.a(this.qXi, paramSurfaceTexture);
    ((MMTextureView)SightVideoTextureView.a(this.qXi)).dEs();
    ab.i("MicroMsg.SightVideoTextureView", "available texture %s, wantPlay %B", new Object[] { paramSurfaceTexture, Boolean.valueOf(SightVideoTextureView.b(this.qXi)) });
    if (SightVideoTextureView.b(this.qXi)) {
      this.qXi.bm(SightVideoTextureView.c(this.qXi), SightVideoTextureView.d(this.qXi));
    }
    AppMethodBeat.o(25115);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(25117);
    ab.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureDestroyed");
    this.qXi.qWQ = SightCameraView.b.qXc;
    SightVideoTextureView.a(this.qXi, null);
    this.qXi.qWS = false;
    ab.i("MicroMsg.SightVideoTextureView", "destroyed texture %s", new Object[] { paramSurfaceTexture });
    AppMethodBeat.o(25117);
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25116);
    ab.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureSizeChanged, [%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.qXi.qWQ = SightCameraView.b.qXb;
    ab.i("MicroMsg.SightVideoTextureView", "changed texture %s", new Object[] { paramSurfaceTexture });
    AppMethodBeat.o(25116);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView.1
 * JD-Core Version:    0.7.0.1
 */