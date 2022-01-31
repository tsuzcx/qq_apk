package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
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

public class HorizontalListView
  extends AdapterView<ListAdapter>
{
  protected Scroller GB;
  protected ListAdapter NK;
  private HorizontalListView.a sgR;
  public boolean uTd = true;
  private int uTe = -1;
  private int uTf = 0;
  protected int uTg;
  protected int uTh;
  private int uTi = 2147483647;
  private int uTj = 0;
  private GestureDetector uTk;
  private Queue<View> uTl = new LinkedList();
  private AdapterView.OnItemSelectedListener uTm;
  private AdapterView.OnItemClickListener uTn;
  private boolean uTo = false;
  private DataSetObserver uTp = new HorizontalListView.1(this);
  private GestureDetector.OnGestureListener uTq = new HorizontalListView.3(this);
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  private void T(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
    }
    addViewInLayout(paramView, paramInt, localLayoutParams1, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
  }
  
  private void initView()
  {
    try
    {
      this.uTe = -1;
      this.uTf = 0;
      this.uTj = 0;
      this.uTg = 0;
      this.uTh = 0;
      this.uTi = 2147483647;
      this.GB = new Scroller(getContext());
      this.uTk = new GestureDetector(getContext(), this.uTq);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void reset()
  {
    try
    {
      initView();
      removeAllViewsInLayout();
      requestLayout();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final boolean aM(float paramFloat)
  {
    try
    {
      this.GB.fling(this.uTh, 0, (int)-paramFloat, 0, 0, this.uTi, 0, 0);
      requestLayout();
      return true;
    }
    finally {}
  }
  
  protected final boolean cAs()
  {
    this.GB.forceFinished(true);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.sgR != null) {
      this.sgR.m(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent) | this.uTk.onTouchEvent(paramMotionEvent);
  }
  
  public ListAdapter getAdapter()
  {
    return this.NK;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      Object localObject1 = this.NK;
      if (localObject1 == null) {
        return;
      }
      if (this.uTo)
      {
        paramInt1 = this.uTg;
        initView();
        removeAllViewsInLayout();
        this.uTh = paramInt1;
        this.uTo = false;
      }
      if (this.GB.computeScrollOffset()) {
        this.uTh = this.GB.getCurrX();
      }
      if (this.uTh <= 0)
      {
        this.uTh = 0;
        this.GB.forceFinished(true);
      }
      if (this.uTh >= this.uTi)
      {
        this.uTh = this.uTi;
        this.GB.forceFinished(true);
      }
      paramInt2 = this.uTg - this.uTh;
      for (localObject1 = getChildAt(0); (localObject1 != null) && (((View)localObject1).getRight() + paramInt2 <= 0); localObject1 = getChildAt(0))
      {
        this.uTj += ((View)localObject1).getMeasuredWidth();
        this.uTl.offer(localObject1);
        removeViewInLayout((View)localObject1);
        this.uTe += 1;
      }
      for (;;)
      {
        localObject1 = getChildAt(getChildCount() - 1);
        if ((localObject1 == null) || (((View)localObject1).getLeft() + paramInt2 < getWidth())) {
          break;
        }
        this.uTl.offer(localObject1);
        removeViewInLayout((View)localObject1);
        this.uTf -= 1;
      }
      localView = getChildAt(getChildCount() - 1);
    }
    finally {}
    View localView;
    if (localView != null)
    {
      paramInt1 = localView.getRight();
      break label658;
      label307:
      while ((paramInt1 + paramInt2 < getWidth()) && (this.uTf < this.NK.getCount()))
      {
        localView = this.NK.getView(this.uTf, (View)this.uTl.poll(), this);
        T(localView, -1);
        paramInt1 = localView.getMeasuredWidth() + paramInt1;
        if (this.uTf == this.NK.getCount() - 1) {
          this.uTi = (this.uTg + paramInt1 - getWidth());
        }
        if (this.uTi < 0) {
          this.uTi = 0;
        }
        this.uTf += 1;
      }
      localView = getChildAt(0);
      if (localView != null)
      {
        paramInt1 = localView.getLeft();
        break label661;
      }
    }
    label658:
    label661:
    for (;;)
    {
      if ((paramInt1 + paramInt2 > 0) && (this.uTe >= 0))
      {
        localView = this.NK.getView(this.uTe, (View)this.uTl.poll(), this);
        T(localView, 0);
        paramInt3 = localView.getMeasuredWidth();
        this.uTe -= 1;
        this.uTj -= localView.getMeasuredWidth();
        paramInt1 -= paramInt3;
      }
      else
      {
        if (getChildCount() > 0)
        {
          this.uTj += paramInt2;
          paramInt2 = this.uTj;
          paramInt1 = i;
          while (paramInt1 < getChildCount())
          {
            localView = getChildAt(paramInt1);
            paramInt3 = localView.getMeasuredWidth();
            localView.layout(paramInt2, 0, paramInt2 + paramInt3, localView.getMeasuredHeight());
            paramInt2 += paramInt3;
            paramInt1 += 1;
          }
        }
        this.uTg = this.uTh;
        if (this.GB.isFinished()) {
          break;
        }
        post(new HorizontalListView.2(this));
        break;
        paramInt1 = 0;
        break label661;
        paramInt1 = 0;
        break label307;
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.NK != null) {
      this.NK.unregisterDataSetObserver(this.uTp);
    }
    this.NK = paramListAdapter;
    this.NK.registerDataSetObserver(this.uTp);
    reset();
  }
  
  public void setDispatchTouchListener(HorizontalListView.a parama)
  {
    this.sgR = parama;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.uTn = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.uTm = paramOnItemSelectedListener;
  }
  
  public void setSelection(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListView
 * JD-Core Version:    0.7.0.1
 */