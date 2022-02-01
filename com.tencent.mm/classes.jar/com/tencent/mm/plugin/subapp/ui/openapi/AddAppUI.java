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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AddAppUI
  extends MMPreference
  implements i
{
  private AppPreference FMl;
  private AppPreference FMm;
  private f screen;
  
  public int getResourceId()
  {
    return 2132017156;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29118);
    setMMTitle(2131755178);
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
    this.FMl = ((AppPreference)this.screen.bmg("addapp_added"));
    this.FMl.FMp = 1;
    this.FMl.FMs = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29112);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = AddAppUI.a(AddAppUI.this).abn(paramAnonymousInt);
        AddAppUI.a(AddAppUI.this, paramAnonymousAdapterView.field_appId);
        a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(29112);
      }
    };
    this.FMl.FMt = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29113);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        AddAppUI.h(AddAppUI.a(AddAppUI.this).abn(paramAnonymousInt));
        AddAppUI.this.initView();
        a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(29113);
      }
    };
    this.FMm = ((AppPreference)this.screen.bmg("addapp_available"));
    this.FMm.FMp = 0;
    this.FMm.FMs = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29114);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = AddAppUI.b(AddAppUI.this).abn(paramAnonymousInt);
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
    if (this.FMl != null) {
      this.FMl.onPause();
    }
    if (this.FMm != null) {
      this.FMm.onPause();
    }
    AppMethodBeat.o(29117);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29119);
    if (paramPreference.mKey.equals("addapp_recommend"))
    {
      paramf = LocaleUtil.loadApplicationLanguage(getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), getContext());
      paramf = getString(2131755183, new Object[] { Integer.valueOf(d.KyO), paramf, LocaleUtil.getCurrentCountryCode() });
      paramPreference = new Intent();
      paramPreference.putExtra("rawUrl", paramf);
      c.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
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
    if (this.FMl != null) {
      this.FMl.onResume();
    }
    if (this.FMm != null) {
      this.FMm.onResume();
    }
    AppMethodBeat.o(29116);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(29120);
    Log.d("MicroMsg.AddAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      AppMethodBeat.o(29120);
      return;
    }
    Log.e("MicroMsg.AddAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(29120);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AddAppUI
 * JD-Core Version:    0.7.0.1
 */