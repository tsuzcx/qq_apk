package com.tencent.mm.plugin.thumbplayer.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView$textureListener$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMThumbPlayerTextureView$b
  implements TextureView.SurfaceTextureListener
{
  MMThumbPlayerTextureView$b(MMThumbPlayerTextureView paramMMThumbPlayerTextureView) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272239);
    s.u(paramSurfaceTexture, "surface");
    TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.TGX);
    if (localSurfaceTextureListener != null) {
      localSurfaceTextureListener.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(272239);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(272245);
    s.u(paramSurfaceTexture, "surface");
    TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.TGX);
    if (localSurfaceTextureListener != null) {
      localSurfaceTextureListener.onSurfaceTextureDestroyed(paramSurfaceTexture);
    }
    AppMethodBeat.o(272245);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272250);
    s.u(paramSurfaceTexture, "surface");
    TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.TGX);
    if (localSurfaceTextureListener != null) {
      localSurfaceTextureListener.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(272250);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(272255);
    s.u(paramSurfaceTexture, "surface");
    TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.TGX);
    if (localSurfaceTextureListener != null) {
      localSurfaceTextureListener.onSurfaceTextureUpdated(paramSurfaceTexture);
    }
    AppMethodBeat.o(272255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView.b
 * JD-Core Version:    0.7.0.1
 */