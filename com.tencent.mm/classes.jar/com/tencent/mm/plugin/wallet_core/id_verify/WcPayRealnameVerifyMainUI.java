package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.wallet_core.ui.w;
import com.tencent.mm.plugin.wallet_core.ui.w.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.ac;
import com.tencent.mm.wallet_core.model.g;
import com.tencent.mm.wallet_core.model.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;
import org.apache.commons.b.a;
import org.json.JSONException;
import org.json.JSONObject;

public class WcPayRealnameVerifyMainUI
  extends WalletBaseUI
{
  private Button HeZ;
  private TextView VBm;
  private ViewGroup VBn;
  private w VBo;
  private boolean VxE;
  private TextView pJi;
  
  public WcPayRealnameVerifyMainUI()
  {
    AppMethodBeat.i(70125);
    this.VBo = new w();
    AppMethodBeat.o(70125);
  }
  
  private static JSONObject ihQ()
  {
    AppMethodBeat.i(70131);
    h.baF();
    Object localObject = h.baE().ban().get(at.a.acMK, "");
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
    return a.g.wc_pay_realname_verify_main_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70127);
    this.HeZ = ((Button)findViewById(a.f.wprv_verify_btn));
    this.pJi = ((TextView)findViewById(a.f.wprv_desc_tv));
    this.VBm = ((TextView)findViewById(a.f.wprv_security_tv));
    this.VBn = ((ViewGroup)findViewById(a.f.wprv_security_layout));
    this.HeZ.setOnClickListener(new ac()
    {
      public final void dsb()
      {
        AppMethodBeat.i(70123);
        Log.d("MicroMsg.WcPayRealnameVerifyMainUI", "click verify btn");
        WcPayRealnameVerifyMainUI.b(WcPayRealnameVerifyMainUI.this).a(new w.a()
        {
          public final void agree()
          {
            AppMethodBeat.i(70120);
            WcPayRealnameVerifyMainUI.a(WcPayRealnameVerifyMainUI.this);
            AppMethodBeat.o(70120);
          }
          
          public final void cancel()
          {
            AppMethodBeat.i(70121);
            WcPayRealnameVerifyMainUI.b(WcPayRealnameVerifyMainUI.this).hBY = false;
            AppMethodBeat.o(70121);
          }
          
          public final void nothing()
          {
            AppMethodBeat.i(70122);
            WcPayRealnameVerifyMainUI.a(WcPayRealnameVerifyMainUI.this);
            AppMethodBeat.o(70122);
          }
        }, WcPayRealnameVerifyMainUI.c(WcPayRealnameVerifyMainUI.this));
        AppMethodBeat.o(70123);
      }
    });
    JSONObject localJSONObject = ihQ();
    if (localJSONObject != null)
    {
      String str = Util.nullAs(localJSONObject.optString("cache_header_titles", getString(a.i.switch_realname_default_tip)), getString(a.i.switch_realname_default_tip));
      this.pJi.setText(str);
      if (localJSONObject.optBoolean("isShowCapitalSecurity", false))
      {
        this.VBm.setText(a.i.wallet_offline_un_open_tip);
        this.VBn.setOnClickListener(new WcPayRealnameVerifyMainUI.4(this));
        this.VBn.setVisibility(0);
        AppMethodBeat.o(70127);
        return;
      }
      this.VBn.setVisibility(8);
    }
    AppMethodBeat.o(70127);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70130);
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1) {
        break label37;
      }
      this.VBo.agree();
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(70130);
      return;
      label37:
      this.VBo.cancel();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70126);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.BG_5));
    hideActionbarLine();
    setMMTitle("");
    this.VBo.VTP = new WcPayRealnameVerifyMainUI.1(this);
    setBackBtn(new WcPayRealnameVerifyMainUI.2(this));
    paramBundle = getInput().getString("realname_verify_process_get_wording_cache");
    try
    {
      if (!Util.isNullOrNil(paramBundle))
      {
        paramBundle = (cqs)new cqs().parseFrom(paramBundle.getBytes(a.ISO_8859_1));
        this.VxE = paramBundle.VxE;
        if (paramBundle.aaxs != null) {
          m.a(paramBundle.aaxs).a(this, new g()
          {
            public final void fWQ() {}
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
    this.VBo.onPause();
    AppMethodBeat.o(70129);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(70128);
    super.onResume();
    this.VBo.onResume();
    AppMethodBeat.o(70128);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyMainUI
 * JD-Core Version:    0.7.0.1
 */