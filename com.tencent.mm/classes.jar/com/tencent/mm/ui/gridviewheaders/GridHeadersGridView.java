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
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.List;

public class GridHeadersGridView
  extends GridView
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private int FUZ;
  private int FVa;
  protected boolean FVs;
  private Runnable FZI;
  private AdapterView.OnItemLongClickListener Ggs;
  public a Hjh;
  public b Hji;
  private boolean Hjj;
  private final Rect Hjk;
  private boolean Hjl;
  private boolean Hjm;
  private int Hjn;
  private long Hjo;
  private int Hjp;
  private float Hjq;
  private boolean Hjr;
  private int Hjs;
  GridHeadersGridView.c Hjt;
  d Hju;
  private e Hjv;
  private View Hjw;
  protected c Hjx;
  protected int Hjy;
  private boolean Hjz;
  private DataSetObserver Qv;
  private AdapterView.OnItemSelectedListener Vm;
  private AdapterView.OnItemClickListener atG;
  protected int avs;
  private ap mHandler;
  private int mNumColumns;
  private int mScrollState;
  private int mTouchSlop;
  private AbsListView.OnScrollListener xVH;
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842865);
  }
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142806);
    this.mHandler = new ap();
    this.Hjj = true;
    this.Hjk = new Rect();
    this.Hjo = -1L;
    this.Qv = new DataSetObserver()
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
    this.Hjs = 1;
    this.mScrollState = 0;
    this.Hjz = true;
    super.setOnScrollListener(this);
    setVerticalFadingEdgeEnabled(false);
    if (!this.Hjr) {
      this.mNumColumns = -1;
    }
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(142806);
  }
  
  private void aac(int paramInt)
  {
    AppMethodBeat.i(142830);
    if ((this.Hjx == null) || (this.Hjx.getCount() == 0) || (!this.Hjj))
    {
      AppMethodBeat.o(142830);
      return;
    }
    if ((c.d)getChildAt(0) == null)
    {
      AppMethodBeat.o(142830);
      return;
    }
    int j = paramInt - this.Hjs;
    int i = j;
    if (j < 0) {
      i = paramInt;
    }
    int k = this.Hjs + paramInt;
    j = k;
    if (k >= this.Hjx.getCount()) {
      j = paramInt;
    }
    long l;
    Object localObject;
    label198:
    c.d locald;
    if (this.FVa != 0) {
      if (this.FVa < 0)
      {
        this.Hjx.zw(paramInt);
        if (getChildAt(this.Hjs).getTop() <= 0)
        {
          l = this.Hjx.zw(j);
          i = j;
          if (this.Hjo != l)
          {
            this.Hjw = this.Hjx.a(i, this.Hjw, this);
            fcZ();
            this.Hjo = l;
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
          if (!this.Hjl) {
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
      k += this.Hjs;
      i = j;
      break label198;
      l = this.Hjx.zw(paramInt);
      i = paramInt;
      break;
      j = getChildAt(0).getTop();
      if ((j > 0) && (j < this.FVa))
      {
        l = this.Hjx.zw(i);
        break;
      }
      l = this.Hjx.zw(paramInt);
      i = paramInt;
      break;
      label336:
      j = locald.getTop();
      break label234;
      label345:
      i = getHeaderHeight();
      if (localObject != null)
      {
        if ((paramInt == 0) && (super.getChildAt(0).getTop() > 0) && (!this.Hjl))
        {
          this.Hjp = 0;
          AppMethodBeat.o(142830);
          return;
        }
        if (this.Hjl)
        {
          this.Hjp = Math.min(localObject.getTop(), getPaddingTop() + i);
          if (this.Hjp < getPaddingTop()) {}
          for (paramInt = i + getPaddingTop();; paramInt = this.Hjp)
          {
            this.Hjp = paramInt;
            AppMethodBeat.o(142830);
            return;
          }
        }
        this.Hjp = Math.min(localObject.getTop(), i);
        if (this.Hjp < 0) {}
        for (paramInt = i;; paramInt = this.Hjp)
        {
          this.Hjp = paramInt;
          AppMethodBeat.o(142830);
          return;
        }
      }
      this.Hjp = i;
      if (this.Hjl) {
        this.Hjp += getPaddingTop();
      }
      label516:
      AppMethodBeat.o(142830);
      return;
      label522:
      j = i;
    }
  }
  
  private void fcZ()
  {
    AppMethodBeat.i(142829);
    if (this.Hjw == null)
    {
      AppMethodBeat.o(142829);
      return;
    }
    int j = View.MeasureSpec.makeMeasureSpec(getWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
    ViewGroup.LayoutParams localLayoutParams = this.Hjw.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height > 0)) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      this.Hjw.measure(j, i);
      this.Hjw.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.Hjw.getMeasuredHeight());
      AppMethodBeat.o(142829);
      return;
    }
  }
  
  private int getHeaderHeight()
  {
    AppMethodBeat.i(142828);
    if (this.Hjw != null)
    {
      int i = this.Hjw.getMeasuredHeight();
      AppMethodBeat.o(142828);
      return i;
    }
    AppMethodBeat.o(142828);
    return 0;
  }
  
  private void reset()
  {
    this.Hjp = 0;
    this.Hjw = null;
    this.Hjo = -9223372036854775808L;
  }
  
  public final View aab(int paramInt)
  {
    AppMethodBeat.i(142807);
    View localView;
    if (paramInt == -2)
    {
      localView = this.Hjw;
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
      aac(getFirstVisiblePosition());
    }
    if ((this.Hjw != null) && (this.Hjj) && (this.Hjw.getVisibility() == 0)) {}
    int m;
    int n;
    ArrayList localArrayList;
    int k;
    for (int i = 1;; i = 0)
    {
      m = getHeaderHeight();
      n = this.Hjp - m;
      if ((i != 0) && (this.Hjz))
      {
        this.Hjk.left = getPaddingLeft();
        this.Hjk.right = (getWidth() - getPaddingRight());
        this.Hjk.top = this.Hjp;
        this.Hjk.bottom = getHeight();
        paramCanvas.save();
        paramCanvas.clipRect(this.Hjk);
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
        k += this.Hjs;
        j += this.Hjs;
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
          if ((((c.b)locald.getChildAt(0)).getHeaderId() == this.Hjo) && (locald.getTop() < 0) && (this.Hjj))
          {
            k = 1;
            if ((localView.getVisibility() == 0) && (k == 0))
            {
              localView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight()), View.MeasureSpec.makeMeasureSpec(0, 0));
              localView.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), locald.getHeight());
              this.Hjk.left = getPaddingLeft();
              this.Hjk.right = (getWidth() - getPaddingRight());
              this.Hjk.bottom = locald.getBottom();
              this.Hjk.top = locald.getTop();
              paramCanvas.save();
              paramCanvas.clipRect(this.Hjk);
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
    if ((i != 0) && (this.Hjz))
    {
      paramCanvas.restore();
      if (this.Hjw.getWidth() != getWidth() - getPaddingLeft() - getPaddingRight())
      {
        i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight());
        j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.Hjw.measure(i, j);
        this.Hjw.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.Hjw.getHeight());
      }
      this.Hjk.left = getPaddingLeft();
      this.Hjk.right = (getWidth() - getPaddingRight());
      this.Hjk.bottom = (n + m);
      if (!this.Hjl) {
        break label741;
      }
    }
    label741:
    for (this.Hjk.top = getPaddingTop();; this.Hjk.top = 0)
    {
      paramCanvas.save();
      paramCanvas.clipRect(this.Hjk);
      paramCanvas.translate(getPaddingLeft(), n);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), (int)(255.0F * this.Hjp / m), 31);
      this.Hjw.draw(paramCanvas);
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
      if (this.Hji == null) {
        this.Hji = new b();
      }
      this.mHandler.postDelayed(this.Hjh, ViewConfiguration.getTapTimeout());
      i = (int)paramMotionEvent.getY();
      this.Hjq = i;
      float f = i;
      if ((this.Hjw != null) && (f <= this.Hjw.getBottom())) {}
      for (;;)
      {
        this.Hjy = j;
        if ((this.Hjy == -1) || (this.mScrollState == 2)) {
          break;
        }
        this.avs = 0;
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
          k += this.Hjs;
          i += this.Hjs;
        }
        label247:
        j = -1;
      }
      if ((this.Hjy == -1) || (Math.abs(paramMotionEvent.getY() - this.Hjq) <= this.mTouchSlop)) {
        break;
      }
      this.avs = -1;
      Object localObject = aab(this.Hjy);
      if (localObject != null) {
        ((View)localObject).setPressed(false);
      }
      if (this.Hjh != null) {
        this.mHandler.removeCallbacks(this.Hjh);
      }
      this.Hjy = -1;
      break;
      if ((this.avs == -2) || (this.avs == -1) || (this.Hjy == -1)) {
        break;
      }
      final View localView = aab(this.Hjy);
      final e locale;
      if ((localView != null) && (!localView.hasFocusable()))
      {
        if (this.avs != 0) {
          localView.setPressed(false);
        }
        if (this.Hjv == null) {
          this.Hjv = new e((byte)0);
        }
        locale = this.Hjv;
        locale.HjD = this.Hjy;
        locale.fdb();
        if ((this.avs == 0) && (this.avs == 1)) {
          break label574;
        }
        localap = this.mHandler;
        if (this.avs == 0) {}
        for (localObject = this.Hji;; localObject = this.Hjh)
        {
          localap.removeCallbacks((Runnable)localObject);
          if (this.FVs) {
            break label561;
          }
          this.avs = 1;
          localView.setPressed(true);
          setPressed(true);
          if (this.FZI != null) {
            removeCallbacks(this.FZI);
          }
          this.FZI = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(142795);
              GridHeadersGridView.this.avs = -1;
              localView.setPressed(false);
              GridHeadersGridView.this.setPressed(false);
              if (!GridHeadersGridView.this.FVs) {
                locale.run();
              }
              AppMethodBeat.o(142795);
            }
          };
          this.mHandler.postDelayed(this.FZI, ViewConfiguration.getPressedStateDuration());
          i = 1;
          break;
        }
        label561:
        this.avs = -1;
      }
      label574:
      while (this.FVs)
      {
        ap localap;
        this.avs = -1;
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
    return this.Hjw;
  }
  
  public boolean getStickyHeaderIsTranscluent()
  {
    return !this.Hjz;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142808);
    this.atG.onItemClick(paramAdapterView, paramView, this.Hjx.aaa(paramInt).mPosition, paramLong);
    AppMethodBeat.o(142808);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142809);
    boolean bool = this.Ggs.onItemLongClick(paramAdapterView, paramView, this.Hjx.aaa(paramInt).mPosition, paramLong);
    AppMethodBeat.o(142809);
    return bool;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(142810);
    this.Vm.onItemSelected(paramAdapterView, paramView, this.Hjx.aaa(paramInt).mPosition, paramLong);
    AppMethodBeat.o(142810);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(142832);
    if (this.mNumColumns == -1) {
      if (this.Hjn > 0)
      {
        int k = Math.max(View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight(), 0);
        int j = k / this.Hjn;
        if (j > 0)
        {
          i = j;
          while ((i != 1) && (this.Hjn * i + (i - 1) * this.FUZ > k)) {
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
      for (this.Hjs = i;; this.Hjs = this.mNumColumns)
      {
        if (this.Hjx != null) {
          this.Hjx.setNumColumns(this.Hjs);
        }
        fcZ();
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(142832);
        return;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AppMethodBeat.i(142811);
    this.Vm.onNothingSelected(paramAdapterView);
    AppMethodBeat.o(142811);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(142812);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.Hjj = paramParcelable.HjE;
    requestLayout();
    AppMethodBeat.o(142812);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(142813);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.HjE = this.Hjj;
    AppMethodBeat.o(142813);
    return localSavedState;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(142814);
    if (this.xVH != null) {
      this.xVH.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (Build.VERSION.SDK_INT >= 8) {
      aac(paramInt1);
    }
    AppMethodBeat.o(142814);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(142815);
    if (this.xVH != null) {
      this.xVH.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.mScrollState = paramInt;
    AppMethodBeat.o(142815);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(142817);
    if ((this.Hjx != null) && (this.Qv != null)) {
      this.Hjx.unregisterDataSetObserver(this.Qv);
    }
    if (!this.Hjm) {
      this.Hjl = true;
    }
    if ((paramListAdapter instanceof b)) {
      paramListAdapter = (b)paramListAdapter;
    }
    for (;;)
    {
      this.Hjx = new c(getContext(), this, paramListAdapter);
      this.Hjx.registerDataSetObserver(this.Qv);
      reset();
      super.setAdapter(this.Hjx);
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
    if (paramBoolean != this.Hjj)
    {
      this.Hjj = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(142818);
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(142819);
    super.setClipToPadding(paramBoolean);
    this.Hjl = paramBoolean;
    this.Hjm = true;
    AppMethodBeat.o(142819);
  }
  
  public void setColumnWidth(int paramInt)
  {
    AppMethodBeat.i(142820);
    super.setColumnWidth(paramInt);
    this.Hjn = paramInt;
    AppMethodBeat.o(142820);
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    AppMethodBeat.i(142821);
    super.setHorizontalSpacing(paramInt);
    this.FUZ = paramInt;
    AppMethodBeat.o(142821);
  }
  
  public void setNumColumns(int paramInt)
  {
    AppMethodBeat.i(142822);
    super.setNumColumns(paramInt);
    this.Hjr = true;
    this.mNumColumns = paramInt;
    if ((paramInt != -1) && (this.Hjx != null)) {
      this.Hjx.setNumColumns(paramInt);
    }
    AppMethodBeat.o(142822);
  }
  
  public void setOnHeaderClickListener(GridHeadersGridView.c paramc)
  {
    this.Hjt = paramc;
  }
  
  public void setOnHeaderLongClickListener(d paramd)
  {
    AppMethodBeat.i(142823);
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.Hju = paramd;
    AppMethodBeat.o(142823);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(142824);
    this.atG = paramOnItemClickListener;
    super.setOnItemClickListener(this);
    AppMethodBeat.o(142824);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(142825);
    this.Ggs = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(this);
    AppMethodBeat.o(142825);
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    AppMethodBeat.i(142826);
    this.Vm = paramOnItemSelectedListener;
    super.setOnItemSelectedListener(this);
    AppMethodBeat.o(142826);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.xVH = paramOnScrollListener;
  }
  
  public void setStickyHeaderIsTranscluent(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Hjz = paramBoolean;
      return;
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    AppMethodBeat.i(142827);
    super.setVerticalSpacing(paramInt);
    this.FVa = paramInt;
    AppMethodBeat.o(142827);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean HjE;
    
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
        this.HjE = bool;
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
      String str = "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.HjE + "}";
      AppMethodBeat.o(142801);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(142802);
      super.writeToParcel(paramParcel, paramInt);
      if (this.HjE) {}
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
      View localView = GridHeadersGridView.this.aab(GridHeadersGridView.this.Hjy);
      boolean bool1;
      if (localView != null)
      {
        GridHeadersGridView.a(GridHeadersGridView.this, GridHeadersGridView.this.Hjy);
        if ((!fdc()) || (GridHeadersGridView.this.FVs)) {
          break label156;
        }
        GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
        if (localGridHeadersGridView.Hju == null) {
          break label151;
        }
        bool1 = localGridHeadersGridView.Hju.fda();
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
          GridHeadersGridView.this.avs = -2;
          GridHeadersGridView.this.setPressed(false);
          localView.setPressed(false);
          AppMethodBeat.o(142796);
          return;
        }
        GridHeadersGridView.this.avs = 2;
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
      if (GridHeadersGridView.this.avs == 0)
      {
        GridHeadersGridView.this.avs = 1;
        View localView = GridHeadersGridView.this.aab(GridHeadersGridView.this.Hjy);
        if ((localView != null) && (!localView.hasFocusable()))
        {
          if (!GridHeadersGridView.this.FVs)
          {
            localView.setPressed(true);
            GridHeadersGridView.this.setPressed(true);
            GridHeadersGridView.this.refreshDrawableState();
            int i = ViewConfiguration.getLongPressTimeout();
            if (GridHeadersGridView.this.isLongClickable())
            {
              if (GridHeadersGridView.this.Hjh == null) {
                GridHeadersGridView.this.Hjh = new GridHeadersGridView.a(GridHeadersGridView.this, (byte)0);
              }
              GridHeadersGridView.this.Hjh.fdb();
              GridHeadersGridView.d(GridHeadersGridView.this).postDelayed(GridHeadersGridView.this.Hjh, i);
              AppMethodBeat.o(142797);
              return;
            }
            GridHeadersGridView.this.avs = 2;
            AppMethodBeat.o(142797);
            return;
          }
          GridHeadersGridView.this.avs = 2;
        }
      }
      AppMethodBeat.o(142797);
    }
  }
  
  public static abstract interface d
  {
    public abstract boolean fda();
  }
  
  final class e
    extends GridHeadersGridView.f
    implements Runnable
  {
    int HjD;
    
    private e()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(142798);
      if (GridHeadersGridView.this.FVs)
      {
        AppMethodBeat.o(142798);
        return;
      }
      if ((GridHeadersGridView.this.Hjx != null) && (GridHeadersGridView.this.Hjx.getCount() > 0) && (this.HjD != -1) && (this.HjD < GridHeadersGridView.this.Hjx.getCount()) && (fdc()))
      {
        View localView = GridHeadersGridView.this.aab(this.HjD);
        if (localView != null)
        {
          GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
          GridHeadersGridView.a(GridHeadersGridView.this, this.HjD);
          if (localGridHeadersGridView.Hjt != null)
          {
            localGridHeadersGridView.playSoundEffect(0);
            if (localView != null) {
              localView.sendAccessibilityEvent(1);
            }
            localGridHeadersGridView.Hjt.dH(localView);
          }
        }
      }
      AppMethodBeat.o(142798);
    }
  }
  
  class f
  {
    private int FZO;
    
    private f() {}
    
    public final void fdb()
    {
      AppMethodBeat.i(142804);
      this.FZO = GridHeadersGridView.b(GridHeadersGridView.this);
      AppMethodBeat.o(142804);
    }
    
    public final boolean fdc()
    {
      AppMethodBeat.i(142805);
      if ((GridHeadersGridView.this.hasWindowFocus()) && (GridHeadersGridView.c(GridHeadersGridView.this) == this.FZO))
      {
        AppMethodBeat.o(142805);
        return true;
      }
      AppMethodBeat.o(142805);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView
 * JD-Core Version:    0.7.0.1
 */