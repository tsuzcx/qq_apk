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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.tools.k.a;

public class MMPullDownView
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  private static int FZh;
  private static final int FZk;
  public View FJA;
  private int FVY;
  private int FWK;
  private g FYI;
  private e FYJ;
  private int FYK;
  private int FYL;
  private boolean FYM;
  private boolean FYN;
  private boolean FYO;
  protected boolean FYP;
  private boolean FYQ;
  private boolean FYR;
  private boolean FYS;
  private c FYT;
  private d FYU;
  public View FYV;
  private int FYW;
  private int FYX;
  private int FYY;
  private boolean FYZ;
  private f FZa;
  private boolean FZb;
  private boolean FZc;
  private k FZd;
  private boolean FZe;
  private a FZf;
  private int FZg;
  private ap FZi;
  boolean FZj;
  private boolean FZl;
  private int FZm;
  private b FZn;
  private int bgColor;
  protected Context context;
  private GestureDetector hRv;
  private boolean lVe;
  private Scroller mScroller;
  
  static
  {
    AppMethodBeat.i(142100);
    FZh = 400;
    FZk = Color.parseColor("#00000000");
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
    this.FWK = 1;
    this.FYM = false;
    this.FYN = false;
    this.lVe = false;
    this.FYO = false;
    this.FYP = true;
    this.FYQ = false;
    this.FYR = true;
    this.FYS = true;
    this.FYX = 4;
    this.FYY = 4;
    this.FYZ = false;
    this.FZb = true;
    this.FZc = true;
    this.FZe = false;
    this.bgColor = aj.getContext().getResources().getColor(2131101179);
    this.FZg = this.bgColor;
    this.FZi = new ap()
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
          ad.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", new Object[] { Integer.valueOf(MMPullDownView.a(MMPullDownView.this)), Boolean.valueOf(MMPullDownView.this.FYP) });
          AppMethodBeat.o(142076);
          return;
          if (MMPullDownView.b(MMPullDownView.this) != null) {
            MMPullDownView.this.FYP = MMPullDownView.b(MMPullDownView.this).bPk();
          }
          if ((MMPullDownView.this.FYP) && (MMPullDownView.c(MMPullDownView.this).getVisibility() == 0))
          {
            MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            continue;
            if (MMPullDownView.e(MMPullDownView.this) != null) {
              MMPullDownView.this.FYP = MMPullDownView.e(MMPullDownView.this).bPh();
            }
            if ((MMPullDownView.this.FYP) && (MMPullDownView.f(MMPullDownView.this).getVisibility() == 0)) {
              MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            }
          }
        }
      }
    };
    this.FZj = false;
    this.FZl = false;
    this.FZm = -2147483648;
    this.mScroller = new Scroller(paramContext, new AccelerateInterpolator());
    this.FVY = this.FWK;
    this.hRv = new GestureDetector(paramContext, this);
    this.FZd = new k(paramContext);
    this.context = paramContext;
    this.bgColor = paramContext.getResources().getColor(2131101179);
    this.FZg = this.bgColor;
    AppMethodBeat.o(142077);
  }
  
  private void eSR()
  {
    AppMethodBeat.i(142086);
    m((ViewGroup)this.FYV, 0);
    m((ViewGroup)this.FJA, 0);
    AppMethodBeat.o(142086);
  }
  
  private void eSS()
  {
    AppMethodBeat.i(142095);
    if (this.FZa != null) {
      this.FZa.dCt();
    }
    Scroller localScroller;
    int i;
    int j;
    if (getScrollY() - this.FYK < 0)
    {
      if (this.FYR)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.FYK + j, 200);
        postInvalidate();
      }
    }
    else if (getScrollY() > this.FYL)
    {
      if (!this.FYS) {
        break label230;
      }
      this.mScroller.startScroll(0, getScrollY(), 0, this.FYL - getScrollY(), 200);
    }
    for (;;)
    {
      postInvalidate();
      this.lVe = false;
      AppMethodBeat.o(142095);
      return;
      if (this.FYV.getVisibility() == 4)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.FYK + j, 200);
      }
      if (this.FYV.getVisibility() == 0) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.FYW = 0;
      this.FYO = true;
      this.FYP = false;
      break;
      label230:
      if (this.FJA.getVisibility() == 4) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.FYL - getScrollY(), 200);
      }
      if (this.FJA.getVisibility() == 0)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = this.FYL;
        int k = getScrollY();
        localScroller.startScroll(0, i, 0, this.FYL + (j - k), 200);
      }
      this.FYW = 1;
      this.FYO = true;
      this.FYP = false;
    }
  }
  
  public static void m(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(142085);
    ad.i("MicroMsg.MMPullDownView", "fix android O progress bar bug. visibility=".concat(String.valueOf(paramInt)));
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
  
  protected void bPG()
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
      if (this.FYO)
      {
        ad.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
        this.FYO = false;
        this.FZi.sendEmptyMessageDelayed(0, FZh);
        eSR();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142092);
    boolean bool;
    if (!this.FZc)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
    }
    k localk = this.FZd;
    if (localk.HrC != null) {
      localk.aNb.onTouchEvent(paramMotionEvent);
    }
    if (!this.FYP)
    {
      AppMethodBeat.o(142092);
      return true;
    }
    if (this.FYU == null)
    {
      this.FYM = false;
      if (this.FYT != null) {
        break label173;
      }
      this.FYN = false;
      label87:
      if (this.FYY == 0)
      {
        if (!this.FYR) {
          break label189;
        }
        this.FYV.setVisibility(4);
      }
      label109:
      if (this.FYX == 0)
      {
        if (!this.FYS) {
          break label200;
        }
        this.FJA.setVisibility(4);
      }
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() != 1) {
        break label211;
      }
      eSS();
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
      this.FYM = this.FYU.bPi();
      break;
      label173:
      this.FYN = this.FYT.bPj();
      break label87;
      label189:
      this.FYV.setVisibility(0);
      break label109;
      label200:
      this.FJA.setVisibility(0);
    }
    label211:
    if (paramMotionEvent.getAction() == 3)
    {
      eSS();
      if (this.FZe)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(142092);
        return bool;
      }
      AppMethodBeat.o(142092);
      return false;
    }
    if (this.hRv.onTouchEvent(paramMotionEvent))
    {
      paramMotionEvent.setAction(3);
      this.FZj = true;
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
      ad.printErrStackTrace("MicroMsg.MMPullDownView", paramMotionEvent, "", new Object[0]);
      AppMethodBeat.o(142092);
    }
    return true;
  }
  
  public int getBottomHeight()
  {
    return this.FYL;
  }
  
  public int getCurScreen()
  {
    return this.FVY;
  }
  
  public int getTopHeight()
  {
    return this.FYK;
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
    ad.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    AppMethodBeat.o(142097);
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142090);
    if (this.FZf != null) {
      this.FZf.onInterceptTouchEvent(paramMotionEvent);
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(142090);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142088);
    ad.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
            ad.printErrStackTrace("MicroMsg.MMPullDownView", localArrayIndexOutOfBoundsException, "childCount: %d, i:%d, childHeight:%d", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(i) });
          }
        }
      }
    }
    this.FYV = getChildAt(0);
    this.FJA = getChildAt(getChildCount() - 1);
    this.FYV.setVisibility(this.FYY);
    this.FJA.setVisibility(this.FYX);
    this.FYK = this.FYV.getHeight();
    this.FYL = this.FJA.getHeight();
    this.FZm = this.FYK;
    if ((!this.FYQ) && (this.FYK != 0))
    {
      this.FYQ = true;
      scrollTo(0, this.FYK);
    }
    AppMethodBeat.o(142088);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142087);
    if (!this.FYZ)
    {
      bPG();
      this.FYZ = true;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(142087);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142098);
    if (paramFloat2 > 0.0F)
    {
      this.lVe = true;
      if (Math.abs(paramFloat2) <= Math.abs(paramFloat1)) {
        break label141;
      }
    }
    label141:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.FZa != null)) {
        this.FZa.bv(paramFloat2);
      }
      if ((!this.FYN) || ((!this.lVe) && (getScrollY() - this.FYK <= 0)) || (i == 0)) {
        break label324;
      }
      if ((this.FZb) || ((this.FJA.getVisibility() == 0) && ((!this.lVe) || (getScrollY() < this.FYK * 2)))) {
        break label147;
      }
      AppMethodBeat.o(142098);
      return true;
      this.lVe = false;
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
      ad.v("check", "moveUp:" + i + " distanceY:" + paramFloat2 + " scrollY:" + getScrollY());
      if ((getScrollY() + i >= this.FYK) || (this.lVe)) {
        break label277;
      }
      j = this.FYK - getScrollY();
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
      if (!this.FZb)
      {
        j = i;
        if (getScrollY() + i >= this.FYK * 2) {
          j = this.FYK * 2 - getScrollY();
        }
      }
    }
    label324:
    if ((this.FYM) && ((!this.lVe) || (getScrollY() - this.FYK < 0)) && (i != 0))
    {
      if ((!this.FZb) && ((this.FYV.getVisibility() != 0) || ((!this.lVe) && (getScrollY() <= 0))))
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
        if (getScrollY() + i <= this.FYK) {
          break label469;
        }
        j = this.FYK - getScrollY();
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
        if (!this.FZb)
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
    if (this.FZn != null) {
      this.FZn.caF();
    }
    if (!this.FZl)
    {
      AppMethodBeat.o(142099);
      return;
    }
    if (this.FZm == -2147483648)
    {
      this.FZm = this.FYK;
      ad.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.FZm);
    }
    if ((paramInt2 <= this.FZm) && (this.FZg != FZk))
    {
      setBackgroundResource(2131233299);
      this.FZg = FZk;
      ad.d("MicroMsg.MMPullDownView", "onScrollChanged full");
      AppMethodBeat.o(142099);
      return;
    }
    if ((paramInt2 > this.FZm) && (this.FZg != this.bgColor))
    {
      ad.d("MicroMsg.MMPullDownView", "onScrollChanged white");
      setBackgroundColor(this.bgColor);
      this.FZg = this.bgColor;
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
      if (getScrollY() - this.FYK < 0) {
        this.FYM = true;
      }
      if (getScrollY() > this.FYL) {
        this.FYN = true;
      }
      eSS();
    }
  }
  
  public void setAtBottomCallBack(c paramc)
  {
    this.FYT = paramc;
  }
  
  public void setAtTopCallBack(d paramd)
  {
    this.FYU = paramd;
  }
  
  public void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
    this.FZg = this.bgColor;
  }
  
  public void setBottomView(View paramView)
  {
    AppMethodBeat.i(142082);
    if (paramView == null)
    {
      this.FYX = 4;
      if (this.FJA != null)
      {
        this.FJA.setVisibility(4);
        AppMethodBeat.o(142082);
      }
    }
    else
    {
      this.FJA = paramView;
      this.FJA.setVisibility(0);
      this.FYX = 0;
      removeViewAt(getChildCount() - 1);
      addView(this.FJA, new FrameLayout.LayoutParams(-1, -2));
      this.FYL = 0;
    }
    AppMethodBeat.o(142082);
  }
  
  public void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142083);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.FYX = i;
      if (this.FJA != null) {
        this.FJA.setVisibility(this.FYX);
      }
      ad.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bt.eGN() });
      AppMethodBeat.o(142083);
      return;
    }
  }
  
  public void setCanOverScrool(boolean paramBoolean)
  {
    this.FZb = paramBoolean;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.FZc = paramBoolean;
  }
  
  public void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142080);
    ad.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.FYS), bt.eGN() });
    this.FYS = paramBoolean;
    AppMethodBeat.o(142080);
  }
  
  public void setIsReturnSuperDispatchWhenCancel(boolean paramBoolean)
  {
    this.FZe = paramBoolean;
  }
  
  public void setIsTopShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142079);
    ad.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.FYR), bt.eGN() });
    this.FYR = paramBoolean;
    AppMethodBeat.o(142079);
  }
  
  public void setOnBottomLoadDataListener(e parame)
  {
    this.FYJ = parame;
  }
  
  public void setOnInterceptTouchEventListener(a parama)
  {
    this.FZf = parama;
  }
  
  public void setOnMMFlingListener(k.a parama)
  {
    this.FZd.HrC = parama;
  }
  
  public void setOnScrollChangedListener(b paramb)
  {
    this.FZn = paramb;
  }
  
  public void setOnSrcollDistance(f paramf)
  {
    this.FZa = paramf;
  }
  
  public void setOnTopLoadDataListener(g paramg)
  {
    this.FYI = paramg;
  }
  
  public void setShowBackground(boolean paramBoolean)
  {
    this.FZl = paramBoolean;
  }
  
  public void setTopView(View paramView)
  {
    AppMethodBeat.i(142081);
    if (paramView == null)
    {
      this.FYY = 4;
      if (this.FYV != null)
      {
        this.FYV.setVisibility(4);
        AppMethodBeat.o(142081);
      }
    }
    else
    {
      removeViewAt(0);
      this.FYV = paramView;
      this.FYV.setVisibility(0);
      this.FYY = 0;
      addView(this.FYV, 0, new FrameLayout.LayoutParams(-1, -2));
      this.FYK = 0;
    }
    AppMethodBeat.o(142081);
  }
  
  public void setTopViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142084);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.FYY = i;
      if (this.FYV != null) {
        this.FYV.setVisibility(this.FYY);
      }
      ad.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(142084);
      return;
    }
  }
  
  public void vL(boolean paramBoolean)
  {
    AppMethodBeat.i(142093);
    ad.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.FYO), Boolean.valueOf(this.FYP), Boolean.valueOf(this.FYR), Integer.valueOf(getScrollY()) });
    Scroller localScroller;
    int i;
    int j;
    if (paramBoolean)
    {
      if (this.FYV != null) {
        this.FYV.setVisibility(this.FYY);
      }
      if (this.FYR)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.FYK + j, 200);
        postInvalidate();
      }
    }
    for (;;)
    {
      if (!this.FYR) {
        eSR();
      }
      AppMethodBeat.o(142093);
      return;
      if ((this.FYV != null) && (this.FYV.getVisibility() == 4))
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.FYK + j, 200);
      }
      if ((this.FYV != null) && (this.FYV.getVisibility() == 0)) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.FYW = 0;
      this.FYO = true;
      this.FYP = false;
      break;
      if (!this.FYP)
      {
        this.FYP = true;
        this.FYO = false;
        if ((this.FYV != null) && (this.FYV.getVisibility() == 0)) {
          scrollTo(0, this.FYK);
        }
      }
      if ((this.FYV != null) && (this.FYV.getVisibility() == 0)) {
        this.FYV.setVisibility(8);
      }
    }
  }
  
  public final void vM(boolean paramBoolean)
  {
    AppMethodBeat.i(142094);
    ad.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.FYO), Boolean.valueOf(this.FYP), Boolean.valueOf(this.FYS), Integer.valueOf(getScrollY()) });
    if (paramBoolean)
    {
      if (this.FJA != null) {
        this.FJA.setVisibility(this.FYY);
      }
      if (this.FYS) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.FYL - getScrollY(), 200);
      }
      for (;;)
      {
        postInvalidate();
        AppMethodBeat.o(142094);
        return;
        if ((this.FJA != null) && (this.FJA.getVisibility() == 4)) {
          this.mScroller.startScroll(0, getScrollY(), 0, this.FYL - getScrollY(), 200);
        }
        if ((this.FJA != null) && (this.FJA.getVisibility() == 0))
        {
          Scroller localScroller = this.mScroller;
          int i = getScrollY();
          int j = this.FYL;
          int k = getScrollY();
          localScroller.startScroll(0, i, 0, this.FYL + (j - k), 200);
        }
        this.FYW = 1;
        this.FYO = true;
        this.FYP = false;
      }
    }
    if (!this.FYP)
    {
      this.FYP = true;
      this.FYO = false;
    }
    if ((this.FJA != null) && (this.FJA.getVisibility() == 0))
    {
      ad.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
      scrollTo(0, this.FYK);
    }
    if ((this.FJA != null) && (this.FJA.getVisibility() == 0)) {
      this.FJA.setVisibility(8);
    }
    AppMethodBeat.o(142094);
  }
  
  public static abstract interface a
  {
    public abstract boolean onInterceptTouchEvent(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface b
  {
    public abstract void caF();
  }
  
  public static abstract interface c
  {
    public abstract boolean bPj();
  }
  
  public static abstract interface d
  {
    public abstract boolean bPi();
  }
  
  public static abstract interface e
  {
    public abstract boolean bPh();
  }
  
  public static abstract interface f
  {
    public abstract void bv(float paramFloat);
    
    public abstract void dCt();
  }
  
  public static abstract interface g
  {
    public abstract boolean bPk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPullDownView
 * JD-Core Version:    0.7.0.1
 */