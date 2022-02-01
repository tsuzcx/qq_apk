package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.os.Message;
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
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.lang.ref.WeakReference;

public class MMViewPager
  extends WxViewPager
{
  private WxImageView HOl;
  private boolean HRA;
  private boolean HRB;
  private boolean HRC;
  private boolean HRt;
  private OverScroller HRu;
  private RectF HRw;
  private float HRy;
  private boolean HRz;
  private boolean Rvo;
  private boolean Rvp;
  private boolean Rvq;
  private boolean adUA;
  private boolean adUB;
  private boolean adUC;
  private int adUD;
  private b adUE;
  private f adUF;
  private d adUG;
  private MMViewPager.a adUH;
  private boolean adUI;
  private ViewPager.OnPageChangeListener adUJ;
  private float adUK;
  private boolean adUL;
  private MotionEvent adUM;
  private long adUN;
  private boolean adUO;
  private c adUP;
  private GestureDetector.SimpleOnGestureListener adUQ;
  private View.OnLongClickListener adUR;
  private final int adUS;
  private final int adUT;
  private i adUw;
  public l adUx;
  private boolean adUy;
  private boolean adUz;
  private int bXr;
  private int caG;
  private int caH;
  private MMHandler handler;
  private float hct;
  private int mI;
  private GestureDetector mQj;
  private VelocityTracker mVelocityTracker;
  private View.OnTouchListener pWX;
  private float puQ;
  private float puR;
  private VelocityTracker puS;
  private int pvg;
  private int sJv;
  private float x_down;
  private float y_down;
  
  public MMViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142287);
    this.bXr = -1;
    this.mI = -1;
    this.HRt = false;
    this.adUy = false;
    this.adUz = false;
    this.adUA = false;
    this.adUB = false;
    this.adUC = false;
    this.HRz = false;
    this.HRA = false;
    this.HRB = false;
    this.HRC = false;
    this.HRw = new RectF();
    this.adUD = 0;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.adUI = false;
    this.adUJ = null;
    this.adUK = 0.0F;
    this.puS = null;
    this.adUL = false;
    this.adUN = 0L;
    this.x_down = 0.0F;
    this.y_down = 0.0F;
    this.Rvo = false;
    this.Rvp = false;
    this.Rvq = false;
    this.adUO = true;
    this.adUQ = new e((byte)0);
    this.adUR = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142262);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        if (MMViewPager.p(MMViewPager.this) != null) {
          MMViewPager.p(MMViewPager.this).longClickOver();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(142262);
        return true;
      }
    };
    this.adUS = 60;
    this.adUT = 500;
    setStaticTransformationsEnabled(true);
    this.adUx = new l(new WeakReference(this));
    this.mQj = new GestureDetector(paramContext, new e((byte)0));
    this.HRu = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    this.adUD = ((int)(getResources().getDisplayMetrics().density * 3000.0F));
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
            paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousMotionEvent.aYi(), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.sb(0)), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
          paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousMotionEvent.aYi(), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.sb(0)), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
    this.bXr = -1;
    this.mI = -1;
    this.HRt = false;
    this.adUy = false;
    this.adUz = false;
    this.adUA = false;
    this.adUB = false;
    this.adUC = false;
    this.HRz = false;
    this.HRA = false;
    this.HRB = false;
    this.HRC = false;
    this.HRw = new RectF();
    this.adUD = 0;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.adUI = false;
    this.adUJ = null;
    this.adUK = 0.0F;
    this.puS = null;
    this.adUL = false;
    this.adUN = 0L;
    this.x_down = 0.0F;
    this.y_down = 0.0F;
    this.Rvo = false;
    this.Rvp = false;
    this.Rvq = false;
    this.adUO = true;
    this.adUQ = new e((byte)0);
    this.adUR = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142262);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        if (MMViewPager.p(MMViewPager.this) != null) {
          MMViewPager.p(MMViewPager.this).longClickOver();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(142262);
        return true;
      }
    };
    this.adUS = 60;
    this.adUT = 500;
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
    if ((getAdapter().getItemPosition(paramView) == firstItemPosForDetermine()) || (this.adUI))
    {
      if ((this.adUw instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.adUw).getTranslationX();
        paramFloat2 *= 0.3F;
        Log.d("MicroMsg.MMViewPager", "alvinluo scrollFirst current is WxImageView, distanceX: %f, translateLeft: %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
        if ((paramFloat2 < 0.0F) && (paramFloat1 - paramFloat2 > 0.0F)) {
          this.adUB = true;
        }
        if (this.adUB)
        {
          ((WxImageView)this.adUw).A(-paramFloat2, 0.0F);
          AppMethodBeat.o(142294);
          return true;
        }
        AppMethodBeat.o(142294);
        return false;
      }
      if (this.adUB)
      {
        if (paramFloat2 < 0.0F)
        {
          if (paramFloat1 > this.HRw.left) {
            break label182;
          }
          this.adUw.be(-paramFloat2, 0.0F);
        }
        label182:
        do
        {
          AppMethodBeat.o(142294);
          return false;
          if ((paramFloat1 > this.HRw.left) && (paramFloat1 < this.sJv * 0.3F))
          {
            this.adUw.be(-(paramFloat2 * 0.3F), 0.0F);
            AppMethodBeat.o(142294);
            return true;
          }
        } while ((!this.adUI) || (paramFloat1 <= this.HRw.left));
        this.adUw.be(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142294);
        return true;
      }
      if (paramFloat2 < 0.0F)
      {
        if (paramFloat1 > 0.0F) {
          this.adUB = true;
        }
        if (paramFloat1 > this.HRw.left) {
          break label338;
        }
        this.adUw.be(-paramFloat2, 0.0F);
      }
    }
    while ((this.adUA) || (this.adUz))
    {
      AppMethodBeat.o(142294);
      return false;
      label338:
      if ((paramFloat1 > this.HRw.left) && (paramFloat1 < this.sJv * 0.3F))
      {
        this.adUw.be(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142294);
        return true;
      }
      if ((this.adUI) && (paramFloat1 > this.HRw.left))
      {
        this.adUw.be(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142294);
        return true;
      }
    }
    this.adUB = false;
    AppMethodBeat.o(142294);
    return false;
  }
  
  private boolean b(float paramFloat1, View paramView, float paramFloat2)
  {
    AppMethodBeat.i(142295);
    if ((getAdapter().getItemPosition(paramView) == lastItemPosForDetermine()) || (this.adUI))
    {
      if ((this.adUw instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.adUw).getTranslationX();
        paramFloat2 *= 0.3F;
        if ((paramFloat2 > 0.0F) && (paramFloat1 - paramFloat2 < 0.0F)) {
          this.adUC = true;
        }
        if (this.adUC)
        {
          ((WxImageView)this.adUw).A(-paramFloat2, 0.0F);
          AppMethodBeat.o(142295);
          return true;
        }
        AppMethodBeat.o(142295);
        return false;
      }
      if (this.adUC)
      {
        if (paramFloat2 > 0.0F)
        {
          if (paramFloat1 < this.sJv) {
            break label153;
          }
          this.adUw.be(-paramFloat2, 0.0F);
        }
        for (;;)
        {
          AppMethodBeat.o(142295);
          return false;
          label153:
          if ((paramFloat1 > this.sJv * 0.7F) && (paramFloat1 < this.sJv))
          {
            this.adUw.be(-(paramFloat2 * 0.3F), 0.0F);
            AppMethodBeat.o(142295);
            return true;
          }
          if ((this.adUI) && (paramFloat1 < this.sJv)) {
            this.adUw.be(-(paramFloat2 * 0.3F), 0.0F);
          }
        }
      }
      if (paramFloat2 > 0.0F)
      {
        if (paramFloat1 < this.sJv) {
          this.adUC = true;
        }
        if (paramFloat1 < this.sJv) {
          break label302;
        }
        this.adUw.be(-paramFloat2, 0.0F);
      }
    }
    while ((this.adUA) || (this.adUz))
    {
      AppMethodBeat.o(142295);
      return false;
      label302:
      if ((paramFloat1 > this.sJv * 0.7F) && (paramFloat1 < this.sJv))
      {
        this.adUw.be(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142295);
        return true;
      }
      if ((this.adUI) && (paramFloat1 < this.sJv)) {
        this.adUw.be(-(paramFloat2 * 0.3F), 0.0F);
      }
    }
    this.adUC = false;
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
  
  private void fBX()
  {
    AppMethodBeat.i(142285);
    this.adUx.removeMessages(1);
    AppMethodBeat.o(142285);
  }
  
  private void fBY()
  {
    AppMethodBeat.i(142286);
    fBX();
    l locall = this.adUx;
    locall.HRP = 15L;
    locall.sendEmptyMessageDelayed(1, 15L);
    AppMethodBeat.o(142286);
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
    int j = this.sJv;
    int k = getAdapter().getCount();
    int m = getCurrentItem();
    AppMethodBeat.o(142302);
    return i - j * (k - m - 1);
  }
  
  private MultiTouchImageView getSelectedMultiTouchImageView()
  {
    AppMethodBeat.i(142299);
    int i = getCurrentItem();
    MultiTouchImageView localMultiTouchImageView = ((ab)getAdapter()).WN(i);
    AppMethodBeat.o(142299);
    return localMultiTouchImageView;
  }
  
  private WxImageView getSelectedWxImageView()
  {
    AppMethodBeat.i(142300);
    int i = getCurrentItem();
    WxImageView localWxImageView = ((ab)getAdapter()).WO(i);
    if (localWxImageView != null)
    {
      localWxImageView = (WxImageView)localWxImageView;
      AppMethodBeat.o(142300);
      return localWxImageView;
    }
    AppMethodBeat.o(142300);
    return null;
  }
  
  private void jmP()
  {
    AppMethodBeat.i(142288);
    this.HOl = getSelectedWxImageView();
    if (this.HOl != null)
    {
      Log.d("MicroMsg.MMViewPager", "alvinluo ViewPager initWxImageView");
      this.HOl.setGestureDetectorListener(this.adUQ);
      this.HOl.setOnLongClickListener(this.adUR);
    }
    AppMethodBeat.o(142288);
  }
  
  private boolean jmQ()
  {
    AppMethodBeat.i(142289);
    i locali = getSelectedImageView();
    if ((locali != null) && ((locali instanceof WxImageView)))
    {
      AppMethodBeat.o(142289);
      return true;
    }
    AppMethodBeat.o(142289);
    return false;
  }
  
  private boolean jmR()
  {
    AppMethodBeat.i(142293);
    Log.d("MicroMsg.MMViewPager", "dancy scroll left right !!");
    if (this.adUz)
    {
      AppMethodBeat.o(142293);
      return true;
    }
    this.adUA = true;
    AppMethodBeat.o(142293);
    return false;
  }
  
  public void computeScroll()
  {
    int m = 0;
    AppMethodBeat.i(142304);
    super.computeScroll();
    if (this.adUw == null)
    {
      AppMethodBeat.o(142304);
      return;
    }
    float f3 = this.adUw.getScale();
    float f4 = this.adUw.getImageWidth();
    float f1 = this.adUw.getScale() * this.adUw.getImageHeight();
    float f5;
    int j;
    int k;
    if (this.HRu.computeScrollOffset())
    {
      i = this.HRu.getCurrX() - this.caG;
      int n = this.HRu.getCurrY() - this.caH;
      this.caG = this.HRu.getCurrX();
      this.caH = this.HRu.getCurrY();
      float[] arrayOfFloat = new float[9];
      this.adUw.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f3 * f4 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.HRw.right - Math.round(f3)) {
          j = (int)(this.HRw.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.HRw.left - Math.round(f2)) {
          i = (int)(this.HRw.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.HRw.bottom - Math.round(f5)) {
          k = (int)(this.HRw.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.HRw.top - Math.round(f4)) {
          j = (int)(this.HRw.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.HRw.left) && (Math.round(f3) > this.HRw.right)) {
        break label449;
      }
      k = 0;
      if (f1 >= this.pvg) {
        break label497;
      }
    }
    label449:
    label497:
    for (int i = m;; i = j)
    {
      this.adUw.be(k, i);
      postInvalidate();
      AppMethodBeat.o(142304);
      return;
      if (Math.round(f4) < this.HRw.top)
      {
        k = i;
        if (Math.round(f5) > this.HRw.bottom) {
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
      if (this.HOl == null) {
        jmP();
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
    int i = ((ab)getAdapter()).firstItemPosForDetermine();
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
    return this.sJv;
  }
  
  public i getSelectedImageView()
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
    View localView = ((ab)getAdapter()).aAZ(i);
    AppMethodBeat.o(142297);
    return localView;
  }
  
  public int getXDown()
  {
    return (int)this.x_down;
  }
  
  public int getYDown()
  {
    return (int)this.y_down;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  public int lastItemPosForDetermine()
  {
    AppMethodBeat.i(142308);
    int i = ((ab)getAdapter()).lastItemPosForDetermine();
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
    this.adUL = false;
    if (!jmQ())
    {
      AppMethodBeat.o(142291);
      return bool;
    }
    if (bool)
    {
      AppMethodBeat.o(142291);
      return bool;
    }
    if (this.puS == null) {
      this.puS = VelocityTracker.obtain();
    }
    this.puS.addMovement(paramMotionEvent);
    VelocityTracker localVelocityTracker = this.puS;
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
        this.x_down = paramMotionEvent.getRawX();
        this.y_down = paramMotionEvent.getRawY();
        this.HRy = this.HOl.getScale();
      }
      this.adUL = bool;
      AppMethodBeat.o(142291);
      return bool;
      this.puQ = paramMotionEvent.getRawX();
      this.puR = paramMotionEvent.getRawY();
      bool = false;
      continue;
      if (this.adUI)
      {
        bool = true;
      }
      else
      {
        float f = paramMotionEvent.getRawX() - this.puQ;
        Log.d("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f), Float.valueOf(paramMotionEvent.getRawY() - this.puR), Integer.valueOf(i), Integer.valueOf(j) });
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
    this.sJv = View.MeasureSpec.getSize(paramInt1);
    this.pvg = View.MeasureSpec.getSize(paramInt2);
    this.HRw.set(0.0F, 0.0F, this.sJv, this.pvg);
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
  
  public void setAdapter(androidx.viewpager.widget.a parama)
  {
    AppMethodBeat.i(251418);
    if ((parama instanceof ab))
    {
      super.setAdapter(parama);
      AppMethodBeat.o(251418);
      return;
    }
    parama = new IllegalArgumentException("must be MMViewPagerAdapter");
    AppMethodBeat.o(251418);
    throw parama;
  }
  
  public void setDoubleClickListener(MMViewPager.a parama)
  {
    this.adUH = parama;
  }
  
  public void setEnableGalleryScale(boolean paramBoolean)
  {
    this.adUO = paramBoolean;
  }
  
  public void setGalleryScaleListener(c paramc)
  {
    this.adUP = paramc;
  }
  
  public void setLongClickOverListener(d paramd)
  {
    this.adUG = paramd;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.adUJ = paramOnPageChangeListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.pWX = paramOnTouchListener;
  }
  
  public void setSingleClickOverListener(f paramf)
  {
    this.adUF = paramf;
  }
  
  public void setSingleMode(boolean paramBoolean)
  {
    this.adUI = paramBoolean;
    if (!paramBoolean) {
      this.HRt = false;
    }
  }
  
  abstract class b
  {
    protected boolean hcg = false;
    
    public b() {}
    
    public final boolean efT()
    {
      return this.hcg;
    }
    
    public abstract void play();
  }
  
  public static abstract interface c
  {
    public abstract void aW(float paramFloat1, float paramFloat2);
    
    public abstract void onGalleryScale(float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface d
  {
    public abstract void longClickOver();
  }
  
  final class e
    extends GestureDetector.SimpleOnGestureListener
  {
    private e() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(251429);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(251429);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(142266);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      if (MMViewPager.a(MMViewPager.this) == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(142266);
        return false;
      }
      if ((MMViewPager.t(MMViewPager.this) != null) && (MMViewPager.t(MMViewPager.this).an(paramMotionEvent)))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(142266);
        return true;
      }
      if (MMViewPager.a(MMViewPager.this).getScale() <= MMViewPager.a(MMViewPager.this).getScaleRate()) {
        MMViewPager.a(MMViewPager.this).ag(g.k(paramMotionEvent, 0), g.l(paramMotionEvent, 0));
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(142266);
        return true;
        MMViewPager.a(MMViewPager.this).bd(g.k(paramMotionEvent, 0), g.l(paramMotionEvent, 0));
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
          f2 = ((i)localObject1).getScale() * ((i)localObject1).getImageWidth();
          f3 = ((i)localObject1).getScale() * ((i)localObject1).getImageHeight();
          if ((!((i)localObject1).jlY()) && (!((i)localObject1).jlZ()) && ((int)f2 <= MMViewPager.b(MMViewPager.this)) && ((int)f3 <= MMViewPager.d(MMViewPager.this))) {
            break label485;
          }
          localObject2 = new float[9];
          ((i)localObject1).getImageMatrix().getValues((float[])localObject2);
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
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
      MMViewPager.s(MMViewPager.this);
      if (MMViewPager.p(MMViewPager.this) != null) {
        MMViewPager.p(MMViewPager.this).longClickOver();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(142265);
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(142263);
      if (MMViewPager.q(MMViewPager.this) != null) {
        MMViewPager.q(MMViewPager.this).singleClickOver();
      }
      AppMethodBeat.o(142263);
      return true;
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(251428);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(251428);
      return bool;
    }
  }
  
  public static abstract interface f
  {
    public abstract void fBN();
    
    public abstract void singleClickOver();
  }
  
  final class g
    extends MMViewPager.b
  {
    float[] HRJ;
    
    public g()
    {
      super();
      AppMethodBeat.i(142269);
      this.HRJ = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.g.this.HRJ);
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f2 = MMViewPager.a(MMViewPager.this).getImageHeight() * f1;
          float f3 = MMViewPager.g.this.HRJ[5];
          f1 = MMViewPager.d(MMViewPager.this);
          if (f2 < MMViewPager.d(MMViewPager.this)) {
            f1 = MMViewPager.d(MMViewPager.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
            f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationY();
          }
          if (f1 <= 0.0F) {
            MMViewPager.g.this.hcg = true;
          }
          for (;;)
          {
            MMViewPager.a(MMViewPager.this).be(0.0F, f1);
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              ((WxImageView)MMViewPager.a(MMViewPager.this)).A(0.0F, f1);
            }
            AppMethodBeat.o(142268);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMViewPager.g.this.hcg = true;
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
    float[] HRJ;
    
    public h()
    {
      super();
      AppMethodBeat.i(142272);
      this.HRJ = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.h.this.HRJ);
          float f5 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageWidth();
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f8 = MMViewPager.a(MMViewPager.this).getImageHeight() * f1;
          float f7 = MMViewPager.h.this.HRJ[2];
          float f10 = MMViewPager.h.this.HRJ[5];
          float f6 = MMViewPager.h.this.HRJ[2];
          float f9 = MMViewPager.h.this.HRJ[5];
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
                    MMViewPager.h.this.hcg = true;
                  }
                  for (;;)
                  {
                    MMViewPager.a(MMViewPager.this).be(f2, f1);
                    if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
                      ((WxImageView)MMViewPager.a(MMViewPager.this)).A(-f2, -f1);
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
    float[] HRJ;
    
    public i()
    {
      super();
      AppMethodBeat.i(142275);
      this.HRJ = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.i.this.HRJ);
          float f2 = MMViewPager.i.this.HRJ[2];
          float f1 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageWidth();
          if (f1 < MMViewPager.b(MMViewPager.this)) {}
          for (f1 = MMViewPager.b(MMViewPager.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationX();
            }
            if (f1 >= 0.0F) {
              MMViewPager.i.this.hcg = true;
            }
            for (;;)
            {
              MMViewPager.a(MMViewPager.this).be(f1, 0.0F);
              if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
                ((WxImageView)MMViewPager.a(MMViewPager.this)).A(f1, 0.0F);
              }
              AppMethodBeat.o(142274);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMViewPager.i.this.hcg = true;
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
    float[] HRJ;
    
    public j()
    {
      super();
      AppMethodBeat.i(142278);
      this.HRJ = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.j.this.HRJ);
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f2 = MMViewPager.a(MMViewPager.this).getImageWidth() * f1;
          float f3 = MMViewPager.j.this.HRJ[2];
          f1 = MMViewPager.b(MMViewPager.this);
          if (f2 < MMViewPager.b(MMViewPager.this)) {
            f1 = MMViewPager.b(MMViewPager.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
            f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationX();
          }
          if (f1 <= 0.0F) {
            MMViewPager.j.this.hcg = true;
          }
          for (;;)
          {
            MMViewPager.a(MMViewPager.this).be(f1, 0.0F);
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              ((WxImageView)MMViewPager.a(MMViewPager.this)).A(f1, 0.0F);
            }
            AppMethodBeat.o(142277);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMViewPager.j.this.hcg = true;
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
    float[] HRJ;
    
    public k()
    {
      super();
      AppMethodBeat.i(142281);
      this.HRJ = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.k.this.HRJ);
          float f2 = MMViewPager.k.this.HRJ[5];
          float f1 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageHeight();
          if (f1 < MMViewPager.d(MMViewPager.this)) {}
          for (f1 = MMViewPager.d(MMViewPager.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationY();
            }
            if (f1 >= 0.0F) {
              MMViewPager.k.this.hcg = true;
            }
            for (;;)
            {
              MMViewPager.a(MMViewPager.this).be(0.0F, f1);
              if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
                ((WxImageView)MMViewPager.a(MMViewPager.this)).A(0.0F, f1);
              }
              AppMethodBeat.o(142280);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMViewPager.k.this.hcg = true;
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
    WeakReference<MMViewPager> HNs;
    long HRP;
    
    public l(WeakReference<MMViewPager> paramWeakReference)
    {
      this.HNs = paramWeakReference;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(142283);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.HNs != null)
      {
        MMViewPager localMMViewPager = (MMViewPager)this.HNs.get();
        if ((localMMViewPager != null) && (paramMessage.what == 1))
        {
          if ((MMViewPager.v(localMMViewPager) != null) && (!MMViewPager.v(localMMViewPager).efT()))
          {
            MMViewPager.v(localMMViewPager).play();
            sendEmptyMessageDelayed(paramMessage.what, this.HRP);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager
 * JD-Core Version:    0.7.0.1
 */