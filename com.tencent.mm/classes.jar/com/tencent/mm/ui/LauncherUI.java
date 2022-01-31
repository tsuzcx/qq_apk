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
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.blink.FirstScreenFrameLayout;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.h.a.ab;
import com.tencent.mm.h.a.ay;
import com.tencent.mm.h.a.ay.b;
import com.tencent.mm.h.a.ex;
import com.tencent.mm.h.a.ix;
import com.tencent.mm.h.a.w;
import com.tencent.mm.h.c.as;
import com.tencent.mm.kernel.b.3;
import com.tencent.mm.kernel.l;
import com.tencent.mm.model.al;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.ui.WelcomeSelectView;
import com.tencent.mm.plugin.account.ui.WelcomeView;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI;
import com.tencent.mm.pluginsdk.f.e.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.conversation.ConversationWithAppBrandListView;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.xlog.app.XLogSetup;
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
  private static ArrayList<LauncherUI> uKM = new ArrayList();
  private static boolean uKN = true;
  public static long uKO;
  private static boolean uKX = false;
  private Intent bRh = null;
  public HomeUI uKP = new HomeUI();
  private ad uKQ = new ad(this.uKP);
  private p uKR = new p();
  public boolean uKS = false;
  boolean uKT = false;
  private boolean uKU = false;
  private WelcomeView uKV;
  private com.tencent.mm.pluginsdk.r uKW = new com.tencent.mm.pluginsdk.r("MicroMsg.LauncherUI");
  private boolean uKY = false;
  private boolean uKZ = false;
  private com.tencent.mm.sdk.platformtools.ah uLa = new com.tencent.mm.sdk.platformtools.ah();
  private Runnable uLb = new LauncherUI.4(this);
  
  private void ao(Intent paramIntent)
  {
    y.i("MicroMsg.LauncherUI", "handleJump");
    if (!au.DK())
    {
      y.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
      startActivity(new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864));
      finish();
    }
    do
    {
      return;
      localObject1 = new ix();
      ((ix)localObject1).bRg.bRh = this.bRh;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      if (!"talkroom_notification".equals(com.tencent.mm.sdk.platformtools.t.j(paramIntent, "nofification_type"))) {
        break;
      }
      paramIntent = com.tencent.mm.sdk.platformtools.t.j(paramIntent, "enter_chat_usrname");
    } while (bk.bl(paramIntent));
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("enter_room_username", paramIntent);
    ((Intent)localObject1).setFlags(268435456);
    com.tencent.mm.br.d.b(this, "talkroom", ".ui.TalkRoomUI", (Intent)localObject1);
    return;
    if ("back_to_pcmgr_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      if (!paramIntent.getBooleanExtra("newPCBackup", true)) {
        y.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BakToPcUI");
      }
      for (paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakToPcUI");; paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI"))
      {
        paramIntent.setFlags(268435456);
        MMWizardActivity.C(this, paramIntent);
        return;
        y.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
      }
    }
    if ("back_to_pcmgr_error_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.C(this, paramIntent);
      return;
    }
    if ("backup_move_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.C(this, paramIntent);
      return;
    }
    int i;
    String str;
    Object localObject2;
    if (com.tencent.mm.sdk.platformtools.t.a(paramIntent, "show_update_dialog", false))
    {
      i = com.tencent.mm.sdk.platformtools.t.a(paramIntent, "update_type", -1);
      if (i == -1) {
        y.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
      }
    }
    else
    {
      str = com.tencent.mm.sdk.platformtools.t.j(paramIntent, "Main_User");
      localObject1 = com.tencent.mm.sdk.platformtools.t.j(paramIntent, "nofification_type");
      y.i("MicroMsg.LauncherUI", "[handleJump] user:%s", new Object[] { str });
      if ((str == null) || (str.equals(""))) {
        break label1502;
      }
      au.Hx();
      localObject2 = com.tencent.mm.model.c.FB().abv(str);
      if (localObject2 == null) {
        break label1497;
      }
      i = ((as)localObject2).field_unReadCount;
      label424:
      y.i("MicroMsg.LauncherUI", "[oneliang] user:%s, conversation :%s, unReadCount:%s", new Object[] { str, localObject2, Integer.valueOf(i) });
    }
    for (;;)
    {
      int j = i;
      if (i == 0) {
        j = com.tencent.mm.sdk.platformtools.t.a(paramIntent, "pushcontent_unread_count", 0);
      }
      MMAppMgr.tn();
      com.tencent.mm.sdk.b.a.udP.m(new ab());
      boolean bool = com.tencent.mm.sdk.platformtools.t.a(paramIntent, "Intro_Is_Muti_Talker", true);
      y.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((!bool) && (j > 0))
      {
        i = com.tencent.mm.sdk.platformtools.t.a(paramIntent, "Intro_Bottle_unread_count", 0);
        if (i > 0)
        {
          y.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.br.d.x(this, "bottle", ".ui.BottleConversationUI");
        }
      }
      if (!bool)
      {
        if (com.tencent.mm.model.s.hB(str))
        {
          y.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("type", 20);
          com.tencent.mm.br.d.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
        }
        for (;;)
        {
          label634:
          if (com.tencent.mm.sdk.platformtools.t.a(paramIntent, "kstyle_show_bind_mobile_afterauth", 0) > 0)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMobileUI");
            ((Intent)localObject1).putExtra("kstyle_bind_recommend_show", paramIntent.getIntExtra("kstyle_bind_recommend_show", 0));
            ((Intent)localObject1).putExtra("kstyle_bind_wording", paramIntent.getParcelableExtra("kstyle_bind_wording"));
            MMWizardActivity.C(this, (Intent)localObject1);
            return;
            com.tencent.mm.plugin.report.service.h.nFQ.a(405L, 28L, 1L, true);
            if (com.tencent.mm.plugin.w.d.bkt() == null) {
              break;
            }
            localObject1 = com.tencent.mm.plugin.w.d.bkt().a(this, null);
            if (localObject1 == null) {
              break;
            }
            localObject2 = com.tencent.mm.plugin.report.service.h.nFQ;
            if (i == 2) {}
            for (long l = 29L;; l = 30L)
            {
              ((com.tencent.mm.plugin.report.service.h)localObject2).a(405L, l, 1L, true);
              ((com.tencent.mm.plugin.w.a)localObject1).update(i);
              break;
            }
            if (com.tencent.mm.model.s.hJ(str))
            {
              y.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
              localObject1 = new Intent();
              ((Intent)localObject1).addFlags(67108864);
              ((Intent)localObject1).putExtra("type", 11);
              com.tencent.mm.br.d.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
            }
            else
            {
              if (paramIntent.getIntExtra("MainUI_User_Last_Msg_Type", 34) != 34) {
                break label1492;
              }
            }
          }
        }
      }
      label1481:
      label1492:
      for (i = 2;; i = 1)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("Chat_Mode", i);
        if ("new_msg_nofification".equals(com.tencent.mm.sdk.platformtools.t.j(paramIntent, "nofification_type"))) {
          ((Bundle)localObject1).putInt("chat_from_scene", 1);
        }
        localObject2 = cyX();
        if (localObject2 == null) {
          break label634;
        }
        if (com.tencent.mm.ai.f.eW(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("biz_chat_from_scene", 4);
          com.tencent.mm.br.d.e(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break label634;
        }
        if (com.tencent.mm.ai.f.ld(str))
        {
          localObject1 = com.tencent.mm.ai.f.kX(str);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.ai.d)localObject1).LC())
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
        if (com.tencent.mm.storage.ad.gr(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("app_brand_conversation_from_scene", 3);
          paramIntent.putExtra("finish_direct", true);
          paramIntent.putExtra("key_need_send_video", false);
          com.tencent.mm.br.d.e(this, ".ui.conversation.AppBrandServiceConversationUI", paramIntent);
          break label634;
        }
        ((LauncherUI)localObject2).startChatting(str, (Bundle)localObject1, false);
        break label634;
        if (com.tencent.mm.sdk.platformtools.t.a(paramIntent, "From_fail_notify", false))
        {
          if (!bk.bl(str))
          {
            localObject1 = cyX();
            if (localObject1 == null) {
              break label634;
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putBoolean("Chat_Mode", com.tencent.mm.sdk.platformtools.t.a(paramIntent, "resend_fail_messages", false));
            if (com.tencent.mm.ai.f.eW(str))
            {
              paramIntent.putExtra("Contact_User", str);
              paramIntent.addFlags(67108864);
              paramIntent.putExtra("biz_chat_from_scene", 4);
              com.tencent.mm.br.d.e(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
              break label634;
            }
            ((LauncherUI)localObject1).startChatting(str, (Bundle)localObject2, false);
            break label634;
          }
          if (!com.tencent.mm.sdk.platformtools.t.a(paramIntent, "jump_sns_from_notify", false)) {
            break label634;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("is_need_resend_sns", paramIntent.getBooleanExtra("is_need_resend_sns", false));
          ((Intent)localObject1).putExtra("sns_resume_state", paramIntent.getBooleanExtra("sns_resume_state", false));
          ((Intent)localObject1).putExtra("sns_timeline_NeedFirstLoadint", paramIntent.getBooleanExtra("sns_timeline_NeedFirstLoadint", false));
          com.tencent.mm.br.d.b(this, "sns", ".ui.SnsTimeLineUI", (Intent)localObject1);
          break label634;
        }
        if (com.tencent.mm.sdk.platformtools.t.a(paramIntent, "biz_chat_need_to_jump_to_chatting_ui", false))
        {
          if ((cyX() == null) || (!com.tencent.mm.ai.f.eW(str))) {
            break label634;
          }
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          com.tencent.mm.br.d.e(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break label634;
        }
        if ((bk.bl(str)) || (!"new_msg_nofification".equals(localObject1))) {
          break label634;
        }
        if (paramIntent == null) {}
        for (localObject1 = "null";; localObject1 = paramIntent)
        {
          y.w("MicroMsg.LauncherUI", "[handleJump] intent:%s", new Object[] { localObject1 });
          localObject1 = cyX();
          if (localObject1 == null) {
            break label1481;
          }
          ((LauncherUI)localObject1).startChatting(str, new Bundle(), false);
          break;
        }
        y.w("MicroMsg.LauncherUI", "LauncherUI.getInstance is null! ");
        break label634;
        break;
      }
      label1497:
      i = 0;
      break label424;
      label1502:
      i = 0;
    }
  }
  
  public static LauncherUI cyX()
  {
    if (uKM.isEmpty())
    {
      y.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", new Object[] { bk.csb() });
      return null;
    }
    return (LauncherUI)uKM.get(0);
  }
  
  public static int cyY()
  {
    if ((cyX() != null) && (cyX().uKP != null) && (cyX().uKP.uKi != null)) {
      return cyX().uKP.uKi.jVi;
    }
    return -1;
  }
  
  private void cyZ()
  {
    int i = uKM.indexOf(this);
    if (i >= 0) {
      uKM.remove(i);
    }
    y.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(uKM.size()), Integer.valueOf(hashCode()) });
  }
  
  private void cza()
  {
    if (uKX) {
      y.i("MicroMsg.LauncherUI", "whatnew has been started.");
    }
    do
    {
      return;
      uKX = true;
      if (!com.tencent.mm.kernel.g.DN().Dc())
      {
        com.tencent.mm.kernel.g.DN();
        if (!com.tencent.mm.kernel.a.Db())
        {
          this.uKY = true;
          uKX = false;
          return;
        }
        y.i("MicroMsg.LauncherUI", "account not initiate, skip whatsnew");
        return;
      }
      if (!czb())
      {
        y.i("MicroMsg.LauncherUI", "notSwitchOrHold is false, skip whatsnew");
        return;
      }
    } while ((com.tencent.mm.sdk.platformtools.t.a(getIntent(), "LauncherUI.enter_from_reg", false)) || (com.tencent.mm.pluginsdk.f.e.rVK == null));
    com.tencent.mm.pluginsdk.f.e.rVK.tw();
  }
  
  private boolean czb()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.bRh != null)
    {
      bool1 = bool2;
      if (!com.tencent.mm.sdk.platformtools.t.a(this.bRh, "Intro_Switch", false))
      {
        bool1 = bool2;
        if (au.Hz())
        {
          bool1 = bool2;
          if (!au.CW()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean czc()
  {
    if ((this.bRh != null) && ((com.tencent.mm.sdk.platformtools.t.a(this.bRh, "absolutely_exit", false)) || (com.tencent.mm.sdk.platformtools.t.a(this.bRh, "absolutely_exit_pid", 0) == Process.myPid())))
    {
      y.w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
      finish();
      com.tencent.mm.plugin.report.service.g.wK(8);
      MMAppMgr.mU(com.tencent.mm.sdk.platformtools.t.a(this.bRh, "kill_service", true));
      System.exit(0);
      return true;
    }
    if ((this.bRh != null) && (com.tencent.mm.sdk.platformtools.t.a(this.bRh, "can_finish", false)))
    {
      y.i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
      au.Dk().bM(true);
      if (l.bm(getApplicationContext()))
      {
        Context localContext = getApplicationContext();
        localContext.stopService(new Intent(localContext, CoreService.class));
      }
      com.tencent.mm.plugin.report.service.g.wK(8);
      sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), "com.tencent.mm.permission.MM_MESSAGE");
      finish();
      com.tencent.mm.ui.base.b.gK(this);
      return true;
    }
    return false;
  }
  
  private void go(Context paramContext)
  {
    if (com.tencent.mm.sdk.platformtools.t.a(this.bRh, "LauncherUI.jump_switch_account", false))
    {
      y.i("MicroMsg.LauncherUI", "launcher to switch account");
      paramContext = ae.getContext().getSharedPreferences("switch_account_preferences", 0);
      y.i("MicroMsg.LauncherUI", "switch to wxid %s", new Object[] { paramContext.getString("last_switch_account_to_wx_username", "") });
      paramContext.edit().putBoolean("transit_to_switch_account", false).commit();
      paramContext = new Intent();
      paramContext.setClass(this, SettingsSwitchAccountUI.class);
      paramContext.addFlags(536870912);
      paramContext.putExtra("key_scene", 1);
      startActivity(paramContext);
      com.tencent.mm.ui.base.b.gL(this);
      this.bRh.removeExtra("LauncherUI.jump_switch_account");
    }
    do
    {
      return;
      if ((com.tencent.mm.sdk.platformtools.t.a(this.bRh, "Intro_Switch", false)) || (this.uKS))
      {
        com.tencent.mrs.a.onDestroy();
        BaseEvent.onSingalCrash(0);
        y.i("MicroMsg.LauncherUI", "switch users count %d", new Object[] { Integer.valueOf(bv.dXJ.Ii().size()) });
        y.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
        y.cqL();
        finish();
        if (!ae.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("transit_to_switch_account", false))
        {
          Intent localIntent = new Intent(paramContext, LauncherUI.class);
          localIntent.addFlags(67108864);
          paramContext.startActivity(localIntent);
        }
        y.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        MMAppMgr.czE();
        Process.killProcess(Process.myPid());
        return;
      }
    } while (com.tencent.mm.sdk.platformtools.t.a(this.bRh, "LauncherUI.jump_switch_account", false));
    paramContext = at.dVC.L("login_user_name", "");
    y.i("MicroMsg.LauncherUI", "jumpToLogin %s", new Object[] { paramContext });
    if (bk.bl(paramContext))
    {
      if (this.uKV == null)
      {
        this.uKV = new WelcomeSelectView(this);
        setContentView(this.uKV);
        this.uKV.Yz();
      }
      com.tencent.mm.plugin.report.service.g.wK(8);
      ai.S(this.uLb);
      ai.l(this.uLb, 2000L);
      return;
    }
    boolean bool = ae.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false);
    y.i("MicroMsg.LauncherUI", "switchAccount %s", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      paramContext = new Intent(this, SettingsSwitchAccountUI.class);
      paramContext.addFlags(67108864);
      paramContext.putExtra("key_scene", 2);
      startActivity(paramContext);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.b.gI(this);
      break;
      int i = bk.ZR(at.dVC.L("last_login_use_voice", ""));
      y.i("MicroMsg.LauncherUI", "pluginSwitch  " + i);
      if ((i & 0x20000) != 0) {
        startActivity(new Intent().setClassName(this, "com.tencent.mm.plugin.account.ui.LoginVoiceUI"));
      } else {
        startActivity(new Intent().setClassName(this, "com.tencent.mm.plugin.account.ui.LoginPasswordUI"));
      }
    }
  }
  
  public static void gp(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, LauncherUI.class);
    localIntent.addFlags(67108864);
    paramContext.startActivity(localIntent);
  }
  
  private void mQ(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramBoolean) {
      if (!this.uKR.c(this, new LauncherUI.2(this)))
      {
        paramBoolean = bool2;
        this.uKZ = paramBoolean;
      }
    }
    while (this.uKZ) {
      for (;;)
      {
        return;
        paramBoolean = false;
      }
    }
    int i;
    if (this.uKR.fht)
    {
      paramBoolean = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "");
      y.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
      if (!paramBoolean)
      {
        i = 0;
        if (i != 0) {
          break label163;
        }
      }
    }
    label163:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      this.uKZ = paramBoolean;
      return;
      paramBoolean = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_PHONE_STATE", 97, "", "");
      y.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", new Object[] { Boolean.valueOf(paramBoolean) });
      if (!paramBoolean)
      {
        i = 0;
        break;
      }
      i = 1;
      break;
    }
  }
  
  public final void closeChatting(boolean paramBoolean)
  {
    Object localObject2 = new LauncherUI.5(this);
    Object localObject1 = this.uKQ;
    boolean bool;
    int i;
    if (((ad)localObject1).uPK == null)
    {
      bool = false;
      y.i("MicroMsg.LauncherUI.NewChattingTabUI", "try closeChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      if ((((ad)localObject1).uPR != null) && (((ad)localObject1).uPR.getView() != null)) {
        ((ad)localObject1).uPR.getView().setImportantForAccessibility(4);
      }
      if ((((ad)localObject1).uPK != null) && (((ad)localObject1).uPK.getVisibility() != 8) && (((ad)localObject1).uPR != null) && (((ad)localObject1).ohK != null)) {
        break label374;
      }
      i = 0;
      if (i != 0)
      {
        localObject1 = this.uKP;
        if (!this.uKQ.uPR.isSupportCustomActionBar()) {
          ((HomeUI)localObject1).initActionBar();
        }
        ((HomeUI)localObject1).uJA.supportInvalidateOptionsMenu();
        if (q.GS().booleanValue()) {
          ((HomeUI)localObject1).cyD();
        }
        localObject1 = ((HomeUI)localObject1).uKi;
        if ((((z)localObject1).jVi != 0) || (!com.tencent.mm.kernel.g.DO().dJT.foreground)) {
          break label675;
        }
        au.getNotification().bc(true);
      }
    }
    for (;;)
    {
      localObject2 = (ViewGroup)((z)localObject1).uJA.findViewById(R.h.launcher_container);
      if (localObject2 != null) {
        ((ViewGroup)localObject2).setImportantForAccessibility(1);
      }
      ((z)localObject1).cyJ();
      k.a(((z)localObject1).uJA, 3, ((z)localObject1).jVi, "prepareCloseChatting");
      localObject1 = (com.tencent.mm.ui.conversation.k)((z)localObject1).uOR.get(Integer.valueOf(0));
      if (localObject1 != null)
      {
        ((com.tencent.mm.ui.conversation.k)localObject1).getContentView();
        if (((com.tencent.mm.ui.conversation.k)localObject1).mController != null) {
          ((com.tencent.mm.ui.conversation.k)localObject1).mController.onResume();
        }
        ((com.tencent.mm.ui.conversation.k)localObject1).onHiddenChanged(false);
      }
      localObject1 = (com.tencent.mm.ui.conversation.k)this.uKP.uKi.uOR.get(Integer.valueOf(0));
      if ((localObject1 != null) && (((com.tencent.mm.ui.conversation.k)localObject1).vTt != null))
      {
        localObject1 = ((com.tencent.mm.ui.conversation.k)localObject1).vTt;
        if (((ConversationWithAppBrandListView)localObject1).vRr != null) {
          ((ConversationWithAppBrandListView)localObject1).vRr.arz();
        }
      }
      return;
      bool = ((ad)localObject1).uPK.isShown();
      break;
      label374:
      if ((((ad)localObject1).uPR != null) && (((ad)localObject1).uPR.isSupportNavigationSwipeBack())) {
        com.tencent.mm.ui.widget.g.b(((ad)localObject1).ohK);
      }
      y.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] needAnim:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      ((ad)localObject1).jdMethod_if(4);
      ((ad)localObject1).mChattingClosed = true;
      if (((ad)localObject1).mChattingOutAnim == null)
      {
        ((ad)localObject1).mChattingOutAnim = AnimationUtils.loadAnimation(((ad)localObject1).ohK, MMFragmentActivity.a.uOh);
        ((ad)localObject1).mChattingOutAnim.setAnimationListener(new ad.6((ad)localObject1, (Runnable)localObject2));
      }
      com.tencent.mm.ui.base.x.b(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
      if (((ad)localObject1).uPR.isSupportCustomActionBar())
      {
        localObject2 = (ImageView)((ad)localObject1).ohK.getWindow().getDecorView().findViewById(R.h.prepare_imageview);
        if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 0))
        {
          ((ImageView)localObject2).setVisibility(8);
          y.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] prepareView GONE");
          if (((ImageView)localObject2).getTag() != null) {
            ((View)((ImageView)localObject2).getTag()).setVisibility(0);
          }
        }
      }
      if (paramBoolean)
      {
        ((ad)localObject1).uPS.cyV();
        ((ad)localObject1).uPS.cyW();
        ((ad)localObject1).uPK.startAnimation(((ad)localObject1).mChattingOutAnim);
      }
      for (;;)
      {
        i = 1;
        break;
        ((ad)localObject1).uPS.cyV();
        ((ad)localObject1).uPS.cyW();
        ((ad)localObject1).uPK.setVisibility(8);
        ((ad)localObject1).ohK.onSwipe(1.0F);
        ((ad)localObject1).tryResetChattingSwipeStatus();
      }
      label675:
      au.getNotification().bc(false);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (this.uKQ.czd())
    {
      localObject1 = this.uKQ;
      if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
        ai.S(((ad)localObject1).uPV);
      }
      if (((ad)localObject1).isAnimating) {}
      for (bool = true; bool; bool = ((ad)localObject1).uPR.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)) {
        return true;
      }
    }
    Object localObject1 = this.uKP;
    y.i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    com.tencent.mm.compatible.b.f.ym();
    com.tencent.mm.compatible.b.f.ym();
    int i;
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (((HomeUI)localObject1).uKa != null) && (((HomeUI)localObject1).uKa.isShowing()))
    {
      ((HomeUI)localObject1).uKa.dismiss();
      i = 1;
    }
    while (i != 0)
    {
      return true;
      if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
      {
        ((HomeUI)localObject1).cyE();
        i = 1;
      }
      else
      {
        Object localObject2 = ((HomeUI)localObject1).uKi.czH();
        if ((localObject2 != null) && (((x)localObject2).onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
        {
          i = 1;
        }
        else if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
        {
          if ((au.DK()) && (com.tencent.mm.kernel.g.DN().dJH) && (aq.isWap(((HomeUI)localObject1).uJA)))
          {
            Object localObject3 = ((HomeUI)localObject1).uJA;
            localObject2 = new HomeUI.9((HomeUI)localObject1);
            if (!au.DK()) {
              i = 0;
            }
            for (;;)
            {
              if (i == 0) {
                break label483;
              }
              i = 1;
              break;
              au.Hx();
              i = ((Integer)com.tencent.mm.model.c.Dz().get(65, Integer.valueOf(0))).intValue();
              if (i >= 5)
              {
                i = 0;
              }
              else if (!ag.Zm("show_wap_adviser"))
              {
                i = 0;
              }
              else
              {
                View localView = View.inflate((Context)localObject3, R.i.network_tips, null);
                ((TextView)localView.findViewById(R.h.network_tips_content)).setText(R.l.network_use_net);
                localObject3 = new com.tencent.mm.ui.widget.a.c.a((Context)localObject3);
                ((com.tencent.mm.ui.widget.a.c.a)localObject3).Ip(R.l.app_tip);
                ((com.tencent.mm.ui.widget.a.c.a)localObject3).ei(localView);
                ((com.tencent.mm.ui.widget.a.c.a)localObject3).Is(R.l.app_ok).a(new MMAppMgr.10(i));
                ((com.tencent.mm.ui.widget.a.c.a)localObject3).nW(false);
                ((com.tencent.mm.ui.widget.a.c.a)localObject3).It(R.l.network_do_not_remind).b(new MMAppMgr.11());
                ((com.tencent.mm.ui.widget.a.c.a)localObject3).a(new MMAppMgr.12((DialogInterface.OnClickListener)localObject2));
                ((com.tencent.mm.ui.widget.a.c.a)localObject3).aoP().show();
                i = 1;
              }
            }
          }
          label483:
          i = aq.getBackgroundLimitType(((HomeUI)localObject1).uJA);
          if ((au.DK()) && (com.tencent.mm.kernel.g.DN().dJH) && (aq.isLimited(i)))
          {
            au.Hx();
            if ((com.tencent.mm.platformtools.ah.c((Boolean)com.tencent.mm.model.c.Dz().get(16385, null))) && (MMAppMgr.a(((HomeUI)localObject1).uJA, i, new HomeUI.10((HomeUI)localObject1, i), new HomeUI.11((HomeUI)localObject1))))
            {
              i = 1;
              continue;
            }
          }
          ((HomeUI)localObject1).cxK();
        }
        else
        {
          i = 0;
        }
      }
    }
    try
    {
      bool = super.dispatchKeyEvent(paramKeyEvent);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      y.w("MicroMsg.LauncherUI", "dispatch key event catch exception %s", new Object[] { paramKeyEvent.getMessage() });
      y.printErrStackTrace("MicroMsg.LauncherUI", paramKeyEvent, "", new Object[0]);
    }
    return false;
  }
  
  public void finish()
  {
    super.finish();
    cyZ();
    y.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(uKM.size()), bk.csb() });
  }
  
  public boolean forceRemoveNoMatchOnPath()
  {
    return true;
  }
  
  public x getCurrentFragmet()
  {
    Object localObject1 = this.uKQ;
    if (!((ad)localObject1).mChattingClosed) {}
    for (localObject1 = ((ad)localObject1).uPR;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getCurrentFragmet();
      }
      return localObject2;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.v("MicroMsg.LauncherUI", "edw on activity result");
    Object localObject = this.uKQ;
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 30762)) && (((ad)localObject).uPR != null)) {
      ((ad)localObject).uPR.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    int i = 0xFFFF & paramInt1;
    y.w("MicroMsg.LauncherUI.NewChattingTabUI", "check request code %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      i = 0;
      if ((i != 0) && (((ad)localObject).uPR == null))
      {
        y.i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
        ai.S(((ad)localObject).uPT);
        ((ad)localObject).uPT.uQe = 0;
        ((ad)localObject).uPT.bQU = paramInt1;
        ((ad)localObject).uPT.aYY = paramInt2;
        ((ad)localObject).uPT.bQV = paramIntent;
        ai.d(((ad)localObject).uPT);
        i = 1;
        label204:
        if (i == 0) {
          break label222;
        }
      }
      break;
    }
    label222:
    HomeUI localHomeUI;
    label276:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            i = 1;
            break;
            i = 0;
            break label204;
            localHomeUI = this.uKP;
          } while (!localHomeUI.uJU);
          if (paramInt1 != 1) {
            break label276;
          }
          au.Hx();
        } while (com.tencent.mm.platformtools.ah.d((Boolean)com.tencent.mm.model.c.Dz().get(12323, null)));
        com.tencent.mm.platformtools.z.showAddrBookUploadConfirm(localHomeUI.uJA, null, false, 3);
        return;
        if (paramInt1 == 22722)
        {
          y.i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          localObject = null;
          if (paramIntent != null) {
            localObject = paramIntent.getBundleExtra("result_data");
          }
          if ((localObject != null) && (((Bundle)localObject).getString("go_next", "").equals("agree_privacy")))
          {
            y.i("MicroMsg.LauncherUI.HomeUI", "agree privacy policy");
            com.tencent.mm.plugin.report.service.h.nFQ.a(712L, 4L, 1L, false);
            localObject = new com.tencent.mm.plugin.account.model.e(1);
            com.tencent.mm.kernel.g.Dk().a((com.tencent.mm.ah.m)localObject, 0);
            if ((com.tencent.mm.at.b.mC((String)com.tencent.mm.kernel.g.DP().Dz().get(274436, null))) && (com.tencent.mm.kernel.g.DP().Dz().getBoolean(ac.a.uzi, false)))
            {
              y.i("MicroMsg.LauncherUI.HomeUI", "needbirthday true");
              ai.l(new HomeUI.14(localHomeUI), 100L);
            }
          }
        }
        while ((paramInt1 == 65534) && (paramInt2 == -1))
        {
          ag.Zn("welcome_page_show");
          l.k(localHomeUI.uJA, true);
          MMAppMgr.tn();
          MMAppMgr.i(localHomeUI.uJA, true);
          localHomeUI.uJA.finish();
          return;
          y.i("MicroMsg.LauncherUI.HomeUI", "disagree privacy policy");
          localObject = new com.tencent.mm.plugin.account.model.e(2);
          com.tencent.mm.kernel.g.Dk().a((com.tencent.mm.ah.m)localObject, 0);
          com.tencent.mm.plugin.report.service.h.nFQ.a(712L, 5L, 1L, false);
          continue;
          if (paramInt1 == 22723)
          {
            localObject = null;
            if (paramIntent != null) {
              localObject = paramIntent.getBundleExtra("result_data");
            }
            if (localObject != null) {
              if (((Bundle)localObject).getString("go_next", "").equals("birthdayComfirmOK"))
              {
                y.i("MicroMsg.LauncherUI.HomeUI", "verify birthday ok");
                com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzi, Boolean.valueOf(false));
              }
              else if (((Bundle)localObject).getString("go_next", "").equals("gdpr_confirm_logout"))
              {
                y.i("MicroMsg.LauncherUI.HomeUI", "quit verify birthday after H5-warnning");
                localObject = new com.tencent.mm.plugin.account.model.e(2);
                com.tencent.mm.kernel.g.Dk().a((com.tencent.mm.ah.m)localObject, 0);
                com.tencent.mm.plugin.report.service.h.nFQ.a(712L, 5L, 1L, false);
              }
            }
          }
        }
      } while ((paramInt1 != 30764) || (paramIntent == null));
      paramIntent = paramIntent.getBundleExtra("result_data");
    } while ((paramIntent == null) || (!paramIntent.getString("go_next", "").equals("gdpr_auth_location")));
    com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzP, Boolean.valueOf(true));
    com.tencent.mm.pluginsdk.permission.a.b(localHomeUI.uJA, "android.permission.ACCESS_COARSE_LOCATION", 66);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.uKP;
    com.tencent.mm.pluginsdk.e.b(paramConfiguration.uJA, paramConfiguration.contentView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.blink.a.bj(com.tencent.mm.kernel.h.DT().dLk);
    long l1 = System.currentTimeMillis();
    y.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bk.fW(this) });
    super.onCreate(paramBundle);
    long l2 = System.currentTimeMillis();
    int i = getTaskId();
    String str = getPackageName();
    paramBundle = getIntent();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (com.tencent.mm.sdk.platformtools.t.a(paramBundle, "absolutely_exit", false))
      {
        bool1 = true;
        y.i("MicroMsg.LauncherUI", "checktask checkInstance isWantToRestart");
      }
    }
    Object localObject1 = null;
    paramBundle = null;
    Object localObject2;
    if (!bool1)
    {
      localObject2 = uKM.iterator();
      localObject1 = paramBundle;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (LauncherUI)((Iterator)localObject2).next();
        if (((LauncherUI)localObject1).getTaskId() != i)
        {
          y.i("MicroMsg.LauncherUI", "checktask checkInstance 0x%x diff taskid taskid %d, nowtaskid:%d", new Object[] { Integer.valueOf(localObject1.hashCode()), Integer.valueOf(((LauncherUI)localObject1).getTaskId()), Integer.valueOf(i) });
          paramBundle = bk.al(this, i);
          if (paramBundle != null)
          {
            y.i("MicroMsg.LauncherUI", "checktask task diff id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), paramBundle.topActivity.getClassName(), paramBundle.baseActivity.getClassName(), Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
            if (paramBundle.baseActivity.getPackageName().equals(str)) {
              break label413;
            }
            y.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + paramBundle.baseActivity.getPackageName());
            finish();
            if (bk.al(this, ((LauncherUI)localObject1).getTaskId()) != null)
            {
              y.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
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
        y.i("MicroMsg.LauncherUI", "onCreate checkInstance false");
        return;
        y.e("MicroMsg.LauncherUI", "checktask cannot found curren taskinfo %d", new Object[] { Integer.valueOf(i) });
        finish();
        i = 0;
        continue;
        label413:
        ((LauncherUI)localObject1).finish();
        uKM.remove(localObject1);
        break;
        if (!uKM.isEmpty())
        {
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = bk.al(this, i);
          }
          if (paramBundle == null) {
            break label684;
          }
          localObject1 = paramBundle.baseActivity.getClassName();
          str = paramBundle.baseActivity.getClassName();
          y.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), str, localObject1, Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
          localObject2 = getComponentName().getClassName();
          if ((paramBundle.numActivities > 1) && (((String)localObject2).equals(localObject1)) && (((String)localObject2).equals(str)))
          {
            finish();
            y.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(uKM.size()) });
            i = 0;
            continue;
          }
          y.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", new Object[] { Integer.valueOf(uKM.size()), Boolean.valueOf(bool1) });
          uKM.clear();
        }
        for (;;)
        {
          uKM.add(this);
          y.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d, use time %d", new Object[] { Integer.valueOf(uKM.size()), Long.valueOf(System.currentTimeMillis() - l2) });
          i = 1;
          break;
          label684:
          y.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(uKM.size()) });
          uKM.clear();
        }
      }
    }
    y.i("MicroMsg.LauncherUI", "onCreate normally");
    this.uKP = new HomeUI();
    this.uKQ = new ad(this.uKP);
    paramBundle = this.uKP;
    localObject1 = this.uKQ;
    paramBundle.uJA = this;
    paramBundle.uKg = ((LauncherUI.a)localObject1);
    localObject1 = paramBundle.uKi;
    ((z)localObject1).uJA = this;
    ((z)localObject1).uOF = paramBundle;
    localObject1 = ((z)localObject1).uOE;
    ((aa)localObject1).uJA = this;
    ((aa)localObject1).uOY = paramBundle;
    paramBundle.uKh = new j(this, paramBundle);
    NotifyReceiver.vX();
    com.tencent.mm.pluginsdk.e.S(paramBundle.uJA);
    paramBundle.mActionBar = getSupportActionBar();
    if (paramBundle.mActionBar != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.actionbar_bg_color)));
      }
      paramBundle.mActionBar.hide();
    }
    setRequestedOrientation(1);
    paramBundle = at.dVC.L("login_user_name", "");
    this.bRh = getIntent();
    localObject1 = this.uKW;
    ((com.tencent.mm.pluginsdk.r)localObject1).rSI = this.bRh.getBooleanExtra("splash-hack-activity-recreate", false);
    y.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", new Object[] { ((com.tencent.mm.pluginsdk.r)localObject1).mTag, Boolean.valueOf(((com.tencent.mm.pluginsdk.r)localObject1).rSI) });
    y.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", new Object[] { paramBundle, Boolean.valueOf(au.Hz()), Boolean.valueOf(uKN) });
    if ((!uKN) && ((au.Hz()) || (!paramBundle.equals(""))))
    {
      uKO = l1;
      y.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.b.bvZ));
      if (czc()) {
        y.i("MicroMsg.LauncherUI", "handleExitIntent return");
      }
    }
    else
    {
      uKO = l1;
      y.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.b.bvZ));
      setRequestedOrientation(1);
      bool1 = au.Hz();
      paramBundle = at.dVC.L("login_user_name", "");
      if ((!bool1) && (paramBundle.equals(""))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1166;
        }
        com.tencent.mm.sdk.platformtools.e.uel = false;
        break;
      }
      label1166:
      bool1 = false;
      if (com.tencent.mm.sdk.platformtools.e.uem) {
        bool1 = MMAppMgr.a(this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            LauncherUI.a(LauncherUI.this);
          }
        });
      }
      for (;;)
      {
        if (!bool1) {
          mQ(true);
        }
        com.tencent.mm.pluginsdk.g.a.a.o.awa();
        com.tencent.mm.plugin.report.service.g.wK(8);
        paramBundle = new WelcomeSelectView(this);
        setContentView(paramBundle);
        this.uKV = paramBundle;
        y.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        ai.S(this.uLb);
        ai.l(this.uLb, 2000L);
        break;
        MMAppMgr.gr(this);
      }
    }
    cza();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.uKQ.czd()) {
      return false;
    }
    HomeUI localHomeUI = this.uKP;
    if ((localHomeUI.uKg == null) || (localHomeUI.uKg.czd())) {
      return false;
    }
    int i = localHomeUI.uJA.getSupportActionBar().getHeight();
    if (i == 0)
    {
      DisplayMetrics localDisplayMetrics = localHomeUI.uJA.getResources().getDisplayMetrics();
      if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels) {
        i = localHomeUI.uJA.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
      }
    }
    for (;;)
    {
      localHomeUI.uKo = paramMenu.add(0, 1, 0, R.l.top_item_desc_search);
      localHomeUI.uKo.setIcon(R.k.actionbar_icon_dark_search);
      if (localHomeUI.nST) {
        localHomeUI.uKo.setIcon(R.k.actionbar_icon_light_search);
      }
      int j = com.tencent.mm.cb.a.fromDPToPix(localHomeUI.uJA, 68);
      localHomeUI.uKp = paramMenu.add(0, 2, 0, R.l.top_item_desc_more);
      if (localHomeUI.uKl == null)
      {
        paramMenu = new ViewGroup.LayoutParams(j, i);
        localHomeUI.uKl = com.tencent.mm.kiss.a.b.ED().a(localHomeUI.uJA, "R.layout.actionview_with_dot_tips", R.i.actionview_with_dot_tips);
        localHomeUI.uKm = ((ImageView)localHomeUI.uKl.findViewById(R.h.icon));
        localHomeUI.uKn = localHomeUI.uKl.findViewById(R.h.tips);
        localHomeUI.uKl.setLayoutParams(paramMenu);
        localHomeUI.uKl.setBackgroundResource(R.g.actionbar_menu_selector);
        localHomeUI.uKl.setMinimumHeight(i);
        localHomeUI.uKl.setMinimumWidth(j);
        localHomeUI.uKm.setImageResource(R.k.actionbar_icon_dark_add);
        localHomeUI.uKl.setContentDescription(localHomeUI.getString(R.l.top_item_desc_more));
        localHomeUI.uKl.setOnClickListener(new HomeUI.26(localHomeUI));
        localHomeUI.uKl.post(new HomeUI.2(localHomeUI));
      }
      if ((localHomeUI.nST) && (localHomeUI.uKm != null)) {
        localHomeUI.uKm.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      com.tencent.mm.blink.b.vG().k(new HomeUI.3(localHomeUI));
      android.support.v4.view.f.a(localHomeUI.uKp, localHomeUI.uKl);
      if (localHomeUI.uKo != null)
      {
        android.support.v4.view.f.a(localHomeUI.uKo, 2);
        localHomeUI.uKo.setVisible(true);
      }
      if (localHomeUI.uKp != null)
      {
        android.support.v4.view.f.a(localHomeUI.uKp, 2);
        localHomeUI.uKp.setVisible(true);
      }
      localHomeUI.uKl.getLayoutParams().width = j;
      localHomeUI.uKl.getLayoutParams().height = i;
      y.v("MicroMsg.LauncherUI.HomeUI", "onCreateOptionsMenu");
      return true;
      i = localHomeUI.uJA.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
    }
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.blink.a.vB();
    super.onDestroy();
    Object localObject = this.uKP;
    ((HomeUI)localObject).uKi.czI();
    if (((HomeUI)localObject).uKh != null)
    {
      j localj = ((HomeUI)localObject).uKh;
      com.tencent.mm.sdk.b.a.udP.d(localj.uJG);
      com.tencent.mm.sdk.b.a.udP.d(localj.uJH);
    }
    if (((HomeUI)localObject).uJU) {
      Looper.myQueue().removeIdleHandler(((HomeUI)localObject).uKq);
    }
    localObject = this.uKQ;
    if ((((ad)localObject).mPrepareBitmap != null) && (!((ad)localObject).mPrepareBitmap.isRecycled())) {
      ((ad)localObject).mPrepareBitmap.recycle();
    }
    ai.S(((ad)localObject).uPV);
    Looper.myQueue().removeIdleHandler(((ad)localObject).uPM);
    cyZ();
    y.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bk.fW(this), Integer.valueOf(uKM.size()) });
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    y.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", new Object[] { Integer.valueOf(hashCode()), bk.fW(this) });
    this.bRh = paramIntent;
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (czc()) {
      y.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
    }
    do
    {
      return;
      if ((this.bRh != null) && (com.tencent.mm.sdk.platformtools.t.a(this.bRh, "Intro_Need_Clear_Top ", false)))
      {
        y.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
        finish();
        gp(this);
        return;
      }
      if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
        closeChatting(false);
      }
      z localz = this.uKP.uKi;
      if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
        localz.uOG = true;
      }
    } while (!this.uKS);
    y.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
    ao(paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int j = 0;
    HomeUI localHomeUI = this.uKP;
    x localx = localHomeUI.uJA.getCurrentFragmet();
    int i;
    if ((localx != null) && (localx.isShowing())) {
      i = j;
    }
    while (i != 0)
    {
      return true;
      i = j;
      if (!localHomeUI.uKg.czd())
      {
        if (paramMenuItem.getItemId() == 2)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.aC(10919, "0");
          localHomeUI.cyE();
        }
        for (;;)
        {
          i = 1;
          break;
          i = j;
          if (paramMenuItem.getItemId() != 1) {
            break;
          }
          localHomeUI.cyF();
        }
      }
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    y.d("MicroMsg.LauncherUI", "onPause, chatting is show ");
    super.onPause();
    Object localObject1 = this.uKW;
    boolean bool = ((com.tencent.mm.pluginsdk.r)localObject1).cd("onPause");
    if (bool) {
      ((com.tencent.mm.pluginsdk.r)localObject1).rSI = false;
    }
    if (bool) {
      y.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
    }
    do
    {
      return;
      com.tencent.mm.blink.a.vB();
      y.i("MicroMsg.LauncherUI", "not skip this onPause");
      localObject1 = getCurrentFragmet();
      this.uLa.removeCallbacksAndMessages(null);
      Object localObject2 = this.uKP;
      Object localObject3 = ((HomeUI)localObject2).uKi;
      bool = ((HomeUI)localObject2).uJU;
      y.v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", new Object[] { Integer.valueOf(((z)localObject3).jVi), Boolean.valueOf(bool) });
      if (bool) {
        ((z)localObject3).czJ();
      }
      localObject3 = ((z)localObject3).uOE;
      if (au.DK())
      {
        au.Hx();
        com.tencent.mm.model.c.Dz().b(((aa)localObject3).uPd);
        au.Hx();
        com.tencent.mm.model.c.FB().b((m.b)localObject3);
        com.tencent.mm.y.c.BS().b(((aa)localObject3).uPc);
        com.tencent.mm.sdk.b.a.udP.d(((aa)localObject3).uPe);
        com.tencent.mm.sdk.b.a.udP.d(((aa)localObject3).uJb);
        com.tencent.mm.sdk.b.a.udP.d(((aa)localObject3).uJa);
      }
      localObject3 = ((HomeUI)localObject2).uKh;
      if (((j)localObject3).uJD != null)
      {
        au.Dk().b(255, ((j)localObject3).uJD);
        au.Dk().b(384, ((j)localObject3).uJD);
        ((j)localObject3).uJD = null;
      }
      com.tencent.mm.sdk.a.b.bN(false);
      ((HomeUI)localObject2).uKf = HomeUI.a.uKB;
      if (!au.Hp()) {
        au.getNotification().bc(false);
      }
      bool = ((HomeUI)localObject2).uKg.czd();
      y.i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show " + bool);
      if (!bool) {
        k.a(((HomeUI)localObject2).uJA, 4, ((HomeUI)localObject2).uKi.jVi, "directReport_onPause");
      }
      if (!((HomeUI)localObject2).uJA.isFinishing()) {
        com.tencent.mm.ui.widget.g.a(((HomeUI)localObject2).uJA);
      }
      if (((HomeUI)localObject2).uJU)
      {
        y.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
        com.tencent.mm.blink.b.vG().vI();
        if (au.DK()) {
          com.tencent.mm.sdk.b.a.udP.d(((HomeUI)localObject2).nQu);
        }
      }
      if ((((HomeUI)localObject2).uKa != null) && (((HomeUI)localObject2).uKa.isShowing())) {
        ((HomeUI)localObject2).uKa.dismiss();
      }
      localObject2 = this.uKQ;
      if (((ad)localObject2).czd())
      {
        ((ad)localObject2).jdMethod_if(4);
        if ((((ad)localObject2).uPR != null) && (((ad)localObject2).uPR.isSupportNavigationSwipeBack())) {
          ((ad)localObject2).uPR.getSwipeBackLayout().setEnableGesture(false);
        }
      }
    } while (localObject1 != null);
    this.uKT = false;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.uKZ = false;
    Object localObject;
    if (!this.uKR.a(this, paramInt, paramArrayOfString, paramArrayOfInt))
    {
      localObject = this.uKP;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      localObject = this.uKQ;
      if (((ad)localObject).uPR != null) {
        ((ad)localObject).uPR.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
      return;
      if (paramInt == 80) {}
      for (int i = R.l.permission_microphone_request_again_msg; paramArrayOfInt[0] != 0; i = R.l.permission_camera_request_again_msg)
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).uJA, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(R.l.permission_tips_title), ((HomeUI)localObject).getString(R.l.jump_to_settings), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.15((HomeUI)localObject), new HomeUI.16((HomeUI)localObject));
        break;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ((HomeUI)localObject).cyF();
      }
      else
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).uJA, ((HomeUI)localObject).getString(R.l.permission_location_request_again_msg), ((HomeUI)localObject).getString(R.l.permission_tips_title), ((HomeUI)localObject).getString(R.l.jump_to_settings), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.17((HomeUI)localObject), null);
        continue;
        if (paramArrayOfInt[0] == 0)
        {
          localObject = ((HomeUI)localObject).uKi.czH();
          if ((localObject instanceof h)) {
            ((h)localObject).cyr();
          }
        }
        else
        {
          com.tencent.mm.ui.base.h.a(((HomeUI)localObject).uJA, ((HomeUI)localObject).getString(R.l.permission_location_request_again_msg), ((HomeUI)localObject).getString(R.l.permission_tips_title), ((HomeUI)localObject).getString(R.l.jump_to_settings), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.18((HomeUI)localObject), null);
        }
      }
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    ad localad = this.uKQ;
    localad.uPO = paramBundle.getString("last_restore_talker");
    y.i("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", new Object[] { localad.uPO });
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.uKW.cd("onResume"))
    {
      y.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
      return;
    }
    y.i("MicroMsg.LauncherUI", "not skip this onResume");
    uKN = false;
    Object localObject1;
    Object localObject2;
    long l1;
    Object localObject4;
    boolean bool1;
    boolean bool2;
    label939:
    long l2;
    if (czb())
    {
      y.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", new Object[] { Boolean.valueOf(this.uKS) });
      if (!this.uKS)
      {
        this.uKS = true;
        localObject1 = this.uKP;
        localObject2 = ((HomeUI)localObject1).uKh;
        com.tencent.mm.sdk.b.a.udP.c(((j)localObject2).uJG);
        com.tencent.mm.sdk.b.a.udP.c(((j)localObject2).uJH);
        if (!com.tencent.mm.ui.conversation.b.cHU()) {
          getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
        }
        localObject2 = ((HomeUI)localObject1).uJA.getSharedPreferences("system_config_prefs", 4);
        if (((SharedPreferences)localObject2).getBoolean("first_launch_weixin", true))
        {
          ((SharedPreferences)localObject2).edit().putBoolean("first_launch_weixin", false).commit();
          XLogSetup.realSetupXlog();
        }
        ((HomeUI)localObject1).uKa = new af(this);
        ((HomeUI)localObject1).uJU = true;
        NotifyReceiver.vY();
        au.getNotification().fU(1);
        y.d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
        l1 = System.currentTimeMillis();
        if (!au.DK())
        {
          y.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
          ((HomeUI)localObject1).uJA.finish();
          localObject4 = ((HomeUI)localObject1).uKi;
          ((z)localObject4).uOI = ((CustomViewPager)((z)localObject4).uJA.findViewById(R.h.pager));
          ((z)localObject4).uOI.setOffscreenPageLimit(4);
          ((z)localObject4).uOI.setCanSlide(true);
          ((z)localObject4).uOI.setCanSlideBySide(false);
          ((z)localObject4).uOJ = new z.a((z)localObject4, ((z)localObject4).uJA, ((z)localObject4).uOI);
          ((z)localObject4).FY(0);
          localObject1 = ((z)localObject4).uOE;
          localObject2 = (ViewGroup)((z)localObject4).uOI.getParent();
          localObject4 = ((z)localObject4).uOJ;
          c localc = ((aa)localObject1).uOZ;
          if (((aa)localObject1).uOZ != null)
          {
            ((aa)localObject1).uOZ.setOnTabClickListener(null);
            ((View)((aa)localObject1).uOZ).setVisibility(8);
            if (localObject2 != null) {
              ((ViewGroup)localObject2).removeView((View)((aa)localObject1).uOZ);
            }
          }
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
          LauncherUIBottomTabView localLauncherUIBottomTabView = new LauncherUIBottomTabView(((aa)localObject1).uJA);
          localLauncherUIBottomTabView.setId(R.h.launcher_ui_bottom_tabview);
          if (localObject2 != null)
          {
            localLayoutParams.gravity = 80;
            ((ViewGroup)localObject2).addView(localLauncherUIBottomTabView, localLayoutParams);
          }
          ((aa)localObject1).uOZ = localLauncherUIBottomTabView;
          ((View)((aa)localObject1).uOZ).setVisibility(0);
          ((aa)localObject1).uOZ.setOnTabClickListener((c.a)localObject4);
          if ((localc != null) && (localc != ((aa)localObject1).uOZ))
          {
            ((aa)localObject1).uOZ.mH(localc.getShowFriendPoint());
            ((aa)localObject1).uOZ.mI(localc.getSettingsPoint());
            ((aa)localObject1).uOZ.FH(localc.getMainTabUnread());
            ((aa)localObject1).uOZ.FI(localc.getContactTabUnread());
            ((aa)localObject1).uOZ.FJ(localc.getFriendTabUnread());
            ((aa)localObject1).uOZ.FK(localc.getSettingsTabUnread());
            ((aa)localObject1).uOZ.setTo(localc.getCurIdx());
          }
          this.uKQ.ohK = this;
          ao(getIntent());
        }
      }
      else
      {
        localObject1 = this.uKP;
        l1 = com.tencent.mm.platformtools.ah.UY();
        localObject2 = ((HomeUI)localObject1).uKi;
        y.i("MicroMsg.LauncherUI.MainTabUI", "onResume start :%d", new Object[] { Integer.valueOf(((z)localObject2).jVi) });
        if (((z)localObject2).uOR.size() != 0) {
          ((o)((z)localObject2).uOR.get(Integer.valueOf(((z)localObject2).jVi))).cxN();
        }
        if ((((z)localObject2).uOG) && (((z)localObject2).uJA.getIntent().hasExtra("isScrollFirst")) && (((z)localObject2).uJA.getIntent().hasExtra("isShowHeader")))
        {
          localObject4 = (com.tencent.mm.ui.conversation.k)((z)localObject2).uOR.get(Integer.valueOf(0));
          if (localObject4 != null)
          {
            bool1 = ((z)localObject2).uJA.getIntent().getBooleanExtra("isShowHeader", false);
            bool2 = ((z)localObject2).uJA.getIntent().getBooleanExtra("isScrollFirst", true);
            ((com.tencent.mm.ui.conversation.k)localObject4).i(bool1, ((z)localObject2).uJA.getIntent().getBooleanExtra("isShowHeaderWithAnim", false), bool2);
          }
        }
        if (((z)localObject2).uOG)
        {
          ((z)localObject2).uOG = false;
          ((z)localObject2).acW("tab_main");
        }
        localObject4 = (com.tencent.mm.ui.conversation.k)((z)localObject2).uOR.get(Integer.valueOf(0));
        if (localObject4 != null)
        {
          ((com.tencent.mm.ui.conversation.k)localObject4).cHo();
          ((com.tencent.mm.ui.conversation.k)localObject4).cIq();
        }
        if (((z)localObject2).jVi != 0) {
          break label3002;
        }
        au.getNotification().bc(true);
        localObject4 = (o)((z)localObject2).FZ(((z)localObject2).jVi);
        if (localObject4 != null) {
          ((o)localObject4).cxO();
        }
        ((z)localObject2).uOG = false;
        int i = com.tencent.mm.sdk.platformtools.t.a(((z)localObject2).uJA.getIntent(), "preferred_tab", 0);
        y.d("MicroMsg.LauncherUI.MainTabUI", "doOnResume, tabIdx = %d", new Object[] { Integer.valueOf(i) });
        if (i != 0)
        {
          ((z)localObject2).FY(i);
          ((z)localObject2).uJA.getIntent().putExtra("preferred_tab", 0);
        }
        com.tencent.mm.sdk.b.a.udP.c(((z)localObject2).uON);
        com.tencent.mm.sdk.b.a.udP.c(((z)localObject2).uOP);
        localObject2 = ((z)localObject2).uOE;
        if (((aa)localObject2).uOZ != null) {
          ((aa)localObject2).uOZ.cxS();
        }
        au.Hx();
        com.tencent.mm.model.c.Dz().a(((aa)localObject2).uPd);
        com.tencent.mm.y.c.BS().a(((aa)localObject2).uPc);
        au.Hx();
        com.tencent.mm.model.c.FB().a((m.b)localObject2);
        com.tencent.mm.sdk.b.a.udP.c(((aa)localObject2).uJb);
        com.tencent.mm.sdk.b.a.udP.c(((aa)localObject2).uPe);
        com.tencent.mm.sdk.b.a.udP.c(((aa)localObject2).uJa);
        com.tencent.mm.blink.b.vG().k(new aa.7((aa)localObject2));
        localObject2 = ((HomeUI)localObject1).uKh;
        localObject4 = new ay();
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject4);
        if ((((ay)localObject4).bHi.bHj) && (!com.tencent.mm.platformtools.ah.bl(((ay)localObject4).bHi.bHk)))
        {
          y.d("MicroMsg.LauncherUI.GlobalAlertMgr", "  now show msg:%s", new Object[] { ((ay)localObject4).bHi.bHk });
          com.tencent.mm.ui.base.h.b(((j)localObject2).uJA, ((ay)localObject4).bHi.bHk, ((ay)localObject4).bHi.title, true);
        }
        if (!((j)localObject2).a(((j)localObject2).uJC)) {
          au.DS().k(new j.6((j)localObject2), 500L);
        }
        ((j)localObject2).uJC = null;
        com.tencent.mm.sdk.a.b.bN(true);
        bool1 = ((HomeUI)localObject1).uKg.czd();
        if ((!bool1) && (au.DK()))
        {
          com.tencent.mm.blink.b.vG().k(new HomeUI.23((HomeUI)localObject1));
          if ((com.tencent.mm.bg.d.eEY != null) && (com.tencent.mm.bg.d.eEX != null) && (!com.tencent.mm.platformtools.ah.bl(com.tencent.mm.bg.d.eEX.RV())))
          {
            y.i("MicroMsg.LauncherUI.HomeUI", "launcher onResume end track %s", new Object[] { com.tencent.mm.bg.d.eEY.RW() });
            localObject2 = new ex();
            ((ex)localObject2).bLp.username = com.tencent.mm.bg.d.eEY.RW();
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
          }
        }
        if (!bool1) {
          k.a(((HomeUI)localObject1).uJA, 3, ((HomeUI)localObject1).uKi.jVi, "directReport_onResume");
        }
        com.tencent.mm.ui.widget.g.b(((HomeUI)localObject1).uJA);
        ((HomeUI)localObject1).uJA.onSwipe(1.0F);
        ((HomeUI)localObject1).uKf = HomeUI.a.uKA;
        if (((HomeUI)localObject1).uJW)
        {
          ((HomeUI)localObject1).uJW = false;
          ((HomeUI)localObject1).uJW = false;
        }
        com.tencent.mm.ag.n.Kc();
        l2 = System.currentTimeMillis();
        y.w("MicroMsg.LauncherUI.HomeUI", "[Launching Application]");
        l.k(((HomeUI)localObject1).uJA, false);
        l.l(((HomeUI)localObject1).uJA, false);
        long l3 = System.currentTimeMillis();
        if (!((HomeUI)localObject1).uJA.getSharedPreferences(ae.cqR(), 0).getBoolean("settings_landscape_mode", false)) {
          break label3014;
        }
        ((HomeUI)localObject1).uJA.setRequestedOrientation(-1);
        label1582:
        long l4 = System.currentTimeMillis();
        if (cyX() != null)
        {
          com.tencent.mm.blink.b.vG().vJ();
          ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("showprivacypolicy", ((HomeUI)localObject1).uKt);
          ((HomeUI)localObject1).mP(false);
          com.tencent.mm.sdk.b.a.udP.c(((HomeUI)localObject1).nQu);
          y.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - l4));
        }
        y.v("MicroMsg.LauncherUI.HomeUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - l3));
        y.d("MicroMsg.LauncherUI.HomeUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - l2));
        y.i("MicroMsg.LauncherUI.HomeUI", "initView " + (System.currentTimeMillis() - l1));
        if (((HomeUI)localObject1).uJW)
        {
          ((HomeUI)localObject1).uJW = false;
          ((HomeUI)localObject1).uJW = false;
        }
        localObject2 = com.tencent.mm.app.m.sZ();
        ((com.tencent.mm.app.m)localObject2).bwW = true;
        ((com.tencent.mm.app.m)localObject2).bwX.removeMessages(-1999);
        ((com.tencent.mm.app.m)localObject2).bwX.removeMessages(-2999);
        y.i("MicroMsg.LauncherUI.HomeUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - l1));
        if (q.GS().booleanValue()) {
          ((HomeUI)localObject1).cyD();
        }
        com.tencent.mm.blink.b.vG().k(new HomeUI.24((HomeUI)localObject1));
        localObject1 = this.uKQ;
        ((ad)localObject1).uPJ = com.tencent.mm.platformtools.ah.UX();
        if (((ad)localObject1).cbo())
        {
          ((ad)localObject1).uPM = new ad.1((ad)localObject1);
          ai.l(new ad.2((ad)localObject1), 500L);
        }
        if (!((ad)localObject1).czd()) {
          break label3026;
        }
        ((ad)localObject1).jdMethod_if(3);
        if ((((ad)localObject1).uPR != null) && (((ad)localObject1).uPR.isSupportNavigationSwipeBack())) {
          ((ad)localObject1).uPR.getSwipeBackLayout().setEnableGesture(true);
        }
        label1958:
        y.i("MicroMsg.LauncherUI", "resumeNormalJump");
        MMFragmentActivity.a.czF();
        if (("pushcontent_notification".equals(com.tencent.mm.sdk.platformtools.t.j(getIntent(), "nofification_type"))) && (!bk.bl(com.tencent.mm.sdk.platformtools.t.j(getIntent(), "Main_FromUserName"))))
        {
          localObject1 = com.tencent.mm.sdk.platformtools.t.j(getIntent(), "Main_FromUserName");
          i = com.tencent.mm.sdk.platformtools.t.a(getIntent(), "MainUI_User_Last_Msg_Type", 0);
          y.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + (String)localObject1 + i);
          com.tencent.mm.plugin.report.service.h.nFQ.f(10856, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(0) });
        }
        localObject1 = com.tencent.mm.sdk.platformtools.t.j(getIntent(), "LauncherUI.Shortcut.LaunchType");
        if (localObject1 != null)
        {
          if (!((String)localObject1).equals("launch_type_voip")) {
            break label3068;
          }
          y.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
          startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip"));
          com.tencent.mm.plugin.report.service.h.nFQ.f(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
        }
        label2176:
        localObject1 = com.tencent.mm.sdk.platformtools.t.j(getIntent(), "LauncherUI.switch.tab");
        if (!bk.bl((String)localObject1))
        {
          this.uKP.uKi.acW((String)localObject1);
          getIntent().putExtra("LauncherUI.switch.tab", "");
        }
        if ((com.tencent.mm.sdk.platformtools.t.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) || (this.uKU))
        {
          this.uKU = false;
          localObject1 = cyX();
          if (localObject1 != null) {
            ((LauncherUI)localObject1).uKP.cyG();
          }
          getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
          getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
        }
        bool1 = com.tencent.mm.sdk.platformtools.t.a(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
        if (!bool1) {
          break label3144;
        }
        localObject1 = com.tencent.mm.sdk.platformtools.t.j(getIntent(), "LauncherUI.Shortcut.Username");
        label2322:
        if (bool1)
        {
          y.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = " + (String)localObject1);
          if (!bk.bl((String)localObject1))
          {
            localObject4 = com.tencent.mm.plugin.base.model.b.xG((String)localObject1);
            if (!bk.bl((String)localObject4))
            {
              if (com.tencent.mm.model.s.hk((String)localObject4))
              {
                y.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                if (!com.tencent.mm.ai.f.la((String)localObject4)) {
                  break label3389;
                }
                if (!com.tencent.mm.ai.f.eW((String)localObject4)) {
                  break label3169;
                }
                localObject1 = new Intent();
                ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                ((Intent)localObject1).putExtra("Contact_User", (String)localObject4);
                ((Intent)localObject1).putExtra("biz_chat_from_scene", 9);
                ((Intent)localObject1).addFlags(67108864);
                startActivity((Intent)localObject1);
              }
              label2460:
              getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
              getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
            }
          }
        }
        this.uKT = true;
      }
    }
    for (;;)
    {
      for (;;)
      {
        com.tencent.mm.blink.a.fP(5);
        mQ(false);
        cza();
        com.tencent.mm.blink.a.el("LauncherUI");
        return;
        l2 = System.currentTimeMillis();
        MMActivity.initLanguage(((HomeUI)localObject1).uJA);
        try
        {
          localObject2 = new HashSet();
          localObject4 = ((HomeUI)localObject1).getString(R.l.country_others).split(";");
          ((Set)localObject2).add(localObject4[0]);
          ((Set)localObject2).add(localObject4[1]);
          com.tencent.mm.model.r.c((Set)localObject2);
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DS().O(new HomeUI.5((HomeUI)localObject1));
          y.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).fhz = ((LayoutInflater)((HomeUI)localObject1).uJA.getSystemService("layout_inflater"));
          l2 = System.currentTimeMillis();
          ((HomeUI)localObject1).contentView = com.tencent.mm.kiss.a.b.ED().a(((HomeUI)localObject1).uJA, "R.layout.main_tab", R.i.main_tab);
          com.tencent.mm.blink.b.vG().vH();
          ((FirstScreenFrameLayout)((HomeUI)localObject1).contentView.findViewById(R.h.first_screen_layout)).dhh = new HomeUI.1((HomeUI)localObject1);
          ap.clb();
          y.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).uJA.setContentView(((HomeUI)localObject1).contentView);
          Looper.myQueue().addIdleHandler(((HomeUI)localObject1).uKq);
          ((HomeUI)localObject1).uJV = true;
          y.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          y.d("MicroMsg.LauncherUI.HomeUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          y.d("MicroMsg.LauncherUI.HomeUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).initActionBar();
          ((HomeUI)localObject1).mActionBar.show();
          ((HomeUI)localObject1).contentView.post(new HomeUI.12((HomeUI)localObject1));
          y.v("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - l1));
          ai.l(new HomeUI.20((HomeUI)localObject1), 2000L);
          ((HomeUI)localObject1).contentView.addOnLayoutChangeListener(((HomeUI)localObject1).uKj);
          com.tencent.mm.pluginsdk.e.b(((HomeUI)localObject1).uJA, ((HomeUI)localObject1).contentView);
          ((HomeUI)localObject1).contentView.postDelayed(new HomeUI.21((HomeUI)localObject1), 20L);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
          }
        }
      }
      label3002:
      au.getNotification().bc(false);
      break label939;
      label3014:
      ((HomeUI)localObject1).uJA.setRequestedOrientation(1);
      break label1582;
      label3026:
      if (!((ad)localObject1).uPU) {
        break label1958;
      }
      y.w("MicroMsg.LauncherUI.NewChattingTabUI", "[onResume] need exec this runnable!");
      ai.S(((ad)localObject1).uPV);
      ai.d(((ad)localObject1).uPV);
      ((ad)localObject1).uPU = false;
      break label1958;
      label3068:
      if (!((String)localObject1).equals("launch_type_voip_audio")) {
        break label2176;
      }
      y.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
      startActivity(new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio"));
      com.tencent.mm.plugin.report.service.h.nFQ.f(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      break label2176;
      label3144:
      bool1 = com.tencent.mm.sdk.platformtools.t.a(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
      localObject1 = getIntent().getAction();
      break label2322;
      label3169:
      if (com.tencent.mm.ai.f.lc((String)localObject4))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject1).putExtra("enterprise_biz_name", (String)localObject4);
        ((Intent)localObject1).putExtra("enterprise_biz_display_name", com.tencent.mm.model.r.gV((String)localObject4));
        startActivity((Intent)localObject1);
        break label2460;
      }
      if (com.tencent.mm.ai.f.ld((String)localObject4))
      {
        localObject1 = com.tencent.mm.ai.f.kX((String)localObject4);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.ai.d)localObject1).LC())
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
      localObject1 = cyX();
      Object localObject3 = new Bundle();
      ((Bundle)localObject3).putInt("chat_from_scene", 3);
      ((LauncherUI)localObject1).startChatting((String)localObject4, (Bundle)localObject3, false);
      break label2460;
      label3389:
      localObject1 = cyX();
      if (localObject1 == null) {
        break label2460;
      }
      ((LauncherUI)localObject1).startChatting((String)localObject4, null, false);
      break label2460;
      y.i("MicroMsg.LauncherUI", "resumeLogoutJump");
      MMFragmentActivity.a.czF();
      localObject1 = at.dVC.L("login_user_name", "");
      if ((!au.Hz()) && (((String)localObject1).equals("")))
      {
        if (this.uKV != null) {
          this.uKV.Yz();
        }
        y.i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
        ai.S(this.uLb);
        ai.l(this.uLb, 2000L);
      }
      else
      {
        com.tencent.mm.plugin.report.service.g.wK(8);
        localObject1 = com.tencent.mm.kernel.g.DO();
        ((com.tencent.mm.kernel.b)localObject1).dJT.a(new bi(new b.3((com.tencent.mm.kernel.b)localObject1), "reset accinfo"), 0);
        if ((this.bRh.getFlags() & 0x4000000) == 67108864) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = com.tencent.mm.sdk.platformtools.t.a(this.bRh, "Intro_Notify", false);
          y.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", new Object[] { Boolean.valueOf(this.uKS), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(au.CW()) });
          y.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", new Object[] { Boolean.valueOf(au.Hz()) });
          this.uKP.uKi.czI();
          if (!com.tencent.mm.sdk.platformtools.t.a(this.bRh, "key_transit_to_switch_account", false)) {
            break label3903;
          }
          y.i("MicroMsg.LauncherUI", "transit to fake switch account");
          this.bRh.removeExtra("key_transit_to_switch_account");
          localObject3 = ae.getContext().getSharedPreferences("switch_account_preferences", 0);
          localObject1 = ((SharedPreferences)localObject3).getString("last_switch_account_to_wx_username", "");
          ((SharedPreferences)localObject3).edit().putBoolean("transit_to_switch_account", true).commit();
          localObject3 = new Intent();
          localObject4 = at.dVC.L("login_weixin_username", "");
          ((Intent)localObject3).putParcelableArrayListExtra("key_switch_account_users", this.bRh.getParcelableArrayListExtra("key_switch_account_users"));
          ((Intent)localObject3).putExtra("key_switch_from_wx_username", (String)localObject4);
          ((Intent)localObject3).putExtra("key_switch_to_wx_username", (String)localObject1);
          localObject1 = com.tencent.mm.sdk.platformtools.x.d(getSharedPreferences(ae.cqR(), 0));
          float f = com.tencent.mm.cb.a.cJ(this);
          ((Intent)localObject3).putExtra("key_langauage_code", (String)localObject1);
          ((Intent)localObject3).putExtra("key_font_scale_size", f);
          y.i("MicroMsg.LauncherUI", "mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
          ((Intent)localObject3).putExtra("key_mm_process_pid", Process.myPid());
          ((Intent)localObject3).setClassName(this, "com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI");
          startActivity((Intent)localObject3);
          com.tencent.mm.ui.base.b.gL(this);
          ai.l(new LauncherUI.3(this), 500L);
          break;
        }
        label3903:
        au.hold();
        localObject1 = new w();
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        if (com.tencent.mm.sdk.platformtools.t.a(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
          this.uKU = true;
        }
        com.tencent.mm.kernel.g.DQ().gi("[" + this.uKS + " " + bool1 + " " + bool2 + "]");
        go(this);
        au.unhold();
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    Object localObject = this.uKQ;
    if (((ad)localObject).uPR != null)
    {
      localObject = ((ad)localObject).uPR.byx.getTalkerUserName();
      if (!com.tencent.mm.platformtools.ah.bl((String)localObject))
      {
        y.i("MicroMsg.LauncherUI.NewChattingTabUI", "onSaveInstanceState:%s", new Object[] { localObject });
        paramBundle.putString("last_restore_talker", (String)localObject);
      }
    }
  }
  
  public void onSettle(boolean paramBoolean, int paramInt)
  {
    if ((this.uKS) && (!this.uKQ.z(paramBoolean, paramInt))) {
      super.onSettle(paramBoolean, paramInt);
    }
  }
  
  protected void onStop()
  {
    y.i("MicroMsg.LauncherUI", "onStop");
    com.tencent.mm.blink.a.vB();
    HomeUI localHomeUI = this.uKP;
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("showprivacypolicy", localHomeUI.uKt);
    super.onStop();
  }
  
  public void onSwipe(float paramFloat)
  {
    int i = 1;
    ad localad;
    if (this.uKS)
    {
      localad = this.uKQ;
      y.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", new Object[] { Float.valueOf(paramFloat), Long.valueOf(220L), Boolean.valueOf(localad.uPI.cyH()) });
      if (localad.cbo()) {
        break label75;
      }
      if (i == 0) {
        super.onSwipe(paramFloat);
      }
    }
    return;
    label75:
    Object localObject1;
    Object localObject2;
    if ((paramFloat == 0.0F) && (!localad.mChattingClosed))
    {
      localObject1 = (ImageView)localad.ohK.getWindow().getDecorView().findViewById(R.h.prepare_imageview);
      if (localObject1 != null)
      {
        localObject2 = (ViewGroup)((ImageView)localObject1).getTag();
        if (localObject2 != null)
        {
          Bitmap localBitmap = localad.getMagicDrawingCache((View)localObject2);
          if (localBitmap == null) {
            break label230;
          }
          y.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView VISIBLE");
          ((ImageView)localObject1).setVisibility(0);
          ((ImageView)localObject1).setImageBitmap(localBitmap);
          ((ViewGroup)localObject2).setVisibility(8);
        }
      }
      label171:
      if (localad.mChattingInAnim != null) {
        localad.mChattingInAnim.cancel();
      }
    }
    for (;;)
    {
      if (localad.uPI.cyH()) {
        break label553;
      }
      if (Float.compare(1.0F, paramFloat) <= 0) {
        break label367;
      }
      y.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Boolean.valueOf(false) });
      i = 0;
      break;
      label230:
      y.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE no cache!");
      ((ViewGroup)localObject2).setVisibility(0);
      ((ImageView)localObject1).setVisibility(8);
      ((ImageView)localObject1).setImageDrawable(null);
      break label171;
      if ((paramFloat == 1.0F) && (!localad.mChattingClosed) && (localad.cbo()))
      {
        localad.ohK.getWindow().setBackgroundDrawableResource(R.e.room_info_comment_layout_bg);
        localObject1 = (ImageView)localad.ohK.getWindow().getDecorView().findViewById(R.h.prepare_imageview);
        if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 0) && (((ImageView)localObject1).getTag() != null))
        {
          ((View)((ImageView)localObject1).getTag()).setVisibility(0);
          y.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
          ((ImageView)localObject1).setVisibility(8);
        }
      }
    }
    label367:
    for (i = 0;; i = 1)
    {
      localObject1 = localad.ohK.findViewById(R.h.launcher_container);
      localObject2 = (ImageView)localad.ohK.findViewById(R.h.prepare_imageview);
      if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 8) && (((ImageView)localObject2).getDrawable() != null) && (!localad.mChattingClosed) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
      {
        ((ImageView)localObject2).setVisibility(0);
        y.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
      }
      if (Float.compare(1.0F, paramFloat) <= 0)
      {
        com.tencent.mm.ui.tools.h.q((View)localObject1, 0.0F);
        com.tencent.mm.ui.tools.h.q((View)localObject2, 0.0F);
      }
      for (;;)
      {
        break;
        if ((localObject2 != null) && (((ImageView)localObject2).getDrawable() != null)) {
          com.tencent.mm.ui.tools.h.q((View)localObject2, ((ImageView)localObject2).getWidth() / 2.5F * (1.0F - paramFloat) * -1.0F);
        } else {
          com.tencent.mm.ui.tools.h.q((View)localObject1, ((View)localObject1).getWidth() / 2.5F * (1.0F - paramFloat) * -1.0F);
        }
      }
    }
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    Object localObject2 = null;
    Object localObject3 = this.uKQ;
    Object localObject1 = localObject2;
    if (((ad)localObject3).uPR != null)
    {
      localObject1 = localObject2;
      if (((ad)localObject3).uPR.cCn() != null)
      {
        if (((ad)localObject3).uPR.isSupportCustomActionBar()) {
          break label58;
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
      return localObject2;
      label58:
      localObject1 = localObject2;
      if (!com.tencent.mm.compatible.util.d.gH(22))
      {
        localObject3 = ((ad)localObject3).uPR.cCn().startActionMode(paramCallback);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject3;
        }
      }
    }
  }
  
  public final void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    HomeUI localHomeUI = this.uKP;
    if ((q.GS().booleanValue()) && ((HomeUI.uKb.booleanValue()) || (HomeUI.uKc.booleanValue()))) {
      localHomeUI.c(Boolean.valueOf(false), Boolean.valueOf(false));
    }
    localHomeUI.uKi.czK();
    this.uKQ.startChatting(paramString, paramBundle, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI
 * JD-Core Version:    0.7.0.1
 */