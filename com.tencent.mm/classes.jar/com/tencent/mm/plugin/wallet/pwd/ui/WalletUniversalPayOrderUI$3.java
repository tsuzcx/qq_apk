package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bae;
import com.tencent.mm.protocal.protobuf.cmk;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;

final class WalletUniversalPayOrderUI$3
  implements MMSwitchBtn.a
{
  WalletUniversalPayOrderUI$3(WalletUniversalPayOrderUI paramWalletUniversalPayOrderUI, cml paramcml) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(46428);
    ab.i("MicroMsg.WalletUniversalPayOrderUI", "click switch: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    WalletUniversalPayOrderUI.e(this.ubc).setDragEnabled(paramBoolean);
    Object localObject;
    c.a locala;
    if (paramBoolean)
    {
      if ((this.ubd.xWi == 1) && (this.ubd.xWj != null) && (!bo.isNullOrNil(this.ubd.xWj.title)))
      {
        ab.i("MicroMsg.WalletUniversalPayOrderUI", "show open dialog");
        localObject = this.ubd.xWj;
        locala = new c.a(this.ubc.getContext());
        locala.avm(((cmk)localObject).title);
        locala.avn(((cmk)localObject).content);
        locala.rG(false);
        if (((cmk)localObject).xWd != null)
        {
          locala.avt(((cmk)localObject).xWd.title);
          locala.b(new WalletUniversalPayOrderUI.3.1(this));
        }
        if (((cmk)localObject).xWe != null)
        {
          locala.avs(((cmk)localObject).xWe.title);
          locala.a(new WalletUniversalPayOrderUI.3.2(this));
        }
        localObject = locala.aLZ();
        this.ubc.addDialog((Dialog)localObject);
        ((c)localObject).show();
        h.qsU.e(16343, new Object[] { Integer.valueOf(3) });
      }
      for (;;)
      {
        h.qsU.e(16343, new Object[] { Integer.valueOf(2) });
        AppMethodBeat.o(46428);
        return;
        WalletUniversalPayOrderUI.f(this.ubc);
      }
    }
    if (WalletUniversalPayOrderUI.g(this.ubc))
    {
      WalletUniversalPayOrderUI.h(this.ubc);
      if ((this.ubd.xWk != null) && (!bo.isNullOrNil(this.ubd.xWk.title)))
      {
        ab.i("MicroMsg.WalletUniversalPayOrderUI", "show close dialog");
        localObject = this.ubd.xWk;
        locala = new c.a(this.ubc.getContext());
        locala.avm(((cmk)localObject).title);
        locala.avn(((cmk)localObject).content);
        locala.rG(false);
        if (((cmk)localObject).xWd != null)
        {
          locala.avt(((cmk)localObject).xWd.title);
          locala.b(new WalletUniversalPayOrderUI.3.3(this));
        }
        if (((cmk)localObject).xWe != null)
        {
          locala.avs(((cmk)localObject).xWe.title);
          locala.a(new WalletUniversalPayOrderUI.3.4(this));
        }
        localObject = locala.aLZ();
        this.ubc.addDialog((Dialog)localObject);
        ((c)localObject).show();
        h.qsU.e(16343, new Object[] { Integer.valueOf(7) });
      }
    }
    for (;;)
    {
      h.qsU.e(16343, new Object[] { Integer.valueOf(6) });
      AppMethodBeat.o(46428);
      return;
      WalletUniversalPayOrderUI.i(this.ubc);
      continue;
      WalletUniversalPayOrderUI.i(this.ubc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.3
 * JD-Core Version:    0.7.0.1
 */