package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EdgeEffect;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.core.g.z;
import androidx.core.widget.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListViewV2
  extends AdapterView<ListAdapter>
{
  private int adOA;
  private int adOB;
  private boolean adOG;
  protected Scroller adOL;
  private final a adOM;
  private List<Queue<View>> adON;
  private View adOO;
  private Integer adOP;
  private int adOQ;
  private int adOR;
  private int adOS;
  private e adOT;
  private int adOU;
  private boolean adOV;
  private HorizontalListViewV2.d adOW;
  private HorizontalListViewV2.d.a adOX;
  private d adOY;
  private d adOZ;
  protected int adOy;
  protected int adOz;
  private int adPa;
  private boolean adPb;
  private boolean adPc;
  private DataSetObserver adPd;
  private Runnable adPe;
  protected ListAdapter fR;
  private View.OnClickListener mOnClickListener;
  private GestureDetector mQj;
  private Rect mRect;
  private Drawable tP;
  private int tQ;
  
  public HorizontalListViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141710);
    this.adOL = new Scroller(getContext());
    this.adOM = new a((byte)0);
    this.adON = new ArrayList();
    this.adOG = false;
    this.mRect = new Rect();
    this.adOO = null;
    this.tQ = 0;
    this.tP = null;
    this.adOP = null;
    this.adOA = 2147483647;
    this.adOT = null;
    this.adOU = 0;
    this.adOV = false;
    this.adOW = null;
    this.adOX = HorizontalListViewV2.d.a.adPg;
    this.adPb = false;
    this.adPc = false;
    this.adPd = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(141695);
        HorizontalListViewV2.b(HorizontalListViewV2.this);
        HorizontalListViewV2.c(HorizontalListViewV2.this);
        HorizontalListViewV2.d(HorizontalListViewV2.this);
        HorizontalListViewV2.this.invalidate();
        HorizontalListViewV2.this.requestLayout();
        AppMethodBeat.o(141695);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(141696);
        HorizontalListViewV2.c(HorizontalListViewV2.this);
        HorizontalListViewV2.d(HorizontalListViewV2.this);
        HorizontalListViewV2.e(HorizontalListViewV2.this);
        HorizontalListViewV2.this.invalidate();
        HorizontalListViewV2.this.requestLayout();
        AppMethodBeat.o(141696);
      }
    };
    this.adPe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141697);
        HorizontalListViewV2.this.requestLayout();
        AppMethodBeat.o(141697);
      }
    };
    this.adOY = new d(paramContext);
    this.adOZ = new d(paramContext);
    this.mQj = new GestureDetector(paramContext, this.adOM);
    setOnTouchListener(new HorizontalListViewV2.1(this));
    initView();
    setWillNotDraw(false);
    if (Build.VERSION.SDK_INT >= 11) {
      HorizontalListViewV2.b.a(this.adOL);
    }
    AppMethodBeat.o(141710);
  }
  
  private void A(int paramInt, View paramView)
  {
    AppMethodBeat.i(141721);
    paramInt = this.fR.getItemViewType(paramInt);
    if (aAL(paramInt)) {
      ((Queue)this.adON.get(paramInt)).offer(paramView);
    }
    AppMethodBeat.o(141721);
  }
  
  private void K(Boolean paramBoolean)
  {
    AppMethodBeat.i(141711);
    if (this.adPc != paramBoolean.booleanValue()) {
      for (Object localObject = this; (((View)localObject).getParent() instanceof View); localObject = (View)((View)localObject).getParent()) {
        if (((((View)localObject).getParent() instanceof ListView)) || ((((View)localObject).getParent() instanceof ScrollView)))
        {
          ((View)localObject).getParent().requestDisallowInterceptTouchEvent(paramBoolean.booleanValue());
          this.adPc = paramBoolean.booleanValue();
          AppMethodBeat.o(141711);
          return;
        }
      }
    }
    AppMethodBeat.o(141711);
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    AppMethodBeat.i(141737);
    if (this.tP != null)
    {
      this.tP.setBounds(paramRect);
      this.tP.draw(paramCanvas);
    }
    AppMethodBeat.o(141737);
  }
  
  private View aAK(int paramInt)
  {
    AppMethodBeat.i(141720);
    paramInt = this.fR.getItemViewType(paramInt);
    if (aAL(paramInt))
    {
      View localView = (View)((Queue)this.adON.get(paramInt)).poll();
      AppMethodBeat.o(141720);
      return localView;
    }
    AppMethodBeat.o(141720);
    return null;
  }
  
  private boolean aAL(int paramInt)
  {
    AppMethodBeat.i(141722);
    if (paramInt < this.adON.size())
    {
      AppMethodBeat.o(141722);
      return true;
    }
    AppMethodBeat.o(141722);
    return false;
  }
  
  private boolean aAM(int paramInt)
  {
    AppMethodBeat.i(141733);
    if (paramInt == this.fR.getCount() - 1)
    {
      AppMethodBeat.o(141733);
      return true;
    }
    AppMethodBeat.o(141733);
    return false;
  }
  
  private void bi(View paramView, int paramInt)
  {
    AppMethodBeat.i(141723);
    addViewInLayout(paramView, paramInt, ld(paramView), true);
    ViewGroup.LayoutParams localLayoutParams = ld(paramView);
    int i = ViewGroup.getChildMeasureSpec(this.adPa, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    if (localLayoutParams.width > 0) {}
    for (paramInt = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);; paramInt = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt, i);
      AppMethodBeat.o(141723);
      return;
    }
  }
  
  private View getLeftmostChild()
  {
    AppMethodBeat.i(141730);
    View localView = getChildAt(0);
    AppMethodBeat.o(141730);
    return localView;
  }
  
  private int getRenderHeight()
  {
    AppMethodBeat.i(141734);
    int i = getHeight();
    int j = getPaddingTop();
    int k = getPaddingBottom();
    AppMethodBeat.o(141734);
    return i - j - k;
  }
  
  private int getRenderWidth()
  {
    AppMethodBeat.i(141735);
    int i = getWidth();
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(141735);
    return i - j - k;
  }
  
  private View getRightmostChild()
  {
    AppMethodBeat.i(141731);
    View localView = getChildAt(getChildCount() - 1);
    AppMethodBeat.o(141731);
    return localView;
  }
  
  private void initView()
  {
    AppMethodBeat.i(141716);
    this.adOQ = -1;
    this.adOR = -1;
    this.adOB = 0;
    this.adOy = 0;
    this.adOz = 0;
    this.adOA = 2147483647;
    setCurrentScrollState(HorizontalListViewV2.d.a.adPg);
    AppMethodBeat.o(141716);
  }
  
  private float jlU()
  {
    AppMethodBeat.i(141728);
    if (Build.VERSION.SDK_INT >= 14)
    {
      float f = c.b(this.adOL);
      AppMethodBeat.o(141728);
      return f;
    }
    AppMethodBeat.o(141728);
    return 30.0F;
  }
  
  private void jlW()
  {
    AppMethodBeat.i(141742);
    if (this.adOO != null)
    {
      this.adOO.setPressed(false);
      refreshDrawableState();
      this.adOO = null;
    }
    AppMethodBeat.o(141742);
  }
  
  private void jlX()
  {
    AppMethodBeat.i(141744);
    if (this.adOY != null) {
      this.adOY.Fi();
    }
    if (this.adOZ != null) {
      this.adOZ.Fi();
    }
    AppMethodBeat.o(141744);
  }
  
  private static ViewGroup.LayoutParams ld(View paramView)
  {
    AppMethodBeat.i(141724);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView = localLayoutParams;
    if (localLayoutParams == null) {
      paramView = new ViewGroup.LayoutParams(-2, -1);
    }
    AppMethodBeat.o(141724);
    return paramView;
  }
  
  private int oe(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141732);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).getHitRect(this.mRect);
      if (this.mRect.contains(paramInt1, paramInt2))
      {
        AppMethodBeat.o(141732);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(141732);
    return -1;
  }
  
  private void reset()
  {
    AppMethodBeat.i(141717);
    initView();
    removeAllViewsInLayout();
    requestLayout();
    AppMethodBeat.o(141717);
  }
  
  private void setCurrentScrollState(HorizontalListViewV2.d.a parama)
  {
    AppMethodBeat.i(141745);
    if ((this.adOX != parama) && (this.adOW != null)) {
      this.adOW.a(parama);
    }
    this.adOX = parama;
    AppMethodBeat.o(141745);
  }
  
  protected final boolean dW(float paramFloat)
  {
    AppMethodBeat.i(141740);
    this.adOL.fling(this.adOz, 0, (int)-paramFloat, 0, 0, this.adOA, 0, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.adPi);
    requestLayout();
    AppMethodBeat.o(141740);
    return true;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141739);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(141739);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean) {}
  
  public ListAdapter getAdapter()
  {
    return this.fR;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.adOQ;
  }
  
  public int getLastVisiblePosition()
  {
    return this.adOR;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(141726);
    int i = getHorizontalFadingEdgeLength();
    if (this.adOy == 0)
    {
      AppMethodBeat.o(141726);
      return 0.0F;
    }
    if (this.adOy < i)
    {
      float f = this.adOy / i;
      AppMethodBeat.o(141726);
      return f;
    }
    AppMethodBeat.o(141726);
    return 1.0F;
  }
  
  protected float getRightFadingEdgeStrength()
  {
    AppMethodBeat.i(141727);
    int i = getHorizontalFadingEdgeLength();
    if (this.adOy == this.adOA)
    {
      AppMethodBeat.o(141727);
      return 0.0F;
    }
    if (this.adOA - this.adOy < i)
    {
      float f = (this.adOA - this.adOy) / i;
      AppMethodBeat.o(141727);
      return f;
    }
    AppMethodBeat.o(141727);
    return 1.0F;
  }
  
  public View getSelectedView()
  {
    AppMethodBeat.i(141718);
    int i = this.adOS;
    if ((i >= this.adOQ) && (i <= this.adOR))
    {
      View localView = getChildAt(i - this.adOQ);
      AppMethodBeat.o(141718);
      return localView;
    }
    AppMethodBeat.o(141718);
    return null;
  }
  
  public final void jlV()
  {
    AppMethodBeat.i(141736);
    this.adOL.startScroll(this.adOz, 0, 0 - this.adOz, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.adPi);
    requestLayout();
    AppMethodBeat.o(141736);
  }
  
  protected final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141741);
    if (!this.adOL.isFinished()) {}
    for (boolean bool = true;; bool = false)
    {
      this.adPb = bool;
      this.adOL.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.adPg);
      jlW();
      if (!this.adPb)
      {
        int i = oe((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (i >= 0)
        {
          this.adOO = getChildAt(i);
          if (this.adOO != null)
          {
            this.adOO.setPressed(true);
            refreshDrawableState();
          }
        }
      }
      AppMethodBeat.o(141741);
      return true;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(141738);
    super.onDraw(paramCanvas);
    int j = getChildCount();
    Rect localRect = this.mRect;
    this.mRect.top = getPaddingTop();
    this.mRect.bottom = (this.mRect.top + getRenderHeight());
    int i = 0;
    while (i < j)
    {
      if ((i != j - 1) || (!aAM(this.adOR)))
      {
        View localView = getChildAt(i);
        localRect.left = localView.getRight();
        localRect.right = (localView.getRight() + this.tQ);
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
    AppMethodBeat.o(141738);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141725);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.fR == null)
    {
      AppMethodBeat.o(141725);
      return;
    }
    invalidate();
    if (this.adOG)
    {
      i = this.adOy;
      initView();
      removeAllViewsInLayout();
      this.adOz = i;
      this.adOG = false;
    }
    if (this.adOP != null)
    {
      this.adOz = this.adOP.intValue();
      this.adOP = null;
    }
    if (this.adOL.computeScrollOffset()) {
      this.adOz = this.adOL.getCurrX();
    }
    int k;
    label181:
    int j;
    if (this.adOz < 0)
    {
      this.adOz = 0;
      if (this.adOY.bww.isFinished()) {
        this.adOY.eE((int)jlU());
      }
      this.adOL.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.adPg);
      k = this.adOy - this.adOz;
      localView = getLeftmostChild();
      if ((localView == null) || (localView.getRight() + k > 0)) {
        break label343;
      }
      j = this.adOB;
      if (!aAM(this.adOQ)) {
        break label328;
      }
    }
    label328:
    for (int i = localView.getMeasuredWidth();; i = this.tQ + localView.getMeasuredWidth())
    {
      this.adOB = (i + j);
      A(this.adOQ, localView);
      removeViewInLayout(localView);
      this.adOQ += 1;
      localView = getLeftmostChild();
      break label181;
      if (this.adOz <= this.adOA) {
        break;
      }
      this.adOz = this.adOA;
      if (this.adOZ.bww.isFinished()) {
        this.adOZ.eE((int)jlU());
      }
      this.adOL.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.adPg);
      break;
    }
    for (;;)
    {
      label343:
      localView = getRightmostChild();
      if ((localView == null) || (localView.getLeft() + k < getWidth())) {
        break;
      }
      A(this.adOR, localView);
      removeViewInLayout(localView);
      this.adOR -= 1;
    }
    i = 0;
    View localView = getRightmostChild();
    if (localView != null) {
      i = localView.getRight();
    }
    if ((i + k + this.tQ < getWidth()) && (this.adOR + 1 < this.fR.getCount()))
    {
      this.adOR += 1;
      if (this.adOQ < 0) {
        this.adOQ = this.adOR;
      }
      localView = this.fR.getView(this.adOR, aAK(this.adOR), this);
      bi(localView, -1);
      if (this.adOR == 0) {}
      for (j = 0;; j = this.tQ)
      {
        j = i + (j + localView.getMeasuredWidth());
        i = j;
        if (this.adOT == null) {
          break;
        }
        i = j;
        if (this.fR == null) {
          break;
        }
        i = j;
        if (this.fR.getCount() - (this.adOR + 1) >= this.adOU) {
          break;
        }
        i = j;
        if (this.adOV) {
          break;
        }
        this.adOV = true;
        i = j;
        break;
      }
    }
    i = 0;
    localView = getLeftmostChild();
    if (localView != null) {
      i = localView.getLeft();
    }
    if ((i + k - this.tQ > 0) && (this.adOQ > 0))
    {
      this.adOQ -= 1;
      localView = this.fR.getView(this.adOQ, aAK(this.adOQ), this);
      bi(localView, 0);
      if (this.adOQ == 0)
      {
        j = localView.getMeasuredWidth();
        label710:
        j = i - j;
        m = this.adOB;
        if (j + k != 0) {
          break label769;
        }
      }
      label769:
      for (i = localView.getMeasuredWidth();; i = this.tQ + localView.getMeasuredWidth())
      {
        this.adOB = (m - i);
        i = j;
        break;
        j = this.tQ + localView.getMeasuredWidth();
        break label710;
      }
    }
    int m = getChildCount();
    if (m > 0)
    {
      this.adOB += k;
      j = this.adOB;
      i = 0;
      while (i < m)
      {
        localView = getChildAt(i);
        k = getPaddingLeft() + j;
        int n = getPaddingTop();
        localView.layout(k, n, localView.getMeasuredWidth() + k, localView.getMeasuredHeight() + n);
        j += localView.getMeasuredWidth() + this.tQ;
        i += 1;
      }
    }
    this.adOy = this.adOz;
    if (aAM(this.adOR))
    {
      localView = getRightmostChild();
      if (localView != null)
      {
        i = this.adOA;
        j = this.adOy;
        this.adOA = (localView.getRight() - getPaddingLeft() + j - getRenderWidth());
        if (this.adOA < 0) {
          this.adOA = 0;
        }
        if (this.adOA == i) {}
      }
    }
    for (i = 1; i != 0; i = 0)
    {
      onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(141725);
      return;
    }
    if (this.adOL.isFinished())
    {
      if (this.adOX == HorizontalListViewV2.d.a.adPi)
      {
        setCurrentScrollState(HorizontalListViewV2.d.a.adPg);
        AppMethodBeat.o(141725);
      }
    }
    else {
      z.b(this, this.adPe);
    }
    AppMethodBeat.o(141725);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141729);
    super.onMeasure(paramInt1, paramInt2);
    this.adPa = paramInt2;
    AppMethodBeat.o(141729);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(141713);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.adOP = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
    AppMethodBeat.o(141713);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(141712);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.adOy);
    AppMethodBeat.o(141712);
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141743);
    if (paramMotionEvent.getAction() == 1)
    {
      if ((this.adOL == null) || (this.adOL.isFinished())) {
        setCurrentScrollState(HorizontalListViewV2.d.a.adPg);
      }
      K(Boolean.FALSE);
      jlX();
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141743);
      return bool;
      if (paramMotionEvent.getAction() == 3)
      {
        jlW();
        jlX();
        K(Boolean.FALSE);
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    int i = 0;
    AppMethodBeat.i(141719);
    if (this.fR != null) {
      this.fR.unregisterDataSetObserver(this.adPd);
    }
    if (paramListAdapter != null)
    {
      this.adOV = false;
      this.fR = paramListAdapter;
      this.fR.registerDataSetObserver(this.adPd);
    }
    if (this.fR != null)
    {
      int j = this.fR.getViewTypeCount();
      this.adON.clear();
      while (i < j)
      {
        this.adON.add(new LinkedList());
        i += 1;
      }
    }
    reset();
    AppMethodBeat.o(141719);
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    AppMethodBeat.i(141714);
    this.tP = paramDrawable;
    if (paramDrawable != null)
    {
      setDividerWidth(paramDrawable.getIntrinsicWidth());
      AppMethodBeat.o(141714);
      return;
    }
    setDividerWidth(0);
    AppMethodBeat.o(141714);
  }
  
  public void setDividerWidth(int paramInt)
  {
    AppMethodBeat.i(141715);
    this.tQ = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(141715);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setOnScrollStateChangedListener(HorizontalListViewV2.d paramd)
  {
    this.adOW = paramd;
  }
  
  public void setSelection(int paramInt)
  {
    this.adOS = paramInt;
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(251398);
      b localb = new b();
      localb.cH(paramMotionEvent);
      a.c("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onContextClick(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(251398);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(251397);
      b localb = new b();
      localb.cH(paramMotionEvent);
      a.c("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(251397);
      return bool;
    }
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(141698);
      boolean bool = HorizontalListViewV2.this.onDown(paramMotionEvent);
      AppMethodBeat.o(141698);
      return bool;
    }
    
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(141699);
      boolean bool = HorizontalListViewV2.this.dW(paramFloat1);
      AppMethodBeat.o(141699);
      return bool;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(141702);
      Object localObject = new b();
      ((b)localObject).cH(paramMotionEvent);
      a.c("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, ((b)localObject).aYj());
      HorizontalListViewV2.d(HorizontalListViewV2.this);
      int i = HorizontalListViewV2.a(HorizontalListViewV2.this, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if ((i >= 0) && (!HorizontalListViewV2.f(HorizontalListViewV2.this)))
      {
        paramMotionEvent = HorizontalListViewV2.this.getChildAt(i);
        localObject = HorizontalListViewV2.this.getOnItemLongClickListener();
        if (localObject != null)
        {
          i = HorizontalListViewV2.g(HorizontalListViewV2.this) + i;
          if (((AdapterView.OnItemLongClickListener)localObject).onItemLongClick(HorizontalListViewV2.this, paramMotionEvent, i, HorizontalListViewV2.this.fR.getItemId(i))) {
            HorizontalListViewV2.this.performHapticFeedback(0);
          }
        }
      }
      a.a(this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(141702);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(141700);
      HorizontalListViewV2.a(HorizontalListViewV2.this, Boolean.TRUE);
      HorizontalListViewV2.a(HorizontalListViewV2.this, HorizontalListViewV2.d.a.adPh);
      HorizontalListViewV2.d(HorizontalListViewV2.this);
      paramMotionEvent1 = HorizontalListViewV2.this;
      paramMotionEvent1.adOz += (int)paramFloat1;
      HorizontalListViewV2.a(HorizontalListViewV2.this, Math.round(paramFloat1));
      HorizontalListViewV2.this.requestLayout();
      AppMethodBeat.o(141700);
      return true;
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(141701);
      HorizontalListViewV2.d(HorizontalListViewV2.this);
      AdapterView.OnItemClickListener localOnItemClickListener = HorizontalListViewV2.this.getOnItemClickListener();
      int i = HorizontalListViewV2.a(HorizontalListViewV2.this, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if ((i >= 0) && (!HorizontalListViewV2.f(HorizontalListViewV2.this)))
      {
        paramMotionEvent = HorizontalListViewV2.this.getChildAt(i);
        i = HorizontalListViewV2.g(HorizontalListViewV2.this) + i;
        if (localOnItemClickListener != null)
        {
          localOnItemClickListener.onItemClick(HorizontalListViewV2.this, paramMotionEvent, i, HorizontalListViewV2.this.fR.getItemId(i));
          AppMethodBeat.o(141701);
          return true;
        }
      }
      if ((HorizontalListViewV2.h(HorizontalListViewV2.this) != null) && (!HorizontalListViewV2.f(HorizontalListViewV2.this))) {
        HorizontalListViewV2.h(HorizontalListViewV2.this).onClick(HorizontalListViewV2.this);
      }
      AppMethodBeat.o(141701);
      return false;
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(251395);
      b localb = new b();
      localb.cH(paramMotionEvent);
      a.c("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(251395);
      return bool;
    }
  }
  
  static final class c
  {
    static
    {
      AppMethodBeat.i(141706);
      if (Build.VERSION.SDK_INT < 14)
      {
        RuntimeException localRuntimeException = new RuntimeException("sdk is >= 14!");
        AppMethodBeat.o(141706);
        throw localRuntimeException;
      }
      AppMethodBeat.o(141706);
    }
    
    public static float b(Scroller paramScroller)
    {
      AppMethodBeat.i(141705);
      float f = paramScroller.getCurrVelocity();
      AppMethodBeat.o(141705);
      return f;
    }
  }
  
  public static abstract interface e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2
 * JD-Core Version:    0.7.0.1
 */