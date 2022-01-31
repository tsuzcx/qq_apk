package com.tencent.mm.plugin.setting.ui.setting;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mars.BaseEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.td;
import com.tencent.mm.g.a.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bx;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.platformtools.w;
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
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.protobuf.bat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class SettingsSwitchAccountUI
  extends MMActivity
  implements f
{
  private String gEZ;
  private TextView gta;
  private SwitchAccountGridView qFN;
  private Map<String, SwitchAccountModel> qFR;
  private boolean qIE;
  private TextView qKk;
  private View qKl;
  private View qKm;
  private TextView qKn;
  private ValueAnimator qKo;
  private ap qKp;
  private boolean qKq;
  private boolean qKr;
  private BroadcastReceiver qKs;
  private int scene;
  private TextView titleView;
  
  public SettingsSwitchAccountUI()
  {
    AppMethodBeat.i(127509);
    this.qFR = new HashMap();
    this.qKs = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(127497);
        ab.i("MicroMsg.SettingsSwitchAccountUI", "onReceive %s", new Object[] { paramAnonymousIntent.getAction() });
        SettingsSwitchAccountUI.this.unregisterReceiver(SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this));
        if (bo.nullAsNil(paramAnonymousIntent.getAction()).equals("action_kill_mm_process"))
        {
          g.RJ();
          com.tencent.mm.kernel.a.hold();
          g.RM().mD("switch account ,delay logout");
          com.tencent.mrs.a.onDestroy();
          BaseEvent.onSingalCrash(0);
          ab.dsI();
          SettingsSwitchAccountUI.this.finish();
          ab.i("MicroMsg.SettingsSwitchAccountUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
          paramAnonymousContext = new td();
          com.tencent.mm.sdk.b.a.ymk.l(paramAnonymousContext);
        }
        AppMethodBeat.o(127497);
      }
    };
    AppMethodBeat.o(127509);
  }
  
  private void YU(String paramString)
  {
    AppMethodBeat.i(127514);
    Object localObject = (SwitchAccountModel)this.qFR.get(paramString);
    if ((localObject != null) && (!this.qKq))
    {
      this.qKq = true;
      localObject = new s(paramString, ((SwitchAccountModel)localObject).username, ((SwitchAccountModel)localObject).qEK, "");
      g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      this.qFN.setSwitchToWxUsername(paramString);
      this.qFN.ckO();
      ckx();
    }
    AppMethodBeat.o(127514);
  }
  
  private void YV(String paramString)
  {
    AppMethodBeat.i(154189);
    Object localObject = new IntentFilter("action_kill_mm_process");
    registerReceiver(this.qKs, (IntentFilter)localObject);
    localObject = new Intent(this, FakeSwitchAccountUI.class);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.qFR.values());
    ((Intent)localObject).putParcelableArrayListExtra("key_switch_account_users", localArrayList);
    ((Intent)localObject).putExtra("key_switch_from_wx_username", paramString);
    ah.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("transit_to_switch_account", true).commit();
    paramString = aa.f(getSharedPreferences(ah.dsP(), 0));
    float f = com.tencent.mm.cb.a.dr(this);
    ((Intent)localObject).putExtra("key_langauage_code", paramString);
    ((Intent)localObject).putExtra("key_font_scale_size", f);
    ab.i("MicroMsg.SettingsSwitchAccountUI", "mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
    ((Intent)localObject).putExtra("key_mm_process_pid", Process.myPid());
    startActivity((Intent)localObject);
    com.tencent.mm.ui.base.b.ih(this);
    AppMethodBeat.o(154189);
  }
  
  private static void aa(Map<String, SwitchAccountModel> paramMap)
  {
    AppMethodBeat.i(127512);
    if (paramMap.size() == 2)
    {
      String[] arrayOfString = new String[2];
      Object localObject = paramMap.values().iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        arrayOfString[i] = ((SwitchAccountModel)((Iterator)localObject).next()).username;
        i += 1;
      }
      if ((!bo.Q(new String[] { arrayOfString[0], arrayOfString[1] })) && (arrayOfString[0].equals(arrayOfString[1])))
      {
        paramMap = paramMap.keySet().iterator();
        while (paramMap.hasNext())
        {
          localObject = (String)paramMap.next();
          bx.fnO.pG((String)localObject);
        }
        paramMap = new NullPointerException(String.format("tow accounts have the same username!!! , %s, %s", new Object[] { arrayOfString[0], arrayOfString[1] }));
        AppMethodBeat.o(127512);
        throw paramMap;
      }
    }
    AppMethodBeat.o(127512);
  }
  
  private void ckx()
  {
    AppMethodBeat.i(127515);
    if (this.qKq)
    {
      this.qKk.setVisibility(8);
      AppMethodBeat.o(127515);
      return;
    }
    if ((this.qFR.size() <= 1) && (this.scene == 0))
    {
      this.qKk.setVisibility(8);
      this.qIE = false;
      this.qFN.setDeleteState(false);
      AppMethodBeat.o(127515);
      return;
    }
    if (!this.qIE)
    {
      this.titleView.setText(2131303465);
      this.qKn.setVisibility(8);
      this.qKk.setText(getString(2131303463));
      this.qKk.setOnClickListener(new SettingsSwitchAccountUI.9(this));
      AppMethodBeat.o(127515);
      return;
    }
    this.titleView.setText(2131303463);
    this.qKn.setVisibility(0);
    if (this.qKr)
    {
      this.qKk.setText(getString(2131296964));
      this.qKk.setOnClickListener(new SettingsSwitchAccountUI.10(this));
      AppMethodBeat.o(127515);
      return;
    }
    this.qKk.setText(getString(2131296888));
    this.qKk.setOnClickListener(new SettingsSwitchAccountUI.11(this));
    AppMethodBeat.o(127515);
  }
  
  private void cky()
  {
    AppMethodBeat.i(127523);
    if (com.tencent.mm.kernel.a.jM(g.RJ().eHa))
    {
      localObject = new ad(2);
      g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
    }
    Object localObject = new com.tencent.mm.modelsimple.r();
    g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
    this.qFN.setLogoutState(true);
    this.qFN.ckO();
    if (this.qKp == null)
    {
      this.qKp = new ap(Looper.getMainLooper(), new SettingsSwitchAccountUI.3(this), false);
      this.qKp.ag(8000L, 8000L);
    }
    AppMethodBeat.o(127523);
  }
  
  private void ckz()
  {
    AppMethodBeat.i(127524);
    ab.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
    com.tencent.mm.plugin.setting.b.gmP.BU();
    this.gta.setVisibility(8);
    this.qKk.setVisibility(8);
    Object localObject = new jo();
    ((jo)localObject).cze.status = 0;
    ((jo)localObject).cze.aXG = 0;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new y();
    ((y)localObject).cne.cnf = true;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    aj.apl("show_whatsnew");
    com.tencent.mm.kernel.l.n(this, true);
    w.I(this, null);
    if (g.RG())
    {
      localObject = com.tencent.mm.ah.b.qS(com.tencent.mm.model.r.Zn());
      av.flM.po((String)localObject);
    }
    ab.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", new Object[] { av.flM.Y("login_user_name", "") });
    localObject = com.tencent.mm.model.r.ZV();
    if (bo.isNullOrNil((String)((Map)localObject).get("login_user_name"))) {
      ((Map)localObject).put("login_user_name", av.flM.Y("login_user_name", ""));
    }
    bx.fnO.g(com.tencent.mm.model.r.Zn(), (Map)localObject);
    ah.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
    YV(com.tencent.mm.model.r.Zn());
    AppMethodBeat.o(127524);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(127519);
    ab.i("MicroMsg.SettingsSwitchAccountUI", "go back");
    if ((this.scene == 2) || (this.scene == 1))
    {
      Intent localIntent = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
      localIntent.addFlags(67108864);
      localIntent.putExtra("can_finish", true);
      startActivity(localIntent);
      finish();
      com.tencent.mm.ui.base.b.ig(this);
      this.qKq = false;
      AppMethodBeat.o(127519);
      return;
    }
    finish();
    AppMethodBeat.o(127519);
  }
  
  private static void logout()
  {
    AppMethodBeat.i(127522);
    if ((g.Rc() != null) && (g.Rc().ftA != null)) {
      g.Rc().ftA.cR(false);
    }
    Object localObject = new gk();
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    g.RJ();
    ab.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.getUin()) });
    com.tencent.mm.modelstat.c.akw().commitNow();
    ((com.tencent.mm.plugin.expt.a.c)g.E(com.tencent.mm.plugin.expt.a.c.class)).logout();
    localObject = new t(2);
    ((t)localObject).fPH = 1;
    g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
    AppMethodBeat.o(127522);
  }
  
  public int getLayoutId()
  {
    return 2130970703;
  }
  
  public void initView()
  {
    AppMethodBeat.i(138712);
    setMMTitle("");
    showMMLogo();
    getSupportActionBar().hide();
    getController().n(this, -1);
    this.scene = getIntent().getIntExtra("key_scene", 0);
    this.qKl = findViewById(2131827653);
    this.qKm = findViewById(2131827652);
    this.titleView = ((TextView)findViewById(2131827656));
    this.qKn = ((TextView)findViewById(2131827655));
    this.qKk = ((TextView)findViewById(2131827658));
    this.gta = ((TextView)findViewById(2131827651));
    this.qFN = ((SwitchAccountGridView)findViewById(2131827657));
    this.qFN.setRowCount(1);
    this.qFN.setOnClickAvatarListener(new SettingsSwitchAccountUI.4(this));
    Object localObject1;
    label249:
    String str;
    Object localObject2;
    if (this.scene == 0)
    {
      localObject1 = new Intent(this, SwitchAccountReceiver.class);
      ((Intent)localObject1).putExtra("switch_process_action_code_key", "action_switch_account");
      ah.getContext().sendBroadcast((Intent)localObject1);
      this.gta.setOnClickListener(new SettingsSwitchAccountUI.5(this));
      localObject1 = bx.fnO.abf();
      g.RJ();
      if (!com.tencent.mm.kernel.a.QT()) {
        break label660;
      }
      this.gEZ = ((String)g.RL().Ru().get(2, null));
      ab.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", new Object[] { Integer.valueOf(this.scene), this.gEZ });
      if ((bo.isNullOrNil(this.gEZ)) || (((Set)localObject1).contains(this.gEZ))) {
        break label678;
      }
      if ((this.scene != 2) || (bx.fnO.pI(this.gEZ)))
      {
        localObject1 = av.flM.Y("login_user_name", "");
        str = av.flM.aar();
        localObject2 = av.flM.Y("last_login_use_voice", "");
        localObject1 = new SwitchAccountModel(this.gEZ, (String)localObject1, str, "", bo.apV((String)localObject2));
        this.qFR.put(this.gEZ, localObject1);
      }
      label388:
      if (this.qFR.size() == 0)
      {
        localObject1 = new Intent(this, MobileInputUI.class);
        ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject1).putExtra("can_finish", true);
        startActivity((Intent)localObject1);
        finish();
        com.tencent.mm.ui.base.b.ih(this);
      }
      aa(this.qFR);
      this.qFN.ab(this.qFR);
      if (this.scene != 1) {
        break label835;
      }
      localObject1 = ah.getContext().getSharedPreferences("switch_account_preferences", 0);
      str = ((SharedPreferences)localObject1).getString("last_switch_account_to_wx_username", "");
      ((SharedPreferences)localObject1).edit().putBoolean("transit_to_switch_account", false).commit();
      ab.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s", new Object[] { str });
      if (bo.isNullOrNil(str)) {
        break label788;
      }
      g.RJ();
      if (!com.tencent.mm.kernel.a.QT()) {
        break label780;
      }
      ab.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
      finish();
    }
    for (;;)
    {
      this.qFN.ckO();
      ckx();
      this.qFN.setOnDeleteAvatarListener(new SettingsSwitchAccountUI.6(this));
      this.qKo = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.qKo.addUpdateListener(new SettingsSwitchAccountUI.7(this));
      this.qKo.addListener(new SettingsSwitchAccountUI.8(this));
      this.qKo.setDuration(500L);
      AppMethodBeat.o(138712);
      return;
      this.gta.setVisibility(8);
      break;
      label660:
      this.gEZ = av.flM.Y("login_weixin_username", "");
      break label249;
      label678:
      if (((Set)localObject1).isEmpty()) {
        break label388;
      }
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        str = (String)((Iterator)localObject1).next();
        localObject2 = new SwitchAccountModel(str, bx.fnO.getString(str, "login_user_name"), bx.fnO.getString(str, "last_avatar_path"), bx.fnO.getString(str, "last_logout_no_pwd_ticket"), bo.apV(bx.fnO.getString(str, "last_login_use_voice")));
        this.qFR.put(str, localObject2);
      }
      break label388;
      label780:
      YU(str);
      continue;
      label788:
      this.qKq = false;
      localObject1 = new Intent(this, MobileInputUI.class);
      ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
      ((Intent)localObject1).putExtra("from_switch_account", true);
      startActivity((Intent)localObject1);
      com.tencent.mm.ui.base.b.ie(this);
      continue;
      label835:
      if (this.scene == 0) {
        this.qFN.setLastLoginWxUsername(this.gEZ);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(127521);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 701) && (paramInt2 == -1)) {
      cky();
    }
    AppMethodBeat.o(127521);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127510);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(127510);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127520);
    super.onDestroy();
    try
    {
      unregisterReceiver(this.qKs);
      AppMethodBeat.o(127520);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(127520);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(127513);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(127513);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(127513);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127516);
    super.onResume();
    ab.i("MicroMsg.SettingsSwitchAccountUI", "onResume");
    if ((this.scene == 1) || (this.scene == 2))
    {
      g.Rc().a(701, this);
      g.Rc().a(252, this);
    }
    if (this.scene == 0)
    {
      g.Rc().a(281, this);
      g.Rc().a(282, this);
      g.Rc().a(255, this);
    }
    this.qFN.ckO();
    ckx();
    if (((this.scene == 1) || (this.scene == 2)) && (g.RG()) && (g.RJ().eHg))
    {
      ab.i("MicroMsg.SettingsSwitchAccountUI", "account initialized");
      this.qKq = true;
      Intent localIntent = com.tencent.mm.plugin.account.a.a.gmO.bm(this);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      finish();
      com.tencent.mm.ui.base.b.ig(this);
    }
    AppMethodBeat.o(127516);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(127518);
    ab.i("MicroMsg.SettingsSwitchAccountUI", "errCode %d, errMsg %s, scene %s, type  %d, this %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramm, Integer.valueOf(paramm.getType()), this });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramm.getType() == 252) || (paramm.getType() == 701))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label456;
      }
      this.qKl.setVisibility(4);
      this.qKm.setVisibility(4);
      localObject1 = this.qFN;
      if (!((SwitchAccountGridView)localObject1).qMo)
      {
        if ((((SwitchAccountGridView)localObject1).qMp == null) && (!bo.isNullOrNil(((SwitchAccountGridView)localObject1).qMn)))
        {
          int i = Math.min(2, ((SwitchAccountGridView)localObject1).qMq.size());
          localObject2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.4((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject2).setDuration(200L);
          localObject3 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.5((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject3).setDuration(300L);
          ((SwitchAccountGridView)localObject1).qMp = new AnimatorSet();
          ((SwitchAccountGridView)localObject1).qMp.addListener(new SwitchAccountGridView.6((SwitchAccountGridView)localObject1));
          ((SwitchAccountGridView)localObject1).qMp.playSequentially(new Animator[] { localObject2, localObject3 });
        }
        if (((SwitchAccountGridView)localObject1).qMp != null)
        {
          ((SwitchAccountGridView)localObject1).qMo = true;
          ((SwitchAccountGridView)localObject1).qMp.start();
        }
      }
      com.tencent.mm.kernel.a.unhold();
      com.tencent.mm.plugin.account.friend.a.l.aqv();
      w.cs(this);
      if (bx.fnO.abf().size() <= 1) {
        break label417;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(0), bx.fnO.abg() });
      this.qFN.setOnAnimatorEndListener(new SwitchAccountGridView.a()
      {
        public final void ckB()
        {
          AppMethodBeat.i(127498);
          String str = com.tencent.mm.model.r.Zn();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setLastLoginWxUsername(str);
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).setSwitchToWxUsername("");
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this).ckO();
          SettingsSwitchAccountUI.i(SettingsSwitchAccountUI.this).start();
          AppMethodBeat.o(127498);
        }
      });
    }
    for (;;)
    {
      if (paramm.getType() == 255)
      {
        if (((t)paramm).fPI != 2) {
          break label1030;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          cky();
          AppMethodBeat.o(127518);
          return;
          label417:
          com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(0), bx.fnO.abg() });
          break;
          label456:
          this.qFN.setSwitchToWxUsername("");
          this.qKq = false;
          com.tencent.mm.ui.base.h.bO(this, getString(2131303464));
          localObject1 = ((s)paramm).fPA;
          if ((!bo.isNullOrNil((String)localObject1)) && (this.qFR.containsKey(localObject1)))
          {
            localObject2 = new Intent();
            localObject3 = (SwitchAccountModel)this.qFR.get(localObject1);
            ab.i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", new Object[] { localObject1, Integer.valueOf(((SwitchAccountModel)localObject3).qEL) });
            if ((((SwitchAccountModel)localObject3).qEL & 0x20000) == 0) {
              break label664;
            }
            ((Intent)localObject2).setClass(this, LoginVoiceUI.class);
          }
          for (;;)
          {
            ((Intent)localObject2).putExtra("switch_login_wx_id", (String)localObject1);
            startActivity((Intent)localObject2);
            com.tencent.mm.ui.base.b.ih(this);
            if (bx.fnO.abf().size() <= 1) {
              break label677;
            }
            com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(1), bx.fnO.abg() });
            break;
            label664:
            ((Intent)localObject2).setClass(this, LoginPasswordUI.class);
          }
          label677:
          com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(1), bx.fnO.abg() });
          continue;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          if (bx.fnO.abf().size() > 1) {
            com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(7), bx.fnO.abg() });
          }
          for (;;)
          {
            paramString = new Intent(getContext(), RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(2131302457));
            startActivityForResult(paramString, 701);
            AppMethodBeat.o(127518);
            return;
            com.tencent.mm.plugin.report.service.h.qsU.e(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(7), bx.fnO.abg() });
          }
        }
        if (!com.tencent.mm.plugin.setting.b.gmP.a(this, paramInt1, paramInt2, paramString)) {
          break label1030;
        }
        AppMethodBeat.o(127518);
        return;
      }
    }
    if (paramm.getType() == 282)
    {
      g.RJ();
      if (com.tencent.mm.kernel.a.QT())
      {
        paramString = ((bat)((com.tencent.mm.modelsimple.r)paramm).rr.fsW.fta).xpX;
        if (paramString != null) {
          break label1037;
        }
      }
    }
    label1030:
    label1037:
    for (paramInt1 = -1;; paramInt1 = paramString.length())
    {
      ab.d("MicroMsg.SettingsSwitchAccountUI", "logout return noPwdTicket[%s]", new Object[] { Integer.valueOf(paramInt1) });
      if (bo.isNullOrNil(paramString)) {
        ab.i("MicroMsg.SettingsSwitchAccountUI", "no pwd ticket is null!");
      }
      paramm = com.tencent.mm.model.r.Zn();
      ab.i("MicroMsg.SettingsSwitchAccountUI", "logout return username[%s]", new Object[] { paramm });
      bx.fnO.n(paramm, "last_logout_no_pwd_ticket", paramString);
      if ((this.qKp != null) && (!this.qKp.dtj()))
      {
        this.qKp.stopTimer();
        ckz();
      }
      AppMethodBeat.o(127518);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(127517);
    super.onStop();
    ab.i("MicroMsg.SettingsSwitchAccountUI", "onStop");
    if (this.scene == 1)
    {
      SwitchAccountGridView localSwitchAccountGridView = this.qFN;
      if (localSwitchAccountGridView.qMo)
      {
        localSwitchAccountGridView.qMo = false;
        if (localSwitchAccountGridView.qMp != null) {
          localSwitchAccountGridView.qMp.end();
        }
      }
    }
    g.Rc().b(701, this);
    g.Rc().b(252, this);
    g.Rc().b(281, this);
    g.Rc().b(282, this);
    g.Rc().b(255, this);
    AppMethodBeat.o(127517);
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