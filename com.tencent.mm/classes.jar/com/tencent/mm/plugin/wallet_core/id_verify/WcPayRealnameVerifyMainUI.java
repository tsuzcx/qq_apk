package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;
import org.apache.commons.a.a;
import org.json.JSONException;
import org.json.JSONObject;

public class WcPayRealnameVerifyMainUI
  extends WalletBaseUI
{
  private TextView kFd;
  private Button rbd;
  private boolean zWb;
  private TextView zZL;
  private ViewGroup zZM;
  private u zZN;
  
  public WcPayRealnameVerifyMainUI()
  {
    AppMethodBeat.i(70125);
    this.zZN = new u();
    AppMethodBeat.o(70125);
  }
  
  private static JSONObject ebq()
  {
    AppMethodBeat.i(70131);
    com.tencent.mm.kernel.g.afC();
    Object localObject = com.tencent.mm.kernel.g.afB().afk().get(ae.a.FkK, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      if (!bt.isNullOrNil((String)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          long l1 = System.currentTimeMillis() / 1000L;
          long l2 = ((JSONObject)localObject).getLong("timestamp");
          long l3 = ((JSONObject)localObject).getLong("cache_time");
          ad.i("MicroMsg.WcPayRealnameVerifyMainUI", " dddd time=" + l1 + ";timestamp=" + l2 + ";cachetime=" + l3);
          if (l1 - l2 > l3)
          {
            ad.e("MicroMsg.WcPayRealnameVerifyMainUI", "wording data from cache is out of date");
            AppMethodBeat.o(70131);
            return null;
          }
          AppMethodBeat.o(70131);
          return localObject;
        }
        catch (JSONException localJSONException)
        {
          ad.printErrStackTrace("MicroMsg.WcPayRealnameVerifyMainUI", localJSONException, "", new Object[0]);
          ad.e("MicroMsg.WcPayRealnameVerifyMainUI", "parse wording data form cache error");
          AppMethodBeat.o(70131);
          return null;
        }
      }
    }
    ad.i("MicroMsg.WcPayRealnameVerifyMainUI", "cache is null");
    AppMethodBeat.o(70131);
    return null;
  }
  
  public int getLayoutId()
  {
    return 2131496067;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70127);
    this.rbd = ((Button)findViewById(2131307095));
    this.kFd = ((TextView)findViewById(2131307093));
    this.zZL = ((TextView)findViewById(2131307094));
    this.zZM = ((ViewGroup)findViewById(2131307259));
    this.rbd.setOnClickListener(new v()
    {
      public final void bOU()
      {
        AppMethodBeat.i(70123);
        ad.d("MicroMsg.WcPayRealnameVerifyMainUI", "click verify btn");
        WcPayRealnameVerifyMainUI.b(WcPayRealnameVerifyMainUI.this).a(new u.a()
        {
          public final void cNA()
          {
            AppMethodBeat.i(70120);
            WcPayRealnameVerifyMainUI.a(WcPayRealnameVerifyMainUI.this);
            AppMethodBeat.o(70120);
          }
          
          public final void cNB()
          {
            AppMethodBeat.i(70122);
            WcPayRealnameVerifyMainUI.a(WcPayRealnameVerifyMainUI.this);
            AppMethodBeat.o(70122);
          }
          
          public final void cancel()
          {
            AppMethodBeat.i(70121);
            WcPayRealnameVerifyMainUI.b(WcPayRealnameVerifyMainUI.this).ddw = false;
            AppMethodBeat.o(70121);
          }
        }, WcPayRealnameVerifyMainUI.c(WcPayRealnameVerifyMainUI.this));
        AppMethodBeat.o(70123);
      }
    });
    JSONObject localJSONObject = ebq();
    if (localJSONObject != null)
    {
      String str = bt.by(localJSONObject.optString("cache_header_titles", getString(2131764331)), getString(2131764331));
      this.kFd.setText(str);
      if (localJSONObject.optBoolean("isShowCapitalSecurity", false))
      {
        this.zZL.setText(2131765532);
        this.zZL.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70124);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("wallet_lock_jsapi_scene", 2);
            com.tencent.mm.bs.d.b(WcPayRealnameVerifyMainUI.this.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", paramAnonymousView);
            AppMethodBeat.o(70124);
          }
        });
        this.zZM.setVisibility(0);
        AppMethodBeat.o(70127);
        return;
      }
      this.zZM.setVisibility(8);
    }
    AppMethodBeat.o(70127);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70130);
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {
        break label35;
      }
      this.zZN.cNA();
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(70130);
      return;
      label35:
      this.zZN.cancel();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70126);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131099653));
    hideActionbarLine();
    setMMTitle("");
    this.zZN.Aro = new u.b()
    {
      public final int cNC()
      {
        return 1;
      }
      
      public final Context getContext()
      {
        AppMethodBeat.i(70118);
        AppCompatActivity localAppCompatActivity = WcPayRealnameVerifyMainUI.this.getContext();
        AppMethodBeat.o(70118);
        return localAppCompatActivity;
      }
    };
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(70119);
        paramAnonymousMenuItem = WcPayRealnameVerifyMainUI.this.getProcess();
        if (paramAnonymousMenuItem != null)
        {
          paramAnonymousMenuItem.g(WcPayRealnameVerifyMainUI.this.getContext(), 0);
          AppMethodBeat.o(70119);
          return true;
        }
        WcPayRealnameVerifyMainUI.this.finish();
        AppMethodBeat.o(70119);
        return false;
      }
    });
    paramBundle = getInput().getString("realname_verify_process_get_wording_cache");
    try
    {
      if (!bt.isNullOrNil(paramBundle))
      {
        paramBundle = (azf)new azf().parseFrom(paramBundle.getBytes(a.ISO_8859_1));
        this.zWb = paramBundle.zWb;
        if (paramBundle.DxM != null) {
          m.a(paramBundle.DxM).a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void cMH() {}
          });
        }
      }
      initView();
      AppMethodBeat.o(70126);
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WcPayRealnameVerifyMainUI", paramBundle, "", new Object[0]);
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(70129);
    super.onPause();
    this.zZN.onPause();
    AppMethodBeat.o(70129);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70128);
    super.onResume();
    this.zZN.onResume();
    AppMethodBeat.o(70128);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI
 * JD-Core Version:    0.7.0.1
 */