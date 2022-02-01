package com.tencent.mm.ui.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.af;
import androidx.lifecycle.aj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlinx.coroutines.ac;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cx;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/UIComponentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "activityLifecycleDetailedCallbacks", "com/tencent/mm/ui/component/UIComponentActivity$activityLifecycleDetailedCallbacks$1", "Lcom/tencent/mm/ui/component/UIComponentActivity$activityLifecycleDetailedCallbacks$1;", "layoutUIC", "Lcom/tencent/mm/ui/component/UIComponent;", "getLayoutUIC", "()Lcom/tencent/mm/ui/component/UIComponent;", "setLayoutUIC", "(Lcom/tencent/mm/ui/component/UIComponent;)V", "lifecycleAsyncScope", "Lkotlinx/coroutines/CoroutineScope;", "getLifecycleAsyncScope", "()Lkotlinx/coroutines/CoroutineScope;", "modelStore", "Landroidx/lifecycle/ViewModelStore;", "savedInstanceState", "Landroid/os/Bundle;", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getUiComponents", "()Ljava/util/HashSet;", "activeUIComponents", "", "includeFragment", "", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "component", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "containUIC", "dispatchViewCreated", "contentView", "Landroid/view/View;", "finish", "getViewModelStore", "importUIComponents", "", "initializeUIC", "mapStoreTo", "src", "dest", "isStore", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "any", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onNewIntent", "intent", "onPause", "onPostCreated", "onPostDestroyed", "onPreDestroyed", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onWindowFocusChanged", "hasFocus", "registerActivityDetailedLifecycleCallbacks", "setContentView", "view", "params", "Landroid/view/ViewGroup$LayoutParams;", "layoutResID", "startActivityForResult", "options", "superImportUIComponents", "set", "unregisterActivityDetailedLifecycleCallbacks", "Companion", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class UIComponentActivity
  extends AppCompatActivity
{
  public static final UIComponentActivity.a Companion = new UIComponentActivity.a((byte)0);
  private static final String TAG = "MicroMsg.UIComponentActivity";
  private final b activityLifecycleDetailedCallbacks = new b(this);
  private UIComponent layoutUIC;
  private final aq lifecycleAsyncScope = ar.d(cx.g(null).plus((f)bg.kCi()));
  private aj modelStore;
  private Bundle savedInstanceState;
  private final HashSet<UIComponent> uiComponents = new HashSet();
  
  private final void dispatchViewCreated(View paramView)
  {
    Log.i("MicroMsg.UIComponentActivity", "[dispatchViewCreated]... " + getClass().getSimpleName() + '@' + hashCode() + " contentView=" + paramView);
    Iterator localIterator = ((Iterable)activeUIComponents(false)).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onViewCreated(paramView);
    }
  }
  
  private final void mapStoreTo(aj paramaj1, aj paramaj2, b<Object, Boolean> paramb)
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
  
  private final void onPostCreated(Bundle paramBundle)
  {
    Log.i("MicroMsg.UIComponentActivity", "[onPostCreated]... " + getClass().getSimpleName() + '@' + hashCode() + " isChangingConfigurations=" + isChangingConfigurations());
    Object localObject = activeUIComponents(false);
    Iterator localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext())
    {
      UIComponent localUIComponent = (UIComponent)localIterator.next();
      View localView = getWindow().getDecorView();
      s.s(localView, "window.decorView");
      localUIComponent.setRootView(localView);
    }
    localIterator = ((Iterable)localObject).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onCreate(paramBundle);
    }
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((UIComponent)((Iterator)localObject).next()).onCreateAfter(paramBundle);
    }
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  protected final List<UIComponent> activeUIComponents(boolean paramBoolean)
  {
    LinkedList localLinkedList = new LinkedList((Collection)getUiComponents());
    if (paramBoolean)
    {
      Object localObject1 = getSupportFragmentManager().getFragments();
      s.s(localObject1, "supportFragmentManager.fragments");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if ((localObject3 instanceof UIComponentFragment)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (((UIComponentFragment)localObject3).isVisible()) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        p.a((Collection)localObject1, (Iterable)((UIComponentFragment)((Iterator)localObject2).next()).uiComponents);
      }
      localLinkedList.addAll((Collection)localObject1);
    }
    return (List)localLinkedList;
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    registerActivityDetailedLifecycleCallbacks();
  }
  
  public final <T extends af> T component(Class<T> paramClass)
  {
    s.u(paramClass, "modelClass");
    k localk = k.aeZF;
    paramClass = k.d((AppCompatActivity)this).q(paramClass);
    s.s(paramClass, "UICProvider.of(this).get(modelClass)");
    return paramClass;
  }
  
  public final boolean containUIC(Class<? extends UIComponent> paramClass)
  {
    s.u(paramClass, "modelClass");
    k localk = k.aeZF;
    return k.d((AppCompatActivity)this).cp(paramClass) != null;
  }
  
  public void finish()
  {
    List localList = activeUIComponents$default(this, false, 1, null);
    Object localObject1 = ((Iterable)localList).iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (UIComponent)((Iterator)localObject1).next();
      if (((UIComponent)localObject3).onInterceptFinish()) {
        Log.w("MicroMsg.UIComponentActivity", localObject3 + " intercept finish!");
      }
    }
    for (;;)
    {
      return;
      for (;;)
      {
        try
        {
          localObject1 = Result.Companion;
          localObject1 = (UIComponentActivity)this;
          localObject3 = Activity.class.getDeclaredField("mResultData");
          ((Field)localObject3).setAccessible(true);
          localObject1 = ((Field)localObject3).get(localObject1);
          if (!(localObject1 instanceof Intent)) {
            continue;
          }
          localObject1 = (Intent)localObject1;
          localObject1 = Result.constructor-impl(localObject1);
        }
        finally
        {
          localObject3 = Result.Companion;
          localObject2 = Result.constructor-impl(ResultKt.createFailure(localThrowable));
          continue;
          continue;
          super.finish();
          localObject2 = ((Iterable)localList).iterator();
        }
        localObject3 = localObject1;
        if (Result.isFailure-impl(localObject1)) {
          localObject3 = null;
        }
        localObject1 = (Intent)localObject3;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = new Intent();
        localObject3 = ((Iterable)localList).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          continue;
        }
        ((UIComponent)((Iterator)localObject3).next()).onBeforeFinish((Intent)localObject1);
        continue;
        localObject1 = null;
      }
      Object localObject2;
      while (((Iterator)localObject2).hasNext()) {
        ((UIComponent)((Iterator)localObject2).next()).onFinished();
      }
    }
  }
  
  public final UIComponent getLayoutUIC()
  {
    return this.layoutUIC;
  }
  
  public aq getLifecycleAsyncScope()
  {
    return this.lifecycleAsyncScope;
  }
  
  protected HashSet<UIComponent> getUiComponents()
  {
    return this.uiComponents;
  }
  
  public aj getViewModelStore()
  {
    aj localaj2 = this.modelStore;
    aj localaj1 = localaj2;
    if (localaj2 == null)
    {
      localaj1 = (aj)new q();
      mapStoreTo$default(this, super.getViewModelStore(), localaj1, null, 4, null);
      this.modelStore = localaj1;
    }
    return localaj1;
  }
  
  public abstract Set<Class<? extends UIComponent>> importUIComponents();
  
  protected void initializeUIC(HashSet<UIComponent> paramHashSet)
  {
    s.u(paramHashSet, "uiComponents");
    Object localObject1 = new HashSet();
    superImportUIComponents((HashSet)localObject1);
    localObject1 = ((Iterable)localObject1).iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Class)((Iterator)localObject1).next();
      k localk = k.aeZF;
      localObject2 = (UIComponent)k.d((AppCompatActivity)this).q((Class)localObject2);
      paramHashSet.add(localObject2);
      if (((UIComponent)localObject2).getLayoutId() == 0) {
        break label139;
      }
      setLayoutUIC((UIComponent)localObject2);
      if (i != 0) {
        throw new RuntimeException("already layout uic[" + getLayoutUIC() + "], no more than one layout uic.");
      }
      i = 1;
    }
    label139:
    for (;;)
    {
      break;
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = ((Iterable)activeUIComponents$default(this, false, 1, null)).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    Iterator localIterator = ((Iterable)activeUIComponents$default(this, false, 1, null)).iterator();
    while (localIterator.hasNext()) {
      if (((UIComponent)localIterator.next()).onBackPressed()) {
        return;
      }
    }
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Iterator localIterator = ((Iterable)activeUIComponents(false)).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.savedInstanceState = paramBundle;
    Log.i("MicroMsg.UIComponentActivity", "[onCreate]... " + getClass().getSimpleName() + '@' + hashCode() + " isChangingConfigurations=" + isChangingConfigurations());
    initializeUIC(getUiComponents());
    Iterator localIterator = ((Iterable)activeUIComponents(false)).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onCreateBefore(paramBundle);
    }
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    Log.i("MicroMsg.UIComponentActivity", "[onDestroy]... " + getClass().getSimpleName() + '@' + hashCode() + " isChangingConfigurations=" + isChangingConfigurations());
    Object localObject = getViewModelStore();
    if ((localObject instanceof q))
    {
      localObject = (q)localObject;
      if ((localObject == null) || (((q)localObject).aeZY)) {
        break label109;
      }
    }
    label109:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label114;
      }
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
      localObject = null;
      break;
    }
    label114:
    localObject = ((Iterable)activeUIComponents(false)).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((UIComponent)((Iterator)localObject).next()).onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    s.u(paramKeyEvent, "event");
    Iterator localIterator = ((Iterable)activeUIComponents$default(this, false, 1, null)).iterator();
    while (localIterator.hasNext()) {
      if (((UIComponent)localIterator.next()).onKeyDown(paramInt, paramKeyEvent)) {
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    s.u(paramKeyEvent, "event");
    Iterator localIterator = ((Iterable)activeUIComponents$default(this, false, 1, null)).iterator();
    while (localIterator.hasNext()) {
      if (((UIComponent)localIterator.next()).onKeyUp(paramInt, paramKeyEvent)) {
        return true;
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Iterator localIterator = ((Iterable)activeUIComponents$default(this, false, 1, null)).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onNewIntent(paramIntent);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = ((Iterable)activeUIComponents(false)).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onPause();
    }
  }
  
  public void onPostDestroyed()
  {
    Object localObject2 = null;
    Log.i("MicroMsg.UIComponentActivity", "[onPostDestroyed]... " + getClass().getSimpleName() + '@' + hashCode() + " isChangingConfigurations=" + isChangingConfigurations());
    Object localObject1 = getSupportFragmentManager().getFragments();
    s.s(localObject1, "supportFragmentManager.fragments");
    Object localObject3 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      if ((localObject4 instanceof UIComponentFragment)) {
        ((Collection)localObject1).add(localObject4);
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((Iterator)localObject1).next();
    }
    localObject1 = ((Iterable)activeUIComponents(false)).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((UIComponent)((Iterator)localObject1).next()).onPostDestroyed();
    }
    localObject1 = getViewModelStore();
    if ((localObject1 instanceof q)) {}
    for (localObject1 = (q)localObject1;; localObject1 = null)
    {
      Log.i("MicroMsg.UIComponentActivity", String.valueOf(localObject1));
      localObject1 = getSupportFragmentManager().getFragments();
      s.s(localObject1, "supportFragmentManager.fragments");
      localObject3 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = ((Iterator)localObject3).next();
        if ((localObject4 instanceof UIComponentFragment)) {
          ((Collection)localObject1).add(localObject4);
        }
      }
    }
    localObject3 = ((Iterable)localObject1).iterator();
    label378:
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((UIComponentFragment)((Iterator)localObject3).next()).getViewModelStore();
      if ((localObject1 instanceof q)) {}
      for (localObject1 = (q)localObject1;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label378;
        }
        ((q)localObject1).aT((b)new UIComponentActivity.d(this));
        break;
      }
    }
    localObject3 = getViewModelStore();
    localObject1 = localObject2;
    if ((localObject3 instanceof q)) {
      localObject1 = (q)localObject3;
    }
    if (localObject1 != null) {
      ((q)localObject1).aT((b)new UIComponentActivity.e(this));
    }
    ar.a(getLifecycleAsyncScope(), this + " onPostDestroyed.");
    unregisterActivityDetailedLifecycleCallbacks();
  }
  
  public void onPreDestroyed()
  {
    Log.i("MicroMsg.UIComponentActivity", "[onPreDestroyed]... " + getClass().getSimpleName() + '@' + hashCode() + " isChangingConfigurations=" + isChangingConfigurations());
    Object localObject1 = getSupportFragmentManager().getFragments();
    s.s(localObject1, "supportFragmentManager.fragments");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if ((localObject3 instanceof UIComponentFragment)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((UIComponentFragment)((Iterator)localObject1).next()).jxO();
    }
    localObject1 = ((Iterable)activeUIComponents(false)).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((UIComponent)((Iterator)localObject1).next()).onPreDestroyed();
    }
    localObject1 = getViewModelStore();
    localObject2 = super.getViewModelStore();
    s.s(localObject2, "super.getViewModelStore()");
    mapStoreTo((aj)localObject1, (aj)localObject2, (b)UIComponentActivity.f.aeZP);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    Iterator localIterator = ((Iterable)activeUIComponents$default(this, false, 1, null)).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    s.u(paramBundle, "savedInstanceState");
    super.onRestoreInstanceState(paramBundle);
    Iterator localIterator = ((Iterable)activeUIComponents(false)).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onRestoreInstanceState(paramBundle);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = ((Iterable)activeUIComponents(false)).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onResume();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    s.u(paramBundle, "outState");
    super.onSaveInstanceState(paramBundle);
    Iterator localIterator = ((Iterable)activeUIComponents(false)).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onSaveInstanceState(paramBundle);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    Iterator localIterator = ((Iterable)activeUIComponents(false)).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Iterator localIterator = ((Iterable)activeUIComponents(false)).iterator();
    while (localIterator.hasNext()) {
      ((UIComponent)localIterator.next()).onStop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    Iterator localIterator = ((Iterable)activeUIComponents$default(this, false, 1, null)).iterator();
    if (localIterator.hasNext())
    {
      UIComponent localUIComponent = (UIComponent)localIterator.next();
      if (!localUIComponent.isBelongFragment())
      {
        if (!paramBoolean) {
          break label63;
        }
        localUIComponent.onUserVisibleFocused();
      }
      for (;;)
      {
        localUIComponent.onWindowFocusChanged(paramBoolean);
        break;
        label63:
        localUIComponent.onUserVisibleUnFocused();
      }
    }
  }
  
  public void registerActivityDetailedLifecycleCallbacks()
  {
    com.tencent.mm.ui.component.support.a locala = com.tencent.mm.ui.component.support.a.afac;
    com.tencent.mm.ui.component.support.a.a((a)this.activityLifecycleDetailedCallbacks);
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    Object localObject = (ViewGroup)getWindow().getDecorView().findViewById(16908290);
    if (localObject != null)
    {
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if (localObject != null) {
        dispatchViewCreated((View)localObject);
      }
    }
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
    if (paramView != null) {
      dispatchViewCreated(paramView);
    }
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
    if (paramView != null) {
      dispatchViewCreated(paramView);
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
      Iterator localIterator = ((Iterable)activeUIComponents$default(this, false, 1, null)).iterator();
      while (localIterator.hasNext()) {
        ((UIComponent)localIterator.next()).onStartActivityForResult(paramIntent, paramInt, paramBundle);
      }
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    s.u(paramHashSet, "set");
    Set localSet = importUIComponents();
    if (localSet != null) {
      paramHashSet.addAll((Collection)localSet);
    }
  }
  
  public void unregisterActivityDetailedLifecycleCallbacks()
  {
    com.tencent.mm.ui.component.support.a locala = com.tencent.mm.ui.component.support.a.afac;
    com.tencent.mm.ui.component.support.a.b((a)this.activityLifecycleDetailedCallbacks);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/component/UIComponentActivity$activityLifecycleDetailedCallbacks$1", "Lcom/tencent/mm/ui/component/ActivityLifecycleDetailedCallbacks;", "onActivityPostCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityPostDestroyed", "onActivityPreDestroyed", "plugin-uic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements a
  {
    b(UIComponentActivity paramUIComponentActivity) {}
    
    public final void onActivityPostCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(250277);
      s.u(paramActivity, "activity");
      s.u((a)this, "this");
      s.u(paramActivity, "activity");
      if (s.p(paramActivity, this.aeZN)) {
        UIComponentActivity.access$onPostCreated(this.aeZN, paramBundle);
      }
      AppMethodBeat.o(250277);
    }
    
    public final void onActivityPostDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(250291);
      s.u(paramActivity, "activity");
      s.u((a)this, "this");
      s.u(paramActivity, "activity");
      if (s.p(paramActivity, this.aeZN)) {
        this.aeZN.onPostDestroyed();
      }
      AppMethodBeat.o(250291);
    }
    
    public final void onActivityPreDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(250284);
      s.u(paramActivity, "activity");
      s.u((a)this, "this");
      s.u(paramActivity, "activity");
      if (s.p(paramActivity, this.aeZN)) {
        this.aeZN.onPreDestroyed();
      }
      AppMethodBeat.o(250284);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.component.UIComponentActivity
 * JD-Core Version:    0.7.0.1
 */