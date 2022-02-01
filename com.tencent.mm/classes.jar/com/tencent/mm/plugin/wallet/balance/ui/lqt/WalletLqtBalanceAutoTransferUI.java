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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.wallet.balance.model.lqt.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.d;
import com.tencent.mm.plugin.wallet.balance.model.lqt.e;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.protocal.protobuf.cgr;
import com.tencent.mm.protocal.protobuf.clu;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.zs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.h;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class WalletLqtBalanceAutoTransferUI
  extends WalletBaseUI
{
  private MMSwitchBtn CRX;
  private TextView CRY;
  private TextView CRZ;
  private FrameLayout CSa;
  private LinearLayout CSb;
  private View CSc;
  private int CSd;
  private dns CSe;
  private dns CSf;
  private clu CSg;
  private String CSh;
  private View CSi;
  private TextView lHT;
  private TextView lHk;
  private TextView vvV;
  
  private String a(dns paramdns)
  {
    AppMethodBeat.i(68768);
    DecimalFormat localDecimalFormat = new DecimalFormat("00");
    paramdns = getString(2131765379, new Object[] { localDecimalFormat.format(paramdns.HUR / 60), localDecimalFormat.format(paramdns.oEs / 60) });
    AppMethodBeat.o(68768);
    return paramdns;
  }
  
  private void eGq()
  {
    AppMethodBeat.i(68764);
    this.CRX.setCheck(true);
    this.CSi.setVisibility(8);
    eGs();
    AppMethodBeat.o(68764);
  }
  
  private void eGr()
  {
    AppMethodBeat.i(68765);
    this.CRX.setCheck(false);
    this.CSi.setVisibility(8);
    eGt();
    AppMethodBeat.o(68765);
  }
  
  private void eGs()
  {
    AppMethodBeat.i(68766);
    this.CSb.setVisibility(0);
    this.CSc.setVisibility(0);
    AppMethodBeat.o(68766);
  }
  
  private void eGt()
  {
    AppMethodBeat.i(68767);
    this.CSb.setVisibility(8);
    this.CSc.setVisibility(8);
    AppMethodBeat.o(68767);
  }
  
  private void eGu()
  {
    AppMethodBeat.i(68769);
    if (this.CSe != null)
    {
      this.vvV.setText(a(this.CSe));
      AppMethodBeat.o(68769);
      return;
    }
    this.vvV.setText("");
    AppMethodBeat.o(68769);
  }
  
  public int getLayoutId()
  {
    return 2131494609;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68762);
    this.CRX = ((MMSwitchBtn)findViewById(2131301359));
    this.lHk = ((TextView)findViewById(2131301368));
    this.lHT = ((TextView)findViewById(2131301363));
    this.vvV = ((TextView)findViewById(2131301365));
    this.CSb = ((LinearLayout)findViewById(2131301366));
    this.CSc = findViewById(2131301362);
    this.CRY = ((TextView)findViewById(2131301361));
    this.CRZ = ((TextView)findViewById(2131301367));
    this.CSa = ((FrameLayout)findViewById(2131301360));
    this.CSi = findViewById(2131301364);
    this.CRX.setSwitchListener(new MMSwitchBtn.a()
    {
      long CSj = 0L;
      
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        boolean bool = true;
        AppMethodBeat.i(68752);
        ae.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "click switch: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        long l = SystemClock.elapsedRealtime();
        if (l - this.CSj < 1000L)
        {
          ae.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "skip");
          MMSwitchBtn localMMSwitchBtn = WalletLqtBalanceAutoTransferUI.a(WalletLqtBalanceAutoTransferUI.this);
          if (!paramAnonymousBoolean) {}
          for (paramAnonymousBoolean = bool;; paramAnonymousBoolean = false)
          {
            localMMSwitchBtn.setCheck(paramAnonymousBoolean);
            this.CSj = l;
            AppMethodBeat.o(68752);
            return;
          }
        }
        this.CSj = l;
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
    this.CSb.setOnClickListener(new WalletLqtBalanceAutoTransferUI.2(this));
    AppMethodBeat.o(68762);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(68763);
    ae.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "on activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = "";
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("encrypt_pwd");
    }
    if (paramInt1 == 16)
    {
      if (paramInt2 == -1)
      {
        ae.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do open");
        paramIntent = h.c(getContext(), false, null);
        new d(str).aET().b(new a() {});
        AppMethodBeat.o(68763);
        return;
      }
      eGr();
      AppMethodBeat.o(68763);
      return;
    }
    if (paramInt1 == 32)
    {
      if (paramInt2 == -1)
      {
        ae.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do close");
        paramIntent = h.c(getContext(), false, null);
        new b(str).aET().b(new a() {});
        AppMethodBeat.o(68763);
        return;
      }
      eGq();
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
    ae.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do qry setting");
    new e().aET().b(new a() {});
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI
 * JD-Core Version:    0.7.0.1
 */