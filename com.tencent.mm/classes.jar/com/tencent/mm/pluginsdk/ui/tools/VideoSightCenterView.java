package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.d;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class VideoSightCenterView
  extends VideoSightView
{
  private int EuH = 0;
  private volatile boolean Yuq = false;
  private MediaMetadataRetriever Yur;
  private boolean isStart = false;
  
  public VideoSightCenterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoSightCenterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void dYi()
  {
    AppMethodBeat.i(116255);
    if ((getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
      localLayoutParams.addRule(13);
      setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(116255);
  }
  
  public final void H(double paramDouble)
  {
    AppMethodBeat.i(116264);
    Log.v("MicroMsg.VideoSightCenterView", "seekTo, time: %s, isStart: %s, currentPosition: %s, getLastProgresstime: %s", new Object[] { Double.valueOf(paramDouble), Boolean.valueOf(this.isStart), Integer.valueOf(this.EuH), Double.valueOf(getLastProgresstime()) });
    if ((this.isStart) && (getLastProgresstime() > 0.0D)) {
      super.H(paramDouble / 1000.0D);
    }
    AppMethodBeat.o(116264);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116259);
    Log.v("MicroMsg.VideoSightCenterView", "getCurrentPosition: %s", new Object[] { Integer.valueOf(this.EuH) });
    int i = this.EuH;
    AppMethodBeat.o(116259);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116258);
    Log.i("MicroMsg.VideoSightCenterView", "getDuration");
    if (!Util.isNullOrNil(this.eDC)) {
      try
      {
        if (this.Yur == null)
        {
          this.Yur = new d();
          this.Yur.setDataSource(this.eDC);
        }
        i = Integer.valueOf(this.Yur.extractMetadata(9)).intValue();
        Log.i("MicroMsg.VideoSightCenterView", "getDuration: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(116258);
        return i;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.VideoSightCenterView", "getDuration error: %s", new Object[] { localException.getMessage() });
      }
    }
    int i = super.getDuration();
    AppMethodBeat.o(116258);
    return i;
  }
  
  public double getLastProgresstime()
  {
    AppMethodBeat.i(116263);
    double d = super.getLastProgresstime();
    AppMethodBeat.o(116263);
    return d;
  }
  
  protected final void init()
  {
    AppMethodBeat.i(116256);
    if (Util.nullAs(af.lYj.lVl, "").equals("other")) {
      Log.i("MicroMsg.VideoSightCenterView", "init::use other player");
    }
    for (;;)
    {
      setOnCompletionListener(new SightPlayController.d()
      {
        public final void c(SightPlayController paramAnonymousSightPlayController, int paramAnonymousInt)
        {
          AppMethodBeat.i(116251);
          if (-1 == paramAnonymousInt)
          {
            Log.i("MicroMsg.VideoSightCenterView", "error stop, isCompletion: %s", new Object[] { Boolean.valueOf(VideoSightCenterView.a(VideoSightCenterView.this)) });
            if ((VideoSightCenterView.this.yki != null) && (!VideoSightCenterView.a(VideoSightCenterView.this)))
            {
              VideoSightCenterView.this.yki.onError(0, 0);
              AppMethodBeat.o(116251);
            }
          }
          else if (paramAnonymousInt == 0)
          {
            Log.i("MicroMsg.VideoSightCenterView", "normal stop");
            VideoSightCenterView.b(VideoSightCenterView.this);
            if (VideoSightCenterView.this.yki != null) {
              VideoSightCenterView.this.yki.onCompletion();
            }
          }
          AppMethodBeat.o(116251);
        }
      });
      AppMethodBeat.o(116256);
      return;
      Dg(true);
    }
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(116265);
    Log.v("MicroMsg.VideoSightCenterView", "isPlaying, isStart: %s, currentPosition: %s", new Object[] { Boolean.valueOf(this.isStart), Integer.valueOf(this.EuH) });
    boolean bool = this.isStart;
    AppMethodBeat.o(116265);
    return bool;
  }
  
  public final void ld(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116254);
    super.ld(paramInt1, paramInt2);
    dYi();
    AppMethodBeat.o(116254);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(116262);
    Log.v("MicroMsg.VideoSightCenterView", "pause");
    super.pause();
    AppMethodBeat.o(116262);
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(116253);
    super.setDrawableWidth(paramInt);
    dYi();
    AppMethodBeat.o(116253);
  }
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(116257);
    if (paramBoolean)
    {
      setOnDecodeDurationListener(new SightPlayController.e()
      {
        public final void b(SightPlayController paramAnonymousSightPlayController, long paramAnonymousLong)
        {
          AppMethodBeat.i(116252);
          if (VideoSightCenterView.this.duration == 0) {
            VideoSightCenterView.this.duration = VideoSightCenterView.this.getDuration();
          }
          if (VideoSightCenterView.this.yki != null)
          {
            Log.v("MicroMsg.VideoSightCenterView", "onPlayTime, currentTime: %s, duration: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(VideoSightCenterView.this.duration) });
            VideoSightCenterView.a(VideoSightCenterView.this, (int)(1000L * paramAnonymousLong));
            VideoSightCenterView.this.yki.gw((int)paramAnonymousLong, VideoSightCenterView.this.duration);
          }
          AppMethodBeat.o(116252);
        }
      });
      AppMethodBeat.o(116257);
      return;
    }
    setOnDecodeDurationListener(null);
    AppMethodBeat.o(116257);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(116260);
    Log.v("MicroMsg.VideoSightCenterView", "start");
    this.isStart = true;
    boolean bool = super.start();
    AppMethodBeat.o(116260);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116261);
    Log.v("MicroMsg.VideoSightCenterView", "stop");
    super.stop();
    this.EuH = 0;
    this.isStart = false;
    AppMethodBeat.o(116261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSightCenterView
 * JD-Core Version:    0.7.0.1
 */