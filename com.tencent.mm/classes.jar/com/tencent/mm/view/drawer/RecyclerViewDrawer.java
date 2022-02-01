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
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawer;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundColorRes", "getBackgroundColorRes", "()I", "setBackgroundColorRes", "(I)V", "downY", "", "isClickBackground", "", "isEnableClickBackgroundToCloseDrawer", "()Z", "setEnableClickBackgroundToCloseDrawer", "(Z)V", "isIntercept", "setIntercept", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "keyboardHeightObserver", "getKeyboardHeightObserver", "()Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "setKeyboardHeightObserver", "(Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;)V", "lastY", "onOpenDrawerListener", "getOnOpenDrawerListener", "()Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "setOnOpenDrawerListener", "(Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;)V", "rect", "Landroid/graphics/Rect;", "scaledDoubleTapSlop", "squares", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares;", "squaresBackgroundResource", "getSquaresBackgroundResource", "setSquaresBackgroundResource", "topOffset", "getTopOffset", "setTopOffset", "addIgnoreInterceptView", "", "view", "Landroid/view/View;", "canCloseDrawerWhenStop", "can", "closeDrawer", "isWithAnim", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getCenterLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getFooterLayout", "Landroid/widget/FrameLayout;", "getHeaderLayout", "getLoadingLayout", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isDrawerOpen", "onDrawerDetach", "onDrawerOpen", "isOpen", "isBegin", "onDrawerTranslation", "percent", "openDrawer", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class RecyclerViewDrawer
  extends InsectFrameLayout
  implements RecyclerViewDrawerSquares.c
{
  public static final a agLg;
  private int LGn;
  private final RecyclerViewDrawerSquares agLh;
  private boolean agLi;
  private int agLj;
  private int agLk;
  private h agLl;
  private final int agLm;
  private RecyclerViewDrawerSquares.c agLn;
  private boolean agLo;
  private float cxN;
  private float fig;
  private boolean hKw;
  private final Rect rect;
  
  static
  {
    AppMethodBeat.i(164669);
    agLg = new a((byte)0);
    AppMethodBeat.o(164669);
  }
  
  public RecyclerViewDrawer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164666);
    this.agLh = new RecyclerViewDrawerSquares(getContext());
    this.agLi = true;
    this.LGn = ((int)getResources().getDimension(a.e.Edge_25A));
    this.agLj = a.d.UN_BW_0_Alpha_0_5;
    this.agLk = a.d.white;
    this.agLm = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    setBackgroundResource(this.agLj);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.LGn, 0, 0);
    this.agLh.setBackgroundResource(this.agLk);
    addView((View)this.agLh, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.agLh.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164666);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164667);
    this.agLh = new RecyclerViewDrawerSquares(getContext());
    this.agLi = true;
    this.LGn = ((int)getResources().getDimension(a.e.Edge_25A));
    this.agLj = a.d.UN_BW_0_Alpha_0_5;
    this.agLk = a.d.white;
    this.agLm = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    setBackgroundResource(this.agLj);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.LGn, 0, 0);
    this.agLh.setBackgroundResource(this.agLk);
    addView((View)this.agLh, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.agLh.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164667);
  }
  
  public RecyclerViewDrawer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164668);
    this.agLh = new RecyclerViewDrawerSquares(getContext());
    this.agLi = true;
    this.LGn = ((int)getResources().getDimension(a.e.Edge_25A));
    this.agLj = a.d.UN_BW_0_Alpha_0_5;
    this.agLk = a.d.white;
    this.agLm = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    setBackgroundResource(this.agLj);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    setPadding(0, this.LGn, 0, 0);
    this.agLh.setBackgroundResource(this.agLk);
    addView((View)this.agLh, (ViewGroup.LayoutParams)paramContext);
    setVisibility(8);
    this.agLh.setOnOpenDrawerListener((RecyclerViewDrawerSquares.c)this);
    this.rect = new Rect();
    AppMethodBeat.o(164668);
  }
  
  public final void Ob(boolean paramBoolean)
  {
    AppMethodBeat.i(164661);
    this.agLh.Ob(paramBoolean);
    AppMethodBeat.o(164661);
  }
  
  public void ak(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(164663);
    new StringBuilder("[onDrawerOpen] isOpen=").append(paramBoolean1).append(" isBegin=").append(paramBoolean2);
    if ((paramBoolean2) && (paramBoolean1)) {
      setVisibility(0);
    }
    for (;;)
    {
      RecyclerViewDrawerSquares.c localc = this.agLn;
      if (localc != null) {
        localc.ak(paramBoolean1, paramBoolean2);
      }
      AppMethodBeat.o(164663);
      return;
      if ((!paramBoolean2) && (!paramBoolean1))
      {
        setVisibility(4);
        getCenterLayout().reset();
      }
    }
  }
  
  public final void bS(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(235239);
    RecyclerViewDrawerSquares localRecyclerViewDrawerSquares = this.agLh;
    Log.i("DrawerSquares", "[openDrawer] isOpening=" + localRecyclerViewDrawerSquares.LWA + ", canCloseDrawerWhenStop=" + paramBoolean2);
    RecyclerViewDrawerSquares.c localc;
    if (!localRecyclerViewDrawerSquares.LWA)
    {
      localRecyclerViewDrawerSquares.setCanCloseDrawerWhenStop(paramBoolean2);
      localRecyclerViewDrawerSquares.lKz.start();
      localc = localRecyclerViewDrawerSquares.agLn;
      if (localc != null) {
        localc.ak(true, true);
      }
      localRecyclerViewDrawerSquares.LWA = true;
      if (!paramBoolean1) {
        break label162;
      }
      if (localRecyclerViewDrawerSquares.getHeight() > 0.0F) {
        break label132;
      }
      localRecyclerViewDrawerSquares.agLv = ((RecyclerViewDrawerSquares.b)new RecyclerViewDrawerSquares.f(localRecyclerViewDrawerSquares));
    }
    for (;;)
    {
      localRecyclerViewDrawerSquares.setVisibility(0);
      AppMethodBeat.o(235239);
      return;
      label132:
      localRecyclerViewDrawerSquares.setTranslationY(localRecyclerViewDrawerSquares.getHeight());
      localRecyclerViewDrawerSquares.agLw.invoke(new RecyclerViewDrawerSquares.g(localRecyclerViewDrawerSquares));
      continue;
      label162:
      localRecyclerViewDrawerSquares.setTranslationY(0.0F);
      localRecyclerViewDrawerSquares.LWA = false;
      localc = localRecyclerViewDrawerSquares.agLn;
      if (localc != null) {
        localc.ak(true, false);
      }
    }
  }
  
  public final void cm(float paramFloat)
  {
    AppMethodBeat.i(164664);
    Object localObject = getBackground();
    if (localObject != null) {
      ((Drawable)localObject).setAlpha((int)(255.0F * (1.0F - paramFloat)));
    }
    localObject = this.agLn;
    if (localObject != null) {
      ((RecyclerViewDrawerSquares.c)localObject).cm(paramFloat);
    }
    AppMethodBeat.o(164664);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164665);
    s.u(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0)
    {
      this.rect.setEmpty();
      this.agLh.getDrawerHeaderLayout().getGlobalVisibleRect(this.rect);
      this.hKw = this.rect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if (this.hKw)
      {
        Rect localRect = new Rect();
        Iterator localIterator = this.agLh.getIgnoreInterceptViewList().iterator();
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
      this.hKw = bool;
      if (this.hKw) {
        break;
      }
      this.cxN = paramMotionEvent.getY();
      this.fig = this.cxN;
      if ((!this.hKw) && (this.agLi))
      {
        this.agLh.getGlobalVisibleRect(this.rect);
        if (!this.rect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          this.agLo = true;
        }
      }
      if (this.hKw)
      {
        this.agLh.v((int)(this.cxN - paramMotionEvent.getY()), 0, true);
        this.cxN = paramMotionEvent.getY();
      }
      if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        if (this.hKw) {
          this.agLh.ecZ();
        }
        this.hKw = false;
        if ((this.agLo) && (this.agLi) && (paramMotionEvent.getAction() == 1) && (Math.abs(this.fig - paramMotionEvent.getY()) <= this.agLm)) {
          RecyclerViewDrawerSquares.a(this.agLh);
        }
        this.agLo = false;
      }
      if ((!this.hKw) && (!this.agLo) && (!super.dispatchTouchEvent(paramMotionEvent))) {
        break label375;
      }
      AppMethodBeat.o(164665);
      return true;
    }
    label375:
    AppMethodBeat.o(164665);
    return false;
  }
  
  public final void eIv()
  {
    AppMethodBeat.i(235248);
    RecyclerViewDrawerSquares.c localc = this.agLn;
    if (localc != null) {
      localc.eIv();
    }
    AppMethodBeat.o(235248);
  }
  
  public final boolean fkp()
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
  
  public final int getBackgroundColorRes()
  {
    return this.agLj;
  }
  
  public final RefreshLoadMoreLayout getCenterLayout()
  {
    AppMethodBeat.i(164655);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.agLh.getCenterLayout();
    AppMethodBeat.o(164655);
    return localRefreshLoadMoreLayout;
  }
  
  public final FrameLayout getFooterLayout()
  {
    AppMethodBeat.i(164656);
    FrameLayout localFrameLayout = this.agLh.getDrawerFooterLayout();
    AppMethodBeat.o(164656);
    return localFrameLayout;
  }
  
  public final FrameLayout getHeaderLayout()
  {
    AppMethodBeat.i(164657);
    FrameLayout localFrameLayout = this.agLh.getDrawerHeaderLayout();
    AppMethodBeat.o(164657);
    return localFrameLayout;
  }
  
  public final h getKeyboardHeightObserver()
  {
    return this.agLl;
  }
  
  public final FrameLayout getLoadingLayout()
  {
    AppMethodBeat.i(164658);
    FrameLayout localFrameLayout = this.agLh.getLoadingLayout();
    AppMethodBeat.o(164658);
    return localFrameLayout;
  }
  
  public final RecyclerViewDrawerSquares.c getOnOpenDrawerListener()
  {
    return this.agLn;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(235229);
    RecyclerView localRecyclerView = this.agLh.getCenterLayout().getRecyclerView();
    AppMethodBeat.o(235229);
    return localRecyclerView;
  }
  
  public final int getSquaresBackgroundResource()
  {
    return this.agLk;
  }
  
  public final int getTopOffset()
  {
    return this.LGn;
  }
  
  public final void jMR()
  {
    AppMethodBeat.i(164660);
    this.agLh.setCanCloseDrawerWhenStop(true);
    AppMethodBeat.o(164660);
  }
  
  protected final boolean jMS()
  {
    return this.hKw;
  }
  
  public final void mA(View paramView)
  {
    AppMethodBeat.i(235236);
    s.u(paramView, "view");
    if (!this.agLh.getIgnoreInterceptViewList().contains(paramView)) {
      this.agLh.getIgnoreInterceptViewList().add(paramView);
    }
    AppMethodBeat.o(235236);
  }
  
  public final void setBackgroundColorRes(int paramInt)
  {
    AppMethodBeat.i(164651);
    this.agLj = paramInt;
    setBackgroundResource(paramInt);
    AppMethodBeat.o(164651);
  }
  
  public final void setEnableClickBackgroundToCloseDrawer(boolean paramBoolean)
  {
    this.agLi = paramBoolean;
  }
  
  protected final void setIntercept(boolean paramBoolean)
  {
    this.hKw = paramBoolean;
  }
  
  public final void setKeyboardHeightObserver(h paramh)
  {
    AppMethodBeat.i(164653);
    this.agLl = paramh;
    this.agLh.setKeyboardHeightObserver(this.agLl);
    AppMethodBeat.o(164653);
  }
  
  public final void setOnOpenDrawerListener(RecyclerViewDrawerSquares.c paramc)
  {
    this.agLn = paramc;
  }
  
  public final void setSquaresBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(164652);
    this.agLk = paramInt;
    this.agLh.setBackgroundResource(paramInt);
    AppMethodBeat.o(164652);
  }
  
  public final void setTopOffset(int paramInt)
  {
    AppMethodBeat.i(164650);
    this.LGn = paramInt;
    setPadding(0, this.LGn, 0, 0);
    AppMethodBeat.o(164650);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawer$Companion;", "", "()V", "TAG", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.drawer.RecyclerViewDrawer
 * JD-Core Version:    0.7.0.1
 */