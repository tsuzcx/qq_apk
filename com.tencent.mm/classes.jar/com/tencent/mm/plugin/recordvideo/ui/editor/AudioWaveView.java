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
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.v;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isPlayerLoading", "", "()Z", "setPlayerLoading", "(Z)V", "isRunningShow", "setRunningShow", "mRandom", "", "getMRandom", "()D", "setMRandom", "(D)V", "mRectCount", "getMRectCount", "()I", "setMRectCount", "(I)V", "mRectHeight", "getMRectHeight", "setMRectHeight", "mRectWidth", "getMRectWidth", "setMRectWidth", "mWavePaint", "Landroid/graphics/Paint;", "getMWavePaint", "()Landroid/graphics/Paint;", "setMWavePaint", "(Landroid/graphics/Paint;)V", "mWavePatinColorState", "Landroid/content/res/ColorStateList;", "getMWavePatinColorState", "()Landroid/content/res/ColorStateList;", "setMWavePatinColorState", "(Landroid/content/res/ColorStateList;)V", "mWidth", "getMWidth", "setMWidth", "offset", "getOffset", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "rectF", "Landroid/graphics/RectF;", "r1", "", "r2", "initView", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "colorStateList", "color", "setSelected", "selected", "setShow", "isShow", "updateColors", "plugin-recordvideo_release"})
public final class AudioWaveView
  extends View
{
  private int HWU;
  private Paint HWV;
  private ColorStateList HWW;
  private int HWX;
  private double HWY;
  private boolean HWZ;
  private boolean HXa;
  private v kLl;
  private int mWidth;
  private final int offset;
  private int uuh;
  
  public AudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75901);
    this.offset = a.H(getContext(), 3);
    this.HXa = true;
    initView();
    AppMethodBeat.o(75901);
  }
  
  public AudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75902);
    this.offset = a.H(getContext(), 3);
    this.HXa = true;
    initView();
    AppMethodBeat.o(75902);
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF)
  {
    AppMethodBeat.i(75900);
    kotlin.g.b.p.k(paramCanvas, "canvas");
    kotlin.g.b.p.k(paramRectF, "rectF");
    Paint localPaint = this.HWV;
    if (localPaint == null) {
      kotlin.g.b.p.iCn();
    }
    paramCanvas.drawRect(paramRectF, localPaint);
    AppMethodBeat.o(75900);
  }
  
  private final void fyc()
  {
    int i = 0;
    AppMethodBeat.i(221974);
    Paint localPaint = this.HWV;
    if (localPaint == null) {
      kotlin.g.b.p.iCn();
    }
    ColorStateList localColorStateList = this.HWW;
    if (localColorStateList != null) {
      i = localColorStateList.getColorForState(getDrawableState(), 0);
    }
    localPaint.setColor(i);
    AppMethodBeat.o(221974);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(75896);
    this.HWX = 20;
    this.HWV = new Paint();
    Paint localPaint = this.HWV;
    if (localPaint == null) {
      kotlin.g.b.p.iCn();
    }
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.HWV;
    if (localPaint == null) {
      kotlin.g.b.p.iCn();
    }
    localPaint.setColor(-3355444);
    localPaint = this.HWV;
    if (localPaint == null) {
      kotlin.g.b.p.iCn();
    }
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(75896);
  }
  
  public final double getMRandom()
  {
    return this.HWY;
  }
  
  public final int getMRectCount()
  {
    return this.HWX;
  }
  
  public final int getMRectHeight()
  {
    return this.HWU;
  }
  
  public final int getMRectWidth()
  {
    return this.uuh;
  }
  
  public final Paint getMWavePaint()
  {
    return this.HWV;
  }
  
  public final ColorStateList getMWavePatinColorState()
  {
    return this.HWW;
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
    return this.kLl;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(75899);
    kotlin.g.b.p.k(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.translate(getWidth() / 2, getHeight());
    int i = 0;
    int j = this.HWX;
    if (i < j)
    {
      if (this.HWZ)
      {
        this.HWY = Math.random();
        float f = (float)(this.HWU * this.HWY);
        a(paramCanvas, new RectF((float)(this.uuh * i + this.offset), 0.0F, this.uuh * (i + 1), -f));
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramCanvas, new RectF((float)(this.uuh * i + this.offset), 0.0F, this.uuh * (i + 1), -0.5F));
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
    this.HWU = (getHeight() / 2);
    this.uuh = (this.mWidth / (this.HWX * 2));
    AppMethodBeat.o(75898);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(75897);
    Paint localPaint = this.HWV;
    if (localPaint == null) {
      kotlin.g.b.p.iCn();
    }
    localPaint.setColor(paramInt);
    AppMethodBeat.o(75897);
  }
  
  public final void setColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(221965);
    kotlin.g.b.p.k(paramColorStateList, "colorStateList");
    this.HWW = paramColorStateList;
    fyc();
    AppMethodBeat.o(221965);
  }
  
  public final void setMRandom(double paramDouble)
  {
    this.HWY = paramDouble;
  }
  
  public final void setMRectCount(int paramInt)
  {
    this.HWX = paramInt;
  }
  
  public final void setMRectHeight(int paramInt)
  {
    this.HWU = paramInt;
  }
  
  public final void setMRectWidth(int paramInt)
  {
    this.uuh = paramInt;
  }
  
  public final void setMWavePaint(Paint paramPaint)
  {
    this.HWV = paramPaint;
  }
  
  public final void setMWavePatinColorState(ColorStateList paramColorStateList)
  {
    this.HWW = paramColorStateList;
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
      this.kLl = paramv;
      paramv = this.kLl;
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
    this.HXa = paramBoolean;
  }
  
  public final void setRunningShow(boolean paramBoolean)
  {
    this.HWZ = paramBoolean;
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(221969);
    super.setSelected(paramBoolean);
    fyc();
    AppMethodBeat.o(221969);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    this.HWZ = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-recordvideo_release"})
  public static final class a
    implements q.a
  {
    public final void I(int paramInt) {}
    
    public final void a(e parame) {}
    
    public final void a(r paramr, g paramg) {}
    
    public final void aP(boolean paramBoolean) {}
    
    public final void b(com.google.android.exoplayer2.p paramp) {}
    
    public final void b(w paramw, Object paramObject) {}
    
    public final void e(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(75894);
      if (paramInt == 3) {
        this.HXb.setPlayerLoading(false);
      }
      AppMethodBeat.o(75894);
    }
    
    public final void rs() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.AudioWaveView
 * JD-Core Version:    0.7.0.1
 */