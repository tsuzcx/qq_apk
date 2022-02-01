package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.sdk.platformtools.ac;

public class SnsAdTimelineVideoView
  extends OfflineVideoView
{
  private boolean ypD;
  private boolean zky;
  
  public SnsAdTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public SnsAdTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.yCn = false;
  }
  
  public final void Po(int paramInt)
  {
    AppMethodBeat.i(179400);
    super.Po(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("updateVideoUI: thumVis=");
    if (this.qQT.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.SnsAdTimelineVideoView", bool + ", ms=" + paramInt + ", second=" + paramInt / 1000);
      AppMethodBeat.o(179400);
      return;
    }
  }
  
  public final void aw(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(200662);
    super.aw(paramInt, paramBoolean);
    ac.i("MicroMsg.SnsAdTimelineVideoView", "seekTo:" + paramInt + ", afterSeekPlay=" + paramBoolean);
    AppMethodBeat.o(200662);
  }
  
  public final void c(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(179399);
    super.c(paramBoolean, paramFloat);
    StringBuilder localStringBuilder = new StringBuilder("switchVideoModel: thumVis=");
    if (this.qQT.getVisibility() == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ac.i("MicroMsg.SnsAdTimelineVideoView", paramBoolean);
      AppMethodBeat.o(179399);
      return;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179389);
    ac.i("MicroMsg.SnsAdTimelineVideoView", "clear");
    super.onDestroy();
    this.zky = false;
    this.yCn = false;
    this.ypD = false;
    ac.i("MicroMsg.SnsAdTimelineVideoView", "path after clear=" + getVideoPath());
    AppMethodBeat.o(179389);
  }
  
  public final void dNR()
  {
    AppMethodBeat.i(179398);
    super.dNR();
    ac.i("MicroMsg.SnsAdTimelineVideoView", "clearTimer");
    AppMethodBeat.o(179398);
  }
  
  public Drawable getThumbDrawable()
  {
    AppMethodBeat.i(179394);
    if (this.qQT != null)
    {
      Drawable localDrawable = this.qQT.getDrawable();
      AppMethodBeat.o(179394);
      return localDrawable;
    }
    AppMethodBeat.o(179394);
    return null;
  }
  
  public final boolean isError()
  {
    AppMethodBeat.i(179395);
    ac.i("MicroMsg.SnsAdTimelineVideoView", "isError=" + this.qUP);
    boolean bool = this.qUP;
    AppMethodBeat.o(179395);
    return bool;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(179396);
    super.onDetachedFromWindow();
    ac.i("MicroMsg.SnsAdTimelineVideoView", "onDetachedFromWindow");
    clear();
    AppMethodBeat.o(179396);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(179385);
    ac.i("MicroMsg.SnsAdTimelineVideoView", "pause");
    super.dNS();
    AppMethodBeat.o(179385);
  }
  
  public final void rB()
  {
    AppMethodBeat.i(179387);
    ac.i("MicroMsg.SnsAdTimelineVideoView", "onPrepared, path=%s , shouldPlayWhenPrepared=%s", new Object[] { getVideoPath(), Boolean.valueOf(this.yCn) });
    if (this.yCn) {
      super.rB();
    }
    this.ypD = true;
    AppMethodBeat.o(179387);
  }
  
  public final void restart()
  {
    AppMethodBeat.i(179388);
    ac.i("MicroMsg.SnsAdTimelineVideoView", "restart, hasPrepared=" + this.zky);
    if (this.zky) {
      super.aw(0, true);
    }
    AppMethodBeat.o(179388);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(179390);
    aw(paramInt, true);
    AppMethodBeat.o(179390);
  }
  
  public void setShouldPlayWhenPrepared(boolean paramBoolean)
  {
    AppMethodBeat.i(179386);
    ac.i("MicroMsg.SnsAdTimelineVideoView", "setShouldPlayWhenPrepared:".concat(String.valueOf(paramBoolean)));
    this.yCn = paramBoolean;
    AppMethodBeat.o(179386);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(179392);
    ac.i("MicroMsg.SnsAdTimelineVideoView", "setThumbBmp=".concat(String.valueOf(paramBitmap)));
    if (this.qQT != null) {
      this.qQT.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(179392);
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(179393);
    ac.i("MicroMsg.SnsAdTimelineVideoView", "setThumbDrawable=".concat(String.valueOf(paramDrawable)));
    if (this.qQT != null) {
      this.qQT.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(179393);
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(179391);
    String str = getVideoPath();
    ac.i("MicroMsg.SnsAdTimelineVideoView", "setVideoPath, hasPrepared=" + this.zky + ", path=" + paramString + ", oldPath=" + str);
    if ((!this.zky) || ((paramString != null) && (!paramString.equals(str))))
    {
      super.ade(paramString);
      this.zky = true;
    }
    AppMethodBeat.o(179391);
  }
  
  public final void showLoading() {}
  
  public final void start()
  {
    AppMethodBeat.i(179384);
    boolean bool = dNU();
    ac.i("MicroMsg.SnsAdTimelineVideoView", "start, hasPrepared=" + this.ypD + ", shouldPlayWhenPrepared=" + this.yCn + ", isPlaying=" + bool);
    if ((!this.ypD) && (this.yCn))
    {
      AppMethodBeat.o(179384);
      return;
    }
    if (!bool)
    {
      ac.i("MicroMsg.SnsAdTimelineVideoView", "do start");
      super.start();
    }
    AppMethodBeat.o(179384);
  }
  
  public final void startTimer()
  {
    AppMethodBeat.i(179397);
    super.startTimer();
    ac.i("MicroMsg.SnsAdTimelineVideoView", "startTimer:" + getTimerInterval());
    AppMethodBeat.o(179397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView
 * JD-Core Version:    0.7.0.1
 */