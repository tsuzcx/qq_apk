package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isPlayerLoading", "", "()Z", "setPlayerLoading", "(Z)V", "isRunningShow", "setRunningShow", "mRandom", "", "getMRandom", "()D", "setMRandom", "(D)V", "mRectCount", "getMRectCount", "()I", "setMRectCount", "(I)V", "mRectHeight", "getMRectHeight", "setMRectHeight", "mRectWidth", "getMRectWidth", "setMRectWidth", "mWavePaint", "Landroid/graphics/Paint;", "getMWavePaint", "()Landroid/graphics/Paint;", "setMWavePaint", "(Landroid/graphics/Paint;)V", "mWidth", "getMWidth", "setMWidth", "offset", "getOffset", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "rectF", "Landroid/graphics/RectF;", "r1", "", "r2", "initView", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "color", "setShow", "isShow", "plugin-recordvideo_release"})
public final class AudioWaveView
  extends View
{
  private v gHz;
  private int mWidth;
  private int oSv;
  private final int offset;
  private Paint wAa;
  private int wAb;
  private double wAc;
  private boolean wAd;
  private boolean wAe;
  private int wzZ;
  
  public AudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75901);
    this.offset = a.ax(getContext(), 3);
    this.wAe = true;
    initView();
    AppMethodBeat.o(75901);
  }
  
  public AudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75902);
    this.offset = a.ax(getContext(), 3);
    this.wAe = true;
    initView();
    AppMethodBeat.o(75902);
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF)
  {
    AppMethodBeat.i(75900);
    k.h(paramCanvas, "canvas");
    k.h(paramRectF, "rectF");
    paramCanvas.drawRect(paramRectF, this.wAa);
    AppMethodBeat.o(75900);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(75896);
    this.wAb = 20;
    this.wAa = new Paint();
    Paint localPaint = this.wAa;
    if (localPaint == null) {
      k.fOy();
    }
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.wAa;
    if (localPaint == null) {
      k.fOy();
    }
    localPaint.setColor(-3355444);
    localPaint = this.wAa;
    if (localPaint == null) {
      k.fOy();
    }
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(75896);
  }
  
  public final double getMRandom()
  {
    return this.wAc;
  }
  
  public final int getMRectCount()
  {
    return this.wAb;
  }
  
  public final int getMRectHeight()
  {
    return this.wzZ;
  }
  
  public final int getMRectWidth()
  {
    return this.oSv;
  }
  
  public final Paint getMWavePaint()
  {
    return this.wAa;
  }
  
  public final int getMWidth()
  {
    return this.mWidth;
  }
  
  public final int getOffset()
  {
    return this.offset;
  }
  
  public final v getPlayer()
  {
    return this.gHz;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(75899);
    k.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.translate(getWidth() / 2, getHeight());
    int i = 0;
    int j = this.wAb;
    if (i < j)
    {
      if (this.wAd)
      {
        this.wAc = Math.random();
        float f = (float)(this.wzZ * this.wAc);
        a(paramCanvas, new RectF((float)(this.oSv * i + this.offset), 0.0F, this.oSv * (i + 1), -f));
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramCanvas, new RectF((float)(this.oSv * i + this.offset), 0.0F, this.oSv * (i + 1), -0.5F));
      }
    }
    postInvalidateDelayed(100L);
    AppMethodBeat.o(75899);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(75898);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = getWidth();
    this.wzZ = (getHeight() / 2);
    this.oSv = (this.mWidth / (this.wAb * 2));
    AppMethodBeat.o(75898);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(75897);
    Paint localPaint = this.wAa;
    if (localPaint == null) {
      k.fOy();
    }
    localPaint.setColor(paramInt);
    AppMethodBeat.o(75897);
  }
  
  public final void setMRandom(double paramDouble)
  {
    this.wAc = paramDouble;
  }
  
  public final void setMRectCount(int paramInt)
  {
    this.wAb = paramInt;
  }
  
  public final void setMRectHeight(int paramInt)
  {
    this.wzZ = paramInt;
  }
  
  public final void setMRectWidth(int paramInt)
  {
    this.oSv = paramInt;
  }
  
  public final void setMWavePaint(Paint paramPaint)
  {
    this.wAa = paramPaint;
  }
  
  public final void setMWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
  
  public final void setPlayer(v paramv)
  {
    AppMethodBeat.i(75895);
    if (paramv != null)
    {
      this.gHz = paramv;
      paramv = this.gHz;
      if (paramv != null)
      {
        paramv.a((q.a)new a(this));
        AppMethodBeat.o(75895);
        return;
      }
    }
    AppMethodBeat.o(75895);
  }
  
  public final void setPlayerLoading(boolean paramBoolean)
  {
    this.wAe = paramBoolean;
  }
  
  public final void setRunningShow(boolean paramBoolean)
  {
    this.wAd = paramBoolean;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    this.wAd = paramBoolean;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-recordvideo_release"})
  public static final class a
    implements q.a
  {
    public final void a(e parame) {}
    
    public final void aA(int paramInt) {}
    
    public final void aR(boolean paramBoolean) {}
    
    public final void b(p paramp) {}
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(75894);
      if (paramInt == 3) {
        this.wAf.setPlayerLoading(false);
      }
      AppMethodBeat.o(75894);
    }
    
    public final void rU() {}
    
    public final void rV() {}
    
    public final void rW() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.AudioWaveView
 * JD-Core Version:    0.7.0.1
 */