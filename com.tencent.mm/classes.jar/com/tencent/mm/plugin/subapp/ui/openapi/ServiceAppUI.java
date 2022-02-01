package com.tencent.mm.plugin.subapp.ui.openapi;

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
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.z;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ServiceAppUI
  extends MMPreference
  implements h
{
  private ServicePreference SHZ;
  private ServicePreference SIa;
  private PreferenceTitleCategory SIb;
  private PreferenceTitleCategory SIc;
  private List<g> SId;
  private List<g> SIe;
  private AdapterView.OnItemClickListener SIf;
  private AdapterView.OnItemClickListener SIg;
  private f screen;
  private String talker;
  
  public ServiceAppUI()
  {
    AppMethodBeat.i(29168);
    this.SId = new ArrayList();
    this.SIe = new ArrayList();
    AppMethodBeat.o(29168);
  }
  
  public int getResourceId()
  {
    return R.o.hbp;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29172);
    setMMTitle(R.l.gUX);
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
    this.SId.clear();
    this.SIe.clear();
    Cursor localCursor;
    if (au.bwE(this.talker))
    {
      localCursor = as.gxn().kr(0, 2);
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
        this.SId.add(localg);
      }
      for (;;)
      {
        if (localCursor.moveToNext()) {
          break label510;
        }
        localCursor.close();
        Log.i("MicroMsg.ServiceAppUI", "initAppList: wxServiceList size %s, bizServiceList size %s", new Object[] { Integer.valueOf(this.SId.size()), Integer.valueOf(this.SIe.size()) });
        if (this.SIf == null) {
          this.SIf = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29166);
              b localb = new b();
              localb.cH(paramAnonymousAdapterView);
              localb.cH(paramAnonymousView);
              localb.sc(paramAnonymousInt);
              localb.hB(paramAnonymousLong);
              a.c("com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
              if (ServiceAppUI.a(ServiceAppUI.this) == null)
              {
                Log.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29166);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.a(ServiceAppUI.this).anJ(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                Log.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29166);
                return;
              }
              Log.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.jOL), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(29166);
            }
          };
        }
        if (this.SIg == null) {
          this.SIg = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29167);
              b localb = new b();
              localb.cH(paramAnonymousAdapterView);
              localb.cH(paramAnonymousView);
              localb.sc(paramAnonymousInt);
              localb.hB(paramAnonymousLong);
              a.c("com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
              if (ServiceAppUI.b(ServiceAppUI.this) == null)
              {
                Log.e("MicroMsg.ServiceAppUI", "biz onItemClick bizServicePref null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29167);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.b(ServiceAppUI.this).anJ(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                Log.e("MicroMsg.ServiceAppUI", "biz onItemClick app is null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29167);
                return;
              }
              Log.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.jOL), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(29167);
            }
          };
        }
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        if (this.SId.size() > 0)
        {
          this.SHZ = new ServicePreference(this);
          this.SHZ.PtA = this.SId;
          if (this.SIf != null) {
            this.SHZ.SHR = this.SIf;
          }
          if (this.SIb == null)
          {
            this.SIb = new PreferenceTitleCategory(this);
            this.SIb.setTitle(R.l.gZq);
          }
          this.screen.c(this.SIb);
          this.screen.c(this.SHZ);
        }
        if (this.SIe.size() > 0)
        {
          this.SIa = new ServicePreference(this);
          this.SIa.PtA = this.SIe;
          if (this.SIg != null) {
            this.SIa.SHR = this.SIg;
          }
          if (this.SIc == null)
          {
            this.SIc = new PreferenceTitleCategory(this);
            this.SIc.setTitle(R.l.gvK);
          }
          this.screen.c(this.SIc);
          this.screen.c(this.SIa);
        }
        AppMethodBeat.o(29172);
        return;
        if (ab.IS(this.talker))
        {
          localCursor = as.gxn().kr(0, 4);
          break;
        }
        localCursor = as.gxn().kr(0, 1);
        break;
        if (localg.field_serviceAppType == 2) {
          this.SIe.add(localg);
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
    if (this.SHZ != null) {
      this.SHZ.onPause();
    }
    if (this.SIa != null) {
      this.SIa.onPause();
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
    if (this.SHZ != null) {
      this.SHZ.onResume();
    }
    if (this.SIa != null) {
      this.SIa.onResume();
    }
    AppMethodBeat.o(29170);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
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