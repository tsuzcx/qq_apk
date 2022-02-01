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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.y;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ServiceAppUI
  extends MMPreference
  implements i
{
  private ServicePreference FMA;
  private ServicePreference FMB;
  private PreferenceTitleCategory FMC;
  private PreferenceTitleCategory FMD;
  private List<g> FME;
  private List<g> FMF;
  private AdapterView.OnItemClickListener FMG;
  private AdapterView.OnItemClickListener FMH;
  private f screen;
  private String talker;
  
  public ServiceAppUI()
  {
    AppMethodBeat.i(29168);
    this.FME = new ArrayList();
    this.FMF = new ArrayList();
    AppMethodBeat.o(29168);
  }
  
  public int getResourceId()
  {
    return 2132017258;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29172);
    setMMTitle(2131765242);
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
    this.FME.clear();
    this.FMF.clear();
    Cursor localCursor;
    if (ab.Eq(this.talker))
    {
      localCursor = ao.eAS().hG(0, 2);
      if (localCursor != null) {
        if (!localCursor.moveToFirst()) {}
      }
    }
    label510:
    for (;;)
    {
      g localg = new g();
      localg.convertFrom(localCursor);
      if (localg.field_serviceAppType == 1) {
        this.FME.add(localg);
      }
      for (;;)
      {
        if (localCursor.moveToNext()) {
          break label510;
        }
        localCursor.close();
        Log.i("MicroMsg.ServiceAppUI", "initAppList: wxServiceList size %s, bizServiceList size %s", new Object[] { Integer.valueOf(this.FME.size()), Integer.valueOf(this.FMF.size()) });
        if (this.FMG == null) {
          this.FMG = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29166);
              b localb = new b();
              localb.bm(paramAnonymousAdapterView);
              localb.bm(paramAnonymousView);
              localb.pH(paramAnonymousInt);
              localb.zo(paramAnonymousLong);
              a.b("com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
              if (ServiceAppUI.a(ServiceAppUI.this) == null)
              {
                Log.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29166);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.a(ServiceAppUI.this).abn(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                Log.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29166);
                return;
              }
              Log.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.fmZ), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(29166);
            }
          };
        }
        if (this.FMH == null) {
          this.FMH = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29167);
              b localb = new b();
              localb.bm(paramAnonymousAdapterView);
              localb.bm(paramAnonymousView);
              localb.pH(paramAnonymousInt);
              localb.zo(paramAnonymousLong);
              a.b("com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
              if (ServiceAppUI.b(ServiceAppUI.this) == null)
              {
                Log.e("MicroMsg.ServiceAppUI", "biz onItemClick bizServicePref null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29167);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.b(ServiceAppUI.this).abn(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                Log.e("MicroMsg.ServiceAppUI", "biz onItemClick app is null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29167);
                return;
              }
              Log.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.fmZ), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(29167);
            }
          };
        }
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        if (this.FME.size() > 0)
        {
          this.FMA = new ServicePreference(this);
          this.FMA.Dcn = this.FME;
          if (this.FMG != null) {
            this.FMA.FMs = this.FMG;
          }
          if (this.FMC == null)
          {
            this.FMC = new PreferenceTitleCategory(this);
            this.FMC.setTitle(2131768809);
          }
          this.screen.c(this.FMC);
          this.screen.c(this.FMA);
        }
        if (this.FMF.size() > 0)
        {
          this.FMB = new ServicePreference(this);
          this.FMB.Dcn = this.FMF;
          if (this.FMH != null) {
            this.FMB.FMs = this.FMH;
          }
          if (this.FMD == null)
          {
            this.FMD = new PreferenceTitleCategory(this);
            this.FMD.setTitle(2131756737);
          }
          this.screen.c(this.FMD);
          this.screen.c(this.FMB);
        }
        AppMethodBeat.o(29172);
        return;
        if (ab.IT(this.talker))
        {
          localCursor = ao.eAS().hG(0, 4);
          break;
        }
        localCursor = ao.eAS().hG(0, 1);
        break;
        if (localg.field_serviceAppType == 2) {
          this.FMF.add(localg);
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
    if (this.FMA != null) {
      this.FMA.onPause();
    }
    if (this.FMB != null) {
      this.FMB.onPause();
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
    if (this.FMA != null) {
      this.FMA.onResume();
    }
    if (this.FMB != null) {
      this.FMB.onResume();
    }
    AppMethodBeat.o(29170);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(29173);
    Log.d("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      AppMethodBeat.o(29173);
      return;
    }
    Log.e("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(29173);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI
 * JD-Core Version:    0.7.0.1
 */