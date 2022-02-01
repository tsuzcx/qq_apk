package com.tencent.mm.ui.vas.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.af;
import androidx.lifecycle.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.component.q;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/fragment/VASBaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "focusState", "", "isActivityCreatedCalled", "", "()Z", "setActivityCreatedCalled", "(Z)V", "layoutUIC", "Lcom/tencent/mm/ui/component/UIComponent;", "getLayoutUIC", "()Lcom/tencent/mm/ui/component/UIComponent;", "setLayoutUIC", "(Lcom/tencent/mm/ui/component/UIComponent;)V", "modelStore", "Landroidx/lifecycle/ViewModelStore;", "pendingResumeAction", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getUiComponents", "()Ljava/util/HashSet;", "component", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "getContentView", "getLayoutId", "getViewModelStore", "importUIComponents", "", "initializeUIC", "", "isUserVisibleFocused", "mapStoreTo", "src", "dest", "isStore", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "any", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityPostDestroyed", "onActivityPreDestroyed", "onAttach", "context", "Landroid/content/Context;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "onViewCreated", "view", "onViewStateRestored", "superImportUIComponents", "set", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class VASBaseFragment
  extends Fragment
{
  public static final VASBaseFragment.a afRa = new VASBaseFragment.a((byte)0);
  private final String TAG = s.X("MicroMsg.VAS.VASBaseFragment@", Integer.valueOf(hashCode()));
  private final LinkedList<Runnable> aeZR = new LinkedList();
  private boolean afRb;
  private UIComponent layoutUIC;
  private aj modelStore;
  private View rootView;
  public final HashSet<UIComponent> uiComponents = new HashSet();
  
  private void initializeUIC(HashSet<UIComponent> paramHashSet)
  {
    s.u(paramHashSet, "uiComponents");
    Object localObject = new HashSet();
    superImportUIComponents((HashSet)localObject);
    int i = 0;
    localObject = ((Iterable)localObject).iterator();
    if (((Iterator)localObject).hasNext())
    {
      UIComponent localUIComponent = (UIComponent)component((Class)((Iterator)localObject).next());
      paramHashSet.add(localUIComponent);
      if (localUIComponent.getLayoutId() == 0) {
        break label121;
      }
      this.layoutUIC = localUIComponent;
      if (i != 0) {
        throw new RuntimeException("already layout uic[" + this.layoutUIC + "], no more than one layout uic.");
      }
      i = 1;
    }
    label121:
    for (;;)
    {
      break;
      return;
    }
  }
  
  private static void mapStoreTo(aj paramaj1, aj paramaj2, b<Object, Boolean> paramb)
  {
    if (paramaj1 == null) {}
    for (;;)
    {
      return;
      Object localObject = aj.class.getDeclaredField("bIx");
      ((Field)localObject).setAccessible(true);
      paramaj1 = ((Field)localObject).get(paramaj1);
      if (paramaj1 == null) {
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.Any, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.Any, kotlin.Any> }");
      }
      paramaj1 = (HashMap)paramaj1;
      paramaj2 = ((Field)localObject).get(paramaj2);
      if (paramaj2 == null) {
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.Any, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.Any, kotlin.Any> }");
      }
      paramaj2 = (HashMap)paramaj2;
      paramaj1 = ((Map)paramaj1).entrySet().iterator();
      while (paramaj1.hasNext())
      {
        localObject = (Map.Entry)paramaj1.next();
        if (((Boolean)paramb.invoke(((Map.Entry)localObject).getValue())).booleanValue()) {
          ((Map)paramaj2).put(((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
        }
      }
    }
  }
  
  public <T extends af> T component(Class<T> paramClass)
  {
    s.u(paramClass, "modelClass");
    k localk = k.aeZF;
    paramClass = k.y((Fragment)this).q(paramClass);
    s.s(paramClass, "UICProvider.of(this).get(modelClass)");
    return paramClass;
  }
  
  public final View getContentView()
  {
    return this.rootView;
  }
  
  public int getLayoutId()
  {
    UIComponent localUIComponent = this.layoutUIC;
    if (localUIComponent == null) {
      return 0;
    }
    return localUIComponent.getLayoutId();
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public aj getViewModelStore()
  {
    aj localaj2 = this.modelStore;
    aj localaj1 = localaj2;
    if (localaj2 == null)
    {
      localaj1 = (aj)new q();
      this.modelStore = localaj1;
    }
    return localaj1;
  }
  
  public abstract Set<Class<? extends UIComponent>> importUIComponents();
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    Log.i(getTAG(), "[onActivityCreated] " + getClass().getSimpleName() + '@' + hashCode());
    if (!this.afRb)
    {
      this.afRb = true;
      Iterator localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onCreate(paramBundle);
      }
      localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onCreateAfter(paramBundle);
      }
    }
  }
  
  public void onAttach(Context paramContext)
  {
    s.u(paramContext, "context");
    super.onAttach(paramContext);
    Log.i(getTAG(), "[onAttach] " + getClass().getSimpleName() + '@' + hashCode());
    mapStoreTo(super.getViewModelStore(), getViewModelStore(), (b)VASBaseFragment.b.afRc);
    initializeUIC(this.uiComponents);
    paramContext = ((Iterable)this.uiComponents).iterator();
    while (paramContext.hasNext()) {
      ((UIComponent)paramContext.next()).setArguments(getArguments());
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i(getTAG(), "[onConfigurationChanged] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onConfigurationChanged(paramConfiguration);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    s.u(paramLayoutInflater, "inflater");
    paramLayoutInflater = LayoutInflater.from(getContext()).inflate(getLayoutId(), paramViewGroup, false);
    Log.i(getTAG(), "[onCreateView] " + getClass().getSimpleName() + '@' + hashCode() + " uiComponents=" + this.uiComponents);
    paramViewGroup = ((Iterable)this.uiComponents).iterator();
    while (paramViewGroup.hasNext())
    {
      UIComponent localUIComponent = (UIComponent)paramViewGroup.next();
      s.s(paramLayoutInflater, "view");
      localUIComponent.setRootView(paramLayoutInflater);
    }
    this.rootView = paramLayoutInflater;
    paramViewGroup = ((Iterable)this.uiComponents).iterator();
    while (paramViewGroup.hasNext()) {
      ((UIComponent)paramViewGroup.next()).onCreateBefore(paramBundle);
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.rootView == null)
    {
      Log.d(getTAG(), "[onDestroy] exception fold " + getClass().getSimpleName() + '@' + hashCode());
      super.onDestroy();
    }
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onPreDestroyed();
      }
      super.onDestroy();
      Log.i(getTAG(), "[onDestroy] " + getClass().getSimpleName() + '@' + hashCode());
      localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onDestroy();
      }
      localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onPostDestroyed();
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onPause()
  {
    super.onPause();
    Log.i(getTAG(), "[onPause] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Log.i(getTAG(), "[onResume] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onResume();
    }
    localIterator = ((Iterable)this.aeZR).iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.aeZR.clear();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    s.u(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onSaveInstanceState(paramBundle);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    Log.i(getTAG(), "[onStart] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Log.i(getTAG(), "[onStop] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onStop();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    Log.i(getTAG(), "[onViewCreated] " + getClass().getSimpleName() + '@' + hashCode());
    paramBundle = ((Iterable)this.uiComponents).iterator();
    while (paramBundle.hasNext()) {
      ((UIComponent)paramBundle.next()).onViewCreated(paramView);
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
    this.rootView = paramView;
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    s.u(paramHashSet, "set");
    Set localSet = importUIComponents();
    if (localSet != null) {
      paramHashSet.addAll((Collection)p.o((Iterable)localSet));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.fragment.VASBaseFragment
 * JD-Core Version:    0.7.0.1
 */