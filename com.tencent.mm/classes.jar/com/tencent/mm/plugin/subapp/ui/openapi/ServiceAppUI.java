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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import java.util.ArrayList;
import java.util.List;

public class ServiceAppUI
  extends MMPreference
  implements com.tencent.mm.ak.f
{
  private ServicePreference BBO;
  private ServicePreference BBP;
  private PreferenceTitleCategory BBQ;
  private PreferenceTitleCategory BBR;
  private List<g> BBS;
  private List<g> BBT;
  private AdapterView.OnItemClickListener BBU;
  private AdapterView.OnItemClickListener BBV;
  private com.tencent.mm.ui.base.preference.f screen;
  private String talker;
  
  public ServiceAppUI()
  {
    AppMethodBeat.i(29168);
    this.BBS = new ArrayList();
    this.BBT = new ArrayList();
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
    this.BBS.clear();
    this.BBT.clear();
    Cursor localCursor;
    if (x.wb(this.talker))
    {
      localCursor = ao.dBg().gV(0, 2);
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
        this.BBS.add(localg);
      }
      for (;;)
      {
        if (localCursor.moveToNext()) {
          break label510;
        }
        localCursor.close();
        ae.i("MicroMsg.ServiceAppUI", "initAppList: wxServiceList size %s, bizServiceList size %s", new Object[] { Integer.valueOf(this.BBS.size()), Integer.valueOf(this.BBT.size()) });
        if (this.BBU == null) {
          this.BBU = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29166);
              b localb = new b();
              localb.bd(paramAnonymousAdapterView);
              localb.bd(paramAnonymousView);
              localb.mu(paramAnonymousInt);
              localb.rl(paramAnonymousLong);
              a.b("com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
              if (ServiceAppUI.a(ServiceAppUI.this) == null)
              {
                ae.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29166);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.a(ServiceAppUI.this).Tr(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ae.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29166);
                return;
              }
              ae.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.eJx), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(29166);
            }
          };
        }
        if (this.BBV == null) {
          this.BBV = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(29167);
              b localb = new b();
              localb.bd(paramAnonymousAdapterView);
              localb.bd(paramAnonymousView);
              localb.mu(paramAnonymousInt);
              localb.rl(paramAnonymousLong);
              a.b("com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
              if (ServiceAppUI.b(ServiceAppUI.this) == null)
              {
                ae.e("MicroMsg.ServiceAppUI", "biz onItemClick bizServicePref null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29167);
                return;
              }
              paramAnonymousAdapterView = ServiceAppUI.b(ServiceAppUI.this).Tr(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ae.e("MicroMsg.ServiceAppUI", "biz onItemClick app is null");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(29167);
                return;
              }
              ae.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramAnonymousAdapterView.eJx), paramAnonymousAdapterView.field_packageName, paramAnonymousAdapterView.field_appId });
              ServiceAppUI.a(ServiceAppUI.this, paramAnonymousAdapterView);
              a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServiceAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(29167);
            }
          };
        }
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        if (this.BBS.size() > 0)
        {
          this.BBO = new ServicePreference(this);
          this.BBO.yXw = this.BBS;
          if (this.BBU != null) {
            this.BBO.BBG = this.BBU;
          }
          if (this.BBQ == null)
          {
            this.BBQ = new PreferenceTitleCategory(this);
            this.BBQ.setTitle(2131766298);
          }
          this.screen.b(this.BBQ);
          this.screen.b(this.BBO);
        }
        if (this.BBT.size() > 0)
        {
          this.BBP = new ServicePreference(this);
          this.BBP.yXw = this.BBT;
          if (this.BBV != null) {
            this.BBP.BBG = this.BBV;
          }
          if (this.BBR == null)
          {
            this.BBR = new PreferenceTitleCategory(this);
            this.BBR.setTitle(2131756597);
          }
          this.screen.b(this.BBR);
          this.screen.b(this.BBP);
        }
        AppMethodBeat.o(29172);
        return;
        if (x.Ao(this.talker))
        {
          localCursor = ao.dBg().gV(0, 4);
          break;
        }
        localCursor = ao.dBg().gV(0, 1);
        break;
        if (localg.field_serviceAppType == 2) {
          this.BBT.add(localg);
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
    if (this.BBO != null) {
      this.BBO.onPause();
    }
    if (this.BBP != null) {
      this.BBP.onPause();
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
    if (this.BBO != null) {
      this.BBO.onResume();
    }
    if (this.BBP != null) {
      this.BBP.onResume();
    }
    AppMethodBeat.o(29170);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29173);
    ae.d("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      AppMethodBeat.o(29173);
      return;
    }
    ae.e("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
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