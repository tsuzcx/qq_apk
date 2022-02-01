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
  protected ListAdapter GE;
  public boolean JiL;
  private int JiM;
  private int JiN;
  protected int JiO;
  protected int JiP;
  private int JiQ;
  private int JiR;
  private GestureDetector JiS;
  private Queue<View> JiT;
  private AdapterView.OnItemSelectedListener JiU;
  private AdapterView.OnItemClickListener JiV;
  private boolean JiW;
  private a JiX;
  private DataSetObserver JiY;
  private GestureDetector.OnGestureListener JiZ;
  protected Scroller mScroller;
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141681);
    this.JiL = true;
    this.JiM = -1;
    this.JiN = 0;
    this.JiQ = 2147483647;
    this.JiR = 0;
    this.JiT = new LinkedList();
    this.JiW = false;
    this.JiY = new DataSetObserver()
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
    this.JiZ = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186459);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186459);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186458);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186458);
        return bool;
      }
      
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(141677);
        boolean bool = HorizontalListView.this.fyr();
        AppMethodBeat.o(141677);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(141678);
        boolean bool = HorizontalListView.this.bR(paramAnonymousFloat1);
        AppMethodBeat.o(141678);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186457);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(186457);
      }
      
      public final boolean onScroll(MotionEvent arg1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(141679);
        synchronized (HorizontalListView.this)
        {
          paramAnonymousMotionEvent2 = HorizontalListView.this;
          paramAnonymousMotionEvent2.JiP += (int)paramAnonymousFloat1;
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
              HorizontalListView.c(HorizontalListView.this).onItemClick(HorizontalListView.this, localView, HorizontalListView.d(HorizontalListView.this) + 1 + i, HorizontalListView.this.GE.getItemId(HorizontalListView.d(HorizontalListView.this) + 1 + i));
            }
            if (HorizontalListView.e(HorizontalListView.this) != null) {
              HorizontalListView.e(HorizontalListView.this).onItemSelected(HorizontalListView.this, localView, HorizontalListView.d(HorizontalListView.this) + 1 + i, HorizontalListView.this.GE.getItemId(HorizontalListView.d(HorizontalListView.this) + 1 + i));
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
        AppMethodBeat.i(186456);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186456);
        return bool;
      }
    };
    initView();
    AppMethodBeat.o(141681);
  }
  
  private void aB(View paramView, int paramInt)
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
      this.JiM = -1;
      this.JiN = 0;
      this.JiR = 0;
      this.JiO = 0;
      this.JiP = 0;
      this.JiQ = 2147483647;
      this.mScroller = new Scroller(getContext());
      this.JiS = new GestureDetector(getContext(), this.JiZ);
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
  
  protected final boolean bR(float paramFloat)
  {
    AppMethodBeat.i(141688);
    try
    {
      this.mScroller.fling(this.JiP, 0, (int)-paramFloat, 0, 0, this.JiQ, 0, 0);
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
    GestureDetector localGestureDetector = this.JiS;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, paramMotionEvent.ahp(), "com/tencent/mm/ui/base/HorizontalListView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool2 = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.mq(0)), "com/tencent/mm/ui/base/HorizontalListView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(141687);
    return bool2 | bool1;
  }
  
  protected final boolean fyr()
  {
    AppMethodBeat.i(141689);
    this.mScroller.forceFinished(true);
    AppMethodBeat.o(141689);
    return true;
  }
  
  public ListAdapter getAdapter()
  {
    return this.GE;
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
      if (this.GE == null)
      {
        AppMethodBeat.o(141686);
        return;
      }
      if (this.JiW)
      {
        paramInt1 = this.JiO;
        initView();
        removeAllViewsInLayout();
        this.JiP = paramInt1;
        this.JiW = false;
      }
      if (this.mScroller.computeScrollOffset()) {
        this.JiP = this.mScroller.getCurrX();
      }
      if (this.JiP <= 0)
      {
        this.JiP = 0;
        this.mScroller.forceFinished(true);
      }
      if (this.JiP >= this.JiQ)
      {
        this.JiP = this.JiQ;
        this.mScroller.forceFinished(true);
      }
      paramInt2 = this.JiO - this.JiP;
      for (View localView1 = getChildAt(0); (localView1 != null) && (localView1.getRight() + paramInt2 <= 0); localView1 = getChildAt(0))
      {
        this.JiR += localView1.getMeasuredWidth();
        this.JiT.offer(localView1);
        removeViewInLayout(localView1);
        this.JiM += 1;
      }
      for (;;)
      {
        localView1 = getChildAt(getChildCount() - 1);
        if ((localView1 == null) || (localView1.getLeft() + paramInt2 < getWidth())) {
          break;
        }
        this.JiT.offer(localView1);
        removeViewInLayout(localView1);
        this.JiN -= 1;
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
      while ((paramInt1 + paramInt2 < getWidth()) && (this.JiN < this.GE.getCount()))
      {
        localView2 = this.GE.getView(this.JiN, (View)this.JiT.poll(), this);
        aB(localView2, -1);
        paramInt1 = localView2.getMeasuredWidth() + paramInt1;
        if (this.JiN == this.GE.getCount() - 1) {
          this.JiQ = (this.JiO + paramInt1 - getWidth());
        }
        if (this.JiQ < 0) {
          this.JiQ = 0;
        }
        this.JiN += 1;
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
      if ((paramInt1 + paramInt2 > 0) && (this.JiM >= 0))
      {
        localView2 = this.GE.getView(this.JiM, (View)this.JiT.poll(), this);
        aB(localView2, 0);
        paramInt3 = localView2.getMeasuredWidth();
        this.JiM -= 1;
        this.JiR -= localView2.getMeasuredWidth();
        paramInt1 -= paramInt3;
      }
      else
      {
        if (getChildCount() > 0)
        {
          this.JiR += paramInt2;
          paramInt2 = this.JiR;
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
        this.JiO = this.JiP;
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
    if (this.GE != null) {
      this.GE.unregisterDataSetObserver(this.JiY);
    }
    this.GE = paramListAdapter;
    this.GE.registerDataSetObserver(this.JiY);
    reset();
    AppMethodBeat.o(141683);
  }
  
  public void setDispatchTouchListener(a parama)
  {
    this.JiX = parama;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.JiV = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.JiU = paramOnItemSelectedListener;
  }
  
  public void setSelection(int paramInt) {}
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListView
 * JD-Core Version:    0.7.0.1
 */