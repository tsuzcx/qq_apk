package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.core.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdTimelineVideoView
  extends OfflineVideoView
{
  boolean Fey;
  private a<Void> QeN;
  public a<Boolean> RWJ;
  private boolean RWK;
  
  public SnsAdTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public SnsAdTimelineVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.Rgx = false;
  }
  
  public final void Qz()
  {
    AppMethodBeat.i(179387);
    if (this.QeN != null)
    {
      this.QeN.accept(null);
      this.QeN = null;
    }
    Log.i("MicroMsg.SnsAdTimelineVideoView", "onPrepared, path=%s , shouldPlayWhenPrepared=%s", new Object[] { getVideoPath(), Boolean.valueOf(this.Rgx) });
    if (this.Rgx) {
      super.Qz();
    }
    this.Fey = true;
    AppMethodBeat.o(179387);
  }
  
  public final void alJ(int paramInt)
  {
    AppMethodBeat.i(179400);
    super.alJ(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("updateVideoUI: thumVis=");
    if (this.AlJ.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.SnsAdTimelineVideoView", bool + ", ms=" + paramInt + ", second=" + paramInt / 1000);
      AppMethodBeat.o(179400);
      return;
    }
  }
  
  public final void bEH()
  {
    AppMethodBeat.i(179388);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "restart, hasPrepared=" + this.RWK);
    if (this.RWK) {
      super.bJ(0, true);
    }
    AppMethodBeat.o(179388);
  }
  
  public final void bJ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(309276);
    super.bJ(paramInt, paramBoolean);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "seekTo:" + paramInt + ", afterSeekPlay=" + paramBoolean);
    AppMethodBeat.o(309276);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179389);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "clear");
    super.onDestroy();
    this.RWK = false;
    this.Rgx = false;
    this.Fey = false;
    Log.i("MicroMsg.SnsAdTimelineVideoView", "path after clear=" + getVideoPath());
    AppMethodBeat.o(179389);
  }
  
  public final void d(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(179399);
    super.d(paramBoolean, paramFloat);
    StringBuilder localStringBuilder = new StringBuilder("switchVideoModel: thumVis=");
    if (this.AlJ.getVisibility() == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      Log.i("MicroMsg.SnsAdTimelineVideoView", paramBoolean);
      AppMethodBeat.o(179399);
      return;
    }
  }
  
  public Drawable getThumbDrawable()
  {
    AppMethodBeat.i(179394);
    if (this.AlJ != null)
    {
      Drawable localDrawable = this.AlJ.getDrawable();
      AppMethodBeat.o(179394);
      return localDrawable;
    }
    AppMethodBeat.o(179394);
    return null;
  }
  
  public final void hmt()
  {
    AppMethodBeat.i(179398);
    super.hmt();
    Log.i("MicroMsg.SnsAdTimelineVideoView", "clearTimer");
    AppMethodBeat.o(179398);
  }
  
  public final void hsQ()
  {
    AppMethodBeat.i(309256);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "showVideoThumb:true");
    d(false, 0.0F);
    AppMethodBeat.o(309256);
  }
  
  public final boolean isError()
  {
    AppMethodBeat.i(179395);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "isError=" + this.Aqa);
    boolean bool = this.Aqa;
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
    AppMethodBeat.i(309338);
    super.onError(paramInt1, paramInt2);
    h.OAn.kJ(1579, 7);
    AppMethodBeat.o(309338);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(179385);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "pause");
    super.hmu();
    AppMethodBeat.o(179385);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(179390);
    bJ(paramInt, true);
    AppMethodBeat.o(179390);
  }
  
  public void setOnPrepared(a<Void> parama)
  {
    this.QeN = parama;
  }
  
  public void setOnReplay(a<Boolean> parama)
  {
    this.RWJ = parama;
  }
  
  public void setShouldPlayWhenPrepared(boolean paramBoolean)
  {
    AppMethodBeat.i(179386);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "setShouldPlayWhenPrepared:".concat(String.valueOf(paramBoolean)));
    this.Rgx = paramBoolean;
    AppMethodBeat.o(179386);
  }
  
  public void setThumbBmp(Bitmap paramBitmap)
  {
    AppMethodBeat.i(179392);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "setThumbBmp=".concat(String.valueOf(paramBitmap)));
    if (this.AlJ != null) {
      this.AlJ.setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(179392);
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(179393);
    Log.i("MicroMsg.SnsAdTimelineVideoView", "setThumbDrawable=".concat(String.valueOf(paramDrawable)));
    if (this.AlJ != null) {
      this.AlJ.setImageDrawable(paramDrawable);
    }
    AppMethodBeat.o(179393);
  }
  
  public void setThumpViewScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(309290);
    if (this.AlJ != null) {
      this.AlJ.setScaleType(paramScaleType);
    }
    AppMethodBeat.o(309290);
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(179391);
    String str = getVideoPath();
    Log.i("MicroMsg.SnsAdTimelineVideoView", "setVideoPath, hasPrepared=" + this.RWK + ", path=" + paramString + ", oldPath=" + str);
    if ((!this.RWK) || ((paramString != null) && (!paramString.equals(str))))
    {
      super.auJ(paramString);
      this.RWK = true;
    }
    AppMethodBeat.o(179391);
  }
  
  public final void showLoading() {}
  
  public final void start()
  {
    AppMethodBeat.i(179384);
    boolean bool = hmw();
    Log.i("MicroMsg.SnsAdTimelineVideoView", "start, hasPrepared=" + this.Fey + ", shouldPlayWhenPrepared=" + this.Rgx + ", isPlaying=" + bool);
    if ((!this.Fey) && (this.Rgx))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView
 * JD-Core Version:    0.7.0.1
 */