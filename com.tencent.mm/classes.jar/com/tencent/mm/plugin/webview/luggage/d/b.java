package com.tencent.mm.plugin.webview.luggage.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.fky;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/luggage/webview_impl/LuggageWebMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getLayoutId", "", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "supportMultiTaskType", "multiTaskType", "Companion", "IOnMultiTaskEventListener", "plugin-webview_release"})
public final class b
  extends com.tencent.mm.plugin.multitask.ui.c
{
  public static final a PTA;
  private static final LinkedList<b> PTz;
  
  static
  {
    AppMethodBeat.i(250944);
    PTA = new a((byte)0);
    PTz = new LinkedList();
    AppMethodBeat.o(250944);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250939);
    AppMethodBeat.o(250939);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(250941);
    AppMethodBeat.o(250941);
  }
  
  public final boolean Of(int paramInt)
  {
    return paramInt == 2;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, dal paramdal, Object paramObject)
  {
    AppMethodBeat.i(250929);
    p.k(paramMultiTaskInfo, "info");
    p.k(paramdal, "animateData");
    Object localObject = new fky();
    try
    {
      ((fky)localObject).parseFrom(paramMultiTaskInfo.field_data);
      label36:
      paramObject = new Intent();
      paramObject.putExtra("rawUrl", ((fky)localObject).fXu);
      paramObject.putExtra("title", ((fky)localObject).title);
      paramObject.putExtra("KMutilTaskInfo", (Parcelable)paramMultiTaskInfo);
      paramObject.putExtra("webview_bg_color_rsID", 17170445);
      localObject = new aco();
      ((aco)localObject).Soh = paramdal;
      if (paramView != null)
      {
        paramdal = a.JbV;
        paramdal = paramView.getContext();
        p.j(paramdal, "view.context");
        if (a.a.hU(paramdal) != null)
        {
          paramdal = a.JbV;
          paramView = paramView.getContext();
          p.j(paramView, "view.context");
          paramView = a.a.hU(paramView);
          if (paramView == null) {
            break label265;
          }
          paramView = (daq)paramView.aef(5);
          if (paramView == null) {
            break label270;
          }
        }
      }
      label265:
      label270:
      for (paramView = paramView.wmL;; paramView = null)
      {
        ((aco)localObject).wmL = paramView;
        paramObject.putExtra("key_multi_task_common_info", ((aco)localObject).toByteArray());
        paramObject.putExtra("float_ball_key", paramMultiTaskInfo.field_id);
        Log.i("MicroMsg.LuggageWebMultiTaskUIC", "onMultiTaskItemClick, id = " + paramMultiTaskInfo.field_id);
        com.tencent.mm.by.c.b((Context)getActivity(), "webview", ".ui.tools.WebViewUI", paramObject);
        com.tencent.mm.ui.base.b.lc((Context)getActivity());
        AppMethodBeat.o(250929);
        return;
        paramView = null;
        break;
      }
    }
    catch (Exception paramObject)
    {
      break label36;
    }
  }
  
  public final void dI(Object paramObject)
  {
    AppMethodBeat.i(250932);
    if ((paramObject instanceof MultiTaskInfo))
    {
      paramObject = (MultiTaskInfo)paramObject;
      p.k(paramObject, "info");
      Iterator localIterator = ((Iterable)PTz).iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).r(paramObject);
      }
    }
    AppMethodBeat.o(250932);
  }
  
  public final void dKo() {}
  
  public final a.b dKp()
  {
    return a.b.FHX;
  }
  
  public final void dp(Object paramObject) {}
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(250916);
    int i = super.getLayoutId();
    AppMethodBeat.o(250916);
    return i;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPressed()
  {
    return false;
  }
  
  public final void onBeforeFinish(Intent paramIntent) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(250903);
    p.k(paramConfiguration, "newConfig");
    AppMethodBeat.o(250903);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250891);
    getRootView().findViewById(getLayoutId());
    AppMethodBeat.o(250891);
  }
  
  public final void onCreateAfter(Bundle paramBundle) {}
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(250909);
    p.k(paramKeyEvent, "event");
    AppMethodBeat.o(250909);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(250913);
    p.k(paramKeyEvent, "event");
    AppMethodBeat.o(250913);
    return false;
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(250902);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(250902);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle) {}
  
  public final void onResume() {}
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onStart() {}
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop() {}
  
  public final void onUserVisibleFocused() {}
  
  public final void onUserVisibleUnFocused() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/luggage/webview_impl/LuggageWebMultiTaskUIC$Companion;", "", "()V", "TAG", "", "onMultiTaskEventListenerList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/luggage/webview_impl/LuggageWebMultiTaskUIC$IOnMultiTaskEventListener;", "getOnMultiTaskEventListenerList", "()Ljava/util/LinkedList;", "addMultiTaskEventListener", "", "listener", "notifyItemClick", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "notifyItemDelete", "removeMultiTaskEventListener", "plugin-webview_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/luggage/webview_impl/LuggageWebMultiTaskUIC$IOnMultiTaskEventListener;", "", "onItemClick", "", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onItemDelete", "plugin-webview_release"})
  public static abstract interface b
  {
    public abstract void r(MultiTaskInfo paramMultiTaskInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.b
 * JD-Core Version:    0.7.0.1
 */