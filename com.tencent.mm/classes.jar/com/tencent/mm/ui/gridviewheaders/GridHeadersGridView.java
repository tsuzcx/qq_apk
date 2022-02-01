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
import com.tencent.mm.sdk.platformtools.ao;
import java.util.ArrayList;
import java.util.List;

public class GridHeadersGridView
  extends GridView
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private AdapterView.OnItemLongClickListener HGi;
  private int HuN;
  private int HuO;
  protected boolean Hvg;
  private Runnable Hzw;
  public a IJA;
  public b IJB;
  private boolean IJC;
  private final Rect IJD;
  private boolean IJE;
  private boolean IJF;
  private int IJG;
  private long IJH;
  private int IJI;
  private float IJJ;
  private boolean IJK;
  private int IJL;
  GridHeadersGridView.c IJM;
  d IJN;
  private e IJO;
  private View IJP;
  protected c IJQ;
  protected int IJR;
  private boolean IJS;
  private DataSetObserver Rq;
  private AdapterView.OnItemSelectedListener Wh;
  private AdapterView.OnItemClickListener auB;
  protected int awn;
  private ao mHandler;
  private int mNumColumns;
  private int mScrollState;
  private int mTouchSlop;
  private AbsListView.OnScrollListener ziD;
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842865);
  }
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142806);
    this.mHandler = new ao();
    this.IJC = true;
    this.IJD = new Rect();
    this.IJH = -1L;
    this.Rq = new DataSetObserver()
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
    this.IJL = 1;
    this.mScrollState = 0;
    this.IJS = true;
    super.setOnScrollListener(this);
    setVerticalFadingEdgeEnabled(false);
    if (!this.IJK) {
      this.mNumColumns = -1;
    }
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(142806);
  }
  
  private void acp(int paramInt)
  {
    AppMethodBeat.i(142830);
    if ((this.IJQ == null) || (this.IJQ.getCount() == 0) || (!this.IJC))
    {
      AppMethodBeat.o(142830);
      return;
    }
    if ((c.d)getChildAt(0) == null)
    {
      AppMethodBeat.o(142830);
      return;
    }
    int j = paramInt - this.IJL;
    int i = j;
    if (j < 0) {
      i = paramInt;
    }
    int k = this.IJL + paramInt;
    j = k;
    if (k >= this.IJQ.getCount()) {
      j = paramInt;
    }
    long l;
    Object localObject;
    label198:
    c.d locald;
    if (this.HuO != 0) {
      if (this.HuO < 0)
      {
        this.IJQ.An(paramInt);
        if (getChildAt(this.IJL).getTop() <= 0)
        {
          l = this.IJQ.An(j);
          i = j;
          if (this.IJH != l)
          {
            this.IJP = this.IJQ.a(i, this.IJP, this);
            fsU();
            this.IJH = l;
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
          if (!this.IJE) {
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
      k += this.IJL;
      i = j;
      break label198;
      l = this.IJQ.An(paramInt);
      i = paramInt;
      break;
      j = getChildAt(0).getTop();
      if ((j > 0) && (j < this.HuO))
      {
        l = this.IJQ.An(i);
        break;
      }
      l = this.IJQ.An(paramInt);
      i = paramInt;
      break;
      label336:
      j = locald.getTop();
      break label234;
      label345:
      i = getHeaderHeight();
      if (localObject != null)
      {
        if ((paramInt == 0) && (super.getChildAt(0).getTop() > 0) && (!this.IJE))
        {
          this.IJI = 0;
          AppMethodBeat.o(142830);
          return;
        }
        if (this.IJE)
        {
          this.IJI = Math.min(localObject.getTop(), getPaddingTop() + i);
          if (this.IJI < getPaddingTop()) {}
          for (paramInt = i + getPaddingTop();; paramInt = this.IJI)
          {
            this.IJI = paramInt;
            AppMethodBeat.o(142830);
            return;
          }
        }
        this.IJI = Math.min(localObject.getTop(), i);
        if (this.IJI < 0) {}
        for (paramInt = i;; paramInt = this.IJI)
        {
          this.IJI = paramInt;
          AppMethodBeat.o(142830);
          return;
        }
      }
      this.IJI = i;
      if (this.IJE) {
        this.IJI += getPaddingTop();
      }
      label516:
      AppMethodBeat.o(142830);
      return;
      label522:
      j = i;
    }
  }
  
  private void fsU()
  {
    AppMethodBeat.i(142829);
    if (this.IJP == null)
    {
      AppMethodBeat.o(142829);
      return;
    }
    int j = View.MeasureSpec.makeMeasureSpec(getWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
    ViewGroup.LayoutParams localLayoutParams = this.IJP.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height > 0)) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      this.IJP.measure(j, i);
      this.IJP.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.IJP.getMeasuredHeight());
      AppMethodBeat.o(142829);
      return;
    }
  }
  
  private int getHeaderHeight()
  {
    AppMethodBeat.i(142828);
    if (this.IJP != null)
    {
      int i = this.IJP.getMeasuredHeight();
      AppMethodBeat.o(142828);
      return i;
    }
    AppMethodBeat.o(142828);
    return 0;
  }
  
  private void reset()
  {
    this.IJI = 0;
    this.IJP = null;
    this.IJH = -9223372036854775808L;
  }
  
  public final View aco(int paramInt)
  {
    AppMethodBeat.i(142807);
    View localView;
    if (paramInt == -2)
    {
      localView = this.IJP;
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
      acp(getFirstVisiblePosition());
    }
    if ((this.IJP != null) && (this.IJC) && (this.IJP.getVisibility() == 0)) {}
    int m;
    int n;
    ArrayList localArrayList;
    int k;
    for (int i = 1;; i = 0)
    {
      m = getHeaderHeight();
      n = this.IJI - m;
      if ((i != 0) && (this.IJS))
      {
        this.IJD.left = getPaddingLeft();
        this.IJD.right = (getWidth() - getPaddingRight());
        this.IJD.top = this.IJI;
        this.IJD.bottom = getHeight();
        paramCanvas.save();
        paramCanvas.clipRect(this.IJD);
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
        k += this.IJL;
        j += this.IJL;
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
          if ((((c.b)locald.getChildAt(0)).getHeaderId() == this.IJH) && (locald.getTop() < 0) && (this.IJC))
          {
            k = 1;
            if ((localView.getVisibility() == 0) && (k == 0))
            {
              localView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight()), View.MeasureSpec.makeMeasureSpec(0, 0));
              localView.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), locald.getHeight());
              this.IJD.left = getPaddingLeft();
              this.IJD.right = (getWidth() - getPaddingRight());
              this.IJD.bottom = locald.getBottom();
              this.IJD.top = locald.getTop();
              paramCanvas.save();
              paramCanvas.clipRect(this.IJD);
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
    if ((i != 0) && (this.IJS))
    {
      paramCanvas.restore();
      if (this.IJP.getWidth() != getWidth() - getPaddingLeft() - getPaddingRight())
      {
        i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight());
        j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.IJP.measure(i, j);
        this.IJP.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.IJP.getHeight());
      }
      this.IJD.left = getPaddingLeft();
      this.IJD.right = (getWidth() - getPaddingRight());
      this.IJD.bottom = (n + m);
      if (!this.IJE) {
        break label741;
      }
    }
    label741:
    for (this.IJD.top = getPaddingTop();; this.IJD.top = 0)
    {
      paramCanvas.save();
      paramCanvas.clipRect(this.IJD);
      paramCanvas.translate(getPaddingLeft(), n);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), (int)(255.0F * this.IJI / m), 31);
      this.IJP.draw(paramCanvas);
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
      if (this.IJB == null) {
        this.IJB = new b();
      }
      this.mHandler.postDelayed(this.IJA, ViewConfiguration.getTapTimeout());
      i = (int)paramMotionEvent.getY();
      this.IJJ = i;
      float f = i;
      if ((this.IJP != null) && (f <= this.IJP.getBottom())) {}
      for (;;)
      {
        this.IJR = j;
        if ((this.IJR == -1) || (this.mScrollState == 2)) {
          break;
        }
        this.awn = 0;
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
          k += this.IJL;
          i += this.IJL;
        }
        label247:
        j = -1;
      }
      if ((this.IJR == -1) || (Math.abs(paramMotionEvent.getY() - this.IJJ) <= this.mTouchSlop)) {
        break;
      }
      this.awn = -1;
      Object localObject = aco(this.IJR);
      if (localObject != null) {
        ((View)localObject).setPressed(false);
      }
      if (this.IJA != null) {
        this.mHandler.removeCallbacks(this.IJA);
      }
      this.IJR = -1;
      break;
      if ((this.awn == -2) || (this.awn == -1) || (this.IJR == -1)) {
        break;
      }
      final View localView = aco(this.IJR);
      final e locale;
      if ((localView != null) && (!localView.hasFocusable()))
      {
        if (this.awn != 0) {
          localView.setPressed(false);
        }
        if (this.IJO == null) {
          this.IJO = new e((byte)0);
        }
        locale = this.IJO;
        locale.IJW = this.IJR;
        locale.fsW();
        if ((this.awn == 0) && (this.awn == 1)) {
          break label574;
        }
        localao = this.mHandler;
        if (this.awn == 0) {}
        for (localObject = this.IJB;; localObject = this.IJA)
        {
          localao.removeCallbacks((Runnable)localObject);
          if (this.Hvg) {
            break label561;
          }
          this.awn = 1;
          localView.setPressed(true);
          setPressed(true);
          if (this.Hzw != null) {
            removeCallbacks(this.Hzw);
          }
          this.Hzw = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142795);
              GridHeadersGridView.this.awn = -1;
              localView.setPressed(false);
              GridHeadersGridView.this.setPressed(false);
              if (!GridHeadersGridView.this.Hvg) {
                locale.run();
              }
              AppMethodBeat.o(142795);
            }
          };
          this.mHandler.postDelayed(this.Hzw, ViewConfiguration.getPressedStateDuration());
          i = 1;
          break;
        }
        label561:
        this.awn = -1;
      }
      label574:
      while (this.Hvg)
      {
        ao localao;
        this.awn = -1;
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
    return this.IJP;
  }
  
  public boolean getStickyHeaderIsTranscluent()
  {
    return !this.IJS;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142808);
    this.auB.onItemClick(paramAdapterView, paramView, this.IJQ.acn(paramInt).mPosition, paramLong);
    AppMethodBeat.o(142808);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142809);
    boolean bool = this.HGi.onItemLongClick(paramAdapterView, paramView, this.IJQ.acn(paramInt).mPosition, paramLong);
    AppMethodBeat.o(142809);
    return bool;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142810);
    this.Wh.onItemSelected(paramAdapterView, paramView, this.IJQ.acn(paramInt).mPosition, paramLong);
    AppMethodBeat.o(142810);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(142832);
    if (this.mNumColumns == -1) {
      if (this.IJG > 0)
      {
        int k = Math.max(View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight(), 0);
        int j = k / this.IJG;
        if (j > 0)
        {
          i = j;
          while ((i != 1) && (this.IJG * i + (i - 1) * this.HuN > k)) {
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
      for (this.IJL = i;; this.IJL = this.mNumColumns)
      {
        if (this.IJQ != null) {
          this.IJQ.setNumColumns(this.IJL);
        }
        fsU();
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(142832);
        return;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AppMethodBeat.i(142811);
    this.Wh.onNothingSelected(paramAdapterView);
    AppMethodBeat.o(142811);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(142812);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.IJC = paramParcelable.IJX;
    requestLayout();
    AppMethodBeat.o(142812);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(142813);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.IJX = this.IJC;
    AppMethodBeat.o(142813);
    return localSavedState;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142814);
    if (this.ziD != null) {
      this.ziD.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (Build.VERSION.SDK_INT >= 8) {
      acp(paramInt1);
    }
    AppMethodBeat.o(142814);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(142815);
    if (this.ziD != null) {
      this.ziD.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.mScrollState = paramInt;
    AppMethodBeat.o(142815);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(142817);
    if ((this.IJQ != null) && (this.Rq != null)) {
      this.IJQ.unregisterDataSetObserver(this.Rq);
    }
    if (!this.IJF) {
      this.IJE = true;
    }
    if ((paramListAdapter instanceof b)) {
      paramListAdapter = (b)paramListAdapter;
    }
    for (;;)
    {
      this.IJQ = new c(getContext(), this, paramListAdapter);
      this.IJQ.registerDataSetObserver(this.Rq);
      reset();
      super.setAdapter(this.IJQ);
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
    if (paramBoolean != this.IJC)
    {
      this.IJC = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(142818);
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(142819);
    super.setClipToPadding(paramBoolean);
    this.IJE = paramBoolean;
    this.IJF = true;
    AppMethodBeat.o(142819);
  }
  
  public void setColumnWidth(int paramInt)
  {
    AppMethodBeat.i(142820);
    super.setColumnWidth(paramInt);
    this.IJG = paramInt;
    AppMethodBeat.o(142820);
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    AppMethodBeat.i(142821);
    super.setHorizontalSpacing(paramInt);
    this.HuN = paramInt;
    AppMethodBeat.o(142821);
  }
  
  public void setNumColumns(int paramInt)
  {
    AppMethodBeat.i(142822);
    super.setNumColumns(paramInt);
    this.IJK = true;
    this.mNumColumns = paramInt;
    if ((paramInt != -1) && (this.IJQ != null)) {
      this.IJQ.setNumColumns(paramInt);
    }
    AppMethodBeat.o(142822);
  }
  
  public void setOnHeaderClickListener(GridHeadersGridView.c paramc)
  {
    this.IJM = paramc;
  }
  
  public void setOnHeaderLongClickListener(d paramd)
  {
    AppMethodBeat.i(142823);
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.IJN = paramd;
    AppMethodBeat.o(142823);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(142824);
    this.auB = paramOnItemClickListener;
    super.setOnItemClickListener(this);
    AppMethodBeat.o(142824);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(142825);
    this.HGi = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(this);
    AppMethodBeat.o(142825);
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    AppMethodBeat.i(142826);
    this.Wh = paramOnItemSelectedListener;
    super.setOnItemSelectedListener(this);
    AppMethodBeat.o(142826);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.ziD = paramOnScrollListener;
  }
  
  public void setStickyHeaderIsTranscluent(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.IJS = paramBoolean;
      return;
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    AppMethodBeat.i(142827);
    super.setVerticalSpacing(paramInt);
    this.HuO = paramInt;
    AppMethodBeat.o(142827);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean IJX;
    
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
        this.IJX = bool;
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
      String str = "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.IJX + "}";
      AppMethodBeat.o(142801);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(142802);
      super.writeToParcel(paramParcel, paramInt);
      if (this.IJX) {}
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
      View localView = GridHeadersGridView.this.aco(GridHeadersGridView.this.IJR);
      boolean bool1;
      if (localView != null)
      {
        GridHeadersGridView.a(GridHeadersGridView.this, GridHeadersGridView.this.IJR);
        if ((!fsX()) || (GridHeadersGridView.this.Hvg)) {
          break label156;
        }
        GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
        if (localGridHeadersGridView.IJN == null) {
          break label151;
        }
        bool1 = localGridHeadersGridView.IJN.fsV();
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
          GridHeadersGridView.this.awn = -2;
          GridHeadersGridView.this.setPressed(false);
          localView.setPressed(false);
          AppMethodBeat.o(142796);
          return;
        }
        GridHeadersGridView.this.awn = 2;
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
      if (GridHeadersGridView.this.awn == 0)
      {
        GridHeadersGridView.this.awn = 1;
        View localView = GridHeadersGridView.this.aco(GridHeadersGridView.this.IJR);
        if ((localView != null) && (!localView.hasFocusable()))
        {
          if (!GridHeadersGridView.this.Hvg)
          {
            localView.setPressed(true);
            GridHeadersGridView.this.setPressed(true);
            GridHeadersGridView.this.refreshDrawableState();
            int i = ViewConfiguration.getLongPressTimeout();
            if (GridHeadersGridView.this.isLongClickable())
            {
              if (GridHeadersGridView.this.IJA == null) {
                GridHeadersGridView.this.IJA = new GridHeadersGridView.a(GridHeadersGridView.this, (byte)0);
              }
              GridHeadersGridView.this.IJA.fsW();
              GridHeadersGridView.d(GridHeadersGridView.this).postDelayed(GridHeadersGridView.this.IJA, i);
              AppMethodBeat.o(142797);
              return;
            }
            GridHeadersGridView.this.awn = 2;
            AppMethodBeat.o(142797);
            return;
          }
          GridHeadersGridView.this.awn = 2;
        }
      }
      AppMethodBeat.o(142797);
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean fsV();
  }
  
  final class e
    extends GridHeadersGridView.f
    implements Runnable
  {
    int IJW;
    
    private e()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(142798);
      if (GridHeadersGridView.this.Hvg)
      {
        AppMethodBeat.o(142798);
        return;
      }
      if ((GridHeadersGridView.this.IJQ != null) && (GridHeadersGridView.this.IJQ.getCount() > 0) && (this.IJW != -1) && (this.IJW < GridHeadersGridView.this.IJQ.getCount()) && (fsX()))
      {
        View localView = GridHeadersGridView.this.aco(this.IJW);
        if (localView != null)
        {
          GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
          GridHeadersGridView.a(GridHeadersGridView.this, this.IJW);
          if (localGridHeadersGridView.IJM != null)
          {
            localGridHeadersGridView.playSoundEffect(0);
            if (localView != null) {
              localView.sendAccessibilityEvent(1);
            }
            localGridHeadersGridView.IJM.dJ(localView);
          }
        }
      }
      AppMethodBeat.o(142798);
    }
  }
  
  class f
  {
    private int HzC;
    
    private f() {}
    
    public final void fsW()
    {
      AppMethodBeat.i(142804);
      this.HzC = GridHeadersGridView.b(GridHeadersGridView.this);
      AppMethodBeat.o(142804);
    }
    
    public final boolean fsX()
    {
      AppMethodBeat.i(142805);
      if ((GridHeadersGridView.this.hasWindowFocus()) && (GridHeadersGridView.c(GridHeadersGridView.this) == this.HzC))
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