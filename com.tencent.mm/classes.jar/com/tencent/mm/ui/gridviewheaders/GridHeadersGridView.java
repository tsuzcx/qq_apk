package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
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
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.List;

public class GridHeadersGridView
  extends GridView
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private AbsListView.OnScrollListener RTW;
  protected boolean adOG;
  private int adOr;
  private int adOs;
  private Runnable adTw;
  private AdapterView.OnItemLongClickListener aeaB;
  private long afvA;
  private int afvB;
  private float afvC;
  private boolean afvD;
  private int afvE;
  c afvF;
  d afvG;
  private e afvH;
  private View afvI;
  protected c afvJ;
  protected int afvK;
  private boolean afvL;
  public a afvt;
  public b afvu;
  private boolean afvv;
  private final Rect afvw;
  private boolean afvx;
  private boolean afvy;
  private int afvz;
  private DataSetObserver bxk;
  private AdapterView.OnItemSelectedListener gz;
  private MMHandler mHandler;
  private int mNumColumns;
  private int mScrollState;
  private int mTouchSlop;
  private AdapterView.OnItemClickListener vT;
  protected int wS;
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842865);
  }
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142806);
    this.mHandler = new MMHandler();
    this.afvv = true;
    this.afvw = new Rect();
    this.afvA = -1L;
    this.bxk = new DataSetObserver()
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
    this.afvE = 1;
    this.mScrollState = 0;
    this.afvL = true;
    super.setOnScrollListener(this);
    setVerticalFadingEdgeEnabled(false);
    if (!this.afvD) {
      this.mNumColumns = -1;
    }
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(142806);
  }
  
  private void aDT(int paramInt)
  {
    AppMethodBeat.i(142830);
    if ((this.afvJ == null) || (this.afvJ.getCount() == 0) || (!this.afvv))
    {
      AppMethodBeat.o(142830);
      return;
    }
    if ((c.d)getChildAt(0) == null)
    {
      AppMethodBeat.o(142830);
      return;
    }
    int j = paramInt - this.afvE;
    int i = j;
    if (j < 0) {
      i = paramInt;
    }
    int k = this.afvE + paramInt;
    j = k;
    if (k >= this.afvJ.getCount()) {
      j = paramInt;
    }
    long l;
    Object localObject;
    label198:
    c.d locald;
    if (this.adOs != 0) {
      if (this.adOs < 0)
      {
        this.afvJ.Ja(paramInt);
        if (getChildAt(this.afvE).getTop() <= 0)
        {
          l = this.afvJ.Ja(j);
          i = j;
          if (this.afvA != l)
          {
            this.afvI = this.afvJ.a(i, this.afvI, this);
            jBy();
            this.afvA = l;
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
          if (!this.afvx) {
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
      k += this.afvE;
      i = j;
      break label198;
      l = this.afvJ.Ja(paramInt);
      i = paramInt;
      break;
      j = getChildAt(0).getTop();
      if ((j > 0) && (j < this.adOs))
      {
        l = this.afvJ.Ja(i);
        break;
      }
      l = this.afvJ.Ja(paramInt);
      i = paramInt;
      break;
      label336:
      j = locald.getTop();
      break label234;
      label345:
      i = getHeaderHeight();
      if (localObject != null)
      {
        if ((paramInt == 0) && (super.getChildAt(0).getTop() > 0) && (!this.afvx))
        {
          this.afvB = 0;
          AppMethodBeat.o(142830);
          return;
        }
        if (this.afvx)
        {
          this.afvB = Math.min(localObject.getTop(), getPaddingTop() + i);
          if (this.afvB < getPaddingTop()) {}
          for (paramInt = i + getPaddingTop();; paramInt = this.afvB)
          {
            this.afvB = paramInt;
            AppMethodBeat.o(142830);
            return;
          }
        }
        this.afvB = Math.min(localObject.getTop(), i);
        if (this.afvB < 0) {}
        for (paramInt = i;; paramInt = this.afvB)
        {
          this.afvB = paramInt;
          AppMethodBeat.o(142830);
          return;
        }
      }
      this.afvB = i;
      if (this.afvx) {
        this.afvB += getPaddingTop();
      }
      label516:
      AppMethodBeat.o(142830);
      return;
      label522:
      j = i;
    }
  }
  
  private int getHeaderHeight()
  {
    AppMethodBeat.i(142828);
    if (this.afvI != null)
    {
      int i = this.afvI.getMeasuredHeight();
      AppMethodBeat.o(142828);
      return i;
    }
    AppMethodBeat.o(142828);
    return 0;
  }
  
  private void jBy()
  {
    AppMethodBeat.i(142829);
    if (this.afvI == null)
    {
      AppMethodBeat.o(142829);
      return;
    }
    int j = View.MeasureSpec.makeMeasureSpec(getWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
    ViewGroup.LayoutParams localLayoutParams = this.afvI.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height > 0)) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      this.afvI.measure(j, i);
      this.afvI.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.afvI.getMeasuredHeight());
      AppMethodBeat.o(142829);
      return;
    }
  }
  
  private void reset()
  {
    this.afvB = 0;
    this.afvI = null;
    this.afvA = -9223372036854775808L;
  }
  
  public final View aDS(int paramInt)
  {
    AppMethodBeat.i(142807);
    View localView;
    if (paramInt == -2)
    {
      localView = this.afvI;
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
      aDT(getFirstVisiblePosition());
    }
    if ((this.afvI != null) && (this.afvv) && (this.afvI.getVisibility() == 0)) {}
    int m;
    int n;
    ArrayList localArrayList;
    int k;
    for (int i = 1;; i = 0)
    {
      m = getHeaderHeight();
      n = this.afvB - m;
      if ((i != 0) && (this.afvL))
      {
        this.afvw.left = getPaddingLeft();
        this.afvw.right = (getWidth() - getPaddingRight());
        this.afvw.top = this.afvB;
        this.afvw.bottom = getHeight();
        paramCanvas.save();
        paramCanvas.clipRect(this.afvw);
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
        k += this.afvE;
        j += this.afvE;
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
          if ((((c.b)locald.getChildAt(0)).getHeaderId() == this.afvA) && (locald.getTop() < 0) && (this.afvv))
          {
            k = 1;
            if ((localView.getVisibility() == 0) && (k == 0))
            {
              localView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight()), View.MeasureSpec.makeMeasureSpec(0, 0));
              localView.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), locald.getHeight());
              this.afvw.left = getPaddingLeft();
              this.afvw.right = (getWidth() - getPaddingRight());
              this.afvw.bottom = locald.getBottom();
              this.afvw.top = locald.getTop();
              paramCanvas.save();
              paramCanvas.clipRect(this.afvw);
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
    if ((i != 0) && (this.afvL))
    {
      paramCanvas.restore();
      if (this.afvI.getWidth() != getWidth() - getPaddingLeft() - getPaddingRight())
      {
        i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight());
        j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.afvI.measure(i, j);
        this.afvI.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.afvI.getHeight());
      }
      this.afvw.left = getPaddingLeft();
      this.afvw.right = (getWidth() - getPaddingRight());
      this.afvw.bottom = (n + m);
      if (!this.afvx) {
        break label741;
      }
    }
    label741:
    for (this.afvw.top = getPaddingTop();; this.afvw.top = 0)
    {
      paramCanvas.save();
      paramCanvas.clipRect(this.afvw);
      paramCanvas.translate(getPaddingLeft(), n);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), (int)(255.0F * this.afvB / m), 31);
      this.afvI.draw(paramCanvas);
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
      if (this.afvu == null) {
        this.afvu = new b();
      }
      this.mHandler.postDelayed(this.afvt, ViewConfiguration.getTapTimeout());
      i = (int)paramMotionEvent.getY();
      this.afvC = i;
      float f = i;
      if ((this.afvI != null) && (f <= this.afvI.getBottom())) {}
      for (;;)
      {
        this.afvK = j;
        if ((this.afvK == -1) || (this.mScrollState == 2)) {
          break;
        }
        this.wS = 0;
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
          k += this.afvE;
          i += this.afvE;
        }
        label247:
        j = -1;
      }
      if ((this.afvK == -1) || (Math.abs(paramMotionEvent.getY() - this.afvC) <= this.mTouchSlop)) {
        break;
      }
      this.wS = -1;
      Object localObject = aDS(this.afvK);
      if (localObject != null) {
        ((View)localObject).setPressed(false);
      }
      if (this.afvt != null) {
        this.mHandler.removeCallbacks(this.afvt);
      }
      this.afvK = -1;
      break;
      if ((this.wS == -2) || (this.wS == -1) || (this.afvK == -1)) {
        break;
      }
      final View localView = aDS(this.afvK);
      final e locale;
      if ((localView != null) && (!localView.hasFocusable()))
      {
        if (this.wS != 0) {
          localView.setPressed(false);
        }
        if (this.afvH == null) {
          this.afvH = new e((byte)0);
        }
        locale = this.afvH;
        locale.afvP = this.afvK;
        locale.jBA();
        if ((this.wS == 0) && (this.wS == 1)) {
          break label574;
        }
        localMMHandler = this.mHandler;
        if (this.wS == 0) {}
        for (localObject = this.afvu;; localObject = this.afvt)
        {
          localMMHandler.removeCallbacks((Runnable)localObject);
          if (this.adOG) {
            break label561;
          }
          this.wS = 1;
          localView.setPressed(true);
          setPressed(true);
          if (this.adTw != null) {
            removeCallbacks(this.adTw);
          }
          this.adTw = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142795);
              GridHeadersGridView.this.wS = -1;
              localView.setPressed(false);
              GridHeadersGridView.this.setPressed(false);
              if (!GridHeadersGridView.this.adOG) {
                locale.run();
              }
              AppMethodBeat.o(142795);
            }
          };
          this.mHandler.postDelayed(this.adTw, ViewConfiguration.getPressedStateDuration());
          i = 1;
          break;
        }
        label561:
        this.wS = -1;
      }
      label574:
      while (this.adOG)
      {
        MMHandler localMMHandler;
        this.wS = -1;
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
    return this.afvI;
  }
  
  public boolean getStickyHeaderIsTranscluent()
  {
    return !this.afvL;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142808);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    a.c("com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    this.vT.onItemClick(paramAdapterView, paramView, this.afvJ.aDR(paramInt).mPosition, paramLong);
    a.a(this, "com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(142808);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142809);
    boolean bool = this.aeaB.onItemLongClick(paramAdapterView, paramView, this.afvJ.aDR(paramInt).mPosition, paramLong);
    AppMethodBeat.o(142809);
    return bool;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142810);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    a.c("com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    this.gz.onItemSelected(paramAdapterView, paramView, this.afvJ.aDR(paramInt).mPosition, paramLong);
    a.a(this, "com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(142810);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(142832);
    if (this.mNumColumns == -1) {
      if (this.afvz > 0)
      {
        int k = Math.max(View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight(), 0);
        int j = k / this.afvz;
        if (j > 0)
        {
          i = j;
          while ((i != 1) && (this.afvz * i + (i - 1) * this.adOr > k)) {
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
      for (this.afvE = i;; this.afvE = this.mNumColumns)
      {
        if (this.afvJ != null) {
          this.afvJ.setNumColumns(this.afvE);
        }
        jBy();
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(142832);
        return;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AppMethodBeat.i(142811);
    this.gz.onNothingSelected(paramAdapterView);
    AppMethodBeat.o(142811);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(142812);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.afvv = paramParcelable.afvQ;
    requestLayout();
    AppMethodBeat.o(142812);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(142813);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.afvQ = this.afvv;
    AppMethodBeat.o(142813);
    return localSavedState;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142814);
    if (this.RTW != null) {
      this.RTW.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (Build.VERSION.SDK_INT >= 8) {
      aDT(paramInt1);
    }
    AppMethodBeat.o(142814);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(142815);
    if (this.RTW != null) {
      this.RTW.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.mScrollState = paramInt;
    AppMethodBeat.o(142815);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(142817);
    if ((this.afvJ != null) && (this.bxk != null)) {
      this.afvJ.unregisterDataSetObserver(this.bxk);
    }
    if (!this.afvy) {
      this.afvx = true;
    }
    if ((paramListAdapter instanceof b)) {
      paramListAdapter = (b)paramListAdapter;
    }
    for (;;)
    {
      this.afvJ = new c(getContext(), this, paramListAdapter);
      this.afvJ.registerDataSetObserver(this.bxk);
      reset();
      super.setAdapter(this.afvJ);
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
    if (paramBoolean != this.afvv)
    {
      this.afvv = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(142818);
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(142819);
    super.setClipToPadding(paramBoolean);
    this.afvx = paramBoolean;
    this.afvy = true;
    AppMethodBeat.o(142819);
  }
  
  public void setColumnWidth(int paramInt)
  {
    AppMethodBeat.i(142820);
    super.setColumnWidth(paramInt);
    this.afvz = paramInt;
    AppMethodBeat.o(142820);
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    AppMethodBeat.i(142821);
    super.setHorizontalSpacing(paramInt);
    this.adOr = paramInt;
    AppMethodBeat.o(142821);
  }
  
  public void setNumColumns(int paramInt)
  {
    AppMethodBeat.i(142822);
    super.setNumColumns(paramInt);
    this.afvD = true;
    this.mNumColumns = paramInt;
    if ((paramInt != -1) && (this.afvJ != null)) {
      this.afvJ.setNumColumns(paramInt);
    }
    AppMethodBeat.o(142822);
  }
  
  public void setOnHeaderClickListener(c paramc)
  {
    this.afvF = paramc;
  }
  
  public void setOnHeaderLongClickListener(d paramd)
  {
    AppMethodBeat.i(142823);
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.afvG = paramd;
    AppMethodBeat.o(142823);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(142824);
    this.vT = paramOnItemClickListener;
    super.setOnItemClickListener(this);
    AppMethodBeat.o(142824);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(142825);
    this.aeaB = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(this);
    AppMethodBeat.o(142825);
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    AppMethodBeat.i(142826);
    this.gz = paramOnItemSelectedListener;
    super.setOnItemSelectedListener(this);
    AppMethodBeat.o(142826);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.RTW = paramOnScrollListener;
  }
  
  public void setStickyHeaderIsTranscluent(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.afvL = paramBoolean;
      return;
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    AppMethodBeat.i(142827);
    super.setVerticalSpacing(paramInt);
    this.adOs = paramInt;
    AppMethodBeat.o(142827);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean afvQ;
    
    static
    {
      AppMethodBeat.i(142803);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(142803);
    }
    
    private SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(142800);
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.afvQ = bool;
        AppMethodBeat.o(142800);
        return;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(142801);
      String str = "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.afvQ + "}";
      AppMethodBeat.o(142801);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(142802);
      super.writeToParcel(paramParcel, paramInt);
      if (this.afvQ) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        AppMethodBeat.o(142802);
        return;
      }
    }
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
      View localView = GridHeadersGridView.this.aDS(GridHeadersGridView.this.afvK);
      boolean bool1;
      if (localView != null)
      {
        GridHeadersGridView.a(GridHeadersGridView.this, GridHeadersGridView.this.afvK);
        if ((!jBB()) || (GridHeadersGridView.this.adOG)) {
          break label156;
        }
        GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
        if (localGridHeadersGridView.afvG == null) {
          break label151;
        }
        bool1 = localGridHeadersGridView.afvG.jBz();
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
          GridHeadersGridView.this.wS = -2;
          GridHeadersGridView.this.setPressed(false);
          localView.setPressed(false);
          AppMethodBeat.o(142796);
          return;
        }
        GridHeadersGridView.this.wS = 2;
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
      if (GridHeadersGridView.this.wS == 0)
      {
        GridHeadersGridView.this.wS = 1;
        View localView = GridHeadersGridView.this.aDS(GridHeadersGridView.this.afvK);
        if ((localView != null) && (!localView.hasFocusable()))
        {
          if (!GridHeadersGridView.this.adOG)
          {
            localView.setPressed(true);
            GridHeadersGridView.this.setPressed(true);
            GridHeadersGridView.this.refreshDrawableState();
            int i = ViewConfiguration.getLongPressTimeout();
            if (GridHeadersGridView.this.isLongClickable())
            {
              if (GridHeadersGridView.this.afvt == null) {
                GridHeadersGridView.this.afvt = new GridHeadersGridView.a(GridHeadersGridView.this, (byte)0);
              }
              GridHeadersGridView.this.afvt.jBA();
              GridHeadersGridView.d(GridHeadersGridView.this).postDelayed(GridHeadersGridView.this.afvt, i);
              AppMethodBeat.o(142797);
              return;
            }
            GridHeadersGridView.this.wS = 2;
            AppMethodBeat.o(142797);
            return;
          }
          GridHeadersGridView.this.wS = 2;
        }
      }
      AppMethodBeat.o(142797);
    }
  }
  
  public static abstract interface c
  {
    public abstract void eR(View paramView);
  }
  
  public static abstract interface d
  {
    public abstract boolean jBz();
  }
  
  final class e
    extends GridHeadersGridView.f
    implements Runnable
  {
    int afvP;
    
    private e()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(142798);
      if (GridHeadersGridView.this.adOG)
      {
        AppMethodBeat.o(142798);
        return;
      }
      if ((GridHeadersGridView.this.afvJ != null) && (GridHeadersGridView.this.afvJ.getCount() > 0) && (this.afvP != -1) && (this.afvP < GridHeadersGridView.this.afvJ.getCount()) && (jBB()))
      {
        View localView = GridHeadersGridView.this.aDS(this.afvP);
        if (localView != null)
        {
          GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
          GridHeadersGridView.a(GridHeadersGridView.this, this.afvP);
          if (localGridHeadersGridView.afvF != null)
          {
            localGridHeadersGridView.playSoundEffect(0);
            if (localView != null) {
              localView.sendAccessibilityEvent(1);
            }
            localGridHeadersGridView.afvF.eR(localView);
          }
        }
      }
      AppMethodBeat.o(142798);
    }
  }
  
  class f
  {
    private int adTB;
    
    private f() {}
    
    public final void jBA()
    {
      AppMethodBeat.i(142804);
      this.adTB = GridHeadersGridView.b(GridHeadersGridView.this);
      AppMethodBeat.o(142804);
    }
    
    public final boolean jBB()
    {
      AppMethodBeat.i(142805);
      if ((GridHeadersGridView.this.hasWindowFocus()) && (GridHeadersGridView.c(GridHeadersGridView.this) == this.adTB))
      {
        AppMethodBeat.o(142805);
        return true;
      }
      AppMethodBeat.o(142805);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView
 * JD-Core Version:    0.7.0.1
 */