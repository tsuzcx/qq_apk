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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MMSightProgressBar
  extends View
{
  public static final int lQb;
  public static final int oQS;
  private static final int[] oQT;
  private int centerX;
  private int centerY;
  private ak handler;
  private boolean isStart;
  private List<a> oQU;
  private int oQV;
  private b oQW;
  private boolean oQX;
  private MMSightProgressBar.a oQY;
  private Paint paint;
  
  static
  {
    AppMethodBeat.i(55340);
    lQb = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 3);
    oQS = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 5);
    oQT = new int[] { -1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340") };
    AppMethodBeat.o(55340);
  }
  
  public MMSightProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55336);
    this.oQU = new ArrayList(5);
    this.oQV = 0;
    this.centerX = 0;
    this.centerY = 0;
    this.handler = null;
    this.isStart = false;
    this.oQX = false;
    init();
    AppMethodBeat.o(55336);
  }
  
  public MMSightProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55337);
    this.oQU = new ArrayList(5);
    this.oQV = 0;
    this.centerX = 0;
    this.centerY = 0;
    this.handler = null;
    this.isStart = false;
    this.oQX = false;
    init();
    AppMethodBeat.o(55337);
  }
  
  private void init()
  {
    AppMethodBeat.i(55338);
    this.paint = new Paint();
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    this.handler = new MMSightProgressBar.1(this, Looper.getMainLooper());
    Log.i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", new Object[] { Integer.valueOf(lQb), Integer.valueOf(oQS) });
    AppMethodBeat.o(55338);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55339);
    super.onDraw(paramCanvas);
    int j;
    int k;
    Object localObject1;
    if ((this.isStart) && ((this.centerX <= 0) || (this.centerY <= 0)))
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
      this.oQU.add(localObject1);
    }
    int i = paramCanvas.save();
    this.oQV = this.oQU.size();
    float f1;
    float f3;
    if (this.oQV % 2 == 0)
    {
      f1 = -(oQS / 2.0F + (this.oQV / 2 - 1) * oQS + this.oQV / 2 * lQb);
      f2 = f1;
      if (this.oQW != null)
      {
        f2 = f1;
        if (this.oQW.oRh)
        {
          j = this.oQV + 1;
          if (j % 2 != 0) {
            break label1181;
          }
          f2 = oQS / 2.0F;
          f3 = (j / 2 - 1) * oQS;
        }
      }
    }
    for (float f2 = -(j / 2 * lQb + (f2 + f3));; f2 = -(j / 2 * lQb + (f2 + f3)))
    {
      Log.d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.oQW.progress) });
      f3 = this.oQW.progress / 100.0F;
      f2 = f1 - (Math.abs(f2) - Math.abs(f1)) * f3;
      Log.d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", new Object[] { Float.valueOf(f2), Integer.valueOf(this.oQV) });
      paramCanvas.translate(f2, 0.0F);
      Object localObject2;
      Object localObject3;
      if ((this.oQW != null) && (this.oQW.oRh))
      {
        localObject2 = this.oQW;
        localObject1 = this.paint;
        f1 = (oQS + lQb * 2) * (((b)localObject2).progress / 100.0F);
        ab.d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", new Object[] { Float.valueOf(((b)localObject2).progress), Float.valueOf(f1) });
        if (((b)localObject2).oRp > ((b)localObject2).oRr)
        {
          f2 = ((b)localObject2).oRf.oRb - lQb;
          f3 = ((b)localObject2).oRf.oRc - lQb;
          ((Paint)localObject1).setColor(((b)localObject2).oRg.color);
          ((b)localObject2).oRt.reset();
          ((b)localObject2).oRt.moveTo(((b)localObject2).oRj.x + f2, ((b)localObject2).oRj.y + f3);
          ((b)localObject2).oRt.quadTo(((b)localObject2).oRk.x + f2, ((b)localObject2).oRk.y + f3, ((b)localObject2).oRl.x + f2, ((b)localObject2).oRl.y + f3);
          ((b)localObject2).oRt.lineTo(((b)localObject2).oRo.x + f2, ((b)localObject2).oRo.y + f3);
          ((b)localObject2).oRt.quadTo(((b)localObject2).oRn.x + f2, ((b)localObject2).oRn.y + f3, ((b)localObject2).oRm.x + f2, f3 + ((b)localObject2).oRm.y);
          if (((b)localObject2).oRg.color != ((b)localObject2).oRf.color)
          {
            f3 = ((b)localObject2).oRj.x;
            float f4 = ((b)localObject2).oRf.oRc;
            float f5 = lQb;
            float f6 = ((b)localObject2).oRl.x;
            float f7 = ((b)localObject2).oRf.oRc;
            float f8 = lQb;
            j = ((b)localObject2).oRf.color;
            k = ((b)localObject2).oRg.color;
            localObject3 = Shader.TileMode.REPEAT;
            ((Paint)localObject1).setShader(new LinearGradient(f3 + f2, f4 - f5, f2 + f6, f7 - f8, new int[] { j, k }, null, (Shader.TileMode)localObject3));
          }
          paramCanvas.drawPath(((b)localObject2).oRt, (Paint)localObject1);
          ((Paint)localObject1).setShader(null);
        }
        localObject2 = ((b)localObject2).oRg;
        ((Paint)localObject1).setColor(((a)localObject2).color);
        ((a)localObject2).oRc = ((a)localObject2).oRe;
        ((a)localObject2).oRb = (((a)localObject2).oRd + (((a)localObject2).index - 1) * (oQS + lQb * 2) + f1);
        Log.d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", new Object[] { Integer.valueOf(((a)localObject2).index), Float.valueOf(f1), Float.valueOf(((a)localObject2).oRb) });
        paramCanvas.drawCircle(((a)localObject2).oRb, ((a)localObject2).oRc, lQb, (Paint)localObject1);
        ((Paint)localObject1).setShader(null);
      }
      localObject1 = this.oQU.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        localObject3 = this.paint;
        ((Paint)localObject3).setColor(((a)localObject2).color);
        ((a)localObject2).oRb = (((a)localObject2).oRd + ((a)localObject2).index * (oQS + lQb * 2));
        ((a)localObject2).oRc = ((a)localObject2).oRe;
        Log.d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", new Object[] { Integer.valueOf(((a)localObject2).index), Float.valueOf(((a)localObject2).oRb) });
        paramCanvas.drawCircle(((a)localObject2).oRb, ((a)localObject2).oRc, lQb, (Paint)localObject3);
        ((Paint)localObject3).setShader(null);
      }
      f1 = -(lQb / 2.0F + this.oQV / 2 * oQS + this.oQV / 2 * lQb);
      break;
      label1181:
      f2 = lQb / 2.0F;
      f3 = j / 2 * oQS;
    }
    paramCanvas.restoreToCount(i);
    if ((this.isStart) && (!this.oQX) && (this.oQU.size() > 0))
    {
      Log.i("MicroMsg.MMSightProgressBar", "start handler loop");
      this.oQX = true;
      this.handler.sendEmptyMessage(233);
    }
    AppMethodBeat.o(55339);
  }
  
  public void setProgressCallback(MMSightProgressBar.a parama)
  {
    this.oQY = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar
 * JD-Core Version:    0.7.0.1
 */