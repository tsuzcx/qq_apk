package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

@TargetApi(14)
public class SightVideoTextureView
  extends SightCameraView
{
  private MediaPlayer gHZ;
  private boolean mMute;
  private String oep;
  private TextureView oiR = null;
  private SurfaceTexture oiS = null;
  private Surface oiT = null;
  private boolean oiU;
  
  public SightVideoTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightVideoTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.oiR.setSurfaceTextureListener(new SightVideoTextureView.1(this));
  }
  
  public final void aX(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.SightVideoTextureView", "start play video, path %s, mute %B, wantPlay %B", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.oiU) });
    this.oep = paramString;
    this.mMute = paramBoolean;
    if (this.oiS == null)
    {
      y.w("MicroMsg.SightVideoTextureView", "play video fail, texture is null");
      this.oiU = true;
      return;
    }
    this.oiU = false;
    au.DS().O(new SightVideoTextureView.2(this, paramString, paramBoolean));
  }
  
  public final void bBR()
  {
    y.i("MicroMsg.SightVideoTextureView", "stop play video, wantPlay %B", new Object[] { Boolean.valueOf(this.oiU) });
    if ((this.gHZ == null) && (!this.oiU))
    {
      y.w("MicroMsg.SightVideoTextureView", "mediaplayer is null, do nothing when stop play video");
      return;
    }
    au.DS().O(new SightVideoTextureView.3(this));
  }
  
  protected Surface getPreviewSurface()
  {
    if (this.oiS != null) {
      return new Surface(this.oiS);
    }
    return null;
  }
  
  protected int getSurfaceHeight()
  {
    if (this.oiR != null) {
      return this.oiR.getHeight();
    }
    return 0;
  }
  
  protected int getSurfaceWidth()
  {
    if (this.oiR != null) {
      return this.oiR.getWidth();
    }
    return 0;
  }
  
  public final boolean isPlaying()
  {
    try
    {
      if (this.gHZ == null) {
        return false;
      }
      boolean bool = this.gHZ.isPlaying();
      return bool;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SightVideoTextureView", localException, "", new Object[0]);
    }
    return false;
  }
  
  public void setFixPreviewRate(float paramFloat)
  {
    ViewGroup.LayoutParams localLayoutParams = this.oiR.getLayoutParams();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    y.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate [%f], dm[%d, %d]", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels) });
    localLayoutParams.width = localDisplayMetrics.widthPixels;
    localLayoutParams.height = ((int)(localDisplayMetrics.widthPixels / paramFloat));
    y.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate width:%d, height:%d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
    this.oiR.setLayoutParams(localLayoutParams);
    super.setPreviewRate(paramFloat);
  }
  
  protected void setIsMute(boolean paramBoolean)
  {
    if (this.gHZ == null) {}
    for (;;)
    {
      return;
      try
      {
        boolean bool = this.gHZ.isPlaying();
        if (bool)
        {
          if (paramBoolean) {
            try
            {
              this.gHZ.setVolume(0.0F, 0.0F);
              return;
            }
            catch (Exception localException1)
            {
              y.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 0, 0 Fail: %s", new Object[] { localException1.getMessage() });
              return;
            }
          }
          bBT();
        }
      }
      catch (Exception localException2)
      {
        y.w("MicroMsg.SightVideoTextureView", "setIsMute %B, check MediaPlayer playing Fail: %s", new Object[] { Boolean.valueOf(paramBoolean), localException2.getMessage() });
        return;
      }
    }
    try
    {
      this.gHZ.setVolume(1.0F, 1.0F);
      return;
    }
    catch (Exception localException3)
    {
      y.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 1, 1 Fail: %s", new Object[] { localException3.getMessage() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView
 * JD-Core Version:    0.7.0.1
 */