package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.remittance.model.p;
import com.tencent.mm.plugin.remittance.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class RemittanceHKUI
  extends RemittanceBaseUI
{
  private int qqL;
  private String qqM;
  private String qqN;
  private String qqO;
  
  public final void Yl(String paramString)
  {
    AppMethodBeat.i(142225);
    ab.d("MicroMsg.RemittanceHKUI", "do scene gen pay");
    int i = 0;
    if (this.mPayScene == 33) {
      i = 1;
    }
    doSceneProgress(new q(Math.round(this.qlk * 100.0D), this.eaX, this.kEW, this.qlH, this.mDesc, this.qlp, this.qqL, i), true);
    AppMethodBeat.o(142225);
  }
  
  public final void chf()
  {
    AppMethodBeat.i(45079);
    ab.d("MicroMsg.RemittanceHKUI", "do scene cancel");
    if (this.mPayScene == 33) {}
    for (int i = 1;; i = 0)
    {
      doSceneProgress(new p(this.eaX, this.qlp, this.qqL, this.qlk * 100L, i), false);
      AppMethodBeat.o(45079);
      return;
    }
  }
  
  public final void chh()
  {
    AppMethodBeat.i(45077);
    t.makeText(getContext(), getString(2131302600, new Object[] { this.qqM }), 0).show();
    AppMethodBeat.o(45077);
  }
  
  public final void chk()
  {
    AppMethodBeat.i(45078);
    if (!bo.isNullOrNil(this.qqN))
    {
      TextView localTextView = (TextView)findViewById(2131821672);
      localTextView.setText(this.qqN);
      localTextView.setOnClickListener(new RemittanceHKUI.1(this));
    }
    AppMethodBeat.o(45078);
  }
  
  protected final void chp() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45081);
    if ((paramInt1 == 4) && (paramInt2 == -1)) {
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(45081);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45074);
    super.onCreate(paramBundle);
    addSceneEndListener(1529);
    addSceneEndListener(1257);
    this.qqL = getIntent().getIntExtra("hk_currency", 0);
    this.qqM = getIntent().getStringExtra("hk_currencyuint");
    this.qqN = getIntent().getStringExtra("hk_notice");
    this.qqO = getIntent().getStringExtra("hk_notice_url");
    this.kRl.setTitleText(this.qqM);
    this.qly.setText(this.qqM);
    AppMethodBeat.o(45074);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45075);
    super.onDestroy();
    removeSceneEndListener(1529);
    removeSceneEndListener(1257);
    AppMethodBeat.o(45075);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(45080);
    if ((paramm instanceof q))
    {
      paramm = (q)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (!bo.isNullOrNil(paramm.qjt))
        {
          e.a(getContext(), paramm.qjt, false, 4);
          AppMethodBeat.o(45080);
          return;
        }
        ab.e("MicroMsg.RemittanceHKUI", "empty payurl");
        AppMethodBeat.o(45080);
        return;
      }
      h.b(getContext(), paramString, "", false);
      AppMethodBeat.o(45080);
      return;
    }
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramm, paramBoolean);
    AppMethodBeat.o(45080);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceHKUI
 * JD-Core Version:    0.7.0.1
 */