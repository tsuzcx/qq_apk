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
import com.tencent.mm.g.a.ae;
import com.tencent.mm.g.a.be;
import com.tencent.mm.g.a.be.b;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.ui.WelcomeActivity;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI;
import com.tencent.mm.pluginsdk.g.e.a;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bh;
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
  private static ArrayList<LauncherUI> FLW;
  private static ArrayList<WeakReference<LauncherUI>> FLX;
  private static boolean FLY;
  public static long FLZ;
  private static boolean FMa;
  private static boolean FMh;
  public HomeUI FMb;
  private n FMc;
  public boolean FMd;
  boolean FMe;
  private boolean FMf;
  private s FMg;
  private boolean FMi;
  private com.tencent.mm.sdk.platformtools.ap FMj;
  private Runnable FMk;
  private boolean FMl;
  int FMm;
  private NewChattingTabUI chattingTabUI;
  private Intent doO;
  
  static
  {
    AppMethodBeat.i(33334);
    FLW = new ArrayList();
    FLX = new ArrayList();
    FLY = true;
    FMa = false;
    FMh = false;
    AppMethodBeat.o(33334);
  }
  
  public LauncherUI()
  {
    AppMethodBeat.i(33295);
    this.FMb = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.FMb);
    this.FMc = new n();
    this.doO = null;
    this.FMd = false;
    this.FMe = false;
    this.FMf = false;
    this.FMg = new s("MicroMsg.LauncherUI");
    this.FMi = false;
    this.FMj = new com.tencent.mm.sdk.platformtools.ap();
    this.FMk = new Runnable()
    {
      long ed = 2000L;
      
      @TargetApi(17)
      public final void run()
      {
        AppMethodBeat.i(33293);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck tid[%d]", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
        com.tencent.mm.sdk.platformtools.aq.az(this);
        if (az.arW())
        {
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck done uin[%d]", new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()) });
          AppMethodBeat.o(33293);
          return;
        }
        if ((com.tencent.mm.modelstat.d.aBC()) || (com.tencent.mm.sdk.a.b.foreground))
        {
          this.ed += 2000L;
          if (this.ed > 10000L) {
            this.ed = 2000L;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "resumeLogoutJump logoutExitCheck isAppOnForeground[%b] foreground[%b] trigger next [%d]", new Object[] { Boolean.valueOf(com.tencent.mm.modelstat.d.aBC()), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground), Long.valueOf(this.ed) });
          com.tencent.mm.sdk.platformtools.aq.n(this, this.ed);
          AppMethodBeat.o(33293);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit!!!");
        if (WXHardCoderJNI.isCheckEnv()) {
          com.tencent.mm.sdk.g.b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33292);
              WXHardCoderJNI.terminateApp(Process.myTid(), SystemClock.elapsedRealtimeNanos());
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp done");
              AppMethodBeat.o(33292);
            }
          }, "terminateApp");
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "resumeLogoutJump terminateApp logoutExitCheck logout and background kill exit app done");
        AppMethodBeat.o(33293);
      }
    };
    this.FMl = false;
    this.FMm = 0;
    AppMethodBeat.o(33295);
  }
  
  private void bi(Intent paramIntent)
  {
    AppMethodBeat.i(33307);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "handleJump");
    if (!az.afw())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
      paramIntent = new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.adn(), "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(33307);
      return;
    }
    Object localObject1 = new kj();
    ((kj)localObject1).doN.doO = this.doO;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BakToPcUI");
      }
      for (paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");; paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI"))
      {
        paramIntent.setFlags(268435456);
        MMWizardActivity.V(this, paramIntent);
        AppMethodBeat.o(33307);
        return;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
      }
    }
    if ("back_to_pcmgr_error_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.V(this, paramIntent);
      AppMethodBeat.o(33307);
      return;
    }
    if ("clear_msg_not_finish_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      com.tencent.mm.ui.base.h.j(this, 2131757416, 2131755906);
      AppMethodBeat.o(33307);
      return;
    }
    if ("backup_move_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.V(this, paramIntent);
      AppMethodBeat.o(33307);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(paramIntent, "show_update_dialog", false)) {
      bj(paramIntent);
    }
    String str = com.tencent.mm.sdk.platformtools.y.getStringExtra(paramIntent, "Main_User");
    localObject1 = com.tencent.mm.sdk.platformtools.y.getStringExtra(paramIntent, "nofification_type");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "[handleJump] user:%s", new Object[] { str });
    Object localObject2;
    int i;
    if ((str != null) && (!str.equals("")))
    {
      az.arV();
      localObject2 = com.tencent.mm.model.c.apR().aIn(str);
      if (localObject2 != null)
      {
        i = ((com.tencent.mm.g.c.ay)localObject2).field_unReadCount;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "[oneliang] user:%s, conversation :%s, unReadCount:%s", new Object[] { str, localObject2, Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0) {
        j = com.tencent.mm.sdk.platformtools.y.getIntExtra(paramIntent, "pushcontent_unread_count", 0);
      }
      MMAppMgr.Lo();
      com.tencent.mm.sdk.b.a.ESL.l(new ae());
      boolean bool = com.tencent.mm.sdk.platformtools.y.getBooleanExtra(paramIntent, "Intro_Is_Muti_Talker", true);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((!bool) && (j > 0))
      {
        i = com.tencent.mm.sdk.platformtools.y.getIntExtra(paramIntent, "Intro_Bottle_unread_count", 0);
        if (i > 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.bs.d.O(this, "bottle", ".ui.BottleConversationUI");
        }
      }
      if (!bool)
      {
        if (w.sU(str))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
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
            MMWizardActivity.V(this, (Intent)localObject1);
          }
          AppMethodBeat.o(33307);
          return;
          if (!w.tc(str)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
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
        if (com.tencent.mm.am.f.pc(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("biz_chat_from_scene", 4);
          com.tencent.mm.bs.d.e(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if (com.tencent.mm.am.f.wM(str))
        {
          localObject1 = com.tencent.mm.am.f.ei(str);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).Ji())
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
        if (af.rz(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("app_brand_conversation_from_scene", 3);
          paramIntent.putExtra("finish_direct", true);
          paramIntent.putExtra("key_need_send_video", false);
          com.tencent.mm.bs.d.e(this, ".ui.conversation.AppBrandServiceConversationUI", paramIntent);
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
            if (com.tencent.mm.am.f.pc(str))
            {
              paramIntent.putExtra("Contact_User", str);
              paramIntent.addFlags(67108864);
              paramIntent.putExtra("biz_chat_from_scene", 4);
              com.tencent.mm.bs.d.e(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
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
          if ((getInstance() == null) || (!com.tencent.mm.am.f.pc(str))) {
            break;
          }
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          com.tencent.mm.bs.d.e(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if ((bt.isNullOrNil(str)) || (!"new_msg_nofification".equals(localObject1))) {
          break;
        }
        if (paramIntent == null) {}
        for (localObject1 = "null";; localObject1 = paramIntent)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI", "[handleJump] intent:%s", new Object[] { localObject1 });
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
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI", "LauncherUI.getInstance is null! ");
        break;
      }
      i = 0;
      break;
      i = 0;
    }
  }
  
  private void bj(Intent paramIntent)
  {
    AppMethodBeat.i(33315);
    int i = com.tencent.mm.sdk.platformtools.y.getIntExtra(paramIntent, "update_type", -1);
    if (i == -1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
      AppMethodBeat.o(33315);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(405L, 28L, 1L, true);
    com.tencent.mm.plugin.report.service.h localh;
    if (com.tencent.mm.plugin.q.d.cRq() != null)
    {
      paramIntent = com.tencent.mm.plugin.q.d.cRq().c(this, null);
      if (paramIntent == null)
      {
        AppMethodBeat.o(33315);
        return;
      }
      localh = com.tencent.mm.plugin.report.service.h.vKh;
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
  
  private void eQH()
  {
    AppMethodBeat.i(33298);
    int i = FLW.indexOf(this);
    if (i >= 0) {
      FLW.remove(i);
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(FLW.size()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(33298);
  }
  
  private void eQI()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33300);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI", "[whatsnew] checkIfStartWhatsNew.");
    if (FMh)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "[whatsnew] has been played.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!com.tencent.mm.kernel.g.afz().aeI())
    {
      com.tencent.mm.kernel.g.afz();
      if (!com.tencent.mm.kernel.a.aeH())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "[whatsnew] not login yet, skip.");
        AppMethodBeat.o(33300);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "[whatsnew] account not initiate, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!eQJ())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "[whatsnew] notSwitchOrHold is false, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    boolean bool3 = com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI.enter_from_reg", false);
    boolean bool4;
    boolean bool1;
    if ((!bool3) && (com.tencent.mm.pluginsdk.g.e.BRG != null) && (com.tencent.mm.pluginsdk.g.e.BRG.Ly()) && (az.afw()))
    {
      if (an.aFx("show_whatsnew"))
      {
        FMh = true;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "[whatsnew] show whatsnew.");
        MMAppMgr.aY(this);
        com.tencent.mm.blink.a.SS();
        AppMethodBeat.o(33300);
      }
    }
    else
    {
      e.a locala = com.tencent.mm.pluginsdk.g.e.BRG;
      bool4 = az.afw();
      if (locala != null) {
        break label262;
      }
      bool1 = true;
      if ((locala == null) || (!locala.Ly())) {
        break label267;
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "[whatsnew] do not show whatsnew. enter_from_reg=%s accHasReady=%s MMAppMgr is null %s isWhatsNewAvailable=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      AppMethodBeat.o(33300);
      return;
      label262:
      bool1 = false;
      break;
      label267:
      bool2 = false;
    }
  }
  
  private boolean eQJ()
  {
    AppMethodBeat.i(33304);
    if ((this.doO != null) && (!com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.doO, "Intro_Switch", false)) && (az.arW()) && (!az.aeC()))
    {
      AppMethodBeat.o(33304);
      return true;
    }
    AppMethodBeat.o(33304);
    return false;
  }
  
  private boolean eQK()
  {
    AppMethodBeat.i(33305);
    if (this.doO != null)
    {
      if ((com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.doO, "absolutely_exit", false)) || (com.tencent.mm.sdk.platformtools.y.getIntExtra(this.doO, "absolutely_exit_pid", 0) == Process.myPid()))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        finish();
        com.tencent.mm.plugin.report.service.g.KK(8);
        MMAppMgr.vy(com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.doO, "kill_service", true));
        System.exit(0);
        AppMethodBeat.o(33305);
        return true;
      }
      if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.doO, "can_finish", false))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
        az.aeS().eg(true);
        if (com.tencent.mm.kernel.l.cj(getApplicationContext())) {
          com.tencent.mm.booter.b.bF(getApplicationContext());
        }
        com.tencent.mm.plugin.report.service.g.KK(8);
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), "com.tencent.mm.permission.MM_MESSAGE");
        finish();
        com.tencent.mm.ui.base.b.jI(this);
        AppMethodBeat.o(33305);
        return true;
      }
      if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.doO, "exit_and_restart", false))
      {
        Mars.onSingalCrash(0);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "exit and restart myself.");
        com.tencent.mm.sdk.platformtools.ad.eFw();
        finish();
        Object localObject = new Intent(this, LauncherUI.class);
        ((Intent)localObject).addFlags(67108864);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "restart, try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        MMAppMgr.eRd();
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(33305);
        return true;
      }
    }
    AppMethodBeat.o(33305);
    return false;
  }
  
  private void eQL()
  {
    AppMethodBeat.i(33306);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "switch to wxid %s", new Object[] { aj.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "") });
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).addFlags(536870912);
    ((Intent)localObject).putExtra("key_scene", 1);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.jJ(this);
    AppMethodBeat.o(33306);
  }
  
  private void eQM()
  {
    AppMethodBeat.i(33308);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "resumeLogoutJump");
    if ((this.doO != null) && (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI.jump_from_uimode_check", false)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "dancy uimode check from background, not jumpToLogin or welcome!");
      AppMethodBeat.o(33308);
      return;
    }
    MMFragmentActivity.a.eRe();
    Object localObject = com.tencent.mm.model.ay.gNa.ao("login_user_name", "");
    if ((!az.arW()) && (((String)localObject).equals("")))
    {
      localObject = new Intent(this, WelcomeActivity.class);
      ((Intent)localObject).addFlags(536870912);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jJ(this);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
      com.tencent.mm.sdk.platformtools.aq.az(this.FMk);
      com.tencent.mm.sdk.platformtools.aq.n(this.FMk, 2000L);
      AppMethodBeat.o(33308);
      return;
    }
    if ((this.doO.getFlags() & 0x4000000) == 67108864) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.doO, "Intro_Notify", false);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", new Object[] { Boolean.valueOf(this.FMd), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(az.aeC()) });
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", new Object[] { Boolean.valueOf(az.arW()) });
      az.hold();
      if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
        this.FMf = true;
      }
      jj(this);
      az.unhold();
      AppMethodBeat.o(33308);
      return;
    }
  }
  
  public static int getCurrentTabIndex()
  {
    AppMethodBeat.i(33297);
    if ((getInstance() != null) && (getInstance().getHomeUI() != null) && (getInstance().getHomeUI().getMainTabUI() != null))
    {
      int i = getInstance().getHomeUI().getMainTabUI().Zo;
      AppMethodBeat.o(33297);
      return i;
    }
    AppMethodBeat.o(33297);
    return -1;
  }
  
  public static LauncherUI getInstance()
  {
    AppMethodBeat.i(33296);
    if (FLW.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", new Object[] { bt.eGN() });
      AppMethodBeat.o(33296);
      return null;
    }
    LauncherUI localLauncherUI = (LauncherUI)FLW.get(0);
    AppMethodBeat.o(33296);
    return localLauncherUI;
  }
  
  private void jj(Context paramContext)
  {
    AppMethodBeat.i(33309);
    if (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.doO, "LauncherUI.jump_switch_account", false))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "launcher to switch account");
      eQL();
      AppMethodBeat.o(33309);
      return;
    }
    if ((com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.doO, "Intro_Switch", false)) || (this.FMd) || (com.tencent.mm.kernel.a.aer()))
    {
      this.FMb.getMainTabUI().bFb();
      com.tencent.mm.kernel.g.afC().qU("[normal logout]");
      Mars.onSingalCrash(0);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
      com.tencent.mm.sdk.platformtools.ad.eFw();
      finish();
      Object localObject = new Intent(paramContext, LauncherUI.class);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
      MMAppMgr.eRd();
      Process.killProcess(Process.myPid());
      AppMethodBeat.o(33309);
      return;
    }
    if (!com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.doO, "LauncherUI.jump_switch_account", false))
    {
      paramContext = com.tencent.mm.model.ay.gNa.ao("login_user_name", "");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "%s jumpToLogin", new Object[] { paramContext });
      if (!bt.isNullOrNil(paramContext)) {
        break label387;
      }
      paramContext = new Intent(this, WelcomeActivity.class);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bd(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.adn(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jJ(this);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.KK(8);
      com.tencent.mm.sdk.platformtools.aq.az(this.FMk);
      com.tencent.mm.sdk.platformtools.aq.n(this.FMk, 2000L);
      AppMethodBeat.o(33309);
      return;
      label387:
      boolean bool = aj.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "switchAccount %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      paramContext = new Intent(this, SettingsSwitchAccountUI.class);
      paramContext.addFlags(536870912);
      paramContext.putExtra("key_scene", 2);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bd(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.adn(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jG(this);
    }
    int i = bt.aGh(com.tencent.mm.model.ay.gNa.ao("last_login_use_voice", ""));
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "pluginSwitch  ".concat(String.valueOf(i)));
    paramContext = new Intent();
    if ((i & 0x20000) != 0) {
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginVoiceUI");
    }
    for (;;)
    {
      paramContext.addFlags(536870912);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bd(paramContext);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramContext.adn(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jG(this);
      break;
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginPasswordUI");
    }
  }
  
  public static void jk(Context paramContext)
  {
    AppMethodBeat.i(33328);
    Object localObject = new Intent(paramContext, LauncherUI.class);
    ((Intent)localObject).addFlags(67108864);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33328);
  }
  
  private void vv(boolean paramBoolean)
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
      n.eQP();
    }
    for (paramBoolean = false;; paramBoolean = true)
    {
      this.FMi = paramBoolean;
      do
      {
        AppMethodBeat.o(33302);
        return;
      } while (this.FMi);
      if (this.FMc.aT(this)) {
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
        LauncherUI.this.FMb.getMainTabUI().eRl();
        AppMethodBeat.o(33294);
      }
    };
    if (this.chattingTabUI.vE(paramBoolean))
    {
      this.FMb.vs(this.chattingTabUI.FRm.isSupportCustomActionBar());
      this.FMb.getMainTabUI().eRo();
    }
    AppMethodBeat.o(33330);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33319);
    boolean bool;
    if (this.chattingTabUI.eQN())
    {
      NewChattingTabUI localNewChattingTabUI = this.chattingTabUI;
      if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
        com.tencent.mm.sdk.platformtools.aq.az(localNewChattingTabUI.mStartChattingRunnable);
      }
      if (localNewChattingTabUI.isAnimating) {}
      for (bool = true; bool; bool = localNewChattingTabUI.FRm.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent))
      {
        AppMethodBeat.o(33319);
        return true;
      }
    }
    if (this.FMb.dispatchKeyEvent(paramKeyEvent))
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
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", new Object[] { paramKeyEvent.getMessage() });
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.LauncherUI", paramKeyEvent, "", new Object[0]);
      AppMethodBeat.o(33319);
    }
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(33316);
    super.finish();
    eQH();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(FLW.size()), bt.eGN() });
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
    for (localObject1 = ((NewChattingTabUI)localObject1).FRm;; localObject1 = null)
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
    return this.FMb;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str1 = null;
    Object localObject1 = null;
    AppMethodBeat.i(33310);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.LauncherUI", "edw on activity result");
    Object localObject2 = this.chattingTabUI;
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 226) || (paramInt1 == 30762) || (paramInt1 == 1111)) && (((NewChattingTabUI)localObject2).FRm != null)) {
      ((NewChattingTabUI)localObject2).FRm.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((NewChattingTabUI.acceptRequestCode(paramInt1)) && (((NewChattingTabUI)localObject2).FRm == null))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
      com.tencent.mm.sdk.platformtools.aq.az(((NewChattingTabUI)localObject2).FRo);
      ((NewChattingTabUI)localObject2).FRo.FRx = 0;
      ((NewChattingTabUI)localObject2).FRo.requestCode = paramInt1;
      ((NewChattingTabUI)localObject2).FRo.bRZ = paramInt2;
      ((NewChattingTabUI)localObject2).FRo.doc = paramIntent;
      com.tencent.mm.sdk.platformtools.aq.f(((NewChattingTabUI)localObject2).FRo);
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(33310);
      return;
    }
    localObject2 = this.FMb;
    if (((HomeUI)localObject2).FKI)
    {
      if (paramInt1 == 1)
      {
        az.arV();
        if (!bt.l((Boolean)com.tencent.mm.model.c.afk().get(12323, null))) {
          com.tencent.mm.platformtools.y.showAddrBookUploadConfirm(((HomeUI)localObject2).FKl, null, false, 3);
        }
        AppMethodBeat.o(33310);
        return;
      }
      if (paramInt1 == 22722)
      {
        str1 = (String)com.tencent.mm.kernel.g.afB().afk().get(274436, null);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
        if (paramIntent != null) {
          localObject1 = paramIntent.getBundleExtra("result_data");
        }
        if ((localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("agree_privacy")))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "agree privacy policy");
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(712L, 4L, 1L, false);
          localObject1 = new com.tencent.mm.plugin.account.model.g(1, str1);
          com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject1, 0);
          if ((com.tencent.mm.ax.b.yL(str1)) && (com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.Fth, false)))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "needbirthday true");
            com.tencent.mm.sdk.platformtools.aq.n(new HomeUI.24((HomeUI)localObject2), 100L);
          }
        }
      }
      while ((paramInt1 == 65534) && (paramInt2 == -1))
      {
        an.aFy("welcome_page_show");
        com.tencent.mm.kernel.l.o(((HomeUI)localObject2).FKl, true);
        MMAppMgr.Lo();
        MMAppMgr.m(((HomeUI)localObject2).FKl, true);
        ((HomeUI)localObject2).FKl.finish();
        AppMethodBeat.o(33310);
        return;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "disagree privacy policy");
        localObject1 = new com.tencent.mm.plugin.account.model.g(2, str1);
        com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(712L, 5L, 1L, false);
        continue;
        if (paramInt1 == 22723)
        {
          String str2 = (String)com.tencent.mm.kernel.g.afB().afk().get(274436, null);
          localObject1 = str1;
          if (paramIntent != null) {
            localObject1 = paramIntent.getBundleExtra("result_data");
          }
          if (localObject1 != null) {
            if (((Bundle)localObject1).getString("go_next", "").equals("birthdayComfirmOK"))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "verify birthday ok");
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fth, Boolean.FALSE);
            }
            else if (((Bundle)localObject1).getString("go_next", "").equals("gdpr_confirm_logout"))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "quit verify birthday after H5-warnning");
              localObject1 = new com.tencent.mm.plugin.account.model.g(2, str2);
              com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject1, 0);
              com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(712L, 5L, 1L, false);
            }
          }
        }
      }
      if ((paramInt1 == 30764) && (paramIntent != null))
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.FtT, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b(((HomeUI)localObject2).FKl, "android.permission.ACCESS_COARSE_LOCATION", 66);
        }
      }
    }
    AppMethodBeat.o(33310);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(33320);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "onBackPressed");
    Object localObject = new Intent("android.intent.action.MAIN");
    ((Intent)localObject).addCategory("android.intent.category.HOME");
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/LauncherUI", "onBackPressed", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "onBackPressed", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33320);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(33325);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.FMb;
    com.tencent.mm.pluginsdk.g.b(paramConfiguration.FKl, paramConfiguration.contentView);
    AppMethodBeat.o(33325);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33299);
    com.tencent.mm.blink.a.lb(com.tencent.mm.kernel.h.afF().gdR);
    if (ai.Eq()) {
      setTheme(2131820569);
    }
    long l1;
    long l2;
    int i;
    boolean bool1;
    for (;;)
    {
      l1 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bt.iQ(this) });
      super.onCreate(paramBundle);
      MainProcessChecker.ako(getClass().getName());
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
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
        }
      }
      paramBundle = FLX.iterator();
      while (paramBundle.hasNext())
      {
        localObject1 = (LauncherUI)((WeakReference)paramBundle.next()).get();
        if (localObject1 != null) {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "Check launcher instance found one %s", new Object[] { localObject1 });
        }
      }
      setTheme(2131820574);
    }
    Object localObject1 = null;
    paramBundle = null;
    Object localObject3;
    if (!bool1)
    {
      localObject3 = FLW.iterator();
      localObject1 = paramBundle;
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (LauncherUI)((Iterator)localObject3).next();
        if (((LauncherUI)localObject1).getTaskId() != i)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", new Object[] { Integer.valueOf(localObject1.hashCode()), Integer.valueOf(((LauncherUI)localObject1).getTaskId()), Integer.valueOf(i) });
          paramBundle = bt.aA(this, i);
          if (paramBundle != null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), paramBundle.topActivity.getClassName(), paramBundle.baseActivity.getClassName(), Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
            if (paramBundle.baseActivity.getPackageName().equals(localObject2)) {
              break label589;
            }
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + paramBundle.baseActivity.getPackageName());
            finish();
            if (bt.aA(this, ((LauncherUI)localObject1).getTaskId()) != null)
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
              paramBundle = new Intent(this, LauncherUI.class);
              paramBundle.addFlags(268435456);
              paramBundle = new com.tencent.mm.hellhoundlib.b.a().bd(paramBundle);
              com.tencent.mm.hellhoundlib.a.a.a(this, paramBundle.adn(), "com/tencent/mm/ui/LauncherUI", "checkInstance", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramBundle.lS(0));
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
        AppMethodBeat.o(33299);
        return;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", new Object[] { Integer.valueOf(i) });
        finish();
        i = 0;
        continue;
        label589:
        ((LauncherUI)localObject1).finish();
        FLW.remove(localObject1);
        break;
        if (!FLW.isEmpty())
        {
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = bt.aA(this, i);
          }
          if (paramBundle == null) {
            break label887;
          }
          localObject1 = paramBundle.baseActivity.getClassName();
          localObject2 = paramBundle.baseActivity.getClassName();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), localObject2, localObject1, Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
          localObject3 = getComponentName().getClassName();
          if ((paramBundle.numActivities > 1) && (((String)localObject3).equals(localObject1)) && (((String)localObject3).equals(localObject2)))
          {
            finish();
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(FLW.size()) });
            i = 0;
            continue;
          }
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", new Object[] { Integer.valueOf(FLW.size()), Boolean.valueOf(bool1) });
          FLW.clear();
        }
        for (;;)
        {
          FLW.add(this);
          FLX.add(new WeakReference(this));
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d weak check %d, use time %d", new Object[] { Integer.valueOf(FLW.size()), Integer.valueOf(FLX.size()), Long.valueOf(System.currentTimeMillis() - l2) });
          i = 1;
          break;
          label887:
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(FLW.size()) });
          FLW.clear();
        }
      }
    }
    if ((getIntent() != null) && (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI.jump_from_uimode_check", false)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "dancy onCreate uimode check from background, finish LauncherUI");
      finish();
      AppMethodBeat.o(33299);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "onCreate normally");
    this.FMb = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.FMb);
    this.chattingTabUI.lTx = this;
    paramBundle = this.FMb;
    localObject1 = this.chattingTabUI;
    paramBundle.FKl = this;
    paramBundle.FLa = ((a)localObject1);
    localObject1 = paramBundle.FLc;
    ((MainTabUI)localObject1).FKl = this;
    ((MainTabUI)localObject1).FPF = paramBundle;
    Object localObject2 = ((MainTabUI)localObject1).FPE;
    ((z)localObject2).FKl = this;
    ((z)localObject2).FPS = paramBundle;
    ((MainTabUI)localObject1).lRQ = paramBundle;
    paramBundle.FLb = new h(this, paramBundle);
    NotifyReceiver.Tw();
    com.tencent.mm.pluginsdk.g.aJ(paramBundle.FKl);
    paramBundle.mActionBar = getSupportActionBar();
    paramBundle.uAo = findViewById(2131296345);
    if (paramBundle.mActionBar != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131099879)));
      }
      paramBundle.mActionBar.hide();
    }
    setRequestedOrientation(1);
    paramBundle.FLd = getResources().getColor(2131100705);
    paramBundle.FLe = Color.alpha(paramBundle.FLd);
    paramBundle = com.tencent.mm.model.ay.gNa.ao("login_user_name", "");
    this.doO = getIntent();
    localObject1 = this.FMg;
    ((s)localObject1).BNB = this.doO.getBooleanExtra("splash-hack-activity-recreate", false);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", new Object[] { ((s)localObject1).mTag, Boolean.valueOf(((s)localObject1).BNB) });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", new Object[] { paramBundle, Boolean.valueOf(az.arW()), Boolean.valueOf(FLY) });
    if (eQK())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "handleExitIntent return");
      AppMethodBeat.o(33299);
      return;
    }
    if ((!FLY) && ((az.arW()) || (!paramBundle.equals(""))))
    {
      FLZ = l1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.d.cKZ));
    }
    label1594:
    for (;;)
    {
      com.tencent.mm.pluginsdk.model.app.q.j(this, "");
      eQI();
      ai.aF(this);
      AppMethodBeat.o(33299);
      return;
      FLZ = l1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.d.cKZ));
      setRequestedOrientation(1);
      bool1 = az.arW();
      paramBundle = com.tencent.mm.model.ay.gNa.ao("login_user_name", "");
      if ((!bool1) && (paramBundle.equals(""))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1488;
        }
        com.tencent.mm.sdk.platformtools.i.ETx = false;
        break;
      }
      label1488:
      bool1 = false;
      if ((com.tencent.mm.sdk.platformtools.i.ETy) && (com.tencent.mm.sdk.platformtools.i.ETx))
      {
        FMa = true;
        bool1 = MMAppMgr.a(this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33290);
            LauncherUI.a(LauncherUI.this);
            LauncherUI.aPL();
            com.tencent.mm.pluginsdk.h.a.a.o.bAT();
            LauncherUI.b(LauncherUI.this);
            AppMethodBeat.o(33290);
          }
        });
      }
      for (;;)
      {
        if (bool1) {
          break label1594;
        }
        vv(true);
        FMa = false;
        com.tencent.mm.pluginsdk.h.a.a.o.bAT();
        com.tencent.mm.plugin.report.service.g.KK(8);
        eQM();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        com.tencent.mm.sdk.platformtools.aq.az(this.FMk);
        com.tencent.mm.sdk.platformtools.aq.n(this.FMk, 2000L);
        break;
        MMAppMgr.jq(this);
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(33324);
    if (this.chattingTabUI.eQN())
    {
      AppMethodBeat.o(33324);
      return false;
    }
    HomeUI localHomeUI = this.FMb;
    if ((localHomeUI.FLa == null) || (localHomeUI.FLa.eQN()))
    {
      AppMethodBeat.o(33324);
      return false;
    }
    localHomeUI.FLv = paramMenu;
    int i = localHomeUI.FKl.getSupportActionBar().getHeight();
    int j = com.tencent.mm.cd.a.ap(localHomeUI.FKl, 2131165296);
    if ((localHomeUI.FLc.Zo == 3) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()))
    {
      localHomeUI.FLu = paramMenu.add(0, 5, 0, 2131764454);
      if (localHomeUI.FLq == null)
      {
        com.tencent.mm.kiss.a.b.agA();
        localHomeUI.FLq = com.tencent.mm.kiss.a.b.c(localHomeUI.FKl, 2131492929);
        paramMenu = new ViewGroup.LayoutParams(j, i);
        localHomeUI.FLq.setLayoutParams(paramMenu);
        localHomeUI.FLq.setMinimumHeight(i);
        localHomeUI.FLq.setMinimumWidth(j);
        localHomeUI.FLq.setOnLongClickListener(new HomeUI.5(localHomeUI));
        localHomeUI.FLq.setOnClickListener(new HomeUI.6(localHomeUI));
      }
      if (localHomeUI.FLg)
      {
        localHomeUI.FLq.findViewById(2131305884).setVisibility(0);
        paramMenu = com.tencent.mm.plugin.story.h.h.ynv;
        com.tencent.mm.plugin.story.h.h.tP(1L);
      }
      for (;;)
      {
        localHomeUI.FLu.setActionView(localHomeUI.FLq);
        localHomeUI.eQs();
        localHomeUI.eQi();
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.LauncherUI.HomeUI", "onCreateOptionsMenu");
        AppMethodBeat.o(33324);
        return true;
        localHomeUI.FLq.findViewById(2131305884).setVisibility(8);
        paramMenu = com.tencent.mm.plugin.story.h.h.ynv;
        com.tencent.mm.plugin.story.h.h.tP(0L);
      }
    }
    Object localObject;
    if (i == 0)
    {
      localObject = localHomeUI.FKl.getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels) {
        i = localHomeUI.FKl.getResources().getDimensionPixelSize(2131165251);
      }
    }
    for (;;)
    {
      localHomeUI.FLr = paramMenu.add(0, HomeUI.FLj, 0, 2131764452);
      localHomeUI.FLr.setIcon(2131689494);
      if (localHomeUI.FGS) {
        localHomeUI.FLr.setIcon(2131689501);
      }
      if (localHomeUI.FHi == null)
      {
        localObject = new ViewGroup.LayoutParams(j, i);
        com.tencent.mm.kiss.a.b.agA();
        localHomeUI.FHi = com.tencent.mm.kiss.a.b.c(localHomeUI.FKl, 2131492929);
        localHomeUI.FLp = ((ImageView)localHomeUI.FHi.findViewById(2131300874));
        localHomeUI.FHi.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localHomeUI.FHi.setMinimumHeight(i);
        localHomeUI.FHi.setMinimumWidth(j);
        localHomeUI.FLp.setImageResource(2131689494);
        localHomeUI.FLp.setImageDrawable(am.e(localHomeUI.FKl.getResources().getDrawable(2131689494), localHomeUI.FKl.getResources().getColor(2131099732)));
        localHomeUI.FHi.setContentDescription(localHomeUI.getString(2131764452));
        localHomeUI.FHi.setOnLongClickListener(new HomeUI.7(localHomeUI));
        localHomeUI.FHi.setOnClickListener(new HomeUI.8(localHomeUI));
        localHomeUI.FHi.post(new HomeUI.9(localHomeUI));
      }
      localHomeUI.FLr.setActionView(localHomeUI.FHi);
      localHomeUI.FLs = paramMenu.add(0, HomeUI.FLk, 0, 2131764451);
      if (localHomeUI.FLm == null) {
        localHomeUI.FLl = new HomeUI.b(localHomeUI, j, i);
      }
      if (com.tencent.mm.kernel.g.afz().aeI()) {
        com.tencent.mm.plugin.newtips.a.cWs().h(localHomeUI.FLl);
      }
      if ((localHomeUI.FGS) && (localHomeUI.FLn != null)) {
        localHomeUI.FLn.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      com.tencent.mm.blink.b.SX().v(new HomeUI.10(localHomeUI));
      localHomeUI.FLs.setActionView(localHomeUI.FLm);
      localHomeUI.eQi();
      localHomeUI.FLm.getLayoutParams().width = j;
      localHomeUI.FLm.getLayoutParams().height = i;
      break;
      i = localHomeUI.FKl.getResources().getDimensionPixelSize(2131165252);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33314);
    com.tencent.mm.blink.a.SS();
    super.onDestroy();
    Object localObject = this.FMb;
    ((HomeUI)localObject).FLc.bFb();
    if (((HomeUI)localObject).FLb != null)
    {
      h localh = ((HomeUI)localObject).FLb;
      com.tencent.mm.sdk.b.a.ESL.d(localh.FKr);
      com.tencent.mm.sdk.b.a.ESL.d(localh.FKs);
    }
    if (((HomeUI)localObject).FKI) {
      Looper.myQueue().removeIdleHandler(((HomeUI)localObject).nbI);
    }
    localObject = this.chattingTabUI;
    if ((((NewChattingTabUI)localObject).mPrepareBitmap != null) && (!((NewChattingTabUI)localObject).mPrepareBitmap.isRecycled()))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", new Object[] { ((NewChattingTabUI)localObject).mPrepareBitmap.toString() });
      ((NewChattingTabUI)localObject).mPrepareBitmap.recycle();
    }
    com.tencent.mm.sdk.platformtools.aq.az(((NewChattingTabUI)localObject).mStartChattingRunnable);
    Looper.myQueue().removeIdleHandler(((NewChattingTabUI)localObject).FRh);
    eQH();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bt.iQ(this), Integer.valueOf(FLW.size()) });
    AppMethodBeat.o(33314);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(33331);
    super.onMultiWindowModeChanged(paramBoolean);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "alvinluo onMultiWindowModeChanged2 isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ll localll = new ll();
    localll.dqb.dqc = paramBoolean;
    com.tencent.mm.sdk.b.a.ESL.l(localll);
    AppMethodBeat.o(33331);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(33301);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", new Object[] { Integer.valueOf(hashCode()), bt.iQ(this) });
    this.doO = paramIntent;
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if ((this.doO != null) && (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.doO, "LauncherUI.jump_from_uimode_check", false)))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "dancy onNewIntent uimode check from background, finish LauncherUI");
      finish();
      AppMethodBeat.o(33301);
      return;
    }
    com.tencent.mm.pluginsdk.model.app.q.j(this, "");
    if (eQK())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
      AppMethodBeat.o(33301);
      return;
    }
    if ((this.doO != null) && (com.tencent.mm.sdk.platformtools.y.getBooleanExtra(this.doO, "Intro_Need_Clear_Top ", false)))
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
      finish();
      jk(this);
      AppMethodBeat.o(33301);
      return;
    }
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      closeChatting(false);
    }
    MainTabUI localMainTabUI = this.FMb.FLc;
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      localMainTabUI.FPG = true;
    }
    if (this.FMd)
    {
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
      bi(paramIntent);
    }
    AppMethodBeat.o(33301);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int j = 0;
    AppMethodBeat.i(33323);
    HomeUI localHomeUI = this.FMb;
    Object localObject = localHomeUI.FKl.getCurrentFragmet();
    int i;
    if ((localObject != null) && (((MMFragment)localObject).isShowing())) {
      i = j;
    }
    while (i != 0)
    {
      AppMethodBeat.o(33323);
      return true;
      i = j;
      if (!localHomeUI.FLa.eQN())
      {
        if (paramMenuItem.getItemId() == HomeUI.FLk)
        {
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(10919, "0");
          localHomeUI.eQh();
        }
        for (;;)
        {
          i = 1;
          break;
          if (paramMenuItem.getItemId() == HomeUI.FLj)
          {
            localHomeUI.eQj();
          }
          else
          {
            i = j;
            if (paramMenuItem.getItemId() != 5) {
              break;
            }
            if ((com.tencent.mm.sdk.a.b.eEQ()) || (com.tencent.mm.platformtools.ab.hWA))
            {
              localObject = new com.tencent.mm.ui.tools.l(localHomeUI.FKl);
              ((com.tencent.mm.ui.tools.l)localObject).HrX = new HomeUI.11(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).HrY = new HomeUI.13(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).fdQ();
            }
            else
            {
              localHomeUI.eQk();
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI", "onPause %s, chatting is show ", new Object[] { Integer.valueOf(hashCode()) });
    super.onPause();
    Object localObject1 = this.FMg;
    boolean bool = ((s)localObject1).em("onPause");
    if (bool) {
      ((s)localObject1).BNB = false;
    }
    if (bool)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
      AppMethodBeat.o(33311);
      return;
    }
    com.tencent.mm.blink.a.SS();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "not skip this onPause");
    localObject1 = getCurrentFragmet();
    this.FMj.removeCallbacksAndMessages(null);
    Object localObject2 = this.FMb;
    Object localObject3 = ((HomeUI)localObject2).FLc;
    bool = ((HomeUI)localObject2).FKI;
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", new Object[] { Integer.valueOf(((MainTabUI)localObject3).Zo), Boolean.valueOf(bool) });
    if (bool) {
      ((MainTabUI)localObject3).eRi();
    }
    localObject3 = ((MainTabUI)localObject3).FPE;
    if (az.afw())
    {
      az.arV();
      com.tencent.mm.model.c.afk().b(((z)localObject3).FPY);
      az.arV();
      com.tencent.mm.model.c.apR().b((n.b)localObject3);
      com.tencent.mm.z.c.adr().b(((z)localObject3).FPX);
      com.tencent.mm.sdk.b.a.ESL.d(((z)localObject3).FPZ);
      com.tencent.mm.sdk.b.a.ESL.d(((z)localObject3).FJD);
      com.tencent.mm.sdk.b.a.ESL.d(((z)localObject3).FJC);
    }
    if (((z)localObject3).FPW != null)
    {
      ((z)localObject3).FPW.FPT = null;
      ((z)localObject3).FPW = null;
    }
    localObject3 = ((HomeUI)localObject2).FLb;
    if (((h)localObject3).FKo != null)
    {
      az.aeS().b(255, ((h)localObject3).FKo);
      az.aeS().b(384, ((h)localObject3).FKo);
      ((h)localObject3).FKo = null;
    }
    com.tencent.mm.sdk.a.b.eh(false);
    ((HomeUI)localObject2).FKZ = HomeUI.a.FLK;
    if (!az.arO()) {
      az.getNotification().cw(false);
    }
    bool = ((HomeUI)localObject2).FLa.eQN();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show ".concat(String.valueOf(bool)));
    if (!bool) {
      j.a(((HomeUI)localObject2).FKl, 4, ((HomeUI)localObject2).FLc.Zo, "directReport_onPause");
    }
    if (!((HomeUI)localObject2).FKl.isFinishing()) {
      com.tencent.mm.ui.widget.h.a(((HomeUI)localObject2).FKl);
    }
    if (((HomeUI)localObject2).FKI)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
      com.tencent.mm.blink.b.SX().SZ();
      if (az.afw()) {
        com.tencent.mm.sdk.b.a.ESL.d(((HomeUI)localObject2).wcH);
      }
    }
    if ((((HomeUI)localObject2).FKQ != null) && (((HomeUI)localObject2).FKQ.isShowing())) {
      ((HomeUI)localObject2).FKQ.dismiss();
    }
    localObject2 = this.chattingTabUI;
    if (((NewChattingTabUI)localObject2).eQN())
    {
      ((NewChattingTabUI)localObject2).lI(4);
      if ((((NewChattingTabUI)localObject2).FRm != null) && (((NewChattingTabUI)localObject2).FRm.isSupportNavigationSwipeBack())) {
        ((NewChattingTabUI)localObject2).FRm.getSwipeBackLayout().setEnableGesture(false);
      }
    }
    if (localObject1 != null)
    {
      AppMethodBeat.o(33311);
      return;
    }
    this.FMe = false;
    AppMethodBeat.o(33311);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(33313);
    this.FMi = false;
    Object localObject;
    if (!this.FMc.a(this, paramInt, paramArrayOfString, paramArrayOfInt))
    {
      localObject = this.FMb;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      localObject = this.chattingTabUI;
      if (((NewChattingTabUI)localObject).FRm != null) {
        ((NewChattingTabUI)localObject).FRm.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(33313);
      return;
      if (paramInt == 80) {}
      for (int i = 2131761871; paramArrayOfInt[0] != 0; i = 2131761860)
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).FKl, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.25((HomeUI)localObject), new HomeUI.26((HomeUI)localObject));
        break;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ((HomeUI)localObject).eQj();
      }
      else
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).FKl, ((HomeUI)localObject).getString(2131761869), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.27((HomeUI)localObject), null);
        continue;
        if (paramArrayOfInt[0] == 0)
        {
          localObject = ((HomeUI)localObject).FLc.eRg();
          if ((localObject instanceof FindMoreFriendsUI)) {
            ((FindMoreFriendsUI)localObject).ePS();
          }
        }
        else
        {
          com.tencent.mm.ui.base.h.a(((HomeUI)localObject).FKl, ((HomeUI)localObject).getString(2131761869), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.28((HomeUI)localObject), null);
          continue;
          if (paramArrayOfInt[0] == 0)
          {
            ((HomeUI)localObject).eQk();
          }
          else
          {
            if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
            for (i = 2131761860;; i = 2131761871)
            {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).FKl, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131755691), false, new HomeUI.29((HomeUI)localObject), new HomeUI.30((HomeUI)localObject));
              break;
            }
            if (paramArrayOfInt[0] == 0) {
              ((HomeUI)localObject).eQk();
            } else {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).FKl, ((HomeUI)localObject).getString(2131761869), ((HomeUI)localObject).getString(2131761885), ((HomeUI)localObject).getString(2131760598), ((HomeUI)localObject).getString(2131756766), false, new HomeUI.31((HomeUI)localObject), null);
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
    localNewChattingTabUI.FRj = paramBundle.getString("last_restore_talker");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", new Object[] { localNewChattingTabUI.FRj });
    this.FMl = paramBundle.getBoolean("last_stay_chatting");
    this.FMm = paramBundle.getInt("last_stay_tab");
    if (this.FMl) {
      this.chattingTabUI.startChatting(this.chattingTabUI.FRj, null, false);
    }
    AppMethodBeat.o(33321);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33303);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    super.onResume();
    if (this.FMg.em("onResume"))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
      AppMethodBeat.o(33303);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "not skip this onResume");
    FLY = false;
    Object localObject1;
    boolean bool1;
    Object localObject2;
    long l1;
    Object localObject4;
    Object localObject5;
    label730:
    Object localObject6;
    long l2;
    if (eQJ())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", new Object[] { Boolean.valueOf(this.FMd) });
      if (!az.afw())
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI", "accHasNotReady, kill self");
        finish();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        Process.killProcess(Process.myPid());
        AppMethodBeat.o(33303);
        return;
      }
      if (!this.FMd)
      {
        this.FMd = true;
        localObject1 = this.FMb;
        if ((HomeUI.eQt()) && (HomeUI.eQu()))
        {
          bool1 = true;
          ((HomeUI)localObject1).FLg = bool1;
          localObject2 = ((HomeUI)localObject1).FLb;
          com.tencent.mm.sdk.b.a.ESL.c(((h)localObject2).FKr);
          com.tencent.mm.sdk.b.a.ESL.c(((h)localObject2).FKs);
          if (!com.tencent.mm.ui.conversation.b.fbV()) {
            getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
          }
          localObject2 = ((HomeUI)localObject1).FKl.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.XN());
          if (((SharedPreferences)localObject2).getBoolean("first_launch_weixin", true))
          {
            ((SharedPreferences)localObject2).edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
          }
          ((HomeUI)localObject1).FKQ = new ad(this);
          ((HomeUI)localObject1).FKI = true;
          NotifyReceiver.Ty();
          az.getNotification().ku(1);
          if (az.afw()) {
            break label2708;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
          ((HomeUI)localObject1).FKl.finish();
          bi(getIntent());
        }
      }
      else
      {
        localObject1 = this.FMb;
        l1 = bt.eGO();
        localObject2 = ((HomeUI)localObject1).FLc;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.MainTabUI", "onResume start :%d", new Object[] { Integer.valueOf(((MainTabUI)localObject2).Zo) });
        if (((MainTabUI)localObject2).FPQ.size() != 0)
        {
          localObject4 = ((MainTabUI)localObject2).Xt(((MainTabUI)localObject2).Zo);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.MainTabUI", "notifyCurrentTabResumeUI, mCurIndex:%s", new Object[] { Integer.valueOf(((MainTabUI)localObject2).Zo) });
          if (localObject4 != null) {
            ((m)localObject4).ePe();
          }
          if ((localObject4 != null) && (com.tencent.matrix.b.GE()) && (((MMFragment)localObject4).getActivity() != null))
          {
            localObject5 = ((MMFragment)localObject4).getActivity().getClass().getName();
            com.tencent.matrix.a.csS.cQ((String)localObject5 + "#" + localObject4.getClass().getSimpleName());
          }
        }
        if ((((MainTabUI)localObject2).FPG) && (((MainTabUI)localObject2).FKl.getIntent().hasExtra("isScrollFirst")) && (((MainTabUI)localObject2).FKl.getIntent().hasExtra("isShowHeader")))
        {
          localObject4 = (MainUI)((MainTabUI)localObject2).FPQ.get(Integer.valueOf(0));
          if (localObject4 != null)
          {
            bool1 = ((MainTabUI)localObject2).FKl.getIntent().getBooleanExtra("isShowHeader", false);
            boolean bool2 = ((MainTabUI)localObject2).FKl.getIntent().getBooleanExtra("isScrollFirst", true);
            ((MainUI)localObject4).i(bool1, ((MainTabUI)localObject2).FKl.getIntent().getBooleanExtra("isShowHeaderWithAnim", false), bool2);
          }
        }
        if (((MainTabUI)localObject2).FPG)
        {
          ((MainTabUI)localObject2).FPG = false;
          ((MainTabUI)localObject2).aKb("tab_main");
        }
        localObject4 = (MainUI)((MainTabUI)localObject2).FPQ.get(Integer.valueOf(0));
        if (localObject4 != null)
        {
          ((MainUI)localObject4).fba();
          ((MainUI)localObject4).fcC();
        }
        if (((MainTabUI)localObject2).Zo != 0) {
          break label3700;
        }
        az.getNotification().cw(true);
        localObject4 = (m)((MainTabUI)localObject2).Xt(((MainTabUI)localObject2).Zo);
        if (localObject4 != null) {
          ((m)localObject4).ePf();
        }
        ((MainTabUI)localObject2).FPG = false;
        int i = com.tencent.mm.sdk.platformtools.y.getIntExtra(((MainTabUI)localObject2).FKl.getIntent(), "preferred_tab", 0);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI.MainTabUI", "doOnResume, tabIdx = %d", new Object[] { Integer.valueOf(i) });
        if (i != 0)
        {
          ((MainTabUI)localObject2).Xs(i);
          ((MainTabUI)localObject2).FKl.getIntent().putExtra("preferred_tab", 0);
        }
        com.tencent.mm.sdk.b.a.ESL.c(((MainTabUI)localObject2).FPL);
        com.tencent.mm.sdk.b.a.ESL.c(((MainTabUI)localObject2).FPN);
        com.tencent.mm.sdk.b.a.ESL.c(((MainTabUI)localObject2).FPO);
        localObject2 = ((MainTabUI)localObject2).FPE;
        if (((z)localObject2).FPT != null) {
          ((z)localObject2).FPT.ePn();
        }
        if (az.afw())
        {
          az.arV();
          com.tencent.mm.model.c.afk().a(((z)localObject2).FPY);
          com.tencent.mm.z.c.adr().a(((z)localObject2).FPX);
          az.arV();
          com.tencent.mm.model.c.apR().a((n.b)localObject2);
          com.tencent.mm.sdk.b.a.ESL.c(((z)localObject2).FJD);
          com.tencent.mm.sdk.b.a.ESL.c(((z)localObject2).FPZ);
          com.tencent.mm.sdk.b.a.ESL.c(((z)localObject2).FJC);
        }
        com.tencent.mm.blink.b.SX().v(new z.6((z)localObject2));
        localObject2 = ((HomeUI)localObject1).FLb;
        localObject6 = new be();
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject6);
        if ((((be)localObject6).ddv.ddw) && (!bt.isNullOrNil(((be)localObject6).ddv.bLg)))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.GlobalAlertMgr", "  now show msg:%s", new Object[] { ((be)localObject6).ddv.bLg });
          localObject4 = new f.a(((h)localObject2).FKl);
          localObject5 = ((f.a)localObject4).au(((h)localObject2).getString(2131755918)).av(((h)localObject2).getString(2131755917));
          localObject6 = ((be)localObject6).ddv.bLg;
          ((f.a)localObject5).BYA.aMh((String)localObject6);
          localObject4 = ((f.a)localObject4).wZ(false).b(new h.2((h)localObject2));
          ((f.a)localObject4).HFB = true;
          ((f.a)localObject4).show();
        }
        if (!((h)localObject2).a(((h)localObject2).FKn)) {
          az.afE().m(new h.7((h)localObject2), 500L);
        }
        ((h)localObject2).FKn = null;
        com.tencent.mm.sdk.a.b.eh(true);
        bool1 = ((HomeUI)localObject1).FLa.eQN();
        if ((!bool1) && (az.afw()))
        {
          com.tencent.mm.blink.b.SX().v(new HomeUI.36((HomeUI)localObject1));
          if ((com.tencent.mm.bj.d.hxy != null) && (com.tencent.mm.bj.d.hxx != null) && (!bt.isNullOrNil(com.tencent.mm.bj.d.hxx.aCl())))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "launcher onResume end track %s", new Object[] { com.tencent.mm.bj.d.hxy.aCm() });
            localObject2 = new fg();
            ((fg)localObject2).dhF.username = com.tencent.mm.bj.d.hxy.aCm();
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        if (!bool1)
        {
          j.a(((HomeUI)localObject1).FKl, 3, ((HomeUI)localObject1).FLc.Zo, "directReport_onResume");
          ((HomeUI)localObject1).FLc.Xp(260);
        }
        com.tencent.mm.ui.widget.h.b(((HomeUI)localObject1).FKl);
        ((HomeUI)localObject1).FKl.onSwipe(1.0F);
        ((HomeUI)localObject1).FKZ = HomeUI.a.FLJ;
        if (((HomeUI)localObject1).FKK)
        {
          ((HomeUI)localObject1).FKK = false;
          ((HomeUI)localObject1).FKK = false;
        }
        com.tencent.mm.ak.o.auB();
        l2 = System.currentTimeMillis();
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI.HomeUI", "[Launching Application]");
        com.tencent.mm.kernel.l.o(((HomeUI)localObject1).FKl, false);
        com.tencent.mm.kernel.l.p(((HomeUI)localObject1).FKl, false);
        long l3 = System.currentTimeMillis();
        if (!((HomeUI)localObject1).FKl.getSharedPreferences(aj.eFD(), 0).getBoolean("settings_landscape_mode", false)) {
          break label3712;
        }
        ((HomeUI)localObject1).FKl.setRequestedOrientation(-1);
        label1465:
        long l4 = System.currentTimeMillis();
        if (getInstance() != null)
        {
          com.tencent.mm.blink.b.SX().Ta();
          ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a("showprivacypolicy", ((HomeUI)localObject1).FLA);
          ((HomeUI)localObject1).vr(false);
          com.tencent.mm.sdk.b.a.ESL.c(((HomeUI)localObject1).wcH);
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - l4));
          if (az.afw()) {
            ((HomeUI)localObject1).eQs();
          }
        }
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.LauncherUI.HomeUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - l3));
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - l2));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "initView " + (System.currentTimeMillis() - l1));
        if (((HomeUI)localObject1).FKK)
        {
          ((HomeUI)localObject1).FKK = false;
          ((HomeUI)localObject1).FKK = false;
        }
        localObject2 = com.tencent.mm.app.v.KT();
        ((com.tencent.mm.app.v)localObject2).cMh = true;
        ((com.tencent.mm.app.v)localObject2).cMi.removeMessages(-1999);
        ((com.tencent.mm.app.v)localObject2).cMi.removeMessages(-2999);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - l1));
        if (com.tencent.mm.model.u.aro().booleanValue()) {
          ((HomeUI)localObject1).eQg();
        }
        i = com.tencent.mm.kernel.g.afB().afk().getInt(ae.a.Fvr, 0);
        if (i != 0)
        {
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fvr, Integer.valueOf(0));
          if (com.tencent.mm.model.u.arj()) {}
        }
        switch (i)
        {
        default: 
          label1804:
          com.tencent.mm.blink.b.SX().v(new HomeUI.2((HomeUI)localObject1));
          if (((HomeUI)localObject1).getMainTabUI().Zo != 3)
          {
            localObject1 = (MoreTabUI)((HomeUI)localObject1).getMainTabUI().Xt(3);
            if ((((MoreTabUI)localObject1).FQg != null) && (!((MoreTabUI)localObject1).FQg.isVisible))
            {
              ((MoreTabUI)localObject1).FQg.ffR();
              ((MoreTabUI)localObject1).dcm();
            }
          }
          localObject1 = this.chattingTabUI;
          ((NewChattingTabUI)localObject1).FRe = bt.aGK();
          if (((NewChattingTabUI)localObject1).eRE())
          {
            ((NewChattingTabUI)localObject1).FRh = new NewChattingTabUI.1((NewChattingTabUI)localObject1);
            com.tencent.mm.sdk.platformtools.aq.n(new NewChattingTabUI.2((NewChattingTabUI)localObject1), 500L);
          }
          if (((NewChattingTabUI)localObject1).eQN())
          {
            ((NewChattingTabUI)localObject1).lI(3);
            if ((((NewChattingTabUI)localObject1).FRm != null) && (((NewChattingTabUI)localObject1).FRm.isSupportNavigationSwipeBack())) {
              ((NewChattingTabUI)localObject1).FRm.getSwipeBackLayout().setEnableGesture(true);
            }
            label1973:
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "resumeNormalJump");
            MMFragmentActivity.a.eRe();
            if (("pushcontent_notification".equals(com.tencent.mm.sdk.platformtools.y.getStringExtra(getIntent(), "nofification_type"))) && (!bt.isNullOrNil(com.tencent.mm.sdk.platformtools.y.getStringExtra(getIntent(), "Main_FromUserName"))))
            {
              localObject1 = com.tencent.mm.sdk.platformtools.y.getStringExtra(getIntent(), "Main_FromUserName");
              i = com.tencent.mm.sdk.platformtools.y.getIntExtra(getIntent(), "MainUI_User_Last_Msg_Type", 0);
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + (String)localObject1 + i);
              com.tencent.mm.plugin.report.service.h.vKh.f(10856, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(0) });
            }
            localObject1 = com.tencent.mm.sdk.platformtools.y.getStringExtra(getIntent(), "LauncherUI.Shortcut.LaunchType");
            if (localObject1 != null)
            {
              if (!((String)localObject1).equals("launch_type_voip")) {
                break label3799;
              }
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
              localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.vKh.f(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
            }
            label2257:
            localObject1 = com.tencent.mm.sdk.platformtools.y.getStringExtra(getIntent(), "LauncherUI.switch.tab");
            if (!bt.isNullOrNil((String)localObject1))
            {
              this.FMb.getMainTabUI().aKb((String)localObject1);
              getIntent().putExtra("LauncherUI.switch.tab", "");
            }
            if ((com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) || (this.FMf))
            {
              this.FMf = false;
              localObject1 = getInstance();
              if (localObject1 != null) {
                ((LauncherUI)localObject1).FMb.eQm();
              }
              getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
              getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
            }
            bool1 = com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
            if (!bool1) {
              break label3941;
            }
            localObject1 = com.tencent.mm.sdk.platformtools.y.getStringExtra(getIntent(), "LauncherUI.Shortcut.Username");
            label2401:
            if (bool1)
            {
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = ".concat(String.valueOf(localObject1)));
              if (!bt.isNullOrNil((String)localObject1))
              {
                localObject4 = com.tencent.mm.plugin.base.model.b.OL((String)localObject1);
                if (!bt.isNullOrNil((String)localObject4))
                {
                  if (w.sD((String)localObject4))
                  {
                    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                    if (!com.tencent.mm.am.f.wJ((String)localObject4)) {
                      break label4247;
                    }
                    if (!com.tencent.mm.am.f.pc((String)localObject4)) {
                      break label3965;
                    }
                    localObject1 = new Intent();
                    ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                    ((Intent)localObject1).putExtra("Contact_User", (String)localObject4);
                    ((Intent)localObject1).putExtra("biz_chat_from_scene", 9);
                    ((Intent)localObject1).addFlags(67108864);
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                  getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
                  getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
                }
              }
            }
            label2593:
            this.FMe = true;
            label2622:
            com.tencent.mm.blink.a.kp(5);
            if (!FMa) {
              vv(false);
            }
            eQI();
            localObject1 = (com.tencent.mm.plugin.ball.c.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.ball.c.c.class);
            if (localObject1 == null) {
              break label4282;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, try to fix");
            ((com.tencent.mm.plugin.ball.c.c)localObject1).byT();
          }
          break;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).cFs();
        com.tencent.mm.plugin.base.stub.f.bAZ();
        com.tencent.mm.blink.a.oj("LauncherUI");
        AppMethodBeat.o(33303);
        return;
        bool1 = false;
        break;
        label2708:
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
        l1 = System.currentTimeMillis();
        l2 = System.currentTimeMillis();
        MMActivity.initLanguage(((HomeUI)localObject1).FKl);
        try
        {
          localObject2 = new HashSet();
          localObject4 = ((HomeUI)localObject1).getString(2131757953).split(";");
          ((Set)localObject2).add(localObject4[0]);
          ((Set)localObject2).add(localObject4[1]);
          com.tencent.mm.model.v.b((Set)localObject2);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afE().ax(new HomeUI.15((HomeUI)localObject1));
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).imq = ((LayoutInflater)((HomeUI)localObject1).FKl.getSystemService("layout_inflater"));
          l2 = System.currentTimeMillis();
          com.tencent.mm.kiss.a.b.agA();
          ((HomeUI)localObject1).contentView = com.tencent.mm.kiss.a.b.c(((HomeUI)localObject1).FKl, 2131494684);
          if ((((HomeUI)localObject1).contentView != null) && (Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.XM())) {
            ((HomeUI)localObject1).contentView.setBackgroundColor(((HomeUI)localObject1).FKl.getResources().getColor(2131100705));
          }
          com.tencent.mm.blink.b.SX().SY();
          ((FirstScreenFrameLayout)((HomeUI)localObject1).contentView.findViewById(2131300113)).fie = new HomeUI.23((HomeUI)localObject1);
          com.tencent.mm.pluginsdk.model.app.ap.evQ();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).FKl.setContentView(((HomeUI)localObject1).contentView);
          Looper.myQueue().addIdleHandler(((HomeUI)localObject1).nbI);
          ((HomeUI)localObject1).FKJ = true;
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI.HomeUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).initActionBar();
          ((HomeUI)localObject1).mActionBar.show();
          ((HomeUI)localObject1).contentView.post(new HomeUI.32((HomeUI)localObject1));
          com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - l1));
          com.tencent.mm.sdk.platformtools.aq.n(new HomeUI.33((HomeUI)localObject1), 2000L);
          ((HomeUI)localObject1).contentView.addOnLayoutChangeListener(((HomeUI)localObject1).FLi);
          com.tencent.mm.pluginsdk.g.b(((HomeUI)localObject1).FKl, ((HomeUI)localObject1).contentView);
          ((HomeUI)localObject1).contentView.postDelayed(new HomeUI.34((HomeUI)localObject1), 20L);
          localObject5 = ((HomeUI)localObject1).FLc;
          ((MainTabUI)localObject5).mViewPager = ((CustomViewPager)((MainTabUI)localObject5).FKl.findViewById(2131303135));
          ((MainTabUI)localObject5).mViewPager.setOffscreenPageLimit(4);
          ((MainTabUI)localObject5).mViewPager.setCanSlide(true);
          ((MainTabUI)localObject5).mViewPager.setCanSlideBySide(false);
          ((MainTabUI)localObject5).mTabsAdapter = new MainTabUI.TabsAdapter((MainTabUI)localObject5, ((MainTabUI)localObject5).FKl, ((MainTabUI)localObject5).mViewPager);
          if (getInstance() != null)
          {
            ((MainTabUI)localObject5).Xs(getInstance().FMm);
            localObject2 = ((MainTabUI)localObject5).FPE;
            localObject4 = (ViewGroup)((MainTabUI)localObject5).mViewPager.getParent();
            localObject5 = ((MainTabUI)localObject5).mTabsAdapter;
            localObject6 = ((z)localObject2).FPT;
            if (((z)localObject2).FPT != null)
            {
              ((z)localObject2).FPT.setOnTabClickListener(null);
              ((View)((z)localObject2).FPT).setVisibility(8);
              if (localObject4 != null) {
                ((ViewGroup)localObject4).removeView((View)((z)localObject2).FPT);
              }
            }
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
            LauncherUIBottomTabView localLauncherUIBottomTabView = new LauncherUIBottomTabView(((z)localObject2).FKl);
            localLauncherUIBottomTabView.setId(2131301338);
            if (localObject4 != null)
            {
              localLayoutParams.gravity = 80;
              ((ViewGroup)localObject4).addView(localLauncherUIBottomTabView, localLayoutParams);
            }
            ((z)localObject2).FPT = localLauncherUIBottomTabView;
            ((View)((z)localObject2).FPT).setVisibility(0);
            ((z)localObject2).FPT.setOnTabClickListener((c.a)localObject5);
            if ((localObject6 != null) && (localObject6 != ((z)localObject2).FPT))
            {
              ((z)localObject2).FPT.vj(((c)localObject6).getShowFriendPoint());
              ((z)localObject2).FPT.vk(((c)localObject6).getSettingsPoint());
              ((z)localObject2).FPT.WZ(((c)localObject6).getMainTabUnread());
              ((z)localObject2).FPT.Xa(((c)localObject6).getContactTabUnread());
              ((z)localObject2).FPT.Xb(((c)localObject6).getFriendTabUnread());
              ((z)localObject2).FPT.Xc(((c)localObject6).getSettingsTabUnread());
              ((z)localObject2).FPT.setTo(((c)localObject6).getCurIdx());
            }
            ((HomeUI)localObject1).FLc.FPK = new HomeUI.1((HomeUI)localObject1);
            com.tencent.e.h.Iye.aP(new HomeUI.12((HomeUI)localObject1));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
            continue;
            ((MainTabUI)localObject5).Xs(0);
          }
        }
      }
      label3700:
      az.getNotification().cw(false);
      break label730;
      label3712:
      ((HomeUI)localObject1).FKl.setRequestedOrientation(1);
      break label1465;
      com.tencent.mm.ui.base.h.a(((HomeUI)localObject1).FKl, ((HomeUI)localObject1).getString(2131760750), "", new HomeUI.37((HomeUI)localObject1), null);
      break label1804;
      if (!((NewChattingTabUI)localObject1).FRp) {
        break label1973;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI.NewChattingTabUI", "[onResume] need exec this runnable!");
      com.tencent.mm.sdk.platformtools.aq.az(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      com.tencent.mm.sdk.platformtools.aq.f(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      ((NewChattingTabUI)localObject1).FRp = false;
      break label1973;
      label3799:
      if (!((String)localObject1).equals("launch_type_voip_audio")) {
        break label2257;
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
      localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.vKh.f(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      break label2257;
      label3941:
      bool1 = com.tencent.mm.sdk.platformtools.y.getBooleanExtra(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
      localObject1 = getIntent().getAction();
      break label2401;
      label3965:
      if (com.tencent.mm.am.f.wL((String)localObject4))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject1).putExtra("enterprise_biz_name", (String)localObject4);
        ((Intent)localObject1).putExtra("enterprise_biz_display_name", com.tencent.mm.model.v.sh((String)localObject4));
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break label2593;
      }
      if (com.tencent.mm.am.f.wM((String)localObject4))
      {
        localObject1 = com.tencent.mm.am.f.ei((String)localObject4);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).Ji())
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
      break label2593;
      label4247:
      localObject1 = getInstance();
      if (localObject1 == null) {
        break label2593;
      }
      ((LauncherUI)localObject1).startChatting((String)localObject4, null, false);
      break label2593;
      if (FMa) {
        break label2622;
      }
      eQM();
      break label2622;
      label4282:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, service is null");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(33322);
    Object localObject = this.chattingTabUI;
    if (((NewChattingTabUI)localObject).FRm != null)
    {
      localObject = ((NewChattingTabUI)localObject).FRm.cOd.getTalkerUserName();
      if (!bt.isNullOrNil((String)localObject))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "onSaveInstanceState:%s", new Object[] { localObject });
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
    if ((this.FMd) && (!this.chattingTabUI.S(paramBoolean, paramInt))) {
      super.onSettle(paramBoolean, paramInt);
    }
    AppMethodBeat.o(33318);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(33312);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.blink.a.SS();
    HomeUI localHomeUI = this.FMb;
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b("showprivacypolicy", localHomeUI.FLA);
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
    if (this.FMd)
    {
      localNewChattingTabUI = this.chattingTabUI;
      if ((localNewChattingTabUI.FRd == null) || (!localNewChattingTabUI.FRd.eQn())) {
        break label108;
      }
      bool = true;
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", new Object[] { Float.valueOf(paramFloat), Long.valueOf(260L), Boolean.valueOf(bool) });
      if (localNewChattingTabUI.eRE()) {
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
        localNewChattingTabUI.Xy(0);
        localObject = (ImageView)localNewChattingTabUI.lTx.getWindow().getDecorView().findViewById(2131303386);
        if (localObject != null)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE no cache!");
          ((ImageView)localObject).setVisibility(8);
          ((ImageView)localObject).setImageDrawable(null);
        }
        if (localNewChattingTabUI.mChattingInAnim != null) {
          localNewChattingTabUI.mChattingInAnim.cancel();
        }
      }
      for (;;)
      {
        if (!localNewChattingTabUI.FRd.eQn())
        {
          if (Float.compare(1.0F, paramFloat) > 0)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Boolean.FALSE });
            i = 0;
            break;
            if ((paramFloat != 1.0F) || (localNewChattingTabUI.mChattingClosed) || (localNewChattingTabUI.FRm.eUT())) {
              continue;
            }
            localNewChattingTabUI.lTx.getWindow().setBackgroundDrawableResource(2131100810);
            localObject = (ImageView)localNewChattingTabUI.lTx.getWindow().getDecorView().findViewById(2131303386);
            if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0) && (((ImageView)localObject).getTag() != null))
            {
              ((View)((ImageView)localObject).getTag()).setVisibility(0);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
              ((ImageView)localObject).setVisibility(8);
            }
            if ((localNewChattingTabUI.FRm.getContentView() != null) && (localNewChattingTabUI.FRm.getContentView().getX() <= 0.0F))
            {
              localNewChattingTabUI.Xy(8);
              continue;
            }
            localNewChattingTabUI.Xy(0);
            continue;
          }
          j = 0;
        }
      }
      i = j;
      if (localNewChattingTabUI.lTx != null)
      {
        localObject = localNewChattingTabUI.lTx.findViewById(2131301337);
        ImageView localImageView = (ImageView)localNewChattingTabUI.lTx.findViewById(2131303386);
        if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null) && (!localNewChattingTabUI.mChattingClosed) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
        {
          localImageView.setVisibility(0);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
          localNewChattingTabUI.Xy(8);
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
    if (((NewChattingTabUI)localObject3).FRm != null)
    {
      localObject1 = localObject2;
      if (((NewChattingTabUI)localObject3).FRm.eUV() != null)
      {
        if (((NewChattingTabUI)localObject3).FRm.isSupportCustomActionBar()) {
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
      if (!com.tencent.mm.compatible.util.d.lh(22))
      {
        localObject3 = ((NewChattingTabUI)localObject3).FRm.eUV().startActionMode(paramCallback);
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
    this.FMb.eQl();
    this.chattingTabUI.startChatting(paramString, paramBundle, paramBoolean);
    AppMethodBeat.o(33329);
  }
  
  static abstract interface a
  {
    public abstract boolean eQN();
  }
  
  static abstract interface b
  {
    public abstract void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup);
    
    public abstract boolean eQn();
    
    public abstract void eQp();
    
    public abstract void eQq();
  }
  
  static abstract interface c
  {
    public abstract void eQo();
  }
  
  static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI
 * JD-Core Version:    0.7.0.1
 */