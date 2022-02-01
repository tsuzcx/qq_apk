package com.tencent.mm.ui.component;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStore;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/component/UIComponentActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "layoutUIC", "Lcom/tencent/mm/ui/component/UIComponent;", "getLayoutUIC", "()Lcom/tencent/mm/ui/component/UIComponent;", "setLayoutUIC", "(Lcom/tencent/mm/ui/component/UIComponent;)V", "modelStore", "Landroid/arch/lifecycle/ViewModelStore;", "savedInstanceState", "Landroid/os/Bundle;", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "component", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "containUIC", "", "finish", "", "getViewModelStore", "importUIComponents", "", "initializeUIC", "mapStoreTo", "src", "dest", "isStore", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "any", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onNewIntent", "intent", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onWindowFocusChanged", "hasFocus", "startActivityForResult", "options", "Companion", "libmmui_release"})
public abstract class UIComponentActivity
  extends AppCompatActivity
{
  public static final a Companion = new a((byte)0);
  private static final String TAG = "MicroMsg.UIComponentActivity";
  private HashMap _$_findViewCache;
  private UIComponent layoutUIC;
  private ViewModelStore modelStore;
  private Bundle savedInstanceState;
  private final HashSet<UIComponent> uiComponents = new HashSet();
  
  private final void mapStoreTo(ViewModelStore paramViewModelStore1, ViewModelStore paramViewModelStore2, b<Object, Boolean> paramb)
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
        throw new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.Any, kotlin.Any> /* = java.util.HashMap<kotlin.Any, kotlin.Any> */");
      }
      paramViewModelStore1 = (HashMap)paramViewModelStore1;
      paramViewModelStore2 = ((Field)localObject).get(paramViewModelStore2);
      if (paramViewModelStore2 == null) {
        throw new t("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.Any, kotlin.Any> /* = java.util.HashMap<kotlin.Any, kotlin.Any> */");
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
  
  public final <T extends ViewModel> T component(Class<T> paramClass)
  {
    p.h(paramClass, "modelClass");
    a locala = a.PRN;
    paramClass = a.b((AppCompatActivity)this).get(paramClass);
    p.g(paramClass, "UICProvider.of(this).get(modelClass)");
    return paramClass;
  }
  
  public final boolean containUIC(Class<? extends UIComponent> paramClass)
  {
    p.h(paramClass, "modelClass");
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      if (p.j(((UIComponent)localIterator.next()).getClass(), paramClass)) {
        return true;
      }
    }
    return false;
  }
  
  public void finish()
  {
    localObject3 = null;
    try
    {
      localObject1 = Activity.class.getDeclaredField("mResultData");
      p.g(localObject1, "it");
      ((Field)localObject1).setAccessible(true);
      localObject4 = ((Field)localObject1).get(this);
      localObject1 = localObject4;
      if (!(localObject4 instanceof Intent)) {
        localObject1 = null;
      }
      localObject1 = (Intent)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject4;
        Object localObject2 = localObject3;
      }
    }
    localObject3 = ((Iterable)this.uiComponents).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((UIComponent)((Iterator)localObject3).next()).onBeforeFinish((Intent)localObject1);
    }
    localObject3 = getSupportFragmentManager();
    p.g(localObject3, "supportFragmentManager");
    localObject3 = ((g)localObject3).getFragments();
    p.g(localObject3, "supportFragmentManager.fragments");
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Fragment)((Iterator)localObject3).next();
      if ((localObject4 instanceof UIComponentFragment))
      {
        localObject4 = ((Iterable)((UIComponentFragment)localObject4).uiComponents).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((UIComponent)((Iterator)localObject4).next()).onBeforeFinish((Intent)localObject1);
        }
      }
    }
    super.finish();
    localObject1 = ((Iterable)this.uiComponents).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((UIComponent)((Iterator)localObject1).next()).onFinished();
    }
    localObject1 = getSupportFragmentManager();
    p.g(localObject1, "supportFragmentManager");
    localObject1 = ((g)localObject1).getFragments();
    p.g(localObject1, "supportFragmentManager.fragments");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Fragment)((Iterator)localObject1).next();
      if ((localObject3 instanceof UIComponentFragment))
      {
        localObject3 = ((Iterable)((UIComponentFragment)localObject3).uiComponents).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((UIComponent)((Iterator)localObject3).next()).onFinished();
        }
      }
    }
  }
  
  public final UIComponent getLayoutUIC()
  {
    return this.layoutUIC;
  }
  
  public ViewModelStore getViewModelStore()
  {
    ViewModelStore localViewModelStore2 = this.modelStore;
    ViewModelStore localViewModelStore1 = localViewModelStore2;
    if (localViewModelStore2 == null)
    {
      localViewModelStore1 = new ViewModelStore();
      mapStoreTo$default(this, super.getViewModelStore(), localViewModelStore1, null, 4, null);
      this.modelStore = localViewModelStore1;
    }
    return localViewModelStore1;
  }
  
  public abstract Set<Class<? extends UIComponent>> importUIComponents();
  
  protected void initializeUIC(HashSet<UIComponent> paramHashSet)
  {
    p.h(paramHashSet, "uiComponents");
    Object localObject1 = importUIComponents();
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Class)((Iterator)localObject1).next();
        a locala = a.PRN;
        localObject2 = (UIComponent)a.b((AppCompatActivity)this).get((Class)localObject2);
        paramHashSet.add(localObject2);
        if (((UIComponent)localObject2).getLayoutId() == 0) {
          break label138;
        }
        this.layoutUIC = ((UIComponent)localObject2);
        if (i != 0) {
          throw ((Throwable)new RuntimeException("already layout uic[" + this.layoutUIC + "], no more than one layout uic."));
        }
        i = 1;
      }
    }
    label138:
    for (;;)
    {
      break;
      return;
    }
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
    Object localObject1 = ((Iterable)this.uiComponents).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((UIComponent)((Iterator)localObject1).next()).onBackPressed()) {
        return;
      }
    }
    localObject1 = getSupportFragmentManager();
    p.g(localObject1, "supportFragmentManager");
    localObject1 = ((g)localObject1).getFragments();
    p.g(localObject1, "supportFragmentManager.fragments");
    Object localObject2;
    do
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (!((Iterator)localObject2).hasNext())
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (Fragment)((Iterator)localObject1).next();
        } while (!(localObject2 instanceof UIComponentFragment));
        localObject2 = ((Iterable)((UIComponentFragment)localObject2).uiComponents).iterator();
      }
    } while (!((UIComponent)((Iterator)localObject2).next()).onBackPressed());
    return;
    finish();
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
  
  public void onCreate(final Bundle paramBundle)
  {
    this.savedInstanceState = paramBundle;
    initializeUIC(this.uiComponents);
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onCreateBefore(paramBundle);
    }
    super.onCreate(paramBundle);
    getLifecycle().addObserver((LifecycleObserver)new LifecycleObserver()
    {
      @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
      public final void onCreate()
      {
        AppMethodBeat.i(204838);
        Iterator localIterator = ((Iterable)UIComponentActivity.access$getUiComponents$p(this.PRT)).iterator();
        while (localIterator.hasNext())
        {
          UIComponent localUIComponent = (UIComponent)localIterator.next();
          Object localObject = this.PRT.getWindow();
          p.g(localObject, "window");
          localObject = ((Window)localObject).getDecorView();
          p.g(localObject, "window.decorView");
          localUIComponent.setRootView((View)localObject);
        }
        localIterator = ((Iterable)UIComponentActivity.access$getUiComponents$p(this.PRT)).iterator();
        while (localIterator.hasNext()) {
          ((UIComponent)localIterator.next()).onCreate(paramBundle);
        }
        localIterator = ((Iterable)UIComponentActivity.access$getUiComponents$p(this.PRT)).iterator();
        while (localIterator.hasNext()) {
          ((UIComponent)localIterator.next()).onCreateAfter(paramBundle);
        }
        AppMethodBeat.o(204838);
      }
    });
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
    mapStoreTo((ViewModelStore)localObject, localViewModelStore, (b)c.PRV);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    p.h(paramKeyEvent, "event");
    Object localObject1 = ((Iterable)this.uiComponents).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((UIComponent)((Iterator)localObject1).next()).onKeyDown(paramInt, paramKeyEvent)) {
        return true;
      }
    }
    localObject1 = getSupportFragmentManager();
    p.g(localObject1, "supportFragmentManager");
    localObject1 = ((g)localObject1).getFragments();
    p.g(localObject1, "supportFragmentManager.fragments");
    Object localObject2;
    do
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (!((Iterator)localObject2).hasNext())
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (Fragment)((Iterator)localObject1).next();
        } while (!(localObject2 instanceof UIComponentFragment));
        localObject2 = ((Iterable)((UIComponentFragment)localObject2).uiComponents).iterator();
      }
    } while (!((UIComponent)((Iterator)localObject2).next()).onKeyDown(paramInt, paramKeyEvent));
    return true;
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    p.h(paramKeyEvent, "event");
    Object localObject1 = ((Iterable)this.uiComponents).iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((UIComponent)((Iterator)localObject1).next()).onKeyUp(paramInt, paramKeyEvent)) {
        return true;
      }
    }
    localObject1 = getSupportFragmentManager();
    p.g(localObject1, "supportFragmentManager");
    localObject1 = ((g)localObject1).getFragments();
    p.g(localObject1, "supportFragmentManager.fragments");
    Object localObject2;
    do
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (!((Iterator)localObject2).hasNext())
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (Fragment)((Iterator)localObject1).next();
        } while (!(localObject2 instanceof UIComponentFragment));
        localObject2 = ((Iterable)((UIComponentFragment)localObject2).uiComponents).iterator();
      }
    } while (!((UIComponent)((Iterator)localObject2).next()).onKeyUp(paramInt, paramKeyEvent));
    return true;
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Object localObject1 = ((Iterable)this.uiComponents).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((UIComponent)((Iterator)localObject1).next()).onNewIntent(paramIntent);
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
          ((UIComponent)((Iterator)localObject2).next()).onNewIntent(paramIntent);
        }
      }
    }
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
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onRestoreInstanceState(paramBundle);
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
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onSaveInstanceState(paramBundle);
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
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onUserVisibleFocused();
      }
    }
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onUserVisibleUnFocused();
    }
  }
  
  public final void setLayoutUIC(UIComponent paramUIComponent)
  {
    this.layoutUIC = paramUIComponent;
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (paramIntent != null)
    {
      Iterator localIterator = ((Iterable)this.uiComponents).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onStartActivityForResult(paramIntent, paramInt, paramBundle);
      }
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/component/UIComponentActivity$Companion;", "", "()V", "TAG", "", "libmmui_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements b<Object, Boolean>
  {
    public static final b PRS;
    
    static
    {
      AppMethodBeat.i(204837);
      PRS = new b();
      AppMethodBeat.o(204837);
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
    public static final c PRV;
    
    static
    {
      AppMethodBeat.i(204840);
      PRV = new c();
      AppMethodBeat.o(204840);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponentActivity
 * JD-Core Version:    0.7.0.1
 */