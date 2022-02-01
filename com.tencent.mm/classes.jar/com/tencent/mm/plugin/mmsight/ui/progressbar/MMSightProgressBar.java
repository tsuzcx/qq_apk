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
  public static final int rLp;
  public static final int zEe;
  private static final int[] zEf;
  private int centerX;
  private int centerY;
  private MMHandler handler;
  private boolean isStart;
  private Paint paint;
  private List<a> zEg;
  private int zEh;
  private b zEi;
  private boolean zEj;
  private a zEk;
  
  static
  {
    AppMethodBeat.i(94793);
    rLp = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 3);
    zEe = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 5);
    zEf = new int[] { -1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340") };
    AppMethodBeat.o(94793);
  }
  
  public MMSightProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94789);
    this.zEg = new ArrayList(5);
    this.zEh = 0;
    this.centerX = 0;
    this.centerY = 0;
    this.handler = null;
    this.isStart = false;
    this.zEj = false;
    init();
    AppMethodBeat.o(94789);
  }
  
  public MMSightProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94790);
    this.zEg = new ArrayList(5);
    this.zEh = 0;
    this.centerX = 0;
    this.centerY = 0;
    this.handler = null;
    this.isStart = false;
    this.zEj = false;
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
          int i = MMSightProgressBar.cVZ()[MMSightProgressBar.b(MMSightProgressBar.this).size()];
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
            
            public final void elf()
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
    com.tencent.wcdb.support.Log.i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", new Object[] { Integer.valueOf(rLp), Integer.valueOf(zEe) });
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
      this.zEg.add(localObject1);
    }
    int i = paramCanvas.save();
    this.zEh = this.zEg.size();
    float f1;
    float f3;
    if (this.zEh % 2 == 0)
    {
      f1 = -(zEe / 2.0F + (this.zEh / 2 - 1) * zEe + this.zEh / 2 * rLp);
      f2 = f1;
      if (this.zEi != null)
      {
        f2 = f1;
        if (this.zEi.zEr)
        {
          j = this.zEh + 1;
          if (j % 2 != 0) {
            break label1181;
          }
          f2 = zEe / 2.0F;
          f3 = (j / 2 - 1) * zEe;
        }
      }
    }
    for (float f2 = -(j / 2 * rLp + (f2 + f3));; f2 = -(j / 2 * rLp + (f2 + f3)))
    {
      com.tencent.wcdb.support.Log.d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.zEi.progress) });
      f3 = this.zEi.progress / 100.0F;
      f2 = f1 - (Math.abs(f2) - Math.abs(f1)) * f3;
      com.tencent.wcdb.support.Log.d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", new Object[] { Float.valueOf(f2), Integer.valueOf(this.zEh) });
      paramCanvas.translate(f2, 0.0F);
      Object localObject2;
      Object localObject3;
      if ((this.zEi != null) && (this.zEi.zEr))
      {
        localObject2 = this.zEi;
        localObject1 = this.paint;
        f1 = (zEe + rLp * 2) * (((b)localObject2).progress / 100.0F);
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", new Object[] { Float.valueOf(((b)localObject2).progress), Float.valueOf(f1) });
        if (((b)localObject2).zEz > ((b)localObject2).zEB)
        {
          f2 = ((b)localObject2).zEp.nSI - rLp;
          f3 = ((b)localObject2).zEp.nSJ - rLp;
          ((Paint)localObject1).setColor(((b)localObject2).zEq.color);
          ((b)localObject2).zED.reset();
          ((b)localObject2).zED.moveTo(((b)localObject2).zEt.x + f2, ((b)localObject2).zEt.y + f3);
          ((b)localObject2).zED.quadTo(((b)localObject2).zEu.x + f2, ((b)localObject2).zEu.y + f3, ((b)localObject2).zEv.x + f2, ((b)localObject2).zEv.y + f3);
          ((b)localObject2).zED.lineTo(((b)localObject2).zEy.x + f2, ((b)localObject2).zEy.y + f3);
          ((b)localObject2).zED.quadTo(((b)localObject2).zEx.x + f2, ((b)localObject2).zEx.y + f3, ((b)localObject2).zEw.x + f2, f3 + ((b)localObject2).zEw.y);
          if (((b)localObject2).zEq.color != ((b)localObject2).zEp.color)
          {
            f3 = ((b)localObject2).zEt.x;
            float f4 = ((b)localObject2).zEp.nSJ;
            float f5 = rLp;
            float f6 = ((b)localObject2).zEv.x;
            float f7 = ((b)localObject2).zEp.nSJ;
            float f8 = rLp;
            j = ((b)localObject2).zEp.color;
            k = ((b)localObject2).zEq.color;
            localObject3 = Shader.TileMode.REPEAT;
            ((Paint)localObject1).setShader(new LinearGradient(f3 + f2, f4 - f5, f2 + f6, f7 - f8, new int[] { j, k }, null, (Shader.TileMode)localObject3));
          }
          paramCanvas.drawPath(((b)localObject2).zED, (Paint)localObject1);
          ((Paint)localObject1).setShader(null);
        }
        localObject2 = ((b)localObject2).zEq;
        ((Paint)localObject1).setColor(((a)localObject2).color);
        ((a)localObject2).nSJ = ((a)localObject2).zEo;
        ((a)localObject2).nSI = (((a)localObject2).zEn + (((a)localObject2).index - 1) * (zEe + rLp * 2) + f1);
        com.tencent.wcdb.support.Log.d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", new Object[] { Integer.valueOf(((a)localObject2).index), Float.valueOf(f1), Float.valueOf(((a)localObject2).nSI) });
        paramCanvas.drawCircle(((a)localObject2).nSI, ((a)localObject2).nSJ, rLp, (Paint)localObject1);
        ((Paint)localObject1).setShader(null);
      }
      localObject1 = this.zEg.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        localObject3 = this.paint;
        ((Paint)localObject3).setColor(((a)localObject2).color);
        ((a)localObject2).nSI = (((a)localObject2).zEn + ((a)localObject2).index * (zEe + rLp * 2));
        ((a)localObject2).nSJ = ((a)localObject2).zEo;
        com.tencent.wcdb.support.Log.d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", new Object[] { Integer.valueOf(((a)localObject2).index), Float.valueOf(((a)localObject2).nSI) });
        paramCanvas.drawCircle(((a)localObject2).nSI, ((a)localObject2).nSJ, rLp, (Paint)localObject3);
        ((Paint)localObject3).setShader(null);
      }
      f1 = -(rLp / 2.0F + this.zEh / 2 * zEe + this.zEh / 2 * rLp);
      break;
      label1181:
      f2 = rLp / 2.0F;
      f3 = j / 2 * zEe;
    }
    paramCanvas.restoreToCount(i);
    if ((this.isStart) && (!this.zEj) && (this.zEg.size() > 0))
    {
      com.tencent.wcdb.support.Log.i("MicroMsg.MMSightProgressBar", "start handler loop");
      this.zEj = true;
      this.handler.sendEmptyMessage(233);
    }
    AppMethodBeat.o(94792);
  }
  
  public void setProgressCallback(a parama)
  {
    this.zEk = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar
 * JD-Core Version:    0.7.0.1
 */