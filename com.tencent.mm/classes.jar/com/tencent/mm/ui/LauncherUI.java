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
import com.tencent.mars.BaseEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.blink.FirstScreenFrameLayout;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.ba.b;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.an;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.account.ui.WelcomeActivity;
import com.tencent.mm.plugin.account.ui.WelcomeSelectView;
import com.tencent.mm.plugin.account.ui.WelcomeView;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI;
import com.tencent.mm.pluginsdk.g.a.a.o;
import com.tencent.mm.pluginsdk.u;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.widget.SwipeBackLayout;
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
  private static ArrayList<LauncherUI> yYO;
  private static ArrayList<WeakReference<LauncherUI>> yYP;
  private static boolean yYQ;
  public static long yYR;
  private static boolean yYS;
  private static boolean yZb;
  private NewChattingTabUI chattingTabUI;
  private Intent cyJ;
  public HomeUI yYT;
  private n yYU;
  public boolean yYV;
  boolean yYW;
  private boolean yYX;
  private WelcomeView yYY;
  private u yYZ;
  com.tencent.mm.app.w yZa;
  private boolean yZc;
  private ak yZd;
  private Runnable yZe;
  
  static
  {
    AppMethodBeat.i(29485);
    yYO = new ArrayList();
    yYP = new ArrayList();
    yYQ = true;
    yYS = false;
    yZb = false;
    AppMethodBeat.o(29485);
  }
  
  public LauncherUI()
  {
    AppMethodBeat.i(29448);
    this.yYT = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.yYT);
    this.yYU = new n();
    this.cyJ = null;
    this.yYV = false;
    this.yYW = false;
    this.yYX = false;
    this.yYZ = new u("MicroMsg.LauncherUI");
    this.yZc = false;
    this.yZd = new ak();
    this.yZe = new LauncherUI.3(this);
    AppMethodBeat.o(29448);
  }
  
  private void aP(Intent paramIntent)
  {
    AppMethodBeat.i(29460);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "handleJump");
    if (!aw.RG())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
      startActivity(new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864));
      finish();
      AppMethodBeat.o(29460);
      return;
    }
    Object localObject1 = new jg();
    ((jg)localObject1).cyI.cyJ = this.cyJ;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    if ("talkroom_notification".equals(com.tencent.mm.sdk.platformtools.w.n(paramIntent, "nofification_type")))
    {
      paramIntent = com.tencent.mm.sdk.platformtools.w.n(paramIntent, "enter_chat_usrname");
      if (!bo.isNullOrNil(paramIntent))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enter_room_username", paramIntent);
        ((Intent)localObject1).setFlags(268435456);
        com.tencent.mm.bq.d.b(this, "talkroom", ".ui.TalkRoomUI", (Intent)localObject1);
      }
      AppMethodBeat.o(29460);
      return;
    }
    if ("back_to_pcmgr_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      if (!paramIntent.getBooleanExtra("newPCBackup", true)) {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BakToPcUI");
      }
      for (paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");; paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI"))
      {
        paramIntent.setFlags(268435456);
        MMWizardActivity.J(this, paramIntent);
        AppMethodBeat.o(29460);
        return;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
      }
    }
    if ("back_to_pcmgr_error_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.J(this, paramIntent);
      AppMethodBeat.o(29460);
      return;
    }
    if ("backup_move_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.J(this, paramIntent);
      AppMethodBeat.o(29460);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.w.a(paramIntent, "show_update_dialog", false)) {
      aQ(paramIntent);
    }
    String str = com.tencent.mm.sdk.platformtools.w.n(paramIntent, "Main_User");
    localObject1 = com.tencent.mm.sdk.platformtools.w.n(paramIntent, "nofification_type");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "[handleJump] user:%s", new Object[] { str });
    Object localObject2;
    int i;
    if ((str != null) && (!str.equals("")))
    {
      aw.aaz();
      localObject2 = com.tencent.mm.model.c.YF().arH(str);
      if (localObject2 != null)
      {
        i = ((au)localObject2).field_unReadCount;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "[oneliang] user:%s, conversation :%s, unReadCount:%s", new Object[] { str, localObject2, Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0) {
        j = com.tencent.mm.sdk.platformtools.w.a(paramIntent, "pushcontent_unread_count", 0);
      }
      MMAppMgr.BR();
      com.tencent.mm.sdk.b.a.ymk.l(new com.tencent.mm.g.a.ab());
      boolean bool = com.tencent.mm.sdk.platformtools.w.a(paramIntent, "Intro_Is_Muti_Talker", true);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((!bool) && (j > 0))
      {
        i = com.tencent.mm.sdk.platformtools.w.a(paramIntent, "Intro_Bottle_unread_count", 0);
        if (i > 0)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.bq.d.H(this, "bottle", ".ui.BottleConversationUI");
        }
      }
      if (!bool)
      {
        if (t.ok(str))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("type", 20);
          com.tencent.mm.bq.d.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
        }
        for (;;)
        {
          if (com.tencent.mm.sdk.platformtools.w.a(paramIntent, "kstyle_show_bind_mobile_afterauth", 0) > 0)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMobileUI");
            ((Intent)localObject1).putExtra("kstyle_bind_recommend_show", paramIntent.getIntExtra("kstyle_bind_recommend_show", 0));
            ((Intent)localObject1).putExtra("kstyle_bind_wording", paramIntent.getParcelableExtra("kstyle_bind_wording"));
            MMWizardActivity.J(this, (Intent)localObject1);
          }
          AppMethodBeat.o(29460);
          return;
          if (!t.os(str)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("type", 11);
          com.tencent.mm.bq.d.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
        }
        if (paramIntent.getIntExtra("MainUI_User_Last_Msg_Type", 34) != 34) {
          break label1436;
        }
      }
      label1425:
      label1436:
      for (i = 2;; i = 1)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("Chat_Mode", i);
        if ("new_msg_nofification".equals(com.tencent.mm.sdk.platformtools.w.n(paramIntent, "nofification_type"))) {
          ((Bundle)localObject1).putInt("chat_from_scene", 1);
        }
        localObject2 = getInstance();
        if (localObject2 == null) {
          break;
        }
        if (com.tencent.mm.aj.f.lg(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("biz_chat_from_scene", 4);
          com.tencent.mm.bq.d.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if (com.tencent.mm.aj.f.rY(str))
        {
          localObject1 = com.tencent.mm.aj.f.rS(str);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.aj.d)localObject1).aek())
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
            com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramIntent);
            break;
          }
        }
        if (ad.na(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("app_brand_conversation_from_scene", 3);
          paramIntent.putExtra("finish_direct", true);
          paramIntent.putExtra("key_need_send_video", false);
          com.tencent.mm.bq.d.f(this, ".ui.conversation.AppBrandServiceConversationUI", paramIntent);
          break;
        }
        ((LauncherUI)localObject2).startChatting(str, (Bundle)localObject1, false);
        break;
        if (com.tencent.mm.sdk.platformtools.w.a(paramIntent, "From_fail_notify", false))
        {
          if (!bo.isNullOrNil(str))
          {
            localObject1 = getInstance();
            if (localObject1 == null) {
              break;
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putBoolean("Chat_Mode", com.tencent.mm.sdk.platformtools.w.a(paramIntent, "resend_fail_messages", false));
            if (com.tencent.mm.aj.f.lg(str))
            {
              paramIntent.putExtra("Contact_User", str);
              paramIntent.addFlags(67108864);
              paramIntent.putExtra("biz_chat_from_scene", 4);
              com.tencent.mm.bq.d.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
              break;
            }
            ((LauncherUI)localObject1).startChatting(str, (Bundle)localObject2, false);
            break;
          }
          if (!com.tencent.mm.sdk.platformtools.w.a(paramIntent, "jump_sns_from_notify", false)) {
            break;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("is_need_resend_sns", paramIntent.getBooleanExtra("is_need_resend_sns", false));
          ((Intent)localObject1).putExtra("sns_resume_state", paramIntent.getBooleanExtra("sns_resume_state", false));
          ((Intent)localObject1).putExtra("sns_timeline_NeedFirstLoadint", paramIntent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
          com.tencent.mm.bq.d.b(this, "sns", ".ui.SnsTimeLineUI", (Intent)localObject1);
          break;
        }
        if (com.tencent.mm.sdk.platformtools.w.a(paramIntent, "biz_chat_need_to_jump_to_chatting_ui", false))
        {
          if ((getInstance() == null) || (!com.tencent.mm.aj.f.lg(str))) {
            break;
          }
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          com.tencent.mm.bq.d.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if ((bo.isNullOrNil(str)) || (!"new_msg_nofification".equals(localObject1))) {
          break;
        }
        if (paramIntent == null) {}
        for (localObject1 = "null";; localObject1 = paramIntent)
        {
          com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LauncherUI", "[handleJump] intent:%s", new Object[] { localObject1 });
          localObject1 = getInstance();
          if (localObject1 == null) {
            break label1425;
          }
          ((LauncherUI)localObject1).startChatting(str, new Bundle(), false);
          break;
        }
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LauncherUI", "LauncherUI.getInstance is null! ");
        break;
      }
      i = 0;
      break;
      i = 0;
    }
  }
  
  private void aQ(Intent paramIntent)
  {
    AppMethodBeat.i(29468);
    int i = com.tencent.mm.sdk.platformtools.w.a(paramIntent, "update_type", -1);
    if (i == -1)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
      AppMethodBeat.o(29468);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 28L, 1L, true);
    com.tencent.mm.plugin.report.service.h localh;
    if (com.tencent.mm.plugin.p.d.bSu() != null)
    {
      paramIntent = com.tencent.mm.plugin.p.d.bSu().c(this, null);
      if (paramIntent == null)
      {
        AppMethodBeat.o(29468);
        return;
      }
      localh = com.tencent.mm.plugin.report.service.h.qsU;
      if (i != 2) {
        break label116;
      }
    }
    label116:
    for (long l = 29L;; l = 30L)
    {
      localh.idkeyStat(405L, l, 1L, true);
      paramIntent.update(i);
      AppMethodBeat.o(29468);
      return;
    }
  }
  
  public static int dCf()
  {
    AppMethodBeat.i(29450);
    if ((getInstance() != null) && (getInstance().getHomeUI() != null) && (getInstance().getHomeUI().getMainTabUI() != null))
    {
      int i = getInstance().getHomeUI().getMainTabUI().Sl;
      AppMethodBeat.o(29450);
      return i;
    }
    AppMethodBeat.o(29450);
    return -1;
  }
  
  private void dCg()
  {
    AppMethodBeat.i(29451);
    int i = yYO.indexOf(this);
    if (i >= 0) {
      yYO.remove(i);
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(yYO.size()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(29451);
  }
  
  private void dCh()
  {
    AppMethodBeat.i(29453);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI", "[whatsnew] checkIfStartWhatsNew.");
    if (yZb)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "[whatsnew] has been played.");
      AppMethodBeat.o(29453);
      return;
    }
    if (!com.tencent.mm.kernel.g.RJ().QU())
    {
      com.tencent.mm.kernel.g.RJ();
      if (!com.tencent.mm.kernel.a.QT())
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "[whatsnew] not login yet, skip.");
        AppMethodBeat.o(29453);
        return;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "[whatsnew] account not initiate, skip whatsnew.");
      AppMethodBeat.o(29453);
      return;
    }
    if (!dCi())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "[whatsnew] notSwitchOrHold is false, skip whatsnew.");
      AppMethodBeat.o(29453);
      return;
    }
    com.tencent.mm.sdk.platformtools.w.a(getIntent(), "LauncherUI.enter_from_reg", false);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI", "[whatsnew] do not show whatsnew.");
    AppMethodBeat.o(29453);
  }
  
  private boolean dCi()
  {
    AppMethodBeat.i(29457);
    if ((this.cyJ != null) && (!com.tencent.mm.sdk.platformtools.w.a(this.cyJ, "Intro_Switch", false)) && (aw.aaB()) && (!aw.QP()))
    {
      AppMethodBeat.o(29457);
      return true;
    }
    AppMethodBeat.o(29457);
    return false;
  }
  
  private boolean dCj()
  {
    AppMethodBeat.i(29458);
    if (this.cyJ != null)
    {
      if ((com.tencent.mm.sdk.platformtools.w.a(this.cyJ, "absolutely_exit", false)) || (com.tencent.mm.sdk.platformtools.w.a(this.cyJ, "absolutely_exit_pid", 0) == Process.myPid()))
      {
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        finish();
        com.tencent.mm.plugin.report.service.g.Cz(8);
        MMAppMgr.qr(com.tencent.mm.sdk.platformtools.w.a(this.cyJ, "kill_service", true));
        System.exit(0);
        AppMethodBeat.o(29458);
        return true;
      }
      if (com.tencent.mm.sdk.platformtools.w.a(this.cyJ, "can_finish", false))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
        aw.Rc().cO(true);
        if (com.tencent.mm.kernel.l.bQ(getApplicationContext())) {
          com.tencent.mm.booter.b.br(getApplicationContext());
        }
        com.tencent.mm.plugin.report.service.g.Cz(8);
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), "com.tencent.mm.permission.MM_MESSAGE");
        finish();
        com.tencent.mm.ui.base.b.ig(this);
        AppMethodBeat.o(29458);
        return true;
      }
      if (com.tencent.mm.sdk.platformtools.w.a(this.cyJ, "exit_and_restart", false))
      {
        com.tencent.mrs.a.onDestroy();
        BaseEvent.onSingalCrash(0);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "exit and restart myself.");
        com.tencent.mm.sdk.platformtools.ab.dsI();
        finish();
        Intent localIntent = new Intent(this, LauncherUI.class);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "restart, try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        MMAppMgr.dCy();
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(29458);
        return true;
      }
    }
    AppMethodBeat.o(29458);
    return false;
  }
  
  private void dCk()
  {
    AppMethodBeat.i(29459);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "switch to wxid %s", new Object[] { com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "") });
    Intent localIntent = new Intent();
    localIntent.setClass(this, SettingsSwitchAccountUI.class);
    localIntent.addFlags(536870912);
    localIntent.putExtra("key_scene", 1);
    startActivity(localIntent);
    com.tencent.mm.ui.base.b.ih(this);
    AppMethodBeat.o(29459);
  }
  
  private void dCl()
  {
    AppMethodBeat.i(29461);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "resumeLogoutJump");
    MMFragmentActivity.a.dCz();
    Object localObject = av.flM.Y("login_user_name", "");
    if ((!aw.aaB()) && (((String)localObject).equals("")))
    {
      startActivity(new Intent(this, WelcomeActivity.class));
      com.tencent.mm.ui.base.b.ih(this);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
      com.tencent.mm.sdk.platformtools.al.ae(this.yZe);
      com.tencent.mm.sdk.platformtools.al.p(this.yZe, 2000L);
      AppMethodBeat.o(29461);
      return;
    }
    com.tencent.mm.plugin.report.service.g.Cz(8);
    com.tencent.mm.kernel.g.RK().Rb();
    if ((this.cyJ.getFlags() & 0x4000000) == 67108864) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.sdk.platformtools.w.a(this.cyJ, "Intro_Notify", false);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", new Object[] { Boolean.valueOf(this.yYV), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(aw.QP()) });
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", new Object[] { Boolean.valueOf(aw.aaB()) });
      this.yYT.getMainTabUI().dCC();
      aw.hold();
      localObject = new com.tencent.mm.g.a.w();
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      if (com.tencent.mm.sdk.platformtools.w.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
        this.yYX = true;
      }
      com.tencent.mm.kernel.g.RM().mD("[" + this.yYV + " " + bool1 + " " + bool2 + "]");
      hF(this);
      aw.unhold();
      AppMethodBeat.o(29461);
      return;
    }
  }
  
  public static LauncherUI getInstance()
  {
    AppMethodBeat.i(29449);
    if (yYO.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", new Object[] { bo.dtY() });
      AppMethodBeat.o(29449);
      return null;
    }
    LauncherUI localLauncherUI = (LauncherUI)yYO.get(0);
    AppMethodBeat.o(29449);
    return localLauncherUI;
  }
  
  private void hF(Context paramContext)
  {
    AppMethodBeat.i(29462);
    if (com.tencent.mm.sdk.platformtools.w.a(this.cyJ, "LauncherUI.jump_switch_account", false))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "launcher to switch account");
      dCk();
      this.cyJ.removeExtra("LauncherUI.jump_switch_account");
      AppMethodBeat.o(29462);
      return;
    }
    if ((com.tencent.mm.sdk.platformtools.w.a(this.cyJ, "Intro_Switch", false)) || (this.yYV) || (com.tencent.mm.kernel.a.QE()))
    {
      com.tencent.mrs.a.onDestroy();
      BaseEvent.onSingalCrash(0);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
      com.tencent.mm.sdk.platformtools.ab.dsI();
      finish();
      Intent localIntent = new Intent(paramContext, LauncherUI.class);
      localIntent.addFlags(67108864);
      paramContext.startActivity(localIntent);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
      MMAppMgr.dCy();
      Process.killProcess(Process.myPid());
      AppMethodBeat.o(29462);
      return;
    }
    if (!com.tencent.mm.sdk.platformtools.w.a(this.cyJ, "LauncherUI.jump_switch_account", false))
    {
      paramContext = av.flM.Y("login_user_name", "");
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "jumpToLogin %s", new Object[] { paramContext });
      if (bo.isNullOrNil(paramContext))
      {
        startActivity(new Intent(this, WelcomeActivity.class));
        com.tencent.mm.ui.base.b.ih(this);
        com.tencent.mm.plugin.report.service.g.Cz(8);
        com.tencent.mm.sdk.platformtools.al.ae(this.yZe);
        com.tencent.mm.sdk.platformtools.al.p(this.yZe, 2000L);
      }
    }
    else
    {
      AppMethodBeat.o(29462);
      return;
    }
    boolean bool = com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "switchAccount %s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      paramContext = new Intent(this, SettingsSwitchAccountUI.class);
      paramContext.addFlags(67108864);
      paramContext.putExtra("key_scene", 2);
      startActivity(paramContext);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.b.ie(this);
      break;
      int i = bo.apV(av.flM.Y("last_login_use_voice", ""));
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "pluginSwitch  ".concat(String.valueOf(i)));
      if ((i & 0x20000) != 0) {
        startActivity(new Intent().setClassName(this, "com.tencent.mm.plugin.account.ui.LoginVoiceUI"));
      } else {
        startActivity(new Intent().setClassName(this, "com.tencent.mm.plugin.account.ui.LoginPasswordUI"));
      }
    }
  }
  
  public static void hG(Context paramContext)
  {
    AppMethodBeat.i(29480);
    Intent localIntent = new Intent(paramContext, LauncherUI.class);
    localIntent.addFlags(67108864);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(29480);
  }
  
  private void qo(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(29455);
    if (paramBoolean)
    {
      if (!this.yYU.c(this, new LauncherUI.2(this))) {}
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        this.yZc = paramBoolean;
        AppMethodBeat.o(29455);
        return;
      }
    }
    if (!this.yZc) {
      if (this.yYU.aw(this)) {
        break label84;
      }
    }
    label84:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      this.yZc = paramBoolean;
      AppMethodBeat.o(29455);
      return;
    }
  }
  
  public final void closeChatting(boolean paramBoolean)
  {
    AppMethodBeat.i(29482);
    new LauncherUI.4(this);
    if (this.chattingTabUI.qx(paramBoolean))
    {
      this.yYT.qk(this.chattingTabUI.zee.isSupportCustomActionBar());
      this.yYT.getMainTabUI().dCK();
    }
    AppMethodBeat.o(29482);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(29472);
    boolean bool;
    if (this.chattingTabUI.dCm())
    {
      NewChattingTabUI localNewChattingTabUI = this.chattingTabUI;
      if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
        com.tencent.mm.sdk.platformtools.al.ae(localNewChattingTabUI.mStartChattingRunnable);
      }
      if (localNewChattingTabUI.isAnimating) {}
      for (bool = true; bool; bool = localNewChattingTabUI.zee.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent))
      {
        AppMethodBeat.o(29472);
        return true;
      }
    }
    if (this.yYT.dispatchKeyEvent(paramKeyEvent))
    {
      AppMethodBeat.o(29472);
      return true;
    }
    try
    {
      bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(29472);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", new Object[] { paramKeyEvent.getMessage() });
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.LauncherUI", paramKeyEvent, "", new Object[0]);
      AppMethodBeat.o(29472);
    }
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(29469);
    super.finish();
    dCg();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(yYO.size()), bo.dtY() });
    AppMethodBeat.o(29469);
  }
  
  public boolean forceRemoveNoMatchOnPath()
  {
    return true;
  }
  
  public MMFragment getCurrentFragmet()
  {
    AppMethodBeat.i(29479);
    Object localObject1 = this.chattingTabUI;
    if (!((NewChattingTabUI)localObject1).mChattingClosed) {}
    for (localObject1 = ((NewChattingTabUI)localObject1).zee;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getCurrentFragmet();
      }
      AppMethodBeat.o(29479);
      return localObject2;
    }
  }
  
  public HomeUI getHomeUI()
  {
    return this.yYT;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str1 = null;
    Object localObject1 = null;
    AppMethodBeat.i(29463);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.LauncherUI", "edw on activity result");
    Object localObject2 = this.chattingTabUI;
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 226) || (paramInt1 == 30762) || (paramInt1 == 1111)) && (((NewChattingTabUI)localObject2).zee != null)) {
      ((NewChattingTabUI)localObject2).zee.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((NewChattingTabUI.acceptRequestCode(paramInt1)) && (((NewChattingTabUI)localObject2).zee == null))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
      com.tencent.mm.sdk.platformtools.al.ae(((NewChattingTabUI)localObject2).zeg);
      ((NewChattingTabUI)localObject2).zeg.zep = 0;
      ((NewChattingTabUI)localObject2).zeg.requestCode = paramInt1;
      ((NewChattingTabUI)localObject2).zeg.bpE = paramInt2;
      ((NewChattingTabUI)localObject2).zeg.cyu = paramIntent;
      com.tencent.mm.sdk.platformtools.al.d(((NewChattingTabUI)localObject2).zeg);
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(29463);
      return;
    }
    localObject2 = this.yYT;
    if (((HomeUI)localObject2).yXC)
    {
      if (paramInt1 == 1)
      {
        aw.aaz();
        if (!com.tencent.mm.platformtools.ah.e((Boolean)com.tencent.mm.model.c.Ru().get(12323, null))) {
          com.tencent.mm.platformtools.z.showAddrBookUploadConfirm(((HomeUI)localObject2).yXg, null, false, 3);
        }
        AppMethodBeat.o(29463);
        return;
      }
      if (paramInt1 == 22722)
      {
        str1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
        if (paramIntent != null) {
          localObject1 = paramIntent.getBundleExtra("result_data");
        }
        if ((localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("agree_privacy")))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "agree privacy policy");
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(712L, 4L, 1L, false);
          localObject1 = new com.tencent.mm.plugin.account.model.e(1, str1);
          com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject1, 0);
          if ((com.tencent.mm.au.b.tM(str1)) && (com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yJW, false)))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "needbirthday true");
            com.tencent.mm.sdk.platformtools.al.p(new HomeUI.24((HomeUI)localObject2), 100L);
          }
        }
      }
      while ((paramInt1 == 65534) && (paramInt2 == -1))
      {
        aj.apl("welcome_page_show");
        com.tencent.mm.kernel.l.n(((HomeUI)localObject2).yXg, true);
        MMAppMgr.BR();
        MMAppMgr.l(((HomeUI)localObject2).yXg, true);
        ((HomeUI)localObject2).yXg.finish();
        AppMethodBeat.o(29463);
        return;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "disagree privacy policy");
        localObject1 = new com.tencent.mm.plugin.account.model.e(2, str1);
        com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(712L, 5L, 1L, false);
        continue;
        if (paramInt1 == 22723)
        {
          String str2 = (String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null);
          localObject1 = str1;
          if (paramIntent != null) {
            localObject1 = paramIntent.getBundleExtra("result_data");
          }
          if (localObject1 != null) {
            if (((Bundle)localObject1).getString("go_next", "").equals("birthdayComfirmOK"))
            {
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "verify birthday ok");
              com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yJW, Boolean.FALSE);
            }
            else if (((Bundle)localObject1).getString("go_next", "").equals("gdpr_confirm_logout"))
            {
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "quit verify birthday after H5-warnning");
              localObject1 = new com.tencent.mm.plugin.account.model.e(2, str2);
              com.tencent.mm.kernel.g.Rc().a((com.tencent.mm.ai.m)localObject1, 0);
              com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(712L, 5L, 1L, false);
            }
          }
        }
      }
      if ((paramInt1 == 30764) && (paramIntent != null))
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKH, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b(((HomeUI)localObject2).yXg, "android.permission.ACCESS_COARSE_LOCATION", 66);
        }
      }
    }
    AppMethodBeat.o(29463);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(29477);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.yYT;
    com.tencent.mm.pluginsdk.f.b(paramConfiguration.yXg, paramConfiguration.contentView);
    AppMethodBeat.o(29477);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29452);
    com.tencent.mm.blink.a.fT(com.tencent.mm.kernel.h.RP().eII);
    long l1 = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bo.hm(this) });
    this.yZa = new com.tencent.mm.app.w();
    super.onCreate(paramBundle);
    MainProcessChecker.WQ(getClass().getName());
    getWindow().getDecorView().setSystemUiVisibility(1280);
    long l2 = System.currentTimeMillis();
    int i = getTaskId();
    Object localObject2 = getPackageName();
    paramBundle = getIntent();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (com.tencent.mm.sdk.platformtools.w.a(paramBundle, "absolutely_exit", false))
      {
        bool1 = true;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
      }
    }
    paramBundle = yYP.iterator();
    while (paramBundle.hasNext())
    {
      localObject1 = (LauncherUI)((WeakReference)paramBundle.next()).get();
      if (localObject1 != null) {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "Check launcher instance found one %s", new Object[] { localObject1 });
      }
    }
    Object localObject1 = null;
    paramBundle = null;
    Object localObject3;
    if (!bool1)
    {
      localObject3 = yYO.iterator();
      localObject1 = paramBundle;
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (LauncherUI)((Iterator)localObject3).next();
        if (((LauncherUI)localObject1).getTaskId() != i)
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", new Object[] { Integer.valueOf(localObject1.hashCode()), Integer.valueOf(((LauncherUI)localObject1).getTaskId()), Integer.valueOf(i) });
          paramBundle = bo.ay(this, i);
          if (paramBundle != null)
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), paramBundle.topActivity.getClassName(), paramBundle.baseActivity.getClassName(), Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
            if (paramBundle.baseActivity.getPackageName().equals(localObject2)) {
              break label517;
            }
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + paramBundle.baseActivity.getPackageName());
            finish();
            if (bo.ay(this, ((LauncherUI)localObject1).getTaskId()) != null)
            {
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
              paramBundle = new Intent(this, LauncherUI.class);
              paramBundle.addFlags(268435456);
              startActivity(paramBundle);
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
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
        AppMethodBeat.o(29452);
        return;
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", new Object[] { Integer.valueOf(i) });
        finish();
        i = 0;
        continue;
        label517:
        ((LauncherUI)localObject1).finish();
        yYO.remove(localObject1);
        break;
        if (!yYO.isEmpty())
        {
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = bo.ay(this, i);
          }
          if (paramBundle == null) {
            break label815;
          }
          localObject1 = paramBundle.baseActivity.getClassName();
          localObject2 = paramBundle.baseActivity.getClassName();
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), localObject2, localObject1, Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
          localObject3 = getComponentName().getClassName();
          if ((paramBundle.numActivities > 1) && (((String)localObject3).equals(localObject1)) && (((String)localObject3).equals(localObject2)))
          {
            finish();
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(yYO.size()) });
            i = 0;
            continue;
          }
          com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", new Object[] { Integer.valueOf(yYO.size()), Boolean.valueOf(bool1) });
          yYO.clear();
        }
        for (;;)
        {
          yYO.add(this);
          yYP.add(new WeakReference(this));
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d weak check %d, use time %d", new Object[] { Integer.valueOf(yYO.size()), Integer.valueOf(yYP.size()), Long.valueOf(System.currentTimeMillis() - l2) });
          i = 1;
          break;
          label815:
          com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(yYO.size()) });
          yYO.clear();
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "onCreate normally");
    this.yYT = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.yYT);
    paramBundle = this.yYT;
    localObject1 = this.chattingTabUI;
    paramBundle.yXg = this;
    paramBundle.yXU = ((LauncherUI.a)localObject1);
    localObject1 = paramBundle.yXW;
    ((MainTabUI)localObject1).yXg = this;
    ((MainTabUI)localObject1).zcy = paramBundle;
    localObject2 = ((MainTabUI)localObject1).zcx;
    ((x)localObject2).yXg = this;
    ((x)localObject2).zcK = paramBundle;
    ((MainTabUI)localObject1).jbW = paramBundle;
    paramBundle.yXV = new h(this, paramBundle);
    NotifyReceiver.Il();
    com.tencent.mm.pluginsdk.f.ao(paramBundle.yXg);
    paramBundle.mActionBar = getSupportActionBar();
    paramBundle.pyE = findViewById(2131820956);
    if (paramBundle.mActionBar != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131689646)));
      }
      paramBundle.mActionBar.hide();
    }
    setRequestedOrientation(1);
    paramBundle.yXX = getResources().getColor(2131690316);
    paramBundle.yXY = Color.alpha(paramBundle.yXX);
    paramBundle = av.flM.Y("login_user_name", "");
    this.cyJ = getIntent();
    localObject1 = this.yYZ;
    ((u)localObject1).vJG = this.cyJ.getBooleanExtra("splash-hack-activity-recreate", false);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", new Object[] { ((u)localObject1).mTag, Boolean.valueOf(((u)localObject1).vJG) });
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", new Object[] { paramBundle, Boolean.valueOf(aw.aaB()), Boolean.valueOf(yYQ) });
    if ((!yYQ) && ((aw.aaB()) || (!paramBundle.equals(""))))
    {
      yYR = l1;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.b.bXE));
    }
    label1461:
    while (dCj())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "handleExitIntent return");
      AppMethodBeat.o(29452);
      return;
      yYR = l1;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.b.bXE));
      setRequestedOrientation(1);
      bool1 = aw.aaB();
      paramBundle = av.flM.Y("login_user_name", "");
      if ((!bool1) && (paramBundle.equals(""))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1345;
        }
        com.tencent.mm.sdk.platformtools.g.ymM = false;
        break;
      }
      label1345:
      bool1 = false;
      if (com.tencent.mm.sdk.platformtools.g.ymN)
      {
        yYS = true;
        bool1 = MMAppMgr.a(this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(29443);
            LauncherUI.a(LauncherUI.this);
            LauncherUI.aMv();
            o.aVE();
            paramAnonymousDialogInterface = jdField_this;
            WelcomeSelectView localWelcomeSelectView = new WelcomeSelectView(jdField_this);
            paramAnonymousDialogInterface.setContentView(localWelcomeSelectView);
            LauncherUI.a(LauncherUI.this, localWelcomeSelectView);
            LauncherUI.b(LauncherUI.this);
            AppMethodBeat.o(29443);
          }
        });
      }
      for (;;)
      {
        if (bool1) {
          break label1461;
        }
        qo(true);
        yYS = false;
        o.aVE();
        com.tencent.mm.plugin.report.service.g.Cz(8);
        paramBundle = new WelcomeSelectView(this);
        setContentView(paramBundle);
        this.yYY = paramBundle;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        com.tencent.mm.sdk.platformtools.al.ae(this.yZe);
        com.tencent.mm.sdk.platformtools.al.p(this.yZe, 2000L);
        break;
        MMAppMgr.hK(this);
      }
    }
    com.tencent.mm.pluginsdk.model.app.p.i(this, "");
    dCh();
    af.hW(this);
    AppMethodBeat.o(29452);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(29476);
    if (this.chattingTabUI.dCm())
    {
      AppMethodBeat.o(29476);
      return false;
    }
    HomeUI localHomeUI = this.yYT;
    if ((localHomeUI.yXU == null) || (localHomeUI.yXU.dCm()))
    {
      AppMethodBeat.o(29476);
      return false;
    }
    localHomeUI.yYo = paramMenu;
    int i = localHomeUI.yXg.getSupportActionBar().getHeight();
    int j = com.tencent.mm.cb.a.ap(localHomeUI.yXg, 2131427594);
    if ((localHomeUI.yXW.Sl == 3) && (com.tencent.mm.plugin.story.api.n.isShowStoryCheck()))
    {
      localHomeUI.yYn = paramMenu.add(0, 5, 0, 2131304320);
      if (localHomeUI.yYj == null)
      {
        com.tencent.mm.kiss.a.b.SH();
        localHomeUI.yYj = com.tencent.mm.kiss.a.b.b(localHomeUI.yXg, 2130968621);
        paramMenu = new ViewGroup.LayoutParams(j, i);
        localHomeUI.yYj.setLayoutParams(paramMenu);
        localHomeUI.yYj.setBackgroundResource(2130837631);
        localHomeUI.yYj.setMinimumHeight(i);
        localHomeUI.yYj.setMinimumWidth(j);
        localHomeUI.yYj.setOnLongClickListener(new HomeUI.4(localHomeUI));
        localHomeUI.yYj.setOnClickListener(new HomeUI.5(localHomeUI));
      }
      localHomeUI.yYn.setActionView(localHomeUI.yYj);
      localHomeUI.dBU();
      localHomeUI.dBK();
      com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.LauncherUI.HomeUI", "onCreateOptionsMenu");
      AppMethodBeat.o(29476);
      return true;
    }
    Object localObject;
    if (i == 0)
    {
      localObject = localHomeUI.yXg.getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels) {
        i = localHomeUI.yXg.getResources().getDimensionPixelSize(2131427558);
      }
    }
    for (;;)
    {
      localHomeUI.yYk = paramMenu.add(0, HomeUI.yYd, 0, 2131304318);
      localHomeUI.yYk.setIcon(2131230741);
      if (localHomeUI.qGO) {
        localHomeUI.yYk.setIcon(2131230748);
      }
      if (localHomeUI.yUs == null)
      {
        localObject = new ViewGroup.LayoutParams(j, i);
        com.tencent.mm.kiss.a.b.SH();
        localHomeUI.yUs = com.tencent.mm.kiss.a.b.b(localHomeUI.yXg, 2130968621);
        localHomeUI.yYi = ((ImageView)localHomeUI.yUs.findViewById(2131820929));
        localHomeUI.yUs.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localHomeUI.yUs.setBackgroundResource(2130837631);
        localHomeUI.yUs.setMinimumHeight(i);
        localHomeUI.yUs.setMinimumWidth(j);
        localHomeUI.yYi.setImageResource(2131230741);
        localHomeUI.yUs.setOnClickListener(new HomeUI.6(localHomeUI));
        localHomeUI.yUs.post(new HomeUI.7(localHomeUI));
      }
      localHomeUI.yYk.setActionView(localHomeUI.yUs);
      localHomeUI.yYl = paramMenu.add(0, HomeUI.yYe, 0, 2131304317);
      if (localHomeUI.yYf == null)
      {
        paramMenu = new ViewGroup.LayoutParams(j, i);
        com.tencent.mm.kiss.a.b.SH();
        localHomeUI.yYf = com.tencent.mm.kiss.a.b.b(localHomeUI.yXg, 2130968621);
        localHomeUI.yYg = ((ImageView)localHomeUI.yYf.findViewById(2131820929));
        localHomeUI.yYh = localHomeUI.yYf.findViewById(2131821001);
        localHomeUI.yYf.setLayoutParams(paramMenu);
        localHomeUI.yYf.setBackgroundResource(2130837631);
        localHomeUI.yYf.setMinimumHeight(i);
        localHomeUI.yYf.setMinimumWidth(j);
        localHomeUI.yYg.setImageResource(2131231480);
        localHomeUI.yYf.setContentDescription(localHomeUI.getString(2131304317));
        localHomeUI.yYf.setOnClickListener(new HomeUI.8(localHomeUI));
        localHomeUI.yYf.post(new HomeUI.9(localHomeUI));
      }
      if ((localHomeUI.qGO) && (localHomeUI.yYg != null)) {
        localHomeUI.yYg.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      com.tencent.mm.blink.b.HP().o(new HomeUI.10(localHomeUI));
      localHomeUI.yYl.setActionView(localHomeUI.yYf);
      localHomeUI.dBK();
      localHomeUI.yYf.getLayoutParams().width = j;
      localHomeUI.yYf.getLayoutParams().height = i;
      break;
      i = localHomeUI.yXg.getResources().getDimensionPixelSize(2131427559);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29467);
    com.tencent.mm.blink.a.HK();
    super.onDestroy();
    Object localObject = this.yYT;
    ((HomeUI)localObject).yXW.dCC();
    if (((HomeUI)localObject).yXV != null)
    {
      h localh = ((HomeUI)localObject).yXV;
      com.tencent.mm.sdk.b.a.ymk.d(localh.yXm);
      com.tencent.mm.sdk.b.a.ymk.d(localh.yXn);
    }
    if (((HomeUI)localObject).yXC) {
      Looper.myQueue().removeIdleHandler(((HomeUI)localObject).jZm);
    }
    localObject = this.chattingTabUI;
    if ((((NewChattingTabUI)localObject).mPrepareBitmap != null) && (!((NewChattingTabUI)localObject).mPrepareBitmap.isRecycled()))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", new Object[] { ((NewChattingTabUI)localObject).mPrepareBitmap.toString() });
      ((NewChattingTabUI)localObject).mPrepareBitmap.recycle();
    }
    com.tencent.mm.sdk.platformtools.al.ae(((NewChattingTabUI)localObject).mStartChattingRunnable);
    Looper.myQueue().removeIdleHandler(((NewChattingTabUI)localObject).zdZ);
    dCg();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bo.hm(this), Integer.valueOf(yYO.size()) });
    AppMethodBeat.o(29467);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(153807);
    super.onMultiWindowModeChanged(paramBoolean);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "alvinluo onMultiWindowModeChanged2 isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    kg localkg = new kg();
    localkg.czS.czT = paramBoolean;
    com.tencent.mm.sdk.b.a.ymk.l(localkg);
    AppMethodBeat.o(153807);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(29454);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", new Object[] { Integer.valueOf(hashCode()), bo.hm(this) });
    this.cyJ = paramIntent;
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    com.tencent.mm.pluginsdk.model.app.p.i(this, "");
    if (dCj())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
      AppMethodBeat.o(29454);
      return;
    }
    if ((this.cyJ != null) && (com.tencent.mm.sdk.platformtools.w.a(this.cyJ, "Intro_Need_Clear_Top ", false)))
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
      finish();
      hG(this);
      AppMethodBeat.o(29454);
      return;
    }
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      closeChatting(false);
    }
    MainTabUI localMainTabUI = this.yYT.yXW;
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      localMainTabUI.zcz = true;
    }
    if (this.yYV)
    {
      com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
      aP(paramIntent);
    }
    AppMethodBeat.o(29454);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int j = 0;
    AppMethodBeat.i(29475);
    HomeUI localHomeUI = this.yYT;
    Object localObject = localHomeUI.yXg.getCurrentFragmet();
    int i;
    if ((localObject != null) && (((MMFragment)localObject).isShowing())) {
      i = j;
    }
    while (i != 0)
    {
      AppMethodBeat.o(29475);
      return true;
      i = j;
      if (!localHomeUI.yXU.dCm())
      {
        if (paramMenuItem.getItemId() == HomeUI.yYe)
        {
          com.tencent.mm.plugin.report.service.h.qsU.kvStat(10919, "0");
          localHomeUI.dBJ();
        }
        for (;;)
        {
          i = 1;
          break;
          if (paramMenuItem.getItemId() == HomeUI.yYd)
          {
            localHomeUI.dBL();
          }
          else
          {
            i = j;
            if (paramMenuItem.getItemId() != 5) {
              break;
            }
            if ((com.tencent.mm.sdk.a.b.dsf()) || (ae.glD))
            {
              localObject = new com.tencent.mm.ui.tools.l(localHomeUI.yXg);
              ((com.tencent.mm.ui.tools.l)localObject).sao = new HomeUI.11(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).sap = new HomeUI.13(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).cwt();
            }
            else
            {
              localHomeUI.dBM();
            }
          }
        }
      }
    }
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(29475);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29464);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI", "onPause, chatting is show ");
    super.onPause();
    Object localObject1 = this.yYZ;
    boolean bool = ((u)localObject1).jdMethod_do("onPause");
    if (bool) {
      ((u)localObject1).vJG = false;
    }
    if (bool)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
      AppMethodBeat.o(29464);
      return;
    }
    com.tencent.mm.blink.a.HK();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "not skip this onPause");
    localObject1 = getCurrentFragmet();
    this.yZd.removeCallbacksAndMessages(null);
    Object localObject2 = this.yYT;
    Object localObject3 = ((HomeUI)localObject2).yXW;
    bool = ((HomeUI)localObject2).yXC;
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", new Object[] { Integer.valueOf(((MainTabUI)localObject3).Sl), Boolean.valueOf(bool) });
    if (bool) {
      ((MainTabUI)localObject3).dCE();
    }
    localObject3 = ((MainTabUI)localObject3).zcx;
    if (aw.RG())
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().b(((x)localObject3).zcQ);
      aw.aaz();
      com.tencent.mm.model.c.YF().b((n.b)localObject3);
      com.tencent.mm.x.c.PJ().b(((x)localObject3).zcP);
      com.tencent.mm.sdk.b.a.ymk.d(((x)localObject3).zcR);
      com.tencent.mm.sdk.b.a.ymk.d(((x)localObject3).yWy);
      com.tencent.mm.sdk.b.a.ymk.d(((x)localObject3).yWx);
    }
    if (((x)localObject3).zcO != null)
    {
      ((x)localObject3).zcO.zcL = null;
      ((x)localObject3).zcO = null;
    }
    localObject3 = ((HomeUI)localObject2).yXV;
    if (((h)localObject3).yXj != null)
    {
      aw.Rc().b(255, ((h)localObject3).yXj);
      aw.Rc().b(384, ((h)localObject3).yXj);
      ((h)localObject3).yXj = null;
    }
    com.tencent.mm.sdk.a.b.cP(false);
    ((HomeUI)localObject2).yXT = HomeUI.a.yYD;
    if (!aw.aas()) {
      aw.getNotification().bE(false);
    }
    bool = ((HomeUI)localObject2).yXU.dCm();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show ".concat(String.valueOf(bool)));
    if (!bool) {
      j.a(((HomeUI)localObject2).yXg, 4, ((HomeUI)localObject2).yXW.Sl, "directReport_onPause");
    }
    if (!((HomeUI)localObject2).yXg.isFinishing()) {
      com.tencent.mm.ui.widget.h.a(((HomeUI)localObject2).yXg);
    }
    if (((HomeUI)localObject2).yXC)
    {
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
      com.tencent.mm.blink.b.HP().HR();
      if (aw.RG()) {
        com.tencent.mm.sdk.b.a.ymk.d(((HomeUI)localObject2).qEr);
      }
    }
    if ((((HomeUI)localObject2).yXK != null) && (((HomeUI)localObject2).yXK.isShowing())) {
      ((HomeUI)localObject2).yXK.dismiss();
    }
    localObject2 = this.chattingTabUI;
    if (((NewChattingTabUI)localObject2).dCm())
    {
      ((NewChattingTabUI)localObject2).kS(4);
      if ((((NewChattingTabUI)localObject2).zee != null) && (((NewChattingTabUI)localObject2).zee.isSupportNavigationSwipeBack())) {
        ((NewChattingTabUI)localObject2).zee.getSwipeBackLayout().setEnableGesture(false);
      }
    }
    if (localObject1 != null)
    {
      AppMethodBeat.o(29464);
      return;
    }
    this.yYW = false;
    AppMethodBeat.o(29464);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(29466);
    this.yZc = false;
    Object localObject;
    if (!this.yYU.a(this, paramInt, paramArrayOfString, paramArrayOfInt))
    {
      localObject = this.yYT;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      localObject = this.chattingTabUI;
      if (((NewChattingTabUI)localObject).zee != null) {
        ((NewChattingTabUI)localObject).zee.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(29466);
      return;
      if (paramInt == 80) {}
      for (int i = 2131302075; paramArrayOfInt[0] != 0; i = 2131302067)
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).yXg, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(2131302083), ((HomeUI)localObject).getString(2131300996), ((HomeUI)localObject).getString(2131297837), false, new HomeUI.25((HomeUI)localObject), new HomeUI.26((HomeUI)localObject));
        break;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ((HomeUI)localObject).dBL();
      }
      else
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).yXg, ((HomeUI)localObject).getString(2131302073), ((HomeUI)localObject).getString(2131302083), ((HomeUI)localObject).getString(2131300996), ((HomeUI)localObject).getString(2131297837), false, new HomeUI.27((HomeUI)localObject), null);
        continue;
        if (paramArrayOfInt[0] == 0)
        {
          localObject = ((HomeUI)localObject).yXW.dCB();
          if ((localObject instanceof FindMoreFriendsUI)) {
            ((FindMoreFriendsUI)localObject).dBu();
          }
        }
        else
        {
          com.tencent.mm.ui.base.h.a(((HomeUI)localObject).yXg, ((HomeUI)localObject).getString(2131302073), ((HomeUI)localObject).getString(2131302083), ((HomeUI)localObject).getString(2131300996), ((HomeUI)localObject).getString(2131297837), false, new HomeUI.28((HomeUI)localObject), null);
          continue;
          if (paramArrayOfInt[0] == 0)
          {
            ((HomeUI)localObject).dBM();
          }
          else
          {
            if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
            for (i = 2131302067;; i = 2131302075)
            {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).yXg, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(2131302083), ((HomeUI)localObject).getString(2131300996), ((HomeUI)localObject).getString(2131296888), false, new HomeUI.29((HomeUI)localObject), new HomeUI.30((HomeUI)localObject));
              break;
            }
            if (paramArrayOfInt[0] == 0) {
              ((HomeUI)localObject).dBM();
            } else {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).yXg, ((HomeUI)localObject).getString(2131302073), ((HomeUI)localObject).getString(2131302083), ((HomeUI)localObject).getString(2131300996), ((HomeUI)localObject).getString(2131297837), false, new HomeUI.31((HomeUI)localObject), null);
            }
          }
        }
      }
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(29473);
    super.onRestoreInstanceState(paramBundle);
    NewChattingTabUI localNewChattingTabUI = this.chattingTabUI;
    localNewChattingTabUI.zeb = paramBundle.getString("last_restore_talker");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", new Object[] { localNewChattingTabUI.zeb });
    AppMethodBeat.o(29473);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29456);
    super.onResume();
    if (this.yYZ.jdMethod_do("onResume"))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
      AppMethodBeat.o(29456);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "not skip this onResume");
    yYQ = false;
    Object localObject1;
    Object localObject2;
    long l1;
    Object localObject4;
    boolean bool1;
    label1061:
    long l2;
    if (dCi())
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", new Object[] { Boolean.valueOf(this.yYV) });
      Object localObject5;
      if (!this.yYV)
      {
        this.yYV = true;
        localObject1 = this.yYT;
        localObject2 = ((HomeUI)localObject1).yXV;
        com.tencent.mm.sdk.b.a.ymk.c(((h)localObject2).yXm);
        com.tencent.mm.sdk.b.a.ymk.c(((h)localObject2).yXn);
        if (!com.tencent.mm.ui.conversation.b.dMo()) {
          getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
        }
        localObject2 = ((HomeUI)localObject1).yXg.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mp());
        if (((SharedPreferences)localObject2).getBoolean("first_launch_weixin", true))
        {
          ((SharedPreferences)localObject2).edit().putBoolean("first_launch_weixin", false).commit();
          XLogSetup.realSetupXlog();
        }
        ((HomeUI)localObject1).yXK = new ab(this);
        ((HomeUI)localObject1).yXC = true;
        NotifyReceiver.In();
        aw.getNotification().ii(1);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
        l1 = System.currentTimeMillis();
        if (!aw.RG())
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
          ((HomeUI)localObject1).yXg.finish();
          localObject5 = ((HomeUI)localObject1).yXW;
          ((MainTabUI)localObject5).mViewPager = ((CustomViewPager)((MainTabUI)localObject5).yXg.findViewById(2131823945));
          ((MainTabUI)localObject5).mViewPager.setOffscreenPageLimit(4);
          ((MainTabUI)localObject5).mViewPager.setCanSlide(true);
          ((MainTabUI)localObject5).mViewPager.setCanSlideBySide(false);
          ((MainTabUI)localObject5).mTabsAdapter = new MainTabUI.TabsAdapter((MainTabUI)localObject5, ((MainTabUI)localObject5).yXg, ((MainTabUI)localObject5).mViewPager);
          ((MainTabUI)localObject5).Om(0);
          localObject2 = ((MainTabUI)localObject5).zcx;
          localObject4 = (ViewGroup)((MainTabUI)localObject5).mViewPager.getParent();
          localObject5 = ((MainTabUI)localObject5).mTabsAdapter;
          c localc = ((x)localObject2).zcL;
          if (((x)localObject2).zcL != null)
          {
            ((x)localObject2).zcL.setOnTabClickListener(null);
            ((View)((x)localObject2).zcL).setVisibility(8);
            if (localObject4 != null) {
              ((ViewGroup)localObject4).removeView((View)((x)localObject2).zcL);
            }
          }
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
          LauncherUIBottomTabView localLauncherUIBottomTabView = new LauncherUIBottomTabView(((x)localObject2).yXg);
          localLauncherUIBottomTabView.setId(2131820634);
          if (localObject4 != null)
          {
            localLayoutParams.gravity = 80;
            ((ViewGroup)localObject4).addView(localLauncherUIBottomTabView, localLayoutParams);
          }
          ((x)localObject2).zcL = localLauncherUIBottomTabView;
          ((View)((x)localObject2).zcL).setVisibility(0);
          ((x)localObject2).zcL.setOnTabClickListener((c.a)localObject5);
          if ((localc != null) && (localc != ((x)localObject2).zcL))
          {
            ((x)localObject2).zcL.qa(localc.getShowFriendPoint());
            ((x)localObject2).zcL.qb(localc.getSettingsPoint());
            ((x)localObject2).zcL.NU(localc.getMainTabUnread());
            ((x)localObject2).zcL.NV(localc.getContactTabUnread());
            ((x)localObject2).zcL.NW(localc.getFriendTabUnread());
            ((x)localObject2).zcL.NX(localc.getSettingsTabUnread());
            ((x)localObject2).zcL.setTo(localc.getCurIdx());
          }
          ((HomeUI)localObject1).yXW.zcD = new HomeUI.1((HomeUI)localObject1);
          com.tencent.mm.sdk.g.d.ysm.execute(new HomeUI.12((HomeUI)localObject1));
          this.chattingTabUI.jdB = this;
          aP(getIntent());
        }
      }
      else
      {
        localObject1 = this.yYT;
        l1 = com.tencent.mm.platformtools.ah.aoy();
        localObject2 = ((HomeUI)localObject1).yXW;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.MainTabUI", "onResume start :%d", new Object[] { Integer.valueOf(((MainTabUI)localObject2).Sl) });
        if (((MainTabUI)localObject2).zcI.size() != 0)
        {
          localObject4 = (MMFragment)((MainTabUI)localObject2).zcI.get(Integer.valueOf(((MainTabUI)localObject2).Sl));
          ((m)localObject4).dAI();
          if ((localObject4 != null) && (com.tencent.matrix.b.isInstalled()) && (((MMFragment)localObject4).getActivity() != null))
          {
            localObject5 = ((MMFragment)localObject4).getActivity().getClass().getName();
            com.tencent.matrix.a.bLP.cw((String)localObject5 + "#" + localObject4.getClass().getSimpleName());
          }
        }
        if ((((MainTabUI)localObject2).zcz) && (((MainTabUI)localObject2).yXg.getIntent().hasExtra("isScrollFirst")) && (((MainTabUI)localObject2).yXg.getIntent().hasExtra("isShowHeader")))
        {
          localObject4 = (MainUI)((MainTabUI)localObject2).zcI.get(Integer.valueOf(0));
          if (localObject4 != null)
          {
            bool1 = ((MainTabUI)localObject2).yXg.getIntent().getBooleanExtra("isShowHeader", false);
            boolean bool2 = ((MainTabUI)localObject2).yXg.getIntent().getBooleanExtra("isScrollFirst", true);
            ((MainUI)localObject4).g(bool1, ((MainTabUI)localObject2).yXg.getIntent().getBooleanExtra("isShowHeaderWithAnim", false), bool2);
          }
        }
        if (((MainTabUI)localObject2).zcz)
        {
          ((MainTabUI)localObject2).zcz = false;
          ((MainTabUI)localObject2).atp("tab_main");
        }
        localObject4 = (MainUI)((MainTabUI)localObject2).zcI.get(Integer.valueOf(0));
        if (localObject4 != null)
        {
          ((MainUI)localObject4).dLE();
          ((MainUI)localObject4).dMV();
        }
        if (((MainTabUI)localObject2).Sl != 0) {
          break label3312;
        }
        aw.getNotification().bE(true);
        localObject4 = (m)((MainTabUI)localObject2).On(((MainTabUI)localObject2).Sl);
        if (localObject4 != null) {
          ((m)localObject4).dAJ();
        }
        ((MainTabUI)localObject2).zcz = false;
        int i = com.tencent.mm.sdk.platformtools.w.a(((MainTabUI)localObject2).yXg.getIntent(), "preferred_tab", 0);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI.MainTabUI", "doOnResume, tabIdx = %d", new Object[] { Integer.valueOf(i) });
        if (i != 0)
        {
          ((MainTabUI)localObject2).Om(i);
          ((MainTabUI)localObject2).yXg.getIntent().putExtra("preferred_tab", 0);
        }
        com.tencent.mm.sdk.b.a.ymk.c(((MainTabUI)localObject2).zcE);
        com.tencent.mm.sdk.b.a.ymk.c(((MainTabUI)localObject2).zcG);
        localObject2 = ((MainTabUI)localObject2).zcx;
        if (((x)localObject2).zcL != null) {
          ((x)localObject2).zcL.dAP();
        }
        aw.aaz();
        com.tencent.mm.model.c.Ru().a(((x)localObject2).zcQ);
        com.tencent.mm.x.c.PJ().a(((x)localObject2).zcP);
        aw.aaz();
        com.tencent.mm.model.c.YF().a((n.b)localObject2);
        com.tencent.mm.sdk.b.a.ymk.c(((x)localObject2).yWy);
        com.tencent.mm.sdk.b.a.ymk.c(((x)localObject2).zcR);
        com.tencent.mm.sdk.b.a.ymk.c(((x)localObject2).yWx);
        com.tencent.mm.blink.b.HP().o(new x.6((x)localObject2));
        localObject2 = ((HomeUI)localObject1).yXV;
        localObject4 = new ba();
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject4);
        if ((((ba)localObject4).cox.coy) && (!com.tencent.mm.platformtools.ah.isNullOrNil(((ba)localObject4).cox.bjm)))
        {
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI.GlobalAlertMgr", "  now show msg:%s", new Object[] { ((ba)localObject4).cox.bjm });
          com.tencent.mm.ui.base.h.b(((h)localObject2).yXg, ((ba)localObject4).cox.bjm, ((ba)localObject4).cox.title, true);
        }
        if (!((h)localObject2).a(((h)localObject2).yXi)) {
          aw.RO().o(new h.6((h)localObject2), 500L);
        }
        ((h)localObject2).yXi = null;
        com.tencent.mm.sdk.a.b.cP(true);
        bool1 = ((HomeUI)localObject1).yXU.dCm();
        if ((!bool1) && (aw.RG()))
        {
          com.tencent.mm.blink.b.HP().o(new HomeUI.37((HomeUI)localObject1));
          if ((com.tencent.mm.bh.d.fUP != null) && (com.tencent.mm.bh.d.fUO != null) && (!com.tencent.mm.platformtools.ah.isNullOrNil(com.tencent.mm.bh.d.fUO.alf())))
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "launcher onResume end track %s", new Object[] { com.tencent.mm.bh.d.fUP.alg() });
            localObject2 = new fa();
            ((fa)localObject2).csJ.username = com.tencent.mm.bh.d.fUP.alg();
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        if (!bool1)
        {
          j.a(((HomeUI)localObject1).yXg, 3, ((HomeUI)localObject1).yXW.Sl, "directReport_onResume");
          ((HomeUI)localObject1).yXW.Oj(360);
        }
        com.tencent.mm.ui.widget.h.b(((HomeUI)localObject1).yXg);
        ((HomeUI)localObject1).yXg.onSwipe(1.0F);
        ((HomeUI)localObject1).yXT = HomeUI.a.yYC;
        if (((HomeUI)localObject1).yXE)
        {
          ((HomeUI)localObject1).yXE = false;
          ((HomeUI)localObject1).yXE = false;
        }
        com.tencent.mm.ah.n.adb();
        l2 = System.currentTimeMillis();
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LauncherUI.HomeUI", "[Launching Application]");
        com.tencent.mm.kernel.l.n(((HomeUI)localObject1).yXg, false);
        com.tencent.mm.kernel.l.o(((HomeUI)localObject1).yXg, false);
        long l3 = System.currentTimeMillis();
        if (!((HomeUI)localObject1).yXg.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0).getBoolean("settings_landscape_mode", false)) {
          break label3324;
        }
        ((HomeUI)localObject1).yXg.setRequestedOrientation(-1);
        label1715:
        long l4 = System.currentTimeMillis();
        if (getInstance() != null)
        {
          com.tencent.mm.blink.b.HP().HS();
          ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("showprivacypolicy", ((HomeUI)localObject1).yYt);
          ((HomeUI)localObject1).qj(false);
          com.tencent.mm.sdk.b.a.ymk.c(((HomeUI)localObject1).qEr);
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - l4));
          if (aw.RG()) {
            ((HomeUI)localObject1).dBU();
          }
        }
        com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.LauncherUI.HomeUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - l3));
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - l2));
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "initView " + (System.currentTimeMillis() - l1));
        if (((HomeUI)localObject1).yXE)
        {
          ((HomeUI)localObject1).yXE = false;
          ((HomeUI)localObject1).yXE = false;
        }
        localObject2 = com.tencent.mm.app.p.Bv();
        ((com.tencent.mm.app.p)localObject2).bYJ = true;
        ((com.tencent.mm.app.p)localObject2).bYK.removeMessages(-1999);
        ((com.tencent.mm.app.p)localObject2).bYK.removeMessages(-2999);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.HomeUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - l1));
        if (r.ZU().booleanValue()) {
          ((HomeUI)localObject1).dBI();
        }
        i = com.tencent.mm.kernel.g.RL().Ru().getInt(ac.a.yLR, 0);
        if (i != 0)
        {
          com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLR, Integer.valueOf(0));
          if (r.ZP()) {}
        }
        switch (i)
        {
        default: 
          label2052:
          com.tencent.mm.blink.b.HP().o(new HomeUI.2((HomeUI)localObject1));
          if (((HomeUI)localObject1).getMainTabUI().Sl != 3)
          {
            localObject1 = (MoreTabUI)((HomeUI)localObject1).getMainTabUI().On(3);
            if ((((MoreTabUI)localObject1).zcZ != null) && (!((MoreTabUI)localObject1).zcZ.isVisible))
            {
              ((MoreTabUI)localObject1).zcZ.dPi();
              ((MoreTabUI)localObject1).cbV();
            }
          }
          localObject1 = this.chattingTabUI;
          ((NewChattingTabUI)localObject1).zdW = com.tencent.mm.platformtools.ah.aox();
          if (((NewChattingTabUI)localObject1).dbs())
          {
            ((NewChattingTabUI)localObject1).zdZ = new NewChattingTabUI.1((NewChattingTabUI)localObject1);
            com.tencent.mm.sdk.platformtools.al.p(new NewChattingTabUI.2((NewChattingTabUI)localObject1), 500L);
          }
          if (((NewChattingTabUI)localObject1).dCm())
          {
            ((NewChattingTabUI)localObject1).kS(3);
            if ((((NewChattingTabUI)localObject1).zee != null) && (((NewChattingTabUI)localObject1).zee.isSupportNavigationSwipeBack())) {
              ((NewChattingTabUI)localObject1).zee.getSwipeBackLayout().setEnableGesture(true);
            }
            label2221:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "resumeNormalJump");
            MMFragmentActivity.a.dCz();
            if (("pushcontent_notification".equals(com.tencent.mm.sdk.platformtools.w.n(getIntent(), "nofification_type"))) && (!bo.isNullOrNil(com.tencent.mm.sdk.platformtools.w.n(getIntent(), "Main_FromUserName"))))
            {
              localObject1 = com.tencent.mm.sdk.platformtools.w.n(getIntent(), "Main_FromUserName");
              i = com.tencent.mm.sdk.platformtools.w.a(getIntent(), "MainUI_User_Last_Msg_Type", 0);
              com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + (String)localObject1 + i);
              com.tencent.mm.plugin.report.service.h.qsU.e(10856, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(0) });
            }
            localObject1 = com.tencent.mm.sdk.platformtools.w.n(getIntent(), "LauncherUI.Shortcut.LaunchType");
            if (localObject1 != null)
            {
              if (!((String)localObject1).equals("launch_type_voip")) {
                break label3411;
              }
              com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
              startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip"));
              com.tencent.mm.plugin.report.service.h.qsU.e(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
            }
            label2439:
            localObject1 = com.tencent.mm.sdk.platformtools.w.n(getIntent(), "LauncherUI.switch.tab");
            if (!bo.isNullOrNil((String)localObject1))
            {
              this.yYT.getMainTabUI().atp((String)localObject1);
              getIntent().putExtra("LauncherUI.switch.tab", "");
            }
            if ((com.tencent.mm.sdk.platformtools.w.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) || (this.yYX))
            {
              this.yYX = false;
              localObject1 = getInstance();
              if (localObject1 != null) {
                ((LauncherUI)localObject1).yYT.dBO();
              }
              getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
              getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
            }
            bool1 = com.tencent.mm.sdk.platformtools.w.a(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
            if (!bool1) {
              break label3487;
            }
            localObject1 = com.tencent.mm.sdk.platformtools.w.n(getIntent(), "LauncherUI.Shortcut.Username");
            label2585:
            if (bool1)
            {
              com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = ".concat(String.valueOf(localObject1)));
              if (!bo.isNullOrNil((String)localObject1))
              {
                localObject4 = com.tencent.mm.plugin.base.model.b.Gz((String)localObject1);
                if (!bo.isNullOrNil((String)localObject4))
                {
                  if (t.nT((String)localObject4))
                  {
                    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                    if (!com.tencent.mm.aj.f.rV((String)localObject4)) {
                      break label3732;
                    }
                    if (!com.tencent.mm.aj.f.lg((String)localObject4)) {
                      break label3512;
                    }
                    localObject1 = new Intent();
                    ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                    ((Intent)localObject1).putExtra("Contact_User", (String)localObject4);
                    ((Intent)localObject1).putExtra("biz_chat_from_scene", 9);
                    ((Intent)localObject1).addFlags(67108864);
                    startActivity((Intent)localObject1);
                  }
                  label2716:
                  getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
                  getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
                }
              }
            }
            this.yYW = true;
          }
          break;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.blink.a.id(5);
        if (!yYS) {
          qo(false);
        }
        dCh();
        com.tencent.mm.blink.a.ks("LauncherUI");
        AppMethodBeat.o(29456);
        return;
        l2 = System.currentTimeMillis();
        MMActivity.initLanguage(((HomeUI)localObject1).yXg);
        try
        {
          localObject2 = new HashSet();
          localObject4 = ((HomeUI)localObject1).getString(2131298874).split(";");
          ((Set)localObject2).add(localObject4[0]);
          ((Set)localObject2).add(localObject4[1]);
          com.tencent.mm.model.s.b((Set)localObject2);
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RO().ac(new HomeUI.15((HomeUI)localObject1));
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).exe = ((LayoutInflater)((HomeUI)localObject1).yXg.getSystemService("layout_inflater"));
          l2 = System.currentTimeMillis();
          com.tencent.mm.kiss.a.b.SH();
          ((HomeUI)localObject1).contentView = com.tencent.mm.kiss.a.b.b(((HomeUI)localObject1).yXg, 2130970070);
          if ((((HomeUI)localObject1).contentView != null) && (Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.h.Mo())) {
            ((HomeUI)localObject1).contentView.setBackgroundColor(((HomeUI)localObject1).yXg.getResources().getColor(2131690316));
          }
          com.tencent.mm.blink.b.HP().HQ();
          ((FirstScreenFrameLayout)((HomeUI)localObject1).contentView.findViewById(2131825898)).dYt = new HomeUI.23((HomeUI)localObject1);
          com.tencent.mm.pluginsdk.model.app.al.dlK();
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).yXg.setContentView(((HomeUI)localObject1).contentView);
          Looper.myQueue().addIdleHandler(((HomeUI)localObject1).jZm);
          ((HomeUI)localObject1).yXD = true;
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI.HomeUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).initActionBar();
          ((HomeUI)localObject1).mActionBar.show();
          ((HomeUI)localObject1).contentView.post(new HomeUI.33((HomeUI)localObject1));
          com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - l1));
          com.tencent.mm.sdk.platformtools.al.p(new HomeUI.34((HomeUI)localObject1), 2000L);
          ((HomeUI)localObject1).contentView.addOnLayoutChangeListener(((HomeUI)localObject1).yYb);
          com.tencent.mm.pluginsdk.f.b(((HomeUI)localObject1).yXg, ((HomeUI)localObject1).contentView);
          ((HomeUI)localObject1).contentView.postDelayed(new HomeUI.35((HomeUI)localObject1), 20L);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
          }
        }
      }
      label3312:
      aw.getNotification().bE(false);
      break label1061;
      label3324:
      ((HomeUI)localObject1).yXg.setRequestedOrientation(1);
      break label1715;
      com.tencent.mm.ui.base.h.a(((HomeUI)localObject1).yXg, ((HomeUI)localObject1).getString(2131301120), "", new HomeUI.38((HomeUI)localObject1), null);
      break label2052;
      if (!((NewChattingTabUI)localObject1).zeh) {
        break label2221;
      }
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.LauncherUI.NewChattingTabUI", "[onResume] need exec this runnable!");
      com.tencent.mm.sdk.platformtools.al.ae(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      com.tencent.mm.sdk.platformtools.al.d(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      ((NewChattingTabUI)localObject1).zeh = false;
      break label2221;
      label3411:
      if (!((String)localObject1).equals("launch_type_voip_audio")) {
        break label2439;
      }
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
      startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio"));
      com.tencent.mm.plugin.report.service.h.qsU.e(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      break label2439;
      label3487:
      bool1 = com.tencent.mm.sdk.platformtools.w.a(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
      localObject1 = getIntent().getAction();
      break label2585;
      label3512:
      if (com.tencent.mm.aj.f.rX((String)localObject4))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject1).putExtra("enterprise_biz_name", (String)localObject4);
        ((Intent)localObject1).putExtra("enterprise_biz_display_name", com.tencent.mm.model.s.nE((String)localObject4));
        startActivity((Intent)localObject1);
        break label2716;
      }
      if (com.tencent.mm.aj.f.rY((String)localObject4))
      {
        localObject1 = com.tencent.mm.aj.f.rS((String)localObject4);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.aj.d)localObject1).aek())
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
          com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          break;
        }
      }
      localObject1 = getInstance();
      Object localObject3 = new Bundle();
      ((Bundle)localObject3).putInt("chat_from_scene", 3);
      ((LauncherUI)localObject1).startChatting((String)localObject4, (Bundle)localObject3, false);
      break label2716;
      label3732:
      localObject1 = getInstance();
      if (localObject1 == null) {
        break label2716;
      }
      ((LauncherUI)localObject1).startChatting((String)localObject4, null, false);
      break label2716;
      if (!yYS) {
        dCl();
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(29474);
    Object localObject = this.chattingTabUI;
    if (((NewChattingTabUI)localObject).zee != null)
    {
      localObject = ((NewChattingTabUI)localObject).zee.caz.getTalkerUserName();
      if (!com.tencent.mm.platformtools.ah.isNullOrNil((String)localObject))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "onSaveInstanceState:%s", new Object[] { localObject });
        paramBundle.putString("last_restore_talker", (String)localObject);
      }
    }
    AppMethodBeat.o(29474);
  }
  
  public void onSettle(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(29471);
    if ((this.yYV) && (!this.chattingTabUI.H(paramBoolean, paramInt))) {
      super.onSettle(paramBoolean, paramInt);
    }
    AppMethodBeat.o(29471);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(29465);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI", "onStop");
    com.tencent.mm.blink.a.HK();
    HomeUI localHomeUI = this.yYT;
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("showprivacypolicy", localHomeUI.yYt);
    super.onStop();
    AppMethodBeat.o(29465);
  }
  
  public void onSwipe(float paramFloat)
  {
    int i = 1;
    AppMethodBeat.i(29470);
    NewChattingTabUI localNewChattingTabUI;
    if (this.yYV)
    {
      localNewChattingTabUI = this.chattingTabUI;
      com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", new Object[] { Float.valueOf(paramFloat), Long.valueOf(320L), Boolean.valueOf(localNewChattingTabUI.zdV.dBP()) });
      if (localNewChattingTabUI.dbs()) {
        break label87;
      }
      if (i == 0) {
        super.onSwipe(paramFloat);
      }
    }
    AppMethodBeat.o(29470);
    return;
    label87:
    Object localObject;
    if ((paramFloat == 0.0F) && (!localNewChattingTabUI.mChattingClosed))
    {
      localNewChattingTabUI.Os(0);
      localObject = (ImageView)localNewChattingTabUI.jdB.getWindow().getDecorView().findViewById(2131820649);
      if (localObject != null)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE no cache!");
        ((ImageView)localObject).setVisibility(8);
        ((ImageView)localObject).setImageDrawable(null);
      }
      if (localNewChattingTabUI.mChattingInAnim != null) {
        localNewChattingTabUI.mChattingInAnim.cancel();
      }
    }
    for (;;)
    {
      if (localNewChattingTabUI.zdV.dBP()) {
        break label462;
      }
      if (Float.compare(1.0F, paramFloat) <= 0) {
        break label359;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Boolean.FALSE });
      i = 0;
      break;
      if ((paramFloat == 1.0F) && (!localNewChattingTabUI.mChattingClosed) && (!localNewChattingTabUI.zee.dFY()))
      {
        localNewChattingTabUI.jdB.getWindow().setBackgroundDrawableResource(2131690402);
        localObject = (ImageView)localNewChattingTabUI.jdB.getWindow().getDecorView().findViewById(2131820649);
        if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0) && (((ImageView)localObject).getTag() != null))
        {
          ((View)((ImageView)localObject).getTag()).setVisibility(0);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
          ((ImageView)localObject).setVisibility(8);
        }
        if ((localNewChattingTabUI.zee.getContentView() != null) && (localNewChattingTabUI.zee.getContentView().getX() <= 0.0F)) {
          localNewChattingTabUI.Os(8);
        } else {
          localNewChattingTabUI.Os(0);
        }
      }
    }
    label359:
    for (i = 0;; i = 1)
    {
      localObject = localNewChattingTabUI.jdB.findViewById(2131820633);
      ImageView localImageView = (ImageView)localNewChattingTabUI.jdB.findViewById(2131820649);
      if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null) && (!localNewChattingTabUI.mChattingClosed) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
      {
        localImageView.setVisibility(0);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
        localNewChattingTabUI.Os(8);
      }
      NewChattingTabUI.resetViewTranX((View)localObject, localImageView, paramFloat);
      break;
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
    AppMethodBeat.i(29478);
    Object localObject3 = this.chattingTabUI;
    Object localObject1 = localObject2;
    if (((NewChattingTabUI)localObject3).zee != null)
    {
      localObject1 = localObject2;
      if (((NewChattingTabUI)localObject3).zee.dGa() != null)
      {
        if (((NewChattingTabUI)localObject3).zee.isSupportCustomActionBar()) {
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
      AppMethodBeat.o(29478);
      return localObject2;
      label70:
      localObject1 = localObject2;
      if (!com.tencent.mm.compatible.util.d.iU(22))
      {
        localObject3 = ((NewChattingTabUI)localObject3).zee.dGa().startActionMode(paramCallback);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject3;
        }
      }
    }
  }
  
  public final void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(29481);
    this.yYT.dBN();
    this.chattingTabUI.startChatting(paramString, paramBundle, paramBoolean);
    AppMethodBeat.o(29481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI
 * JD-Core Version:    0.7.0.1
 */