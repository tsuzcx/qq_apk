package com.tencent.mm.ui.component;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStore;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/component/UIComponentActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mainUIC", "Lcom/tencent/mm/ui/component/UIComponent;", "store", "Landroid/arch/lifecycle/ViewModelStore;", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "component", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "getLayoutId", "", "getViewModelStore", "importUIComponents", "", "initializeUIC", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "libmmui_release"})
public abstract class UIComponentActivity
  extends MMActivity
{
  private UIComponent KFa;
  private final ViewModelStore KFb = new ViewModelStore();
  private HashMap _$_findViewCache;
  private final HashSet<UIComponent> uiComponents = new HashSet();
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  protected void b(HashSet<UIComponent> paramHashSet)
  {
    p.h(paramHashSet, "uiComponents");
    Object localObject1 = cEg();
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Class)((Iterator)localObject1).next();
        a locala = a.KEX;
        localObject2 = (UIComponent)a.s((MMActivity)this).get((Class)localObject2);
        paramHashSet.add(localObject2);
        if (((UIComponent)localObject2).getLayoutId() == 0) {
          break label113;
        }
        this.KFa = ((UIComponent)localObject2);
        if (i != 0) {
          throw ((Throwable)new RuntimeException("don't has more one daemon uic"));
        }
        i = 1;
      }
    }
    label113:
    for (;;)
    {
      break;
      return;
    }
  }
  
  public final <T extends ViewModel> T bj(Class<T> paramClass)
  {
    p.h(paramClass, "modelClass");
    a locala = a.KEX;
    paramClass = a.s((MMActivity)this).get(paramClass);
    p.g(paramClass, "UICProvider.of(this).get(modelClass)");
    return paramClass;
  }
  
  public abstract Set<Class<? extends UIComponent>> cEg();
  
  public int getLayoutId()
  {
    UIComponent localUIComponent = this.KFa;
    if (localUIComponent != null) {
      return localUIComponent.getLayoutId();
    }
    return 0;
  }
  
  public ViewModelStore getViewModelStore()
  {
    return this.KFb;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = ((Iterable)this.uiComponents).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((UIComponent)((Iterator)localObject1).next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    localObject1 = getSupportFragmentManager();
    p.g(localObject1, "supportFragmentManager");
    localObject1 = ((g)localObject1).getFragments();
    p.g(localObject1, "supportFragmentManager.fragments");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Fragment)((Iterator)localObject1).next();
      if ((localObject2 instanceof UIComponentFragment))
      {
        localObject2 = ((Iterable)((UIComponentFragment)localObject2).uiComponents).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((UIComponent)((Iterator)localObject2).next()).onActivityResult(paramInt1, paramInt2, paramIntent);
        }
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      if (((UIComponent)localIterator.next()).onBackPressed()) {
        return;
      }
    }
    finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = ((Iterable)this.uiComponents).iterator();
    while (paramConfiguration.hasNext()) {
      paramConfiguration.next();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    b(this.uiComponents);
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).ae(paramBundle);
    }
    super.onCreate(paramBundle);
    localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext())
    {
      UIComponent localUIComponent = (UIComponent)localIterator.next();
      View localView = getContentView();
      p.g(localView, "contentView");
      localUIComponent.gV(localView);
    }
    localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onCreate(paramBundle);
    }
    localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).ad(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onDestroy();
    }
    this.uiComponents.clear();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onPause();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    Object localObject1 = ((Iterable)this.uiComponents).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((UIComponent)((Iterator)localObject1).next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    localObject1 = getSupportFragmentManager();
    p.g(localObject1, "supportFragmentManager");
    localObject1 = ((g)localObject1).getFragments();
    p.g(localObject1, "supportFragmentManager.fragments");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Fragment)((Iterator)localObject1).next();
      if ((localObject2 instanceof UIComponentFragment))
      {
        localObject2 = ((Iterable)((UIComponentFragment)localObject2).uiComponents).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((UIComponent)((Iterator)localObject2).next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        }
      }
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    paramBundle = ((Iterable)this.uiComponents).iterator();
    while (paramBundle.hasNext()) {
      paramBundle.next();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onResume();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle = ((Iterable)this.uiComponents).iterator();
    while (paramBundle.hasNext()) {
      paramBundle.next();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onStop();
    }
    if (isFinishing())
    {
      localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).cRf();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponentActivity
 * JD-Core Version:    0.7.0.1
 */