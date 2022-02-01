package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.p;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.wallet.balance.model.lqt.d;
import com.tencent.mm.plugin.wallet.balance.model.lqt.e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.adr;
import com.tencent.mm.protocal.protobuf.dqy;
import com.tencent.mm.protocal.protobuf.dyp;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.protocal.protobuf.ekb;
import com.tencent.mm.protocal.protobuf.fmx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.picker.b.b;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.k;
import com.tencent.mm.wallet_core.ui.l;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class WalletLqtBalanceAutoTransferUI
  extends WalletBaseUI
{
  private TextView KmP;
  private TextView VdA;
  private TextView VdB;
  private FrameLayout VdC;
  private LinearLayout VdD;
  private View VdE;
  private int VdF;
  private fmx VdG;
  private fmx VdH;
  private efj VdI;
  private String VdJ;
  private View VdK;
  private MMSwitchBtn Vdz;
  private TextView pJi;
  private TextView sUt;
  
  private String a(fmx paramfmx, int paramInt)
  {
    AppMethodBeat.i(316523);
    DecimalFormat localDecimalFormat = new DecimalFormat("00");
    paramfmx = getString(paramInt, new Object[] { localDecimalFormat.format(paramfmx.ftu / 60), localDecimalFormat.format(paramfmx.end_time / 60) });
    AppMethodBeat.o(316523);
    return paramfmx;
  }
  
  private void ifb()
  {
    AppMethodBeat.i(68764);
    this.Vdz.setCheck(true);
    this.VdK.setVisibility(8);
    ifd();
    AppMethodBeat.o(68764);
  }
  
  private void ifc()
  {
    AppMethodBeat.i(68765);
    this.Vdz.setCheck(false);
    this.VdK.setVisibility(8);
    ife();
    AppMethodBeat.o(68765);
  }
  
  private void ifd()
  {
    AppMethodBeat.i(68766);
    this.VdD.setVisibility(0);
    this.VdE.setVisibility(0);
    AppMethodBeat.o(68766);
  }
  
  private void ife()
  {
    AppMethodBeat.i(68767);
    this.VdD.setVisibility(8);
    this.VdE.setVisibility(8);
    AppMethodBeat.o(68767);
  }
  
  private void iff()
  {
    AppMethodBeat.i(68769);
    if (this.VdG != null)
    {
      this.KmP.setText(a(this.VdG, a.i.wallet_lqt_balance_auto_time));
      AppMethodBeat.o(68769);
      return;
    }
    this.KmP.setText("");
    AppMethodBeat.o(68769);
  }
  
  public int getLayoutId()
  {
    return a.g.lqt_balance_auto_transfer;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68762);
    this.Vdz = ((MMSwitchBtn)findViewById(a.f.lbat_account_switch_btn));
    this.sUt = ((TextView)findViewById(a.f.lbat_title_tv));
    this.pJi = ((TextView)findViewById(a.f.lbat_desc_tv));
    this.KmP = ((TextView)findViewById(a.f.lbat_time_desc_tv));
    this.VdD = ((LinearLayout)findViewById(a.f.lbat_time_layout));
    this.VdE = findViewById(a.f.lbat_bottom_divider);
    this.VdA = ((TextView)findViewById(a.f.lbat_account_title));
    this.VdB = ((TextView)findViewById(a.f.lbat_time_title_tv));
    this.VdC = ((FrameLayout)findViewById(a.f.lbat_account_switch_layout));
    this.VdK = findViewById(a.f.lbat_disable_block_view);
    this.Vdz.setSwitchListener(new MMSwitchBtn.a()
    {
      long VdL = 0L;
      
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        boolean bool = true;
        AppMethodBeat.i(68752);
        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "click switch: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        long l = SystemClock.elapsedRealtime();
        if (l - this.VdL < 1000L)
        {
          Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "skip");
          MMSwitchBtn localMMSwitchBtn = WalletLqtBalanceAutoTransferUI.a(WalletLqtBalanceAutoTransferUI.this);
          if (!paramAnonymousBoolean) {}
          for (paramAnonymousBoolean = bool;; paramAnonymousBoolean = false)
          {
            localMMSwitchBtn.setCheck(paramAnonymousBoolean);
            this.VdL = l;
            AppMethodBeat.o(68752);
            return;
          }
        }
        this.VdL = l;
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
    this.VdD.setOnClickListener(new k()
    {
      public final void dr(View paramAnonymousView)
      {
        AppMethodBeat.i(316365);
        Log.d("MicroMsg.WalletLqtBalanceAutoTransferUI", "click time layout");
        WalletLqtBalanceAutoTransferUI.c(WalletLqtBalanceAutoTransferUI.this);
        AppMethodBeat.o(316365);
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
        paramIntent = l.c(getContext(), false, null);
        new d(str).bFJ().b(new a() {});
        AppMethodBeat.o(68763);
        return;
      }
      ifc();
      AppMethodBeat.o(68763);
      return;
    }
    if (paramInt1 == 32)
    {
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do close");
        paramIntent = l.c(getContext(), false, null);
        new com.tencent.mm.plugin.wallet.balance.model.lqt.b(str).bFJ().b(new a() {});
        AppMethodBeat.o(68763);
        return;
      }
      ifb();
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
    new e().bFJ().b(new a() {});
    AppMethodBeat.o(68761);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI
 * JD-Core Version:    0.7.0.1
 */