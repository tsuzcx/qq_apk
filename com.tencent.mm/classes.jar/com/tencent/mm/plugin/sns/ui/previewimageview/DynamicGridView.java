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
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
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
  private List<Long> idList;
  boolean lNb;
  private int mActivePointerId;
  private int mScrollState;
  private BitmapDrawable skQ;
  private Rect skR;
  private Rect skS;
  private Rect skT;
  private int skU;
  private int skV;
  private int skW;
  private int skX;
  private int skY;
  private int skZ;
  private float slA;
  private float slB;
  private AbsListView.OnScrollListener slC;
  private int sla;
  private long slb;
  private boolean slc;
  private boolean sld;
  private int sle;
  private boolean slf;
  private List<ObjectAnimator> slg;
  boolean slh;
  boolean sli;
  boolean slj;
  private boolean slk;
  private AbsListView.OnScrollListener sll;
  private DynamicGridView.f slm;
  private DynamicGridView.e sln;
  private DynamicGridView.g slo;
  private AdapterView.OnItemClickListener slp;
  private AdapterView.OnItemClickListener slq;
  private boolean slr;
  private Stack<a> sls;
  private a slt;
  private h slu;
  private View slv;
  DynamicGridView.d slw;
  int slx;
  float sly;
  float slz;
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40367);
    this.skU = 0;
    this.skV = 0;
    this.skW = -1;
    this.skX = -1;
    this.skY = -1;
    this.skZ = -1;
    this.idList = new ArrayList();
    this.slb = -1L;
    this.slc = false;
    this.mActivePointerId = -1;
    this.sle = 0;
    this.slf = false;
    this.mScrollState = 0;
    this.lNb = false;
    this.slg = new LinkedList();
    this.slj = true;
    this.slk = true;
    this.slq = new DynamicGridView.1(this);
    this.slw = new DynamicGridView.d(this, (byte)0);
    this.slx = -1;
    this.slC = new DynamicGridView.2(this);
    init(paramContext);
    AppMethodBeat.o(40367);
  }
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40368);
    this.skU = 0;
    this.skV = 0;
    this.skW = -1;
    this.skX = -1;
    this.skY = -1;
    this.skZ = -1;
    this.idList = new ArrayList();
    this.slb = -1L;
    this.slc = false;
    this.mActivePointerId = -1;
    this.sle = 0;
    this.slf = false;
    this.mScrollState = 0;
    this.lNb = false;
    this.slg = new LinkedList();
    this.slj = true;
    this.slk = true;
    this.slq = new DynamicGridView.1(this);
    this.slw = new DynamicGridView.d(this, (byte)0);
    this.slx = -1;
    this.slC = new DynamicGridView.2(this);
    init(paramContext);
    AppMethodBeat.o(40368);
  }
  
  private boolean Fq(int paramInt)
  {
    AppMethodBeat.i(40388);
    if (!getAdapterInterface().Fk(paramInt))
    {
      AppMethodBeat.o(40388);
      return false;
    }
    this.skU = 0;
    this.skV = 0;
    View localView = getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null)
    {
      this.slb = getAdapter().getItemId(paramInt);
      this.skQ = ea(localView);
      cxi();
      if (cxj()) {
        localView.setVisibility(4);
      }
      mj(this.slb);
      if (this.sln != null) {
        this.sln.Fn(paramInt);
      }
      AppMethodBeat.o(40388);
      return true;
    }
    AppMethodBeat.o(40388);
    return false;
  }
  
  private long Fr(int paramInt)
  {
    AppMethodBeat.i(40399);
    long l = getAdapter().getItemId(paramInt);
    AppMethodBeat.o(40399);
    return l;
  }
  
  @TargetApi(11)
  private void cxe()
  {
    AppMethodBeat.i(40372);
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView != null) && (Boolean.TRUE != localView.getTag(2131820591)))
      {
        if (i % 2 != 0) {
          break label67;
        }
        dX(localView);
      }
      for (;;)
      {
        localView.setTag(2131820591, Boolean.TRUE);
        i += 1;
        break;
        label67:
        dY(localView);
      }
    }
    AppMethodBeat.o(40372);
  }
  
  private boolean cxf()
  {
    AppMethodBeat.i(40387);
    int i = mk(this.slb);
    if (i != -1)
    {
      this.sln.Fo(i);
      if (this.slv == null)
      {
        AppMethodBeat.o(40387);
        return false;
      }
    }
    else
    {
      AppMethodBeat.o(40387);
      return false;
    }
    i = getPositionForView(this.slv);
    int j = getChildCount() - 1;
    new StringBuilder("switch ").append(i).append(",").append(j);
    if (i == -1)
    {
      AppMethodBeat.o(40387);
      return false;
    }
    fP(i, j);
    if (this.slr) {
      this.slt.fQ(i, j);
    }
    this.skX = this.skY;
    this.skW = this.skZ;
    Object localObject;
    if ((cxj()) && (cxk())) {
      localObject = new b(0, 0);
    }
    for (;;)
    {
      mj(this.slb);
      ((DynamicGridView.j)localObject).fR(i, j);
      AppMethodBeat.o(40387);
      return true;
      if (cxk()) {
        localObject = new DynamicGridView.i(this, 0, 0);
      } else {
        localObject = new c(0, 0);
      }
    }
  }
  
  private void cxg()
  {
    AppMethodBeat.i(40389);
    this.sld = o(this.skR);
    AppMethodBeat.o(40389);
  }
  
  private void cxh()
  {
    AppMethodBeat.i(40392);
    this.slw.removeMessages(1);
    View localView = ml(this.slb);
    Rect localRect;
    if (this.skR != null)
    {
      localRect = new Rect(this.skR);
      localRect.offset(0, this.skR.height() >>> 1);
    }
    for (;;)
    {
      if ((this.sln != null) && (this.sln.n(localRect)) && (cxf()))
      {
        this.skQ = null;
        cxl();
        if (this.slm != null) {
          this.slm.cxd();
        }
      }
      for (;;)
      {
        if (this.sln != null) {
          this.sln.cxc();
        }
        AppMethodBeat.o(40392);
        return;
        if ((localView != null) && ((this.slc) || (this.slf)))
        {
          this.slc = false;
          this.slf = false;
          this.sld = false;
          this.mActivePointerId = -1;
          this.skR.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          new StringBuilder("animating to  ").append(this.skR);
          if (Build.VERSION.SDK_INT > 11)
          {
            eb(localView);
          }
          else
          {
            this.skQ.setBounds(this.skR);
            invalidate();
            ec(localView);
          }
        }
        else
        {
          cxl();
        }
      }
      localRect = null;
    }
  }
  
  @TargetApi(11)
  private void cxi()
  {
    AppMethodBeat.i(40393);
    Object localObject = new DynamicGridView.4(this);
    localObject = ObjectAnimator.ofObject(this.skQ, "bounds", (TypeEvaluator)localObject, new Object[] { this.skR });
    ((ObjectAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(40348);
        DynamicGridView.this.invalidate();
        AppMethodBeat.o(40348);
      }
    });
    ((ObjectAnimator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(40350);
        DynamicGridView.a(DynamicGridView.this, false);
        DynamicGridView.b(DynamicGridView.this);
        AppMethodBeat.o(40350);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(40349);
        DynamicGridView.a(DynamicGridView.this, true);
        DynamicGridView.b(DynamicGridView.this);
        AppMethodBeat.o(40349);
      }
    });
    ((ObjectAnimator)localObject).setDuration(10L);
    ((ObjectAnimator)localObject).start();
    AppMethodBeat.o(40393);
  }
  
  static boolean cxj()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private static boolean cxk()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private void cxl()
  {
    AppMethodBeat.i(40396);
    View localView = ml(this.slb);
    if (localView == null)
    {
      AppMethodBeat.o(40396);
      return;
    }
    if (this.slc) {
      ec(localView);
    }
    this.slc = false;
    this.sld = false;
    this.mActivePointerId = -1;
    AppMethodBeat.o(40396);
  }
  
  private void cxm()
  {
    AppMethodBeat.i(40397);
    int j = this.skY - this.skX;
    int k = this.skZ - this.skW;
    int m = this.skS.centerY() + this.skU + j;
    int n = this.skS.centerX() + this.skV + k;
    this.slv = ml(this.slb);
    if (this.slv == null)
    {
      AppMethodBeat.o(40397);
      return;
    }
    Object localObject = null;
    float f2 = 0.0F;
    float f1 = 0.0F;
    Point localPoint1 = ed(this.slv);
    Iterator localIterator = this.idList.iterator();
    int i;
    if (localIterator.hasNext())
    {
      View localView = ml(((Long)localIterator.next()).longValue());
      if (localView == null) {
        break label913;
      }
      Point localPoint2 = ed(localView);
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
                if ((i == 0) || (m >= localView.getBottom() - this.sla))
                {
                  if ((localPoint2.y <= localPoint1.y) || (localPoint2.x != localPoint1.x)) {
                    break label660;
                  }
                  i = 1;
                  if ((i == 0) || (m <= localView.getTop() + this.sla))
                  {
                    if ((localPoint2.y != localPoint1.y) || (localPoint2.x <= localPoint1.x)) {
                      break label666;
                    }
                    i = 1;
                    label501:
                    if ((i == 0) || (n <= localView.getLeft() + this.sla))
                    {
                      if ((localPoint2.y != localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
                        break label672;
                      }
                      i = 1;
                      if ((i == 0) || (n >= localView.getRight() - this.sla)) {
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
        float f4 = Math.abs(f.dV(localView) - f.dV(this.slv));
        label403:
        label550:
        float f3 = Math.abs(f.dW(localView) - f.dW(this.slv));
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
        i = getPositionForView(this.slv);
        m = getPositionForView((View)localObject);
        new StringBuilder("switch ").append(i).append(",").append(m);
        localObject = getAdapterInterface();
        if ((m == -1) || (!((d)localObject).Fl(i)) || (!((d)localObject).Fl(m)))
        {
          mj(this.slb);
          AppMethodBeat.o(40397);
          return;
        }
        fP(i, m);
        if (this.slr) {
          this.slt.fQ(i, m);
        }
        this.skX = this.skY;
        this.skW = this.skZ;
        if ((!cxj()) || (!cxk())) {
          break label873;
        }
        localObject = new b(k, j);
      }
      for (;;)
      {
        mj(this.slb);
        ((DynamicGridView.j)localObject).fR(i, m);
        AppMethodBeat.o(40397);
        return;
        label873:
        if (cxk()) {
          localObject = new DynamicGridView.i(this, k, j);
        } else {
          localObject = new c(k, j);
        }
      }
    }
  }
  
  @TargetApi(11)
  private void dX(View paramView)
  {
    AppMethodBeat.i(40375);
    paramView = dZ(paramView);
    paramView.setFloatValues(new float[] { -2.0F, 2.0F });
    paramView.start();
    this.slg.add(paramView);
    AppMethodBeat.o(40375);
  }
  
  @TargetApi(11)
  private void dY(View paramView)
  {
    AppMethodBeat.i(40376);
    paramView = dZ(paramView);
    paramView.setFloatValues(new float[] { 2.0F, -2.0F });
    paramView.start();
    this.slg.add(paramView);
    AppMethodBeat.o(40376);
  }
  
  @TargetApi(11)
  private ObjectAnimator dZ(View paramView)
  {
    AppMethodBeat.i(40377);
    if (!cxk()) {
      paramView.setLayerType(1, null);
    }
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    localObjectAnimator.setDuration(180L);
    localObjectAnimator.setRepeatMode(2);
    localObjectAnimator.setRepeatCount(-1);
    localObjectAnimator.setPropertyName("rotation");
    localObjectAnimator.setTarget(paramView);
    localObjectAnimator.addListener(new DynamicGridView.3(this, paramView));
    AppMethodBeat.o(40377);
    return localObjectAnimator;
  }
  
  @TargetApi(11)
  private static AnimatorSet e(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(40400);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, 0.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat2, 0.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    AppMethodBeat.o(40400);
    return localAnimatorSet;
  }
  
  private BitmapDrawable ea(View paramView)
  {
    AppMethodBeat.i(40381);
    int j = paramView.getWidth();
    int i = paramView.getHeight();
    int k = paramView.getTop();
    int m = paramView.getLeft();
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    paramView = new BitmapDrawable(getResources(), localBitmap);
    this.skS = new Rect(m, k, m + j, k + i);
    k = this.skS.left;
    m = (int)(j * 0.05F);
    int n = this.skS.top;
    int i1 = (int)(i * 0.05F);
    int i2 = this.skS.right;
    j = (int)(j * 0.05F);
    int i3 = this.skS.bottom;
    this.skR = new Rect(k - m, n - i1, j + i2, (int)(i * 0.05F) + i3);
    this.skT = new Rect(this.skR);
    paramView.setBounds(this.skS);
    AppMethodBeat.o(40381);
    return paramView;
  }
  
  @TargetApi(11)
  private void eb(View paramView)
  {
    AppMethodBeat.i(40394);
    Object localObject = new DynamicGridView.7(this);
    localObject = ObjectAnimator.ofObject(this.skQ, "bounds", (TypeEvaluator)localObject, new Object[] { this.skR });
    ((ObjectAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(40352);
        DynamicGridView.this.invalidate();
        AppMethodBeat.o(40352);
      }
    });
    ((ObjectAnimator)localObject).addListener(new DynamicGridView.9(this, paramView));
    ((ObjectAnimator)localObject).setDuration(200L);
    ((ObjectAnimator)localObject).start();
    AppMethodBeat.o(40394);
  }
  
  private void ec(View paramView)
  {
    AppMethodBeat.i(40395);
    this.idList.clear();
    this.slb = -1L;
    paramView.setVisibility(0);
    this.skQ = null;
    if ((cxj()) && (this.slj))
    {
      if (!this.lNb) {
        break label98;
      }
      lH(false);
      cxe();
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
      lH(true);
    }
    invalidate();
    AppMethodBeat.o(40395);
  }
  
  private Point ed(View paramView)
  {
    AppMethodBeat.i(40398);
    int i = getPositionForView(paramView);
    int j = getColumnCount();
    paramView = new Point(i % j, i / j);
    AppMethodBeat.o(40398);
    return paramView;
  }
  
  private void fP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40378);
    getAdapterInterface().fO(paramInt1, paramInt2);
    AppMethodBeat.o(40378);
  }
  
  private d getAdapterInterface()
  {
    AppMethodBeat.i(40380);
    d locald = (d)getAdapter();
    AppMethodBeat.o(40380);
    return locald;
  }
  
  private int getColumnCount()
  {
    AppMethodBeat.i(40379);
    int i = getAdapterInterface().getColumnCount();
    AppMethodBeat.o(40379);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(40374);
    super.setOnScrollListener(this.slC);
    this.sle = ((int)(paramContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
    this.sla = getResources().getDimensionPixelSize(2131428307);
    AppMethodBeat.o(40374);
  }
  
  private void mj(long paramLong)
  {
    AppMethodBeat.i(40382);
    this.idList.clear();
    int j = mk(paramLong);
    int i = getFirstVisiblePosition();
    while (i <= getLastVisiblePosition())
    {
      if ((j != i) && (getAdapterInterface().Fl(i))) {
        this.idList.add(Long.valueOf(Fr(i)));
      }
      i += 1;
    }
    AppMethodBeat.o(40382);
  }
  
  private boolean o(Rect paramRect)
  {
    AppMethodBeat.i(40390);
    int i = computeVerticalScrollOffset();
    int j = getHeight();
    int k = computeVerticalScrollExtent();
    int m = computeVerticalScrollRange();
    int n = paramRect.top;
    int i1 = paramRect.height();
    if ((n <= 0) && (i > 0))
    {
      smoothScrollBy(-this.sle, 0);
      AppMethodBeat.o(40390);
      return true;
    }
    if ((n + i1 >= j) && (i + k < m))
    {
      smoothScrollBy(this.sle, 0);
      AppMethodBeat.o(40390);
      return true;
    }
    AppMethodBeat.o(40390);
    return false;
  }
  
  public final void Fp(int paramInt)
  {
    AppMethodBeat.i(40369);
    if (!this.slk)
    {
      AppMethodBeat.o(40369);
      return;
    }
    requestDisallowInterceptTouchEvent(true);
    if ((cxj()) && (this.slj)) {
      cxe();
    }
    if (paramInt != -1)
    {
      this.lNb = Fq(paramInt);
      if (this.lNb) {
        this.slc = true;
      }
    }
    AppMethodBeat.o(40369);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(40401);
    super.dispatchDraw(paramCanvas);
    if (this.skQ != null) {
      this.skQ.draw(paramCanvas);
    }
    AppMethodBeat.o(40401);
  }
  
  @TargetApi(11)
  final void lH(boolean paramBoolean)
  {
    AppMethodBeat.i(40373);
    Object localObject = this.slg.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Animator)((Iterator)localObject).next()).cancel();
    }
    this.slg.clear();
    int i = 0;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      if (localObject != null)
      {
        if (paramBoolean) {
          ((View)localObject).setRotation(0.0F);
        }
        ((View)localObject).setTag(2131820591, Boolean.FALSE);
      }
      i += 1;
    }
    AppMethodBeat.o(40373);
  }
  
  public final int mk(long paramLong)
  {
    AppMethodBeat.i(40383);
    View localView = ml(paramLong);
    if (localView == null)
    {
      AppMethodBeat.o(40383);
      return -1;
    }
    int i = getPositionForView(localView);
    AppMethodBeat.o(40383);
    return i;
  }
  
  public final View ml(long paramLong)
  {
    AppMethodBeat.i(40384);
    int j = getFirstVisiblePosition();
    ListAdapter localListAdapter = getAdapter();
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localListAdapter.getItemId(j + i) == paramLong)
      {
        AppMethodBeat.o(40384);
        return localView;
      }
      i += 1;
    }
    AppMethodBeat.o(40384);
    return null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(40385);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    new StringBuilder("onInterceptTouchEvent ").append(paramMotionEvent.getAction()).append(" ").append(bool);
    AppMethodBeat.o(40385);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(40386);
    int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
    new StringBuilder("onTouchEvent ").append(paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(40386);
      return bool;
      this.sly = paramMotionEvent.getX();
      this.slz = paramMotionEvent.getY();
      this.slx = f.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
      new StringBuilder("onTouchEvent ").append(paramMotionEvent.getAction()).append(",downPos ").append(this.slx);
      Object localObject;
      if ((!this.slh) && (this.slx >= 0))
      {
        localObject = this.slw;
        ((DynamicGridView.d)localObject).removeMessages(1);
        ((DynamicGridView.d)localObject).sendEmptyMessageDelayed(1, 300L);
      }
      this.skY = -1;
      this.skZ = -1;
      this.skW = ((int)paramMotionEvent.getX());
      this.skX = ((int)paramMotionEvent.getY());
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if ((this.lNb) && (isEnabled()))
      {
        layoutChildren();
        Fq(pointToPosition(this.skW, this.skX));
      }
      else if (!isEnabled())
      {
        AppMethodBeat.o(40386);
        return false;
        this.sly = paramMotionEvent.getX();
        this.slz = paramMotionEvent.getY();
        if ((this.slc) && (this.mActivePointerId != -1) && (i != -1)) {
          if ((this.skZ == -1) && (this.skY == -1))
          {
            this.skY = ((int)paramMotionEvent.getY(i));
            this.skZ = ((int)paramMotionEvent.getX(i));
            this.skW = this.skZ;
            this.skX = this.skY;
          }
          else
          {
            this.slA = paramMotionEvent.getRawX();
            this.slB = paramMotionEvent.getRawY();
            this.skY = ((int)paramMotionEvent.getY(i));
            this.skZ = ((int)paramMotionEvent.getX(i));
            i = this.skY;
            int j = this.skX;
            int k = this.skZ;
            int m = this.skW;
            this.skR.offsetTo(k - m + this.skT.left + this.skV, i - j + this.skT.top + this.skU);
            if (this.skQ != null) {
              this.skQ.setBounds(this.skR);
            }
            invalidate();
            cxm();
            this.sld = false;
            cxg();
            if (this.sln != null)
            {
              paramMotionEvent = new Rect(this.skR);
              paramMotionEvent.offset(0, this.skR.height() >>> 1);
              this.sln.m(paramMotionEvent);
            }
            AppMethodBeat.o(40386);
            return false;
            cxh();
            if ((this.slr) && (this.slt != null))
            {
              localObject = this.slt;
              Collections.reverse(((a)localObject).slJ);
              if (!((a)localObject).slJ.isEmpty())
              {
                this.sls.push(this.slt);
                this.slt = new a();
                continue;
                cxl();
                cxh();
                continue;
                if (paramMotionEvent.getPointerId((paramMotionEvent.getAction() & 0xFF00) >> 8) == this.mActivePointerId) {
                  cxh();
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
    AppMethodBeat.i(40391);
    super.setAdapter(paramListAdapter);
    AppMethodBeat.o(40391);
  }
  
  public void setEditModeEnabled(boolean paramBoolean)
  {
    this.slk = paramBoolean;
  }
  
  public void setOnDragListener(DynamicGridView.e parame)
  {
    this.sln = parame;
  }
  
  public void setOnDropListener(DynamicGridView.f paramf)
  {
    this.slm = paramf;
  }
  
  public void setOnEditModeChangeListener(DynamicGridView.g paramg)
  {
    this.slo = paramg;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(40370);
    this.slp = paramOnItemClickListener;
    super.setOnItemClickListener(this.slq);
    AppMethodBeat.o(40370);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.sll = paramOnScrollListener;
  }
  
  public void setOnSelectedItemBitmapCreationListener(h paramh)
  {
    this.slu = paramh;
  }
  
  public void setUndoSupportEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(40371);
    if (this.slr != paramBoolean) {
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (this.sls = new Stack();; this.sls = null)
    {
      this.slr = paramBoolean;
      AppMethodBeat.o(40371);
      return;
    }
  }
  
  public void setWobbleInEditMode(boolean paramBoolean)
  {
    this.slj = paramBoolean;
  }
  
  static final class a
  {
    List<Pair<Integer, Integer>> slJ;
    
    a()
    {
      AppMethodBeat.i(40357);
      this.slJ = new Stack();
      AppMethodBeat.o(40357);
    }
    
    public final void fQ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(40358);
      this.slJ.add(new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
      AppMethodBeat.o(40358);
    }
  }
  
  final class b
    implements DynamicGridView.j
  {
    private int rM;
    private int rN;
    
    static
    {
      AppMethodBeat.i(40361);
      if (!DynamicGridView.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(40361);
        return;
      }
    }
    
    public b(int paramInt1, int paramInt2)
    {
      this.rM = paramInt1;
      this.rN = paramInt2;
    }
    
    public final void fR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(40360);
      if ((!$assertionsDisabled) && (DynamicGridView.g(DynamicGridView.this) == null))
      {
        AssertionError localAssertionError = new AssertionError();
        AppMethodBeat.o(40360);
        throw localAssertionError;
      }
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new DynamicGridView.b.a(this, DynamicGridView.g(DynamicGridView.this), paramInt1, paramInt2));
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.ml(DynamicGridView.h(DynamicGridView.this)));
      AppMethodBeat.o(40360);
    }
  }
  
  final class c
    implements DynamicGridView.j
  {
    int rM;
    int rN;
    
    public c(int paramInt1, int paramInt2)
    {
      this.rM = paramInt1;
      this.rN = paramInt2;
    }
    
    public final void fR(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(40364);
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new DynamicGridView.c.a(this, paramInt1, paramInt2));
      AppMethodBeat.o(40364);
    }
  }
  
  public static abstract interface h {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView
 * JD-Core Version:    0.7.0.1
 */