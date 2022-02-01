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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.aq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SoundWaveView
  extends View
{
  private SoundWaveView.d BTN;
  private SoundWaveView.b BTO;
  private ArrayList<Integer> BTP;
  private ArrayList<Integer> BTQ;
  private ArrayList<AnimatorSet> BTR;
  private List<List<Float>> BTS;
  private List<List<Float>> BTT;
  private Interpolator BTU;
  private int BTV;
  private int BTW;
  private int BTX;
  private int BTY;
  private int BTZ;
  private int BUa;
  private int BUb;
  private Runnable BUc;
  private int BUd;
  private a BUe;
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
    this.BTN = SoundWaveView.d.BUJ;
    this.BTO = SoundWaveView.b.BUl;
    this.BTS = new ArrayList();
    this.BTT = new ArrayList();
    this.BUc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185277);
        ae.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active waiting!!!");
        SoundWaveView.a(SoundWaveView.this, SoundWaveView.b.BUl);
        SoundWaveView.a(SoundWaveView.this);
        AppMethodBeat.o(185277);
      }
    };
    this.BUd = -1;
    this.BUe = new a((byte)0);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(185288);
  }
  
  private boolean Uc(int paramInt)
  {
    return (paramInt >= this.BUe.start) && (paramInt <= this.BUe.end);
  }
  
  private boolean Ud(int paramInt)
  {
    AppMethodBeat.i(185297);
    if (!Uc(paramInt))
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
    int j = c.BUw;
    int k = j / 2;
    final int i = 0;
    if (i < j)
    {
      final float f = (float)(paramFloat * Math.pow(c.BUD, Math.abs(k - i)));
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
  
  private void akw()
  {
    AppMethodBeat.i(185295);
    this.BUd = -1;
    evh();
    evl();
    evm();
    AppMethodBeat.o(185295);
  }
  
  private void evg()
  {
    AppMethodBeat.i(185290);
    int j = getBundleCount();
    int i = 0;
    while (i < j)
    {
      this.BTP.set(i, Integer.valueOf(this.BTY));
      i += 1;
    }
    AppMethodBeat.o(185290);
  }
  
  private void evh()
  {
    AppMethodBeat.i(185291);
    int j = getVolumeItemCount();
    int i = 0;
    while (i < j)
    {
      this.BTQ.set(i, Integer.valueOf(this.BTY));
      i += 1;
    }
    AppMethodBeat.o(185291);
  }
  
  private void evi()
  {
    AppMethodBeat.i(186024);
    Iterator localIterator = this.BTS.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.BTY));
        i += 1;
      }
    }
    AppMethodBeat.o(186024);
  }
  
  private void evj()
  {
    AppMethodBeat.i(186025);
    Iterator localIterator = this.BTT.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.BTY));
        i += 1;
      }
    }
    AppMethodBeat.o(186025);
  }
  
  private void evk()
  {
    AppMethodBeat.i(185298);
    this.BTR.clear();
    int j = getVolumeItemCount();
    final int i = 0;
    while (i < j)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setStartDelay(c.BUA * i);
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
      ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { this.BTY, this.BUa });
      localValueAnimator1.setDuration(c.BUB);
      localValueAnimator1.addUpdateListener(local6);
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { this.BUa, this.BTY });
      localValueAnimator2.setDuration(c.BUB);
      localValueAnimator2.addUpdateListener(local6);
      ValueAnimator localValueAnimator3 = ValueAnimator.ofInt(new int[] { this.BTY, this.BTY });
      localValueAnimator3.setDuration(c.BUC);
      localValueAnimator3.addUpdateListener(local6);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(186023);
          ae.d("MicroMsg.NewTrans2Txt.SoundWaveView", "AnimatorSet onAnimationEnd, mode: %s", new Object[] { SoundWaveView.e(SoundWaveView.this) });
          if ((SoundWaveView.b.BUl == SoundWaveView.e(SoundWaveView.this)) && (i == SoundWaveView.f(SoundWaveView.this).size() - 1) && (SoundWaveView.this.isShown()))
          {
            ae.d("MicroMsg.NewTrans2Txt.SoundWaveView", "restart waiting anim!!!");
            SoundWaveView.g(SoundWaveView.this);
          }
          AppMethodBeat.o(186023);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      localAnimatorSet.playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2, localValueAnimator3 });
      this.BTR.add(localAnimatorSet);
      i += 1;
    }
    AppMethodBeat.o(185298);
  }
  
  private void evl()
  {
    AppMethodBeat.i(185299);
    Iterator localIterator = this.BTR.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).end();
    }
    AppMethodBeat.o(185299);
  }
  
  private void evm()
  {
    AppMethodBeat.i(185300);
    Iterator localIterator = this.BTR.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).start();
    }
    AppMethodBeat.o(185300);
  }
  
  private void evn()
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
      this.BUe.start = i;
      this.BUe.end = j;
      ae.i("MicroMsg.NewTrans2Txt.SoundWaveView", "initBaseBundleGroupInfo: %s", new Object[] { this.BUe.toString() });
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
    ae.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, mLastActiveBundleIndex: %s.", new Object[] { Integer.valueOf(this.BUd) });
    if (-1 == this.BUd)
    {
      this.BUd = (new Random().nextInt(this.BUe.end - this.BUe.start + 1) + this.BUe.start);
      i = this.BUd;
      AppMethodBeat.o(185302);
      return i;
    }
    int i = new Random().nextInt(3);
    int j;
    if (1 == i)
    {
      j = this.BUd - 1;
      i = j;
      if (Ud(j))
      {
        j = this.BUd + 1;
        i = j;
        if (Ud(j))
        {
          ae.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.BUd), this.BUe });
          i = this.BUd;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    if (2 == i)
    {
      j = this.BUd + 1;
      i = j;
      if (Ud(j))
      {
        j = this.BUd - 1;
        i = j;
        if (Ud(j))
        {
          ae.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.BUd), this.BUe });
          i = this.BUd;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    i = this.BUd;
    AppMethodBeat.o(185302);
    return i;
  }
  
  private int getBundleCount()
  {
    int i = c.BUx;
    if (SoundWaveView.d.BUK == this.BTN) {
      i = c.BUy;
    }
    return i;
  }
  
  private int getVolumeItemCount()
  {
    AppMethodBeat.i(185296);
    int i = getBundleCount();
    int j = c.BUw;
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
      i = paramContext.getInt(0, SoundWaveView.d.BUJ.ordinal());
      if (i == SoundWaveView.d.BUJ.ordinal())
      {
        this.BTN = SoundWaveView.d.BUJ;
        paramContext.recycle();
        ae.i("MicroMsg.NewTrans2Txt.SoundWaveView", "init style %s", new Object[] { this.BTN });
      }
    }
    else
    {
      this.BTV = aq.fromDPToPix(getContext(), c.BUp);
      this.BTW = aq.fromDPToPix(getContext(), c.BUq);
      this.BTX = aq.fromDPToPix(getContext(), c.BUr);
      this.BTY = aq.fromDPToPix(getContext(), c.BUs);
      this.BTZ = aq.fromDPToPix(getContext(), c.BUt);
      this.BUa = aq.fromDPToPix(getContext(), c.BUu);
      this.BUb = aq.fromDPToPix(getContext(), c.BUG);
      this.mWidth = aq.fromDPToPix(getContext(), c.BUH);
      this.mHeight = aq.fromDPToPix(getContext(), c.BUt);
      this.BTP = new ArrayList();
      i = 0;
    }
    for (;;)
    {
      if (i >= c.BUx) {
        break label376;
      }
      this.BTP.add(Integer.valueOf(this.BTY));
      paramContext = new ArrayList();
      paramAttributeSet = new ArrayList();
      int j = 0;
      for (;;)
      {
        if (j < c.BUw)
        {
          paramContext.add(Float.valueOf(this.BTY));
          paramAttributeSet.add(Float.valueOf(this.BTY));
          j += 1;
          continue;
          if (i == SoundWaveView.d.BUK.ordinal())
          {
            this.BTN = SoundWaveView.d.BUK;
            break;
          }
          ae.e("MicroMsg.NewTrans2Txt.SoundWaveView", "style err! %s", new Object[] { Integer.valueOf(i) });
          break;
        }
      }
      this.BTS.add(paramContext);
      this.BTT.add(paramAttributeSet);
      i += 1;
    }
    label376:
    this.BTQ = new ArrayList();
    int i = k;
    while (i < c.BUw * c.BUx)
    {
      this.BTQ.add(Integer.valueOf(this.BTY));
      i += 1;
    }
    evg();
    evh();
    this.BTR = new ArrayList(c.BUw * c.BUx);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (paramContext = new PathInterpolator(0.0F, 0.5F, 0.2F, 1.0F);; paramContext = new e())
    {
      this.BTU = paramContext;
      evn();
      evk();
      this.mPaint = new Paint(1);
      this.mPaint.setColor(Color.parseColor(c.BUv));
      this.mPaint.setAlpha(128);
      AppMethodBeat.o(185289);
      return;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(185305);
    evi();
    evj();
    this.BTO = SoundWaveView.b.BUl;
    akw();
    AppMethodBeat.o(185305);
  }
  
  public final void Ub(int paramInt)
  {
    AppMethodBeat.i(185294);
    float f = paramInt / 100.0F;
    ae.d("MicroMsg.NewTrans2Txt.SoundWaveView", "iVolume %s, fVolume %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(f) });
    int j;
    final int i;
    ArrayList localArrayList;
    label293:
    int k;
    int m;
    if (f <= 0.05D)
    {
      if (SoundWaveView.b.BUm == this.BTO)
      {
        this.BTO = SoundWaveView.b.BUn;
        postDelayed(this.BUc, c.BUz);
      }
      if ((SoundWaveView.b.BUm != this.BTO) && (SoundWaveView.b.BUn != this.BTO)) {
        break label799;
      }
      evg();
      f = this.BTU.getInterpolation(f);
      ae.d("MicroMsg.NewTrans2Txt.SoundWaveView", "PathInterpolatorCompat value: %s.", new Object[] { Float.valueOf(f) });
      j = (int)(f * this.BTZ);
      i = getActiveBundleIndex();
      ae.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, activeBundleIndex: %s", new Object[] { Integer.valueOf(i) });
      this.BTP.set(i, Integer.valueOf(j));
      paramInt = new Random().nextInt(2);
      if (this.BUe.start != i) {
        break label470;
      }
      this.BTP.set(this.BUe.end, Integer.valueOf((int)(j * c.BUE[paramInt])));
      if (this.BUe.end - 1 != this.BUe.start)
      {
        localArrayList = this.BTP;
        i = this.BUe.end;
        f = j;
        localArrayList.set(i - 1, Integer.valueOf((int)(c.BUE[(1 - paramInt)] * f)));
      }
      k = getBundleCount();
      paramInt = new Random().nextInt(2);
      if (k != c.BUx) {
        break label714;
      }
      m = k / 2;
      i = 0;
      label327:
      if (i >= k) {
        break label795;
      }
      if (!Ud(i)) {
        break label809;
      }
      this.BTP.set(i, Integer.valueOf((int)(j * c.BUF[paramInt])));
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
        if (SoundWaveView.b.BUn == this.BTO)
        {
          ae.i("MicroMsg.NewTrans2Txt.SoundWaveView", "cancel judging!!!");
          this.BTO = SoundWaveView.b.BUm;
          removeCallbacks(this.BUc);
        }
        if (SoundWaveView.b.BUl != this.BTO) {
          break;
        }
        ae.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active reacting!!!");
        this.BTO = SoundWaveView.b.BUm;
        evl();
        break;
        label470:
        if (this.BUe.end == i)
        {
          this.BTP.set(this.BUe.start, Integer.valueOf((int)(j * c.BUE[paramInt])));
          if (this.BUe.start + 1 == this.BUe.end) {
            break label293;
          }
          localArrayList = this.BTP;
          i = this.BUe.start;
          f = j;
          localArrayList.set(i + 1, Integer.valueOf((int)(c.BUE[(1 - paramInt)] * f)));
          break label293;
        }
        this.BTP.set(this.BUe.start, Integer.valueOf((int)(j * c.BUE[paramInt])));
        localArrayList = this.BTP;
        i = this.BUe.end;
        f = j;
        localArrayList.set(i, Integer.valueOf((int)(c.BUE[paramInt] * f)));
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
          a(((Integer)this.BTP.get(i)).intValue(), (List)this.BTT.get(i));
        }
      }
      label714:
      i = 0;
      if (i < k)
      {
        if (!Ud(i)) {
          break label806;
        }
        this.BTP.set(i, Integer.valueOf((int)(j * c.BUF[paramInt])));
        paramInt = 1 - paramInt;
      }
      for (;;)
      {
        a(((Integer)this.BTP.get(i)).intValue(), (List)this.BTT.get(i));
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
    this.BTN = paramd;
    evg();
    evh();
    evn();
    evk();
    ae.i("MicroMsg.NewTrans2Txt.SoundWaveView", "update style %s", new Object[] { this.BTN });
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
    if ((SoundWaveView.b.BUm == this.BTO) || (SoundWaveView.b.BUn == this.BTO))
    {
      k = getBundleCount();
      i = 0;
    }
    while (i < k)
    {
      ((Integer)this.BTP.get(i)).intValue();
      int m = c.BUw;
      int j = 0;
      float f1;
      float f2;
      while (j < m)
      {
        f1 = ((Float)((List)this.BTT.get(i)).get(j)).floatValue();
        f2 = ((Float)((List)this.BTS.get(i)).get(j)).floatValue();
        ((List)this.BTS.get(i)).set(j, Float.valueOf((f1 - f2) / 6.0F + f2));
        j += 1;
      }
      int n = this.BUb;
      int i1 = this.BTW;
      j = 0;
      while (j < m)
      {
        int i2 = this.BTV * j + this.BTW * j + (n * i + i1 * i);
        f2 = ((Float)((List)this.BTS.get(i)).get(j)).floatValue();
        f1 = f2;
        if (f2 < this.BTY) {
          f1 = this.BTY;
        }
        f2 = f1;
        if (f1 > this.BTZ) {
          f2 = this.BTZ;
        }
        f1 = (this.mHeight - f2) / 2.0F;
        int i3 = this.BTV;
        paramCanvas.drawRoundRect(i2, f1, i3 + i2, f1 + f2, this.BTX, this.BTX, this.mPaint);
        j += 1;
      }
      i += 1;
      continue;
      if (SoundWaveView.b.BUl == this.BTO)
      {
        j = getVolumeItemCount();
        i = 0;
        while (i < j)
        {
          k = this.mWidth - (i + 1) * this.BTV - this.BTW * i;
          m = (this.mHeight - ((Integer)this.BTQ.get(i)).intValue()) / 2;
          n = this.BTV;
          i1 = ((Integer)this.BTQ.get(i)).intValue();
          paramCanvas.drawRoundRect(k, m, k + n, i1 + m, this.BTX, this.BTX, this.mPaint);
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
    if (SoundWaveView.d.BUK == this.BTN) {}
    for (this.mWidth = aq.fromDPToPix(getContext(), c.BUI);; this.mWidth = aq.fromDPToPix(getContext(), c.BUH))
    {
      ae.d("MicroMsg.NewTrans2Txt.SoundWaveView", "style: %s, w: %s, h: %s.", new Object[] { this.BTN, Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
      setMeasuredDimension(this.mWidth, this.mHeight);
      AppMethodBeat.o(185292);
      return;
    }
  }
  
  public void setStyle(SoundWaveView.d paramd)
  {
    AppMethodBeat.i(185303);
    this.BTN = paramd;
    ae.i("MicroMsg.NewTrans2Txt.SoundWaveView", "set style %s", new Object[] { this.BTN });
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
    static int BUA;
    static int BUB;
    static int BUC;
    static float BUD;
    static float[] BUE;
    static float[] BUF;
    static int BUG;
    static int BUH;
    static int BUI;
    static int BUp;
    static int BUq;
    static int BUr;
    static int BUs;
    static int BUt;
    static int BUu;
    static String BUv;
    static int BUw;
    static int BUx;
    static int BUy;
    static int BUz;
    
    static
    {
      AppMethodBeat.i(185284);
      BUp = 2;
      BUq = 1;
      BUr = 1;
      BUs = 4;
      BUt = 34;
      BUu = 10;
      BUv = "#000000";
      BUw = 5;
      BUx = 5;
      BUy = 2;
      BUz = 300;
      BUA = 100;
      BUB = 500;
      BUC = 1000;
      BUD = 0.8F;
      BUE = new float[] { 0.8F, 0.6F };
      BUF = new float[] { 0.5F, 0.3F };
      BUG = Ue(BUw);
      BUH = Ue(BUw * BUx);
      BUI = Ue(BUw * BUy);
      AppMethodBeat.o(185284);
    }
    
    private static int Ue(int paramInt)
    {
      return (paramInt - 1) * BUq + BUp * paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.SoundWaveView
 * JD-Core Version:    0.7.0.1
 */