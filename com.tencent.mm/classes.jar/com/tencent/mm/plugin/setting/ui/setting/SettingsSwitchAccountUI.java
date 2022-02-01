package com.tencent.mm.plugin.setting.ui.setting;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.aah;
import com.tencent.mm.autogen.a.ah;
import com.tencent.mm.autogen.a.hv;
import com.tencent.mm.autogen.a.ny;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.n;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.account.ui.LoginPasswordUI;
import com.tencent.mm.plugin.account.ui.LoginVoiceUI;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.SwitchAccountReceiver;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.b;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.djy;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class SettingsSwitchAccountUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private View AtJ;
  private SwitchAccountGridView Ppc;
  private Map<String, SwitchAccountModel> Ppe;
  private boolean Pty;
  private View Pwn;
  private TextView Pwo;
  private ValueAnimator Pwp;
  private MTimerHandler Pwq;
  private boolean Pwr;
  private boolean Pws;
  private BroadcastReceiver Pwt;
  private SwitchAccountGridView.b Pwu;
  private String qaF;
  private int scene;
  private TextView titleView;
  
  public SettingsSwitchAccountUI()
  {
    AppMethodBeat.i(74445);
    this.Ppe = new HashMap();
    this.Pwt = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(74433);
        Log.i("MicroMsg.SettingsSwitchAccountUI", "onReceive %s", new Object[] { paramAnonymousIntent.getAction() });
        SettingsSwitchAccountUI.this.unregisterReceiver(SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this));
        if (Util.nullAsNil(paramAnonymousIntent.getAction()).equals("action_kill_mm_process"))
        {
          com.tencent.mm.kernel.h.baC();
          com.tencent.mm.kernel.b.aZH();
          com.tencent.mm.kernel.h.baF().FB("switch account ,delay logout");
          Mars.onSingalCrash(0);
          Log.appenderFlush();
          SettingsSwitchAccountUI.this.finish();
          Log.i("MicroMsg.SettingsSwitchAccountUI", "try to kill mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
          new aah().publish();
        }
        AppMethodBeat.o(74433);
      }
    };
    this.Pwu = new SwitchAccountGridView.b()
    {
      public final void aVI(String paramAnonymousString)
      {
        AppMethodBeat.i(299093);
        if (!Util.isNullOrNil(paramAnonymousString))
        {
          if (SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this) == 0)
          {
            SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, paramAnonymousString);
            AppMethodBeat.o(299093);
            return;
          }
          SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, paramAnonymousString);
          AppMethodBeat.o(299093);
          return;
        }
        if (SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this) == 0)
        {
          paramAnonymousString = com.tencent.mm.plugin.report.service.h.OAn;
          if (SettingsSwitchAccountUI.c(SettingsSwitchAccountUI.this).size() > 1)
          {
            i = 1;
            paramAnonymousString.b(14978, new Object[] { Integer.valueOf(i), Integer.valueOf(11), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
            paramAnonymousString = (String)com.tencent.mm.kernel.h.baE().ban().d(274436, null);
            i = com.tencent.mm.k.i.aRC().getInt("AffiliatedAcctRegSwitch", 0);
            com.tencent.mm.kernel.h.baC();
            if (((!com.tencent.mm.kernel.b.aZM()) || (!"CN".equalsIgnoreCase(paramAnonymousString)) || (i != 1)) && (!BuildInfo.DEBUG)) {
              break label321;
            }
            paramAnonymousString = com.tencent.mm.plugin.report.service.h.OAn;
            if (SettingsSwitchAccountUI.c(SettingsSwitchAccountUI.this).size() <= 1) {
              break label316;
            }
          }
          label316:
          for (int i = 1;; i = 0)
          {
            paramAnonymousString.b(14978, new Object[] { Integer.valueOf(i), Integer.valueOf(12), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
            paramAnonymousString = new com.tencent.mm.ui.widget.a.f(SettingsSwitchAccountUI.this.getContext(), 1, false);
            paramAnonymousString.Vtg = new u.g()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
              {
                AppMethodBeat.i(298848);
                paramAnonymous2s.c(0, SettingsSwitchAccountUI.this.getString(b.i.settings_switch_account_logout));
                paramAnonymous2s.c(1, SettingsSwitchAccountUI.this.getString(b.i.settings_switch_account_register));
                AppMethodBeat.o(298848);
              }
            };
            paramAnonymousString.GAC = new u.i()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(298850);
                switch (paramAnonymous2MenuItem.getItemId())
                {
                default: 
                  AppMethodBeat.o(298850);
                  return;
                case 0: 
                  paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.h.OAn;
                  if (SettingsSwitchAccountUI.c(SettingsSwitchAccountUI.this).size() > 1) {}
                  for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                  {
                    paramAnonymous2MenuItem.b(14978, new Object[] { Integer.valueOf(paramAnonymous2Int), Integer.valueOf(13), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
                    paramAnonymous2MenuItem = MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0);
                    paramAnonymous2MenuItem.edit().putString("last_switch_account_to_wx_username", "").commit();
                    paramAnonymous2MenuItem.edit().putBoolean("last_switch_account_to_regui", false).commit();
                    SettingsSwitchAccountUI.gWk();
                    AppMethodBeat.o(298850);
                    return;
                  }
                }
                paramAnonymous2MenuItem = com.tencent.mm.plugin.report.service.h.OAn;
                if (SettingsSwitchAccountUI.c(SettingsSwitchAccountUI.this).size() > 1) {}
                for (paramAnonymous2Int = 1;; paramAnonymous2Int = 0)
                {
                  paramAnonymous2MenuItem.b(14978, new Object[] { Integer.valueOf(paramAnonymous2Int), Integer.valueOf(14), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
                  paramAnonymous2MenuItem = new Intent(SettingsSwitchAccountUI.this, SettingsSelectCreateAccount.class);
                  SettingsSwitchAccountUI.this.startActivityForResult(paramAnonymous2MenuItem, 702);
                  break;
                }
              }
            };
            paramAnonymousString.dDn();
            AppMethodBeat.o(299093);
            return;
            i = 0;
            break;
          }
          label321:
          paramAnonymousString = MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0);
          paramAnonymousString.edit().putString("last_switch_account_to_wx_username", "").commit();
          paramAnonymousString.edit().putBoolean("last_switch_account_to_regui", false).commit();
          SettingsSwitchAccountUI.gWk();
          AppMethodBeat.o(299093);
          return;
        }
        Object localObject = new Intent(SettingsSwitchAccountUI.this, MobileInputUI.class);
        ((Intent)localObject).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject).putExtra("from_switch_account", true);
        paramAnonymousString = SettingsSwitchAccountUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$5", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$5", "onClickAvatar", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.nd(SettingsSwitchAccountUI.this);
        AppMethodBeat.o(299093);
      }
    };
    AppMethodBeat.o(74445);
  }
  
  private void aVF(String paramString)
  {
    AppMethodBeat.i(74450);
    Object localObject = (SwitchAccountModel)this.Ppe.get(paramString);
    if ((localObject != null) && (!this.Pwr))
    {
      this.Pwr = true;
      Log.i("MicroMsg.SettingsSwitchAccountUI", "doLoginScene: wxid: %s username:%s, ticket:%s", new Object[] { paramString, ((SwitchAccountModel)localObject).username, ((SwitchAccountModel)localObject).PnS });
      localObject = new u(paramString, ((SwitchAccountModel)localObject).username, ((SwitchAccountModel)localObject).PnS, "");
      com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
      this.Ppc.setSwitchToWxUsername(paramString);
      this.Ppc.gWD();
      gWh();
    }
    AppMethodBeat.o(74450);
  }
  
  private void aVG(String paramString)
  {
    AppMethodBeat.i(74461);
    Object localObject = new IntentFilter("action_kill_mm_process");
    registerReceiver(this.Pwt, (IntentFilter)localObject);
    localObject = new Intent(this, FakeSwitchAccountUI.class);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.Ppe.values());
    ((Intent)localObject).putParcelableArrayListExtra("key_switch_account_users", localArrayList);
    ((Intent)localObject).putExtra("key_switch_from_wx_username", paramString);
    MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("transit_to_switch_account", true).commit();
    paramString = LocaleUtil.loadApplicationLanguage(getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this);
    float f = com.tencent.mm.cd.a.getScaleSize(this);
    ((Intent)localObject).putExtra("key_langauage_code", paramString);
    ((Intent)localObject).putExtra("key_font_scale_size", f);
    Log.i("MicroMsg.SettingsSwitchAccountUI", "mm pid %d", new Object[] { Integer.valueOf(Process.myPid()) });
    ((Intent)localObject).putExtra("key_mm_process_pid", Process.myPid());
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "transitToSwitchAccount", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.ng(this);
    AppMethodBeat.o(74461);
  }
  
  private static void dHR()
  {
    AppMethodBeat.i(74458);
    if ((com.tencent.mm.kernel.h.aZW() != null) && (com.tencent.mm.kernel.h.aZW().oun != null)) {
      com.tencent.mm.kernel.h.aZW().oun.hb(false);
    }
    new hv().publish();
    com.tencent.mm.kernel.h.baC();
    Log.w("MicroMsg.SettingsSwitchAccountUI", "dklogout User LOGOUT Now uin:%d , clear cookie", new Object[] { Integer.valueOf(com.tencent.mm.kernel.b.getUin()) });
    com.tencent.mm.modelstat.c.bMY().FY();
    ((com.tencent.mm.plugin.expt.b.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.f.class)).dHR();
    v localv = new v(2);
    localv.oST = 1;
    com.tencent.mm.kernel.h.aZW().a(localv, 0);
    AppMethodBeat.o(74458);
  }
  
  private void gWh()
  {
    AppMethodBeat.i(74451);
    if (this.Pwr)
    {
      showOptionMenu(false);
      AppMethodBeat.o(74451);
      return;
    }
    if ((this.Ppe.size() <= 1) && (this.scene == 0))
    {
      showOptionMenu(false);
      this.Pty = false;
      this.Ppc.setDeleteState(false);
      AppMethodBeat.o(74451);
      return;
    }
    if (!this.Pty)
    {
      this.titleView.setText(b.i.settings_switch_account_login_title);
      this.Pwo.setVisibility(8);
      addTextOptionMenu(0, getString(b.i.app_manage), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(299384);
          if (!SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this))
          {
            SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, true);
            SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).setDeleteState(SettingsSwitchAccountUI.g(SettingsSwitchAccountUI.this));
            SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).gWD();
            SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
            if (cj.ono.bDj().size() <= 1) {
              break label131;
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(3), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
          }
          for (;;)
          {
            AppMethodBeat.o(299384);
            return false;
            label131:
            com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(3), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
          }
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    this.titleView.setText(b.i.settings_switch_account_delete_title);
    this.Pwo.setVisibility(0);
    if (this.Pws)
    {
      addTextOptionMenu(0, getString(b.i.app_finish), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(299383);
          SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
          SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).setDeleteState(false);
          SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).gWD();
          SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
          if (SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).getAccountCount() == 0)
          {
            if (cj.ono.bDj().size() <= 1) {
              break label245;
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(11), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
          }
          for (;;)
          {
            Object localObject = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(SettingsSwitchAccountUI.this);
            ((Intent)localObject).addFlags(67108864);
            paramAnonymousMenuItem = SettingsSwitchAccountUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$9", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$9", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            SettingsSwitchAccountUI.this.finish();
            com.tencent.mm.ui.base.b.nf(SettingsSwitchAccountUI.this);
            SettingsSwitchAccountUI.h(SettingsSwitchAccountUI.this);
            AppMethodBeat.o(299383);
            return false;
            label245:
            com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(11), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
          }
        }
      });
      AppMethodBeat.o(74451);
      return;
    }
    addTextOptionMenu(0, getString(b.i.app_cancel), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(299143);
        SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, false);
        SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).setDeleteState(false);
        SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).gWD();
        SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
        AppMethodBeat.o(299143);
        return false;
      }
    });
    AppMethodBeat.o(74451);
  }
  
  private void gWi()
  {
    AppMethodBeat.i(74459);
    if (com.tencent.mm.kernel.b.sy(com.tencent.mm.kernel.h.baC().mBT))
    {
      localObject = new af();
      com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    }
    Object localObject = new t();
    com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    this.Ppc.setLogoutState(true);
    this.Ppc.gWD();
    if (this.Pwq == null)
    {
      this.Pwq = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(299156);
          SettingsSwitchAccountUI.j(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(299156);
          return false;
        }
      }, false);
      this.Pwq.startTimer(8000L);
    }
    AppMethodBeat.o(74459);
  }
  
  private void gWj()
  {
    AppMethodBeat.i(74460);
    Log.i("MicroMsg.SettingsSwitchAccountUI", "switch account logout");
    com.tencent.mm.plugin.setting.c.pFo.aDD();
    setBackBtnVisible(false);
    showOptionMenu(false);
    Object localObject = new ny();
    ((ny)localObject).hQx.status = 0;
    ((ny)localObject).hQx.reason = 0;
    ((ny)localObject).publish();
    localObject = new ah();
    ((ah)localObject).hAc.hAd = true;
    ((ah)localObject).publish();
    MMEntryLock.unlock("show_whatsnew");
    n.w(this, true);
    if (com.tencent.mm.kernel.h.baz())
    {
      localObject = d.Lz(z.bAM());
      bg.okT.JD((String)localObject);
    }
    Log.i("MicroMsg.SettingsSwitchAccountUI", "last login username in sp %s", new Object[] { bg.okT.aM("login_user_name", "") });
    localObject = z.bBM();
    if (Util.isNullOrNil((String)((Map)localObject).get("login_user_name"))) {
      ((Map)localObject).put("login_user_name", bg.okT.aM("login_user_name", ""));
    }
    cj.ono.g(z.bAM(), (Map)localObject);
    MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", true).commit();
    aVG(z.bAM());
    AppMethodBeat.o(74460);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(74455);
    Log.i("MicroMsg.SettingsSwitchAccountUI", "go back");
    if ((this.scene == 2) || (this.scene == 1))
    {
      Object localObject = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("can_finish", true);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.nf(this);
      this.Pwr = false;
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
    hideActionbarLine();
    setActionbarColor(getResources().getColor(b.c.settings_bg));
    addTextOptionMenu(0, getString(b.i.app_manage), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        return false;
      }
    });
    this.scene = getIntent().getIntExtra("key_scene", 0);
    this.AtJ = findViewById(b.f.switch_account_title_container);
    this.Pwn = findViewById(b.f.switch_account_icon);
    this.titleView = ((TextView)findViewById(b.f.switch_account_title));
    this.Pwo = ((TextView)findViewById(b.f.switch_account_del_tip));
    this.Ppc = ((SwitchAccountGridView)findViewById(b.f.switch_account_grid));
    this.Ppc.setOnClickAvatarListener(this.Pwu);
    Object localObject1;
    label224:
    String str1;
    Object localObject2;
    String str2;
    label395:
    boolean bool;
    if (this.scene == 0)
    {
      localObject1 = new Intent(this, SwitchAccountReceiver.class);
      ((Intent)localObject1).putExtra("switch_process_action_code_key", "action_switch_account");
      MMApplicationContext.getContext().sendBroadcast((Intent)localObject1);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(299067);
          SettingsSwitchAccountUI.b(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(299067);
          return false;
        }
      });
      localObject1 = cj.ono.bDj();
      com.tencent.mm.kernel.h.baC();
      if (!com.tencent.mm.kernel.b.aZM()) {
        break label733;
      }
      this.qaF = ((String)com.tencent.mm.kernel.h.baE().ban().d(2, null));
      Log.i("MicroMsg.SettingsSwitchAccountUI", "scene %d， lastLoginWxUsername %s", new Object[] { Integer.valueOf(this.scene), this.qaF });
      if ((Util.isNullOrNil(this.qaF)) || (((Set)localObject1).contains(this.qaF))) {
        break label751;
      }
      if ((this.scene != 2) || (cj.ono.Ke(this.qaF)))
      {
        localObject1 = bg.okT.aM("login_user_name", "");
        str1 = bg.okT.aM("last_login_nick_name", "");
        localObject2 = bg.okT.bCr();
        str2 = bg.okT.aM("last_login_use_voice", "");
        String str3 = cj.ono.getString(this.qaF, "last_logout_no_pwd_ticket");
        localObject1 = new SwitchAccountModel(this.qaF, (String)localObject1, (String)localObject2, str3, Util.safeParseInt(str2), str1);
        this.Ppe.put(this.qaF, localObject1);
      }
      if (this.Ppe.size() == 0)
      {
        localObject1 = new Intent(this, MobileInputUI.class);
        ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
        ((Intent)localObject1).putExtra("can_finish", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        com.tencent.mm.ui.base.b.ng(this);
      }
      this.Ppc.aQ(this.Ppe);
      if (this.scene != 1) {
        break label1018;
      }
      localObject1 = MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0);
      str1 = ((SharedPreferences)localObject1).getString("last_switch_account_to_wx_username", "");
      bool = ((SharedPreferences)localObject1).getBoolean("last_switch_account_to_regui", false);
      ((SharedPreferences)localObject1).edit().putBoolean("transit_to_switch_account", false).commit();
      Log.i("MicroMsg.SettingsSwitchAccountUI", "switch to %s", new Object[] { str1 });
      if (Util.isNullOrNil(str1)) {
        break label881;
      }
      com.tencent.mm.kernel.h.baC();
      if (!com.tencent.mm.kernel.b.aZM()) {
        break label873;
      }
      Log.w("MicroMsg.SettingsSwitchAccountUI", "already login ,quit");
      finish();
    }
    for (;;)
    {
      this.Ppc.gWD();
      gWh();
      this.Ppc.setOnDeleteAvatarListener(new SwitchAccountGridView.c()
      {
        public final void aVH(final String paramAnonymousString)
        {
          AppMethodBeat.i(74439);
          k.b(SettingsSwitchAccountUI.this, SettingsSwitchAccountUI.this.getString(b.i.settings_switch_account_delete_alert, new Object[] { ((SwitchAccountModel)SettingsSwitchAccountUI.c(SettingsSwitchAccountUI.this).get(paramAnonymousString)).username }), SettingsSwitchAccountUI.this.getString(b.i.app_tip), SettingsSwitchAccountUI.this.getString(b.i.app_yes), SettingsSwitchAccountUI.this.getString(b.i.app_no), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(74438);
              Log.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", new Object[] { paramAnonymousString });
              SettingsSwitchAccountUI.a(SettingsSwitchAccountUI.this, true);
              cj.ono.Kb(paramAnonymousString);
              SettingsSwitchAccountUI.c(SettingsSwitchAccountUI.this).remove(paramAnonymousString);
              paramAnonymous2DialogInterface = SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this);
              String str = paramAnonymousString;
              if (paramAnonymous2DialogInterface.PyA.contains(str))
              {
                paramAnonymous2Int = paramAnonymous2DialogInterface.PyA.indexOf(str);
                paramAnonymous2DialogInterface.PyA.remove(str);
                paramAnonymous2DialogInterface.PyB.remove(paramAnonymous2Int);
                paramAnonymous2DialogInterface.PyC.remove(paramAnonymous2Int);
              }
              SettingsSwitchAccountUI.e(SettingsSwitchAccountUI.this);
              SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).gWD();
              if (SettingsSwitchAccountUI.f(SettingsSwitchAccountUI.this) == 0)
              {
                if (cj.ono.bDj().size() > 0)
                {
                  com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(4), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
                  AppMethodBeat.o(74438);
                  return;
                }
                com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(4), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
              }
              AppMethodBeat.o(74438);
            }
          }, null);
          AppMethodBeat.o(74439);
        }
      });
      this.Pwp = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Pwp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(299092);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).setTranslationY(-f * SettingsSwitchAccountUI.d(SettingsSwitchAccountUI.this).getHeight());
          AppMethodBeat.o(299092);
        }
      });
      this.Pwp.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(299389);
          Log.i("MicroMsg.SettingsSwitchAccountUI", "up animation end");
          Object localObject = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(SettingsSwitchAccountUI.this);
          ((Intent)localObject).addFlags(67108864);
          paramAnonymousAnimator = SettingsSwitchAccountUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAnimator, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$7", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAnimator.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAnimator, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI$7", "onAnimationEnd", "(Landroid/animation/Animator;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          SettingsSwitchAccountUI.this.finish();
          com.tencent.mm.ui.base.b.nf(SettingsSwitchAccountUI.this);
          AppMethodBeat.o(299389);
        }
      });
      this.Pwp.setDuration(500L);
      AppMethodBeat.o(74447);
      return;
      setBackBtnVisible(false);
      break;
      label733:
      this.qaF = bg.okT.aM("login_weixin_username", "");
      break label224;
      label751:
      if (((Set)localObject1).isEmpty()) {
        break label395;
      }
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        str1 = (String)((Iterator)localObject1).next();
        localObject2 = cj.ono.getString(str1, "login_user_name");
        str2 = cj.ono.getString(str1, "last_login_nick_name");
        localObject2 = new SwitchAccountModel(str1, (String)localObject2, cj.ono.getString(str1, "last_avatar_path"), cj.ono.getString(str1, "last_logout_no_pwd_ticket"), Util.safeParseInt(cj.ono.getString(str1, "last_login_use_voice")), str2);
        this.Ppe.put(str1, localObject2);
      }
      break label395;
      label873:
      aVF(str1);
      continue;
      label881:
      this.Pwr = false;
      if (!bool)
      {
        localObject1 = new Intent(this, MobileInputUI.class);
        ((Intent)localObject1).putExtra("mobile_input_purpose", 1);
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("from_switch_account", true);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "initView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.ng(this);
        cj.onp = true;
        break;
        localObject1 = new Intent(this, RegByMobileRegAIOUI.class);
      }
      label1018:
      if (this.scene == 0) {
        this.Ppc.setLastLoginWxUsername(this.qaF);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(74457);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 701)
    {
      if (paramInt2 == -1)
      {
        gWi();
        AppMethodBeat.o(74457);
      }
    }
    else if (paramInt1 == 702)
    {
      if (paramInt2 == 1)
      {
        paramIntent = MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0);
        paramIntent.edit().putString("last_switch_account_to_wx_username", "").commit();
        paramIntent.edit().putBoolean("last_switch_account_to_regui", true).commit();
        dHR();
        AppMethodBeat.o(74457);
        return;
      }
      if (paramInt2 == -1)
      {
        Object localObject1 = cj.ono.bDj();
        this.Ppe.clear();
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          String str1 = (String)((Iterator)localObject1).next();
          Object localObject2 = cj.ono.getString(str1, "login_user_name");
          String str2 = cj.ono.getString(str1, "last_login_nick_name");
          localObject2 = new SwitchAccountModel(str1, (String)localObject2, cj.ono.getString(str1, "last_avatar_path"), cj.ono.getString(str1, "last_logout_no_pwd_ticket"), Util.safeParseInt(cj.ono.getString(str1, "last_login_use_voice")), str2);
          this.Ppe.put(str1, localObject2);
        }
        this.Ppc.aQ(this.Ppe);
        gWh();
        this.Ppc.gWD();
        this.Ppc.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(299148);
            SettingsSwitchAccountUI.i(SettingsSwitchAccountUI.this).aVI(paramIntent.getStringExtra("SWITCH_TO_USERNAME"));
            aa.makeText(SettingsSwitchAccountUI.this.getContext(), SettingsSwitchAccountUI.this.getString(b.i.settings_register_affiliate_account_complete), 1).show();
            AppMethodBeat.o(299148);
          }
        });
      }
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
      unregisterReceiver(this.Pwt);
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
      com.tencent.mm.kernel.h.aZW().a(701, this);
      com.tencent.mm.kernel.h.aZW().a(252, this);
    }
    if (this.scene == 0)
    {
      com.tencent.mm.kernel.h.aZW().a(281, this);
      com.tencent.mm.kernel.h.aZW().a(282, this);
      com.tencent.mm.kernel.h.aZW().a(255, this);
    }
    this.Ppc.gWD();
    gWh();
    if (((this.scene == 1) || (this.scene == 2)) && (com.tencent.mm.kernel.h.baz()) && (com.tencent.mm.kernel.h.baC().mBZ))
    {
      Log.i("MicroMsg.SettingsSwitchAccountUI", "account initialized");
      this.Pwr = true;
      Object localObject = com.tencent.mm.plugin.account.sdk.a.pFn.cJ(this);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      com.tencent.mm.ui.base.b.nf(this);
    }
    AppMethodBeat.o(74452);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(74454);
    Log.i("MicroMsg.SettingsSwitchAccountUI", "errCode %d, errMsg %s, scene %s, type  %d, this %s", new Object[] { Integer.valueOf(paramInt2), paramString, paramp, Integer.valueOf(paramp.getType()), this });
    if ((paramp.getType() == 252) || (paramp.getType() == 701))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label270;
      }
      this.AtJ.setVisibility(4);
      this.Pwn.setVisibility(4);
      com.tencent.mm.kernel.b.aZI();
      com.tencent.mm.plugin.account.friend.model.i.bXa();
      if (cj.ono.bDj().size() <= 1) {
        break label216;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(0), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
      this.Pwp.start();
    }
    for (;;)
    {
      if (paramp.getType() == 255)
      {
        if (((v)paramp).oSU != 2) {
          break label983;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          gWi();
          AppMethodBeat.o(74454);
          return;
          label216:
          com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(0), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
          break;
          label270:
          this.Ppc.setSwitchToWxUsername("");
          this.Pwr = false;
          k.cZ(this, getString(b.i.settings_switch_account_error_tip));
          Object localObject = ((u)paramp).oSM;
          Intent localIntent;
          if ((!Util.isNullOrNil((String)localObject)) && (this.Ppe.containsKey(localObject)))
          {
            localIntent = new Intent();
            SwitchAccountModel localSwitchAccountModel = (SwitchAccountModel)this.Ppe.get(localObject);
            Log.i("MicroMsg.SettingsSwitchAccountUI", "wxID %s, plugSwitch: %d", new Object[] { localObject, Integer.valueOf(localSwitchAccountModel.PnT) });
            if ((WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned()) || ((localSwitchAccountModel.PnT & 0x20000) == 0)) {
              break label572;
            }
            localIntent.setClass(this, LoginVoiceUI.class);
          }
          for (;;)
          {
            localIntent.putExtra("switch_login_wx_id", (String)localObject);
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
            com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsSwitchAccountUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.ng(this);
            if (cj.ono.bDj().size() <= 1) {
              break label585;
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(1), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
            break;
            label572:
            localIntent.setClass(this, LoginPasswordUI.class);
          }
          label585:
          com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(1), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
          continue;
        }
        if ((paramInt2 == -3) && (paramInt1 == 4))
        {
          if (cj.ono.bDj().size() > 1) {
            com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(1), Integer.valueOf(7), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
          }
          for (;;)
          {
            paramString = new Intent(getContext(), RegByMobileSetPwdUI.class);
            paramString.putExtra("kintent_hint", getString(b.i.regbymobile_reg_setpwd_tip_when_logout));
            startActivityForResult(paramString, 701);
            AppMethodBeat.o(74454);
            return;
            com.tencent.mm.plugin.report.service.h.OAn.b(14978, new Object[] { Integer.valueOf(0), Integer.valueOf(7), cj.ono.bDk(), cj.ono.bDl(), q.aPg() });
          }
        }
        if (!com.tencent.mm.plugin.setting.c.pFo.a(this, paramInt1, paramInt2, paramString)) {
          break label983;
        }
        AppMethodBeat.o(74454);
        return;
      }
    }
    if (paramp.getType() == 282)
    {
      com.tencent.mm.kernel.h.baC();
      if (com.tencent.mm.kernel.b.aZM())
      {
        paramString = ((djy)c.c.b(((t)paramp).rr.otC)).aaPR;
        if (paramString != null) {
          break label990;
        }
      }
    }
    label983:
    label990:
    for (paramInt1 = -1;; paramInt1 = paramString.length())
    {
      Log.d("MicroMsg.SettingsSwitchAccountUI", "logout return noPwdTicket[%s]", new Object[] { Integer.valueOf(paramInt1) });
      if (Util.isNullOrNil(paramString)) {
        Log.i("MicroMsg.SettingsSwitchAccountUI", "no pwd ticket is null!");
      }
      paramp = z.bAM();
      Log.i("MicroMsg.SettingsSwitchAccountUI", "logout return username[%s]", new Object[] { paramp });
      cj.ono.s(paramp, "last_logout_no_pwd_ticket", paramString);
      if ((this.Pwq != null) && (!this.Pwq.stopped()))
      {
        this.Pwq.stopTimer();
        gWj();
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
      SwitchAccountGridView localSwitchAccountGridView = this.Ppc;
      if (localSwitchAccountGridView.pIz)
      {
        localSwitchAccountGridView.pIz = false;
        if (localSwitchAccountGridView.Pyz != null) {
          localSwitchAccountGridView.Pyz.end();
        }
      }
    }
    com.tencent.mm.kernel.h.aZW().b(701, this);
    com.tencent.mm.kernel.h.aZW().b(252, this);
    com.tencent.mm.kernel.h.aZW().b(281, this);
    com.tencent.mm.kernel.h.aZW().b(282, this);
    com.tencent.mm.kernel.h.aZW().b(255, this);
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