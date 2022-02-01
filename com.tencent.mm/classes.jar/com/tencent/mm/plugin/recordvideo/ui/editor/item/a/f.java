package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dki;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/FinderLyricsEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "lyricsBitmaps", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorInfo;", "matrix", "Landroid/graphics/Matrix;", "musicDuration", "", "(Ljava/util/List;Landroid/graphics/Matrix;J)V", "currentTime", "lastLrcTime", "getLastLrcTime", "()J", "draw", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "drawWave", "fillAlpha", "fillWaveAlpha", "appearTime", "nextIndex", "seekTo", "timeMs", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends h
{
  private final long NYV;
  private long ood;
  
  public f(List<g> paramList, Matrix paramMatrix, long paramLong)
  {
    super(paramList, paramMatrix);
    AppMethodBeat.i(280406);
    this.NYV = paramLong;
    AppMethodBeat.o(280406);
  }
  
  private final long getLastLrcTime()
  {
    AppMethodBeat.i(280414);
    if (this.NYV > 0L)
    {
      l1 = this.NYV;
      AppMethodBeat.o(280414);
      return l1;
    }
    long l1 = ((g)p.oM(gKJ())).NZE.startTime;
    long l2 = getLAST_INTERVAL();
    AppMethodBeat.o(280414);
    return l1 + l2;
  }
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(280442);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    paramCanvas.save();
    Object localObject = (g)p.ae(gKJ(), getCurIndex());
    if (localObject == null) {}
    for (localObject = null;; localObject = ((g)localObject).bitmap)
    {
      if (localObject != null)
      {
        gKy();
        gKx();
        paramPaint.setAlpha(getAlpha());
        paramCanvas.concat(getMatrix());
        s(paramCanvas);
        paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, getLYRICS_VERTICAL_OFFSET(), paramPaint);
        paramPaint.setAlpha(255);
      }
      paramCanvas.restore();
      AppMethodBeat.o(280442);
      return;
    }
  }
  
  protected final void gKx()
  {
    int j = 1;
    AppMethodBeat.i(280426);
    if (getCurIndex() < gKJ().size())
    {
      long l2 = ((g)gKJ().get(getCurIndex())).NZE.startTime;
      Object localObject = (g)p.ae(gKJ(), getCurIndex() + 1);
      long l1;
      label106:
      int i;
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          break label201;
        }
        l1 = ((g)gKJ().get(getCurIndex())).NZE.startTime + getLAST_INTERVAL();
        l3 = getTRANS_TIME();
        l4 = this.ood - l2;
        if (0L > l4) {
          break label215;
        }
        if (l4 > l3) {
          break label210;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label220;
        }
        setAlpha((int)((float)(this.ood - l2) * 255.0F / (float)getTRANS_TIME()));
        AppMethodBeat.o(280426);
        return;
        localObject = ((g)localObject).NZE;
        if (localObject == null)
        {
          localObject = null;
          break;
        }
        localObject = Long.valueOf(((dki)localObject).startTime);
        break;
        label201:
        l1 = ((Long)localObject).longValue();
        break label106;
        label210:
        i = 0;
        continue;
        label215:
        i = 0;
      }
      label220:
      long l3 = getTRANS_TIME();
      long l4 = l1 - this.ood;
      if (0L <= l4) {
        if (l4 <= l3) {
          i = j;
        }
      }
      while (i != 0)
      {
        setAlpha((int)((float)(l1 - this.ood) / (float)getTRANS_TIME() * 255.0F));
        AppMethodBeat.o(280426);
        return;
        i = 0;
        continue;
        i = 0;
      }
      if ((this.ood - l2 > getTRANS_TIME()) && (l1 - this.ood > getTRANS_TIME()))
      {
        setAlpha(255);
        AppMethodBeat.o(280426);
        return;
      }
      setAlpha(0);
    }
    AppMethodBeat.o(280426);
  }
  
  protected final void gKy()
  {
    AppMethodBeat.i(280434);
    if (gKJ().isEmpty())
    {
      AppMethodBeat.o(280434);
      return;
    }
    Object localObject = gKJ();
    localObject = ((List)localObject).listIterator(((List)localObject).size());
    if (((ListIterator)localObject).hasPrevious())
    {
      g localg = (g)((ListIterator)localObject).previous();
      if (this.ood >= localg.NZE.startTime)
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
      AppMethodBeat.o(280434);
      return;
      i = 0;
      break label77;
      label106:
      break;
    }
  }
  
  protected final void s(Canvas paramCanvas)
  {
    AppMethodBeat.i(280439);
    s.u(paramCanvas, "canvas");
    float f1;
    label87:
    RectF localRectF;
    if (!((Collection)gKJ()).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label376;
      }
      if ((getWaveTime() != 0L) && (this.ood - getWaveTime() <= gKK())) {
        break label299;
      }
      setWaveTime(this.ood);
      arrayOfRectF = gKR();
      i = 0;
      int k = arrayOfRectF.length;
      j = 0;
      f1 = 0.0F;
      if (j >= k) {
        break label299;
      }
      localRectF = arrayOfRectF[j];
      f2 = localRectF.height();
      if (f2 > gKN()) {
        break label253;
      }
      gKS()[i] = ((float)(gKM() * Math.random()));
      label134:
      if (f2 > gKS()[i]) {
        break label280;
      }
    }
    label280:
    for (float f2 = Math.min(f2 + gKP(), gKM());; f2 = Math.max(f2 - gKQ(), gKN()))
    {
      float f3 = gKO();
      float f4 = gKM() / 2.0F;
      float f5 = f2 / 2.0F;
      float f6 = gKO();
      float f7 = gKL();
      float f8 = gKM() / 2.0F;
      localRectF.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
      f1 = localRectF.right;
      j += 1;
      i += 1;
      break label87;
      i = 0;
      break;
      label253:
      if (f2 < gKS()[i]) {
        break label134;
      }
      gKS()[i] = gKN();
      break label134;
    }
    label299:
    tC(((g)gKJ().get(0)).NZE.startTime);
    getWavePaint().setAlpha(getWaveAlpha());
    RectF[] arrayOfRectF = gKR();
    int j = arrayOfRectF.length;
    int i = 0;
    while (i < j)
    {
      paramCanvas.drawRect(arrayOfRectF[i], getWavePaint());
      i += 1;
    }
    label376:
    AppMethodBeat.o(280439);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(280419);
    for (this.ood = paramLong; this.ood > getLastLrcTime(); this.ood -= getLastLrcTime()) {}
    super.seekTo(paramLong);
    AppMethodBeat.o(280419);
  }
  
  protected final void tC(long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(280430);
    if (getWaveAlpha() < 255)
    {
      long l1 = getTRANS_TIME();
      long l2 = gKG() - paramLong;
      int i = j;
      if (0L <= l2)
      {
        i = j;
        if (l2 <= l1) {
          i = 1;
        }
      }
      if (i != 0)
      {
        setWaveAlpha((int)(255.0F * (float)(this.ood - paramLong) / (float)getTRANS_TIME()));
        AppMethodBeat.o(280430);
        return;
      }
      if (this.ood - paramLong > getTRANS_TIME()) {
        setWaveAlpha(255);
      }
    }
    AppMethodBeat.o(280430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.f
 * JD-Core Version:    0.7.0.1
 */