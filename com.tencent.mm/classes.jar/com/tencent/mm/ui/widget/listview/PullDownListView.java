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
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.ap;
import java.util.ArrayList;
import java.util.List;

public class PullDownListView
  extends ListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private boolean HHG;
  private float HHH;
  private float HHI;
  private float HHJ;
  private float HHK;
  public boolean HHL;
  private View HHM;
  private View HHN;
  private int HHO;
  public IPullDownCallback HHP;
  private boolean HHQ;
  private final int HHR;
  private final int HHS;
  private final int HHT;
  private View HHU;
  private float HHV;
  private float HHW;
  private boolean HHX;
  private boolean HHY;
  private boolean HHZ;
  private float HIa;
  private float HIb;
  private int HIc;
  private int HId;
  private boolean HIe;
  private float HIf;
  private int HIg;
  private int HIh;
  private boolean HIi;
  private long HIj;
  private long HIk;
  private AdapterView.OnItemLongClickListener HIl;
  private float aOa;
  private float aOb;
  private AdapterView.OnItemClickListener aos;
  private AdapterView.OnItemSelectedListener aot;
  private View awD;
  public boolean isVisible;
  private boolean jVE;
  private int kvo;
  private int lRM;
  private int lRN;
  private Vibrator lRO;
  private int mActivePointerId;
  private float mLastMotionY;
  private Rect mRect;
  private int ym;
  
  public PullDownListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159440);
    this.HHG = false;
    this.HHH = 0.05F;
    this.HHI = 0.05F;
    this.lRM = 0;
    this.lRN = 0;
    this.kvo = 0;
    this.HHJ = 0.0F;
    this.HHK = 0.0F;
    this.HHL = true;
    this.mRect = new Rect();
    this.ym = 0;
    this.HHO = 0;
    this.HHQ = false;
    this.HHR = 1;
    this.HHS = 2;
    this.HHT = 200;
    this.HHV = 0.0F;
    this.HHW = 0.0F;
    this.jVE = false;
    this.isVisible = true;
    this.HHX = false;
    this.HHY = false;
    this.HHZ = false;
    this.HIb = 0.0F;
    this.HIc = 0;
    this.HId = 0;
    this.HIe = false;
    this.HIf = 0.0F;
    this.mActivePointerId = -1;
    this.HIg = 0;
    this.HIh = 0;
    this.HIi = false;
    this.HIj = 0L;
    this.HIk = 0L;
    super.setOnItemClickListener(this);
    super.setOnItemLongClickListener(this);
    super.setOnItemSelectedListener(this);
    ap.cf(paramContext);
    this.kvo = ap.cf(paramContext).y;
    this.lRO = ((Vibrator)getContext().getSystemService("vibrator"));
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159434);
        an.d("MicroMsg.PullDownListView", "mThis.getLeft()=%s, mThis.getTop()=%s, mThis.getRight()=%s, mThis.getBottom()=%s", new Object[] { Integer.valueOf(PullDownListView.c(PullDownListView.this).getLeft()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getTop()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getRight()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getBottom()) });
        PullDownListView.d(PullDownListView.this).set(PullDownListView.c(PullDownListView.this).getLeft(), PullDownListView.c(PullDownListView.this).getTop(), PullDownListView.c(PullDownListView.this).getRight(), PullDownListView.c(PullDownListView.this).getBottom());
        AppMethodBeat.o(159434);
      }
    });
    AppMethodBeat.o(159440);
  }
  
  private void I(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(159447);
    an.i("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", new Object[] { Integer.valueOf(this.mRect.left), Integer.valueOf(this.mRect.top), Integer.valueOf(this.mRect.right), Integer.valueOf(this.mRect.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(brx()), Integer.valueOf(ffM()), Boolean.valueOf(paramBoolean) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt1, paramInt2 }));
    if ((this.awD != null) && (paramInt1 > brx()) && (paramInt1 < ffM()))
    {
      if (paramInt2 != 0) {
        localArrayList.add(ObjectAnimator.ofFloat(this.awD, "translationY", new float[] { paramInt1, paramInt2 }));
      }
    }
    else if (this.HHU != null)
    {
      if (paramInt2 < getBottom()) {
        break label379;
      }
      localArrayList.add(jI(((ViewGroup.MarginLayoutParams)this.HHU.getLayoutParams()).topMargin, 0));
    }
    for (;;)
    {
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(159438);
          an.i("MicroMsg.PullDownListView", "onAnimationEnd start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(PullDownListView.e(PullDownListView.this)), Integer.valueOf(PullDownListView.f(PullDownListView.this)) });
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
          an.i("MicroMsg.PullDownListView", "onAnimationStart start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(PullDownListView.e(PullDownListView.this)), Integer.valueOf(PullDownListView.f(PullDownListView.this)) });
          PullDownListView.a(PullDownListView.this, true);
          if (paramInt2 == 0) {
            PullDownListView.b(PullDownListView.this, true);
          }
          while ((PullDownListView.g(PullDownListView.this) != null) && (paramInt1 > PullDownListView.e(PullDownListView.this)) && (paramInt1 < PullDownListView.f(PullDownListView.this))) {
            if (PullDownListView.h(PullDownListView.this))
            {
              PullDownListView.g(PullDownListView.this).dcq();
              AppMethodBeat.o(159437);
              return;
              PullDownListView.b(PullDownListView.this, false);
            }
            else
            {
              PullDownListView.g(PullDownListView.this).dcp();
            }
          }
          AppMethodBeat.o(159437);
        }
      });
      localAnimatorSet.playTogether(localArrayList);
      localAnimatorSet.start();
      cyo();
      AppMethodBeat.o(159447);
      return;
      localArrayList.add(ObjectAnimator.ofFloat(this.awD, "translationY", new float[] { paramInt1, paramInt2 - this.HHO }));
      break;
      label379:
      localArrayList.add(jI(((ViewGroup.MarginLayoutParams)this.HHU.getLayoutParams()).topMargin, this.HIc));
    }
  }
  
  private int aaO(int paramInt)
  {
    AppMethodBeat.i(159451);
    int i = (int)Math.abs(paramInt / this.kvo * this.HIc);
    an.d("MicroMsg.PullDownListView", "offset:%s,  ((float) offset / screenHeight):%s,  Math.abs(mCoordinationAnimThreshold):%s,  result:%s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramInt / this.kvo), Integer.valueOf(Math.abs(this.HIc)), Integer.valueOf(i) });
    AppMethodBeat.o(159451);
    return i;
  }
  
  private boolean aj(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(159452);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    if (this.HHN != null) {
      if ((paramMotionEvent.getActionMasked() != 1) || (this.HIk >= 200L)) {
        if (this.aOa < this.HHN.getRight()) {
          if ((f1 <= this.HHN.getLeft()) || (f1 >= this.HHN.getRight()) || (f2 <= this.HHN.getTop() - this.HHN.getHeight() / 2) || (f2 >= this.HHN.getBottom() + this.HHO)) {}
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(159452);
      return bool;
      bool = false;
      continue;
      if ((f1 <= this.HHN.getLeft()) || (f1 >= this.HHN.getRight()) || (f2 <= this.HHN.getTop()) || (f2 >= this.HHN.getBottom() + this.HHO))
      {
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  private int brx()
  {
    if (this.lRM == 0) {
      this.lRM = ((int)(this.kvo * this.HHH));
    }
    return this.lRM;
  }
  
  @TargetApi(11)
  private void cyo()
  {
    AppMethodBeat.i(159449);
    this.ym = 0;
    an.d("MicroMsg.PullDownListView", "startAnimation %s %s %s %s", new Object[] { Integer.valueOf(this.HHM.getLeft()), Integer.valueOf(this.HHM.getTop()), Integer.valueOf(this.HHM.getRight()), Integer.valueOf(this.HHM.getBottom()) });
    AppMethodBeat.o(159449);
  }
  
  private int ffM()
  {
    if (this.lRN == 0) {
      this.lRN = ((int)((this.kvo - this.HId) * (1.0F - this.HHI)));
    }
    return this.lRN;
  }
  
  private void ffN()
  {
    AppMethodBeat.i(159446);
    if (this.HHN != null)
    {
      float f1 = this.HHN.getTranslationX();
      float f2 = this.HHN.getTranslationY();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.HHN, "translationX", new float[] { f1, this.HHJ });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.HHN, "translationY", new float[] { f2, this.HHK });
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
  
  private boolean ffO()
  {
    AppMethodBeat.i(159450);
    if ((!this.mRect.isEmpty()) && (Math.abs(this.ym) > 0))
    {
      AppMethodBeat.o(159450);
      return true;
    }
    AppMethodBeat.o(159450);
    return false;
  }
  
  private void ffP()
  {
    AppMethodBeat.i(159453);
    if (this.HHN != null) {
      this.HHN.setVisibility(8);
    }
    AppMethodBeat.o(159453);
  }
  
  private void ffQ()
  {
    AppMethodBeat.i(159454);
    if (this.HHN != null)
    {
      this.HHN.setTranslationX(this.HHJ);
      this.HHN.setTranslationY(this.HHK);
      this.HHN.setVisibility(8);
    }
    AppMethodBeat.o(159454);
  }
  
  private ValueAnimator jI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159455);
    an.d("MicroMsg.PullDownListView", "startStoryGalleryOpenAnim start:%s, end:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    this.HHU = paramView;
    this.HId = paramInt1;
    this.HIc = paramInt2;
    this.lRN = 0;
    this.lRM = 0;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159444);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(159444);
    return bool;
  }
  
  public final void ffR()
  {
    AppMethodBeat.i(159460);
    an.i("MicroMsg.PullDownListView", "switchNormalStatus", new Object[0]);
    if (!this.isVisible) {
      I(ffM() - 1, 0, false);
    }
    AppMethodBeat.o(159460);
  }
  
  public final void ffS()
  {
    AppMethodBeat.i(159461);
    an.i("MicroMsg.PullDownListView", "switchPullDownStatus", new Object[0]);
    if (this.isVisible) {
      I(brx() + 1, this.HHM.getBottom() + this.HHO, false);
    }
    AppMethodBeat.o(159461);
  }
  
  @TargetApi(11)
  protected void onFinishInflate()
  {
    AppMethodBeat.i(159443);
    this.HHM = this;
    this.HIa = getTranslationY();
    an.d("MicroMsg.PullDownListView", "onFinishInflate %s %s %s %s", new Object[] { Integer.valueOf(this.HHM.getLeft()), Integer.valueOf(this.HHM.getTop()), Integer.valueOf(this.HHM.getRight()), Integer.valueOf(this.HHM.getBottom()) });
    AppMethodBeat.o(159443);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159456);
    if ((this.aos != null) && (!this.jVE) && (this.isVisible))
    {
      this.HHQ = true;
      this.aos.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(159456);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159459);
    if ((this.HIl != null) && (!this.jVE) && (this.isVisible))
    {
      this.HHQ = true;
      boolean bool = this.HIl.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
      AppMethodBeat.o(159459);
      return bool;
    }
    AppMethodBeat.o(159459);
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159457);
    if ((this.aot != null) && (!this.jVE) && (this.isVisible))
    {
      this.HHQ = true;
      this.aot.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
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
    if (this.aot != null) {
      this.aot.onNothingSelected(paramAdapterView);
    }
    AppMethodBeat.o(159458);
  }
  
  @TargetApi(11)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159445);
    an.d("MicroMsg.PullDownListView", "dancy test onTouchEvent, supportOverscroll:%s, scrollY:%s", new Object[] { Boolean.valueOf(this.HHG), Integer.valueOf(getScrollY()) });
    boolean bool1;
    if ((!this.HHG) || (this.HHM == null) || (this.HHX))
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159445);
      return bool1;
    }
    int j = paramMotionEvent.getActionMasked();
    an.d("MicroMsg.PullDownListView", "onTouchEvent %s", new Object[] { Integer.valueOf(j) });
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
          an.d("MicroMsg.PullDownListView", "consumed: %b", new Object[] { Boolean.valueOf(bool1) });
          if (bool1) {
            paramMotionEvent.setAction(3);
          }
          if (!bool1) {
            break label2277;
          }
          AppMethodBeat.o(159445);
          return true;
          if (this.HIe) {
            break;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          ffP();
          this.HHQ = false;
          f = paramMotionEvent.getY(0);
          this.mLastMotionY = f;
          this.HHV = f;
          this.HHW = paramMotionEvent.getX(0);
          this.mRect.setEmpty();
          this.aOb = paramMotionEvent.getY(0);
          this.aOa = paramMotionEvent.getX(0);
          this.HIb = 0.0F;
          this.HIg = ((int)this.HIb);
          this.HIe = true;
          this.HIi = false;
          this.HIj = System.currentTimeMillis();
          this.HIk = 0L;
          ffQ();
        }
        this.jVE = true;
        if (!this.HIe)
        {
          if (this.isVisible) {
            break;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.mLastMotionY = paramMotionEvent.getY(0);
          this.aOb = paramMotionEvent.getY(0);
          this.HIb = (this.kvo - this.HId);
          this.HIg = ((int)this.HIb);
          this.HIe = true;
        }
        k = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      } while (k == -1);
      this.HHV = paramMotionEvent.getY(k);
      this.HHW = paramMotionEvent.getX(k);
      if (this.HHV - this.aOb >= 0.0F)
      {
        this.HIh = 2;
        i = getChildCount();
        if ((i <= 0) || (!this.isVisible)) {
          break label2425;
        }
        if (this.HIh != 2) {
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
        this.HIi = true;
      }
      label1024:
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (!this.HIi)
      {
        an.d("MicroMsg.PullDownListView", "rawY:%s, rawX:%s, indexY:%s, indexX:%s", new Object[] { Float.valueOf(paramMotionEvent.getRawY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(paramMotionEvent.getX(k)) });
        an.d("MicroMsg.PullDownListView", "move deltaY:%s, isAnima:%s, mDeltaY:%s, mIsIgnoreCallBack:%s translateBaseY:%s", new Object[] { Integer.valueOf((int)(this.mLastMotionY - this.HHV)), Boolean.valueOf(this.HHX), Integer.valueOf(this.ym), Boolean.valueOf(this.HHQ), Float.valueOf(this.HIb) });
        if ((!this.HHQ) && (!this.HHX))
        {
          if (this.mRect.isEmpty())
          {
            this.HIa = getTranslationY();
            this.mRect.set(this.HHM.getLeft(), this.HHM.getTop(), this.HHM.getRight(), this.HHM.getBottom());
            an.d("MicroMsg.PullDownListView", "mRect.isEmpty() %s %s %s %s", new Object[] { Integer.valueOf(this.HHM.getLeft()), Integer.valueOf(this.HHM.getTop()), Integer.valueOf(this.HHM.getRight()), Integer.valueOf(this.HHM.getBottom()) });
          }
          an.d("MicroMsg.PullDownListView", "eventIndex:%s, ev.getY():%s, y_down:%s, ev.getY()-y_down:%s", new Object[] { Integer.valueOf(k), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(this.aOb), Float.valueOf(paramMotionEvent.getY(k) - this.aOb) });
          this.HIg += (int)((int)(this.HHV - this.mLastMotionY) / 2.0F);
          this.ym = Math.max(0, this.HIg);
          an.d("MicroMsg.PullDownListView", "top %s, bottom:%s, mDeltaY %s, deltaOverScrollY:%s", new Object[] { Integer.valueOf(this.HHM.getTop()), Integer.valueOf(this.HHM.getBottom()), Integer.valueOf(this.ym), Integer.valueOf(this.HIg) });
          if (Math.abs(this.HIg) > 50)
          {
            if ((!this.HHY) && (this.ym >= brx()) && (this.ym <= ffM()))
            {
              this.lRO.vibrate(10L);
              this.HHY = true;
              this.HIf = this.HIg;
            }
            an.d("MicroMsg.PullDownListView", "OverScroll top %s, mIsIgnoreCallBack:%s, isVisible:%s", new Object[] { Integer.valueOf(this.mRect.top + this.ym), Boolean.valueOf(this.HHQ), Boolean.valueOf(this.isVisible) });
            bool1 = true;
            this.HHM.setTranslationY(this.ym);
            if (this.isVisible)
            {
              i = aaO(Math.max(this.ym - (int)this.HIb, 0));
              if (this.HHU != null)
              {
                localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.HHU.getLayoutParams();
                localMarginLayoutParams.topMargin = Math.max(this.HIc, Math.min(0, i + this.HIc));
                an.d("MicroMsg.PullDownListView", "openingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
                this.HHU.setLayoutParams(localMarginLayoutParams);
              }
              if (this.HHP != null) {
                this.HHP.Ji(aaO(Math.max(this.ym - brx() - (int)this.HIb, 0)));
              }
              label1174:
              if (this.HIf != 0.0F)
              {
                i = (int)((int)(this.HIg - this.HIf) * 3.0F);
                if ((!this.isVisible) || (i <= 0) || (this.HHP == null)) {
                  break label1691;
                }
                f = i;
                if (this.HHN != null)
                {
                  this.HHN.setTranslationX(Math.min(this.HHJ + f, 0.0F));
                  this.HHN.setTranslationY(Math.max(this.HHK - f, 0.0F));
                  this.HHN.setVisibility(0);
                }
                if ((this.HHZ) || (!aj(paramMotionEvent))) {
                  break label1663;
                }
                this.lRO.vibrate(20L);
                this.HHZ = true;
                if (!this.HHZ) {
                  break label1679;
                }
                this.HHP.dcr();
              }
              label1301:
              label1317:
              an.d("MicroMsg.PullDownListView", "mThis.layout %s %s %s %s", new Object[] { Integer.valueOf(this.HHM.getLeft()), Integer.valueOf(this.HHM.getTop()), Integer.valueOf(this.HHM.getRight()), Integer.valueOf(this.HHM.getBottom()) });
            }
          }
        }
      }
      for (;;)
      {
        this.mLastMotionY = this.HHV;
        break label147;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        ffP();
        this.HHQ = false;
        f = paramMotionEvent.getY(0);
        this.mLastMotionY = f;
        this.HHV = f;
        this.HHW = paramMotionEvent.getX(0);
        this.mRect.setEmpty();
        this.aOb = paramMotionEvent.getY(0);
        this.aOa = paramMotionEvent.getX(0);
        this.HIb = 0.0F;
        this.HIg = ((int)this.HIb);
        this.HIe = true;
        ffQ();
        break label385;
        this.HIh = 1;
        break label440;
        label1494:
        i = 0;
        break label483;
        label1499:
        if (this.HIh != 1) {
          break label2425;
        }
        if (getChildAt(i - 1).getBottom() >= getHeight() - getPaddingBottom())
        {
          i = 1;
          break label483;
        }
        i = 0;
        break label483;
        i = aaO(Math.max((int)this.HIb - this.ym, 0));
        if (this.HHU != null)
        {
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.HHU.getLayoutParams();
          localMarginLayoutParams.topMargin = Math.min(0, Math.max(this.HIc, -i));
          an.d("MicroMsg.PullDownListView", "closingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
          this.HHU.setLayoutParams(localMarginLayoutParams);
        }
        if (this.HHP == null) {
          break label1174;
        }
        this.HHP.Jj(aaO(Math.max(ffM() - this.ym, 0)));
        break label1174;
        label1663:
        if (aj(paramMotionEvent)) {
          break label1301;
        }
        this.HHZ = false;
        break label1301;
        label1679:
        this.HHP.dcs();
        break label1317;
        label1691:
        ffP();
        break label1317;
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i == -1) {
          break;
        }
        this.HHV = paramMotionEvent.getY(i);
        this.HHW = paramMotionEvent.getX(i);
        ffN();
        this.mLastMotionY = 0.0F;
        this.HIf = 0.0F;
        this.HHY = false;
        this.HIk = (System.currentTimeMillis() - this.HIj);
        an.d("MicroMsg.PullDownListView", "dancy test action up, mDeltaY:%s, closeLimitPx:%s, bottom:%s, mPullDownDuration%s", new Object[] { Integer.valueOf(this.ym), Integer.valueOf(ffM()), Integer.valueOf(this.HHM.getBottom()), Long.valueOf(this.HIk) });
        if ((ffO()) && (this.HHP != null) && (!this.HHX) && (this.HHL) && (!this.HIi))
        {
          an.d("MicroMsg.PullDownListView", "dancy test action up, deltaOverScrollY:%s, translateBaseY:%s", new Object[] { Integer.valueOf(this.HIg), Float.valueOf(this.HIb) });
          if (this.HIg - this.HIb > 0.0F)
          {
            i = 1;
            label1900:
            if (i == 0) {
              break label2013;
            }
            if (((!this.isVisible) || (this.ym < brx())) && ((this.isVisible) || (this.ym < ffM()))) {
              break label2408;
            }
          }
        }
        label1967:
        label2013:
        label2272:
        label2277:
        label2408:
        for (i = this.HHM.getBottom() + this.HHO;; i = 0)
        {
          I(this.ym, i, aj(paramMotionEvent));
          this.HHQ = false;
          this.HIe = false;
          this.HIg = 0;
          this.mActivePointerId = -1;
          this.HIi = false;
          this.HIk = 0L;
          this.HIj = 0L;
          bool1 = false;
          break label147;
          i = 0;
          break label1900;
          if (this.HIg - this.HIb < 0.0F)
          {
            i = 1;
            label2030:
            if (i == 0) {
              break label2059;
            }
            if (this.ym >= 0) {
              break label2061;
            }
            i = 0;
          }
          for (;;)
          {
            I(this.ym, i, false);
            break label1967;
            i = 0;
            break label2030;
            break label1967;
            if (this.ym >= ffM())
            {
              i = this.HHM.getBottom();
              continue;
              if (ffO()) {
                break label1967;
              }
              this.jVE = false;
              break label1967;
              ffN();
              this.HIe = false;
              this.HHQ = false;
              this.mLastMotionY = 0.0F;
              this.HIf = 0.0F;
              this.HHY = false;
              if (this.HHP != null) {
                cyo();
              }
              this.HIg = 0;
              this.mActivePointerId = -1;
              this.HIi = false;
              this.HIk = 0L;
              this.HIj = 0L;
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
                an.d("MicroMsg.PullDownListView", "super.onTouchEvent(): %b", new Object[] { Boolean.valueOf(bool2) });
                if ((this.HHP != null) && (getChildCount() > 0))
                {
                  i = getChildAt(0).getTop();
                  an.d("MicroMsg.PullDownListView", "scrolled %s", new Object[] { Integer.valueOf(i) });
                  this.HHP.Jk(i);
                }
                AppMethodBeat.o(159445);
                return bool2;
              }
              catch (Exception paramMotionEvent)
              {
                an.printErrStackTrace("MicroMsg.PullDownListView", paramMotionEvent, "%b, %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(j) });
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
      this.HHN = paramView;
      AppMethodBeat.o(159441);
      return;
      this.HHJ = 0.0F;
      this.HHK = 0.0F;
    }
  }
  
  public void setNavigationBarHeight(int paramInt)
  {
    AppMethodBeat.i(159442);
    an.i("MicroMsg.PullDownListView", "setNavigationBarHeight=%s", new Object[] { Integer.valueOf(paramInt) });
    this.HHO = paramInt;
    AppMethodBeat.o(159442);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.aos = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.HIl = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.aot = paramOnItemSelectedListener;
  }
  
  public void setSupportOverscroll(boolean paramBoolean)
  {
    this.HHG = paramBoolean;
  }
  
  public void setTabView(View paramView)
  {
    this.awD = paramView;
  }
  
  public static abstract interface IPullDownCallback
  {
    public abstract void Ji(int paramInt);
    
    public abstract void Jj(int paramInt);
    
    public abstract void Jk(int paramInt);
    
    public abstract void dcp();
    
    public abstract void dcq();
    
    public abstract void dcr();
    
    public abstract void dcs();
    
    public abstract void onPostClose();
    
    public abstract void onPostOpen(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView
 * JD-Core Version:    0.7.0.1
 */