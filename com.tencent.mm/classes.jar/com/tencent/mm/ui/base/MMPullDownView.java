package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.tools.k.a;

public class MMPullDownView
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  private static int HyW;
  private static final int HyZ;
  public View HiH;
  private int HvM;
  private int Hwy;
  private int HyA;
  private boolean HyB;
  private boolean HyC;
  private boolean HyD;
  protected boolean HyE;
  private boolean HyF;
  private boolean HyG;
  private boolean HyH;
  private c HyI;
  private d HyJ;
  public View HyK;
  private int HyL;
  private int HyM;
  private int HyN;
  private boolean HyO;
  private f HyP;
  private boolean HyQ;
  private boolean HyR;
  private k HyS;
  private boolean HyT;
  private a HyU;
  private int HyV;
  private ao HyX;
  boolean HyY;
  private g Hyx;
  private e Hyy;
  private int Hyz;
  private boolean Hza;
  private int Hzb;
  private MMPullDownView.b Hzc;
  private int bgColor;
  protected Context context;
  private GestureDetector irA;
  private Scroller mScroller;
  private boolean mxg;
  
  static
  {
    AppMethodBeat.i(142100);
    HyW = 400;
    HyZ = Color.parseColor("#00000000");
    AppMethodBeat.o(142100);
  }
  
  public MMPullDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMPullDownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142077);
    this.Hwy = 1;
    this.HyB = false;
    this.HyC = false;
    this.mxg = false;
    this.HyD = false;
    this.HyE = true;
    this.HyF = false;
    this.HyG = true;
    this.HyH = true;
    this.HyM = 4;
    this.HyN = 4;
    this.HyO = false;
    this.HyQ = true;
    this.HyR = true;
    this.HyT = false;
    this.bgColor = ai.getContext().getResources().getColor(2131101179);
    this.HyV = this.bgColor;
    this.HyX = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(142076);
        super.handleMessage(paramAnonymousMessage);
        switch (MMPullDownView.a(MMPullDownView.this))
        {
        }
        for (;;)
        {
          ac.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", new Object[] { Integer.valueOf(MMPullDownView.a(MMPullDownView.this)), Boolean.valueOf(MMPullDownView.this.HyE) });
          AppMethodBeat.o(142076);
          return;
          if (MMPullDownView.b(MMPullDownView.this) != null) {
            MMPullDownView.this.HyE = MMPullDownView.b(MMPullDownView.this).bWA();
          }
          if ((MMPullDownView.this.HyE) && (MMPullDownView.c(MMPullDownView.this).getVisibility() == 0))
          {
            MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            continue;
            if (MMPullDownView.e(MMPullDownView.this) != null) {
              MMPullDownView.this.HyE = MMPullDownView.e(MMPullDownView.this).bWx();
            }
            if ((MMPullDownView.this.HyE) && (MMPullDownView.f(MMPullDownView.this).getVisibility() == 0)) {
              MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            }
          }
        }
      }
    };
    this.HyY = false;
    this.Hza = false;
    this.Hzb = -2147483648;
    this.mScroller = new Scroller(paramContext, new AccelerateInterpolator());
    this.HvM = this.Hwy;
    this.irA = new GestureDetector(paramContext, this);
    this.HyS = new k(paramContext);
    this.context = paramContext;
    this.bgColor = paramContext.getResources().getColor(2131101179);
    this.HyV = this.bgColor;
    AppMethodBeat.o(142077);
  }
  
  private void fiB()
  {
    AppMethodBeat.i(142086);
    m((ViewGroup)this.HyK, 0);
    m((ViewGroup)this.HiH, 0);
    AppMethodBeat.o(142086);
  }
  
  private void fiC()
  {
    AppMethodBeat.i(142095);
    if (this.HyP != null) {
      this.HyP.dQQ();
    }
    Scroller localScroller;
    int i;
    int j;
    if (getScrollY() - this.Hyz < 0)
    {
      if (this.HyG)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.Hyz + j, 200);
        postInvalidate();
      }
    }
    else if (getScrollY() > this.HyA)
    {
      if (!this.HyH) {
        break label230;
      }
      this.mScroller.startScroll(0, getScrollY(), 0, this.HyA - getScrollY(), 200);
    }
    for (;;)
    {
      postInvalidate();
      this.mxg = false;
      AppMethodBeat.o(142095);
      return;
      if (this.HyK.getVisibility() == 4)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.Hyz + j, 200);
      }
      if (this.HyK.getVisibility() == 0) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.HyL = 0;
      this.HyD = true;
      this.HyE = false;
      break;
      label230:
      if (this.HiH.getVisibility() == 4) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.HyA - getScrollY(), 200);
      }
      if (this.HiH.getVisibility() == 0)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = this.HyA;
        int k = getScrollY();
        localScroller.startScroll(0, i, 0, this.HyA + (j - k), 200);
      }
      this.HyL = 1;
      this.HyD = true;
      this.HyE = false;
    }
  }
  
  public static void m(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(142085);
    ac.i("MicroMsg.MMPullDownView", "fix android O progress bar bug. visibility=".concat(String.valueOf(paramInt)));
    if ((paramViewGroup != null) && (paramViewGroup.getVisibility() == 0))
    {
      if (paramViewGroup.getTag() == null) {
        paramViewGroup.setTag(paramViewGroup.findViewById(2131298140));
      }
      paramViewGroup = (View)paramViewGroup.getTag();
      if (paramViewGroup != null) {
        paramViewGroup.setVisibility(paramInt);
      }
    }
    AppMethodBeat.o(142085);
  }
  
  protected void bWW()
  {
    AppMethodBeat.i(142078);
    View localView1 = inflate(this.context, 2131494594, null);
    View localView2 = inflate(this.context, 2131494594, null);
    addView(localView1, 0, new FrameLayout.LayoutParams(-1, -2));
    addView(localView2, new FrameLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(142078);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(142089);
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
    }
    for (;;)
    {
      this.mScroller.isFinished();
      AppMethodBeat.o(142089);
      return;
      if (this.HyD)
      {
        ac.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
        this.HyD = false;
        this.HyX.sendEmptyMessageDelayed(0, HyW);
        fiB();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142092);
    boolean bool;
    if (!this.HyR)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
    }
    k localk = this.HyS;
    if (localk.IRZ != null) {
      localk.aNR.onTouchEvent(paramMotionEvent);
    }
    if (!this.HyE)
    {
      AppMethodBeat.o(142092);
      return true;
    }
    if (this.HyJ == null)
    {
      this.HyB = false;
      if (this.HyI != null) {
        break label173;
      }
      this.HyC = false;
      label87:
      if (this.HyN == 0)
      {
        if (!this.HyG) {
          break label189;
        }
        this.HyK.setVisibility(4);
      }
      label109:
      if (this.HyM == 0)
      {
        if (!this.HyH) {
          break label200;
        }
        this.HiH.setVisibility(4);
      }
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() != 1) {
        break label211;
      }
      fiC();
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
      this.HyB = this.HyJ.bWy();
      break;
      label173:
      this.HyC = this.HyI.bWz();
      break label87;
      label189:
      this.HyK.setVisibility(0);
      break label109;
      label200:
      this.HiH.setVisibility(0);
    }
    label211:
    if (paramMotionEvent.getAction() == 3)
    {
      fiC();
      if (this.HyT)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(142092);
        return bool;
      }
      AppMethodBeat.o(142092);
      return false;
    }
    if (this.irA.onTouchEvent(paramMotionEvent))
    {
      paramMotionEvent.setAction(3);
      this.HyY = true;
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
    }
    try
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      ac.printErrStackTrace("MicroMsg.MMPullDownView", paramMotionEvent, "", new Object[0]);
      AppMethodBeat.o(142092);
    }
    return true;
  }
  
  public int getBottomHeight()
  {
    return this.HyA;
  }
  
  public int getCurScreen()
  {
    return this.HvM;
  }
  
  public int getTopHeight()
  {
    return this.Hyz;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142096);
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    AppMethodBeat.o(142096);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142097);
    ac.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    AppMethodBeat.o(142097);
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142090);
    if (this.HyU != null) {
      this.HyU.onInterceptTouchEvent(paramMotionEvent);
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(142090);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142088);
    ac.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
            ac.printErrStackTrace("MicroMsg.MMPullDownView", localArrayIndexOutOfBoundsException, "childCount: %d, i:%d, childHeight:%d", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(i) });
          }
        }
      }
    }
    this.HyK = getChildAt(0);
    this.HiH = getChildAt(getChildCount() - 1);
    this.HyK.setVisibility(this.HyN);
    this.HiH.setVisibility(this.HyM);
    this.Hyz = this.HyK.getHeight();
    this.HyA = this.HiH.getHeight();
    this.Hzb = this.Hyz;
    if ((!this.HyF) && (this.Hyz != 0))
    {
      this.HyF = true;
      scrollTo(0, this.Hyz);
    }
    AppMethodBeat.o(142088);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142087);
    if (!this.HyO)
    {
      bWW();
      this.HyO = true;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(142087);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142098);
    if (paramFloat2 > 0.0F)
    {
      this.mxg = true;
      if (Math.abs(paramFloat2) <= Math.abs(paramFloat1)) {
        break label141;
      }
    }
    label141:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.HyP != null)) {
        this.HyP.bD(paramFloat2);
      }
      if ((!this.HyC) || ((!this.mxg) && (getScrollY() - this.Hyz <= 0)) || (i == 0)) {
        break label324;
      }
      if ((this.HyQ) || ((this.HiH.getVisibility() == 0) && ((!this.mxg) || (getScrollY() < this.Hyz * 2)))) {
        break label147;
      }
      AppMethodBeat.o(142098);
      return true;
      this.mxg = false;
      break;
    }
    label147:
    int j = (int)(paramFloat2 * 0.5D);
    i = j;
    if (j == 0)
    {
      if (paramFloat2 > 0.0F) {
        i = 1;
      }
    }
    else
    {
      ac.v("check", "moveUp:" + i + " distanceY:" + paramFloat2 + " scrollY:" + getScrollY());
      if ((getScrollY() + i >= this.Hyz) || (this.mxg)) {
        break label277;
      }
      j = this.Hyz - getScrollY();
    }
    for (;;)
    {
      scrollBy(0, j);
      AppMethodBeat.o(142098);
      return true;
      i = -1;
      break;
      label277:
      j = i;
      if (!this.HyQ)
      {
        j = i;
        if (getScrollY() + i >= this.Hyz * 2) {
          j = this.Hyz * 2 - getScrollY();
        }
      }
    }
    label324:
    if ((this.HyB) && ((!this.mxg) || (getScrollY() - this.Hyz < 0)) && (i != 0))
    {
      if ((!this.HyQ) && ((this.HyK.getVisibility() != 0) || ((!this.mxg) && (getScrollY() <= 0))))
      {
        AppMethodBeat.o(142098);
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
        if (getScrollY() + i <= this.Hyz) {
          break label469;
        }
        j = this.Hyz - getScrollY();
      }
      for (;;)
      {
        scrollBy(0, j);
        AppMethodBeat.o(142098);
        return true;
        i = -1;
        break;
        label469:
        j = i;
        if (!this.HyQ)
        {
          j = i;
          if (getScrollY() + i < 0) {
            j = -getScrollY();
          }
        }
      }
    }
    AppMethodBeat.o(142098);
    return false;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142099);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.Hzc != null) {
      this.Hzc.chO();
    }
    if (!this.Hza)
    {
      AppMethodBeat.o(142099);
      return;
    }
    if (this.Hzb == -2147483648)
    {
      this.Hzb = this.Hyz;
      ac.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.Hzb);
    }
    if ((paramInt2 <= this.Hzb) && (this.HyV != HyZ))
    {
      setBackgroundResource(2131233299);
      this.HyV = HyZ;
      ac.d("MicroMsg.MMPullDownView", "onScrollChanged full");
      AppMethodBeat.o(142099);
      return;
    }
    if ((paramInt2 > this.Hzb) && (this.HyV != this.bgColor))
    {
      ac.d("MicroMsg.MMPullDownView", "onScrollChanged white");
      setBackgroundColor(this.bgColor);
      this.HyV = this.bgColor;
    }
    AppMethodBeat.o(142099);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142091);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(142091);
      return true;
      if (getScrollY() - this.Hyz < 0) {
        this.HyB = true;
      }
      if (getScrollY() > this.HyA) {
        this.HyC = true;
      }
      fiC();
    }
  }
  
  public void setAtBottomCallBack(c paramc)
  {
    this.HyI = paramc;
  }
  
  public void setAtTopCallBack(d paramd)
  {
    this.HyJ = paramd;
  }
  
  public void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
    this.HyV = this.bgColor;
  }
  
  public void setBottomView(View paramView)
  {
    AppMethodBeat.i(142082);
    if (paramView == null)
    {
      this.HyM = 4;
      if (this.HiH != null)
      {
        this.HiH.setVisibility(4);
        AppMethodBeat.o(142082);
      }
    }
    else
    {
      this.HiH = paramView;
      this.HiH.setVisibility(0);
      this.HyM = 0;
      removeViewAt(getChildCount() - 1);
      addView(this.HiH, new FrameLayout.LayoutParams(-1, -2));
      this.HyA = 0;
    }
    AppMethodBeat.o(142082);
  }
  
  public void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142083);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.HyM = i;
      if (this.HiH != null) {
        this.HiH.setVisibility(this.HyM);
      }
      ac.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bs.eWi() });
      AppMethodBeat.o(142083);
      return;
    }
  }
  
  public void setCanOverScrool(boolean paramBoolean)
  {
    this.HyQ = paramBoolean;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.HyR = paramBoolean;
  }
  
  public void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142080);
    ac.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.HyH), bs.eWi() });
    this.HyH = paramBoolean;
    AppMethodBeat.o(142080);
  }
  
  public void setIsReturnSuperDispatchWhenCancel(boolean paramBoolean)
  {
    this.HyT = paramBoolean;
  }
  
  public void setIsTopShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142079);
    ac.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.HyG), bs.eWi() });
    this.HyG = paramBoolean;
    AppMethodBeat.o(142079);
  }
  
  public void setOnBottomLoadDataListener(e parame)
  {
    this.Hyy = parame;
  }
  
  public void setOnInterceptTouchEventListener(a parama)
  {
    this.HyU = parama;
  }
  
  public void setOnMMFlingListener(k.a parama)
  {
    this.HyS.IRZ = parama;
  }
  
  public void setOnScrollChangedListener(MMPullDownView.b paramb)
  {
    this.Hzc = paramb;
  }
  
  public void setOnSrcollDistance(f paramf)
  {
    this.HyP = paramf;
  }
  
  public void setOnTopLoadDataListener(g paramg)
  {
    this.Hyx = paramg;
  }
  
  public void setShowBackground(boolean paramBoolean)
  {
    this.Hza = paramBoolean;
  }
  
  public void setTopView(View paramView)
  {
    AppMethodBeat.i(142081);
    if (paramView == null)
    {
      this.HyN = 4;
      if (this.HyK != null)
      {
        this.HyK.setVisibility(4);
        AppMethodBeat.o(142081);
      }
    }
    else
    {
      removeViewAt(0);
      this.HyK = paramView;
      this.HyK.setVisibility(0);
      this.HyN = 0;
      addView(this.HyK, 0, new FrameLayout.LayoutParams(-1, -2));
      this.Hyz = 0;
    }
    AppMethodBeat.o(142081);
  }
  
  public void setTopViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142084);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.HyN = i;
      if (this.HyK != null) {
        this.HyK.setVisibility(this.HyN);
      }
      ac.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(142084);
      return;
    }
  }
  
  public void wP(boolean paramBoolean)
  {
    AppMethodBeat.i(142093);
    ac.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.HyD), Boolean.valueOf(this.HyE), Boolean.valueOf(this.HyG), Integer.valueOf(getScrollY()) });
    Scroller localScroller;
    int i;
    int j;
    if (paramBoolean)
    {
      if (this.HyK != null) {
        this.HyK.setVisibility(this.HyN);
      }
      if (this.HyG)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.Hyz + j, 200);
        postInvalidate();
      }
    }
    for (;;)
    {
      if (!this.HyG) {
        fiB();
      }
      AppMethodBeat.o(142093);
      return;
      if ((this.HyK != null) && (this.HyK.getVisibility() == 4))
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.Hyz + j, 200);
      }
      if ((this.HyK != null) && (this.HyK.getVisibility() == 0)) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.HyL = 0;
      this.HyD = true;
      this.HyE = false;
      break;
      if (!this.HyE)
      {
        this.HyE = true;
        this.HyD = false;
        if ((this.HyK != null) && (this.HyK.getVisibility() == 0)) {
          scrollTo(0, this.Hyz);
        }
      }
      if ((this.HyK != null) && (this.HyK.getVisibility() == 0)) {
        this.HyK.setVisibility(8);
      }
    }
  }
  
  public final void wQ(boolean paramBoolean)
  {
    AppMethodBeat.i(142094);
    ac.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.HyD), Boolean.valueOf(this.HyE), Boolean.valueOf(this.HyH), Integer.valueOf(getScrollY()) });
    if (paramBoolean)
    {
      if (this.HiH != null) {
        this.HiH.setVisibility(this.HyN);
      }
      if (this.HyH) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.HyA - getScrollY(), 200);
      }
      for (;;)
      {
        postInvalidate();
        AppMethodBeat.o(142094);
        return;
        if ((this.HiH != null) && (this.HiH.getVisibility() == 4)) {
          this.mScroller.startScroll(0, getScrollY(), 0, this.HyA - getScrollY(), 200);
        }
        if ((this.HiH != null) && (this.HiH.getVisibility() == 0))
        {
          Scroller localScroller = this.mScroller;
          int i = getScrollY();
          int j = this.HyA;
          int k = getScrollY();
          localScroller.startScroll(0, i, 0, this.HyA + (j - k), 200);
        }
        this.HyL = 1;
        this.HyD = true;
        this.HyE = false;
      }
    }
    if (!this.HyE)
    {
      this.HyE = true;
      this.HyD = false;
    }
    if ((this.HiH != null) && (this.HiH.getVisibility() == 0))
    {
      ac.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
      scrollTo(0, this.Hyz);
    }
    if ((this.HiH != null) && (this.HiH.getVisibility() == 0)) {
      this.HiH.setVisibility(8);
    }
    AppMethodBeat.o(142094);
  }
  
  public static abstract interface a
  {
    public abstract boolean onInterceptTouchEvent(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface c
  {
    public abstract boolean bWz();
  }
  
  public static abstract interface d
  {
    public abstract boolean bWy();
  }
  
  public static abstract interface e
  {
    public abstract boolean bWx();
  }
  
  public static abstract interface f
  {
    public abstract void bD(float paramFloat);
    
    public abstract void dQQ();
  }
  
  public static abstract interface g
  {
    public abstract boolean bWA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPullDownView
 * JD-Core Version:    0.7.0.1
 */