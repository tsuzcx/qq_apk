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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MMSightProgressBar
  extends View
{
  public static final int qui;
  public static final int wjF;
  private static final int[] wjG;
  private int centerX;
  private int centerY;
  private aq handler;
  private boolean isStart;
  private Paint paint;
  private List<a> wjH;
  private int wjI;
  private b wjJ;
  private boolean wjK;
  private a wjL;
  
  static
  {
    AppMethodBeat.i(94793);
    qui = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 3);
    wjF = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 5);
    wjG = new int[] { -1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340") };
    AppMethodBeat.o(94793);
  }
  
  public MMSightProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94789);
    this.wjH = new ArrayList(5);
    this.wjI = 0;
    this.centerX = 0;
    this.centerY = 0;
    this.handler = null;
    this.isStart = false;
    this.wjK = false;
    init();
    AppMethodBeat.o(94789);
  }
  
  public MMSightProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94790);
    this.wjH = new ArrayList(5);
    this.wjI = 0;
    this.centerX = 0;
    this.centerY = 0;
    this.handler = null;
    this.isStart = false;
    this.wjK = false;
    init();
    AppMethodBeat.o(94790);
  }
  
  private void init()
  {
    AppMethodBeat.i(94791);
    this.paint = new Paint();
    this.paint.setColor(-65536);
    this.paint.setAntiAlias(true);
    this.handler = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(94788);
        if ((paramAnonymousMessage.what == 233) && (MMSightProgressBar.a(MMSightProgressBar.this)) && (MMSightProgressBar.b(MMSightProgressBar.this).size() > 0) && (MMSightProgressBar.b(MMSightProgressBar.this).size() < 5))
        {
          paramAnonymousMessage = (a)MMSightProgressBar.b(MMSightProgressBar.this).get(MMSightProgressBar.b(MMSightProgressBar.this).size() - 1);
          int i = MMSightProgressBar.cxV()[MMSightProgressBar.b(MMSightProgressBar.this).size()];
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
            
            public final void drl()
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
    Log.i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", new Object[] { Integer.valueOf(qui), Integer.valueOf(wjF) });
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
      this.wjH.add(localObject1);
    }
    int i = paramCanvas.save();
    this.wjI = this.wjH.size();
    float f1;
    float f3;
    if (this.wjI % 2 == 0)
    {
      f1 = -(wjF / 2.0F + (this.wjI / 2 - 1) * wjF + this.wjI / 2 * qui);
      f2 = f1;
      if (this.wjJ != null)
      {
        f2 = f1;
        if (this.wjJ.wjS)
        {
          j = this.wjI + 1;
          if (j % 2 != 0) {
            break label1181;
          }
          f2 = wjF / 2.0F;
          f3 = (j / 2 - 1) * wjF;
        }
      }
    }
    for (float f2 = -(j / 2 * qui + (f2 + f3));; f2 = -(j / 2 * qui + (f2 + f3)))
    {
      Log.d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", new Object[] { Float.valueOf(f2), Float.valueOf(this.wjJ.progress) });
      f3 = this.wjJ.progress / 100.0F;
      f2 = f1 - (Math.abs(f2) - Math.abs(f1)) * f3;
      Log.d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", new Object[] { Float.valueOf(f2), Integer.valueOf(this.wjI) });
      paramCanvas.translate(f2, 0.0F);
      Object localObject2;
      Object localObject3;
      if ((this.wjJ != null) && (this.wjJ.wjS))
      {
        localObject2 = this.wjJ;
        localObject1 = this.paint;
        f1 = (wjF + qui * 2) * (((b)localObject2).progress / 100.0F);
        ae.d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", new Object[] { Float.valueOf(((b)localObject2).progress), Float.valueOf(f1) });
        if (((b)localObject2).wka > ((b)localObject2).wkc)
        {
          f2 = ((b)localObject2).wjQ.mFP - qui;
          f3 = ((b)localObject2).wjQ.mFQ - qui;
          ((Paint)localObject1).setColor(((b)localObject2).wjR.color);
          ((b)localObject2).wke.reset();
          ((b)localObject2).wke.moveTo(((b)localObject2).wjU.x + f2, ((b)localObject2).wjU.y + f3);
          ((b)localObject2).wke.quadTo(((b)localObject2).wjV.x + f2, ((b)localObject2).wjV.y + f3, ((b)localObject2).wjW.x + f2, ((b)localObject2).wjW.y + f3);
          ((b)localObject2).wke.lineTo(((b)localObject2).wjZ.x + f2, ((b)localObject2).wjZ.y + f3);
          ((b)localObject2).wke.quadTo(((b)localObject2).wjY.x + f2, ((b)localObject2).wjY.y + f3, ((b)localObject2).wjX.x + f2, f3 + ((b)localObject2).wjX.y);
          if (((b)localObject2).wjR.color != ((b)localObject2).wjQ.color)
          {
            f3 = ((b)localObject2).wjU.x;
            float f4 = ((b)localObject2).wjQ.mFQ;
            float f5 = qui;
            float f6 = ((b)localObject2).wjW.x;
            float f7 = ((b)localObject2).wjQ.mFQ;
            float f8 = qui;
            j = ((b)localObject2).wjQ.color;
            k = ((b)localObject2).wjR.color;
            localObject3 = Shader.TileMode.REPEAT;
            ((Paint)localObject1).setShader(new LinearGradient(f3 + f2, f4 - f5, f2 + f6, f7 - f8, new int[] { j, k }, null, (Shader.TileMode)localObject3));
          }
          paramCanvas.drawPath(((b)localObject2).wke, (Paint)localObject1);
          ((Paint)localObject1).setShader(null);
        }
        localObject2 = ((b)localObject2).wjR;
        ((Paint)localObject1).setColor(((a)localObject2).color);
        ((a)localObject2).mFQ = ((a)localObject2).wjP;
        ((a)localObject2).mFP = (((a)localObject2).wjO + (((a)localObject2).index - 1) * (wjF + qui * 2) + f1);
        Log.d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", new Object[] { Integer.valueOf(((a)localObject2).index), Float.valueOf(f1), Float.valueOf(((a)localObject2).mFP) });
        paramCanvas.drawCircle(((a)localObject2).mFP, ((a)localObject2).mFQ, qui, (Paint)localObject1);
        ((Paint)localObject1).setShader(null);
      }
      localObject1 = this.wjH.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        localObject3 = this.paint;
        ((Paint)localObject3).setColor(((a)localObject2).color);
        ((a)localObject2).mFP = (((a)localObject2).wjO + ((a)localObject2).index * (wjF + qui * 2));
        ((a)localObject2).mFQ = ((a)localObject2).wjP;
        Log.d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", new Object[] { Integer.valueOf(((a)localObject2).index), Float.valueOf(((a)localObject2).mFP) });
        paramCanvas.drawCircle(((a)localObject2).mFP, ((a)localObject2).mFQ, qui, (Paint)localObject3);
        ((Paint)localObject3).setShader(null);
      }
      f1 = -(qui / 2.0F + this.wjI / 2 * wjF + this.wjI / 2 * qui);
      break;
      label1181:
      f2 = qui / 2.0F;
      f3 = j / 2 * wjF;
    }
    paramCanvas.restoreToCount(i);
    if ((this.isStart) && (!this.wjK) && (this.wjH.size() > 0))
    {
      Log.i("MicroMsg.MMSightProgressBar", "start handler loop");
      this.wjK = true;
      this.handler.sendEmptyMessage(233);
    }
    AppMethodBeat.o(94792);
  }
  
  public void setProgressCallback(a parama)
  {
    this.wjL = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.progressbar.MMSightProgressBar
 * JD-Core Version:    0.7.0.1
 */