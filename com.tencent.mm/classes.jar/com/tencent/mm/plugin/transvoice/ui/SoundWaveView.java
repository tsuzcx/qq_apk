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
import com.tencent.mm.ui.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SoundWaveView
  extends View
{
  private SoundWaveView.d TUK;
  private SoundWaveView.b TUL;
  private ArrayList<Integer> TUM;
  private ArrayList<Integer> TUN;
  private ArrayList<AnimatorSet> TUO;
  private List<List<Float>> TUP;
  private List<List<Float>> TUQ;
  private Interpolator TUR;
  private int TUS;
  private int TUT;
  private int TUU;
  private int TUV;
  private int TUW;
  private int TUX;
  private int TUY;
  private Runnable TUZ;
  private int TVa;
  private a TVb;
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
    this.TUK = SoundWaveView.d.TVG;
    this.TUL = SoundWaveView.b.TVi;
    this.TUP = new ArrayList();
    this.TUQ = new ArrayList();
    this.TUZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(185277);
        Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active waiting!!!");
        SoundWaveView.a(SoundWaveView.this, SoundWaveView.b.TVi);
        SoundWaveView.a(SoundWaveView.this);
        AppMethodBeat.o(185277);
      }
    };
    this.TVa = -1;
    this.TVb = new a((byte)0);
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(185288);
  }
  
  private void a(float paramFloat, final List<Float> paramList)
  {
    AppMethodBeat.i(186026);
    int j = c.TVt;
    int k = j / 2;
    final int i = 0;
    if (i < j)
    {
      final float f = (float)(paramFloat * Math.pow(c.TVA, Math.abs(k - i)));
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
  
  private boolean aps(int paramInt)
  {
    return (paramInt >= this.TVb.start) && (paramInt <= this.TVb.end);
  }
  
  private boolean apt(int paramInt)
  {
    AppMethodBeat.i(185297);
    if (!aps(paramInt))
    {
      AppMethodBeat.o(185297);
      return true;
    }
    AppMethodBeat.o(185297);
    return false;
  }
  
  private void bbk()
  {
    AppMethodBeat.i(185295);
    this.TVa = -1;
    hPJ();
    hPN();
    hPO();
    AppMethodBeat.o(185295);
  }
  
  private int getActiveBundleIndex()
  {
    AppMethodBeat.i(185302);
    Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, mLastActiveBundleIndex: %s.", new Object[] { Integer.valueOf(this.TVa) });
    if (-1 == this.TVa)
    {
      this.TVa = (new Random().nextInt(this.TVb.end - this.TVb.start + 1) + this.TVb.start);
      i = this.TVa;
      AppMethodBeat.o(185302);
      return i;
    }
    int i = new Random().nextInt(3);
    int j;
    if (1 == i)
    {
      j = this.TVa - 1;
      i = j;
      if (apt(j))
      {
        j = this.TVa + 1;
        i = j;
        if (apt(j))
        {
          Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.TVa), this.TVb });
          i = this.TVa;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    if (2 == i)
    {
      j = this.TVa + 1;
      i = j;
      if (apt(j))
      {
        j = this.TVa - 1;
        i = j;
        if (apt(j))
        {
          Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", new Object[] { Integer.valueOf(this.TVa), this.TVb });
          i = this.TVa;
          AppMethodBeat.o(185302);
          return i;
        }
      }
      AppMethodBeat.o(185302);
      return i;
    }
    i = this.TVa;
    AppMethodBeat.o(185302);
    return i;
  }
  
  private int getBundleCount()
  {
    int i = c.TVu;
    if (SoundWaveView.d.TVH == this.TUK) {
      i = c.TVv;
    }
    return i;
  }
  
  private int getVolumeItemCount()
  {
    AppMethodBeat.i(185296);
    int i = getBundleCount();
    int j = c.TVt;
    AppMethodBeat.o(185296);
    return i * j;
  }
  
  private void hPI()
  {
    AppMethodBeat.i(185290);
    int j = getBundleCount();
    int i = 0;
    while (i < j)
    {
      this.TUM.set(i, Integer.valueOf(this.TUV));
      i += 1;
    }
    AppMethodBeat.o(185290);
  }
  
  private void hPJ()
  {
    AppMethodBeat.i(185291);
    int j = getVolumeItemCount();
    int i = 0;
    while (i < j)
    {
      this.TUN.set(i, Integer.valueOf(this.TUV));
      i += 1;
    }
    AppMethodBeat.o(185291);
  }
  
  private void hPK()
  {
    AppMethodBeat.i(186024);
    Iterator localIterator = this.TUP.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.TUV));
        i += 1;
      }
    }
    AppMethodBeat.o(186024);
  }
  
  private void hPL()
  {
    AppMethodBeat.i(186025);
    Iterator localIterator = this.TUQ.iterator();
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      int i = 0;
      while (i < localList.size())
      {
        localList.set(i, Float.valueOf(this.TUV));
        i += 1;
      }
    }
    AppMethodBeat.o(186025);
  }
  
  private void hPM()
  {
    AppMethodBeat.i(185298);
    this.TUO.clear();
    int j = getVolumeItemCount();
    final int i = 0;
    while (i < j)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.setStartDelay(c.TVx * i);
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
      ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { this.TUV, this.TUX });
      localValueAnimator1.setDuration(c.TVy);
      localValueAnimator1.addUpdateListener(local6);
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { this.TUX, this.TUV });
      localValueAnimator2.setDuration(c.TVy);
      localValueAnimator2.addUpdateListener(local6);
      ValueAnimator localValueAnimator3 = ValueAnimator.ofInt(new int[] { this.TUV, this.TUV });
      localValueAnimator3.setDuration(c.TVz);
      localValueAnimator3.addUpdateListener(local6);
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(186023);
          Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "AnimatorSet onAnimationEnd, mode: %s", new Object[] { SoundWaveView.e(SoundWaveView.this) });
          if ((SoundWaveView.b.TVi == SoundWaveView.e(SoundWaveView.this)) && (i == SoundWaveView.f(SoundWaveView.this).size() - 1) && (SoundWaveView.this.isShown()))
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
      this.TUO.add(localAnimatorSet);
      i += 1;
    }
    AppMethodBeat.o(185298);
  }
  
  private void hPN()
  {
    AppMethodBeat.i(185299);
    Iterator localIterator = this.TUO.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).end();
    }
    AppMethodBeat.o(185299);
  }
  
  private void hPO()
  {
    AppMethodBeat.i(185300);
    Iterator localIterator = this.TUO.iterator();
    while (localIterator.hasNext()) {
      ((AnimatorSet)localIterator.next()).start();
    }
    AppMethodBeat.o(185300);
  }
  
  private void hPP()
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
      this.TVb.start = i;
      this.TVb.end = j;
      Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "initBaseBundleGroupInfo: %s", new Object[] { this.TVb.toString() });
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
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.h.haC, 0, 0);
      i = paramContext.getInt(a.h.TTO, SoundWaveView.d.TVG.ordinal());
      if (i == SoundWaveView.d.TVG.ordinal())
      {
        this.TUK = SoundWaveView.d.TVG;
        paramContext.recycle();
        Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "init style %s", new Object[] { this.TUK });
      }
    }
    else
    {
      this.TUS = bd.fromDPToPix(getContext(), c.TVm);
      this.TUT = bd.fromDPToPix(getContext(), c.TVn);
      this.TUU = bd.fromDPToPix(getContext(), c.TVo);
      this.TUV = bd.fromDPToPix(getContext(), c.TVp);
      this.TUW = bd.fromDPToPix(getContext(), c.TVq);
      this.TUX = bd.fromDPToPix(getContext(), c.TVr);
      this.TUY = bd.fromDPToPix(getContext(), c.TVD);
      this.mWidth = bd.fromDPToPix(getContext(), c.TVE);
      this.mHeight = bd.fromDPToPix(getContext(), c.TVq);
      this.TUM = new ArrayList();
      i = 0;
    }
    for (;;)
    {
      if (i >= c.TVu) {
        break label376;
      }
      this.TUM.add(Integer.valueOf(this.TUV));
      paramContext = new ArrayList();
      paramAttributeSet = new ArrayList();
      int j = 0;
      for (;;)
      {
        if (j < c.TVt)
        {
          paramContext.add(Float.valueOf(this.TUV));
          paramAttributeSet.add(Float.valueOf(this.TUV));
          j += 1;
          continue;
          if (i == SoundWaveView.d.TVH.ordinal())
          {
            this.TUK = SoundWaveView.d.TVH;
            break;
          }
          Log.e("MicroMsg.NewTrans2Txt.SoundWaveView", "style err! %s", new Object[] { Integer.valueOf(i) });
          break;
        }
      }
      this.TUP.add(paramContext);
      this.TUQ.add(paramAttributeSet);
      i += 1;
    }
    label376:
    this.TUN = new ArrayList();
    int i = k;
    while (i < c.TVt * c.TVu)
    {
      this.TUN.add(Integer.valueOf(this.TUV));
      i += 1;
    }
    hPI();
    hPJ();
    this.TUO = new ArrayList(c.TVt * c.TVu);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (paramContext = new PathInterpolator(0.0F, 0.5F, 0.2F, 1.0F);; paramContext = new a())
    {
      this.TUR = paramContext;
      hPP();
      hPM();
      this.mPaint = new Paint(1);
      this.mPaint.setColor(Color.parseColor(c.TVs));
      this.mPaint.setAlpha(128);
      AppMethodBeat.o(185289);
      return;
    }
  }
  
  private void reset()
  {
    AppMethodBeat.i(185305);
    hPK();
    hPL();
    this.TUL = SoundWaveView.b.TVi;
    bbk();
    AppMethodBeat.o(185305);
  }
  
  public final void a(SoundWaveView.d paramd)
  {
    AppMethodBeat.i(185304);
    this.TUK = paramd;
    hPI();
    hPJ();
    hPP();
    hPM();
    Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "update style %s", new Object[] { this.TUK });
    requestLayout();
    reset();
    AppMethodBeat.o(185304);
  }
  
  public final void apr(int paramInt)
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
      if (SoundWaveView.b.TVj == this.TUL)
      {
        this.TUL = SoundWaveView.b.TVk;
        postDelayed(this.TUZ, c.TVw);
      }
      if ((SoundWaveView.b.TVj != this.TUL) && (SoundWaveView.b.TVk != this.TUL)) {
        break label794;
      }
      hPI();
      f = this.TUR.getInterpolation(f);
      Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "PathInterpolatorCompat value: %s.", new Object[] { Float.valueOf(f) });
      j = (int)(f * this.TUW);
      i = getActiveBundleIndex();
      Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, activeBundleIndex: %s", new Object[] { Integer.valueOf(i) });
      this.TUM.set(i, Integer.valueOf(j));
      paramInt = new Random().nextInt(2);
      if (this.TVb.start != i) {
        break label465;
      }
      this.TUM.set(this.TVb.end, Integer.valueOf((int)(j * c.TVB[paramInt])));
      if (this.TVb.end - 1 != this.TVb.start)
      {
        localArrayList = this.TUM;
        i = this.TVb.end;
        f = j;
        localArrayList.set(i - 1, Integer.valueOf((int)(c.TVB[(1 - paramInt)] * f)));
      }
      k = getBundleCount();
      paramInt = new Random().nextInt(2);
      if (k != c.TVu) {
        break label709;
      }
      m = k / 2;
      i = 0;
      label324:
      if (i >= k) {
        break label790;
      }
      if (!apt(i)) {
        break label804;
      }
      this.TUM.set(i, Integer.valueOf((int)(j * c.TVC[paramInt])));
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
        if (SoundWaveView.b.TVk == this.TUL)
        {
          Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "cancel judging!!!");
          this.TUL = SoundWaveView.b.TVj;
          removeCallbacks(this.TUZ);
        }
        if (SoundWaveView.b.TVi != this.TUL) {
          break;
        }
        Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active reacting!!!");
        this.TUL = SoundWaveView.b.TVj;
        hPN();
        break;
        label465:
        if (this.TVb.end == i)
        {
          this.TUM.set(this.TVb.start, Integer.valueOf((int)(j * c.TVB[paramInt])));
          if (this.TVb.start + 1 == this.TVb.end) {
            break label290;
          }
          localArrayList = this.TUM;
          i = this.TVb.start;
          f = j;
          localArrayList.set(i + 1, Integer.valueOf((int)(c.TVB[(1 - paramInt)] * f)));
          break label290;
        }
        this.TUM.set(this.TVb.start, Integer.valueOf((int)(j * c.TVB[paramInt])));
        localArrayList = this.TUM;
        i = this.TVb.end;
        f = j;
        localArrayList.set(i, Integer.valueOf((int)(c.TVB[paramInt] * f)));
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
          a(((Integer)this.TUM.get(i)).intValue(), (List)this.TUQ.get(i));
        }
      }
      label709:
      i = 0;
      if (i < k)
      {
        if (!apt(i)) {
          break label801;
        }
        this.TUM.set(i, Integer.valueOf((int)(j * c.TVC[paramInt])));
        paramInt = 1 - paramInt;
      }
      for (;;)
      {
        a(((Integer)this.TUM.get(i)).intValue(), (List)this.TUQ.get(i));
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
    if ((SoundWaveView.b.TVj == this.TUL) || (SoundWaveView.b.TVk == this.TUL))
    {
      k = getBundleCount();
      i = 0;
    }
    while (i < k)
    {
      ((Integer)this.TUM.get(i)).intValue();
      int m = c.TVt;
      int j = 0;
      float f1;
      float f2;
      while (j < m)
      {
        f1 = ((Float)((List)this.TUQ.get(i)).get(j)).floatValue();
        f2 = ((Float)((List)this.TUP.get(i)).get(j)).floatValue();
        ((List)this.TUP.get(i)).set(j, Float.valueOf((f1 - f2) / 6.0F + f2));
        j += 1;
      }
      int n = this.TUY;
      int i1 = this.TUT;
      j = 0;
      while (j < m)
      {
        int i2 = this.TUS * j + this.TUT * j + (n * i + i1 * i);
        f2 = ((Float)((List)this.TUP.get(i)).get(j)).floatValue();
        f1 = f2;
        if (f2 < this.TUV) {
          f1 = this.TUV;
        }
        f2 = f1;
        if (f1 > this.TUW) {
          f2 = this.TUW;
        }
        f1 = (this.mHeight - f2) / 2.0F;
        int i3 = this.TUS;
        paramCanvas.drawRoundRect(i2, f1, i3 + i2, f1 + f2, this.TUU, this.TUU, this.mPaint);
        j += 1;
      }
      i += 1;
      continue;
      if (SoundWaveView.b.TVi == this.TUL)
      {
        j = getVolumeItemCount();
        i = 0;
        while (i < j)
        {
          k = this.mWidth - (i + 1) * this.TUS - this.TUT * i;
          m = (this.mHeight - ((Integer)this.TUN.get(i)).intValue()) / 2;
          n = this.TUS;
          i1 = ((Integer)this.TUN.get(i)).intValue();
          paramCanvas.drawRoundRect(k, m, k + n, i1 + m, this.TUU, this.TUU, this.mPaint);
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
    if (SoundWaveView.d.TVH == this.TUK) {}
    for (this.mWidth = bd.fromDPToPix(getContext(), c.TVF);; this.mWidth = bd.fromDPToPix(getContext(), c.TVE))
    {
      Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "style: %s, w: %s, h: %s.", new Object[] { this.TUK, Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
      setMeasuredDimension(this.mWidth, this.mHeight);
      AppMethodBeat.o(185292);
      return;
    }
  }
  
  public void setStyle(SoundWaveView.d paramd)
  {
    AppMethodBeat.i(185303);
    this.TUK = paramd;
    Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "set style %s", new Object[] { this.TUK });
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
    static float TVA;
    static float[] TVB;
    static float[] TVC;
    static int TVD;
    static int TVE;
    static int TVF;
    static int TVm;
    static int TVn;
    static int TVo;
    static int TVp;
    static int TVq;
    static int TVr;
    static String TVs;
    static int TVt;
    static int TVu;
    static int TVv;
    static int TVw;
    static int TVx;
    static int TVy;
    static int TVz;
    
    static
    {
      AppMethodBeat.i(185284);
      TVm = 2;
      TVn = 1;
      TVo = 1;
      TVp = 4;
      TVq = 34;
      TVr = 10;
      TVs = "#000000";
      TVt = 5;
      TVu = 5;
      TVv = 2;
      TVw = 300;
      TVx = 100;
      TVy = 500;
      TVz = 1000;
      TVA = 0.8F;
      TVB = new float[] { 0.8F, 0.6F };
      TVC = new float[] { 0.5F, 0.3F };
      TVD = apu(TVt);
      TVE = apu(TVt * TVu);
      TVF = apu(TVt * TVv);
      AppMethodBeat.o(185284);
    }
    
    private static int apu(int paramInt)
    {
      return (paramInt - 1) * TVn + TVm * paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.SoundWaveView
 * JD-Core Version:    0.7.0.1
 */