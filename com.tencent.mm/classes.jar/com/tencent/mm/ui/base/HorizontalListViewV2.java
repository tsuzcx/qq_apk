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
  protected int JiO;
  protected int JiP;
  private int JiQ;
  private int JiR;
  private boolean JiW;
  protected Scroller Jjb;
  private final a Jjc;
  private List<Queue<View>> Jjd;
  private View Jje;
  private Integer Jjf;
  private int Jjg;
  private int Jjh;
  private int Jji;
  private e Jjj;
  private int Jjk;
  private boolean Jjl;
  private d Jjm;
  private HorizontalListViewV2.d.a Jjn;
  private i Jjo;
  private i Jjp;
  private int Jjq;
  private boolean Jjr;
  private boolean Jjs;
  private DataSetObserver Jjt;
  private Runnable Jju;
  private Drawable amC;
  private int aqb;
  private GestureDetector lsn;
  private View.OnClickListener mOnClickListener;
  private Rect mRect;
  
  public HorizontalListViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141710);
    this.Jjb = new Scroller(getContext());
    this.Jjc = new a((byte)0);
    this.Jjd = new ArrayList();
    this.JiW = false;
    this.mRect = new Rect();
    this.Jje = null;
    this.aqb = 0;
    this.amC = null;
    this.Jjf = null;
    this.JiQ = 2147483647;
    this.Jjj = null;
    this.Jjk = 0;
    this.Jjl = false;
    this.Jjm = null;
    this.Jjn = HorizontalListViewV2.d.a.Jjw;
    this.Jjr = false;
    this.Jjs = false;
    this.Jjt = new DataSetObserver()
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
    this.Jju = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141697);
        HorizontalListViewV2.this.requestLayout();
        AppMethodBeat.o(141697);
      }
    };
    this.Jjo = new i(paramContext);
    this.Jjp = new i(paramContext);
    this.lsn = new GestureDetector(paramContext, this.Jjc);
    setOnTouchListener(new HorizontalListViewV2.1(this));
    initView();
    setWillNotDraw(false);
    if (Build.VERSION.SDK_INT >= 11) {
      HorizontalListViewV2.b.a(this.Jjb);
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
    addViewInLayout(paramView, paramInt, gf(paramView), true);
    ViewGroup.LayoutParams localLayoutParams = gf(paramView);
    int i = ViewGroup.getChildMeasureSpec(this.Jjq, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    if (localLayoutParams.width > 0) {}
    for (paramInt = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);; paramInt = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt, i);
      AppMethodBeat.o(141723);
      return;
    }
  }
  
  private View abZ(int paramInt)
  {
    AppMethodBeat.i(141720);
    paramInt = this.GE.getItemViewType(paramInt);
    if (aca(paramInt))
    {
      View localView = (View)((Queue)this.Jjd.get(paramInt)).poll();
      AppMethodBeat.o(141720);
      return localView;
    }
    AppMethodBeat.o(141720);
    return null;
  }
  
  private boolean aca(int paramInt)
  {
    AppMethodBeat.i(141722);
    if (paramInt < this.Jjd.size())
    {
      AppMethodBeat.o(141722);
      return true;
    }
    AppMethodBeat.o(141722);
    return false;
  }
  
  private boolean acb(int paramInt)
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
  
  private float fys()
  {
    AppMethodBeat.i(141728);
    if (Build.VERSION.SDK_INT >= 14)
    {
      float f = HorizontalListViewV2.c.b(this.Jjb);
      AppMethodBeat.o(141728);
      return f;
    }
    AppMethodBeat.o(141728);
    return 30.0F;
  }
  
  private void fyu()
  {
    AppMethodBeat.i(141742);
    if (this.Jje != null)
    {
      this.Jje.setPressed(false);
      refreshDrawableState();
      this.Jje = null;
    }
    AppMethodBeat.o(141742);
  }
  
  private void fyv()
  {
    AppMethodBeat.i(141744);
    if (this.Jjo != null) {
      this.Jjo.fT();
    }
    if (this.Jjp != null) {
      this.Jjp.fT();
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
  
  private static ViewGroup.LayoutParams gf(View paramView)
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
    this.Jjg = -1;
    this.Jjh = -1;
    this.JiR = 0;
    this.JiO = 0;
    this.JiP = 0;
    this.JiQ = 2147483647;
    setCurrentScrollState(HorizontalListViewV2.d.a.Jjw);
    AppMethodBeat.o(141716);
  }
  
  private int jF(int paramInt1, int paramInt2)
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
    if (aca(paramInt)) {
      ((Queue)this.Jjd.get(paramInt)).offer(paramView);
    }
    AppMethodBeat.o(141721);
  }
  
  private void p(Boolean paramBoolean)
  {
    AppMethodBeat.i(141711);
    if (this.Jjs != paramBoolean.booleanValue()) {
      for (Object localObject = this; (((View)localObject).getParent() instanceof View); localObject = (View)((View)localObject).getParent()) {
        if (((((View)localObject).getParent() instanceof ListView)) || ((((View)localObject).getParent() instanceof ScrollView)))
        {
          ((View)localObject).getParent().requestDisallowInterceptTouchEvent(paramBoolean.booleanValue());
          this.Jjs = paramBoolean.booleanValue();
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
    if ((this.Jjn != parama) && (this.Jjm != null)) {
      this.Jjm.a(parama);
    }
    this.Jjn = parama;
    AppMethodBeat.o(141745);
  }
  
  protected final boolean bR(float paramFloat)
  {
    AppMethodBeat.i(141740);
    this.Jjb.fling(this.JiP, 0, (int)-paramFloat, 0, 0, this.JiQ, 0, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.Jjy);
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
  
  public final void fyt()
  {
    AppMethodBeat.i(141736);
    this.Jjb.startScroll(this.JiP, 0, 0 - this.JiP, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.Jjy);
    requestLayout();
    AppMethodBeat.o(141736);
  }
  
  public ListAdapter getAdapter()
  {
    return this.GE;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.Jjg;
  }
  
  public int getLastVisiblePosition()
  {
    return this.Jjh;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(141726);
    int i = getHorizontalFadingEdgeLength();
    if (this.JiO == 0)
    {
      AppMethodBeat.o(141726);
      return 0.0F;
    }
    if (this.JiO < i)
    {
      float f = this.JiO / i;
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
    if (this.JiO == this.JiQ)
    {
      AppMethodBeat.o(141727);
      return 0.0F;
    }
    if (this.JiQ - this.JiO < i)
    {
      float f = (this.JiQ - this.JiO) / i;
      AppMethodBeat.o(141727);
      return f;
    }
    AppMethodBeat.o(141727);
    return 1.0F;
  }
  
  public View getSelectedView()
  {
    AppMethodBeat.i(141718);
    int i = this.Jji;
    if ((i >= this.Jjg) && (i <= this.Jjh))
    {
      View localView = getChildAt(i - this.Jjg);
      AppMethodBeat.o(141718);
      return localView;
    }
    AppMethodBeat.o(141718);
    return null;
  }
  
  protected final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141741);
    if (!this.Jjb.isFinished()) {}
    for (boolean bool = true;; bool = false)
    {
      this.Jjr = bool;
      this.Jjb.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.Jjw);
      fyu();
      if (!this.Jjr)
      {
        int i = jF((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (i >= 0)
        {
          this.Jje = getChildAt(i);
          if (this.Jje != null)
          {
            this.Jje.setPressed(true);
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
      if ((i != j - 1) || (!acb(this.Jjh)))
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
    if (this.JiW)
    {
      i = this.JiO;
      initView();
      removeAllViewsInLayout();
      this.JiP = i;
      this.JiW = false;
    }
    if (this.Jjf != null)
    {
      this.JiP = this.Jjf.intValue();
      this.Jjf = null;
    }
    if (this.Jjb.computeScrollOffset()) {
      this.JiP = this.Jjb.getCurrX();
    }
    int k;
    label181:
    int j;
    if (this.JiP < 0)
    {
      this.JiP = 0;
      if (this.Jjo.Uj.isFinished()) {
        this.Jjo.aW((int)fys());
      }
      this.Jjb.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.Jjw);
      k = this.JiO - this.JiP;
      localView = getLeftmostChild();
      if ((localView == null) || (localView.getRight() + k > 0)) {
        break label343;
      }
      j = this.JiR;
      if (!acb(this.Jjg)) {
        break label328;
      }
    }
    label328:
    for (int i = localView.getMeasuredWidth();; i = this.aqb + localView.getMeasuredWidth())
    {
      this.JiR = (i + j);
      n(this.Jjg, localView);
      removeViewInLayout(localView);
      this.Jjg += 1;
      localView = getLeftmostChild();
      break label181;
      if (this.JiP <= this.JiQ) {
        break;
      }
      this.JiP = this.JiQ;
      if (this.Jjp.Uj.isFinished()) {
        this.Jjp.aW((int)fys());
      }
      this.Jjb.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.Jjw);
      break;
    }
    for (;;)
    {
      label343:
      localView = getRightmostChild();
      if ((localView == null) || (localView.getLeft() + k < getWidth())) {
        break;
      }
      n(this.Jjh, localView);
      removeViewInLayout(localView);
      this.Jjh -= 1;
    }
    i = 0;
    View localView = getRightmostChild();
    if (localView != null) {
      i = localView.getRight();
    }
    if ((i + k + this.aqb < getWidth()) && (this.Jjh + 1 < this.GE.getCount()))
    {
      this.Jjh += 1;
      if (this.Jjg < 0) {
        this.Jjg = this.Jjh;
      }
      localView = this.GE.getView(this.Jjh, abZ(this.Jjh), this);
      aB(localView, -1);
      if (this.Jjh == 0) {}
      for (j = 0;; j = this.aqb)
      {
        j = i + (j + localView.getMeasuredWidth());
        i = j;
        if (this.Jjj == null) {
          break;
        }
        i = j;
        if (this.GE == null) {
          break;
        }
        i = j;
        if (this.GE.getCount() - (this.Jjh + 1) >= this.Jjk) {
          break;
        }
        i = j;
        if (this.Jjl) {
          break;
        }
        this.Jjl = true;
        i = j;
        break;
      }
    }
    i = 0;
    localView = getLeftmostChild();
    if (localView != null) {
      i = localView.getLeft();
    }
    if ((i + k - this.aqb > 0) && (this.Jjg > 0))
    {
      this.Jjg -= 1;
      localView = this.GE.getView(this.Jjg, abZ(this.Jjg), this);
      aB(localView, 0);
      if (this.Jjg == 0)
      {
        j = localView.getMeasuredWidth();
        label710:
        j = i - j;
        m = this.JiR;
        if (j + k != 0) {
          break label769;
        }
      }
      label769:
      for (i = localView.getMeasuredWidth();; i = this.aqb + localView.getMeasuredWidth())
      {
        this.JiR = (m - i);
        i = j;
        break;
        j = this.aqb + localView.getMeasuredWidth();
        break label710;
      }
    }
    int m = getChildCount();
    if (m > 0)
    {
      this.JiR += k;
      j = this.JiR;
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
    this.JiO = this.JiP;
    if (acb(this.Jjh))
    {
      localView = getRightmostChild();
      if (localView != null)
      {
        i = this.JiQ;
        j = this.JiO;
        this.JiQ = (localView.getRight() - getPaddingLeft() + j - getRenderWidth());
        if (this.JiQ < 0) {
          this.JiQ = 0;
        }
        if (this.JiQ == i) {}
      }
    }
    for (i = 1; i != 0; i = 0)
    {
      onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(141725);
      return;
    }
    if (this.Jjb.isFinished())
    {
      if (this.Jjn == HorizontalListViewV2.d.a.Jjy)
      {
        setCurrentScrollState(HorizontalListViewV2.d.a.Jjw);
        AppMethodBeat.o(141725);
      }
    }
    else {
      t.b(this, this.Jju);
    }
    AppMethodBeat.o(141725);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141729);
    super.onMeasure(paramInt1, paramInt2);
    this.Jjq = paramInt2;
    AppMethodBeat.o(141729);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(141713);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.Jjf = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
    AppMethodBeat.o(141713);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(141712);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.JiO);
    AppMethodBeat.o(141712);
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141743);
    if (paramMotionEvent.getAction() == 1)
    {
      if ((this.Jjb == null) || (this.Jjb.isFinished())) {
        setCurrentScrollState(HorizontalListViewV2.d.a.Jjw);
      }
      p(Boolean.FALSE);
      fyv();
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141743);
      return bool;
      if (paramMotionEvent.getAction() == 3)
      {
        fyu();
        fyv();
        p(Boolean.FALSE);
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    int i = 0;
    AppMethodBeat.i(141719);
    if (this.GE != null) {
      this.GE.unregisterDataSetObserver(this.Jjt);
    }
    if (paramListAdapter != null)
    {
      this.Jjl = false;
      this.GE = paramListAdapter;
      this.GE.registerDataSetObserver(this.Jjt);
    }
    if (this.GE != null)
    {
      int j = this.GE.getViewTypeCount();
      this.Jjd.clear();
      while (i < j)
      {
        this.Jjd.add(new LinkedList());
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
    this.Jjm = paramd;
  }
  
  public void setSelection(int paramInt)
  {
    this.Jji = paramInt;
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(186462);
      b localb = new b();
      localb.bd(paramMotionEvent);
      a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
      boolean bool = super.onContextClick(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(186462);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(186461);
      b localb = new b();
      localb.bd(paramMotionEvent);
      a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(186461);
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
      boolean bool = HorizontalListViewV2.this.bR(paramFloat1);
      AppMethodBeat.o(141699);
      return bool;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(141702);
      Object localObject = new b();
      ((b)localObject).bd(paramMotionEvent);
      a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, ((b)localObject).ahq());
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
      HorizontalListViewV2.a(HorizontalListViewV2.this, HorizontalListViewV2.d.a.Jjx);
      HorizontalListViewV2.d(HorizontalListViewV2.this);
      paramMotionEvent1 = HorizontalListViewV2.this;
      paramMotionEvent1.JiP += (int)paramFloat1;
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
      AppMethodBeat.i(186460);
      b localb = new b();
      localb.bd(paramMotionEvent);
      a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(186460);
      return bool;
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