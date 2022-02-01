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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import java.util.ArrayList;
import java.util.List;

public class ServiceAppUI
  extends MMPreference
  implements com.tencent.mm.al.f
{
  private ServicePreference Bkp;
  private ServicePreference Bkq;
  private PreferenceTitleCategory Bkr;
  private PreferenceTitleCategory Bks;
  private List<g> Bkt;
  private List<g> Bku;
  private AdapterView.OnItemClickListener Bkv;
  private AdapterView.OnItemClickListener Bkw;
  private com.tencent.mm.ui.base.preference.f screen;
  private String talker;
  
  public ServiceAppUI()
  {
    AppMethodBeat.i(29168);
    this.Bkt = new ArrayList();
    this.Bku = new ArrayList();
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
    this.Bkt.clear();
    this.Bku.clear();
    Cursor localCursor;
    if (w.vF(this.talker))
    {
      localCursor = ao.dxQ().gU(0, 2);
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
        this.Bkt.add(localg);
      }
      for (;;)
      {
        if (localCursor.moveToNext()) {
          break label510;
        }
        localCursor.close();
        ad.i("MicroMsg.ServiceAppUI", "initAppList: wxServiceList size %s, bizServiceList size %s", new Object[] { Integer.valueOf(this.Bkt.size()), Integer.valueOf(this.Bku.size()) });
        if (this.Bkv == null) {
          this.Bkv = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29166);
              b localb = new b();
              localb.bd(paramAnonymousAdapterView);
              localb.bd(paramAnonymousView);
              localb.mr(paramAnonymousInt);
              localb.qY(paramAnonymousLong);
              a.b("com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
              if (ServiceAppUI.a(ServiceAppUI.this) == null)
              {
                ad.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29166);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.a(ServiceAppUI.this).SK(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ad.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29166);
                return;
              }
              ad.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.eHO), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(29166);
            }
          };
        }
        if (this.Bkw == null) {
          this.Bkw = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29167);
              b localb = new b();
              localb.bd(paramAnonymousAdapterView);
              localb.bd(paramAnonymousView);
              localb.mr(paramAnonymousInt);
              localb.qY(paramAnonymousLong);
              a.b("com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
              if (ServiceAppUI.b(ServiceAppUI.this) == null)
              {
                ad.e("MicroMsg.ServiceAppUI", "biz onItemClick bizServicePref null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29167);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.b(ServiceAppUI.this).SK(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ad.e("MicroMsg.ServiceAppUI", "biz onItemClick app is null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29167);
                return;
              }
              ad.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.eHO), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(29167);
            }
          };
        }
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        if (this.Bkt.size() > 0)
        {
          this.Bkp = new ServicePreference(this);
          this.Bkp.yHm = this.Bkt;
          if (this.Bkv != null) {
            this.Bkp.Bkh = this.Bkv;
          }
          if (this.Bkr == null)
          {
            this.Bkr = new PreferenceTitleCategory(this);
            this.Bkr.setTitle(2131766298);
          }
          this.screen.b(this.Bkr);
          this.screen.b(this.Bkp);
        }
        if (this.Bku.size() > 0)
        {
          this.Bkq = new ServicePreference(this);
          this.Bkq.yHm = this.Bku;
          if (this.Bkw != null) {
            this.Bkq.Bkh = this.Bkw;
          }
          if (this.Bks == null)
          {
            this.Bks = new PreferenceTitleCategory(this);
            this.Bks.setTitle(2131756597);
          }
          this.screen.b(this.Bks);
          this.screen.b(this.Bkq);
        }
        AppMethodBeat.o(29172);
        return;
        if (w.zE(this.talker))
        {
          localCursor = ao.dxQ().gU(0, 4);
          break;
        }
        localCursor = ao.dxQ().gU(0, 1);
        break;
        if (localg.field_serviceAppType == 2) {
          this.Bku.add(localg);
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
    if (this.Bkp != null) {
      this.Bkp.onPause();
    }
    if (this.Bkq != null) {
      this.Bkq.onPause();
    }
    AppMethodBeat.o(29171);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29170);
    super.onResume();
    initView();
    if (this.Bkp != null) {
      this.Bkp.onResume();
    }
    if (this.Bkq != null) {
      this.Bkq.onResume();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServiceAppUI
 * JD-Core Version:    0.7.0.1
 */