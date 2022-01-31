package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SphereImageView$4
  implements TextureView.SurfaceTextureListener
{
  SphereImageView$4(SphereImageView paramSphereImageView) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145408);
    ab.i("SphereImageView.SphereView", "onSurfaceTextureAvailable, hasPendingImage=" + this.rBr.rBo);
    if (this.rBr.rBo)
    {
      this.rBr.queueEvent(this.rBr.g(this.rBr.rBn, this.rBr.hzS));
      this.rBr.rBn = null;
      this.rBr.rBo = false;
      this.rBr.hzS = "";
    }
    AppMethodBeat.o(145408);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.4
 * JD-Core Version:    0.7.0.1
 */