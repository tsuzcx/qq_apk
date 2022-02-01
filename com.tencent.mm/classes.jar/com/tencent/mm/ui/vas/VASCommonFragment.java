package com.tencent.mm.ui.vas;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.g;
import androidx.appcompat.view.menu.h;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.af;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.compatible.util.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.vas.c.c;
import com.tencent.mm.ui.vas.c.d;
import com.tencent.mm.ui.vas.fragment.VASBaseFragment;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;
import com.tencent.mm.ui.widget.SwipeBackLayout.c;
import com.tencent.mm.ui.y;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.ak;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/VASCommonFragment;", "Lcom/tencent/mm/ui/vas/fragment/VASBaseFragment;", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$SwipeBackListener;", "Lcom/tencent/mm/ui/vas/IVASComonCallback;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "actionBarRoot", "Landroid/view/View;", "getActionBarRoot", "()Landroid/view/View;", "setActionBarRoot", "(Landroid/view/View;)V", "actionBarWrapper", "getActionBarWrapper", "setActionBarWrapper", "currentView", "getCurrentView", "setCurrentView", "enterAnim", "Lcom/tencent/mm/ui/vas/page/VASPageAnim;", "getEnterAnim", "()Lcom/tencent/mm/ui/vas/page/VASPageAnim;", "setEnterAnim", "(Lcom/tencent/mm/ui/vas/page/VASPageAnim;)V", "exitAnim", "getExitAnim", "setExitAnim", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "isShouldCreated", "", "()Z", "setShouldCreated", "(Z)V", "lastFragment", "getLastFragment", "()Lcom/tencent/mm/ui/vas/VASCommonFragment;", "setLastFragment", "(Lcom/tencent/mm/ui/vas/VASCommonFragment;)V", "layoutCustomContainer", "Landroid/widget/FrameLayout;", "getLayoutCustomContainer", "()Landroid/widget/FrameLayout;", "setLayoutCustomContainer", "(Landroid/widget/FrameLayout;)V", "mController", "Lcom/tencent/mm/ui/MMActivityController;", "getMController", "()Lcom/tencent/mm/ui/MMActivityController;", "mSwipeBackLayout", "Lcom/tencent/mm/ui/widget/SwipeBackLayout;", "getMSwipeBackLayout", "()Lcom/tencent/mm/ui/widget/SwipeBackLayout;", "setMSwipeBackLayout", "(Lcom/tencent/mm/ui/widget/SwipeBackLayout;)V", "mWrappingFrame", "Landroid/view/ViewGroup;", "getMWrappingFrame", "()Landroid/view/ViewGroup;", "setMWrappingFrame", "(Landroid/view/ViewGroup;)V", "maxTransX", "", "getMaxTransX", "()F", "setMaxTransX", "(F)V", "onAttachCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/vas/VASActivity;", "", "getOnAttachCallback", "()Lkotlin/jvm/functions/Function1;", "setOnAttachCallback", "(Lkotlin/jvm/functions/Function1;)V", "popEnterAnim", "getPopEnterAnim", "setPopEnterAnim", "popExitAnim", "getPopExitAnim", "setPopExitAnim", "vNavigationBar", "getVNavigationBar", "setVNavigationBar", "vStatusBar", "getVStatusBar", "setVStatusBar", "vasActivity", "getVasActivity", "()Lcom/tencent/mm/ui/vas/VASActivity;", "setVasActivity", "(Lcom/tencent/mm/ui/vas/VASActivity;)V", "vasBack", "getVasBack", "setVasBack", "_requireView", "canInterceptTouch", "component", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "dealContentView", "v", "enableSwipeBack", "getCommonTitleTv", "Lcom/tencent/mm/ui/vas/page/ICommonAnimTitle;", "getCustomBounceId", "", "getEntity", "()Ljava/lang/Object;", "getLayoutId", "getLayoutView", "getSwipeBackTouchState", "handleActionBarAndStatusBar", "savedInstanceState", "Landroid/os/Bundle;", "handleNavigationBar", "isFullScreen", "importUIComponents", "", "Lcom/tencent/mm/ui/component/UIComponent;", "initStartAnim", "tempAnim", "Lcom/tencent/mm/ui/vas/VASActivity$TempPageAnim;", "initSwipeBack", "initTargetAnim", "isSupportNavigationSwipeBack", "isUseActivitySwipeBack", "noActionBar", "onActivityResult", "requestCode", "resultCode", "data", "onAttach", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "onBackPressed", "onCancelDrag", "onCreate", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "enter", "nextAnim", "onCreateAnimator", "Landroid/animation/Animator;", "onCreateBeforeSetContentView", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "onDispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onDragBegin", "onEdgeDragStarted", "edgeFlags", "pointerId", "onKeyboardStateChanged", "onPause", "onPositionChange", "left", "top", "dx", "dy", "scrollPercent", "onPrepareOptionsMenu", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSaveInstanceState", "outState", "onSwipeBack", "onViewCreated", "view", "onViewReleased", "willSwipeBack", "onWindowFocusChanged", "hasFocus", "setArguments", "args", "setLastFragmentBack", "shouldInterceptTouchEvent", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VASCommonFragment
  extends VASBaseFragment
  implements a, SwipeBackLayout.c
{
  public static final a afQz;
  final String TAG;
  VASCommonFragment afQA;
  private View afQB;
  private FrameLayout afQC;
  private View afQD;
  View afQE;
  View afQF;
  View afQG;
  FrameLayout afQH;
  private boolean afQI;
  private kotlin.g.a.b<? super VASActivity, ah> afQJ;
  private float afQK;
  VASActivity afQn;
  com.tencent.mm.ui.vas.c.f afQp;
  com.tencent.mm.ui.vas.c.f afQq;
  com.tencent.mm.ui.vas.c.f afQr;
  com.tencent.mm.ui.vas.c.f afQs;
  Intent intent;
  final y mController;
  private SwipeBackLayout mSwipeBackLayout;
  private ViewGroup mWrappingFrame;
  
  static
  {
    AppMethodBeat.i(249969);
    afQz = new a((byte)0);
    AppMethodBeat.o(249969);
  }
  
  public VASCommonFragment()
  {
    AppMethodBeat.i(249936);
    this.TAG = s.X("MicroMsg.VAS.VASCommonFragment@", Integer.valueOf(hashCode()));
    this.intent = new Intent();
    this.afQp = ((com.tencent.mm.ui.vas.c.f)d.afRf);
    this.afQq = ((com.tencent.mm.ui.vas.c.f)c.afRe);
    this.afQr = ((com.tencent.mm.ui.vas.c.f)com.tencent.mm.ui.vas.c.b.afRd);
    this.afQs = ((com.tencent.mm.ui.vas.c.f)com.tencent.mm.ui.vas.c.e.afRg);
    this.mController = ((y)new c(this));
    AppMethodBeat.o(249936);
  }
  
  private final void Nf(boolean paramBoolean)
  {
    AppMethodBeat.i(249957);
    Object localObject;
    if (!paramBoolean)
    {
      localObject = this.afQG;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.afQG;
      if (localObject != null)
      {
        localObject = ((View)localObject).getLayoutParams();
        if (localObject != null)
        {
          ((ViewGroup.LayoutParams)localObject).height = bf.bk(getContext());
          View localView = this.afQG;
          if (localView != null) {
            localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          AppMethodBeat.o(249957);
        }
      }
    }
    else
    {
      localObject = this.afQG;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    AppMethodBeat.o(249957);
  }
  
  private final void ca(Bundle paramBundle)
  {
    AppMethodBeat.i(249952);
    Object localObject1 = getActivity();
    Object localObject2;
    int i;
    boolean bool;
    if (!(localObject1 instanceof VASCommonActivity))
    {
      localObject2 = this.afQn;
      if ((localObject2 != null) && (!((VASActivity)localObject2).getDisableCommonAreaControl()))
      {
        i = 1;
        if (i == 0) {
          break label345;
        }
      }
    }
    else
    {
      localObject2 = this.afQn;
      if ((localObject2 == null) || (((VASActivity)localObject2).isFullScreen() != true)) {
        break label282;
      }
      bool = true;
      label67:
      if (!bool) {
        break label287;
      }
      localObject2 = this.afQD;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      label89:
      if ((localObject1 instanceof VASCommonActivity)) {
        ((VASCommonActivity)localObject1).hUb();
      }
      localObject1 = this.mWrappingFrame;
      if ((localObject1 != null) && ((localObject1 instanceof com.tencent.mm.ui.statusbar.b))) {
        ((com.tencent.mm.ui.statusbar.b)localObject1).MU(true);
      }
      if (bool) {
        break label307;
      }
      i = o.I(getContext(), -1);
      localObject1 = this.afQF;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = this.afQF;
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).getLayoutParams();
        if (localObject1 != null)
        {
          ((ViewGroup.LayoutParams)localObject1).height = i;
          localObject2 = this.afQF;
          if (localObject2 != null) {
            ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
      localObject1 = jEm();
      if (localObject1 != null) {
        ((com.tencent.mm.ui.vas.c.a)localObject1).aEj(i);
      }
    }
    for (;;)
    {
      Nf(bool);
      if (paramBundle == null) {
        break label328;
      }
      if (!paramBundle.containsKey("KEY_ACTIONBAR_COLOR")) {
        break label345;
      }
      i = paramBundle.getInt("KEY_ACTIONBAR_COLOR");
      paramBundle = this.afQn;
      if (paramBundle == null) {
        break label345;
      }
      paramBundle.setActionbarColor(i);
      AppMethodBeat.o(249952);
      return;
      i = 0;
      break;
      label282:
      bool = false;
      break label67;
      label287:
      localObject2 = this.afQD;
      if (localObject2 == null) {
        break label89;
      }
      ((View)localObject2).setVisibility(0);
      break label89;
      label307:
      localObject1 = this.afQF;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    label328:
    paramBundle = this.afQn;
    if (paramBundle != null) {
      paramBundle.setActionbarColor(paramBundle.getActionbarColor());
    }
    label345:
    AppMethodBeat.o(249952);
  }
  
  public static int getCustomBounceId()
  {
    return a.g.layout_custom;
  }
  
  private boolean isSupportNavigationSwipeBack()
  {
    AppMethodBeat.i(249942);
    VASActivity localVASActivity = this.afQn;
    if ((localVASActivity != null) && (localVASActivity.isSupportNavigationSwipeBack() == true))
    {
      AppMethodBeat.o(249942);
      return true;
    }
    AppMethodBeat.o(249942);
    return false;
  }
  
  private boolean jEn()
  {
    return this.afQA == null;
  }
  
  public static boolean noActionBar()
  {
    return false;
  }
  
  public final void a(VASActivity.b paramb)
  {
    AppMethodBeat.i(250090);
    s.u(paramb, "tempAnim");
    com.tencent.mm.ui.vas.c.f localf = paramb.afQq;
    if (localf != null)
    {
      s.u(localf, "<set-?>");
      this.afQq = localf;
    }
    paramb = paramb.afQr;
    if (paramb != null)
    {
      s.u(paramb, "<set-?>");
      this.afQr = paramb;
    }
    AppMethodBeat.o(250090);
  }
  
  public final void aG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250074);
    Log.d(this.TAG, "onEdgeDragStarted() called with: edgeFlags = " + paramInt1 + ", pointerId = " + paramInt2);
    AppMethodBeat.o(250074);
  }
  
  public final void b(VASActivity.b paramb)
  {
    AppMethodBeat.i(250094);
    s.u(paramb, "tempAnim");
    com.tencent.mm.ui.vas.c.f localf = paramb.afQp;
    if (localf != null)
    {
      s.u(localf, "<set-?>");
      this.afQp = localf;
    }
    paramb = paramb.afQs;
    if (paramb != null)
    {
      s.u(paramb, "<set-?>");
      this.afQs = paramb;
    }
    AppMethodBeat.o(250094);
  }
  
  public final void cD(float paramFloat)
  {
    VASCommonFragment localVASCommonFragment = null;
    Object localObject = null;
    AppMethodBeat.i(250056);
    if (paramFloat <= 0.0F)
    {
      localVASCommonFragment = this.afQA;
      if (localVASCommonFragment == null) {}
      while (localObject != null)
      {
        ((View)localObject).setTranslationX(0.0F);
        AppMethodBeat.o(250056);
        return;
        localObject = localVASCommonFragment.afQB;
      }
    }
    float f = this.afQK;
    localObject = this.afQA;
    if (localObject == null) {}
    for (localObject = localVASCommonFragment;; localObject = ((VASCommonFragment)localObject).afQB)
    {
      if (localObject != null) {
        ((View)localObject).setTranslationX(f * (1.0F - paramFloat));
      }
      AppMethodBeat.o(250056);
      return;
    }
  }
  
  public final int cI(boolean paramBoolean)
  {
    AppMethodBeat.i(250066);
    Log.d(this.TAG, s.X("onViewReleased() called with: willSwipeBack = ", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(250066);
    return 1;
  }
  
  public final <T extends af> T component(Class<T> paramClass)
  {
    AppMethodBeat.i(249979);
    s.u(paramClass, "modelClass");
    Object localObject = k.aeZF;
    localObject = this.afQn;
    s.checkNotNull(localObject);
    paramClass = k.d((AppCompatActivity)localObject).q(paramClass);
    s.s(paramClass, "UICProvider.of(vasActivity!!).get(modelClass)");
    AppMethodBeat.o(249979);
    return paramClass;
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(250024);
    VASActivity localVASActivity = this.afQn;
    if (localVASActivity == null)
    {
      AppMethodBeat.o(250024);
      return -1;
    }
    int i = localVASActivity.getCurLayoutId();
    AppMethodBeat.o(250024);
    return i;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final boolean gjA()
  {
    return false;
  }
  
  public final boolean gjD()
  {
    return false;
  }
  
  public final int gjz()
  {
    return 0;
  }
  
  public final boolean i(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    return null;
  }
  
  public final com.tencent.mm.ui.vas.c.a jEm()
  {
    AppMethodBeat.i(250097);
    Object localObject = getActivity();
    if ((localObject instanceof VASCommonActivity)) {}
    for (localObject = (VASCommonActivity)localObject; localObject == null; localObject = null)
    {
      AppMethodBeat.o(250097);
      return null;
    }
    localObject = (com.tencent.mm.ui.vas.c.a)((VASCommonActivity)localObject).afQw.getValue();
    AppMethodBeat.o(250097);
    return localObject;
  }
  
  public final View jEo()
  {
    AppMethodBeat.i(250103);
    View localView = getView();
    s.checkNotNull(localView);
    s.s(localView, "view!!");
    AppMethodBeat.o(250103);
    return localView;
  }
  
  public final void n(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(250061);
    String str = this.TAG;
    if (paramMotionEvent == null) {}
    for (int i = -1;; i = paramMotionEvent.getAction())
    {
      Log.d(str, s.X("onDispatchTouchEvent() called with: ev = ", MotionEvent.actionToString(i)));
      AppMethodBeat.o(250061);
      return;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(250027);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    VASActivity localVASActivity = this.afQn;
    if (localVASActivity != null) {
      localVASActivity.callOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    Log.d(this.TAG, "onActivityResult() called with: requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent);
    AppMethodBeat.o(250027);
  }
  
  public final void onAttach(Activity paramActivity)
  {
    AppMethodBeat.i(249983);
    s.u(paramActivity, "activity");
    Log.d(this.TAG, s.X("onAttach() called with: activity = ", paramActivity));
    super.onAttach(paramActivity);
    AppMethodBeat.o(249983);
  }
  
  public final void onAttach(Context paramContext)
  {
    AppMethodBeat.i(249994);
    s.u(paramContext, "context");
    Log.d(this.TAG, s.X("onAttach() called with: context = ", paramContext));
    Object localObject1 = getArguments();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getSerializable("VAS_CLASS");
      if (localObject1 == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type java.lang.Class<com.tencent.mm.ui.vas.VASActivity>");
        AppMethodBeat.o(249994);
        throw paramContext;
      }
      localObject2 = (Class)localObject1;
      localObject1 = getActivity();
      if (localObject1 != null) {}
      for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
      {
        paramContext = (Throwable)new AssertionError("Assertion failed");
        AppMethodBeat.o(249994);
        throw paramContext;
      }
      this.afQn = ((VASActivity)((Class)localObject2).getConstructor(new Class[0]).newInstance(new Object[0]));
      localObject2 = this.afQn;
      if (localObject2 != null) {
        ((VASActivity)localObject2).setMFragmentManager(getFragmentManager());
      }
      localObject2 = this.afQn;
      if (localObject2 != null) {
        ((VASActivity)localObject2).setFragment(this);
      }
      if (localObject1 != null)
      {
        localObject2 = this.afQn;
        if (localObject2 != null) {
          ((VASActivity)localObject2).set_activity((Activity)localObject1);
        }
        localObject2 = this.afQn;
        if (localObject2 != null) {
          ((VASActivity)localObject2).setInnerContext((Context)localObject1);
        }
      }
    }
    try
    {
      localObject2 = Activity.class.getDeclaredField("mApplication");
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject2).set(this.afQn, ((FragmentActivity)localObject1).getApplication());
      localObject1 = this.afQn;
      if (localObject1 != null) {
        ((VASActivity)localObject1).onInited();
      }
      localObject1 = this.afQn;
      if (localObject1 != null) {
        ((VASActivity)localObject1).initVasController();
      }
      localObject1 = this.afQn;
      if (localObject1 != null) {
        ((VASActivity)localObject1).fixStatusbar(true);
      }
      super.onAttach(paramContext);
      paramContext = this.afQJ;
      if (paramContext != null) {
        paramContext.invoke(this.afQn);
      }
      AppMethodBeat.o(249994);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace(this.TAG, localThrowable, "onAttach application err", new Object[0]);
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(249999);
    com.tencent.mm.ui.vas.d.a locala = MMFragmentActivity.aReporter;
    Object localObject1 = this.afQn;
    if (localObject1 == null)
    {
      localObject1 = null;
      locala.bs((Intent)localObject1);
      localObject1 = getActivity();
      if (localObject1 != null) {
        break label99;
      }
    }
    label99:
    for (localObject1 = localObject2;; localObject1 = (FrameLayout)((FragmentActivity)localObject1).findViewById(a.g.layout_vas_back))
    {
      this.afQC = ((FrameLayout)localObject1);
      super.onCreate(paramBundle);
      Log.d(this.TAG, "onCreate");
      this.mController.a((Context)this.afQn, (AppCompatActivity)this.afQn);
      AppMethodBeat.o(249999);
      return;
      localObject1 = ((VASActivity)localObject1).getIntent();
      break;
    }
  }
  
  public final Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public final Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(250034);
    Object localObject = e.afQO;
    localObject = e.a(this, paramInt2);
    Log.d(this.TAG, "onCreateAnimator() called with: animator = " + localObject + " transit = " + paramInt1 + ", enter = " + paramBoolean + ", nextAnim = " + paramInt2);
    AppMethodBeat.o(250034);
    return localObject;
  }
  
  public final void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    AppMethodBeat.i(250045);
    s.u(paramMenu, "menu");
    s.u(paramMenuInflater, "inflater");
    paramMenuInflater = this.afQn;
    if (paramMenuInflater != null) {
      paramMenuInflater.onCreateOptionsMenu(paramMenu);
    }
    AppMethodBeat.o(250045);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(250004);
    s.u(paramLayoutInflater, "inflater");
    Log.i(this.TAG, s.X("onCreateView:", Integer.valueOf(getId())));
    setHasOptionsMenu(true);
    this.afQB = this.mController.getContentView();
    paramLayoutInflater = this.afQB;
    if ((paramViewGroup != null) && (paramLayoutInflater != null) && ((paramLayoutInflater.getParent() instanceof ViewGroup)))
    {
      paramViewGroup = paramLayoutInflater.getParent();
      if (paramViewGroup == null)
      {
        paramLayoutInflater = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(250004);
        throw paramLayoutInflater;
      }
      paramViewGroup = (ViewGroup)paramViewGroup;
      Log.d(this.TAG, s.X("onCreateView removeView vg:", paramViewGroup));
      paramViewGroup.removeView(paramLayoutInflater);
    }
    paramLayoutInflater = this.afQB;
    if (paramLayoutInflater != null)
    {
      paramViewGroup = ((Iterable)this.uiComponents).iterator();
      while (paramViewGroup.hasNext()) {
        ((UIComponent)paramViewGroup.next()).setRootView(paramLayoutInflater);
      }
      if (!this.afQI)
      {
        setRootView(paramLayoutInflater);
        paramLayoutInflater = ((Iterable)this.uiComponents).iterator();
        while (paramLayoutInflater.hasNext()) {
          ((UIComponent)paramLayoutInflater.next()).onCreateBefore(paramBundle);
        }
        this.afQI = true;
      }
    }
    paramViewGroup = this.afQB;
    paramLayoutInflater = paramViewGroup;
    if (isSupportNavigationSwipeBack())
    {
      paramLayoutInflater = paramViewGroup;
      if (!jEn())
      {
        paramBundle = getContentView();
        s.checkNotNull(paramBundle);
        paramLayoutInflater = paramBundle.getParent();
        if ((paramLayoutInflater instanceof ViewGroup)) {
          paramLayoutInflater = (ViewGroup)paramLayoutInflater;
        }
        while (paramLayoutInflater != null)
        {
          paramViewGroup = LayoutInflater.from((Context)getActivity()).inflate(a.h.swipeback_layout, paramLayoutInflater, false);
          if (paramViewGroup == null)
          {
            paramLayoutInflater = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.SwipeBackLayout");
            AppMethodBeat.o(250004);
            throw paramLayoutInflater;
            paramLayoutInflater = null;
          }
          else
          {
            paramViewGroup = (SwipeBackLayout)paramViewGroup;
            paramLayoutInflater.removeView(paramBundle);
            paramLayoutInflater.addView((View)this.mSwipeBackLayout);
          }
        }
      }
    }
    for (paramLayoutInflater = paramViewGroup;; paramLayoutInflater = (SwipeBackLayout)paramLayoutInflater)
    {
      paramLayoutInflater.addView(paramBundle);
      paramLayoutInflater.setContentView(paramBundle);
      if (paramLayoutInflater.getChildCount() > 0)
      {
        paramViewGroup = paramLayoutInflater.getChildAt(0);
        paramLayoutInflater.removeView(paramViewGroup);
        paramBundle = new com.tencent.mm.ui.statusbar.b(paramLayoutInflater.getContext());
        paramBundle.addView(paramViewGroup, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        paramLayoutInflater.addView((View)paramBundle);
        paramLayoutInflater.setContentView((View)paramBundle);
        this.mWrappingFrame = ((ViewGroup)paramBundle);
      }
      paramLayoutInflater.Nl(true);
      paramLayoutInflater.setSwipeGestureDelegate((SwipeBackLayout.b)new b(this));
      paramLayoutInflater.setSwipeBackListener((SwipeBackLayout.c)this);
      this.mSwipeBackLayout = paramLayoutInflater;
      paramLayoutInflater = (View)paramLayoutInflater;
      this.afQB = paramLayoutInflater;
      AppMethodBeat.o(250004);
      return paramLayoutInflater;
      paramLayoutInflater = LayoutInflater.from((Context)getActivity()).inflate(a.h.swipeback_layout, null);
      if (paramLayoutInflater == null)
      {
        paramLayoutInflater = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.SwipeBackLayout");
        AppMethodBeat.o(250004);
        throw paramLayoutInflater;
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(250020);
    Log.d(this.TAG, "onPause() called");
    super.onPause();
    AppMethodBeat.o(250020);
  }
  
  public final void onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(250051);
    s.u(paramMenu, "menu");
    VASActivity localVASActivity = this.afQn;
    if (localVASActivity != null) {
      localVASActivity.onPrepareOptionsMenu(paramMenu);
    }
    AppMethodBeat.o(250051);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(250030);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    VASActivity localVASActivity = this.afQn;
    if (localVASActivity != null) {
      localVASActivity.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(250030);
  }
  
  public final void onResume()
  {
    View localView = null;
    AppMethodBeat.i(250016);
    Log.d(this.TAG, "onResume() called");
    super.onResume();
    Object localObject = getActivity();
    boolean bool1;
    if ((localObject instanceof VASCommonActivity))
    {
      ca(null);
      bool1 = isSupportNavigationSwipeBack();
      boolean bool2 = jEn();
      if (!bool1) {
        break label238;
      }
      localObject = ((VASCommonActivity)localObject).getSwipeBackLayout();
      if (localObject != null) {
        ((SwipeBackLayout)localObject).setEnableGesture(bool2);
      }
      localObject = this.mSwipeBackLayout;
      if (localObject != null)
      {
        if (bool2) {
          break label233;
        }
        bool1 = true;
        ((SwipeBackLayout)localObject).setEnableGesture(bool1);
      }
    }
    label99:
    localObject = this.afQA;
    label110:
    ViewParent localViewParent;
    if (localObject == null)
    {
      localObject = this.afQC;
      if ((localView != null) && (localObject != null))
      {
        localViewParent = localView.getParent();
        if (!(localViewParent instanceof ViewGroup)) {
          break label288;
        }
        if (!s.p(localViewParent, localObject))
        {
          ((ViewGroup)localViewParent).endViewTransition(localView);
          ((ViewGroup)localViewParent).removeView(localView);
          ((FrameLayout)localObject).removeAllViews();
          ((FrameLayout)localObject).addView(localView);
        }
      }
    }
    for (;;)
    {
      this.afQK = localView.getTranslationX();
      Log.d(this.TAG, "setLastFragmentBack maxTransX:" + this.afQK + " viewHash:" + localView.hashCode());
      AppMethodBeat.o(250016);
      return;
      label233:
      bool1 = false;
      break;
      label238:
      localObject = ((VASCommonActivity)localObject).getSwipeBackLayout();
      if (localObject != null) {
        ((SwipeBackLayout)localObject).setEnableGesture(false);
      }
      localObject = this.mSwipeBackLayout;
      if (localObject == null) {
        break label99;
      }
      ((SwipeBackLayout)localObject).setEnableGesture(false);
      break label99;
      localView = ((VASCommonFragment)localObject).afQB;
      break label110;
      label288:
      if (localViewParent == null)
      {
        ((FrameLayout)localObject).removeAllViews();
        ((FrameLayout)localObject).addView(localView);
      }
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(250010);
    s.u(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    Log.d(this.TAG, s.X("onSaveInstanceState() called with: outState = ", paramBundle));
    VASActivity localVASActivity = this.afQn;
    if (localVASActivity == null) {}
    for (int i = 0;; i = localVASActivity.getActionbarColor())
    {
      paramBundle.putInt("KEY_ACTIONBAR_COLOR", i);
      AppMethodBeat.o(250010);
      return;
    }
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(250008);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    Log.d(this.TAG, "onViewCreated() called with: view = " + paramView + ", savedInstanceState = " + paramBundle);
    this.afQD = paramView.findViewById(a.g.layout_actionbar_wrapper);
    this.afQE = paramView.findViewById(a.g.action_bar_root);
    this.afQF = paramView.findViewById(a.g.v_statusbar);
    this.afQG = paramView.findViewById(a.g.v_navigation_bar);
    paramView = this.afQn;
    if (paramView != null) {
      getLifecycle().addObserver((p)paramView);
    }
    ca(paramBundle);
    AppMethodBeat.o(250008);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(250081);
    int i;
    if (paramBoolean)
    {
      VASActivity localVASActivity;
      if (!(getActivity() instanceof VASCommonActivity))
      {
        localVASActivity = this.afQn;
        if ((localVASActivity == null) || (localVASActivity.getDisableCommonAreaControl())) {
          break label81;
        }
        i = 1;
        if (i == 0) {}
      }
      else
      {
        localVASActivity = this.afQn;
        if ((localVASActivity == null) || (localVASActivity.isFullScreen() != true)) {
          break label86;
        }
      }
    }
    label81:
    label86:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      Nf(paramBoolean);
      AppMethodBeat.o(250081);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setArguments(Bundle paramBundle)
  {
    AppMethodBeat.i(249981);
    super.setArguments(paramBundle);
    this.intent = new Intent();
    Intent localIntent = this.intent;
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localIntent.putExtras(localBundle);
    AppMethodBeat.o(249981);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(250038);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    VASActivity localVASActivity = this.afQn;
    if (localVASActivity != null) {
      localVASActivity.superImportUIComponents(paramHashSet);
    }
    AppMethodBeat.o(250038);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/VASCommonFragment$Companion;", "", "()V", "KEY_ACTIONBAR_COLOR", "", "sDisableAnim", "", "getSDisableAnim", "()Z", "setSDisableAnim", "(Z)V", "newInstance", "Lcom/tencent/mm/ui/vas/VASCommonFragment;", "param", "Landroid/os/Bundle;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static VASCommonFragment cb(Bundle paramBundle)
    {
      AppMethodBeat.i(249976);
      VASCommonFragment localVASCommonFragment = new VASCommonFragment();
      Bundle localBundle = new Bundle();
      if (paramBundle != null) {
        localBundle.putAll(paramBundle);
      }
      paramBundle = ah.aiuX;
      localVASCommonFragment.setArguments(localBundle);
      AppMethodBeat.o(249976);
      return localVASCommonFragment;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/vas/VASCommonFragment$initSwipeBack$1", "Lcom/tencent/mm/ui/widget/SwipeBackLayout$ISwipeGestureDelegate;", "onCancel", "", "onDrag", "onSwipeBack", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements SwipeBackLayout.b
  {
    b(VASCommonFragment paramVASCommonFragment) {}
    
    public final void onCancel()
    {
      AppMethodBeat.i(249978);
      Log.d(this.afQL.TAG, "onCancelDrag: ");
      AppMethodBeat.o(249978);
    }
    
    public final void onDrag()
    {
      AppMethodBeat.i(249980);
      Log.d(this.afQL.TAG, "onDragBegin: ");
      AppMethodBeat.o(249980);
    }
    
    public final void onSwipeBack()
    {
      AppMethodBeat.i(249974);
      Object localObject = this.afQL;
      Log.d(((VASCommonFragment)localObject).TAG, "onSwipeBack: ");
      localObject = ((VASCommonFragment)localObject).afQn;
      if (localObject != null) {
        ((VASActivity)localObject).finishWithNoAnim();
      }
      AppMethodBeat.o(249974);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/vas/VASCommonFragment$mController$1", "Lcom/tencent/mm/ui/MMActivityController;", "mMenuInflater", "Landroid/view/MenuInflater;", "addIconOptionMenu", "", "menuID", "", "titleRes", "iconID", "clickListener", "Landroid/view/MenuItem$OnMenuItemClickListener;", "title", "", "createMenu", "Landroidx/appcompat/view/menu/MenuBuilder;", "dealContentView", "v", "Landroid/view/View;", "fromFullScreenActivity", "", "getClassName", "getContentView", "getContext", "Landroidx/appcompat/app/AppCompatActivity;", "getCustomBounceId", "getIdentString", "getLayoutId", "getLayoutView", "getMenuInflater", "isActionbarMenuUseOriginalSys", "isFromFragment", "isRootLayoutInCenter", "needResetStatusBarColorOnActivityCreate", "noActionBar", "onCreateBeforeSetContentView", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onKeyboardStateChanged", "onPrepareOptionsMenu", "setActionbarColor", "actionbarColor", "setNavigationbarColor", "color", "supportInvalidateOptionsMenu", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends y
  {
    private MenuInflater gS;
    
    c(VASCommonFragment paramVASCommonFragment) {}
    
    public final String Dy()
    {
      AppMethodBeat.i(250014);
      String str = this.afQL.getClass().getName();
      s.s(str, "this@VASCommonFragment.javaClass.name");
      AppMethodBeat.o(250014);
      return str;
    }
    
    public final void addIconOptionMenu(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
    {
      AppMethodBeat.i(250042);
      super.addIconOptionMenu(paramInt1, paramInt2, paramInt3, paramOnMenuItemClickListener);
      AppMethodBeat.o(250042);
    }
    
    public final void addIconOptionMenu(int paramInt1, String paramString, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
    {
      AppMethodBeat.i(250039);
      super.addIconOptionMenu(paramInt1, paramString, paramInt2, paramOnMenuItemClickListener);
      AppMethodBeat.o(250039);
    }
    
    public final void dealContentView(View paramView) {}
    
    public final boolean fromFullScreenActivity()
    {
      return false;
    }
    
    public final View getContentView()
    {
      AppMethodBeat.i(249986);
      View localView = super.getContentView();
      s.s(localView, "super.getContentView()");
      AppMethodBeat.o(249986);
      return localView;
    }
    
    public final AppCompatActivity getContext()
    {
      return (AppCompatActivity)this.afQL.afQn;
    }
    
    public final int getCustomBounceId()
    {
      AppMethodBeat.i(250029);
      VASActivity localVASActivity = this.afQL.afQn;
      if (localVASActivity == null) {}
      for (int i = -1; i != -1; i = localVASActivity._getCustomBounceId())
      {
        AppMethodBeat.o(250029);
        return i;
      }
      i = VASCommonFragment.getCustomBounceId();
      AppMethodBeat.o(250029);
      return i;
    }
    
    public final String getIdentString()
    {
      return "";
    }
    
    public final int getLayoutId()
    {
      AppMethodBeat.i(249990);
      int i = this.afQL.getLayoutId();
      AppMethodBeat.o(249990);
      return i;
    }
    
    public final View getLayoutView()
    {
      AppMethodBeat.i(250005);
      VASCommonFragment localVASCommonFragment = this.afQL;
      View localView = LayoutInflater.from((Context)localVASCommonFragment.afQn).inflate(a.h.fragment_common_vas, null);
      Object localObject1 = localVASCommonFragment.afQn;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!(localObject1 instanceof b)) {
          break label122;
        }
        localObject1 = (b)localObject1;
      }
      Object localObject2;
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject1 = ((b)localObject1).afQo;
          if (localObject1 != null)
          {
            localObject2 = (FrameLayout)localView.findViewById(a.g.layout_actionbar_wrapper);
            localObject3 = ((FrameLayout)localObject2).getLayoutParams();
            ViewParent localViewParent = ((FrameLayout)localObject2).getParent();
            if (localViewParent == null)
            {
              localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
              AppMethodBeat.o(250005);
              throw ((Throwable)localObject1);
              localObject1 = ((VASActivity)localObject1).getMActionBar();
              break;
              label122:
              localObject1 = null;
              continue;
            }
            int i = ((ViewGroup)localViewParent).indexOfChild((View)localObject2);
            ((ViewGroup)localViewParent).removeView((View)localObject2);
            ((ViewGroup)localViewParent).addView((View)localObject1, i, (ViewGroup.LayoutParams)localObject3);
          }
        }
      }
      Object localObject3 = (FrameLayout)localView.findViewById(a.g.layout_custom);
      localObject1 = VASActivity.Companion;
      localObject1 = localVASCommonFragment.afQn;
      if (localObject1 == null)
      {
        localObject1 = "";
        if (VASActivity.a.jEh().aVz((String)localObject1))
        {
          localObject1 = ((FrameLayout)localObject3).getLayoutParams();
          if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
            break label324;
          }
        }
      }
      label324:
      for (localObject1 = (ViewGroup.MarginLayoutParams)localObject1;; localObject1 = null)
      {
        if (localObject1 != null)
        {
          ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
          ((FrameLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        ((FrameLayout)localObject3).addView(LayoutInflater.from((Context)localVASCommonFragment.afQn).inflate(localVASCommonFragment.getLayoutId(), null));
        localVASCommonFragment.afQH = ((FrameLayout)localObject3);
        s.s(localView, "root");
        AppMethodBeat.o(250005);
        return localView;
        localObject1 = localObject1.getClass();
        if (localObject1 == null)
        {
          localObject1 = "";
          break;
        }
        localObject2 = ((Class)localObject1).getName();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = "";
        break;
      }
    }
    
    public final boolean isActionbarMenuUseOriginalSys()
    {
      return false;
    }
    
    public final boolean jjN()
    {
      return true;
    }
    
    public final boolean jjO()
    {
      return false;
    }
    
    public final boolean needResetStatusBarColorOnActivityCreate()
    {
      return false;
    }
    
    public final boolean noActionBar()
    {
      AppMethodBeat.i(250022);
      boolean bool = VASCommonFragment.noActionBar();
      AppMethodBeat.o(250022);
      return bool;
    }
    
    public final void onCreateBeforeSetContentView() {}
    
    public final boolean onCreateOptionsMenu(Menu paramMenu)
    {
      AppMethodBeat.i(250046);
      boolean bool = super.onCreateOptionsMenu(paramMenu);
      AppMethodBeat.o(250046);
      return bool;
    }
    
    public final void onKeyboardStateChanged() {}
    
    public final boolean onPrepareOptionsMenu(Menu paramMenu)
    {
      AppMethodBeat.i(250052);
      boolean bool = super.onPrepareOptionsMenu(paramMenu);
      AppMethodBeat.o(250052);
      return bool;
    }
    
    public final void setActionbarColor(int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(250032);
      Object localObject = this.afQL.afQn;
      if ((localObject != null) && (((VASActivity)localObject).isGetFragment() == true)) {}
      for (;;)
      {
        if (i == 0) {
          super.setActionbarColor(paramInt);
        }
        localObject = this.adDT;
        if (localObject != null) {
          ((com.tencent.mm.ui.widget.pulldown.f)localObject).setStart2EndBgColorByActionBar(paramInt);
        }
        localObject = this.afQL.afQE;
        if (localObject != null) {
          ((View)localObject).setBackgroundColor(paramInt);
        }
        localObject = this.afQL.afQF;
        if (localObject != null) {
          ((View)localObject).setBackgroundColor(paramInt);
        }
        AppMethodBeat.o(250032);
        return;
        i = 0;
      }
    }
    
    public final void setNavigationbarColor(int paramInt)
    {
      AppMethodBeat.i(250035);
      super.setNavigationbarColor(paramInt);
      Object localObject = this.adDT;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.pulldown.f)localObject).setEnd2StartBgColorByNavigationBar(paramInt);
      }
      localObject = this.afQL.afQG;
      if (localObject != null) {
        ((View)localObject).setBackgroundColor(paramInt);
      }
      AppMethodBeat.o(250035);
    }
    
    public final void supportInvalidateOptionsMenu()
    {
      AppMethodBeat.i(250059);
      h localh = new h((Context)this.afQL.afQn);
      VASCommonFragment localVASCommonFragment = this.afQL;
      Menu localMenu = (Menu)localh;
      Object localObject;
      if (this.gS == null)
      {
        localObject = getSupportActionBar();
        if (localObject == null) {
          break label116;
        }
      }
      label116:
      for (this.gS = ((MenuInflater)new g(((ActionBar)localObject).bw()));; this.gS = ((MenuInflater)new g((Context)this.afQL.getActivity())))
      {
        localObject = this.gS;
        s.checkNotNull(localObject);
        localVASCommonFragment.onCreateOptionsMenu(localMenu, (MenuInflater)localObject);
        this.afQL.onPrepareOptionsMenu((Menu)localh);
        super.onCreateOptionsMenu((Menu)localh);
        AppMethodBeat.o(250059);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.VASCommonFragment
 * JD-Core Version:    0.7.0.1
 */