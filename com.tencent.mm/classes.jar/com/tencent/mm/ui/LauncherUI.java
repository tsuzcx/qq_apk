package com.tencent.mm.ui;

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
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.autogen.a.by.b;
import com.tencent.mm.autogen.a.gg;
import com.tencent.mm.autogen.a.no;
import com.tencent.mm.autogen.a.ou;
import com.tencent.mm.autogen.a.pw;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.mmdata.rpt.rg;
import com.tencent.mm.blink.FirstScreenFrameLayout;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.kernel.n;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.account.ui.WelcomeActivity;
import com.tencent.mm.plugin.finder.extension.reddot.FinderRedDotManagerOnTab.mainUiIndexChangeListener.1;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.platformtools.c.a;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.sdk.systemservicecache.NetworkCache;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.xlog.app.XLogSetup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class LauncherUI
  extends MMSecDataFragmentActivity
{
  private static ArrayList<LauncherUI> adBA;
  private static ArrayList<WeakReference<LauncherUI>> adBB;
  private static boolean adBC;
  public static long adBD;
  private static boolean adBE;
  private static boolean adBN;
  private IListener<pw> adBF;
  public HomeUI adBG;
  private r adBH;
  public boolean adBI;
  boolean adBJ;
  private boolean adBK;
  private com.tencent.mm.plugin.wallet_index.model.b adBL;
  private com.tencent.mm.pluginsdk.u adBM;
  private boolean adBO;
  private MMHandler adBP;
  private Runnable adBQ;
  private boolean adBR;
  int adBS;
  NewChattingTabUI chattingTabUI;
  private Intent hPY;
  
  static
  {
    AppMethodBeat.i(33334);
    adBA = new ArrayList();
    adBB = new ArrayList();
    adBC = true;
    adBE = false;
    adBN = false;
    AppMethodBeat.o(33334);
  }
  
  public LauncherUI()
  {
    AppMethodBeat.i(33295);
    this.adBF = new LauncherUI.1(this, com.tencent.mm.app.f.hfK);
    this.adBG = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.adBG);
    this.adBH = new r();
    this.hPY = null;
    this.adBI = false;
    this.adBJ = false;
    this.adBK = false;
    this.adBM = new com.tencent.mm.pluginsdk.u("MicroMsg.LauncherUI");
    this.adBO = false;
    this.adBP = new MMHandler();
    this.adBQ = new LauncherUI.4(this);
    this.adBR = false;
    this.adBS = 0;
    AppMethodBeat.o(33295);
  }
  
  private void Lg(boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(33302);
    if (paramBoolean)
    {
      new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(249597);
          LauncherUI.a(LauncherUI.this);
          AppMethodBeat.o(249597);
        }
      };
      if (!r.jjv()) {}
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        this.adBO = paramBoolean;
        AppMethodBeat.o(33302);
        return;
      }
    }
    if (!this.adBO) {
      if (this.adBH.bN(this)) {
        break label77;
      }
    }
    label77:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      this.adBO = paramBoolean;
      AppMethodBeat.o(33302);
      return;
    }
  }
  
  private void cd(Intent paramIntent)
  {
    AppMethodBeat.i(33307);
    Log.i("MicroMsg.LauncherUI", "handleJump");
    if (!com.tencent.mm.model.bh.baz())
    {
      Log.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
      paramIntent = new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(33307);
      return;
    }
    Object localObject1 = new no();
    ((no)localObject1).hPX.hPY = this.hPY;
    ((no)localObject1).publish();
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
        MMWizardActivity.aQ(this, paramIntent);
        AppMethodBeat.o(33307);
        return;
        Log.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
      }
    }
    if ("back_to_pcmgr_error_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.aQ(this, paramIntent);
      AppMethodBeat.o(33307);
      return;
    }
    if ("clear_msg_not_finish_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      com.tencent.mm.ui.base.k.s(this, R.l.gAn, R.l.app_tip);
      AppMethodBeat.o(33307);
      return;
    }
    if ("backup_move_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.aQ(this, paramIntent);
      AppMethodBeat.o(33307);
      return;
    }
    if (IntentUtil.getBooleanExtra(paramIntent, "show_update_dialog", false)) {
      ce(paramIntent);
    }
    String str = IntentUtil.getStringExtra(paramIntent, "Main_User");
    localObject1 = IntentUtil.getStringExtra(paramIntent, "nofification_type");
    Log.i("MicroMsg.LauncherUI", "[handleJump] user:%s", new Object[] { str });
    Object localObject2;
    int i;
    if ((str != null) && (!str.equals("")))
    {
      com.tencent.mm.model.bh.bCz();
      localObject2 = com.tencent.mm.model.c.bzG().bxM(str);
      if (localObject2 != null)
      {
        i = ((bd)localObject2).field_unReadCount;
        Log.i("MicroMsg.LauncherUI", "[oneliang] user:%s, conversation :%s, unReadCount:%s", new Object[] { str, localObject2, Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      int j = i;
      if (i == 0) {
        j = IntentUtil.getIntExtra(paramIntent, "pushcontent_unread_count", 0);
      }
      MMAppMgr.aDA();
      new com.tencent.mm.autogen.a.al().publish();
      boolean bool = IntentUtil.getBooleanExtra(paramIntent, "Intro_Is_Muti_Talker", true);
      Log.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((!bool) && (j > 0))
      {
        i = IntentUtil.getIntExtra(paramIntent, "Intro_Bottle_unread_count", 0);
        if (i > 0)
        {
          Log.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.br.c.ai(this, "bottle", ".ui.BottleConversationUI");
        }
      }
      if (!bool)
      {
        if (au.bwg(str))
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
            MMWizardActivity.aQ(this, (Intent)localObject1);
          }
          AppMethodBeat.o(33307);
          return;
          if (!au.bwo(str)) {
            break;
          }
          Log.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("type", 11);
          com.tencent.mm.br.c.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
        }
        if (paramIntent.getIntExtra("MainUI_User_Last_Msg_Type", 34) != 34) {
          break label1736;
        }
      }
      label1736:
      for (i = 2;; i = 1)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("Chat_Mode", i);
        if ("new_msg_nofification".equals(IntentUtil.getStringExtra(paramIntent, "nofification_type")))
        {
          ((Bundle)localObject1).putInt("chat_from_scene", 1);
          ((Bundle)localObject1).putBoolean("key_can_show_message_float_ball", true);
          ((Bundle)localObject1).putBoolean("MainUI_FromFinderNotification", paramIntent.getBooleanExtra("MainUI_FromFinderNotification", false));
          paramIntent.removeExtra("MainUI_FromFinderNotification");
        }
        localObject2 = getInstance();
        if (localObject2 == null) {
          break;
        }
        if (com.tencent.mm.an.g.Dn(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("biz_chat_from_scene", 4);
          com.tencent.mm.br.c.g(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if (com.tencent.mm.an.g.MC(str))
        {
          localObject1 = com.tencent.mm.an.g.hU(str);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).aAT())
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
        if (au.Hh(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("app_brand_conversation_from_scene", 3);
          paramIntent.putExtra("finish_direct", true);
          localObject2 = com.tencent.mm.plugin.appbrand.config.g.qWE;
          if (!com.tencent.mm.plugin.appbrand.config.g.ckz()) {
            ((Bundle)localObject1).putBoolean("key_need_send_video", false);
          }
          com.tencent.mm.br.c.g(this, ".ui.conversation.AppBrandServiceConversationUI", paramIntent);
          break;
        }
        if (au.bwQ(str))
        {
          paramIntent.putExtra("Contact_User", "opencustomerservicemsg");
          paramIntent.putExtra("open_im_kefu_chatting_username", str);
          paramIntent.putExtra("open_im_kefu_jump_chatting", true);
          paramIntent.putExtra("open_im_kefu_conversation_list_ui_from_scene", 2);
          paramIntent.addFlags(67108864);
          com.tencent.mm.br.c.g(this, ".ui.conversation.OpenImKefuServiceConversationUI", paramIntent);
          ((LauncherUI)localObject2).overridePendingTransition(0, R.a.pop_out);
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
            if (com.tencent.mm.an.g.Dn(str))
            {
              paramIntent.putExtra("Contact_User", str);
              paramIntent.addFlags(67108864);
              paramIntent.putExtra("biz_chat_from_scene", 4);
              com.tencent.mm.br.c.g(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
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
          if ((getInstance() == null) || (!com.tencent.mm.an.g.Dn(str))) {
            break;
          }
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          com.tencent.mm.br.c.g(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if ((!Util.isNullOrNil(str)) && ("new_msg_nofification".equals(localObject1)))
        {
          if (paramIntent == null) {}
          for (localObject1 = "null";; localObject1 = paramIntent)
          {
            Log.w("MicroMsg.LauncherUI", "[handleJump] intent:%s", new Object[] { localObject1 });
            localObject1 = getInstance();
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("chat_from_scene", 1);
            ((Bundle)localObject2).putBoolean("key_can_show_message_float_ball", true);
            if (localObject1 == null) {
              break label1659;
            }
            ((LauncherUI)localObject1).startChatting(str, (Bundle)localObject2, false);
            break;
          }
          label1659:
          Log.w("MicroMsg.LauncherUI", "LauncherUI.getInstance is null! ");
          break;
        }
        if ((Util.isNullOrNil(str)) || (!"force_notify_wxa_subscribemsg".equals(paramIntent.getStringExtra("force_notify_type")))) {
          break;
        }
        localObject1 = getInstance();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("chat_from_scene", 7);
        if (localObject1 == null) {
          break;
        }
        ((LauncherUI)localObject1).startChatting(str, (Bundle)localObject2, false);
        break;
      }
      i = 0;
      break;
      i = 0;
    }
  }
  
  private void ce(Intent paramIntent)
  {
    AppMethodBeat.i(33315);
    int i = IntentUtil.getIntExtra(paramIntent, "update_type", -1);
    if (i == -1)
    {
      Log.e("MicroMsg.LauncherUI", "showUpdateDialog is true, but updateType is -1");
      AppMethodBeat.o(33315);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(405L, 28L, 1L, true);
    com.tencent.mm.plugin.report.service.h localh;
    if (com.tencent.mm.plugin.y.d.gdL() != null)
    {
      paramIntent = com.tencent.mm.plugin.y.d.gdL().b(this, null);
      if (paramIntent == null)
      {
        AppMethodBeat.o(33315);
        return;
      }
      localh = com.tencent.mm.plugin.report.service.h.OAn;
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
  
  public static int getCurrentTabIndex()
  {
    AppMethodBeat.i(33297);
    if ((getInstance() != null) && (getInstance().getHomeUI() != null) && (getInstance().getHomeUI().getMainTabUI() != null))
    {
      int i = getInstance().getHomeUI().getMainTabUI().jP;
      AppMethodBeat.o(33297);
      return i;
    }
    AppMethodBeat.o(33297);
    return -1;
  }
  
  public static LauncherUI getInstance()
  {
    AppMethodBeat.i(33296);
    if (adBA.isEmpty())
    {
      Log.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", new Object[] { Util.getStack() });
      AppMethodBeat.o(33296);
      return null;
    }
    LauncherUI localLauncherUI = (LauncherUI)adBA.get(0);
    AppMethodBeat.o(33296);
    return localLauncherUI;
  }
  
  private void jjm()
  {
    AppMethodBeat.i(33298);
    int i = adBA.indexOf(this);
    if (i >= 0) {
      adBA.remove(i);
    }
    Log.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(adBA.size()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(33298);
  }
  
  private void jjn()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33300);
    Log.d("MicroMsg.LauncherUI", "[whatsnew] checkIfStartWhatsNew.");
    if (adBN)
    {
      Log.i("MicroMsg.LauncherUI", "[whatsnew] has been played.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!com.tencent.mm.kernel.h.baC().aZN())
    {
      com.tencent.mm.kernel.h.baC();
      if (!com.tencent.mm.kernel.b.aZM())
      {
        Log.i("MicroMsg.LauncherUI", "[whatsnew] not login yet, skip.");
        AppMethodBeat.o(33300);
        return;
      }
      Log.i("MicroMsg.LauncherUI", "[whatsnew] account not initiate, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!jjo())
    {
      Log.i("MicroMsg.LauncherUI", "[whatsnew] notSwitchOrHold is false, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    boolean bool3 = IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.enter_from_reg", false);
    boolean bool4 = com.tencent.mm.ui.a.a.a.jlv().jls();
    boolean bool5;
    boolean bool1;
    if ((!bool3) && (com.tencent.mm.pluginsdk.platformtools.c.XUP != null) && (com.tencent.mm.pluginsdk.platformtools.c.XUP.aDL()) && (com.tencent.mm.model.bh.baz()) && (!bool4))
    {
      if (MMEntryLock.lock("show_whatsnew"))
      {
        adBN = true;
        Log.i("MicroMsg.LauncherUI", "[whatsnew] show whatsnew.");
        com.tencent.mm.blink.a.aJT();
        AppMethodBeat.o(33300);
      }
    }
    else
    {
      c.a locala = com.tencent.mm.pluginsdk.platformtools.c.XUP;
      bool5 = com.tencent.mm.model.bh.baz();
      if (locala != null) {
        break label279;
      }
      bool1 = true;
      if ((locala == null) || (!locala.aDL())) {
        break label284;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.LauncherUI", "[whatsnew] do not show whatsnew. enter_from_reg=%s accHasReady=%s MMAppMgr is null %s isWhatsNewAvailable=%s, isAccessibilityEnabled=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
      AppMethodBeat.o(33300);
      return;
      label279:
      bool1 = false;
      break;
      label284:
      bool2 = false;
    }
  }
  
  private boolean jjo()
  {
    AppMethodBeat.i(33304);
    if ((this.hPY != null) && (!IntentUtil.getBooleanExtra(this.hPY, "Intro_Switch", false)) && (com.tencent.mm.model.bh.bCA()) && (!com.tencent.mm.model.bh.aZG()))
    {
      AppMethodBeat.o(33304);
      return true;
    }
    AppMethodBeat.o(33304);
    return false;
  }
  
  private boolean jjp()
  {
    AppMethodBeat.i(33305);
    if (this.hPY != null)
    {
      Object localObject1;
      Object localObject2;
      if ((IntentUtil.getBooleanExtra(this.hPY, "absolutely_exit", false)) || (IntentUtil.getIntExtra(this.hPY, "absolutely_exit_pid", 0) == Process.myPid()))
      {
        Log.w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        finish();
        com.tencent.mm.plugin.report.service.g.ahy(8);
        MMAppMgr.Lj(IntentUtil.getBooleanExtra(this.hPY, "kill_service", true));
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "java/lang/System_EXEC_", "exit", "(I)V");
        AppMethodBeat.o(33305);
        return true;
      }
      if (IntentUtil.getBooleanExtra(this.hPY, "can_finish", false))
      {
        Log.i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
        com.tencent.mm.model.bh.aZW().gZ(true);
        if (n.dv(getApplicationContext())) {
          com.tencent.mm.booter.b.cM(getApplicationContext());
        }
        com.tencent.mm.plugin.report.service.g.ahy(8);
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), WeChatPermissions.PERMISSION_MM_MESSAGE());
        finish();
        com.tencent.mm.ui.base.b.nf(this);
        AppMethodBeat.o(33305);
        return true;
      }
      if (IntentUtil.getBooleanExtra(this.hPY, "exit_and_restart", false))
      {
        Mars.onSingalCrash(0);
        Log.i("MicroMsg.LauncherUI", "exit and restart myself.");
        Log.appenderFlush();
        finish();
        localObject1 = new Intent(this, LauncherUI.class);
        ((Intent)localObject1).addFlags(67108864);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        Log.i("MicroMsg.LauncherUI", "restart, try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        MMAppMgr.jjZ();
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(33305);
        return true;
      }
    }
    AppMethodBeat.o(33305);
    return false;
  }
  
  private void jjq()
  {
    AppMethodBeat.i(33306);
    Log.i("MicroMsg.LauncherUI", "switch to wxid %s", new Object[] { MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "") });
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).addFlags(536870912);
    ((Intent)localObject).putExtra("key_scene", 1);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.ng(this);
    AppMethodBeat.o(33306);
  }
  
  private void jjr()
  {
    AppMethodBeat.i(33308);
    Log.i("MicroMsg.LauncherUI", "resumeLogoutJump");
    if ((this.hPY != null) && (IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.jump_from_uimode_check", false)))
    {
      Log.i("MicroMsg.LauncherUI", "dancy uimode check from background, not jumpToLogin or welcome!");
      AppMethodBeat.o(33308);
      return;
    }
    Object localObject = IntentUtil.getStringExtra(getIntent(), "LauncherUI.Shortcut.LaunchType");
    com.tencent.mm.util.c localc;
    if (localObject != null)
    {
      if (!((String)localObject).equals("launch_type_scan_qrcode")) {
        break label276;
      }
      localObject = new rg();
      ((rg)localObject).iUz = 2L;
      ((rg)localObject).jvA = 2L;
      ((rg)localObject).bMH();
      localc = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject);
    }
    for (;;)
    {
      MMFragmentActivity.a.jka();
      MMFragmentActivity.a.jka();
      ag.init(MMApplicationContext.getContext());
      ag.aAi(2);
      localObject = bg.okT.aM("login_user_name", "");
      if ((com.tencent.mm.model.bh.bCA()) || (!((String)localObject).equals(""))) {
        break;
      }
      localObject = new Intent(this, WelcomeActivity.class);
      ((Intent)localObject).addFlags(536870912);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.ng(this);
      Log.i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
      MMHandlerThread.removeRunnable(this.adBQ);
      MMHandlerThread.postToMainThreadDelayed(this.adBQ, 2000L);
      AppMethodBeat.o(33308);
      return;
      label276:
      if (((String)localObject).equals("launch_type_offline_wallet"))
      {
        localObject = new rg();
        ((rg)localObject).iUz = 1L;
        ((rg)localObject).jvA = 2L;
        ((rg)localObject).bMH();
        localc = com.tencent.mm.util.c.agsX;
        com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject);
      }
      else if (((String)localObject).equals("launch_type_my_qrcode"))
      {
        localObject = new rg();
        ((rg)localObject).iUz = 3L;
        ((rg)localObject).jvA = 2L;
        ((rg)localObject).bMH();
        localc = com.tencent.mm.util.c.agsX;
        com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject);
      }
    }
    com.tencent.mm.model.z.bAY();
    if ((this.hPY != null) && ((this.hPY.getFlags() & 0x4000000) == 67108864)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = IntentUtil.getBooleanExtra(this.hPY, "Intro_Notify", false);
      Log.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", new Object[] { Boolean.valueOf(this.adBI), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(com.tencent.mm.model.bh.aZG()) });
      Log.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", new Object[] { Boolean.valueOf(com.tencent.mm.model.bh.bCA()) });
      com.tencent.mm.model.bh.aZH();
      if (IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
        this.adBK = true;
      }
      mJ(this);
      com.tencent.mm.model.bh.aZI();
      AppMethodBeat.o(33308);
      return;
    }
  }
  
  private void mJ(Context paramContext)
  {
    AppMethodBeat.i(33309);
    if (Log.getLogLevel() <= 1)
    {
      Log.d("MicroMsg.LauncherUI", "jumpToLogin() called with: KJumpSwitchAccount = %s", new Object[] { Boolean.valueOf(IntentUtil.getBooleanExtra(this.hPY, "LauncherUI.jump_switch_account", false)) });
      Log.d("MicroMsg.LauncherUI", "jumpToLogin() called with: KSwitch = %s, hasDoneCreateImp = %s, isKickOffline = %s", new Object[] { Boolean.valueOf(IntentUtil.getBooleanExtra(this.hPY, "Intro_Switch", false)), Boolean.valueOf(this.adBI), Boolean.valueOf(com.tencent.mm.kernel.b.aZv()) });
      Log.d("MicroMsg.LauncherUI", "jumpToLogin() called with: KJumpSwitchAccount = %s", new Object[] { Boolean.valueOf(IntentUtil.getBooleanExtra(this.hPY, "LauncherUI.jump_switch_account", false)) });
    }
    if (IntentUtil.getBooleanExtra(this.hPY, "LauncherUI.jump_switch_account", false))
    {
      Log.i("MicroMsg.LauncherUI", "launcher to switch account");
      jjq();
      AppMethodBeat.o(33309);
      return;
    }
    if ((IntentUtil.getBooleanExtra(this.hPY, "Intro_Switch", false)) || (this.adBI) || (com.tencent.mm.kernel.b.aZv()))
    {
      this.adBG.getMainTabUI().jkc();
      com.tencent.mm.kernel.h.baF().FB("[normal logout]");
      Mars.onSingalCrash(0);
      Log.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
      Log.appenderFlush();
      finish();
      Object localObject = new Intent(paramContext, LauncherUI.class);
      ((Intent)localObject).putExtra("key_errType", IntentUtil.getIntExtra(this.hPY, "key_errType", 0));
      ((Intent)localObject).putExtra("key_errCode", IntentUtil.getIntExtra(this.hPY, "key_errCode", 0));
      ((Intent)localObject).putExtra("key_errMsg", IntentUtil.getStringExtra(this.hPY, "key_errMsg"));
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      Log.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
      MMAppMgr.jjZ();
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramContext.aYi(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(33309);
      return;
    }
    if (!IntentUtil.getBooleanExtra(this.hPY, "LauncherUI.jump_switch_account", false))
    {
      paramContext = bg.okT.aM("login_user_name", "");
      Log.i("MicroMsg.LauncherUI", "%s jumpToLogin", new Object[] { paramContext });
      if (!Util.isNullOrNil(paramContext)) {
        break label637;
      }
      paramContext = new Intent(this, WelcomeActivity.class);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().cG(paramContext);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramContext.aYi(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.ng(this);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.ahy(8);
      MMHandlerThread.removeRunnable(this.adBQ);
      MMHandlerThread.postToMainThreadDelayed(this.adBQ, 2000L);
      AppMethodBeat.o(33309);
      return;
      label637:
      boolean bool = MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).getBoolean("last_logout_switch_account", false);
      Log.i("MicroMsg.LauncherUI", "switchAccount %s", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      paramContext = new Intent(this, SettingsSwitchAccountUI.class);
      paramContext.addFlags(536870912);
      paramContext.putExtra("key_scene", 2);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().cG(paramContext);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramContext.aYi(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.nd(this);
    }
    int i = Util.safeParseInt(bg.okT.aM("last_login_use_voice", ""));
    Log.i("MicroMsg.LauncherUI", "pluginSwitch  ".concat(String.valueOf(i)));
    paramContext = new Intent();
    paramContext.putExtra("key_errType", IntentUtil.getIntExtra(this.hPY, "key_errType", 0));
    paramContext.putExtra("key_errCode", IntentUtil.getIntExtra(this.hPY, "key_errCode", 0));
    paramContext.putExtra("key_errMsg", IntentUtil.getStringExtra(this.hPY, "key_errMsg"));
    if ((!WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned()) && ((i & 0x20000) != 0)) {
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginVoiceUI");
    }
    for (;;)
    {
      paramContext.addFlags(536870912);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().cG(paramContext);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramContext.aYi(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.nd(this);
      break;
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginPasswordUI");
    }
  }
  
  public static void mK(Context paramContext)
  {
    AppMethodBeat.i(33328);
    Object localObject = new Intent(paramContext, LauncherUI.class);
    ((Intent)localObject).addFlags(67108864);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33328);
  }
  
  public final void closeChatting(boolean paramBoolean)
  {
    AppMethodBeat.i(33330);
    new LauncherUI.5(this);
    if (this.chattingTabUI.Lq(paramBoolean))
    {
      this.adBG.Ld(this.chattingTabUI.adIL.isSupportCustomActionBar());
      this.adBG.getMainTabUI().jkk();
    }
    AppMethodBeat.o(33330);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int j = 5;
    AppMethodBeat.i(33319);
    boolean bool;
    if (this.chattingTabUI.glL())
    {
      localObject1 = this.chattingTabUI;
      if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
        MMHandlerThread.removeRunnable(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      }
      if (((NewChattingTabUI)localObject1).isAnimating) {}
      for (bool = true; bool; bool = ((NewChattingTabUI)localObject1).adIL.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent))
      {
        AppMethodBeat.o(33319);
        return true;
      }
    }
    Object localObject2;
    int i;
    if ((paramKeyEvent.getKeyCode() == 4) && (aw.isMultiTaskMode()))
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = (com.tencent.mm.plugin.multitask.ui.uic.c)com.tencent.mm.ui.component.k.d(this).q(com.tencent.mm.plugin.multitask.ui.uic.c.class);
      kotlin.g.b.s.u(paramKeyEvent, "event");
      if (paramKeyEvent.getKeyCode() == 4)
      {
        localObject2 = ((com.tencent.mm.plugin.multitask.ui.uic.c)localObject1).LHp;
        if ((localObject2 != null) && (((com.tencent.mm.plugin.multitask.ui.panel.b)localObject2).onKeyDown(4, paramKeyEvent) == true))
        {
          i = 1;
          if (i == 0) {
            break label186;
          }
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label219;
        }
        AppMethodBeat.o(33319);
        return true;
        i = 0;
        break;
        label186:
        if (((com.tencent.mm.plugin.multitask.ui.uic.c)localObject1).gkZ())
        {
          com.tencent.mm.plugin.multitask.ui.uic.c.a((com.tencent.mm.plugin.multitask.ui.uic.c)localObject1, true, true, false, false, true, false, false, 224);
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
    label219:
    Object localObject1 = this.adBG;
    Log.i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    if ((com.tencent.mm.compatible.b.g.aOg()) && (paramKeyEvent.getKeyCode() == 25) && (paramKeyEvent.getAction() == 0) && (com.tencent.mm.model.bh.baz())) {
      if (com.tencent.mm.aw.a.bLk())
      {
        i = 3;
        com.tencent.mm.plugin.audio.c.a.EZ(i);
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label828;
      }
      AppMethodBeat.o(33319);
      return true;
      i = 5;
      break;
      if ((com.tencent.mm.compatible.b.g.aOg()) && (paramKeyEvent.getKeyCode() == 24) && (paramKeyEvent.getAction() == 0) && (com.tencent.mm.model.bh.baz()))
      {
        i = j;
        if (com.tencent.mm.aw.a.bLk()) {
          i = 3;
        }
        com.tencent.mm.plugin.audio.c.a.EY(i);
        i = 1;
      }
      else if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (((HomeUI)localObject1).adAq != null) && (((HomeUI)localObject1).adAq.isShowing()))
      {
        ((HomeUI)localObject1).adAq.dismiss();
        i = 1;
      }
      else if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
      {
        ((HomeUI)localObject1).jiN();
        i = 1;
      }
      else
      {
        localObject2 = ((HomeUI)localObject1).adAC.jkb();
        if ((localObject2 != null) && (((MMFragment)localObject2).onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
        {
          i = 1;
        }
        else if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
        {
          if ((com.tencent.mm.model.bh.baz()) && (com.tencent.mm.kernel.h.baC().mBZ) && (NetworkCache.INSTANCE.isWapFromCache(((HomeUI)localObject1).EzS)))
          {
            Object localObject3 = ((HomeUI)localObject1).EzS;
            localObject2 = new HomeUI.23((HomeUI)localObject1);
            if (!com.tencent.mm.model.bh.baz()) {
              i = 0;
            }
            for (;;)
            {
              if (i == 0) {
                break label728;
              }
              i = 1;
              break;
              com.tencent.mm.model.bh.bCz();
              i = ((Integer)com.tencent.mm.model.c.ban().d(65, Integer.valueOf(0))).intValue();
              if (i >= 5)
              {
                i = 0;
              }
              else if (!MMEntryLock.lock("show_wap_adviser"))
              {
                i = 0;
              }
              else
              {
                View localView = View.inflate((Context)localObject3, R.i.gmx, null);
                ((TextView)localView.findViewById(R.h.network_tips_content)).setText(R.l.gOD);
                localObject3 = new e.a((Context)localObject3);
                ((e.a)localObject3).aEK(R.l.app_tip);
                ((e.a)localObject3).md(localView);
                ((e.a)localObject3).aER(R.l.app_ok).c(new MMAppMgr.1(i));
                ((e.a)localObject3).NC(false);
                ((e.a)localObject3).aES(R.l.gOy).d(new MMAppMgr.7());
                ((e.a)localObject3).c(new MMAppMgr.8((DialogInterface.OnClickListener)localObject2));
                ((e.a)localObject3).jHH().show();
                i = 1;
              }
            }
          }
          label728:
          i = NetStatusUtil.getBackgroundLimitType(((HomeUI)localObject1).EzS);
          if ((com.tencent.mm.model.bh.baz()) && (com.tencent.mm.kernel.h.baC().mBZ) && (NetStatusUtil.isLimited(i)))
          {
            com.tencent.mm.model.bh.bCz();
            if ((Util.nullAsTrue((Boolean)com.tencent.mm.model.c.ban().d(16385, null))) && (MMAppMgr.a(((HomeUI)localObject1).EzS, i, new HomeUI.26((HomeUI)localObject1, i), new HomeUI.27((HomeUI)localObject1))))
            {
              i = 1;
              continue;
            }
          }
          ((HomeUI)localObject1).jhu();
        }
        else
        {
          i = 0;
        }
      }
    }
    try
    {
      label828:
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
    jjm();
    Log.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(adBA.size()), Util.getStack() });
    AppMethodBeat.o(33316);
  }
  
  public boolean forceRemoveNoMatchOnPath()
  {
    AppMethodBeat.i(249669);
    boolean bool = NewChattingTabUI.forceRemoveNoMatchOnPath();
    AppMethodBeat.o(249669);
    return bool;
  }
  
  public MMFragment getCurrentFragmet()
  {
    AppMethodBeat.i(33327);
    Object localObject1 = this.chattingTabUI;
    if (!((NewChattingTabUI)localObject1).mChattingClosed) {}
    for (localObject1 = ((NewChattingTabUI)localObject1).adIL;; localObject1 = null)
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
    return this.adBG;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str1 = null;
    Object localObject1 = null;
    AppMethodBeat.i(33310);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.v("MicroMsg.LauncherUI", "edw on activity result");
    Object localObject2 = this.chattingTabUI;
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 226) || (paramInt1 == 3001) || (paramInt1 == 30762) || (paramInt1 == 1111)) && (((NewChattingTabUI)localObject2).adIL != null)) {
      ((NewChattingTabUI)localObject2).adIL.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((NewChattingTabUI.acceptRequestCode(paramInt1)) && (((NewChattingTabUI)localObject2).adIL == null))
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
      MMHandlerThread.removeRunnable(((NewChattingTabUI)localObject2).adIN);
      ((NewChattingTabUI)localObject2).adIN.adIW = 0;
      ((NewChattingTabUI)localObject2).adIN.hPm = paramInt1;
      ((NewChattingTabUI)localObject2).adIN.resultCode = paramInt2;
      ((NewChattingTabUI)localObject2).adIN.hPn = paramIntent;
      MMHandlerThread.postToMainThread(((NewChattingTabUI)localObject2).adIN);
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(33310);
      return;
    }
    localObject2 = this.adBG;
    if ((((HomeUI)localObject2).adAk) && (paramInt1 != 1))
    {
      if (paramInt1 == 22722)
      {
        str1 = (String)com.tencent.mm.kernel.h.baE().ban().d(274436, null);
        Log.i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
        if (paramIntent != null) {
          localObject1 = paramIntent.getBundleExtra("result_data");
        }
        if ((localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("agree_privacy")))
        {
          Log.i("MicroMsg.LauncherUI.HomeUI", "agree privacy policy");
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(712L, 4L, 1L, false);
          localObject1 = new com.tencent.mm.plugin.account.bind.a.c(1, str1);
          com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
          if ((com.tencent.mm.au.b.OE(str1)) && (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acWu, false)))
          {
            Log.i("MicroMsg.LauncherUI.HomeUI", "needbirthday true");
            MMHandlerThread.postToMainThreadDelayed(new HomeUI.29((HomeUI)localObject2), 100L);
          }
        }
      }
      while ((paramInt1 == 65534) && (paramInt2 == -1))
      {
        MMEntryLock.unlock("welcome_page_show");
        n.w(((HomeUI)localObject2).EzS, true);
        MMAppMgr.aDA();
        MMAppMgr.o(((HomeUI)localObject2).EzS, true);
        ((HomeUI)localObject2).EzS.finish();
        AppMethodBeat.o(33310);
        return;
        Log.i("MicroMsg.LauncherUI.HomeUI", "disagree privacy policy");
        localObject1 = new com.tencent.mm.plugin.account.bind.a.c(2, str1);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(712L, 5L, 1L, false);
        continue;
        if (paramInt1 == 22723)
        {
          String str2 = (String)com.tencent.mm.kernel.h.baE().ban().d(274436, null);
          localObject1 = str1;
          if (paramIntent != null) {
            localObject1 = paramIntent.getBundleExtra("result_data");
          }
          if (localObject1 != null) {
            if (((Bundle)localObject1).getString("go_next", "").equals("birthdayComfirmOK"))
            {
              Log.i("MicroMsg.LauncherUI.HomeUI", "verify birthday ok");
              com.tencent.mm.kernel.h.baE().ban().set(at.a.acWu, Boolean.FALSE);
            }
            else if (((Bundle)localObject1).getString("go_next", "").equals("gdpr_confirm_logout"))
            {
              Log.i("MicroMsg.LauncherUI.HomeUI", "quit verify birthday after H5-warnning");
              localObject1 = new com.tencent.mm.plugin.account.bind.a.c(2, str2);
              com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(712L, 5L, 1L, false);
            }
          }
        }
      }
      if ((paramInt1 == 30764) && (paramIntent != null))
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acXn, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b(((HomeUI)localObject2).EzS, "android.permission.ACCESS_FINE_LOCATION", 66);
        }
      }
    }
    AppMethodBeat.o(33310);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(33320);
    Log.i("MicroMsg.LauncherUI", "onBackPressed");
    this.adBG.jiU();
    AppMethodBeat.o(33320);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(33325);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.adBG;
    com.tencent.mm.pluginsdk.h.a(paramConfiguration.EzS, paramConfiguration.contentView);
    AppMethodBeat.o(33325);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33299);
    com.tencent.mm.blink.a.ha(com.tencent.mm.kernel.i.baI().mDH);
    if (aw.isDarkMode()) {
      setTheme(R.m.AppTheme_DarkMode);
    }
    long l1;
    long l2;
    int i;
    boolean bool1;
    for (;;)
    {
      com.tencent.mm.kernel.h.b(com.tencent.mm.ui.l.a.class, new d());
      l1 = System.currentTimeMillis();
      Log.i("MicroMsg.LauncherUI", "start time check checktask onCreate 0x%x, taskid %d, task:%s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), Util.getActivityTaskInfo(this) });
      super.onCreate(paramBundle);
      MainProcessChecker.aRB(getClass().getName());
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
      paramBundle = adBB.iterator();
      while (paramBundle.hasNext())
      {
        localObject1 = (LauncherUI)((WeakReference)paramBundle.next()).get();
        if (localObject1 != null) {
          Log.i("MicroMsg.LauncherUI", "Check launcher instance found one %s", new Object[] { localObject1 });
        }
      }
      setTheme(R.m.AppTheme_LightMode);
    }
    Object localObject1 = null;
    paramBundle = null;
    Object localObject3;
    if (!bool1)
    {
      localObject3 = adBA.iterator();
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
              break label602;
            }
            Log.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + paramBundle.baseActivity.getPackageName());
            finish();
            if (Util.getCurrentTaskInfo(this, ((LauncherUI)localObject1).getTaskId()) != null)
            {
              Log.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
              paramBundle = new Intent(this, LauncherUI.class);
              paramBundle.addFlags(268435456);
              paramBundle = new com.tencent.mm.hellhoundlib.b.a().cG(paramBundle);
              com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aYi(), "com/tencent/mm/ui/LauncherUI", "checkInstance", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramBundle.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "checkInstance", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
        label602:
        ((LauncherUI)localObject1).finish();
        adBA.remove(localObject1);
        break;
        if (!adBA.isEmpty())
        {
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = Util.getCurrentTaskInfo(this, i);
          }
          if (paramBundle == null) {
            break label900;
          }
          localObject1 = paramBundle.baseActivity.getClassName();
          localObject2 = paramBundle.baseActivity.getClassName();
          Log.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), localObject2, localObject1, Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
          localObject3 = getComponentName().getClassName();
          if ((paramBundle.numActivities > 1) && (((String)localObject3).equals(localObject1)) && (((String)localObject3).equals(localObject2)))
          {
            finish();
            Log.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(adBA.size()) });
            i = 0;
            continue;
          }
          Log.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", new Object[] { Integer.valueOf(adBA.size()), Boolean.valueOf(bool1) });
          adBA.clear();
        }
        for (;;)
        {
          adBA.add(this);
          adBB.add(new WeakReference(this));
          Log.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d weak check %d, use time %d", new Object[] { Integer.valueOf(adBA.size()), Integer.valueOf(adBB.size()), Long.valueOf(System.currentTimeMillis() - l2) });
          i = 1;
          break;
          label900:
          Log.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(adBA.size()) });
          adBA.clear();
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
    this.adBG = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.adBG);
    this.chattingTabUI.PIA = this;
    paramBundle = this.adBG;
    localObject1 = this.chattingTabUI;
    paramBundle.EzS = this;
    paramBundle.adAA = ((a)localObject1);
    localObject1 = paramBundle.adAC;
    ((MainTabUI)localObject1).EzS = this;
    ((MainTabUI)localObject1).adGS = paramBundle;
    Object localObject2 = ((MainTabUI)localObject1).adGR;
    ((ah)localObject2).EzS = this;
    ((ah)localObject2).adHh = paramBundle;
    ((ah)localObject2).adHi = new com.tencent.mm.plugin.finder.extension.reddot.k();
    ((MainTabUI)localObject1).SQU = paramBundle;
    paramBundle.adAB = new j(this, paramBundle);
    NotifyReceiver.aKx();
    com.tencent.mm.pluginsdk.h.bE(paramBundle.EzS);
    paramBundle.mActionBar = getSupportActionBar();
    paramBundle.Inv = findViewById(R.h.action_bar_container);
    if (paramBundle.mActionBar != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.actionbar_bg_color)));
      }
      paramBundle.mActionBar.hide();
    }
    setRequestedOrientation(1);
    paramBundle.adAD = getResources().getColor(R.e.normal_actionbar_color);
    paramBundle.adAE = Color.alpha(paramBundle.adAD);
    paramBundle = bg.okT.aM("login_user_name", "");
    this.hPY = getIntent();
    localObject1 = this.adBM;
    ((com.tencent.mm.pluginsdk.u)localObject1).XOa = this.hPY.getBooleanExtra("splash-hack-activity-recreate", false);
    Log.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", new Object[] { ((com.tencent.mm.pluginsdk.u)localObject1).mTag, Boolean.valueOf(((com.tencent.mm.pluginsdk.u)localObject1).XOa) });
    Log.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", new Object[] { paramBundle, Boolean.valueOf(com.tencent.mm.model.bh.bCA()), Boolean.valueOf(adBC) });
    if (jjp())
    {
      Log.i("MicroMsg.LauncherUI", "handleExitIntent return");
      AppMethodBeat.o(33299);
      return;
    }
    if ((!adBC) && ((com.tencent.mm.model.bh.bCA()) || (!paramBundle.equals(""))))
    {
      adBD = l1;
      Log.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.e.hfJ));
    }
    label1634:
    for (;;)
    {
      com.tencent.mm.pluginsdk.model.app.u.q(this, "");
      jjn();
      aw.bx(this);
      com.tencent.mm.plugin.ae.a.c.gxP().gxO();
      this.adBF.alive();
      AppMethodBeat.o(33299);
      return;
      adBD = l1;
      Log.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.e.hfJ));
      setRequestedOrientation(1);
      bool1 = com.tencent.mm.model.bh.bCA();
      paramBundle = bg.okT.aM("login_user_name", "");
      if ((!bool1) && (paramBundle.equals(""))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1528;
        }
        ChannelUtil.isShowingGprsAlert = false;
        break;
      }
      label1528:
      bool1 = false;
      if ((ChannelUtil.shouldShowGprsAlert) && (ChannelUtil.isShowingGprsAlert))
      {
        adBE = true;
        bool1 = MMAppMgr.a(this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(249603);
            LauncherUI.a(LauncherUI.this);
            LauncherUI.bDd();
            com.tencent.mm.pluginsdk.res.downloader.checkresupdate.o.cZW();
            LauncherUI.b(LauncherUI.this);
            AppMethodBeat.o(249603);
          }
        });
      }
      for (;;)
      {
        if (bool1) {
          break label1634;
        }
        Lg(true);
        adBE = false;
        com.tencent.mm.pluginsdk.res.downloader.checkresupdate.o.cZW();
        com.tencent.mm.plugin.report.service.g.ahy(8);
        jjr();
        Log.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        MMHandlerThread.removeRunnable(this.adBQ);
        MMHandlerThread.postToMainThreadDelayed(this.adBQ, 2000L);
        break;
        MMAppMgr.mS(this);
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(33324);
    if (this.chattingTabUI.glL())
    {
      AppMethodBeat.o(33324);
      return false;
    }
    HomeUI localHomeUI = this.adBG;
    if ((localHomeUI.adAA == null) || (localHomeUI.adAA.glL()))
    {
      if (localHomeUI.adAA == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.LauncherUI.HomeUI", "unCreateOptionsMenu, %b, %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localHomeUI.adAA.glL()) });
        AppMethodBeat.o(33324);
        return false;
      }
    }
    localHomeUI.adAV = paramMenu;
    int i = localHomeUI.EzS.getSupportActionBar().getHeight();
    int j = com.tencent.mm.cd.a.bs(localHomeUI.EzS, R.f.Edge_6A);
    if ((localHomeUI.adAC.jP == 3) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()) && (!ac.hFS()) && ((!aw.jkS()) || (!aw.jkZ())))
    {
      localHomeUI.adAU = paramMenu.add(0, 5, 0, R.l.top_item_desc_send_story);
      if (localHomeUI.adAQ == null)
      {
        com.tencent.mm.kiss.layout.b.bbG();
        localHomeUI.adAQ = com.tencent.mm.kiss.layout.b.d(localHomeUI.EzS, R.i.actionview_with_dot_tips);
        paramMenu = new ViewGroup.LayoutParams(j, i);
        localHomeUI.adAQ.setLayoutParams(paramMenu);
        localHomeUI.adAQ.setMinimumHeight(i);
        localHomeUI.adAQ.setMinimumWidth(j);
        localHomeUI.adAQ.setOnLongClickListener(new HomeUI.7(localHomeUI));
        localHomeUI.adAQ.setOnClickListener(new HomeUI.8(localHomeUI));
        localHomeUI.adAQ.setContentDescription(localHomeUI.getString(R.l.top_item_desc_send_story));
      }
      if (localHomeUI.adAG)
      {
        localHomeUI.adAQ.findViewById(R.h.tips).setVisibility(0);
        paramMenu = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.vW(1L);
      }
      for (;;)
      {
        localHomeUI.adAU.setActionView(localHomeUI.adAQ);
        localHomeUI.jiZ();
        localHomeUI.jiO();
        Log.v("MicroMsg.LauncherUI.HomeUI", "onCreateOptionsMenu");
        AppMethodBeat.o(33324);
        return true;
        localHomeUI.adAQ.findViewById(R.h.tips).setVisibility(8);
        paramMenu = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.vW(0L);
      }
    }
    Object localObject;
    if (i == 0)
    {
      localObject = localHomeUI.EzS.getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels) {
        i = localHomeUI.EzS.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
      }
    }
    for (;;)
    {
      localHomeUI.adAR = paramMenu.add(0, HomeUI.adAJ, 0, R.l.top_item_desc_search);
      localHomeUI.adAR.setIcon(bb.e(localHomeUI.EzS.getResources().getDrawable(R.k.actionbar_icon_dark_search), localHomeUI.EzS.getResources().getColor(R.e.FG_0)));
      if (localHomeUI.advd) {
        localHomeUI.adAR.setIcon(R.k.actionbar_icon_light_search);
      }
      if (localHomeUI.advt == null)
      {
        localObject = new ViewGroup.LayoutParams(j, i);
        com.tencent.mm.kiss.layout.b.bbG();
        localHomeUI.advt = com.tencent.mm.kiss.layout.b.d(localHomeUI.EzS, R.i.actionbar_option_menu_left);
        localHomeUI.adAP = ((ImageView)localHomeUI.advt.findViewById(R.h.icon));
        localHomeUI.advt.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localHomeUI.advt.setMinimumHeight(i);
        localHomeUI.advt.setMinimumWidth(j);
        localHomeUI.adAP.setImageDrawable(bb.e(localHomeUI.EzS.getResources().getDrawable(R.k.actionbar_icon_dark_search), localHomeUI.EzS.getResources().getColor(R.e.FG_0)));
        localHomeUI.advt.setContentDescription(localHomeUI.getString(R.l.top_item_desc_search));
        localHomeUI.advt.setOnLongClickListener(new HomeUI.9(localHomeUI));
        localHomeUI.advt.setOnClickListener(new HomeUI.10(localHomeUI));
        localHomeUI.advt.post(new HomeUI.12(localHomeUI));
      }
      localHomeUI.adAR.setActionView(localHomeUI.advt);
      localHomeUI.adAS = paramMenu.add(0, HomeUI.adAK, 0, R.l.top_item_desc_more);
      if (localHomeUI.adAM == null) {
        localHomeUI.adAL = new HomeUI.b(localHomeUI, j, i);
      }
      if (com.tencent.mm.kernel.h.baC().aZN()) {
        com.tencent.mm.plugin.newtips.a.gtf().h(localHomeUI.adAL);
      }
      if ((localHomeUI.advd) && (localHomeUI.adAN != null)) {
        localHomeUI.adAN.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      com.tencent.mm.blink.b.aJY().arrange(new HomeUI.13(localHomeUI));
      localHomeUI.adAS.setActionView(localHomeUI.adAM);
      localHomeUI.jiO();
      localHomeUI.adAM.getLayoutParams().width = j;
      localHomeUI.adAM.getLayoutParams().height = i;
      break;
      i = localHomeUI.EzS.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33314);
    com.tencent.mm.blink.a.aJT();
    super.onDestroy();
    Object localObject = this.adBG;
    ((HomeUI)localObject).adAC.jkc();
    if (((HomeUI)localObject).adAB != null)
    {
      j localj = ((HomeUI)localObject).adAB;
      localj.adzU.dead();
      localj.adzV.dead();
    }
    if (((HomeUI)localObject).adAk) {
      Looper.myQueue().removeIdleHandler(((HomeUI)localObject).fgm);
    }
    ((HomeUI)localObject).adAX.dead();
    localObject = this.chattingTabUI;
    if ((((NewChattingTabUI)localObject).mPrepareBitmap != null) && (!((NewChattingTabUI)localObject).mPrepareBitmap.isRecycled()))
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", new Object[] { ((NewChattingTabUI)localObject).mPrepareBitmap.toString() });
      ((NewChattingTabUI)localObject).mPrepareBitmap.recycle();
    }
    MMHandlerThread.removeRunnable(((NewChattingTabUI)localObject).mStartChattingRunnable);
    Looper.myQueue().removeIdleHandler(((NewChattingTabUI)localObject).adIG);
    if (this.adBL != null)
    {
      localObject = this.adBL;
      Log.i("MicroMsg.HKOfflineLogic", "doOnDestroy");
      ((com.tencent.mm.plugin.wallet_index.model.b)localObject).mContext = null;
      ((com.tencent.mm.plugin.wallet_index.model.b)localObject).pIx = null;
      ((com.tencent.mm.plugin.wallet_index.model.b)localObject).Wai = false;
      ((com.tencent.mm.plugin.wallet_index.model.b)localObject).Waj = null;
      com.tencent.mm.kernel.h.aZW().b(2540, (com.tencent.mm.am.h)localObject);
      this.adBL = null;
    }
    this.adBF.dead();
    jjm();
    Log.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), Util.getActivityTaskInfo(this), Integer.valueOf(adBA.size()) });
    AppMethodBeat.o(33314);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(33331);
    super.onMultiWindowModeChanged(paramBoolean);
    Log.i("MicroMsg.LauncherUI", "alvinluo onMultiWindowModeChanged2 isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ou localou = new ou();
    localou.hRC.hRD = paramBoolean;
    localou.publish();
    AppMethodBeat.o(33331);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(33301);
    Log.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", new Object[] { Integer.valueOf(hashCode()), Util.getActivityTaskInfo(this) });
    this.hPY = paramIntent;
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    Object localObject = (com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class);
    if (("android.intent.action.MAIN".equals(paramIntent.getAction())) && (localObject != null) && (((com.tencent.mm.plugin.l)localObject).E(this)))
    {
      AppMethodBeat.o(33301);
      return;
    }
    if ((this.hPY != null) && (IntentUtil.getBooleanExtra(this.hPY, "LauncherUI.jump_from_uimode_check", false)))
    {
      Log.i("MicroMsg.LauncherUI", "dancy onNewIntent uimode check from background, finish LauncherUI");
      finish();
      AppMethodBeat.o(33301);
      return;
    }
    if ((localObject != null) && ("new_msg_nofification".equals(paramIntent.getStringExtra("nofification_type")))) {
      ((com.tencent.mm.plugin.l)localObject).bUV();
    }
    com.tencent.mm.pluginsdk.model.app.u.q(this, "");
    if (jjp())
    {
      Log.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
      AppMethodBeat.o(33301);
      return;
    }
    if ((this.hPY != null) && (IntentUtil.getBooleanExtra(this.hPY, "Intro_Need_Clear_Top ", false)))
    {
      Log.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
      finish();
      mK(this);
      AppMethodBeat.o(33301);
      return;
    }
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      closeChatting(false);
    }
    localObject = this.adBG.adAC;
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      ((MainTabUI)localObject).adGT = true;
    }
    if (this.adBI)
    {
      Log.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
      cd(paramIntent);
    }
    com.tencent.mm.plugin.ae.a.c.gxP().gxO();
    AppMethodBeat.o(33301);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int j = 0;
    AppMethodBeat.i(33323);
    HomeUI localHomeUI = this.adBG;
    Object localObject = localHomeUI.EzS.getCurrentFragmet();
    int i;
    if ((localObject != null) && (((MMFragment)localObject).isShowing())) {
      i = j;
    }
    while (i != 0)
    {
      AppMethodBeat.o(33323);
      return true;
      i = j;
      if (!localHomeUI.adAA.glL())
      {
        if (paramMenuItem.getItemId() == HomeUI.adAK)
        {
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10919, "0");
          localHomeUI.jiN();
        }
        for (;;)
        {
          i = 1;
          break;
          if (paramMenuItem.getItemId() == HomeUI.adAJ)
          {
            localHomeUI.jiP();
          }
          else
          {
            i = j;
            if (paramMenuItem.getItemId() != 5) {
              break;
            }
            if ((CrashReportFactory.hasDebuger()) || (com.tencent.mm.platformtools.z.pDk))
            {
              localObject = new com.tencent.mm.ui.tools.l(localHomeUI.EzS);
              ((com.tencent.mm.ui.tools.l)localObject).Vtg = new HomeUI.14(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).GAC = new HomeUI.15(localHomeUI);
              ((com.tencent.mm.ui.tools.l)localObject).jDd();
            }
            else
            {
              localHomeUI.jiQ();
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
    Object localObject = (com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class);
    if (localObject != null) {
      ((com.tencent.mm.plugin.l)localObject).bUU();
    }
    localObject = this.adBM;
    boolean bool = ((com.tencent.mm.pluginsdk.u)localObject).hZ("onPause");
    if (bool) {
      ((com.tencent.mm.pluginsdk.u)localObject).XOa = false;
    }
    if (bool)
    {
      Log.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
      AppMethodBeat.o(33311);
      return;
    }
    com.tencent.mm.blink.a.aJT();
    Log.i("MicroMsg.LauncherUI", "not skip this onPause");
    localObject = getCurrentFragmet();
    this.adBP.removeCallbacksAndMessages(null);
    if (!aw.jkS())
    {
      this.adBG.hdx();
      this.chattingTabUI.hdx();
    }
    if (localObject != null)
    {
      AppMethodBeat.o(33311);
      return;
    }
    this.adBJ = false;
    localObject = com.tencent.mm.storage.r.acDM;
    com.tencent.mm.storage.r.emm();
    AppMethodBeat.o(33311);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(33313);
    this.adBO = false;
    Object localObject;
    if (!this.adBH.a(this, paramInt, paramArrayOfString, paramArrayOfInt))
    {
      localObject = this.adBG;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      localObject = this.chattingTabUI;
      if (((NewChattingTabUI)localObject).adIL != null) {
        ((NewChattingTabUI)localObject).adIL.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(33313);
      return;
      if (paramInt == 80) {}
      for (int i = R.l.permission_microphone_request_again_msg; paramArrayOfInt[0] != 0; i = R.l.permission_camera_request_again_msg)
      {
        com.tencent.mm.ui.base.k.a(((HomeUI)localObject).EzS, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(R.l.permission_tips_title), ((HomeUI)localObject).getString(R.l.jump_to_settings), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.30((HomeUI)localObject), new HomeUI.31((HomeUI)localObject));
        break;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ((HomeUI)localObject).jiP();
      }
      else
      {
        com.tencent.mm.ui.base.k.a(((HomeUI)localObject).EzS, ((HomeUI)localObject).getString(R.l.permission_location_request_again_msg), ((HomeUI)localObject).getString(R.l.permission_tips_title), ((HomeUI)localObject).getString(R.l.jump_to_settings), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.32((HomeUI)localObject), null);
        continue;
        if (paramArrayOfInt[0] == 0)
        {
          localObject = ((HomeUI)localObject).adAC.jkb();
          if ((localObject instanceof FindMoreFriendsUI)) {
            ((FindMoreFriendsUI)localObject).jiq();
          }
        }
        else
        {
          com.tencent.mm.ui.base.k.a(((HomeUI)localObject).EzS, ((HomeUI)localObject).getString(R.l.permission_location_request_again_msg), ((HomeUI)localObject).getString(R.l.permission_tips_title), ((HomeUI)localObject).getString(R.l.jump_to_settings), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.34((HomeUI)localObject), null);
          continue;
          if (paramArrayOfInt[0] == 0)
          {
            ((HomeUI)localObject).jiQ();
          }
          else
          {
            if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
            for (i = R.l.permission_camera_request_again_msg;; i = R.l.permission_microphone_request_again_msg)
            {
              com.tencent.mm.ui.base.k.a(((HomeUI)localObject).EzS, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(R.l.permission_tips_title), ((HomeUI)localObject).getString(R.l.jump_to_settings), ((HomeUI)localObject).getString(R.l.app_cancel), false, new HomeUI.35((HomeUI)localObject), new HomeUI.36((HomeUI)localObject));
              break;
            }
            if (paramArrayOfInt[0] == 0) {
              ((HomeUI)localObject).jiQ();
            } else {
              com.tencent.mm.ui.base.k.a(((HomeUI)localObject).EzS, ((HomeUI)localObject).getString(R.l.permission_location_request_again_msg), ((HomeUI)localObject).getString(R.l.permission_tips_title), ((HomeUI)localObject).getString(R.l.jump_to_settings), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.37((HomeUI)localObject), null);
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
    localNewChattingTabUI.adII = paramBundle.getString("last_restore_talker");
    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", new Object[] { localNewChattingTabUI.adII });
    this.adBR = paramBundle.getBoolean("last_stay_chatting");
    this.adBS = paramBundle.getInt("last_stay_tab");
    if (this.adBR) {
      this.chattingTabUI.startChatting(this.chattingTabUI.adII, null, false);
    }
    AppMethodBeat.o(33321);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33303);
    Log.i("MicroMsg.LauncherUI", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    super.onResume();
    if (this.adBM.hZ("onResume"))
    {
      Log.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
      AppMethodBeat.o(33303);
      return;
    }
    Log.i("MicroMsg.LauncherUI", "not skip this onResume");
    adBC = false;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    long l1;
    Object localObject4;
    Object localObject5;
    label837:
    int i;
    Object localObject6;
    long l2;
    if (jjo())
    {
      Log.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", new Object[] { Boolean.valueOf(this.adBI) });
      if (!com.tencent.mm.model.bh.baz())
      {
        Log.w("MicroMsg.LauncherUI", "accHasNotReady, kill self");
        finish();
        Log.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/LauncherUI", "onResume", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/LauncherUI", "onResume", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(33303);
        return;
      }
      if (!this.adBI)
      {
        this.adBI = true;
        localObject1 = this.adBG;
        Log.i("MicroMsg.LauncherUI.HomeUI", "doOnCreate");
        if ((HomeUI.jja()) && (HomeUI.jjb()))
        {
          bool1 = true;
          ((HomeUI)localObject1).adAG = bool1;
          localObject2 = ((HomeUI)localObject1).adAB;
          ((j)localObject2).adzU.alive();
          ((j)localObject2).adzV.alive();
          if (!com.tencent.mm.ui.conversation.b.jzR()) {
            getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
          }
          localObject2 = ((HomeUI)localObject1).EzS.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aQe());
          if (((SharedPreferences)localObject2).getBoolean("first_launch_weixin", true))
          {
            ((SharedPreferences)localObject2).edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
          }
          ((HomeUI)localObject1).adAq = new al(this);
          ((HomeUI)localObject1).adAk = true;
          NotifyReceiver.aKz();
          com.tencent.mm.model.bh.getNotification().qh(1);
          if (com.tencent.mm.model.bh.baz()) {
            break label2881;
          }
          Log.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
          ((HomeUI)localObject1).EzS.finish();
          cd(getIntent());
        }
      }
      else
      {
        localObject1 = this.adBG;
        l1 = Util.nowMilliSecond();
        localObject2 = ((HomeUI)localObject1).adAC;
        bool1 = ((HomeUI)localObject1).adAA.glL();
        Log.i("MicroMsg.LauncherUI.MainTabUI", "onResume start :%d, chattingShow:%s", new Object[] { Integer.valueOf(((MainTabUI)localObject2).jP), Boolean.valueOf(bool1) });
        if (((MainTabUI)localObject2).adHf.size() != 0)
        {
          localObject4 = ((MainTabUI)localObject2).aAt(((MainTabUI)localObject2).jP);
          Log.i("MicroMsg.LauncherUI.MainTabUI", "notifyCurrentTabResumeUI, mCurIndex:%s", new Object[] { Integer.valueOf(((MainTabUI)localObject2).jP) });
          if (localObject4 != null) {
            ((p)localObject4).jhx();
          }
          if ((localObject4 != null) && (com.tencent.matrix.c.isInstalled()) && (((MMFragment)localObject4).getActivity() != null))
          {
            localObject5 = ((MMFragment)localObject4).getActivity().getClass().getName();
            com.tencent.matrix.a.eLw.gf((String)localObject5 + "#" + localObject4.getClass().getSimpleName());
          }
        }
        if ((((MainTabUI)localObject2).adGT) && (((MainTabUI)localObject2).EzS.getIntent().hasExtra("isScrollFirst")) && (((MainTabUI)localObject2).EzS.getIntent().hasExtra("isShowHeader")))
        {
          localObject4 = (MainUI)((MainTabUI)localObject2).adHf.get(Integer.valueOf(0));
          if (localObject4 != null)
          {
            bool2 = ((MainTabUI)localObject2).EzS.getIntent().getBooleanExtra("isShowHeader", false);
            boolean bool3 = ((MainTabUI)localObject2).EzS.getIntent().getBooleanExtra("isScrollFirst", true);
            ((MainUI)localObject4).s(bool2, ((MainTabUI)localObject2).EzS.getIntent().getBooleanExtra("isShowHeaderWithAnim", false), bool3);
          }
        }
        if (((MainTabUI)localObject2).adGT)
        {
          ((MainTabUI)localObject2).adGT = false;
          ((MainTabUI)localObject2).bzP("tab_main");
        }
        localObject4 = (MainUI)((MainTabUI)localObject2).adHf.get(Integer.valueOf(0));
        if (localObject4 != null)
        {
          ((MainUI)localObject4).jxZ();
          ((MainUI)localObject4).jAK();
        }
        if ((((MainTabUI)localObject2).jP != 0) || (bool1)) {
          break label3961;
        }
        com.tencent.mm.model.bh.getNotification().et(true);
        localObject4 = (p)((MainTabUI)localObject2).aAt(((MainTabUI)localObject2).jP);
        if (localObject4 != null) {
          ((p)localObject4).jhy();
        }
        ((MainTabUI)localObject2).adGT = false;
        i = IntentUtil.getIntExtra(((MainTabUI)localObject2).EzS.getIntent(), "preferred_tab", 0);
        Log.d("MicroMsg.LauncherUI.MainTabUI", "doOnResume, tabIdx = %d", new Object[] { Integer.valueOf(i) });
        if (i != 0)
        {
          ((MainTabUI)localObject2).aAs(i);
          ((MainTabUI)localObject2).EzS.getIntent().putExtra("preferred_tab", 0);
        }
        ((MainTabUI)localObject2).adGZ.alive();
        ((MainTabUI)localObject2).adHb.alive();
        ((MainTabUI)localObject2).adHc.alive();
        localObject4 = ((MainTabUI)localObject2).adGR;
        if (((ah)localObject4).adHj != null) {
          ((ah)localObject4).adHj.jhJ();
        }
        if (com.tencent.mm.model.bh.baz())
        {
          com.tencent.mm.model.bh.bCz();
          com.tencent.mm.model.c.ban().add(((ah)localObject4).adHp);
          com.tencent.mm.aa.c.aYo().a(((ah)localObject4).adHo);
          com.tencent.mm.model.bh.bCz();
          com.tencent.mm.model.c.bzG().add((MStorageEx.IOnStorageChange)localObject4);
          ((ah)localObject4).adyq.alive();
          ((ah)localObject4).adHq.alive();
          ((ah)localObject4).adyp.alive();
        }
        if (((ah)localObject4).adHi != null)
        {
          ((ah)localObject4).adHi.DWR.alive();
          localObject5 = com.tencent.mm.plugin.finder.extension.reddot.l.ARA;
          com.tencent.mm.plugin.finder.extension.reddot.l.avu("Discovery");
        }
        com.tencent.mm.blink.b.aJY().arrange(new ah.5((ah)localObject4));
        if (!((MainTabUI)localObject2).adHd)
        {
          localObject4 = (com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class);
          if (localObject4 != null) {
            ((com.tencent.mm.plugin.l)localObject4).R(((MainTabUI)localObject2).EzS, 1);
          }
        }
        ((MainTabUI)localObject2).adHd = false;
        localObject2 = ((HomeUI)localObject1).adAB;
        localObject6 = new com.tencent.mm.autogen.a.by();
        ((com.tencent.mm.autogen.a.by)localObject6).publish();
        if ((((com.tencent.mm.autogen.a.by)localObject6).hBX.hBY) && (!Util.isNullOrNil(((com.tencent.mm.autogen.a.by)localObject6).hBX.msg)))
        {
          Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "  now show msg:%s", new Object[] { ((com.tencent.mm.autogen.a.by)localObject6).hBX.msg });
          localObject4 = new g.a(((j)localObject2).EzS);
          localObject5 = ((g.a)localObject4).bf(((j)localObject2).getString(R.l.app_updated_title)).bg(((j)localObject2).getString(R.l.app_updated_new_feature));
          localObject6 = ((com.tencent.mm.autogen.a.by)localObject6).hBX.msg;
          ((g.a)localObject5).GGP.bDx((String)localObject6);
          localObject4 = ((g.a)localObject4).NF(false).b(new j.1((j)localObject2));
          ((g.a)localObject4).Xdm = true;
          ((g.a)localObject4).show();
        }
        if (!((j)localObject2).a(((j)localObject2).adzQ)) {
          com.tencent.mm.model.bh.baH().postToWorkerDelayed(new j.4((j)localObject2), 500L);
        }
        ((j)localObject2).adzQ = null;
        CrashReportFactory.setForeground(true);
        bool1 = ((HomeUI)localObject1).adAA.glL();
        if ((!bool1) && (com.tencent.mm.model.bh.baz()))
        {
          com.tencent.mm.blink.b.aJY().arrange(new HomeUI.42((HomeUI)localObject1));
          if ((com.tencent.mm.bd.d.oXO != null) && (com.tencent.mm.bd.d.oXN != null) && (!Util.isNullOrNil(com.tencent.mm.bd.d.oXN.bNF())))
          {
            Log.i("MicroMsg.LauncherUI.HomeUI", "launcher onResume end track %s", new Object[] { com.tencent.mm.bd.d.oXO.bNG() });
            localObject2 = new gg();
            ((gg)localObject2).hGt.username = com.tencent.mm.bd.d.oXO.bNG();
            ((gg)localObject2).publish();
          }
        }
        if (!bool1)
        {
          k.a(((HomeUI)localObject1).EzS, 3, ((HomeUI)localObject1).adAC.jP, "directReport_onResume");
          ((HomeUI)localObject1).adAC.aAq(260);
        }
        com.tencent.mm.ui.widget.l.b(((HomeUI)localObject1).EzS);
        ((HomeUI)localObject1).EzS.onSwipe(1.0F);
        ((HomeUI)localObject1).adAz = HomeUI.a.adBm;
        if (((HomeUI)localObject1).adAm)
        {
          ((HomeUI)localObject1).adAm = false;
          ((HomeUI)localObject1).adAm = false;
        }
        com.tencent.mm.modelavatar.p.bFA();
        l2 = System.currentTimeMillis();
        Log.w("MicroMsg.LauncherUI.HomeUI", "[Launching Application]");
        n.w(((HomeUI)localObject1).EzS, false);
        n.x(((HomeUI)localObject1).EzS, false);
        long l3 = System.currentTimeMillis();
        bool1 = ((HomeUI)localObject1).EzS.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("settings_landscape_mode", false);
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        boolean bool2 = ((com.tencent.mm.plugin.multitask.ui.uic.c)com.tencent.mm.ui.component.k.d(((HomeUI)localObject1).EzS).q(com.tencent.mm.plugin.multitask.ui.uic.c.class)).gkZ();
        if ((!bool1) || (bool2)) {
          break label3973;
        }
        if (aw.jkT()) {
          bh.aDU(1);
        }
        ((HomeUI)localObject1).EzS.setRequestedOrientation(-1);
        label1657:
        long l4 = System.currentTimeMillis();
        if (getInstance() != null)
        {
          com.tencent.mm.blink.b.aJY().aKb();
          ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("showprivacypolicy", ((HomeUI)localObject1).adBc);
          ((HomeUI)localObject1).Lb(false);
          ((HomeUI)localObject1).Pme.alive();
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - l4));
          if (com.tencent.mm.model.bh.baz()) {
            ((HomeUI)localObject1).jiZ();
          }
        }
        Log.v("MicroMsg.LauncherUI.HomeUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - l3));
        Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - l2));
        Log.i("MicroMsg.LauncherUI.HomeUI", "initView " + (System.currentTimeMillis() - l1));
        if (((HomeUI)localObject1).adAm)
        {
          ((HomeUI)localObject1).adAm = false;
          ((HomeUI)localObject1).adAm = false;
        }
        localObject2 = com.tencent.mm.app.z.aCK();
        ((com.tencent.mm.app.z)localObject2).hhr = true;
        ((com.tencent.mm.app.z)localObject2).hhs.removeMessages(-1999);
        ((com.tencent.mm.app.z)localObject2).hhs.removeMessages(-2999);
        Log.i("MicroMsg.LauncherUI.HomeUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - l1));
        i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acYY, 0);
        if (i != 0)
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acYY, Integer.valueOf(0));
          if (com.tencent.mm.model.z.bBz()) {}
        }
        switch (i)
        {
        default: 
          label1976:
          com.tencent.mm.blink.b.aJY().arrange(new HomeUI.2((HomeUI)localObject1));
          if (((HomeUI)localObject1).getMainTabUI().jP != 3)
          {
            localObject1 = (MoreTabUI)((HomeUI)localObject1).getMainTabUI().aAt(3);
            if ((((MoreTabUI)localObject1).adHx != null) && (!((MoreTabUI)localObject1).adHx.isVisible))
            {
              ((MoreTabUI)localObject1).adHx.jIr();
              ((MoreTabUI)localObject1).gBq();
            }
          }
          localObject1 = this.chattingTabUI;
          ((NewChattingTabUI)localObject1).adID = Util.nowSecond();
          if (((NewChattingTabUI)localObject1).jkB())
          {
            ((NewChattingTabUI)localObject1).adIG = new NewChattingTabUI.1((NewChattingTabUI)localObject1);
            MMHandlerThread.postToMainThreadDelayed(new NewChattingTabUI.2((NewChattingTabUI)localObject1), 500L);
          }
          if (((NewChattingTabUI)localObject1).glL())
          {
            ((NewChattingTabUI)localObject1).rG(3);
            if ((((NewChattingTabUI)localObject1).adIL != null) && (((NewChattingTabUI)localObject1).adIL.isSupportNavigationSwipeBack())) {
              ((NewChattingTabUI)localObject1).adIL.getSwipeBackLayout().setEnableGesture(true);
            }
            label2145:
            Log.i("MicroMsg.LauncherUI", "resumeNormalJump");
            MMFragmentActivity.a.jka();
            if (("pushcontent_notification".equals(IntentUtil.getStringExtra(getIntent(), "nofification_type"))) && (!Util.isNullOrNil(IntentUtil.getStringExtra(getIntent(), "Main_FromUserName"))))
            {
              localObject1 = IntentUtil.getStringExtra(getIntent(), "Main_FromUserName");
              i = IntentUtil.getIntExtra(getIntent(), "MainUI_User_Last_Msg_Type", 0);
              Log.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + (String)localObject1 + i);
              com.tencent.mm.plugin.report.service.h.OAn.b(10856, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(0) });
            }
            localObject1 = IntentUtil.getStringExtra(getIntent(), "LauncherUI.Shortcut.LaunchType");
            if (localObject1 != null)
            {
              if (!((String)localObject1).equals("launch_type_voip")) {
                break label4070;
              }
              Log.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
              localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
              com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.OAn.b(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
            }
            label2430:
            localObject1 = IntentUtil.getStringExtra(getIntent(), "LauncherUI.switch.tab");
            if (!Util.isNullOrNil((String)localObject1))
            {
              this.adBG.getMainTabUI().bzP((String)localObject1);
              getIntent().putExtra("LauncherUI.switch.tab", "");
            }
            if ((IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) || (this.adBK))
            {
              this.adBK = false;
              localObject1 = getInstance();
              if (localObject1 != null) {
                ((LauncherUI)localObject1).adBG.jiS();
              }
              getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
              getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
            }
            bool1 = IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
            if (!bool1) {
              break label4767;
            }
            localObject1 = IntentUtil.getStringExtra(getIntent(), "LauncherUI.Shortcut.Username");
            label2574:
            if (bool1)
            {
              Log.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = ".concat(String.valueOf(localObject1)));
              if (!Util.isNullOrNil((String)localObject1))
              {
                localObject4 = com.tencent.mm.plugin.base.model.b.aia((String)localObject1);
                if (!Util.isNullOrNil((String)localObject4))
                {
                  if (com.tencent.mm.model.ab.IR((String)localObject4))
                  {
                    Log.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                    if (!com.tencent.mm.an.g.Mz((String)localObject4)) {
                      break label5073;
                    }
                    if (!com.tencent.mm.an.g.Dn((String)localObject4)) {
                      break label4791;
                    }
                    localObject1 = new Intent();
                    ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                    ((Intent)localObject1).putExtra("Contact_User", (String)localObject4);
                    ((Intent)localObject1).putExtra("biz_chat_from_scene", 9);
                    ((Intent)localObject1).addFlags(67108864);
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
                    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                  label2766:
                  getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
                  getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
                }
              }
            }
            this.adBJ = true;
            label2795:
            com.tencent.mm.blink.a.qd(5);
            if (!adBE) {
              Lg(false);
            }
            jjn();
            localObject1 = (com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ball.c.b.class);
            if (localObject1 == null) {
              break label5108;
            }
            Log.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, try to fix");
            ((com.tencent.mm.plugin.ball.c.b)localObject1).cXK();
          }
          break;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).fJJ();
        com.tencent.mm.plugin.base.stub.f.dad();
        com.tencent.mm.blink.a.Ch("LauncherUI");
        AppMethodBeat.o(33303);
        return;
        bool1 = false;
        break;
        label2881:
        Log.d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
        l1 = System.currentTimeMillis();
        l2 = System.currentTimeMillis();
        MMActivity.initLanguage(((HomeUI)localObject1).EzS);
        try
        {
          localObject2 = new HashSet();
          localObject4 = ((HomeUI)localObject1).getString(R.l.country_others).split(";");
          ((Set)localObject2).add(localObject4[0]);
          ((Set)localObject2).add(localObject4[1]);
          aa.m((Set)localObject2);
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baH().postToWorker(new HomeUI.16((HomeUI)localObject1));
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).pUI = ((LayoutInflater)((HomeUI)localObject1).EzS.getSystemService("layout_inflater"));
          l2 = System.currentTimeMillis();
          com.tencent.mm.kiss.layout.b.bbG();
          ((HomeUI)localObject1).contentView = com.tencent.mm.kiss.layout.b.d(((HomeUI)localObject1).EzS, R.i.gls);
          if ((((HomeUI)localObject1).contentView != null) && (Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.isMIUIV8())) {
            ((HomeUI)localObject1).contentView.setBackgroundColor(((HomeUI)localObject1).EzS.getResources().getColor(R.e.normal_actionbar_color));
          }
          com.tencent.mm.blink.b.aJY().aJZ();
          ((FirstScreenFrameLayout)((HomeUI)localObject1).contentView.findViewById(R.h.fIl)).lqX = new HomeUI.20((HomeUI)localObject1);
          as.iII();
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).EzS.setContentView(((HomeUI)localObject1).contentView);
          Looper.myQueue().addIdleHandler(((HomeUI)localObject1).fgm);
          ((HomeUI)localObject1).adAl = true;
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).initActionBar();
          ((HomeUI)localObject1).mActionBar.show();
          ((HomeUI)localObject1).contentView.post(new HomeUI.33((HomeUI)localObject1));
          Log.v("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - l1));
          MMHandlerThread.postToMainThreadDelayed(new HomeUI.39((HomeUI)localObject1), 2000L);
          ((HomeUI)localObject1).contentView.addOnLayoutChangeListener(((HomeUI)localObject1).adAI);
          com.tencent.mm.pluginsdk.h.a(((HomeUI)localObject1).EzS, ((HomeUI)localObject1).contentView);
          ((HomeUI)localObject1).contentView.postDelayed(new HomeUI.40((HomeUI)localObject1), 20L);
          ag.init(MMApplicationContext.getContext());
          ag.aAi(1);
          ((HomeUI)localObject1).adAX.alive();
          localObject5 = ((HomeUI)localObject1).adAC;
          Log.i("MicroMsg.LauncherUI.MainTabUI", "doOnCreate");
          ((MainTabUI)localObject5).mViewPager = ((CustomViewPager)((MainTabUI)localObject5).EzS.findViewById(R.h.pager));
          ((MainTabUI)localObject5).mViewPager.setOffscreenPageLimit(4);
          ((MainTabUI)localObject5).setCanSlide(true);
          ((MainTabUI)localObject5).mViewPager.setCanSlideBySide(false);
          ((MainTabUI)localObject5).mTabsAdapter = new MainTabUI.TabsAdapter((MainTabUI)localObject5, ((MainTabUI)localObject5).EzS, ((MainTabUI)localObject5).mViewPager);
          if (getInstance() != null)
          {
            ((MainTabUI)localObject5).aAs(getInstance().adBS);
            localObject2 = ((MainTabUI)localObject5).adGR;
            localObject4 = (ViewGroup)((MainTabUI)localObject5).mViewPager.getParent();
            localObject5 = ((MainTabUI)localObject5).mTabsAdapter;
            localObject6 = ((ah)localObject2).adHj;
            if (((ah)localObject2).adHj != null)
            {
              ((ah)localObject2).adHj.setOnTabClickListener(null);
              ((View)((ah)localObject2).adHj).setVisibility(8);
              if (localObject4 != null) {
                ((ViewGroup)localObject4).removeView((View)((ah)localObject2).adHj);
              }
            }
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
            LauncherUIBottomTabView localLauncherUIBottomTabView = new LauncherUIBottomTabView(((ah)localObject2).EzS);
            localLauncherUIBottomTabView.setId(R.h.fMt);
            if (localObject4 != null)
            {
              localLayoutParams.gravity = 80;
              ((ViewGroup)localObject4).addView(localLauncherUIBottomTabView, localLayoutParams);
            }
            ((ah)localObject2).adHj = localLauncherUIBottomTabView;
            ((View)((ah)localObject2).adHj).setVisibility(0);
            ((ah)localObject2).adHj.setOnTabClickListener((d.a)localObject5);
            if ((localObject6 != null) && (localObject6 != ((ah)localObject2).adHj))
            {
              ((ah)localObject2).adHj.KT(((d)localObject6).getShowFriendPoint());
              ((ah)localObject2).adHj.KU(((d)localObject6).getSettingsPoint());
              ((ah)localObject2).adHj.azS(((d)localObject6).getMainTabUnread());
              ((ah)localObject2).adHj.azT(((d)localObject6).getContactTabUnread());
              ((ah)localObject2).adHj.azU(((d)localObject6).getFriendTabUnread());
              ((ah)localObject2).adHj.azV(((d)localObject6).getSettingsTabUnread());
              ((ah)localObject2).adHj.setTo(((d)localObject6).getCurIdx());
            }
            if (((ah)localObject2).adHi != null)
            {
              localObject4 = ((ah)localObject2).adHi;
              localObject5 = ((ah)localObject2).EzS;
              kotlin.g.b.s.u(localObject5, "activity");
              localObject6 = com.tencent.mm.plugin.finder.extension.reddot.l.ARA;
              com.tencent.mm.plugin.finder.extension.reddot.l.dZB().a((androidx.lifecycle.q)localObject5, ((com.tencent.mm.plugin.finder.extension.reddot.k)localObject4).ARx);
              ((ah)localObject2).adHi.ARw = ((ah)localObject2).adHr;
            }
            ((HomeUI)localObject1).adAC.adGX = new HomeUI.1((HomeUI)localObject1);
            com.tencent.threadpool.h.ahAA.bm(new HomeUI.11((HomeUI)localObject1));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
            continue;
            ((MainTabUI)localObject5).aAs(0);
          }
        }
      }
      label3961:
      com.tencent.mm.model.bh.getNotification().et(false);
      break label837;
      label3973:
      if (aw.jkT()) {
        bh.aDU(0);
      }
      ((HomeUI)localObject1).EzS.setRequestedOrientation(1);
      break label1657;
      com.tencent.mm.ui.base.k.a(((HomeUI)localObject1).EzS, ((HomeUI)localObject1).getString(R.l.login_bind_facebook_tip), "", new HomeUI.43((HomeUI)localObject1), null);
      break label1976;
      if (!((NewChattingTabUI)localObject1).adIO) {
        break label2145;
      }
      Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "[onResume] need exec this runnable!");
      MMHandlerThread.removeRunnable(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      MMHandlerThread.postToMainThread(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      ((NewChattingTabUI)localObject1).adIO = false;
      break label2145;
      label4070:
      if (((String)localObject1).equals("launch_type_voip_audio"))
      {
        Log.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
        localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.OAn.b(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        break label2430;
      }
      if (((String)localObject1).equals("launch_type_scan_qrcode"))
      {
        if (!WeChatBrands.Business.Entries.GlobalScan.checkAvailable(this)) {
          break label2430;
        }
        getIntent().putExtra("LauncherUI.Shortcut.LaunchType", "");
        localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject1 = (dgs)com.tencent.mm.plugin.secdata.ui.a.a.a(this, "BaseScanUI", 3, dgs.class);
        if (localObject1 != null) {
          ((dgs)localObject1).aaLL = "launch_type_scan_qrcode";
        }
        localObject1 = new Intent().setClassName(this, "com.tencent.mm.plugin.scanner.ui.BaseScanUI");
        ((Intent)localObject1).putExtra("key_enable_multi_code", true);
        ((Intent)localObject1).putExtra("key_scan_goods_enable_dynamic_wording", true);
        ((Intent)localObject1).putExtra("key_enable_scan_code_product_merge", true);
        ((Intent)localObject1).putExtra("key_scan_entry_scene", 5);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break label2430;
      }
      if (((String)localObject1).equals("launch_type_offline_wallet"))
      {
        getIntent().putExtra("LauncherUI.Shortcut.LaunchType", "");
        localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject1 = (dgs)com.tencent.mm.plugin.secdata.ui.a.a.a(this, "WalletOfflineEntranceUI", 3, dgs.class);
        if (localObject1 != null) {
          ((dgs)localObject1).aaLL = "launch_type_offline_wallet";
        }
        i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
        if ((i == 0) || (i == 1))
        {
          localObject1 = new Intent().setClassName(this, "com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI");
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break label2430;
        }
        if (i != 8) {
          break label2430;
        }
        if (this.adBL == null) {
          this.adBL = new com.tencent.mm.plugin.wallet_index.model.b();
        }
        this.adBL.kL(this);
        break label2430;
      }
      if (!((String)localObject1).equals("launch_type_my_qrcode")) {
        break label2430;
      }
      getIntent().putExtra("LauncherUI.Shortcut.LaunchType", "");
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject1 = (dgs)com.tencent.mm.plugin.secdata.ui.a.a.a(this, "SelfQRCodeUI", 3, dgs.class);
      if (localObject1 != null) {
        ((dgs)localObject1).aaLL = "launch_type_my_qrcode";
      }
      localObject1 = new Intent().setClassName(this, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break label2430;
      label4767:
      bool1 = IntentUtil.getBooleanExtra(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
      localObject1 = getIntent().getAction();
      break label2574;
      label4791:
      if (com.tencent.mm.an.g.MB((String)localObject4))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject1).putExtra("enterprise_biz_name", (String)localObject4);
        ((Intent)localObject1).putExtra("enterprise_biz_display_name", aa.getDisplayName((String)localObject4));
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break label2766;
      }
      if (com.tencent.mm.an.g.MC((String)localObject4))
      {
        localObject1 = com.tencent.mm.an.g.hU((String)localObject4);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).aAT())
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
      break label2766;
      label5073:
      localObject1 = getInstance();
      if (localObject1 == null) {
        break label2766;
      }
      ((LauncherUI)localObject1).startChatting((String)localObject4, null, false);
      break label2766;
      if (adBE) {
        break label2795;
      }
      jjr();
      break label2795;
      label5108:
      Log.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, service is null");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(33322);
    super.onSaveInstanceState(paramBundle);
    Object localObject = this.chattingTabUI;
    if (((NewChattingTabUI)localObject).adIL != null)
    {
      localObject = ((NewChattingTabUI)localObject).adIL.iNh().getTalkerUserName();
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
    if ((this.adBI) && (!this.chattingTabUI.ar(paramBoolean, paramInt))) {
      super.onSettle(paramBoolean, paramInt);
    }
    AppMethodBeat.o(33318);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(249614);
    com.tencent.mm.plugin.l locall = (com.tencent.mm.plugin.l)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.l.class);
    if (locall != null) {
      locall.bUT();
    }
    super.onStart();
    AppMethodBeat.o(249614);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(33312);
    Log.i("MicroMsg.LauncherUI", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.blink.a.aJT();
    if (aw.jkS())
    {
      this.adBG.hdx();
      this.chattingTabUI.hdx();
    }
    HomeUI localHomeUI = this.adBG;
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("showprivacypolicy", localHomeUI.adBc);
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
    if (this.adBI)
    {
      localNewChattingTabUI = this.chattingTabUI;
      if ((localNewChattingTabUI.adIC == null) || (!localNewChattingTabUI.adIC.jiT())) {
        break label108;
      }
      bool = true;
      Log.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", new Object[] { Float.valueOf(paramFloat), Long.valueOf(260L), Boolean.valueOf(bool) });
      if (localNewChattingTabUI.jkB()) {
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
        localNewChattingTabUI.aAx(0);
        localObject = (ImageView)localNewChattingTabUI.PIA.getWindow().getDecorView().findViewById(R.h.fTp);
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
        if (!localNewChattingTabUI.adIC.jiT())
        {
          if (Float.compare(1.0F, paramFloat) > 0)
          {
            Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Boolean.FALSE });
            i = 0;
            break;
            if ((paramFloat != 1.0F) || (localNewChattingTabUI.mChattingClosed) || (localNewChattingTabUI.adIL.joQ())) {
              continue;
            }
            localNewChattingTabUI.PIA.getWindow().setBackgroundDrawableResource(R.e.fkX);
            localObject = (ImageView)localNewChattingTabUI.PIA.getWindow().getDecorView().findViewById(R.h.fTp);
            if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0) && (((ImageView)localObject).getTag() != null))
            {
              ((View)((ImageView)localObject).getTag()).setVisibility(0);
              Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
              ((ImageView)localObject).setVisibility(8);
              ((ImageView)localObject).setVisibility(8);
            }
            if ((localNewChattingTabUI.adIL.getContentView() != null) && (localNewChattingTabUI.adIL.getContentView().getX() <= 0.0F))
            {
              localNewChattingTabUI.aAx(8);
              continue;
            }
            localNewChattingTabUI.aAx(0);
            continue;
          }
          j = 0;
        }
      }
      i = j;
      if (localNewChattingTabUI.PIA != null)
      {
        localObject = localNewChattingTabUI.PIA.findViewById(R.h.fMr);
        ImageView localImageView = (ImageView)localNewChattingTabUI.PIA.findViewById(R.h.fTp);
        if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null) && (!localNewChattingTabUI.mChattingClosed) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
        {
          localImageView.setVisibility(0);
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
          localNewChattingTabUI.aAx(8);
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
    if (((NewChattingTabUI)localObject3).adIL != null)
    {
      localObject1 = localObject2;
      if (((NewChattingTabUI)localObject3).adIL.joS() != null)
      {
        if (((NewChattingTabUI)localObject3).adIL.isSupportCustomActionBar()) {
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
      if (!com.tencent.mm.compatible.util.d.rd(22))
      {
        localObject3 = ((NewChattingTabUI)localObject3).adIL.joS().b(paramCallback);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject3;
        }
      }
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(249715);
    if ((paramIntent != null) && (paramIntent.getComponent() != null))
    {
      com.tencent.mm.ui.tools.x localx = com.tencent.mm.ui.tools.x.afLD;
      com.tencent.mm.ui.tools.x.bCG(paramIntent.getComponent().getClassName());
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(249715);
  }
  
  public final void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(33329);
    this.adBG.jiR();
    this.chattingTabUI.startChatting(paramString, paramBundle, paramBoolean);
    AppMethodBeat.o(33329);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(249611);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.addAll(super.importUIComponents());
    paramHashSet.add(com.tencent.mm.plugin.multitask.ui.uic.c.class);
    paramHashSet.add(com.tencent.mm.ui.a.g.class);
    paramHashSet.add(q.class);
    paramHashSet.add(com.tencent.mm.plugin.multitask.ui.a.a.class);
    AppMethodBeat.o(249611);
  }
  
  static abstract interface a
  {
    public abstract boolean glL();
  }
  
  static abstract interface b
  {
    public abstract void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup);
    
    public abstract boolean jiT();
    
    public abstract void jiW();
    
    public abstract void jiX();
  }
  
  static final class d
    implements com.tencent.mm.ui.l.a
  {
    public final Activity jjs()
    {
      AppMethodBeat.i(249554);
      LauncherUI localLauncherUI = LauncherUI.getInstance();
      AppMethodBeat.o(249554);
      return localLauncherUI;
    }
  }
  
  static abstract interface e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI
 * JD-Core Version:    0.7.0.1
 */