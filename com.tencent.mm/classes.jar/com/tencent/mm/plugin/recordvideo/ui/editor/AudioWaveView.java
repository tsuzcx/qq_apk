package com.tencent.mm.plugin.recordvideo.ui.editor;

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
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q.a;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.v;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isPlayerLoading", "", "()Z", "setPlayerLoading", "(Z)V", "isRunningShow", "setRunningShow", "mRandom", "", "getMRandom", "()D", "setMRandom", "(D)V", "mRectCount", "getMRectCount", "()I", "setMRectCount", "(I)V", "mRectHeight", "getMRectHeight", "setMRectHeight", "mRectWidth", "getMRectWidth", "setMRectWidth", "mWavePaint", "Landroid/graphics/Paint;", "getMWavePaint", "()Landroid/graphics/Paint;", "setMWavePaint", "(Landroid/graphics/Paint;)V", "mWavePatinColorState", "Landroid/content/res/ColorStateList;", "getMWavePatinColorState", "()Landroid/content/res/ColorStateList;", "setMWavePatinColorState", "(Landroid/content/res/ColorStateList;)V", "mWidth", "getMWidth", "setMWidth", "offset", "getOffset", "value", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "player", "getPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setPlayer", "(Lcom/google/android/exoplayer2/SimpleExoPlayer;)V", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "rectF", "Landroid/graphics/RectF;", "r1", "", "r2", "initView", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setColor", "colorStateList", "color", "setSelected", "selected", "setShow", "isShow", "updateColors", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AudioWaveView
  extends View
{
  private int NTE;
  private Paint NTF;
  private ColorStateList NTG;
  private int NTH;
  private double NTI;
  private boolean NTJ;
  private boolean NTK;
  private int mWidth;
  private v nno;
  private final int offset;
  private int xAE;
  
  public AudioWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75901);
    this.offset = a.K(getContext(), 3);
    this.NTK = true;
    initView();
    AppMethodBeat.o(75901);
  }
  
  public AudioWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(75902);
    this.offset = a.K(getContext(), 3);
    this.NTK = true;
    initView();
    AppMethodBeat.o(75902);
  }
  
  private void a(Canvas paramCanvas, RectF paramRectF)
  {
    AppMethodBeat.i(75900);
    s.u(paramCanvas, "canvas");
    s.u(paramRectF, "rectF");
    Paint localPaint = this.NTF;
    s.checkNotNull(localPaint);
    paramCanvas.drawRect(paramRectF, localPaint);
    AppMethodBeat.o(75900);
  }
  
  private final void gJP()
  {
    int i = 0;
    AppMethodBeat.i(280059);
    Paint localPaint = this.NTF;
    s.checkNotNull(localPaint);
    ColorStateList localColorStateList = this.NTG;
    if (localColorStateList == null) {}
    for (;;)
    {
      localPaint.setColor(i);
      AppMethodBeat.o(280059);
      return;
      i = localColorStateList.getColorForState(getDrawableState(), 0);
    }
  }
  
  private final void initView()
  {
    AppMethodBeat.i(75896);
    this.NTH = 20;
    this.NTF = new Paint();
    Paint localPaint = this.NTF;
    s.checkNotNull(localPaint);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.NTF;
    s.checkNotNull(localPaint);
    localPaint.setColor(-3355444);
    localPaint = this.NTF;
    s.checkNotNull(localPaint);
    localPaint.setAntiAlias(true);
    AppMethodBeat.o(75896);
  }
  
  public final double getMRandom()
  {
    return this.NTI;
  }
  
  public final int getMRectCount()
  {
    return this.NTH;
  }
  
  public final int getMRectHeight()
  {
    return this.NTE;
  }
  
  public final int getMRectWidth()
  {
    return this.xAE;
  }
  
  public final Paint getMWavePaint()
  {
    return this.NTF;
  }
  
  public final ColorStateList getMWavePatinColorState()
  {
    return this.NTG;
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
    return this.nno;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(75899);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.translate(getWidth() / 2, getHeight());
    int i = 0;
    int k = this.NTH;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      if (this.NTJ)
      {
        this.NTI = Math.random();
        float f = (float)(this.NTE * this.NTI);
        a(paramCanvas, new RectF((float)(this.xAE * i + this.offset), 0.0F, (i + 1) * this.xAE, -f));
      }
      while (j >= k)
      {
        postInvalidateDelayed(100L);
        AppMethodBeat.o(75899);
        return;
        a(paramCanvas, new RectF((float)(this.xAE * i + this.offset), 0.0F, (i + 1) * this.xAE, -0.5F));
      }
      i = j;
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(75898);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = getWidth();
    this.NTE = (getHeight() / 2);
    this.xAE = (this.mWidth / (this.NTH * 2));
    AppMethodBeat.o(75898);
  }
  
  public final void setColor(int paramInt)
  {
    AppMethodBeat.i(75897);
    Paint localPaint = this.NTF;
    s.checkNotNull(localPaint);
    localPaint.setColor(paramInt);
    AppMethodBeat.o(75897);
  }
  
  public final void setColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(280169);
    s.u(paramColorStateList, "colorStateList");
    this.NTG = paramColorStateList;
    gJP();
    AppMethodBeat.o(280169);
  }
  
  public final void setMRandom(double paramDouble)
  {
    this.NTI = paramDouble;
  }
  
  public final void setMRectCount(int paramInt)
  {
    this.NTH = paramInt;
  }
  
  public final void setMRectHeight(int paramInt)
  {
    this.NTE = paramInt;
  }
  
  public final void setMRectWidth(int paramInt)
  {
    this.xAE = paramInt;
  }
  
  public final void setMWavePaint(Paint paramPaint)
  {
    this.NTF = paramPaint;
  }
  
  public final void setMWavePatinColorState(ColorStateList paramColorStateList)
  {
    this.NTG = paramColorStateList;
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
      this.nno = paramv;
      paramv = this.nno;
      if (paramv != null) {
        paramv.a((q.a)new a(this));
      }
    }
    AppMethodBeat.o(75895);
  }
  
  public final void setPlayerLoading(boolean paramBoolean)
  {
    this.NTK = paramBoolean;
  }
  
  public final void setRunningShow(boolean paramBoolean)
  {
    this.NTJ = paramBoolean;
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(280177);
    super.setSelected(paramBoolean);
    gJP();
    AppMethodBeat.o(280177);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    this.NTJ = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/ui/editor/AudioWaveView$player$1", "Lcom/google/android/exoplayer2/Player$EventListener;", "onLoadingChanged", "", "p0", "", "onPlaybackParametersChanged", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "p1", "", "onPositionDiscontinuity", "onRepeatModeChanged", "onTimelineChanged", "Lcom/google/android/exoplayer2/Timeline;", "", "onTracksChanged", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements q.a
  {
    a(AudioWaveView paramAudioWaveView) {}
    
    public final void onLoadingChanged(boolean paramBoolean) {}
    
    public final void onPlaybackParametersChanged(p paramp) {}
    
    public final void onPlayerError(e parame) {}
    
    public final void onPlayerStateChanged(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(75894);
      if (paramInt == 3) {
        this.NTL.setPlayerLoading(false);
      }
      AppMethodBeat.o(75894);
    }
    
    public final void onPositionDiscontinuity() {}
    
    public final void onRepeatModeChanged(int paramInt) {}
    
    public final void onTimelineChanged(w paramw, Object paramObject) {}
    
    public final void onTracksChanged(r paramr, g paramg) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.AudioWaveView
 * JD-Core Version:    0.7.0.1
 */