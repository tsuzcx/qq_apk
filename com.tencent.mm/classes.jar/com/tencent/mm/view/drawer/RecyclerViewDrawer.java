package com.tencent.mm.view.drawer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.InsectFrameLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundColorRes", "getBackgroundColorRes", "()I", "setBackgroundColorRes", "(I)V", "downY", "", "isClickBackground", "", "isEnableClickBackgroundToCloseDrawer", "()Z", "setEnableClickBackgroundToCloseDrawer", "(Z)V", "isIntercept", "setIntercept", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "keyboardHeightObserver", "getKeyboardHeightObserver", "()Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "setKeyboardHeightObserver", "(Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;)V", "lastY", "onOpenDrawerListener", "getOnOpenDrawerListener", "()Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "setOnOpenDrawerListener", "(Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;)V", "rect", "Landroid/graphics/Rect;", "scaledDoubleTapSlop", "squares", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares;", "squaresBackgroundResource", "getSquaresBackgroundResource", "setSquaresBackgroundResource", "topOffset", "getTopOffset", "setTopOffset", "addIgnoreInterceptView", "", "view", "Landroid/view/View;", "canCloseDrawerWhenStop", "can", "closeDrawer", "isWithAnim", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getCenterLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getFooterLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "getLoadingLayout", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isDrawerOpen", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "openDrawer", "Companion", "libmmui_release"})
public class RecyclerViewDrawer
  extends InsectFrameLayout
  implements RecyclerViewDrawerSquares.c
{
  public static final RecyclerViewDrawer.a YPC;
  private int FLg;
  private boolean YPA;
  private boolean YPB;
  private final RecyclerViewDrawerSquares YPt;
  private boolean YPu;
  private int YPv;
  private int YPw;
  private h YPx;
  private final int YPy;
  private RecyclerViewDrawerSquares.c YPz;
  private float aCb;
  private final Rect byG;
  private float diu;
  
  static
  {
    AppMethodBeat.i(164669);
    YPC = new RecyclerViewDrawer.a((byte)0);
    AppMethodBeat.o(164669);
  }
  
  public RecyclerViewDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164666);
    this.YPt = new RecyclerViewDrawerSquares(getContext());
    this.YPu = true;
    this.FLg = ((int)getResources().getDimension(a.e.Edge_25A));
    this.YPv = a.d.UN_BW_0_Alpha_0_5;
    this.YPw = a.d.white;
    paramContext = ViewConfiguration.get(getContext());
    p.j(paramContext, "ViewConfiguration.get(context)");
    this.YPy = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.YPv);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.FLg, 0, 0);
    this.YPt.setBackgroundResource(this.YPw);
    addView((View)this.YPt, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.YPt.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.byG = new Rect();
    AppMethodBeat.o(164666);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164667);
    this.YPt = new RecyclerViewDrawerSquares(getContext());
    this.YPu = true;
    this.FLg = ((int)getResources().getDimension(a.e.Edge_25A));
    this.YPv = a.d.UN_BW_0_Alpha_0_5;
    this.YPw = a.d.white;
    paramContext = ViewConfiguration.get(getContext());
    p.j(paramContext, "ViewConfiguration.get(context)");
    this.YPy = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.YPv);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.FLg, 0, 0);
    this.YPt.setBackgroundResource(this.YPw);
    addView((View)this.YPt, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.YPt.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.byG = new Rect();
    AppMethodBeat.o(164667);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164668);
    this.YPt = new RecyclerViewDrawerSquares(getContext());
    this.YPu = true;
    this.FLg = ((int)getResources().getDimension(a.e.Edge_25A));
    this.YPv = a.d.UN_BW_0_Alpha_0_5;
    this.YPw = a.d.white;
    paramContext = ViewConfiguration.get(getContext());
    p.j(paramContext, "ViewConfiguration.get(context)");
    this.YPy = paramContext.getScaledTouchSlop();
    setBackgroundResource(this.YPv);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.FLg, 0, 0);
    this.YPt.setBackgroundResource(this.YPw);
    addView((View)this.YPt, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.YPt.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.byG = new Rect();
    AppMethodBeat.o(164668);
  }
  
  public final void Ig(boolean paramBoolean)
  {
    AppMethodBeat.i(164661);
    this.YPt.Ig(paramBoolean);
    AppMethodBeat.o(164661);
  }
  
  public final void aa(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(164663);
    new StringBuilder("[onDrawerOpen] isOpen=").append(paramBoolean1).append(" isBegin=").append(paramBoolean2);
    if ((paramBoolean2) && (paramBoolean1)) {
      setVisibility(0);
    }
    for (;;)
    {
      RecyclerViewDrawerSquares.c localc = this.YPz;
      if (localc == null) {
        break;
      }
      localc.aa(paramBoolean1, paramBoolean2);
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
  
  public final void bm(float paramFloat)
  {
    AppMethodBeat.i(164664);
    Object localObject = getBackground();
    if (localObject != null) {
      ((Drawable)localObject).setAlpha((int)(255.0F * (1.0F - paramFloat)));
    }
    localObject = this.YPz;
    if (localObject != null)
    {
      ((RecyclerViewDrawerSquares.c)localObject).bm(paramFloat);
      AppMethodBeat.o(164664);
      return;
    }
    AppMethodBeat.o(164664);
  }
  
  public final void bs(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(221329);
    RecyclerViewDrawerSquares localRecyclerViewDrawerSquares = this.YPt;
    Log.i("DrawerSquares", "[openDrawer] isOpening=" + localRecyclerViewDrawerSquares.Gar + ", canCloseDrawerWhenStop=" + paramBoolean2);
    RecyclerViewDrawerSquares.c localc;
    if (!localRecyclerViewDrawerSquares.Gar)
    {
      localRecyclerViewDrawerSquares.setCanCloseDrawerWhenStop(paramBoolean2);
      localRecyclerViewDrawerSquares.jij.start();
      localc = localRecyclerViewDrawerSquares.YPz;
      if (localc != null) {
        localc.aa(true, true);
      }
      localRecyclerViewDrawerSquares.Gar = true;
      if (!paramBoolean1) {
        break label162;
      }
      if (localRecyclerViewDrawerSquares.getHeight() > 0.0F) {
        break label132;
      }
      localRecyclerViewDrawerSquares.YPI = ((RecyclerViewDrawerSquares.b)new RecyclerViewDrawerSquares.i(localRecyclerViewDrawerSquares));
    }
    for (;;)
    {
      localRecyclerViewDrawerSquares.setVisibility(0);
      AppMethodBeat.o(221329);
      return;
      label132:
      localRecyclerViewDrawerSquares.setTranslationY(localRecyclerViewDrawerSquares.getHeight());
      localRecyclerViewDrawerSquares.YPJ.invoke(new RecyclerViewDrawerSquares.j(localRecyclerViewDrawerSquares));
      continue;
      label162:
      localRecyclerViewDrawerSquares.setTranslationY(0.0F);
      localRecyclerViewDrawerSquares.Gar = false;
      localc = localRecyclerViewDrawerSquares.YPz;
      if (localc != null) {
        localc.aa(true, false);
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164665);
    p.k(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      this.byG.setEmpty();
      this.YPt.getDrawerHeaderLayout().getGlobalVisibleRect(this.byG);
      this.YPA = this.byG.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if (this.YPA)
      {
        Rect localRect = new Rect();
        Iterator localIterator = this.YPt.getIgnoreInterceptViewList().iterator();
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
      this.YPA = bool;
      if (this.YPA) {
        break;
      }
      this.aCb = paramMotionEvent.getY();
      this.diu = this.aCb;
      if ((!this.YPA) && (this.YPu))
      {
        this.YPt.getGlobalVisibleRect(this.byG);
        if (!this.byG.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          this.YPB = true;
        }
      }
      if (this.YPA)
      {
        this.YPt.v((int)(this.aCb - paramMotionEvent.getY()), 0, true);
        this.aCb = paramMotionEvent.getY();
      }
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        if (this.YPA) {
          this.YPt.dtZ();
        }
        this.YPA = false;
        if ((this.YPB) && (this.YPu) && (paramMotionEvent.getAction() == 1) && (Math.abs(this.diu - paramMotionEvent.getY()) <= this.YPy)) {
          RecyclerViewDrawerSquares.a(this.YPt);
        }
        this.YPB = false;
      }
      if ((!this.YPA) && (!this.YPB) && (!super.dispatchTouchEvent(paramMotionEvent))) {
        break label375;
      }
      AppMethodBeat.o(164665);
      return true;
    }
    label375:
    AppMethodBeat.o(164665);
    return false;
  }
  
  public final boolean eis()
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
  
  public final void ejF()
  {
    AppMethodBeat.i(221337);
    RecyclerViewDrawerSquares.c localc = this.YPz;
    if (localc != null)
    {
      localc.ejF();
      AppMethodBeat.o(221337);
      return;
    }
    AppMethodBeat.o(221337);
  }
  
  public final int getBackgroundColorRes()
  {
    return this.YPv;
  }
  
  public final RefreshLoadMoreLayout getCenterLayout()
  {
    AppMethodBeat.i(164655);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.YPt.getCenterLayout();
    AppMethodBeat.o(164655);
    return localRefreshLoadMoreLayout;
  }
  
  public final FrameLayout getFooterLayout()
  {
    AppMethodBeat.i(164656);
    FrameLayout localFrameLayout = this.YPt.getDrawerFooterLayout();
    AppMethodBeat.o(164656);
    return localFrameLayout;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(164657);
    FrameLayout localFrameLayout = this.YPt.getDrawerHeaderLayout();
    AppMethodBeat.o(164657);
    return localFrameLayout;
  }
  
  public final h getKeyboardHeightObserver()
  {
    return this.YPx;
  }
  
  public final FrameLayout getLoadingLayout()
  {
    AppMethodBeat.i(164658);
    FrameLayout localFrameLayout = this.YPt.getLoadingLayout();
    AppMethodBeat.o(164658);
    return localFrameLayout;
  }
  
  public final RecyclerViewDrawerSquares.c getOnOpenDrawerListener()
  {
    return this.YPz;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(221314);
    RecyclerView localRecyclerView = this.YPt.getCenterLayout().getRecyclerView();
    AppMethodBeat.o(221314);
    return localRecyclerView;
  }
  
  public final int getSquaresBackgroundResource()
  {
    return this.YPw;
  }
  
  public final int getTopOffset()
  {
    return this.FLg;
  }
  
  public final void ihE()
  {
    AppMethodBeat.i(164660);
    this.YPt.setCanCloseDrawerWhenStop(true);
    AppMethodBeat.o(164660);
  }
  
  protected final boolean ihF()
  {
    return this.YPA;
  }
  
  public final void jc(View paramView)
  {
    AppMethodBeat.i(221322);
    p.k(paramView, "view");
    if (!this.YPt.getIgnoreInterceptViewList().contains(paramView)) {
      this.YPt.getIgnoreInterceptViewList().add(paramView);
    }
    AppMethodBeat.o(221322);
  }
  
  public final void setBackgroundColorRes(int paramInt)
  {
    AppMethodBeat.i(164651);
    this.YPv = paramInt;
    setBackgroundResource(paramInt);
    AppMethodBeat.o(164651);
  }
  
  public final void setEnableClickBackgroundToCloseDrawer(boolean paramBoolean)
  {
    this.YPu = paramBoolean;
  }
  
  protected final void setIntercept(boolean paramBoolean)
  {
    this.YPA = paramBoolean;
  }
  
  public final void setKeyboardHeightObserver(h paramh)
  {
    AppMethodBeat.i(164653);
    this.YPx = paramh;
    this.YPt.setKeyboardHeightObserver(this.YPx);
    AppMethodBeat.o(164653);
  }
  
  public final void setOnOpenDrawerListener(RecyclerViewDrawerSquares.c paramc)
  {
    this.YPz = paramc;
  }
  
  public final void setSquaresBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(164652);
    this.YPw = paramInt;
    this.YPt.setBackgroundResource(paramInt);
    AppMethodBeat.o(164652);
  }
  
  public final void setTopOffset(int paramInt)
  {
    AppMethodBeat.i(164650);
    this.FLg = paramInt;
    setPadding(0, this.FLg, 0, 0);
    AppMethodBeat.o(164650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.drawer.RecyclerViewDrawer
 * JD-Core Version:    0.7.0.1
 */