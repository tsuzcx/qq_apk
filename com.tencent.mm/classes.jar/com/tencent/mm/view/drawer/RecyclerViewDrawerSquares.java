package com.tencent.mm.view.drawer;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.view.HeadFooterLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "canCloseDrawerWhenStop", "getCanCloseDrawerWhenStop", "()Z", "setCanCloseDrawerWhenStop", "(Z)V", "centerLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getCenterLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setCenterLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "drawerFooterLayout", "Landroid/widget/FrameLayout;", "getDrawerFooterLayout", "()Landroid/widget/FrameLayout;", "setDrawerFooterLayout", "(Landroid/widget/FrameLayout;)V", "drawerHeaderLayout", "getDrawerHeaderLayout", "setDrawerHeaderLayout", "ignoreInterceptViewList", "", "Landroid/view/View;", "getIgnoreInterceptViewList", "()Ljava/util/List;", "setIgnoreInterceptViewList", "(Ljava/util/List;)V", "isClosing", "setClosing", "isKeyboardShow", "isOpening", "setOpening", "keyboardHeightObserver", "getKeyboardHeightObserver", "()Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "setKeyboardHeightObserver", "(Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;)V", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "loadingLayout", "getLoadingLayout", "setLoadingLayout", "onLayoutChangeCallback", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnLayoutChangeCallback;", "onOpenDrawerListener", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "getOnOpenDrawerListener", "()Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "setOnOpenDrawerListener", "(Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;)V", "openAnimation", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "end", "closeDrawer", "isWithAnim", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onAttachedToWindow", "onDetachedFromWindow", "onKeyboardHeightChanged", "height", "isResized", "onLayout", "changed", "l", "t", "r", "b", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "openDrawer", "setTranslationY", "translationY", "", "Companion", "OnLayoutChangeCallback", "OnOpenDrawerListener", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RecyclerViewDrawerSquares
  extends LinearLayout
  implements h, HeadFooterLayout.b
{
  public static final a agLp;
  private FrameLayout FZT;
  private boolean HDO;
  boolean LWA;
  private h agLl;
  c agLn;
  private RefreshLoadMoreLayout agLq;
  private FrameLayout agLr;
  private FrameLayout agLs;
  private List<View> agLt;
  boolean agLu;
  b agLv;
  final kotlin.g.a.b<kotlin.g.a.a<ah>, ah> agLw;
  private boolean agLx;
  i lKz;
  
  static
  {
    AppMethodBeat.i(164699);
    agLp = new a((byte)0);
    AppMethodBeat.o(164699);
  }
  
  public RecyclerViewDrawerSquares(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(164696);
    this.agLt = ((List)new ArrayList());
    paramContext = getContext();
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(164696);
      throw paramContext;
    }
    this.lKz = new i((Activity)paramContext);
    this.agLw = ((kotlin.g.a.b)new e(this));
    setOrientation(1);
    paramContext = LayoutInflater.from(getContext()).inflate(a.h.recycler_view_drawer, (ViewGroup)this);
    View localView = paramContext.findViewById(a.g.refresh_load_more_layout);
    s.s(localView, "view.findViewById(R.id.refresh_load_more_layout)");
    this.agLq = ((RefreshLoadMoreLayout)localView);
    localView = paramContext.findViewById(a.g.placeholder_drawer_header);
    s.s(localView, "view.findViewById(R.id.placeholder_drawer_header)");
    this.agLs = ((FrameLayout)localView);
    localView = paramContext.findViewById(a.g.placeholder_drawer_footer);
    s.s(localView, "view.findViewById(R.id.placeholder_drawer_footer)");
    this.agLr = ((FrameLayout)localView);
    paramContext = paramContext.findViewById(a.g.placeholder_loading_layout);
    s.s(paramContext, "view.findViewById(R.id.placeholder_loading_layout)");
    this.FZT = ((FrameLayout)paramContext);
    this.agLq.setOverCallback((HeadFooterLayout.b)this);
    setVisibility(8);
    this.lKz.afIL = ((h)this);
    setOnClickListener(RecyclerViewDrawerSquares..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(164696);
  }
  
  public RecyclerViewDrawerSquares(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(164697);
    this.agLt = ((List)new ArrayList());
    paramContext = getContext();
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(164697);
      throw paramContext;
    }
    this.lKz = new i((Activity)paramContext);
    this.agLw = ((kotlin.g.a.b)new e(this));
    setOrientation(1);
    paramContext = LayoutInflater.from(getContext()).inflate(a.h.recycler_view_drawer, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(a.g.refresh_load_more_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.refresh_load_more_layout)");
    this.agLq = ((RefreshLoadMoreLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(a.g.placeholder_drawer_header);
    s.s(paramAttributeSet, "view.findViewById(R.id.placeholder_drawer_header)");
    this.agLs = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(a.g.placeholder_drawer_footer);
    s.s(paramAttributeSet, "view.findViewById(R.id.placeholder_drawer_footer)");
    this.agLr = ((FrameLayout)paramAttributeSet);
    paramContext = paramContext.findViewById(a.g.placeholder_loading_layout);
    s.s(paramContext, "view.findViewById(R.id.placeholder_loading_layout)");
    this.FZT = ((FrameLayout)paramContext);
    this.agLq.setOverCallback((HeadFooterLayout.b)this);
    setVisibility(8);
    this.lKz.afIL = ((h)this);
    setOnClickListener(RecyclerViewDrawerSquares..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(164697);
  }
  
  public RecyclerViewDrawerSquares(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164698);
    this.agLt = ((List)new ArrayList());
    paramContext = getContext();
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(164698);
      throw paramContext;
    }
    this.lKz = new i((Activity)paramContext);
    this.agLw = ((kotlin.g.a.b)new e(this));
    setOrientation(1);
    paramContext = LayoutInflater.from(getContext()).inflate(a.h.recycler_view_drawer, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(a.g.refresh_load_more_layout);
    s.s(paramAttributeSet, "view.findViewById(R.id.refresh_load_more_layout)");
    this.agLq = ((RefreshLoadMoreLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(a.g.placeholder_drawer_header);
    s.s(paramAttributeSet, "view.findViewById(R.id.placeholder_drawer_header)");
    this.agLs = ((FrameLayout)paramAttributeSet);
    paramAttributeSet = paramContext.findViewById(a.g.placeholder_drawer_footer);
    s.s(paramAttributeSet, "view.findViewById(R.id.placeholder_drawer_footer)");
    this.agLr = ((FrameLayout)paramAttributeSet);
    paramContext = paramContext.findViewById(a.g.placeholder_loading_layout);
    s.s(paramContext, "view.findViewById(R.id.placeholder_loading_layout)");
    this.FZT = ((FrameLayout)paramContext);
    this.agLq.setOverCallback((HeadFooterLayout.b)this);
    setVisibility(8);
    this.lKz.afIL = ((h)this);
    setOnClickListener(RecyclerViewDrawerSquares..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(164698);
  }
  
  private static final void a(RecyclerViewDrawerSquares paramRecyclerViewDrawerSquares, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(235216);
    s.u(paramRecyclerViewDrawerSquares, "this$0");
    Log.d("DrawerSquares", "[closeDrawer] setUpdateListener height:" + paramRecyclerViewDrawerSquares.getHeight() + ", translationY:" + paramRecyclerViewDrawerSquares.getTranslationY());
    paramValueAnimator = paramRecyclerViewDrawerSquares.getOnOpenDrawerListener();
    if (paramValueAnimator != null) {
      paramValueAnimator.cm(1.0F * paramRecyclerViewDrawerSquares.getTranslationY() / paramRecyclerViewDrawerSquares.getHeight());
    }
    AppMethodBeat.o(235216);
  }
  
  private static final void b(RecyclerViewDrawerSquares paramRecyclerViewDrawerSquares)
  {
    AppMethodBeat.i(235213);
    s.u(paramRecyclerViewDrawerSquares, "this$0");
    paramRecyclerViewDrawerSquares.setVisibility(8);
    paramRecyclerViewDrawerSquares.setClosing(false);
    c localc = paramRecyclerViewDrawerSquares.getOnOpenDrawerListener();
    if (localc != null) {
      localc.ak(false, false);
    }
    paramRecyclerViewDrawerSquares.lKz.close();
    paramRecyclerViewDrawerSquares.HDO = false;
    paramRecyclerViewDrawerSquares = paramRecyclerViewDrawerSquares.getKeyboardHeightObserver();
    if (paramRecyclerViewDrawerSquares != null) {
      paramRecyclerViewDrawerSquares.onKeyboardHeightChanged(0, false);
    }
    AppMethodBeat.o(235213);
  }
  
  private static final void c(RecyclerViewDrawerSquares paramRecyclerViewDrawerSquares)
  {
    AppMethodBeat.i(235219);
    s.u(paramRecyclerViewDrawerSquares, "this$0");
    paramRecyclerViewDrawerSquares.setAlpha(1.0F);
    paramRecyclerViewDrawerSquares.setTranslationY(paramRecyclerViewDrawerSquares.getHeight());
    paramRecyclerViewDrawerSquares.setVisibility(8);
    paramRecyclerViewDrawerSquares.HDO = false;
    paramRecyclerViewDrawerSquares.setClosing(false);
    c localc = paramRecyclerViewDrawerSquares.getOnOpenDrawerListener();
    if (localc != null) {
      localc.ak(false, false);
    }
    paramRecyclerViewDrawerSquares.lKz.close();
    paramRecyclerViewDrawerSquares = paramRecyclerViewDrawerSquares.getKeyboardHeightObserver();
    if (paramRecyclerViewDrawerSquares != null) {
      paramRecyclerViewDrawerSquares.onKeyboardHeightChanged(0, false);
    }
    AppMethodBeat.o(235219);
  }
  
  private static final void dg(View paramView)
  {
    AppMethodBeat.i(235211);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/view/drawer/RecyclerViewDrawerSquares", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/view/drawer/RecyclerViewDrawerSquares", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(235211);
  }
  
  public final boolean NK(int paramInt)
  {
    return false;
  }
  
  public final void Ob(boolean paramBoolean)
  {
    AppMethodBeat.i(164687);
    Log.i("DrawerSquares", "closeDrawer isClosing " + this.agLu + ", isWithAnim " + paramBoolean);
    if (!this.agLu)
    {
      Object localObject = getContext();
      if ((localObject instanceof MMFragmentActivity))
      {
        localObject = (MMFragmentActivity)localObject;
        if (localObject != null) {
          ((MMFragmentActivity)localObject).hideVKB();
        }
        this.agLu = true;
        this.LWA = false;
        localObject = this.agLn;
        if (localObject != null) {
          ((c)localObject).ak(false, true);
        }
        if (!paramBoolean) {
          break label221;
        }
        clearAnimation();
        animate().cancel();
        localObject = animate().setInterpolator((TimeInterpolator)new DecelerateInterpolator(1.5F)).translationY(getHeight()).setDuration(300L).withEndAction(new RecyclerViewDrawerSquares..ExternalSyntheticLambda3(this)).setUpdateListener(new RecyclerViewDrawerSquares..ExternalSyntheticLambda0(this));
        if (!this.HDO) {
          break label216;
        }
      }
      label216:
      for (long l = 200L;; l = 0L)
      {
        ((ViewPropertyAnimator)localObject).setStartDelay(l).start();
        AppMethodBeat.o(164687);
        return;
        localObject = null;
        break;
      }
      label221:
      clearAnimation();
      animate().cancel();
      animate().alpha(0.0F).setDuration(300L).withEndAction(new RecyclerViewDrawerSquares..ExternalSyntheticLambda2(this));
    }
    AppMethodBeat.o(164687);
  }
  
  public final void ecZ()
  {
    AppMethodBeat.i(164694);
    if (getTranslationY() >= 0.25F * getHeight())
    {
      if (this.agLx)
      {
        Ob(true);
        AppMethodBeat.o(164694);
      }
    }
    else {
      this.agLw.invoke(d.agLy);
    }
    AppMethodBeat.o(164694);
  }
  
  public final boolean getCanCloseDrawerWhenStop()
  {
    return this.agLx;
  }
  
  public final RefreshLoadMoreLayout getCenterLayout()
  {
    return this.agLq;
  }
  
  public final FrameLayout getDrawerFooterLayout()
  {
    return this.agLr;
  }
  
  public final FrameLayout getDrawerHeaderLayout()
  {
    return this.agLs;
  }
  
  public final List<View> getIgnoreInterceptViewList()
  {
    return this.agLt;
  }
  
  public final h getKeyboardHeightObserver()
  {
    return this.agLl;
  }
  
  public final FrameLayout getLoadingLayout()
  {
    return this.FZT;
  }
  
  public final c getOnOpenDrawerListener()
  {
    return this.agLn;
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(235254);
    RecyclerView localRecyclerView = this.agLq.getRecyclerView();
    AppMethodBeat.o(235254);
    return localRecyclerView;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(164690);
    super.onAttachedToWindow();
    if ((getContext() instanceof Activity))
    {
      Object localObject = getContext();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(164690);
        throw ((Throwable)localObject);
      }
      ((Activity)localObject).getWindow().setSoftInputMode(48);
    }
    AppMethodBeat.o(164690);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(164691);
    super.onDetachedFromWindow();
    this.lKz.close();
    AppMethodBeat.o(164691);
  }
  
  public final void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(164689);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.HDO = bool;
      h localh = this.agLl;
      if (localh != null) {
        localh.onKeyboardHeightChanged(paramInt, paramBoolean);
      }
      AppMethodBeat.o(164689);
      return;
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164685);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      b localb = this.agLv;
      if (localb != null) {
        localb.jMT();
      }
    }
    AppMethodBeat.o(164685);
  }
  
  public final void setCanCloseDrawerWhenStop(boolean paramBoolean)
  {
    AppMethodBeat.i(164693);
    this.agLx = paramBoolean;
    Log.i("DrawerSquares", "lxl set canCloseDrawerWhenStop " + paramBoolean + ' ');
    AppMethodBeat.o(164693);
  }
  
  public final void setCenterLayout(RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(164681);
    s.u(paramRefreshLoadMoreLayout, "<set-?>");
    this.agLq = paramRefreshLoadMoreLayout;
    AppMethodBeat.o(164681);
  }
  
  public final void setClosing(boolean paramBoolean)
  {
    this.agLu = paramBoolean;
  }
  
  public final void setDrawerFooterLayout(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(164682);
    s.u(paramFrameLayout, "<set-?>");
    this.agLr = paramFrameLayout;
    AppMethodBeat.o(164682);
  }
  
  public final void setDrawerHeaderLayout(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(164683);
    s.u(paramFrameLayout, "<set-?>");
    this.agLs = paramFrameLayout;
    AppMethodBeat.o(164683);
  }
  
  public final void setIgnoreInterceptViewList(List<View> paramList)
  {
    AppMethodBeat.i(235242);
    s.u(paramList, "<set-?>");
    this.agLt = paramList;
    AppMethodBeat.o(235242);
  }
  
  public final void setKeyboardHeightObserver(h paramh)
  {
    this.agLl = paramh;
  }
  
  public final void setLoadingLayout(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(164684);
    s.u(paramFrameLayout, "<set-?>");
    this.FZT = paramFrameLayout;
    AppMethodBeat.o(164684);
  }
  
  public final void setOnOpenDrawerListener(c paramc)
  {
    this.agLn = paramc;
  }
  
  public final void setOpening(boolean paramBoolean)
  {
    this.LWA = paramBoolean;
  }
  
  public final void setTranslationY(float paramFloat)
  {
    AppMethodBeat.i(164692);
    super.setTranslationY(paramFloat);
    c localc = this.agLn;
    if (localc != null) {
      localc.cm(1.0F * paramFloat / getHeight());
    }
    AppMethodBeat.o(164692);
  }
  
  public final boolean v(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(164695);
    if ((this.agLu) || (this.LWA))
    {
      AppMethodBeat.o(164695);
      return true;
    }
    if ((paramInt2 == 1) && (!paramBoolean))
    {
      AppMethodBeat.o(164695);
      return false;
    }
    if (((paramBoolean) || ((!paramBoolean) && (paramInt1 < 0))) && (this.agLx))
    {
      setTranslationY(androidx.core.b.a.g(getTranslationY() - paramInt1, 0.0F, getHeight()));
      AppMethodBeat.o(164695);
      return true;
    }
    AppMethodBeat.o(164695);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$Companion;", "", "()V", "DURATION", "", "LIMIT_CLOSE", "", "TAG", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnLayoutChangeCallback;", "", "onLayoutChange", "", "l", "", "t", "r", "b", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void jMT();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnOpenDrawerListener;", "", "onDrawerDetach", "", "onDrawerOpen", "isOpen", "", "isBegin", "onDrawerTranslation", "percent", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void ak(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void cm(float paramFloat);
    
    public abstract void eIv();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final d agLy;
    
    static
    {
      AppMethodBeat.i(164673);
      agLy = new d();
      AppMethodBeat.o(164673);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/Function0;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<kotlin.g.a.a<? extends ah>, ah>
  {
    e(RecyclerViewDrawerSquares paramRecyclerViewDrawerSquares)
    {
      super();
    }
    
    private static final void ar(kotlin.g.a.a parama)
    {
      AppMethodBeat.i(235195);
      s.u(parama, "$it");
      parama.invoke();
      AppMethodBeat.o(235195);
    }
    
    private static final void b(RecyclerViewDrawerSquares paramRecyclerViewDrawerSquares, ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(235199);
      s.u(paramRecyclerViewDrawerSquares, "this$0");
      Log.d("DrawerSquares", "[openDrawer] setUpdateListener height:" + paramRecyclerViewDrawerSquares.getHeight() + ", translationY:" + paramRecyclerViewDrawerSquares.getTranslationY());
      paramValueAnimator = paramRecyclerViewDrawerSquares.getOnOpenDrawerListener();
      if (paramValueAnimator != null) {
        paramValueAnimator.cm(1.0F * paramRecyclerViewDrawerSquares.getTranslationY() / paramRecyclerViewDrawerSquares.getHeight());
      }
      AppMethodBeat.o(235199);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/drawer/RecyclerViewDrawerSquares$openDrawer$1", "Lcom/tencent/mm/view/drawer/RecyclerViewDrawerSquares$OnLayoutChangeCallback;", "onLayoutChange", "", "l", "", "t", "r", "b", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements RecyclerViewDrawerSquares.b
  {
    f(RecyclerViewDrawerSquares paramRecyclerViewDrawerSquares) {}
    
    private static final void f(RecyclerViewDrawerSquares paramRecyclerViewDrawerSquares)
    {
      AppMethodBeat.i(235194);
      s.u(paramRecyclerViewDrawerSquares, "this$0");
      RecyclerViewDrawerSquares.e(paramRecyclerViewDrawerSquares).invoke(new a(paramRecyclerViewDrawerSquares));
      AppMethodBeat.o(235194);
    }
    
    public final void jMT()
    {
      AppMethodBeat.i(164679);
      Log.d("DrawerSquares", s.X("[openDrawer] onLayoutChange height:", Integer.valueOf(this.agLz.getHeight())));
      RecyclerViewDrawerSquares.d(this.agLz);
      this.agLz.setTranslationY(this.agLz.getHeight());
      this.agLz.post(new RecyclerViewDrawerSquares.f..ExternalSyntheticLambda0(this.agLz));
      AppMethodBeat.o(164679);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(RecyclerViewDrawerSquares paramRecyclerViewDrawerSquares)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(RecyclerViewDrawerSquares paramRecyclerViewDrawerSquares)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.drawer.RecyclerViewDrawerSquares
 * JD-Core Version:    0.7.0.1
 */