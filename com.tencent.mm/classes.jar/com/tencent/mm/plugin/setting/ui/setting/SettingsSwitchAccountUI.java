package com.tencent.mm.plugin.setting.ui.setting;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.h.a.jf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bv;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.modelstat.c;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.ui.LoginPasswordUI;
import com.tencent.mm.plugin.account.ui.LoginVoiceUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.4;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.5;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.6;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.a;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.b;
import com.tencent.mm.protocal.c.aul;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
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
  private TextView fbi;
  private String fnG;
  private SwitchAccountGridView nRP;
  private Map<String, com.tencent.mm.plugin.setting.model.SwitchAccountModel> nRT = new HashMap();
  private boolean nUz;
  private TextView nWa;
  private View nWb;
  private View nWc;
  private TextView nWd;
  private ValueAnimator nWe;
  private am nWf;
  private boolean nWg;
  private boolean nWh;
  private int scene;
  private TextView titleView;
  
  private static void I(Map<String, com.tencent.mm.plugin.setting.model.SwitchAccountModel> paramMap)
  {
    if (paramMap.size() == 2)
    {
      String[] arrayOfString = new String[2];
      Object localObject = paramMap.values().iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        arrayOfString[i] = ((com.tencent.mm.plugin.setting.model.SwitchAccountModel)((Iterator)localObject).next()).username;
        i += 1;
      }
      if ((!bk.H(new String[] { arrayOfString[0], arrayOfString[1] })) && (arrayOfString[0].equals(arrayOfString[1])))
      {
        paramMap = paramMap.keySet().iterator();
        while (paramMap.hasNext())
        {
          localObject = (String)paramMap.next();
          bv.dXJ.iS((String)localObject);
        }
        throw new NullPointerException(String.format("tow accounts have the same username!!! , %s, %s", new Object[] { arrayOfString[0], arrayOfString[1] }));
      }
    }
  }
  
  private void Mq(String paramString)
  {
    Object localObject = (com.tencent.mm.plugin.setting.model.SwitchAccountModel)this.nRT.get(paramString);
    if ((localObject != null) && (!this.nWg))
    {
      this.nWg = true;
      localObject = new com.tencent.mm.modelsimple.q(paramString, ((com.tencent.mm.plugin.setting.model.SwitchAccountModel)localObject).username, ((com.tencent.mm.plugin.setting.model.SwitchAccountModel)localObject).nQN, "");
      g.Dk().a((com.tencent.mm.ah.m)localObject, 0);
      this.nRP.setSwitchToWxUsername(paramString);
      this.nRP.bzE();
      bzn();
    }
  }
  
  private void bzn()
  {
    if (this.nWg)
    {
      this.nWa.setVisibility(8);
      return;
    }
    if ((this.nRT.size() <= 1) && (this.scene == 0))
    {
      this.nWa.setVisibility(8);
      this.nUz = false;
      this.nRP.setDeleteState(false);
      return;
    }
    if (!this.nUz)
    {
      this.titleView.setText(a.i.settings_switch_account_login_title);
      this.nWd.setVisibility(8);
      this.nWa.setText(getString(a.i.settings_switch_account_delete_title));
      this.nWa.setOnClickListener(new SettingsSwitchAccountUI.7(this));
      return;
    }
    this.titleView.setText(a.i.settings_switch_account_delete_title);
    this.nWd.setVisibility(0);
    if (this.nWh)
    {
      this.nWa.setText(getString(a.i.app_finish));
      this.nWa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).setDeleteState(false);
          SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).bzE();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
          if (SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).getAccountCount() == 0)
          {
            if (bv.dXJ.Ii().size() <= 1) {
              break label162;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(11), bv.dXJ.Ij() });
          }
          for (;;)
          {
            paramAnonymousView = com.tencent.mm.plugin.account.a.a.eUR.aN(SettingsSwitchAccountUI.this);
            paramAnonymousView.addFlags(67108864);
            SettingsSwitchAccountUI.this.startActivity(paramAnonymousView);
            SettingsSwitchAccountUI.this.finish();
            com.tencent.mm.ui.base.b.gK(SettingsSwitchAccountUI.this);
            SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this);
            return;
            label162:
            com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(11), bv.dXJ.Ij() });
          }
        }
      });
      return;
    }
    this.nWa.setText(getString(a.i.app_cancel));
    this.nWa.setOnClickListener(new SettingsSwitchAccountUI.9(this));
  }
  
  private void bzo()
  {
    if (com.tencent.mm.kernel.a.hw(g.DN().dJB))
    {
      localObject = new ac(2);
      g.Dk().a((com.tencent.mm.ah.m)localObject, 0);
    }
    Object localObject = new com.tencent.mm.modelsimple.p();
    g.Dk().a((com.tencent.mm.ah.m)localObject, 0);
    this.nRP.setLogoutState(true);
    this.nRP.bzE();
    if (this.nWf == null)
    {
      this.nWf = new am(Looper.getMainLooper(), new am.a()
      {
        public final boolean tC()
        {
          SettingsSwitchAccountUI.i(SettingsSwitchAccountUI.this);
          return false;
        }
      }, false);
      this.nWf.S(8000L, 8000L);
    }
  }
  
  private void bzp()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsSwitchAccountUI", "just keep class %s", new Object[] { com.tencent.mm.plugin.setting.modelsimple.SwitchAccountModel.class.toString() });
    com.tencent.mm.plugin.setting.b.eUS.tq();
    Object localObject = new jf();
    ((jf)localObject).bRC.status = 0;
    ((jf)localObject).bRC.aQw = 0;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    localObject = new com.tencent.mm.h.a.y();
    ((com.tencent.mm.h.a.y)localObject).bFX.bFY = true;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    ag.Zn("show_whatsnew");
    com.tencent.mm.kernel.l.k(this, true);
    w.E(this, null);
    if (g.DK())
    {
      localObject = com.tencent.mm.ag.b.jZ(com.tencent.mm.model.q.Gj());
      at.dVC.iF((String)localObject);
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", new Object[] { at.dVC.L("login_user_name", "") });
    localObject = com.tencent.mm.model.q.GT();
    if (bk.bl((String)((Map)localObject).get("login_user_name"))) {
      ((Map)localObject).put("login_user_name", at.dVC.L("login_user_name", ""));
    }
    bv.dXJ.f(com.tencent.mm.model.q.Gj(), (Map)localObject);
    ae.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
    localObject = new Intent();
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("Intro_Switch", true);
    ((Intent)localObject).putExtra("key_transit_to_switch_account", true);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.nRT.values());
    ((Intent)localObject).putParcelableArrayListExtra("key_switch_account_users", localArrayList);
    com.tencent.mm.plugin.setting.b.eUR.q((Intent)localObject, this);
    finish();
    com.tencent.mm.ui.base.b.gL(this);
  }
  
  private void goBack()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsSwitchAccountUI", "go back");
    if ((this.scene == 2) || (this.scene == 1))
    {
      Intent localIntent = com.tencent.mm.plugin.account.a.a.eUR.aN(this);
      localIntent.addFlags(67108864);
      localIntent.putExtra("can_finish", true);
      startActivity(localIntent);
      finish();
      com.tencent.mm.ui.base.b.gK(this);
      this.nWg = false;
      return;
    }
    finish();
  }
  
  private static void logout()
  {
    if ((g.Dk() != null) && (g.Dk().edx != null)) {
      g.Dk().edx.bP(false);
    }
    g.DN();
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", new Object[] { Integer.valueOf(com.tencent.mm.kernel.a.CK()) });
    c.Rn().commitNow();
    r localr = new r(2);
    localr.ezR = 1;
    g.Dk().a(localr, 0);
  }
  
  protected final int getLayoutId()
  {
    return a.g.settings_switch_account;
  }
  
  protected final void initView()
  {
    setMMTitle("");
    czr();
    getSupportActionBar().hide();
    if (d.gF(23))
    {
      getWindow().setStatusBarColor(getResources().getColor(a.c.navpage));
      czk();
    }
    this.scene = getIntent().getIntExtra("key_scene", 0);
    this.nWb = findViewById(a.f.switch_account_title_container);
    this.nWc = findViewById(a.f.switch_account_icon);
    this.titleView = ((TextView)findViewById(a.f.switch_account_title));
    this.nWd = ((TextView)findViewById(a.f.switch_account_del_tip));
    this.nWa = ((TextView)findViewById(a.f.switch_account_delete_btn));
    this.fbi = ((TextView)findViewById(a.f.switch_account_cancel_btn));
    this.nRP = ((SwitchAccountGridView)findViewById(a.f.switch_account_grid));
    this.nRP.setRowCount(1);
    this.nRP.setOnClickAvatarListener(new SwitchAccountGridView.b()
    {
      public final void Mr(String paramAnonymousString)
      {
        if (!bk.bl(paramAnonymousString))
        {
          if (SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this) == 0)
          {
            SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, paramAnonymousString);
            return;
          }
          SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, paramAnonymousString);
          return;
        }
        ae.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putString("last_switch_account_to_wx_username", "").commit();
        if (SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this) == 0)
        {
          SettingsSwitchAccountUI.bzq();
          return;
        }
        paramAnonymousString = new Intent(SettingsSwitchAccountUI.this, MobileInputUI.class);
        paramAnonymousString.putExtra("mobile_input_purpose", 1);
        paramAnonymousString.putExtra("from_switch_account", true);
        SettingsSwitchAccountUI.this.startActivity(paramAnonymousString);
        com.tencent.mm.ui.base.b.gI(SettingsSwitchAccountUI.this);
      }
    });
    Object localObject1;
    label233:
    String str;
    Object localObject2;
    if (this.scene == 0)
    {
      this.fbi.setOnClickListener(new SettingsSwitchAccountUI.3(this));
      localObject1 = bv.dXJ.Ii();
      g.DN();
      if (!com.tencent.mm.kernel.a.Db()) {
        break label615;
      }
      this.fnG = ((String)g.DP().Dz().get(2, null));
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", new Object[] { Integer.valueOf(this.scene), this.fnG });
      if ((bk.bl(this.fnG)) || (((Set)localObject1).contains(this.fnG))) {
        break label633;
      }
      if ((this.scene != 2) || (bv.dXJ.iU(this.fnG)))
      {
        localObject1 = at.dVC.L("login_user_name", "");
        str = at.dVC.Ho();
        localObject2 = at.dVC.L("last_login_use_voice", "");
        localObject1 = new com.tencent.mm.plugin.setting.model.SwitchAccountModel(this.fnG, (String)localObject1, str, "", bk.ZR((String)localObject2));
        this.nRT.put(this.fnG, localObject1);
      }
      label372:
      if (this.nRT.size() == 0)
      {
        localObject1 = new Intent(this, MobileInputUI.class);
        ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject1).putExtra("can_finish", true);
        startActivity((Intent)localObject1);
        finish();
        com.tencent.mm.ui.base.b.gL(this);
      }
      I(this.nRT);
      this.nRP.J(this.nRT);
      if (this.scene != 1) {
        break label790;
      }
      localObject1 = ae.getContext().getSharedPreferences("switch_account_preferences", 0).getString("last_switch_account_to_wx_username", "");
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s", new Object[] { localObject1 });
      if (bk.bl((String)localObject1)) {
        break label743;
      }
      g.DN();
      if (!com.tencent.mm.kernel.a.Db()) {
        break label735;
      }
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
      finish();
    }
    for (;;)
    {
      this.nRP.bzE();
      bzn();
      this.nRP.setOnDeleteAvatarListener(new SettingsSwitchAccountUI.4(this));
      this.nWe = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.nWe.addUpdateListener(new SettingsSwitchAccountUI.5(this));
      this.nWe.addListener(new SettingsSwitchAccountUI.6(this));
      this.nWe.setDuration(500L);
      return;
      this.fbi.setVisibility(8);
      break;
      label615:
      this.fnG = at.dVC.L("login_weixin_username", "");
      break label233;
      label633:
      if (((Set)localObject1).isEmpty()) {
        break label372;
      }
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        str = (String)((Iterator)localObject1).next();
        localObject2 = new com.tencent.mm.plugin.setting.model.SwitchAccountModel(str, bv.dXJ.getString(str, "login_user_name"), bv.dXJ.getString(str, "last_avatar_path"), bv.dXJ.getString(str, "last_logout_no_pwd_ticket"), bk.ZR(bv.dXJ.getString(str, "last_login_use_voice")));
        this.nRT.put(str, localObject2);
      }
      break label372;
      label735:
      Mq((String)localObject1);
      continue;
      label743:
      this.nWg = false;
      localObject1 = new Intent(this, MobileInputUI.class);
      ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
      ((Intent)localObject1).putExtra("from_switch_account", true);
      startActivity((Intent)localObject1);
      com.tencent.mm.ui.base.b.gI(this);
      continue;
      label790:
      if (this.scene == 0) {
        this.nRP.setLastLoginWxUsername(this.fnG);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 701) && (paramInt2 == -1)) {
      bzo();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsSwitchAccountUI", "onResume");
    if ((this.scene == 1) || (this.scene == 2)) {
      g.Dk().a(701, this);
    }
    if (this.scene == 0)
    {
      g.Dk().a(281, this);
      g.Dk().a(282, this);
      g.Dk().a(255, this);
    }
    this.nRP.bzE();
    bzn();
    if (((this.scene == 1) || (this.scene == 2)) && (g.DK()))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsSwitchAccountUI", "account has ready");
      this.nWg = true;
      Intent localIntent = com.tencent.mm.plugin.account.a.a.eUR.aN(this);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      finish();
      com.tencent.mm.ui.base.b.gK(this);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsSwitchAccountUI", "errCode %d, errMsg %s, scene %s, this %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramm, this });
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramm.getType() == 701)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label419;
      }
      this.nWb.setVisibility(4);
      this.nWc.setVisibility(4);
      localObject1 = this.nRP;
      if (!((SwitchAccountGridView)localObject1).nYe)
      {
        if ((((SwitchAccountGridView)localObject1).nYf == null) && (!bk.bl(((SwitchAccountGridView)localObject1).nYd)))
        {
          int i = Math.min(2, ((SwitchAccountGridView)localObject1).nYg.size());
          localObject2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.4((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject2).setDuration(200L);
          localObject3 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject2).addUpdateListener(new SwitchAccountGridView.5((SwitchAccountGridView)localObject1, i));
          ((ValueAnimator)localObject3).setDuration(300L);
          ((SwitchAccountGridView)localObject1).nYf = new AnimatorSet();
          ((SwitchAccountGridView)localObject1).nYf.addListener(new SwitchAccountGridView.6((SwitchAccountGridView)localObject1));
          ((SwitchAccountGridView)localObject1).nYf.playSequentially(new Animator[] { localObject2, localObject3 });
        }
        if (((SwitchAccountGridView)localObject1).nYf != null)
        {
          ((SwitchAccountGridView)localObject1).nYe = true;
          ((SwitchAccountGridView)localObject1).nYf.start();
        }
      }
      com.tencent.mm.kernel.a.unhold();
      w.bL(this);
      if (bv.dXJ.Ii().size() > 1)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(0), bv.dXJ.Ij() });
        this.nRP.setOnAnimatorEndListener(new SwitchAccountGridView.a()
        {
          public final void bzr()
          {
            String str = at.dVC.L("login_weixin_username", "");
            SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).setLastLoginWxUsername(str);
            SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).setSwitchToWxUsername("");
            SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).bzE();
            SettingsSwitchAccountUI.h(SettingsSwitchAccountUI.this).start();
          }
        });
      }
    }
    else
    {
      label344:
      if (paramm.getType() != 255) {
        break label844;
      }
      if (((r)paramm).ezS == 2)
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label683;
        }
        bzo();
      }
    }
    label419:
    label631:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(0), bv.dXJ.Ij() });
            break;
            this.nRP.setSwitchToWxUsername("");
            this.nWg = false;
            com.tencent.mm.ui.base.h.bC(this, getString(a.i.settings_switch_account_error_tip));
            localObject1 = ((com.tencent.mm.modelsimple.q)paramm).ezK;
            if ((!bk.bl((String)localObject1)) && (this.nRT.containsKey(localObject1)))
            {
              localObject2 = new Intent();
              localObject3 = (com.tencent.mm.plugin.setting.model.SwitchAccountModel)this.nRT.get(localObject1);
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", new Object[] { localObject1, Integer.valueOf(((com.tencent.mm.plugin.setting.model.SwitchAccountModel)localObject3).nQO) });
              if ((((com.tencent.mm.plugin.setting.model.SwitchAccountModel)localObject3).nQO & 0x20000) == 0) {
                break label631;
              }
              ((Intent)localObject2).setClass(this, LoginVoiceUI.class);
            }
            for (;;)
            {
              ((Intent)localObject2).putExtra("switch_login_wx_id", (String)localObject1);
              startActivity((Intent)localObject2);
              finish();
              com.tencent.mm.ui.base.b.gL(this);
              if (bv.dXJ.Ii().size() <= 1) {
                break label644;
              }
              com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(1), bv.dXJ.Ij() });
              break;
              ((Intent)localObject2).setClass(this, LoginPasswordUI.class);
            }
            com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(1), bv.dXJ.Ij() });
            break label344;
            if ((paramInt2 == -3) && (paramInt1 == 4))
            {
              if (bv.dXJ.Ii().size() > 1) {
                com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(7), bv.dXJ.Ij() });
              }
              for (;;)
              {
                paramString = new Intent(this.mController.uMN, RegByMobileSetPwdUI.class);
                paramString.putExtra("kintent_hint", getString(a.i.regbymobile_reg_setpwd_tip_when_logout));
                startActivityForResult(paramString, 701);
                return;
                com.tencent.mm.plugin.report.service.h.nFQ.f(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(7), bv.dXJ.Ij() });
              }
            }
          } while (!com.tencent.mm.plugin.setting.b.eUS.a(this, paramInt1, paramInt2, paramString));
          return;
        } while (paramm.getType() != 282);
        g.DN();
      } while (!com.tencent.mm.kernel.a.Db());
      paramString = ((aul)((com.tencent.mm.modelsimple.p)paramm).dmK.ecF.ecN).tpZ;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsSwitchAccountUI", "logout return");
      if (bk.bl(paramString)) {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsSwitchAccountUI", "no pwd ticket is null!");
      }
      paramm = at.dVC.L("login_weixin_username", "");
      bv.dXJ.l(paramm, "last_logout_no_pwd_ticket", paramString);
    } while ((this.nWf == null) || (this.nWf.crl()));
    label644:
    label683:
    label844:
    this.nWf.stopTimer();
    bzp();
  }
  
  protected void onStop()
  {
    super.onStop();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SettingsSwitchAccountUI", "onStop");
    if (this.scene == 1)
    {
      SwitchAccountGridView localSwitchAccountGridView = this.nRP;
      if (localSwitchAccountGridView.nYe)
      {
        localSwitchAccountGridView.nYe = false;
        if (localSwitchAccountGridView.nYf != null) {
          localSwitchAccountGridView.nYf.end();
        }
      }
    }
    g.Dk().b(701, this);
    g.Dk().b(281, this);
    g.Dk().b(282, this);
    g.Dk().b(255, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSwitchAccountUI
 * JD-Core Version:    0.7.0.1
 */