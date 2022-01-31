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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

@TargetApi(14)
public class SightVideoTextureView
  extends SightCameraView
{
  private String bHM;
  private MediaPlayer bIo;
  private boolean mMute;
  private TextureView qXe;
  private SurfaceTexture qXf;
  private Surface qXg;
  private boolean qXh;
  
  public SightVideoTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightVideoTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(25124);
    this.qXe = null;
    this.qXf = null;
    this.qXg = null;
    this.qXe = ((TextureView)findViewById(2131827769));
    this.qXe.setSurfaceTextureListener(new SightVideoTextureView.1(this));
    AppMethodBeat.o(25124);
  }
  
  public final void bm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(25126);
    ab.i("MicroMsg.SightVideoTextureView", "start play video, path %s, mute %B, wantPlay %B", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.qXh) });
    this.bHM = paramString;
    this.mMute = paramBoolean;
    if (this.qXf == null)
    {
      ab.w("MicroMsg.SightVideoTextureView", "play video fail, texture is null");
      this.qXh = true;
      AppMethodBeat.o(25126);
      return;
    }
    this.qXh = false;
    aw.RO().ac(new SightVideoTextureView.2(this, paramString, paramBoolean));
    AppMethodBeat.o(25126);
  }
  
  public final void cns()
  {
    AppMethodBeat.i(25128);
    ab.i("MicroMsg.SightVideoTextureView", "stop play video, wantPlay %B", new Object[] { Boolean.valueOf(this.qXh) });
    if ((this.bIo == null) && (!this.qXh))
    {
      ab.w("MicroMsg.SightVideoTextureView", "mediaplayer is null, do nothing when stop play video");
      AppMethodBeat.o(25128);
      return;
    }
    aw.RO().ac(new SightVideoTextureView.3(this));
    AppMethodBeat.o(25128);
  }
  
  protected Surface getPreviewSurface()
  {
    AppMethodBeat.i(25131);
    if (this.qXf != null)
    {
      Surface localSurface = new Surface(this.qXf);
      AppMethodBeat.o(25131);
      return localSurface;
    }
    AppMethodBeat.o(25131);
    return null;
  }
  
  protected int getSurfaceHeight()
  {
    AppMethodBeat.i(25130);
    if (this.qXe != null)
    {
      int i = this.qXe.getHeight();
      AppMethodBeat.o(25130);
      return i;
    }
    AppMethodBeat.o(25130);
    return 0;
  }
  
  protected int getSurfaceWidth()
  {
    AppMethodBeat.i(25129);
    if (this.qXe != null)
    {
      int i = this.qXe.getWidth();
      AppMethodBeat.o(25129);
      return i;
    }
    AppMethodBeat.o(25129);
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(25127);
    try
    {
      if (this.bIo == null)
      {
        AppMethodBeat.o(25127);
        return false;
      }
      boolean bool = this.bIo.isPlaying();
      AppMethodBeat.o(25127);
      return bool;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SightVideoTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(25127);
    }
    return false;
  }
  
  public void setFixPreviewRate(float paramFloat)
  {
    AppMethodBeat.i(25132);
    ViewGroup.LayoutParams localLayoutParams = this.qXe.getLayoutParams();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    ab.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate [%f], dm[%d, %d]", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels) });
    localLayoutParams.width = localDisplayMetrics.widthPixels;
    localLayoutParams.height = ((int)(localDisplayMetrics.widthPixels / paramFloat));
    ab.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate width:%d, height:%d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
    this.qXe.setLayoutParams(localLayoutParams);
    super.setPreviewRate(paramFloat);
    AppMethodBeat.o(25132);
  }
  
  protected void setIsMute(boolean paramBoolean)
  {
    AppMethodBeat.i(25125);
    if (this.bIo == null)
    {
      AppMethodBeat.o(25125);
      return;
    }
    try
    {
      boolean bool = this.bIo.isPlaying();
      if (!bool)
      {
        AppMethodBeat.o(25125);
        return;
      }
    }
    catch (Exception localException1)
    {
      ab.w("MicroMsg.SightVideoTextureView", "setIsMute %B, check MediaPlayer playing Fail: %s", new Object[] { Boolean.valueOf(paramBoolean), localException1.getMessage() });
      AppMethodBeat.o(25125);
      return;
    }
    if (paramBoolean) {
      try
      {
        this.bIo.setVolume(0.0F, 0.0F);
        AppMethodBeat.o(25125);
        return;
      }
      catch (Exception localException2)
      {
        ab.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 0, 0 Fail: %s", new Object[] { localException2.getMessage() });
        AppMethodBeat.o(25125);
        return;
      }
    }
    cnu();
    try
    {
      this.bIo.setVolume(1.0F, 1.0F);
      AppMethodBeat.o(25125);
      return;
    }
    catch (Exception localException3)
    {
      ab.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 1, 1 Fail: %s", new Object[] { localException3.getMessage() });
      AppMethodBeat.o(25125);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView
 * JD-Core Version:    0.7.0.1
 */