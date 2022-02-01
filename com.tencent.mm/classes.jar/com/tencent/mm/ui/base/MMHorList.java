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

public class MMHorList
  extends AdapterView<ListAdapter>
{
  private a FXM;
  private int FXN;
  private int FXO;
  private int FXP;
  private int FXQ;
  private Queue<View> FXR;
  private boolean FXS;
  private boolean FXT;
  protected Scroller FXU;
  private GestureDetector FXV;
  private AdapterView.OnItemSelectedListener FXW;
  private AdapterView.OnItemClickListener FXX;
  private ListAdapter FXY;
  private Runnable FXZ;
  private boolean FYa;
  private boolean FYb;
  private int FYc;
  private int FYd;
  private boolean FYe;
  private DataSetObserver FYf;
  private GestureDetector.OnGestureListener FYg;
  private int nlj;
  private int offset;
  private boolean tYG;
  
  public MMHorList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142011);
    this.FXQ = 536870912;
    this.FXR = new LinkedList();
    this.FXS = false;
    this.FXT = false;
    this.FXZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142002);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142002);
      }
    };
    this.FYa = false;
    this.FYb = false;
    this.FYc = 0;
    this.FYd = 0;
    this.tYG = false;
    this.FYe = false;
    this.FYf = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(142003);
        MMHorList.a(MMHorList.this);
        MMHorList.this.invalidate();
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142003);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(142004);
        MMHorList.b(MMHorList.this);
        MMHorList.this.invalidate();
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142004);
      }
    };
    this.FYg = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142005);
        boolean bool = MMHorList.this.eSs();
        AppMethodBeat.o(142005);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142006);
        boolean bool = MMHorList.this.bE(paramAnonymousFloat1);
        AppMethodBeat.o(142006);
        return bool;
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142007);
        MMHorList.a(MMHorList.this, MMHorList.c(MMHorList.this) + (int)paramAnonymousFloat1);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142007);
        return true;
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142008);
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
              break label217;
            }
            if (MMHorList.d(MMHorList.this) != null) {
              MMHorList.d(MMHorList.this).onItemClick(MMHorList.this, localView, MMHorList.e(MMHorList.this) + 1 + i, MMHorList.f(MMHorList.this).getItemId(MMHorList.e(MMHorList.this) + 1 + i));
            }
            if (MMHorList.g(MMHorList.this) != null) {
              MMHorList.g(MMHorList.this).onItemSelected(MMHorList.this, localView, MMHorList.e(MMHorList.this) + 1 + i, MMHorList.f(MMHorList.this).getItemId(MMHorList.e(MMHorList.this) + 1 + i));
            }
          }
          AppMethodBeat.o(142008);
          return true;
          label217:
          i += 1;
        }
      }
    };
    init();
    AppMethodBeat.o(142011);
  }
  
  public MMHorList(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142010);
    this.FXQ = 536870912;
    this.FXR = new LinkedList();
    this.FXS = false;
    this.FXT = false;
    this.FXZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142002);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142002);
      }
    };
    this.FYa = false;
    this.FYb = false;
    this.FYc = 0;
    this.FYd = 0;
    this.tYG = false;
    this.FYe = false;
    this.FYf = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(142003);
        MMHorList.a(MMHorList.this);
        MMHorList.this.invalidate();
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142003);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(142004);
        MMHorList.b(MMHorList.this);
        MMHorList.this.invalidate();
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142004);
      }
    };
    this.FYg = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142005);
        boolean bool = MMHorList.this.eSs();
        AppMethodBeat.o(142005);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142006);
        boolean bool = MMHorList.this.bE(paramAnonymousFloat1);
        AppMethodBeat.o(142006);
        return bool;
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142007);
        MMHorList.a(MMHorList.this, MMHorList.c(MMHorList.this) + (int)paramAnonymousFloat1);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142007);
        return true;
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142008);
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
              break label217;
            }
            if (MMHorList.d(MMHorList.this) != null) {
              MMHorList.d(MMHorList.this).onItemClick(MMHorList.this, localView, MMHorList.e(MMHorList.this) + 1 + i, MMHorList.f(MMHorList.this).getItemId(MMHorList.e(MMHorList.this) + 1 + i));
            }
            if (MMHorList.g(MMHorList.this) != null) {
              MMHorList.g(MMHorList.this).onItemSelected(MMHorList.this, localView, MMHorList.e(MMHorList.this) + 1 + i, MMHorList.f(MMHorList.this).getItemId(MMHorList.e(MMHorList.this) + 1 + i));
            }
          }
          AppMethodBeat.o(142008);
          return true;
          label217:
          i += 1;
        }
      }
    };
    init();
    AppMethodBeat.o(142010);
  }
  
  private void ax(View paramView, int paramInt)
  {
    AppMethodBeat.i(142015);
    this.FXT = true;
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
    }
    addViewInLayout(paramView, paramInt, localLayoutParams1, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(getHeight(), -2147483648));
    AppMethodBeat.o(142015);
  }
  
  private int getChildViewTotalWidth()
  {
    AppMethodBeat.i(142013);
    int i = this.FXY.getCount();
    int j = this.FYc;
    AppMethodBeat.o(142013);
    return i * j;
  }
  
  private void init()
  {
    AppMethodBeat.i(142009);
    this.FXU = new Scroller(getContext());
    this.FXN = -1;
    this.FXO = 0;
    this.offset = 0;
    this.nlj = 0;
    this.FXP = 0;
    this.FXS = false;
    this.FXQ = 536870912;
    this.FXV = new GestureDetector(getContext(), this.FYg);
    AppMethodBeat.o(142009);
  }
  
  private void reset()
  {
    AppMethodBeat.i(142021);
    init();
    removeAllViewsInLayout();
    requestLayout();
    AppMethodBeat.o(142021);
  }
  
  public final void XO(int paramInt)
  {
    AppMethodBeat.i(142019);
    this.FXU.forceFinished(true);
    this.FXU.startScroll(this.nlj, 0, paramInt - this.nlj, 0);
    this.FYe = true;
    requestLayout();
    AppMethodBeat.o(142019);
  }
  
  protected final boolean bE(float paramFloat)
  {
    AppMethodBeat.i(142020);
    this.FXU.fling(this.FXP, 0, (int)-paramFloat, 0, 0, this.FXQ, 0, 0);
    requestLayout();
    AppMethodBeat.o(142020);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142017);
    boolean bool = this.FXV.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0)
    {
      this.tYG = true;
      if (this.FXM != null) {
        this.FXM.dNj();
      }
    }
    while ((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1))
    {
      AppMethodBeat.o(142017);
      return bool;
    }
    if (this.FYb)
    {
      if (getChildViewTotalWidth() <= getWidth()) {
        break label193;
      }
      if (this.nlj >= 0) {
        break label145;
      }
      this.FXU.forceFinished(true);
      this.FXU.startScroll(this.nlj, 0, 0 - this.nlj, 0);
      requestLayout();
    }
    for (;;)
    {
      this.tYG = false;
      if (this.FXM == null) {
        break;
      }
      this.FXM.dwD();
      break;
      label145:
      if (this.nlj > this.FXQ)
      {
        this.FXU.forceFinished(true);
        this.FXU.startScroll(this.nlj, 0, this.FXQ - this.nlj, 0);
        requestLayout();
        continue;
        label193:
        if (this.nlj != this.FYd * -1)
        {
          this.FXU.forceFinished(true);
          this.FXU.startScroll(this.nlj, 0, 0 - this.nlj, 0);
          requestLayout();
        }
      }
    }
  }
  
  protected final boolean eSs()
  {
    AppMethodBeat.i(142018);
    this.FXU.forceFinished(true);
    AppMethodBeat.o(142018);
    return true;
  }
  
  public ListAdapter getAdapter()
  {
    return this.FXY;
  }
  
  public int getCurrentPosition()
  {
    return this.nlj;
  }
  
  public boolean getIsTouching()
  {
    return this.tYG;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142014);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.FXY == null)
    {
      AppMethodBeat.o(142014);
      return;
    }
    this.FXT = true;
    if (this.FXS)
    {
      paramInt1 = this.nlj;
      init();
      removeAllViewsInLayout();
      this.FXP = paramInt1;
      if (this.FYa)
      {
        this.FYd = Math.max(0, (getWidth() - getChildViewTotalWidth()) / 2);
        this.offset = this.FYd;
      }
      this.FXS = false;
    }
    if (this.FXU.computeScrollOffset()) {
      this.FXP = this.FXU.getCurrX();
    }
    if (this.FYb) {
      if (getChildViewTotalWidth() > getWidth())
      {
        if (this.FXP < getWidth() * -1)
        {
          this.FXP = (getWidth() * -1 + 1);
          this.FXU.forceFinished(true);
        }
        if (this.FXP > this.FXQ + getWidth())
        {
          this.FXP = (this.FXQ + getWidth() - 1);
          this.FXU.forceFinished(true);
        }
      }
    }
    for (;;)
    {
      paramInt2 = this.nlj - this.FXP;
      localView = getChildAt(0);
      while ((localView != null) && (localView.getRight() + paramInt2 <= 0))
      {
        this.offset += localView.getMeasuredWidth();
        this.FXR.offer(localView);
        removeViewInLayout(localView);
        this.FXN += 1;
        localView = getChildAt(0);
        this.FXT = true;
      }
      if (this.FXP < getWidth() * -1 + this.FYd)
      {
        this.FXP = (getWidth() * -1 + this.FYd + 1);
        this.FXU.forceFinished(true);
      }
      if (this.FXP > getWidth() - this.FYd)
      {
        this.FXP = (getWidth() - this.FYd - 1);
        this.FXU.forceFinished(true);
        continue;
        if (this.FXP < 0)
        {
          this.FXP = 0;
          this.FXU.forceFinished(true);
        }
        if (this.FXP > this.FXQ)
        {
          this.FXP = this.FXQ;
          this.FXU.forceFinished(true);
        }
      }
    }
    View localView = getChildAt(getChildCount() - 1);
    while ((localView != null) && (localView.getLeft() + paramInt2 >= getWidth()))
    {
      this.FXR.offer(localView);
      removeViewInLayout(localView);
      this.FXO -= 1;
      localView = getChildAt(getChildCount() - 1);
      this.FXT = true;
    }
    localView = getChildAt(getChildCount() - 1);
    if (localView != null) {
      paramInt1 = localView.getRight();
    }
    for (;;)
    {
      if ((paramInt1 + paramInt2 < getWidth()) && (this.FXO < this.FXY.getCount()))
      {
        localView = this.FXY.getView(this.FXO, (View)this.FXR.poll(), this);
        ax(localView, -1);
        paramInt1 = localView.getMeasuredWidth() + paramInt1;
        if (this.FXO == this.FXY.getCount() - 1) {
          this.FXQ = (this.nlj + paramInt1 - getWidth());
        }
        this.FXO += 1;
      }
      else
      {
        localView = getChildAt(0);
        if (localView != null) {
          paramInt1 = localView.getLeft();
        }
        for (;;)
        {
          if ((paramInt1 + paramInt2 > 0) && (this.FXN >= 0))
          {
            localView = this.FXY.getView(this.FXN, (View)this.FXR.poll(), this);
            ax(localView, 0);
            paramInt3 = localView.getMeasuredWidth();
            this.FXN -= 1;
            this.offset -= localView.getMeasuredWidth();
            paramInt1 -= paramInt3;
          }
          else
          {
            if ((getChildCount() > 0) && (this.FXT))
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
            this.nlj = this.FXP;
            if (!this.FXU.isFinished())
            {
              post(this.FXZ);
              AppMethodBeat.o(142014);
              return;
            }
            if ((this.FXM != null) && (this.FYe))
            {
              this.FXM.bss();
              this.FYe = false;
            }
            AppMethodBeat.o(142014);
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
    AppMethodBeat.i(142016);
    if ((this.FXY != null) && (this.FXY.getCount() > 0))
    {
      View localView = getChildAt(0);
      if (localView != null)
      {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), -2147483648));
        AppMethodBeat.o(142016);
        return;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(142016);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(142012);
    if (this.FXY == null) {
      paramListAdapter.registerDataSetObserver(this.FYf);
    }
    this.FXY = paramListAdapter;
    reset();
    AppMethodBeat.o(142012);
  }
  
  public void setCenterInParent(boolean paramBoolean)
  {
    this.FYa = paramBoolean;
  }
  
  public void setHorListLitener(a parama)
  {
    this.FXM = parama;
  }
  
  public void setItemWidth(int paramInt)
  {
    this.FYc = paramInt;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.FXX = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.FXW = paramOnItemSelectedListener;
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.FYb = paramBoolean;
  }
  
  public void setSelection(int paramInt) {}
  
  public static abstract interface a
  {
    public abstract void bss();
    
    public abstract void dNj();
    
    public abstract void dwD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMHorList
 * JD-Core Version:    0.7.0.1
 */