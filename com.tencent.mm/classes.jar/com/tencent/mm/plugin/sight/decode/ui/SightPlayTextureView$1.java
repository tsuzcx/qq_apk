package com.tencent.mm.plugin.sight.decode.ui;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.sdk.platformtools.ad;

final class SightPlayTextureView$1
  implements TextureView.SurfaceTextureListener
{
  SightPlayTextureView$1(SightPlayTextureView paramSightPlayTextureView) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28643);
    ad.i("MicroMsg.SightPlayTextureView", "on surface texture available, width %d height %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    SightPlayTextureView.a locala = new SightPlayTextureView.a((byte)0);
    locala.ySF = SightPlayTextureView.e(this.ySE);
    o.i(locala, 0L);
    SightPlayTextureView.a(this.ySE, new Surface(paramSurfaceTexture));
    SightPlayTextureView.d(this.ySE).j(SightPlayTextureView.e(this.ySE));
    this.ySE.fzf();
    AppMethodBeat.o(28643);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(28642);
    ad.i("MicroMsg.SightPlayTextureView", "on surface texture destroyed");
    SightPlayTextureView.d(this.ySE).j(null);
    SightPlayTextureView.d(this.ySE).clear();
    paramSurfaceTexture = new SightPlayTextureView.a((byte)0);
    paramSurfaceTexture.ySF = SightPlayTextureView.e(this.ySE);
    o.i(paramSurfaceTexture, 0L);
    SightPlayTextureView.a(this.ySE, null);
    AppMethodBeat.o(28642);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(28641);
    ad.i("MicroMsg.SightPlayTextureView", "on surface texture size changed, width " + paramInt1 + " height " + paramInt2);
    AppMethodBeat.o(28641);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView.1
 * JD-Core Version:    0.7.0.1
 */