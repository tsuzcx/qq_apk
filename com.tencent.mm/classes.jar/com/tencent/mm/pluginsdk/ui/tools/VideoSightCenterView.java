package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class VideoSightCenterView
  extends VideoSightView
{
  private boolean bSr = false;
  private int oGy = 0;
  private volatile boolean snn = false;
  private MediaMetadataRetriever sno;
  
  public VideoSightCenterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoSightCenterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cor()
  {
    if ((getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
      localLayoutParams.addRule(13);
      setLayoutParams(localLayoutParams);
    }
  }
  
  public final void dL(int paramInt1, int paramInt2)
  {
    super.dL(paramInt1, paramInt2);
    cor();
  }
  
  public int getCurrentPosition()
  {
    y.v("MicroMsg.VideoSightCenterView", "getCurrentPosition: %s", new Object[] { Integer.valueOf(this.oGy) });
    return this.oGy;
  }
  
  public int getDuration()
  {
    y.i("MicroMsg.VideoSightCenterView", "getDuration");
    if (!bk.bl(this.oep)) {
      try
      {
        if (this.sno == null)
        {
          this.sno = new MediaMetadataRetriever();
          this.sno.setDataSource(this.oep);
        }
        int i = Integer.valueOf(this.sno.extractMetadata(9)).intValue();
        y.i("MicroMsg.VideoSightCenterView", "getDuration: %s", new Object[] { Integer.valueOf(i) });
        return i;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.VideoSightCenterView", "getDuration error: %s", new Object[] { localException.getMessage() });
      }
    }
    return super.getDuration();
  }
  
  public double getLastProgresstime()
  {
    return super.getLastProgresstime();
  }
  
  protected final void init()
  {
    if (bk.aM(q.dyn.dxD, "").equals("other")) {
      y.i("MicroMsg.VideoSightCenterView", "init::use other player");
    }
    for (;;)
    {
      setOnCompletionListener(new VideoSightCenterView.1(this));
      return;
      iO(true);
    }
  }
  
  public final boolean isPlaying()
  {
    y.v("MicroMsg.VideoSightCenterView", "isPlaying, isStart: %s, currentPosition: %s", new Object[] { Boolean.valueOf(this.bSr), Integer.valueOf(this.oGy) });
    return this.bSr;
  }
  
  public final void pause()
  {
    y.v("MicroMsg.VideoSightCenterView", "pause");
    super.pause();
  }
  
  public void setDrawableWidth(int paramInt)
  {
    super.setDrawableWidth(paramInt);
    cor();
  }
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setOnDecodeDurationListener(new b.f()
      {
        public final void b(b paramAnonymousb, long paramAnonymousLong)
        {
          if (VideoSightCenterView.this.duration == 0) {
            VideoSightCenterView.this.duration = VideoSightCenterView.this.getDuration();
          }
          if (VideoSightCenterView.this.joM != null)
          {
            y.v("MicroMsg.VideoSightCenterView", "onPlayTime, currentTime: %s, duration: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(VideoSightCenterView.this.duration) });
            VideoSightCenterView.a(VideoSightCenterView.this, (int)(1000L * paramAnonymousLong));
            VideoSightCenterView.this.joM.cv((int)paramAnonymousLong, VideoSightCenterView.this.duration);
          }
        }
      });
      return;
    }
    setOnDecodeDurationListener(null);
  }
  
  public final boolean start()
  {
    y.v("MicroMsg.VideoSightCenterView", "start");
    this.bSr = true;
    return super.start();
  }
  
  public final void stop()
  {
    y.v("MicroMsg.VideoSightCenterView", "stop");
    super.stop();
    this.oGy = 0;
    this.bSr = false;
  }
  
  public final void x(double paramDouble)
  {
    y.v("MicroMsg.VideoSightCenterView", "seekTo, time: %s, isStart: %s, currentPosition: %s, getLastProgresstime: %s", new Object[] { Double.valueOf(paramDouble), Boolean.valueOf(this.bSr), Integer.valueOf(this.oGy), Double.valueOf(getLastProgresstime()) });
    if ((this.bSr) && (getLastProgresstime() > 0.0D)) {
      super.x(paramDouble / 1000.0D);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSightCenterView
 * JD-Core Version:    0.7.0.1
 */