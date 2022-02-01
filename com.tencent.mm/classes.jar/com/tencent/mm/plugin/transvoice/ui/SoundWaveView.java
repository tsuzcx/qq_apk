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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SoundWaveView
  extends View
{
  private Interpolator GuA;
  private int GuB;
  private int GuC;
  private int GuD;
  private int GuE;
  private int GuF;
  private int GuG;
  private int GuH;
  private Runnable GuI;
  private int GuJ;
  private a GuK;
  private SoundWaveView.d Gut;
  private SoundWaveView.b Guu;
  private ArrayList<Integer> Guv;
  private ArrayList<Integer> Guw;
  private ArrayList<AnimatorSet> Gux;
  private List<List<Float>> Guy;
  private List<List<Float>> Guz;
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
    this.Gut = SoundWaveView.d.Gvp;
    this.Guu = SoundWaveView.b.GuR;
    this.Guy = new ArrayList();
    this.Guz = new ArrayList();
    this.GuI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185277);
        Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active waiting!!!");
        SoundWaveView.a(SoundWaveView.this, SoundWaveView.b.GuR);
        SoundWaveView.a(SoundWaveView.this);
        AppMethodBeat.o(185277);
      }
    };
    this.GuJ = -1;
    this.GuK = new a((byte)0);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(185288);
  }
  
  private void a(float paramFloat, final List<Float> paramList)
  {
    AppMethodBeat.i(186026);
    int j = c.Gvc;
    int k = j / 2;
    final int i = 0;
    if (i < j)
    {
      final float f = (float)(paramFloat * Math.pow(c.Gvj, Math.abs(k - i)));
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
  
  private void aAM()
  {
    AppMethodBeat.i(185295);
    this.GuJ = -1;
    fAA();
    fAE();
    fAF();
    AppMethodBeat.o(185295);
  }
  
  private boolean acs(int paramInt)
  {
    return (paramInt >= this.GuK.start) && (paramInt <= this.GuK.end);
  }
  
  private boolean act(int paramInt)
  {
    AppMethodBeat.i(185297);
    if (!acs(paramInt))
    {
      AppMethodBeat.o(185297);
      return true;
    }
    AppMethodBeat.o(185297);
    return false;
  }
  
  private void fAA()
  {
    AppMethodBeat.i(185291);
    int j = getVolumeItemCount();
    int i = 0;
    while (i < j)
    {
      this.Guw.set(i, Integer.valueOf(this.GuE));
      i += 1;
    }
    AppMethodBeat.o(185291);
  }
  
  private void fAB()
  {
    AppMethodBeat.i(186024);
    Iterator localIterator = this.Guy.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.GuE));
        i += 1;
      }
    }
    AppMethodBeat.o(186024);
  }
  
  private void fAC()
  {
    AppMethodBeat.i(186025);
    Iterator localIterator = this.Guz.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.GuE));
        i += 1;
      }
    }
    AppMethodBeat.o(186025);
  }
  
  private void fAD()
  {
    AppMethodBeat.i(185298);
    this.Gux.clear();
    int j = getVolumeItemCount();
    final int i = 0;
    while (i < j)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setStartDelay(c.Gvg * i);
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
      ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { this.GuE, this.GuG });
      localValueAnimator1.setDuration(c.Gvh);
      localValueAnimator1.addUpdateListener(local6);
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { this.GuG, this.GuE });
      localValueAnimator2.setDuration(c.Gvh);
      localValueAnimator2.addUpdateListener(local6);
      ValueAnimator localValueAnimator3 = ValueAnimator.ofInt(new int[] { this.GuE, this.GuE });
      localValueAnimator3.setDuration(c.Gvi);
      localValueAnimator3.addUpdateListener(local6);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(186023);
          Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "AnimatorSet onAnimationEnd, mode: %s", new Object[] { SoundWaveView.e(SoundWaveView.this) });
          if ((SoundWaveView.b.GuR == SoundWaveView.e(SoundWaveView.this)) && (i == SoundWaveView.f(SoundWaveView.this).size() - 1) && (SoundWaveView.this.isShown()))
          {
            Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "restart waiting anim!!!");
            SoundWaveView.g(SoundWaveView.this);
          }
          AppMethodBeat.o(186023);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      localAnimatorSet.playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2, localValueAnimator3 });
      this.Gux.add(localAnimatorSet);
      i += 1;
    }
    AppMethodBeat.o(185298);
  }
  
  private void fAE()
  {
    AppMethodBeat.i(185299);
    Iterator localIterator = this.Gux.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).end();
    }
    AppMethodBeat.o(185299);
  }
  
  private void fAF()
  {
    AppMethodBeat.i(185300);
    Iterator localIterator = this.Gux.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).start();
    }
    AppMethodBeat.o(185300);
  }
  
  private void fAG()
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
      this.GuK.start = i;
      this.GuK.end = j;
      Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "initBaseBundleGroupInfo: %s", new Object[] { this.GuK.toString() });
      AppMethodBeat.o(185301);
      return;
      i = k - 1;
      break;
      label87:
      j = k + 1;
    }
  }
  
  private void fAz()
  {
    AppMethodBeat.i(185290);
    int j = getBundleCount();
    int i = 0;
    while (i < j)
    {
      this.Guv.set(i, Integer.valueOf(this.GuE));
      i += 1;
    }
    AppMethodBeat.o(185290);
  }
  
  private int getActiveBundleIndex()
  {
    AppMethodBeat.i(185302);
    Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, mLastActiveBundleIndex: %s.", new Object[] { Integer.valueOf(this.GuJ) });
    if (-1 == this.GuJ)
    {
      this.GuJ = (new Random().nextInt(this.GuK.end - this.GuK.start + 1) + this.GuK.start);
      i = this.GuJ;
      AppMethodBeat.o(185302);
      return i;
    }
    int i = new Random().nextInt(3);
    int j;
    if (1 == i)
    {
      j = this.GuJ - 1;
      i = j;
      if (act(j))
      {
        j = this.GuJ + 1;
        i = j;
        if (act(j))
        {
          Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.GuJ), this.GuK });
          i = this.GuJ;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    if (2 == i)
    {
      j = this.GuJ + 1;
      i = j;
      if (act(j))
      {
        j = this.GuJ - 1;
        i = j;
        if (act(j))
        {
          Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.GuJ), this.GuK });
          i = this.GuJ;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    i = this.GuJ;
    AppMethodBeat.o(185302);
    return i;
  }
  
  private int getBundleCount()
  {
    int i = c.Gvd;
    if (SoundWaveView.d.Gvq == this.Gut) {
      i = c.Gve;
    }
    return i;
  }
  
  private int getVolumeItemCount()
  {
    AppMethodBeat.i(185296);
    int i = getBundleCount();
    int j = c.Gvc;
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
      i = paramContext.getInt(0, SoundWaveView.d.Gvp.ordinal());
      if (i == SoundWaveView.d.Gvp.ordinal())
      {
        this.Gut = SoundWaveView.d.Gvp;
        paramContext.recycle();
        Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "init style %s", new Object[] { this.Gut });
      }
    }
    else
    {
      this.GuB = at.fromDPToPix(getContext(), c.GuV);
      this.GuC = at.fromDPToPix(getContext(), c.GuW);
      this.GuD = at.fromDPToPix(getContext(), c.GuX);
      this.GuE = at.fromDPToPix(getContext(), c.GuY);
      this.GuF = at.fromDPToPix(getContext(), c.GuZ);
      this.GuG = at.fromDPToPix(getContext(), c.Gva);
      this.GuH = at.fromDPToPix(getContext(), c.Gvm);
      this.mWidth = at.fromDPToPix(getContext(), c.Gvn);
      this.mHeight = at.fromDPToPix(getContext(), c.GuZ);
      this.Guv = new ArrayList();
      i = 0;
    }
    for (;;)
    {
      if (i >= c.Gvd) {
        break label376;
      }
      this.Guv.add(Integer.valueOf(this.GuE));
      paramContext = new ArrayList();
      paramAttributeSet = new ArrayList();
      int j = 0;
      for (;;)
      {
        if (j < c.Gvc)
        {
          paramContext.add(Float.valueOf(this.GuE));
          paramAttributeSet.add(Float.valueOf(this.GuE));
          j += 1;
          continue;
          if (i == SoundWaveView.d.Gvq.ordinal())
          {
            this.Gut = SoundWaveView.d.Gvq;
            break;
          }
          Log.e("MicroMsg.NewTrans2Txt.SoundWaveView", "style err! %s", new Object[] { Integer.valueOf(i) });
          break;
        }
      }
      this.Guy.add(paramContext);
      this.Guz.add(paramAttributeSet);
      i += 1;
    }
    label376:
    this.Guw = new ArrayList();
    int i = k;
    while (i < c.Gvc * c.Gvd)
    {
      this.Guw.add(Integer.valueOf(this.GuE));
      i += 1;
    }
    fAz();
    fAA();
    this.Gux = new ArrayList(c.Gvc * c.Gvd);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (paramContext = new PathInterpolator(0.0F, 0.5F, 0.2F, 1.0F);; paramContext = new e())
    {
      this.GuA = paramContext;
      fAG();
      fAD();
      this.mPaint = new Paint(1);
      this.mPaint.setColor(Color.parseColor(c.Gvb));
      this.mPaint.setAlpha(128);
      AppMethodBeat.o(185289);
      return;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(185305);
    fAB();
    fAC();
    this.Guu = SoundWaveView.b.GuR;
    aAM();
    AppMethodBeat.o(185305);
  }
  
  public final void a(SoundWaveView.d paramd)
  {
    AppMethodBeat.i(185304);
    this.Gut = paramd;
    fAz();
    fAA();
    fAG();
    fAD();
    Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "update style %s", new Object[] { this.Gut });
    requestLayout();
    reset();
    AppMethodBeat.o(185304);
  }
  
  public final void acr(int paramInt)
  {
    AppMethodBeat.i(185294);
    float f = paramInt / 100.0F;
    Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "iVolume %s, fVolume %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(f) });
    int j;
    final int i;
    ArrayList localArrayList;
    label293:
    int k;
    int m;
    if (f <= 0.05D)
    {
      if (SoundWaveView.b.GuS == this.Guu)
      {
        this.Guu = SoundWaveView.b.GuT;
        postDelayed(this.GuI, c.Gvf);
      }
      if ((SoundWaveView.b.GuS != this.Guu) && (SoundWaveView.b.GuT != this.Guu)) {
        break label799;
      }
      fAz();
      f = this.GuA.getInterpolation(f);
      Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "PathInterpolatorCompat value: %s.", new Object[] { Float.valueOf(f) });
      j = (int)(f * this.GuF);
      i = getActiveBundleIndex();
      Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, activeBundleIndex: %s", new Object[] { Integer.valueOf(i) });
      this.Guv.set(i, Integer.valueOf(j));
      paramInt = new Random().nextInt(2);
      if (this.GuK.start != i) {
        break label470;
      }
      this.Guv.set(this.GuK.end, Integer.valueOf((int)(j * c.Gvk[paramInt])));
      if (this.GuK.end - 1 != this.GuK.start)
      {
        localArrayList = this.Guv;
        i = this.GuK.end;
        f = j;
        localArrayList.set(i - 1, Integer.valueOf((int)(c.Gvk[(1 - paramInt)] * f)));
      }
      k = getBundleCount();
      paramInt = new Random().nextInt(2);
      if (k != c.Gvd) {
        break label714;
      }
      m = k / 2;
      i = 0;
      label327:
      if (i >= k) {
        break label795;
      }
      if (!act(i)) {
        break label809;
      }
      this.Guv.set(i, Integer.valueOf((int)(j * c.Gvl[paramInt])));
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
        if (SoundWaveView.b.GuT == this.Guu)
        {
          Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "cancel judging!!!");
          this.Guu = SoundWaveView.b.GuS;
          removeCallbacks(this.GuI);
        }
        if (SoundWaveView.b.GuR != this.Guu) {
          break;
        }
        Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active reacting!!!");
        this.Guu = SoundWaveView.b.GuS;
        fAE();
        break;
        label470:
        if (this.GuK.end == i)
        {
          this.Guv.set(this.GuK.start, Integer.valueOf((int)(j * c.Gvk[paramInt])));
          if (this.GuK.start + 1 == this.GuK.end) {
            break label293;
          }
          localArrayList = this.Guv;
          i = this.GuK.start;
          f = j;
          localArrayList.set(i + 1, Integer.valueOf((int)(c.Gvk[(1 - paramInt)] * f)));
          break label293;
        }
        this.Guv.set(this.GuK.start, Integer.valueOf((int)(j * c.Gvk[paramInt])));
        localArrayList = this.Guv;
        i = this.GuK.end;
        f = j;
        localArrayList.set(i, Integer.valueOf((int)(c.Gvk[paramInt] * f)));
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
          a(((Integer)this.Guv.get(i)).intValue(), (List)this.Guz.get(i));
        }
      }
      label714:
      i = 0;
      if (i < k)
      {
        if (!act(i)) {
          break label806;
        }
        this.Guv.set(i, Integer.valueOf((int)(j * c.Gvl[paramInt])));
        paramInt = 1 - paramInt;
      }
      for (;;)
      {
        a(((Integer)this.Guv.get(i)).intValue(), (List)this.Guz.get(i));
        i += 1;
        break;
        invalidate();
        AppMethodBeat.o(185294);
        return;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(185293);
    super.onDraw(paramCanvas);
    int k;
    int i;
    if ((SoundWaveView.b.GuS == this.Guu) || (SoundWaveView.b.GuT == this.Guu))
    {
      k = getBundleCount();
      i = 0;
    }
    while (i < k)
    {
      ((Integer)this.Guv.get(i)).intValue();
      int m = c.Gvc;
      int j = 0;
      float f1;
      float f2;
      while (j < m)
      {
        f1 = ((Float)((List)this.Guz.get(i)).get(j)).floatValue();
        f2 = ((Float)((List)this.Guy.get(i)).get(j)).floatValue();
        ((List)this.Guy.get(i)).set(j, Float.valueOf((f1 - f2) / 6.0F + f2));
        j += 1;
      }
      int n = this.GuH;
      int i1 = this.GuC;
      j = 0;
      while (j < m)
      {
        int i2 = this.GuB * j + this.GuC * j + (n * i + i1 * i);
        f2 = ((Float)((List)this.Guy.get(i)).get(j)).floatValue();
        f1 = f2;
        if (f2 < this.GuE) {
          f1 = this.GuE;
        }
        f2 = f1;
        if (f1 > this.GuF) {
          f2 = this.GuF;
        }
        f1 = (this.mHeight - f2) / 2.0F;
        int i3 = this.GuB;
        paramCanvas.drawRoundRect(i2, f1, i3 + i2, f1 + f2, this.GuD, this.GuD, this.mPaint);
        j += 1;
      }
      i += 1;
      continue;
      if (SoundWaveView.b.GuR == this.Guu)
      {
        j = getVolumeItemCount();
        i = 0;
        while (i < j)
        {
          k = this.mWidth - (i + 1) * this.GuB - this.GuC * i;
          m = (this.mHeight - ((Integer)this.Guw.get(i)).intValue()) / 2;
          n = this.GuB;
          i1 = ((Integer)this.Guw.get(i)).intValue();
          paramCanvas.drawRoundRect(k, m, k + n, i1 + m, this.GuD, this.GuD, this.mPaint);
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
    if (SoundWaveView.d.Gvq == this.Gut) {}
    for (this.mWidth = at.fromDPToPix(getContext(), c.Gvo);; this.mWidth = at.fromDPToPix(getContext(), c.Gvn))
    {
      Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "style: %s, w: %s, h: %s.", new Object[] { this.Gut, Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
      setMeasuredDimension(this.mWidth, this.mHeight);
      AppMethodBeat.o(185292);
      return;
    }
  }
  
  public void setStyle(SoundWaveView.d paramd)
  {
    AppMethodBeat.i(185303);
    this.Gut = paramd;
    Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "set style %s", new Object[] { this.Gut });
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
    static int GuV;
    static int GuW;
    static int GuX;
    static int GuY;
    static int GuZ;
    static int Gva;
    static String Gvb;
    static int Gvc;
    static int Gvd;
    static int Gve;
    static int Gvf;
    static int Gvg;
    static int Gvh;
    static int Gvi;
    static float Gvj;
    static float[] Gvk;
    static float[] Gvl;
    static int Gvm;
    static int Gvn;
    static int Gvo;
    
    static
    {
      AppMethodBeat.i(185284);
      GuV = 2;
      GuW = 1;
      GuX = 1;
      GuY = 4;
      GuZ = 34;
      Gva = 10;
      Gvb = "#000000";
      Gvc = 5;
      Gvd = 5;
      Gve = 2;
      Gvf = 300;
      Gvg = 100;
      Gvh = 500;
      Gvi = 1000;
      Gvj = 0.8F;
      Gvk = new float[] { 0.8F, 0.6F };
      Gvl = new float[] { 0.5F, 0.3F };
      Gvm = acu(Gvc);
      Gvn = acu(Gvc * Gvd);
      Gvo = acu(Gvc * Gve);
      AppMethodBeat.o(185284);
    }
    
    private static int acu(int paramInt)
    {
      return (paramInt - 1) * GuW + GuV * paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.SoundWaveView
 * JD-Core Version:    0.7.0.1
 */