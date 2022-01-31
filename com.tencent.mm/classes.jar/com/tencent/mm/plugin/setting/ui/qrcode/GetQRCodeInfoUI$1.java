package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.m;

final class GetQRCodeInfoUI$1
  implements bi.a
{
  GetQRCodeInfoUI$1(GetQRCodeInfoUI paramGetQRCodeInfoUI) {}
  
  public final void a(e parame)
  {
    if (parame == null)
    {
      this.nRx.finish();
      return;
    }
    if ((g.DK()) && (!a.CW()))
    {
      GetQRCodeInfoUI.a(this.nRx, this.nRx.getIntent().getDataString());
      return;
    }
    b.eUR.q(new Intent(), this.nRx);
    this.nRx.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI.1
 * JD-Core Version:    0.7.0.1
 */