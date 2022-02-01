package com.tencent.mm.ui.chatting.j.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.multitask.d;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.c;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getLayoutId", "", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "supportMultiTaskType", "multiTaskType", "Companion", "app_release"})
public final class a
  extends c
{
  public static final a.a WYN;
  
  static
  {
    AppMethodBeat.i(236769);
    WYN = new a.a((byte)0);
    AppMethodBeat.o(236769);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(236767);
    AppMethodBeat.o(236767);
  }
  
  public a(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(236768);
    AppMethodBeat.o(236768);
  }
  
  public final boolean Of(int paramInt)
  {
    return paramInt == 4;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, dal paramdal, Object paramObject)
  {
    AppMethodBeat.i(236766);
    p.k(paramMultiTaskInfo, "info");
    p.k(paramdal, "animateData");
    if (paramMultiTaskInfo.field_data != null)
    {
      Log.i("MicroMsg.FileMultiTaskUIC", "handleBallInfoClicked, openFile t:%s", new Object[] { paramMultiTaskInfo });
      paramObject = getActivity();
      if (!com.tencent.mm.ui.chatting.j.b.hRJ())
      {
        w.g((Context)paramObject, null);
        AppMethodBeat.o(236766);
        return;
      }
      apf localapf = new apf();
      try
      {
        localapf.parseFrom(paramMultiTaskInfo.field_data);
        String str1 = localapf.filePath;
        if (!u.agG(str1))
        {
          Log.i("MicroMsg.FileMultiTaskUIC", "handleBallInfoClicked() %s not exist", new Object[] { str1 });
          paramView = new f.a((Context)paramObject);
          paramView.aR((CharSequence)"");
          paramView.bBl(paramObject.getString(R.l.eEZ)).HL(true).icD().b((f.c)new b()).show();
          ((d)h.ag(d.class)).removeTaskInfoAndCoverImg(paramMultiTaskInfo.field_id);
          AppMethodBeat.o(236766);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("MicroMsg.FileMultiTaskUIC", "handleMultiTaskInfoClicked", new Object[] { localThrowable });
        }
        paramMultiTaskInfo = new aco();
        paramMultiTaskInfo.Soh = paramdal;
        if (paramView != null)
        {
          paramdal = com.tencent.mm.plugin.secdata.ui.a.JbV;
          paramView = paramView.getContext();
          p.j(paramView, "it.context");
          paramView = com.tencent.mm.plugin.secdata.ui.a.a.hU(paramView);
          if (paramView == null) {
            break label437;
          }
          paramView = (daq)paramView.aef(5);
          if (paramView == null) {
            break label437;
          }
        }
        label437:
        for (paramView = paramView.wmL;; paramView = null)
        {
          paramMultiTaskInfo.wmL = paramView;
          if (!localapf.SCl) {
            break;
          }
          paramView = new Intent();
          paramView.setClassName((Context)paramObject, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
          com.tencent.mm.plugin.multitask.f.b.a(paramView, localapf);
          paramView.putExtra("key_multi_task_common_info", paramMultiTaskInfo.toByteArray());
          paramMultiTaskInfo = paramView.getExtras();
          if (paramMultiTaskInfo != null) {
            paramMultiTaskInfo.putInt("scene", 9);
          }
          paramView.addFlags(268435456);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(paramObject, paramView.aFh(), "com/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC", "onMultiTaskItemClick", "(Landroid/view/View;Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramObject.startActivity((Intent)paramView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramObject, "com/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC", "onMultiTaskItemClick", "(Landroid/view/View;Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(236766);
          return;
        }
        paramView = localapf.jmx;
        paramdal = localapf.appId;
        String str2 = localapf.processName;
        boolean bool = localapf.orn;
        if (Util.isNullOrNil(str2))
        {
          if (com.tencent.mm.pluginsdk.ui.tools.a.a(localThrowable, paramView, "", 9, paramMultiTaskInfo))
          {
            com.tencent.mm.pluginsdk.ui.tools.a.a((Activity)getActivity(), localThrowable, paramView, "", 9, paramMultiTaskInfo);
            AppMethodBeat.o(236766);
          }
        }
        else {
          ((f)h.ae(f.class)).a((Context)paramObject, localThrowable, paramView, paramdal, bool, str2);
        }
      }
    }
    AppMethodBeat.o(236766);
  }
  
  public final void dKo() {}
  
  public final com.tencent.mm.plugin.multitask.ui.a.b dKp()
  {
    return com.tencent.mm.plugin.multitask.ui.a.b.FHX;
  }
  
  public final void dp(Object paramObject) {}
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(236758);
    int i = super.getLayoutId();
    AppMethodBeat.o(236758);
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
    AppMethodBeat.i(236739);
    p.k(paramConfiguration, "newConfig");
    AppMethodBeat.o(236739);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(236714);
    getRootView().findViewById(getLayoutId());
    AppMethodBeat.o(236714);
  }
  
  public final void onCreateAfter(Bundle paramBundle) {}
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(236751);
    p.k(paramKeyEvent, "event");
    AppMethodBeat.o(236751);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(236754);
    p.k(paramKeyEvent, "event");
    AppMethodBeat.o(236754);
    return false;
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(236735);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(236735);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle) {}
  
  public final void onResume() {}
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onStart() {}
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop() {}
  
  public final void onUserVisibleFocused() {}
  
  public final void onUserVisibleUnFocused() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC$onMultiTaskItemClick$1$1", "Lcom/tencent/mm/ui/widget/dialog/MMConfirmDialog$IOnDialogClick;", "onDialogClick", "", "bOk", "", "text", "", "app_release"})
  public static final class b
    implements f.c
  {
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(266198);
      if (paramBoolean)
      {
        paramString = (d)h.ag(d.class);
        g localg = g.FEX;
        paramString.sendMultiTaskEvent(0, g.fan(), 1048576);
      }
      AppMethodBeat.o(266198);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.a.a
 * JD-Core Version:    0.7.0.1
 */