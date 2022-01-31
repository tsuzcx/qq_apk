package com.tencent.mm.plugin.sight.decode.ui;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class SightPlayTextureView$1
  implements TextureView.SurfaceTextureListener
{
  SightPlayTextureView$1(SightPlayTextureView paramSightPlayTextureView) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24973);
    ab.i("MicroMsg.SightPlayTextureView", "on surface texture available, width %d height %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    SightPlayTextureView.a locala = new SightPlayTextureView.a((byte)0);
    locala.qUg = SightPlayTextureView.e(this.qUf);
    o.j(locala, 0L);
    SightPlayTextureView.a(this.qUf, new Surface(paramSurfaceTexture));
    SightPlayTextureView.d(this.qUf).g(SightPlayTextureView.e(this.qUf));
    this.qUf.dEs();
    AppMethodBeat.o(24973);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(24972);
    ab.i("MicroMsg.SightPlayTextureView", "on surface texture destroyed");
    SightPlayTextureView.d(this.qUf).g(null);
    SightPlayTextureView.d(this.qUf).clear();
    paramSurfaceTexture = new SightPlayTextureView.a((byte)0);
    paramSurfaceTexture.qUg = SightPlayTextureView.e(this.qUf);
    o.j(paramSurfaceTexture, 0L);
    SightPlayTextureView.a(this.qUf, null);
    AppMethodBeat.o(24972);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24971);
    ab.i("MicroMsg.SightPlayTextureView", "on surface texture size changed, width " + paramInt1 + " height " + paramInt2);
    AppMethodBeat.o(24971);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView.1
 * JD-Core Version:    0.7.0.1
 */