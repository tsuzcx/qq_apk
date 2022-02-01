package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.ui.u;
import com.tencent.mm.plugin.wallet_core.ui.u.a;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;
import org.apache.commons.a.a;
import org.json.JSONException;
import org.json.JSONObject;

public class WcPayRealnameVerifyMainUI
  extends WalletBaseUI
{
  private boolean HPI;
  private TextView HTt;
  private ViewGroup HTu;
  private u HTv;
  private TextView jVn;
  private Button wEz;
  
  public WcPayRealnameVerifyMainUI()
  {
    AppMethodBeat.i(70125);
    this.HTv = new u();
    AppMethodBeat.o(70125);
  }
  
  private static JSONObject fPW()
  {
    AppMethodBeat.i(70131);
    com.tencent.mm.kernel.g.aAi();
    Object localObject = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NXq, "");
    if (localObject != null)
    {
      localObject = (String)localObject;
      if (!Util.isNullOrNil((String)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          long l1 = System.currentTimeMillis() / 1000L;
          long l2 = ((JSONObject)localObject).getLong("timestamp");
          long l3 = ((JSONObject)localObject).getLong("cache_time");
          Log.i("MicroMsg.WcPayRealnameVerifyMainUI", " dddd time=" + l1 + ";timestamp=" + l2 + ";cachetime=" + l3);
          if (l1 - l2 > l3)
          {
            Log.e("MicroMsg.WcPayRealnameVerifyMainUI", "wording data from cache is out of date");
            AppMethodBeat.o(70131);
            return null;
          }
          AppMethodBeat.o(70131);
          return localObject;
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("MicroMsg.WcPayRealnameVerifyMainUI", localJSONException, "", new Object[0]);
          Log.e("MicroMsg.WcPayRealnameVerifyMainUI", "parse wording data form cache error");
          AppMethodBeat.o(70131);
          return null;
        }
      }
    }
    Log.i("MicroMsg.WcPayRealnameVerifyMainUI", "cache is null");
    AppMethodBeat.o(70131);
    return null;
  }
  
  public int getLayoutId()
  {
    return 2131497047;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70127);
    this.wEz = ((Button)findViewById(2131310620));
    this.jVn = ((TextView)findViewById(2131310617));
    this.HTt = ((TextView)findViewById(2131310619));
    this.HTu = ((ViewGroup)findViewById(2131310618));
    this.wEz.setOnClickListener(new x()
    {
      public final void czW()
      {
        AppMethodBeat.i(70123);
        Log.d("MicroMsg.WcPayRealnameVerifyMainUI", "click verify btn");
        WcPayRealnameVerifyMainUI.b(WcPayRealnameVerifyMainUI.this).a(new u.a()
        {
          public final void cancel()
          {
            AppMethodBeat.i(70121);
            WcPayRealnameVerifyMainUI.b(WcPayRealnameVerifyMainUI.this).dEF = false;
            AppMethodBeat.o(70121);
          }
          
          public final void ehm()
          {
            AppMethodBeat.i(70120);
            WcPayRealnameVerifyMainUI.a(WcPayRealnameVerifyMainUI.this);
            AppMethodBeat.o(70120);
          }
          
          public final void ehn()
          {
            AppMethodBeat.i(70122);
            WcPayRealnameVerifyMainUI.a(WcPayRealnameVerifyMainUI.this);
            AppMethodBeat.o(70122);
          }
        }, WcPayRealnameVerifyMainUI.c(WcPayRealnameVerifyMainUI.this));
        AppMethodBeat.o(70123);
      }
    });
    JSONObject localJSONObject = fPW();
    if (localJSONObject != null)
    {
      String str = Util.nullAs(localJSONObject.optString("cache_header_titles", getString(2131766590)), getString(2131766590));
      this.jVn.setText(str);
      if (localJSONObject.optBoolean("isShowCapitalSecurity", false))
      {
        this.HTt.setText(2131767981);
        this.HTt.setOnClickListener(new WcPayRealnameVerifyMainUI.4(this));
        this.HTu.setVisibility(0);
        AppMethodBeat.o(70127);
        return;
      }
      this.HTu.setVisibility(8);
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
      this.HTv.ehm();
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(70130);
      return;
      label35:
      this.HTv.cancel();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70126);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131099653));
    hideActionbarLine();
    setMMTitle("");
    this.HTv.IkQ = new WcPayRealnameVerifyMainUI.1(this);
    setBackBtn(new WcPayRealnameVerifyMainUI.2(this));
    paramBundle = getInput().getString("realname_verify_process_get_wording_cache");
    try
    {
      if (!Util.isNullOrNil(paramBundle))
      {
        paramBundle = (btr)new btr().parseFrom(paramBundle.getBytes(a.ISO_8859_1));
        this.HPI = paramBundle.HPI;
        if (paramBundle.Maw != null) {
          m.a(paramBundle.Maw).a(this, new com.tencent.mm.wallet_core.c.g()
          {
            public final void eeY() {}
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
        Log.printErrStackTrace("MicroMsg.WcPayRealnameVerifyMainUI", paramBundle, "", new Object[0]);
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(70129);
    super.onPause();
    this.HTv.onPause();
    AppMethodBeat.o(70129);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70128);
    super.onResume();
    this.HTv.onResume();
    AppMethodBeat.o(70128);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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