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
import com.tencent.mm.al.n;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.wallet.balance.model.lqt.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.d;
import com.tencent.mm.plugin.wallet.balance.model.lqt.e;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.dbu;
import com.tencent.mm.protocal.protobuf.wy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class WalletLqtBalanceAutoTransferUI
  extends WalletBaseUI
{
  private TextView kEu;
  private TextView kFd;
  private TextView sYS;
  private MMSwitchBtn zHT;
  private TextView zHU;
  private TextView zHV;
  private FrameLayout zHW;
  private LinearLayout zHX;
  private View zHY;
  private int zHZ;
  private dbu zIa;
  private dbu zIb;
  private cbb zIc;
  private String zId;
  private View zIe;
  
  private String a(dbu paramdbu)
  {
    AppMethodBeat.i(68768);
    DecimalFormat localDecimalFormat = new DecimalFormat("00");
    paramdbu = getString(2131765379, new Object[] { localDecimalFormat.format(paramdbu.Etx / 60), localDecimalFormat.format(paramdbu.nrv / 60) });
    AppMethodBeat.o(68768);
    return paramdbu;
  }
  
  private void dZn()
  {
    AppMethodBeat.i(68764);
    this.zHT.setCheck(true);
    this.zIe.setVisibility(8);
    dZp();
    AppMethodBeat.o(68764);
  }
  
  private void dZo()
  {
    AppMethodBeat.i(68765);
    this.zHT.setCheck(false);
    this.zIe.setVisibility(8);
    dZq();
    AppMethodBeat.o(68765);
  }
  
  private void dZp()
  {
    AppMethodBeat.i(68766);
    this.zHX.setVisibility(0);
    this.zHY.setVisibility(0);
    AppMethodBeat.o(68766);
  }
  
  private void dZq()
  {
    AppMethodBeat.i(68767);
    this.zHX.setVisibility(8);
    this.zHY.setVisibility(8);
    AppMethodBeat.o(68767);
  }
  
  private void dZr()
  {
    AppMethodBeat.i(68769);
    if (this.zIa != null)
    {
      this.sYS.setText(a(this.zIa));
      AppMethodBeat.o(68769);
      return;
    }
    this.sYS.setText("");
    AppMethodBeat.o(68769);
  }
  
  public int getLayoutId()
  {
    return 2131494609;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68762);
    this.zHT = ((MMSwitchBtn)findViewById(2131301359));
    this.kEu = ((TextView)findViewById(2131301368));
    this.kFd = ((TextView)findViewById(2131301363));
    this.sYS = ((TextView)findViewById(2131301365));
    this.zHX = ((LinearLayout)findViewById(2131301366));
    this.zHY = findViewById(2131301362);
    this.zHU = ((TextView)findViewById(2131301361));
    this.zHV = ((TextView)findViewById(2131301367));
    this.zHW = ((FrameLayout)findViewById(2131301360));
    this.zIe = findViewById(2131301364);
    this.zHT.setSwitchListener(new MMSwitchBtn.a()
    {
      long zIf = 0L;
      
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        boolean bool = true;
        AppMethodBeat.i(68752);
        ad.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "click switch: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        long l = SystemClock.elapsedRealtime();
        if (l - this.zIf < 1000L)
        {
          ad.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "skip");
          MMSwitchBtn localMMSwitchBtn = WalletLqtBalanceAutoTransferUI.a(WalletLqtBalanceAutoTransferUI.this);
          if (!paramAnonymousBoolean) {}
          for (paramAnonymousBoolean = bool;; paramAnonymousBoolean = false)
          {
            localMMSwitchBtn.setCheck(paramAnonymousBoolean);
            this.zIf = l;
            AppMethodBeat.o(68752);
            return;
          }
        }
        this.zIf = l;
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
    this.zHX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68753);
        ad.d("MicroMsg.WalletLqtBalanceAutoTransferUI", "click time layout");
        WalletLqtBalanceAutoTransferUI.c(WalletLqtBalanceAutoTransferUI.this);
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
        new d(str).auK().b(new a() {});
        AppMethodBeat.o(68763);
        return;
      }
      dZo();
      AppMethodBeat.o(68763);
      return;
    }
    if (paramInt1 == 32)
    {
      if (paramInt2 == -1)
      {
        ad.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do close");
        paramIntent = g.c(getContext(), false, null);
        new b(str).auK().b(new a() {});
        AppMethodBeat.o(68763);
        return;
      }
      dZn();
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
    new e().auK().b(new a() {});
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI
 * JD-Core Version:    0.7.0.1
 */