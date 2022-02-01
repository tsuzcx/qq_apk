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
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.List;

public class PullDownListView
  extends ListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private int Bj;
  private int FSu;
  private int FSv;
  private boolean QRA;
  private boolean QRB;
  private float QRC;
  private float QRD;
  private float QRE;
  private float QRF;
  public boolean QRG;
  private View QRH;
  private View QRI;
  private int QRJ;
  public IPullDownCallback QRK;
  private boolean QRL;
  private final int QRM;
  private final int QRN;
  private final int QRO;
  private View QRP;
  private float QRQ;
  private float QRR;
  private boolean QRS;
  private boolean QRT;
  private boolean QRU;
  private float QRV;
  private float QRW;
  private int QRX;
  private int QRY;
  private boolean QRZ;
  private float QSa;
  private int QSb;
  private int QSc;
  private boolean QSd;
  private long QSe;
  private long QSf;
  private int QSg;
  a QSh;
  private AdapterView.OnItemLongClickListener QSi;
  private float aZg;
  private float aZh;
  private AdapterView.OnItemClickListener ars;
  private AdapterView.OnItemSelectedListener art;
  private View azm;
  public boolean isVisible;
  private int mActivePointerId;
  private int mEX;
  private int mEY;
  private float mLastMotionY;
  private Rect mRect;
  private boolean mbo;
  private Vibrator ooM;
  
  public PullDownListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(159440);
    this.QRA = false;
    this.QRB = false;
    this.QRC = 0.05F;
    this.QRD = 0.05F;
    this.FSu = 0;
    this.FSv = 0;
    this.mEY = 0;
    this.mEX = 0;
    this.QRE = 0.0F;
    this.QRF = 0.0F;
    this.QRG = true;
    this.mRect = new Rect();
    this.Bj = 0;
    this.QRJ = 0;
    this.QRL = false;
    this.QRM = 1;
    this.QRN = 2;
    this.QRO = 200;
    this.QRQ = 0.0F;
    this.QRR = 0.0F;
    this.mbo = false;
    this.isVisible = true;
    this.QRS = false;
    this.QRT = false;
    this.QRU = false;
    this.QRW = 0.0F;
    this.QRX = 0;
    this.QRY = 0;
    this.QRZ = false;
    this.QSa = 0.0F;
    this.mActivePointerId = -1;
    this.QSb = 0;
    this.QSc = 0;
    this.QSd = false;
    this.QSe = 0L;
    this.QSf = 0L;
    this.QSh = null;
    super.setOnItemClickListener(this);
    super.setOnItemLongClickListener(this);
    super.setOnItemSelectedListener(this);
    au.az(paramContext);
    this.mEY = au.az(paramContext).y;
    this.mEX = au.az(paramContext).x;
    this.ooM = ((Vibrator)getContext().getSystemService("vibrator"));
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(159434);
        as.d("MicroMsg.PullDownListView", "mThis.getLeft()=%s, mThis.getTop()=%s, mThis.getRight()=%s, mThis.getBottom()=%s", new Object[] { Integer.valueOf(PullDownListView.c(PullDownListView.this).getLeft()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getTop()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getRight()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getBottom()) });
        PullDownListView.d(PullDownListView.this).set(PullDownListView.c(PullDownListView.this).getLeft(), PullDownListView.c(PullDownListView.this).getTop(), PullDownListView.c(PullDownListView.this).getRight(), PullDownListView.c(PullDownListView.this).getBottom());
        AppMethodBeat.o(159434);
      }
    });
    AppMethodBeat.o(159440);
  }
  
  private void P(final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    AppMethodBeat.i(159447);
    as.i("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", new Object[] { Integer.valueOf(this.mRect.left), Integer.valueOf(this.mRect.top), Integer.valueOf(this.mRect.right), Integer.valueOf(this.mRect.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(fuF()), Integer.valueOf(fuG()), Boolean.valueOf(paramBoolean) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt1, paramInt2 }));
    if ((this.azm != null) && (paramInt1 > fuF()) && (paramInt1 < fuG()))
    {
      if (paramInt2 != 0) {
        localArrayList.add(ObjectAnimator.ofFloat(this.azm, "translationY", new float[] { paramInt1, paramInt2 }));
      }
    }
    else if (this.QRP != null)
    {
      if (paramInt2 < getBottom()) {
        break label379;
      }
      localArrayList.add(lI(((ViewGroup.MarginLayoutParams)this.QRP.getLayoutParams()).topMargin, 0));
    }
    for (;;)
    {
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(159438);
          as.i("MicroMsg.PullDownListView", "onAnimationEnd start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(PullDownListView.e(PullDownListView.this)), Integer.valueOf(PullDownListView.f(PullDownListView.this)) });
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
          as.i("MicroMsg.PullDownListView", "onAnimationStart start:%s, openLimitPx():%s, closeLimitPx():%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(PullDownListView.e(PullDownListView.this)), Integer.valueOf(PullDownListView.f(PullDownListView.this)) });
          PullDownListView.a(PullDownListView.this, true);
          if (paramInt2 == 0) {
            PullDownListView.b(PullDownListView.this, true);
          }
          while ((PullDownListView.g(PullDownListView.this) != null) && (paramInt1 > PullDownListView.e(PullDownListView.this)) && (paramInt1 < PullDownListView.f(PullDownListView.this))) {
            if (PullDownListView.h(PullDownListView.this))
            {
              PullDownListView.g(PullDownListView.this).eEl();
              AppMethodBeat.o(159437);
              return;
              PullDownListView.b(PullDownListView.this, false);
            }
            else
            {
              PullDownListView.g(PullDownListView.this).eEk();
            }
          }
          AppMethodBeat.o(159437);
        }
      });
      localAnimatorSet.playTogether(localArrayList);
      localAnimatorSet.start();
      hbT();
      AppMethodBeat.o(159447);
      return;
      localArrayList.add(ObjectAnimator.ofFloat(this.azm, "translationY", new float[] { paramInt1, paramInt2 - this.QRJ }));
      break;
      label379:
      localArrayList.add(lI(((ViewGroup.MarginLayoutParams)this.QRP.getLayoutParams()).topMargin, this.QRX));
    }
  }
  
  private int apm(int paramInt)
  {
    AppMethodBeat.i(159451);
    int i = (int)Math.abs(paramInt / this.mEY * this.QRX);
    as.d("MicroMsg.PullDownListView", "offset:%s,  ((float) offset / screenHeight):%s,  Math.abs(mCoordinationAnimThreshold):%s,  result:%s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramInt / this.mEY), Integer.valueOf(Math.abs(this.QRX)), Integer.valueOf(i) });
    AppMethodBeat.o(159451);
    return i;
  }
  
  private boolean ax(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(159452);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    if (this.QRI != null) {
      if ((paramMotionEvent.getActionMasked() != 1) || (this.QSf >= 200L)) {
        if (this.aZg < this.QRI.getRight()) {
          if ((f1 <= this.QRI.getLeft()) || (f1 >= this.QRI.getRight()) || (f2 <= this.QRI.getTop() - this.QRI.getHeight() / 2) || (f2 >= this.QRI.getBottom() + this.QRJ)) {}
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(159452);
      return bool;
      bool = false;
      continue;
      if ((f1 <= this.QRI.getLeft()) || (f1 >= this.QRI.getRight()) || (f2 <= this.QRI.getTop()) || (f2 >= this.QRI.getBottom() + this.QRJ))
      {
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  private int fuF()
  {
    if (this.FSu == 0) {
      this.FSu = ((int)(this.mEY * this.QRC));
    }
    return this.FSu;
  }
  
  private int fuG()
  {
    if (this.FSv == 0) {
      this.FSv = ((int)((this.mEY - this.QRY) * (1.0F - this.QRD)));
    }
    return this.FSv;
  }
  
  private void hbS()
  {
    AppMethodBeat.i(159446);
    if (this.QRI != null)
    {
      float f1 = this.QRI.getTranslationX();
      float f2 = this.QRI.getTranslationY();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.QRI, "translationX", new float[] { f1, this.QRE });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.QRI, "translationY", new float[] { f2, this.QRF });
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
  
  @TargetApi(11)
  private void hbT()
  {
    AppMethodBeat.i(159449);
    this.Bj = 0;
    as.d("MicroMsg.PullDownListView", "startAnimation %s %s %s %s", new Object[] { Integer.valueOf(this.QRH.getLeft()), Integer.valueOf(this.QRH.getTop()), Integer.valueOf(this.QRH.getRight()), Integer.valueOf(this.QRH.getBottom()) });
    AppMethodBeat.o(159449);
  }
  
  private boolean hbU()
  {
    AppMethodBeat.i(159450);
    if ((!this.mRect.isEmpty()) && (Math.abs(this.Bj) > 0))
    {
      AppMethodBeat.o(159450);
      return true;
    }
    AppMethodBeat.o(159450);
    return false;
  }
  
  private void hbV()
  {
    AppMethodBeat.i(159453);
    if (this.QRI != null) {
      this.QRI.setVisibility(8);
    }
    AppMethodBeat.o(159453);
  }
  
  private void hbW()
  {
    AppMethodBeat.i(159454);
    if (this.QRI != null)
    {
      this.QRI.setTranslationX(this.QRE);
      this.QRI.setTranslationY(this.QRF);
      this.QRI.setVisibility(8);
    }
    AppMethodBeat.o(159454);
  }
  
  private ValueAnimator lI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159455);
    as.d("MicroMsg.PullDownListView", "startStoryGalleryOpenAnim start:%s, end:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159444);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(159444);
    return bool;
  }
  
  public final void hbX()
  {
    AppMethodBeat.i(159460);
    as.i("MicroMsg.PullDownListView", "switchNormalStatus", new Object[0]);
    if (!this.isVisible)
    {
      if (this.QRB)
      {
        P((int)(this.mEX * 0.6666667F * (1.0F - this.QRD)), 0, false);
        AppMethodBeat.o(159460);
        return;
      }
      P(fuG() - 1, 0, false);
    }
    AppMethodBeat.o(159460);
  }
  
  public final void hbY()
  {
    AppMethodBeat.i(159461);
    as.i("MicroMsg.PullDownListView", "switchPullDownStatus", new Object[0]);
    if (this.isVisible)
    {
      if (this.QRB)
      {
        int i = (int)(this.mEX * 0.6666667F);
        P(fuF() + 1, i, false);
        AppMethodBeat.o(159461);
        return;
      }
      P(fuF() + 1, this.QRH.getBottom() + this.QRJ, false);
    }
    AppMethodBeat.o(159461);
  }
  
  @TargetApi(11)
  protected void onFinishInflate()
  {
    AppMethodBeat.i(159443);
    this.QRH = this;
    this.QRV = getTranslationY();
    as.d("MicroMsg.PullDownListView", "onFinishInflate %s %s %s %s", new Object[] { Integer.valueOf(this.QRH.getLeft()), Integer.valueOf(this.QRH.getTop()), Integer.valueOf(this.QRH.getRight()), Integer.valueOf(this.QRH.getBottom()) });
    AppMethodBeat.o(159443);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159456);
    if ((this.ars != null) && (!this.mbo) && ((this.isVisible) || (this.QRB)))
    {
      this.QRL = true;
      this.ars.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(159456);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(159459);
    if ((this.QSi != null) && ((this.isVisible) || (this.QRB)))
    {
      this.QRL = true;
      boolean bool = this.QSi.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
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
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    a.b("com/tencent/mm/ui/widget/listview/PullDownListView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    if ((this.art != null) && (!this.mbo) && ((this.isVisible) || (this.QRB)))
    {
      this.QRL = true;
      this.art.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
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
    if (this.art != null) {
      this.art.onNothingSelected(paramAdapterView);
    }
    AppMethodBeat.o(159458);
  }
  
  @TargetApi(11)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159445);
    as.d("MicroMsg.PullDownListView", "dancy test onTouchEvent, supportOverscroll:%s, scrollY:%s", new Object[] { Boolean.valueOf(this.QRA), Integer.valueOf(getScrollY()) });
    boolean bool1;
    if ((!this.QRA) || (this.QRH == null) || (this.QRS))
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(159445);
      return bool1;
    }
    int j = paramMotionEvent.getActionMasked();
    as.d("MicroMsg.PullDownListView", "onTouchEvent %s", new Object[] { Integer.valueOf(j) });
    label147:
    float f;
    label395:
    label409:
    int k;
    label464:
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
          as.d("MicroMsg.PullDownListView", "consumed: %b", new Object[] { Boolean.valueOf(bool1) });
          if (bool1) {
            paramMotionEvent.setAction(3);
          }
          if (!bool1) {
            break label2355;
          }
          AppMethodBeat.o(159445);
          return true;
          if (this.QRZ) {
            break;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          hbV();
          this.QRL = false;
          f = paramMotionEvent.getY(0);
          this.mLastMotionY = f;
          this.QRQ = f;
          this.QRR = paramMotionEvent.getX(0);
          this.mRect.setEmpty();
          this.aZh = paramMotionEvent.getY(0);
          this.aZg = paramMotionEvent.getX(0);
          this.QRW = 0.0F;
          if ((this.QRB) && (!this.isVisible)) {
            this.QRW = getTranslationY();
          }
          this.QSb = ((int)this.QRW);
          this.QRZ = true;
          this.QSd = false;
          this.QSe = System.currentTimeMillis();
          this.QSf = 0L;
          hbW();
        }
        this.mbo = true;
        if (!this.QRZ)
        {
          if (this.isVisible) {
            break label1447;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.mLastMotionY = paramMotionEvent.getY(0);
          this.aZh = paramMotionEvent.getY(0);
          if (!this.QRB) {
            break;
          }
          this.QRW = this.QSg;
          this.QSb = ((int)this.QRW);
          this.QRZ = true;
        }
        k = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      } while (k == -1);
      this.QRQ = paramMotionEvent.getY(k);
      this.QRR = paramMotionEvent.getX(k);
      if (this.QRQ - this.aZh >= 0.0F)
      {
        this.QSc = 2;
        i = getChildCount();
        if ((i <= 0) || (!this.isVisible)) {
          break label2503;
        }
        if (this.QSc != 2) {
          break label1554;
        }
        if (getChildAt(0).getTop() >= getPaddingTop() + 0) {
          break label1549;
        }
        i = 1;
      }
      break;
    }
    for (;;)
    {
      label507:
      if (i != 0) {
        this.QSd = true;
      }
      label1055:
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (!this.QSd)
      {
        as.d("MicroMsg.PullDownListView", "rawY:%s, rawX:%s, indexY:%s, indexX:%s", new Object[] { Float.valueOf(paramMotionEvent.getRawY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(paramMotionEvent.getX(k)) });
        as.d("MicroMsg.PullDownListView", "move deltaY:%s, isAnima:%s, mDeltaY:%s, mIsIgnoreCallBack:%s translateBaseY:%s", new Object[] { Integer.valueOf((int)(this.mLastMotionY - this.QRQ)), Boolean.valueOf(this.QRS), Integer.valueOf(this.Bj), Boolean.valueOf(this.QRL), Float.valueOf(this.QRW) });
        if ((!this.QRL) && (!this.QRS))
        {
          if (this.mRect.isEmpty())
          {
            this.QRV = getTranslationY();
            this.mRect.set(this.QRH.getLeft(), this.QRH.getTop(), this.QRH.getRight(), this.QRH.getBottom());
            as.d("MicroMsg.PullDownListView", "mRect.isEmpty() %s %s %s %s", new Object[] { Integer.valueOf(this.QRH.getLeft()), Integer.valueOf(this.QRH.getTop()), Integer.valueOf(this.QRH.getRight()), Integer.valueOf(this.QRH.getBottom()) });
          }
          as.d("MicroMsg.PullDownListView", "eventIndex:%s, ev.getY():%s, y_down:%s, ev.getY()-y_down:%s", new Object[] { Integer.valueOf(k), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(this.aZh), Float.valueOf(paramMotionEvent.getY(k) - this.aZh) });
          this.QSb += (int)((int)(this.QRQ - this.mLastMotionY) / 2.0F);
          this.Bj = Math.max(0, this.QSb);
          as.d("MicroMsg.PullDownListView", "top %s, bottom:%s, mDeltaY %s, deltaOverScrollY:%s", new Object[] { Integer.valueOf(this.QRH.getTop()), Integer.valueOf(this.QRH.getBottom()), Integer.valueOf(this.Bj), Integer.valueOf(this.QSb) });
          if (Math.abs(this.QSb) > 50)
          {
            if ((!this.QRT) && (this.Bj >= fuF()) && (this.Bj <= fuG()))
            {
              if (!this.QRB) {
                this.ooM.vibrate(10L);
              }
              this.QRT = true;
              this.QSa = this.QSb;
            }
            as.d("MicroMsg.PullDownListView", "OverScroll top %s, mIsIgnoreCallBack:%s, isVisible:%s", new Object[] { Integer.valueOf(this.mRect.top + this.Bj), Boolean.valueOf(this.QRL), Boolean.valueOf(this.isVisible) });
            bool1 = true;
            this.QRH.setTranslationY(this.Bj);
            if (this.isVisible)
            {
              i = apm(Math.max(this.Bj - (int)this.QRW, 0));
              if (this.QRP != null)
              {
                localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.QRP.getLayoutParams();
                localMarginLayoutParams.topMargin = Math.max(this.QRX, Math.min(0, i + this.QRX));
                as.d("MicroMsg.PullDownListView", "openingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
                this.QRP.setLayoutParams(localMarginLayoutParams);
              }
              if (this.QRK != null) {
                this.QRK.UC(apm(Math.max(this.Bj - fuF() - (int)this.QRW, 0)));
              }
              label1205:
              if (this.QSa != 0.0F)
              {
                i = (int)((int)(this.QSb - this.QSa) * 3.0F);
                if ((!this.isVisible) || (i <= 0) || (this.QRK == null)) {
                  break label1746;
                }
                f = i;
                if (this.QRI != null)
                {
                  this.QRI.setTranslationX(Math.min(this.QRE + f, 0.0F));
                  this.QRI.setTranslationY(Math.max(this.QRF - f, 0.0F));
                  this.QRI.setVisibility(0);
                }
                if ((this.QRU) || (!ax(paramMotionEvent))) {
                  break label1718;
                }
                if (!this.QRB) {
                  this.ooM.vibrate(20L);
                }
                this.QRU = true;
                label1339:
                if (!this.QRU) {
                  break label1734;
                }
                this.QRK.eEm();
              }
              label1355:
              as.d("MicroMsg.PullDownListView", "mThis.layout %s %s %s %s", new Object[] { Integer.valueOf(this.QRH.getLeft()), Integer.valueOf(this.QRH.getTop()), Integer.valueOf(this.QRH.getRight()), Integer.valueOf(this.QRH.getBottom()) });
            }
          }
        }
      }
      for (;;)
      {
        this.mLastMotionY = this.QRQ;
        break label147;
        this.QRW = (this.mEY - this.QRY);
        break label395;
        label1447:
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        hbV();
        this.QRL = false;
        f = paramMotionEvent.getY(0);
        this.mLastMotionY = f;
        this.QRQ = f;
        this.QRR = paramMotionEvent.getX(0);
        this.mRect.setEmpty();
        this.aZh = paramMotionEvent.getY(0);
        this.aZg = paramMotionEvent.getX(0);
        this.QRW = 0.0F;
        this.QSb = ((int)this.QRW);
        this.QRZ = true;
        hbW();
        break label409;
        this.QSc = 1;
        break label464;
        label1549:
        i = 0;
        break label507;
        label1554:
        if (this.QSc != 1) {
          break label2503;
        }
        if (getChildAt(i - 1).getBottom() >= getHeight() - getPaddingBottom())
        {
          i = 1;
          break label507;
        }
        i = 0;
        break label507;
        i = apm(Math.max((int)this.QRW - this.Bj, 0));
        if (this.QRP != null)
        {
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.QRP.getLayoutParams();
          localMarginLayoutParams.topMargin = Math.min(0, Math.max(this.QRX, -i));
          as.d("MicroMsg.PullDownListView", "closingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
          this.QRP.setLayoutParams(localMarginLayoutParams);
        }
        if (this.QRK == null) {
          break label1205;
        }
        this.QRK.UD(apm(Math.max(fuG() - this.Bj, 0)));
        break label1205;
        label1718:
        if (ax(paramMotionEvent)) {
          break label1339;
        }
        this.QRU = false;
        break label1339;
        label1734:
        this.QRK.eEn();
        break label1355;
        label1746:
        hbV();
        break label1355;
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i == -1) {
          break;
        }
        this.QRQ = paramMotionEvent.getY(i);
        this.QRR = paramMotionEvent.getX(i);
        hbS();
        this.mLastMotionY = 0.0F;
        this.QSa = 0.0F;
        this.QRT = false;
        this.QSf = (System.currentTimeMillis() - this.QSe);
        as.d("MicroMsg.PullDownListView", "dancy test action up, mDeltaY:%s, closeLimitPx:%s, bottom:%s, mPullDownDuration%s", new Object[] { Integer.valueOf(this.Bj), Integer.valueOf(fuG()), Integer.valueOf(this.QRH.getBottom()), Long.valueOf(this.QSf) });
        if ((hbU()) && (this.QRK != null) && (!this.QRS) && (this.QRG) && (!this.QSd))
        {
          as.d("MicroMsg.PullDownListView", "dancy test action up, deltaOverScrollY:%s, translateBaseY:%s", new Object[] { Integer.valueOf(this.QSb), Float.valueOf(this.QRW) });
          if (this.QSb - this.QRW > 0.0F)
          {
            i = 1;
            label1955:
            if (i == 0) {
              break label2091;
            }
            if (((!this.isVisible) || (this.Bj < fuF())) && ((this.isVisible) || (this.Bj < fuG()))) {
              break label2486;
            }
            i = this.QRH.getBottom() + this.QRJ;
            if (this.QRB)
            {
              i = (int)(this.mEX * 0.6666667F);
              this.QSg = i;
            }
          }
        }
        for (;;)
        {
          P(this.Bj, i, ax(paramMotionEvent));
          label2045:
          this.QRL = false;
          this.QRZ = false;
          this.QSb = 0;
          this.mActivePointerId = -1;
          this.QSd = false;
          this.QSf = 0L;
          this.QSe = 0L;
          bool1 = false;
          break label147;
          i = 0;
          break label1955;
          label2091:
          if (this.QSb - this.QRW < 0.0F)
          {
            i = 1;
            label2108:
            if (i == 0) {
              break label2137;
            }
            if (this.Bj >= 0) {
              break label2139;
            }
            i = 0;
          }
          for (;;)
          {
            P(this.Bj, i, false);
            break label2045;
            i = 0;
            break label2108;
            label2137:
            break label2045;
            label2139:
            if (this.Bj >= fuG())
            {
              i = this.QRH.getBottom();
              continue;
              if (hbU()) {
                break label2045;
              }
              this.mbo = false;
              break label2045;
              hbS();
              this.QRZ = false;
              this.QRL = false;
              this.mLastMotionY = 0.0F;
              this.QSa = 0.0F;
              this.QRT = false;
              if (this.QRK != null) {
                hbT();
              }
              this.QSb = 0;
              this.mActivePointerId = -1;
              this.QSd = false;
              this.QSf = 0L;
              this.QSe = 0L;
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
                  break label2350;
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
                as.d("MicroMsg.PullDownListView", "super.onTouchEvent(): %b", new Object[] { Boolean.valueOf(bool2) });
                if ((this.QRK != null) && (getChildCount() > 0))
                {
                  i = getChildAt(0).getTop();
                  as.d("MicroMsg.PullDownListView", "scrolled %s", new Object[] { Integer.valueOf(i) });
                  this.QRK.UE(i);
                }
                AppMethodBeat.o(159445);
                return bool2;
              }
              catch (Exception paramMotionEvent)
              {
                as.printErrStackTrace("MicroMsg.PullDownListView", paramMotionEvent, "%b, %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(j) });
                AppMethodBeat.o(159445);
                return true;
              }
            }
            label2350:
            label2355:
            i = 0;
          }
          label2486:
          i = 0;
        }
        bool1 = false;
        break label1055;
        bool1 = false;
      }
      label2503:
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
      this.QRI = paramView;
      AppMethodBeat.o(159441);
      return;
      this.QRE = 0.0F;
      this.QRF = 0.0F;
    }
  }
  
  public void setNavigationBarHeight(int paramInt)
  {
    AppMethodBeat.i(159442);
    as.i("MicroMsg.PullDownListView", "setNavigationBarHeight=%s", new Object[] { Integer.valueOf(paramInt) });
    this.QRJ = paramInt;
    AppMethodBeat.o(159442);
  }
  
  public void setNeedHover(boolean paramBoolean)
  {
    this.QRB = paramBoolean;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.ars = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.QSi = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.art = paramOnItemSelectedListener;
  }
  
  public void setSupportOverscroll(boolean paramBoolean)
  {
    this.QRA = paramBoolean;
  }
  
  public void setTabView(View paramView)
  {
    this.azm = paramView;
  }
  
  public void setTranslationListener(a parama)
  {
    this.QSh = parama;
  }
  
  public void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(198354);
    super.setTranslationY(paramFloat);
    if (this.QSh != null) {
      this.QSh.bI(paramFloat);
    }
    AppMethodBeat.o(198354);
  }
  
  public final void y(View paramView, int paramInt1, int paramInt2)
  {
    this.QRP = paramView;
    this.QRY = paramInt1;
    this.QRX = paramInt2;
    this.FSv = 0;
    this.FSu = 0;
  }
  
  public static abstract interface IPullDownCallback
  {
    public abstract void UC(int paramInt);
    
    public abstract void UD(int paramInt);
    
    public abstract void UE(int paramInt);
    
    public abstract void eEk();
    
    public abstract void eEl();
    
    public abstract void eEm();
    
    public abstract void eEn();
    
    public abstract void onPostClose();
    
    public abstract void onPostOpen(boolean paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void bI(float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView
 * JD-Core Version:    0.7.0.1
 */