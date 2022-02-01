package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.model.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class RemittanceHKUI
  extends RemittanceBaseUI
{
  private int Cwu;
  private String Cwv;
  private String Cww;
  private String Cwx;
  
  public final void aMj(String paramString)
  {
    AppMethodBeat.i(68205);
    Log.d("MicroMsg.RemittanceHKUI", "do scene gen pay");
    int i = 0;
    if (this.mPayScene == 33) {
      i = 1;
    }
    doSceneProgress(new r(Math.round(this.jVp * 100.0D), this.goe, this.qnT, this.Crk, this.mDesc, this.CqS, this.Cwu, i), true);
    AppMethodBeat.o(68205);
  }
  
  public final void eNI()
  {
    AppMethodBeat.i(68208);
    Log.d("MicroMsg.RemittanceHKUI", "do scene cancel");
    if (this.mPayScene == 33) {}
    for (int i = 1;; i = 0)
    {
      doSceneProgress(new com.tencent.mm.plugin.remittance.model.q(this.goe, this.CqS, this.Cwu, this.jVp * 100L, i), false);
      AppMethodBeat.o(68208);
      return;
    }
  }
  
  public final void eNK()
  {
    AppMethodBeat.i(68206);
    u.makeText(getContext(), getString(2131764573, new Object[] { this.Cwv }), 0).show();
    AppMethodBeat.o(68206);
  }
  
  public final void eNN()
  {
    AppMethodBeat.i(68207);
    if (!Util.isNullOrNil(this.Cww))
    {
      TextView localTextView = (TextView)findViewById(2131297330);
      localTextView.setText(this.Cww);
      localTextView.setOnClickListener(new RemittanceHKUI.1(this));
    }
    AppMethodBeat.o(68207);
  }
  
  protected final void eNS() {}
  
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
    this.Cwu = getIntent().getIntExtra("hk_currency", 0);
    this.Cwv = getIntent().getStringExtra("hk_currencyuint");
    this.Cww = getIntent().getStringExtra("hk_notice");
    this.Cwx = getIntent().getStringExtra("hk_notice_url");
    this.qAh.setTitleText(this.Cwv);
    this.Crb.setText(this.Cwv);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(68209);
    if ((paramq instanceof r))
    {
      paramq = (r)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (!Util.isNullOrNil(paramq.CoO))
        {
          f.a(getContext(), paramq.CoO, false, 4);
          AppMethodBeat.o(68209);
          return;
        }
        Log.e("MicroMsg.RemittanceHKUI", "empty payurl");
        AppMethodBeat.o(68209);
        return;
      }
      h.c(getContext(), paramString, "", false);
      AppMethodBeat.o(68209);
      return;
    }
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramq, paramBoolean);
    AppMethodBeat.o(68209);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceHKUI
 * JD-Core Version:    0.7.0.1
 */