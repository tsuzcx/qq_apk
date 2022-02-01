package com.tencent.mm.plugin.setting.ui.setting;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.hk;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.kernel.n;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.account.ui.LoginPasswordUI;
import com.tencent.mm.plugin.account.ui.LoginVoiceUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.expt.b.e;
import com.tencent.mm.plugin.setting.SwitchAccountReceiver;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.4;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.5;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.6;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.a;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.b;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.csw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class SettingsSwitchAccountUI
  extends MMActivity
  implements i
{
  private SwitchAccountGridView JeC;
  private Map<String, SwitchAccountModel> JeG;
  private boolean JhM;
  private TextView JjP;
  private View JjQ;
  private TextView JjR;
  private ValueAnimator JjS;
  private MTimerHandler JjT;
  private boolean JjU;
  private boolean JjV;
  private BroadcastReceiver JjW;
  private TextView mRJ;
  private String ndm;
  private int scene;
  private TextView titleView;
  private View wWQ;
  
  public SettingsSwitchAccountUI()
  {
    AppMethodBeat.i(74445);
    this.JeG = new HashMap();
    this.JjW = new SettingsSwitchAccountUI.1(this);
    AppMethodBeat.o(74445);
  }
  
  private void aXN(String paramString)
  {
    AppMethodBeat.i(74450);
    Object localObject = (SwitchAccountModel)this.JeG.get(paramString);
    if ((localObject != null) && (!this.JjU))
    {
      this.JjU = true;
      localObject = new com.tencent.mm.modelsimple.t(paramString, ((SwitchAccountModel)localObject).username, ((SwitchAccountModel)localObject).Jdz, "");
      com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
      this.JeC.setSwitchToWxUsername(paramString);
      this.JeC.fGQ();
      fGy();
    }
    AppMethodBeat.o(74450);
  }
  
  private void aXO(String paramString)
  {
    AppMethodBeat.i(74461);
    Object localObject = new IntentFilter("action_kill_mm_process");
    registerReceiver(this.JjW, (IntentFilter)localObject);
    localObject = new Intent(this, FakeSwitchAccountUI.class);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.JeG.values());
    ((Intent)localObject).putParcelableArrayListExtra("key_switch_account_users", localArrayList);
    ((Intent)localObject).putExtra("key_switch_from_wx_username", paramString);
    MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("transit_to_switch_account", true).commit();
    paramString = LocaleUtil.loadApplicationLanguage(getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this);
    float f = com.tencent.mm.ci.a.ez(this);
    ((Intent)localObject).putExtra("key_langauage_code", paramString);
    ((Intent)localObject).putExtra("key_font_scale_size", f);
    Log.i("MicroMsg.SettingsSwitchAccountUI", "mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
    ((Intent)localObject).putExtra("key_mm_process_pid", Process.myPid());
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.lc(this);
    AppMethodBeat.o(74461);
  }
  
  private static void dbv()
  {
    AppMethodBeat.i(74458);
    if ((com.tencent.mm.kernel.h.aGY() != null) && (com.tencent.mm.kernel.h.aGY().lCD != null)) {
      com.tencent.mm.kernel.h.aGY().lCD.gk(false);
    }
    Object localObject = new hk();
    EventCenter.instance.publish((IEvent)localObject);
    com.tencent.mm.kernel.h.aHE();
    Log.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", new Object[] { Integer.valueOf(com.tencent.mm.kernel.b.getUin()) });
    com.tencent.mm.modelstat.c.bpr().iq();
    ((e)com.tencent.mm.kernel.h.ae(e.class)).dbv();
    localObject = new u(2);
    ((u)localObject).mad = 1;
    com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
    AppMethodBeat.o(74458);
  }
  
  private void fGA()
  {
    AppMethodBeat.i(74460);
    Log.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
    com.tencent.mm.plugin.setting.c.mIH.abH();
    this.mRJ.setVisibility(8);
    this.JjP.setVisibility(8);
    Object localObject = new mr();
    ((mr)localObject).fKQ.status = 0;
    ((mr)localObject).fKQ.bnA = 0;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = new com.tencent.mm.f.a.ae();
    ((com.tencent.mm.f.a.ae)localObject).fvH.fvI = true;
    EventCenter.instance.publish((IEvent)localObject);
    MMEntryLock.unlock("show_whatsnew");
    n.v(this, true);
    com.tencent.mm.platformtools.t.O(this, null);
    if (com.tencent.mm.kernel.h.aHB())
    {
      localObject = com.tencent.mm.am.d.Tz(z.bcZ());
      bg.ltv.RF((String)localObject);
    }
    Log.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", new Object[] { bg.ltv.aD("login_user_name", "") });
    localObject = z.bdU();
    if (Util.isNullOrNil((String)((Map)localObject).get("login_user_name"))) {
      ((Map)localObject).put("login_user_name", bg.ltv.aD("login_user_name", ""));
    }
    ci.lvQ.g(z.bcZ(), (Map)localObject);
    MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
    aXO(z.bcZ());
    AppMethodBeat.o(74460);
  }
  
  private void fGy()
  {
    AppMethodBeat.i(74451);
    if (this.JjU)
    {
      this.JjP.setVisibility(8);
      AppMethodBeat.o(74451);
      return;
    }
    if ((this.JeG.size() <= 1) && (this.scene == 0))
    {
      this.JjP.setVisibility(8);
      this.JhM = false;
      this.JeC.setDeleteState(false);
      AppMethodBeat.o(74451);
      return;
    }
    if (!this.JhM)
    {
      this.titleView.setText(b.i.settings_switch_account_login_title);
      this.JjR.setVisibility(8);
      this.JjP.setText(getString(b.i.settings_switch_account_delete_title));
      this.JjP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this))
          {
            SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, true);
            SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this));
            SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).fGQ();
            SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
            if (ci.lvQ.bfs().size() <= 1) {
              break label156;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(3), ci.lvQ.bft() });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74442);
            return;
            label156:
            com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(3), ci.lvQ.bft() });
          }
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    this.titleView.setText(b.i.settings_switch_account_delete_title);
    this.JjR.setVisibility(0);
    if (this.JjV)
    {
      this.JjP.setText(getString(b.i.app_finish));
      this.JjP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74443);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(false);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).fGQ();
          SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
          if (SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).getAccountCount() == 0)
          {
            if (ci.lvQ.bfs().size() <= 1) {
              break label270;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(11), ci.lvQ.bft() });
          }
          for (;;)
          {
            localObject = com.tencent.mm.plugin.account.sdk.a.mIG.bX(SettingsSwitchAccountUI.this);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousView = SettingsSwitchAccountUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            SettingsSwitchAccountUI.this.finish();
            com.tencent.mm.ui.base.b.lb(SettingsSwitchAccountUI.this);
            SettingsSwitchAccountUI.h(SettingsSwitchAccountUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74443);
            return;
            label270:
            com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(11), ci.lvQ.bft() });
          }
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    this.JjP.setText(getString(b.i.app_cancel));
    this.JjP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74444);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(false);
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).fGQ();
        SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74444);
      }
    });
    AppMethodBeat.o(74451);
  }
  
  private void fGz()
  {
    AppMethodBeat.i(74459);
    if (com.tencent.mm.kernel.b.sC(com.tencent.mm.kernel.h.aHE().kbN))
    {
      localObject = new com.tencent.mm.modelsimple.ae(2);
      com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
    }
    Object localObject = new s();
    com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
    this.JeC.setLogoutState(true);
    this.JeC.fGQ();
    if (this.JjT == null)
    {
      this.JjT = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(74435);
          SettingsSwitchAccountUI.j(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74435);
          return false;
        }
      }, false);
      this.JjT.startTimer(8000L);
    }
    AppMethodBeat.o(74459);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(74455);
    Log.i("MicroMsg.SettingsSwitchAccountUI", "go back");
    if ((this.scene == 2) || (this.scene == 1))
    {
      Object localObject = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.lb(this);
      this.JjU = false;
      AppMethodBeat.o(74455);
      return;
    }
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    finish();
    AppMethodBeat.o(74455);
  }
  
  public int getLayoutId()
  {
    return b.g.settings_switch_account;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74447);
    setMMTitle("");
    showMMLogo();
    getSupportActionBar().hide();
    getController().q(this, getContext().getResources().getColor(b.c.white));
    this.scene = getIntent().getIntExtra("key_scene", 0);
    this.wWQ = findViewById(b.f.switch_account_title_container);
    this.JjQ = findViewById(b.f.switch_account_icon);
    this.titleView = ((TextView)findViewById(b.f.switch_account_title));
    this.JjR = ((TextView)findViewById(b.f.switch_account_del_tip));
    this.JjP = ((TextView)findViewById(b.f.switch_account_delete_btn));
    this.mRJ = ((TextView)findViewById(b.f.switch_account_cancel_btn));
    this.JeC = ((SwitchAccountGridView)findViewById(b.f.switch_account_grid));
    this.JeC.setRowCount(1);
    this.JeC.setOnClickAvatarListener(new SwitchAccountGridView.b()
    {
      public final void aXP(String paramAnonymousString)
      {
        AppMethodBeat.i(74436);
        if (!Util.isNullOrNil(paramAnonymousString))
        {
          if (SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this) == 0)
          {
            SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, paramAnonymousString);
            AppMethodBeat.o(74436);
            return;
          }
          SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, paramAnonymousString);
          AppMethodBeat.o(74436);
          return;
        }
        MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", "").commit();
        if (SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this) == 0)
        {
          SettingsSwitchAccountUI.fGB();
          AppMethodBeat.o(74436);
          return;
        }
        Object localObject = new Intent(SettingsSwitchAccountUI.this, MobileInputUI.class);
        ((Intent)localObject).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject).putExtra("from_switch_account", true);
        paramAnonymousString = SettingsSwitchAccountUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.kZ(SettingsSwitchAccountUI.this);
        AppMethodBeat.o(74436);
      }
    });
    Object localObject1;
    label261:
    String str1;
    Object localObject2;
    if (this.scene == 0)
    {
      localObject1 = new Intent(this, SwitchAccountReceiver.class);
      ((Intent)localObject1).putExtra("switch_process_action_code_key", "action_switch_account");
      MMApplicationContext.getContext().sendBroadcast((Intent)localObject1);
      this.mRJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74437);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          SettingsSwitchAccountUI.c(SettingsSwitchAccountUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74437);
        }
      });
      localObject1 = ci.lvQ.bfs();
      com.tencent.mm.kernel.h.aHE();
      if (!com.tencent.mm.kernel.b.aGL()) {
        break label746;
      }
      this.ndm = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(2, null));
      Log.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", new Object[] { Integer.valueOf(this.scene), this.ndm });
      if ((Util.isNullOrNil(this.ndm)) || (((Set)localObject1).contains(this.ndm))) {
        break label764;
      }
      if ((this.scene != 2) || (ci.lvQ.Sc(this.ndm)))
      {
        localObject1 = bg.ltv.aD("login_user_name", "");
        str1 = bg.ltv.beA();
        localObject2 = bg.ltv.aD("last_login_use_voice", "");
        String str2 = ci.lvQ.getString(this.ndm, "last_logout_no_pwd_ticket");
        localObject1 = new SwitchAccountModel(this.ndm, (String)localObject1, str1, str2, Util.safeParseInt((String)localObject2));
        this.JeG.put(this.ndm, localObject1);
      }
      label415:
      if (this.JeG.size() == 0)
      {
        localObject1 = new Intent(this, MobileInputUI.class);
        ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject1).putExtra("can_finish", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.ui.base.b.lc(this);
      }
      this.JeC.aA(this.JeG);
      if (this.scene != 1) {
        break label988;
      }
      localObject1 = MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0);
      str1 = ((SharedPreferences)localObject1).getString("last_switch_account_to_wx_username", "");
      ((SharedPreferences)localObject1).edit().putBoolean("transit_to_switch_account", false).commit();
      Log.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s", new Object[] { str1 });
      if (Util.isNullOrNil(str1)) {
        break label874;
      }
      com.tencent.mm.kernel.h.aHE();
      if (!com.tencent.mm.kernel.b.aGL()) {
        break label866;
      }
      Log.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
      finish();
    }
    for (;;)
    {
      this.JeC.fGQ();
      fGy();
      this.JeC.setOnDeleteAvatarListener(new SwitchAccountGridView.c()
      {
        public final void aXQ(final String paramAnonymousString)
        {
          AppMethodBeat.i(74439);
          com.tencent.mm.ui.base.h.c(SettingsSwitchAccountUI.this, SettingsSwitchAccountUI.this.getString(b.i.settings_switch_account_delete_alert, new Object[] { ((SwitchAccountModel)SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).get(paramAnonymousString)).username }), SettingsSwitchAccountUI.this.getString(b.i.app_tip), SettingsSwitchAccountUI.this.getString(b.i.app_yes), SettingsSwitchAccountUI.this.getString(b.i.app_no), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74438);
              Log.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", new Object[] { paramAnonymousString });
              SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, true);
              ci.lvQ.Sa(paramAnonymousString);
              SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).remove(paramAnonymousString);
              paramAnonymous2DialogInterface = SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
              String str = paramAnonymousString;
              if (paramAnonymous2DialogInterface.JlK.contains(str))
              {
                paramAnonymous2Int = paramAnonymous2DialogInterface.JlK.indexOf(str);
                paramAnonymous2DialogInterface.JlK.remove(str);
                paramAnonymous2DialogInterface.JlL.remove(paramAnonymous2Int);
                paramAnonymous2DialogInterface.JlM.remove(paramAnonymous2Int);
              }
              SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).fGQ();
              SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
              if (SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this) == 0)
              {
                if (ci.lvQ.bfs().size() > 0)
                {
                  com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(4), ci.lvQ.bft() });
                  AppMethodBeat.o(74438);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(4), ci.lvQ.bft() });
              }
              AppMethodBeat.o(74438);
            }
          }, null);
          AppMethodBeat.o(74439);
        }
      });
      this.JjS = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.JjS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(74440);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setTranslationY(-f * SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).getHeight());
          AppMethodBeat.o(74440);
        }
      });
      this.JjS.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(74441);
          Log.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
          Object localObject = com.tencent.mm.plugin.account.sdk.a.mIG.bX(SettingsSwitchAccountUI.this);
          ((Intent)localObject).addFlags(67108864);
          paramAnonymousAnimator = SettingsSwitchAccountUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAnimator, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAnimator.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAnimator, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          SettingsSwitchAccountUI.this.finish();
          com.tencent.mm.ui.base.b.lb(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74441);
        }
      });
      this.JjS.setDuration(500L);
      AppMethodBeat.o(74447);
      return;
      this.mRJ.setVisibility(8);
      break;
      label746:
      this.ndm = bg.ltv.aD("login_weixin_username", "");
      break label261;
      label764:
      if (((Set)localObject1).isEmpty()) {
        break label415;
      }
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        str1 = (String)((Iterator)localObject1).next();
        localObject2 = new SwitchAccountModel(str1, ci.lvQ.getString(str1, "login_user_name"), ci.lvQ.getString(str1, "last_avatar_path"), ci.lvQ.getString(str1, "last_logout_no_pwd_ticket"), Util.safeParseInt(ci.lvQ.getString(str1, "last_login_use_voice")));
        this.JeG.put(str1, localObject2);
      }
      break label415;
      label866:
      aXN(str1);
      continue;
      label874:
      this.JjU = false;
      localObject1 = new Intent(this, MobileInputUI.class);
      ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
      ((Intent)localObject1).putExtra("from_switch_account", true);
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.lc(this);
      continue;
      label988:
      if (this.scene == 0) {
        this.JeC.setLastLoginWxUsername(this.ndm);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74457);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 701) && (paramInt2 == -1)) {
      fGz();
    }
    AppMethodBeat.o(74457);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74446);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(74446);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74456);
    super.onDestroy();
    try
    {
      unregisterReceiver(this.JjW);
      AppMethodBeat.o(74456);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(74456);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74449);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(74449);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(74449);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74452);
    super.onResume();
    Log.i("MicroMsg.SettingsSwitchAccountUI", "onResume");
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    if ((this.scene == 1) || (this.scene == 2))
    {
      com.tencent.mm.kernel.h.aGY().a(701, this);
      com.tencent.mm.kernel.h.aGY().a(252, this);
    }
    if (this.scene == 0)
    {
      com.tencent.mm.kernel.h.aGY().a(281, this);
      com.tencent.mm.kernel.h.aGY().a(282, this);
      com.tencent.mm.kernel.h.aGY().a(255, this);
    }
    this.JeC.fGQ();
    fGy();
    if (((this.scene == 1) || (this.scene == 2)) && (com.tencent.mm.kernel.h.aHB()) && (com.tencent.mm.kernel.h.aHE().kbT))
    {
      Log.i("MicroMsg.SettingsSwitchAccountUI", "account initialized");
      this.JjU = true;
      Object localObject = com.tencent.mm.plugin.account.sdk.a.mIG.bX(this);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.lb(this);
    }
    AppMethodBeat.o(74452);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(74454);
    Log.i("MicroMsg.SettingsSwitchAccountUI", "errCode %d, errMsg %s, scene %s, type  %d, this %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramq, Integer.valueOf(paramq.getType()), this });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramq.getType() == 252) || (paramq.getType() == 701))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label456;
      }
      this.wWQ.setVisibility(4);
      this.JjQ.setVisibility(4);
      localObject1 = this.JeC;
      if (!((SwitchAccountGridView)localObject1).mLR)
      {
        if ((((SwitchAccountGridView)localObject1).JlJ == null) && (!Util.isNullOrNil(((SwitchAccountGridView)localObject1).JlI)))
        {
          int i = Math.min(2, ((SwitchAccountGridView)localObject1).JlK.size());
          localObject2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.4((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject2).setDuration(200L);
          localObject3 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.5((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject3).setDuration(300L);
          ((SwitchAccountGridView)localObject1).JlJ = new AnimatorSet();
          ((SwitchAccountGridView)localObject1).JlJ.addListener(new SwitchAccountGridView.6((SwitchAccountGridView)localObject1));
          ((SwitchAccountGridView)localObject1).JlJ.playSequentially(new Animator[] { localObject2, localObject3 });
        }
        if (((SwitchAccountGridView)localObject1).JlJ != null)
        {
          ((SwitchAccountGridView)localObject1).mLR = true;
          ((SwitchAccountGridView)localObject1).JlJ.start();
        }
      }
      com.tencent.mm.kernel.b.aGG();
      com.tencent.mm.plugin.account.friend.a.l.byn();
      com.tencent.mm.platformtools.t.jdMethod_do(this);
      if (ci.lvQ.bfs().size() <= 1) {
        break label417;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(0), ci.lvQ.bft() });
      this.JeC.setOnAnimatorEndListener(new SwitchAccountGridView.a()
      {
        public final void fGC()
        {
          AppMethodBeat.i(74434);
          String str = z.bcZ();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setLastLoginWxUsername(str);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setSwitchToWxUsername("");
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).fGQ();
          SettingsSwitchAccountUI.i(SettingsSwitchAccountUI.this).start();
          AppMethodBeat.o(74434);
        }
      });
    }
    for (;;)
    {
      if (paramq.getType() == 255)
      {
        if (((u)paramq).mae != 2) {
          break label1109;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          fGz();
          AppMethodBeat.o(74454);
          return;
          label417:
          com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(0), ci.lvQ.bft() });
          break;
          label456:
          this.JeC.setSwitchToWxUsername("");
          this.JjU = false;
          com.tencent.mm.ui.base.h.cO(this, getString(b.i.settings_switch_account_error_tip));
          localObject1 = ((com.tencent.mm.modelsimple.t)paramq).lZV;
          if ((!Util.isNullOrNil((String)localObject1)) && (this.JeG.containsKey(localObject1)))
          {
            localObject2 = new Intent();
            localObject3 = (SwitchAccountModel)this.JeG.get(localObject1);
            Log.i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", new Object[] { localObject1, Integer.valueOf(((SwitchAccountModel)localObject3).JdA) });
            if ((WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned()) || ((((SwitchAccountModel)localObject3).JdA & 0x20000) == 0)) {
              break label743;
            }
            ((Intent)localObject2).setClass(this, LoginVoiceUI.class);
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("switch_login_wx_id", (String)localObject1);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
            com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.lc(this);
            if (ci.lvQ.bfs().size() <= 1) {
              break label756;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(1), ci.lvQ.bft() });
            break;
            label743:
            ((Intent)localObject2).setClass(this, LoginPasswordUI.class);
          }
          label756:
          com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(1), ci.lvQ.bft() });
          continue;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          if (ci.lvQ.bfs().size() > 1) {
            com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(7), ci.lvQ.bft() });
          }
          for (;;)
          {
            paramString = new Intent(getContext(), RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(b.i.regbymobile_reg_setpwd_tip_when_logout));
            startActivityForResult(paramString, 701);
            AppMethodBeat.o(74454);
            return;
            com.tencent.mm.plugin.report.service.h.IzE.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(7), ci.lvQ.bft() });
          }
        }
        if (!com.tencent.mm.plugin.setting.c.mIH.a(this, paramInt1, paramInt2, paramString)) {
          break label1109;
        }
        AppMethodBeat.o(74454);
        return;
      }
    }
    if (paramq.getType() == 282)
    {
      com.tencent.mm.kernel.h.aHE();
      if (com.tencent.mm.kernel.b.aGL())
      {
        paramString = ((csw)d.c.b(((s)paramq).rr.lBS)).TAD;
        if (paramString != null) {
          break label1116;
        }
      }
    }
    label1109:
    label1116:
    for (paramInt1 = -1;; paramInt1 = paramString.length())
    {
      Log.d("MicroMsg.SettingsSwitchAccountUI", "logout return noPwdTicket[%s]", new Object[] { Integer.valueOf(paramInt1) });
      if (Util.isNullOrNil(paramString)) {
        Log.i("MicroMsg.SettingsSwitchAccountUI", "no pwd ticket is null!");
      }
      paramq = z.bcZ();
      Log.i("MicroMsg.SettingsSwitchAccountUI", "logout return username[%s]", new Object[] { paramq });
      ci.lvQ.o(paramq, "last_logout_no_pwd_ticket", paramString);
      if ((this.JjT != null) && (!this.JjT.stopped()))
      {
        this.JjT.stopTimer();
        fGA();
      }
      AppMethodBeat.o(74454);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(74453);
    super.onStop();
    Log.i("MicroMsg.SettingsSwitchAccountUI", "onStop");
    if (this.scene == 1)
    {
      SwitchAccountGridView localSwitchAccountGridView = this.JeC;
      if (localSwitchAccountGridView.mLR)
      {
        localSwitchAccountGridView.mLR = false;
        if (localSwitchAccountGridView.JlJ != null) {
          localSwitchAccountGridView.JlJ.end();
        }
      }
    }
    com.tencent.mm.kernel.h.aGY().b(701, this);
    com.tencent.mm.kernel.h.aGY().b(252, this);
    com.tencent.mm.kernel.h.aGY().b(281, this);
    com.tencent.mm.kernel.h.aGY().b(282, this);
    com.tencent.mm.kernel.h.aGY().b(255, this);
    AppMethodBeat.o(74453);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI
 * JD-Core Version:    0.7.0.1
 */