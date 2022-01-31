package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.w;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletBindDepositUI
  extends WalletBaseUI
{
  private Button gHb;
  private boolean nwf;
  private ElementQuery udb;
  private WalletFormView ung;
  private WalletFormView uoK;
  private WalletFormView vHX;
  
  public WalletBindDepositUI()
  {
    AppMethodBeat.i(48674);
    this.nwf = true;
    this.udb = new ElementQuery();
    AppMethodBeat.o(48674);
  }
  
  private void bJ()
  {
    AppMethodBeat.i(48677);
    if (bo.isNullOrNil(this.udb.nLq))
    {
      this.uoK.setText("");
      AppMethodBeat.o(48677);
      return;
    }
    if (2 == this.udb.uhx)
    {
      this.uoK.setText(this.udb.nLq + " " + getString(2131305029));
      AppMethodBeat.o(48677);
      return;
    }
    this.uoK.setText(this.udb.nLq + " " + getString(2131305049));
    AppMethodBeat.o(48677);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971118;
  }
  
  public void initView()
  {
    AppMethodBeat.i(48676);
    setMMTitle(2131304881);
    this.ung = ((WalletFormView)findViewById(2131828909));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.ung);
    this.uoK = ((WalletFormView)findViewById(2131823480));
    this.vHX = ((WalletFormView)findViewById(2131828910));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.vHX);
    this.gHb = ((Button)findViewById(2131822914));
    setEditFocusListener(this.ung, 0, false);
    setEditFocusListener(this.vHX, 0, false);
    this.uoK.setOnClickListener(new WalletBindDepositUI.1(this));
    this.gHb.setOnClickListener(new WalletBindDepositUI.2(this));
    AppMethodBeat.o(48676);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(48678);
    ab.i("MicroMsg.WalletBindDepositUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(48678);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(48678);
      return;
      paramIntent = (ElementQuery)paramIntent.getParcelableExtra("elemt_query");
      if (paramIntent.cTv())
      {
        this.udb = paramIntent;
        bJ();
        AppMethodBeat.o(48678);
        return;
      }
      h.h(this, 2131304879, 2131297087);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48675);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(48675);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = false;
    AppMethodBeat.i(48679);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramm instanceof w)))
    {
      paramString = (w)paramm;
      if (paramString.ubT != null)
      {
        if (!paramString.ubT.cTv())
        {
          h.h(this, 2131304879, 2131297087);
          AppMethodBeat.o(48679);
          return true;
        }
        this.udb = paramString.ubT;
        bJ();
        if ((this.udb.uhv) && (this.udb.isError()))
        {
          h.h(this, 2131304850, 2131297087);
          AppMethodBeat.o(48679);
          return true;
        }
        paramString = com.tencent.mm.wallet_core.a.aM(this);
        if (paramString != null)
        {
          paramInt1 = this.udb.ubU;
          if (paramString == null)
          {
            if (bool) {
              break label238;
            }
            if (!paramString.cWe()) {
              break label217;
            }
            ab.w("MicroMsg.WalletBindDepositUI", "Overseas user try to bind domestic card!");
            h.h(this, 2131304783, 2131297087);
          }
          for (;;)
          {
            this.ung.cfK();
            AppMethodBeat.o(48679);
            return true;
            if (!paramString.mEJ.containsKey("key_support_bankcard"))
            {
              bool = true;
              break;
            }
            paramInt2 = paramString.dRO();
            if (paramInt2 == 0)
            {
              bool = true;
              break;
            }
            bool = Bankcard.gx(paramInt2, paramInt1);
            break;
            label217:
            ab.w("MicroMsg.WalletBindDepositUI", "Domestic user try to bind international card!");
            h.h(this, 2131304782, 2131297087);
          }
        }
        label238:
        bJ();
        AppMethodBeat.o(48679);
        return true;
      }
    }
    AppMethodBeat.o(48679);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI
 * JD-Core Version:    0.7.0.1
 */