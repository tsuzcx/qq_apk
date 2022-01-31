package com.tencent.mm.plugin.sight.decode.ui;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class SightPlayTextureView$1
  implements TextureView.SurfaceTextureListener
{
  SightPlayTextureView$1(SightPlayTextureView paramSightPlayTextureView) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.SightPlayTextureView", "on surface texture available, width %d height %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    SightPlayTextureView.a locala = new SightPlayTextureView.a((byte)0);
    locala.ofR = SightPlayTextureView.e(this.ofQ);
    o.g(locala, 0L);
    SightPlayTextureView.a(this.ofQ, new Surface(paramSurfaceTexture));
    SightPlayTextureView.d(this.ofQ).e(SightPlayTextureView.e(this.ofQ));
    this.ofQ.cBe();
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    y.i("MicroMsg.SightPlayTextureView", "on surface texture destroyed");
    SightPlayTextureView.d(this.ofQ).e(null);
    SightPlayTextureView.d(this.ofQ).clear();
    paramSurfaceTexture = new SightPlayTextureView.a((byte)0);
    paramSurfaceTexture.ofR = SightPlayTextureView.e(this.ofQ);
    o.g(paramSurfaceTexture, 0L);
    SightPlayTextureView.a(this.ofQ, null);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.SightPlayTextureView", "on surface texture size changed, width " + paramInt1 + " height " + paramInt2);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.ui.SightPlayTextureView.1
 * JD-Core Version:    0.7.0.1
 */