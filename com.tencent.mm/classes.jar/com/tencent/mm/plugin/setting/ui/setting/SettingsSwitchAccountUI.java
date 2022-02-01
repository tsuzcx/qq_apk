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
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsimple.u;
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
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
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
  implements com.tencent.mm.ak.f
{
  private TextView jcn;
  private String jno;
  private int scene;
  private TextView titleView;
  private SwitchAccountGridView yUd;
  private Map<String, SwitchAccountModel> yUh;
  private boolean yXu;
  private TextView yZq;
  private View yZr;
  private View yZs;
  private TextView yZt;
  private ValueAnimator yZu;
  private aw yZv;
  private boolean yZw;
  private boolean yZx;
  private BroadcastReceiver yZy;
  
  public SettingsSwitchAccountUI()
  {
    AppMethodBeat.i(74445);
    this.yUh = new HashMap();
    this.yZy = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(74433);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "onReceive %s", new Object[] { paramAnonymousIntent.getAction() });
        SettingsSwitchAccountUI.this.unregisterReceiver(SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this));
        if (bu.nullAsNil(paramAnonymousIntent.getAction()).equals("action_kill_mm_process"))
        {
          com.tencent.mm.kernel.g.ajP();
          com.tencent.mm.kernel.a.hold();
          com.tencent.mm.kernel.g.ajS().xI("switch account ,delay logout");
          Mars.onSingalCrash(0);
          com.tencent.mm.sdk.platformtools.ae.foo();
          SettingsSwitchAccountUI.this.finish();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
          paramAnonymousContext = new wh();
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousContext);
        }
        AppMethodBeat.o(74433);
      }
    };
    AppMethodBeat.o(74445);
  }
  
  private void ayu(String paramString)
  {
    AppMethodBeat.i(74450);
    Object localObject = (SwitchAccountModel)this.yUh.get(paramString);
    if ((localObject != null) && (!this.yZw))
    {
      this.yZw = true;
      localObject = new com.tencent.mm.modelsimple.t(paramString, ((SwitchAccountModel)localObject).username, ((SwitchAccountModel)localObject).yTb, "");
      com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
      this.yUd.setSwitchToWxUsername(paramString);
      this.yUd.dRM();
      dRu();
    }
    AppMethodBeat.o(74450);
  }
  
  private void ayv(String paramString)
  {
    AppMethodBeat.i(74461);
    Object localObject = new IntentFilter("action_kill_mm_process");
    registerReceiver(this.yZy, (IntentFilter)localObject);
    localObject = new Intent(this, FakeSwitchAccountUI.class);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.yUh.values());
    ((Intent)localObject).putParcelableArrayListExtra("key_switch_account_users", localArrayList);
    ((Intent)localObject).putExtra("key_switch_from_wx_username", paramString);
    ak.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("transit_to_switch_account", true).commit();
    paramString = ad.f(getSharedPreferences(ak.fow(), 0));
    float f = com.tencent.mm.cb.a.ef(this);
    ((Intent)localObject).putExtra("key_langauage_code", paramString);
    ((Intent)localObject).putExtra("key_font_scale_size", f);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
    ((Intent)localObject).putExtra("key_mm_process_pid", Process.myPid());
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.km(this);
    AppMethodBeat.o(74461);
  }
  
  private void dRu()
  {
    AppMethodBeat.i(74451);
    if (this.yZw)
    {
      this.yZq.setVisibility(8);
      AppMethodBeat.o(74451);
      return;
    }
    if ((this.yUh.size() <= 1) && (this.scene == 0))
    {
      this.yZq.setVisibility(8);
      this.yXu = false;
      this.yUd.setDeleteState(false);
      AppMethodBeat.o(74451);
      return;
    }
    if (!this.yXu)
    {
      this.titleView.setText(2131763447);
      this.yZt.setVisibility(8);
      this.yZq.setText(getString(2131763445));
      this.yZq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74442);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this))
          {
            SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, true);
            SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this));
            SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dRM();
            SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
            if (cd.hLa.aCQ().size() <= 1) {
              break label156;
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(3), cd.hLa.aCR() });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74442);
            return;
            label156:
            com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(3), cd.hLa.aCR() });
          }
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    this.titleView.setText(2131763445);
    this.yZt.setVisibility(0);
    if (this.yZx)
    {
      this.yZq.setText(getString(2131755779));
      this.yZq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74443);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(false);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dRM();
          SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
          if (SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).getAccountCount() == 0)
          {
            if (cd.hLa.aCQ().size() <= 1) {
              break label270;
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(11), cd.hLa.aCR() });
          }
          for (;;)
          {
            localObject = com.tencent.mm.plugin.account.a.a.iUz.bE(SettingsSwitchAccountUI.this);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousView = SettingsSwitchAccountUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            SettingsSwitchAccountUI.this.finish();
            com.tencent.mm.ui.base.b.kl(SettingsSwitchAccountUI.this);
            SettingsSwitchAccountUI.h(SettingsSwitchAccountUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74443);
            return;
            label270:
            com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(11), cd.hLa.aCR() });
          }
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    this.yZq.setText(getString(2131755691));
    this.yZq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74444);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setDeleteState(false);
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dRM();
        SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74444);
      }
    });
    AppMethodBeat.o(74451);
  }
  
  private void dRv()
  {
    AppMethodBeat.i(74459);
    if (com.tencent.mm.kernel.a.mQ(com.tencent.mm.kernel.g.ajP().gDe))
    {
      localObject = new com.tencent.mm.modelsimple.ae(2);
      com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
    }
    Object localObject = new com.tencent.mm.modelsimple.s();
    com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
    this.yUd.setLogoutState(true);
    this.yUd.dRM();
    if (this.yZv == null)
    {
      this.yZv = new aw(Looper.getMainLooper(), new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(74435);
          SettingsSwitchAccountUI.j(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74435);
          return false;
        }
      }, false);
      this.yZv.ay(8000L, 8000L);
    }
    AppMethodBeat.o(74459);
  }
  
  private void dRw()
  {
    AppMethodBeat.i(74460);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
    com.tencent.mm.plugin.setting.c.iUA.MS();
    this.jcn.setVisibility(8);
    this.yZq.setVisibility(8);
    Object localObject = new lk();
    ((lk)localObject).dzN.status = 0;
    ((lk)localObject).dzN.reason = 0;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new ab();
    ((ab)localObject).dlL.dlM = true;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    ao.aRS("show_whatsnew");
    com.tencent.mm.kernel.l.q(this, true);
    com.tencent.mm.platformtools.t.J(this, null);
    if (com.tencent.mm.kernel.g.ajM())
    {
      localObject = com.tencent.mm.aj.c.Du(v.aAC());
      bb.hIK.BG((String)localObject);
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", new Object[] { bb.hIK.ay("login_user_name", "") });
    localObject = v.aBv();
    if (bu.isNullOrNil((String)((Map)localObject).get("login_user_name"))) {
      ((Map)localObject).put("login_user_name", bb.hIK.ay("login_user_name", ""));
    }
    cd.hLa.h(v.aAC(), (Map)localObject);
    ak.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
    ayv(v.aAC());
    AppMethodBeat.o(74460);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(74455);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "go back");
    if ((this.scene == 2) || (this.scene == 1))
    {
      Object localObject = com.tencent.mm.plugin.account.a.a.iUz.bE(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.kl(this);
      this.yZw = false;
      AppMethodBeat.o(74455);
      return;
    }
    finish();
    AppMethodBeat.o(74455);
  }
  
  private static void logout()
  {
    AppMethodBeat.i(74458);
    if ((com.tencent.mm.kernel.g.ajj() != null) && (com.tencent.mm.kernel.g.ajj().hRo != null)) {
      com.tencent.mm.kernel.g.ajj().hRo.eI(false);
    }
    Object localObject = new gz();
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    com.tencent.mm.kernel.g.ajP();
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()) });
    com.tencent.mm.modelstat.c.aLY().commitNow();
    ((com.tencent.mm.plugin.expt.b.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.e.class)).logout();
    localObject = new u(2);
    ((u)localObject).ioZ = 1;
    com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
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
    this.yZr = findViewById(2131305573);
    this.yZs = findViewById(2131305571);
    this.titleView = ((TextView)findViewById(2131305572));
    this.yZt = ((TextView)findViewById(2131305567));
    this.yZq = ((TextView)findViewById(2131305568));
    this.jcn = ((TextView)findViewById(2131305566));
    this.yUd = ((SwitchAccountGridView)findViewById(2131305570));
    this.yUd.setRowCount(1);
    this.yUd.setOnClickAvatarListener(new SwitchAccountGridView.b()
    {
      public final void ayw(String paramAnonymousString)
      {
        AppMethodBeat.i(74436);
        if (!bu.isNullOrNil(paramAnonymousString))
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
        ak.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", "").commit();
        if (SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this) == 0)
        {
          SettingsSwitchAccountUI.dRx();
          AppMethodBeat.o(74436);
          return;
        }
        Object localObject = new Intent(SettingsSwitchAccountUI.this, MobileInputUI.class);
        ((Intent)localObject).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject).putExtra("from_switch_account", true);
        paramAnonymousString = SettingsSwitchAccountUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousString, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$2", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.kj(SettingsSwitchAccountUI.this);
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
      ak.getContext().sendBroadcast((Intent)localObject1);
      this.jcn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74437);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          SettingsSwitchAccountUI.c(SettingsSwitchAccountUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74437);
        }
      });
      localObject1 = cd.hLa.aCQ();
      com.tencent.mm.kernel.g.ajP();
      if (!com.tencent.mm.kernel.a.aiY()) {
        break label746;
      }
      this.jno = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(2, null));
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", new Object[] { Integer.valueOf(this.scene), this.jno });
      if ((bu.isNullOrNil(this.jno)) || (((Set)localObject1).contains(this.jno))) {
        break label764;
      }
      if ((this.scene != 2) || (cd.hLa.Cd(this.jno)))
      {
        localObject1 = bb.hIK.ay("login_user_name", "");
        str1 = bb.hIK.aBY();
        localObject2 = bb.hIK.ay("last_login_use_voice", "");
        String str2 = cd.hLa.getString(this.jno, "last_logout_no_pwd_ticket");
        localObject1 = new SwitchAccountModel(this.jno, (String)localObject1, str1, str2, bu.aSB((String)localObject2));
        this.yUh.put(this.jno, localObject1);
      }
      label415:
      if (this.yUh.size() == 0)
      {
        localObject1 = new Intent(this, MobileInputUI.class);
        ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject1).putExtra("can_finish", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.ui.base.b.km(this);
      }
      this.yUd.aH(this.yUh);
      if (this.scene != 1) {
        break label988;
      }
      localObject1 = ak.getContext().getSharedPreferences("switch_account_preferences", 0);
      str1 = ((SharedPreferences)localObject1).getString("last_switch_account_to_wx_username", "");
      ((SharedPreferences)localObject1).edit().putBoolean("transit_to_switch_account", false).commit();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s", new Object[] { str1 });
      if (bu.isNullOrNil(str1)) {
        break label874;
      }
      com.tencent.mm.kernel.g.ajP();
      if (!com.tencent.mm.kernel.a.aiY()) {
        break label866;
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
      finish();
    }
    for (;;)
    {
      this.yUd.dRM();
      dRu();
      this.yUd.setOnDeleteAvatarListener(new SwitchAccountGridView.c()
      {
        public final void ayx(final String paramAnonymousString)
        {
          AppMethodBeat.i(74439);
          h.e(SettingsSwitchAccountUI.this, SettingsSwitchAccountUI.this.getString(2131763443, new Object[] { ((SwitchAccountModel)SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).get(paramAnonymousString)).username }), SettingsSwitchAccountUI.this.getString(2131755906), SettingsSwitchAccountUI.this.getString(2131755939), SettingsSwitchAccountUI.this.getString(2131755831), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74438);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", new Object[] { paramAnonymousString });
              SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, true);
              cd.hLa.Cb(paramAnonymousString);
              SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).remove(paramAnonymousString);
              paramAnonymous2DialogInterface = SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
              String str = paramAnonymousString;
              if (paramAnonymous2DialogInterface.zbo.contains(str))
              {
                paramAnonymous2Int = paramAnonymous2DialogInterface.zbo.indexOf(str);
                paramAnonymous2DialogInterface.zbo.remove(str);
                paramAnonymous2DialogInterface.zbp.remove(paramAnonymous2Int);
                paramAnonymous2DialogInterface.zbq.remove(paramAnonymous2Int);
              }
              SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dRM();
              SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this);
              if (SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this) == 0)
              {
                if (cd.hLa.aCQ().size() > 0)
                {
                  com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(4), cd.hLa.aCR() });
                  AppMethodBeat.o(74438);
                  return;
                }
                com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(4), cd.hLa.aCR() });
              }
              AppMethodBeat.o(74438);
            }
          }, null);
          AppMethodBeat.o(74439);
        }
      });
      this.yZu = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.yZu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(74440);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setTranslationY(-f * SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).getHeight());
          AppMethodBeat.o(74440);
        }
      });
      this.yZu.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(74441);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
          Object localObject = com.tencent.mm.plugin.account.a.a.iUz.bE(SettingsSwitchAccountUI.this);
          ((Intent)localObject).addFlags(67108864);
          paramAnonymousAnimator = SettingsSwitchAccountUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAnimator, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAnimator.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAnimator, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$6", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          SettingsSwitchAccountUI.this.finish();
          com.tencent.mm.ui.base.b.kl(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(74441);
        }
      });
      this.yZu.setDuration(500L);
      AppMethodBeat.o(74447);
      return;
      this.jcn.setVisibility(8);
      break;
      label746:
      this.jno = bb.hIK.ay("login_weixin_username", "");
      break label261;
      label764:
      if (((Set)localObject1).isEmpty()) {
        break label415;
      }
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        str1 = (String)((Iterator)localObject1).next();
        localObject2 = new SwitchAccountModel(str1, cd.hLa.getString(str1, "login_user_name"), cd.hLa.getString(str1, "last_avatar_path"), cd.hLa.getString(str1, "last_logout_no_pwd_ticket"), bu.aSB(cd.hLa.getString(str1, "last_login_use_voice")));
        this.yUh.put(str1, localObject2);
      }
      break label415;
      label866:
      ayu(str1);
      continue;
      label874:
      this.yZw = false;
      localObject1 = new Intent(this, MobileInputUI.class);
      ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
      ((Intent)localObject1).putExtra("from_switch_account", true);
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.km(this);
      continue;
      label988:
      if (this.scene == 0) {
        this.yUd.setLastLoginWxUsername(this.jno);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74457);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 701) && (paramInt2 == -1)) {
      dRv();
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
      unregisterReceiver(this.yZy);
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "onResume");
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    if ((this.scene == 1) || (this.scene == 2))
    {
      com.tencent.mm.kernel.g.ajj().a(701, this);
      com.tencent.mm.kernel.g.ajj().a(252, this);
    }
    if (this.scene == 0)
    {
      com.tencent.mm.kernel.g.ajj().a(281, this);
      com.tencent.mm.kernel.g.ajj().a(282, this);
      com.tencent.mm.kernel.g.ajj().a(255, this);
    }
    this.yUd.dRM();
    dRu();
    if (((this.scene == 1) || (this.scene == 2)) && (com.tencent.mm.kernel.g.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "account initialized");
      this.yZw = true;
      Object localObject = com.tencent.mm.plugin.account.a.a.iUz.bE(this);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.kl(this);
    }
    AppMethodBeat.o(74452);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(74454);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "errCode %d, errMsg %s, scene %s, type  %d, this %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramn, Integer.valueOf(paramn.getType()), this });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramn.getType() == 252) || (paramn.getType() == 701))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label456;
      }
      this.yZr.setVisibility(4);
      this.yZs.setVisibility(4);
      localObject1 = this.yUd;
      if (!((SwitchAccountGridView)localObject1).iXG)
      {
        if ((((SwitchAccountGridView)localObject1).zbn == null) && (!bu.isNullOrNil(((SwitchAccountGridView)localObject1).zbm)))
        {
          int i = Math.min(2, ((SwitchAccountGridView)localObject1).zbo.size());
          localObject2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.4((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject2).setDuration(200L);
          localObject3 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.5((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject3).setDuration(300L);
          ((SwitchAccountGridView)localObject1).zbn = new AnimatorSet();
          ((SwitchAccountGridView)localObject1).zbn.addListener(new SwitchAccountGridView.6((SwitchAccountGridView)localObject1));
          ((SwitchAccountGridView)localObject1).zbn.playSequentially(new Animator[] { localObject2, localObject3 });
        }
        if (((SwitchAccountGridView)localObject1).zbn != null)
        {
          ((SwitchAccountGridView)localObject1).iXG = true;
          ((SwitchAccountGridView)localObject1).zbn.start();
        }
      }
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.plugin.account.friend.a.l.aTs();
      com.tencent.mm.platformtools.t.cW(this);
      if (cd.hLa.aCQ().size() <= 1) {
        break label417;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(0), cd.hLa.aCR() });
      this.yUd.setOnAnimatorEndListener(new SwitchAccountGridView.a()
      {
        public final void dRy()
        {
          AppMethodBeat.i(74434);
          String str = v.aAC();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setLastLoginWxUsername(str);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setSwitchToWxUsername("");
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).dRM();
          SettingsSwitchAccountUI.i(SettingsSwitchAccountUI.this).start();
          AppMethodBeat.o(74434);
        }
      });
    }
    for (;;)
    {
      if (paramn.getType() == 255)
      {
        if (((u)paramn).ipa != 2) {
          break label1100;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          dRv();
          AppMethodBeat.o(74454);
          return;
          label417:
          com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(0), cd.hLa.aCR() });
          break;
          label456:
          this.yUd.setSwitchToWxUsername("");
          this.yZw = false;
          h.cm(this, getString(2131763446));
          localObject1 = ((com.tencent.mm.modelsimple.t)paramn).ioS;
          if ((!bu.isNullOrNil((String)localObject1)) && (this.yUh.containsKey(localObject1)))
          {
            localObject2 = new Intent();
            localObject3 = (SwitchAccountModel)this.yUh.get(localObject1);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", new Object[] { localObject1, Integer.valueOf(((SwitchAccountModel)localObject3).yTc) });
            if ((((SwitchAccountModel)localObject3).yTc & 0x20000) == 0) {
              break label734;
            }
            ((Intent)localObject2).setClass(this, LoginVoiceUI.class);
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("switch_login_wx_id", (String)localObject1);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.km(this);
            if (cd.hLa.aCQ().size() <= 1) {
              break label747;
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(1), cd.hLa.aCR() });
            break;
            label734:
            ((Intent)localObject2).setClass(this, LoginPasswordUI.class);
          }
          label747:
          com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(1), cd.hLa.aCR() });
          continue;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          if (cd.hLa.aCQ().size() > 1) {
            com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(7), cd.hLa.aCR() });
          }
          for (;;)
          {
            paramString = new Intent(getContext(), RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(2131762360));
            startActivityForResult(paramString, 701);
            AppMethodBeat.o(74454);
            return;
            com.tencent.mm.plugin.report.service.g.yxI.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(7), cd.hLa.aCR() });
          }
        }
        if (!com.tencent.mm.plugin.setting.c.iUA.a(this, paramInt1, paramInt2, paramString)) {
          break label1100;
        }
        AppMethodBeat.o(74454);
        return;
      }
    }
    if (paramn.getType() == 282)
    {
      com.tencent.mm.kernel.g.ajP();
      if (com.tencent.mm.kernel.a.aiY())
      {
        paramString = ((bwo)((com.tencent.mm.modelsimple.s)paramn).rr.hQE.hQJ).Hjy;
        if (paramString != null) {
          break label1107;
        }
      }
    }
    label1100:
    label1107:
    for (paramInt1 = -1;; paramInt1 = paramString.length())
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SettingsSwitchAccountUI", "logout return noPwdTicket[%s]", new Object[] { Integer.valueOf(paramInt1) });
      if (bu.isNullOrNil(paramString)) {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "no pwd ticket is null!");
      }
      paramn = v.aAC();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "logout return username[%s]", new Object[] { paramn });
      cd.hLa.l(paramn, "last_logout_no_pwd_ticket", paramString);
      if ((this.yZv != null) && (!this.yZv.foU()))
      {
        this.yZv.stopTimer();
        dRw();
      }
      AppMethodBeat.o(74454);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(74453);
    super.onStop();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SettingsSwitchAccountUI", "onStop");
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    if (this.scene == 1)
    {
      SwitchAccountGridView localSwitchAccountGridView = this.yUd;
      if (localSwitchAccountGridView.iXG)
      {
        localSwitchAccountGridView.iXG = false;
        if (localSwitchAccountGridView.zbn != null) {
          localSwitchAccountGridView.zbn.end();
        }
      }
    }
    com.tencent.mm.kernel.g.ajj().b(701, this);
    com.tencent.mm.kernel.g.ajj().b(252, this);
    com.tencent.mm.kernel.g.ajj().b(281, this);
    com.tencent.mm.kernel.g.ajj().b(282, this);
    com.tencent.mm.kernel.g.ajj().b(255, this);
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