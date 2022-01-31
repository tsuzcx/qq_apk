package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SettingsNetStatUI
  extends MMPreference
{
  private long period;
  private f screen;
  
  private void cks()
  {
    AppMethodBeat.i(127347);
    Object localObject2 = q.akL().mc((int)(this.period / 86400000L));
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new k();
    }
    this.period = q.akL().akE();
    this.screen.atx("settings_netstat_info").setTitle(getString(2131303478, new Object[] { DateFormat.format(getString(2131300050, new Object[] { "" }), this.period).toString() }));
    localObject2 = this.screen.atx("settings_netstat_mobile");
    ab.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic mobile out:%d in:%d", new Object[] { Integer.valueOf(((k)localObject1).fTO), Integer.valueOf(((k)localObject1).fTC) });
    ((Preference)localObject2).setSummary(k(this, ((k)localObject1).fTO + ((k)localObject1).fTC));
    ((Preference)localObject2).OW(8);
    localObject2 = this.screen.atx("settings_netstat_wifi");
    ab.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic wifi out:%d in:%d", new Object[] { Integer.valueOf(((k)localObject1).fTP), Integer.valueOf(((k)localObject1).fTD) });
    ((Preference)localObject2).setSummary(k(this, ((k)localObject1).fTP + ((k)localObject1).fTD));
    ((Preference)localObject2).OW(8);
    ((NetStatPreference)this.screen.atx("settings_netstat_mobile_detail")).qFW = false;
    ((NetStatPreference)this.screen.atx("settings_netstat_wifi_detail")).qFW = true;
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(127347);
  }
  
  private static String k(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(127348);
    paramContext = paramContext.getString(2131303477, new Object[] { bo.hk(paramLong) });
    AppMethodBeat.o(127348);
    return paramContext;
  }
  
  public boolean autoRefresh()
  {
    return false;
  }
  
  public int getResourceId()
  {
    return 2131165285;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127346);
    setMMTitle(2131303480);
    Object localObject1 = q.akL();
    int i = (int)(bo.dtT() / 86400000L);
    if (((m)localObject1).mb(i) == null)
    {
      localObject2 = new k();
      ((k)localObject2).fTt = i;
      ((k)localObject2).id = -1;
      ((m)localObject1).b((k)localObject2);
    }
    this.screen = getPreferenceScreen();
    this.period = q.akL().akE();
    localObject1 = this.screen.atx("settings_netstat_info");
    Object localObject2 = new SimpleDateFormat(getString(2131300050), Locale.US).format(new Date(this.period));
    ((Preference)localObject1).setTitle(getString(2131303478, new Object[] { localObject2 }));
    ab.i("MicroMsg.SettingsNetStatUI", "title datatime = ".concat(String.valueOf(localObject2)));
    ab.d("MicroMsg.SettingsNetStatUI", "title datatime = ".concat(String.valueOf(localObject2)));
    setBackBtn(new SettingsNetStatUI.1(this));
    addTextOptionMenu(0, getString(2131303481), new SettingsNetStatUI.2(this));
    AppMethodBeat.o(127346);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127344);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(127344);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127345);
    super.onResume();
    cks();
    AppMethodBeat.o(127345);
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