package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.aq;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "lyricsBitmaps", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "DP_1", "", "LAST_INTERVAL", "", "LYRICS_PRE_NEXT", "LYRICS_VERTICAL_OFFSET", "", "TRANS_TIME", "WAVE_DECREMENT", "WAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "alpha", "curIndex", "duration", "getLyricsBitmaps", "()Ljava/util/List;", "waveAlpha", "wavePaint", "Landroid/graphics/Paint;", "getWavePaint", "()Landroid/graphics/Paint;", "setWavePaint", "(Landroid/graphics/Paint;)V", "waveRects", "", "Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "", "waveTime", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "drawWave", "fillAlpha", "fillWaveAlpha", "appearTime", "init", "nextIndex", "prepareNext", "plugin-recordvideo_release"})
public final class g
  extends a
{
  private int alpha;
  private long duration;
  private final int oKW;
  private int rko;
  private long xOH;
  private int xOI;
  private final long xOJ;
  private final long xOK;
  private final long xOL;
  private final int xOM;
  private final float xON;
  private final float xOO;
  private final int xOP;
  private final float xOQ;
  private final float xOR;
  private final float xOS;
  private final int xOT;
  private final RectF[] xOU;
  private final float[] xOV;
  private Paint xOZ;
  private final long xPA;
  private final List<f> xPB;
  
  public g(List<f> paramList, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(200769);
    this.xPB = paramList;
    this.xPA = 16L;
    this.xOJ = 50L;
    this.xOK = 200L;
    this.xOL = 3000L;
    this.xOM = 11;
    this.oKW = aq.fromDPToPix(aj.getContext(), 1);
    this.xON = (this.oKW * 1.5F);
    this.xOO = (this.oKW * 9.0F);
    this.xOP = this.oKW;
    this.xOQ = (this.oKW * 1.5F);
    this.xOR = (this.oKW * 12.0F);
    this.xOS = (this.oKW * 2.0F);
    this.xOT = this.oKW;
    int j = this.xOM;
    paramList = new RectF[j];
    int i = 0;
    while (i < j)
    {
      paramList[i] = new RectF();
      i += 1;
    }
    this.xOU = paramList;
    this.xOV = new float[this.xOM];
    this.xOZ = new Paint();
    AppMethodBeat.o(200769);
  }
  
  public final long dIg()
  {
    return this.xPA;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(200768);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    paramCanvas.save();
    Bitmap localBitmap = ((f)this.xPB.get(this.rko)).bitmap;
    if (localBitmap != null)
    {
      this.duration += this.pRV;
      Object localObject1 = (f)j.E(this.xPB, this.rko + 1);
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
        localObject1 = ((f)localObject1).xPz;
        if (localObject1 != null)
        {
          l1 = ((bwa)localObject1).startTime;
          if (this.duration >= l1)
          {
            this.rko += 1;
            if (this.rko >= this.xPB.size())
            {
              this.rko = 0;
              this.duration = 0L;
              this.xOH = 0L;
            }
          }
          if (this.rko < this.xPB.size())
          {
            l2 = ((f)this.xPB.get(this.rko)).xPz.startTime;
            localObject1 = (f)j.E(this.xPB, this.rko + 1);
            if (localObject1 == null) {
              break label597;
            }
            localObject1 = ((f)localObject1).xPz;
            if (localObject1 == null) {
              break label597;
            }
            l1 = ((bwa)localObject1).startTime;
            l3 = this.xOK;
            l4 = this.duration - l2;
            if (0L <= l4) {
              break label629;
            }
            l3 = this.xOK;
            l4 = l1 - this.duration;
            if (0L <= l4) {
              break label663;
            }
            if ((this.duration - l2 > this.xOK) && (l1 - this.duration > this.xOK)) {
              this.alpha = 255;
            }
          }
          paramPaint.setAlpha(this.alpha);
          paramCanvas.concat(this.gR);
          if (this.xPB.isEmpty()) {
            break label909;
          }
          if ((this.xOH != 0L) && (this.duration - this.xOH <= this.xOJ)) {
            break label746;
          }
          this.xOH = this.duration;
          localObject1 = this.xOU;
          i = 0;
          int k = localObject1.length;
          j = 0;
          f1 = 0.0F;
          if (j >= k) {
            break label746;
          }
          localObject2 = localObject1[j];
          f2 = localObject2.height();
          if (f2 > this.xOP) {
            break label697;
          }
          this.xOV[i] = ((float)(this.xOO * Math.random()));
          label447:
          if (f2 > this.xOV[i]) {
            break label725;
          }
        }
      }
      label663:
      label697:
      label725:
      for (float f2 = Math.min(f2 + this.xOS, this.xOO);; f2 = Math.max(f2 - this.xOT, this.xOP))
      {
        float f3 = this.xOQ;
        float f4 = this.xOO / 2.0F;
        float f5 = f2 / 2.0F;
        float f6 = this.xOQ;
        float f7 = this.xON;
        float f8 = this.xOO / 2.0F;
        localObject2.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
        f1 = localObject2.right;
        j += 1;
        i += 1;
        break label398;
        l1 = ((f)this.xPB.get(this.rko)).xPz.startTime + this.xOL;
        break;
        label597:
        l1 = ((f)this.xPB.get(this.rko)).xPz.startTime + this.xOL;
        break label236;
        label629:
        if (l3 < l4) {
          break label258;
        }
        this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.xOK));
        break label317;
        if (l3 < l4) {
          break label280;
        }
        this.alpha = ((int)((float)(l1 - this.duration) / (float)this.xOK * 255.0F));
        break label317;
        if (f2 < this.xOV[i]) {
          break label447;
        }
        this.xOV[i] = this.xOP;
        break label447;
      }
      label746:
      long l1 = ((f)this.xPB.get(0)).xPz.startTime;
      if (this.xOI < 255)
      {
        l2 = this.xOK;
        l3 = this.duration - l1;
        if (0L <= l3) {
          break label875;
        }
        if (this.duration - l1 <= this.xOK) {}
      }
      for (this.xOI = 255;; this.xOI = ((int)((float)(this.duration - l1) * 255.0F / (float)this.xOK)))
      {
        this.xOZ.setAlpha(this.xOI);
        localObject1 = this.xOU;
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          paramCanvas.drawRect(localObject1[i], this.xOZ);
          i += 1;
        }
        label875:
        if (l2 < l3) {
          break;
        }
      }
      label909:
      paramCanvas.drawBitmap(localBitmap, 0.0F, this.xOR, paramPaint);
      paramPaint.setAlpha(255);
    }
    paramCanvas.restore();
    AppMethodBeat.o(200768);
  }
  
  public final void init()
  {
    AppMethodBeat.i(200767);
    this.xOZ.setColor(Color.parseColor("#CCFFFFFF"));
    AppMethodBeat.o(200767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.g
 * JD-Core Version:    0.7.0.1
 */