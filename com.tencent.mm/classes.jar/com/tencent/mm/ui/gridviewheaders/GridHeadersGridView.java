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
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.List;

public class GridHeadersGridView
  extends GridView
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  private DataSetObserver JP = new GridHeadersGridView.1(this);
  private AdapterView.OnItemSelectedListener Ot;
  private AdapterView.OnItemClickListener ajR;
  protected int alA;
  private int jb;
  private int lf = 0;
  private ah mHandler = new ah();
  private int mNumColumns;
  private AbsListView.OnScrollListener pqK;
  private int uSV;
  private int uSW;
  protected boolean uTo;
  private Runnable uXO;
  public a vWD;
  public GridHeadersGridView.b vWE;
  private boolean vWF = true;
  private final Rect vWG = new Rect();
  private boolean vWH;
  private boolean vWI;
  private int vWJ;
  private long vWK = -1L;
  private int vWL;
  private float vWM;
  private boolean vWN;
  private int vWO = 1;
  GridHeadersGridView.c vWP;
  GridHeadersGridView.d vWQ;
  private GridHeadersGridView.e vWR;
  private View vWS;
  protected c vWT;
  protected int vWU;
  private boolean vWV = true;
  private AdapterView.OnItemLongClickListener vec;
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842865);
  }
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setOnScrollListener(this);
    setVerticalFadingEdgeEnabled(false);
    if (!this.vWN) {
      this.mNumColumns = -1;
    }
    this.jb = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void HZ(int paramInt)
  {
    if ((this.vWT == null) || (this.vWT.getCount() == 0) || (!this.vWF)) {}
    int j;
    long l;
    label125:
    int m;
    do
    {
      do
      {
        return;
      } while ((c.d)getChildAt(0) == null);
      j = paramInt - this.vWO;
      i = j;
      if (j < 0) {
        i = paramInt;
      }
      k = this.vWO + paramInt;
      j = k;
      if (k >= this.vWT.getCount()) {
        j = paramInt;
      }
      if (this.uSW == 0) {
        break label305;
      }
      if (this.uSW >= 0) {
        break label271;
      }
      this.vWT.pm(paramInt);
      if (getChildAt(this.vWO).getTop() > 0) {
        break;
      }
      l = this.vWT.pm(j);
      i = j;
      if (this.vWK != l)
      {
        this.vWS = this.vWT.a(i, this.vWS, this);
        cIB();
        this.vWK = l;
      }
      m = getChildCount();
    } while (m == 0);
    Object localObject = null;
    int i = 99999;
    int k = 0;
    label182:
    c.d locald;
    if (k < m)
    {
      locald = (c.d)super.getChildAt(k);
      if (this.vWH)
      {
        j = locald.getTop() - getPaddingTop();
        label218:
        if ((j < 0) || (!(locald.getView() instanceof c.b)) || (j >= i)) {
          break label486;
        }
        localObject = locald;
      }
    }
    for (;;)
    {
      k += this.vWO;
      i = j;
      break label182;
      l = this.vWT.pm(paramInt);
      i = paramInt;
      break label125;
      label271:
      j = getChildAt(0).getTop();
      if ((j > 0) && (j < this.uSW))
      {
        l = this.vWT.pm(i);
        break label125;
      }
      label305:
      l = this.vWT.pm(paramInt);
      i = paramInt;
      break label125;
      j = locald.getTop();
      break label218;
      i = getHeaderHeight();
      if (localObject != null)
      {
        if ((paramInt == 0) && (super.getChildAt(0).getTop() > 0) && (!this.vWH))
        {
          this.vWL = 0;
          return;
        }
        if (this.vWH)
        {
          this.vWL = Math.min(localObject.getTop(), getPaddingTop() + i);
          if (this.vWL < getPaddingTop()) {}
          for (paramInt = i + getPaddingTop();; paramInt = this.vWL)
          {
            this.vWL = paramInt;
            return;
          }
        }
        this.vWL = Math.min(localObject.getTop(), i);
        if (this.vWL < 0) {}
        for (paramInt = i;; paramInt = this.vWL)
        {
          this.vWL = paramInt;
          return;
        }
      }
      this.vWL = i;
      if (!this.vWH) {
        break;
      }
      this.vWL += getPaddingTop();
      return;
      label486:
      j = i;
    }
  }
  
  private void cIB()
  {
    if (this.vWS == null) {
      return;
    }
    int j = View.MeasureSpec.makeMeasureSpec(getWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
    ViewGroup.LayoutParams localLayoutParams = this.vWS.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height > 0)) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      this.vWS.measure(j, i);
      this.vWS.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.vWS.getMeasuredHeight());
      return;
    }
  }
  
  private int getHeaderHeight()
  {
    if (this.vWS != null) {
      return this.vWS.getMeasuredHeight();
    }
    return 0;
  }
  
  private void reset()
  {
    this.vWL = 0;
    this.vWS = null;
    this.vWK = -9223372036854775808L;
  }
  
  public final View HY(int paramInt)
  {
    if (paramInt == -2) {
      return this.vWS;
    }
    try
    {
      View localView = (View)getChildAt(paramInt).getTag();
      return localView;
    }
    catch (Exception localException) {}
    return null;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (Build.VERSION.SDK_INT < 8) {
      HZ(getFirstVisiblePosition());
    }
    if ((this.vWS != null) && (this.vWF) && (this.vWS.getVisibility() == 0)) {}
    int m;
    int n;
    ArrayList localArrayList;
    int k;
    for (int i = 1;; i = 0)
    {
      m = getHeaderHeight();
      n = this.vWL - m;
      if ((i != 0) && (this.vWV))
      {
        this.vWG.left = getPaddingLeft();
        this.vWG.right = (getWidth() - getPaddingRight());
        this.vWG.top = this.vWL;
        this.vWG.bottom = getHeight();
        paramCanvas.save();
        paramCanvas.clipRect(this.vWG);
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
        k += this.vWO;
        j += this.vWO;
      }
    }
    int j = 0;
    for (;;)
    {
      c.d locald;
      if (j < localArrayList.size()) {
        locald = (c.d)getChildAt(((Integer)localArrayList.get(j)).intValue());
      }
      try
      {
        View localView = (View)locald.getTag();
        if ((((c.b)locald.getChildAt(0)).getHeaderId() == this.vWK) && (locald.getTop() < 0) && (this.vWF)) {}
        for (k = 1;; k = 0)
        {
          if ((localView.getVisibility() == 0) && (k == 0))
          {
            localView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight()), View.MeasureSpec.makeMeasureSpec(0, 0));
            localView.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), locald.getHeight());
            this.vWG.left = getPaddingLeft();
            this.vWG.right = (getWidth() - getPaddingRight());
            this.vWG.bottom = locald.getBottom();
            this.vWG.top = locald.getTop();
            paramCanvas.save();
            paramCanvas.clipRect(this.vWG);
            paramCanvas.translate(getPaddingLeft(), locald.getTop());
            localView.draw(paramCanvas);
            paramCanvas.restore();
          }
          j += 1;
          break;
        }
        if ((i != 0) && (this.vWV))
        {
          paramCanvas.restore();
          if (this.vWS.getWidth() != getWidth() - getPaddingLeft() - getPaddingRight())
          {
            i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight());
            j = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.vWS.measure(i, j);
            this.vWS.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.vWS.getHeight());
          }
          this.vWG.left = getPaddingLeft();
          this.vWG.right = (getWidth() - getPaddingRight());
          this.vWG.bottom = (n + m);
          if (!this.vWH) {
            break label714;
          }
        }
        label714:
        for (this.vWG.top = getPaddingTop();; this.vWG.top = 0)
        {
          paramCanvas.save();
          paramCanvas.clipRect(this.vWG);
          paramCanvas.translate(getPaddingLeft(), n);
          paramCanvas.saveLayerAlpha(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), (int)(255.0F * this.vWL / m), 4);
          this.vWS.draw(paramCanvas);
          paramCanvas.restore();
          paramCanvas.restore();
          return;
          if (i != 0) {
            break;
          }
          return;
        }
        return;
      }
      catch (Exception paramCanvas) {}
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = -2;
    int i;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label581;
      }
      return false;
      if (this.vWE == null) {
        this.vWE = new GridHeadersGridView.b(this);
      }
      this.mHandler.postDelayed(this.vWD, ViewConfiguration.getTapTimeout());
      i = (int)paramMotionEvent.getY();
      this.vWM = i;
      float f = i;
      if ((this.vWS != null) && (f <= this.vWS.getBottom())) {}
      for (;;)
      {
        this.vWU = j;
        if ((this.vWU == -1) || (this.lf == 2)) {
          break;
        }
        this.alA = 0;
        break;
        int k = getFirstVisiblePosition();
        i = 0;
        for (;;)
        {
          if (k > getLastVisiblePosition()) {
            break label237;
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
          k += this.vWO;
          i += this.vWO;
        }
        label237:
        j = -1;
      }
      if ((this.vWU == -1) || (Math.abs(paramMotionEvent.getY() - this.vWM) <= this.jb)) {
        break;
      }
      this.alA = -1;
      Object localObject = HY(this.vWU);
      if (localObject != null) {
        ((View)localObject).setPressed(false);
      }
      if (this.vWD != null) {
        this.mHandler.removeCallbacks(this.vWD);
      }
      this.vWU = -1;
      break;
      if ((this.alA == -2) || (this.alA == -1) || (this.vWU == -1)) {
        break;
      }
      View localView = HY(this.vWU);
      GridHeadersGridView.e locale;
      if ((localView != null) && (!localView.hasFocusable()))
      {
        if (this.alA != 0) {
          localView.setPressed(false);
        }
        if (this.vWR == null) {
          this.vWR = new GridHeadersGridView.e(this, (byte)0);
        }
        locale = this.vWR;
        locale.vWZ = this.vWU;
        locale.cID();
        if ((this.alA == 0) && (this.alA == 1)) {
          break label564;
        }
        localah = this.mHandler;
        if (this.alA == 0) {}
        for (localObject = this.vWE;; localObject = this.vWD)
        {
          localah.removeCallbacks((Runnable)localObject);
          if (this.uTo) {
            break label551;
          }
          this.alA = 1;
          localView.setPressed(true);
          setPressed(true);
          if (this.uXO != null) {
            removeCallbacks(this.uXO);
          }
          this.uXO = new GridHeadersGridView.2(this, localView, locale);
          this.mHandler.postDelayed(this.uXO, ViewConfiguration.getPressedStateDuration());
          i = 1;
          break;
        }
        label551:
        this.alA = -1;
      }
      label564:
      while (this.uTo)
      {
        ah localah;
        this.alA = -1;
        break;
      }
      locale.run();
      i = 1;
    }
    label581:
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public View getStickiedHeader()
  {
    return this.vWS;
  }
  
  public boolean getStickyHeaderIsTranscluent()
  {
    return !this.vWV;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.ajR.onItemClick(paramAdapterView, paramView, this.vWT.HX(paramInt).mPosition, paramLong);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return this.vec.onItemLongClick(paramAdapterView, paramView, this.vWT.HX(paramInt).mPosition, paramLong);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.Ot.onItemSelected(paramAdapterView, paramView, this.vWT.HX(paramInt).mPosition, paramLong);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (this.mNumColumns == -1) {
      if (this.vWJ > 0)
      {
        int k = Math.max(View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight(), 0);
        int j = k / this.vWJ;
        if (j > 0)
        {
          i = j;
          while ((i != 1) && (this.vWJ * i + (i - 1) * this.uSV > k)) {
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
      for (this.vWO = i;; this.vWO = this.mNumColumns)
      {
        if (this.vWT != null) {
          this.vWT.setNumColumns(this.vWO);
        }
        cIB();
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    this.Ot.onNothingSelected(paramAdapterView);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (GridHeadersGridView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.vWF = paramParcelable.vXa;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    GridHeadersGridView.SavedState localSavedState = new GridHeadersGridView.SavedState(super.onSaveInstanceState());
    localSavedState.vXa = this.vWF;
    return localSavedState;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.pqK != null) {
      this.pqK.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (Build.VERSION.SDK_INT >= 8) {
      HZ(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.pqK != null) {
      this.pqK.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.lf = paramInt;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((this.vWT != null) && (this.JP != null)) {
      this.vWT.unregisterDataSetObserver(this.JP);
    }
    if (!this.vWI) {
      this.vWH = true;
    }
    if ((paramListAdapter instanceof b)) {
      paramListAdapter = (b)paramListAdapter;
    }
    for (;;)
    {
      this.vWT = new c(getContext(), this, paramListAdapter);
      this.vWT.registerDataSetObserver(this.JP);
      reset();
      super.setAdapter(this.vWT);
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
    if (paramBoolean != this.vWF)
    {
      this.vWF = paramBoolean;
      requestLayout();
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    super.setClipToPadding(paramBoolean);
    this.vWH = paramBoolean;
    this.vWI = true;
  }
  
  public void setColumnWidth(int paramInt)
  {
    super.setColumnWidth(paramInt);
    this.vWJ = paramInt;
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    super.setHorizontalSpacing(paramInt);
    this.uSV = paramInt;
  }
  
  public void setNumColumns(int paramInt)
  {
    super.setNumColumns(paramInt);
    this.vWN = true;
    this.mNumColumns = paramInt;
    if ((paramInt != -1) && (this.vWT != null)) {
      this.vWT.setNumColumns(paramInt);
    }
  }
  
  public void setOnHeaderClickListener(GridHeadersGridView.c paramc)
  {
    this.vWP = paramc;
  }
  
  public void setOnHeaderLongClickListener(GridHeadersGridView.d paramd)
  {
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.vWQ = paramd;
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.ajR = paramOnItemClickListener;
    super.setOnItemClickListener(this);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.vec = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(this);
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.Ot = paramOnItemSelectedListener;
    super.setOnItemSelectedListener(this);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.pqK = paramOnScrollListener;
  }
  
  public void setStickyHeaderIsTranscluent(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.vWV = paramBoolean;
      return;
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    super.setVerticalSpacing(paramInt);
    this.uSW = paramInt;
  }
  
  private final class a
    extends GridHeadersGridView.f
    implements Runnable
  {
    private a()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      View localView = GridHeadersGridView.this.HY(GridHeadersGridView.this.vWU);
      boolean bool1;
      if (localView != null)
      {
        GridHeadersGridView.a(GridHeadersGridView.this, GridHeadersGridView.this.vWU);
        if ((!cIE()) || (GridHeadersGridView.this.uTo)) {
          break label141;
        }
        GridHeadersGridView localGridHeadersGridView = GridHeadersGridView.this;
        if (localGridHeadersGridView.vWQ == null) {
          break label136;
        }
        bool1 = localGridHeadersGridView.vWQ.cIC();
        bool2 = bool1;
        if (bool1)
        {
          if (localView != null) {
            localView.sendAccessibilityEvent(2);
          }
          localGridHeadersGridView.performHapticFeedback(0);
        }
      }
      label136:
      label141:
      for (boolean bool2 = bool1;; bool2 = false)
      {
        if (bool2)
        {
          GridHeadersGridView.this.alA = -2;
          GridHeadersGridView.this.setPressed(false);
          localView.setPressed(false);
          return;
        }
        GridHeadersGridView.this.alA = 2;
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView
 * JD-Core Version:    0.7.0.1
 */