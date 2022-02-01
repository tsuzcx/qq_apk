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
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.md;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.account.ui.WelcomeActivity;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bq;
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
  private static ArrayList<LauncherUI> IYL;
  private static ArrayList<WeakReference<LauncherUI>> IYM;
  private static boolean IYN;
  public static long IYO;
  private static boolean IYP;
  private static boolean IYW;
  public HomeUI IYQ;
  private n IYR;
  public boolean IYS;
  boolean IYT;
  private boolean IYU;
  private t IYV;
  private boolean IYX;
  private ap IYY;
  private Runnable IYZ;
  private boolean IZa;
  int IZb;
  private NewChattingTabUI chattingTabUI;
  private Intent dyk;
  
  static
  {
    AppMethodBeat.i(33334);
    IYL = new ArrayList();
    IYM = new ArrayList();
    IYN = true;
    IYP = false;
    IYW = false;
    AppMethodBeat.o(33334);
  }
  
  public LauncherUI()
  {
    AppMethodBeat.i(33295);
    this.IYQ = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.IYQ);
    this.IYR = new n();
    this.dyk = null;
    this.IYS = false;
    this.IYT = false;
    this.IYU = false;
    this.IYV = new t("MicroMsg.LauncherUI");
    this.IYX = false;
    this.IYY = new ap();
    this.IYZ = new Runnable()
    {
      long gW = 2000L;
      
      @TargetApi(17)
      public final void run()
      {
        AppMethodBeat.i(33293);
        ad.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
        aq.aA(this);
        if (com.tencent.mm.model.ba.aBR())
        {
          com.tencent.mm.kernel.g.ajA();
          ad.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()) });
          AppMethodBeat.o(33293);
          return;
        }
        if ((com.tencent.mm.modelstat.d.aLC()) || (com.tencent.mm.sdk.a.b.foreground))
        {
          this.gW += 2000L;
          if (this.gW > 10000L) {
            this.gW = 2000L;
          }
          ad.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelstat.d.aLC()), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground), Long.valueOf(this.gW) });
          aq.o(this, this.gW);
          AppMethodBeat.o(33293);
          return;
        }
        ad.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit!!!");
        if (WXHardCoderJNI.isCheckEnv()) {
          com.tencent.mm.sdk.g.b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33292);
              WXHardCoderJNI.terminateApp(Process.myTid(), SystemClock.elapsedRealtimeNanos());
              ad.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp done");
              AppMethodBeat.o(33292);
            }
          }, "terminateApp");
        }
        ad.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit app done");
        AppMethodBeat.o(33293);
      }
    };
    this.IZa = false;
    this.IZb = 0;
    AppMethodBeat.o(33295);
  }
  
  private void bo(Intent paramIntent)
  {
    AppMethodBeat.i(33307);
    ad.i("MicroMsg.LauncherUI", "handleJump");
    if (!com.tencent.mm.model.ba.ajx())
    {
      ad.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
      paramIntent = new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahp(), "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(33307);
      return;
    }
    Object localObject1 = new la();
    ((la)localObject1).dyj.dyk = this.dyk;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    if ("talkroom_notification".equals(com.tencent.mm.sdk.platformtools.y.getStringExtra(paramIntent, "nofification_type")))
    {
      paramIntent = com.tencent.mm.sdk.platformtools.y.getStringExtra(paramIntent, "enter_chat_usrname");
      if (!bt.isNullOrNil(paramIntent))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enter_room_username", paramIntent);
        ((Intent)localObject1).setFlags(268435456);
        com.tencent.mm.bs.d.b(this, "talkroom", ".ui.TalkRoomUI", (Intent)localObject1);
      }
      AppMethodBeat.o(33307);
      return;
    }
    if ("back_to_pcmgr_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      if (!paramIntent.getBooleanExtra("newPCBackup", true)) {
        ad.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BakToPcUI");
      }
      for (paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");; paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI"))
      {
        paramIntent.setFlags(268435456);
        MMWizardActivity.al(this, paramIntent);
        AppMethodBeat.o(33307);
        return;
        ad.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
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
    if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(paramIntent, "show_update_dialog", false)) {
      bp(paramIntent);
    }
    String str = com.tencent.mm.sdk.platformtools.y.getStringExtra(paramIntent, "Main_User");
    localObject1 = com.tencent.mm.sdk.platformtools.y.getStringExtra(paramIntent, "nofification_type");
    ad.i("MicroMsg.LauncherUI", "[handleJump] user:%s", new Object[] { str });
    Object localObject2;
    int i;
    if ((str != null) && (!str.equals("")))
    {
      com.tencent.mm.model.ba.aBQ();
      localObject2 = com.tencent.mm.model.c.azv().aTz(str);
      if (localObject2 != null)
      {
        i = ((com.tencent.mm.g.c.ba)localObject2).field_unReadCount;
        ad.i("MicroMsg.LauncherUI", "[oneliang] user:%s, conversation :%s, unReadCount:%s", new Object[] { str, localObject2, Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0) {
        j = com.tencent.mm.sdk.platformtools.y.getIntExtra(paramIntent, "pushcontent_unread_count", 0);
      }
      MMAppMgr.MU();
      com.tencent.mm.sdk.b.a.IbL.l(new af());
      boolean bool = com.tencent.mm.sdk.platformtools.y.getBooleanExtra(paramIntent, "Intro_Is_Muti_Talker", true);
      ad.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((!bool) && (j > 0))
      {
        i = com.tencent.mm.sdk.platformtools.y.getIntExtra(paramIntent, "Intro_Bottle_unread_count", 0);
        if (i > 0)
        {
          ad.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.bs.d.Q(this, "bottle", ".ui.BottleConversationUI");
        }
      }
      if (!bool)
      {
        if (w.zU(str))
        {
          ad.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("type", 20);
          com.tencent.mm.bs.d.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
        }
        for (;;)
        {
          if (com.tencent.mm.sdk.platformtools.y.getIntExtra(paramIntent, "kstyle_show_bind_mobile_afterauth", 0) > 0)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMobileUI");
            ((Intent)localObject1).putExtra("kstyle_bind_recommend_show", paramIntent.getIntExtra("kstyle_bind_recommend_show", 0));
            ((Intent)localObject1).putExtra("kstyle_bind_wording", paramIntent.getParcelableExtra("kstyle_bind_wording"));
            MMWizardActivity.al(this, (Intent)localObject1);
          }
          AppMethodBeat.o(33307);
          return;
          if (!w.Ac(str)) {
            break;
          }
          ad.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("type", 11);
          com.tencent.mm.bs.d.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
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
        if ("new_msg_nofification".equals(com.tencent.mm.sdk.platformtools.y.getStringExtra(paramIntent, "nofification_type")))
        {
          ((Bundle)localObject1).putInt("chat_from_scene", 1);
          ((Bundle)localObject1).putBoolean("key_can_show_message_float_ball", true);
        }
        localObject2 = getInstance();
        if (localObject2 == null) {
          break;
        }
        if (com.tencent.mm.am.g.vd(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("biz_chat_from_scene", 4);
          com.tencent.mm.bs.d.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if (com.tencent.mm.am.g.DR(str))
        {
          localObject1 = com.tencent.mm.am.g.eS(str);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).Kr())
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
            com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", paramIntent);
            break;
          }
        }
        if (am.yt(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("app_brand_conversation_from_scene", 3);
          paramIntent.putExtra("finish_direct", true);
          paramIntent.putExtra("key_need_send_video", false);
          com.tencent.mm.bs.d.f(this, ".ui.conversation.AppBrandServiceConversationUI", paramIntent);
          break;
        }
        ((LauncherUI)localObject2).startChatting(str, (Bundle)localObject1, false);
        break;
        if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(paramIntent, "From_fail_notify", false))
        {
          if (!bt.isNullOrNil(str))
          {
            localObject1 = getInstance();
            if (localObject1 == null) {
              break;
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putBoolean("Chat_Mode", com.tencent.mm.sdk.platformtools.y.getBooleanExtra(paramIntent, "resend_fail_messages", false));
            if (com.tencent.mm.am.g.vd(str))
            {
              paramIntent.putExtra("Contact_User", str);
              paramIntent.addFlags(67108864);
              paramIntent.putExtra("biz_chat_from_scene", 4);
              com.tencent.mm.bs.d.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
              break;
            }
            ((LauncherUI)localObject1).startChatting(str, (Bundle)localObject2, false);
            break;
          }
          if (!com.tencent.mm.sdk.platformtools.y.getBooleanExtra(paramIntent, "jump_sns_from_notify", false)) {
            break;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("is_need_resend_sns", paramIntent.getBooleanExtra("is_need_resend_sns", false));
          ((Intent)localObject1).putExtra("sns_resume_state", paramIntent.getBooleanExtra("sns_resume_state", false));
          ((Intent)localObject1).putExtra("sns_timeline_NeedFirstLoadint", paramIntent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
          com.tencent.mm.bs.d.b(this, "sns", ".ui.SnsTimeLineUI", (Intent)localObject1);
          break;
        }
        if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(paramIntent, "biz_chat_need_to_jump_to_chatting_ui", false))
        {
          if ((getInstance() == null) || (!com.tencent.mm.am.g.vd(str))) {
            break;
          }
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          com.tencent.mm.bs.d.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if ((bt.isNullOrNil(str)) || (!"new_msg_nofification".equals(localObject1))) {
          break;
        }
        if (paramIntent == null) {}
        for (localObject1 = "null";; localObject1 = paramIntent)
        {
          ad.w("MicroMsg.LauncherUI", "[handleJump] intent:%s", new Object[] { localObject1 });
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
        ad.w("MicroMsg.LauncherUI", "LauncherUI.getInstance is null! ");
        break;
      }
      i = 0;
      break;
      i = 0;
    }
  }
  
  private void bp(Intent paramIntent)
  {
    AppMethodBeat.i(33315);
    int i = com.tencent.mm.sdk.platformtools.y.getIntExtra(paramIntent, "update_type", -1);
    if (i == -1)
    {
      ad.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
      AppMethodBeat.o(33315);
      return;
    }
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(405L, 28L, 1L, true);
    com.tencent.mm.plugin.report.service.g localg;
    if (com.tencent.mm.plugin.q.d.doy() != null)
    {
      paramIntent = com.tencent.mm.plugin.q.d.doy().c(this, null);
      if (paramIntent == null)
      {
        AppMethodBeat.o(33315);
        return;
      }
      localg = com.tencent.mm.plugin.report.service.g.yhR;
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
  
  private void fwA()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33300);
    ad.d("MicroMsg.LauncherUI", "[whatsnew] checkIfStartWhatsNew.");
    if (IYW)
    {
      ad.i("MicroMsg.LauncherUI", "[whatsnew] has been played.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!com.tencent.mm.kernel.g.ajA().aiK())
    {
      com.tencent.mm.kernel.g.ajA();
      if (!com.tencent.mm.kernel.a.aiJ())
      {
        ad.i("MicroMsg.LauncherUI", "[whatsnew] not login yet, skip.");
        AppMethodBeat.o(33300);
        return;
      }
      ad.i("MicroMsg.LauncherUI", "[whatsnew] account not initiate, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!fwB())
    {
      ad.i("MicroMsg.LauncherUI", "[whatsnew] notSwitchOrHold is false, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    boolean bool3 = com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI.enter_from_reg", false);
    boolean bool4;
    boolean bool1;
    if ((!bool3) && (com.tencent.mm.pluginsdk.i.f.EOZ != null) && (com.tencent.mm.pluginsdk.i.f.EOZ.Ne()) && (com.tencent.mm.model.ba.ajx()))
    {
      if (an.aQu("show_whatsnew"))
      {
        IYW = true;
        ad.i("MicroMsg.LauncherUI", "[whatsnew] show whatsnew.");
        MMAppMgr.bc(this);
        com.tencent.mm.blink.a.Wd();
        AppMethodBeat.o(33300);
      }
    }
    else
    {
      com.tencent.mm.pluginsdk.i.f.a locala = com.tencent.mm.pluginsdk.i.f.EOZ;
      bool4 = com.tencent.mm.model.ba.ajx();
      if (locala != null) {
        break label262;
      }
      bool1 = true;
      if ((locala == null) || (!locala.Ne())) {
        break label267;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.LauncherUI", "[whatsnew] do not show whatsnew. enter_from_reg=%s accHasReady=%s MMAppMgr is null %s isWhatsNewAvailable=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      AppMethodBeat.o(33300);
      return;
      label262:
      bool1 = false;
      break;
      label267:
      bool2 = false;
    }
  }
  
  private boolean fwB()
  {
    AppMethodBeat.i(33304);
    if ((this.dyk != null) && (!com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.dyk, "Intro_Switch", false)) && (com.tencent.mm.model.ba.aBR()) && (!com.tencent.mm.model.ba.aiE()))
    {
      AppMethodBeat.o(33304);
      return true;
    }
    AppMethodBeat.o(33304);
    return false;
  }
  
  private boolean fwC()
  {
    AppMethodBeat.i(33305);
    if (this.dyk != null)
    {
      Object localObject1;
      Object localObject2;
      if ((com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.dyk, "absolutely_exit", false)) || (com.tencent.mm.sdk.platformtools.y.getIntExtra(this.dyk, "absolutely_exit_pid", 0) == Process.myPid()))
      {
        ad.w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        finish();
        com.tencent.mm.plugin.report.service.f.Ol(8);
        MMAppMgr.xm(com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.dyk, "kill_service", true));
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "java/lang/System_EXEC_", "exit", "(I)V");
        AppMethodBeat.o(33305);
        return true;
      }
      if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.dyk, "can_finish", false))
      {
        ad.i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
        com.tencent.mm.model.ba.aiU().eD(true);
        if (com.tencent.mm.kernel.l.cm(getApplicationContext())) {
          com.tencent.mm.booter.b.bH(getApplicationContext());
        }
        com.tencent.mm.plugin.report.service.f.Ol(8);
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), "com.tencent.mm.permission.MM_MESSAGE");
        finish();
        com.tencent.mm.ui.base.b.ke(this);
        AppMethodBeat.o(33305);
        return true;
      }
      if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.dyk, "exit_and_restart", false))
      {
        Mars.onSingalCrash(0);
        ad.i("MicroMsg.LauncherUI", "exit and restart myself.");
        ad.fku();
        finish();
        localObject1 = new Intent(this, LauncherUI.class);
        ((Intent)localObject1).addFlags(67108864);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ad.i("MicroMsg.LauncherUI", "restart, try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        MMAppMgr.fwY();
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(33305);
        return true;
      }
    }
    AppMethodBeat.o(33305);
    return false;
  }
  
  private void fwD()
  {
    AppMethodBeat.i(33306);
    ad.i("MicroMsg.LauncherUI", "switch to wxid %s", new Object[] { aj.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "") });
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).addFlags(536870912);
    ((Intent)localObject).putExtra("key_scene", 1);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.kf(this);
    AppMethodBeat.o(33306);
  }
  
  private void fwE()
  {
    AppMethodBeat.i(33308);
    ad.i("MicroMsg.LauncherUI", "resumeLogoutJump");
    if ((this.dyk != null) && (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI.jump_from_uimode_check", false)))
    {
      ad.i("MicroMsg.LauncherUI", "dancy uimode check from background, not jumpToLogin or welcome!");
      AppMethodBeat.o(33308);
      return;
    }
    MMFragmentActivity.a.fwZ();
    Object localObject = az.hFS.ax("login_user_name", "");
    if ((!com.tencent.mm.model.ba.aBR()) && (((String)localObject).equals("")))
    {
      localObject = new Intent(this, WelcomeActivity.class);
      ((Intent)localObject).addFlags(536870912);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kf(this);
      ad.i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
      aq.aA(this.IYZ);
      aq.o(this.IYZ, 2000L);
      AppMethodBeat.o(33308);
      return;
    }
    if ((this.dyk.getFlags() & 0x4000000) == 67108864) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.dyk, "Intro_Notify", false);
      ad.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", new Object[] { Boolean.valueOf(this.IYS), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(com.tencent.mm.model.ba.aiE()) });
      ad.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", new Object[] { Boolean.valueOf(com.tencent.mm.model.ba.aBR()) });
      com.tencent.mm.model.ba.hold();
      if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
        this.IYU = true;
      }
      jE(this);
      com.tencent.mm.model.ba.unhold();
      AppMethodBeat.o(33308);
      return;
    }
  }
  
  private void fwz()
  {
    AppMethodBeat.i(33298);
    int i = IYL.indexOf(this);
    if (i >= 0) {
      IYL.remove(i);
    }
    ad.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(IYL.size()), Integer.valueOf(hashCode()) });
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
    if (IYL.isEmpty())
    {
      ad.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", new Object[] { bt.flS() });
      AppMethodBeat.o(33296);
      return null;
    }
    LauncherUI localLauncherUI = (LauncherUI)IYL.get(0);
    AppMethodBeat.o(33296);
    return localLauncherUI;
  }
  
  private void jE(Context paramContext)
  {
    AppMethodBeat.i(33309);
    if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.dyk, "LauncherUI.jump_switch_account", false))
    {
      ad.i("MicroMsg.LauncherUI", "launcher to switch account");
      fwD();
      AppMethodBeat.o(33309);
      return;
    }
    if ((com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.dyk, "Intro_Switch", false)) || (this.IYS) || (com.tencent.mm.kernel.a.ait()))
    {
      this.IYQ.getMainTabUI().bQQ();
      com.tencent.mm.kernel.g.ajD().wZ("[normal logout]");
      Mars.onSingalCrash(0);
      ad.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
      ad.fku();
      finish();
      Object localObject = new Intent(paramContext, LauncherUI.class);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ad.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
      MMAppMgr.fwY();
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramContext.ahp(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(33309);
      return;
    }
    if (!com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.dyk, "LauncherUI.jump_switch_account", false))
    {
      paramContext = az.hFS.ax("login_user_name", "");
      ad.i("MicroMsg.LauncherUI", "%s jumpToLogin", new Object[] { paramContext });
      if (!bt.isNullOrNil(paramContext)) {
        break label466;
      }
      paramContext = new Intent(this, WelcomeActivity.class);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bc(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.ahp(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kf(this);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.f.Ol(8);
      aq.aA(this.IYZ);
      aq.o(this.IYZ, 2000L);
      AppMethodBeat.o(33309);
      return;
      label466:
      boolean bool = aj.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false);
      ad.i("MicroMsg.LauncherUI", "switchAccount %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      paramContext = new Intent(this, SettingsSwitchAccountUI.class);
      paramContext.addFlags(536870912);
      paramContext.putExtra("key_scene", 2);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bc(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.ahp(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kc(this);
    }
    int i = bt.aRe(az.hFS.ax("last_login_use_voice", ""));
    ad.i("MicroMsg.LauncherUI", "pluginSwitch  ".concat(String.valueOf(i)));
    paramContext = new Intent();
    if ((i & 0x20000) != 0) {
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginVoiceUI");
    }
    for (;;)
    {
      paramContext.addFlags(536870912);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bc(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.ahp(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kc(this);
      break;
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginPasswordUI");
    }
  }
  
  public static void jF(Context paramContext)
  {
    AppMethodBeat.i(33328);
    Object localObject = new Intent(paramContext, LauncherUI.class);
    ((Intent)localObject).addFlags(67108864);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33328);
  }
  
  private void xj(boolean paramBoolean)
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
      n.fwH();
    }
    for (paramBoolean = false;; paramBoolean = true)
    {
      this.IYX = paramBoolean;
      do
      {
        AppMethodBeat.o(33302);
        return;
      } while (this.IYX);
      if (this.IYR.aX(this)) {
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
        LauncherUI.this.IYQ.getMainTabUI().fxg();
        AppMethodBeat.o(33294);
      }
    };
    if (this.chattingTabUI.xt(paramBoolean))
    {
      this.IYQ.xg(this.chattingTabUI.JeG.isSupportCustomActionBar());
      this.IYQ.getMainTabUI().fxj();
    }
    AppMethodBeat.o(33330);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33319);
    boolean bool;
    if (this.chattingTabUI.fwF())
    {
      NewChattingTabUI localNewChattingTabUI = this.chattingTabUI;
      if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
        aq.aA(localNewChattingTabUI.mStartChattingRunnable);
      }
      if (localNewChattingTabUI.isAnimating) {}
      for (bool = true; bool; bool = localNewChattingTabUI.JeG.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent))
      {
        AppMethodBeat.o(33319);
        return true;
      }
    }
    if (this.IYQ.dispatchKeyEvent(paramKeyEvent))
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
      ad.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", new Object[] { paramKeyEvent.getMessage() });
      ad.printErrStackTrace("MicroMsg.LauncherUI", paramKeyEvent, "", new Object[0]);
      AppMethodBeat.o(33319);
    }
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(33316);
    super.finish();
    fwz();
    ad.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(IYL.size()), bt.flS() });
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
    for (localObject1 = ((NewChattingTabUI)localObject1).JeG;; localObject1 = null)
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
    return this.IYQ;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str1 = null;
    Object localObject1 = null;
    AppMethodBeat.i(33310);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.v("MicroMsg.LauncherUI", "edw on activity result");
    Object localObject2 = this.chattingTabUI;
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 226) || (paramInt1 == 30762) || (paramInt1 == 1111)) && (((NewChattingTabUI)localObject2).JeG != null)) {
      ((NewChattingTabUI)localObject2).JeG.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((NewChattingTabUI.acceptRequestCode(paramInt1)) && (((NewChattingTabUI)localObject2).JeG == null))
    {
      ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
      aq.aA(((NewChattingTabUI)localObject2).JeI);
      ((NewChattingTabUI)localObject2).JeI.JeR = 0;
      ((NewChattingTabUI)localObject2).JeI.requestCode = paramInt1;
      ((NewChattingTabUI)localObject2).JeI.bZU = paramInt2;
      ((NewChattingTabUI)localObject2).JeI.dxy = paramIntent;
      aq.f(((NewChattingTabUI)localObject2).JeI);
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(33310);
      return;
    }
    localObject2 = this.IYQ;
    if (((HomeUI)localObject2).IXx)
    {
      if (paramInt1 == 1)
      {
        com.tencent.mm.model.ba.aBQ();
        if (!bt.o((Boolean)com.tencent.mm.model.c.ajl().get(12323, null))) {
          com.tencent.mm.platformtools.y.showAddrBookUploadConfirm(((HomeUI)localObject2).IXa, null, false, 3);
        }
        AppMethodBeat.o(33310);
        return;
      }
      if (paramInt1 == 22722)
      {
        str1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null);
        ad.i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
        if (paramIntent != null) {
          localObject1 = paramIntent.getBundleExtra("result_data");
        }
        if ((localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("agree_privacy")))
        {
          ad.i("MicroMsg.LauncherUI.HomeUI", "agree privacy policy");
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(712L, 4L, 1L, false);
          localObject1 = new com.tencent.mm.plugin.account.model.g(1, str1);
          com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject1, 0);
          if ((com.tencent.mm.ax.b.FU(str1)) && (com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IDy, false)))
          {
            ad.i("MicroMsg.LauncherUI.HomeUI", "needbirthday true");
            aq.o(new HomeUI.24((HomeUI)localObject2), 100L);
          }
        }
      }
      while ((paramInt1 == 65534) && (paramInt2 == -1))
      {
        an.aQv("welcome_page_show");
        com.tencent.mm.kernel.l.q(((HomeUI)localObject2).IXa, true);
        MMAppMgr.MU();
        MMAppMgr.m(((HomeUI)localObject2).IXa, true);
        ((HomeUI)localObject2).IXa.finish();
        AppMethodBeat.o(33310);
        return;
        ad.i("MicroMsg.LauncherUI.HomeUI", "disagree privacy policy");
        localObject1 = new com.tencent.mm.plugin.account.model.g(2, str1);
        com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject1, 0);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(712L, 5L, 1L, false);
        continue;
        if (paramInt1 == 22723)
        {
          String str2 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(274436, null);
          localObject1 = str1;
          if (paramIntent != null) {
            localObject1 = paramIntent.getBundleExtra("result_data");
          }
          if (localObject1 != null) {
            if (((Bundle)localObject1).getString("go_next", "").equals("birthdayComfirmOK"))
            {
              ad.i("MicroMsg.LauncherUI.HomeUI", "verify birthday ok");
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDy, Boolean.FALSE);
            }
            else if (((Bundle)localObject1).getString("go_next", "").equals("gdpr_confirm_logout"))
            {
              ad.i("MicroMsg.LauncherUI.HomeUI", "quit verify birthday after H5-warnning");
              localObject1 = new com.tencent.mm.plugin.account.model.g(2, str2);
              com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject1, 0);
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(712L, 5L, 1L, false);
            }
          }
        }
      }
      if ((paramInt1 == 30764) && (paramIntent != null))
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEr, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b(((HomeUI)localObject2).IXa, "android.permission.ACCESS_COARSE_LOCATION", 66);
        }
      }
    }
    AppMethodBeat.o(33310);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(33320);
    ad.i("MicroMsg.LauncherUI", "onBackPressed");
    Object localObject = new Intent("android.intent.action.MAIN");
    ((Intent)localObject).addCategory("android.intent.category.HOME");
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/LauncherUI", "onBackPressed", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "onBackPressed", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33320);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(33325);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.IYQ;
    com.tencent.mm.pluginsdk.h.b(paramConfiguration.IXa, paramConfiguration.contentView);
    AppMethodBeat.o(33325);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33299);
    com.tencent.mm.blink.a.qD(com.tencent.mm.kernel.h.ajG().gCh);
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
      ad.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bt.jl(this) });
      super.onCreate(paramBundle);
      MainProcessChecker.aus(getClass().getName());
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
        if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(paramBundle, "absolutely_exit", false))
        {
          bool1 = true;
          ad.i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
        }
      }
      paramBundle = IYM.iterator();
      while (paramBundle.hasNext())
      {
        localObject1 = (LauncherUI)((WeakReference)paramBundle.next()).get();
        if (localObject1 != null) {
          ad.i("MicroMsg.LauncherUI", "Check launcher instance found one %s", new Object[] { localObject1 });
        }
      }
      setTheme(2131820574);
    }
    Object localObject1 = null;
    paramBundle = null;
    Object localObject3;
    if (!bool1)
    {
      localObject3 = IYL.iterator();
      localObject1 = paramBundle;
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (LauncherUI)((Iterator)localObject3).next();
        if (((LauncherUI)localObject1).getTaskId() != i)
        {
          ad.i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", new Object[] { Integer.valueOf(localObject1.hashCode()), Integer.valueOf(((LauncherUI)localObject1).getTaskId()), Integer.valueOf(i) });
          paramBundle = bt.aJ(this, i);
          if (paramBundle != null)
          {
            ad.i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), paramBundle.topActivity.getClassName(), paramBundle.baseActivity.getClassName(), Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
            if (paramBundle.baseActivity.getPackageName().equals(localObject2)) {
              break label589;
            }
            ad.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + paramBundle.baseActivity.getPackageName());
            finish();
            if (bt.aJ(this, ((LauncherUI)localObject1).getTaskId()) != null)
            {
              ad.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
              paramBundle = new Intent(this, LauncherUI.class);
              paramBundle.addFlags(268435456);
              paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramBundle);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.ahp(), "com/tencent/mm/ui/LauncherUI", "checkInstance", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramBundle.mq(0));
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
        ad.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
        AppMethodBeat.o(33299);
        return;
        ad.e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", new Object[] { Integer.valueOf(i) });
        finish();
        i = 0;
        continue;
        label589:
        ((LauncherUI)localObject1).finish();
        IYL.remove(localObject1);
        break;
        if (!IYL.isEmpty())
        {
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = bt.aJ(this, i);
          }
          if (paramBundle == null) {
            break label887;
          }
          localObject1 = paramBundle.baseActivity.getClassName();
          localObject2 = paramBundle.baseActivity.getClassName();
          ad.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), localObject2, localObject1, Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
          localObject3 = getComponentName().getClassName();
          if ((paramBundle.numActivities > 1) && (((String)localObject3).equals(localObject1)) && (((String)localObject3).equals(localObject2)))
          {
            finish();
            ad.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(IYL.size()) });
            i = 0;
            continue;
          }
          ad.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", new Object[] { Integer.valueOf(IYL.size()), Boolean.valueOf(bool1) });
          IYL.clear();
        }
        for (;;)
        {
          IYL.add(this);
          IYM.add(new WeakReference(this));
          ad.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d weak check %d, use time %d", new Object[] { Integer.valueOf(IYL.size()), Integer.valueOf(IYM.size()), Long.valueOf(System.currentTimeMillis() - l2) });
          i = 1;
          break;
          label887:
          ad.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(IYL.size()) });
          IYL.clear();
        }
      }
    }
    if ((getIntent() != null) && (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI.jump_from_uimode_check", false)))
    {
      ad.i("MicroMsg.LauncherUI", "dancy onCreate uimode check from background, finish LauncherUI");
      finish();
      AppMethodBeat.o(33299);
      return;
    }
    ad.i("MicroMsg.LauncherUI", "onCreate normally");
    this.IYQ = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.IYQ);
    this.chattingTabUI.mWg = this;
    paramBundle = this.IYQ;
    localObject1 = this.chattingTabUI;
    paramBundle.IXa = this;
    paramBundle.IXP = ((a)localObject1);
    localObject1 = paramBundle.IXR;
    ((MainTabUI)localObject1).IXa = this;
    ((MainTabUI)localObject1).JcW = paramBundle;
    Object localObject2 = ((MainTabUI)localObject1).JcV;
    ((aa)localObject2).IXa = this;
    ((aa)localObject2).Jdj = paramBundle;
    ((MainTabUI)localObject1).mUy = paramBundle;
    paramBundle.IXQ = new h(this, paramBundle);
    NotifyReceiver.WH();
    com.tencent.mm.pluginsdk.h.aN(paramBundle.IXa);
    paramBundle.mActionBar = getSupportActionBar();
    paramBundle.wQp = findViewById(2131296345);
    if (paramBundle.mActionBar != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131099879)));
      }
      paramBundle.mActionBar.hide();
    }
    setRequestedOrientation(1);
    paramBundle.IXS = getResources().getColor(2131100705);
    paramBundle.IXT = Color.alpha(paramBundle.IXS);
    paramBundle = az.hFS.ax("login_user_name", "");
    this.dyk = getIntent();
    localObject1 = this.IYV;
    ((t)localObject1).EJH = this.dyk.getBooleanExtra("splash-hack-activity-recreate", false);
    ad.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", new Object[] { ((t)localObject1).mTag, Boolean.valueOf(((t)localObject1).EJH) });
    ad.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", new Object[] { paramBundle, Boolean.valueOf(com.tencent.mm.model.ba.aBR()), Boolean.valueOf(IYN) });
    if (fwC())
    {
      ad.i("MicroMsg.LauncherUI", "handleExitIntent return");
      AppMethodBeat.o(33299);
      return;
    }
    if ((!IYN) && ((com.tencent.mm.model.ba.aBR()) || (!paramBundle.equals(""))))
    {
      IYO = l1;
      ad.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.d.cTp));
    }
    label1598:
    for (;;)
    {
      com.tencent.mm.pluginsdk.model.app.q.j(this, "");
      fwA();
      al.aG(this);
      com.tencent.mm.plugin.u.a.b.dyr();
      AppMethodBeat.o(33299);
      return;
      IYO = l1;
      ad.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.d.cTp));
      setRequestedOrientation(1);
      bool1 = com.tencent.mm.model.ba.aBR();
      paramBundle = az.hFS.ax("login_user_name", "");
      if ((!bool1) && (paramBundle.equals(""))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1492;
        }
        com.tencent.mm.sdk.platformtools.j.Icy = false;
        break;
      }
      label1492:
      bool1 = false;
      if ((com.tencent.mm.sdk.platformtools.j.Icz) && (com.tencent.mm.sdk.platformtools.j.Icy))
      {
        IYP = true;
        bool1 = MMAppMgr.a(this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33290);
            LauncherUI.a(LauncherUI.this);
            LauncherUI.aZZ();
            com.tencent.mm.pluginsdk.j.a.a.o.bMa();
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
        xj(true);
        IYP = false;
        com.tencent.mm.pluginsdk.j.a.a.o.bMa();
        com.tencent.mm.plugin.report.service.f.Ol(8);
        fwE();
        ad.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        aq.aA(this.IYZ);
        aq.o(this.IYZ, 2000L);
        break;
        MMAppMgr.jM(this);
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(33324);
    if (this.chattingTabUI.fwF())
    {
      AppMethodBeat.o(33324);
      return false;
    }
    HomeUI localHomeUI = this.IYQ;
    if ((localHomeUI.IXP == null) || (localHomeUI.IXP.fwF()))
    {
      AppMethodBeat.o(33324);
      return false;
    }
    localHomeUI.IYk = paramMenu;
    int i = localHomeUI.IXa.getSupportActionBar().getHeight();
    int j = com.tencent.mm.cc.a.ay(localHomeUI.IXa, 2131165296);
    if ((localHomeUI.IXR.abZ == 3) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()))
    {
      localHomeUI.IYj = paramMenu.add(0, 5, 0, 2131764454);
      if (localHomeUI.IYf == null)
      {
        com.tencent.mm.kiss.a.b.akC();
        localHomeUI.IYf = com.tencent.mm.kiss.a.b.c(localHomeUI.IXa, 2131492929);
        paramMenu = new ViewGroup.LayoutParams(j, i);
        localHomeUI.IYf.setLayoutParams(paramMenu);
        localHomeUI.IYf.setMinimumHeight(i);
        localHomeUI.IYf.setMinimumWidth(j);
        localHomeUI.IYf.setOnLongClickListener(new HomeUI.5(localHomeUI));
        localHomeUI.IYf.setOnClickListener(new HomeUI.6(localHomeUI));
        localHomeUI.IYf.setContentDescription(localHomeUI.getString(2131764454));
      }
      if (localHomeUI.IXV)
      {
        localHomeUI.IYf.findViewById(2131305884).setVisibility(0);
        paramMenu = com.tencent.mm.plugin.story.h.h.ASt;
        com.tencent.mm.plugin.story.h.h.AQ(1L);
      }
      for (;;)
      {
        localHomeUI.IYj.setActionView(localHomeUI.IYf);
        localHomeUI.fwl();
        localHomeUI.fwb();
        ad.v("MicroMsg.LauncherUI.HomeUI", "onCreateOptionsMenu");
        AppMethodBeat.o(33324);
        return true;
        localHomeUI.IYf.findViewById(2131305884).setVisibility(8);
        paramMenu = com.tencent.mm.plugin.story.h.h.ASt;
        com.tencent.mm.plugin.story.h.h.AQ(0L);
      }
    }
    Object localObject;
    if (i == 0)
    {
      localObject = localHomeUI.IXa.getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels) {
        i = localHomeUI.IXa.getResources().getDimensionPixelSize(2131165251);
      }
    }
    for (;;)
    {
      localHomeUI.IYg = paramMenu.add(0, HomeUI.IXY, 0, 2131764452);
      localHomeUI.IYg.setIcon(2131689494);
      if (localHomeUI.ITq) {
        localHomeUI.IYg.setIcon(2131689501);
      }
      if (localHomeUI.ITG == null)
      {
        localObject = new ViewGroup.LayoutParams(j, i);
        com.tencent.mm.kiss.a.b.akC();
        localHomeUI.ITG = com.tencent.mm.kiss.a.b.c(localHomeUI.IXa, 2131492929);
        localHomeUI.IYe = ((ImageView)localHomeUI.ITG.findViewById(2131300874));
        localHomeUI.ITG.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localHomeUI.ITG.setMinimumHeight(i);
        localHomeUI.ITG.setMinimumWidth(j);
        localHomeUI.IYe.setImageResource(2131689494);
        localHomeUI.IYe.setImageDrawable(ao.e(localHomeUI.IXa.getResources().getDrawable(2131689494), localHomeUI.IXa.getResources().getColor(2131099732)));
        localHomeUI.ITG.setContentDescription(localHomeUI.getString(2131764452));
        localHomeUI.ITG.setOnLongClickListener(new HomeUI.7(localHomeUI));
        localHomeUI.ITG.setOnClickListener(new HomeUI.8(localHomeUI));
        localHomeUI.ITG.post(new HomeUI.9(localHomeUI));
      }
      localHomeUI.IYg.setActionView(localHomeUI.ITG);
      localHomeUI.IYh = paramMenu.add(0, HomeUI.IXZ, 0, 2131764451);
      if (localHomeUI.IYb == null) {
        localHomeUI.IYa = new HomeUI.b(localHomeUI, j, i);
      }
      if (com.tencent.mm.kernel.g.ajA().aiK()) {
        com.tencent.mm.plugin.newtips.a.dun().h(localHomeUI.IYa);
      }
      if ((localHomeUI.ITq) && (localHomeUI.IYc != null)) {
        localHomeUI.IYc.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      com.tencent.mm.blink.b.Wi().w(new HomeUI.10(localHomeUI));
      localHomeUI.IYh.setActionView(localHomeUI.IYb);
      localHomeUI.fwb();
      localHomeUI.IYb.getLayoutParams().width = j;
      localHomeUI.IYb.getLayoutParams().height = i;
      break;
      i = localHomeUI.IXa.getResources().getDimensionPixelSize(2131165252);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33314);
    com.tencent.mm.blink.a.Wd();
    super.onDestroy();
    Object localObject = this.IYQ;
    ((HomeUI)localObject).IXR.bQQ();
    if (((HomeUI)localObject).IXQ != null)
    {
      h localh = ((HomeUI)localObject).IXQ;
      com.tencent.mm.sdk.b.a.IbL.d(localh.IXg);
      com.tencent.mm.sdk.b.a.IbL.d(localh.IXh);
    }
    if (((HomeUI)localObject).IXx) {
      Looper.myQueue().removeIdleHandler(((HomeUI)localObject).ogP);
    }
    localObject = this.chattingTabUI;
    if ((((NewChattingTabUI)localObject).mPrepareBitmap != null) && (!((NewChattingTabUI)localObject).mPrepareBitmap.isRecycled()))
    {
      ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", new Object[] { ((NewChattingTabUI)localObject).mPrepareBitmap.toString() });
      ((NewChattingTabUI)localObject).mPrepareBitmap.recycle();
    }
    aq.aA(((NewChattingTabUI)localObject).mStartChattingRunnable);
    Looper.myQueue().removeIdleHandler(((NewChattingTabUI)localObject).JeB);
    fwz();
    ad.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bt.jl(this), Integer.valueOf(IYL.size()) });
    AppMethodBeat.o(33314);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(33331);
    super.onMultiWindowModeChanged(paramBoolean);
    ad.i("MicroMsg.LauncherUI", "alvinluo onMultiWindowModeChanged2 isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    md localmd = new md();
    localmd.dzA.dzB = paramBoolean;
    com.tencent.mm.sdk.b.a.IbL.l(localmd);
    AppMethodBeat.o(33331);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(33301);
    ad.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", new Object[] { Integer.valueOf(hashCode()), bt.jl(this) });
    this.dyk = paramIntent;
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if ((this.dyk != null) && (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.dyk, "LauncherUI.jump_from_uimode_check", false)))
    {
      ad.i("MicroMsg.LauncherUI", "dancy onNewIntent uimode check from background, finish LauncherUI");
      finish();
      AppMethodBeat.o(33301);
      return;
    }
    com.tencent.mm.pluginsdk.model.app.q.j(this, "");
    if (fwC())
    {
      ad.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
      AppMethodBeat.o(33301);
      return;
    }
    if ((this.dyk != null) && (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.dyk, "Intro_Need_Clear_Top ", false)))
    {
      ad.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
      finish();
      jF(this);
      AppMethodBeat.o(33301);
      return;
    }
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      closeChatting(false);
    }
    MainTabUI localMainTabUI = this.IYQ.IXR;
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      localMainTabUI.JcX = true;
    }
    if (this.IYS)
    {
      ad.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
      bo(paramIntent);
    }
    com.tencent.mm.plugin.u.a.b.dyr();
    AppMethodBeat.o(33301);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int j = 0;
    AppMethodBeat.i(33323);
    HomeUI localHomeUI = this.IYQ;
    Object localObject = localHomeUI.IXa.getCurrentFragmet();
    int i;
    if ((localObject != null) && (((MMFragment)localObject).isShowing())) {
      i = j;
    }
    while (i != 0)
    {
      AppMethodBeat.o(33323);
      return true;
      i = j;
      if (!localHomeUI.IXP.fwF())
      {
        if (paramMenuItem.getItemId() == HomeUI.IXZ)
        {
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10919, "0");
          localHomeUI.fwa();
        }
        for (;;)
        {
          i = 1;
          break;
          if (paramMenuItem.getItemId() == HomeUI.IXY)
          {
            localHomeUI.fwc();
          }
          else
          {
            i = j;
            if (paramMenuItem.getItemId() != 5) {
              break;
            }
            if ((com.tencent.mm.sdk.a.b.fjN()) || (ac.iPM))
            {
              localObject = new com.tencent.mm.ui.tools.l(localHomeUI.IXa);
              ((com.tencent.mm.ui.tools.l)localObject).KJy = new HomeUI.11(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).KJz = new HomeUI.13(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).fKy();
            }
            else
            {
              localHomeUI.fwd();
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
    ad.d("MicroMsg.LauncherUI", "onPause %s, chatting is show ", new Object[] { Integer.valueOf(hashCode()) });
    super.onPause();
    Object localObject1 = this.IYV;
    boolean bool = ((t)localObject1).eW("onPause");
    if (bool) {
      ((t)localObject1).EJH = false;
    }
    if (bool)
    {
      ad.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
      AppMethodBeat.o(33311);
      return;
    }
    com.tencent.mm.blink.a.Wd();
    ad.i("MicroMsg.LauncherUI", "not skip this onPause");
    localObject1 = getCurrentFragmet();
    this.IYY.removeCallbacksAndMessages(null);
    Object localObject2 = this.IYQ;
    Object localObject3 = ((HomeUI)localObject2).IXR;
    bool = ((HomeUI)localObject2).IXx;
    ad.v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", new Object[] { Integer.valueOf(((MainTabUI)localObject3).abZ), Boolean.valueOf(bool) });
    if (bool) {
      ((MainTabUI)localObject3).fxd();
    }
    localObject3 = ((MainTabUI)localObject3).JcV;
    if (com.tencent.mm.model.ba.ajx())
    {
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.ajl().b(((aa)localObject3).Jdp);
      com.tencent.mm.model.ba.aBQ();
      com.tencent.mm.model.c.azv().b((n.b)localObject3);
      com.tencent.mm.z.c.aht().b(((aa)localObject3).Jdo);
      com.tencent.mm.sdk.b.a.IbL.d(((aa)localObject3).Jdq);
      com.tencent.mm.sdk.b.a.IbL.d(((aa)localObject3).IWd);
      com.tencent.mm.sdk.b.a.IbL.d(((aa)localObject3).IWc);
    }
    if (((aa)localObject3).Jdn != null)
    {
      ((aa)localObject3).Jdn.Jdk = null;
      ((aa)localObject3).Jdn = null;
    }
    localObject3 = ((HomeUI)localObject2).IXQ;
    if (((h)localObject3).IXd != null)
    {
      com.tencent.mm.model.ba.aiU().b(255, ((h)localObject3).IXd);
      com.tencent.mm.model.ba.aiU().b(384, ((h)localObject3).IXd);
      ((h)localObject3).IXd = null;
    }
    com.tencent.mm.sdk.a.b.eE(false);
    ((HomeUI)localObject2).IXO = HomeUI.a.IYz;
    if (!com.tencent.mm.model.ba.aBJ()) {
      com.tencent.mm.model.ba.getNotification().cz(false);
    }
    bool = ((HomeUI)localObject2).IXP.fwF();
    ad.i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show ".concat(String.valueOf(bool)));
    if (!bool) {
      j.a(((HomeUI)localObject2).IXa, 4, ((HomeUI)localObject2).IXR.abZ, "directReport_onPause");
    }
    if (!((HomeUI)localObject2).IXa.isFinishing()) {
      com.tencent.mm.ui.widget.h.a(((HomeUI)localObject2).IXa);
    }
    if (((HomeUI)localObject2).IXx)
    {
      ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
      com.tencent.mm.blink.b.Wi().Wk();
      if (com.tencent.mm.model.ba.ajx()) {
        com.tencent.mm.sdk.b.a.IbL.d(((HomeUI)localObject2).yBT);
      }
    }
    if ((((HomeUI)localObject2).IXF != null) && (((HomeUI)localObject2).IXF.isShowing())) {
      ((HomeUI)localObject2).IXF.dismiss();
    }
    localObject2 = this.chattingTabUI;
    if (((NewChattingTabUI)localObject2).fwF())
    {
      ((NewChattingTabUI)localObject2).ma(4);
      if ((((NewChattingTabUI)localObject2).JeG != null) && (((NewChattingTabUI)localObject2).JeG.isSupportNavigationSwipeBack())) {
        ((NewChattingTabUI)localObject2).JeG.getSwipeBackLayout().setEnableGesture(false);
      }
    }
    if (localObject1 != null)
    {
      AppMethodBeat.o(33311);
      return;
    }
    this.IYT = false;
    AppMethodBeat.o(33311);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(33313);
    this.IYX = false;
    Object localObject;
    if (!this.IYR.a(this, paramInt, paramArrayOfString, paramArrayOfInt))
    {
      localObject = this.IYQ;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      localObject = this.chattingTabUI;
      if (((NewChattingTabUI)localObject).JeG != null) {
        ((NewChattingTabUI)localObject).JeG.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(33313);
      return;
      if (paramInt == 80) {}
      for (int i = 2131761871; paramArrayOfInt[0] != 0; i = 2131761860)
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).IXa, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.25((HomeUI)localObject), new HomeUI.26((HomeUI)localObject));
        break;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ((HomeUI)localObject).fwc();
      }
      else
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).IXa, ((HomeUI)localObject).getString(2131761869), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.27((HomeUI)localObject), null);
        continue;
        if (paramArrayOfInt[0] == 0)
        {
          localObject = ((HomeUI)localObject).IXR.fxb();
          if ((localObject instanceof FindMoreFriendsUI)) {
            ((FindMoreFriendsUI)localObject).fvH();
          }
        }
        else
        {
          com.tencent.mm.ui.base.h.a(((HomeUI)localObject).IXa, ((HomeUI)localObject).getString(2131761869), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.28((HomeUI)localObject), null);
          continue;
          if (paramArrayOfInt[0] == 0)
          {
            ((HomeUI)localObject).fwd();
          }
          else
          {
            if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
            for (i = 2131761860;; i = 2131761871)
            {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).IXa, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131755691), false, new HomeUI.29((HomeUI)localObject), new HomeUI.30((HomeUI)localObject));
              break;
            }
            if (paramArrayOfInt[0] == 0) {
              ((HomeUI)localObject).fwd();
            } else {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).IXa, ((HomeUI)localObject).getString(2131761869), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.31((HomeUI)localObject), null);
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
    localNewChattingTabUI.JeD = paramBundle.getString("last_restore_talker");
    ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", new Object[] { localNewChattingTabUI.JeD });
    this.IZa = paramBundle.getBoolean("last_stay_chatting");
    this.IZb = paramBundle.getInt("last_stay_tab");
    if (this.IZa) {
      this.chattingTabUI.startChatting(this.chattingTabUI.JeD, null, false);
    }
    AppMethodBeat.o(33321);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33303);
    ad.i("MicroMsg.LauncherUI", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    super.onResume();
    if (this.IYV.eW("onResume"))
    {
      ad.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
      AppMethodBeat.o(33303);
      return;
    }
    ad.i("MicroMsg.LauncherUI", "not skip this onResume");
    IYN = false;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    long l1;
    Object localObject4;
    Object localObject5;
    label812:
    Object localObject6;
    long l2;
    if (fwB())
    {
      ad.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", new Object[] { Boolean.valueOf(this.IYS) });
      if (!com.tencent.mm.model.ba.ajx())
      {
        ad.w("MicroMsg.LauncherUI", "accHasNotReady, kill self");
        finish();
        ad.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/LauncherUI", "onResume", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/LauncherUI", "onResume", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(33303);
        return;
      }
      if (!this.IYS)
      {
        this.IYS = true;
        localObject1 = this.IYQ;
        if ((HomeUI.fwm()) && (HomeUI.fwn()))
        {
          bool1 = true;
          ((HomeUI)localObject1).IXV = bool1;
          localObject2 = ((HomeUI)localObject1).IXQ;
          com.tencent.mm.sdk.b.a.IbL.c(((h)localObject2).IXg);
          com.tencent.mm.sdk.b.a.IbL.c(((h)localObject2).IXh);
          if (!com.tencent.mm.ui.conversation.b.fIB()) {
            getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
          }
          localObject2 = ((HomeUI)localObject1).IXa.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.abm());
          if (((SharedPreferences)localObject2).getBoolean("first_launch_weixin", true))
          {
            ((SharedPreferences)localObject2).edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
          }
          ((HomeUI)localObject1).IXF = new ae(this);
          ((HomeUI)localObject1).IXx = true;
          NotifyReceiver.WJ();
          com.tencent.mm.model.ba.getNotification().kO(1);
          if (com.tencent.mm.model.ba.ajx()) {
            break label2788;
          }
          ad.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
          ((HomeUI)localObject1).IXa.finish();
          bo(getIntent());
        }
      }
      else
      {
        localObject1 = this.IYQ;
        l1 = bt.flT();
        localObject2 = ((HomeUI)localObject1).IXR;
        ad.i("MicroMsg.LauncherUI.MainTabUI", "onResume start :%d", new Object[] { Integer.valueOf(((MainTabUI)localObject2).abZ) });
        if (((MainTabUI)localObject2).Jdh.size() != 0)
        {
          localObject4 = ((MainTabUI)localObject2).abP(((MainTabUI)localObject2).abZ);
          ad.i("MicroMsg.LauncherUI.MainTabUI", "notifyCurrentTabResumeUI, mCurIndex:%s", new Object[] { Integer.valueOf(((MainTabUI)localObject2).abZ) });
          if (localObject4 != null) {
            ((m)localObject4).fuP();
          }
          if ((localObject4 != null) && (com.tencent.matrix.b.HK()) && (((MMFragment)localObject4).getActivity() != null))
          {
            localObject5 = ((MMFragment)localObject4).getActivity().getClass().getName();
            com.tencent.matrix.a.cAS.dI((String)localObject5 + "#" + localObject4.getClass().getSimpleName());
          }
        }
        if ((((MainTabUI)localObject2).JcX) && (((MainTabUI)localObject2).IXa.getIntent().hasExtra("isScrollFirst")) && (((MainTabUI)localObject2).IXa.getIntent().hasExtra("isShowHeader")))
        {
          localObject4 = (MainUI)((MainTabUI)localObject2).Jdh.get(Integer.valueOf(0));
          if (localObject4 != null)
          {
            bool1 = ((MainTabUI)localObject2).IXa.getIntent().getBooleanExtra("isShowHeader", false);
            boolean bool2 = ((MainTabUI)localObject2).IXa.getIntent().getBooleanExtra("isScrollFirst", true);
            ((MainUI)localObject4).j(bool1, ((MainTabUI)localObject2).IXa.getIntent().getBooleanExtra("isShowHeaderWithAnim", false), bool2);
          }
        }
        if (((MainTabUI)localObject2).JcX)
        {
          ((MainTabUI)localObject2).JcX = false;
          ((MainTabUI)localObject2).aVt("tab_main");
        }
        localObject4 = (MainUI)((MainTabUI)localObject2).Jdh.get(Integer.valueOf(0));
        if (localObject4 != null)
        {
          ((MainUI)localObject4).fHE();
          ((MainUI)localObject4).fJl();
        }
        if (((MainTabUI)localObject2).abZ != 0) {
          break label3780;
        }
        com.tencent.mm.model.ba.getNotification().cz(true);
        localObject4 = (m)((MainTabUI)localObject2).abP(((MainTabUI)localObject2).abZ);
        if (localObject4 != null) {
          ((m)localObject4).fuQ();
        }
        ((MainTabUI)localObject2).JcX = false;
        int i = com.tencent.mm.sdk.platformtools.y.getIntExtra(((MainTabUI)localObject2).IXa.getIntent(), "preferred_tab", 0);
        ad.d("MicroMsg.LauncherUI.MainTabUI", "doOnResume, tabIdx = %d", new Object[] { Integer.valueOf(i) });
        if (i != 0)
        {
          ((MainTabUI)localObject2).abO(i);
          ((MainTabUI)localObject2).IXa.getIntent().putExtra("preferred_tab", 0);
        }
        com.tencent.mm.sdk.b.a.IbL.c(((MainTabUI)localObject2).Jdc);
        com.tencent.mm.sdk.b.a.IbL.c(((MainTabUI)localObject2).Jde);
        com.tencent.mm.sdk.b.a.IbL.c(((MainTabUI)localObject2).Jdf);
        localObject2 = ((MainTabUI)localObject2).JcV;
        if (((aa)localObject2).Jdk != null) {
          ((aa)localObject2).Jdk.fuZ();
        }
        if (com.tencent.mm.model.ba.ajx())
        {
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.ajl().a(((aa)localObject2).Jdp);
          com.tencent.mm.z.c.aht().a(((aa)localObject2).Jdo);
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azv().a((n.b)localObject2);
          com.tencent.mm.sdk.b.a.IbL.c(((aa)localObject2).IWd);
          com.tencent.mm.sdk.b.a.IbL.c(((aa)localObject2).Jdq);
          com.tencent.mm.sdk.b.a.IbL.c(((aa)localObject2).IWc);
        }
        com.tencent.mm.blink.b.Wi().w(new aa.6((aa)localObject2));
        localObject2 = ((HomeUI)localObject1).IXQ;
        localObject6 = new bi();
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject6);
        if ((((bi)localObject6).dmn.dmo) && (!bt.isNullOrNil(((bi)localObject6).dmn.msg)))
        {
          ad.i("MicroMsg.LauncherUI.GlobalAlertMgr", "  now show msg:%s", new Object[] { ((bi)localObject6).dmn.msg });
          localObject4 = new com.tencent.mm.ui.widget.a.f.a(((h)localObject2).IXa);
          localObject5 = ((com.tencent.mm.ui.widget.a.f.a)localObject4).av(((h)localObject2).getString(2131755918)).aw(((h)localObject2).getString(2131755917));
          localObject6 = ((bi)localObject6).dmn.msg;
          ((com.tencent.mm.ui.widget.a.f.a)localObject5).EVU.aXH((String)localObject6);
          localObject4 = ((com.tencent.mm.ui.widget.a.f.a)localObject4).yU(false).b(new h.2((h)localObject2));
          ((com.tencent.mm.ui.widget.a.f.a)localObject4).EgK = true;
          ((com.tencent.mm.ui.widget.a.f.a)localObject4).show();
        }
        if (!((h)localObject2).a(((h)localObject2).IXc)) {
          com.tencent.mm.model.ba.ajF().n(new h.6((h)localObject2), 500L);
        }
        ((h)localObject2).IXc = null;
        com.tencent.mm.sdk.a.b.eE(true);
        bool1 = ((HomeUI)localObject1).IXP.fwF();
        if ((!bool1) && (com.tencent.mm.model.ba.ajx()))
        {
          com.tencent.mm.blink.b.Wi().w(new HomeUI.37((HomeUI)localObject1));
          if ((com.tencent.mm.bj.d.irv != null) && (com.tencent.mm.bj.d.iru != null) && (!bt.isNullOrNil(com.tencent.mm.bj.d.iru.aMl())))
          {
            ad.i("MicroMsg.LauncherUI.HomeUI", "launcher onResume end track %s", new Object[] { com.tencent.mm.bj.d.irv.aMm() });
            localObject2 = new fk();
            ((fk)localObject2).dqw.username = com.tencent.mm.bj.d.irv.aMm();
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        if (!bool1)
        {
          j.a(((HomeUI)localObject1).IXa, 3, ((HomeUI)localObject1).IXR.abZ, "directReport_onResume");
          ((HomeUI)localObject1).IXR.abL(260);
        }
        com.tencent.mm.ui.widget.h.b(((HomeUI)localObject1).IXa);
        ((HomeUI)localObject1).IXa.onSwipe(1.0F);
        ((HomeUI)localObject1).IXO = HomeUI.a.IYy;
        if (((HomeUI)localObject1).IXz)
        {
          ((HomeUI)localObject1).IXz = false;
          ((HomeUI)localObject1).IXz = false;
        }
        com.tencent.mm.ak.o.aEu();
        l2 = System.currentTimeMillis();
        ad.w("MicroMsg.LauncherUI.HomeUI", "[Launching Application]");
        com.tencent.mm.kernel.l.q(((HomeUI)localObject1).IXa, false);
        com.tencent.mm.kernel.l.r(((HomeUI)localObject1).IXa, false);
        long l3 = System.currentTimeMillis();
        if (!((HomeUI)localObject1).IXa.getSharedPreferences(aj.fkC(), 0).getBoolean("settings_landscape_mode", false)) {
          break label3792;
        }
        ((HomeUI)localObject1).IXa.setRequestedOrientation(-1);
        label1547:
        long l4 = System.currentTimeMillis();
        if (getInstance() != null)
        {
          com.tencent.mm.blink.b.Wi().Wl();
          ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("showprivacypolicy", ((HomeUI)localObject1).IYp);
          ((HomeUI)localObject1).xf(false);
          com.tencent.mm.sdk.b.a.IbL.c(((HomeUI)localObject1).yBT);
          ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - l4));
          if (com.tencent.mm.model.ba.ajx()) {
            ((HomeUI)localObject1).fwl();
          }
        }
        ad.v("MicroMsg.LauncherUI.HomeUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - l3));
        ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - l2));
        ad.i("MicroMsg.LauncherUI.HomeUI", "initView " + (System.currentTimeMillis() - l1));
        if (((HomeUI)localObject1).IXz)
        {
          ((HomeUI)localObject1).IXz = false;
          ((HomeUI)localObject1).IXz = false;
        }
        localObject2 = com.tencent.mm.app.v.Ml();
        ((com.tencent.mm.app.v)localObject2).cUC = true;
        ((com.tencent.mm.app.v)localObject2).cUD.removeMessages(-1999);
        ((com.tencent.mm.app.v)localObject2).cUD.removeMessages(-2999);
        ad.i("MicroMsg.LauncherUI.HomeUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - l1));
        if (u.aBd().booleanValue()) {
          ((HomeUI)localObject1).fvZ();
        }
        i = com.tencent.mm.kernel.g.ajC().ajl().getInt(al.a.IFQ, 0);
        if (i != 0)
        {
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFQ, Integer.valueOf(0));
          if (u.aAS()) {}
        }
        switch (i)
        {
        default: 
          label1884:
          com.tencent.mm.blink.b.Wi().w(new HomeUI.2((HomeUI)localObject1));
          if (((HomeUI)localObject1).getMainTabUI().abZ != 3)
          {
            localObject1 = (MoreTabUI)((HomeUI)localObject1).getMainTabUI().abP(3);
            if ((((MoreTabUI)localObject1).Jdx != null) && (!((MoreTabUI)localObject1).Jdx.isVisible))
            {
              ((MoreTabUI)localObject1).Jdx.fME();
              ((MoreTabUI)localObject1).dAx();
            }
          }
          localObject1 = this.chattingTabUI;
          ((NewChattingTabUI)localObject1).Jey = bt.aQJ();
          if (((NewChattingTabUI)localObject1).fxz())
          {
            ((NewChattingTabUI)localObject1).JeB = new NewChattingTabUI.1((NewChattingTabUI)localObject1);
            aq.o(new NewChattingTabUI.2((NewChattingTabUI)localObject1), 500L);
          }
          if (((NewChattingTabUI)localObject1).fwF())
          {
            ((NewChattingTabUI)localObject1).ma(3);
            if ((((NewChattingTabUI)localObject1).JeG != null) && (((NewChattingTabUI)localObject1).JeG.isSupportNavigationSwipeBack())) {
              ((NewChattingTabUI)localObject1).JeG.getSwipeBackLayout().setEnableGesture(true);
            }
            label2053:
            ad.i("MicroMsg.LauncherUI", "resumeNormalJump");
            MMFragmentActivity.a.fwZ();
            if (("pushcontent_notification".equals(com.tencent.mm.sdk.platformtools.y.getStringExtra(getIntent(), "nofification_type"))) && (!bt.isNullOrNil(com.tencent.mm.sdk.platformtools.y.getStringExtra(getIntent(), "Main_FromUserName"))))
            {
              localObject1 = com.tencent.mm.sdk.platformtools.y.getStringExtra(getIntent(), "Main_FromUserName");
              i = com.tencent.mm.sdk.platformtools.y.getIntExtra(getIntent(), "MainUI_User_Last_Msg_Type", 0);
              ad.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + (String)localObject1 + i);
              com.tencent.mm.plugin.report.service.g.yhR.f(10856, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(0) });
            }
            localObject1 = com.tencent.mm.sdk.platformtools.y.getStringExtra(getIntent(), "LauncherUI.Shortcut.LaunchType");
            if (localObject1 != null)
            {
              if (!((String)localObject1).equals("launch_type_voip")) {
                break label3879;
              }
              ad.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
              localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.g.yhR.f(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
            }
            label2337:
            localObject1 = com.tencent.mm.sdk.platformtools.y.getStringExtra(getIntent(), "LauncherUI.switch.tab");
            if (!bt.isNullOrNil((String)localObject1))
            {
              this.IYQ.getMainTabUI().aVt((String)localObject1);
              getIntent().putExtra("LauncherUI.switch.tab", "");
            }
            if ((com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) || (this.IYU))
            {
              this.IYU = false;
              localObject1 = getInstance();
              if (localObject1 != null) {
                ((LauncherUI)localObject1).IYQ.fwf();
              }
              getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
              getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
            }
            bool1 = com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
            if (!bool1) {
              break label4021;
            }
            localObject1 = com.tencent.mm.sdk.platformtools.y.getStringExtra(getIntent(), "LauncherUI.Shortcut.Username");
            label2481:
            if (bool1)
            {
              ad.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = ".concat(String.valueOf(localObject1)));
              if (!bt.isNullOrNil((String)localObject1))
              {
                localObject4 = com.tencent.mm.plugin.base.model.b.Ws((String)localObject1);
                if (!bt.isNullOrNil((String)localObject4))
                {
                  if (w.zD((String)localObject4))
                  {
                    ad.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                    if (!com.tencent.mm.am.g.DO((String)localObject4)) {
                      break label4327;
                    }
                    if (!com.tencent.mm.am.g.vd((String)localObject4)) {
                      break label4045;
                    }
                    localObject1 = new Intent();
                    ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                    ((Intent)localObject1).putExtra("Contact_User", (String)localObject4);
                    ((Intent)localObject1).putExtra("biz_chat_from_scene", 9);
                    ((Intent)localObject1).addFlags(67108864);
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                  label2673:
                  getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
                  getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
                }
              }
            }
            this.IYT = true;
            label2702:
            com.tencent.mm.blink.a.kJ(5);
            if (!IYP) {
              xj(false);
            }
            fwA();
            localObject1 = (com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class);
            if (localObject1 == null) {
              break label4362;
            }
            ad.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, try to fix");
            ((com.tencent.mm.plugin.ball.c.c)localObject1).bJZ();
          }
          break;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).dbJ();
        com.tencent.mm.plugin.base.stub.f.bMg();
        com.tencent.mm.blink.a.ub("LauncherUI");
        AppMethodBeat.o(33303);
        return;
        bool1 = false;
        break;
        label2788:
        ad.d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
        l1 = System.currentTimeMillis();
        l2 = System.currentTimeMillis();
        MMActivity.initLanguage(((HomeUI)localObject1).IXa);
        try
        {
          localObject2 = new HashSet();
          localObject4 = ((HomeUI)localObject1).getString(2131757953).split(";");
          ((Set)localObject2).add(localObject4[0]);
          ((Set)localObject2).add(localObject4[1]);
          com.tencent.mm.model.v.f((Set)localObject2);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajF().ay(new HomeUI.15((HomeUI)localObject1));
          ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).jfG = ((LayoutInflater)((HomeUI)localObject1).IXa.getSystemService("layout_inflater"));
          l2 = System.currentTimeMillis();
          com.tencent.mm.kiss.a.b.akC();
          ((HomeUI)localObject1).contentView = com.tencent.mm.kiss.a.b.c(((HomeUI)localObject1).IXa, 2131494684);
          if ((((HomeUI)localObject1).contentView != null) && (Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.abl())) {
            ((HomeUI)localObject1).contentView.setBackgroundColor(((HomeUI)localObject1).IXa.getResources().getColor(2131100705));
          }
          com.tencent.mm.blink.b.Wi().Wj();
          ((FirstScreenFrameLayout)((HomeUI)localObject1).contentView.findViewById(2131300113)).fDG = new HomeUI.23((HomeUI)localObject1);
          com.tencent.mm.pluginsdk.model.app.ao.faf();
          ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).IXa.setContentView(((HomeUI)localObject1).contentView);
          Looper.myQueue().addIdleHandler(((HomeUI)localObject1).ogP);
          ((HomeUI)localObject1).IXy = true;
          ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).initActionBar();
          ((HomeUI)localObject1).mActionBar.show();
          ((HomeUI)localObject1).contentView.post(new HomeUI.33((HomeUI)localObject1));
          ad.v("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - l1));
          aq.o(new HomeUI.34((HomeUI)localObject1), 2000L);
          ((HomeUI)localObject1).contentView.addOnLayoutChangeListener(((HomeUI)localObject1).IXX);
          com.tencent.mm.pluginsdk.h.b(((HomeUI)localObject1).IXa, ((HomeUI)localObject1).contentView);
          ((HomeUI)localObject1).contentView.postDelayed(new HomeUI.35((HomeUI)localObject1), 20L);
          localObject5 = ((HomeUI)localObject1).IXR;
          ((MainTabUI)localObject5).mViewPager = ((CustomViewPager)((MainTabUI)localObject5).IXa.findViewById(2131303135));
          ((MainTabUI)localObject5).mViewPager.setOffscreenPageLimit(4);
          ((MainTabUI)localObject5).mViewPager.setCanSlide(true);
          ((MainTabUI)localObject5).mViewPager.setCanSlideBySide(false);
          ((MainTabUI)localObject5).mTabsAdapter = new MainTabUI.TabsAdapter((MainTabUI)localObject5, ((MainTabUI)localObject5).IXa, ((MainTabUI)localObject5).mViewPager);
          if (getInstance() != null)
          {
            ((MainTabUI)localObject5).abO(getInstance().IZb);
            localObject2 = ((MainTabUI)localObject5).JcV;
            localObject4 = (ViewGroup)((MainTabUI)localObject5).mViewPager.getParent();
            localObject5 = ((MainTabUI)localObject5).mTabsAdapter;
            localObject6 = ((aa)localObject2).Jdk;
            if (((aa)localObject2).Jdk != null)
            {
              ((aa)localObject2).Jdk.setOnTabClickListener(null);
              ((View)((aa)localObject2).Jdk).setVisibility(8);
              if (localObject4 != null) {
                ((ViewGroup)localObject4).removeView((View)((aa)localObject2).Jdk);
              }
            }
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
            LauncherUIBottomTabView localLauncherUIBottomTabView = new LauncherUIBottomTabView(((aa)localObject2).IXa);
            localLauncherUIBottomTabView.setId(2131301338);
            if (localObject4 != null)
            {
              localLayoutParams.gravity = 80;
              ((ViewGroup)localObject4).addView(localLauncherUIBottomTabView, localLayoutParams);
            }
            ((aa)localObject2).Jdk = localLauncherUIBottomTabView;
            ((View)((aa)localObject2).Jdk).setVisibility(0);
            ((aa)localObject2).Jdk.setOnTabClickListener((c.a)localObject5);
            if ((localObject6 != null) && (localObject6 != ((aa)localObject2).Jdk))
            {
              ((aa)localObject2).Jdk.wX(((c)localObject6).getShowFriendPoint());
              ((aa)localObject2).Jdk.wY(((c)localObject6).getSettingsPoint());
              ((aa)localObject2).Jdk.abs(((c)localObject6).getMainTabUnread());
              ((aa)localObject2).Jdk.abt(((c)localObject6).getContactTabUnread());
              ((aa)localObject2).Jdk.abu(((c)localObject6).getFriendTabUnread());
              ((aa)localObject2).Jdk.abv(((c)localObject6).getSettingsTabUnread());
              ((aa)localObject2).Jdk.setTo(((c)localObject6).getCurIdx());
            }
            ((HomeUI)localObject1).IXR.Jdb = new HomeUI.1((HomeUI)localObject1);
            com.tencent.e.h.LTJ.aR(new HomeUI.12((HomeUI)localObject1));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
            continue;
            ((MainTabUI)localObject5).abO(0);
          }
        }
      }
      label3780:
      com.tencent.mm.model.ba.getNotification().cz(false);
      break label812;
      label3792:
      ((HomeUI)localObject1).IXa.setRequestedOrientation(1);
      break label1547;
      com.tencent.mm.ui.base.h.a(((HomeUI)localObject1).IXa, ((HomeUI)localObject1).getString(2131760750), "", new HomeUI.38((HomeUI)localObject1), null);
      break label1884;
      if (!((NewChattingTabUI)localObject1).JeJ) {
        break label2053;
      }
      ad.w("MicroMsg.LauncherUI.NewChattingTabUI", "[onResume] need exec this runnable!");
      aq.aA(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      aq.f(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      ((NewChattingTabUI)localObject1).JeJ = false;
      break label2053;
      label3879:
      if (!((String)localObject1).equals("launch_type_voip_audio")) {
        break label2337;
      }
      ad.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
      localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.g.yhR.f(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      break label2337;
      label4021:
      bool1 = com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
      localObject1 = getIntent().getAction();
      break label2481;
      label4045:
      if (com.tencent.mm.am.g.DQ((String)localObject4))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject1).putExtra("enterprise_biz_name", (String)localObject4);
        ((Intent)localObject1).putExtra("enterprise_biz_display_name", com.tencent.mm.model.v.zf((String)localObject4));
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break label2673;
      }
      if (com.tencent.mm.am.g.DR((String)localObject4))
      {
        localObject1 = com.tencent.mm.am.g.eS((String)localObject4);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).Kr())
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
          com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
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
      if (IYP) {
        break label2702;
      }
      fwE();
      break label2702;
      label4362:
      ad.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, service is null");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(33322);
    Object localObject = this.chattingTabUI;
    if (((NewChattingTabUI)localObject).JeG != null)
    {
      localObject = ((NewChattingTabUI)localObject).JeG.cWM.getTalkerUserName();
      if (!bt.isNullOrNil((String)localObject))
      {
        ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "onSaveInstanceState:%s", new Object[] { localObject });
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
    if ((this.IYS) && (!this.chattingTabUI.W(paramBoolean, paramInt))) {
      super.onSettle(paramBoolean, paramInt);
    }
    AppMethodBeat.o(33318);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(33312);
    ad.i("MicroMsg.LauncherUI", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.blink.a.Wd();
    HomeUI localHomeUI = this.IYQ;
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("showprivacypolicy", localHomeUI.IYp);
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
    if (this.IYS)
    {
      localNewChattingTabUI = this.chattingTabUI;
      if ((localNewChattingTabUI.Jex == null) || (!localNewChattingTabUI.Jex.fwg())) {
        break label108;
      }
      bool = true;
      ad.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", new Object[] { Float.valueOf(paramFloat), Long.valueOf(260L), Boolean.valueOf(bool) });
      if (localNewChattingTabUI.fxz()) {
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
        localNewChattingTabUI.abT(0);
        localObject = (ImageView)localNewChattingTabUI.mWg.getWindow().getDecorView().findViewById(2131303386);
        if (localObject != null)
        {
          ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE no cache!");
          ((ImageView)localObject).setVisibility(8);
          ((ImageView)localObject).setImageDrawable(null);
        }
        if (localNewChattingTabUI.mChattingInAnim != null) {
          localNewChattingTabUI.mChattingInAnim.cancel();
        }
      }
      for (;;)
      {
        if (!localNewChattingTabUI.Jex.fwg())
        {
          if (Float.compare(1.0F, paramFloat) > 0)
          {
            ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Boolean.FALSE });
            i = 0;
            break;
            if ((paramFloat != 1.0F) || (localNewChattingTabUI.mChattingClosed) || (localNewChattingTabUI.JeG.fAU())) {
              continue;
            }
            localNewChattingTabUI.mWg.getWindow().setBackgroundDrawableResource(2131100810);
            localObject = (ImageView)localNewChattingTabUI.mWg.getWindow().getDecorView().findViewById(2131303386);
            if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0) && (((ImageView)localObject).getTag() != null))
            {
              ((View)((ImageView)localObject).getTag()).setVisibility(0);
              ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
              ((ImageView)localObject).setVisibility(8);
              ((ImageView)localObject).setVisibility(8);
            }
            if ((localNewChattingTabUI.JeG.getContentView() != null) && (localNewChattingTabUI.JeG.getContentView().getX() <= 0.0F))
            {
              localNewChattingTabUI.abT(8);
              continue;
            }
            localNewChattingTabUI.abT(0);
            continue;
          }
          j = 0;
        }
      }
      i = j;
      if (localNewChattingTabUI.mWg != null)
      {
        localObject = localNewChattingTabUI.mWg.findViewById(2131301337);
        ImageView localImageView = (ImageView)localNewChattingTabUI.mWg.findViewById(2131303386);
        if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null) && (!localNewChattingTabUI.mChattingClosed) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
        {
          localImageView.setVisibility(0);
          ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
          localNewChattingTabUI.abT(8);
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
    if (((NewChattingTabUI)localObject3).JeG != null)
    {
      localObject1 = localObject2;
      if (((NewChattingTabUI)localObject3).JeG.fAW() != null)
      {
        if (((NewChattingTabUI)localObject3).JeG.isSupportCustomActionBar()) {
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
      if (!com.tencent.mm.compatible.util.d.lA(22))
      {
        localObject3 = ((NewChattingTabUI)localObject3).JeG.fAW().startActionMode(paramCallback);
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
    this.IYQ.fwe();
    this.chattingTabUI.startChatting(paramString, paramBundle, paramBoolean);
    AppMethodBeat.o(33329);
  }
  
  static abstract interface a
  {
    public abstract boolean fwF();
  }
  
  static abstract interface b
  {
    public abstract void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup);
    
    public abstract boolean fwg();
    
    public abstract void fwi();
    
    public abstract void fwj();
  }
  
  static abstract interface c
  {
    public abstract void fwh();
  }
  
  static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI
 * JD-Core Version:    0.7.0.1
 */