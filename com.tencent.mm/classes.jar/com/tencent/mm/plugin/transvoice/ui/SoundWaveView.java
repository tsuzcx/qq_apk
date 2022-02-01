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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SoundWaveView
  extends View
{
  private SoundWaveView.d AkD;
  private b AkE;
  private ArrayList<Integer> AkF;
  private ArrayList<Integer> AkG;
  private ArrayList<AnimatorSet> AkH;
  private List<List<Float>> AkI;
  private List<List<Float>> AkJ;
  private Interpolator AkK;
  private int AkL;
  private int AkM;
  private int AkN;
  private int AkO;
  private int AkP;
  private int AkQ;
  private int AkR;
  private Runnable AkS;
  private int AkT;
  private a AkU;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  
  public SoundWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SoundWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(185288);
    this.AkD = SoundWaveView.d.AlA;
    this.AkE = b.Alb;
    this.AkI = new ArrayList();
    this.AkJ = new ArrayList();
    this.AkS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185277);
        ac.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active waiting!!!");
        SoundWaveView.a(SoundWaveView.this, SoundWaveView.b.Alb);
        SoundWaveView.a(SoundWaveView.this);
        AppMethodBeat.o(185277);
      }
    };
    this.AkT = -1;
    this.AkU = new a((byte)0);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(185288);
  }
  
  private boolean RL(int paramInt)
  {
    return (paramInt >= this.AkU.start) && (paramInt <= this.AkU.end);
  }
  
  private boolean RM(int paramInt)
  {
    AppMethodBeat.i(185297);
    if (!RL(paramInt))
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
    int j = c.Aln;
    int k = j / 2;
    final int i = 0;
    if (i < j)
    {
      final float f = (float)(paramFloat * Math.pow(c.Alu, Math.abs(k - i)));
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
  
  private void ahw()
  {
    AppMethodBeat.i(185295);
    this.AkT = -1;
    efj();
    efn();
    efo();
    AppMethodBeat.o(185295);
  }
  
  private void efi()
  {
    AppMethodBeat.i(185290);
    int j = getBundleCount();
    int i = 0;
    while (i < j)
    {
      this.AkF.set(i, Integer.valueOf(this.AkO));
      i += 1;
    }
    AppMethodBeat.o(185290);
  }
  
  private void efj()
  {
    AppMethodBeat.i(185291);
    int j = getVolumeItemCount();
    int i = 0;
    while (i < j)
    {
      this.AkG.set(i, Integer.valueOf(this.AkO));
      i += 1;
    }
    AppMethodBeat.o(185291);
  }
  
  private void efk()
  {
    AppMethodBeat.i(186024);
    Iterator localIterator = this.AkI.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.AkO));
        i += 1;
      }
    }
    AppMethodBeat.o(186024);
  }
  
  private void efl()
  {
    AppMethodBeat.i(186025);
    Iterator localIterator = this.AkJ.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.AkO));
        i += 1;
      }
    }
    AppMethodBeat.o(186025);
  }
  
  private void efm()
  {
    AppMethodBeat.i(185298);
    this.AkH.clear();
    int j = getVolumeItemCount();
    final int i = 0;
    while (i < j)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setStartDelay(c.Alr * i);
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
      ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { this.AkO, this.AkQ });
      localValueAnimator1.setDuration(c.Als);
      localValueAnimator1.addUpdateListener(local6);
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { this.AkQ, this.AkO });
      localValueAnimator2.setDuration(c.Als);
      localValueAnimator2.addUpdateListener(local6);
      ValueAnimator localValueAnimator3 = ValueAnimator.ofInt(new int[] { this.AkO, this.AkO });
      localValueAnimator3.setDuration(c.Alt);
      localValueAnimator3.addUpdateListener(local6);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(186023);
          ac.d("MicroMsg.NewTrans2Txt.SoundWaveView", "AnimatorSet onAnimationEnd, mode: %s", new Object[] { SoundWaveView.e(SoundWaveView.this) });
          if ((SoundWaveView.b.Alb == SoundWaveView.e(SoundWaveView.this)) && (i == SoundWaveView.f(SoundWaveView.this).size() - 1) && (SoundWaveView.this.isShown()))
          {
            ac.d("MicroMsg.NewTrans2Txt.SoundWaveView", "restart waiting anim!!!");
            SoundWaveView.g(SoundWaveView.this);
          }
          AppMethodBeat.o(186023);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      localAnimatorSet.playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2, localValueAnimator3 });
      this.AkH.add(localAnimatorSet);
      i += 1;
    }
    AppMethodBeat.o(185298);
  }
  
  private void efn()
  {
    AppMethodBeat.i(185299);
    Iterator localIterator = this.AkH.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).end();
    }
    AppMethodBeat.o(185299);
  }
  
  private void efo()
  {
    AppMethodBeat.i(185300);
    Iterator localIterator = this.AkH.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).start();
    }
    AppMethodBeat.o(185300);
  }
  
  private void efp()
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
      this.AkU.start = i;
      this.AkU.end = j;
      ac.i("MicroMsg.NewTrans2Txt.SoundWaveView", "initBaseBundleGroupInfo: %s", new Object[] { this.AkU.toString() });
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
    ac.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, mLastActiveBundleIndex: %s.", new Object[] { Integer.valueOf(this.AkT) });
    if (-1 == this.AkT)
    {
      this.AkT = (new Random().nextInt(this.AkU.end - this.AkU.start + 1) + this.AkU.start);
      i = this.AkT;
      AppMethodBeat.o(185302);
      return i;
    }
    int i = new Random().nextInt(3);
    int j;
    if (1 == i)
    {
      j = this.AkT - 1;
      i = j;
      if (RM(j))
      {
        j = this.AkT + 1;
        i = j;
        if (RM(j))
        {
          ac.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.AkT), this.AkU });
          i = this.AkT;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    if (2 == i)
    {
      j = this.AkT + 1;
      i = j;
      if (RM(j))
      {
        j = this.AkT - 1;
        i = j;
        if (RM(j))
        {
          ac.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.AkT), this.AkU });
          i = this.AkT;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    i = this.AkT;
    AppMethodBeat.o(185302);
    return i;
  }
  
  private int getBundleCount()
  {
    int i = c.Alo;
    if (SoundWaveView.d.AlB == this.AkD) {
      i = c.Alp;
    }
    return i;
  }
  
  private int getVolumeItemCount()
  {
    AppMethodBeat.i(185296);
    int i = getBundleCount();
    int j = c.Aln;
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
      i = paramContext.getInt(0, SoundWaveView.d.AlA.ordinal());
      if (i == SoundWaveView.d.AlA.ordinal())
      {
        this.AkD = SoundWaveView.d.AlA;
        paramContext.recycle();
        ac.i("MicroMsg.NewTrans2Txt.SoundWaveView", "init style %s", new Object[] { this.AkD });
      }
    }
    else
    {
      this.AkL = ao.fromDPToPix(getContext(), c.Alf);
      this.AkM = ao.fromDPToPix(getContext(), c.Alg);
      this.AkN = ao.fromDPToPix(getContext(), c.Alh);
      this.AkO = ao.fromDPToPix(getContext(), c.Ali);
      this.AkP = ao.fromDPToPix(getContext(), c.Alj);
      this.AkQ = ao.fromDPToPix(getContext(), c.Alk);
      this.AkR = ao.fromDPToPix(getContext(), c.Alx);
      this.mWidth = ao.fromDPToPix(getContext(), c.Aly);
      this.mHeight = ao.fromDPToPix(getContext(), c.Alj);
      this.AkF = new ArrayList();
      i = 0;
    }
    for (;;)
    {
      if (i >= c.Alo) {
        break label376;
      }
      this.AkF.add(Integer.valueOf(this.AkO));
      paramContext = new ArrayList();
      paramAttributeSet = new ArrayList();
      int j = 0;
      for (;;)
      {
        if (j < c.Aln)
        {
          paramContext.add(Float.valueOf(this.AkO));
          paramAttributeSet.add(Float.valueOf(this.AkO));
          j += 1;
          continue;
          if (i == SoundWaveView.d.AlB.ordinal())
          {
            this.AkD = SoundWaveView.d.AlB;
            break;
          }
          ac.e("MicroMsg.NewTrans2Txt.SoundWaveView", "style err! %s", new Object[] { Integer.valueOf(i) });
          break;
        }
      }
      this.AkI.add(paramContext);
      this.AkJ.add(paramAttributeSet);
      i += 1;
    }
    label376:
    this.AkG = new ArrayList();
    int i = k;
    while (i < c.Aln * c.Alo)
    {
      this.AkG.add(Integer.valueOf(this.AkO));
      i += 1;
    }
    efi();
    efj();
    this.AkH = new ArrayList(c.Aln * c.Alo);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (paramContext = new PathInterpolator(0.0F, 0.5F, 0.2F, 1.0F);; paramContext = new e())
    {
      this.AkK = paramContext;
      efp();
      efm();
      this.mPaint = new Paint(1);
      this.mPaint.setColor(Color.parseColor(c.Alm));
      this.mPaint.setAlpha(128);
      AppMethodBeat.o(185289);
      return;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(185305);
    efk();
    efl();
    this.AkE = b.Alb;
    ahw();
    AppMethodBeat.o(185305);
  }
  
  public final void RK(int paramInt)
  {
    AppMethodBeat.i(185294);
    float f = paramInt / 100.0F;
    ac.d("MicroMsg.NewTrans2Txt.SoundWaveView", "iVolume %s, fVolume %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(f) });
    int j;
    final int i;
    ArrayList localArrayList;
    label293:
    int k;
    int m;
    if (f <= 0.05D)
    {
      if (b.Alc == this.AkE)
      {
        this.AkE = b.Ald;
        postDelayed(this.AkS, c.Alq);
      }
      if ((b.Alc != this.AkE) && (b.Ald != this.AkE)) {
        break label799;
      }
      efi();
      f = this.AkK.getInterpolation(f);
      ac.d("MicroMsg.NewTrans2Txt.SoundWaveView", "PathInterpolatorCompat value: %s.", new Object[] { Float.valueOf(f) });
      j = (int)(f * this.AkP);
      i = getActiveBundleIndex();
      ac.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, activeBundleIndex: %s", new Object[] { Integer.valueOf(i) });
      this.AkF.set(i, Integer.valueOf(j));
      paramInt = new Random().nextInt(2);
      if (this.AkU.start != i) {
        break label470;
      }
      this.AkF.set(this.AkU.end, Integer.valueOf((int)(j * c.Alv[paramInt])));
      if (this.AkU.end - 1 != this.AkU.start)
      {
        localArrayList = this.AkF;
        i = this.AkU.end;
        f = j;
        localArrayList.set(i - 1, Integer.valueOf((int)(c.Alv[(1 - paramInt)] * f)));
      }
      k = getBundleCount();
      paramInt = new Random().nextInt(2);
      if (k != c.Alo) {
        break label714;
      }
      m = k / 2;
      i = 0;
      label327:
      if (i >= k) {
        break label795;
      }
      if (!RM(i)) {
        break label809;
      }
      this.AkF.set(i, Integer.valueOf((int)(j * c.Alw[paramInt])));
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
        if (b.Ald == this.AkE)
        {
          ac.i("MicroMsg.NewTrans2Txt.SoundWaveView", "cancel judging!!!");
          this.AkE = b.Alc;
          removeCallbacks(this.AkS);
        }
        if (b.Alb != this.AkE) {
          break;
        }
        ac.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active reacting!!!");
        this.AkE = b.Alc;
        efn();
        break;
        label470:
        if (this.AkU.end == i)
        {
          this.AkF.set(this.AkU.start, Integer.valueOf((int)(j * c.Alv[paramInt])));
          if (this.AkU.start + 1 == this.AkU.end) {
            break label293;
          }
          localArrayList = this.AkF;
          i = this.AkU.start;
          f = j;
          localArrayList.set(i + 1, Integer.valueOf((int)(c.Alv[(1 - paramInt)] * f)));
          break label293;
        }
        this.AkF.set(this.AkU.start, Integer.valueOf((int)(j * c.Alv[paramInt])));
        localArrayList = this.AkF;
        i = this.AkU.end;
        f = j;
        localArrayList.set(i, Integer.valueOf((int)(c.Alv[paramInt] * f)));
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
          a(((Integer)this.AkF.get(i)).intValue(), (List)this.AkJ.get(i));
        }
      }
      label714:
      i = 0;
      if (i < k)
      {
        if (!RM(i)) {
          break label806;
        }
        this.AkF.set(i, Integer.valueOf((int)(j * c.Alw[paramInt])));
        paramInt = 1 - paramInt;
      }
      for (;;)
      {
        a(((Integer)this.AkF.get(i)).intValue(), (List)this.AkJ.get(i));
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
    this.AkD = paramd;
    efi();
    efj();
    efp();
    efm();
    ac.i("MicroMsg.NewTrans2Txt.SoundWaveView", "update style %s", new Object[] { this.AkD });
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
    if ((b.Alc == this.AkE) || (b.Ald == this.AkE))
    {
      k = getBundleCount();
      i = 0;
    }
    while (i < k)
    {
      ((Integer)this.AkF.get(i)).intValue();
      int m = c.Aln;
      int j = 0;
      float f1;
      float f2;
      while (j < m)
      {
        f1 = ((Float)((List)this.AkJ.get(i)).get(j)).floatValue();
        f2 = ((Float)((List)this.AkI.get(i)).get(j)).floatValue();
        ((List)this.AkI.get(i)).set(j, Float.valueOf((f1 - f2) / 6.0F + f2));
        j += 1;
      }
      int n = this.AkR;
      int i1 = this.AkM;
      j = 0;
      while (j < m)
      {
        int i2 = this.AkL * j + this.AkM * j + (n * i + i1 * i);
        f2 = ((Float)((List)this.AkI.get(i)).get(j)).floatValue();
        f1 = f2;
        if (f2 < this.AkO) {
          f1 = this.AkO;
        }
        f2 = f1;
        if (f1 > this.AkP) {
          f2 = this.AkP;
        }
        f1 = (this.mHeight - f2) / 2.0F;
        int i3 = this.AkL;
        paramCanvas.drawRoundRect(i2, f1, i3 + i2, f1 + f2, this.AkN, this.AkN, this.mPaint);
        j += 1;
      }
      i += 1;
      continue;
      if (b.Alb == this.AkE)
      {
        j = getVolumeItemCount();
        i = 0;
        while (i < j)
        {
          k = this.mWidth - (i + 1) * this.AkL - this.AkM * i;
          m = (this.mHeight - ((Integer)this.AkG.get(i)).intValue()) / 2;
          n = this.AkL;
          i1 = ((Integer)this.AkG.get(i)).intValue();
          paramCanvas.drawRoundRect(k, m, k + n, i1 + m, this.AkN, this.AkN, this.mPaint);
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
    if (SoundWaveView.d.AlB == this.AkD) {}
    for (this.mWidth = ao.fromDPToPix(getContext(), c.Alz);; this.mWidth = ao.fromDPToPix(getContext(), c.Aly))
    {
      ac.d("MicroMsg.NewTrans2Txt.SoundWaveView", "style: %s, w: %s, h: %s.", new Object[] { this.AkD, Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
      setMeasuredDimension(this.mWidth, this.mHeight);
      AppMethodBeat.o(185292);
      return;
    }
  }
  
  public void setStyle(SoundWaveView.d paramd)
  {
    AppMethodBeat.i(185303);
    this.AkD = paramd;
    ac.i("MicroMsg.NewTrans2Txt.SoundWaveView", "set style %s", new Object[] { this.AkD });
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
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(185283);
      Alb = new b("WAITING", 0);
      Alc = new b("REACTING", 1);
      Ald = new b("JUDGING", 2);
      Ale = new b[] { Alb, Alc, Ald };
      AppMethodBeat.o(185283);
    }
    
    private b() {}
  }
  
  static final class c
  {
    static int Alf;
    static int Alg;
    static int Alh;
    static int Ali;
    static int Alj;
    static int Alk;
    static String Alm;
    static int Aln;
    static int Alo;
    static int Alp;
    static int Alq;
    static int Alr;
    static int Als;
    static int Alt;
    static float Alu;
    static float[] Alv;
    static float[] Alw;
    static int Alx;
    static int Aly;
    static int Alz;
    
    static
    {
      AppMethodBeat.i(185284);
      Alf = 2;
      Alg = 1;
      Alh = 1;
      Ali = 4;
      Alj = 34;
      Alk = 10;
      Alm = "#000000";
      Aln = 5;
      Alo = 5;
      Alp = 2;
      Alq = 300;
      Alr = 100;
      Als = 500;
      Alt = 1000;
      Alu = 0.8F;
      Alv = new float[] { 0.8F, 0.6F };
      Alw = new float[] { 0.5F, 0.3F };
      Alx = RN(Aln);
      Aly = RN(Aln * Alo);
      Alz = RN(Aln * Alp);
      AppMethodBeat.o(185284);
    }
    
    private static int RN(int paramInt)
    {
      return (paramInt - 1) * Alg + Alf * paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.SoundWaveView
 * JD-Core Version:    0.7.0.1
 */