package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdTimelineVideoView
  extends OfflineVideoView
{
  private boolean FeD;
  public boolean vbV;
  
  public SnsAdTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public SnsAdTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.EtA = false;
  }
  
  public final void Zz(int paramInt)
  {
    AppMethodBeat.i(179400);
    super.Zz(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("updateVideoUI: thumVis=");
    if (this.tiQ.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.SnsAdTimelineVideoView", bool + ", ms=" + paramInt + ", second=" + paramInt / 1000);
      AppMethodBeat.o(179400);
      return;
    }
  }
  
  public final void aT(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(203988);
    super.aT(paramInt, paramBoolean);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "seekTo:" + paramInt + ", afterSeekPlay=" + paramBoolean);
    AppMethodBeat.o(203988);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179389);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "clear");
    super.onDestroy();
    this.FeD = false;
    this.EtA = false;
    this.vbV = false;
    Log.i("MicroMsg.SnsAdTimelineVideoView", "path after clear=" + getVideoPath());
    AppMethodBeat.o(179389);
  }
  
  public final void d(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(179399);
    super.d(paramBoolean, paramFloat);
    StringBuilder localStringBuilder = new StringBuilder("switchVideoModel: thumVis=");
    if (this.tiQ.getVisibility() == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.i("MicroMsg.SnsAdTimelineVideoView", paramBoolean);
      AppMethodBeat.o(179399);
      return;
    }
  }
  
  public final void fgc()
  {
    AppMethodBeat.i(179398);
    super.fgc();
    Log.i("MicroMsg.SnsAdTimelineVideoView", "clearTimer");
    AppMethodBeat.o(179398);
  }
  
  public Drawable getThumbDrawable()
  {
    AppMethodBeat.i(179394);
    if (this.tiQ != null)
    {
      Drawable localDrawable = this.tiQ.getDrawable();
      AppMethodBeat.o(179394);
      return localDrawable;
    }
    AppMethodBeat.o(179394);
    return null;
  }
  
  public final boolean isError()
  {
    AppMethodBeat.i(179395);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "isError=" + this.tmZ);
    boolean bool = this.tmZ;
    AppMethodBeat.o(179395);
    return bool;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(179396);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.SnsAdTimelineVideoView", "onDetachedFromWindow");
    clear();
    AppMethodBeat.o(179396);
  }
  
  public final void onError(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203990);
    super.onError(paramInt1, paramInt2);
    h.CyF.dN(1579, 7);
    AppMethodBeat.o(203990);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(179385);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "pause");
    super.fgd();
    AppMethodBeat.o(179385);
  }
  
  public final void restart()
  {
    AppMethodBeat.i(179388);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "restart, hasPrepared=" + this.FeD);
    if (this.FeD) {
      super.aT(0, true);
    }
    AppMethodBeat.o(179388);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(179390);
    aT(paramInt, true);
    AppMethodBeat.o(179390);
  }
  
  public void setShouldPlayWhenPrepared(boolean paramBoolean)
  {
    AppMethodBeat.i(179386);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "setShouldPlayWhenPrepared:".concat(String.valueOf(paramBoolean)));
    this.EtA = paramBoolean;
    AppMethodBeat.o(179386);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(179392);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "setThumbBmp=".concat(String.valueOf(paramBitmap)));
    if (this.tiQ != null) {
      this.tiQ.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(179392);
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(179393);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "setThumbDrawable=".concat(String.valueOf(paramDrawable)));
    if (this.tiQ != null) {
      this.tiQ.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(179393);
  }
  
  public void setThumpViewScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(203989);
    if (this.tiQ != null) {
      this.tiQ.setScaleType(paramScaleType);
    }
    AppMethodBeat.o(203989);
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(179391);
    String str = getVideoPath();
    Log.i("MicroMsg.SnsAdTimelineVideoView", "setVideoPath, hasPrepared=" + this.FeD + ", path=" + paramString + ", oldPath=" + str);
    if ((!this.FeD) || ((paramString != null) && (!paramString.equals(str))))
    {
      super.asy(paramString);
      this.FeD = true;
    }
    AppMethodBeat.o(179391);
  }
  
  public final void showLoading() {}
  
  public final void start()
  {
    AppMethodBeat.i(179384);
    boolean bool = fgf();
    Log.i("MicroMsg.SnsAdTimelineVideoView", "start, hasPrepared=" + this.vbV + ", shouldPlayWhenPrepared=" + this.EtA + ", isPlaying=" + bool);
    if ((!this.vbV) && (this.EtA))
    {
      AppMethodBeat.o(179384);
      return;
    }
    if (!bool)
    {
      Log.i("MicroMsg.SnsAdTimelineVideoView", "do start");
      super.start();
    }
    AppMethodBeat.o(179384);
  }
  
  public final void startTimer()
  {
    AppMethodBeat.i(179397);
    super.startTimer();
    Log.i("MicroMsg.SnsAdTimelineVideoView", "startTimer:" + getTimerInterval());
    AppMethodBeat.o(179397);
  }
  
  public final void tf()
  {
    AppMethodBeat.i(179387);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "onPrepared, path=%s , shouldPlayWhenPrepared=%s", new Object[] { getVideoPath(), Boolean.valueOf(this.EtA) });
    if (this.EtA) {
      super.tf();
    }
    this.vbV = true;
    AppMethodBeat.o(179387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView
 * JD-Core Version:    0.7.0.1
 */