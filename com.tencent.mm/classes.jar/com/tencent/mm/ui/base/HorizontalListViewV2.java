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
import android.support.v4.view.u;
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
  protected ListAdapter GO;
  private boolean OOC;
  protected Scroller OOH;
  private final a OOI;
  private List<Queue<View>> OOJ;
  private View OOK;
  private Integer OOL;
  private int OOM;
  private int OON;
  private int OOO;
  private e OOP;
  private int OOQ;
  private boolean OOR;
  private d OOS;
  private HorizontalListViewV2.d.a OOT;
  private i OOU;
  private i OOV;
  private int OOW;
  private boolean OOX;
  private boolean OOY;
  private DataSetObserver OOZ;
  protected int OOu;
  protected int OOv;
  private int OOw;
  private int OOx;
  private Runnable OPa;
  private Drawable amP;
  private int aqn;
  private GestureDetector mDJ;
  private View.OnClickListener mOnClickListener;
  private Rect mRect;
  
  public HorizontalListViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141710);
    this.OOH = new Scroller(getContext());
    this.OOI = new a((byte)0);
    this.OOJ = new ArrayList();
    this.OOC = false;
    this.mRect = new Rect();
    this.OOK = null;
    this.aqn = 0;
    this.amP = null;
    this.OOL = null;
    this.OOw = 2147483647;
    this.OOP = null;
    this.OOQ = 0;
    this.OOR = false;
    this.OOS = null;
    this.OOT = HorizontalListViewV2.d.a.OPc;
    this.OOX = false;
    this.OOY = false;
    this.OOZ = new DataSetObserver()
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
    this.OPa = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141697);
        HorizontalListViewV2.this.requestLayout();
        AppMethodBeat.o(141697);
      }
    };
    this.OOU = new i(paramContext);
    this.OOV = new i(paramContext);
    this.mDJ = new GestureDetector(paramContext, this.OOI);
    setOnTouchListener(new HorizontalListViewV2.1(this));
    initView();
    setWillNotDraw(false);
    if (Build.VERSION.SDK_INT >= 11) {
      HorizontalListViewV2.b.a(this.OOH);
    }
    AppMethodBeat.o(141710);
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    AppMethodBeat.i(141737);
    if (this.amP != null)
    {
      this.amP.setBounds(paramRect);
      this.amP.draw(paramCanvas);
    }
    AppMethodBeat.o(141737);
  }
  
  private void aG(View paramView, int paramInt)
  {
    AppMethodBeat.i(141723);
    addViewInLayout(paramView, paramInt, gw(paramView), true);
    ViewGroup.LayoutParams localLayoutParams = gw(paramView);
    int i = ViewGroup.getChildMeasureSpec(this.OOW, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    if (localLayoutParams.width > 0) {}
    for (paramInt = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);; paramInt = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt, i);
      AppMethodBeat.o(141723);
      return;
    }
  }
  
  private View alq(int paramInt)
  {
    AppMethodBeat.i(141720);
    paramInt = this.GO.getItemViewType(paramInt);
    if (alr(paramInt))
    {
      View localView = (View)((Queue)this.OOJ.get(paramInt)).poll();
      AppMethodBeat.o(141720);
      return localView;
    }
    AppMethodBeat.o(141720);
    return null;
  }
  
  private boolean alr(int paramInt)
  {
    AppMethodBeat.i(141722);
    if (paramInt < this.OOJ.size())
    {
      AppMethodBeat.o(141722);
      return true;
    }
    AppMethodBeat.o(141722);
    return false;
  }
  
  private boolean als(int paramInt)
  {
    AppMethodBeat.i(141733);
    if (paramInt == this.GO.getCount() - 1)
    {
      AppMethodBeat.o(141733);
      return true;
    }
    AppMethodBeat.o(141733);
    return false;
  }
  
  private float gKs()
  {
    AppMethodBeat.i(141728);
    if (Build.VERSION.SDK_INT >= 14)
    {
      float f = HorizontalListViewV2.c.b(this.OOH);
      AppMethodBeat.o(141728);
      return f;
    }
    AppMethodBeat.o(141728);
    return 30.0F;
  }
  
  private void gKu()
  {
    AppMethodBeat.i(141742);
    if (this.OOK != null)
    {
      this.OOK.setPressed(false);
      refreshDrawableState();
      this.OOK = null;
    }
    AppMethodBeat.o(141742);
  }
  
  private void gKv()
  {
    AppMethodBeat.i(141744);
    if (this.OOU != null) {
      this.OOU.ga();
    }
    if (this.OOV != null) {
      this.OOV.ga();
    }
    AppMethodBeat.o(141744);
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
  
  private static ViewGroup.LayoutParams gw(View paramView)
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
  
  private void initView()
  {
    AppMethodBeat.i(141716);
    this.OOM = -1;
    this.OON = -1;
    this.OOx = 0;
    this.OOu = 0;
    this.OOv = 0;
    this.OOw = 2147483647;
    setCurrentScrollState(HorizontalListViewV2.d.a.OPc);
    AppMethodBeat.o(141716);
  }
  
  private int kS(int paramInt1, int paramInt2)
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
  
  private void p(int paramInt, View paramView)
  {
    AppMethodBeat.i(141721);
    paramInt = this.GO.getItemViewType(paramInt);
    if (alr(paramInt)) {
      ((Queue)this.OOJ.get(paramInt)).offer(paramView);
    }
    AppMethodBeat.o(141721);
  }
  
  private void r(Boolean paramBoolean)
  {
    AppMethodBeat.i(141711);
    if (this.OOY != paramBoolean.booleanValue()) {
      for (Object localObject = this; (((View)localObject).getParent() instanceof View); localObject = (View)((View)localObject).getParent()) {
        if (((((View)localObject).getParent() instanceof ListView)) || ((((View)localObject).getParent() instanceof ScrollView)))
        {
          ((View)localObject).getParent().requestDisallowInterceptTouchEvent(paramBoolean.booleanValue());
          this.OOY = paramBoolean.booleanValue();
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
    if ((this.OOT != parama) && (this.OOS != null)) {
      this.OOS.a(parama);
    }
    this.OOT = parama;
    AppMethodBeat.o(141745);
  }
  
  protected final boolean cr(float paramFloat)
  {
    AppMethodBeat.i(141740);
    this.OOH.fling(this.OOv, 0, (int)-paramFloat, 0, 0, this.OOw, 0, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.OPe);
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
  
  public final void gKt()
  {
    AppMethodBeat.i(141736);
    this.OOH.startScroll(this.OOv, 0, 0 - this.OOv, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.OPe);
    requestLayout();
    AppMethodBeat.o(141736);
  }
  
  public ListAdapter getAdapter()
  {
    return this.GO;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.OOM;
  }
  
  public int getLastVisiblePosition()
  {
    return this.OON;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(141726);
    int i = getHorizontalFadingEdgeLength();
    if (this.OOu == 0)
    {
      AppMethodBeat.o(141726);
      return 0.0F;
    }
    if (this.OOu < i)
    {
      float f = this.OOu / i;
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
    if (this.OOu == this.OOw)
    {
      AppMethodBeat.o(141727);
      return 0.0F;
    }
    if (this.OOw - this.OOu < i)
    {
      float f = (this.OOw - this.OOu) / i;
      AppMethodBeat.o(141727);
      return f;
    }
    AppMethodBeat.o(141727);
    return 1.0F;
  }
  
  public View getSelectedView()
  {
    AppMethodBeat.i(141718);
    int i = this.OOO;
    if ((i >= this.OOM) && (i <= this.OON))
    {
      View localView = getChildAt(i - this.OOM);
      AppMethodBeat.o(141718);
      return localView;
    }
    AppMethodBeat.o(141718);
    return null;
  }
  
  protected final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141741);
    if (!this.OOH.isFinished()) {}
    for (boolean bool = true;; bool = false)
    {
      this.OOX = bool;
      this.OOH.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.OPc);
      gKu();
      if (!this.OOX)
      {
        int i = kS((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (i >= 0)
        {
          this.OOK = getChildAt(i);
          if (this.OOK != null)
          {
            this.OOK.setPressed(true);
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
      if ((i != j - 1) || (!als(this.OON)))
      {
        View localView = getChildAt(i);
        localRect.left = localView.getRight();
        localRect.right = (localView.getRight() + this.aqn);
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
    if (this.GO == null)
    {
      AppMethodBeat.o(141725);
      return;
    }
    invalidate();
    if (this.OOC)
    {
      i = this.OOu;
      initView();
      removeAllViewsInLayout();
      this.OOv = i;
      this.OOC = false;
    }
    if (this.OOL != null)
    {
      this.OOv = this.OOL.intValue();
      this.OOL = null;
    }
    if (this.OOH.computeScrollOffset()) {
      this.OOv = this.OOH.getCurrX();
    }
    int k;
    label181:
    int j;
    if (this.OOv < 0)
    {
      this.OOv = 0;
      if (this.OOU.Uv.isFinished()) {
        this.OOU.aX((int)gKs());
      }
      this.OOH.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.OPc);
      k = this.OOu - this.OOv;
      localView = getLeftmostChild();
      if ((localView == null) || (localView.getRight() + k > 0)) {
        break label343;
      }
      j = this.OOx;
      if (!als(this.OOM)) {
        break label328;
      }
    }
    label328:
    for (int i = localView.getMeasuredWidth();; i = this.aqn + localView.getMeasuredWidth())
    {
      this.OOx = (i + j);
      p(this.OOM, localView);
      removeViewInLayout(localView);
      this.OOM += 1;
      localView = getLeftmostChild();
      break label181;
      if (this.OOv <= this.OOw) {
        break;
      }
      this.OOv = this.OOw;
      if (this.OOV.Uv.isFinished()) {
        this.OOV.aX((int)gKs());
      }
      this.OOH.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.OPc);
      break;
    }
    for (;;)
    {
      label343:
      localView = getRightmostChild();
      if ((localView == null) || (localView.getLeft() + k < getWidth())) {
        break;
      }
      p(this.OON, localView);
      removeViewInLayout(localView);
      this.OON -= 1;
    }
    i = 0;
    View localView = getRightmostChild();
    if (localView != null) {
      i = localView.getRight();
    }
    if ((i + k + this.aqn < getWidth()) && (this.OON + 1 < this.GO.getCount()))
    {
      this.OON += 1;
      if (this.OOM < 0) {
        this.OOM = this.OON;
      }
      localView = this.GO.getView(this.OON, alq(this.OON), this);
      aG(localView, -1);
      if (this.OON == 0) {}
      for (j = 0;; j = this.aqn)
      {
        j = i + (j + localView.getMeasuredWidth());
        i = j;
        if (this.OOP == null) {
          break;
        }
        i = j;
        if (this.GO == null) {
          break;
        }
        i = j;
        if (this.GO.getCount() - (this.OON + 1) >= this.OOQ) {
          break;
        }
        i = j;
        if (this.OOR) {
          break;
        }
        this.OOR = true;
        i = j;
        break;
      }
    }
    i = 0;
    localView = getLeftmostChild();
    if (localView != null) {
      i = localView.getLeft();
    }
    if ((i + k - this.aqn > 0) && (this.OOM > 0))
    {
      this.OOM -= 1;
      localView = this.GO.getView(this.OOM, alq(this.OOM), this);
      aG(localView, 0);
      if (this.OOM == 0)
      {
        j = localView.getMeasuredWidth();
        label710:
        j = i - j;
        m = this.OOx;
        if (j + k != 0) {
          break label769;
        }
      }
      label769:
      for (i = localView.getMeasuredWidth();; i = this.aqn + localView.getMeasuredWidth())
      {
        this.OOx = (m - i);
        i = j;
        break;
        j = this.aqn + localView.getMeasuredWidth();
        break label710;
      }
    }
    int m = getChildCount();
    if (m > 0)
    {
      this.OOx += k;
      j = this.OOx;
      i = 0;
      while (i < m)
      {
        localView = getChildAt(i);
        k = getPaddingLeft() + j;
        int n = getPaddingTop();
        localView.layout(k, n, localView.getMeasuredWidth() + k, localView.getMeasuredHeight() + n);
        j += localView.getMeasuredWidth() + this.aqn;
        i += 1;
      }
    }
    this.OOu = this.OOv;
    if (als(this.OON))
    {
      localView = getRightmostChild();
      if (localView != null)
      {
        i = this.OOw;
        j = this.OOu;
        this.OOw = (localView.getRight() - getPaddingLeft() + j - getRenderWidth());
        if (this.OOw < 0) {
          this.OOw = 0;
        }
        if (this.OOw == i) {}
      }
    }
    for (i = 1; i != 0; i = 0)
    {
      onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(141725);
      return;
    }
    if (this.OOH.isFinished())
    {
      if (this.OOT == HorizontalListViewV2.d.a.OPe)
      {
        setCurrentScrollState(HorizontalListViewV2.d.a.OPc);
        AppMethodBeat.o(141725);
      }
    }
    else {
      u.b(this, this.OPa);
    }
    AppMethodBeat.o(141725);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141729);
    super.onMeasure(paramInt1, paramInt2);
    this.OOW = paramInt2;
    AppMethodBeat.o(141729);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(141713);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.OOL = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
    AppMethodBeat.o(141713);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(141712);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.OOu);
    AppMethodBeat.o(141712);
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141743);
    if (paramMotionEvent.getAction() == 1)
    {
      if ((this.OOH == null) || (this.OOH.isFinished())) {
        setCurrentScrollState(HorizontalListViewV2.d.a.OPc);
      }
      r(Boolean.FALSE);
      gKv();
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141743);
      return bool;
      if (paramMotionEvent.getAction() == 3)
      {
        gKu();
        gKv();
        r(Boolean.FALSE);
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    int i = 0;
    AppMethodBeat.i(141719);
    if (this.GO != null) {
      this.GO.unregisterDataSetObserver(this.OOZ);
    }
    if (paramListAdapter != null)
    {
      this.OOR = false;
      this.GO = paramListAdapter;
      this.GO.registerDataSetObserver(this.OOZ);
    }
    if (this.GO != null)
    {
      int j = this.GO.getViewTypeCount();
      this.OOJ.clear();
      while (i < j)
      {
        this.OOJ.add(new LinkedList());
        i += 1;
      }
    }
    reset();
    AppMethodBeat.o(141719);
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    AppMethodBeat.i(141714);
    this.amP = paramDrawable;
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
    this.aqn = paramInt;
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
    this.OOS = paramd;
  }
  
  public void setSelection(int paramInt)
  {
    this.OOO = paramInt;
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205210);
      b localb = new b();
      localb.bm(paramMotionEvent);
      a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onContextClick(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(205210);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(205209);
      b localb = new b();
      localb.bm(paramMotionEvent);
      a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(205209);
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
      boolean bool = HorizontalListViewV2.this.cr(paramFloat1);
      AppMethodBeat.o(141699);
      return bool;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(141702);
      Object localObject = new b();
      ((b)localObject).bm(paramMotionEvent);
      a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, ((b)localObject).axR());
      HorizontalListViewV2.d(HorizontalListViewV2.this);
      int i = HorizontalListViewV2.a(HorizontalListViewV2.this, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if ((i >= 0) && (!HorizontalListViewV2.f(HorizontalListViewV2.this)))
      {
        paramMotionEvent = HorizontalListViewV2.this.getChildAt(i);
        localObject = HorizontalListViewV2.this.getOnItemLongClickListener();
        if (localObject != null)
        {
          i = HorizontalListViewV2.g(HorizontalListViewV2.this) + i;
          if (((AdapterView.OnItemLongClickListener)localObject).onItemLongClick(HorizontalListViewV2.this, paramMotionEvent, i, HorizontalListViewV2.this.GO.getItemId(i))) {
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
      HorizontalListViewV2.a(HorizontalListViewV2.this, HorizontalListViewV2.d.a.OPd);
      HorizontalListViewV2.d(HorizontalListViewV2.this);
      paramMotionEvent1 = HorizontalListViewV2.this;
      paramMotionEvent1.OOv += (int)paramFloat1;
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
          localOnItemClickListener.onItemClick(HorizontalListViewV2.this, paramMotionEvent, i, HorizontalListViewV2.this.GO.getItemId(i));
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
      AppMethodBeat.i(205208);
      b localb = new b();
      localb.bm(paramMotionEvent);
      a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(205208);
      return bool;
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(a parama);
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(141709);
        OPc = new a("SCROLL_STATE_IDLE", 0);
        OPd = new a("SCROLL_STATE_TOUCH_SCROLL", 1);
        OPe = new a("SCROLL_STATE_FLING", 2);
        OPf = new a[] { OPc, OPd, OPe };
        AppMethodBeat.o(141709);
      }
      
      private a() {}
    }
  }
  
  public static abstract interface e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2
 * JD-Core Version:    0.7.0.1
 */