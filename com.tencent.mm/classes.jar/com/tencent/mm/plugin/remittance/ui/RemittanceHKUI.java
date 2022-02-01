package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.model.q;
import com.tencent.mm.plugin.remittance.model.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class RemittanceHKUI
  extends RemittanceBaseUI
{
  private int wSa;
  private String wSb;
  private String wSc;
  private String wSd;
  
  public final void aru(String paramString)
  {
    AppMethodBeat.i(68205);
    ac.d("MicroMsg.RemittanceHKUI", "do scene gen pay");
    int i = 0;
    if (this.mPayScene == 33) {
      i = 1;
    }
    doSceneProgress(new r(Math.round(this.wJu * 100.0D), this.foE, this.ooX, this.wMU, this.mDesc, this.wMC, this.wSa, i), true);
    AppMethodBeat.o(68205);
  }
  
  public final void dxY()
  {
    AppMethodBeat.i(68208);
    ac.d("MicroMsg.RemittanceHKUI", "do scene cancel");
    if (this.mPayScene == 33) {}
    for (int i = 1;; i = 0)
    {
      doSceneProgress(new q(this.foE, this.wMC, this.wSa, this.wJu * 100L, i), false);
      AppMethodBeat.o(68208);
      return;
    }
  }
  
  public final void dya()
  {
    AppMethodBeat.i(68206);
    t.makeText(getContext(), getString(2131762506, new Object[] { this.wSb }), 0).show();
    AppMethodBeat.o(68206);
  }
  
  public final void dyd()
  {
    AppMethodBeat.i(68207);
    if (!bs.isNullOrNil(this.wSc))
    {
      TextView localTextView = (TextView)findViewById(2131297186);
      localTextView.setText(this.wSc);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68202);
          ac.i("MicroMsg.RemittanceHKUI", "hy: on click banner");
          if (!bs.isNullOrNil(RemittanceHKUI.a(RemittanceHKUI.this))) {
            e.aT(RemittanceHKUI.this.getContext(), RemittanceHKUI.a(RemittanceHKUI.this));
          }
          AppMethodBeat.o(68202);
        }
      });
    }
    AppMethodBeat.o(68207);
  }
  
  protected final void dyi() {}
  
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
    this.wSa = getIntent().getIntExtra("hk_currency", 0);
    this.wSb = getIntent().getStringExtra("hk_currencyuint");
    this.wSc = getIntent().getStringExtra("hk_notice");
    this.wSd = getIntent().getStringExtra("hk_notice_url");
    this.oAV.setTitleText(this.wSb);
    this.wML.setText(this.wSb);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(68209);
    if ((paramn instanceof r))
    {
      paramn = (r)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (!bs.isNullOrNil(paramn.wKz))
        {
          e.a(getContext(), paramn.wKz, false, 4);
          AppMethodBeat.o(68209);
          return;
        }
        ac.e("MicroMsg.RemittanceHKUI", "empty payurl");
        AppMethodBeat.o(68209);
        return;
      }
      h.c(getContext(), paramString, "", false);
      AppMethodBeat.o(68209);
      return;
    }
    super.onSceneEnd(paramInt1, paramInt2, paramString, paramn, paramBoolean);
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