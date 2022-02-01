package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.remittance.model.t;
import com.tencent.mm.plugin.remittance.model.u;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.i;

public class RemittanceHKUI
  extends RemittanceBaseUI
{
  private int OrX;
  private String OrY;
  private String OrZ;
  private String Osa;
  
  public final void aUb(String paramString)
  {
    AppMethodBeat.i(68205);
    Log.d("MicroMsg.RemittanceHKUI", "do scene gen pay");
    int i = 0;
    if (this.mPayScene == 33) {
      i = 1;
    }
    doSceneProgress(new u(Math.round(this.pJk * 100.0D), this.luk, this.wPR, this.Omc, this.mDesc, this.OlK, this.OrX, i), true);
    AppMethodBeat.o(68205);
  }
  
  protected final void gMB() {}
  
  public final void gMs()
  {
    AppMethodBeat.i(68208);
    Log.d("MicroMsg.RemittanceHKUI", "do scene cancel");
    if (this.mPayScene == 33) {}
    for (int i = 1;; i = 0)
    {
      doSceneProgress(new t(this.luk, this.OlK, this.OrX, this.pJk * 100L, i), false);
      AppMethodBeat.o(68208);
      return;
    }
  }
  
  public final void gMu()
  {
    AppMethodBeat.i(68206);
    aa.makeText(getContext(), getString(a.i.remittance_os_amount_lowest_limit, new Object[] { this.OrY }), 0).show();
    AppMethodBeat.o(68206);
  }
  
  public final void gMx()
  {
    AppMethodBeat.i(68207);
    if (!Util.isNullOrNil(this.OrZ))
    {
      TextView localTextView = (TextView)findViewById(a.f.banner_tips);
      localTextView.setText(this.OrZ);
      localTextView.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(289145);
          Log.i("MicroMsg.RemittanceHKUI", "hy: on click banner");
          if (!Util.isNullOrNil(RemittanceHKUI.a(RemittanceHKUI.this))) {
            i.bC(RemittanceHKUI.this.getContext(), RemittanceHKUI.a(RemittanceHKUI.this));
          }
          AppMethodBeat.o(289145);
        }
      });
    }
    AppMethodBeat.o(68207);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68210);
    if ((paramInt1 == 4) && (paramInt2 == -1)) {
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(68210);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68203);
    super.onCreate(paramBundle);
    addSceneEndListener(1529);
    addSceneEndListener(1257);
    this.OrX = getIntent().getIntExtra("hk_currency", 0);
    this.OrY = getIntent().getStringExtra("hk_currencyuint");
    this.OrZ = getIntent().getStringExtra("hk_notice");
    this.Osa = getIntent().getStringExtra("hk_notice_url");
    this.xcz.setTitleText(this.OrY);
    this.OlT.setText(this.OrY);
    AppMethodBeat.o(68203);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68204);
    super.onDestroy();
    removeSceneEndListener(1529);
    removeSceneEndListener(1257);
    AppMethodBeat.o(68204);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(68209);
    if ((paramp instanceof u))
    {
      paramp = (u)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (!Util.isNullOrNil(paramp.Ojh))
        {
          i.a(getContext(), paramp.Ojh, false, 4);
          AppMethodBeat.o(68209);
          return;
        }
        Log.e("MicroMsg.RemittanceHKUI", "empty payurl");
        AppMethodBeat.o(68209);
        return;
      }
      com.tencent.mm.ui.base.k.c(getContext(), paramString, "", false);
      AppMethodBeat.o(68209);
      return;
    }
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramp, paramBoolean);
    AppMethodBeat.o(68209);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceHKUI
 * JD-Core Version:    0.7.0.1
 */