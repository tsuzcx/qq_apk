package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.s;

public class AddAppUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private com.tencent.mm.ui.base.preference.f dnn;
  private AppPreference pwS;
  private AppPreference pwT;
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    if (paramPreference.mKey.equals("addapp_recommend"))
    {
      paramf = this.mController.uMN.getSharedPreferences(ae.cqR(), 0);
      paramPreference = this.mController.uMN;
      paramf = x.d(paramf);
      paramf = getString(R.l.addapp_recommend_url, new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.spa), paramf, x.cqI() });
      paramPreference = new Intent();
      paramPreference.putExtra("rawUrl", paramf);
      com.tencent.mm.br.d.b(this, "webview", ".ui.tools.WebViewUI", paramPreference);
      return true;
    }
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.addapp_add_app);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AddAppUI.this.finish();
        return true;
      }
    });
    this.dnn = this.vdd;
    this.dnn.removeAll();
    this.dnn.addPreferencesFromResource(R.o.addapp_pref);
    this.pwS = ((AppPreference)this.dnn.add("addapp_added"));
    this.pwS.pwW = 1;
    this.pwS.pwZ = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = AddAppUI.a(AddAppUI.this).zn(paramAnonymousInt);
        AddAppUI.a(AddAppUI.this, paramAnonymousAdapterView.field_appId);
      }
    };
    this.pwS.pxa = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AddAppUI.f(AddAppUI.a(AddAppUI.this).zn(paramAnonymousInt));
        AddAppUI.this.initView();
      }
    };
    this.pwT = ((AppPreference)this.dnn.add("addapp_available"));
    this.pwT.pwW = 0;
    this.pwT.pwZ = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = AddAppUI.b(AddAppUI.this).zn(paramAnonymousInt);
        AddAppUI.a(AddAppUI.this, paramAnonymousAdapterView.field_appId);
      }
    };
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.pwS != null) {
      this.pwS.onPause();
    }
    if (this.pwT != null) {
      this.pwT.onPause();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    initView();
    if (this.pwS != null) {
      this.pwS.onResume();
    }
    if (this.pwT != null) {
      this.pwT.onResume();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.AddAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    y.e("MicroMsg.AddAppUI", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
  }
  
  public final int xj()
  {
    return R.o.addapp_pref;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AddAppUI
 * JD-Core Version:    0.7.0.1
 */