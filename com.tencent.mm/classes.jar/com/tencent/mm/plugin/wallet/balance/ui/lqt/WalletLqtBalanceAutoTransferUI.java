package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.q;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.wallet.balance.model.lqt.d;
import com.tencent.mm.plugin.wallet.balance.model.lqt.e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.abp;
import com.tencent.mm.protocal.protobuf.czr;
import com.tencent.mm.protocal.protobuf.dgi;
import com.tencent.mm.protocal.protobuf.dmv;
import com.tencent.mm.protocal.protobuf.drg;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.picker.b.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class WalletLqtBalanceAutoTransferUI
  extends WalletBaseUI
{
  private TextView Eui;
  private MMSwitchBtn OoH;
  private TextView OoI;
  private TextView OoJ;
  private FrameLayout OoK;
  private LinearLayout OoL;
  private View OoM;
  private int OoN;
  private erp OoO;
  private erp OoP;
  private dmv OoQ;
  private String OoR;
  private View OoS;
  private TextView mMA;
  private TextView pPT;
  
  private String a(erp paramerp, int paramInt)
  {
    AppMethodBeat.i(277956);
    DecimalFormat localDecimalFormat = new DecimalFormat("00");
    paramerp = getString(paramInt, new Object[] { localDecimalFormat.format(paramerp.dte / 60), localDecimalFormat.format(paramerp.end_time / 60) });
    AppMethodBeat.o(277956);
    return paramerp;
  }
  
  private void gGc()
  {
    AppMethodBeat.i(68764);
    this.OoH.setCheck(true);
    this.OoS.setVisibility(8);
    gGe();
    AppMethodBeat.o(68764);
  }
  
  private void gGd()
  {
    AppMethodBeat.i(68765);
    this.OoH.setCheck(false);
    this.OoS.setVisibility(8);
    gGf();
    AppMethodBeat.o(68765);
  }
  
  private void gGe()
  {
    AppMethodBeat.i(68766);
    this.OoL.setVisibility(0);
    this.OoM.setVisibility(0);
    AppMethodBeat.o(68766);
  }
  
  private void gGf()
  {
    AppMethodBeat.i(68767);
    this.OoL.setVisibility(8);
    this.OoM.setVisibility(8);
    AppMethodBeat.o(68767);
  }
  
  private void gGg()
  {
    AppMethodBeat.i(68769);
    if (this.OoO != null)
    {
      this.Eui.setText(a(this.OoO, a.i.wallet_lqt_balance_auto_time));
      AppMethodBeat.o(68769);
      return;
    }
    this.Eui.setText("");
    AppMethodBeat.o(68769);
  }
  
  public int getLayoutId()
  {
    return a.g.lqt_balance_auto_transfer;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68762);
    this.OoH = ((MMSwitchBtn)findViewById(a.f.lbat_account_switch_btn));
    this.pPT = ((TextView)findViewById(a.f.lbat_title_tv));
    this.mMA = ((TextView)findViewById(a.f.lbat_desc_tv));
    this.Eui = ((TextView)findViewById(a.f.lbat_time_desc_tv));
    this.OoL = ((LinearLayout)findViewById(a.f.lbat_time_layout));
    this.OoM = findViewById(a.f.lbat_bottom_divider);
    this.OoI = ((TextView)findViewById(a.f.lbat_account_title));
    this.OoJ = ((TextView)findViewById(a.f.lbat_time_title_tv));
    this.OoK = ((FrameLayout)findViewById(a.f.lbat_account_switch_layout));
    this.OoS = findViewById(a.f.lbat_disable_block_view);
    this.OoH.setSwitchListener(new MMSwitchBtn.a()
    {
      long OoT = 0L;
      
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        boolean bool = true;
        AppMethodBeat.i(68752);
        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "click switch: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        long l = SystemClock.elapsedRealtime();
        if (l - this.OoT < 1000L)
        {
          Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "skip");
          MMSwitchBtn localMMSwitchBtn = WalletLqtBalanceAutoTransferUI.a(WalletLqtBalanceAutoTransferUI.this);
          if (!paramAnonymousBoolean) {}
          for (paramAnonymousBoolean = bool;; paramAnonymousBoolean = false)
          {
            localMMSwitchBtn.setCheck(paramAnonymousBoolean);
            this.OoT = l;
            AppMethodBeat.o(68752);
            return;
          }
        }
        this.OoT = l;
        if (paramAnonymousBoolean)
        {
          WalletLqtBalanceAutoTransferUI.a(WalletLqtBalanceAutoTransferUI.this, 16);
          AppMethodBeat.o(68752);
          return;
        }
        WalletLqtBalanceAutoTransferUI.b(WalletLqtBalanceAutoTransferUI.this);
        AppMethodBeat.o(68752);
      }
    });
    this.OoL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68753);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtBalanceAutoTransferUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.d("MicroMsg.WalletLqtBalanceAutoTransferUI", "click time layout");
        WalletLqtBalanceAutoTransferUI.c(WalletLqtBalanceAutoTransferUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtBalanceAutoTransferUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(68753);
      }
    });
    AppMethodBeat.o(68762);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(68763);
    Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "on activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = "";
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("encrypt_pwd");
    }
    if (paramInt1 == 16)
    {
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do open");
        paramIntent = i.c(getContext(), false, null);
        new d(str).bhW().b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(68763);
        return;
      }
      gGd();
      AppMethodBeat.o(68763);
      return;
    }
    if (paramInt1 == 32)
    {
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do close");
        paramIntent = i.c(getContext(), false, null);
        new com.tencent.mm.plugin.wallet.balance.model.lqt.b(str).bhW().b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(68763);
        return;
      }
      gGc();
      AppMethodBeat.o(68763);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(68763);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68761);
    super.onCreate(paramBundle);
    setMMTitle("");
    initView();
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    if (getIntent().getIntExtra("show_open_toast", 0) == 1) {
      Toast.makeText(this, a.i.wallet_lqt_balance_auto_open_success_text, 0).show();
    }
    Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do qry setting");
    new e().bhW().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(68761);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI
 * JD-Core Version:    0.7.0.1
 */