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
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.List;

public class GridHeadersGridView
  extends GridView
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private AbsListView.OnScrollListener FcF;
  protected boolean OOC;
  private int OOj;
  private int OOk;
  private Runnable OSV;
  private AdapterView.OnItemLongClickListener OZU;
  private float QkA;
  private boolean QkB;
  private int QkC;
  c QkD;
  d QkE;
  private e QkF;
  private View QkG;
  protected c QkH;
  protected int QkI;
  private boolean QkJ;
  public a Qkr;
  public b Qks;
  private boolean Qkt;
  private final Rect Qku;
  private boolean Qkv;
  private boolean Qkw;
  private int Qkx;
  private long Qky;
  private int Qkz;
  private DataSetObserver Tr;
  private AdapterView.OnItemSelectedListener Yj;
  private AdapterView.OnItemClickListener awr;
  protected int ayc;
  private MMHandler mHandler;
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
    this.mHandler = new MMHandler();
    this.Qkt = true;
    this.Qku = new Rect();
    this.Qky = -1L;
    this.Tr = new DataSetObserver()
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
    this.QkC = 1;
    this.mScrollState = 0;
    this.QkJ = true;
    super.setOnScrollListener(this);
    setVerticalFadingEdgeEnabled(false);
    if (!this.QkB) {
      this.mNumColumns = -1;
    }
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(142806);
  }
  
  private void aog(int paramInt)
  {
    AppMethodBeat.i(142830);
    if ((this.QkH == null) || (this.QkH.getCount() == 0) || (!this.Qkt))
    {
      AppMethodBeat.o(142830);
      return;
    }
    if ((c.d)getChildAt(0) == null)
    {
      AppMethodBeat.o(142830);
      return;
    }
    int j = paramInt - this.QkC;
    int i = j;
    if (j < 0) {
      i = paramInt;
    }
    int k = this.QkC + paramInt;
    j = k;
    if (k >= this.QkH.getCount()) {
      j = paramInt;
    }
    long l;
    Object localObject;
    label198:
    c.d locald;
    if (this.OOk != 0) {
      if (this.OOk < 0)
      {
        this.QkH.EQ(paramInt);
        if (getChildAt(this.QkC).getTop() <= 0)
        {
          l = this.QkH.EQ(j);
          i = j;
          if (this.Qky != l)
          {
            this.QkG = this.QkH.a(i, this.QkG, this);
            gWt();
            this.Qky = l;
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
          if (!this.Qkv) {
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
      k += this.QkC;
      i = j;
      break label198;
      l = this.QkH.EQ(paramInt);
      i = paramInt;
      break;
      j = getChildAt(0).getTop();
      if ((j > 0) && (j < this.OOk))
      {
        l = this.QkH.EQ(i);
        break;
      }
      l = this.QkH.EQ(paramInt);
      i = paramInt;
      break;
      label336:
      j = locald.getTop();
      break label234;
      label345:
      i = getHeaderHeight();
      if (localObject != null)
      {
        if ((paramInt == 0) && (super.getChildAt(0).getTop() > 0) && (!this.Qkv))
        {
          this.Qkz = 0;
          AppMethodBeat.o(142830);
          return;
        }
        if (this.Qkv)
        {
          this.Qkz = Math.min(localObject.getTop(), getPaddingTop() + i);
          if (this.Qkz < getPaddingTop()) {}
          for (paramInt = i + getPaddingTop();; paramInt = this.Qkz)
          {
            this.Qkz = paramInt;
            AppMethodBeat.o(142830);
            return;
          }
        }
        this.Qkz = Math.min(localObject.getTop(), i);
        if (this.Qkz < 0) {}
        for (paramInt = i;; paramInt = this.Qkz)
        {
          this.Qkz = paramInt;
          AppMethodBeat.o(142830);
          return;
        }
      }
      this.Qkz = i;
      if (this.Qkv) {
        this.Qkz += getPaddingTop();
      }
      label516:
      AppMethodBeat.o(142830);
      return;
      label522:
      j = i;
    }
  }
  
  private void gWt()
  {
    AppMethodBeat.i(142829);
    if (this.QkG == null)
    {
      AppMethodBeat.o(142829);
      return;
    }
    int j = View.MeasureSpec.makeMeasureSpec(getWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
    ViewGroup.LayoutParams localLayoutParams = this.QkG.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height > 0)) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      this.QkG.measure(j, i);
      this.QkG.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.QkG.getMeasuredHeight());
      AppMethodBeat.o(142829);
      return;
    }
  }
  
  private int getHeaderHeight()
  {
    AppMethodBeat.i(142828);
    if (this.QkG != null)
    {
      int i = this.QkG.getMeasuredHeight();
      AppMethodBeat.o(142828);
      return i;
    }
    AppMethodBeat.o(142828);
    return 0;
  }
  
  private void reset()
  {
    this.Qkz = 0;
    this.QkG = null;
    this.Qky = -9223372036854775808L;
  }
  
  public final View aof(int paramInt)
  {
    AppMethodBeat.i(142807);
    View localView;
    if (paramInt == -2)
    {
      localView = this.QkG;
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
      aog(getFirstVisiblePosition());
    }
    if ((this.QkG != null) && (this.Qkt) && (this.QkG.getVisibility() == 0)) {}
    int m;
    int n;
    ArrayList localArrayList;
    int k;
    for (int i = 1;; i = 0)
    {
      m = getHeaderHeight();
      n = this.Qkz - m;
      if ((i != 0) && (this.QkJ))
      {
        this.Qku.left = getPaddingLeft();
        this.Qku.right = (getWidth() - getPaddingRight());
        this.Qku.top = this.Qkz;
        this.Qku.bottom = getHeight();
        paramCanvas.save();
        paramCanvas.clipRect(this.Qku);
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
        k += this.QkC;
        j += this.QkC;
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
          if ((((c.b)locald.getChildAt(0)).getHeaderId() == this.Qky) && (locald.getTop() < 0) && (this.Qkt))
          {
            k = 1;
            if ((localView.getVisibility() == 0) && (k == 0))
            {
              localView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight()), View.MeasureSpec.makeMeasureSpec(0, 0));
              localView.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), locald.getHeight());
              this.Qku.left = getPaddingLeft();
              this.Qku.right = (getWidth() - getPaddingRight());
              this.Qku.bottom = locald.getBottom();
              this.Qku.top = locald.getTop();
              paramCanvas.save();
              paramCanvas.clipRect(this.Qku);
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
    if ((i != 0) && (this.QkJ))
    {
      paramCanvas.restore();
      if (this.QkG.getWidth() != getWidth() - getPaddingLeft() - getPaddingRight())
      {
        i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight());
        j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.QkG.measure(i, j);
        this.QkG.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.QkG.getHeight());
      }
      this.Qku.left = getPaddingLeft();
      this.Qku.right = (getWidth() - getPaddingRight());
      this.Qku.bottom = (n + m);
      if (!this.Qkv) {
        break label741;
      }
    }
    label741:
    for (this.Qku.top = getPaddingTop();; this.Qku.top = 0)
    {
      paramCanvas.save();
      paramCanvas.clipRect(this.Qku);
      paramCanvas.translate(getPaddingLeft(), n);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), (int)(255.0F * this.Qkz / m), 31);
      this.QkG.draw(paramCanvas);
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
      if (this.Qks == null) {
        this.Qks = new b();
      }
      this.mHandler.postDelayed(this.Qkr, ViewConfiguration.getTapTimeout());
      i = (int)paramMotionEvent.getY();
      this.QkA = i;
      float f = i;
      if ((this.QkG != null) && (f <= this.QkG.getBottom())) {}
      for (;;)
      {
        this.QkI = j;
        if ((this.QkI == -1) || (this.mScrollState == 2)) {
          break;
        }
        this.ayc = 0;
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
          k += this.QkC;
          i += this.QkC;
        }
        label247:
        j = -1;
      }
      if ((this.QkI == -1) || (Math.abs(paramMotionEvent.getY() - this.QkA) <= this.mTouchSlop)) {
        break;
      }
      this.ayc = -1;
      Object localObject = aof(this.QkI);
      if (localObject != null) {
        ((View)localObject).setPressed(false);
      }
      if (this.Qkr != null) {
        this.mHandler.removeCallbacks(this.Qkr);
      }
      this.QkI = -1;
      break;
      if ((this.ayc == -2) || (this.ayc == -1) || (this.QkI == -1)) {
        break;
      }
      final View localView = aof(this.QkI);
      final e locale;
      if ((localView != null) && (!localView.hasFocusable()))
      {
        if (this.ayc != 0) {
          localView.setPressed(false);
        }
        if (this.QkF == null) {
          this.QkF = new e((byte)0);
        }
        locale = this.QkF;
        locale.QkN = this.QkI;
        locale.gWv();
        if ((this.ayc == 0) && (this.ayc == 1)) {
          break label574;
        }
        localMMHandler = this.mHandler;
        if (this.ayc == 0) {}
        for (localObject = this.Qks;; localObject = this.Qkr)
        {
          localMMHandler.removeCallbacks((Runnable)localObject);
          if (this.OOC) {
            break label561;
          }
          this.ayc = 1;
          localView.setPressed(true);
          setPressed(true);
          if (this.OSV != null) {
            removeCallbacks(this.OSV);
          }
          this.OSV = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142795);
              GridHeadersGridView.this.ayc = -1;
              localView.setPressed(false);
              GridHeadersGridView.this.setPressed(false);
              if (!GridHeadersGridView.this.OOC) {
                locale.run();
              }
              AppMethodBeat.o(142795);
            }
          };
          this.mHandler.postDelayed(this.OSV, ViewConfiguration.getPressedStateDuration());
          i = 1;
          break;
        }
        label561:
        this.ayc = -1;
      }
      label574:
      while (this.OOC)
      {
        MMHandler localMMHandler;
        this.ayc = -1;
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
    return this.QkG;
  }
  
  public boolean getStickyHeaderIsTranscluent()
  {
    return !this.QkJ;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142808);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    a.b("com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    this.awr.onItemClick(paramAdapterView, paramView, this.QkH.aoe(paramInt).mPosition, paramLong);
    a.a(this, "com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(142808);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142809);
    boolean bool = this.OZU.onItemLongClick(paramAdapterView, paramView, this.QkH.aoe(paramInt).mPosition, paramLong);
    AppMethodBeat.o(142809);
    return bool;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142810);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    a.b("com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    this.Yj.onItemSelected(paramAdapterView, paramView, this.QkH.aoe(paramInt).mPosition, paramLong);
    a.a(this, "com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(142810);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(142832);
    if (this.mNumColumns == -1) {
      if (this.Qkx > 0)
      {
        int k = Math.max(View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight(), 0);
        int j = k / this.Qkx;
        if (j > 0)
        {
          i = j;
          while ((i != 1) && (this.Qkx * i + (i - 1) * this.OOj > k)) {
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
      for (this.QkC = i;; this.QkC = this.mNumColumns)
      {
        if (this.QkH != null) {
          this.QkH.setNumColumns(this.QkC);
        }
        gWt();
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(142832);
        return;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AppMethodBeat.i(142811);
    this.Yj.onNothingSelected(paramAdapterView);
    AppMethodBeat.o(142811);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(142812);
    paramParcelable = (GridHeadersGridView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.Qkt = paramParcelable.QkO;
    requestLayout();
    AppMethodBeat.o(142812);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(142813);
    GridHeadersGridView.SavedState localSavedState = new GridHeadersGridView.SavedState(super.onSaveInstanceState());
    localSavedState.QkO = this.Qkt;
    AppMethodBeat.o(142813);
    return localSavedState;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142814);
    if (this.FcF != null) {
      this.FcF.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (Build.VERSION.SDK_INT >= 8) {
      aog(paramInt1);
    }
    AppMethodBeat.o(142814);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(142815);
    if (this.FcF != null) {
      this.FcF.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.mScrollState = paramInt;
    AppMethodBeat.o(142815);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(142817);
    if ((this.QkH != null) && (this.Tr != null)) {
      this.QkH.unregisterDataSetObserver(this.Tr);
    }
    if (!this.Qkw) {
      this.Qkv = true;
    }
    if ((paramListAdapter instanceof b)) {
      paramListAdapter = (b)paramListAdapter;
    }
    for (;;)
    {
      this.QkH = new c(getContext(), this, paramListAdapter);
      this.QkH.registerDataSetObserver(this.Tr);
      reset();
      super.setAdapter(this.QkH);
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
    if (paramBoolean != this.Qkt)
    {
      this.Qkt = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(142818);
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(142819);
    super.setClipToPadding(paramBoolean);
    this.Qkv = paramBoolean;
    this.Qkw = true;
    AppMethodBeat.o(142819);
  }
  
  public void setColumnWidth(int paramInt)
  {
    AppMethodBeat.i(142820);
    super.setColumnWidth(paramInt);
    this.Qkx = paramInt;
    AppMethodBeat.o(142820);
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    AppMethodBeat.i(142821);
    super.setHorizontalSpacing(paramInt);
    this.OOj = paramInt;
    AppMethodBeat.o(142821);
  }
  
  public void setNumColumns(int paramInt)
  {
    AppMethodBeat.i(142822);
    super.setNumColumns(paramInt);
    this.QkB = true;
    this.mNumColumns = paramInt;
    if ((paramInt != -1) && (this.QkH != null)) {
      this.QkH.setNumColumns(paramInt);
    }
    AppMethodBeat.o(142822);
  }
  
  public void setOnHeaderClickListener(c paramc)
  {
    this.QkD = paramc;
  }
  
  public void setOnHeaderLongClickListener(d paramd)
  {
    AppMethodBeat.i(142823);
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.QkE = paramd;
    AppMethodBeat.o(142823);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(142824);
    this.awr = paramOnItemClickListener;
    super.setOnItemClickListener(this);
    AppMethodBeat.o(142824);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(142825);
    this.OZU = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(this);
    AppMethodBeat.o(142825);
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    AppMethodBeat.i(142826);
    this.Yj = paramOnItemSelectedListener;
    super.setOnItemSelectedListener(this);
    AppMethodBeat.o(142826);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.FcF = paramOnScrollListener;
  }
  
  public void setStickyHeaderIsTranscluent(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.QkJ = paramBoolean;
      return;
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    AppMethodBeat.i(142827);
    super.setVerticalSpacing(paramInt);
    this.OOk = paramInt;
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
      View localView = GridHeadersGridView.this.aof(GridHeadersGridView.this.QkI);
      boolean bool1;
      if (localView != null)
      {
        GridHeadersGridView.a(GridHeadersGridView.this, GridHeadersGridView.this.QkI);
        if ((!gWw()) || (GridHeadersGridView.this.OOC)) {
          break label156;
        }
        GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
        if (localGridHeadersGridView.QkE == null) {
          break label151;
        }
        bool1 = localGridHeadersGridView.QkE.gWu();
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
          GridHeadersGridView.this.ayc = -2;
          GridHeadersGridView.this.setPressed(false);
          localView.setPressed(false);
          AppMethodBeat.o(142796);
          return;
        }
        GridHeadersGridView.this.ayc = 2;
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
      if (GridHeadersGridView.this.ayc == 0)
      {
        GridHeadersGridView.this.ayc = 1;
        View localView = GridHeadersGridView.this.aof(GridHeadersGridView.this.QkI);
        if ((localView != null) && (!localView.hasFocusable()))
        {
          if (!GridHeadersGridView.this.OOC)
          {
            localView.setPressed(true);
            GridHeadersGridView.this.setPressed(true);
            GridHeadersGridView.this.refreshDrawableState();
            int i = ViewConfiguration.getLongPressTimeout();
            if (GridHeadersGridView.this.isLongClickable())
            {
              if (GridHeadersGridView.this.Qkr == null) {
                GridHeadersGridView.this.Qkr = new GridHeadersGridView.a(GridHeadersGridView.this, (byte)0);
              }
              GridHeadersGridView.this.Qkr.gWv();
              GridHeadersGridView.d(GridHeadersGridView.this).postDelayed(GridHeadersGridView.this.Qkr, i);
              AppMethodBeat.o(142797);
              return;
            }
            GridHeadersGridView.this.ayc = 2;
            AppMethodBeat.o(142797);
            return;
          }
          GridHeadersGridView.this.ayc = 2;
        }
      }
      AppMethodBeat.o(142797);
    }
  }
  
  public static abstract interface c
  {
    public abstract void dE(View paramView);
  }
  
  public static abstract interface d
  {
    public abstract boolean gWu();
  }
  
  final class e
    extends GridHeadersGridView.f
    implements Runnable
  {
    int QkN;
    
    private e()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(142798);
      if (GridHeadersGridView.this.OOC)
      {
        AppMethodBeat.o(142798);
        return;
      }
      if ((GridHeadersGridView.this.QkH != null) && (GridHeadersGridView.this.QkH.getCount() > 0) && (this.QkN != -1) && (this.QkN < GridHeadersGridView.this.QkH.getCount()) && (gWw()))
      {
        View localView = GridHeadersGridView.this.aof(this.QkN);
        if (localView != null)
        {
          GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
          GridHeadersGridView.a(GridHeadersGridView.this, this.QkN);
          if (localGridHeadersGridView.QkD != null)
          {
            localGridHeadersGridView.playSoundEffect(0);
            if (localView != null) {
              localView.sendAccessibilityEvent(1);
            }
            localGridHeadersGridView.QkD.dE(localView);
          }
        }
      }
      AppMethodBeat.o(142798);
    }
  }
  
  class f
  {
    private int OTb;
    
    private f() {}
    
    public final void gWv()
    {
      AppMethodBeat.i(142804);
      this.OTb = GridHeadersGridView.b(GridHeadersGridView.this);
      AppMethodBeat.o(142804);
    }
    
    public final boolean gWw()
    {
      AppMethodBeat.i(142805);
      if ((GridHeadersGridView.this.hasWindowFocus()) && (GridHeadersGridView.c(GridHeadersGridView.this) == this.OTb))
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