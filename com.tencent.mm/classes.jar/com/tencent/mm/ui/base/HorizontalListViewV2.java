package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.q;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.EdgeEffect;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListViewV2
  extends AdapterView<ListAdapter>
{
  protected ListAdapter NK;
  private Drawable adT = null;
  private int adU = 0;
  private GestureDetector gEU;
  private View.OnClickListener mOnClickListener;
  private Rect mRect = new Rect();
  private HorizontalListViewV2.e uTA = null;
  private int uTB = 0;
  private boolean uTC = false;
  private HorizontalListViewV2.d uTD = null;
  private HorizontalListViewV2.d.a uTE = HorizontalListViewV2.d.a.uTN;
  private i uTF;
  private i uTG;
  private int uTH;
  private boolean uTI = false;
  private boolean uTJ = false;
  private DataSetObserver uTK = new HorizontalListViewV2.2(this);
  private Runnable uTL = new HorizontalListViewV2.3(this);
  protected int uTg;
  protected int uTh;
  private int uTi = 2147483647;
  private int uTj;
  private boolean uTo = false;
  protected Scroller uTs = new Scroller(getContext());
  private final HorizontalListViewV2.a uTt = new HorizontalListViewV2.a(this, (byte)0);
  private List<Queue<View>> uTu = new ArrayList();
  private View uTv = null;
  private Integer uTw = null;
  private int uTx;
  private int uTy;
  private int uTz;
  
  public HorizontalListViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.uTF = new i(paramContext);
    this.uTG = new i(paramContext);
    this.gEU = new GestureDetector(paramContext, this.uTt);
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return HorizontalListViewV2.a(HorizontalListViewV2.this).onTouchEvent(paramAnonymousMotionEvent);
      }
    });
    initView();
    setWillNotDraw(false);
    if (Build.VERSION.SDK_INT >= 11) {
      HorizontalListViewV2.b.a(this.uTs);
    }
  }
  
  private View Gh(int paramInt)
  {
    paramInt = this.NK.getItemViewType(paramInt);
    if (Gi(paramInt)) {
      return (View)((Queue)this.uTu.get(paramInt)).poll();
    }
    return null;
  }
  
  private boolean Gi(int paramInt)
  {
    return paramInt < this.uTu.size();
  }
  
  private boolean Gj(int paramInt)
  {
    return paramInt == this.NK.getCount() - 1;
  }
  
  private void T(View paramView, int paramInt)
  {
    addViewInLayout(paramView, paramInt, dC(paramView), true);
    ViewGroup.LayoutParams localLayoutParams = dC(paramView);
    int i = ViewGroup.getChildMeasureSpec(this.uTH, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    if (localLayoutParams.width > 0) {}
    for (paramInt = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);; paramInt = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt, i);
      return;
    }
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    if (this.adT != null)
    {
      this.adT.setBounds(paramRect);
      this.adT.draw(paramCanvas);
    }
  }
  
  private float cAt()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return HorizontalListViewV2.c.b(this.uTs);
    }
    return 30.0F;
  }
  
  private void cAu()
  {
    if (this.uTv != null)
    {
      this.uTv.setPressed(false);
      refreshDrawableState();
      this.uTv = null;
    }
  }
  
  private void cAv()
  {
    if (this.uTF != null) {
      this.uTF.dL();
    }
    if (this.uTG != null) {
      this.uTG.dL();
    }
  }
  
  private static ViewGroup.LayoutParams dC(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (localLayoutParams == null) {
      paramView = new ViewGroup.LayoutParams(-2, -1);
    }
    return paramView;
  }
  
  private int fo(int paramInt1, int paramInt2)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).getHitRect(this.mRect);
      if (this.mRect.contains(paramInt1, paramInt2)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private View getLeftmostChild()
  {
    return getChildAt(0);
  }
  
  private int getRenderHeight()
  {
    return getHeight() - getPaddingTop() - getPaddingBottom();
  }
  
  private int getRenderWidth()
  {
    return getWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private View getRightmostChild()
  {
    return getChildAt(getChildCount() - 1);
  }
  
  private void h(int paramInt, View paramView)
  {
    paramInt = this.NK.getItemViewType(paramInt);
    if (Gi(paramInt)) {
      ((Queue)this.uTu.get(paramInt)).offer(paramView);
    }
  }
  
  private void i(Boolean paramBoolean)
  {
    if (this.uTJ != paramBoolean.booleanValue()) {}
    for (Object localObject = this;; localObject = (View)((View)localObject).getParent()) {
      if ((((View)localObject).getParent() instanceof View))
      {
        if (((((View)localObject).getParent() instanceof ListView)) || ((((View)localObject).getParent() instanceof ScrollView)))
        {
          ((View)localObject).getParent().requestDisallowInterceptTouchEvent(paramBoolean.booleanValue());
          this.uTJ = paramBoolean.booleanValue();
        }
      }
      else {
        return;
      }
    }
  }
  
  private void initView()
  {
    this.uTx = -1;
    this.uTy = -1;
    this.uTj = 0;
    this.uTg = 0;
    this.uTh = 0;
    this.uTi = 2147483647;
    setCurrentScrollState(HorizontalListViewV2.d.a.uTN);
  }
  
  private void reset()
  {
    initView();
    removeAllViewsInLayout();
    requestLayout();
  }
  
  private void setCurrentScrollState(HorizontalListViewV2.d.a parama)
  {
    if ((this.uTE != parama) && (this.uTD != null)) {
      this.uTD.a(parama);
    }
    this.uTE = parama;
  }
  
  public final void Gk(int paramInt)
  {
    this.uTs.startScroll(this.uTh, 0, paramInt - this.uTh, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.uTP);
    requestLayout();
  }
  
  protected final boolean aM(float paramFloat)
  {
    this.uTs.fling(this.uTh, 0, (int)-paramFloat, 0, 0, this.uTi, 0, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.uTP);
    requestLayout();
    return true;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  public ListAdapter getAdapter()
  {
    return this.NK;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.uTx;
  }
  
  public int getLastVisiblePosition()
  {
    return this.uTy;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    int i = getHorizontalFadingEdgeLength();
    if (this.uTg == 0) {
      return 0.0F;
    }
    if (this.uTg < i) {
      return this.uTg / i;
    }
    return 1.0F;
  }
  
  protected float getRightFadingEdgeStrength()
  {
    int i = getHorizontalFadingEdgeLength();
    if (this.uTg == this.uTi) {
      return 0.0F;
    }
    if (this.uTi - this.uTg < i) {
      return (this.uTi - this.uTg) / i;
    }
    return 1.0F;
  }
  
  public View getSelectedView()
  {
    int i = this.uTz;
    if ((i >= this.uTx) && (i <= this.uTy)) {
      return getChildAt(i - this.uTx);
    }
    return null;
  }
  
  protected final boolean onDown(MotionEvent paramMotionEvent)
  {
    if (!this.uTs.isFinished()) {}
    for (boolean bool = true;; bool = false)
    {
      this.uTI = bool;
      this.uTs.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.uTN);
      cAu();
      if (!this.uTI)
      {
        int i = fo((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (i >= 0)
        {
          this.uTv = getChildAt(i);
          if (this.uTv != null)
          {
            this.uTv.setPressed(true);
            refreshDrawableState();
          }
        }
      }
      return true;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getChildCount();
    Rect localRect = this.mRect;
    this.mRect.top = getPaddingTop();
    this.mRect.bottom = (this.mRect.top + getRenderHeight());
    int i = 0;
    while (i < j)
    {
      if ((i != j - 1) || (!Gj(this.uTy)))
      {
        View localView = getChildAt(i);
        localRect.left = localView.getRight();
        localRect.right = (localView.getRight() + this.adU);
        if (localRect.left < getPaddingLeft()) {
          localRect.left = getPaddingLeft();
        }
        if (localRect.right > getWidth() - getPaddingRight()) {
          localRect.right = (getWidth() - getPaddingRight());
        }
        a(paramCanvas, localRect);
        if ((i == 0) && (localView.getLeft() > getPaddingLeft()))
        {
          localRect.left = getPaddingLeft();
          localRect.right = localView.getLeft();
          a(paramCanvas, localRect);
        }
      }
      i += 1;
    }
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.NK == null) {
      return;
    }
    invalidate();
    if (this.uTo)
    {
      i = this.uTg;
      initView();
      removeAllViewsInLayout();
      this.uTh = i;
      this.uTo = false;
    }
    if (this.uTw != null)
    {
      this.uTh = this.uTw.intValue();
      this.uTw = null;
    }
    if (this.uTs.computeScrollOffset()) {
      this.uTh = this.uTs.getCurrX();
    }
    int m;
    label172:
    int j;
    if (this.uTh < 0)
    {
      this.uTh = 0;
      if (this.uTF.KQ.isFinished()) {
        this.uTF.aI((int)cAt());
      }
      this.uTs.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.uTN);
      m = this.uTg - this.uTh;
      localView = getLeftmostChild();
      if ((localView == null) || (localView.getRight() + m > 0)) {
        break label334;
      }
      j = this.uTj;
      if (!Gj(this.uTx)) {
        break label319;
      }
    }
    label319:
    for (int i = localView.getMeasuredWidth();; i = this.adU + localView.getMeasuredWidth())
    {
      this.uTj = (i + j);
      h(this.uTx, localView);
      removeViewInLayout(localView);
      this.uTx += 1;
      localView = getLeftmostChild();
      break label172;
      if (this.uTh <= this.uTi) {
        break;
      }
      this.uTh = this.uTi;
      if (this.uTG.KQ.isFinished()) {
        this.uTG.aI((int)cAt());
      }
      this.uTs.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.uTN);
      break;
    }
    for (;;)
    {
      label334:
      localView = getRightmostChild();
      if ((localView == null) || (localView.getLeft() + m < getWidth())) {
        break;
      }
      h(this.uTy, localView);
      removeViewInLayout(localView);
      this.uTy -= 1;
    }
    View localView = getRightmostChild();
    if (localView != null) {
      i = localView.getRight();
    }
    for (;;)
    {
      if ((i + m + this.adU < getWidth()) && (this.uTy + 1 < this.NK.getCount()))
      {
        this.uTy += 1;
        if (this.uTx < 0) {
          this.uTx = this.uTy;
        }
        localView = this.NK.getView(this.uTy, Gh(this.uTy), this);
        T(localView, -1);
        if (this.uTy == 0) {}
        for (j = 0;; j = this.adU)
        {
          j = i + (j + localView.getMeasuredWidth());
          i = j;
          if (this.uTA == null) {
            break;
          }
          i = j;
          if (this.NK == null) {
            break;
          }
          i = j;
          if (this.NK.getCount() - (this.uTy + 1) >= this.uTB) {
            break;
          }
          i = j;
          if (this.uTC) {
            break;
          }
          this.uTC = true;
          i = j;
          break;
        }
      }
      localView = getLeftmostChild();
      if (localView != null) {
        i = localView.getLeft();
      }
      for (;;)
      {
        if ((i + m - this.adU > 0) && (this.uTx > 0))
        {
          this.uTx -= 1;
          localView = this.NK.getView(this.uTx, Gh(this.uTx), this);
          T(localView, 0);
          if (this.uTx == 0)
          {
            j = localView.getMeasuredWidth();
            label695:
            j = i - j;
            n = this.uTj;
            if (j + m != 0) {
              break label754;
            }
          }
          label754:
          for (i = localView.getMeasuredWidth();; i = this.adU + localView.getMeasuredWidth())
          {
            this.uTj = (n - i);
            i = j;
            break;
            j = this.adU + localView.getMeasuredWidth();
            break label695;
          }
        }
        int n = getChildCount();
        if (n > 0)
        {
          this.uTj += m;
          j = this.uTj;
          i = 0;
          while (i < n)
          {
            localView = getChildAt(i);
            m = getPaddingLeft() + j;
            int i1 = getPaddingTop();
            localView.layout(m, i1, localView.getMeasuredWidth() + m, localView.getMeasuredHeight() + i1);
            j += localView.getMeasuredWidth() + this.adU;
            i += 1;
          }
        }
        this.uTg = this.uTh;
        i = k;
        if (Gj(this.uTy))
        {
          localView = getRightmostChild();
          i = k;
          if (localView != null)
          {
            j = this.uTi;
            i = this.uTg;
            this.uTi = (localView.getRight() - getPaddingLeft() + i - getRenderWidth());
            if (this.uTi < 0) {
              this.uTi = 0;
            }
            i = k;
            if (this.uTi != j) {
              i = 1;
            }
          }
        }
        if (i != 0)
        {
          onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
          return;
        }
        if (this.uTs.isFinished())
        {
          if (this.uTE != HorizontalListViewV2.d.a.uTP) {
            break;
          }
          setCurrentScrollState(HorizontalListViewV2.d.a.uTN);
          return;
        }
        q.b(this, this.uTL);
        return;
        i = 0;
      }
      i = 0;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.uTH = paramInt2;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.uTw = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.uTg);
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if ((this.uTs == null) || (this.uTs.isFinished())) {
        setCurrentScrollState(HorizontalListViewV2.d.a.uTN);
      }
      i(Boolean.valueOf(false));
      cAv();
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (paramMotionEvent.getAction() == 3)
      {
        cAu();
        cAv();
        i(Boolean.valueOf(false));
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    int i = 0;
    if (this.NK != null) {
      this.NK.unregisterDataSetObserver(this.uTK);
    }
    if (paramListAdapter != null)
    {
      this.uTC = false;
      this.NK = paramListAdapter;
      this.NK.registerDataSetObserver(this.uTK);
    }
    if (this.NK != null)
    {
      int j = this.NK.getViewTypeCount();
      this.uTu.clear();
      while (i < j)
      {
        this.uTu.add(new LinkedList());
        i += 1;
      }
    }
    reset();
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    this.adT = paramDrawable;
    if (paramDrawable != null)
    {
      setDividerWidth(paramDrawable.getIntrinsicWidth());
      return;
    }
    setDividerWidth(0);
  }
  
  public void setDividerWidth(int paramInt)
  {
    this.adU = paramInt;
    requestLayout();
    invalidate();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setOnScrollStateChangedListener(HorizontalListViewV2.d paramd)
  {
    this.uTD = paramd;
  }
  
  public void setSelection(int paramInt)
  {
    this.uTz = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2
 * JD-Core Version:    0.7.0.1
 */