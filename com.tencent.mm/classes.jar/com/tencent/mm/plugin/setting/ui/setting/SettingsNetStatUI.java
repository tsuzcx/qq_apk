package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SettingsNetStatUI
  extends MMPreference
{
  private f dnn;
  private long period;
  
  private void bzi()
  {
    Object localObject2 = q.RC().jj((int)(this.period / 86400000L));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new k();
    }
    this.period = q.RC().Rv();
    localObject2 = this.dnn.add("settings_netstat_info");
    String str = DateFormat.format(getString(a.i.fmt_longdate, new Object[] { "" }), this.period).toString();
    ((Preference)localObject2).setTitle(getString(a.i.settings_traffic_all_statistic, new Object[] { str }));
    localObject2 = this.dnn.add("settings_netstat_mobile");
    y.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic mobile out:%d in:%d", new Object[] { Integer.valueOf(((k)localObject1).eDX), Integer.valueOf(((k)localObject1).eDL) });
    ((Preference)localObject2).setSummary(j(this, ((k)localObject1).eDX + ((k)localObject1).eDL));
    localObject2 = this.dnn.add("settings_netstat_wifi");
    y.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic wifi out:%d in:%d", new Object[] { Integer.valueOf(((k)localObject1).eDY), Integer.valueOf(((k)localObject1).eDM) });
    ((Preference)localObject2).setSummary(j(this, ((k)localObject1).eDY + ((k)localObject1).eDM));
    ((NetStatPreference)this.dnn.add("settings_netstat_mobile_detail")).nRY = false;
    ((NetStatPreference)this.dnn.add("settings_netstat_wifi_detail")).nRY = true;
    this.dnn.notifyDataSetChanged();
  }
  
  private static String j(Context paramContext, long paramLong)
  {
    return paramContext.getString(a.i.settings_total_traffic_statistic_all, new Object[] { bk.cm(paramLong) });
  }
  
  protected final boolean XI()
  {
    return false;
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_traffic_statistic);
    Object localObject1 = q.RC();
    int i = (int)(bk.crW() / 86400000L);
    if (((m)localObject1).ji(i) == null)
    {
      localObject2 = new k();
      ((k)localObject2).eDC = i;
      ((k)localObject2).id = -1;
      ((m)localObject1).b((k)localObject2);
    }
    this.dnn = this.vdd;
    this.period = q.RC().Rv();
    localObject1 = this.dnn.add("settings_netstat_info");
    Object localObject2 = new SimpleDateFormat(getString(a.i.fmt_longdate), Locale.US).format(new Date(this.period));
    ((Preference)localObject1).setTitle(getString(a.i.settings_traffic_all_statistic, new Object[] { localObject2 }));
    y.i("MicroMsg.SettingsNetStatUI", "title datatime = " + (String)localObject2);
    y.d("MicroMsg.SettingsNetStatUI", "title datatime = " + (String)localObject2);
    setBackBtn(new SettingsNetStatUI.1(this));
    addTextOptionMenu(0, getString(a.i.settings_traffic_statistic_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        SettingsNetStatUI.a(SettingsNetStatUI.this);
        return true;
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onResume()
  {
    super.onResume();
    bzi();
  }
  
  public final int xj()
  {
    return a.k.settings_pref_netstat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI
 * JD-Core Version:    0.7.0.1
 */