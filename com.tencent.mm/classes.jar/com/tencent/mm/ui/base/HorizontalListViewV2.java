package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.t;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.EdgeEffect;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListViewV2
  extends AdapterView<ListAdapter>
{
  private Drawable acK;
  private int agh;
  private GestureDetector idY;
  private View.OnClickListener mOnClickListener;
  private Rect mRect;
  protected ListAdapter xw;
  protected int zhG;
  protected int zhH;
  private int zhI;
  private int zhJ;
  private boolean zhO;
  protected Scroller zhS;
  private final HorizontalListViewV2.a zhT;
  private List<Queue<View>> zhU;
  private View zhV;
  private Integer zhW;
  private int zhX;
  private int zhY;
  private int zhZ;
  private HorizontalListViewV2.e zia;
  private int zib;
  private boolean zic;
  private HorizontalListViewV2.d zid;
  private HorizontalListViewV2.d.a zie;
  private i zif;
  private i zig;
  private int zih;
  private boolean zii;
  private boolean zij;
  private DataSetObserver zik;
  private Runnable zil;
  
  public HorizontalListViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(106344);
    this.zhS = new Scroller(getContext());
    this.zhT = new HorizontalListViewV2.a(this, (byte)0);
    this.zhU = new ArrayList();
    this.zhO = false;
    this.mRect = new Rect();
    this.zhV = null;
    this.agh = 0;
    this.acK = null;
    this.zhW = null;
    this.zhI = 2147483647;
    this.zia = null;
    this.zib = 0;
    this.zic = false;
    this.zid = null;
    this.zie = HorizontalListViewV2.d.a.zin;
    this.zii = false;
    this.zij = false;
    this.zik = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(106329);
        HorizontalListViewV2.b(HorizontalListViewV2.this);
        HorizontalListViewV2.c(HorizontalListViewV2.this);
        HorizontalListViewV2.d(HorizontalListViewV2.this);
        HorizontalListViewV2.this.invalidate();
        HorizontalListViewV2.this.requestLayout();
        AppMethodBeat.o(106329);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(106330);
        HorizontalListViewV2.c(HorizontalListViewV2.this);
        HorizontalListViewV2.d(HorizontalListViewV2.this);
        HorizontalListViewV2.e(HorizontalListViewV2.this);
        HorizontalListViewV2.this.invalidate();
        HorizontalListViewV2.this.requestLayout();
        AppMethodBeat.o(106330);
      }
    };
    this.zil = new HorizontalListViewV2.3(this);
    this.zif = new i(paramContext);
    this.zig = new i(paramContext);
    this.idY = new GestureDetector(paramContext, this.zhT);
    setOnTouchListener(new HorizontalListViewV2.1(this));
    initView();
    setWillNotDraw(false);
    if (Build.VERSION.SDK_INT >= 11) {
      HorizontalListViewV2.b.a(this.zhS);
    }
    AppMethodBeat.o(106344);
  }
  
  private boolean OA(int paramInt)
  {
    AppMethodBeat.i(106367);
    if (paramInt == this.xw.getCount() - 1)
    {
      AppMethodBeat.o(106367);
      return true;
    }
    AppMethodBeat.o(106367);
    return false;
  }
  
  private View Oy(int paramInt)
  {
    AppMethodBeat.i(106354);
    paramInt = this.xw.getItemViewType(paramInt);
    if (Oz(paramInt))
    {
      View localView = (View)((Queue)this.zhU.get(paramInt)).poll();
      AppMethodBeat.o(106354);
      return localView;
    }
    AppMethodBeat.o(106354);
    return null;
  }
  
  private boolean Oz(int paramInt)
  {
    AppMethodBeat.i(106356);
    if (paramInt < this.zhU.size())
    {
      AppMethodBeat.o(106356);
      return true;
    }
    AppMethodBeat.o(106356);
    return false;
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    AppMethodBeat.i(106371);
    if (this.acK != null)
    {
      this.acK.setBounds(paramRect);
      this.acK.draw(paramCanvas);
    }
    AppMethodBeat.o(106371);
  }
  
  private void am(View paramView, int paramInt)
  {
    AppMethodBeat.i(106357);
    addViewInLayout(paramView, paramInt, eL(paramView), true);
    ViewGroup.LayoutParams localLayoutParams = eL(paramView);
    int i = ViewGroup.getChildMeasureSpec(this.zih, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    if (localLayoutParams.width > 0) {}
    for (paramInt = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);; paramInt = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt, i);
      AppMethodBeat.o(106357);
      return;
    }
  }
  
  private float dDD()
  {
    AppMethodBeat.i(106362);
    if (Build.VERSION.SDK_INT >= 14)
    {
      float f = HorizontalListViewV2.c.b(this.zhS);
      AppMethodBeat.o(106362);
      return f;
    }
    AppMethodBeat.o(106362);
    return 30.0F;
  }
  
  private void dDF()
  {
    AppMethodBeat.i(106376);
    if (this.zhV != null)
    {
      this.zhV.setPressed(false);
      refreshDrawableState();
      this.zhV = null;
    }
    AppMethodBeat.o(106376);
  }
  
  private void dDG()
  {
    AppMethodBeat.i(106378);
    if (this.zif != null) {
      this.zif.ec();
    }
    if (this.zig != null) {
      this.zig.ec();
    }
    AppMethodBeat.o(106378);
  }
  
  private static ViewGroup.LayoutParams eL(View paramView)
  {
    AppMethodBeat.i(106358);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (localLayoutParams == null) {
      paramView = new ViewGroup.LayoutParams(-2, -1);
    }
    AppMethodBeat.o(106358);
    return paramView;
  }
  
  private View getLeftmostChild()
  {
    AppMethodBeat.i(106364);
    View localView = getChildAt(0);
    AppMethodBeat.o(106364);
    return localView;
  }
  
  private int getRenderHeight()
  {
    AppMethodBeat.i(106368);
    int i = getHeight();
    int j = getPaddingTop();
    int k = getPaddingBottom();
    AppMethodBeat.o(106368);
    return i - j - k;
  }
  
  private int getRenderWidth()
  {
    AppMethodBeat.i(106369);
    int i = getWidth();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(106369);
    return i - j - k;
  }
  
  private View getRightmostChild()
  {
    AppMethodBeat.i(106365);
    View localView = getChildAt(getChildCount() - 1);
    AppMethodBeat.o(106365);
    return localView;
  }
  
  private int hu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106366);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).getHitRect(this.mRect);
      if (this.mRect.contains(paramInt1, paramInt2))
      {
        AppMethodBeat.o(106366);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(106366);
    return -1;
  }
  
  private void i(int paramInt, View paramView)
  {
    AppMethodBeat.i(106355);
    paramInt = this.xw.getItemViewType(paramInt);
    if (Oz(paramInt)) {
      ((Queue)this.zhU.get(paramInt)).offer(paramView);
    }
    AppMethodBeat.o(106355);
  }
  
  private void initView()
  {
    AppMethodBeat.i(106350);
    this.zhX = -1;
    this.zhY = -1;
    this.zhJ = 0;
    this.zhG = 0;
    this.zhH = 0;
    this.zhI = 2147483647;
    setCurrentScrollState(HorizontalListViewV2.d.a.zin);
    AppMethodBeat.o(106350);
  }
  
  private void k(Boolean paramBoolean)
  {
    AppMethodBeat.i(106345);
    if (this.zij != paramBoolean.booleanValue()) {
      for (Object localObject = this; (((View)localObject).getParent() instanceof View); localObject = (View)((View)localObject).getParent()) {
        if (((((View)localObject).getParent() instanceof ListView)) || ((((View)localObject).getParent() instanceof ScrollView)))
        {
          ((View)localObject).getParent().requestDisallowInterceptTouchEvent(paramBoolean.booleanValue());
          this.zij = paramBoolean.booleanValue();
          AppMethodBeat.o(106345);
          return;
        }
      }
    }
    AppMethodBeat.o(106345);
  }
  
  private void reset()
  {
    AppMethodBeat.i(106351);
    initView();
    removeAllViewsInLayout();
    requestLayout();
    AppMethodBeat.o(106351);
  }
  
  private void setCurrentScrollState(HorizontalListViewV2.d.a parama)
  {
    AppMethodBeat.i(106379);
    if ((this.zie != parama) && (this.zid != null)) {
      this.zid.a(parama);
    }
    this.zie = parama;
    AppMethodBeat.o(106379);
  }
  
  protected final boolean bt(float paramFloat)
  {
    AppMethodBeat.i(106374);
    this.zhS.fling(this.zhH, 0, (int)-paramFloat, 0, 0, this.zhI, 0, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.ziq);
    requestLayout();
    AppMethodBeat.o(106374);
    return true;
  }
  
  public final void dDE()
  {
    AppMethodBeat.i(106370);
    this.zhS.startScroll(this.zhH, 0, 0 - this.zhH, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.ziq);
    requestLayout();
    AppMethodBeat.o(106370);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106373);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(106373);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  public ListAdapter getAdapter()
  {
    return this.xw;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.zhX;
  }
  
  public int getLastVisiblePosition()
  {
    return this.zhY;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(106360);
    int i = getHorizontalFadingEdgeLength();
    if (this.zhG == 0)
    {
      AppMethodBeat.o(106360);
      return 0.0F;
    }
    if (this.zhG < i)
    {
      float f = this.zhG / i;
      AppMethodBeat.o(106360);
      return f;
    }
    AppMethodBeat.o(106360);
    return 1.0F;
  }
  
  protected float getRightFadingEdgeStrength()
  {
    AppMethodBeat.i(106361);
    int i = getHorizontalFadingEdgeLength();
    if (this.zhG == this.zhI)
    {
      AppMethodBeat.o(106361);
      return 0.0F;
    }
    if (this.zhI - this.zhG < i)
    {
      float f = (this.zhI - this.zhG) / i;
      AppMethodBeat.o(106361);
      return f;
    }
    AppMethodBeat.o(106361);
    return 1.0F;
  }
  
  public View getSelectedView()
  {
    AppMethodBeat.i(106352);
    int i = this.zhZ;
    if ((i >= this.zhX) && (i <= this.zhY))
    {
      View localView = getChildAt(i - this.zhX);
      AppMethodBeat.o(106352);
      return localView;
    }
    AppMethodBeat.o(106352);
    return null;
  }
  
  protected final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106375);
    if (!this.zhS.isFinished()) {}
    for (boolean bool = true;; bool = false)
    {
      this.zii = bool;
      this.zhS.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.zin);
      dDF();
      if (!this.zii)
      {
        int i = hu((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (i >= 0)
        {
          this.zhV = getChildAt(i);
          if (this.zhV != null)
          {
            this.zhV.setPressed(true);
            refreshDrawableState();
          }
        }
      }
      AppMethodBeat.o(106375);
      return true;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106372);
    super.onDraw(paramCanvas);
    int j = getChildCount();
    Rect localRect = this.mRect;
    this.mRect.top = getPaddingTop();
    this.mRect.bottom = (this.mRect.top + getRenderHeight());
    int i = 0;
    while (i < j)
    {
      if ((i != j - 1) || (!OA(this.zhY)))
      {
        View localView = getChildAt(i);
        localRect.left = localView.getRight();
        localRect.right = (localView.getRight() + this.agh);
        if (localRect.left < getPaddingLeft()) {
          localRect.left = getPaddingLeft();
        }
        if (localRect.right > getWidth() - getPaddingRight()) {
          localRect.right = (getWidth() - getPaddingRight());
        }
        a(paramCanvas, localRect);
        if ((i == 0) && (localView.getLeft() > getPaddingLeft()))
        {
          localRect.left = getPaddingLeft();
          localRect.right = localView.getLeft();
          a(paramCanvas, localRect);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(106372);
  }
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106359);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.xw == null)
    {
      AppMethodBeat.o(106359);
      return;
    }
    invalidate();
    if (this.zhO)
    {
      i = this.zhG;
      initView();
      removeAllViewsInLayout();
      this.zhH = i;
      this.zhO = false;
    }
    if (this.zhW != null)
    {
      this.zhH = this.zhW.intValue();
      this.zhW = null;
    }
    if (this.zhS.computeScrollOffset()) {
      this.zhH = this.zhS.getCurrX();
    }
    int k;
    label181:
    int j;
    if (this.zhH < 0)
    {
      this.zhH = 0;
      if (this.zif.Ky.isFinished()) {
        this.zif.aF((int)dDD());
      }
      this.zhS.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.zin);
      k = this.zhG - this.zhH;
      localView = getLeftmostChild();
      if ((localView == null) || (localView.getRight() + k > 0)) {
        break label343;
      }
      j = this.zhJ;
      if (!OA(this.zhX)) {
        break label328;
      }
    }
    label328:
    for (int i = localView.getMeasuredWidth();; i = this.agh + localView.getMeasuredWidth())
    {
      this.zhJ = (i + j);
      i(this.zhX, localView);
      removeViewInLayout(localView);
      this.zhX += 1;
      localView = getLeftmostChild();
      break label181;
      if (this.zhH <= this.zhI) {
        break;
      }
      this.zhH = this.zhI;
      if (this.zig.Ky.isFinished()) {
        this.zig.aF((int)dDD());
      }
      this.zhS.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.zin);
      break;
    }
    for (;;)
    {
      label343:
      localView = getRightmostChild();
      if ((localView == null) || (localView.getLeft() + k < getWidth())) {
        break;
      }
      i(this.zhY, localView);
      removeViewInLayout(localView);
      this.zhY -= 1;
    }
    i = 0;
    View localView = getRightmostChild();
    if (localView != null) {
      i = localView.getRight();
    }
    if ((i + k + this.agh < getWidth()) && (this.zhY + 1 < this.xw.getCount()))
    {
      this.zhY += 1;
      if (this.zhX < 0) {
        this.zhX = this.zhY;
      }
      localView = this.xw.getView(this.zhY, Oy(this.zhY), this);
      am(localView, -1);
      if (this.zhY == 0) {}
      for (j = 0;; j = this.agh)
      {
        j = i + (j + localView.getMeasuredWidth());
        i = j;
        if (this.zia == null) {
          break;
        }
        i = j;
        if (this.xw == null) {
          break;
        }
        i = j;
        if (this.xw.getCount() - (this.zhY + 1) >= this.zib) {
          break;
        }
        i = j;
        if (this.zic) {
          break;
        }
        this.zic = true;
        i = j;
        break;
      }
    }
    i = 0;
    localView = getLeftmostChild();
    if (localView != null) {
      i = localView.getLeft();
    }
    if ((i + k - this.agh > 0) && (this.zhX > 0))
    {
      this.zhX -= 1;
      localView = this.xw.getView(this.zhX, Oy(this.zhX), this);
      am(localView, 0);
      if (this.zhX == 0)
      {
        j = localView.getMeasuredWidth();
        label710:
        j = i - j;
        m = this.zhJ;
        if (j + k != 0) {
          break label769;
        }
      }
      label769:
      for (i = localView.getMeasuredWidth();; i = this.agh + localView.getMeasuredWidth())
      {
        this.zhJ = (m - i);
        i = j;
        break;
        j = this.agh + localView.getMeasuredWidth();
        break label710;
      }
    }
    int m = getChildCount();
    if (m > 0)
    {
      this.zhJ += k;
      j = this.zhJ;
      i = 0;
      while (i < m)
      {
        localView = getChildAt(i);
        k = getPaddingLeft() + j;
        int n = getPaddingTop();
        localView.layout(k, n, localView.getMeasuredWidth() + k, localView.getMeasuredHeight() + n);
        j += localView.getMeasuredWidth() + this.agh;
        i += 1;
      }
    }
    this.zhG = this.zhH;
    if (OA(this.zhY))
    {
      localView = getRightmostChild();
      if (localView != null)
      {
        i = this.zhI;
        j = this.zhG;
        this.zhI = (localView.getRight() - getPaddingLeft() + j - getRenderWidth());
        if (this.zhI < 0) {
          this.zhI = 0;
        }
        if (this.zhI == i) {}
      }
    }
    for (i = 1; i != 0; i = 0)
    {
      onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(106359);
      return;
    }
    if (this.zhS.isFinished())
    {
      if (this.zie == HorizontalListViewV2.d.a.ziq)
      {
        setCurrentScrollState(HorizontalListViewV2.d.a.zin);
        AppMethodBeat.o(106359);
      }
    }
    else {
      t.b(this, this.zil);
    }
    AppMethodBeat.o(106359);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106363);
    super.onMeasure(paramInt1, paramInt2);
    this.zih = paramInt2;
    AppMethodBeat.o(106363);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(106347);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.zhW = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
    AppMethodBeat.o(106347);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(106346);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.zhG);
    AppMethodBeat.o(106346);
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106377);
    if (paramMotionEvent.getAction() == 1)
    {
      if ((this.zhS == null) || (this.zhS.isFinished())) {
        setCurrentScrollState(HorizontalListViewV2.d.a.zin);
      }
      k(Boolean.FALSE);
      dDG();
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106377);
      return bool;
      if (paramMotionEvent.getAction() == 3)
      {
        dDF();
        dDG();
        k(Boolean.FALSE);
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    int i = 0;
    AppMethodBeat.i(106353);
    if (this.xw != null) {
      this.xw.unregisterDataSetObserver(this.zik);
    }
    if (paramListAdapter != null)
    {
      this.zic = false;
      this.xw = paramListAdapter;
      this.xw.registerDataSetObserver(this.zik);
    }
    if (this.xw != null)
    {
      int j = this.xw.getViewTypeCount();
      this.zhU.clear();
      while (i < j)
      {
        this.zhU.add(new LinkedList());
        i += 1;
      }
    }
    reset();
    AppMethodBeat.o(106353);
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    AppMethodBeat.i(106348);
    this.acK = paramDrawable;
    if (paramDrawable != null)
    {
      setDividerWidth(paramDrawable.getIntrinsicWidth());
      AppMethodBeat.o(106348);
      return;
    }
    setDividerWidth(0);
    AppMethodBeat.o(106348);
  }
  
  public void setDividerWidth(int paramInt)
  {
    AppMethodBeat.i(106349);
    this.agh = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(106349);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setOnScrollStateChangedListener(HorizontalListViewV2.d paramd)
  {
    this.zid = paramd;
  }
  
  public void setSelection(int paramInt)
  {
    this.zhZ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2
 * JD-Core Version:    0.7.0.1
 */