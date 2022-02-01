package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMTextureView;

public class VoIPVideoView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static final int[] Hqr = { 452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295 };
  private int Hqs;
  private int Hqt;
  private int Hqu;
  private float Hqv;
  private Paint qvj;
  private int surfaceHeight;
  private SurfaceTexture surfaceTexture;
  private int surfaceWidth;
  private float tEJ;
  
  public VoIPVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115781);
    this.tEJ = 0.4F;
    this.Hqs = 30;
    this.Hqt = 30;
    this.Hqu = 15;
    this.Hqv = 0.02F;
    initView();
    AppMethodBeat.o(115781);
  }
  
  public VoIPVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(115782);
    this.tEJ = 0.4F;
    this.Hqs = 30;
    this.Hqt = 30;
    this.Hqu = 15;
    this.Hqv = 0.02F;
    initView();
    AppMethodBeat.o(115782);
  }
  
  private void initView()
  {
    AppMethodBeat.i(115783);
    this.qvj = new Paint();
    this.qvj.setColor(-16777216);
    this.qvj.setFilterBitmap(true);
    this.qvj.setTextSize(40.0F);
    setSurfaceTextureListener(this);
    AppMethodBeat.o(115783);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115784);
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureAvailable %b %d %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.surfaceTexture = paramSurfaceTexture;
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
      gLi();
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
      Log.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureDestroyed %b", new Object[] { Boolean.valueOf(bool) });
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
      Log.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureSizeChanged %b %d %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      Log.v("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureUpdated %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(115787);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoIPVideoView
 * JD-Core Version:    0.7.0.1
 */