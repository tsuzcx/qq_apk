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
  protected ListAdapter EN;
  protected int HuY;
  protected int HuZ;
  private int HvA;
  private boolean HvB;
  private boolean HvC;
  private DataSetObserver HvD;
  private Runnable HvE;
  private int Hva;
  private int Hvb;
  private boolean Hvg;
  protected Scroller Hvl;
  private final a Hvm;
  private List<Queue<View>> Hvn;
  private View Hvo;
  private Integer Hvp;
  private int Hvq;
  private int Hvr;
  private int Hvs;
  private e Hvt;
  private int Hvu;
  private boolean Hvv;
  private HorizontalListViewV2.d Hvw;
  private HorizontalListViewV2.d.a Hvx;
  private i Hvy;
  private i Hvz;
  private Drawable akL;
  private int aoj;
  private GestureDetector kVo;
  private View.OnClickListener mOnClickListener;
  private Rect mRect;
  
  public HorizontalListViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141710);
    this.Hvl = new Scroller(getContext());
    this.Hvm = new a((byte)0);
    this.Hvn = new ArrayList();
    this.Hvg = false;
    this.mRect = new Rect();
    this.Hvo = null;
    this.aoj = 0;
    this.akL = null;
    this.Hvp = null;
    this.Hva = 2147483647;
    this.Hvt = null;
    this.Hvu = 0;
    this.Hvv = false;
    this.Hvw = null;
    this.Hvx = HorizontalListViewV2.d.a.HvG;
    this.HvB = false;
    this.HvC = false;
    this.HvD = new DataSetObserver()
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
    this.HvE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141697);
        HorizontalListViewV2.this.requestLayout();
        AppMethodBeat.o(141697);
      }
    };
    this.Hvy = new i(paramContext);
    this.Hvz = new i(paramContext);
    this.kVo = new GestureDetector(paramContext, this.Hvm);
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
      HorizontalListViewV2.b.a(this.Hvl);
    }
    AppMethodBeat.o(141710);
  }
  
  private View ZP(int paramInt)
  {
    AppMethodBeat.i(141720);
    paramInt = this.EN.getItemViewType(paramInt);
    if (ZQ(paramInt))
    {
      View localView = (View)((Queue)this.Hvn.get(paramInt)).poll();
      AppMethodBeat.o(141720);
      return localView;
    }
    AppMethodBeat.o(141720);
    return null;
  }
  
  private boolean ZQ(int paramInt)
  {
    AppMethodBeat.i(141722);
    if (paramInt < this.Hvn.size())
    {
      AppMethodBeat.o(141722);
      return true;
    }
    AppMethodBeat.o(141722);
    return false;
  }
  
  private boolean ZR(int paramInt)
  {
    AppMethodBeat.i(141733);
    if (paramInt == this.EN.getCount() - 1)
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
    if (this.akL != null)
    {
      this.akL.setBounds(paramRect);
      this.akL.draw(paramCanvas);
    }
    AppMethodBeat.o(141737);
  }
  
  private void az(View paramView, int paramInt)
  {
    AppMethodBeat.i(141723);
    addViewInLayout(paramView, paramInt, fQ(paramView), true);
    ViewGroup.LayoutParams localLayoutParams = fQ(paramView);
    int i = ViewGroup.getChildMeasureSpec(this.HvA, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    if (localLayoutParams.width > 0) {}
    for (paramInt = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);; paramInt = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt, i);
      AppMethodBeat.o(141723);
      return;
    }
  }
  
  private static ViewGroup.LayoutParams fQ(View paramView)
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
  
  private float fid()
  {
    AppMethodBeat.i(141728);
    if (Build.VERSION.SDK_INT >= 14)
    {
      float f = HorizontalListViewV2.c.b(this.Hvl);
      AppMethodBeat.o(141728);
      return f;
    }
    AppMethodBeat.o(141728);
    return 30.0F;
  }
  
  private void fif()
  {
    AppMethodBeat.i(141742);
    if (this.Hvo != null)
    {
      this.Hvo.setPressed(false);
      refreshDrawableState();
      this.Hvo = null;
    }
    AppMethodBeat.o(141742);
  }
  
  private void fig()
  {
    AppMethodBeat.i(141744);
    if (this.Hvy != null) {
      this.Hvy.fC();
    }
    if (this.Hvz != null) {
      this.Hvz.fC();
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
  
  private void initView()
  {
    AppMethodBeat.i(141716);
    this.Hvq = -1;
    this.Hvr = -1;
    this.Hvb = 0;
    this.HuY = 0;
    this.HuZ = 0;
    this.Hva = 2147483647;
    setCurrentScrollState(HorizontalListViewV2.d.a.HvG);
    AppMethodBeat.o(141716);
  }
  
  private int jt(int paramInt1, int paramInt2)
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
    paramInt = this.EN.getItemViewType(paramInt);
    if (ZQ(paramInt)) {
      ((Queue)this.Hvn.get(paramInt)).offer(paramView);
    }
    AppMethodBeat.o(141721);
  }
  
  private void m(Boolean paramBoolean)
  {
    AppMethodBeat.i(141711);
    if (this.HvC != paramBoolean.booleanValue()) {
      for (Object localObject = this; (((View)localObject).getParent() instanceof View); localObject = (View)((View)localObject).getParent()) {
        if (((((View)localObject).getParent() instanceof ListView)) || ((((View)localObject).getParent() instanceof ScrollView)))
        {
          ((View)localObject).getParent().requestDisallowInterceptTouchEvent(paramBoolean.booleanValue());
          this.HvC = paramBoolean.booleanValue();
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
    if ((this.Hvx != parama) && (this.Hvw != null)) {
      this.Hvw.a(parama);
    }
    this.Hvx = parama;
    AppMethodBeat.o(141745);
  }
  
  protected final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(141740);
    this.Hvl.fling(this.HuZ, 0, (int)-paramFloat, 0, 0, this.Hva, 0, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.HvI);
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
  
  public final void fie()
  {
    AppMethodBeat.i(141736);
    this.Hvl.startScroll(this.HuZ, 0, 0 - this.HuZ, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.HvI);
    requestLayout();
    AppMethodBeat.o(141736);
  }
  
  public ListAdapter getAdapter()
  {
    return this.EN;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.Hvq;
  }
  
  public int getLastVisiblePosition()
  {
    return this.Hvr;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(141726);
    int i = getHorizontalFadingEdgeLength();
    if (this.HuY == 0)
    {
      AppMethodBeat.o(141726);
      return 0.0F;
    }
    if (this.HuY < i)
    {
      float f = this.HuY / i;
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
    if (this.HuY == this.Hva)
    {
      AppMethodBeat.o(141727);
      return 0.0F;
    }
    if (this.Hva - this.HuY < i)
    {
      float f = (this.Hva - this.HuY) / i;
      AppMethodBeat.o(141727);
      return f;
    }
    AppMethodBeat.o(141727);
    return 1.0F;
  }
  
  public View getSelectedView()
  {
    AppMethodBeat.i(141718);
    int i = this.Hvs;
    if ((i >= this.Hvq) && (i <= this.Hvr))
    {
      View localView = getChildAt(i - this.Hvq);
      AppMethodBeat.o(141718);
      return localView;
    }
    AppMethodBeat.o(141718);
    return null;
  }
  
  protected final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141741);
    if (!this.Hvl.isFinished()) {}
    for (boolean bool = true;; bool = false)
    {
      this.HvB = bool;
      this.Hvl.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.HvG);
      fif();
      if (!this.HvB)
      {
        int i = jt((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (i >= 0)
        {
          this.Hvo = getChildAt(i);
          if (this.Hvo != null)
          {
            this.Hvo.setPressed(true);
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
      if ((i != j - 1) || (!ZR(this.Hvr)))
      {
        View localView = getChildAt(i);
        localRect.left = localView.getRight();
        localRect.right = (localView.getRight() + this.aoj);
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
    if (this.EN == null)
    {
      AppMethodBeat.o(141725);
      return;
    }
    invalidate();
    if (this.Hvg)
    {
      i = this.HuY;
      initView();
      removeAllViewsInLayout();
      this.HuZ = i;
      this.Hvg = false;
    }
    if (this.Hvp != null)
    {
      this.HuZ = this.Hvp.intValue();
      this.Hvp = null;
    }
    if (this.Hvl.computeScrollOffset()) {
      this.HuZ = this.Hvl.getCurrX();
    }
    int k;
    label181:
    int j;
    if (this.HuZ < 0)
    {
      this.HuZ = 0;
      if (this.Hvy.Su.isFinished()) {
        this.Hvy.aW((int)fid());
      }
      this.Hvl.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.HvG);
      k = this.HuY - this.HuZ;
      localView = getLeftmostChild();
      if ((localView == null) || (localView.getRight() + k > 0)) {
        break label343;
      }
      j = this.Hvb;
      if (!ZR(this.Hvq)) {
        break label328;
      }
    }
    label328:
    for (int i = localView.getMeasuredWidth();; i = this.aoj + localView.getMeasuredWidth())
    {
      this.Hvb = (i + j);
      m(this.Hvq, localView);
      removeViewInLayout(localView);
      this.Hvq += 1;
      localView = getLeftmostChild();
      break label181;
      if (this.HuZ <= this.Hva) {
        break;
      }
      this.HuZ = this.Hva;
      if (this.Hvz.Su.isFinished()) {
        this.Hvz.aW((int)fid());
      }
      this.Hvl.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.HvG);
      break;
    }
    for (;;)
    {
      label343:
      localView = getRightmostChild();
      if ((localView == null) || (localView.getLeft() + k < getWidth())) {
        break;
      }
      m(this.Hvr, localView);
      removeViewInLayout(localView);
      this.Hvr -= 1;
    }
    i = 0;
    View localView = getRightmostChild();
    if (localView != null) {
      i = localView.getRight();
    }
    if ((i + k + this.aoj < getWidth()) && (this.Hvr + 1 < this.EN.getCount()))
    {
      this.Hvr += 1;
      if (this.Hvq < 0) {
        this.Hvq = this.Hvr;
      }
      localView = this.EN.getView(this.Hvr, ZP(this.Hvr), this);
      az(localView, -1);
      if (this.Hvr == 0) {}
      for (j = 0;; j = this.aoj)
      {
        j = i + (j + localView.getMeasuredWidth());
        i = j;
        if (this.Hvt == null) {
          break;
        }
        i = j;
        if (this.EN == null) {
          break;
        }
        i = j;
        if (this.EN.getCount() - (this.Hvr + 1) >= this.Hvu) {
          break;
        }
        i = j;
        if (this.Hvv) {
          break;
        }
        this.Hvv = true;
        i = j;
        break;
      }
    }
    i = 0;
    localView = getLeftmostChild();
    if (localView != null) {
      i = localView.getLeft();
    }
    if ((i + k - this.aoj > 0) && (this.Hvq > 0))
    {
      this.Hvq -= 1;
      localView = this.EN.getView(this.Hvq, ZP(this.Hvq), this);
      az(localView, 0);
      if (this.Hvq == 0)
      {
        j = localView.getMeasuredWidth();
        label710:
        j = i - j;
        m = this.Hvb;
        if (j + k != 0) {
          break label769;
        }
      }
      label769:
      for (i = localView.getMeasuredWidth();; i = this.aoj + localView.getMeasuredWidth())
      {
        this.Hvb = (m - i);
        i = j;
        break;
        j = this.aoj + localView.getMeasuredWidth();
        break label710;
      }
    }
    int m = getChildCount();
    if (m > 0)
    {
      this.Hvb += k;
      j = this.Hvb;
      i = 0;
      while (i < m)
      {
        localView = getChildAt(i);
        k = getPaddingLeft() + j;
        int n = getPaddingTop();
        localView.layout(k, n, localView.getMeasuredWidth() + k, localView.getMeasuredHeight() + n);
        j += localView.getMeasuredWidth() + this.aoj;
        i += 1;
      }
    }
    this.HuY = this.HuZ;
    if (ZR(this.Hvr))
    {
      localView = getRightmostChild();
      if (localView != null)
      {
        i = this.Hva;
        j = this.HuY;
        this.Hva = (localView.getRight() - getPaddingLeft() + j - getRenderWidth());
        if (this.Hva < 0) {
          this.Hva = 0;
        }
        if (this.Hva == i) {}
      }
    }
    for (i = 1; i != 0; i = 0)
    {
      onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(141725);
      return;
    }
    if (this.Hvl.isFinished())
    {
      if (this.Hvx == HorizontalListViewV2.d.a.HvI)
      {
        setCurrentScrollState(HorizontalListViewV2.d.a.HvG);
        AppMethodBeat.o(141725);
      }
    }
    else {
      t.b(this, this.HvE);
    }
    AppMethodBeat.o(141725);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141729);
    super.onMeasure(paramInt1, paramInt2);
    this.HvA = paramInt2;
    AppMethodBeat.o(141729);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(141713);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.Hvp = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
    AppMethodBeat.o(141713);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(141712);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.HuY);
    AppMethodBeat.o(141712);
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141743);
    if (paramMotionEvent.getAction() == 1)
    {
      if ((this.Hvl == null) || (this.Hvl.isFinished())) {
        setCurrentScrollState(HorizontalListViewV2.d.a.HvG);
      }
      m(Boolean.FALSE);
      fig();
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141743);
      return bool;
      if (paramMotionEvent.getAction() == 3)
      {
        fif();
        fig();
        m(Boolean.FALSE);
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    int i = 0;
    AppMethodBeat.i(141719);
    if (this.EN != null) {
      this.EN.unregisterDataSetObserver(this.HvD);
    }
    if (paramListAdapter != null)
    {
      this.Hvv = false;
      this.EN = paramListAdapter;
      this.EN.registerDataSetObserver(this.HvD);
    }
    if (this.EN != null)
    {
      int j = this.EN.getViewTypeCount();
      this.Hvn.clear();
      while (i < j)
      {
        this.Hvn.add(new LinkedList());
        i += 1;
      }
    }
    reset();
    AppMethodBeat.o(141719);
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    AppMethodBeat.i(141714);
    this.akL = paramDrawable;
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
    this.aoj = paramInt;
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
    this.Hvw = paramd;
  }
  
  public void setSelection(int paramInt)
  {
    this.Hvs = paramInt;
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
      boolean bool = HorizontalListViewV2.this.bM(paramFloat1);
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
          if (localOnItemLongClickListener.onItemLongClick(HorizontalListViewV2.this, paramMotionEvent, i, HorizontalListViewV2.this.EN.getItemId(i))) {
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
      HorizontalListViewV2.a(HorizontalListViewV2.this, HorizontalListViewV2.d.a.HvH);
      HorizontalListViewV2.d(HorizontalListViewV2.this);
      paramMotionEvent1 = HorizontalListViewV2.this;
      paramMotionEvent1.HuZ += (int)paramFloat1;
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
          localOnItemClickListener.onItemClick(HorizontalListViewV2.this, paramMotionEvent, i, HorizontalListViewV2.this.EN.getItemId(i));
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
  
  public static abstract interface e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2
 * JD-Core Version:    0.7.0.1
 */