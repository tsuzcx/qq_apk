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
import androidx.core.g.w;
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
  protected int WhB;
  protected int WhC;
  private int WhD;
  private int WhE;
  private boolean WhJ;
  protected Scroller WhO;
  private final a WhP;
  private List<Queue<View>> WhQ;
  private View WhR;
  private Integer WhS;
  private int WhT;
  private int WhU;
  private int WhV;
  private e WhW;
  private int WhX;
  private boolean WhY;
  private d WhZ;
  private HorizontalListViewV2.d.a Wia;
  private d Wib;
  private d Wic;
  private int Wid;
  private boolean Wie;
  private boolean Wif;
  private DataSetObserver Wig;
  private Runnable Wih;
  protected ListAdapter eP;
  private View.OnClickListener mOnClickListener;
  private Rect mRect;
  private GestureDetector pCU;
  private Drawable sQ;
  private int sR;
  
  public HorizontalListViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141710);
    this.WhO = new Scroller(getContext());
    this.WhP = new a((byte)0);
    this.WhQ = new ArrayList();
    this.WhJ = false;
    this.mRect = new Rect();
    this.WhR = null;
    this.sR = 0;
    this.sQ = null;
    this.WhS = null;
    this.WhD = 2147483647;
    this.WhW = null;
    this.WhX = 0;
    this.WhY = false;
    this.WhZ = null;
    this.Wia = HorizontalListViewV2.d.a.Wij;
    this.Wie = false;
    this.Wif = false;
    this.Wig = new DataSetObserver()
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
    this.Wih = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(141697);
        HorizontalListViewV2.this.requestLayout();
        AppMethodBeat.o(141697);
      }
    };
    this.Wib = new d(paramContext);
    this.Wic = new d(paramContext);
    this.pCU = new GestureDetector(paramContext, this.WhP);
    setOnTouchListener(new HorizontalListViewV2.1(this));
    initView();
    setWillNotDraw(false);
    if (Build.VERSION.SDK_INT >= 11) {
      HorizontalListViewV2.b.a(this.WhO);
    }
    AppMethodBeat.o(141710);
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    AppMethodBeat.i(141737);
    if (this.sQ != null)
    {
      this.sQ.setBounds(paramRect);
      this.sQ.draw(paramCanvas);
    }
    AppMethodBeat.o(141737);
  }
  
  private void aL(View paramView, int paramInt)
  {
    AppMethodBeat.i(141723);
    addViewInLayout(paramView, paramInt, hH(paramView), true);
    ViewGroup.LayoutParams localLayoutParams = hH(paramView);
    int i = ViewGroup.getChildMeasureSpec(this.Wid, getPaddingTop() + getPaddingBottom(), localLayoutParams.height);
    if (localLayoutParams.width > 0) {}
    for (paramInt = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);; paramInt = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(paramInt, i);
      AppMethodBeat.o(141723);
      return;
    }
  }
  
  private View auo(int paramInt)
  {
    AppMethodBeat.i(141720);
    paramInt = this.eP.getItemViewType(paramInt);
    if (aup(paramInt))
    {
      View localView = (View)((Queue)this.WhQ.get(paramInt)).poll();
      AppMethodBeat.o(141720);
      return localView;
    }
    AppMethodBeat.o(141720);
    return null;
  }
  
  private boolean aup(int paramInt)
  {
    AppMethodBeat.i(141722);
    if (paramInt < this.WhQ.size())
    {
      AppMethodBeat.o(141722);
      return true;
    }
    AppMethodBeat.o(141722);
    return false;
  }
  
  private boolean auq(int paramInt)
  {
    AppMethodBeat.i(141733);
    if (paramInt == this.eP.getCount() - 1)
    {
      AppMethodBeat.o(141733);
      return true;
    }
    AppMethodBeat.o(141733);
    return false;
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
  
  private static ViewGroup.LayoutParams hH(View paramView)
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
  
  private float hJr()
  {
    AppMethodBeat.i(141728);
    if (Build.VERSION.SDK_INT >= 14)
    {
      float f = HorizontalListViewV2.c.b(this.WhO);
      AppMethodBeat.o(141728);
      return f;
    }
    AppMethodBeat.o(141728);
    return 30.0F;
  }
  
  private void hJt()
  {
    AppMethodBeat.i(141742);
    if (this.WhR != null)
    {
      this.WhR.setPressed(false);
      refreshDrawableState();
      this.WhR = null;
    }
    AppMethodBeat.o(141742);
  }
  
  private void hJu()
  {
    AppMethodBeat.i(141744);
    if (this.Wib != null) {
      this.Wib.hD();
    }
    if (this.Wic != null) {
      this.Wic.hD();
    }
    AppMethodBeat.o(141744);
  }
  
  private void initView()
  {
    AppMethodBeat.i(141716);
    this.WhT = -1;
    this.WhU = -1;
    this.WhE = 0;
    this.WhB = 0;
    this.WhC = 0;
    this.WhD = 2147483647;
    setCurrentScrollState(HorizontalListViewV2.d.a.Wij);
    AppMethodBeat.o(141716);
  }
  
  private int mk(int paramInt1, int paramInt2)
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
  
  private void s(int paramInt, View paramView)
  {
    AppMethodBeat.i(141721);
    paramInt = this.eP.getItemViewType(paramInt);
    if (aup(paramInt)) {
      ((Queue)this.WhQ.get(paramInt)).offer(paramView);
    }
    AppMethodBeat.o(141721);
  }
  
  private void setCurrentScrollState(HorizontalListViewV2.d.a parama)
  {
    AppMethodBeat.i(141745);
    if ((this.Wia != parama) && (this.WhZ != null)) {
      this.WhZ.a(parama);
    }
    this.Wia = parama;
    AppMethodBeat.o(141745);
  }
  
  private void y(Boolean paramBoolean)
  {
    AppMethodBeat.i(141711);
    if (this.Wif != paramBoolean.booleanValue()) {
      for (Object localObject = this; (((View)localObject).getParent() instanceof View); localObject = (View)((View)localObject).getParent()) {
        if (((((View)localObject).getParent() instanceof ListView)) || ((((View)localObject).getParent() instanceof ScrollView)))
        {
          ((View)localObject).getParent().requestDisallowInterceptTouchEvent(paramBoolean.booleanValue());
          this.Wif = paramBoolean.booleanValue();
          AppMethodBeat.o(141711);
          return;
        }
      }
    }
    AppMethodBeat.o(141711);
  }
  
  protected final boolean cJ(float paramFloat)
  {
    AppMethodBeat.i(141740);
    this.WhO.fling(this.WhC, 0, (int)-paramFloat, 0, 0, this.WhD, 0, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.Wil);
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
    return this.eP;
  }
  
  public int getFirstVisiblePosition()
  {
    return this.WhT;
  }
  
  public int getLastVisiblePosition()
  {
    return this.WhU;
  }
  
  protected float getLeftFadingEdgeStrength()
  {
    AppMethodBeat.i(141726);
    int i = getHorizontalFadingEdgeLength();
    if (this.WhB == 0)
    {
      AppMethodBeat.o(141726);
      return 0.0F;
    }
    if (this.WhB < i)
    {
      float f = this.WhB / i;
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
    if (this.WhB == this.WhD)
    {
      AppMethodBeat.o(141727);
      return 0.0F;
    }
    if (this.WhD - this.WhB < i)
    {
      float f = (this.WhD - this.WhB) / i;
      AppMethodBeat.o(141727);
      return f;
    }
    AppMethodBeat.o(141727);
    return 1.0F;
  }
  
  public View getSelectedView()
  {
    AppMethodBeat.i(141718);
    int i = this.WhV;
    if ((i >= this.WhT) && (i <= this.WhU))
    {
      View localView = getChildAt(i - this.WhT);
      AppMethodBeat.o(141718);
      return localView;
    }
    AppMethodBeat.o(141718);
    return null;
  }
  
  public final void hJs()
  {
    AppMethodBeat.i(141736);
    this.WhO.startScroll(this.WhC, 0, 0 - this.WhC, 0);
    setCurrentScrollState(HorizontalListViewV2.d.a.Wil);
    requestLayout();
    AppMethodBeat.o(141736);
  }
  
  protected final boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141741);
    if (!this.WhO.isFinished()) {}
    for (boolean bool = true;; bool = false)
    {
      this.Wie = bool;
      this.WhO.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.Wij);
      hJt();
      if (!this.Wie)
      {
        int i = mk((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
        if (i >= 0)
        {
          this.WhR = getChildAt(i);
          if (this.WhR != null)
          {
            this.WhR.setPressed(true);
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
      if ((i != j - 1) || (!auq(this.WhU)))
      {
        View localView = getChildAt(i);
        localRect.left = localView.getRight();
        localRect.right = (localView.getRight() + this.sR);
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
    if (this.eP == null)
    {
      AppMethodBeat.o(141725);
      return;
    }
    invalidate();
    if (this.WhJ)
    {
      i = this.WhB;
      initView();
      removeAllViewsInLayout();
      this.WhC = i;
      this.WhJ = false;
    }
    if (this.WhS != null)
    {
      this.WhC = this.WhS.intValue();
      this.WhS = null;
    }
    if (this.WhO.computeScrollOffset()) {
      this.WhC = this.WhO.getCurrX();
    }
    int k;
    label181:
    int j;
    if (this.WhC < 0)
    {
      this.WhC = 0;
      if (this.Wib.Qf.isFinished()) {
        this.Wib.bJ((int)hJr());
      }
      this.WhO.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.Wij);
      k = this.WhB - this.WhC;
      localView = getLeftmostChild();
      if ((localView == null) || (localView.getRight() + k > 0)) {
        break label343;
      }
      j = this.WhE;
      if (!auq(this.WhT)) {
        break label328;
      }
    }
    label328:
    for (int i = localView.getMeasuredWidth();; i = this.sR + localView.getMeasuredWidth())
    {
      this.WhE = (i + j);
      s(this.WhT, localView);
      removeViewInLayout(localView);
      this.WhT += 1;
      localView = getLeftmostChild();
      break label181;
      if (this.WhC <= this.WhD) {
        break;
      }
      this.WhC = this.WhD;
      if (this.Wic.Qf.isFinished()) {
        this.Wic.bJ((int)hJr());
      }
      this.WhO.forceFinished(true);
      setCurrentScrollState(HorizontalListViewV2.d.a.Wij);
      break;
    }
    for (;;)
    {
      label343:
      localView = getRightmostChild();
      if ((localView == null) || (localView.getLeft() + k < getWidth())) {
        break;
      }
      s(this.WhU, localView);
      removeViewInLayout(localView);
      this.WhU -= 1;
    }
    i = 0;
    View localView = getRightmostChild();
    if (localView != null) {
      i = localView.getRight();
    }
    if ((i + k + this.sR < getWidth()) && (this.WhU + 1 < this.eP.getCount()))
    {
      this.WhU += 1;
      if (this.WhT < 0) {
        this.WhT = this.WhU;
      }
      localView = this.eP.getView(this.WhU, auo(this.WhU), this);
      aL(localView, -1);
      if (this.WhU == 0) {}
      for (j = 0;; j = this.sR)
      {
        j = i + (j + localView.getMeasuredWidth());
        i = j;
        if (this.WhW == null) {
          break;
        }
        i = j;
        if (this.eP == null) {
          break;
        }
        i = j;
        if (this.eP.getCount() - (this.WhU + 1) >= this.WhX) {
          break;
        }
        i = j;
        if (this.WhY) {
          break;
        }
        this.WhY = true;
        i = j;
        break;
      }
    }
    i = 0;
    localView = getLeftmostChild();
    if (localView != null) {
      i = localView.getLeft();
    }
    if ((i + k - this.sR > 0) && (this.WhT > 0))
    {
      this.WhT -= 1;
      localView = this.eP.getView(this.WhT, auo(this.WhT), this);
      aL(localView, 0);
      if (this.WhT == 0)
      {
        j = localView.getMeasuredWidth();
        label710:
        j = i - j;
        m = this.WhE;
        if (j + k != 0) {
          break label769;
        }
      }
      label769:
      for (i = localView.getMeasuredWidth();; i = this.sR + localView.getMeasuredWidth())
      {
        this.WhE = (m - i);
        i = j;
        break;
        j = this.sR + localView.getMeasuredWidth();
        break label710;
      }
    }
    int m = getChildCount();
    if (m > 0)
    {
      this.WhE += k;
      j = this.WhE;
      i = 0;
      while (i < m)
      {
        localView = getChildAt(i);
        k = getPaddingLeft() + j;
        int n = getPaddingTop();
        localView.layout(k, n, localView.getMeasuredWidth() + k, localView.getMeasuredHeight() + n);
        j += localView.getMeasuredWidth() + this.sR;
        i += 1;
      }
    }
    this.WhB = this.WhC;
    if (auq(this.WhU))
    {
      localView = getRightmostChild();
      if (localView != null)
      {
        i = this.WhD;
        j = this.WhB;
        this.WhD = (localView.getRight() - getPaddingLeft() + j - getRenderWidth());
        if (this.WhD < 0) {
          this.WhD = 0;
        }
        if (this.WhD == i) {}
      }
    }
    for (i = 1; i != 0; i = 0)
    {
      onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(141725);
      return;
    }
    if (this.WhO.isFinished())
    {
      if (this.Wia == HorizontalListViewV2.d.a.Wil)
      {
        setCurrentScrollState(HorizontalListViewV2.d.a.Wij);
        AppMethodBeat.o(141725);
      }
    }
    else {
      w.a(this, this.Wih);
    }
    AppMethodBeat.o(141725);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141729);
    super.onMeasure(paramInt1, paramInt2);
    this.Wid = paramInt2;
    AppMethodBeat.o(141729);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(141713);
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      this.WhS = Integer.valueOf(paramParcelable.getInt("BUNDLE_ID_CURRENT_X"));
      super.onRestoreInstanceState(paramParcelable.getParcelable("BUNDLE_ID_PARENT_STATE"));
    }
    AppMethodBeat.o(141713);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(141712);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
    localBundle.putInt("BUNDLE_ID_CURRENT_X", this.WhB);
    AppMethodBeat.o(141712);
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141743);
    if (paramMotionEvent.getAction() == 1)
    {
      if ((this.WhO == null) || (this.WhO.isFinished())) {
        setCurrentScrollState(HorizontalListViewV2.d.a.Wij);
      }
      y(Boolean.FALSE);
      hJu();
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141743);
      return bool;
      if (paramMotionEvent.getAction() == 3)
      {
        hJt();
        hJu();
        y(Boolean.FALSE);
      }
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    int i = 0;
    AppMethodBeat.i(141719);
    if (this.eP != null) {
      this.eP.unregisterDataSetObserver(this.Wig);
    }
    if (paramListAdapter != null)
    {
      this.WhY = false;
      this.eP = paramListAdapter;
      this.eP.registerDataSetObserver(this.Wig);
    }
    if (this.eP != null)
    {
      int j = this.eP.getViewTypeCount();
      this.WhQ.clear();
      while (i < j)
      {
        this.WhQ.add(new LinkedList());
        i += 1;
      }
    }
    reset();
    AppMethodBeat.o(141719);
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    AppMethodBeat.i(141714);
    this.sQ = paramDrawable;
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
    this.sR = paramInt;
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
    this.WhZ = paramd;
  }
  
  public void setSelection(int paramInt)
  {
    this.WhV = paramInt;
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(223145);
      b localb = new b();
      localb.bn(paramMotionEvent);
      a.c("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
      boolean bool = super.onContextClick(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(223145);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(223142);
      b localb = new b();
      localb.bn(paramMotionEvent);
      a.c("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(223142);
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
      boolean bool = HorizontalListViewV2.this.cJ(paramFloat1);
      AppMethodBeat.o(141699);
      return bool;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(141702);
      Object localObject = new b();
      ((b)localObject).bn(paramMotionEvent);
      a.c("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, ((b)localObject).aFi());
      HorizontalListViewV2.d(HorizontalListViewV2.this);
      int i = HorizontalListViewV2.a(HorizontalListViewV2.this, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if ((i >= 0) && (!HorizontalListViewV2.f(HorizontalListViewV2.this)))
      {
        paramMotionEvent = HorizontalListViewV2.this.getChildAt(i);
        localObject = HorizontalListViewV2.this.getOnItemLongClickListener();
        if (localObject != null)
        {
          i = HorizontalListViewV2.g(HorizontalListViewV2.this) + i;
          if (((AdapterView.OnItemLongClickListener)localObject).onItemLongClick(HorizontalListViewV2.this, paramMotionEvent, i, HorizontalListViewV2.this.eP.getItemId(i))) {
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
      HorizontalListViewV2.a(HorizontalListViewV2.this, HorizontalListViewV2.d.a.Wik);
      HorizontalListViewV2.d(HorizontalListViewV2.this);
      paramMotionEvent1 = HorizontalListViewV2.this;
      paramMotionEvent1.WhC += (int)paramFloat1;
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
          localOnItemClickListener.onItemClick(HorizontalListViewV2.this, paramMotionEvent, i, HorizontalListViewV2.this.eP.getItemId(i));
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
      AppMethodBeat.i(223140);
      b localb = new b();
      localb.bn(paramMotionEvent);
      a.c("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      a.a(bool, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(223140);
      return bool;
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(HorizontalListViewV2.d.a parama);
  }
  
  public static abstract interface e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.HorizontalListViewV2
 * JD-Core Version:    0.7.0.1
 */