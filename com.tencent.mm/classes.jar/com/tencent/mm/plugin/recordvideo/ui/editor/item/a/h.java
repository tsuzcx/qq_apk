package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "lyricsBitmaps", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/LyricsEditorInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "DP_1", "", "LAST_INTERVAL", "", "getLAST_INTERVAL", "()J", "LYRICS_PRE_NEXT", "LYRICS_VERTICAL_OFFSET", "", "getLYRICS_VERTICAL_OFFSET", "()F", "TRANS_TIME", "getTRANS_TIME", "WAVE_DECREMENT", "getWAVE_DECREMENT", "()I", "WAVE_INCREMENT", "getWAVE_INCREMENT", "WAVE_INVALIDAT_INTERVAL", "getWAVE_INVALIDAT_INTERVAL", "WAVE_RECT_COUNT", "WAVE_RECT_HEIGHT", "getWAVE_RECT_HEIGHT", "WAVE_RECT_MIN_HEIGHT", "getWAVE_RECT_MIN_HEIGHT", "WAVE_RECT_OFFSET", "getWAVE_RECT_OFFSET", "WAVE_RECT_WIDTH", "getWAVE_RECT_WIDTH", "alpha", "getAlpha", "setAlpha", "(I)V", "curIndex", "getCurIndex", "setCurIndex", "duration", "getLyricsBitmaps", "()Ljava/util/List;", "waveAlpha", "getWaveAlpha", "setWaveAlpha", "wavePaint", "Landroid/graphics/Paint;", "getWavePaint", "()Landroid/graphics/Paint;", "setWavePaint", "(Landroid/graphics/Paint;)V", "waveRects", "", "Landroid/graphics/RectF;", "getWaveRects", "()[Landroid/graphics/RectF;", "[Landroid/graphics/RectF;", "waveTargetHeight", "", "getWaveTargetHeight", "()[F", "waveTime", "getWaveTime", "setWaveTime", "(J)V", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "drawWave", "fillAlpha", "fillWaveAlpha", "appearTime", "init", "nextIndex", "prepareNext", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public class h
  extends a
{
  private final float NWY;
  private final int NWZ;
  private final float NXa;
  private final int NXb;
  private final float NXc;
  private final float NXd;
  private final RectF[] NXf;
  private final float[] NXg;
  private long NYW;
  private int NYX;
  private final long NYY;
  private final long NYZ;
  private final List<g> NZF;
  private final long NZG;
  private final long NZa;
  private final int NZb;
  private final float NZc;
  private Paint NZg;
  private int alpha;
  private long duration;
  private final int wFI;
  private int zVI;
  
  public h(List<g> paramList, Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(280400);
    this.NZF = paramList;
    this.NZG = 16L;
    this.NYY = 50L;
    this.NYZ = 200L;
    this.NZa = 3000L;
    this.NZb = 11;
    this.wFI = bd.fromDPToPix(MMApplicationContext.getContext(), 1);
    this.NWY = (this.wFI * 1.5F);
    this.NXd = (this.wFI * 9.0F);
    this.NWZ = this.wFI;
    this.NXc = (this.wFI * 1.5F);
    this.NZc = (this.wFI * 12.0F);
    this.NXa = (this.wFI * 2.0F);
    this.NXb = this.wFI;
    int i = 0;
    int j = this.NZb;
    paramList = new RectF[j];
    while (i < j)
    {
      paramList[i] = new RectF();
      i += 1;
    }
    this.NXf = paramList;
    this.NXg = new float[this.NZb];
    this.NZg = new Paint();
    AppMethodBeat.o(280400);
  }
  
  public final void destroy() {}
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(280497);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    paramCanvas.save();
    Bitmap localBitmap = ((g)this.NZF.get(this.zVI)).bitmap;
    if (localBitmap != null)
    {
      this.duration += gKF();
      gKy();
      gKx();
      paramPaint.setAlpha(this.alpha);
      paramCanvas.concat(getMatrix());
      s(paramCanvas);
      paramCanvas.drawBitmap(localBitmap, 0.0F, this.NZc, paramPaint);
      paramPaint.setAlpha(255);
    }
    paramCanvas.restore();
    AppMethodBeat.o(280497);
  }
  
  public final long gKI()
  {
    return this.NZG;
  }
  
  public final List<g> gKJ()
  {
    return this.NZF;
  }
  
  protected final long gKK()
  {
    return this.NYY;
  }
  
  protected final float gKL()
  {
    return this.NWY;
  }
  
  protected final float gKM()
  {
    return this.NXd;
  }
  
  protected final int gKN()
  {
    return this.NWZ;
  }
  
  protected final float gKO()
  {
    return this.NXc;
  }
  
  protected final float gKP()
  {
    return this.NXa;
  }
  
  protected final int gKQ()
  {
    return this.NXb;
  }
  
  protected final RectF[] gKR()
  {
    return this.NXf;
  }
  
  protected final float[] gKS()
  {
    return this.NXg;
  }
  
  protected void gKx()
  {
    AppMethodBeat.i(280476);
    if (this.zVI < this.NZF.size())
    {
      long l2 = ((g)this.NZF.get(this.zVI)).NZE.startTime;
      Object localObject = (g)p.ae(this.NZF, this.zVI + 1);
      long l1;
      label105:
      int i;
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          break label187;
        }
        l1 = ((g)this.NZF.get(this.zVI)).NZE.startTime + this.NZa;
        l3 = this.NYZ;
        l4 = this.duration - l2;
        if (0L > l4) {
          break label201;
        }
        if (l4 > l3) {
          break label196;
        }
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label206;
        }
        this.alpha = ((int)(255.0F * (float)(this.duration - l2) / (float)this.NYZ));
        AppMethodBeat.o(280476);
        return;
        localObject = Long.valueOf(((g)localObject).NZE.startTime);
        break;
        label187:
        l1 = ((Long)localObject).longValue();
        break label105;
        label196:
        i = 0;
        continue;
        label201:
        i = 0;
      }
      label206:
      long l3 = this.NYZ;
      long l4 = l1 - this.duration;
      if (0L <= l4) {
        if (l4 <= l3) {
          i = 1;
        }
      }
      while (i != 0)
      {
        this.alpha = ((int)((float)(l1 - this.duration) / (float)this.NYZ * 255.0F));
        AppMethodBeat.o(280476);
        return;
        i = 0;
        continue;
        i = 0;
      }
      if ((this.duration - l2 > this.NYZ) && (l1 - this.duration > this.NYZ)) {
        this.alpha = 255;
      }
    }
    AppMethodBeat.o(280476);
  }
  
  protected void gKy()
  {
    AppMethodBeat.i(280480);
    Object localObject = (g)p.ae(this.NZF, this.zVI + 1);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label132;
      }
    }
    label132:
    for (long l = ((g)this.NZF.get(this.zVI)).NZE.startTime + this.NZa;; l = ((Long)localObject).longValue())
    {
      if (this.duration >= l)
      {
        this.zVI += 1;
        if (this.zVI >= this.NZF.size())
        {
          this.zVI = 0;
          this.duration = 0L;
          this.NYW = 0L;
        }
      }
      AppMethodBeat.o(280480);
      return;
      localObject = Long.valueOf(((g)localObject).NZE.startTime);
      break;
    }
  }
  
  protected final int getAlpha()
  {
    return this.alpha;
  }
  
  protected final int getCurIndex()
  {
    return this.zVI;
  }
  
  protected final long getLAST_INTERVAL()
  {
    return this.NZa;
  }
  
  protected final float getLYRICS_VERTICAL_OFFSET()
  {
    return this.NZc;
  }
  
  protected final long getTRANS_TIME()
  {
    return this.NYZ;
  }
  
  protected final int getWaveAlpha()
  {
    return this.NYX;
  }
  
  public final Paint getWavePaint()
  {
    return this.NZg;
  }
  
  protected final long getWaveTime()
  {
    return this.NYW;
  }
  
  public final void init()
  {
    AppMethodBeat.i(280492);
    this.NZg.setColor(Color.parseColor("#CCFFFFFF"));
    AppMethodBeat.o(280492);
  }
  
  protected void s(Canvas paramCanvas)
  {
    AppMethodBeat.i(280487);
    s.u(paramCanvas, "canvas");
    if (!this.NZF.isEmpty())
    {
      if ((this.NYW == 0L) || (this.duration - this.NYW > this.NYY))
      {
        this.NYW = this.duration;
        arrayOfRectF = this.NXf;
        i = 0;
        int k = arrayOfRectF.length;
        j = 0;
        float f1 = 0.0F;
        if (j < k)
        {
          RectF localRectF = arrayOfRectF[j];
          float f2 = localRectF.height();
          if (f2 <= this.NWZ)
          {
            this.NXg[i] = ((float)(this.NXd * Math.random()));
            label124:
            if (f2 > this.NXg[i]) {
              break label264;
            }
          }
          label264:
          for (f2 = Math.min(f2 + this.NXa, this.NXd);; f2 = Math.max(f2 - this.NXb, this.NWZ))
          {
            float f3 = this.NXc;
            float f4 = this.NXd / 2.0F;
            float f5 = f2 / 2.0F;
            float f6 = this.NXc;
            float f7 = this.NWY;
            float f8 = this.NXd / 2.0F;
            localRectF.set(f3 + f1, f4 - f5, f1 + f6 + f7, f2 / 2.0F + f8);
            f1 = localRectF.right;
            j += 1;
            i += 1;
            break;
            if (f2 < this.NXg[i]) {
              break label124;
            }
            this.NXg[i] = this.NWZ;
            break label124;
          }
        }
      }
      tC(((g)this.NZF.get(0)).NZE.startTime);
      this.NZg.setAlpha(this.NYX);
      RectF[] arrayOfRectF = this.NXf;
      int j = arrayOfRectF.length;
      int i = 0;
      while (i < j)
      {
        paramCanvas.drawRect(arrayOfRectF[i], this.NZg);
        i += 1;
      }
    }
    AppMethodBeat.o(280487);
  }
  
  protected final void setAlpha(int paramInt)
  {
    this.alpha = paramInt;
  }
  
  protected final void setCurIndex(int paramInt)
  {
    this.zVI = paramInt;
  }
  
  protected final void setWaveAlpha(int paramInt)
  {
    this.NYX = paramInt;
  }
  
  protected final void setWaveTime(long paramLong)
  {
    this.NYW = paramLong;
  }
  
  protected void tC(long paramLong)
  {
    int j = 0;
    if (this.NYX < 255)
    {
      long l1 = this.NYZ;
      long l2 = this.duration - paramLong;
      int i = j;
      if (0L <= l2)
      {
        i = j;
        if (l2 <= l1) {
          i = 1;
        }
      }
      if (i == 0) {
        break label77;
      }
      this.NYX = ((int)(255.0F * (float)(this.duration - paramLong) / (float)this.NYZ));
    }
    label77:
    while (this.duration - paramLong <= this.NYZ) {
      return;
    }
    this.NYX = 255;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.h
 * JD-Core Version:    0.7.0.1
 */