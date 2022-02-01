package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WcPayRealnameVerifySuccessUI
  extends WalletBaseUI
{
  private Button Bsk;
  private Button Bsl;
  private ImageView kgj;
  private TextView lfN;
  private TextView lgw;
  
  public int getLayoutId()
  {
    return 2131496068;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70137);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131099653));
    hideActionbarLine();
    showHomeBtn(false);
    setMMTitle("");
    this.lfN = ((TextView)findViewById(2131307091));
    this.lgw = ((TextView)findViewById(2131307090));
    this.kgj = ((ImageView)findViewById(2131307092));
    this.Bsk = ((Button)findViewById(2131307088));
    this.Bsl = ((Button)findViewById(2131307089));
    if (getInput().getInt("realname_verify_process_finish_err_jump") == 1)
    {
      this.Bsk.setVisibility(0);
      this.Bsl.setVisibility(0);
      this.kgj.setImageDrawable(am.k(getContext(), 2131690567, getResources().getColor(2131099804)));
      paramBundle = getInput().getString("realname_verify_process_finish_page");
      if (!bs.isNullOrNil(paramBundle)) {
        this.Bsk.setText(paramBundle);
      }
      this.Bsl.setText(2131755691);
      this.Bsk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70134);
          a.t(WcPayRealnameVerifySuccessUI.this.getContext(), 1);
          AppMethodBeat.o(70134);
        }
      });
      this.Bsl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70135);
          a.b(WcPayRealnameVerifySuccessUI.this.getContext(), WcPayRealnameVerifySuccessUI.this.getInput(), 0);
          AppMethodBeat.o(70135);
        }
      });
    }
    for (;;)
    {
      paramBundle = getInput().getString("realname_verify_process_finish_title");
      String str = getInput().getString("realname_verify_process_finish_desc");
      if (!bs.isNullOrNil(paramBundle)) {
        this.lfN.setText(paramBundle);
      }
      if (!bs.isNullOrNil(str))
      {
        this.lgw.setText(str);
        this.lgw.setVisibility(0);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(70133);
          a.b(WcPayRealnameVerifySuccessUI.this.getContext(), WcPayRealnameVerifySuccessUI.this.getInput(), 0);
          AppMethodBeat.o(70133);
          return false;
        }
      });
      AppMethodBeat.o(70137);
      return;
      this.Bsk.setVisibility(8);
      this.Bsl.setVisibility(0);
      this.kgj.setImageResource(2131691082);
      paramBundle = getInput().getString("realname_verify_process_finish_page");
      if (!bs.isNullOrNil(paramBundle)) {
        this.Bsl.setText(paramBundle);
      }
      this.Bsl.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70136);
          a.b(WcPayRealnameVerifySuccessUI.this.getContext(), WcPayRealnameVerifySuccessUI.this.getInput(), 0);
          AppMethodBeat.o(70136);
        }
      });
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifySuccessUI
 * JD-Core Version:    0.7.0.1
 */