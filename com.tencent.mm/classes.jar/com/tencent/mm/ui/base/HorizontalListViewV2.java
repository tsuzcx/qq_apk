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
  protected ListAdapter GE;
  protected int JDC;
  protected int JDD;
  private int JDE;
  private int JDF;
  private boolean JDK;
  protected Scroller JDP;
  private final a JDQ;
  private List<Queue<View>> JDR;
  private View JDS;
  private Integer JDT;
  private int JDU;
  private int JDV;
  private int JDW;
  private e JDX;
  private int JDY;
  private boolean JDZ;
  private d JEa;
  private HorizontalListViewV2.d.a JEb;
  private i JEc;
  private i JEd;
  private int JEe;
  private boolean JEf;
  private boolean JEg;
  private DataSetObserver JEh;
  private Runnable JEi;
  private Drawable amC;
  private int aqb;
  private GestureDetector lwM;
  private View.OnClickListener mOnClickListener;
  private Rect mRect;
  
  public HorizontalListViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141710);
    this.JDP = new Scroller(getContext());
    this.JDQ = new a((byte)0);
    this.JDR = new ArrayList();
    this.JDK = false;
    this.mRect = new Rect();
    this.JDS = null;
    this.aqb = 0;
    this.amC = null;
    this.JDT = null;
    this.JDE = 2147483647;
    this.JDX = null;
    this.JDY = 0;
    this.JDZ = false;
    this.JEa = null;
    this.JEb = HorizontalListViewV2.d.a.JEk;
    this.JEf = false;
    this.JEg = false;
    this.JEh = new DataSetObserver()
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
    this.JEi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141697);
        HorizontalListViewV2.this.requestLayout();
        AppMethodBeat.o(141697);
      }
    };
    this.JEc = new i(paramContext);
    this.JEd = new i(paramContext);
    this.lwM = new GestureDetector(paramContext, this.JDQ);
    setOnTouchListener(new HorizontalListViewV2.1(this));
    initView();
    setWillNotDraw(false);
    if (Build.VERSION.SDK_INT >= 11) {
      HorizontalListViewV2.b.a(this.JDP);
    }
    AppMethodBeat.o(141710);
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    AppMethodBeat.i(141737);
    if (this.amC != null)
    {
      this.amC.setBounds(paramRect);
      this.amC.draw(paramCanvas);
    }
    AppMethodBeat.o(141737);
  }
  
  private void aB(View paramView, int paramInt)
  {
    AppMethodBeat.i(141723);
    addViewInLayout(paramView, paramInt, ge(paramView), true);
    ViewGroup.LayoutParams localLayoutParams = ge(paramView);
    int i = ViewGroup.getChildMeasureSpec(this.JEe, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    if (localLayoutParams.width > 0) {}
    for (paramInt = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);; paramInt = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt, i);
      AppMethodBeat.o(141723);
      return;
    }
  }
  
  private View acG(int paramInt)
  {
    AppMethodBeat.i(141720);
    paramInt = this.GE.getItemViewType(paramInt);
    if (acH(paramInt))
    {
      View localView = (View)((Queue)this.JDR.get(paramInt)).poll();
      AppMethodBeat.o(141720);
      return localView;
    }
    AppMethodBeat.o(141720);
    return null;
  }
  
  private boolean acH(int paramInt)
  {
    AppMethodBeat.i(141722);
    if (paramInt < this.JDR.size())
    {
      AppMethodBeat.o(141722);
      return true;
    }
    AppMethodBeat.o(141722);
    return false;
  }
  
  private boolean acI(int paramInt)
  {
    AppMethodBeat.i(141733);
    if (paramInt == this.GE.getCount() - 1)
    {
      AppMethodBeat.o(141733);
      return true;
    }
    AppMethodBeat.o(141733);
    return false;
  }
  
  private float fCu()
  {
    AppMethodBeat.i(141728);
    if (Build.VERSION.SDK_INT >= 14)
    {
      float f = HorizontalListViewV2.c.b(this.JDP);
      AppMethodBeat.o(141728);
      return f;
    }
    AppMethodBeat.o(141728);
    return 30.0F;
  }
  
  private void fCw()
  {
    AppMethodBeat.i(141742);
    if (this.JDS != null)
    {
      this.JDS.setPressed(false);
      refreshDrawableState();
      this.JDS = null;
    }
    AppMethodBeat.o(141742);
  }
  
  private void fCx()
  {
    AppMethodBeat.i(141744);
    if (this.JEc != null) {
      this.JEc.fT();
    }
    if (this.JEd != null) {
      this.JEd.fT();
    }
    AppMethodBeat.o(141744);
  }
  
  private static ViewGroup.LayoutParams ge(View paramView)
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
    this.JDU = -1;
    this.JDV = -1;
    this.JDF = 0;
    this.JDC = 0;
    this.JDD = 0;
    this.JDE = 2147483647;
    setCurrentScrollState(HorizontalListViewV2.d.a.JEk);
    AppMethodBeat.o(141716);
  }
  
  private int jJ(int paramInt1, int paramInt2)
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
  
  private void n(int paramInt, View paramView)
  {
    AppMethodBeat.i(141721);
    paramInt = this.GE.getItemViewType(paramInt);
    if (acH(paramInt)) {
      ((Queue)this.JDR.get(paramInt)).offer(paramView);
    }
    AppMethodBeat.o(141721);
  }
  
  private void p(Boolean paramBoolean)
  {
    AppMethodBeat.i(141711);
    if (this.JEg != paramBoolean.booleanValue()) {
      for (Object localObject = this; (((View)localObject).getParent() instanceof View); localObject = (View)((View)localObject).getParent()) {
        if (((((View)localObject).getParent() instanceof ListView)) || ((((View)localObject).getParent() instanceof ScrollView)))
        {
          ((View)localObject).getParent().requestDisallowInterceptTouchEvent(paramBoolean.booleanValue());
          this.JEg = paramBoolean.booleanValue();
          AppMethodBeat.o(141711);
          return;
        }
      }
    }
    AppMethodBeat.o(141711);
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
    if ((this.JEb != parama) && (this.JEa != null)) {
      this.JEa.a(parama);
    }
    this.JEb = parama;
    AppMethodBeat.o(141745);
  }
  
  protected final boolean bP(float paramFloat)
  {
    AppMethodBeat.i(141740);
    this.JDP.fling(this.JDD, 0, (int)-paramFloat, 0, 0, this.JDE, 0, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.JEm);
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
  
  public final void fCv()
  {
    AppMethodBeat.i(141736);
    this.JDP.startScroll(this.JDD, 0, 0 - this.JDD, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.JEm);
    requestLayout();
    AppMethodBeat.o(141736);
  }
  
  public ListAdapter getAdapter()
  {
    return this.GE;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.JDU;
  }
  
  public int getLastVisiblePosition()
  {
    return this.JDV;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(141726);
    int i = getHorizontalFadingEdgeLength();
    if (this.JDC == 0)
    {
      AppMethodBeat.o(141726);
      return 0.0F;
    }
    if (this.JDC < i)
    {
      float f = this.JDC / i;
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
    if (this.JDC == this.JDE)
    {
      AppMethodBeat.o(141727);
      return 0.0F;
    }
    if (this.JDE - this.JDC < i)
    {
      float f = (this.JDE - this.JDC) / i;
      AppMethodBeat.o(141727);
      return f;
    }
    AppMethodBeat.o(141727);
    return 1.0F;
  }
  
  public View getSelectedView()
  {
    AppMethodBeat.i(141718);
    int i = this.JDW;
    if ((i >= this.JDU) && (i <= this.JDV))
    {
      View localView = getChildAt(i - this.JDU);
      AppMethodBeat.o(141718);
      return localView;
    }
    AppMethodBeat.o(141718);
    return null;
  }
  
  protected final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141741);
    if (!this.JDP.isFinished()) {}
    for (boolean bool = true;; bool = false)
    {
      this.JEf = bool;
      this.JDP.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.JEk);
      fCw();
      if (!this.JEf)
      {
        int i = jJ((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (i >= 0)
        {
          this.JDS = getChildAt(i);
          if (this.JDS != null)
          {
            this.JDS.setPressed(true);
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
      if ((i != j - 1) || (!acI(this.JDV)))
      {
        View localView = getChildAt(i);
        localRect.left = localView.getRight();
        localRect.right = (localView.getRight() + this.aqb);
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
  
  @SuppressLint({"WrongCall"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141725);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.GE == null)
    {
      AppMethodBeat.o(141725);
      return;
    }
    invalidate();
    if (this.JDK)
    {
      i = this.JDC;
      initView();
      removeAllViewsInLayout();
      this.JDD = i;
      this.JDK = false;
    }
    if (this.JDT != null)
    {
      this.JDD = this.JDT.intValue();
      this.JDT = null;
    }
    if (this.JDP.computeScrollOffset()) {
      this.JDD = this.JDP.getCurrX();
    }
    int k;
    label181:
    int j;
    if (this.JDD < 0)
    {
      this.JDD = 0;
      if (this.JEc.Uj.isFinished()) {
        this.JEc.aW((int)fCu());
      }
      this.JDP.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.JEk);
      k = this.JDC - this.JDD;
      localView = getLeftmostChild();
      if ((localView == null) || (localView.getRight() + k > 0)) {
        break label343;
      }
      j = this.JDF;
      if (!acI(this.JDU)) {
        break label328;
      }
    }
    label328:
    for (int i = localView.getMeasuredWidth();; i = this.aqb + localView.getMeasuredWidth())
    {
      this.JDF = (i + j);
      n(this.JDU, localView);
      removeViewInLayout(localView);
      this.JDU += 1;
      localView = getLeftmostChild();
      break label181;
      if (this.JDD <= this.JDE) {
        break;
      }
      this.JDD = this.JDE;
      if (this.JEd.Uj.isFinished()) {
        this.JEd.aW((int)fCu());
      }
      this.JDP.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.JEk);
      break;
    }
    for (;;)
    {
      label343:
      localView = getRightmostChild();
      if ((localView == null) || (localView.getLeft() + k < getWidth())) {
        break;
      }
      n(this.JDV, localView);
      removeViewInLayout(localView);
      this.JDV -= 1;
    }
    i = 0;
    View localView = getRightmostChild();
    if (localView != null) {
      i = localView.getRight();
    }
    if ((i + k + this.aqb < getWidth()) && (this.JDV + 1 < this.GE.getCount()))
    {
      this.JDV += 1;
      if (this.JDU < 0) {
        this.JDU = this.JDV;
      }
      localView = this.GE.getView(this.JDV, acG(this.JDV), this);
      aB(localView, -1);
      if (this.JDV == 0) {}
      for (j = 0;; j = this.aqb)
      {
        j = i + (j + localView.getMeasuredWidth());
        i = j;
        if (this.JDX == null) {
          break;
        }
        i = j;
        if (this.GE == null) {
          break;
        }
        i = j;
        if (this.GE.getCount() - (this.JDV + 1) >= this.JDY) {
          break;
        }
        i = j;
        if (this.JDZ) {
          break;
        }
        this.JDZ = true;
        i = j;
        break;
      }
    }
    i = 0;
    localView = getLeftmostChild();
    if (localView != null) {
      i = localView.getLeft();
    }
    if ((i + k - this.aqb > 0) && (this.JDU > 0))
    {
      this.JDU -= 1;
      localView = this.GE.getView(this.JDU, acG(this.JDU), this);
      aB(localView, 0);
      if (this.JDU == 0)
      {
        j = localView.getMeasuredWidth();
        label710:
        j = i - j;
        m = this.JDF;
        if (j + k != 0) {
          break label769;
        }
      }
      label769:
      for (i = localView.getMeasuredWidth();; i = this.aqb + localView.getMeasuredWidth())
      {
        this.JDF = (m - i);
        i = j;
        break;
        j = this.aqb + localView.getMeasuredWidth();
        break label710;
      }
    }
    int m = getChildCount();
    if (m > 0)
    {
      this.JDF += k;
      j = this.JDF;
      i = 0;
      while (i < m)
      {
        localView = getChildAt(i);
        k = getPaddingLeft() + j;
        int n = getPaddingTop();
        localView.layout(k, n, localView.getMeasuredWidth() + k, localView.getMeasuredHeight() + n);
        j += localView.getMeasuredWidth() + this.aqb;
        i += 1;
      }
    }
    this.JDC = this.JDD;
    if (acI(this.JDV))
    {
      localView = getRightmostChild();
      if (localView != null)
      {
        i = this.JDE;
        j = this.JDC;
        this.JDE = (localView.getRight() - getPaddingLeft() + j - getRenderWidth());
        if (this.JDE < 0) {
          this.JDE = 0;
        }
        if (this.JDE == i) {}
      }
    }
    for (i = 1; i != 0; i = 0)
    {
      onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(141725);
      return;
    }
    if (this.JDP.isFinished())
    {
      if (this.JEb == HorizontalListViewV2.d.a.JEm)
      {
        setCurrentScrollState(HorizontalListViewV2.d.a.JEk);
        AppMethodBeat.o(141725);
      }
    }
    else {
      t.b(this, this.JEi);
    }
    AppMethodBeat.o(141725);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141729);
    super.onMeasure(paramInt1, paramInt2);
    this.JEe = paramInt2;
    AppMethodBeat.o(141729);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(141713);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.JDT = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
    AppMethodBeat.o(141713);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(141712);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.JDC);
    AppMethodBeat.o(141712);
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141743);
    if (paramMotionEvent.getAction() == 1)
    {
      if ((this.JDP == null) || (this.JDP.isFinished())) {
        setCurrentScrollState(HorizontalListViewV2.d.a.JEk);
      }
      p(Boolean.FALSE);
      fCx();
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141743);
      return bool;
      if (paramMotionEvent.getAction() == 3)
      {
        fCw();
        fCx();
        p(Boolean.FALSE);
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    int i = 0;
    AppMethodBeat.i(141719);
    if (this.GE != null) {
      this.GE.unregisterDataSetObserver(this.JEh);
    }
    if (paramListAdapter != null)
    {
      this.JDZ = false;
      this.GE = paramListAdapter;
      this.GE.registerDataSetObserver(this.JEh);
    }
    if (this.GE != null)
    {
      int j = this.GE.getViewTypeCount();
      this.JDR.clear();
      while (i < j)
      {
        this.JDR.add(new LinkedList());
        i += 1;
      }
    }
    reset();
    AppMethodBeat.o(141719);
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    AppMethodBeat.i(141714);
    this.amC = paramDrawable;
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
    this.aqb = paramInt;
    requestLayout();
    invalidate();
    AppMethodBeat.o(141715);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void setOnScrollStateChangedListener(d paramd)
  {
    this.JEa = paramd;
  }
  
  public void setSelection(int paramInt)
  {
    this.JDW = paramInt;
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(193715);
      b localb = new b();
      localb.bd(paramMotionEvent);
      a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onContextClick(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(193715);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(193714);
      b localb = new b();
      localb.bd(paramMotionEvent);
      a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(193714);
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
      boolean bool = HorizontalListViewV2.this.bP(paramFloat1);
      AppMethodBeat.o(141699);
      return bool;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(141702);
      Object localObject = new b();
      ((b)localObject).bd(paramMotionEvent);
      a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, ((b)localObject).ahF());
      HorizontalListViewV2.d(HorizontalListViewV2.this);
      int i = HorizontalListViewV2.a(HorizontalListViewV2.this, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if ((i >= 0) && (!HorizontalListViewV2.f(HorizontalListViewV2.this)))
      {
        paramMotionEvent = HorizontalListViewV2.this.getChildAt(i);
        localObject = HorizontalListViewV2.this.getOnItemLongClickListener();
        if (localObject != null)
        {
          i = HorizontalListViewV2.g(HorizontalListViewV2.this) + i;
          if (((AdapterView.OnItemLongClickListener)localObject).onItemLongClick(HorizontalListViewV2.this, paramMotionEvent, i, HorizontalListViewV2.this.GE.getItemId(i))) {
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
      HorizontalListViewV2.a(HorizontalListViewV2.this, HorizontalListViewV2.d.a.JEl);
      HorizontalListViewV2.d(HorizontalListViewV2.this);
      paramMotionEvent1 = HorizontalListViewV2.this;
      paramMotionEvent1.JDD += (int)paramFloat1;
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
          localOnItemClickListener.onItemClick(HorizontalListViewV2.this, paramMotionEvent, i, HorizontalListViewV2.this.GE.getItemId(i));
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
      AppMethodBeat.i(193713);
      b localb = new b();
      localb.bd(paramMotionEvent);
      a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(193713);
      return bool;
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(HorizontalListViewV2.d.a parama);
  }
  
  public static abstract interface e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2
 * JD-Core Version:    0.7.0.1
 */