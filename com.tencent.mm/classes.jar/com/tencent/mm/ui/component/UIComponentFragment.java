package com.tencent.mm.ui.component;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.aa;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/component/UIComponentFragment;", "Landroidx/fragment/app/Fragment;", "()V", "focusState", "", "isShouldCreated", "", "()Z", "setShouldCreated", "(Z)V", "layoutUIC", "Lcom/tencent/mm/ui/component/UIComponent;", "getLayoutUIC", "()Lcom/tencent/mm/ui/component/UIComponent;", "setLayoutUIC", "(Lcom/tencent/mm/ui/component/UIComponent;)V", "modelStore", "Landroidx/lifecycle/ViewModelStore;", "pendingResumeAction", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getUiComponents", "()Ljava/util/HashSet;", "component", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "getLayoutId", "getViewModelStore", "importUIComponents", "", "initializeUIC", "", "isUserVisibleFocused", "mapStoreTo", "src", "dest", "isStore", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "any", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "onViewStateRestored", "Companion", "plugin-uic_release"})
public abstract class UIComponentFragment
  extends Fragment
{
  public static final a XoL = new a((byte)0);
  private int XoI;
  private boolean XoJ;
  private final LinkedList<Runnable> XoK = new LinkedList();
  private HashMap _$_findViewCache;
  private UIComponent layoutUIC;
  private aa modelStore;
  private View oFW;
  public final HashSet<UIComponent> uiComponents = new HashSet();
  
  private static void mapStoreTo(aa paramaa1, aa paramaa2, b<Object, Boolean> paramb)
  {
    if (paramaa1 == null) {}
    for (;;)
    {
      return;
      Object localObject = aa.class.getDeclaredField("aaP");
      p.j(localObject, "ViewModelStore::class.ja….getDeclaredField(\"mMap\")");
      ((Field)localObject).setAccessible(true);
      paramaa1 = ((Field)localObject).get(paramaa1);
      if (paramaa1 == null) {
        throw new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.Any, kotlin.Any> /* = java.util.HashMap<kotlin.Any, kotlin.Any> */");
      }
      paramaa1 = (HashMap)paramaa1;
      paramaa2 = ((Field)localObject).get(paramaa2);
      if (paramaa2 == null) {
        throw new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.Any, kotlin.Any> /* = java.util.HashMap<kotlin.Any, kotlin.Any> */");
      }
      paramaa2 = (HashMap)paramaa2;
      paramaa1 = ((Map)paramaa1).entrySet().iterator();
      while (paramaa1.hasNext())
      {
        localObject = (Map.Entry)paramaa1.next();
        if (((Boolean)paramb.invoke(((Map.Entry)localObject).getValue())).booleanValue()) {
          ((Map)paramaa2).put(((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
        }
      }
    }
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public final <T extends x> T component(Class<T> paramClass)
  {
    p.k(paramClass, "modelClass");
    g localg = g.Xox;
    paramClass = g.h((Fragment)this).i(paramClass);
    p.j(paramClass, "UICProvider.of(this).get(modelClass)");
    return paramClass;
  }
  
  public int getLayoutId()
  {
    UIComponent localUIComponent = this.layoutUIC;
    if (localUIComponent != null) {
      return localUIComponent.getLayoutId();
    }
    return 0;
  }
  
  protected final View getRootView()
  {
    return this.oFW;
  }
  
  public aa getViewModelStore()
  {
    aa localaa2 = this.modelStore;
    aa localaa1 = localaa2;
    if (localaa2 == null)
    {
      localaa1 = new aa();
      this.modelStore = localaa1;
    }
    return localaa1;
  }
  
  protected final void hUd()
  {
    this.XoJ = true;
  }
  
  public abstract Set<Class<? extends UIComponent>> importUIComponents();
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (this.XoJ)
    {
      Log.i("MicroMsg.UIComponentFragment", "[onActivityCreated] " + getClass().getSimpleName() + '@' + hashCode());
      Iterator localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onCreate(paramBundle);
      }
      localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onCreateAfter(paramBundle);
      }
      this.XoJ = false;
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    mapStoreTo(super.getViewModelStore(), getViewModelStore(), (b)UIComponentFragment.b.XoM);
    paramContext = this.uiComponents;
    p.k(paramContext, "uiComponents");
    Object localObject1 = importUIComponents();
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Class)((Iterator)localObject1).next();
        g localg = g.Xox;
        localObject2 = (UIComponent)g.h((Fragment)this).i((Class)localObject2);
        paramContext.add(localObject2);
        if (((UIComponent)localObject2).getLayoutId() == 0) {
          break label206;
        }
        this.layoutUIC = ((UIComponent)localObject2);
        if (i != 0) {
          throw ((Throwable)new RuntimeException("already layout uic[" + this.layoutUIC + "], no more than one layout uic."));
        }
        i = 1;
      }
    }
    label206:
    for (;;)
    {
      break;
      paramContext = ((Iterable)this.uiComponents).iterator();
      while (paramContext.hasNext()) {
        ((UIComponent)paramContext.next()).setArguments(getArguments());
      }
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onConfigurationChanged(paramConfiguration);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    p.k(paramLayoutInflater, "inflater");
    if (this.oFW == null)
    {
      paramLayoutInflater = LayoutInflater.from(getContext()).inflate(getLayoutId(), paramViewGroup, false);
      Log.i("MicroMsg.UIComponentFragment", "[onCreateView] " + getClass().getSimpleName() + '@' + hashCode() + " uiComponents=" + this.uiComponents);
      paramViewGroup = ((Iterable)this.uiComponents).iterator();
      while (paramViewGroup.hasNext())
      {
        UIComponent localUIComponent = (UIComponent)paramViewGroup.next();
        p.j(paramLayoutInflater, "view");
        localUIComponent.setRootView(paramLayoutInflater);
      }
      this.oFW = paramLayoutInflater;
      paramLayoutInflater = ((Iterable)this.uiComponents).iterator();
      while (paramLayoutInflater.hasNext()) {
        ((UIComponent)paramLayoutInflater.next()).onCreateBefore(paramBundle);
      }
      this.XoJ = true;
    }
    return this.oFW;
  }
  
  public void onDestroy()
  {
    Object localObject = ((Iterable)this.uiComponents).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((UIComponent)((Iterator)localObject).next()).onDestroy();
    }
    localObject = this.modelStore;
    aa localaa = super.getViewModelStore();
    p.j(localaa, "super.getViewModelStore()");
    mapStoreTo((aa)localObject, localaa, (b)c.XoN);
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    Log.i("MicroMsg.UIComponentFragment", "[onPause] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Log.i("MicroMsg.UIComponentFragment", "[onResume] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onResume();
    }
    localIterator = ((Iterable)this.XoK).iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.XoK.clear();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    p.k(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onSaveInstanceState(paramBundle);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    Log.i("MicroMsg.UIComponentFragment", "[onStart] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Log.i("MicroMsg.UIComponentFragment", "[onStop] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onStop();
    }
  }
  
  public void onUserVisibleFocused()
  {
    Object localObject = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.j(localLooper, "Looper.getMainLooper()");
    if (!p.h(localObject, localLooper.getThread())) {
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    if (this.XoI != 1)
    {
      localObject = (Runnable)new d(this);
      if (isResumed()) {
        break label94;
      }
      Log.w("MicroMsg.UIComponentFragment", "[onUserVisibleFocused] wait to fragment resume.");
      this.XoK.add(localObject);
    }
    for (;;)
    {
      this.XoI = 1;
      return;
      label94:
      ((Runnable)localObject).run();
    }
  }
  
  public void onUserVisibleUnFocused()
  {
    Object localObject = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.j(localLooper, "Looper.getMainLooper()");
    if (!p.h(localObject, localLooper.getThread())) {
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    if (this.XoI != 2)
    {
      Log.i("MicroMsg.UIComponentFragment", "[onViewUnFocused] " + getClass().getSimpleName() + '@' + hashCode());
      localObject = ((Iterable)this.uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onUserVisibleUnFocused();
      }
      this.XoI = 2;
    }
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onRestoreInstanceState(paramBundle);
    }
  }
  
  protected final void setRootView(View paramView)
  {
    this.oFW = paramView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/component/UIComponentFragment$Companion;", "", "()V", "STATE_DEFAULT", "", "STATE_FOCUSED", "STATE_UN_FOCUSED", "TAG", "", "plugin-uic_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "model", "", "invoke"})
  static final class c
    extends q
    implements b<Object, Boolean>
  {
    public static final c XoN;
    
    static
    {
      AppMethodBeat.i(231509);
      XoN = new c();
      AppMethodBeat.o(231509);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(UIComponentFragment paramUIComponentFragment) {}
    
    public final void run()
    {
      AppMethodBeat.i(231440);
      Log.i("MicroMsg.UIComponentFragment", "[onViewFocused] " + this.XoO.getClass().getSimpleName() + '@' + this.XoO.hashCode() + " focusState=" + UIComponentFragment.a(this.XoO));
      Iterator localIterator = ((Iterable)this.XoO.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onUserVisibleFocused();
      }
      AppMethodBeat.o(231440);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponentFragment
 * JD-Core Version:    0.7.0.1
 */