package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
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
  implements h
{
  private AppPreference SHK;
  private AppPreference SHL;
  private f screen;
  
  public int getResourceId()
  {
    return R.o.haG;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29118);
    setMMTitle(R.l.gpO);
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
    this.screen.aBe(getResourceId());
    this.SHK = ((AppPreference)this.screen.bAi("addapp_added"));
    this.SHK.SHO = 1;
    this.SHK.SHR = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29112);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = AddAppUI.a(AddAppUI.this).anJ(paramAnonymousInt);
        AddAppUI.a(AddAppUI.this, paramAnonymousAdapterView.field_appId);
        a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(29112);
      }
    };
    this.SHK.SHS = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29113);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        AddAppUI.h(AddAppUI.a(AddAppUI.this).anJ(paramAnonymousInt));
        AddAppUI.this.initView();
        a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(29113);
      }
    };
    this.SHL = ((AppPreference)this.screen.bAi("addapp_available"));
    this.SHL.SHO = 0;
    this.SHL.SHR = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29114);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/subapp/ui/openapi/AddAppUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = AddAppUI.b(AddAppUI.this).anJ(paramAnonymousInt);
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
    if (this.SHK != null) {
      this.SHK.onPause();
    }
    if (this.SHL != null) {
      this.SHL.onPause();
    }
    AppMethodBeat.o(29117);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29119);
    if (paramPreference.mKey.equals("addapp_recommend"))
    {
      paramf = LocaleUtil.loadApplicationLanguage(getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), getContext());
      paramf = getString(R.l.gpP, new Object[] { Integer.valueOf(d.Yxh), paramf, LocaleUtil.getCurrentCountryCode() });
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
    if (this.SHK != null) {
      this.SHK.onResume();
    }
    if (this.SHL != null) {
      this.SHL.onResume();
    }
    AppMethodBeat.o(29116);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
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