package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.aq;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "lyricsBitmaps", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_PRE_NEXT", "LYRICS_VERTICAL_OFFSET", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "curIndex", "duration", "getLyricsBitmaps", "()Ljava/util/List;", "waveAlpha", "wavePaint", "Landroid/graphics/Paint;", "getWavePaint", "()Landroid/graphics/Paint;", "setWavePaint", "(Landroid/graphics/Paint;)V", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "", "waveTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "drawWave", "fillAlpha", "fillWaveAlpha", "appearTime", "init", "nextIndex", "prepareNext", "plugin-recordvideo_release"})
public final class g
  extends a
{
  private int alpha;
  private long duration;
  private final int oRy;
  private int rss;
  private long yeA;
  private int yeB;
  private final long yeC;
  private final long yeD;
  private final long yeE;
  private final int yeF;
  private final float yeG;
  private final float yeH;
  private final int yeI;
  private final float yeJ;
  private final float yeK;
  private final float yeL;
  private final int yeM;
  private final RectF[] yeN;
  private final float[] yeO;
  private Paint yeS;
  private final long yft;
  private final List<f> yfu;
  
  public g(List<f> paramList, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(207027);
    this.yfu = paramList;
    this.yft = 16L;
    this.yeC = 50L;
    this.yeD = 200L;
    this.yeE = 3000L;
    this.yeF = 11;
    this.oRy = aq.fromDPToPix(ak.getContext(), 1);
    this.yeG = (this.oRy * 1.5F);
    this.yeH = (this.oRy * 9.0F);
    this.yeI = this.oRy;
    this.yeJ = (this.oRy * 1.5F);
    this.yeK = (this.oRy * 12.0F);
    this.yeL = (this.oRy * 2.0F);
    this.yeM = this.oRy;
    int j = this.yeF;
    paramList = new RectF[j];
    int i = 0;
    while (i < j)
    {
      paramList[i] = new RectF();
      i += 1;
    }
    this.yeN = paramList;
    this.yeO = new float[this.yeF];
    this.yeS = new Paint();
    AppMethodBeat.o(207027);
  }
  
  public final long dLx()
  {
    return this.yft;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(207026);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    paramCanvas.save();
    Bitmap localBitmap = ((f)this.yfu.get(this.rss)).bitmap;
    if (localBitmap != null)
    {
      this.duration += this.pYA;
      Object localObject1 = (f)j.F(this.yfu, this.rss + 1);
      long l2;
      label236:
      long l3;
      long l4;
      label258:
      label280:
      label317:
      int i;
      int j;
      float f1;
      label398:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((f)localObject1).yfs;
        if (localObject1 != null)
        {
          l1 = ((bwu)localObject1).startTime;
          if (this.duration >= l1)
          {
            this.rss += 1;
            if (this.rss >= this.yfu.size())
            {
              this.rss = 0;
              this.duration = 0L;
              this.yeA = 0L;
            }
          }
          if (this.rss < this.yfu.size())
          {
            l2 = ((f)this.yfu.get(this.rss)).yfs.startTime;
            localObject1 = (f)j.F(this.yfu, this.rss + 1);
            if (localObject1 == null) {
              break label597;
            }
            localObject1 = ((f)localObject1).yfs;
            if (localObject1 == null) {
              break label597;
            }
            l1 = ((bwu)localObject1).startTime;
            l3 = this.yeD;
            l4 = this.duration - l2;
            if (0L <= l4) {
              break label629;
            }
            l3 = this.yeD;
            l4 = l1 - this.duration;
            if (0L <= l4) {
              break label663;
            }
            if ((this.duration - l2 > this.yeD) && (l1 - this.duration > this.yeD)) {
              this.alpha = 255;
            }
          }
          paramPaint.setAlpha(this.alpha);
          paramCanvas.concat(this.gR);
          if (this.yfu.isEmpty()) {
            break label909;
          }
          if ((this.yeA != 0L) && (this.duration - this.yeA <= this.yeC)) {
            break label746;
          }
          this.yeA = this.duration;
          localObject1 = this.yeN;
          i = 0;
          int k = localObject1.length;
          j = 0;
          f1 = 0.0F;
          if (j >= k) {
            break label746;
          }
          localObject2 = localObject1[j];
          f2 = localObject2.height();
          if (f2 > this.yeI) {
            break label697;
          }
          this.yeO[i] = ((float)(this.yeH * Math.random()));
          label447:
          if (f2 > this.yeO[i]) {
            break label725;
          }
        }
      }
      label663:
      label697:
      label725:
      for (float f2 = Math.min(f2 + this.yeL, this.yeH);; f2 = Math.max(f2 - this.yeM, this.yeI))
      {
        float f3 = this.yeJ;
        float f4 = this.yeH / 2.0F;
        float f5 = f2 / 2.0F;
        float f6 = this.yeJ;
        float f7 = this.yeG;
        float f8 = this.yeH / 2.0F;
        localObject2.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
        f1 = localObject2.right;
        j += 1;
        i += 1;
        break label398;
        l1 = ((f)this.yfu.get(this.rss)).yfs.startTime + this.yeE;
        break;
        label597:
        l1 = ((f)this.yfu.get(this.rss)).yfs.startTime + this.yeE;
        break label236;
        label629:
        if (l3 < l4) {
          break label258;
        }
        this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.yeD));
        break label317;
        if (l3 < l4) {
          break label280;
        }
        this.alpha = ((int)((float)(l1 - this.duration) / (float)this.yeD * 255.0F));
        break label317;
        if (f2 < this.yeO[i]) {
          break label447;
        }
        this.yeO[i] = this.yeI;
        break label447;
      }
      label746:
      long l1 = ((f)this.yfu.get(0)).yfs.startTime;
      if (this.yeB < 255)
      {
        l2 = this.yeD;
        l3 = this.duration - l1;
        if (0L <= l3) {
          break label875;
        }
        if (this.duration - l1 <= this.yeD) {}
      }
      for (this.yeB = 255;; this.yeB = ((int)((float)(this.duration - l1) * 255.0F / (float)this.yeD)))
      {
        this.yeS.setAlpha(this.yeB);
        localObject1 = this.yeN;
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          paramCanvas.drawRect(localObject1[i], this.yeS);
          i += 1;
        }
        label875:
        if (l2 < l3) {
          break;
        }
      }
      label909:
      paramCanvas.drawBitmap(localBitmap, 0.0F, this.yeK, paramPaint);
      paramPaint.setAlpha(255);
    }
    paramCanvas.restore();
    AppMethodBeat.o(207026);
  }
  
  public final void init()
  {
    AppMethodBeat.i(207025);
    this.yeS.setColor(Color.parseColor("#CCFFFFFF"));
    AppMethodBeat.o(207025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g
 * JD-Core Version:    0.7.0.1
 */