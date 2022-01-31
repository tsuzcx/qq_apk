package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

public class MMHorList
  extends AdapterView<ListAdapter>
{
  private boolean mBn = false;
  private int offset;
  private a uVV;
  private int uVW;
  private int uVX;
  private int uVY;
  private int uVZ;
  private int uWa = 536870912;
  private Queue<View> uWb = new LinkedList();
  private boolean uWc = false;
  private boolean uWd = false;
  protected Scroller uWe;
  private GestureDetector uWf;
  private AdapterView.OnItemSelectedListener uWg;
  private AdapterView.OnItemClickListener uWh;
  private ListAdapter uWi;
  private Runnable uWj = new MMHorList.1(this);
  private boolean uWk = false;
  private boolean uWl = false;
  private int uWm = 0;
  private int uWn = 0;
  private boolean uWo = false;
  private DataSetObserver uWp = new MMHorList.2(this);
  private GestureDetector.OnGestureListener uWq = new GestureDetector.SimpleOnGestureListener()
  {
    public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
    {
      return MMHorList.this.cAs();
    }
    
    public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      return MMHorList.this.aM(paramAnonymousFloat1);
    }
    
    public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      MMHorList.a(MMHorList.this, MMHorList.c(MMHorList.this) + (int)paramAnonymousFloat1);
      MMHorList.this.requestLayout();
      return true;
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
    {
      Rect localRect = new Rect();
      int i = 0;
      for (;;)
      {
        if (i < MMHorList.this.getChildCount())
        {
          View localView = MMHorList.this.getChildAt(i);
          int j = localView.getLeft();
          int k = localView.getRight();
          localRect.set(j, localView.getTop(), k, localView.getBottom());
          if (!localRect.contains((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY())) {
            break label207;
          }
          if (MMHorList.d(MMHorList.this) != null) {
            MMHorList.d(MMHorList.this).onItemClick(MMHorList.this, localView, MMHorList.e(MMHorList.this) + 1 + i, MMHorList.f(MMHorList.this).getItemId(MMHorList.e(MMHorList.this) + 1 + i));
          }
          if (MMHorList.g(MMHorList.this) != null) {
            MMHorList.g(MMHorList.this).onItemSelected(MMHorList.this, localView, MMHorList.e(MMHorList.this) + 1 + i, MMHorList.f(MMHorList.this).getItemId(MMHorList.e(MMHorList.this) + 1 + i));
          }
        }
        return true;
        label207:
        i += 1;
      }
    }
  };
  
  public MMHorList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MMHorList(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void T(View paramView, int paramInt)
  {
    this.uWd = true;
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
    }
    addViewInLayout(paramView, paramInt, localLayoutParams1, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
  }
  
  private int getChildViewTotalWidth()
  {
    return this.uWi.getCount() * this.uWm;
  }
  
  private void init()
  {
    this.uWe = new Scroller(getContext());
    this.uVW = -1;
    this.uVX = 0;
    this.offset = 0;
    this.uVY = 0;
    this.uVZ = 0;
    this.uWc = false;
    this.uWa = 536870912;
    this.uWf = new GestureDetector(getContext(), this.uWq);
  }
  
  private void reset()
  {
    init();
    removeAllViewsInLayout();
    requestLayout();
  }
  
  public final void Gq(int paramInt)
  {
    this.uWe.forceFinished(true);
    this.uWe.startScroll(this.uVY, 0, paramInt - this.uVY, 0);
    this.uWo = true;
    requestLayout();
  }
  
  protected final boolean aM(float paramFloat)
  {
    this.uWe.fling(this.uVZ, 0, (int)-paramFloat, 0, 0, this.uWa, 0, 0);
    requestLayout();
    return true;
  }
  
  protected final boolean cAs()
  {
    this.uWe.forceFinished(true);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = this.uWf.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0)
    {
      this.mBn = true;
      if (this.uVV != null) {
        this.uVV.bMM();
      }
    }
    while ((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1)) {
      return bool;
    }
    if (this.uWl)
    {
      if (getChildViewTotalWidth() <= getWidth()) {
        break label182;
      }
      if (this.uVY >= 0) {
        break label134;
      }
      this.uWe.forceFinished(true);
      this.uWe.startScroll(this.uVY, 0, 0 - this.uVY, 0);
      requestLayout();
    }
    for (;;)
    {
      this.mBn = false;
      if (this.uVV == null) {
        break;
      }
      this.uVV.bMN();
      return bool;
      label134:
      if (this.uVY > this.uWa)
      {
        this.uWe.forceFinished(true);
        this.uWe.startScroll(this.uVY, 0, this.uWa - this.uVY, 0);
        requestLayout();
        continue;
        label182:
        if (this.uVY != this.uWn * -1)
        {
          this.uWe.forceFinished(true);
          this.uWe.startScroll(this.uVY, 0, 0 - this.uVY, 0);
          requestLayout();
        }
      }
    }
  }
  
  public ListAdapter getAdapter()
  {
    return this.uWi;
  }
  
  public int getCurrentPosition()
  {
    return this.uVY;
  }
  
  public boolean getIsTouching()
  {
    return this.mBn;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.uWi == null) {
      return;
    }
    this.uWd = true;
    if (this.uWc)
    {
      paramInt1 = this.uVY;
      init();
      removeAllViewsInLayout();
      this.uVZ = paramInt1;
      if (this.uWk)
      {
        this.uWn = Math.max(0, (getWidth() - getChildViewTotalWidth()) / 2);
        this.offset = this.uWn;
      }
      this.uWc = false;
    }
    if (this.uWe.computeScrollOffset()) {
      this.uVZ = this.uWe.getCurrX();
    }
    if (this.uWl) {
      if (getChildViewTotalWidth() > getWidth())
      {
        if (this.uVZ < getWidth() * -1)
        {
          this.uVZ = (getWidth() * -1 + 1);
          this.uWe.forceFinished(true);
        }
        if (this.uVZ > this.uWa + getWidth())
        {
          this.uVZ = (this.uWa + getWidth() - 1);
          this.uWe.forceFinished(true);
        }
      }
    }
    for (;;)
    {
      paramInt2 = this.uVY - this.uVZ;
      localView = getChildAt(0);
      while ((localView != null) && (localView.getRight() + paramInt2 <= 0))
      {
        this.offset += localView.getMeasuredWidth();
        this.uWb.offer(localView);
        removeViewInLayout(localView);
        this.uVW += 1;
        localView = getChildAt(0);
        this.uWd = true;
      }
      if (this.uVZ < getWidth() * -1 + this.uWn)
      {
        this.uVZ = (getWidth() * -1 + this.uWn + 1);
        this.uWe.forceFinished(true);
      }
      if (this.uVZ > getWidth() - this.uWn)
      {
        this.uVZ = (getWidth() - this.uWn - 1);
        this.uWe.forceFinished(true);
        continue;
        if (this.uVZ < 0)
        {
          this.uVZ = 0;
          this.uWe.forceFinished(true);
        }
        if (this.uVZ > this.uWa)
        {
          this.uVZ = this.uWa;
          this.uWe.forceFinished(true);
        }
      }
    }
    View localView = getChildAt(getChildCount() - 1);
    while ((localView != null) && (localView.getLeft() + paramInt2 >= getWidth()))
    {
      this.uWb.offer(localView);
      removeViewInLayout(localView);
      this.uVX -= 1;
      localView = getChildAt(getChildCount() - 1);
      this.uWd = true;
    }
    localView = getChildAt(getChildCount() - 1);
    if (localView != null) {
      paramInt1 = localView.getRight();
    }
    for (;;)
    {
      if ((paramInt1 + paramInt2 < getWidth()) && (this.uVX < this.uWi.getCount()))
      {
        localView = this.uWi.getView(this.uVX, (View)this.uWb.poll(), this);
        T(localView, -1);
        paramInt1 = localView.getMeasuredWidth() + paramInt1;
        if (this.uVX == this.uWi.getCount() - 1) {
          this.uWa = (this.uVY + paramInt1 - getWidth());
        }
        this.uVX += 1;
      }
      else
      {
        localView = getChildAt(0);
        if (localView != null) {
          paramInt1 = localView.getLeft();
        }
        for (;;)
        {
          if ((paramInt1 + paramInt2 > 0) && (this.uVW >= 0))
          {
            localView = this.uWi.getView(this.uVW, (View)this.uWb.poll(), this);
            T(localView, 0);
            paramInt3 = localView.getMeasuredWidth();
            this.uVW -= 1;
            this.offset -= localView.getMeasuredWidth();
            paramInt1 -= paramInt3;
          }
          else
          {
            if ((getChildCount() > 0) && (this.uWd))
            {
              this.offset += paramInt2;
              paramInt2 = this.offset;
              paramInt1 = 0;
              while (paramInt1 < getChildCount())
              {
                localView = getChildAt(paramInt1);
                paramInt3 = localView.getMeasuredWidth();
                localView.layout(paramInt2, 0, paramInt2 + paramInt3, localView.getMeasuredHeight());
                paramInt2 += paramInt3;
                paramInt1 += 1;
              }
            }
            this.uVY = this.uVZ;
            if (!this.uWe.isFinished())
            {
              post(this.uWj);
              return;
            }
            if ((this.uVV == null) || (!this.uWo)) {
              break;
            }
            this.uVV.arA();
            this.uWo = false;
            return;
            paramInt1 = 0;
          }
        }
        paramInt1 = 0;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.uWi != null) && (this.uWi.getCount() > 0))
    {
      View localView = getChildAt(0);
      if (localView != null)
      {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), -2147483648));
        return;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.uWi == null) {
      paramListAdapter.registerDataSetObserver(this.uWp);
    }
    this.uWi = paramListAdapter;
    reset();
  }
  
  public void setCenterInParent(boolean paramBoolean)
  {
    this.uWk = paramBoolean;
  }
  
  public void setHorListLitener(a parama)
  {
    this.uVV = parama;
  }
  
  public void setItemWidth(int paramInt)
  {
    this.uWm = paramInt;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.uWh = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.uWg = paramOnItemSelectedListener;
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.uWl = paramBoolean;
  }
  
  public void setSelection(int paramInt) {}
  
  public static abstract interface a
  {
    public abstract void arA();
    
    public abstract void bMM();
    
    public abstract void bMN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMHorList
 * JD-Core Version:    0.7.0.1
 */