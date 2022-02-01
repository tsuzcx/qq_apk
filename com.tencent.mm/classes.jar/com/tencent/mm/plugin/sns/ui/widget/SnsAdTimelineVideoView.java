package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.sdk.platformtools.ae;

public class SnsAdTimelineVideoView
  extends OfflineVideoView
{
  private boolean ATX;
  public boolean zXN;
  
  public SnsAdTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public SnsAdTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.AkO = false;
  }
  
  public final void RD(int paramInt)
  {
    AppMethodBeat.i(179400);
    super.RD(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("updateVideoUI: thumVis=");
    if (this.rJe.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d("MicroMsg.SnsAdTimelineVideoView", bool + ", ms=" + paramInt + ", second=" + paramInt / 1000);
      AppMethodBeat.o(179400);
      return;
    }
  }
  
  public final void aE(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(220144);
    super.aE(paramInt, paramBoolean);
    ae.i("MicroMsg.SnsAdTimelineVideoView", "seekTo:" + paramInt + ", afterSeekPlay=" + paramBoolean);
    AppMethodBeat.o(220144);
  }
  
  public final void c(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(179399);
    super.c(paramBoolean, paramFloat);
    StringBuilder localStringBuilder = new StringBuilder("switchVideoModel: thumVis=");
    if (this.rJe.getVisibility() == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ae.i("MicroMsg.SnsAdTimelineVideoView", paramBoolean);
      AppMethodBeat.o(179399);
      return;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179389);
    ae.i("MicroMsg.SnsAdTimelineVideoView", "clear");
    super.onDestroy();
    this.ATX = false;
    this.AkO = false;
    this.zXN = false;
    ae.i("MicroMsg.SnsAdTimelineVideoView", "path after clear=" + getVideoPath());
    AppMethodBeat.o(179389);
  }
  
  public final void edK()
  {
    AppMethodBeat.i(179398);
    super.edK();
    ae.i("MicroMsg.SnsAdTimelineVideoView", "clearTimer");
    AppMethodBeat.o(179398);
  }
  
  public Drawable getThumbDrawable()
  {
    AppMethodBeat.i(179394);
    if (this.rJe != null)
    {
      Drawable localDrawable = this.rJe.getDrawable();
      AppMethodBeat.o(179394);
      return localDrawable;
    }
    AppMethodBeat.o(179394);
    return null;
  }
  
  public final boolean isError()
  {
    AppMethodBeat.i(179395);
    ae.i("MicroMsg.SnsAdTimelineVideoView", "isError=" + this.rNo);
    boolean bool = this.rNo;
    AppMethodBeat.o(179395);
    return bool;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(179396);
    super.onDetachedFromWindow();
    ae.i("MicroMsg.SnsAdTimelineVideoView", "onDetachedFromWindow");
    clear();
    AppMethodBeat.o(179396);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(179385);
    ae.i("MicroMsg.SnsAdTimelineVideoView", "pause");
    super.edL();
    AppMethodBeat.o(179385);
  }
  
  public final void restart()
  {
    AppMethodBeat.i(179388);
    ae.i("MicroMsg.SnsAdTimelineVideoView", "restart, hasPrepared=" + this.ATX);
    if (this.ATX) {
      super.aE(0, true);
    }
    AppMethodBeat.o(179388);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(179390);
    aE(paramInt, true);
    AppMethodBeat.o(179390);
  }
  
  public void setShouldPlayWhenPrepared(boolean paramBoolean)
  {
    AppMethodBeat.i(179386);
    ae.i("MicroMsg.SnsAdTimelineVideoView", "setShouldPlayWhenPrepared:".concat(String.valueOf(paramBoolean)));
    this.AkO = paramBoolean;
    AppMethodBeat.o(179386);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(179392);
    ae.i("MicroMsg.SnsAdTimelineVideoView", "setThumbBmp=".concat(String.valueOf(paramBitmap)));
    if (this.rJe != null) {
      this.rJe.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(179392);
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(179393);
    ae.i("MicroMsg.SnsAdTimelineVideoView", "setThumbDrawable=".concat(String.valueOf(paramDrawable)));
    if (this.rJe != null) {
      this.rJe.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(179393);
  }
  
  public void setThumpViewScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(220145);
    if (this.rJe != null) {
      this.rJe.setScaleType(paramScaleType);
    }
    AppMethodBeat.o(220145);
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(179391);
    String str = getVideoPath();
    ae.i("MicroMsg.SnsAdTimelineVideoView", "setVideoPath, hasPrepared=" + this.ATX + ", path=" + paramString + ", oldPath=" + str);
    if ((!this.ATX) || ((paramString != null) && (!paramString.equals(str))))
    {
      super.ahQ(paramString);
      this.ATX = true;
    }
    AppMethodBeat.o(179391);
  }
  
  public final void showLoading() {}
  
  public final void start()
  {
    AppMethodBeat.i(179384);
    boolean bool = edN();
    ae.i("MicroMsg.SnsAdTimelineVideoView", "start, hasPrepared=" + this.zXN + ", shouldPlayWhenPrepared=" + this.AkO + ", isPlaying=" + bool);
    if ((!this.zXN) && (this.AkO))
    {
      AppMethodBeat.o(179384);
      return;
    }
    if (!bool)
    {
      ae.i("MicroMsg.SnsAdTimelineVideoView", "do start");
      super.start();
    }
    AppMethodBeat.o(179384);
  }
  
  public final void startTimer()
  {
    AppMethodBeat.i(179397);
    super.startTimer();
    ae.i("MicroMsg.SnsAdTimelineVideoView", "startTimer:" + getTimerInterval());
    AppMethodBeat.o(179397);
  }
  
  public final void ta()
  {
    AppMethodBeat.i(179387);
    ae.i("MicroMsg.SnsAdTimelineVideoView", "onPrepared, path=%s , shouldPlayWhenPrepared=%s", new Object[] { getVideoPath(), Boolean.valueOf(this.AkO) });
    if (this.AkO) {
      super.ta();
    }
    this.zXN = true;
    AppMethodBeat.o(179387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView
 * JD-Core Version:    0.7.0.1
 */