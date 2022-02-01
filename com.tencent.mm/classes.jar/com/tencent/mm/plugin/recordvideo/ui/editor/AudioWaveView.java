package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
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
import com.tencent.mm.cb.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isPlayerLoading", "", "()Z", "setPlayerLoading", "(Z)V", "isRunningShow", "setRunningShow", "mRandom", "", "getMRandom", "()D", "setMRandom", "(D)V", "mRectCount", "getMRectCount", "()I", "setMRectCount", "(I)V", "mRectHeight", "getMRectHeight", "setMRectHeight", "mRectWidth", "getMRectWidth", "setMRectWidth", "mWavePaint", "Landroid/graphics/Paint;", "getMWavePaint", "()Landroid/graphics/Paint;", "setMWavePaint", "(Landroid/graphics/Paint;)V", "mWavePatinColorState", "Landroid/content/res/ColorStateList;", "getMWavePatinColorState", "()Landroid/content/res/ColorStateList;", "setMWavePatinColorState", "(Landroid/content/res/ColorStateList;)V", "mWidth", "getMWidth", "setMWidth", "offset", "getOffset", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "rectF", "Landroid/graphics/RectF;", "r1", "", "r2", "initView", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "colorStateList", "color", "setSelected", "selected", "setShow", "isShow", "updateColors", "plugin-recordvideo_release"})
public final class AudioWaveView
  extends View
{
  private int Caf;
  private Paint Cag;
  private ColorStateList Cah;
  private int Cai;
  private double Caj;
  private boolean Cak;
  private boolean Cal;
  private v hWJ;
  private int mWidth;
  private final int offset;
  private int qSb;
  
  public AudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75901);
    this.offset = a.E(getContext(), 3);
    this.Cal = true;
    initView();
    AppMethodBeat.o(75901);
  }
  
  public AudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75902);
    this.offset = a.E(getContext(), 3);
    this.Cal = true;
    initView();
    AppMethodBeat.o(75902);
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF)
  {
    AppMethodBeat.i(75900);
    kotlin.g.b.p.h(paramCanvas, "canvas");
    kotlin.g.b.p.h(paramRectF, "rectF");
    Paint localPaint = this.Cag;
    if (localPaint == null) {
      kotlin.g.b.p.hyc();
    }
    paramCanvas.drawRect(paramRectF, localPaint);
    AppMethodBeat.o(75900);
  }
  
  private final void eLH()
  {
    int i = 0;
    AppMethodBeat.i(237576);
    Paint localPaint = this.Cag;
    if (localPaint == null) {
      kotlin.g.b.p.hyc();
    }
    ColorStateList localColorStateList = this.Cah;
    if (localColorStateList != null) {
      i = localColorStateList.getColorForState(getDrawableState(), 0);
    }
    localPaint.setColor(i);
    AppMethodBeat.o(237576);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(75896);
    this.Cai = 20;
    this.Cag = new Paint();
    Paint localPaint = this.Cag;
    if (localPaint == null) {
      kotlin.g.b.p.hyc();
    }
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.Cag;
    if (localPaint == null) {
      kotlin.g.b.p.hyc();
    }
    localPaint.setColor(-3355444);
    localPaint = this.Cag;
    if (localPaint == null) {
      kotlin.g.b.p.hyc();
    }
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(75896);
  }
  
  public final double getMRandom()
  {
    return this.Caj;
  }
  
  public final int getMRectCount()
  {
    return this.Cai;
  }
  
  public final int getMRectHeight()
  {
    return this.Caf;
  }
  
  public final int getMRectWidth()
  {
    return this.qSb;
  }
  
  public final Paint getMWavePaint()
  {
    return this.Cag;
  }
  
  public final ColorStateList getMWavePatinColorState()
  {
    return this.Cah;
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
    return this.hWJ;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(75899);
    kotlin.g.b.p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.translate(getWidth() / 2, getHeight());
    int i = 0;
    int j = this.Cai;
    if (i < j)
    {
      if (this.Cak)
      {
        this.Caj = Math.random();
        float f = (float)(this.Caf * this.Caj);
        a(paramCanvas, new RectF((float)(this.qSb * i + this.offset), 0.0F, this.qSb * (i + 1), -f));
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramCanvas, new RectF((float)(this.qSb * i + this.offset), 0.0F, this.qSb * (i + 1), -0.5F));
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
    this.Caf = (getHeight() / 2);
    this.qSb = (this.mWidth / (this.Cai * 2));
    AppMethodBeat.o(75898);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(75897);
    Paint localPaint = this.Cag;
    if (localPaint == null) {
      kotlin.g.b.p.hyc();
    }
    localPaint.setColor(paramInt);
    AppMethodBeat.o(75897);
  }
  
  public final void setColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237574);
    kotlin.g.b.p.h(paramColorStateList, "colorStateList");
    this.Cah = paramColorStateList;
    eLH();
    AppMethodBeat.o(237574);
  }
  
  public final void setMRandom(double paramDouble)
  {
    this.Caj = paramDouble;
  }
  
  public final void setMRectCount(int paramInt)
  {
    this.Cai = paramInt;
  }
  
  public final void setMRectHeight(int paramInt)
  {
    this.Caf = paramInt;
  }
  
  public final void setMRectWidth(int paramInt)
  {
    this.qSb = paramInt;
  }
  
  public final void setMWavePaint(Paint paramPaint)
  {
    this.Cag = paramPaint;
  }
  
  public final void setMWavePatinColorState(ColorStateList paramColorStateList)
  {
    this.Cah = paramColorStateList;
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
      this.hWJ = paramv;
      paramv = this.hWJ;
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
    this.Cal = paramBoolean;
  }
  
  public final void setRunningShow(boolean paramBoolean)
  {
    this.Cak = paramBoolean;
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(237575);
    super.setSelected(paramBoolean);
    eLH();
    AppMethodBeat.o(237575);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    this.Cak = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-recordvideo_release"})
  public static final class a
    implements q.a
  {
    public final void a(e parame) {}
    
    public final void aA(int paramInt) {}
    
    public final void aR(boolean paramBoolean) {}
    
    public final void b(com.google.android.exoplayer2.p paramp) {}
    
    public final void c(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(75894);
      if (paramInt == 3) {
        this.Cam.setPlayerLoading(false);
      }
      AppMethodBeat.o(75894);
    }
    
    public final void tA() {}
    
    public final void ty() {}
    
    public final void tz() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.AudioWaveView
 * JD-Core Version:    0.7.0.1
 */