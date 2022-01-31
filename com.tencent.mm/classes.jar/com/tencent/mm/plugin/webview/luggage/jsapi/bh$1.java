package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.os.Bundle;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.ipc.a;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

final class bh$1
  implements a
{
  bh$1(bh parambh, a.a parama) {}
  
  public final void o(Bundle paramBundle)
  {
    AppMethodBeat.i(6389);
    String str = paramBundle.getString("err_msg");
    paramBundle = paramBundle.getString("data");
    if (!bo.isNullOrNil(str))
    {
      this.njN.a(str, null);
      AppMethodBeat.o(6389);
      return;
    }
    try
    {
      paramBundle = new JSONObject(paramBundle);
      this.njN.a("", paramBundle);
      AppMethodBeat.o(6389);
      return;
    }
    catch (Exception paramBundle)
    {
      this.njN.a("", null);
      AppMethodBeat.o(6389);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bh.1
 * JD-Core Version:    0.7.0.1
 */