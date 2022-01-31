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
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class AddAppUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private AppPreference sYH;
  private AppPreference sYI;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public int getResourceId()
  {
    return 2131165188;
  }
  
  public void initView()
  {
    AppMethodBeat.i(25423);
    setMMTitle(2131296432);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25416);
        AddAppUI.this.finish();
        AppMethodBeat.o(25416);
        return true;
      }
    });
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(getResourceId());
    this.sYH = ((AppPreference)this.screen.atx("addapp_added"));
    this.sYH.sYL = 1;
    this.sYH.sYO = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(25417);
        paramAnonymousAdapterView = AddAppUI.a(AddAppUI.this).Gn(paramAnonymousInt);
        AddAppUI.a(AddAppUI.this, paramAnonymousAdapterView.field_appId);
        AppMethodBeat.o(25417);
      }
    };
    this.sYH.sYP = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(25418);
        AddAppUI.h(AddAppUI.a(AddAppUI.this).Gn(paramAnonymousInt));
        AddAppUI.this.initView();
        AppMethodBeat.o(25418);
      }
    };
    this.sYI = ((AppPreference)this.screen.atx("addapp_available"));
    this.sYI.sYL = 0;
    this.sYI.sYO = new AddAppUI.4(this);
    AppMethodBeat.o(25423);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25420);
    super.onCreate(paramBundle);
    AppMethodBeat.o(25420);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25422);
    super.onPause();
    if (this.sYH != null) {
      this.sYH.onPause();
    }
    if (this.sYI != null) {
      this.sYI.onPause();
    }
    AppMethodBeat.o(25422);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(25425);
    if (paramPreference.mKey.equals("addapp_recommend"))
    {
      paramf = getContext().getSharedPreferences(ah.dsP(), 0);
      getContext();
      paramf = aa.f(paramf);
      paramf = getString(2131296437, new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.whH), paramf, aa.dsF() });
      paramPreference = new Intent();
      paramPreference.putExtra("rawUrl", paramf);
      com.tencent.mm.bq.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
      AppMethodBeat.o(25425);
      return true;
    }
    AppMethodBeat.o(25425);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25421);
    super.onResume();
    initView();
    if (this.sYH != null) {
      this.sYH.onResume();
    }
    if (this.sYI != null) {
      this.sYI.onResume();
    }
    AppMethodBeat.o(25421);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(25426);
    ab.d("MicroMsg.AddAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      AppMethodBeat.o(25426);
      return;
    }
    ab.e("MicroMsg.AddAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    AppMethodBeat.o(25426);
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