package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/component/UIComponentFragment;", "Landroid/support/v4/app/Fragment;", "()V", "focusState", "", "isShouldCreated", "", "()Z", "setShouldCreated", "(Z)V", "layoutUIC", "Lcom/tencent/mm/ui/component/UIComponent;", "getLayoutUIC", "()Lcom/tencent/mm/ui/component/UIComponent;", "setLayoutUIC", "(Lcom/tencent/mm/ui/component/UIComponent;)V", "modelStore", "Landroid/arch/lifecycle/ViewModelStore;", "pendingResumeAction", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getUiComponents", "()Ljava/util/HashSet;", "component", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "getLayoutId", "getViewModelStore", "importUIComponents", "", "initializeUIC", "", "isUserVisibleFocused", "mapStoreTo", "src", "dest", "isStore", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "any", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "onViewStateRestored", "Companion", "libmmui_release"})
public abstract class UIComponentFragment
  extends Fragment
{
  public static final a PRZ = new a((byte)0);
  private int PRW;
  protected boolean PRX;
  private final LinkedList<Runnable> PRY = new LinkedList();
  private HashMap _$_findViewCache;
  protected View lJI;
  private UIComponent layoutUIC;
  private ViewModelStore modelStore;
  public final HashSet<UIComponent> uiComponents = new HashSet();
  
  private static void mapStoreTo(ViewModelStore paramViewModelStore1, ViewModelStore paramViewModelStore2, b<Object, Boolean> paramb)
  {
    if (paramViewModelStore1 == null) {}
    for (;;)
    {
      return;
      Object localObject = ViewModelStore.class.getDeclaredField("mMap");
      p.g(localObject, "ViewModelStore::class.ja….getDeclaredField(\"mMap\")");
      ((Field)localObject).setAccessible(true);
      paramViewModelStore1 = ((Field)localObject).get(paramViewModelStore1);
      if (paramViewModelStore1 == null) {
        throw new t("null cannot be cast to non-null type java.util.HashMap<kotlin.Any, kotlin.Any>");
      }
      paramViewModelStore1 = (HashMap)paramViewModelStore1;
      paramViewModelStore2 = ((Field)localObject).get(paramViewModelStore2);
      if (paramViewModelStore2 == null) {
        throw new t("null cannot be cast to non-null type java.util.HashMap<kotlin.Any, kotlin.Any>");
      }
      paramViewModelStore2 = (HashMap)paramViewModelStore2;
      paramViewModelStore1 = ((Map)paramViewModelStore1).entrySet().iterator();
      while (paramViewModelStore1.hasNext())
      {
        localObject = (Map.Entry)paramViewModelStore1.next();
        if (((Boolean)paramb.invoke(((Map.Entry)localObject).getValue())).booleanValue()) {
          ((Map)paramViewModelStore2).put(((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
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
  
  public final <T extends ViewModel> T component(Class<T> paramClass)
  {
    p.h(paramClass, "modelClass");
    a locala = a.PRN;
    paramClass = a.of((Fragment)this).get(paramClass);
    p.g(paramClass, "UICProvider.of(this).get(modelClass)");
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
  
  public ViewModelStore getViewModelStore()
  {
    ViewModelStore localViewModelStore2 = this.modelStore;
    ViewModelStore localViewModelStore1 = localViewModelStore2;
    if (localViewModelStore2 == null)
    {
      localViewModelStore1 = new ViewModelStore();
      mapStoreTo(super.getViewModelStore(), localViewModelStore1, (b)b.PSa);
      this.modelStore = localViewModelStore1;
    }
    return localViewModelStore1;
  }
  
  public abstract Set<Class<? extends UIComponent>> importUIComponents();
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (this.PRX)
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
      this.PRX = false;
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    paramContext = this.uiComponents;
    p.h(paramContext, "uiComponents");
    Object localObject1 = importUIComponents();
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Class)((Iterator)localObject1).next();
        a locala = a.PRN;
        localObject2 = (UIComponent)a.of((Fragment)this).get((Class)localObject2);
        paramContext.add(localObject2);
        if (((UIComponent)localObject2).getLayoutId() == 0) {
          break label189;
        }
        this.layoutUIC = ((UIComponent)localObject2);
        if (i != 0) {
          throw ((Throwable)new RuntimeException("already layout uic[" + this.layoutUIC + "], no more than one layout uic."));
        }
        i = 1;
      }
    }
    label189:
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
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onConfigurationChanged(paramConfiguration);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    p.h(paramLayoutInflater, "inflater");
    if (this.lJI == null)
    {
      paramLayoutInflater = aa.jQ(getContext()).inflate(getLayoutId(), paramViewGroup, false);
      Log.i("MicroMsg.UIComponentFragment", "[onCreateView] " + getClass().getSimpleName() + '@' + hashCode() + " uiComponents=" + this.uiComponents);
      paramViewGroup = ((Iterable)this.uiComponents).iterator();
      while (paramViewGroup.hasNext())
      {
        UIComponent localUIComponent = (UIComponent)paramViewGroup.next();
        p.g(paramLayoutInflater, "view");
        localUIComponent.setRootView(paramLayoutInflater);
      }
      this.lJI = paramLayoutInflater;
      paramLayoutInflater = ((Iterable)this.uiComponents).iterator();
      while (paramLayoutInflater.hasNext()) {
        ((UIComponent)paramLayoutInflater.next()).onCreateBefore(paramBundle);
      }
      this.PRX = true;
    }
    return this.lJI;
  }
  
  public void onDestroy()
  {
    Object localObject = ((Iterable)this.uiComponents).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((UIComponent)((Iterator)localObject).next()).onDestroy();
    }
    localObject = this.modelStore;
    ViewModelStore localViewModelStore = super.getViewModelStore();
    p.g(localViewModelStore, "super.getViewModelStore()");
    mapStoreTo((ViewModelStore)localObject, localViewModelStore, (b)c.PSb);
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
    localIterator = ((Iterable)this.PRY).iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.PRY.clear();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    p.h(paramBundle, "outState");
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
    p.g(localLooper, "Looper.getMainLooper()");
    if (!p.j(localObject, localLooper.getThread())) {
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    if (this.PRW != 1)
    {
      localObject = (Runnable)new d(this);
      if (isResumed()) {
        break label94;
      }
      Log.w("MicroMsg.UIComponentFragment", "[onUserVisibleFocused] wait to fragment resume.");
      this.PRY.add(localObject);
    }
    for (;;)
    {
      this.PRW = 1;
      return;
      label94:
      ((Runnable)localObject).run();
    }
  }
  
  public void onUserVisibleUnFocused()
  {
    Object localObject = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.g(localLooper, "Looper.getMainLooper()");
    if (!p.j(localObject, localLooper.getThread())) {
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    if (this.PRW != 2)
    {
      Log.i("MicroMsg.UIComponentFragment", "[onViewUnFocused] " + getClass().getSimpleName() + '@' + hashCode());
      localObject = ((Iterable)this.uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onUserVisibleUnFocused();
      }
      this.PRW = 2;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/component/UIComponentFragment$Companion;", "", "()V", "STATE_DEFAULT", "", "STATE_FOCUSED", "STATE_UN_FOCUSED", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements b<Object, Boolean>
  {
    public static final b PSa;
    
    static
    {
      AppMethodBeat.i(204842);
      PSa = new b();
      AppMethodBeat.o(204842);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "model", "", "invoke"})
  static final class c
    extends q
    implements b<Object, Boolean>
  {
    public static final c PSb;
    
    static
    {
      AppMethodBeat.i(204844);
      PSb = new c();
      AppMethodBeat.o(204844);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(UIComponentFragment paramUIComponentFragment) {}
    
    public final void run()
    {
      AppMethodBeat.i(204845);
      Log.i("MicroMsg.UIComponentFragment", "[onViewFocused] " + this.PSc.getClass().getSimpleName() + '@' + this.PSc.hashCode() + " focusState=" + UIComponentFragment.a(this.PSc));
      Iterator localIterator = ((Iterable)this.PSc.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onUserVisibleFocused();
      }
      AppMethodBeat.o(204845);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponentFragment
 * JD-Core Version:    0.7.0.1
 */