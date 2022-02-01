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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DynamicGridView
  extends WrappingGridView
{
  float Grh;
  float Gri;
  private int Kxq;
  private int Kxr;
  private int LqA;
  private int LqB;
  private long LqC;
  private boolean LqD;
  private boolean LqE;
  private int LqF;
  private boolean LqG;
  private List<ObjectAnimator> LqH;
  boolean LqI;
  boolean LqJ;
  boolean LqK;
  private boolean LqL;
  private AbsListView.OnScrollListener LqM;
  private f LqN;
  private e LqO;
  private g LqP;
  private AdapterView.OnItemClickListener LqQ;
  private AdapterView.OnItemClickListener LqR;
  private boolean LqS;
  private Stack<DynamicGridView.a> LqT;
  private DynamicGridView.a LqU;
  private h LqV;
  private View LqW;
  d LqX;
  int LqY;
  private float LqZ;
  private BitmapDrawable Lqt;
  private Rect Lqu;
  private Rect Lqv;
  private Rect Lqw;
  private int Lqx;
  private int Lqy;
  private int Lqz;
  private float Lra;
  private AbsListView.OnScrollListener Lrb;
  private List<Long> idList;
  private int mActivePointerId;
  private int mScrollState;
  boolean vok;
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(100329);
    this.Lqx = 0;
    this.Lqy = 0;
    this.Kxq = -1;
    this.Kxr = -1;
    this.Lqz = -1;
    this.LqA = -1;
    this.idList = new ArrayList();
    this.LqC = -1L;
    this.LqD = false;
    this.mActivePointerId = -1;
    this.LqF = 0;
    this.LqG = false;
    this.mScrollState = 0;
    this.vok = false;
    this.LqH = new LinkedList();
    this.LqK = true;
    this.LqL = true;
    this.LqR = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100305);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if ((!DynamicGridView.this.vok) && (DynamicGridView.this.isEnabled()) && (DynamicGridView.a(DynamicGridView.this) != null)) {
          DynamicGridView.a(DynamicGridView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(100305);
      }
    };
    this.LqX = new d((byte)0);
    this.LqY = -1;
    this.Lrb = new AbsListView.OnScrollListener()
    {
      private int Lrd = -1;
      private int Lre = -1;
      private int Lrf;
      private int Lrg;
      private int iZf;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.Lrf = paramAnonymousInt1;
        this.Lrg = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.Lrd == -1)
        {
          i = this.Lrf;
          this.Lrd = i;
          if (this.Lre != -1) {
            break label307;
          }
          i = this.Lrg;
          this.Lre = i;
          if ((this.Lrf != this.Lrd) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          if ((this.Lrf + this.Lrg != this.Lrd + this.Lre) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          this.Lrd = this.Lrf;
          this.Lre = this.Lrg;
          if ((!DynamicGridView.fYU()) || (!DynamicGridView.i(DynamicGridView.this))) {
            break label372;
          }
          i = 0;
          if (i >= paramAnonymousInt2) {
            break label372;
          }
          localView = DynamicGridView.this.getChildAt(i);
          if (localView != null)
          {
            if ((DynamicGridView.h(DynamicGridView.this) == -1L) || (Boolean.TRUE == localView.getTag(i.f.dgv_wobble_tag))) {
              break label328;
            }
            if (i % 2 != 0) {
              break label316;
            }
            DynamicGridView.c(DynamicGridView.this, localView);
            label278:
            localView.setTag(i.f.dgv_wobble_tag, Boolean.TRUE);
          }
        }
        for (;;)
        {
          i += 1;
          break label212;
          i = this.Lrd;
          break;
          label307:
          i = this.Lre;
          break label49;
          label316:
          DynamicGridView.d(DynamicGridView.this, localView);
          break label278;
          label328:
          if ((DynamicGridView.h(DynamicGridView.this) == -1L) && (localView.getRotation() != 0.0F))
          {
            localView.setRotation(0.0F);
            localView.setTag(i.f.dgv_wobble_tag, Boolean.FALSE);
          }
        }
        label372:
        if (DynamicGridView.j(DynamicGridView.this) != null) {
          DynamicGridView.j(DynamicGridView.this).onScroll(paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(100306);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(100307);
        this.iZf = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.Lrg > 0) && (this.iZf == 0))
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
    this.Lqx = 0;
    this.Lqy = 0;
    this.Kxq = -1;
    this.Kxr = -1;
    this.Lqz = -1;
    this.LqA = -1;
    this.idList = new ArrayList();
    this.LqC = -1L;
    this.LqD = false;
    this.mActivePointerId = -1;
    this.LqF = 0;
    this.LqG = false;
    this.mScrollState = 0;
    this.vok = false;
    this.LqH = new LinkedList();
    this.LqK = true;
    this.LqL = true;
    this.LqR = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100305);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        if ((!DynamicGridView.this.vok) && (DynamicGridView.this.isEnabled()) && (DynamicGridView.a(DynamicGridView.this) != null)) {
          DynamicGridView.a(DynamicGridView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridView$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(100305);
      }
    };
    this.LqX = new d((byte)0);
    this.LqY = -1;
    this.Lrb = new AbsListView.OnScrollListener()
    {
      private int Lrd = -1;
      private int Lre = -1;
      private int Lrf;
      private int Lrg;
      private int iZf;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(100306);
        this.Lrf = paramAnonymousInt1;
        this.Lrg = paramAnonymousInt2;
        int i;
        label49:
        label212:
        View localView;
        if (this.Lrd == -1)
        {
          i = this.Lrf;
          this.Lrd = i;
          if (this.Lre != -1) {
            break label307;
          }
          i = this.Lrg;
          this.Lre = i;
          if ((this.Lrf != this.Lrd) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          if ((this.Lrf + this.Lrg != this.Lrd + this.Lre) && (DynamicGridView.k(DynamicGridView.this)) && (DynamicGridView.h(DynamicGridView.this) != -1L))
          {
            DynamicGridView.a(DynamicGridView.this, DynamicGridView.h(DynamicGridView.this));
            DynamicGridView.p(DynamicGridView.this);
          }
          this.Lrd = this.Lrf;
          this.Lre = this.Lrg;
          if ((!DynamicGridView.fYU()) || (!DynamicGridView.i(DynamicGridView.this))) {
            break label372;
          }
          i = 0;
          if (i >= paramAnonymousInt2) {
            break label372;
          }
          localView = DynamicGridView.this.getChildAt(i);
          if (localView != null)
          {
            if ((DynamicGridView.h(DynamicGridView.this) == -1L) || (Boolean.TRUE == localView.getTag(i.f.dgv_wobble_tag))) {
              break label328;
            }
            if (i % 2 != 0) {
              break label316;
            }
            DynamicGridView.c(DynamicGridView.this, localView);
            label278:
            localView.setTag(i.f.dgv_wobble_tag, Boolean.TRUE);
          }
        }
        for (;;)
        {
          i += 1;
          break label212;
          i = this.Lrd;
          break;
          label307:
          i = this.Lre;
          break label49;
          label316:
          DynamicGridView.d(DynamicGridView.this, localView);
          break label278;
          label328:
          if ((DynamicGridView.h(DynamicGridView.this) == -1L) && (localView.getRotation() != 0.0F))
          {
            localView.setRotation(0.0F);
            localView.setTag(i.f.dgv_wobble_tag, Boolean.FALSE);
          }
        }
        label372:
        if (DynamicGridView.j(DynamicGridView.this) != null) {
          DynamicGridView.j(DynamicGridView.this).onScroll(paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(100306);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(100307);
        this.iZf = paramAnonymousInt;
        DynamicGridView.c(DynamicGridView.this, paramAnonymousInt);
        if ((this.Lrg > 0) && (this.iZf == 0))
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
  
  private void Rr(long paramLong)
  {
    AppMethodBeat.i(100344);
    this.idList.clear();
    int j = Rs(paramLong);
    int i = getFirstVisiblePosition();
    while (i <= getLastVisiblePosition())
    {
      if ((j != i) && (getAdapterInterface().ahB(i))) {
        this.idList.add(Long.valueOf(ahG(i)));
      }
      i += 1;
    }
    AppMethodBeat.o(100344);
  }
  
  private boolean ahF(int paramInt)
  {
    AppMethodBeat.i(100350);
    if (!getAdapterInterface().ahA(paramInt))
    {
      AppMethodBeat.o(100350);
      return false;
    }
    this.Lqx = 0;
    this.Lqy = 0;
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      this.LqC = getAdapter().getItemId(paramInt);
      this.Lqt = gQ(localView);
      fYP();
      if (fYQ()) {
        localView.setVisibility(4);
      }
      Rr(this.LqC);
      if (this.LqO != null) {
        this.LqO.ZM(paramInt);
      }
      AppMethodBeat.o(100350);
      return true;
    }
    AppMethodBeat.o(100350);
    return false;
  }
  
  private long ahG(int paramInt)
  {
    AppMethodBeat.i(100361);
    long l = getAdapter().getItemId(paramInt);
    AppMethodBeat.o(100361);
    return l;
  }
  
  @TargetApi(11)
  private void fYL()
  {
    AppMethodBeat.i(100334);
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView != null) && (Boolean.TRUE != localView.getTag(i.f.dgv_wobble_tag)))
      {
        if (i % 2 != 0) {
          break label67;
        }
        gN(localView);
      }
      for (;;)
      {
        localView.setTag(i.f.dgv_wobble_tag, Boolean.TRUE);
        i += 1;
        break;
        label67:
        gO(localView);
      }
    }
    AppMethodBeat.o(100334);
  }
  
  private boolean fYM()
  {
    AppMethodBeat.i(100349);
    int i = Rs(this.LqC);
    if (i != -1)
    {
      this.LqO.ahD(i);
      if (this.LqW == null)
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
      i = getPositionForView(this.LqW);
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
      kd(i, j);
      if (this.LqS) {
        this.LqU.ke(i, j);
      }
      this.Kxr = this.Lqz;
      this.Kxq = this.LqA;
      if (!fYQ()) {
        break label216;
      }
    }
    Object localObject;
    if (fYR()) {
      localObject = new b(0, 0);
    }
    for (;;)
    {
      Rr(this.LqC);
      ((j)localObject).kf(i, j);
      AppMethodBeat.o(100349);
      return true;
      label216:
      if (fYR()) {
        localObject = new i(0, 0);
      } else {
        localObject = new c(0, 0);
      }
    }
  }
  
  private void fYN()
  {
    AppMethodBeat.i(100351);
    this.LqE = w(this.Lqu);
    AppMethodBeat.o(100351);
  }
  
  private void fYO()
  {
    AppMethodBeat.i(100354);
    this.LqX.removeMessages(1);
    View localView = Rt(this.LqC);
    Rect localRect;
    if (this.Lqu != null)
    {
      localRect = new Rect(this.Lqu);
      localRect.offset(0, this.Lqu.height() >>> 1);
    }
    for (;;)
    {
      if ((this.LqO != null) && (this.LqO.v(localRect)) && (fYM()))
      {
        this.Lqt = null;
        fYS();
        if (this.LqN != null) {
          this.LqN.fYK();
        }
      }
      for (;;)
      {
        if (this.LqO != null) {
          this.LqO.fYJ();
        }
        AppMethodBeat.o(100354);
        return;
        if ((localView != null) && ((this.LqD) || (this.LqG)))
        {
          this.LqD = false;
          this.LqG = false;
          this.LqE = false;
          this.mActivePointerId = -1;
          this.Lqu.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          new StringBuilder("animating to  ").append(this.Lqu);
          if (Build.VERSION.SDK_INT > 11)
          {
            gR(localView);
          }
          else
          {
            this.Lqt.setBounds(this.Lqu);
            invalidate();
            gS(localView);
          }
        }
        else
        {
          fYS();
        }
      }
      localRect = null;
    }
  }
  
  @TargetApi(11)
  private void fYP()
  {
    AppMethodBeat.i(100355);
    Object localObject = new TypeEvaluator()
    {
      private static int g(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.Lqt, "bounds", (TypeEvaluator)localObject, new Object[] { this.Lqu });
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
  
  static boolean fYQ()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private static boolean fYR()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private void fYS()
  {
    AppMethodBeat.i(100358);
    View localView = Rt(this.LqC);
    if (localView == null)
    {
      AppMethodBeat.o(100358);
      return;
    }
    if (this.LqD) {
      gS(localView);
    }
    this.LqD = false;
    this.LqE = false;
    this.mActivePointerId = -1;
    AppMethodBeat.o(100358);
  }
  
  private void fYT()
  {
    AppMethodBeat.i(100359);
    int j = this.Lqz - this.Kxr;
    int k = this.LqA - this.Kxq;
    int m = this.Lqv.centerY() + this.Lqx + j;
    int n = this.Lqv.centerX() + this.Lqy + k;
    this.LqW = Rt(this.LqC);
    if (this.LqW == null)
    {
      AppMethodBeat.o(100359);
      return;
    }
    Object localObject = null;
    float f2 = 0.0F;
    float f1 = 0.0F;
    Point localPoint1 = gT(this.LqW);
    Iterator localIterator = this.idList.iterator();
    int i;
    if (localIterator.hasNext())
    {
      View localView = Rt(((Long)localIterator.next()).longValue());
      if (localView == null) {
        break label913;
      }
      Point localPoint2 = gT(localView);
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
                if ((i == 0) || (m >= localView.getBottom() - this.LqB))
                {
                  if ((localPoint2.y <= localPoint1.y) || (localPoint2.x != localPoint1.x)) {
                    break label660;
                  }
                  i = 1;
                  if ((i == 0) || (m <= localView.getTop() + this.LqB))
                  {
                    if ((localPoint2.y != localPoint1.y) || (localPoint2.x <= localPoint1.x)) {
                      break label666;
                    }
                    i = 1;
                    label501:
                    if ((i == 0) || (n <= localView.getLeft() + this.LqB))
                    {
                      if ((localPoint2.y != localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
                        break label672;
                      }
                      i = 1;
                      if ((i == 0) || (n >= localView.getRight() - this.LqB)) {
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
        float f4 = Math.abs(f.gL(localView) - f.gL(this.LqW));
        label403:
        label550:
        float f3 = Math.abs(f.gM(localView) - f.gM(this.LqW));
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
        i = getPositionForView(this.LqW);
        m = getPositionForView((View)localObject);
        new StringBuilder("switch ").append(i).append(",").append(m);
        localObject = getAdapterInterface();
        if ((m == -1) || (!((d)localObject).ahB(i)) || (!((d)localObject).ahB(m)))
        {
          Rr(this.LqC);
          AppMethodBeat.o(100359);
          return;
        }
        kd(i, m);
        if (this.LqS) {
          this.LqU.ke(i, m);
        }
        this.Kxr = this.Lqz;
        this.Kxq = this.LqA;
        if ((!fYQ()) || (!fYR())) {
          break label873;
        }
        localObject = new b(k, j);
      }
      for (;;)
      {
        Rr(this.LqC);
        ((j)localObject).kf(i, m);
        AppMethodBeat.o(100359);
        return;
        label873:
        if (fYR()) {
          localObject = new i(k, j);
        } else {
          localObject = new c(k, j);
        }
      }
    }
  }
  
  @TargetApi(11)
  private void gN(View paramView)
  {
    AppMethodBeat.i(100337);
    paramView = gP(paramView);
    paramView.setFloatValues(new float[] { -2.0F, 2.0F });
    paramView.start();
    this.LqH.add(paramView);
    AppMethodBeat.o(100337);
  }
  
  @TargetApi(11)
  private void gO(View paramView)
  {
    AppMethodBeat.i(100338);
    paramView = gP(paramView);
    paramView.setFloatValues(new float[] { 2.0F, -2.0F });
    paramView.start();
    this.LqH.add(paramView);
    AppMethodBeat.o(100338);
  }
  
  @TargetApi(11)
  private ObjectAnimator gP(final View paramView)
  {
    AppMethodBeat.i(100339);
    if (!fYR()) {
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
  
  private BitmapDrawable gQ(View paramView)
  {
    AppMethodBeat.i(100343);
    int j = paramView.getWidth();
    int i = paramView.getHeight();
    int k = paramView.getTop();
    int m = paramView.getLeft();
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    paramView = new BitmapDrawable(getResources(), localBitmap);
    this.Lqv = new Rect(m, k, m + j, k + i);
    k = this.Lqv.left;
    m = (int)(j * 0.05F);
    int n = this.Lqv.top;
    int i1 = (int)(i * 0.05F);
    int i2 = this.Lqv.right;
    j = (int)(j * 0.05F);
    int i3 = this.Lqv.bottom;
    this.Lqu = new Rect(k - m, n - i1, j + i2, (int)(i * 0.05F) + i3);
    this.Lqw = new Rect(this.Lqu);
    paramView.setBounds(this.Lqv);
    AppMethodBeat.o(100343);
    return paramView;
  }
  
  @TargetApi(11)
  private void gR(final View paramView)
  {
    AppMethodBeat.i(100356);
    Object localObject = new TypeEvaluator()
    {
      private static int g(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.Lqt, "bounds", (TypeEvaluator)localObject, new Object[] { this.Lqu });
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
          DynamicGridView.d(DynamicGridView.this).fYK();
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
  
  private void gS(View paramView)
  {
    AppMethodBeat.i(100357);
    this.idList.clear();
    this.LqC = -1L;
    paramView.setVisibility(0);
    this.Lqt = null;
    if ((fYQ()) && (this.LqK))
    {
      if (!this.vok) {
        break label98;
      }
      zi(false);
      fYL();
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
      zi(true);
    }
    invalidate();
    AppMethodBeat.o(100357);
  }
  
  private Point gT(View paramView)
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
  
  @TargetApi(11)
  private static AnimatorSet i(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(100362);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, 0.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat2, 0.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    AppMethodBeat.o(100362);
    return localAnimatorSet;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(100336);
    super.setOnScrollListener(this.Lrb);
    this.LqF = ((int)(paramContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
    this.LqB = getResources().getDimensionPixelSize(i.d.dgv_overlap_if_switch_straight_line);
    AppMethodBeat.o(100336);
  }
  
  private void kd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100340);
    getAdapterInterface().kc(paramInt1, paramInt2);
    AppMethodBeat.o(100340);
  }
  
  private boolean w(Rect paramRect)
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
      smoothScrollBy(-this.LqF, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    if ((n + i1 >= j) && (i + k < m))
    {
      smoothScrollBy(this.LqF, 0);
      AppMethodBeat.o(100352);
      return true;
    }
    AppMethodBeat.o(100352);
    return false;
  }
  
  public final int Rs(long paramLong)
  {
    AppMethodBeat.i(100345);
    View localView = Rt(paramLong);
    if (localView == null)
    {
      AppMethodBeat.o(100345);
      return -1;
    }
    int i = getPositionForView(localView);
    AppMethodBeat.o(100345);
    return i;
  }
  
  public final View Rt(long paramLong)
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
  
  public final void ahE(int paramInt)
  {
    AppMethodBeat.i(100331);
    if (!this.LqL)
    {
      AppMethodBeat.o(100331);
      return;
    }
    requestDisallowInterceptTouchEvent(true);
    if ((fYQ()) && (this.LqK)) {
      fYL();
    }
    if (paramInt != -1)
    {
      this.vok = ahF(paramInt);
      if (this.vok) {
        this.LqD = true;
      }
    }
    AppMethodBeat.o(100331);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(100363);
    super.dispatchDraw(paramCanvas);
    if (this.Lqt != null) {
      this.Lqt.draw(paramCanvas);
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
      this.Grh = paramMotionEvent.getX();
      this.Gri = paramMotionEvent.getY();
      this.LqY = f.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      new StringBuilder("onTouchEvent ").append(paramMotionEvent.getAction()).append(",downPos ").append(this.LqY);
      Object localObject;
      if ((!this.LqI) && (this.LqY >= 0))
      {
        localObject = this.LqX;
        ((d)localObject).removeMessages(1);
        ((d)localObject).sendEmptyMessageDelayed(1, 300L);
      }
      this.Lqz = -1;
      this.LqA = -1;
      this.Kxq = ((int)paramMotionEvent.getX());
      this.Kxr = ((int)paramMotionEvent.getY());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if ((this.vok) && (isEnabled()))
      {
        layoutChildren();
        ahF(pointToPosition(this.Kxq, this.Kxr));
      }
      else if (!isEnabled())
      {
        AppMethodBeat.o(100348);
        return false;
        this.Grh = paramMotionEvent.getX();
        this.Gri = paramMotionEvent.getY();
        if ((this.LqD) && (this.mActivePointerId != -1) && (i != -1)) {
          if ((this.LqA == -1) && (this.Lqz == -1))
          {
            this.Lqz = ((int)paramMotionEvent.getY(i));
            this.LqA = ((int)paramMotionEvent.getX(i));
            this.Kxq = this.LqA;
            this.Kxr = this.Lqz;
          }
          else
          {
            this.LqZ = paramMotionEvent.getRawX();
            this.Lra = paramMotionEvent.getRawY();
            this.Lqz = ((int)paramMotionEvent.getY(i));
            this.LqA = ((int)paramMotionEvent.getX(i));
            i = this.Lqz;
            int j = this.Kxr;
            int k = this.LqA;
            int m = this.Kxq;
            this.Lqu.offsetTo(k - m + this.Lqw.left + this.Lqy, i - j + this.Lqw.top + this.Lqx);
            if (this.Lqt != null) {
              this.Lqt.setBounds(this.Lqu);
            }
            invalidate();
            fYT();
            this.LqE = false;
            fYN();
            if (this.LqO != null)
            {
              paramMotionEvent = new Rect(this.Lqu);
              paramMotionEvent.offset(0, this.Lqu.height() >>> 1);
              this.LqO.u(paramMotionEvent);
            }
            AppMethodBeat.o(100348);
            return false;
            fYO();
            if ((this.LqS) && (this.LqU != null))
            {
              localObject = this.LqU;
              Collections.reverse(((DynamicGridView.a)localObject).Lri);
              if (!((DynamicGridView.a)localObject).Lri.isEmpty())
              {
                this.LqT.push(this.LqU);
                this.LqU = new DynamicGridView.a();
                continue;
                fYS();
                fYO();
                continue;
                if (paramMotionEvent.getPointerId((paramMotionEvent.getAction() & 0xFF00) >> 8) == this.mActivePointerId) {
                  fYO();
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(100353);
    super.setAdapter(paramListAdapter);
    AppMethodBeat.o(100353);
  }
  
  public void setEditModeEnabled(boolean paramBoolean)
  {
    this.LqL = paramBoolean;
  }
  
  public void setOnDragListener(e parame)
  {
    this.LqO = parame;
  }
  
  public void setOnDropListener(f paramf)
  {
    this.LqN = paramf;
  }
  
  public void setOnEditModeChangeListener(g paramg)
  {
    this.LqP = paramg;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(100332);
    this.LqQ = paramOnItemClickListener;
    super.setOnItemClickListener(this.LqR);
    AppMethodBeat.o(100332);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.LqM = paramOnScrollListener;
  }
  
  public void setOnSelectedItemBitmapCreationListener(h paramh)
  {
    this.LqV = paramh;
  }
  
  public void setUndoSupportEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(100333);
    if (this.LqS != paramBoolean) {
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (this.LqT = new Stack();; this.LqT = null)
    {
      this.LqS = paramBoolean;
      AppMethodBeat.o(100333);
      return;
    }
  }
  
  public void setWobbleInEditMode(boolean paramBoolean)
  {
    this.LqK = paramBoolean;
  }
  
  @TargetApi(11)
  final void zi(boolean paramBoolean)
  {
    AppMethodBeat.i(100335);
    Object localObject = this.LqH.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Animator)((Iterator)localObject).next()).cancel();
    }
    this.LqH.clear();
    int i = 0;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      if (localObject != null)
      {
        if (paramBoolean) {
          ((View)localObject).setRotation(0.0F);
        }
        ((View)localObject).setTag(i.f.dgv_wobble_tag, Boolean.FALSE);
      }
      i += 1;
    }
    AppMethodBeat.o(100335);
  }
  
  final class b
    implements DynamicGridView.j
  {
    private int PR;
    private int PS;
    
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
      this.PR = paramInt1;
      this.PS = paramInt2;
    }
    
    public final void kf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100322);
      if ((!$assertionsDisabled) && (DynamicGridView.g(DynamicGridView.this) == null))
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(100322);
        throw localAssertionError;
      }
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(DynamicGridView.g(DynamicGridView.this), paramInt1, paramInt2));
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.Rt(DynamicGridView.h(DynamicGridView.this)));
      AppMethodBeat.o(100322);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final View Lrj;
      private final int Lrk;
      private final int alG;
      
      a(View paramView, int paramInt1, int paramInt2)
      {
        this.Lrj = paramView;
        this.Lrk = paramInt1;
        this.alG = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100321);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + DynamicGridView.b.a(DynamicGridView.b.this));
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + DynamicGridView.b.b(DynamicGridView.b.this));
        DynamicGridView.a(DynamicGridView.this, this.Lrk, this.alG);
        this.Lrj.setVisibility(0);
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
    int PR;
    int PS;
    
    public c(int paramInt1, int paramInt2)
    {
      this.PR = paramInt1;
      this.PS = paramInt2;
    }
    
    public final void kf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100326);
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(paramInt1, paramInt2));
      AppMethodBeat.o(100326);
    }
    
    final class a
      implements ViewTreeObserver.OnPreDrawListener
    {
      private final int Lrk;
      private final int alG;
      
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
        this.Lrk = paramInt1;
        this.alG = paramInt2;
      }
      
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(100324);
        DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
        DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + DynamicGridView.c.this.PS);
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + DynamicGridView.c.this.PR);
        DynamicGridView.a(DynamicGridView.this, this.Lrk, this.alG);
        new StringBuilder("id ").append(DynamicGridView.this.Rs(DynamicGridView.h(DynamicGridView.this)));
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
        DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.Rt(DynamicGridView.h(DynamicGridView.this)));
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
        View localView = paramMessage.getChildAt(paramMessage.LqY);
        new StringBuilder("downView ").append(localView).append(",downPos ").append(paramMessage.LqY).append(",lastTouchX ").append(paramMessage.Grh).append(",lastTouchY ").append(paramMessage.Gri);
        if ((!paramMessage.LqI) && (!paramMessage.LqJ) && (f.h(localView, paramMessage.Grh, paramMessage.Gri))) {
          paramMessage.ahE(paramMessage.LqY);
        }
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void ZM(int paramInt);
    
    public abstract void ahD(int paramInt);
    
    public abstract void fYJ();
    
    public abstract void u(Rect paramRect);
    
    public abstract boolean v(Rect paramRect);
  }
  
  public static abstract interface f
  {
    public abstract void fYK();
  }
  
  public static abstract interface g {}
  
  public static abstract interface h {}
  
  final class i
    implements DynamicGridView.j
  {
    private int PR;
    private int PS;
    
    public i(int paramInt1, int paramInt2)
    {
      this.PR = paramInt1;
      this.PS = paramInt2;
    }
    
    public final void kf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(100328);
      DynamicGridView.a(DynamicGridView.this, DynamicGridView.e(DynamicGridView.this) + this.PS);
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.f(DynamicGridView.this) + this.PR);
      AppMethodBeat.o(100328);
    }
  }
  
  static abstract interface j
  {
    public abstract void kf(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView
 * JD-Core Version:    0.7.0.1
 */