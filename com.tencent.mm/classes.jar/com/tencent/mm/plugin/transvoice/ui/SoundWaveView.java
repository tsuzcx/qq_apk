package com.tencent.mm.plugin.transvoice.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.v4.view.b.e;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.transvoice.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SoundWaveView
  extends View
{
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private SoundWaveView.d yWP;
  private SoundWaveView.b yWQ;
  private ArrayList<Integer> yWR;
  private ArrayList<Integer> yWS;
  private ArrayList<AnimatorSet> yWT;
  private List<List<Float>> yWU;
  private List<List<Float>> yWV;
  private Interpolator yWW;
  private int yWX;
  private int yWY;
  private int yWZ;
  private int yXa;
  private int yXb;
  private int yXc;
  private int yXd;
  private Runnable yXe;
  private int yXf;
  private a yXg;
  
  public SoundWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SoundWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(185288);
    this.yWP = SoundWaveView.d.yXL;
    this.yWQ = SoundWaveView.b.yXn;
    this.yWU = new ArrayList();
    this.yWV = new ArrayList();
    this.yXe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185277);
        ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active waiting!!!");
        SoundWaveView.a(SoundWaveView.this, SoundWaveView.b.yXn);
        SoundWaveView.a(SoundWaveView.this);
        AppMethodBeat.o(185277);
      }
    };
    this.yXf = -1;
    this.yXg = new a((byte)0);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(185288);
  }
  
  private boolean PF(int paramInt)
  {
    return (paramInt >= this.yXg.start) && (paramInt <= this.yXg.end);
  }
  
  private boolean PG(int paramInt)
  {
    AppMethodBeat.i(185297);
    if (!PF(paramInt))
    {
      AppMethodBeat.o(185297);
      return true;
    }
    AppMethodBeat.o(185297);
    return false;
  }
  
  private void a(float paramFloat, final List<Float> paramList)
  {
    AppMethodBeat.i(186026);
    int j = c.yXy;
    int k = j / 2;
    final int i = 0;
    if (i < j)
    {
      final float f = (float)(paramFloat * Math.pow(c.yXF, Math.abs(k - i)));
      if (2 == Math.abs(k - i)) {
        postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186020);
            paramList.set(i, Float.valueOf(f));
            AppMethodBeat.o(186020);
          }
        }, 320L);
      }
      for (;;)
      {
        i += 1;
        break;
        if (1 == Math.abs(k - i)) {
          postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186021);
              paramList.set(i, Float.valueOf(f));
              AppMethodBeat.o(186021);
            }
          }, 160L);
        } else if (Math.abs(k - i) == 0) {
          paramList.set(i, Float.valueOf(f));
        }
      }
    }
    AppMethodBeat.o(186026);
  }
  
  private void agg()
  {
    AppMethodBeat.i(185295);
    this.yXf = -1;
    dQK();
    dQO();
    dQP();
    AppMethodBeat.o(185295);
  }
  
  private void dQJ()
  {
    AppMethodBeat.i(185290);
    int j = getBundleCount();
    int i = 0;
    while (i < j)
    {
      this.yWR.set(i, Integer.valueOf(this.yXa));
      i += 1;
    }
    AppMethodBeat.o(185290);
  }
  
  private void dQK()
  {
    AppMethodBeat.i(185291);
    int j = getVolumeItemCount();
    int i = 0;
    while (i < j)
    {
      this.yWS.set(i, Integer.valueOf(this.yXa));
      i += 1;
    }
    AppMethodBeat.o(185291);
  }
  
  private void dQL()
  {
    AppMethodBeat.i(186024);
    Iterator localIterator = this.yWU.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.yXa));
        i += 1;
      }
    }
    AppMethodBeat.o(186024);
  }
  
  private void dQM()
  {
    AppMethodBeat.i(186025);
    Iterator localIterator = this.yWV.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.yXa));
        i += 1;
      }
    }
    AppMethodBeat.o(186025);
  }
  
  private void dQN()
  {
    AppMethodBeat.i(185298);
    this.yWT.clear();
    int j = getVolumeItemCount();
    final int i = 0;
    while (i < j)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setStartDelay(c.yXC * i);
      localAnimatorSet.setInterpolator(new LinearInterpolator());
      ValueAnimator.AnimatorUpdateListener local6 = new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(186022);
          SoundWaveView.d(SoundWaveView.this).set(i, (Integer)paramAnonymousValueAnimator.getAnimatedValue());
          SoundWaveView.this.invalidate();
          AppMethodBeat.o(186022);
        }
      };
      ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { this.yXa, this.yXc });
      localValueAnimator1.setDuration(c.yXD);
      localValueAnimator1.addUpdateListener(local6);
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { this.yXc, this.yXa });
      localValueAnimator2.setDuration(c.yXD);
      localValueAnimator2.addUpdateListener(local6);
      ValueAnimator localValueAnimator3 = ValueAnimator.ofInt(new int[] { this.yXa, this.yXa });
      localValueAnimator3.setDuration(c.yXE);
      localValueAnimator3.addUpdateListener(local6);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(186023);
          ad.d("MicroMsg.NewTrans2Txt.SoundWaveView", "AnimatorSet onAnimationEnd, mode: %s", new Object[] { SoundWaveView.e(SoundWaveView.this) });
          if ((SoundWaveView.b.yXn == SoundWaveView.e(SoundWaveView.this)) && (i == SoundWaveView.f(SoundWaveView.this).size() - 1) && (SoundWaveView.this.isShown()))
          {
            ad.d("MicroMsg.NewTrans2Txt.SoundWaveView", "restart waiting anim!!!");
            SoundWaveView.g(SoundWaveView.this);
          }
          AppMethodBeat.o(186023);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      localAnimatorSet.playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2, localValueAnimator3 });
      this.yWT.add(localAnimatorSet);
      i += 1;
    }
    AppMethodBeat.o(185298);
  }
  
  private void dQO()
  {
    AppMethodBeat.i(185299);
    Iterator localIterator = this.yWT.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).end();
    }
    AppMethodBeat.o(185299);
  }
  
  private void dQP()
  {
    AppMethodBeat.i(185300);
    Iterator localIterator = this.yWT.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).start();
    }
    AppMethodBeat.o(185300);
  }
  
  private void dQQ()
  {
    AppMethodBeat.i(185301);
    int j = getBundleCount();
    int k = j / 2;
    int i;
    if (k - 1 < 0)
    {
      i = 0;
      if (k + 1 < j) {
        break label87;
      }
      j -= 1;
    }
    for (;;)
    {
      this.yXg.start = i;
      this.yXg.end = j;
      ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "initBaseBundleGroupInfo: %s", new Object[] { this.yXg.toString() });
      AppMethodBeat.o(185301);
      return;
      i = k - 1;
      break;
      label87:
      j = k + 1;
    }
  }
  
  private int getActiveBundleIndex()
  {
    AppMethodBeat.i(185302);
    ad.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, mLastActiveBundleIndex: %s.", new Object[] { Integer.valueOf(this.yXf) });
    if (-1 == this.yXf)
    {
      this.yXf = (new Random().nextInt(this.yXg.end - this.yXg.start + 1) + this.yXg.start);
      i = this.yXf;
      AppMethodBeat.o(185302);
      return i;
    }
    int i = new Random().nextInt(3);
    int j;
    if (1 == i)
    {
      j = this.yXf - 1;
      i = j;
      if (PG(j))
      {
        j = this.yXf + 1;
        i = j;
        if (PG(j))
        {
          ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.yXf), this.yXg });
          i = this.yXf;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    if (2 == i)
    {
      j = this.yXf + 1;
      i = j;
      if (PG(j))
      {
        j = this.yXf - 1;
        i = j;
        if (PG(j))
        {
          ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.yXf), this.yXg });
          i = this.yXf;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    i = this.yXf;
    AppMethodBeat.o(185302);
    return i;
  }
  
  private int getBundleCount()
  {
    int i = c.yXz;
    if (SoundWaveView.d.yXM == this.yWP) {
      i = c.yXA;
    }
    return i;
  }
  
  private int getVolumeItemCount()
  {
    AppMethodBeat.i(185296);
    int i = getBundleCount();
    int j = c.yXy;
    AppMethodBeat.o(185296);
    return i * j;
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    int k = 0;
    AppMethodBeat.i(185289);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.SoundWaveView, 0, 0);
      i = paramContext.getInt(0, SoundWaveView.d.yXL.ordinal());
      if (i == SoundWaveView.d.yXL.ordinal())
      {
        this.yWP = SoundWaveView.d.yXL;
        paramContext.recycle();
        ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "init style %s", new Object[] { this.yWP });
      }
    }
    else
    {
      this.yWX = ao.fromDPToPix(getContext(), c.yXr);
      this.yWY = ao.fromDPToPix(getContext(), c.yXs);
      this.yWZ = ao.fromDPToPix(getContext(), c.yXt);
      this.yXa = ao.fromDPToPix(getContext(), c.yXu);
      this.yXb = ao.fromDPToPix(getContext(), c.yXv);
      this.yXc = ao.fromDPToPix(getContext(), c.yXw);
      this.yXd = ao.fromDPToPix(getContext(), c.yXI);
      this.mWidth = ao.fromDPToPix(getContext(), c.yXJ);
      this.mHeight = ao.fromDPToPix(getContext(), c.yXv);
      this.yWR = new ArrayList();
      i = 0;
    }
    for (;;)
    {
      if (i >= c.yXz) {
        break label376;
      }
      this.yWR.add(Integer.valueOf(this.yXa));
      paramContext = new ArrayList();
      paramAttributeSet = new ArrayList();
      int j = 0;
      for (;;)
      {
        if (j < c.yXy)
        {
          paramContext.add(Float.valueOf(this.yXa));
          paramAttributeSet.add(Float.valueOf(this.yXa));
          j += 1;
          continue;
          if (i == SoundWaveView.d.yXM.ordinal())
          {
            this.yWP = SoundWaveView.d.yXM;
            break;
          }
          ad.e("MicroMsg.NewTrans2Txt.SoundWaveView", "style err! %s", new Object[] { Integer.valueOf(i) });
          break;
        }
      }
      this.yWU.add(paramContext);
      this.yWV.add(paramAttributeSet);
      i += 1;
    }
    label376:
    this.yWS = new ArrayList();
    int i = k;
    while (i < c.yXy * c.yXz)
    {
      this.yWS.add(Integer.valueOf(this.yXa));
      i += 1;
    }
    dQJ();
    dQK();
    this.yWT = new ArrayList(c.yXy * c.yXz);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (paramContext = new PathInterpolator(0.0F, 0.5F, 0.2F, 1.0F);; paramContext = new e())
    {
      this.yWW = paramContext;
      dQQ();
      dQN();
      this.mPaint = new Paint(1);
      this.mPaint.setColor(Color.parseColor(c.yXx));
      this.mPaint.setAlpha(128);
      AppMethodBeat.o(185289);
      return;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(185305);
    dQL();
    dQM();
    this.yWQ = SoundWaveView.b.yXn;
    agg();
    AppMethodBeat.o(185305);
  }
  
  public final void PE(int paramInt)
  {
    AppMethodBeat.i(185294);
    float f = paramInt / 100.0F;
    ad.d("MicroMsg.NewTrans2Txt.SoundWaveView", "iVolume %s, fVolume %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(f) });
    int j;
    final int i;
    ArrayList localArrayList;
    label293:
    int k;
    int m;
    if (f <= 0.05D)
    {
      if (SoundWaveView.b.yXo == this.yWQ)
      {
        this.yWQ = SoundWaveView.b.yXp;
        postDelayed(this.yXe, c.yXB);
      }
      if ((SoundWaveView.b.yXo != this.yWQ) && (SoundWaveView.b.yXp != this.yWQ)) {
        break label799;
      }
      dQJ();
      f = this.yWW.getInterpolation(f);
      ad.d("MicroMsg.NewTrans2Txt.SoundWaveView", "PathInterpolatorCompat value: %s.", new Object[] { Float.valueOf(f) });
      j = (int)(f * this.yXb);
      i = getActiveBundleIndex();
      ad.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, activeBundleIndex: %s", new Object[] { Integer.valueOf(i) });
      this.yWR.set(i, Integer.valueOf(j));
      paramInt = new Random().nextInt(2);
      if (this.yXg.start != i) {
        break label470;
      }
      this.yWR.set(this.yXg.end, Integer.valueOf((int)(j * c.yXG[paramInt])));
      if (this.yXg.end - 1 != this.yXg.start)
      {
        localArrayList = this.yWR;
        i = this.yXg.end;
        f = j;
        localArrayList.set(i - 1, Integer.valueOf((int)(c.yXG[(1 - paramInt)] * f)));
      }
      k = getBundleCount();
      paramInt = new Random().nextInt(2);
      if (k != c.yXz) {
        break label714;
      }
      m = k / 2;
      i = 0;
      label327:
      if (i >= k) {
        break label795;
      }
      if (!PG(i)) {
        break label809;
      }
      this.yWR.set(i, Integer.valueOf((int)(j * c.yXH[paramInt])));
      paramInt = 1 - paramInt;
    }
    label795:
    label799:
    label806:
    label809:
    for (;;)
    {
      if (2 == Math.abs(m - i)) {
        postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186018);
            SoundWaveView.a(SoundWaveView.this, ((Integer)SoundWaveView.b(SoundWaveView.this).get(i)).intValue(), (List)SoundWaveView.c(SoundWaveView.this).get(i));
            AppMethodBeat.o(186018);
          }
        }, 320L);
      }
      for (;;)
      {
        i += 1;
        break label327;
        if (SoundWaveView.b.yXp == this.yWQ)
        {
          ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "cancel judging!!!");
          this.yWQ = SoundWaveView.b.yXo;
          removeCallbacks(this.yXe);
        }
        if (SoundWaveView.b.yXn != this.yWQ) {
          break;
        }
        ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active reacting!!!");
        this.yWQ = SoundWaveView.b.yXo;
        dQO();
        break;
        label470:
        if (this.yXg.end == i)
        {
          this.yWR.set(this.yXg.start, Integer.valueOf((int)(j * c.yXG[paramInt])));
          if (this.yXg.start + 1 == this.yXg.end) {
            break label293;
          }
          localArrayList = this.yWR;
          i = this.yXg.start;
          f = j;
          localArrayList.set(i + 1, Integer.valueOf((int)(c.yXG[(1 - paramInt)] * f)));
          break label293;
        }
        this.yWR.set(this.yXg.start, Integer.valueOf((int)(j * c.yXG[paramInt])));
        localArrayList = this.yWR;
        i = this.yXg.end;
        f = j;
        localArrayList.set(i, Integer.valueOf((int)(c.yXG[paramInt] * f)));
        break label293;
        if (1 == Math.abs(m - i)) {
          postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186019);
              SoundWaveView.a(SoundWaveView.this, ((Integer)SoundWaveView.b(SoundWaveView.this).get(i)).intValue(), (List)SoundWaveView.c(SoundWaveView.this).get(i));
              AppMethodBeat.o(186019);
            }
          }, 160L);
        } else if (Math.abs(m - i) == 0) {
          a(((Integer)this.yWR.get(i)).intValue(), (List)this.yWV.get(i));
        }
      }
      label714:
      i = 0;
      if (i < k)
      {
        if (!PG(i)) {
          break label806;
        }
        this.yWR.set(i, Integer.valueOf((int)(j * c.yXH[paramInt])));
        paramInt = 1 - paramInt;
      }
      for (;;)
      {
        a(((Integer)this.yWR.get(i)).intValue(), (List)this.yWV.get(i));
        i += 1;
        break;
        invalidate();
        AppMethodBeat.o(185294);
        return;
      }
    }
  }
  
  public final void a(SoundWaveView.d paramd)
  {
    AppMethodBeat.i(185304);
    this.yWP = paramd;
    dQJ();
    dQK();
    dQQ();
    dQN();
    ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "update style %s", new Object[] { this.yWP });
    requestLayout();
    reset();
    AppMethodBeat.o(185304);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(185293);
    super.onDraw(paramCanvas);
    int k;
    int i;
    if ((SoundWaveView.b.yXo == this.yWQ) || (SoundWaveView.b.yXp == this.yWQ))
    {
      k = getBundleCount();
      i = 0;
    }
    while (i < k)
    {
      ((Integer)this.yWR.get(i)).intValue();
      int m = c.yXy;
      int j = 0;
      float f1;
      float f2;
      while (j < m)
      {
        f1 = ((Float)((List)this.yWV.get(i)).get(j)).floatValue();
        f2 = ((Float)((List)this.yWU.get(i)).get(j)).floatValue();
        ((List)this.yWU.get(i)).set(j, Float.valueOf((f1 - f2) / 6.0F + f2));
        j += 1;
      }
      int n = this.yXd;
      int i1 = this.yWY;
      j = 0;
      while (j < m)
      {
        int i2 = this.yWX * j + this.yWY * j + (n * i + i1 * i);
        f2 = ((Float)((List)this.yWU.get(i)).get(j)).floatValue();
        f1 = f2;
        if (f2 < this.yXa) {
          f1 = this.yXa;
        }
        f2 = f1;
        if (f1 > this.yXb) {
          f2 = this.yXb;
        }
        f1 = (this.mHeight - f2) / 2.0F;
        int i3 = this.yWX;
        paramCanvas.drawRoundRect(i2, f1, i3 + i2, f1 + f2, this.yWZ, this.yWZ, this.mPaint);
        j += 1;
      }
      i += 1;
      continue;
      if (SoundWaveView.b.yXn == this.yWQ)
      {
        j = getVolumeItemCount();
        i = 0;
        while (i < j)
        {
          k = this.mWidth - (i + 1) * this.yWX - this.yWY * i;
          m = (this.mHeight - ((Integer)this.yWS.get(i)).intValue()) / 2;
          n = this.yWX;
          i1 = ((Integer)this.yWS.get(i)).intValue();
          paramCanvas.drawRoundRect(k, m, k + n, i1 + m, this.yWZ, this.yWZ, this.mPaint);
          i += 1;
        }
      }
    }
    invalidate();
    AppMethodBeat.o(185293);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(185292);
    super.onMeasure(paramInt1, paramInt2);
    if (SoundWaveView.d.yXM == this.yWP) {}
    for (this.mWidth = ao.fromDPToPix(getContext(), c.yXK);; this.mWidth = ao.fromDPToPix(getContext(), c.yXJ))
    {
      ad.d("MicroMsg.NewTrans2Txt.SoundWaveView", "style: %s, w: %s, h: %s.", new Object[] { this.yWP, Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
      setMeasuredDimension(this.mWidth, this.mHeight);
      AppMethodBeat.o(185292);
      return;
    }
  }
  
  public void setStyle(SoundWaveView.d paramd)
  {
    AppMethodBeat.i(185303);
    this.yWP = paramd;
    ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "set style %s", new Object[] { this.yWP });
    AppMethodBeat.o(185303);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(185306);
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      reset();
    }
    AppMethodBeat.o(185306);
  }
  
  final class a
  {
    int end = -1;
    int start = -1;
    
    private a() {}
    
    public final String toString()
    {
      AppMethodBeat.i(185280);
      String str = "start: " + this.start + " end: " + this.end;
      AppMethodBeat.o(185280);
      return str;
    }
  }
  
  static final class c
  {
    static int yXA;
    static int yXB;
    static int yXC;
    static int yXD;
    static int yXE;
    static float yXF;
    static float[] yXG;
    static float[] yXH;
    static int yXI;
    static int yXJ;
    static int yXK;
    static int yXr;
    static int yXs;
    static int yXt;
    static int yXu;
    static int yXv;
    static int yXw;
    static String yXx;
    static int yXy;
    static int yXz;
    
    static
    {
      AppMethodBeat.i(185284);
      yXr = 2;
      yXs = 1;
      yXt = 1;
      yXu = 4;
      yXv = 34;
      yXw = 10;
      yXx = "#000000";
      yXy = 5;
      yXz = 5;
      yXA = 2;
      yXB = 300;
      yXC = 100;
      yXD = 500;
      yXE = 1000;
      yXF = 0.8F;
      yXG = new float[] { 0.8F, 0.6F };
      yXH = new float[] { 0.5F, 0.3F };
      yXI = PH(yXy);
      yXJ = PH(yXy * yXz);
      yXK = PH(yXy * yXA);
      AppMethodBeat.o(185284);
    }
    
    private static int PH(int paramInt)
    {
      return (paramInt - 1) * yXs + yXr * paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.SoundWaveView
 * JD-Core Version:    0.7.0.1
 */