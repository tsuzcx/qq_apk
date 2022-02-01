package com.tencent.mm.plugin.multitask.ui.panel;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskPanelContainer;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.SimpleUIComponent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/panel/BaseMultiTaskPanel;", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "onCreateInstanceState", "Landroid/os/Bundle;", "(Landroid/support/v7/app/AppCompatActivity;Landroid/os/Bundle;)V", "TAG", "", "getActivity", "()Landroid/support/v7/app/AppCompatActivity;", "currentUiComponent", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "getCurrentUiComponent", "()Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "setCurrentUiComponent", "(Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;)V", "getOnCreateInstanceState", "()Landroid/os/Bundle;", "panelView", "Landroid/view/View;", "getPanelView", "()Landroid/view/View;", "setPanelView", "(Landroid/view/View;)V", "panelWindowContainer", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;", "getPanelWindowContainer", "()Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;", "setPanelWindowContainer", "(Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;)V", "uiComponentMaps", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getUiComponentMaps", "()Ljava/util/HashMap;", "setUiComponentMaps", "(Ljava/util/HashMap;)V", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getUiComponents", "()Ljava/util/HashSet;", "findUIComponent", "componetType", "", "id", "findUIComponentClass", "Ljava/lang/Class;", "multiTaskType", "getCurrentUIC", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getSnapShotUIC", "getTitle", "getUIComponent", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getView", "position", "hideUIComponent", "", "initPanelWindowContainer", "", "container", "isMinusScreenUIC", "isSingleSceneShow", "newUIComponent", "modelClass", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "removeUIComponet", "ui-multitask_release"})
public class a
  implements com.tencent.mm.plugin.multitask.ui.a
{
  public MultiTaskPanelContainer AeE;
  public View AeF;
  public MultiTaskUIComponent AeG;
  HashMap<String, MultiTaskUIComponent> AeH;
  private final Bundle AeI;
  public final String TAG;
  public final AppCompatActivity tUQ;
  final HashSet<MultiTaskUIComponent> uiComponents;
  
  public a(AppCompatActivity paramAppCompatActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(236565);
    this.tUQ = paramAppCompatActivity;
    this.AeI = paramBundle;
    this.TAG = "MicroMsg.MultiTask.MultiTaskPanelItem";
    this.uiComponents = new HashSet();
    this.AeH = new HashMap();
    AppMethodBeat.o(236565);
  }
  
  public static boolean e(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(236562);
    p.h(paramKeyEvent, "event");
    AppMethodBeat.o(236562);
    return false;
  }
  
  private MultiTaskUIComponent i(String paramString, Class<? extends MultiTaskUIComponent> paramClass)
  {
    AppMethodBeat.i(236553);
    p.h(paramClass, "modelClass");
    MultiTaskUIComponent localMultiTaskUIComponent = null;
    if (SimpleUIComponent.class.isAssignableFrom(paramClass)) {}
    try
    {
      localMultiTaskUIComponent = (MultiTaskUIComponent)paramClass.getConstructor(new Class[] { AppCompatActivity.class }).newInstance(new Object[] { this.tUQ });
      if (localMultiTaskUIComponent != null)
      {
        this.uiComponents.add(localMultiTaskUIComponent);
        if (paramString != null) {
          this.AeH.put(paramString, localMultiTaskUIComponent);
        }
      }
      AppMethodBeat.o(236553);
      return localMultiTaskUIComponent;
    }
    catch (NoSuchMethodException paramString)
    {
      paramString = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)paramString);
      AppMethodBeat.o(236553);
      throw paramString;
    }
    catch (IllegalAccessException paramString)
    {
      paramString = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)paramString);
      AppMethodBeat.o(236553);
      throw paramString;
    }
    catch (InstantiationException paramString)
    {
      paramString = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)paramString);
      AppMethodBeat.o(236553);
      throw paramString;
    }
    catch (InvocationTargetException paramString)
    {
      paramString = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)paramString);
      AppMethodBeat.o(236553);
      throw paramString;
    }
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, crq paramcrq, Object paramObject)
  {
    AppMethodBeat.i(236566);
    p.h(paramMultiTaskInfo, "info");
    p.h(paramcrq, "animateData");
    p.h(paramMultiTaskInfo, "info");
    p.h(paramcrq, "animateData");
    AppMethodBeat.o(236566);
  }
  
  public void a(MultiTaskPanelContainer paramMultiTaskPanelContainer)
  {
    AppMethodBeat.i(236558);
    p.h(paramMultiTaskPanelContainer, "container");
    onCreate(this.AeI);
    onStart();
    onResume();
    AppMethodBeat.o(236558);
  }
  
  public final boolean aGO(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(236555);
    p.h(paramString, "id");
    if (this.AeH.containsKey(paramString))
    {
      MultiTaskUIComponent localMultiTaskUIComponent = (MultiTaskUIComponent)this.AeH.get(paramString);
      Collection localCollection = (Collection)this.uiComponents;
      if (localCollection == null)
      {
        paramString = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(236555);
        throw paramString;
      }
      af.eV(localCollection).remove(localMultiTaskUIComponent);
      this.AeH.remove(paramString);
      if (localMultiTaskUIComponent != null) {}
      for (paramString = localMultiTaskUIComponent.dks();; paramString = null)
      {
        if (paramString != a.b.Acg)
        {
          paramString = localObject;
          if (localMultiTaskUIComponent != null) {
            paramString = localMultiTaskUIComponent.dks();
          }
          if (paramString != a.b.Aci) {
            break label183;
          }
        }
        if (localMultiTaskUIComponent.getRootView().getParent() == null) {
          break label183;
        }
        paramString = localMultiTaskUIComponent.getRootView().getParent();
        if (paramString != null) {
          break;
        }
        paramString = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(236555);
        throw paramString;
      }
      ((ViewGroup)paramString).removeView(localMultiTaskUIComponent.getRootView());
      label183:
      AppMethodBeat.o(236555);
      return true;
    }
    AppMethodBeat.o(236555);
    return false;
  }
  
  public final MultiTaskUIComponent aGP(String paramString)
  {
    AppMethodBeat.i(236557);
    p.h(paramString, "id");
    Object localObject1 = ((Iterable)this.uiComponents).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MultiTaskUIComponent)((Iterator)localObject1).next();
      if ((((MultiTaskUIComponent)localObject2).Js(1048576)) && (this.AeH.containsKey(paramString)) && (p.j(localObject2, (MultiTaskUIComponent)this.AeH.get(paramString))))
      {
        AppMethodBeat.o(236557);
        return localObject2;
      }
    }
    localObject1 = PluginMultiTask.zZu;
    localObject1 = (Class)PluginMultiTask.access$getItemSelectors$cp().get(Integer.valueOf(1048576));
    if (localObject1 != null)
    {
      p.g(localObject1, "componentClass");
      localObject1 = i(paramString, (Class)localObject1);
      if (localObject1 != null) {}
      for (paramString = ((MultiTaskUIComponent)localObject1).dks(); paramString == a.b.Aci; paramString = null)
      {
        paramString = this.AeE;
        if (paramString == null) {
          break;
        }
        localObject2 = this.tUQ.getLayoutInflater().inflate(((MultiTaskUIComponent)localObject1).getLayoutId(), null);
        paramString.addView((View)localObject2, new ViewGroup.LayoutParams(-1, -1));
        if (localObject2 != null)
        {
          ((MultiTaskUIComponent)localObject1).setRootView((View)localObject2);
          ((MultiTaskUIComponent)localObject1).getRootView().setVisibility(8);
        }
        ((MultiTaskUIComponent)localObject1).dk(null);
        AppMethodBeat.o(236557);
        return localObject1;
      }
    }
    AppMethodBeat.o(236557);
    return null;
  }
  
  public final MultiTaskUIComponent bK(int paramInt, String paramString)
  {
    AppMethodBeat.i(236554);
    p.h(paramString, "id");
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext())
    {
      MultiTaskUIComponent localMultiTaskUIComponent = (MultiTaskUIComponent)localIterator.next();
      if ((localMultiTaskUIComponent.Js(paramInt)) && (this.AeH.containsKey(paramString)) && (p.j(localMultiTaskUIComponent, (MultiTaskUIComponent)this.AeH.get(paramString))))
      {
        AppMethodBeat.o(236554);
        return localMultiTaskUIComponent;
      }
    }
    AppMethodBeat.o(236554);
    return null;
  }
  
  public final void dkr()
  {
    AppMethodBeat.i(236564);
    String str = this.TAG;
    Object localObject = this.AeG;
    if (localObject != null) {}
    for (localObject = ((MultiTaskUIComponent)localObject).toString();; localObject = null)
    {
      Log.i(str, "onMultiTaskPagePause, uic: %s", new Object[] { localObject });
      localObject = this.AeG;
      if (localObject == null) {
        break;
      }
      ((MultiTaskUIComponent)localObject).dkr();
      AppMethodBeat.o(236564);
      return;
    }
    AppMethodBeat.o(236564);
  }
  
  public a.b dks()
  {
    return a.b.Acj;
  }
  
  public final void erG()
  {
    AppMethodBeat.i(236563);
    String str = this.TAG;
    Object localObject = this.AeG;
    if (localObject != null) {}
    for (localObject = ((MultiTaskUIComponent)localObject).toString();; localObject = null)
    {
      Log.i(str, "onMultiTaskPageResume, uic: %s", new Object[] { localObject });
      AppMethodBeat.o(236563);
      return;
    }
  }
  
  public final MultiTaskUIComponent i(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(236556);
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    int i = paramMultiTaskInfo.field_type;
    this.AeG = null;
    Object localObject1 = ((Iterable)this.uiComponents).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MultiTaskUIComponent)((Iterator)localObject1).next();
      if ((((MultiTaskUIComponent)localObject2).Js(i)) && (this.AeH.containsKey(paramMultiTaskInfo.field_id)) && (p.j(localObject2, (MultiTaskUIComponent)this.AeH.get(paramMultiTaskInfo.field_id))))
      {
        if (((MultiTaskUIComponent)localObject2).dks() == a.b.Acg) {
          ((MultiTaskUIComponent)localObject2).getRootView().setVisibility(0);
        }
        this.AeG = ((MultiTaskUIComponent)localObject2);
        erG();
        AppMethodBeat.o(236556);
        return localObject2;
      }
    }
    localObject1 = PluginMultiTask.zZu;
    localObject1 = (Class)PluginMultiTask.access$getItemSelectors$cp().get(Integer.valueOf(i));
    if (localObject1 != null)
    {
      localObject2 = paramMultiTaskInfo.field_id;
      p.g(localObject1, "componentClass");
      localObject1 = i((String)localObject2, (Class)localObject1);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.ui.component.a.PRN;
        ((MultiTaskUIComponent)localObject1).zZC = ((MultiTaskUIC)com.tencent.mm.ui.component.a.b(this.tUQ).get(MultiTaskUIC.class)).AfB;
        if (localObject1 == null) {
          break label366;
        }
        localObject2 = ((MultiTaskUIComponent)localObject1).dks();
        label225:
        if (localObject2 != a.b.Acg) {
          break label372;
        }
        localObject2 = this.AeE;
        if (localObject2 != null)
        {
          View localView = this.tUQ.getLayoutInflater().inflate(((MultiTaskUIComponent)localObject1).getLayoutId(), null);
          ((MultiTaskPanelContainer)localObject2).addView(localView, new ViewGroup.LayoutParams(-1, -1));
          if (localView != null) {
            ((MultiTaskUIComponent)localObject1).setRootView(localView);
          }
          ((MultiTaskUIComponent)localObject1).onCreateBefore(this.AeI);
          ((MultiTaskUIComponent)localObject1).dk(paramMultiTaskInfo);
          ((MultiTaskUIComponent)localObject1).onCreate(this.AeI);
          ((MultiTaskUIComponent)localObject1).onCreateAfter(this.AeI);
          ((MultiTaskUIComponent)localObject1).onStart();
          if (((this.tUQ instanceof MMFragmentActivity)) && (!((MMFragmentActivity)this.tUQ).isPaused())) {
            ((MultiTaskUIComponent)localObject1).onResume();
          }
        }
      }
      for (;;)
      {
        this.AeG = ((MultiTaskUIComponent)localObject1);
        AppMethodBeat.o(236556);
        return localObject1;
        localObject1 = null;
        break;
        label366:
        localObject2 = null;
        break label225;
        label372:
        paramMultiTaskInfo = this.AeE;
        if ((paramMultiTaskInfo != null) && (localObject1 != null)) {
          ((MultiTaskUIComponent)localObject1).setRootView((View)paramMultiTaskInfo);
        }
      }
    }
    AppMethodBeat.o(236556);
    return null;
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy()
  {
    AppMethodBeat.i(236561);
    Log.i(this.TAG, "onDestroy");
    AppMethodBeat.o(236561);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(236560);
    Log.i(this.TAG, "onResume");
    AppMethodBeat.o(236560);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(236559);
    Log.i(this.TAG, "onStart");
    AppMethodBeat.o(236559);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(z.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.a
 * JD-Core Version:    0.7.0.1
 */