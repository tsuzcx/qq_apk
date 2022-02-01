package com.tencent.mm.plugin.multitask.ui.uic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.webview.ui.tools.floatball.d;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/uic/WebMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getLayoutId", "", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onTaskBarItemExposed", "onUserVisibleFocused", "onUserVisibleUnFocused", "supportMultiTaskType", "multiTaskType", "Companion", "ui-multitask_release"})
public final class WebMultiTaskUIC
  extends MultiTaskUIComponent
{
  public static final WebMultiTaskUIC.a AgH;
  
  static
  {
    AppMethodBeat.i(236738);
    AgH = new WebMultiTaskUIC.a((byte)0);
    AppMethodBeat.o(236738);
  }
  
  public WebMultiTaskUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(236737);
    AppMethodBeat.o(236737);
  }
  
  public WebMultiTaskUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(236736);
    AppMethodBeat.o(236736);
  }
  
  public final boolean Js(int paramInt)
  {
    return paramInt == 2;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, crq paramcrq, Object paramObject)
  {
    AppMethodBeat.i(236733);
    p.h(paramMultiTaskInfo, "info");
    p.h(paramcrq, "animateData");
    paramObject = new fah();
    try
    {
      paramObject.parseFrom(paramMultiTaskInfo.field_data);
      label36:
      Intent localIntent = new Intent();
      com.tencent.mm.plugin.multitask.f.b.a(localIntent, paramObject);
      int i = paramObject.Nwt;
      ach localach = new ach();
      localach.LmQ = paramcrq;
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
            break label329;
          }
          paramView = (crt)paramView.Xh(5);
          if (paramView == null) {
            break label334;
          }
        }
      }
      label329:
      label334:
      for (paramView = paramView.sGQ;; paramView = null)
      {
        localach.sGQ = paramView;
        localIntent.putExtra("rawUrl", paramObject.edo);
        localIntent.putExtra("convertActivityFromTranslucent", false);
        localIntent.putExtra("key_multi_task_common_info", localach.toByteArray());
        localIntent.putExtra("float_ball_key", paramMultiTaskInfo.field_id);
        localIntent.putExtra("key_enable_teen_mode_check", true);
        localIntent.putExtra("nextAnimIn", 2130772059);
        localIntent.putExtra("currentAnimOut", 0);
        localIntent.putExtra("minimize_secene", 0);
        localIntent.putExtra("webpageTitle", paramObject.title);
        if (i < 0) {
          break label339;
        }
        int j = paramObject.Nwo;
        int k = paramObject.Nwp;
        if ((!((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(j)) || (!((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(MMApplicationContext.getContext(), paramObject.edo, i, j, k, localIntent))) {
          break label339;
        }
        Log.i("MicroMsg.WebMultiTaskUIC", "openWebPage, use fast Load");
        AppMethodBeat.o(236733);
        return;
        paramView = null;
        break;
      }
      label339:
      c.b((Context)getActivity(), "webview", ".ui.tools.WebViewUI", localIntent);
      paramView = d.JmQ;
      d.s(paramMultiTaskInfo);
      AppMethodBeat.o(236733);
      return;
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(236735);
    p.h(paramMultiTaskInfo, "info");
    Log.d("MicroMsg.WebMultiTaskUIC", "onTaskBarItemExposed, name:%s", new Object[] { paramMultiTaskInfo.field_showData.title });
    Object localObject = new fah();
    try
    {
      ((fah)localObject).parseFrom(paramMultiTaskInfo.field_data);
      int i = ((fah)localObject).Nwt;
      String str = ((fah)localObject).edo;
      if ((i >= 0) && (!Util.isNullOrNil(str)))
      {
        int j = ((fah)localObject).Nwo;
        Log.d("MicroMsg.WebMultiTaskUIC", "addToPreload, name:%s", new Object[] { paramMultiTaskInfo.field_showData.title });
        ((com.tencent.mm.plugin.brandservice.a.b)g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(str, i, j, new Object[0]);
      }
      localObject = d.JmQ;
      d.r(paramMultiTaskInfo);
      AppMethodBeat.o(236735);
      return;
    }
    catch (Throwable paramMultiTaskInfo)
    {
      Log.e("MicroMsg.WebMultiTaskUIC", "WebMultiTaskData parse fail", new Object[] { paramMultiTaskInfo });
      AppMethodBeat.o(236735);
    }
  }
  
  public final void dF(Object paramObject)
  {
    AppMethodBeat.i(236734);
    if ((paramObject instanceof MultiTaskInfo))
    {
      Log.d("MicroMsg.WebMultiTaskUIC", "onMultiTaskItemDelete, name:%s", new Object[] { ((MultiTaskInfo)paramObject).field_showData.title });
      d locald = d.JmQ;
      d.q((MultiTaskInfo)paramObject);
    }
    AppMethodBeat.o(236734);
  }
  
  public final void dk(Object paramObject) {}
  
  public final void dkr() {}
  
  public final a.b dks()
  {
    return a.b.Ach;
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(236732);
    int i = super.getLayoutId();
    AppMethodBeat.o(236732);
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
    AppMethodBeat.i(236729);
    p.h(paramConfiguration, "newConfig");
    AppMethodBeat.o(236729);
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onCreateAfter(Bundle paramBundle) {}
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(236730);
    p.h(paramKeyEvent, "event");
    AppMethodBeat.o(236730);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(236731);
    p.h(paramKeyEvent, "event");
    AppMethodBeat.o(236731);
    return false;
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(236728);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(236728);
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
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.WebMultiTaskUIC
 * JD-Core Version:    0.7.0.1
 */