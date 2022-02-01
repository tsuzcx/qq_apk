package com.tencent.mm.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.t;
import java.util.LinkedList;

final class AppBrandNotifySettingsUI$5
  implements x.a
{
  AppBrandNotifySettingsUI$5(AppBrandNotifySettingsUI paramAppBrandNotifySettingsUI, LinkedList paramLinkedList) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(193581);
    ad.d("MicroMsg.AppBrandNotifySettingsUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      t.makeText(this.ISP, 2131761765, 0).show();
      AppMethodBeat.o(193581);
      return 0;
    }
    AppBrandNotifySettingsUI.bo(this.fSx);
    AppMethodBeat.o(193581);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.AppBrandNotifySettingsUI.5
 * JD-Core Version:    0.7.0.1
 */