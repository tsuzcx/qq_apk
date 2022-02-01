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
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.wallet.balance.model.lqt.b;
import com.tencent.mm.plugin.wallet.balance.model.lqt.d;
import com.tencent.mm.plugin.wallet.balance.model.lqt.e;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.protocal.protobuf.ddf;
import com.tencent.mm.protocal.protobuf.dhl;
import com.tencent.mm.protocal.protobuf.ehn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.c.b;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.h;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class WalletLqtBalanceAutoTransferUI
  extends WalletBaseUI
{
  private MMSwitchBtn HwU;
  private TextView HwV;
  private TextView HwW;
  private FrameLayout HwX;
  private LinearLayout HwY;
  private View HwZ;
  private int Hxa;
  private ehn Hxb;
  private ehn Hxc;
  private ddf Hxd;
  private String Hxe;
  private View Hxf;
  private TextView jVn;
  private TextView mPa;
  private TextView yQj;
  
  private String a(ehn paramehn)
  {
    AppMethodBeat.i(68768);
    DecimalFormat localDecimalFormat = new DecimalFormat("00");
    paramehn = getString(2131767822, new Object[] { localDecimalFormat.format(paramehn.Nhb / 60), localDecimalFormat.format(paramehn.pSb / 60) });
    AppMethodBeat.o(68768);
    return paramehn;
  }
  
  private void fNA()
  {
    AppMethodBeat.i(68766);
    this.HwY.setVisibility(0);
    this.HwZ.setVisibility(0);
    AppMethodBeat.o(68766);
  }
  
  private void fNB()
  {
    AppMethodBeat.i(68767);
    this.HwY.setVisibility(8);
    this.HwZ.setVisibility(8);
    AppMethodBeat.o(68767);
  }
  
  private void fNC()
  {
    AppMethodBeat.i(68769);
    if (this.Hxb != null)
    {
      this.yQj.setText(a(this.Hxb));
      AppMethodBeat.o(68769);
      return;
    }
    this.yQj.setText("");
    AppMethodBeat.o(68769);
  }
  
  private void fNy()
  {
    AppMethodBeat.i(68764);
    this.HwU.setCheck(true);
    this.Hxf.setVisibility(8);
    fNA();
    AppMethodBeat.o(68764);
  }
  
  private void fNz()
  {
    AppMethodBeat.i(68765);
    this.HwU.setCheck(false);
    this.Hxf.setVisibility(8);
    fNB();
    AppMethodBeat.o(68765);
  }
  
  public int getLayoutId()
  {
    return 2131495325;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68762);
    this.HwU = ((MMSwitchBtn)findViewById(2131303106));
    this.mPa = ((TextView)findViewById(2131303115));
    this.jVn = ((TextView)findViewById(2131303110));
    this.yQj = ((TextView)findViewById(2131303112));
    this.HwY = ((LinearLayout)findViewById(2131303113));
    this.HwZ = findViewById(2131303109);
    this.HwV = ((TextView)findViewById(2131303108));
    this.HwW = ((TextView)findViewById(2131303114));
    this.HwX = ((FrameLayout)findViewById(2131303107));
    this.Hxf = findViewById(2131303111);
    this.HwU.setSwitchListener(new MMSwitchBtn.a()
    {
      long Hxg = 0L;
      
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        boolean bool = true;
        AppMethodBeat.i(68752);
        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "click switch: %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        long l = SystemClock.elapsedRealtime();
        if (l - this.Hxg < 1000L)
        {
          Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "skip");
          MMSwitchBtn localMMSwitchBtn = WalletLqtBalanceAutoTransferUI.a(WalletLqtBalanceAutoTransferUI.this);
          if (!paramAnonymousBoolean) {}
          for (paramAnonymousBoolean = bool;; paramAnonymousBoolean = false)
          {
            localMMSwitchBtn.setCheck(paramAnonymousBoolean);
            this.Hxg = l;
            AppMethodBeat.o(68752);
            return;
          }
        }
        this.Hxg = l;
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
    this.HwY.setOnClickListener(new WalletLqtBalanceAutoTransferUI.2(this));
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
        paramIntent = h.c(getContext(), false, null);
        new d(str).aYI().b(new a() {});
        AppMethodBeat.o(68763);
        return;
      }
      fNz();
      AppMethodBeat.o(68763);
      return;
    }
    if (paramInt1 == 32)
    {
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do close");
        paramIntent = h.c(getContext(), false, null);
        new b(str).aYI().b(new a() {});
        AppMethodBeat.o(68763);
        return;
      }
      fNy();
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
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    if (getIntent().getIntExtra("show_open_toast", 0) == 1) {
      Toast.makeText(this, 2131767821, 0).show();
    }
    Log.i("MicroMsg.WalletLqtBalanceAutoTransferUI", "do qry setting");
    new e().aYI().b(new a() {});
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBalanceAutoTransferUI
 * JD-Core Version:    0.7.0.1
 */