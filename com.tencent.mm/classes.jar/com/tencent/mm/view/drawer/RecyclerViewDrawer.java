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
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundColorRes", "getBackgroundColorRes", "()I", "setBackgroundColorRes", "(I)V", "downY", "", "isClickBackground", "", "isEnableClickBackgroundToCloseDrawer", "()Z", "setEnableClickBackgroundToCloseDrawer", "(Z)V", "isIntercept", "setIntercept", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "keyboardHeightObserver", "getKeyboardHeightObserver", "()Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "setKeyboardHeightObserver", "(Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;)V", "lastY", "onOpenDrawerListener", "getOnOpenDrawerListener", "()Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "setOnOpenDrawerListener", "(Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;)V", "rect", "Landroid/graphics/Rect;", "scaledDoubleTapSlop", "squares", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares;", "squaresBackgroundResource", "getSquaresBackgroundResource", "setSquaresBackgroundResource", "topOffset", "getTopOffset", "setTopOffset", "addIgnoreInterceptView", "", "view", "Landroid/view/View;", "canCloseDrawerWhenStop", "can", "closeDrawer", "isWithAnim", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getCenterLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getFooterLayout", "getHeaderLayout", "getLoadingLayout", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "isDrawerOpen", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "openDrawer", "Companion", "libmmui_release"})
public class RecyclerViewDrawer
  extends FrameLayout
  implements RecyclerViewDrawerSquares.c
{
  public static final a HYT;
  private final RecyclerViewDrawerSquares HYK;
  private boolean HYL;
  private int HYM;
  private int HYN;
  private g HYO;
  private final int HYP;
  private RecyclerViewDrawerSquares.c HYQ;
  protected boolean HYR;
  private boolean HYS;
  private float cFa;
  private final Rect rect;
  private float seQ;
  private int topOffset;
  
  static
  {
    AppMethodBeat.i(164669);
    HYT = new a((byte)0);
    AppMethodBeat.o(164669);
  }
  
  public RecyclerViewDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164666);
    this.HYK = new RecyclerViewDrawerSquares(getContext());
    this.HYL = true;
    this.topOffset = ((int)getResources().getDimension(2131165287));
    this.HYM = 2131099819;
    this.HYN = 2131101179;
    paramContext = ViewConfiguration.get(getContext());
    k.g(paramContext, "ViewConfiguration.get(context)");
    this.HYP = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.HYM);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.HYK.setBackgroundResource(this.HYN);
    addView((View)this.HYK, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.HYK.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164666);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164667);
    this.HYK = new RecyclerViewDrawerSquares(getContext());
    this.HYL = true;
    this.topOffset = ((int)getResources().getDimension(2131165287));
    this.HYM = 2131099819;
    this.HYN = 2131101179;
    paramContext = ViewConfiguration.get(getContext());
    k.g(paramContext, "ViewConfiguration.get(context)");
    this.HYP = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.HYM);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.HYK.setBackgroundResource(this.HYN);
    addView((View)this.HYK, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.HYK.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164667);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164668);
    this.HYK = new RecyclerViewDrawerSquares(getContext());
    this.HYL = true;
    this.topOffset = ((int)getResources().getDimension(2131165287));
    this.HYM = 2131099819;
    this.HYN = 2131101179;
    paramContext = ViewConfiguration.get(getContext());
    k.g(paramContext, "ViewConfiguration.get(context)");
    this.HYP = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.HYM);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.HYK.setBackgroundResource(this.HYN);
    addView((View)this.HYK, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.HYK.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164668);
  }
  
  public final void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(164663);
    new StringBuilder("[onDrawerOpen] isOpen=").append(paramBoolean1).append(" isBegin=").append(paramBoolean2);
    if ((paramBoolean2) && (paramBoolean1)) {
      setVisibility(0);
    }
    for (;;)
    {
      RecyclerViewDrawerSquares.c localc = this.HYQ;
      if (localc == null) {
        break;
      }
      localc.L(paramBoolean1, paramBoolean2);
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
  
  public final void aU(float paramFloat)
  {
    AppMethodBeat.i(164664);
    Object localObject = getBackground();
    if (localObject != null) {
      ((Drawable)localObject).setAlpha((int)(255.0F * (1.0F - paramFloat)));
    }
    localObject = this.HYQ;
    if (localObject != null)
    {
      ((RecyclerViewDrawerSquares.c)localObject).aU(paramFloat);
      AppMethodBeat.o(164664);
      return;
    }
    AppMethodBeat.o(164664);
  }
  
  public final void aX(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(203977);
    this.HYK.aX(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(203977);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164665);
    k.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      this.rect.setEmpty();
      this.HYK.getDrawerHeaderLayout().getGlobalVisibleRect(this.rect);
      this.HYR = this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
      if (this.HYR)
      {
        Rect localRect = new Rect();
        Iterator localIterator = this.HYK.getIgnoreInterceptViewList().iterator();
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
      this.HYR = bool;
      if (this.HYR) {
        break;
      }
      this.seQ = paramMotionEvent.getRawY();
      this.cFa = this.seQ;
      if ((!this.HYR) && (this.HYL))
      {
        this.HYK.getGlobalVisibleRect(this.rect);
        if (!this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
          this.HYS = true;
        }
      }
      if (this.HYR)
      {
        this.HYK.r((int)(this.seQ - paramMotionEvent.getRawY()), 0, true);
        this.seQ = paramMotionEvent.getRawY();
      }
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        if (this.HYR) {
          this.HYK.cms();
        }
        this.HYR = false;
        if ((this.HYS) && (this.HYL) && (paramMotionEvent.getAction() == 1) && (Math.abs(this.cFa - paramMotionEvent.getRawY()) <= this.HYP)) {
          RecyclerViewDrawerSquares.a(this.HYK);
        }
        this.HYS = false;
      }
      if ((!this.HYR) && (!this.HYS) && (!super.dispatchTouchEvent(paramMotionEvent))) {
        break label375;
      }
      AppMethodBeat.o(164665);
      return true;
    }
    label375:
    AppMethodBeat.o(164665);
    return false;
  }
  
  public final void fiP()
  {
    AppMethodBeat.i(164660);
    this.HYK.setCanCloseDrawerWhenStop(true);
    AppMethodBeat.o(164660);
  }
  
  public final boolean fiQ()
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
  
  public final void gV(View paramView)
  {
    AppMethodBeat.i(203976);
    k.h(paramView, "view");
    if (!this.HYK.getIgnoreInterceptViewList().contains(paramView)) {
      this.HYK.getIgnoreInterceptViewList().add(paramView);
    }
    AppMethodBeat.o(203976);
  }
  
  public final int getBackgroundColorRes()
  {
    return this.HYM;
  }
  
  public final RefreshLoadMoreLayout getCenterLayout()
  {
    AppMethodBeat.i(164655);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.HYK.getCenterLayout();
    AppMethodBeat.o(164655);
    return localRefreshLoadMoreLayout;
  }
  
  public final FrameLayout getFooterLayout()
  {
    AppMethodBeat.i(164656);
    FrameLayout localFrameLayout = this.HYK.getDrawerFooterLayout();
    AppMethodBeat.o(164656);
    return localFrameLayout;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(164657);
    FrameLayout localFrameLayout = this.HYK.getDrawerHeaderLayout();
    AppMethodBeat.o(164657);
    return localFrameLayout;
  }
  
  public final g getKeyboardHeightObserver()
  {
    return this.HYO;
  }
  
  public final FrameLayout getLoadingLayout()
  {
    AppMethodBeat.i(164658);
    FrameLayout localFrameLayout = this.HYK.getLoadingLayout();
    AppMethodBeat.o(164658);
    return localFrameLayout;
  }
  
  public final RecyclerViewDrawerSquares.c getOnOpenDrawerListener()
  {
    return this.HYQ;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(164654);
    RecyclerView localRecyclerView = this.HYK.getCenterLayout().getRecyclerView();
    AppMethodBeat.o(164654);
    return localRecyclerView;
  }
  
  public final int getSquaresBackgroundResource()
  {
    return this.HYN;
  }
  
  public final int getTopOffset()
  {
    return this.topOffset;
  }
  
  public final void setBackgroundColorRes(int paramInt)
  {
    AppMethodBeat.i(164651);
    this.HYM = paramInt;
    setBackgroundResource(paramInt);
    AppMethodBeat.o(164651);
  }
  
  public final void setEnableClickBackgroundToCloseDrawer(boolean paramBoolean)
  {
    this.HYL = paramBoolean;
  }
  
  protected final void setIntercept(boolean paramBoolean)
  {
    this.HYR = paramBoolean;
  }
  
  public final void setKeyboardHeightObserver(g paramg)
  {
    AppMethodBeat.i(164653);
    this.HYO = paramg;
    this.HYK.setKeyboardHeightObserver(this.HYO);
    AppMethodBeat.o(164653);
  }
  
  public final void setOnOpenDrawerListener(RecyclerViewDrawerSquares.c paramc)
  {
    this.HYQ = paramc;
  }
  
  public final void setSquaresBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(164652);
    this.HYN = paramInt;
    this.HYK.setBackgroundResource(paramInt);
    AppMethodBeat.o(164652);
  }
  
  public final void setTopOffset(int paramInt)
  {
    AppMethodBeat.i(164650);
    this.topOffset = paramInt;
    setPadding(0, this.topOffset, 0, 0);
    AppMethodBeat.o(164650);
  }
  
  public final void xl(boolean paramBoolean)
  {
    AppMethodBeat.i(164661);
    this.HYK.xl(paramBoolean);
    AppMethodBeat.o(164661);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawer$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.drawer.RecyclerViewDrawer
 * JD-Core Version:    0.7.0.1
 */