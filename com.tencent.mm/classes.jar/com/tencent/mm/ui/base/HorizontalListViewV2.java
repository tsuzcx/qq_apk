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
import android.view.View.OnTouchListener;
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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListViewV2
  extends AdapterView<ListAdapter>
{
  protected ListAdapter DP;
  private View FVA;
  private Integer FVB;
  private int FVC;
  private int FVD;
  private int FVE;
  private e FVF;
  private int FVG;
  private boolean FVH;
  private d FVI;
  private HorizontalListViewV2.d.a FVJ;
  private i FVK;
  private i FVL;
  private int FVM;
  private boolean FVN;
  private boolean FVO;
  private DataSetObserver FVP;
  private Runnable FVQ;
  protected int FVk;
  protected int FVl;
  private int FVm;
  private int FVn;
  private boolean FVs;
  protected Scroller FVx;
  private final a FVy;
  private List<Queue<View>> FVz;
  private Drawable ajR;
  private int ano;
  private GestureDetector ktZ;
  private View.OnClickListener mOnClickListener;
  private Rect mRect;
  
  public HorizontalListViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141710);
    this.FVx = new Scroller(getContext());
    this.FVy = new a((byte)0);
    this.FVz = new ArrayList();
    this.FVs = false;
    this.mRect = new Rect();
    this.FVA = null;
    this.ano = 0;
    this.ajR = null;
    this.FVB = null;
    this.FVm = 2147483647;
    this.FVF = null;
    this.FVG = 0;
    this.FVH = false;
    this.FVI = null;
    this.FVJ = HorizontalListViewV2.d.a.FVS;
    this.FVN = false;
    this.FVO = false;
    this.FVP = new DataSetObserver()
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
    this.FVQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141697);
        HorizontalListViewV2.this.requestLayout();
        AppMethodBeat.o(141697);
      }
    };
    this.FVK = new i(paramContext);
    this.FVL = new i(paramContext);
    this.ktZ = new GestureDetector(paramContext, this.FVy);
    setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(141694);
        boolean bool = HorizontalListViewV2.a(HorizontalListViewV2.this).onTouchEvent(paramAnonymousMotionEvent);
        AppMethodBeat.o(141694);
        return bool;
      }
    });
    initView();
    setWillNotDraw(false);
    if (Build.VERSION.SDK_INT >= 11) {
      HorizontalListViewV2.b.a(this.FVx);
    }
    AppMethodBeat.o(141710);
  }
  
  private View XE(int paramInt)
  {
    AppMethodBeat.i(141720);
    paramInt = this.DP.getItemViewType(paramInt);
    if (XF(paramInt))
    {
      View localView = (View)((Queue)this.FVz.get(paramInt)).poll();
      AppMethodBeat.o(141720);
      return localView;
    }
    AppMethodBeat.o(141720);
    return null;
  }
  
  private boolean XF(int paramInt)
  {
    AppMethodBeat.i(141722);
    if (paramInt < this.FVz.size())
    {
      AppMethodBeat.o(141722);
      return true;
    }
    AppMethodBeat.o(141722);
    return false;
  }
  
  private boolean XG(int paramInt)
  {
    AppMethodBeat.i(141733);
    if (paramInt == this.DP.getCount() - 1)
    {
      AppMethodBeat.o(141733);
      return true;
    }
    AppMethodBeat.o(141733);
    return false;
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    AppMethodBeat.i(141737);
    if (this.ajR != null)
    {
      this.ajR.setBounds(paramRect);
      this.ajR.draw(paramCanvas);
    }
    AppMethodBeat.o(141737);
  }
  
  private void ax(View paramView, int paramInt)
  {
    AppMethodBeat.i(141723);
    addViewInLayout(paramView, paramInt, fD(paramView), true);
    ViewGroup.LayoutParams localLayoutParams = fD(paramView);
    int i = ViewGroup.getChildMeasureSpec(this.FVM, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    if (localLayoutParams.width > 0) {}
    for (paramInt = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);; paramInt = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt, i);
      AppMethodBeat.o(141723);
      return;
    }
  }
  
  private float eSt()
  {
    AppMethodBeat.i(141728);
    if (Build.VERSION.SDK_INT >= 14)
    {
      float f = HorizontalListViewV2.c.b(this.FVx);
      AppMethodBeat.o(141728);
      return f;
    }
    AppMethodBeat.o(141728);
    return 30.0F;
  }
  
  private void eSv()
  {
    AppMethodBeat.i(141742);
    if (this.FVA != null)
    {
      this.FVA.setPressed(false);
      refreshDrawableState();
      this.FVA = null;
    }
    AppMethodBeat.o(141742);
  }
  
  private void eSw()
  {
    AppMethodBeat.i(141744);
    if (this.FVK != null) {
      this.FVK.fu();
    }
    if (this.FVL != null) {
      this.FVL.fu();
    }
    AppMethodBeat.o(141744);
  }
  
  private static ViewGroup.LayoutParams fD(View paramView)
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
    this.FVC = -1;
    this.FVD = -1;
    this.FVn = 0;
    this.FVk = 0;
    this.FVl = 0;
    this.FVm = 2147483647;
    setCurrentScrollState(HorizontalListViewV2.d.a.FVS);
    AppMethodBeat.o(141716);
  }
  
  private int jg(int paramInt1, int paramInt2)
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
  
  private void m(int paramInt, View paramView)
  {
    AppMethodBeat.i(141721);
    paramInt = this.DP.getItemViewType(paramInt);
    if (XF(paramInt)) {
      ((Queue)this.FVz.get(paramInt)).offer(paramView);
    }
    AppMethodBeat.o(141721);
  }
  
  private void m(Boolean paramBoolean)
  {
    AppMethodBeat.i(141711);
    if (this.FVO != paramBoolean.booleanValue()) {
      for (Object localObject = this; (((View)localObject).getParent() instanceof View); localObject = (View)((View)localObject).getParent()) {
        if (((((View)localObject).getParent() instanceof ListView)) || ((((View)localObject).getParent() instanceof ScrollView)))
        {
          ((View)localObject).getParent().requestDisallowInterceptTouchEvent(paramBoolean.booleanValue());
          this.FVO = paramBoolean.booleanValue();
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
    if ((this.FVJ != parama) && (this.FVI != null)) {
      this.FVI.a(parama);
    }
    this.FVJ = parama;
    AppMethodBeat.o(141745);
  }
  
  protected final boolean bE(float paramFloat)
  {
    AppMethodBeat.i(141740);
    this.FVx.fling(this.FVl, 0, (int)-paramFloat, 0, 0, this.FVm, 0, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.FVU);
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
  
  public final void eSu()
  {
    AppMethodBeat.i(141736);
    this.FVx.startScroll(this.FVl, 0, 0 - this.FVl, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.FVU);
    requestLayout();
    AppMethodBeat.o(141736);
  }
  
  public ListAdapter getAdapter()
  {
    return this.DP;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.FVC;
  }
  
  public int getLastVisiblePosition()
  {
    return this.FVD;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(141726);
    int i = getHorizontalFadingEdgeLength();
    if (this.FVk == 0)
    {
      AppMethodBeat.o(141726);
      return 0.0F;
    }
    if (this.FVk < i)
    {
      float f = this.FVk / i;
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
    if (this.FVk == this.FVm)
    {
      AppMethodBeat.o(141727);
      return 0.0F;
    }
    if (this.FVm - this.FVk < i)
    {
      float f = (this.FVm - this.FVk) / i;
      AppMethodBeat.o(141727);
      return f;
    }
    AppMethodBeat.o(141727);
    return 1.0F;
  }
  
  public View getSelectedView()
  {
    AppMethodBeat.i(141718);
    int i = this.FVE;
    if ((i >= this.FVC) && (i <= this.FVD))
    {
      View localView = getChildAt(i - this.FVC);
      AppMethodBeat.o(141718);
      return localView;
    }
    AppMethodBeat.o(141718);
    return null;
  }
  
  protected final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141741);
    if (!this.FVx.isFinished()) {}
    for (boolean bool = true;; bool = false)
    {
      this.FVN = bool;
      this.FVx.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.FVS);
      eSv();
      if (!this.FVN)
      {
        int i = jg((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (i >= 0)
        {
          this.FVA = getChildAt(i);
          if (this.FVA != null)
          {
            this.FVA.setPressed(true);
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
      if ((i != j - 1) || (!XG(this.FVD)))
      {
        View localView = getChildAt(i);
        localRect.left = localView.getRight();
        localRect.right = (localView.getRight() + this.ano);
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
    if (this.DP == null)
    {
      AppMethodBeat.o(141725);
      return;
    }
    invalidate();
    if (this.FVs)
    {
      i = this.FVk;
      initView();
      removeAllViewsInLayout();
      this.FVl = i;
      this.FVs = false;
    }
    if (this.FVB != null)
    {
      this.FVl = this.FVB.intValue();
      this.FVB = null;
    }
    if (this.FVx.computeScrollOffset()) {
      this.FVl = this.FVx.getCurrX();
    }
    int k;
    label181:
    int j;
    if (this.FVl < 0)
    {
      this.FVl = 0;
      if (this.FVK.Rz.isFinished()) {
        this.FVK.aW((int)eSt());
      }
      this.FVx.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.FVS);
      k = this.FVk - this.FVl;
      localView = getLeftmostChild();
      if ((localView == null) || (localView.getRight() + k > 0)) {
        break label343;
      }
      j = this.FVn;
      if (!XG(this.FVC)) {
        break label328;
      }
    }
    label328:
    for (int i = localView.getMeasuredWidth();; i = this.ano + localView.getMeasuredWidth())
    {
      this.FVn = (i + j);
      m(this.FVC, localView);
      removeViewInLayout(localView);
      this.FVC += 1;
      localView = getLeftmostChild();
      break label181;
      if (this.FVl <= this.FVm) {
        break;
      }
      this.FVl = this.FVm;
      if (this.FVL.Rz.isFinished()) {
        this.FVL.aW((int)eSt());
      }
      this.FVx.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.FVS);
      break;
    }
    for (;;)
    {
      label343:
      localView = getRightmostChild();
      if ((localView == null) || (localView.getLeft() + k < getWidth())) {
        break;
      }
      m(this.FVD, localView);
      removeViewInLayout(localView);
      this.FVD -= 1;
    }
    i = 0;
    View localView = getRightmostChild();
    if (localView != null) {
      i = localView.getRight();
    }
    if ((i + k + this.ano < getWidth()) && (this.FVD + 1 < this.DP.getCount()))
    {
      this.FVD += 1;
      if (this.FVC < 0) {
        this.FVC = this.FVD;
      }
      localView = this.DP.getView(this.FVD, XE(this.FVD), this);
      ax(localView, -1);
      if (this.FVD == 0) {}
      for (j = 0;; j = this.ano)
      {
        j = i + (j + localView.getMeasuredWidth());
        i = j;
        if (this.FVF == null) {
          break;
        }
        i = j;
        if (this.DP == null) {
          break;
        }
        i = j;
        if (this.DP.getCount() - (this.FVD + 1) >= this.FVG) {
          break;
        }
        i = j;
        if (this.FVH) {
          break;
        }
        this.FVH = true;
        i = j;
        break;
      }
    }
    i = 0;
    localView = getLeftmostChild();
    if (localView != null) {
      i = localView.getLeft();
    }
    if ((i + k - this.ano > 0) && (this.FVC > 0))
    {
      this.FVC -= 1;
      localView = this.DP.getView(this.FVC, XE(this.FVC), this);
      ax(localView, 0);
      if (this.FVC == 0)
      {
        j = localView.getMeasuredWidth();
        label710:
        j = i - j;
        m = this.FVn;
        if (j + k != 0) {
          break label769;
        }
      }
      label769:
      for (i = localView.getMeasuredWidth();; i = this.ano + localView.getMeasuredWidth())
      {
        this.FVn = (m - i);
        i = j;
        break;
        j = this.ano + localView.getMeasuredWidth();
        break label710;
      }
    }
    int m = getChildCount();
    if (m > 0)
    {
      this.FVn += k;
      j = this.FVn;
      i = 0;
      while (i < m)
      {
        localView = getChildAt(i);
        k = getPaddingLeft() + j;
        int n = getPaddingTop();
        localView.layout(k, n, localView.getMeasuredWidth() + k, localView.getMeasuredHeight() + n);
        j += localView.getMeasuredWidth() + this.ano;
        i += 1;
      }
    }
    this.FVk = this.FVl;
    if (XG(this.FVD))
    {
      localView = getRightmostChild();
      if (localView != null)
      {
        i = this.FVm;
        j = this.FVk;
        this.FVm = (localView.getRight() - getPaddingLeft() + j - getRenderWidth());
        if (this.FVm < 0) {
          this.FVm = 0;
        }
        if (this.FVm == i) {}
      }
    }
    for (i = 1; i != 0; i = 0)
    {
      onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(141725);
      return;
    }
    if (this.FVx.isFinished())
    {
      if (this.FVJ == HorizontalListViewV2.d.a.FVU)
      {
        setCurrentScrollState(HorizontalListViewV2.d.a.FVS);
        AppMethodBeat.o(141725);
      }
    }
    else {
      t.b(this, this.FVQ);
    }
    AppMethodBeat.o(141725);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141729);
    super.onMeasure(paramInt1, paramInt2);
    this.FVM = paramInt2;
    AppMethodBeat.o(141729);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(141713);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.FVB = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
    AppMethodBeat.o(141713);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(141712);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.FVk);
    AppMethodBeat.o(141712);
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141743);
    if (paramMotionEvent.getAction() == 1)
    {
      if ((this.FVx == null) || (this.FVx.isFinished())) {
        setCurrentScrollState(HorizontalListViewV2.d.a.FVS);
      }
      m(Boolean.FALSE);
      eSw();
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141743);
      return bool;
      if (paramMotionEvent.getAction() == 3)
      {
        eSv();
        eSw();
        m(Boolean.FALSE);
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    int i = 0;
    AppMethodBeat.i(141719);
    if (this.DP != null) {
      this.DP.unregisterDataSetObserver(this.FVP);
    }
    if (paramListAdapter != null)
    {
      this.FVH = false;
      this.DP = paramListAdapter;
      this.DP.registerDataSetObserver(this.FVP);
    }
    if (this.DP != null)
    {
      int j = this.DP.getViewTypeCount();
      this.FVz.clear();
      while (i < j)
      {
        this.FVz.add(new LinkedList());
        i += 1;
      }
    }
    reset();
    AppMethodBeat.o(141719);
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    AppMethodBeat.i(141714);
    this.ajR = paramDrawable;
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
    this.ano = paramInt;
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
    this.FVI = paramd;
  }
  
  public void setSelection(int paramInt)
  {
    this.FVE = paramInt;
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
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
      boolean bool = HorizontalListViewV2.this.bE(paramFloat1);
      AppMethodBeat.o(141699);
      return bool;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(141702);
      HorizontalListViewV2.d(HorizontalListViewV2.this);
      int i = HorizontalListViewV2.a(HorizontalListViewV2.this, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if ((i >= 0) && (!HorizontalListViewV2.f(HorizontalListViewV2.this)))
      {
        paramMotionEvent = HorizontalListViewV2.this.getChildAt(i);
        AdapterView.OnItemLongClickListener localOnItemLongClickListener = HorizontalListViewV2.this.getOnItemLongClickListener();
        if (localOnItemLongClickListener != null)
        {
          i = HorizontalListViewV2.g(HorizontalListViewV2.this) + i;
          if (localOnItemLongClickListener.onItemLongClick(HorizontalListViewV2.this, paramMotionEvent, i, HorizontalListViewV2.this.DP.getItemId(i))) {
            HorizontalListViewV2.this.performHapticFeedback(0);
          }
        }
      }
      AppMethodBeat.o(141702);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(141700);
      HorizontalListViewV2.a(HorizontalListViewV2.this, Boolean.TRUE);
      HorizontalListViewV2.a(HorizontalListViewV2.this, HorizontalListViewV2.d.a.FVT);
      HorizontalListViewV2.d(HorizontalListViewV2.this);
      paramMotionEvent1 = HorizontalListViewV2.this;
      paramMotionEvent1.FVl += (int)paramFloat1;
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
          localOnItemClickListener.onItemClick(HorizontalListViewV2.this, paramMotionEvent, i, HorizontalListViewV2.this.DP.getItemId(i));
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
  }
  
  public static abstract interface d
  {
    public abstract void a(HorizontalListViewV2.d.a parama);
  }
  
  public static abstract interface e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2
 * JD-Core Version:    0.7.0.1
 */