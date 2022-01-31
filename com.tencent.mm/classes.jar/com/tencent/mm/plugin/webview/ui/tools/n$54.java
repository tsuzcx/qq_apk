package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class n$54
  implements DialogInterface.OnCancelListener
{
  n$54(n paramn, Bundle paramBundle) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(154909);
    ab.i("MicroMsg.WebViewStubCallbackAIDLStub", "WebViewUITipsDialogCancel");
    try
    {
      this.cax.putInt("WebViewShare_BinderID", ((WebViewUI)n.a(this.vdr).get()).hashCode());
      ((WebViewUI)n.a(this.vdr).get()).igU.i(111, this.cax);
      AppMethodBeat.o(154909);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ab.e("MicroMsg.WebViewStubCallbackAIDLStub", "hide dialog err %s", new Object[] { paramDialogInterface.getMessage() });
      AppMethodBeat.o(154909);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.54
 * JD-Core Version:    0.7.0.1
 */