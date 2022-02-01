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
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.y;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ServiceAppUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  private f screen;
  private String talker;
  private ServicePreference zSK;
  private ServicePreference zSL;
  private PreferenceTitleCategory zSM;
  private PreferenceTitleCategory zSN;
  private List<com.tencent.mm.pluginsdk.model.app.g> zSO;
  private List<com.tencent.mm.pluginsdk.model.app.g> zSP;
  private AdapterView.OnItemClickListener zSQ;
  private AdapterView.OnItemClickListener zSR;
  
  public ServiceAppUI()
  {
    AppMethodBeat.i(29168);
    this.zSO = new ArrayList();
    this.zSP = new ArrayList();
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
    this.zSO.clear();
    this.zSP.clear();
    Cursor localCursor;
    if (w.sQ(this.talker))
    {
      localCursor = ap.dny().gC(0, 2);
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
        this.zSO.add(localg);
      }
      for (;;)
      {
        if (localCursor.moveToNext()) {
          break label510;
        }
        localCursor.close();
        ac.i("MicroMsg.ServiceAppUI", "initAppList: wxServiceList size %s, bizServiceList size %s", new Object[] { Integer.valueOf(this.zSO.size()), Integer.valueOf(this.zSP.size()) });
        if (this.zSQ == null) {
          this.zSQ = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29166);
              if (ServiceAppUI.a(ServiceAppUI.this) == null)
              {
                ac.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
                AppMethodBeat.o(29166);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.a(ServiceAppUI.this).Ra(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ac.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
                AppMethodBeat.o(29166);
                return;
              }
              ac.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.eqF), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              AppMethodBeat.o(29166);
            }
          };
        }
        if (this.zSR == null) {
          this.zSR = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29167);
              if (ServiceAppUI.b(ServiceAppUI.this) == null)
              {
                ac.e("MicroMsg.ServiceAppUI", "biz onItemClick bizServicePref null");
                AppMethodBeat.o(29167);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.b(ServiceAppUI.this).Ra(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ac.e("MicroMsg.ServiceAppUI", "biz onItemClick app is null");
                AppMethodBeat.o(29167);
                return;
              }
              ac.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.eqF), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              AppMethodBeat.o(29167);
            }
          };
        }
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        if (this.zSO.size() > 0)
        {
          this.zSK = new ServicePreference(this);
          this.zSK.xsD = this.zSO;
          if (this.zSQ != null) {
            this.zSK.zSC = this.zSQ;
          }
          if (this.zSM == null)
          {
            this.zSM = new PreferenceTitleCategory(this);
            this.zSM.setTitle(2131766298);
          }
          this.screen.b(this.zSM);
          this.screen.b(this.zSK);
        }
        if (this.zSP.size() > 0)
        {
          this.zSL = new ServicePreference(this);
          this.zSL.xsD = this.zSP;
          if (this.zSR != null) {
            this.zSL.zSC = this.zSR;
          }
          if (this.zSN == null)
          {
            this.zSN = new PreferenceTitleCategory(this);
            this.zSN.setTitle(2131756597);
          }
          this.screen.b(this.zSN);
          this.screen.b(this.zSL);
        }
        AppMethodBeat.o(29172);
        return;
        if (w.wH(this.talker))
        {
          localCursor = ap.dny().gC(0, 4);
          break;
        }
        localCursor = ap.dny().gC(0, 1);
        break;
        if (localg.field_serviceAppType == 2) {
          this.zSP.add(localg);
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
    if (this.zSK != null) {
      this.zSK.onPause();
    }
    if (this.zSL != null) {
      this.zSL.onPause();
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
    if (this.zSK != null) {
      this.zSK.onResume();
    }
    if (this.zSL != null) {
      this.zSL.onResume();
    }
    AppMethodBeat.o(29170);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29173);
    ac.d("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      AppMethodBeat.o(29173);
      return;
    }
    ac.e("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(29173);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI
 * JD-Core Version:    0.7.0.1
 */