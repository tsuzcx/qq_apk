package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;

public class VoIPVideoView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static final int[] mwE = { 452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295 };
  private SurfaceTexture aTk;
  private float bgT = 0.4F;
  private int fvV;
  private int fvW;
  private Paint mwF;
  private int qcC = 30;
  private int qcD = 30;
  private int qcE = 15;
  private float qcF = 0.02F;
  
  public VoIPVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public VoIPVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    this.mwF = new Paint();
    this.mwF.setColor(-16777216);
    this.mwF.setFilterBitmap(true);
    this.mwF.setTextSize(40.0F);
    setSurfaceTextureListener(this);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureAvailable %b %d %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.aTk = paramSurfaceTexture;
      this.fvV = paramInt1;
      this.fvW = paramInt2;
      cBe();
      return;
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = true;
    if (paramSurfaceTexture != null) {}
    for (;;)
    {
      y.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureDestroyed %b", new Object[] { Boolean.valueOf(bool) });
      this.aTk = null;
      this.fvW = 0;
      this.fvV = 0;
      return false;
      bool = false;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureSizeChanged %b %d %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.fvV = paramInt1;
      this.fvW = paramInt2;
      return;
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = true;
    if (paramSurfaceTexture != null) {}
    for (;;)
    {
      y.v("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureUpdated %b", new Object[] { Boolean.valueOf(bool) });
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoIPVideoView
 * JD-Core Version:    0.7.0.1
 */