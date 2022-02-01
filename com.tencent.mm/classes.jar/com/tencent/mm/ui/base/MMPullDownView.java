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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.tools.k.a;

public class MMPullDownView
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  private static int JHC;
  private static final int JHF;
  public View Ccu;
  private int JEq;
  private int JFc;
  private a JHA;
  private int JHB;
  private aq JHD;
  boolean JHE;
  private boolean JHG;
  private int JHH;
  private b JHI;
  private g JHd;
  private e JHe;
  private int JHf;
  private int JHg;
  private boolean JHh;
  private boolean JHi;
  private boolean JHj;
  protected boolean JHk;
  private boolean JHl;
  private boolean JHm;
  private boolean JHn;
  private c JHo;
  private d JHp;
  public View JHq;
  private int JHr;
  private int JHs;
  private int JHt;
  private boolean JHu;
  private f JHv;
  private boolean JHw;
  private boolean JHx;
  private k JHy;
  private boolean JHz;
  private int bgColor;
  protected Context context;
  private GestureDetector iNw;
  private Scroller mScroller;
  private boolean ncR;
  
  static
  {
    AppMethodBeat.i(142100);
    JHC = 400;
    JHF = Color.parseColor("#00000000");
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
    this.JFc = 1;
    this.JHh = false;
    this.JHi = false;
    this.ncR = false;
    this.JHj = false;
    this.JHk = true;
    this.JHl = false;
    this.JHm = true;
    this.JHn = true;
    this.JHs = 4;
    this.JHt = 4;
    this.JHu = false;
    this.JHw = true;
    this.JHx = true;
    this.JHz = false;
    this.bgColor = ak.getContext().getResources().getColor(2131101179);
    this.JHB = this.bgColor;
    this.JHD = new aq()
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
          ae.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", new Object[] { Integer.valueOf(MMPullDownView.a(MMPullDownView.this)), Boolean.valueOf(MMPullDownView.this.JHk) });
          AppMethodBeat.o(142076);
          return;
          if (MMPullDownView.b(MMPullDownView.this) != null) {
            MMPullDownView.this.JHk = MMPullDownView.b(MMPullDownView.this).ccs();
          }
          if ((MMPullDownView.this.JHk) && (MMPullDownView.c(MMPullDownView.this).getVisibility() == 0))
          {
            MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            continue;
            if (MMPullDownView.e(MMPullDownView.this) != null) {
              MMPullDownView.this.JHk = MMPullDownView.e(MMPullDownView.this).ccp();
            }
            if ((MMPullDownView.this.JHk) && (MMPullDownView.f(MMPullDownView.this).getVisibility() == 0)) {
              MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            }
          }
        }
      }
    };
    this.JHE = false;
    this.JHG = false;
    this.JHH = -2147483648;
    this.mScroller = new Scroller(paramContext, new AccelerateInterpolator());
    this.JEq = this.JFc;
    this.iNw = new GestureDetector(paramContext, this);
    this.JHy = new k(paramContext);
    this.context = paramContext;
    this.bgColor = paramContext.getResources().getColor(2131101179);
    this.JHB = this.bgColor;
    AppMethodBeat.o(142077);
  }
  
  private void fCS()
  {
    AppMethodBeat.i(142086);
    o((ViewGroup)this.JHq, 0);
    o((ViewGroup)this.Ccu, 0);
    AppMethodBeat.o(142086);
  }
  
  private void fCT()
  {
    AppMethodBeat.i(142095);
    if (this.JHv != null) {
      this.JHv.egP();
    }
    Scroller localScroller;
    int i;
    int j;
    if (getScrollY() - this.JHf < 0)
    {
      if (this.JHm)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.JHf + j, 200);
        postInvalidate();
      }
    }
    else if (getScrollY() > this.JHg)
    {
      if (!this.JHn) {
        break label230;
      }
      this.mScroller.startScroll(0, getScrollY(), 0, this.JHg - getScrollY(), 200);
    }
    for (;;)
    {
      postInvalidate();
      this.ncR = false;
      AppMethodBeat.o(142095);
      return;
      if (this.JHq.getVisibility() == 4)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.JHf + j, 200);
      }
      if (this.JHq.getVisibility() == 0) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.JHr = 0;
      this.JHj = true;
      this.JHk = false;
      break;
      label230:
      if (this.Ccu.getVisibility() == 4) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.JHg - getScrollY(), 200);
      }
      if (this.Ccu.getVisibility() == 0)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = this.JHg;
        int k = getScrollY();
        localScroller.startScroll(0, i, 0, this.JHg + (j - k), 200);
      }
      this.JHr = 1;
      this.JHj = true;
      this.JHk = false;
    }
  }
  
  public static void o(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(142085);
    ae.i("MicroMsg.MMPullDownView", "fix android O progress bar bug. visibility=".concat(String.valueOf(paramInt)));
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
  
  protected void ccO()
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
      if (this.JHj)
      {
        ae.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
        this.JHj = false;
        this.JHD.sendEmptyMessageDelayed(0, JHC);
        fCS();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142092);
    boolean bool;
    if (!this.JHx)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
    }
    Object localObject = this.JHy;
    if (((k)localObject).Lfx != null)
    {
      localObject = ((k)localObject).aYl;
      locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/ui/tools/MMGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/ui/tools/MMGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    if (!this.JHk)
    {
      AppMethodBeat.o(142092);
      return true;
    }
    if (this.JHp == null)
    {
      this.JHh = false;
      if (this.JHo != null) {
        break label245;
      }
      this.JHi = false;
      label159:
      if (this.JHt == 0)
      {
        if (!this.JHm) {
          break label261;
        }
        this.JHq.setVisibility(4);
      }
      label181:
      if (this.JHs == 0)
      {
        if (!this.JHn) {
          break label272;
        }
        this.Ccu.setVisibility(4);
      }
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() != 1) {
        break label283;
      }
      fCT();
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
      this.JHh = this.JHp.ccq();
      break;
      label245:
      this.JHi = this.JHo.ccr();
      break label159;
      label261:
      this.JHq.setVisibility(0);
      break label181;
      label272:
      this.Ccu.setVisibility(0);
    }
    label283:
    if (paramMotionEvent.getAction() == 3)
    {
      fCT();
      if (this.JHz)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(142092);
        return bool;
      }
      AppMethodBeat.o(142092);
      return false;
    }
    localObject = this.iNw;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/ui/base/MMPullDownView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/ui/base/MMPullDownView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z"))
    {
      paramMotionEvent.setAction(3);
      this.JHE = true;
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
      ae.printErrStackTrace("MicroMsg.MMPullDownView", paramMotionEvent, "", new Object[0]);
      AppMethodBeat.o(142092);
    }
    return true;
  }
  
  public int getBottomHeight()
  {
    return this.JHg;
  }
  
  public int getCurScreen()
  {
    return this.JEq;
  }
  
  public int getTopHeight()
  {
    return this.JHf;
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
    ae.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    AppMethodBeat.o(142097);
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142090);
    if (this.JHA != null) {
      this.JHA.onInterceptTouchEvent(paramMotionEvent);
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(142090);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142088);
    ae.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
            ae.printErrStackTrace("MicroMsg.MMPullDownView", localArrayIndexOutOfBoundsException, "childCount: %d, i:%d, childHeight:%d", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(i) });
          }
        }
      }
    }
    this.JHq = getChildAt(0);
    this.Ccu = getChildAt(getChildCount() - 1);
    this.JHq.setVisibility(this.JHt);
    this.Ccu.setVisibility(this.JHs);
    this.JHf = this.JHq.getHeight();
    this.JHg = this.Ccu.getHeight();
    this.JHH = this.JHf;
    if ((!this.JHl) && (this.JHf != 0))
    {
      this.JHl = true;
      scrollTo(0, this.JHf);
    }
    AppMethodBeat.o(142088);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193724);
    b localb = new b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(193724);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142087);
    if (!this.JHu)
    {
      ccO();
      this.JHu = true;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(142087);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142098);
    if (paramFloat2 > 0.0F)
    {
      this.ncR = true;
      if (Math.abs(paramFloat2) <= Math.abs(paramFloat1)) {
        break label141;
      }
    }
    label141:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.JHv != null)) {
        this.JHv.bE(paramFloat2);
      }
      if ((!this.JHi) || ((!this.ncR) && (getScrollY() - this.JHf <= 0)) || (i == 0)) {
        break label324;
      }
      if ((this.JHw) || ((this.Ccu.getVisibility() == 0) && ((!this.ncR) || (getScrollY() < this.JHf * 2)))) {
        break label147;
      }
      AppMethodBeat.o(142098);
      return true;
      this.ncR = false;
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
      ae.v("check", "moveUp:" + i + " distanceY:" + paramFloat2 + " scrollY:" + getScrollY());
      if ((getScrollY() + i >= this.JHf) || (this.ncR)) {
        break label277;
      }
      j = this.JHf - getScrollY();
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
      if (!this.JHw)
      {
        j = i;
        if (getScrollY() + i >= this.JHf * 2) {
          j = this.JHf * 2 - getScrollY();
        }
      }
    }
    label324:
    if ((this.JHh) && ((!this.ncR) || (getScrollY() - this.JHf < 0)) && (i != 0))
    {
      if ((!this.JHw) && ((this.JHq.getVisibility() != 0) || ((!this.ncR) && (getScrollY() <= 0))))
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
        if (getScrollY() + i <= this.JHf) {
          break label469;
        }
        j = this.JHf - getScrollY();
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
        if (!this.JHw)
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
    if (this.JHI != null) {
      this.JHI.cnI();
    }
    if (!this.JHG)
    {
      AppMethodBeat.o(142099);
      return;
    }
    if (this.JHH == -2147483648)
    {
      this.JHH = this.JHf;
      ae.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.JHH);
    }
    if ((paramInt2 <= this.JHH) && (this.JHB != JHF))
    {
      setBackgroundResource(2131233299);
      this.JHB = JHF;
      ae.d("MicroMsg.MMPullDownView", "onScrollChanged full");
      AppMethodBeat.o(142099);
      return;
    }
    if ((paramInt2 > this.JHH) && (this.JHB != this.bgColor))
    {
      ae.d("MicroMsg.MMPullDownView", "onScrollChanged white");
      setBackgroundColor(this.bgColor);
      this.JHB = this.bgColor;
    }
    AppMethodBeat.o(142099);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193725);
    b localb = new b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(193725);
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
      if (getScrollY() - this.JHf < 0) {
        this.JHh = true;
      }
      if (getScrollY() > this.JHg) {
        this.JHi = true;
      }
      fCT();
    }
  }
  
  public void setAtBottomCallBack(c paramc)
  {
    this.JHo = paramc;
  }
  
  public void setAtTopCallBack(d paramd)
  {
    this.JHp = paramd;
  }
  
  public void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
    this.JHB = this.bgColor;
  }
  
  public void setBottomView(View paramView)
  {
    AppMethodBeat.i(142082);
    if (paramView == null)
    {
      this.JHs = 4;
      if (this.Ccu != null)
      {
        this.Ccu.setVisibility(4);
        AppMethodBeat.o(142082);
      }
    }
    else
    {
      this.Ccu = paramView;
      this.Ccu.setVisibility(0);
      this.JHs = 0;
      removeViewAt(getChildCount() - 1);
      addView(this.Ccu, new FrameLayout.LayoutParams(-1, -2));
      this.JHg = 0;
    }
    AppMethodBeat.o(142082);
  }
  
  public void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142083);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.JHs = i;
      if (this.Ccu != null) {
        this.Ccu.setVisibility(this.JHs);
      }
      ae.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bu.fpN() });
      AppMethodBeat.o(142083);
      return;
    }
  }
  
  public void setCanOverScrool(boolean paramBoolean)
  {
    this.JHw = paramBoolean;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.JHx = paramBoolean;
  }
  
  public void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142080);
    ae.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.JHn), bu.fpN() });
    this.JHn = paramBoolean;
    AppMethodBeat.o(142080);
  }
  
  public void setIsReturnSuperDispatchWhenCancel(boolean paramBoolean)
  {
    this.JHz = paramBoolean;
  }
  
  public void setIsTopShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142079);
    ae.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.JHm), bu.fpN() });
    this.JHm = paramBoolean;
    AppMethodBeat.o(142079);
  }
  
  public void setOnBottomLoadDataListener(e parame)
  {
    this.JHe = parame;
  }
  
  public void setOnInterceptTouchEventListener(a parama)
  {
    this.JHA = parama;
  }
  
  public void setOnMMFlingListener(k.a parama)
  {
    this.JHy.Lfx = parama;
  }
  
  public void setOnScrollChangedListener(b paramb)
  {
    this.JHI = paramb;
  }
  
  public void setOnSrcollDistance(f paramf)
  {
    this.JHv = paramf;
  }
  
  public void setOnTopLoadDataListener(g paramg)
  {
    this.JHd = paramg;
  }
  
  public void setShowBackground(boolean paramBoolean)
  {
    this.JHG = paramBoolean;
  }
  
  public void setTopView(View paramView)
  {
    AppMethodBeat.i(142081);
    if (paramView == null)
    {
      this.JHt = 4;
      if (this.JHq != null)
      {
        this.JHq.setVisibility(4);
        AppMethodBeat.o(142081);
      }
    }
    else
    {
      removeViewAt(0);
      this.JHq = paramView;
      this.JHq.setVisibility(0);
      this.JHt = 0;
      addView(this.JHq, 0, new FrameLayout.LayoutParams(-1, -2));
      this.JHf = 0;
    }
    AppMethodBeat.o(142081);
  }
  
  public void setTopViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142084);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.JHt = i;
      if (this.JHq != null) {
        this.JHq.setVisibility(this.JHt);
      }
      ae.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(142084);
      return;
    }
  }
  
  public void xI(boolean paramBoolean)
  {
    AppMethodBeat.i(142093);
    ae.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.JHj), Boolean.valueOf(this.JHk), Boolean.valueOf(this.JHm), Integer.valueOf(getScrollY()) });
    Scroller localScroller;
    int i;
    int j;
    if (paramBoolean)
    {
      if (this.JHq != null) {
        this.JHq.setVisibility(this.JHt);
      }
      if (this.JHm)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.JHf + j, 200);
        postInvalidate();
      }
    }
    for (;;)
    {
      if (!this.JHm) {
        fCS();
      }
      AppMethodBeat.o(142093);
      return;
      if ((this.JHq != null) && (this.JHq.getVisibility() == 4))
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.JHf + j, 200);
      }
      if ((this.JHq != null) && (this.JHq.getVisibility() == 0)) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.JHr = 0;
      this.JHj = true;
      this.JHk = false;
      break;
      if (!this.JHk)
      {
        this.JHk = true;
        this.JHj = false;
        if ((this.JHq != null) && (this.JHq.getVisibility() == 0)) {
          scrollTo(0, this.JHf);
        }
      }
      if ((this.JHq != null) && (this.JHq.getVisibility() == 0)) {
        this.JHq.setVisibility(8);
      }
    }
  }
  
  public final void xJ(boolean paramBoolean)
  {
    AppMethodBeat.i(142094);
    ae.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.JHj), Boolean.valueOf(this.JHk), Boolean.valueOf(this.JHn), Integer.valueOf(getScrollY()) });
    if (paramBoolean)
    {
      if (this.Ccu != null) {
        this.Ccu.setVisibility(this.JHt);
      }
      if (this.JHn) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.JHg - getScrollY(), 200);
      }
      for (;;)
      {
        postInvalidate();
        AppMethodBeat.o(142094);
        return;
        if ((this.Ccu != null) && (this.Ccu.getVisibility() == 4)) {
          this.mScroller.startScroll(0, getScrollY(), 0, this.JHg - getScrollY(), 200);
        }
        if ((this.Ccu != null) && (this.Ccu.getVisibility() == 0))
        {
          Scroller localScroller = this.mScroller;
          int i = getScrollY();
          int j = this.JHg;
          int k = getScrollY();
          localScroller.startScroll(0, i, 0, this.JHg + (j - k), 200);
        }
        this.JHr = 1;
        this.JHj = true;
        this.JHk = false;
      }
    }
    if (!this.JHk)
    {
      this.JHk = true;
      this.JHj = false;
    }
    if ((this.Ccu != null) && (this.Ccu.getVisibility() == 0))
    {
      ae.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
      scrollTo(0, this.JHf);
    }
    if ((this.Ccu != null) && (this.Ccu.getVisibility() == 0)) {
      this.Ccu.setVisibility(8);
    }
    AppMethodBeat.o(142094);
  }
  
  public static abstract interface a
  {
    public abstract boolean onInterceptTouchEvent(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface b
  {
    public abstract void cnI();
  }
  
  public static abstract interface c
  {
    public abstract boolean ccr();
  }
  
  public static abstract interface d
  {
    public abstract boolean ccq();
  }
  
  public static abstract interface e
  {
    public abstract boolean ccp();
  }
  
  public static abstract interface f
  {
    public abstract void bE(float paramFloat);
    
    public abstract void egP();
  }
  
  public static abstract interface g
  {
    public abstract boolean ccs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPullDownView
 * JD-Core Version:    0.7.0.1
 */