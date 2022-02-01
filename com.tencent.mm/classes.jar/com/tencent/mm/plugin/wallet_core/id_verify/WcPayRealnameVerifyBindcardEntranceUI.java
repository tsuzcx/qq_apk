package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WcPayRealnameVerifyBindcardEntranceUI
  extends WalletBaseUI
{
  private Button VzL;
  private Button VzM;
  private TextView pJi;
  
  public int getLayoutId()
  {
    return a.g.wc_pay_realname_verify_bindcard_entrance_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70072);
    this.VzL = ((Button)findViewById(a.f.wprb_bind_btn));
    this.VzM = ((Button)findViewById(a.f.wprb_unbind_btn));
    this.pJi = ((TextView)findViewById(a.f.wprv_desc_tv));
    String str = getInput().getString("realname_verify_process_add_bank_word");
    if (!Util.isNullOrNil(str)) {
      this.pJi.setText(str);
    }
    this.VzL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70069);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyBindcardEntranceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WcPayRealnameVerifyBindcardEntranceUI.this.getInput().putBoolean("realname_verify_process_do_bind", true);
        com.tencent.mm.wallet_core.a.k(WcPayRealnameVerifyBindcardEntranceUI.this.getContext(), WcPayRealnameVerifyBindcardEntranceUI.this.getInput());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyBindcardEntranceUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70069);
      }
    });
    this.VzM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70070);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyBindcardEntranceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        boolean bool = WcPayRealnameVerifyBindcardEntranceUI.this.getInput().getBoolean("realname_verify_process_need_face", false);
        Log.i("MicroMsg.WcPayRealnameVerifyBindcardEntranceUI", "need face : %s", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          WcPayRealnameVerifyBindcardEntranceUI.a(WcPayRealnameVerifyBindcardEntranceUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifyBindcardEntranceUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70070);
          return;
          WcPayRealnameVerifyBindcardEntranceUI.this.getInput().putBoolean("realname_verify_process_do_bind", false);
          com.tencent.mm.wallet_core.a.k(WcPayRealnameVerifyBindcardEntranceUI.this.getContext(), WcPayRealnameVerifyBindcardEntranceUI.this.getInput());
        }
      }
    });
    AppMethodBeat.o(70072);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70073);
    Log.i("MicroMsg.WcPayRealnameVerifyBindcardEntranceUI", "onActivityResult: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = paramIntent.getExtras().getString("token");
        getInput().putString("realname_verify_process_face_token", paramIntent);
        getProcess().a(this, 0, getInput());
        AppMethodBeat.o(70073);
      }
    }
    else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(70073);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70071);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.BG_5));
    hideActionbarLine();
    setMMTitle("");
    initView();
    AppMethodBeat.o(70071);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyBindcardEntranceUI
 * JD-Core Version:    0.7.0.1
 */