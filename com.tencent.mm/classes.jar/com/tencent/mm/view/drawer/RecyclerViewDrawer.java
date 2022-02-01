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
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundColorRes", "getBackgroundColorRes", "()I", "setBackgroundColorRes", "(I)V", "downY", "", "isClickBackground", "", "isEnableClickBackgroundToCloseDrawer", "()Z", "setEnableClickBackgroundToCloseDrawer", "(Z)V", "isIntercept", "setIntercept", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "keyboardHeightObserver", "getKeyboardHeightObserver", "()Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "setKeyboardHeightObserver", "(Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;)V", "lastY", "onOpenDrawerListener", "getOnOpenDrawerListener", "()Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "setOnOpenDrawerListener", "(Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;)V", "rect", "Landroid/graphics/Rect;", "scaledDoubleTapSlop", "squares", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares;", "squaresBackgroundResource", "getSquaresBackgroundResource", "setSquaresBackgroundResource", "topOffset", "getTopOffset", "setTopOffset", "addIgnoreInterceptView", "", "view", "Landroid/view/View;", "canCloseDrawerWhenStop", "can", "closeDrawer", "isWithAnim", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getCenterLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getFooterLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "getLoadingLayout", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "isDrawerOpen", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "openDrawer", "Companion", "libmmui_release"})
public class RecyclerViewDrawer
  extends InsectFrameLayout
  implements RecyclerViewDrawerSquares.c
{
  public static final RecyclerViewDrawer.a JzH;
  private int JzA;
  private int JzB;
  private g JzC;
  private final int JzD;
  private RecyclerViewDrawerSquares.c JzE;
  protected boolean JzF;
  private boolean JzG;
  private final RecyclerViewDrawerSquares Jzy;
  private boolean Jzz;
  private float cCi;
  private final Rect rect;
  private float tmJ;
  private int topOffset;
  
  static
  {
    AppMethodBeat.i(164669);
    JzH = new RecyclerViewDrawer.a((byte)0);
    AppMethodBeat.o(164669);
  }
  
  public RecyclerViewDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164666);
    this.Jzy = new RecyclerViewDrawerSquares(getContext());
    this.Jzz = true;
    this.topOffset = ((int)getResources().getDimension(2131165287));
    this.JzA = 2131099819;
    this.JzB = 2131101179;
    paramContext = ViewConfiguration.get(getContext());
    k.g(paramContext, "ViewConfiguration.get(context)");
    this.JzD = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.JzA);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.Jzy.setBackgroundResource(this.JzB);
    addView((View)this.Jzy, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.Jzy.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164666);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164667);
    this.Jzy = new RecyclerViewDrawerSquares(getContext());
    this.Jzz = true;
    this.topOffset = ((int)getResources().getDimension(2131165287));
    this.JzA = 2131099819;
    this.JzB = 2131101179;
    paramContext = ViewConfiguration.get(getContext());
    k.g(paramContext, "ViewConfiguration.get(context)");
    this.JzD = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.JzA);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.Jzy.setBackgroundResource(this.JzB);
    addView((View)this.Jzy, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.Jzy.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164667);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164668);
    this.Jzy = new RecyclerViewDrawerSquares(getContext());
    this.Jzz = true;
    this.topOffset = ((int)getResources().getDimension(2131165287));
    this.JzA = 2131099819;
    this.JzB = 2131101179;
    paramContext = ViewConfiguration.get(getContext());
    k.g(paramContext, "ViewConfiguration.get(context)");
    this.JzD = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.JzA);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.Jzy.setBackgroundResource(this.JzB);
    addView((View)this.Jzy, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.Jzy.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164668);
  }
  
  public final void O(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(164663);
    new StringBuilder("[onDrawerOpen] isOpen=").append(paramBoolean1).append(" isBegin=").append(paramBoolean2);
    if ((paramBoolean2) && (paramBoolean1)) {
      setVisibility(0);
    }
    for (;;)
    {
      RecyclerViewDrawerSquares.c localc = this.JzE;
      if (localc == null) {
        break;
      }
      localc.O(paramBoolean1, paramBoolean2);
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
  
  public final void aR(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(197333);
    this.Jzy.aR(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(197333);
  }
  
  public final void bb(float paramFloat)
  {
    AppMethodBeat.i(164664);
    Object localObject = getBackground();
    if (localObject != null) {
      ((Drawable)localObject).setAlpha((int)(255.0F * (1.0F - paramFloat)));
    }
    localObject = this.JzE;
    if (localObject != null)
    {
      ((RecyclerViewDrawerSquares.c)localObject).bb(paramFloat);
      AppMethodBeat.o(164664);
      return;
    }
    AppMethodBeat.o(164664);
  }
  
  public final boolean cEG()
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
  
  public final void cMT()
  {
    AppMethodBeat.i(210329);
    RecyclerViewDrawerSquares.c localc = this.JzE;
    if (localc != null)
    {
      localc.cMT();
      AppMethodBeat.o(210329);
      return;
    }
    AppMethodBeat.o(210329);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164665);
    k.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      this.rect.setEmpty();
      this.Jzy.getDrawerHeaderLayout().getGlobalVisibleRect(this.rect);
      this.JzF = this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
      if (this.JzF)
      {
        Rect localRect = new Rect();
        Iterator localIterator = this.Jzy.getIgnoreInterceptViewList().iterator();
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
      this.JzF = bool;
      if (this.JzF) {
        break;
      }
      this.tmJ = paramMotionEvent.getRawY();
      this.cCi = this.tmJ;
      if ((!this.JzF) && (this.Jzz))
      {
        this.Jzy.getGlobalVisibleRect(this.rect);
        if (!this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
          this.JzG = true;
        }
      }
      if (this.JzF)
      {
        this.Jzy.r((int)(this.tmJ - paramMotionEvent.getRawY()), 0, true);
        this.tmJ = paramMotionEvent.getRawY();
      }
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        if (this.JzF) {
          this.Jzy.cvv();
        }
        this.JzF = false;
        if ((this.JzG) && (this.Jzz) && (paramMotionEvent.getAction() == 1) && (Math.abs(this.cCi - paramMotionEvent.getRawY()) <= this.JzD)) {
          RecyclerViewDrawerSquares.a(this.Jzy);
        }
        this.JzG = false;
      }
      if ((!this.JzF) && (!this.JzG) && (!super.dispatchTouchEvent(paramMotionEvent))) {
        break label375;
      }
      AppMethodBeat.o(164665);
      return true;
    }
    label375:
    AppMethodBeat.o(164665);
    return false;
  }
  
  public final void fzd()
  {
    AppMethodBeat.i(164660);
    this.Jzy.setCanCloseDrawerWhenStop(true);
    AppMethodBeat.o(164660);
  }
  
  public final void gT(View paramView)
  {
    AppMethodBeat.i(197332);
    k.h(paramView, "view");
    if (!this.Jzy.getIgnoreInterceptViewList().contains(paramView)) {
      this.Jzy.getIgnoreInterceptViewList().add(paramView);
    }
    AppMethodBeat.o(197332);
  }
  
  public final int getBackgroundColorRes()
  {
    return this.JzA;
  }
  
  public final RefreshLoadMoreLayout getCenterLayout()
  {
    AppMethodBeat.i(164655);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.Jzy.getCenterLayout();
    AppMethodBeat.o(164655);
    return localRefreshLoadMoreLayout;
  }
  
  public final FrameLayout getFooterLayout()
  {
    AppMethodBeat.i(164656);
    FrameLayout localFrameLayout = this.Jzy.getDrawerFooterLayout();
    AppMethodBeat.o(164656);
    return localFrameLayout;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(164657);
    FrameLayout localFrameLayout = this.Jzy.getDrawerHeaderLayout();
    AppMethodBeat.o(164657);
    return localFrameLayout;
  }
  
  public final g getKeyboardHeightObserver()
  {
    return this.JzC;
  }
  
  public final FrameLayout getLoadingLayout()
  {
    AppMethodBeat.i(164658);
    FrameLayout localFrameLayout = this.Jzy.getLoadingLayout();
    AppMethodBeat.o(164658);
    return localFrameLayout;
  }
  
  public final RecyclerViewDrawerSquares.c getOnOpenDrawerListener()
  {
    return this.JzE;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(164654);
    RecyclerView localRecyclerView = this.Jzy.getCenterLayout().getRecyclerView();
    AppMethodBeat.o(164654);
    return localRecyclerView;
  }
  
  public final int getSquaresBackgroundResource()
  {
    return this.JzB;
  }
  
  public final int getTopOffset()
  {
    return this.topOffset;
  }
  
  public final void setBackgroundColorRes(int paramInt)
  {
    AppMethodBeat.i(164651);
    this.JzA = paramInt;
    setBackgroundResource(paramInt);
    AppMethodBeat.o(164651);
  }
  
  public final void setEnableClickBackgroundToCloseDrawer(boolean paramBoolean)
  {
    this.Jzz = paramBoolean;
  }
  
  protected final void setIntercept(boolean paramBoolean)
  {
    this.JzF = paramBoolean;
  }
  
  public final void setKeyboardHeightObserver(g paramg)
  {
    AppMethodBeat.i(164653);
    this.JzC = paramg;
    this.Jzy.setKeyboardHeightObserver(this.JzC);
    AppMethodBeat.o(164653);
  }
  
  public final void setOnOpenDrawerListener(RecyclerViewDrawerSquares.c paramc)
  {
    this.JzE = paramc;
  }
  
  public final void setSquaresBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(164652);
    this.JzB = paramInt;
    this.Jzy.setBackgroundResource(paramInt);
    AppMethodBeat.o(164652);
  }
  
  public final void setTopOffset(int paramInt)
  {
    AppMethodBeat.i(164650);
    this.topOffset = paramInt;
    setPadding(0, this.topOffset, 0, 0);
    AppMethodBeat.o(164650);
  }
  
  public final void yv(boolean paramBoolean)
  {
    AppMethodBeat.i(164661);
    this.Jzy.yv(paramBoolean);
    AppMethodBeat.o(164661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.drawer.RecyclerViewDrawer
 * JD-Core Version:    0.7.0.1
 */