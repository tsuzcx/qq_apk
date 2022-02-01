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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

public class HorizontalListView
  extends AdapterView<ListAdapter>
{
  protected ListAdapter EN;
  public boolean HuV;
  private int HuW;
  private int HuX;
  protected int HuY;
  protected int HuZ;
  private int Hva;
  private int Hvb;
  private GestureDetector Hvc;
  private Queue<View> Hvd;
  private AdapterView.OnItemSelectedListener Hve;
  private AdapterView.OnItemClickListener Hvf;
  private boolean Hvg;
  private a Hvh;
  private DataSetObserver Hvi;
  private GestureDetector.OnGestureListener Hvj;
  protected Scroller mScroller;
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141681);
    this.HuV = true;
    this.HuW = -1;
    this.HuX = 0;
    this.Hva = 2147483647;
    this.Hvb = 0;
    this.Hvd = new LinkedList();
    this.Hvg = false;
    this.Hvi = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(141674);
        synchronized (HorizontalListView.this)
        {
          HorizontalListView.a(HorizontalListView.this);
          HorizontalListView.this.invalidate();
          HorizontalListView.this.requestLayout();
          AppMethodBeat.o(141674);
          return;
        }
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(141675);
        HorizontalListView.b(HorizontalListView.this);
        HorizontalListView.this.invalidate();
        HorizontalListView.this.requestLayout();
        AppMethodBeat.o(141675);
      }
    };
    this.Hvj = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(141677);
        boolean bool = HorizontalListView.this.fic();
        AppMethodBeat.o(141677);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(141678);
        boolean bool = HorizontalListView.this.bM(paramAnonymousFloat1);
        AppMethodBeat.o(141678);
        return bool;
      }
      
      public final boolean onScroll(MotionEvent arg1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(141679);
        synchronized (HorizontalListView.this)
        {
          paramAnonymousMotionEvent2 = HorizontalListView.this;
          paramAnonymousMotionEvent2.HuZ += (int)paramAnonymousFloat1;
          HorizontalListView.this.requestLayout();
          AppMethodBeat.o(141679);
          return true;
        }
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(141680);
        Rect localRect = new Rect();
        int i = 0;
        for (;;)
        {
          if (i < HorizontalListView.this.getChildCount())
          {
            View localView = HorizontalListView.this.getChildAt(i);
            int j = localView.getLeft();
            int k = localView.getRight();
            localRect.set(j, localView.getTop(), k, localView.getBottom());
            if (!localRect.contains((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY())) {
              break label217;
            }
            if (HorizontalListView.c(HorizontalListView.this) != null) {
              HorizontalListView.c(HorizontalListView.this).onItemClick(HorizontalListView.this, localView, HorizontalListView.d(HorizontalListView.this) + 1 + i, HorizontalListView.this.EN.getItemId(HorizontalListView.d(HorizontalListView.this) + 1 + i));
            }
            if (HorizontalListView.e(HorizontalListView.this) != null) {
              HorizontalListView.e(HorizontalListView.this).onItemSelected(HorizontalListView.this, localView, HorizontalListView.d(HorizontalListView.this) + 1 + i, HorizontalListView.this.EN.getItemId(HorizontalListView.d(HorizontalListView.this) + 1 + i));
            }
          }
          AppMethodBeat.o(141680);
          return true;
          label217:
          i += 1;
        }
      }
    };
    initView();
    AppMethodBeat.o(141681);
  }
  
  private void az(View paramView, int paramInt)
  {
    AppMethodBeat.i(141685);
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
    }
    addViewInLayout(paramView, paramInt, localLayoutParams1, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
    AppMethodBeat.o(141685);
  }
  
  private void initView()
  {
    try
    {
      AppMethodBeat.i(141682);
      this.HuW = -1;
      this.HuX = 0;
      this.Hvb = 0;
      this.HuY = 0;
      this.HuZ = 0;
      this.Hva = 2147483647;
      this.mScroller = new Scroller(getContext());
      this.Hvc = new GestureDetector(getContext(), this.Hvj);
      AppMethodBeat.o(141682);
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
      AppMethodBeat.i(141684);
      initView();
      removeAllViewsInLayout();
      requestLayout();
      AppMethodBeat.o(141684);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(141688);
    try
    {
      this.mScroller.fling(this.HuZ, 0, (int)-paramFloat, 0, 0, this.Hva, 0, 0);
      requestLayout();
      AppMethodBeat.o(141688);
      return true;
    }
    finally
    {
      AppMethodBeat.o(141688);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141687);
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    boolean bool2 = this.Hvc.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(141687);
    return bool1 | bool2;
  }
  
  protected final boolean fic()
  {
    AppMethodBeat.i(141689);
    this.mScroller.forceFinished(true);
    AppMethodBeat.o(141689);
    return true;
  }
  
  public ListAdapter getAdapter()
  {
    return this.EN;
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
      AppMethodBeat.i(141686);
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.EN == null)
      {
        AppMethodBeat.o(141686);
        return;
      }
      if (this.Hvg)
      {
        paramInt1 = this.HuY;
        initView();
        removeAllViewsInLayout();
        this.HuZ = paramInt1;
        this.Hvg = false;
      }
      if (this.mScroller.computeScrollOffset()) {
        this.HuZ = this.mScroller.getCurrX();
      }
      if (this.HuZ <= 0)
      {
        this.HuZ = 0;
        this.mScroller.forceFinished(true);
      }
      if (this.HuZ >= this.Hva)
      {
        this.HuZ = this.Hva;
        this.mScroller.forceFinished(true);
      }
      paramInt2 = this.HuY - this.HuZ;
      for (View localView1 = getChildAt(0); (localView1 != null) && (localView1.getRight() + paramInt2 <= 0); localView1 = getChildAt(0))
      {
        this.Hvb += localView1.getMeasuredWidth();
        this.Hvd.offer(localView1);
        removeViewInLayout(localView1);
        this.HuW += 1;
      }
      for (;;)
      {
        localView1 = getChildAt(getChildCount() - 1);
        if ((localView1 == null) || (localView1.getLeft() + paramInt2 < getWidth())) {
          break;
        }
        this.Hvd.offer(localView1);
        removeViewInLayout(localView1);
        this.HuX -= 1;
      }
      localView2 = getChildAt(getChildCount() - 1);
    }
    finally {}
    View localView2;
    if (localView2 != null)
    {
      paramInt1 = localView2.getRight();
      break label669;
      label313:
      while ((paramInt1 + paramInt2 < getWidth()) && (this.HuX < this.EN.getCount()))
      {
        localView2 = this.EN.getView(this.HuX, (View)this.Hvd.poll(), this);
        az(localView2, -1);
        paramInt1 = localView2.getMeasuredWidth() + paramInt1;
        if (this.HuX == this.EN.getCount() - 1) {
          this.Hva = (this.HuY + paramInt1 - getWidth());
        }
        if (this.Hva < 0) {
          this.Hva = 0;
        }
        this.HuX += 1;
      }
      localView2 = getChildAt(0);
      if (localView2 != null)
      {
        paramInt1 = localView2.getLeft();
        break label672;
      }
    }
    label669:
    label672:
    for (;;)
    {
      if ((paramInt1 + paramInt2 > 0) && (this.HuW >= 0))
      {
        localView2 = this.EN.getView(this.HuW, (View)this.Hvd.poll(), this);
        az(localView2, 0);
        paramInt3 = localView2.getMeasuredWidth();
        this.HuW -= 1;
        this.Hvb -= localView2.getMeasuredWidth();
        paramInt1 -= paramInt3;
      }
      else
      {
        if (getChildCount() > 0)
        {
          this.Hvb += paramInt2;
          paramInt2 = this.Hvb;
          paramInt1 = i;
          while (paramInt1 < getChildCount())
          {
            localView2 = getChildAt(paramInt1);
            paramInt3 = localView2.getMeasuredWidth();
            localView2.layout(paramInt2, 0, paramInt2 + paramInt3, localView2.getMeasuredHeight());
            paramInt2 += paramInt3;
            paramInt1 += 1;
          }
        }
        this.HuY = this.HuZ;
        if (!this.mScroller.isFinished()) {
          post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(141676);
              HorizontalListView.this.requestLayout();
              AppMethodBeat.o(141676);
            }
          });
        }
        AppMethodBeat.o(141686);
        break;
        paramInt1 = 0;
        break label672;
        paramInt1 = 0;
        break label313;
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(141683);
    if (this.EN != null) {
      this.EN.unregisterDataSetObserver(this.Hvi);
    }
    this.EN = paramListAdapter;
    this.EN.registerDataSetObserver(this.Hvi);
    reset();
    AppMethodBeat.o(141683);
  }
  
  public void setDispatchTouchListener(a parama)
  {
    this.Hvh = parama;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.Hvf = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.Hve = paramOnItemSelectedListener;
  }
  
  public void setSelection(int paramInt) {}
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListView
 * JD-Core Version:    0.7.0.1
 */