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
  private float AAA;
  private float AAB;
  private AbsListView.OnScrollListener AAD;
  private int AAa;
  private long AAb;
  private boolean AAc;
  private boolean AAd;
  private int AAe;
  private boolean AAf;
  private List<ObjectAnimator> AAg;
  boolean AAh;
  boolean AAi;
  boolean AAj;
  private boolean AAk;
  private AbsListView.OnScrollListener AAl;
  private f AAm;
  private e AAn;
  private g AAo;
  private AdapterView.OnItemClickListener AAp;
  private AdapterView.OnItemClickListener AAq;
  private boolean AAr;
  private Stack<DynamicGridView.a> AAs;
  private DynamicGridView.a AAt;
  private h AAu;
  private View AAv;
  d AAw;
  int AAx;
  float AAy;
  float AAz;
  private BitmapDrawable AzS;
  private Rect AzT;
  private Rect AzU;
  private Rect AzV;
  private int AzW;
  private int AzX;
  private int AzY;
  private int AzZ;
  private List<Long> idList;
  private int mActivePointerId;
  private int mScrollState;
  boolean qkC;
  private int zKK;
  private int zKL;
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100329);
    this.AzW = 0;
    this.AzX = 0;
    this.zKK = -1;
    this.zKL = -1;
    this.AzY = -1;
    this.AzZ = -1;
    this.idList = new ArrayList();
    this.AAb = -1L;
    this.AAc = false;
    this.mActivePointerId = -1;
    this.AAe = 0;
    this.AAf = false;
    this.mScrollState = 0;
    this.qkC = false;
    this.AAg = new LinkedList();
    this.AAj = true;
    this.AAk = true;
    this.AAq = new DynamicGridView.1(this);
    this.AAw = new d((byte)0);
    this.AAx = -1;
    this.AAD = new AbsListView.OnScrollListener()
    {
      private int AAF = -1;
      private int AAG = -1;
      private int AAH;
      private int AAI;
      private int fND;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.AAH = paramAnonymousInt1;
        this.AAI = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.AAF == -1)
        {
          i = this.AAH;
          this.AAF = i;
          if (this.AAG != -1) {
            break label305;
          }
          i = this.AAI;
          this.AAG = i;
          if ((this.AAH != this.AAF) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          if ((this.AAH + this.AAI != this.AAF + this.AAG) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          this.AAF = this.AAH;
          this.AAG = this.AAI;
          if ((!DynamicGridView.eeA()) || (!DynamicGridView.i(DynamicGridView.this))) {
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
          i = this.AAF;
          break;
          label305:
          i = this.AAG;
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
        this.fND = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.AAI > 0) && (this.fND == 0))
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
    this.AzW = 0;
    this.AzX = 0;
    this.zKK = -1;
    this.zKL = -1;
    this.AzY = -1;
    this.AzZ = -1;
    this.idList = new ArrayList();
    this.AAb = -1L;
    this.AAc = false;
    this.mActivePointerId = -1;
    this.AAe = 0;
    this.AAf = false;
    this.mScrollState = 0;
    this.qkC = false;
    this.AAg = new LinkedList();
    this.AAj = true;
    this.AAk = true;
    this.AAq = new DynamicGridView.1(this);
    this.AAw = new d((byte)0);
    this.AAx = -1;
    this.AAD = new AbsListView.OnScrollListener()
    {
      private int AAF = -1;
      private int AAG = -1;
      private int AAH;
      private int AAI;
      private int fND;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.AAH = paramAnonymousInt1;
        this.AAI = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.AAF == -1)
        {
          i = this.AAH;
          this.AAF = i;
          if (this.AAG != -1) {
            break label305;
          }
          i = this.AAI;
          this.AAG = i;
          if ((this.AAH != this.AAF) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          if ((this.AAH + this.AAI != this.AAF + this.AAG) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          this.AAF = this.AAH;
          this.AAG = this.AAI;
          if ((!DynamicGridView.eeA()) || (!DynamicGridView.i(DynamicGridView.this))) {
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
          i = this.AAF;
          break;
          label305:
          i = this.AAG;
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
        this.fND = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.AAI > 0) && (this.fND == 0))
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
  
  private void Au(long paramLong)
  {
    AppMethodBeat.i(100344);
    this.idList.clear();
    int j = Av(paramLong);
    int i = getFirstVisiblePosition();
    while (i <= getLastVisiblePosition())
    {
      if ((j != i) && (getAdapterInterface().RD(i))) {
        this.idList.add(Long.valueOf(RJ(i)));
      }
      i += 1;
    }
    AppMethodBeat.o(100344);
  }
  
  private boolean RI(int paramInt)
  {
    AppMethodBeat.i(100350);
    if (!getAdapterInterface().RC(paramInt))
    {
      AppMethodBeat.o(100350);
      return false;
    }
    this.AzW = 0;
    this.AzX = 0;
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      this.AAb = getAdapter().getItemId(paramInt);
      this.AzS = fu(localView);
      eev();
      if (eew()) {
        localView.setVisibility(4);
      }
      Au(this.AAb);
      if (this.AAn != null) {
        this.AAn.RF(paramInt);
      }
      AppMethodBeat.o(100350);
      return true;
    }
    AppMethodBeat.o(100350);
    return false;
  }
  
  private long RJ(int paramInt)
  {
    AppMethodBeat.i(100361);
    long l = getAdapter().getItemId(paramInt);
    AppMethodBeat.o(100361);
    return l;
  }
  
  @TargetApi(11)
  private void eer()
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
        fr(localView);
      }
      for (;;)
      {
        localView.setTag(2131299072, Boolean.TRUE);
        i += 1;
        break;
        label67:
        fs(localView);
      }
    }
    AppMethodBeat.o(100334);
  }
  
  private boolean ees()
  {
    AppMethodBeat.i(100349);
    int i = Av(this.AAb);
    if (i != -1)
    {
      this.AAn.RG(i);
      if (this.AAv == null)
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
      i = getPositionForView(this.AAv);
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
      hW(i, j);
      if (this.AAr) {
        this.AAt.hX(i, j);
      }
      this.zKL = this.AzY;
      this.zKK = this.AzZ;
      if (!eew()) {
        break label216;
      }
    }
    Object localObject;
    if (eex()) {
      localObject = new b(0, 0);
    }
    for (;;)
    {
      Au(this.AAb);
      ((j)localObject).hY(i, j);
      AppMethodBeat.o(100349);
      return true;
      label216:
      if (eex()) {
        localObject = new i(0, 0);
      } else {
        localObject = new c(0, 0);
      }
    }
  }
  
  private void eet()
  {
    AppMethodBeat.i(100351);
    this.AAd = n(this.AzT);
    AppMethodBeat.o(100351);
  }
  
  private void eeu()
  {
    AppMethodBeat.i(100354);
    this.AAw.removeMessages(1);
    View localView = Aw(this.AAb);
    Rect localRect;
    if (this.AzT != null)
    {
      localRect = new Rect(this.AzT);
      localRect.offset(0, this.AzT.height() >>> 1);
    }
    for (;;)
    {
      if ((this.AAn != null) && (this.AAn.m(localRect)) && (ees()))
      {
        this.AzS = null;
        eey();
        if (this.AAm != null) {
          this.AAm.eeq();
        }
      }
      for (;;)
      {
        if (this.AAn != null) {
          this.AAn.eep();
        }
        AppMethodBeat.o(100354);
        return;
        if ((localView != null) && ((this.AAc) || (this.AAf)))
        {
          this.AAc = false;
          this.AAf = false;
          this.AAd = false;
          this.mActivePointerId = -1;
          this.AzT.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          new StringBuilder("animating to  ").append(this.AzT);
          if (Build.VERSION.SDK_INT > 11)
          {
            fv(localView);
          }
          else
          {
            this.AzS.setBounds(this.AzT);
            invalidate();
            ei(localView);
          }
        }
        else
        {
          eey();
        }
      }
      localRect = null;
    }
  }
  
  @TargetApi(11)
  private void eev()
  {
    AppMethodBeat.i(100355);
    Object localObject = new TypeEvaluator()
    {
      private static int e(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.AzS, "bounds", (TypeEvaluator)localObject, new Object[] { this.AzT });
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
  
  static boolean eew()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private static boolean eex()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private void eey()
  {
    AppMethodBeat.i(100358);
    View localView = Aw(this.AAb);
    if (localView == null)
    {
      AppMethodBeat.o(100358);
      return;
    }
    if (this.AAc) {
      ei(localView);
    }
    this.AAc = false;
    this.AAd = false;
    this.mActivePointerId = -1;
    AppMethodBeat.o(100358);
  }
  
  private void eez()
  {
    AppMethodBeat.i(100359);
    int j = this.AzY - this.zKL;
    int k = this.AzZ - this.zKK;
    int m = this.AzU.centerY() + this.AzW + j;
    int n = this.AzU.centerX() + this.AzX + k;
    this.AAv = Aw(this.AAb);
    if (this.AAv == null)
    {
      AppMethodBeat.o(100359);
      return;
    }
    Object localObject = null;
    float f2 = 0.0F;
    float f1 = 0.0F;
    Point localPoint1 = fw(this.AAv);
    Iterator localIterator = this.idList.iterator();
    int i;
    if (localIterator.hasNext())
    {
      View localView = Aw(((Long)localIterator.next()).longValue());
      if (localView == null) {
        break label913;
      }
      Point localPoint2 = fw(localView);
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
                if ((i == 0) || (m >= localView.getBottom() - this.AAa))
                {
                  if ((localPoint2.y <= localPoint1.y) || (localPoint2.x != localPoint1.x)) {
                    break label660;
                  }
                  i = 1;
                  if ((i == 0) || (m <= localView.getTop() + this.AAa))
                  {
                    if ((localPoint2.y != localPoint1.y) || (localPoint2.x <= localPoint1.x)) {
                      break label666;
                    }
                    i = 1;
                    label501:
                    if ((i == 0) || (n <= localView.getLeft() + this.AAa))
                    {
                      if ((localPoint2.y != localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
                        break label672;
                      }
                      i = 1;
                      if ((i == 0) || (n >= localView.getRight() - this.AAa)) {
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
        float f4 = Math.abs(f.fp(localView) - f.fp(this.AAv));
        label403:
        label550:
        float f3 = Math.abs(f.fq(localView) - f.fq(this.AAv));
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
        i = getPositionForView(this.AAv);
        m = getPositionForView((View)localObject);
        new StringBuilder("switch ").append(i).append(",").append(m);
        localObject = getAdapterInterface();
        if ((m == -1) || (!((d)localObject).RD(i)) || (!((d)localObject).RD(m)))
        {
          Au(this.AAb);
          AppMethodBeat.o(100359);
          return;
        }
        hW(i, m);
        if (this.AAr) {
          this.AAt.hX(i, m);
        }
        this.zKL = this.AzY;
        this.zKK = this.AzZ;
        if ((!eew()) || (!eex())) {
          break label873;
        }
        localObject = new b(k, j);
      }
      for (;;)
      {
        Au(this.AAb);
        ((j)localObject).hY(i, m);
        AppMethodBeat.o(100359);
        return;
        label873:
        if (eex()) {
          localObject = new i(k, j);
        } else {
          localObject = new c(k, j);
        }
      }
    }
  }
  
  private void ei(View paramView)
  {
    AppMethodBeat.i(100357);
    this.idList.clear();
    this.AAb = -1L;
    paramView.setVisibility(0);
    this.AzS = null;
    if ((eew()) && (this.AAj))
    {
      if (!this.qkC) {
        break label98;
      }
      sb(false);
      eer();
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
      sb(true);
    }
    invalidate();
    AppMethodBeat.o(100357);
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
  
  @TargetApi(11)
  private void fr(View paramView)
  {
    AppMethodBeat.i(100337);
    paramView = ft(paramView);
    paramView.setFloatValues(new float[] { -2.0F, 2.0F });
    paramView.start();
    this.AAg.add(paramView);
    AppMethodBeat.o(100337);
  }
  
  @TargetApi(11)
  private void fs(View paramView)
  {
    AppMethodBeat.i(100338);
    paramView = ft(paramView);
    paramView.setFloatValues(new float[] { 2.0F, -2.0F });
    paramView.start();
    this.AAg.add(paramView);
    AppMethodBeat.o(100338);
  }
  
  @TargetApi(11)
  private ObjectAnimator ft(View paramView)
  {
    AppMethodBeat.i(100339);
    if (!eex()) {
      paramView.setLayerType(1, null);
    }
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    localObjectAnimator.setDuration(180L);
    localObjectAnimator.setRepeatMode(2);
    localObjectAnimator.setRepeatCount(-1);
    localObjectAnimator.setPropertyName("rotation");
    localObjectAnimator.setTarget(paramView);
    localObjectAnimator.addListener(new DynamicGridView.3(this, paramView));
    AppMethodBeat.o(100339);
    return localObjectAnimator;
  }
  
  private BitmapDrawable fu(View paramView)
  {
    AppMethodBeat.i(100343);
    int j = paramView.getWidth();
    int i = paramView.getHeight();
    int k = paramView.getTop();
    int m = paramView.getLeft();
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    paramView = new BitmapDrawable(getResources(), localBitmap);
    this.AzU = new Rect(m, k, m + j, k + i);
    k = this.AzU.left;
    m = (int)(j * 0.05F);
    int n = this.AzU.top;
    int i1 = (int)(i * 0.05F);
    int i2 = this.AzU.right;
    j = (int)(j * 0.05F);
    int i3 = this.AzU.bottom;
    this.AzT = new Rect(k - m, n - i1, j + i2, (int)(i * 0.05F) + i3);
    this.AzV = new Rect(this.AzT);
    paramView.setBounds(this.AzU);
    AppMethodBeat.o(100343);
    return paramView;
  }
  
  @TargetApi(11)
  private void fv(final View paramView)
  {
    AppMethodBeat.i(100356);
    Object localObject = new TypeEvaluator()
    {
      private static int e(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.AzS, "bounds", (TypeEvaluator)localObject, new Object[] { this.AzT });
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
          DynamicGridView.d(DynamicGridView.this).eeq();
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
  
  private Point fw(View paramView)
  {
    AppMethodBeat.i(100360);
    int i = getPositionForView(paramView);
    int j = getColumnCount();
    paramView = new Point(i % j, i / j);
    AppMethodBeat.o(100360);
    return paramView;
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
  
  private void hW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100340);
    getAdapterInterface().hV(paramInt1, paramInt2);
    AppMethodBeat.o(100340);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(100336);
    super.setOnScrollListener(this.AAD);
    this.AAe = ((int)(paramContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
    this.AAa = getResources().getDimensionPixelSize(2131166136);
    AppMethodBeat.o(100336);
  }
  
  private boolean n(Rect paramRect)
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
      smoothScrollBy(-this.AAe, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    if ((n + i1 >= j) && (i + k < m))
    {
      smoothScrollBy(this.AAe, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    AppMethodBeat.o(100352);
    return false;
  }
  
  public final int Av(long paramLong)
  {
    AppMethodBeat.i(100345);
    View localView = Aw(paramLong);
    if (localView == null)
    {
      AppMethodBeat.o(100345);
      return -1;
    }
    int i = getPositionForView(localView);
    AppMethodBeat.o(100345);
    return i;
  }
  
  public final View Aw(long paramLong)
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
  
  public final void RH(int paramInt)
  {
    AppMethodBeat.i(100331);
    if (!this.AAk)
    {
      AppMethodBeat.o(100331);
      return;
    }
    requestDisallowInterceptTouchEvent(true);
    if ((eew()) && (this.AAj)) {
      eer();
    }
    if (paramInt != -1)
    {
      this.qkC = RI(paramInt);
      if (this.qkC) {
        this.AAc = true;
      }
    }
    AppMethodBeat.o(100331);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100363);
    super.dispatchDraw(paramCanvas);
    if (this.AzS != null) {
      this.AzS.draw(paramCanvas);
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
      this.AAy = paramMotionEvent.getX();
      this.AAz = paramMotionEvent.getY();
      this.AAx = f.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      new StringBuilder("onTouchEvent ").append(paramMotionEvent.getAction()).append(",downPos ").append(this.AAx);
      Object localObject;
      if ((!this.AAh) && (this.AAx >= 0))
      {
        localObject = this.AAw;
        ((d)localObject).removeMessages(1);
        ((d)localObject).sendEmptyMessageDelayed(1, 300L);
      }
      this.AzY = -1;
      this.AzZ = -1;
      this.zKK = ((int)paramMotionEvent.getX());
      this.zKL = ((int)paramMotionEvent.getY());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if ((this.qkC) && (isEnabled()))
      {
        layoutChildren();
        RI(pointToPosition(this.zKK, this.zKL));
      }
      else if (!isEnabled())
      {
        AppMethodBeat.o(100348);
        return false;
        this.AAy = paramMotionEvent.getX();
        this.AAz = paramMotionEvent.getY();
        if ((this.AAc) && (this.mActivePointerId != -1) && (i != -1)) {
          if ((this.AzZ == -1) && (this.AzY == -1))
          {
            this.AzY = ((int)paramMotionEvent.getY(i));
            this.AzZ = ((int)paramMotionEvent.getX(i));
            this.zKK = this.AzZ;
            this.zKL = this.AzY;
          }
          else
          {
            this.AAA = paramMotionEvent.getRawX();
            this.AAB = paramMotionEvent.getRawY();
            this.AzY = ((int)paramMotionEvent.getY(i));
            this.AzZ = ((int)paramMotionEvent.getX(i));
            i = this.AzY;
            int j = this.zKL;
            int k = this.AzZ;
            int m = this.zKK;
            this.AzT.offsetTo(k - m + this.AzV.left + this.AzX, i - j + this.AzV.top + this.AzW);
            if (this.AzS != null) {
              this.AzS.setBounds(this.AzT);
            }
            invalidate();
            eez();
            this.AAd = false;
            eet();
            if (this.AAn != null)
            {
              paramMotionEvent = new Rect(this.AzT);
              paramMotionEvent.offset(0, this.AzT.height() >>> 1);
              this.AAn.l(paramMotionEvent);
            }
            AppMethodBeat.o(100348);
            return false;
            eeu();
            if ((this.AAr) && (this.AAt != null))
            {
              localObject = this.AAt;
              Collections.reverse(((DynamicGridView.a)localObject).AAK);
              if (!((DynamicGridView.a)localObject).AAK.isEmpty())
              {
                this.AAs.push(this.AAt);
                this.AAt = new DynamicGridView.a();
                continue;
                eey();
                eeu();
                continue;
                if (paramMotionEvent.getPointerId((paramMotionEvent.getAction() & 0xFF00) >> 8) == this.mActivePointerId) {
                  eeu();
                }
              }
            }
          }
        }
      }
    }
  }
  
  @TargetApi(11)
  final void sb(boolean paramBoolean)
  {
    AppMethodBeat.i(100335);
    Object localObject = this.AAg.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Animator)((Iterator)localObject).next()).cancel();
    }
    this.AAg.clear();
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
    this.AAk = paramBoolean;
  }
  
  public void setOnDragListener(e parame)
  {
    this.AAn = parame;
  }
  
  public void setOnDropListener(f paramf)
  {
    this.AAm = paramf;
  }
  
  public void setOnEditModeChangeListener(g paramg)
  {
    this.AAo = paramg;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(100332);
    this.AAp = paramOnItemClickListener;
    super.setOnItemClickListener(this.AAq);
    AppMethodBeat.o(100332);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.AAl = paramOnScrollListener;
  }
  
  public void setOnSelectedItemBitmapCreationListener(h paramh)
  {
    this.AAu = paramh;
  }
  
  public void setUndoSupportEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(100333);
    if (this.AAr != paramBoolean) {
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (this.AAs = new Stack();; this.AAs = null)
    {
      this.AAr = paramBoolean;
      AppMethodBeat.o(100333);
      return;
    }
  }
  
  public void setWobbleInEditMode(boolean paramBoolean)
  {
    this.AAj = paramBoolean;
  }
  
  final class b
    implements DynamicGridView.j
  {
    private int Bc;
    private int Bd;
    
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
      this.Bc = paramInt1;
      this.Bd = paramInt2;
    }
    
    public final void hY(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100322);
      if ((!$assertionsDisabled) && (DynamicGridView.g(DynamicGridView.this) == null))
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(100322);
        throw localAssertionError;
      }
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(DynamicGridView.g(DynamicGridView.this), paramInt1, paramInt2));
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.Aw(DynamicGridView.h(DynamicGridView.this)));
      AppMethodBeat.o(100322);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final View AAL;
      private final int AAM;
      private final int atQ;
      
      a(View paramView, int paramInt1, int paramInt2)
      {
        this.AAL = paramView;
        this.AAM = paramInt1;
        this.atQ = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100321);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + DynamicGridView.b.a(DynamicGridView.b.this));
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + DynamicGridView.b.b(DynamicGridView.b.this));
        DynamicGridView.a(DynamicGridView.this, this.AAM, this.atQ);
        this.AAL.setVisibility(0);
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
    int Bc;
    int Bd;
    
    public c(int paramInt1, int paramInt2)
    {
      this.Bc = paramInt1;
      this.Bd = paramInt2;
    }
    
    public final void hY(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100326);
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(paramInt1, paramInt2));
      AppMethodBeat.o(100326);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final int AAM;
      private final int atQ;
      
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
        this.AAM = paramInt1;
        this.atQ = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100324);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + DynamicGridView.c.this.Bd);
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + DynamicGridView.c.this.Bc);
        DynamicGridView.a(DynamicGridView.this, this.AAM, this.atQ);
        new StringBuilder("id ").append(DynamicGridView.this.Av(DynamicGridView.h(DynamicGridView.this)));
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
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.Aw(DynamicGridView.h(DynamicGridView.this)));
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
        View localView = paramMessage.getChildAt(paramMessage.AAx);
        new StringBuilder("downView ").append(localView).append(",downPos ").append(paramMessage.AAx).append(",lastTouchX ").append(paramMessage.AAy).append(",lastTouchY ").append(paramMessage.AAz);
        if ((!paramMessage.AAh) && (!paramMessage.AAi) && (f.e(localView, paramMessage.AAy, paramMessage.AAz))) {
          paramMessage.RH(paramMessage.AAx);
        }
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void RF(int paramInt);
    
    public abstract void RG(int paramInt);
    
    public abstract void eep();
    
    public abstract void l(Rect paramRect);
    
    public abstract boolean m(Rect paramRect);
  }
  
  public static abstract interface f
  {
    public abstract void eeq();
  }
  
  public static abstract interface g {}
  
  public static abstract interface h {}
  
  final class i
    implements DynamicGridView.j
  {
    private int Bc;
    private int Bd;
    
    public i(int paramInt1, int paramInt2)
    {
      this.Bc = paramInt1;
      this.Bd = paramInt2;
    }
    
    public final void hY(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100328);
      DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + this.Bd);
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + this.Bc);
      AppMethodBeat.o(100328);
    }
  }
  
  static abstract interface j
  {
    public abstract void hY(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView
 * JD-Core Version:    0.7.0.1
 */