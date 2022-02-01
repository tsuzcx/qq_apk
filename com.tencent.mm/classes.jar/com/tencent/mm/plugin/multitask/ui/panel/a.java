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
import com.tencent.mm.plugin.multitask.ui.uic.b;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.i;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/panel/BaseMultiTaskPanel;", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "onCreateInstanceState", "Landroid/os/Bundle;", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/os/Bundle;)V", "TAG", "", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "currentUiComponent", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "getCurrentUiComponent", "()Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "setCurrentUiComponent", "(Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;)V", "getOnCreateInstanceState", "()Landroid/os/Bundle;", "panelView", "Landroid/view/View;", "getPanelView", "()Landroid/view/View;", "setPanelView", "(Landroid/view/View;)V", "panelWindowContainer", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;", "getPanelWindowContainer", "()Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;", "setPanelWindowContainer", "(Lcom/tencent/mm/plugin/multitask/ui/MultiTaskPanelContainer;)V", "uiComponentMaps", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getUiComponentMaps", "()Ljava/util/HashMap;", "setUiComponentMaps", "(Ljava/util/HashMap;)V", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getUiComponents", "()Ljava/util/HashSet;", "findUIComponent", "componetType", "", "id", "findUIComponentClass", "Ljava/lang/Class;", "multiTaskType", "getCurrentUIC", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getSnapShotUIC", "getTitle", "getUIComponent", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getView", "position", "hideUIComponent", "", "initPanelWindowContainer", "", "container", "isMinusScreenUIC", "isSingleSceneShow", "newUIComponent", "modelClass", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskPageDestroy", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "removeUIComponet", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  implements com.tencent.mm.plugin.multitask.ui.a
{
  private final Bundle LGo;
  public MultiTaskPanelContainer LGp;
  public View LGq;
  public com.tencent.mm.plugin.multitask.ui.c LGr;
  HashMap<String, com.tencent.mm.plugin.multitask.ui.c> LGs;
  private final String TAG;
  public final AppCompatActivity activity;
  private final HashSet<com.tencent.mm.plugin.multitask.ui.c> uiComponents;
  
  public a(AppCompatActivity paramAppCompatActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(304560);
    this.activity = paramAppCompatActivity;
    this.LGo = paramBundle;
    this.TAG = "MicroMsg.MultiTask.MultiTaskPanelItem";
    this.uiComponents = new HashSet();
    this.LGs = new HashMap();
    AppMethodBeat.o(304560);
  }
  
  private com.tencent.mm.plugin.multitask.ui.c m(String paramString, Class<? extends com.tencent.mm.plugin.multitask.ui.c> paramClass)
  {
    AppMethodBeat.i(304580);
    s.u(paramClass, "modelClass");
    com.tencent.mm.plugin.multitask.ui.c localc = null;
    if (i.class.isAssignableFrom(paramClass)) {}
    try
    {
      localc = (com.tencent.mm.plugin.multitask.ui.c)paramClass.getConstructor(new Class[] { AppCompatActivity.class }).newInstance(new Object[] { this.activity });
      if (localc != null)
      {
        this.uiComponents.add(localc);
        if (paramString != null) {
          this.LGs.put(paramString, localc);
        }
      }
      AppMethodBeat.o(304580);
      return localc;
    }
    catch (NoSuchMethodException paramString)
    {
      paramString = new RuntimeException(s.X("Cannot create an instance of ", paramClass), (Throwable)paramString);
      AppMethodBeat.o(304580);
      throw paramString;
    }
    catch (IllegalAccessException paramString)
    {
      paramString = new RuntimeException(s.X("Cannot create an instance of ", paramClass), (Throwable)paramString);
      AppMethodBeat.o(304580);
      throw paramString;
    }
    catch (InstantiationException paramString)
    {
      paramString = new RuntimeException(s.X("Cannot create an instance of ", paramClass), (Throwable)paramString);
      AppMethodBeat.o(304580);
      throw paramString;
    }
    catch (InvocationTargetException paramString)
    {
      paramString = new RuntimeException(s.X("Cannot create an instance of ", paramClass), (Throwable)paramString);
      AppMethodBeat.o(304580);
      throw paramString;
    }
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, Object paramObject)
  {
    AppMethodBeat.i(304768);
    s.u(this, "this");
    s.u(paramMultiTaskInfo, "info");
    s.u(paramdrt, "animateData");
    AppMethodBeat.o(304768);
  }
  
  public void a(MultiTaskPanelContainer paramMultiTaskPanelContainer)
  {
    AppMethodBeat.i(304642);
    s.u(paramMultiTaskPanelContainer, "container");
    onCreateBefore(this.LGo);
    onCreate(this.LGo);
    onCreateAfter(this.LGo);
    onStart();
    onResume();
    AppMethodBeat.o(304642);
  }
  
  public final boolean aNV(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(304610);
    s.u(paramString, "id");
    if (this.LGs.containsKey(paramString))
    {
      com.tencent.mm.plugin.multitask.ui.c localc = (com.tencent.mm.plugin.multitask.ui.c)this.LGs.get(paramString);
      Collection localCollection = (Collection)this.uiComponents;
      if (localCollection == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(304610);
        throw paramString;
      }
      an.hA(localCollection).remove(localc);
      this.LGs.remove(paramString);
      if (localc == null)
      {
        paramString = null;
        if (paramString != a.b.LDp)
        {
          if (localc != null) {
            break label167;
          }
          paramString = localObject;
        }
      }
      for (;;)
      {
        if (paramString == a.b.LDr) {
          if (localc.getRootView().getParent() != null)
          {
            paramString = localc.getRootView().getParent();
            if (paramString == null)
            {
              paramString = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
              AppMethodBeat.o(304610);
              throw paramString;
              paramString = localc.eDe();
              break;
              label167:
              paramString = localc.eDe();
              continue;
            }
            ((ViewGroup)paramString).removeView(localc.getRootView());
          }
        }
      }
      AppMethodBeat.o(304610);
      return true;
    }
    AppMethodBeat.o(304610);
    return false;
  }
  
  public final com.tencent.mm.plugin.multitask.ui.c aNW(String paramString)
  {
    AppMethodBeat.i(304632);
    s.u(paramString, "id");
    Object localObject1 = ((Iterable)this.uiComponents).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.multitask.ui.c)((Iterator)localObject1).next();
      if ((((com.tencent.mm.plugin.multitask.ui.c)localObject2).Qs(1048576)) && (this.LGs.containsKey(paramString)) && (s.p(localObject2, this.LGs.get(paramString))))
      {
        AppMethodBeat.o(304632);
        return localObject2;
      }
    }
    localObject1 = PluginMultiTask.LBi;
    localObject1 = (Class)PluginMultiTask.access$getItemSelectors$cp().get(Integer.valueOf(1048576));
    if (localObject1 != null)
    {
      localObject1 = m(paramString, (Class)localObject1);
      if (localObject1 == null) {}
      for (paramString = null; paramString == a.b.LDr; paramString = ((com.tencent.mm.plugin.multitask.ui.c)localObject1).eDe())
      {
        paramString = this.LGp;
        if (paramString == null) {
          break;
        }
        localObject2 = this.activity.getLayoutInflater().inflate(((com.tencent.mm.plugin.multitask.ui.c)localObject1).getLayoutId(), null);
        paramString.addView((View)localObject2, new ViewGroup.LayoutParams(-1, -1));
        if (localObject2 != null)
        {
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).setRootView((View)localObject2);
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).getRootView().setVisibility(8);
        }
        ((com.tencent.mm.plugin.multitask.ui.c)localObject1).fw(null);
        AppMethodBeat.o(304632);
        return localObject1;
      }
    }
    AppMethodBeat.o(304632);
    return null;
  }
  
  public final com.tencent.mm.plugin.multitask.ui.c cq(int paramInt, String paramString)
  {
    AppMethodBeat.i(304602);
    s.u(paramString, "id");
    Iterator localIterator = ((Iterable)this.uiComponents).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.multitask.ui.c localc = (com.tencent.mm.plugin.multitask.ui.c)localIterator.next();
      if ((localc.Qs(paramInt)) && (this.LGs.containsKey(paramString)) && (s.p(localc, this.LGs.get(paramString))))
      {
        AppMethodBeat.o(304602);
        return localc;
      }
    }
    AppMethodBeat.o(304602);
    return null;
  }
  
  public final void eDd()
  {
    AppMethodBeat.i(304759);
    String str = this.TAG;
    Object localObject = this.LGr;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.multitask.ui.c)localObject).toString())
    {
      Log.i(str, "onMultiTaskPagePause, uic: %s", new Object[] { localObject });
      localObject = this.LGr;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.ui.c)localObject).eDd();
      }
      AppMethodBeat.o(304759);
      return;
    }
  }
  
  public a.b eDe()
  {
    return a.b.LDs;
  }
  
  public final HashSet<com.tencent.mm.plugin.multitask.ui.c> getUiComponents()
  {
    return this.uiComponents;
  }
  
  public final void gkQ()
  {
    AppMethodBeat.i(304756);
    String str = this.TAG;
    Object localObject = this.LGr;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.multitask.ui.c)localObject).toString())
    {
      Log.i(str, "onMultiTaskPageResume, uic: %s", new Object[] { localObject });
      AppMethodBeat.o(304756);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.multitask.ui.c h(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(304623);
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    int i = paramMultiTaskInfo.field_type;
    this.LGr = null;
    Object localObject1 = ((Iterable)this.uiComponents).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.mm.plugin.multitask.ui.c)((Iterator)localObject1).next();
      if ((((com.tencent.mm.plugin.multitask.ui.c)localObject2).Qs(i)) && (this.LGs.containsKey(paramMultiTaskInfo.field_id)) && (s.p(localObject2, this.LGs.get(paramMultiTaskInfo.field_id))))
      {
        if (((com.tencent.mm.plugin.multitask.ui.c)localObject2).eDe() == a.b.LDp) {
          ((com.tencent.mm.plugin.multitask.ui.c)localObject2).getRootView().setVisibility(0);
        }
        this.LGr = ((com.tencent.mm.plugin.multitask.ui.c)localObject2);
        gkQ();
        AppMethodBeat.o(304623);
        return localObject2;
      }
    }
    localObject1 = PluginMultiTask.LBi;
    localObject1 = (Class)PluginMultiTask.access$getItemSelectors$cp().get(Integer.valueOf(i));
    if (localObject1 != null)
    {
      localObject1 = m(paramMultiTaskInfo.field_id, (Class)localObject1);
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label354;
        }
        localObject2 = null;
        label182:
        if (localObject2 != a.b.LDp) {
          break label363;
        }
        localObject2 = this.LGp;
        if (localObject2 != null)
        {
          View localView = this.activity.getLayoutInflater().inflate(((com.tencent.mm.plugin.multitask.ui.c)localObject1).getLayoutId(), null);
          ((MultiTaskPanelContainer)localObject2).addView(localView, new ViewGroup.LayoutParams(-1, -1));
          if (localView != null) {
            ((com.tencent.mm.plugin.multitask.ui.c)localObject1).setRootView(localView);
          }
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).onCreateBefore(this.LGo);
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).fw(paramMultiTaskInfo);
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).onCreate(this.LGo);
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).onCreateAfter(this.LGo);
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).onStart();
          if (((this.activity instanceof MMFragmentActivity)) && (!((MMFragmentActivity)this.activity).isPaused())) {
            ((com.tencent.mm.plugin.multitask.ui.c)localObject1).onResume();
          }
        }
      }
      for (;;)
      {
        this.LGr = ((com.tencent.mm.plugin.multitask.ui.c)localObject1);
        AppMethodBeat.o(304623);
        return localObject1;
        localObject2 = k.aeZF;
        ((com.tencent.mm.plugin.multitask.ui.c)localObject1).LBs = ((com.tencent.mm.plugin.multitask.ui.uic.c)k.d(this.activity).q(com.tencent.mm.plugin.multitask.ui.uic.c.class)).LHm;
        localObject2 = ah.aiuX;
        break;
        label354:
        localObject2 = ((com.tencent.mm.plugin.multitask.ui.c)localObject1).eDe();
        break label182;
        label363:
        paramMultiTaskInfo = this.LGp;
        if ((paramMultiTaskInfo != null) && (localObject1 != null)) {
          ((com.tencent.mm.plugin.multitask.ui.c)localObject1).setRootView((View)paramMultiTaskInfo);
        }
      }
    }
    AppMethodBeat.o(304623);
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
    AppMethodBeat.i(304748);
    s.u(paramConfiguration, "newConfig");
    Object localObject = com.tencent.mm.plugin.multitask.g.LBa;
    localObject = cq(0, com.tencent.mm.plugin.multitask.g.gjr());
    if (localObject != null)
    {
      ((b)localObject).onConfigurationChanged(paramConfiguration);
      AppMethodBeat.o(304748);
      return;
    }
    AppMethodBeat.o(304748);
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onCreateAfter(Bundle paramBundle) {}
  
  public void onCreateBefore(Bundle paramBundle) {}
  
  public void onDestroy()
  {
    AppMethodBeat.i(304724);
    Log.i(this.TAG, "onDestroy");
    AppMethodBeat.o(304724);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(304740);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(304740);
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(304744);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(304744);
    return false;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(304771);
    paramIntent = (com.tencent.mm.plugin.multitask.ui.a)this;
    s.u(paramIntent, "this");
    s.u((com.tencent.mm.ui.component.g)paramIntent, "this");
    AppMethodBeat.o(304771);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(304706);
    Log.i(this.TAG, "onPause");
    AppMethodBeat.o(304706);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(304735);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(304735);
  }
  
  public void onRestoreInstanceState(Bundle paramBundle) {}
  
  public void onResume()
  {
    AppMethodBeat.i(304695);
    Log.i(this.TAG, "onResume");
    AppMethodBeat.o(304695);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    AppMethodBeat.i(304684);
    Log.i(this.TAG, "onStart");
    AppMethodBeat.o(304684);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(304714);
    Log.i(this.TAG, "onStop");
    AppMethodBeat.o(304714);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(ah.f<com.tencent.mm.plugin.multitask.ui.c> paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.panel.a
 * JD-Core Version:    0.7.0.1
 */