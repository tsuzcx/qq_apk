package com.tencent.mm.plugin.voip.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;

public final class e
  implements TextureView.SurfaceTextureListener
{
  public MMTextureView jXi;
  int mWidth = 320;
  private final String qat = "DecodeTextureView";
  public SurfaceTexture qau;
  int qav = 240;
  
  public e()
  {
    y.d("DecodeTextureView", "steve:  new DecodeTextureView instance");
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("DecodeTextureView", "onSurfaceTextureAvailable size=" + paramInt1 + "x" + paramInt2 + ", st=" + paramSurfaceTexture);
    if (this.qau == null)
    {
      this.qau = paramSurfaceTexture;
      v2protocal.pWm = new Surface(paramSurfaceTexture);
      y.i("DecodeTextureView", "steve: pass decoder surface successfully!");
      v2protocal.a(this);
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    y.i("DecodeTextureView", "onSurfaceTextureDestroyed st=" + paramSurfaceTexture);
    return this.qau == null;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.d("DecodeTextureView", "onSurfaceTextureSizeChanged size=" + paramInt1 + "x" + paramInt2 + ", st=" + paramSurfaceTexture);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.e
 * JD-Core Version:    0.7.0.1
 */