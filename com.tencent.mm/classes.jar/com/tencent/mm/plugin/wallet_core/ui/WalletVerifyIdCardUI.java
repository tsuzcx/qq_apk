package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

public class WalletVerifyIdCardUI
  extends WalletBaseUI
{
  private EditHintPasswdView DBA;
  private boolean DBr;
  private i DBt;
  private p.a DBu;
  private TextView lHk;
  
  public WalletVerifyIdCardUI()
  {
    AppMethodBeat.i(71293);
    this.DBt = new i();
    this.DBr = false;
    this.DBu = new p.a()
    {
      public final void eLH()
      {
        AppMethodBeat.i(71292);
        WalletVerifyIdCardUI.b(WalletVerifyIdCardUI.this);
        AppMethodBeat.o(71292);
      }
    };
    AppMethodBeat.o(71293);
  }
  
  private boolean eLI()
  {
    AppMethodBeat.i(71297);
    boolean bool = getInput().getBoolean("key_is_oversea", false);
    AppMethodBeat.o(71297);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131496042;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71295);
    this.lHk = ((TextView)findViewById(2131307103));
    this.DBA = ((EditHintPasswdView)findViewById(2131307102));
    String str1 = getInput().getString("key_true_name");
    String str2 = getInput().getString("key_cre_name");
    String str3 = getInput().getString("key_cre_type");
    this.lHk.setText(getString(2131765294, new Object[] { str1, str2 }));
    this.DBA.setEditTextMaxLength(4);
    this.DBA.setEditTextSize(34.0F);
    this.DBA.setOnInputValidListener(new EditHintPasswdView.a()
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
      setEditFocusListener(this.DBA, 1, false);
      AppMethodBeat.o(71295);
      return;
    }
    setEditFocusListener(this.DBA, 1, true);
    AppMethodBeat.o(71295);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71294);
    super.onCreate(paramBundle);
    this.DBt = new i(getInput());
    initView();
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131101179)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.findViewById(2131299154);
      if (paramBundle != null) {
        paramBundle.setBackgroundColor(getResources().getColor(2131101053));
      }
    }
    if (d.lA(21))
    {
      if (!d.lA(23)) {
        break label153;
      }
      getWindow().setStatusBarColor(getResources().getColor(2131101179));
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
      }, 2131689490);
      AppMethodBeat.o(71294);
      return;
      label153:
      getWindow().setStatusBarColor(getResources().getColor(2131099678));
    }
  }
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71298);
    ae.i("MicroMsg.WalletVerifyIdCardUI", "onPreSceneEnd %s %s", new Object[] { Integer.valueOf(paramInt2), paramn });
    if (((paramn instanceof p)) && (paramInt2 == 0))
    {
      this.DBr = true;
      t.makeText(this, 2131765617, 0).show();
      ae.i("MicroMsg.WalletVerifyIdCardUI", "tag it isCertInstalled ok");
    }
    AppMethodBeat.o(71298);
    return true;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(71296);
    if ((paramn instanceof p))
    {
      if ((paramInt2 != 0) && (((p)paramn).isBlock())) {
        h.a(getContext(), paramString, null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
      }
      for (;;)
      {
        AppMethodBeat.o(71296);
        return true;
        this.DBA.dHv();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI
 * JD-Core Version:    0.7.0.1
 */