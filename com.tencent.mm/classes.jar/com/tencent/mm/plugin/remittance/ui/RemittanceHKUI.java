package com.tencent.mm.plugin.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.remittance.model.s;
import com.tencent.mm.plugin.remittance.model.t;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.g;

public class RemittanceHKUI
  extends RemittanceBaseUI
{
  private int Iup;
  private String Iuq;
  private String Iur;
  private String Ius;
  
  public final void aWN(String paramString)
  {
    AppMethodBeat.i(68205);
    Log.d("MicroMsg.RemittanceHKUI", "do scene gen pay");
    int i = 0;
    if (this.mPayScene == 33) {
      i = 1;
    }
    doSceneProgress(new t(Math.round(this.mMC * 100.0D), this.iSn, this.tMB, this.IoJ, this.mDesc, this.Ior, this.Iup, i), true);
    AppMethodBeat.o(68205);
  }
  
  public final void fAA()
  {
    AppMethodBeat.i(68206);
    w.makeText(getContext(), getString(a.i.remittance_os_amount_lowest_limit, new Object[] { this.Iuq }), 0).show();
    AppMethodBeat.o(68206);
  }
  
  public final void fAD()
  {
    AppMethodBeat.i(68207);
    if (!Util.isNullOrNil(this.Iur))
    {
      TextView localTextView = (TextView)findViewById(a.f.banner_tips);
      localTextView.setText(this.Iur);
      localTextView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(68202);
          b localb = new b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/remittance/ui/RemittanceHKUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.RemittanceHKUI", "hy: on click banner");
          if (!Util.isNullOrNil(RemittanceHKUI.a(RemittanceHKUI.this))) {
            g.bA(RemittanceHKUI.this.getContext(), RemittanceHKUI.a(RemittanceHKUI.this));
          }
          a.a(this, "com/tencent/mm/plugin/remittance/ui/RemittanceHKUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(68202);
        }
      });
    }
    AppMethodBeat.o(68207);
  }
  
  protected final void fAH() {}
  
  public final void fAy()
  {
    AppMethodBeat.i(68208);
    Log.d("MicroMsg.RemittanceHKUI", "do scene cancel");
    if (this.mPayScene == 33) {}
    for (int i = 1;; i = 0)
    {
      doSceneProgress(new s(this.iSn, this.Ior, this.Iup, this.mMC * 100L, i), false);
      AppMethodBeat.o(68208);
      return;
    }
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
    this.Iup = getIntent().getIntExtra("hk_currency", 0);
    this.Iuq = getIntent().getStringExtra("hk_currencyuint");
    this.Iur = getIntent().getStringExtra("hk_notice");
    this.Ius = getIntent().getStringExtra("hk_notice_url");
    this.tZh.setTitleText(this.Iuq);
    this.IoA.setText(this.Iuq);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(68209);
    if ((paramq instanceof t))
    {
      paramq = (t)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (!Util.isNullOrNil(paramq.IlQ))
        {
          g.a(getContext(), paramq.IlQ, false, 4);
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