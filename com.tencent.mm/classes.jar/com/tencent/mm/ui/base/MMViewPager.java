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
  private float BpT;
  private float BpU;
  private VelocityTracker BpV;
  private WxImageView Ccj;
  private boolean Cfm;
  private OverScroller Cfn;
  private RectF Cfp;
  private float Cfr;
  private boolean Cfs;
  private boolean Cft;
  private boolean Cfu;
  private boolean Cfv;
  private boolean KVq;
  private boolean KVr;
  private boolean KVs;
  private c WnA;
  private GestureDetector.SimpleOnGestureListener WnB;
  private View.OnLongClickListener WnC;
  private final int WnD;
  private final int WnE;
  private g Wnh;
  public l Wni;
  private boolean Wnj;
  private boolean Wnk;
  private boolean Wnl;
  private boolean Wnm;
  private boolean Wnn;
  private int Wno;
  private b Wnp;
  private f Wnq;
  private d Wnr;
  private MMViewPager.a Wns;
  private boolean Wnt;
  private ViewPager.OnPageChangeListener Wnu;
  private float Wnv;
  private boolean Wnw;
  private MotionEvent Wnx;
  private long Wny;
  private boolean Wnz;
  private float aIC;
  private float aID;
  private int aiM;
  private int amg;
  private int amh;
  private float eYT;
  private MMHandler handler;
  private int lL;
  private VelocityTracker mVelocityTracker;
  private View.OnTouchListener nan;
  private GestureDetector pCU;
  private int pEj;
  private int pEk;
  
  public MMViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142287);
    this.aiM = -1;
    this.lL = -1;
    this.Cfm = false;
    this.Wnj = false;
    this.Wnk = false;
    this.Wnl = false;
    this.Wnm = false;
    this.Wnn = false;
    this.Cfs = false;
    this.Cft = false;
    this.Cfu = false;
    this.Cfv = false;
    this.Cfp = new RectF();
    this.Wno = 0;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Wnt = false;
    this.Wnu = null;
    this.Wnv = 0.0F;
    this.BpV = null;
    this.Wnw = false;
    this.Wny = 0L;
    this.aIC = 0.0F;
    this.aID = 0.0F;
    this.KVq = false;
    this.KVr = false;
    this.KVs = false;
    this.Wnz = true;
    this.WnB = new e((byte)0);
    this.WnC = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142262);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        if (MMViewPager.p(MMViewPager.this) != null) {
          MMViewPager.p(MMViewPager.this).bwC();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(142262);
        return true;
      }
    };
    this.WnD = 60;
    this.WnE = 500;
    setStaticTransformationsEnabled(true);
    this.Wni = new l(new WeakReference(this));
    this.pCU = new GestureDetector(paramContext, new e((byte)0));
    this.Cfn = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    this.Wno = ((int)(getResources().getDisplayMetrics().density * 3000.0F));
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
            paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousMotionEvent.aFh(), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.sf(0)), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
          paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousMotionEvent.aFh(), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.sf(0)), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
    this.aiM = -1;
    this.lL = -1;
    this.Cfm = false;
    this.Wnj = false;
    this.Wnk = false;
    this.Wnl = false;
    this.Wnm = false;
    this.Wnn = false;
    this.Cfs = false;
    this.Cft = false;
    this.Cfu = false;
    this.Cfv = false;
    this.Cfp = new RectF();
    this.Wno = 0;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Wnt = false;
    this.Wnu = null;
    this.Wnv = 0.0F;
    this.BpV = null;
    this.Wnw = false;
    this.Wny = 0L;
    this.aIC = 0.0F;
    this.aID = 0.0F;
    this.KVq = false;
    this.KVr = false;
    this.KVs = false;
    this.Wnz = true;
    this.WnB = new e((byte)0);
    this.WnC = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142262);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        if (MMViewPager.p(MMViewPager.this) != null) {
          MMViewPager.p(MMViewPager.this).bwC();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(142262);
        return true;
      }
    };
    this.WnD = 60;
    this.WnE = 500;
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
    if ((getAdapter().getItemPosition(paramView) == firstItemPosForDetermine()) || (this.Wnt))
    {
      if ((this.Wnh instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.Wnh).getTranslationX();
        paramFloat2 *= 0.3F;
        Log.d("MicroMsg.MMViewPager", "alvinluo scrollFirst current is WxImageView, distanceX: %f, translateLeft: %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
        if ((paramFloat2 < 0.0F) && (paramFloat1 - paramFloat2 > 0.0F)) {
          this.Wnm = true;
        }
        if (this.Wnm)
        {
          ((WxImageView)this.Wnh).aC(-paramFloat2, 0.0F);
          AppMethodBeat.o(142294);
          return true;
        }
        AppMethodBeat.o(142294);
        return false;
      }
      if (this.Wnm)
      {
        if (paramFloat2 < 0.0F)
        {
          if (paramFloat1 > this.Cfp.left) {
            break label182;
          }
          this.Wnh.az(-paramFloat2, 0.0F);
        }
        label182:
        do
        {
          AppMethodBeat.o(142294);
          return false;
          if ((paramFloat1 > this.Cfp.left) && (paramFloat1 < this.pEj * 0.3F))
          {
            this.Wnh.az(-(paramFloat2 * 0.3F), 0.0F);
            AppMethodBeat.o(142294);
            return true;
          }
        } while ((!this.Wnt) || (paramFloat1 <= this.Cfp.left));
        this.Wnh.az(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142294);
        return true;
      }
      if (paramFloat2 < 0.0F)
      {
        if (paramFloat1 > 0.0F) {
          this.Wnm = true;
        }
        if (paramFloat1 > this.Cfp.left) {
          break label338;
        }
        this.Wnh.az(-paramFloat2, 0.0F);
      }
    }
    while ((this.Wnl) || (this.Wnk))
    {
      AppMethodBeat.o(142294);
      return false;
      label338:
      if ((paramFloat1 > this.Cfp.left) && (paramFloat1 < this.pEj * 0.3F))
      {
        this.Wnh.az(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142294);
        return true;
      }
      if ((this.Wnt) && (paramFloat1 > this.Cfp.left))
      {
        this.Wnh.az(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142294);
        return true;
      }
    }
    this.Wnm = false;
    AppMethodBeat.o(142294);
    return false;
  }
  
  private boolean b(float paramFloat1, View paramView, float paramFloat2)
  {
    AppMethodBeat.i(142295);
    if ((getAdapter().getItemPosition(paramView) == lastItemPosForDetermine()) || (this.Wnt))
    {
      if ((this.Wnh instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.Wnh).getTranslationX();
        paramFloat2 *= 0.3F;
        if ((paramFloat2 > 0.0F) && (paramFloat1 - paramFloat2 < 0.0F)) {
          this.Wnn = true;
        }
        if (this.Wnn)
        {
          ((WxImageView)this.Wnh).aC(-paramFloat2, 0.0F);
          AppMethodBeat.o(142295);
          return true;
        }
        AppMethodBeat.o(142295);
        return false;
      }
      if (this.Wnn)
      {
        if (paramFloat2 > 0.0F)
        {
          if (paramFloat1 < this.pEj) {
            break label153;
          }
          this.Wnh.az(-paramFloat2, 0.0F);
        }
        for (;;)
        {
          AppMethodBeat.o(142295);
          return false;
          label153:
          if ((paramFloat1 > this.pEj * 0.7F) && (paramFloat1 < this.pEj))
          {
            this.Wnh.az(-(paramFloat2 * 0.3F), 0.0F);
            AppMethodBeat.o(142295);
            return true;
          }
          if ((this.Wnt) && (paramFloat1 < this.pEj)) {
            this.Wnh.az(-(paramFloat2 * 0.3F), 0.0F);
          }
        }
      }
      if (paramFloat2 > 0.0F)
      {
        if (paramFloat1 < this.pEj) {
          this.Wnn = true;
        }
        if (paramFloat1 < this.pEj) {
          break label302;
        }
        this.Wnh.az(-paramFloat2, 0.0F);
      }
    }
    while ((this.Wnl) || (this.Wnk))
    {
      AppMethodBeat.o(142295);
      return false;
      label302:
      if ((paramFloat1 > this.pEj * 0.7F) && (paramFloat1 < this.pEj))
      {
        this.Wnh.az(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142295);
        return true;
      }
      if ((this.Wnt) && (paramFloat1 < this.pEj)) {
        this.Wnh.az(-(paramFloat2 * 0.3F), 0.0F);
      }
    }
    this.Wnn = false;
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
  
  private void eve()
  {
    AppMethodBeat.i(142285);
    this.Wni.removeMessages(1);
    AppMethodBeat.o(142285);
  }
  
  private void evf()
  {
    AppMethodBeat.i(142286);
    eve();
    l locall = this.Wni;
    locall.CfI = 15L;
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
    int j = this.pEj;
    int k = getAdapter().getCount();
    int m = getCurrentItem();
    AppMethodBeat.o(142302);
    return i - j * (k - m - 1);
  }
  
  private MultiTouchImageView getSelectedMultiTouchImageView()
  {
    AppMethodBeat.i(142299);
    int i = getCurrentItem();
    MultiTouchImageView localMultiTouchImageView = ((x)getAdapter()).Tf(i);
    AppMethodBeat.o(142299);
    return localMultiTouchImageView;
  }
  
  private WxImageView getSelectedWxImageView()
  {
    AppMethodBeat.i(142300);
    int i = getCurrentItem();
    WxImageView localWxImageView = ((x)getAdapter()).Tg(i);
    if (localWxImageView != null)
    {
      localWxImageView = (WxImageView)localWxImageView;
      AppMethodBeat.o(142300);
      return localWxImageView;
    }
    AppMethodBeat.o(142300);
    return null;
  }
  
  private void hKi()
  {
    AppMethodBeat.i(142288);
    this.Ccj = getSelectedWxImageView();
    if (this.Ccj != null)
    {
      Log.d("MicroMsg.MMViewPager", "alvinluo ViewPager initWxImageView");
      this.Ccj.setGestureDetectorListener(this.WnB);
      this.Ccj.setOnLongClickListener(this.WnC);
    }
    AppMethodBeat.o(142288);
  }
  
  private boolean hKj()
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
  
  private boolean hKk()
  {
    AppMethodBeat.i(142293);
    Log.d("MicroMsg.MMViewPager", "dancy scroll left right !!");
    if (this.Wnk)
    {
      AppMethodBeat.o(142293);
      return true;
    }
    this.Wnl = true;
    AppMethodBeat.o(142293);
    return false;
  }
  
  public void computeScroll()
  {
    int m = 0;
    AppMethodBeat.i(142304);
    super.computeScroll();
    if (this.Wnh == null)
    {
      AppMethodBeat.o(142304);
      return;
    }
    float f3 = this.Wnh.getScale();
    float f4 = this.Wnh.getImageWidth();
    float f1 = this.Wnh.getScale() * this.Wnh.getImageHeight();
    float f5;
    int j;
    int k;
    if (this.Cfn.computeScrollOffset())
    {
      i = this.Cfn.getCurrX() - this.amg;
      int n = this.Cfn.getCurrY() - this.amh;
      this.amg = this.Cfn.getCurrX();
      this.amh = this.Cfn.getCurrY();
      float[] arrayOfFloat = new float[9];
      this.Wnh.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f3 * f4 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.Cfp.right - Math.round(f3)) {
          j = (int)(this.Cfp.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.Cfp.left - Math.round(f2)) {
          i = (int)(this.Cfp.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.Cfp.bottom - Math.round(f5)) {
          k = (int)(this.Cfp.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.Cfp.top - Math.round(f4)) {
          j = (int)(this.Cfp.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.Cfp.left) && (Math.round(f3) > this.Cfp.right)) {
        break label449;
      }
      k = 0;
      if (f1 >= this.pEk) {
        break label497;
      }
    }
    label449:
    label497:
    for (int i = m;; i = j)
    {
      this.Wnh.az(k, i);
      postInvalidate();
      AppMethodBeat.o(142304);
      return;
      if (Math.round(f4) < this.Cfp.top)
      {
        k = i;
        if (Math.round(f5) > this.Cfp.bottom) {
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
      if (this.Ccj == null) {
        hKi();
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
    int i = ((x)getAdapter()).firstItemPosForDetermine();
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
    return this.pEj;
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
    View localView = ((x)getAdapter()).aiI(i);
    AppMethodBeat.o(142297);
    return localView;
  }
  
  public int getXDown()
  {
    return (int)this.aIC;
  }
  
  public int getYDown()
  {
    return (int)this.aID;
  }
  
  public boolean isFocused()
  {
    return true;
  }
  
  public int lastItemPosForDetermine()
  {
    AppMethodBeat.i(142308);
    int i = ((x)getAdapter()).lastItemPosForDetermine();
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
    this.Wnw = false;
    if (!hKj())
    {
      AppMethodBeat.o(142291);
      return bool;
    }
    if (bool)
    {
      AppMethodBeat.o(142291);
      return bool;
    }
    if (this.BpV == null) {
      this.BpV = VelocityTracker.obtain();
    }
    this.BpV.addMovement(paramMotionEvent);
    VelocityTracker localVelocityTracker = this.BpV;
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
        this.aIC = paramMotionEvent.getRawX();
        this.aID = paramMotionEvent.getRawY();
        this.Cfr = this.Ccj.getScale();
      }
      this.Wnw = bool;
      AppMethodBeat.o(142291);
      return bool;
      this.BpT = paramMotionEvent.getRawX();
      this.BpU = paramMotionEvent.getRawY();
      bool = false;
      continue;
      if (this.Wnt)
      {
        bool = true;
      }
      else
      {
        float f = paramMotionEvent.getRawX() - this.BpT;
        Log.d("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f), Float.valueOf(paramMotionEvent.getRawY() - this.BpU), Integer.valueOf(i), Integer.valueOf(j) });
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
    this.pEj = View.MeasureSpec.getSize(paramInt1);
    this.pEk = View.MeasureSpec.getSize(paramInt2);
    this.Cfp.set(0.0F, 0.0F, this.pEj, this.pEk);
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
    AppMethodBeat.i(194621);
    if ((parama instanceof x))
    {
      super.setAdapter(parama);
      AppMethodBeat.o(194621);
      return;
    }
    parama = new IllegalArgumentException("must be MMViewPagerAdapter");
    AppMethodBeat.o(194621);
    throw parama;
  }
  
  public void setDoubleClickListener(MMViewPager.a parama)
  {
    this.Wns = parama;
  }
  
  public void setEnableGalleryScale(boolean paramBoolean)
  {
    this.Wnz = paramBoolean;
  }
  
  public void setGalleryScaleListener(c paramc)
  {
    this.WnA = paramc;
  }
  
  public void setLongClickOverListener(d paramd)
  {
    this.Wnr = paramd;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.Wnu = paramOnPageChangeListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.nan = paramOnTouchListener;
  }
  
  public void setSingleClickOverListener(f paramf)
  {
    this.Wnq = paramf;
  }
  
  public void setSingleMode(boolean paramBoolean)
  {
    this.Wnt = paramBoolean;
    if (!paramBoolean) {
      this.Cfm = false;
    }
  }
  
  abstract class b
  {
    protected boolean eYG = false;
    
    public b() {}
    
    public final boolean evg()
    {
      return this.eYG;
    }
    
    public abstract void play();
  }
  
  public static abstract interface c
  {
    public abstract void U(float paramFloat1, float paramFloat2);
    
    public abstract void aq(float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface d
  {
    public abstract void bwC();
  }
  
  final class e
    extends GestureDetector.SimpleOnGestureListener
  {
    private e() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(199045);
      b localb = new b();
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(199045);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(142266);
      b localb = new b();
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
      if (MMViewPager.a(MMViewPager.this) == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(142266);
        return false;
      }
      if ((MMViewPager.t(MMViewPager.this) != null) && (MMViewPager.t(MMViewPager.this).ak(paramMotionEvent)))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(142266);
        return true;
      }
      if (MMViewPager.a(MMViewPager.this).getScale() <= MMViewPager.a(MMViewPager.this).getScaleRate()) {
        MMViewPager.a(MMViewPager.this).A(f.j(paramMotionEvent, 0), f.k(paramMotionEvent, 0));
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(142266);
        return true;
        MMViewPager.a(MMViewPager.this).ay(f.j(paramMotionEvent, 0), f.k(paramMotionEvent, 0));
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
          if ((!((g)localObject1).hJv()) && (!((g)localObject1).hJw()) && ((int)f2 <= MMViewPager.b(MMViewPager.this)) && ((int)f3 <= MMViewPager.d(MMViewPager.this))) {
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
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
      MMViewPager.s(MMViewPager.this);
      if (MMViewPager.p(MMViewPager.this) != null) {
        MMViewPager.p(MMViewPager.this).bwC();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(142265);
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(142263);
      if (MMViewPager.q(MMViewPager.this) != null) {
        MMViewPager.q(MMViewPager.this).bwB();
      }
      AppMethodBeat.o(142263);
      return true;
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(199043);
      b localb = new b();
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(199043);
      return bool;
    }
  }
  
  public static abstract interface f
  {
    public abstract void bwB();
    
    public abstract void euS();
  }
  
  final class g
    extends MMViewPager.b
  {
    float[] CfC;
    
    public g()
    {
      super();
      AppMethodBeat.i(142269);
      this.CfC = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.g.this.CfC);
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f2 = MMViewPager.a(MMViewPager.this).getImageHeight() * f1;
          float f3 = MMViewPager.g.this.CfC[5];
          f1 = MMViewPager.d(MMViewPager.this);
          if (f2 < MMViewPager.d(MMViewPager.this)) {
            f1 = MMViewPager.d(MMViewPager.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
            f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationY();
          }
          if (f1 <= 0.0F) {
            MMViewPager.g.this.eYG = true;
          }
          for (;;)
          {
            MMViewPager.a(MMViewPager.this).az(0.0F, f1);
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              ((WxImageView)MMViewPager.a(MMViewPager.this)).aC(0.0F, f1);
            }
            AppMethodBeat.o(142268);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMViewPager.g.this.eYG = true;
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
    float[] CfC;
    
    public h()
    {
      super();
      AppMethodBeat.i(142272);
      this.CfC = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.h.this.CfC);
          float f5 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageWidth();
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f8 = MMViewPager.a(MMViewPager.this).getImageHeight() * f1;
          float f7 = MMViewPager.h.this.CfC[2];
          float f10 = MMViewPager.h.this.CfC[5];
          float f6 = MMViewPager.h.this.CfC[2];
          float f9 = MMViewPager.h.this.CfC[5];
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
                    MMViewPager.h.this.eYG = true;
                  }
                  for (;;)
                  {
                    MMViewPager.a(MMViewPager.this).az(f2, f1);
                    if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
                      ((WxImageView)MMViewPager.a(MMViewPager.this)).aC(-f2, -f1);
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
    float[] CfC;
    
    public i()
    {
      super();
      AppMethodBeat.i(142275);
      this.CfC = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.i.this.CfC);
          float f2 = MMViewPager.i.this.CfC[2];
          float f1 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageWidth();
          if (f1 < MMViewPager.b(MMViewPager.this)) {}
          for (f1 = MMViewPager.b(MMViewPager.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationX();
            }
            if (f1 >= 0.0F) {
              MMViewPager.i.this.eYG = true;
            }
            for (;;)
            {
              MMViewPager.a(MMViewPager.this).az(f1, 0.0F);
              if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
                ((WxImageView)MMViewPager.a(MMViewPager.this)).aC(f1, 0.0F);
              }
              AppMethodBeat.o(142274);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMViewPager.i.this.eYG = true;
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
    float[] CfC;
    
    public j()
    {
      super();
      AppMethodBeat.i(142278);
      this.CfC = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.j.this.CfC);
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f2 = MMViewPager.a(MMViewPager.this).getImageWidth() * f1;
          float f3 = MMViewPager.j.this.CfC[2];
          f1 = MMViewPager.b(MMViewPager.this);
          if (f2 < MMViewPager.b(MMViewPager.this)) {
            f1 = MMViewPager.b(MMViewPager.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
            f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationX();
          }
          if (f1 <= 0.0F) {
            MMViewPager.j.this.eYG = true;
          }
          for (;;)
          {
            MMViewPager.a(MMViewPager.this).az(f1, 0.0F);
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              ((WxImageView)MMViewPager.a(MMViewPager.this)).aC(f1, 0.0F);
            }
            AppMethodBeat.o(142277);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMViewPager.j.this.eYG = true;
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
    float[] CfC;
    
    public k()
    {
      super();
      AppMethodBeat.i(142281);
      this.CfC = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.k.this.CfC);
          float f2 = MMViewPager.k.this.CfC[5];
          float f1 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageHeight();
          if (f1 < MMViewPager.d(MMViewPager.this)) {}
          for (f1 = MMViewPager.d(MMViewPager.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationY();
            }
            if (f1 >= 0.0F) {
              MMViewPager.k.this.eYG = true;
            }
            for (;;)
            {
              MMViewPager.a(MMViewPager.this).az(0.0F, f1);
              if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
                ((WxImageView)MMViewPager.a(MMViewPager.this)).aC(0.0F, f1);
              }
              AppMethodBeat.o(142280);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMViewPager.k.this.eYG = true;
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
    WeakReference<MMViewPager> Cbq;
    long CfI;
    
    public l(WeakReference<MMViewPager> paramWeakReference)
    {
      this.Cbq = paramWeakReference;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(142283);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.Cbq != null)
      {
        MMViewPager localMMViewPager = (MMViewPager)this.Cbq.get();
        if ((localMMViewPager != null) && (paramMessage.what == 1))
        {
          if ((MMViewPager.v(localMMViewPager) != null) && (!MMViewPager.v(localMMViewPager).evg()))
          {
            MMViewPager.v(localMMViewPager).play();
            sendEmptyMessageDelayed(paramMessage.what, this.CfI);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMViewPager
 * JD-Core Version:    0.7.0.1
 */