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
  private AbsListView.OnScrollListener Lrb;
  private DataSetObserver QT;
  protected boolean WhJ;
  private int Whu;
  private int Whv;
  private Runnable Wmi;
  private AdapterView.OnItemLongClickListener Wth;
  public a XHN;
  public b XHO;
  private boolean XHP;
  private final Rect XHQ;
  private boolean XHR;
  private boolean XHS;
  private int XHT;
  private long XHU;
  private int XHV;
  private float XHW;
  private boolean XHX;
  private int XHY;
  c XHZ;
  d XIa;
  private e XIb;
  private View XIc;
  protected c XId;
  protected int XIe;
  private boolean XIf;
  private AdapterView.OnItemSelectedListener fE;
  private MMHandler mHandler;
  private int mNumColumns;
  private int mScrollState;
  private int mTouchSlop;
  private AdapterView.OnItemClickListener uX;
  protected int vW;
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842865);
  }
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142806);
    this.mHandler = new MMHandler();
    this.XHP = true;
    this.XHQ = new Rect();
    this.XHU = -1L;
    this.QT = new DataSetObserver()
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
    this.XHY = 1;
    this.mScrollState = 0;
    this.XIf = true;
    super.setOnScrollListener(this);
    setVerticalFadingEdgeEnabled(false);
    if (!this.XHX) {
      this.mNumColumns = -1;
    }
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(142806);
  }
  
  private void axl(int paramInt)
  {
    AppMethodBeat.i(142830);
    if ((this.XId == null) || (this.XId.getCount() == 0) || (!this.XHP))
    {
      AppMethodBeat.o(142830);
      return;
    }
    if ((c.d)getChildAt(0) == null)
    {
      AppMethodBeat.o(142830);
      return;
    }
    int j = paramInt - this.XHY;
    int i = j;
    if (j < 0) {
      i = paramInt;
    }
    int k = this.XHY + paramInt;
    j = k;
    if (k >= this.XId.getCount()) {
      j = paramInt;
    }
    long l;
    Object localObject;
    label198:
    c.d locald;
    if (this.Whv != 0) {
      if (this.Whv < 0)
      {
        this.XId.Ix(paramInt);
        if (getChildAt(this.XHY).getTop() <= 0)
        {
          l = this.XId.Ix(j);
          i = j;
          if (this.XHU != l)
          {
            this.XIc = this.XId.a(i, this.XIc, this);
            hXb();
            this.XHU = l;
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
          if (!this.XHR) {
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
      k += this.XHY;
      i = j;
      break label198;
      l = this.XId.Ix(paramInt);
      i = paramInt;
      break;
      j = getChildAt(0).getTop();
      if ((j > 0) && (j < this.Whv))
      {
        l = this.XId.Ix(i);
        break;
      }
      l = this.XId.Ix(paramInt);
      i = paramInt;
      break;
      label336:
      j = locald.getTop();
      break label234;
      label345:
      i = getHeaderHeight();
      if (localObject != null)
      {
        if ((paramInt == 0) && (super.getChildAt(0).getTop() > 0) && (!this.XHR))
        {
          this.XHV = 0;
          AppMethodBeat.o(142830);
          return;
        }
        if (this.XHR)
        {
          this.XHV = Math.min(localObject.getTop(), getPaddingTop() + i);
          if (this.XHV < getPaddingTop()) {}
          for (paramInt = i + getPaddingTop();; paramInt = this.XHV)
          {
            this.XHV = paramInt;
            AppMethodBeat.o(142830);
            return;
          }
        }
        this.XHV = Math.min(localObject.getTop(), i);
        if (this.XHV < 0) {}
        for (paramInt = i;; paramInt = this.XHV)
        {
          this.XHV = paramInt;
          AppMethodBeat.o(142830);
          return;
        }
      }
      this.XHV = i;
      if (this.XHR) {
        this.XHV += getPaddingTop();
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
    if (this.XIc != null)
    {
      int i = this.XIc.getMeasuredHeight();
      AppMethodBeat.o(142828);
      return i;
    }
    AppMethodBeat.o(142828);
    return 0;
  }
  
  private void hXb()
  {
    AppMethodBeat.i(142829);
    if (this.XIc == null)
    {
      AppMethodBeat.o(142829);
      return;
    }
    int j = View.MeasureSpec.makeMeasureSpec(getWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
    ViewGroup.LayoutParams localLayoutParams = this.XIc.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height > 0)) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      this.XIc.measure(j, i);
      this.XIc.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.XIc.getMeasuredHeight());
      AppMethodBeat.o(142829);
      return;
    }
  }
  
  private void reset()
  {
    this.XHV = 0;
    this.XIc = null;
    this.XHU = -9223372036854775808L;
  }
  
  public final View axk(int paramInt)
  {
    AppMethodBeat.i(142807);
    View localView;
    if (paramInt == -2)
    {
      localView = this.XIc;
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
      axl(getFirstVisiblePosition());
    }
    if ((this.XIc != null) && (this.XHP) && (this.XIc.getVisibility() == 0)) {}
    int m;
    int n;
    ArrayList localArrayList;
    int k;
    for (int i = 1;; i = 0)
    {
      m = getHeaderHeight();
      n = this.XHV - m;
      if ((i != 0) && (this.XIf))
      {
        this.XHQ.left = getPaddingLeft();
        this.XHQ.right = (getWidth() - getPaddingRight());
        this.XHQ.top = this.XHV;
        this.XHQ.bottom = getHeight();
        paramCanvas.save();
        paramCanvas.clipRect(this.XHQ);
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
        k += this.XHY;
        j += this.XHY;
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
          if ((((c.b)locald.getChildAt(0)).getHeaderId() == this.XHU) && (locald.getTop() < 0) && (this.XHP))
          {
            k = 1;
            if ((localView.getVisibility() == 0) && (k == 0))
            {
              localView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight()), View.MeasureSpec.makeMeasureSpec(0, 0));
              localView.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), locald.getHeight());
              this.XHQ.left = getPaddingLeft();
              this.XHQ.right = (getWidth() - getPaddingRight());
              this.XHQ.bottom = locald.getBottom();
              this.XHQ.top = locald.getTop();
              paramCanvas.save();
              paramCanvas.clipRect(this.XHQ);
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
    if ((i != 0) && (this.XIf))
    {
      paramCanvas.restore();
      if (this.XIc.getWidth() != getWidth() - getPaddingLeft() - getPaddingRight())
      {
        i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight());
        j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.XIc.measure(i, j);
        this.XIc.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.XIc.getHeight());
      }
      this.XHQ.left = getPaddingLeft();
      this.XHQ.right = (getWidth() - getPaddingRight());
      this.XHQ.bottom = (n + m);
      if (!this.XHR) {
        break label741;
      }
    }
    label741:
    for (this.XHQ.top = getPaddingTop();; this.XHQ.top = 0)
    {
      paramCanvas.save();
      paramCanvas.clipRect(this.XHQ);
      paramCanvas.translate(getPaddingLeft(), n);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), (int)(255.0F * this.XHV / m), 31);
      this.XIc.draw(paramCanvas);
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
      if (this.XHO == null) {
        this.XHO = new b();
      }
      this.mHandler.postDelayed(this.XHN, ViewConfiguration.getTapTimeout());
      i = (int)paramMotionEvent.getY();
      this.XHW = i;
      float f = i;
      if ((this.XIc != null) && (f <= this.XIc.getBottom())) {}
      for (;;)
      {
        this.XIe = j;
        if ((this.XIe == -1) || (this.mScrollState == 2)) {
          break;
        }
        this.vW = 0;
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
          k += this.XHY;
          i += this.XHY;
        }
        label247:
        j = -1;
      }
      if ((this.XIe == -1) || (Math.abs(paramMotionEvent.getY() - this.XHW) <= this.mTouchSlop)) {
        break;
      }
      this.vW = -1;
      Object localObject = axk(this.XIe);
      if (localObject != null) {
        ((View)localObject).setPressed(false);
      }
      if (this.XHN != null) {
        this.mHandler.removeCallbacks(this.XHN);
      }
      this.XIe = -1;
      break;
      if ((this.vW == -2) || (this.vW == -1) || (this.XIe == -1)) {
        break;
      }
      final View localView = axk(this.XIe);
      final e locale;
      if ((localView != null) && (!localView.hasFocusable()))
      {
        if (this.vW != 0) {
          localView.setPressed(false);
        }
        if (this.XIb == null) {
          this.XIb = new e((byte)0);
        }
        locale = this.XIb;
        locale.XIj = this.XIe;
        locale.hXd();
        if ((this.vW == 0) && (this.vW == 1)) {
          break label574;
        }
        localMMHandler = this.mHandler;
        if (this.vW == 0) {}
        for (localObject = this.XHO;; localObject = this.XHN)
        {
          localMMHandler.removeCallbacks((Runnable)localObject);
          if (this.WhJ) {
            break label561;
          }
          this.vW = 1;
          localView.setPressed(true);
          setPressed(true);
          if (this.Wmi != null) {
            removeCallbacks(this.Wmi);
          }
          this.Wmi = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142795);
              GridHeadersGridView.this.vW = -1;
              localView.setPressed(false);
              GridHeadersGridView.this.setPressed(false);
              if (!GridHeadersGridView.this.WhJ) {
                locale.run();
              }
              AppMethodBeat.o(142795);
            }
          };
          this.mHandler.postDelayed(this.Wmi, ViewConfiguration.getPressedStateDuration());
          i = 1;
          break;
        }
        label561:
        this.vW = -1;
      }
      label574:
      while (this.WhJ)
      {
        MMHandler localMMHandler;
        this.vW = -1;
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
    return this.XIc;
  }
  
  public boolean getStickyHeaderIsTranscluent()
  {
    return !this.XIf;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142808);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    a.c("com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    this.uX.onItemClick(paramAdapterView, paramView, this.XId.axj(paramInt).mPosition, paramLong);
    a.a(this, "com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(142808);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142809);
    boolean bool = this.Wth.onItemLongClick(paramAdapterView, paramView, this.XId.axj(paramInt).mPosition, paramLong);
    AppMethodBeat.o(142809);
    return bool;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142810);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    a.c("com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    this.fE.onItemSelected(paramAdapterView, paramView, this.XId.axj(paramInt).mPosition, paramLong);
    a.a(this, "com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(142810);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(142832);
    if (this.mNumColumns == -1) {
      if (this.XHT > 0)
      {
        int k = Math.max(View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight(), 0);
        int j = k / this.XHT;
        if (j > 0)
        {
          i = j;
          while ((i != 1) && (this.XHT * i + (i - 1) * this.Whu > k)) {
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
      for (this.XHY = i;; this.XHY = this.mNumColumns)
      {
        if (this.XId != null) {
          this.XId.setNumColumns(this.XHY);
        }
        hXb();
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(142832);
        return;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AppMethodBeat.i(142811);
    this.fE.onNothingSelected(paramAdapterView);
    AppMethodBeat.o(142811);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(142812);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.XHP = paramParcelable.XIk;
    requestLayout();
    AppMethodBeat.o(142812);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(142813);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.XIk = this.XHP;
    AppMethodBeat.o(142813);
    return localSavedState;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142814);
    if (this.Lrb != null) {
      this.Lrb.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (Build.VERSION.SDK_INT >= 8) {
      axl(paramInt1);
    }
    AppMethodBeat.o(142814);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(142815);
    if (this.Lrb != null) {
      this.Lrb.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.mScrollState = paramInt;
    AppMethodBeat.o(142815);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(142817);
    if ((this.XId != null) && (this.QT != null)) {
      this.XId.unregisterDataSetObserver(this.QT);
    }
    if (!this.XHS) {
      this.XHR = true;
    }
    if ((paramListAdapter instanceof b)) {
      paramListAdapter = (b)paramListAdapter;
    }
    for (;;)
    {
      this.XId = new c(getContext(), this, paramListAdapter);
      this.XId.registerDataSetObserver(this.QT);
      reset();
      super.setAdapter(this.XId);
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
    if (paramBoolean != this.XHP)
    {
      this.XHP = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(142818);
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(142819);
    super.setClipToPadding(paramBoolean);
    this.XHR = paramBoolean;
    this.XHS = true;
    AppMethodBeat.o(142819);
  }
  
  public void setColumnWidth(int paramInt)
  {
    AppMethodBeat.i(142820);
    super.setColumnWidth(paramInt);
    this.XHT = paramInt;
    AppMethodBeat.o(142820);
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    AppMethodBeat.i(142821);
    super.setHorizontalSpacing(paramInt);
    this.Whu = paramInt;
    AppMethodBeat.o(142821);
  }
  
  public void setNumColumns(int paramInt)
  {
    AppMethodBeat.i(142822);
    super.setNumColumns(paramInt);
    this.XHX = true;
    this.mNumColumns = paramInt;
    if ((paramInt != -1) && (this.XId != null)) {
      this.XId.setNumColumns(paramInt);
    }
    AppMethodBeat.o(142822);
  }
  
  public void setOnHeaderClickListener(c paramc)
  {
    this.XHZ = paramc;
  }
  
  public void setOnHeaderLongClickListener(d paramd)
  {
    AppMethodBeat.i(142823);
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.XIa = paramd;
    AppMethodBeat.o(142823);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(142824);
    this.uX = paramOnItemClickListener;
    super.setOnItemClickListener(this);
    AppMethodBeat.o(142824);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(142825);
    this.Wth = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(this);
    AppMethodBeat.o(142825);
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    AppMethodBeat.i(142826);
    this.fE = paramOnItemSelectedListener;
    super.setOnItemSelectedListener(this);
    AppMethodBeat.o(142826);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.Lrb = paramOnScrollListener;
  }
  
  public void setStickyHeaderIsTranscluent(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.XIf = paramBoolean;
      return;
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    AppMethodBeat.i(142827);
    super.setVerticalSpacing(paramInt);
    this.Whv = paramInt;
    AppMethodBeat.o(142827);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean XIk;
    
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
        this.XIk = bool;
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
      String str = "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.XIk + "}";
      AppMethodBeat.o(142801);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(142802);
      super.writeToParcel(paramParcel, paramInt);
      if (this.XIk) {}
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
      View localView = GridHeadersGridView.this.axk(GridHeadersGridView.this.XIe);
      boolean bool1;
      if (localView != null)
      {
        GridHeadersGridView.a(GridHeadersGridView.this, GridHeadersGridView.this.XIe);
        if ((!hXe()) || (GridHeadersGridView.this.WhJ)) {
          break label156;
        }
        GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
        if (localGridHeadersGridView.XIa == null) {
          break label151;
        }
        bool1 = localGridHeadersGridView.XIa.hXc();
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
          GridHeadersGridView.this.vW = -2;
          GridHeadersGridView.this.setPressed(false);
          localView.setPressed(false);
          AppMethodBeat.o(142796);
          return;
        }
        GridHeadersGridView.this.vW = 2;
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
      if (GridHeadersGridView.this.vW == 0)
      {
        GridHeadersGridView.this.vW = 1;
        View localView = GridHeadersGridView.this.axk(GridHeadersGridView.this.XIe);
        if ((localView != null) && (!localView.hasFocusable()))
        {
          if (!GridHeadersGridView.this.WhJ)
          {
            localView.setPressed(true);
            GridHeadersGridView.this.setPressed(true);
            GridHeadersGridView.this.refreshDrawableState();
            int i = ViewConfiguration.getLongPressTimeout();
            if (GridHeadersGridView.this.isLongClickable())
            {
              if (GridHeadersGridView.this.XHN == null) {
                GridHeadersGridView.this.XHN = new GridHeadersGridView.a(GridHeadersGridView.this, (byte)0);
              }
              GridHeadersGridView.this.XHN.hXd();
              GridHeadersGridView.d(GridHeadersGridView.this).postDelayed(GridHeadersGridView.this.XHN, i);
              AppMethodBeat.o(142797);
              return;
            }
            GridHeadersGridView.this.vW = 2;
            AppMethodBeat.o(142797);
            return;
          }
          GridHeadersGridView.this.vW = 2;
        }
      }
      AppMethodBeat.o(142797);
    }
  }
  
  public static abstract interface c
  {
    public abstract void ec(View paramView);
  }
  
  public static abstract interface d
  {
    public abstract boolean hXc();
  }
  
  final class e
    extends GridHeadersGridView.f
    implements Runnable
  {
    int XIj;
    
    private e()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(142798);
      if (GridHeadersGridView.this.WhJ)
      {
        AppMethodBeat.o(142798);
        return;
      }
      if ((GridHeadersGridView.this.XId != null) && (GridHeadersGridView.this.XId.getCount() > 0) && (this.XIj != -1) && (this.XIj < GridHeadersGridView.this.XId.getCount()) && (hXe()))
      {
        View localView = GridHeadersGridView.this.axk(this.XIj);
        if (localView != null)
        {
          GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
          GridHeadersGridView.a(GridHeadersGridView.this, this.XIj);
          if (localGridHeadersGridView.XHZ != null)
          {
            localGridHeadersGridView.playSoundEffect(0);
            if (localView != null) {
              localView.sendAccessibilityEvent(1);
            }
            localGridHeadersGridView.XHZ.ec(localView);
          }
        }
      }
      AppMethodBeat.o(142798);
    }
  }
  
  class f
  {
    private int Wmo;
    
    private f() {}
    
    public final void hXd()
    {
      AppMethodBeat.i(142804);
      this.Wmo = GridHeadersGridView.b(GridHeadersGridView.this);
      AppMethodBeat.o(142804);
    }
    
    public final boolean hXe()
    {
      AppMethodBeat.i(142805);
      if ((GridHeadersGridView.this.hasWindowFocus()) && (GridHeadersGridView.c(GridHeadersGridView.this) == this.Wmo))
      {
        AppMethodBeat.o(142805);
        return true;
      }
      AppMethodBeat.o(142805);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView
 * JD-Core Version:    0.7.0.1
 */