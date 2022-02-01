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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MMSightProgressBar
  extends View
{
  public static final int LeA;
  private static final int[] LeB;
  public static final int yDp;
  private List<a> LeC;
  private int LeD;
  private b LeE;
  private boolean LeF;
  private a LeG;
  private int centerX;
  private int centerY;
  private MMHandler handler;
  private boolean isStart;
  private Paint paint;
  
  static
  {
    AppMethodBeat.i(94793);
    yDp = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 3);
    LeA = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 5);
    LeB = new int[] { -1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340") };
    AppMethodBeat.o(94793);
  }
  
  public MMSightProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94789);
    this.LeC = new ArrayList(5);
    this.LeD = 0;
    this.centerX = 0;
    this.centerY = 0;
    this.handler = null;
    this.isStart = false;
    this.LeF = false;
    init();
    AppMethodBeat.o(94789);
  }
  
  public MMSightProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94790);
    this.LeC = new ArrayList(5);
    this.LeD = 0;
    this.centerX = 0;
    this.centerY = 0;
    this.handler = null;
    this.isStart = false;
    this.LeF = false;
    init();
    AppMethodBeat.o(94790);
  }
  
  private void init()
  {
    AppMethodBeat.i(94791);
    this.paint = new Paint();
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    this.handler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(94788);
        if ((paramAnonymousMessage.what == 233) && (MMSightProgressBar.a(MMSightProgressBar.this)) && (MMSightProgressBar.b(MMSightProgressBar.this).size() > 0) && (MMSightProgressBar.b(MMSightProgressBar.this).size() < 5))
        {
          paramAnonymousMessage = (a)MMSightProgressBar.b(MMSightProgressBar.this).get(MMSightProgressBar.b(MMSightProgressBar.this).size() - 1);
          int i = MMSightProgressBar.dRV()[MMSightProgressBar.b(MMSightProgressBar.this).size()];
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
                com.tencent.wcdb.support.Log.i("MicroMsg.MMSightProgressBar", "progress finish!");
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
            
            public final void gdA()
            {
              AppMethodBeat.i(94787);
              MMSightProgressBar.this.invalidate();
              AppMethodBeat.o(94787);
            }
          }));
          paramAnonymousMessage = MMSightProgressBar.g(MMSightProgressBar.this);
          paramAnonymousMessage.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
          paramAnonymousMessage.animator.addUpdateListener(new b.1(paramAnonymousMessage));
          paramAnonymousMessage.animator.addListener(new b.2(paramAnonymousMessage));
          paramAnonymousMessage.animator.setInterpolator(new AccelerateDecelerateInterpolator());
          paramAnonymousMessage.animator.setDuration(2000L);
          paramAnonymousMessage.animator.start();
        }
        AppMethodBeat.o(94788);
      }
    };
    com.tencent.wcdb.support.Log.i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", new Object[] { Integer.valueOf(yDp), Integer.valueOf(LeA) });
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
      com.tencent.wcdb.support.Log.i("MicroMsg.MMSightProgressBar", "left: %s, right: %s, top: %s, bottom: %s, centerX: %s, centerY: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(this.centerX), Integer.valueOf(this.centerY) });
      com.tencent.wcdb.support.Log.i("MicroMsg.MMSightProgressBar", "add init point");
      localObject1 = new a(0, this.centerX, this.centerY, -1);
      this.LeC.add(localObject1);
    }
    int i = paramCanvas.save();
    this.LeD = this.LeC.size();
    float f1;
    float f3;
    if (this.LeD % 2 == 0)
    {
      f1 = -(LeA / 2.0F + (this.LeD / 2 - 1) * LeA + this.LeD / 2 * yDp);
      f2 = f1;
      if (this.LeE != null)
      {
        f2 = f1;
        if (this.LeE.LeN)
        {
          j = this.LeD + 1;
          if (j % 2 != 0) {
            break label1181;
          }
          f2 = LeA / 2.0F;
          f3 = (j / 2 - 1) * LeA;
        }
      }
    }
    for (float f2 = -(j / 2 * yDp + (f2 + f3));; f2 = -(j / 2 * yDp + (f2 + f3)))
    {
      com.tencent.wcdb.support.Log.d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.LeE.progress) });
      f3 = this.LeE.progress / 100.0F;
      f2 = f1 - (Math.abs(f2) - Math.abs(f1)) * f3;
      com.tencent.wcdb.support.Log.d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", new Object[] { Float.valueOf(f2), Integer.valueOf(this.LeD) });
      paramCanvas.translate(f2, 0.0F);
      Object localObject2;
      Object localObject3;
      if ((this.LeE != null) && (this.LeE.LeN))
      {
        localObject2 = this.LeE;
        localObject1 = this.paint;
        f1 = (LeA + yDp * 2) * (((b)localObject2).progress / 100.0F);
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", new Object[] { Float.valueOf(((b)localObject2).progress), Float.valueOf(f1) });
        if (((b)localObject2).LeV > ((b)localObject2).LeX)
        {
          f2 = ((b)localObject2).LeL.tZl - yDp;
          f3 = ((b)localObject2).LeL.tZm - yDp;
          ((Paint)localObject1).setColor(((b)localObject2).LeM.color);
          ((b)localObject2).LeZ.reset();
          ((b)localObject2).LeZ.moveTo(((b)localObject2).LeP.x + f2, ((b)localObject2).LeP.y + f3);
          ((b)localObject2).LeZ.quadTo(((b)localObject2).LeQ.x + f2, ((b)localObject2).LeQ.y + f3, ((b)localObject2).LeR.x + f2, ((b)localObject2).LeR.y + f3);
          ((b)localObject2).LeZ.lineTo(((b)localObject2).LeU.x + f2, ((b)localObject2).LeU.y + f3);
          ((b)localObject2).LeZ.quadTo(((b)localObject2).LeT.x + f2, ((b)localObject2).LeT.y + f3, ((b)localObject2).LeS.x + f2, f3 + ((b)localObject2).LeS.y);
          if (((b)localObject2).LeM.color != ((b)localObject2).LeL.color)
          {
            f3 = ((b)localObject2).LeP.x;
            float f4 = ((b)localObject2).LeL.tZm;
            float f5 = yDp;
            float f6 = ((b)localObject2).LeR.x;
            float f7 = ((b)localObject2).LeL.tZm;
            float f8 = yDp;
            j = ((b)localObject2).LeL.color;
            k = ((b)localObject2).LeM.color;
            localObject3 = Shader.TileMode.REPEAT;
            ((Paint)localObject1).setShader(new LinearGradient(f3 + f2, f4 - f5, f2 + f6, f7 - f8, new int[] { j, k }, null, (Shader.TileMode)localObject3));
          }
          paramCanvas.drawPath(((b)localObject2).LeZ, (Paint)localObject1);
          ((Paint)localObject1).setShader(null);
        }
        localObject2 = ((b)localObject2).LeM;
        ((Paint)localObject1).setColor(((a)localObject2).color);
        ((a)localObject2).tZm = ((a)localObject2).LeK;
        ((a)localObject2).tZl = (((a)localObject2).LeJ + (((a)localObject2).index - 1) * (LeA + yDp * 2) + f1);
        com.tencent.wcdb.support.Log.d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", new Object[] { Integer.valueOf(((a)localObject2).index), Float.valueOf(f1), Float.valueOf(((a)localObject2).tZl) });
        paramCanvas.drawCircle(((a)localObject2).tZl, ((a)localObject2).tZm, yDp, (Paint)localObject1);
        ((Paint)localObject1).setShader(null);
      }
      localObject1 = this.LeC.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        localObject3 = this.paint;
        ((Paint)localObject3).setColor(((a)localObject2).color);
        ((a)localObject2).tZl = (((a)localObject2).LeJ + ((a)localObject2).index * (LeA + yDp * 2));
        ((a)localObject2).tZm = ((a)localObject2).LeK;
        com.tencent.wcdb.support.Log.d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", new Object[] { Integer.valueOf(((a)localObject2).index), Float.valueOf(((a)localObject2).tZl) });
        paramCanvas.drawCircle(((a)localObject2).tZl, ((a)localObject2).tZm, yDp, (Paint)localObject3);
        ((Paint)localObject3).setShader(null);
      }
      f1 = -(yDp / 2.0F + this.LeD / 2 * LeA + this.LeD / 2 * yDp);
      break;
      label1181:
      f2 = yDp / 2.0F;
      f3 = j / 2 * LeA;
    }
    paramCanvas.restoreToCount(i);
    if ((this.isStart) && (!this.LeF) && (this.LeC.size() > 0))
    {
      com.tencent.wcdb.support.Log.i("MicroMsg.MMSightProgressBar", "start handler loop");
      this.LeF = true;
      this.handler.sendEmptyMessage(233);
    }
    AppMethodBeat.o(94792);
  }
  
  public void setProgressCallback(a parama)
  {
    this.LeG = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar
 * JD-Core Version:    0.7.0.1
 */