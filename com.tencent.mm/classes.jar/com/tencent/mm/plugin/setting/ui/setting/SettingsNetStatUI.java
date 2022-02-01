package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;

public class SettingsNetStatUI
  extends MMPreference
{
  private long period;
  private f screen;
  
  private void dRm()
  {
    AppMethodBeat.i(74284);
    Object localObject2 = q.aMn().qf((int)(this.period / 86400000L));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new k();
    }
    this.period = q.aMn().aMg();
    this.screen.aXe("settings_netstat_info").setTitle(getString(2131763460, new Object[] { DateFormat.format(getString(2131759517, new Object[] { "" }), this.period).toString() }));
    localObject2 = this.screen.aXe("settings_netstat_mobile");
    ae.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic mobile out:%d in:%d", new Object[] { Long.valueOf(((k)localObject1).ito), Long.valueOf(((k)localObject1).itc) });
    ((Preference)localObject2).setSummary(p(this, ((k)localObject1).ito + ((k)localObject1).itc));
    ((Preference)localObject2).ade(8);
    localObject2 = this.screen.aXe("settings_netstat_wifi");
    ae.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic wifi out:%d in:%d", new Object[] { Long.valueOf(((k)localObject1).itp), Long.valueOf(((k)localObject1).itd) });
    ((Preference)localObject2).setSummary(p(this, ((k)localObject1).itp + ((k)localObject1).itd));
    ((Preference)localObject2).ade(8);
    ((NetStatPreference)this.screen.aXe("settings_netstat_mobile_detail")).yUm = false;
    ((NetStatPreference)this.screen.aXe("settings_netstat_wifi_detail")).yUm = true;
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(74284);
  }
  
  private static String p(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(74285);
    paramContext = paramContext.getString(2131763459, new Object[] { bu.sL(paramLong) });
    AppMethodBeat.o(74285);
    return paramContext;
  }
  
  public boolean autoRefresh()
  {
    return false;
  }
  
  public int getResourceId()
  {
    return 2131951729;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74283);
    setMMTitle(2131763462);
    Object localObject1 = q.aMn();
    int i = (int)(bu.fpI() / 86400000L);
    if (((m)localObject1).qe(i) == null)
    {
      localObject2 = new k();
      ((k)localObject2).isT = i;
      ((k)localObject2).id = -1;
      ((m)localObject1).b((k)localObject2);
    }
    this.screen = getPreferenceScreen();
    this.period = q.aMn().aMg();
    localObject1 = this.screen.aXe("settings_netstat_info");
    Object localObject2 = new SimpleDateFormat(getString(2131759517), Locale.US).format(new Date(this.period));
    ((Preference)localObject1).setTitle(getString(2131763460, new Object[] { localObject2 }));
    ae.i("MicroMsg.SettingsNetStatUI", "title datatime = ".concat(String.valueOf(localObject2)));
    ae.d("MicroMsg.SettingsNetStatUI", "title datatime = ".concat(String.valueOf(localObject2)));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74278);
        SettingsNetStatUI.this.hideVKB();
        SettingsNetStatUI.this.finish();
        AppMethodBeat.o(74278);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131763463), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74279);
        SettingsNetStatUI.a(SettingsNetStatUI.this);
        AppMethodBeat.o(74279);
        return true;
      }
    });
    AppMethodBeat.o(74283);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74281);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(74281);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74282);
    super.onResume();
    dRm();
    AppMethodBeat.o(74282);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI
 * JD-Core Version:    0.7.0.1
 */