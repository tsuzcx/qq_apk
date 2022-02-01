package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ctg;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/FinderLyricsEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "lyricsBitmaps", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorInfo;", "matrix", "Landroid/graphics/Matrix;", "musicDuration", "", "(Ljava/util/List;Landroid/graphics/Matrix;J)V", "currentTime", "lastLrcTime", "getLastLrcTime", "()J", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawWave", "fillAlpha", "fillWaveAlpha", "appearTime", "nextIndex", "seekTo", "timeMs", "plugin-recordvideo_release"})
public final class f
  extends h
{
  private final long Icy;
  private long lwE;
  
  public f(List<g> paramList, Matrix paramMatrix, long paramLong)
  {
    super(paramList, paramMatrix);
    AppMethodBeat.i(220095);
    this.Icy = paramLong;
    AppMethodBeat.o(220095);
  }
  
  private final long getLastLrcTime()
  {
    AppMethodBeat.i(220051);
    if (this.Icy > 0L)
    {
      l1 = this.Icy;
      AppMethodBeat.o(220051);
      return l1;
    }
    long l1 = ((g)j.lq(fzg())).Idi.startTime;
    long l2 = getLAST_INTERVAL();
    AppMethodBeat.o(220051);
    return l1 + l2;
  }
  
  protected final void PC(long paramLong)
  {
    AppMethodBeat.i(220068);
    long l1;
    long l2;
    if (getWaveAlpha() < 255)
    {
      l1 = getTRANS_TIME();
      l2 = fyT() - paramLong;
      if (0L <= l2) {
        break label62;
      }
    }
    label62:
    while (l1 < l2)
    {
      if (this.lwE - paramLong > getTRANS_TIME()) {
        setWaveAlpha(255);
      }
      AppMethodBeat.o(220068);
      return;
    }
    setWaveAlpha((int)(255.0F * (float)(this.lwE - paramLong) / (float)getTRANS_TIME()));
    AppMethodBeat.o(220068);
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(220092);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    paramCanvas.save();
    Object localObject = (g)j.M(fzg(), getCurIndex());
    if (localObject != null) {}
    for (localObject = ((g)localObject).bitmap;; localObject = null)
    {
      if (localObject != null)
      {
        fyM();
        fyL();
        paramPaint.setAlpha(getAlpha());
        paramCanvas.concat(fyW());
        x(paramCanvas);
        paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, getLYRICS_VERTICAL_OFFSET(), paramPaint);
        paramPaint.setAlpha(255);
      }
      paramCanvas.restore();
      AppMethodBeat.o(220092);
      return;
    }
  }
  
  protected final void fyL()
  {
    AppMethodBeat.i(220062);
    if (getCurIndex() < fzg().size())
    {
      long l2 = ((g)fzg().get(getCurIndex())).Idi.startTime;
      Object localObject = (g)j.M(fzg(), getCurIndex() + 1);
      long l1;
      long l3;
      long l4;
      if (localObject != null)
      {
        localObject = ((g)localObject).Idi;
        if (localObject != null)
        {
          l1 = ((ctg)localObject).startTime;
          l3 = getTRANS_TIME();
          l4 = this.lwE - l2;
          if (0L <= l4) {
            break label199;
          }
          label106:
          l3 = getTRANS_TIME();
          l4 = l1 - this.lwE;
          if (0L <= l4) {
            break label234;
          }
        }
      }
      for (;;)
      {
        if ((this.lwE - l2 > getTRANS_TIME()) && (l1 - this.lwE > getTRANS_TIME()))
        {
          setAlpha(255);
          AppMethodBeat.o(220062);
          return;
          l1 = ((g)fzg().get(getCurIndex())).Idi.startTime + getLAST_INTERVAL();
          break;
          label199:
          if (l3 < l4) {
            break label106;
          }
          setAlpha((int)((float)(this.lwE - l2) * 255.0F / (float)getTRANS_TIME()));
          AppMethodBeat.o(220062);
          return;
          label234:
          if (l3 >= l4)
          {
            setAlpha((int)((float)(l1 - this.lwE) / (float)getTRANS_TIME() * 255.0F));
            AppMethodBeat.o(220062);
            return;
          }
        }
      }
      setAlpha(0);
    }
    AppMethodBeat.o(220062);
  }
  
  protected final void fyM()
  {
    AppMethodBeat.i(220076);
    if (fzg().isEmpty())
    {
      AppMethodBeat.o(220076);
      return;
    }
    Object localObject = fzg();
    localObject = ((List)localObject).listIterator(((List)localObject).size());
    if (((ListIterator)localObject).hasPrevious())
    {
      g localg = (g)((ListIterator)localObject).previous();
      if (this.lwE >= localg.Idi.startTime)
      {
        i = 1;
        label77:
        if (i == 0) {
          break label106;
        }
      }
    }
    for (int i = ((ListIterator)localObject).nextIndex();; i = -1)
    {
      setCurIndex(Math.max(0, i));
      AppMethodBeat.o(220076);
      return;
      i = 0;
      break label77;
      label106:
      break;
    }
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(220054);
    for (this.lwE = paramLong; this.lwE > getLastLrcTime(); this.lwE -= getLastLrcTime()) {}
    super.seekTo(paramLong);
    AppMethodBeat.o(220054);
  }
  
  protected final void x(Canvas paramCanvas)
  {
    AppMethodBeat.i(220085);
    p.k(paramCanvas, "canvas");
    float f1;
    label87:
    RectF localRectF;
    if (!((Collection)fzg()).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label376;
      }
      if ((getWaveTime() != 0L) && (this.lwE - getWaveTime() <= fyX())) {
        break label299;
      }
      setWaveTime(this.lwE);
      arrayOfRectF = fze();
      i = 0;
      int k = arrayOfRectF.length;
      j = 0;
      f1 = 0.0F;
      if (j >= k) {
        break label299;
      }
      localRectF = arrayOfRectF[j];
      f2 = localRectF.height();
      if (f2 > fza()) {
        break label253;
      }
      fzf()[i] = ((float)(fyZ() * Math.random()));
      label134:
      if (f2 > fzf()[i]) {
        break label280;
      }
    }
    label280:
    for (float f2 = Math.min(f2 + fzc(), fyZ());; f2 = Math.max(f2 - fzd(), fza()))
    {
      float f3 = fzb();
      float f4 = fyZ() / 2.0F;
      float f5 = f2 / 2.0F;
      float f6 = fzb();
      float f7 = fyY();
      float f8 = fyZ() / 2.0F;
      localRectF.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
      f1 = localRectF.right;
      j += 1;
      i += 1;
      break label87;
      i = 0;
      break;
      label253:
      if (f2 < fzf()[i]) {
        break label134;
      }
      fzf()[i] = fza();
      break label134;
    }
    label299:
    PC(((g)fzg().get(0)).Idi.startTime);
    getWavePaint().setAlpha(getWaveAlpha());
    RectF[] arrayOfRectF = fze();
    int j = arrayOfRectF.length;
    int i = 0;
    while (i < j)
    {
      paramCanvas.drawRect(arrayOfRectF[i], getWavePaint());
      i += 1;
    }
    label376:
    AppMethodBeat.o(220085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.f
 * JD-Core Version:    0.7.0.1
 */