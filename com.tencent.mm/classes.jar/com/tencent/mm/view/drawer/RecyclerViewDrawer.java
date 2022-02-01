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
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundColorRes", "getBackgroundColorRes", "()I", "setBackgroundColorRes", "(I)V", "downY", "", "isClickBackground", "", "isEnableClickBackgroundToCloseDrawer", "()Z", "setEnableClickBackgroundToCloseDrawer", "(Z)V", "isIntercept", "setIntercept", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "keyboardHeightObserver", "getKeyboardHeightObserver", "()Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "setKeyboardHeightObserver", "(Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;)V", "lastY", "onOpenDrawerListener", "getOnOpenDrawerListener", "()Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "setOnOpenDrawerListener", "(Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;)V", "rect", "Landroid/graphics/Rect;", "scaledDoubleTapSlop", "squares", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares;", "squaresBackgroundResource", "getSquaresBackgroundResource", "setSquaresBackgroundResource", "topOffset", "getTopOffset", "setTopOffset", "addIgnoreInterceptView", "", "view", "Landroid/view/View;", "canCloseDrawerWhenStop", "can", "closeDrawer", "isWithAnim", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getCenterLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getFooterLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "getLoadingLayout", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "isDrawerOpen", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "openDrawer", "Companion", "libmmui_release"})
public class RecyclerViewDrawer
  extends InsectFrameLayout
  implements RecyclerViewDrawerSquares.c
{
  public static final a Roh;
  private final RecyclerViewDrawerSquares RnY;
  private boolean RnZ;
  private int Roa;
  private int Rob;
  private g Roc;
  private final int Rod;
  private RecyclerViewDrawerSquares.c Roe;
  protected boolean Rof;
  private boolean Rog;
  private float aTE;
  private float dep;
  private final Rect rect;
  private int topOffset;
  
  static
  {
    AppMethodBeat.i(164669);
    Roh = new a((byte)0);
    AppMethodBeat.o(164669);
  }
  
  public RecyclerViewDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164666);
    this.RnY = new RecyclerViewDrawerSquares(getContext());
    this.RnZ = true;
    this.topOffset = ((int)getResources().getDimension(2131165294));
    this.Roa = 2131099835;
    this.Rob = 2131101424;
    paramContext = ViewConfiguration.get(getContext());
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.Rod = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.Roa);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.RnY.setBackgroundResource(this.Rob);
    addView((View)this.RnY, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.RnY.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164666);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164667);
    this.RnY = new RecyclerViewDrawerSquares(getContext());
    this.RnZ = true;
    this.topOffset = ((int)getResources().getDimension(2131165294));
    this.Roa = 2131099835;
    this.Rob = 2131101424;
    paramContext = ViewConfiguration.get(getContext());
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.Rod = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.Roa);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.RnY.setBackgroundResource(this.Rob);
    addView((View)this.RnY, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.RnY.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164667);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164668);
    this.RnY = new RecyclerViewDrawerSquares(getContext());
    this.RnZ = true;
    this.topOffset = ((int)getResources().getDimension(2131165294));
    this.Roa = 2131099835;
    this.Rob = 2131101424;
    paramContext = ViewConfiguration.get(getContext());
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.Rod = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.Roa);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.RnY.setBackgroundResource(this.Rob);
    addView((View)this.RnY, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.RnY.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164668);
  }
  
  public final void DG(boolean paramBoolean)
  {
    AppMethodBeat.i(164661);
    this.RnY.DG(paramBoolean);
    AppMethodBeat.o(164661);
  }
  
  public final void S(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(164663);
    new StringBuilder("[onDrawerOpen] isOpen=").append(paramBoolean1).append(" isBegin=").append(paramBoolean2);
    if ((paramBoolean2) && (paramBoolean1)) {
      setVisibility(0);
    }
    for (;;)
    {
      RecyclerViewDrawerSquares.c localc = this.Roe;
      if (localc == null) {
        break;
      }
      localc.S(paramBoolean1, paramBoolean2);
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
  
  public final void bi(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(205018);
    this.RnY.bi(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(205018);
  }
  
  public final void bo(float paramFloat)
  {
    AppMethodBeat.i(164664);
    Object localObject = getBackground();
    if (localObject != null) {
      ((Drawable)localObject).setAlpha((int)(255.0F * (1.0F - paramFloat)));
    }
    localObject = this.Roe;
    if (localObject != null)
    {
      ((RecyclerViewDrawerSquares.c)localObject).bo(paramFloat);
      AppMethodBeat.o(164664);
      return;
    }
    AppMethodBeat.o(164664);
  }
  
  public final boolean dGs()
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
  
  public final void dHu()
  {
    AppMethodBeat.i(205019);
    RecyclerViewDrawerSquares.c localc = this.Roe;
    if (localc != null)
    {
      localc.dHu();
      AppMethodBeat.o(205019);
      return;
    }
    AppMethodBeat.o(205019);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164665);
    p.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      this.rect.setEmpty();
      this.RnY.getDrawerHeaderLayout().getGlobalVisibleRect(this.rect);
      this.Rof = this.rect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if (this.Rof)
      {
        Rect localRect = new Rect();
        Iterator localIterator = this.RnY.getIgnoreInterceptViewList().iterator();
        if (localIterator.hasNext())
        {
          ((View)localIterator.next()).getGlobalVisibleRect(localRect);
          if (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
            break label370;
          }
        }
      }
    }
    label370:
    for (boolean bool = true;; bool = false)
    {
      this.Rof = bool;
      if (this.Rof) {
        break;
      }
      this.aTE = paramMotionEvent.getY();
      this.dep = this.aTE;
      if ((!this.Rof) && (this.RnZ))
      {
        this.RnY.getGlobalVisibleRect(this.rect);
        if (!this.rect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          this.Rog = true;
        }
      }
      if (this.Rof)
      {
        this.RnY.u((int)(this.aTE - paramMotionEvent.getY()), 0, true);
        this.aTE = paramMotionEvent.getY();
      }
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        if (this.Rof) {
          this.RnY.ddr();
        }
        this.Rof = false;
        if ((this.Rog) && (this.RnZ) && (paramMotionEvent.getAction() == 1) && (Math.abs(this.dep - paramMotionEvent.getY()) <= this.Rod)) {
          RecyclerViewDrawerSquares.a(this.RnY);
        }
        this.Rog = false;
      }
      if ((!this.Rof) && (!this.Rog) && (!super.dispatchTouchEvent(paramMotionEvent))) {
        break label375;
      }
      AppMethodBeat.o(164665);
      return true;
    }
    label375:
    AppMethodBeat.o(164665);
    return false;
  }
  
  public final int getBackgroundColorRes()
  {
    return this.Roa;
  }
  
  public final RefreshLoadMoreLayout getCenterLayout()
  {
    AppMethodBeat.i(164655);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.RnY.getCenterLayout();
    AppMethodBeat.o(164655);
    return localRefreshLoadMoreLayout;
  }
  
  public final FrameLayout getFooterLayout()
  {
    AppMethodBeat.i(164656);
    FrameLayout localFrameLayout = this.RnY.getDrawerFooterLayout();
    AppMethodBeat.o(164656);
    return localFrameLayout;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(164657);
    FrameLayout localFrameLayout = this.RnY.getDrawerHeaderLayout();
    AppMethodBeat.o(164657);
    return localFrameLayout;
  }
  
  public final g getKeyboardHeightObserver()
  {
    return this.Roc;
  }
  
  public final FrameLayout getLoadingLayout()
  {
    AppMethodBeat.i(164658);
    FrameLayout localFrameLayout = this.RnY.getLoadingLayout();
    AppMethodBeat.o(164658);
    return localFrameLayout;
  }
  
  public final RecyclerViewDrawerSquares.c getOnOpenDrawerListener()
  {
    return this.Roe;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(164654);
    RecyclerView localRecyclerView = this.RnY.getCenterLayout().getRecyclerView();
    AppMethodBeat.o(164654);
    return localRecyclerView;
  }
  
  public final int getSquaresBackgroundResource()
  {
    return this.Rob;
  }
  
  public final int getTopOffset()
  {
    return this.topOffset;
  }
  
  public final void hH(View paramView)
  {
    AppMethodBeat.i(205017);
    p.h(paramView, "view");
    if (!this.RnY.getIgnoreInterceptViewList().contains(paramView)) {
      this.RnY.getIgnoreInterceptViewList().add(paramView);
    }
    AppMethodBeat.o(205017);
  }
  
  public final void hge()
  {
    AppMethodBeat.i(164660);
    this.RnY.setCanCloseDrawerWhenStop(true);
    AppMethodBeat.o(164660);
  }
  
  public final void setBackgroundColorRes(int paramInt)
  {
    AppMethodBeat.i(164651);
    this.Roa = paramInt;
    setBackgroundResource(paramInt);
    AppMethodBeat.o(164651);
  }
  
  public final void setEnableClickBackgroundToCloseDrawer(boolean paramBoolean)
  {
    this.RnZ = paramBoolean;
  }
  
  protected final void setIntercept(boolean paramBoolean)
  {
    this.Rof = paramBoolean;
  }
  
  public final void setKeyboardHeightObserver(g paramg)
  {
    AppMethodBeat.i(164653);
    this.Roc = paramg;
    this.RnY.setKeyboardHeightObserver(this.Roc);
    AppMethodBeat.o(164653);
  }
  
  public final void setOnOpenDrawerListener(RecyclerViewDrawerSquares.c paramc)
  {
    this.Roe = paramc;
  }
  
  public final void setSquaresBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(164652);
    this.Rob = paramInt;
    this.RnY.setBackgroundResource(paramInt);
    AppMethodBeat.o(164652);
  }
  
  public final void setTopOffset(int paramInt)
  {
    AppMethodBeat.i(164650);
    this.topOffset = paramInt;
    setPadding(0, this.topOffset, 0, 0);
    AppMethodBeat.o(164650);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawer$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.drawer.RecyclerViewDrawer
 * JD-Core Version:    0.7.0.1
 */