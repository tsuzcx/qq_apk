package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.bu;

public class VideoSightCenterView
  extends VideoSightView
{
  private MediaMetadataRetriever FDA;
  private volatile boolean FDz = false;
  private boolean isStart = false;
  private int vFD = 0;
  
  public VideoSightCenterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoSightCenterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void bTA()
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
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116259);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoSightCenterView", "getCurrentPosition: %s", new Object[] { Integer.valueOf(this.vFD) });
    int i = this.vFD;
    AppMethodBeat.o(116259);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116258);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSightCenterView", "getDuration");
    if (!bu.isNullOrNil(this.cvr)) {
      try
      {
        if (this.FDA == null)
        {
          this.FDA = new d();
          this.FDA.setDataSource(this.cvr);
        }
        i = Integer.valueOf(this.FDA.extractMetadata(9)).intValue();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSightCenterView", "getDuration: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(116258);
        return i;
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoSightCenterView", "getDuration error: %s", new Object[] { localException.getMessage() });
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
  
  public final void hy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116254);
    super.hy(paramInt1, paramInt2);
    bTA();
    AppMethodBeat.o(116254);
  }
  
  protected final void init()
  {
    AppMethodBeat.i(116256);
    if (bu.bI(com.tencent.mm.compatible.deviceinfo.ae.geX.gcg, "").equals("other")) {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSightCenterView", "init::use other player");
    }
    for (;;)
    {
      setOnCompletionListener(new b.e()
      {
        public final void c(b paramAnonymousb, int paramAnonymousInt)
        {
          AppMethodBeat.i(116251);
          if (-1 == paramAnonymousInt)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSightCenterView", "error stop, isCompletion: %s", new Object[] { Boolean.valueOf(VideoSightCenterView.a(VideoSightCenterView.this)) });
            if ((VideoSightCenterView.this.qbr != null) && (!VideoSightCenterView.a(VideoSightCenterView.this)))
            {
              VideoSightCenterView.this.qbr.onError(0, 0);
              AppMethodBeat.o(116251);
            }
          }
          else if (paramAnonymousInt == 0)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSightCenterView", "normal stop");
            VideoSightCenterView.b(VideoSightCenterView.this);
            if (VideoSightCenterView.this.qbr != null) {
              VideoSightCenterView.this.qbr.onCompletion();
            }
          }
          AppMethodBeat.o(116251);
        }
      });
      AppMethodBeat.o(116256);
      return;
      ri(true);
    }
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(116265);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoSightCenterView", "isPlaying, isStart: %s, currentPosition: %s", new Object[] { Boolean.valueOf(this.isStart), Integer.valueOf(this.vFD) });
    boolean bool = this.isStart;
    AppMethodBeat.o(116265);
    return bool;
  }
  
  public final void p(double paramDouble)
  {
    AppMethodBeat.i(116264);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoSightCenterView", "seekTo, time: %s, isStart: %s, currentPosition: %s, getLastProgresstime: %s", new Object[] { Double.valueOf(paramDouble), Boolean.valueOf(this.isStart), Integer.valueOf(this.vFD), Double.valueOf(getLastProgresstime()) });
    if ((this.isStart) && (getLastProgresstime() > 0.0D)) {
      super.p(paramDouble / 1000.0D);
    }
    AppMethodBeat.o(116264);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(116262);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoSightCenterView", "pause");
    super.pause();
    AppMethodBeat.o(116262);
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(116253);
    super.setDrawableWidth(paramInt);
    bTA();
    AppMethodBeat.o(116253);
  }
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(116257);
    if (paramBoolean)
    {
      setOnDecodeDurationListener(new b.f()
      {
        public final void b(b paramAnonymousb, long paramAnonymousLong)
        {
          AppMethodBeat.i(116252);
          if (VideoSightCenterView.this.duration == 0) {
            VideoSightCenterView.this.duration = VideoSightCenterView.this.getDuration();
          }
          if (VideoSightCenterView.this.qbr != null)
          {
            com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoSightCenterView", "onPlayTime, currentTime: %s, duration: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(VideoSightCenterView.this.duration) });
            VideoSightCenterView.a(VideoSightCenterView.this, (int)(1000L * paramAnonymousLong));
            VideoSightCenterView.this.qbr.eU((int)paramAnonymousLong, VideoSightCenterView.this.duration);
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
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoSightCenterView", "start");
    this.isStart = true;
    boolean bool = super.start();
    AppMethodBeat.o(116260);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116261);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.VideoSightCenterView", "stop");
    super.stop();
    this.vFD = 0;
    this.isStart = false;
    AppMethodBeat.o(116261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSightCenterView
 * JD-Core Version:    0.7.0.1
 */