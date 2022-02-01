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
import com.tencent.mm.ak.n;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.wallet.balance.model.lqt.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.d;
import com.tencent.mm.plugin.wallet.balance.model.lqt.e;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.protocal.protobuf.cbg;
import com.tencent.mm.protocal.protobuf.cgb;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.xq;
import com.tencent.mm.sdk.platformtools.ac;
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
  private MMSwitchBtn Baf;
  private TextView Bag;
  private TextView Bah;
  private FrameLayout Bai;
  private LinearLayout Baj;
  private View Bak;
  private int Bal;
  private dhg Bam;
  private dhg Ban;
  private cgb Bao;
  private String Bap;
  private View Baq;
  private TextView lfN;
  private TextView lgw;
  private TextView uhg;
  
  private String a(dhg paramdhg)
  {
    AppMethodBeat.i(68768);
    DecimalFormat localDecimalFormat = new DecimalFormat("00");
    paramdhg = getString(2131765379, new Object[] { localDecimalFormat.format(paramdhg.FQz / 60), localDecimalFormat.format(paramdhg.nUv / 60) });
    AppMethodBeat.o(68768);
    return paramdhg;
  }
  
  private void eoJ()
  {
    AppMethodBeat.i(68764);
    this.Baf.setCheck(true);
    this.Baq.setVisibility(8);
    eoL();
    AppMethodBeat.o(68764);
  }
  
  private void eoK()
  {
    AppMethodBeat.i(68765);
    this.Baf.setCheck(false);
    this.Baq.setVisibility(8);
    eoM();
    AppMethodBeat.o(68765);
  }
  
  private void eoL()
  {
    AppMethodBeat.i(68766);
    this.Baj.setVisibility(0);
    this.Bak.setVisibility(0);
    AppMethodBeat.o(68766);
  }
  
  private void eoM()
  {
    AppMethodBeat.i(68767);
    this.Baj.setVisibility(8);
    this.Bak.setVisibility(8);
    AppMethodBeat.o(68767);
  }
  
  private void eoN()
  {
    AppMethodBeat.i(68769);
    if (this.Bam != null)
    {
      this.uhg.setText(a(this.Bam));
      AppMethodBeat.o(68769);
      return;
    }
    this.uhg.setText("");
    AppMethodBeat.o(68769);
  }
  
  public int getLayoutId()
  {
    return 2131494609;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68762);
    this.Baf = ((MMSwitchBtn)findViewById(2131301359));
    this.lfN = ((TextView)findViewById(2131301368));
    this.lgw = ((TextView)findViewById(2131301363));
    this.uhg = ((TextView)findViewById(2131301365));
    this.Baj = ((LinearLayout)findViewById(2131301366));
    this.Bak = findViewById(2131301362);
    this.Bag = ((TextView)findViewById(2131301361));
    this.Bah = ((TextView)findViewById(2131301367));
    this.Bai = ((FrameLayout)findViewById(2131301360));
    this.Baq = findViewById(2131301364);
    this.Baf.setSwitchListener(new MMSwitchBtn.a()
    {
      long Bar = 0L;
      
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        boolean bool = true;
        AppMethodBeat.i(68752);
        ac.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "click switch: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        long l = SystemClock.elapsedRealtime();
        if (l - this.Bar < 1000L)
        {
          ac.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "skip");
          MMSwitchBtn localMMSwitchBtn = WalletLqtBalanceAutoTransferUI.a(WalletLqtBalanceAutoTransferUI.this);
          if (!paramAnonymousBoolean) {}
          for (paramAnonymousBoolean = bool;; paramAnonymousBoolean = false)
          {
            localMMSwitchBtn.setCheck(paramAnonymousBoolean);
            this.Bar = l;
            AppMethodBeat.o(68752);
            return;
          }
        }
        this.Bar = l;
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
    this.Baj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(68753);
        ac.d("MicroMsg.WalletLqtBalanceAutoTransferUI", "click time layout");
        WalletLqtBalanceAutoTransferUI.c(WalletLqtBalanceAutoTransferUI.this);
        AppMethodBeat.o(68753);
      }
    });
    AppMethodBeat.o(68762);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(68763);
    ac.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "on activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = "";
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("encrypt_pwd");
    }
    if (paramInt1 == 16)
    {
      if (paramInt2 == -1)
      {
        ac.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do open");
        paramIntent = g.c(getContext(), false, null);
        new d(str).aBB().b(new a() {});
        AppMethodBeat.o(68763);
        return;
      }
      eoK();
      AppMethodBeat.o(68763);
      return;
    }
    if (paramInt1 == 32)
    {
      if (paramInt2 == -1)
      {
        ac.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do close");
        paramIntent = g.c(getContext(), false, null);
        new b(str).aBB().b(new a() {});
        AppMethodBeat.o(68763);
        return;
      }
      eoJ();
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
    ac.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do qry setting");
    new e().aBB().b(new a() {});
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