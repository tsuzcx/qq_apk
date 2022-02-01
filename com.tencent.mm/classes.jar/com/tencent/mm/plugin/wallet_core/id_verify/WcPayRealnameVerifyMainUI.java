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
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;
import org.apache.commons.a.a;
import org.json.JSONException;
import org.json.JSONObject;

public class WcPayRealnameVerifyMainUI
  extends WalletBaseUI
{
  private boolean Bov;
  private TextView Bsf;
  private ViewGroup Bsg;
  private u Bsh;
  private TextView lgw;
  private Button sjx;
  
  public WcPayRealnameVerifyMainUI()
  {
    AppMethodBeat.i(70125);
    this.Bsh = new u();
    AppMethodBeat.o(70125);
  }
  
  private static JSONObject eqM()
  {
    AppMethodBeat.i(70131);
    com.tencent.mm.kernel.g.agS();
    Object localObject = com.tencent.mm.kernel.g.agR().agA().get(ah.a.GIz, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      if (!bs.isNullOrNil((String)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          long l1 = System.currentTimeMillis() / 1000L;
          long l2 = ((JSONObject)localObject).getLong("timestamp");
          long l3 = ((JSONObject)localObject).getLong("cache_time");
          ac.i("MicroMsg.WcPayRealnameVerifyMainUI", " dddd time=" + l1 + ";timestamp=" + l2 + ";cachetime=" + l3);
          if (l1 - l2 > l3)
          {
            ac.e("MicroMsg.WcPayRealnameVerifyMainUI", "wording data from cache is out of date");
            AppMethodBeat.o(70131);
            return null;
          }
          AppMethodBeat.o(70131);
          return localObject;
        }
        catch (JSONException localJSONException)
        {
          ac.printErrStackTrace("MicroMsg.WcPayRealnameVerifyMainUI", localJSONException, "", new Object[0]);
          ac.e("MicroMsg.WcPayRealnameVerifyMainUI", "parse wording data form cache error");
          AppMethodBeat.o(70131);
          return null;
        }
      }
    }
    ac.i("MicroMsg.WcPayRealnameVerifyMainUI", "cache is null");
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
    this.sjx = ((Button)findViewById(2131307095));
    this.lgw = ((TextView)findViewById(2131307093));
    this.Bsf = ((TextView)findViewById(2131307094));
    this.Bsg = ((ViewGroup)findViewById(2131307259));
    this.sjx.setOnClickListener(new w()
    {
      public final void bWk()
      {
        AppMethodBeat.i(70123);
        ac.d("MicroMsg.WcPayRealnameVerifyMainUI", "click verify btn");
        WcPayRealnameVerifyMainUI.b(WcPayRealnameVerifyMainUI.this).a(new u.a()
        {
          public final void cancel()
          {
            AppMethodBeat.i(70121);
            WcPayRealnameVerifyMainUI.b(WcPayRealnameVerifyMainUI.this).daU = false;
            AppMethodBeat.o(70121);
          }
          
          public final void dbh()
          {
            AppMethodBeat.i(70120);
            WcPayRealnameVerifyMainUI.a(WcPayRealnameVerifyMainUI.this);
            AppMethodBeat.o(70120);
          }
          
          public final void dbi()
          {
            AppMethodBeat.i(70122);
            WcPayRealnameVerifyMainUI.a(WcPayRealnameVerifyMainUI.this);
            AppMethodBeat.o(70122);
          }
        }, WcPayRealnameVerifyMainUI.c(WcPayRealnameVerifyMainUI.this));
        AppMethodBeat.o(70123);
      }
    });
    JSONObject localJSONObject = eqM();
    if (localJSONObject != null)
    {
      String str = bs.bG(localJSONObject.optString("cache_header_titles", getString(2131764331)), getString(2131764331));
      this.lgw.setText(str);
      if (localJSONObject.optBoolean("isShowCapitalSecurity", false))
      {
        this.Bsf.setText(2131765532);
        this.Bsf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70124);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("wallet_lock_jsapi_scene", 2);
            com.tencent.mm.br.d.b(WcPayRealnameVerifyMainUI.this.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", paramAnonymousView);
            AppMethodBeat.o(70124);
          }
        });
        this.Bsg.setVisibility(0);
        AppMethodBeat.o(70127);
        return;
      }
      this.Bsg.setVisibility(8);
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
      this.Bsh.dbh();
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(70130);
      return;
      label35:
      this.Bsh.cancel();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70126);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131099653));
    hideActionbarLine();
    setMMTitle("");
    this.Bsh.BJI = new u.b()
    {
      public final int dbj()
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
      if (!bs.isNullOrNil(paramBundle))
      {
        paramBundle = (bcx)new bcx().parseFrom(paramBundle.getBytes(a.ISO_8859_1));
        this.Bov = paramBundle.Bov;
        if (paramBundle.ETi != null) {
          m.a(paramBundle.ETi).a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void dan() {}
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
        ac.printErrStackTrace("MicroMsg.WcPayRealnameVerifyMainUI", paramBundle, "", new Object[0]);
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(70129);
    super.onPause();
    this.Bsh.onPause();
    AppMethodBeat.o(70129);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70128);
    super.onResume();
    this.Bsh.onResume();
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