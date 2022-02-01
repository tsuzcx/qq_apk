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
  private a HxB;
  private int HxC;
  private int HxD;
  private int HxE;
  private int HxF;
  private Queue<View> HxG;
  private boolean HxH;
  private boolean HxI;
  protected Scroller HxJ;
  private GestureDetector HxK;
  private AdapterView.OnItemSelectedListener HxL;
  private AdapterView.OnItemClickListener HxM;
  private ListAdapter HxN;
  private Runnable HxO;
  private boolean HxP;
  private boolean HxQ;
  private int HxR;
  private int HxS;
  private boolean HxT;
  private DataSetObserver HxU;
  private GestureDetector.OnGestureListener HxV;
  private int nOj;
  private int offset;
  private boolean vhz;
  
  public MMHorList(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142011);
    this.HxF = 536870912;
    this.HxG = new LinkedList();
    this.HxH = false;
    this.HxI = false;
    this.HxO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142002);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142002);
      }
    };
    this.HxP = false;
    this.HxQ = false;
    this.HxR = 0;
    this.HxS = 0;
    this.vhz = false;
    this.HxT = false;
    this.HxU = new DataSetObserver()
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
    this.HxV = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142005);
        boolean bool = MMHorList.this.fic();
        AppMethodBeat.o(142005);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142006);
        boolean bool = MMHorList.this.bM(paramAnonymousFloat1);
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
    this.HxF = 536870912;
    this.HxG = new LinkedList();
    this.HxH = false;
    this.HxI = false;
    this.HxO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142002);
        MMHorList.this.requestLayout();
        AppMethodBeat.o(142002);
      }
    };
    this.HxP = false;
    this.HxQ = false;
    this.HxR = 0;
    this.HxS = 0;
    this.vhz = false;
    this.HxT = false;
    this.HxU = new DataSetObserver()
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
    this.HxV = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(142005);
        boolean bool = MMHorList.this.fic();
        AppMethodBeat.o(142005);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(142006);
        boolean bool = MMHorList.this.bM(paramAnonymousFloat1);
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
  
  private void az(View paramView, int paramInt)
  {
    AppMethodBeat.i(142015);
    this.HxI = true;
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
    int i = this.HxN.getCount();
    int j = this.HxR;
    AppMethodBeat.o(142013);
    return i * j;
  }
  
  private void init()
  {
    AppMethodBeat.i(142009);
    this.HxJ = new Scroller(getContext());
    this.HxC = -1;
    this.HxD = 0;
    this.offset = 0;
    this.nOj = 0;
    this.HxE = 0;
    this.HxH = false;
    this.HxF = 536870912;
    this.HxK = new GestureDetector(getContext(), this.HxV);
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
  
  public final void ZZ(int paramInt)
  {
    AppMethodBeat.i(142019);
    this.HxJ.forceFinished(true);
    this.HxJ.startScroll(this.nOj, 0, paramInt - this.nOj, 0);
    this.HxT = true;
    requestLayout();
    AppMethodBeat.o(142019);
  }
  
  protected final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(142020);
    this.HxJ.fling(this.HxE, 0, (int)-paramFloat, 0, 0, this.HxF, 0, 0);
    requestLayout();
    AppMethodBeat.o(142020);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(142017);
    boolean bool = this.HxK.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0)
    {
      this.vhz = true;
      if (this.HxB != null) {
        this.HxB.ebJ();
      }
    }
    while ((paramMotionEvent.getAction() != 3) && (paramMotionEvent.getAction() != 1))
    {
      AppMethodBeat.o(142017);
      return bool;
    }
    if (this.HxQ)
    {
      if (getChildViewTotalWidth() <= getWidth()) {
        break label193;
      }
      if (this.nOj >= 0) {
        break label145;
      }
      this.HxJ.forceFinished(true);
      this.HxJ.startScroll(this.nOj, 0, 0 - this.nOj, 0);
      requestLayout();
    }
    for (;;)
    {
      this.vhz = false;
      if (this.HxB == null) {
        break;
      }
      this.HxB.dLc();
      break;
      label145:
      if (this.nOj > this.HxF)
      {
        this.HxJ.forceFinished(true);
        this.HxJ.startScroll(this.nOj, 0, this.HxF - this.nOj, 0);
        requestLayout();
        continue;
        label193:
        if (this.nOj != this.HxS * -1)
        {
          this.HxJ.forceFinished(true);
          this.HxJ.startScroll(this.nOj, 0, 0 - this.nOj, 0);
          requestLayout();
        }
      }
    }
  }
  
  protected final boolean fic()
  {
    AppMethodBeat.i(142018);
    this.HxJ.forceFinished(true);
    AppMethodBeat.o(142018);
    return true;
  }
  
  public ListAdapter getAdapter()
  {
    return this.HxN;
  }
  
  public int getCurrentPosition()
  {
    return this.nOj;
  }
  
  public boolean getIsTouching()
  {
    return this.vhz;
  }
  
  public View getSelectedView()
  {
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142014);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.HxN == null)
    {
      AppMethodBeat.o(142014);
      return;
    }
    this.HxI = true;
    if (this.HxH)
    {
      paramInt1 = this.nOj;
      init();
      removeAllViewsInLayout();
      this.HxE = paramInt1;
      if (this.HxP)
      {
        this.HxS = Math.max(0, (getWidth() - getChildViewTotalWidth()) / 2);
        this.offset = this.HxS;
      }
      this.HxH = false;
    }
    if (this.HxJ.computeScrollOffset()) {
      this.HxE = this.HxJ.getCurrX();
    }
    if (this.HxQ) {
      if (getChildViewTotalWidth() > getWidth())
      {
        if (this.HxE < getWidth() * -1)
        {
          this.HxE = (getWidth() * -1 + 1);
          this.HxJ.forceFinished(true);
        }
        if (this.HxE > this.HxF + getWidth())
        {
          this.HxE = (this.HxF + getWidth() - 1);
          this.HxJ.forceFinished(true);
        }
      }
    }
    for (;;)
    {
      paramInt2 = this.nOj - this.HxE;
      localView = getChildAt(0);
      while ((localView != null) && (localView.getRight() + paramInt2 <= 0))
      {
        this.offset += localView.getMeasuredWidth();
        this.HxG.offer(localView);
        removeViewInLayout(localView);
        this.HxC += 1;
        localView = getChildAt(0);
        this.HxI = true;
      }
      if (this.HxE < getWidth() * -1 + this.HxS)
      {
        this.HxE = (getWidth() * -1 + this.HxS + 1);
        this.HxJ.forceFinished(true);
      }
      if (this.HxE > getWidth() - this.HxS)
      {
        this.HxE = (getWidth() - this.HxS - 1);
        this.HxJ.forceFinished(true);
        continue;
        if (this.HxE < 0)
        {
          this.HxE = 0;
          this.HxJ.forceFinished(true);
        }
        if (this.HxE > this.HxF)
        {
          this.HxE = this.HxF;
          this.HxJ.forceFinished(true);
        }
      }
    }
    View localView = getChildAt(getChildCount() - 1);
    while ((localView != null) && (localView.getLeft() + paramInt2 >= getWidth()))
    {
      this.HxG.offer(localView);
      removeViewInLayout(localView);
      this.HxD -= 1;
      localView = getChildAt(getChildCount() - 1);
      this.HxI = true;
    }
    localView = getChildAt(getChildCount() - 1);
    if (localView != null) {
      paramInt1 = localView.getRight();
    }
    for (;;)
    {
      if ((paramInt1 + paramInt2 < getWidth()) && (this.HxD < this.HxN.getCount()))
      {
        localView = this.HxN.getView(this.HxD, (View)this.HxG.poll(), this);
        az(localView, -1);
        paramInt1 = localView.getMeasuredWidth() + paramInt1;
        if (this.HxD == this.HxN.getCount() - 1) {
          this.HxF = (this.nOj + paramInt1 - getWidth());
        }
        this.HxD += 1;
      }
      else
      {
        localView = getChildAt(0);
        if (localView != null) {
          paramInt1 = localView.getLeft();
        }
        for (;;)
        {
          if ((paramInt1 + paramInt2 > 0) && (this.HxC >= 0))
          {
            localView = this.HxN.getView(this.HxC, (View)this.HxG.poll(), this);
            az(localView, 0);
            paramInt3 = localView.getMeasuredWidth();
            this.HxC -= 1;
            this.offset -= localView.getMeasuredWidth();
            paramInt1 -= paramInt3;
          }
          else
          {
            if ((getChildCount() > 0) && (this.HxI))
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
            this.nOj = this.HxE;
            if (!this.HxJ.isFinished())
            {
              post(this.HxO);
              AppMethodBeat.o(142014);
              return;
            }
            if ((this.HxB != null) && (this.HxT))
            {
              this.HxB.bzs();
              this.HxT = false;
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
    if ((this.HxN != null) && (this.HxN.getCount() > 0))
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
    if (this.HxN == null) {
      paramListAdapter.registerDataSetObserver(this.HxU);
    }
    this.HxN = paramListAdapter;
    reset();
    AppMethodBeat.o(142012);
  }
  
  public void setCenterInParent(boolean paramBoolean)
  {
    this.HxP = paramBoolean;
  }
  
  public void setHorListLitener(a parama)
  {
    this.HxB = parama;
  }
  
  public void setItemWidth(int paramInt)
  {
    this.HxR = paramInt;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.HxM = paramOnItemClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.HxL = paramOnItemSelectedListener;
  }
  
  public void setOverScrollEnabled(boolean paramBoolean)
  {
    this.HxQ = paramBoolean;
  }
  
  public void setSelection(int paramInt) {}
  
  public static abstract interface a
  {
    public abstract void bzs();
    
    public abstract void dLc();
    
    public abstract void ebJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMHorList
 * JD-Core Version:    0.7.0.1
 */