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
import com.tencent.mm.al.c.a;
import com.tencent.mm.al.n;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.wallet.pwd.a.c;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.dfk;
import com.tencent.mm.protocal.protobuf.dfl;
import com.tencent.mm.protocal.protobuf.dgi;
import com.tencent.mm.protocal.protobuf.xa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private ViewGroup nGk;
  private ViewGroup svI;
  private TextView zVA;
  private Dialog zVB;
  private boolean zVC = true;
  private DragSortListView zVt;
  private WalletUniversalPayOrderUI.a zVu;
  private TextView zVv;
  private TextView zVw;
  private TextView zVx;
  private MMSwitchBtn zVy;
  private TextView zVz;
  
  public int getLayoutId()
  {
    return 2131495945;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69837);
    this.zVt = ((DragSortListView)findViewById(2131306891));
    this.nGk = ((ViewGroup)LayoutInflater.from(this).inflate(2131495943, null, false));
    this.zVv = ((TextView)this.nGk.findViewById(2131306887));
    this.zVw = ((TextView)this.nGk.findViewById(2131306883));
    this.zVx = ((TextView)this.nGk.findViewById(2131306885));
    this.zVy = ((MMSwitchBtn)this.nGk.findViewById(2131306884));
    this.zVz = ((TextView)this.nGk.findViewById(2131306886));
    this.zVt.addHeaderView(this.nGk, null, false);
    this.svI = ((ViewGroup)LayoutInflater.from(this).inflate(2131495942, null, false));
    this.zVA = ((TextView)this.svI.findViewById(2131306882));
    this.zVt.addFooterView(this.svI, null, false);
    this.zVu = new WalletUniversalPayOrderUI.a(this);
    this.zVt.setAdapter(this.zVu);
    this.zVt.setDropListener(new DragSortListView.h()
    {
      public final void eg(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(69819);
        if (paramAnonymousInt1 == paramAnonymousInt2)
        {
          ad.d("MicroMsg.WalletUniversalPayOrderUI", "no change: %s", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(69819);
          return;
        }
        WalletUniversalPayOrderUI.a(WalletUniversalPayOrderUI.this, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.plugin.report.service.h.vKh.f(16343, new Object[] { Integer.valueOf(10) });
        AppMethodBeat.o(69819);
      }
    });
    this.zVt.setRemoveListener(new DragSortListView.l()
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
    ad.i("MicroMsg.WalletUniversalPayOrderUI", "do query uni pay order");
    getString(2131755726);
    this.zVB = com.tencent.mm.ui.base.h.b(this, getString(2131765693), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    new c().auK().b(new a() {});
    com.tencent.mm.plugin.report.service.h.vKh.f(16343, new Object[] { Integer.valueOf(1) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI
 * JD-Core Version:    0.7.0.1
 */