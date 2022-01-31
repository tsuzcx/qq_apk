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
  private int fC = -1;
  private List<Long> idList = new ArrayList();
  boolean jDC = false;
  private int lf = 0;
  private BitmapDrawable ppY;
  private Rect ppZ;
  private Stack<a> pqA;
  private a pqB;
  private DynamicGridView.h pqC;
  private View pqD;
  DynamicGridView.d pqE = new DynamicGridView.d(this, (byte)0);
  int pqF = -1;
  float pqG;
  float pqH;
  private float pqI;
  private float pqJ;
  private AbsListView.OnScrollListener pqK = new DynamicGridView.2(this);
  private Rect pqa;
  private Rect pqb;
  private int pqc = 0;
  private int pqd = 0;
  private int pqe = -1;
  private int pqf = -1;
  private int pqg = -1;
  private int pqh = -1;
  private int pqi;
  private long pqj = -1L;
  private boolean pqk = false;
  private boolean pql;
  private int pqm = 0;
  private boolean pqn = false;
  private List<ObjectAnimator> pqo = new LinkedList();
  boolean pqp;
  boolean pqq;
  boolean pqr = true;
  private boolean pqs = true;
  private AbsListView.OnScrollListener pqt;
  private DynamicGridView.f pqu;
  private DynamicGridView.e pqv;
  private DynamicGridView.g pqw;
  private AdapterView.OnItemClickListener pqx;
  private AdapterView.OnItemClickListener pqy = new DynamicGridView.1(this);
  private boolean pqz;
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public DynamicGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  @TargetApi(11)
  private void bKr()
  {
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView != null) && (Boolean.TRUE != localView.getTag(i.f.dgv_wobble_tag)))
      {
        if (i % 2 != 0) {
          break label62;
        }
        dg(localView);
      }
      for (;;)
      {
        localView.setTag(i.f.dgv_wobble_tag, Boolean.valueOf(true));
        i += 1;
        break;
        label62:
        dh(localView);
      }
    }
  }
  
  private boolean bKs()
  {
    int i = gC(this.pqj);
    if (i != -1)
    {
      this.pqv.zd(i);
      if (this.pqD == null) {
        return false;
      }
    }
    else
    {
      return false;
    }
    i = getPositionForView(this.pqD);
    int j = getChildCount() - 1;
    new StringBuilder("switch ").append(i).append(",").append(j);
    ec(i, j);
    if (this.pqz) {
      this.pqB.ed(i, j);
    }
    this.pqf = this.pqg;
    this.pqe = this.pqh;
    Object localObject;
    if ((bKv()) && (bKw())) {
      localObject = new b(0, 0);
    }
    for (;;)
    {
      gB(this.pqj);
      ((DynamicGridView.j)localObject).ee(i, j);
      return true;
      if (bKw()) {
        localObject = new DynamicGridView.i(this, 0, 0);
      } else {
        localObject = new c(0, 0);
      }
    }
  }
  
  private void bKt()
  {
    boolean bool = true;
    Rect localRect = this.ppZ;
    int i = computeVerticalScrollOffset();
    int j = getHeight();
    int k = computeVerticalScrollExtent();
    int m = computeVerticalScrollRange();
    int n = localRect.top;
    int i1 = localRect.height();
    if ((n <= 0) && (i > 0)) {
      smoothScrollBy(-this.pqm, 0);
    }
    for (;;)
    {
      this.pql = bool;
      return;
      if ((i1 + n >= j) && (i + k < m)) {
        smoothScrollBy(this.pqm, 0);
      } else {
        bool = false;
      }
    }
  }
  
  private void bKu()
  {
    this.pqE.removeMessages(1);
    View localView = gD(this.pqj);
    Object localObject;
    if (this.ppZ != null)
    {
      localObject = new Rect(this.ppZ);
      ((Rect)localObject).offset(0, this.ppZ.height() >>> 1);
    }
    for (;;)
    {
      if ((this.pqv != null) && (this.pqv.l((Rect)localObject)) && (bKs()))
      {
        this.ppY = null;
        bKx();
        if (this.pqu != null) {
          this.pqu.bKq();
        }
      }
      for (;;)
      {
        if (this.pqv != null) {
          this.pqv.bKp();
        }
        return;
        if ((localView != null) && ((this.pqk) || (this.pqn)))
        {
          this.pqk = false;
          this.pqn = false;
          this.pql = false;
          this.fC = -1;
          this.ppZ.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
          new StringBuilder("animating to  ").append(this.ppZ);
          if (Build.VERSION.SDK_INT > 11)
          {
            localObject = new DynamicGridView.7(this);
            localObject = ObjectAnimator.ofObject(this.ppY, "bounds", (TypeEvaluator)localObject, new Object[] { this.ppZ });
            ((ObjectAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
              {
                DynamicGridView.this.invalidate();
              }
            });
            ((ObjectAnimator)localObject).addListener(new DynamicGridView.9(this, localView));
            ((ObjectAnimator)localObject).setDuration(200L);
            ((ObjectAnimator)localObject).start();
          }
          else
          {
            this.ppY.setBounds(this.ppZ);
            invalidate();
            dj(localView);
          }
        }
        else
        {
          bKx();
        }
      }
      localObject = null;
    }
  }
  
  static boolean bKv()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  private static boolean bKw()
  {
    return Build.VERSION.SDK_INT < 21;
  }
  
  private void bKx()
  {
    View localView = gD(this.pqj);
    if (localView == null) {
      return;
    }
    if (this.pqk) {
      dj(localView);
    }
    this.pqk = false;
    this.pql = false;
    this.fC = -1;
  }
  
  private void bKy()
  {
    int j = this.pqg - this.pqf;
    int k = this.pqh - this.pqe;
    int m = this.pqa.centerY() + this.pqc + j;
    int n = this.pqa.centerX() + this.pqd + k;
    this.pqD = gD(this.pqj);
    if (this.pqD == null) {
      return;
    }
    Object localObject = null;
    float f2 = 0.0F;
    float f1 = 0.0F;
    Point localPoint1 = dk(this.pqD);
    Iterator localIterator = this.idList.iterator();
    label104:
    int i;
    if (localIterator.hasNext())
    {
      View localView = gD(((Long)localIterator.next()).longValue());
      if (localView == null) {
        break label889;
      }
      Point localPoint2 = dk(localView);
      if ((localPoint2.y < localPoint1.y) && (localPoint2.x > localPoint1.x))
      {
        i = 1;
        label175:
        label337:
        if ((i == 0) || (m >= localView.getBottom()) || (n <= localView.getLeft()))
        {
          if ((localPoint2.y >= localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
            break label624;
          }
          i = 1;
          label229:
          if ((i == 0) || (m >= localView.getBottom()) || (n >= localView.getRight()))
          {
            if ((localPoint2.y <= localPoint1.y) || (localPoint2.x <= localPoint1.x)) {
              break label630;
            }
            i = 1;
            if ((i == 0) || (m <= localView.getTop()) || (n <= localView.getLeft()))
            {
              if ((localPoint2.y <= localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
                break label636;
              }
              i = 1;
              if ((i == 0) || (m <= localView.getTop()) || (n >= localView.getRight()))
              {
                if ((localPoint2.y >= localPoint1.y) || (localPoint2.x != localPoint1.x)) {
                  break label642;
                }
                i = 1;
                if ((i == 0) || (m >= localView.getBottom() - this.pqi))
                {
                  if ((localPoint2.y <= localPoint1.y) || (localPoint2.x != localPoint1.x)) {
                    break label648;
                  }
                  i = 1;
                  if ((i == 0) || (m <= localView.getTop() + this.pqi))
                  {
                    if ((localPoint2.y != localPoint1.y) || (localPoint2.x <= localPoint1.x)) {
                      break label654;
                    }
                    i = 1;
                    label489:
                    if ((i == 0) || (n <= localView.getLeft() + this.pqi))
                    {
                      if ((localPoint2.y != localPoint1.y) || (localPoint2.x >= localPoint1.x)) {
                        break label660;
                      }
                      i = 1;
                      if ((i == 0) || (n >= localView.getRight() - this.pqi)) {
                        break label889;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label283:
        label440:
        float f4 = Math.abs(f.de(localView) - f.de(this.pqD));
        label391:
        label538:
        float f3 = Math.abs(f.df(localView) - f.df(this.pqD));
        if ((f4 < f2) || (f3 < f1)) {
          break label889;
        }
        f2 = f4;
        localObject = localView;
        f1 = f3;
      }
    }
    label624:
    label630:
    label889:
    for (;;)
    {
      break label104;
      i = 0;
      break label175;
      i = 0;
      break label229;
      i = 0;
      break label283;
      label636:
      i = 0;
      break label337;
      i = 0;
      break label391;
      i = 0;
      break label440;
      i = 0;
      break label489;
      i = 0;
      break label538;
      if (localObject == null) {
        break;
      }
      i = getPositionForView(this.pqD);
      m = getPositionForView((View)localObject);
      new StringBuilder("switch ").append(i).append(",").append(m);
      localObject = getAdapterInterface();
      if ((m == -1) || (!((d)localObject).za(i)) || (!((d)localObject).za(m)))
      {
        gB(this.pqj);
        return;
      }
      ec(i, m);
      if (this.pqz) {
        this.pqB.ed(i, m);
      }
      this.pqf = this.pqg;
      this.pqe = this.pqh;
      if ((bKv()) && (bKw())) {
        localObject = new b(k, j);
      }
      for (;;)
      {
        gB(this.pqj);
        ((DynamicGridView.j)localObject).ee(i, m);
        return;
        if (bKw()) {
          localObject = new DynamicGridView.i(this, k, j);
        } else {
          localObject = new c(k, j);
        }
      }
    }
  }
  
  @TargetApi(11)
  private void dg(View paramView)
  {
    paramView = di(paramView);
    paramView.setFloatValues(new float[] { -2.0F, 2.0F });
    paramView.start();
    this.pqo.add(paramView);
  }
  
  @TargetApi(11)
  private void dh(View paramView)
  {
    paramView = di(paramView);
    paramView.setFloatValues(new float[] { 2.0F, -2.0F });
    paramView.start();
    this.pqo.add(paramView);
  }
  
  @TargetApi(11)
  private ObjectAnimator di(View paramView)
  {
    if (!bKw()) {
      paramView.setLayerType(1, null);
    }
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    localObjectAnimator.setDuration(180L);
    localObjectAnimator.setRepeatMode(2);
    localObjectAnimator.setRepeatCount(-1);
    localObjectAnimator.setPropertyName("rotation");
    localObjectAnimator.setTarget(paramView);
    localObjectAnimator.addListener(new DynamicGridView.3(this, paramView));
    return localObjectAnimator;
  }
  
  private void dj(View paramView)
  {
    this.idList.clear();
    this.pqj = -1L;
    paramView.setVisibility(0);
    this.ppY = null;
    if ((bKv()) && (this.pqr))
    {
      if (!this.jDC) {
        break label92;
      }
      jB(false);
      bKr();
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
      label92:
      jB(true);
    }
    invalidate();
  }
  
  private Point dk(View paramView)
  {
    int i = getPositionForView(paramView);
    int j = getColumnCount();
    return new Point(i % j, i / j);
  }
  
  @TargetApi(11)
  private static AnimatorSet e(View paramView, float paramFloat1, float paramFloat2)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, 0.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { paramFloat2, 0.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator, paramView });
    return localAnimatorSet;
  }
  
  private void ec(int paramInt1, int paramInt2)
  {
    getAdapterInterface().eb(paramInt1, paramInt2);
  }
  
  private void gB(long paramLong)
  {
    this.idList.clear();
    int j = gC(paramLong);
    int i = getFirstVisiblePosition();
    while (i <= getLastVisiblePosition())
    {
      if ((j != i) && (getAdapterInterface().za(i))) {
        this.idList.add(Long.valueOf(zg(i)));
      }
      i += 1;
    }
  }
  
  private d getAdapterInterface()
  {
    return (d)getAdapter();
  }
  
  private int getColumnCount()
  {
    return getAdapterInterface().getColumnCount();
  }
  
  private void init(Context paramContext)
  {
    super.setOnScrollListener(this.pqK);
    this.pqm = ((int)(paramContext.getResources().getDisplayMetrics().density * 8.0F + 0.5F));
    this.pqi = getResources().getDimensionPixelSize(i.d.dgv_overlap_if_switch_straight_line);
  }
  
  private boolean zf(int paramInt)
  {
    if (!getAdapterInterface().yZ(paramInt)) {}
    View localView;
    do
    {
      return false;
      this.pqc = 0;
      this.pqd = 0;
      localView = getChildAt(paramInt - getFirstVisiblePosition());
    } while (localView == null);
    this.pqj = getAdapter().getItemId(paramInt);
    int j = localView.getWidth();
    int i = localView.getHeight();
    int k = localView.getTop();
    int m = localView.getLeft();
    Object localObject = Bitmap.createBitmap(localView.getWidth(), localView.getHeight(), Bitmap.Config.ARGB_8888);
    localView.draw(new Canvas((Bitmap)localObject));
    localObject = new BitmapDrawable(getResources(), (Bitmap)localObject);
    this.pqa = new Rect(m, k, m + j, k + i);
    k = this.pqa.left;
    m = (int)(j * 0.05F);
    int n = this.pqa.top;
    int i1 = (int)(i * 0.05F);
    int i2 = this.pqa.right;
    j = (int)(j * 0.05F);
    int i3 = this.pqa.bottom;
    this.ppZ = new Rect(k - m, n - i1, j + i2, (int)(i * 0.05F) + i3);
    this.pqb = new Rect(this.ppZ);
    ((BitmapDrawable)localObject).setBounds(this.pqa);
    this.ppY = ((BitmapDrawable)localObject);
    localObject = new TypeEvaluator()
    {
      private static int d(int paramAnonymousInt1, int paramAnonymousInt2, float paramAnonymousFloat)
      {
        return (int)(paramAnonymousInt1 + (paramAnonymousInt2 - paramAnonymousInt1) * paramAnonymousFloat);
      }
    };
    localObject = ObjectAnimator.ofObject(this.ppY, "bounds", (TypeEvaluator)localObject, new Object[] { this.ppZ });
    ((ObjectAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        DynamicGridView.this.invalidate();
      }
    });
    ((ObjectAnimator)localObject).addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        DynamicGridView.a(DynamicGridView.this, false);
        DynamicGridView.b(DynamicGridView.this);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        DynamicGridView.a(DynamicGridView.this, true);
        DynamicGridView.b(DynamicGridView.this);
      }
    });
    ((ObjectAnimator)localObject).setDuration(10L);
    ((ObjectAnimator)localObject).start();
    if (bKv()) {
      localView.setVisibility(4);
    }
    gB(this.pqj);
    if (this.pqv != null) {
      this.pqv.zc(paramInt);
    }
    return true;
  }
  
  private long zg(int paramInt)
  {
    return getAdapter().getItemId(paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.ppY != null) {
      this.ppY.draw(paramCanvas);
    }
  }
  
  public final int gC(long paramLong)
  {
    View localView = gD(paramLong);
    if (localView == null) {
      return -1;
    }
    return getPositionForView(localView);
  }
  
  public final View gD(long paramLong)
  {
    int j = getFirstVisiblePosition();
    ListAdapter localListAdapter = getAdapter();
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if (localListAdapter.getItemId(j + i) == paramLong) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  @TargetApi(11)
  final void jB(boolean paramBoolean)
  {
    Object localObject = this.pqo.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Animator)((Iterator)localObject).next()).cancel();
    }
    this.pqo.clear();
    int i = 0;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      if (localObject != null)
      {
        if (paramBoolean) {
          ((View)localObject).setRotation(0.0F);
        }
        ((View)localObject).setTag(i.f.dgv_wobble_tag, Boolean.valueOf(false));
      }
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    new StringBuilder("onInterceptTouchEvent ").append(paramMotionEvent.getAction()).append(" ").append(bool);
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i = paramMotionEvent.findPointerIndex(this.fC);
    new StringBuilder("onTouchEvent ").append(paramMotionEvent.getAction());
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      Object localObject;
      do
      {
        return bool;
        this.pqG = paramMotionEvent.getX();
        this.pqH = paramMotionEvent.getY();
        this.pqF = f.a(this, paramMotionEvent.getX(), paramMotionEvent.getY());
        new StringBuilder("onTouchEvent ").append(paramMotionEvent.getAction()).append(",downPos ").append(this.pqF);
        if ((!this.pqp) && (this.pqF >= 0))
        {
          localObject = this.pqE;
          ((DynamicGridView.d)localObject).removeMessages(1);
          ((DynamicGridView.d)localObject).sendEmptyMessageDelayed(1, 300L);
        }
        this.pqg = -1;
        this.pqh = -1;
        this.pqe = ((int)paramMotionEvent.getX());
        this.pqf = ((int)paramMotionEvent.getY());
        this.fC = paramMotionEvent.getPointerId(0);
        if ((this.jDC) && (isEnabled()))
        {
          layoutChildren();
          zf(pointToPosition(this.pqe, this.pqf));
          break;
        }
        if (isEnabled()) {
          break;
        }
        return false;
        this.pqG = paramMotionEvent.getX();
        this.pqH = paramMotionEvent.getY();
        if ((!this.pqk) || (this.fC == -1)) {
          break;
        }
        if ((this.pqh == -1) && (this.pqg == -1))
        {
          this.pqg = ((int)paramMotionEvent.getY(i));
          this.pqh = ((int)paramMotionEvent.getX(i));
          this.pqe = this.pqh;
          this.pqf = this.pqg;
          break;
        }
        this.pqI = paramMotionEvent.getRawX();
        this.pqJ = paramMotionEvent.getRawY();
        this.pqg = ((int)paramMotionEvent.getY(i));
        this.pqh = ((int)paramMotionEvent.getX(i));
        i = this.pqg;
        int j = this.pqf;
        int k = this.pqh;
        int m = this.pqe;
        this.ppZ.offsetTo(k - m + this.pqb.left + this.pqd, i - j + this.pqb.top + this.pqc);
        if (this.ppY != null) {
          this.ppY.setBounds(this.ppZ);
        }
        invalidate();
        bKy();
        this.pql = false;
        bKt();
      } while (this.pqv == null);
      paramMotionEvent = new Rect(this.ppZ);
      paramMotionEvent.offset(0, this.ppZ.height() >>> 1);
      this.pqv.k(paramMotionEvent);
      return false;
      bKu();
      if ((this.pqz) && (this.pqB != null))
      {
        localObject = this.pqB;
        Collections.reverse(((a)localObject).pqR);
        if (!((a)localObject).pqR.isEmpty())
        {
          this.pqA.push(this.pqB);
          this.pqB = new a();
          continue;
          bKx();
          bKu();
          continue;
          if (paramMotionEvent.getPointerId((paramMotionEvent.getAction() & 0xFF00) >> 8) == this.fC) {
            bKu();
          }
        }
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
  }
  
  public void setEditModeEnabled(boolean paramBoolean)
  {
    this.pqs = paramBoolean;
  }
  
  public void setOnDragListener(DynamicGridView.e parame)
  {
    this.pqv = parame;
  }
  
  public void setOnDropListener(DynamicGridView.f paramf)
  {
    this.pqu = paramf;
  }
  
  public void setOnEditModeChangeListener(DynamicGridView.g paramg)
  {
    this.pqw = paramg;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.pqx = paramOnItemClickListener;
    super.setOnItemClickListener(this.pqy);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.pqt = paramOnScrollListener;
  }
  
  public void setOnSelectedItemBitmapCreationListener(DynamicGridView.h paramh)
  {
    this.pqC = paramh;
  }
  
  public void setUndoSupportEnabled(boolean paramBoolean)
  {
    if (this.pqz != paramBoolean) {
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (this.pqA = new Stack();; this.pqA = null)
    {
      this.pqz = paramBoolean;
      return;
    }
  }
  
  public void setWobbleInEditMode(boolean paramBoolean)
  {
    this.pqr = paramBoolean;
  }
  
  public final void ze(int paramInt)
  {
    if (!this.pqs) {}
    do
    {
      do
      {
        return;
        requestDisallowInterceptTouchEvent(true);
        if ((bKv()) && (this.pqr)) {
          bKr();
        }
      } while (paramInt == -1);
      this.jDC = zf(paramInt);
    } while (!this.jDC);
    this.pqk = true;
  }
  
  private static final class a
  {
    List<Pair<Integer, Integer>> pqR = new Stack();
    
    public final void ed(int paramInt1, int paramInt2)
    {
      this.pqR.add(new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
    }
  }
  
  private final class b
    implements DynamicGridView.j
  {
    private int qP;
    private int qQ;
    
    static
    {
      if (!DynamicGridView.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    public b(int paramInt1, int paramInt2)
    {
      this.qP = paramInt1;
      this.qQ = paramInt2;
    }
    
    public final void ee(int paramInt1, int paramInt2)
    {
      assert (DynamicGridView.g(DynamicGridView.this) != null);
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new DynamicGridView.b.a(this, DynamicGridView.g(DynamicGridView.this), paramInt1, paramInt2));
      DynamicGridView.b(DynamicGridView.this, DynamicGridView.this.gD(DynamicGridView.h(DynamicGridView.this)));
    }
  }
  
  private final class c
    implements DynamicGridView.j
  {
    int qP;
    int qQ;
    
    public c(int paramInt1, int paramInt2)
    {
      this.qP = paramInt1;
      this.qQ = paramInt2;
    }
    
    public final void ee(int paramInt1, int paramInt2)
    {
      DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new DynamicGridView.c.a(this, paramInt1, paramInt2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView
 * JD-Core Version:    0.7.0.1
 */