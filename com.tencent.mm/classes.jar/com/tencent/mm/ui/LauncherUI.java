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
import androidx.appcompat.app.ActionBar;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.app.w;
import com.tencent.mm.blink.FirstScreenFrameLayout;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.f.a.ai;
import com.tencent.mm.f.a.bp;
import com.tencent.mm.f.a.bp.b;
import com.tencent.mm.f.a.fv;
import com.tencent.mm.f.a.mi;
import com.tencent.mm.f.a.nm;
import com.tencent.mm.f.a.om;
import com.tencent.mm.f.a.rm;
import com.tencent.mm.f.b.a.no;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.kernel.n;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ck;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.account.ui.WelcomeActivity;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.performance.elf.MainProcessChecker;
import com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity;
import com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI;
import com.tencent.mm.pluginsdk.j.c.a;
import com.tencent.mm.protocal.protobuf.cpy;
import com.tencent.mm.protocal.protobuf.djx;
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
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.widget.SwipeBackLayout;
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
  private static ArrayList<LauncherUI> VXd;
  private static ArrayList<WeakReference<LauncherUI>> VXe;
  private static boolean VXf;
  public static long VXg;
  private static boolean VXh;
  private static boolean VXr;
  private IListener<rm> VXi;
  private IListener<om> VXj;
  public HomeUI VXk;
  private p VXl;
  public boolean VXm;
  boolean VXn;
  private boolean VXo;
  private com.tencent.mm.plugin.wallet_index.c.b VXp;
  private com.tencent.mm.pluginsdk.t VXq;
  private boolean VXs;
  private MMHandler VXt;
  private Runnable VXu;
  private boolean VXv;
  int VXw;
  NewChattingTabUI chattingTabUI;
  private Intent fKs;
  
  static
  {
    AppMethodBeat.i(33334);
    VXd = new ArrayList();
    VXe = new ArrayList();
    VXf = true;
    VXh = false;
    VXr = false;
    AppMethodBeat.o(33334);
  }
  
  public LauncherUI()
  {
    AppMethodBeat.i(33295);
    this.VXi = new IListener() {};
    this.VXj = new LauncherUI.2(this);
    this.VXk = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.VXk);
    this.VXl = new p();
    this.fKs = null;
    this.VXm = false;
    this.VXn = false;
    this.VXo = false;
    this.VXq = new com.tencent.mm.pluginsdk.t("MicroMsg.LauncherUI");
    this.VXs = false;
    this.VXt = new MMHandler();
    this.VXu = new LauncherUI.5(this);
    this.VXv = false;
    this.VXw = 0;
    AppMethodBeat.o(33295);
  }
  
  private void Fw(boolean paramBoolean)
  {
    AppMethodBeat.i(33302);
    if (paramBoolean)
    {
      new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(260140);
          LauncherUI.a(LauncherUI.this);
          AppMethodBeat.o(260140);
        }
      };
      p.hHk();
    }
    for (paramBoolean = false;; paramBoolean = true)
    {
      this.VXs = paramBoolean;
      do
      {
        AppMethodBeat.o(33302);
        return;
      } while (this.VXs);
      if (this.VXl.bi(this)) {
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
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(405L, 28L, 1L, true);
    com.tencent.mm.plugin.report.service.h localh;
    if (com.tencent.mm.plugin.y.d.eUZ() != null)
    {
      paramIntent = com.tencent.mm.plugin.y.d.eUZ().b(this, null);
      if (paramIntent == null)
      {
        AppMethodBeat.o(33315);
        return;
      }
      localh = com.tencent.mm.plugin.report.service.h.IzE;
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
    if (!bh.aHB())
    {
      Log.i("MicroMsg.LauncherUI", "handleJump not accHhasReady");
      paramIntent = new Intent(this, LauncherUI.class).putExtra("Intro_Switch", true).addFlags(67108864);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aFh(), "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "handleJump", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(33307);
      return;
    }
    Object localObject1 = new mi();
    ((mi)localObject1).fKr.fKs = this.fKs;
    EventCenter.instance.publish((IEvent)localObject1);
    if ("talkroom_notification".equals(IntentUtil.getStringExtra(paramIntent, "nofification_type")))
    {
      paramIntent = IntentUtil.getStringExtra(paramIntent, "enter_chat_usrname");
      if (!Util.isNullOrNil(paramIntent))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("enter_room_username", paramIntent);
        ((Intent)localObject1).setFlags(268435456);
        com.tencent.mm.by.c.b(this, "talkroom", ".ui.TalkRoomUI", (Intent)localObject1);
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
        MMWizardActivity.aH(this, paramIntent);
        AppMethodBeat.o(33307);
        return;
        Log.i("MicroMsg.LauncherUI", "MicroMsg.Backup jump BackupPcUI");
      }
    }
    if ("back_to_pcmgr_error_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakConnErrorUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.aH(this, paramIntent);
      AppMethodBeat.o(33307);
      return;
    }
    if ("clear_msg_not_finish_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      com.tencent.mm.ui.base.h.p(this, R.l.exD, R.l.app_tip);
      AppMethodBeat.o(33307);
      return;
    }
    if ("backup_move_notification".equals(paramIntent.getStringExtra("nofification_type")))
    {
      paramIntent = new Intent().setClassName(this, "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
      paramIntent.setFlags(268435456);
      MMWizardActivity.aH(this, paramIntent);
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
      bh.beI();
      localObject2 = com.tencent.mm.model.c.bbR().bwx(str);
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
      MMAppMgr.abF();
      EventCenter.instance.publish(new ai());
      boolean bool = IntentUtil.getBooleanExtra(paramIntent, "Intro_Is_Muti_Talker", true);
      Log.i("MicroMsg.LauncherUI", "handleJump, isMutiTalker:%b, unReadCount:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
      if ((!bool) && (j > 0))
      {
        i = IntentUtil.getIntExtra(paramIntent, "Intro_Bottle_unread_count", 0);
        if (i > 0)
        {
          Log.i("MicroMsg.LauncherUI", "handleJump, bottleReadCnt :%d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.by.c.ad(this, "bottle", ".ui.BottleConversationUI");
        }
      }
      if (!bool)
      {
        if (ab.QC(str))
        {
          Log.i("MicroMsg.LauncherUI", "handleJump, isReaderAppNewsHelper");
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("type", 20);
          com.tencent.mm.by.c.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
        }
        for (;;)
        {
          if (IntentUtil.getIntExtra(paramIntent, "kstyle_show_bind_mobile_afterauth", 0) > 0)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).setClassName(this, "com.tencent.mm.plugin.account.bind.ui.BindMobileUI");
            ((Intent)localObject1).putExtra("kstyle_bind_recommend_show", paramIntent.getIntExtra("kstyle_bind_recommend_show", 0));
            ((Intent)localObject1).putExtra("kstyle_bind_wording", paramIntent.getParcelableExtra("kstyle_bind_wording"));
            MMWizardActivity.aH(this, (Intent)localObject1);
          }
          AppMethodBeat.o(33307);
          return;
          if (!ab.QK(str)) {
            break;
          }
          Log.i("MicroMsg.LauncherUI", "handleJump, isReaderAppWeiboHelper");
          localObject1 = new Intent();
          ((Intent)localObject1).addFlags(67108864);
          ((Intent)localObject1).putExtra("type", 11);
          com.tencent.mm.by.c.b(this, "readerapp", ".ui.ReaderAppUI", (Intent)localObject1);
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
        if (com.tencent.mm.ao.g.KI(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("biz_chat_from_scene", 4);
          com.tencent.mm.by.c.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
          break;
        }
        if (com.tencent.mm.ao.g.UD(str))
        {
          localObject1 = com.tencent.mm.ao.g.gu(str);
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).Zb())
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
            com.tencent.mm.by.c.b(this, "webview", ".ui.tools.WebViewUI", paramIntent);
            break;
          }
        }
        if (as.OS(str))
        {
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          paramIntent.putExtra("app_brand_conversation_from_scene", 3);
          paramIntent.putExtra("finish_direct", true);
          paramIntent.putExtra("key_need_send_video", false);
          com.tencent.mm.by.c.f(this, ".ui.conversation.AppBrandServiceConversationUI", paramIntent);
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
            if (com.tencent.mm.ao.g.KI(str))
            {
              paramIntent.putExtra("Contact_User", str);
              paramIntent.addFlags(67108864);
              paramIntent.putExtra("biz_chat_from_scene", 4);
              com.tencent.mm.by.c.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
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
          com.tencent.mm.by.c.b(this, "sns", ".ui.SnsTimeLineUI", (Intent)localObject1);
          break;
        }
        if (IntentUtil.getBooleanExtra(paramIntent, "biz_chat_need_to_jump_to_chatting_ui", false))
        {
          if ((getInstance() == null) || (!com.tencent.mm.ao.g.KI(str))) {
            break;
          }
          paramIntent.putExtra("Contact_User", str);
          paramIntent.addFlags(67108864);
          com.tencent.mm.by.c.f(this, ".ui.bizchat.BizChatConversationUI", paramIntent);
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
  
  public static int getCurrentTabIndex()
  {
    AppMethodBeat.i(33297);
    if ((getInstance() != null) && (getInstance().getHomeUI() != null) && (getInstance().getHomeUI().getMainTabUI() != null))
    {
      int i = getInstance().getHomeUI().getMainTabUI().iU;
      AppMethodBeat.o(33297);
      return i;
    }
    AppMethodBeat.o(33297);
    return -1;
  }
  
  public static LauncherUI getInstance()
  {
    AppMethodBeat.i(33296);
    if (VXd.isEmpty())
    {
      Log.e("MicroMsg.LauncherUI", "LauncherUI instances should not be empty. %s", new Object[] { Util.getStack() });
      AppMethodBeat.o(33296);
      return null;
    }
    LauncherUI localLauncherUI = (LauncherUI)VXd.get(0);
    AppMethodBeat.o(33296);
    return localLauncherUI;
  }
  
  private void hHb()
  {
    AppMethodBeat.i(33298);
    int i = VXd.indexOf(this);
    if (i >= 0) {
      VXd.remove(i);
    }
    Log.i("MicroMsg.LauncherUI", "checktask delteInstance index %d, size:%d, hashCode: 0x%x", new Object[] { Integer.valueOf(i), Integer.valueOf(VXd.size()), Integer.valueOf(hashCode()) });
    AppMethodBeat.o(33298);
  }
  
  private void hHc()
  {
    boolean bool2 = true;
    AppMethodBeat.i(33300);
    Log.d("MicroMsg.LauncherUI", "[whatsnew] checkIfStartWhatsNew.");
    if (VXr)
    {
      Log.i("MicroMsg.LauncherUI", "[whatsnew] has been played.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!com.tencent.mm.kernel.h.aHE().aGM())
    {
      com.tencent.mm.kernel.h.aHE();
      if (!com.tencent.mm.kernel.b.aGL())
      {
        Log.i("MicroMsg.LauncherUI", "[whatsnew] not login yet, skip.");
        AppMethodBeat.o(33300);
        return;
      }
      Log.i("MicroMsg.LauncherUI", "[whatsnew] account not initiate, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    if (!hHd())
    {
      Log.i("MicroMsg.LauncherUI", "[whatsnew] notSwitchOrHold is false, skip whatsnew.");
      AppMethodBeat.o(33300);
      return;
    }
    boolean bool3 = IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.enter_from_reg", false);
    boolean bool4 = com.tencent.mm.ui.a.a.a.hJg().hJd();
    boolean bool5;
    boolean bool1;
    if ((!bool3) && (com.tencent.mm.pluginsdk.j.c.QYP != null) && (com.tencent.mm.pluginsdk.j.c.QYP.abN()) && (bh.aHB()) && (!bool4))
    {
      if (MMEntryLock.lock("show_whatsnew"))
      {
        VXr = true;
        Log.i("MicroMsg.LauncherUI", "[whatsnew] show whatsnew.");
        MMAppMgr.hHQ();
        com.tencent.mm.blink.a.apV();
        AppMethodBeat.o(33300);
      }
    }
    else
    {
      c.a locala = com.tencent.mm.pluginsdk.j.c.QYP;
      bool5 = bh.aHB();
      if (locala != null) {
        break label282;
      }
      bool1 = true;
      if ((locala == null) || (!locala.abN())) {
        break label287;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.LauncherUI", "[whatsnew] do not show whatsnew. enter_from_reg=%s accHasReady=%s MMAppMgr is null %s isWhatsNewAvailable=%s, isAccessibilityEnabled=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
      AppMethodBeat.o(33300);
      return;
      label282:
      bool1 = false;
      break;
      label287:
      bool2 = false;
    }
  }
  
  private boolean hHd()
  {
    AppMethodBeat.i(33304);
    if ((this.fKs != null) && (!IntentUtil.getBooleanExtra(this.fKs, "Intro_Switch", false)) && (bh.beJ()) && (!bh.aGE()))
    {
      AppMethodBeat.o(33304);
      return true;
    }
    AppMethodBeat.o(33304);
    return false;
  }
  
  private boolean hHe()
  {
    AppMethodBeat.i(33305);
    if (this.fKs != null)
    {
      Object localObject1;
      Object localObject2;
      if ((IntentUtil.getBooleanExtra(this.fKs, "absolutely_exit", false)) || (IntentUtil.getIntExtra(this.fKs, "absolutely_exit_pid", 0) == Process.myPid()))
      {
        Log.w("MicroMsg.LauncherUI", "resumeLogoutJump launcherOnResume exit absolutely!!! hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        finish();
        com.tencent.mm.plugin.report.service.g.adc(8);
        MMAppMgr.Fz(IntentUtil.getBooleanExtra(this.fKs, "kill_service", true));
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "java/lang/System_EXEC_", "exit", "(I)V");
        AppMethodBeat.o(33305);
        return true;
      }
      if (IntentUtil.getBooleanExtra(this.fKs, "can_finish", false))
      {
        Log.i("MicroMsg.LauncherUI", "resumeLogoutJump exit obviously");
        bh.aGY().gi(true);
        if (n.cG(getApplicationContext())) {
          com.tencent.mm.booter.b.ca(getApplicationContext());
        }
        com.tencent.mm.plugin.report.service.g.adc(8);
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_FORCE_DEACTIVE"), WeChatPermissions.PERMISSION_MM_MESSAGE());
        finish();
        com.tencent.mm.ui.base.b.lb(this);
        AppMethodBeat.o(33305);
        return true;
      }
      if (IntentUtil.getBooleanExtra(this.fKs, "exit_and_restart", false))
      {
        Mars.onSingalCrash(0);
        Log.i("MicroMsg.LauncherUI", "exit and restart myself.");
        Log.appenderFlush();
        finish();
        localObject1 = new Intent(this, LauncherUI.class);
        ((Intent)localObject1).addFlags(67108864);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        Log.i("MicroMsg.LauncherUI", "restart, try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        MMAppMgr.hHP();
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/LauncherUI", "handleExitIntent", "()Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(33305);
        return true;
      }
    }
    AppMethodBeat.o(33305);
    return false;
  }
  
  private void hHf()
  {
    AppMethodBeat.i(33306);
    Log.i("MicroMsg.LauncherUI", "switch to wxid %s", new Object[] { MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "") });
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, SettingsSwitchAccountUI.class);
    ((Intent)localObject).addFlags(536870912);
    ((Intent)localObject).putExtra("key_scene", 1);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "switchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.lc(this);
    AppMethodBeat.o(33306);
  }
  
  private void hHg()
  {
    AppMethodBeat.i(33308);
    Log.i("MicroMsg.LauncherUI", "resumeLogoutJump");
    if ((this.fKs != null) && (IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.jump_from_uimode_check", false)))
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
        break label294;
      }
      localObject = new no();
      ((no)localObject).ggN = 2L;
      ((no)localObject).gZO = 2L;
      ((no)localObject).bpa();
      localc = com.tencent.mm.util.c.Yyz;
      com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject);
    }
    for (;;)
    {
      MMFragmentActivity.a.hHS();
      MMFragmentActivity.a.hHS();
      az.kK(MMApplicationContext.getContext());
      az.atQ(2);
      u.kK(MMApplicationContext.getContext());
      u.atQ(2);
      localObject = bg.ltv.aD("login_user_name", "");
      if ((bh.beJ()) || (!((String)localObject).equals(""))) {
        break;
      }
      localObject = new Intent(this, WelcomeActivity.class);
      ((Intent)localObject).addFlags(536870912);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeLogoutJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.lc(this);
      Log.i("MicroMsg.LauncherUI", "resumeLogoutJump but has not login and ret");
      MMHandlerThread.removeRunnable(this.VXu);
      MMHandlerThread.postToMainThreadDelayed(this.VXu, 2000L);
      AppMethodBeat.o(33308);
      return;
      label294:
      if (((String)localObject).equals("launch_type_offline_wallet"))
      {
        localObject = new no();
        ((no)localObject).ggN = 1L;
        ((no)localObject).gZO = 2L;
        ((no)localObject).bpa();
        localc = com.tencent.mm.util.c.Yyz;
        com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject);
      }
      else if (((String)localObject).equals("launch_type_my_qrcode"))
      {
        localObject = new no();
        ((no)localObject).ggN = 3L;
        ((no)localObject).gZO = 2L;
        ((no)localObject).bpa();
        localc = com.tencent.mm.util.c.Yyz;
        com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)localObject);
      }
    }
    if ((this.fKs.getFlags() & 0x4000000) == 67108864) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = IntentUtil.getBooleanExtra(this.fKs, "Intro_Notify", false);
      Log.i("MicroMsg.LauncherUI", "resumeLogoutJump hasDoInit:%b needResetLaunchUI:%b formNotification:%b, ishold:%b", new Object[] { Boolean.valueOf(this.VXm), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bh.aGE()) });
      Log.i("MicroMsg.LauncherUI", "doOnResumeImp resumeLogoutJump hasCfgDefaultUin[%b]", new Object[] { Boolean.valueOf(bh.beJ()) });
      bh.aGF();
      if (IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) {
        this.VXo = true;
      }
      kG(this);
      bh.aGG();
      AppMethodBeat.o(33308);
      return;
    }
  }
  
  public static boolean hHh()
  {
    AppMethodBeat.i(288719);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSo, 1);
    Log.d("MicroMsg.LauncherUI", "isHWMagicLauncherUIOnresumeSwt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(288719);
      return true;
    }
    AppMethodBeat.o(288719);
    return false;
  }
  
  private void kG(Context paramContext)
  {
    AppMethodBeat.i(33309);
    if (IntentUtil.getBooleanExtra(this.fKs, "LauncherUI.jump_switch_account", false))
    {
      Log.i("MicroMsg.LauncherUI", "launcher to switch account");
      hHf();
      AppMethodBeat.o(33309);
      return;
    }
    if ((IntentUtil.getBooleanExtra(this.fKs, "Intro_Switch", false)) || (this.VXm) || (com.tencent.mm.kernel.b.aGt()))
    {
      this.VXk.getMainTabUI().hHV();
      com.tencent.mm.kernel.h.aHH().MS("[normal logout]");
      Mars.onSingalCrash(0);
      Log.i("MicroMsg.LauncherUI", "checktask ConstantsUI.Intro.KSwitch kill myself.");
      Log.appenderFlush();
      finish();
      Object localObject = new Intent(paramContext, LauncherUI.class);
      ((Intent)localObject).putExtra("key_errType", IntentUtil.getIntExtra(this.fKs, "key_errType", 0));
      ((Intent)localObject).putExtra("key_errCode", IntentUtil.getIntExtra(this.fKs, "key_errCode", 0));
      ((Intent)localObject).putExtra("key_errMsg", IntentUtil.getStringExtra(this.fKs, "key_errMsg"));
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      Log.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
      MMAppMgr.hHP();
      paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramContext.aFh(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(33309);
      return;
    }
    if (!IntentUtil.getBooleanExtra(this.fKs, "LauncherUI.jump_switch_account", false))
    {
      paramContext = bg.ltv.aD("login_user_name", "");
      Log.i("MicroMsg.LauncherUI", "%s jumpToLogin", new Object[] { paramContext });
      if (!Util.isNullOrNil(paramContext)) {
        break label544;
      }
      paramContext = new Intent(this, WelcomeActivity.class);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bm(paramContext);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramContext.aFh(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.lc(this);
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.adc(8);
      MMHandlerThread.removeRunnable(this.VXu);
      MMHandlerThread.postToMainThreadDelayed(this.VXu, 2000L);
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
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bm(paramContext);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramContext.aFh(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kZ(this);
    }
    int i = Util.safeParseInt(bg.ltv.aD("last_login_use_voice", ""));
    Log.i("MicroMsg.LauncherUI", "pluginSwitch  ".concat(String.valueOf(i)));
    paramContext = new Intent();
    paramContext.putExtra("key_errType", IntentUtil.getIntExtra(this.fKs, "key_errType", 0));
    paramContext.putExtra("key_errCode", IntentUtil.getIntExtra(this.fKs, "key_errCode", 0));
    paramContext.putExtra("key_errMsg", IntentUtil.getStringExtra(this.fKs, "key_errMsg"));
    if ((!WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned()) && ((i & 0x20000) != 0)) {
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginVoiceUI");
    }
    for (;;)
    {
      paramContext.addFlags(536870912);
      paramContext = new com.tencent.mm.hellhoundlib.b.a().bm(paramContext);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramContext.aFh(), "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramContext.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "jumpToLogin", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kZ(this);
      break;
      paramContext.setClassName(this, "com.tencent.mm.plugin.account.ui.LoginPasswordUI");
    }
  }
  
  public static void kH(Context paramContext)
  {
    AppMethodBeat.i(33328);
    Object localObject = new Intent(paramContext, LauncherUI.class);
    ((Intent)localObject).addFlags(67108864);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/LauncherUI", "startMainTabUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(33328);
  }
  
  public final void closeChatting(boolean paramBoolean)
  {
    AppMethodBeat.i(33330);
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33294);
        LauncherUI.this.VXk.getMainTabUI().hIa();
        AppMethodBeat.o(33294);
      }
    };
    if (this.chattingTabUI.FH(paramBoolean))
    {
      this.VXk.Ft(this.chattingTabUI.Wdi.isSupportCustomActionBar());
      this.VXk.getMainTabUI().hId();
    }
    AppMethodBeat.o(33330);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33319);
    boolean bool;
    if (this.chattingTabUI.fcI())
    {
      localObject1 = this.chattingTabUI;
      if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
        MMHandlerThread.removeRunnable(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      }
      if (((NewChattingTabUI)localObject1).isAnimating) {}
      for (bool = true; bool; bool = ((NewChattingTabUI)localObject1).Wdi.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent))
      {
        AppMethodBeat.o(33319);
        return true;
      }
    }
    Object localObject2;
    int i;
    if ((paramKeyEvent.getKeyCode() == 4) && (ar.isMultiTaskMode()))
    {
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      localObject1 = (com.tencent.mm.plugin.multitask.ui.a.c)com.tencent.mm.ui.component.g.b(this).i(com.tencent.mm.plugin.multitask.ui.a.c.class);
      kotlin.g.b.p.k(paramKeyEvent, "event");
      if (paramKeyEvent.getKeyCode() == 4)
      {
        localObject2 = ((com.tencent.mm.plugin.multitask.ui.a.c)localObject1).FMk;
        if ((localObject2 != null) && (((com.tencent.mm.plugin.multitask.ui.panel.b)localObject2).onKeyDown(4, paramKeyEvent) == true)) {
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(33319);
        return true;
        if (((com.tencent.mm.plugin.multitask.ui.a.c)localObject1).fbW())
        {
          com.tencent.mm.plugin.multitask.ui.a.c.a((com.tencent.mm.plugin.multitask.ui.a.c)localObject1, true, true, false, false, true, false, false, 224);
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
    Object localObject1 = this.VXk;
    Log.i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    com.tencent.mm.compatible.b.g.atI();
    com.tencent.mm.compatible.b.g.atI();
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (((HomeUI)localObject1).VVU != null) && (((HomeUI)localObject1).VVU.isShowing()))
    {
      ((HomeUI)localObject1).VVU.dismiss();
      i = 1;
    }
    while (i != 0)
    {
      AppMethodBeat.o(33319);
      return true;
      if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
      {
        ((HomeUI)localObject1).hGC();
        i = 1;
      }
      else
      {
        localObject2 = ((HomeUI)localObject1).VWg.hHU();
        if ((localObject2 != null) && (((MMFragment)localObject2).onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent))) {
          i = 1;
        } else if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
        {
          if ((bh.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT) && (NetStatusUtil.isWap(((HomeUI)localObject1).zwS)) && (MMAppMgr.h(((HomeUI)localObject1).zwS, new HomeUI.24((HomeUI)localObject1))))
          {
            i = 1;
          }
          else
          {
            i = NetStatusUtil.getBackgroundLimitType(((HomeUI)localObject1).zwS);
            if ((bh.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT) && (NetStatusUtil.isLimited(i)))
            {
              bh.beI();
              if ((Util.nullAsTrue((Boolean)com.tencent.mm.model.c.aHp().b(16385, null))) && (MMAppMgr.a(((HomeUI)localObject1).zwS, i, new HomeUI.25((HomeUI)localObject1, i), new HomeUI.26((HomeUI)localObject1))))
              {
                i = 1;
                continue;
              }
            }
            ((HomeUI)localObject1).hFi();
          }
        }
        else {
          i = 0;
        }
      }
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
    hHb();
    Log.i("MicroMsg.LauncherUI", "checktask Launcherui onfinish 0x%x,instance size %d, stack: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(VXd.size()), Util.getStack() });
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
    for (localObject1 = ((NewChattingTabUI)localObject1).Wdi;; localObject1 = null)
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
    return this.VXk;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(288720);
    HashSet localHashSet = new HashSet();
    localHashSet.addAll(super.importUIComponents());
    localHashSet.add(com.tencent.mm.plugin.multitask.ui.a.c.class);
    AppMethodBeat.o(288720);
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
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 226) || (paramInt1 == 3001) || (paramInt1 == 30762) || (paramInt1 == 1111)) && (((NewChattingTabUI)localObject2).Wdi != null)) {
      ((NewChattingTabUI)localObject2).Wdi.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((NewChattingTabUI.acceptRequestCode(paramInt1)) && (((NewChattingTabUI)localObject2).Wdi == null))
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
      MMHandlerThread.removeRunnable(((NewChattingTabUI)localObject2).Wdk);
      ((NewChattingTabUI)localObject2).Wdk.Wdt = 0;
      ((NewChattingTabUI)localObject2).Wdk.requestCode = paramInt1;
      ((NewChattingTabUI)localObject2).Wdk.resultCode = paramInt2;
      ((NewChattingTabUI)localObject2).Wdk.fJJ = paramIntent;
      MMHandlerThread.postToMainThread(((NewChattingTabUI)localObject2).Wdk);
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(33310);
      return;
    }
    localObject2 = this.VXk;
    if (((HomeUI)localObject2).VVM)
    {
      if (paramInt1 == 1)
      {
        bh.beI();
        if (!Util.nullAsFalse((Boolean)com.tencent.mm.model.c.aHp().b(12323, null))) {
          com.tencent.mm.platformtools.y.showAddrBookUploadConfirm(((HomeUI)localObject2).zwS, null, false, 3);
        }
        AppMethodBeat.o(33310);
        return;
      }
      if (paramInt1 == 22722)
      {
        str1 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null);
        Log.i("MicroMsg.LauncherUI.HomeUI", "showAgreements %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1 });
        if (paramIntent != null) {
          localObject1 = paramIntent.getBundleExtra("result_data");
        }
        if ((localObject1 != null) && (((Bundle)localObject1).getString("go_next", "").equals("agree_privacy")))
        {
          Log.i("MicroMsg.LauncherUI.HomeUI", "agree privacy policy");
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(712L, 4L, 1L, false);
          localObject1 = new com.tencent.mm.plugin.account.bind.a.c(1, str1);
          com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
          if ((com.tencent.mm.az.b.WF(str1)) && (com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VuL, false)))
          {
            Log.i("MicroMsg.LauncherUI.HomeUI", "needbirthday true");
            MMHandlerThread.postToMainThreadDelayed(new HomeUI.28((HomeUI)localObject2), 100L);
          }
        }
      }
      while ((paramInt1 == 65534) && (paramInt2 == -1))
      {
        MMEntryLock.unlock("welcome_page_show");
        n.v(((HomeUI)localObject2).zwS, true);
        MMAppMgr.abF();
        MMAppMgr.bT(((HomeUI)localObject2).zwS);
        ((HomeUI)localObject2).zwS.finish();
        AppMethodBeat.o(33310);
        return;
        Log.i("MicroMsg.LauncherUI.HomeUI", "disagree privacy policy");
        localObject1 = new com.tencent.mm.plugin.account.bind.a.c(2, str1);
        com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(712L, 5L, 1L, false);
        continue;
        if (paramInt1 == 22723)
        {
          String str2 = (String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null);
          localObject1 = str1;
          if (paramIntent != null) {
            localObject1 = paramIntent.getBundleExtra("result_data");
          }
          if (localObject1 != null) {
            if (((Bundle)localObject1).getString("go_next", "").equals("birthdayComfirmOK"))
            {
              Log.i("MicroMsg.LauncherUI.HomeUI", "verify birthday ok");
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VuL, Boolean.FALSE);
            }
            else if (((Bundle)localObject1).getString("go_next", "").equals("gdpr_confirm_logout"))
            {
              Log.i("MicroMsg.LauncherUI.HomeUI", "quit verify birthday after H5-warnning");
              localObject1 = new com.tencent.mm.plugin.account.bind.a.c(2, str2);
              com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(712L, 5L, 1L, false);
            }
          }
        }
      }
      if ((paramInt1 == 30764) && (paramIntent != null))
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("gdpr_auth_location")))
        {
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VvE, Boolean.TRUE);
          com.tencent.mm.pluginsdk.permission.b.b(((HomeUI)localObject2).zwS, "android.permission.ACCESS_FINE_LOCATION", 66);
        }
      }
    }
    AppMethodBeat.o(33310);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(33320);
    Log.i("MicroMsg.LauncherUI", "onBackPressed");
    this.VXk.hGJ();
    AppMethodBeat.o(33320);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(33325);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = this.VXk;
    com.tencent.mm.pluginsdk.h.a(paramConfiguration.zwS, paramConfiguration.contentView);
    AppMethodBeat.o(33325);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33299);
    com.tencent.mm.blink.a.EJ(com.tencent.mm.kernel.i.aHL().kdx);
    if (ar.isDarkMode()) {
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
      MainProcessChecker.aUt(getClass().getName());
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
      paramBundle = VXe.iterator();
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
      localObject3 = VXd.iterator();
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
              break label610;
            }
            Log.e("MicroMsg.LauncherUI", "checktask base activity is not mm, finish! info.baseActivity.getPackageName()  " + paramBundle.baseActivity.getPackageName());
            finish();
            if (Util.getCurrentTaskInfo(this, ((LauncherUI)localObject1).getTaskId()) != null)
            {
              Log.i("MicroMsg.LauncherUI", "checktask startLauncherUI with FLAG_ACTIVITY_NEW_TASK");
              paramBundle = new Intent(this, LauncherUI.class);
              paramBundle.addFlags(268435456);
              paramBundle = new com.tencent.mm.hellhoundlib.b.a().bm(paramBundle);
              com.tencent.mm.hellhoundlib.a.a.b(this, paramBundle.aFh(), "com/tencent/mm/ui/LauncherUI", "checkInstance", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramBundle.sf(0));
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
        label610:
        ((LauncherUI)localObject1).finish();
        VXd.remove(localObject1);
        break;
        if (!VXd.isEmpty())
        {
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = Util.getCurrentTaskInfo(this, i);
          }
          if (paramBundle == null) {
            break label908;
          }
          localObject1 = paramBundle.baseActivity.getClassName();
          localObject2 = paramBundle.baseActivity.getClassName();
          Log.i("MicroMsg.LauncherUI", "checktask now info id %d, topactivity %s, baseactivity %s, numtotal %d, numrunning %d", new Object[] { Integer.valueOf(paramBundle.id), localObject2, localObject1, Integer.valueOf(paramBundle.numActivities), Integer.valueOf(paramBundle.numRunning) });
          localObject3 = getComponentName().getClassName();
          if ((paramBundle.numActivities > 1) && (((String)localObject3).equals(localObject1)) && (((String)localObject3).equals(localObject2)))
          {
            finish();
            Log.w("MicroMsg.LauncherUI", "checktask finish this mainTabUI, and use the last LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(VXd.size()) });
            i = 0;
            continue;
          }
          Log.w("MicroMsg.LauncherUI", "checktask should not here without isWantToRestart is true launcherUIInstances.clear LauncherUI instanceCount: %d, isWantToRestart %b", new Object[] { Integer.valueOf(VXd.size()), Boolean.valueOf(bool1) });
          VXd.clear();
        }
        for (;;)
        {
          VXd.add(this);
          VXe.add(new WeakReference(this));
          Log.i("MicroMsg.LauncherUI", "checktask Launcherui oncreate checkInstance size %d weak check %d, use time %d", new Object[] { Integer.valueOf(VXd.size()), Integer.valueOf(VXe.size()), Long.valueOf(System.currentTimeMillis() - l2) });
          i = 1;
          break;
          label908:
          Log.w("MicroMsg.LauncherUI", "checktask can not found taskid %d,  LauncherUI instanceCount: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(VXd.size()) });
          VXd.clear();
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
    this.VXk = new HomeUI();
    this.chattingTabUI = new NewChattingTabUI(this.VXk);
    this.chattingTabUI.Jvc = this;
    paramBundle = this.VXk;
    localObject1 = this.chattingTabUI;
    paramBundle.zwS = this;
    paramBundle.VWe = ((a)localObject1);
    localObject1 = paramBundle.VWg;
    ((MainTabUI)localObject1).zwS = this;
    ((MainTabUI)localObject1).Wbv = paramBundle;
    Object localObject2 = ((MainTabUI)localObject1).Wbu;
    ((ae)localObject2).zwS = this;
    ((ae)localObject2).WbI = paramBundle;
    ((MainTabUI)localObject1).MnB = paramBundle;
    paramBundle.VWf = new j(this, paramBundle);
    NotifyReceiver.aqz();
    com.tencent.mm.pluginsdk.h.aZ(paramBundle.zwS);
    paramBundle.mActionBar = getSupportActionBar();
    paramBundle.Cwk = findViewById(R.h.action_bar_container);
    if (paramBundle.mActionBar != null)
    {
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.actionbar_bg_color)));
      }
      paramBundle.mActionBar.hide();
    }
    setRequestedOrientation(1);
    paramBundle.VWh = getResources().getColor(R.e.normal_actionbar_color);
    paramBundle.VWi = Color.alpha(paramBundle.VWh);
    paramBundle = bg.ltv.aD("login_user_name", "");
    this.fKs = getIntent();
    localObject1 = this.VXq;
    ((com.tencent.mm.pluginsdk.t)localObject1).QSj = this.fKs.getBooleanExtra("splash-hack-activity-recreate", false);
    Log.i("MicroMsg.SplashOptimizing", "[%s], recreating activity this time? %s", new Object[] { ((com.tencent.mm.pluginsdk.t)localObject1).mTag, Boolean.valueOf(((com.tencent.mm.pluginsdk.t)localObject1).QSj) });
    Log.i("MicroMsg.LauncherUI", "lastLoginName %s, hasCfgDefaultUin %s  isFirstTimeCreate %s", new Object[] { paramBundle, Boolean.valueOf(bh.beJ()), Boolean.valueOf(VXf) });
    if (hHe())
    {
      Log.i("MicroMsg.LauncherUI", "handleExitIntent return");
      AppMethodBeat.o(33299);
      return;
    }
    if ((!VXf) && ((bh.beJ()) || (!paramBundle.equals(""))))
    {
      VXg = l1;
      Log.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop no welcomeearth create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.d.fcc));
    }
    label1631:
    for (;;)
    {
      com.tencent.mm.pluginsdk.model.app.q.n(this, "");
      hHc();
      ar.aN(this);
      com.tencent.mm.plugin.ad.a.c.fnc().fnb();
      this.VXj.alive();
      AppMethodBeat.o(33299);
      return;
      VXg = l1;
      Log.i("MicroMsg.LauncherUI", "start time check not isLauncherUIOnTop create time from mmapplication==" + (System.currentTimeMillis() - com.tencent.mm.app.d.fcc));
      setRequestedOrientation(1);
      bool1 = bh.beJ();
      paramBundle = bg.ltv.aD("login_user_name", "");
      if ((!bool1) && (paramBundle.equals(""))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1525;
        }
        ChannelUtil.isShowingGprsAlert = false;
        break;
      }
      label1525:
      bool1 = false;
      if ((ChannelUtil.shouldShowGprsAlert) && (ChannelUtil.isShowingGprsAlert))
      {
        VXh = true;
        bool1 = MMAppMgr.a(this, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(276238);
            LauncherUI.a(LauncherUI.this);
            LauncherUI.bfm();
            com.tencent.mm.pluginsdk.k.a.a.o.cxi();
            LauncherUI.b(LauncherUI.this);
            AppMethodBeat.o(276238);
          }
        });
      }
      for (;;)
      {
        if (bool1) {
          break label1631;
        }
        Fw(true);
        VXh = false;
        com.tencent.mm.pluginsdk.k.a.a.o.cxi();
        com.tencent.mm.plugin.report.service.g.adc(8);
        hHg();
        Log.i("MicroMsg.LauncherUI", "resumeLogoutJump showLoginSelectUI hashCode[%d]", new Object[] { Integer.valueOf(hashCode()) });
        MMHandlerThread.removeRunnable(this.VXu);
        MMHandlerThread.postToMainThreadDelayed(this.VXu, 2000L);
        break;
        MMAppMgr.kQ(this);
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(33324);
    if (this.chattingTabUI.fcI())
    {
      AppMethodBeat.o(33324);
      return false;
    }
    HomeUI localHomeUI = this.VXk;
    if ((localHomeUI.VWe == null) || (localHomeUI.VWe.fcI()))
    {
      if (localHomeUI.VWe == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.LauncherUI.HomeUI", "unCreateOptionsMenu, %b, %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localHomeUI.VWe.fcI()) });
        AppMethodBeat.o(33324);
        return false;
      }
    }
    localHomeUI.VWz = paramMenu;
    int i = localHomeUI.zwS.getSupportActionBar().getHeight();
    int j = com.tencent.mm.ci.a.aZ(localHomeUI.zwS, R.f.Edge_5A);
    if ((localHomeUI.VWg.iU == 3) && (com.tencent.mm.plugin.story.api.o.isShowStoryCheck()) && (!com.tencent.mm.plugin.textstatus.a.t.gkZ()) && ((!ar.hIH()) || (!ar.hIN())))
    {
      localHomeUI.VWy = paramMenu.add(0, 5, 0, R.l.top_item_desc_send_story);
      if (localHomeUI.VWu == null)
      {
        com.tencent.mm.kiss.a.b.aIK();
        localHomeUI.VWu = com.tencent.mm.kiss.a.b.d(localHomeUI.zwS, R.i.actionview_with_dot_tips);
        paramMenu = new ViewGroup.LayoutParams(j, i);
        localHomeUI.VWu.setLayoutParams(paramMenu);
        localHomeUI.VWu.setMinimumHeight(i);
        localHomeUI.VWu.setMinimumWidth(j);
        localHomeUI.VWu.setOnLongClickListener(new HomeUI.6(localHomeUI));
        localHomeUI.VWu.setOnClickListener(new HomeUI.7(localHomeUI));
        localHomeUI.VWu.setContentDescription(localHomeUI.getString(R.l.top_item_desc_send_story));
      }
      if (localHomeUI.VWk)
      {
        localHomeUI.VWu.findViewById(R.h.tips).setVisibility(0);
        paramMenu = com.tencent.mm.plugin.story.h.h.LOJ;
        com.tencent.mm.plugin.story.h.h.RN(1L);
      }
      for (;;)
      {
        localHomeUI.VWy.setActionView(localHomeUI.VWu);
        localHomeUI.hGO();
        localHomeUI.hGD();
        Log.v("MicroMsg.LauncherUI.HomeUI", "onCreateOptionsMenu");
        AppMethodBeat.o(33324);
        return true;
        localHomeUI.VWu.findViewById(R.h.tips).setVisibility(8);
        paramMenu = com.tencent.mm.plugin.story.h.h.LOJ;
        com.tencent.mm.plugin.story.h.h.RN(0L);
      }
    }
    Object localObject;
    if (i == 0)
    {
      localObject = localHomeUI.zwS.getResources().getDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels > ((DisplayMetrics)localObject).heightPixels) {
        i = localHomeUI.zwS.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
      }
    }
    for (;;)
    {
      localHomeUI.VWv = paramMenu.add(0, HomeUI.VWn, 0, R.l.top_item_desc_search);
      localHomeUI.VWv.setIcon(R.k.actionbar_icon_dark_search);
      if (localHomeUI.VQV) {
        localHomeUI.VWv.setIcon(R.k.actionbar_icon_light_search);
      }
      if (localHomeUI.VRl == null)
      {
        localObject = new ViewGroup.LayoutParams(j, i);
        com.tencent.mm.kiss.a.b.aIK();
        localHomeUI.VRl = com.tencent.mm.kiss.a.b.d(localHomeUI.zwS, R.i.actionview_with_dot_tips);
        localHomeUI.VWt = ((ImageView)localHomeUI.VRl.findViewById(R.h.icon));
        localHomeUI.VRl.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localHomeUI.VRl.setMinimumHeight(i);
        localHomeUI.VRl.setMinimumWidth(j);
        localHomeUI.VWt.setImageResource(R.k.actionbar_icon_dark_search);
        localHomeUI.VWt.setImageDrawable(au.e(localHomeUI.zwS.getResources().getDrawable(R.k.actionbar_icon_dark_search), localHomeUI.zwS.getResources().getColor(R.e.FG_0)));
        localHomeUI.VRl.setContentDescription(localHomeUI.getString(R.l.top_item_desc_search));
        localHomeUI.VRl.setOnLongClickListener(new HomeUI.8(localHomeUI));
        localHomeUI.VRl.setOnClickListener(new HomeUI.9(localHomeUI));
        localHomeUI.VRl.post(new HomeUI.10(localHomeUI));
      }
      localHomeUI.VWv.setActionView(localHomeUI.VRl);
      localHomeUI.VWw = paramMenu.add(0, HomeUI.VWo, 0, R.l.top_item_desc_more);
      if (localHomeUI.VWq == null) {
        localHomeUI.VWp = new HomeUI.b(localHomeUI, j, i);
      }
      if (com.tencent.mm.kernel.h.aHE().aGM()) {
        com.tencent.mm.plugin.newtips.a.fiO().h(localHomeUI.VWp);
      }
      if ((localHomeUI.VQV) && (localHomeUI.VWr != null)) {
        localHomeUI.VWr.getDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
      }
      com.tencent.mm.blink.b.aqa().arrange(new HomeUI.11(localHomeUI));
      localHomeUI.VWw.setActionView(localHomeUI.VWq);
      localHomeUI.hGD();
      localHomeUI.VWq.getLayoutParams().width = j;
      localHomeUI.VWq.getLayoutParams().height = i;
      break;
      i = localHomeUI.zwS.getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33314);
    com.tencent.mm.blink.a.apV();
    super.onDestroy();
    Object localObject = this.VXk;
    ((HomeUI)localObject).VWg.hHV();
    if (((HomeUI)localObject).VWf != null)
    {
      j localj = ((HomeUI)localObject).VWf;
      EventCenter.instance.removeListener(localj.VVw);
      EventCenter.instance.removeListener(localj.VVx);
    }
    if (((HomeUI)localObject).VVM) {
      Looper.myQueue().removeIdleHandler(((HomeUI)localObject).sJE);
    }
    EventCenter.instance.removeListener(((HomeUI)localObject).VWB);
    localObject = this.chattingTabUI;
    if ((((NewChattingTabUI)localObject).mPrepareBitmap != null) && (!((NewChattingTabUI)localObject).mPrepareBitmap.isRecycled()))
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", new Object[] { ((NewChattingTabUI)localObject).mPrepareBitmap.toString() });
      ((NewChattingTabUI)localObject).mPrepareBitmap.recycle();
    }
    MMHandlerThread.removeRunnable(((NewChattingTabUI)localObject).mStartChattingRunnable);
    Looper.myQueue().removeIdleHandler(((NewChattingTabUI)localObject).Wdd);
    if (this.VXp != null)
    {
      localObject = this.VXp;
      Log.i("MicroMsg.HKOfflineLogic", "doOnDestroy");
      ((com.tencent.mm.plugin.wallet_index.c.b)localObject).mContext = null;
      ((com.tencent.mm.plugin.wallet_index.c.b)localObject).mLP = null;
      ((com.tencent.mm.plugin.wallet_index.c.b)localObject).Pjq = false;
      ((com.tencent.mm.plugin.wallet_index.c.b)localObject).Pjr = null;
      com.tencent.mm.kernel.h.aGY().b(2540, (com.tencent.mm.an.i)localObject);
      this.VXp = null;
    }
    this.VXi.dead();
    this.VXj.dead();
    hHb();
    Log.i("MicroMsg.LauncherUI", "checktask onDestroy 0x%x, taskid %d, task:%s, instancesize %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), Util.getActivityTaskInfo(this), Integer.valueOf(VXd.size()) });
    AppMethodBeat.o(33314);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(33331);
    super.onMultiWindowModeChanged(paramBoolean);
    Log.i("MicroMsg.LauncherUI", "alvinluo onMultiWindowModeChanged2 isInMultiWindowMode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    nm localnm = new nm();
    localnm.fLR.fLS = paramBoolean;
    EventCenter.instance.publish(localnm);
    AppMethodBeat.o(33331);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(33301);
    Log.i("MicroMsg.LauncherUI", "onNewIntent 0x%x task:%s", new Object[] { Integer.valueOf(hashCode()), Util.getActivityTaskInfo(this) });
    this.fKs = paramIntent;
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if ((this.fKs != null) && (IntentUtil.getBooleanExtra(this.fKs, "LauncherUI.jump_from_uimode_check", false)))
    {
      Log.i("MicroMsg.LauncherUI", "dancy onNewIntent uimode check from background, finish LauncherUI");
      finish();
      AppMethodBeat.o(33301);
      return;
    }
    com.tencent.mm.pluginsdk.model.app.q.n(this, "");
    if (hHe())
    {
      Log.i("MicroMsg.LauncherUI", "onNewIntent handleExitIntent");
      AppMethodBeat.o(33301);
      return;
    }
    if ((this.fKs != null) && (IntentUtil.getBooleanExtra(this.fKs, "Intro_Need_Clear_Top ", false)))
    {
      Log.d("MicroMsg.LauncherUI", "KEVIN KNeedClearTop");
      finish();
      kH(this);
      AppMethodBeat.o(33301);
      return;
    }
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      closeChatting(false);
    }
    MainTabUI localMainTabUI = this.VXk.VWg;
    if ((paramIntent.getFlags() & 0x4000000) == 67108864) {
      localMainTabUI.Wbw = true;
    }
    if (this.VXm)
    {
      Log.v("MicroMsg.LauncherUI", "onMainTabNewIntent on new intent");
      bz(paramIntent);
    }
    com.tencent.mm.plugin.ad.a.c.fnc().fnb();
    AppMethodBeat.o(33301);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int j = 0;
    AppMethodBeat.i(33323);
    HomeUI localHomeUI = this.VXk;
    Object localObject = localHomeUI.zwS.getCurrentFragmet();
    int i;
    if ((localObject != null) && (((MMFragment)localObject).isShowing())) {
      i = j;
    }
    while (i != 0)
    {
      AppMethodBeat.o(33323);
      return true;
      i = j;
      if (!localHomeUI.VWe.fcI())
      {
        if (paramMenuItem.getItemId() == HomeUI.VWo)
        {
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10919, "0");
          localHomeUI.hGC();
        }
        for (;;)
        {
          i = 1;
          break;
          if (paramMenuItem.getItemId() == HomeUI.VWn)
          {
            localHomeUI.hGE();
          }
          else
          {
            i = j;
            if (paramMenuItem.getItemId() != 5) {
              break;
            }
            if ((CrashReportFactory.hasDebuger()) || (ac.mGK))
            {
              localObject = new m(localHomeUI.zwS);
              ((m)localObject).ODT = new HomeUI.13(localHomeUI);
              ((m)localObject).ODU = new HomeUI.14(localHomeUI);
              ((m)localObject).hYu();
            }
            else
            {
              localHomeUI.hGF();
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
    Object localObject = this.VXq;
    boolean bool = ((com.tencent.mm.pluginsdk.t)localObject).gz("onPause");
    if (bool) {
      ((com.tencent.mm.pluginsdk.t)localObject).QSj = false;
    }
    if (bool)
    {
      Log.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onPause");
      AppMethodBeat.o(33311);
      return;
    }
    com.tencent.mm.blink.a.apV();
    Log.i("MicroMsg.LauncherUI", "not skip this onPause");
    localObject = getCurrentFragmet();
    this.VXt.removeCallbacksAndMessages(null);
    if (!ar.hIH())
    {
      this.VXk.fMw();
      this.chattingTabUI.fMw();
    }
    if (localObject != null)
    {
      AppMethodBeat.o(33311);
      return;
    }
    this.VXn = false;
    localObject = r.VcW;
    r.hvY();
    AppMethodBeat.o(33311);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(33313);
    this.VXs = false;
    Object localObject;
    if (!this.VXl.a(this, paramInt, paramArrayOfString, paramArrayOfInt))
    {
      localObject = this.VXk;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      localObject = this.chattingTabUI;
      if (((NewChattingTabUI)localObject).Wdi != null) {
        ((NewChattingTabUI)localObject).Wdi.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      }
      AppMethodBeat.o(33313);
      return;
      if (paramInt == 80) {}
      for (int i = R.l.permission_microphone_request_again_msg; paramArrayOfInt[0] != 0; i = R.l.permission_camera_request_again_msg)
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).zwS, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(R.l.permission_tips_title), ((HomeUI)localObject).getString(R.l.jump_to_settings), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.29((HomeUI)localObject), new HomeUI.30((HomeUI)localObject));
        break;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ((HomeUI)localObject).hGE();
      }
      else
      {
        com.tencent.mm.ui.base.h.a(((HomeUI)localObject).zwS, ((HomeUI)localObject).getString(R.l.permission_location_request_again_msg), ((HomeUI)localObject).getString(R.l.permission_tips_title), ((HomeUI)localObject).getString(R.l.jump_to_settings), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.31((HomeUI)localObject), null);
        continue;
        if (paramArrayOfInt[0] == 0)
        {
          localObject = ((HomeUI)localObject).VWg.hHU();
          if ((localObject instanceof FindMoreFriendsUI)) {
            ((FindMoreFriendsUI)localObject).hGf();
          }
        }
        else
        {
          com.tencent.mm.ui.base.h.a(((HomeUI)localObject).zwS, ((HomeUI)localObject).getString(R.l.permission_location_request_again_msg), ((HomeUI)localObject).getString(R.l.permission_tips_title), ((HomeUI)localObject).getString(R.l.jump_to_settings), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.32((HomeUI)localObject), null);
          continue;
          if (paramArrayOfInt[0] == 0)
          {
            ((HomeUI)localObject).hGF();
          }
          else
          {
            if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
            for (i = R.l.permission_camera_request_again_msg;; i = R.l.permission_microphone_request_again_msg)
            {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).zwS, ((HomeUI)localObject).getString(i), ((HomeUI)localObject).getString(R.l.permission_tips_title), ((HomeUI)localObject).getString(R.l.jump_to_settings), ((HomeUI)localObject).getString(R.l.app_cancel), false, new HomeUI.33((HomeUI)localObject), new HomeUI.35((HomeUI)localObject));
              break;
            }
            if (paramArrayOfInt[0] == 0) {
              ((HomeUI)localObject).hGF();
            } else {
              com.tencent.mm.ui.base.h.a(((HomeUI)localObject).zwS, ((HomeUI)localObject).getString(R.l.permission_location_request_again_msg), ((HomeUI)localObject).getString(R.l.permission_tips_title), ((HomeUI)localObject).getString(R.l.jump_to_settings), ((HomeUI)localObject).getString(R.l.cancel), false, new HomeUI.36((HomeUI)localObject), null);
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
    localNewChattingTabUI.Wdf = paramBundle.getString("last_restore_talker");
    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "onRestoreInstanceState:%s", new Object[] { localNewChattingTabUI.Wdf });
    this.VXv = paramBundle.getBoolean("last_stay_chatting");
    this.VXw = paramBundle.getInt("last_stay_tab");
    if (this.VXv) {
      this.chattingTabUI.startChatting(this.chattingTabUI.Wdf, null, false);
    }
    AppMethodBeat.o(33321);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33303);
    Log.i("MicroMsg.LauncherUI", "onResume %s", new Object[] { Integer.valueOf(hashCode()) });
    super.onResume();
    if (this.VXq.gz("onResume"))
    {
      Log.i("MicroMsg.LauncherUI", "recreate activity %s, skip this onResume");
      AppMethodBeat.o(33303);
      return;
    }
    Log.i("MicroMsg.LauncherUI", "not skip this onResume");
    VXf = false;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    long l1;
    Object localObject4;
    Object localObject5;
    label847:
    int i;
    Object localObject6;
    long l2;
    if (hHd())
    {
      Log.i("MicroMsg.LauncherUI", "doOnResumeImp notSwitchorHold, hasDoInit:%b", new Object[] { Boolean.valueOf(this.VXm) });
      if (!bh.aHB())
      {
        Log.w("MicroMsg.LauncherUI", "accHasNotReady, kill self");
        finish();
        Log.i("MicroMsg.LauncherUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
        localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/LauncherUI", "onResume", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/LauncherUI", "onResume", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(33303);
        return;
      }
      if (!this.VXm)
      {
        this.VXm = true;
        localObject1 = this.VXk;
        Log.i("MicroMsg.LauncherUI.HomeUI", "doOnCreate");
        if ((HomeUI.hGP()) && (HomeUI.hGQ()))
        {
          bool1 = true;
          ((HomeUI)localObject1).VWk = bool1;
          localObject2 = ((HomeUI)localObject1).VWf;
          EventCenter.instance.addListener(((j)localObject2).VVw);
          EventCenter.instance.addListener(((j)localObject2).VVx);
          if (!com.tencent.mm.ui.conversation.b.hVU()) {
            getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
          }
          localObject2 = ((HomeUI)localObject1).zwS.getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.avK());
          if (((SharedPreferences)localObject2).getBoolean("first_launch_weixin", true))
          {
            ((SharedPreferences)localObject2).edit().putBoolean("first_launch_weixin", false).commit();
            XLogSetup.realSetupXlog();
          }
          ((HomeUI)localObject1).VVU = new ah(this);
          ((HomeUI)localObject1).VVM = true;
          NotifyReceiver.aqB();
          bh.getNotification().qh(1);
          if (bh.aHB()) {
            break label2882;
          }
          Log.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready, finish launcherui");
          ((HomeUI)localObject1).zwS.finish();
          bz(getIntent());
        }
      }
      else
      {
        localObject1 = this.VXk;
        l1 = Util.nowMilliSecond();
        localObject2 = ((HomeUI)localObject1).VWg;
        bool1 = ((HomeUI)localObject1).VWe.fcI();
        Log.i("MicroMsg.LauncherUI.MainTabUI", "onResume start :%d, chattingShow:%s", new Object[] { Integer.valueOf(((MainTabUI)localObject2).iU), Boolean.valueOf(bool1) });
        if (((MainTabUI)localObject2).WbG.size() != 0)
        {
          localObject4 = ((MainTabUI)localObject2).auc(((MainTabUI)localObject2).iU);
          Log.i("MicroMsg.LauncherUI.MainTabUI", "notifyCurrentTabResumeUI, mCurIndex:%s", new Object[] { Integer.valueOf(((MainTabUI)localObject2).iU) });
          if (localObject4 != null) {
            ((o)localObject4).hFl();
          }
          if ((localObject4 != null) && (com.tencent.matrix.b.Vt()) && (((MMFragment)localObject4).getActivity() != null))
          {
            localObject5 = ((MMFragment)localObject4).getActivity().getClass().getName();
            com.tencent.matrix.a.cQs.eH((String)localObject5 + "#" + localObject4.getClass().getSimpleName());
          }
        }
        if ((((MainTabUI)localObject2).Wbw) && (((MainTabUI)localObject2).zwS.getIntent().hasExtra("isScrollFirst")) && (((MainTabUI)localObject2).zwS.getIntent().hasExtra("isShowHeader")))
        {
          localObject4 = (MainUI)((MainTabUI)localObject2).WbG.get(Integer.valueOf(0));
          if (localObject4 != null)
          {
            bool2 = ((MainTabUI)localObject2).zwS.getIntent().getBooleanExtra("isShowHeader", false);
            boolean bool3 = ((MainTabUI)localObject2).zwS.getIntent().getBooleanExtra("isScrollFirst", true);
            ((MainUI)localObject4).o(bool2, ((MainTabUI)localObject2).zwS.getIntent().getBooleanExtra("isShowHeaderWithAnim", false), bool3);
          }
        }
        if (((MainTabUI)localObject2).Wbw)
        {
          ((MainTabUI)localObject2).Wbw = false;
          ((MainTabUI)localObject2).byt("tab_main");
        }
        localObject4 = (MainUI)((MainTabUI)localObject2).WbG.get(Integer.valueOf(0));
        if (localObject4 != null)
        {
          ((MainUI)localObject4).hUj();
          ((MainUI)localObject4).hWv();
        }
        if ((((MainTabUI)localObject2).iU != 0) || (bool1)) {
          break label3912;
        }
        bh.getNotification().dH(true);
        localObject4 = (o)((MainTabUI)localObject2).auc(((MainTabUI)localObject2).iU);
        if (localObject4 != null) {
          ((o)localObject4).hFm();
        }
        ((MainTabUI)localObject2).Wbw = false;
        i = IntentUtil.getIntExtra(((MainTabUI)localObject2).zwS.getIntent(), "preferred_tab", 0);
        Log.d("MicroMsg.LauncherUI.MainTabUI", "doOnResume, tabIdx = %d", new Object[] { Integer.valueOf(i) });
        if (i != 0)
        {
          ((MainTabUI)localObject2).aub(i);
          ((MainTabUI)localObject2).zwS.getIntent().putExtra("preferred_tab", 0);
        }
        EventCenter.instance.addListener(((MainTabUI)localObject2).WbB);
        EventCenter.instance.addListener(((MainTabUI)localObject2).WbD);
        EventCenter.instance.addListener(((MainTabUI)localObject2).WbE);
        localObject2 = ((MainTabUI)localObject2).Wbu;
        if (((ae)localObject2).WbJ != null) {
          ((ae)localObject2).WbJ.hFw();
        }
        if (bh.aHB())
        {
          bh.beI();
          com.tencent.mm.model.c.aHp().add(((ae)localObject2).WbO);
          com.tencent.mm.aa.c.aFn().a(((ae)localObject2).WbN);
          bh.beI();
          com.tencent.mm.model.c.bbR().add((MStorageEx.IOnStorageChange)localObject2);
          EventCenter.instance.addListener(((ae)localObject2).VUf);
          EventCenter.instance.addListener(((ae)localObject2).WbP);
          EventCenter.instance.addListener(((ae)localObject2).VUe);
        }
        com.tencent.mm.blink.b.aqa().arrange(new ae.7((ae)localObject2));
        localObject2 = ((HomeUI)localObject1).VWf;
        localObject6 = new bp();
        EventCenter.instance.publish((IEvent)localObject6);
        if ((((bp)localObject6).fxs.fxt) && (!Util.isNullOrNil(((bp)localObject6).fxs.msg)))
        {
          Log.i("MicroMsg.LauncherUI.GlobalAlertMgr", "  now show msg:%s", new Object[] { ((bp)localObject6).fxs.msg });
          localObject4 = new f.a(((j)localObject2).zwS);
          localObject5 = ((f.a)localObject4).aR(((j)localObject2).getString(R.l.app_updated_title)).aS(((j)localObject2).getString(R.l.app_updated_new_feature));
          localObject6 = ((bp)localObject6).fxs.msg;
          ((f.a)localObject5).RfU.bBe((String)localObject6);
          localObject4 = ((f.a)localObject4).HL(false).b(new j.2((j)localObject2));
          ((f.a)localObject4).Qlf = true;
          ((f.a)localObject4).show();
        }
        if (!((j)localObject2).a(((j)localObject2).VVs)) {
          bh.aHJ().postToWorkerDelayed(new j.6((j)localObject2), 500L);
        }
        ((j)localObject2).VVs = null;
        CrashReportFactory.setForeground(true);
        bool1 = ((HomeUI)localObject1).VWe.fcI();
        if ((!bool1) && (bh.aHB()))
        {
          com.tencent.mm.blink.b.aqa().arrange(new HomeUI.41((HomeUI)localObject1));
          if ((com.tencent.mm.bk.d.meW != null) && (com.tencent.mm.bk.d.meV != null) && (!Util.isNullOrNil(com.tencent.mm.bk.d.meV.bpZ())))
          {
            Log.i("MicroMsg.LauncherUI.HomeUI", "launcher onResume end track %s", new Object[] { com.tencent.mm.bk.d.meW.bqa() });
            localObject2 = new fv();
            ((fv)localObject2).fBE.username = com.tencent.mm.bk.d.meW.bqa();
            EventCenter.instance.publish((IEvent)localObject2);
          }
        }
        if (!bool1)
        {
          l.a(((HomeUI)localObject1).zwS, 3, ((HomeUI)localObject1).VWg.iU, "directReport_onResume");
          ((HomeUI)localObject1).VWg.atY(260);
        }
        com.tencent.mm.ui.widget.j.b(((HomeUI)localObject1).zwS);
        ((HomeUI)localObject1).zwS.onSwipe(1.0F);
        ((HomeUI)localObject1).VWd = HomeUI.a.VWR;
        if (((HomeUI)localObject1).VVO)
        {
          ((HomeUI)localObject1).VVO = false;
          ((HomeUI)localObject1).VVO = false;
        }
        com.tencent.mm.am.p.bhL();
        l2 = System.currentTimeMillis();
        Log.w("MicroMsg.LauncherUI.HomeUI", "[Launching Application]");
        n.v(((HomeUI)localObject1).zwS, false);
        n.w(((HomeUI)localObject1).zwS, false);
        long l3 = System.currentTimeMillis();
        bool1 = ((HomeUI)localObject1).zwS.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("settings_landscape_mode", false);
        localObject2 = com.tencent.mm.ui.component.g.Xox;
        boolean bool2 = ((com.tencent.mm.plugin.multitask.ui.a.c)com.tencent.mm.ui.component.g.b(((HomeUI)localObject1).zwS).i(com.tencent.mm.plugin.multitask.ui.a.c.class)).fbW();
        if ((!bool1) || (bool2)) {
          break label3924;
        }
        ((HomeUI)localObject1).zwS.setRequestedOrientation(-1);
        label1614:
        long l4 = System.currentTimeMillis();
        if (getInstance() != null)
        {
          com.tencent.mm.blink.b.aqa().aqd();
          ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("showprivacypolicy", ((HomeUI)localObject1).VWG);
          ((HomeUI)localObject1).Fr(false);
          EventCenter.instance.addListener(((HomeUI)localObject1).Jcp);
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onResume:" + (System.currentTimeMillis() - l4));
          if (bh.aHB()) {
            ((HomeUI)localObject1).hGO();
          }
        }
        Log.v("MicroMsg.LauncherUI.HomeUI", "KEVIN dispatch resume " + (System.currentTimeMillis() - l3));
        Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN LaucherUI lauch last : " + (System.currentTimeMillis() - l2));
        Log.i("MicroMsg.LauncherUI.HomeUI", "initView " + (System.currentTimeMillis() - l1));
        if (((HomeUI)localObject1).VVO)
        {
          ((HomeUI)localObject1).VVO = false;
          ((HomeUI)localObject1).VVO = false;
        }
        localObject2 = w.aaZ();
        ((w)localObject2).fdB = true;
        ((w)localObject2).fdC.removeMessages(-1999);
        ((w)localObject2).fdC.removeMessages(-2999);
        Log.i("MicroMsg.LauncherUI.HomeUI", "start time check LauncherUI Launcher onResume end: " + (System.currentTimeMillis() - l1));
        if (com.tencent.mm.model.z.bdS().booleanValue()) {
          ((HomeUI)localObject1).hGB();
        }
        i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vxm, 0);
        if (i != 0)
        {
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vxm, Integer.valueOf(0));
          if (com.tencent.mm.model.z.bdH()) {}
        }
        switch (i)
        {
        default: 
          label1952:
          com.tencent.mm.blink.b.aqa().arrange(new HomeUI.2((HomeUI)localObject1));
          if (((HomeUI)localObject1).getMainTabUI().iU != 3)
          {
            localObject1 = (MoreTabUI)((HomeUI)localObject1).getMainTabUI().auc(3);
            if ((((MoreTabUI)localObject1).WbV != null) && (!((MoreTabUI)localObject1).WbV.isVisible))
            {
              ((MoreTabUI)localObject1).WbV.idf();
              ((MoreTabUI)localObject1).fqb();
            }
          }
          localObject1 = this.chattingTabUI;
          ((NewChattingTabUI)localObject1).Wda = Util.nowSecond();
          if (((NewChattingTabUI)localObject1).hIs())
          {
            ((NewChattingTabUI)localObject1).Wdd = new NewChattingTabUI.1((NewChattingTabUI)localObject1);
            MMHandlerThread.postToMainThreadDelayed(new NewChattingTabUI.2((NewChattingTabUI)localObject1), 500L);
          }
          if (((NewChattingTabUI)localObject1).fcI())
          {
            ((NewChattingTabUI)localObject1).rE(3);
            if ((((NewChattingTabUI)localObject1).Wdi != null) && (((NewChattingTabUI)localObject1).Wdi.isSupportNavigationSwipeBack())) {
              ((NewChattingTabUI)localObject1).Wdi.getSwipeBackLayout().setEnableGesture(true);
            }
            label2121:
            Log.i("MicroMsg.LauncherUI", "resumeNormalJump");
            MMFragmentActivity.a.hHS();
            if (("pushcontent_notification".equals(IntentUtil.getStringExtra(getIntent(), "nofification_type"))) && (!Util.isNullOrNil(IntentUtil.getStringExtra(getIntent(), "Main_FromUserName"))))
            {
              localObject1 = IntentUtil.getStringExtra(getIntent(), "Main_FromUserName");
              i = IntentUtil.getIntExtra(getIntent(), "MainUI_User_Last_Msg_Type", 0);
              Log.e("MicroMsg.LauncherUI", "launch report, fromUserName = %s, msgType = %d" + (String)localObject1 + i);
              com.tencent.mm.plugin.report.service.h.IzE.a(10856, new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(0) });
            }
            localObject1 = IntentUtil.getStringExtra(getIntent(), "LauncherUI.Shortcut.LaunchType");
            if (localObject1 != null)
            {
              if (!((String)localObject1).equals("launch_type_voip")) {
                break label4011;
              }
              Log.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIP");
              localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
              com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.plugin.report.service.h.IzE.a(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
            }
            label2414:
            localObject1 = IntentUtil.getStringExtra(getIntent(), "LauncherUI.switch.tab");
            if (!Util.isNullOrNil((String)localObject1))
            {
              this.VXk.getMainTabUI().byt((String)localObject1);
              getIntent().putExtra("LauncherUI.switch.tab", "");
            }
            if ((IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.From.Scaner.Shortcut", false)) || (this.VXo))
            {
              this.VXo = false;
              localObject1 = getInstance();
              if (localObject1 != null) {
                ((LauncherUI)localObject1).VXk.hGH();
              }
              getIntent().putExtra("LauncherUI.From.Scaner.Shortcut", false);
              getIntent().putExtra("LauncherUI.switch.tab", "tab_find_friend");
            }
            bool1 = IntentUtil.getBooleanExtra(getIntent(), "LauncherUI.From.Biz.Shortcut", false);
            if (!bool1) {
              break label4923;
            }
            localObject1 = IntentUtil.getStringExtra(getIntent(), "LauncherUI.Shortcut.Username");
            label2558:
            if (bool1)
            {
              Log.d("MicroMsg.LauncherUI", "launch, fromBizShortcut, bizUsername = ".concat(String.valueOf(localObject1)));
              if (!Util.isNullOrNil((String)localObject1))
              {
                localObject4 = com.tencent.mm.plugin.base.model.b.aoE((String)localObject1);
                if (!Util.isNullOrNil((String)localObject4))
                {
                  if (ab.Ql((String)localObject4))
                  {
                    Log.d("MicroMsg.LauncherUI", "launch, username is contact, go to chattingui");
                    if (!com.tencent.mm.ao.g.UA((String)localObject4)) {
                      break label5238;
                    }
                    if (!com.tencent.mm.ao.g.KI((String)localObject4)) {
                      break label4947;
                    }
                    localObject1 = new Intent();
                    ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.bizchat.BizChatConversationUI");
                    ((Intent)localObject1).putExtra("Contact_User", (String)localObject4);
                    ((Intent)localObject1).putExtra("biz_chat_from_scene", 9);
                    ((Intent)localObject1).addFlags(67108864);
                    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
                    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
                    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  }
                  getIntent().putExtra("LauncherUI_From_Biz_Shortcut", false);
                  getIntent().putExtra("LauncherUI.From.Biz.Shortcut", false);
                }
              }
            }
            label2759:
            this.VXn = true;
            label2788:
            com.tencent.mm.blink.a.qd(5);
            if (!VXh) {
              Fw(false);
            }
            hHc();
            localObject1 = (com.tencent.mm.plugin.ball.c.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.ball.c.b.class);
            if (localObject1 == null) {
              break label5273;
            }
            Log.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, try to fix");
            ((com.tencent.mm.plugin.ball.c.b)localObject1).cva();
          }
          break;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).eBH();
        com.tencent.mm.plugin.base.stub.f.cxp();
        this.VXi.alive();
        com.tencent.mm.blink.a.JB("LauncherUI");
        AppMethodBeat.o(33303);
        return;
        bool1 = false;
        break;
        label2882:
        Log.d("MicroMsg.LauncherUI.HomeUI", "on main tab create");
        l1 = System.currentTimeMillis();
        l2 = System.currentTimeMillis();
        MMActivity.initLanguage(((HomeUI)localObject1).zwS);
        try
        {
          localObject2 = new HashSet();
          localObject4 = ((HomeUI)localObject1).getString(R.l.country_others).split(";");
          ((Set)localObject2).add(localObject4[0]);
          ((Set)localObject2).add(localObject4[1]);
          aa.f((Set)localObject2);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHJ().postToWorker(new HomeUI.17((HomeUI)localObject1));
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initLanguage: " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).mYa = ((LayoutInflater)((HomeUI)localObject1).zwS.getSystemService("layout_inflater"));
          l2 = System.currentTimeMillis();
          com.tencent.mm.kiss.a.b.aIK();
          ((HomeUI)localObject1).contentView = com.tencent.mm.kiss.a.b.d(((HomeUI)localObject1).zwS, R.i.eit);
          if ((((HomeUI)localObject1).contentView != null) && (Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.isMIUIV8())) {
            ((HomeUI)localObject1).contentView.setBackgroundColor(((HomeUI)localObject1).zwS.getResources().getColor(R.e.normal_actionbar_color));
          }
          com.tencent.mm.blink.b.aqa().aqb();
          ((FirstScreenFrameLayout)((HomeUI)localObject1).contentView.findViewById(R.h.dHc)).iPb = new HomeUI.23((HomeUI)localObject1);
          com.tencent.mm.pluginsdk.model.app.ao.hhG();
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate inflater.inflate(R.layout.main_tab, null);" + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).zwS.setContentView(((HomeUI)localObject1).contentView);
          Looper.myQueue().addIdleHandler(((HomeUI)localObject1).sJE);
          ((HomeUI)localObject1).VVN = true;
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate initView(); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN handleJump(getIntent()); " + (System.currentTimeMillis() - l2));
          l2 = System.currentTimeMillis();
          Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN syncAddrBookAndUpload checkLastLbsroomAndQuitIt " + (System.currentTimeMillis() - l2));
          ((HomeUI)localObject1).initActionBar();
          ((HomeUI)localObject1).mActionBar.show();
          ((HomeUI)localObject1).contentView.post(new HomeUI.34((HomeUI)localObject1));
          Log.v("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onCreate : " + (System.currentTimeMillis() - l1));
          MMHandlerThread.postToMainThreadDelayed(new HomeUI.38((HomeUI)localObject1), 2000L);
          ((HomeUI)localObject1).contentView.addOnLayoutChangeListener(((HomeUI)localObject1).VWm);
          com.tencent.mm.pluginsdk.h.a(((HomeUI)localObject1).zwS, ((HomeUI)localObject1).contentView);
          ((HomeUI)localObject1).contentView.postDelayed(new HomeUI.39((HomeUI)localObject1), 20L);
          az.kK(MMApplicationContext.getContext());
          az.atQ(1);
          u.kK(MMApplicationContext.getContext());
          u.atQ(1);
          EventCenter.instance.addListener(((HomeUI)localObject1).VWB);
          localObject5 = ((HomeUI)localObject1).VWg;
          Log.i("MicroMsg.LauncherUI.MainTabUI", "doOnCreate");
          ((MainTabUI)localObject5).mViewPager = ((CustomViewPager)((MainTabUI)localObject5).zwS.findViewById(R.h.pager));
          ((MainTabUI)localObject5).mViewPager.setOffscreenPageLimit(4);
          ((MainTabUI)localObject5).setCanSlide(true);
          ((MainTabUI)localObject5).mViewPager.setCanSlideBySide(false);
          ((MainTabUI)localObject5).mTabsAdapter = new MainTabUI.TabsAdapter((MainTabUI)localObject5, ((MainTabUI)localObject5).zwS, ((MainTabUI)localObject5).mViewPager);
          if (getInstance() != null)
          {
            ((MainTabUI)localObject5).aub(getInstance().VXw);
            localObject2 = ((MainTabUI)localObject5).Wbu;
            localObject4 = (ViewGroup)((MainTabUI)localObject5).mViewPager.getParent();
            localObject5 = ((MainTabUI)localObject5).mTabsAdapter;
            localObject6 = ((ae)localObject2).WbJ;
            if (((ae)localObject2).WbJ != null)
            {
              ((ae)localObject2).WbJ.setOnTabClickListener(null);
              ((View)((ae)localObject2).WbJ).setVisibility(8);
              if (localObject4 != null) {
                ((ViewGroup)localObject4).removeView((View)((ae)localObject2).WbJ);
              }
            }
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
            LauncherUIBottomTabView localLauncherUIBottomTabView = new LauncherUIBottomTabView(((ae)localObject2).zwS);
            localLauncherUIBottomTabView.setId(R.h.dKR);
            if (localObject4 != null)
            {
              localLayoutParams.gravity = 80;
              ((ViewGroup)localObject4).addView(localLauncherUIBottomTabView, localLayoutParams);
            }
            ((ae)localObject2).WbJ = localLauncherUIBottomTabView;
            ((View)((ae)localObject2).WbJ).setVisibility(0);
            ((ae)localObject2).WbJ.setOnTabClickListener((d.a)localObject5);
            if ((localObject6 != null) && (localObject6 != ((ae)localObject2).WbJ))
            {
              ((ae)localObject2).WbJ.Fi(((d)localObject6).getShowFriendPoint());
              ((ae)localObject2).WbJ.Fj(((d)localObject6).getSettingsPoint());
              ((ae)localObject2).WbJ.atB(((d)localObject6).getMainTabUnread());
              ((ae)localObject2).WbJ.atC(((d)localObject6).getContactTabUnread());
              ((ae)localObject2).WbJ.atD(((d)localObject6).getFriendTabUnread());
              ((ae)localObject2).WbJ.atE(((d)localObject6).getSettingsTabUnread());
              ((ae)localObject2).WbJ.setTo(((d)localObject6).getCurIdx());
            }
            ((HomeUI)localObject1).VWg.WbA = new HomeUI.1((HomeUI)localObject1);
            com.tencent.e.h.ZvG.be(new HomeUI.12((HomeUI)localObject1));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
            continue;
            ((MainTabUI)localObject5).aub(0);
          }
        }
      }
      label3912:
      bh.getNotification().dH(false);
      break label847;
      label3924:
      ((HomeUI)localObject1).zwS.setRequestedOrientation(1);
      break label1614;
      com.tencent.mm.ui.base.h.a(((HomeUI)localObject1).zwS, ((HomeUI)localObject1).getString(R.l.login_bind_facebook_tip), "", new HomeUI.42((HomeUI)localObject1), null);
      break label1952;
      if (!((NewChattingTabUI)localObject1).Wdl) {
        break label2121;
      }
      Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "[onResume] need exec this runnable!");
      MMHandlerThread.removeRunnable(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      MMHandlerThread.postToMainThread(((NewChattingTabUI)localObject1).mStartChattingRunnable);
      ((NewChattingTabUI)localObject1).Wdl = false;
      break label2121;
      label4011:
      if (((String)localObject1).equals("launch_type_voip_audio"))
      {
        Log.d("MicroMsg.LauncherUI", "launch, LaunchTypeVOIPAudio");
        localObject1 = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.IzE.a(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
        break label2414;
      }
      if (((String)localObject1).equals("launch_type_scan_qrcode"))
      {
        if (!WeChatBrands.Business.Entries.GlobalScan.checkAvailable(this)) {
          break label2414;
        }
        getIntent().putExtra("LauncherUI.Shortcut.LaunchType", "");
        localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject1 = (cpy)com.tencent.mm.plugin.secdata.ui.a.a.a(this, "BaseScanUI", 3, cpy.class);
        if (localObject1 != null) {
          ((cpy)localObject1).Txg = "launch_type_scan_qrcode";
        }
        localObject1 = new Intent().setClassName(this, "com.tencent.mm.plugin.scanner.ui.BaseScanUI");
        ((Intent)localObject1).putExtra("key_enable_multi_code", true);
        ((Intent)localObject1).putExtra("key_scan_goods_enable_dynamic_wording", true);
        ((Intent)localObject1).putExtra("key_scan_entry_scene", 5);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break label2414;
      }
      if (((String)localObject1).equals("launch_type_offline_wallet"))
      {
        getIntent().putExtra("LauncherUI.Shortcut.LaunchType", "");
        localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject1 = (cpy)com.tencent.mm.plugin.secdata.ui.a.a.a(this, "WalletOfflineEntranceUI", 3, cpy.class);
        if (localObject1 != null) {
          ((cpy)localObject1).Txg = "launch_type_offline_wallet";
        }
        i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
        if ((i == 0) || (i == 1))
        {
          localObject1 = new Intent().setClassName(this, "com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI");
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          break label2414;
        }
        if (i != 8) {
          break label2414;
        }
        if (this.VXp == null) {
          this.VXp = new com.tencent.mm.plugin.wallet_index.c.b();
        }
        localObject1 = this.VXp;
        ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).mContext = this;
        ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).mLP = null;
        ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).Pjq = false;
        ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).Pjr = null;
        com.tencent.mm.kernel.h.aGY().a(2540, (com.tencent.mm.an.i)localObject1);
        localObject3 = com.tencent.mm.plugin.wallet_index.c.b.gMT();
        if (Util.isNullOrNil(((djx)localObject3).TRp))
        {
          Log.i("MicroMsg.HKOfflineLogic", "hk OfflineH5 has no cache");
          ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).Cu(false);
          break label2414;
        }
        l1 = System.currentTimeMillis();
        l2 = l1 - ((djx)localObject3).TRr;
        Log.d("MicroMsg.HKOfflineLogic", "hk currentTime ：%s ,lastTime：%s,internalTime ：%s", new Object[] { Long.valueOf(l1), Long.valueOf(((djx)localObject3).TRr), Long.valueOf(l2) });
        if (l2 < ((djx)localObject3).TRq)
        {
          Log.i("MicroMsg.HKOfflineLogic", "hk OfflineH5 dont expired，url：%s", new Object[] { ((djx)localObject3).TRp });
          com.tencent.mm.wallet_core.ui.g.o(((com.tencent.mm.plugin.wallet_index.c.b)localObject1).mContext, ((djx)localObject3).TRp, false);
          ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).Cu(true);
          break label2414;
        }
        Log.i("MicroMsg.HKOfflineLogic", "hk OfflineH5 is expired");
        ((com.tencent.mm.plugin.wallet_index.c.b)localObject1).Cu(false);
        break label2414;
      }
      if (!((String)localObject1).equals("launch_type_my_qrcode")) {
        break label2414;
      }
      getIntent().putExtra("LauncherUI.Shortcut.LaunchType", "");
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject1 = (cpy)com.tencent.mm.plugin.secdata.ui.a.a.a(this, "SelfQRCodeUI", 3, cpy.class);
      if (localObject1 != null) {
        ((cpy)localObject1).Txg = "launch_type_my_qrcode";
      }
      localObject1 = new Intent().setClassName(this, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      break label2414;
      label4923:
      bool1 = IntentUtil.getBooleanExtra(getIntent(), "LauncherUI_From_Biz_Shortcut", false);
      localObject1 = getIntent().getAction();
      break label2558;
      label4947:
      if (com.tencent.mm.ao.g.UC((String)localObject4))
      {
        localObject1 = new Intent();
        ((Intent)localObject1).setClassName(this, "com.tencent.mm.ui.conversation.EnterpriseConversationUI");
        ((Intent)localObject1).putExtra("enterprise_biz_name", (String)localObject4);
        ((Intent)localObject1).putExtra("enterprise_biz_display_name", aa.PJ((String)localObject4));
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/LauncherUI", "resumeNormalJump", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        break label2759;
      }
      if (com.tencent.mm.ao.g.UD((String)localObject4))
      {
        localObject1 = com.tencent.mm.ao.g.gu((String)localObject4);
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.api.c)localObject1).Zb())
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
          com.tencent.mm.by.c.b(this, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          break;
        }
      }
      localObject1 = getInstance();
      Object localObject3 = new Bundle();
      ((Bundle)localObject3).putInt("chat_from_scene", 3);
      ((LauncherUI)localObject1).startChatting((String)localObject4, (Bundle)localObject3, false);
      break label2759;
      label5238:
      localObject1 = getInstance();
      if (localObject1 == null) {
        break label2759;
      }
      ((LauncherUI)localObject1).startChatting((String)localObject4, null, false);
      break label2759;
      if (VXh) {
        break label2788;
      }
      hHg();
      break label2788;
      label5273:
      Log.i("MicroMsg.FloatBallVisibilityUtil", "fixFloatBallIfNeed, service is null");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(33322);
    super.onSaveInstanceState(paramBundle);
    Object localObject = this.chattingTabUI;
    if (((NewChattingTabUI)localObject).Wdi != null)
    {
      localObject = ((NewChattingTabUI)localObject).Wdi.fgR.getTalkerUserName();
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
    if ((this.VXm) && (!this.chattingTabUI.aq(paramBoolean, paramInt))) {
      super.onSettle(paramBoolean, paramInt);
    }
    AppMethodBeat.o(33318);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(33312);
    Log.i("MicroMsg.LauncherUI", "onStop %s", new Object[] { Integer.valueOf(hashCode()) });
    com.tencent.mm.blink.a.apV();
    if (ar.hIH())
    {
      this.VXk.fMw();
      this.chattingTabUI.fMw();
    }
    HomeUI localHomeUI = this.VXk;
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("showprivacypolicy", localHomeUI.VWG);
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
    if (this.VXm)
    {
      localNewChattingTabUI = this.chattingTabUI;
      if ((localNewChattingTabUI.WcZ == null) || (!localNewChattingTabUI.WcZ.hGI())) {
        break label108;
      }
      bool = true;
      Log.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::on swipe %f, duration %d, resumeStatus %b", new Object[] { Float.valueOf(paramFloat), Long.valueOf(260L), Boolean.valueOf(bool) });
      if (localNewChattingTabUI.hIs()) {
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
        localNewChattingTabUI.aug(0);
        localObject = (ImageView)localNewChattingTabUI.Jvc.getWindow().getDecorView().findViewById(R.h.dRm);
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
        if (!localNewChattingTabUI.WcZ.hGI())
        {
          if (Float.compare(1.0F, paramFloat) > 0)
          {
            Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Boolean.FALSE });
            i = 0;
            break;
            if ((paramFloat != 1.0F) || (localNewChattingTabUI.mChattingClosed) || (localNewChattingTabUI.Wdi.hMn())) {
              continue;
            }
            localNewChattingTabUI.Jvc.getWindow().setBackgroundDrawableResource(R.e.dkI);
            localObject = (ImageView)localNewChattingTabUI.Jvc.getWindow().getDecorView().findViewById(R.h.dRm);
            if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0) && (((ImageView)localObject).getTag() != null))
            {
              ((View)((ImageView)localObject).getTag()).setVisibility(0);
              Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] prepareView GONE");
              ((ImageView)localObject).setVisibility(8);
              ((ImageView)localObject).setVisibility(8);
            }
            if ((localNewChattingTabUI.Wdi.getContentView() != null) && (localNewChattingTabUI.Wdi.getContentView().getX() <= 0.0F))
            {
              localNewChattingTabUI.aug(8);
              continue;
            }
            localNewChattingTabUI.aug(0);
            continue;
          }
          j = 0;
        }
      }
      i = j;
      if (localNewChattingTabUI.Jvc != null)
      {
        localObject = localNewChattingTabUI.Jvc.findViewById(R.h.dKQ);
        ImageView localImageView = (ImageView)localNewChattingTabUI.Jvc.findViewById(R.h.dRm);
        if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null) && (!localNewChattingTabUI.mChattingClosed) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
        {
          localImageView.setVisibility(0);
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
          localNewChattingTabUI.aug(8);
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
    if (((NewChattingTabUI)localObject3).Wdi != null)
    {
      localObject1 = localObject2;
      if (((NewChattingTabUI)localObject3).Wdi.hMp() != null)
      {
        if (((NewChattingTabUI)localObject3).Wdi.isSupportCustomActionBar()) {
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
      if (!com.tencent.mm.compatible.util.d.qX(22))
      {
        localObject3 = ((NewChattingTabUI)localObject3).Wdi.hMp().b(paramCallback);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = localObject3;
        }
      }
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(288717);
    if ((paramIntent != null) && (paramIntent.getComponent() != null))
    {
      com.tencent.mm.ui.tools.y localy = com.tencent.mm.ui.tools.y.XVr;
      com.tencent.mm.ui.tools.y.bAI(paramIntent.getComponent().getClassName());
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(288717);
  }
  
  public final void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(33329);
    this.VXk.hGG();
    this.chattingTabUI.startChatting(paramString, paramBundle, paramBoolean);
    AppMethodBeat.o(33329);
  }
  
  static abstract interface a
  {
    public abstract boolean fcI();
  }
  
  static abstract interface b
  {
    public abstract void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup);
    
    public abstract boolean hGI();
    
    public abstract void hGL();
    
    public abstract void hGM();
  }
  
  static abstract interface c
  {
    public abstract void hGK();
  }
  
  static final class d
    implements com.tencent.mm.ui.l.a
  {
    public final Activity hHi()
    {
      AppMethodBeat.i(256934);
      LauncherUI localLauncherUI = LauncherUI.getInstance();
      AppMethodBeat.o(256934);
      return localLauncherUI;
    }
  }
  
  static abstract interface e {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.LauncherUI
 * JD-Core Version:    0.7.0.1
 */