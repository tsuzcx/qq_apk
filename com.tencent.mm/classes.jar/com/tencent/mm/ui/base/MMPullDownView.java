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
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.tools.i.a;

public class MMPullDownView
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  private static int uXo = 400;
  private static final int uXr = Color.parseColor("#00000000");
  private Scroller GB;
  private int bgColor = Color.parseColor("#ffffffff");
  public Context context;
  private GestureDetector jEK;
  public View uIY;
  private int uTT;
  private int uUL = 1;
  private MMPullDownView.g uWQ;
  private MMPullDownView.e uWR;
  private int uWS;
  private int uWT;
  private boolean uWU = false;
  private boolean uWV = false;
  private boolean uWW = false;
  private boolean uWX = false;
  public boolean uWY = true;
  private boolean uWZ = false;
  private boolean uXa = true;
  private boolean uXb = true;
  private MMPullDownView.c uXc;
  private MMPullDownView.d uXd;
  public View uXe;
  private int uXf;
  private int uXg = 4;
  private int uXh = 4;
  private boolean uXi = false;
  private MMPullDownView.f uXj;
  private boolean uXk = true;
  private i uXl;
  private boolean uXm = false;
  private MMPullDownView.a uXn;
  private ah uXp = new ah()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (MMPullDownView.a(MMPullDownView.this))
      {
      }
      for (;;)
      {
        y.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", new Object[] { Integer.valueOf(MMPullDownView.a(MMPullDownView.this)), Boolean.valueOf(MMPullDownView.this.uWY) });
        return;
        if (MMPullDownView.b(MMPullDownView.this) != null) {
          MMPullDownView.this.uWY = MMPullDownView.b(MMPullDownView.this).aEX();
        }
        if ((MMPullDownView.this.uWY) && (MMPullDownView.c(MMPullDownView.this).getVisibility() == 0))
        {
          MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
          continue;
          if (MMPullDownView.e(MMPullDownView.this) != null) {
            MMPullDownView.this.uWY = MMPullDownView.e(MMPullDownView.this).aEU();
          }
          if ((MMPullDownView.this.uWY) && (MMPullDownView.f(MMPullDownView.this).getVisibility() == 0)) {
            MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
          }
        }
      }
    }
  };
  boolean uXq = false;
  private boolean uXs = false;
  private int uXt = -2147483648;
  private int uXu = this.bgColor;
  private MMPullDownView.b uXv;
  
  public MMPullDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMPullDownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.GB = new Scroller(paramContext, new AccelerateInterpolator());
    this.uTT = this.uUL;
    this.jEK = new GestureDetector(paramContext, this);
    this.uXl = new i(paramContext);
    this.context = paramContext;
  }
  
  private void cAS()
  {
    e((ViewGroup)this.uXe, 0);
    e((ViewGroup)this.uIY, 0);
  }
  
  private void cAT()
  {
    if (this.uXj != null) {
      this.uXj.bJK();
    }
    Scroller localScroller;
    int i;
    int j;
    if (getScrollY() - this.uWS < 0)
    {
      if (this.uXa)
      {
        localScroller = this.GB;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.uWS + j, 200);
        postInvalidate();
      }
    }
    else if (getScrollY() > this.uWT)
    {
      if (!this.uXb) {
        break label220;
      }
      this.GB.startScroll(0, getScrollY(), 0, this.uWT - getScrollY(), 200);
    }
    for (;;)
    {
      postInvalidate();
      this.uWW = false;
      return;
      if (this.uXe.getVisibility() == 4)
      {
        localScroller = this.GB;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.uWS + j, 200);
      }
      if (this.uXe.getVisibility() == 0) {
        this.GB.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.uXf = 0;
      this.uWX = true;
      this.uWY = false;
      break;
      label220:
      if (this.uIY.getVisibility() == 4) {
        this.GB.startScroll(0, getScrollY(), 0, this.uWT - getScrollY(), 200);
      }
      if (this.uIY.getVisibility() == 0)
      {
        localScroller = this.GB;
        i = getScrollY();
        j = this.uWT;
        int k = getScrollY();
        localScroller.startScroll(0, i, 0, this.uWT + (j - k), 200);
      }
      this.uXf = 1;
      this.uWX = true;
      this.uWY = false;
    }
  }
  
  public static void e(ViewGroup paramViewGroup, int paramInt)
  {
    y.i("MicroMsg.MMPullDownView", "fix android O progress bar bug.");
    if ((paramViewGroup != null) && (paramViewGroup.getVisibility() == 0))
    {
      if (paramViewGroup.getTag() == null) {
        paramViewGroup.setTag(paramViewGroup.findViewById(a.g.chatting_load_progress));
      }
      paramViewGroup = (View)paramViewGroup.getTag();
      if (paramViewGroup != null) {
        paramViewGroup.setVisibility(paramInt);
      }
    }
  }
  
  public void aFp()
  {
    View localView1 = inflate(this.context, a.h.loading_view, null);
    View localView2 = inflate(this.context, a.h.loading_view, null);
    addView(localView1, 0, new FrameLayout.LayoutParams(-1, -2));
    addView(localView2, new FrameLayout.LayoutParams(-1, -2));
  }
  
  public void computeScroll()
  {
    if (this.GB.computeScrollOffset())
    {
      scrollTo(this.GB.getCurrX(), this.GB.getCurrY());
      postInvalidate();
    }
    for (;;)
    {
      this.GB.isFinished();
      return;
      if (this.uWX)
      {
        y.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
        this.uWX = false;
        this.uXp.sendEmptyMessageDelayed(0, uXo);
        cAS();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    i locali = this.uXl;
    if (locali.wcW != null) {
      locali.apX.onTouchEvent(paramMotionEvent);
    }
    if (!this.uWY) {
      return true;
    }
    if (this.uXd == null)
    {
      this.uWU = false;
      if (this.uXc != null) {
        break label132;
      }
      this.uWV = false;
      label54:
      if (this.uXh == 0)
      {
        if (!this.uXa) {
          break label148;
        }
        this.uXe.setVisibility(4);
      }
      label76:
      if (this.uXg == 0)
      {
        if (!this.uXb) {
          break label159;
        }
        this.uIY.setVisibility(4);
      }
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() != 1) {
        break label170;
      }
      cAT();
      return super.dispatchTouchEvent(paramMotionEvent);
      this.uWU = this.uXd.aEV();
      break;
      label132:
      this.uWV = this.uXc.aEW();
      break label54;
      label148:
      this.uXe.setVisibility(0);
      break label76;
      label159:
      this.uIY.setVisibility(0);
    }
    label170:
    if (paramMotionEvent.getAction() == 3)
    {
      cAT();
      if (this.uXm) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      return false;
    }
    if (this.jEK.onTouchEvent(paramMotionEvent))
    {
      paramMotionEvent.setAction(3);
      this.uXq = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      y.printErrStackTrace("MicroMsg.MMPullDownView", paramMotionEvent, "", new Object[0]);
    }
    return true;
  }
  
  public int getBottomHeight()
  {
    return this.uWT;
  }
  
  public int getCurScreen()
  {
    return this.uTT;
  }
  
  public int getTopHeight()
  {
    return this.uWS;
  }
  
  public void na(boolean paramBoolean)
  {
    y.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.uWX), Boolean.valueOf(this.uWY), Boolean.valueOf(this.uXa), Integer.valueOf(getScrollY()), bk.csb() });
    Scroller localScroller;
    int i;
    int j;
    if (paramBoolean) {
      if (this.uXa)
      {
        localScroller = this.GB;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.uWS + j, 200);
        postInvalidate();
      }
    }
    for (;;)
    {
      cAS();
      return;
      if ((this.uXe != null) && (this.uXe.getVisibility() == 4))
      {
        localScroller = this.GB;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.uWS + j, 200);
      }
      if ((this.uXe != null) && (this.uXe.getVisibility() == 0)) {
        this.GB.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.uXf = 0;
      this.uWX = true;
      this.uWY = false;
      break;
      if (!this.uWY)
      {
        this.uWY = true;
        this.uWX = false;
        if ((this.uXe != null) && (this.uXe.getVisibility() == 0)) {
          scrollTo(0, this.uWS);
        }
      }
    }
  }
  
  public final void nb(boolean paramBoolean)
  {
    y.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.uWX), Boolean.valueOf(this.uWY), Boolean.valueOf(this.uXb), Integer.valueOf(getScrollY()), bk.csb() });
    if (paramBoolean) {
      if (this.uXb)
      {
        this.GB.startScroll(0, getScrollY(), 0, this.uWT - getScrollY(), 200);
        postInvalidate();
      }
    }
    do
    {
      return;
      if ((this.uIY != null) && (this.uIY.getVisibility() == 4)) {
        this.GB.startScroll(0, getScrollY(), 0, this.uWT - getScrollY(), 200);
      }
      if ((this.uIY != null) && (this.uIY.getVisibility() == 0))
      {
        Scroller localScroller = this.GB;
        int i = getScrollY();
        int j = this.uWT;
        int k = getScrollY();
        localScroller.startScroll(0, i, 0, this.uWT + (j - k), 200);
      }
      this.uXf = 1;
      this.uWX = true;
      this.uWY = false;
      break;
      if (!this.uWY)
      {
        this.uWY = true;
        this.uWX = false;
      }
    } while ((this.uIY == null) || (this.uIY.getVisibility() != 0));
    y.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
    scrollTo(0, this.uWS);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (!this.GB.isFinished()) {
      this.GB.abortAnimation();
    }
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    y.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.uXn != null) {
      this.uXn.onInterceptTouchEvent(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
            y.printErrStackTrace("MicroMsg.MMPullDownView", localArrayIndexOutOfBoundsException, "childCount: %d, i:%d, childHeight:%d", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(i) });
          }
        }
      }
    }
    this.uXe = getChildAt(0);
    this.uIY = getChildAt(getChildCount() - 1);
    this.uXe.setVisibility(this.uXh);
    this.uIY.setVisibility(this.uXg);
    this.uWS = this.uXe.getHeight();
    this.uWT = this.uIY.getHeight();
    this.uXt = this.uWS;
    if ((!this.uWZ) && (this.uWS != 0))
    {
      this.uWZ = true;
      scrollTo(0, this.uWS);
    }
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.uXi)
    {
      aFp();
      this.uXi = true;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    int i = -1;
    if (this.uXj != null) {
      this.uXj.aF(paramFloat2);
    }
    if (paramFloat2 > 0.0F) {
      this.uWW = true;
    }
    int j;
    for (;;)
    {
      if ((this.uWV) && ((this.uWW) || (getScrollY() - this.uWS > 0))) {
        if ((!this.uXk) && ((this.uIY.getVisibility() != 0) || ((this.uWW) && (getScrollY() >= this.uWS * 2))))
        {
          return true;
          this.uWW = false;
        }
        else
        {
          j = (int)(paramFloat2 * 0.5D);
          if (j != 0) {
            break label427;
          }
          if (paramFloat2 <= 0.0F) {
            break;
          }
        }
      }
    }
    label420:
    label427:
    for (i = 1;; i = j)
    {
      y.v("check", "moveUp:" + i + " distanceY:" + paramFloat2 + " scrollY:" + getScrollY());
      if ((getScrollY() + i < this.uWS) && (!this.uWW)) {
        j = this.uWS - getScrollY();
      }
      for (;;)
      {
        scrollBy(0, j);
        return true;
        j = i;
        if (!this.uXk)
        {
          j = i;
          if (getScrollY() + i >= this.uWS * 2) {
            j = this.uWS * 2 - getScrollY();
          }
        }
      }
      if ((this.uWU) && ((!this.uWW) || (getScrollY() - this.uWS < 0)))
      {
        if ((!this.uXk) && ((this.uXe.getVisibility() != 0) || ((!this.uWW) && (getScrollY() <= 0)))) {
          break;
        }
        j = (int)(paramFloat2 * 0.5D);
        if (j != 0) {
          break label420;
        }
        if (paramFloat2 <= 0.0F) {}
      }
      for (i = 1;; i = j)
      {
        if (getScrollY() + i > this.uWS) {
          j = this.uWS - getScrollY();
        }
        for (;;)
        {
          scrollBy(0, j);
          return true;
          j = i;
          if (!this.uXk)
          {
            j = i;
            if (getScrollY() + i < 0) {
              j = -getScrollY();
            }
          }
        }
        return false;
      }
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.uXv != null) {
      this.uXv.aMI();
    }
    if (!this.uXs) {}
    do
    {
      return;
      if (this.uXt == -2147483648)
      {
        this.uXt = this.uWS;
        y.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.uXt);
      }
      if ((paramInt2 <= this.uXt) && (this.uXu != uXr))
      {
        setBackgroundResource(a.f.mm_trans);
        this.uXu = uXr;
        y.d("MicroMsg.MMPullDownView", "onScrollChanged full");
        return;
      }
    } while ((paramInt2 <= this.uXt) || (this.uXu == this.bgColor));
    y.d("MicroMsg.MMPullDownView", "onScrollChanged white");
    setBackgroundColor(this.bgColor);
    this.uXu = this.bgColor;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    }
    if (getScrollY() - this.uWS < 0) {
      this.uWU = true;
    }
    if (getScrollY() > this.uWT) {
      this.uWV = true;
    }
    cAT();
    return true;
  }
  
  public void setAtBottomCallBack(MMPullDownView.c paramc)
  {
    this.uXc = paramc;
  }
  
  public void setAtTopCallBack(MMPullDownView.d paramd)
  {
    this.uXd = paramd;
  }
  
  public void setBgColor(String paramString)
  {
    this.bgColor = Color.parseColor(paramString);
    this.uXu = this.bgColor;
  }
  
  public void setBottomView(View paramView)
  {
    if (paramView == null)
    {
      this.uXg = 4;
      if (this.uIY != null) {
        this.uIY.setVisibility(4);
      }
      return;
    }
    this.uIY = paramView;
    this.uIY.setVisibility(0);
    this.uXg = 0;
    removeViewAt(getChildCount() - 1);
    addView(this.uIY, new FrameLayout.LayoutParams(-1, -2));
    this.uWT = 0;
  }
  
  public void setBottomViewVisible(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.uXg = i;
      if (this.uIY != null) {
        this.uIY.setVisibility(this.uXg);
      }
      y.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bk.csb() });
      return;
    }
  }
  
  public void setCanOverScrool(boolean paramBoolean)
  {
    this.uXk = paramBoolean;
  }
  
  public void setIsBottomShowAll(boolean paramBoolean)
  {
    y.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.uXb), bk.csb() });
    this.uXb = paramBoolean;
  }
  
  public void setIsReturnSuperDispatchWhenCancel(boolean paramBoolean)
  {
    this.uXm = paramBoolean;
  }
  
  public void setIsTopShowAll(boolean paramBoolean)
  {
    y.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.uXa), bk.csb() });
    this.uXa = paramBoolean;
  }
  
  public void setOnBottomLoadDataListener(MMPullDownView.e parame)
  {
    this.uWR = parame;
  }
  
  public void setOnInterceptTouchEventListener(MMPullDownView.a parama)
  {
    this.uXn = parama;
  }
  
  public void setOnMMFlingListener(i.a parama)
  {
    this.uXl.wcW = parama;
  }
  
  public void setOnScrollChangedListener(MMPullDownView.b paramb)
  {
    this.uXv = paramb;
  }
  
  public void setOnSrcollDistance(MMPullDownView.f paramf)
  {
    this.uXj = paramf;
  }
  
  public void setOnTopLoadDataListener(MMPullDownView.g paramg)
  {
    this.uWQ = paramg;
  }
  
  public void setShowBackground(boolean paramBoolean)
  {
    this.uXs = paramBoolean;
  }
  
  public void setTopView(View paramView)
  {
    if (paramView == null)
    {
      this.uXh = 4;
      if (this.uXe != null) {
        this.uXe.setVisibility(4);
      }
      return;
    }
    removeViewAt(0);
    this.uXe = paramView;
    this.uXe.setVisibility(0);
    this.uXh = 0;
    addView(this.uXe, 0, new FrameLayout.LayoutParams(-1, -2));
    this.uWS = 0;
  }
  
  public void setTopViewVisible(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.uXh = i;
      if (this.uXe != null) {
        this.uXe.setVisibility(this.uXh);
      }
      y.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bk.csb() });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPullDownView
 * JD-Core Version:    0.7.0.1
 */