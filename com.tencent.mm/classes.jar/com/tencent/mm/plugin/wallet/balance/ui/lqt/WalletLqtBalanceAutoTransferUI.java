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
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.n;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.wallet.balance.model.lqt.d;
import com.tencent.mm.plugin.wallet.balance.model.lqt.e;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.protocal.protobuf.cla;
import com.tencent.mm.protocal.protobuf.cos;
import com.tencent.mm.protocal.protobuf.dmv;
import com.tencent.mm.protocal.protobuf.zp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class WalletLqtBalanceAutoTransferUI
  extends WalletBaseUI
{
  private dmv CAA;
  private cla CAB;
  private String CAC;
  private View CAD;
  private MMSwitchBtn CAs;
  private TextView CAt;
  private TextView CAu;
  private FrameLayout CAv;
  private LinearLayout CAw;
  private View CAx;
  private int CAy;
  private dmv CAz;
  private TextView lCL;
  private TextView lDu;
  private TextView vjQ;
  
  private String a(dmv paramdmv)
  {
    AppMethodBeat.i(68768);
    DecimalFormat localDecimalFormat = new DecimalFormat("00");
    paramdmv = getString(2131765379, new Object[] { localDecimalFormat.format(paramdmv.HBe / 60), localDecimalFormat.format(paramdmv.oxQ / 60) });
    AppMethodBeat.o(68768);
    return paramdmv;
  }
  
  private void eCJ()
  {
    AppMethodBeat.i(68764);
    this.CAs.setCheck(true);
    this.CAD.setVisibility(8);
    eCL();
    AppMethodBeat.o(68764);
  }
  
  private void eCK()
  {
    AppMethodBeat.i(68765);
    this.CAs.setCheck(false);
    this.CAD.setVisibility(8);
    eCM();
    AppMethodBeat.o(68765);
  }
  
  private void eCL()
  {
    AppMethodBeat.i(68766);
    this.CAw.setVisibility(0);
    this.CAx.setVisibility(0);
    AppMethodBeat.o(68766);
  }
  
  private void eCM()
  {
    AppMethodBeat.i(68767);
    this.CAw.setVisibility(8);
    this.CAx.setVisibility(8);
    AppMethodBeat.o(68767);
  }
  
  private void eCN()
  {
    AppMethodBeat.i(68769);
    if (this.CAz != null)
    {
      this.vjQ.setText(a(this.CAz));
      AppMethodBeat.o(68769);
      return;
    }
    this.vjQ.setText("");
    AppMethodBeat.o(68769);
  }
  
  public int getLayoutId()
  {
    return 2131494609;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68762);
    this.CAs = ((MMSwitchBtn)findViewById(2131301359));
    this.lCL = ((TextView)findViewById(2131301368));
    this.lDu = ((TextView)findViewById(2131301363));
    this.vjQ = ((TextView)findViewById(2131301365));
    this.CAw = ((LinearLayout)findViewById(2131301366));
    this.CAx = findViewById(2131301362);
    this.CAt = ((TextView)findViewById(2131301361));
    this.CAu = ((TextView)findViewById(2131301367));
    this.CAv = ((FrameLayout)findViewById(2131301360));
    this.CAD = findViewById(2131301364);
    this.CAs.setSwitchListener(new MMSwitchBtn.a()
    {
      long CAE = 0L;
      
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        boolean bool = true;
        AppMethodBeat.i(68752);
        ad.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "click switch: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        long l = SystemClock.elapsedRealtime();
        if (l - this.CAE < 1000L)
        {
          ad.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "skip");
          MMSwitchBtn localMMSwitchBtn = WalletLqtBalanceAutoTransferUI.a(WalletLqtBalanceAutoTransferUI.this);
          if (!paramAnonymousBoolean) {}
          for (paramAnonymousBoolean = bool;; paramAnonymousBoolean = false)
          {
            localMMSwitchBtn.setCheck(paramAnonymousBoolean);
            this.CAE = l;
            AppMethodBeat.o(68752);
            return;
          }
        }
        this.CAE = l;
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
    this.CAw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68753);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtBalanceAutoTransferUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.d("MicroMsg.WalletLqtBalanceAutoTransferUI", "click time layout");
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
    ad.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "on activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = "";
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("encrypt_pwd");
    }
    if (paramInt1 == 16)
    {
      if (paramInt2 == -1)
      {
        ad.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do open");
        paramIntent = g.c(getContext(), false, null);
        new d(str).aED().b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(68763);
        return;
      }
      eCK();
      AppMethodBeat.o(68763);
      return;
    }
    if (paramInt1 == 32)
    {
      if (paramInt2 == -1)
      {
        ad.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do close");
        paramIntent = g.c(getContext(), false, null);
        new com.tencent.mm.plugin.wallet.balance.model.lqt.b(str).aED().b(new com.tencent.mm.vending.c.a() {});
        AppMethodBeat.o(68763);
        return;
      }
      eCJ();
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
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    if (getIntent().getIntExtra("show_open_toast", 0) == 1) {
      Toast.makeText(this, 2131765378, 0).show();
    }
    ad.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do qry setting");
    new e().aED().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(68761);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI
 * JD-Core Version:    0.7.0.1
 */