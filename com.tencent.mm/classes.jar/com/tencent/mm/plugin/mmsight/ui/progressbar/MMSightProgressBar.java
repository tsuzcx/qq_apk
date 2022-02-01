package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MMSightProgressBar
  extends View
{
  public static final int pgN;
  public static final int tLN;
  private static final int[] tLO;
  private int centerX;
  private int centerY;
  private ap handler;
  private boolean isStart;
  private Paint paint;
  private List<a> tLP;
  private int tLQ;
  private b tLR;
  private boolean tLS;
  private a tLT;
  
  static
  {
    AppMethodBeat.i(94793);
    pgN = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 3);
    tLN = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 5);
    tLO = new int[] { -1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340") };
    AppMethodBeat.o(94793);
  }
  
  public MMSightProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94789);
    this.tLP = new ArrayList(5);
    this.tLQ = 0;
    this.centerX = 0;
    this.centerY = 0;
    this.handler = null;
    this.isStart = false;
    this.tLS = false;
    init();
    AppMethodBeat.o(94789);
  }
  
  public MMSightProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94790);
    this.tLP = new ArrayList(5);
    this.tLQ = 0;
    this.centerX = 0;
    this.centerY = 0;
    this.handler = null;
    this.isStart = false;
    this.tLS = false;
    init();
    AppMethodBeat.o(94790);
  }
  
  private void init()
  {
    AppMethodBeat.i(94791);
    this.paint = new Paint();
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    this.handler = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(94788);
        if ((paramAnonymousMessage.what == 233) && (MMSightProgressBar.a(MMSightProgressBar.this)) && (MMSightProgressBar.b(MMSightProgressBar.this).size() > 0) && (MMSightProgressBar.b(MMSightProgressBar.this).size() < 5))
        {
          paramAnonymousMessage = (a)MMSightProgressBar.b(MMSightProgressBar.this).get(MMSightProgressBar.b(MMSightProgressBar.this).size() - 1);
          int i = MMSightProgressBar.cjd()[MMSightProgressBar.b(MMSightProgressBar.this).size()];
          a locala = new a(MMSightProgressBar.b(MMSightProgressBar.this).size(), MMSightProgressBar.c(MMSightProgressBar.this), MMSightProgressBar.d(MMSightProgressBar.this), i);
          MMSightProgressBar.a(MMSightProgressBar.this, new b(paramAnonymousMessage, locala, new b.a()
          {
            public final void a(a paramAnonymous2a)
            {
              AppMethodBeat.i(94786);
              MMSightProgressBar.b(MMSightProgressBar.this).add(paramAnonymous2a);
              MMSightProgressBar.a(MMSightProgressBar.this, null);
              if (MMSightProgressBar.b(MMSightProgressBar.this).size() >= 5)
              {
                Log.i("MicroMsg.MMSightProgressBar", "progress finish!");
                if (MMSightProgressBar.e(MMSightProgressBar.this) != null) {
                  MMSightProgressBar.e(MMSightProgressBar.this);
                }
              }
              for (;;)
              {
                MMSightProgressBar.this.invalidate();
                AppMethodBeat.o(94786);
                return;
                if (MMSightProgressBar.a(MMSightProgressBar.this)) {
                  MMSightProgressBar.f(MMSightProgressBar.this).sendEmptyMessage(233);
                }
              }
            }
            
            public final void cRf()
            {
              AppMethodBeat.i(94787);
              MMSightProgressBar.this.invalidate();
              AppMethodBeat.o(94787);
            }
          }));
          paramAnonymousMessage = MMSightProgressBar.g(MMSightProgressBar.this);
          paramAnonymousMessage.qT = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
          paramAnonymousMessage.qT.addUpdateListener(new b.1(paramAnonymousMessage));
          paramAnonymousMessage.qT.addListener(new b.2(paramAnonymousMessage));
          paramAnonymousMessage.qT.setInterpolator(new AccelerateDecelerateInterpolator());
          paramAnonymousMessage.qT.setDuration(2000L);
          paramAnonymousMessage.qT.start();
        }
        AppMethodBeat.o(94788);
      }
    };
    Log.i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", new Object[] { Integer.valueOf(pgN), Integer.valueOf(tLN) });
    AppMethodBeat.o(94791);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94792);
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
      this.tLP.add(localObject1);
    }
    int i = paramCanvas.save();
    this.tLQ = this.tLP.size();
    float f1;
    float f3;
    if (this.tLQ % 2 == 0)
    {
      f1 = -(tLN / 2.0F + (this.tLQ / 2 - 1) * tLN + this.tLQ / 2 * pgN);
      f2 = f1;
      if (this.tLR != null)
      {
        f2 = f1;
        if (this.tLR.tMc)
        {
          j = this.tLQ + 1;
          if (j % 2 != 0) {
            break label1181;
          }
          f2 = tLN / 2.0F;
          f3 = (j / 2 - 1) * tLN;
        }
      }
    }
    for (float f2 = -(j / 2 * pgN + (f2 + f3));; f2 = -(j / 2 * pgN + (f2 + f3)))
    {
      Log.d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.tLR.progress) });
      f3 = this.tLR.progress / 100.0F;
      f2 = f1 - (Math.abs(f2) - Math.abs(f1)) * f3;
      Log.d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", new Object[] { Float.valueOf(f2), Integer.valueOf(this.tLQ) });
      paramCanvas.translate(f2, 0.0F);
      Object localObject2;
      Object localObject3;
      if ((this.tLR != null) && (this.tLR.tMc))
      {
        localObject2 = this.tLR;
        localObject1 = this.paint;
        f1 = (tLN + pgN * 2) * (((b)localObject2).progress / 100.0F);
        ad.d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", new Object[] { Float.valueOf(((b)localObject2).progress), Float.valueOf(f1) });
        if (((b)localObject2).tMk > ((b)localObject2).tMm)
        {
          f2 = ((b)localObject2).tMa.tLW - pgN;
          f3 = ((b)localObject2).tMa.tLX - pgN;
          ((Paint)localObject1).setColor(((b)localObject2).tMb.color);
          ((b)localObject2).tMo.reset();
          ((b)localObject2).tMo.moveTo(((b)localObject2).tMe.x + f2, ((b)localObject2).tMe.y + f3);
          ((b)localObject2).tMo.quadTo(((b)localObject2).tMf.x + f2, ((b)localObject2).tMf.y + f3, ((b)localObject2).tMg.x + f2, ((b)localObject2).tMg.y + f3);
          ((b)localObject2).tMo.lineTo(((b)localObject2).tMj.x + f2, ((b)localObject2).tMj.y + f3);
          ((b)localObject2).tMo.quadTo(((b)localObject2).tMi.x + f2, ((b)localObject2).tMi.y + f3, ((b)localObject2).tMh.x + f2, f3 + ((b)localObject2).tMh.y);
          if (((b)localObject2).tMb.color != ((b)localObject2).tMa.color)
          {
            f3 = ((b)localObject2).tMe.x;
            float f4 = ((b)localObject2).tMa.tLX;
            float f5 = pgN;
            float f6 = ((b)localObject2).tMg.x;
            float f7 = ((b)localObject2).tMa.tLX;
            float f8 = pgN;
            j = ((b)localObject2).tMa.color;
            k = ((b)localObject2).tMb.color;
            localObject3 = Shader.TileMode.REPEAT;
            ((Paint)localObject1).setShader(new LinearGradient(f3 + f2, f4 - f5, f2 + f6, f7 - f8, new int[] { j, k }, null, (Shader.TileMode)localObject3));
          }
          paramCanvas.drawPath(((b)localObject2).tMo, (Paint)localObject1);
          ((Paint)localObject1).setShader(null);
        }
        localObject2 = ((b)localObject2).tMb;
        ((Paint)localObject1).setColor(((a)localObject2).color);
        ((a)localObject2).tLX = ((a)localObject2).tLZ;
        ((a)localObject2).tLW = (((a)localObject2).tLY + (((a)localObject2).index - 1) * (tLN + pgN * 2) + f1);
        Log.d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", new Object[] { Integer.valueOf(((a)localObject2).index), Float.valueOf(f1), Float.valueOf(((a)localObject2).tLW) });
        paramCanvas.drawCircle(((a)localObject2).tLW, ((a)localObject2).tLX, pgN, (Paint)localObject1);
        ((Paint)localObject1).setShader(null);
      }
      localObject1 = this.tLP.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        localObject3 = this.paint;
        ((Paint)localObject3).setColor(((a)localObject2).color);
        ((a)localObject2).tLW = (((a)localObject2).tLY + ((a)localObject2).index * (tLN + pgN * 2));
        ((a)localObject2).tLX = ((a)localObject2).tLZ;
        Log.d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", new Object[] { Integer.valueOf(((a)localObject2).index), Float.valueOf(((a)localObject2).tLW) });
        paramCanvas.drawCircle(((a)localObject2).tLW, ((a)localObject2).tLX, pgN, (Paint)localObject3);
        ((Paint)localObject3).setShader(null);
      }
      f1 = -(pgN / 2.0F + this.tLQ / 2 * tLN + this.tLQ / 2 * pgN);
      break;
      label1181:
      f2 = pgN / 2.0F;
      f3 = j / 2 * tLN;
    }
    paramCanvas.restoreToCount(i);
    if ((this.isStart) && (!this.tLS) && (this.tLP.size() > 0))
    {
      Log.i("MicroMsg.MMSightProgressBar", "start handler loop");
      this.tLS = true;
      this.handler.sendEmptyMessage(233);
    }
    AppMethodBeat.o(94792);
  }
  
  public void setProgressCallback(a parama)
  {
    this.tLT = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar
 * JD-Core Version:    0.7.0.1
 */