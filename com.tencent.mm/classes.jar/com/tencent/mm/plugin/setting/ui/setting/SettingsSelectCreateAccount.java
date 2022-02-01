package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.au.b;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.account.sdk.c.a;
import com.tencent.mm.plugin.account.ui.RegAffiliateAccountUI;
import com.tencent.mm.plugin.account.ui.r.c;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.protocal.protobuf.egk;
import com.tencent.mm.protocal.protobuf.egl;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SummaryBelowPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.w;
import java.io.IOException;
import java.util.Map;

public class SettingsSelectCreateAccount
  extends MMPreference
{
  private String qex = null;
  private String qey = null;
  private w tipDialog;
  
  public View getBottomView()
  {
    AppMethodBeat.i(299286);
    LinearLayout localLinearLayout = (LinearLayout)af.mU(getContext()).inflate(b.g.setting_register_select_footer, null);
    localLinearLayout.findViewById(b.f.settings_register_select_ui_help).setOnClickListener(new SettingsSelectCreateAccount.1(this));
    AppMethodBeat.o(299286);
    return localLinearLayout;
  }
  
  public int getHeaderResourceId()
  {
    return b.g.setting_register_select_header;
  }
  
  public int getResourceId()
  {
    return b.g.settings_select_create_account;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(299312);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 702)
    {
      if (paramIntent != null)
      {
        paramIntent = (Map)paramIntent.getBundleExtra("result_data").getSerializable("next_params");
        if (paramIntent != null) {
          this.qex = ((String)paramIntent.get("ticket"));
        }
        if (this.qex != null)
        {
          a.b(this, getString(r.j.license_read_url, new Object[] { LocaleUtil.getApplicationLanguage(), b.bJ("CN", getString(r.j.country_code)), "reg", Integer.valueOf(1), Integer.valueOf(0) }), 703, false);
          h.OAn.b(23530, new Object[] { this.qey, q.aPg(), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1002), Integer.valueOf(0) });
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
      {
        this.tipDialog.dismiss();
        AppMethodBeat.o(299312);
      }
    }
    else if (paramInt1 == 703)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getBundleExtra("result_data");
        if ((paramIntent != null) && (paramIntent.getString("go_next", "").equals("agree_privacy")))
        {
          paramIntent = new Intent(this, RegAffiliateAccountUI.class);
          paramIntent.putExtra("RegTicket", this.qex);
          paramIntent.putExtra("sessionID", this.qey);
          startActivityForResult(paramIntent, 704);
        }
      }
      if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
      {
        this.tipDialog.dismiss();
        AppMethodBeat.o(299312);
      }
    }
    else if (paramInt1 == 704)
    {
      if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
        this.tipDialog.dismiss();
      }
      setResult(paramInt2, paramIntent);
      finish();
    }
    AppMethodBeat.o(299312);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(299296);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(r.c.BG_2));
    setBackGroundColorResource(r.c.white);
    setBackGroundColorResource(b.c.white);
    if (getListView() != null)
    {
      int i = getContext().getResources().getDimensionPixelSize(b.d.Edge_3A);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getResources().getColor(b.c.white));
    }
    this.qey = System.currentTimeMillis();
    h.OAn.b(23530, new Object[] { this.qey, q.aPg(), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1001), Integer.valueOf(0) });
    setBackBtn(new SettingsSelectCreateAccount.2(this));
    ((SummaryBelowPreference)getPreferenceScreen().bAi("register_by_phone")).aeai = true;
    paramBundle = (SummaryBelowPreference)getPreferenceScreen().bAi("register_by_weixin");
    paramBundle.aeai = true;
    paramBundle.aS(getString(b.i.settings_register_by_weixin_hint, new Object[] { com.tencent.mm.model.z.bAO() }));
    AppMethodBeat.o(299296);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    int j = -1;
    AppMethodBeat.i(299307);
    paramf = paramPreference.mKey;
    if ("register_by_phone".equals(paramf))
    {
      h.OAn.b(23530, new Object[] { this.qey, q.aPg(), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(1001), Integer.valueOf(10101) });
      setResult(1);
      finish();
    }
    while (!"register_by_weixin".equals(paramf))
    {
      AppMethodBeat.o(299307);
      return false;
    }
    h.OAn.b(23530, new Object[] { this.qey, q.aPg(), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(1001), Integer.valueOf(10102) });
    for (;;)
    {
      try
      {
        paramf = getContext();
        getString(b.i.app_tip);
        this.tipDialog = k.a(paramf, getString(b.i.app_waiting), true, null);
        paramf = new c.a();
        paramf.funcId = 5298;
        paramf.uri = "/cgi-bin/micromsg-bin/precheckaffiliatedacct";
        paramPreference = new egk();
        paramPreference.ablM = this.qey;
        byte[] arrayOfByte = d.MtP.gtE();
        if (arrayOfByte == null) {
          break label431;
        }
        i = arrayOfByte.length;
        Log.d("MicroMsg.SettingsSelectCreateAccount", "[tomys] ccd set on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
        gdd localgdd = new gdd();
        localgdd.acaX = new gol().df(arrayOfByte);
        localgdd.acbb = new gol().df(d.MtP.gtH());
        i = j;
        if (localgdd.acbb != null) {
          i = localgdd.acbb.abwJ;
        }
        Log.d("MicroMsg.SettingsSelectCreateAccount", "[debug] devtok on auto auth, len: %s", new Object[] { Integer.valueOf(i) });
        paramPreference.YKb = new gol().df(localgdd.toByteArray());
        paramf.otE = paramPreference;
        paramf.otF = new egl();
        com.tencent.mm.am.z.a(paramf.bEF(), new SettingsSelectCreateAccount.3(this));
      }
      catch (IOException paramf)
      {
        Log.printErrStackTrace("MicroMsg.SettingsSelectCreateAccount", paramf, null, new Object[0]);
      }
      break;
      label431:
      int i = -1;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectCreateAccount
 * JD-Core Version:    0.7.0.1
 */