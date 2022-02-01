package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

public class WalletVerifyIdCardUI
  extends WalletBaseUI
{
  private boolean PcV;
  private i PcX;
  private p.a PcY;
  private EditHintPasswdView Pde;
  private TextView pPT;
  
  public WalletVerifyIdCardUI()
  {
    AppMethodBeat.i(71293);
    this.PcX = new i();
    this.PcV = false;
    this.PcY = new p.a()
    {
      public final void gLU()
      {
        AppMethodBeat.i(71292);
        WalletVerifyIdCardUI.b(WalletVerifyIdCardUI.this);
        AppMethodBeat.o(71292);
      }
    };
    AppMethodBeat.o(71293);
  }
  
  private boolean gLV()
  {
    AppMethodBeat.i(71297);
    boolean bool = getInput().getBoolean("key_is_oversea", false);
    AppMethodBeat.o(71297);
    return bool;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_verify_idcard_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71295);
    this.pPT = ((TextView)findViewById(a.f.wviu_title_tv));
    this.Pde = ((EditHintPasswdView)findViewById(a.f.wviu_tail_et));
    String str1 = getInput().getString("key_true_name");
    String str2 = getInput().getString("key_cre_name");
    String str3 = getInput().getString("key_cre_type");
    this.pPT.setText(getString(a.i.wallet_idcard_tail_title, new Object[] { str1, str2 }));
    this.Pde.setEditTextMaxLength(4);
    this.Pde.setEditTextSize(34.0F);
    this.Pde.setOnInputValidListener(new EditHintPasswdView.a()
    {
      public final void onInputValidChange(final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71291);
        WalletVerifyIdCardUI.c(WalletVerifyIdCardUI.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71290);
            if (paramAnonymousBoolean)
            {
              if (WalletVerifyIdCardUI.a(WalletVerifyIdCardUI.this, WalletVerifyIdCardUI.a(WalletVerifyIdCardUI.this)))
              {
                AppMethodBeat.o(71290);
                return;
              }
              WalletVerifyIdCardUI.b(WalletVerifyIdCardUI.this);
            }
            AppMethodBeat.o(71290);
          }
        }, 50L);
        AppMethodBeat.o(71291);
      }
    });
    if ("1".equals(str3))
    {
      setEditFocusListener(this.Pde, 1, false);
      AppMethodBeat.o(71295);
      return;
    }
    setEditFocusListener(this.Pde, 1, true);
    AppMethodBeat.o(71295);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71294);
    super.onCreate(paramBundle);
    this.PcX = new i(getInput());
    initView();
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.white)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.findViewById(a.f.divider);
      if (paramBundle != null) {
        paramBundle.setBackgroundColor(getResources().getColor(a.c.transparent));
      }
    }
    if (d.qV(21))
    {
      if (!d.qV(23)) {
        break label153;
      }
      getWindow().setStatusBarColor(getResources().getColor(a.c.white));
    }
    for (;;)
    {
      setMMTitle("");
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(71289);
          WalletVerifyIdCardUI.this.finish();
          AppMethodBeat.o(71289);
          return false;
        }
      }, a.h.actionbar_icon_dark_back);
      AppMethodBeat.o(71294);
      return;
      label153:
      getWindow().setStatusBarColor(getResources().getColor(a.c.BW_90));
    }
  }
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71298);
    Log.i("MicroMsg.WalletVerifyIdCardUI", "onPreSceneEnd %s %s", new Object[] { Integer.valueOf(paramInt2), paramq });
    if (((paramq instanceof p)) && (paramInt2 == 0))
    {
      this.PcV = true;
      w.makeText(this, a.i.wallet_password_setting_digitalcert_install_verify_install_toast, 0).show();
      Log.i("MicroMsg.WalletVerifyIdCardUI", "tag it isCertInstalled ok");
    }
    AppMethodBeat.o(71298);
    return true;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(71296);
    if ((paramq instanceof p))
    {
      if ((paramInt2 != 0) && (((p)paramq).isBlock())) {
        h.a(getContext(), paramString, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (;;)
      {
        AppMethodBeat.o(71296);
        return true;
        this.Pde.fuo();
      }
    }
    AppMethodBeat.o(71296);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI
 * JD-Core Version:    0.7.0.1
 */