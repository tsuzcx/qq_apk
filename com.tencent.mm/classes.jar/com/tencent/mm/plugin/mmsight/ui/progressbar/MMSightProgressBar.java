package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MMSightProgressBar
  extends View
{
  public static final int jGD = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 3);
  public static final int mre = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 5);
  private static final int[] mrf = { -1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340") };
  private boolean bSr = false;
  private int centerX = 0;
  private int centerY = 0;
  private Paint gaZ;
  private ah handler = null;
  private List<a> mrg = new ArrayList(5);
  private int mrh = 0;
  private b mri;
  private boolean mrj = false;
  private MMSightProgressBar.a mrk;
  
  public MMSightProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MMSightProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.gaZ = new Paint();
    this.gaZ.setColor(-65536);
    this.gaZ.setAntiAlias(true);
    this.handler = new MMSightProgressBar.1(this, Looper.getMainLooper());
    Log.i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", new Object[] { Integer.valueOf(jGD), Integer.valueOf(mre) });
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j;
    int k;
    Object localObject1;
    if ((this.bSr) && ((this.centerX <= 0) || (this.centerY <= 0)))
    {
      i = getLeft();
      j = getRight();
      k = getTop();
      int m = getBottom();
      this.centerX = ((j - i) / 2);
      this.centerY = ((m - k) / 2);
      Log.i("MicroMsg.MMSightProgressBar", "left: %s, right: %s, top: %s, bottom: %s, centerX: %s, centerY: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(this.centerX), Integer.valueOf(this.centerY) });
      Log.i("MicroMsg.MMSightProgressBar", "add init point");
      localObject1 = new a(0, this.centerX, this.centerY, -1);
      this.mrg.add(localObject1);
    }
    int i = paramCanvas.save();
    this.mrh = this.mrg.size();
    float f1;
    float f3;
    if (this.mrh % 2 == 0)
    {
      f1 = -(mre / 2.0F + (this.mrh / 2 - 1) * mre + this.mrh / 2 * jGD);
      f2 = f1;
      if (this.mri != null)
      {
        f2 = f1;
        if (this.mri.mrt)
        {
          j = this.mrh + 1;
          if (j % 2 != 0) {
            break label1176;
          }
          f2 = mre / 2.0F;
          f3 = (j / 2 - 1) * mre;
        }
      }
    }
    for (float f2 = -(j / 2 * jGD + (f2 + f3));; f2 = -(j / 2 * jGD + (f2 + f3)))
    {
      Log.d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.mri.progress) });
      f3 = this.mri.progress / 100.0F;
      f2 = f1 - (Math.abs(f2) - Math.abs(f1)) * f3;
      Log.d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", new Object[] { Float.valueOf(f2), Integer.valueOf(this.mrh) });
      paramCanvas.translate(f2, 0.0F);
      Object localObject2;
      Object localObject3;
      if ((this.mri != null) && (this.mri.mrt))
      {
        localObject2 = this.mri;
        localObject1 = this.gaZ;
        f1 = (mre + jGD * 2) * (((b)localObject2).progress / 100.0F);
        y.d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", new Object[] { Float.valueOf(((b)localObject2).progress), Float.valueOf(f1) });
        if (((b)localObject2).mrB > ((b)localObject2).mrD)
        {
          f2 = ((b)localObject2).mrr.mrn - jGD;
          f3 = ((b)localObject2).mrr.mro - jGD;
          ((Paint)localObject1).setColor(((b)localObject2).mrs.color);
          ((b)localObject2).mrF.reset();
          ((b)localObject2).mrF.moveTo(((b)localObject2).mrv.x + f2, ((b)localObject2).mrv.y + f3);
          ((b)localObject2).mrF.quadTo(((b)localObject2).mrw.x + f2, ((b)localObject2).mrw.y + f3, ((b)localObject2).mrx.x + f2, ((b)localObject2).mrx.y + f3);
          ((b)localObject2).mrF.lineTo(((b)localObject2).mrA.x + f2, ((b)localObject2).mrA.y + f3);
          ((b)localObject2).mrF.quadTo(((b)localObject2).mrz.x + f2, ((b)localObject2).mrz.y + f3, ((b)localObject2).mry.x + f2, f3 + ((b)localObject2).mry.y);
          if (((b)localObject2).mrs.color != ((b)localObject2).mrr.color)
          {
            f3 = ((b)localObject2).mrv.x;
            float f4 = ((b)localObject2).mrr.mro;
            float f5 = jGD;
            float f6 = ((b)localObject2).mrx.x;
            float f7 = ((b)localObject2).mrr.mro;
            float f8 = jGD;
            j = ((b)localObject2).mrr.color;
            k = ((b)localObject2).mrs.color;
            localObject3 = Shader.TileMode.REPEAT;
            ((Paint)localObject1).setShader(new LinearGradient(f3 + f2, f4 - f5, f2 + f6, f7 - f8, new int[] { j, k }, null, (Shader.TileMode)localObject3));
          }
          paramCanvas.drawPath(((b)localObject2).mrF, (Paint)localObject1);
          ((Paint)localObject1).setShader(null);
        }
        localObject2 = ((b)localObject2).mrs;
        ((Paint)localObject1).setColor(((a)localObject2).color);
        ((a)localObject2).mro = ((a)localObject2).mrq;
        ((a)localObject2).mrn = (((a)localObject2).mrp + (((a)localObject2).index - 1) * (mre + jGD * 2) + f1);
        Log.d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", new Object[] { Integer.valueOf(((a)localObject2).index), Float.valueOf(f1), Float.valueOf(((a)localObject2).mrn) });
        paramCanvas.drawCircle(((a)localObject2).mrn, ((a)localObject2).mro, jGD, (Paint)localObject1);
        ((Paint)localObject1).setShader(null);
      }
      localObject1 = this.mrg.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        localObject3 = this.gaZ;
        ((Paint)localObject3).setColor(((a)localObject2).color);
        ((a)localObject2).mrn = (((a)localObject2).mrp + ((a)localObject2).index * (mre + jGD * 2));
        ((a)localObject2).mro = ((a)localObject2).mrq;
        Log.d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", new Object[] { Integer.valueOf(((a)localObject2).index), Float.valueOf(((a)localObject2).mrn) });
        paramCanvas.drawCircle(((a)localObject2).mrn, ((a)localObject2).mro, jGD, (Paint)localObject3);
        ((Paint)localObject3).setShader(null);
      }
      f1 = -(jGD / 2.0F + this.mrh / 2 * mre + this.mrh / 2 * jGD);
      break;
      label1176:
      f2 = jGD / 2.0F;
      f3 = j / 2 * mre;
    }
    paramCanvas.restoreToCount(i);
    if ((this.bSr) && (!this.mrj) && (this.mrg.size() > 0))
    {
      Log.i("MicroMsg.MMSightProgressBar", "start handler loop");
      this.mrj = true;
      this.handler.sendEmptyMessage(233);
    }
  }
  
  public void setProgressCallback(MMSightProgressBar.a parama)
  {
    this.mrk = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar
 * JD-Core Version:    0.7.0.1
 */