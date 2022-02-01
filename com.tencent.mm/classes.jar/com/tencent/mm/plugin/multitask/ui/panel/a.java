package com.tencent.mm.plugin.multitask.ui.panel;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskPanelContainer;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.e;
import com.tencent.mm.ui.component.g.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.aa.f;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/panel/BaseMultiTaskPanel;", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "onCreateInstanceState", "Landroid/os/Bundle;", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/os/Bundle;)V", "TAG", "", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "currentUiComponent", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "getCurrentUiComponent", "()Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "setCurrentUiComponent", "(Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;)V", "getOnCreateInstanceState", "()Landroid/os/Bundle;", "panelView", "Landroid/view/View;", "getPanelView", "()Landroid/view/View;", "setPanelView", "(Landroid/view/View;)V", "panelWindowContainer", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;", "getPanelWindowContainer", "()Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;", "setPanelWindowContainer", "(Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;)V", "uiComponentMaps", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getUiComponentMaps", "()Ljava/util/HashMap;", "setUiComponentMaps", "(Ljava/util/HashMap;)V", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getUiComponents", "()Ljava/util/HashSet;", "findUIComponent", "componetType", "", "id", "findUIComponentClass", "Ljava/lang/Class;", "multiTaskType", "getCurrentUIC", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getSnapShotUIC", "getTitle", "getUIComponent", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getView", "position", "hideUIComponent", "", "initPanelWindowContainer", "", "container", "isMinusScreenUIC", "isSingleSceneShow", "newUIComponent", "modelClass", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "removeUIComponet", "ui-multitask_release"})
public class a
  implements com.tencent.mm.plugin.multitask.ui.a
{
  public MultiTaskPanelContainer FLh;
  public View FLi;
  public com.tencent.mm.plugin.multitask.ui.c FLj;
  HashMap<String, com.tencent.mm.plugin.multitask.ui.c> FLk;
  private final Bundle FLl;
  private final String TAG;
  private final HashSet<com.tencent.mm.plugin.multitask.ui.c> uiComponents;
  public final AppCompatActivity xGq;
  
  public a(AppCompatActivity paramAppCompatActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(196331);
    this.xGq = paramAppCompatActivity;
    this.FLl = paramBundle;
    this.TAG = "MicroMsg.MultiTask.MultiTaskPanelItem";
    this.uiComponents = new HashSet();
    this.FLk = new HashMap();
    AppMethodBeat.o(196331);
  }
  
  private com.tencent.mm.plugin.multitask.ui.c i(String paramString, Class<? extends com.tencent.mm.plugin.multitask.ui.c> paramClass)
  {
    AppMethodBeat.i(196263);
    p.k(paramClass, "modelClass");
    com.tencent.mm.plugin.multitask.ui.c localc = null;
    if (e.class.isAssignableFrom(paramClass)) {}
    try
    {
      localc = (com.tencent.mm.plugin.multitask.ui.c)paramClass.getConstructor(new Class[] { AppCompatActivity.class }).newInstance(new Object[] { this.xGq });
      if (localc != null)
      {
        this.uiComponents.add(localc);
        if (paramString != null) {
          this.FLk.put(paramString, localc);
        }
      }
      AppMethodBeat.o(196263);
      return localc;
    }
    catch (NoSuchMethodException paramString)
    {
      paramString = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)paramString);
      AppMethodBeat.o(196263);
      throw paramString;
    }
    catch (IllegalAccessException paramString)
    {
      paramString = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)paramString);
      AppMethodBeat.o(196263);
      throw paramString;
    }
    catch (InstantiationException paramString)
    {
      paramString = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)paramString);
      AppMethodBeat.o(196263);
      throw paramString;
    }
    catch (InvocationTargetException paramString)
    {
      paramString = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)paramString);
      AppMethodBeat.o(196263);
      throw paramString;
    }
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, dal paramdal, Object paramObject)
  {
    AppMethodBeat.i(196335);
    p.k(paramMultiTaskInfo, "info");
    p.k(paramdal, "animateData");
    p.k(paramMultiTaskInfo, "info");
    p.k(paramdal, "animateData");
    AppMethodBeat.o(196335);
  }
  
  public void a(MultiTaskPanelContainer paramMultiTaskPanelContainer)
  {
    AppMethodBeat.i(196299);
    p.k(paramMultiTaskPanelContainer, "container");
    onCreateBefore(this.FLl);
    onCreate(this.FLl);
    onCreateAfter(this.FLl);
    onStart();
    onResume();
    AppMethodBeat.o(196299);
  }
  
  public final boolean aRd(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(196271);
    p.k(paramString, "id");
    if (this.FLk.containsKey(paramString))
    {
      com.tencent.mm.plugin.multitask.ui.c localc = (com.tencent.mm.plugin.multitask.ui.c)this.FLk.get(paramString);
      Collection localCollection = (Collection)this.uiComponents;
      if (localCollection == null)
      {
        paramString = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(196271);
        throw paramString;
      }
      ag.fc(localCollection).remove(localc);
      this.FLk.remove(paramString);
      if (localc != null) {}
      for (paramString = localc.dKp();; paramString = null)
      {
        if (paramString != a.b.FHW)
        {
          paramString = localObject;
          if (localc != null) {
            paramString = localc.dKp();
          }
          if (paramString != a.b.FHY) {
            break label183;
          }
        }
        if (localc.getRootView().getParent() == null) {
          break label183;
        }
        paramString = localc.getRootView().getParent();
        if (paramString != null) {
          break;
        }
        paramString = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(196271);
        throw paramString;
      }
      ((ViewGroup)paramString).removeView(localc.getRootView());
      label183:
      AppMethodBeat.o(196271);
      return true;
    }
    AppMethodBeat.o(196271);
    return false;
  }
  
  public final com.tencent.mm.plugin.multitask.ui.c aRe(String paramString)
  {
    AppMethodBeat.i(196296);
    p.k(paramString, "id");
    Object localObject1 = ((Iterable)this.uiComponents).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.multitask.ui.c)((Iterator)localObject1).next();
      if ((((com.tencent.mm.plugin.multitask.ui.c)localObject2).Of(1048576)) && (this.FLk.containsKey(paramString)) && (p.h(localObject2, (com.tencent.mm.plugin.multitask.ui.c)this.FLk.get(paramString))))
      {
        AppMethodBeat.o(196296);
        return localObject2;
      }
    }
    localObject1 = PluginMultiTask.FFm;
    localObject1 = (Class)PluginMultiTask.access$getItemSelectors$cp().get(Integer.valueOf(1048576));
    if (localObject1 != null)
    {
      p.j(localObject1, "componentClass");
      localObject1 = i(paramString, (Class)localObject1);
      if (localObject1 != null) {}
      for (paramString = ((com.tencent.mm.plugin.multitask.ui.c)localObject1).dKp(); paramString == a.b.FHY; paramString = null)
      {
        paramString = this.FLh;
        if (paramString == null) {
          break;
        }
        localObject2 = this.xGq.getLayoutInflater().inflate(((com.tencent.mm.plugin.multitask.ui.c)localObject1).getLayoutId(), null);
        paramString.addView((View)localObject2, new ViewGroup.LayoutParams(-1, -1));
        if (localObject2 != null)
        {
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).setRootView((View)localObject2);
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).getRootView().setVisibility(8);
        }
        ((com.tencent.mm.plugin.multitask.ui.c)localObject1).dp(null);
        AppMethodBeat.o(196296);
        return localObject1;
      }
    }
    AppMethodBeat.o(196296);
    return null;
  }
  
  public final com.tencent.mm.plugin.multitask.ui.c bI(int paramInt, String paramString)
  {
    AppMethodBeat.i(196267);
    p.k(paramString, "id");
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.multitask.ui.c localc = (com.tencent.mm.plugin.multitask.ui.c)localIterator.next();
      if ((localc.Of(paramInt)) && (this.FLk.containsKey(paramString)) && (p.h(localc, (com.tencent.mm.plugin.multitask.ui.c)this.FLk.get(paramString))))
      {
        AppMethodBeat.o(196267);
        return localc;
      }
    }
    AppMethodBeat.o(196267);
    return null;
  }
  
  public final void dKo()
  {
    AppMethodBeat.i(196327);
    String str = this.TAG;
    Object localObject = this.FLj;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.multitask.ui.c)localObject).toString();; localObject = null)
    {
      Log.i(str, "onMultiTaskPagePause, uic: %s", new Object[] { localObject });
      localObject = this.FLj;
      if (localObject == null) {
        break;
      }
      ((com.tencent.mm.plugin.multitask.ui.c)localObject).dKo();
      AppMethodBeat.o(196327);
      return;
    }
    AppMethodBeat.o(196327);
  }
  
  public a.b dKp()
  {
    return a.b.FHZ;
  }
  
  public final HashSet<com.tencent.mm.plugin.multitask.ui.c> fbM()
  {
    return this.uiComponents;
  }
  
  public final void fbN()
  {
    AppMethodBeat.i(196324);
    String str = this.TAG;
    Object localObject = this.FLj;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.multitask.ui.c)localObject).toString();; localObject = null)
    {
      Log.i(str, "onMultiTaskPageResume, uic: %s", new Object[] { localObject });
      AppMethodBeat.o(196324);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.multitask.ui.c h(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(196289);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    int i = paramMultiTaskInfo.field_type;
    this.FLj = null;
    Object localObject1 = ((Iterable)this.uiComponents).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.multitask.ui.c)((Iterator)localObject1).next();
      if ((((com.tencent.mm.plugin.multitask.ui.c)localObject2).Of(i)) && (this.FLk.containsKey(paramMultiTaskInfo.field_id)) && (p.h(localObject2, (com.tencent.mm.plugin.multitask.ui.c)this.FLk.get(paramMultiTaskInfo.field_id))))
      {
        if (((com.tencent.mm.plugin.multitask.ui.c)localObject2).dKp() == a.b.FHW) {
          ((com.tencent.mm.plugin.multitask.ui.c)localObject2).getRootView().setVisibility(0);
        }
        this.FLj = ((com.tencent.mm.plugin.multitask.ui.c)localObject2);
        fbN();
        AppMethodBeat.o(196289);
        return localObject2;
      }
    }
    localObject1 = PluginMultiTask.FFm;
    localObject1 = (Class)PluginMultiTask.access$getItemSelectors$cp().get(Integer.valueOf(i));
    if (localObject1 != null)
    {
      localObject2 = paramMultiTaskInfo.field_id;
      p.j(localObject1, "componentClass");
      localObject1 = i((String)localObject2, (Class)localObject1);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.ui.component.g.Xox;
        ((com.tencent.mm.plugin.multitask.ui.c)localObject1).FFs = ((com.tencent.mm.plugin.multitask.ui.a.c)com.tencent.mm.ui.component.g.b(this.xGq).i(com.tencent.mm.plugin.multitask.ui.a.c.class)).FMh;
        if (localObject1 == null) {
          break label366;
        }
        localObject2 = ((com.tencent.mm.plugin.multitask.ui.c)localObject1).dKp();
        label225:
        if (localObject2 != a.b.FHW) {
          break label372;
        }
        localObject2 = this.FLh;
        if (localObject2 != null)
        {
          View localView = this.xGq.getLayoutInflater().inflate(((com.tencent.mm.plugin.multitask.ui.c)localObject1).getLayoutId(), null);
          ((MultiTaskPanelContainer)localObject2).addView(localView, new ViewGroup.LayoutParams(-1, -1));
          if (localView != null) {
            ((com.tencent.mm.plugin.multitask.ui.c)localObject1).setRootView(localView);
          }
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).onCreateBefore(this.FLl);
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).dp(paramMultiTaskInfo);
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).onCreate(this.FLl);
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).onCreateAfter(this.FLl);
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).onStart();
          if (((this.xGq instanceof MMFragmentActivity)) && (!((MMFragmentActivity)this.xGq).isPaused())) {
            ((com.tencent.mm.plugin.multitask.ui.c)localObject1).onResume();
          }
        }
      }
      for (;;)
      {
        this.FLj = ((com.tencent.mm.plugin.multitask.ui.c)localObject1);
        AppMethodBeat.o(196289);
        return localObject1;
        localObject1 = null;
        break;
        label366:
        localObject2 = null;
        break label225;
        label372:
        paramMultiTaskInfo = this.FLh;
        if ((paramMultiTaskInfo != null) && (localObject1 != null)) {
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).setRootView((View)paramMultiTaskInfo);
        }
      }
    }
    AppMethodBeat.o(196289);
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onBeforeFinish(Intent paramIntent) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(196322);
    p.k(paramConfiguration, "newConfig");
    Object localObject = com.tencent.mm.plugin.multitask.g.FEX;
    localObject = bI(0, com.tencent.mm.plugin.multitask.g.fam());
    if (localObject != null)
    {
      if (localObject == null)
      {
        paramConfiguration = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.ui.uic.MultiTaskMinusScreenUIC");
        AppMethodBeat.o(196322);
        throw paramConfiguration;
      }
      ((b)localObject).onConfigurationChanged(paramConfiguration);
      AppMethodBeat.o(196322);
      return;
    }
    AppMethodBeat.o(196322);
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onCreateAfter(Bundle paramBundle) {}
  
  public void onCreateBefore(Bundle paramBundle) {}
  
  public void onDestroy()
  {
    AppMethodBeat.i(196316);
    Log.i(this.TAG, "onDestroy");
    AppMethodBeat.o(196316);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(196319);
    p.k(paramKeyEvent, "event");
    AppMethodBeat.o(196319);
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(196320);
    p.k(paramKeyEvent, "event");
    AppMethodBeat.o(196320);
    return false;
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPause()
  {
    AppMethodBeat.i(196311);
    Log.i(this.TAG, "onPause");
    AppMethodBeat.o(196311);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196318);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(196318);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle) {}
  
  public void onResume()
  {
    AppMethodBeat.i(196307);
    Log.i(this.TAG, "onResume");
    AppMethodBeat.o(196307);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    AppMethodBeat.i(196305);
    Log.i(this.TAG, "onStart");
    AppMethodBeat.o(196305);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(196313);
    Log.i(this.TAG, "onStop");
    AppMethodBeat.o(196313);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(aa.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.a
 * JD-Core Version:    0.7.0.1
 */