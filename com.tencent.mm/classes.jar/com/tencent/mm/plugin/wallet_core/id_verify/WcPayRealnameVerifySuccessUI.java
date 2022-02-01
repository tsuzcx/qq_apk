package com.tencent.mm.plugin.wallet_core.id_verify;

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
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WcPayRealnameVerifySuccessUI
  extends WalletBaseUI
{
  private Button VBr;
  private Button VBs;
  private TextView pJi;
  private ImageView rIe;
  private TextView sUt;
  
  public int getLayoutId()
  {
    return a.g.wc_pay_realname_verify_success_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70137);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.BG_5));
    hideActionbarLine();
    showHomeBtn(false);
    setMMTitle("");
    this.sUt = ((TextView)findViewById(a.f.wprs_finish_title));
    this.pJi = ((TextView)findViewById(a.f.wprs_finish_desc));
    this.rIe = ((ImageView)findViewById(a.f.wprs_icon_iv));
    this.VBr = ((Button)findViewById(a.f.wprs_finish_btn1));
    this.VBs = ((Button)findViewById(a.f.wprs_finish_btn2));
    if (getInput().getInt("realname_verify_process_finish_err_jump") == 1)
    {
      this.VBr.setVisibility(0);
      this.VBs.setVisibility(0);
      this.rIe.setImageDrawable(bb.m(getContext(), a.h.icons_outlined_error1, getResources().getColor(a.c.Red_100)));
      paramBundle = getInput().getString("realname_verify_process_finish_page");
      if (!Util.isNullOrNil(paramBundle)) {
        this.VBr.setText(paramBundle);
      }
      this.VBs.setText(a.i.app_cancel);
      this.VBr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70134);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.wallet_core.a.v(WcPayRealnameVerifySuccessUI.this.getContext(), 1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70134);
        }
      });
      this.VBs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70135);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
      if (!Util.isNullOrNil(paramBundle)) {
        this.sUt.setText(paramBundle);
      }
      if (!Util.isNullOrNil(str))
      {
        this.pJi.setText(str);
        this.pJi.setVisibility(0);
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
      this.VBr.setVisibility(8);
      this.VBs.setVisibility(0);
      this.rIe.setImageResource(a.h.realname_done);
      paramBundle = getInput().getString("realname_verify_process_finish_page");
      if (!Util.isNullOrNil(paramBundle)) {
        this.VBs.setText(paramBundle);
      }
      this.VBs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(70136);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.wallet_core.a.b(WcPayRealnameVerifySuccessUI.this.getContext(), WcPayRealnameVerifySuccessUI.this.getInput(), 0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WcPayRealnameVerifySuccessUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(70136);
        }
      });
    }
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifySuccessUI
 * JD-Core Version:    0.7.0.1
 */