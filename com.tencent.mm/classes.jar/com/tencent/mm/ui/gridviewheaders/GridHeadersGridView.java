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
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.List;

public class GridHeadersGridView
  extends GridView
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener
{
  public GridHeadersGridView.a AoL;
  public GridHeadersGridView.b AoM;
  private boolean AoN;
  private final Rect AoO;
  private boolean AoP;
  private boolean AoQ;
  private int AoR;
  private long AoS;
  private int AoT;
  private float AoU;
  private boolean AoV;
  private int AoW;
  GridHeadersGridView.c AoX;
  GridHeadersGridView.d AoY;
  private GridHeadersGridView.e AoZ;
  private View Apa;
  protected c Apb;
  protected int Apc;
  private boolean Apd;
  private DataSetObserver Jv;
  private AdapterView.OnItemSelectedListener Oh;
  private AdapterView.OnItemClickListener amh;
  protected int anS;
  private ak mHandler;
  private int mNumColumns;
  private int mScrollState;
  private int mTouchSlop;
  private AbsListView.OnScrollListener slC;
  protected boolean zhO;
  private int zhv;
  private int zhw;
  private Runnable zmf;
  private AdapterView.OnItemLongClickListener zsC;
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842865);
  }
  
  public GridHeadersGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107373);
    this.mHandler = new ak();
    this.AoN = true;
    this.AoO = new Rect();
    this.AoS = -1L;
    this.Jv = new GridHeadersGridView.1(this);
    this.AoW = 1;
    this.mScrollState = 0;
    this.Apd = true;
    super.setOnScrollListener(this);
    setVerticalFadingEdgeEnabled(false);
    if (!this.AoV) {
      this.mNumColumns = -1;
    }
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    AppMethodBeat.o(107373);
  }
  
  private void QL(int paramInt)
  {
    AppMethodBeat.i(107397);
    if ((this.Apb == null) || (this.Apb.getCount() == 0) || (!this.AoN))
    {
      AppMethodBeat.o(107397);
      return;
    }
    if ((c.d)getChildAt(0) == null)
    {
      AppMethodBeat.o(107397);
      return;
    }
    int j = paramInt - this.AoW;
    int i = j;
    if (j < 0) {
      i = paramInt;
    }
    int k = this.AoW + paramInt;
    j = k;
    if (k >= this.Apb.getCount()) {
      j = paramInt;
    }
    long l;
    Object localObject;
    label198:
    c.d locald;
    if (this.zhw != 0) {
      if (this.zhw < 0)
      {
        this.Apb.tC(paramInt);
        if (getChildAt(this.AoW).getTop() <= 0)
        {
          l = this.Apb.tC(j);
          i = j;
          if (this.AoS != l)
          {
            this.Apa = this.Apb.a(i, this.Apa, this);
            dNl();
            this.AoS = l;
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
          if (!this.AoP) {
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
      k += this.AoW;
      i = j;
      break label198;
      l = this.Apb.tC(paramInt);
      i = paramInt;
      break;
      j = getChildAt(0).getTop();
      if ((j > 0) && (j < this.zhw))
      {
        l = this.Apb.tC(i);
        break;
      }
      l = this.Apb.tC(paramInt);
      i = paramInt;
      break;
      label336:
      j = locald.getTop();
      break label234;
      label345:
      i = getHeaderHeight();
      if (localObject != null)
      {
        if ((paramInt == 0) && (super.getChildAt(0).getTop() > 0) && (!this.AoP))
        {
          this.AoT = 0;
          AppMethodBeat.o(107397);
          return;
        }
        if (this.AoP)
        {
          this.AoT = Math.min(localObject.getTop(), getPaddingTop() + i);
          if (this.AoT < getPaddingTop()) {}
          for (paramInt = i + getPaddingTop();; paramInt = this.AoT)
          {
            this.AoT = paramInt;
            AppMethodBeat.o(107397);
            return;
          }
        }
        this.AoT = Math.min(localObject.getTop(), i);
        if (this.AoT < 0) {}
        for (paramInt = i;; paramInt = this.AoT)
        {
          this.AoT = paramInt;
          AppMethodBeat.o(107397);
          return;
        }
      }
      this.AoT = i;
      if (this.AoP) {
        this.AoT += getPaddingTop();
      }
      label516:
      AppMethodBeat.o(107397);
      return;
      label522:
      j = i;
    }
  }
  
  private void dNl()
  {
    AppMethodBeat.i(107396);
    if (this.Apa == null)
    {
      AppMethodBeat.o(107396);
      return;
    }
    int j = View.MeasureSpec.makeMeasureSpec(getWidth() - getPaddingLeft() - getPaddingRight(), 1073741824);
    ViewGroup.LayoutParams localLayoutParams = this.Apa.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height > 0)) {}
    for (int i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);; i = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      this.Apa.measure(j, i);
      this.Apa.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.Apa.getMeasuredHeight());
      AppMethodBeat.o(107396);
      return;
    }
  }
  
  private int getHeaderHeight()
  {
    AppMethodBeat.i(107395);
    if (this.Apa != null)
    {
      int i = this.Apa.getMeasuredHeight();
      AppMethodBeat.o(107395);
      return i;
    }
    AppMethodBeat.o(107395);
    return 0;
  }
  
  private void reset()
  {
    this.AoT = 0;
    this.Apa = null;
    this.AoS = -9223372036854775808L;
  }
  
  public final View QK(int paramInt)
  {
    AppMethodBeat.i(107374);
    View localView;
    if (paramInt == -2)
    {
      localView = this.Apa;
      AppMethodBeat.o(107374);
      return localView;
    }
    try
    {
      localView = (View)getChildAt(paramInt).getTag();
      AppMethodBeat.o(107374);
      return localView;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(107374);
    }
    return null;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(107398);
    if (Build.VERSION.SDK_INT < 8) {
      QL(getFirstVisiblePosition());
    }
    if ((this.Apa != null) && (this.AoN) && (this.Apa.getVisibility() == 0)) {}
    int m;
    int n;
    ArrayList localArrayList;
    int k;
    for (int i = 1;; i = 0)
    {
      m = getHeaderHeight();
      n = this.AoT - m;
      if ((i != 0) && (this.Apd))
      {
        this.AoO.left = getPaddingLeft();
        this.AoO.right = (getWidth() - getPaddingRight());
        this.AoO.top = this.AoT;
        this.AoO.bottom = getHeight();
        paramCanvas.save();
        paramCanvas.clipRect(this.AoO);
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
        k += this.AoW;
        j += this.AoW;
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
          if ((((c.b)locald.getChildAt(0)).getHeaderId() == this.AoS) && (locald.getTop() < 0) && (this.AoN))
          {
            k = 1;
            if ((localView.getVisibility() == 0) && (k == 0))
            {
              localView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight()), View.MeasureSpec.makeMeasureSpec(0, 0));
              localView.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), locald.getHeight());
              this.AoO.left = getPaddingLeft();
              this.AoO.right = (getWidth() - getPaddingRight());
              this.AoO.bottom = locald.getBottom();
              this.AoO.top = locald.getTop();
              paramCanvas.save();
              paramCanvas.clipRect(this.AoO);
              paramCanvas.translate(getPaddingLeft(), locald.getTop());
              localView.draw(paramCanvas);
              paramCanvas.restore();
            }
            j += 1;
          }
        }
        catch (Exception paramCanvas)
        {
          AppMethodBeat.o(107398);
          return;
        }
        k = 0;
      }
    }
    if ((i != 0) && (this.Apd))
    {
      paramCanvas.restore();
      if (this.Apa.getWidth() != getWidth() - getPaddingLeft() - getPaddingRight())
      {
        i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824 - getPaddingLeft() - getPaddingRight());
        j = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.Apa.measure(i, j);
        this.Apa.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.Apa.getHeight());
      }
      this.AoO.left = getPaddingLeft();
      this.AoO.right = (getWidth() - getPaddingRight());
      this.AoO.bottom = (n + m);
      if (!this.AoP) {
        break label741;
      }
    }
    label741:
    for (this.AoO.top = getPaddingTop();; this.AoO.top = 0)
    {
      paramCanvas.save();
      paramCanvas.clipRect(this.AoO);
      paramCanvas.translate(getPaddingLeft(), n);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), (int)(255.0F * this.AoT / m), 31);
      this.Apa.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      AppMethodBeat.o(107398);
      return;
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(107398);
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = -2;
    AppMethodBeat.i(107383);
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
      AppMethodBeat.o(107383);
      return false;
      if (this.AoM == null) {
        this.AoM = new GridHeadersGridView.b(this);
      }
      this.mHandler.postDelayed(this.AoL, ViewConfiguration.getTapTimeout());
      i = (int)paramMotionEvent.getY();
      this.AoU = i;
      float f = i;
      if ((this.Apa != null) && (f <= this.Apa.getBottom())) {}
      for (;;)
      {
        this.Apc = j;
        if ((this.Apc == -1) || (this.mScrollState == 2)) {
          break;
        }
        this.anS = 0;
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
          k += this.AoW;
          i += this.AoW;
        }
        label247:
        j = -1;
      }
      if ((this.Apc == -1) || (Math.abs(paramMotionEvent.getY() - this.AoU) <= this.mTouchSlop)) {
        break;
      }
      this.anS = -1;
      Object localObject = QK(this.Apc);
      if (localObject != null) {
        ((View)localObject).setPressed(false);
      }
      if (this.AoL != null) {
        this.mHandler.removeCallbacks(this.AoL);
      }
      this.Apc = -1;
      break;
      if ((this.anS == -2) || (this.anS == -1) || (this.Apc == -1)) {
        break;
      }
      View localView = QK(this.Apc);
      GridHeadersGridView.e locale;
      if ((localView != null) && (!localView.hasFocusable()))
      {
        if (this.anS != 0) {
          localView.setPressed(false);
        }
        if (this.AoZ == null) {
          this.AoZ = new GridHeadersGridView.e(this, (byte)0);
        }
        locale = this.AoZ;
        locale.Aph = this.Apc;
        locale.dNn();
        if ((this.anS == 0) && (this.anS == 1)) {
          break label574;
        }
        localak = this.mHandler;
        if (this.anS == 0) {}
        for (localObject = this.AoM;; localObject = this.AoL)
        {
          localak.removeCallbacks((Runnable)localObject);
          if (this.zhO) {
            break label561;
          }
          this.anS = 1;
          localView.setPressed(true);
          setPressed(true);
          if (this.zmf != null) {
            removeCallbacks(this.zmf);
          }
          this.zmf = new GridHeadersGridView.2(this, localView, locale);
          this.mHandler.postDelayed(this.zmf, ViewConfiguration.getPressedStateDuration());
          i = 1;
          break;
        }
        label561:
        this.anS = -1;
      }
      label574:
      while (this.zhO)
      {
        ak localak;
        this.anS = -1;
        break;
      }
      locale.run();
      i = 1;
    }
    label591:
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(107383);
    return bool;
  }
  
  public View getStickiedHeader()
  {
    return this.Apa;
  }
  
  public boolean getStickyHeaderIsTranscluent()
  {
    return !this.Apd;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107375);
    this.amh.onItemClick(paramAdapterView, paramView, this.Apb.QJ(paramInt).mPosition, paramLong);
    AppMethodBeat.o(107375);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107376);
    boolean bool = this.zsC.onItemLongClick(paramAdapterView, paramView, this.Apb.QJ(paramInt).mPosition, paramLong);
    AppMethodBeat.o(107376);
    return bool;
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107377);
    this.Oh.onItemSelected(paramAdapterView, paramView, this.Apb.QJ(paramInt).mPosition, paramLong);
    AppMethodBeat.o(107377);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(107399);
    if (this.mNumColumns == -1) {
      if (this.AoR > 0)
      {
        int k = Math.max(View.MeasureSpec.getSize(paramInt1) - getPaddingLeft() - getPaddingRight(), 0);
        int j = k / this.AoR;
        if (j > 0)
        {
          i = j;
          while ((i != 1) && (this.AoR * i + (i - 1) * this.zhv > k)) {
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
      for (this.AoW = i;; this.AoW = this.mNumColumns)
      {
        if (this.Apb != null) {
          this.Apb.setNumColumns(this.AoW);
        }
        dNl();
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(107399);
        return;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AppMethodBeat.i(107378);
    this.Oh.onNothingSelected(paramAdapterView);
    AppMethodBeat.o(107378);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(107379);
    paramParcelable = (GridHeadersGridView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.AoN = paramParcelable.Api;
    requestLayout();
    AppMethodBeat.o(107379);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(107380);
    GridHeadersGridView.SavedState localSavedState = new GridHeadersGridView.SavedState(super.onSaveInstanceState());
    localSavedState.Api = this.AoN;
    AppMethodBeat.o(107380);
    return localSavedState;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107381);
    if (this.slC != null) {
      this.slC.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (Build.VERSION.SDK_INT >= 8) {
      QL(paramInt1);
    }
    AppMethodBeat.o(107381);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(107382);
    if (this.slC != null) {
      this.slC.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.mScrollState = paramInt;
    AppMethodBeat.o(107382);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(107384);
    if ((this.Apb != null) && (this.Jv != null)) {
      this.Apb.unregisterDataSetObserver(this.Jv);
    }
    if (!this.AoQ) {
      this.AoP = true;
    }
    if ((paramListAdapter instanceof b)) {
      paramListAdapter = (b)paramListAdapter;
    }
    for (;;)
    {
      this.Apb = new c(getContext(), this, paramListAdapter);
      this.Apb.registerDataSetObserver(this.Jv);
      reset();
      super.setAdapter(this.Apb);
      AppMethodBeat.o(107384);
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
    AppMethodBeat.i(107385);
    if (paramBoolean != this.AoN)
    {
      this.AoN = paramBoolean;
      requestLayout();
    }
    AppMethodBeat.o(107385);
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(107386);
    super.setClipToPadding(paramBoolean);
    this.AoP = paramBoolean;
    this.AoQ = true;
    AppMethodBeat.o(107386);
  }
  
  public void setColumnWidth(int paramInt)
  {
    AppMethodBeat.i(107387);
    super.setColumnWidth(paramInt);
    this.AoR = paramInt;
    AppMethodBeat.o(107387);
  }
  
  public void setHorizontalSpacing(int paramInt)
  {
    AppMethodBeat.i(107388);
    super.setHorizontalSpacing(paramInt);
    this.zhv = paramInt;
    AppMethodBeat.o(107388);
  }
  
  public void setNumColumns(int paramInt)
  {
    AppMethodBeat.i(107389);
    super.setNumColumns(paramInt);
    this.AoV = true;
    this.mNumColumns = paramInt;
    if ((paramInt != -1) && (this.Apb != null)) {
      this.Apb.setNumColumns(paramInt);
    }
    AppMethodBeat.o(107389);
  }
  
  public void setOnHeaderClickListener(GridHeadersGridView.c paramc)
  {
    this.AoX = paramc;
  }
  
  public void setOnHeaderLongClickListener(GridHeadersGridView.d paramd)
  {
    AppMethodBeat.i(107390);
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.AoY = paramd;
    AppMethodBeat.o(107390);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(107391);
    this.amh = paramOnItemClickListener;
    super.setOnItemClickListener(this);
    AppMethodBeat.o(107391);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(107392);
    this.zsC = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(this);
    AppMethodBeat.o(107392);
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    AppMethodBeat.i(107393);
    this.Oh = paramOnItemSelectedListener;
    super.setOnItemSelectedListener(this);
    AppMethodBeat.o(107393);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.slC = paramOnScrollListener;
  }
  
  public void setStickyHeaderIsTranscluent(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Apd = paramBoolean;
      return;
    }
  }
  
  public void setVerticalSpacing(int paramInt)
  {
    AppMethodBeat.i(107394);
    super.setVerticalSpacing(paramInt);
    this.zhw = paramInt;
    AppMethodBeat.o(107394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.GridHeadersGridView
 * JD-Core Version:    0.7.0.1
 */