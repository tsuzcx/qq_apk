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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.y;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/component/UIComponentFragment;", "Landroid/support/v4/app/Fragment;", "()V", "focusState", "", "isShouldCreated", "", "mainUIC", "Lcom/tencent/mm/ui/component/UIComponent;", "rootView", "Landroid/view/View;", "store", "Landroid/arch/lifecycle/ViewModelStore;", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getUiComponents", "()Ljava/util/HashSet;", "component", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "getMMActivity", "Lcom/tencent/mm/ui/MMActivity;", "getViewModelStore", "importUIComponents", "", "initializeUIC", "", "isUserVisibleFocused", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "onViewStateRestored", "Companion", "libmmui_release"})
public abstract class UIComponentFragment
  extends Fragment
{
  public static final a LDe = new a((byte)0);
  private UIComponent LDa;
  private final ViewModelStore LDb = new ViewModelStore();
  public int LDc;
  private boolean LDd;
  private HashMap _$_findViewCache;
  private View jGG;
  public final HashSet<UIComponent> uiComponents = new HashSet();
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public final <T extends ViewModel> T bF(Class<T> paramClass)
  {
    k.h(paramClass, "modelClass");
    a locala = a.LCX;
    paramClass = a.of((Fragment)this).get(paramClass);
    k.g(paramClass, "UICProvider.of(this).get(modelClass)");
    return paramClass;
  }
  
  public abstract Set<Class<? extends UIComponent>> fTM();
  
  public final void fTo()
  {
    if (this.LDc != 1)
    {
      ad.i("MicroMsg.UIComponentFragment", "[onViewFocused] " + getClass().getSimpleName() + '@' + hashCode() + " focusState=" + this.LDc);
      Iterator localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).fTo();
      }
      this.LDc = 1;
    }
  }
  
  public ViewModelStore getViewModelStore()
  {
    return this.LDb;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (this.LDd)
    {
      ad.i("MicroMsg.UIComponentFragment", "[onActivityCreated] " + getClass().getSimpleName() + '@' + hashCode());
      Iterator localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).be(paramBundle);
      }
      localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onCreate(paramBundle);
      }
      localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).ba(paramBundle);
      }
      this.LDd = false;
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    paramContext = this.uiComponents;
    k.h(paramContext, "uiComponents");
    Object localObject1 = fTM();
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Class)((Iterator)localObject1).next();
        a locala = a.LCX;
        localObject2 = (UIComponent)a.of((Fragment)this).get((Class)localObject2);
        paramContext.add(localObject2);
        if (((UIComponent)localObject2).getLayoutId() == 0) {
          break label123;
        }
        this.LDa = ((UIComponent)localObject2);
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
    k.h(paramLayoutInflater, "inflater");
    if (this.jGG == null)
    {
      paramLayoutInflater = y.js(getContext());
      paramBundle = this.LDa;
      if (paramBundle != null) {}
      for (int i = paramBundle.getLayoutId();; i = 0)
      {
        paramLayoutInflater = paramLayoutInflater.inflate(i, paramViewGroup, false);
        ad.i("MicroMsg.UIComponentFragment", "[onCreateView] " + getClass().getSimpleName() + '@' + hashCode() + " uiComponents=" + this.uiComponents);
        paramViewGroup = ((Iterable)this.uiComponents).iterator();
        while (paramViewGroup.hasNext())
        {
          paramBundle = (UIComponent)paramViewGroup.next();
          k.g(paramLayoutInflater, "view");
          paramBundle.gT(paramLayoutInflater);
        }
      }
      this.jGG = paramLayoutInflater;
      this.LDd = true;
    }
    return this.jGG;
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
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    k.h(paramBundle, "outState");
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
        ((UIComponent)((Iterator)localObject).next()).fXy();
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/component/UIComponentFragment$Companion;", "", "()V", "STATE_DEFAULT", "", "STATE_FOCUSED", "STATE_UN_FOCUSED", "TAG", "", "libmmui_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponentFragment
 * JD-Core Version:    0.7.0.1
 */