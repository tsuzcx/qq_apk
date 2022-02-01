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
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.core.g.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.transvoice.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SoundWaveView
  extends View
{
  private SoundWaveView.d NhM;
  private SoundWaveView.b NhN;
  private ArrayList<Integer> NhO;
  private ArrayList<Integer> NhP;
  private ArrayList<AnimatorSet> NhQ;
  private List<List<Float>> NhR;
  private List<List<Float>> NhS;
  private Interpolator NhT;
  private int NhU;
  private int NhV;
  private int NhW;
  private int NhX;
  private int NhY;
  private int NhZ;
  private int Nia;
  private Runnable Nib;
  private int Nic;
  private a Nid;
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
    this.NhM = SoundWaveView.d.NiI;
    this.NhN = SoundWaveView.b.Nik;
    this.NhR = new ArrayList();
    this.NhS = new ArrayList();
    this.Nib = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185277);
        Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active waiting!!!");
        SoundWaveView.a(SoundWaveView.this, SoundWaveView.b.Nik);
        SoundWaveView.a(SoundWaveView.this);
        AppMethodBeat.o(185277);
      }
    };
    this.Nic = -1;
    this.Nid = new a((byte)0);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(185288);
  }
  
  private void a(float paramFloat, final List<Float> paramList)
  {
    AppMethodBeat.i(186026);
    int j = c.Niv;
    int k = j / 2;
    final int i = 0;
    if (i < j)
    {
      final float f = (float)(paramFloat * Math.pow(c.NiC, Math.abs(k - i)));
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
  
  private void aIp()
  {
    AppMethodBeat.i(185295);
    this.Nic = -1;
    gsB();
    gsF();
    gsG();
    AppMethodBeat.o(185295);
  }
  
  private boolean ajZ(int paramInt)
  {
    return (paramInt >= this.Nid.start) && (paramInt <= this.Nid.end);
  }
  
  private boolean aka(int paramInt)
  {
    AppMethodBeat.i(185297);
    if (!ajZ(paramInt))
    {
      AppMethodBeat.o(185297);
      return true;
    }
    AppMethodBeat.o(185297);
    return false;
  }
  
  private int getActiveBundleIndex()
  {
    AppMethodBeat.i(185302);
    Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, mLastActiveBundleIndex: %s.", new Object[] { Integer.valueOf(this.Nic) });
    if (-1 == this.Nic)
    {
      this.Nic = (new Random().nextInt(this.Nid.end - this.Nid.start + 1) + this.Nid.start);
      i = this.Nic;
      AppMethodBeat.o(185302);
      return i;
    }
    int i = new Random().nextInt(3);
    int j;
    if (1 == i)
    {
      j = this.Nic - 1;
      i = j;
      if (aka(j))
      {
        j = this.Nic + 1;
        i = j;
        if (aka(j))
        {
          Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.Nic), this.Nid });
          i = this.Nic;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    if (2 == i)
    {
      j = this.Nic + 1;
      i = j;
      if (aka(j))
      {
        j = this.Nic - 1;
        i = j;
        if (aka(j))
        {
          Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.Nic), this.Nid });
          i = this.Nic;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    i = this.Nic;
    AppMethodBeat.o(185302);
    return i;
  }
  
  private int getBundleCount()
  {
    int i = c.Niw;
    if (SoundWaveView.d.NiJ == this.NhM) {
      i = c.Nix;
    }
    return i;
  }
  
  private int getVolumeItemCount()
  {
    AppMethodBeat.i(185296);
    int i = getBundleCount();
    int j = c.Niv;
    AppMethodBeat.o(185296);
    return i * j;
  }
  
  private void gsA()
  {
    AppMethodBeat.i(185290);
    int j = getBundleCount();
    int i = 0;
    while (i < j)
    {
      this.NhO.set(i, Integer.valueOf(this.NhX));
      i += 1;
    }
    AppMethodBeat.o(185290);
  }
  
  private void gsB()
  {
    AppMethodBeat.i(185291);
    int j = getVolumeItemCount();
    int i = 0;
    while (i < j)
    {
      this.NhP.set(i, Integer.valueOf(this.NhX));
      i += 1;
    }
    AppMethodBeat.o(185291);
  }
  
  private void gsC()
  {
    AppMethodBeat.i(186024);
    Iterator localIterator = this.NhR.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.NhX));
        i += 1;
      }
    }
    AppMethodBeat.o(186024);
  }
  
  private void gsD()
  {
    AppMethodBeat.i(186025);
    Iterator localIterator = this.NhS.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.NhX));
        i += 1;
      }
    }
    AppMethodBeat.o(186025);
  }
  
  private void gsE()
  {
    AppMethodBeat.i(185298);
    this.NhQ.clear();
    int j = getVolumeItemCount();
    final int i = 0;
    while (i < j)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setStartDelay(c.Niz * i);
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
      ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { this.NhX, this.NhZ });
      localValueAnimator1.setDuration(c.NiA);
      localValueAnimator1.addUpdateListener(local6);
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { this.NhZ, this.NhX });
      localValueAnimator2.setDuration(c.NiA);
      localValueAnimator2.addUpdateListener(local6);
      ValueAnimator localValueAnimator3 = ValueAnimator.ofInt(new int[] { this.NhX, this.NhX });
      localValueAnimator3.setDuration(c.NiB);
      localValueAnimator3.addUpdateListener(local6);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(186023);
          Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "AnimatorSet onAnimationEnd, mode: %s", new Object[] { SoundWaveView.e(SoundWaveView.this) });
          if ((SoundWaveView.b.Nik == SoundWaveView.e(SoundWaveView.this)) && (i == SoundWaveView.f(SoundWaveView.this).size() - 1) && (SoundWaveView.this.isShown()))
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
      this.NhQ.add(localAnimatorSet);
      i += 1;
    }
    AppMethodBeat.o(185298);
  }
  
  private void gsF()
  {
    AppMethodBeat.i(185299);
    Iterator localIterator = this.NhQ.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).end();
    }
    AppMethodBeat.o(185299);
  }
  
  private void gsG()
  {
    AppMethodBeat.i(185300);
    Iterator localIterator = this.NhQ.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).start();
    }
    AppMethodBeat.o(185300);
  }
  
  private void gsH()
  {
    AppMethodBeat.i(185301);
    int j = getBundleCount();
    int k = j / 2;
    int i;
    if (k - 1 < 0)
    {
      i = 0;
      if (k + 1 < j) {
        break label86;
      }
      j -= 1;
    }
    for (;;)
    {
      this.Nid.start = i;
      this.Nid.end = j;
      Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "initBaseBundleGroupInfo: %s", new Object[] { this.Nid.toString() });
      AppMethodBeat.o(185301);
      return;
      i = k - 1;
      break;
      label86:
      j = k + 1;
    }
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    int k = 0;
    AppMethodBeat.i(185289);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.h.eWZ, 0, 0);
      i = paramContext.getInt(a.h.NgQ, SoundWaveView.d.NiI.ordinal());
      if (i == SoundWaveView.d.NiI.ordinal())
      {
        this.NhM = SoundWaveView.d.NiI;
        paramContext.recycle();
        Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "init style %s", new Object[] { this.NhM });
      }
    }
    else
    {
      this.NhU = aw.fromDPToPix(getContext(), c.Nio);
      this.NhV = aw.fromDPToPix(getContext(), c.Nip);
      this.NhW = aw.fromDPToPix(getContext(), c.Niq);
      this.NhX = aw.fromDPToPix(getContext(), c.Nir);
      this.NhY = aw.fromDPToPix(getContext(), c.Nis);
      this.NhZ = aw.fromDPToPix(getContext(), c.Nit);
      this.Nia = aw.fromDPToPix(getContext(), c.NiF);
      this.mWidth = aw.fromDPToPix(getContext(), c.NiG);
      this.mHeight = aw.fromDPToPix(getContext(), c.Nis);
      this.NhO = new ArrayList();
      i = 0;
    }
    for (;;)
    {
      if (i >= c.Niw) {
        break label376;
      }
      this.NhO.add(Integer.valueOf(this.NhX));
      paramContext = new ArrayList();
      paramAttributeSet = new ArrayList();
      int j = 0;
      for (;;)
      {
        if (j < c.Niv)
        {
          paramContext.add(Float.valueOf(this.NhX));
          paramAttributeSet.add(Float.valueOf(this.NhX));
          j += 1;
          continue;
          if (i == SoundWaveView.d.NiJ.ordinal())
          {
            this.NhM = SoundWaveView.d.NiJ;
            break;
          }
          Log.e("MicroMsg.NewTrans2Txt.SoundWaveView", "style err! %s", new Object[] { Integer.valueOf(i) });
          break;
        }
      }
      this.NhR.add(paramContext);
      this.NhS.add(paramAttributeSet);
      i += 1;
    }
    label376:
    this.NhP = new ArrayList();
    int i = k;
    while (i < c.Niv * c.Niw)
    {
      this.NhP.add(Integer.valueOf(this.NhX));
      i += 1;
    }
    gsA();
    gsB();
    this.NhQ = new ArrayList(c.Niv * c.Niw);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (paramContext = new PathInterpolator(0.0F, 0.5F, 0.2F, 1.0F);; paramContext = new a())
    {
      this.NhT = paramContext;
      gsH();
      gsE();
      this.mPaint = new Paint(1);
      this.mPaint.setColor(Color.parseColor(c.Niu));
      this.mPaint.setAlpha(128);
      AppMethodBeat.o(185289);
      return;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(185305);
    gsC();
    gsD();
    this.NhN = SoundWaveView.b.Nik;
    aIp();
    AppMethodBeat.o(185305);
  }
  
  public final void a(SoundWaveView.d paramd)
  {
    AppMethodBeat.i(185304);
    this.NhM = paramd;
    gsA();
    gsB();
    gsH();
    gsE();
    Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "update style %s", new Object[] { this.NhM });
    requestLayout();
    reset();
    AppMethodBeat.o(185304);
  }
  
  public final void ajY(int paramInt)
  {
    AppMethodBeat.i(185294);
    float f = paramInt / 100.0F;
    Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "iVolume %s, fVolume %s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(f) });
    int j;
    final int i;
    ArrayList localArrayList;
    label290:
    int k;
    int m;
    if (f <= 0.05D)
    {
      if (SoundWaveView.b.Nil == this.NhN)
      {
        this.NhN = SoundWaveView.b.Nim;
        postDelayed(this.Nib, c.Niy);
      }
      if ((SoundWaveView.b.Nil != this.NhN) && (SoundWaveView.b.Nim != this.NhN)) {
        break label794;
      }
      gsA();
      f = this.NhT.getInterpolation(f);
      Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "PathInterpolatorCompat value: %s.", new Object[] { Float.valueOf(f) });
      j = (int)(f * this.NhY);
      i = getActiveBundleIndex();
      Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, activeBundleIndex: %s", new Object[] { Integer.valueOf(i) });
      this.NhO.set(i, Integer.valueOf(j));
      paramInt = new Random().nextInt(2);
      if (this.Nid.start != i) {
        break label465;
      }
      this.NhO.set(this.Nid.end, Integer.valueOf((int)(j * c.NiD[paramInt])));
      if (this.Nid.end - 1 != this.Nid.start)
      {
        localArrayList = this.NhO;
        i = this.Nid.end;
        f = j;
        localArrayList.set(i - 1, Integer.valueOf((int)(c.NiD[(1 - paramInt)] * f)));
      }
      k = getBundleCount();
      paramInt = new Random().nextInt(2);
      if (k != c.Niw) {
        break label709;
      }
      m = k / 2;
      i = 0;
      label324:
      if (i >= k) {
        break label790;
      }
      if (!aka(i)) {
        break label804;
      }
      this.NhO.set(i, Integer.valueOf((int)(j * c.NiE[paramInt])));
      paramInt = 1 - paramInt;
    }
    label790:
    label794:
    label801:
    label804:
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
        break label324;
        if (SoundWaveView.b.Nim == this.NhN)
        {
          Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "cancel judging!!!");
          this.NhN = SoundWaveView.b.Nil;
          removeCallbacks(this.Nib);
        }
        if (SoundWaveView.b.Nik != this.NhN) {
          break;
        }
        Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active reacting!!!");
        this.NhN = SoundWaveView.b.Nil;
        gsF();
        break;
        label465:
        if (this.Nid.end == i)
        {
          this.NhO.set(this.Nid.start, Integer.valueOf((int)(j * c.NiD[paramInt])));
          if (this.Nid.start + 1 == this.Nid.end) {
            break label290;
          }
          localArrayList = this.NhO;
          i = this.Nid.start;
          f = j;
          localArrayList.set(i + 1, Integer.valueOf((int)(c.NiD[(1 - paramInt)] * f)));
          break label290;
        }
        this.NhO.set(this.Nid.start, Integer.valueOf((int)(j * c.NiD[paramInt])));
        localArrayList = this.NhO;
        i = this.Nid.end;
        f = j;
        localArrayList.set(i, Integer.valueOf((int)(c.NiD[paramInt] * f)));
        break label290;
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
          a(((Integer)this.NhO.get(i)).intValue(), (List)this.NhS.get(i));
        }
      }
      label709:
      i = 0;
      if (i < k)
      {
        if (!aka(i)) {
          break label801;
        }
        this.NhO.set(i, Integer.valueOf((int)(j * c.NiE[paramInt])));
        paramInt = 1 - paramInt;
      }
      for (;;)
      {
        a(((Integer)this.NhO.get(i)).intValue(), (List)this.NhS.get(i));
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
    if ((SoundWaveView.b.Nil == this.NhN) || (SoundWaveView.b.Nim == this.NhN))
    {
      k = getBundleCount();
      i = 0;
    }
    while (i < k)
    {
      ((Integer)this.NhO.get(i)).intValue();
      int m = c.Niv;
      int j = 0;
      float f1;
      float f2;
      while (j < m)
      {
        f1 = ((Float)((List)this.NhS.get(i)).get(j)).floatValue();
        f2 = ((Float)((List)this.NhR.get(i)).get(j)).floatValue();
        ((List)this.NhR.get(i)).set(j, Float.valueOf((f1 - f2) / 6.0F + f2));
        j += 1;
      }
      int n = this.Nia;
      int i1 = this.NhV;
      j = 0;
      while (j < m)
      {
        int i2 = this.NhU * j + this.NhV * j + (n * i + i1 * i);
        f2 = ((Float)((List)this.NhR.get(i)).get(j)).floatValue();
        f1 = f2;
        if (f2 < this.NhX) {
          f1 = this.NhX;
        }
        f2 = f1;
        if (f1 > this.NhY) {
          f2 = this.NhY;
        }
        f1 = (this.mHeight - f2) / 2.0F;
        int i3 = this.NhU;
        paramCanvas.drawRoundRect(i2, f1, i3 + i2, f1 + f2, this.NhW, this.NhW, this.mPaint);
        j += 1;
      }
      i += 1;
      continue;
      if (SoundWaveView.b.Nik == this.NhN)
      {
        j = getVolumeItemCount();
        i = 0;
        while (i < j)
        {
          k = this.mWidth - (i + 1) * this.NhU - this.NhV * i;
          m = (this.mHeight - ((Integer)this.NhP.get(i)).intValue()) / 2;
          n = this.NhU;
          i1 = ((Integer)this.NhP.get(i)).intValue();
          paramCanvas.drawRoundRect(k, m, k + n, i1 + m, this.NhW, this.NhW, this.mPaint);
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
    if (SoundWaveView.d.NiJ == this.NhM) {}
    for (this.mWidth = aw.fromDPToPix(getContext(), c.NiH);; this.mWidth = aw.fromDPToPix(getContext(), c.NiG))
    {
      Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "style: %s, w: %s, h: %s.", new Object[] { this.NhM, Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
      setMeasuredDimension(this.mWidth, this.mHeight);
      AppMethodBeat.o(185292);
      return;
    }
  }
  
  public void setStyle(SoundWaveView.d paramd)
  {
    AppMethodBeat.i(185303);
    this.NhM = paramd;
    Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "set style %s", new Object[] { this.NhM });
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
    static int NiA;
    static int NiB;
    static float NiC;
    static float[] NiD;
    static float[] NiE;
    static int NiF;
    static int NiG;
    static int NiH;
    static int Nio;
    static int Nip;
    static int Niq;
    static int Nir;
    static int Nis;
    static int Nit;
    static String Niu;
    static int Niv;
    static int Niw;
    static int Nix;
    static int Niy;
    static int Niz;
    
    static
    {
      AppMethodBeat.i(185284);
      Nio = 2;
      Nip = 1;
      Niq = 1;
      Nir = 4;
      Nis = 34;
      Nit = 10;
      Niu = "#000000";
      Niv = 5;
      Niw = 5;
      Nix = 2;
      Niy = 300;
      Niz = 100;
      NiA = 500;
      NiB = 1000;
      NiC = 0.8F;
      NiD = new float[] { 0.8F, 0.6F };
      NiE = new float[] { 0.5F, 0.3F };
      NiF = akb(Niv);
      NiG = akb(Niv * Niw);
      NiH = akb(Niv * Nix);
      AppMethodBeat.o(185284);
    }
    
    private static int akb(int paramInt)
    {
      return (paramInt - 1) * Nip + Nio * paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.SoundWaveView
 * JD-Core Version:    0.7.0.1
 */