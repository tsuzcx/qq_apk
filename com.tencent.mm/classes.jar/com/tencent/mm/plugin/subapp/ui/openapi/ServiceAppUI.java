package com.tencent.mm.plugin.subapp.ui.openapi;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.y;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ServiceAppUI
  extends MMPreference
  implements com.tencent.mm.al.g
{
  private f screen;
  private String talker;
  private List<com.tencent.mm.pluginsdk.model.app.g> yFA;
  private List<com.tencent.mm.pluginsdk.model.app.g> yFB;
  private AdapterView.OnItemClickListener yFC;
  private AdapterView.OnItemClickListener yFD;
  private ServicePreference yFw;
  private ServicePreference yFx;
  private PreferenceTitleCategory yFy;
  private PreferenceTitleCategory yFz;
  
  public ServiceAppUI()
  {
    AppMethodBeat.i(29168);
    this.yFA = new ArrayList();
    this.yFB = new ArrayList();
    AppMethodBeat.o(29168);
  }
  
  public int getResourceId()
  {
    return 2131951713;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29172);
    setMMTitle(2131763082);
    this.talker = getIntent().getStringExtra("service_app_talker_user");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29165);
        ServiceAppUI.this.finish();
        AppMethodBeat.o(29165);
        return true;
      }
    });
    this.yFA.clear();
    this.yFB.clear();
    Cursor localCursor;
    if (w.pF(this.talker))
    {
      localCursor = ap.cZQ().gv(0, 2);
      if (localCursor != null) {
        if (!localCursor.moveToFirst()) {}
      }
    }
    label510:
    for (;;)
    {
      com.tencent.mm.pluginsdk.model.app.g localg = new com.tencent.mm.pluginsdk.model.app.g();
      localg.convertFrom(localCursor);
      if (localg.field_serviceAppType == 1) {
        this.yFA.add(localg);
      }
      for (;;)
      {
        if (localCursor.moveToNext()) {
          break label510;
        }
        localCursor.close();
        ad.i("MicroMsg.ServiceAppUI", "initAppList: wxServiceList size %s, bizServiceList size %s", new Object[] { Integer.valueOf(this.yFA.size()), Integer.valueOf(this.yFB.size()) });
        if (this.yFC == null) {
          this.yFC = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29166);
              if (ServiceAppUI.a(ServiceAppUI.this) == null)
              {
                ad.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
                AppMethodBeat.o(29166);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.a(ServiceAppUI.this).OU(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ad.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
                AppMethodBeat.o(29166);
                return;
              }
              ad.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.eoB), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              AppMethodBeat.o(29166);
            }
          };
        }
        if (this.yFD == null) {
          this.yFD = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29167);
              if (ServiceAppUI.b(ServiceAppUI.this) == null)
              {
                ad.e("MicroMsg.ServiceAppUI", "biz onItemClick bizServicePref null");
                AppMethodBeat.o(29167);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.b(ServiceAppUI.this).OU(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ad.e("MicroMsg.ServiceAppUI", "biz onItemClick app is null");
                AppMethodBeat.o(29167);
                return;
              }
              ad.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.eoB), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              AppMethodBeat.o(29167);
            }
          };
        }
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        if (this.yFA.size() > 0)
        {
          this.yFw = new ServicePreference(this);
          this.yFw.whn = this.yFA;
          if (this.yFC != null) {
            this.yFw.yFo = this.yFC;
          }
          if (this.yFy == null)
          {
            this.yFy = new PreferenceTitleCategory(this);
            this.yFy.setTitle(2131766298);
          }
          this.screen.b(this.yFy);
          this.screen.b(this.yFw);
        }
        if (this.yFB.size() > 0)
        {
          this.yFx = new ServicePreference(this);
          this.yFx.whn = this.yFB;
          if (this.yFD != null) {
            this.yFx.yFo = this.yFD;
          }
          if (this.yFz == null)
          {
            this.yFz = new PreferenceTitleCategory(this);
            this.yFz.setTitle(2131756597);
          }
          this.screen.b(this.yFz);
          this.screen.b(this.yFx);
        }
        AppMethodBeat.o(29172);
        return;
        if (w.sE(this.talker))
        {
          localCursor = ap.cZQ().gv(0, 4);
          break;
        }
        localCursor = ap.cZQ().gv(0, 1);
        break;
        if (localg.field_serviceAppType == 2) {
          this.yFB.add(localg);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29169);
    super.onCreate(paramBundle);
    AppMethodBeat.o(29169);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29171);
    super.onPause();
    if (this.yFw != null) {
      this.yFw.onPause();
    }
    if (this.yFx != null) {
      this.yFx.onPause();
    }
    AppMethodBeat.o(29171);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29170);
    super.onResume();
    initView();
    if (this.yFw != null) {
      this.yFw.onResume();
    }
    if (this.yFx != null) {
      this.yFx.onResume();
    }
    AppMethodBeat.o(29170);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29173);
    ad.d("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      AppMethodBeat.o(29173);
      return;
    }
    ad.e("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(29173);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI
 * JD-Core Version:    0.7.0.1
 */