package com.tencent.mm.plugin.webview.luggage.webview_impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.b;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/luggage/webview_impl/LuggageWebMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getLayoutId", "", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "supportMultiTaskType", "multiTaskType", "Companion", "IOnMultiTaskEventListener", "plugin-webview_release"})
public final class LuggageWebMultiTaskUIC
  extends MultiTaskUIComponent
{
  private static final LinkedList<LuggageWebMultiTaskUIC.b> IXj;
  public static final LuggageWebMultiTaskUIC.a IXk;
  
  static
  {
    AppMethodBeat.i(210345);
    IXk = new LuggageWebMultiTaskUIC.a((byte)0);
    IXj = new LinkedList();
    AppMethodBeat.o(210345);
  }
  
  public LuggageWebMultiTaskUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(210344);
    AppMethodBeat.o(210344);
  }
  
  public LuggageWebMultiTaskUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(210343);
    AppMethodBeat.o(210343);
  }
  
  public final boolean Js(int paramInt)
  {
    return paramInt == 2;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, crq paramcrq, Object paramObject)
  {
    AppMethodBeat.i(210341);
    p.h(paramMultiTaskInfo, "info");
    p.h(paramcrq, "animateData");
    Object localObject = new fah();
    try
    {
      ((fah)localObject).parseFrom(paramMultiTaskInfo.field_data);
      label36:
      paramObject = new Intent();
      paramObject.putExtra("rawUrl", ((fah)localObject).edo);
      paramObject.putExtra("title", ((fah)localObject).title);
      paramObject.putExtra("KMutilTaskInfo", (Parcelable)paramMultiTaskInfo);
      paramObject.putExtra("webview_bg_color_rsID", 17170445);
      localObject = new ach();
      ((ach)localObject).LmQ = paramcrq;
      if (paramView != null)
      {
        paramcrq = SecDataUIC.CWq;
        paramcrq = paramView.getContext();
        p.g(paramcrq, "view.context");
        if (SecDataUIC.a.gU(paramcrq) != null)
        {
          paramcrq = SecDataUIC.CWq;
          paramView = paramView.getContext();
          p.g(paramView, "view.context");
          paramView = SecDataUIC.a.gU(paramView);
          if (paramView == null) {
            break label265;
          }
          paramView = (crt)paramView.Xh(5);
          if (paramView == null) {
            break label270;
          }
        }
      }
      label265:
      label270:
      for (paramView = paramView.sGQ;; paramView = null)
      {
        ((ach)localObject).sGQ = paramView;
        paramObject.putExtra("key_multi_task_common_info", ((ach)localObject).toByteArray());
        paramObject.putExtra("float_ball_key", paramMultiTaskInfo.field_id);
        Log.i("MicroMsg.LuggageWebMultiTaskUIC", "onMultiTaskItemClick, id = " + paramMultiTaskInfo.field_id);
        c.b((Context)getActivity(), "webview", ".ui.tools.WebViewUI", paramObject);
        b.ke((Context)getActivity());
        AppMethodBeat.o(210341);
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
  
  public final void dF(Object paramObject)
  {
    AppMethodBeat.i(210342);
    if ((paramObject instanceof MultiTaskInfo))
    {
      paramObject = (MultiTaskInfo)paramObject;
      p.h(paramObject, "info");
      Iterator localIterator = ((Iterable)IXj).iterator();
      while (localIterator.hasNext()) {
        ((LuggageWebMultiTaskUIC.b)localIterator.next()).p(paramObject);
      }
    }
    AppMethodBeat.o(210342);
  }
  
  public final void dk(Object paramObject) {}
  
  public final void dkr() {}
  
  public final a.b dks()
  {
    return a.b.Ach;
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(210340);
    int i = super.getLayoutId();
    AppMethodBeat.o(210340);
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
    AppMethodBeat.i(210337);
    p.h(paramConfiguration, "newConfig");
    AppMethodBeat.o(210337);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(210335);
    getRootView().findViewById(getLayoutId());
    AppMethodBeat.o(210335);
  }
  
  public final void onCreateAfter(Bundle paramBundle) {}
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(210338);
    p.h(paramKeyEvent, "event");
    AppMethodBeat.o(210338);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(210339);
    p.h(paramKeyEvent, "event");
    AppMethodBeat.o(210339);
    return false;
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(210336);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(210336);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle) {}
  
  public final void onResume() {}
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onStart() {}
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop() {}
  
  public final void onUserVisibleFocused() {}
  
  public final void onUserVisibleUnFocused() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.webview_impl.LuggageWebMultiTaskUIC
 * JD-Core Version:    0.7.0.1
 */