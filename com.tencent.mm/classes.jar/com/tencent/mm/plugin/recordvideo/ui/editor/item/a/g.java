package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "lyricsBitmaps", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_PRE_NEXT", "LYRICS_VERTICAL_OFFSET", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "curIndex", "duration", "getLyricsBitmaps", "()Ljava/util/List;", "waveAlpha", "wavePaint", "Landroid/graphics/Paint;", "getWavePaint", "()Landroid/graphics/Paint;", "setWavePaint", "(Landroid/graphics/Paint;)V", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "", "waveTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "drawWave", "fillAlpha", "fillWaveAlpha", "appearTime", "init", "nextIndex", "prepareNext", "plugin-recordvideo_release"})
public final class g
  extends a
{
  private long CfC;
  private int CfD;
  private final long CfE;
  private final long CfF;
  private final long CfG;
  private final int CfH;
  private final float CfI;
  private final float CfJ;
  private final int CfK;
  private final float CfL;
  private final float CfM;
  private final float CfN;
  private final int CfO;
  private final RectF[] CfP;
  private final float[] CfQ;
  private Paint CfU;
  private final long Cgs;
  private final List<f> Cgt;
  private int alpha;
  private long duration;
  private final int qfm;
  private int sTB;
  
  public g(List<f> paramList, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(237868);
    this.Cgt = paramList;
    this.Cgs = 16L;
    this.CfE = 50L;
    this.CfF = 200L;
    this.CfG = 3000L;
    this.CfH = 11;
    this.qfm = at.fromDPToPix(MMApplicationContext.getContext(), 1);
    this.CfI = (this.qfm * 1.5F);
    this.CfJ = (this.qfm * 9.0F);
    this.CfK = this.qfm;
    this.CfL = (this.qfm * 1.5F);
    this.CfM = (this.qfm * 12.0F);
    this.CfN = (this.qfm * 2.0F);
    this.CfO = this.qfm;
    int j = this.CfH;
    paramList = new RectF[j];
    int i = 0;
    while (i < j)
    {
      paramList[i] = new RectF();
      i += 1;
    }
    this.CfP = paramList;
    this.CfQ = new float[this.CfH];
    this.CfU = new Paint();
    AppMethodBeat.o(237868);
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(237867);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    paramCanvas.save();
    Bitmap localBitmap = ((f)this.Cgt.get(this.sTB)).bitmap;
    if (localBitmap != null)
    {
      this.duration += this.rpy;
      Object localObject1 = (f)j.L(this.Cgt, this.sTB + 1);
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
        localObject1 = ((f)localObject1).Cgr;
        if (localObject1 != null)
        {
          l1 = ((ckm)localObject1).startTime;
          if (this.duration >= l1)
          {
            this.sTB += 1;
            if (this.sTB >= this.Cgt.size())
            {
              this.sTB = 0;
              this.duration = 0L;
              this.CfC = 0L;
            }
          }
          if (this.sTB < this.Cgt.size())
          {
            l2 = ((f)this.Cgt.get(this.sTB)).Cgr.startTime;
            localObject1 = (f)j.L(this.Cgt, this.sTB + 1);
            if (localObject1 == null) {
              break label597;
            }
            localObject1 = ((f)localObject1).Cgr;
            if (localObject1 == null) {
              break label597;
            }
            l1 = ((ckm)localObject1).startTime;
            l3 = this.CfF;
            l4 = this.duration - l2;
            if (0L <= l4) {
              break label629;
            }
            l3 = this.CfF;
            l4 = l1 - this.duration;
            if (0L <= l4) {
              break label663;
            }
            if ((this.duration - l2 > this.CfF) && (l1 - this.duration > this.CfF)) {
              this.alpha = 255;
            }
          }
          paramPaint.setAlpha(this.alpha);
          paramCanvas.concat(this.gT);
          if (this.Cgt.isEmpty()) {
            break label909;
          }
          if ((this.CfC != 0L) && (this.duration - this.CfC <= this.CfE)) {
            break label746;
          }
          this.CfC = this.duration;
          localObject1 = this.CfP;
          i = 0;
          int k = localObject1.length;
          j = 0;
          f1 = 0.0F;
          if (j >= k) {
            break label746;
          }
          localObject2 = localObject1[j];
          f2 = localObject2.height();
          if (f2 > this.CfK) {
            break label697;
          }
          this.CfQ[i] = ((float)(this.CfJ * Math.random()));
          label447:
          if (f2 > this.CfQ[i]) {
            break label725;
          }
        }
      }
      label663:
      label697:
      label725:
      for (float f2 = Math.min(f2 + this.CfN, this.CfJ);; f2 = Math.max(f2 - this.CfO, this.CfK))
      {
        float f3 = this.CfL;
        float f4 = this.CfJ / 2.0F;
        float f5 = f2 / 2.0F;
        float f6 = this.CfL;
        float f7 = this.CfI;
        float f8 = this.CfJ / 2.0F;
        localObject2.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
        f1 = localObject2.right;
        j += 1;
        i += 1;
        break label398;
        l1 = ((f)this.Cgt.get(this.sTB)).Cgr.startTime + this.CfG;
        break;
        label597:
        l1 = ((f)this.Cgt.get(this.sTB)).Cgr.startTime + this.CfG;
        break label236;
        label629:
        if (l3 < l4) {
          break label258;
        }
        this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.CfF));
        break label317;
        if (l3 < l4) {
          break label280;
        }
        this.alpha = ((int)((float)(l1 - this.duration) / (float)this.CfF * 255.0F));
        break label317;
        if (f2 < this.CfQ[i]) {
          break label447;
        }
        this.CfQ[i] = this.CfK;
        break label447;
      }
      label746:
      long l1 = ((f)this.Cgt.get(0)).Cgr.startTime;
      if (this.CfD < 255)
      {
        l2 = this.CfF;
        l3 = this.duration - l1;
        if (0L <= l3) {
          break label875;
        }
        if (this.duration - l1 <= this.CfF) {}
      }
      for (this.CfD = 255;; this.CfD = ((int)((float)(this.duration - l1) * 255.0F / (float)this.CfF)))
      {
        this.CfU.setAlpha(this.CfD);
        localObject1 = this.CfP;
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          paramCanvas.drawRect(localObject1[i], this.CfU);
          i += 1;
        }
        label875:
        if (l2 < l3) {
          break;
        }
      }
      label909:
      paramCanvas.drawBitmap(localBitmap, 0.0F, this.CfM, paramPaint);
      paramPaint.setAlpha(255);
    }
    paramCanvas.restore();
    AppMethodBeat.o(237867);
  }
  
  public final long eMv()
  {
    return this.Cgs;
  }
  
  public final void init()
  {
    AppMethodBeat.i(237866);
    this.CfU.setColor(Color.parseColor("#CCFFFFFF"));
    AppMethodBeat.o(237866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g
 * JD-Core Version:    0.7.0.1
 */