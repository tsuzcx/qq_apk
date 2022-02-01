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
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.pwd.a.c;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.protocal.protobuf.buz;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.protocal.protobuf.drn;
import com.tencent.mm.protocal.protobuf.dro;
import com.tencent.mm.protocal.protobuf.dsl;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
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
  private DragSortListView DfK;
  private WalletUniversalPayOrderUI.a DfL;
  private TextView DfM;
  private TextView DfN;
  private TextView DfO;
  private MMSwitchBtn DfP;
  private TextView DfQ;
  private TextView DfR;
  private Dialog DfS;
  private boolean DfT = true;
  private ViewGroup oTj;
  private ViewGroup uRT;
  
  public int getLayoutId()
  {
    return 2131495945;
  }
  
  public void initView()
  {
    AppMethodBeat.i(69837);
    this.DfK = ((DragSortListView)findViewById(2131306891));
    this.oTj = ((ViewGroup)LayoutInflater.from(this).inflate(2131495943, null, false));
    this.DfM = ((TextView)this.oTj.findViewById(2131306887));
    this.DfN = ((TextView)this.oTj.findViewById(2131306883));
    this.DfO = ((TextView)this.oTj.findViewById(2131306885));
    this.DfP = ((MMSwitchBtn)this.oTj.findViewById(2131306884));
    this.DfQ = ((TextView)this.oTj.findViewById(2131306886));
    this.DfK.addHeaderView(this.oTj, null, false);
    this.uRT = ((ViewGroup)LayoutInflater.from(this).inflate(2131495942, null, false));
    this.DfR = ((TextView)this.uRT.findViewById(2131306882));
    this.DfK.addFooterView(this.uRT, null, false);
    this.DfL = new WalletUniversalPayOrderUI.a(this);
    this.DfK.setAdapter(this.DfL);
    this.DfK.setDropListener(new DragSortListView.h()
    {
      public final void ek(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(69819);
        if (paramAnonymousInt1 == paramAnonymousInt2)
        {
          ae.d("MicroMsg.WalletUniversalPayOrderUI", "no change: %s", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(69819);
          return;
        }
        WalletUniversalPayOrderUI.a(WalletUniversalPayOrderUI.this, paramAnonymousInt1, paramAnonymousInt2);
        g.yxI.f(16343, new Object[] { Integer.valueOf(10) });
        AppMethodBeat.o(69819);
      }
    });
    this.DfK.setRemoveListener(new DragSortListView.l()
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
    ae.i("MicroMsg.WalletUniversalPayOrderUI", "do query uni pay order");
    getString(2131755726);
    this.DfS = h.b(this, getString(2131765693), false, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    new c().aET().b(new a() {});
    g.yxI.f(16343, new Object[] { Integer.valueOf(1) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI
 * JD-Core Version:    0.7.0.1
 */