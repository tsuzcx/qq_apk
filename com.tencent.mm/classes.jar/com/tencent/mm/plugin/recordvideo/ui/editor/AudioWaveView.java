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
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isPlayerLoading", "", "()Z", "setPlayerLoading", "(Z)V", "isRunningShow", "setRunningShow", "mRandom", "", "getMRandom", "()D", "setMRandom", "(D)V", "mRectCount", "getMRectCount", "()I", "setMRectCount", "(I)V", "mRectHeight", "getMRectHeight", "setMRectHeight", "mRectWidth", "getMRectWidth", "setMRectWidth", "mWavePaint", "Landroid/graphics/Paint;", "getMWavePaint", "()Landroid/graphics/Paint;", "setMWavePaint", "(Landroid/graphics/Paint;)V", "mWidth", "getMWidth", "setMWidth", "offset", "getOffset", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "rectF", "Landroid/graphics/RectF;", "r1", "", "r2", "initView", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "color", "setShow", "isShow", "plugin-recordvideo_release"})
public final class AudioWaveView
  extends View
{
  private v hbj;
  private int mWidth;
  private final int offset;
  private int pwf;
  private int xJm;
  private Paint xJn;
  private int xJo;
  private double xJp;
  private boolean xJq;
  private boolean xJr;
  
  public AudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75901);
    this.offset = a.aA(getContext(), 3);
    this.xJr = true;
    initView();
    AppMethodBeat.o(75901);
  }
  
  public AudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75902);
    this.offset = a.aA(getContext(), 3);
    this.xJr = true;
    initView();
    AppMethodBeat.o(75902);
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF)
  {
    AppMethodBeat.i(75900);
    d.g.b.p.h(paramCanvas, "canvas");
    d.g.b.p.h(paramRectF, "rectF");
    paramCanvas.drawRect(paramRectF, this.xJn);
    AppMethodBeat.o(75900);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(75896);
    this.xJo = 20;
    this.xJn = new Paint();
    Paint localPaint = this.xJn;
    if (localPaint == null) {
      d.g.b.p.gfZ();
    }
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.xJn;
    if (localPaint == null) {
      d.g.b.p.gfZ();
    }
    localPaint.setColor(-3355444);
    localPaint = this.xJn;
    if (localPaint == null) {
      d.g.b.p.gfZ();
    }
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(75896);
  }
  
  public final double getMRandom()
  {
    return this.xJp;
  }
  
  public final int getMRectCount()
  {
    return this.xJo;
  }
  
  public final int getMRectHeight()
  {
    return this.xJm;
  }
  
  public final int getMRectWidth()
  {
    return this.pwf;
  }
  
  public final Paint getMWavePaint()
  {
    return this.xJn;
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
    return this.hbj;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(75899);
    d.g.b.p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.translate(getWidth() / 2, getHeight());
    int i = 0;
    int j = this.xJo;
    if (i < j)
    {
      if (this.xJq)
      {
        this.xJp = Math.random();
        float f = (float)(this.xJm * this.xJp);
        a(paramCanvas, new RectF((float)(this.pwf * i + this.offset), 0.0F, this.pwf * (i + 1), -f));
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramCanvas, new RectF((float)(this.pwf * i + this.offset), 0.0F, this.pwf * (i + 1), -0.5F));
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
    this.xJm = (getHeight() / 2);
    this.pwf = (this.mWidth / (this.xJo * 2));
    AppMethodBeat.o(75898);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(75897);
    Paint localPaint = this.xJn;
    if (localPaint == null) {
      d.g.b.p.gfZ();
    }
    localPaint.setColor(paramInt);
    AppMethodBeat.o(75897);
  }
  
  public final void setMRandom(double paramDouble)
  {
    this.xJp = paramDouble;
  }
  
  public final void setMRectCount(int paramInt)
  {
    this.xJo = paramInt;
  }
  
  public final void setMRectHeight(int paramInt)
  {
    this.xJm = paramInt;
  }
  
  public final void setMRectWidth(int paramInt)
  {
    this.pwf = paramInt;
  }
  
  public final void setMWavePaint(Paint paramPaint)
  {
    this.xJn = paramPaint;
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
      this.hbj = paramv;
      paramv = this.hbj;
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
    this.xJr = paramBoolean;
  }
  
  public final void setRunningShow(boolean paramBoolean)
  {
    this.xJq = paramBoolean;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    this.xJq = paramBoolean;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-recordvideo_release"})
  public static final class a
    implements q.a
  {
    public final void a(e parame) {}
    
    public final void aA(int paramInt) {}
    
    public final void aS(boolean paramBoolean) {}
    
    public final void b(com.google.android.exoplayer2.p paramp) {}
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(75894);
      if (paramInt == 3) {
        this.xJs.setPlayerLoading(false);
      }
      AppMethodBeat.o(75894);
    }
    
    public final void tt() {}
    
    public final void tu() {}
    
    public final void tv() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.AudioWaveView
 * JD-Core Version:    0.7.0.1
 */