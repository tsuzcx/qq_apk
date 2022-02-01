package com.tencent.mm.plugin.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMTextureView;

public class ObservableTextureView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  protected b GwU;
  private boolean GwV;
  protected SurfaceTexture surfaceTexture;
  
  public ObservableTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(127133);
    this.GwV = false;
    init();
    AppMethodBeat.o(127133);
  }
  
  public ObservableTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(127134);
    this.GwV = false;
    init();
    AppMethodBeat.o(127134);
  }
  
  public ObservableTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.GwV = false;
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
    return this.GwV;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127136);
    Log.i("MicroMsg.ObservableTextureView", "onSurfaceTextureAvailable");
    gLi();
    this.GwV = true;
    if (this.GwU != null) {
      this.GwU.f(paramSurfaceTexture);
    }
    AppMethodBeat.o(127136);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(127138);
    Log.i("MicroMsg.ObservableTextureView", "onSurfaceTextureDestroyed");
    this.GwV = false;
    AppMethodBeat.o(127138);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(127137);
    Log.d("MicroMsg.ObservableTextureView", "onSurfaceTextureSizeChanged");
    AppMethodBeat.o(127137);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setTextureChangeCallback(b paramb)
  {
    this.GwU = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.video.ObservableTextureView
 * JD-Core Version:    0.7.0.1
 */