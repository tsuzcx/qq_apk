package com.tencent.mm.ui.chatting.multitask.a;

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
import com.tencent.mm.plugin.multitask.d;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.c;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getLayoutId", "", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "supportMultiTaskType", "multiTaskType", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
{
  public static final a aeIn;
  
  static
  {
    AppMethodBeat.i(254019);
    aeIn = new a((byte)0);
    AppMethodBeat.o(254019);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(254015);
    AppMethodBeat.o(254015);
  }
  
  public a(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(254017);
    AppMethodBeat.o(254017);
  }
  
  public final boolean Qs(int paramInt)
  {
    return paramInt == 4;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, Object paramObject)
  {
    AppMethodBeat.i(254091);
    s.u(paramMultiTaskInfo, "info");
    s.u(paramdrt, "animateData");
    if (paramMultiTaskInfo.field_data != null)
    {
      Log.i("MicroMsg.FileMultiTaskUIC", "handleBallInfoClicked, openFile t:%s", new Object[] { paramMultiTaskInfo });
      paramObject = getActivity();
      if (!com.tencent.mm.ui.chatting.multitask.b.jvh())
      {
        aa.j((Context)paramObject, null);
        AppMethodBeat.o(254091);
        return;
      }
      asy localasy = new asy();
      try
      {
        localasy.parseFrom(paramMultiTaskInfo.field_data);
        String str1 = localasy.filePath;
        if (!y.ZC(str1))
        {
          Log.i("MicroMsg.FileMultiTaskUIC", "handleBallInfoClicked() %s not exist", new Object[] { str1 });
          paramView = new g.a((Context)paramObject);
          paramView.bf((CharSequence)"");
          paramView = paramView.bDE(paramObject.getString(R.l.gHS)).NF(true);
          paramView.Xdm = true;
          paramView.b((g.c)new b()).show();
          ((d)h.az(d.class)).removeTaskInfoAndCoverImg(paramMultiTaskInfo.field_id);
          AppMethodBeat.o(254091);
          return;
        }
      }
      finally
      {
        for (;;)
        {
          Log.e("MicroMsg.FileMultiTaskUIC", "handleMultiTaskInfoClicked", new Object[] { str2 });
        }
        paramMultiTaskInfo = new aet();
        paramMultiTaskInfo.ZmM = paramdrt;
        if (paramView != null)
        {
          paramdrt = com.tencent.mm.plugin.secdata.ui.a.PlI;
          paramView = paramView.getContext();
          s.s(paramView, "it.context");
          paramView = com.tencent.mm.plugin.secdata.ui.a.a.jC(paramView);
          if (paramView != null) {
            break label425;
          }
          paramView = null;
        }
        for (;;)
        {
          paramMultiTaskInfo.zIO = paramView;
          if (!localasy.ZDd) {
            break;
          }
          paramView = new Intent();
          paramView.setClassName((Context)paramObject, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
          com.tencent.mm.plugin.multitask.f.b.a(paramView, localasy);
          paramView.putExtra("key_multi_task_common_info", paramMultiTaskInfo.toByteArray());
          paramMultiTaskInfo = paramView.getExtras();
          if (paramMultiTaskInfo != null) {
            paramMultiTaskInfo.putInt("scene", 9);
          }
          paramView.addFlags(268435456);
          paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(paramObject, paramView.aYi(), "com/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC", "onMultiTaskItemClick", "(Landroid/view/View;Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramObject.startActivity((Intent)paramView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramObject, "com/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC", "onMultiTaskItemClick", "(Landroid/view/View;Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(254091);
          return;
          label425:
          paramView = (dry)paramView.aiK(5);
          if (paramView == null) {
            paramView = null;
          } else {
            paramView = paramView.zIO;
          }
        }
        paramView = localasy.lPJ;
        paramdrt = localasy.appId;
        String str3 = localasy.processName;
        boolean bool = localasy.rvh;
        if (Util.isNullOrNil(str3))
        {
          if (com.tencent.mm.pluginsdk.ui.tools.a.a(str2, paramView, "", 9, paramMultiTaskInfo))
          {
            com.tencent.mm.pluginsdk.ui.tools.a.a((Activity)getActivity(), str2, paramView, "", 9, paramMultiTaskInfo);
            AppMethodBeat.o(254091);
          }
        }
        else {
          ((com.tencent.mm.plugin.appbrand.service.g)h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).a((Context)paramObject, str2, paramView, paramdrt, bool, str3);
        }
      }
    }
    AppMethodBeat.o(254091);
  }
  
  public final void eDd() {}
  
  public final com.tencent.mm.plugin.multitask.ui.a.b eDe()
  {
    return com.tencent.mm.plugin.multitask.ui.a.b.LDq;
  }
  
  public final void fw(Object paramObject) {}
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(254074);
    int i = super.getLayoutId();
    AppMethodBeat.o(254074);
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
    AppMethodBeat.i(254062);
    s.u(paramConfiguration, "newConfig");
    AppMethodBeat.o(254062);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(254025);
    getRootView().findViewById(getLayoutId());
    AppMethodBeat.o(254025);
  }
  
  public final void onCreateAfter(Bundle paramBundle) {}
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(254070);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(254070);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(254072);
    s.u(paramKeyEvent, "event");
    AppMethodBeat.o(254072);
    return false;
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(254057);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(254057);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle) {}
  
  public final void onResume() {}
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onStart() {}
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop() {}
  
  public final void onUserVisibleFocused() {}
  
  public final void onUserVisibleUnFocused() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC$Companion;", "", "()V", "TAG", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC$onMultiTaskItemClick$1$1", "Lcom/tencent/mm/ui/widget/dialog/MMConfirmDialog$IOnDialogClick;", "onDialogClick", "", "bOk", "", "text", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g.c
  {
    public final void onDialogClick(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(254004);
      if (paramBoolean)
      {
        paramString = (d)h.az(d.class);
        com.tencent.mm.plugin.multitask.g localg = com.tencent.mm.plugin.multitask.g.LBa;
        paramString.sendMultiTaskEvent(0, com.tencent.mm.plugin.multitask.g.gjs(), 1048576);
      }
      AppMethodBeat.o(254004);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.multitask.a.a
 * JD-Core Version:    0.7.0.1
 */