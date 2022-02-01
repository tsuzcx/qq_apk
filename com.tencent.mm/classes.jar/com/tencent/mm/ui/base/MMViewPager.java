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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.lang.ref.WeakReference;

public class MMViewPager
  extends WxViewPager
{
  private boolean AgO;
  private boolean AgP;
  private boolean AgQ;
  private View.OnTouchListener Cjy;
  private ViewPager.OnPageChangeListener JoA;
  private float JoB;
  private boolean JoC;
  private MotionEvent JoD;
  private long JoE;
  private b JoF;
  private GestureDetector.SimpleOnGestureListener JoG;
  private View.OnLongClickListener JoH;
  private final int JoI;
  private final int JoJ;
  private g Jop;
  public k Joq;
  private boolean Jor;
  private boolean Jos;
  private boolean Jot;
  private boolean Jou;
  private boolean Jov;
  private int Jow;
  private a Jox;
  private e Joy;
  private c Joz;
  private float aZk;
  private float aZl;
  private int afo;
  private int apN;
  private int auq;
  private int aur;
  private float cQi;
  private ap handler;
  private GestureDetector lsn;
  private int ltA;
  private int ltB;
  private VelocityTracker mVelocityTracker;
  private WxImageView tNK;
  private boolean tQI;
  private OverScroller tQJ;
  private RectF tQL;
  private float tQN;
  private boolean tQO;
  private boolean tQP;
  private boolean tQQ;
  private boolean tQR;
  private float yjX;
  private float yjY;
  private VelocityTracker yjZ;
  
  public MMViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142287);
    this.apN = -1;
    this.afo = -1;
    this.tQI = false;
    this.Jor = false;
    this.Jos = false;
    this.Jot = false;
    this.Jou = false;
    this.Jov = false;
    this.tQO = false;
    this.tQP = false;
    this.tQQ = false;
    this.tQR = false;
    this.tQL = new RectF();
    this.Jow = 0;
    this.handler = new ap(Looper.getMainLooper());
    this.JoA = null;
    this.JoB = 0.0F;
    this.yjZ = null;
    this.JoC = false;
    this.JoE = 0L;
    this.aZk = 0.0F;
    this.aZl = 0.0F;
    this.AgO = false;
    this.AgP = false;
    this.AgQ = false;
    this.JoG = new d((byte)0);
    this.JoH = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142262);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        if (MMViewPager.p(MMViewPager.this) != null) {
          MMViewPager.p(MMViewPager.this).aRq();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(142262);
        return true;
      }
    };
    this.JoI = 60;
    this.JoJ = 500;
    setStaticTransformationsEnabled(true);
    this.Joq = new k(new WeakReference(this));
    this.lsn = new GestureDetector(paramContext, new d((byte)0));
    this.tQJ = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    this.Jow = ((int)(getResources().getDisplayMetrics().density * 3000.0F));
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
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        ad.d("MicroMsg.MMViewPager", "alvinluo onTouch getCurrentItem: %d", new Object[] { Integer.valueOf(MMViewPager.this.getCurrentItem()) });
        if (MMViewPager.k(MMViewPager.this) != null) {}
        for (boolean bool1 = MMViewPager.k(MMViewPager.this).onTouch(paramAnonymousView, paramAnonymousMotionEvent);; bool1 = false)
        {
          paramAnonymousView = MMViewPager.this.getSelectedImageView();
          if (paramAnonymousView == null)
          {
            MMViewPager.a(MMViewPager.this, paramAnonymousMotionEvent);
            MMViewPager.b(MMViewPager.this, null);
            paramAnonymousView = MMViewPager.l(MMViewPager.this);
            paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousMotionEvent.ahp(), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.mq(0)), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            if ((MMViewPager.m(MMViewPager.this)) || (MMViewPager.n(MMViewPager.this)))
            {
              com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(142261);
              return true;
            }
            com.tencent.mm.hellhoundlib.a.a.a(bool1, this, "com/tencent/mm/ui/base/MMViewPager$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
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
          paramAnonymousMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousMotionEvent.ahp(), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)paramAnonymousMotionEvent.mq(0)), "com/tencent/mm/ui/base/MMViewPager$2", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          MMViewPager.this.computeScroll();
          if ((bool2) || (bool1)) {}
          for (bool1 = true;; bool1 = false)
          {
            com.tencent.mm.hellhoundlib.a.a.a(bool1, this, "com/tencent/mm/ui/base/MMViewPager$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(142261);
            return bool1;
          }
        }
      }
    });
    AppMethodBeat.o(142287);
  }
  
  public MMViewPager(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142284);
    this.apN = -1;
    this.afo = -1;
    this.tQI = false;
    this.Jor = false;
    this.Jos = false;
    this.Jot = false;
    this.Jou = false;
    this.Jov = false;
    this.tQO = false;
    this.tQP = false;
    this.tQQ = false;
    this.tQR = false;
    this.tQL = new RectF();
    this.Jow = 0;
    this.handler = new ap(Looper.getMainLooper());
    this.JoA = null;
    this.JoB = 0.0F;
    this.yjZ = null;
    this.JoC = false;
    this.JoE = 0L;
    this.aZk = 0.0F;
    this.aZl = 0.0F;
    this.AgO = false;
    this.AgP = false;
    this.AgQ = false;
    this.JoG = new d((byte)0);
    this.JoH = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142262);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
        if (MMViewPager.p(MMViewPager.this) != null) {
          MMViewPager.p(MMViewPager.this).aRq();
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(142262);
        return true;
      }
    };
    this.JoI = 60;
    this.JoJ = 500;
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
      if ((this.Jop instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.Jop).getTranslationX();
        paramFloat2 *= 0.3F;
        ad.d("MicroMsg.MMViewPager", "alvinluo scrollFirst current is WxImageView, distanceX: %f, translateLeft: %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
        if ((paramFloat2 < 0.0F) && (paramFloat1 - paramFloat2 > 0.0F)) {
          this.Jou = true;
        }
        if (this.Jou)
        {
          ((WxImageView)this.Jop).translate(-paramFloat2, 0.0F);
          AppMethodBeat.o(142294);
          return true;
        }
        AppMethodBeat.o(142294);
        return false;
      }
      if (this.Jou)
      {
        if (paramFloat2 < 0.0F)
        {
          if (paramFloat1 > this.tQL.left) {
            break label175;
          }
          this.Jop.ao(-paramFloat2, 0.0F);
        }
        label175:
        while ((paramFloat1 <= this.tQL.left) || (paramFloat1 >= this.ltA * 0.3F))
        {
          AppMethodBeat.o(142294);
          return false;
        }
        this.Jop.ao(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142294);
        return true;
      }
      if (paramFloat2 < 0.0F)
      {
        if (paramFloat1 > 0.0F) {
          this.Jou = true;
        }
        if (paramFloat1 > this.tQL.left) {
          break label288;
        }
        this.Jop.ao(-paramFloat2, 0.0F);
      }
    }
    while ((this.Jot) || (this.Jos))
    {
      AppMethodBeat.o(142294);
      return false;
      label288:
      if ((paramFloat1 > this.tQL.left) && (paramFloat1 < this.ltA * 0.3F))
      {
        this.Jop.ao(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142294);
        return true;
      }
    }
    this.Jou = false;
    AppMethodBeat.o(142294);
    return false;
  }
  
  private boolean b(float paramFloat1, View paramView, float paramFloat2)
  {
    AppMethodBeat.i(142295);
    if (getAdapter().getItemPosition(paramView) == lastItemPosForDetermine())
    {
      if ((this.Jop instanceof WxImageView))
      {
        paramFloat1 = ((WxImageView)this.Jop).getTranslationX();
        paramFloat2 *= 0.3F;
        ad.d("MicroMsg.MMViewPager", "alvinluo scrollLast current is WxImageView, distanceX: %f, translateRight: %f", new Object[] { Float.valueOf(paramFloat2), Float.valueOf(paramFloat1) });
        if ((paramFloat2 > 0.0F) && (paramFloat1 - paramFloat2 < 0.0F)) {
          this.Jov = true;
        }
        if (this.Jov)
        {
          ((WxImageView)this.Jop).translate(-paramFloat2, 0.0F);
          AppMethodBeat.o(142295);
          return true;
        }
        AppMethodBeat.o(142295);
        return false;
      }
      if (this.Jov)
      {
        if (paramFloat2 > 0.0F)
        {
          if (paramFloat1 < this.ltA) {
            break label173;
          }
          this.Jop.ao(-paramFloat2, 0.0F);
        }
        label173:
        while ((paramFloat1 <= this.ltA * 0.7F) || (paramFloat1 >= this.ltB))
        {
          AppMethodBeat.o(142295);
          return false;
        }
        this.Jop.ao(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142295);
        return true;
      }
      if (paramFloat2 > 0.0F)
      {
        if (paramFloat1 < this.ltA) {
          this.Jov = true;
        }
        if (paramFloat1 < this.ltA) {
          break label286;
        }
        this.Jop.ao(-paramFloat2, 0.0F);
      }
    }
    while ((this.Jot) || (this.Jos))
    {
      AppMethodBeat.o(142295);
      return false;
      label286:
      if ((paramFloat1 > this.ltA * 0.7F) && (paramFloat1 < this.ltB))
      {
        this.Jop.ao(-(paramFloat2 * 0.3F), 0.0F);
        AppMethodBeat.o(142295);
        return true;
      }
    }
    this.Jov = false;
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
  
  private void cWx()
  {
    AppMethodBeat.i(142285);
    this.Joq.removeMessages(1);
    AppMethodBeat.o(142285);
  }
  
  private void cWy()
  {
    AppMethodBeat.i(142286);
    cWx();
    k localk = this.Joq;
    localk.tRe = 15L;
    localk.sendEmptyMessageDelayed(1, 15L);
    AppMethodBeat.o(142286);
  }
  
  private void fzj()
  {
    AppMethodBeat.i(142288);
    this.tNK = getSelectedWxImageView();
    if (this.tNK != null)
    {
      ad.d("MicroMsg.MMViewPager", "alvinluo ViewPager initWxImageView");
      this.tNK.setGestureDetectorListener(this.JoG);
      this.tNK.setOnLongClickListener(this.JoH);
      this.tNK.fyy();
    }
    AppMethodBeat.o(142288);
  }
  
  private boolean fzk()
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
  
  private boolean fzl()
  {
    AppMethodBeat.i(142293);
    ad.d("MicroMsg.MMViewPager", "dancy scroll left right !!");
    if (this.Jos)
    {
      AppMethodBeat.o(142293);
      return true;
    }
    this.Jot = true;
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
    int j = this.ltA;
    int k = getAdapter().getCount();
    int m = getCurrentItem();
    AppMethodBeat.o(142302);
    return i - j * (k - m - 1);
  }
  
  private MultiTouchImageView getSelectedMultiTouchImageView()
  {
    AppMethodBeat.i(142299);
    int i = getCurrentItem();
    MultiTouchImageView localMultiTouchImageView = ((u)getAdapter()).Hq(i);
    AppMethodBeat.o(142299);
    return localMultiTouchImageView;
  }
  
  private WxImageView getSelectedWxImageView()
  {
    AppMethodBeat.i(142300);
    int i = getCurrentItem();
    WxImageView localWxImageView = ((u)getAdapter()).Hr(i);
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
    if (this.Jop == null)
    {
      AppMethodBeat.o(142304);
      return;
    }
    float f3 = this.Jop.getScale();
    float f4 = this.Jop.getImageWidth();
    float f1 = this.Jop.getScale() * this.Jop.getImageHeight();
    float f5;
    int j;
    int k;
    if (this.tQJ.computeScrollOffset())
    {
      i = this.tQJ.getCurrX() - this.auq;
      int n = this.tQJ.getCurrY() - this.aur;
      this.auq = this.tQJ.getCurrX();
      this.aur = this.tQJ.getCurrY();
      float[] arrayOfFloat = new float[9];
      this.Jop.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f3 * f4 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.tQL.right - Math.round(f3)) {
          j = (int)(this.tQL.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.tQL.left - Math.round(f2)) {
          i = (int)(this.tQL.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.tQL.bottom - Math.round(f5)) {
          k = (int)(this.tQL.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.tQL.top - Math.round(f4)) {
          j = (int)(this.tQL.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.tQL.left) && (Math.round(f3) > this.tQL.right)) {
        break label449;
      }
      k = 0;
      if (f1 >= this.ltB) {
        break label497;
      }
    }
    label449:
    label497:
    for (int i = m;; i = j)
    {
      this.Jop.ao(k, i);
      postInvalidate();
      AppMethodBeat.o(142304);
      return;
      if (Math.round(f4) < this.tQL.top)
      {
        k = i;
        if (Math.round(f5) > this.tQL.bottom) {
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
      if (this.tNK == null) {
        fzj();
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
    return this.ltA;
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
    View localView = ((u)getAdapter()).SJ(i);
    AppMethodBeat.o(142297);
    return localView;
  }
  
  public int getXDown()
  {
    return (int)this.aZk;
  }
  
  public int getYDown()
  {
    return (int)this.aZl;
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
    this.JoC = false;
    if (!fzk())
    {
      AppMethodBeat.o(142291);
      return bool;
    }
    if (bool)
    {
      AppMethodBeat.o(142291);
      return bool;
    }
    if (this.yjZ == null) {
      this.yjZ = VelocityTracker.obtain();
    }
    this.yjZ.addMovement(paramMotionEvent);
    VelocityTracker localVelocityTracker = this.yjZ;
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
        this.aZk = paramMotionEvent.getRawX();
        this.aZl = paramMotionEvent.getRawY();
        this.tQN = this.tNK.getScale();
      }
      this.JoC = bool;
      AppMethodBeat.o(142291);
      return bool;
      this.yjX = paramMotionEvent.getRawX();
      this.yjY = paramMotionEvent.getRawY();
      bool = false;
      continue;
      float f = paramMotionEvent.getRawX() - this.yjX;
      ad.d("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f), Float.valueOf(paramMotionEvent.getRawY() - this.yjY), Integer.valueOf(i), Integer.valueOf(j) });
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
    this.ltA = View.MeasureSpec.getSize(paramInt1);
    this.ltB = View.MeasureSpec.getSize(paramInt2);
    this.tQL.set(0.0F, 0.0F, this.ltA, this.ltB);
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
    this.JoF = paramb;
  }
  
  public void setLongClickOverListener(c paramc)
  {
    this.Joz = paramc;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.JoA = paramOnPageChangeListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.Cjy = paramOnTouchListener;
  }
  
  public void setSingleClickOverListener(e parame)
  {
    this.Joy = parame;
  }
  
  abstract class a
  {
    protected boolean cPV = false;
    
    public a() {}
    
    public final boolean cWz()
    {
      return this.cPV;
    }
    
    public abstract void play();
  }
  
  public static abstract interface b
  {
    public abstract void O(float paramFloat1, float paramFloat2);
    
    public abstract void ah(float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface c
  {
    public abstract void aRq();
  }
  
  final class d
    extends GestureDetector.SimpleOnGestureListener
  {
    private d() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(186479);
      b localb = new b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(186479);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(142266);
      b localb = new b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
      if (MMViewPager.a(MMViewPager.this) == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(142266);
        return false;
      }
      if (MMViewPager.a(MMViewPager.this).getScale() <= MMViewPager.a(MMViewPager.this).getScaleRate()) {
        MMViewPager.a(MMViewPager.this).an(f.d(paramMotionEvent, 0), f.e(paramMotionEvent, 0));
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(142266);
        return true;
        MMViewPager.a(MMViewPager.this).am(f.d(paramMotionEvent, 0), f.e(paramMotionEvent, 0));
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
          if ((!((g)localObject1).fyw()) && (!((g)localObject1).fyx()) && ((int)f2 <= MMViewPager.b(MMViewPager.this)) && ((int)f3 <= MMViewPager.d(MMViewPager.this))) {
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
      b localb = new b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
      MMViewPager.s(MMViewPager.this);
      if (MMViewPager.p(MMViewPager.this) != null) {
        MMViewPager.p(MMViewPager.this).aRq();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(142265);
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(142263);
      if (MMViewPager.q(MMViewPager.this) != null) {
        MMViewPager.q(MMViewPager.this).aRp();
      }
      AppMethodBeat.o(142263);
      return true;
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(186478);
      b localb = new b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMViewPager$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(186478);
      return bool;
    }
  }
  
  public static abstract interface e
  {
    public abstract void aRp();
    
    public abstract void cWo();
  }
  
  final class f
    extends MMViewPager.a
  {
    float[] tQY;
    
    public f()
    {
      super();
      AppMethodBeat.i(142269);
      this.tQY = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.f.this.tQY);
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f2 = MMViewPager.a(MMViewPager.this).getImageHeight() * f1;
          float f3 = MMViewPager.f.this.tQY[5];
          f1 = MMViewPager.d(MMViewPager.this);
          if (f2 < MMViewPager.d(MMViewPager.this)) {
            f1 = MMViewPager.d(MMViewPager.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
            f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationY();
          }
          if (f1 <= 0.0F) {
            MMViewPager.f.this.cPV = true;
          }
          for (;;)
          {
            MMViewPager.a(MMViewPager.this).ao(0.0F, f1);
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              ((WxImageView)MMViewPager.a(MMViewPager.this)).translate(0.0F, f1);
            }
            AppMethodBeat.o(142268);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMViewPager.f.this.cPV = true;
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
    float[] tQY;
    
    public g()
    {
      super();
      AppMethodBeat.i(142272);
      this.tQY = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.g.this.tQY);
          float f5 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageWidth();
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f8 = MMViewPager.a(MMViewPager.this).getImageHeight() * f1;
          float f7 = MMViewPager.g.this.tQY[2];
          float f10 = MMViewPager.g.this.tQY[5];
          float f6 = MMViewPager.g.this.tQY[2];
          float f9 = MMViewPager.g.this.tQY[5];
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
                    MMViewPager.g.this.cPV = true;
                  }
                  for (;;)
                  {
                    MMViewPager.a(MMViewPager.this).ao(f2, f1);
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
    float[] tQY;
    
    public h()
    {
      super();
      AppMethodBeat.i(142275);
      this.tQY = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.h.this.tQY);
          float f2 = MMViewPager.h.this.tQY[2];
          float f1 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageWidth();
          if (f1 < MMViewPager.b(MMViewPager.this)) {}
          for (f1 = MMViewPager.b(MMViewPager.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationX();
            }
            if (f1 >= 0.0F) {
              MMViewPager.h.this.cPV = true;
            }
            for (;;)
            {
              MMViewPager.a(MMViewPager.this).ao(f1, 0.0F);
              if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
                ((WxImageView)MMViewPager.a(MMViewPager.this)).translate(f1, 0.0F);
              }
              AppMethodBeat.o(142274);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMViewPager.h.this.cPV = true;
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
    float[] tQY;
    
    public i()
    {
      super();
      AppMethodBeat.i(142278);
      this.tQY = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.i.this.tQY);
          float f1 = MMViewPager.a(MMViewPager.this).getScale();
          float f2 = MMViewPager.a(MMViewPager.this).getImageWidth() * f1;
          float f3 = MMViewPager.i.this.tQY[2];
          f1 = MMViewPager.b(MMViewPager.this);
          if (f2 < MMViewPager.b(MMViewPager.this)) {
            f1 = MMViewPager.b(MMViewPager.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
            f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationX();
          }
          if (f1 <= 0.0F) {
            MMViewPager.i.this.cPV = true;
          }
          for (;;)
          {
            MMViewPager.a(MMViewPager.this).ao(f1, 0.0F);
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              ((WxImageView)MMViewPager.a(MMViewPager.this)).translate(f1, 0.0F);
            }
            AppMethodBeat.o(142277);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MMViewPager.i.this.cPV = true;
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
    float[] tQY;
    
    public j()
    {
      super();
      AppMethodBeat.i(142281);
      this.tQY = new float[9];
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
          MMViewPager.a(MMViewPager.this).getImageMatrix().getValues(MMViewPager.j.this.tQY);
          float f2 = MMViewPager.j.this.tQY[5];
          float f1 = MMViewPager.a(MMViewPager.this).getScale() * MMViewPager.a(MMViewPager.this).getImageHeight();
          if (f1 < MMViewPager.d(MMViewPager.this)) {}
          for (f1 = MMViewPager.d(MMViewPager.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
              f1 = -((WxImageView)MMViewPager.a(MMViewPager.this)).getTranslationY();
            }
            if (f1 >= 0.0F) {
              MMViewPager.j.this.cPV = true;
            }
            for (;;)
            {
              MMViewPager.a(MMViewPager.this).ao(0.0F, f1);
              if ((MMViewPager.a(MMViewPager.this) instanceof WxImageView)) {
                ((WxImageView)MMViewPager.a(MMViewPager.this)).translate(0.0F, f1);
              }
              AppMethodBeat.o(142280);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MMViewPager.j.this.cPV = true;
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
    WeakReference<MMViewPager> tMV;
    long tRe;
    
    public k(WeakReference<MMViewPager> paramWeakReference)
    {
      this.tMV = paramWeakReference;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(142283);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.tMV != null)
      {
        MMViewPager localMMViewPager = (MMViewPager)this.tMV.get();
        if ((localMMViewPager != null) && (paramMessage.what == 1))
        {
          if ((MMViewPager.u(localMMViewPager) != null) && (!MMViewPager.u(localMMViewPager).cWz()))
          {
            MMViewPager.u(localMMViewPager).play();
            sendEmptyMessageDelayed(paramMessage.what, this.tRe);
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