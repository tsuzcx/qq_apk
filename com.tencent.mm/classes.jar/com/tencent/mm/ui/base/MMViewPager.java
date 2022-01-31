package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.lang.ref.WeakReference;

public class MMViewPager
  extends WxViewPager
{
  private int Vy;
  private int afT;
  private int akq;
  private int akr;
  private float atq;
  private float atr;
  private float bVQ;
  private ak handler;
  private GestureDetector idY;
  private int iiW;
  private int iiX;
  private View.OnTouchListener kjL;
  private VelocityTracker mVelocityTracker;
  private RectF nhA;
  private float nhC;
  private boolean nhD;
  private boolean nhE;
  private boolean nhF;
  private boolean nhG;
  private boolean nhx;
  private OverScroller nhy;
  private boolean rUb;
  private boolean rUc;
  private boolean rUd;
  private GestureDetector.SimpleOnGestureListener znA;
  private View.OnLongClickListener znB;
  private final int znC;
  private final int znD;
  private g zng;
  private WxImageView znh;
  private MMViewPager.k zni;
  private boolean znj;
  private boolean znk;
  private boolean znl;
  private boolean znm;
  private boolean znn;
  private int zno;
  private MMViewPager.a znp;
  private MMViewPager.e znq;
  private c znr;
  private ViewPager.OnPageChangeListener zns;
  private float znt;
  private float znu;
  private float znv;
  private VelocityTracker znw;
  private MotionEvent znx;
  private long zny;
  private MMViewPager.b znz;
  
  public MMViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106924);
    this.afT = -1;
    this.Vy = -1;
    this.nhx = false;
    this.znj = false;
    this.znk = false;
    this.znl = false;
    this.znm = false;
    this.znn = false;
    this.nhD = false;
    this.nhE = false;
    this.nhF = false;
    this.nhG = false;
    this.nhA = new RectF();
    this.zno = 0;
    this.handler = new ak(Looper.getMainLooper());
    this.zns = null;
    this.znt = 0.0F;
    this.znw = null;
    this.zny = 0L;
    this.atq = 0.0F;
    this.atr = 0.0F;
    this.rUb = false;
    this.rUc = false;
    this.rUd = false;
    this.znA = new MMViewPager.d(this, (byte)0);
    this.znB = new MMViewPager.3(this);
    this.znC = 60;
    this.znD = 500;
    setStaticTransformationsEnabled(true);
    this.zni = new MMViewPager.k(new WeakReference(this));
    this.idY = new GestureDetector(paramContext, new MMViewPager.d(this, (byte)0));
    this.nhy = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    this.zno = ((int)(getResources().getDisplayMetrics().density * 3000.0F));
    super.setOnPageChangeListener(new MMViewPager.1(this));
    super.setOnTouchListener(new MMViewPager.2(this));
    AppMethodBeat.o(106924);
  }
  
  public MMViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106921);
    this.afT = -1;
    this.Vy = -1;
    this.nhx = false;
    this.znj = false;
    this.znk = false;
    this.znl = false;
    this.znm = false;
    this.znn = false;
    this.nhD = false;
    this.nhE = false;
    this.nhF = false;
    this.nhG = false;
    this.nhA = new RectF();
    this.zno = 0;
    this.handler = new ak(Looper.getMainLooper());
    this.zns = null;
    this.znt = 0.0F;
    this.znw = null;
    this.zny = 0L;
    this.atq = 0.0F;
    this.atr = 0.0F;
    this.rUb = false;
    this.rUc = false;
    this.rUd = false;
    this.znA = new MMViewPager.d(this, (byte)0);
    this.znB = new MMViewPager.3(this);
    this.znC = 60;
    this.znD = 500;
    setStaticTransformationsEnabled(true);
    AppMethodBeat.o(106921);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, View paramView, float paramFloat3)
  {
    AppMethodBeat.i(106933);
    if (b(paramFloat2, paramView, paramFloat3))
    {
      AppMethodBeat.o(106933);
      return true;
    }
    if (a(paramFloat1, paramView, paramFloat3))
    {
      AppMethodBeat.o(106933);
      return true;
    }
    AppMethodBeat.o(106933);
    return false;
  }
  
  private boolean a(float paramFloat1, View paramView, float paramFloat2)
  {
    AppMethodBeat.i(106931);
    if (getAdapter().getItemPosition(paramView) == firstItemPosForDetermine())
    {
      if ((this.zng instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.zng).getTranslationX();
        paramFloat2 *= 0.3F;
        ab.d("MicroMsg.MMViewPager", "alvinluo scrollFirst current is WxImageView, distanceX: %f, translateLeft: %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
        if ((paramFloat2 < 0.0F) && (paramFloat1 - paramFloat2 > 0.0F)) {
          this.znm = true;
        }
        if (this.znm)
        {
          ((WxImageView)this.zng).translate(-paramFloat2, 0.0F);
          AppMethodBeat.o(106931);
          return true;
        }
        AppMethodBeat.o(106931);
        return false;
      }
      if (this.znm)
      {
        if (paramFloat2 < 0.0F)
        {
          if (paramFloat1 > this.nhA.left) {
            break label175;
          }
          this.zng.ap(-paramFloat2, 0.0F);
        }
        label175:
        while ((paramFloat1 <= this.nhA.left) || (paramFloat1 >= this.iiW * 0.3F))
        {
          AppMethodBeat.o(106931);
          return false;
        }
        this.zng.ap(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(106931);
        return true;
      }
      if (paramFloat2 < 0.0F)
      {
        if (paramFloat1 > 0.0F) {
          this.znm = true;
        }
        if (paramFloat1 > this.nhA.left) {
          break label288;
        }
        this.zng.ap(-paramFloat2, 0.0F);
      }
    }
    while ((this.znl) || (this.znk))
    {
      AppMethodBeat.o(106931);
      return false;
      label288:
      if ((paramFloat1 > this.nhA.left) && (paramFloat1 < this.iiW * 0.3F))
      {
        this.zng.ap(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(106931);
        return true;
      }
    }
    this.znm = false;
    AppMethodBeat.o(106931);
    return false;
  }
  
  private boolean b(float paramFloat1, View paramView, float paramFloat2)
  {
    AppMethodBeat.i(106932);
    if (getAdapter().getItemPosition(paramView) == lastItemPosForDetermine())
    {
      if ((this.zng instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.zng).getTranslationX();
        paramFloat2 *= 0.3F;
        ab.d("MicroMsg.MMViewPager", "alvinluo scrollLast current is WxImageView, distanceX: %f, translateRight: %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
        if ((paramFloat2 > 0.0F) && (paramFloat1 - paramFloat2 < 0.0F)) {
          this.znn = true;
        }
        if (this.znn)
        {
          ((WxImageView)this.zng).translate(-paramFloat2, 0.0F);
          AppMethodBeat.o(106932);
          return true;
        }
        AppMethodBeat.o(106932);
        return false;
      }
      if (this.znn)
      {
        if (paramFloat2 > 0.0F)
        {
          if (paramFloat1 < this.iiW) {
            break label173;
          }
          this.zng.ap(-paramFloat2, 0.0F);
        }
        label173:
        while ((paramFloat1 <= this.iiW * 0.7F) || (paramFloat1 >= this.iiX))
        {
          AppMethodBeat.o(106932);
          return false;
        }
        this.zng.ap(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(106932);
        return true;
      }
      if (paramFloat2 > 0.0F)
      {
        if (paramFloat1 < this.iiW) {
          this.znn = true;
        }
        if (paramFloat1 < this.iiW) {
          break label286;
        }
        this.zng.ap(-paramFloat2, 0.0F);
      }
    }
    while ((this.znl) || (this.znk))
    {
      AppMethodBeat.o(106932);
      return false;
      label286:
      if ((paramFloat1 > this.iiW * 0.7F) && (paramFloat1 < this.iiX))
      {
        this.zng.ap(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(106932);
        return true;
      }
    }
    this.znn = false;
    AppMethodBeat.o(106932);
    return false;
  }
  
  private static boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    AppMethodBeat.i(106940);
    if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null))
    {
      AppMethodBeat.o(106940);
      return false;
    }
    if (paramMotionEvent1.getX() - paramMotionEvent2.getX() < 0.0F)
    {
      AppMethodBeat.o(106940);
      return true;
    }
    AppMethodBeat.o(106940);
    return false;
  }
  
  private void bEJ()
  {
    AppMethodBeat.i(106922);
    this.zni.removeMessages(1);
    AppMethodBeat.o(106922);
  }
  
  private void bEK()
  {
    AppMethodBeat.i(106923);
    bEJ();
    MMViewPager.k localk = this.zni;
    localk.nhU = 15L;
    localk.sendEmptyMessageDelayed(1, 15L);
    AppMethodBeat.o(106923);
  }
  
  private void dEt()
  {
    AppMethodBeat.i(106925);
    this.znh = getSelectedWxImageView();
    if (this.znh != null)
    {
      ab.d("MicroMsg.MMViewPager", "alvinluo ViewPager initWxImageView");
      this.znh.setGestureDetectorListener(this.znA);
      this.znh.setOnLongClickListener(this.znB);
      this.znh.dDJ();
    }
    AppMethodBeat.o(106925);
  }
  
  private boolean dEu()
  {
    AppMethodBeat.i(106926);
    g localg = getSelectedImageView();
    if ((localg != null) && ((localg instanceof WxImageView)))
    {
      AppMethodBeat.o(106926);
      return true;
    }
    AppMethodBeat.o(106926);
    return false;
  }
  
  private boolean dEv()
  {
    AppMethodBeat.i(106930);
    ab.d("MicroMsg.MMViewPager", "dancy scroll left right !!");
    if (this.znk)
    {
      AppMethodBeat.o(106930);
      return true;
    }
    this.znl = true;
    AppMethodBeat.o(106930);
    return false;
  }
  
  private int getCurrentX()
  {
    AppMethodBeat.i(106939);
    if (getAdapter() == null)
    {
      AppMethodBeat.o(106939);
      return -1;
    }
    int i = getScrollX();
    int j = this.iiW;
    int k = getAdapter().getCount();
    int m = getCurrentItem();
    AppMethodBeat.o(106939);
    return i - j * (k - m - 1);
  }
  
  private MultiTouchImageView getSelectedMultiTouchImageView()
  {
    AppMethodBeat.i(106936);
    int i = getCurrentItem();
    MultiTouchImageView localMultiTouchImageView = ((u)getAdapter()).wT(i);
    AppMethodBeat.o(106936);
    return localMultiTouchImageView;
  }
  
  private View getSelectedView()
  {
    AppMethodBeat.i(106934);
    int i = getCurrentItem();
    View localView = ((u)getAdapter()).Gm(i);
    AppMethodBeat.o(106934);
    return localView;
  }
  
  private WxImageView getSelectedWxImageView()
  {
    AppMethodBeat.i(106937);
    int i = getCurrentItem();
    WxImageView localWxImageView = ((u)getAdapter()).wU(i);
    if (localWxImageView != null)
    {
      localWxImageView = (WxImageView)localWxImageView;
      AppMethodBeat.o(106937);
      return localWxImageView;
    }
    AppMethodBeat.o(106937);
    return null;
  }
  
  public void computeScroll()
  {
    int m = 0;
    AppMethodBeat.i(106941);
    super.computeScroll();
    if (this.zng == null)
    {
      AppMethodBeat.o(106941);
      return;
    }
    float f3 = this.zng.getScale();
    float f4 = this.zng.getImageWidth();
    float f1 = this.zng.getScale() * this.zng.getImageHeight();
    float f5;
    int j;
    int k;
    if (this.nhy.computeScrollOffset())
    {
      i = this.nhy.getCurrX() - this.akq;
      int n = this.nhy.getCurrY() - this.akr;
      this.akq = this.nhy.getCurrX();
      this.akr = this.nhy.getCurrY();
      float[] arrayOfFloat = new float[9];
      this.zng.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f3 * f4 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.nhA.right - Math.round(f3)) {
          j = (int)(this.nhA.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.nhA.left - Math.round(f2)) {
          i = (int)(this.nhA.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.nhA.bottom - Math.round(f5)) {
          k = (int)(this.nhA.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.nhA.top - Math.round(f4)) {
          j = (int)(this.nhA.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.nhA.left) && (Math.round(f3) > this.nhA.right)) {
        break label449;
      }
      k = 0;
      if (f1 >= this.iiX) {
        break label497;
      }
    }
    label449:
    label497:
    for (int i = m;; i = j)
    {
      this.zng.ap(k, i);
      postInvalidate();
      AppMethodBeat.o(106941);
      return;
      if (Math.round(f4) < this.nhA.top)
      {
        k = i;
        if (Math.round(f5) > this.nhA.bottom) {
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
    AppMethodBeat.i(106927);
    try
    {
      ab.d("MicroMsg.MMViewPager", "alvinluo dispatchTouchEvent action: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
      if (this.znh == null) {
        dEt();
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106927);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      ab.printErrStackTrace("MicroMsg.MMViewPager", paramMotionEvent, "alvinluo MMViewPager dispatchTouchEvent exception", new Object[0]);
      AppMethodBeat.o(106927);
    }
    return false;
  }
  
  public int firstItemPosForDetermine()
  {
    AppMethodBeat.i(106944);
    int i = ((u)getAdapter()).firstItemPosForDetermine();
    if (i >= 0)
    {
      AppMethodBeat.o(106944);
      return i;
    }
    i = super.firstItemPosForDetermine();
    AppMethodBeat.o(106944);
    return i;
  }
  
  public int getScreenWidth()
  {
    return this.iiW;
  }
  
  public g getSelectedImageView()
  {
    AppMethodBeat.i(106935);
    Object localObject = getSelectedMultiTouchImageView();
    if (localObject != null)
    {
      AppMethodBeat.o(106935);
      return localObject;
    }
    localObject = getSelectedWxImageView();
    AppMethodBeat.o(106935);
    return localObject;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  public int lastItemPosForDetermine()
  {
    AppMethodBeat.i(106945);
    int i = ((u)getAdapter()).lastItemPosForDetermine();
    if (i >= 0)
    {
      AppMethodBeat.o(106945);
      return i;
    }
    i = super.lastItemPosForDetermine();
    AppMethodBeat.o(106945);
    return i;
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(106942);
    if (paramBoolean) {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
    }
    AppMethodBeat.o(106942);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106928);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    if (!dEu())
    {
      AppMethodBeat.o(106928);
      return bool;
    }
    if (bool)
    {
      AppMethodBeat.o(106928);
      return bool;
    }
    if (this.znw == null) {
      this.znw = VelocityTracker.obtain();
    }
    this.znw.addMovement(paramMotionEvent);
    VelocityTracker localVelocityTracker = this.znw;
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
        this.atq = paramMotionEvent.getRawX();
        this.atr = paramMotionEvent.getRawY();
        this.nhC = this.znh.getScale();
      }
      AppMethodBeat.o(106928);
      return bool;
      this.znu = paramMotionEvent.getRawX();
      this.znv = paramMotionEvent.getRawY();
      bool = false;
      continue;
      float f = paramMotionEvent.getRawX() - this.znu;
      ab.d("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f), Float.valueOf(paramMotionEvent.getRawY() - this.znv), Integer.valueOf(i), Integer.valueOf(j) });
      if ((Math.abs(f) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (Math.abs(j) > 0))
      {
        ab.i("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action: %d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
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
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106929);
    super.onMeasure(paramInt1, paramInt2);
    this.iiW = View.MeasureSpec.getSize(paramInt1);
    this.iiX = View.MeasureSpec.getSize(paramInt2);
    this.nhA.set(0.0F, 0.0F, this.iiW, this.iiX);
    AppMethodBeat.o(106929);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(106943);
    if (paramBoolean) {
      super.onWindowFocusChanged(paramBoolean);
    }
    AppMethodBeat.o(106943);
  }
  
  public void setAdapter(q paramq)
  {
    AppMethodBeat.i(106938);
    if ((paramq instanceof u))
    {
      super.setAdapter(paramq);
      AppMethodBeat.o(106938);
      return;
    }
    paramq = new IllegalArgumentException("must be MMViewPagerAdapter");
    AppMethodBeat.o(106938);
    throw paramq;
  }
  
  public void setGalleryScaleListener(MMViewPager.b paramb)
  {
    this.znz = paramb;
  }
  
  public void setLongClickOverListener(c paramc)
  {
    this.znr = paramc;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.zns = paramOnPageChangeListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.kjL = paramOnTouchListener;
  }
  
  public void setSingleClickOverListener(MMViewPager.e parame)
  {
    this.znq = parame;
  }
  
  public static abstract interface c
  {
    public abstract void bxv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager
 * JD-Core Version:    0.7.0.1
 */