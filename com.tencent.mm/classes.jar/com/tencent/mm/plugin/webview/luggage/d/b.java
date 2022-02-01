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
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.protocal.protobuf.ghm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/luggage/webview_impl/LuggageWebMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getLayoutId", "", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "supportMultiTaskType", "multiTaskType", "Companion", "IOnMultiTaskEventListener", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.multitask.ui.c
{
  public static final a WKl;
  private static final LinkedList<b> WKm;
  
  static
  {
    AppMethodBeat.i(295987);
    WKl = new a((byte)0);
    WKm = new LinkedList();
    AppMethodBeat.o(295987);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(295979);
    AppMethodBeat.o(295979);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(295982);
    AppMethodBeat.o(295982);
  }
  
  public final boolean Qs(int paramInt)
  {
    return paramInt == 2;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, Object paramObject)
  {
    AppMethodBeat.i(296031);
    s.u(paramMultiTaskInfo, "info");
    s.u(paramdrt, "animateData");
    Object localObject = new ghm();
    try
    {
      ((ghm)localObject).parseFrom(paramMultiTaskInfo.field_data);
      label36:
      paramObject = new Intent();
      paramObject.putExtra("rawUrl", ((ghm)localObject).idu);
      paramObject.putExtra("title", ((ghm)localObject).title);
      paramObject.putExtra("KMutilTaskInfo", (Parcelable)paramMultiTaskInfo);
      paramObject.putExtra("webview_bg_color_rsID", 17170445);
      localObject = new aet();
      ((aet)localObject).ZmM = paramdrt;
      if (paramView != null)
      {
        paramdrt = a.PlI;
        paramdrt = paramView.getContext();
        s.s(paramdrt, "view.context");
        if (a.a.jC(paramdrt) != null)
        {
          paramdrt = a.PlI;
          paramView = paramView.getContext();
          s.s(paramView, "view.context");
          paramView = a.a.jC(paramView);
          if (paramView != null) {
            break label243;
          }
          paramView = null;
          if (paramView != null) {
            break label255;
          }
        }
      }
      label243:
      label255:
      for (paramView = null;; paramView = paramView.zIO)
      {
        ((aet)localObject).zIO = paramView;
        paramObject.putExtra("key_multi_task_common_info", ((aet)localObject).toByteArray());
        paramObject.putExtra("float_ball_key", paramMultiTaskInfo.field_id);
        Log.i("MicroMsg.LuggageWebMultiTaskUIC", s.X("onMultiTaskItemClick, id = ", paramMultiTaskInfo.field_id));
        com.tencent.mm.br.c.b((Context)getActivity(), "webview", ".ui.tools.WebViewUI", paramObject);
        com.tencent.mm.ui.base.b.ng((Context)getActivity());
        AppMethodBeat.o(296031);
        return;
        paramView = (dry)paramView.aiK(5);
        break;
      }
    }
    catch (Exception paramObject)
    {
      break label36;
    }
  }
  
  public final void eDd() {}
  
  public final a.b eDe()
  {
    return a.b.LDq;
  }
  
  public final void fZ(Object paramObject)
  {
    AppMethodBeat.i(296033);
    if ((paramObject instanceof MultiTaskInfo))
    {
      paramObject = (MultiTaskInfo)paramObject;
      s.u(paramObject, "info");
      Iterator localIterator = ((Iterable)WKm).iterator();
      while (localIterator.hasNext()) {
        ((b)localIterator.next()).r(paramObject);
      }
    }
    AppMethodBeat.o(296033);
  }
  
  public final void fw(Object paramObject) {}
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(296029);
    int i = super.getLayoutId();
    AppMethodBeat.o(296029);
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
    AppMethodBeat.i(296017);
    s.u(paramConfiguration, "newConfig");
    AppMethodBeat.o(296017);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(295991);
    getRootView().findViewById(getLayoutId());
    AppMethodBeat.o(295991);
  }
  
  public final void onCreateAfter(Bundle paramBundle) {}
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(296023);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(296023);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(296026);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(296026);
    return false;
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(296014);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(296014);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle) {}
  
  public final void onResume() {}
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onStart() {}
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop() {}
  
  public final void onUserVisibleFocused() {}
  
  public final void onUserVisibleUnFocused() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/luggage/webview_impl/LuggageWebMultiTaskUIC$Companion;", "", "()V", "TAG", "", "onMultiTaskEventListenerList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/webview/luggage/webview_impl/LuggageWebMultiTaskUIC$IOnMultiTaskEventListener;", "getOnMultiTaskEventListenerList", "()Ljava/util/LinkedList;", "addMultiTaskEventListener", "", "listener", "notifyItemClick", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "notifyItemDelete", "removeMultiTaskEventListener", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/luggage/webview_impl/LuggageWebMultiTaskUIC$IOnMultiTaskEventListener;", "", "onItemClick", "", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "onItemDelete", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void r(MultiTaskInfo paramMultiTaskInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.b
 * JD-Core Version:    0.7.0.1
 */