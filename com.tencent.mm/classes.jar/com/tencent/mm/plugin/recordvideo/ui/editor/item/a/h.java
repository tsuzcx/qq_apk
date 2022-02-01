package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "lyricsBitmaps", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "DP_1", "", "LAST_INTERVAL", "", "getLAST_INTERVAL", "()J", "LYRICS_PRE_NEXT", "LYRICS_VERTICAL_OFFSET", "", "getLYRICS_VERTICAL_OFFSET", "()F", "TRANS_TIME", "getTRANS_TIME", "WAVE_DECREMENT", "getWAVE_DECREMENT", "()I", "WAVE_INCREMENT", "getWAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "getWAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "getWAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "getWAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "getWAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "getWAVE_RECT_WIDTH", "alpha", "getAlpha", "setAlpha", "(I)V", "curIndex", "getCurIndex", "setCurIndex", "duration", "getLyricsBitmaps", "()Ljava/util/List;", "waveAlpha", "getWaveAlpha", "setWaveAlpha", "wavePaint", "Landroid/graphics/Paint;", "getWavePaint", "()Landroid/graphics/Paint;", "setWavePaint", "(Landroid/graphics/Paint;)V", "waveRects", "", "Landroid/graphics/RectF;", "getWaveRects", "()[Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "", "getWaveTargetHeight", "()[F", "waveTime", "getWaveTime", "setWaveTime", "(J)V", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "drawWave", "fillAlpha", "fillWaveAlpha", "appearTime", "init", "nextIndex", "prepareNext", "plugin-recordvideo_release"})
public class h
  extends a
{
  private final int IaA;
  private final float IaB;
  private final float IaC;
  private final RectF[] IaE;
  private final float[] IaF;
  private final float Iax;
  private final int Iay;
  private final float Iaz;
  private long IcA;
  private int IcB;
  private final long IcC;
  private final long IcD;
  private final long IcE;
  private final int IcF;
  private final float IcG;
  private Paint IcK;
  private final long Idj;
  private final List<g> Idk;
  private int alpha;
  private long duration;
  private final int tBj;
  private int wzx;
  
  public h(List<g> paramList, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(226349);
    this.Idk = paramList;
    this.Idj = 16L;
    this.IcC = 50L;
    this.IcD = 200L;
    this.IcE = 3000L;
    this.IcF = 11;
    this.tBj = aw.fromDPToPix(MMApplicationContext.getContext(), 1);
    this.Iax = (this.tBj * 1.5F);
    this.IaC = (this.tBj * 9.0F);
    this.Iay = this.tBj;
    this.IaB = (this.tBj * 1.5F);
    this.IcG = (this.tBj * 12.0F);
    this.Iaz = (this.tBj * 2.0F);
    this.IaA = this.tBj;
    int j = this.IcF;
    paramList = new RectF[j];
    int i = 0;
    while (i < j)
    {
      paramList[i] = new RectF();
      i += 1;
    }
    this.IaE = paramList;
    this.IaF = new float[this.IcF];
    this.IcK = new Paint();
    AppMethodBeat.o(226349);
  }
  
  protected void PC(long paramLong)
  {
    long l1;
    long l2;
    if (this.IcB < 255)
    {
      l1 = this.IcD;
      l2 = this.duration - paramLong;
      if (0L <= l2) {
        break label52;
      }
    }
    label52:
    while (l1 < l2)
    {
      if (this.duration - paramLong > this.IcD) {
        this.IcB = 255;
      }
      return;
    }
    this.IcB = ((int)(255.0F * (float)(this.duration - paramLong) / (float)this.IcD));
  }
  
  public final void destroy() {}
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(226342);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    paramCanvas.save();
    Bitmap localBitmap = ((g)this.Idk.get(this.wzx)).bitmap;
    if (localBitmap != null)
    {
      this.duration += fyS();
      fyM();
      fyL();
      paramPaint.setAlpha(this.alpha);
      paramCanvas.concat(fyW());
      x(paramCanvas);
      paramCanvas.drawBitmap(localBitmap, 0.0F, this.IcG, paramPaint);
      paramPaint.setAlpha(255);
    }
    paramCanvas.restore();
    AppMethodBeat.o(226342);
  }
  
  protected void fyL()
  {
    AppMethodBeat.i(226330);
    long l2;
    long l1;
    long l3;
    long l4;
    if (this.wzx < this.Idk.size())
    {
      l2 = ((g)this.Idk.get(this.wzx)).Idi.startTime;
      Object localObject = (g)j.M(this.Idk, this.wzx + 1);
      if (localObject == null) {
        break label170;
      }
      localObject = ((g)localObject).Idi;
      if (localObject == null) {
        break label170;
      }
      l1 = ((ctg)localObject).startTime;
      l3 = this.IcD;
      l4 = this.duration - l2;
      if (0L <= l4) {
        break label201;
      }
      label107:
      l3 = this.IcD;
      l4 = l1 - this.duration;
      if (0L <= l4) {
        break label237;
      }
    }
    label170:
    label201:
    label237:
    while (l3 < l4)
    {
      if ((this.duration - l2 > this.IcD) && (l1 - this.duration > this.IcD)) {
        this.alpha = 255;
      }
      AppMethodBeat.o(226330);
      return;
      l1 = ((g)this.Idk.get(this.wzx)).Idi.startTime + this.IcE;
      break;
      if (l3 < l4) {
        break label107;
      }
      this.alpha = ((int)((float)(this.duration - l2) * 255.0F / (float)this.IcD));
      AppMethodBeat.o(226330);
      return;
    }
    this.alpha = ((int)((float)(l1 - this.duration) / (float)this.IcD * 255.0F));
    AppMethodBeat.o(226330);
  }
  
  protected void fyM()
  {
    AppMethodBeat.i(226332);
    Object localObject = (g)j.M(this.Idk, this.wzx + 1);
    if (localObject != null)
    {
      localObject = ((g)localObject).Idi;
      if (localObject == null) {}
    }
    for (long l = ((ctg)localObject).startTime;; l = ((g)this.Idk.get(this.wzx)).Idi.startTime + this.IcE)
    {
      if (this.duration >= l)
      {
        this.wzx += 1;
        if (this.wzx >= this.Idk.size())
        {
          this.wzx = 0;
          this.duration = 0L;
          this.IcA = 0L;
        }
      }
      AppMethodBeat.o(226332);
      return;
    }
  }
  
  public final long fyV()
  {
    return this.Idj;
  }
  
  protected final long fyX()
  {
    return this.IcC;
  }
  
  protected final float fyY()
  {
    return this.Iax;
  }
  
  protected final float fyZ()
  {
    return this.IaC;
  }
  
  protected final int fza()
  {
    return this.Iay;
  }
  
  protected final float fzb()
  {
    return this.IaB;
  }
  
  protected final float fzc()
  {
    return this.Iaz;
  }
  
  protected final int fzd()
  {
    return this.IaA;
  }
  
  protected final RectF[] fze()
  {
    return this.IaE;
  }
  
  protected final float[] fzf()
  {
    return this.IaF;
  }
  
  public final List<g> fzg()
  {
    return this.Idk;
  }
  
  protected final int getAlpha()
  {
    return this.alpha;
  }
  
  protected final int getCurIndex()
  {
    return this.wzx;
  }
  
  protected final long getLAST_INTERVAL()
  {
    return this.IcE;
  }
  
  protected final float getLYRICS_VERTICAL_OFFSET()
  {
    return this.IcG;
  }
  
  protected final long getTRANS_TIME()
  {
    return this.IcD;
  }
  
  protected final int getWaveAlpha()
  {
    return this.IcB;
  }
  
  public final Paint getWavePaint()
  {
    return this.IcK;
  }
  
  protected final long getWaveTime()
  {
    return this.IcA;
  }
  
  public final void init()
  {
    AppMethodBeat.i(226339);
    this.IcK.setColor(Color.parseColor("#CCFFFFFF"));
    AppMethodBeat.o(226339);
  }
  
  protected final void setAlpha(int paramInt)
  {
    this.alpha = paramInt;
  }
  
  protected final void setCurIndex(int paramInt)
  {
    this.wzx = paramInt;
  }
  
  protected final void setWaveAlpha(int paramInt)
  {
    this.IcB = paramInt;
  }
  
  protected final void setWaveTime(long paramLong)
  {
    this.IcA = paramLong;
  }
  
  protected void x(Canvas paramCanvas)
  {
    AppMethodBeat.i(226337);
    p.k(paramCanvas, "canvas");
    if (!this.Idk.isEmpty())
    {
      if ((this.IcA == 0L) || (this.duration - this.IcA > this.IcC))
      {
        this.IcA = this.duration;
        arrayOfRectF = this.IaE;
        i = 0;
        int k = arrayOfRectF.length;
        j = 0;
        float f1 = 0.0F;
        if (j < k)
        {
          RectF localRectF = arrayOfRectF[j];
          float f2 = localRectF.height();
          if (f2 <= this.Iay)
          {
            this.IaF[i] = ((float)(this.IaC * Math.random()));
            label124:
            if (f2 > this.IaF[i]) {
              break label264;
            }
          }
          label264:
          for (f2 = Math.min(f2 + this.Iaz, this.IaC);; f2 = Math.max(f2 - this.IaA, this.Iay))
          {
            float f3 = this.IaB;
            float f4 = this.IaC / 2.0F;
            float f5 = f2 / 2.0F;
            float f6 = this.IaB;
            float f7 = this.Iax;
            float f8 = this.IaC / 2.0F;
            localRectF.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
            f1 = localRectF.right;
            j += 1;
            i += 1;
            break;
            if (f2 < this.IaF[i]) {
              break label124;
            }
            this.IaF[i] = this.Iay;
            break label124;
          }
        }
      }
      PC(((g)this.Idk.get(0)).Idi.startTime);
      this.IcK.setAlpha(this.IcB);
      RectF[] arrayOfRectF = this.IaE;
      int j = arrayOfRectF.length;
      int i = 0;
      while (i < j)
      {
        paramCanvas.drawRect(arrayOfRectF[i], this.IcK);
        i += 1;
      }
    }
    AppMethodBeat.o(226337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.h
 * JD-Core Version:    0.7.0.1
 */