package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.n.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

public class WalletVerifyIdCardUI
  extends WalletBaseUI
{
  private TextView iJG;
  private boolean uuh;
  private k uuj;
  private n.a uuk;
  private EditHintPasswdView uuq;
  
  public WalletVerifyIdCardUI()
  {
    AppMethodBeat.i(47722);
    this.uuj = new k();
    this.uuh = false;
    this.uuk = new WalletVerifyIdCardUI.4(this);
    AppMethodBeat.o(47722);
  }
  
  private boolean cWe()
  {
    AppMethodBeat.i(47726);
    boolean bool = getInput().getBoolean("key_is_oversea", false);
    AppMethodBeat.o(47726);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2130971265;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47724);
    this.iJG = ((TextView)findViewById(2131829416));
    this.uuq = ((EditHintPasswdView)findViewById(2131829417));
    String str1 = getInput().getString("key_true_name");
    String str2 = getInput().getString("key_cre_name");
    String str3 = getInput().getString("key_cre_type");
    this.iJG.setText(getString(2131305102, new Object[] { str1, str2 }));
    this.uuq.setEditTextMaxLength(4);
    this.uuq.setEditTextSize(34.0F);
    this.uuq.setOnInputValidListener(new WalletVerifyIdCardUI.2(this));
    if ("1".equals(str3))
    {
      setEditFocusListener(this.uuq, 1, false);
      AppMethodBeat.o(47724);
      return;
    }
    setEditFocusListener(this.uuq, 1, true);
    AppMethodBeat.o(47724);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47723);
    super.onCreate(paramBundle);
    this.uuj = new k(getInput());
    initView();
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131690709)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.findViewById(2131821148);
      if (paramBundle != null) {
        paramBundle.setBackgroundColor(getResources().getColor(2131690605));
      }
    }
    if (d.fv(21))
    {
      if (!d.fv(23)) {
        break label157;
      }
      getWindow().setStatusBarColor(-1);
      getWindow().getDecorView().setSystemUiVisibility(8192);
    }
    for (;;)
    {
      setMMTitle("");
      setBackBtn(new WalletVerifyIdCardUI.1(this), 2131230737);
      AppMethodBeat.o(47723);
      return;
      label157:
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
    }
  }
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47727);
    ab.i("MicroMsg.WalletVerifyIdCardUI", "onPreSceneEnd %s %s", new Object[] { Integer.valueOf(paramInt2), paramm });
    if (((paramm instanceof n)) && (paramInt2 == 0))
    {
      this.uuh = true;
      t.makeText(this, 2131305403, 0).show();
      ab.i("MicroMsg.WalletVerifyIdCardUI", "tag it isCertInstalled ok");
    }
    AppMethodBeat.o(47727);
    return true;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47725);
    if ((paramm instanceof n))
    {
      if ((paramInt2 != 0) && (((n)paramm).isBlock())) {
        h.a(getContext(), paramString, null, false, new WalletVerifyIdCardUI.3(this));
      }
      for (;;)
      {
        AppMethodBeat.o(47725);
        return true;
        this.uuq.cfK();
      }
    }
    AppMethodBeat.o(47725);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI
 * JD-Core Version:    0.7.0.1
 */