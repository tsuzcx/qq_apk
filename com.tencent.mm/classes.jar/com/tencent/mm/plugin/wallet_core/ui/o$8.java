package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.faceid.auth.a;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.y;

final class o$8
  implements a
{
  o$8(o paramo) {}
  
  public final void aSj()
  {
    this.qGj.ipf.setVisibility(0);
  }
  
  public final void ri(int paramInt)
  {
    y.i("MicroMsg.WalletPwdDialog", "face id auth success");
    this.qGj.nqa.qFX = 1;
    this.qGj.nqa.bOU = "";
    this.qGj.nqa.bOV = "";
    this.qGj.nqa.bUA = ((k)g.r(k.class)).aSA();
    this.qGj.nqa.bOS = paramInt;
    PayInfo localPayInfo = this.qGj.nqa;
    localPayInfo.qFY += 1;
    this.qGj.bWR();
  }
  
  public final void rj(int paramInt)
  {
    y.i("MicroMsg.WalletPwdDialog", "face id auth fail: %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.qGj.nqa.qFY) });
    this.qGj.ipf.setVisibility(0);
    this.qGj.qFN.setVisibility(8);
    o.d(this.qGj);
    PayInfo localPayInfo = this.qGj.nqa;
    localPayInfo.qFY += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.o.8
 * JD-Core Version:    0.7.0.1
 */