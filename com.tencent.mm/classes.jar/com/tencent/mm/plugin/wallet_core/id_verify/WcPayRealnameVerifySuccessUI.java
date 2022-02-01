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
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WcPayRealnameVerifySuccessUI
  extends WalletBaseUI
{
  private Button CSA;
  private Button CSz;
  private ImageView kAX;
  private TextView lCL;
  private TextView lDu;
  
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
    this.lCL = ((TextView)findViewById(2131307091));
    this.lDu = ((TextView)findViewById(2131307090));
    this.kAX = ((ImageView)findViewById(2131307092));
    this.CSz = ((Button)findViewById(2131307088));
    this.CSA = ((Button)findViewById(2131307089));
    if (getInput().getInt("realname_verify_process_finish_err_jump") == 1)
    {
      this.CSz.setVisibility(0);
      this.CSA.setVisibility(0);
      this.kAX.setImageDrawable(ao.k(getContext(), 2131690567, getResources().getColor(2131099804)));
      paramBundle = getInput().getString("realname_verify_process_finish_page");
      if (!bt.isNullOrNil(paramBundle)) {
        this.CSz.setText(paramBundle);
      }
      this.CSA.setText(2131755691);
      this.CSz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70134);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.wallet_core.a.t(WcPayRealnameVerifySuccessUI.this.getContext(), 1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70134);
        }
      });
      this.CSA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70135);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.wallet_core.a.b(WcPayRealnameVerifySuccessUI.this.getContext(), WcPayRealnameVerifySuccessUI.this.getInput(), 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70135);
        }
      });
    }
    for (;;)
    {
      paramBundle = getInput().getString("realname_verify_process_finish_title");
      String str = getInput().getString("realname_verify_process_finish_desc");
      if (!bt.isNullOrNil(paramBundle)) {
        this.lCL.setText(paramBundle);
      }
      if (!bt.isNullOrNil(str))
      {
        this.lDu.setText(str);
        this.lDu.setVisibility(0);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(70133);
          com.tencent.mm.wallet_core.a.b(WcPayRealnameVerifySuccessUI.this.getContext(), WcPayRealnameVerifySuccessUI.this.getInput(), 0);
          AppMethodBeat.o(70133);
          return false;
        }
      });
      AppMethodBeat.o(70137);
      return;
      this.CSz.setVisibility(8);
      this.CSA.setVisibility(0);
      this.kAX.setImageResource(2131691082);
      paramBundle = getInput().getString("realname_verify_process_finish_page");
      if (!bt.isNullOrNil(paramBundle)) {
        this.CSA.setText(paramBundle);
      }
      this.CSA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70136);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.wallet_core.a.b(WcPayRealnameVerifySuccessUI.this.getContext(), WcPayRealnameVerifySuccessUI.this.getInput(), 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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