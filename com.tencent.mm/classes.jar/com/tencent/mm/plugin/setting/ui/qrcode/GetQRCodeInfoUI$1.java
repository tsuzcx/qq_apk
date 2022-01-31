package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.n;

final class GetQRCodeInfoUI$1
  implements bk.a
{
  GetQRCodeInfoUI$1(GetQRCodeInfoUI paramGetQRCodeInfoUI) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(126902);
    if (parame == null)
    {
      this.qFv.finish();
      AppMethodBeat.o(126902);
      return;
    }
    if ((g.RG()) && (!a.QP()))
    {
      GetQRCodeInfoUI.a(this.qFv, this.qFv.getIntent().getDataString());
      AppMethodBeat.o(126902);
      return;
    }
    b.gmO.p(new Intent(), this.qFv);
    this.qFv.finish();
    AppMethodBeat.o(126902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.GetQRCodeInfoUI.1
 * JD-Core Version:    0.7.0.1
 */