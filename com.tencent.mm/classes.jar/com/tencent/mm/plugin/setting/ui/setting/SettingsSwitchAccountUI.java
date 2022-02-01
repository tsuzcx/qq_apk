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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gv;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.modelsimple.r;
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
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
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
  implements com.tencent.mm.ak.g
{
  private TextView iGl;
  private String iRm;
  private int scene;
  private TextView titleView;
  private SwitchAccountGridView xpv;
  private Map<String, SwitchAccountModel> xpz;
  private boolean xsB;
  private au xuA;
  private boolean xuB;
  private boolean xuC;
  private BroadcastReceiver xuD;
  private TextView xuv;
  private View xuw;
  private View xux;
  private TextView xuy;
  private ValueAnimator xuz;
  
  public SettingsSwitchAccountUI()
  {
    AppMethodBeat.i(74445);
    this.xpz = new HashMap();
    this.xuD = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(74433);
        ac.i("MicroMsg.SettingsSwitchAccountUI", "onReceive %s", new Object[] { paramAnonymousIntent.getAction() });
        SettingsSwitchAccountUI.this.unregisterReceiver(SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this));
        if (bs.nullAsNil(paramAnonymousIntent.getAction()).equals("action_kill_mm_process"))
        {
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.agS().uj("switch account ,delay logout");
          Mars.onSingalCrash(0);
          ac.eUQ();
          SettingsSwitchAccountUI.this.finish();
          ac.i("MicroMsg.SettingsSwitchAccountUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
          paramAnonymousContext = new vk();
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousContext);
        }
        AppMethodBeat.o(74433);
      }
    };
    AppMethodBeat.o(74445);
  }
  
  private void ase(String paramString)
  {
    AppMethodBeat.i(74450);
    Object localObject = (SwitchAccountModel)this.xpz.get(paramString);
    if ((localObject != null) && (!this.xuB))
    {
      this.xuB = true;
      localObject = new com.tencent.mm.modelsimple.s(paramString, ((SwitchAccountModel)localObject).username, ((SwitchAccountModel)localObject).xor, "");
      com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
      this.xpv.setSwitchToWxUsername(paramString);
      this.xpv.dCM();
      dCu();
    }
    AppMethodBeat.o(74450);
  }
  
  private void asf(String paramString)
  {
    AppMethodBeat.i(74461);
    Object localObject = new IntentFilter("action_kill_mm_process");
    registerReceiver(this.xuD, (IntentFilter)localObject);
    localObject = new Intent(this, FakeSwitchAccountUI.class);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.xpz.values());
    ((Intent)localObject).putParcelableArrayListExtra("key_switch_account_users", localArrayList);
    ((Intent)localObject).putExtra("key_switch_from_wx_username", paramString);
    ai.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("transit_to_switch_account", true).commit();
    paramString = com.tencent.mm.sdk.platformtools.ab.f(getSharedPreferences(ai.eUX(), 0));
    float f = com.tencent.mm.cc.a.eb(this);
    ((Intent)localObject).putExtra("key_langauage_code", paramString);
    ((Intent)localObject).putExtra("key_font_scale_size", f);
    ac.i("MicroMsg.SettingsSwitchAccountUI", "mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
    ((Intent)localObject).putExtra("key_mm_process_pid", Process.myPid());
    paramString = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.jU(this);
    AppMethodBeat.o(74461);
  }
  
  private void dCu()
  {
    AppMethodBeat.i(74451);
    if (this.xuB)
    {
      this.xuv.setVisibility(8);
      AppMethodBeat.o(74451);
      return;
    }
    if ((this.xpz.size() <= 1) && (this.scene == 0))
    {
      this.xuv.setVisibility(8);
      this.xsB = false;
      this.xpv.setDeleteState(false);
      AppMethodBeat.o(74451);
      return;
    }
    if (!this.xsB)
    {
      this.titleView.setText(2131763447);
      this.xuy.setVisibility(8);
      this.xuv.setText(getString(2131763445));
      this.xuv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74442);
          if (!SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this))
          {
            SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, true);
            SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this));
            SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dCM();
            SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
            if (ca.hpQ.azx().size() > 1)
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(3), ca.hpQ.azy() });
              AppMethodBeat.o(74442);
              return;
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(3), ca.hpQ.azy() });
          }
          AppMethodBeat.o(74442);
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    this.titleView.setText(2131763445);
    this.xuy.setVisibility(0);
    if (this.xuC)
    {
      this.xuv.setText(getString(2131755779));
      this.xuv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74443);
          SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(false);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dCM();
          SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
          if (SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).getAccountCount() == 0)
          {
            if (ca.hpQ.azx().size() <= 1) {
              break label229;
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(11), ca.hpQ.azy() });
          }
          for (;;)
          {
            Object localObject = com.tencent.mm.plugin.account.a.a.iyx.bD(SettingsSwitchAccountUI.this);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousView = SettingsSwitchAccountUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            SettingsSwitchAccountUI.this.finish();
            com.tencent.mm.ui.base.b.jT(SettingsSwitchAccountUI.this);
            SettingsSwitchAccountUI.h(SettingsSwitchAccountUI.this);
            AppMethodBeat.o(74443);
            return;
            label229:
            com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(11), ca.hpQ.azy() });
          }
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    this.xuv.setText(getString(2131755691));
    this.xuv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74444);
        SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(false);
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dCM();
        SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
        AppMethodBeat.o(74444);
      }
    });
    AppMethodBeat.o(74451);
  }
  
  private void dCv()
  {
    AppMethodBeat.i(74459);
    if (com.tencent.mm.kernel.a.mo(com.tencent.mm.kernel.g.agP().ggN))
    {
      localObject = new ad(2);
      com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
    }
    Object localObject = new r();
    com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
    this.xpv.setLogoutState(true);
    this.xpv.dCM();
    if (this.xuA == null)
    {
      this.xuA = new au(Looper.getMainLooper(), new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(74435);
          SettingsSwitchAccountUI.j(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74435);
          return false;
        }
      }, false);
      this.xuA.au(8000L, 8000L);
    }
    AppMethodBeat.o(74459);
  }
  
  private void dCw()
  {
    AppMethodBeat.i(74460);
    ac.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
    com.tencent.mm.plugin.setting.b.iyy.Lp();
    this.iGl.setVisibility(8);
    this.xuv.setVisibility(8);
    Object localObject = new la();
    ((la)localObject).dmU.status = 0;
    ((la)localObject).dmU.reason = 0;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new com.tencent.mm.g.a.ab();
    ((com.tencent.mm.g.a.ab)localObject).cZr.cZs = true;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    am.aKP("show_whatsnew");
    com.tencent.mm.kernel.l.o(this, true);
    com.tencent.mm.platformtools.t.J(this, null);
    if (com.tencent.mm.kernel.g.agM())
    {
      localObject = com.tencent.mm.aj.c.zT(u.axw());
      ay.hnA.yg((String)localObject);
    }
    ac.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", new Object[] { ay.hnA.aw("login_user_name", "") });
    localObject = u.ayf();
    if (bs.isNullOrNil((String)((Map)localObject).get("login_user_name"))) {
      ((Map)localObject).put("login_user_name", ay.hnA.aw("login_user_name", ""));
    }
    ca.hpQ.f(u.axw(), (Map)localObject);
    ai.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
    asf(u.axw());
    AppMethodBeat.o(74460);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(74455);
    ac.i("MicroMsg.SettingsSwitchAccountUI", "go back");
    if ((this.scene == 2) || (this.scene == 1))
    {
      Object localObject = com.tencent.mm.plugin.account.a.a.iyx.bD(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.jT(this);
      this.xuB = false;
      AppMethodBeat.o(74455);
      return;
    }
    finish();
    AppMethodBeat.o(74455);
  }
  
  private static void logout()
  {
    AppMethodBeat.i(74458);
    if ((com.tencent.mm.kernel.g.agi() != null) && (com.tencent.mm.kernel.g.agi().hwg != null)) {
      com.tencent.mm.kernel.g.agi().hwg.eE(false);
    }
    Object localObject = new gv();
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.kernel.g.agP();
    ac.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()) });
    com.tencent.mm.modelstat.c.aIr().commitNow();
    ((com.tencent.mm.plugin.expt.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.e.class)).logout();
    localObject = new com.tencent.mm.modelsimple.t(2);
    ((com.tencent.mm.modelsimple.t)localObject).hSO = 1;
    com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
    AppMethodBeat.o(74458);
  }
  
  public int getLayoutId()
  {
    return 2131495406;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74447);
    setMMTitle("");
    showMMLogo();
    getSupportActionBar().hide();
    getController().q(this, getContext().getResources().getColor(2131101179));
    this.scene = getIntent().getIntExtra("key_scene", 0);
    this.xuw = findViewById(2131305573);
    this.xux = findViewById(2131305571);
    this.titleView = ((TextView)findViewById(2131305572));
    this.xuy = ((TextView)findViewById(2131305567));
    this.xuv = ((TextView)findViewById(2131305568));
    this.iGl = ((TextView)findViewById(2131305566));
    this.xpv = ((SwitchAccountGridView)findViewById(2131305570));
    this.xpv.setRowCount(1);
    this.xpv.setOnClickAvatarListener(new SwitchAccountGridView.b()
    {
      public final void asg(String paramAnonymousString)
      {
        AppMethodBeat.i(74436);
        if (!bs.isNullOrNil(paramAnonymousString))
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
        ai.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", "").commit();
        if (SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this) == 0)
        {
          SettingsSwitchAccountUI.dCx();
          AppMethodBeat.o(74436);
          return;
        }
        Object localObject = new Intent(SettingsSwitchAccountUI.this, MobileInputUI.class);
        ((Intent)localObject).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject).putExtra("from_switch_account", true);
        paramAnonymousString = SettingsSwitchAccountUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.jR(SettingsSwitchAccountUI.this);
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
      ai.getContext().sendBroadcast((Intent)localObject1);
      this.iGl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74437);
          SettingsSwitchAccountUI.c(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74437);
        }
      });
      localObject1 = ca.hpQ.azx();
      com.tencent.mm.kernel.g.agP();
      if (!com.tencent.mm.kernel.a.afX()) {
        break label746;
      }
      this.iRm = ((String)com.tencent.mm.kernel.g.agR().agA().get(2, null));
      ac.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", new Object[] { Integer.valueOf(this.scene), this.iRm });
      if ((bs.isNullOrNil(this.iRm)) || (((Set)localObject1).contains(this.iRm))) {
        break label764;
      }
      if ((this.scene != 2) || (ca.hpQ.yC(this.iRm)))
      {
        localObject1 = ay.hnA.aw("login_user_name", "");
        str1 = ay.hnA.ayE();
        localObject2 = ay.hnA.aw("last_login_use_voice", "");
        String str2 = ca.hpQ.getString(this.iRm, "last_logout_no_pwd_ticket");
        localObject1 = new SwitchAccountModel(this.iRm, (String)localObject1, str1, str2, bs.aLy((String)localObject2));
        this.xpz.put(this.iRm, localObject1);
      }
      label415:
      if (this.xpz.size() == 0)
      {
        localObject1 = new Intent(this, MobileInputUI.class);
        ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject1).putExtra("can_finish", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.ui.base.b.jU(this);
      }
      this.xpv.ay(this.xpz);
      if (this.scene != 1) {
        break label988;
      }
      localObject1 = ai.getContext().getSharedPreferences("switch_account_preferences", 0);
      str1 = ((SharedPreferences)localObject1).getString("last_switch_account_to_wx_username", "");
      ((SharedPreferences)localObject1).edit().putBoolean("transit_to_switch_account", false).commit();
      ac.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s", new Object[] { str1 });
      if (bs.isNullOrNil(str1)) {
        break label874;
      }
      com.tencent.mm.kernel.g.agP();
      if (!com.tencent.mm.kernel.a.afX()) {
        break label866;
      }
      ac.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
      finish();
    }
    for (;;)
    {
      this.xpv.dCM();
      dCu();
      this.xpv.setOnDeleteAvatarListener(new SwitchAccountGridView.c()
      {
        public final void ash(final String paramAnonymousString)
        {
          AppMethodBeat.i(74439);
          com.tencent.mm.ui.base.h.d(SettingsSwitchAccountUI.this, SettingsSwitchAccountUI.this.getString(2131763443, new Object[] { ((SwitchAccountModel)SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).get(paramAnonymousString)).username }), SettingsSwitchAccountUI.this.getString(2131755906), SettingsSwitchAccountUI.this.getString(2131755939), SettingsSwitchAccountUI.this.getString(2131755831), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74438);
              ac.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", new Object[] { paramAnonymousString });
              SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, true);
              ca.hpQ.yA(paramAnonymousString);
              SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).remove(paramAnonymousString);
              paramAnonymous2DialogInterface = SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
              String str = paramAnonymousString;
              if (paramAnonymous2DialogInterface.xwt.contains(str))
              {
                paramAnonymous2Int = paramAnonymous2DialogInterface.xwt.indexOf(str);
                paramAnonymous2DialogInterface.xwt.remove(str);
                paramAnonymous2DialogInterface.xwu.remove(paramAnonymous2Int);
                paramAnonymous2DialogInterface.xwv.remove(paramAnonymous2Int);
              }
              SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dCM();
              SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
              if (SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this) == 0)
              {
                if (ca.hpQ.azx().size() > 0)
                {
                  com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(4), ca.hpQ.azy() });
                  AppMethodBeat.o(74438);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(4), ca.hpQ.azy() });
              }
              AppMethodBeat.o(74438);
            }
          }, null);
          AppMethodBeat.o(74439);
        }
      });
      this.xuz = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.xuz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(74440);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setTranslationY(-f * SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).getHeight());
          AppMethodBeat.o(74440);
        }
      });
      this.xuz.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(74441);
          ac.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
          Object localObject = com.tencent.mm.plugin.account.a.a.iyx.bD(SettingsSwitchAccountUI.this);
          ((Intent)localObject).addFlags(67108864);
          paramAnonymousAnimator = SettingsSwitchAccountUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAnimator, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAnimator.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAnimator, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          SettingsSwitchAccountUI.this.finish();
          com.tencent.mm.ui.base.b.jT(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74441);
        }
      });
      this.xuz.setDuration(500L);
      AppMethodBeat.o(74447);
      return;
      this.iGl.setVisibility(8);
      break;
      label746:
      this.iRm = ay.hnA.aw("login_weixin_username", "");
      break label261;
      label764:
      if (((Set)localObject1).isEmpty()) {
        break label415;
      }
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        str1 = (String)((Iterator)localObject1).next();
        localObject2 = new SwitchAccountModel(str1, ca.hpQ.getString(str1, "login_user_name"), ca.hpQ.getString(str1, "last_avatar_path"), ca.hpQ.getString(str1, "last_logout_no_pwd_ticket"), bs.aLy(ca.hpQ.getString(str1, "last_login_use_voice")));
        this.xpz.put(str1, localObject2);
      }
      break label415;
      label866:
      ase(str1);
      continue;
      label874:
      this.xuB = false;
      localObject1 = new Intent(this, MobileInputUI.class);
      ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
      ((Intent)localObject1).putExtra("from_switch_account", true);
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jU(this);
      continue;
      label988:
      if (this.scene == 0) {
        this.xpv.setLastLoginWxUsername(this.iRm);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74457);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 701) && (paramInt2 == -1)) {
      dCv();
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
      unregisterReceiver(this.xuD);
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
    ac.i("MicroMsg.SettingsSwitchAccountUI", "onResume");
    f.e(true, true, true);
    if ((this.scene == 1) || (this.scene == 2))
    {
      com.tencent.mm.kernel.g.agi().a(701, this);
      com.tencent.mm.kernel.g.agi().a(252, this);
    }
    if (this.scene == 0)
    {
      com.tencent.mm.kernel.g.agi().a(281, this);
      com.tencent.mm.kernel.g.agi().a(282, this);
      com.tencent.mm.kernel.g.agi().a(255, this);
    }
    this.xpv.dCM();
    dCu();
    if (((this.scene == 1) || (this.scene == 2)) && (com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
    {
      ac.i("MicroMsg.SettingsSwitchAccountUI", "account initialized");
      this.xuB = true;
      Object localObject = com.tencent.mm.plugin.account.a.a.iyx.bD(this);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.jT(this);
    }
    AppMethodBeat.o(74452);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74454);
    ac.i("MicroMsg.SettingsSwitchAccountUI", "errCode %d, errMsg %s, scene %s, type  %d, this %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramn, Integer.valueOf(paramn.getType()), this });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label456;
      }
      this.xuw.setVisibility(4);
      this.xux.setVisibility(4);
      localObject1 = this.xpv;
      if (!((SwitchAccountGridView)localObject1).iBD)
      {
        if ((((SwitchAccountGridView)localObject1).xws == null) && (!bs.isNullOrNil(((SwitchAccountGridView)localObject1).xwr)))
        {
          int i = Math.min(2, ((SwitchAccountGridView)localObject1).xwt.size());
          localObject2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.4((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject2).setDuration(200L);
          localObject3 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.5((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject3).setDuration(300L);
          ((SwitchAccountGridView)localObject1).xws = new AnimatorSet();
          ((SwitchAccountGridView)localObject1).xws.addListener(new SwitchAccountGridView.6((SwitchAccountGridView)localObject1));
          ((SwitchAccountGridView)localObject1).xws.playSequentially(new Animator[] { localObject2, localObject3 });
        }
        if (((SwitchAccountGridView)localObject1).xws != null)
        {
          ((SwitchAccountGridView)localObject1).iBD = true;
          ((SwitchAccountGridView)localObject1).xws.start();
        }
      }
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.plugin.account.friend.a.l.aPH();
      com.tencent.mm.platformtools.t.cW(this);
      if (ca.hpQ.azx().size() <= 1) {
        break label417;
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(0), ca.hpQ.azy() });
      this.xpv.setOnAnimatorEndListener(new SwitchAccountGridView.a()
      {
        public final void dCy()
        {
          AppMethodBeat.i(74434);
          String str = u.axw();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setLastLoginWxUsername(str);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setSwitchToWxUsername("");
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dCM();
          SettingsSwitchAccountUI.i(SettingsSwitchAccountUI.this).start();
          AppMethodBeat.o(74434);
        }
      });
    }
    for (;;)
    {
      if (paramn.getType() == 255)
      {
        if (((com.tencent.mm.modelsimple.t)paramn).hSP != 2) {
          break label1100;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          dCv();
          AppMethodBeat.o(74454);
          return;
          label417:
          com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(0), ca.hpQ.azy() });
          break;
          label456:
          this.xpv.setSwitchToWxUsername("");
          this.xuB = false;
          com.tencent.mm.ui.base.h.cg(this, getString(2131763446));
          localObject1 = ((com.tencent.mm.modelsimple.s)paramn).hSH;
          if ((!bs.isNullOrNil((String)localObject1)) && (this.xpz.containsKey(localObject1)))
          {
            localObject2 = new Intent();
            localObject3 = (SwitchAccountModel)this.xpz.get(localObject1);
            ac.i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", new Object[] { localObject1, Integer.valueOf(((SwitchAccountModel)localObject3).xos) });
            if ((((SwitchAccountModel)localObject3).xos & 0x20000) == 0) {
              break label734;
            }
            ((Intent)localObject2).setClass(this, LoginVoiceUI.class);
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("switch_login_wx_id", (String)localObject1);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.jU(this);
            if (ca.hpQ.azx().size() <= 1) {
              break label747;
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(1), ca.hpQ.azy() });
            break;
            label734:
            ((Intent)localObject2).setClass(this, LoginPasswordUI.class);
          }
          label747:
          com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(1), ca.hpQ.azy() });
          continue;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          if (ca.hpQ.azx().size() > 1) {
            com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(7), ca.hpQ.azy() });
          }
          for (;;)
          {
            paramString = new Intent(getContext(), RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(2131762360));
            startActivityForResult(paramString, 701);
            AppMethodBeat.o(74454);
            return;
            com.tencent.mm.plugin.report.service.h.wUl.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(7), ca.hpQ.azy() });
          }
        }
        if (!com.tencent.mm.plugin.setting.b.iyy.a(this, paramInt1, paramInt2, paramString)) {
          break label1100;
        }
        AppMethodBeat.o(74454);
        return;
      }
    }
    if (paramn.getType() == 282)
    {
      com.tencent.mm.kernel.g.agP();
      if (com.tencent.mm.kernel.a.afX())
      {
        paramString = ((brh)((r)paramn).rr.hvs.hvw).Fgv;
        if (paramString != null) {
          break label1107;
        }
      }
    }
    label1100:
    label1107:
    for (paramInt1 = -1;; paramInt1 = paramString.length())
    {
      ac.d("MicroMsg.SettingsSwitchAccountUI", "logout return noPwdTicket[%s]", new Object[] { Integer.valueOf(paramInt1) });
      if (bs.isNullOrNil(paramString)) {
        ac.i("MicroMsg.SettingsSwitchAccountUI", "no pwd ticket is null!");
      }
      paramn = u.axw();
      ac.i("MicroMsg.SettingsSwitchAccountUI", "logout return username[%s]", new Object[] { paramn });
      ca.hpQ.m(paramn, "last_logout_no_pwd_ticket", paramString);
      if ((this.xuA != null) && (!this.xuA.eVs()))
      {
        this.xuA.stopTimer();
        dCw();
      }
      AppMethodBeat.o(74454);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(74453);
    super.onStop();
    ac.i("MicroMsg.SettingsSwitchAccountUI", "onStop");
    f.e(false, true, true);
    if (this.scene == 1)
    {
      SwitchAccountGridView localSwitchAccountGridView = this.xpv;
      if (localSwitchAccountGridView.iBD)
      {
        localSwitchAccountGridView.iBD = false;
        if (localSwitchAccountGridView.xws != null) {
          localSwitchAccountGridView.xws.end();
        }
      }
    }
    com.tencent.mm.kernel.g.agi().b(701, this);
    com.tencent.mm.kernel.g.agi().b(252, this);
    com.tencent.mm.kernel.g.agi().b(281, this);
    com.tencent.mm.kernel.g.agi().b(282, this);
    com.tencent.mm.kernel.g.agi().b(255, this);
    AppMethodBeat.o(74453);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI
 * JD-Core Version:    0.7.0.1
 */