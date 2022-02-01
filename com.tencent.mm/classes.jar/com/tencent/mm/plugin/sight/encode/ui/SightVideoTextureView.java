package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;

public class SightVideoTextureView
  extends SightCameraView
{
  private SurfaceTexture PJG;
  private Surface PJH;
  private boolean PJI;
  private String eDC;
  private TextureView eDa;
  private boolean mMute;
  private MediaPlayer sFf;
  
  public SightVideoTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SightVideoTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28799);
    this.eDa = null;
    this.PJG = null;
    this.PJH = null;
    this.eDa = ((TextureView)findViewById(R.h.fYv));
    this.eDa.setSurfaceTextureListener(new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(28790);
        Log.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureAvailable, [%d, %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        SightVideoTextureView.this.PJs = SightCameraView.b.PJC;
        SightVideoTextureView.a(SightVideoTextureView.this, paramAnonymousSurfaceTexture);
        ((MMTextureView)SightVideoTextureView.a(SightVideoTextureView.this)).jmM();
        Log.i("MicroMsg.SightVideoTextureView", "available texture %s, wantPlay %B", new Object[] { paramAnonymousSurfaceTexture, Boolean.valueOf(SightVideoTextureView.b(SightVideoTextureView.this)) });
        if (SightVideoTextureView.b(SightVideoTextureView.this)) {
          SightVideoTextureView.this.cN(SightVideoTextureView.c(SightVideoTextureView.this), SightVideoTextureView.d(SightVideoTextureView.this));
        }
        AppMethodBeat.o(28790);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(28792);
        Log.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureDestroyed");
        SightVideoTextureView.this.PJs = SightCameraView.b.PJE;
        SightVideoTextureView.a(SightVideoTextureView.this, null);
        SightVideoTextureView.this.PJu = false;
        Log.i("MicroMsg.SightVideoTextureView", "destroyed texture %s", new Object[] { paramAnonymousSurfaceTexture });
        AppMethodBeat.o(28792);
        return true;
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(28791);
        Log.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureSizeChanged, [%d, %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        SightVideoTextureView.this.PJs = SightCameraView.b.PJD;
        Log.i("MicroMsg.SightVideoTextureView", "changed texture %s", new Object[] { paramAnonymousSurfaceTexture });
        AppMethodBeat.o(28791);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    });
    AppMethodBeat.o(28799);
  }
  
  public final void cN(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(28801);
    Log.i("MicroMsg.SightVideoTextureView", "start play video, path %s, mute %B, wantPlay %B", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(this.PJI) });
    this.eDC = paramString;
    this.mMute = paramBoolean;
    if (this.PJG == null)
    {
      Log.w("MicroMsg.SightVideoTextureView", "play video fail, texture is null");
      this.PJI = true;
      AppMethodBeat.o(28801);
      return;
    }
    this.PJI = false;
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28795);
        if (SightVideoTextureView.e(SightVideoTextureView.this) != null) {}
        try
        {
          SightVideoTextureView.e(SightVideoTextureView.this).stop();
          SightVideoTextureView.e(SightVideoTextureView.this).release();
        }
        catch (Exception localException1)
        {
          try
          {
            SightVideoTextureView.a(SightVideoTextureView.this, new k());
            SightVideoTextureView.e(SightVideoTextureView.this).setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
              public final void onCompletion(MediaPlayer paramAnonymous2MediaPlayer)
              {
                AppMethodBeat.i(28793);
                Log.i("MicroMsg.SightVideoTextureView", "complete playing %s ", new Object[] { SightVideoTextureView.2.this.PJK });
                SightVideoTextureView.this.gZp();
                AppMethodBeat.o(28793);
              }
            });
            SightVideoTextureView.e(SightVideoTextureView.this).setOnErrorListener(new MediaPlayer.OnErrorListener()
            {
              public final boolean onError(MediaPlayer paramAnonymous2MediaPlayer, int paramAnonymous2Int1, int paramAnonymous2Int2)
              {
                AppMethodBeat.i(28794);
                Log.i("MicroMsg.SightVideoTextureView", "play %s error", new Object[] { SightVideoTextureView.2.this.PJK });
                AppMethodBeat.o(28794);
                return false;
              }
            });
            SightVideoTextureView.e(SightVideoTextureView.this).setDataSource(paramString);
            SightVideoTextureView.a(SightVideoTextureView.this, SightVideoTextureView.this.getPreviewSurface());
            SightVideoTextureView.e(SightVideoTextureView.this).setSurface(SightVideoTextureView.f(SightVideoTextureView.this));
            SightVideoTextureView.e(SightVideoTextureView.this).setAudioStreamType(3);
            if (paramBoolean) {
              SightVideoTextureView.e(SightVideoTextureView.this).setVolume(0.0F, 0.0F);
            }
            for (;;)
            {
              SightVideoTextureView.e(SightVideoTextureView.this).setScreenOnWhilePlaying(true);
              SightVideoTextureView.e(SightVideoTextureView.this).setLooping(true);
              SightVideoTextureView.e(SightVideoTextureView.this).prepare();
              SightVideoTextureView.e(SightVideoTextureView.this).start();
              AppMethodBeat.o(28795);
              return;
              localException1 = localException1;
              Log.printErrStackTrace("MicroMsg.SightVideoTextureView", localException1, "", new Object[0]);
              Log.w("MicroMsg.SightVideoTextureView", "try to release mediaplayer error");
              break;
              SightVideoTextureView.this.bUf();
            }
            return;
          }
          catch (Exception localException2)
          {
            Log.e("MicroMsg.SightVideoTextureView", "play %s, error: %s, %s", new Object[] { paramString, localException2.getMessage(), Util.stackTraceToString(localException2) });
            AppMethodBeat.o(28795);
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(28796);
        String str = super.toString() + "|playVideo";
        AppMethodBeat.o(28796);
        return str;
      }
    });
    AppMethodBeat.o(28801);
  }
  
  public final void gZn()
  {
    AppMethodBeat.i(28803);
    Log.i("MicroMsg.SightVideoTextureView", "stop play video, wantPlay %B", new Object[] { Boolean.valueOf(this.PJI) });
    if ((this.sFf == null) && (!this.PJI))
    {
      Log.w("MicroMsg.SightVideoTextureView", "mediaplayer is null, do nothing when stop play video");
      AppMethodBeat.o(28803);
      return;
    }
    bh.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28797);
        try
        {
          SightVideoTextureView.this.gZp();
          SightVideoTextureView.e(SightVideoTextureView.this).stop();
          SightVideoTextureView.e(SightVideoTextureView.this).release();
          if ((SightVideoTextureView.f(SightVideoTextureView.this) != null) && (SightVideoTextureView.f(SightVideoTextureView.this).isValid()))
          {
            SightVideoTextureView.f(SightVideoTextureView.this).release();
            SightVideoTextureView.a(SightVideoTextureView.this, null);
          }
          SightVideoTextureView.a(SightVideoTextureView.this, null);
          AppMethodBeat.o(28797);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.w("MicroMsg.SightVideoTextureView", "stop play video error: %s, %s", new Object[] { localException.getMessage(), Util.stackTraceToString(localException) });
          }
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(28798);
        String str = super.toString() + "|stopPlayVideo";
        AppMethodBeat.o(28798);
        return str;
      }
    });
    AppMethodBeat.o(28803);
  }
  
  protected Surface getPreviewSurface()
  {
    AppMethodBeat.i(28806);
    if (this.PJG != null)
    {
      Surface localSurface = new Surface(this.PJG);
      AppMethodBeat.o(28806);
      return localSurface;
    }
    AppMethodBeat.o(28806);
    return null;
  }
  
  protected int getSurfaceHeight()
  {
    AppMethodBeat.i(28805);
    if (this.eDa != null)
    {
      int i = this.eDa.getHeight();
      AppMethodBeat.o(28805);
      return i;
    }
    AppMethodBeat.o(28805);
    return 0;
  }
  
  protected int getSurfaceWidth()
  {
    AppMethodBeat.i(28804);
    if (this.eDa != null)
    {
      int i = this.eDa.getWidth();
      AppMethodBeat.o(28804);
      return i;
    }
    AppMethodBeat.o(28804);
    return 0;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(28802);
    try
    {
      if (this.sFf == null)
      {
        AppMethodBeat.o(28802);
        return false;
      }
      boolean bool = this.sFf.isPlaying();
      AppMethodBeat.o(28802);
      return bool;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SightVideoTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(28802);
    }
    return false;
  }
  
  public void setFixPreviewRate(float paramFloat)
  {
    AppMethodBeat.i(28807);
    ViewGroup.LayoutParams localLayoutParams = this.eDa.getLayoutParams();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    Log.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate [%f], dm[%d, %d]", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localDisplayMetrics.heightPixels) });
    localLayoutParams.width = localDisplayMetrics.widthPixels;
    localLayoutParams.height = ((int)(localDisplayMetrics.widthPixels / paramFloat));
    Log.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate width:%d, height:%d", new Object[] { Integer.valueOf(localLayoutParams.width), Integer.valueOf(localLayoutParams.height) });
    this.eDa.setLayoutParams(localLayoutParams);
    super.setPreviewRate(paramFloat);
    AppMethodBeat.o(28807);
  }
  
  protected void setIsMute(boolean paramBoolean)
  {
    AppMethodBeat.i(28800);
    if (this.sFf == null)
    {
      AppMethodBeat.o(28800);
      return;
    }
    try
    {
      boolean bool = this.sFf.isPlaying();
      if (!bool)
      {
        AppMethodBeat.o(28800);
        return;
      }
    }
    catch (Exception localException1)
    {
      Log.w("MicroMsg.SightVideoTextureView", "setIsMute %B, check MediaPlayer playing Fail: %s", new Object[] { Boolean.valueOf(paramBoolean), localException1.getMessage() });
      AppMethodBeat.o(28800);
      return;
    }
    if (paramBoolean) {
      try
      {
        this.sFf.setVolume(0.0F, 0.0F);
        AppMethodBeat.o(28800);
        return;
      }
      catch (Exception localException2)
      {
        Log.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 0, 0 Fail: %s", new Object[] { localException2.getMessage() });
        AppMethodBeat.o(28800);
        return;
      }
    }
    bUf();
    try
    {
      this.sFf.setVolume(1.0F, 1.0F);
      AppMethodBeat.o(28800);
      return;
    }
    catch (Exception localException3)
    {
      Log.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 1, 1 Fail: %s", new Object[] { localException3.getMessage() });
      AppMethodBeat.o(28800);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.SightVideoTextureView
 * JD-Core Version:    0.7.0.1
 */