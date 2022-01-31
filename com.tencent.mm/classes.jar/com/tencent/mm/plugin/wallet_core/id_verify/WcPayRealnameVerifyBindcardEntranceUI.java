package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WcPayRealnameVerifyBindcardEntranceUI
  extends WalletBaseUI
{
  private Button udh;
  private Button udi;
  
  public int getLayoutId()
  {
    return 2130971284;
  }
  
  public void initView()
  {
    AppMethodBeat.i(142414);
    this.udh = ((Button)findViewById(2131829493));
    this.udi = ((Button)findViewById(2131829494));
    this.udh.setOnClickListener(new WcPayRealnameVerifyBindcardEntranceUI.1(this));
    this.udi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142412);
        boolean bool = WcPayRealnameVerifyBindcardEntranceUI.this.getInput().getBoolean("realname_verify_process_need_face", false);
        ab.i("MicroMsg.WcPayRealnameVerifyBindcardEntranceUI", "need face : %s", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          WcPayRealnameVerifyBindcardEntranceUI.a(WcPayRealnameVerifyBindcardEntranceUI.this);
          AppMethodBeat.o(142412);
          return;
        }
        WcPayRealnameVerifyBindcardEntranceUI.this.getInput().putBoolean("realname_verify_process_do_bind", false);
        a.j(WcPayRealnameVerifyBindcardEntranceUI.this.getContext(), WcPayRealnameVerifyBindcardEntranceUI.this.getInput());
        AppMethodBeat.o(142412);
      }
    });
    AppMethodBeat.o(142414);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(142415);
    ab.i("MicroMsg.WcPayRealnameVerifyBindcardEntranceUI", "onActivityResult: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 1)
    {
      if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = paramIntent.getExtras().getString("token");
        getInput().putString("realname_verify_process_face_token", paramIntent);
        getProcess().a(this, 0, getInput());
        AppMethodBeat.o(142415);
      }
    }
    else {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(142415);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(142413);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131690709));
    hideActionbarLine();
    setMMTitle("");
    initView();
    AppMethodBeat.o(142413);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyBindcardEntranceUI
 * JD-Core Version:    0.7.0.1
 */