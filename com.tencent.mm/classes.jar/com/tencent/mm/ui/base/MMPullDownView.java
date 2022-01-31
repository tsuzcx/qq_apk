package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.tools.k.a;

public class MMPullDownView
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  private static int zlG;
  private static final int zlJ;
  private int bgColor;
  protected Context context;
  private boolean jfa;
  private GestureDetector lOj;
  private Scroller mScroller;
  public View yWv;
  private int ziu;
  private int zjg;
  private boolean zlA;
  private MMPullDownView.f zlB;
  private boolean zlC;
  private k zlD;
  private boolean zlE;
  private MMPullDownView.a zlF;
  private ak zlH;
  boolean zlI;
  private boolean zlK;
  private int zlL;
  private int zlM;
  private MMPullDownView.b zlN;
  private MMPullDownView.g zlj;
  private MMPullDownView.e zlk;
  private int zll;
  private int zlm;
  private boolean zln;
  private boolean zlo;
  private boolean zlp;
  protected boolean zlq;
  private boolean zlr;
  private boolean zls;
  private boolean zlt;
  private MMPullDownView.c zlu;
  private MMPullDownView.d zlv;
  public View zlw;
  private int zlx;
  private int zly;
  private int zlz;
  
  static
  {
    AppMethodBeat.i(106746);
    zlG = 400;
    zlJ = Color.parseColor("#00000000");
    AppMethodBeat.o(106746);
  }
  
  public MMPullDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMPullDownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106722);
    this.zjg = 1;
    this.zln = false;
    this.zlo = false;
    this.jfa = false;
    this.zlp = false;
    this.zlq = true;
    this.zlr = false;
    this.zls = true;
    this.zlt = true;
    this.zly = 4;
    this.zlz = 4;
    this.zlA = false;
    this.zlC = true;
    this.zlE = false;
    this.zlH = new ak()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(106721);
        super.handleMessage(paramAnonymousMessage);
        switch (MMPullDownView.a(MMPullDownView.this))
        {
        }
        for (;;)
        {
          ab.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", new Object[] { Integer.valueOf(MMPullDownView.a(MMPullDownView.this)), Boolean.valueOf(MMPullDownView.this.zlq) });
          AppMethodBeat.o(106721);
          return;
          if (MMPullDownView.b(MMPullDownView.this) != null) {
            MMPullDownView.this.zlq = MMPullDownView.b(MMPullDownView.this).bin();
          }
          if ((MMPullDownView.this.zlq) && (MMPullDownView.c(MMPullDownView.this).getVisibility() == 0))
          {
            MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            continue;
            if (MMPullDownView.e(MMPullDownView.this) != null) {
              MMPullDownView.this.zlq = MMPullDownView.e(MMPullDownView.this).bik();
            }
            if ((MMPullDownView.this.zlq) && (MMPullDownView.f(MMPullDownView.this).getVisibility() == 0)) {
              MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            }
          }
        }
      }
    };
    this.zlI = false;
    this.zlK = false;
    this.bgColor = Color.parseColor("#ffffffff");
    this.zlL = -2147483648;
    this.zlM = this.bgColor;
    this.mScroller = new Scroller(paramContext, new AccelerateInterpolator());
    this.ziu = this.zjg;
    this.lOj = new GestureDetector(paramContext, this);
    this.zlD = new k(paramContext);
    this.context = paramContext;
    AppMethodBeat.o(106722);
  }
  
  public static void d(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(106730);
    ab.i("MicroMsg.MMPullDownView", "fix android O progress bar bug.");
    if ((paramViewGroup != null) && (paramViewGroup.getVisibility() == 0))
    {
      if (paramViewGroup.getTag() == null) {
        paramViewGroup.setTag(paramViewGroup.findViewById(2131822228));
      }
      paramViewGroup = (View)paramViewGroup.getTag();
      if (paramViewGroup != null) {
        paramViewGroup.setVisibility(paramInt);
      }
    }
    AppMethodBeat.o(106730);
  }
  
  private void dEd()
  {
    AppMethodBeat.i(106731);
    d((ViewGroup)this.zlw, 0);
    d((ViewGroup)this.yWv, 0);
    AppMethodBeat.o(106731);
  }
  
  private void dEe()
  {
    AppMethodBeat.i(106740);
    if (this.zlB != null) {
      this.zlB.cwp();
    }
    Scroller localScroller;
    int i;
    int j;
    if (getScrollY() - this.zll < 0)
    {
      if (this.zls)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.zll + j, 200);
        postInvalidate();
      }
    }
    else if (getScrollY() > this.zlm)
    {
      if (!this.zlt) {
        break label230;
      }
      this.mScroller.startScroll(0, getScrollY(), 0, this.zlm - getScrollY(), 200);
    }
    for (;;)
    {
      postInvalidate();
      this.jfa = false;
      AppMethodBeat.o(106740);
      return;
      if (this.zlw.getVisibility() == 4)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.zll + j, 200);
      }
      if (this.zlw.getVisibility() == 0) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.zlx = 0;
      this.zlp = true;
      this.zlq = false;
      break;
      label230:
      if (this.yWv.getVisibility() == 4) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.zlm - getScrollY(), 200);
      }
      if (this.yWv.getVisibility() == 0)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = this.zlm;
        int k = getScrollY();
        localScroller.startScroll(0, i, 0, this.zlm + (j - k), 200);
      }
      this.zlx = 1;
      this.zlp = true;
      this.zlq = false;
    }
  }
  
  protected void biE()
  {
    AppMethodBeat.i(106723);
    View localView1 = inflate(this.context, 2130969990, null);
    View localView2 = inflate(this.context, 2130969990, null);
    addView(localView1, 0, new FrameLayout.LayoutParams(-1, -2));
    addView(localView2, new FrameLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(106723);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(106734);
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
    }
    for (;;)
    {
      this.mScroller.isFinished();
      AppMethodBeat.o(106734);
      return;
      if (this.zlp)
      {
        ab.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
        this.zlp = false;
        this.zlH.sendEmptyMessageDelayed(0, zlG);
        dEd();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106737);
    k localk = this.zlD;
    if (localk.AvD != null) {
      localk.asq.onTouchEvent(paramMotionEvent);
    }
    if (!this.zlq)
    {
      AppMethodBeat.o(106737);
      return true;
    }
    if (this.zlv == null)
    {
      this.zln = false;
      if (this.zlu != null) {
        break label152;
      }
      this.zlo = false;
      label66:
      if (this.zlz == 0)
      {
        if (!this.zls) {
          break label168;
        }
        this.zlw.setVisibility(4);
      }
      label88:
      if (this.zly == 0)
      {
        if (!this.zlt) {
          break label179;
        }
        this.yWv.setVisibility(4);
      }
    }
    boolean bool;
    for (;;)
    {
      if (paramMotionEvent.getAction() != 1) {
        break label190;
      }
      dEe();
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106737);
      return bool;
      this.zln = this.zlv.bil();
      break;
      label152:
      this.zlo = this.zlu.bim();
      break label66;
      label168:
      this.zlw.setVisibility(0);
      break label88;
      label179:
      this.yWv.setVisibility(0);
    }
    label190:
    if (paramMotionEvent.getAction() == 3)
    {
      dEe();
      if (this.zlE)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(106737);
        return bool;
      }
      AppMethodBeat.o(106737);
      return false;
    }
    if (this.lOj.onTouchEvent(paramMotionEvent))
    {
      paramMotionEvent.setAction(3);
      this.zlI = true;
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106737);
      return bool;
    }
    try
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106737);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      ab.printErrStackTrace("MicroMsg.MMPullDownView", paramMotionEvent, "", new Object[0]);
      AppMethodBeat.o(106737);
    }
    return true;
  }
  
  public int getBottomHeight()
  {
    return this.zlm;
  }
  
  public int getCurScreen()
  {
    return this.ziu;
  }
  
  public int getTopHeight()
  {
    return this.zll;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106741);
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    AppMethodBeat.o(106741);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(106742);
    ab.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    AppMethodBeat.o(106742);
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106735);
    if (this.zlF != null) {
      this.zlF.onInterceptTouchEvent(paramMotionEvent);
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(106735);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106733);
    ab.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    paramInt2 = 0;
    paramInt4 = getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt4)
      {
        View localView = getChildAt(paramInt1);
        int i = localView.getMeasuredHeight();
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 8) {}
        try
        {
          localView.layout(0, paramInt2, localView.getMeasuredWidth(), paramInt2 + i);
          paramInt3 = paramInt2 + i;
          paramInt1 += 1;
          paramInt2 = paramInt3;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.MMPullDownView", localArrayIndexOutOfBoundsException, "childCount: %d, i:%d, childHeight:%d", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(i) });
          }
        }
      }
    }
    this.zlw = getChildAt(0);
    this.yWv = getChildAt(getChildCount() - 1);
    this.zlw.setVisibility(this.zlz);
    this.yWv.setVisibility(this.zly);
    this.zll = this.zlw.getHeight();
    this.zlm = this.yWv.getHeight();
    this.zlL = this.zll;
    if ((!this.zlr) && (this.zll != 0))
    {
      this.zlr = true;
      scrollTo(0, this.zll);
    }
    AppMethodBeat.o(106733);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106732);
    if (!this.zlA)
    {
      biE();
      this.zlA = true;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(106732);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(106743);
    if (this.zlB != null) {
      this.zlB.be(paramFloat2);
    }
    if (paramFloat2 > 0.0F) {
      this.jfa = true;
    }
    int j;
    int i;
    while ((this.zlo) && ((this.jfa) || (getScrollY() - this.zll > 0))) {
      if ((!this.zlC) && ((this.yWv.getVisibility() != 0) || ((this.jfa) && (getScrollY() >= this.zll * 2))))
      {
        AppMethodBeat.o(106743);
        return true;
        this.jfa = false;
      }
      else
      {
        j = (int)(paramFloat2 * 0.5D);
        i = j;
        if (j == 0)
        {
          if (paramFloat2 > 0.0F) {
            i = 1;
          }
        }
        else
        {
          ab.v("check", "moveUp:" + i + " distanceY:" + paramFloat2 + " scrollY:" + getScrollY());
          if ((getScrollY() + i >= this.zll) || (this.jfa)) {
            break label245;
          }
          j = this.zll - getScrollY();
        }
        for (;;)
        {
          scrollBy(0, j);
          AppMethodBeat.o(106743);
          return true;
          i = -1;
          break;
          label245:
          j = i;
          if (!this.zlC)
          {
            j = i;
            if (getScrollY() + i >= this.zll * 2) {
              j = this.zll * 2 - getScrollY();
            }
          }
        }
      }
    }
    if ((this.zln) && ((!this.jfa) || (getScrollY() - this.zll < 0)))
    {
      if ((!this.zlC) && ((this.zlw.getVisibility() != 0) || ((!this.jfa) && (getScrollY() <= 0))))
      {
        AppMethodBeat.o(106743);
        return true;
      }
      j = (int)(paramFloat2 * 0.5D);
      i = j;
      if (j == 0)
      {
        if (paramFloat2 > 0.0F) {
          i = 1;
        }
      }
      else
      {
        if (getScrollY() + i <= this.zll) {
          break label432;
        }
        j = this.zll - getScrollY();
      }
      for (;;)
      {
        scrollBy(0, j);
        AppMethodBeat.o(106743);
        return true;
        i = -1;
        break;
        label432:
        j = i;
        if (!this.zlC)
        {
          j = i;
          if (getScrollY() + i < 0) {
            j = -getScrollY();
          }
        }
      }
    }
    AppMethodBeat.o(106743);
    return false;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106745);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.zlN != null) {
      this.zlN.bqW();
    }
    if (!this.zlK)
    {
      AppMethodBeat.o(106745);
      return;
    }
    if (this.zlL == -2147483648)
    {
      this.zlL = this.zll;
      ab.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.zlL);
    }
    if ((paramInt2 <= this.zlL) && (this.zlM != zlJ))
    {
      setBackgroundResource(2130839676);
      this.zlM = zlJ;
      ab.d("MicroMsg.MMPullDownView", "onScrollChanged full");
      AppMethodBeat.o(106745);
      return;
    }
    if ((paramInt2 > this.zlL) && (this.zlM != this.bgColor))
    {
      ab.d("MicroMsg.MMPullDownView", "onScrollChanged white");
      setBackgroundColor(this.bgColor);
      this.zlM = this.bgColor;
    }
    AppMethodBeat.o(106745);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106736);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(106736);
      return true;
      if (getScrollY() - this.zll < 0) {
        this.zln = true;
      }
      if (getScrollY() > this.zlm) {
        this.zlo = true;
      }
      dEe();
    }
  }
  
  public void qD(boolean paramBoolean)
  {
    AppMethodBeat.i(106738);
    ab.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.zlp), Boolean.valueOf(this.zlq), Boolean.valueOf(this.zls), Integer.valueOf(getScrollY()) });
    Scroller localScroller;
    int i;
    int j;
    if (paramBoolean)
    {
      if (this.zlw != null) {
        this.zlw.setVisibility(this.zlz);
      }
      if (this.zls)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.zll + j, 200);
        postInvalidate();
      }
    }
    for (;;)
    {
      dEd();
      AppMethodBeat.o(106738);
      return;
      if ((this.zlw != null) && (this.zlw.getVisibility() == 4))
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.zll + j, 200);
      }
      if ((this.zlw != null) && (this.zlw.getVisibility() == 0)) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.zlx = 0;
      this.zlp = true;
      this.zlq = false;
      break;
      if (!this.zlq)
      {
        this.zlq = true;
        this.zlp = false;
        if ((this.zlw != null) && (this.zlw.getVisibility() == 0)) {
          scrollTo(0, this.zll);
        }
      }
      if ((this.zlw != null) && (this.zlw.getVisibility() == 0)) {
        this.zlw.setVisibility(8);
      }
    }
  }
  
  public final void qE(boolean paramBoolean)
  {
    AppMethodBeat.i(106739);
    ab.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.zlp), Boolean.valueOf(this.zlq), Boolean.valueOf(this.zlt), Integer.valueOf(getScrollY()) });
    if (paramBoolean)
    {
      if (this.yWv != null) {
        this.yWv.setVisibility(this.zlz);
      }
      if (this.zlt) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.zlm - getScrollY(), 200);
      }
      for (;;)
      {
        postInvalidate();
        AppMethodBeat.o(106739);
        return;
        if ((this.yWv != null) && (this.yWv.getVisibility() == 4)) {
          this.mScroller.startScroll(0, getScrollY(), 0, this.zlm - getScrollY(), 200);
        }
        if ((this.yWv != null) && (this.yWv.getVisibility() == 0))
        {
          Scroller localScroller = this.mScroller;
          int i = getScrollY();
          int j = this.zlm;
          int k = getScrollY();
          localScroller.startScroll(0, i, 0, this.zlm + (j - k), 200);
        }
        this.zlx = 1;
        this.zlp = true;
        this.zlq = false;
      }
    }
    if (!this.zlq)
    {
      this.zlq = true;
      this.zlp = false;
    }
    if ((this.yWv != null) && (this.yWv.getVisibility() == 0))
    {
      ab.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
      scrollTo(0, this.zll);
    }
    if ((this.yWv != null) && (this.yWv.getVisibility() == 0)) {
      this.yWv.setVisibility(8);
    }
    AppMethodBeat.o(106739);
  }
  
  public void setAtBottomCallBack(MMPullDownView.c paramc)
  {
    this.zlu = paramc;
  }
  
  public void setAtTopCallBack(MMPullDownView.d paramd)
  {
    this.zlv = paramd;
  }
  
  public void setBgColor(String paramString)
  {
    AppMethodBeat.i(106744);
    this.bgColor = Color.parseColor(paramString);
    this.zlM = this.bgColor;
    AppMethodBeat.o(106744);
  }
  
  public void setBottomView(View paramView)
  {
    AppMethodBeat.i(106727);
    if (paramView == null)
    {
      this.zly = 4;
      if (this.yWv != null)
      {
        this.yWv.setVisibility(4);
        AppMethodBeat.o(106727);
      }
    }
    else
    {
      this.yWv = paramView;
      this.yWv.setVisibility(0);
      this.zly = 0;
      removeViewAt(getChildCount() - 1);
      addView(this.yWv, new FrameLayout.LayoutParams(-1, -2));
      this.zlm = 0;
    }
    AppMethodBeat.o(106727);
  }
  
  public void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(106728);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.zly = i;
      if (this.yWv != null) {
        this.yWv.setVisibility(this.zly);
      }
      ab.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bo.dtY() });
      AppMethodBeat.o(106728);
      return;
    }
  }
  
  public void setCanOverScrool(boolean paramBoolean)
  {
    this.zlC = paramBoolean;
  }
  
  public void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(106725);
    ab.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.zlt), bo.dtY() });
    this.zlt = paramBoolean;
    AppMethodBeat.o(106725);
  }
  
  public void setIsReturnSuperDispatchWhenCancel(boolean paramBoolean)
  {
    this.zlE = paramBoolean;
  }
  
  public void setIsTopShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(106724);
    ab.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.zls), bo.dtY() });
    this.zls = paramBoolean;
    AppMethodBeat.o(106724);
  }
  
  public void setOnBottomLoadDataListener(MMPullDownView.e parame)
  {
    this.zlk = parame;
  }
  
  public void setOnInterceptTouchEventListener(MMPullDownView.a parama)
  {
    this.zlF = parama;
  }
  
  public void setOnMMFlingListener(k.a parama)
  {
    this.zlD.AvD = parama;
  }
  
  public void setOnScrollChangedListener(MMPullDownView.b paramb)
  {
    this.zlN = paramb;
  }
  
  public void setOnSrcollDistance(MMPullDownView.f paramf)
  {
    this.zlB = paramf;
  }
  
  public void setOnTopLoadDataListener(MMPullDownView.g paramg)
  {
    this.zlj = paramg;
  }
  
  public void setShowBackground(boolean paramBoolean)
  {
    this.zlK = paramBoolean;
  }
  
  public void setTopView(View paramView)
  {
    AppMethodBeat.i(106726);
    if (paramView == null)
    {
      this.zlz = 4;
      if (this.zlw != null)
      {
        this.zlw.setVisibility(4);
        AppMethodBeat.o(106726);
      }
    }
    else
    {
      removeViewAt(0);
      this.zlw = paramView;
      this.zlw.setVisibility(0);
      this.zlz = 0;
      addView(this.zlw, 0, new FrameLayout.LayoutParams(-1, -2));
      this.zll = 0;
    }
    AppMethodBeat.o(106726);
  }
  
  public void setTopViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(106729);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.zlz = i;
      if (this.zlw != null) {
        this.zlw.setVisibility(this.zlz);
      }
      ab.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(106729);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPullDownView
 * JD-Core Version:    0.7.0.1
 */