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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WcPayRealnameVerifySuccessUI
  extends WalletBaseUI
{
  private Button HTy;
  private Button HTz;
  private TextView jVn;
  private ImageView lIM;
  private TextView mPa;
  
  public int getLayoutId()
  {
    return 2131497048;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70137);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131099653));
    hideActionbarLine();
    showHomeBtn(false);
    setMMTitle("");
    this.mPa = ((TextView)findViewById(2131310615));
    this.jVn = ((TextView)findViewById(2131310614));
    this.lIM = ((ImageView)findViewById(2131310616));
    this.HTy = ((Button)findViewById(2131310612));
    this.HTz = ((Button)findViewById(2131310613));
    if (getInput().getInt("realname_verify_process_finish_err_jump") == 1)
    {
      this.HTy.setVisibility(0);
      this.HTz.setVisibility(0);
      this.lIM.setImageDrawable(ar.m(getContext(), 2131690796, getResources().getColor(2131099819)));
      paramBundle = getInput().getString("realname_verify_process_finish_page");
      if (!Util.isNullOrNil(paramBundle)) {
        this.HTy.setText(paramBundle);
      }
      this.HTz.setText(2131755761);
      this.HTy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70134);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.wallet_core.a.s(WcPayRealnameVerifySuccessUI.this.getContext(), 1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70134);
        }
      });
      this.HTz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70135);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.wallet_core.a.c(WcPayRealnameVerifySuccessUI.this.getContext(), WcPayRealnameVerifySuccessUI.this.getInput(), 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70135);
        }
      });
    }
    for (;;)
    {
      paramBundle = getInput().getString("realname_verify_process_finish_title");
      String str = getInput().getString("realname_verify_process_finish_desc");
      if (!Util.isNullOrNil(paramBundle)) {
        this.mPa.setText(paramBundle);
      }
      if (!Util.isNullOrNil(str))
      {
        this.jVn.setText(str);
        this.jVn.setVisibility(0);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(70133);
          com.tencent.mm.wallet_core.a.c(WcPayRealnameVerifySuccessUI.this.getContext(), WcPayRealnameVerifySuccessUI.this.getInput(), 0);
          AppMethodBeat.o(70133);
          return false;
        }
      });
      AppMethodBeat.o(70137);
      return;
      this.HTy.setVisibility(8);
      this.HTz.setVisibility(0);
      this.lIM.setImageResource(2131691384);
      paramBundle = getInput().getString("realname_verify_process_finish_page");
      if (!Util.isNullOrNil(paramBundle)) {
        this.HTz.setText(paramBundle);
      }
      this.HTz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70136);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.wallet_core.a.c(WcPayRealnameVerifySuccessUI.this.getContext(), WcPayRealnameVerifySuccessUI.this.getInput(), 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70136);
        }
      });
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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