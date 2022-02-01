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
import com.tencent.mm.ui.aq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SoundWaveView
  extends View
{
  private int BCA;
  private int BCB;
  private int BCC;
  private int BCD;
  private Runnable BCE;
  private int BCF;
  private a BCG;
  private SoundWaveView.d BCp;
  private SoundWaveView.b BCq;
  private ArrayList<Integer> BCr;
  private ArrayList<Integer> BCs;
  private ArrayList<AnimatorSet> BCt;
  private List<List<Float>> BCu;
  private List<List<Float>> BCv;
  private Interpolator BCw;
  private int BCx;
  private int BCy;
  private int BCz;
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
    this.BCp = SoundWaveView.d.BDl;
    this.BCq = SoundWaveView.b.BCN;
    this.BCu = new ArrayList();
    this.BCv = new ArrayList();
    this.BCE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185277);
        ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active waiting!!!");
        SoundWaveView.a(SoundWaveView.this, SoundWaveView.b.BCN);
        SoundWaveView.a(SoundWaveView.this);
        AppMethodBeat.o(185277);
      }
    };
    this.BCF = -1;
    this.BCG = new a((byte)0);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(185288);
  }
  
  private boolean Tv(int paramInt)
  {
    return (paramInt >= this.BCG.start) && (paramInt <= this.BCG.end);
  }
  
  private boolean Tw(int paramInt)
  {
    AppMethodBeat.i(185297);
    if (!Tv(paramInt))
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
    int j = c.BCY;
    int k = j / 2;
    final int i = 0;
    if (i < j)
    {
      final float f = (float)(paramFloat * Math.pow(c.BDf, Math.abs(k - i)));
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
  
  private void akh()
  {
    AppMethodBeat.i(185295);
    this.BCF = -1;
    erA();
    erE();
    erF();
    AppMethodBeat.o(185295);
  }
  
  private void erA()
  {
    AppMethodBeat.i(185291);
    int j = getVolumeItemCount();
    int i = 0;
    while (i < j)
    {
      this.BCs.set(i, Integer.valueOf(this.BCA));
      i += 1;
    }
    AppMethodBeat.o(185291);
  }
  
  private void erB()
  {
    AppMethodBeat.i(186024);
    Iterator localIterator = this.BCu.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.BCA));
        i += 1;
      }
    }
    AppMethodBeat.o(186024);
  }
  
  private void erC()
  {
    AppMethodBeat.i(186025);
    Iterator localIterator = this.BCv.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.BCA));
        i += 1;
      }
    }
    AppMethodBeat.o(186025);
  }
  
  private void erD()
  {
    AppMethodBeat.i(185298);
    this.BCt.clear();
    int j = getVolumeItemCount();
    final int i = 0;
    while (i < j)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setStartDelay(c.BDc * i);
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
      ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { this.BCA, this.BCC });
      localValueAnimator1.setDuration(c.BDd);
      localValueAnimator1.addUpdateListener(local6);
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { this.BCC, this.BCA });
      localValueAnimator2.setDuration(c.BDd);
      localValueAnimator2.addUpdateListener(local6);
      ValueAnimator localValueAnimator3 = ValueAnimator.ofInt(new int[] { this.BCA, this.BCA });
      localValueAnimator3.setDuration(c.BDe);
      localValueAnimator3.addUpdateListener(local6);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(186023);
          ad.d("MicroMsg.NewTrans2Txt.SoundWaveView", "AnimatorSet onAnimationEnd, mode: %s", new Object[] { SoundWaveView.e(SoundWaveView.this) });
          if ((SoundWaveView.b.BCN == SoundWaveView.e(SoundWaveView.this)) && (i == SoundWaveView.f(SoundWaveView.this).size() - 1) && (SoundWaveView.this.isShown()))
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
      this.BCt.add(localAnimatorSet);
      i += 1;
    }
    AppMethodBeat.o(185298);
  }
  
  private void erE()
  {
    AppMethodBeat.i(185299);
    Iterator localIterator = this.BCt.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).end();
    }
    AppMethodBeat.o(185299);
  }
  
  private void erF()
  {
    AppMethodBeat.i(185300);
    Iterator localIterator = this.BCt.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).start();
    }
    AppMethodBeat.o(185300);
  }
  
  private void erG()
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
      this.BCG.start = i;
      this.BCG.end = j;
      ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "initBaseBundleGroupInfo: %s", new Object[] { this.BCG.toString() });
      AppMethodBeat.o(185301);
      return;
      i = k - 1;
      break;
      label87:
      j = k + 1;
    }
  }
  
  private void erz()
  {
    AppMethodBeat.i(185290);
    int j = getBundleCount();
    int i = 0;
    while (i < j)
    {
      this.BCr.set(i, Integer.valueOf(this.BCA));
      i += 1;
    }
    AppMethodBeat.o(185290);
  }
  
  private int getActiveBundleIndex()
  {
    AppMethodBeat.i(185302);
    ad.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, mLastActiveBundleIndex: %s.", new Object[] { Integer.valueOf(this.BCF) });
    if (-1 == this.BCF)
    {
      this.BCF = (new Random().nextInt(this.BCG.end - this.BCG.start + 1) + this.BCG.start);
      i = this.BCF;
      AppMethodBeat.o(185302);
      return i;
    }
    int i = new Random().nextInt(3);
    int j;
    if (1 == i)
    {
      j = this.BCF - 1;
      i = j;
      if (Tw(j))
      {
        j = this.BCF + 1;
        i = j;
        if (Tw(j))
        {
          ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.BCF), this.BCG });
          i = this.BCF;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    if (2 == i)
    {
      j = this.BCF + 1;
      i = j;
      if (Tw(j))
      {
        j = this.BCF - 1;
        i = j;
        if (Tw(j))
        {
          ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.BCF), this.BCG });
          i = this.BCF;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    i = this.BCF;
    AppMethodBeat.o(185302);
    return i;
  }
  
  private int getBundleCount()
  {
    int i = c.BCZ;
    if (SoundWaveView.d.BDm == this.BCp) {
      i = c.BDa;
    }
    return i;
  }
  
  private int getVolumeItemCount()
  {
    AppMethodBeat.i(185296);
    int i = getBundleCount();
    int j = c.BCY;
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
      i = paramContext.getInt(0, SoundWaveView.d.BDl.ordinal());
      if (i == SoundWaveView.d.BDl.ordinal())
      {
        this.BCp = SoundWaveView.d.BDl;
        paramContext.recycle();
        ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "init style %s", new Object[] { this.BCp });
      }
    }
    else
    {
      this.BCx = aq.fromDPToPix(getContext(), c.BCR);
      this.BCy = aq.fromDPToPix(getContext(), c.BCS);
      this.BCz = aq.fromDPToPix(getContext(), c.BCT);
      this.BCA = aq.fromDPToPix(getContext(), c.BCU);
      this.BCB = aq.fromDPToPix(getContext(), c.BCV);
      this.BCC = aq.fromDPToPix(getContext(), c.BCW);
      this.BCD = aq.fromDPToPix(getContext(), c.BDi);
      this.mWidth = aq.fromDPToPix(getContext(), c.BDj);
      this.mHeight = aq.fromDPToPix(getContext(), c.BCV);
      this.BCr = new ArrayList();
      i = 0;
    }
    for (;;)
    {
      if (i >= c.BCZ) {
        break label376;
      }
      this.BCr.add(Integer.valueOf(this.BCA));
      paramContext = new ArrayList();
      paramAttributeSet = new ArrayList();
      int j = 0;
      for (;;)
      {
        if (j < c.BCY)
        {
          paramContext.add(Float.valueOf(this.BCA));
          paramAttributeSet.add(Float.valueOf(this.BCA));
          j += 1;
          continue;
          if (i == SoundWaveView.d.BDm.ordinal())
          {
            this.BCp = SoundWaveView.d.BDm;
            break;
          }
          ad.e("MicroMsg.NewTrans2Txt.SoundWaveView", "style err! %s", new Object[] { Integer.valueOf(i) });
          break;
        }
      }
      this.BCu.add(paramContext);
      this.BCv.add(paramAttributeSet);
      i += 1;
    }
    label376:
    this.BCs = new ArrayList();
    int i = k;
    while (i < c.BCY * c.BCZ)
    {
      this.BCs.add(Integer.valueOf(this.BCA));
      i += 1;
    }
    erz();
    erA();
    this.BCt = new ArrayList(c.BCY * c.BCZ);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (paramContext = new PathInterpolator(0.0F, 0.5F, 0.2F, 1.0F);; paramContext = new e())
    {
      this.BCw = paramContext;
      erG();
      erD();
      this.mPaint = new Paint(1);
      this.mPaint.setColor(Color.parseColor(c.BCX));
      this.mPaint.setAlpha(128);
      AppMethodBeat.o(185289);
      return;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(185305);
    erB();
    erC();
    this.BCq = SoundWaveView.b.BCN;
    akh();
    AppMethodBeat.o(185305);
  }
  
  public final void Tu(int paramInt)
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
      if (SoundWaveView.b.BCO == this.BCq)
      {
        this.BCq = SoundWaveView.b.BCP;
        postDelayed(this.BCE, c.BDb);
      }
      if ((SoundWaveView.b.BCO != this.BCq) && (SoundWaveView.b.BCP != this.BCq)) {
        break label799;
      }
      erz();
      f = this.BCw.getInterpolation(f);
      ad.d("MicroMsg.NewTrans2Txt.SoundWaveView", "PathInterpolatorCompat value: %s.", new Object[] { Float.valueOf(f) });
      j = (int)(f * this.BCB);
      i = getActiveBundleIndex();
      ad.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, activeBundleIndex: %s", new Object[] { Integer.valueOf(i) });
      this.BCr.set(i, Integer.valueOf(j));
      paramInt = new Random().nextInt(2);
      if (this.BCG.start != i) {
        break label470;
      }
      this.BCr.set(this.BCG.end, Integer.valueOf((int)(j * c.BDg[paramInt])));
      if (this.BCG.end - 1 != this.BCG.start)
      {
        localArrayList = this.BCr;
        i = this.BCG.end;
        f = j;
        localArrayList.set(i - 1, Integer.valueOf((int)(c.BDg[(1 - paramInt)] * f)));
      }
      k = getBundleCount();
      paramInt = new Random().nextInt(2);
      if (k != c.BCZ) {
        break label714;
      }
      m = k / 2;
      i = 0;
      label327:
      if (i >= k) {
        break label795;
      }
      if (!Tw(i)) {
        break label809;
      }
      this.BCr.set(i, Integer.valueOf((int)(j * c.BDh[paramInt])));
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
        if (SoundWaveView.b.BCP == this.BCq)
        {
          ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "cancel judging!!!");
          this.BCq = SoundWaveView.b.BCO;
          removeCallbacks(this.BCE);
        }
        if (SoundWaveView.b.BCN != this.BCq) {
          break;
        }
        ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active reacting!!!");
        this.BCq = SoundWaveView.b.BCO;
        erE();
        break;
        label470:
        if (this.BCG.end == i)
        {
          this.BCr.set(this.BCG.start, Integer.valueOf((int)(j * c.BDg[paramInt])));
          if (this.BCG.start + 1 == this.BCG.end) {
            break label293;
          }
          localArrayList = this.BCr;
          i = this.BCG.start;
          f = j;
          localArrayList.set(i + 1, Integer.valueOf((int)(c.BDg[(1 - paramInt)] * f)));
          break label293;
        }
        this.BCr.set(this.BCG.start, Integer.valueOf((int)(j * c.BDg[paramInt])));
        localArrayList = this.BCr;
        i = this.BCG.end;
        f = j;
        localArrayList.set(i, Integer.valueOf((int)(c.BDg[paramInt] * f)));
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
          a(((Integer)this.BCr.get(i)).intValue(), (List)this.BCv.get(i));
        }
      }
      label714:
      i = 0;
      if (i < k)
      {
        if (!Tw(i)) {
          break label806;
        }
        this.BCr.set(i, Integer.valueOf((int)(j * c.BDh[paramInt])));
        paramInt = 1 - paramInt;
      }
      for (;;)
      {
        a(((Integer)this.BCr.get(i)).intValue(), (List)this.BCv.get(i));
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
    this.BCp = paramd;
    erz();
    erA();
    erG();
    erD();
    ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "update style %s", new Object[] { this.BCp });
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
    if ((SoundWaveView.b.BCO == this.BCq) || (SoundWaveView.b.BCP == this.BCq))
    {
      k = getBundleCount();
      i = 0;
    }
    while (i < k)
    {
      ((Integer)this.BCr.get(i)).intValue();
      int m = c.BCY;
      int j = 0;
      float f1;
      float f2;
      while (j < m)
      {
        f1 = ((Float)((List)this.BCv.get(i)).get(j)).floatValue();
        f2 = ((Float)((List)this.BCu.get(i)).get(j)).floatValue();
        ((List)this.BCu.get(i)).set(j, Float.valueOf((f1 - f2) / 6.0F + f2));
        j += 1;
      }
      int n = this.BCD;
      int i1 = this.BCy;
      j = 0;
      while (j < m)
      {
        int i2 = this.BCx * j + this.BCy * j + (n * i + i1 * i);
        f2 = ((Float)((List)this.BCu.get(i)).get(j)).floatValue();
        f1 = f2;
        if (f2 < this.BCA) {
          f1 = this.BCA;
        }
        f2 = f1;
        if (f1 > this.BCB) {
          f2 = this.BCB;
        }
        f1 = (this.mHeight - f2) / 2.0F;
        int i3 = this.BCx;
        paramCanvas.drawRoundRect(i2, f1, i3 + i2, f1 + f2, this.BCz, this.BCz, this.mPaint);
        j += 1;
      }
      i += 1;
      continue;
      if (SoundWaveView.b.BCN == this.BCq)
      {
        j = getVolumeItemCount();
        i = 0;
        while (i < j)
        {
          k = this.mWidth - (i + 1) * this.BCx - this.BCy * i;
          m = (this.mHeight - ((Integer)this.BCs.get(i)).intValue()) / 2;
          n = this.BCx;
          i1 = ((Integer)this.BCs.get(i)).intValue();
          paramCanvas.drawRoundRect(k, m, k + n, i1 + m, this.BCz, this.BCz, this.mPaint);
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
    if (SoundWaveView.d.BDm == this.BCp) {}
    for (this.mWidth = aq.fromDPToPix(getContext(), c.BDk);; this.mWidth = aq.fromDPToPix(getContext(), c.BDj))
    {
      ad.d("MicroMsg.NewTrans2Txt.SoundWaveView", "style: %s, w: %s, h: %s.", new Object[] { this.BCp, Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
      setMeasuredDimension(this.mWidth, this.mHeight);
      AppMethodBeat.o(185292);
      return;
    }
  }
  
  public void setStyle(SoundWaveView.d paramd)
  {
    AppMethodBeat.i(185303);
    this.BCp = paramd;
    ad.i("MicroMsg.NewTrans2Txt.SoundWaveView", "set style %s", new Object[] { this.BCp });
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
    static int BCR;
    static int BCS;
    static int BCT;
    static int BCU;
    static int BCV;
    static int BCW;
    static String BCX;
    static int BCY;
    static int BCZ;
    static int BDa;
    static int BDb;
    static int BDc;
    static int BDd;
    static int BDe;
    static float BDf;
    static float[] BDg;
    static float[] BDh;
    static int BDi;
    static int BDj;
    static int BDk;
    
    static
    {
      AppMethodBeat.i(185284);
      BCR = 2;
      BCS = 1;
      BCT = 1;
      BCU = 4;
      BCV = 34;
      BCW = 10;
      BCX = "#000000";
      BCY = 5;
      BCZ = 5;
      BDa = 2;
      BDb = 300;
      BDc = 100;
      BDd = 500;
      BDe = 1000;
      BDf = 0.8F;
      BDg = new float[] { 0.8F, 0.6F };
      BDh = new float[] { 0.5F, 0.3F };
      BDi = Tx(BCY);
      BDj = Tx(BCY * BCZ);
      BDk = Tx(BCY * BDa);
      AppMethodBeat.o(185284);
    }
    
    private static int Tx(int paramInt)
    {
      return (paramInt - 1) * BCS + BCR * paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.SoundWaveView
 * JD-Core Version:    0.7.0.1
 */