package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.MMTextureView;

public class VoIPVideoView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static final int[] tTp = { 452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295 };
  private Paint nSL;
  private float rQP;
  private int surfaceHeight;
  private SurfaceTexture surfaceTexture;
  private int surfaceWidth;
  private int zBC;
  private int zBD;
  private int zBE;
  private float zBF;
  
  public VoIPVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115781);
    this.rQP = 0.4F;
    this.zBC = 30;
    this.zBD = 30;
    this.zBE = 15;
    this.zBF = 0.02F;
    initView();
    AppMethodBeat.o(115781);
  }
  
  public VoIPVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(115782);
    this.rQP = 0.4F;
    this.zBC = 30;
    this.zBD = 30;
    this.zBE = 15;
    this.zBF = 0.02F;
    initView();
    AppMethodBeat.o(115782);
  }
  
  private void initView()
  {
    AppMethodBeat.i(115783);
    this.nSL = new Paint();
    this.nSL.setColor(-16777216);
    this.nSL.setFilterBitmap(true);
    this.nSL.setTextSize(40.0F);
    setSurfaceTextureListener(this);
    AppMethodBeat.o(115783);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115784);
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureAvailable %b %d %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.surfaceTexture = paramSurfaceTexture;
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
      eTg();
      AppMethodBeat.o(115784);
      return;
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = true;
    AppMethodBeat.i(115786);
    if (paramSurfaceTexture != null) {}
    for (;;)
    {
      ad.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureDestroyed %b", new Object[] { Boolean.valueOf(bool) });
      this.surfaceTexture = null;
      this.surfaceHeight = 0;
      this.surfaceWidth = 0;
      AppMethodBeat.o(115786);
      return false;
      bool = false;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115785);
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureSizeChanged %b %d %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
      AppMethodBeat.o(115785);
      return;
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = true;
    AppMethodBeat.i(115787);
    if (paramSurfaceTexture != null) {}
    for (;;)
    {
      ad.v("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureUpdated %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(115787);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoIPVideoView
 * JD-Core Version:    0.7.0.1
 */