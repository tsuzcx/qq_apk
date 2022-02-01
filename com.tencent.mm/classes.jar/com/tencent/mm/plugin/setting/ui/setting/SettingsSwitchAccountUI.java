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
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.plugin.account.ui.LoginPasswordUI;
import com.tencent.mm.plugin.account.ui.LoginVoiceUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.setting.SwitchAccountReceiver;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.4;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.5;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.6;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.a;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.b;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ckc;
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
  private SwitchAccountGridView CYW;
  private Map<String, SwitchAccountModel> CZa;
  private boolean Dcl;
  private TextView Dej;
  private View Dek;
  private TextView Del;
  private ValueAnimator Dem;
  private MTimerHandler Den;
  private boolean Deo;
  private boolean Dep;
  private BroadcastReceiver Deq;
  private TextView kaq;
  private String klw;
  private int scene;
  private TextView titleView;
  private View tql;
  
  public SettingsSwitchAccountUI()
  {
    AppMethodBeat.i(74445);
    this.CZa = new HashMap();
    this.Deq = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(74433);
        Log.i("MicroMsg.SettingsSwitchAccountUI", "onReceive %s", new Object[] { paramAnonymousIntent.getAction() });
        SettingsSwitchAccountUI.this.unregisterReceiver(SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this));
        if (Util.nullAsNil(paramAnonymousIntent.getAction()).equals("action_kill_mm_process"))
        {
          com.tencent.mm.kernel.g.aAf();
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.aAi().FS("switch account ,delay logout");
          Mars.onSingalCrash(0);
          Log.appenderFlush();
          SettingsSwitchAccountUI.this.finish();
          Log.i("MicroMsg.SettingsSwitchAccountUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
          paramAnonymousContext = new xh();
          EventCenter.instance.publish(paramAnonymousContext);
        }
        AppMethodBeat.o(74433);
      }
    };
    AppMethodBeat.o(74445);
  }
  
  private void aNe(String paramString)
  {
    AppMethodBeat.i(74450);
    Object localObject = (SwitchAccountModel)this.CZa.get(paramString);
    if ((localObject != null) && (!this.Deo))
    {
      this.Deo = true;
      localObject = new com.tencent.mm.modelsimple.t(paramString, ((SwitchAccountModel)localObject).username, ((SwitchAccountModel)localObject).CXT, "");
      com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
      this.CYW.setSwitchToWxUsername(paramString);
      this.CYW.eTN();
      eTv();
    }
    AppMethodBeat.o(74450);
  }
  
  private void aNf(String paramString)
  {
    AppMethodBeat.i(74461);
    Object localObject = new IntentFilter("action_kill_mm_process");
    registerReceiver(this.Deq, (IntentFilter)localObject);
    localObject = new Intent(this, FakeSwitchAccountUI.class);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.CZa.values());
    ((Intent)localObject).putParcelableArrayListExtra("key_switch_account_users", localArrayList);
    ((Intent)localObject).putExtra("key_switch_from_wx_username", paramString);
    MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("transit_to_switch_account", true).commit();
    paramString = LocaleUtil.loadApplicationLanguage(getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this);
    float f = com.tencent.mm.cb.a.ez(this);
    ((Intent)localObject).putExtra("key_langauage_code", paramString);
    ((Intent)localObject).putExtra("key_font_scale_size", f);
    Log.i("MicroMsg.SettingsSwitchAccountUI", "mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
    ((Intent)localObject).putExtra("key_mm_process_pid", Process.myPid());
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.ke(this);
    AppMethodBeat.o(74461);
  }
  
  private void eTv()
  {
    AppMethodBeat.i(74451);
    if (this.Deo)
    {
      this.Dej.setVisibility(8);
      AppMethodBeat.o(74451);
      return;
    }
    if ((this.CZa.size() <= 1) && (this.scene == 0))
    {
      this.Dej.setVisibility(8);
      this.Dcl = false;
      this.CYW.setDeleteState(false);
      AppMethodBeat.o(74451);
      return;
    }
    if (!this.Dcl)
    {
      this.titleView.setText(2131765629);
      this.Del.setVisibility(8);
      this.Dej.setText(getString(2131765627));
      this.Dej.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this))
          {
            SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, true);
            SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this));
            SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).eTN();
            SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
            if (ch.iFO.aWo().size() <= 1) {
              break label156;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(3), ch.iFO.aWp() });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74442);
            return;
            label156:
            com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(3), ch.iFO.aWp() });
          }
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    this.titleView.setText(2131765627);
    this.Del.setVisibility(0);
    if (this.Dep)
    {
      this.Dej.setText(getString(2131755858));
      this.Dej.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74443);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(false);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).eTN();
          SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
          if (SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).getAccountCount() == 0)
          {
            if (ch.iFO.aWo().size() <= 1) {
              break label270;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(11), ch.iFO.aWp() });
          }
          for (;;)
          {
            localObject = com.tencent.mm.plugin.account.a.a.jRt.bZ(SettingsSwitchAccountUI.this);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousView = SettingsSwitchAccountUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            SettingsSwitchAccountUI.this.finish();
            com.tencent.mm.ui.base.b.kd(SettingsSwitchAccountUI.this);
            SettingsSwitchAccountUI.h(SettingsSwitchAccountUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74443);
            return;
            label270:
            com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(11), ch.iFO.aWp() });
          }
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    this.Dej.setText(getString(2131755761));
    this.Dej.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74444);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(false);
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).eTN();
        SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74444);
      }
    });
    AppMethodBeat.o(74451);
  }
  
  private void eTw()
  {
    AppMethodBeat.i(74459);
    if (com.tencent.mm.kernel.a.qd(com.tencent.mm.kernel.g.aAf().hpS))
    {
      localObject = new ae(2);
      com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
    }
    Object localObject = new s();
    com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
    this.CYW.setLogoutState(true);
    this.CYW.eTN();
    if (this.Den == null)
    {
      this.Den = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(74435);
          SettingsSwitchAccountUI.j(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74435);
          return false;
        }
      }, false);
      this.Den.startTimer(8000L);
    }
    AppMethodBeat.o(74459);
  }
  
  private void eTx()
  {
    AppMethodBeat.i(74460);
    Log.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
    com.tencent.mm.plugin.setting.c.jRu.Xe();
    this.kaq.setVisibility(8);
    this.Dej.setVisibility(8);
    Object localObject = new ma();
    ((ma)localObject).dRA.status = 0;
    ((ma)localObject).dRA.bDZ = 0;
    EventCenter.instance.publish((IEvent)localObject);
    localObject = new ad();
    ((ad)localObject).dDb.dDc = true;
    EventCenter.instance.publish((IEvent)localObject);
    MMEntryLock.unlock("show_whatsnew");
    com.tencent.mm.kernel.l.s(this, true);
    com.tencent.mm.platformtools.t.Q(this, null);
    if (com.tencent.mm.kernel.g.aAc())
    {
      localObject = com.tencent.mm.aj.c.Me(z.aTY());
      bf.iDu.Km((String)localObject);
    }
    Log.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", new Object[] { bf.iDu.aA("login_user_name", "") });
    localObject = z.aUS();
    if (Util.isNullOrNil((String)((Map)localObject).get("login_user_name"))) {
      ((Map)localObject).put("login_user_name", bf.iDu.aA("login_user_name", ""));
    }
    ch.iFO.h(z.aTY(), (Map)localObject);
    MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
    aNf(z.aTY());
    AppMethodBeat.o(74460);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(74455);
    Log.i("MicroMsg.SettingsSwitchAccountUI", "go back");
    if ((this.scene == 2) || (this.scene == 1))
    {
      Object localObject = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.kd(this);
      this.Deo = false;
      AppMethodBeat.o(74455);
      return;
    }
    finish();
    AppMethodBeat.o(74455);
  }
  
  private static void logout()
  {
    AppMethodBeat.i(74458);
    if ((com.tencent.mm.kernel.g.azz() != null) && (com.tencent.mm.kernel.g.azz().iMw != null)) {
      com.tencent.mm.kernel.g.azz().iMw.fz(false);
    }
    Object localObject = new hd();
    EventCenter.instance.publish((IEvent)localObject);
    com.tencent.mm.kernel.g.aAf();
    Log.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()) });
    com.tencent.mm.modelstat.c.bgb().commitNow();
    ((com.tencent.mm.plugin.expt.b.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.e.class)).logout();
    localObject = new u(2);
    ((u)localObject).jkg = 1;
    com.tencent.mm.kernel.g.azz().a((q)localObject, 0);
    AppMethodBeat.o(74458);
  }
  
  public int getLayoutId()
  {
    return 2131496268;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74447);
    setMMTitle("");
    showMMLogo();
    getSupportActionBar().hide();
    getController().p(this, getContext().getResources().getColor(2131101424));
    this.scene = getIntent().getIntExtra("key_scene", 0);
    this.tql = findViewById(2131308797);
    this.Dek = findViewById(2131308795);
    this.titleView = ((TextView)findViewById(2131308796));
    this.Del = ((TextView)findViewById(2131308791));
    this.Dej = ((TextView)findViewById(2131308792));
    this.kaq = ((TextView)findViewById(2131308790));
    this.CYW = ((SwitchAccountGridView)findViewById(2131308794));
    this.CYW.setRowCount(1);
    this.CYW.setOnClickAvatarListener(new SwitchAccountGridView.b()
    {
      public final void aNg(String paramAnonymousString)
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
          SettingsSwitchAccountUI.eTy();
          AppMethodBeat.o(74436);
          return;
        }
        Object localObject = new Intent(SettingsSwitchAccountUI.this, MobileInputUI.class);
        ((Intent)localObject).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject).putExtra("from_switch_account", true);
        paramAnonymousString = SettingsSwitchAccountUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.kb(SettingsSwitchAccountUI.this);
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
      this.kaq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74437);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          SettingsSwitchAccountUI.c(SettingsSwitchAccountUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74437);
        }
      });
      localObject1 = ch.iFO.aWo();
      com.tencent.mm.kernel.g.aAf();
      if (!com.tencent.mm.kernel.a.azo()) {
        break label746;
      }
      this.klw = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, null));
      Log.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", new Object[] { Integer.valueOf(this.scene), this.klw });
      if ((Util.isNullOrNil(this.klw)) || (((Set)localObject1).contains(this.klw))) {
        break label764;
      }
      if ((this.scene != 2) || (ch.iFO.KJ(this.klw)))
      {
        localObject1 = bf.iDu.aA("login_user_name", "");
        str1 = bf.iDu.aVx();
        localObject2 = bf.iDu.aA("last_login_use_voice", "");
        String str2 = ch.iFO.getString(this.klw, "last_logout_no_pwd_ticket");
        localObject1 = new SwitchAccountModel(this.klw, (String)localObject1, str1, str2, Util.safeParseInt((String)localObject2));
        this.CZa.put(this.klw, localObject1);
      }
      label415:
      if (this.CZa.size() == 0)
      {
        localObject1 = new Intent(this, MobileInputUI.class);
        ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject1).putExtra("can_finish", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.ui.base.b.ke(this);
      }
      this.CYW.aG(this.CZa);
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
      com.tencent.mm.kernel.g.aAf();
      if (!com.tencent.mm.kernel.a.azo()) {
        break label866;
      }
      Log.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
      finish();
    }
    for (;;)
    {
      this.CYW.eTN();
      eTv();
      this.CYW.setOnDeleteAvatarListener(new SwitchAccountGridView.c()
      {
        public final void aNh(final String paramAnonymousString)
        {
          AppMethodBeat.i(74439);
          com.tencent.mm.ui.base.h.c(SettingsSwitchAccountUI.this, SettingsSwitchAccountUI.this.getString(2131765625, new Object[] { ((SwitchAccountModel)SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).get(paramAnonymousString)).username }), SettingsSwitchAccountUI.this.getString(2131755998), SettingsSwitchAccountUI.this.getString(2131756033), SettingsSwitchAccountUI.this.getString(2131755917), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74438);
              Log.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", new Object[] { paramAnonymousString });
              SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, true);
              ch.iFO.KH(paramAnonymousString);
              SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).remove(paramAnonymousString);
              paramAnonymous2DialogInterface = SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
              String str = paramAnonymousString;
              if (paramAnonymous2DialogInterface.Dgg.contains(str))
              {
                paramAnonymous2Int = paramAnonymous2DialogInterface.Dgg.indexOf(str);
                paramAnonymous2DialogInterface.Dgg.remove(str);
                paramAnonymous2DialogInterface.Dgh.remove(paramAnonymous2Int);
                paramAnonymous2DialogInterface.Dgi.remove(paramAnonymous2Int);
              }
              SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).eTN();
              SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
              if (SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this) == 0)
              {
                if (ch.iFO.aWo().size() > 0)
                {
                  com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(4), ch.iFO.aWp() });
                  AppMethodBeat.o(74438);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(4), ch.iFO.aWp() });
              }
              AppMethodBeat.o(74438);
            }
          }, null);
          AppMethodBeat.o(74439);
        }
      });
      this.Dem = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Dem.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(74440);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setTranslationY(-f * SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).getHeight());
          AppMethodBeat.o(74440);
        }
      });
      this.Dem.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(74441);
          Log.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
          Object localObject = com.tencent.mm.plugin.account.a.a.jRt.bZ(SettingsSwitchAccountUI.this);
          ((Intent)localObject).addFlags(67108864);
          paramAnonymousAnimator = SettingsSwitchAccountUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAnimator, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAnimator.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAnimator, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          SettingsSwitchAccountUI.this.finish();
          com.tencent.mm.ui.base.b.kd(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74441);
        }
      });
      this.Dem.setDuration(500L);
      AppMethodBeat.o(74447);
      return;
      this.kaq.setVisibility(8);
      break;
      label746:
      this.klw = bf.iDu.aA("login_weixin_username", "");
      break label261;
      label764:
      if (((Set)localObject1).isEmpty()) {
        break label415;
      }
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        str1 = (String)((Iterator)localObject1).next();
        localObject2 = new SwitchAccountModel(str1, ch.iFO.getString(str1, "login_user_name"), ch.iFO.getString(str1, "last_avatar_path"), ch.iFO.getString(str1, "last_logout_no_pwd_ticket"), Util.safeParseInt(ch.iFO.getString(str1, "last_login_use_voice")));
        this.CZa.put(str1, localObject2);
      }
      break label415;
      label866:
      aNe(str1);
      continue;
      label874:
      this.Deo = false;
      localObject1 = new Intent(this, MobileInputUI.class);
      ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
      ((Intent)localObject1).putExtra("from_switch_account", true);
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.ke(this);
      continue;
      label988:
      if (this.scene == 0) {
        this.CYW.setLastLoginWxUsername(this.klw);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74457);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 701) && (paramInt2 == -1)) {
      eTw();
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
      unregisterReceiver(this.Deq);
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
    f.e(true, true, true);
    if ((this.scene == 1) || (this.scene == 2))
    {
      com.tencent.mm.kernel.g.azz().a(701, this);
      com.tencent.mm.kernel.g.azz().a(252, this);
    }
    if (this.scene == 0)
    {
      com.tencent.mm.kernel.g.azz().a(281, this);
      com.tencent.mm.kernel.g.azz().a(282, this);
      com.tencent.mm.kernel.g.azz().a(255, this);
    }
    this.CYW.eTN();
    eTv();
    if (((this.scene == 1) || (this.scene == 2)) && (com.tencent.mm.kernel.g.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY))
    {
      Log.i("MicroMsg.SettingsSwitchAccountUI", "account initialized");
      this.Deo = true;
      Object localObject = com.tencent.mm.plugin.account.a.a.jRt.bZ(this);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.kd(this);
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
      this.tql.setVisibility(4);
      this.Dek.setVisibility(4);
      localObject1 = this.CYW;
      if (!((SwitchAccountGridView)localObject1).jUE)
      {
        if ((((SwitchAccountGridView)localObject1).Dgf == null) && (!Util.isNullOrNil(((SwitchAccountGridView)localObject1).Dge)))
        {
          int i = Math.min(2, ((SwitchAccountGridView)localObject1).Dgg.size());
          localObject2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.4((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject2).setDuration(200L);
          localObject3 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.5((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject3).setDuration(300L);
          ((SwitchAccountGridView)localObject1).Dgf = new AnimatorSet();
          ((SwitchAccountGridView)localObject1).Dgf.addListener(new SwitchAccountGridView.6((SwitchAccountGridView)localObject1));
          ((SwitchAccountGridView)localObject1).Dgf.playSequentially(new Animator[] { localObject2, localObject3 });
        }
        if (((SwitchAccountGridView)localObject1).Dgf != null)
        {
          ((SwitchAccountGridView)localObject1).jUE = true;
          ((SwitchAccountGridView)localObject1).Dgf.start();
        }
      }
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.plugin.account.friend.a.l.boe();
      com.tencent.mm.platformtools.t.dr(this);
      if (ch.iFO.aWo().size() <= 1) {
        break label417;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(0), ch.iFO.aWp() });
      this.CYW.setOnAnimatorEndListener(new SwitchAccountGridView.a()
      {
        public final void eTz()
        {
          AppMethodBeat.i(74434);
          String str = z.aTY();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setLastLoginWxUsername(str);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setSwitchToWxUsername("");
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).eTN();
          SettingsSwitchAccountUI.i(SettingsSwitchAccountUI.this).start();
          AppMethodBeat.o(74434);
        }
      });
    }
    for (;;)
    {
      if (paramq.getType() == 255)
      {
        if (((u)paramq).jkh != 2) {
          break label1109;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          eTw();
          AppMethodBeat.o(74454);
          return;
          label417:
          com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(0), ch.iFO.aWp() });
          break;
          label456:
          this.CYW.setSwitchToWxUsername("");
          this.Deo = false;
          com.tencent.mm.ui.base.h.cD(this, getString(2131765628));
          localObject1 = ((com.tencent.mm.modelsimple.t)paramq).jjZ;
          if ((!Util.isNullOrNil((String)localObject1)) && (this.CZa.containsKey(localObject1)))
          {
            localObject2 = new Intent();
            localObject3 = (SwitchAccountModel)this.CZa.get(localObject1);
            Log.i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", new Object[] { localObject1, Integer.valueOf(((SwitchAccountModel)localObject3).CXU) });
            if ((WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned()) || ((((SwitchAccountModel)localObject3).CXU & 0x20000) == 0)) {
              break label743;
            }
            ((Intent)localObject2).setClass(this, LoginVoiceUI.class);
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("switch_login_wx_id", (String)localObject1);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.ke(this);
            if (ch.iFO.aWo().size() <= 1) {
              break label756;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(1), ch.iFO.aWp() });
            break;
            label743:
            ((Intent)localObject2).setClass(this, LoginPasswordUI.class);
          }
          label756:
          com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(1), ch.iFO.aWp() });
          continue;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          if (ch.iFO.aWo().size() > 1) {
            com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(7), ch.iFO.aWp() });
          }
          for (;;)
          {
            paramString = new Intent(getContext(), RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(2131764426));
            startActivityForResult(paramString, 701);
            AppMethodBeat.o(74454);
            return;
            com.tencent.mm.plugin.report.service.h.CyF.a(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(7), ch.iFO.aWp() });
          }
        }
        if (!com.tencent.mm.plugin.setting.c.jRu.a(this, paramInt1, paramInt2, paramString)) {
          break label1109;
        }
        AppMethodBeat.o(74454);
        return;
      }
    }
    if (paramq.getType() == 282)
    {
      com.tencent.mm.kernel.g.aAf();
      if (com.tencent.mm.kernel.a.azo())
      {
        paramString = ((ckc)((s)paramq).rr.iLL.iLR).MpB;
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
      paramq = z.aTY();
      Log.i("MicroMsg.SettingsSwitchAccountUI", "logout return username[%s]", new Object[] { paramq });
      ch.iFO.l(paramq, "last_logout_no_pwd_ticket", paramString);
      if ((this.Den != null) && (!this.Den.stopped()))
      {
        this.Den.stopTimer();
        eTx();
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
    f.e(false, true, true);
    if (this.scene == 1)
    {
      SwitchAccountGridView localSwitchAccountGridView = this.CYW;
      if (localSwitchAccountGridView.jUE)
      {
        localSwitchAccountGridView.jUE = false;
        if (localSwitchAccountGridView.Dgf != null) {
          localSwitchAccountGridView.Dgf.end();
        }
      }
    }
    com.tencent.mm.kernel.g.azz().b(701, this);
    com.tencent.mm.kernel.g.azz().b(252, this);
    com.tencent.mm.kernel.g.azz().b(281, this);
    com.tencent.mm.kernel.g.azz().b(282, this);
    com.tencent.mm.kernel.g.azz().b(255, this);
    AppMethodBeat.o(74453);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI
 * JD-Core Version:    0.7.0.1
 */