package com.tencent.mm.ui.chatting.multitask.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.multitask.d;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "getLayoutId", "", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onCreateBefore", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStartActivityForResult", "intent", "options", "onStop", "onUserVisibleFocused", "onUserVisibleUnFocused", "supportMultiTaskType", "multiTaskType", "Companion", "app_release"})
public final class FileMultiTaskUIC
  extends MultiTaskUIComponent
{
  public static final FileMultiTaskUIC.a PEa;
  
  static
  {
    AppMethodBeat.i(231346);
    PEa = new FileMultiTaskUIC.a((byte)0);
    AppMethodBeat.o(231346);
  }
  
  public FileMultiTaskUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(231345);
    AppMethodBeat.o(231345);
  }
  
  public FileMultiTaskUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(231344);
    AppMethodBeat.o(231344);
  }
  
  public final boolean Js(int paramInt)
  {
    return paramInt == 4;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, crq paramcrq, Object paramObject)
  {
    AppMethodBeat.i(231343);
    p.h(paramMultiTaskInfo, "info");
    p.h(paramcrq, "animateData");
    if (paramMultiTaskInfo.field_data != null)
    {
      Log.i("MicroMsg.FileMultiTaskUIC", "handleBallInfoClicked, openFile t:%s", new Object[] { paramMultiTaskInfo });
      paramObject = getActivity();
      if (!com.tencent.mm.ui.chatting.multitask.b.gSk())
      {
        u.g((Context)paramObject, null);
        AppMethodBeat.o(231343);
        return;
      }
      aoe localaoe = new aoe();
      try
      {
        localaoe.parseFrom(paramMultiTaskInfo.field_data);
        String str1 = localaoe.filePath;
        if (!s.YS(str1))
        {
          Log.i("MicroMsg.FileMultiTaskUIC", "handleBallInfoClicked() %s not exist", new Object[] { str1 });
          paramView = new f.a((Context)paramObject);
          paramView.aC((CharSequence)"");
          paramView.bow(paramObject.getString(2131759413)).Dq(true).hbu().b((f.c)new b()).show();
          ((d)com.tencent.mm.kernel.g.ah(d.class)).removeTaskInfoAndCoverImg(paramMultiTaskInfo.field_id);
          AppMethodBeat.o(231343);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.e("MicroMsg.FileMultiTaskUIC", "handleMultiTaskInfoClicked", new Object[] { localThrowable });
        }
        paramMultiTaskInfo = new ach();
        paramMultiTaskInfo.LmQ = paramcrq;
        if (paramView != null)
        {
          paramcrq = SecDataUIC.CWq;
          paramView = paramView.getContext();
          p.g(paramView, "it.context");
          paramView = SecDataUIC.a.gU(paramView);
          if (paramView == null) {
            break label436;
          }
          paramView = (crt)paramView.Xh(5);
          if (paramView == null) {
            break label436;
          }
        }
        label436:
        for (paramView = paramView.sGQ;; paramView = null)
        {
          paramMultiTaskInfo.sGQ = paramView;
          if (!localaoe.LzL) {
            break;
          }
          paramView = new Intent();
          paramView.setClassName((Context)paramObject, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
          com.tencent.mm.plugin.multitask.f.b.a(paramView, localaoe);
          paramView.putExtra("key_multi_task_common_info", paramMultiTaskInfo.toByteArray());
          paramMultiTaskInfo = paramView.getExtras();
          if (paramMultiTaskInfo != null) {
            paramMultiTaskInfo.putInt("scene", 9);
          }
          paramView.addFlags(268435456);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(paramObject, paramView.axQ(), "com/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC", "onMultiTaskItemClick", "(Landroid/view/View;Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramObject.startActivity((Intent)paramView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramObject, "com/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC", "onMultiTaskItemClick", "(Landroid/view/View;Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(231343);
          return;
        }
        paramView = localaoe.gCr;
        paramcrq = localaoe.appId;
        String str2 = localaoe.processName;
        boolean bool = localaoe.lwF;
        if (Util.isNullOrNil(str2))
        {
          if (com.tencent.mm.pluginsdk.ui.tools.a.a(localThrowable, paramView, "", 9, paramMultiTaskInfo))
          {
            com.tencent.mm.pluginsdk.ui.tools.a.a((Activity)getActivity(), localThrowable, paramView, "", 9, paramMultiTaskInfo);
            AppMethodBeat.o(231343);
          }
        }
        else {
          ((f)com.tencent.mm.kernel.g.af(f.class)).a((Context)paramObject, localThrowable, paramView, paramcrq, bool, str2);
        }
      }
    }
    AppMethodBeat.o(231343);
  }
  
  public final void dk(Object paramObject) {}
  
  public final void dkr() {}
  
  public final a.b dks()
  {
    return a.b.Ach;
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(231342);
    int i = super.getLayoutId();
    AppMethodBeat.o(231342);
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
    AppMethodBeat.i(231339);
    p.h(paramConfiguration, "newConfig");
    AppMethodBeat.o(231339);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(231337);
    getRootView().findViewById(getLayoutId());
    AppMethodBeat.o(231337);
  }
  
  public final void onCreateAfter(Bundle paramBundle) {}
  
  public final void onCreateBefore(Bundle paramBundle) {}
  
  public final void onDestroy() {}
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(231340);
    p.h(paramKeyEvent, "event");
    AppMethodBeat.o(231340);
    return false;
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(231341);
    p.h(paramKeyEvent, "event");
    AppMethodBeat.o(231341);
    return false;
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(231338);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    AppMethodBeat.o(231338);
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle) {}
  
  public final void onResume() {}
  
  public final void onSaveInstanceState(Bundle paramBundle) {}
  
  public final void onStart() {}
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public final void onStop() {}
  
  public final void onUserVisibleFocused() {}
  
  public final void onUserVisibleUnFocused() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/ui/chatting/multitask/uic/FileMultiTaskUIC$onMultiTaskItemClick$1$1", "Lcom/tencent/mm/ui/widget/dialog/MMConfirmDialog$IOnDialogClick;", "onDialogClick", "", "bOk", "", "text", "", "app_release"})
  public static final class b
    implements f.c
  {
    public final void e(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(231336);
      if (paramBoolean)
      {
        paramString = (d)com.tencent.mm.kernel.g.ah(d.class);
        com.tencent.mm.plugin.multitask.g localg = com.tencent.mm.plugin.multitask.g.zZj;
        paramString.sendMultiTaskEvent(0, com.tencent.mm.plugin.multitask.g.eqx(), 1048576);
      }
      AppMethodBeat.o(231336);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.multitask.uic.FileMultiTaskUIC
 * JD-Core Version:    0.7.0.1
 */