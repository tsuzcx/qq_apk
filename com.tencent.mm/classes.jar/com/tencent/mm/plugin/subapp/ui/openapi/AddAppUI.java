package com.tencent.mm.plugin.subapp.ui.openapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class AddAppUI
  extends MMPreference
  implements com.tencent.mm.al.f
{
  private AppPreference Bka;
  private AppPreference Bkb;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getResourceId()
  {
    return 2131951620;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29118);
    setMMTitle(2131755160);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29111);
        AddAppUI.this.finish();
        AppMethodBeat.o(29111);
        return true;
      }
    });
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(getResourceId());
    this.Bka = ((AppPreference)this.screen.aVD("addapp_added"));
    this.Bka.Bke = 1;
    this.Bka.Bkh = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29112);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = AddAppUI.a(AddAppUI.this).SK(paramAnonymousInt);
        AddAppUI.a(AddAppUI.this, paramAnonymousAdapterView.field_appId);
        a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(29112);
      }
    };
    this.Bka.Bki = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29113);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        AddAppUI.h(AddAppUI.a(AddAppUI.this).SK(paramAnonymousInt));
        AddAppUI.this.initView();
        a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(29113);
      }
    };
    this.Bkb = ((AppPreference)this.screen.aVD("addapp_available"));
    this.Bkb.Bke = 0;
    this.Bkb.Bkh = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29114);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = AddAppUI.b(AddAppUI.this).SK(paramAnonymousInt);
        AddAppUI.a(AddAppUI.this, paramAnonymousAdapterView.field_appId);
        a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(29114);
      }
    };
    AppMethodBeat.o(29118);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29115);
    super.onCreate(paramBundle);
    AppMethodBeat.o(29115);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29117);
    super.onPause();
    if (this.Bka != null) {
      this.Bka.onPause();
    }
    if (this.Bkb != null) {
      this.Bkb.onPause();
    }
    AppMethodBeat.o(29117);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29119);
    if (paramPreference.mKey.equals("addapp_recommend"))
    {
      paramf = getContext().getSharedPreferences(aj.fkC(), 0);
      getContext();
      paramf = ac.f(paramf);
      paramf = getString(2131755165, new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.Fnj), paramf, ac.fkr() });
      paramPreference = new Intent();
      paramPreference.putExtra("rawUrl", paramf);
      com.tencent.mm.bs.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
      AppMethodBeat.o(29119);
      return true;
    }
    AppMethodBeat.o(29119);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(29116);
    super.onResume();
    initView();
    if (this.Bka != null) {
      this.Bka.onResume();
    }
    if (this.Bkb != null) {
      this.Bkb.onResume();
    }
    AppMethodBeat.o(29116);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29120);
    ad.d("MicroMsg.AddAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      AppMethodBeat.o(29120);
      return;
    }
    ad.e("MicroMsg.AddAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(29120);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AddAppUI
 * JD-Core Version:    0.7.0.1
 */