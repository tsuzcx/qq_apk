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
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class AddAppUI
  extends MMPreference
  implements com.tencent.mm.ak.g
{
  private f screen;
  private AppPreference zSv;
  private AppPreference zSw;
  
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
    this.zSv = ((AppPreference)this.screen.aPN("addapp_added"));
    this.zSv.zSz = 1;
    this.zSv.zSC = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29112);
        paramAnonymousAdapterView = AddAppUI.a(AddAppUI.this).Ra(paramAnonymousInt);
        AddAppUI.a(AddAppUI.this, paramAnonymousAdapterView.field_appId);
        AppMethodBeat.o(29112);
      }
    };
    this.zSv.zSD = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29113);
        AddAppUI.h(AddAppUI.a(AddAppUI.this).Ra(paramAnonymousInt));
        AddAppUI.this.initView();
        AppMethodBeat.o(29113);
      }
    };
    this.zSw = ((AppPreference)this.screen.aPN("addapp_available"));
    this.zSw.zSz = 0;
    this.zSw.zSC = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29114);
        paramAnonymousAdapterView = AddAppUI.b(AddAppUI.this).Ra(paramAnonymousInt);
        AddAppUI.a(AddAppUI.this, paramAnonymousAdapterView.field_appId);
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
    if (this.zSv != null) {
      this.zSv.onPause();
    }
    if (this.zSw != null) {
      this.zSw.onPause();
    }
    AppMethodBeat.o(29117);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29119);
    if (paramPreference.mKey.equals("addapp_recommend"))
    {
      paramf = getContext().getSharedPreferences(ai.eUX(), 0);
      getContext();
      paramf = ab.f(paramf);
      paramf = getString(2131755165, new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.DIc), paramf, ab.eUN() });
      paramPreference = new Intent();
      paramPreference.putExtra("rawUrl", paramf);
      com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
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
    if (this.zSv != null) {
      this.zSv.onResume();
    }
    if (this.zSw != null) {
      this.zSw.onResume();
    }
    AppMethodBeat.o(29116);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(29120);
    ac.d("MicroMsg.AddAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      AppMethodBeat.o(29120);
      return;
    }
    ac.e("MicroMsg.AddAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
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