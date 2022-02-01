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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.z;
import d.g.b.k;
import d.l;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/component/UIComponentFragment;", "Landroid/support/v4/app/Fragment;", "()V", "focusState", "", "isShouldCreated", "", "mainUIC", "Lcom/tencent/mm/ui/component/UIComponent;", "pendingResumeAction", "Ljava/util/LinkedList;", "Ljava/lang/Runnable;", "rootView", "Landroid/view/View;", "store", "Landroid/arch/lifecycle/ViewModelStore;", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getUiComponents", "()Ljava/util/HashSet;", "component", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "getMMActivity", "Lcom/tencent/mm/ui/MMActivity;", "getViewModelStore", "importUIComponents", "", "initializeUIC", "", "isUserVisibleFocused", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "onViewStateRestored", "Companion", "libmmui_release"})
public abstract class UIComponentFragment
  extends Fragment
{
  public static final UIComponentFragment.a Isg = new UIComponentFragment.a((byte)0);
  private UIComponent Isb;
  private final ViewModelStore Isc = new ViewModelStore();
  public int Isd;
  private boolean Ise;
  public final LinkedList<Runnable> Isf = new LinkedList();
  private HashMap _$_findViewCache;
  private View khe;
  final HashSet<UIComponent> uiComponents = new HashSet();
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
  public final <T extends ViewModel> T bh(Class<T> paramClass)
  {
    k.h(paramClass, "modelClass");
    a locala = a.IrY;
    paramClass = a.of((Fragment)this).get(paramClass);
    k.g(paramClass, "UICProvider.of(this).get(modelClass)");
    return paramClass;
  }
  
  public final void cFW()
  {
    if (this.Isd != 2)
    {
      ac.i("MicroMsg.UIComponentFragment", "[onViewUnFocused] " + getClass().getSimpleName() + '@' + hashCode());
      Iterator localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).cFW();
      }
      this.Isd = 2;
    }
  }
  
  public abstract Set<Class<? extends UIComponent>> cwg();
  
  public ViewModelStore getViewModelStore()
  {
    return this.Isc;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (this.Ise)
    {
      ac.i("MicroMsg.UIComponentFragment", "[onActivityCreated] " + getClass().getSimpleName() + '@' + hashCode());
      Iterator localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).aa(paramBundle);
      }
      localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onCreate(paramBundle);
      }
      localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).Z(paramBundle);
      }
      this.Ise = false;
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    paramContext = this.uiComponents;
    k.h(paramContext, "uiComponents");
    Object localObject1 = cwg();
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Class)((Iterator)localObject1).next();
        a locala = a.IrY;
        localObject2 = (UIComponent)a.of((Fragment)this).get((Class)localObject2);
        paramContext.add(localObject2);
        if (((UIComponent)localObject2).getLayoutId() == 0) {
          break label123;
        }
        this.Isb = ((UIComponent)localObject2);
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
    if (this.khe == null)
    {
      paramLayoutInflater = z.jD(getContext());
      paramBundle = this.Isb;
      if (paramBundle != null) {}
      for (int i = paramBundle.getLayoutId();; i = 0)
      {
        paramLayoutInflater = paramLayoutInflater.inflate(i, paramViewGroup, false);
        ac.i("MicroMsg.UIComponentFragment", "[onCreateView] " + getClass().getSimpleName() + '@' + hashCode() + " uiComponents=" + this.uiComponents);
        paramViewGroup = ((Iterable)this.uiComponents).iterator();
        while (paramViewGroup.hasNext())
        {
          paramBundle = (UIComponent)paramViewGroup.next();
          k.g(paramLayoutInflater, "view");
          paramBundle.gz(paramLayoutInflater);
        }
      }
      this.khe = paramLayoutInflater;
      this.Ise = true;
    }
    return this.khe;
  }
  
  public void onDestroy()
  {
    ac.i("MicroMsg.UIComponentFragment", "[onDestroy] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    ac.i("MicroMsg.UIComponentFragment", "[onPause] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ac.i("MicroMsg.UIComponentFragment", "[onResume] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onResume();
    }
    localIterator = ((Iterable)this.Isf).iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.Isf.clear();
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
    ac.i("MicroMsg.UIComponentFragment", "[onStart] " + getClass().getSimpleName() + '@' + hashCode());
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    ac.i("MicroMsg.UIComponentFragment", "[onStop] " + getClass().getSimpleName() + '@' + hashCode());
    Object localObject = ((Iterable)this.uiComponents).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((UIComponent)((Iterator)localObject).next()).onStop();
    }
    localObject = getActivity();
    if ((localObject != null) && (((FragmentActivity)localObject).isFinishing() == true))
    {
      localObject = ((Iterable)this.uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).cGh();
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(UIComponentFragment paramUIComponentFragment) {}
    
    public final void run()
    {
      AppMethodBeat.i(197286);
      ac.i("MicroMsg.UIComponentFragment", "[onViewFocused] " + this.Ish.getClass().getSimpleName() + '@' + this.Ish.hashCode() + " focusState=" + UIComponentFragment.a(this.Ish));
      Iterator localIterator = ((Iterable)this.Ish.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).cvj();
      }
      AppMethodBeat.o(197286);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponentFragment
 * JD-Core Version:    0.7.0.1
 */