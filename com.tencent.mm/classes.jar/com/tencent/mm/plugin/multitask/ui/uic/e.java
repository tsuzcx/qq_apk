package com.tencent.mm.plugin.multitask.ui.uic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.multitask.f.b;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.secdata.ui.a;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.webview.ui.tools.floatball.d;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.protocal.protobuf.ghm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/uic/WebMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getLayoutId", "", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onTaskBarItemExposed", "onUserVisibleFocused", "onUserVisibleUnFocused", "supportMultiTaskType", "multiTaskType", "Companion", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.multitask.ui.c
{
  public static final a LIt;
  
  static
  {
    AppMethodBeat.i(304286);
    LIt = new a((byte)0);
    AppMethodBeat.o(304286);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(304276);
    AppMethodBeat.o(304276);
  }
  
  public e(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(304280);
    AppMethodBeat.o(304280);
  }
  
  public final boolean Qs(int paramInt)
  {
    return paramInt == 2;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, Object paramObject)
  {
    AppMethodBeat.i(304425);
    s.u(paramMultiTaskInfo, "info");
    s.u(paramdrt, "animateData");
    paramObject = new ghm();
    try
    {
      paramObject.parseFrom(paramMultiTaskInfo.field_data);
      label36:
      Intent localIntent = new Intent();
      b.a(localIntent, paramObject);
      int i = paramObject.acdM;
      aet localaet = new aet();
      localaet.ZmM = paramdrt;
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
            break label320;
          }
          paramView = null;
          if (paramView != null) {
            break label332;
          }
        }
      }
      label320:
      label332:
      for (paramView = null;; paramView = paramView.zIO)
      {
        localaet.zIO = paramView;
        localIntent.putExtra("rawUrl", paramObject.idu);
        localIntent.putExtra("convertActivityFromTranslucent", false);
        localIntent.putExtra("key_multi_task_common_info", localaet.toByteArray());
        localIntent.putExtra("float_ball_key", paramMultiTaskInfo.field_id);
        localIntent.putExtra("key_enable_teen_mode_check", true);
        localIntent.putExtra("nextAnimIn", com.tencent.mm.plugin.multitask.ui.e.a.fast_faded_in);
        localIntent.putExtra("currentAnimOut", 0);
        localIntent.putExtra("minimize_secene", 0);
        localIntent.putExtra("webpageTitle", paramObject.title);
        if (i < 0) {
          break label340;
        }
        int j = paramObject.acdH;
        int k = paramObject.acdI;
        if ((!((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(j)) || (!((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(MMApplicationContext.getContext(), paramObject.idu, i, j, k, localIntent))) {
          break label340;
        }
        Log.i("MicroMsg.WebMultiTaskUIC", "openWebPage, use fast Load");
        AppMethodBeat.o(304425);
        return;
        paramView = (dry)paramView.aiK(5);
        break;
      }
      label340:
      com.tencent.mm.br.c.b((Context)getActivity(), "webview", ".ui.tools.WebViewUI", localIntent);
      paramView = d.XbW;
      d.u(paramMultiTaskInfo);
      AppMethodBeat.o(304425);
      return;
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(304443);
    s.u(paramMultiTaskInfo, "info");
    Log.d("MicroMsg.WebMultiTaskUIC", "onTaskBarItemExposed, name:%s", new Object[] { paramMultiTaskInfo.field_showData.title });
    Object localObject = new ghm();
    try
    {
      ((ghm)localObject).parseFrom(paramMultiTaskInfo.field_data);
      int i = ((ghm)localObject).acdM;
      String str = ((ghm)localObject).idu;
      if ((i >= 0) && (!Util.isNullOrNil(str)))
      {
        int j = ((ghm)localObject).acdH;
        Log.d("MicroMsg.WebMultiTaskUIC", "addToPreload, name:%s", new Object[] { paramMultiTaskInfo.field_showData.title });
        ((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(str, i, j, new Object[0]);
      }
      localObject = d.XbW;
      d.t(paramMultiTaskInfo);
      AppMethodBeat.o(304443);
      return;
    }
    finally
    {
      Log.e("MicroMsg.WebMultiTaskUIC", "WebMultiTaskData parse fail", new Object[] { paramMultiTaskInfo });
      AppMethodBeat.o(304443);
    }
  }
  
  public final void eDd() {}
  
  public final a.b eDe()
  {
    return a.b.LDq;
  }
  
  public final void fZ(Object paramObject)
  {
    AppMethodBeat.i(304437);
    if ((paramObject instanceof MultiTaskInfo))
    {
      Log.d("MicroMsg.WebMultiTaskUIC", "onMultiTaskItemDelete, name:%s", new Object[] { ((MultiTaskInfo)paramObject).field_showData.title });
      d locald = d.XbW;
      d.s((MultiTaskInfo)paramObject);
    }
    AppMethodBeat.o(304437);
  }
  
  public final void fw(Object paramObject) {}
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(304398);
    int i = super.getLayoutId();
    AppMethodBeat.o(304398);
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
    AppMethodBeat.i(304356);
    s.u(paramConfiguration, "newConfig");
    AppMethodBeat.o(304356);
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onCreateAfter(Bundle paramBundle) {}
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(304383);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(304383);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(304392);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(304392);
    return false;
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(304351);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(304351);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle) {}
  
  public final void onResume() {}
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onStart() {}
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop() {}
  
  public final void onUserVisibleFocused() {}
  
  public final void onUserVisibleUnFocused() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/uic/WebMultiTaskUIC$Companion;", "", "()V", "TAG", "", "ui-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.e
 * JD-Core Version:    0.7.0.1
 */