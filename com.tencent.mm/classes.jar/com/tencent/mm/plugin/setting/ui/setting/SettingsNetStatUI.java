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
import com.tencent.mm.modelstat.j;
import com.tencent.mm.modelstat.l;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SettingsNetStatUI
  extends MMPreference
{
  private long JiN;
  private f screen;
  
  private void fGr()
  {
    AppMethodBeat.i(74284);
    Object localObject2 = p.bpD().wU((int)(this.JiN / 86400000L));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new j();
    }
    this.JiN = p.bpD().bpx();
    localObject2 = this.screen.byG("settings_netstat_info");
    String str = DateFormat.format(getString(b.i.fmt_longdate, new Object[] { "" }), this.JiN).toString();
    ((Preference)localObject2).setTitle(getString(b.i.settings_traffic_all_statistic, new Object[] { str }));
    localObject2 = this.screen.byG("settings_netstat_mobile");
    Log.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic mobile out:%d in:%d", new Object[] { Long.valueOf(((j)localObject1).mdQ), Long.valueOf(((j)localObject1).mdE) });
    ((Preference)localObject2).aF(r(this, ((j)localObject1).mdQ + ((j)localObject1).mdE));
    ((Preference)localObject2).auO(8);
    localObject2 = this.screen.byG("settings_netstat_wifi");
    Log.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic wifi out:%d in:%d", new Object[] { Long.valueOf(((j)localObject1).mdR), Long.valueOf(((j)localObject1).mdF) });
    ((Preference)localObject2).aF(r(this, ((j)localObject1).mdR + ((j)localObject1).mdF));
    ((Preference)localObject2).auO(8);
    ((NetStatPreference)this.screen.byG("settings_netstat_mobile_detail")).JeM = false;
    ((NetStatPreference)this.screen.byG("settings_netstat_wifi_detail")).JeM = true;
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(74284);
  }
  
  private static String r(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(74285);
    paramContext = paramContext.getString(b.i.settings_total_traffic_statistic_all, new Object[] { Util.getSizeKB(paramLong) });
    AppMethodBeat.o(74285);
    return paramContext;
  }
  
  public boolean autoRefresh()
  {
    return false;
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_netstat;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74283);
    setMMTitle(b.i.settings_traffic_statistic);
    Object localObject1 = p.bpD();
    int i = (int)(Util.currentDayInMills() / 86400000L);
    if (((l)localObject1).wT(i) == null)
    {
      localObject2 = new j();
      ((j)localObject2).mdv = i;
      ((j)localObject2).id = -1;
      ((l)localObject1).b((j)localObject2);
    }
    this.screen = getPreferenceScreen();
    this.JiN = p.bpD().bpx();
    localObject1 = this.screen.byG("settings_netstat_info");
    Object localObject2 = new SimpleDateFormat(getString(b.i.fmt_longdate), Locale.US).format(new Date(this.JiN));
    ((Preference)localObject1).setTitle(getString(b.i.settings_traffic_all_statistic, new Object[] { localObject2 }));
    Log.i("MicroMsg.SettingsNetStatUI", "title datatime = ".concat(String.valueOf(localObject2)));
    Log.d("MicroMsg.SettingsNetStatUI", "title datatime = ".concat(String.valueOf(localObject2)));
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
    addTextOptionMenu(0, getString(b.i.settings_traffic_statistic_clear), new MenuItem.OnMenuItemClickListener()
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
    fGr();
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