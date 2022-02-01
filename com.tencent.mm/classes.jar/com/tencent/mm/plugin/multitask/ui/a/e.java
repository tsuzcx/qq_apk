package com.tencent.mm.plugin.multitask.ui.a;

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
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.fky;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/uic/WebMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getLayoutId", "", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskItemDelete", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onTaskBarItemExposed", "onUserVisibleFocused", "onUserVisibleUnFocused", "supportMultiTaskType", "multiTaskType", "Companion", "ui-multitask_release"})
public final class e
  extends com.tencent.mm.plugin.multitask.ui.c
{
  public static final a FNx;
  
  static
  {
    AppMethodBeat.i(196195);
    FNx = new a((byte)0);
    AppMethodBeat.o(196195);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(196191);
    AppMethodBeat.o(196191);
  }
  
  public e(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(196192);
    AppMethodBeat.o(196192);
  }
  
  public final boolean Of(int paramInt)
  {
    return paramInt == 2;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, dal paramdal, Object paramObject)
  {
    AppMethodBeat.i(196178);
    p.k(paramMultiTaskInfo, "info");
    p.k(paramdal, "animateData");
    paramObject = new fky();
    try
    {
      paramObject.parseFrom(paramMultiTaskInfo.field_data);
      label36:
      Intent localIntent = new Intent();
      b.a(localIntent, paramObject);
      int i = paramObject.UJE;
      aco localaco = new aco();
      localaco.Soh = paramdal;
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
            break label330;
          }
          paramView = (daq)paramView.aef(5);
          if (paramView == null) {
            break label335;
          }
        }
      }
      label330:
      label335:
      for (paramView = paramView.wmL;; paramView = null)
      {
        localaco.wmL = paramView;
        localIntent.putExtra("rawUrl", paramObject.fXu);
        localIntent.putExtra("convertActivityFromTranslucent", false);
        localIntent.putExtra("key_multi_task_common_info", localaco.toByteArray());
        localIntent.putExtra("float_ball_key", paramMultiTaskInfo.field_id);
        localIntent.putExtra("key_enable_teen_mode_check", true);
        localIntent.putExtra("nextAnimIn", com.tencent.mm.plugin.multitask.ui.e.a.fast_faded_in);
        localIntent.putExtra("currentAnimOut", 0);
        localIntent.putExtra("minimize_secene", 0);
        localIntent.putExtra("webpageTitle", paramObject.title);
        if (i < 0) {
          break label340;
        }
        int j = paramObject.UJz;
        int k = paramObject.UJA;
        if ((!((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(j)) || (!((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(MMApplicationContext.getContext(), paramObject.fXu, i, j, k, localIntent))) {
          break label340;
        }
        Log.i("MicroMsg.WebMultiTaskUIC", "openWebPage, use fast Load");
        AppMethodBeat.o(196178);
        return;
        paramView = null;
        break;
      }
      label340:
      com.tencent.mm.by.c.b((Context)getActivity(), "webview", ".ui.tools.WebViewUI", localIntent);
      paramView = d.Qkh;
      d.u(paramMultiTaskInfo);
      AppMethodBeat.o(196178);
      return;
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(196188);
    p.k(paramMultiTaskInfo, "info");
    Log.d("MicroMsg.WebMultiTaskUIC", "onTaskBarItemExposed, name:%s", new Object[] { paramMultiTaskInfo.field_showData.title });
    Object localObject = new fky();
    try
    {
      ((fky)localObject).parseFrom(paramMultiTaskInfo.field_data);
      int i = ((fky)localObject).UJE;
      String str = ((fky)localObject).fXu;
      if ((i >= 0) && (!Util.isNullOrNil(str)))
      {
        int j = ((fky)localObject).UJz;
        Log.d("MicroMsg.WebMultiTaskUIC", "addToPreload, name:%s", new Object[] { paramMultiTaskInfo.field_showData.title });
        ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(str, i, j, new Object[0]);
      }
      localObject = d.Qkh;
      d.t(paramMultiTaskInfo);
      AppMethodBeat.o(196188);
      return;
    }
    catch (Throwable paramMultiTaskInfo)
    {
      Log.e("MicroMsg.WebMultiTaskUIC", "WebMultiTaskData parse fail", new Object[] { paramMultiTaskInfo });
      AppMethodBeat.o(196188);
    }
  }
  
  public final void dI(Object paramObject)
  {
    AppMethodBeat.i(196182);
    if ((paramObject instanceof MultiTaskInfo))
    {
      Log.d("MicroMsg.WebMultiTaskUIC", "onMultiTaskItemDelete, name:%s", new Object[] { ((MultiTaskInfo)paramObject).field_showData.title });
      d locald = d.Qkh;
      d.s((MultiTaskInfo)paramObject);
    }
    AppMethodBeat.o(196182);
  }
  
  public final void dKo() {}
  
  public final a.b dKp()
  {
    return a.b.FHX;
  }
  
  public final void dp(Object paramObject) {}
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(196161);
    int i = super.getLayoutId();
    AppMethodBeat.o(196161);
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
    AppMethodBeat.i(196153);
    p.k(paramConfiguration, "newConfig");
    AppMethodBeat.o(196153);
  }
  
  public final void onCreate(Bundle paramBundle) {}
  
  public final void onCreateAfter(Bundle paramBundle) {}
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(196158);
    p.k(paramKeyEvent, "event");
    AppMethodBeat.o(196158);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(196159);
    p.k(paramKeyEvent, "event");
    AppMethodBeat.o(196159);
    return false;
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196150);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(196150);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle) {}
  
  public final void onResume() {}
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onStart() {}
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop() {}
  
  public final void onUserVisibleFocused() {}
  
  public final void onUserVisibleUnFocused() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/uic/WebMultiTaskUIC$Companion;", "", "()V", "TAG", "", "ui-multitask_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a.e
 * JD-Core Version:    0.7.0.1
 */