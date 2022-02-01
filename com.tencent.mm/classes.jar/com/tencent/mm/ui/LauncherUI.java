package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.arch.lifecycle.ViewModelProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.blink.FirstScreenFrameLayout;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bk.b;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.g.b.a.ks;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.ui.WelcomeActivity;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.tools.x;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.xlog.app.XLogSetup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public class LauncherUI
  extends MMSecDataFragmentActivity
{
  private static ArrayList<LauncherUI> ODL;
  private static ArrayList<WeakReference<LauncherUI>> ODM;
  private static boolean ODN;
  public static long ODO;
  private static boolean ODP;
  private static boolean ODY;
  private IListener<qm> ODQ;
  public HomeUI ODR;
  private o ODS;
  public boolean ODT;
  boolean ODU;
  private boolean ODV;
  private com.tencent.mm.plugin.wallet_index.c.b ODW;
  private com.tencent.mm.pluginsdk.t ODX;
  private boolean ODZ;
  private MMHandler OEa;
  private Runnable OEb;
  private boolean OEc;
  int OEd;
  private NewChattingTabUI chattingTabUI;
  private Intent dRc;
  
  static
  {
    AppMethodBeat.i(33334);
    ODL = new ArrayList();
    ODM = new ArrayList();
    ODN = true;
    ODP = false;
    com.tencent.mm.kernel.g.b(com.tencent.mm.ui.j.a.class, new com.tencent.mm.ui.j.a()
    {
      public final Activity gIw()
      {
        AppMethodBeat.i(232594);
        LauncherUI localLauncherUI = LauncherUI.getInstance();
        AppMethodBeat.o(232594);
        return localLauncherUI;
      }
    });
    ODY = false;
    AppMethodBeat.o(33334);
  }
  
  public LauncherUI()
  {
    AppMethodBeat.i(33295);
    this.ODQ = new IListener() {};
    this.ODR = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.ODR);
    this.ODS = new o();
    this.dRc = null;
    this.ODT = false;
    this.ODU = false;
    this.ODV = false;
    this.ODX = new com.tencent.mm.pluginsdk.t("MicroMsg.LauncherUI");
    this.ODZ = false;
    this.OEa = new MMHandler();
    this.OEb = new LauncherUI.5(this);
    this.OEc = false;
    this.OEd = 0;
    AppMethodBeat.o(33295);
  }
  
  private void Bg(boolean paramBoolean)
  {
    AppMethodBeat.i(33302);
    if (paramBoolean)
    {
      new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(232596);
          LauncherUI.a(LauncherUI.this);
          AppMethodBeat.o(232596);
        }
      };
      o.gIz();
    }
    for (paramBoolean = false;; paramBoolean = true)
    {
      this.ODZ = paramBoolean;
      do
      {
        AppMethodBeat.o(33302);
        return;
      } while (this.ODZ);
      if (this.ODS.bc(this)) {
        break;
      }
    }
  }
  
  private void bA(Intent paramIntent)
  {
    AppMethodBeat.i(33315);
    int i = IntentUtil.getIntExtra(paramIntent, "update_type", -1);
    if (i == -1)
    {
      Log.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
      AppMethodBeat.o(33315);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(405L, 28L, 1L, true);
    com.tencent.mm.plugin.report.service.h localh;
    if (com.tencent.mm.plugin.p.d.elq() != null)
    {
      paramIntent = com.tencent.mm.plugin.p.d.elq().c(this, null);
      if (paramIntent == null)
      {
        AppMethodBeat.o(33315);
        return;
      }
      localh = com.tencent.mm.plugin.report.service.h.CyF;
      if (i != 2) {
        break label110;
      }
    }
    label110:
    for (long l = 29L;; l = 30L)
    {
      localh.idkeyStat(405L, l, 1L, true);
      paramIntent.update(i);
      AppMethodBeat.o(33315);
      return;
    }
  }
  
  private void bz(Intent paramIntent)
  {
    AppMethodBeat.i(33307);
    Log.i("MicroMsg.LauncherUI", "handleJump");
    if (!bg.aAc())
    {
      Log.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
      paramIntent = new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(33307);
      return;
    }
    Object localObject1 = new lr();
    ((lr)localObject1).dRb.dRc = this.dRc;
    EventCenter.instance.publish((IEvent)localObject1);
    if ("talkroom_notification".equals(IntentUtil.getStringExtra(paramIntent, "nofification_type")))
    {
      paramIntent = IntentUtil.getStringExtra(paramIntent, "enter_chat_usrname");
      if (!Util.isNullOrNil(paramIntent))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enter_room_username", paramIntent);
        ((Intent)localObject1).setFlags(268435456);
        com.tencent.mm.br.c.b(this, "talkroom", ".ui.TalkRoomUI", (Intent)localObject1);
      }
      AppMethodBeat.o(33307);
      return;
    }
    if ("back_to_pcmgr_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      if (!paramIntent.getBooleanExtra("newPCBackup", true)) {
        Log.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BakToPcUI");
      }
      for (paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");; paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI"))
      {
        paramIntent.setFlags(268435456);
        MMWizardActivity.ay(this, paramIntent);
        AppMethodBeat.o(33307);
        return;
        Log.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
      }
    }
    if ("back_to_pcmgr_error_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.ay(this, paramIntent);
      AppMethodBeat.o(33307);
      return;
    }
    if ("clear_msg_not_finish_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      com.tencent.mm.ui.base.h.n(this, 2131757633, 2131755998);
      AppMethodBeat.o(33307);
      return;
    }
    if ("backup_move_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.ay(this, paramIntent);
      AppMethodBeat.o(33307);
      return;
    }
    if (IntentUtil.getBooleanExtra(paramIntent, "show_update_dialog", false)) {
      bA(paramIntent);
    }
    String str = IntentUtil.getStringExtra(paramIntent, "Main_User");
    localObject1 = IntentUtil.getStringExtra(paramIntent, "nofification_type");
    Log.i("MicroMsg.LauncherUI", "[handleJump] user:%s", new Object[] { str });
    Object localObject2;
    int i;
    if ((str != null) && (!str.equals("")))
    {
      bg.aVF();
      localObject2 = com.tencent.mm.model.c.aST().bjY(str);
      if (localObject2 != null)
      {
        i = ((bb)localObject2).field_unReadCount;
        Log.i("MicroMsg.LauncherUI", "[oneliang] user:%s, conversation :%s, unReadCount:%s", new Object[] { str, localObject2, Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0) {
        j = IntentUtil.getIntExtra(paramIntent, "pushcontent_unread_count", 0);
      }
      MMAppMgr.Xc();
      EventCenter.instance.publish(new ah());
      boolean bool = IntentUtil.getBooleanExtra(paramIntent, "Intro_Is_Muti_Talker", true);
      Log.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((!bool) && (j > 0))
      {
        i = IntentUtil.getIntExtra(paramIntent, "Intro_Bottle_unread_count", 0);
        if (i > 0)
        {
          Log.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.br.c.V(this, "bottle", ".ui.BottleConversationUI");
        }
      }
      if (!bool)
      {
        if (com.tencent.mm.model.ab.Jj(str))
        {
          Log.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("type", 20);
          com.tencent.mm.br.c.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
        }
        for (;;)
        {
          if (IntentUtil.getIntExtra(paramIntent, "kstyle_show_bind_mobile_afterauth", 0) > 0)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMobileUI");
            ((Intent)localObject1).putExtra("kstyle_bind_recommend_show", paramIntent.getIntExtra("kstyle_bind_recommend_show", 0));
            ((Intent)localObject1).putExtra("kstyle_bind_wording", paramIntent.getParcelableExtra("kstyle_bind_wording"));
            MMWizardActivity.ay(this, (Intent)localObject1);
          }
          AppMethodBeat.o(33307);
          return;
          if (!com.tencent.mm.model.ab.Jr(str)) {
            break;
          }
          Log.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("type", 11);
          com.tencent.mm.br.c.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
        }
        if (paramIntent.getIntExtra("MainUI_User_Last_Msg_Type", 34) != 34) {
          break label1587;
        }
      }
      label1576:
      label1587:
      for (i = 2;; i = 1)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("Chat_Mode", i);
        if ("new_msg_nofification".equals(IntentUtil.getStringExtra(paramIntent, "nofification_type")))
        {
          ((Bundle)localObject1).putInt("chat_from_scene", 1);
          ((Bundle)localObject1).putBoolean("key_can_show_message_float_ball", true);
        }
        localObject2 = getInstance();
        if (localObject2 == null) {
          break;
        }
        if (com.tencent.mm.al.g.DQ(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("biz_chat_from_scene", 4);
          com.tencent.mm.br.c.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if (com.tencent.mm.al.g.Nh(str))
        {
          localObject1 = com.tencent.mm.al.g.fJ(str);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).UJ())
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = "";
            }
            paramIntent.putExtra("rawUrl", (String)localObject2);
            paramIntent.putExtra("useJs", true);
            paramIntent.putExtra("srcUsername", str);
            paramIntent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            paramIntent.addFlags(67108864);
            com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", paramIntent);
            break;
          }
        }
        if (as.HF(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("app_brand_conversation_from_scene", 3);
          paramIntent.putExtra("finish_direct", true);
          paramIntent.putExtra("key_need_send_video", false);
          com.tencent.mm.br.c.f(this, ".ui.conversation.AppBrandServiceConversationUI", paramIntent);
          break;
        }
        ((LauncherUI)localObject2).startChatting(str, (Bundle)localObject1, false);
        break;
        if (IntentUtil.getBooleanExtra(paramIntent, "From_fail_notify", false))
        {
          if (!Util.isNullOrNil(str))
          {
            localObject1 = getInstance();
            if (localObject1 == null) {
              break;
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putBoolean("Chat_Mode", IntentUtil.getBooleanExtra(paramIntent, "resend_fail_messages", false));
            if (com.tencent.mm.al.g.DQ(str))
            {
              paramIntent.putExtra("Contact_User", str);
              paramIntent.addFlags(67108864);
              paramIntent.putExtra("biz_chat_from_scene", 4);
              com.tencent.mm.br.c.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
              break;
            }
            ((LauncherUI)localObject1).startChatting(str, (Bundle)localObject2, false);
            break;
          }
          if (!IntentUtil.getBooleanExtra(paramIntent, "jump_sns_from_notify", false)) {
            break;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("is_need_resend_sns", paramIntent.getBooleanExtra("is_need_resend_sns", false));
          ((Intent)localObject1).putExtra("sns_resume_state", paramIntent.getBooleanExtra("sns_resume_state", false));
          ((Intent)localObject1).putExtra("sns_timeline_NeedFirstLoadint", paramIntent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
          com.tencent.mm.br.c.b(this, "sns", ".ui.SnsTimeLineUI", (Intent)localObject1);
          break;
        }
        if (IntentUtil.getBooleanExtra(paramIntent, "biz_chat_need_to_jump_to_chatting_ui", false))
        {
          if ((getInstance() == null) || (!com.tencent.mm.al.g.DQ(str))) {
            break;
          }
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          com.tencent.mm.br.c.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if ((Util.isNullOrNil(str)) || (!"new_msg_nofification".equals(localObject1))) {
          break;
        }
        if (paramIntent == null) {}
        for (localObject1 = "null";; localObject1 = paramIntent)
        {
          Log.w("MicroMsg.LauncherUI", "[handleJump] intent:%s", new Object[] { localObject1 });
          localObject1 = getInstance();
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("chat_from_scene", 1);
          ((Bundle)localObject2).putBoolean("key_can_show_message_float_ball", true);
          if (localObject1 == null) {
            break label1576;
          }
          ((LauncherUI)localObject1).startChatting(str, (Bundle)localObject2, false);
          break;
        }
        Log.w("MicroMsg.LauncherUI", "LauncherUI.getInstance is null! ");
        break;
      }
      i = 0;
      break;
      i = 0;
    }
  }
  
  private void gIp()
  {
    AppMethodBeat.i(33298);
    int i = ODL.indexOf(this);
    if (i >= 0) {
      ODL.remove(i);
    }
    Log.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(ODL.size()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(33298);
  }
  
  private void gIq()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33300);
    Log.d("MicroMsg.LauncherUI", "[whatsnew] checkIfStartWhatsNew.");
    if (ODY)
    {
      Log.i("MicroMsg.LauncherUI", "[whatsnew] has been played.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      com.tencent.mm.kernel.g.aAf();
      if (!com.tencent.mm.kernel.a.azo())
      {
        Log.i("MicroMsg.LauncherUI", "[whatsnew] not login yet, skip.");
        AppMethodBeat.o(33300);
        return;
      }
      Log.i("MicroMsg.LauncherUI", "[whatsnew] account not initiate, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!gIr())
    {
      Log.i("MicroMsg.LauncherUI", "[whatsnew] notSwitchOrHold is false, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    boolean bool3 = IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.enter_from_reg", false);
    boolean bool4 = a.a.gKe().gKc();
    boolean bool5;
    boolean bool1;
    if ((!bool3) && (com.tencent.mm.pluginsdk.i.c.JYn != null) && (com.tencent.mm.pluginsdk.i.c.JYn.Xl()) && (bg.aAc()) && (!bool4))
    {
      if (MMEntryLock.lock("show_whatsnew"))
      {
        ODY = true;
        Log.i("MicroMsg.LauncherUI", "[whatsnew] show whatsnew.");
        MMAppMgr.bh(this);
        com.tencent.mm.blink.a.ajZ();
        AppMethodBeat.o(33300);
      }
    }
    else
    {
      com.tencent.mm.pluginsdk.i.c.a locala = com.tencent.mm.pluginsdk.i.c.JYn;
      bool5 = bg.aAc();
      if (locala != null) {
        break label283;
      }
      bool1 = true;
      if ((locala == null) || (!locala.Xl())) {
        break label288;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.LauncherUI", "[whatsnew] do not show whatsnew. enter_from_reg=%s accHasReady=%s MMAppMgr is null %s isWhatsNewAvailable=%s, isAccessibilityEnabled=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
      AppMethodBeat.o(33300);
      return;
      label283:
      bool1 = false;
      break;
      label288:
      bool2 = false;
    }
  }
  
  private boolean gIr()
  {
    AppMethodBeat.i(33304);
    if ((this.dRc != null) && (!IntentUtil.getBooleanExtra(this.dRc, "Intro_Switch", false)) && (bg.aVG()) && (!bg.azj()))
    {
      AppMethodBeat.o(33304);
      return true;
    }
    AppMethodBeat.o(33304);
    return false;
  }
  
  private boolean gIs()
  {
    AppMethodBeat.i(33305);
    if (this.dRc != null)
    {
      Object localObject1;
      Object localObject2;
      if ((IntentUtil.getBooleanExtra(this.dRc, "absolutely_exit", false)) || (IntentUtil.getIntExtra(this.dRc, "absolutely_exit_pid", 0) == Process.myPid()))
      {
        Log.w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        finish();
        com.tencent.mm.plugin.report.service.g.Wn(8);
        MMAppMgr.Bj(IntentUtil.getBooleanExtra(this.dRc, "kill_service", true));
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "java/lang/System_EXEC_", "exit", "(I)V");
        AppMethodBeat.o(33305);
        return true;
      }
      if (IntentUtil.getBooleanExtra(this.dRc, "can_finish", false))
      {
        Log.i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
        bg.azz().fx(true);
        if (com.tencent.mm.kernel.l.cK(getApplicationContext())) {
          com.tencent.mm.booter.b.ce(getApplicationContext());
        }
        com.tencent.mm.plugin.report.service.g.Wn(8);
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), WeChatPermissions.PERMISSION_MM_MESSAGE());
        finish();
        com.tencent.mm.ui.base.b.kd(this);
        AppMethodBeat.o(33305);
        return true;
      }
      if (IntentUtil.getBooleanExtra(this.dRc, "exit_and_restart", false))
      {
        Mars.onSingalCrash(0);
        Log.i("MicroMsg.LauncherUI", "exit and restart myself.");
        Log.appenderFlush();
        finish();
        localObject1 = new Intent(this, LauncherUI.class);
        ((Intent)localObject1).addFlags(67108864);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        Log.i("MicroMsg.LauncherUI", "restart, try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        MMAppMgr.gIU();
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(33305);
        return true;
      }
    }
    AppMethodBeat.o(33305);
    return false;
  }
  
  private void gIt()
  {
    AppMethodBeat.i(33306);
    Log.i("MicroMsg.LauncherUI", "switch to wxid %s", new Object[] { MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "") });
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).addFlags(536870912);
    ((Intent)localObject).putExtra("key_scene", 1);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.ke(this);
    AppMethodBeat.o(33306);
  }
  
  private void gIu()
  {
    AppMethodBeat.i(33308);
    Log.i("MicroMsg.LauncherUI", "resumeLogoutJump");
    if ((this.dRc != null) && (IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.jump_from_uimode_check", false)))
    {
      Log.i("MicroMsg.LauncherUI", "dancy uimode check from background, not jumpToLogin or welcome!");
      AppMethodBeat.o(33308);
      return;
    }
    Object localObject = IntentUtil.getStringExtra(getIntent(), "LauncherUI.Shortcut.LaunchType");
    com.tencent.mm.util.b localb;
    if (localObject != null)
    {
      if (!((String)localObject).equals("launch_type_scan_qrcode")) {
        break label284;
      }
      localObject = new ks();
      ((ks)localObject).elF = 2L;
      ((ks)localObject).eXj = 2L;
      ((ks)localObject).bfK();
      localb = com.tencent.mm.util.b.QYu;
      com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject);
    }
    for (;;)
    {
      MMFragmentActivity.a.gIV();
      MMFragmentActivity.a.gIV();
      aw.kA(MMApplicationContext.getContext());
      aw.aoh(2);
      localObject = bf.iDu.aA("login_user_name", "");
      if ((bg.aVG()) || (!((String)localObject).equals(""))) {
        break;
      }
      localObject = new Intent(this, WelcomeActivity.class);
      ((Intent)localObject).addFlags(536870912);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.ke(this);
      Log.i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
      MMHandlerThread.removeRunnable(this.OEb);
      MMHandlerThread.postToMainThreadDelayed(this.OEb, 2000L);
      AppMethodBeat.o(33308);
      return;
      label284:
      if (((String)localObject).equals("launch_type_offline_wallet"))
      {
        localObject = new ks();
        ((ks)localObject).elF = 1L;
        ((ks)localObject).eXj = 2L;
        ((ks)localObject).bfK();
        localb = com.tencent.mm.util.b.QYu;
        com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject);
      }
      else if (((String)localObject).equals("launch_type_my_qrcode"))
      {
        localObject = new ks();
        ((ks)localObject).elF = 3L;
        ((ks)localObject).eXj = 2L;
        ((ks)localObject).bfK();
        localb = com.tencent.mm.util.b.QYu;
        com.tencent.mm.util.b.a((com.tencent.mm.plugin.report.a)localObject);
      }
    }
    if ((this.dRc.getFlags() & 0x4000000) == 67108864) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = IntentUtil.getBooleanExtra(this.dRc, "Intro_Notify", false);
      Log.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", new Object[] { Boolean.valueOf(this.ODT), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bg.azj()) });
      Log.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", new Object[] { Boolean.valueOf(bg.aVG()) });
      bg.hold();
      if (IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
        this.ODV = true;
      }
      jH(this);
      bg.unhold();
      AppMethodBeat.o(33308);
      return;
    }
  }
  
  public static boolean gIv()
  {
    AppMethodBeat.i(232598);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sir, 1);
    Log.d("MicroMsg.LauncherUI", "isHWMagicLauncherUIOnresumeSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(232598);
      return true;
    }
    AppMethodBeat.o(232598);
    return false;
  }
  
  public static int getCurrentTabIndex()
  {
    AppMethodBeat.i(33297);
    if ((getInstance() != null) && (getInstance().getHomeUI() != null) && (getInstance().getHomeUI().getMainTabUI() != null))
    {
      int i = getInstance().getHomeUI().getMainTabUI().acm;
      AppMethodBeat.o(33297);
      return i;
    }
    AppMethodBeat.o(33297);
    return -1;
  }
  
  public static LauncherUI getInstance()
  {
    AppMethodBeat.i(33296);
    if (ODL.isEmpty())
    {
      Log.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", new Object[] { Util.getStack() });
      AppMethodBeat.o(33296);
      return null;
    }
    LauncherUI localLauncherUI = (LauncherUI)ODL.get(0);
    AppMethodBeat.o(33296);
    return localLauncherUI;
  }
  
  private void jH(Context paramContext)
  {
    AppMethodBeat.i(33309);
    if (IntentUtil.getBooleanExtra(this.dRc, "LauncherUI.jump_switch_account", false))
    {
      Log.i("MicroMsg.LauncherUI", "launcher to switch account");
      gIt();
      AppMethodBeat.o(33309);
      return;
    }
    if ((IntentUtil.getBooleanExtra(this.dRc, "Intro_Switch", false)) || (this.ODT) || (com.tencent.mm.kernel.a.ayY()))
    {
      this.ODR.getMainTabUI().cpB();
      com.tencent.mm.kernel.g.aAi().FS("[normal logout]");
      Mars.onSingalCrash(0);
      Log.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
      Log.appenderFlush();
      finish();
      Object localObject = new Intent(paramContext, LauncherUI.class);
      ((Intent)localObject).putExtra("key_errType", IntentUtil.getIntExtra(this.dRc, "key_errType", 0));
      ((Intent)localObject).putExtra("key_errCode", IntentUtil.getIntExtra(this.dRc, "key_errCode", 0));
      ((Intent)localObject).putExtra("key_errMsg", IntentUtil.getStringExtra(this.dRc, "key_errMsg"));
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      Log.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
      MMAppMgr.gIU();
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramContext.axQ(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(33309);
      return;
    }
    if (!IntentUtil.getBooleanExtra(this.dRc, "LauncherUI.jump_switch_account", false))
    {
      paramContext = bf.iDu.aA("login_user_name", "");
      Log.i("MicroMsg.LauncherUI", "%s jumpToLogin", new Object[] { paramContext });
      if (!Util.isNullOrNil(paramContext)) {
        break label544;
      }
      paramContext = new Intent(this, WelcomeActivity.class);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bl(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.axQ(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.ke(this);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.Wn(8);
      MMHandlerThread.removeRunnable(this.OEb);
      MMHandlerThread.postToMainThreadDelayed(this.OEb, 2000L);
      AppMethodBeat.o(33309);
      return;
      label544:
      boolean bool = MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false);
      Log.i("MicroMsg.LauncherUI", "switchAccount %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      paramContext = new Intent(this, SettingsSwitchAccountUI.class);
      paramContext.addFlags(536870912);
      paramContext.putExtra("key_scene", 2);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bl(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.axQ(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kb(this);
    }
    int i = Util.safeParseInt(bf.iDu.aA("last_login_use_voice", ""));
    Log.i("MicroMsg.LauncherUI", "pluginSwitch  ".concat(String.valueOf(i)));
    paramContext = new Intent();
    paramContext.putExtra("key_errType", IntentUtil.getIntExtra(this.dRc, "key_errType", 0));
    paramContext.putExtra("key_errCode", IntentUtil.getIntExtra(this.dRc, "key_errCode", 0));
    paramContext.putExtra("key_errMsg", IntentUtil.getStringExtra(this.dRc, "key_errMsg"));
    if ((!WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned()) && ((i & 0x20000) != 0)) {
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginVoiceUI");
    }
    for (;;)
    {
      paramContext.addFlags(536870912);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bl(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.axQ(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kb(this);
      break;
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginPasswordUI");
    }
  }
  
  public static void jI(Context paramContext)
  {
    AppMethodBeat.i(33328);
    Object localObject = new Intent(paramContext, LauncherUI.class);
    ((Intent)localObject).addFlags(67108864);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33328);
  }
  
  public final void closeChatting(boolean paramBoolean)
  {
    AppMethodBeat.i(33330);
    new LauncherUI.6(this);
    if (this.chattingTabUI.Bq(paramBoolean))
    {
      this.ODR.Bd(this.chattingTabUI.OJN.isSupportCustomActionBar());
      this.ODR.getMainTabUI().gJf();
    }
    AppMethodBeat.o(33330);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33319);
    Object localObject;
    boolean bool;
    if (this.chattingTabUI.gIx())
    {
      localObject = this.chattingTabUI;
      if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
        MMHandlerThread.removeRunnable(((NewChattingTabUI)localObject).mStartChattingRunnable);
      }
      if (((NewChattingTabUI)localObject).isAnimating) {}
      for (bool = true; bool; bool = ((NewChattingTabUI)localObject).OJN.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent))
      {
        AppMethodBeat.o(33319);
        return true;
      }
    }
    if ((paramKeyEvent.getKeyCode() == 4) && (ao.isMultiTaskMode()))
    {
      localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = (MultiTaskUIC)com.tencent.mm.ui.component.a.b(this).get(MultiTaskUIC.class);
      kotlin.g.b.p.h(paramKeyEvent, "event");
      if (paramKeyEvent.getKeyCode() == 4)
      {
        if (((MultiTaskUIC)localObject).AfE != null) {
          com.tencent.mm.plugin.multitask.ui.panel.b.e(paramKeyEvent);
        }
        if (((MultiTaskUIC)localObject).erO()) {
          ((MultiTaskUIC)localObject).m(true, true, false);
        }
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(33319);
        return true;
      }
    }
    if (this.ODR.dispatchKeyEvent(paramKeyEvent))
    {
      AppMethodBeat.o(33319);
      return true;
    }
    try
    {
      bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(33319);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      Log.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", new Object[] { paramKeyEvent.getMessage() });
      Log.printErrStackTrace("MicroMsg.LauncherUI", paramKeyEvent, "", new Object[0]);
      AppMethodBeat.o(33319);
    }
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(33316);
    super.finish();
    gIp();
    Log.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(ODL.size()), Util.getStack() });
    AppMethodBeat.o(33316);
  }
  
  public boolean forceRemoveNoMatchOnPath()
  {
    return true;
  }
  
  public MMFragment getCurrentFragmet()
  {
    AppMethodBeat.i(33327);
    Object localObject1 = this.chattingTabUI;
    if (!((NewChattingTabUI)localObject1).mChattingClosed) {}
    for (localObject1 = ((NewChattingTabUI)localObject1).OJN;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getCurrentFragmet();
      }
      AppMethodBeat.o(33327);
      return localObject2;
    }
  }
  
  public HomeUI getHomeUI()
  {
    return this.ODR;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(232599);
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(super.importUIComponents());
    localHashSet.add(MultiTaskUIC.class);
    AppMethodBeat.o(232599);
    return localHashSet;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str1 = null;
    Object localObject1 = null;
    AppMethodBeat.i(33310);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.v("MicroMsg.LauncherUI", "edw on activity result");
    Object localObject2 = this.chattingTabUI;
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 226) || (paramInt1 == 3001) || (paramInt1 == 30762) || (paramInt1 == 1111)) && (((NewChattingTabUI)localObject2).OJN != null)) {
      ((NewChattingTabUI)localObject2).OJN.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((NewChattingTabUI.acceptRequestCode(paramInt1)) && (((NewChattingTabUI)localObject2).OJN == null))
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
      MMHandlerThread.removeRunnable(((NewChattingTabUI)localObject2).OJP);
      ((NewChattingTabUI)localObject2).OJP.OJY = 0;
      ((NewChattingTabUI)localObject2).OJP.requestCode = paramInt1;
      ((NewChattingTabUI)localObject2).OJP.resultCode = paramInt2;
      ((NewChattingTabUI)localObject2).OJP.dQs = paramIntent;
      MMHandlerThread.postToMainThread(((NewChattingTabUI)localObject2).OJP);
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(33310);
      return;
    }
    localObject2 = this.ODR;
    if (((HomeUI)localObject2).OCv)
    {
      if (paramInt1 == 1)
      {
        bg.aVF();
        if (!Util.nullAsFalse((Boolean)com.tencent.mm.model.c.azQ().get(12323, null))) {
          y.showAddrBookUploadConfirm(((HomeUI)localObject2).uLr, null, false, 3);
        }
        AppMethodBeat.o(33310);
        return;
      }
      if (paramInt1 == 22722)
      {
        str1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null);
        Log.i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
        if (paramIntent != null) {
          localObject1 = paramIntent.getBundleExtra("result_data");
        }
        if ((localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("agree_privacy")))
        {
          Log.i("MicroMsg.LauncherUI.HomeUI", "agree privacy policy");
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(712L, 4L, 1L, false);
          localObject1 = new com.tencent.mm.plugin.account.model.h(1, str1);
          com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject1, 0);
          if ((com.tencent.mm.aw.b.Pi(str1)) && (com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Ogv, false)))
          {
            Log.i("MicroMsg.LauncherUI.HomeUI", "needbirthday true");
            MMHandlerThread.postToMainThreadDelayed(new HomeUI.27((HomeUI)localObject2), 100L);
          }
        }
      }
      while ((paramInt1 == 65534) && (paramInt2 == -1))
      {
        MMEntryLock.unlock("welcome_page_show");
        com.tencent.mm.kernel.l.s(((HomeUI)localObject2).uLr, true);
        MMAppMgr.Xc();
        MMAppMgr.n(((HomeUI)localObject2).uLr, true);
        ((HomeUI)localObject2).uLr.finish();
        AppMethodBeat.o(33310);
        return;
        Log.i("MicroMsg.LauncherUI.HomeUI", "disagree privacy policy");
        localObject1 = new com.tencent.mm.plugin.account.model.h(2, str1);
        com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(712L, 5L, 1L, false);
        continue;
        if (paramInt1 == 22723)
        {
          String str2 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(274436, null);
          localObject1 = str1;
          if (paramIntent != null) {
            localObject1 = paramIntent.getBundleExtra("result_data");
          }
          if (localObject1 != null) {
            if (((Bundle)localObject1).getString("go_next", "").equals("birthdayComfirmOK"))
            {
              Log.i("MicroMsg.LauncherUI.HomeUI", "verify birthday ok");
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogv, Boolean.FALSE);
            }
            else if (((Bundle)localObject1).getString("go_next", "").equals("gdpr_confirm_logout"))
            {
              Log.i("MicroMsg.LauncherUI.HomeUI", "quit verify birthday after H5-warnning");
              localObject1 = new com.tencent.mm.plugin.account.model.h(2, str2);
              com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject1, 0);
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(712L, 5L, 1L, false);
            }
          }
        }
      }
      if ((paramInt1 == 30764) && (paramIntent != null))
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oho, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b(((HomeUI)localObject2).uLr, "android.permission.ACCESS_FINE_LOCATION", 66);
        }
      }
    }
    AppMethodBeat.o(33310);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(33320);
    Log.i("MicroMsg.LauncherUI", "onBackPressed");
    Object localObject = new Intent("android.intent.action.MAIN");
    ((Intent)localObject).addCategory("android.intent.category.HOME");
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/LauncherUI", "onBackPressed", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "onBackPressed", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33320);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(33325);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.ODR;
    com.tencent.mm.pluginsdk.h.a(paramConfiguration.uLr, paramConfiguration.contentView);
    AppMethodBeat.o(33325);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33299);
    com.tencent.mm.blink.a.yI(com.tencent.mm.kernel.h.aAl().hrC);
    if (ao.isDarkMode()) {
      setTheme(2131820570);
    }
    long l1;
    long l2;
    int i;
    boolean bool1;
    for (;;)
    {
      l1 = System.currentTimeMillis();
      Log.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), Util.getActivityTaskInfo(this) });
      super.onCreate(paramBundle);
      MainProcessChecker.aJX(getClass().getName());
      getWindow().getDecorView().setSystemUiVisibility(1280);
      l2 = System.currentTimeMillis();
      i = getTaskId();
      localObject2 = getPackageName();
      paramBundle = getIntent();
      boolean bool2 = false;
      bool1 = bool2;
      if (paramBundle != null)
      {
        bool1 = bool2;
        if (IntentUtil.getBooleanExtra(paramBundle, "absolutely_exit", false))
        {
          bool1 = true;
          Log.i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
        }
      }
      paramBundle = ODM.iterator();
      while (paramBundle.hasNext())
      {
        localObject1 = (LauncherUI)((WeakReference)paramBundle.next()).get();
        if (localObject1 != null) {
          Log.i("MicroMsg.LauncherUI", "Check launcher instance found one %s", new Object[] { localObject1 });
        }
      }
      setTheme(2131820575);
    }
    Object localObject1 = null;
    paramBundle = null;
    Object localObject3;
    if (!bool1)
    {
      localObject3 = ODL.iterator();
      localObject1 = paramBundle;
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (LauncherUI)((Iterator)localObject3).next();
        if (((LauncherUI)localObject1).getTaskId() != i)
        {
          Log.i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", new Object[] { Integer.valueOf(localObject1.hashCode()), Integer.valueOf(((LauncherUI)localObject1).getTaskId()), Integer.valueOf(i) });
          paramBundle = Util.getCurrentTaskInfo(this, i);
          if (paramBundle != null)
          {
            Log.i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), paramBundle.topActivity.getClassName(), paramBundle.baseActivity.getClassName(), Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
            if (paramBundle.baseActivity.getPackageName().equals(localObject2)) {
              break label597;
            }
            Log.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + paramBundle.baseActivity.getPackageName());
            finish();
            if (Util.getCurrentTaskInfo(this, ((LauncherUI)localObject1).getTaskId()) != null)
            {
              Log.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
              paramBundle = new Intent(this, LauncherUI.class);
              paramBundle.addFlags(268435456);
              paramBundle = new com.tencent.mm.hellhoundlib.b.a().bl(paramBundle);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.axQ(), "com/tencent/mm/ui/LauncherUI", "checkInstance", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramBundle.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "checkInstance", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        Log.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
        AppMethodBeat.o(33299);
        return;
        Log.e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", new Object[] { Integer.valueOf(i) });
        finish();
        i = 0;
        continue;
        label597:
        ((LauncherUI)localObject1).finish();
        ODL.remove(localObject1);
        break;
        if (!ODL.isEmpty())
        {
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = Util.getCurrentTaskInfo(this, i);
          }
          if (paramBundle == null) {
            break label895;
          }
          localObject1 = paramBundle.baseActivity.getClassName();
          localObject2 = paramBundle.baseActivity.getClassName();
          Log.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), localObject2, localObject1, Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
          localObject3 = getComponentName().getClassName();
          if ((paramBundle.numActivities > 1) && (((String)localObject3).equals(localObject1)) && (((String)localObject3).equals(localObject2)))
          {
            finish();
            Log.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(ODL.size()) });
            i = 0;
            continue;
          }
          Log.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", new Object[] { Integer.valueOf(ODL.size()), Boolean.valueOf(bool1) });
          ODL.clear();
        }
        for (;;)
        {
          ODL.add(this);
          ODM.add(new WeakReference(this));
          Log.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d weak check %d, use time %d", new Object[] { Integer.valueOf(ODL.size()), Integer.valueOf(ODM.size()), Long.valueOf(System.currentTimeMillis() - l2) });
          i = 1;
          break;
          label895:
          Log.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(ODL.size()) });
          ODL.clear();
        }
      }
    }
    if ((getIntent() != null) && (IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.jump_from_uimode_check", false)))
    {
      Log.i("MicroMsg.LauncherUI", "dancy onCreate uimode check from background, finish LauncherUI");
      finish();
      AppMethodBeat.o(33299);
      return;
    }
    Log.i("MicroMsg.LauncherUI", "onCreate normally");
    this.ODR = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.ODR);
    this.chattingTabUI.Dpx = this;
    paramBundle = this.ODR;
    localObject1 = this.chattingTabUI;
    paramBundle.uLr = this;
    paramBundle.OCN = ((a)localObject1);
    localObject1 = paramBundle.OCP;
    ((MainTabUI)localObject1).uLr = this;
    ((MainTabUI)localObject1).OIa = paramBundle;
    Object localObject2 = ((MainTabUI)localObject1).OHZ;
    ((ab)localObject2).uLr = this;
    ((ab)localObject2).OIn = paramBundle;
    ((MainTabUI)localObject1).FSw = paramBundle;
    paramBundle.OCO = new i(this, paramBundle);
    NotifyReceiver.akD();
    com.tencent.mm.pluginsdk.h.aU(paramBundle.uLr);
    paramBundle.mActionBar = getSupportActionBar();
    paramBundle.BdQ = findViewById(2131296366);
    if (paramBundle.mActionBar != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131099897)));
      }
      paramBundle.mActionBar.hide();
    }
    setRequestedOrientation(1);
    paramBundle.OCQ = getResources().getColor(2131100898);
    paramBundle.OCR = Color.alpha(paramBundle.OCQ);
    paramBundle = bf.iDu.aA("login_user_name", "");
    this.dRc = getIntent();
    localObject1 = this.ODX;
    ((com.tencent.mm.pluginsdk.t)localObject1).JTe = this.dRc.getBooleanExtra("splash-hack-activity-recreate", false);
    Log.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", new Object[] { ((com.tencent.mm.pluginsdk.t)localObject1).mTag, Boolean.valueOf(((com.tencent.mm.pluginsdk.t)localObject1).JTe) });
    Log.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", new Object[] { paramBundle, Boolean.valueOf(bg.aVG()), Boolean.valueOf(ODN) });
    if (gIs())
    {
      Log.i("MicroMsg.LauncherUI", "handleExitIntent return");
      AppMethodBeat.o(33299);
      return;
    }
    if ((!ODN) && ((bg.aVG()) || (!paramBundle.equals(""))))
    {
      ODO = l1;
      Log.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.d.dkt));
    }
    label1610:
    for (;;)
    {
      com.tencent.mm.pluginsdk.model.app.q.n(this, "");
      gIq();
      ao.aQ(this);
      com.tencent.mm.plugin.t.a.c.eBv().eBu();
      AppMethodBeat.o(33299);
      return;
      ODO = l1;
      Log.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.d.dkt));
      setRequestedOrientation(1);
      bool1 = bg.aVG();
      paramBundle = bf.iDu.aA("login_user_name", "");
      if ((!bool1) && (paramBundle.equals(""))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1504;
        }
        ChannelUtil.isShowingGprsAlert = false;
        break;
      }
      label1504:
      bool1 = false;
      if ((ChannelUtil.shouldShowGprsAlert) && (ChannelUtil.isShowingGprsAlert))
      {
        ODP = true;
        bool1 = MMAppMgr.a(this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(232595);
            LauncherUI.a(LauncherUI.this);
            LauncherUI.bvM();
            com.tencent.mm.pluginsdk.j.a.a.o.cjR();
            LauncherUI.b(LauncherUI.this);
            AppMethodBeat.o(232595);
          }
        });
      }
      for (;;)
      {
        if (bool1) {
          break label1610;
        }
        Bg(true);
        ODP = false;
        com.tencent.mm.pluginsdk.j.a.a.o.cjR();
        com.tencent.mm.plugin.report.service.g.Wn(8);
        gIu();
        Log.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        MMHandlerThread.removeRunnable(this.OEb);
        MMHandlerThread.postToMainThreadDelayed(this.OEb, 2000L);
        break;
        MMAppMgr.jO(this);
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(33324);
    if (this.chattingTabUI.gIx())
    {
      AppMethodBeat.o(33324);
      return false;
    }
    HomeUI localHomeUI = this.ODR;
    if ((localHomeUI.OCN == null) || (localHomeUI.OCN.gIx()))
    {
      AppMethodBeat.o(33324);
      return false;
    }
    localHomeUI.ODi = paramMenu;
    int i = localHomeUI.uLr.getSupportActionBar().getHeight();
    int j = com.tencent.mm.cb.a.aH(localHomeUI.uLr, 2131165306);
    if ((localHomeUI.OCP.acm == 3) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()) && (!com.tencent.mm.plugin.textstatus.a.p.fvC()) && ((!ao.gJK()) || (!ao.gJM())))
    {
      localHomeUI.ODh = paramMenu.add(0, 5, 0, 2131766798);
      if (localHomeUI.ODd == null)
      {
        com.tencent.mm.kiss.a.b.aBh();
        localHomeUI.ODd = com.tencent.mm.kiss.a.b.c(localHomeUI.uLr, 2131492950);
        paramMenu = new ViewGroup.LayoutParams(j, i);
        localHomeUI.ODd.setLayoutParams(paramMenu);
        localHomeUI.ODd.setMinimumHeight(i);
        localHomeUI.ODd.setMinimumWidth(j);
        localHomeUI.ODd.setOnLongClickListener(new HomeUI.6(localHomeUI));
        localHomeUI.ODd.setOnClickListener(new HomeUI.7(localHomeUI));
        localHomeUI.ODd.setContentDescription(localHomeUI.getString(2131766798));
      }
      if (localHomeUI.OCT)
      {
        localHomeUI.ODd.findViewById(2131309167).setVisibility(0);
        paramMenu = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.Kt(1L);
      }
      for (;;)
      {
        localHomeUI.ODh.setActionView(localHomeUI.ODd);
        localHomeUI.gIe();
        localHomeUI.gHU();
        Log.v("MicroMsg.LauncherUI.HomeUI", "onCreateOptionsMenu");
        AppMethodBeat.o(33324);
        return true;
        localHomeUI.ODd.findViewById(2131309167).setVisibility(8);
        paramMenu = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.Kt(0L);
      }
    }
    Object localObject;
    if (i == 0)
    {
      localObject = localHomeUI.uLr.getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels) {
        i = localHomeUI.uLr.getResources().getDimensionPixelSize(2131165255);
      }
    }
    for (;;)
    {
      localHomeUI.ODe = paramMenu.add(0, HomeUI.OCW, 0, 2131766796);
      localHomeUI.ODe.setIcon(2131689496);
      if (localHomeUI.OxS) {
        localHomeUI.ODe.setIcon(2131689503);
      }
      if (localHomeUI.Oyi == null)
      {
        localObject = new ViewGroup.LayoutParams(j, i);
        com.tencent.mm.kiss.a.b.aBh();
        localHomeUI.Oyi = com.tencent.mm.kiss.a.b.c(localHomeUI.uLr, 2131492950);
        localHomeUI.ODc = ((ImageView)localHomeUI.Oyi.findViewById(2131302468));
        localHomeUI.Oyi.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localHomeUI.Oyi.setMinimumHeight(i);
        localHomeUI.Oyi.setMinimumWidth(j);
        localHomeUI.ODc.setImageResource(2131689496);
        localHomeUI.ODc.setImageDrawable(ar.e(localHomeUI.uLr.getResources().getDrawable(2131689496), localHomeUI.uLr.getResources().getColor(2131099746)));
        localHomeUI.Oyi.setContentDescription(localHomeUI.getString(2131766796));
        localHomeUI.Oyi.setOnLongClickListener(new HomeUI.8(localHomeUI));
        localHomeUI.Oyi.setOnClickListener(new HomeUI.9(localHomeUI));
        localHomeUI.Oyi.post(new HomeUI.10(localHomeUI));
      }
      localHomeUI.ODe.setActionView(localHomeUI.Oyi);
      localHomeUI.ODf = paramMenu.add(0, HomeUI.OCX, 0, 2131766795);
      if (localHomeUI.OCZ == null) {
        localHomeUI.OCY = new HomeUI.b(localHomeUI, j, i);
      }
      if (com.tencent.mm.kernel.g.aAf().azp()) {
        com.tencent.mm.plugin.newtips.a.exl().h(localHomeUI.OCY);
      }
      if ((localHomeUI.OxS) && (localHomeUI.ODa != null)) {
        localHomeUI.ODa.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      com.tencent.mm.blink.b.ake().arrange(new HomeUI.11(localHomeUI));
      localHomeUI.ODf.setActionView(localHomeUI.OCZ);
      localHomeUI.gHU();
      localHomeUI.OCZ.getLayoutParams().width = j;
      localHomeUI.OCZ.getLayoutParams().height = i;
      break;
      i = localHomeUI.uLr.getResources().getDimensionPixelSize(2131165256);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33314);
    com.tencent.mm.blink.a.ajZ();
    super.onDestroy();
    Object localObject = this.ODR;
    ((HomeUI)localObject).OCP.cpB();
    if (((HomeUI)localObject).OCO != null)
    {
      i locali = ((HomeUI)localObject).OCO;
      EventCenter.instance.removeListener(locali.OCe);
      EventCenter.instance.removeListener(locali.OCf);
    }
    if (((HomeUI)localObject).OCv) {
      Looper.myQueue().removeIdleHandler(((HomeUI)localObject).pzA);
    }
    EventCenter.instance.removeListener(((HomeUI)localObject).ODk);
    localObject = this.chattingTabUI;
    if ((((NewChattingTabUI)localObject).mPrepareBitmap != null) && (!((NewChattingTabUI)localObject).mPrepareBitmap.isRecycled()))
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", new Object[] { ((NewChattingTabUI)localObject).mPrepareBitmap.toString() });
      ((NewChattingTabUI)localObject).mPrepareBitmap.recycle();
    }
    MMHandlerThread.removeRunnable(((NewChattingTabUI)localObject).mStartChattingRunnable);
    Looper.myQueue().removeIdleHandler(((NewChattingTabUI)localObject).OJI);
    if (this.ODW != null)
    {
      localObject = this.ODW;
      Log.i("MicroMsg.HKOfflineLogic", "doOnDestroy");
      ((com.tencent.mm.plugin.wallet_index.c.b)localObject).mContext = null;
      ((com.tencent.mm.plugin.wallet_index.c.b)localObject).jUC = null;
      ((com.tencent.mm.plugin.wallet_index.c.b)localObject).IqH = false;
      ((com.tencent.mm.plugin.wallet_index.c.b)localObject).IqI = null;
      com.tencent.mm.kernel.g.azz().b(2540, (com.tencent.mm.ak.i)localObject);
      this.ODW = null;
    }
    this.ODQ.dead();
    gIp();
    Log.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), Util.getActivityTaskInfo(this), Integer.valueOf(ODL.size()) });
    AppMethodBeat.o(33314);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(33331);
    super.onMultiWindowModeChanged(paramBoolean);
    Log.i("MicroMsg.LauncherUI", "alvinluo onMultiWindowModeChanged2 isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    mv localmv = new mv();
    localmv.dSu.dSv = paramBoolean;
    EventCenter.instance.publish(localmv);
    AppMethodBeat.o(33331);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(33301);
    Log.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", new Object[] { Integer.valueOf(hashCode()), Util.getActivityTaskInfo(this) });
    this.dRc = paramIntent;
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if ((this.dRc != null) && (IntentUtil.getBooleanExtra(this.dRc, "LauncherUI.jump_from_uimode_check", false)))
    {
      Log.i("MicroMsg.LauncherUI", "dancy onNewIntent uimode check from background, finish LauncherUI");
      finish();
      AppMethodBeat.o(33301);
      return;
    }
    com.tencent.mm.pluginsdk.model.app.q.n(this, "");
    if (gIs())
    {
      Log.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
      AppMethodBeat.o(33301);
      return;
    }
    if ((this.dRc != null) && (IntentUtil.getBooleanExtra(this.dRc, "Intro_Need_Clear_Top ", false)))
    {
      Log.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
      finish();
      jI(this);
      AppMethodBeat.o(33301);
      return;
    }
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      closeChatting(false);
    }
    MainTabUI localMainTabUI = this.ODR.OCP;
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      localMainTabUI.OIb = true;
    }
    if (this.ODT)
    {
      Log.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
      bz(paramIntent);
    }
    com.tencent.mm.plugin.t.a.c.eBv().eBu();
    AppMethodBeat.o(33301);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int j = 0;
    AppMethodBeat.i(33323);
    HomeUI localHomeUI = this.ODR;
    Object localObject = localHomeUI.uLr.getCurrentFragmet();
    int i;
    if ((localObject != null) && (((MMFragment)localObject).isShowing())) {
      i = j;
    }
    while (i != 0)
    {
      AppMethodBeat.o(33323);
      return true;
      i = j;
      if (!localHomeUI.OCN.gIx())
      {
        if (paramMenuItem.getItemId() == HomeUI.OCX)
        {
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10919, "0");
          localHomeUI.gHT();
        }
        for (;;)
        {
          i = 1;
          break;
          if (paramMenuItem.getItemId() == HomeUI.OCW)
          {
            localHomeUI.gHV();
          }
          else
          {
            i = j;
            if (paramMenuItem.getItemId() != 5) {
              break;
            }
            if ((CrashReportFactory.hasDebuger()) || (ac.jPA))
            {
              localObject = new com.tencent.mm.ui.tools.l(localHomeUI.uLr);
              ((com.tencent.mm.ui.tools.l)localObject).HLX = new HomeUI.13(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).HLY = new HomeUI.14(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).gXI();
            }
            else
            {
              localHomeUI.gHW();
            }
          }
        }
      }
    }
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(33323);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(33311);
    Log.d("MicroMsg.LauncherUI", "onPause %s, chatting is show ", new Object[] { Integer.valueOf(hashCode()) });
    super.onPause();
    Object localObject = this.ODX;
    boolean bool = ((com.tencent.mm.pluginsdk.t)localObject).fP("onPause");
    if (bool) {
      ((com.tencent.mm.pluginsdk.t)localObject).JTe = false;
    }
    if (bool)
    {
      Log.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
      AppMethodBeat.o(33311);
      return;
    }
    com.tencent.mm.blink.a.ajZ();
    Log.i("MicroMsg.LauncherUI", "not skip this onPause");
    localObject = getCurrentFragmet();
    this.OEa.removeCallbacksAndMessages(null);
    if (!ao.gJK())
    {
      this.ODR.gHP();
      this.chattingTabUI.gHP();
    }
    if (localObject != null)
    {
      AppMethodBeat.o(33311);
      return;
    }
    this.ODU = false;
    localObject = r.NPl;
    r.gzU();
    AppMethodBeat.o(33311);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(33313);
    this.ODZ = false;
    Object localObject;
    if (!this.ODS.a(this, paramInt, paramArrayOfString, paramArrayOfInt))
    {
      localObject = this.ODR;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      localObject = this.chattingTabUI;
      if (((NewChattingTabUI)localObject).OJN != null) {
        ((NewChattingTabUI)localObject).OJN.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(33313);
      return;
      if (paramInt == 80) {}
      for (int i = 2131763876; paramArrayOfInt[0] != 0; i = 2131763864)
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).uLr, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(2131763890), ((HomeUI)localObject).getString(2131762043), ((HomeUI)localObject).getString(2131756929), false, new HomeUI.28((HomeUI)localObject), new HomeUI.29((HomeUI)localObject));
        break;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ((HomeUI)localObject).gHV();
      }
      else
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).uLr, ((HomeUI)localObject).getString(2131763874), ((HomeUI)localObject).getString(2131763890), ((HomeUI)localObject).getString(2131762043), ((HomeUI)localObject).getString(2131756929), false, new HomeUI.30((HomeUI)localObject), null);
        continue;
        if (paramArrayOfInt[0] == 0)
        {
          localObject = ((HomeUI)localObject).OCP.gIX();
          if ((localObject instanceof FindMoreFriendsUI)) {
            ((FindMoreFriendsUI)localObject).gHw();
          }
        }
        else
        {
          com.tencent.mm.ui.base.h.a(((HomeUI)localObject).uLr, ((HomeUI)localObject).getString(2131763874), ((HomeUI)localObject).getString(2131763890), ((HomeUI)localObject).getString(2131762043), ((HomeUI)localObject).getString(2131756929), false, new HomeUI.31((HomeUI)localObject), null);
          continue;
          if (paramArrayOfInt[0] == 0)
          {
            ((HomeUI)localObject).gHW();
          }
          else
          {
            if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
            for (i = 2131763864;; i = 2131763876)
            {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).uLr, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(2131763890), ((HomeUI)localObject).getString(2131762043), ((HomeUI)localObject).getString(2131755761), false, new HomeUI.32((HomeUI)localObject), new HomeUI.33((HomeUI)localObject));
              break;
            }
            if (paramArrayOfInt[0] == 0) {
              ((HomeUI)localObject).gHW();
            } else {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).uLr, ((HomeUI)localObject).getString(2131763874), ((HomeUI)localObject).getString(2131763890), ((HomeUI)localObject).getString(2131762043), ((HomeUI)localObject).getString(2131756929), false, new HomeUI.35((HomeUI)localObject), null);
            }
          }
        }
      }
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(33321);
    super.onRestoreInstanceState(paramBundle);
    NewChattingTabUI localNewChattingTabUI = this.chattingTabUI;
    localNewChattingTabUI.OJK = paramBundle.getString("last_restore_talker");
    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", new Object[] { localNewChattingTabUI.OJK });
    this.OEc = paramBundle.getBoolean("last_stay_chatting");
    this.OEd = paramBundle.getInt("last_stay_tab");
    if (this.OEc) {
      this.chattingTabUI.startChatting(this.chattingTabUI.OJK, null, false);
    }
    AppMethodBeat.o(33321);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33303);
    Log.i("MicroMsg.LauncherUI", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    super.onResume();
    if (this.ODX.fP("onResume"))
    {
      Log.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
      AppMethodBeat.o(33303);
      return;
    }
    Log.i("MicroMsg.LauncherUI", "not skip this onResume");
    ODN = false;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    long l1;
    Object localObject4;
    Object localObject5;
    label823:
    int i;
    Object localObject6;
    long l2;
    if (gIr())
    {
      Log.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", new Object[] { Boolean.valueOf(this.ODT) });
      if (!bg.aAc())
      {
        Log.w("MicroMsg.LauncherUI", "accHasNotReady, kill self");
        finish();
        Log.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/LauncherUI", "onResume", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/LauncherUI", "onResume", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(33303);
        return;
      }
      if (!this.ODT)
      {
        this.ODT = true;
        localObject1 = this.ODR;
        Log.i("MicroMsg.LauncherUI.HomeUI", "doOnCreate");
        if ((HomeUI.gIf()) && (HomeUI.gIg()))
        {
          bool1 = true;
          ((HomeUI)localObject1).OCT = bool1;
          localObject2 = ((HomeUI)localObject1).OCO;
          EventCenter.instance.addListener(((i)localObject2).OCe);
          EventCenter.instance.addListener(((i)localObject2).OCf);
          if (!com.tencent.mm.ui.conversation.b.gVn()) {
            getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
          }
          localObject2 = ((HomeUI)localObject1).uLr.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aps());
          if (((SharedPreferences)localObject2).getBoolean("first_launch_weixin", true))
          {
            ((SharedPreferences)localObject2).edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
          }
          ((HomeUI)localObject1).OCD = new af(this);
          ((HomeUI)localObject1).OCv = true;
          NotifyReceiver.akF();
          bg.getNotification().nS(1);
          if (bg.aAc()) {
            break label2858;
          }
          Log.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
          ((HomeUI)localObject1).uLr.finish();
          bz(getIntent());
        }
      }
      else
      {
        localObject1 = this.ODR;
        l1 = Util.nowMilliSecond();
        localObject2 = ((HomeUI)localObject1).OCP;
        Log.i("MicroMsg.LauncherUI.MainTabUI", "onResume start :%d", new Object[] { Integer.valueOf(((MainTabUI)localObject2).acm) });
        if (((MainTabUI)localObject2).OIl.size() != 0)
        {
          localObject4 = ((MainTabUI)localObject2).alf(((MainTabUI)localObject2).acm);
          Log.i("MicroMsg.LauncherUI.MainTabUI", "notifyCurrentTabResumeUI, mCurIndex:%s", new Object[] { Integer.valueOf(((MainTabUI)localObject2).acm) });
          if (localObject4 != null) {
            ((n)localObject4).gGE();
          }
          if ((localObject4 != null) && (com.tencent.matrix.b.isInstalled()) && (((MMFragment)localObject4).getActivity() != null))
          {
            localObject5 = ((MMFragment)localObject4).getActivity().getClass().getName();
            com.tencent.matrix.a.cPA.eg((String)localObject5 + "#" + localObject4.getClass().getSimpleName());
          }
        }
        if ((((MainTabUI)localObject2).OIb) && (((MainTabUI)localObject2).uLr.getIntent().hasExtra("isScrollFirst")) && (((MainTabUI)localObject2).uLr.getIntent().hasExtra("isShowHeader")))
        {
          localObject4 = (MainUI)((MainTabUI)localObject2).OIl.get(Integer.valueOf(0));
          if (localObject4 != null)
          {
            bool1 = ((MainTabUI)localObject2).uLr.getIntent().getBooleanExtra("isShowHeader", false);
            bool2 = ((MainTabUI)localObject2).uLr.getIntent().getBooleanExtra("isScrollFirst", true);
            ((MainUI)localObject4).q(bool1, ((MainTabUI)localObject2).uLr.getIntent().getBooleanExtra("isShowHeaderWithAnim", false), bool2);
          }
        }
        if (((MainTabUI)localObject2).OIb)
        {
          ((MainTabUI)localObject2).OIb = false;
          ((MainTabUI)localObject2).blU("tab_main");
        }
        localObject4 = (MainUI)((MainTabUI)localObject2).OIl.get(Integer.valueOf(0));
        if (localObject4 != null)
        {
          ((MainUI)localObject4).gUq();
          ((MainUI)localObject4).gVW();
        }
        if (((MainTabUI)localObject2).acm != 0) {
          break label3878;
        }
        bg.getNotification().dh(true);
        localObject4 = (n)((MainTabUI)localObject2).alf(((MainTabUI)localObject2).acm);
        if (localObject4 != null) {
          ((n)localObject4).gGF();
        }
        ((MainTabUI)localObject2).OIb = false;
        i = IntentUtil.getIntExtra(((MainTabUI)localObject2).uLr.getIntent(), "preferred_tab", 0);
        Log.d("MicroMsg.LauncherUI.MainTabUI", "doOnResume, tabIdx = %d", new Object[] { Integer.valueOf(i) });
        if (i != 0)
        {
          ((MainTabUI)localObject2).ale(i);
          ((MainTabUI)localObject2).uLr.getIntent().putExtra("preferred_tab", 0);
        }
        EventCenter.instance.addListener(((MainTabUI)localObject2).OIg);
        EventCenter.instance.addListener(((MainTabUI)localObject2).OIi);
        EventCenter.instance.addListener(((MainTabUI)localObject2).OIj);
        localObject2 = ((MainTabUI)localObject2).OHZ;
        if (((ab)localObject2).OIo != null) {
          ((ab)localObject2).OIo.gGO();
        }
        if (bg.aAc())
        {
          bg.aVF();
          com.tencent.mm.model.c.azQ().add(((ab)localObject2).OIt);
          com.tencent.mm.y.c.axV().a(((ab)localObject2).OIs);
          bg.aVF();
          com.tencent.mm.model.c.aST().add((MStorageEx.IOnStorageChange)localObject2);
          EventCenter.instance.addListener(((ab)localObject2).OAR);
          EventCenter.instance.addListener(((ab)localObject2).OIu);
          EventCenter.instance.addListener(((ab)localObject2).OAQ);
        }
        com.tencent.mm.blink.b.ake().arrange(new ab.7((ab)localObject2));
        localObject2 = ((HomeUI)localObject1).OCO;
        localObject6 = new bk();
        EventCenter.instance.publish((IEvent)localObject6);
        if ((((bk)localObject6).dEE.dEF) && (!Util.isNullOrNil(((bk)localObject6).dEE.msg)))
        {
          Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "  now show msg:%s", new Object[] { ((bk)localObject6).dEE.msg });
          localObject4 = new f.a(((i)localObject2).uLr);
          localObject5 = ((f.a)localObject4).aC(((i)localObject2).getString(2131756010)).aD(((i)localObject2).getString(2131756009));
          localObject6 = ((bk)localObject6).dEE.msg;
          ((f.a)localObject5).Kfg.bop((String)localObject6);
          localObject4 = ((f.a)localObject4).Dq(false).b(new i.2((i)localObject2));
          ((f.a)localObject4).JnN = true;
          ((f.a)localObject4).show();
        }
        if (!((i)localObject2).a(((i)localObject2).OCa)) {
          bg.aAk().postToWorkerDelayed(new i.6((i)localObject2), 500L);
        }
        ((i)localObject2).OCa = null;
        CrashReportFactory.setForeground(true);
        bool1 = ((HomeUI)localObject1).OCN.gIx();
        if ((!bool1) && (bg.aAc()))
        {
          com.tencent.mm.blink.b.ake().arrange(new HomeUI.40((HomeUI)localObject1));
          if ((com.tencent.mm.bi.d.jpB != null) && (com.tencent.mm.bi.d.jpA != null) && (!Util.isNullOrNil(com.tencent.mm.bi.d.jpA.bgK())))
          {
            Log.i("MicroMsg.LauncherUI.HomeUI", "launcher onResume end track %s", new Object[] { com.tencent.mm.bi.d.jpB.bgL() });
            localObject2 = new fo();
            ((fo)localObject2).dIN.username = com.tencent.mm.bi.d.jpB.bgL();
            EventCenter.instance.publish((IEvent)localObject2);
          }
        }
        if (!bool1)
        {
          k.a(((HomeUI)localObject1).uLr, 3, ((HomeUI)localObject1).OCP.acm, "directReport_onResume");
          ((HomeUI)localObject1).OCP.alb(260);
        }
        com.tencent.mm.ui.widget.h.b(((HomeUI)localObject1).uLr);
        ((HomeUI)localObject1).uLr.onSwipe(1.0F);
        ((HomeUI)localObject1).OCM = HomeUI.a.ODz;
        if (((HomeUI)localObject1).OCx)
        {
          ((HomeUI)localObject1).OCx = false;
          ((HomeUI)localObject1).OCx = false;
        }
        com.tencent.mm.aj.o.aYx();
        l2 = System.currentTimeMillis();
        Log.w("MicroMsg.LauncherUI.HomeUI", "[Launching Application]");
        com.tencent.mm.kernel.l.s(((HomeUI)localObject1).uLr, false);
        com.tencent.mm.kernel.l.t(((HomeUI)localObject1).uLr, false);
        long l3 = System.currentTimeMillis();
        bool1 = ((HomeUI)localObject1).uLr.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("settings_landscape_mode", false);
        localObject2 = com.tencent.mm.ui.component.a.PRN;
        boolean bool2 = ((MultiTaskUIC)com.tencent.mm.ui.component.a.b(((HomeUI)localObject1).uLr).get(MultiTaskUIC.class)).erO();
        if ((!bool1) || (bool2)) {
          break label3890;
        }
        ((HomeUI)localObject1).uLr.setRequestedOrientation(-1);
        label1590:
        long l4 = System.currentTimeMillis();
        if (getInstance() != null)
        {
          com.tencent.mm.blink.b.ake().akh();
          ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("showprivacypolicy", ((HomeUI)localObject1).ODo);
          ((HomeUI)localObject1).Bb(false);
          EventCenter.instance.addListener(((HomeUI)localObject1).CWJ);
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - l4));
          if (bg.aAc()) {
            ((HomeUI)localObject1).gIe();
          }
        }
        Log.v("MicroMsg.LauncherUI.HomeUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - l3));
        Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - l2));
        Log.i("MicroMsg.LauncherUI.HomeUI", "initView " + (System.currentTimeMillis() - l1));
        if (((HomeUI)localObject1).OCx)
        {
          ((HomeUI)localObject1).OCx = false;
          ((HomeUI)localObject1).OCx = false;
        }
        localObject2 = com.tencent.mm.app.w.WE();
        ((com.tencent.mm.app.w)localObject2).dlW = true;
        ((com.tencent.mm.app.w)localObject2).dlX.removeMessages(-1999);
        ((com.tencent.mm.app.w)localObject2).dlX.removeMessages(-2999);
        Log.i("MicroMsg.LauncherUI.HomeUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - l1));
        if (z.aUQ().booleanValue()) {
          ((HomeUI)localObject1).gHS();
        }
        i = com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.OiW, 0);
        if (i != 0)
        {
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OiW, Integer.valueOf(0));
          if (z.aUF()) {}
        }
        switch (i)
        {
        default: 
          label1928:
          com.tencent.mm.blink.b.ake().arrange(new HomeUI.2((HomeUI)localObject1));
          if (((HomeUI)localObject1).getMainTabUI().acm != 3)
          {
            localObject1 = (MoreTabUI)((HomeUI)localObject1).getMainTabUI().alf(3);
            if ((((MoreTabUI)localObject1).OIC != null) && (!((MoreTabUI)localObject1).OIC.isVisible))
            {
              ((MoreTabUI)localObject1).OIC.hbX();
              ((MoreTabUI)localObject1).eEh();
            }
          }
          localObject1 = this.chattingTabUI;
          ((NewChattingTabUI)localObject1).OJF = Util.nowSecond();
          if (((NewChattingTabUI)localObject1).gJv())
          {
            ((NewChattingTabUI)localObject1).OJI = new NewChattingTabUI.1((NewChattingTabUI)localObject1);
            MMHandlerThread.postToMainThreadDelayed(new NewChattingTabUI.2((NewChattingTabUI)localObject1), 500L);
          }
          if (((NewChattingTabUI)localObject1).gIx())
          {
            ((NewChattingTabUI)localObject1).pl(3);
            if ((((NewChattingTabUI)localObject1).OJN != null) && (((NewChattingTabUI)localObject1).OJN.isSupportNavigationSwipeBack())) {
              ((NewChattingTabUI)localObject1).OJN.getSwipeBackLayout().setEnableGesture(true);
            }
            label2097:
            Log.i("MicroMsg.LauncherUI", "resumeNormalJump");
            MMFragmentActivity.a.gIV();
            if (("pushcontent_notification".equals(IntentUtil.getStringExtra(getIntent(), "nofification_type"))) && (!Util.isNullOrNil(IntentUtil.getStringExtra(getIntent(), "Main_FromUserName"))))
            {
              localObject1 = IntentUtil.getStringExtra(getIntent(), "Main_FromUserName");
              i = IntentUtil.getIntExtra(getIntent(), "MainUI_User_Last_Msg_Type", 0);
              Log.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + (String)localObject1 + i);
              com.tencent.mm.plugin.report.service.h.CyF.a(10856, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(0) });
            }
            localObject1 = IntentUtil.getStringExtra(getIntent(), "LauncherUI.Shortcut.LaunchType");
            if (localObject1 != null)
            {
              if (!((String)localObject1).equals("launch_type_voip")) {
                break label3977;
              }
              Log.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
              localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.CyF.a(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
            }
            label2390:
            localObject1 = IntentUtil.getStringExtra(getIntent(), "LauncherUI.switch.tab");
            if (!Util.isNullOrNil((String)localObject1))
            {
              this.ODR.getMainTabUI().blU((String)localObject1);
              getIntent().putExtra("LauncherUI.switch.tab", "");
            }
            if ((IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) || (this.ODV))
            {
              this.ODV = false;
              localObject1 = getInstance();
              if (localObject1 != null) {
                ((LauncherUI)localObject1).ODR.gHY();
              }
              getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
              getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
            }
            bool1 = IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
            if (!bool1) {
              break label4849;
            }
            localObject1 = IntentUtil.getStringExtra(getIntent(), "LauncherUI.Shortcut.Username");
            label2534:
            if (bool1)
            {
              Log.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = ".concat(String.valueOf(localObject1)));
              if (!Util.isNullOrNil((String)localObject1))
              {
                localObject4 = com.tencent.mm.plugin.base.model.b.agY((String)localObject1);
                if (!Util.isNullOrNil((String)localObject4))
                {
                  if (com.tencent.mm.model.ab.IS((String)localObject4))
                  {
                    Log.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                    if (!com.tencent.mm.al.g.Ne((String)localObject4)) {
                      break label5164;
                    }
                    if (!com.tencent.mm.al.g.DQ((String)localObject4)) {
                      break label4873;
                    }
                    localObject1 = new Intent();
                    ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                    ((Intent)localObject1).putExtra("Contact_User", (String)localObject4);
                    ((Intent)localObject1).putExtra("biz_chat_from_scene", 9);
                    ((Intent)localObject1).addFlags(67108864);
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                  getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
                  getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
                }
              }
            }
            label2735:
            this.ODU = true;
            label2764:
            com.tencent.mm.blink.a.nO(5);
            if (!ODP) {
              Bg(false);
            }
            gIq();
            localObject1 = (com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class);
            if (localObject1 == null) {
              break label5199;
            }
            Log.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, try to fix");
            ((com.tencent.mm.plugin.ball.c.b)localObject1).chP();
          }
          break;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYj();
        com.tencent.mm.plugin.base.stub.f.cjY();
        this.ODQ.alive();
        com.tencent.mm.blink.a.CM("LauncherUI");
        AppMethodBeat.o(33303);
        return;
        bool1 = false;
        break;
        label2858:
        Log.d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
        l1 = System.currentTimeMillis();
        l2 = System.currentTimeMillis();
        MMActivity.initLanguage(((HomeUI)localObject1).uLr);
        try
        {
          localObject2 = new HashSet();
          localObject4 = ((HomeUI)localObject1).getString(2131758201).split(";");
          ((Set)localObject2).add(localObject4[0]);
          ((Set)localObject2).add(localObject4[1]);
          aa.f((Set)localObject2);
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAk().postToWorker(new HomeUI.17((HomeUI)localObject1));
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).kgB = ((LayoutInflater)((HomeUI)localObject1).uLr.getSystemService("layout_inflater"));
          l2 = System.currentTimeMillis();
          com.tencent.mm.kiss.a.b.aBh();
          ((HomeUI)localObject1).contentView = com.tencent.mm.kiss.a.b.c(((HomeUI)localObject1).uLr, 2131495410);
          if ((((HomeUI)localObject1).contentView != null) && (Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.isMIUIV8())) {
            ((HomeUI)localObject1).contentView.setBackgroundColor(((HomeUI)localObject1).uLr.getResources().getColor(2131100898));
          }
          com.tencent.mm.blink.b.ake().akf();
          ((FirstScreenFrameLayout)((HomeUI)localObject1).contentView.findViewById(2131301553)).gkU = new HomeUI.23((HomeUI)localObject1);
          com.tencent.mm.pluginsdk.model.app.ao.gne();
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).uLr.setContentView(((HomeUI)localObject1).contentView);
          Looper.myQueue().addIdleHandler(((HomeUI)localObject1).pzA);
          ((HomeUI)localObject1).OCw = true;
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).initActionBar();
          ((HomeUI)localObject1).mActionBar.show();
          ((HomeUI)localObject1).contentView.post(new HomeUI.34((HomeUI)localObject1));
          Log.v("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - l1));
          MMHandlerThread.postToMainThreadDelayed(new HomeUI.37((HomeUI)localObject1), 2000L);
          ((HomeUI)localObject1).contentView.addOnLayoutChangeListener(((HomeUI)localObject1).OCV);
          com.tencent.mm.pluginsdk.h.a(((HomeUI)localObject1).uLr, ((HomeUI)localObject1).contentView);
          ((HomeUI)localObject1).contentView.postDelayed(new HomeUI.38((HomeUI)localObject1), 20L);
          aw.kA(MMApplicationContext.getContext());
          aw.aoh(1);
          EventCenter.instance.addListener(((HomeUI)localObject1).ODk);
          localObject5 = ((HomeUI)localObject1).OCP;
          Log.i("MicroMsg.LauncherUI.MainTabUI", "doOnCreate");
          ((MainTabUI)localObject5).mViewPager = ((CustomViewPager)((MainTabUI)localObject5).uLr.findViewById(2131305772));
          ((MainTabUI)localObject5).mViewPager.setOffscreenPageLimit(4);
          ((MainTabUI)localObject5).setCanSlide(true);
          ((MainTabUI)localObject5).mViewPager.setCanSlideBySide(false);
          ((MainTabUI)localObject5).mTabsAdapter = new MainTabUI.TabsAdapter((MainTabUI)localObject5, ((MainTabUI)localObject5).uLr, ((MainTabUI)localObject5).mViewPager);
          if (getInstance() != null)
          {
            ((MainTabUI)localObject5).ale(getInstance().OEd);
            localObject2 = ((MainTabUI)localObject5).OHZ;
            localObject4 = (ViewGroup)((MainTabUI)localObject5).mViewPager.getParent();
            localObject5 = ((MainTabUI)localObject5).mTabsAdapter;
            localObject6 = ((ab)localObject2).OIo;
            if (((ab)localObject2).OIo != null)
            {
              ((ab)localObject2).OIo.setOnTabClickListener(null);
              ((View)((ab)localObject2).OIo).setVisibility(8);
              if (localObject4 != null) {
                ((ViewGroup)localObject4).removeView((View)((ab)localObject2).OIo);
              }
            }
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
            LauncherUIBottomTabView localLauncherUIBottomTabView = new LauncherUIBottomTabView(((ab)localObject2).uLr);
            localLauncherUIBottomTabView.setId(2131303053);
            if (localObject4 != null)
            {
              localLayoutParams.gravity = 80;
              ((ViewGroup)localObject4).addView(localLauncherUIBottomTabView, localLayoutParams);
            }
            ((ab)localObject2).OIo = localLauncherUIBottomTabView;
            ((View)((ab)localObject2).OIo).setVisibility(0);
            ((ab)localObject2).OIo.setOnTabClickListener((c.a)localObject5);
            if ((localObject6 != null) && (localObject6 != ((ab)localObject2).OIo))
            {
              ((ab)localObject2).OIo.AT(((c)localObject6).getShowFriendPoint());
              ((ab)localObject2).OIo.AU(((c)localObject6).getSettingsPoint());
              ((ab)localObject2).OIo.akH(((c)localObject6).getMainTabUnread());
              ((ab)localObject2).OIo.akI(((c)localObject6).getContactTabUnread());
              ((ab)localObject2).OIo.akJ(((c)localObject6).getFriendTabUnread());
              ((ab)localObject2).OIo.akK(((c)localObject6).getSettingsTabUnread());
              ((ab)localObject2).OIo.setTo(((c)localObject6).getCurIdx());
            }
            ((HomeUI)localObject1).OCP.OIf = new HomeUI.1((HomeUI)localObject1);
            com.tencent.f.h.RTc.aX(new HomeUI.12((HomeUI)localObject1));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
            continue;
            ((MainTabUI)localObject5).ale(0);
          }
        }
      }
      label3878:
      bg.getNotification().dh(false);
      break label823;
      label3890:
      ((HomeUI)localObject1).uLr.setRequestedOrientation(1);
      break label1590;
      com.tencent.mm.ui.base.h.a(((HomeUI)localObject1).uLr, ((HomeUI)localObject1).getString(2131762496), "", new HomeUI.41((HomeUI)localObject1), null);
      break label1928;
      if (!((NewChattingTabUI)localObject1).OJQ) {
        break label2097;
      }
      Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "[onResume] need exec this runnable!");
      MMHandlerThread.removeRunnable(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      MMHandlerThread.postToMainThread(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      ((NewChattingTabUI)localObject1).OJQ = false;
      break label2097;
      label3977:
      if (((String)localObject1).equals("launch_type_voip_audio"))
      {
        Log.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
        localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.CyF.a(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        break label2390;
      }
      if (((String)localObject1).equals("launch_type_scan_qrcode"))
      {
        getIntent().putExtra("LauncherUI.Shortcut.LaunchType", "");
        localObject1 = SecDataUIC.CWq;
        localObject1 = (chc)SecDataUIC.a.a(this, "BaseScanUI", 3, chc.class);
        if (localObject1 != null) {
          ((chc)localObject1).Mmm = "launch_type_scan_qrcode";
        }
        localObject1 = new Intent().setClassName(this, "com.tencent.mm.plugin.scanner.ui.BaseScanUI");
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break label2390;
      }
      if (((String)localObject1).equals("launch_type_offline_wallet"))
      {
        getIntent().putExtra("LauncherUI.Shortcut.LaunchType", "");
        localObject1 = SecDataUIC.CWq;
        localObject1 = (chc)SecDataUIC.a.a(this, "WalletOfflineEntranceUI", 3, chc.class);
        if (localObject1 != null) {
          ((chc)localObject1).Mmm = "launch_type_offline_wallet";
        }
        i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
        if ((i == 0) || (i == 1))
        {
          localObject1 = new Intent().setClassName(this, "com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI");
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break label2390;
        }
        if (i != 8) {
          break label2390;
        }
        if (this.ODW == null) {
          this.ODW = new com.tencent.mm.plugin.wallet_index.c.b();
        }
        localObject1 = this.ODW;
        ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).mContext = this;
        ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).jUC = null;
        ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).IqH = false;
        ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).IqI = null;
        com.tencent.mm.kernel.g.azz().a(2540, (com.tencent.mm.ak.i)localObject1);
        localObject3 = com.tencent.mm.plugin.wallet_index.c.b.fUn();
        if (Util.isNullOrNil(((daj)localObject3).MFD))
        {
          Log.i("MicroMsg.HKOfflineLogic", "hk OfflineH5 has no cache");
          ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).yz(false);
          break label2390;
        }
        l1 = System.currentTimeMillis();
        l2 = l1 - ((daj)localObject3).MFF;
        Log.d("MicroMsg.HKOfflineLogic", "hk currentTime ：%s ,lastTime：%s,internalTime ：%s", new Object[] { Long.valueOf(l1), Long.valueOf(((daj)localObject3).MFF), Long.valueOf(l2) });
        if (l2 < ((daj)localObject3).MFE)
        {
          Log.i("MicroMsg.HKOfflineLogic", "hk OfflineH5 dont expired，url：%s", new Object[] { ((daj)localObject3).MFD });
          com.tencent.mm.wallet_core.ui.f.o(((com.tencent.mm.plugin.wallet_index.c.b)localObject1).mContext, ((daj)localObject3).MFD, false);
          ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).yz(true);
          break label2390;
        }
        Log.i("MicroMsg.HKOfflineLogic", "hk OfflineH5 is expired");
        ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).yz(false);
        break label2390;
      }
      if (!((String)localObject1).equals("launch_type_my_qrcode")) {
        break label2390;
      }
      getIntent().putExtra("LauncherUI.Shortcut.LaunchType", "");
      localObject1 = SecDataUIC.CWq;
      localObject1 = (chc)SecDataUIC.a.a(this, "SelfQRCodeUI", 3, chc.class);
      if (localObject1 != null) {
        ((chc)localObject1).Mmm = "launch_type_my_qrcode";
      }
      localObject1 = new Intent().setClassName(this, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break label2390;
      label4849:
      bool1 = IntentUtil.getBooleanExtra(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
      localObject1 = getIntent().getAction();
      break label2534;
      label4873:
      if (com.tencent.mm.al.g.Ng((String)localObject4))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject1).putExtra("enterprise_biz_name", (String)localObject4);
        ((Intent)localObject1).putExtra("enterprise_biz_display_name", aa.getDisplayName((String)localObject4));
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break label2735;
      }
      if (com.tencent.mm.al.g.Nh((String)localObject4))
      {
        localObject1 = com.tencent.mm.al.g.fJ((String)localObject4);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).UJ())
        {
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = "";
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("rawUrl", (String)localObject3);
          ((Intent)localObject1).putExtra("useJs", true);
          ((Intent)localObject1).putExtra("srcUsername", (String)localObject4);
          ((Intent)localObject1).putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
          ((Intent)localObject1).addFlags(67108864);
          com.tencent.mm.br.c.b(this, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          break;
        }
      }
      localObject1 = getInstance();
      Object localObject3 = new Bundle();
      ((Bundle)localObject3).putInt("chat_from_scene", 3);
      ((LauncherUI)localObject1).startChatting((String)localObject4, (Bundle)localObject3, false);
      break label2735;
      label5164:
      localObject1 = getInstance();
      if (localObject1 == null) {
        break label2735;
      }
      ((LauncherUI)localObject1).startChatting((String)localObject4, null, false);
      break label2735;
      if (ODP) {
        break label2764;
      }
      gIu();
      break label2764;
      label5199:
      Log.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, service is null");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(33322);
    super.onSaveInstanceState(paramBundle);
    Object localObject = this.chattingTabUI;
    if (((NewChattingTabUI)localObject).OJN != null)
    {
      localObject = ((NewChattingTabUI)localObject).OJN.dom.getTalkerUserName();
      if (!Util.isNullOrNil((String)localObject))
      {
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "onSaveInstanceState:%s", new Object[] { localObject });
        paramBundle.putString("last_restore_talker", (String)localObject);
      }
    }
    if (getCurrentFragmet() != null) {}
    for (;;)
    {
      paramBundle.putBoolean("last_stay_chatting", bool);
      paramBundle.putInt("last_stay_tab", getCurrentTabIndex());
      AppMethodBeat.o(33322);
      return;
      bool = false;
    }
  }
  
  public void onSettle(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(33318);
    if ((this.ODT) && (!this.chattingTabUI.ac(paramBoolean, paramInt))) {
      super.onSettle(paramBoolean, paramInt);
    }
    AppMethodBeat.o(33318);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(33312);
    Log.i("MicroMsg.LauncherUI", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.blink.a.ajZ();
    if (ao.gJK())
    {
      this.ODR.gHP();
      this.chattingTabUI.gHP();
    }
    HomeUI localHomeUI = this.ODR;
    ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("showprivacypolicy", localHomeUI.ODo);
    super.onStop();
    AppMethodBeat.o(33312);
  }
  
  public void onSwipe(float paramFloat)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(33317);
    NewChattingTabUI localNewChattingTabUI;
    boolean bool;
    if (this.ODT)
    {
      localNewChattingTabUI = this.chattingTabUI;
      if ((localNewChattingTabUI.OJE == null) || (!localNewChattingTabUI.OJE.gHZ())) {
        break label108;
      }
      bool = true;
      Log.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", new Object[] { Float.valueOf(paramFloat), Long.valueOf(260L), Boolean.valueOf(bool) });
      if (localNewChattingTabUI.gJv()) {
        break label114;
      }
    }
    for (;;)
    {
      if (i == 0) {
        super.onSwipe(paramFloat);
      }
      AppMethodBeat.o(33317);
      return;
      label108:
      bool = false;
      break;
      label114:
      Object localObject;
      if ((paramFloat == 0.0F) && (!localNewChattingTabUI.mChattingClosed))
      {
        localNewChattingTabUI.alj(0);
        localObject = (ImageView)localNewChattingTabUI.Dpx.getWindow().getDecorView().findViewById(2131306100);
        if (localObject != null)
        {
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE no cache!");
          ((ImageView)localObject).setVisibility(8);
          ((ImageView)localObject).setImageDrawable(null);
        }
        if (localNewChattingTabUI.mChattingInAnim != null) {
          localNewChattingTabUI.mChattingInAnim.cancel();
        }
      }
      for (;;)
      {
        if (!localNewChattingTabUI.OJE.gHZ())
        {
          if (Float.compare(1.0F, paramFloat) > 0)
          {
            Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Boolean.FALSE });
            i = 0;
            break;
            if ((paramFloat != 1.0F) || (localNewChattingTabUI.mChattingClosed) || (localNewChattingTabUI.OJN.gNe())) {
              continue;
            }
            localNewChattingTabUI.Dpx.getWindow().setBackgroundDrawableResource(2131101007);
            localObject = (ImageView)localNewChattingTabUI.Dpx.getWindow().getDecorView().findViewById(2131306100);
            if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0) && (((ImageView)localObject).getTag() != null))
            {
              ((View)((ImageView)localObject).getTag()).setVisibility(0);
              Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
              ((ImageView)localObject).setVisibility(8);
              ((ImageView)localObject).setVisibility(8);
            }
            if ((localNewChattingTabUI.OJN.getContentView() != null) && (localNewChattingTabUI.OJN.getContentView().getX() <= 0.0F))
            {
              localNewChattingTabUI.alj(8);
              continue;
            }
            localNewChattingTabUI.alj(0);
            continue;
          }
          j = 0;
        }
      }
      i = j;
      if (localNewChattingTabUI.Dpx != null)
      {
        localObject = localNewChattingTabUI.Dpx.findViewById(2131303052);
        ImageView localImageView = (ImageView)localNewChattingTabUI.Dpx.findViewById(2131306100);
        if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null) && (!localNewChattingTabUI.mChattingClosed) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
        {
          localImageView.setVisibility(0);
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
          localNewChattingTabUI.alj(8);
        }
        NewChattingTabUI.resetViewTranX((View)localObject, localImageView, paramFloat);
        i = j;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    Object localObject2 = null;
    AppMethodBeat.i(33326);
    Object localObject3 = this.chattingTabUI;
    Object localObject1 = localObject2;
    if (((NewChattingTabUI)localObject3).OJN != null)
    {
      localObject1 = localObject2;
      if (((NewChattingTabUI)localObject3).OJN.gNg() != null)
      {
        if (((NewChattingTabUI)localObject3).OJN.isSupportCustomActionBar()) {
          break label70;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.onWindowStartingActionMode(paramCallback);
      }
      AppMethodBeat.o(33326);
      return localObject2;
      label70:
      localObject1 = localObject2;
      if (!com.tencent.mm.compatible.util.d.oF(22))
      {
        localObject3 = ((NewChattingTabUI)localObject3).OJN.gNg().startActionMode(paramCallback);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject3;
        }
      }
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(232597);
    if ((paramIntent != null) && (paramIntent.getComponent() != null))
    {
      x localx = x.Qxl;
      x.bnV(paramIntent.getComponent().getClassName());
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(232597);
  }
  
  public final void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(33329);
    this.ODR.gHX();
    this.chattingTabUI.startChatting(paramString, paramBundle, paramBoolean);
    AppMethodBeat.o(33329);
  }
  
  static abstract interface a
  {
    public abstract boolean gIx();
  }
  
  static abstract interface b
  {
    public abstract void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup);
    
    public abstract boolean gHZ();
    
    public abstract void gIb();
    
    public abstract void gIc();
  }
  
  static abstract interface c
  {
    public abstract void gIa();
  }
  
  static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI
 * JD-Core Version:    0.7.0.1
 */