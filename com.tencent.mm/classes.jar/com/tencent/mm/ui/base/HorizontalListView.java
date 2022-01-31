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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

public class HorizontalListView
  extends AdapterView<ListAdapter>
{
  protected Scroller mScroller;
  private HorizontalListView.a vZk;
  protected ListAdapter xw;
  public boolean zhD;
  private int zhE;
  private int zhF;
  protected int zhG;
  protected int zhH;
  private int zhI;
  private int zhJ;
  private GestureDetector zhK;
  private Queue<View> zhL;
  private AdapterView.OnItemSelectedListener zhM;
  private AdapterView.OnItemClickListener zhN;
  private boolean zhO;
  private DataSetObserver zhP;
  private GestureDetector.OnGestureListener zhQ;
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106316);
    this.zhD = true;
    this.zhE = -1;
    this.zhF = 0;
    this.zhI = 2147483647;
    this.zhJ = 0;
    this.zhL = new LinkedList();
    this.zhO = false;
    this.zhP = new HorizontalListView.1(this);
    this.zhQ = new HorizontalListView.3(this);
    initView();
    AppMethodBeat.o(106316);
  }
  
  private void am(View paramView, int paramInt)
  {
    AppMethodBeat.i(106320);
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
    }
    addViewInLayout(paramView, paramInt, localLayoutParams1, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
    AppMethodBeat.o(106320);
  }
  
  private void initView()
  {
    try
    {
      AppMethodBeat.i(106317);
      this.zhE = -1;
      this.zhF = 0;
      this.zhJ = 0;
      this.zhG = 0;
      this.zhH = 0;
      this.zhI = 2147483647;
      this.mScroller = new Scroller(getContext());
      this.zhK = new GestureDetector(getContext(), this.zhQ);
      AppMethodBeat.o(106317);
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
      AppMethodBeat.i(106319);
      initView();
      removeAllViewsInLayout();
      requestLayout();
      AppMethodBeat.o(106319);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final boolean bt(float paramFloat)
  {
    AppMethodBeat.i(106323);
    try
    {
      this.mScroller.fling(this.zhH, 0, (int)-paramFloat, 0, 0, this.zhI, 0, 0);
      requestLayout();
      AppMethodBeat.o(106323);
      return true;
    }
    finally
    {
      AppMethodBeat.o(106323);
    }
  }
  
  protected final boolean dDC()
  {
    AppMethodBeat.i(106324);
    this.mScroller.forceFinished(true);
    AppMethodBeat.o(106324);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106322);
    if (this.vZk != null) {
      this.vZk.o(paramMotionEvent);
    }
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    boolean bool2 = this.zhK.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(106322);
    return bool1 | bool2;
  }
  
  public ListAdapter getAdapter()
  {
    return this.xw;
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
      AppMethodBeat.i(106321);
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.xw == null)
      {
        AppMethodBeat.o(106321);
        return;
      }
      if (this.zhO)
      {
        paramInt1 = this.zhG;
        initView();
        removeAllViewsInLayout();
        this.zhH = paramInt1;
        this.zhO = false;
      }
      if (this.mScroller.computeScrollOffset()) {
        this.zhH = this.mScroller.getCurrX();
      }
      if (this.zhH <= 0)
      {
        this.zhH = 0;
        this.mScroller.forceFinished(true);
      }
      if (this.zhH >= this.zhI)
      {
        this.zhH = this.zhI;
        this.mScroller.forceFinished(true);
      }
      paramInt2 = this.zhG - this.zhH;
      for (View localView1 = getChildAt(0); (localView1 != null) && (localView1.getRight() + paramInt2 <= 0); localView1 = getChildAt(0))
      {
        this.zhJ += localView1.getMeasuredWidth();
        this.zhL.offer(localView1);
        removeViewInLayout(localView1);
        this.zhE += 1;
      }
      for (;;)
      {
        localView1 = getChildAt(getChildCount() - 1);
        if ((localView1 == null) || (localView1.getLeft() + paramInt2 < getWidth())) {
          break;
        }
        this.zhL.offer(localView1);
        removeViewInLayout(localView1);
        this.zhF -= 1;
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
      while ((paramInt1 + paramInt2 < getWidth()) && (this.zhF < this.xw.getCount()))
      {
        localView2 = this.xw.getView(this.zhF, (View)this.zhL.poll(), this);
        am(localView2, -1);
        paramInt1 = localView2.getMeasuredWidth() + paramInt1;
        if (this.zhF == this.xw.getCount() - 1) {
          this.zhI = (this.zhG + paramInt1 - getWidth());
        }
        if (this.zhI < 0) {
          this.zhI = 0;
        }
        this.zhF += 1;
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
      if ((paramInt1 + paramInt2 > 0) && (this.zhE >= 0))
      {
        localView2 = this.xw.getView(this.zhE, (View)this.zhL.poll(), this);
        am(localView2, 0);
        paramInt3 = localView2.getMeasuredWidth();
        this.zhE -= 1;
        this.zhJ -= localView2.getMeasuredWidth();
        paramInt1 -= paramInt3;
      }
      else
      {
        if (getChildCount() > 0)
        {
          this.zhJ += paramInt2;
          paramInt2 = this.zhJ;
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
        this.zhG = this.zhH;
        if (!this.mScroller.isFinished()) {
          post(new HorizontalListView.2(this));
        }
        AppMethodBeat.o(106321);
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
    AppMethodBeat.i(106318);
    if (this.xw != null) {
      this.xw.unregisterDataSetObserver(this.zhP);
    }
    this.xw = paramListAdapter;
    this.xw.registerDataSetObserver(this.zhP);
    reset();
    AppMethodBeat.o(106318);
  }
  
  public void setDispatchTouchListener(HorizontalListView.a parama)
  {
    this.vZk = parama;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.zhN = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.zhM = paramOnItemSelectedListener;
  }
  
  public void setSelection(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListView
 * JD-Core Version:    0.7.0.1
 */