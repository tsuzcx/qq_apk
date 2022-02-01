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
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.pwd.a.c;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.protocal.protobuf.abk;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.protocal.protobuf.elk;
import com.tencent.mm.protocal.protobuf.emj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.l;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletUniversalPayOrderUI
  extends WalletBaseUI
{
  private DragSortListView HLG;
  private WalletUniversalPayOrderUI.a HLH;
  private TextView HLI;
  private TextView HLJ;
  private TextView HLK;
  private MMSwitchBtn HLL;
  private TextView HLM;
  private TextView HLN;
  private Dialog HLO;
  private boolean HLP = true;
  private ViewGroup qgZ;
  private ViewGroup ykw;
  
  public int getLayoutId()
  {
    return 2131496925;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69837);
    this.HLG = ((DragSortListView)findViewById(2131310359));
    this.qgZ = ((ViewGroup)LayoutInflater.from(this).inflate(2131496923, null, false));
    this.HLI = ((TextView)this.qgZ.findViewById(2131310355));
    this.HLJ = ((TextView)this.qgZ.findViewById(2131310351));
    this.HLK = ((TextView)this.qgZ.findViewById(2131310353));
    this.HLL = ((MMSwitchBtn)this.qgZ.findViewById(2131310352));
    this.HLM = ((TextView)this.qgZ.findViewById(2131310354));
    this.HLG.addHeaderView(this.qgZ, null, false);
    this.ykw = ((ViewGroup)LayoutInflater.from(this).inflate(2131496922, null, false));
    this.HLN = ((TextView)this.ykw.findViewById(2131310350));
    this.HLG.addFooterView(this.ykw, null, false);
    this.HLH = new WalletUniversalPayOrderUI.a(this);
    this.HLG.setAdapter(this.HLH);
    this.HLG.setDropListener(new DragSortListView.h()
    {
      public final void ey(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(69819);
        if (paramAnonymousInt1 == paramAnonymousInt2)
        {
          Log.d("MicroMsg.WalletUniversalPayOrderUI", "no change: %s", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(69819);
          return;
        }
        WalletUniversalPayOrderUI.a(WalletUniversalPayOrderUI.this, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.plugin.report.service.h.CyF.a(16343, new Object[] { Integer.valueOf(10) });
        AppMethodBeat.o(69819);
      }
    });
    this.HLG.setRemoveListener(new DragSortListView.l()
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
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    setMMTitle("");
    initView();
    Log.i("MicroMsg.WalletUniversalPayOrderUI", "do query uni pay order");
    getString(2131755797);
    this.HLO = com.tencent.mm.ui.base.h.a(this, getString(2131768146), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    new c().aYI().b(new a() {});
    com.tencent.mm.plugin.report.service.h.CyF.a(16343, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(69836);
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
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI
 * JD-Core Version:    0.7.0.1
 */