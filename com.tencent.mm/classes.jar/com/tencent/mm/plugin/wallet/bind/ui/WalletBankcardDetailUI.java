package com.tencent.mm.plugin.wallet.bind.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletBankcardDetailUI
  extends WalletBaseUI
{
  protected Bankcard tOQ;
  protected TextView tSP;
  private TextView tSQ;
  private View tSR;
  protected LinearLayout tSS;
  protected LinearLayout tST;
  protected LinearLayout tSU;
  
  private void nv(boolean paramBoolean)
  {
    AppMethodBeat.i(45757);
    if ((!r.ZB()) && (!paramBoolean) && (!((com.tencent.mm.plugin.walletlock.a.b)g.E(com.tencent.mm.plugin.walletlock.a.b.class)).cXu()))
    {
      e.RX(0);
      h.a(this, 2131304869, -1, 2131304868, 2131304870, true, new WalletBankcardDetailUI.6(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45747);
          WalletBankcardDetailUI.b(WalletBankcardDetailUI.this);
          e.RX(2);
          AppMethodBeat.o(45747);
        }
      });
      AppMethodBeat.o(45757);
      return;
    }
    getInput().putBoolean("offline_pay", false);
    com.tencent.mm.wallet_core.a.j(this, getInput());
    AppMethodBeat.o(45757);
  }
  
  protected final void cRx()
  {
    AppMethodBeat.i(45755);
    this.tSS.setVisibility(0);
    this.tST.setVisibility(8);
    ((TextView)findViewById(2131829007)).setOnClickListener(new WalletBankcardDetailUI.3(this));
    ((TextView)findViewById(2131829005)).setOnClickListener(new WalletBankcardDetailUI.4(this));
    AppMethodBeat.o(45755);
  }
  
  public int getLayoutId()
  {
    return 2130971141;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45756);
    this.tOQ = ((Bankcard)getInput().getParcelable("key_bankcard"));
    if (this.tOQ == null)
    {
      AppMethodBeat.o(45756);
      return;
    }
    this.tSS = ((LinearLayout)findViewById(2131829004));
    this.tST = ((LinearLayout)findViewById(2131828995));
    this.tSU = ((LinearLayout)findViewById(2131829008));
    this.tSQ = ((TextView)findViewById(2131829001));
    this.tSR = findViewById(2131829002);
    this.tSR.setOnClickListener(new WalletBankcardDetailUI.1(this));
    if (1 == this.tOQ.field_bankcardState)
    {
      cRx();
      AppMethodBeat.o(45756);
      return;
    }
    if (this.tOQ.cTi())
    {
      nu(true);
      this.tSP = ((TextView)findViewById(2131828996));
      s.cRG();
      s.cRH();
      this.tSP.setVisibility(8);
    }
    for (;;)
    {
      addIconOptionMenu(0, 2130839668, new WalletBankcardDetailUI.5(this));
      AppMethodBeat.o(45756);
      return;
      nu(false);
      this.tSP = ((TextView)findViewById(2131829009));
      s.cRG();
      s.cRH();
      this.tSP.setVisibility(8);
    }
  }
  
  protected final void nu(boolean paramBoolean)
  {
    AppMethodBeat.i(45754);
    if (paramBoolean)
    {
      this.tSS.setVisibility(8);
      this.tST.setVisibility(0);
      ((TextView)findViewById(2131829003)).setOnClickListener(new WalletBankcardDetailUI.2(this));
      TextView localTextView1 = (TextView)findViewById(2131828997);
      TextView localTextView2 = (TextView)findViewById(2131828998);
      TextView localTextView3 = (TextView)findViewById(2131828999);
      TextView localTextView4 = (TextView)findViewById(2131829000);
      localTextView1.setText(e.e(this.tOQ.field_onceQuotaKind, null));
      localTextView2.setText(e.e(this.tOQ.field_onceQuotaVirtual, null));
      localTextView3.setText(e.e(this.tOQ.field_dayQuotaKind, null));
      localTextView4.setText(e.e(this.tOQ.field_dayQuotaVirtual, null));
      if (!bo.isNullOrNil(this.tOQ.field_repay_url))
      {
        this.tSQ.setVisibility(0);
        this.tSR.setVisibility(0);
      }
      AppMethodBeat.o(45754);
      return;
    }
    this.tSS.setVisibility(8);
    this.tST.setVisibility(8);
    this.tSU.setVisibility(0);
    AppMethodBeat.o(45754);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45750);
    super.onCreate(paramBundle);
    addSceneEndListener(621);
    setMMTitle(2131304867);
    initView();
    AppMethodBeat.o(45750);
  }
  
  @Deprecated
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(45758);
    Dialog localDialog = h.a(getContext(), getString(2131304854), getResources().getStringArray(2131755065), "", new WalletBankcardDetailUI.8(this));
    AppMethodBeat.o(45758);
    return localDialog;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45752);
    removeSceneEndListener(621);
    super.onDestroy();
    AppMethodBeat.o(45752);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(45751);
    super.onResume();
    AppMethodBeat.o(45751);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45759);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.wallet.bind.a.b)) {
        if (this.tSP != null) {
          this.tSP.setVisibility(0);
        }
      }
    }
    while (!(paramm instanceof com.tencent.mm.plugin.wallet.bind.a.a)) {
      for (;;)
      {
        AppMethodBeat.o(45759);
        return false;
        if ((paramm instanceof com.tencent.mm.plugin.wallet.bind.a.a))
        {
          paramString = (com.tencent.mm.plugin.wallet.bind.a.a)paramm;
          ab.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo succ and level = " + paramString.tSp);
          switch (paramString.tSp)
          {
          default: 
            nv(false);
            break;
          case 2: 
          case 3: 
            paramInt1 = paramString.tSp;
            h.a(this, paramString.tSq, null, false, new WalletBankcardDetailUI.9(this, paramInt1));
          }
        }
      }
    }
    ab.e("MicroMsg.WalletBankcardDetailUI", "NetSceneGetUnbindInfo error");
    nv(false);
    AppMethodBeat.o(45759);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI
 * JD-Core Version:    0.7.0.1
 */