package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DynamicGridView
  extends WrappingGridView
{
  private List<Long> idList;
  private int mActivePointerId;
  private int mScrollState;
  boolean pdM;
  private BitmapDrawable xUV;
  private Rect xUW;
  private Rect xUX;
  private Rect xUY;
  private int xUZ;
  private View xVA;
  d xVB;
  int xVC;
  float xVD;
  float xVE;
  private float xVF;
  private float xVG;
  private AbsListView.OnScrollListener xVH;
  private int xVa;
  private int xVb;
  private int xVc;
  private int xVd;
  private int xVe;
  private int xVf;
  private long xVg;
  private boolean xVh;
  private boolean xVi;
  private int xVj;
  private boolean xVk;
  private List<ObjectAnimator> xVl;
  boolean xVm;
  boolean xVn;
  boolean xVo;
  private boolean xVp;
  private AbsListView.OnScrollListener xVq;
  private DynamicGridView.f xVr;
  private e xVs;
  private g xVt;
  private AdapterView.OnItemClickListener xVu;
  private AdapterView.OnItemClickListener xVv;
  private boolean xVw;
  private Stack<DynamicGridView.a> xVx;
  private DynamicGridView.a xVy;
  private h xVz;
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100329);
    this.xUZ = 0;
    this.xVa = 0;
    this.xVb = -1;
    this.xVc = -1;
    this.xVd = -1;
    this.xVe = -1;
    this.idList = new ArrayList();
    this.xVg = -1L;
    this.xVh = false;
    this.mActivePointerId = -1;
    this.xVj = 0;
    this.xVk = false;
    this.mScrollState = 0;
    this.pdM = false;
    this.xVl = new LinkedList();
    this.xVo = true;
    this.xVp = true;
    this.xVv = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100305);
        if ((!DynamicGridView.this.pdM) && (DynamicGridView.this.isEnabled()) && (DynamicGridView.a(DynamicGridView.this) != null)) {
          DynamicGridView.a(DynamicGridView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(100305);
      }
    };
    this.xVB = new d((byte)0);
    this.xVC = -1;
    this.xVH = new AbsListView.OnScrollListener()
    {
      private int fra;
      private int xVJ = -1;
      private int xVK = -1;
      private int xVL;
      private int xVM;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.xVL = paramAnonymousInt1;
        this.xVM = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.xVJ == -1)
        {
          i = this.xVL;
          this.xVJ = i;
          if (this.xVK != -1) {
            break label305;
          }
          i = this.xVM;
          this.xVK = i;
          if ((this.xVL != this.xVJ) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          if ((this.xVL + this.xVM != this.xVJ + this.xVK) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          this.xVJ = this.xVL;
          this.xVK = this.xVM;
          if ((!DynamicGridView.dDI()) || (!DynamicGridView.i(DynamicGridView.this))) {
            break label369;
          }
          i = 0;
          if (i >= paramAnonymousInt2) {
            break label369;
          }
          localView = DynamicGridView.this.getChildAt(i);
          if (localView != null)
          {
            if ((DynamicGridView.h(DynamicGridView.this) == -1L) || (Boolean.TRUE == localView.getTag(2131299072))) {
              break label326;
            }
            if (i % 2 != 0) {
              break label314;
            }
            DynamicGridView.c(DynamicGridView.this, localView);
            label277:
            localView.setTag(2131299072, Boolean.TRUE);
          }
        }
        for (;;)
        {
          i += 1;
          break label212;
          i = this.xVJ;
          break;
          label305:
          i = this.xVK;
          break label49;
          label314:
          DynamicGridView.d(DynamicGridView.this, localView);
          break label277;
          label326:
          if ((DynamicGridView.h(DynamicGridView.this) == -1L) && (localView.getRotation() != 0.0F))
          {
            localView.setRotation(0.0F);
            localView.setTag(2131299072, Boolean.FALSE);
          }
        }
        label369:
        if (DynamicGridView.j(DynamicGridView.this) != null) {
          DynamicGridView.j(DynamicGridView.this).onScroll(paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(100306);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(100307);
        this.fra = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.xVM > 0) && (this.fra == 0))
        {
          if ((!DynamicGridView.k(DynamicGridView.this)) || (!DynamicGridView.l(DynamicGridView.this))) {
            break label90;
          }
          DynamicGridView.m(DynamicGridView.this);
        }
        for (;;)
        {
          if (DynamicGridView.j(DynamicGridView.this) != null) {
            DynamicGridView.j(DynamicGridView.this).onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
          }
          AppMethodBeat.o(100307);
          return;
          label90:
          if (DynamicGridView.n(DynamicGridView.this)) {
            DynamicGridView.o(DynamicGridView.this);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(100329);
  }
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(100330);
    this.xUZ = 0;
    this.xVa = 0;
    this.xVb = -1;
    this.xVc = -1;
    this.xVd = -1;
    this.xVe = -1;
    this.idList = new ArrayList();
    this.xVg = -1L;
    this.xVh = false;
    this.mActivePointerId = -1;
    this.xVj = 0;
    this.xVk = false;
    this.mScrollState = 0;
    this.pdM = false;
    this.xVl = new LinkedList();
    this.xVo = true;
    this.xVp = true;
    this.xVv = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100305);
        if ((!DynamicGridView.this.pdM) && (DynamicGridView.this.isEnabled()) && (DynamicGridView.a(DynamicGridView.this) != null)) {
          DynamicGridView.a(DynamicGridView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(100305);
      }
    };
    this.xVB = new d((byte)0);
    this.xVC = -1;
    this.xVH = new AbsListView.OnScrollListener()
    {
      private int fra;
      private int xVJ = -1;
      private int xVK = -1;
      private int xVL;
      private int xVM;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.xVL = paramAnonymousInt1;
        this.xVM = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.xVJ == -1)
        {
          i = this.xVL;
          this.xVJ = i;
          if (this.xVK != -1) {
            break label305;
          }
          i = this.xVM;
          this.xVK = i;
          if ((this.xVL != this.xVJ) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          if ((this.xVL + this.xVM != this.xVJ + this.xVK) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          this.xVJ = this.xVL;
          this.xVK = this.xVM;
          if ((!DynamicGridView.dDI()) || (!DynamicGridView.i(DynamicGridView.this))) {
            break label369;
          }
          i = 0;
          if (i >= paramAnonymousInt2) {
            break label369;
          }
          localView = DynamicGridView.this.getChildAt(i);
          if (localView != null)
          {
            if ((DynamicGridView.h(DynamicGridView.this) == -1L) || (Boolean.TRUE == localView.getTag(2131299072))) {
              break label326;
            }
            if (i % 2 != 0) {
              break label314;
            }
            DynamicGridView.c(DynamicGridView.this, localView);
            label277:
            localView.setTag(2131299072, Boolean.TRUE);
          }
        }
        for (;;)
        {
          i += 1;
          break label212;
          i = this.xVJ;
          break;
          label305:
          i = this.xVK;
          break label49;
          label314:
          DynamicGridView.d(DynamicGridView.this, localView);
          break label277;
          label326:
          if ((DynamicGridView.h(DynamicGridView.this) == -1L) && (localView.getRotation() != 0.0F))
          {
            localView.setRotation(0.0F);
            localView.setTag(2131299072, Boolean.FALSE);
          }
        }
        label369:
        if (DynamicGridView.j(DynamicGridView.this) != null) {
          DynamicGridView.j(DynamicGridView.this).onScroll(paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(100306);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(100307);
        this.fra = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.xVM > 0) && (this.fra == 0))
        {
          if ((!DynamicGridView.k(DynamicGridView.this)) || (!DynamicGridView.l(DynamicGridView.this))) {
            break label90;
          }
          DynamicGridView.m(DynamicGridView.this);
        }
        for (;;)
        {
          if (DynamicGridView.j(DynamicGridView.this) != null) {
            DynamicGridView.j(DynamicGridView.this).onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
          }
          AppMethodBeat.o(100307);
          return;
          label90:
          if (DynamicGridView.n(DynamicGridView.this)) {
            DynamicGridView.o(DynamicGridView.this);
          }
        }
      }
    };
    init(paramContext);
    AppMethodBeat.o(100330);
  }
  
  private boolean NV(int paramInt)
  {
    AppMethodBeat.i(100350);
    if (!getAdapterInterface().NP(paramInt))
    {
      AppMethodBeat.o(100350);
      return false;
    }
    this.xUZ = 0;
    this.xVa = 0;
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      this.xVg = getAdapter().getItemId(paramInt);
      this.xUV = eS(localView);
      dDD();
      if (dDE()) {
        localView.setVisibility(4);
      }
      tt(this.xVg);
      if (this.xVs != null) {
        this.xVs.NS(paramInt);
      }
      AppMethodBeat.o(100350);
      return true;
    }
    AppMethodBeat.o(100350);
    return false;
  }
  
  private long NW(int paramInt)
  {
    AppMethodBeat.i(100361);
    long l = getAdapter().getItemId(paramInt);
    AppMethodBeat.o(100361);
    return l;
  }
  
  private boolean dDA()
  {
    AppMethodBeat.i(100349);
    int i = tu(this.xVg);
    if (i != -1)
    {
      this.xVs.NT(i);
      if (this.xVA == null)
      {
        AppMethodBeat.o(100349);
        return false;
      }
    }
    else
    {
      AppMethodBeat.o(100349);
      return false;
    }
    int j;
    try
    {
      i = getPositionForView(this.xVA);
      j = getChildCount() - 1;
      new StringBuilder("switch ").append(i).append(",").append(j);
      if (i == -1)
      {
        AppMethodBeat.o(100349);
        return false;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        new StringBuilder("NullPointerException: ").append(localNullPointerException.getMessage());
        i = -1;
      }
      hw(i, j);
      if (this.xVw) {
        this.xVy.hx(i, j);
      }
      this.xVc = this.xVd;
      this.xVb = this.xVe;
      if (!dDE()) {
        break label216;
      }
    }
    Object localObject;
    if (dDF()) {
      localObject = new b(0, 0);
    }
    for (;;)
    {
      tt(this.xVg);
      ((j)localObject).hy(i, j);
      AppMethodBeat.o(100349);
      return true;
      label216:
      if (dDF()) {
        localObject = new i(0, 0);
      } else {
        localObject = new c(0, 0);
      }
    }
  }
  
  private void dDB()
  {
    AppMethodBeat.i(100351);
    this.xVi = r(this.xUW);
    AppMethodBeat.o(100351);
  }
  
  private void dDC()
  {
    AppMethodBeat.i(100354);
    this.xVB.removeMessages(1);
    View localView = tv(this.xVg);
    Rect localRect;
    if (this.xUW != null)
    {
      localRect = new Rect(this.xUW);
      localRect.offset(0, this.xUW.height() >>> 1);
    }
    for (;;)
    {
      if ((this.xVs != null) && (this.xVs.q(localRect)) && (dDA()))
      {
        this.xUV = null;
        dDG();
        if (this.xVr != null) {
          this.xVr.dDy();
        }
      }
      for (;;)
      {
        if (this.xVs != null) {
          this.xVs.dDx();
        }
        AppMethodBeat.o(100354);
        return;
        if ((localView != null) && ((this.xVh) || (this.xVk)))
        {
          this.xVh = false;
          this.xVk = false;
          this.xVi = false;
          this.mActivePointerId = -1;
          this.xUW.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          new StringBuilder("animating to  ").append(this.xUW);
          if (Build.VERSION.SDK_INT > 11)
          {
            eT(localView);
          }
          else
          {
            this.xUV.setBounds(this.xUW);
            invalidate();
            eU(localView);
          }
        }
        else
        {
          dDG();
        }
      }
      localRect = null;
    }
  }
  
  @TargetApi(11)
  private void dDD()
  {
    AppMethodBeat.i(100355);
    Object localObject = new TypeEvaluator()
    {
      private static int e(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.xUV, "bounds", (TypeEvaluator)localObject, new Object[] { this.xUW });
    ((ObjectAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(100310);
        DynamicGridView.this.invalidate();
        AppMethodBeat.o(100310);
      }
    });
    ((ObjectAnimator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100312);
        DynamicGridView.a(DynamicGridView.this, false);
        DynamicGridView.b(DynamicGridView.this);
        AppMethodBeat.o(100312);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100311);
        DynamicGridView.a(DynamicGridView.this, true);
        DynamicGridView.b(DynamicGridView.this);
        AppMethodBeat.o(100311);
      }
    });
    ((ObjectAnimator)localObject).setDuration(10L);
    ((ObjectAnimator)localObject).start();
    AppMethodBeat.o(100355);
  }
  
  static boolean dDE()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private static boolean dDF()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private void dDG()
  {
    AppMethodBeat.i(100358);
    View localView = tv(this.xVg);
    if (localView == null)
    {
      AppMethodBeat.o(100358);
      return;
    }
    if (this.xVh) {
      eU(localView);
    }
    this.xVh = false;
    this.xVi = false;
    this.mActivePointerId = -1;
    AppMethodBeat.o(100358);
  }
  
  private void dDH()
  {
    AppMethodBeat.i(100359);
    int j = this.xVd - this.xVc;
    int k = this.xVe - this.xVb;
    int m = this.xUX.centerY() + this.xUZ + j;
    int n = this.xUX.centerX() + this.xVa + k;
    this.xVA = tv(this.xVg);
    if (this.xVA == null)
    {
      AppMethodBeat.o(100359);
      return;
    }
    Object localObject = null;
    float f2 = 0.0F;
    float f1 = 0.0F;
    Point localPoint1 = eV(this.xVA);
    Iterator localIterator = this.idList.iterator();
    int i;
    if (localIterator.hasNext())
    {
      View localView = tv(((Long)localIterator.next()).longValue());
      if (localView == null) {
        break label913;
      }
      Point localPoint2 = eV(localView);
      if ((localPoint2.y < localPoint1.y) && (localPoint2.x > localPoint1.x))
      {
        i = 1;
        label187:
        label349:
        if ((i == 0) || (m >= localView.getBottom()) || (n <= localView.getLeft()))
        {
          if ((localPoint2.y >= localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
            break label636;
          }
          i = 1;
          label241:
          if ((i == 0) || (m >= localView.getBottom()) || (n >= localView.getRight()))
          {
            if ((localPoint2.y <= localPoint1.y) || (localPoint2.x <= localPoint1.x)) {
              break label642;
            }
            i = 1;
            if ((i == 0) || (m <= localView.getTop()) || (n <= localView.getLeft()))
            {
              if ((localPoint2.y <= localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
                break label648;
              }
              i = 1;
              if ((i == 0) || (m <= localView.getTop()) || (n >= localView.getRight()))
              {
                if ((localPoint2.y >= localPoint1.y) || (localPoint2.x != localPoint1.x)) {
                  break label654;
                }
                i = 1;
                if ((i == 0) || (m >= localView.getBottom() - this.xVf))
                {
                  if ((localPoint2.y <= localPoint1.y) || (localPoint2.x != localPoint1.x)) {
                    break label660;
                  }
                  i = 1;
                  if ((i == 0) || (m <= localView.getTop() + this.xVf))
                  {
                    if ((localPoint2.y != localPoint1.y) || (localPoint2.x <= localPoint1.x)) {
                      break label666;
                    }
                    i = 1;
                    label501:
                    if ((i == 0) || (n <= localView.getLeft() + this.xVf))
                    {
                      if ((localPoint2.y != localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
                        break label672;
                      }
                      i = 1;
                      if ((i == 0) || (n >= localView.getRight() - this.xVf)) {
                        break label913;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label295:
        label452:
        float f4 = Math.abs(f.eN(localView) - f.eN(this.xVA));
        label403:
        label550:
        float f3 = Math.abs(f.eO(localView) - f.eO(this.xVA));
        if ((f4 < f2) || (f3 < f1)) {
          break label913;
        }
        f2 = f4;
        localObject = localView;
        f1 = f3;
      }
    }
    label642:
    label648:
    label654:
    label913:
    for (;;)
    {
      break;
      i = 0;
      break label187;
      label636:
      i = 0;
      break label241;
      i = 0;
      break label295;
      i = 0;
      break label349;
      i = 0;
      break label403;
      label660:
      i = 0;
      break label452;
      label666:
      i = 0;
      break label501;
      label672:
      i = 0;
      break label550;
      if (localObject != null)
      {
        i = getPositionForView(this.xVA);
        m = getPositionForView((View)localObject);
        new StringBuilder("switch ").append(i).append(",").append(m);
        localObject = getAdapterInterface();
        if ((m == -1) || (!((d)localObject).NQ(i)) || (!((d)localObject).NQ(m)))
        {
          tt(this.xVg);
          AppMethodBeat.o(100359);
          return;
        }
        hw(i, m);
        if (this.xVw) {
          this.xVy.hx(i, m);
        }
        this.xVc = this.xVd;
        this.xVb = this.xVe;
        if ((!dDE()) || (!dDF())) {
          break label873;
        }
        localObject = new b(k, j);
      }
      for (;;)
      {
        tt(this.xVg);
        ((j)localObject).hy(i, m);
        AppMethodBeat.o(100359);
        return;
        label873:
        if (dDF()) {
          localObject = new i(k, j);
        } else {
          localObject = new c(k, j);
        }
      }
    }
  }
  
  @TargetApi(11)
  private void dDz()
  {
    AppMethodBeat.i(100334);
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView != null) && (Boolean.TRUE != localView.getTag(2131299072)))
      {
        if (i % 2 != 0) {
          break label67;
        }
        eP(localView);
      }
      for (;;)
      {
        localView.setTag(2131299072, Boolean.TRUE);
        i += 1;
        break;
        label67:
        eQ(localView);
      }
    }
    AppMethodBeat.o(100334);
  }
  
  @TargetApi(11)
  private void eP(View paramView)
  {
    AppMethodBeat.i(100337);
    paramView = eR(paramView);
    paramView.setFloatValues(new float[] { -2.0F, 2.0F });
    paramView.start();
    this.xVl.add(paramView);
    AppMethodBeat.o(100337);
  }
  
  @TargetApi(11)
  private void eQ(View paramView)
  {
    AppMethodBeat.i(100338);
    paramView = eR(paramView);
    paramView.setFloatValues(new float[] { 2.0F, -2.0F });
    paramView.start();
    this.xVl.add(paramView);
    AppMethodBeat.o(100338);
  }
  
  @TargetApi(11)
  private ObjectAnimator eR(final View paramView)
  {
    AppMethodBeat.i(100339);
    if (!dDF()) {
      paramView.setLayerType(1, null);
    }
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    localObjectAnimator.setDuration(180L);
    localObjectAnimator.setRepeatMode(2);
    localObjectAnimator.setRepeatCount(-1);
    localObjectAnimator.setPropertyName("rotation");
    localObjectAnimator.setTarget(paramView);
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100308);
        paramView.setLayerType(0, null);
        AppMethodBeat.o(100308);
      }
    });
    AppMethodBeat.o(100339);
    return localObjectAnimator;
  }
  
  private BitmapDrawable eS(View paramView)
  {
    AppMethodBeat.i(100343);
    int j = paramView.getWidth();
    int i = paramView.getHeight();
    int k = paramView.getTop();
    int m = paramView.getLeft();
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    paramView = new BitmapDrawable(getResources(), localBitmap);
    this.xUX = new Rect(m, k, m + j, k + i);
    k = this.xUX.left;
    m = (int)(j * 0.05F);
    int n = this.xUX.top;
    int i1 = (int)(i * 0.05F);
    int i2 = this.xUX.right;
    j = (int)(j * 0.05F);
    int i3 = this.xUX.bottom;
    this.xUW = new Rect(k - m, n - i1, j + i2, (int)(i * 0.05F) + i3);
    this.xUY = new Rect(this.xUW);
    paramView.setBounds(this.xUX);
    AppMethodBeat.o(100343);
    return paramView;
  }
  
  @TargetApi(11)
  private void eT(final View paramView)
  {
    AppMethodBeat.i(100356);
    Object localObject = new TypeEvaluator()
    {
      private static int e(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.xUV, "bounds", (TypeEvaluator)localObject, new Object[] { this.xUW });
    ((ObjectAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(100314);
        DynamicGridView.this.invalidate();
        AppMethodBeat.o(100314);
      }
    });
    ((ObjectAnimator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100316);
        DynamicGridView.a(DynamicGridView.this, false);
        DynamicGridView.b(DynamicGridView.this);
        if ((DynamicGridView.c(DynamicGridView.this) != null) && (DynamicGridView.d(DynamicGridView.this) != null)) {
          DynamicGridView.d(DynamicGridView.this).dDy();
        }
        DynamicGridView.a(DynamicGridView.this, paramView);
        AppMethodBeat.o(100316);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(100315);
        DynamicGridView.a(DynamicGridView.this, true);
        DynamicGridView.b(DynamicGridView.this);
        AppMethodBeat.o(100315);
      }
    });
    ((ObjectAnimator)localObject).setDuration(200L);
    ((ObjectAnimator)localObject).start();
    AppMethodBeat.o(100356);
  }
  
  private void eU(View paramView)
  {
    AppMethodBeat.i(100357);
    this.idList.clear();
    this.xVg = -1L;
    paramView.setVisibility(0);
    this.xUV = null;
    if ((dDE()) && (this.xVo))
    {
      if (!this.pdM) {
        break label98;
      }
      qx(false);
      dDz();
    }
    for (;;)
    {
      int i = 0;
      while (i < getLastVisiblePosition() - getFirstVisiblePosition())
      {
        paramView = getChildAt(i);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        i += 1;
      }
      label98:
      qx(true);
    }
    invalidate();
    AppMethodBeat.o(100357);
  }
  
  private Point eV(View paramView)
  {
    AppMethodBeat.i(100360);
    int i = getPositionForView(paramView);
    int j = getColumnCount();
    paramView = new Point(i % j, i / j);
    AppMethodBeat.o(100360);
    return paramView;
  }
  
  @TargetApi(11)
  private static AnimatorSet f(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(100362);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, 0.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat2, 0.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    AppMethodBeat.o(100362);
    return localAnimatorSet;
  }
  
  private d getAdapterInterface()
  {
    AppMethodBeat.i(100342);
    d locald = (d)getAdapter();
    AppMethodBeat.o(100342);
    return locald;
  }
  
  private int getColumnCount()
  {
    AppMethodBeat.i(100341);
    int i = getAdapterInterface().getColumnCount();
    AppMethodBeat.o(100341);
    return i;
  }
  
  private void hw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100340);
    getAdapterInterface().hv(paramInt1, paramInt2);
    AppMethodBeat.o(100340);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(100336);
    super.setOnScrollListener(this.xVH);
    this.xVj = ((int)(paramContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
    this.xVf = getResources().getDimensionPixelSize(2131166136);
    AppMethodBeat.o(100336);
  }
  
  private boolean r(Rect paramRect)
  {
    AppMethodBeat.i(100352);
    int i = computeVerticalScrollOffset();
    int j = getHeight();
    int k = computeVerticalScrollExtent();
    int m = computeVerticalScrollRange();
    int n = paramRect.top;
    int i1 = paramRect.height();
    if ((n <= 0) && (i > 0))
    {
      smoothScrollBy(-this.xVj, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    if ((n + i1 >= j) && (i + k < m))
    {
      smoothScrollBy(this.xVj, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    AppMethodBeat.o(100352);
    return false;
  }
  
  private void tt(long paramLong)
  {
    AppMethodBeat.i(100344);
    this.idList.clear();
    int j = tu(paramLong);
    int i = getFirstVisiblePosition();
    while (i <= getLastVisiblePosition())
    {
      if ((j != i) && (getAdapterInterface().NQ(i))) {
        this.idList.add(Long.valueOf(NW(i)));
      }
      i += 1;
    }
    AppMethodBeat.o(100344);
  }
  
  public final void NU(int paramInt)
  {
    AppMethodBeat.i(100331);
    if (!this.xVp)
    {
      AppMethodBeat.o(100331);
      return;
    }
    requestDisallowInterceptTouchEvent(true);
    if ((dDE()) && (this.xVo)) {
      dDz();
    }
    if (paramInt != -1)
    {
      this.pdM = NV(paramInt);
      if (this.pdM) {
        this.xVh = true;
      }
    }
    AppMethodBeat.o(100331);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100363);
    super.dispatchDraw(paramCanvas);
    if (this.xUV != null) {
      this.xUV.draw(paramCanvas);
    }
    AppMethodBeat.o(100363);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(100347);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    new StringBuilder("onInterceptTouchEvent ").append(paramMotionEvent.getAction()).append(" ").append(bool);
    AppMethodBeat.o(100347);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(100348);
    int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
    new StringBuilder("onTouchEvent ").append(paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(100348);
      return bool;
      this.xVD = paramMotionEvent.getX();
      this.xVE = paramMotionEvent.getY();
      this.xVC = f.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      new StringBuilder("onTouchEvent ").append(paramMotionEvent.getAction()).append(",downPos ").append(this.xVC);
      Object localObject;
      if ((!this.xVm) && (this.xVC >= 0))
      {
        localObject = this.xVB;
        ((d)localObject).removeMessages(1);
        ((d)localObject).sendEmptyMessageDelayed(1, 300L);
      }
      this.xVd = -1;
      this.xVe = -1;
      this.xVb = ((int)paramMotionEvent.getX());
      this.xVc = ((int)paramMotionEvent.getY());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if ((this.pdM) && (isEnabled()))
      {
        layoutChildren();
        NV(pointToPosition(this.xVb, this.xVc));
      }
      else if (!isEnabled())
      {
        AppMethodBeat.o(100348);
        return false;
        this.xVD = paramMotionEvent.getX();
        this.xVE = paramMotionEvent.getY();
        if ((this.xVh) && (this.mActivePointerId != -1) && (i != -1)) {
          if ((this.xVe == -1) && (this.xVd == -1))
          {
            this.xVd = ((int)paramMotionEvent.getY(i));
            this.xVe = ((int)paramMotionEvent.getX(i));
            this.xVb = this.xVe;
            this.xVc = this.xVd;
          }
          else
          {
            this.xVF = paramMotionEvent.getRawX();
            this.xVG = paramMotionEvent.getRawY();
            this.xVd = ((int)paramMotionEvent.getY(i));
            this.xVe = ((int)paramMotionEvent.getX(i));
            i = this.xVd;
            int j = this.xVc;
            int k = this.xVe;
            int m = this.xVb;
            this.xUW.offsetTo(k - m + this.xUY.left + this.xVa, i - j + this.xUY.top + this.xUZ);
            if (this.xUV != null) {
              this.xUV.setBounds(this.xUW);
            }
            invalidate();
            dDH();
            this.xVi = false;
            dDB();
            if (this.xVs != null)
            {
              paramMotionEvent = new Rect(this.xUW);
              paramMotionEvent.offset(0, this.xUW.height() >>> 1);
              this.xVs.p(paramMotionEvent);
            }
            AppMethodBeat.o(100348);
            return false;
            dDC();
            if ((this.xVw) && (this.xVy != null))
            {
              localObject = this.xVy;
              Collections.reverse(((DynamicGridView.a)localObject).xVO);
              if (!((DynamicGridView.a)localObject).xVO.isEmpty())
              {
                this.xVx.push(this.xVy);
                this.xVy = new DynamicGridView.a();
                continue;
                dDG();
                dDC();
                continue;
                if (paramMotionEvent.getPointerId((paramMotionEvent.getAction() & 0xFF00) >> 8) == this.mActivePointerId) {
                  dDC();
                }
              }
            }
          }
        }
      }
    }
  }
  
  @TargetApi(11)
  final void qx(boolean paramBoolean)
  {
    AppMethodBeat.i(100335);
    Object localObject = this.xVl.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Animator)((Iterator)localObject).next()).cancel();
    }
    this.xVl.clear();
    int i = 0;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      if (localObject != null)
      {
        if (paramBoolean) {
          ((View)localObject).setRotation(0.0F);
        }
        ((View)localObject).setTag(2131299072, Boolean.FALSE);
      }
      i += 1;
    }
    AppMethodBeat.o(100335);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(100353);
    super.setAdapter(paramListAdapter);
    AppMethodBeat.o(100353);
  }
  
  public void setEditModeEnabled(boolean paramBoolean)
  {
    this.xVp = paramBoolean;
  }
  
  public void setOnDragListener(e parame)
  {
    this.xVs = parame;
  }
  
  public void setOnDropListener(DynamicGridView.f paramf)
  {
    this.xVr = paramf;
  }
  
  public void setOnEditModeChangeListener(g paramg)
  {
    this.xVt = paramg;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(100332);
    this.xVu = paramOnItemClickListener;
    super.setOnItemClickListener(this.xVv);
    AppMethodBeat.o(100332);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.xVq = paramOnScrollListener;
  }
  
  public void setOnSelectedItemBitmapCreationListener(h paramh)
  {
    this.xVz = paramh;
  }
  
  public void setUndoSupportEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(100333);
    if (this.xVw != paramBoolean) {
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (this.xVx = new Stack();; this.xVx = null)
    {
      this.xVw = paramBoolean;
      AppMethodBeat.o(100333);
      return;
    }
  }
  
  public void setWobbleInEditMode(boolean paramBoolean)
  {
    this.xVo = paramBoolean;
  }
  
  public final int tu(long paramLong)
  {
    AppMethodBeat.i(100345);
    View localView = tv(paramLong);
    if (localView == null)
    {
      AppMethodBeat.o(100345);
      return -1;
    }
    int i = getPositionForView(localView);
    AppMethodBeat.o(100345);
    return i;
  }
  
  public final View tv(long paramLong)
  {
    AppMethodBeat.i(100346);
    int j = getFirstVisiblePosition();
    ListAdapter localListAdapter = getAdapter();
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localListAdapter.getItemId(j + i) == paramLong)
      {
        AppMethodBeat.o(100346);
        return localView;
      }
      i += 1;
    }
    AppMethodBeat.o(100346);
    return null;
  }
  
  final class b
    implements DynamicGridView.j
  {
    private int yl;
    private int ym;
    
    static
    {
      AppMethodBeat.i(100323);
      if (!DynamicGridView.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(100323);
        return;
      }
    }
    
    public b(int paramInt1, int paramInt2)
    {
      this.yl = paramInt1;
      this.ym = paramInt2;
    }
    
    public final void hy(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100322);
      if ((!$assertionsDisabled) && (DynamicGridView.g(DynamicGridView.this) == null))
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(100322);
        throw localAssertionError;
      }
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(DynamicGridView.g(DynamicGridView.this), paramInt1, paramInt2));
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.tv(DynamicGridView.h(DynamicGridView.this)));
      AppMethodBeat.o(100322);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final int ard;
      private final View xVP;
      private final int xVQ;
      
      a(View paramView, int paramInt1, int paramInt2)
      {
        this.xVP = paramView;
        this.xVQ = paramInt1;
        this.ard = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100321);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + DynamicGridView.b.a(DynamicGridView.b.this));
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + DynamicGridView.b.b(DynamicGridView.b.this));
        DynamicGridView.a(DynamicGridView.this, this.xVQ, this.ard);
        this.xVP.setVisibility(0);
        if (DynamicGridView.g(DynamicGridView.this) != null) {
          DynamicGridView.g(DynamicGridView.this).setVisibility(4);
        }
        AppMethodBeat.o(100321);
        return true;
      }
    }
  }
  
  final class c
    implements DynamicGridView.j
  {
    int yl;
    int ym;
    
    public c(int paramInt1, int paramInt2)
    {
      this.yl = paramInt1;
      this.ym = paramInt2;
    }
    
    public final void hy(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100326);
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(paramInt1, paramInt2));
      AppMethodBeat.o(100326);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final int ard;
      private final int xVQ;
      
      static
      {
        AppMethodBeat.i(100325);
        if (!DynamicGridView.class.desiredAssertionStatus()) {}
        for (boolean bool = true;; bool = false)
        {
          $assertionsDisabled = bool;
          AppMethodBeat.o(100325);
          return;
        }
      }
      
      a(int paramInt1, int paramInt2)
      {
        this.xVQ = paramInt1;
        this.ard = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100324);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + DynamicGridView.c.this.ym);
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + DynamicGridView.c.this.yl);
        DynamicGridView.a(DynamicGridView.this, this.xVQ, this.ard);
        new StringBuilder("id ").append(DynamicGridView.this.tu(DynamicGridView.h(DynamicGridView.this)));
        if (DynamicGridView.g(DynamicGridView.this) == null)
        {
          AppMethodBeat.o(100324);
          return true;
        }
        if (DynamicGridView.g(DynamicGridView.this) == null)
        {
          AppMethodBeat.o(100324);
          return true;
        }
        AssertionError localAssertionError;
        if ((!$assertionsDisabled) && (DynamicGridView.g(DynamicGridView.this) == null))
        {
          localAssertionError = new AssertionError();
          AppMethodBeat.o(100324);
          throw localAssertionError;
        }
        DynamicGridView.g(DynamicGridView.this).setVisibility(0);
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.tv(DynamicGridView.h(DynamicGridView.this)));
        if (DynamicGridView.g(DynamicGridView.this) == null)
        {
          AppMethodBeat.o(100324);
          return true;
        }
        if ((!$assertionsDisabled) && (DynamicGridView.g(DynamicGridView.this) == null))
        {
          localAssertionError = new AssertionError();
          AppMethodBeat.o(100324);
          throw localAssertionError;
        }
        DynamicGridView.g(DynamicGridView.this).setVisibility(4);
        AppMethodBeat.o(100324);
        return true;
      }
    }
  }
  
  final class d
    extends Handler
  {
    private d() {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(100327);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(100327);
        return;
        paramMessage = DynamicGridView.this;
        View localView = paramMessage.getChildAt(paramMessage.xVC);
        new StringBuilder("downView ").append(localView).append(",downPos ").append(paramMessage.xVC).append(",lastTouchX ").append(paramMessage.xVD).append(",lastTouchY ").append(paramMessage.xVE);
        if ((!paramMessage.xVm) && (!paramMessage.xVn) && (f.e(localView, paramMessage.xVD, paramMessage.xVE))) {
          paramMessage.NU(paramMessage.xVC);
        }
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void NS(int paramInt);
    
    public abstract void NT(int paramInt);
    
    public abstract void dDx();
    
    public abstract void p(Rect paramRect);
    
    public abstract boolean q(Rect paramRect);
  }
  
  public static abstract interface g {}
  
  public static abstract interface h {}
  
  final class i
    implements DynamicGridView.j
  {
    private int yl;
    private int ym;
    
    public i(int paramInt1, int paramInt2)
    {
      this.yl = paramInt1;
      this.ym = paramInt2;
    }
    
    public final void hy(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100328);
      DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + this.ym);
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + this.yl);
      AppMethodBeat.o(100328);
    }
  }
  
  static abstract interface j
  {
    public abstract void hy(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView
 * JD-Core Version:    0.7.0.1
 */