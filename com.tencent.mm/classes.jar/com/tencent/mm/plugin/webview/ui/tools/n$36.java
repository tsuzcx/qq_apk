package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.a;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

final class n$36
  implements Runnable
{
  n$36(n paramn, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(7749);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()) || (((WebViewUI)n.a(this.vdr).get()).pOd == null))
    {
      AppMethodBeat.o(7749);
      return;
    }
    i locali = ((WebViewUI)n.a(this.vdr).get()).vfR;
    Object localObject = this.ihj;
    int i = this.hJy;
    int j = this.hJz;
    ab.i("MicroMsg.WebViewLongClickHelper", "onGetQRCodeResult");
    locali.igX = ((String)localObject);
    locali.vcx = i;
    locali.vcy = j;
    locali.ddI();
    if (bo.isNullOrNil(locali.igX))
    {
      ab.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName mResultOfImageUrl nil");
      AppMethodBeat.o(7749);
      return;
    }
    if (a.ba(locali.vcx, locali.igX))
    {
      ab.i("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName");
      localObject = new Bundle();
      try
      {
        ((Bundle)localObject).putString("wxa_result", locali.igX);
        ((Bundle)localObject).putInt("wxa_code_type", locali.vcx);
        ((Bundle)localObject).putInt("wxa_code_version", locali.vcy);
        locali.ddt().igU.a(110000, (Bundle)localObject, locali.ddt().hashCode());
        AppMethodBeat.o(7749);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        ab.w("MicroMsg.WebViewLongClickHelper", "processGetWXACodeNickName exp:%s", new Object[] { localRemoteException.getLocalizedMessage() });
      }
    }
    AppMethodBeat.o(7749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.36
 * JD-Core Version:    0.7.0.1
 */