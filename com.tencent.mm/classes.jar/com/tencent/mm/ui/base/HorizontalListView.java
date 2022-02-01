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
import com.tencent.mm.hellhoundlib.b.b;
import java.util.LinkedList;
import java.util.Queue;

public class HorizontalListView
  extends AdapterView<ListAdapter>
{
  private int adOA;
  private int adOB;
  private GestureDetector adOC;
  private Queue<View> adOD;
  private AdapterView.OnItemSelectedListener adOE;
  private AdapterView.OnItemClickListener adOF;
  private boolean adOG;
  private a adOH;
  private DataSetObserver adOI;
  private GestureDetector.OnGestureListener adOJ;
  public boolean adOv;
  private int adOw;
  private int adOx;
  protected int adOy;
  protected int adOz;
  protected ListAdapter fR;
  protected Scroller mScroller;
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141681);
    this.adOv = true;
    this.adOw = -1;
    this.adOx = 0;
    this.adOA = 2147483647;
    this.adOB = 0;
    this.adOD = new LinkedList();
    this.adOG = false;
    this.adOI = new DataSetObserver()
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
    this.adOJ = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251317);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(251317);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251314);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(251314);
        return bool;
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(141677);
        boolean bool = HorizontalListView.this.jlT();
        AppMethodBeat.o(141677);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(141678);
        boolean bool = HorizontalListView.this.dW(paramAnonymousFloat1);
        AppMethodBeat.o(141678);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251312);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(251312);
      }
      
      public final boolean onScroll(MotionEvent arg1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(141679);
        synchronized (HorizontalListView.this)
        {
          paramAnonymousMotionEvent2 = HorizontalListView.this;
          paramAnonymousMotionEvent2.adOz += (int)paramAnonymousFloat1;
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
              HorizontalListView.c(HorizontalListView.this).onItemClick(HorizontalListView.this, localView, HorizontalListView.d(HorizontalListView.this) + 1 + i, HorizontalListView.this.fR.getItemId(HorizontalListView.d(HorizontalListView.this) + 1 + i));
            }
            if (HorizontalListView.e(HorizontalListView.this) != null) {
              HorizontalListView.e(HorizontalListView.this).onItemSelected(HorizontalListView.this, localView, HorizontalListView.d(HorizontalListView.this) + 1 + i, HorizontalListView.this.fR.getItemId(HorizontalListView.d(HorizontalListView.this) + 1 + i));
            }
          }
          AppMethodBeat.o(141680);
          return true;
          label217:
          i += 1;
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251307);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(251307);
        return bool;
      }
    };
    initView();
    AppMethodBeat.o(141681);
  }
  
  private void bi(View paramView, int paramInt)
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
      this.adOw = -1;
      this.adOx = 0;
      this.adOB = 0;
      this.adOy = 0;
      this.adOz = 0;
      this.adOA = 2147483647;
      this.mScroller = new Scroller(getContext());
      this.adOC = new GestureDetector(getContext(), this.adOJ);
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
  
  protected final boolean dW(float paramFloat)
  {
    AppMethodBeat.i(141688);
    try
    {
      this.mScroller.fling(this.adOz, 0, (int)-paramFloat, 0, 0, this.adOA, 0, 0);
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
    GestureDetector localGestureDetector = this.adOC;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aYi(), "com/tencent/mm/ui/base/HorizontalListView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool2 = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/ui/base/HorizontalListView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(141687);
    return bool2 | bool1;
  }
  
  public ListAdapter getAdapter()
  {
    return this.fR;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected final boolean jlT()
  {
    AppMethodBeat.i(141689);
    this.mScroller.forceFinished(true);
    AppMethodBeat.o(141689);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    try
    {
      AppMethodBeat.i(141686);
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.fR == null)
      {
        AppMethodBeat.o(141686);
        return;
      }
      if (this.adOG)
      {
        paramInt1 = this.adOy;
        initView();
        removeAllViewsInLayout();
        this.adOz = paramInt1;
        this.adOG = false;
      }
      if (this.mScroller.computeScrollOffset()) {
        this.adOz = this.mScroller.getCurrX();
      }
      if (this.adOz <= 0)
      {
        this.adOz = 0;
        this.mScroller.forceFinished(true);
      }
      if (this.adOz >= this.adOA)
      {
        this.adOz = this.adOA;
        this.mScroller.forceFinished(true);
      }
      paramInt2 = this.adOy - this.adOz;
      for (View localView1 = getChildAt(0); (localView1 != null) && (localView1.getRight() + paramInt2 <= 0); localView1 = getChildAt(0))
      {
        this.adOB += localView1.getMeasuredWidth();
        this.adOD.offer(localView1);
        removeViewInLayout(localView1);
        this.adOw += 1;
      }
      for (;;)
      {
        localView1 = getChildAt(getChildCount() - 1);
        if ((localView1 == null) || (localView1.getLeft() + paramInt2 < getWidth())) {
          break;
        }
        this.adOD.offer(localView1);
        removeViewInLayout(localView1);
        this.adOx -= 1;
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
      while ((paramInt1 + paramInt2 < getWidth()) && (this.adOx < this.fR.getCount()))
      {
        localView2 = this.fR.getView(this.adOx, (View)this.adOD.poll(), this);
        bi(localView2, -1);
        paramInt1 = localView2.getMeasuredWidth() + paramInt1;
        if (this.adOx == this.fR.getCount() - 1) {
          this.adOA = (this.adOy + paramInt1 - getWidth());
        }
        if (this.adOA < 0) {
          this.adOA = 0;
        }
        this.adOx += 1;
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
      if ((paramInt1 + paramInt2 > 0) && (this.adOw >= 0))
      {
        localView2 = this.fR.getView(this.adOw, (View)this.adOD.poll(), this);
        bi(localView2, 0);
        paramInt3 = localView2.getMeasuredWidth();
        this.adOw -= 1;
        this.adOB -= localView2.getMeasuredWidth();
        paramInt1 -= paramInt3;
      }
      else
      {
        if (getChildCount() > 0)
        {
          this.adOB += paramInt2;
          paramInt2 = this.adOB;
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
        this.adOy = this.adOz;
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
    if (this.fR != null) {
      this.fR.unregisterDataSetObserver(this.adOI);
    }
    this.fR = paramListAdapter;
    this.fR.registerDataSetObserver(this.adOI);
    reset();
    AppMethodBeat.o(141683);
  }
  
  public void setDispatchTouchListener(a parama)
  {
    this.adOH = parama;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.adOF = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.adOE = paramOnItemSelectedListener;
  }
  
  public void setSelection(int paramInt) {}
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListView
 * JD-Core Version:    0.7.0.1
 */