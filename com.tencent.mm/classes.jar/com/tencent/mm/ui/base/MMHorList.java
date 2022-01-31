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

public class MMHorList
  extends AdapterView<ListAdapter>
{
  private int offset;
  private boolean pbs;
  private AdapterView.OnItemClickListener zkA;
  private ListAdapter zkB;
  private Runnable zkC;
  private boolean zkD;
  private boolean zkE;
  private int zkF;
  private int zkG;
  private boolean zkH;
  private DataSetObserver zkI;
  private GestureDetector.OnGestureListener zkJ;
  private a zko;
  private int zkp;
  private int zkq;
  private int zkr;
  private int zks;
  private int zkt;
  private Queue<View> zku;
  private boolean zkv;
  private boolean zkw;
  protected Scroller zkx;
  private GestureDetector zky;
  private AdapterView.OnItemSelectedListener zkz;
  
  public MMHorList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106662);
    this.zkt = 536870912;
    this.zku = new LinkedList();
    this.zkv = false;
    this.zkw = false;
    this.zkC = new MMHorList.1(this);
    this.zkD = false;
    this.zkE = false;
    this.zkF = 0;
    this.zkG = 0;
    this.pbs = false;
    this.zkH = false;
    this.zkI = new MMHorList.2(this);
    this.zkJ = new MMHorList.3(this);
    init();
    AppMethodBeat.o(106662);
  }
  
  public MMHorList(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106661);
    this.zkt = 536870912;
    this.zku = new LinkedList();
    this.zkv = false;
    this.zkw = false;
    this.zkC = new MMHorList.1(this);
    this.zkD = false;
    this.zkE = false;
    this.zkF = 0;
    this.zkG = 0;
    this.pbs = false;
    this.zkH = false;
    this.zkI = new MMHorList.2(this);
    this.zkJ = new MMHorList.3(this);
    init();
    AppMethodBeat.o(106661);
  }
  
  private void am(View paramView, int paramInt)
  {
    AppMethodBeat.i(106666);
    this.zkw = true;
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
    }
    addViewInLayout(paramView, paramInt, localLayoutParams1, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
    AppMethodBeat.o(106666);
  }
  
  private int getChildViewTotalWidth()
  {
    AppMethodBeat.i(106664);
    int i = this.zkB.getCount();
    int j = this.zkF;
    AppMethodBeat.o(106664);
    return i * j;
  }
  
  private void init()
  {
    AppMethodBeat.i(106660);
    this.zkx = new Scroller(getContext());
    this.zkp = -1;
    this.zkq = 0;
    this.offset = 0;
    this.zkr = 0;
    this.zks = 0;
    this.zkv = false;
    this.zkt = 536870912;
    this.zky = new GestureDetector(getContext(), this.zkJ);
    AppMethodBeat.o(106660);
  }
  
  private void reset()
  {
    AppMethodBeat.i(106672);
    init();
    removeAllViewsInLayout();
    requestLayout();
    AppMethodBeat.o(106672);
  }
  
  public final void OI(int paramInt)
  {
    AppMethodBeat.i(106670);
    this.zkx.forceFinished(true);
    this.zkx.startScroll(this.zkr, 0, paramInt - this.zkr, 0);
    this.zkH = true;
    requestLayout();
    AppMethodBeat.o(106670);
  }
  
  protected final boolean bt(float paramFloat)
  {
    AppMethodBeat.i(106671);
    this.zkx.fling(this.zks, 0, (int)-paramFloat, 0, 0, this.zkt, 0, 0);
    requestLayout();
    AppMethodBeat.o(106671);
    return true;
  }
  
  protected final boolean dDC()
  {
    AppMethodBeat.i(106669);
    this.zkx.forceFinished(true);
    AppMethodBeat.o(106669);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106668);
    boolean bool = this.zky.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0)
    {
      this.pbs = true;
      if (this.zko != null) {
        this.zko.cHQ();
      }
    }
    while ((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1))
    {
      AppMethodBeat.o(106668);
      return bool;
    }
    if (this.zkE)
    {
      if (getChildViewTotalWidth() <= getWidth()) {
        break label193;
      }
      if (this.zkr >= 0) {
        break label145;
      }
      this.zkx.forceFinished(true);
      this.zkx.startScroll(this.zkr, 0, 0 - this.zkr, 0);
      requestLayout();
    }
    for (;;)
    {
      this.pbs = false;
      if (this.zko == null) {
        break;
      }
      this.zko.crx();
      break;
      label145:
      if (this.zkr > this.zkt)
      {
        this.zkx.forceFinished(true);
        this.zkx.startScroll(this.zkr, 0, this.zkt - this.zkr, 0);
        requestLayout();
        continue;
        label193:
        if (this.zkr != this.zkG * -1)
        {
          this.zkx.forceFinished(true);
          this.zkx.startScroll(this.zkr, 0, 0 - this.zkr, 0);
          requestLayout();
        }
      }
    }
  }
  
  public ListAdapter getAdapter()
  {
    return this.zkB;
  }
  
  public int getCurrentPosition()
  {
    return this.zkr;
  }
  
  public boolean getIsTouching()
  {
    return this.pbs;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106665);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.zkB == null)
    {
      AppMethodBeat.o(106665);
      return;
    }
    this.zkw = true;
    if (this.zkv)
    {
      paramInt1 = this.zkr;
      init();
      removeAllViewsInLayout();
      this.zks = paramInt1;
      if (this.zkD)
      {
        this.zkG = Math.max(0, (getWidth() - getChildViewTotalWidth()) / 2);
        this.offset = this.zkG;
      }
      this.zkv = false;
    }
    if (this.zkx.computeScrollOffset()) {
      this.zks = this.zkx.getCurrX();
    }
    if (this.zkE) {
      if (getChildViewTotalWidth() > getWidth())
      {
        if (this.zks < getWidth() * -1)
        {
          this.zks = (getWidth() * -1 + 1);
          this.zkx.forceFinished(true);
        }
        if (this.zks > this.zkt + getWidth())
        {
          this.zks = (this.zkt + getWidth() - 1);
          this.zkx.forceFinished(true);
        }
      }
    }
    for (;;)
    {
      paramInt2 = this.zkr - this.zks;
      localView = getChildAt(0);
      while ((localView != null) && (localView.getRight() + paramInt2 <= 0))
      {
        this.offset += localView.getMeasuredWidth();
        this.zku.offer(localView);
        removeViewInLayout(localView);
        this.zkp += 1;
        localView = getChildAt(0);
        this.zkw = true;
      }
      if (this.zks < getWidth() * -1 + this.zkG)
      {
        this.zks = (getWidth() * -1 + this.zkG + 1);
        this.zkx.forceFinished(true);
      }
      if (this.zks > getWidth() - this.zkG)
      {
        this.zks = (getWidth() - this.zkG - 1);
        this.zkx.forceFinished(true);
        continue;
        if (this.zks < 0)
        {
          this.zks = 0;
          this.zkx.forceFinished(true);
        }
        if (this.zks > this.zkt)
        {
          this.zks = this.zkt;
          this.zkx.forceFinished(true);
        }
      }
    }
    View localView = getChildAt(getChildCount() - 1);
    while ((localView != null) && (localView.getLeft() + paramInt2 >= getWidth()))
    {
      this.zku.offer(localView);
      removeViewInLayout(localView);
      this.zkq -= 1;
      localView = getChildAt(getChildCount() - 1);
      this.zkw = true;
    }
    localView = getChildAt(getChildCount() - 1);
    if (localView != null) {
      paramInt1 = localView.getRight();
    }
    for (;;)
    {
      if ((paramInt1 + paramInt2 < getWidth()) && (this.zkq < this.zkB.getCount()))
      {
        localView = this.zkB.getView(this.zkq, (View)this.zku.poll(), this);
        am(localView, -1);
        paramInt1 = localView.getMeasuredWidth() + paramInt1;
        if (this.zkq == this.zkB.getCount() - 1) {
          this.zkt = (this.zkr + paramInt1 - getWidth());
        }
        this.zkq += 1;
      }
      else
      {
        localView = getChildAt(0);
        if (localView != null) {
          paramInt1 = localView.getLeft();
        }
        for (;;)
        {
          if ((paramInt1 + paramInt2 > 0) && (this.zkp >= 0))
          {
            localView = this.zkB.getView(this.zkp, (View)this.zku.poll(), this);
            am(localView, 0);
            paramInt3 = localView.getMeasuredWidth();
            this.zkp -= 1;
            this.offset -= localView.getMeasuredWidth();
            paramInt1 -= paramInt3;
          }
          else
          {
            if ((getChildCount() > 0) && (this.zkw))
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
            this.zkr = this.zks;
            if (!this.zkx.isFinished())
            {
              post(this.zkC);
              AppMethodBeat.o(106665);
              return;
            }
            if ((this.zko != null) && (this.zkH))
            {
              this.zko.aQl();
              this.zkH = false;
            }
            AppMethodBeat.o(106665);
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
    AppMethodBeat.i(106667);
    if ((this.zkB != null) && (this.zkB.getCount() > 0))
    {
      View localView = getChildAt(0);
      if (localView != null)
      {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), -2147483648));
        AppMethodBeat.o(106667);
        return;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(106667);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(106663);
    if (this.zkB == null) {
      paramListAdapter.registerDataSetObserver(this.zkI);
    }
    this.zkB = paramListAdapter;
    reset();
    AppMethodBeat.o(106663);
  }
  
  public void setCenterInParent(boolean paramBoolean)
  {
    this.zkD = paramBoolean;
  }
  
  public void setHorListLitener(a parama)
  {
    this.zko = parama;
  }
  
  public void setItemWidth(int paramInt)
  {
    this.zkF = paramInt;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.zkA = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.zkz = paramOnItemSelectedListener;
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.zkE = paramBoolean;
  }
  
  public void setSelection(int paramInt) {}
  
  public static abstract interface a
  {
    public abstract void aQl();
    
    public abstract void cHQ();
    
    public abstract void crx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMHorList
 * JD-Core Version:    0.7.0.1
 */