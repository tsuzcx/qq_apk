package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/AudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isPlayerLoading", "", "()Z", "setPlayerLoading", "(Z)V", "isRunningShow", "setRunningShow", "mRandom", "", "getMRandom", "()D", "setMRandom", "(D)V", "mRectCount", "getMRectCount", "()I", "setMRectCount", "(I)V", "mRectHeight", "getMRectHeight", "setMRectHeight", "mRectWidth", "getMRectWidth", "setMRectWidth", "mWavePaint", "Landroid/graphics/Paint;", "getMWavePaint", "()Landroid/graphics/Paint;", "setMWavePaint", "(Landroid/graphics/Paint;)V", "mWidth", "getMWidth", "setMWidth", "offset", "", "getOffset", "()F", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "rectF", "Landroid/graphics/RectF;", "r1", "r2", "initView", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "color", "setShow", "isShow", "plugin-story_release"})
public final class AudioWaveView
  extends View
{
  private int mWidth;
  private final float offset;
  private int sKW;
  private int sKX;
  private Paint sKY;
  private int sKZ;
  private double sLa;
  private boolean sLb;
  private boolean sLd;
  private v sLe;
  
  public AudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(110292);
    this.offset = e.df(getContext());
    this.sLd = true;
    initView();
    AppMethodBeat.o(110292);
  }
  
  public AudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110293);
    this.offset = e.df(getContext());
    this.sLd = true;
    initView();
    AppMethodBeat.o(110293);
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF)
  {
    AppMethodBeat.i(110291);
    j.q(paramCanvas, "canvas");
    j.q(paramRectF, "rectF");
    paramCanvas.drawRect(paramRectF, this.sKY);
    AppMethodBeat.o(110291);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(110287);
    this.sKZ = 20;
    this.sKY = new Paint();
    Paint localPaint = this.sKY;
    if (localPaint == null) {
      j.ebi();
    }
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.sKY;
    if (localPaint == null) {
      j.ebi();
    }
    localPaint.setColor(-3355444);
    localPaint = this.sKY;
    if (localPaint == null) {
      j.ebi();
    }
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(110287);
  }
  
  public final double getMRandom()
  {
    return this.sLa;
  }
  
  public final int getMRectCount()
  {
    return this.sKZ;
  }
  
  public final int getMRectHeight()
  {
    return this.sKX;
  }
  
  public final int getMRectWidth()
  {
    return this.sKW;
  }
  
  public final Paint getMWavePaint()
  {
    return this.sKY;
  }
  
  public final int getMWidth()
  {
    return this.mWidth;
  }
  
  public final float getOffset()
  {
    return this.offset;
  }
  
  public final v getPlayer()
  {
    return this.sLe;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(110290);
    j.q(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.translate(getWidth() / 2, getHeight());
    int i = 0;
    int j = this.sKZ;
    if (i < j)
    {
      if (this.sLb)
      {
        this.sLa = Math.random();
        float f = (float)(this.sKX * this.sLa);
        a(paramCanvas, new RectF((float)(this.sKW * i + this.offset), 0.0F, this.sKW * (i + 1), -f));
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramCanvas, new RectF((float)(this.sKW * i + this.offset), 0.0F, this.sKW * (i + 1), -0.5F));
      }
    }
    postInvalidateDelayed(100L);
    AppMethodBeat.o(110290);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(110289);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = getWidth();
    this.sKX = (getHeight() / 2);
    this.sKW = (this.mWidth / (this.sKZ * 2));
    AppMethodBeat.o(110289);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(110288);
    Paint localPaint = this.sKY;
    if (localPaint == null) {
      j.ebi();
    }
    localPaint.setColor(paramInt);
    AppMethodBeat.o(110288);
  }
  
  public final void setMRandom(double paramDouble)
  {
    this.sLa = paramDouble;
  }
  
  public final void setMRectCount(int paramInt)
  {
    this.sKZ = paramInt;
  }
  
  public final void setMRectHeight(int paramInt)
  {
    this.sKX = paramInt;
  }
  
  public final void setMRectWidth(int paramInt)
  {
    this.sKW = paramInt;
  }
  
  public final void setMWavePaint(Paint paramPaint)
  {
    this.sKY = paramPaint;
  }
  
  public final void setMWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
  
  public final void setPlayer(v paramv)
  {
    AppMethodBeat.i(110286);
    if (paramv != null)
    {
      this.sLe = paramv;
      paramv = this.sLe;
      if (paramv != null)
      {
        paramv.a((q.a)new AudioWaveView.a(this));
        AppMethodBeat.o(110286);
        return;
      }
    }
    AppMethodBeat.o(110286);
  }
  
  public final void setPlayerLoading(boolean paramBoolean)
  {
    this.sLd = paramBoolean;
  }
  
  public final void setRunningShow(boolean paramBoolean)
  {
    this.sLb = paramBoolean;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    this.sLb = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.AudioWaveView
 * JD-Core Version:    0.7.0.1
 */