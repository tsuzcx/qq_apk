package com.tencent.mm.view.drawer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.InsectFrameLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundColorRes", "getBackgroundColorRes", "()I", "setBackgroundColorRes", "(I)V", "downY", "", "isClickBackground", "", "isEnableClickBackgroundToCloseDrawer", "()Z", "setEnableClickBackgroundToCloseDrawer", "(Z)V", "isIntercept", "setIntercept", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "keyboardHeightObserver", "getKeyboardHeightObserver", "()Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "setKeyboardHeightObserver", "(Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;)V", "lastY", "onOpenDrawerListener", "getOnOpenDrawerListener", "()Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "setOnOpenDrawerListener", "(Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;)V", "rect", "Landroid/graphics/Rect;", "scaledDoubleTapSlop", "squares", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares;", "squaresBackgroundResource", "getSquaresBackgroundResource", "setSquaresBackgroundResource", "topOffset", "getTopOffset", "setTopOffset", "addIgnoreInterceptView", "", "view", "Landroid/view/View;", "canCloseDrawerWhenStop", "can", "closeDrawer", "isWithAnim", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getCenterLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getFooterLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "getLoadingLayout", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "isDrawerOpen", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "openDrawer", "Companion", "libmmui_release"})
public class RecyclerViewDrawer
  extends InsectFrameLayout
  implements RecyclerViewDrawerSquares.c
{
  public static final RecyclerViewDrawer.a LPB;
  private boolean LPA;
  private final RecyclerViewDrawerSquares LPs;
  private boolean LPt;
  private int LPu;
  private int LPv;
  private g LPw;
  private final int LPx;
  private RecyclerViewDrawerSquares.c LPy;
  protected boolean LPz;
  private float aTM;
  private float cNR;
  private final Rect rect;
  private int topOffset;
  
  static
  {
    AppMethodBeat.i(164669);
    LPB = new RecyclerViewDrawer.a((byte)0);
    AppMethodBeat.o(164669);
  }
  
  public RecyclerViewDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164666);
    this.LPs = new RecyclerViewDrawerSquares(getContext());
    this.LPt = true;
    this.topOffset = ((int)getResources().getDimension(2131165287));
    this.LPu = 2131099819;
    this.LPv = 2131101179;
    paramContext = ViewConfiguration.get(getContext());
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.LPx = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.LPu);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.LPs.setBackgroundResource(this.LPv);
    addView((View)this.LPs, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.LPs.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164666);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164667);
    this.LPs = new RecyclerViewDrawerSquares(getContext());
    this.LPt = true;
    this.topOffset = ((int)getResources().getDimension(2131165287));
    this.LPu = 2131099819;
    this.LPv = 2131101179;
    paramContext = ViewConfiguration.get(getContext());
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.LPx = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.LPu);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.LPs.setBackgroundResource(this.LPv);
    addView((View)this.LPs, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.LPs.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164667);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164668);
    this.LPs = new RecyclerViewDrawerSquares(getContext());
    this.LPt = true;
    this.topOffset = ((int)getResources().getDimension(2131165287));
    this.LPu = 2131099819;
    this.LPv = 2131101179;
    paramContext = ViewConfiguration.get(getContext());
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.LPx = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.LPu);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.LPs.setBackgroundResource(this.LPv);
    addView((View)this.LPs, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.LPs.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164668);
  }
  
  public final void P(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(164663);
    new StringBuilder("[onDrawerOpen] isOpen=").append(paramBoolean1).append(" isBegin=").append(paramBoolean2);
    if ((paramBoolean2) && (paramBoolean1)) {
      setVisibility(0);
    }
    for (;;)
    {
      RecyclerViewDrawerSquares.c localc = this.LPy;
      if (localc == null) {
        break;
      }
      localc.P(paramBoolean1, paramBoolean2);
      AppMethodBeat.o(164663);
      return;
      if ((!paramBoolean2) && (!paramBoolean1))
      {
        setVisibility(4);
        getCenterLayout().reset();
      }
    }
    AppMethodBeat.o(164663);
  }
  
  public final void aY(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(193920);
    this.LPs.aY(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(193920);
  }
  
  public final void be(float paramFloat)
  {
    AppMethodBeat.i(164664);
    Object localObject = getBackground();
    if (localObject != null) {
      ((Drawable)localObject).setAlpha((int)(255.0F * (1.0F - paramFloat)));
    }
    localObject = this.LPy;
    if (localObject != null)
    {
      ((RecyclerViewDrawerSquares.c)localObject).be(paramFloat);
      AppMethodBeat.o(164664);
      return;
    }
    AppMethodBeat.o(164664);
  }
  
  public final boolean cPI()
  {
    AppMethodBeat.i(164662);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(164662);
      return true;
    }
    AppMethodBeat.o(164662);
    return false;
  }
  
  public final void cQu()
  {
    AppMethodBeat.i(193921);
    RecyclerViewDrawerSquares.c localc = this.LPy;
    if (localc != null)
    {
      localc.cQu();
      AppMethodBeat.o(193921);
      return;
    }
    AppMethodBeat.o(193921);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164665);
    p.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      this.rect.setEmpty();
      this.LPs.getDrawerHeaderLayout().getGlobalVisibleRect(this.rect);
      this.LPz = this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
      if (this.LPz)
      {
        Rect localRect = new Rect();
        Iterator localIterator = this.LPs.getIgnoreInterceptViewList().iterator();
        if (localIterator.hasNext())
        {
          ((View)localIterator.next()).getGlobalVisibleRect(localRect);
          if (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
            break label370;
          }
        }
      }
    }
    label370:
    for (boolean bool = true;; bool = false)
    {
      this.LPz = bool;
      if (this.LPz) {
        break;
      }
      this.aTM = paramMotionEvent.getRawY();
      this.cNR = this.aTM;
      if ((!this.LPz) && (this.LPt))
      {
        this.LPs.getGlobalVisibleRect(this.rect);
        if (!this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
          this.LPA = true;
        }
      }
      if (this.LPz)
      {
        this.LPs.r((int)(this.aTM - paramMotionEvent.getRawY()), 0, true);
        this.aTM = paramMotionEvent.getRawY();
      }
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        if (this.LPz) {
          this.LPs.cDB();
        }
        this.LPz = false;
        if ((this.LPA) && (this.LPt) && (paramMotionEvent.getAction() == 1) && (Math.abs(this.cNR - paramMotionEvent.getRawY()) <= this.LPx)) {
          RecyclerViewDrawerSquares.a(this.LPs);
        }
        this.LPA = false;
      }
      if ((!this.LPz) && (!this.LPA) && (!super.dispatchTouchEvent(paramMotionEvent))) {
        break label375;
      }
      AppMethodBeat.o(164665);
      return true;
    }
    label375:
    AppMethodBeat.o(164665);
    return false;
  }
  
  public final void fUI()
  {
    AppMethodBeat.i(164660);
    this.LPs.setCanCloseDrawerWhenStop(true);
    AppMethodBeat.o(164660);
  }
  
  public final int getBackgroundColorRes()
  {
    return this.LPu;
  }
  
  public final RefreshLoadMoreLayout getCenterLayout()
  {
    AppMethodBeat.i(164655);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.LPs.getCenterLayout();
    AppMethodBeat.o(164655);
    return localRefreshLoadMoreLayout;
  }
  
  public final FrameLayout getFooterLayout()
  {
    AppMethodBeat.i(164656);
    FrameLayout localFrameLayout = this.LPs.getDrawerFooterLayout();
    AppMethodBeat.o(164656);
    return localFrameLayout;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(164657);
    FrameLayout localFrameLayout = this.LPs.getDrawerHeaderLayout();
    AppMethodBeat.o(164657);
    return localFrameLayout;
  }
  
  public final g getKeyboardHeightObserver()
  {
    return this.LPw;
  }
  
  public final FrameLayout getLoadingLayout()
  {
    AppMethodBeat.i(164658);
    FrameLayout localFrameLayout = this.LPs.getLoadingLayout();
    AppMethodBeat.o(164658);
    return localFrameLayout;
  }
  
  public final RecyclerViewDrawerSquares.c getOnOpenDrawerListener()
  {
    return this.LPy;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(164654);
    RecyclerView localRecyclerView = this.LPs.getCenterLayout().getRecyclerView();
    AppMethodBeat.o(164654);
    return localRecyclerView;
  }
  
  public final int getSquaresBackgroundResource()
  {
    return this.LPv;
  }
  
  public final int getTopOffset()
  {
    return this.topOffset;
  }
  
  public final void hp(View paramView)
  {
    AppMethodBeat.i(193919);
    p.h(paramView, "view");
    if (!this.LPs.getIgnoreInterceptViewList().contains(paramView)) {
      this.LPs.getIgnoreInterceptViewList().add(paramView);
    }
    AppMethodBeat.o(193919);
  }
  
  public final void setBackgroundColorRes(int paramInt)
  {
    AppMethodBeat.i(164651);
    this.LPu = paramInt;
    setBackgroundResource(paramInt);
    AppMethodBeat.o(164651);
  }
  
  public final void setEnableClickBackgroundToCloseDrawer(boolean paramBoolean)
  {
    this.LPt = paramBoolean;
  }
  
  protected final void setIntercept(boolean paramBoolean)
  {
    this.LPz = paramBoolean;
  }
  
  public final void setKeyboardHeightObserver(g paramg)
  {
    AppMethodBeat.i(164653);
    this.LPw = paramg;
    this.LPs.setKeyboardHeightObserver(this.LPw);
    AppMethodBeat.o(164653);
  }
  
  public final void setOnOpenDrawerListener(RecyclerViewDrawerSquares.c paramc)
  {
    this.LPy = paramc;
  }
  
  public final void setSquaresBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(164652);
    this.LPv = paramInt;
    this.LPs.setBackgroundResource(paramInt);
    AppMethodBeat.o(164652);
  }
  
  public final void setTopOffset(int paramInt)
  {
    AppMethodBeat.i(164650);
    this.topOffset = paramInt;
    setPadding(0, this.topOffset, 0, 0);
    AppMethodBeat.o(164650);
  }
  
  public final void zw(boolean paramBoolean)
  {
    AppMethodBeat.i(164661);
    this.LPs.zw(paramBoolean);
    AppMethodBeat.o(164661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.drawer.RecyclerViewDrawer
 * JD-Core Version:    0.7.0.1
 */