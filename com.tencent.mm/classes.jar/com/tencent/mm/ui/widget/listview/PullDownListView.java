package com.tencent.mm.ui.widget.listview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.List;

public class PullDownListView
  extends ListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private int Bd;
  private View KZA;
  private int KZB;
  public IPullDownCallback KZC;
  private boolean KZD;
  private final int KZE;
  private final int KZF;
  private final int KZG;
  private View KZH;
  private float KZI;
  private float KZJ;
  private boolean KZK;
  private boolean KZL;
  private boolean KZM;
  private float KZN;
  private float KZO;
  private int KZP;
  private int KZQ;
  private boolean KZR;
  private float KZS;
  private int KZT;
  private int KZU;
  private boolean KZV;
  private long KZW;
  private long KZX;
  private AdapterView.OnItemLongClickListener KZY;
  private boolean KZt;
  private float KZu;
  private float KZv;
  private float KZw;
  private float KZx;
  public boolean KZy;
  private View KZz;
  private float aZk;
  private float aZl;
  private AdapterView.OnItemClickListener arf;
  private AdapterView.OnItemSelectedListener arg;
  private View azo;
  public boolean isVisible;
  private boolean kSw;
  private int ltB;
  private int mActivePointerId;
  private float mLastMotionY;
  private Rect mRect;
  private int mUu;
  private int mUv;
  private Vibrator mUw;
  
  public PullDownListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159440);
    this.KZt = false;
    this.KZu = 0.05F;
    this.KZv = 0.05F;
    this.mUu = 0;
    this.mUv = 0;
    this.ltB = 0;
    this.KZw = 0.0F;
    this.KZx = 0.0F;
    this.KZy = true;
    this.mRect = new Rect();
    this.Bd = 0;
    this.KZB = 0;
    this.KZD = false;
    this.KZE = 1;
    this.KZF = 2;
    this.KZG = 200;
    this.KZI = 0.0F;
    this.KZJ = 0.0F;
    this.kSw = false;
    this.isVisible = true;
    this.KZK = false;
    this.KZL = false;
    this.KZM = false;
    this.KZO = 0.0F;
    this.KZP = 0;
    this.KZQ = 0;
    this.KZR = false;
    this.KZS = 0.0F;
    this.mActivePointerId = -1;
    this.KZT = 0;
    this.KZU = 0;
    this.KZV = false;
    this.KZW = 0L;
    this.KZX = 0L;
    super.setOnItemClickListener(this);
    super.setOnItemLongClickListener(this);
    super.setOnItemSelectedListener(this);
    ar.ci(paramContext);
    this.ltB = ar.ci(paramContext).y;
    this.mUw = ((Vibrator)getContext().getSystemService("vibrator"));
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159434);
        ap.d("MicroMsg.PullDownListView", "mThis.getLeft()=%s, mThis.getTop()=%s, mThis.getRight()=%s, mThis.getBottom()=%s", new Object[] { Integer.valueOf(PullDownListView.c(PullDownListView.this).getLeft()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getTop()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getRight()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getBottom()) });
        PullDownListView.d(PullDownListView.this).set(PullDownListView.c(PullDownListView.this).getLeft(), PullDownListView.c(PullDownListView.this).getTop(), PullDownListView.c(PullDownListView.this).getRight(), PullDownListView.c(PullDownListView.this).getBottom());
        AppMethodBeat.o(159434);
      }
    });
    AppMethodBeat.o(159440);
  }
  
  private void I(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(159447);
    ap.i("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", new Object[] { Integer.valueOf(this.mRect.left), Integer.valueOf(this.mRect.top), Integer.valueOf(this.mRect.right), Integer.valueOf(this.mRect.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(bCC()), Integer.valueOf(fMz()), Boolean.valueOf(paramBoolean) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt1, paramInt2 }));
    if ((this.azo != null) && (paramInt1 > bCC()) && (paramInt1 < fMz()))
    {
      if (paramInt2 != 0) {
        localArrayList.add(ObjectAnimator.ofFloat(this.azo, "translationY", new float[] { paramInt1, paramInt2 }));
      }
    }
    else if (this.KZH != null)
    {
      if (paramInt2 < getBottom()) {
        break label379;
      }
      localArrayList.add(kg(((ViewGroup.MarginLayoutParams)this.KZH.getLayoutParams()).topMargin, 0));
    }
    for (;;)
    {
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(159438);
          ap.i("MicroMsg.PullDownListView", "onAnimationEnd start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(PullDownListView.e(PullDownListView.this)), Integer.valueOf(PullDownListView.f(PullDownListView.this)) });
          PullDownListView.i(PullDownListView.this);
          PullDownListView.a(PullDownListView.this, false);
          PullDownListView.j(PullDownListView.this);
          PullDownListView.k(PullDownListView.this);
          if ((PullDownListView.g(PullDownListView.this) != null) && (paramInt1 > PullDownListView.e(PullDownListView.this)) && (paramInt1 < PullDownListView.f(PullDownListView.this))) {
            if (PullDownListView.h(PullDownListView.this))
            {
              PullDownListView.g(PullDownListView.this).onPostClose();
              if (PullDownListView.l(PullDownListView.this) != null) {
                AppMethodBeat.o(159438);
              }
            }
            else
            {
              PullDownListView.g(PullDownListView.this).onPostOpen(paramBoolean);
            }
          }
          AppMethodBeat.o(159438);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(159437);
          ap.i("MicroMsg.PullDownListView", "onAnimationStart start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(PullDownListView.e(PullDownListView.this)), Integer.valueOf(PullDownListView.f(PullDownListView.this)) });
          PullDownListView.a(PullDownListView.this, true);
          if (paramInt2 == 0) {
            PullDownListView.b(PullDownListView.this, true);
          }
          while ((PullDownListView.g(PullDownListView.this) != null) && (paramInt1 > PullDownListView.e(PullDownListView.this)) && (paramInt1 < PullDownListView.f(PullDownListView.this))) {
            if (PullDownListView.h(PullDownListView.this))
            {
              PullDownListView.g(PullDownListView.this).dAB();
              AppMethodBeat.o(159437);
              return;
              PullDownListView.b(PullDownListView.this, false);
            }
            else
            {
              PullDownListView.g(PullDownListView.this).dAA();
            }
          }
          AppMethodBeat.o(159437);
        }
      });
      localAnimatorSet.playTogether(localArrayList);
      localAnimatorSet.start();
      cTT();
      AppMethodBeat.o(159447);
      return;
      localArrayList.add(ObjectAnimator.ofFloat(this.azo, "translationY", new float[] { paramInt1, paramInt2 - this.KZB }));
      break;
      label379:
      localArrayList.add(kg(((ViewGroup.MarginLayoutParams)this.KZH.getLayoutParams()).topMargin, this.KZP));
    }
  }
  
  private int afA(int paramInt)
  {
    AppMethodBeat.i(159451);
    int i = (int)Math.abs(paramInt / this.ltB * this.KZP);
    ap.d("MicroMsg.PullDownListView", "offset:%s,  ((float) offset / screenHeight):%s,  Math.abs(mCoordinationAnimThreshold):%s,  result:%s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramInt / this.ltB), Integer.valueOf(Math.abs(this.KZP)), Integer.valueOf(i) });
    AppMethodBeat.o(159451);
    return i;
  }
  
  private boolean al(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(159452);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    if (this.KZA != null) {
      if ((paramMotionEvent.getActionMasked() != 1) || (this.KZX >= 200L)) {
        if (this.aZk < this.KZA.getRight()) {
          if ((f1 <= this.KZA.getLeft()) || (f1 >= this.KZA.getRight()) || (f2 <= this.KZA.getTop() - this.KZA.getHeight() / 2) || (f2 >= this.KZA.getBottom() + this.KZB)) {}
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(159452);
      return bool;
      bool = false;
      continue;
      if ((f1 <= this.KZA.getLeft()) || (f1 >= this.KZA.getRight()) || (f2 <= this.KZA.getTop()) || (f2 >= this.KZA.getBottom() + this.KZB))
      {
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  private int bCC()
  {
    if (this.mUu == 0) {
      this.mUu = ((int)(this.ltB * this.KZu));
    }
    return this.mUu;
  }
  
  @TargetApi(11)
  private void cTT()
  {
    AppMethodBeat.i(159449);
    this.Bd = 0;
    ap.d("MicroMsg.PullDownListView", "startAnimation %s %s %s %s", new Object[] { Integer.valueOf(this.KZz.getLeft()), Integer.valueOf(this.KZz.getTop()), Integer.valueOf(this.KZz.getRight()), Integer.valueOf(this.KZz.getBottom()) });
    AppMethodBeat.o(159449);
  }
  
  private void fMA()
  {
    AppMethodBeat.i(159446);
    if (this.KZA != null)
    {
      float f1 = this.KZA.getTranslationX();
      float f2 = this.KZA.getTranslationY();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.KZA, "translationX", new float[] { f1, this.KZw });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.KZA, "translationY", new float[] { f2, this.KZx });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(159436);
          if (PullDownListView.b(PullDownListView.this) != null) {
            PullDownListView.b(PullDownListView.this).setVisibility(8);
          }
          AppMethodBeat.o(159436);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(159435);
          if (PullDownListView.b(PullDownListView.this) != null) {
            PullDownListView.b(PullDownListView.this).setVisibility(8);
          }
          AppMethodBeat.o(159435);
        }
      });
      localAnimatorSet.start();
    }
    AppMethodBeat.o(159446);
  }
  
  private boolean fMB()
  {
    AppMethodBeat.i(159450);
    if ((!this.mRect.isEmpty()) && (Math.abs(this.Bd) > 0))
    {
      AppMethodBeat.o(159450);
      return true;
    }
    AppMethodBeat.o(159450);
    return false;
  }
  
  private void fMC()
  {
    AppMethodBeat.i(159453);
    if (this.KZA != null) {
      this.KZA.setVisibility(8);
    }
    AppMethodBeat.o(159453);
  }
  
  private void fMD()
  {
    AppMethodBeat.i(159454);
    if (this.KZA != null)
    {
      this.KZA.setTranslationX(this.KZw);
      this.KZA.setTranslationY(this.KZx);
      this.KZA.setVisibility(8);
    }
    AppMethodBeat.o(159454);
  }
  
  private int fMz()
  {
    if (this.mUv == 0) {
      this.mUv = ((int)((this.ltB - this.KZQ) * (1.0F - this.KZv)));
    }
    return this.mUv;
  }
  
  private ValueAnimator kg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159455);
    ap.d("MicroMsg.PullDownListView", "startStoryGalleryOpenAnim start:%s, end:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(159439);
        paramAnonymousValueAnimator = (Integer)paramAnonymousValueAnimator.getAnimatedValue();
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)PullDownListView.m(PullDownListView.this).getLayoutParams();
        localMarginLayoutParams.topMargin = paramAnonymousValueAnimator.intValue();
        PullDownListView.m(PullDownListView.this).setLayoutParams(localMarginLayoutParams);
        AppMethodBeat.o(159439);
      }
    });
    AppMethodBeat.o(159455);
    return localValueAnimator;
  }
  
  public final void B(View paramView, int paramInt1, int paramInt2)
  {
    this.KZH = paramView;
    this.KZQ = paramInt1;
    this.KZP = paramInt2;
    this.mUv = 0;
    this.mUu = 0;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159444);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(159444);
    return bool;
  }
  
  public final void fME()
  {
    AppMethodBeat.i(159460);
    ap.i("MicroMsg.PullDownListView", "switchNormalStatus", new Object[0]);
    if (!this.isVisible) {
      I(fMz() - 1, 0, false);
    }
    AppMethodBeat.o(159460);
  }
  
  public final void fMF()
  {
    AppMethodBeat.i(159461);
    ap.i("MicroMsg.PullDownListView", "switchPullDownStatus", new Object[0]);
    if (this.isVisible) {
      I(bCC() + 1, this.KZz.getBottom() + this.KZB, false);
    }
    AppMethodBeat.o(159461);
  }
  
  @TargetApi(11)
  protected void onFinishInflate()
  {
    AppMethodBeat.i(159443);
    this.KZz = this;
    this.KZN = getTranslationY();
    ap.d("MicroMsg.PullDownListView", "onFinishInflate %s %s %s %s", new Object[] { Integer.valueOf(this.KZz.getLeft()), Integer.valueOf(this.KZz.getTop()), Integer.valueOf(this.KZz.getRight()), Integer.valueOf(this.KZz.getBottom()) });
    AppMethodBeat.o(159443);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159456);
    if ((this.arf != null) && (!this.kSw) && (this.isVisible))
    {
      this.KZD = true;
      this.arf.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(159456);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159459);
    if ((this.KZY != null) && (!this.kSw) && (this.isVisible))
    {
      this.KZD = true;
      boolean bool = this.KZY.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
      AppMethodBeat.o(159459);
      return bool;
    }
    AppMethodBeat.o(159459);
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159457);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    a.b("com/tencent/mm/ui/widget/listview/PullDownListView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    if ((this.arg != null) && (!this.kSw) && (this.isVisible))
    {
      this.KZD = true;
      this.arg.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
    a.a(this, "com/tencent/mm/ui/widget/listview/PullDownListView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(159457);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(159448);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(159448);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AppMethodBeat.i(159458);
    if (this.arg != null) {
      this.arg.onNothingSelected(paramAdapterView);
    }
    AppMethodBeat.o(159458);
  }
  
  @TargetApi(11)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159445);
    ap.d("MicroMsg.PullDownListView", "dancy test onTouchEvent, supportOverscroll:%s, scrollY:%s", new Object[] { Boolean.valueOf(this.KZt), Integer.valueOf(getScrollY()) });
    boolean bool1;
    if ((!this.KZt) || (this.KZz == null) || (this.KZK))
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159445);
      return bool1;
    }
    int j = paramMotionEvent.getActionMasked();
    ap.d("MicroMsg.PullDownListView", "onTouchEvent %s", new Object[] { Integer.valueOf(j) });
    label147:
    float f;
    label385:
    int k;
    label440:
    int i;
    switch (j)
    {
    case 4: 
    default: 
    case 0: 
    case 2: 
      do
      {
        for (bool1 = false;; bool1 = false)
        {
          ap.d("MicroMsg.PullDownListView", "consumed: %b", new Object[] { Boolean.valueOf(bool1) });
          if (bool1) {
            paramMotionEvent.setAction(3);
          }
          if (!bool1) {
            break label2277;
          }
          AppMethodBeat.o(159445);
          return true;
          if (this.KZR) {
            break;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          fMC();
          this.KZD = false;
          f = paramMotionEvent.getY(0);
          this.mLastMotionY = f;
          this.KZI = f;
          this.KZJ = paramMotionEvent.getX(0);
          this.mRect.setEmpty();
          this.aZl = paramMotionEvent.getY(0);
          this.aZk = paramMotionEvent.getX(0);
          this.KZO = 0.0F;
          this.KZT = ((int)this.KZO);
          this.KZR = true;
          this.KZV = false;
          this.KZW = System.currentTimeMillis();
          this.KZX = 0L;
          fMD();
        }
        this.kSw = true;
        if (!this.KZR)
        {
          if (this.isVisible) {
            break;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.mLastMotionY = paramMotionEvent.getY(0);
          this.aZl = paramMotionEvent.getY(0);
          this.KZO = (this.ltB - this.KZQ);
          this.KZT = ((int)this.KZO);
          this.KZR = true;
        }
        k = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      } while (k == -1);
      this.KZI = paramMotionEvent.getY(k);
      this.KZJ = paramMotionEvent.getX(k);
      if (this.KZI - this.aZl >= 0.0F)
      {
        this.KZU = 2;
        i = getChildCount();
        if ((i <= 0) || (!this.isVisible)) {
          break label2425;
        }
        if (this.KZU != 2) {
          break label1499;
        }
        if (getChildAt(0).getTop() >= getPaddingTop() + 0) {
          break label1494;
        }
        i = 1;
      }
      break;
    }
    for (;;)
    {
      label483:
      if (i != 0) {
        this.KZV = true;
      }
      label1024:
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (!this.KZV)
      {
        ap.d("MicroMsg.PullDownListView", "rawY:%s, rawX:%s, indexY:%s, indexX:%s", new Object[] { Float.valueOf(paramMotionEvent.getRawY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(paramMotionEvent.getX(k)) });
        ap.d("MicroMsg.PullDownListView", "move deltaY:%s, isAnima:%s, mDeltaY:%s, mIsIgnoreCallBack:%s translateBaseY:%s", new Object[] { Integer.valueOf((int)(this.mLastMotionY - this.KZI)), Boolean.valueOf(this.KZK), Integer.valueOf(this.Bd), Boolean.valueOf(this.KZD), Float.valueOf(this.KZO) });
        if ((!this.KZD) && (!this.KZK))
        {
          if (this.mRect.isEmpty())
          {
            this.KZN = getTranslationY();
            this.mRect.set(this.KZz.getLeft(), this.KZz.getTop(), this.KZz.getRight(), this.KZz.getBottom());
            ap.d("MicroMsg.PullDownListView", "mRect.isEmpty() %s %s %s %s", new Object[] { Integer.valueOf(this.KZz.getLeft()), Integer.valueOf(this.KZz.getTop()), Integer.valueOf(this.KZz.getRight()), Integer.valueOf(this.KZz.getBottom()) });
          }
          ap.d("MicroMsg.PullDownListView", "eventIndex:%s, ev.getY():%s, y_down:%s, ev.getY()-y_down:%s", new Object[] { Integer.valueOf(k), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(this.aZl), Float.valueOf(paramMotionEvent.getY(k) - this.aZl) });
          this.KZT += (int)((int)(this.KZI - this.mLastMotionY) / 2.0F);
          this.Bd = Math.max(0, this.KZT);
          ap.d("MicroMsg.PullDownListView", "top %s, bottom:%s, mDeltaY %s, deltaOverScrollY:%s", new Object[] { Integer.valueOf(this.KZz.getTop()), Integer.valueOf(this.KZz.getBottom()), Integer.valueOf(this.Bd), Integer.valueOf(this.KZT) });
          if (Math.abs(this.KZT) > 50)
          {
            if ((!this.KZL) && (this.Bd >= bCC()) && (this.Bd <= fMz()))
            {
              this.mUw.vibrate(10L);
              this.KZL = true;
              this.KZS = this.KZT;
            }
            ap.d("MicroMsg.PullDownListView", "OverScroll top %s, mIsIgnoreCallBack:%s, isVisible:%s", new Object[] { Integer.valueOf(this.mRect.top + this.Bd), Boolean.valueOf(this.KZD), Boolean.valueOf(this.isVisible) });
            bool1 = true;
            this.KZz.setTranslationY(this.Bd);
            if (this.isVisible)
            {
              i = afA(Math.max(this.Bd - (int)this.KZO, 0));
              if (this.KZH != null)
              {
                localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.KZH.getLayoutParams();
                localMarginLayoutParams.topMargin = Math.max(this.KZP, Math.min(0, i + this.KZP));
                ap.d("MicroMsg.PullDownListView", "openingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
                this.KZH.setLayoutParams(localMarginLayoutParams);
              }
              if (this.KZC != null) {
                this.KZC.MJ(afA(Math.max(this.Bd - bCC() - (int)this.KZO, 0)));
              }
              label1174:
              if (this.KZS != 0.0F)
              {
                i = (int)((int)(this.KZT - this.KZS) * 3.0F);
                if ((!this.isVisible) || (i <= 0) || (this.KZC == null)) {
                  break label1691;
                }
                f = i;
                if (this.KZA != null)
                {
                  this.KZA.setTranslationX(Math.min(this.KZw + f, 0.0F));
                  this.KZA.setTranslationY(Math.max(this.KZx - f, 0.0F));
                  this.KZA.setVisibility(0);
                }
                if ((this.KZM) || (!al(paramMotionEvent))) {
                  break label1663;
                }
                this.mUw.vibrate(20L);
                this.KZM = true;
                if (!this.KZM) {
                  break label1679;
                }
                this.KZC.dAC();
              }
              label1301:
              label1317:
              ap.d("MicroMsg.PullDownListView", "mThis.layout %s %s %s %s", new Object[] { Integer.valueOf(this.KZz.getLeft()), Integer.valueOf(this.KZz.getTop()), Integer.valueOf(this.KZz.getRight()), Integer.valueOf(this.KZz.getBottom()) });
            }
          }
        }
      }
      for (;;)
      {
        this.mLastMotionY = this.KZI;
        break label147;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        fMC();
        this.KZD = false;
        f = paramMotionEvent.getY(0);
        this.mLastMotionY = f;
        this.KZI = f;
        this.KZJ = paramMotionEvent.getX(0);
        this.mRect.setEmpty();
        this.aZl = paramMotionEvent.getY(0);
        this.aZk = paramMotionEvent.getX(0);
        this.KZO = 0.0F;
        this.KZT = ((int)this.KZO);
        this.KZR = true;
        fMD();
        break label385;
        this.KZU = 1;
        break label440;
        label1494:
        i = 0;
        break label483;
        label1499:
        if (this.KZU != 1) {
          break label2425;
        }
        if (getChildAt(i - 1).getBottom() >= getHeight() - getPaddingBottom())
        {
          i = 1;
          break label483;
        }
        i = 0;
        break label483;
        i = afA(Math.max((int)this.KZO - this.Bd, 0));
        if (this.KZH != null)
        {
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.KZH.getLayoutParams();
          localMarginLayoutParams.topMargin = Math.min(0, Math.max(this.KZP, -i));
          ap.d("MicroMsg.PullDownListView", "closingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
          this.KZH.setLayoutParams(localMarginLayoutParams);
        }
        if (this.KZC == null) {
          break label1174;
        }
        this.KZC.MK(afA(Math.max(fMz() - this.Bd, 0)));
        break label1174;
        label1663:
        if (al(paramMotionEvent)) {
          break label1301;
        }
        this.KZM = false;
        break label1301;
        label1679:
        this.KZC.dAD();
        break label1317;
        label1691:
        fMC();
        break label1317;
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i == -1) {
          break;
        }
        this.KZI = paramMotionEvent.getY(i);
        this.KZJ = paramMotionEvent.getX(i);
        fMA();
        this.mLastMotionY = 0.0F;
        this.KZS = 0.0F;
        this.KZL = false;
        this.KZX = (System.currentTimeMillis() - this.KZW);
        ap.d("MicroMsg.PullDownListView", "dancy test action up, mDeltaY:%s, closeLimitPx:%s, bottom:%s, mPullDownDuration%s", new Object[] { Integer.valueOf(this.Bd), Integer.valueOf(fMz()), Integer.valueOf(this.KZz.getBottom()), Long.valueOf(this.KZX) });
        if ((fMB()) && (this.KZC != null) && (!this.KZK) && (this.KZy) && (!this.KZV))
        {
          ap.d("MicroMsg.PullDownListView", "dancy test action up, deltaOverScrollY:%s, translateBaseY:%s", new Object[] { Integer.valueOf(this.KZT), Float.valueOf(this.KZO) });
          if (this.KZT - this.KZO > 0.0F)
          {
            i = 1;
            label1900:
            if (i == 0) {
              break label2013;
            }
            if (((!this.isVisible) || (this.Bd < bCC())) && ((this.isVisible) || (this.Bd < fMz()))) {
              break label2408;
            }
          }
        }
        label1967:
        label2013:
        label2272:
        label2277:
        label2408:
        for (i = this.KZz.getBottom() + this.KZB;; i = 0)
        {
          I(this.Bd, i, al(paramMotionEvent));
          this.KZD = false;
          this.KZR = false;
          this.KZT = 0;
          this.mActivePointerId = -1;
          this.KZV = false;
          this.KZX = 0L;
          this.KZW = 0L;
          bool1 = false;
          break label147;
          i = 0;
          break label1900;
          if (this.KZT - this.KZO < 0.0F)
          {
            i = 1;
            label2030:
            if (i == 0) {
              break label2059;
            }
            if (this.Bd >= 0) {
              break label2061;
            }
            i = 0;
          }
          for (;;)
          {
            I(this.Bd, i, false);
            break label1967;
            i = 0;
            break label2030;
            break label1967;
            if (this.Bd >= fMz())
            {
              i = this.KZz.getBottom();
              continue;
              if (fMB()) {
                break label1967;
              }
              this.kSw = false;
              break label1967;
              fMA();
              this.KZR = false;
              this.KZD = false;
              this.mLastMotionY = 0.0F;
              this.KZS = 0.0F;
              this.KZL = false;
              if (this.KZC != null) {
                cTT();
              }
              this.KZT = 0;
              this.mActivePointerId = -1;
              this.KZV = false;
              this.KZX = 0L;
              this.KZW = 0L;
              bool1 = false;
              break label147;
              i = paramMotionEvent.getActionIndex();
              if (i == -1) {
                break;
              }
              this.mLastMotionY = ((int)paramMotionEvent.getY(i));
              this.mActivePointerId = paramMotionEvent.getPointerId(i);
              bool1 = false;
              break label147;
              i = paramMotionEvent.getActionIndex();
              if (paramMotionEvent.getPointerId(i) == this.mActivePointerId) {
                if (i != 0) {
                  break label2272;
                }
              }
              for (i = 1;; i = 0)
              {
                this.mLastMotionY = ((int)paramMotionEvent.getY(i));
                this.mActivePointerId = paramMotionEvent.getPointerId(i);
                i = paramMotionEvent.getActionIndex();
                if (i == -1) {
                  break;
                }
                this.mLastMotionY = ((int)paramMotionEvent.getY(i));
                break;
              }
              try
              {
                boolean bool2 = super.onTouchEvent(paramMotionEvent);
                ap.d("MicroMsg.PullDownListView", "super.onTouchEvent(): %b", new Object[] { Boolean.valueOf(bool2) });
                if ((this.KZC != null) && (getChildCount() > 0))
                {
                  i = getChildAt(0).getTop();
                  ap.d("MicroMsg.PullDownListView", "scrolled %s", new Object[] { Integer.valueOf(i) });
                  this.KZC.ML(i);
                }
                AppMethodBeat.o(159445);
                return bool2;
              }
              catch (Exception paramMotionEvent)
              {
                ap.printErrStackTrace("MicroMsg.PullDownListView", paramMotionEvent, "%b, %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(j) });
                AppMethodBeat.o(159445);
                return true;
              }
            }
            i = 0;
          }
        }
        label2059:
        label2061:
        bool1 = false;
        break label1024;
        bool1 = false;
      }
      label2425:
      i = 0;
    }
  }
  
  public void setMuteView(final View paramView)
  {
    AppMethodBeat.i(159441);
    if (paramView != null) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(159433);
          if (PullDownListView.b(PullDownListView.this) != null)
          {
            PullDownListView.a(PullDownListView.this, -PullDownListView.b(PullDownListView.this).getWidth());
            PullDownListView.b(PullDownListView.this, PullDownListView.b(PullDownListView.this).getHeight());
            PullDownListView.b(PullDownListView.this).setVisibility(8);
          }
          paramView.bringToFront();
          AppMethodBeat.o(159433);
        }
      });
    }
    for (;;)
    {
      this.KZA = paramView;
      AppMethodBeat.o(159441);
      return;
      this.KZw = 0.0F;
      this.KZx = 0.0F;
    }
  }
  
  public void setNavigationBarHeight(int paramInt)
  {
    AppMethodBeat.i(159442);
    ap.i("MicroMsg.PullDownListView", "setNavigationBarHeight=%s", new Object[] { Integer.valueOf(paramInt) });
    this.KZB = paramInt;
    AppMethodBeat.o(159442);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.arf = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.KZY = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.arg = paramOnItemSelectedListener;
  }
  
  public void setSupportOverscroll(boolean paramBoolean)
  {
    this.KZt = paramBoolean;
  }
  
  public void setTabView(View paramView)
  {
    this.azo = paramView;
  }
  
  public static abstract interface IPullDownCallback
  {
    public abstract void MJ(int paramInt);
    
    public abstract void MK(int paramInt);
    
    public abstract void ML(int paramInt);
    
    public abstract void dAA();
    
    public abstract void dAB();
    
    public abstract void dAC();
    
    public abstract void dAD();
    
    public abstract void onPostClose();
    
    public abstract void onPostOpen(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView
 * JD-Core Version:    0.7.0.1
 */