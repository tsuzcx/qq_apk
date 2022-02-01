package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.ArrayList;
import java.util.List;

public class GridHeadersGridView
  extends GridView
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private AbsListView.OnScrollListener ARY;
  protected boolean JDK;
  private int JDr;
  private int JDs;
  private Runnable JIc;
  private AdapterView.OnItemLongClickListener JOO;
  public a KXb;
  public b KXc;
  private boolean KXd;
  private final Rect KXe;
  private boolean KXf;
  private boolean KXg;
  private int KXh;
  private long KXi;
  private int KXj;
  private float KXk;
  private boolean KXl;
  private int KXm;
  GridHeadersGridView.c KXn;
  d KXo;
  private e KXp;
  private View KXq;
  protected c KXr;
  protected int KXs;
  private boolean KXt;
  private DataSetObserver Tf;
  private AdapterView.OnItemSelectedListener XW;
  private AdapterView.OnItemClickListener awt;
  protected int aye;
  private aq mHandler;
  private int mNumColumns;
  private int mScrollState;
  private int mTouchSlop;
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842865);
  }
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142806);
    this.mHandler = new aq();
    this.KXd = true;
    this.KXe = new Rect();
    this.KXi = -1L;
    this.Tf = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(142793);
        GridHeadersGridView.a(GridHeadersGridView.this);
        AppMethodBeat.o(142793);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(142794);
        GridHeadersGridView.a(GridHeadersGridView.this);
        AppMethodBeat.o(142794);
      }
    };
    this.KXm = 1;
    this.mScrollState = 0;
    this.KXt = true;
    super.setOnScrollListener(this);
    setVerticalFadingEdgeEnabled(false);
    if (!this.KXl) {
      this.mNumColumns = -1;
    }
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(142806);
  }
  
  private void afw(int paramInt)
  {
    AppMethodBeat.i(142830);
    if ((this.KXr == null) || (this.KXr.getCount() == 0) || (!this.KXd))
    {
      AppMethodBeat.o(142830);
      return;
    }
    if ((c.d)getChildAt(0) == null)
    {
      AppMethodBeat.o(142830);
      return;
    }
    int j = paramInt - this.KXm;
    int i = j;
    if (j < 0) {
      i = paramInt;
    }
    int k = this.KXm + paramInt;
    j = k;
    if (k >= this.KXr.getCount()) {
      j = paramInt;
    }
    long l;
    Object localObject;
    label198:
    c.d locald;
    if (this.JDs != 0) {
      if (this.JDs < 0)
      {
        this.KXr.Bi(paramInt);
        if (getChildAt(this.KXm).getTop() <= 0)
        {
          l = this.KXr.Bi(j);
          i = j;
          if (this.KXi != l)
          {
            this.KXq = this.KXr.a(i, this.KXq, this);
            fNZ();
            this.KXi = l;
          }
          int m = getChildCount();
          if (m == 0) {
            break label516;
          }
          localObject = null;
          i = 99999;
          k = 0;
          if (k >= m) {
            break label345;
          }
          locald = (c.d)super.getChildAt(k);
          if (!this.KXf) {
            break label336;
          }
          j = locald.getTop() - getPaddingTop();
          label234:
          if ((j < 0) || (!(locald.getView() instanceof c.b)) || (j >= i)) {
            break label522;
          }
          localObject = locald;
        }
      }
    }
    for (;;)
    {
      k += this.KXm;
      i = j;
      break label198;
      l = this.KXr.Bi(paramInt);
      i = paramInt;
      break;
      j = getChildAt(0).getTop();
      if ((j > 0) && (j < this.JDs))
      {
        l = this.KXr.Bi(i);
        break;
      }
      l = this.KXr.Bi(paramInt);
      i = paramInt;
      break;
      label336:
      j = locald.getTop();
      break label234;
      label345:
      i = getHeaderHeight();
      if (localObject != null)
      {
        if ((paramInt == 0) && (super.getChildAt(0).getTop() > 0) && (!this.KXf))
        {
          this.KXj = 0;
          AppMethodBeat.o(142830);
          return;
        }
        if (this.KXf)
        {
          this.KXj = Math.min(localObject.getTop(), getPaddingTop() + i);
          if (this.KXj < getPaddingTop()) {}
          for (paramInt = i + getPaddingTop();; paramInt = this.KXj)
          {
            this.KXj = paramInt;
            AppMethodBeat.o(142830);
            return;
          }
        }
        this.KXj = Math.min(localObject.getTop(), i);
        if (this.KXj < 0) {}
        for (paramInt = i;; paramInt = this.KXj)
        {
          this.KXj = paramInt;
          AppMethodBeat.o(142830);
          return;
        }
      }
      this.KXj = i;
      if (this.KXf) {
        this.KXj += getPaddingTop();
      }
      label516:
      AppMethodBeat.o(142830);
      return;
      label522:
      j = i;
    }
  }
  
  private void fNZ()
  {
    AppMethodBeat.i(142829);
    if (this.KXq == null)
    {
      AppMethodBeat.o(142829);
      return;
    }
    int j = View.MeasureSpec.makeMeasureSpec(getWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
    ViewGroup.LayoutParams localLayoutParams = this.KXq.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height > 0)) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      this.KXq.measure(j, i);
      this.KXq.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.KXq.getMeasuredHeight());
      AppMethodBeat.o(142829);
      return;
    }
  }
  
  private int getHeaderHeight()
  {
    AppMethodBeat.i(142828);
    if (this.KXq != null)
    {
      int i = this.KXq.getMeasuredHeight();
      AppMethodBeat.o(142828);
      return i;
    }
    AppMethodBeat.o(142828);
    return 0;
  }
  
  private void reset()
  {
    this.KXj = 0;
    this.KXq = null;
    this.KXi = -9223372036854775808L;
  }
  
  public final View afv(int paramInt)
  {
    AppMethodBeat.i(142807);
    View localView;
    if (paramInt == -2)
    {
      localView = this.KXq;
      AppMethodBeat.o(142807);
      return localView;
    }
    try
    {
      localView = (View)getChildAt(paramInt).getTag();
      AppMethodBeat.o(142807);
      return localView;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(142807);
    }
    return null;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142831);
    if (Build.VERSION.SDK_INT < 8) {
      afw(getFirstVisiblePosition());
    }
    if ((this.KXq != null) && (this.KXd) && (this.KXq.getVisibility() == 0)) {}
    int m;
    int n;
    ArrayList localArrayList;
    int k;
    for (int i = 1;; i = 0)
    {
      m = getHeaderHeight();
      n = this.KXj - m;
      if ((i != 0) && (this.KXt))
      {
        this.KXe.left = getPaddingLeft();
        this.KXe.right = (getWidth() - getPaddingRight());
        this.KXe.top = this.KXj;
        this.KXe.bottom = getHeight();
        paramCanvas.save();
        paramCanvas.clipRect(this.KXe);
      }
      super.dispatchDraw(paramCanvas);
      localArrayList = new ArrayList();
      j = 0;
      k = getFirstVisiblePosition();
      while (k <= getLastVisiblePosition())
      {
        if (getItemIdAtPosition(k) == -1L) {
          localArrayList.add(Integer.valueOf(j));
        }
        k += this.KXm;
        j += this.KXm;
      }
    }
    int j = 0;
    if (j < localArrayList.size())
    {
      c.d locald = (c.d)getChildAt(((Integer)localArrayList.get(j)).intValue());
      for (;;)
      {
        try
        {
          View localView = (View)locald.getTag();
          if ((((c.b)locald.getChildAt(0)).getHeaderId() == this.KXi) && (locald.getTop() < 0) && (this.KXd))
          {
            k = 1;
            if ((localView.getVisibility() == 0) && (k == 0))
            {
              localView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight()), View.MeasureSpec.makeMeasureSpec(0, 0));
              localView.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), locald.getHeight());
              this.KXe.left = getPaddingLeft();
              this.KXe.right = (getWidth() - getPaddingRight());
              this.KXe.bottom = locald.getBottom();
              this.KXe.top = locald.getTop();
              paramCanvas.save();
              paramCanvas.clipRect(this.KXe);
              paramCanvas.translate(getPaddingLeft(), locald.getTop());
              localView.draw(paramCanvas);
              paramCanvas.restore();
            }
            j += 1;
          }
        }
        catch (Exception paramCanvas)
        {
          AppMethodBeat.o(142831);
          return;
        }
        k = 0;
      }
    }
    if ((i != 0) && (this.KXt))
    {
      paramCanvas.restore();
      if (this.KXq.getWidth() != getWidth() - getPaddingLeft() - getPaddingRight())
      {
        i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight());
        j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.KXq.measure(i, j);
        this.KXq.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.KXq.getHeight());
      }
      this.KXe.left = getPaddingLeft();
      this.KXe.right = (getWidth() - getPaddingRight());
      this.KXe.bottom = (n + m);
      if (!this.KXf) {
        break label741;
      }
    }
    label741:
    for (this.KXe.top = getPaddingTop();; this.KXe.top = 0)
    {
      paramCanvas.save();
      paramCanvas.clipRect(this.KXe);
      paramCanvas.translate(getPaddingLeft(), n);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), (int)(255.0F * this.KXj / m), 31);
      this.KXq.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      AppMethodBeat.o(142831);
      return;
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(142831);
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = -2;
    AppMethodBeat.i(142816);
    int i;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label591;
      }
      AppMethodBeat.o(142816);
      return false;
      if (this.KXc == null) {
        this.KXc = new b();
      }
      this.mHandler.postDelayed(this.KXb, ViewConfiguration.getTapTimeout());
      i = (int)paramMotionEvent.getY();
      this.KXk = i;
      float f = i;
      if ((this.KXq != null) && (f <= this.KXq.getBottom())) {}
      for (;;)
      {
        this.KXs = j;
        if ((this.KXs == -1) || (this.mScrollState == 2)) {
          break;
        }
        this.aye = 0;
        break;
        int k = getFirstVisiblePosition();
        i = 0;
        for (;;)
        {
          if (k > getLastVisiblePosition()) {
            break label247;
          }
          if (getItemIdAtPosition(k) == -1L)
          {
            localObject = getChildAt(i);
            j = ((View)localObject).getBottom();
            int m = ((View)localObject).getTop();
            if (f <= j)
            {
              j = i;
              if (f >= m) {
                break;
              }
            }
          }
          k += this.KXm;
          i += this.KXm;
        }
        label247:
        j = -1;
      }
      if ((this.KXs == -1) || (Math.abs(paramMotionEvent.getY() - this.KXk) <= this.mTouchSlop)) {
        break;
      }
      this.aye = -1;
      Object localObject = afv(this.KXs);
      if (localObject != null) {
        ((View)localObject).setPressed(false);
      }
      if (this.KXb != null) {
        this.mHandler.removeCallbacks(this.KXb);
      }
      this.KXs = -1;
      break;
      if ((this.aye == -2) || (this.aye == -1) || (this.KXs == -1)) {
        break;
      }
      final View localView = afv(this.KXs);
      final e locale;
      if ((localView != null) && (!localView.hasFocusable()))
      {
        if (this.aye != 0) {
          localView.setPressed(false);
        }
        if (this.KXp == null) {
          this.KXp = new e((byte)0);
        }
        locale = this.KXp;
        locale.KXx = this.KXs;
        locale.fOb();
        if ((this.aye == 0) && (this.aye == 1)) {
          break label574;
        }
        localaq = this.mHandler;
        if (this.aye == 0) {}
        for (localObject = this.KXc;; localObject = this.KXb)
        {
          localaq.removeCallbacks((Runnable)localObject);
          if (this.JDK) {
            break label561;
          }
          this.aye = 1;
          localView.setPressed(true);
          setPressed(true);
          if (this.JIc != null) {
            removeCallbacks(this.JIc);
          }
          this.JIc = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142795);
              GridHeadersGridView.this.aye = -1;
              localView.setPressed(false);
              GridHeadersGridView.this.setPressed(false);
              if (!GridHeadersGridView.this.JDK) {
                locale.run();
              }
              AppMethodBeat.o(142795);
            }
          };
          this.mHandler.postDelayed(this.JIc, ViewConfiguration.getPressedStateDuration());
          i = 1;
          break;
        }
        label561:
        this.aye = -1;
      }
      label574:
      while (this.JDK)
      {
        aq localaq;
        this.aye = -1;
        break;
      }
      locale.run();
      i = 1;
    }
    label591:
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(142816);
    return bool;
  }
  
  public View getStickiedHeader()
  {
    return this.KXq;
  }
  
  public boolean getStickyHeaderIsTranscluent()
  {
    return !this.KXt;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142808);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    a.b("com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    this.awt.onItemClick(paramAdapterView, paramView, this.KXr.afu(paramInt).mPosition, paramLong);
    a.a(this, "com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(142808);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142809);
    boolean bool = this.JOO.onItemLongClick(paramAdapterView, paramView, this.KXr.afu(paramInt).mPosition, paramLong);
    AppMethodBeat.o(142809);
    return bool;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142810);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    a.b("com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    this.XW.onItemSelected(paramAdapterView, paramView, this.KXr.afu(paramInt).mPosition, paramLong);
    a.a(this, "com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(142810);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(142832);
    if (this.mNumColumns == -1) {
      if (this.KXh > 0)
      {
        int k = Math.max(View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight(), 0);
        int j = k / this.KXh;
        if (j > 0)
        {
          i = j;
          while ((i != 1) && (this.KXh * i + (i - 1) * this.JDr > k)) {
            i -= 1;
          }
        }
      }
      else
      {
        i = 2;
      }
    }
    for (;;)
    {
      for (this.KXm = i;; this.KXm = this.mNumColumns)
      {
        if (this.KXr != null) {
          this.KXr.setNumColumns(this.KXm);
        }
        fNZ();
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(142832);
        return;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AppMethodBeat.i(142811);
    this.XW.onNothingSelected(paramAdapterView);
    AppMethodBeat.o(142811);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(142812);
    paramParcelable = (GridHeadersGridView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.KXd = paramParcelable.KXy;
    requestLayout();
    AppMethodBeat.o(142812);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(142813);
    GridHeadersGridView.SavedState localSavedState = new GridHeadersGridView.SavedState(super.onSaveInstanceState());
    localSavedState.KXy = this.KXd;
    AppMethodBeat.o(142813);
    return localSavedState;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142814);
    if (this.ARY != null) {
      this.ARY.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (Build.VERSION.SDK_INT >= 8) {
      afw(paramInt1);
    }
    AppMethodBeat.o(142814);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(142815);
    if (this.ARY != null) {
      this.ARY.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.mScrollState = paramInt;
    AppMethodBeat.o(142815);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(142817);
    if ((this.KXr != null) && (this.Tf != null)) {
      this.KXr.unregisterDataSetObserver(this.Tf);
    }
    if (!this.KXg) {
      this.KXf = true;
    }
    if ((paramListAdapter instanceof b)) {
      paramListAdapter = (b)paramListAdapter;
    }
    for (;;)
    {
      this.KXr = new c(getContext(), this, paramListAdapter);
      this.KXr.registerDataSetObserver(this.Tf);
      reset();
      super.setAdapter(this.KXr);
      AppMethodBeat.o(142817);
      return;
      if ((paramListAdapter instanceof e)) {
        paramListAdapter = new f((e)paramListAdapter);
      } else {
        paramListAdapter = new d(paramListAdapter);
      }
    }
  }
  
  public void setAreHeadersSticky(boolean paramBoolean)
  {
    AppMethodBeat.i(142818);
    if (paramBoolean != this.KXd)
    {
      this.KXd = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(142818);
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(142819);
    super.setClipToPadding(paramBoolean);
    this.KXf = paramBoolean;
    this.KXg = true;
    AppMethodBeat.o(142819);
  }
  
  public void setColumnWidth(int paramInt)
  {
    AppMethodBeat.i(142820);
    super.setColumnWidth(paramInt);
    this.KXh = paramInt;
    AppMethodBeat.o(142820);
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    AppMethodBeat.i(142821);
    super.setHorizontalSpacing(paramInt);
    this.JDr = paramInt;
    AppMethodBeat.o(142821);
  }
  
  public void setNumColumns(int paramInt)
  {
    AppMethodBeat.i(142822);
    super.setNumColumns(paramInt);
    this.KXl = true;
    this.mNumColumns = paramInt;
    if ((paramInt != -1) && (this.KXr != null)) {
      this.KXr.setNumColumns(paramInt);
    }
    AppMethodBeat.o(142822);
  }
  
  public void setOnHeaderClickListener(GridHeadersGridView.c paramc)
  {
    this.KXn = paramc;
  }
  
  public void setOnHeaderLongClickListener(d paramd)
  {
    AppMethodBeat.i(142823);
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.KXo = paramd;
    AppMethodBeat.o(142823);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(142824);
    this.awt = paramOnItemClickListener;
    super.setOnItemClickListener(this);
    AppMethodBeat.o(142824);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(142825);
    this.JOO = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(this);
    AppMethodBeat.o(142825);
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    AppMethodBeat.i(142826);
    this.XW = paramOnItemSelectedListener;
    super.setOnItemSelectedListener(this);
    AppMethodBeat.o(142826);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.ARY = paramOnScrollListener;
  }
  
  public void setStickyHeaderIsTranscluent(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.KXt = paramBoolean;
      return;
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    AppMethodBeat.i(142827);
    super.setVerticalSpacing(paramInt);
    this.JDs = paramInt;
    AppMethodBeat.o(142827);
  }
  
  final class a
    extends GridHeadersGridView.f
    implements Runnable
  {
    private a()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(142796);
      View localView = GridHeadersGridView.this.afv(GridHeadersGridView.this.KXs);
      boolean bool1;
      if (localView != null)
      {
        GridHeadersGridView.a(GridHeadersGridView.this, GridHeadersGridView.this.KXs);
        if ((!fOc()) || (GridHeadersGridView.this.JDK)) {
          break label156;
        }
        GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
        if (localGridHeadersGridView.KXo == null) {
          break label151;
        }
        bool1 = localGridHeadersGridView.KXo.fOa();
        bool2 = bool1;
        if (bool1)
        {
          if (localView != null) {
            localView.sendAccessibilityEvent(2);
          }
          localGridHeadersGridView.performHapticFeedback(0);
        }
      }
      label151:
      label156:
      for (boolean bool2 = bool1;; bool2 = false)
      {
        if (bool2)
        {
          GridHeadersGridView.this.aye = -2;
          GridHeadersGridView.this.setPressed(false);
          localView.setPressed(false);
          AppMethodBeat.o(142796);
          return;
        }
        GridHeadersGridView.this.aye = 2;
        AppMethodBeat.o(142796);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  final class b
    implements Runnable
  {
    b() {}
    
    public final void run()
    {
      AppMethodBeat.i(142797);
      if (GridHeadersGridView.this.aye == 0)
      {
        GridHeadersGridView.this.aye = 1;
        View localView = GridHeadersGridView.this.afv(GridHeadersGridView.this.KXs);
        if ((localView != null) && (!localView.hasFocusable()))
        {
          if (!GridHeadersGridView.this.JDK)
          {
            localView.setPressed(true);
            GridHeadersGridView.this.setPressed(true);
            GridHeadersGridView.this.refreshDrawableState();
            int i = ViewConfiguration.getLongPressTimeout();
            if (GridHeadersGridView.this.isLongClickable())
            {
              if (GridHeadersGridView.this.KXb == null) {
                GridHeadersGridView.this.KXb = new GridHeadersGridView.a(GridHeadersGridView.this, (byte)0);
              }
              GridHeadersGridView.this.KXb.fOb();
              GridHeadersGridView.d(GridHeadersGridView.this).postDelayed(GridHeadersGridView.this.KXb, i);
              AppMethodBeat.o(142797);
              return;
            }
            GridHeadersGridView.this.aye = 2;
            AppMethodBeat.o(142797);
            return;
          }
          GridHeadersGridView.this.aye = 2;
        }
      }
      AppMethodBeat.o(142797);
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean fOa();
  }
  
  final class e
    extends GridHeadersGridView.f
    implements Runnable
  {
    int KXx;
    
    private e()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(142798);
      if (GridHeadersGridView.this.JDK)
      {
        AppMethodBeat.o(142798);
        return;
      }
      if ((GridHeadersGridView.this.KXr != null) && (GridHeadersGridView.this.KXr.getCount() > 0) && (this.KXx != -1) && (this.KXx < GridHeadersGridView.this.KXr.getCount()) && (fOc()))
      {
        View localView = GridHeadersGridView.this.afv(this.KXx);
        if (localView != null)
        {
          GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
          GridHeadersGridView.a(GridHeadersGridView.this, this.KXx);
          if (localGridHeadersGridView.KXn != null)
          {
            localGridHeadersGridView.playSoundEffect(0);
            if (localView != null) {
              localView.sendAccessibilityEvent(1);
            }
            localGridHeadersGridView.KXn.dM(localView);
          }
        }
      }
      AppMethodBeat.o(142798);
    }
  }
  
  class f
  {
    private int JIi;
    
    private f() {}
    
    public final void fOb()
    {
      AppMethodBeat.i(142804);
      this.JIi = GridHeadersGridView.b(GridHeadersGridView.this);
      AppMethodBeat.o(142804);
    }
    
    public final boolean fOc()
    {
      AppMethodBeat.i(142805);
      if ((GridHeadersGridView.this.hasWindowFocus()) && (GridHeadersGridView.c(GridHeadersGridView.this) == this.JIi))
      {
        AppMethodBeat.o(142805);
        return true;
      }
      AppMethodBeat.o(142805);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView
 * JD-Core Version:    0.7.0.1
 */