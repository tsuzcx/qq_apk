package com.tencent.mm.ui.component;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.z;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/component/UIComponentFragment;", "Landroid/support/v4/app/Fragment;", "()V", "focusState", "", "isShouldCreated", "", "mainUIC", "Lcom/tencent/mm/ui/component/UIComponent;", "pendingResumeAction", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "rootView", "Landroid/view/View;", "store", "Landroid/arch/lifecycle/ViewModelStore;", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getUiComponents", "()Ljava/util/HashSet;", "component", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "getMMActivity", "Lcom/tencent/mm/ui/MMActivity;", "getViewModelStore", "importUIComponents", "", "initializeUIC", "", "isUserVisibleFocused", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "onViewStateRestored", "Companion", "libmmui_release"})
public abstract class UIComponentFragment
  extends Fragment
{
  public static final a KiL = new a((byte)0);
  private UIComponent KiG;
  private final ViewModelStore KiH = new ViewModelStore();
  public int KiI;
  private boolean KiJ;
  public final LinkedList<Runnable> KiK = new LinkedList();
  private HashMap _$_findViewCache;
  private View kBS;
  final HashSet<UIComponent> uiComponents = new HashSet();
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public final <T extends ViewModel> T bj(Class<T> paramClass)
  {
    p.h(paramClass, "modelClass");
    a locala = a.KiD;
    paramClass = a.of((Fragment)this).get(paramClass);
    p.g(paramClass, "UICProvider.of(this).get(modelClass)");
    return paramClass;
  }
  
  public abstract Set<Class<? extends UIComponent>> cCu();
  
  public void cKA()
  {
    if (this.KiI != 2)
    {
      ad.i("MicroMsg.UIComponentFragment", "[onViewUnFocused] " + getClass().getSimpleName() + '@' + hashCode());
      Iterator localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).cKA();
      }
      this.KiI = 2;
    }
  }
  
  public ViewModelStore getViewModelStore()
  {
    return this.KiH;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (this.KiJ)
    {
      ad.i("MicroMsg.UIComponentFragment", "[onActivityCreated] " + getClass().getSimpleName() + '@' + hashCode());
      Iterator localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).ad(paramBundle);
      }
      localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onCreate(paramBundle);
      }
      localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).ac(paramBundle);
      }
      this.KiJ = false;
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    paramContext = this.uiComponents;
    p.h(paramContext, "uiComponents");
    Object localObject1 = cCu();
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Class)((Iterator)localObject1).next();
        a locala = a.KiD;
        localObject2 = (UIComponent)a.of((Fragment)this).get((Class)localObject2);
        paramContext.add(localObject2);
        if (((UIComponent)localObject2).getLayoutId() == 0) {
          break label123;
        }
        this.KiG = ((UIComponent)localObject2);
        if (i != 0) {
          throw ((Throwable)new RuntimeException("don't has more one daemon uic"));
        }
        i = 1;
      }
    }
    label123:
    for (;;)
    {
      break;
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    p.h(paramLayoutInflater, "inflater");
    if (this.kBS == null)
    {
      paramLayoutInflater = z.jO(getContext());
      paramBundle = this.KiG;
      if (paramBundle != null) {}
      for (int i = paramBundle.getLayoutId();; i = 0)
      {
        paramLayoutInflater = paramLayoutInflater.inflate(i, paramViewGroup, false);
        ad.i("MicroMsg.UIComponentFragment", "[onCreateView] " + getClass().getSimpleName() + '@' + hashCode() + " uiComponents=" + this.uiComponents);
        paramViewGroup = ((Iterable)this.uiComponents).iterator();
        while (paramViewGroup.hasNext())
        {
          paramBundle = (UIComponent)paramViewGroup.next();
          p.g(paramLayoutInflater, "view");
          paramBundle.gQ(paramLayoutInflater);
        }
      }
      this.kBS = paramLayoutInflater;
      this.KiJ = true;
    }
    return this.kBS;
  }
  
  public void onDestroy()
  {
    ad.i("MicroMsg.UIComponentFragment", "[onDestroy] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    ad.i("MicroMsg.UIComponentFragment", "[onPause] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ad.i("MicroMsg.UIComponentFragment", "[onResume] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onResume();
    }
    localIterator = ((Iterable)this.KiK).iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.KiK.clear();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    p.h(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    paramBundle = ((Iterable)this.uiComponents).iterator();
    while (paramBundle.hasNext()) {
      paramBundle.next();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    ad.i("MicroMsg.UIComponentFragment", "[onStart] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    ad.i("MicroMsg.UIComponentFragment", "[onStop] " + getClass().getSimpleName() + '@' + hashCode());
    Object localObject = ((Iterable)this.uiComponents).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((UIComponent)((Iterator)localObject).next()).onStop();
    }
    localObject = getActivity();
    if ((localObject != null) && (((FragmentActivity)localObject).isFinishing() == true))
    {
      localObject = ((Iterable)this.uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).cOA();
      }
    }
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    paramBundle = ((Iterable)this.uiComponents).iterator();
    while (paramBundle.hasNext()) {
      paramBundle.next();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/component/UIComponentFragment$Companion;", "", "()V", "STATE_DEFAULT", "", "STATE_FOCUSED", "STATE_UN_FOCUSED", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(UIComponentFragment paramUIComponentFragment) {}
    
    public final void run()
    {
      AppMethodBeat.i(186603);
      ad.i("MicroMsg.UIComponentFragment", "[onViewFocused] " + this.KiM.getClass().getSimpleName() + '@' + this.KiM.hashCode() + " focusState=" + UIComponentFragment.a(this.KiM));
      Iterator localIterator = ((Iterable)this.KiM.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).cBA();
      }
      AppMethodBeat.o(186603);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponentFragment
 * JD-Core Version:    0.7.0.1
 */