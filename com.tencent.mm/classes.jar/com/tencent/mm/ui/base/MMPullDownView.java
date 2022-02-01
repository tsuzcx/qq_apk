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
import com.tencent.mm.hellhoundlib.b.b;
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
  private static int JmN;
  private static final int JmQ;
  public View BKV;
  private int JjC;
  private int Jko;
  private d JmA;
  public View JmB;
  private int JmC;
  private int JmD;
  private int JmE;
  private boolean JmF;
  private f JmG;
  private boolean JmH;
  private boolean JmI;
  private k JmJ;
  private boolean JmK;
  private a JmL;
  private int JmM;
  private ap JmO;
  boolean JmP;
  private boolean JmR;
  private int JmS;
  private b JmT;
  private g Jmo;
  private e Jmp;
  private int Jmq;
  private int Jmr;
  private boolean Jms;
  private boolean Jmt;
  private boolean Jmu;
  protected boolean Jmv;
  private boolean Jmw;
  private boolean Jmx;
  private boolean Jmy;
  private c Jmz;
  private int bgColor;
  protected Context context;
  private GestureDetector iKD;
  private Scroller mScroller;
  private boolean mXK;
  
  static
  {
    AppMethodBeat.i(142100);
    JmN = 400;
    JmQ = Color.parseColor("#00000000");
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
    this.Jko = 1;
    this.Jms = false;
    this.Jmt = false;
    this.mXK = false;
    this.Jmu = false;
    this.Jmv = true;
    this.Jmw = false;
    this.Jmx = true;
    this.Jmy = true;
    this.JmD = 4;
    this.JmE = 4;
    this.JmF = false;
    this.JmH = true;
    this.JmI = true;
    this.JmK = false;
    this.bgColor = aj.getContext().getResources().getColor(2131101179);
    this.JmM = this.bgColor;
    this.JmO = new ap()
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
          ad.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", new Object[] { Integer.valueOf(MMPullDownView.a(MMPullDownView.this)), Boolean.valueOf(MMPullDownView.this.Jmv) });
          AppMethodBeat.o(142076);
          return;
          if (MMPullDownView.b(MMPullDownView.this) != null) {
            MMPullDownView.this.Jmv = MMPullDownView.b(MMPullDownView.this).cbd();
          }
          if ((MMPullDownView.this.Jmv) && (MMPullDownView.c(MMPullDownView.this).getVisibility() == 0))
          {
            MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            continue;
            if (MMPullDownView.e(MMPullDownView.this) != null) {
              MMPullDownView.this.Jmv = MMPullDownView.e(MMPullDownView.this).cba();
            }
            if ((MMPullDownView.this.Jmv) && (MMPullDownView.f(MMPullDownView.this).getVisibility() == 0)) {
              MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            }
          }
        }
      }
    };
    this.JmP = false;
    this.JmR = false;
    this.JmS = -2147483648;
    this.mScroller = new Scroller(paramContext, new AccelerateInterpolator());
    this.JjC = this.Jko;
    this.iKD = new GestureDetector(paramContext, this);
    this.JmJ = new k(paramContext);
    this.context = paramContext;
    this.bgColor = paramContext.getResources().getColor(2131101179);
    this.JmM = this.bgColor;
    AppMethodBeat.o(142077);
  }
  
  private void fyQ()
  {
    AppMethodBeat.i(142086);
    o((ViewGroup)this.JmB, 0);
    o((ViewGroup)this.BKV, 0);
    AppMethodBeat.o(142086);
  }
  
  private void fyR()
  {
    AppMethodBeat.i(142095);
    if (this.JmG != null) {
      this.JmG.edi();
    }
    Scroller localScroller;
    int i;
    int j;
    if (getScrollY() - this.Jmq < 0)
    {
      if (this.Jmx)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.Jmq + j, 200);
        postInvalidate();
      }
    }
    else if (getScrollY() > this.Jmr)
    {
      if (!this.Jmy) {
        break label230;
      }
      this.mScroller.startScroll(0, getScrollY(), 0, this.Jmr - getScrollY(), 200);
    }
    for (;;)
    {
      postInvalidate();
      this.mXK = false;
      AppMethodBeat.o(142095);
      return;
      if (this.JmB.getVisibility() == 4)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.Jmq + j, 200);
      }
      if (this.JmB.getVisibility() == 0) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.JmC = 0;
      this.Jmu = true;
      this.Jmv = false;
      break;
      label230:
      if (this.BKV.getVisibility() == 4) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.Jmr - getScrollY(), 200);
      }
      if (this.BKV.getVisibility() == 0)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = this.Jmr;
        int k = getScrollY();
        localScroller.startScroll(0, i, 0, this.Jmr + (j - k), 200);
      }
      this.JmC = 1;
      this.Jmu = true;
      this.Jmv = false;
    }
  }
  
  public static void o(ViewGroup paramViewGroup, int paramInt)
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
  
  protected void cbz()
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
      if (this.Jmu)
      {
        ad.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
        this.Jmu = false;
        this.JmO.sendEmptyMessageDelayed(0, JmN);
        fyQ();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142092);
    boolean bool;
    if (!this.JmI)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
    }
    Object localObject = this.JmJ;
    if (((k)localObject).KJd != null)
    {
      localObject = ((k)localObject).aYl;
      locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/ui/tools/MMGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/ui/tools/MMGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    if (!this.Jmv)
    {
      AppMethodBeat.o(142092);
      return true;
    }
    if (this.JmA == null)
    {
      this.Jms = false;
      if (this.Jmz != null) {
        break label245;
      }
      this.Jmt = false;
      label159:
      if (this.JmE == 0)
      {
        if (!this.Jmx) {
          break label261;
        }
        this.JmB.setVisibility(4);
      }
      label181:
      if (this.JmD == 0)
      {
        if (!this.Jmy) {
          break label272;
        }
        this.BKV.setVisibility(4);
      }
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() != 1) {
        break label283;
      }
      fyR();
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
      this.Jms = this.JmA.cbb();
      break;
      label245:
      this.Jmt = this.Jmz.cbc();
      break label159;
      label261:
      this.JmB.setVisibility(0);
      break label181;
      label272:
      this.BKV.setVisibility(0);
    }
    label283:
    if (paramMotionEvent.getAction() == 3)
    {
      fyR();
      if (this.JmK)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(142092);
        return bool;
      }
      AppMethodBeat.o(142092);
      return false;
    }
    localObject = this.iKD;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/ui/base/MMPullDownView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/ui/base/MMPullDownView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z"))
    {
      paramMotionEvent.setAction(3);
      this.JmP = true;
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
    return this.Jmr;
  }
  
  public int getCurScreen()
  {
    return this.JjC;
  }
  
  public int getTopHeight()
  {
    return this.Jmq;
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
    if (this.JmL != null) {
      this.JmL.onInterceptTouchEvent(paramMotionEvent);
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
    this.JmB = getChildAt(0);
    this.BKV = getChildAt(getChildCount() - 1);
    this.JmB.setVisibility(this.JmE);
    this.BKV.setVisibility(this.JmD);
    this.Jmq = this.JmB.getHeight();
    this.Jmr = this.BKV.getHeight();
    this.JmS = this.Jmq;
    if ((!this.Jmw) && (this.Jmq != 0))
    {
      this.Jmw = true;
      scrollTo(0, this.Jmq);
    }
    AppMethodBeat.o(142088);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186470);
    b localb = new b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(186470);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142087);
    if (!this.JmF)
    {
      cbz();
      this.JmF = true;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(142087);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142098);
    if (paramFloat2 > 0.0F)
    {
      this.mXK = true;
      if (Math.abs(paramFloat2) <= Math.abs(paramFloat1)) {
        break label141;
      }
    }
    label141:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.JmG != null)) {
        this.JmG.bG(paramFloat2);
      }
      if ((!this.Jmt) || ((!this.mXK) && (getScrollY() - this.Jmq <= 0)) || (i == 0)) {
        break label324;
      }
      if ((this.JmH) || ((this.BKV.getVisibility() == 0) && ((!this.mXK) || (getScrollY() < this.Jmq * 2)))) {
        break label147;
      }
      AppMethodBeat.o(142098);
      return true;
      this.mXK = false;
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
      if ((getScrollY() + i >= this.Jmq) || (this.mXK)) {
        break label277;
      }
      j = this.Jmq - getScrollY();
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
      if (!this.JmH)
      {
        j = i;
        if (getScrollY() + i >= this.Jmq * 2) {
          j = this.Jmq * 2 - getScrollY();
        }
      }
    }
    label324:
    if ((this.Jms) && ((!this.mXK) || (getScrollY() - this.Jmq < 0)) && (i != 0))
    {
      if ((!this.JmH) && ((this.JmB.getVisibility() != 0) || ((!this.mXK) && (getScrollY() <= 0))))
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
        if (getScrollY() + i <= this.Jmq) {
          break label469;
        }
        j = this.Jmq - getScrollY();
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
        if (!this.JmH)
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
    if (this.JmT != null) {
      this.JmT.cms();
    }
    if (!this.JmR)
    {
      AppMethodBeat.o(142099);
      return;
    }
    if (this.JmS == -2147483648)
    {
      this.JmS = this.Jmq;
      ad.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.JmS);
    }
    if ((paramInt2 <= this.JmS) && (this.JmM != JmQ))
    {
      setBackgroundResource(2131233299);
      this.JmM = JmQ;
      ad.d("MicroMsg.MMPullDownView", "onScrollChanged full");
      AppMethodBeat.o(142099);
      return;
    }
    if ((paramInt2 > this.JmS) && (this.JmM != this.bgColor))
    {
      ad.d("MicroMsg.MMPullDownView", "onScrollChanged white");
      setBackgroundColor(this.bgColor);
      this.JmM = this.bgColor;
    }
    AppMethodBeat.o(142099);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(186471);
    b localb = new b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(186471);
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
      if (getScrollY() - this.Jmq < 0) {
        this.Jms = true;
      }
      if (getScrollY() > this.Jmr) {
        this.Jmt = true;
      }
      fyR();
    }
  }
  
  public void setAtBottomCallBack(c paramc)
  {
    this.Jmz = paramc;
  }
  
  public void setAtTopCallBack(d paramd)
  {
    this.JmA = paramd;
  }
  
  public void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
    this.JmM = this.bgColor;
  }
  
  public void setBottomView(View paramView)
  {
    AppMethodBeat.i(142082);
    if (paramView == null)
    {
      this.JmD = 4;
      if (this.BKV != null)
      {
        this.BKV.setVisibility(4);
        AppMethodBeat.o(142082);
      }
    }
    else
    {
      this.BKV = paramView;
      this.BKV.setVisibility(0);
      this.JmD = 0;
      removeViewAt(getChildCount() - 1);
      addView(this.BKV, new FrameLayout.LayoutParams(-1, -2));
      this.Jmr = 0;
    }
    AppMethodBeat.o(142082);
  }
  
  public void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142083);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.JmD = i;
      if (this.BKV != null) {
        this.BKV.setVisibility(this.JmD);
      }
      ad.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bt.flS() });
      AppMethodBeat.o(142083);
      return;
    }
  }
  
  public void setCanOverScrool(boolean paramBoolean)
  {
    this.JmH = paramBoolean;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.JmI = paramBoolean;
  }
  
  public void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142080);
    ad.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Jmy), bt.flS() });
    this.Jmy = paramBoolean;
    AppMethodBeat.o(142080);
  }
  
  public void setIsReturnSuperDispatchWhenCancel(boolean paramBoolean)
  {
    this.JmK = paramBoolean;
  }
  
  public void setIsTopShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142079);
    ad.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Jmx), bt.flS() });
    this.Jmx = paramBoolean;
    AppMethodBeat.o(142079);
  }
  
  public void setOnBottomLoadDataListener(e parame)
  {
    this.Jmp = parame;
  }
  
  public void setOnInterceptTouchEventListener(a parama)
  {
    this.JmL = parama;
  }
  
  public void setOnMMFlingListener(k.a parama)
  {
    this.JmJ.KJd = parama;
  }
  
  public void setOnScrollChangedListener(b paramb)
  {
    this.JmT = paramb;
  }
  
  public void setOnSrcollDistance(f paramf)
  {
    this.JmG = paramf;
  }
  
  public void setOnTopLoadDataListener(g paramg)
  {
    this.Jmo = paramg;
  }
  
  public void setShowBackground(boolean paramBoolean)
  {
    this.JmR = paramBoolean;
  }
  
  public void setTopView(View paramView)
  {
    AppMethodBeat.i(142081);
    if (paramView == null)
    {
      this.JmE = 4;
      if (this.JmB != null)
      {
        this.JmB.setVisibility(4);
        AppMethodBeat.o(142081);
      }
    }
    else
    {
      removeViewAt(0);
      this.JmB = paramView;
      this.JmB.setVisibility(0);
      this.JmE = 0;
      addView(this.JmB, 0, new FrameLayout.LayoutParams(-1, -2));
      this.Jmq = 0;
    }
    AppMethodBeat.o(142081);
  }
  
  public void setTopViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142084);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.JmE = i;
      if (this.JmB != null) {
        this.JmB.setVisibility(this.JmE);
      }
      ad.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(142084);
      return;
    }
  }
  
  public void xA(boolean paramBoolean)
  {
    AppMethodBeat.i(142093);
    ad.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Jmu), Boolean.valueOf(this.Jmv), Boolean.valueOf(this.Jmx), Integer.valueOf(getScrollY()) });
    Scroller localScroller;
    int i;
    int j;
    if (paramBoolean)
    {
      if (this.JmB != null) {
        this.JmB.setVisibility(this.JmE);
      }
      if (this.Jmx)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.Jmq + j, 200);
        postInvalidate();
      }
    }
    for (;;)
    {
      if (!this.Jmx) {
        fyQ();
      }
      AppMethodBeat.o(142093);
      return;
      if ((this.JmB != null) && (this.JmB.getVisibility() == 4))
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.Jmq + j, 200);
      }
      if ((this.JmB != null) && (this.JmB.getVisibility() == 0)) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.JmC = 0;
      this.Jmu = true;
      this.Jmv = false;
      break;
      if (!this.Jmv)
      {
        this.Jmv = true;
        this.Jmu = false;
        if ((this.JmB != null) && (this.JmB.getVisibility() == 0)) {
          scrollTo(0, this.Jmq);
        }
      }
      if ((this.JmB != null) && (this.JmB.getVisibility() == 0)) {
        this.JmB.setVisibility(8);
      }
    }
  }
  
  public final void xB(boolean paramBoolean)
  {
    AppMethodBeat.i(142094);
    ad.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Jmu), Boolean.valueOf(this.Jmv), Boolean.valueOf(this.Jmy), Integer.valueOf(getScrollY()) });
    if (paramBoolean)
    {
      if (this.BKV != null) {
        this.BKV.setVisibility(this.JmE);
      }
      if (this.Jmy) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.Jmr - getScrollY(), 200);
      }
      for (;;)
      {
        postInvalidate();
        AppMethodBeat.o(142094);
        return;
        if ((this.BKV != null) && (this.BKV.getVisibility() == 4)) {
          this.mScroller.startScroll(0, getScrollY(), 0, this.Jmr - getScrollY(), 200);
        }
        if ((this.BKV != null) && (this.BKV.getVisibility() == 0))
        {
          Scroller localScroller = this.mScroller;
          int i = getScrollY();
          int j = this.Jmr;
          int k = getScrollY();
          localScroller.startScroll(0, i, 0, this.Jmr + (j - k), 200);
        }
        this.JmC = 1;
        this.Jmu = true;
        this.Jmv = false;
      }
    }
    if (!this.Jmv)
    {
      this.Jmv = true;
      this.Jmu = false;
    }
    if ((this.BKV != null) && (this.BKV.getVisibility() == 0))
    {
      ad.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
      scrollTo(0, this.Jmq);
    }
    if ((this.BKV != null) && (this.BKV.getVisibility() == 0)) {
      this.BKV.setVisibility(8);
    }
    AppMethodBeat.o(142094);
  }
  
  public static abstract interface a
  {
    public abstract boolean onInterceptTouchEvent(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface b
  {
    public abstract void cms();
  }
  
  public static abstract interface c
  {
    public abstract boolean cbc();
  }
  
  public static abstract interface d
  {
    public abstract boolean cbb();
  }
  
  public static abstract interface e
  {
    public abstract boolean cba();
  }
  
  public static abstract interface f
  {
    public abstract void bG(float paramFloat);
    
    public abstract void edi();
  }
  
  public static abstract interface g
  {
    public abstract boolean cbd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPullDownView
 * JD-Core Version:    0.7.0.1
 */