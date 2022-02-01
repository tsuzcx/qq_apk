package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
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
import android.os.SystemClock;
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
import com.tencent.mm.g.a.af;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.bf.b;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.ui.WelcomeActivity;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI;
import com.tencent.mm.pluginsdk.g.e.a;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.conversation.MainUI;
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
  extends MMFragmentActivity
{
  private static ArrayList<LauncherUI> Hle;
  private static ArrayList<WeakReference<LauncherUI>> Hlf;
  private static boolean Hlg;
  public static long Hlh;
  private static boolean Hli;
  private static boolean Hlp;
  public HomeUI Hlj;
  private n Hlk;
  public boolean Hll;
  boolean Hlm;
  private boolean Hln;
  private s Hlo;
  private boolean Hlq;
  private ao Hlr;
  private Runnable Hls;
  private boolean Hlt;
  int Hlu;
  private NewChattingTabUI chattingTabUI;
  private Intent dmw;
  
  static
  {
    AppMethodBeat.i(33334);
    Hle = new ArrayList();
    Hlf = new ArrayList();
    Hlg = true;
    Hli = false;
    Hlp = false;
    AppMethodBeat.o(33334);
  }
  
  public LauncherUI()
  {
    AppMethodBeat.i(33295);
    this.Hlj = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.Hlj);
    this.Hlk = new n();
    this.dmw = null;
    this.Hll = false;
    this.Hlm = false;
    this.Hln = false;
    this.Hlo = new s("MicroMsg.LauncherUI");
    this.Hlq = false;
    this.Hlr = new ao();
    this.Hls = new Runnable()
    {
      long fe = 2000L;
      
      @TargetApi(17)
      public final void run()
      {
        AppMethodBeat.i(33293);
        ac.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
        com.tencent.mm.sdk.platformtools.ap.aB(this);
        if (com.tencent.mm.model.az.ayN())
        {
          com.tencent.mm.kernel.g.agP();
          ac.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()) });
          AppMethodBeat.o(33293);
          return;
        }
        if ((com.tencent.mm.modelstat.d.aIs()) || (com.tencent.mm.sdk.a.b.foreground))
        {
          this.fe += 2000L;
          if (this.fe > 10000L) {
            this.fe = 2000L;
          }
          ac.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelstat.d.aIs()), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground), Long.valueOf(this.fe) });
          com.tencent.mm.sdk.platformtools.ap.n(this, this.fe);
          AppMethodBeat.o(33293);
          return;
        }
        ac.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit!!!");
        if (WXHardCoderJNI.isCheckEnv()) {
          com.tencent.mm.sdk.g.b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33292);
              WXHardCoderJNI.terminateApp(Process.myTid(), SystemClock.elapsedRealtimeNanos());
              ac.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp done");
              AppMethodBeat.o(33292);
            }
          }, "terminateApp");
        }
        ac.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit app done");
        AppMethodBeat.o(33293);
      }
    };
    this.Hlt = false;
    this.Hlu = 0;
    AppMethodBeat.o(33295);
  }
  
  private void bj(Intent paramIntent)
  {
    AppMethodBeat.i(33307);
    ac.i("MicroMsg.LauncherUI", "handleJump");
    if (!com.tencent.mm.model.az.agM())
    {
      ac.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
      paramIntent = new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(33307);
      return;
    }
    Object localObject1 = new kr();
    ((kr)localObject1).dmv.dmw = this.dmw;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    if ("talkroom_notification".equals(x.getStringExtra(paramIntent, "nofification_type")))
    {
      paramIntent = x.getStringExtra(paramIntent, "enter_chat_usrname");
      if (!bs.isNullOrNil(paramIntent))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enter_room_username", paramIntent);
        ((Intent)localObject1).setFlags(268435456);
        com.tencent.mm.br.d.b(this, "talkroom", ".ui.TalkRoomUI", (Intent)localObject1);
      }
      AppMethodBeat.o(33307);
      return;
    }
    if ("back_to_pcmgr_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      if (!paramIntent.getBooleanExtra("newPCBackup", true)) {
        ac.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BakToPcUI");
      }
      for (paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");; paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI"))
      {
        paramIntent.setFlags(268435456);
        MMWizardActivity.aj(this, paramIntent);
        AppMethodBeat.o(33307);
        return;
        ac.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
      }
    }
    if ("back_to_pcmgr_error_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.aj(this, paramIntent);
      AppMethodBeat.o(33307);
      return;
    }
    if ("clear_msg_not_finish_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      com.tencent.mm.ui.base.h.l(this, 2131757416, 2131755906);
      AppMethodBeat.o(33307);
      return;
    }
    if ("backup_move_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.aj(this, paramIntent);
      AppMethodBeat.o(33307);
      return;
    }
    if (x.getBooleanExtra(paramIntent, "show_update_dialog", false)) {
      bk(paramIntent);
    }
    String str = x.getStringExtra(paramIntent, "Main_User");
    localObject1 = x.getStringExtra(paramIntent, "nofification_type");
    ac.i("MicroMsg.LauncherUI", "[handleJump] user:%s", new Object[] { str });
    Object localObject2;
    int i;
    if ((str != null) && (!str.equals("")))
    {
      com.tencent.mm.model.az.ayM();
      localObject2 = com.tencent.mm.model.c.awG().aNI(str);
      if (localObject2 != null)
      {
        i = ((com.tencent.mm.g.c.az)localObject2).field_unReadCount;
        ac.i("MicroMsg.LauncherUI", "[oneliang] user:%s, conversation :%s, unReadCount:%s", new Object[] { str, localObject2, Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0) {
        j = x.getIntExtra(paramIntent, "pushcontent_unread_count", 0);
      }
      MMAppMgr.Lm();
      com.tencent.mm.sdk.b.a.GpY.l(new af());
      boolean bool = x.getBooleanExtra(paramIntent, "Intro_Is_Muti_Talker", true);
      ac.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((!bool) && (j > 0))
      {
        i = x.getIntExtra(paramIntent, "Intro_Bottle_unread_count", 0);
        if (i > 0)
        {
          ac.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.br.d.N(this, "bottle", ".ui.BottleConversationUI");
        }
      }
      if (!bool)
      {
        if (w.wX(str))
        {
          ac.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("type", 20);
          com.tencent.mm.br.d.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
        }
        for (;;)
        {
          if (x.getIntExtra(paramIntent, "kstyle_show_bind_mobile_afterauth", 0) > 0)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMobileUI");
            ((Intent)localObject1).putExtra("kstyle_bind_recommend_show", paramIntent.getIntExtra("kstyle_bind_recommend_show", 0));
            ((Intent)localObject1).putExtra("kstyle_bind_wording", paramIntent.getParcelableExtra("kstyle_bind_wording"));
            MMWizardActivity.aj(this, (Intent)localObject1);
          }
          AppMethodBeat.o(33307);
          return;
          if (!w.xf(str)) {
            break;
          }
          ac.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("type", 11);
          com.tencent.mm.br.d.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
        }
        if (paramIntent.getIntExtra("MainUI_User_Last_Msg_Type", 34) != 34) {
          break label1560;
        }
      }
      label1549:
      label1560:
      for (i = 2;; i = 1)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("Chat_Mode", i);
        if ("new_msg_nofification".equals(x.getStringExtra(paramIntent, "nofification_type")))
        {
          ((Bundle)localObject1).putInt("chat_from_scene", 1);
          ((Bundle)localObject1).putBoolean("key_can_show_message_float_ball", true);
        }
        localObject2 = getInstance();
        if (localObject2 == null) {
          break;
        }
        if (com.tencent.mm.al.f.so(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("biz_chat_from_scene", 4);
          com.tencent.mm.br.d.e(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if (com.tencent.mm.al.f.AS(str))
        {
          localObject1 = com.tencent.mm.al.f.dX(str);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).IR())
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
            com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramIntent);
            break;
          }
        }
        if (com.tencent.mm.storage.ai.vC(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("app_brand_conversation_from_scene", 3);
          paramIntent.putExtra("finish_direct", true);
          paramIntent.putExtra("key_need_send_video", false);
          com.tencent.mm.br.d.e(this, ".ui.conversation.AppBrandServiceConversationUI", paramIntent);
          break;
        }
        ((LauncherUI)localObject2).startChatting(str, (Bundle)localObject1, false);
        break;
        if (x.getBooleanExtra(paramIntent, "From_fail_notify", false))
        {
          if (!bs.isNullOrNil(str))
          {
            localObject1 = getInstance();
            if (localObject1 == null) {
              break;
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putBoolean("Chat_Mode", x.getBooleanExtra(paramIntent, "resend_fail_messages", false));
            if (com.tencent.mm.al.f.so(str))
            {
              paramIntent.putExtra("Contact_User", str);
              paramIntent.addFlags(67108864);
              paramIntent.putExtra("biz_chat_from_scene", 4);
              com.tencent.mm.br.d.e(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
              break;
            }
            ((LauncherUI)localObject1).startChatting(str, (Bundle)localObject2, false);
            break;
          }
          if (!x.getBooleanExtra(paramIntent, "jump_sns_from_notify", false)) {
            break;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("is_need_resend_sns", paramIntent.getBooleanExtra("is_need_resend_sns", false));
          ((Intent)localObject1).putExtra("sns_resume_state", paramIntent.getBooleanExtra("sns_resume_state", false));
          ((Intent)localObject1).putExtra("sns_timeline_NeedFirstLoadint", paramIntent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
          com.tencent.mm.br.d.b(this, "sns", ".ui.SnsTimeLineUI", (Intent)localObject1);
          break;
        }
        if (x.getBooleanExtra(paramIntent, "biz_chat_need_to_jump_to_chatting_ui", false))
        {
          if ((getInstance() == null) || (!com.tencent.mm.al.f.so(str))) {
            break;
          }
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          com.tencent.mm.br.d.e(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if ((bs.isNullOrNil(str)) || (!"new_msg_nofification".equals(localObject1))) {
          break;
        }
        if (paramIntent == null) {}
        for (localObject1 = "null";; localObject1 = paramIntent)
        {
          ac.w("MicroMsg.LauncherUI", "[handleJump] intent:%s", new Object[] { localObject1 });
          localObject1 = getInstance();
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("chat_from_scene", 1);
          ((Bundle)localObject2).putBoolean("key_can_show_message_float_ball", true);
          if (localObject1 == null) {
            break label1549;
          }
          ((LauncherUI)localObject1).startChatting(str, (Bundle)localObject2, false);
          break;
        }
        ac.w("MicroMsg.LauncherUI", "LauncherUI.getInstance is null! ");
        break;
      }
      i = 0;
      break;
      i = 0;
    }
  }
  
  private void bk(Intent paramIntent)
  {
    AppMethodBeat.i(33315);
    int i = x.getIntExtra(paramIntent, "update_type", -1);
    if (i == -1)
    {
      ac.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
      AppMethodBeat.o(33315);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(405L, 28L, 1L, true);
    com.tencent.mm.plugin.report.service.h localh;
    if (com.tencent.mm.plugin.q.d.dfa() != null)
    {
      paramIntent = com.tencent.mm.plugin.q.d.dfa().c(this, null);
      if (paramIntent == null)
      {
        AppMethodBeat.o(33315);
        return;
      }
      localh = com.tencent.mm.plugin.report.service.h.wUl;
      if (i != 2) {
        break label116;
      }
    }
    label116:
    for (long l = 29L;; l = 30L)
    {
      localh.idkeyStat(405L, l, 1L, true);
      paramIntent.update(i);
      AppMethodBeat.o(33315);
      return;
    }
  }
  
  private void fgn()
  {
    AppMethodBeat.i(33298);
    int i = Hle.indexOf(this);
    if (i >= 0) {
      Hle.remove(i);
    }
    ac.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(Hle.size()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(33298);
  }
  
  private void fgo()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33300);
    ac.d("MicroMsg.LauncherUI", "[whatsnew] checkIfStartWhatsNew.");
    if (Hlp)
    {
      ac.i("MicroMsg.LauncherUI", "[whatsnew] has been played.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!com.tencent.mm.kernel.g.agP().afY())
    {
      com.tencent.mm.kernel.g.agP();
      if (!com.tencent.mm.kernel.a.afX())
      {
        ac.i("MicroMsg.LauncherUI", "[whatsnew] not login yet, skip.");
        AppMethodBeat.o(33300);
        return;
      }
      ac.i("MicroMsg.LauncherUI", "[whatsnew] account not initiate, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!fgp())
    {
      ac.i("MicroMsg.LauncherUI", "[whatsnew] notSwitchOrHold is false, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    boolean bool3 = x.getBooleanExtra(getIntent(), "LauncherUI.enter_from_reg", false);
    boolean bool4;
    boolean bool1;
    if ((!bool3) && (com.tencent.mm.pluginsdk.g.e.DjW != null) && (com.tencent.mm.pluginsdk.g.e.DjW.Lw()) && (com.tencent.mm.model.az.agM()))
    {
      if (com.tencent.mm.sdk.platformtools.am.aKO("show_whatsnew"))
      {
        Hlp = true;
        ac.i("MicroMsg.LauncherUI", "[whatsnew] show whatsnew.");
        MMAppMgr.bc(this);
        com.tencent.mm.blink.a.TM();
        AppMethodBeat.o(33300);
      }
    }
    else
    {
      e.a locala = com.tencent.mm.pluginsdk.g.e.DjW;
      bool4 = com.tencent.mm.model.az.agM();
      if (locala != null) {
        break label262;
      }
      bool1 = true;
      if ((locala == null) || (!locala.Lw())) {
        break label267;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.LauncherUI", "[whatsnew] do not show whatsnew. enter_from_reg=%s accHasReady=%s MMAppMgr is null %s isWhatsNewAvailable=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      AppMethodBeat.o(33300);
      return;
      label262:
      bool1 = false;
      break;
      label267:
      bool2 = false;
    }
  }
  
  private boolean fgp()
  {
    AppMethodBeat.i(33304);
    if ((this.dmw != null) && (!x.getBooleanExtra(this.dmw, "Intro_Switch", false)) && (com.tencent.mm.model.az.ayN()) && (!com.tencent.mm.model.az.afS()))
    {
      AppMethodBeat.o(33304);
      return true;
    }
    AppMethodBeat.o(33304);
    return false;
  }
  
  private boolean fgq()
  {
    AppMethodBeat.i(33305);
    if (this.dmw != null)
    {
      if ((x.getBooleanExtra(this.dmw, "absolutely_exit", false)) || (x.getIntExtra(this.dmw, "absolutely_exit_pid", 0) == Process.myPid()))
      {
        ac.w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        finish();
        com.tencent.mm.plugin.report.service.g.MJ(8);
        MMAppMgr.wA(x.getBooleanExtra(this.dmw, "kill_service", true));
        System.exit(0);
        AppMethodBeat.o(33305);
        return true;
      }
      if (x.getBooleanExtra(this.dmw, "can_finish", false))
      {
        ac.i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
        com.tencent.mm.model.az.agi().eB(true);
        if (com.tencent.mm.kernel.l.cp(getApplicationContext())) {
          com.tencent.mm.booter.b.bI(getApplicationContext());
        }
        com.tencent.mm.plugin.report.service.g.MJ(8);
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), "com.tencent.mm.permission.MM_MESSAGE");
        finish();
        com.tencent.mm.ui.base.b.jT(this);
        AppMethodBeat.o(33305);
        return true;
      }
      if (x.getBooleanExtra(this.dmw, "exit_and_restart", false))
      {
        Mars.onSingalCrash(0);
        ac.i("MicroMsg.LauncherUI", "exit and restart myself.");
        ac.eUQ();
        finish();
        Object localObject = new Intent(this, LauncherUI.class);
        ((Intent)localObject).addFlags(67108864);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ac.i("MicroMsg.LauncherUI", "restart, try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        MMAppMgr.fgM();
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(33305);
        return true;
      }
    }
    AppMethodBeat.o(33305);
    return false;
  }
  
  private void fgr()
  {
    AppMethodBeat.i(33306);
    ac.i("MicroMsg.LauncherUI", "switch to wxid %s", new Object[] { com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "") });
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).addFlags(536870912);
    ((Intent)localObject).putExtra("key_scene", 1);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.jU(this);
    AppMethodBeat.o(33306);
  }
  
  private void fgs()
  {
    AppMethodBeat.i(33308);
    ac.i("MicroMsg.LauncherUI", "resumeLogoutJump");
    if ((this.dmw != null) && (x.getBooleanExtra(getIntent(), "LauncherUI.jump_from_uimode_check", false)))
    {
      ac.i("MicroMsg.LauncherUI", "dancy uimode check from background, not jumpToLogin or welcome!");
      AppMethodBeat.o(33308);
      return;
    }
    MMFragmentActivity.a.fgN();
    Object localObject = ay.hnA.aw("login_user_name", "");
    if ((!com.tencent.mm.model.az.ayN()) && (((String)localObject).equals("")))
    {
      localObject = new Intent(this, WelcomeActivity.class);
      ((Intent)localObject).addFlags(536870912);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jU(this);
      ac.i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
      com.tencent.mm.sdk.platformtools.ap.aB(this.Hls);
      com.tencent.mm.sdk.platformtools.ap.n(this.Hls, 2000L);
      AppMethodBeat.o(33308);
      return;
    }
    if ((this.dmw.getFlags() & 0x4000000) == 67108864) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = x.getBooleanExtra(this.dmw, "Intro_Notify", false);
      ac.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", new Object[] { Boolean.valueOf(this.Hll), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(com.tencent.mm.model.az.afS()) });
      ac.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", new Object[] { Boolean.valueOf(com.tencent.mm.model.az.ayN()) });
      com.tencent.mm.model.az.hold();
      if (x.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
        this.Hln = true;
      }
      ju(this);
      com.tencent.mm.model.az.unhold();
      AppMethodBeat.o(33308);
      return;
    }
  }
  
  public static int getCurrentTabIndex()
  {
    AppMethodBeat.i(33297);
    if ((getInstance() != null) && (getInstance().getHomeUI() != null) && (getInstance().getHomeUI().getMainTabUI() != null))
    {
      int i = getInstance().getHomeUI().getMainTabUI().aaj;
      AppMethodBeat.o(33297);
      return i;
    }
    AppMethodBeat.o(33297);
    return -1;
  }
  
  public static LauncherUI getInstance()
  {
    AppMethodBeat.i(33296);
    if (Hle.isEmpty())
    {
      ac.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", new Object[] { bs.eWi() });
      AppMethodBeat.o(33296);
      return null;
    }
    LauncherUI localLauncherUI = (LauncherUI)Hle.get(0);
    AppMethodBeat.o(33296);
    return localLauncherUI;
  }
  
  private void ju(Context paramContext)
  {
    AppMethodBeat.i(33309);
    if (x.getBooleanExtra(this.dmw, "LauncherUI.jump_switch_account", false))
    {
      ac.i("MicroMsg.LauncherUI", "launcher to switch account");
      fgr();
      AppMethodBeat.o(33309);
      return;
    }
    if ((x.getBooleanExtra(this.dmw, "Intro_Switch", false)) || (this.Hll) || (com.tencent.mm.kernel.a.afH()))
    {
      this.Hlj.getMainTabUI().bMp();
      com.tencent.mm.kernel.g.agS().uj("[normal logout]");
      Mars.onSingalCrash(0);
      ac.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
      ac.eUQ();
      finish();
      Object localObject = new Intent(paramContext, LauncherUI.class);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ac.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
      MMAppMgr.fgM();
      Process.killProcess(Process.myPid());
      AppMethodBeat.o(33309);
      return;
    }
    if (!x.getBooleanExtra(this.dmw, "LauncherUI.jump_switch_account", false))
    {
      paramContext = ay.hnA.aw("login_user_name", "");
      ac.i("MicroMsg.LauncherUI", "%s jumpToLogin", new Object[] { paramContext });
      if (!bs.isNullOrNil(paramContext)) {
        break label387;
      }
      paramContext = new Intent(this, WelcomeActivity.class);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().ba(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.aeD(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jU(this);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.MJ(8);
      com.tencent.mm.sdk.platformtools.ap.aB(this.Hls);
      com.tencent.mm.sdk.platformtools.ap.n(this.Hls, 2000L);
      AppMethodBeat.o(33309);
      return;
      label387:
      boolean bool = com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false);
      ac.i("MicroMsg.LauncherUI", "switchAccount %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      paramContext = new Intent(this, SettingsSwitchAccountUI.class);
      paramContext.addFlags(536870912);
      paramContext.putExtra("key_scene", 2);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().ba(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.aeD(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jR(this);
    }
    int i = bs.aLy(ay.hnA.aw("last_login_use_voice", ""));
    ac.i("MicroMsg.LauncherUI", "pluginSwitch  ".concat(String.valueOf(i)));
    paramContext = new Intent();
    if ((i & 0x20000) != 0) {
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginVoiceUI");
    }
    for (;;)
    {
      paramContext.addFlags(536870912);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().ba(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.aeD(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jR(this);
      break;
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginPasswordUI");
    }
  }
  
  public static void jv(Context paramContext)
  {
    AppMethodBeat.i(33328);
    Object localObject = new Intent(paramContext, LauncherUI.class);
    ((Intent)localObject).addFlags(67108864);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33328);
  }
  
  private void wx(boolean paramBoolean)
  {
    AppMethodBeat.i(33302);
    if (paramBoolean)
    {
      new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33291);
          LauncherUI.a(LauncherUI.this);
          AppMethodBeat.o(33291);
        }
      };
      n.fgv();
    }
    for (paramBoolean = false;; paramBoolean = true)
    {
      this.Hlq = paramBoolean;
      do
      {
        AppMethodBeat.o(33302);
        return;
      } while (this.Hlq);
      if (this.Hlk.aX(this)) {
        break;
      }
    }
  }
  
  public final void closeChatting(boolean paramBoolean)
  {
    AppMethodBeat.i(33330);
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33294);
        LauncherUI.this.Hlj.getMainTabUI().fgU();
        AppMethodBeat.o(33294);
      }
    };
    if (this.chattingTabUI.wH(paramBoolean))
    {
      this.Hlj.wu(this.chattingTabUI.Hra.isSupportCustomActionBar());
      this.Hlj.getMainTabUI().fgX();
    }
    AppMethodBeat.o(33330);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33319);
    boolean bool;
    if (this.chattingTabUI.fgt())
    {
      NewChattingTabUI localNewChattingTabUI = this.chattingTabUI;
      if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
        com.tencent.mm.sdk.platformtools.ap.aB(localNewChattingTabUI.mStartChattingRunnable);
      }
      if (localNewChattingTabUI.isAnimating) {}
      for (bool = true; bool; bool = localNewChattingTabUI.Hra.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent))
      {
        AppMethodBeat.o(33319);
        return true;
      }
    }
    if (this.Hlj.dispatchKeyEvent(paramKeyEvent))
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
      ac.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", new Object[] { paramKeyEvent.getMessage() });
      ac.printErrStackTrace("MicroMsg.LauncherUI", paramKeyEvent, "", new Object[0]);
      AppMethodBeat.o(33319);
    }
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(33316);
    super.finish();
    fgn();
    ac.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(Hle.size()), bs.eWi() });
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
    for (localObject1 = ((NewChattingTabUI)localObject1).Hra;; localObject1 = null)
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
    return this.Hlj;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str1 = null;
    Object localObject1 = null;
    AppMethodBeat.i(33310);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.v("MicroMsg.LauncherUI", "edw on activity result");
    Object localObject2 = this.chattingTabUI;
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 226) || (paramInt1 == 30762) || (paramInt1 == 1111)) && (((NewChattingTabUI)localObject2).Hra != null)) {
      ((NewChattingTabUI)localObject2).Hra.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((NewChattingTabUI.acceptRequestCode(paramInt1)) && (((NewChattingTabUI)localObject2).Hra == null))
    {
      ac.i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
      com.tencent.mm.sdk.platformtools.ap.aB(((NewChattingTabUI)localObject2).Hrc);
      ((NewChattingTabUI)localObject2).Hrc.Hrl = 0;
      ((NewChattingTabUI)localObject2).Hrc.requestCode = paramInt1;
      ((NewChattingTabUI)localObject2).Hrc.bPH = paramInt2;
      ((NewChattingTabUI)localObject2).Hrc.dlL = paramIntent;
      com.tencent.mm.sdk.platformtools.ap.f(((NewChattingTabUI)localObject2).Hrc);
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(33310);
      return;
    }
    localObject2 = this.Hlj;
    if (((HomeUI)localObject2).HjQ)
    {
      if (paramInt1 == 1)
      {
        com.tencent.mm.model.az.ayM();
        if (!bs.l((Boolean)com.tencent.mm.model.c.agA().get(12323, null))) {
          y.showAddrBookUploadConfirm(((HomeUI)localObject2).Hjt, null, false, 3);
        }
        AppMethodBeat.o(33310);
        return;
      }
      if (paramInt1 == 22722)
      {
        str1 = (String)com.tencent.mm.kernel.g.agR().agA().get(274436, null);
        ac.i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
        if (paramIntent != null) {
          localObject1 = paramIntent.getBundleExtra("result_data");
        }
        if ((localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("agree_privacy")))
        {
          ac.i("MicroMsg.LauncherUI.HomeUI", "agree privacy policy");
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(712L, 4L, 1L, false);
          localObject1 = new com.tencent.mm.plugin.account.model.g(1, str1);
          com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject1, 0);
          if ((com.tencent.mm.aw.b.CQ(str1)) && (com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GRb, false)))
          {
            ac.i("MicroMsg.LauncherUI.HomeUI", "needbirthday true");
            com.tencent.mm.sdk.platformtools.ap.n(new HomeUI.24((HomeUI)localObject2), 100L);
          }
        }
      }
      while ((paramInt1 == 65534) && (paramInt2 == -1))
      {
        com.tencent.mm.sdk.platformtools.am.aKP("welcome_page_show");
        com.tencent.mm.kernel.l.o(((HomeUI)localObject2).Hjt, true);
        MMAppMgr.Lm();
        MMAppMgr.m(((HomeUI)localObject2).Hjt, true);
        ((HomeUI)localObject2).Hjt.finish();
        AppMethodBeat.o(33310);
        return;
        ac.i("MicroMsg.LauncherUI.HomeUI", "disagree privacy policy");
        localObject1 = new com.tencent.mm.plugin.account.model.g(2, str1);
        com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(712L, 5L, 1L, false);
        continue;
        if (paramInt1 == 22723)
        {
          String str2 = (String)com.tencent.mm.kernel.g.agR().agA().get(274436, null);
          localObject1 = str1;
          if (paramIntent != null) {
            localObject1 = paramIntent.getBundleExtra("result_data");
          }
          if (localObject1 != null) {
            if (((Bundle)localObject1).getString("go_next", "").equals("birthdayComfirmOK"))
            {
              ac.i("MicroMsg.LauncherUI.HomeUI", "verify birthday ok");
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRb, Boolean.FALSE);
            }
            else if (((Bundle)localObject1).getString("go_next", "").equals("gdpr_confirm_logout"))
            {
              ac.i("MicroMsg.LauncherUI.HomeUI", "quit verify birthday after H5-warnning");
              localObject1 = new com.tencent.mm.plugin.account.model.g(2, str2);
              com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject1, 0);
              com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(712L, 5L, 1L, false);
            }
          }
        }
      }
      if ((paramInt1 == 30764) && (paramIntent != null))
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRN, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b(((HomeUI)localObject2).Hjt, "android.permission.ACCESS_COARSE_LOCATION", 66);
        }
      }
    }
    AppMethodBeat.o(33310);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(33320);
    ac.i("MicroMsg.LauncherUI", "onBackPressed");
    Object localObject = new Intent("android.intent.action.MAIN");
    ((Intent)localObject).addCategory("android.intent.category.HOME");
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/LauncherUI", "onBackPressed", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "onBackPressed", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33320);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(33325);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.Hlj;
    com.tencent.mm.pluginsdk.g.b(paramConfiguration.Hjt, paramConfiguration.contentView);
    AppMethodBeat.o(33325);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33299);
    com.tencent.mm.blink.a.oD(com.tencent.mm.kernel.h.agV().gix);
    if (aj.DT()) {
      setTheme(2131820569);
    }
    long l1;
    long l2;
    int i;
    boolean bool1;
    for (;;)
    {
      l1 = System.currentTimeMillis();
      ac.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bs.jb(this) });
      super.onCreate(paramBundle);
      MainProcessChecker.apn(getClass().getName());
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
        if (x.getBooleanExtra(paramBundle, "absolutely_exit", false))
        {
          bool1 = true;
          ac.i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
        }
      }
      paramBundle = Hlf.iterator();
      while (paramBundle.hasNext())
      {
        localObject1 = (LauncherUI)((WeakReference)paramBundle.next()).get();
        if (localObject1 != null) {
          ac.i("MicroMsg.LauncherUI", "Check launcher instance found one %s", new Object[] { localObject1 });
        }
      }
      setTheme(2131820574);
    }
    Object localObject1 = null;
    paramBundle = null;
    Object localObject3;
    if (!bool1)
    {
      localObject3 = Hle.iterator();
      localObject1 = paramBundle;
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (LauncherUI)((Iterator)localObject3).next();
        if (((LauncherUI)localObject1).getTaskId() != i)
        {
          ac.i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", new Object[] { Integer.valueOf(localObject1.hashCode()), Integer.valueOf(((LauncherUI)localObject1).getTaskId()), Integer.valueOf(i) });
          paramBundle = bs.aG(this, i);
          if (paramBundle != null)
          {
            ac.i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), paramBundle.topActivity.getClassName(), paramBundle.baseActivity.getClassName(), Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
            if (paramBundle.baseActivity.getPackageName().equals(localObject2)) {
              break label589;
            }
            ac.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + paramBundle.baseActivity.getPackageName());
            finish();
            if (bs.aG(this, ((LauncherUI)localObject1).getTaskId()) != null)
            {
              ac.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
              paramBundle = new Intent(this, LauncherUI.class);
              paramBundle.addFlags(268435456);
              paramBundle = new com.tencent.mm.hellhoundlib.b.a().ba(paramBundle);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.aeD(), "com/tencent/mm/ui/LauncherUI", "checkInstance", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramBundle.lR(0));
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
        ac.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
        AppMethodBeat.o(33299);
        return;
        ac.e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", new Object[] { Integer.valueOf(i) });
        finish();
        i = 0;
        continue;
        label589:
        ((LauncherUI)localObject1).finish();
        Hle.remove(localObject1);
        break;
        if (!Hle.isEmpty())
        {
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = bs.aG(this, i);
          }
          if (paramBundle == null) {
            break label887;
          }
          localObject1 = paramBundle.baseActivity.getClassName();
          localObject2 = paramBundle.baseActivity.getClassName();
          ac.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), localObject2, localObject1, Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
          localObject3 = getComponentName().getClassName();
          if ((paramBundle.numActivities > 1) && (((String)localObject3).equals(localObject1)) && (((String)localObject3).equals(localObject2)))
          {
            finish();
            ac.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(Hle.size()) });
            i = 0;
            continue;
          }
          ac.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", new Object[] { Integer.valueOf(Hle.size()), Boolean.valueOf(bool1) });
          Hle.clear();
        }
        for (;;)
        {
          Hle.add(this);
          Hlf.add(new WeakReference(this));
          ac.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d weak check %d, use time %d", new Object[] { Integer.valueOf(Hle.size()), Integer.valueOf(Hlf.size()), Long.valueOf(System.currentTimeMillis() - l2) });
          i = 1;
          break;
          label887:
          ac.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Hle.size()) });
          Hle.clear();
        }
      }
    }
    if ((getIntent() != null) && (x.getBooleanExtra(getIntent(), "LauncherUI.jump_from_uimode_check", false)))
    {
      ac.i("MicroMsg.LauncherUI", "dancy onCreate uimode check from background, finish LauncherUI");
      finish();
      AppMethodBeat.o(33299);
      return;
    }
    ac.i("MicroMsg.LauncherUI", "onCreate normally");
    this.Hlj = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.Hlj);
    this.chattingTabUI.mvz = this;
    paramBundle = this.Hlj;
    localObject1 = this.chattingTabUI;
    paramBundle.Hjt = this;
    paramBundle.Hki = ((a)localObject1);
    localObject1 = paramBundle.Hkk;
    ((MainTabUI)localObject1).Hjt = this;
    ((MainTabUI)localObject1).Hpq = paramBundle;
    Object localObject2 = ((MainTabUI)localObject1).Hpp;
    ((aa)localObject2).Hjt = this;
    ((aa)localObject2).HpD = paramBundle;
    ((MainTabUI)localObject1).mtS = paramBundle;
    paramBundle.Hkj = new h(this, paramBundle);
    NotifyReceiver.Uq();
    com.tencent.mm.pluginsdk.g.aN(paramBundle.Hjt);
    paramBundle.mActionBar = getSupportActionBar();
    paramBundle.vJh = findViewById(2131296345);
    if (paramBundle.mActionBar != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131099879)));
      }
      paramBundle.mActionBar.hide();
    }
    setRequestedOrientation(1);
    paramBundle.Hkl = getResources().getColor(2131100705);
    paramBundle.Hkm = Color.alpha(paramBundle.Hkl);
    paramBundle = ay.hnA.aw("login_user_name", "");
    this.dmw = getIntent();
    localObject1 = this.Hlo;
    ((s)localObject1).DfL = this.dmw.getBooleanExtra("splash-hack-activity-recreate", false);
    ac.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", new Object[] { ((s)localObject1).mTag, Boolean.valueOf(((s)localObject1).DfL) });
    ac.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", new Object[] { paramBundle, Boolean.valueOf(com.tencent.mm.model.az.ayN()), Boolean.valueOf(Hlg) });
    if (fgq())
    {
      ac.i("MicroMsg.LauncherUI", "handleExitIntent return");
      AppMethodBeat.o(33299);
      return;
    }
    if ((!Hlg) && ((com.tencent.mm.model.az.ayN()) || (!paramBundle.equals(""))))
    {
      Hlh = l1;
      ac.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.d.cIh));
    }
    label1608:
    for (;;)
    {
      com.tencent.mm.pluginsdk.model.app.q.j(this, "");
      fgo();
      aj.aG(this);
      if (com.tencent.mm.sdk.platformtools.h.IS_UAT) {
        break;
      }
      ac.d("MicroMsg.LauncherUI", "is_uat false! savePayUATTestId return");
      AppMethodBeat.o(33299);
      return;
      Hlh = l1;
      ac.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.d.cIh));
      setRequestedOrientation(1);
      bool1 = com.tencent.mm.model.az.ayN();
      paramBundle = ay.hnA.aw("login_user_name", "");
      if ((!bool1) && (paramBundle.equals(""))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1502;
        }
        com.tencent.mm.sdk.platformtools.i.GqK = false;
        break;
      }
      label1502:
      bool1 = false;
      if ((com.tencent.mm.sdk.platformtools.i.GqL) && (com.tencent.mm.sdk.platformtools.i.GqK))
      {
        Hli = true;
        bool1 = MMAppMgr.a(this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33290);
            LauncherUI.a(LauncherUI.this);
            LauncherUI.aWD();
            com.tencent.mm.pluginsdk.h.a.a.o.bHP();
            LauncherUI.b(LauncherUI.this);
            AppMethodBeat.o(33290);
          }
        });
      }
      for (;;)
      {
        if (bool1) {
          break label1608;
        }
        wx(true);
        Hli = false;
        com.tencent.mm.pluginsdk.h.a.a.o.bHP();
        com.tencent.mm.plugin.report.service.g.MJ(8);
        fgs();
        ac.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        com.tencent.mm.sdk.platformtools.ap.aB(this.Hls);
        com.tencent.mm.sdk.platformtools.ap.n(this.Hls, 2000L);
        break;
        MMAppMgr.jB(this);
      }
    }
    if (!com.tencent.mm.kernel.g.agP().afY())
    {
      ac.w("MicroMsg.LauncherUI", "account has not init! savePayUATTestId return");
      AppMethodBeat.o(33299);
      return;
    }
    if ((this.dmw != null) && (this.dmw.getExtras() != null))
    {
      paramBundle = this.dmw.getExtras().getString("uat_test_id");
      com.tencent.mm.kernel.g.agR().agA().set(352280, paramBundle);
      ac.i("MicroMsg.LauncherUI", "UAT test id has save!, test_id: ".concat(String.valueOf(paramBundle)));
    }
    AppMethodBeat.o(33299);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(33324);
    if (this.chattingTabUI.fgt())
    {
      AppMethodBeat.o(33324);
      return false;
    }
    HomeUI localHomeUI = this.Hlj;
    if ((localHomeUI.Hki == null) || (localHomeUI.Hki.fgt()))
    {
      AppMethodBeat.o(33324);
      return false;
    }
    localHomeUI.HkD = paramMenu;
    int i = localHomeUI.Hjt.getSupportActionBar().getHeight();
    int j = com.tencent.mm.cc.a.av(localHomeUI.Hjt, 2131165296);
    if ((localHomeUI.Hkk.aaj == 3) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()))
    {
      localHomeUI.HkC = paramMenu.add(0, 5, 0, 2131764454);
      if (localHomeUI.Hky == null)
      {
        com.tencent.mm.kiss.a.b.ahR();
        localHomeUI.Hky = com.tencent.mm.kiss.a.b.c(localHomeUI.Hjt, 2131492929);
        paramMenu = new ViewGroup.LayoutParams(j, i);
        localHomeUI.Hky.setLayoutParams(paramMenu);
        localHomeUI.Hky.setMinimumHeight(i);
        localHomeUI.Hky.setMinimumWidth(j);
        localHomeUI.Hky.setOnLongClickListener(new HomeUI.5(localHomeUI));
        localHomeUI.Hky.setOnClickListener(new HomeUI.6(localHomeUI));
      }
      if (localHomeUI.Hko)
      {
        localHomeUI.Hky.findViewById(2131305884).setVisibility(0);
        paramMenu = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.ys(1L);
      }
      for (;;)
      {
        localHomeUI.HkC.setActionView(localHomeUI.Hky);
        localHomeUI.ffY();
        localHomeUI.ffO();
        ac.v("MicroMsg.LauncherUI.HomeUI", "onCreateOptionsMenu");
        AppMethodBeat.o(33324);
        return true;
        localHomeUI.Hky.findViewById(2131305884).setVisibility(8);
        paramMenu = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.ys(0L);
      }
    }
    Object localObject;
    if (i == 0)
    {
      localObject = localHomeUI.Hjt.getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels) {
        i = localHomeUI.Hjt.getResources().getDimensionPixelSize(2131165251);
      }
    }
    for (;;)
    {
      localHomeUI.Hkz = paramMenu.add(0, HomeUI.Hkr, 0, 2131764452);
      localHomeUI.Hkz.setIcon(2131689494);
      if (localHomeUI.Hga) {
        localHomeUI.Hkz.setIcon(2131689501);
      }
      if (localHomeUI.Hgq == null)
      {
        localObject = new ViewGroup.LayoutParams(j, i);
        com.tencent.mm.kiss.a.b.ahR();
        localHomeUI.Hgq = com.tencent.mm.kiss.a.b.c(localHomeUI.Hjt, 2131492929);
        localHomeUI.Hkx = ((ImageView)localHomeUI.Hgq.findViewById(2131300874));
        localHomeUI.Hgq.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localHomeUI.Hgq.setMinimumHeight(i);
        localHomeUI.Hgq.setMinimumWidth(j);
        localHomeUI.Hkx.setImageResource(2131689494);
        localHomeUI.Hkx.setImageDrawable(am.e(localHomeUI.Hjt.getResources().getDrawable(2131689494), localHomeUI.Hjt.getResources().getColor(2131099732)));
        localHomeUI.Hgq.setContentDescription(localHomeUI.getString(2131764452));
        localHomeUI.Hgq.setOnLongClickListener(new HomeUI.7(localHomeUI));
        localHomeUI.Hgq.setOnClickListener(new HomeUI.8(localHomeUI));
        localHomeUI.Hgq.post(new HomeUI.9(localHomeUI));
      }
      localHomeUI.Hkz.setActionView(localHomeUI.Hgq);
      localHomeUI.HkA = paramMenu.add(0, HomeUI.Hks, 0, 2131764451);
      if (localHomeUI.Hku == null) {
        localHomeUI.Hkt = new HomeUI.b(localHomeUI, j, i);
      }
      if (com.tencent.mm.kernel.g.agP().afY()) {
        com.tencent.mm.plugin.newtips.a.dkb().h(localHomeUI.Hkt);
      }
      if ((localHomeUI.Hga) && (localHomeUI.Hkv != null)) {
        localHomeUI.Hkv.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      com.tencent.mm.blink.b.TR().w(new HomeUI.10(localHomeUI));
      localHomeUI.HkA.setActionView(localHomeUI.Hku);
      localHomeUI.ffO();
      localHomeUI.Hku.getLayoutParams().width = j;
      localHomeUI.Hku.getLayoutParams().height = i;
      break;
      i = localHomeUI.Hjt.getResources().getDimensionPixelSize(2131165252);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33314);
    com.tencent.mm.blink.a.TM();
    super.onDestroy();
    Object localObject = this.Hlj;
    ((HomeUI)localObject).Hkk.bMp();
    if (((HomeUI)localObject).Hkj != null)
    {
      h localh = ((HomeUI)localObject).Hkj;
      com.tencent.mm.sdk.b.a.GpY.d(localh.Hjz);
      com.tencent.mm.sdk.b.a.GpY.d(localh.HjA);
    }
    if (((HomeUI)localObject).HjQ) {
      Looper.myQueue().removeIdleHandler(((HomeUI)localObject).nEp);
    }
    localObject = this.chattingTabUI;
    if ((((NewChattingTabUI)localObject).mPrepareBitmap != null) && (!((NewChattingTabUI)localObject).mPrepareBitmap.isRecycled()))
    {
      ac.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", new Object[] { ((NewChattingTabUI)localObject).mPrepareBitmap.toString() });
      ((NewChattingTabUI)localObject).mPrepareBitmap.recycle();
    }
    com.tencent.mm.sdk.platformtools.ap.aB(((NewChattingTabUI)localObject).mStartChattingRunnable);
    Looper.myQueue().removeIdleHandler(((NewChattingTabUI)localObject).HqV);
    fgn();
    ac.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bs.jb(this), Integer.valueOf(Hle.size()) });
    AppMethodBeat.o(33314);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(33331);
    super.onMultiWindowModeChanged(paramBoolean);
    ac.i("MicroMsg.LauncherUI", "alvinluo onMultiWindowModeChanged2 isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    lu locallu = new lu();
    locallu.dnM.dnN = paramBoolean;
    com.tencent.mm.sdk.b.a.GpY.l(locallu);
    AppMethodBeat.o(33331);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(33301);
    ac.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", new Object[] { Integer.valueOf(hashCode()), bs.jb(this) });
    this.dmw = paramIntent;
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if ((this.dmw != null) && (x.getBooleanExtra(this.dmw, "LauncherUI.jump_from_uimode_check", false)))
    {
      ac.i("MicroMsg.LauncherUI", "dancy onNewIntent uimode check from background, finish LauncherUI");
      finish();
      AppMethodBeat.o(33301);
      return;
    }
    com.tencent.mm.pluginsdk.model.app.q.j(this, "");
    if (fgq())
    {
      ac.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
      AppMethodBeat.o(33301);
      return;
    }
    if ((this.dmw != null) && (x.getBooleanExtra(this.dmw, "Intro_Need_Clear_Top ", false)))
    {
      ac.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
      finish();
      jv(this);
      AppMethodBeat.o(33301);
      return;
    }
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      closeChatting(false);
    }
    MainTabUI localMainTabUI = this.Hlj.Hkk;
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      localMainTabUI.Hpr = true;
    }
    if (this.Hll)
    {
      ac.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
      bj(paramIntent);
    }
    AppMethodBeat.o(33301);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int j = 0;
    AppMethodBeat.i(33323);
    HomeUI localHomeUI = this.Hlj;
    Object localObject = localHomeUI.Hjt.getCurrentFragmet();
    int i;
    if ((localObject != null) && (((MMFragment)localObject).isShowing())) {
      i = j;
    }
    while (i != 0)
    {
      AppMethodBeat.o(33323);
      return true;
      i = j;
      if (!localHomeUI.Hki.fgt())
      {
        if (paramMenuItem.getItemId() == HomeUI.Hks)
        {
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(10919, "0");
          localHomeUI.ffN();
        }
        for (;;)
        {
          i = 1;
          break;
          if (paramMenuItem.getItemId() == HomeUI.Hkr)
          {
            localHomeUI.ffP();
          }
          else
          {
            i = j;
            if (paramMenuItem.getItemId() != 5) {
              break;
            }
            if ((com.tencent.mm.sdk.a.b.eUk()) || (ab.iwE))
            {
              localObject = new com.tencent.mm.ui.tools.l(localHomeUI.Hjt);
              ((com.tencent.mm.ui.tools.l)localObject).ISu = new HomeUI.11(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).ISv = new HomeUI.13(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).ftL();
            }
            else
            {
              localHomeUI.ffQ();
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
    ac.d("MicroMsg.LauncherUI", "onPause %s, chatting is show ", new Object[] { Integer.valueOf(hashCode()) });
    super.onPause();
    Object localObject1 = this.Hlo;
    boolean bool = ((s)localObject1).eb("onPause");
    if (bool) {
      ((s)localObject1).DfL = false;
    }
    if (bool)
    {
      ac.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
      AppMethodBeat.o(33311);
      return;
    }
    com.tencent.mm.blink.a.TM();
    ac.i("MicroMsg.LauncherUI", "not skip this onPause");
    localObject1 = getCurrentFragmet();
    this.Hlr.removeCallbacksAndMessages(null);
    Object localObject2 = this.Hlj;
    Object localObject3 = ((HomeUI)localObject2).Hkk;
    bool = ((HomeUI)localObject2).HjQ;
    ac.v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", new Object[] { Integer.valueOf(((MainTabUI)localObject3).aaj), Boolean.valueOf(bool) });
    if (bool) {
      ((MainTabUI)localObject3).fgR();
    }
    localObject3 = ((MainTabUI)localObject3).Hpp;
    if (com.tencent.mm.model.az.agM())
    {
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.agA().b(((aa)localObject3).HpJ);
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awG().b((n.b)localObject3);
      com.tencent.mm.y.c.aeH().b(((aa)localObject3).HpI);
      com.tencent.mm.sdk.b.a.GpY.d(((aa)localObject3).HpK);
      com.tencent.mm.sdk.b.a.GpY.d(((aa)localObject3).HiK);
      com.tencent.mm.sdk.b.a.GpY.d(((aa)localObject3).HiJ);
    }
    if (((aa)localObject3).HpH != null)
    {
      ((aa)localObject3).HpH.HpE = null;
      ((aa)localObject3).HpH = null;
    }
    localObject3 = ((HomeUI)localObject2).Hkj;
    if (((h)localObject3).Hjw != null)
    {
      com.tencent.mm.model.az.agi().b(255, ((h)localObject3).Hjw);
      com.tencent.mm.model.az.agi().b(384, ((h)localObject3).Hjw);
      ((h)localObject3).Hjw = null;
    }
    com.tencent.mm.sdk.a.b.eC(false);
    ((HomeUI)localObject2).Hkh = HomeUI.a.HkS;
    if (!com.tencent.mm.model.az.ayF()) {
      com.tencent.mm.model.az.getNotification().cx(false);
    }
    bool = ((HomeUI)localObject2).Hki.fgt();
    ac.i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show ".concat(String.valueOf(bool)));
    if (!bool) {
      j.a(((HomeUI)localObject2).Hjt, 4, ((HomeUI)localObject2).Hkk.aaj, "directReport_onPause");
    }
    if (!((HomeUI)localObject2).Hjt.isFinishing()) {
      com.tencent.mm.ui.widget.h.a(((HomeUI)localObject2).Hjt);
    }
    if (((HomeUI)localObject2).HjQ)
    {
      ac.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
      com.tencent.mm.blink.b.TR().TT();
      if (com.tencent.mm.model.az.agM()) {
        com.tencent.mm.sdk.b.a.GpY.d(((HomeUI)localObject2).xnS);
      }
    }
    if ((((HomeUI)localObject2).HjY != null) && (((HomeUI)localObject2).HjY.isShowing())) {
      ((HomeUI)localObject2).HjY.dismiss();
    }
    localObject2 = this.chattingTabUI;
    if (((NewChattingTabUI)localObject2).fgt())
    {
      ((NewChattingTabUI)localObject2).lA(4);
      if ((((NewChattingTabUI)localObject2).Hra != null) && (((NewChattingTabUI)localObject2).Hra.isSupportNavigationSwipeBack())) {
        ((NewChattingTabUI)localObject2).Hra.getSwipeBackLayout().setEnableGesture(false);
      }
    }
    if (localObject1 != null)
    {
      AppMethodBeat.o(33311);
      return;
    }
    this.Hlm = false;
    AppMethodBeat.o(33311);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(33313);
    this.Hlq = false;
    Object localObject;
    if (!this.Hlk.a(this, paramInt, paramArrayOfString, paramArrayOfInt))
    {
      localObject = this.Hlj;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      localObject = this.chattingTabUI;
      if (((NewChattingTabUI)localObject).Hra != null) {
        ((NewChattingTabUI)localObject).Hra.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(33313);
      return;
      if (paramInt == 80) {}
      for (int i = 2131761871; paramArrayOfInt[0] != 0; i = 2131761860)
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).Hjt, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.25((HomeUI)localObject), new HomeUI.26((HomeUI)localObject));
        break;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ((HomeUI)localObject).ffP();
      }
      else
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).Hjt, ((HomeUI)localObject).getString(2131761869), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.27((HomeUI)localObject), null);
        continue;
        if (paramArrayOfInt[0] == 0)
        {
          localObject = ((HomeUI)localObject).Hkk.fgP();
          if ((localObject instanceof FindMoreFriendsUI)) {
            ((FindMoreFriendsUI)localObject).ffx();
          }
        }
        else
        {
          com.tencent.mm.ui.base.h.a(((HomeUI)localObject).Hjt, ((HomeUI)localObject).getString(2131761869), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.28((HomeUI)localObject), null);
          continue;
          if (paramArrayOfInt[0] == 0)
          {
            ((HomeUI)localObject).ffQ();
          }
          else
          {
            if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
            for (i = 2131761860;; i = 2131761871)
            {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).Hjt, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131755691), false, new HomeUI.29((HomeUI)localObject), new HomeUI.30((HomeUI)localObject));
              break;
            }
            if (paramArrayOfInt[0] == 0) {
              ((HomeUI)localObject).ffQ();
            } else {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).Hjt, ((HomeUI)localObject).getString(2131761869), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.31((HomeUI)localObject), null);
            }
          }
        }
      }
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(33321);
    super.onRestoreInstanceState(paramBundle);
    NewChattingTabUI localNewChattingTabUI = this.chattingTabUI;
    localNewChattingTabUI.HqX = paramBundle.getString("last_restore_talker");
    ac.i("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", new Object[] { localNewChattingTabUI.HqX });
    this.Hlt = paramBundle.getBoolean("last_stay_chatting");
    this.Hlu = paramBundle.getInt("last_stay_tab");
    if (this.Hlt) {
      this.chattingTabUI.startChatting(this.chattingTabUI.HqX, null, false);
    }
    AppMethodBeat.o(33321);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33303);
    ac.i("MicroMsg.LauncherUI", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    super.onResume();
    if (this.Hlo.eb("onResume"))
    {
      ac.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
      AppMethodBeat.o(33303);
      return;
    }
    ac.i("MicroMsg.LauncherUI", "not skip this onResume");
    Hlg = false;
    Object localObject1;
    boolean bool1;
    Object localObject2;
    long l1;
    Object localObject4;
    Object localObject5;
    label730:
    Object localObject6;
    long l2;
    if (fgp())
    {
      ac.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", new Object[] { Boolean.valueOf(this.Hll) });
      if (!com.tencent.mm.model.az.agM())
      {
        ac.w("MicroMsg.LauncherUI", "accHasNotReady, kill self");
        finish();
        ac.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(33303);
        return;
      }
      if (!this.Hll)
      {
        this.Hll = true;
        localObject1 = this.Hlj;
        if ((HomeUI.ffZ()) && (HomeUI.fga()))
        {
          bool1 = true;
          ((HomeUI)localObject1).Hko = bool1;
          localObject2 = ((HomeUI)localObject1).Hkj;
          com.tencent.mm.sdk.b.a.GpY.c(((h)localObject2).Hjz);
          com.tencent.mm.sdk.b.a.GpY.c(((h)localObject2).HjA);
          if (!com.tencent.mm.ui.conversation.b.frM()) {
            getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
          }
          localObject2 = ((HomeUI)localObject1).Hjt.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.YK());
          if (((SharedPreferences)localObject2).getBoolean("first_launch_weixin", true))
          {
            ((SharedPreferences)localObject2).edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
          }
          ((HomeUI)localObject1).HjY = new ae(this);
          ((HomeUI)localObject1).HjQ = true;
          NotifyReceiver.Us();
          com.tencent.mm.model.az.getNotification().kr(1);
          if (com.tencent.mm.model.az.agM()) {
            break label2708;
          }
          ac.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
          ((HomeUI)localObject1).Hjt.finish();
          bj(getIntent());
        }
      }
      else
      {
        localObject1 = this.Hlj;
        l1 = bs.eWj();
        localObject2 = ((HomeUI)localObject1).Hkk;
        ac.i("MicroMsg.LauncherUI.MainTabUI", "onResume start :%d", new Object[] { Integer.valueOf(((MainTabUI)localObject2).aaj) });
        if (((MainTabUI)localObject2).HpB.size() != 0)
        {
          localObject4 = ((MainTabUI)localObject2).ZF(((MainTabUI)localObject2).aaj);
          ac.i("MicroMsg.LauncherUI.MainTabUI", "notifyCurrentTabResumeUI, mCurIndex:%s", new Object[] { Integer.valueOf(((MainTabUI)localObject2).aaj) });
          if (localObject4 != null) {
            ((m)localObject4).feI();
          }
          if ((localObject4 != null) && (com.tencent.matrix.b.Gp()) && (((MMFragment)localObject4).getActivity() != null))
          {
            localObject5 = ((MMFragment)localObject4).getActivity().getClass().getName();
            com.tencent.matrix.a.cqa.cF((String)localObject5 + "#" + localObject4.getClass().getSimpleName());
          }
        }
        if ((((MainTabUI)localObject2).Hpr) && (((MainTabUI)localObject2).Hjt.getIntent().hasExtra("isScrollFirst")) && (((MainTabUI)localObject2).Hjt.getIntent().hasExtra("isShowHeader")))
        {
          localObject4 = (MainUI)((MainTabUI)localObject2).HpB.get(Integer.valueOf(0));
          if (localObject4 != null)
          {
            bool1 = ((MainTabUI)localObject2).Hjt.getIntent().getBooleanExtra("isShowHeader", false);
            boolean bool2 = ((MainTabUI)localObject2).Hjt.getIntent().getBooleanExtra("isScrollFirst", true);
            ((MainUI)localObject4).j(bool1, ((MainTabUI)localObject2).Hjt.getIntent().getBooleanExtra("isShowHeaderWithAnim", false), bool2);
          }
        }
        if (((MainTabUI)localObject2).Hpr)
        {
          ((MainTabUI)localObject2).Hpr = false;
          ((MainTabUI)localObject2).aPD("tab_main");
        }
        localObject4 = (MainUI)((MainTabUI)localObject2).HpB.get(Integer.valueOf(0));
        if (localObject4 != null)
        {
          ((MainUI)localObject4).fqR();
          ((MainUI)localObject4).fsx();
        }
        if (((MainTabUI)localObject2).aaj != 0) {
          break label3700;
        }
        com.tencent.mm.model.az.getNotification().cx(true);
        localObject4 = (m)((MainTabUI)localObject2).ZF(((MainTabUI)localObject2).aaj);
        if (localObject4 != null) {
          ((m)localObject4).feJ();
        }
        ((MainTabUI)localObject2).Hpr = false;
        int i = x.getIntExtra(((MainTabUI)localObject2).Hjt.getIntent(), "preferred_tab", 0);
        ac.d("MicroMsg.LauncherUI.MainTabUI", "doOnResume, tabIdx = %d", new Object[] { Integer.valueOf(i) });
        if (i != 0)
        {
          ((MainTabUI)localObject2).ZE(i);
          ((MainTabUI)localObject2).Hjt.getIntent().putExtra("preferred_tab", 0);
        }
        com.tencent.mm.sdk.b.a.GpY.c(((MainTabUI)localObject2).Hpw);
        com.tencent.mm.sdk.b.a.GpY.c(((MainTabUI)localObject2).Hpy);
        com.tencent.mm.sdk.b.a.GpY.c(((MainTabUI)localObject2).Hpz);
        localObject2 = ((MainTabUI)localObject2).Hpp;
        if (((aa)localObject2).HpE != null) {
          ((aa)localObject2).HpE.feR();
        }
        if (com.tencent.mm.model.az.agM())
        {
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.agA().a(((aa)localObject2).HpJ);
          com.tencent.mm.y.c.aeH().a(((aa)localObject2).HpI);
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awG().a((n.b)localObject2);
          com.tencent.mm.sdk.b.a.GpY.c(((aa)localObject2).HiK);
          com.tencent.mm.sdk.b.a.GpY.c(((aa)localObject2).HpK);
          com.tencent.mm.sdk.b.a.GpY.c(((aa)localObject2).HiJ);
        }
        com.tencent.mm.blink.b.TR().w(new aa.6((aa)localObject2));
        localObject2 = ((HomeUI)localObject1).Hkj;
        localObject6 = new bf();
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject6);
        if ((((bf)localObject6).daT.daU) && (!bs.isNullOrNil(((bf)localObject6).daT.bIO)))
        {
          ac.i("MicroMsg.LauncherUI.GlobalAlertMgr", "  now show msg:%s", new Object[] { ((bf)localObject6).daT.bIO });
          localObject4 = new f.a(((h)localObject2).Hjt);
          localObject5 = ((f.a)localObject4).av(((h)localObject2).getString(2131755918)).aw(((h)localObject2).getString(2131755917));
          localObject6 = ((bf)localObject6).daT.bIO;
          ((f.a)localObject5).DqR.aRJ((String)localObject6);
          localObject4 = ((f.a)localObject4).yi(false).b(new h.2((h)localObject2));
          ((f.a)localObject4).JfY = true;
          ((f.a)localObject4).show();
        }
        if (!((h)localObject2).a(((h)localObject2).Hjv)) {
          com.tencent.mm.model.az.agU().m(new h.6((h)localObject2), 500L);
        }
        ((h)localObject2).Hjv = null;
        com.tencent.mm.sdk.a.b.eC(true);
        bool1 = ((HomeUI)localObject1).Hki.fgt();
        if ((!bool1) && (com.tencent.mm.model.az.agM()))
        {
          com.tencent.mm.blink.b.TR().w(new HomeUI.37((HomeUI)localObject1));
          if ((com.tencent.mm.bi.d.hXZ != null) && (com.tencent.mm.bi.d.hXY != null) && (!bs.isNullOrNil(com.tencent.mm.bi.d.hXY.aJb())))
          {
            ac.i("MicroMsg.LauncherUI.HomeUI", "launcher onResume end track %s", new Object[] { com.tencent.mm.bi.d.hXZ.aJc() });
            localObject2 = new fh();
            ((fh)localObject2).dfa.username = com.tencent.mm.bi.d.hXZ.aJc();
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        if (!bool1)
        {
          j.a(((HomeUI)localObject1).Hjt, 3, ((HomeUI)localObject1).Hkk.aaj, "directReport_onResume");
          ((HomeUI)localObject1).Hkk.ZB(260);
        }
        com.tencent.mm.ui.widget.h.b(((HomeUI)localObject1).Hjt);
        ((HomeUI)localObject1).Hjt.onSwipe(1.0F);
        ((HomeUI)localObject1).Hkh = HomeUI.a.HkR;
        if (((HomeUI)localObject1).HjS)
        {
          ((HomeUI)localObject1).HjS = false;
          ((HomeUI)localObject1).HjS = false;
        }
        com.tencent.mm.aj.o.aBs();
        l2 = System.currentTimeMillis();
        ac.w("MicroMsg.LauncherUI.HomeUI", "[Launching Application]");
        com.tencent.mm.kernel.l.o(((HomeUI)localObject1).Hjt, false);
        com.tencent.mm.kernel.l.p(((HomeUI)localObject1).Hjt, false);
        long l3 = System.currentTimeMillis();
        if (!((HomeUI)localObject1).Hjt.getSharedPreferences(com.tencent.mm.sdk.platformtools.ai.eUX(), 0).getBoolean("settings_landscape_mode", false)) {
          break label3712;
        }
        ((HomeUI)localObject1).Hjt.setRequestedOrientation(-1);
        label1465:
        long l4 = System.currentTimeMillis();
        if (getInstance() != null)
        {
          com.tencent.mm.blink.b.TR().TU();
          ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("showprivacypolicy", ((HomeUI)localObject1).HkI);
          ((HomeUI)localObject1).wt(false);
          com.tencent.mm.sdk.b.a.GpY.c(((HomeUI)localObject1).xnS);
          ac.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - l4));
          if (com.tencent.mm.model.az.agM()) {
            ((HomeUI)localObject1).ffY();
          }
        }
        ac.v("MicroMsg.LauncherUI.HomeUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - l3));
        ac.d("MicroMsg.LauncherUI.HomeUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - l2));
        ac.i("MicroMsg.LauncherUI.HomeUI", "initView " + (System.currentTimeMillis() - l1));
        if (((HomeUI)localObject1).HjS)
        {
          ((HomeUI)localObject1).HjS = false;
          ((HomeUI)localObject1).HjS = false;
        }
        localObject2 = com.tencent.mm.app.v.KE();
        ((com.tencent.mm.app.v)localObject2).cJp = true;
        ((com.tencent.mm.app.v)localObject2).cJq.removeMessages(-1999);
        ((com.tencent.mm.app.v)localObject2).cJq.removeMessages(-2999);
        ac.i("MicroMsg.LauncherUI.HomeUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - l1));
        if (u.aye().booleanValue()) {
          ((HomeUI)localObject1).ffM();
        }
        i = com.tencent.mm.kernel.g.agR().agA().getInt(ah.a.GTl, 0);
        if (i != 0)
        {
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GTl, Integer.valueOf(0));
          if (u.axZ()) {}
        }
        switch (i)
        {
        default: 
          label1804:
          com.tencent.mm.blink.b.TR().w(new HomeUI.2((HomeUI)localObject1));
          if (((HomeUI)localObject1).getMainTabUI().aaj != 3)
          {
            localObject1 = (MoreTabUI)((HomeUI)localObject1).getMainTabUI().ZF(3);
            if ((((MoreTabUI)localObject1).HpR != null) && (!((MoreTabUI)localObject1).HpR.isVisible))
            {
              ((MoreTabUI)localObject1).HpR.fvQ();
              ((MoreTabUI)localObject1).dpU();
            }
          }
          localObject1 = this.chattingTabUI;
          ((NewChattingTabUI)localObject1).HqS = bs.aNx();
          if (((NewChattingTabUI)localObject1).fhn())
          {
            ((NewChattingTabUI)localObject1).HqV = new NewChattingTabUI.1((NewChattingTabUI)localObject1);
            com.tencent.mm.sdk.platformtools.ap.n(new NewChattingTabUI.2((NewChattingTabUI)localObject1), 500L);
          }
          if (((NewChattingTabUI)localObject1).fgt())
          {
            ((NewChattingTabUI)localObject1).lA(3);
            if ((((NewChattingTabUI)localObject1).Hra != null) && (((NewChattingTabUI)localObject1).Hra.isSupportNavigationSwipeBack())) {
              ((NewChattingTabUI)localObject1).Hra.getSwipeBackLayout().setEnableGesture(true);
            }
            label1973:
            ac.i("MicroMsg.LauncherUI", "resumeNormalJump");
            MMFragmentActivity.a.fgN();
            if (("pushcontent_notification".equals(x.getStringExtra(getIntent(), "nofification_type"))) && (!bs.isNullOrNil(x.getStringExtra(getIntent(), "Main_FromUserName"))))
            {
              localObject1 = x.getStringExtra(getIntent(), "Main_FromUserName");
              i = x.getIntExtra(getIntent(), "MainUI_User_Last_Msg_Type", 0);
              ac.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + (String)localObject1 + i);
              com.tencent.mm.plugin.report.service.h.wUl.f(10856, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(0) });
            }
            localObject1 = x.getStringExtra(getIntent(), "LauncherUI.Shortcut.LaunchType");
            if (localObject1 != null)
            {
              if (!((String)localObject1).equals("launch_type_voip")) {
                break label3799;
              }
              ac.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
              localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.wUl.f(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
            }
            label2257:
            localObject1 = x.getStringExtra(getIntent(), "LauncherUI.switch.tab");
            if (!bs.isNullOrNil((String)localObject1))
            {
              this.Hlj.getMainTabUI().aPD((String)localObject1);
              getIntent().putExtra("LauncherUI.switch.tab", "");
            }
            if ((x.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) || (this.Hln))
            {
              this.Hln = false;
              localObject1 = getInstance();
              if (localObject1 != null) {
                ((LauncherUI)localObject1).Hlj.ffS();
              }
              getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
              getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
            }
            bool1 = x.getBooleanExtra(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
            if (!bool1) {
              break label3941;
            }
            localObject1 = x.getStringExtra(getIntent(), "LauncherUI.Shortcut.Username");
            label2401:
            if (bool1)
            {
              ac.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = ".concat(String.valueOf(localObject1)));
              if (!bs.isNullOrNil((String)localObject1))
              {
                localObject4 = com.tencent.mm.plugin.base.model.b.SV((String)localObject1);
                if (!bs.isNullOrNil((String)localObject4))
                {
                  if (w.wG((String)localObject4))
                  {
                    ac.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                    if (!com.tencent.mm.al.f.AP((String)localObject4)) {
                      break label4247;
                    }
                    if (!com.tencent.mm.al.f.so((String)localObject4)) {
                      break label3965;
                    }
                    localObject1 = new Intent();
                    ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                    ((Intent)localObject1).putExtra("Contact_User", (String)localObject4);
                    ((Intent)localObject1).putExtra("biz_chat_from_scene", 9);
                    ((Intent)localObject1).addFlags(67108864);
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                  getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
                  getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
                }
              }
            }
            label2593:
            this.Hlm = true;
            label2622:
            com.tencent.mm.blink.a.km(5);
            if (!Hli) {
              wx(false);
            }
            fgo();
            localObject1 = (com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class);
            if (localObject1 == null) {
              break label4282;
            }
            ac.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, try to fix");
            ((com.tencent.mm.plugin.ball.c.c)localObject1).bFP();
          }
          break;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).cSC();
        com.tencent.mm.plugin.base.stub.f.bHV();
        com.tencent.mm.blink.a.rp("LauncherUI");
        AppMethodBeat.o(33303);
        return;
        bool1 = false;
        break;
        label2708:
        ac.d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
        l1 = System.currentTimeMillis();
        l2 = System.currentTimeMillis();
        MMActivity.initLanguage(((HomeUI)localObject1).Hjt);
        try
        {
          localObject2 = new HashSet();
          localObject4 = ((HomeUI)localObject1).getString(2131757953).split(";");
          ((Set)localObject2).add(localObject4[0]);
          ((Set)localObject2).add(localObject4[1]);
          com.tencent.mm.model.v.b((Set)localObject2);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agU().az(new HomeUI.15((HomeUI)localObject1));
          ac.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).iMw = ((LayoutInflater)((HomeUI)localObject1).Hjt.getSystemService("layout_inflater"));
          l2 = System.currentTimeMillis();
          com.tencent.mm.kiss.a.b.ahR();
          ((HomeUI)localObject1).contentView = com.tencent.mm.kiss.a.b.c(((HomeUI)localObject1).Hjt, 2131494684);
          if ((((HomeUI)localObject1).contentView != null) && (Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.YJ())) {
            ((HomeUI)localObject1).contentView.setBackgroundColor(((HomeUI)localObject1).Hjt.getResources().getColor(2131100705));
          }
          com.tencent.mm.blink.b.TR().TS();
          ((FirstScreenFrameLayout)((HomeUI)localObject1).contentView.findViewById(2131300113)).flz = new HomeUI.23((HomeUI)localObject1);
          com.tencent.mm.pluginsdk.model.app.ap.eLk();
          ac.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).Hjt.setContentView(((HomeUI)localObject1).contentView);
          Looper.myQueue().addIdleHandler(((HomeUI)localObject1).nEp);
          ((HomeUI)localObject1).HjR = true;
          ac.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          ac.d("MicroMsg.LauncherUI.HomeUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          ac.d("MicroMsg.LauncherUI.HomeUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).initActionBar();
          ((HomeUI)localObject1).mActionBar.show();
          ((HomeUI)localObject1).contentView.post(new HomeUI.33((HomeUI)localObject1));
          ac.v("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - l1));
          com.tencent.mm.sdk.platformtools.ap.n(new HomeUI.34((HomeUI)localObject1), 2000L);
          ((HomeUI)localObject1).contentView.addOnLayoutChangeListener(((HomeUI)localObject1).Hkq);
          com.tencent.mm.pluginsdk.g.b(((HomeUI)localObject1).Hjt, ((HomeUI)localObject1).contentView);
          ((HomeUI)localObject1).contentView.postDelayed(new HomeUI.35((HomeUI)localObject1), 20L);
          localObject5 = ((HomeUI)localObject1).Hkk;
          ((MainTabUI)localObject5).mViewPager = ((CustomViewPager)((MainTabUI)localObject5).Hjt.findViewById(2131303135));
          ((MainTabUI)localObject5).mViewPager.setOffscreenPageLimit(4);
          ((MainTabUI)localObject5).mViewPager.setCanSlide(true);
          ((MainTabUI)localObject5).mViewPager.setCanSlideBySide(false);
          ((MainTabUI)localObject5).mTabsAdapter = new MainTabUI.TabsAdapter((MainTabUI)localObject5, ((MainTabUI)localObject5).Hjt, ((MainTabUI)localObject5).mViewPager);
          if (getInstance() != null)
          {
            ((MainTabUI)localObject5).ZE(getInstance().Hlu);
            localObject2 = ((MainTabUI)localObject5).Hpp;
            localObject4 = (ViewGroup)((MainTabUI)localObject5).mViewPager.getParent();
            localObject5 = ((MainTabUI)localObject5).mTabsAdapter;
            localObject6 = ((aa)localObject2).HpE;
            if (((aa)localObject2).HpE != null)
            {
              ((aa)localObject2).HpE.setOnTabClickListener(null);
              ((View)((aa)localObject2).HpE).setVisibility(8);
              if (localObject4 != null) {
                ((ViewGroup)localObject4).removeView((View)((aa)localObject2).HpE);
              }
            }
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
            LauncherUIBottomTabView localLauncherUIBottomTabView = new LauncherUIBottomTabView(((aa)localObject2).Hjt);
            localLauncherUIBottomTabView.setId(2131301338);
            if (localObject4 != null)
            {
              localLayoutParams.gravity = 80;
              ((ViewGroup)localObject4).addView(localLauncherUIBottomTabView, localLayoutParams);
            }
            ((aa)localObject2).HpE = localLauncherUIBottomTabView;
            ((View)((aa)localObject2).HpE).setVisibility(0);
            ((aa)localObject2).HpE.setOnTabClickListener((c.a)localObject5);
            if ((localObject6 != null) && (localObject6 != ((aa)localObject2).HpE))
            {
              ((aa)localObject2).HpE.wl(((c)localObject6).getShowFriendPoint());
              ((aa)localObject2).HpE.wm(((c)localObject6).getSettingsPoint());
              ((aa)localObject2).HpE.Zj(((c)localObject6).getMainTabUnread());
              ((aa)localObject2).HpE.Zk(((c)localObject6).getContactTabUnread());
              ((aa)localObject2).HpE.Zl(((c)localObject6).getFriendTabUnread());
              ((aa)localObject2).HpE.Zm(((c)localObject6).getSettingsTabUnread());
              ((aa)localObject2).HpE.setTo(((c)localObject6).getCurIdx());
            }
            ((HomeUI)localObject1).Hkk.Hpv = new HomeUI.1((HomeUI)localObject1);
            com.tencent.e.h.JZN.aS(new HomeUI.12((HomeUI)localObject1));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
            continue;
            ((MainTabUI)localObject5).ZE(0);
          }
        }
      }
      label3700:
      com.tencent.mm.model.az.getNotification().cx(false);
      break label730;
      label3712:
      ((HomeUI)localObject1).Hjt.setRequestedOrientation(1);
      break label1465;
      com.tencent.mm.ui.base.h.a(((HomeUI)localObject1).Hjt, ((HomeUI)localObject1).getString(2131760750), "", new HomeUI.38((HomeUI)localObject1), null);
      break label1804;
      if (!((NewChattingTabUI)localObject1).Hrd) {
        break label1973;
      }
      ac.w("MicroMsg.LauncherUI.NewChattingTabUI", "[onResume] need exec this runnable!");
      com.tencent.mm.sdk.platformtools.ap.aB(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      com.tencent.mm.sdk.platformtools.ap.f(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      ((NewChattingTabUI)localObject1).Hrd = false;
      break label1973;
      label3799:
      if (!((String)localObject1).equals("launch_type_voip_audio")) {
        break label2257;
      }
      ac.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
      localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.wUl.f(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      break label2257;
      label3941:
      bool1 = x.getBooleanExtra(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
      localObject1 = getIntent().getAction();
      break label2401;
      label3965:
      if (com.tencent.mm.al.f.AR((String)localObject4))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject1).putExtra("enterprise_biz_name", (String)localObject4);
        ((Intent)localObject1).putExtra("enterprise_biz_display_name", com.tencent.mm.model.v.wk((String)localObject4));
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break label2593;
      }
      if (com.tencent.mm.al.f.AS((String)localObject4))
      {
        localObject1 = com.tencent.mm.al.f.dX((String)localObject4);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).IR())
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
          com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          break;
        }
      }
      localObject1 = getInstance();
      Object localObject3 = new Bundle();
      ((Bundle)localObject3).putInt("chat_from_scene", 3);
      ((LauncherUI)localObject1).startChatting((String)localObject4, (Bundle)localObject3, false);
      break label2593;
      label4247:
      localObject1 = getInstance();
      if (localObject1 == null) {
        break label2593;
      }
      ((LauncherUI)localObject1).startChatting((String)localObject4, null, false);
      break label2593;
      if (Hli) {
        break label2622;
      }
      fgs();
      break label2622;
      label4282:
      ac.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, service is null");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(33322);
    Object localObject = this.chattingTabUI;
    if (((NewChattingTabUI)localObject).Hra != null)
    {
      localObject = ((NewChattingTabUI)localObject).Hra.cLy.getTalkerUserName();
      if (!bs.isNullOrNil((String)localObject))
      {
        ac.i("MicroMsg.LauncherUI.NewChattingTabUI", "onSaveInstanceState:%s", new Object[] { localObject });
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
    if ((this.Hll) && (!this.chattingTabUI.V(paramBoolean, paramInt))) {
      super.onSettle(paramBoolean, paramInt);
    }
    AppMethodBeat.o(33318);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(33312);
    ac.i("MicroMsg.LauncherUI", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.blink.a.TM();
    HomeUI localHomeUI = this.Hlj;
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("showprivacypolicy", localHomeUI.HkI);
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
    if (this.Hll)
    {
      localNewChattingTabUI = this.chattingTabUI;
      if ((localNewChattingTabUI.HqR == null) || (!localNewChattingTabUI.HqR.ffT())) {
        break label108;
      }
      bool = true;
      ac.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", new Object[] { Float.valueOf(paramFloat), Long.valueOf(260L), Boolean.valueOf(bool) });
      if (localNewChattingTabUI.fhn()) {
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
        localNewChattingTabUI.ZJ(0);
        localObject = (ImageView)localNewChattingTabUI.mvz.getWindow().getDecorView().findViewById(2131303386);
        if (localObject != null)
        {
          ac.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE no cache!");
          ((ImageView)localObject).setVisibility(8);
          ((ImageView)localObject).setImageDrawable(null);
        }
        if (localNewChattingTabUI.mChattingInAnim != null) {
          localNewChattingTabUI.mChattingInAnim.cancel();
        }
      }
      for (;;)
      {
        if (!localNewChattingTabUI.HqR.ffT())
        {
          if (Float.compare(1.0F, paramFloat) > 0)
          {
            ac.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Boolean.FALSE });
            i = 0;
            break;
            if ((paramFloat != 1.0F) || (localNewChattingTabUI.mChattingClosed) || (localNewChattingTabUI.Hra.fkF())) {
              continue;
            }
            localNewChattingTabUI.mvz.getWindow().setBackgroundDrawableResource(2131100810);
            localObject = (ImageView)localNewChattingTabUI.mvz.getWindow().getDecorView().findViewById(2131303386);
            if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0) && (((ImageView)localObject).getTag() != null))
            {
              ((View)((ImageView)localObject).getTag()).setVisibility(0);
              ac.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
              ((ImageView)localObject).setVisibility(8);
            }
            if ((localNewChattingTabUI.Hra.getContentView() != null) && (localNewChattingTabUI.Hra.getContentView().getX() <= 0.0F))
            {
              localNewChattingTabUI.ZJ(8);
              continue;
            }
            localNewChattingTabUI.ZJ(0);
            continue;
          }
          j = 0;
        }
      }
      i = j;
      if (localNewChattingTabUI.mvz != null)
      {
        localObject = localNewChattingTabUI.mvz.findViewById(2131301337);
        ImageView localImageView = (ImageView)localNewChattingTabUI.mvz.findViewById(2131303386);
        if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null) && (!localNewChattingTabUI.mChattingClosed) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
        {
          localImageView.setVisibility(0);
          ac.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
          localNewChattingTabUI.ZJ(8);
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
    if (((NewChattingTabUI)localObject3).Hra != null)
    {
      localObject1 = localObject2;
      if (((NewChattingTabUI)localObject3).Hra.fkH() != null)
      {
        if (((NewChattingTabUI)localObject3).Hra.isSupportCustomActionBar()) {
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
      if (!com.tencent.mm.compatible.util.d.lb(22))
      {
        localObject3 = ((NewChattingTabUI)localObject3).Hra.fkH().startActionMode(paramCallback);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject3;
        }
      }
    }
  }
  
  public final void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(33329);
    this.Hlj.ffR();
    this.chattingTabUI.startChatting(paramString, paramBundle, paramBoolean);
    AppMethodBeat.o(33329);
  }
  
  static abstract interface a
  {
    public abstract boolean fgt();
  }
  
  static abstract interface b
  {
    public abstract void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup);
    
    public abstract boolean ffT();
    
    public abstract void ffV();
    
    public abstract void ffW();
  }
  
  static abstract interface c
  {
    public abstract void ffU();
  }
  
  static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI
 * JD-Core Version:    0.7.0.1
 */