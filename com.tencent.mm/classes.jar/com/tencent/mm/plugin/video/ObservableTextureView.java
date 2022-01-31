package com.tencent.mm.plugin.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;

public class ObservableTextureView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  protected SurfaceTexture aTk;
  protected b pKV;
  private boolean pKW = false;
  
  public ObservableTextureView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ObservableTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ObservableTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void init()
  {
    setSurfaceTextureListener(this);
    this.aTk = getSurfaceTexture();
  }
  
  public boolean isAvailable()
  {
    return this.pKW;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.ObservableTextureView", "onSurfaceTextureAvailable");
    cBe();
    this.pKW = true;
    if (this.pKV != null) {
      this.pKV.e(paramSurfaceTexture);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    y.i("MicroMsg.ObservableTextureView", "onSurfaceTextureDestroyed");
    this.pKW = false;
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.ObservableTextureView", "onSurfaceTextureSizeChanged");
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setTextureChangeCallback(b paramb)
  {
    this.pKV = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.video.ObservableTextureView
 * JD-Core Version:    0.7.0.1
 */