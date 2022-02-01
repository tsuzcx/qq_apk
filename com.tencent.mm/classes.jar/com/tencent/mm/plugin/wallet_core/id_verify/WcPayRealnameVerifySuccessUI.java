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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WcPayRealnameVerifySuccessUI
  extends WalletBaseUI
{
  private Button Dkf;
  private Button Dkg;
  private ImageView kEm;
  private TextView lHT;
  private TextView lHk;
  
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
    this.lHk = ((TextView)findViewById(2131307091));
    this.lHT = ((TextView)findViewById(2131307090));
    this.kEm = ((ImageView)findViewById(2131307092));
    this.Dkf = ((Button)findViewById(2131307088));
    this.Dkg = ((Button)findViewById(2131307089));
    if (getInput().getInt("realname_verify_process_finish_err_jump") == 1)
    {
      this.Dkf.setVisibility(0);
      this.Dkg.setVisibility(0);
      this.kEm.setImageDrawable(ao.k(getContext(), 2131690567, getResources().getColor(2131099804)));
      paramBundle = getInput().getString("realname_verify_process_finish_page");
      if (!bu.isNullOrNil(paramBundle)) {
        this.Dkf.setText(paramBundle);
      }
      this.Dkg.setText(2131755691);
      this.Dkf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70134);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.wallet_core.a.t(WcPayRealnameVerifySuccessUI.this.getContext(), 1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70134);
        }
      });
      this.Dkg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70135);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
      if (!bu.isNullOrNil(paramBundle)) {
        this.lHk.setText(paramBundle);
      }
      if (!bu.isNullOrNil(str))
      {
        this.lHT.setText(str);
        this.lHT.setVisibility(0);
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
      this.Dkf.setVisibility(8);
      this.Dkg.setVisibility(0);
      this.kEm.setImageResource(2131691082);
      paramBundle = getInput().getString("realname_verify_process_finish_page");
      if (!bu.isNullOrNil(paramBundle)) {
        this.Dkg.setText(paramBundle);
      }
      this.Dkg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70136);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifySuccessUI
 * JD-Core Version:    0.7.0.1
 */