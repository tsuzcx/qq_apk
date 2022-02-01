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
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.wd;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.plugin.account.ui.LoginPasswordUI;
import com.tencent.mm.plugin.account.ui.LoginVoiceUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
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
import com.tencent.mm.protocal.protobuf.bvu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class SettingsSwitchAccountUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private TextView iZu;
  private String jku;
  private int scene;
  private TextView titleView;
  private SwitchAccountGridView yDY;
  private Map<String, SwitchAccountModel> yEc;
  private boolean yHk;
  private TextView yJg;
  private View yJh;
  private View yJi;
  private TextView yJj;
  private ValueAnimator yJk;
  private av yJl;
  private boolean yJm;
  private boolean yJn;
  private BroadcastReceiver yJo;
  
  public SettingsSwitchAccountUI()
  {
    AppMethodBeat.i(74445);
    this.yEc = new HashMap();
    this.yJo = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(74433);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "onReceive %s", new Object[] { paramAnonymousIntent.getAction() });
        SettingsSwitchAccountUI.this.unregisterReceiver(SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this));
        if (bt.nullAsNil(paramAnonymousIntent.getAction()).equals("action_kill_mm_process"))
        {
          com.tencent.mm.kernel.g.ajA();
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.ajD().wZ("switch account ,delay logout");
          Mars.onSingalCrash(0);
          com.tencent.mm.sdk.platformtools.ad.fku();
          SettingsSwitchAccountUI.this.finish();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
          paramAnonymousContext = new wd();
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousContext);
        }
        AppMethodBeat.o(74433);
      }
    };
    AppMethodBeat.o(74445);
  }
  
  private void axe(String paramString)
  {
    AppMethodBeat.i(74450);
    Object localObject = (SwitchAccountModel)this.yEc.get(paramString);
    if ((localObject != null) && (!this.yJm))
    {
      this.yJm = true;
      localObject = new com.tencent.mm.modelsimple.s(paramString, ((SwitchAccountModel)localObject).username, ((SwitchAccountModel)localObject).yCW, "");
      com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
      this.yDY.setSwitchToWxUsername(paramString);
      this.yDY.dOp();
      dNX();
    }
    AppMethodBeat.o(74450);
  }
  
  private void axf(String paramString)
  {
    AppMethodBeat.i(74461);
    Object localObject = new IntentFilter("action_kill_mm_process");
    registerReceiver(this.yJo, (IntentFilter)localObject);
    localObject = new Intent(this, FakeSwitchAccountUI.class);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.yEc.values());
    ((Intent)localObject).putParcelableArrayListExtra("key_switch_account_users", localArrayList);
    ((Intent)localObject).putExtra("key_switch_from_wx_username", paramString);
    aj.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("transit_to_switch_account", true).commit();
    paramString = ac.f(getSharedPreferences(aj.fkC(), 0));
    float f = com.tencent.mm.cc.a.eb(this);
    ((Intent)localObject).putExtra("key_langauage_code", paramString);
    ((Intent)localObject).putExtra("key_font_scale_size", f);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
    ((Intent)localObject).putExtra("key_mm_process_pid", Process.myPid());
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.kf(this);
    AppMethodBeat.o(74461);
  }
  
  private void dNX()
  {
    AppMethodBeat.i(74451);
    if (this.yJm)
    {
      this.yJg.setVisibility(8);
      AppMethodBeat.o(74451);
      return;
    }
    if ((this.yEc.size() <= 1) && (this.scene == 0))
    {
      this.yJg.setVisibility(8);
      this.yHk = false;
      this.yDY.setDeleteState(false);
      AppMethodBeat.o(74451);
      return;
    }
    if (!this.yHk)
    {
      this.titleView.setText(2131763447);
      this.yJj.setVisibility(8);
      this.yJg.setText(getString(2131763445));
      this.yJg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this))
          {
            SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, true);
            SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this));
            SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dOp();
            SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
            if (cb.hIi.aCA().size() <= 1) {
              break label156;
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(3), cb.hIi.aCB() });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74442);
            return;
            label156:
            com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(3), cb.hIi.aCB() });
          }
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    this.titleView.setText(2131763445);
    this.yJj.setVisibility(0);
    if (this.yJn)
    {
      this.yJg.setText(getString(2131755779));
      this.yJg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74443);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(false);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dOp();
          SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
          if (SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).getAccountCount() == 0)
          {
            if (cb.hIi.aCA().size() <= 1) {
              break label270;
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(11), cb.hIi.aCB() });
          }
          for (;;)
          {
            localObject = com.tencent.mm.plugin.account.a.a.iRG.bC(SettingsSwitchAccountUI.this);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousView = SettingsSwitchAccountUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            SettingsSwitchAccountUI.this.finish();
            com.tencent.mm.ui.base.b.ke(SettingsSwitchAccountUI.this);
            SettingsSwitchAccountUI.h(SettingsSwitchAccountUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74443);
            return;
            label270:
            com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(11), cb.hIi.aCB() });
          }
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    this.yJg.setText(getString(2131755691));
    this.yJg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74444);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(false);
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dOp();
        SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74444);
      }
    });
    AppMethodBeat.o(74451);
  }
  
  private void dNY()
  {
    AppMethodBeat.i(74459);
    if (com.tencent.mm.kernel.a.mN(com.tencent.mm.kernel.g.ajA().gAx))
    {
      localObject = new com.tencent.mm.modelsimple.ad(2);
      com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
    }
    Object localObject = new r();
    com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
    this.yDY.setLogoutState(true);
    this.yDY.dOp();
    if (this.yJl == null)
    {
      this.yJl = new av(Looper.getMainLooper(), new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(74435);
          SettingsSwitchAccountUI.j(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74435);
          return false;
        }
      }, false);
      this.yJl.az(8000L, 8000L);
    }
    AppMethodBeat.o(74459);
  }
  
  private void dNZ()
  {
    AppMethodBeat.i(74460);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
    com.tencent.mm.plugin.setting.b.iRH.MX();
    this.iZu.setVisibility(8);
    this.yJg.setVisibility(8);
    Object localObject = new lj();
    ((lj)localObject).dyI.status = 0;
    ((lj)localObject).dyI.reason = 0;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new ab();
    ((ab)localObject).dkJ.dkK = true;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    an.aQv("show_whatsnew");
    com.tencent.mm.kernel.l.q(this, true);
    com.tencent.mm.platformtools.t.I(this, null);
    if (com.tencent.mm.kernel.g.ajx())
    {
      localObject = com.tencent.mm.ak.c.CS(u.aAm());
      az.hFS.Be((String)localObject);
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", new Object[] { az.hFS.ax("login_user_name", "") });
    localObject = u.aBf();
    if (bt.isNullOrNil((String)((Map)localObject).get("login_user_name"))) {
      ((Map)localObject).put("login_user_name", az.hFS.ax("login_user_name", ""));
    }
    cb.hIi.g(u.aAm(), (Map)localObject);
    aj.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
    axf(u.aAm());
    AppMethodBeat.o(74460);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(74455);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "go back");
    if ((this.scene == 2) || (this.scene == 1))
    {
      Object localObject = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.ke(this);
      this.yJm = false;
      AppMethodBeat.o(74455);
      return;
    }
    finish();
    AppMethodBeat.o(74455);
  }
  
  private static void logout()
  {
    AppMethodBeat.i(74458);
    if ((com.tencent.mm.kernel.g.aiU() != null) && (com.tencent.mm.kernel.g.aiU().hOv != null)) {
      com.tencent.mm.kernel.g.aiU().hOv.eG(false);
    }
    Object localObject = new gy();
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.kernel.g.ajA();
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()) });
    com.tencent.mm.modelstat.c.aLB().commitNow();
    ((com.tencent.mm.plugin.expt.b.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.e.class)).logout();
    localObject = new com.tencent.mm.modelsimple.t(2);
    ((com.tencent.mm.modelsimple.t)localObject).imf = 1;
    com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
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
    this.yJh = findViewById(2131305573);
    this.yJi = findViewById(2131305571);
    this.titleView = ((TextView)findViewById(2131305572));
    this.yJj = ((TextView)findViewById(2131305567));
    this.yJg = ((TextView)findViewById(2131305568));
    this.iZu = ((TextView)findViewById(2131305566));
    this.yDY = ((SwitchAccountGridView)findViewById(2131305570));
    this.yDY.setRowCount(1);
    this.yDY.setOnClickAvatarListener(new SwitchAccountGridView.b()
    {
      public final void axg(String paramAnonymousString)
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
          SettingsSwitchAccountUI.dOa();
          AppMethodBeat.o(74436);
          return;
        }
        Object localObject = new Intent(SettingsSwitchAccountUI.this, MobileInputUI.class);
        ((Intent)localObject).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject).putExtra("from_switch_account", true);
        paramAnonymousString = SettingsSwitchAccountUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.kc(SettingsSwitchAccountUI.this);
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
      this.iZu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74437);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          SettingsSwitchAccountUI.c(SettingsSwitchAccountUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74437);
        }
      });
      localObject1 = cb.hIi.aCA();
      com.tencent.mm.kernel.g.ajA();
      if (!com.tencent.mm.kernel.a.aiJ()) {
        break label746;
      }
      this.jku = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(2, null));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", new Object[] { Integer.valueOf(this.scene), this.jku });
      if ((bt.isNullOrNil(this.jku)) || (((Set)localObject1).contains(this.jku))) {
        break label764;
      }
      if ((this.scene != 2) || (cb.hIi.BB(this.jku)))
      {
        localObject1 = az.hFS.ax("login_user_name", "");
        str1 = az.hFS.aBI();
        localObject2 = az.hFS.ax("last_login_use_voice", "");
        String str2 = cb.hIi.getString(this.jku, "last_logout_no_pwd_ticket");
        localObject1 = new SwitchAccountModel(this.jku, (String)localObject1, str1, str2, bt.aRe((String)localObject2));
        this.yEc.put(this.jku, localObject1);
      }
      label415:
      if (this.yEc.size() == 0)
      {
        localObject1 = new Intent(this, MobileInputUI.class);
        ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject1).putExtra("can_finish", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.ui.base.b.kf(this);
      }
      this.yDY.aB(this.yEc);
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
      com.tencent.mm.kernel.g.ajA();
      if (!com.tencent.mm.kernel.a.aiJ()) {
        break label866;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
      finish();
    }
    for (;;)
    {
      this.yDY.dOp();
      dNX();
      this.yDY.setOnDeleteAvatarListener(new SwitchAccountGridView.c()
      {
        public final void axh(final String paramAnonymousString)
        {
          AppMethodBeat.i(74439);
          h.e(SettingsSwitchAccountUI.this, SettingsSwitchAccountUI.this.getString(2131763443, new Object[] { ((SwitchAccountModel)SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).get(paramAnonymousString)).username }), SettingsSwitchAccountUI.this.getString(2131755906), SettingsSwitchAccountUI.this.getString(2131755939), SettingsSwitchAccountUI.this.getString(2131755831), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74438);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", new Object[] { paramAnonymousString });
              SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, true);
              cb.hIi.Bz(paramAnonymousString);
              SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).remove(paramAnonymousString);
              paramAnonymous2DialogInterface = SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
              String str = paramAnonymousString;
              if (paramAnonymous2DialogInterface.yLe.contains(str))
              {
                paramAnonymous2Int = paramAnonymous2DialogInterface.yLe.indexOf(str);
                paramAnonymous2DialogInterface.yLe.remove(str);
                paramAnonymous2DialogInterface.yLf.remove(paramAnonymous2Int);
                paramAnonymous2DialogInterface.yLg.remove(paramAnonymous2Int);
              }
              SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dOp();
              SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
              if (SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this) == 0)
              {
                if (cb.hIi.aCA().size() > 0)
                {
                  com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(4), cb.hIi.aCB() });
                  AppMethodBeat.o(74438);
                  return;
                }
                com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(4), cb.hIi.aCB() });
              }
              AppMethodBeat.o(74438);
            }
          }, null);
          AppMethodBeat.o(74439);
        }
      });
      this.yJk = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.yJk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(74440);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setTranslationY(-f * SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).getHeight());
          AppMethodBeat.o(74440);
        }
      });
      this.yJk.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(74441);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
          Object localObject = com.tencent.mm.plugin.account.a.a.iRG.bC(SettingsSwitchAccountUI.this);
          ((Intent)localObject).addFlags(67108864);
          paramAnonymousAnimator = SettingsSwitchAccountUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAnimator, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAnimator.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAnimator, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          SettingsSwitchAccountUI.this.finish();
          com.tencent.mm.ui.base.b.ke(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74441);
        }
      });
      this.yJk.setDuration(500L);
      AppMethodBeat.o(74447);
      return;
      this.iZu.setVisibility(8);
      break;
      label746:
      this.jku = az.hFS.ax("login_weixin_username", "");
      break label261;
      label764:
      if (((Set)localObject1).isEmpty()) {
        break label415;
      }
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        str1 = (String)((Iterator)localObject1).next();
        localObject2 = new SwitchAccountModel(str1, cb.hIi.getString(str1, "login_user_name"), cb.hIi.getString(str1, "last_avatar_path"), cb.hIi.getString(str1, "last_logout_no_pwd_ticket"), bt.aRe(cb.hIi.getString(str1, "last_login_use_voice")));
        this.yEc.put(str1, localObject2);
      }
      break label415;
      label866:
      axe(str1);
      continue;
      label874:
      this.yJm = false;
      localObject1 = new Intent(this, MobileInputUI.class);
      ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
      ((Intent)localObject1).putExtra("from_switch_account", true);
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kf(this);
      continue;
      label988:
      if (this.scene == 0) {
        this.yDY.setLastLoginWxUsername(this.jku);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74457);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 701) && (paramInt2 == -1)) {
      dNY();
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
      unregisterReceiver(this.yJo);
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
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    if ((this.scene == 1) || (this.scene == 2))
    {
      com.tencent.mm.kernel.g.aiU().a(701, this);
      com.tencent.mm.kernel.g.aiU().a(252, this);
    }
    if (this.scene == 0)
    {
      com.tencent.mm.kernel.g.aiU().a(281, this);
      com.tencent.mm.kernel.g.aiU().a(282, this);
      com.tencent.mm.kernel.g.aiU().a(255, this);
    }
    this.yDY.dOp();
    dNX();
    if (((this.scene == 1) || (this.scene == 2)) && (com.tencent.mm.kernel.g.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "account initialized");
      this.yJm = true;
      Object localObject = com.tencent.mm.plugin.account.a.a.iRG.bC(this);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.ke(this);
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
      this.yJh.setVisibility(4);
      this.yJi.setVisibility(4);
      localObject1 = this.yDY;
      if (!((SwitchAccountGridView)localObject1).iUN)
      {
        if ((((SwitchAccountGridView)localObject1).yLd == null) && (!bt.isNullOrNil(((SwitchAccountGridView)localObject1).yLc)))
        {
          int i = Math.min(2, ((SwitchAccountGridView)localObject1).yLe.size());
          localObject2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.4((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject2).setDuration(200L);
          localObject3 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.5((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject3).setDuration(300L);
          ((SwitchAccountGridView)localObject1).yLd = new AnimatorSet();
          ((SwitchAccountGridView)localObject1).yLd.addListener(new SwitchAccountGridView.6((SwitchAccountGridView)localObject1));
          ((SwitchAccountGridView)localObject1).yLd.playSequentially(new Animator[] { localObject2, localObject3 });
        }
        if (((SwitchAccountGridView)localObject1).yLd != null)
        {
          ((SwitchAccountGridView)localObject1).iUN = true;
          ((SwitchAccountGridView)localObject1).yLd.start();
        }
      }
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.plugin.account.friend.a.l.aST();
      com.tencent.mm.platformtools.t.cU(this);
      if (cb.hIi.aCA().size() <= 1) {
        break label417;
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(0), cb.hIi.aCB() });
      this.yDY.setOnAnimatorEndListener(new SwitchAccountGridView.a()
      {
        public final void dOb()
        {
          AppMethodBeat.i(74434);
          String str = u.aAm();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setLastLoginWxUsername(str);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setSwitchToWxUsername("");
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dOp();
          SettingsSwitchAccountUI.i(SettingsSwitchAccountUI.this).start();
          AppMethodBeat.o(74434);
        }
      });
    }
    for (;;)
    {
      if (paramn.getType() == 255)
      {
        if (((com.tencent.mm.modelsimple.t)paramn).img != 2) {
          break label1100;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          dNY();
          AppMethodBeat.o(74454);
          return;
          label417:
          com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(0), cb.hIi.aCB() });
          break;
          label456:
          this.yDY.setSwitchToWxUsername("");
          this.yJm = false;
          h.cl(this, getString(2131763446));
          localObject1 = ((com.tencent.mm.modelsimple.s)paramn).ilY;
          if ((!bt.isNullOrNil((String)localObject1)) && (this.yEc.containsKey(localObject1)))
          {
            localObject2 = new Intent();
            localObject3 = (SwitchAccountModel)this.yEc.get(localObject1);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", new Object[] { localObject1, Integer.valueOf(((SwitchAccountModel)localObject3).yCX) });
            if ((((SwitchAccountModel)localObject3).yCX & 0x20000) == 0) {
              break label734;
            }
            ((Intent)localObject2).setClass(this, LoginVoiceUI.class);
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("switch_login_wx_id", (String)localObject1);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.kf(this);
            if (cb.hIi.aCA().size() <= 1) {
              break label747;
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(1), cb.hIi.aCB() });
            break;
            label734:
            ((Intent)localObject2).setClass(this, LoginPasswordUI.class);
          }
          label747:
          com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(1), cb.hIi.aCB() });
          continue;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          if (cb.hIi.aCA().size() > 1) {
            com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(7), cb.hIi.aCB() });
          }
          for (;;)
          {
            paramString = new Intent(getContext(), RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(2131762360));
            startActivityForResult(paramString, 701);
            AppMethodBeat.o(74454);
            return;
            com.tencent.mm.plugin.report.service.g.yhR.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(7), cb.hIi.aCB() });
          }
        }
        if (!com.tencent.mm.plugin.setting.b.iRH.a(this, paramInt1, paramInt2, paramString)) {
          break label1100;
        }
        AppMethodBeat.o(74454);
        return;
      }
    }
    if (paramn.getType() == 282)
    {
      com.tencent.mm.kernel.g.ajA();
      if (com.tencent.mm.kernel.a.aiJ())
      {
        paramString = ((bvu)((r)paramn).rr.hNL.hNQ).GPX;
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
      paramn = u.aAm();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SettingsSwitchAccountUI", "logout return username[%s]", new Object[] { paramn });
      cb.hIi.l(paramn, "last_logout_no_pwd_ticket", paramString);
      if ((this.yJl != null) && (!this.yJl.fkZ()))
      {
        this.yJl.stopTimer();
        dNZ();
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
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.scene == 1)
    {
      SwitchAccountGridView localSwitchAccountGridView = this.yDY;
      if (localSwitchAccountGridView.iUN)
      {
        localSwitchAccountGridView.iUN = false;
        if (localSwitchAccountGridView.yLd != null) {
          localSwitchAccountGridView.yLd.end();
        }
      }
    }
    com.tencent.mm.kernel.g.aiU().b(701, this);
    com.tencent.mm.kernel.g.aiU().b(252, this);
    com.tencent.mm.kernel.g.aiU().b(281, this);
    com.tencent.mm.kernel.g.aiU().b(282, this);
    com.tencent.mm.kernel.g.aiU().b(255, this);
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