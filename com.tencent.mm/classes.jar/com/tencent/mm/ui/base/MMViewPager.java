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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.lang.ref.WeakReference;

public class MMViewPager
  extends WxViewPager
{
  private g GaK;
  public k GaL;
  private boolean GaM;
  private boolean GaN;
  private boolean GaO;
  private boolean GaP;
  private boolean GaQ;
  private int GaR;
  private a GaS;
  private e GaT;
  private c GaU;
  private ViewPager.OnPageChangeListener GaV;
  private float GaW;
  private MotionEvent GaX;
  private long GaY;
  private b GaZ;
  private GestureDetector.SimpleOnGestureListener Gba;
  private View.OnLongClickListener Gbb;
  private final int Gbc;
  private final int Gbd;
  private float aOa;
  private float aOb;
  private int acD;
  private int ana;
  private int arE;
  private int arF;
  private float cHW;
  private ap handler;
  private GestureDetector ktZ;
  private int kvn;
  private int kvo;
  private VelocityTracker mVelocityTracker;
  private WxImageView rJr;
  private boolean rMA;
  private boolean rMB;
  private boolean rMC;
  private boolean rMD;
  private boolean rMu;
  private OverScroller rMv;
  private RectF rMx;
  private float rMz;
  private float vLZ;
  private float vMa;
  private VelocityTracker vMb;
  private boolean xCE;
  private boolean xCF;
  private boolean xCG;
  private View.OnTouchListener zrL;
  
  public MMViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142287);
    this.ana = -1;
    this.acD = -1;
    this.rMu = false;
    this.GaM = false;
    this.GaN = false;
    this.GaO = false;
    this.GaP = false;
    this.GaQ = false;
    this.rMA = false;
    this.rMB = false;
    this.rMC = false;
    this.rMD = false;
    this.rMx = new RectF();
    this.GaR = 0;
    this.handler = new ap(Looper.getMainLooper());
    this.GaV = null;
    this.GaW = 0.0F;
    this.vMb = null;
    this.GaY = 0L;
    this.aOa = 0.0F;
    this.aOb = 0.0F;
    this.xCE = false;
    this.xCF = false;
    this.xCG = false;
    this.Gba = new d((byte)0);
    this.Gbb = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142262);
        if (MMViewPager.p(MMViewPager.this) != null) {
          MMViewPager.p(MMViewPager.this).aHp();
        }
        AppMethodBeat.o(142262);
        return true;
      }
    };
    this.Gbc = 60;
    this.Gbd = 500;
    setStaticTransformationsEnabled(true);
    this.GaL = new k(new WeakReference(this));
    this.ktZ = new GestureDetector(paramContext, new d((byte)0));
    this.rMv = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    this.GaR = ((int)(getResources().getDisplayMetrics().density * 3000.0F));
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
        ad.d("MicroMsg.MMViewPager", "alvinluo onTouch getCurrentItem: %d", new Object[] { Integer.valueOf(MMViewPager.this.getCurrentItem()) });
        if (MMViewPager.k(MMViewPager.this) != null) {}
        for (boolean bool1 = MMViewPager.k(MMViewPager.this).onTouch(paramAnonymousView, paramAnonymousMotionEvent);; bool1 = false)
        {
          paramAnonymousView = MMViewPager.this.getSelectedImageView();
          if (paramAnonymousView == null)
          {
            MMViewPager.a(MMViewPager.this, paramAnonymousMotionEvent);
            MMViewPager.b(MMViewPager.this, null);
            MMViewPager.l(MMViewPager.this).onTouchEvent(paramAnonymousMotionEvent);
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
          MMViewPager.l(MMViewPager.this).onTouchEvent(paramAnonymousMotionEvent);
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
    this.ana = -1;
    this.acD = -1;
    this.rMu = false;
    this.GaM = false;
    this.GaN = false;
    this.GaO = false;
    this.GaP = false;
    this.GaQ = false;
    this.rMA = false;
    this.rMB = false;
    this.rMC = false;
    this.rMD = false;
    this.rMx = new RectF();
    this.GaR = 0;
    this.handler = new ap(Looper.getMainLooper());
    this.GaV = null;
    this.GaW = 0.0F;
    this.vMb = null;
    this.GaY = 0L;
    this.aOa = 0.0F;
    this.aOb = 0.0F;
    this.xCE = false;
    this.xCF = false;
    this.xCG = false;
    this.Gba = new d((byte)0);
    this.Gbb = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142262);
        if (MMViewPager.p(MMViewPager.this) != null) {
          MMViewPager.p(MMViewPager.this).aHp();
        }
        AppMethodBeat.o(142262);
        return true;
      }
    };
    this.Gbc = 60;
    this.Gbd = 500;
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
    if (getAdapter().getItemPosition(paramView) == firstItemPosForDetermine())
    {
      if ((this.GaK instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.GaK).getTranslationX();
        paramFloat2 *= 0.3F;
        ad.d("MicroMsg.MMViewPager", "alvinluo scrollFirst current is WxImageView, distanceX: %f, translateLeft: %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
        if ((paramFloat2 < 0.0F) && (paramFloat1 - paramFloat2 > 0.0F)) {
          this.GaP = true;
        }
        if (this.GaP)
        {
          ((WxImageView)this.GaK).translate(-paramFloat2, 0.0F);
          AppMethodBeat.o(142294);
          return true;
        }
        AppMethodBeat.o(142294);
        return false;
      }
      if (this.GaP)
      {
        if (paramFloat2 < 0.0F)
        {
          if (paramFloat1 > this.rMx.left) {
            break label175;
          }
          this.GaK.ag(-paramFloat2, 0.0F);
        }
        label175:
        while ((paramFloat1 <= this.rMx.left) || (paramFloat1 >= this.kvn * 0.3F))
        {
          AppMethodBeat.o(142294);
          return false;
        }
        this.GaK.ag(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142294);
        return true;
      }
      if (paramFloat2 < 0.0F)
      {
        if (paramFloat1 > 0.0F) {
          this.GaP = true;
        }
        if (paramFloat1 > this.rMx.left) {
          break label288;
        }
        this.GaK.ag(-paramFloat2, 0.0F);
      }
    }
    while ((this.GaO) || (this.GaN))
    {
      AppMethodBeat.o(142294);
      return false;
      label288:
      if ((paramFloat1 > this.rMx.left) && (paramFloat1 < this.kvn * 0.3F))
      {
        this.GaK.ag(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142294);
        return true;
      }
    }
    this.GaP = false;
    AppMethodBeat.o(142294);
    return false;
  }
  
  private boolean b(float paramFloat1, View paramView, float paramFloat2)
  {
    AppMethodBeat.i(142295);
    if (getAdapter().getItemPosition(paramView) == lastItemPosForDetermine())
    {
      if ((this.GaK instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.GaK).getTranslationX();
        paramFloat2 *= 0.3F;
        ad.d("MicroMsg.MMViewPager", "alvinluo scrollLast current is WxImageView, distanceX: %f, translateRight: %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
        if ((paramFloat2 > 0.0F) && (paramFloat1 - paramFloat2 < 0.0F)) {
          this.GaQ = true;
        }
        if (this.GaQ)
        {
          ((WxImageView)this.GaK).translate(-paramFloat2, 0.0F);
          AppMethodBeat.o(142295);
          return true;
        }
        AppMethodBeat.o(142295);
        return false;
      }
      if (this.GaQ)
      {
        if (paramFloat2 > 0.0F)
        {
          if (paramFloat1 < this.kvn) {
            break label173;
          }
          this.GaK.ag(-paramFloat2, 0.0F);
        }
        label173:
        while ((paramFloat1 <= this.kvn * 0.7F) || (paramFloat1 >= this.kvo))
        {
          AppMethodBeat.o(142295);
          return false;
        }
        this.GaK.ag(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142295);
        return true;
      }
      if (paramFloat2 > 0.0F)
      {
        if (paramFloat1 < this.kvn) {
          this.GaQ = true;
        }
        if (paramFloat1 < this.kvn) {
          break label286;
        }
        this.GaK.ag(-paramFloat2, 0.0F);
      }
    }
    while ((this.GaO) || (this.GaN))
    {
      AppMethodBeat.o(142295);
      return false;
      label286:
      if ((paramFloat1 > this.kvn * 0.7F) && (paramFloat1 < this.kvo))
      {
        this.GaK.ag(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142295);
        return true;
      }
    }
    this.GaQ = false;
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
  
  private void cAV()
  {
    AppMethodBeat.i(142285);
    this.GaL.removeMessages(1);
    AppMethodBeat.o(142285);
  }
  
  private void cAW()
  {
    AppMethodBeat.i(142286);
    cAV();
    k localk = this.GaL;
    localk.rMQ = 15L;
    localk.sendEmptyMessageDelayed(1, 15L);
    AppMethodBeat.o(142286);
  }
  
  private void eTj()
  {
    AppMethodBeat.i(142288);
    this.rJr = getSelectedWxImageView();
    if (this.rJr != null)
    {
      ad.d("MicroMsg.MMViewPager", "alvinluo ViewPager initWxImageView");
      this.rJr.setGestureDetectorListener(this.Gba);
      this.rJr.setOnLongClickListener(this.Gbb);
      this.rJr.eSz();
    }
    AppMethodBeat.o(142288);
  }
  
  private boolean eTk()
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
  
  private boolean eTl()
  {
    AppMethodBeat.i(142293);
    ad.d("MicroMsg.MMViewPager", "dancy scroll left right !!");
    if (this.GaN)
    {
      AppMethodBeat.o(142293);
      return true;
    }
    this.GaO = true;
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
    int j = this.kvn;
    int k = getAdapter().getCount();
    int m = getCurrentItem();
    AppMethodBeat.o(142302);
    return i - j * (k - m - 1);
  }
  
  private MultiTouchImageView getSelectedMultiTouchImageView()
  {
    AppMethodBeat.i(142299);
    int i = getCurrentItem();
    MultiTouchImageView localMultiTouchImageView = ((u)getAdapter()).Ef(i);
    AppMethodBeat.o(142299);
    return localMultiTouchImageView;
  }
  
  private WxImageView getSelectedWxImageView()
  {
    AppMethodBeat.i(142300);
    int i = getCurrentItem();
    WxImageView localWxImageView = ((u)getAdapter()).Eg(i);
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
    if (this.GaK == null)
    {
      AppMethodBeat.o(142304);
      return;
    }
    float f3 = this.GaK.getScale();
    float f4 = this.GaK.getImageWidth();
    float f1 = this.GaK.getScale() * this.GaK.getImageHeight();
    float f5;
    int j;
    int k;
    if (this.rMv.computeScrollOffset())
    {
      i = this.rMv.getCurrX() - this.arE;
      int n = this.rMv.getCurrY() - this.arF;
      this.arE = this.rMv.getCurrX();
      this.arF = this.rMv.getCurrY();
      float[] arrayOfFloat = new float[9];
      this.GaK.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f3 * f4 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.rMx.right - Math.round(f3)) {
          j = (int)(this.rMx.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.rMx.left - Math.round(f2)) {
          i = (int)(this.rMx.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.rMx.bottom - Math.round(f5)) {
          k = (int)(this.rMx.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.rMx.top - Math.round(f4)) {
          j = (int)(this.rMx.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.rMx.left) && (Math.round(f3) > this.rMx.right)) {
        break label449;
      }
      k = 0;
      if (f1 >= this.kvo) {
        break label497;
      }
    }
    label449:
    label497:
    for (int i = m;; i = j)
    {
      this.GaK.ag(k, i);
      postInvalidate();
      AppMethodBeat.o(142304);
      return;
      if (Math.round(f4) < this.rMx.top)
      {
        k = i;
        if (Math.round(f5) > this.rMx.bottom) {
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
      ad.d("MicroMsg.MMViewPager", "alvinluo dispatchTouchEvent action: %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
      if (this.rJr == null) {
        eTj();
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(142290);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      ad.printErrStackTrace("MicroMsg.MMViewPager", paramMotionEvent, "alvinluo MMViewPager dispatchTouchEvent exception", new Object[0]);
      AppMethodBeat.o(142290);
    }
    return false;
  }
  
  public int firstItemPosForDetermine()
  {
    AppMethodBeat.i(142307);
    int i = ((u)getAdapter()).firstItemPosForDetermine();
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
    return this.kvn;
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
    View localView = ((u)getAdapter()).OT(i);
    AppMethodBeat.o(142297);
    return localView;
  }
  
  public int getXDown()
  {
    return (int)this.aOa;
  }
  
  public int getYDown()
  {
    return (int)this.aOb;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  public int lastItemPosForDetermine()
  {
    AppMethodBeat.i(142308);
    int i = ((u)getAdapter()).lastItemPosForDetermine();
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
    if (!eTk())
    {
      AppMethodBeat.o(142291);
      return bool;
    }
    if (bool)
    {
      AppMethodBeat.o(142291);
      return bool;
    }
    if (this.vMb == null) {
      this.vMb = VelocityTracker.obtain();
    }
    this.vMb.addMovement(paramMotionEvent);
    VelocityTracker localVelocityTracker = this.vMb;
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
        this.aOa = paramMotionEvent.getRawX();
        this.aOb = paramMotionEvent.getRawY();
        this.rMz = this.rJr.getScale();
      }
      AppMethodBeat.o(142291);
      return bool;
      this.vLZ = paramMotionEvent.getRawX();
      this.vMa = paramMotionEvent.getRawY();
      bool = false;
      continue;
      float f = paramMotionEvent.getRawX() - this.vLZ;
      ad.d("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f), Float.valueOf(paramMotionEvent.getRawY() - this.vMa), Integer.valueOf(i), Integer.valueOf(j) });
      if ((Math.abs(f) <= 250.0F) && (Math.abs(j) > Math.abs(i)) && (Math.abs(j) > 0))
      {
        ad.i("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action: %d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
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
    AppMethodBeat.i(142292);
    super.onMeasure(paramInt1, paramInt2);
    this.kvn = View.MeasureSpec.getSize(paramInt1);
    this.kvo = View.MeasureSpec.getSize(paramInt2);
    this.rMx.set(0.0F, 0.0F, this.kvn, this.kvo);
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
    if ((paramq instanceof u))
    {
      super.setAdapter(paramq);
      AppMethodBeat.o(142301);
      return;
    }
    paramq = new IllegalArgumentException("must be MMViewPagerAdapter");
    AppMethodBeat.o(142301);
    throw paramq;
  }
  
  public void setGalleryScaleListener(b paramb)
  {
    this.GaZ = paramb;
  }
  
  public void setLongClickOverListener(c paramc)
  {
    this.GaU = paramc;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.GaV = paramOnPageChangeListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.zrL = paramOnTouchListener;
  }
  
  public void setSingleClickOverListener(e parame)
  {
    this.GaT = parame;
  }
  
  abstract class a
  {
    protected boolean cHI = false;
    
    public a() {}
    
    public final boolean cAX()
    {
      return this.cHI;
    }
    
    public abstract void play();
  }
  
  public static abstract interface b
  {
    public abstract void J(float paramFloat1, float paramFloat2);
    
    public abstract void Y(float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface c
  {
    public abstract void aHp();
  }
  
  final class d
    extends GestureDetector.SimpleOnGestureListener
  {
    private d() {}
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(142266);
      if (MMViewPager.a(MMViewPager.this) == null)
      {
        AppMethodBeat.o(142266);
        return false;
      }
      if (MMViewPager.a(MMViewPager.this).getScale() <= MMViewPager.a(MMViewPager.this).getScaleRate()) {
        MMViewPager.a(MMViewPager.this).af(f.d(paramMotionEvent, 0), f.e(paramMotionEvent, 0));
      }
      for (;;)
      {
        AppMethodBeat.o(142266);
        return true;
        MMViewPager.a(MMViewPager.this).ae(f.d(paramMotionEvent, 0), f.e(paramMotionEvent, 0));
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
      ad.d("MicroMsg.MMViewPager", "onFling");
      Object localObject2 = MMViewPager.this.getSelectedImageView();
      Object localObject1;
      float f2;
      float f3;
      float f4;
      float f5;
      float f6;
      if (localObject2 != null)
      {
        ad.d("MicroMsg.MMViewPager", "onFling MultiTouchImageView");
        if ((localObject2 instanceof MultiTouchImageView))
        {
          localObject1 = (MultiTouchImageView)localObject2;
          f2 = ((g)localObject1).getScale() * ((g)localObject1).getImageWidth();
          f3 = ((g)localObject1).getScale() * ((g)localObject1).getImageHeight();
          if ((!((g)localObject1).eSx()) && (!((g)localObject1).eSy()) && ((int)f2 <= MMViewPager.b(MMViewPager.this)) && ((int)f3 <= MMViewPager.d(MMViewPager.this))) {
            break label485;
          }
          localObject2 = new float[9];
          ((g)localObject1).getImageMatrix().getValues((float[])localObject2);
          f4 = localObject2[2];
          f5 = f4 + f2;
          f6 = localObject2[5];
          ad.d("MicroMsg.MMViewPager", "left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", new Object[] { Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(MMViewPager.c(paramMotionEvent1, paramMotionEvent2)), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
          if ((Math.round(f4) < MMViewPager.t(MMViewPager.this).left) && (Math.round(f5) > MMViewPager.t(MMViewPager.this).right)) {
            break label522;
          }
        }
      }
      label522:
      for (float f1 = 0.0F;; f1 = paramFloat1)
      {
        if ((Math.round(f6) >= MMViewPager.t(MMViewPager.this).top) || (Math.round(f6 + f3) <= MMViewPager.t(MMViewPager.this).bottom)) {
          paramFloat2 = 0.0F;
        }
        int i = (int)(MMViewPager.t(MMViewPager.this).right - f2);
        int j = (int)(MMViewPager.t(MMViewPager.this).right + f2);
        int k = (int)(MMViewPager.t(MMViewPager.this).bottom - f3);
        int m = (int)(MMViewPager.t(MMViewPager.this).bottom + f3);
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
      MMViewPager.s(MMViewPager.this);
      if (MMViewPager.p(MMViewPager.this) != null) {
        MMViewPager.p(MMViewPager.this).aHp();
      }
      AppMethodBeat.o(142265);
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(142263);
      if (MMViewPager.q(MMViewPager.this) != null) {
        MMViewPager.q(MMViewPager.this).aHo();
      }
      AppMethodBeat.o(142263);
      return true;
    }
  }
  
  public static abstract interface e
  {
    public abstract void aHo();
    
    public abstract void cAM();
  }
  
  final class f
    extends MMViewPager.a
  {
    float[] rMK;
    
    public f()
    {
      super();
      AppMethodBeat.i(142269);
      this.rMK = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.f.this.rMK);
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f2 = MMViewPager.a(MMViewPager.this).getImageHeight() * f1;
          float f3 = MMViewPager.f.this.rMK[5];
          f1 = MMViewPager.d(MMViewPager.this);
          if (f2 < MMViewPager.d(MMViewPager.this)) {
            f1 = MMViewPager.d(MMViewPager.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
            f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationY();
          }
          if (f1 <= 0.0F) {
            MMViewPager.f.this.cHI = true;
          }
          for (;;)
          {
            MMViewPager.a(MMViewPager.this).ag(0.0F, f1);
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              ((WxImageView)MMViewPager.a(MMViewPager.this)).translate(0.0F, f1);
            }
            AppMethodBeat.o(142268);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMViewPager.f.this.cHI = true;
            } else {
              f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      AppMethodBeat.o(142270);
    }
  }
  
  final class g
    extends MMViewPager.a
  {
    float[] rMK;
    
    public g()
    {
      super();
      AppMethodBeat.i(142272);
      this.rMK = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.g.this.rMK);
          float f5 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageWidth();
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f8 = MMViewPager.a(MMViewPager.this).getImageHeight() * f1;
          float f7 = MMViewPager.g.this.rMK[2];
          float f10 = MMViewPager.g.this.rMK[5];
          float f6 = MMViewPager.g.this.rMK[2];
          float f9 = MMViewPager.g.this.rMK[5];
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
                    MMViewPager.g.this.cHI = true;
                  }
                  for (;;)
                  {
                    MMViewPager.a(MMViewPager.this).ag(f2, f1);
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
  
  final class h
    extends MMViewPager.a
  {
    float[] rMK;
    
    public h()
    {
      super();
      AppMethodBeat.i(142275);
      this.rMK = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.h.this.rMK);
          float f2 = MMViewPager.h.this.rMK[2];
          float f1 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageWidth();
          if (f1 < MMViewPager.b(MMViewPager.this)) {}
          for (f1 = MMViewPager.b(MMViewPager.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationX();
            }
            if (f1 >= 0.0F) {
              MMViewPager.h.this.cHI = true;
            }
            for (;;)
            {
              MMViewPager.a(MMViewPager.this).ag(f1, 0.0F);
              if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
                ((WxImageView)MMViewPager.a(MMViewPager.this)).translate(f1, 0.0F);
              }
              AppMethodBeat.o(142274);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMViewPager.h.this.cHI = true;
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
  
  final class i
    extends MMViewPager.a
  {
    float[] rMK;
    
    public i()
    {
      super();
      AppMethodBeat.i(142278);
      this.rMK = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.i.this.rMK);
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f2 = MMViewPager.a(MMViewPager.this).getImageWidth() * f1;
          float f3 = MMViewPager.i.this.rMK[2];
          f1 = MMViewPager.b(MMViewPager.this);
          if (f2 < MMViewPager.b(MMViewPager.this)) {
            f1 = MMViewPager.b(MMViewPager.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
            f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationX();
          }
          if (f1 <= 0.0F) {
            MMViewPager.i.this.cHI = true;
          }
          for (;;)
          {
            MMViewPager.a(MMViewPager.this).ag(f1, 0.0F);
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              ((WxImageView)MMViewPager.a(MMViewPager.this)).translate(f1, 0.0F);
            }
            AppMethodBeat.o(142277);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMViewPager.i.this.cHI = true;
            } else {
              f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      AppMethodBeat.o(142279);
    }
  }
  
  final class j
    extends MMViewPager.a
  {
    float[] rMK;
    
    public j()
    {
      super();
      AppMethodBeat.i(142281);
      this.rMK = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.j.this.rMK);
          float f2 = MMViewPager.j.this.rMK[5];
          float f1 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageHeight();
          if (f1 < MMViewPager.d(MMViewPager.this)) {}
          for (f1 = MMViewPager.d(MMViewPager.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationY();
            }
            if (f1 >= 0.0F) {
              MMViewPager.j.this.cHI = true;
            }
            for (;;)
            {
              MMViewPager.a(MMViewPager.this).ag(0.0F, f1);
              if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
                ((WxImageView)MMViewPager.a(MMViewPager.this)).translate(0.0F, f1);
              }
              AppMethodBeat.o(142280);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMViewPager.j.this.cHI = true;
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
  
  public static final class k
    extends ap
  {
    WeakReference<MMViewPager> rIC;
    long rMQ;
    
    public k(WeakReference<MMViewPager> paramWeakReference)
    {
      this.rIC = paramWeakReference;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(142283);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.rIC != null)
      {
        MMViewPager localMMViewPager = (MMViewPager)this.rIC.get();
        if ((localMMViewPager != null) && (paramMessage.what == 1))
        {
          if ((MMViewPager.u(localMMViewPager) != null) && (!MMViewPager.u(localMMViewPager).cAX()))
          {
            MMViewPager.u(localMMViewPager).play();
            sendEmptyMessageDelayed(paramMessage.what, this.rMQ);
            AppMethodBeat.o(142283);
            return;
          }
          MMViewPager.v(localMMViewPager);
        }
      }
      AppMethodBeat.o(142283);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager
 * JD-Core Version:    0.7.0.1
 */