package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.lang.ref.WeakReference;

public class MMViewPager
  extends WxViewPager
{
  private float CBe;
  private float CBf;
  private VelocityTracker CBg;
  private boolean EHq;
  private boolean EHr;
  private boolean EHs;
  private View.OnTouchListener HeV;
  private g OTU;
  public l OTV;
  private boolean OTW;
  private boolean OTX;
  private boolean OTY;
  private boolean OTZ;
  private boolean OUa;
  private int OUb;
  private b OUc;
  private f OUd;
  private MMViewPager.d OUe;
  private MMViewPager.a OUf;
  private boolean OUg;
  private ViewPager.OnPageChangeListener OUh;
  private float OUi;
  private boolean OUj;
  private MotionEvent OUk;
  private long OUl;
  private boolean OUm;
  private c OUn;
  private GestureDetector.SimpleOnGestureListener OUo;
  private View.OnLongClickListener OUp;
  private final int OUq;
  private final int OUr;
  private float aZg;
  private float aZh;
  private int afB;
  private int apZ;
  private int auo;
  private int aup;
  private float dhm;
  private MMHandler handler;
  private GestureDetector mDJ;
  private int mEX;
  private int mEY;
  private VelocityTracker mVelocityTracker;
  private WxImageView xpO;
  private boolean xsN;
  private OverScroller xsO;
  private RectF xsQ;
  private float xsS;
  private boolean xsT;
  private boolean xsU;
  private boolean xsV;
  private boolean xsW;
  
  public MMViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142287);
    this.apZ = -1;
    this.afB = -1;
    this.xsN = false;
    this.OTW = false;
    this.OTX = false;
    this.OTY = false;
    this.OTZ = false;
    this.OUa = false;
    this.xsT = false;
    this.xsU = false;
    this.xsV = false;
    this.xsW = false;
    this.xsQ = new RectF();
    this.OUb = 0;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.OUg = false;
    this.OUh = null;
    this.OUi = 0.0F;
    this.CBg = null;
    this.OUj = false;
    this.OUl = 0L;
    this.aZg = 0.0F;
    this.aZh = 0.0F;
    this.EHq = false;
    this.EHr = false;
    this.EHs = false;
    this.OUm = true;
    this.OUo = new e((byte)0);
    this.OUp = new MMViewPager.3(this);
    this.OUq = 60;
    this.OUr = 500;
    setStaticTransformationsEnabled(true);
    this.OTV = new l(new WeakReference(this));
    this.mDJ = new GestureDetector(paramContext, new e((byte)0));
    this.xsO = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    this.OUb = ((int)(getResources().getDisplayMetrics().density * 3000.0F));
    super.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(142260);
        if (MMViewPager.f(MMViewPager.this) != null) {
          MMViewPager.f(MMViewPager.this).onPageScrollStateChanged(paramAnonymousInt);
        }
        if (paramAnonymousInt == 0) {
          MMViewPager.a(MMViewPager.this, 0.0F);
        }
        AppMethodBeat.o(142260);
      }
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        AppMethodBeat.i(142259);
        if (MMViewPager.f(MMViewPager.this) != null) {
          MMViewPager.f(MMViewPager.this).onPageScrolled(paramAnonymousInt1, paramAnonymousFloat, paramAnonymousInt2);
        }
        MMViewPager.a(MMViewPager.this, paramAnonymousFloat);
        if ((paramAnonymousInt2 == 0) && (MMViewPager.j(MMViewPager.this) != -1)) {
          MMViewPager.c(MMViewPager.this, MMViewPager.j(MMViewPager.this));
        }
        AppMethodBeat.o(142259);
      }
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(142258);
        MMViewPager.a(MMViewPager.this, MMViewPager.e(MMViewPager.this));
        MMViewPager.b(MMViewPager.this, paramAnonymousInt);
        if (MMViewPager.f(MMViewPager.this) != null) {
          MMViewPager.f(MMViewPager.this).onPageSelected(paramAnonymousInt);
        }
        if (MMViewPager.g(MMViewPager.this))
        {
          MMViewPager.h(MMViewPager.this);
          AppMethodBeat.o(142258);
          return;
        }
        MMViewPager.i(MMViewPager.this);
        AppMethodBeat.o(142258);
      }
    });
    super.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142261);
        Log.d("MicroMsg.MMViewPager", "alvinluo onTouch getCurrentItem: %d", new Object[] { Integer.valueOf(MMViewPager.this.getCurrentItem()) });
        if (MMViewPager.k(MMViewPager.this) != null) {}
        for (boolean bool1 = MMViewPager.k(MMViewPager.this).onTouch(paramAnonymousView, paramAnonymousMotionEvent);; bool1 = false)
        {
          paramAnonymousView = MMViewPager.this.getSelectedImageView();
          if (paramAnonymousView == null)
          {
            MMViewPager.a(MMViewPager.this, paramAnonymousMotionEvent);
            MMViewPager.b(MMViewPager.this, null);
            paramAnonymousView = MMViewPager.l(MMViewPager.this);
            paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousMotionEvent.axQ(), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.pG(0)), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            if ((MMViewPager.m(MMViewPager.this)) || (MMViewPager.n(MMViewPager.this)))
            {
              AppMethodBeat.o(142261);
              return true;
            }
            AppMethodBeat.o(142261);
            return bool1;
          }
          MMViewPager.a(MMViewPager.this, paramAnonymousView);
          boolean bool2 = MMViewPager.c(MMViewPager.this, paramAnonymousMotionEvent);
          if (MMViewPager.o(MMViewPager.this) != null) {
            MMViewPager.o(MMViewPager.this).recycle();
          }
          MMViewPager.b(MMViewPager.this, MotionEvent.obtainNoHistory(paramAnonymousMotionEvent));
          paramAnonymousView = MMViewPager.l(MMViewPager.this);
          paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousMotionEvent.axQ(), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.pG(0)), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          MMViewPager.this.computeScroll();
          if ((bool2) || (bool1))
          {
            AppMethodBeat.o(142261);
            return true;
          }
          AppMethodBeat.o(142261);
          return false;
        }
      }
    });
    AppMethodBeat.o(142287);
  }
  
  public MMViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142284);
    this.apZ = -1;
    this.afB = -1;
    this.xsN = false;
    this.OTW = false;
    this.OTX = false;
    this.OTY = false;
    this.OTZ = false;
    this.OUa = false;
    this.xsT = false;
    this.xsU = false;
    this.xsV = false;
    this.xsW = false;
    this.xsQ = new RectF();
    this.OUb = 0;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.OUg = false;
    this.OUh = null;
    this.OUi = 0.0F;
    this.CBg = null;
    this.OUj = false;
    this.OUl = 0L;
    this.aZg = 0.0F;
    this.aZh = 0.0F;
    this.EHq = false;
    this.EHr = false;
    this.EHs = false;
    this.OUm = true;
    this.OUo = new e((byte)0);
    this.OUp = new MMViewPager.3(this);
    this.OUq = 60;
    this.OUr = 500;
    setStaticTransformationsEnabled(true);
    AppMethodBeat.o(142284);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, View paramView, float paramFloat3)
  {
    AppMethodBeat.i(142296);
    if (b(paramFloat2, paramView, paramFloat3))
    {
      AppMethodBeat.o(142296);
      return true;
    }
    if (a(paramFloat1, paramView, paramFloat3))
    {
      AppMethodBeat.o(142296);
      return true;
    }
    AppMethodBeat.o(142296);
    return false;
  }
  
  private boolean a(float paramFloat1, View paramView, float paramFloat2)
  {
    AppMethodBeat.i(142294);
    if ((getAdapter().getItemPosition(paramView) == firstItemPosForDetermine()) || (this.OUg))
    {
      if ((this.OTU instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.OTU).getTranslationX();
        paramFloat2 *= 0.3F;
        Log.d("MicroMsg.MMViewPager", "alvinluo scrollFirst current is WxImageView, distanceX: %f, translateLeft: %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
        if ((paramFloat2 < 0.0F) && (paramFloat1 - paramFloat2 > 0.0F)) {
          this.OTZ = true;
        }
        if (this.OTZ)
        {
          ((WxImageView)this.OTU).translate(-paramFloat2, 0.0F);
          AppMethodBeat.o(142294);
          return true;
        }
        AppMethodBeat.o(142294);
        return false;
      }
      if (this.OTZ)
      {
        if (paramFloat2 < 0.0F)
        {
          if (paramFloat1 > this.xsQ.left) {
            break label182;
          }
          this.OTU.au(-paramFloat2, 0.0F);
        }
        label182:
        do
        {
          AppMethodBeat.o(142294);
          return false;
          if ((paramFloat1 > this.xsQ.left) && (paramFloat1 < this.mEX * 0.3F))
          {
            this.OTU.au(-(paramFloat2 * 0.3F), 0.0F);
            AppMethodBeat.o(142294);
            return true;
          }
        } while ((!this.OUg) || (paramFloat1 <= this.xsQ.left));
        this.OTU.au(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142294);
        return true;
      }
      if (paramFloat2 < 0.0F)
      {
        if (paramFloat1 > 0.0F) {
          this.OTZ = true;
        }
        if (paramFloat1 > this.xsQ.left) {
          break label338;
        }
        this.OTU.au(-paramFloat2, 0.0F);
      }
    }
    while ((this.OTY) || (this.OTX))
    {
      AppMethodBeat.o(142294);
      return false;
      label338:
      if ((paramFloat1 > this.xsQ.left) && (paramFloat1 < this.mEX * 0.3F))
      {
        this.OTU.au(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142294);
        return true;
      }
      if ((this.OUg) && (paramFloat1 > this.xsQ.left))
      {
        this.OTU.au(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142294);
        return true;
      }
    }
    this.OTZ = false;
    AppMethodBeat.o(142294);
    return false;
  }
  
  private boolean b(float paramFloat1, View paramView, float paramFloat2)
  {
    AppMethodBeat.i(142295);
    if ((getAdapter().getItemPosition(paramView) == lastItemPosForDetermine()) || (this.OUg))
    {
      if ((this.OTU instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.OTU).getTranslationX();
        paramFloat2 *= 0.3F;
        if ((paramFloat2 > 0.0F) && (paramFloat1 - paramFloat2 < 0.0F)) {
          this.OUa = true;
        }
        if (this.OUa)
        {
          ((WxImageView)this.OTU).translate(-paramFloat2, 0.0F);
          AppMethodBeat.o(142295);
          return true;
        }
        AppMethodBeat.o(142295);
        return false;
      }
      if (this.OUa)
      {
        if (paramFloat2 > 0.0F)
        {
          if (paramFloat1 < this.mEX) {
            break label153;
          }
          this.OTU.au(-paramFloat2, 0.0F);
        }
        for (;;)
        {
          AppMethodBeat.o(142295);
          return false;
          label153:
          if ((paramFloat1 > this.mEX * 0.7F) && (paramFloat1 < this.mEX))
          {
            this.OTU.au(-(paramFloat2 * 0.3F), 0.0F);
            AppMethodBeat.o(142295);
            return true;
          }
          if ((this.OUg) && (paramFloat1 < this.mEX)) {
            this.OTU.au(-(paramFloat2 * 0.3F), 0.0F);
          }
        }
      }
      if (paramFloat2 > 0.0F)
      {
        if (paramFloat1 < this.mEX) {
          this.OUa = true;
        }
        if (paramFloat1 < this.mEX) {
          break label302;
        }
        this.OTU.au(-paramFloat2, 0.0F);
      }
    }
    while ((this.OTY) || (this.OTX))
    {
      AppMethodBeat.o(142295);
      return false;
      label302:
      if ((paramFloat1 > this.mEX * 0.7F) && (paramFloat1 < this.mEX))
      {
        this.OTU.au(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142295);
        return true;
      }
      if ((this.OUg) && (paramFloat1 < this.mEX)) {
        this.OTU.au(-(paramFloat2 * 0.3F), 0.0F);
      }
    }
    this.OUa = false;
    AppMethodBeat.o(142295);
    return false;
  }
  
  private static boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    AppMethodBeat.i(142303);
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null))
    {
      AppMethodBeat.o(142303);
      return false;
    }
    if (paramMotionEvent1.getX() - paramMotionEvent2.getX() < 0.0F)
    {
      AppMethodBeat.o(142303);
      return true;
    }
    AppMethodBeat.o(142303);
    return false;
  }
  
  private void dSC()
  {
    AppMethodBeat.i(142285);
    this.OTV.removeMessages(1);
    AppMethodBeat.o(142285);
  }
  
  private void dSD()
  {
    AppMethodBeat.i(142286);
    dSC();
    l locall = this.OTV;
    locall.xtj = 15L;
    locall.sendEmptyMessageDelayed(1, 15L);
    AppMethodBeat.o(142286);
  }
  
  private void gLk()
  {
    AppMethodBeat.i(142288);
    this.xpO = getSelectedWxImageView();
    if (this.xpO != null)
    {
      Log.d("MicroMsg.MMViewPager", "alvinluo ViewPager initWxImageView");
      this.xpO.setGestureDetectorListener(this.OUo);
      this.xpO.setOnLongClickListener(this.OUp);
    }
    AppMethodBeat.o(142288);
  }
  
  private boolean gLl()
  {
    AppMethodBeat.i(142289);
    g localg = getSelectedImageView();
    if ((localg != null) && ((localg instanceof WxImageView)))
    {
      AppMethodBeat.o(142289);
      return true;
    }
    AppMethodBeat.o(142289);
    return false;
  }
  
  private boolean gLm()
  {
    AppMethodBeat.i(142293);
    Log.d("MicroMsg.MMViewPager", "dancy scroll left right !!");
    if (this.OTX)
    {
      AppMethodBeat.o(142293);
      return true;
    }
    this.OTY = true;
    AppMethodBeat.o(142293);
    return false;
  }
  
  private int getCurrentX()
  {
    AppMethodBeat.i(142302);
    if (getAdapter() == null)
    {
      AppMethodBeat.o(142302);
      return -1;
    }
    int i = getScrollX();
    int j = this.mEX;
    int k = getAdapter().getCount();
    int m = getCurrentItem();
    AppMethodBeat.o(142302);
    return i - j * (k - m - 1);
  }
  
  private MultiTouchImageView getSelectedMultiTouchImageView()
  {
    AppMethodBeat.i(142299);
    int i = getCurrentItem();
    MultiTouchImageView localMultiTouchImageView = ((v)getAdapter()).NQ(i);
    AppMethodBeat.o(142299);
    return localMultiTouchImageView;
  }
  
  private WxImageView getSelectedWxImageView()
  {
    AppMethodBeat.i(142300);
    int i = getCurrentItem();
    WxImageView localWxImageView = ((v)getAdapter()).NR(i);
    if (localWxImageView != null)
    {
      localWxImageView = (WxImageView)localWxImageView;
      AppMethodBeat.o(142300);
      return localWxImageView;
    }
    AppMethodBeat.o(142300);
    return null;
  }
  
  public void computeScroll()
  {
    int m = 0;
    AppMethodBeat.i(142304);
    super.computeScroll();
    if (this.OTU == null)
    {
      AppMethodBeat.o(142304);
      return;
    }
    float f3 = this.OTU.getScale();
    float f4 = this.OTU.getImageWidth();
    float f1 = this.OTU.getScale() * this.OTU.getImageHeight();
    float f5;
    int j;
    int k;
    if (this.xsO.computeScrollOffset())
    {
      i = this.xsO.getCurrX() - this.auo;
      int n = this.xsO.getCurrY() - this.aup;
      this.auo = this.xsO.getCurrX();
      this.aup = this.xsO.getCurrY();
      float[] arrayOfFloat = new float[9];
      this.OTU.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f3 * f4 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.xsQ.right - Math.round(f3)) {
          j = (int)(this.xsQ.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.xsQ.left - Math.round(f2)) {
          i = (int)(this.xsQ.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.xsQ.bottom - Math.round(f5)) {
          k = (int)(this.xsQ.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.xsQ.top - Math.round(f4)) {
          j = (int)(this.xsQ.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.xsQ.left) && (Math.round(f3) > this.xsQ.right)) {
        break label449;
      }
      k = 0;
      if (f1 >= this.mEY) {
        break label497;
      }
    }
    label449:
    label497:
    for (int i = m;; i = j)
    {
      this.OTU.au(k, i);
      postInvalidate();
      AppMethodBeat.o(142304);
      return;
      if (Math.round(f4) < this.xsQ.top)
      {
        k = i;
        if (Math.round(f5) > this.xsQ.bottom) {
          break;
        }
      }
      j = 0;
      k = i;
      break;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142290);
    try
    {
      Log.d("MicroMsg.MMViewPager", "alvinluo dispatchTouchEvent action: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
      if (this.xpO == null) {
        gLk();
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142290);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      Log.printErrStackTrace("MicroMsg.MMViewPager", paramMotionEvent, "alvinluo MMViewPager dispatchTouchEvent exception", new Object[0]);
      AppMethodBeat.o(142290);
    }
    return false;
  }
  
  public int firstItemPosForDetermine()
  {
    AppMethodBeat.i(142307);
    int i = ((v)getAdapter()).firstItemPosForDetermine();
    if (i >= 0)
    {
      AppMethodBeat.o(142307);
      return i;
    }
    i = super.firstItemPosForDetermine();
    AppMethodBeat.o(142307);
    return i;
  }
  
  public int getScreenWidth()
  {
    return this.mEX;
  }
  
  public g getSelectedImageView()
  {
    AppMethodBeat.i(142298);
    Object localObject = getSelectedMultiTouchImageView();
    if (localObject != null)
    {
      AppMethodBeat.o(142298);
      return localObject;
    }
    localObject = getSelectedWxImageView();
    AppMethodBeat.o(142298);
    return localObject;
  }
  
  public View getSelectedView()
  {
    AppMethodBeat.i(142297);
    int i = getCurrentItem();
    View localView = ((v)getAdapter()).abm(i);
    AppMethodBeat.o(142297);
    return localView;
  }
  
  public int getXDown()
  {
    return (int)this.aZg;
  }
  
  public int getYDown()
  {
    return (int)this.aZh;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  public int lastItemPosForDetermine()
  {
    AppMethodBeat.i(142308);
    int i = ((v)getAdapter()).lastItemPosForDetermine();
    if (i >= 0)
    {
      AppMethodBeat.o(142308);
      return i;
    }
    i = super.lastItemPosForDetermine();
    AppMethodBeat.o(142308);
    return i;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(142305);
    if (paramBoolean) {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
    }
    AppMethodBeat.o(142305);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142291);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    this.OUj = false;
    if (!gLl())
    {
      AppMethodBeat.o(142291);
      return bool;
    }
    if (bool)
    {
      AppMethodBeat.o(142291);
      return bool;
    }
    if (this.CBg == null) {
      this.CBg = VelocityTracker.obtain();
    }
    this.CBg.addMovement(paramMotionEvent);
    VelocityTracker localVelocityTracker = this.CBg;
    localVelocityTracker.computeCurrentVelocity(1000);
    int i = (int)localVelocityTracker.getXVelocity();
    int j = (int)localVelocityTracker.getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if (bool)
      {
        this.aZg = paramMotionEvent.getRawX();
        this.aZh = paramMotionEvent.getRawY();
        this.xsS = this.xpO.getScale();
      }
      this.OUj = bool;
      AppMethodBeat.o(142291);
      return bool;
      this.CBe = paramMotionEvent.getRawX();
      this.CBf = paramMotionEvent.getRawY();
      bool = false;
      continue;
      if (this.OUg)
      {
        bool = true;
      }
      else
      {
        float f = paramMotionEvent.getRawX() - this.CBe;
        Log.d("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f), Float.valueOf(paramMotionEvent.getRawY() - this.CBf), Integer.valueOf(i), Integer.valueOf(j) });
        if ((Math.abs(f) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (Math.abs(j) > 0))
        {
          Log.i("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action: %d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
          bool = true;
        }
        else
        {
          bool = false;
          continue;
          bool = false;
        }
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(142292);
    super.onMeasure(paramInt1, paramInt2);
    this.mEX = View.MeasureSpec.getSize(paramInt1);
    this.mEY = View.MeasureSpec.getSize(paramInt2);
    this.xsQ.set(0.0F, 0.0F, this.mEX, this.mEY);
    AppMethodBeat.o(142292);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(142306);
    if (paramBoolean) {
      super.onWindowFocusChanged(paramBoolean);
    }
    AppMethodBeat.o(142306);
  }
  
  public void setAdapter(q paramq)
  {
    AppMethodBeat.i(142301);
    if ((paramq instanceof v))
    {
      super.setAdapter(paramq);
      AppMethodBeat.o(142301);
      return;
    }
    paramq = new IllegalArgumentException("must be MMViewPagerAdapter");
    AppMethodBeat.o(142301);
    throw paramq;
  }
  
  public void setDoubleClickListener(MMViewPager.a parama)
  {
    this.OUf = parama;
  }
  
  public void setEnableGalleryScale(boolean paramBoolean)
  {
    this.OUm = paramBoolean;
  }
  
  public void setGalleryScaleListener(c paramc)
  {
    this.OUn = paramc;
  }
  
  public void setLongClickOverListener(MMViewPager.d paramd)
  {
    this.OUe = paramd;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.OUh = paramOnPageChangeListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.HeV = paramOnTouchListener;
  }
  
  public void setSingleClickOverListener(f paramf)
  {
    this.OUd = paramf;
  }
  
  public void setSingleMode(boolean paramBoolean)
  {
    this.OUg = paramBoolean;
  }
  
  abstract class b
  {
    protected boolean dgZ = false;
    
    public b() {}
    
    public final boolean deQ()
    {
      return this.dgZ;
    }
    
    public abstract void play();
  }
  
  public static abstract interface c
  {
    public abstract void S(float paramFloat1, float paramFloat2);
    
    public abstract void ao(float paramFloat1, float paramFloat2);
  }
  
  final class e
    extends GestureDetector.SimpleOnGestureListener
  {
    private e() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205254);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(205254);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(142266);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      if (MMViewPager.a(MMViewPager.this) == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(142266);
        return false;
      }
      if ((MMViewPager.t(MMViewPager.this) != null) && (MMViewPager.t(MMViewPager.this).ab(paramMotionEvent)))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(142266);
        return true;
      }
      if (MMViewPager.a(MMViewPager.this).getScale() <= MMViewPager.a(MMViewPager.this).getScaleRate()) {
        MMViewPager.a(MMViewPager.this).y(f.j(paramMotionEvent, 0), f.k(paramMotionEvent, 0));
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(142266);
        return true;
        MMViewPager.a(MMViewPager.this).at(f.j(paramMotionEvent, 0), f.k(paramMotionEvent, 0));
      }
    }
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(142264);
      if (MMViewPager.r(MMViewPager.this) != null) {
        MMViewPager.r(MMViewPager.this).forceFinished(true);
      }
      boolean bool = super.onDown(paramMotionEvent);
      AppMethodBeat.o(142264);
      return bool;
    }
    
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(142267);
      Log.d("MicroMsg.MMViewPager", "onFling");
      Object localObject2 = MMViewPager.this.getSelectedImageView();
      Object localObject1;
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      if (localObject2 != null)
      {
        Log.d("MicroMsg.MMViewPager", "onFling MultiTouchImageView");
        if ((localObject2 instanceof MultiTouchImageView))
        {
          localObject1 = (MultiTouchImageView)localObject2;
          f2 = ((g)localObject1).getScale() * ((g)localObject1).getImageWidth();
          f3 = ((g)localObject1).getScale() * ((g)localObject1).getImageHeight();
          if ((!((g)localObject1).gKw()) && (!((g)localObject1).gKx()) && ((int)f2 <= MMViewPager.b(MMViewPager.this)) && ((int)f3 <= MMViewPager.d(MMViewPager.this))) {
            break label485;
          }
          localObject2 = new float[9];
          ((g)localObject1).getImageMatrix().getValues((float[])localObject2);
          f4 = localObject2[2];
          f5 = f4 + f2;
          f6 = localObject2[5];
          Log.d("MicroMsg.MMViewPager", "left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", new Object[] { Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(MMViewPager.c(paramMotionEvent1, paramMotionEvent2)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
          if ((Math.round(f4) < MMViewPager.u(MMViewPager.this).left) && (Math.round(f5) > MMViewPager.u(MMViewPager.this).right)) {
            break label522;
          }
        }
      }
      label522:
      for (float f1 = 0.0F;; f1 = paramFloat1)
      {
        if ((Math.round(f6) >= MMViewPager.u(MMViewPager.this).top) || (Math.round(f6 + f3) <= MMViewPager.u(MMViewPager.this).bottom)) {
          paramFloat2 = 0.0F;
        }
        int i = (int)(MMViewPager.u(MMViewPager.this).right - f2);
        int j = (int)(MMViewPager.u(MMViewPager.this).right + f2);
        int k = (int)(MMViewPager.u(MMViewPager.this).bottom - f3);
        int m = (int)(MMViewPager.u(MMViewPager.this).bottom + f3);
        MMViewPager.r(MMViewPager.this).fling(MMViewPager.r(MMViewPager.this).getCurrX(), MMViewPager.r(MMViewPager.this).getCurrY(), (int)f1, (int)paramFloat2, i, j, k, m, 0, 0);
        if (((!MMViewPager.c(paramMotionEvent1, paramMotionEvent2)) || (f4 < 0.0F)) && ((MMViewPager.c(paramMotionEvent1, paramMotionEvent2)) || (f5 > MMViewPager.b(MMViewPager.this))))
        {
          AppMethodBeat.o(142267);
          return false;
          localObject1 = localObject2;
          if (!(localObject2 instanceof WxImageView)) {
            break;
          }
          localObject1 = (WxImageView)localObject2;
          break;
        }
        label485:
        if (MMViewPager.m(MMViewPager.this))
        {
          AppMethodBeat.o(142267);
          return false;
        }
        boolean bool = MMViewPager.a(MMViewPager.this, paramMotionEvent1, paramMotionEvent2, paramFloat1);
        AppMethodBeat.o(142267);
        return bool;
      }
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(142265);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
      MMViewPager.s(MMViewPager.this);
      if (MMViewPager.p(MMViewPager.this) != null) {
        MMViewPager.p(MMViewPager.this).bmu();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(142265);
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(142263);
      if (MMViewPager.q(MMViewPager.this) != null) {
        MMViewPager.q(MMViewPager.this).bmt();
      }
      AppMethodBeat.o(142263);
      return true;
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205253);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(205253);
      return bool;
    }
  }
  
  public static abstract interface f
  {
    public abstract void bmt();
    
    public abstract void dSr();
  }
  
  final class g
    extends MMViewPager.b
  {
    float[] xtd;
    
    public g()
    {
      super();
      AppMethodBeat.i(142269);
      this.xtd = new float[9];
      AppMethodBeat.o(142269);
    }
    
    public final void play()
    {
      AppMethodBeat.i(142270);
      MMViewPager.c(MMViewPager.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(142268);
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.g.this.xtd);
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f2 = MMViewPager.a(MMViewPager.this).getImageHeight() * f1;
          float f3 = MMViewPager.g.this.xtd[5];
          f1 = MMViewPager.d(MMViewPager.this);
          if (f2 < MMViewPager.d(MMViewPager.this)) {
            f1 = MMViewPager.d(MMViewPager.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
            f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationY();
          }
          if (f1 <= 0.0F) {
            MMViewPager.g.this.dgZ = true;
          }
          for (;;)
          {
            MMViewPager.a(MMViewPager.this).au(0.0F, f1);
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              ((WxImageView)MMViewPager.a(MMViewPager.this)).translate(0.0F, f1);
            }
            AppMethodBeat.o(142268);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMViewPager.g.this.dgZ = true;
            } else {
              f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      AppMethodBeat.o(142270);
    }
  }
  
  final class h
    extends MMViewPager.b
  {
    float[] xtd;
    
    public h()
    {
      super();
      AppMethodBeat.i(142272);
      this.xtd = new float[9];
      AppMethodBeat.o(142272);
    }
    
    public final void play()
    {
      AppMethodBeat.i(142273);
      MMViewPager.c(MMViewPager.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(142271);
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.h.this.xtd);
          float f5 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageWidth();
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f8 = MMViewPager.a(MMViewPager.this).getImageHeight() * f1;
          float f7 = MMViewPager.h.this.xtd[2];
          float f10 = MMViewPager.h.this.xtd[5];
          float f6 = MMViewPager.h.this.xtd[2];
          float f9 = MMViewPager.h.this.xtd[5];
          float f2 = 0.0F;
          f1 = MMViewPager.d(MMViewPager.this);
          float f3 = 0.0F;
          float f4 = MMViewPager.b(MMViewPager.this);
          if (f8 < MMViewPager.d(MMViewPager.this))
          {
            f2 = MMViewPager.d(MMViewPager.this) / 2.0F - f8 / 2.0F;
            f1 = MMViewPager.d(MMViewPager.this) / 2.0F + f8 / 2.0F;
          }
          for (;;)
          {
            f2 -= f10;
            f1 -= f9 + f8;
            if (f2 < 0.0F) {
              f1 = f2;
            }
            for (;;)
            {
              if (f5 < MMViewPager.b(MMViewPager.this))
              {
                f3 = MMViewPager.b(MMViewPager.this) / 2.0F;
                f4 = f5 / 2.0F;
                f2 = MMViewPager.b(MMViewPager.this) / 2.0F + f5 / 2.0F;
                f3 -= f4;
              }
              for (;;)
              {
                f3 -= f7;
                f2 -= f6 + f5;
                if (f3 < 0.0F) {
                  f2 = f3;
                }
                for (;;)
                {
                  label331:
                  if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView))
                  {
                    f2 = ((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationX();
                    f1 = ((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationY();
                  }
                  if ((Math.abs(f2) <= 5.0F) && (Math.abs(f1) <= 5.0F)) {
                    MMViewPager.h.this.dgZ = true;
                  }
                  for (;;)
                  {
                    MMViewPager.a(MMViewPager.this).au(f2, f1);
                    if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
                      ((WxImageView)MMViewPager.a(MMViewPager.this)).translate(-f2, -f1);
                    }
                    AppMethodBeat.o(142271);
                    return;
                    if (f1 <= 0.0F) {
                      break label624;
                    }
                    break;
                    if (f2 <= 0.0F) {
                      break label613;
                    }
                    break label331;
                    if (f2 >= 0.0F) {}
                    for (f2 = (float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F;; f2 = -(float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F)
                    {
                      if (f1 < 0.0F) {
                        break label583;
                      }
                      f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                      break;
                    }
                    label583:
                    f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                  }
                  label613:
                  f2 = 0.0F;
                }
                f2 = f4;
              }
              label624:
              f1 = 0.0F;
            }
          }
        }
      });
      AppMethodBeat.o(142273);
    }
  }
  
  final class i
    extends MMViewPager.b
  {
    float[] xtd;
    
    public i()
    {
      super();
      AppMethodBeat.i(142275);
      this.xtd = new float[9];
      AppMethodBeat.o(142275);
    }
    
    public final void play()
    {
      AppMethodBeat.i(142276);
      MMViewPager.c(MMViewPager.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(142274);
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.i.this.xtd);
          float f2 = MMViewPager.i.this.xtd[2];
          float f1 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageWidth();
          if (f1 < MMViewPager.b(MMViewPager.this)) {}
          for (f1 = MMViewPager.b(MMViewPager.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationX();
            }
            if (f1 >= 0.0F) {
              MMViewPager.i.this.dgZ = true;
            }
            for (;;)
            {
              MMViewPager.a(MMViewPager.this).au(f1, 0.0F);
              if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
                ((WxImageView)MMViewPager.a(MMViewPager.this)).translate(f1, 0.0F);
              }
              AppMethodBeat.o(142274);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMViewPager.i.this.dgZ = true;
              } else {
                f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
              }
            }
          }
        }
      });
      AppMethodBeat.o(142276);
    }
  }
  
  final class j
    extends MMViewPager.b
  {
    float[] xtd;
    
    public j()
    {
      super();
      AppMethodBeat.i(142278);
      this.xtd = new float[9];
      AppMethodBeat.o(142278);
    }
    
    public final void play()
    {
      AppMethodBeat.i(142279);
      MMViewPager.c(MMViewPager.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(142277);
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.j.this.xtd);
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f2 = MMViewPager.a(MMViewPager.this).getImageWidth() * f1;
          float f3 = MMViewPager.j.this.xtd[2];
          f1 = MMViewPager.b(MMViewPager.this);
          if (f2 < MMViewPager.b(MMViewPager.this)) {
            f1 = MMViewPager.b(MMViewPager.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
            f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationX();
          }
          if (f1 <= 0.0F) {
            MMViewPager.j.this.dgZ = true;
          }
          for (;;)
          {
            MMViewPager.a(MMViewPager.this).au(f1, 0.0F);
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              ((WxImageView)MMViewPager.a(MMViewPager.this)).translate(f1, 0.0F);
            }
            AppMethodBeat.o(142277);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMViewPager.j.this.dgZ = true;
            } else {
              f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      AppMethodBeat.o(142279);
    }
  }
  
  final class k
    extends MMViewPager.b
  {
    float[] xtd;
    
    public k()
    {
      super();
      AppMethodBeat.i(142281);
      this.xtd = new float[9];
      AppMethodBeat.o(142281);
    }
    
    public final void play()
    {
      AppMethodBeat.i(142282);
      MMViewPager.c(MMViewPager.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(142280);
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.k.this.xtd);
          float f2 = MMViewPager.k.this.xtd[5];
          float f1 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageHeight();
          if (f1 < MMViewPager.d(MMViewPager.this)) {}
          for (f1 = MMViewPager.d(MMViewPager.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationY();
            }
            if (f1 >= 0.0F) {
              MMViewPager.k.this.dgZ = true;
            }
            for (;;)
            {
              MMViewPager.a(MMViewPager.this).au(0.0F, f1);
              if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
                ((WxImageView)MMViewPager.a(MMViewPager.this)).translate(0.0F, f1);
              }
              AppMethodBeat.o(142280);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMViewPager.k.this.dgZ = true;
              } else {
                f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
              }
            }
          }
        }
      });
      AppMethodBeat.o(142282);
    }
  }
  
  public static final class l
    extends MMHandler
  {
    WeakReference<MMViewPager> xoV;
    long xtj;
    
    public l(WeakReference<MMViewPager> paramWeakReference)
    {
      this.xoV = paramWeakReference;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(142283);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.xoV != null)
      {
        MMViewPager localMMViewPager = (MMViewPager)this.xoV.get();
        if ((localMMViewPager != null) && (paramMessage.what == 1))
        {
          if ((MMViewPager.v(localMMViewPager) != null) && (!MMViewPager.v(localMMViewPager).deQ()))
          {
            MMViewPager.v(localMMViewPager).play();
            sendEmptyMessageDelayed(paramMessage.what, this.xtj);
            AppMethodBeat.o(142283);
            return;
          }
          MMViewPager.w(localMMViewPager);
        }
      }
      AppMethodBeat.o(142283);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager
 * JD-Core Version:    0.7.0.1
 */