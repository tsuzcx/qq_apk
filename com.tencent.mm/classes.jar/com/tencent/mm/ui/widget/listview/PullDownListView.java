package com.tencent.mm.ui.widget.listview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.am;
import java.util.ArrayList;
import java.util.List;

public class PullDownListView
  extends ListView
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private boolean AHR;
  private float AHS;
  private float AHT;
  private float AHU;
  private float AHV;
  public boolean AHW;
  private View AHX;
  private View AHY;
  private int AHZ;
  public PullDownListView.IPullDownCallback AIa;
  private boolean AIb;
  private final int AIc;
  private final int AId;
  private final int AIe;
  private View AIf;
  private float AIg;
  private float AIh;
  private boolean AIi;
  private boolean AIj;
  private boolean AIk;
  private float AIl;
  private float AIm;
  private int AIn;
  private int AIo;
  private boolean AIp;
  private float AIq;
  private int AIr;
  private int AIs;
  private boolean AIt;
  private long AIu;
  private long AIv;
  private AdapterView.OnItemLongClickListener AIw;
  private AdapterView.OnItemClickListener ahl;
  private AdapterView.OnItemSelectedListener ahm;
  private View apa;
  private float atq;
  private float atr;
  private boolean hPP;
  private int iiX;
  public boolean isVisible;
  private int jbS;
  private int jbT;
  private Vibrator jbU;
  private int mActivePointerId;
  private float mLastMotionY;
  private Rect mRect;
  private int rN;
  
  public PullDownListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112731);
    this.AHR = false;
    this.AHS = 0.05F;
    this.AHT = 0.05F;
    this.jbS = 0;
    this.jbT = 0;
    this.iiX = 0;
    this.AHU = 0.0F;
    this.AHV = 0.0F;
    this.AHW = true;
    this.mRect = new Rect();
    this.rN = 0;
    this.AHZ = 0;
    this.AIb = false;
    this.AIc = 1;
    this.AId = 2;
    this.AIe = 200;
    this.AIg = 0.0F;
    this.AIh = 0.0F;
    this.hPP = false;
    this.isVisible = true;
    this.AIi = false;
    this.AIj = false;
    this.AIk = false;
    this.AIm = 0.0F;
    this.AIn = 0;
    this.AIo = 0;
    this.AIp = false;
    this.AIq = 0.0F;
    this.mActivePointerId = -1;
    this.AIr = 0;
    this.AIs = 0;
    this.AIt = false;
    this.AIu = 0L;
    this.AIv = 0L;
    super.setOnItemClickListener(this);
    super.setOnItemLongClickListener(this);
    super.setOnItemSelectedListener(this);
    am.hQ(paramContext);
    this.iiX = am.hQ(paramContext).y;
    this.jbU = ((Vibrator)getContext().getSystemService("vibrator"));
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(112725);
        ak.d("MicroMsg.PullDownListView", "mThis.getLeft()=%s, mThis.getTop()=%s, mThis.getRight()=%s, mThis.getBottom()=%s", new Object[] { Integer.valueOf(PullDownListView.c(PullDownListView.this).getLeft()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getTop()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getRight()), Integer.valueOf(PullDownListView.c(PullDownListView.this).getBottom()) });
        PullDownListView.d(PullDownListView.this).set(PullDownListView.c(PullDownListView.this).getLeft(), PullDownListView.c(PullDownListView.this).getTop(), PullDownListView.c(PullDownListView.this).getRight(), PullDownListView.c(PullDownListView.this).getBottom());
        AppMethodBeat.o(112725);
      }
    });
    AppMethodBeat.o(112731);
  }
  
  private int Rs(int paramInt)
  {
    AppMethodBeat.i(112742);
    int i = (int)Math.abs(paramInt / this.iiX * this.AIn);
    ak.d("MicroMsg.PullDownListView", "offset:%s,  ((float) offset / screenHeight):%s,  Math.abs(mCoordinationAnimThreshold):%s,  result:%s", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramInt / this.iiX), Integer.valueOf(Math.abs(this.AIn)), Integer.valueOf(i) });
    AppMethodBeat.o(112742);
    return i;
  }
  
  private boolean Y(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    AppMethodBeat.i(112743);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    if (this.AHY != null) {
      if ((paramMotionEvent.getActionMasked() != 1) || (this.AIv >= 200L)) {
        if (this.atq < this.AHY.getRight()) {
          if ((f1 <= this.AHY.getLeft()) || (f1 >= this.AHY.getRight()) || (f2 <= this.AHY.getTop() - this.AHY.getHeight() / 2) || (f2 >= this.AHY.getBottom() + this.AHZ)) {}
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(112743);
      return bool;
      bool = false;
      continue;
      if ((f1 <= this.AHY.getLeft()) || (f1 >= this.AHY.getRight()) || (f2 <= this.AHY.getTop()) || (f2 >= this.AHY.getBottom() + this.AHZ))
      {
        bool = false;
        continue;
        bool = false;
      }
    }
  }
  
  private int aPa()
  {
    if (this.jbS == 0) {
      this.jbS = ((int)(this.iiX * this.AHS));
    }
    return this.jbS;
  }
  
  @TargetApi(11)
  private void bDl()
  {
    AppMethodBeat.i(112740);
    this.rN = 0;
    ak.d("MicroMsg.PullDownListView", "startAnimation %s %s %s %s", new Object[] { Integer.valueOf(this.AHX.getLeft()), Integer.valueOf(this.AHX.getTop()), Integer.valueOf(this.AHX.getRight()), Integer.valueOf(this.AHX.getBottom()) });
    AppMethodBeat.o(112740);
  }
  
  private int dPd()
  {
    if (this.jbT == 0) {
      this.jbT = ((int)((this.iiX - this.AIo) * (1.0F - this.AHT)));
    }
    return this.jbT;
  }
  
  private void dPe()
  {
    AppMethodBeat.i(112737);
    if (this.AHY != null)
    {
      float f1 = this.AHY.getTranslationX();
      float f2 = this.AHY.getTranslationY();
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.AHY, "translationX", new float[] { f1, this.AHU });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.AHY, "translationY", new float[] { f2, this.AHV });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      localAnimatorSet.addListener(new PullDownListView.3(this));
      localAnimatorSet.start();
    }
    AppMethodBeat.o(112737);
  }
  
  private boolean dPf()
  {
    AppMethodBeat.i(112741);
    if ((!this.mRect.isEmpty()) && (Math.abs(this.rN) > 0))
    {
      AppMethodBeat.o(112741);
      return true;
    }
    AppMethodBeat.o(112741);
    return false;
  }
  
  private void dPg()
  {
    AppMethodBeat.i(112744);
    if (this.AHY != null) {
      this.AHY.setVisibility(8);
    }
    AppMethodBeat.o(112744);
  }
  
  private void dPh()
  {
    AppMethodBeat.i(112745);
    if (this.AHY != null)
    {
      this.AHY.setTranslationX(this.AHU);
      this.AHY.setTranslationY(this.AHV);
      this.AHY.setVisibility(8);
    }
    AppMethodBeat.o(112745);
  }
  
  private ValueAnimator hT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112746);
    ak.d("MicroMsg.PullDownListView", "startStoryGalleryOpenAnim start:%s, end:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    localValueAnimator.addUpdateListener(new PullDownListView.5(this));
    AppMethodBeat.o(112746);
    return localValueAnimator;
  }
  
  private void y(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(112738);
    ak.i("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", new Object[] { Integer.valueOf(this.mRect.left), Integer.valueOf(this.mRect.top), Integer.valueOf(this.mRect.right), Integer.valueOf(this.mRect.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(aPa()), Integer.valueOf(dPd()), Boolean.valueOf(paramBoolean) });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ObjectAnimator.ofFloat(this, "translationY", new float[] { paramInt1, paramInt2 }));
    if ((this.apa != null) && (paramInt1 > aPa()) && (paramInt1 < dPd()))
    {
      if (paramInt2 != 0) {
        localArrayList.add(ObjectAnimator.ofFloat(this.apa, "translationY", new float[] { paramInt1, paramInt2 }));
      }
    }
    else if (this.AIf != null)
    {
      if (paramInt2 < getBottom()) {
        break label382;
      }
      localArrayList.add(hT(((ViewGroup.MarginLayoutParams)this.AIf.getLayoutParams()).topMargin, 0));
    }
    for (;;)
    {
      localAnimatorSet.addListener(new PullDownListView.4(this, paramInt1, paramInt2, paramBoolean));
      localAnimatorSet.playTogether(localArrayList);
      localAnimatorSet.start();
      bDl();
      AppMethodBeat.o(112738);
      return;
      localArrayList.add(ObjectAnimator.ofFloat(this.apa, "translationY", new float[] { paramInt1, paramInt2 - this.AHZ }));
      break;
      label382:
      localArrayList.add(hT(((ViewGroup.MarginLayoutParams)this.AIf.getLayoutParams()).topMargin, this.AIn));
    }
  }
  
  public final void dPi()
  {
    AppMethodBeat.i(112751);
    ak.i("MicroMsg.PullDownListView", "switchNormalStatus", new Object[0]);
    if (!this.isVisible) {
      y(dPd() - 1, 0, false);
    }
    AppMethodBeat.o(112751);
  }
  
  public final void dPj()
  {
    AppMethodBeat.i(112752);
    ak.i("MicroMsg.PullDownListView", "switchPullDownStatus", new Object[0]);
    if (this.isVisible) {
      y(aPa() + 1, this.AHX.getBottom() + this.AHZ, false);
    }
    AppMethodBeat.o(112752);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(112735);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(112735);
    return bool;
  }
  
  @TargetApi(11)
  protected void onFinishInflate()
  {
    AppMethodBeat.i(112734);
    this.AHX = this;
    this.AIl = getTranslationY();
    ak.d("MicroMsg.PullDownListView", "onFinishInflate %s %s %s %s", new Object[] { Integer.valueOf(this.AHX.getLeft()), Integer.valueOf(this.AHX.getTop()), Integer.valueOf(this.AHX.getRight()), Integer.valueOf(this.AHX.getBottom()) });
    AppMethodBeat.o(112734);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(112747);
    if ((this.ahl != null) && (!this.hPP) && (this.isVisible))
    {
      this.AIb = true;
      this.ahl.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(112747);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(112750);
    if ((this.AIw != null) && (!this.hPP) && (this.isVisible))
    {
      this.AIb = true;
      boolean bool = this.AIw.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
      AppMethodBeat.o(112750);
      return bool;
    }
    AppMethodBeat.o(112750);
    return false;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(112748);
    if ((this.ahm != null) && (!this.hPP) && (this.isVisible))
    {
      this.AIb = true;
      this.ahm.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(112748);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(112739);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(112739);
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AppMethodBeat.i(112749);
    if (this.ahm != null) {
      this.ahm.onNothingSelected(paramAdapterView);
    }
    AppMethodBeat.o(112749);
  }
  
  @TargetApi(11)
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(112736);
    ak.d("MicroMsg.PullDownListView", "dancy test onTouchEvent, supportOverscroll:%s, scrollY:%s", new Object[] { Boolean.valueOf(this.AHR), Integer.valueOf(getScrollY()) });
    boolean bool1;
    if ((!this.AHR) || (this.AHX == null) || (this.AIi))
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(112736);
      return bool1;
    }
    int j = paramMotionEvent.getActionMasked();
    ak.d("MicroMsg.PullDownListView", "onTouchEvent %s", new Object[] { Integer.valueOf(j) });
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
          ak.d("MicroMsg.PullDownListView", "consumed: %b", new Object[] { Boolean.valueOf(bool1) });
          if (bool1) {
            paramMotionEvent.setAction(3);
          }
          if (!bool1) {
            break label2277;
          }
          AppMethodBeat.o(112736);
          return true;
          if (this.AIp) {
            break;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          dPg();
          this.AIb = false;
          f = paramMotionEvent.getY(0);
          this.mLastMotionY = f;
          this.AIg = f;
          this.AIh = paramMotionEvent.getX(0);
          this.mRect.setEmpty();
          this.atr = paramMotionEvent.getY(0);
          this.atq = paramMotionEvent.getX(0);
          this.AIm = 0.0F;
          this.AIr = ((int)this.AIm);
          this.AIp = true;
          this.AIt = false;
          this.AIu = System.currentTimeMillis();
          this.AIv = 0L;
          dPh();
        }
        this.hPP = true;
        if (!this.AIp)
        {
          if (this.isVisible) {
            break;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.mLastMotionY = paramMotionEvent.getY(0);
          this.atr = paramMotionEvent.getY(0);
          this.AIm = (this.iiX - this.AIo);
          this.AIr = ((int)this.AIm);
          this.AIp = true;
        }
        k = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      } while (k == -1);
      this.AIg = paramMotionEvent.getY(k);
      this.AIh = paramMotionEvent.getX(k);
      if (this.AIg - this.atr >= 0.0F)
      {
        this.AIs = 2;
        i = getChildCount();
        if ((i <= 0) || (!this.isVisible)) {
          break label2425;
        }
        if (this.AIs != 2) {
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
        this.AIt = true;
      }
      label1024:
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if (!this.AIt)
      {
        ak.d("MicroMsg.PullDownListView", "rawY:%s, rawX:%s, indexY:%s, indexX:%s", new Object[] { Float.valueOf(paramMotionEvent.getRawY()), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(paramMotionEvent.getX(k)) });
        ak.d("MicroMsg.PullDownListView", "move deltaY:%s, isAnima:%s, mDeltaY:%s, mIsIgnoreCallBack:%s translateBaseY:%s", new Object[] { Integer.valueOf((int)(this.mLastMotionY - this.AIg)), Boolean.valueOf(this.AIi), Integer.valueOf(this.rN), Boolean.valueOf(this.AIb), Float.valueOf(this.AIm) });
        if ((!this.AIb) && (!this.AIi))
        {
          if (this.mRect.isEmpty())
          {
            this.AIl = getTranslationY();
            this.mRect.set(this.AHX.getLeft(), this.AHX.getTop(), this.AHX.getRight(), this.AHX.getBottom());
            ak.d("MicroMsg.PullDownListView", "mRect.isEmpty() %s %s %s %s", new Object[] { Integer.valueOf(this.AHX.getLeft()), Integer.valueOf(this.AHX.getTop()), Integer.valueOf(this.AHX.getRight()), Integer.valueOf(this.AHX.getBottom()) });
          }
          ak.d("MicroMsg.PullDownListView", "eventIndex:%s, ev.getY():%s, y_down:%s, ev.getY()-y_down:%s", new Object[] { Integer.valueOf(k), Float.valueOf(paramMotionEvent.getY(k)), Float.valueOf(this.atr), Float.valueOf(paramMotionEvent.getY(k) - this.atr) });
          this.AIr += (int)((int)(this.AIg - this.mLastMotionY) / 2.0F);
          this.rN = Math.max(0, this.AIr);
          ak.d("MicroMsg.PullDownListView", "top %s, bottom:%s, mDeltaY %s, deltaOverScrollY:%s", new Object[] { Integer.valueOf(this.AHX.getTop()), Integer.valueOf(this.AHX.getBottom()), Integer.valueOf(this.rN), Integer.valueOf(this.AIr) });
          if (Math.abs(this.AIr) > 50)
          {
            if ((!this.AIj) && (this.rN >= aPa()) && (this.rN <= dPd()))
            {
              this.jbU.vibrate(10L);
              this.AIj = true;
              this.AIq = this.AIr;
            }
            ak.d("MicroMsg.PullDownListView", "OverScroll top %s, mIsIgnoreCallBack:%s, isVisible:%s", new Object[] { Integer.valueOf(this.mRect.top + this.rN), Boolean.valueOf(this.AIb), Boolean.valueOf(this.isVisible) });
            bool1 = true;
            this.AHX.setTranslationY(this.rN);
            if (this.isVisible)
            {
              i = Rs(Math.max(this.rN - (int)this.AIm, 0));
              if (this.AIf != null)
              {
                localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.AIf.getLayoutParams();
                localMarginLayoutParams.topMargin = Math.max(this.AIn, Math.min(0, i + this.AIn));
                ak.d("MicroMsg.PullDownListView", "openingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
                this.AIf.setLayoutParams(localMarginLayoutParams);
              }
              if (this.AIa != null) {
                this.AIa.Bv(Rs(Math.max(this.rN - aPa() - (int)this.AIm, 0)));
              }
              label1174:
              if (this.AIq != 0.0F)
              {
                i = (int)((int)(this.AIr - this.AIq) * 3.0F);
                if ((!this.isVisible) || (i <= 0) || (this.AIa == null)) {
                  break label1691;
                }
                f = i;
                if (this.AHY != null)
                {
                  this.AHY.setTranslationX(Math.min(this.AHU + f, 0.0F));
                  this.AHY.setTranslationY(Math.max(this.AHV - f, 0.0F));
                  this.AHY.setVisibility(0);
                }
                if ((this.AIk) || (!Y(paramMotionEvent))) {
                  break label1663;
                }
                this.jbU.vibrate(20L);
                this.AIk = true;
                if (!this.AIk) {
                  break label1679;
                }
                this.AIa.cca();
              }
              label1301:
              label1317:
              ak.d("MicroMsg.PullDownListView", "mThis.layout %s %s %s %s", new Object[] { Integer.valueOf(this.AHX.getLeft()), Integer.valueOf(this.AHX.getTop()), Integer.valueOf(this.AHX.getRight()), Integer.valueOf(this.AHX.getBottom()) });
            }
          }
        }
      }
      for (;;)
      {
        this.mLastMotionY = this.AIg;
        break label147;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        dPg();
        this.AIb = false;
        f = paramMotionEvent.getY(0);
        this.mLastMotionY = f;
        this.AIg = f;
        this.AIh = paramMotionEvent.getX(0);
        this.mRect.setEmpty();
        this.atr = paramMotionEvent.getY(0);
        this.atq = paramMotionEvent.getX(0);
        this.AIm = 0.0F;
        this.AIr = ((int)this.AIm);
        this.AIp = true;
        dPh();
        break label385;
        this.AIs = 1;
        break label440;
        label1494:
        i = 0;
        break label483;
        label1499:
        if (this.AIs != 1) {
          break label2425;
        }
        if (getChildAt(i - 1).getBottom() >= getHeight() - getPaddingBottom())
        {
          i = 1;
          break label483;
        }
        i = 0;
        break label483;
        i = Rs(Math.max((int)this.AIm - this.rN, 0));
        if (this.AIf != null)
        {
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.AIf.getLayoutParams();
          localMarginLayoutParams.topMargin = Math.min(0, Math.max(this.AIn, -i));
          ak.d("MicroMsg.PullDownListView", "closingCoordinationView params.bottomMargin:%s", new Object[] { Integer.valueOf(localMarginLayoutParams.bottomMargin) });
          this.AIf.setLayoutParams(localMarginLayoutParams);
        }
        if (this.AIa == null) {
          break label1174;
        }
        this.AIa.Bw(Rs(Math.max(dPd() - this.rN, 0)));
        break label1174;
        label1663:
        if (Y(paramMotionEvent)) {
          break label1301;
        }
        this.AIk = false;
        break label1301;
        label1679:
        this.AIa.ccb();
        break label1317;
        label1691:
        dPg();
        break label1317;
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i == -1) {
          break;
        }
        this.AIg = paramMotionEvent.getY(i);
        this.AIh = paramMotionEvent.getX(i);
        dPe();
        this.mLastMotionY = 0.0F;
        this.AIq = 0.0F;
        this.AIj = false;
        this.AIv = (System.currentTimeMillis() - this.AIu);
        ak.d("MicroMsg.PullDownListView", "dancy test action up, mDeltaY:%s, closeLimitPx:%s, bottom:%s, mPullDownDuration%s", new Object[] { Integer.valueOf(this.rN), Integer.valueOf(dPd()), Integer.valueOf(this.AHX.getBottom()), Long.valueOf(this.AIv) });
        if ((dPf()) && (this.AIa != null) && (!this.AIi) && (this.AHW) && (!this.AIt))
        {
          ak.d("MicroMsg.PullDownListView", "dancy test action up, deltaOverScrollY:%s, translateBaseY:%s", new Object[] { Integer.valueOf(this.AIr), Float.valueOf(this.AIm) });
          if (this.AIr - this.AIm > 0.0F)
          {
            i = 1;
            label1900:
            if (i == 0) {
              break label2013;
            }
            if (((!this.isVisible) || (this.rN < aPa())) && ((this.isVisible) || (this.rN < dPd()))) {
              break label2408;
            }
          }
        }
        label1967:
        label2013:
        label2272:
        label2277:
        label2408:
        for (i = this.AHX.getBottom() + this.AHZ;; i = 0)
        {
          y(this.rN, i, Y(paramMotionEvent));
          this.AIb = false;
          this.AIp = false;
          this.AIr = 0;
          this.mActivePointerId = -1;
          this.AIt = false;
          this.AIv = 0L;
          this.AIu = 0L;
          bool1 = false;
          break label147;
          i = 0;
          break label1900;
          if (this.AIr - this.AIm < 0.0F)
          {
            i = 1;
            label2030:
            if (i == 0) {
              break label2059;
            }
            if (this.rN >= 0) {
              break label2061;
            }
            i = 0;
          }
          for (;;)
          {
            y(this.rN, i, false);
            break label1967;
            i = 0;
            break label2030;
            break label1967;
            if (this.rN >= dPd())
            {
              i = this.AHX.getBottom();
              continue;
              if (dPf()) {
                break label1967;
              }
              this.hPP = false;
              break label1967;
              dPe();
              this.AIp = false;
              this.AIb = false;
              this.mLastMotionY = 0.0F;
              this.AIq = 0.0F;
              this.AIj = false;
              if (this.AIa != null) {
                bDl();
              }
              this.AIr = 0;
              this.mActivePointerId = -1;
              this.AIt = false;
              this.AIv = 0L;
              this.AIu = 0L;
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
                ak.d("MicroMsg.PullDownListView", "super.onTouchEvent(): %b", new Object[] { Boolean.valueOf(bool2) });
                if ((this.AIa != null) && (getChildCount() > 0))
                {
                  i = getChildAt(0).getTop();
                  ak.d("MicroMsg.PullDownListView", "scrolled %s", new Object[] { Integer.valueOf(i) });
                  this.AIa.Bx(i);
                }
                AppMethodBeat.o(112736);
                return bool2;
              }
              catch (Exception paramMotionEvent)
              {
                ak.printErrStackTrace("MicroMsg.PullDownListView", paramMotionEvent, "%b, %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(j) });
                AppMethodBeat.o(112736);
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
  
  public void setMuteView(View paramView)
  {
    AppMethodBeat.i(112732);
    if (paramView != null) {
      post(new PullDownListView.1(this, paramView));
    }
    for (;;)
    {
      this.AHY = paramView;
      AppMethodBeat.o(112732);
      return;
      this.AHU = 0.0F;
      this.AHV = 0.0F;
    }
  }
  
  public void setNavigationBarHeight(int paramInt)
  {
    AppMethodBeat.i(112733);
    ak.i("MicroMsg.PullDownListView", "setNavigationBarHeight=%s", new Object[] { Integer.valueOf(paramInt) });
    this.AHZ = paramInt;
    AppMethodBeat.o(112733);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.ahl = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.AIw = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.ahm = paramOnItemSelectedListener;
  }
  
  public void setSupportOverscroll(boolean paramBoolean)
  {
    this.AHR = paramBoolean;
  }
  
  public void setTabView(View paramView)
  {
    this.apa = paramView;
  }
  
  public final void y(View paramView, int paramInt1, int paramInt2)
  {
    this.AIf = paramView;
    this.AIo = paramInt1;
    this.AIn = paramInt2;
    this.jbT = 0;
    this.jbS = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView
 * JD-Core Version:    0.7.0.1
 */