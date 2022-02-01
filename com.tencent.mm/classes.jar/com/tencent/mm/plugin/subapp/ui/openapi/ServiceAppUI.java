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
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.c.y;
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
  private ServicePreference MgC;
  private ServicePreference MgD;
  private PreferenceTitleCategory MgE;
  private PreferenceTitleCategory MgF;
  private List<g> MgG;
  private List<g> MgH;
  private AdapterView.OnItemClickListener MgI;
  private AdapterView.OnItemClickListener MgJ;
  private f screen;
  private String talker;
  
  public ServiceAppUI()
  {
    AppMethodBeat.i(29168);
    this.MgG = new ArrayList();
    this.MgH = new ArrayList();
    AppMethodBeat.o(29168);
  }
  
  public int getResourceId()
  {
    return R.o.eXO;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29172);
    setMMTitle(R.l.eSn);
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
    this.MgG.clear();
    this.MgH.clear();
    Cursor localCursor;
    if (ab.Lj(this.talker))
    {
      localCursor = ao.fmz().iL(0, 2);
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
        this.MgG.add(localg);
      }
      for (;;)
      {
        if (localCursor.moveToNext()) {
          break label510;
        }
        localCursor.close();
        Log.i("MicroMsg.ServiceAppUI", "initAppList: wxServiceList size %s, bizServiceList size %s", new Object[] { Integer.valueOf(this.MgG.size()), Integer.valueOf(this.MgH.size()) });
        if (this.MgI == null) {
          this.MgI = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29166);
              b localb = new b();
              localb.bn(paramAnonymousAdapterView);
              localb.bn(paramAnonymousView);
              localb.sg(paramAnonymousInt);
              localb.Fs(paramAnonymousLong);
              a.c("com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
              if (ServiceAppUI.a(ServiceAppUI.this) == null)
              {
                Log.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29166);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.a(ServiceAppUI.this).aiJ(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                Log.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29166);
                return;
              }
              Log.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.hrY), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(29166);
            }
          };
        }
        if (this.MgJ == null) {
          this.MgJ = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29167);
              b localb = new b();
              localb.bn(paramAnonymousAdapterView);
              localb.bn(paramAnonymousView);
              localb.sg(paramAnonymousInt);
              localb.Fs(paramAnonymousLong);
              a.c("com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
              if (ServiceAppUI.b(ServiceAppUI.this) == null)
              {
                Log.e("MicroMsg.ServiceAppUI", "biz onItemClick bizServicePref null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29167);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.b(ServiceAppUI.this).aiJ(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                Log.e("MicroMsg.ServiceAppUI", "biz onItemClick app is null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29167);
                return;
              }
              Log.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.hrY), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(29167);
            }
          };
        }
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        if (this.MgG.size() > 0)
        {
          this.MgC = new ServicePreference(this);
          this.MgC.JhO = this.MgG;
          if (this.MgI != null) {
            this.MgC.Mgu = this.MgI;
          }
          if (this.MgE == null)
          {
            this.MgE = new PreferenceTitleCategory(this);
            this.MgE.setTitle(R.l.eWd);
          }
          this.screen.b(this.MgE);
          this.screen.b(this.MgC);
        }
        if (this.MgH.size() > 0)
        {
          this.MgD = new ServicePreference(this);
          this.MgD.JhO = this.MgH;
          if (this.MgJ != null) {
            this.MgD.Mgu = this.MgJ;
          }
          if (this.MgF == null)
          {
            this.MgF = new PreferenceTitleCategory(this);
            this.MgF.setTitle(R.l.esN);
          }
          this.screen.b(this.MgF);
          this.screen.b(this.MgD);
        }
        AppMethodBeat.o(29172);
        return;
        if (ab.Qm(this.talker))
        {
          localCursor = ao.fmz().iL(0, 4);
          break;
        }
        localCursor = ao.fmz().iL(0, 1);
        break;
        if (localg.field_serviceAppType == 2) {
          this.MgH.add(localg);
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
    if (this.MgC != null) {
      this.MgC.onPause();
    }
    if (this.MgD != null) {
      this.MgD.onPause();
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
    if (this.MgC != null) {
      this.MgC.onResume();
    }
    if (this.MgD != null) {
      this.MgD.onResume();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI
 * JD-Core Version:    0.7.0.1
 */