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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.tools.k.a;

public class MMPullDownView
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  private static int OSv;
  private static final int OSy;
  public View GEr;
  private int OPU;
  private int OPi;
  private g ORV;
  private e ORW;
  private int ORX;
  private int ORY;
  private boolean ORZ;
  private int OSA;
  private b OSB;
  private boolean OSa;
  private boolean OSb;
  protected boolean OSc;
  private boolean OSd;
  private boolean OSe;
  private boolean OSf;
  private c OSg;
  private d OSh;
  public View OSi;
  private int OSj;
  private int OSk;
  private int OSl;
  private boolean OSm;
  private f OSn;
  private boolean OSo;
  private boolean OSp;
  public boolean OSq;
  private k OSr;
  private boolean OSs;
  private a OSt;
  private int OSu;
  private MMHandler OSw;
  boolean OSx;
  private boolean OSz;
  private int bgColor;
  protected Context context;
  private GestureDetector jKk;
  private Scroller mScroller;
  private boolean onY;
  
  static
  {
    AppMethodBeat.i(142100);
    OSv = 400;
    OSy = Color.parseColor("#00000000");
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
    this.OPU = 1;
    this.ORZ = false;
    this.OSa = false;
    this.onY = false;
    this.OSb = false;
    this.OSc = true;
    this.OSd = false;
    this.OSe = true;
    this.OSf = true;
    this.OSk = 4;
    this.OSl = 4;
    this.OSm = false;
    this.OSo = true;
    this.OSp = true;
    this.OSq = false;
    this.OSs = false;
    this.bgColor = MMApplicationContext.getContext().getResources().getColor(2131101424);
    this.OSu = this.bgColor;
    this.OSw = new MMHandler()
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
          Log.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", new Object[] { Integer.valueOf(MMPullDownView.a(MMPullDownView.this)), Boolean.valueOf(MMPullDownView.this.OSc) });
          AppMethodBeat.o(142076);
          return;
          if (MMPullDownView.b(MMPullDownView.this) != null) {
            MMPullDownView.this.OSc = MMPullDownView.b(MMPullDownView.this).cAm();
          }
          if ((MMPullDownView.this.OSc) && (MMPullDownView.c(MMPullDownView.this).getVisibility() == 0))
          {
            MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            continue;
            if (MMPullDownView.e(MMPullDownView.this) != null) {
              MMPullDownView.this.OSc = MMPullDownView.e(MMPullDownView.this).cAj();
            }
            if ((MMPullDownView.this.OSc) && (MMPullDownView.f(MMPullDownView.this).getVisibility() == 0)) {
              MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            }
          }
        }
      }
    };
    this.OSx = false;
    this.OSz = false;
    this.OSA = -2147483648;
    this.mScroller = new Scroller(paramContext, new AccelerateInterpolator());
    this.OPi = this.OPU;
    this.jKk = new GestureDetector(paramContext, this);
    this.OSr = new k(paramContext);
    this.context = paramContext;
    this.bgColor = paramContext.getResources().getColor(2131101424);
    this.OSu = this.bgColor;
    AppMethodBeat.o(142077);
  }
  
  private void gKT()
  {
    AppMethodBeat.i(142086);
    n((ViewGroup)this.OSi, 0);
    n((ViewGroup)this.GEr, 0);
    AppMethodBeat.o(142086);
  }
  
  private void gKU()
  {
    AppMethodBeat.i(142095);
    if (this.OSn != null) {
      this.OSn.fjr();
    }
    Scroller localScroller;
    int i;
    int j;
    if (getScrollY() - this.ORX < 0)
    {
      if (this.OSe)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.ORX + j, 200);
        postInvalidate();
      }
    }
    else if (getScrollY() > this.ORY)
    {
      if (!this.OSf) {
        break label230;
      }
      this.mScroller.startScroll(0, getScrollY(), 0, this.ORY - getScrollY(), 200);
    }
    for (;;)
    {
      postInvalidate();
      this.onY = false;
      AppMethodBeat.o(142095);
      return;
      if (this.OSi.getVisibility() == 4)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.ORX + j, 200);
      }
      if (this.OSi.getVisibility() == 0) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.OSj = 0;
      this.OSb = true;
      this.OSc = false;
      break;
      label230:
      if (this.GEr.getVisibility() == 4) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.ORY - getScrollY(), 200);
      }
      if (this.GEr.getVisibility() == 0)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = this.ORY;
        int k = getScrollY();
        localScroller.startScroll(0, i, 0, this.ORY + (j - k), 200);
      }
      this.OSj = 1;
      this.OSb = true;
      this.OSc = false;
    }
  }
  
  public static void n(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(142085);
    Log.i("MicroMsg.MMPullDownView", "fix android O progress bar bug. visibility=".concat(String.valueOf(paramInt)));
    if ((paramViewGroup != null) && (paramViewGroup.getVisibility() == 0))
    {
      if (paramViewGroup.getTag() == null) {
        paramViewGroup.setTag(paramViewGroup.findViewById(2131298501));
      }
      paramViewGroup = (View)paramViewGroup.getTag();
      if (paramViewGroup != null) {
        paramViewGroup.setVisibility(paramInt);
      }
    }
    AppMethodBeat.o(142085);
  }
  
  public void Bx(boolean paramBoolean)
  {
    AppMethodBeat.i(142093);
    Log.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.OSb), Boolean.valueOf(this.OSc), Boolean.valueOf(this.OSe), Integer.valueOf(getScrollY()) });
    Scroller localScroller;
    int i;
    int j;
    if (paramBoolean)
    {
      if (this.OSi != null) {
        this.OSi.setVisibility(this.OSl);
      }
      if (this.OSe)
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.ORX + j, 200);
        postInvalidate();
      }
    }
    for (;;)
    {
      if (!this.OSe) {
        gKT();
      }
      AppMethodBeat.o(142093);
      return;
      if ((this.OSi != null) && (this.OSi.getVisibility() == 4))
      {
        localScroller = this.mScroller;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.ORX + j, 200);
      }
      if ((this.OSi != null) && (this.OSi.getVisibility() == 0)) {
        this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.OSj = 0;
      this.OSb = true;
      this.OSc = false;
      break;
      if (!this.OSc)
      {
        this.OSc = true;
        this.OSb = false;
        if ((this.OSi != null) && (this.OSi.getVisibility() == 0)) {
          scrollTo(0, this.ORX);
        }
      }
      if ((this.OSi != null) && (this.OSi.getVisibility() == 0)) {
        this.OSi.setVisibility(8);
      }
    }
  }
  
  public final void By(boolean paramBoolean)
  {
    AppMethodBeat.i(142094);
    Log.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.OSb), Boolean.valueOf(this.OSc), Boolean.valueOf(this.OSf), Integer.valueOf(getScrollY()) });
    if (paramBoolean)
    {
      if (this.GEr != null) {
        this.GEr.setVisibility(this.OSl);
      }
      if (this.OSf) {
        this.mScroller.startScroll(0, getScrollY(), 0, this.ORY - getScrollY(), 200);
      }
      for (;;)
      {
        postInvalidate();
        AppMethodBeat.o(142094);
        return;
        if ((this.GEr != null) && (this.GEr.getVisibility() == 4)) {
          this.mScroller.startScroll(0, getScrollY(), 0, this.ORY - getScrollY(), 200);
        }
        if ((this.GEr != null) && (this.GEr.getVisibility() == 0))
        {
          Scroller localScroller = this.mScroller;
          int i = getScrollY();
          int j = this.ORY;
          int k = getScrollY();
          localScroller.startScroll(0, i, 0, this.ORY + (j - k), 200);
        }
        this.OSj = 1;
        this.OSb = true;
        this.OSc = false;
      }
    }
    if (!this.OSc)
    {
      this.OSc = true;
      this.OSb = false;
    }
    if ((this.GEr != null) && (this.GEr.getVisibility() == 0))
    {
      Log.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
      scrollTo(0, this.ORX);
    }
    if ((this.GEr != null) && (this.GEr.getVisibility() == 0)) {
      this.GEr.setVisibility(8);
    }
    AppMethodBeat.o(142094);
  }
  
  protected void cAG()
  {
    AppMethodBeat.i(142078);
    View localView1 = inflate(this.context, 2131495305, null);
    View localView2 = inflate(this.context, 2131495305, null);
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
      if (this.OSb)
      {
        Log.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
        this.OSb = false;
        this.OSw.sendEmptyMessageDelayed(0, OSv);
        gKT();
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142092);
    boolean bool;
    if (!this.OSp)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
    }
    if ((this.OSq) && (paramMotionEvent.getAction() == 2))
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
    }
    this.OSq = false;
    Object localObject = this.OSr;
    if (((k)localObject).Quy != null)
    {
      localObject = ((k)localObject).aYg;
      locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/ui/tools/MMGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/ui/tools/MMGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    if (!this.OSc)
    {
      AppMethodBeat.o(142092);
      return true;
    }
    if (this.OSh == null)
    {
      this.ORZ = false;
      if (this.OSg != null) {
        break label279;
      }
      this.OSa = false;
      label193:
      if (this.OSl == 0)
      {
        if (!this.OSe) {
          break label295;
        }
        this.OSi.setVisibility(4);
      }
      label215:
      if (this.OSk == 0)
      {
        if (!this.OSf) {
          break label306;
        }
        this.GEr.setVisibility(4);
      }
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() != 1) {
        break label317;
      }
      gKU();
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142092);
      return bool;
      this.ORZ = this.OSh.cAk();
      break;
      label279:
      this.OSa = this.OSg.cAl();
      break label193;
      label295:
      this.OSi.setVisibility(0);
      break label215;
      label306:
      this.GEr.setVisibility(0);
    }
    label317:
    if (paramMotionEvent.getAction() == 3)
    {
      gKU();
      if (this.OSs)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(142092);
        return bool;
      }
      AppMethodBeat.o(142092);
      return false;
    }
    localObject = this.jKk;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/ui/base/MMPullDownView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/ui/base/MMPullDownView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z"))
    {
      paramMotionEvent.setAction(3);
      this.OSx = true;
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
    return this.ORY;
  }
  
  public int getCurScreen()
  {
    return this.OPi;
  }
  
  public int getTopHeight()
  {
    return this.ORX;
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
    if (this.OSt != null) {
      this.OSt.onInterceptTouchEvent(paramMotionEvent);
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
    this.OSi = getChildAt(0);
    this.GEr = getChildAt(getChildCount() - 1);
    this.OSi.setVisibility(this.OSl);
    this.GEr.setVisibility(this.OSk);
    this.ORX = this.OSi.getHeight();
    this.ORY = this.GEr.getHeight();
    this.OSA = this.ORX;
    if ((!this.OSd) && (this.ORX != 0))
    {
      this.OSd = true;
      scrollTo(0, this.ORX);
    }
    AppMethodBeat.o(142088);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205238);
    b localb = new b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(205238);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142087);
    if (!this.OSm)
    {
      cAG();
      this.OSm = true;
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(142087);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(142098);
    if (paramFloat2 > 0.0F)
    {
      this.onY = true;
      if (Math.abs(paramFloat2) <= Math.abs(paramFloat1)) {
        break label141;
      }
    }
    label141:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.OSn != null)) {
        this.OSn.bY(paramFloat2);
      }
      if ((!this.OSa) || ((!this.onY) && (getScrollY() - this.ORX <= 0)) || (i == 0)) {
        break label324;
      }
      if ((this.OSo) || ((this.GEr.getVisibility() == 0) && ((!this.onY) || (getScrollY() < this.ORX * 2)))) {
        break label147;
      }
      AppMethodBeat.o(142098);
      return true;
      this.onY = false;
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
      Log.v("check", "moveUp:" + i + " distanceY:" + paramFloat2 + " scrollY:" + getScrollY());
      if ((getScrollY() + i >= this.ORX) || (this.onY)) {
        break label277;
      }
      j = this.ORX - getScrollY();
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
      if (!this.OSo)
      {
        j = i;
        if (getScrollY() + i >= this.ORX * 2) {
          j = this.ORX * 2 - getScrollY();
        }
      }
    }
    label324:
    if ((this.ORZ) && ((!this.onY) || (getScrollY() - this.ORX < 0)) && (i != 0))
    {
      if ((!this.OSo) && ((this.OSi.getVisibility() != 0) || ((!this.onY) && (getScrollY() <= 0))))
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
        if (getScrollY() + i <= this.ORX) {
          break label469;
        }
        j = this.ORX - getScrollY();
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
        if (!this.OSo)
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
    if (this.OSB != null) {
      this.OSB.cLT();
    }
    if (!this.OSz)
    {
      AppMethodBeat.o(142099);
      return;
    }
    if (this.OSA == -2147483648)
    {
      this.OSA = this.ORX;
      Log.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.OSA);
    }
    if ((paramInt2 <= this.OSA) && (this.OSu != OSy))
    {
      setBackgroundResource(2131233974);
      this.OSu = OSy;
      Log.d("MicroMsg.MMPullDownView", "onScrollChanged full");
      AppMethodBeat.o(142099);
      return;
    }
    if ((paramInt2 > this.OSA) && (this.OSu != this.bgColor))
    {
      Log.d("MicroMsg.MMPullDownView", "onScrollChanged white");
      setBackgroundColor(this.bgColor);
      this.OSu = this.bgColor;
    }
    AppMethodBeat.o(142099);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205239);
    b localb = new b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(205239);
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
      if (getScrollY() - this.ORX < 0) {
        this.ORZ = true;
      }
      if (getScrollY() > this.ORY) {
        this.OSa = true;
      }
      gKU();
    }
  }
  
  public void setAtBottomCallBack(c paramc)
  {
    this.OSg = paramc;
  }
  
  public void setAtTopCallBack(d paramd)
  {
    this.OSh = paramd;
  }
  
  public void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
    this.OSu = this.bgColor;
  }
  
  public void setBottomView(View paramView)
  {
    AppMethodBeat.i(142082);
    if (paramView == null)
    {
      this.OSk = 4;
      if (this.GEr != null)
      {
        this.GEr.setVisibility(4);
        AppMethodBeat.o(142082);
      }
    }
    else
    {
      this.GEr = paramView;
      this.GEr.setVisibility(0);
      this.OSk = 0;
      removeViewAt(getChildCount() - 1);
      addView(this.GEr, new FrameLayout.LayoutParams(-1, -2));
      this.ORY = 0;
    }
    AppMethodBeat.o(142082);
  }
  
  public void setBottomViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142083);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.OSk = i;
      if (this.GEr != null) {
        this.GEr.setVisibility(this.OSk);
      }
      Log.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Util.getStack() });
      AppMethodBeat.o(142083);
      return;
    }
  }
  
  public void setCanOverScrool(boolean paramBoolean)
  {
    this.OSo = paramBoolean;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.OSp = paramBoolean;
  }
  
  public void setIsBottomShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142080);
    Log.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.OSf), Util.getStack() });
    this.OSf = paramBoolean;
    AppMethodBeat.o(142080);
  }
  
  public void setIsReturnSuperDispatchWhenCancel(boolean paramBoolean)
  {
    this.OSs = paramBoolean;
  }
  
  public void setIsTopShowAll(boolean paramBoolean)
  {
    AppMethodBeat.i(142079);
    Log.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.OSe), Util.getStack() });
    this.OSe = paramBoolean;
    AppMethodBeat.o(142079);
  }
  
  public void setOnBottomLoadDataListener(e parame)
  {
    this.ORW = parame;
  }
  
  public void setOnInterceptTouchEventListener(a parama)
  {
    this.OSt = parama;
  }
  
  public void setOnMMFlingListener(k.a parama)
  {
    this.OSr.Quy = parama;
  }
  
  public void setOnScrollChangedListener(b paramb)
  {
    this.OSB = paramb;
  }
  
  public void setOnSrcollDistance(f paramf)
  {
    this.OSn = paramf;
  }
  
  public void setOnTopLoadDataListener(g paramg)
  {
    this.ORV = paramg;
  }
  
  public void setShowBackground(boolean paramBoolean)
  {
    this.OSz = paramBoolean;
  }
  
  public void setTopView(View paramView)
  {
    AppMethodBeat.i(142081);
    if (paramView == null)
    {
      this.OSl = 4;
      if (this.OSi != null)
      {
        this.OSi.setVisibility(4);
        AppMethodBeat.o(142081);
      }
    }
    else
    {
      removeViewAt(0);
      this.OSi = paramView;
      this.OSi.setVisibility(0);
      this.OSl = 0;
      addView(this.OSi, 0, new FrameLayout.LayoutParams(-1, -2));
      this.ORX = 0;
    }
    AppMethodBeat.o(142081);
  }
  
  public void setTopViewVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(142084);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.OSl = i;
      if (this.OSi != null) {
        this.OSi.setVisibility(this.OSl);
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
    public abstract void cLT();
  }
  
  public static abstract interface c
  {
    public abstract boolean cAl();
  }
  
  public static abstract interface d
  {
    public abstract boolean cAk();
  }
  
  public static abstract interface e
  {
    public abstract boolean cAj();
  }
  
  public static abstract interface f
  {
    public abstract void bY(float paramFloat);
    
    public abstract void fjr();
  }
  
  public static abstract interface g
  {
    public abstract boolean cAm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMPullDownView
 * JD-Core Version:    0.7.0.1
 */