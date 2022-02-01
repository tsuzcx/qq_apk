package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.setting.model.a.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SettingsManageFindOtherServiceUI
  extends SettingsManageFindMoreUI
{
  private static int PtS = 1000;
  private static int PtT = 500;
  private static int PtU = 3;
  private static int PtV = 10;
  private static int PtW = 11;
  protected HashMap<Integer, Integer> PtX;
  private TextView PtY;
  private Button lDb;
  private View rootView;
  
  public SettingsManageFindOtherServiceUI()
  {
    AppMethodBeat.i(299391);
    this.PtX = new HashMap();
    AppMethodBeat.o(299391);
  }
  
  protected final void cIX()
  {
    AppMethodBeat.i(299454);
    Log.i("MicroMsg.SettingsManageFindMoreUI", "doReport.");
    Iterator localIterator = this.PtX.keySet().iterator();
    int j;
    CheckBoxPreference localCheckBoxPreference;
    if (localIterator.hasNext())
    {
      j = ((Integer)localIterator.next()).intValue();
      if (j == PtU)
      {
        if (!getPreferenceScreen().bAj("settings_search_switch")) {
          break label311;
        }
        localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("settings_search_switch");
      }
    }
    for (;;)
    {
      label87:
      Log.i("MicroMsg.SettingsManageFindMoreUI", "doReport. oldDefaultState.get(entrance) = " + this.PtX.get(Integer.valueOf(j)) + ", checkBoxPreference.isChecked() = " + localCheckBoxPreference.isChecked());
      int k = ((Integer)this.PtX.get(Integer.valueOf(j))).intValue();
      label159:
      h localh;
      if (localCheckBoxPreference.isChecked())
      {
        i = 1;
        if (k == i) {
          break label298;
        }
        localh = h.OAn;
        if (!localCheckBoxPreference.isChecked()) {
          break label300;
        }
      }
      label298:
      label300:
      for (int i = 1;; i = 0)
      {
        localh.b(15185, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(1) });
        break;
        if (j == PtV)
        {
          if (!getPreferenceScreen().bAj("settings_look_switch")) {
            break label311;
          }
          localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("settings_look_switch");
          break label87;
        }
        if ((j != PtW) || (!getPreferenceScreen().bAj("settings_finder_switch"))) {
          break label311;
        }
        localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("settings_finder_switch");
        break label87;
        i = 0;
        break label159;
        break;
      }
      AppMethodBeat.o(299454);
      return;
      label311:
      localCheckBoxPreference = null;
    }
  }
  
  protected final void gVL()
  {
    AppMethodBeat.i(299442);
    super.gVL();
    if (this.PtG.containsKey(Integer.valueOf(3))) {
      this.PtX.put(Integer.valueOf(3), (Integer)this.PtG.get(Integer.valueOf(3)));
    }
    if ((this.PtJ) && (getPreferenceScreen().bAj("settings_search_switch")))
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("settings_search_switch");
      if (localCheckBoxPreference != null)
      {
        if (this.PtM)
        {
          localCheckBoxPreference.setChecked(true);
          this.PtG.put(Integer.valueOf(3), Integer.valueOf(1));
          AppMethodBeat.o(299442);
          return;
        }
        localCheckBoxPreference.setChecked(false);
        this.PtG.put(Integer.valueOf(3), Integer.valueOf(0));
      }
    }
    AppMethodBeat.o(299442);
  }
  
  protected final void gVM()
  {
    AppMethodBeat.i(299447);
    super.gVM();
    if (this.PtG.containsKey(Integer.valueOf(10))) {
      this.PtX.put(Integer.valueOf(10), (Integer)this.PtG.get(Integer.valueOf(10)));
    }
    if ((this.PtJ) && (getPreferenceScreen().bAj("settings_look_switch")))
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("settings_look_switch");
      if (localCheckBoxPreference != null)
      {
        if (this.PtM)
        {
          localCheckBoxPreference.setChecked(true);
          this.PtG.put(Integer.valueOf(10), Integer.valueOf(1));
          AppMethodBeat.o(299447);
          return;
        }
        localCheckBoxPreference.setChecked(false);
        this.PtG.put(Integer.valueOf(10), Integer.valueOf(0));
      }
    }
    AppMethodBeat.o(299447);
  }
  
  protected final void gVN()
  {
    AppMethodBeat.i(299450);
    super.gVN();
    if (this.PtG.containsKey(Integer.valueOf(11))) {
      this.PtX.put(Integer.valueOf(11), (Integer)this.PtG.get(Integer.valueOf(11)));
    }
    if ((this.PtJ) && (getPreferenceScreen().bAj("settings_finder_switch")))
    {
      CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)getPreferenceScreen().bAi("settings_finder_switch");
      if (localCheckBoxPreference != null)
      {
        if (this.PtM)
        {
          localCheckBoxPreference.setChecked(true);
          this.PtG.put(Integer.valueOf(11), Integer.valueOf(1));
          AppMethodBeat.o(299450);
          return;
        }
        localCheckBoxPreference.setChecked(false);
        this.PtG.put(Integer.valueOf(11), Integer.valueOf(0));
      }
    }
    AppMethodBeat.o(299450);
  }
  
  protected final boolean gVO()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return b.g.setting_finder_mg_preference;
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_manage_find_other_service_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(299435);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(298679);
        k.b(SettingsManageFindOtherServiceUI.this, SettingsManageFindOtherServiceUI.this.getString(b.i.setting_wechat_permission_cancel_alert_title), null, SettingsManageFindOtherServiceUI.this.getString(b.i.setting_wechat_permission_cancel_alert_yes), SettingsManageFindOtherServiceUI.this.getString(b.i.setting_wechat_permission_cancel_alert_no), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(298654);
            SettingsManageFindOtherServiceUI.a(SettingsManageFindOtherServiceUI.this);
            AppMethodBeat.o(298654);
          }
        });
        AppMethodBeat.o(298679);
        return true;
      }
    }, b.h.actionbar_icon_close_black);
    this.rootView = findViewById(b.f.mm_preference_list_content_root);
    this.rootView.setBackgroundColor(getResources().getColor(b.c.white_color));
    this.lDb = ((Button)findViewById(b.f.finish_btn));
    this.PtY = ((TextView)findViewById(b.f.permission_delete_tips));
    ArrayList localArrayList1 = new ArrayList();
    if ("zh_CN".equals(LocaleUtil.getCurrentLanguage(this))) {
      localArrayList1.add("https://" + WeChatHosts.domainString(b.i.host_help_wechat_com) + "/cgi-bin/micromsg-bin/oshelpcenter?opcode=2&lang=zh_CN&plat=android&pid=1002060&id=180514qe7zqb180514ea6rff&Channel=helpcenter");
    }
    for (;;)
    {
      String str = this.PtY.getText().toString();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(getString(b.i.setting_wechat_permission_tips_link_text));
      p.a(this, localArrayList1, str, localArrayList2, this.PtY);
      this.lDb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(298692);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsManageFindOtherServiceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          long l1 = 0L;
          final long l2 = 0L;
          paramAnonymousView = SettingsManageFindOtherServiceUI.this.PtG.keySet().iterator();
          boolean bool1 = false;
          while (paramAnonymousView.hasNext())
          {
            int i = ((Integer)paramAnonymousView.next()).intValue();
            if (i == SettingsManageFindOtherServiceUI.PtU)
            {
              localObject = (CheckBoxPreference)SettingsManageFindOtherServiceUI.this.getPreferenceScreen().bAi("settings_search_switch");
              if (SettingsManageFindOtherServiceUI.this.getPreferenceScreen().bAj("settings_search_switch"))
              {
                l2 |= 0x200000;
                if (!((CheckBoxPreference)localObject).isChecked()) {
                  l1 |= 0x200000;
                }
                for (;;)
                {
                  Log.i("MicroMsg.SettingsManageFindMoreUI", "finishBtn, settings_search_switch " + ((CheckBoxPreference)localObject).isChecked());
                  break;
                  bool1 = true;
                }
              }
            }
            else if (i == SettingsManageFindOtherServiceUI.PtV)
            {
              if (SettingsManageFindOtherServiceUI.this.getPreferenceScreen().bAj("settings_look_switch"))
              {
                l2 |= 0x4000000;
                localObject = (CheckBoxPreference)SettingsManageFindOtherServiceUI.this.getPreferenceScreen().bAi("settings_look_switch");
                if (!((CheckBoxPreference)localObject).isChecked()) {
                  l1 |= 0x4000000;
                }
                for (;;)
                {
                  Log.i("MicroMsg.SettingsManageFindMoreUI", "finishBtn, settings_look_switch " + ((CheckBoxPreference)localObject).isChecked());
                  break;
                  bool1 = true;
                }
              }
            }
            else
            {
              boolean bool2 = bool1;
              long l4 = l2;
              long l3 = l1;
              if (i == SettingsManageFindOtherServiceUI.PtW)
              {
                if (!SettingsManageFindOtherServiceUI.this.getPreferenceScreen().bAj("settings_finder_switch")) {
                  continue;
                }
                l4 = l2 | 0x0;
                localObject = (CheckBoxPreference)SettingsManageFindOtherServiceUI.this.getPreferenceScreen().bAi("settings_finder_switch");
                if (((CheckBoxPreference)localObject).isChecked()) {
                  break label403;
                }
                l1 |= 0x0;
              }
              for (;;)
              {
                Log.i("MicroMsg.SettingsManageFindMoreUI", "finishBtn, settings_finder_switch = " + ((CheckBoxPreference)localObject).isChecked());
                l3 = l1;
                bool2 = bool1;
                bool1 = bool2;
                l2 = l4;
                l1 = l3;
                break;
                label403:
                bool1 = true;
              }
            }
          }
          Log.i("MicroMsg.SettingsManageFindMoreUI", "finishBtn, switchValue = " + l1 + ", WhichExtFunctionSwitch = " + l2 + ", hasOpen = " + bool1);
          if (bool1) {
            com.tencent.mm.plugin.setting.ui.b.a.a(SettingsManageFindOtherServiceUI.this, SettingsManageFindOtherServiceUI.this.getString(b.i.setting_finder_other_services_dlg_bottom_title), new SettingsManageFindOtherServiceUI.a()
            {
              public final void sK(boolean paramAnonymous2Boolean)
              {
                AppMethodBeat.i(299085);
                if (paramAnonymous2Boolean)
                {
                  Log.i("MicroMsg.SettingsManageFindMoreUI", "showTipDialog, yes.");
                  com.tencent.mm.plugin.setting.ui.b.a.a(SettingsManageFindOtherServiceUI.this, 1, l2, this.Puc, new a.a()
                  {
                    public final void b(boolean paramAnonymous3Boolean, app paramAnonymous3app)
                    {
                      AppMethodBeat.i(298817);
                      if ((paramAnonymous3app == null) || (!paramAnonymous3Boolean))
                      {
                        Log.i("MicroMsg.SettingsManageFindMoreUI", "showTipDialog, response no.");
                        com.tencent.mm.plugin.setting.ui.b.a.cZ(SettingsManageFindOtherServiceUI.this);
                        AppMethodBeat.o(298817);
                        return;
                      }
                      Log.i("MicroMsg.SettingsManageFindMoreUI", "showTipDialog, response yes.");
                      long l = System.currentTimeMillis();
                      SettingsManageFindOtherServiceUI.b(SettingsManageFindOtherServiceUI.this);
                      Log.i("MicroMsg.SettingsManageFindMoreUI", "showTipDialog time = " + (System.currentTimeMillis() - l));
                      if (SettingsManageFindOtherServiceUI.c(SettingsManageFindOtherServiceUI.this)) {
                        SettingsManageFindOtherServiceUI.d(SettingsManageFindOtherServiceUI.this).postDelayed(new Runnable()
                        {
                          public final void run()
                          {
                            AppMethodBeat.i(298998);
                            com.tencent.mm.plugin.setting.ui.b.a.jI(SettingsManageFindOtherServiceUI.this);
                            AppMethodBeat.o(298998);
                          }
                        }, SettingsManageFindOtherServiceUI.cdH());
                      }
                      AppMethodBeat.o(298817);
                    }
                  });
                }
                AppMethodBeat.o(299085);
              }
            }, false);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageFindOtherServiceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(298692);
            return;
            com.tencent.mm.plugin.setting.ui.b.a.a(SettingsManageFindOtherServiceUI.this, 2, l2, l1, new a.a()
            {
              public final void b(boolean paramAnonymous2Boolean, app paramAnonymous2app)
              {
                AppMethodBeat.i(299077);
                if ((paramAnonymous2app == null) || (!paramAnonymous2Boolean))
                {
                  Log.i("MicroMsg.SettingsManageFindMoreUI", "doSave. response = no");
                  SettingsManageFindOtherServiceUI.this.finish();
                  AppMethodBeat.o(299077);
                  return;
                }
                Log.i("MicroMsg.SettingsManageFindMoreUI", "doSave. response = yes");
                SettingsManageFindOtherServiceUI.b(SettingsManageFindOtherServiceUI.this);
                AppMethodBeat.o(299077);
              }
            });
          }
        }
      });
      gVN();
      gVM();
      gVL();
      getPreferenceScreen().notifyDataSetChanged();
      setActionbarColor(getContext().getResources().getColor(b.c.white_color));
      hideActionbarLine();
      setMMTitle("");
      this.mController.setStatusBarColor(getResources().getColor(b.c.white_color));
      AppMethodBeat.o(299435);
      return;
      localArrayList1.add("https://" + WeChatHosts.domainString(b.i.host_help_wechat_com) + "/cgi-bin/micromsg-bin/oshelpcenter?opcode=2&lang=en&plat=android&pid=1003432&id=180323j2ynmi180323afvrzj&Channel=helpcenter");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(299415);
    super.onCreate(paramBundle);
    AppMethodBeat.o(299415);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(299427);
    if (!(paramPreference instanceof CheckBoxPreference))
    {
      AppMethodBeat.o(299427);
      return true;
    }
    paramf = (CheckBoxPreference)paramPreference;
    paramPreference = paramPreference.mKey;
    Log.i("MicroMsg.SettingsManageFindMoreUI", "click pref key %s", new Object[] { paramPreference });
    int i = -1;
    if (paramPreference.equals("settings_search_switch"))
    {
      if (!WeChatBrands.Business.Entries.MeSetDiscoverySearch.checkAvailable(this))
      {
        AppMethodBeat.o(299427);
        return true;
      }
      i = PtU;
      a(paramf, paramf.isChecked(), true);
      if (!paramf.isChecked()) {
        break label197;
      }
    }
    label197:
    for (int j = 1;; j = 0)
    {
      if (i >= 0) {
        this.PtH.put(Integer.valueOf(i), Integer.valueOf(j));
      }
      AppMethodBeat.o(299427);
      return true;
      if (paramPreference.equals("settings_look_switch"))
      {
        if (!WeChatBrands.Business.Entries.MeSetDiscoveryLooks.checkAvailable(this))
        {
          AppMethodBeat.o(299427);
          return true;
        }
        i = PtV;
        break;
      }
      if (!paramPreference.equals("settings_finder_switch")) {
        break;
      }
      if (!WeChatBrands.Business.Entries.MeSetDiscoveryChannels.checkAvailable(this))
      {
        AppMethodBeat.o(299427);
        return true;
      }
      i = PtW;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void sK(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindOtherServiceUI
 * JD-Core Version:    0.7.0.1
 */