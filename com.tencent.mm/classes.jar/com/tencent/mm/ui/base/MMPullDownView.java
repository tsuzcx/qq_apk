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
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public class MMPullDownView
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  private static int adSW;
  private static final int adSZ;
  private boolean CIK;
  public View UfQ;
  private int adPo;
  private int adQd;
  private g adSC;
  private e adSD;
  private int adSE;
  private int adSF;
  private boolean adSG;
  protected boolean adSH;
  private boolean adSI;
  private boolean adSJ;
  private boolean adSK;
  public View adSL;
  private int adSM;
  private int adSN;
  private int adSO;
  private boolean adSP;
  private f adSQ;
  private boolean adSR;
  private boolean adSS;
  private boolean adST;
  private a adSU;
  private int adSV;
  private MMHandler adSX;
  boolean adSY;
  private c adSg;
  private d adSh;
  public boolean adSi;
  private boolean adSm;
  private boolean adSn;
  private boolean adTa;
  private int adTb;
  private b adTc;
  private int bgColor;
  protected Context context;
  private Scroller mScroller;
  private GestureDetector nwZ;
  private boolean uAg;
  
  static
  {
    AppMethodBeat.i(142100);
    adSW = 400;
    adSZ = Color.parseColor("#00000000");
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
    this.adQd = 1;
    this.adSm = false;
    this.adSn = false;
    this.uAg = false;
    this.adSG = false;
    this.adSH = true;
    this.adSI = false;
    this.adSJ = true;
    this.adSK = true;
    this.adSN = 4;
    this.adSO = 4;
    this.adSP = false;
    this.adSR = true;
    this.CIK = true;
    this.adSi = false;
    this.adSS = false;
    this.adST = false;
    this.bgColor = MMApplicationContext.getContext().getResources().getColor(a.d.white);
    this.adSV = this.bgColor;
    this.adSX = new MMHandler()
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
          Log.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", new Object[] { Integer.valueOf(MMPullDownView.a(MMPullDownView.this)), Boolean.valueOf(MMPullDownView.this.adSH) });
          AppMethodBeat.o(142076);
          return;
          if (MMPullDownView.b(MMPullDownView.this) != null) {
            MMPullDownView.this.adSH = MMPullDownView.b(MMPullDownView.this).dsr();
          }
          if ((MMPullDownView.this.adSH) && (MMPullDownView.c(MMPullDownView.this).getVisibility() == 0))
          {
            MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            continue;
            if (MMPullDownView.e(MMPullDownView.this) != null) {
              MMPullDownView.this.adSH = MMPullDownView.e(MMPullDownView.this).dso();
            }
            if ((MMPullDownView.this.adSH) && (MMPullDownView.f(MMPullDownView.this).getVisibility() == 0)) {
              MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            }
          }
        }
      }
    };
    this.adSY = false;
    this.adTa = false;
    this.adTb = -2147483648;
    this.mScroller = new Scroller(paramContext, new AccelerateInterpolator());
    this.adPo = this.adQd;
    this.nwZ = new GestureDetector(paramContext, this);
    this.context = paramContext;
    this.bgColor = paramContext.getResources().getColor(a.d.white);
    this.adSV = this.bgColor;
    AppMethodBeat.o(142077);
  }
  
  private void fqm()
  {
    AppMethodBeat.i(142095);
    Scroller localScroller;
    int i;
    int j;
    if (getScrollY() - this.adSE < 0)
    {
      if (this.adSJ)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.adSE + j, 200);
        postInvalidate();
      }
    }
    else if (getScrollY() > this.adSF)
    {
      if (!this.adSK) {
        break label214;
      }
      this.mScroller.startScroll(0, getScrollY(), 0, this.adSF - getScrollY(), 200);
    }
    for (;;)
    {
      postInvalidate();
      this.uAg = false;
      AppMethodBeat.o(142095);
      return;
      if (this.adSL.getVisibility() == 4)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.adSE + j, 200);
      }
      if (this.adSL.getVisibility() == 0) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.adSM = 0;
      this.adSG = true;
      this.adSH = false;
      break;
      label214:
      if (this.UfQ.getVisibility() == 4) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.adSF - getScrollY(), 200);
      }
      if (this.UfQ.getVisibility() == 0)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = this.adSF;
        int k = getScrollY();
        localScroller.startScroll(0, i, 0, this.adSF + (j - k), 200);
      }
      this.adSM = 1;
      this.adSG = true;
      this.adSH = false;
    }
  }
  
  private void jmy()
  {
    AppMethodBeat.i(142086);
    o((ViewGroup)this.adSL, 0);
    o((ViewGroup)this.UfQ, 0);
    AppMethodBeat.o(142086);
  }
  
  public static void o(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(142085);
    Log.i("MicroMsg.MMPullDownView", "fix android O progress bar bug. visibility=".concat(String.valueOf(paramInt)));
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
    AppMethodBeat.o(142085);
  }
  
  public final void LB(boolean paramBoolean)
  {
    AppMethodBeat.i(142093);
    as(paramBoolean, 200);
    AppMethodBeat.o(142093);
  }
  
  public final void LC(boolean paramBoolean)
  {
    AppMethodBeat.i(142094);
    Log.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.adSG), Boolean.valueOf(this.adSH), Boolean.valueOf(this.adSK), Integer.valueOf(getScrollY()) });
    if (paramBoolean)
    {
      if (this.UfQ != null) {
        this.UfQ.setVisibility(this.adSO);
      }
      if (this.adSK) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.adSF - getScrollY(), 200);
      }
      for (;;)
      {
        postInvalidate();
        AppMethodBeat.o(142094);
        return;
        if ((this.UfQ != null) && (this.UfQ.getVisibility() == 4)) {
          this.mScroller.startScroll(0, getScrollY(), 0, this.adSF - getScrollY(), 200);
        }
        if ((this.UfQ != null) && (this.UfQ.getVisibility() == 0))
        {
          Scroller localScroller = this.mScroller;
          int i = getScrollY();
          int j = this.adSF;
          int k = getScrollY();
          localScroller.startScroll(0, i, 0, this.adSF + (j - k), 200);
        }
        this.adSM = 1;
        this.adSG = true;
        this.adSH = false;
      }
    }
    if (!this.adSH)
    {
      this.adSH = true;
      this.adSG = false;
    }
    if ((this.UfQ != null) && (this.UfQ.getVisibility() == 0))
    {
      Log.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
      scrollTo(0, this.adSE);
    }
    if ((this.UfQ != null) && (this.UfQ.getVisibility() == 0)) {
      this.UfQ.setVisibility(8);
    }
    AppMethodBeat.o(142094);
  }
  
  public void as(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(251342);
    Log.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.adSG), Boolean.valueOf(this.adSH), Boolean.valueOf(this.adSJ), Integer.valueOf(getScrollY()) });
    Scroller localScroller;
    int i;
    int j;
    if (paramBoolean)
    {
      if (this.adSL != null) {
        this.adSL.setVisibility(this.adSO);
      }
      if (this.adSJ)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.adSE + j, paramInt);
        postInvalidate();
      }
    }
    for (;;)
    {
      if (!this.adSJ) {
        jmy();
      }
      AppMethodBeat.o(251342);
      return;
      if ((this.adSL != null) && (this.adSL.getVisibility() == 4))
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.adSE + j, paramInt);
      }
      if ((this.adSL != null) && (this.adSL.getVisibility() == 0)) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), paramInt);
      }
      this.adSM = 0;
      this.adSG = true;
      this.adSH = false;
      break;
      if (!this.adSH)
      {
        this.adSH = true;
        this.adSG = false;
        if ((this.adSL != null) && (this.adSL.getVisibility() == 0)) {
          scrollTo(0, this.adSE);
        }
      }
      if ((this.adSL != null) && (this.adSL.getVisibility() == 0)) {
        this.adSL.setVisibility(8);
      }
    }
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
      if (this.adSG)
      {
        Log.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
        this.adSG = false;
        this.adSX.sendEmptyMessageDelayed(0, adSW);
        jmy();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142092);
    boolean bool;
    if (!this.CIK)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
    }
    if ((this.adSi) && (paramMotionEvent.getAction() == 2))
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
    }
    this.adSi = false;
    if (!this.adSH)
    {
      AppMethodBeat.o(142092);
      return true;
    }
    if (this.adSh == null)
    {
      this.adSm = false;
      if (this.adSg != null) {
        break label186;
      }
      this.adSn = false;
      label100:
      if (this.adSO == 0)
      {
        if (!this.adSJ) {
          break label202;
        }
        this.adSL.setVisibility(4);
      }
      label122:
      if (this.adSN == 0)
      {
        if (!this.adSK) {
          break label213;
        }
        this.UfQ.setVisibility(4);
      }
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() != 1) {
        break label224;
      }
      fqm();
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
      this.adSm = this.adSh.dsp();
      break;
      label186:
      this.adSn = this.adSg.dsq();
      break label100;
      label202:
      this.adSL.setVisibility(0);
      break label122;
      label213:
      this.UfQ.setVisibility(0);
    }
    label224:
    if (paramMotionEvent.getAction() == 3)
    {
      fqm();
      if (this.adST)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(142092);
        return bool;
      }
      AppMethodBeat.o(142092);
      return false;
    }
    GestureDetector localGestureDetector = this.nwZ;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aYi(), "com/tencent/mm/ui/base/MMPullDownView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/ui/base/MMPullDownView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z"))
    {
      paramMotionEvent.setAction(3);
      this.adSY = true;
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
      Log.printErrStackTrace("MicroMsg.MMPullDownView", paramMotionEvent, "", new Object[0]);
      AppMethodBeat.o(142092);
    }
    return true;
  }
  
  protected void dsM()
  {
    AppMethodBeat.i(142078);
    View localView1 = inflate(this.context, a.h.loading_view, null);
    View localView2 = inflate(this.context, a.h.loading_view, null);
    addView(localView1, 0, new FrameLayout.LayoutParams(-1, -2));
    addView(localView2, new FrameLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(142078);
  }
  
  public int getBottomHeight()
  {
    return this.adSF;
  }
  
  public int getCurScreen()
  {
    return this.adPo;
  }
  
  public int getTopHeight()
  {
    return this.adSE;
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
    Log.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    AppMethodBeat.o(142097);
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142090);
    if (this.adSU != null) {
      this.adSU.onInterceptTouchEvent(paramMotionEvent);
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(142090);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142088);
    Log.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
            Log.printErrStackTrace("MicroMsg.MMPullDownView", localArrayIndexOutOfBoundsException, "childCount: %d, i:%d, childHeight:%d", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(i) });
          }
        }
      }
    }
    this.adSL = getChildAt(0);
    this.UfQ = getChildAt(getChildCount() - 1);
    this.adSL.setVisibility(this.adSO);
    this.UfQ.setVisibility(this.adSN);
    this.adSE = this.adSL.getHeight();
    this.adSF = this.UfQ.getHeight();
    this.adTb = this.adSE;
    if ((!this.adSI) && (this.adSE != 0))
    {
      this.adSI = true;
      scrollTo(0, this.adSE);
    }
    AppMethodBeat.o(142088);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251348);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(251348);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142087);
    if (!this.adSP)
    {
      dsM();
      this.adSP = true;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(142087);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142098);
    int i;
    if (paramFloat2 > 0.0F)
    {
      this.uAg = true;
      if (Math.abs(paramFloat2) <= Math.abs(paramFloat1)) {
        break label125;
      }
      i = 1;
    }
    label125:
    int j;
    for (;;)
    {
      if ((this.adSn) && ((this.uAg) || (getScrollY() - this.adSE > 0)) && (i != 0))
      {
        if ((!this.adSR) && ((this.UfQ.getVisibility() != 0) || ((this.uAg) && (getScrollY() >= this.adSE * 2))))
        {
          if (this.adSS)
          {
            AppMethodBeat.o(142098);
            return false;
            this.uAg = false;
            break;
            i = 0;
            continue;
          }
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
          Log.v("check", "moveUp:" + i + " distanceY:" + paramFloat2 + " scrollY:" + getScrollY());
          if ((getScrollY() + i >= this.adSE) || (this.uAg)) {
            break label269;
          }
          j = this.adSE - getScrollY();
        }
        for (;;)
        {
          scrollBy(0, j);
          AppMethodBeat.o(142098);
          return true;
          i = -1;
          break;
          label269:
          j = i;
          if (!this.adSR)
          {
            j = i;
            if (getScrollY() + i >= this.adSE * 2) {
              j = this.adSE * 2 - getScrollY();
            }
          }
        }
      }
    }
    if ((this.adSm) && ((!this.uAg) || (getScrollY() - this.adSE < 0)) && (i != 0))
    {
      if ((!this.adSR) && ((this.adSL.getVisibility() != 0) || ((!this.uAg) && (getScrollY() <= 0))))
      {
        if (this.adSS)
        {
          AppMethodBeat.o(142098);
          return false;
        }
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
        if (getScrollY() + i <= this.adSE) {
          break label476;
        }
        j = this.adSE - getScrollY();
      }
      for (;;)
      {
        scrollBy(0, j);
        AppMethodBeat.o(142098);
        return true;
        i = -1;
        break;
        label476:
        j = i;
        if (!this.adSR)
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
    if (this.adTc != null) {
      this.adTc.dHa();
    }
    if (!this.adTa)
    {
      AppMethodBeat.o(142099);
      return;
    }
    if (this.adTb == -2147483648)
    {
      this.adTb = this.adSE;
      Log.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.adTb);
    }
    if ((paramInt2 <= this.adTb) && (this.adSV != adSZ))
    {
      setBackgroundResource(a.f.mm_trans);
      this.adSV = adSZ;
      Log.d("MicroMsg.MMPullDownView", "onScrollChanged full");
      AppMethodBeat.o(142099);
      return;
    }
    if ((paramInt2 > this.adTb) && (this.adSV != this.bgColor))
    {
      Log.d("MicroMsg.MMPullDownView", "onScrollChanged white");
      setBackgroundColor(this.bgColor);
      this.adSV = this.bgColor;
    }
    AppMethodBeat.o(142099);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251355);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(251355);
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
      if (getScrollY() - this.adSE < 0) {
        this.adSm = true;
      }
      if (getScrollY() > this.adSF) {
        this.adSn = true;
      }
      fqm();
    }
  }
  
  public void setAtBottomCallBack(c paramc)
  {
    this.adSg = paramc;
  }
  
  public void setAtTopCallBack(d paramd)
  {
    this.adSh = paramd;
  }
  
  public void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
    this.adSV = this.bgColor;
  }
  
  public void setBottomView(View paramView)
  {
    AppMethodBeat.i(142082);
    if (paramView == null)
    {
      this.adSN = 4;
      if (this.UfQ != null)
      {
        this.UfQ.setVisibility(4);
        AppMethodBeat.o(142082);
      }
    }
    else
    {
      this.UfQ = paramView;
      this.UfQ.setVisibility(0);
      this.adSN = 0;
      removeViewAt(getChildCount() - 1);
      addView(this.UfQ, new FrameLayout.LayoutParams(-1, -2));
      this.adSF = 0;
    }
    AppMethodBeat.o(142082);
  }
  
  public void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142083);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.adSN = i;
      if (this.UfQ != null) {
        this.UfQ.setVisibility(this.adSN);
      }
      Log.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Util.getStack() });
      AppMethodBeat.o(142083);
      return;
    }
  }
  
  public void setCanOverScrool(boolean paramBoolean)
  {
    this.adSR = paramBoolean;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.CIK = paramBoolean;
  }
  
  public void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142080);
    Log.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.adSK), Util.getStack() });
    this.adSK = paramBoolean;
    AppMethodBeat.o(142080);
  }
  
  public void setIsReturnSuperDispatchWhenCancel(boolean paramBoolean)
  {
    this.adST = paramBoolean;
  }
  
  public void setIsTopShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142079);
    Log.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.adSJ), Util.getStack() });
    this.adSJ = paramBoolean;
    AppMethodBeat.o(142079);
  }
  
  public void setNestedOverScrollEnabled(boolean paramBoolean)
  {
    this.adSS = paramBoolean;
  }
  
  public void setOnBottomLoadDataListener(e parame)
  {
    this.adSD = parame;
  }
  
  public void setOnInterceptTouchEventListener(a parama)
  {
    this.adSU = parama;
  }
  
  public void setOnScrollChangedListener(b paramb)
  {
    this.adTc = paramb;
  }
  
  public void setOnSrcollDistance(f paramf)
  {
    this.adSQ = paramf;
  }
  
  public void setOnTopLoadDataListener(g paramg)
  {
    this.adSC = paramg;
  }
  
  public void setShowBackground(boolean paramBoolean)
  {
    this.adTa = paramBoolean;
  }
  
  public void setTopView(View paramView)
  {
    AppMethodBeat.i(142081);
    if (paramView == null)
    {
      this.adSO = 4;
      if (this.adSL != null)
      {
        this.adSL.setVisibility(4);
        AppMethodBeat.o(142081);
      }
    }
    else
    {
      removeViewAt(0);
      this.adSL = paramView;
      this.adSL.setVisibility(0);
      this.adSO = 0;
      addView(this.adSL, 0, new FrameLayout.LayoutParams(-1, -2));
      this.adSE = 0;
    }
    AppMethodBeat.o(142081);
  }
  
  public void setTopViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142084);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.adSO = i;
      if (this.adSL != null) {
        this.adSL.setVisibility(this.adSO);
      }
      Log.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(142084);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean onInterceptTouchEvent(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface b
  {
    public abstract void dHa();
  }
  
  public static abstract interface c
  {
    public abstract boolean dsq();
  }
  
  public static abstract interface d
  {
    public abstract boolean dsp();
  }
  
  public static abstract interface e
  {
    public abstract boolean dso();
  }
  
  public static abstract interface f {}
  
  public static abstract interface g
  {
    public abstract boolean dsr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPullDownView
 * JD-Core Version:    0.7.0.1
 */