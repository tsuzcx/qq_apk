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
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.bi.b;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.ui.WelcomeActivity;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.a.d.a;
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
  private static boolean JtE;
  private static ArrayList<LauncherUI> Jtt;
  private static ArrayList<WeakReference<LauncherUI>> Jtu;
  private static boolean Jtv;
  public static long Jtw;
  private static boolean Jtx;
  public boolean JtA;
  boolean JtB;
  private boolean JtC;
  private t JtD;
  private boolean JtF;
  private aq JtG;
  private Runnable JtH;
  private boolean JtI;
  int JtJ;
  public HomeUI Jty;
  private n Jtz;
  private NewChattingTabUI chattingTabUI;
  private Intent dzp;
  
  static
  {
    AppMethodBeat.i(33334);
    Jtt = new ArrayList();
    Jtu = new ArrayList();
    Jtv = true;
    Jtx = false;
    JtE = false;
    AppMethodBeat.o(33334);
  }
  
  public LauncherUI()
  {
    AppMethodBeat.i(33295);
    this.Jty = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.Jty);
    this.Jtz = new n();
    this.dzp = null;
    this.JtA = false;
    this.JtB = false;
    this.JtC = false;
    this.JtD = new t("MicroMsg.LauncherUI");
    this.JtF = false;
    this.JtG = new aq();
    this.JtH = new Runnable()
    {
      long gW = 2000L;
      
      @TargetApi(17)
      public final void run()
      {
        AppMethodBeat.i(33293);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
        ar.ay(this);
        if (bc.aCh())
        {
          com.tencent.mm.kernel.g.ajP();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()) });
          AppMethodBeat.o(33293);
          return;
        }
        if ((com.tencent.mm.modelstat.d.aLZ()) || (com.tencent.mm.sdk.a.b.foreground))
        {
          this.gW += 2000L;
          if (this.gW > 10000L) {
            this.gW = 2000L;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelstat.d.aLZ()), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground), Long.valueOf(this.gW) });
          ar.o(this, this.gW);
          AppMethodBeat.o(33293);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit!!!");
        if (WXHardCoderJNI.isCheckEnv()) {
          com.tencent.mm.sdk.g.b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33292);
              WXHardCoderJNI.terminateApp(Process.myTid(), SystemClock.elapsedRealtimeNanos());
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp done");
              AppMethodBeat.o(33292);
            }
          }, "terminateApp");
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit app done");
        AppMethodBeat.o(33293);
      }
    };
    this.JtI = false;
    this.JtJ = 0;
    AppMethodBeat.o(33295);
  }
  
  private void bp(Intent paramIntent)
  {
    AppMethodBeat.i(33307);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "handleJump");
    if (!bc.ajM())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
      paramIntent = new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahE(), "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(33307);
      return;
    }
    Object localObject1 = new lb();
    ((lb)localObject1).dzo.dzp = this.dzp;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    if ("talkroom_notification".equals(z.getStringExtra(paramIntent, "nofification_type")))
    {
      paramIntent = z.getStringExtra(paramIntent, "enter_chat_usrname");
      if (!bu.isNullOrNil(paramIntent))
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BakToPcUI");
      }
      for (paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");; paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI"))
      {
        paramIntent.setFlags(268435456);
        MMWizardActivity.al(this, paramIntent);
        AppMethodBeat.o(33307);
        return;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
      }
    }
    if ("back_to_pcmgr_error_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.al(this, paramIntent);
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
      MMWizardActivity.al(this, paramIntent);
      AppMethodBeat.o(33307);
      return;
    }
    if (z.getBooleanExtra(paramIntent, "show_update_dialog", false)) {
      bq(paramIntent);
    }
    String str = z.getStringExtra(paramIntent, "Main_User");
    localObject1 = z.getStringExtra(paramIntent, "nofification_type");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "[handleJump] user:%s", new Object[] { str });
    Object localObject2;
    int i;
    if ((str != null) && (!str.equals("")))
    {
      bc.aCg();
      localObject2 = com.tencent.mm.model.c.azL().aVa(str);
      if (localObject2 != null)
      {
        i = ((ba)localObject2).field_unReadCount;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "[oneliang] user:%s, conversation :%s, unReadCount:%s", new Object[] { str, localObject2, Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0) {
        j = z.getIntExtra(paramIntent, "pushcontent_unread_count", 0);
      }
      MMAppMgr.MP();
      com.tencent.mm.sdk.b.a.IvT.l(new af());
      boolean bool = z.getBooleanExtra(paramIntent, "Intro_Is_Muti_Talker", true);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((!bool) && (j > 0))
      {
        i = z.getIntExtra(paramIntent, "Intro_Bottle_unread_count", 0);
        if (i > 0)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.br.d.Q(this, "bottle", ".ui.BottleConversationUI");
        }
      }
      if (!bool)
      {
        if (x.AE(str))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("type", 20);
          com.tencent.mm.br.d.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
        }
        for (;;)
        {
          if (z.getIntExtra(paramIntent, "kstyle_show_bind_mobile_afterauth", 0) > 0)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMobileUI");
            ((Intent)localObject1).putExtra("kstyle_bind_recommend_show", paramIntent.getIntExtra("kstyle_bind_recommend_show", 0));
            ((Intent)localObject1).putExtra("kstyle_bind_wording", paramIntent.getParcelableExtra("kstyle_bind_wording"));
            MMWizardActivity.al(this, (Intent)localObject1);
          }
          AppMethodBeat.o(33307);
          return;
          if (!x.AM(str)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
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
        if ("new_msg_nofification".equals(z.getStringExtra(paramIntent, "nofification_type")))
        {
          ((Bundle)localObject1).putInt("chat_from_scene", 1);
          ((Bundle)localObject1).putBoolean("key_can_show_message_float_ball", true);
        }
        localObject2 = getInstance();
        if (localObject2 == null) {
          break;
        }
        if (com.tencent.mm.al.g.vz(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("biz_chat_from_scene", 4);
          com.tencent.mm.br.d.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if (com.tencent.mm.al.g.Et(str))
        {
          localObject1 = com.tencent.mm.al.g.eX(str);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).Kz())
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
        if (an.zd(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("app_brand_conversation_from_scene", 3);
          paramIntent.putExtra("finish_direct", true);
          paramIntent.putExtra("key_need_send_video", false);
          com.tencent.mm.br.d.f(this, ".ui.conversation.AppBrandServiceConversationUI", paramIntent);
          break;
        }
        ((LauncherUI)localObject2).startChatting(str, (Bundle)localObject1, false);
        break;
        if (z.getBooleanExtra(paramIntent, "From_fail_notify", false))
        {
          if (!bu.isNullOrNil(str))
          {
            localObject1 = getInstance();
            if (localObject1 == null) {
              break;
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putBoolean("Chat_Mode", z.getBooleanExtra(paramIntent, "resend_fail_messages", false));
            if (com.tencent.mm.al.g.vz(str))
            {
              paramIntent.putExtra("Contact_User", str);
              paramIntent.addFlags(67108864);
              paramIntent.putExtra("biz_chat_from_scene", 4);
              com.tencent.mm.br.d.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
              break;
            }
            ((LauncherUI)localObject1).startChatting(str, (Bundle)localObject2, false);
            break;
          }
          if (!z.getBooleanExtra(paramIntent, "jump_sns_from_notify", false)) {
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
        if (z.getBooleanExtra(paramIntent, "biz_chat_need_to_jump_to_chatting_ui", false))
        {
          if ((getInstance() == null) || (!com.tencent.mm.al.g.vz(str))) {
            break;
          }
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          com.tencent.mm.br.d.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if ((bu.isNullOrNil(str)) || (!"new_msg_nofification".equals(localObject1))) {
          break;
        }
        if (paramIntent == null) {}
        for (localObject1 = "null";; localObject1 = paramIntent)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LauncherUI", "[handleJump] intent:%s", new Object[] { localObject1 });
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
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LauncherUI", "LauncherUI.getInstance is null! ");
        break;
      }
      i = 0;
      break;
      i = 0;
    }
  }
  
  private void bq(Intent paramIntent)
  {
    AppMethodBeat.i(33315);
    int i = z.getIntExtra(paramIntent, "update_type", -1);
    if (i == -1)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
      AppMethodBeat.o(33315);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(405L, 28L, 1L, true);
    com.tencent.mm.plugin.report.service.g localg;
    if (com.tencent.mm.plugin.q.d.drw() != null)
    {
      paramIntent = com.tencent.mm.plugin.q.d.drw().c(this, null);
      if (paramIntent == null)
      {
        AppMethodBeat.o(33315);
        return;
      }
      localg = com.tencent.mm.plugin.report.service.g.yxI;
      if (i != 2) {
        break label116;
      }
    }
    label116:
    for (long l = 29L;; l = 30L)
    {
      localg.idkeyStat(405L, l, 1L, true);
      paramIntent.update(i);
      AppMethodBeat.o(33315);
      return;
    }
  }
  
  private void fAA()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33300);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI", "[whatsnew] checkIfStartWhatsNew.");
    if (JtE)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "[whatsnew] has been played.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!com.tencent.mm.kernel.g.ajP().aiZ())
    {
      com.tencent.mm.kernel.g.ajP();
      if (!com.tencent.mm.kernel.a.aiY())
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "[whatsnew] not login yet, skip.");
        AppMethodBeat.o(33300);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "[whatsnew] account not initiate, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!fAB())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "[whatsnew] notSwitchOrHold is false, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    boolean bool3 = z.getBooleanExtra(getIntent(), "LauncherUI.enter_from_reg", false);
    boolean bool4;
    boolean bool1;
    if ((!bool3) && (com.tencent.mm.pluginsdk.i.f.Fhu != null) && (com.tencent.mm.pluginsdk.i.f.Fhu.MZ()) && (bc.ajM()))
    {
      if (com.tencent.mm.sdk.platformtools.ao.aRR("show_whatsnew"))
      {
        JtE = true;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "[whatsnew] show whatsnew.");
        MMAppMgr.bd(this);
        com.tencent.mm.blink.a.Wl();
        AppMethodBeat.o(33300);
      }
    }
    else
    {
      com.tencent.mm.pluginsdk.i.f.a locala = com.tencent.mm.pluginsdk.i.f.Fhu;
      bool4 = bc.ajM();
      if (locala != null) {
        break label262;
      }
      bool1 = true;
      if ((locala == null) || (!locala.MZ())) {
        break label267;
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "[whatsnew] do not show whatsnew. enter_from_reg=%s accHasReady=%s MMAppMgr is null %s isWhatsNewAvailable=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      AppMethodBeat.o(33300);
      return;
      label262:
      bool1 = false;
      break;
      label267:
      bool2 = false;
    }
  }
  
  private boolean fAB()
  {
    AppMethodBeat.i(33304);
    if ((this.dzp != null) && (!z.getBooleanExtra(this.dzp, "Intro_Switch", false)) && (bc.aCh()) && (!bc.aiT()))
    {
      AppMethodBeat.o(33304);
      return true;
    }
    AppMethodBeat.o(33304);
    return false;
  }
  
  private boolean fAC()
  {
    AppMethodBeat.i(33305);
    if (this.dzp != null)
    {
      Object localObject1;
      Object localObject2;
      if ((z.getBooleanExtra(this.dzp, "absolutely_exit", false)) || (z.getIntExtra(this.dzp, "absolutely_exit_pid", 0) == Process.myPid()))
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        finish();
        com.tencent.mm.plugin.report.service.f.OR(8);
        MMAppMgr.xu(z.getBooleanExtra(this.dzp, "kill_service", true));
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "java/lang/System_EXEC_", "exit", "(I)V");
        AppMethodBeat.o(33305);
        return true;
      }
      if (z.getBooleanExtra(this.dzp, "can_finish", false))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
        bc.ajj().eF(true);
        if (com.tencent.mm.kernel.l.co(getApplicationContext())) {
          com.tencent.mm.booter.b.bJ(getApplicationContext());
        }
        com.tencent.mm.plugin.report.service.f.OR(8);
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), "com.tencent.mm.permission.MM_MESSAGE");
        finish();
        com.tencent.mm.ui.base.b.kl(this);
        AppMethodBeat.o(33305);
        return true;
      }
      if (z.getBooleanExtra(this.dzp, "exit_and_restart", false))
      {
        Mars.onSingalCrash(0);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "exit and restart myself.");
        com.tencent.mm.sdk.platformtools.ae.foo();
        finish();
        localObject1 = new Intent(this, LauncherUI.class);
        ((Intent)localObject1).addFlags(67108864);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "restart, try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        MMAppMgr.fBa();
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(33305);
        return true;
      }
    }
    AppMethodBeat.o(33305);
    return false;
  }
  
  private void fAD()
  {
    AppMethodBeat.i(33306);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "switch to wxid %s", new Object[] { ak.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "") });
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).addFlags(536870912);
    ((Intent)localObject).putExtra("key_scene", 1);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.km(this);
    AppMethodBeat.o(33306);
  }
  
  private void fAE()
  {
    AppMethodBeat.i(33308);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "resumeLogoutJump");
    if ((this.dzp != null) && (z.getBooleanExtra(getIntent(), "LauncherUI.jump_from_uimode_check", false)))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "dancy uimode check from background, not jumpToLogin or welcome!");
      AppMethodBeat.o(33308);
      return;
    }
    MMFragmentActivity.a.fBb();
    Object localObject = bb.hIK.ay("login_user_name", "");
    if ((!bc.aCh()) && (((String)localObject).equals("")))
    {
      localObject = new Intent(this, WelcomeActivity.class);
      ((Intent)localObject).addFlags(536870912);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.km(this);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
      ar.ay(this.JtH);
      ar.o(this.JtH, 2000L);
      AppMethodBeat.o(33308);
      return;
    }
    if ((this.dzp.getFlags() & 0x4000000) == 67108864) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = z.getBooleanExtra(this.dzp, "Intro_Notify", false);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", new Object[] { Boolean.valueOf(this.JtA), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bc.aiT()) });
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", new Object[] { Boolean.valueOf(bc.aCh()) });
      bc.hold();
      if (z.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
        this.JtC = true;
      }
      jL(this);
      bc.unhold();
      AppMethodBeat.o(33308);
      return;
    }
  }
  
  private void fAz()
  {
    AppMethodBeat.i(33298);
    int i = Jtt.indexOf(this);
    if (i >= 0) {
      Jtt.remove(i);
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(Jtt.size()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(33298);
  }
  
  public static int getCurrentTabIndex()
  {
    AppMethodBeat.i(33297);
    if ((getInstance() != null) && (getInstance().getHomeUI() != null) && (getInstance().getHomeUI().getMainTabUI() != null))
    {
      int i = getInstance().getHomeUI().getMainTabUI().abZ;
      AppMethodBeat.o(33297);
      return i;
    }
    AppMethodBeat.o(33297);
    return -1;
  }
  
  public static LauncherUI getInstance()
  {
    AppMethodBeat.i(33296);
    if (Jtt.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", new Object[] { bu.fpN() });
      AppMethodBeat.o(33296);
      return null;
    }
    LauncherUI localLauncherUI = (LauncherUI)Jtt.get(0);
    AppMethodBeat.o(33296);
    return localLauncherUI;
  }
  
  private void jL(Context paramContext)
  {
    AppMethodBeat.i(33309);
    if (z.getBooleanExtra(this.dzp, "LauncherUI.jump_switch_account", false))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "launcher to switch account");
      fAD();
      AppMethodBeat.o(33309);
      return;
    }
    if ((z.getBooleanExtra(this.dzp, "Intro_Switch", false)) || (this.JtA) || (com.tencent.mm.kernel.a.aiI()))
    {
      this.Jty.getMainTabUI().bRR();
      com.tencent.mm.kernel.g.ajS().xI("[normal logout]");
      Mars.onSingalCrash(0);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
      com.tencent.mm.sdk.platformtools.ae.foo();
      finish();
      Object localObject = new Intent(paramContext, LauncherUI.class);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
      MMAppMgr.fBa();
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramContext.ahE(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(33309);
      return;
    }
    if (!z.getBooleanExtra(this.dzp, "LauncherUI.jump_switch_account", false))
    {
      paramContext = bb.hIK.ay("login_user_name", "");
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "%s jumpToLogin", new Object[] { paramContext });
      if (!bu.isNullOrNil(paramContext)) {
        break label466;
      }
      paramContext = new Intent(this, WelcomeActivity.class);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bc(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.ahE(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.km(this);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.f.OR(8);
      ar.ay(this.JtH);
      ar.o(this.JtH, 2000L);
      AppMethodBeat.o(33309);
      return;
      label466:
      boolean bool = ak.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "switchAccount %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      paramContext = new Intent(this, SettingsSwitchAccountUI.class);
      paramContext.addFlags(536870912);
      paramContext.putExtra("key_scene", 2);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bc(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.ahE(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kj(this);
    }
    int i = bu.aSB(bb.hIK.ay("last_login_use_voice", ""));
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "pluginSwitch  ".concat(String.valueOf(i)));
    paramContext = new Intent();
    if ((i & 0x20000) != 0) {
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginVoiceUI");
    }
    for (;;)
    {
      paramContext.addFlags(536870912);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bc(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.ahE(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kj(this);
      break;
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginPasswordUI");
    }
  }
  
  public static void jM(Context paramContext)
  {
    AppMethodBeat.i(33328);
    Object localObject = new Intent(paramContext, LauncherUI.class);
    ((Intent)localObject).addFlags(67108864);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33328);
  }
  
  private void xr(boolean paramBoolean)
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
      n.fAH();
    }
    for (paramBoolean = false;; paramBoolean = true)
    {
      this.JtF = paramBoolean;
      do
      {
        AppMethodBeat.o(33302);
        return;
      } while (this.JtF);
      if (this.Jtz.aY(this)) {
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
        LauncherUI.this.Jty.getMainTabUI().fBi();
        AppMethodBeat.o(33294);
      }
    };
    if (this.chattingTabUI.xB(paramBoolean))
    {
      this.Jty.xo(this.chattingTabUI.Jzr.isSupportCustomActionBar());
      this.Jty.getMainTabUI().fBl();
    }
    AppMethodBeat.o(33330);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33319);
    boolean bool;
    if (this.chattingTabUI.fAF())
    {
      NewChattingTabUI localNewChattingTabUI = this.chattingTabUI;
      if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
        ar.ay(localNewChattingTabUI.mStartChattingRunnable);
      }
      if (localNewChattingTabUI.isAnimating) {}
      for (bool = true; bool; bool = localNewChattingTabUI.Jzr.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent))
      {
        AppMethodBeat.o(33319);
        return true;
      }
    }
    if (this.Jty.dispatchKeyEvent(paramKeyEvent))
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
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", new Object[] { paramKeyEvent.getMessage() });
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.LauncherUI", paramKeyEvent, "", new Object[0]);
      AppMethodBeat.o(33319);
    }
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(33316);
    super.finish();
    fAz();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(Jtt.size()), bu.fpN() });
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
    for (localObject1 = ((NewChattingTabUI)localObject1).Jzr;; localObject1 = null)
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
    return this.Jty;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str1 = null;
    Object localObject1 = null;
    AppMethodBeat.i(33310);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.LauncherUI", "edw on activity result");
    Object localObject2 = this.chattingTabUI;
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 226) || (paramInt1 == 30762) || (paramInt1 == 1111)) && (((NewChattingTabUI)localObject2).Jzr != null)) {
      ((NewChattingTabUI)localObject2).Jzr.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((NewChattingTabUI.acceptRequestCode(paramInt1)) && (((NewChattingTabUI)localObject2).Jzr == null))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
      ar.ay(((NewChattingTabUI)localObject2).Jzt);
      ((NewChattingTabUI)localObject2).Jzt.JzC = 0;
      ((NewChattingTabUI)localObject2).Jzt.requestCode = paramInt1;
      ((NewChattingTabUI)localObject2).Jzt.bZU = paramInt2;
      ((NewChattingTabUI)localObject2).Jzt.dyD = paramIntent;
      ar.f(((NewChattingTabUI)localObject2).Jzt);
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(33310);
      return;
    }
    localObject2 = this.Jty;
    if (((HomeUI)localObject2).Jsf)
    {
      if (paramInt1 == 1)
      {
        bc.aCg();
        if (!bu.o((Boolean)com.tencent.mm.model.c.ajA().get(12323, null))) {
          y.showAddrBookUploadConfirm(((HomeUI)localObject2).JrI, null, false, 3);
        }
        AppMethodBeat.o(33310);
        return;
      }
      if (paramInt1 == 22722)
      {
        str1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
        if (paramIntent != null) {
          localObject1 = paramIntent.getBundleExtra("result_data");
        }
        if ((localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("agree_privacy")))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "agree privacy policy");
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(712L, 4L, 1L, false);
          localObject1 = new com.tencent.mm.plugin.account.model.g(1, str1);
          com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)localObject1, 0);
          if ((com.tencent.mm.aw.b.Gw(str1)) && (com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.IXY, false)))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "needbirthday true");
            ar.o(new HomeUI.24((HomeUI)localObject2), 100L);
          }
        }
      }
      while ((paramInt1 == 65534) && (paramInt2 == -1))
      {
        com.tencent.mm.sdk.platformtools.ao.aRS("welcome_page_show");
        com.tencent.mm.kernel.l.q(((HomeUI)localObject2).JrI, true);
        MMAppMgr.MP();
        MMAppMgr.m(((HomeUI)localObject2).JrI, true);
        ((HomeUI)localObject2).JrI.finish();
        AppMethodBeat.o(33310);
        return;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "disagree privacy policy");
        localObject1 = new com.tencent.mm.plugin.account.model.g(2, str1);
        com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)localObject1, 0);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(712L, 5L, 1L, false);
        continue;
        if (paramInt1 == 22723)
        {
          String str2 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null);
          localObject1 = str1;
          if (paramIntent != null) {
            localObject1 = paramIntent.getBundleExtra("result_data");
          }
          if (localObject1 != null) {
            if (((Bundle)localObject1).getString("go_next", "").equals("birthdayComfirmOK"))
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "verify birthday ok");
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXY, Boolean.FALSE);
            }
            else if (((Bundle)localObject1).getString("go_next", "").equals("gdpr_confirm_logout"))
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "quit verify birthday after H5-warnning");
              localObject1 = new com.tencent.mm.plugin.account.model.g(2, str2);
              com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)localObject1, 0);
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(712L, 5L, 1L, false);
            }
          }
        }
      }
      if ((paramInt1 == 30764) && (paramIntent != null))
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYR, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b(((HomeUI)localObject2).JrI, "android.permission.ACCESS_COARSE_LOCATION", 66);
        }
      }
    }
    AppMethodBeat.o(33310);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(33320);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "onBackPressed");
    Object localObject = new Intent("android.intent.action.MAIN");
    ((Intent)localObject).addCategory("android.intent.category.HOME");
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/LauncherUI", "onBackPressed", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "onBackPressed", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33320);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(33325);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.Jty;
    com.tencent.mm.pluginsdk.h.b(paramConfiguration.JrI, paramConfiguration.contentView);
    AppMethodBeat.o(33325);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33299);
    com.tencent.mm.blink.a.qQ(com.tencent.mm.kernel.h.ajV().gEO);
    if (al.isDarkMode()) {
      setTheme(2131820569);
    }
    long l1;
    long l2;
    int i;
    boolean bool1;
    for (;;)
    {
      l1 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bu.jr(this) });
      super.onCreate(paramBundle);
      MainProcessChecker.avH(getClass().getName());
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
        if (z.getBooleanExtra(paramBundle, "absolutely_exit", false))
        {
          bool1 = true;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
        }
      }
      paramBundle = Jtu.iterator();
      while (paramBundle.hasNext())
      {
        localObject1 = (LauncherUI)((WeakReference)paramBundle.next()).get();
        if (localObject1 != null) {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "Check launcher instance found one %s", new Object[] { localObject1 });
        }
      }
      setTheme(2131820574);
    }
    Object localObject1 = null;
    paramBundle = null;
    Object localObject3;
    if (!bool1)
    {
      localObject3 = Jtt.iterator();
      localObject1 = paramBundle;
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (LauncherUI)((Iterator)localObject3).next();
        if (((LauncherUI)localObject1).getTaskId() != i)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", new Object[] { Integer.valueOf(localObject1.hashCode()), Integer.valueOf(((LauncherUI)localObject1).getTaskId()), Integer.valueOf(i) });
          paramBundle = bu.aJ(this, i);
          if (paramBundle != null)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), paramBundle.topActivity.getClassName(), paramBundle.baseActivity.getClassName(), Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
            if (paramBundle.baseActivity.getPackageName().equals(localObject2)) {
              break label589;
            }
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + paramBundle.baseActivity.getPackageName());
            finish();
            if (bu.aJ(this, ((LauncherUI)localObject1).getTaskId()) != null)
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
              paramBundle = new Intent(this, LauncherUI.class);
              paramBundle.addFlags(268435456);
              paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahE(), "com/tencent/mm/ui/LauncherUI", "checkInstance", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramBundle.mt(0));
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
        AppMethodBeat.o(33299);
        return;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", new Object[] { Integer.valueOf(i) });
        finish();
        i = 0;
        continue;
        label589:
        ((LauncherUI)localObject1).finish();
        Jtt.remove(localObject1);
        break;
        if (!Jtt.isEmpty())
        {
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = bu.aJ(this, i);
          }
          if (paramBundle == null) {
            break label887;
          }
          localObject1 = paramBundle.baseActivity.getClassName();
          localObject2 = paramBundle.baseActivity.getClassName();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), localObject2, localObject1, Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
          localObject3 = getComponentName().getClassName();
          if ((paramBundle.numActivities > 1) && (((String)localObject3).equals(localObject1)) && (((String)localObject3).equals(localObject2)))
          {
            finish();
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(Jtt.size()) });
            i = 0;
            continue;
          }
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", new Object[] { Integer.valueOf(Jtt.size()), Boolean.valueOf(bool1) });
          Jtt.clear();
        }
        for (;;)
        {
          Jtt.add(this);
          Jtu.add(new WeakReference(this));
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d weak check %d, use time %d", new Object[] { Integer.valueOf(Jtt.size()), Integer.valueOf(Jtu.size()), Long.valueOf(System.currentTimeMillis() - l2) });
          i = 1;
          break;
          label887:
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(Jtt.size()) });
          Jtt.clear();
        }
      }
    }
    if ((getIntent() != null) && (z.getBooleanExtra(getIntent(), "LauncherUI.jump_from_uimode_check", false)))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "dancy onCreate uimode check from background, finish LauncherUI");
      finish();
      AppMethodBeat.o(33299);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "onCreate normally");
    this.Jty = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.Jty);
    this.chattingTabUI.nbm = this;
    paramBundle = this.Jty;
    localObject1 = this.chattingTabUI;
    paramBundle.JrI = this;
    paramBundle.Jsx = ((a)localObject1);
    localObject1 = paramBundle.Jsz;
    ((MainTabUI)localObject1).JrI = this;
    ((MainTabUI)localObject1).JxG = paramBundle;
    Object localObject2 = ((MainTabUI)localObject1).JxF;
    ((aa)localObject2).JrI = this;
    ((aa)localObject2).JxT = paramBundle;
    ((MainTabUI)localObject1).mZF = paramBundle;
    paramBundle.Jsy = new h(this, paramBundle);
    NotifyReceiver.WP();
    com.tencent.mm.pluginsdk.h.aO(paramBundle.JrI);
    paramBundle.mActionBar = getSupportActionBar();
    paramBundle.xgg = findViewById(2131296345);
    if (paramBundle.mActionBar != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131099879)));
      }
      paramBundle.mActionBar.hide();
    }
    setRequestedOrientation(1);
    paramBundle.JsA = getResources().getColor(2131100705);
    paramBundle.JsB = Color.alpha(paramBundle.JsA);
    paramBundle = bb.hIK.ay("login_user_name", "");
    this.dzp = getIntent();
    localObject1 = this.JtD;
    ((t)localObject1).Fcf = this.dzp.getBooleanExtra("splash-hack-activity-recreate", false);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", new Object[] { ((t)localObject1).mTag, Boolean.valueOf(((t)localObject1).Fcf) });
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", new Object[] { paramBundle, Boolean.valueOf(bc.aCh()), Boolean.valueOf(Jtv) });
    if (fAC())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "handleExitIntent return");
      AppMethodBeat.o(33299);
      return;
    }
    if ((!Jtv) && ((bc.aCh()) || (!paramBundle.equals(""))))
    {
      Jtw = l1;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.d.cUa));
    }
    label1598:
    for (;;)
    {
      com.tencent.mm.pluginsdk.model.app.q.j(this, "");
      fAA();
      al.aH(this);
      com.tencent.mm.plugin.u.a.c.dBH();
      AppMethodBeat.o(33299);
      return;
      Jtw = l1;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.d.cUa));
      setRequestedOrientation(1);
      bool1 = bc.aCh();
      paramBundle = bb.hIK.ay("login_user_name", "");
      if ((!bool1) && (paramBundle.equals(""))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1492;
        }
        k.IwJ = false;
        break;
      }
      label1492:
      bool1 = false;
      if ((k.IwK) && (k.IwJ))
      {
        Jtx = true;
        bool1 = MMAppMgr.a(this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33290);
            LauncherUI.a(LauncherUI.this);
            LauncherUI.bay();
            com.tencent.mm.pluginsdk.j.a.a.o.bMY();
            LauncherUI.b(LauncherUI.this);
            AppMethodBeat.o(33290);
          }
        });
      }
      for (;;)
      {
        if (bool1) {
          break label1598;
        }
        xr(true);
        Jtx = false;
        com.tencent.mm.pluginsdk.j.a.a.o.bMY();
        com.tencent.mm.plugin.report.service.f.OR(8);
        fAE();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        ar.ay(this.JtH);
        ar.o(this.JtH, 2000L);
        break;
        MMAppMgr.jT(this);
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(33324);
    if (this.chattingTabUI.fAF())
    {
      AppMethodBeat.o(33324);
      return false;
    }
    HomeUI localHomeUI = this.Jty;
    if ((localHomeUI.Jsx == null) || (localHomeUI.Jsx.fAF()))
    {
      AppMethodBeat.o(33324);
      return false;
    }
    localHomeUI.JsS = paramMenu;
    int i = localHomeUI.JrI.getSupportActionBar().getHeight();
    int j = com.tencent.mm.cb.a.ay(localHomeUI.JrI, 2131165296);
    if ((localHomeUI.Jsz.abZ == 3) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()))
    {
      localHomeUI.JsR = paramMenu.add(0, 5, 0, 2131764454);
      if (localHomeUI.JsN == null)
      {
        com.tencent.mm.kiss.a.b.akR();
        localHomeUI.JsN = com.tencent.mm.kiss.a.b.c(localHomeUI.JrI, 2131492929);
        paramMenu = new ViewGroup.LayoutParams(j, i);
        localHomeUI.JsN.setLayoutParams(paramMenu);
        localHomeUI.JsN.setMinimumHeight(i);
        localHomeUI.JsN.setMinimumWidth(j);
        localHomeUI.JsN.setOnLongClickListener(new HomeUI.5(localHomeUI));
        localHomeUI.JsN.setOnClickListener(new HomeUI.6(localHomeUI));
        localHomeUI.JsN.setContentDescription(localHomeUI.getString(2131764454));
      }
      if (localHomeUI.JsD)
      {
        localHomeUI.JsN.findViewById(2131305884).setVisibility(0);
        paramMenu = com.tencent.mm.plugin.story.h.h.BjR;
        com.tencent.mm.plugin.story.h.h.Bo(1L);
      }
      for (;;)
      {
        localHomeUI.JsR.setActionView(localHomeUI.JsN);
        localHomeUI.fAl();
        localHomeUI.fAb();
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.LauncherUI.HomeUI", "onCreateOptionsMenu");
        AppMethodBeat.o(33324);
        return true;
        localHomeUI.JsN.findViewById(2131305884).setVisibility(8);
        paramMenu = com.tencent.mm.plugin.story.h.h.BjR;
        com.tencent.mm.plugin.story.h.h.Bo(0L);
      }
    }
    Object localObject;
    if (i == 0)
    {
      localObject = localHomeUI.JrI.getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels) {
        i = localHomeUI.JrI.getResources().getDimensionPixelSize(2131165251);
      }
    }
    for (;;)
    {
      localHomeUI.JsO = paramMenu.add(0, HomeUI.JsG, 0, 2131764452);
      localHomeUI.JsO.setIcon(2131689494);
      if (localHomeUI.JnY) {
        localHomeUI.JsO.setIcon(2131689501);
      }
      if (localHomeUI.Joo == null)
      {
        localObject = new ViewGroup.LayoutParams(j, i);
        com.tencent.mm.kiss.a.b.akR();
        localHomeUI.Joo = com.tencent.mm.kiss.a.b.c(localHomeUI.JrI, 2131492929);
        localHomeUI.JsM = ((ImageView)localHomeUI.Joo.findViewById(2131300874));
        localHomeUI.Joo.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localHomeUI.Joo.setMinimumHeight(i);
        localHomeUI.Joo.setMinimumWidth(j);
        localHomeUI.JsM.setImageResource(2131689494);
        localHomeUI.JsM.setImageDrawable(ao.e(localHomeUI.JrI.getResources().getDrawable(2131689494), localHomeUI.JrI.getResources().getColor(2131099732)));
        localHomeUI.Joo.setContentDescription(localHomeUI.getString(2131764452));
        localHomeUI.Joo.setOnLongClickListener(new HomeUI.7(localHomeUI));
        localHomeUI.Joo.setOnClickListener(new HomeUI.8(localHomeUI));
        localHomeUI.Joo.post(new HomeUI.9(localHomeUI));
      }
      localHomeUI.JsO.setActionView(localHomeUI.Joo);
      localHomeUI.JsP = paramMenu.add(0, HomeUI.JsH, 0, 2131764451);
      if (localHomeUI.JsJ == null) {
        localHomeUI.JsI = new HomeUI.b(localHomeUI, j, i);
      }
      if (com.tencent.mm.kernel.g.ajP().aiZ()) {
        com.tencent.mm.plugin.newtips.a.dxD().h(localHomeUI.JsI);
      }
      if ((localHomeUI.JnY) && (localHomeUI.JsK != null)) {
        localHomeUI.JsK.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      com.tencent.mm.blink.b.Wq().u(new HomeUI.10(localHomeUI));
      localHomeUI.JsP.setActionView(localHomeUI.JsJ);
      localHomeUI.fAb();
      localHomeUI.JsJ.getLayoutParams().width = j;
      localHomeUI.JsJ.getLayoutParams().height = i;
      break;
      i = localHomeUI.JrI.getResources().getDimensionPixelSize(2131165252);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33314);
    com.tencent.mm.blink.a.Wl();
    super.onDestroy();
    Object localObject = this.Jty;
    ((HomeUI)localObject).Jsz.bRR();
    if (((HomeUI)localObject).Jsy != null)
    {
      h localh = ((HomeUI)localObject).Jsy;
      com.tencent.mm.sdk.b.a.IvT.d(localh.JrO);
      com.tencent.mm.sdk.b.a.IvT.d(localh.JrP);
    }
    if (((HomeUI)localObject).Jsf) {
      Looper.myQueue().removeIdleHandler(((HomeUI)localObject).omO);
    }
    localObject = this.chattingTabUI;
    if ((((NewChattingTabUI)localObject).mPrepareBitmap != null) && (!((NewChattingTabUI)localObject).mPrepareBitmap.isRecycled()))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", new Object[] { ((NewChattingTabUI)localObject).mPrepareBitmap.toString() });
      ((NewChattingTabUI)localObject).mPrepareBitmap.recycle();
    }
    ar.ay(((NewChattingTabUI)localObject).mStartChattingRunnable);
    Looper.myQueue().removeIdleHandler(((NewChattingTabUI)localObject).Jzm);
    fAz();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bu.jr(this), Integer.valueOf(Jtt.size()) });
    AppMethodBeat.o(33314);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(33331);
    super.onMultiWindowModeChanged(paramBoolean);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "alvinluo onMultiWindowModeChanged2 isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    me localme = new me();
    localme.dAF.dAG = paramBoolean;
    com.tencent.mm.sdk.b.a.IvT.l(localme);
    AppMethodBeat.o(33331);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(33301);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", new Object[] { Integer.valueOf(hashCode()), bu.jr(this) });
    this.dzp = paramIntent;
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if ((this.dzp != null) && (z.getBooleanExtra(this.dzp, "LauncherUI.jump_from_uimode_check", false)))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "dancy onNewIntent uimode check from background, finish LauncherUI");
      finish();
      AppMethodBeat.o(33301);
      return;
    }
    com.tencent.mm.pluginsdk.model.app.q.j(this, "");
    if (fAC())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
      AppMethodBeat.o(33301);
      return;
    }
    if ((this.dzp != null) && (z.getBooleanExtra(this.dzp, "Intro_Need_Clear_Top ", false)))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
      finish();
      jM(this);
      AppMethodBeat.o(33301);
      return;
    }
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      closeChatting(false);
    }
    MainTabUI localMainTabUI = this.Jty.Jsz;
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      localMainTabUI.JxH = true;
    }
    if (this.JtA)
    {
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
      bp(paramIntent);
    }
    com.tencent.mm.plugin.u.a.c.dBH();
    AppMethodBeat.o(33301);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int j = 0;
    AppMethodBeat.i(33323);
    HomeUI localHomeUI = this.Jty;
    Object localObject = localHomeUI.JrI.getCurrentFragmet();
    int i;
    if ((localObject != null) && (((MMFragment)localObject).isShowing())) {
      i = j;
    }
    while (i != 0)
    {
      AppMethodBeat.o(33323);
      return true;
      i = j;
      if (!localHomeUI.Jsx.fAF())
      {
        if (paramMenuItem.getItemId() == HomeUI.JsH)
        {
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10919, "0");
          localHomeUI.fAa();
        }
        for (;;)
        {
          i = 1;
          break;
          if (paramMenuItem.getItemId() == HomeUI.JsG)
          {
            localHomeUI.fAc();
          }
          else
          {
            i = j;
            if (paramMenuItem.getItemId() != 5) {
              break;
            }
            if ((com.tencent.mm.sdk.a.b.fnF()) || (ac.iSF))
            {
              localObject = new com.tencent.mm.ui.tools.l(localHomeUI.JrI);
              ((com.tencent.mm.ui.tools.l)localObject).LfS = new HomeUI.11(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).LfT = new HomeUI.13(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).fOP();
            }
            else
            {
              localHomeUI.fAd();
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
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI", "onPause %s, chatting is show ", new Object[] { Integer.valueOf(hashCode()) });
    super.onPause();
    Object localObject1 = this.JtD;
    boolean bool = ((t)localObject1).fb("onPause");
    if (bool) {
      ((t)localObject1).Fcf = false;
    }
    if (bool)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
      AppMethodBeat.o(33311);
      return;
    }
    com.tencent.mm.blink.a.Wl();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "not skip this onPause");
    localObject1 = getCurrentFragmet();
    this.JtG.removeCallbacksAndMessages(null);
    Object localObject2 = this.Jty;
    Object localObject3 = ((HomeUI)localObject2).Jsz;
    bool = ((HomeUI)localObject2).Jsf;
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", new Object[] { Integer.valueOf(((MainTabUI)localObject3).abZ), Boolean.valueOf(bool) });
    if (bool) {
      ((MainTabUI)localObject3).fBf();
    }
    localObject3 = ((MainTabUI)localObject3).JxF;
    if (bc.ajM())
    {
      bc.aCg();
      com.tencent.mm.model.c.ajA().b(((aa)localObject3).JxZ);
      bc.aCg();
      com.tencent.mm.model.c.azL().b((n.b)localObject3);
      com.tencent.mm.y.c.ahI().b(((aa)localObject3).JxY);
      com.tencent.mm.sdk.b.a.IvT.d(((aa)localObject3).Jya);
      com.tencent.mm.sdk.b.a.IvT.d(((aa)localObject3).JqL);
      com.tencent.mm.sdk.b.a.IvT.d(((aa)localObject3).JqK);
    }
    if (((aa)localObject3).JxX != null)
    {
      ((aa)localObject3).JxX.JxU = null;
      ((aa)localObject3).JxX = null;
    }
    localObject3 = ((HomeUI)localObject2).Jsy;
    if (((h)localObject3).JrL != null)
    {
      bc.ajj().b(255, ((h)localObject3).JrL);
      bc.ajj().b(384, ((h)localObject3).JrL);
      ((h)localObject3).JrL = null;
    }
    com.tencent.mm.sdk.a.b.eG(false);
    ((HomeUI)localObject2).Jsw = HomeUI.a.Jth;
    if (!bc.aBZ()) {
      bc.getNotification().cz(false);
    }
    bool = ((HomeUI)localObject2).Jsx.fAF();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show ".concat(String.valueOf(bool)));
    if (!bool) {
      j.a(((HomeUI)localObject2).JrI, 4, ((HomeUI)localObject2).Jsz.abZ, "directReport_onPause");
    }
    if (!((HomeUI)localObject2).JrI.isFinishing()) {
      com.tencent.mm.ui.widget.h.a(((HomeUI)localObject2).JrI);
    }
    if (((HomeUI)localObject2).Jsf)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
      com.tencent.mm.blink.b.Wq().Ws();
      if (bc.ajM()) {
        com.tencent.mm.sdk.b.a.IvT.d(((HomeUI)localObject2).yRT);
      }
    }
    if ((((HomeUI)localObject2).Jsn != null) && (((HomeUI)localObject2).Jsn.isShowing())) {
      ((HomeUI)localObject2).Jsn.dismiss();
    }
    localObject2 = this.chattingTabUI;
    if (((NewChattingTabUI)localObject2).fAF())
    {
      ((NewChattingTabUI)localObject2).md(4);
      if ((((NewChattingTabUI)localObject2).Jzr != null) && (((NewChattingTabUI)localObject2).Jzr.isSupportNavigationSwipeBack())) {
        ((NewChattingTabUI)localObject2).Jzr.getSwipeBackLayout().setEnableGesture(false);
      }
    }
    if (localObject1 != null)
    {
      AppMethodBeat.o(33311);
      return;
    }
    this.JtB = false;
    AppMethodBeat.o(33311);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(33313);
    this.JtF = false;
    Object localObject;
    if (!this.Jtz.a(this, paramInt, paramArrayOfString, paramArrayOfInt))
    {
      localObject = this.Jty;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      localObject = this.chattingTabUI;
      if (((NewChattingTabUI)localObject).Jzr != null) {
        ((NewChattingTabUI)localObject).Jzr.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(33313);
      return;
      if (paramInt == 80) {}
      for (int i = 2131761871; paramArrayOfInt[0] != 0; i = 2131761860)
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).JrI, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.25((HomeUI)localObject), new HomeUI.26((HomeUI)localObject));
        break;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ((HomeUI)localObject).fAc();
      }
      else
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).JrI, ((HomeUI)localObject).getString(2131761869), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.27((HomeUI)localObject), null);
        continue;
        if (paramArrayOfInt[0] == 0)
        {
          localObject = ((HomeUI)localObject).Jsz.fBd();
          if ((localObject instanceof FindMoreFriendsUI)) {
            ((FindMoreFriendsUI)localObject).fzH();
          }
        }
        else
        {
          com.tencent.mm.ui.base.h.a(((HomeUI)localObject).JrI, ((HomeUI)localObject).getString(2131761869), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.28((HomeUI)localObject), null);
          continue;
          if (paramArrayOfInt[0] == 0)
          {
            ((HomeUI)localObject).fAd();
          }
          else
          {
            if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
            for (i = 2131761860;; i = 2131761871)
            {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).JrI, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131755691), false, new HomeUI.29((HomeUI)localObject), new HomeUI.30((HomeUI)localObject));
              break;
            }
            if (paramArrayOfInt[0] == 0) {
              ((HomeUI)localObject).fAd();
            } else {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).JrI, ((HomeUI)localObject).getString(2131761869), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.31((HomeUI)localObject), null);
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
    localNewChattingTabUI.Jzo = paramBundle.getString("last_restore_talker");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", new Object[] { localNewChattingTabUI.Jzo });
    this.JtI = paramBundle.getBoolean("last_stay_chatting");
    this.JtJ = paramBundle.getInt("last_stay_tab");
    if (this.JtI) {
      this.chattingTabUI.startChatting(this.chattingTabUI.Jzo, null, false);
    }
    AppMethodBeat.o(33321);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33303);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    super.onResume();
    if (this.JtD.fb("onResume"))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
      AppMethodBeat.o(33303);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "not skip this onResume");
    Jtv = false;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    long l1;
    Object localObject4;
    Object localObject5;
    label812:
    Object localObject6;
    long l2;
    if (fAB())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", new Object[] { Boolean.valueOf(this.JtA) });
      if (!bc.ajM())
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LauncherUI", "accHasNotReady, kill self");
        finish();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/LauncherUI", "onResume", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/LauncherUI", "onResume", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(33303);
        return;
      }
      if (!this.JtA)
      {
        this.JtA = true;
        localObject1 = this.Jty;
        if ((HomeUI.fAm()) && (HomeUI.fAn()))
        {
          bool1 = true;
          ((HomeUI)localObject1).JsD = bool1;
          localObject2 = ((HomeUI)localObject1).Jsy;
          com.tencent.mm.sdk.b.a.IvT.c(((h)localObject2).JrO);
          com.tencent.mm.sdk.b.a.IvT.c(((h)localObject2).JrP);
          if (!com.tencent.mm.ui.conversation.b.fMT()) {
            getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
          }
          localObject2 = ((HomeUI)localObject1).JrI.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.abv());
          if (((SharedPreferences)localObject2).getBoolean("first_launch_weixin", true))
          {
            ((SharedPreferences)localObject2).edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
          }
          ((HomeUI)localObject1).Jsn = new ae(this);
          ((HomeUI)localObject1).Jsf = true;
          NotifyReceiver.WR();
          bc.getNotification().kQ(1);
          if (bc.ajM()) {
            break label2788;
          }
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
          ((HomeUI)localObject1).JrI.finish();
          bp(getIntent());
        }
      }
      else
      {
        localObject1 = this.Jty;
        l1 = bu.fpO();
        localObject2 = ((HomeUI)localObject1).Jsz;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.MainTabUI", "onResume start :%d", new Object[] { Integer.valueOf(((MainTabUI)localObject2).abZ) });
        if (((MainTabUI)localObject2).JxR.size() != 0)
        {
          localObject4 = ((MainTabUI)localObject2).acx(((MainTabUI)localObject2).abZ);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.MainTabUI", "notifyCurrentTabResumeUI, mCurIndex:%s", new Object[] { Integer.valueOf(((MainTabUI)localObject2).abZ) });
          if (localObject4 != null) {
            ((m)localObject4).fyQ();
          }
          if ((localObject4 != null) && (com.tencent.matrix.b.HS()) && (((MMFragment)localObject4).getActivity() != null))
          {
            localObject5 = ((MMFragment)localObject4).getActivity().getClass().getName();
            com.tencent.matrix.a.cBz.dL((String)localObject5 + "#" + localObject4.getClass().getSimpleName());
          }
        }
        if ((((MainTabUI)localObject2).JxH) && (((MainTabUI)localObject2).JrI.getIntent().hasExtra("isScrollFirst")) && (((MainTabUI)localObject2).JrI.getIntent().hasExtra("isShowHeader")))
        {
          localObject4 = (MainUI)((MainTabUI)localObject2).JxR.get(Integer.valueOf(0));
          if (localObject4 != null)
          {
            bool1 = ((MainTabUI)localObject2).JrI.getIntent().getBooleanExtra("isShowHeader", false);
            boolean bool2 = ((MainTabUI)localObject2).JrI.getIntent().getBooleanExtra("isScrollFirst", true);
            ((MainUI)localObject4).m(bool1, ((MainTabUI)localObject2).JrI.getIntent().getBooleanExtra("isShowHeaderWithAnim", false), bool2);
          }
        }
        if (((MainTabUI)localObject2).JxH)
        {
          ((MainTabUI)localObject2).JxH = false;
          ((MainTabUI)localObject2).aWU("tab_main");
        }
        localObject4 = (MainUI)((MainTabUI)localObject2).JxR.get(Integer.valueOf(0));
        if (localObject4 != null)
        {
          ((MainUI)localObject4).fLW();
          ((MainUI)localObject4).fNC();
        }
        if (((MainTabUI)localObject2).abZ != 0) {
          break label3780;
        }
        bc.getNotification().cz(true);
        localObject4 = (m)((MainTabUI)localObject2).acx(((MainTabUI)localObject2).abZ);
        if (localObject4 != null) {
          ((m)localObject4).fyR();
        }
        ((MainTabUI)localObject2).JxH = false;
        int i = z.getIntExtra(((MainTabUI)localObject2).JrI.getIntent(), "preferred_tab", 0);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI.MainTabUI", "doOnResume, tabIdx = %d", new Object[] { Integer.valueOf(i) });
        if (i != 0)
        {
          ((MainTabUI)localObject2).acw(i);
          ((MainTabUI)localObject2).JrI.getIntent().putExtra("preferred_tab", 0);
        }
        com.tencent.mm.sdk.b.a.IvT.c(((MainTabUI)localObject2).JxM);
        com.tencent.mm.sdk.b.a.IvT.c(((MainTabUI)localObject2).JxO);
        com.tencent.mm.sdk.b.a.IvT.c(((MainTabUI)localObject2).JxP);
        localObject2 = ((MainTabUI)localObject2).JxF;
        if (((aa)localObject2).JxU != null) {
          ((aa)localObject2).JxU.fza();
        }
        if (bc.ajM())
        {
          bc.aCg();
          com.tencent.mm.model.c.ajA().a(((aa)localObject2).JxZ);
          com.tencent.mm.y.c.ahI().a(((aa)localObject2).JxY);
          bc.aCg();
          com.tencent.mm.model.c.azL().a((n.b)localObject2);
          com.tencent.mm.sdk.b.a.IvT.c(((aa)localObject2).JqL);
          com.tencent.mm.sdk.b.a.IvT.c(((aa)localObject2).Jya);
          com.tencent.mm.sdk.b.a.IvT.c(((aa)localObject2).JqK);
        }
        com.tencent.mm.blink.b.Wq().u(new aa.7((aa)localObject2));
        localObject2 = ((HomeUI)localObject1).Jsy;
        localObject6 = new bi();
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject6);
        if ((((bi)localObject6).dnp.dnq) && (!bu.isNullOrNil(((bi)localObject6).dnp.msg)))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.GlobalAlertMgr", "  now show msg:%s", new Object[] { ((bi)localObject6).dnp.msg });
          localObject4 = new com.tencent.mm.ui.widget.a.f.a(((h)localObject2).JrI);
          localObject5 = ((com.tencent.mm.ui.widget.a.f.a)localObject4).au(((h)localObject2).getString(2131755918)).av(((h)localObject2).getString(2131755917));
          localObject6 = ((bi)localObject6).dnp.msg;
          ((com.tencent.mm.ui.widget.a.f.a)localObject5).Fop.aZj((String)localObject6);
          localObject4 = ((com.tencent.mm.ui.widget.a.f.a)localObject4).zi(false).b(new h.2((h)localObject2));
          ((com.tencent.mm.ui.widget.a.f.a)localObject4).EyN = true;
          ((com.tencent.mm.ui.widget.a.f.a)localObject4).show();
        }
        if (!((h)localObject2).a(((h)localObject2).JrK)) {
          bc.ajU().n(new h.6((h)localObject2), 500L);
        }
        ((h)localObject2).JrK = null;
        com.tencent.mm.sdk.a.b.eG(true);
        bool1 = ((HomeUI)localObject1).Jsx.fAF();
        if ((!bool1) && (bc.ajM()))
        {
          com.tencent.mm.blink.b.Wq().u(new HomeUI.37((HomeUI)localObject1));
          if ((com.tencent.mm.bi.d.iup != null) && (com.tencent.mm.bi.d.iuo != null) && (!bu.isNullOrNil(com.tencent.mm.bi.d.iuo.aMJ())))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "launcher onResume end track %s", new Object[] { com.tencent.mm.bi.d.iup.aMK() });
            localObject2 = new fl();
            ((fl)localObject2).drB.username = com.tencent.mm.bi.d.iup.aMK();
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        if (!bool1)
        {
          j.a(((HomeUI)localObject1).JrI, 3, ((HomeUI)localObject1).Jsz.abZ, "directReport_onResume");
          ((HomeUI)localObject1).Jsz.act(260);
        }
        com.tencent.mm.ui.widget.h.b(((HomeUI)localObject1).JrI);
        ((HomeUI)localObject1).JrI.onSwipe(1.0F);
        ((HomeUI)localObject1).Jsw = HomeUI.a.Jtg;
        if (((HomeUI)localObject1).Jsh)
        {
          ((HomeUI)localObject1).Jsh = false;
          ((HomeUI)localObject1).Jsh = false;
        }
        com.tencent.mm.aj.o.aEK();
        l2 = System.currentTimeMillis();
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LauncherUI.HomeUI", "[Launching Application]");
        com.tencent.mm.kernel.l.q(((HomeUI)localObject1).JrI, false);
        com.tencent.mm.kernel.l.r(((HomeUI)localObject1).JrI, false);
        long l3 = System.currentTimeMillis();
        if (!((HomeUI)localObject1).JrI.getSharedPreferences(ak.fow(), 0).getBoolean("settings_landscape_mode", false)) {
          break label3792;
        }
        ((HomeUI)localObject1).JrI.setRequestedOrientation(-1);
        label1547:
        long l4 = System.currentTimeMillis();
        if (getInstance() != null)
        {
          com.tencent.mm.blink.b.Wq().Wt();
          ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("showprivacypolicy", ((HomeUI)localObject1).JsX);
          ((HomeUI)localObject1).xn(false);
          com.tencent.mm.sdk.b.a.IvT.c(((HomeUI)localObject1).yRT);
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - l4));
          if (bc.ajM()) {
            ((HomeUI)localObject1).fAl();
          }
        }
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.LauncherUI.HomeUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - l3));
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI.HomeUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - l2));
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "initView " + (System.currentTimeMillis() - l1));
        if (((HomeUI)localObject1).Jsh)
        {
          ((HomeUI)localObject1).Jsh = false;
          ((HomeUI)localObject1).Jsh = false;
        }
        localObject2 = com.tencent.mm.app.w.Mt();
        ((com.tencent.mm.app.w)localObject2).cVC = true;
        ((com.tencent.mm.app.w)localObject2).cVD.removeMessages(-1999);
        ((com.tencent.mm.app.w)localObject2).cVD.removeMessages(-2999);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - l1));
        if (com.tencent.mm.model.v.aBt().booleanValue()) {
          ((HomeUI)localObject1).fzZ();
        }
        i = com.tencent.mm.kernel.g.ajR().ajA().getInt(am.a.Jaq, 0);
        if (i != 0)
        {
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jaq, Integer.valueOf(0));
          if (com.tencent.mm.model.v.aBi()) {}
        }
        switch (i)
        {
        default: 
          label1884:
          com.tencent.mm.blink.b.Wq().u(new HomeUI.2((HomeUI)localObject1));
          if (((HomeUI)localObject1).getMainTabUI().abZ != 3)
          {
            localObject1 = (MoreTabUI)((HomeUI)localObject1).getMainTabUI().acx(3);
            if ((((MoreTabUI)localObject1).Jyi != null) && (!((MoreTabUI)localObject1).Jyi.isVisible))
            {
              ((MoreTabUI)localObject1).Jyi.fQY();
              ((MoreTabUI)localObject1).dDO();
            }
          }
          localObject1 = this.chattingTabUI;
          ((NewChattingTabUI)localObject1).Jzj = bu.aRi();
          if (((NewChattingTabUI)localObject1).fBB())
          {
            ((NewChattingTabUI)localObject1).Jzm = new NewChattingTabUI.1((NewChattingTabUI)localObject1);
            ar.o(new NewChattingTabUI.2((NewChattingTabUI)localObject1), 500L);
          }
          if (((NewChattingTabUI)localObject1).fAF())
          {
            ((NewChattingTabUI)localObject1).md(3);
            if ((((NewChattingTabUI)localObject1).Jzr != null) && (((NewChattingTabUI)localObject1).Jzr.isSupportNavigationSwipeBack())) {
              ((NewChattingTabUI)localObject1).Jzr.getSwipeBackLayout().setEnableGesture(true);
            }
            label2053:
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "resumeNormalJump");
            MMFragmentActivity.a.fBb();
            if (("pushcontent_notification".equals(z.getStringExtra(getIntent(), "nofification_type"))) && (!bu.isNullOrNil(z.getStringExtra(getIntent(), "Main_FromUserName"))))
            {
              localObject1 = z.getStringExtra(getIntent(), "Main_FromUserName");
              i = z.getIntExtra(getIntent(), "MainUI_User_Last_Msg_Type", 0);
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + (String)localObject1 + i);
              com.tencent.mm.plugin.report.service.g.yxI.f(10856, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(0) });
            }
            localObject1 = z.getStringExtra(getIntent(), "LauncherUI.Shortcut.LaunchType");
            if (localObject1 != null)
            {
              if (!((String)localObject1).equals("launch_type_voip")) {
                break label3879;
              }
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
              localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.g.yxI.f(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
            }
            label2337:
            localObject1 = z.getStringExtra(getIntent(), "LauncherUI.switch.tab");
            if (!bu.isNullOrNil((String)localObject1))
            {
              this.Jty.getMainTabUI().aWU((String)localObject1);
              getIntent().putExtra("LauncherUI.switch.tab", "");
            }
            if ((z.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) || (this.JtC))
            {
              this.JtC = false;
              localObject1 = getInstance();
              if (localObject1 != null) {
                ((LauncherUI)localObject1).Jty.fAf();
              }
              getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
              getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
            }
            bool1 = z.getBooleanExtra(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
            if (!bool1) {
              break label4021;
            }
            localObject1 = z.getStringExtra(getIntent(), "LauncherUI.Shortcut.Username");
            label2481:
            if (bool1)
            {
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = ".concat(String.valueOf(localObject1)));
              if (!bu.isNullOrNil((String)localObject1))
              {
                localObject4 = com.tencent.mm.plugin.base.model.b.Xe((String)localObject1);
                if (!bu.isNullOrNil((String)localObject4))
                {
                  if (x.An((String)localObject4))
                  {
                    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                    if (!com.tencent.mm.al.g.Eq((String)localObject4)) {
                      break label4327;
                    }
                    if (!com.tencent.mm.al.g.vz((String)localObject4)) {
                      break label4045;
                    }
                    localObject1 = new Intent();
                    ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                    ((Intent)localObject1).putExtra("Contact_User", (String)localObject4);
                    ((Intent)localObject1).putExtra("biz_chat_from_scene", 9);
                    ((Intent)localObject1).addFlags(67108864);
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                  label2673:
                  getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
                  getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
                }
              }
            }
            this.JtB = true;
            label2702:
            com.tencent.mm.blink.a.kL(5);
            if (!Jtx) {
              xr(false);
            }
            fAA();
            localObject1 = (com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class);
            if (localObject1 == null) {
              break label4362;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, try to fix");
            ((com.tencent.mm.plugin.ball.c.c)localObject1).bKX();
          }
          break;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).deA();
        com.tencent.mm.plugin.base.stub.f.bNe();
        com.tencent.mm.blink.a.uw("LauncherUI");
        AppMethodBeat.o(33303);
        return;
        bool1 = false;
        break;
        label2788:
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
        l1 = System.currentTimeMillis();
        l2 = System.currentTimeMillis();
        MMActivity.initLanguage(((HomeUI)localObject1).JrI);
        try
        {
          localObject2 = new HashSet();
          localObject4 = ((HomeUI)localObject1).getString(2131757953).split(";");
          ((Set)localObject2).add(localObject4[0]);
          ((Set)localObject2).add(localObject4[1]);
          com.tencent.mm.model.w.f((Set)localObject2);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajU().aw(new HomeUI.15((HomeUI)localObject1));
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).jiz = ((LayoutInflater)((HomeUI)localObject1).JrI.getSystemService("layout_inflater"));
          l2 = System.currentTimeMillis();
          com.tencent.mm.kiss.a.b.akR();
          ((HomeUI)localObject1).contentView = com.tencent.mm.kiss.a.b.c(((HomeUI)localObject1).JrI, 2131494684);
          if ((((HomeUI)localObject1).contentView != null) && (Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.abu())) {
            ((HomeUI)localObject1).contentView.setBackgroundColor(((HomeUI)localObject1).JrI.getResources().getColor(2131100705));
          }
          com.tencent.mm.blink.b.Wq().Wr();
          ((FirstScreenFrameLayout)((HomeUI)localObject1).contentView.findViewById(2131300113)).fFK = new HomeUI.23((HomeUI)localObject1);
          com.tencent.mm.pluginsdk.model.app.ao.fdT();
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).JrI.setContentView(((HomeUI)localObject1).contentView);
          Looper.myQueue().addIdleHandler(((HomeUI)localObject1).omO);
          ((HomeUI)localObject1).Jsg = true;
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI.HomeUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI.HomeUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).initActionBar();
          ((HomeUI)localObject1).mActionBar.show();
          ((HomeUI)localObject1).contentView.post(new HomeUI.33((HomeUI)localObject1));
          com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - l1));
          ar.o(new HomeUI.34((HomeUI)localObject1), 2000L);
          ((HomeUI)localObject1).contentView.addOnLayoutChangeListener(((HomeUI)localObject1).JsF);
          com.tencent.mm.pluginsdk.h.b(((HomeUI)localObject1).JrI, ((HomeUI)localObject1).contentView);
          ((HomeUI)localObject1).contentView.postDelayed(new HomeUI.35((HomeUI)localObject1), 20L);
          localObject5 = ((HomeUI)localObject1).Jsz;
          ((MainTabUI)localObject5).mViewPager = ((CustomViewPager)((MainTabUI)localObject5).JrI.findViewById(2131303135));
          ((MainTabUI)localObject5).mViewPager.setOffscreenPageLimit(4);
          ((MainTabUI)localObject5).mViewPager.setCanSlide(true);
          ((MainTabUI)localObject5).mViewPager.setCanSlideBySide(false);
          ((MainTabUI)localObject5).mTabsAdapter = new MainTabUI.TabsAdapter((MainTabUI)localObject5, ((MainTabUI)localObject5).JrI, ((MainTabUI)localObject5).mViewPager);
          if (getInstance() != null)
          {
            ((MainTabUI)localObject5).acw(getInstance().JtJ);
            localObject2 = ((MainTabUI)localObject5).JxF;
            localObject4 = (ViewGroup)((MainTabUI)localObject5).mViewPager.getParent();
            localObject5 = ((MainTabUI)localObject5).mTabsAdapter;
            localObject6 = ((aa)localObject2).JxU;
            if (((aa)localObject2).JxU != null)
            {
              ((aa)localObject2).JxU.setOnTabClickListener(null);
              ((View)((aa)localObject2).JxU).setVisibility(8);
              if (localObject4 != null) {
                ((ViewGroup)localObject4).removeView((View)((aa)localObject2).JxU);
              }
            }
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
            LauncherUIBottomTabView localLauncherUIBottomTabView = new LauncherUIBottomTabView(((aa)localObject2).JrI);
            localLauncherUIBottomTabView.setId(2131301338);
            if (localObject4 != null)
            {
              localLayoutParams.gravity = 80;
              ((ViewGroup)localObject4).addView(localLauncherUIBottomTabView, localLayoutParams);
            }
            ((aa)localObject2).JxU = localLauncherUIBottomTabView;
            ((View)((aa)localObject2).JxU).setVisibility(0);
            ((aa)localObject2).JxU.setOnTabClickListener((c.a)localObject5);
            if ((localObject6 != null) && (localObject6 != ((aa)localObject2).JxU))
            {
              ((aa)localObject2).JxU.xf(((c)localObject6).getShowFriendPoint());
              ((aa)localObject2).JxU.xg(((c)localObject6).getSettingsPoint());
              ((aa)localObject2).JxU.aca(((c)localObject6).getMainTabUnread());
              ((aa)localObject2).JxU.acb(((c)localObject6).getContactTabUnread());
              ((aa)localObject2).JxU.acc(((c)localObject6).getFriendTabUnread());
              ((aa)localObject2).JxU.acd(((c)localObject6).getSettingsTabUnread());
              ((aa)localObject2).JxU.setTo(((c)localObject6).getCurIdx());
            }
            ((HomeUI)localObject1).Jsz.JxL = new HomeUI.1((HomeUI)localObject1);
            com.tencent.e.h.MqF.aO(new HomeUI.12((HomeUI)localObject1));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
            continue;
            ((MainTabUI)localObject5).acw(0);
          }
        }
      }
      label3780:
      bc.getNotification().cz(false);
      break label812;
      label3792:
      ((HomeUI)localObject1).JrI.setRequestedOrientation(1);
      break label1547;
      com.tencent.mm.ui.base.h.a(((HomeUI)localObject1).JrI, ((HomeUI)localObject1).getString(2131760750), "", new HomeUI.38((HomeUI)localObject1), null);
      break label1884;
      if (!((NewChattingTabUI)localObject1).Jzu) {
        break label2053;
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LauncherUI.NewChattingTabUI", "[onResume] need exec this runnable!");
      ar.ay(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      ar.f(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      ((NewChattingTabUI)localObject1).Jzu = false;
      break label2053;
      label3879:
      if (!((String)localObject1).equals("launch_type_voip_audio")) {
        break label2337;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
      localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.g.yxI.f(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      break label2337;
      label4021:
      bool1 = z.getBooleanExtra(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
      localObject1 = getIntent().getAction();
      break label2481;
      label4045:
      if (com.tencent.mm.al.g.Es((String)localObject4))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject1).putExtra("enterprise_biz_name", (String)localObject4);
        ((Intent)localObject1).putExtra("enterprise_biz_display_name", com.tencent.mm.model.w.zP((String)localObject4));
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break label2673;
      }
      if (com.tencent.mm.al.g.Et((String)localObject4))
      {
        localObject1 = com.tencent.mm.al.g.eX((String)localObject4);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).Kz())
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
      break label2673;
      label4327:
      localObject1 = getInstance();
      if (localObject1 == null) {
        break label2673;
      }
      ((LauncherUI)localObject1).startChatting((String)localObject4, null, false);
      break label2673;
      if (Jtx) {
        break label2702;
      }
      fAE();
      break label2702;
      label4362:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, service is null");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(33322);
    Object localObject = this.chattingTabUI;
    if (((NewChattingTabUI)localObject).Jzr != null)
    {
      localObject = ((NewChattingTabUI)localObject).Jzr.cXJ.getTalkerUserName();
      if (!bu.isNullOrNil((String)localObject))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.NewChattingTabUI", "onSaveInstanceState:%s", new Object[] { localObject });
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
    if ((this.JtA) && (!this.chattingTabUI.aa(paramBoolean, paramInt))) {
      super.onSettle(paramBoolean, paramInt);
    }
    AppMethodBeat.o(33318);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(33312);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.blink.a.Wl();
    HomeUI localHomeUI = this.Jty;
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("showprivacypolicy", localHomeUI.JsX);
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
    if (this.JtA)
    {
      localNewChattingTabUI = this.chattingTabUI;
      if ((localNewChattingTabUI.Jzi == null) || (!localNewChattingTabUI.Jzi.fAg())) {
        break label108;
      }
      bool = true;
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", new Object[] { Float.valueOf(paramFloat), Long.valueOf(260L), Boolean.valueOf(bool) });
      if (localNewChattingTabUI.fBB()) {
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
        localNewChattingTabUI.acB(0);
        localObject = (ImageView)localNewChattingTabUI.nbm.getWindow().getDecorView().findViewById(2131303386);
        if (localObject != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE no cache!");
          ((ImageView)localObject).setVisibility(8);
          ((ImageView)localObject).setImageDrawable(null);
        }
        if (localNewChattingTabUI.mChattingInAnim != null) {
          localNewChattingTabUI.mChattingInAnim.cancel();
        }
      }
      for (;;)
      {
        if (!localNewChattingTabUI.Jzi.fAg())
        {
          if (Float.compare(1.0F, paramFloat) > 0)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Boolean.FALSE });
            i = 0;
            break;
            if ((paramFloat != 1.0F) || (localNewChattingTabUI.mChattingClosed) || (localNewChattingTabUI.Jzr.fEW())) {
              continue;
            }
            localNewChattingTabUI.nbm.getWindow().setBackgroundDrawableResource(2131100810);
            localObject = (ImageView)localNewChattingTabUI.nbm.getWindow().getDecorView().findViewById(2131303386);
            if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0) && (((ImageView)localObject).getTag() != null))
            {
              ((View)((ImageView)localObject).getTag()).setVisibility(0);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
              ((ImageView)localObject).setVisibility(8);
              ((ImageView)localObject).setVisibility(8);
            }
            if ((localNewChattingTabUI.Jzr.getContentView() != null) && (localNewChattingTabUI.Jzr.getContentView().getX() <= 0.0F))
            {
              localNewChattingTabUI.acB(8);
              continue;
            }
            localNewChattingTabUI.acB(0);
            continue;
          }
          j = 0;
        }
      }
      i = j;
      if (localNewChattingTabUI.nbm != null)
      {
        localObject = localNewChattingTabUI.nbm.findViewById(2131301337);
        ImageView localImageView = (ImageView)localNewChattingTabUI.nbm.findViewById(2131303386);
        if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null) && (!localNewChattingTabUI.mChattingClosed) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
        {
          localImageView.setVisibility(0);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
          localNewChattingTabUI.acB(8);
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
    if (((NewChattingTabUI)localObject3).Jzr != null)
    {
      localObject1 = localObject2;
      if (((NewChattingTabUI)localObject3).Jzr.fEY() != null)
      {
        if (((NewChattingTabUI)localObject3).Jzr.isSupportCustomActionBar()) {
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
      if (!com.tencent.mm.compatible.util.d.lC(22))
      {
        localObject3 = ((NewChattingTabUI)localObject3).Jzr.fEY().startActionMode(paramCallback);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject3;
        }
      }
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(186969);
    if ((paramIntent != null) && (paramIntent.getComponent() != null))
    {
      com.tencent.mm.ui.tools.w localw = com.tencent.mm.ui.tools.w.Lim;
      com.tencent.mm.ui.tools.w.aYQ(paramIntent.getComponent().getClassName());
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(186969);
  }
  
  public final void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(33329);
    this.Jty.fAe();
    this.chattingTabUI.startChatting(paramString, paramBundle, paramBoolean);
    AppMethodBeat.o(33329);
  }
  
  static abstract interface a
  {
    public abstract boolean fAF();
  }
  
  static abstract interface b
  {
    public abstract void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup);
    
    public abstract boolean fAg();
    
    public abstract void fAi();
    
    public abstract void fAj();
  }
  
  static abstract interface c
  {
    public abstract void fAh();
  }
  
  static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI
 * JD-Core Version:    0.7.0.1
 */