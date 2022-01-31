package com.tencent.mm.plugin.voip_cs.ui.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;

public class VoipCSVideoView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static final int[] mwE = { 452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295 };
  private SurfaceTexture aTk;
  private int fvV;
  private int fvW;
  private int index;
  private Paint mwF;
  private int position;
  private VoipCSVideoView.a qeY = VoipCSVideoView.a.qfb;
  private String username;
  
  public VoipCSVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public VoipCSVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    if (isAvailable()) {
      onSurfaceTextureAvailable(getSurfaceTexture(), getWidth(), getHeight());
    }
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    y.i("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureAvailable %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    String str = this.username;
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureDestroyed %s %b", new Object[] { str, Boolean.valueOf(bool) });
      this.aTk = null;
      this.fvW = 0;
      this.fvV = 0;
      return false;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    y.i("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureSizeChanged %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = false;
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    y.v("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureUpdated %s %b", new Object[] { str, Boolean.valueOf(bool) });
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.widget.VoipCSVideoView
 * JD-Core Version:    0.7.0.1
 */