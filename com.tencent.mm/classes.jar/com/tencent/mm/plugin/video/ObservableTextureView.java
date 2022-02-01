package com.tencent.mm.plugin.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.MMTextureView;

public class ObservableTextureView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  protected SurfaceTexture surfaceTexture;
  protected b yYT;
  private boolean yYU;
  
  public ObservableTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(127133);
    this.yYU = false;
    init();
    AppMethodBeat.o(127133);
  }
  
  public ObservableTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(127134);
    this.yYU = false;
    init();
    AppMethodBeat.o(127134);
  }
  
  public ObservableTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.yYU = false;
  }
  
  private void init()
  {
    AppMethodBeat.i(127135);
    setSurfaceTextureListener(this);
    this.surfaceTexture = getSurfaceTexture();
    AppMethodBeat.o(127135);
  }
  
  public boolean isAvailable()
  {
    return this.yYU;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127136);
    ad.i("MicroMsg.ObservableTextureView", "onSurfaceTextureAvailable");
    eTg();
    this.yYU = true;
    if (this.yYT != null) {
      this.yYT.f(paramSurfaceTexture);
    }
    AppMethodBeat.o(127136);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(127138);
    ad.i("MicroMsg.ObservableTextureView", "onSurfaceTextureDestroyed");
    this.yYU = false;
    AppMethodBeat.o(127138);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127137);
    ad.d("MicroMsg.ObservableTextureView", "onSurfaceTextureSizeChanged");
    AppMethodBeat.o(127137);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setTextureChangeCallback(b paramb)
  {
    this.yYT = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.video.ObservableTextureView
 * JD-Core Version:    0.7.0.1
 */