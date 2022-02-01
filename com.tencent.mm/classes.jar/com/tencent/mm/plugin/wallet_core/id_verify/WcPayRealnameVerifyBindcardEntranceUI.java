package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WcPayRealnameVerifyBindcardEntranceUI
  extends WalletBaseUI
{
  private Button BqG;
  private Button BqH;
  private TextView lgw;
  
  public int getLayoutId()
  {
    return 2131496063;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70072);
    this.BqG = ((Button)findViewById(2131307064));
    this.BqH = ((Button)findViewById(2131307065));
    this.lgw = ((TextView)findViewById(2131307093));
    String str = getInput().getString("realname_verify_process_add_bank_word");
    if (!bs.isNullOrNil(str)) {
      this.lgw.setText(str);
    }
    this.BqG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70069);
        WcPayRealnameVerifyBindcardEntranceUI.this.getInput().putBoolean("realname_verify_process_do_bind", true);
        a.k(WcPayRealnameVerifyBindcardEntranceUI.this.getContext(), WcPayRealnameVerifyBindcardEntranceUI.this.getInput());
        AppMethodBeat.o(70069);
      }
    });
    this.BqH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70070);
        boolean bool = WcPayRealnameVerifyBindcardEntranceUI.this.getInput().getBoolean("realname_verify_process_need_face", false);
        ac.i("MicroMsg.WcPayRealnameVerifyBindcardEntranceUI", "need face : %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          WcPayRealnameVerifyBindcardEntranceUI.a(WcPayRealnameVerifyBindcardEntranceUI.this);
          AppMethodBeat.o(70070);
          return;
        }
        WcPayRealnameVerifyBindcardEntranceUI.this.getInput().putBoolean("realname_verify_process_do_bind", false);
        a.k(WcPayRealnameVerifyBindcardEntranceUI.this.getContext(), WcPayRealnameVerifyBindcardEntranceUI.this.getInput());
        AppMethodBeat.o(70070);
      }
    });
    AppMethodBeat.o(70072);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70073);
    ac.i("MicroMsg.WcPayRealnameVerifyBindcardEntranceUI", "onActivityResult: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    setActionbarColor(getResources().getColor(2131099653));
    hideActionbarLine();
    setMMTitle("");
    initView();
    AppMethodBeat.o(70071);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyBindcardEntranceUI
 * JD-Core Version:    0.7.0.1
 */