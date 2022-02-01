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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.plugin.wallet_core.ui.u.b;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class WcPayRealnameVerifyMainUI
  extends WalletBaseUI
{
  private boolean COK;
  private TextView CSu;
  private ViewGroup CSv;
  private u CSw;
  private TextView lDu;
  private Button tfZ;
  
  public WcPayRealnameVerifyMainUI()
  {
    AppMethodBeat.i(70125);
    this.CSw = new u();
    AppMethodBeat.o(70125);
  }
  
  private static JSONObject eEM()
  {
    AppMethodBeat.i(70131);
    com.tencent.mm.kernel.g.ajD();
    Object localObject = com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IuR, "");
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
    this.tfZ = ((Button)findViewById(2131307095));
    this.lDu = ((TextView)findViewById(2131307093));
    this.CSu = ((TextView)findViewById(2131307094));
    this.CSv = ((ViewGroup)findViewById(2131307259));
    this.tfZ.setOnClickListener(new w()
    {
      public final void caN()
      {
        AppMethodBeat.i(70123);
        ad.d("MicroMsg.WcPayRealnameVerifyMainUI", "click verify btn");
        WcPayRealnameVerifyMainUI.b(WcPayRealnameVerifyMainUI.this).a(new u.a()
        {
          public final void cancel()
          {
            AppMethodBeat.i(70121);
            WcPayRealnameVerifyMainUI.b(WcPayRealnameVerifyMainUI.this).dmo = false;
            AppMethodBeat.o(70121);
          }
          
          public final void dkA()
          {
            AppMethodBeat.i(70120);
            WcPayRealnameVerifyMainUI.a(WcPayRealnameVerifyMainUI.this);
            AppMethodBeat.o(70120);
          }
          
          public final void dkB()
          {
            AppMethodBeat.i(70122);
            WcPayRealnameVerifyMainUI.a(WcPayRealnameVerifyMainUI.this);
            AppMethodBeat.o(70122);
          }
        }, WcPayRealnameVerifyMainUI.c(WcPayRealnameVerifyMainUI.this));
        AppMethodBeat.o(70123);
      }
    });
    JSONObject localJSONObject = eEM();
    if (localJSONObject != null)
    {
      String str = bt.bI(localJSONObject.optString("cache_header_titles", getString(2131764331)), getString(2131764331));
      this.lDu.setText(str);
      if (localJSONObject.optBoolean("isShowCapitalSecurity", false))
      {
        this.CSu.setText(2131765532);
        this.CSu.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(70124);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyMainUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("wallet_lock_jsapi_scene", 2);
            com.tencent.mm.bs.d.b(WcPayRealnameVerifyMainUI.this.getContext(), "wallet", ".pwd.ui.WalletSecuritySettingUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyMainUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(70124);
          }
        });
        this.CSv.setVisibility(0);
        AppMethodBeat.o(70127);
        return;
      }
      this.CSv.setVisibility(8);
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
      this.CSw.dkA();
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(70130);
      return;
      label35:
      this.CSw.cancel();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70126);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131099653));
    hideActionbarLine();
    setMMTitle("");
    this.CSw.Dka = new u.b()
    {
      public final int dkC()
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
        paramBundle = (bhd)new bhd().parseFrom(paramBundle.getBytes(org.apache.commons.a.a.ISO_8859_1));
        this.COK = paramBundle.COK;
        if (paramBundle.GCB != null) {
          m.a(paramBundle.GCB).a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void djA() {}
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
    this.CSw.onPause();
    AppMethodBeat.o(70129);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70128);
    super.onResume();
    this.CSw.onResume();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI
 * JD-Core Version:    0.7.0.1
 */