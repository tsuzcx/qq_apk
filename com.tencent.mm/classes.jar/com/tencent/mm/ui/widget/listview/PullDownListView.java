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
  private boolean LvR;
  private float LvS;
  private float LvT;
  private float LvU;
  private float LvV;
  public boolean LvW;
  private View LvX;
  private View LvY;
  private int LvZ;
  public IPullDownCallback Lwa;
  private boolean Lwb;
  private final int Lwc;
  private final int Lwd;
  private final int Lwe;
  private View Lwf;
  private float Lwg;
  private float Lwh;
  private boolean Lwi;
  private boolean Lwj;
  private boolean Lwk;
  private float Lwl;
  private float Lwm;
  private int Lwn;
  private int Lwo;
  private boolean Lwp;
  private float Lwq;
  private int Lwr;
  private int Lws;
  private boolean Lwt;
  private long Lwu;
  private long Lwv;
  private AdapterView.OnItemLongClickListener Lww;
  private float aZk;
  private float aZl;
  private AdapterView.OnItemClickListener arf;
  private AdapterView.OnItemSelectedListener arg;
  private View azo;
  public boolean isVisible;
  private boolean kWf;
  private int lya;
  private int mActivePointerId;
  private float mLastMotionY;
  private Rect mRect;
  private int mZB;
  private int mZC;
  private Vibrator mZD;
  
  public PullDownListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159440);
    this.LvR = false;
    this.LvS = 0.05F;
    this.LvT = 0.05F;
    this.mZB = 0;
    this.mZC = 0;
    this.lya = 0;
    this.LvU = 0.0F;
    this.LvV = 0.0F;
    this.LvW = true;
    this.mRect = new Rect();
    this.Bd = 0;
    this.LvZ = 0;
    this.Lwb = false;
    this.Lwc = 1;
    this.Lwd = 2;
    this.Lwe = 200;
    this.Lwg = 0.0F;
    this.Lwh = 0.0F;
    this.kWf = false;
    this.isVisible = true;
    this.Lwi = false;
    this.Lwj = false;
    this.Lwk = false;
    this.Lwm = 0.0F;
    this.Lwn = 0;
    this.Lwo = 0;
    this.Lwp = false;
    this.Lwq = 0.0F;
    this.mActivePointerId = -1;
    this.Lwr = 0;
    this.Lws = 0;
    this.Lwt = false;
    this.Lwu = 0L;
    this.Lwv = 0L;
    super.setOnItemClickListener(this);
    super.setOnItemLongClickListener(this);
    super.setOnItemSelectedListener(this);
    ar.ck(paramContext);
    this.lya = ar.ck(paramContext).y;
    this.mZD = ((Vibrator)getContext().getSystemService("vibrator"));
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
    ap.i("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", new Object[] { Integer.valueOf(this.mRect.left), Integer.valueOf(this.mRect.top), Integer.valueOf(this.mRect.right), Integer.valueOf(this.mRect.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(bDu()), Integer.valueOf(fQT()), Boolean.valueOf(paramBoolean) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt1, paramInt2 }));
    if ((this.azo != null) && (paramInt1 > bDu()) && (paramInt1 < fQT()))
    {
      if (paramInt2 != 0) {
        localArrayList.add(ObjectAnimator.ofFloat(this.azo, "translationY", new float[] { paramInt1, paramInt2 }));
      }
    }
    else if (this.Lwf != null)
    {
      if (paramInt2 < getBottom()) {
        break label379;
      }
      localArrayList.add(kn(((ViewGroup.MarginLayoutParams)this.Lwf.getLayoutParams()).topMargin, 0));
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
              PullDownListView.g(PullDownListView.this).dDS();
              AppMethodBeat.o(159437);
              return;
              PullDownListView.b(PullDownListView.this, false);
            }
            else
            {
              PullDownListView.g(PullDownListView.this).dDR();
            }
          }
          AppMethodBeat.o(159437);
        }
      });
      localAnimatorSet.playTogether(localArrayList);
      localAnimatorSet.start();
      cWy();
      AppMethodBeat.o(159447);
      return;
      localArrayList.add(ObjectAnimator.ofFloat(this.azo, "translationY", new float[] { paramInt1, paramInt2 - this.LvZ }));
      break;
      label379:
      localArrayList.add(kn(((ViewGroup.MarginLayoutParams)this.Lwf.getLayoutParams()).topMargin, this.Lwn));
    }
  }
  
  private int agj(int paramInt)
  {
    AppMethodBeat.i(159451);
    int i = (int)Math.abs(paramInt / this.lya * this.Lwn);
    ap.d("MicroMsg.PullDownListView", "offset:%s,  ((float) offset / screenHeight):%s,  Math.abs(mCoordinationAnimThreshold):%s,  result:%s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramInt / this.lya), Integer.valueOf(Math.abs(this.Lwn)), Integer.valueOf(i) });
    AppMethodBeat.o(159451);
    return i;
  }
  
  private boolean aj(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(159452);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    if (this.LvY != null) {
      if ((paramMotionEvent.getActionMasked() != 1) || (this.Lwv >= 200L)) {
        if (this.aZk < this.LvY.getRight()) {
          if ((f1 <= this.LvY.getLeft()) || (f1 >= this.LvY.getRight()) || (f2 <= this.LvY.getTop() - this.LvY.getHeight() / 2) || (f2 >= this.LvY.getBottom() + this.LvZ)) {}
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(159452);
      return bool;
      bool = false;
      continue;
      if ((f1 <= this.LvY.getLeft()) || (f1 >= this.LvY.getRight()) || (f2 <= this.LvY.getTop()) || (f2 >= this.LvY.getBottom() + this.LvZ))
      {
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  private int bDu()
  {
    if (this.mZB == 0) {
      this.mZB = ((int)(this.lya * this.LvS));
    }
    return this.mZB;
  }
  
  @TargetApi(11)
  private void cWy()
  {
    AppMethodBeat.i(159449);
    this.Bd = 0;
    ap.d("MicroMsg.PullDownListView", "startAnimation %s %s %s %s", new Object[] { Integer.valueOf(this.LvX.getLeft()), Integer.valueOf(this.LvX.getTop()), Integer.valueOf(this.LvX.getRight()), Integer.valueOf(this.LvX.getBottom()) });
    AppMethodBeat.o(159449);
  }
  
  private int fQT()
  {
    if (this.mZC == 0) {
      this.mZC = ((int)((this.lya - this.Lwo) * (1.0F - this.LvT)));
    }
    return this.mZC;
  }
  
  private void fQU()
  {
    AppMethodBeat.i(159446);
    if (this.LvY != null)
    {
      float f1 = this.LvY.getTranslationX();
      float f2 = this.LvY.getTranslationY();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.LvY, "translationX", new float[] { f1, this.LvU });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.LvY, "translationY", new float[] { f2, this.LvV });
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
  
  private boolean fQV()
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
  
  private void fQW()
  {
    AppMethodBeat.i(159453);
    if (this.LvY != null) {
      this.LvY.setVisibility(8);
    }
    AppMethodBeat.o(159453);
  }
  
  private void fQX()
  {
    AppMethodBeat.i(159454);
    if (this.LvY != null)
    {
      this.LvY.setTranslationX(this.LvU);
      this.LvY.setTranslationY(this.LvV);
      this.LvY.setVisibility(8);
    }
    AppMethodBeat.o(159454);
  }
  
  private ValueAnimator kn(int paramInt1, int paramInt2)
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
  
  public final void A(View paramView, int paramInt1, int paramInt2)
  {
    this.Lwf = paramView;
    this.Lwo = paramInt1;
    this.Lwn = paramInt2;
    this.mZC = 0;
    this.mZB = 0;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159444);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(159444);
    return bool;
  }
  
  public final void fQY()
  {
    AppMethodBeat.i(159460);
    ap.i("MicroMsg.PullDownListView", "switchNormalStatus", new Object[0]);
    if (!this.isVisible) {
      I(fQT() - 1, 0, false);
    }
    AppMethodBeat.o(159460);
  }
  
  public final void fQZ()
  {
    AppMethodBeat.i(159461);
    ap.i("MicroMsg.PullDownListView", "switchPullDownStatus", new Object[0]);
    if (this.isVisible) {
      I(bDu() + 1, this.LvX.getBottom() + this.LvZ, false);
    }
    AppMethodBeat.o(159461);
  }
  
  @TargetApi(11)
  protected void onFinishInflate()
  {
    AppMethodBeat.i(159443);
    this.LvX = this;
    this.Lwl = getTranslationY();
    ap.d("MicroMsg.PullDownListView", "onFinishInflate %s %s %s %s", new Object[] { Integer.valueOf(this.LvX.getLeft()), Integer.valueOf(this.LvX.getTop()), Integer.valueOf(this.LvX.getRight()), Integer.valueOf(this.LvX.getBottom()) });
    AppMethodBeat.o(159443);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159456);
    if ((this.arf != null) && (!this.kWf) && (this.isVisible))
    {
      this.Lwb = true;
      this.arf.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(159456);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159459);
    if ((this.Lww != null) && (!this.kWf) && (this.isVisible))
    {
      this.Lwb = true;
      boolean bool = this.Lww.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
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
    localb.mu(paramInt);
    localb.rl(paramLong);
    a.b("com/tencent/mm/ui/widget/listview/PullDownListView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    if ((this.arg != null) && (!this.kWf) && (this.isVisible))
    {
      this.Lwb = true;
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
    ap.d("MicroMsg.PullDownListView", "dancy test onTouchEvent, supportOverscroll:%s, scrollY:%s", new Object[] { Boolean.valueOf(this.LvR), Integer.valueOf(getScrollY()) });
    boolean bool1;
    if ((!this.LvR) || (this.LvX == null) || (this.Lwi))
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
          if (this.Lwp) {
            break;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          fQW();
          this.Lwb = false;
          f = paramMotionEvent.getY(0);
          this.mLastMotionY = f;
          this.Lwg = f;
          this.Lwh = paramMotionEvent.getX(0);
          this.mRect.setEmpty();
          this.aZl = paramMotionEvent.getY(0);
          this.aZk = paramMotionEvent.getX(0);
          this.Lwm = 0.0F;
          this.Lwr = ((int)this.Lwm);
          this.Lwp = true;
          this.Lwt = false;
          this.Lwu = System.currentTimeMillis();
          this.Lwv = 0L;
          fQX();
        }
        this.kWf = true;
        if (!this.Lwp)
        {
          if (this.isVisible) {
            break;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.mLastMotionY = paramMotionEvent.getY(0);
          this.aZl = paramMotionEvent.getY(0);
          this.Lwm = (this.lya - this.Lwo);
          this.Lwr = ((int)this.Lwm);
          this.Lwp = true;
        }
        k = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      } while (k == -1);
      this.Lwg = paramMotionEvent.getY(k);
      this.Lwh = paramMotionEvent.getX(k);
      if (this.Lwg - this.aZl >= 0.0F)
      {
        this.Lws = 2;
        i = getChildCount();
        if ((i <= 0) || (!this.isVisible)) {
          break label2425;
        }
        if (this.Lws != 2) {
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
        this.Lwt = true;
      }
      label1024:
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (!this.Lwt)
      {
        ap.d("MicroMsg.PullDownListView", "rawY:%s, rawX:%s, indexY:%s, indexX:%s", new Object[] { Float.valueOf(paramMotionEvent.getRawY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(paramMotionEvent.getX(k)) });
        ap.d("MicroMsg.PullDownListView", "move deltaY:%s, isAnima:%s, mDeltaY:%s, mIsIgnoreCallBack:%s translateBaseY:%s", new Object[] { Integer.valueOf((int)(this.mLastMotionY - this.Lwg)), Boolean.valueOf(this.Lwi), Integer.valueOf(this.Bd), Boolean.valueOf(this.Lwb), Float.valueOf(this.Lwm) });
        if ((!this.Lwb) && (!this.Lwi))
        {
          if (this.mRect.isEmpty())
          {
            this.Lwl = getTranslationY();
            this.mRect.set(this.LvX.getLeft(), this.LvX.getTop(), this.LvX.getRight(), this.LvX.getBottom());
            ap.d("MicroMsg.PullDownListView", "mRect.isEmpty() %s %s %s %s", new Object[] { Integer.valueOf(this.LvX.getLeft()), Integer.valueOf(this.LvX.getTop()), Integer.valueOf(this.LvX.getRight()), Integer.valueOf(this.LvX.getBottom()) });
          }
          ap.d("MicroMsg.PullDownListView", "eventIndex:%s, ev.getY():%s, y_down:%s, ev.getY()-y_down:%s", new Object[] { Integer.valueOf(k), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(this.aZl), Float.valueOf(paramMotionEvent.getY(k) - this.aZl) });
          this.Lwr += (int)((int)(this.Lwg - this.mLastMotionY) / 2.0F);
          this.Bd = Math.max(0, this.Lwr);
          ap.d("MicroMsg.PullDownListView", "top %s, bottom:%s, mDeltaY %s, deltaOverScrollY:%s", new Object[] { Integer.valueOf(this.LvX.getTop()), Integer.valueOf(this.LvX.getBottom()), Integer.valueOf(this.Bd), Integer.valueOf(this.Lwr) });
          if (Math.abs(this.Lwr) > 50)
          {
            if ((!this.Lwj) && (this.Bd >= bDu()) && (this.Bd <= fQT()))
            {
              this.mZD.vibrate(10L);
              this.Lwj = true;
              this.Lwq = this.Lwr;
            }
            ap.d("MicroMsg.PullDownListView", "OverScroll top %s, mIsIgnoreCallBack:%s, isVisible:%s", new Object[] { Integer.valueOf(this.mRect.top + this.Bd), Boolean.valueOf(this.Lwb), Boolean.valueOf(this.isVisible) });
            bool1 = true;
            this.LvX.setTranslationY(this.Bd);
            if (this.isVisible)
            {
              i = agj(Math.max(this.Bd - (int)this.Lwm, 0));
              if (this.Lwf != null)
              {
                localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Lwf.getLayoutParams();
                localMarginLayoutParams.topMargin = Math.max(this.Lwn, Math.min(0, i + this.Lwn));
                ap.d("MicroMsg.PullDownListView", "openingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
                this.Lwf.setLayoutParams(localMarginLayoutParams);
              }
              if (this.Lwa != null) {
                this.Lwa.Np(agj(Math.max(this.Bd - bDu() - (int)this.Lwm, 0)));
              }
              label1174:
              if (this.Lwq != 0.0F)
              {
                i = (int)((int)(this.Lwr - this.Lwq) * 3.0F);
                if ((!this.isVisible) || (i <= 0) || (this.Lwa == null)) {
                  break label1691;
                }
                f = i;
                if (this.LvY != null)
                {
                  this.LvY.setTranslationX(Math.min(this.LvU + f, 0.0F));
                  this.LvY.setTranslationY(Math.max(this.LvV - f, 0.0F));
                  this.LvY.setVisibility(0);
                }
                if ((this.Lwk) || (!aj(paramMotionEvent))) {
                  break label1663;
                }
                this.mZD.vibrate(20L);
                this.Lwk = true;
                if (!this.Lwk) {
                  break label1679;
                }
                this.Lwa.dDT();
              }
              label1301:
              label1317:
              ap.d("MicroMsg.PullDownListView", "mThis.layout %s %s %s %s", new Object[] { Integer.valueOf(this.LvX.getLeft()), Integer.valueOf(this.LvX.getTop()), Integer.valueOf(this.LvX.getRight()), Integer.valueOf(this.LvX.getBottom()) });
            }
          }
        }
      }
      for (;;)
      {
        this.mLastMotionY = this.Lwg;
        break label147;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        fQW();
        this.Lwb = false;
        f = paramMotionEvent.getY(0);
        this.mLastMotionY = f;
        this.Lwg = f;
        this.Lwh = paramMotionEvent.getX(0);
        this.mRect.setEmpty();
        this.aZl = paramMotionEvent.getY(0);
        this.aZk = paramMotionEvent.getX(0);
        this.Lwm = 0.0F;
        this.Lwr = ((int)this.Lwm);
        this.Lwp = true;
        fQX();
        break label385;
        this.Lws = 1;
        break label440;
        label1494:
        i = 0;
        break label483;
        label1499:
        if (this.Lws != 1) {
          break label2425;
        }
        if (getChildAt(i - 1).getBottom() >= getHeight() - getPaddingBottom())
        {
          i = 1;
          break label483;
        }
        i = 0;
        break label483;
        i = agj(Math.max((int)this.Lwm - this.Bd, 0));
        if (this.Lwf != null)
        {
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Lwf.getLayoutParams();
          localMarginLayoutParams.topMargin = Math.min(0, Math.max(this.Lwn, -i));
          ap.d("MicroMsg.PullDownListView", "closingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
          this.Lwf.setLayoutParams(localMarginLayoutParams);
        }
        if (this.Lwa == null) {
          break label1174;
        }
        this.Lwa.Nq(agj(Math.max(fQT() - this.Bd, 0)));
        break label1174;
        label1663:
        if (aj(paramMotionEvent)) {
          break label1301;
        }
        this.Lwk = false;
        break label1301;
        label1679:
        this.Lwa.dDU();
        break label1317;
        label1691:
        fQW();
        break label1317;
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i == -1) {
          break;
        }
        this.Lwg = paramMotionEvent.getY(i);
        this.Lwh = paramMotionEvent.getX(i);
        fQU();
        this.mLastMotionY = 0.0F;
        this.Lwq = 0.0F;
        this.Lwj = false;
        this.Lwv = (System.currentTimeMillis() - this.Lwu);
        ap.d("MicroMsg.PullDownListView", "dancy test action up, mDeltaY:%s, closeLimitPx:%s, bottom:%s, mPullDownDuration%s", new Object[] { Integer.valueOf(this.Bd), Integer.valueOf(fQT()), Integer.valueOf(this.LvX.getBottom()), Long.valueOf(this.Lwv) });
        if ((fQV()) && (this.Lwa != null) && (!this.Lwi) && (this.LvW) && (!this.Lwt))
        {
          ap.d("MicroMsg.PullDownListView", "dancy test action up, deltaOverScrollY:%s, translateBaseY:%s", new Object[] { Integer.valueOf(this.Lwr), Float.valueOf(this.Lwm) });
          if (this.Lwr - this.Lwm > 0.0F)
          {
            i = 1;
            label1900:
            if (i == 0) {
              break label2013;
            }
            if (((!this.isVisible) || (this.Bd < bDu())) && ((this.isVisible) || (this.Bd < fQT()))) {
              break label2408;
            }
          }
        }
        label1967:
        label2013:
        label2272:
        label2277:
        label2408:
        for (i = this.LvX.getBottom() + this.LvZ;; i = 0)
        {
          I(this.Bd, i, aj(paramMotionEvent));
          this.Lwb = false;
          this.Lwp = false;
          this.Lwr = 0;
          this.mActivePointerId = -1;
          this.Lwt = false;
          this.Lwv = 0L;
          this.Lwu = 0L;
          bool1 = false;
          break label147;
          i = 0;
          break label1900;
          if (this.Lwr - this.Lwm < 0.0F)
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
            if (this.Bd >= fQT())
            {
              i = this.LvX.getBottom();
              continue;
              if (fQV()) {
                break label1967;
              }
              this.kWf = false;
              break label1967;
              fQU();
              this.Lwp = false;
              this.Lwb = false;
              this.mLastMotionY = 0.0F;
              this.Lwq = 0.0F;
              this.Lwj = false;
              if (this.Lwa != null) {
                cWy();
              }
              this.Lwr = 0;
              this.mActivePointerId = -1;
              this.Lwt = false;
              this.Lwv = 0L;
              this.Lwu = 0L;
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
                if ((this.Lwa != null) && (getChildCount() > 0))
                {
                  i = getChildAt(0).getTop();
                  ap.d("MicroMsg.PullDownListView", "scrolled %s", new Object[] { Integer.valueOf(i) });
                  this.Lwa.Nr(i);
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
      this.LvY = paramView;
      AppMethodBeat.o(159441);
      return;
      this.LvU = 0.0F;
      this.LvV = 0.0F;
    }
  }
  
  public void setNavigationBarHeight(int paramInt)
  {
    AppMethodBeat.i(159442);
    ap.i("MicroMsg.PullDownListView", "setNavigationBarHeight=%s", new Object[] { Integer.valueOf(paramInt) });
    this.LvZ = paramInt;
    AppMethodBeat.o(159442);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.arf = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.Lww = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.arg = paramOnItemSelectedListener;
  }
  
  public void setSupportOverscroll(boolean paramBoolean)
  {
    this.LvR = paramBoolean;
  }
  
  public void setTabView(View paramView)
  {
    this.azo = paramView;
  }
  
  public static abstract interface IPullDownCallback
  {
    public abstract void Np(int paramInt);
    
    public abstract void Nq(int paramInt);
    
    public abstract void Nr(int paramInt);
    
    public abstract void dDR();
    
    public abstract void dDS();
    
    public abstract void dDT();
    
    public abstract void dDU();
    
    public abstract void onPostClose();
    
    public abstract void onPostOpen(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView
 * JD-Core Version:    0.7.0.1
 */