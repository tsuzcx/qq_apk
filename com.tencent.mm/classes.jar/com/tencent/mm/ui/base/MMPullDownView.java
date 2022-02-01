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
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.tools.l.a;

public class MMPullDownView
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  private static int WlI;
  private static final int WlL;
  public View Nsh;
  private int Wip;
  private int Wjb;
  private f WlA;
  private boolean WlB;
  public boolean WlC;
  private boolean WlD;
  private l WlE;
  private boolean WlF;
  private MMPullDownView.a WlG;
  private int WlH;
  private MMHandler WlJ;
  boolean WlK;
  private boolean WlM;
  private int WlN;
  private b WlO;
  private g Wli;
  private e Wlj;
  private int Wlk;
  private int Wll;
  private boolean Wlm;
  private boolean Wln;
  private boolean Wlo;
  protected boolean Wlp;
  private boolean Wlq;
  private boolean Wlr;
  private boolean Wls;
  private c Wlt;
  private d Wlu;
  public View Wlv;
  private int Wlw;
  private int Wlx;
  private int Wly;
  private boolean Wlz;
  private int bgColor;
  protected Context context;
  private GestureDetector mBn;
  private Scroller mScroller;
  private boolean rpV;
  private boolean yiG;
  
  static
  {
    AppMethodBeat.i(142100);
    WlI = 400;
    WlL = Color.parseColor("#00000000");
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
    this.Wjb = 1;
    this.Wlm = false;
    this.Wln = false;
    this.rpV = false;
    this.Wlo = false;
    this.Wlp = true;
    this.Wlq = false;
    this.Wlr = true;
    this.Wls = true;
    this.Wlx = 4;
    this.Wly = 4;
    this.Wlz = false;
    this.WlB = true;
    this.yiG = true;
    this.WlC = false;
    this.WlD = false;
    this.WlF = false;
    this.bgColor = MMApplicationContext.getContext().getResources().getColor(a.d.white);
    this.WlH = this.bgColor;
    this.WlJ = new MMHandler()
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
          Log.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", new Object[] { Integer.valueOf(MMPullDownView.a(MMPullDownView.this)), Boolean.valueOf(MMPullDownView.this.Wlp) });
          AppMethodBeat.o(142076);
          return;
          if (MMPullDownView.b(MMPullDownView.this) != null) {
            MMPullDownView.this.Wlp = MMPullDownView.b(MMPullDownView.this).cOM();
          }
          if ((MMPullDownView.this.Wlp) && (MMPullDownView.c(MMPullDownView.this).getVisibility() == 0))
          {
            MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            continue;
            if (MMPullDownView.e(MMPullDownView.this) != null) {
              MMPullDownView.this.Wlp = MMPullDownView.e(MMPullDownView.this).cOJ();
            }
            if ((MMPullDownView.this.Wlp) && (MMPullDownView.f(MMPullDownView.this).getVisibility() == 0)) {
              MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            }
          }
        }
      }
    };
    this.WlK = false;
    this.WlM = false;
    this.WlN = -2147483648;
    this.mScroller = new Scroller(paramContext, new AccelerateInterpolator());
    this.Wip = this.Wjb;
    this.mBn = new GestureDetector(paramContext, this);
    this.WlE = new l(paramContext);
    this.context = paramContext;
    this.bgColor = paramContext.getResources().getColor(a.d.white);
    this.WlH = this.bgColor;
    AppMethodBeat.o(142077);
  }
  
  private void hJR()
  {
    AppMethodBeat.i(142086);
    o((ViewGroup)this.Wlv, 0);
    o((ViewGroup)this.Nsh, 0);
    AppMethodBeat.o(142086);
  }
  
  private void hJS()
  {
    AppMethodBeat.i(142095);
    if (this.WlA != null) {
      this.WlA.fXE();
    }
    Scroller localScroller;
    int i;
    int j;
    if (getScrollY() - this.Wlk < 0)
    {
      if (this.Wlr)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.Wlk + j, 200);
        postInvalidate();
      }
    }
    else if (getScrollY() > this.Wll)
    {
      if (!this.Wls) {
        break label230;
      }
      this.mScroller.startScroll(0, getScrollY(), 0, this.Wll - getScrollY(), 200);
    }
    for (;;)
    {
      postInvalidate();
      this.rpV = false;
      AppMethodBeat.o(142095);
      return;
      if (this.Wlv.getVisibility() == 4)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.Wlk + j, 200);
      }
      if (this.Wlv.getVisibility() == 0) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.Wlw = 0;
      this.Wlo = true;
      this.Wlp = false;
      break;
      label230:
      if (this.Nsh.getVisibility() == 4) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.Wll - getScrollY(), 200);
      }
      if (this.Nsh.getVisibility() == 0)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = this.Wll;
        int k = getScrollY();
        localScroller.startScroll(0, i, 0, this.Wll + (j - k), 200);
      }
      this.Wlw = 1;
      this.Wlo = true;
      this.Wlp = false;
    }
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
  
  public final void FP(boolean paramBoolean)
  {
    AppMethodBeat.i(142093);
    am(paramBoolean, 200);
    AppMethodBeat.o(142093);
  }
  
  public final void FQ(boolean paramBoolean)
  {
    AppMethodBeat.i(142094);
    Log.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Wlo), Boolean.valueOf(this.Wlp), Boolean.valueOf(this.Wls), Integer.valueOf(getScrollY()) });
    if (paramBoolean)
    {
      if (this.Nsh != null) {
        this.Nsh.setVisibility(this.Wly);
      }
      if (this.Wls) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.Wll - getScrollY(), 200);
      }
      for (;;)
      {
        postInvalidate();
        AppMethodBeat.o(142094);
        return;
        if ((this.Nsh != null) && (this.Nsh.getVisibility() == 4)) {
          this.mScroller.startScroll(0, getScrollY(), 0, this.Wll - getScrollY(), 200);
        }
        if ((this.Nsh != null) && (this.Nsh.getVisibility() == 0))
        {
          Scroller localScroller = this.mScroller;
          int i = getScrollY();
          int j = this.Wll;
          int k = getScrollY();
          localScroller.startScroll(0, i, 0, this.Wll + (j - k), 200);
        }
        this.Wlw = 1;
        this.Wlo = true;
        this.Wlp = false;
      }
    }
    if (!this.Wlp)
    {
      this.Wlp = true;
      this.Wlo = false;
    }
    if ((this.Nsh != null) && (this.Nsh.getVisibility() == 0))
    {
      Log.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
      scrollTo(0, this.Wlk);
    }
    if ((this.Nsh != null) && (this.Nsh.getVisibility() == 0)) {
      this.Nsh.setVisibility(8);
    }
    AppMethodBeat.o(142094);
  }
  
  public void am(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(293083);
    Log.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Wlo), Boolean.valueOf(this.Wlp), Boolean.valueOf(this.Wlr), Integer.valueOf(getScrollY()) });
    Scroller localScroller;
    int i;
    int j;
    if (paramBoolean)
    {
      if (this.Wlv != null) {
        this.Wlv.setVisibility(this.Wly);
      }
      if (this.Wlr)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.Wlk + j, paramInt);
        postInvalidate();
      }
    }
    for (;;)
    {
      if (!this.Wlr) {
        hJR();
      }
      AppMethodBeat.o(293083);
      return;
      if ((this.Wlv != null) && (this.Wlv.getVisibility() == 4))
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.Wlk + j, paramInt);
      }
      if ((this.Wlv != null) && (this.Wlv.getVisibility() == 0)) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), paramInt);
      }
      this.Wlw = 0;
      this.Wlo = true;
      this.Wlp = false;
      break;
      if (!this.Wlp)
      {
        this.Wlp = true;
        this.Wlo = false;
        if ((this.Wlv != null) && (this.Wlv.getVisibility() == 0)) {
          scrollTo(0, this.Wlk);
        }
      }
      if ((this.Wlv != null) && (this.Wlv.getVisibility() == 0)) {
        this.Wlv.setVisibility(8);
      }
    }
  }
  
  protected void cPg()
  {
    AppMethodBeat.i(142078);
    View localView1 = inflate(this.context, a.h.loading_view, null);
    View localView2 = inflate(this.context, a.h.loading_view, null);
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
      if (this.Wlo)
      {
        Log.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
        this.Wlo = false;
        this.WlJ.sendEmptyMessageDelayed(0, WlI);
        hJR();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142092);
    boolean bool;
    if (!this.yiG)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
    }
    if ((this.WlC) && (paramMotionEvent.getAction() == 2))
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
    }
    this.WlC = false;
    Object localObject = this.WlE;
    if (((l)localObject).XSA != null)
    {
      localObject = ((l)localObject).aHB;
      locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/ui/tools/MMGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/ui/tools/MMGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    if (!this.Wlp)
    {
      AppMethodBeat.o(142092);
      return true;
    }
    if (this.Wlu == null)
    {
      this.Wlm = false;
      if (this.Wlt != null) {
        break label279;
      }
      this.Wln = false;
      label193:
      if (this.Wly == 0)
      {
        if (!this.Wlr) {
          break label295;
        }
        this.Wlv.setVisibility(4);
      }
      label215:
      if (this.Wlx == 0)
      {
        if (!this.Wls) {
          break label306;
        }
        this.Nsh.setVisibility(4);
      }
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() != 1) {
        break label317;
      }
      hJS();
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
      this.Wlm = this.Wlu.cOK();
      break;
      label279:
      this.Wln = this.Wlt.cOL();
      break label193;
      label295:
      this.Wlv.setVisibility(0);
      break label215;
      label306:
      this.Nsh.setVisibility(0);
    }
    label317:
    if (paramMotionEvent.getAction() == 3)
    {
      hJS();
      if (this.WlF)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(142092);
        return bool;
      }
      AppMethodBeat.o(142092);
      return false;
    }
    localObject = this.mBn;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/ui/base/MMPullDownView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/ui/base/MMPullDownView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z"))
    {
      paramMotionEvent.setAction(3);
      this.WlK = true;
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
  
  public int getBottomHeight()
  {
    return this.Wll;
  }
  
  public int getCurScreen()
  {
    return this.Wip;
  }
  
  public int getTopHeight()
  {
    return this.Wlk;
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
    if (this.WlG != null) {
      this.WlG.onInterceptTouchEvent(paramMotionEvent);
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
    this.Wlv = getChildAt(0);
    this.Nsh = getChildAt(getChildCount() - 1);
    this.Wlv.setVisibility(this.Wly);
    this.Nsh.setVisibility(this.Wlx);
    this.Wlk = this.Wlv.getHeight();
    this.Wll = this.Nsh.getHeight();
    this.WlN = this.Wlk;
    if ((!this.Wlq) && (this.Wlk != 0))
    {
      this.Wlq = true;
      scrollTo(0, this.Wlk);
    }
    AppMethodBeat.o(142088);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187249);
    b localb = new b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(187249);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142087);
    if (!this.Wlz)
    {
      cPg();
      this.Wlz = true;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(142087);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142098);
    if (paramFloat2 > 0.0F)
    {
      this.rpV = true;
      if (Math.abs(paramFloat2) <= Math.abs(paramFloat1)) {
        break label148;
      }
    }
    label148:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.WlA != null)) {
        this.WlA.cg(paramFloat2);
      }
      if ((!this.Wln) || ((!this.rpV) && (getScrollY() - this.Wlk <= 0)) || (i == 0)) {
        break label339;
      }
      if ((this.WlB) || ((this.Nsh.getVisibility() == 0) && ((!this.rpV) || (getScrollY() < this.Wlk * 2)))) {
        break label162;
      }
      if (!this.WlD) {
        break label154;
      }
      AppMethodBeat.o(142098);
      return false;
      this.rpV = false;
      break;
    }
    label154:
    AppMethodBeat.o(142098);
    return true;
    label162:
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
      Log.v("check", "moveUp:" + i + " distanceY:" + paramFloat2 + " scrollY:" + getScrollY());
      if ((getScrollY() + i >= this.Wlk) || (this.rpV)) {
        break label292;
      }
      j = this.Wlk - getScrollY();
    }
    for (;;)
    {
      scrollBy(0, j);
      AppMethodBeat.o(142098);
      return true;
      i = -1;
      break;
      label292:
      j = i;
      if (!this.WlB)
      {
        j = i;
        if (getScrollY() + i >= this.Wlk * 2) {
          j = this.Wlk * 2 - getScrollY();
        }
      }
    }
    label339:
    if ((this.Wlm) && ((!this.rpV) || (getScrollY() - this.Wlk < 0)) && (i != 0))
    {
      if ((!this.WlB) && ((this.Wlv.getVisibility() != 0) || ((!this.rpV) && (getScrollY() <= 0))))
      {
        if (this.WlD)
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
        if (getScrollY() + i <= this.Wlk) {
          break label499;
        }
        j = this.Wlk - getScrollY();
      }
      for (;;)
      {
        scrollBy(0, j);
        AppMethodBeat.o(142098);
        return true;
        i = -1;
        break;
        label499:
        j = i;
        if (!this.WlB)
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
    if (this.WlO != null) {
      this.WlO.daG();
    }
    if (!this.WlM)
    {
      AppMethodBeat.o(142099);
      return;
    }
    if (this.WlN == -2147483648)
    {
      this.WlN = this.Wlk;
      Log.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.WlN);
    }
    if ((paramInt2 <= this.WlN) && (this.WlH != WlL))
    {
      setBackgroundResource(a.f.mm_trans);
      this.WlH = WlL;
      Log.d("MicroMsg.MMPullDownView", "onScrollChanged full");
      AppMethodBeat.o(142099);
      return;
    }
    if ((paramInt2 > this.WlN) && (this.WlH != this.bgColor))
    {
      Log.d("MicroMsg.MMPullDownView", "onScrollChanged white");
      setBackgroundColor(this.bgColor);
      this.WlH = this.bgColor;
    }
    AppMethodBeat.o(142099);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(187255);
    b localb = new b();
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(187255);
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
      if (getScrollY() - this.Wlk < 0) {
        this.Wlm = true;
      }
      if (getScrollY() > this.Wll) {
        this.Wln = true;
      }
      hJS();
    }
  }
  
  public void setAtBottomCallBack(c paramc)
  {
    this.Wlt = paramc;
  }
  
  public void setAtTopCallBack(d paramd)
  {
    this.Wlu = paramd;
  }
  
  public void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
    this.WlH = this.bgColor;
  }
  
  public void setBottomView(View paramView)
  {
    AppMethodBeat.i(142082);
    if (paramView == null)
    {
      this.Wlx = 4;
      if (this.Nsh != null)
      {
        this.Nsh.setVisibility(4);
        AppMethodBeat.o(142082);
      }
    }
    else
    {
      this.Nsh = paramView;
      this.Nsh.setVisibility(0);
      this.Wlx = 0;
      removeViewAt(getChildCount() - 1);
      addView(this.Nsh, new FrameLayout.LayoutParams(-1, -2));
      this.Wll = 0;
    }
    AppMethodBeat.o(142082);
  }
  
  public void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142083);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.Wlx = i;
      if (this.Nsh != null) {
        this.Nsh.setVisibility(this.Wlx);
      }
      Log.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Util.getStack() });
      AppMethodBeat.o(142083);
      return;
    }
  }
  
  public void setCanOverScrool(boolean paramBoolean)
  {
    this.WlB = paramBoolean;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.yiG = paramBoolean;
  }
  
  public void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142080);
    Log.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Wls), Util.getStack() });
    this.Wls = paramBoolean;
    AppMethodBeat.o(142080);
  }
  
  public void setIsReturnSuperDispatchWhenCancel(boolean paramBoolean)
  {
    this.WlF = paramBoolean;
  }
  
  public void setIsTopShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142079);
    Log.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Wlr), Util.getStack() });
    this.Wlr = paramBoolean;
    AppMethodBeat.o(142079);
  }
  
  public void setNestedOverScrollEnabled(boolean paramBoolean)
  {
    this.WlD = paramBoolean;
  }
  
  public void setOnBottomLoadDataListener(e parame)
  {
    this.Wlj = parame;
  }
  
  public void setOnInterceptTouchEventListener(MMPullDownView.a parama)
  {
    this.WlG = parama;
  }
  
  public void setOnMMFlingListener(l.a parama)
  {
    this.WlE.XSA = parama;
  }
  
  public void setOnScrollChangedListener(b paramb)
  {
    this.WlO = paramb;
  }
  
  public void setOnSrcollDistance(f paramf)
  {
    this.WlA = paramf;
  }
  
  public void setOnTopLoadDataListener(g paramg)
  {
    this.Wli = paramg;
  }
  
  public void setShowBackground(boolean paramBoolean)
  {
    this.WlM = paramBoolean;
  }
  
  public void setTopView(View paramView)
  {
    AppMethodBeat.i(142081);
    if (paramView == null)
    {
      this.Wly = 4;
      if (this.Wlv != null)
      {
        this.Wlv.setVisibility(4);
        AppMethodBeat.o(142081);
      }
    }
    else
    {
      removeViewAt(0);
      this.Wlv = paramView;
      this.Wlv.setVisibility(0);
      this.Wly = 0;
      addView(this.Wlv, 0, new FrameLayout.LayoutParams(-1, -2));
      this.Wlk = 0;
    }
    AppMethodBeat.o(142081);
  }
  
  public void setTopViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142084);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.Wly = i;
      if (this.Wlv != null) {
        this.Wlv.setVisibility(this.Wly);
      }
      Log.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(142084);
      return;
    }
  }
  
  public static abstract interface b
  {
    public abstract void daG();
  }
  
  public static abstract interface c
  {
    public abstract boolean cOL();
  }
  
  public static abstract interface d
  {
    public abstract boolean cOK();
  }
  
  public static abstract interface e
  {
    public abstract boolean cOJ();
  }
  
  public static abstract interface f
  {
    public abstract void cg(float paramFloat);
    
    public abstract void fXE();
  }
  
  public static abstract interface g
  {
    public abstract boolean cOM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPullDownView
 * JD-Core Version:    0.7.0.1
 */