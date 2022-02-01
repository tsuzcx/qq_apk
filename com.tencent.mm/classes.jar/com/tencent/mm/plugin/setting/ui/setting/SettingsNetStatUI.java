package com.tencent.mm.plugin.setting.ui.setting;

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
  private long PuU;
  private f screen;
  
  private void gVW()
  {
    AppMethodBeat.i(74284);
    Object localObject2 = p.bNk().wU((int)(this.PuU / 86400000L));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new j();
    }
    this.PuU = p.bNk().bNe();
    localObject2 = this.screen.bAi("settings_netstat_info");
    String str = DateFormat.format(getString(b.i.fmt_longdate, new Object[] { "" }), this.PuU).toString();
    ((Preference)localObject2).setTitle(getString(b.i.settings_traffic_all_statistic, new Object[] { str }));
    localObject2 = this.screen.bAi("settings_netstat_mobile");
    Log.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic mobile out:%d in:%d", new Object[] { Long.valueOf(((j)localObject1).oWJ), Long.valueOf(((j)localObject1).oWx) });
    ((Preference)localObject2).aS(t(this, ((j)localObject1).oWJ + ((j)localObject1).oWx));
    ((Preference)localObject2).aBq(8);
    localObject2 = this.screen.bAi("settings_netstat_wifi");
    Log.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic wifi out:%d in:%d", new Object[] { Long.valueOf(((j)localObject1).oWK), Long.valueOf(((j)localObject1).oWy) });
    ((Preference)localObject2).aS(t(this, ((j)localObject1).oWK + ((j)localObject1).oWy));
    ((Preference)localObject2).aBq(8);
    ((NetStatPreference)this.screen.bAi("settings_netstat_mobile_detail")).Ppi = false;
    ((NetStatPreference)this.screen.bAi("settings_netstat_wifi_detail")).Ppi = true;
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(74284);
  }
  
  private static String t(Context paramContext, long paramLong)
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
    Object localObject1 = p.bNk();
    int i = (int)(Util.currentDayInMills() / 86400000L);
    if (((l)localObject1).wT(i) == null)
    {
      localObject2 = new j();
      ((j)localObject2).oWo = i;
      ((j)localObject2).id = -1;
      ((l)localObject1).b((j)localObject2);
    }
    this.screen = getPreferenceScreen();
    this.PuU = p.bNk().bNe();
    localObject1 = this.screen.bAi("settings_netstat_info");
    Object localObject2 = new SimpleDateFormat(getString(b.i.fmt_longdate), Locale.US).format(new Date(this.PuU));
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
    gVW();
    AppMethodBeat.o(74282);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI
 * JD-Core Version:    0.7.0.1
 */