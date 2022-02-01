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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.g.a.va;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.s;
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
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
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
  implements com.tencent.mm.al.g
{
  private TextView igc;
  private String irg;
  private int scene;
  private TextView titleView;
  private SwitchAccountGridView weh;
  private Map<String, SwitchAccountModel> wel;
  private boolean whl;
  private TextView wjf;
  private View wjg;
  private View wjh;
  private TextView wji;
  private ValueAnimator wjj;
  private av wjk;
  private boolean wjl;
  private boolean wjm;
  private BroadcastReceiver wjn;
  
  public SettingsSwitchAccountUI()
  {
    AppMethodBeat.i(74445);
    this.wel = new HashMap();
    this.wjn = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(74433);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "onReceive %s", new Object[] { paramAnonymousIntent.getAction() });
        SettingsSwitchAccountUI.this.unregisterReceiver(SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this));
        if (bt.nullAsNil(paramAnonymousIntent.getAction()).equals("action_kill_mm_process"))
        {
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.afC().qU("switch account ,delay logout");
          Mars.onSingalCrash(0);
          com.tencent.mm.sdk.platformtools.ad.eFw();
          SettingsSwitchAccountUI.this.finish();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
          paramAnonymousContext = new va();
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousContext);
        }
        AppMethodBeat.o(74433);
      }
    };
    AppMethodBeat.o(74445);
  }
  
  private void amV(String paramString)
  {
    AppMethodBeat.i(74450);
    Object localObject = (SwitchAccountModel)this.wel.get(paramString);
    if ((localObject != null) && (!this.wjl))
    {
      this.wjl = true;
      localObject = new s(paramString, ((SwitchAccountModel)localObject).username, ((SwitchAccountModel)localObject).wdd, "");
      com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
      this.weh.setSwitchToWxUsername(paramString);
      this.weh.doC();
      dok();
    }
    AppMethodBeat.o(74450);
  }
  
  private void amW(String paramString)
  {
    AppMethodBeat.i(74461);
    Object localObject = new IntentFilter("action_kill_mm_process");
    registerReceiver(this.wjn, (IntentFilter)localObject);
    localObject = new Intent(this, FakeSwitchAccountUI.class);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.wel.values());
    ((Intent)localObject).putParcelableArrayListExtra("key_switch_account_users", localArrayList);
    ((Intent)localObject).putExtra("key_switch_from_wx_username", paramString);
    aj.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("transit_to_switch_account", true).commit();
    paramString = ac.f(getSharedPreferences(aj.eFD(), 0));
    float f = com.tencent.mm.cd.a.dT(this);
    ((Intent)localObject).putExtra("key_langauage_code", paramString);
    ((Intent)localObject).putExtra("key_font_scale_size", f);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
    ((Intent)localObject).putExtra("key_mm_process_pid", Process.myPid());
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.jJ(this);
    AppMethodBeat.o(74461);
  }
  
  private void dok()
  {
    AppMethodBeat.i(74451);
    if (this.wjl)
    {
      this.wjf.setVisibility(8);
      AppMethodBeat.o(74451);
      return;
    }
    if ((this.wel.size() <= 1) && (this.scene == 0))
    {
      this.wjf.setVisibility(8);
      this.whl = false;
      this.weh.setDeleteState(false);
      AppMethodBeat.o(74451);
      return;
    }
    if (!this.whl)
    {
      this.titleView.setText(2131763447);
      this.wji.setVisibility(8);
      this.wjf.setText(getString(2131763445));
      this.wjf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74442);
          if (!SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this))
          {
            SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, true);
            SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this));
            SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).doC();
            SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
            if (ca.gPq.asG().size() > 1)
            {
              com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(3), ca.gPq.asH() });
              AppMethodBeat.o(74442);
              return;
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(3), ca.gPq.asH() });
          }
          AppMethodBeat.o(74442);
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    this.titleView.setText(2131763445);
    this.wji.setVisibility(0);
    if (this.wjm)
    {
      this.wjf.setText(getString(2131755779));
      this.wjf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74443);
          SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(false);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).doC();
          SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
          if (SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).getAccountCount() == 0)
          {
            if (ca.gPq.asG().size() <= 1) {
              break label229;
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(11), ca.gPq.asH() });
          }
          for (;;)
          {
            Object localObject = com.tencent.mm.plugin.account.a.a.hYt.bA(SettingsSwitchAccountUI.this);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousView = SettingsSwitchAccountUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            SettingsSwitchAccountUI.this.finish();
            com.tencent.mm.ui.base.b.jI(SettingsSwitchAccountUI.this);
            SettingsSwitchAccountUI.h(SettingsSwitchAccountUI.this);
            AppMethodBeat.o(74443);
            return;
            label229:
            com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(11), ca.gPq.asH() });
          }
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    this.wjf.setText(getString(2131755691));
    this.wjf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74444);
        SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(false);
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).doC();
        SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
        AppMethodBeat.o(74444);
      }
    });
    AppMethodBeat.o(74451);
  }
  
  private void dol()
  {
    AppMethodBeat.i(74459);
    if (com.tencent.mm.kernel.a.mp(com.tencent.mm.kernel.g.afz().gch))
    {
      localObject = new com.tencent.mm.modelsimple.ad(2);
      com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
    }
    Object localObject = new com.tencent.mm.modelsimple.r();
    com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
    this.weh.setLogoutState(true);
    this.weh.doC();
    if (this.wjk == null)
    {
      this.wjk = new av(Looper.getMainLooper(), new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(74435);
          SettingsSwitchAccountUI.j(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74435);
          return false;
        }
      }, false);
      this.wjk.av(8000L, 8000L);
    }
    AppMethodBeat.o(74459);
  }
  
  private void dom()
  {
    AppMethodBeat.i(74460);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
    com.tencent.mm.plugin.setting.b.hYu.Lr();
    this.igc.setVisibility(8);
    this.wjf.setVisibility(8);
    Object localObject = new kr();
    ((kr)localObject).dpk.status = 0;
    ((kr)localObject).dpk.bvJ = 0;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new aa();
    ((aa)localObject).dbS.dbT = true;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    an.aFy("show_whatsnew");
    com.tencent.mm.kernel.l.o(this, true);
    com.tencent.mm.platformtools.t.I(this, null);
    if (com.tencent.mm.kernel.g.afw())
    {
      localObject = com.tencent.mm.ak.c.vN(u.aqG());
      ay.gNa.ua((String)localObject);
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", new Object[] { ay.gNa.ao("login_user_name", "") });
    localObject = u.arp();
    if (bt.isNullOrNil((String)((Map)localObject).get("login_user_name"))) {
      ((Map)localObject).put("login_user_name", ay.gNa.ao("login_user_name", ""));
    }
    ca.gPq.f(u.aqG(), (Map)localObject);
    aj.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
    amW(u.aqG());
    AppMethodBeat.o(74460);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(74455);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "go back");
    if ((this.scene == 2) || (this.scene == 1))
    {
      Object localObject = com.tencent.mm.plugin.account.a.a.hYt.bA(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.jI(this);
      this.wjl = false;
      AppMethodBeat.o(74455);
      return;
    }
    finish();
    AppMethodBeat.o(74455);
  }
  
  private static void logout()
  {
    AppMethodBeat.i(74458);
    if ((com.tencent.mm.kernel.g.aeS() != null) && (com.tencent.mm.kernel.g.aeS().gVH != null)) {
      com.tencent.mm.kernel.g.aeS().gVH.ej(false);
    }
    Object localObject = new gu();
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.kernel.g.afz();
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()) });
    com.tencent.mm.modelstat.c.aBB().commitNow();
    ((com.tencent.mm.plugin.expt.a.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.e.class)).logout();
    localObject = new com.tencent.mm.modelsimple.t(2);
    ((com.tencent.mm.modelsimple.t)localObject).hsm = 1;
    com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
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
    this.wjg = findViewById(2131305573);
    this.wjh = findViewById(2131305571);
    this.titleView = ((TextView)findViewById(2131305572));
    this.wji = ((TextView)findViewById(2131305567));
    this.wjf = ((TextView)findViewById(2131305568));
    this.igc = ((TextView)findViewById(2131305566));
    this.weh = ((SwitchAccountGridView)findViewById(2131305570));
    this.weh.setRowCount(1);
    this.weh.setOnClickAvatarListener(new SwitchAccountGridView.b()
    {
      public final void amX(String paramAnonymousString)
      {
        AppMethodBeat.i(74436);
        if (!bt.isNullOrNil(paramAnonymousString))
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
        aj.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", "").commit();
        if (SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this) == 0)
        {
          SettingsSwitchAccountUI.don();
          AppMethodBeat.o(74436);
          return;
        }
        Object localObject = new Intent(SettingsSwitchAccountUI.this, MobileInputUI.class);
        ((Intent)localObject).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject).putExtra("from_switch_account", true);
        paramAnonymousString = SettingsSwitchAccountUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.jG(SettingsSwitchAccountUI.this);
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
      aj.getContext().sendBroadcast((Intent)localObject1);
      this.igc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74437);
          SettingsSwitchAccountUI.c(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74437);
        }
      });
      localObject1 = ca.gPq.asG();
      com.tencent.mm.kernel.g.afz();
      if (!com.tencent.mm.kernel.a.aeH()) {
        break label746;
      }
      this.irg = ((String)com.tencent.mm.kernel.g.afB().afk().get(2, null));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", new Object[] { Integer.valueOf(this.scene), this.irg });
      if ((bt.isNullOrNil(this.irg)) || (((Set)localObject1).contains(this.irg))) {
        break label764;
      }
      if ((this.scene != 2) || (ca.gPq.uw(this.irg)))
      {
        localObject1 = ay.gNa.ao("login_user_name", "");
        str1 = ay.gNa.arN();
        localObject2 = ay.gNa.ao("last_login_use_voice", "");
        String str2 = ca.gPq.getString(this.irg, "last_logout_no_pwd_ticket");
        localObject1 = new SwitchAccountModel(this.irg, (String)localObject1, str1, str2, bt.aGh((String)localObject2));
        this.wel.put(this.irg, localObject1);
      }
      label415:
      if (this.wel.size() == 0)
      {
        localObject1 = new Intent(this, MobileInputUI.class);
        ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject1).putExtra("can_finish", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.ui.base.b.jJ(this);
      }
      this.weh.aw(this.wel);
      if (this.scene != 1) {
        break label988;
      }
      localObject1 = aj.getContext().getSharedPreferences("switch_account_preferences", 0);
      str1 = ((SharedPreferences)localObject1).getString("last_switch_account_to_wx_username", "");
      ((SharedPreferences)localObject1).edit().putBoolean("transit_to_switch_account", false).commit();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s", new Object[] { str1 });
      if (bt.isNullOrNil(str1)) {
        break label874;
      }
      com.tencent.mm.kernel.g.afz();
      if (!com.tencent.mm.kernel.a.aeH()) {
        break label866;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
      finish();
    }
    for (;;)
    {
      this.weh.doC();
      dok();
      this.weh.setOnDeleteAvatarListener(new SwitchAccountGridView.c()
      {
        public final void amY(final String paramAnonymousString)
        {
          AppMethodBeat.i(74439);
          com.tencent.mm.ui.base.h.d(SettingsSwitchAccountUI.this, SettingsSwitchAccountUI.this.getString(2131763443, new Object[] { ((SwitchAccountModel)SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).get(paramAnonymousString)).username }), SettingsSwitchAccountUI.this.getString(2131755906), SettingsSwitchAccountUI.this.getString(2131755939), SettingsSwitchAccountUI.this.getString(2131755831), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74438);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", new Object[] { paramAnonymousString });
              SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, true);
              ca.gPq.uu(paramAnonymousString);
              SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).remove(paramAnonymousString);
              paramAnonymous2DialogInterface = SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
              String str = paramAnonymousString;
              if (paramAnonymous2DialogInterface.wld.contains(str))
              {
                paramAnonymous2Int = paramAnonymous2DialogInterface.wld.indexOf(str);
                paramAnonymous2DialogInterface.wld.remove(str);
                paramAnonymous2DialogInterface.wle.remove(paramAnonymous2Int);
                paramAnonymous2DialogInterface.wlf.remove(paramAnonymous2Int);
              }
              SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).doC();
              SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
              if (SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this) == 0)
              {
                if (ca.gPq.asG().size() > 0)
                {
                  com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(4), ca.gPq.asH() });
                  AppMethodBeat.o(74438);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(4), ca.gPq.asH() });
              }
              AppMethodBeat.o(74438);
            }
          }, null);
          AppMethodBeat.o(74439);
        }
      });
      this.wjj = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.wjj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(74440);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setTranslationY(-f * SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).getHeight());
          AppMethodBeat.o(74440);
        }
      });
      this.wjj.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(74441);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
          Object localObject = com.tencent.mm.plugin.account.a.a.hYt.bA(SettingsSwitchAccountUI.this);
          ((Intent)localObject).addFlags(67108864);
          paramAnonymousAnimator = SettingsSwitchAccountUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAnimator, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAnimator.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAnimator, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          SettingsSwitchAccountUI.this.finish();
          com.tencent.mm.ui.base.b.jI(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74441);
        }
      });
      this.wjj.setDuration(500L);
      AppMethodBeat.o(74447);
      return;
      this.igc.setVisibility(8);
      break;
      label746:
      this.irg = ay.gNa.ao("login_weixin_username", "");
      break label261;
      label764:
      if (((Set)localObject1).isEmpty()) {
        break label415;
      }
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        str1 = (String)((Iterator)localObject1).next();
        localObject2 = new SwitchAccountModel(str1, ca.gPq.getString(str1, "login_user_name"), ca.gPq.getString(str1, "last_avatar_path"), ca.gPq.getString(str1, "last_logout_no_pwd_ticket"), bt.aGh(ca.gPq.getString(str1, "last_login_use_voice")));
        this.wel.put(str1, localObject2);
      }
      break label415;
      label866:
      amV(str1);
      continue;
      label874:
      this.wjl = false;
      localObject1 = new Intent(this, MobileInputUI.class);
      ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
      ((Intent)localObject1).putExtra("from_switch_account", true);
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jJ(this);
      continue;
      label988:
      if (this.scene == 0) {
        this.weh.setLastLoginWxUsername(this.irg);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74457);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 701) && (paramInt2 == -1)) {
      dol();
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
      unregisterReceiver(this.wjn);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "onResume");
    f.d(true, true, true);
    if ((this.scene == 1) || (this.scene == 2))
    {
      com.tencent.mm.kernel.g.aeS().a(701, this);
      com.tencent.mm.kernel.g.aeS().a(252, this);
    }
    if (this.scene == 0)
    {
      com.tencent.mm.kernel.g.aeS().a(281, this);
      com.tencent.mm.kernel.g.aeS().a(282, this);
      com.tencent.mm.kernel.g.aeS().a(255, this);
    }
    this.weh.doC();
    dok();
    if (((this.scene == 1) || (this.scene == 2)) && (com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "account initialized");
      this.wjl = true;
      Object localObject = com.tencent.mm.plugin.account.a.a.hYt.bA(this);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.jI(this);
    }
    AppMethodBeat.o(74452);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74454);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "errCode %d, errMsg %s, scene %s, type  %d, this %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramn, Integer.valueOf(paramn.getType()), this });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label456;
      }
      this.wjg.setVisibility(4);
      this.wjh.setVisibility(4);
      localObject1 = this.weh;
      if (!((SwitchAccountGridView)localObject1).qMy)
      {
        if ((((SwitchAccountGridView)localObject1).wlc == null) && (!bt.isNullOrNil(((SwitchAccountGridView)localObject1).wlb)))
        {
          int i = Math.min(2, ((SwitchAccountGridView)localObject1).wld.size());
          localObject2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.4((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject2).setDuration(200L);
          localObject3 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.5((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject3).setDuration(300L);
          ((SwitchAccountGridView)localObject1).wlc = new AnimatorSet();
          ((SwitchAccountGridView)localObject1).wlc.addListener(new SwitchAccountGridView.6((SwitchAccountGridView)localObject1));
          ((SwitchAccountGridView)localObject1).wlc.playSequentially(new Animator[] { localObject2, localObject3 });
        }
        if (((SwitchAccountGridView)localObject1).wlc != null)
        {
          ((SwitchAccountGridView)localObject1).qMy = true;
          ((SwitchAccountGridView)localObject1).wlc.start();
        }
      }
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.plugin.account.friend.a.l.aIQ();
      com.tencent.mm.platformtools.t.cN(this);
      if (ca.gPq.asG().size() <= 1) {
        break label417;
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(0), ca.gPq.asH() });
      this.weh.setOnAnimatorEndListener(new SwitchAccountGridView.a()
      {
        public final void doo()
        {
          AppMethodBeat.i(74434);
          String str = u.aqG();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setLastLoginWxUsername(str);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setSwitchToWxUsername("");
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).doC();
          SettingsSwitchAccountUI.i(SettingsSwitchAccountUI.this).start();
          AppMethodBeat.o(74434);
        }
      });
    }
    for (;;)
    {
      if (paramn.getType() == 255)
      {
        if (((com.tencent.mm.modelsimple.t)paramn).hsn != 2) {
          break label1100;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          dol();
          AppMethodBeat.o(74454);
          return;
          label417:
          com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(0), ca.gPq.asH() });
          break;
          label456:
          this.weh.setSwitchToWxUsername("");
          this.wjl = false;
          com.tencent.mm.ui.base.h.cf(this, getString(2131763446));
          localObject1 = ((s)paramn).hsf;
          if ((!bt.isNullOrNil((String)localObject1)) && (this.wel.containsKey(localObject1)))
          {
            localObject2 = new Intent();
            localObject3 = (SwitchAccountModel)this.wel.get(localObject1);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", new Object[] { localObject1, Integer.valueOf(((SwitchAccountModel)localObject3).wde) });
            if ((((SwitchAccountModel)localObject3).wde & 0x20000) == 0) {
              break label734;
            }
            ((Intent)localObject2).setClass(this, LoginVoiceUI.class);
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("switch_login_wx_id", (String)localObject1);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.jJ(this);
            if (ca.gPq.asG().size() <= 1) {
              break label747;
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(1), ca.gPq.asH() });
            break;
            label734:
            ((Intent)localObject2).setClass(this, LoginPasswordUI.class);
          }
          label747:
          com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(1), ca.gPq.asH() });
          continue;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          if (ca.gPq.asG().size() > 1) {
            com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(7), ca.gPq.asH() });
          }
          for (;;)
          {
            paramString = new Intent(getContext(), RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(2131762360));
            startActivityForResult(paramString, 701);
            AppMethodBeat.o(74454);
            return;
            com.tencent.mm.plugin.report.service.h.vKh.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(7), ca.gPq.asH() });
          }
        }
        if (!com.tencent.mm.plugin.setting.b.hYu.a(this, paramInt1, paramInt2, paramString)) {
          break label1100;
        }
        AppMethodBeat.o(74454);
        return;
      }
    }
    if (paramn.getType() == 282)
    {
      com.tencent.mm.kernel.g.afz();
      if (com.tencent.mm.kernel.a.aeH())
      {
        paramString = ((bmr)((com.tencent.mm.modelsimple.r)paramn).rr.gUT.gUX).DKg;
        if (paramString != null) {
          break label1107;
        }
      }
    }
    label1100:
    label1107:
    for (paramInt1 = -1;; paramInt1 = paramString.length())
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SettingsSwitchAccountUI", "logout return noPwdTicket[%s]", new Object[] { Integer.valueOf(paramInt1) });
      if (bt.isNullOrNil(paramString)) {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "no pwd ticket is null!");
      }
      paramn = u.aqG();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "logout return username[%s]", new Object[] { paramn });
      ca.gPq.m(paramn, "last_logout_no_pwd_ticket", paramString);
      if ((this.wjk != null) && (!this.wjk.eFX()))
      {
        this.wjk.stopTimer();
        dom();
      }
      AppMethodBeat.o(74454);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(74453);
    super.onStop();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "onStop");
    f.d(false, true, true);
    if (this.scene == 1)
    {
      SwitchAccountGridView localSwitchAccountGridView = this.weh;
      if (localSwitchAccountGridView.qMy)
      {
        localSwitchAccountGridView.qMy = false;
        if (localSwitchAccountGridView.wlc != null) {
          localSwitchAccountGridView.wlc.end();
        }
      }
    }
    com.tencent.mm.kernel.g.aeS().b(701, this);
    com.tencent.mm.kernel.g.aeS().b(252, this);
    com.tencent.mm.kernel.g.aeS().b(281, this);
    com.tencent.mm.kernel.g.aeS().b(282, this);
    com.tencent.mm.kernel.g.aeS().b(255, this);
    AppMethodBeat.o(74453);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI
 * JD-Core Version:    0.7.0.1
 */