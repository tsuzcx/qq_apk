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
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.List;

public class GridHeadersGridView
  extends GridView
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private AbsListView.OnScrollListener AAD;
  private int JiD;
  private int JiE;
  protected boolean JiW;
  private Runnable Jnn;
  private AdapterView.OnItemLongClickListener JtZ;
  public a KAH;
  public b KAI;
  private boolean KAJ;
  private final Rect KAK;
  private boolean KAL;
  private boolean KAM;
  private int KAN;
  private long KAO;
  private int KAP;
  private float KAQ;
  private boolean KAR;
  private int KAS;
  GridHeadersGridView.c KAT;
  d KAU;
  private e KAV;
  private View KAW;
  protected c KAX;
  protected int KAY;
  private boolean KAZ;
  private DataSetObserver Tf;
  private AdapterView.OnItemSelectedListener XW;
  private AdapterView.OnItemClickListener awt;
  protected int aye;
  private ap mHandler;
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
    this.mHandler = new ap();
    this.KAJ = true;
    this.KAK = new Rect();
    this.KAO = -1L;
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
    this.KAS = 1;
    this.mScrollState = 0;
    this.KAZ = true;
    super.setOnScrollListener(this);
    setVerticalFadingEdgeEnabled(false);
    if (!this.KAR) {
      this.mNumColumns = -1;
    }
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(142806);
  }
  
  private void aeN(int paramInt)
  {
    AppMethodBeat.i(142830);
    if ((this.KAX == null) || (this.KAX.getCount() == 0) || (!this.KAJ))
    {
      AppMethodBeat.o(142830);
      return;
    }
    if ((c.d)getChildAt(0) == null)
    {
      AppMethodBeat.o(142830);
      return;
    }
    int j = paramInt - this.KAS;
    int i = j;
    if (j < 0) {
      i = paramInt;
    }
    int k = this.KAS + paramInt;
    j = k;
    if (k >= this.KAX.getCount()) {
      j = paramInt;
    }
    long l;
    Object localObject;
    label198:
    c.d locald;
    if (this.JiE != 0) {
      if (this.JiE < 0)
      {
        this.KAX.AW(paramInt);
        if (getChildAt(this.KAS).getTop() <= 0)
        {
          l = this.KAX.AW(j);
          i = j;
          if (this.KAO != l)
          {
            this.KAW = this.KAX.a(i, this.KAW, this);
            fJI();
            this.KAO = l;
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
          if (!this.KAL) {
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
      k += this.KAS;
      i = j;
      break label198;
      l = this.KAX.AW(paramInt);
      i = paramInt;
      break;
      j = getChildAt(0).getTop();
      if ((j > 0) && (j < this.JiE))
      {
        l = this.KAX.AW(i);
        break;
      }
      l = this.KAX.AW(paramInt);
      i = paramInt;
      break;
      label336:
      j = locald.getTop();
      break label234;
      label345:
      i = getHeaderHeight();
      if (localObject != null)
      {
        if ((paramInt == 0) && (super.getChildAt(0).getTop() > 0) && (!this.KAL))
        {
          this.KAP = 0;
          AppMethodBeat.o(142830);
          return;
        }
        if (this.KAL)
        {
          this.KAP = Math.min(localObject.getTop(), getPaddingTop() + i);
          if (this.KAP < getPaddingTop()) {}
          for (paramInt = i + getPaddingTop();; paramInt = this.KAP)
          {
            this.KAP = paramInt;
            AppMethodBeat.o(142830);
            return;
          }
        }
        this.KAP = Math.min(localObject.getTop(), i);
        if (this.KAP < 0) {}
        for (paramInt = i;; paramInt = this.KAP)
        {
          this.KAP = paramInt;
          AppMethodBeat.o(142830);
          return;
        }
      }
      this.KAP = i;
      if (this.KAL) {
        this.KAP += getPaddingTop();
      }
      label516:
      AppMethodBeat.o(142830);
      return;
      label522:
      j = i;
    }
  }
  
  private void fJI()
  {
    AppMethodBeat.i(142829);
    if (this.KAW == null)
    {
      AppMethodBeat.o(142829);
      return;
    }
    int j = View.MeasureSpec.makeMeasureSpec(getWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
    ViewGroup.LayoutParams localLayoutParams = this.KAW.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height > 0)) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      this.KAW.measure(j, i);
      this.KAW.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.KAW.getMeasuredHeight());
      AppMethodBeat.o(142829);
      return;
    }
  }
  
  private int getHeaderHeight()
  {
    AppMethodBeat.i(142828);
    if (this.KAW != null)
    {
      int i = this.KAW.getMeasuredHeight();
      AppMethodBeat.o(142828);
      return i;
    }
    AppMethodBeat.o(142828);
    return 0;
  }
  
  private void reset()
  {
    this.KAP = 0;
    this.KAW = null;
    this.KAO = -9223372036854775808L;
  }
  
  public final View aeM(int paramInt)
  {
    AppMethodBeat.i(142807);
    View localView;
    if (paramInt == -2)
    {
      localView = this.KAW;
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
      aeN(getFirstVisiblePosition());
    }
    if ((this.KAW != null) && (this.KAJ) && (this.KAW.getVisibility() == 0)) {}
    int m;
    int n;
    ArrayList localArrayList;
    int k;
    for (int i = 1;; i = 0)
    {
      m = getHeaderHeight();
      n = this.KAP - m;
      if ((i != 0) && (this.KAZ))
      {
        this.KAK.left = getPaddingLeft();
        this.KAK.right = (getWidth() - getPaddingRight());
        this.KAK.top = this.KAP;
        this.KAK.bottom = getHeight();
        paramCanvas.save();
        paramCanvas.clipRect(this.KAK);
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
        k += this.KAS;
        j += this.KAS;
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
          if ((((c.b)locald.getChildAt(0)).getHeaderId() == this.KAO) && (locald.getTop() < 0) && (this.KAJ))
          {
            k = 1;
            if ((localView.getVisibility() == 0) && (k == 0))
            {
              localView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight()), View.MeasureSpec.makeMeasureSpec(0, 0));
              localView.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), locald.getHeight());
              this.KAK.left = getPaddingLeft();
              this.KAK.right = (getWidth() - getPaddingRight());
              this.KAK.bottom = locald.getBottom();
              this.KAK.top = locald.getTop();
              paramCanvas.save();
              paramCanvas.clipRect(this.KAK);
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
    if ((i != 0) && (this.KAZ))
    {
      paramCanvas.restore();
      if (this.KAW.getWidth() != getWidth() - getPaddingLeft() - getPaddingRight())
      {
        i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight());
        j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.KAW.measure(i, j);
        this.KAW.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.KAW.getHeight());
      }
      this.KAK.left = getPaddingLeft();
      this.KAK.right = (getWidth() - getPaddingRight());
      this.KAK.bottom = (n + m);
      if (!this.KAL) {
        break label741;
      }
    }
    label741:
    for (this.KAK.top = getPaddingTop();; this.KAK.top = 0)
    {
      paramCanvas.save();
      paramCanvas.clipRect(this.KAK);
      paramCanvas.translate(getPaddingLeft(), n);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), (int)(255.0F * this.KAP / m), 31);
      this.KAW.draw(paramCanvas);
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
      if (this.KAI == null) {
        this.KAI = new b();
      }
      this.mHandler.postDelayed(this.KAH, ViewConfiguration.getTapTimeout());
      i = (int)paramMotionEvent.getY();
      this.KAQ = i;
      float f = i;
      if ((this.KAW != null) && (f <= this.KAW.getBottom())) {}
      for (;;)
      {
        this.KAY = j;
        if ((this.KAY == -1) || (this.mScrollState == 2)) {
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
          k += this.KAS;
          i += this.KAS;
        }
        label247:
        j = -1;
      }
      if ((this.KAY == -1) || (Math.abs(paramMotionEvent.getY() - this.KAQ) <= this.mTouchSlop)) {
        break;
      }
      this.aye = -1;
      Object localObject = aeM(this.KAY);
      if (localObject != null) {
        ((View)localObject).setPressed(false);
      }
      if (this.KAH != null) {
        this.mHandler.removeCallbacks(this.KAH);
      }
      this.KAY = -1;
      break;
      if ((this.aye == -2) || (this.aye == -1) || (this.KAY == -1)) {
        break;
      }
      final View localView = aeM(this.KAY);
      final e locale;
      if ((localView != null) && (!localView.hasFocusable()))
      {
        if (this.aye != 0) {
          localView.setPressed(false);
        }
        if (this.KAV == null) {
          this.KAV = new e((byte)0);
        }
        locale = this.KAV;
        locale.KBd = this.KAY;
        locale.fJK();
        if ((this.aye == 0) && (this.aye == 1)) {
          break label574;
        }
        localap = this.mHandler;
        if (this.aye == 0) {}
        for (localObject = this.KAI;; localObject = this.KAH)
        {
          localap.removeCallbacks((Runnable)localObject);
          if (this.JiW) {
            break label561;
          }
          this.aye = 1;
          localView.setPressed(true);
          setPressed(true);
          if (this.Jnn != null) {
            removeCallbacks(this.Jnn);
          }
          this.Jnn = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142795);
              GridHeadersGridView.this.aye = -1;
              localView.setPressed(false);
              GridHeadersGridView.this.setPressed(false);
              if (!GridHeadersGridView.this.JiW) {
                locale.run();
              }
              AppMethodBeat.o(142795);
            }
          };
          this.mHandler.postDelayed(this.Jnn, ViewConfiguration.getPressedStateDuration());
          i = 1;
          break;
        }
        label561:
        this.aye = -1;
      }
      label574:
      while (this.JiW)
      {
        ap localap;
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
    return this.KAW;
  }
  
  public boolean getStickyHeaderIsTranscluent()
  {
    return !this.KAZ;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142808);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    a.b("com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    this.awt.onItemClick(paramAdapterView, paramView, this.KAX.aeL(paramInt).mPosition, paramLong);
    a.a(this, "com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(142808);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142809);
    boolean bool = this.JtZ.onItemLongClick(paramAdapterView, paramView, this.KAX.aeL(paramInt).mPosition, paramLong);
    AppMethodBeat.o(142809);
    return bool;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142810);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    a.b("com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    this.XW.onItemSelected(paramAdapterView, paramView, this.KAX.aeL(paramInt).mPosition, paramLong);
    a.a(this, "com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(142810);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(142832);
    if (this.mNumColumns == -1) {
      if (this.KAN > 0)
      {
        int k = Math.max(View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight(), 0);
        int j = k / this.KAN;
        if (j > 0)
        {
          i = j;
          while ((i != 1) && (this.KAN * i + (i - 1) * this.JiD > k)) {
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
      for (this.KAS = i;; this.KAS = this.mNumColumns)
      {
        if (this.KAX != null) {
          this.KAX.setNumColumns(this.KAS);
        }
        fJI();
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
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.KAJ = paramParcelable.KBe;
    requestLayout();
    AppMethodBeat.o(142812);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(142813);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.KBe = this.KAJ;
    AppMethodBeat.o(142813);
    return localSavedState;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142814);
    if (this.AAD != null) {
      this.AAD.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (Build.VERSION.SDK_INT >= 8) {
      aeN(paramInt1);
    }
    AppMethodBeat.o(142814);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(142815);
    if (this.AAD != null) {
      this.AAD.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.mScrollState = paramInt;
    AppMethodBeat.o(142815);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(142817);
    if ((this.KAX != null) && (this.Tf != null)) {
      this.KAX.unregisterDataSetObserver(this.Tf);
    }
    if (!this.KAM) {
      this.KAL = true;
    }
    if ((paramListAdapter instanceof b)) {
      paramListAdapter = (b)paramListAdapter;
    }
    for (;;)
    {
      this.KAX = new c(getContext(), this, paramListAdapter);
      this.KAX.registerDataSetObserver(this.Tf);
      reset();
      super.setAdapter(this.KAX);
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
    if (paramBoolean != this.KAJ)
    {
      this.KAJ = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(142818);
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(142819);
    super.setClipToPadding(paramBoolean);
    this.KAL = paramBoolean;
    this.KAM = true;
    AppMethodBeat.o(142819);
  }
  
  public void setColumnWidth(int paramInt)
  {
    AppMethodBeat.i(142820);
    super.setColumnWidth(paramInt);
    this.KAN = paramInt;
    AppMethodBeat.o(142820);
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    AppMethodBeat.i(142821);
    super.setHorizontalSpacing(paramInt);
    this.JiD = paramInt;
    AppMethodBeat.o(142821);
  }
  
  public void setNumColumns(int paramInt)
  {
    AppMethodBeat.i(142822);
    super.setNumColumns(paramInt);
    this.KAR = true;
    this.mNumColumns = paramInt;
    if ((paramInt != -1) && (this.KAX != null)) {
      this.KAX.setNumColumns(paramInt);
    }
    AppMethodBeat.o(142822);
  }
  
  public void setOnHeaderClickListener(GridHeadersGridView.c paramc)
  {
    this.KAT = paramc;
  }
  
  public void setOnHeaderLongClickListener(d paramd)
  {
    AppMethodBeat.i(142823);
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.KAU = paramd;
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
    this.JtZ = paramOnItemLongClickListener;
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
    this.AAD = paramOnScrollListener;
  }
  
  public void setStickyHeaderIsTranscluent(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.KAZ = paramBoolean;
      return;
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    AppMethodBeat.i(142827);
    super.setVerticalSpacing(paramInt);
    this.JiE = paramInt;
    AppMethodBeat.o(142827);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean KBe;
    
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
        this.KBe = bool;
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
      String str = "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.KBe + "}";
      AppMethodBeat.o(142801);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(142802);
      super.writeToParcel(paramParcel, paramInt);
      if (this.KBe) {}
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
      View localView = GridHeadersGridView.this.aeM(GridHeadersGridView.this.KAY);
      boolean bool1;
      if (localView != null)
      {
        GridHeadersGridView.a(GridHeadersGridView.this, GridHeadersGridView.this.KAY);
        if ((!fJL()) || (GridHeadersGridView.this.JiW)) {
          break label156;
        }
        GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
        if (localGridHeadersGridView.KAU == null) {
          break label151;
        }
        bool1 = localGridHeadersGridView.KAU.fJJ();
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
        View localView = GridHeadersGridView.this.aeM(GridHeadersGridView.this.KAY);
        if ((localView != null) && (!localView.hasFocusable()))
        {
          if (!GridHeadersGridView.this.JiW)
          {
            localView.setPressed(true);
            GridHeadersGridView.this.setPressed(true);
            GridHeadersGridView.this.refreshDrawableState();
            int i = ViewConfiguration.getLongPressTimeout();
            if (GridHeadersGridView.this.isLongClickable())
            {
              if (GridHeadersGridView.this.KAH == null) {
                GridHeadersGridView.this.KAH = new GridHeadersGridView.a(GridHeadersGridView.this, (byte)0);
              }
              GridHeadersGridView.this.KAH.fJK();
              GridHeadersGridView.d(GridHeadersGridView.this).postDelayed(GridHeadersGridView.this.KAH, i);
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
    public abstract boolean fJJ();
  }
  
  final class e
    extends GridHeadersGridView.f
    implements Runnable
  {
    int KBd;
    
    private e()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(142798);
      if (GridHeadersGridView.this.JiW)
      {
        AppMethodBeat.o(142798);
        return;
      }
      if ((GridHeadersGridView.this.KAX != null) && (GridHeadersGridView.this.KAX.getCount() > 0) && (this.KBd != -1) && (this.KBd < GridHeadersGridView.this.KAX.getCount()) && (fJL()))
      {
        View localView = GridHeadersGridView.this.aeM(this.KBd);
        if (localView != null)
        {
          GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
          GridHeadersGridView.a(GridHeadersGridView.this, this.KBd);
          if (localGridHeadersGridView.KAT != null)
          {
            localGridHeadersGridView.playSoundEffect(0);
            if (localView != null) {
              localView.sendAccessibilityEvent(1);
            }
            localGridHeadersGridView.KAT.dM(localView);
          }
        }
      }
      AppMethodBeat.o(142798);
    }
  }
  
  class f
  {
    private int Jnt;
    
    private f() {}
    
    public final void fJK()
    {
      AppMethodBeat.i(142804);
      this.Jnt = GridHeadersGridView.b(GridHeadersGridView.this);
      AppMethodBeat.o(142804);
    }
    
    public final boolean fJL()
    {
      AppMethodBeat.i(142805);
      if ((GridHeadersGridView.this.hasWindowFocus()) && (GridHeadersGridView.c(GridHeadersGridView.this) == this.Jnt))
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