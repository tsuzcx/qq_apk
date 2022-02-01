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
  private int JiA;
  private boolean JiB;
  private float JiC;
  private int JiD;
  private int JiE;
  private boolean JiF;
  private long JiG;
  private long JiH;
  private AdapterView.OnItemLongClickListener JiI;
  private boolean Jid;
  private float Jie;
  private float Jif;
  private float Jig;
  private float Jih;
  public boolean Jii;
  private View Jij;
  private View Jik;
  private int Jil;
  public IPullDownCallback Jim;
  private boolean Jin;
  private final int Jio;
  private final int Jip;
  private final int Jiq;
  private View Jir;
  private float Jis;
  private float Jit;
  private boolean Jiu;
  private boolean Jiv;
  private boolean Jiw;
  private float Jix;
  private float Jiy;
  private int Jiz;
  private float aOQ;
  private float aOR;
  private AdapterView.OnItemClickListener apn;
  private AdapterView.OnItemSelectedListener apo;
  private View axx;
  public boolean isVisible;
  private int kWC;
  private boolean kwq;
  private int mActivePointerId;
  private float mLastMotionY;
  private Rect mRect;
  private int mtO;
  private int mtP;
  private Vibrator mtQ;
  private int zl;
  
  public PullDownListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159440);
    this.Jid = false;
    this.Jie = 0.05F;
    this.Jif = 0.05F;
    this.mtO = 0;
    this.mtP = 0;
    this.kWC = 0;
    this.Jig = 0.0F;
    this.Jih = 0.0F;
    this.Jii = true;
    this.mRect = new Rect();
    this.zl = 0;
    this.Jil = 0;
    this.Jin = false;
    this.Jio = 1;
    this.Jip = 2;
    this.Jiq = 200;
    this.Jis = 0.0F;
    this.Jit = 0.0F;
    this.kwq = false;
    this.isVisible = true;
    this.Jiu = false;
    this.Jiv = false;
    this.Jiw = false;
    this.Jiy = 0.0F;
    this.Jiz = 0;
    this.JiA = 0;
    this.JiB = false;
    this.JiC = 0.0F;
    this.mActivePointerId = -1;
    this.JiD = 0;
    this.JiE = 0;
    this.JiF = false;
    this.JiG = 0L;
    this.JiH = 0L;
    super.setOnItemClickListener(this);
    super.setOnItemLongClickListener(this);
    super.setOnItemSelectedListener(this);
    ap.cl(paramContext);
    this.kWC = ap.cl(paramContext).y;
    this.mtQ = ((Vibrator)getContext().getSystemService("vibrator"));
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
  
  private void H(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(159447);
    an.i("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", new Object[] { Integer.valueOf(this.mRect.left), Integer.valueOf(this.mRect.top), Integer.valueOf(this.mRect.right), Integer.valueOf(this.mRect.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(byx()), Integer.valueOf(fvL()), Boolean.valueOf(paramBoolean) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt1, paramInt2 }));
    if ((this.axx != null) && (paramInt1 > byx()) && (paramInt1 < fvL()))
    {
      if (paramInt2 != 0) {
        localArrayList.add(ObjectAnimator.ofFloat(this.axx, "translationY", new float[] { paramInt1, paramInt2 }));
      }
    }
    else if (this.Jir != null)
    {
      if (paramInt2 < getBottom()) {
        break label379;
      }
      localArrayList.add(jU(((ViewGroup.MarginLayoutParams)this.Jir.getLayoutParams()).topMargin, 0));
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
              PullDownListView.g(PullDownListView.this).dpY();
              AppMethodBeat.o(159437);
              return;
              PullDownListView.b(PullDownListView.this, false);
            }
            else
            {
              PullDownListView.g(PullDownListView.this).dpX();
            }
          }
          AppMethodBeat.o(159437);
        }
      });
      localAnimatorSet.playTogether(localArrayList);
      localAnimatorSet.start();
      cLA();
      AppMethodBeat.o(159447);
      return;
      localArrayList.add(ObjectAnimator.ofFloat(this.axx, "translationY", new float[] { paramInt1, paramInt2 - this.Jil }));
      break;
      label379:
      localArrayList.add(jU(((ViewGroup.MarginLayoutParams)this.Jir.getLayoutParams()).topMargin, this.Jiz));
    }
  }
  
  private int acZ(int paramInt)
  {
    AppMethodBeat.i(159451);
    int i = (int)Math.abs(paramInt / this.kWC * this.Jiz);
    an.d("MicroMsg.PullDownListView", "offset:%s,  ((float) offset / screenHeight):%s,  Math.abs(mCoordinationAnimThreshold):%s,  result:%s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramInt / this.kWC), Integer.valueOf(Math.abs(this.Jiz)), Integer.valueOf(i) });
    AppMethodBeat.o(159451);
    return i;
  }
  
  private boolean aj(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(159452);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    if (this.Jik != null) {
      if ((paramMotionEvent.getActionMasked() != 1) || (this.JiH >= 200L)) {
        if (this.aOQ < this.Jik.getRight()) {
          if ((f1 <= this.Jik.getLeft()) || (f1 >= this.Jik.getRight()) || (f2 <= this.Jik.getTop() - this.Jik.getHeight() / 2) || (f2 >= this.Jik.getBottom() + this.Jil)) {}
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(159452);
      return bool;
      bool = false;
      continue;
      if ((f1 <= this.Jik.getLeft()) || (f1 >= this.Jik.getRight()) || (f2 <= this.Jik.getTop()) || (f2 >= this.Jik.getBottom() + this.Jil))
      {
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  private int byx()
  {
    if (this.mtO == 0) {
      this.mtO = ((int)(this.kWC * this.Jie));
    }
    return this.mtO;
  }
  
  @TargetApi(11)
  private void cLA()
  {
    AppMethodBeat.i(159449);
    this.zl = 0;
    an.d("MicroMsg.PullDownListView", "startAnimation %s %s %s %s", new Object[] { Integer.valueOf(this.Jij.getLeft()), Integer.valueOf(this.Jij.getTop()), Integer.valueOf(this.Jij.getRight()), Integer.valueOf(this.Jij.getBottom()) });
    AppMethodBeat.o(159449);
  }
  
  private int fvL()
  {
    if (this.mtP == 0) {
      this.mtP = ((int)((this.kWC - this.JiA) * (1.0F - this.Jif)));
    }
    return this.mtP;
  }
  
  private void fvM()
  {
    AppMethodBeat.i(159446);
    if (this.Jik != null)
    {
      float f1 = this.Jik.getTranslationX();
      float f2 = this.Jik.getTranslationY();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.Jik, "translationX", new float[] { f1, this.Jig });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.Jik, "translationY", new float[] { f2, this.Jih });
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
  
  private boolean fvN()
  {
    AppMethodBeat.i(159450);
    if ((!this.mRect.isEmpty()) && (Math.abs(this.zl) > 0))
    {
      AppMethodBeat.o(159450);
      return true;
    }
    AppMethodBeat.o(159450);
    return false;
  }
  
  private void fvO()
  {
    AppMethodBeat.i(159453);
    if (this.Jik != null) {
      this.Jik.setVisibility(8);
    }
    AppMethodBeat.o(159453);
  }
  
  private void fvP()
  {
    AppMethodBeat.i(159454);
    if (this.Jik != null)
    {
      this.Jik.setTranslationX(this.Jig);
      this.Jik.setTranslationY(this.Jih);
      this.Jik.setVisibility(8);
    }
    AppMethodBeat.o(159454);
  }
  
  private ValueAnimator jU(int paramInt1, int paramInt2)
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
    this.Jir = paramView;
    this.JiA = paramInt1;
    this.Jiz = paramInt2;
    this.mtP = 0;
    this.mtO = 0;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159444);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(159444);
    return bool;
  }
  
  public final void fvQ()
  {
    AppMethodBeat.i(159460);
    an.i("MicroMsg.PullDownListView", "switchNormalStatus", new Object[0]);
    if (!this.isVisible) {
      H(fvL() - 1, 0, false);
    }
    AppMethodBeat.o(159460);
  }
  
  public final void fvR()
  {
    AppMethodBeat.i(159461);
    an.i("MicroMsg.PullDownListView", "switchPullDownStatus", new Object[0]);
    if (this.isVisible) {
      H(byx() + 1, this.Jij.getBottom() + this.Jil, false);
    }
    AppMethodBeat.o(159461);
  }
  
  @TargetApi(11)
  protected void onFinishInflate()
  {
    AppMethodBeat.i(159443);
    this.Jij = this;
    this.Jix = getTranslationY();
    an.d("MicroMsg.PullDownListView", "onFinishInflate %s %s %s %s", new Object[] { Integer.valueOf(this.Jij.getLeft()), Integer.valueOf(this.Jij.getTop()), Integer.valueOf(this.Jij.getRight()), Integer.valueOf(this.Jij.getBottom()) });
    AppMethodBeat.o(159443);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159456);
    if ((this.apn != null) && (!this.kwq) && (this.isVisible))
    {
      this.Jin = true;
      this.apn.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(159456);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159459);
    if ((this.JiI != null) && (!this.kwq) && (this.isVisible))
    {
      this.Jin = true;
      boolean bool = this.JiI.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
      AppMethodBeat.o(159459);
      return bool;
    }
    AppMethodBeat.o(159459);
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159457);
    if ((this.apo != null) && (!this.kwq) && (this.isVisible))
    {
      this.Jin = true;
      this.apo.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
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
    if (this.apo != null) {
      this.apo.onNothingSelected(paramAdapterView);
    }
    AppMethodBeat.o(159458);
  }
  
  @TargetApi(11)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159445);
    an.d("MicroMsg.PullDownListView", "dancy test onTouchEvent, supportOverscroll:%s, scrollY:%s", new Object[] { Boolean.valueOf(this.Jid), Integer.valueOf(getScrollY()) });
    boolean bool1;
    if ((!this.Jid) || (this.Jij == null) || (this.Jiu))
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
          if (this.JiB) {
            break;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          fvO();
          this.Jin = false;
          f = paramMotionEvent.getY(0);
          this.mLastMotionY = f;
          this.Jis = f;
          this.Jit = paramMotionEvent.getX(0);
          this.mRect.setEmpty();
          this.aOR = paramMotionEvent.getY(0);
          this.aOQ = paramMotionEvent.getX(0);
          this.Jiy = 0.0F;
          this.JiD = ((int)this.Jiy);
          this.JiB = true;
          this.JiF = false;
          this.JiG = System.currentTimeMillis();
          this.JiH = 0L;
          fvP();
        }
        this.kwq = true;
        if (!this.JiB)
        {
          if (this.isVisible) {
            break;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.mLastMotionY = paramMotionEvent.getY(0);
          this.aOR = paramMotionEvent.getY(0);
          this.Jiy = (this.kWC - this.JiA);
          this.JiD = ((int)this.Jiy);
          this.JiB = true;
        }
        k = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      } while (k == -1);
      this.Jis = paramMotionEvent.getY(k);
      this.Jit = paramMotionEvent.getX(k);
      if (this.Jis - this.aOR >= 0.0F)
      {
        this.JiE = 2;
        i = getChildCount();
        if ((i <= 0) || (!this.isVisible)) {
          break label2425;
        }
        if (this.JiE != 2) {
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
        this.JiF = true;
      }
      label1024:
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (!this.JiF)
      {
        an.d("MicroMsg.PullDownListView", "rawY:%s, rawX:%s, indexY:%s, indexX:%s", new Object[] { Float.valueOf(paramMotionEvent.getRawY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(paramMotionEvent.getX(k)) });
        an.d("MicroMsg.PullDownListView", "move deltaY:%s, isAnima:%s, mDeltaY:%s, mIsIgnoreCallBack:%s translateBaseY:%s", new Object[] { Integer.valueOf((int)(this.mLastMotionY - this.Jis)), Boolean.valueOf(this.Jiu), Integer.valueOf(this.zl), Boolean.valueOf(this.Jin), Float.valueOf(this.Jiy) });
        if ((!this.Jin) && (!this.Jiu))
        {
          if (this.mRect.isEmpty())
          {
            this.Jix = getTranslationY();
            this.mRect.set(this.Jij.getLeft(), this.Jij.getTop(), this.Jij.getRight(), this.Jij.getBottom());
            an.d("MicroMsg.PullDownListView", "mRect.isEmpty() %s %s %s %s", new Object[] { Integer.valueOf(this.Jij.getLeft()), Integer.valueOf(this.Jij.getTop()), Integer.valueOf(this.Jij.getRight()), Integer.valueOf(this.Jij.getBottom()) });
          }
          an.d("MicroMsg.PullDownListView", "eventIndex:%s, ev.getY():%s, y_down:%s, ev.getY()-y_down:%s", new Object[] { Integer.valueOf(k), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(this.aOR), Float.valueOf(paramMotionEvent.getY(k) - this.aOR) });
          this.JiD += (int)((int)(this.Jis - this.mLastMotionY) / 2.0F);
          this.zl = Math.max(0, this.JiD);
          an.d("MicroMsg.PullDownListView", "top %s, bottom:%s, mDeltaY %s, deltaOverScrollY:%s", new Object[] { Integer.valueOf(this.Jij.getTop()), Integer.valueOf(this.Jij.getBottom()), Integer.valueOf(this.zl), Integer.valueOf(this.JiD) });
          if (Math.abs(this.JiD) > 50)
          {
            if ((!this.Jiv) && (this.zl >= byx()) && (this.zl <= fvL()))
            {
              this.mtQ.vibrate(10L);
              this.Jiv = true;
              this.JiC = this.JiD;
            }
            an.d("MicroMsg.PullDownListView", "OverScroll top %s, mIsIgnoreCallBack:%s, isVisible:%s", new Object[] { Integer.valueOf(this.mRect.top + this.zl), Boolean.valueOf(this.Jin), Boolean.valueOf(this.isVisible) });
            bool1 = true;
            this.Jij.setTranslationY(this.zl);
            if (this.isVisible)
            {
              i = acZ(Math.max(this.zl - (int)this.Jiy, 0));
              if (this.Jir != null)
              {
                localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Jir.getLayoutParams();
                localMarginLayoutParams.topMargin = Math.max(this.Jiz, Math.min(0, i + this.Jiz));
                an.d("MicroMsg.PullDownListView", "openingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
                this.Jir.setLayoutParams(localMarginLayoutParams);
              }
              if (this.Jim != null) {
                this.Jim.Lh(acZ(Math.max(this.zl - byx() - (int)this.Jiy, 0)));
              }
              label1174:
              if (this.JiC != 0.0F)
              {
                i = (int)((int)(this.JiD - this.JiC) * 3.0F);
                if ((!this.isVisible) || (i <= 0) || (this.Jim == null)) {
                  break label1691;
                }
                f = i;
                if (this.Jik != null)
                {
                  this.Jik.setTranslationX(Math.min(this.Jig + f, 0.0F));
                  this.Jik.setTranslationY(Math.max(this.Jih - f, 0.0F));
                  this.Jik.setVisibility(0);
                }
                if ((this.Jiw) || (!aj(paramMotionEvent))) {
                  break label1663;
                }
                this.mtQ.vibrate(20L);
                this.Jiw = true;
                if (!this.Jiw) {
                  break label1679;
                }
                this.Jim.dpZ();
              }
              label1301:
              label1317:
              an.d("MicroMsg.PullDownListView", "mThis.layout %s %s %s %s", new Object[] { Integer.valueOf(this.Jij.getLeft()), Integer.valueOf(this.Jij.getTop()), Integer.valueOf(this.Jij.getRight()), Integer.valueOf(this.Jij.getBottom()) });
            }
          }
        }
      }
      for (;;)
      {
        this.mLastMotionY = this.Jis;
        break label147;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        fvO();
        this.Jin = false;
        f = paramMotionEvent.getY(0);
        this.mLastMotionY = f;
        this.Jis = f;
        this.Jit = paramMotionEvent.getX(0);
        this.mRect.setEmpty();
        this.aOR = paramMotionEvent.getY(0);
        this.aOQ = paramMotionEvent.getX(0);
        this.Jiy = 0.0F;
        this.JiD = ((int)this.Jiy);
        this.JiB = true;
        fvP();
        break label385;
        this.JiE = 1;
        break label440;
        label1494:
        i = 0;
        break label483;
        label1499:
        if (this.JiE != 1) {
          break label2425;
        }
        if (getChildAt(i - 1).getBottom() >= getHeight() - getPaddingBottom())
        {
          i = 1;
          break label483;
        }
        i = 0;
        break label483;
        i = acZ(Math.max((int)this.Jiy - this.zl, 0));
        if (this.Jir != null)
        {
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.Jir.getLayoutParams();
          localMarginLayoutParams.topMargin = Math.min(0, Math.max(this.Jiz, -i));
          an.d("MicroMsg.PullDownListView", "closingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
          this.Jir.setLayoutParams(localMarginLayoutParams);
        }
        if (this.Jim == null) {
          break label1174;
        }
        this.Jim.Li(acZ(Math.max(fvL() - this.zl, 0)));
        break label1174;
        label1663:
        if (aj(paramMotionEvent)) {
          break label1301;
        }
        this.Jiw = false;
        break label1301;
        label1679:
        this.Jim.dqa();
        break label1317;
        label1691:
        fvO();
        break label1317;
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i == -1) {
          break;
        }
        this.Jis = paramMotionEvent.getY(i);
        this.Jit = paramMotionEvent.getX(i);
        fvM();
        this.mLastMotionY = 0.0F;
        this.JiC = 0.0F;
        this.Jiv = false;
        this.JiH = (System.currentTimeMillis() - this.JiG);
        an.d("MicroMsg.PullDownListView", "dancy test action up, mDeltaY:%s, closeLimitPx:%s, bottom:%s, mPullDownDuration%s", new Object[] { Integer.valueOf(this.zl), Integer.valueOf(fvL()), Integer.valueOf(this.Jij.getBottom()), Long.valueOf(this.JiH) });
        if ((fvN()) && (this.Jim != null) && (!this.Jiu) && (this.Jii) && (!this.JiF))
        {
          an.d("MicroMsg.PullDownListView", "dancy test action up, deltaOverScrollY:%s, translateBaseY:%s", new Object[] { Integer.valueOf(this.JiD), Float.valueOf(this.Jiy) });
          if (this.JiD - this.Jiy > 0.0F)
          {
            i = 1;
            label1900:
            if (i == 0) {
              break label2013;
            }
            if (((!this.isVisible) || (this.zl < byx())) && ((this.isVisible) || (this.zl < fvL()))) {
              break label2408;
            }
          }
        }
        label1967:
        label2013:
        label2272:
        label2277:
        label2408:
        for (i = this.Jij.getBottom() + this.Jil;; i = 0)
        {
          H(this.zl, i, aj(paramMotionEvent));
          this.Jin = false;
          this.JiB = false;
          this.JiD = 0;
          this.mActivePointerId = -1;
          this.JiF = false;
          this.JiH = 0L;
          this.JiG = 0L;
          bool1 = false;
          break label147;
          i = 0;
          break label1900;
          if (this.JiD - this.Jiy < 0.0F)
          {
            i = 1;
            label2030:
            if (i == 0) {
              break label2059;
            }
            if (this.zl >= 0) {
              break label2061;
            }
            i = 0;
          }
          for (;;)
          {
            H(this.zl, i, false);
            break label1967;
            i = 0;
            break label2030;
            break label1967;
            if (this.zl >= fvL())
            {
              i = this.Jij.getBottom();
              continue;
              if (fvN()) {
                break label1967;
              }
              this.kwq = false;
              break label1967;
              fvM();
              this.JiB = false;
              this.Jin = false;
              this.mLastMotionY = 0.0F;
              this.JiC = 0.0F;
              this.Jiv = false;
              if (this.Jim != null) {
                cLA();
              }
              this.JiD = 0;
              this.mActivePointerId = -1;
              this.JiF = false;
              this.JiH = 0L;
              this.JiG = 0L;
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
                if ((this.Jim != null) && (getChildCount() > 0))
                {
                  i = getChildAt(0).getTop();
                  an.d("MicroMsg.PullDownListView", "scrolled %s", new Object[] { Integer.valueOf(i) });
                  this.Jim.Lj(i);
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
      this.Jik = paramView;
      AppMethodBeat.o(159441);
      return;
      this.Jig = 0.0F;
      this.Jih = 0.0F;
    }
  }
  
  public void setNavigationBarHeight(int paramInt)
  {
    AppMethodBeat.i(159442);
    an.i("MicroMsg.PullDownListView", "setNavigationBarHeight=%s", new Object[] { Integer.valueOf(paramInt) });
    this.Jil = paramInt;
    AppMethodBeat.o(159442);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.apn = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.JiI = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.apo = paramOnItemSelectedListener;
  }
  
  public void setSupportOverscroll(boolean paramBoolean)
  {
    this.Jid = paramBoolean;
  }
  
  public void setTabView(View paramView)
  {
    this.axx = paramView;
  }
  
  public static abstract interface IPullDownCallback
  {
    public abstract void Lh(int paramInt);
    
    public abstract void Li(int paramInt);
    
    public abstract void Lj(int paramInt);
    
    public abstract void dpX();
    
    public abstract void dpY();
    
    public abstract void dpZ();
    
    public abstract void dqa();
    
    public abstract void onPostClose();
    
    public abstract void onPostOpen(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView
 * JD-Core Version:    0.7.0.1
 */