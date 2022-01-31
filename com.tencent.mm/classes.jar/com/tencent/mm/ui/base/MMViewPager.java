package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.n;
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
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.lang.ref.WeakReference;

public class MMViewPager
  extends WxViewPager
{
  private int UL = -1;
  private int adE = -1;
  private int aia;
  private int aib;
  private float aqX = 0.0F;
  private float aqY = 0.0F;
  private float buF;
  private VelocityTracker fB;
  private GestureDetector gEU;
  private int gHR;
  private int gHS;
  private ah handler = new ah(Looper.getMainLooper());
  private boolean kKU = false;
  private OverScroller kKV;
  private RectF kKX = new RectF();
  private float kKZ;
  private boolean kLa = false;
  private boolean kLb = false;
  private boolean kLc = false;
  private boolean kLd = false;
  private View.OnTouchListener pXl;
  private boolean pbn = false;
  private boolean pbo = false;
  private boolean pbp = false;
  private g uYO;
  private WxImageView uYP;
  private boolean uYQ = false;
  private MMViewPager.k uYR;
  private boolean uYS = false;
  private boolean uYT = false;
  private boolean uYU = false;
  private boolean uYV = false;
  private boolean uYW = false;
  private int uYX = 0;
  private MMViewPager.a uYY;
  private MMViewPager.e uYZ;
  private c uZa;
  private ViewPager.e uZb = null;
  private float uZc = 0.0F;
  private float uZd;
  private float uZe;
  private VelocityTracker uZf = null;
  private MotionEvent uZg;
  private long uZh = 0L;
  private MMViewPager.b uZi;
  private GestureDetector.SimpleOnGestureListener uZj = new MMViewPager.d(this, (byte)0);
  private View.OnLongClickListener uZk = new MMViewPager.3(this);
  private final int uZl = 60;
  private final int uZm = 500;
  
  public MMViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setStaticTransformationsEnabled(true);
    this.uYR = new MMViewPager.k(new WeakReference(this));
    this.gEU = new GestureDetector(paramContext, new MMViewPager.d(this, (byte)0));
    this.kKV = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    this.uYX = ((int)(getResources().getDisplayMetrics().density * 3000.0F));
    super.setOnPageChangeListener(new MMViewPager.1(this));
    super.setOnTouchListener(new MMViewPager.2(this));
  }
  
  public MMViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setStaticTransformationsEnabled(true);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, View paramView, float paramFloat3)
  {
    if (b(paramFloat2, paramView, paramFloat3)) {}
    while (a(paramFloat1, paramView, paramFloat3)) {
      return true;
    }
    return false;
  }
  
  private boolean a(float paramFloat1, View paramView, float paramFloat2)
  {
    if (getAdapter().F(paramView) == cBh())
    {
      if ((this.uYO instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.uYO).getTranslationX();
        paramFloat2 *= 0.3F;
        y.d("MicroMsg.MMViewPager", "alvinluo scrollFirst current is WxImageView, distanceX: %f, translateLeft: %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
        if ((paramFloat2 < 0.0F) && (paramFloat1 - paramFloat2 > 0.0F)) {
          this.uYV = true;
        }
        if (this.uYV)
        {
          ((WxImageView)this.uYO).translate(-paramFloat2, 0.0F);
          return true;
        }
        return false;
      }
      if (this.uYV)
      {
        if (paramFloat2 < 0.0F)
        {
          if (paramFloat1 > this.kKX.left) {
            break label151;
          }
          this.uYO.ae(-paramFloat2, 0.0F);
        }
        label151:
        while ((paramFloat1 <= this.kKX.left) || (paramFloat1 >= this.gHR * 0.3F)) {
          return false;
        }
        this.uYO.ae(-(paramFloat2 * 0.3F), 0.0F);
        return true;
      }
      if (paramFloat2 < 0.0F)
      {
        if (paramFloat1 > 0.0F) {
          this.uYV = true;
        }
        if (paramFloat1 > this.kKX.left) {
          break label252;
        }
        this.uYO.ae(-paramFloat2, 0.0F);
      }
    }
    while ((this.uYU) || (this.uYT))
    {
      return false;
      label252:
      if ((paramFloat1 > this.kKX.left) && (paramFloat1 < this.gHR * 0.3F))
      {
        this.uYO.ae(-(paramFloat2 * 0.3F), 0.0F);
        return true;
      }
    }
    this.uYV = false;
    return false;
  }
  
  private void aXW()
  {
    this.uYR.removeMessages(1);
  }
  
  private void aXX()
  {
    aXW();
    MMViewPager.k localk = this.uYR;
    localk.kLr = 15L;
    localk.sendEmptyMessageDelayed(1, 15L);
  }
  
  private boolean b(float paramFloat1, View paramView, float paramFloat2)
  {
    if (getAdapter().F(paramView) == cBi())
    {
      if ((this.uYO instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.uYO).getTranslationX();
        paramFloat2 *= 0.3F;
        y.d("MicroMsg.MMViewPager", "alvinluo scrollLast current is WxImageView, distanceX: %f, translateRight: %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
        if ((paramFloat2 > 0.0F) && (paramFloat1 - paramFloat2 < 0.0F)) {
          this.uYW = true;
        }
        if (this.uYW)
        {
          ((WxImageView)this.uYO).translate(-paramFloat2, 0.0F);
          return true;
        }
        return false;
      }
      if (this.uYW)
      {
        if (paramFloat2 > 0.0F)
        {
          if (paramFloat1 < this.gHR) {
            break label149;
          }
          this.uYO.ae(-paramFloat2, 0.0F);
        }
        label149:
        while ((paramFloat1 <= this.gHR * 0.7F) || (paramFloat1 >= this.gHS)) {
          return false;
        }
        this.uYO.ae(-(paramFloat2 * 0.3F), 0.0F);
        return true;
      }
      if (paramFloat2 > 0.0F)
      {
        if (paramFloat1 < this.gHR) {
          this.uYW = true;
        }
        if (paramFloat1 < this.gHR) {
          break label250;
        }
        this.uYO.ae(-paramFloat2, 0.0F);
      }
    }
    while ((this.uYU) || (this.uYT))
    {
      return false;
      label250:
      if ((paramFloat1 > this.gHR * 0.7F) && (paramFloat1 < this.gHS))
      {
        this.uYO.ae(-(paramFloat2 * 0.3F), 0.0F);
        return true;
      }
    }
    this.uYW = false;
    return false;
  }
  
  private static boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null)) {}
    while (paramMotionEvent1.getX() - paramMotionEvent2.getX() >= 0.0F) {
      return false;
    }
    return true;
  }
  
  private void cBf()
  {
    this.uYP = getSelectedWxImageView$778eb1f();
    if (this.uYP != null)
    {
      y.d("MicroMsg.MMViewPager", "alvinluo ViewPager initWxImageView");
      this.uYQ = true;
      this.uYP.setGestureDetectorListener(this.uZj);
      this.uYP.setOnLongClickListener(this.uZk);
      this.uYP.cAy();
    }
  }
  
  private boolean cBg()
  {
    y.d("MicroMsg.MMViewPager", "dancy scroll left right !!");
    if (this.uYT) {
      return true;
    }
    this.uYU = true;
    return false;
  }
  
  private int getCurrentX()
  {
    if (getAdapter() == null) {
      return -1;
    }
    return getScrollX() - this.gHR * (getAdapter().getCount() - getCurrentItem() - 1);
  }
  
  private g getSelectedImageView()
  {
    MultiTouchImageView localMultiTouchImageView = getSelectedMultiTouchImageView();
    if (localMultiTouchImageView != null) {
      return localMultiTouchImageView;
    }
    return getSelectedWxImageView$778eb1f();
  }
  
  private MultiTouchImageView getSelectedMultiTouchImageView()
  {
    int i = getCurrentItem();
    return ((t)getAdapter()).rX(i);
  }
  
  private View getSelectedView()
  {
    int i = getCurrentItem();
    return ((t)getAdapter()).Gs(i);
  }
  
  private WxImageView getSelectedWxImageView$778eb1f()
  {
    int i = getCurrentItem();
    WxImageView localWxImageView = ((t)getAdapter()).rY(i);
    if (localWxImageView != null) {
      return (WxImageView)localWxImageView;
    }
    return null;
  }
  
  public final int cBh()
  {
    int i = ((t)getAdapter()).cBh();
    if (i >= 0) {
      return i;
    }
    return super.cBh();
  }
  
  public final int cBi()
  {
    int i = ((t)getAdapter()).cBi();
    if (i >= 0) {
      return i;
    }
    return super.cBi();
  }
  
  public void computeScroll()
  {
    int m = 0;
    super.computeScroll();
    if (this.uYO == null) {}
    float f1;
    do
    {
      return;
      f3 = this.uYO.getScale();
      f4 = this.uYO.getImageWidth();
      f1 = this.uYO.getScale() * this.uYO.getImageHeight();
    } while (!this.kKV.computeScrollOffset());
    int i = this.kKV.getCurrX() - this.aia;
    int n = this.kKV.getCurrY() - this.aib;
    this.aia = this.kKV.getCurrX();
    this.aib = this.kKV.getCurrY();
    float[] arrayOfFloat = new float[9];
    this.uYO.getImageMatrix().getValues(arrayOfFloat);
    float f2 = arrayOfFloat[2];
    float f3 = f3 * f4 + f2;
    float f4 = arrayOfFloat[5];
    float f5 = f4 + f1;
    int j = i;
    if (i < 0)
    {
      j = i;
      if (i < this.kKX.right - Math.round(f3)) {
        j = (int)(this.kKX.right - Math.round(f3));
      }
    }
    i = j;
    if (j > 0)
    {
      i = j;
      if (j > this.kKX.left - Math.round(f2)) {
        i = (int)(this.kKX.left - Math.round(f2));
      }
    }
    int k = n;
    if (n < 0)
    {
      k = n;
      if (n < this.kKX.bottom - Math.round(f5)) {
        k = (int)(this.kKX.bottom - Math.round(f5));
      }
    }
    j = k;
    if (k > 0)
    {
      j = k;
      if (k > this.kKX.top - Math.round(f4)) {
        j = (int)(this.kKX.top - Math.round(f4));
      }
    }
    if ((Math.round(f2) >= this.kKX.left) || (Math.round(f3) <= this.kKX.right))
    {
      k = 0;
      if (f1 >= this.gHS) {
        break label479;
      }
    }
    label479:
    for (i = m;; i = j)
    {
      this.uYO.ae(k, i);
      postInvalidate();
      return;
      if (Math.round(f4) < this.kKX.top)
      {
        k = i;
        if (Math.round(f5) > this.kKX.bottom) {
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
    try
    {
      y.d("MicroMsg.MMViewPager", "alvinluo dispatchTouchEvent action: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
      if (this.uYP == null) {
        cBf();
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      y.printErrStackTrace("MicroMsg.MMViewPager", paramMotionEvent, "alvinluo MMViewPager dispatchTouchEvent exception", new Object[0]);
    }
    return false;
  }
  
  public int getScreenWidth()
  {
    return this.gHR;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (paramBoolean) {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    boolean bool2;
    if (this.uYP == null) {
      bool2 = bool1;
    }
    do
    {
      return bool2;
      bool2 = bool1;
    } while (bool1);
    if (this.uZf == null) {
      this.uZf = VelocityTracker.obtain();
    }
    this.uZf.addMovement(paramMotionEvent);
    VelocityTracker localVelocityTracker = this.uZf;
    localVelocityTracker.computeCurrentVelocity(1000);
    int i = (int)localVelocityTracker.getXVelocity();
    int j = (int)localVelocityTracker.getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.aqX = paramMotionEvent.getRawX();
      this.aqY = paramMotionEvent.getRawY();
      this.kKZ = this.uYP.getScale();
      return bool1;
      this.uZd = paramMotionEvent.getRawX();
      this.uZe = paramMotionEvent.getRawY();
      bool1 = false;
      continue;
      float f = paramMotionEvent.getRawX() - this.uZd;
      y.d("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f), Float.valueOf(paramMotionEvent.getRawY() - this.uZe), Integer.valueOf(i), Integer.valueOf(j) });
      if ((Math.abs(f) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (Math.abs(j) > 0))
      {
        y.i("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action: %d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
        bool1 = true;
      }
      else
      {
        bool1 = false;
        continue;
        bool1 = false;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.gHR = View.MeasureSpec.getSize(paramInt1);
    this.gHS = View.MeasureSpec.getSize(paramInt2);
    this.kKX.set(0.0F, 0.0F, this.gHR, this.gHS);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      super.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void setAdapter(n paramn)
  {
    if ((paramn instanceof t))
    {
      super.setAdapter(paramn);
      return;
    }
    throw new IllegalArgumentException("must be MMViewPagerAdapter");
  }
  
  public void setGalleryScaleListener(MMViewPager.b paramb)
  {
    this.uZi = paramb;
  }
  
  public void setLongClickOverListener(c paramc)
  {
    this.uZa = paramc;
  }
  
  public void setOnPageChangeListener(ViewPager.e parame)
  {
    this.uZb = parame;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.pXl = paramOnTouchListener;
  }
  
  public void setSingleClickOverListener(MMViewPager.e parame)
  {
    this.uYZ = parame;
  }
  
  public static abstract interface c
  {
    public abstract void aRg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager
 * JD-Core Version:    0.7.0.1
 */