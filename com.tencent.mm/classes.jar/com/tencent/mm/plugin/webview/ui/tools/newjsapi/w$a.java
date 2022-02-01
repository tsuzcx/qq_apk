package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.model.OpenImKefuStartChattingResultReceiver.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenCustomerServiceChat$openCustomerServiceChat$1", "Lcom/tencent/mm/openim/model/OpenImKefuStartChattingResultReceiver$ReceiveResultCallback;", "hasShownConfirmPage", "", "onReceiveResult", "", "resultData", "Landroid/os/Bundle;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w$a
  implements OpenImKefuStartChattingResultReceiver.b
{
  private boolean rUh;
  
  private static final void dP(int paramInt, String paramString)
  {
    AppMethodBeat.i(297647);
    s.u(paramString, "$errMsg");
    w localw = w.Xnv;
    w.dO(paramInt, paramString);
    AppMethodBeat.o(297647);
  }
  
  public final void R(Bundle paramBundle)
  {
    AppMethodBeat.i(297664);
    if (paramBundle == null)
    {
      AppMethodBeat.o(297664);
      return;
    }
    int i = paramBundle.getInt("result_key_action", -1);
    if (i < 0)
    {
      AppMethodBeat.o(297664);
      return;
    }
    int j = paramBundle.getInt("result_key_err_code", -1);
    Object localObject = paramBundle.getString("result_key_err_msg");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    Log.i("MicroMsg.JsApiOpenCustomerServiceChat", "openCustomerServiceChat startKfConversation onReceiveResult action: " + i + ", errCode: " + j + ", errMsg: " + paramBundle);
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(297664);
      return;
      this.rUh = true;
      AppMethodBeat.o(297664);
      return;
      localObject = w.Xnv;
      w.dO(j, paramBundle);
      AppMethodBeat.o(297664);
      return;
      localObject = w.Xnv;
      w.dO(j, paramBundle);
      AppMethodBeat.o(297664);
      return;
      localObject = h.ahAA;
      paramBundle = new w.a..ExternalSyntheticLambda0(j, paramBundle);
      if (this.rUh) {}
      for (long l = 0L;; l = 600L)
      {
        ((i)localObject).o(paramBundle, l);
        AppMethodBeat.o(297664);
        return;
      }
      localObject = w.Xnv;
      w.dO(j, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.w.a
 * JD-Core Version:    0.7.0.1
 */