package com.tencent.mm.plugin.sight.encode.ui;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;

final class SightVideoTextureView$1
  implements TextureView.SurfaceTextureListener
{
  SightVideoTextureView$1(SightVideoTextureView paramSightVideoTextureView) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureAvailable, [%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.oiV.oiD = SightCameraView.b.oiN;
    SightVideoTextureView.a(this.oiV, paramSurfaceTexture);
    ((MMTextureView)SightVideoTextureView.a(this.oiV)).cBe();
    y.i("MicroMsg.SightVideoTextureView", "available texture %s, wantPlay %B", new Object[] { paramSurfaceTexture, Boolean.valueOf(SightVideoTextureView.b(this.oiV)) });
    if (SightVideoTextureView.b(this.oiV)) {
      this.oiV.aX(SightVideoTextureView.c(this.oiV), SightVideoTextureView.d(this.oiV));
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    y.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureDestroyed");
    this.oiV.oiD = SightCameraView.b.oiP;
    SightVideoTextureView.a(this.oiV, null);
    this.oiV.oiF = false;
    y.i("MicroMsg.SightVideoTextureView", "destroyed texture %s", new Object[] { paramSurfaceTexture });
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureSizeChanged, [%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.oiV.oiD = SightCameraView.b.oiO;
    y.i("MicroMsg.SightVideoTextureView", "changed texture %s", new Object[] { paramSurfaceTexture });
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView.1
 * JD-Core Version:    0.7.0.1
 */