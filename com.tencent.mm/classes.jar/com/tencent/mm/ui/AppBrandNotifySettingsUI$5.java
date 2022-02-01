package com.tencent.mm.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import java.util.LinkedList;

final class AppBrandNotifySettingsUI$5
  implements aa.a
{
  AppBrandNotifySettingsUI$5(AppBrandNotifySettingsUI paramAppBrandNotifySettingsUI, LinkedList paramLinkedList) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(289281);
    Log.d("MicroMsg.AppBrandNotifySettingsUI", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      w.makeText(this.VQv, R.l.eOu, 0).show();
      AppMethodBeat.o(289281);
      return 0;
    }
    AppBrandNotifySettingsUI.cj(this.jjN);
    AppMethodBeat.o(289281);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.AppBrandNotifySettingsUI.5
 * JD-Core Version:    0.7.0.1
 */