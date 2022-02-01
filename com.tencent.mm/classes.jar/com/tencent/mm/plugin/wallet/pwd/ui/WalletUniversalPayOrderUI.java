package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.cn.f;
import com.tencent.mm.plugin.wallet.pwd.a.c;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.protocal.protobuf.dlx;
import com.tencent.mm.protocal.protobuf.xs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletUniversalPayOrderUI
  extends WalletBaseUI
{
  private DragSortListView BnN;
  private WalletUniversalPayOrderUI.a BnO;
  private TextView BnP;
  private TextView BnQ;
  private TextView BnR;
  private MMSwitchBtn BnS;
  private TextView BnT;
  private TextView BnU;
  private Dialog BnV;
  private boolean BnW = true;
  private ViewGroup ojl;
  private ViewGroup tDx;
  
  public int getLayoutId()
  {
    return 2131495945;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69837);
    this.BnN = ((DragSortListView)findViewById(2131306891));
    this.ojl = ((ViewGroup)LayoutInflater.from(this).inflate(2131495943, null, false));
    this.BnP = ((TextView)this.ojl.findViewById(2131306887));
    this.BnQ = ((TextView)this.ojl.findViewById(2131306883));
    this.BnR = ((TextView)this.ojl.findViewById(2131306885));
    this.BnS = ((MMSwitchBtn)this.ojl.findViewById(2131306884));
    this.BnT = ((TextView)this.ojl.findViewById(2131306886));
    this.BnN.addHeaderView(this.ojl, null, false);
    this.tDx = ((ViewGroup)LayoutInflater.from(this).inflate(2131495942, null, false));
    this.BnU = ((TextView)this.tDx.findViewById(2131306882));
    this.BnN.addFooterView(this.tDx, null, false);
    this.BnO = new WalletUniversalPayOrderUI.a(this);
    this.BnN.setAdapter(this.BnO);
    this.BnN.setDropListener(new DragSortListView.h()
    {
      public final void ei(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(69819);
        if (paramAnonymousInt1 == paramAnonymousInt2)
        {
          ac.d("MicroMsg.WalletUniversalPayOrderUI", "no change: %s", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(69819);
          return;
        }
        WalletUniversalPayOrderUI.a(WalletUniversalPayOrderUI.this, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.plugin.report.service.h.wUl.f(16343, new Object[] { Integer.valueOf(10) });
        AppMethodBeat.o(69819);
      }
    });
    this.BnN.setRemoveListener(new DragSortListView.l()
    {
      public final void remove(int paramAnonymousInt) {}
    });
    AppMethodBeat.o(69837);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69836);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitle("");
    initView();
    ac.i("MicroMsg.WalletUniversalPayOrderUI", "do query uni pay order");
    getString(2131755726);
    this.BnV = com.tencent.mm.ui.base.h.b(this, getString(2131765693), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    new c().aBB().b(new a() {});
    com.tencent.mm.plugin.report.service.h.wUl.f(16343, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(69836);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI
 * JD-Core Version:    0.7.0.1
 */