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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundColorRes", "getBackgroundColorRes", "()I", "setBackgroundColorRes", "(I)V", "downY", "", "isClickBackground", "", "isEnableClickBackgroundToCloseDrawer", "()Z", "setEnableClickBackgroundToCloseDrawer", "(Z)V", "isIntercept", "setIntercept", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "keyboardHeightObserver", "getKeyboardHeightObserver", "()Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "setKeyboardHeightObserver", "(Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;)V", "lastY", "onOpenDrawerListener", "getOnOpenDrawerListener", "()Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "setOnOpenDrawerListener", "(Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;)V", "rect", "Landroid/graphics/Rect;", "scaledDoubleTapSlop", "squares", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares;", "squaresBackgroundResource", "getSquaresBackgroundResource", "setSquaresBackgroundResource", "topOffset", "getTopOffset", "setTopOffset", "addIgnoreInterceptView", "", "view", "Landroid/view/View;", "canCloseDrawerWhenStop", "can", "closeDrawer", "isWithAnim", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getCenterLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getFooterLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "getLoadingLayout", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "isDrawerOpen", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "openDrawer", "Companion", "libmmui_release"})
public class RecyclerViewDrawer
  extends InsectFrameLayout
  implements RecyclerViewDrawerSquares.c
{
  public static final a LsO;
  private final RecyclerViewDrawerSquares LsF;
  private boolean LsG;
  private int LsH;
  private int LsI;
  private g LsJ;
  private final int LsK;
  private RecyclerViewDrawerSquares.c LsL;
  protected boolean LsM;
  private boolean LsN;
  private float aTM;
  private float cNh;
  private final Rect rect;
  private int topOffset;
  
  static
  {
    AppMethodBeat.i(164669);
    LsO = new a((byte)0);
    AppMethodBeat.o(164669);
  }
  
  public RecyclerViewDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164666);
    this.LsF = new RecyclerViewDrawerSquares(getContext());
    this.LsG = true;
    this.topOffset = ((int)getResources().getDimension(2131165287));
    this.LsH = 2131099819;
    this.LsI = 2131101179;
    paramContext = ViewConfiguration.get(getContext());
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.LsK = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.LsH);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.LsF.setBackgroundResource(this.LsI);
    addView((View)this.LsF, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.LsF.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164666);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164667);
    this.LsF = new RecyclerViewDrawerSquares(getContext());
    this.LsG = true;
    this.topOffset = ((int)getResources().getDimension(2131165287));
    this.LsH = 2131099819;
    this.LsI = 2131101179;
    paramContext = ViewConfiguration.get(getContext());
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.LsK = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.LsH);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.LsF.setBackgroundResource(this.LsI);
    addView((View)this.LsF, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.LsF.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164667);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164668);
    this.LsF = new RecyclerViewDrawerSquares(getContext());
    this.LsG = true;
    this.topOffset = ((int)getResources().getDimension(2131165287));
    this.LsH = 2131099819;
    this.LsI = 2131101179;
    paramContext = ViewConfiguration.get(getContext());
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.LsK = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.LsH);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.topOffset, 0, 0);
    this.LsF.setBackgroundResource(this.LsI);
    addView((View)this.LsF, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.LsF.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164668);
  }
  
  public final void Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(164663);
    new StringBuilder("[onDrawerOpen] isOpen=").append(paramBoolean1).append(" isBegin=").append(paramBoolean2);
    if ((paramBoolean2) && (paramBoolean1)) {
      setVisibility(0);
    }
    for (;;)
    {
      RecyclerViewDrawerSquares.c localc = this.LsL;
      if (localc == null) {
        break;
      }
      localc.Q(paramBoolean1, paramBoolean2);
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
  
  public final void aZ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(186663);
    this.LsF.aZ(paramBoolean1, paramBoolean2);
    AppMethodBeat.o(186663);
  }
  
  public final void be(float paramFloat)
  {
    AppMethodBeat.i(164664);
    Object localObject = getBackground();
    if (localObject != null) {
      ((Drawable)localObject).setAlpha((int)(255.0F * (1.0F - paramFloat)));
    }
    localObject = this.LsL;
    if (localObject != null)
    {
      ((RecyclerViewDrawerSquares.c)localObject).be(paramFloat);
      AppMethodBeat.o(164664);
      return;
    }
    AppMethodBeat.o(164664);
  }
  
  public final boolean cMZ()
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
  
  public final void cNK()
  {
    AppMethodBeat.i(186664);
    RecyclerViewDrawerSquares.c localc = this.LsL;
    if (localc != null)
    {
      localc.cNK();
      AppMethodBeat.o(186664);
      return;
    }
    AppMethodBeat.o(186664);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164665);
    p.h(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      this.rect.setEmpty();
      this.LsF.getDrawerHeaderLayout().getGlobalVisibleRect(this.rect);
      this.LsM = this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
      if (this.LsM)
      {
        Rect localRect = new Rect();
        Iterator localIterator = this.LsF.getIgnoreInterceptViewList().iterator();
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
      this.LsM = bool;
      if (this.LsM) {
        break;
      }
      this.aTM = paramMotionEvent.getRawY();
      this.cNh = this.aTM;
      if ((!this.LsM) && (this.LsG))
      {
        this.LsF.getGlobalVisibleRect(this.rect);
        if (!this.rect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())) {
          this.LsN = true;
        }
      }
      if (this.LsM)
      {
        this.LsF.r((int)(this.aTM - paramMotionEvent.getRawY()), 0, true);
        this.aTM = paramMotionEvent.getRawY();
      }
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        if (this.LsM) {
          this.LsF.cBP();
        }
        this.LsM = false;
        if ((this.LsN) && (this.LsG) && (paramMotionEvent.getAction() == 1) && (Math.abs(this.cNh - paramMotionEvent.getRawY()) <= this.LsK)) {
          RecyclerViewDrawerSquares.a(this.LsF);
        }
        this.LsN = false;
      }
      if ((!this.LsM) && (!this.LsN) && (!super.dispatchTouchEvent(paramMotionEvent))) {
        break label375;
      }
      AppMethodBeat.o(164665);
      return true;
    }
    label375:
    AppMethodBeat.o(164665);
    return false;
  }
  
  public final void fQm()
  {
    AppMethodBeat.i(164660);
    this.LsF.setCanCloseDrawerWhenStop(true);
    AppMethodBeat.o(164660);
  }
  
  public final int getBackgroundColorRes()
  {
    return this.LsH;
  }
  
  public final RefreshLoadMoreLayout getCenterLayout()
  {
    AppMethodBeat.i(164655);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.LsF.getCenterLayout();
    AppMethodBeat.o(164655);
    return localRefreshLoadMoreLayout;
  }
  
  public final FrameLayout getFooterLayout()
  {
    AppMethodBeat.i(164656);
    FrameLayout localFrameLayout = this.LsF.getDrawerFooterLayout();
    AppMethodBeat.o(164656);
    return localFrameLayout;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(164657);
    FrameLayout localFrameLayout = this.LsF.getDrawerHeaderLayout();
    AppMethodBeat.o(164657);
    return localFrameLayout;
  }
  
  public final g getKeyboardHeightObserver()
  {
    return this.LsJ;
  }
  
  public final FrameLayout getLoadingLayout()
  {
    AppMethodBeat.i(164658);
    FrameLayout localFrameLayout = this.LsF.getLoadingLayout();
    AppMethodBeat.o(164658);
    return localFrameLayout;
  }
  
  public final RecyclerViewDrawerSquares.c getOnOpenDrawerListener()
  {
    return this.LsL;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(164654);
    RecyclerView localRecyclerView = this.LsF.getCenterLayout().getRecyclerView();
    AppMethodBeat.o(164654);
    return localRecyclerView;
  }
  
  public final int getSquaresBackgroundResource()
  {
    return this.LsI;
  }
  
  public final int getTopOffset()
  {
    return this.topOffset;
  }
  
  public final void hk(View paramView)
  {
    AppMethodBeat.i(186662);
    p.h(paramView, "view");
    if (!this.LsF.getIgnoreInterceptViewList().contains(paramView)) {
      this.LsF.getIgnoreInterceptViewList().add(paramView);
    }
    AppMethodBeat.o(186662);
  }
  
  public final void setBackgroundColorRes(int paramInt)
  {
    AppMethodBeat.i(164651);
    this.LsH = paramInt;
    setBackgroundResource(paramInt);
    AppMethodBeat.o(164651);
  }
  
  public final void setEnableClickBackgroundToCloseDrawer(boolean paramBoolean)
  {
    this.LsG = paramBoolean;
  }
  
  protected final void setIntercept(boolean paramBoolean)
  {
    this.LsM = paramBoolean;
  }
  
  public final void setKeyboardHeightObserver(g paramg)
  {
    AppMethodBeat.i(164653);
    this.LsJ = paramg;
    this.LsF.setKeyboardHeightObserver(this.LsJ);
    AppMethodBeat.o(164653);
  }
  
  public final void setOnOpenDrawerListener(RecyclerViewDrawerSquares.c paramc)
  {
    this.LsL = paramc;
  }
  
  public final void setSquaresBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(164652);
    this.LsI = paramInt;
    this.LsF.setBackgroundResource(paramInt);
    AppMethodBeat.o(164652);
  }
  
  public final void setTopOffset(int paramInt)
  {
    AppMethodBeat.i(164650);
    this.topOffset = paramInt;
    setPadding(0, this.topOffset, 0, 0);
    AppMethodBeat.o(164650);
  }
  
  public final void zi(boolean paramBoolean)
  {
    AppMethodBeat.i(164661);
    this.LsF.zi(paramBoolean);
    AppMethodBeat.o(164661);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawer$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.drawer.RecyclerViewDrawer
 * JD-Core Version:    0.7.0.1
 */