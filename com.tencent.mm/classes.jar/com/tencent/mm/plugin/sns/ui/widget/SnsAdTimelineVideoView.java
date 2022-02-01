package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.sdk.platformtools.ad;

public class SnsAdTimelineVideoView
  extends OfflineVideoView
{
  private boolean ACw;
  public boolean zGF;
  
  public SnsAdTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public SnsAdTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.zTH = false;
  }
  
  public final void QW(int paramInt)
  {
    AppMethodBeat.i(179400);
    super.QW(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("updateVideoUI: thumVis=");
    if (this.rAT.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.SnsAdTimelineVideoView", bool + ", ms=" + paramInt + ", second=" + paramInt / 1000);
      AppMethodBeat.o(179400);
      return;
    }
  }
  
  public final void aB(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(198597);
    super.aB(paramInt, paramBoolean);
    ad.i("MicroMsg.SnsAdTimelineVideoView", "seekTo:" + paramInt + ", afterSeekPlay=" + paramBoolean);
    AppMethodBeat.o(198597);
  }
  
  public final void c(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(179399);
    super.c(paramBoolean, paramFloat);
    StringBuilder localStringBuilder = new StringBuilder("switchVideoModel: thumVis=");
    if (this.rAT.getVisibility() == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ad.i("MicroMsg.SnsAdTimelineVideoView", paramBoolean);
      AppMethodBeat.o(179399);
      return;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179389);
    ad.i("MicroMsg.SnsAdTimelineVideoView", "clear");
    super.onDestroy();
    this.ACw = false;
    this.zTH = false;
    this.zGF = false;
    ad.i("MicroMsg.SnsAdTimelineVideoView", "path after clear=" + getVideoPath());
    AppMethodBeat.o(179389);
  }
  
  public final void eae()
  {
    AppMethodBeat.i(179398);
    super.eae();
    ad.i("MicroMsg.SnsAdTimelineVideoView", "clearTimer");
    AppMethodBeat.o(179398);
  }
  
  public Drawable getThumbDrawable()
  {
    AppMethodBeat.i(179394);
    if (this.rAT != null)
    {
      Drawable localDrawable = this.rAT.getDrawable();
      AppMethodBeat.o(179394);
      return localDrawable;
    }
    AppMethodBeat.o(179394);
    return null;
  }
  
  public final boolean isError()
  {
    AppMethodBeat.i(179395);
    ad.i("MicroMsg.SnsAdTimelineVideoView", "isError=" + this.rFd);
    boolean bool = this.rFd;
    AppMethodBeat.o(179395);
    return bool;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(179396);
    super.onDetachedFromWindow();
    ad.i("MicroMsg.SnsAdTimelineVideoView", "onDetachedFromWindow");
    clear();
    AppMethodBeat.o(179396);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(179385);
    ad.i("MicroMsg.SnsAdTimelineVideoView", "pause");
    super.eaf();
    AppMethodBeat.o(179385);
  }
  
  public final void restart()
  {
    AppMethodBeat.i(179388);
    ad.i("MicroMsg.SnsAdTimelineVideoView", "restart, hasPrepared=" + this.ACw);
    if (this.ACw) {
      super.aB(0, true);
    }
    AppMethodBeat.o(179388);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(179390);
    aB(paramInt, true);
    AppMethodBeat.o(179390);
  }
  
  public void setShouldPlayWhenPrepared(boolean paramBoolean)
  {
    AppMethodBeat.i(179386);
    ad.i("MicroMsg.SnsAdTimelineVideoView", "setShouldPlayWhenPrepared:".concat(String.valueOf(paramBoolean)));
    this.zTH = paramBoolean;
    AppMethodBeat.o(179386);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(179392);
    ad.i("MicroMsg.SnsAdTimelineVideoView", "setThumbBmp=".concat(String.valueOf(paramBitmap)));
    if (this.rAT != null) {
      this.rAT.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(179392);
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(179393);
    ad.i("MicroMsg.SnsAdTimelineVideoView", "setThumbDrawable=".concat(String.valueOf(paramDrawable)));
    if (this.rAT != null) {
      this.rAT.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(179393);
  }
  
  public void setThumpViewScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(198598);
    if (this.rAT != null) {
      this.rAT.setScaleType(paramScaleType);
    }
    AppMethodBeat.o(198598);
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(179391);
    String str = getVideoPath();
    ad.i("MicroMsg.SnsAdTimelineVideoView", "setVideoPath, hasPrepared=" + this.ACw + ", path=" + paramString + ", oldPath=" + str);
    if ((!this.ACw) || ((paramString != null) && (!paramString.equals(str))))
    {
      super.agT(paramString);
      this.ACw = true;
    }
    AppMethodBeat.o(179391);
  }
  
  public final void showLoading() {}
  
  public final void start()
  {
    AppMethodBeat.i(179384);
    boolean bool = eah();
    ad.i("MicroMsg.SnsAdTimelineVideoView", "start, hasPrepared=" + this.zGF + ", shouldPlayWhenPrepared=" + this.zTH + ", isPlaying=" + bool);
    if ((!this.zGF) && (this.zTH))
    {
      AppMethodBeat.o(179384);
      return;
    }
    if (!bool)
    {
      ad.i("MicroMsg.SnsAdTimelineVideoView", "do start");
      super.start();
    }
    AppMethodBeat.o(179384);
  }
  
  public final void startTimer()
  {
    AppMethodBeat.i(179397);
    super.startTimer();
    ad.i("MicroMsg.SnsAdTimelineVideoView", "startTimer:" + getTimerInterval());
    AppMethodBeat.o(179397);
  }
  
  public final void ta()
  {
    AppMethodBeat.i(179387);
    ad.i("MicroMsg.SnsAdTimelineVideoView", "onPrepared, path=%s , shouldPlayWhenPrepared=%s", new Object[] { getVideoPath(), Boolean.valueOf(this.zTH) });
    if (this.zTH) {
      super.ta();
    }
    this.zGF = true;
    AppMethodBeat.o(179387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView
 * JD-Core Version:    0.7.0.1
 */