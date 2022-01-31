package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class VideoSightCenterView
  extends VideoSightView
{
  private boolean isStart = false;
  private int rwn = 0;
  private volatile boolean wfI = false;
  private MediaMetadataRetriever wfJ;
  
  public VideoSightCenterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoSightCenterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void dpH()
  {
    AppMethodBeat.i(70401);
    if ((getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
      localLayoutParams.addRule(13);
      setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(70401);
  }
  
  public final void A(double paramDouble)
  {
    AppMethodBeat.i(70410);
    ab.v("MicroMsg.VideoSightCenterView", "seekTo, time: %s, isStart: %s, currentPosition: %s, getLastProgresstime: %s", new Object[] { Double.valueOf(paramDouble), Boolean.valueOf(this.isStart), Integer.valueOf(this.rwn), Double.valueOf(getLastProgresstime()) });
    if ((this.isStart) && (getLastProgresstime() > 0.0D)) {
      super.A(paramDouble / 1000.0D);
    }
    AppMethodBeat.o(70410);
  }
  
  public final void ft(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70400);
    super.ft(paramInt1, paramInt2);
    dpH();
    AppMethodBeat.o(70400);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(70405);
    ab.v("MicroMsg.VideoSightCenterView", "getCurrentPosition: %s", new Object[] { Integer.valueOf(this.rwn) });
    int i = this.rwn;
    AppMethodBeat.o(70405);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(70404);
    ab.i("MicroMsg.VideoSightCenterView", "getDuration");
    if (!bo.isNullOrNil(this.bHM)) {
      try
      {
        if (this.wfJ == null)
        {
          this.wfJ = new MediaMetadataRetriever();
          this.wfJ.setDataSource(this.bHM);
        }
        i = Integer.valueOf(this.wfJ.extractMetadata(9)).intValue();
        ab.i("MicroMsg.VideoSightCenterView", "getDuration: %s", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(70404);
        return i;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.VideoSightCenterView", "getDuration error: %s", new Object[] { localException.getMessage() });
      }
    }
    int i = super.getDuration();
    AppMethodBeat.o(70404);
    return i;
  }
  
  public double getLastProgresstime()
  {
    AppMethodBeat.i(70409);
    double d = super.getLastProgresstime();
    AppMethodBeat.o(70409);
    return d;
  }
  
  protected final void init()
  {
    AppMethodBeat.i(70402);
    if (bo.bf(ac.erF.epB, "").equals("other")) {
      ab.i("MicroMsg.VideoSightCenterView", "init::use other player");
    }
    for (;;)
    {
      setOnCompletionListener(new VideoSightCenterView.1(this));
      AppMethodBeat.o(70402);
      return;
      kS(true);
    }
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(70411);
    ab.v("MicroMsg.VideoSightCenterView", "isPlaying, isStart: %s, currentPosition: %s", new Object[] { Boolean.valueOf(this.isStart), Integer.valueOf(this.rwn) });
    boolean bool = this.isStart;
    AppMethodBeat.o(70411);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(70408);
    ab.v("MicroMsg.VideoSightCenterView", "pause");
    super.pause();
    AppMethodBeat.o(70408);
  }
  
  public void setDrawableWidth(int paramInt)
  {
    AppMethodBeat.i(70399);
    super.setDrawableWidth(paramInt);
    dpH();
    AppMethodBeat.o(70399);
  }
  
  public void setPlayProgressCallback(boolean paramBoolean)
  {
    AppMethodBeat.i(70403);
    if (paramBoolean)
    {
      setOnDecodeDurationListener(new b.f()
      {
        public final void b(b paramAnonymousb, long paramAnonymousLong)
        {
          AppMethodBeat.i(70398);
          if (VideoSightCenterView.this.duration == 0) {
            VideoSightCenterView.this.duration = VideoSightCenterView.this.getDuration();
          }
          if (VideoSightCenterView.this.lxA != null)
          {
            ab.v("MicroMsg.VideoSightCenterView", "onPlayTime, currentTime: %s, duration: %s", new Object[] { Long.valueOf(paramAnonymousLong), Integer.valueOf(VideoSightCenterView.this.duration) });
            VideoSightCenterView.a(VideoSightCenterView.this, (int)(1000L * paramAnonymousLong));
            VideoSightCenterView.this.lxA.dP((int)paramAnonymousLong, VideoSightCenterView.this.duration);
          }
          AppMethodBeat.o(70398);
        }
      });
      AppMethodBeat.o(70403);
      return;
    }
    setOnDecodeDurationListener(null);
    AppMethodBeat.o(70403);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(70406);
    ab.v("MicroMsg.VideoSightCenterView", "start");
    this.isStart = true;
    boolean bool = super.start();
    AppMethodBeat.o(70406);
    return bool;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(70407);
    ab.v("MicroMsg.VideoSightCenterView", "stop");
    super.stop();
    this.rwn = 0;
    this.isStart = false;
    AppMethodBeat.o(70407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSightCenterView
 * JD-Core Version:    0.7.0.1
 */