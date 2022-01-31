package com.tencent.mm.plugin.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMTextureView;

public class ObservableTextureView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  protected SurfaceTexture bbI;
  protected b tqR;
  private boolean tqS;
  
  public ObservableTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50963);
    this.tqS = false;
    init();
    AppMethodBeat.o(50963);
  }
  
  public ObservableTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(50964);
    this.tqS = false;
    init();
    AppMethodBeat.o(50964);
  }
  
  public ObservableTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.tqS = false;
  }
  
  private void init()
  {
    AppMethodBeat.i(50965);
    setSurfaceTextureListener(this);
    this.bbI = getSurfaceTexture();
    AppMethodBeat.o(50965);
  }
  
  public boolean isAvailable()
  {
    return this.tqS;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50966);
    ab.i("MicroMsg.ObservableTextureView", "onSurfaceTextureAvailable");
    dEs();
    this.tqS = true;
    if (this.tqR != null) {
      this.tqR.f(paramSurfaceTexture);
    }
    AppMethodBeat.o(50966);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(50968);
    ab.i("MicroMsg.ObservableTextureView", "onSurfaceTextureDestroyed");
    this.tqS = false;
    AppMethodBeat.o(50968);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50967);
    ab.d("MicroMsg.ObservableTextureView", "onSurfaceTextureSizeChanged");
    AppMethodBeat.o(50967);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setTextureChangeCallback(b paramb)
  {
    this.tqR = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.video.ObservableTextureView
 * JD-Core Version:    0.7.0.1
 */